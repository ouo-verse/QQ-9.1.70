package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProVerifyShareInfoReq {
    public String inviteCode = "";
    public String contentId = "";
    public String shortUrl = "";
    public GProVerifyShareInfoFilter filter = new GProVerifyShareInfoFilter();

    public String getContentId() {
        return this.contentId;
    }

    public GProVerifyShareInfoFilter getFilter() {
        return this.filter;
    }

    public String getInviteCode() {
        return this.inviteCode;
    }

    public String getShortUrl() {
        return this.shortUrl;
    }

    public String toString() {
        return "GProVerifyShareInfoReq{inviteCode=" + this.inviteCode + ",contentId=" + this.contentId + ",shortUrl=" + this.shortUrl + ",filter=" + this.filter + ",}";
    }
}
