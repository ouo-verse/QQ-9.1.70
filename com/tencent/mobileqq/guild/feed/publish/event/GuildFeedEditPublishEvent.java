package com.tencent.mobileqq.guild.feed.publish.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedPublishInitBean;

/* loaded from: classes13.dex */
public class GuildFeedEditPublishEvent extends SimpleBaseEvent {
    private GuildFeedPublishInitBean initBean;

    public GuildFeedEditPublishEvent(GuildFeedPublishInitBean guildFeedPublishInitBean) {
        this.initBean = guildFeedPublishInitBean;
    }

    public GuildFeedPublishInitBean getInitBean() {
        return this.initBean;
    }
}
