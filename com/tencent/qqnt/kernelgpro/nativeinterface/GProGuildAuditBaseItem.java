package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProGuildAuditBaseItem implements Serializable {
    public long auditAuthor;
    public long auditContentNum;
    public long auditTime;
    public int status;
    public int type;
    long serialVersionUID = 1;
    public String auditContentStr = "";
    public String byteBeatReasonStr = "";
    public String msgId = "";
    public String byteAuditTitleStr = "";
    public String ruleMd5 = "";

    public long getAuditAuthor() {
        return this.auditAuthor;
    }

    public long getAuditContentNum() {
        return this.auditContentNum;
    }

    public String getAuditContentStr() {
        return this.auditContentStr;
    }

    public long getAuditTime() {
        return this.auditTime;
    }

    public String getByteAuditTitleStr() {
        return this.byteAuditTitleStr;
    }

    public String getByteBeatReasonStr() {
        return this.byteBeatReasonStr;
    }

    public String getMsgId() {
        return this.msgId;
    }

    public String getRuleMd5() {
        return this.ruleMd5;
    }

    public int getStatus() {
        return this.status;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "GProGuildAuditBaseItem{status=" + this.status + ",type=" + this.type + ",auditTime=" + this.auditTime + ",auditAuthor=" + this.auditAuthor + ",auditContentNum=" + this.auditContentNum + ",auditContentStr=" + this.auditContentStr + ",byteBeatReasonStr=" + this.byteBeatReasonStr + ",msgId=" + this.msgId + ",byteAuditTitleStr=" + this.byteAuditTitleStr + ",ruleMd5=" + this.ruleMd5 + ",}";
    }
}
