package com.tencent.qqmini.sdk.launcher.core.proxy.va;

import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

/* loaded from: classes23.dex */
public abstract class VirtualAppProxy {
    public static final String KEY_APP_ID = "appId";
    public static final String KEY_AUTO_DOWNLOAD = "autoDownload";
    public static final String KEY_DOWNLOAD_SCENE = "downloadScene";
    public static final String KEY_DOWNLOAD_SIZE = "downloadSize";
    public static final String KEY_DOWNLOAD_STATUS = "downloadStatus";
    public static final String KEY_DOWNLOAD_TYPE_ON_WIFI = "downloadTypeOnWifi";
    public static final String KEY_ERROR_CODE = "errorCode";
    public static final String KEY_GAME_ID = "gameId";
    public static final String KEY_GAME_VERSION_CODE = "gameVersionCode";
    public static final String KEY_PKG_SIZE = "pkgSize";
    public static final String KEY_PROGRESS = "progress";

    public boolean getDualChannelDownloadSwitch() {
        return false;
    }

    public VACustomTextConfig getVACustomTextConfig() {
        return new VACustomTextConfig();
    }

    public boolean queryDownloadIgnoreGameEvent(String str) {
        return false;
    }

    public void startDownload(String str, boolean z16, ProxyCallback proxyCallback) {
    }

    public void startDownload(String str, ProxyCallback proxyCallback) {
        startDownload(str, true, proxyCallback);
    }

    public void pauseHotfixDownload(String str) {
    }

    public void recordWifiAutoDownloadVAFlag(String str) {
    }

    public void startHotfixDownload(String str) {
    }

    public void stopHotfixDownload(String str) {
    }

    public void updateDualChannelDownloadSwitch(boolean z16) {
    }

    public void cancelDownload(String str, ProxyCallback proxyCallback) {
    }

    public void getDanmakuList(String str, IDanmakuLoadListener iDanmakuLoadListener) {
    }

    public void queryDownloadState(String str, ProxyCallback proxyCallback) {
    }

    public void removeDownloadListener(String str, OnVADownloadListener onVADownloadListener) {
    }

    public void stopDownload(String str, ProxyCallback proxyCallback) {
    }

    public void unregisterHotfixDownloadCallback(String str, IHotfixloadListener iHotfixloadListener) {
    }

    public void addDownloadListener(String str, MiniAppInfo miniAppInfo, OnVADownloadListener onVADownloadListener) {
    }

    public void registerHotfixDownloadCallback(String str, MiniAppInfo miniAppInfo, IHotfixloadListener iHotfixloadListener) {
    }

    public void restartVirtualApp(String str, String str2, ProxyCallback proxyCallback) {
    }

    public void notifyHotfixDownloadChange(String str, int i3, int i16, long j3, int i17) {
    }

    public void notifyDownloadChange(String str, int i3, int i16, long j3, long j16, String str2) {
    }
}
