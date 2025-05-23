package com.tencent.mobileqq.guild.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.guild.util.HashTagViewType;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildHashtagEvent extends SimpleBaseEvent {
    public String channelName;
    public String channelUin;
    public String guildId;
    public HashTagViewType viewType;

    public GuildHashtagEvent(String str, String str2, String str3, HashTagViewType hashTagViewType) {
        this.guildId = str;
        this.channelUin = str2;
        this.channelName = str3;
        this.viewType = hashTagViewType;
    }

    public String toString() {
        return "GuildHashtagEvent{guildId=" + this.guildId + "channelUin=" + this.channelUin + "channelName=" + this.channelName + "viewType=" + this.viewType + "} " + super.toString();
    }
}
