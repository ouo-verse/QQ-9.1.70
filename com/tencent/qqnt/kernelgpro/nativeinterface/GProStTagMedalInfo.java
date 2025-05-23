package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProStTagMedalInfo implements Serializable {
    public long rank;
    long serialVersionUID = 1;
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
        return "GProStTagMedalInfo{tagID=" + this.tagID + ",tagName=" + this.tagName + ",rank=" + this.rank + ",}";
    }
}
