package com.tencent.thumbplayer.core.downloadproxy.jni;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkRequest;
import android.text.TextUtils;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.thumbplayer.core.datatransport.api.TPDataTransportEnum;
import com.tencent.thumbplayer.core.datatransport.apiinner.TPDataTransportBizIdCreator;
import com.tencent.thumbplayer.core.datatransport.apiinner.TPDataTransportTaskListenerMgr;
import com.tencent.thumbplayer.core.datatransport.util.ITPDataTransportLog;
import com.tencent.thumbplayer.core.datatransport.util.TPDataTransportLogFactory;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyNativeLibLoader;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLFileSystem;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyUtils;
import java.io.File;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes26.dex */
public class TPDownloadProxyNative {
    private ConnectivityManager mConnectivityManager;
    private boolean mIsInit;
    private ITPDLProxyNativeLibLoader mLibLoader;
    private ConnectivityManager.NetworkCallback mNetworkCallback;
    private TPSystemBroadcastReceiver mReceiver;
    private static final ITPDataTransportLog mLogger = TPDataTransportLogFactory.getInstance().getLogger("TPDownloadProxyNative");
    private static boolean isLoadDownloadProxySucceed = false;
    private static Context appContext = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public static class SingletonHolder {
        private static final TPDownloadProxyNative INSTANCE = new TPDownloadProxyNative();

        SingletonHolder() {
        }
    }

    public static TPDownloadProxyNative getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static int nativeIntMessageCallback(int i3, int i16, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return TPDataTransportTaskListenerMgr.getInstance().handleIntCallbackMessage(i3, i16, obj, obj2, obj3, obj4, obj5);
    }

    private static void nativeLogCallback(int i3, byte[] bArr, int i16, byte[] bArr2, byte[] bArr3) {
        String byteArrayToString = TPDLProxyUtils.byteArrayToString(bArr);
        String byteArrayToString2 = TPDLProxyUtils.byteArrayToString(bArr2);
        String byteArrayToString3 = TPDLProxyUtils.byteArrayToString(bArr3);
        if (i3 == 6) {
            mLogger.e(byteArrayToString2, byteArrayToString, i16, byteArrayToString3);
            return;
        }
        if (i3 == 5) {
            mLogger.w(byteArrayToString2, byteArrayToString, i16, byteArrayToString3);
            return;
        }
        if (i3 == 4) {
            mLogger.i(byteArrayToString2, byteArrayToString, i16, byteArrayToString3);
        } else if (i3 == 3) {
            mLogger.d(byteArrayToString2, byteArrayToString, i16, byteArrayToString3);
        } else {
            mLogger.i(byteArrayToString2, byteArrayToString, i16, byteArrayToString3);
        }
    }

    private static void nativeMessageCallback(int i3, int i16, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        TPDataTransportTaskListenerMgr.getInstance().handleCallbackMessage(i3, i16, obj, obj2, obj3, obj4, obj5);
    }

    private static String nativeStringMessageCallback(int i3, int i16, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return TPDataTransportTaskListenerMgr.getInstance().handleStringCallbackMessage(i3, i16, obj, obj2, obj3, obj4, obj5);
    }

    private void registerNetworkConnectivity(Context context) {
        if (context == null) {
            mLogger.i("registerNetworkConnectivity failed, context is null, can not set interface 4g");
            return;
        }
        try {
            NetworkRequest.Builder builder = new NetworkRequest.Builder();
            builder.addCapability(12);
            builder.addTransportType(0);
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            this.mConnectivityManager = connectivityManager;
            if (connectivityManager == null) {
                mLogger.i("cellular_network, connectivityManager is null, can not set interface 4g");
                return;
            }
            initCares(context);
            NetworkRequest build = builder.build();
            ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback() { // from class: com.tencent.thumbplayer.core.downloadproxy.jni.TPDownloadProxyNative.1
                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onAvailable(Network network) {
                    super.onAvailable(network);
                    TPDataTransportTaskListenerMgr.getInstance().setNetwork(network);
                    long networkHandle = network.getNetworkHandle();
                    TPDownloadProxyNative.mLogger.i("cellular_network, net_id_t: " + networkHandle);
                    TPDownloadProxyNative.this.setGlobalOptionalConfigParam("cellular_interface_id", String.valueOf(networkHandle));
                    try {
                        LinkProperties linkProperties = TPDownloadProxyNative.this.mConnectivityManager.getLinkProperties(network);
                        if (linkProperties != null) {
                            String interfaceName = linkProperties.getInterfaceName();
                            TPDownloadProxyNative.mLogger.i("cellular_network, interfaceName: " + interfaceName);
                            TPDownloadProxyNative.this.setGlobalOptionalConfigParam("cellular_interface_name", interfaceName);
                            List<InetAddress> dnsServers = linkProperties.getDnsServers();
                            ArrayList arrayList = new ArrayList();
                            Iterator<InetAddress> it = dnsServers.iterator();
                            while (it.hasNext()) {
                                arrayList.add(it.next().getHostAddress());
                            }
                            String join = TextUtils.join(",", arrayList);
                            TPDownloadProxyNative.mLogger.i("cellular dns address: " + join);
                            TPDownloadProxyNative.this.setGlobalOptionalConfigParam("dns_servers", join);
                        }
                    } catch (Throwable th5) {
                        TPDownloadProxyNative.mLogger.e("ConnectivityManager getLinkProperties failed, error:" + th5);
                    }
                }

                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onLost(Network network) {
                    super.onLost(network);
                    TPDownloadProxyNative.this.setGlobalOptionalConfigParam("cellular_interface_id", String.valueOf(0));
                    TPDownloadProxyNative.this.setGlobalOptionalConfigParam("cellular_interface_name", "");
                    TPDownloadProxyNative.this.setGlobalOptionalConfigParam("dns_servers", "");
                    TPDownloadProxyNative.mLogger.i("cellular_network failed");
                }
            };
            this.mNetworkCallback = networkCallback;
            this.mConnectivityManager.requestNetwork(build, networkCallback);
        } catch (Throwable th5) {
            ITPDataTransportLog iTPDataTransportLog = mLogger;
            iTPDataTransportLog.e("registerNetworkConnectivity, error:" + th5);
            iTPDataTransportLog.e("registerNetworkConnectivity, stack:" + TPDLProxyUtils.getExceptionCallStack(th5));
        }
    }

    private void registerSystemReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_OFF);
        intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_ON);
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.mReceiver = new TPSystemBroadcastReceiver();
        if (appContext != null) {
            mLogger.i("register system receiver");
            appContext.registerReceiver(this.mReceiver, intentFilter);
        }
    }

    private void updateCurrentNetworkState() {
        try {
            if (TPDLProxyUtils.getNetWorkState(appContext) == 1) {
                setGlobalOptionalConfigParam(TPDataTransportEnum.GLOBAL_OPTIONAL_CONFIG_PARAM_INT_NETWORK_STATE, String.valueOf(1));
            } else {
                setGlobalOptionalConfigParam(TPDataTransportEnum.GLOBAL_OPTIONAL_CONFIG_PARAM_INT_NETWORK_STATE, String.valueOf(2));
            }
        } catch (Throwable th5) {
            mLogger.e("updateCurrentNetworkState failed, error:" + th5);
        }
    }

    public native long GetTotalMemorySizeKB();

    public native int checkResourceStatus(String str, String str2, int i3);

    public native int clearCache(String str, String str2, int i3);

    public native int clearRangeCache(String str, String str2, int i3, int i16);

    public native int createDownloadTask(int i3, String str, int i16, int i17);

    public native int deInitService(int i3);

    public native int deleteCache(String str, String str2);

    public Context getAppContext() {
        return appContext;
    }

    public native byte[] getBizAccessibleNativeInfo(int i3, int i16);

    public native byte[] getClipPlayUrl(int i3, int i16, int i17);

    public native byte[] getErrorCodeStr(int i3);

    public native byte[] getGlobalAccessibleNativeInfo(int i3);

    public native byte[] getHLSOfflineExttag(String str, String str2, int i3, long j3);

    public native byte[] getNativeInfo(int i3);

    public String getNativeVersion() {
        String str;
        if (isLoadDownloadProxySucceed) {
            str = TPDLProxyUtils.byteArrayToString(getVersion());
        } else {
            str = "2.35.0.00016";
        }
        mLogger.i("get native version:" + str);
        return str;
    }

    public native long getResourceSize(String str, String str2);

    public native byte[] getTaskAccessibleNativeInfo(int i3, int i16);

    public native byte[] getVersion();

    public int initBizId(int i3) {
        String str;
        int i16 = -1;
        if (appContext == null) {
            mLogger.e("initDefaultBizId failed, context is null");
            return -1;
        }
        TPDataTransportTaskListenerMgr.getInstance().initHandler();
        try {
            File properCacheDirectory = TPDLFileSystem.getProperCacheDirectory(appContext, "download");
            if (properCacheDirectory == null) {
                str = "";
            } else {
                str = properCacheDirectory.getAbsolutePath();
                mLogger.i("get download proxy cacheDir: " + str);
            }
            i16 = initService(i3, str, TPDataTransportBizIdCreator.getInstance().getBizDataDir(i3), "");
            if (!this.mIsInit) {
                updateCurrentNetworkState();
                registerNetworkConnectivity(appContext);
                registerSystemReceiver();
                this.mIsInit = true;
                String appVer = TPDLProxyUtils.getAppVer(appContext);
                String deviceModel = TPDLProxyUtils.getDeviceModel();
                if (!TextUtils.isEmpty(appVer)) {
                    setGlobalOptionalConfigParam("app_version_name", appVer);
                }
                if (!TextUtils.isEmpty(deviceModel)) {
                    setGlobalOptionalConfigParam("device_model", deviceModel);
                }
            }
        } catch (Throwable th5) {
            ITPDataTransportLog iTPDataTransportLog = mLogger;
            iTPDataTransportLog.e("initBizId, error:" + th5);
            iTPDataTransportLog.e("initBizId, stack:" + TPDLProxyUtils.getExceptionCallStack(th5));
        }
        return i16;
    }

    public native void initCares(Context context);

    public native int initService(int i3, String str, String str2, String str3);

    public boolean isNativeLoaded() {
        return isLoadDownloadProxySucceed;
    }

    public native boolean isNativeReadyForWork();

    public boolean isReadyForWork() {
        if (isLoadDownloadProxySucceed) {
            return isNativeReadyForWork();
        }
        return false;
    }

    public boolean loadLibrary() {
        String str;
        if (!isLoadDownloadProxySucceed) {
            try {
                ITPDLProxyNativeLibLoader iTPDLProxyNativeLibLoader = this.mLibLoader;
                if (iTPDLProxyNativeLibLoader != null) {
                    isLoadDownloadProxySucceed = iTPDLProxyNativeLibLoader.loadLib("DownloadProxy", getNativeVersion());
                    ITPDataTransportLog iTPDataTransportLog = mLogger;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("third module so load ret:");
                    if (isLoadDownloadProxySucceed) {
                        str = "0";
                    } else {
                        str = "1";
                    }
                    sb5.append(str);
                    iTPDataTransportLog.i(sb5.toString());
                }
            } catch (Throwable th5) {
                isLoadDownloadProxySucceed = false;
                mLogger.e("third module so load failed, error:" + th5);
            }
            try {
                if (!isLoadDownloadProxySucceed) {
                    System.loadLibrary("DownloadProxy");
                    isLoadDownloadProxySucceed = true;
                    mLogger.i("system so load success!");
                }
            } catch (Throwable th6) {
                isLoadDownloadProxySucceed = false;
                mLogger.e("system so load failed, error:" + th6);
            }
        }
        return isLoadDownloadProxySucceed;
    }

    public native int pauseDownload(int i3);

    public native void pushEvent(int i3);

    public native int resumeDownload(int i3);

    public native int sendCgiRequest(String str, String str2);

    public void setAppContext(Context context) {
        if (context != null) {
            appContext = context.getApplicationContext();
        }
    }

    public native void setBizOptionalConfigParam(int i3, String str, String str2);

    public native void setBusinessDownloadStrategy(int i3, int i16, int i17, int i18, int i19);

    public native int setClipInfo(int i3, int i16, String str, int i17, String str2, String str3, String str4);

    public native void setGlobalOptionalConfigParam(String str, String str2);

    public void setLibLoader(ITPDLProxyNativeLibLoader iTPDLProxyNativeLibLoader) {
        mLogger.i("set third module so loader!!!");
        this.mLibLoader = iTPDLProxyNativeLibLoader;
    }

    public native int setMaxStorageSizeMB(int i3, long j3);

    public native void setPlayerState(int i3, int i16);

    public native void setServiceConfig(int i3, String str);

    public native void setUserData(String str, String str2);

    public native int startDownload(int i3);

    public native int stopAllDownload(int i3);

    public native int stopDownload(int i3);

    public int unregisterBizId(int i3) {
        return deInitService(i3);
    }

    public native void updatePlayerPlayMsg(int i3, int i16, int i17, int i18);

    public native int updateStoragePath(int i3, String str);

    public native void updateTaskInfo(int i3, String str, String str2);

    public native long verifyOfflineCacheSync(String str, int i3, String str2, String str3);

    TPDownloadProxyNative() {
        this.mIsInit = false;
    }
}
