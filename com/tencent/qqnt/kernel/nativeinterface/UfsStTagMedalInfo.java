package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class UfsStTagMedalInfo {
    public long rank;
    public String tagID = "";
    public String tagName = "";

    public long getRank() {
        return this.rank;
    }

    public String getTagID() {
        return this.tagID;
    }

    public String getTagName() {
        return this.tagName;
    }

    public String toString() {
        return "UfsStTagMedalInfo{tagID=" + this.tagID + ",tagName=" + this.tagName + ",rank=" + this.rank + ",}";
    }
}
