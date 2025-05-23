package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupClassInfo {
    public long firstClassId;
    public long secClassId;
    public String firstClassTxt = "";
    public String secClassTxt = "";

    public long getFirstClassId() {
        return this.firstClassId;
    }

    public String getFirstClassTxt() {
        return this.firstClassTxt;
    }

    public long getSecClassId() {
        return this.secClassId;
    }

    public String getSecClassTxt() {
        return this.secClassTxt;
    }

    public String toString() {
        return "GroupClassInfo{firstClassId=" + this.firstClassId + ",firstClassTxt=" + this.firstClassTxt + ",secClassId=" + this.secClassId + ",secClassTxt=" + this.secClassTxt + ",}";
    }
}
