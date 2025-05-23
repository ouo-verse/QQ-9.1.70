package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GuildCategoryChatInfo {
    public long categoryId;
    public String categoryName;
    public ArrayList<GuildChannelChatInfo> channelList;

    public GuildCategoryChatInfo() {
        this.categoryName = "";
        this.channelList = new ArrayList<>();
    }

    public long getCategoryId() {
        return this.categoryId;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public ArrayList<GuildChannelChatInfo> getChannelList() {
        return this.channelList;
    }

    public GuildCategoryChatInfo(long j3, String str, ArrayList<GuildChannelChatInfo> arrayList) {
        this.categoryName = "";
        new ArrayList();
        this.categoryId = j3;
        this.categoryName = str;
        this.channelList = arrayList;
    }
}
