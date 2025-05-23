package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GetServiceAssistantSwitchReq {
    public Long appId;
    public Integer appType;
    public int msgType;

    public GetServiceAssistantSwitchReq() {
    }

    public Long getAppId() {
        return this.appId;
    }

    public Integer getAppType() {
        return this.appType;
    }

    public int getMsgType() {
        return this.msgType;
    }

    public GetServiceAssistantSwitchReq(int i3, Integer num, Long l3) {
        this.msgType = i3;
        this.appType = num;
        this.appId = l3;
    }
}
