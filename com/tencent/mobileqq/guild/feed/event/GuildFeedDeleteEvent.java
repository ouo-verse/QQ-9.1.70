package com.tencent.mobileqq.guild.feed.event;

import androidx.annotation.Nullable;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildFeedDeleteEvent extends SimpleBaseEvent {
    private final String mChannelId;
    private String mDataDisplaySurfacePrefixKey;
    private final String mFeedId;
    private final String mGuildId;
    private boolean mNeedReFetchTopFeeds = true;

    public GuildFeedDeleteEvent(String str, String str2, String str3) {
        this.mFeedId = str;
        this.mGuildId = str2;
        this.mChannelId = str3;
    }

    public String getChannelId() {
        return this.mChannelId;
    }

    public String getDataDisplaySurfacePrefixKey() {
        return this.mDataDisplaySurfacePrefixKey;
    }

    public String getFeedId() {
        return this.mFeedId;
    }

    public String getGuildId() {
        return this.mGuildId;
    }

    public boolean isNeedReFetchTopFeeds() {
        return this.mNeedReFetchTopFeeds;
    }

    public void setDataDisplaySurfacePrefixKey(@Nullable String str) {
        this.mDataDisplaySurfacePrefixKey = str;
    }

    public void setNeedReFetchTopFeeds(boolean z16) {
        this.mNeedReFetchTopFeeds = z16;
    }
}
