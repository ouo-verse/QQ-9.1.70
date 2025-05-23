package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProAISearchGetSessionMsgListReq {
    public int fromType;
    public GProAISearchSessionTimeline sessionTimeLine = new GProAISearchSessionTimeline();
    public GProAISearchShareMsgPull shareMsgPull = new GProAISearchShareMsgPull();

    public int getFromType() {
        return this.fromType;
    }

    public GProAISearchSessionTimeline getSessionTimeLine() {
        return this.sessionTimeLine;
    }

    public GProAISearchShareMsgPull getShareMsgPull() {
        return this.shareMsgPull;
    }

    public String toString() {
        return "GProAISearchGetSessionMsgListReq{fromType=" + this.fromType + ",sessionTimeLine=" + this.sessionTimeLine + ",shareMsgPull=" + this.shareMsgPull + ",}";
    }
}
