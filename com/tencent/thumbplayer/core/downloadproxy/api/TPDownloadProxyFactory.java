package com.tencent.thumbplayer.core.downloadproxy.api;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyInfoCallbackAidl;
import com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadProxyFactoryAidl;
import com.tencent.thumbplayer.core.downloadproxy.apiinner.TPListenerManager;
import com.tencent.thumbplayer.core.downloadproxy.client.TPDownloadProxyClient;
import com.tencent.thumbplayer.core.downloadproxy.jni.TPDownloadProxyNative;
import com.tencent.thumbplayer.core.downloadproxy.service.TPDownloadProxyService;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyLog;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes26.dex */
public class TPDownloadProxyFactory {
    private static final String CONFIG_DEVICE_BLACKLIST = "device_blacklist";
    private static final String CONFIG_ENABLE_ALL_DEVICE_SWITCH_MAIN_PROCESS = "enable_all_device_switch_main_process";
    private static final String CONFIG_MAX_ALL_DEVICE_DISCONNECTED_COUNT = "max_all_device_process_disconnected_count";
    private static final String CONFIG_MAX_MATCH_DEVICE_DISCONNECTED_COUNT = "max_match_device_process_disconnected_count";
    private static final String FILE_NAME = "TPDownloadProxyFactory";
    private static TPDownloadProxyFactoryAidl downloadProxyFactoryAidl;
    private static final Object mMapObject = new Object();
    private static final HashMap<Integer, ITPDownloadProxy> mvTPDownloadProxyMap = new HashMap<>();
    private static final HashMap<Integer, Boolean> mvTPDownloadProxyMapState = new HashMap<>();
    private static final HashMap<Integer, TPDownloadProxyClient> mvTPDownloadProxyClientMap = new HashMap<>();
    private static final HashMap<Integer, ITPDownloadProxy> mvTPDownloadProxyProcessAdapterMap = new HashMap<>();
    private static final List<WeakReference<ITPServiceListener>> mServiceListener = new ArrayList();
    private static boolean mUseService = false;
    private static boolean mCanUseAIDL = false;
    private static boolean mIsReadyForDownload = false;
    private static boolean mAddAboveClientForBindService = false;
    private static boolean mIsDeviceInBlacklist = false;
    private static int mMaxServiceDisconnectedCount = 1;
    private static int mServiceDisconnectedCount = 0;
    private static TPDLProxyBindServiceCallback mCallback = null;
    private static final ServiceConnection mConnection = new ServiceConnection() { // from class: com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyFactory.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            TPDownloadProxyFactoryAidl unused = TPDownloadProxyFactory.downloadProxyFactoryAidl = TPDownloadProxyFactoryAidl.Stub.asInterface(iBinder);
            try {
                for (Map.Entry entry : TPDownloadProxyFactory.mvTPDownloadProxyClientMap.entrySet()) {
                    ((TPDownloadProxyClient) entry.getValue()).updateAidl(TPDownloadProxyFactory.downloadProxyFactoryAidl.getTPDownloadProxy(((Integer) entry.getKey()).intValue()));
                }
            } catch (Throwable th5) {
                TPDLProxyLog.i(TPDownloadProxyFactory.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onServiceConnected failed, error:" + th5);
            }
            TPDLProxyLog.i(TPDownloadProxyFactory.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "on service connected!");
            if (TPDownloadProxyFactory.downloadProxyFactoryAidl == null) {
                TPDLProxyLog.i(TPDownloadProxyFactory.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "on service connected, aidl is null!");
                return;
            }
            TPDLProxyLog.i(TPDownloadProxyFactory.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "on service connected, aidl not null!");
            TPDownloadProxyFactory.setCanUseAIDL(true);
            TPDownloadProxyFactory.registerProxyInfoCallback(null);
            if (TPDownloadProxyFactory.mCallback != null) {
                TPDownloadProxyFactory.mCallback.onBindSuccess();
            }
            synchronized (TPDownloadProxyFactory.mServiceListener) {
                for (int i3 = 0; i3 < TPDownloadProxyFactory.mServiceListener.size(); i3++) {
                    ((ITPServiceListener) ((WeakReference) TPDownloadProxyFactory.mServiceListener.get(i3)).get()).OnServiceConnected();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            TPDLProxyLog.i(TPDownloadProxyFactory.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "on service disconnected, count:" + TPDownloadProxyFactory.mServiceDisconnectedCount);
            TPDownloadProxyFactoryAidl unused = TPDownloadProxyFactory.downloadProxyFactoryAidl = null;
            TPDownloadProxyFactory.access$508();
            TPDownloadProxyFactory.setCanUseAIDL(false);
            TPDownloadProxyFactory.ensurePlayManagerService(TPDownloadProxyFactory.mCallback);
            synchronized (TPDownloadProxyFactory.mServiceListener) {
                for (int i3 = 0; i3 < TPDownloadProxyFactory.mServiceListener.size(); i3++) {
                    ((ITPServiceListener) ((WeakReference) TPDownloadProxyFactory.mServiceListener.get(i3)).get()).OnServiceDisconnected();
                }
            }
        }
    };

    static /* synthetic */ int access$508() {
        int i3 = mServiceDisconnectedCount;
        mServiceDisconnectedCount = i3 + 1;
        return i3;
    }

    public static boolean addServiceListener(ITPServiceListener iTPServiceListener) {
        if (iTPServiceListener == null) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "serviceListener is null");
            return false;
        }
        List<WeakReference<ITPServiceListener>> list = mServiceListener;
        synchronized (list) {
            list.add(new WeakReference<>(iTPServiceListener));
        }
        return true;
    }

    public static synchronized boolean canUseService() {
        synchronized (TPDownloadProxyFactory.class) {
            if (!mUseService) {
                return true;
            }
            if (!mCanUseAIDL) {
                return false;
            }
            TPDownloadProxyFactoryAidl tPDownloadProxyFactoryAidl = downloadProxyFactoryAidl;
            if (tPDownloadProxyFactoryAidl != null) {
                try {
                    tPDownloadProxyFactoryAidl.isReadyForPlay();
                    return true;
                } catch (Throwable th5) {
                    TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "canUseService failed, error:" + th5);
                }
            }
            return false;
        }
    }

    public static void deInitAllProxy() {
        synchronized (mMapObject) {
            for (Map.Entry<Integer, ITPDownloadProxy> entry : mvTPDownloadProxyMap.entrySet()) {
                entry.getValue().deinit();
                mvTPDownloadProxyMapState.put(entry.getKey(), Boolean.FALSE);
            }
        }
    }

    public static boolean ensurePlayManagerService(TPDLProxyBindServiceCallback tPDLProxyBindServiceCallback) {
        boolean bindService;
        Context context = TPDownloadProxyHelper.getContext();
        if (context == null) {
            TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "ensurePlayManagerService get context null!");
            return false;
        }
        mCallback = tPDLProxyBindServiceCallback;
        TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "ensurePlayManagerService " + FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
        try {
            Intent intent = new Intent(context, (Class<?>) TPDownloadProxyService.class);
            if (mAddAboveClientForBindService) {
                bindService = context.bindService(intent, mConnection, 9);
            } else {
                context.startService(intent);
                bindService = context.bindService(intent, mConnection, 1);
            }
            if (!bindService) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "ensurePlayManagerService bind service failed!");
            }
            return true;
        } catch (Throwable th5) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "ensurePlayManagerService failed, error:" + th5);
            return false;
        }
    }

    public static synchronized boolean getCanUseAIDL() {
        boolean z16;
        synchronized (TPDownloadProxyFactory.class) {
            z16 = mCanUseAIDL;
        }
        return z16;
    }

    public static String getNativeVersion() {
        if (!mUseService) {
            return TPDownloadProxyNative.getInstance().getNativeVersion();
        }
        if (!mCanUseAIDL) {
            return TPDownloadProxyNative.getInstance().getNativeVersion();
        }
        TPDownloadProxyFactoryAidl tPDownloadProxyFactoryAidl = downloadProxyFactoryAidl;
        if (tPDownloadProxyFactoryAidl != null) {
            try {
                return tPDownloadProxyFactoryAidl.getNativeVersion();
            } catch (Throwable th5) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getNativeVersion failed, error:" + th5);
            }
        }
        return TPDownloadProxyNative.getInstance().getNativeVersion();
    }

    public static ITPDownloadProxy getProcessAdapterDownloadProxy(int i3) {
        ITPDownloadProxy iTPDownloadProxy;
        HashMap<Integer, ITPDownloadProxy> hashMap = mvTPDownloadProxyProcessAdapterMap;
        synchronized (hashMap) {
            iTPDownloadProxy = hashMap.get(Integer.valueOf(i3));
            if (iTPDownloadProxy == null) {
                iTPDownloadProxy = new TPDownloadProxyProcessAdapter(i3);
                hashMap.put(Integer.valueOf(i3), iTPDownloadProxy);
            }
            TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getTPDownloadProxy process adapter success serviceType:" + i3);
        }
        return iTPDownloadProxy;
    }

    public static ITPDownloadProxy getTPDownloadProxy(int i3) {
        ITPDownloadProxy iTPDownloadProxy;
        if (i3 <= 0) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getTPDownloadProxy is invalid, serviceType:" + i3);
            return null;
        }
        if (mUseService) {
            if (mCanUseAIDL) {
                try {
                    return getTPDownloadProxyService(i3);
                } catch (Throwable th5) {
                    TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getTPDownloadProxy serviceType:" + i3 + " failed, error:" + th5);
                }
            } else {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getTPDownloadProxy serviceType:" + i3 + " failed, can't use aidl!");
            }
            return null;
        }
        synchronized (mMapObject) {
            HashMap<Integer, ITPDownloadProxy> hashMap = mvTPDownloadProxyMap;
            iTPDownloadProxy = hashMap.get(Integer.valueOf(i3));
            HashMap<Integer, Boolean> hashMap2 = mvTPDownloadProxyMapState;
            Boolean bool = hashMap2.get(Integer.valueOf(i3));
            if (iTPDownloadProxy == null || bool == null || !bool.booleanValue()) {
                iTPDownloadProxy = new TPDownloadProxy(i3);
                hashMap.put(Integer.valueOf(i3), iTPDownloadProxy);
                hashMap2.put(Integer.valueOf(i3), Boolean.TRUE);
            }
        }
        return iTPDownloadProxy;
    }

    private static synchronized ITPDownloadProxy getTPDownloadProxyService(int i3) {
        TPDownloadProxyClient tPDownloadProxyClient;
        synchronized (TPDownloadProxyFactory.class) {
            if (downloadProxyFactoryAidl != null) {
                HashMap<Integer, TPDownloadProxyClient> hashMap = mvTPDownloadProxyClientMap;
                synchronized (hashMap) {
                    tPDownloadProxyClient = hashMap.get(Integer.valueOf(i3));
                    if (tPDownloadProxyClient == null) {
                        try {
                            tPDownloadProxyClient = new TPDownloadProxyClient(i3, downloadProxyFactoryAidl.getTPDownloadProxy(i3));
                        } catch (Throwable th5) {
                            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getTPDownloadProxyService serviceType:" + i3 + " failed, error:" + th5);
                        }
                    }
                    mvTPDownloadProxyClientMap.put(Integer.valueOf(i3), tPDownloadProxyClient);
                }
                return tPDownloadProxyClient;
            }
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getTPDownloadProxyService failed, aidl is null!");
            return null;
        }
    }

    public static boolean getUseService() {
        return mUseService;
    }

    public static boolean isNeedSwitchToMainProcess() {
        int i3;
        if (mIsDeviceInBlacklist && (i3 = mMaxServiceDisconnectedCount) > 0 && mServiceDisconnectedCount >= i3) {
            return true;
        }
        return false;
    }

    public static synchronized boolean isReadyForDownload() {
        synchronized (TPDownloadProxyFactory.class) {
            boolean z16 = false;
            if (!mUseService) {
                TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "isReadyForDownload ret:" + mIsReadyForDownload);
                return mIsReadyForDownload;
            }
            if (!mCanUseAIDL) {
                return false;
            }
            TPDownloadProxyFactoryAidl tPDownloadProxyFactoryAidl = downloadProxyFactoryAidl;
            if (tPDownloadProxyFactoryAidl != null) {
                try {
                    z16 = tPDownloadProxyFactoryAidl.isReadyForDownload();
                } catch (Throwable th5) {
                    TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "isReadyForDownload failed, error:" + th5);
                }
            }
            return z16;
        }
    }

    public static synchronized boolean isReadyForPlay() {
        synchronized (TPDownloadProxyFactory.class) {
            boolean z16 = false;
            if (!mUseService) {
                boolean isReadyForWork = TPDownloadProxyNative.getInstance().isReadyForWork();
                TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "isReadyForPlay ret:" + isReadyForWork);
                return isReadyForWork;
            }
            if (isNeedSwitchToMainProcess()) {
                return true;
            }
            if (!mCanUseAIDL) {
                return false;
            }
            TPDownloadProxyFactoryAidl tPDownloadProxyFactoryAidl = downloadProxyFactoryAidl;
            if (tPDownloadProxyFactoryAidl != null) {
                try {
                    z16 = tPDownloadProxyFactoryAidl.isReadyForPlay();
                } catch (Throwable th5) {
                    TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "isReadyForPlay failed, error:" + th5);
                }
            }
            return z16;
        }
    }

    public static boolean isServiceBinding(int i3) {
        boolean containsKey;
        if (isNeedSwitchToMainProcess()) {
            return false;
        }
        HashMap<Integer, TPDownloadProxyClient> hashMap = mvTPDownloadProxyClientMap;
        synchronized (hashMap) {
            containsKey = hashMap.containsKey(Integer.valueOf(i3));
        }
        return containsKey;
    }

    public static boolean pushEvent(int i3) {
        TPDownloadProxyFactoryAidl tPDownloadProxyFactoryAidl;
        if (!mUseService) {
            if (!TPDownloadProxyNative.getInstance().isNativeLoaded()) {
                return false;
            }
            TPDownloadProxyNative.getInstance().pushEvent(i3);
            return true;
        }
        if (mCanUseAIDL && (tPDownloadProxyFactoryAidl = downloadProxyFactoryAidl) != null) {
            try {
                return tPDownloadProxyFactoryAidl.pushEvent(i3);
            } catch (Throwable th5) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "upload enable failed, error:" + th5);
            }
        }
        return false;
    }

    public static void registerProxyInfoCallback(ITPDownloadProxyInfoCallback iTPDownloadProxyInfoCallback) {
        if (!mUseService) {
            TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "register proxy info callback");
            TPListenerManager.getInstance().registerDownloadProxyCallback(iTPDownloadProxyInfoCallback);
            return;
        }
        if (mCanUseAIDL && downloadProxyFactoryAidl != null) {
            try {
                ITPDownloadProxyInfoCallbackAidl.Stub stub = new ITPDownloadProxyInfoCallbackAidl.Stub() { // from class: com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyFactory.2
                    @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyInfoCallbackAidl
                    public void OnNativeConfigUpdate(String str) throws RemoteException {
                        TPDLProxyLog.i(TPDownloadProxyFactory.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "OnNativeConfigUpdate callback");
                        TPDownloadProxyFactory.setNativeConfigJsonStr(str);
                    }
                };
                TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "in service process mode, register proxy info callback");
                downloadProxyFactoryAidl.registerProxyInfoCallback(stub);
            } catch (Throwable th5) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "registerProxyInfoCallback error:" + th5);
            }
        }
    }

    public static boolean removeServiceListener(ITPServiceListener iTPServiceListener) {
        synchronized (mServiceListener) {
            int i3 = 0;
            while (true) {
                List<WeakReference<ITPServiceListener>> list = mServiceListener;
                if (i3 >= list.size()) {
                    return false;
                }
                if (list.get(i3).get() == iTPServiceListener) {
                    list.remove(i3);
                    return true;
                }
                i3++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void setCanUseAIDL(boolean z16) {
        synchronized (TPDownloadProxyFactory.class) {
            mCanUseAIDL = z16;
        }
    }

    public static void setNativeConfigJsonStr(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String model = DeviceInfoMonitor.getModel();
                JSONObject jSONObject = new JSONObject(str);
                String jSONStringValue = TPDLProxyUtils.getJSONStringValue(jSONObject, CONFIG_DEVICE_BLACKLIST, "");
                if (jSONStringValue.contains(model)) {
                    mIsDeviceInBlacklist = true;
                    mMaxServiceDisconnectedCount = jSONObject.getInt(CONFIG_MAX_MATCH_DEVICE_DISCONNECTED_COUNT);
                    mMaxServiceDisconnectedCount = TPDLProxyUtils.getJSONIntValue(jSONObject, CONFIG_MAX_MATCH_DEVICE_DISCONNECTED_COUNT, -1);
                } else {
                    mIsDeviceInBlacklist = TPDLProxyUtils.getJSONBooleanValue(jSONObject, CONFIG_ENABLE_ALL_DEVICE_SWITCH_MAIN_PROCESS, false);
                    mMaxServiceDisconnectedCount = TPDLProxyUtils.getJSONIntValue(jSONObject, CONFIG_MAX_ALL_DEVICE_DISCONNECTED_COUNT, -1);
                }
                TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "disconnected count:(" + mServiceDisconnectedCount + ", " + mMaxServiceDisconnectedCount + "), current device model " + model + ", blacklist:" + jSONStringValue);
            } catch (Throwable th5) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "set native config json str:" + str + ", error:" + th5);
            }
        }
    }

    public static synchronized void setReadyForDownload(boolean z16) {
        synchronized (TPDownloadProxyFactory.class) {
            mIsReadyForDownload = z16;
        }
    }

    public static void setUseNewBindServiceMethod(boolean z16) {
        mAddAboveClientForBindService = z16;
    }

    public static void setUseService(boolean z16) {
        mUseService = z16;
    }
}
