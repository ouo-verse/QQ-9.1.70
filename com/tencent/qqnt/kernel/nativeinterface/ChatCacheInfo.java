package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class ChatCacheInfo {
    public BasicChatCacheInfo basicChatCacheInfo;
    public int chatType;
    public GuildChatCacheInfo guildChatCacheInfo;

    public ChatCacheInfo() {
        this.basicChatCacheInfo = new BasicChatCacheInfo();
        this.guildChatCacheInfo = new GuildChatCacheInfo();
    }

    public BasicChatCacheInfo getBasicChatCacheInfo() {
        return this.basicChatCacheInfo;
    }

    public int getChatType() {
        return this.chatType;
    }

    public GuildChatCacheInfo getGuildChatCacheInfo() {
        return this.guildChatCacheInfo;
    }

    public ChatCacheInfo(int i3, BasicChatCacheInfo basicChatCacheInfo, GuildChatCacheInfo guildChatCacheInfo) {
        this.basicChatCacheInfo = new BasicChatCacheInfo();
        new GuildChatCacheInfo();
        this.chatType = i3;
        this.basicChatCacheInfo = basicChatCacheInfo;
        this.guildChatCacheInfo = guildChatCacheInfo;
    }
}
