package com.tencent.qqmini.sdk.launcher.core.proxy;

import java.util.List;

/* loaded from: classes23.dex */
public abstract class WnsConfigProxy {
    public static final int DOWNLOAD_FILE_TYPE_OKHTTP = 3;
    public static final int DOWNLOAD_FILE_TYPE_QZONE = 1;

    public abstract List<String> getApiReportConfig();

    public abstract String getConfig(String str, String str2);

    public long getGameInnerTimeoutSetting(boolean z16) {
        if (z16) {
            return 60000L;
        }
        return 30000L;
    }

    public int getMiniFileDownloadType() {
        return 1;
    }

    public String getMiniGameEnginePackageConfig() {
        return null;
    }

    public abstract boolean getWebgl2Enable(String str, boolean z16);

    public abstract boolean isWebAudioEnable();

    public void loadConfigFromServer() {
    }

    public boolean getNotchIgnoreEnable(boolean z16) {
        return z16;
    }

    public boolean getToggleEnableStatus(String str, boolean z16) {
        return z16;
    }
}
