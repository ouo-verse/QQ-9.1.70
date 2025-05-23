package com.tencent.mobileqq.guild.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import ij1.h;
import java.util.List;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildFeedTopDataEvent extends SimpleBaseEvent {
    private String mChannelId;
    private String mGuildId;
    private List<h> mTopDataList;

    public GuildFeedTopDataEvent(List<h> list) {
        this(list, "", "");
    }

    public String getChannelId() {
        return this.mChannelId;
    }

    public String getGuildId() {
        return this.mGuildId;
    }

    public List<h> getTopDataList() {
        return this.mTopDataList;
    }

    public GuildFeedTopDataEvent(List<h> list, String str, String str2) {
        this.mTopDataList = list;
        this.mGuildId = str;
        this.mChannelId = str2;
    }
}
