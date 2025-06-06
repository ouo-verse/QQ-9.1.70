package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SearchDeviceInfo {
    public String guid = "";
    public boolean nightModeStatus;
    public int platform;
    public boolean studyModeStatus;

    public String getGuid() {
        return this.guid;
    }

    public boolean getNightModeStatus() {
        return this.nightModeStatus;
    }

    public int getPlatform() {
        return this.platform;
    }

    public boolean getStudyModeStatus() {
        return this.studyModeStatus;
    }

    public String toString() {
        return "SearchDeviceInfo{guid=" + this.guid + ",platform=" + this.platform + ",studyModeStatus=" + this.studyModeStatus + ",nightModeStatus=" + this.nightModeStatus + ",}";
    }
}
