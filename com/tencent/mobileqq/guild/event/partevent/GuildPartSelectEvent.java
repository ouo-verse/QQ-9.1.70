package com.tencent.mobileqq.guild.event.partevent;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes13.dex */
public class GuildPartSelectEvent extends SimpleBaseEvent {
    public String channelName;
    public String channelUin;
    public String guildId;
    public boolean isSquare;
    public String sourceChannelId;

    public GuildPartSelectEvent(String str, String str2, String str3, boolean z16) {
        this.guildId = str;
        this.channelUin = str2;
        this.channelName = str3;
        this.isSquare = z16;
    }

    public String toString() {
        return "GuildPartSelectEvent{guildId=" + this.guildId + "channelUin=" + this.channelUin + "channelName=" + this.channelName + "isSquare=" + this.isSquare + "} " + super.toString();
    }
}
