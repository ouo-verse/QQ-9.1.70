package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProAISearchGetSessionMsgListRsp {
    public long cookie;
    public boolean isFinished;
    public ArrayList<GProAISearchSessionMsg> sessionMsgList = new ArrayList<>();
    public String webCookie = "";
    public String sessionId = "";

    public long getCookie() {
        return this.cookie;
    }

    public boolean getIsFinished() {
        return this.isFinished;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public ArrayList<GProAISearchSessionMsg> getSessionMsgList() {
        return this.sessionMsgList;
    }

    public String getWebCookie() {
        return this.webCookie;
    }

    public String toString() {
        return "GProAISearchGetSessionMsgListRsp{sessionMsgList=" + this.sessionMsgList + ",cookie=" + this.cookie + ",isFinished=" + this.isFinished + ",webCookie=" + this.webCookie + ",sessionId=" + this.sessionId + ",}";
    }
}
