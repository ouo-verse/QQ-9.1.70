package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProRecommendVoiceChannel implements Serializable {
    public GProRecommendCoverInfo cover;
    long serialVersionUID;
    public GProChannelMemberInfos voiceChannel;

    public GProRecommendVoiceChannel() {
        this.serialVersionUID = 1L;
        this.voiceChannel = new GProChannelMemberInfos();
        this.cover = new GProRecommendCoverInfo();
    }

    public GProRecommendCoverInfo getCover() {
        return this.cover;
    }

    public GProChannelMemberInfos getVoiceChannel() {
        return this.voiceChannel;
    }

    public String toString() {
        return "GProRecommendVoiceChannel{voiceChannel=" + this.voiceChannel + ",cover=" + this.cover + ",}";
    }

    public GProRecommendVoiceChannel(GProChannelMemberInfos gProChannelMemberInfos, GProRecommendCoverInfo gProRecommendCoverInfo) {
        this.serialVersionUID = 1L;
        this.voiceChannel = new GProChannelMemberInfos();
        new GProRecommendCoverInfo();
        this.voiceChannel = gProChannelMemberInfos;
        this.cover = gProRecommendCoverInfo;
    }
}
