package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GuildChatCacheInfo {
    public long cacheSize;
    public ArrayList<GuildCategoryChatInfo> categoryList;
    public long chatTime;
    public long guildAvatarSeq;
    public long guildId;
    public String guildName;

    public GuildChatCacheInfo() {
        this.guildName = "";
        this.categoryList = new ArrayList<>();
    }

    public long getCacheSize() {
        return this.cacheSize;
    }

    public ArrayList<GuildCategoryChatInfo> getCategoryList() {
        return this.categoryList;
    }

    public long getChatTime() {
        return this.chatTime;
    }

    public long getGuildAvatarSeq() {
        return this.guildAvatarSeq;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getGuildName() {
        return this.guildName;
    }

    public GuildChatCacheInfo(long j3, long j16, long j17, long j18, String str, ArrayList<GuildCategoryChatInfo> arrayList) {
        this.guildName = "";
        new ArrayList();
        this.cacheSize = j3;
        this.chatTime = j16;
        this.guildId = j17;
        this.guildAvatarSeq = j18;
        this.guildName = str;
        this.categoryList = arrayList;
    }
}
