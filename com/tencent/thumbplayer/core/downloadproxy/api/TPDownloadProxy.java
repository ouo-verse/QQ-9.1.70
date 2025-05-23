package com.tencent.thumbplayer.core.downloadproxy.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.text.TextUtils;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import com.tencent.thumbplayer.core.downloadproxy.apiinner.TPListenerManager;
import com.tencent.thumbplayer.core.downloadproxy.jni.TPDownloadProxyNative;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLFileSystem;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyLog;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyUtils;
import java.io.File;

/* loaded from: classes26.dex */
public class TPDownloadProxy implements ITPDownloadProxy {
    private static final String FILE_NAME = "TPDownloadProxy";
    private ConnectivityManager mConnectivityManager;
    private Context mContext;
    private String mCurrentStoragePath = "";
    private boolean mIsInit = false;
    private ConnectivityManager.NetworkCallback mNetworkCallback;
    private BroadcastReceiver mReceiver;
    private final int mServiceType;

    public TPDownloadProxy(int i3) {
        this.mServiceType = i3;
        TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "Construct TPDownloadProxy, serviceType:" + i3);
    }

    private String getSuggestBitrate(int i3) {
        if (i3 == TPDownloadProxyEnum.SuggestBitrateType.NOT_CHOOSE_CLARIFY.ordinal()) {
            return getNativeInfo(6);
        }
        if (i3 == TPDownloadProxyEnum.SuggestBitrateType.CHOOSE_CLARIFY.ordinal()) {
            return getNativeInfo(7);
        }
        return null;
    }

    private void registerNetworkConnectivity(Context context) {
        if (context == null) {
            TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "cellular_network, context is null, can not set interface 4g");
            return;
        }
        NetworkRequest.Builder builder = new NetworkRequest.Builder();
        builder.addCapability(12);
        builder.addTransportType(0);
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        this.mConnectivityManager = connectivityManager;
        if (connectivityManager == null) {
            TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "cellular_network, connectivityManager is null, can not set interface 4g");
            return;
        }
        NetworkRequest build = builder.build();
        ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback() { // from class: com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxy.1
            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                super.onAvailable(network);
                TPListenerManager.getInstance().setNetwork(network);
                long networkHandle = network.getNetworkHandle();
                TPDLProxyLog.i(TPDownloadProxy.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "cellular_network, net_id_t: " + networkHandle);
                TPDownloadProxy.this.setUserData("cellular_interface_id", Long.valueOf(networkHandle));
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(Network network) {
                super.onLost(network);
                TPDownloadProxy.this.setUserData("cellular_interface_id", 0);
                TPDLProxyLog.i(TPDownloadProxy.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "cellular_network failed");
            }
        };
        this.mNetworkCallback = networkCallback;
        this.mConnectivityManager.requestNetwork(build, networkCallback);
    }

    private void unregisterNetworkConnectivity() {
        ConnectivityManager connectivityManager = this.mConnectivityManager;
        if (connectivityManager != null) {
            connectivityManager.unregisterNetworkCallback(this.mNetworkCallback);
        }
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public long GetTotalMemorySizeKB() {
        return TPDownloadProxyNative.getInstance().GetTotalMemorySizeKB();
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public int checkResourceStatus(String str, String str2, int i3) {
        if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                return TPDownloadProxyNative.getInstance().checkResourceStatus(str, str2, i3);
            } catch (Throwable th5) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "checkResourceStatus failed, error:" + th5);
            }
        }
        return -1;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public int clearCache(String str, String str2, int i3) {
        if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                return TPDownloadProxyNative.getInstance().clearCache(str, str2, i3);
            } catch (Throwable th5) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "clearCache failed, error:" + th5);
                return -1;
            }
        }
        return -1;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public int clearRangeCache(String str, int i3, int i16) {
        if (!TextUtils.isEmpty(str) && TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                return TPDownloadProxyNative.getInstance().clearRangeCache(this.mCurrentStoragePath, str, i3, i16);
            } catch (Throwable th5) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "deleteCache failed, error:" + th5);
            }
        }
        return -1;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public int deinit() {
        if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                this.mIsInit = false;
                unregisterNetworkConnectivity();
                return TPDownloadProxyNative.getInstance().deInitService(this.mServiceType);
            } catch (Throwable th5) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "deinit failed, error:" + th5);
            }
        }
        Context context = this.mContext;
        BroadcastReceiver broadcastReceiver = this.mReceiver;
        if (broadcastReceiver != null && context != null) {
            context.unregisterReceiver(broadcastReceiver);
        }
        this.mContext = null;
        return -1;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public String getClipPlayUrl(int i3, int i16, int i17) {
        String str = "";
        if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                str = TPDLProxyUtils.byteArrayToString(TPDownloadProxyNative.getInstance().getClipPlayUrl(i3, i16, i17));
                if (i17 != 2) {
                    TPDownloadProxyNative.getInstance().startDownload(i3);
                }
            } catch (Throwable th5) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getClipPlayUrl failed, error:" + th5);
            }
        }
        return str;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public String getDownloadProxyInfo(int i3, Object obj, Object obj2, Object obj3) {
        if (i3 != 0) {
            return null;
        }
        int ordinal = TPDownloadProxyEnum.SuggestBitrateType.NOT_CHOOSE_CLARIFY.ordinal();
        if (obj != null) {
            ordinal = TPDLProxyUtils.stringToInt(obj.toString(), ordinal);
        }
        return getSuggestBitrate(ordinal);
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public String getNativeInfo(int i3) {
        if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                return TPDLProxyUtils.byteArrayToString(TPDownloadProxyNative.getInstance().getNativeInfo(i3));
            } catch (Throwable th5) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getNativeInfo failed, error:" + th5);
                return null;
            }
        }
        return null;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public String getPlayErrorCodeStr(int i3) {
        if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                return TPDLProxyUtils.byteArrayToString(TPDownloadProxyNative.getInstance().getErrorCodeStr(i3));
            } catch (Throwable th5) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getPlayErrorCodeStr failed, error:" + th5);
            }
        }
        return "";
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public String getPlayUrl(int i3, int i16) {
        String str = "";
        if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                str = TPDLProxyUtils.byteArrayToString(TPDownloadProxyNative.getInstance().getClipPlayUrl(i3, 1, i16));
                if (i16 != 2) {
                    TPDownloadProxyNative.getInstance().startDownload(i3);
                }
            } catch (Throwable th5) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getPlayUrl failed, error:" + th5);
            }
        }
        return str;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public long getResourceSize(String str, String str2) {
        if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                return TPDownloadProxyNative.getInstance().getResourceSize(str, str2);
            } catch (Throwable th5) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getResourceSize failed, error:" + th5);
            }
        }
        return -1L;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public synchronized int init(Context context, TPDLProxyInitParam tPDLProxyInitParam) {
        int initService;
        if (this.mIsInit) {
            TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "download already init");
            return 0;
        }
        TPDownloadProxyNative.getInstance().setAppContext(context);
        if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                if (!TextUtils.isEmpty(tPDLProxyInitParam.getAppVer())) {
                    setUserData("app_version_name", tPDLProxyInitParam.getAppVer());
                }
                if (tPDLProxyInitParam.getPlatform() > 0) {
                    setUserData("platform", Integer.valueOf(tPDLProxyInitParam.getPlatform()));
                }
                if (!TextUtils.isEmpty(tPDLProxyInitParam.getGuid())) {
                    setUserData("guid", tPDLProxyInitParam.getGuid());
                }
                String str = "";
                if (context != null) {
                    try {
                        File properCacheDirectory = TPDLFileSystem.getProperCacheDirectory(context, "download");
                        if (properCacheDirectory != null) {
                            str = properCacheDirectory.getAbsolutePath();
                            TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "get download proxy cacheDir: " + str);
                        }
                    } catch (Throwable th5) {
                        TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "init get cache dir failed, error:" + th5);
                    }
                }
                if (TextUtils.isEmpty(str)) {
                    str = tPDLProxyInitParam.getCacheDir();
                    TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "get app cacheDir: " + str);
                }
                TPListenerManager.getInstance().initHandler();
                if (TextUtils.isEmpty(tPDLProxyInitParam.getDataDir()) && !TextUtils.isEmpty(this.mCurrentStoragePath)) {
                    initService = TPDownloadProxyNative.getInstance().initService(this.mServiceType, str, this.mCurrentStoragePath, tPDLProxyInitParam.getConfigStr());
                    TPDLProxyLog.i(FILE_NAME, 145, ITPDLProxyLogListener.COMMON_TAG, "mServiceType:" + this.mServiceType + " cacheDir:" + str + " mCurrentStoragePath:" + this.mCurrentStoragePath);
                    TPDLProxyLog.e(FILE_NAME, 150, ITPDLProxyLogListener.COMMON_TAG, TPDLProxyUtils.getCurrentStackTrace(ITPDLProxyLogListener.COMMON_TAG, 20));
                } else {
                    if (!TextUtils.isEmpty(tPDLProxyInitParam.getDataDir())) {
                        this.mCurrentStoragePath = tPDLProxyInitParam.getDataDir();
                    }
                    initService = TPDownloadProxyNative.getInstance().initService(this.mServiceType, str, tPDLProxyInitParam.getDataDir(), tPDLProxyInitParam.getConfigStr());
                    TPDLProxyLog.i(FILE_NAME, 157, ITPDLProxyLogListener.COMMON_TAG, "mServiceType:" + this.mServiceType + " cacheDir:" + str + " mCurrentStoragePath:" + this.mCurrentStoragePath);
                    TPDLProxyLog.e(FILE_NAME, 159, ITPDLProxyLogListener.COMMON_TAG, TPDLProxyUtils.getCurrentStackTrace(ITPDLProxyLogListener.COMMON_TAG, 20));
                }
                setUserData("device_model", DeviceInfoMonitor.getModel());
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_OFF);
                intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_ON);
                intentFilter.addAction("android.intent.action.USER_PRESENT");
                BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxy.2
                    @Override // android.content.BroadcastReceiver
                    public void onReceive(Context context2, Intent intent) {
                        String action = intent.getAction();
                        if (IECScreenReceiver.ACTION_SCREEN_OFF.equals(action)) {
                            TPDownloadProxy.this.pushEvent(20);
                        } else if (IECScreenReceiver.ACTION_SCREEN_ON.equals(action)) {
                            TPDownloadProxy.this.pushEvent(19);
                        }
                    }
                };
                this.mReceiver = broadcastReceiver;
                if (context != null) {
                    context.registerReceiver(broadcastReceiver, intentFilter);
                }
                if (initService == 0) {
                    this.mIsInit = true;
                }
                registerNetworkConnectivity(context);
                this.mContext = context;
                return initService;
            } catch (Throwable th6) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "init failed, error:" + th6);
            }
        }
        return -1;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public boolean isInit() {
        return this.mIsInit;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public int pauseDownload(int i3) {
        if (i3 > 0 && TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                return TPDownloadProxyNative.getInstance().pauseDownload(i3);
            } catch (Throwable th5) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "pauseDownload failed, error:" + th5);
            }
        }
        return -1;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public void pushEvent(int i3) {
        if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                TPDownloadProxyNative.getInstance().pushEvent(i3);
            } catch (Throwable th5) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "cellular_network pushEvent failed, error:" + th5);
            }
        }
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public int removeStorageCache(String str) {
        if (!TextUtils.isEmpty(str) && TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                return TPDownloadProxyNative.getInstance().deleteCache(this.mCurrentStoragePath, str);
            } catch (Throwable th5) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "deleteCache failed, error:" + th5);
            }
        }
        return -1;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public int resumeDownload(int i3) {
        if (i3 > 0 && TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                return TPDownloadProxyNative.getInstance().resumeDownload(i3);
            } catch (Throwable th5) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "resumeDownload failed, error:" + th5);
            }
        }
        return -1;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public void setBusinessDownloadStrategy(int i3, int i16, int i17, int i18, int i19) {
        if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                TPDownloadProxyNative.getInstance().setBusinessDownloadStrategy(i3, i16, i17, i18, i19);
            } catch (Throwable th5) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "setBusinessDownloadStrategy failed, error:" + th5.toString());
            }
        }
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public boolean setClipInfo(int i3, int i16, String str, TPDownloadParam tPDownloadParam) {
        int dlType = tPDownloadParam.getDlType();
        if (tPDownloadParam.isOffline()) {
            dlType += 300;
        }
        int i17 = dlType;
        if (!TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            return false;
        }
        try {
            if (TPDownloadProxyNative.getInstance().setClipInfo(i3, i16, str, i17, tPDownloadParam.getCdnUrls(), tPDownloadParam.getSavaPath(), tPDownloadParam.getExtraJsonInfo()) < 0) {
                return false;
            }
            return true;
        } catch (Throwable th5) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "setClipInfo failed, error:" + th5);
            return false;
        }
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public void setLogListener(ITPDLProxyLogListener iTPDLProxyLogListener) {
        TPDLProxyLog.setLogListener(this.mServiceType, iTPDLProxyLogListener);
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public void setMaxStorageSizeMB(long j3) {
        if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                TPDownloadProxyNative.getInstance().setMaxStorageSizeMB(this.mServiceType, j3);
            } catch (Throwable th5) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "setMaxStorageSizeMB failed, error:" + th5);
            }
        }
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public void setPlayState(int i3, int i16) {
        if (i3 > 0 && TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                TPDownloadProxyNative.getInstance().setPlayerState(i3, i16);
                if (i16 == 1) {
                    long currentPlayOffset = TPListenerManager.getInstance().getPlaylistener(i3).getCurrentPlayOffset();
                    int currentPosition = (int) (TPListenerManager.getInstance().getPlaylistener(i3).getCurrentPosition() / 1000);
                    int playerBufferLength = (int) TPListenerManager.getInstance().getPlaylistener(i3).getPlayerBufferLength();
                    int advRemainTime = (int) (TPListenerManager.getInstance().getPlaylistener(i3).getAdvRemainTime() / 1000);
                    TPDownloadProxyNative.getInstance().updateTaskInfo(i3, "taskinfo_play_offset", String.valueOf(currentPlayOffset));
                    TPDownloadProxyNative.getInstance().updatePlayerPlayMsg(i3, currentPosition, playerBufferLength, advRemainTime);
                }
            } catch (Throwable th5) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "setPlayState failed, error:" + th5);
            }
        }
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public void setUpdatePlayerInfoInterval(int i3) {
        TPListenerManager.getInstance().setUpdatePlayerInfoInterval(i3);
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public void setUserData(String str, Object obj) {
        String str2;
        if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                if (str.equalsIgnoreCase("app_version_name")) {
                    TPDownloadProxyNative.getInstance().setUserData("app_version_name", (String) obj);
                } else if (str.equalsIgnoreCase("platform")) {
                    TPDownloadProxyNative.getInstance().setUserData("platform", obj.toString());
                } else if (str.equalsIgnoreCase("guid")) {
                    TPDownloadProxyNative.getInstance().setUserData("guid", (String) obj);
                } else if (str.equalsIgnoreCase("qq_is_vip")) {
                    TPDownloadProxyNative tPDownloadProxyNative = TPDownloadProxyNative.getInstance();
                    if (((Boolean) obj).booleanValue()) {
                        str2 = "1";
                    } else {
                        str2 = "0";
                    }
                    tPDownloadProxyNative.setUserData("qq_is_vip", str2);
                } else if (str.equalsIgnoreCase("carrier_pesudo_code")) {
                    TPDownloadProxyNative.getInstance().setUserData("carrier_pesudo_code", (String) obj);
                } else if (str.equalsIgnoreCase("carrier_pesudo_state")) {
                    TPDownloadProxyNative.getInstance().setUserData("carrier_pesudo_state", obj.toString());
                } else if (str.equalsIgnoreCase("proxy_config")) {
                    TPDownloadProxyNative.getInstance().setUserData("proxy_config", obj.toString());
                } else if (str.equalsIgnoreCase(TPDownloadProxyEnum.USER_SERVICE_CONFIG)) {
                    TPDownloadProxyNative.getInstance().setServiceConfig(this.mServiceType, obj.toString());
                } else {
                    TPDownloadProxyNative.getInstance().setUserData(str, obj.toString());
                }
            } catch (Throwable th5) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "setUserData failed, error:" + th5);
            }
        }
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public int startClipOfflineDownload(String str, int i3, ITPOfflineDownloadListener iTPOfflineDownloadListener) {
        int i16 = -1;
        if (!TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            return -1;
        }
        try {
            i16 = TPDownloadProxyNative.getInstance().createDownloadTask(this.mServiceType, str, 102, i3);
            TPListenerManager.getInstance().setOfflineDownloadListener(i16, iTPOfflineDownloadListener);
            return i16;
        } catch (Throwable th5) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "startClipOfflineDownload failed, error:" + th5);
            return i16;
        }
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public int startClipPlay(String str, int i3, ITPPlayListener iTPPlayListener) {
        int i16 = -1;
        if (!TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            return -1;
        }
        try {
            i16 = TPDownloadProxyNative.getInstance().createDownloadTask(this.mServiceType, str, 2, i3);
            TPListenerManager.getInstance().setPlayListener(i16, iTPPlayListener);
            return i16;
        } catch (Throwable th5) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "startClipPlay failed, error:" + th5);
            return i16;
        }
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public int startClipPreload(String str, int i3, ITPPreLoadListener iTPPreLoadListener) {
        int i16 = -1;
        if (!TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            return -1;
        }
        try {
            i16 = TPDownloadProxyNative.getInstance().createDownloadTask(this.mServiceType, str, 202, i3);
            TPListenerManager.getInstance().setPreLoadListener(i16, iTPPreLoadListener);
            return i16;
        } catch (Throwable th5) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "startClipPreload failed, error:" + th5);
            return i16;
        }
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public int startOfflineDownload(String str, TPDownloadParam tPDownloadParam, ITPOfflineDownloadListener iTPOfflineDownloadListener) {
        int i3 = -1;
        if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                int dlType = tPDownloadParam.getDlType() + 100;
                i3 = TPDownloadProxyNative.getInstance().createDownloadTask(this.mServiceType, str, dlType, tPDownloadParam.getClipCount());
                TPListenerManager.getInstance().setOfflineDownloadListener(i3, iTPOfflineDownloadListener);
                if (!TextUtils.isEmpty(tPDownloadParam.getKeyid())) {
                    str = tPDownloadParam.getKeyid();
                }
                TPDownloadProxyNative.getInstance().setClipInfo(i3, tPDownloadParam.getClipNo(), str, dlType, tPDownloadParam.getCdnUrls(), tPDownloadParam.getSavaPath(), tPDownloadParam.getExtraJsonInfo());
            } catch (Throwable th5) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "stopOfflineDownload failed, error:" + th5);
            }
        }
        return i3;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public int startPlay(String str, TPDownloadParam tPDownloadParam, ITPPlayListener iTPPlayListener) {
        long currentTimeMillis;
        int createDownloadTask;
        int dlType = tPDownloadParam.getDlType();
        if (iTPPlayListener != null) {
            tPDownloadParam.getExtInfoMap().put("dl_param_adv_remain_time", Long.valueOf(iTPPlayListener.getAdvRemainTime() / 1000));
        }
        if (tPDownloadParam.isOffline()) {
            dlType += 300;
        }
        if (tPDownloadParam.isAdaptive() && (dlType == 3 || dlType == 5)) {
            dlType += 400;
        }
        if (dlType == 16 && tPDownloadParam.isUseP2p()) {
            if (tPDownloadParam.isTencentCloudOrigin()) {
                tPDownloadParam.getExtInfoMap().put("package", TPDownloadProxyNative.getInstance().getAppContext().getPackageName());
                dlType = 12;
            } else {
                dlType = 23;
            }
        }
        int i3 = dlType;
        int i16 = -1;
        if (!TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            return -1;
        }
        try {
            currentTimeMillis = System.currentTimeMillis();
            createDownloadTask = TPDownloadProxyNative.getInstance().createDownloadTask(this.mServiceType, tPDownloadParam.buildFileId(str, currentTimeMillis), i3, tPDownloadParam.getClipCount());
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            TPDownloadProxyNative.getInstance().setClipInfo(createDownloadTask, tPDownloadParam.getClipNo(), tPDownloadParam.buildKeyId(str, currentTimeMillis), i3, tPDownloadParam.getCdnUrls(), tPDownloadParam.getSavaPath(), tPDownloadParam.getExtraJsonInfo());
            TPListenerManager.getInstance().setPlayListener(createDownloadTask, iTPPlayListener);
            return createDownloadTask;
        } catch (Throwable th6) {
            th = th6;
            i16 = createDownloadTask;
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "startPlay failed, error:" + th);
            return i16;
        }
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public int startPreload(String str, TPDownloadParam tPDownloadParam, ITPPreLoadListener iTPPreLoadListener) {
        int i3 = -1;
        if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                int dlType = tPDownloadParam.getDlType() + 200;
                i3 = TPDownloadProxyNative.getInstance().createDownloadTask(this.mServiceType, str, dlType, tPDownloadParam.getClipCount());
                TPListenerManager.getInstance().setPreLoadListener(i3, iTPPreLoadListener);
                if (!TextUtils.isEmpty(tPDownloadParam.getKeyid())) {
                    str = tPDownloadParam.getKeyid();
                }
                TPDownloadProxyNative.getInstance().setClipInfo(i3, tPDownloadParam.getClipNo(), str, dlType, tPDownloadParam.getCdnUrls(), tPDownloadParam.getSavaPath(), tPDownloadParam.getExtraJsonInfo());
                TPDownloadProxyNative.getInstance().startDownload(i3);
            } catch (Throwable th5) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "startPreload failed, error:" + th5);
            }
        }
        return i3;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public void startTask(int i3) {
        if (i3 > 0 && TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                TPDownloadProxyNative.getInstance().startDownload(i3);
            } catch (Throwable th5) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "startTask failed, error:" + th5);
            }
        }
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public void stopOfflineDownload(int i3) {
        if (i3 > 0 && TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                TPDownloadProxyNative.getInstance().stopDownload(i3);
                TPListenerManager.getInstance().removeOfflineDownloadListener(i3);
            } catch (Throwable th5) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "stopOfflineDownload failed, error:" + th5);
            }
        }
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public void stopPlay(int i3) {
        if (i3 > 0 && TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                TPDownloadProxyNative.getInstance().stopDownload(i3);
                TPListenerManager.getInstance().removePlayListener(i3);
            } catch (Throwable th5) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "stopPlay failed, error:" + th5);
            }
        }
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public void stopPreload(int i3) {
        if (i3 > 0 && TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                TPDownloadProxyNative.getInstance().stopDownload(i3);
                TPListenerManager.getInstance().removePreLoadListener(i3);
            } catch (Throwable th5) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "stopPreload failed, error:" + th5);
            }
        }
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public void updateStoragePath(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.mCurrentStoragePath = str;
            TPDownloadProxyNative.getInstance().updateStoragePath(this.mServiceType, str);
        } catch (Throwable th5) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "updateStoragePath failed, error:" + th5);
        }
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public void updateTaskInfo(int i3, String str, Object obj) {
        if (i3 > 0 && TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                TPDownloadProxyNative.getInstance().updateTaskInfo(i3, str, obj.toString());
            } catch (Throwable th5) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "updateTaskInfo failed, error:" + th5);
            }
        }
    }
}
