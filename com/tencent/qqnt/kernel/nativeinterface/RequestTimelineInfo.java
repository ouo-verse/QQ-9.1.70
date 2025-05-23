package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class RequestTimelineInfo {
    public long requestInvokeTime;
    public long requestSendTime;
    public long responseCallbackTime;
    public long responseRecvTime;

    public long getRequestInvokeTime() {
        return this.requestInvokeTime;
    }

    public long getRequestSendTime() {
        return this.requestSendTime;
    }

    public long getResponseCallbackTime() {
        return this.responseCallbackTime;
    }

    public long getResponseRecvTime() {
        return this.responseRecvTime;
    }

    public void setRequestInvokeTime(long j3) {
        this.requestInvokeTime = j3;
    }

    public void setRequestSendTime(long j3) {
        this.requestSendTime = j3;
    }

    public void setResponseCallbackTime(long j3) {
        this.responseCallbackTime = j3;
    }

    public void setResponseRecvTime(long j3) {
        this.responseRecvTime = j3;
    }
}
