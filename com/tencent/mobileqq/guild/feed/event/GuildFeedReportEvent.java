package com.tencent.mobileqq.guild.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.guild.feed.bean.GuildFeedReportBean;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildFeedReportEvent extends SimpleBaseEvent {
    private boolean mFinish;
    private GuildFeedReportBean mGuildFeedReportBean;

    public GuildFeedReportEvent(GuildFeedReportBean guildFeedReportBean, boolean z16) {
        this.mGuildFeedReportBean = guildFeedReportBean;
        this.mFinish = z16;
    }

    public GuildFeedReportBean getGuildFeedReportBean() {
        return this.mGuildFeedReportBean;
    }

    public boolean isFinish() {
        return this.mFinish;
    }

    public void setFinish(boolean z16) {
        this.mFinish = z16;
    }

    public void setGuildFeedReportBean(GuildFeedReportBean guildFeedReportBean) {
        this.mGuildFeedReportBean = guildFeedReportBean;
    }

    public String toString() {
        return "GuildFeedReportEvent{mGuildFeedReportBean=" + this.mGuildFeedReportBean + ", mFinish=" + this.mFinish + "} " + super.toString();
    }
}
