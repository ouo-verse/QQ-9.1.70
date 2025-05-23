package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class UfsCheckAIAuthReq {
    public long robotUin;
    public long timestamp;
    public String questionId = "";
    public String query = "";
    public String sign = "";

    public String getQuery() {
        return this.query;
    }

    public String getQuestionId() {
        return this.questionId;
    }

    public long getRobotUin() {
        return this.robotUin;
    }

    public String getSign() {
        return this.sign;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public String toString() {
        return "UfsCheckAIAuthReq{questionId=" + this.questionId + ",query=" + this.query + ",sign=" + this.sign + ",timestamp=" + this.timestamp + ",robotUin=" + this.robotUin + ",}";
    }
}
