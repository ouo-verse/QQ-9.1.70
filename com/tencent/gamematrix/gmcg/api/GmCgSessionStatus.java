package com.tencent.gamematrix.gmcg.api;

/* compiled from: P */
/* loaded from: classes6.dex */
public enum GmCgSessionStatus {
    StatusSessionStart(0, "Start", "\u5f00\u59cb"),
    StatusSessionPrepareCGData(1, "PrepareCloudGameData", "\u51c6\u5907\u4e91\u6e38\u620f\u6570\u636e"),
    StatusSessionWaitingCGData(2, "WaitingCloudGameData", "\u7b49\u5f85\u4e91\u6e38\u620f\u6570\u636e"),
    StatusSessionReadyCGData(3, "CloudGameDataReady", "\u5b8c\u6210\u4e91\u6e38\u620f\u6570\u636e"),
    StatusSessionStartLaunchCloudGame(4, "DeviceAllocated", "\u51c6\u5907\u542f\u52a8\u4e91\u7aef\u6e38\u620f"),
    StatusSessionWaitingLaunchCloudGame(5, "DeviceAllocated", "\u7b49\u5f85\u4e91\u7aef\u6e38\u620f\u542f\u52a8\u4e2d"),
    StatusSessionFinishLaunchCloudGame(6, "DeviceAllocated", "\u4e91\u7aef\u6e38\u620f\u542f\u52a8\u5b8c\u6210");

    private final int mStatusCode;
    private final String mStatusDesc;
    private final String mStatusName;

    GmCgSessionStatus(int i3, String str, String str2) {
        this.mStatusCode = i3;
        this.mStatusName = str;
        this.mStatusDesc = str2;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }

    public String getStatusDesc() {
        return this.mStatusDesc;
    }

    public String getStatusName() {
        return this.mStatusName;
    }

    public boolean is(GmCgSessionStatus gmCgSessionStatus) {
        if (this.mStatusCode == gmCgSessionStatus.mStatusCode) {
            return true;
        }
        return false;
    }

    public boolean not(GmCgSessionStatus gmCgSessionStatus) {
        if (this.mStatusCode != gmCgSessionStatus.mStatusCode) {
            return true;
        }
        return false;
    }
}
