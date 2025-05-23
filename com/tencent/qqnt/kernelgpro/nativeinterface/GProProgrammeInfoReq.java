package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProProgrammeInfoReq {
    public String programmeId;
    public int tabType;

    public GProProgrammeInfoReq() {
        this.programmeId = "";
    }

    public String getProgrammeId() {
        return this.programmeId;
    }

    public int getTabType() {
        return this.tabType;
    }

    public String toString() {
        return "GProProgrammeInfoReq{programmeId=" + this.programmeId + ",tabType=" + this.tabType + ",}";
    }

    public GProProgrammeInfoReq(String str, int i3) {
        this.programmeId = str;
        this.tabType = i3;
    }
}
