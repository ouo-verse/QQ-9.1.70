package com.tencent.mobileqq.zplan.smallhome.status;

import com.tencent.mobileqq.vas.theme.ThemeReporter;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010?\u001a\u00020\u0003J\b\u0010@\u001a\u00020\u0003H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0004R\u001a\u0010\u0015\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0004R\u001a\u0010\u0018\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0013\"\u0004\b\u001a\u0010\u0004R\u001a\u0010\u001b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000e\"\u0004\b\u001d\u0010\u0010R\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0013\"\u0004\b&\u0010\u0004R\u001a\u0010'\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0013\"\u0004\b)\u0010\u0004R\u001a\u0010*\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0013\"\u0004\b,\u0010\u0004R\u001a\u0010-\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0013\"\u0004\b/\u0010\u0004R\u001a\u00100\u001a\u000201X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u00102\"\u0004\b3\u00104R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u0010\u0013R\u001a\u00106\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0013\"\u0004\b8\u0010\u0004R\u001a\u00109\u001a\u00020:X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/zplan/smallhome/status/ZPlanModLoadStatusInfo;", "Ljava/io/Serializable;", "mapId", "", "(Ljava/lang/String;)V", "downloadProgress", "", "getDownloadProgress", "()F", "setDownloadProgress", "(F)V", "downloadReceivedBytes", "", "getDownloadReceivedBytes", "()J", "setDownloadReceivedBytes", "(J)V", "downloadTaskUrl", "getDownloadTaskUrl", "()Ljava/lang/String;", "setDownloadTaskUrl", "downloadTips1", "getDownloadTips1", "setDownloadTips1", "downloadTips2", "getDownloadTips2", "setDownloadTips2", "downloadTotalBytes", "getDownloadTotalBytes", "setDownloadTotalBytes", "errCode", "", "getErrCode", "()I", "setErrCode", "(I)V", "errMsg", "getErrMsg", "setErrMsg", "gameVersion1", "getGameVersion1", "setGameVersion1", "gameVersion2", "getGameVersion2", "setGameVersion2", "gameVersion3", "getGameVersion3", "setGameVersion3", "isFromGame", "", "()Z", "setFromGame", "(Z)V", "getMapId", "mapVersion", "getMapVersion", "setMapVersion", "status", "Lcom/tencent/mobileqq/zplan/smallhome/status/ZPlanModLoadStatus;", ThemeReporter.BUNDLE_KEY_TASK_GET_STATUS, "()Lcom/tencent/mobileqq/zplan/smallhome/status/ZPlanModLoadStatus;", "setStatus", "(Lcom/tencent/mobileqq/zplan/smallhome/status/ZPlanModLoadStatus;)V", "printSimpleInfo", "toString", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class ZPlanModLoadStatusInfo implements Serializable {
    private float downloadProgress;
    private long downloadReceivedBytes;
    private String downloadTaskUrl;
    private String downloadTips1;
    private String downloadTips2;
    private long downloadTotalBytes;
    private int errCode;
    private String errMsg;
    private String gameVersion1;
    private String gameVersion2;
    private String gameVersion3;
    private boolean isFromGame;
    private final String mapId;
    private String mapVersion;
    private ZPlanModLoadStatus status;

    public ZPlanModLoadStatusInfo(String mapId) {
        Intrinsics.checkNotNullParameter(mapId, "mapId");
        this.mapId = mapId;
        this.status = ZPlanModLoadStatus.Init;
        this.errMsg = "";
        this.downloadTaskUrl = "";
        this.mapVersion = "";
        this.downloadTips1 = "";
        this.downloadTips2 = "";
        this.gameVersion1 = "";
        this.gameVersion2 = "";
        this.gameVersion3 = "";
    }

    public final float getDownloadProgress() {
        return this.downloadProgress;
    }

    public final long getDownloadReceivedBytes() {
        return this.downloadReceivedBytes;
    }

    public final String getDownloadTaskUrl() {
        return this.downloadTaskUrl;
    }

    public final String getDownloadTips1() {
        return this.downloadTips1;
    }

    public final String getDownloadTips2() {
        return this.downloadTips2;
    }

    public final long getDownloadTotalBytes() {
        return this.downloadTotalBytes;
    }

    public final int getErrCode() {
        return this.errCode;
    }

    public final String getErrMsg() {
        return this.errMsg;
    }

    public final String getGameVersion1() {
        return this.gameVersion1;
    }

    public final String getGameVersion2() {
        return this.gameVersion2;
    }

    public final String getGameVersion3() {
        return this.gameVersion3;
    }

    public final String getMapId() {
        return this.mapId;
    }

    public final String getMapVersion() {
        return this.mapVersion;
    }

    public final ZPlanModLoadStatus getStatus() {
        return this.status;
    }

    /* renamed from: isFromGame, reason: from getter */
    public final boolean getIsFromGame() {
        return this.isFromGame;
    }

    public final String printSimpleInfo() {
        return "ZPlanModLoadStatusInfo(mapId= " + this.mapId + ", status= " + this.status + ", errCode:" + this.errCode + ", errMsg:" + this.errMsg + ", downloadTaskUrl:" + this.downloadTaskUrl + ")";
    }

    public final void setDownloadProgress(float f16) {
        this.downloadProgress = f16;
    }

    public final void setDownloadReceivedBytes(long j3) {
        this.downloadReceivedBytes = j3;
    }

    public final void setDownloadTaskUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.downloadTaskUrl = str;
    }

    public final void setDownloadTips1(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.downloadTips1 = str;
    }

    public final void setDownloadTips2(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.downloadTips2 = str;
    }

    public final void setDownloadTotalBytes(long j3) {
        this.downloadTotalBytes = j3;
    }

    public final void setErrCode(int i3) {
        this.errCode = i3;
    }

    public final void setErrMsg(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.errMsg = str;
    }

    public final void setFromGame(boolean z16) {
        this.isFromGame = z16;
    }

    public final void setGameVersion1(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.gameVersion1 = str;
    }

    public final void setGameVersion2(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.gameVersion2 = str;
    }

    public final void setGameVersion3(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.gameVersion3 = str;
    }

    public final void setMapVersion(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mapVersion = str;
    }

    public final void setStatus(ZPlanModLoadStatus zPlanModLoadStatus) {
        Intrinsics.checkNotNullParameter(zPlanModLoadStatus, "<set-?>");
        this.status = zPlanModLoadStatus;
    }

    public String toString() {
        return printSimpleInfo();
    }
}
