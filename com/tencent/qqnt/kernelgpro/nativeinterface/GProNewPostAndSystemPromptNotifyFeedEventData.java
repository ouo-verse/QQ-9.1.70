package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProNewPostAndSystemPromptNotifyFeedEventData {
    public long guildId;
    public int mainType;
    public long posterTinyId;
    public int subType;

    public long getGuildId() {
        return this.guildId;
    }

    public int getMainType() {
        return this.mainType;
    }

    public long getPosterTinyId() {
        return this.posterTinyId;
    }

    public int getSubType() {
        return this.subType;
    }

    public String toString() {
        return "GProNewPostAndSystemPromptNotifyFeedEventData{guildId=" + this.guildId + ",mainType=" + this.mainType + ",posterTinyId=" + this.posterTinyId + ",subType=" + this.subType + ",}";
    }
}
