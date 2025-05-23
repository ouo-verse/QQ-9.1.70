package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProAISearchSessionTimeline {
    public long cookie;
    public int pullDirection;
    public String sessionId = "";

    public long getCookie() {
        return this.cookie;
    }

    public int getPullDirection() {
        return this.pullDirection;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public String toString() {
        return "GProAISearchSessionTimeline{sessionId=" + this.sessionId + ",cookie=" + this.cookie + ",pullDirection=" + this.pullDirection + ",}";
    }
}
