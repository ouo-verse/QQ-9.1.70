package com.tencent.qqnt.kernelgpro.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GproGetOpenShareInfoReq {
    public String linkUrl;
    public String queryStr;
    public int queryType;
    public String sessionId;

    public GproGetOpenShareInfoReq() {
        this.queryStr = "";
        this.linkUrl = "";
        this.sessionId = "";
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public String getQueryStr() {
        return this.queryStr;
    }

    public int getQueryType() {
        return this.queryType;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public void setLinkUrl(String str) {
        this.linkUrl = str;
    }

    public void setQueryStr(String str) {
        this.queryStr = str;
    }

    public void setQueryType(int i3) {
        this.queryType = i3;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }

    public String toString() {
        return "GproGetOpenShareInfoReq{queryStr=" + this.queryStr + ",linkUrl=" + this.linkUrl + ",sessionId=" + this.sessionId + ",queryType=" + this.queryType + ",}";
    }

    public GproGetOpenShareInfoReq(String str, String str2, String str3, int i3) {
        this.queryStr = str;
        this.linkUrl = str2;
        this.sessionId = str3;
        this.queryType = i3;
    }
}
