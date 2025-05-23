package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class ReplyMsgWithSourceMsgInfoResult {
    public String errMsg = "";
    public long replyMsgId;
    public int result;

    public String getErrMsg() {
        return this.errMsg;
    }

    public long getReplyMsgId() {
        return this.replyMsgId;
    }

    public int getResult() {
        return this.result;
    }

    public String toString() {
        return "ReplyMsgWithSourceMsgInfoResult{result=" + this.result + ",errMsg=" + this.errMsg + ",replyMsgId=" + this.replyMsgId + ",}";
    }
}
