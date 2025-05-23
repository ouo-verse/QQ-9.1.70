package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProStFeedListHeaderInfo {
    public GProStImage headPic = new GProStImage();
    public String feedCountDesc = "";
    public String joinDesc = "";

    public String getFeedCountDesc() {
        return this.feedCountDesc;
    }

    public GProStImage getHeadPic() {
        return this.headPic;
    }

    public String getJoinDesc() {
        return this.joinDesc;
    }

    public String toString() {
        return "GProStFeedListHeaderInfo{headPic=" + this.headPic + ",feedCountDesc=" + this.feedCountDesc + ",joinDesc=" + this.joinDesc + ",}";
    }
}
