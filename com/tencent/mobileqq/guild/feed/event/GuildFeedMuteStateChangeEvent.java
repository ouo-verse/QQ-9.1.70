package com.tencent.mobileqq.guild.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildFeedMuteStateChangeEvent extends SimpleBaseEvent {
    public String channelId;
    public long globalShutUpExpireTime;
    public String guildId;
    public boolean isAtomicMute;
    public boolean isManager;
    public boolean isMute;
    public boolean isRestrictPost;
    public String muteTimeHint;
    public long myShutUpExpireTime;
    public String simpleMuteTimeHint;

    public GuildFeedMuteStateChangeEvent(String str, String str2, boolean z16, boolean z17, boolean z18, String str3, String str4) {
        this.guildId = str;
        this.channelId = str2;
        this.isMute = z16;
        this.isManager = z18;
        this.isRestrictPost = z17;
        this.muteTimeHint = str3;
        this.simpleMuteTimeHint = str4;
    }

    public String toString() {
        return "GuildFeedMuteStateChangeEvent{guildId='" + this.guildId + "', channelId='" + this.channelId + "', isMute=" + this.isMute + ", isManager=" + this.isManager + ", isRestrictPost=" + this.isRestrictPost + ", muteTimeHint='" + this.muteTimeHint + "', simpleMuteTimeHint='" + this.simpleMuteTimeHint + "'}";
    }
}
