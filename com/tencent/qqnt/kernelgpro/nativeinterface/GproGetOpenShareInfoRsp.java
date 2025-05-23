package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GproGetOpenShareInfoRsp implements Serializable {
    public String fileId;
    public String queryStr;
    long serialVersionUID;
    public String sessionId;

    public GproGetOpenShareInfoRsp() {
        this.serialVersionUID = 1L;
        this.sessionId = "";
        this.fileId = "";
        this.queryStr = "";
    }

    public String getFileId() {
        return this.fileId;
    }

    public String getQueryStr() {
        return this.queryStr;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public String toString() {
        return "GproGetOpenShareInfoRsp{sessionId=" + this.sessionId + ",fileId=" + this.fileId + ",queryStr=" + this.queryStr + ",}";
    }

    public GproGetOpenShareInfoRsp(String str, String str2, String str3) {
        this.serialVersionUID = 1L;
        this.sessionId = str;
        this.fileId = str2;
        this.queryStr = str3;
    }
}
