package com.tencent.qqmini.sdk.launcher.core.proxy.va;

/* compiled from: P */
/* loaded from: classes23.dex */
public class VADownloadState {
    public static final int FLAG_AUTO_DOWNLOAD = 1;
    public static final int LAUNCH_MSG_LIST_MINI_GAME_VA_BANNER = 2123;
    public static final int START_TYPE_NORMAL = 0;
    public static final int START_TYPE_SPECIAL = 1;
    public static final int STATUS_DELETE = 10;
    public static final int STATUS_DOWNLOADED = 5;
    public static final int STATUS_DOWNLOADING = 2;
    public static final int STATUS_DOWNLOAD_START = 1;
    public static final int STATUS_FAILED = 6;
    public static final int STATUS_HOTFIXING = 1015;
    public static final int STATUS_INIT = 0;
    public static final int STATUS_INIT_CAN_UPDATE = 11;
    public static final int STATUS_INSTALLED = 9;
    public static final int STATUS_INTERRUPT = 8;
    public static final int STATUS_NEED_UPDATE = 7;
    public static final int STATUS_PAUSE = 4;
    public static final int STATUS_READY_TO_LAUNCH = 1016;
    public String gameId;
    public String gameVersionCode;
    public int downloadTypeOnWifi = 0;
    public int autoDownload = 1;
    public int downloadStatus = 0;
    public int progress = 0;
    public long pkgSize = 0;
    public long downloadSize = 0;
    public int downloadScene = 0;

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("VADownloadState{");
        stringBuffer.append("gameId='");
        stringBuffer.append(this.gameId);
        stringBuffer.append('\'');
        stringBuffer.append(", downloadTypeOnWifi=");
        stringBuffer.append(this.downloadTypeOnWifi);
        stringBuffer.append(", autoDownload=");
        stringBuffer.append(this.autoDownload);
        stringBuffer.append(", downloadStatus=");
        stringBuffer.append(this.downloadStatus);
        stringBuffer.append(", progress=");
        stringBuffer.append(this.progress);
        stringBuffer.append(", pkgSize=");
        stringBuffer.append(this.pkgSize);
        stringBuffer.append(", downloadSize=");
        stringBuffer.append(this.downloadSize);
        stringBuffer.append(", gameVersionCode='");
        stringBuffer.append(this.gameVersionCode);
        stringBuffer.append('\'');
        stringBuffer.append(", downloadScene=");
        stringBuffer.append(this.downloadScene);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
