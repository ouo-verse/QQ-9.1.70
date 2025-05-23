package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProAISearchSession {
    public int isDeleted;
    public int sessionStatus;
    public long timestamp;
    public long updateTimestamp;
    public String sessionId = "";
    public String firstMsgId = "";
    public String summary = "";

    public String getFirstMsgId() {
        return this.firstMsgId;
    }

    public int getIsDeleted() {
        return this.isDeleted;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public int getSessionStatus() {
        return this.sessionStatus;
    }

    public String getSummary() {
        return this.summary;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public long getUpdateTimestamp() {
        return this.updateTimestamp;
    }

    public String toString() {
        return "GProAISearchSession{sessionId=" + this.sessionId + ",firstMsgId=" + this.firstMsgId + ",summary=" + this.summary + ",timestamp=" + this.timestamp + ",isDeleted=" + this.isDeleted + ",updateTimestamp=" + this.updateTimestamp + ",sessionStatus=" + this.sessionStatus + ",}";
    }
}
