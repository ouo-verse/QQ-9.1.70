package com.tencent.mobileqq.guild.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes13.dex */
public class GuildFeedPublishPartEvent extends SimpleBaseEvent {
    private final String mChannelId;
    private final boolean mIsSpeakThresholdLimit;
    private final boolean mShowPublishIcon;

    public GuildFeedPublishPartEvent(String str, boolean z16, boolean z17) {
        this.mChannelId = str;
        this.mShowPublishIcon = z16;
        this.mIsSpeakThresholdLimit = z17;
    }

    public String getChannelId() {
        return this.mChannelId;
    }

    public boolean isIsSpeakThresholdLimit() {
        return this.mIsSpeakThresholdLimit;
    }

    public boolean isShowPublishIcon() {
        return this.mShowPublishIcon;
    }
}
