package com.tencent.mobileqq.guild.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes13.dex */
public class GuildEmptyPartEvent extends SimpleBaseEvent {
    private int mBusinessType;
    private String mChannelId;
    private String mGuildId;
    private boolean mShowPartView;
    private boolean mShowPublishView;

    public GuildEmptyPartEvent(boolean z16) {
        this(z16, true, "", "", 15);
    }

    public int getBusinessType() {
        return this.mBusinessType;
    }

    public String getChannelId() {
        return this.mChannelId;
    }

    public String getGuildId() {
        return this.mGuildId;
    }

    public boolean isShowPublishView() {
        return this.mShowPublishView;
    }

    public boolean isShowView() {
        return this.mShowPartView;
    }

    public GuildEmptyPartEvent(boolean z16, boolean z17, String str, String str2, int i3) {
        this.mShowPartView = z16;
        this.mShowPublishView = z17;
        this.mGuildId = str;
        this.mChannelId = str2;
        this.mBusinessType = i3;
    }
}
