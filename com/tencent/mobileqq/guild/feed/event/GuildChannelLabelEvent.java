package com.tencent.mobileqq.guild.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildChannelLabelEvent extends SimpleBaseEvent {
    private final String mGuildId;
    private final String mHotIcon;
    private final int mHotIndex;

    public GuildChannelLabelEvent(String str, String str2, int i3) {
        this.mGuildId = str;
        this.mHotIcon = str2;
        this.mHotIndex = i3;
    }

    public String getGuildId() {
        return this.mGuildId;
    }

    public String getHotIcon() {
        return this.mHotIcon;
    }

    public int getHotIndex() {
        return this.mHotIndex;
    }
}
