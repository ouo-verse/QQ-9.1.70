package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProRealTimeVoiceChannel {
    public GProChannelMemberInfos memberInfos;

    public GProRealTimeVoiceChannel() {
        this.memberInfos = new GProChannelMemberInfos();
    }

    public GProChannelMemberInfos getMemberInfos() {
        return this.memberInfos;
    }

    public String toString() {
        return "GProRealTimeVoiceChannel{memberInfos=" + this.memberInfos + ",}";
    }

    public GProRealTimeVoiceChannel(GProChannelMemberInfos gProChannelMemberInfos) {
        new GProChannelMemberInfos();
        this.memberInfos = gProChannelMemberInfos;
    }
}
