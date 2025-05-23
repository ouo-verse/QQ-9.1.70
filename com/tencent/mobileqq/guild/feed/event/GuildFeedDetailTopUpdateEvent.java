package com.tencent.mobileqq.guild.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildFeedDetailTopUpdateEvent extends SimpleBaseEvent {
    public static final int SERVICE_TYPE_EMBED_IN_GAME_CENTER = 3;
    public static final int SERVICE_TYPE_NORMAL = 1;
    private String mChannelId;
    private String mGuildId;
    private String feedId = "";
    private boolean isFeedSetTop = false;
    private int mTopType = 1;
    private int mServiceType = 1;

    public String getChannelId() {
        return this.mChannelId;
    }

    public String getFeedId() {
        return this.feedId;
    }

    public String getGuildId() {
        return this.mGuildId;
    }

    public boolean getIsFeedSetTop() {
        return this.isFeedSetTop;
    }

    public int getServiceType() {
        return this.mServiceType;
    }

    public int getTopType() {
        return this.mTopType;
    }

    public boolean isFeedTop() {
        int i3 = this.mTopType;
        if (i3 == 1 || i3 == 3) {
            return true;
        }
        return false;
    }

    public boolean isSectionFeedTop() {
        int i3 = this.mTopType;
        if (i3 != 2 && i3 != 3) {
            return false;
        }
        return true;
    }

    public void setChannelId(String str) {
        this.mChannelId = str;
    }

    public void setFeedId(String str) {
        this.feedId = str;
    }

    public void setGuildId(String str) {
        this.mGuildId = str;
    }

    public void setIsFeedSetTop(boolean z16) {
        this.isFeedSetTop = z16;
    }

    public void setServiceType(int i3) {
        this.mServiceType = i3;
    }

    public void setTopType(int i3) {
        this.mTopType = i3;
    }
}
