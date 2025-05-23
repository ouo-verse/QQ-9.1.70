package com.tencent.mobileqq.guild.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import java.util.List;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildChannelDeleteEvent extends SimpleBaseEvent {
    private final List<String> mChannelIds;
    private final String mGuildId;

    public GuildChannelDeleteEvent(String str, List<String> list) {
        this.mGuildId = str;
        this.mChannelIds = list;
    }

    public List<String> getChannelIds() {
        return this.mChannelIds;
    }

    public String getGuildId() {
        return this.mGuildId;
    }
}
