package com.tencent.thumbplayer.core.datatransport.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemoteBridge;
import com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemoteCommonInfoListener;
import com.tencent.thumbplayer.core.datatransport.aidl.TPDataTransportMessageInfo;
import com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportCommonInfoListener;
import com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportNativeLibLoader;
import com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportOfflineTaskMgr;
import com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportPreloadTaskMgr;
import com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportServiceListener;
import com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportTaskMgr;
import com.tencent.thumbplayer.core.datatransport.api.TPDataTransportEnum;
import com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportMgrBridge;
import com.tencent.thumbplayer.core.datatransport.apiinner.TPDataTransportBizIdCreator;
import com.tencent.thumbplayer.core.datatransport.apiinner.TPDataTransportFactory;
import com.tencent.thumbplayer.core.datatransport.apiinner.TPDataTransportOfflineTaskMgrImpl;
import com.tencent.thumbplayer.core.datatransport.apiinner.TPDataTransportPreloadTaskMgrImpl;
import com.tencent.thumbplayer.core.datatransport.apiinner.TPDataTransportTaskMgrImpl;
import com.tencent.thumbplayer.core.datatransport.util.ITPDataTransportLog;
import com.tencent.thumbplayer.core.datatransport.util.TPDataTransportLifecycleObserver;
import com.tencent.thumbplayer.core.datatransport.util.TPDataTransportLogFactory;
import com.tencent.thumbplayer.core.downloadproxy.utils.TVKThreadUtil;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes26.dex */
public class TPDataTransportRemoteMgrWrapper implements ITPDataTransportMgrBridge {
    private final ConcurrentLinkedQueue<WeakReference<ITPDataTransportCommonInfoListener>> mCommonInfoListenerMgr;
    private Context mContext;
    private boolean mEnableMainProcessTemporary;
    private final ConcurrentHashMap<String, String> mGlobalConfigParam;
    private boolean mIsNativeInit;
    private boolean mIsServiceBind;
    private final TPDataTransportLifecycleObserver mLifecycleObserver;
    private final ITPDataTransportLog mLogger;
    private int mMaxServiceDisConnectedCount;
    private final ITPDataTransportOfflineTaskMgr mOfflineTaskMgr;
    private final ITPDataTransportPreloadTaskMgr mPreloadTaskMgr;
    private ITPDataTransportRemoteBridge mRemoteBridge;
    private final ServiceConnection mServiceConnection;
    private int mServiceDisconnectedCount;
    private final ConcurrentLinkedQueue<WeakReference<ITPDataTransportServiceListener>> mServiceListenerQueue;
    private final ITPDataTransportTaskMgr mTaskMgr;

    public TPDataTransportRemoteMgrWrapper() {
        ITPDataTransportLog logger = TPDataTransportLogFactory.getInstance().getLogger("TPDataTransportRemoteMgrWrapper");
        this.mLogger = logger;
        this.mLifecycleObserver = new TPDataTransportLifecycleObserver();
        this.mCommonInfoListenerMgr = new ConcurrentLinkedQueue<>();
        this.mServiceListenerQueue = new ConcurrentLinkedQueue<>();
        this.mTaskMgr = new TPDataTransportTaskMgrImpl(true);
        this.mPreloadTaskMgr = new TPDataTransportPreloadTaskMgrImpl(true);
        this.mOfflineTaskMgr = new TPDataTransportOfflineTaskMgrImpl(true);
        this.mContext = null;
        this.mIsNativeInit = false;
        this.mGlobalConfigParam = new ConcurrentHashMap<>();
        this.mIsServiceBind = false;
        this.mRemoteBridge = null;
        this.mServiceDisconnectedCount = 0;
        this.mMaxServiceDisConnectedCount = -1;
        this.mEnableMainProcessTemporary = false;
        this.mServiceConnection = new ServiceConnection() { // from class: com.tencent.thumbplayer.core.datatransport.service.TPDataTransportRemoteMgrWrapper.1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                TPDataTransportRemoteMgrWrapper.this.mRemoteBridge = ITPDataTransportRemoteBridge.Stub.asInterface(iBinder);
                if (TPDataTransportRemoteMgrWrapper.this.mRemoteBridge != null) {
                    TPDataTransportRemoteMgrWrapper.this.mLogger.i("on service connected!");
                    TPDataTransportRemoteMgrWrapper.this.mIsServiceBind = true;
                    TPDataTransportFactory.getInstance().setServiceConnected(true);
                    try {
                        TPDataTransportFactory.getInstance().getRemoteDataTransport().updateRemoteService(TPDataTransportRemoteMgrWrapper.this.mRemoteBridge.getRemoteDataTransport());
                        synchronized (TPDataTransportRemoteMgrWrapper.this.mServiceListenerQueue) {
                            Iterator it = TPDataTransportRemoteMgrWrapper.this.mServiceListenerQueue.iterator();
                            while (it.hasNext()) {
                                WeakReference weakReference = (WeakReference) it.next();
                                TPDataTransportRemoteMgrWrapper.this.mLogger.i("service connected callback");
                                if (weakReference.get() != null) {
                                    TPDataTransportRemoteMgrWrapper.this.mLogger.i("service connected callback2");
                                    ((ITPDataTransportServiceListener) weakReference.get()).onBind();
                                }
                            }
                        }
                        TVKThreadUtil.getScheduledExecutorServiceInstance().execute(new Runnable() { // from class: com.tencent.thumbplayer.core.datatransport.service.TPDataTransportRemoteMgrWrapper.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                TPDataTransportRemoteMgrWrapper.this.registerNativeInfoCallback();
                                try {
                                    TPDataTransportRemoteMgrWrapper.this.mRemoteBridge.initBizId(TPDataTransportBizIdCreator.getInstance().getDefaultBizId());
                                    synchronized (TPDataTransportRemoteMgrWrapper.this.mGlobalConfigParam) {
                                        for (Map.Entry entry : TPDataTransportRemoteMgrWrapper.this.mGlobalConfigParam.entrySet()) {
                                            TPDataTransportRemoteMgrWrapper.this.mRemoteBridge.setGlobalOptionalConfigParam((String) entry.getKey(), (String) entry.getValue());
                                        }
                                        TPDataTransportRemoteMgrWrapper.this.mRemoteBridge.setGlobalOptionalConfigParam(TPDataTransportEnum.GLOBAL_OPTIONAL_CONFIG_PARAM_INT_APP_STATE, String.valueOf(5));
                                        TPDataTransportRemoteMgrWrapper.this.mGlobalConfigParam.clear();
                                    }
                                } catch (RemoteException e16) {
                                    TPDataTransportRemoteMgrWrapper.this.mLogger.e("onServiceConnected failed, init bizId error:" + e16);
                                }
                            }
                        });
                    } catch (Throwable th5) {
                        TPDataTransportRemoteMgrWrapper.this.mLogger.e("onServiceConnected failed, error:" + th5);
                    }
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                TPDataTransportFactory.getInstance().setServiceConnected(false);
                TPDataTransportRemoteMgrWrapper.access$608(TPDataTransportRemoteMgrWrapper.this);
                TPDataTransportRemoteMgrWrapper.this.mIsServiceBind = false;
                TPDataTransportRemoteMgrWrapper.this.mRemoteBridge = null;
                TPDataTransportRemoteMgrWrapper.this.mIsNativeInit = false;
                TPDataTransportFactory.getInstance().getRemoteDataTransport().updateRemoteService(null);
                synchronized (TPDataTransportRemoteMgrWrapper.this.mServiceListenerQueue) {
                    Iterator it = TPDataTransportRemoteMgrWrapper.this.mServiceListenerQueue.iterator();
                    while (it.hasNext()) {
                        WeakReference weakReference = (WeakReference) it.next();
                        if (weakReference.get() != null) {
                            ((ITPDataTransportServiceListener) weakReference.get()).onUnBind();
                        }
                    }
                }
                TPDataTransportRemoteMgrWrapper.this.mLogger.i("on service disconnected, count:" + TPDataTransportRemoteMgrWrapper.this.mServiceDisconnectedCount);
                TPDataTransportRemoteMgrWrapper.this.startBindingService();
            }
        };
        logger.i("construct start");
    }

    static /* synthetic */ int access$608(TPDataTransportRemoteMgrWrapper tPDataTransportRemoteMgrWrapper) {
        int i3 = tPDataTransportRemoteMgrWrapper.mServiceDisconnectedCount;
        tPDataTransportRemoteMgrWrapper.mServiceDisconnectedCount = i3 + 1;
        return i3;
    }

    private boolean isServiceNotBind() {
        if (this.mIsServiceBind && this.mRemoteBridge != null) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerNativeInfoCallback() {
        if (isServiceNotBind()) {
            this.mLogger.e("registerNativeInfoCallback failed, service is not bind!");
            return;
        }
        try {
            this.mRemoteBridge.registerCommonInfoListener(new ITPDataTransportRemoteCommonInfoListener.Stub() { // from class: com.tencent.thumbplayer.core.datatransport.service.TPDataTransportRemoteMgrWrapper.4
                @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemoteCommonInfoListener
                public void onCommonInfoUpdate(int i3, TPDataTransportMessageInfo tPDataTransportMessageInfo) {
                    if (i3 == 0) {
                        TPDataTransportRemoteMgrWrapper.this.mLogger.i("on native config update:" + tPDataTransportMessageInfo.obj1);
                        TPDataTransportServiceConfig.parseNativeConfig((String) tPDataTransportMessageInfo.obj1);
                        TPDataTransportRemoteMgrWrapper.this.mMaxServiceDisConnectedCount = TPDataTransportServiceConfig.getMaxServiceDisconnectedCount();
                        TPDataTransportRemoteMgrWrapper.this.mEnableMainProcessTemporary = TPDataTransportServiceConfig.enableMainProcessTemporary();
                        return;
                    }
                    synchronized (TPDataTransportRemoteMgrWrapper.this.mCommonInfoListenerMgr) {
                        Iterator it = TPDataTransportRemoteMgrWrapper.this.mCommonInfoListenerMgr.iterator();
                        while (it.hasNext()) {
                            WeakReference weakReference = (WeakReference) it.next();
                            if (weakReference.get() != null) {
                                ((ITPDataTransportCommonInfoListener) weakReference.get()).onCommonInfoUpdate(i3, tPDataTransportMessageInfo);
                            }
                        }
                    }
                }
            });
        } catch (Throwable th5) {
            this.mLogger.e("registerNativeInfoCallback failed, error:" + th5);
        }
    }

    private boolean useMainProcessTemporarily() {
        int i3 = this.mMaxServiceDisConnectedCount;
        if ((i3 > 0 && this.mServiceDisconnectedCount >= i3) || this.mEnableMainProcessTemporary) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportMgrBridge
    public int checkFileCacheStatus(int i3, String str, int i16) {
        if (isServiceNotBind()) {
            this.mLogger.e("checkFileCacheStatus failed, service is not bind!");
            return -1;
        }
        try {
            return this.mRemoteBridge.checkFileCacheStatus(i3, str, i16);
        } catch (Throwable th5) {
            this.mLogger.e("checkFileCacheStatus failed, error:" + th5);
            return -1;
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportMgrBridge
    public boolean clearCache(int i3, String str, int i16) {
        if (isServiceNotBind()) {
            this.mLogger.e("clearCache failed, service is not bind!");
            return false;
        }
        try {
            return this.mRemoteBridge.clearCache(i3, str, i16);
        } catch (Throwable th5) {
            this.mLogger.e("clearCache failed, error:" + th5);
            return false;
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportMgrBridge
    public boolean clearRangeCache(int i3, String str, int i16, int i17) {
        if (isServiceNotBind()) {
            this.mLogger.e("clearRangeCache failed, service is not bind!");
            return false;
        }
        try {
            return this.mRemoteBridge.clearRangeCache(i3, str, i16, i17);
        } catch (Throwable th5) {
            this.mLogger.e("clearRangeCache failed, error:" + th5);
            return false;
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportMgrBridge
    public String getBizAccessibleNativeInfo(int i3, int i16) {
        if (isServiceNotBind()) {
            this.mLogger.e("getBizAccessibleNativeInfo failed, service is not bind!");
            return "";
        }
        try {
            this.mRemoteBridge.getBizAccessibleNativeInfo(i3, i16);
        } catch (Throwable th5) {
            this.mLogger.e("getBizAccessibleNativeInfo failed, error:" + th5);
        }
        return "";
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportMgrBridge
    public long getFileCacheSize(int i3, String str) {
        if (isServiceNotBind()) {
            this.mLogger.e("checkFileCacheStatus failed, service is not bind!");
            return 0L;
        }
        try {
            return this.mRemoteBridge.getFileCacheSize(i3, str);
        } catch (Throwable th5) {
            this.mLogger.e("checkFileCacheStatus failed, error:" + th5);
            return 0L;
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportMgrBridge
    public String getGlobalAccessibleNativeInfo(int i3) {
        if (isServiceNotBind()) {
            this.mLogger.e("getGlobalAccessibleNativeInfo failed, service is not bind!");
            if (!useMainProcessTemporarily()) {
                return "";
            }
            return TPDataTransportFactory.getInstance().getDefaultDataTransportMgr().getGlobalAccessibleNativeInfo(i3);
        }
        try {
            return this.mRemoteBridge.getGlobalAccessibleNativeInfo(i3);
        } catch (Throwable th5) {
            this.mLogger.e("getGlobalAccessibleNativeInfo failed, error:" + th5);
            return "";
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportMgrBridge
    public String getNativeLibVersion() {
        if (isServiceNotBind()) {
            this.mLogger.e("getNativeLibVersion failed, service is not bind!");
            return "";
        }
        try {
            return this.mRemoteBridge.getNativeVersion();
        } catch (Throwable th5) {
            this.mLogger.e("getNativeLibVersion failed, error:" + th5);
            return "";
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportMgrBridge
    public ITPDataTransportOfflineTaskMgr getOfflineTaskMgr() {
        if (isServiceNotBind()) {
            this.mLogger.e("getOfflineTaskMgr failed, service is not bind!");
            return null;
        }
        return this.mOfflineTaskMgr;
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportMgrBridge
    public ITPDataTransportPreloadTaskMgr getPreloadTaskMgr() {
        if (isServiceNotBind()) {
            this.mLogger.e("getPreloadTaskMgr failed, service is not bind!");
            return null;
        }
        return this.mPreloadTaskMgr;
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportMgrBridge
    public ITPDataTransportTaskMgr getTaskMgr() {
        if (isServiceNotBind()) {
            this.mLogger.e("getTaskMgr failed, service is not bind!");
            if (useMainProcessTemporarily()) {
                ITPDataTransportMgrBridge defaultDataTransportMgr = TPDataTransportFactory.getInstance().getDefaultDataTransportMgr();
                defaultDataTransportMgr.setGlobalOptionalConfigParam(TPDataTransportEnum.GLOBAL_OPTIONAL_CONFIG_PARAM_LIMIT_MODE, "1");
                synchronized (this.mGlobalConfigParam) {
                    for (Map.Entry<String, String> entry : this.mGlobalConfigParam.entrySet()) {
                        defaultDataTransportMgr.setGlobalOptionalConfigParam(entry.getKey(), entry.getValue());
                    }
                }
                defaultDataTransportMgr.init(TPDataTransportFactory.getInstance().getContext());
                return defaultDataTransportMgr.getTaskMgr();
            }
            return this.mTaskMgr;
        }
        return this.mTaskMgr;
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportMgrBridge
    public boolean init(Context context) {
        this.mLogger.i("init stack trace: ");
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            this.mLogger.i(stackTraceElement.toString());
        }
        this.mContext = context;
        this.mMaxServiceDisConnectedCount = TPDataTransportServiceConfig.getMaxServiceDisconnectedCount();
        this.mEnableMainProcessTemporary = TPDataTransportServiceConfig.enableMainProcessTemporary();
        this.mLogger.i("config load, max service disconnected count: " + this.mMaxServiceDisConnectedCount + ", enable main process temporary: " + this.mEnableMainProcessTemporary);
        TVKThreadUtil.postRunnableOnMainThread(new Runnable() { // from class: com.tencent.thumbplayer.core.datatransport.service.TPDataTransportRemoteMgrWrapper.2
            @Override // java.lang.Runnable
            public void run() {
                ProcessLifecycleOwner.get().getLifecycle().addObserver(TPDataTransportRemoteMgrWrapper.this.mLifecycleObserver);
                TPDataTransportRemoteMgrWrapper.this.mLogger.i("register service lifecycle observer");
            }
        });
        return true;
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportMgrBridge
    public boolean isNativeInit() {
        if (isServiceNotBind()) {
            this.mLogger.e("isNativeInit failed, service is not bind, enable main process temporary: " + this.mEnableMainProcessTemporary);
            return this.mEnableMainProcessTemporary;
        }
        try {
            if (!this.mIsNativeInit) {
                this.mIsNativeInit = this.mRemoteBridge.isNativeInit();
            }
            return this.mIsNativeInit;
        } catch (Throwable th5) {
            this.mLogger.e("isNativeInit failed, error:" + th5);
            return false;
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportMgrBridge
    public int registerBizId(@NonNull String str) {
        if (isServiceNotBind()) {
            this.mLogger.e("registerBizId failed, service is not bind!");
            return -1;
        }
        try {
            return this.mRemoteBridge.registerBizId(str);
        } catch (Throwable th5) {
            this.mLogger.e("registerBizId failed, error:" + th5);
            return -1;
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportMgrBridge
    public void registerCommonInfoListener(ITPDataTransportCommonInfoListener iTPDataTransportCommonInfoListener) {
        if (iTPDataTransportCommonInfoListener == null) {
            return;
        }
        synchronized (this.mCommonInfoListenerMgr) {
            Iterator<WeakReference<ITPDataTransportCommonInfoListener>> it = this.mCommonInfoListenerMgr.iterator();
            boolean z16 = false;
            while (it.hasNext()) {
                if (iTPDataTransportCommonInfoListener.equals(it.next().get())) {
                    z16 = true;
                }
            }
            if (!z16) {
                this.mCommonInfoListenerMgr.add(new WeakReference<>(iTPDataTransportCommonInfoListener));
            }
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportMgrBridge
    public void registerServiceListener(ITPDataTransportServiceListener iTPDataTransportServiceListener) {
        if (iTPDataTransportServiceListener == null) {
            return;
        }
        synchronized (this.mServiceListenerQueue) {
            Iterator<WeakReference<ITPDataTransportServiceListener>> it = this.mServiceListenerQueue.iterator();
            boolean z16 = false;
            while (it.hasNext()) {
                if (Objects.equals(it.next().get(), iTPDataTransportServiceListener)) {
                    z16 = true;
                }
            }
            if (!z16) {
                this.mLogger.i("add service listener");
                this.mServiceListenerQueue.add(new WeakReference<>(iTPDataTransportServiceListener));
            }
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportMgrBridge
    public boolean setBizOptionalConfigParam(int i3, String str, String str2) {
        if (isServiceNotBind()) {
            this.mLogger.e("setBizOptionalConfigParam failed, service is not bind!");
            return false;
        }
        try {
            return this.mRemoteBridge.setBizOptionalConfigParam(i3, str, str2);
        } catch (Throwable th5) {
            this.mLogger.e("setBizOptionalConfigParam failed, error:" + th5);
            return false;
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportMgrBridge
    public boolean setGlobalOptionalConfigParam(final String str, final String str2) {
        if (isServiceNotBind()) {
            synchronized (this.mGlobalConfigParam) {
                this.mGlobalConfigParam.put(str, str2);
            }
            this.mLogger.e("setGlobalOptionalConfigParam failed, service is not bind, key:" + str + ", value:" + str2);
            if (useMainProcessTemporarily()) {
                TPDataTransportFactory.getInstance().getDefaultDataTransportMgr().setGlobalOptionalConfigParam(str, str2);
                return true;
            }
            return false;
        }
        TVKThreadUtil.getScheduledExecutorServiceInstance().execute(new Runnable() { // from class: com.tencent.thumbplayer.core.datatransport.service.TPDataTransportRemoteMgrWrapper.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    TPDataTransportRemoteMgrWrapper.this.mRemoteBridge.setGlobalOptionalConfigParam(str, str2);
                } catch (Throwable th5) {
                    TPDataTransportRemoteMgrWrapper.this.mLogger.e("setGlobalOptionalConfigParam failed, error:" + th5);
                }
            }
        });
        return true;
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportMgrBridge
    public void startBindingService() {
        if (this.mContext == null) {
            this.mLogger.e("startBindingService failed, context is null!");
            return;
        }
        this.mLogger.i("start binding service!");
        if (!this.mContext.bindService(new Intent(this.mContext, (Class<?>) TPDataTransportRemoteService.class), this.mServiceConnection, 9)) {
            this.mLogger.i("start binding service failed!");
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportMgrBridge
    public void unregisterBizId(int i3) {
        if (isServiceNotBind()) {
            this.mLogger.e("unregisterBizId failed, service is not bind!");
            return;
        }
        try {
            this.mRemoteBridge.unregisterBizId(i3);
        } catch (Throwable th5) {
            this.mLogger.e("unregisterBizId failed, error:" + th5);
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportMgrBridge
    public void unregisterCommonInfoListener(ITPDataTransportCommonInfoListener iTPDataTransportCommonInfoListener) {
        if (iTPDataTransportCommonInfoListener == null) {
            return;
        }
        synchronized (this.mCommonInfoListenerMgr) {
            Iterator<WeakReference<ITPDataTransportCommonInfoListener>> it = this.mCommonInfoListenerMgr.iterator();
            while (it.hasNext()) {
                if (iTPDataTransportCommonInfoListener.equals(it.next().get())) {
                    it.remove();
                }
            }
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportMgrBridge
    public void unregisterServiceListener(ITPDataTransportServiceListener iTPDataTransportServiceListener) {
        if (iTPDataTransportServiceListener == null) {
            return;
        }
        synchronized (this.mServiceListenerQueue) {
            Iterator<WeakReference<ITPDataTransportServiceListener>> it = this.mServiceListenerQueue.iterator();
            while (it.hasNext()) {
                if (Objects.equals(it.next().get(), iTPDataTransportServiceListener)) {
                    it.remove();
                }
            }
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportMgrBridge
    public int registerBizId(int i3, String str) {
        if (isServiceNotBind()) {
            this.mLogger.e("registerBizId failed, service is not bind!");
            return -1;
        }
        try {
            return this.mRemoteBridge.registerAssignedBizId(i3, str);
        } catch (Throwable th5) {
            this.mLogger.e("registerBizId2 failed, error:" + th5);
            return -1;
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportMgrBridge
    public void setThirdNativeLibLoader(ITPDataTransportNativeLibLoader iTPDataTransportNativeLibLoader) {
    }
}
