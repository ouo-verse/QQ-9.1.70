package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProStWearingMedalInfo {
    public int type;
    public String medalName = "";
    public String medalID = "";

    public String getMedalID() {
        return this.medalID;
    }

    public String getMedalName() {
        return this.medalName;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "GProStWearingMedalInfo{type=" + this.type + ",medalName=" + this.medalName + ",medalID=" + this.medalID + ",}";
    }
}
