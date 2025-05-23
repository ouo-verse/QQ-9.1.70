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
import com.tencent.thumbplayer.core.datatransport.api.TPDataTransportEnum;
import com.tencent.thumbplayer.core.downloadproxy.apiinner.TPListenerManager;
import com.tencent.thumbplayer.core.downloadproxy.jni.TPDownloadProxyNative;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLFileSystem;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyLog;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyUtils;
import java.io.File;

/* loaded from: classes26.dex */
public class TPDownloadProxyProcessAdapter implements ITPDownloadProxy {
    private static final String FILE_NAME = "TPDownloadProxyProcessAdapters";
    private final int mServiceType;
    private String mCurrentStoragePath = "";
    private boolean mIsInit = false;
    private Context mContext = null;

    public TPDownloadProxyProcessAdapter(int i3) {
        this.mServiceType = i3;
        TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "Construct TPDownloadProxy, serviceType:" + i3);
    }

    private void getCellularNetwork(Context context) {
        if (context == null) {
            TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "cellular_network, context is null, can not set interface 4g");
            return;
        }
        NetworkRequest.Builder builder = new NetworkRequest.Builder();
        builder.addCapability(12);
        builder.addTransportType(0);
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "cellular_network, connectivityManager is null, can not set interface 4g");
        } else {
            connectivityManager.requestNetwork(builder.build(), new ConnectivityManager.NetworkCallback() { // from class: com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyProcessAdapter.1
                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onAvailable(Network network) {
                    super.onAvailable(network);
                    TPListenerManager.getInstance().setNetwork(network);
                    long networkHandle = network.getNetworkHandle();
                    TPDLProxyLog.i(TPDownloadProxyProcessAdapter.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "cellular_network, net_id_t: " + networkHandle);
                    TPDownloadProxyProcessAdapter.this.setUserData("cellular_interface_id", Long.valueOf(networkHandle));
                }

                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onLost(Network network) {
                    super.onLost(network);
                    TPDownloadProxyProcessAdapter.this.setUserData("cellular_interface_id", 0);
                    TPDLProxyLog.i(TPDownloadProxyProcessAdapter.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "cellular_network failed");
                }
            });
        }
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public long GetTotalMemorySizeKB() {
        if (TPDownloadProxyFactory.isServiceBinding(this.mServiceType)) {
            return TPDownloadProxyFactory.getTPDownloadProxy(this.mServiceType).GetTotalMemorySizeKB();
        }
        return 0L;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public int checkResourceStatus(String str, String str2, int i3) {
        if (TPDownloadProxyFactory.isServiceBinding(this.mServiceType)) {
            return TPDownloadProxyFactory.getTPDownloadProxy(this.mServiceType).checkResourceStatus(str, str2, i3);
        }
        return -1;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public int clearCache(String str, String str2, int i3) {
        if (TPDownloadProxyFactory.isServiceBinding(this.mServiceType)) {
            return TPDownloadProxyFactory.getTPDownloadProxy(this.mServiceType).clearCache(str, str2, i3);
        }
        return -1;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public int clearRangeCache(String str, int i3, int i16) {
        if (TPDownloadProxyFactory.isServiceBinding(this.mServiceType)) {
            return TPDownloadProxyFactory.getTPDownloadProxy(this.mServiceType).clearRangeCache(str, i3, i16);
        }
        return -1;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public int deinit() {
        if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                this.mIsInit = false;
                return TPDownloadProxyNative.getInstance().deInitService(this.mServiceType);
            } catch (Throwable th5) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "deinit failed, error:" + th5);
                return -1;
            }
        }
        return -1;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public String getClipPlayUrl(int i3, int i16, int i17) {
        if (TPDownloadProxyFactory.isServiceBinding(this.mServiceType)) {
            return TPDownloadProxyFactory.getTPDownloadProxy(this.mServiceType).getClipPlayUrl(i3, i16, i17);
        }
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
        if (TPDownloadProxyFactory.isServiceBinding(this.mServiceType)) {
            return TPDownloadProxyFactory.getTPDownloadProxy(this.mServiceType).getDownloadProxyInfo(i3, obj, obj2, obj3);
        }
        return null;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public String getNativeInfo(int i3) {
        if (TPDownloadProxyFactory.isServiceBinding(this.mServiceType)) {
            return TPDownloadProxyFactory.getTPDownloadProxy(this.mServiceType).getNativeInfo(i3);
        }
        return null;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public String getPlayErrorCodeStr(int i3) {
        if (TPDownloadProxyFactory.isServiceBinding(this.mServiceType)) {
            return TPDownloadProxyFactory.getTPDownloadProxy(this.mServiceType).getPlayErrorCodeStr(i3);
        }
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
        if (TPDownloadProxyFactory.isServiceBinding(this.mServiceType)) {
            return TPDownloadProxyFactory.getTPDownloadProxy(this.mServiceType).getPlayUrl(i3, i16);
        }
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
        if (TPDownloadProxyFactory.isServiceBinding(this.mServiceType)) {
            return TPDownloadProxyFactory.getTPDownloadProxy(this.mServiceType).getResourceSize(str, str2);
        }
        return -1L;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public int init(Context context, TPDLProxyInitParam tPDLProxyInitParam) {
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
                    initService = TPDownloadProxyNative.getInstance().initService(this.mServiceType, str, this.mCurrentStoragePath, TPDataTransportEnum.GLOBAL_OPTIONAL_CONFIG_PARAM_LIMIT_MODE);
                } else {
                    if (!TextUtils.isEmpty(tPDLProxyInitParam.getDataDir())) {
                        this.mCurrentStoragePath = tPDLProxyInitParam.getDataDir();
                    }
                    initService = TPDownloadProxyNative.getInstance().initService(this.mServiceType, str, tPDLProxyInitParam.getDataDir(), TPDataTransportEnum.GLOBAL_OPTIONAL_CONFIG_PARAM_LIMIT_MODE);
                }
                setUserData("device_model", DeviceInfoMonitor.getModel());
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_OFF);
                intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_ON);
                intentFilter.addAction("android.intent.action.USER_PRESENT");
                BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyProcessAdapter.2
                    @Override // android.content.BroadcastReceiver
                    public void onReceive(Context context2, Intent intent) {
                        String action = intent.getAction();
                        if (IECScreenReceiver.ACTION_SCREEN_OFF.equals(action)) {
                            TPDownloadProxyProcessAdapter.this.pushEvent(20);
                        } else if (IECScreenReceiver.ACTION_SCREEN_ON.equals(action)) {
                            TPDownloadProxyProcessAdapter.this.pushEvent(19);
                        }
                    }
                };
                if (context != null) {
                    context.registerReceiver(broadcastReceiver, intentFilter);
                }
                if (initService == 0) {
                    this.mIsInit = true;
                }
                this.mContext = context;
                return initService;
            } catch (Throwable th6) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "init failed, error:" + th6);
                return -1;
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
        if (TPDownloadProxyFactory.isServiceBinding(this.mServiceType)) {
            return TPDownloadProxyFactory.getTPDownloadProxy(this.mServiceType).pauseDownload(i3);
        }
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
        if (TPDownloadProxyFactory.isServiceBinding(this.mServiceType)) {
            TPDownloadProxyFactory.getTPDownloadProxy(this.mServiceType).pushEvent(i3);
            return;
        }
        if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                TPDownloadProxyNative.getInstance().pushEvent(i3);
                if (9 == i3) {
                    TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "cellular_network, update net interface info");
                    getCellularNetwork(this.mContext);
                }
            } catch (Throwable th5) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "cellular_network pushEvent failed, error:" + th5);
            }
        }
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public int removeStorageCache(String str) {
        if (TPDownloadProxyFactory.isServiceBinding(this.mServiceType)) {
            return TPDownloadProxyFactory.getTPDownloadProxy(this.mServiceType).removeStorageCache(str);
        }
        return -1;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public int resumeDownload(int i3) {
        if (TPDownloadProxyFactory.isServiceBinding(this.mServiceType)) {
            return TPDownloadProxyFactory.getTPDownloadProxy(this.mServiceType).resumeDownload(i3);
        }
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
        if (TPDownloadProxyFactory.isServiceBinding(this.mServiceType)) {
            TPDownloadProxyFactory.getTPDownloadProxy(this.mServiceType).setBusinessDownloadStrategy(i3, i16, i17, i18, i19);
        }
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public boolean setClipInfo(int i3, int i16, String str, TPDownloadParam tPDownloadParam) {
        if (TPDownloadProxyFactory.isServiceBinding(this.mServiceType)) {
            return TPDownloadProxyFactory.getTPDownloadProxy(this.mServiceType).setClipInfo(i3, i16, str, tPDownloadParam);
        }
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
        if (TPDownloadProxyFactory.isServiceBinding(this.mServiceType)) {
            TPDownloadProxyFactory.getTPDownloadProxy(this.mServiceType).setMaxStorageSizeMB(j3);
        }
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public void setPlayState(int i3, int i16) {
        if (TPDownloadProxyFactory.isServiceBinding(this.mServiceType)) {
            TPDownloadProxyFactory.getTPDownloadProxy(this.mServiceType).setPlayState(i3, i16);
            return;
        }
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
        if (TPDownloadProxyFactory.isServiceBinding(this.mServiceType)) {
            TPDownloadProxyFactory.getTPDownloadProxy(this.mServiceType).setUserData(str, obj);
            return;
        }
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
        if (TPDownloadProxyFactory.isServiceBinding(this.mServiceType)) {
            return TPDownloadProxyFactory.getTPDownloadProxy(this.mServiceType).startClipOfflineDownload(str, i3, iTPOfflineDownloadListener);
        }
        return -1;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public int startClipPlay(String str, int i3, ITPPlayListener iTPPlayListener) {
        if (TPDownloadProxyFactory.isServiceBinding(this.mServiceType)) {
            return TPDownloadProxyFactory.getTPDownloadProxy(this.mServiceType).startClipPlay(str, i3, iTPPlayListener);
        }
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
        if (TPDownloadProxyFactory.isServiceBinding(this.mServiceType)) {
            return TPDownloadProxyFactory.getTPDownloadProxy(this.mServiceType).startClipPreload(str, i3, iTPPreLoadListener);
        }
        return -1;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public int startOfflineDownload(String str, TPDownloadParam tPDownloadParam, ITPOfflineDownloadListener iTPOfflineDownloadListener) {
        if (TPDownloadProxyFactory.isServiceBinding(this.mServiceType)) {
            return TPDownloadProxyFactory.getTPDownloadProxy(this.mServiceType).startOfflineDownload(str, tPDownloadParam, iTPOfflineDownloadListener);
        }
        return -1;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public int startPlay(String str, TPDownloadParam tPDownloadParam, ITPPlayListener iTPPlayListener) {
        if (TPDownloadProxyFactory.isServiceBinding(this.mServiceType)) {
            if (this.mIsInit) {
                deinit();
            }
            return TPDownloadProxyFactory.getTPDownloadProxy(this.mServiceType).startPlay(str, tPDownloadParam, iTPPlayListener);
        }
        int dlType = tPDownloadParam.getDlType();
        if (iTPPlayListener != null) {
            tPDownloadParam.getExtInfoMap().put("dl_param_adv_remain_time", Long.valueOf(iTPPlayListener.getAdvRemainTime() / 1000));
        }
        if (tPDownloadParam.isOffline()) {
            dlType += 300;
        }
        int i3 = -1;
        if (!TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            return -1;
        }
        try {
            if (tPDownloadParam.isAdaptive() && (dlType == 3 || dlType == 5)) {
                dlType += 400;
            }
            int i16 = dlType;
            long currentTimeMillis = System.currentTimeMillis();
            i3 = TPDownloadProxyNative.getInstance().createDownloadTask(this.mServiceType, tPDownloadParam.buildFileId(str, currentTimeMillis), i16, tPDownloadParam.getClipCount());
            TPDownloadProxyNative.getInstance().setClipInfo(i3, tPDownloadParam.getClipNo(), tPDownloadParam.buildKeyId(str, currentTimeMillis), i16, tPDownloadParam.getCdnUrls(), tPDownloadParam.getSavaPath(), tPDownloadParam.getExtraJsonInfo());
            TPListenerManager.getInstance().setPlayListener(i3, iTPPlayListener);
            return i3;
        } catch (Throwable th5) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "startPlay failed, error:" + th5);
            return i3;
        }
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public int startPreload(String str, TPDownloadParam tPDownloadParam, ITPPreLoadListener iTPPreLoadListener) {
        if (TPDownloadProxyFactory.isServiceBinding(this.mServiceType)) {
            return TPDownloadProxyFactory.getTPDownloadProxy(this.mServiceType).startPreload(str, tPDownloadParam, iTPPreLoadListener);
        }
        return -1;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public void startTask(int i3) {
        if (TPDownloadProxyFactory.isServiceBinding(this.mServiceType)) {
            TPDownloadProxyFactory.getTPDownloadProxy(this.mServiceType).startTask(i3);
        }
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public void stopOfflineDownload(int i3) {
        if (TPDownloadProxyFactory.isServiceBinding(this.mServiceType)) {
            TPDownloadProxyFactory.getTPDownloadProxy(this.mServiceType).stopOfflineDownload(i3);
        }
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public void stopPlay(int i3) {
        if (TPDownloadProxyFactory.isServiceBinding(this.mServiceType)) {
            TPDownloadProxyFactory.getTPDownloadProxy(this.mServiceType).stopPlay(i3);
            return;
        }
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
        if (TPDownloadProxyFactory.isServiceBinding(this.mServiceType)) {
            TPDownloadProxyFactory.getTPDownloadProxy(this.mServiceType).stopPreload(i3);
        }
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public void updateStoragePath(String str) {
        if (TPDownloadProxyFactory.isServiceBinding(this.mServiceType)) {
            TPDownloadProxyFactory.getTPDownloadProxy(this.mServiceType).updateStoragePath(str);
        }
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public void updateTaskInfo(int i3, String str, Object obj) {
        if (TPDownloadProxyFactory.isServiceBinding(this.mServiceType)) {
            TPDownloadProxyFactory.getTPDownloadProxy(this.mServiceType).updateTaskInfo(i3, str, obj);
            return;
        }
        if (i3 > 0 && TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                TPDownloadProxyNative.getInstance().updateTaskInfo(i3, str, obj.toString());
            } catch (Throwable th5) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "updateTaskInfo failed, error:" + th5);
            }
        }
    }
}
