package com.tencent.qqnt.kernel.nativeinterface;

import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SetServiceAssistantSwitchReq {
    public Long appId;
    public Integer appType;
    public int msgSwitch;
    public int msgType;
    public HashMap<String, Integer> templateMap;

    public SetServiceAssistantSwitchReq() {
        this.templateMap = new HashMap<>();
    }

    public Long getAppId() {
        return this.appId;
    }

    public Integer getAppType() {
        return this.appType;
    }

    public int getMsgSwitch() {
        return this.msgSwitch;
    }

    public int getMsgType() {
        return this.msgType;
    }

    public HashMap<String, Integer> getTemplateMap() {
        return this.templateMap;
    }

    public SetServiceAssistantSwitchReq(int i3, int i16, Integer num, Long l3, HashMap<String, Integer> hashMap) {
        new HashMap();
        this.msgSwitch = i3;
        this.msgType = i16;
        this.appType = num;
        this.appId = l3;
        this.templateMap = hashMap;
    }
}
