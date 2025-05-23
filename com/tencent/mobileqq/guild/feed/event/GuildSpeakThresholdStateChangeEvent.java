package com.tencent.mobileqq.guild.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qqguildsdk.data.IGuildSpeakableThresholdPermission;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildSpeakThresholdStateChangeEvent extends SimpleBaseEvent {
    public String mChannelId;
    public String mGuildId;
    public boolean mIsChannelLevelAdmin;
    public IGuildSpeakableThresholdPermission mSpeakThresholdState;

    public GuildSpeakThresholdStateChangeEvent(String str, String str2, boolean z16, IGuildSpeakableThresholdPermission iGuildSpeakableThresholdPermission) {
        this.mGuildId = str;
        this.mChannelId = str2;
        this.mIsChannelLevelAdmin = z16;
        this.mSpeakThresholdState = iGuildSpeakableThresholdPermission;
    }

    public String toString() {
        return "GuildSpeakThresholdStateChangeEvent{mGuildId='" + this.mGuildId + "', mChannelId='" + this.mChannelId + "', mIsChannelLevelAdmin=" + this.mIsChannelLevelAdmin + ", mSpeakThresholdState=" + this.mSpeakThresholdState + ", mHashCode=" + this.mHashCode + '}';
    }
}
