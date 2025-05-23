package com.tencent.thumbplayer.core.datatransport.apiinner;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.tencent.thumbplayer.core.datatransport.aidl.TPDataTransportMessageInfo;
import com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportCommonInfoListener;
import com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportNativeLibLoader;
import com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportOfflineTaskMgr;
import com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportPreloadTaskMgr;
import com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportServiceListener;
import com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportTaskMgr;
import com.tencent.thumbplayer.core.datatransport.api.TPDataTransportEnum;
import com.tencent.thumbplayer.core.datatransport.service.TPDataTransportServiceConfig;
import com.tencent.thumbplayer.core.datatransport.util.ITPDataTransportLog;
import com.tencent.thumbplayer.core.datatransport.util.TPDataTransportLifecycleObserver;
import com.tencent.thumbplayer.core.datatransport.util.TPDataTransportLogFactory;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyNativeLibLoader;
import com.tencent.thumbplayer.core.downloadproxy.jni.TPDownloadProxyNative;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyUtils;
import com.tencent.thumbplayer.core.downloadproxy.utils.TVKThreadUtil;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes26.dex */
public class TPDataTransportMgrWrapper implements ITPDataTransportMgrBridge, ITPDataTransportCommonInfoListener {
    private final ConcurrentLinkedQueue<WeakReference<ITPDataTransportCommonInfoListener>> mCommonInfoListenerMgr;
    private final ConcurrentHashMap<String, String> mGlobalOptionalConfigParam;
    private boolean mIsInit;
    private final TPDataTransportLifecycleObserver mLifecycleObserver;
    private final ITPDataTransportLog mLogger;
    private final ITPDataTransportOfflineTaskMgr mOfflineTaskMgr;
    private final ITPDataTransportPreloadTaskMgr mPreloadTaskMgr;
    private final ITPDataTransportTaskMgr mTaskMgr;

    public TPDataTransportMgrWrapper() {
        ITPDataTransportLog logger = TPDataTransportLogFactory.getInstance().getLogger("TPDataTransportMgrWrapper");
        this.mLogger = logger;
        this.mLifecycleObserver = new TPDataTransportLifecycleObserver();
        this.mCommonInfoListenerMgr = new ConcurrentLinkedQueue<>();
        this.mTaskMgr = new TPDataTransportTaskMgrImpl(false);
        this.mPreloadTaskMgr = new TPDataTransportPreloadTaskMgrImpl(false);
        this.mOfflineTaskMgr = new TPDataTransportOfflineTaskMgrImpl(false);
        this.mIsInit = false;
        this.mGlobalOptionalConfigParam = new ConcurrentHashMap<>();
        logger.i("construct start");
        TPDataTransportTaskListenerMgr.getInstance().setCommonInfoListener(this);
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportMgrBridge
    public int checkFileCacheStatus(int i3, String str, int i16) {
        if (!isNativeInit()) {
            this.mLogger.e("checkFileCacheStatus failed, native is not loaded!");
            return -1;
        }
        try {
            return TPDownloadProxyNative.getInstance().checkResourceStatus(TPDataTransportBizIdCreator.getInstance().getBizDataDir(i3), str, i16);
        } catch (Throwable th5) {
            this.mLogger.e("checkFileCacheStatus failed, error:" + th5);
            return 0;
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportMgrBridge
    public boolean clearCache(int i3, String str, int i16) {
        if (!isNativeInit()) {
            this.mLogger.e("clearCache failed, native not loaded!");
            return false;
        }
        try {
            if (TPDownloadProxyNative.getInstance().clearCache(TPDataTransportBizIdCreator.getInstance().getBizDataDir(i3), str, i16) != 0) {
                return false;
            }
            return true;
        } catch (Throwable th5) {
            this.mLogger.e("clearCache failed, error:" + th5);
            return false;
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportMgrBridge
    public boolean clearRangeCache(int i3, String str, int i16, int i17) {
        if (!isNativeInit()) {
            this.mLogger.e("clearRangeCache failed, native not loaded!");
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            this.mLogger.e("clearRangeCache failed, file id is empty!");
            return false;
        }
        try {
            if (TPDownloadProxyNative.getInstance().clearRangeCache(TPDataTransportBizIdCreator.getInstance().getBizDataDir(i3), str, i16, i17) != 0) {
                return false;
            }
            return true;
        } catch (Throwable th5) {
            this.mLogger.e("clearRangeCache failed, error:" + th5);
            return false;
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportMgrBridge
    public String getBizAccessibleNativeInfo(int i3, int i16) {
        if (!isNativeInit()) {
            this.mLogger.e("getBizAccessibleNativeInfo failed, native not loaded!");
            return "";
        }
        try {
            return TPDLProxyUtils.byteArrayToString(TPDownloadProxyNative.getInstance().getBizAccessibleNativeInfo(i3, i16));
        } catch (Throwable th5) {
            this.mLogger.e("getBizAccessibleNativeInfo failed, error:" + th5);
            return "";
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportMgrBridge
    public long getFileCacheSize(int i3, String str) {
        if (!isNativeInit()) {
            this.mLogger.e("getFileCacheSize failed, native is not loaded!");
            return -1L;
        }
        try {
            return TPDownloadProxyNative.getInstance().getResourceSize(TPDataTransportBizIdCreator.getInstance().getBizDataDir(i3), str);
        } catch (Throwable th5) {
            this.mLogger.e("getFileCacheSize failed, error:" + th5);
            return 0L;
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportMgrBridge
    public String getGlobalAccessibleNativeInfo(int i3) {
        if (!isNativeInit()) {
            this.mLogger.e("getGlobalAccessibleNativeInfo failed, native not loaded!");
            return "";
        }
        try {
            return TPDLProxyUtils.byteArrayToString(TPDownloadProxyNative.getInstance().getGlobalAccessibleNativeInfo(i3));
        } catch (Throwable th5) {
            this.mLogger.e("getGlobalAccessibleNativeInfo failed, error:" + th5);
            return "";
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportMgrBridge
    public String getNativeLibVersion() {
        if (!isNativeInit()) {
            this.mLogger.e("getNativeLibVersion failed, native not loaded!");
            return "";
        }
        try {
            return TPDownloadProxyNative.getInstance().getNativeVersion();
        } catch (Throwable th5) {
            this.mLogger.e("getNativeLibVersion failed, error:" + th5);
            return "";
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportMgrBridge
    public ITPDataTransportOfflineTaskMgr getOfflineTaskMgr() {
        return this.mOfflineTaskMgr;
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportMgrBridge
    public ITPDataTransportPreloadTaskMgr getPreloadTaskMgr() {
        return this.mPreloadTaskMgr;
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportMgrBridge
    public ITPDataTransportTaskMgr getTaskMgr() {
        return this.mTaskMgr;
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportMgrBridge
    public boolean init(Context context) {
        this.mLogger.i("init stack trace: ");
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            this.mLogger.i(stackTraceElement.toString());
        }
        synchronized (TPDataTransportMgrWrapper.class) {
            if (this.mIsInit) {
                return true;
            }
            TPDownloadProxyNative.getInstance().setAppContext(context);
            TVKThreadUtil.postRunnableOnMainThread(new Runnable() { // from class: com.tencent.thumbplayer.core.datatransport.apiinner.TPDataTransportMgrWrapper.2
                @Override // java.lang.Runnable
                public void run() {
                    ProcessLifecycleOwner.get().getLifecycle().addObserver(TPDataTransportMgrWrapper.this.mLifecycleObserver);
                    TPDataTransportMgrWrapper.this.mLogger.i("register lifecycle observer");
                }
            });
            if (this.mIsInit) {
                return false;
            }
            if (TPDownloadProxyNative.getInstance().loadLibrary()) {
                for (String str : this.mGlobalOptionalConfigParam.keySet()) {
                    TPDownloadProxyNative.getInstance().setGlobalOptionalConfigParam(str, this.mGlobalOptionalConfigParam.get(str));
                }
                TPDownloadProxyNative.getInstance().initBizId(TPDataTransportBizIdCreator.getInstance().getDefaultBizId());
                this.mIsInit = true;
            }
            return this.mIsInit;
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportMgrBridge
    public boolean isNativeInit() {
        if (this.mIsInit && TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportCommonInfoListener
    public void onCommonInfoUpdate(int i3, TPDataTransportMessageInfo tPDataTransportMessageInfo) {
        synchronized (this.mCommonInfoListenerMgr) {
            if (i3 == 0) {
                this.mLogger.i("on native config update:" + tPDataTransportMessageInfo.obj1);
                TPDataTransportServiceConfig.parseNativeConfig((String) tPDataTransportMessageInfo.obj1);
            } else {
                Iterator<WeakReference<ITPDataTransportCommonInfoListener>> it = this.mCommonInfoListenerMgr.iterator();
                while (it.hasNext()) {
                    WeakReference<ITPDataTransportCommonInfoListener> next = it.next();
                    if (next.get() != null) {
                        next.get().onCommonInfoUpdate(i3, tPDataTransportMessageInfo);
                    }
                }
            }
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportMgrBridge
    public int registerBizId(@NonNull String str) {
        if (!isNativeInit()) {
            this.mLogger.e("registerBizId failed, native not loaded!");
            return -1;
        }
        int registerBizId = TPDataTransportBizIdCreator.getInstance().registerBizId(str);
        this.mLogger.i("register bizId:" + registerBizId + ", dataDir:" + str);
        if (registerBizId <= 0 || TPDownloadProxyNative.getInstance().initBizId(registerBizId) != 0) {
            return -1;
        }
        this.mLogger.i("register bizId:" + registerBizId + ", dataDir:" + str + ", init succeed!");
        return registerBizId;
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
    public boolean setBizOptionalConfigParam(int i3, String str, String str2) {
        if (!isNativeInit()) {
            this.mLogger.e("setBizOptionalConfigParam failed, native not loaded!");
            return false;
        }
        try {
            if (TPDataTransportEnum.BIZ_OPTIONAL_CONFIG_PARAM_LONG_MAX_CACHE_SIZE_MB.equals(str)) {
                TPDownloadProxyNative.getInstance().setMaxStorageSizeMB(i3, Long.valueOf(str2, 10).longValue());
                return true;
            }
            TPDownloadProxyNative.getInstance().setBizOptionalConfigParam(i3, str, str2);
            return true;
        } catch (Throwable th5) {
            this.mLogger.e("setBizOptionalConfigParam failed, error:" + th5);
            return false;
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportMgrBridge
    public boolean setGlobalOptionalConfigParam(String str, String str2) {
        if (str.equals("device_model")) {
            TPDLProxyUtils.setDeviceModel(str2);
        }
        if (!isNativeInit()) {
            this.mGlobalOptionalConfigParam.put(str, str2);
            this.mLogger.e("setGlobalOptionalConfigParam failed, native not loaded, key:" + str + ", value:" + str2);
            return false;
        }
        try {
            this.mLogger.i("setGlobalOptionalConfigParam, key:" + str + ", value:" + str2);
            TPDownloadProxyNative.getInstance().setGlobalOptionalConfigParam(str, str2);
        } catch (Throwable th5) {
            this.mLogger.e("setGlobalOptionalConfigParam failed, error:" + th5);
        }
        return false;
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportMgrBridge
    public void setThirdNativeLibLoader(final ITPDataTransportNativeLibLoader iTPDataTransportNativeLibLoader) {
        TPDownloadProxyNative.getInstance().setLibLoader(new ITPDLProxyNativeLibLoader() { // from class: com.tencent.thumbplayer.core.datatransport.apiinner.TPDataTransportMgrWrapper.1
            @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyNativeLibLoader
            public boolean loadLib(String str, String str2) {
                return iTPDataTransportNativeLibLoader.loadLib(str);
            }
        });
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportMgrBridge
    public void unregisterBizId(int i3) {
        TPDataTransportBizIdCreator.getInstance().unregisterBizId(i3);
        try {
            TPDownloadProxyNative.getInstance().unregisterBizId(i3);
        } catch (Throwable th5) {
            this.mLogger.i("unregister bizId:" + i3 + " failed, error:" + th5);
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
    public int registerBizId(int i3, String str) {
        if (!isNativeInit()) {
            this.mLogger.e("getNativeLibVersion failed, native not loaded!");
            return -1;
        }
        int registerBizId = TPDataTransportBizIdCreator.getInstance().registerBizId(i3, str);
        this.mLogger.i("register bizId:" + registerBizId + ", dataDir:" + str);
        if (registerBizId <= 0 || TPDownloadProxyNative.getInstance().initBizId(registerBizId) != 0) {
            return -1;
        }
        this.mLogger.i("register bizId:" + registerBizId + ", dataDir:" + str + ", init succeed!");
        return registerBizId;
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportMgrBridge
    public void startBindingService() {
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportMgrBridge
    public void registerServiceListener(ITPDataTransportServiceListener iTPDataTransportServiceListener) {
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportMgrBridge
    public void unregisterServiceListener(ITPDataTransportServiceListener iTPDataTransportServiceListener) {
    }
}
