package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProFetchShareUrlRsp {
    public boolean canShare;
    public String shareLink = "";
    public String attaContentId = "";

    public String getAttaContentId() {
        return this.attaContentId;
    }

    public boolean getCanShare() {
        return this.canShare;
    }

    public String getShareLink() {
        return this.shareLink;
    }

    public String toString() {
        return "GProFetchShareUrlRsp{canShare=" + this.canShare + ",shareLink=" + this.shareLink + ",attaContentId=" + this.attaContentId + ",}";
    }
}
