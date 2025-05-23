package com.tencent.mobileqq.guild.share.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildShareActionSheetClickEvent extends SimpleBaseEvent {
    private IGProChannelInfo mChannelInfo;
    private IGProGuildInfo mGuildInfo;

    public IGProChannelInfo getChannelInfo() {
        return this.mChannelInfo;
    }

    public IGProGuildInfo getGuildInfo() {
        return this.mGuildInfo;
    }

    public void setChannelInfo(IGProChannelInfo iGProChannelInfo) {
        this.mChannelInfo = iGProChannelInfo;
    }

    public void setGuildInfo(IGProGuildInfo iGProGuildInfo) {
        this.mGuildInfo = iGProGuildInfo;
    }
}
