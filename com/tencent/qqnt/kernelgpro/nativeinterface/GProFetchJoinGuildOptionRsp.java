package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProFetchJoinGuildOptionRsp {
    public boolean enableAIGCAnswer;
    public GProJoinGuildSetting settingInfo;

    public GProFetchJoinGuildOptionRsp() {
        this.settingInfo = new GProJoinGuildSetting();
    }

    public boolean getEnableAIGCAnswer() {
        return this.enableAIGCAnswer;
    }

    public GProJoinGuildSetting getSettingInfo() {
        return this.settingInfo;
    }

    public String toString() {
        return "GProFetchJoinGuildOptionRsp{settingInfo=" + this.settingInfo + ",enableAIGCAnswer=" + this.enableAIGCAnswer + ",}";
    }

    public GProFetchJoinGuildOptionRsp(GProJoinGuildSetting gProJoinGuildSetting, boolean z16) {
        new GProJoinGuildSetting();
        this.settingInfo = gProJoinGuildSetting;
        this.enableAIGCAnswer = z16;
    }
}
