package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProAISearchMsgShareData {
    public String sessionId = "";
    public ArrayList<GProAISearchMsgWithFold> msgList = new ArrayList<>();

    public ArrayList<GProAISearchMsgWithFold> getMsgList() {
        return this.msgList;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public String toString() {
        return "GProAISearchMsgShareData{sessionId=" + this.sessionId + ",msgList=" + this.msgList + ",}";
    }
}
