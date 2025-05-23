package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GuildChannelChatInfo {
    public long cacheSize;
    public long channelId;
    public String channelName;
    public int channelType;
    public int textChannelSubtypeId;

    public GuildChannelChatInfo() {
        this.channelName = "";
    }

    public long getCacheSize() {
        return this.cacheSize;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public int getChannelType() {
        return this.channelType;
    }

    public int getTextChannelSubtypeId() {
        return this.textChannelSubtypeId;
    }

    public GuildChannelChatInfo(int i3, int i16, long j3, long j16, String str) {
        this.channelType = i3;
        this.textChannelSubtypeId = i16;
        this.channelId = j3;
        this.cacheSize = j16;
        this.channelName = str;
    }
}
