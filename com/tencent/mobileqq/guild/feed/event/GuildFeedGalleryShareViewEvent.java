package com.tencent.mobileqq.guild.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedGalleryInitBean;
import com.tencent.mobileqq.guild.feed.share.c;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildFeedGalleryShareViewEvent extends SimpleBaseEvent {
    private GProStFeed mFeed;
    private GuildFeedGalleryInitBean mGalleryInitBean;
    private c mGalleryShareInfo;
    private GuildSharePageSource mSource;

    public GProStFeed getFeed() {
        return this.mFeed;
    }

    public GuildFeedGalleryInitBean getGalleryInitBean() {
        return this.mGalleryInitBean;
    }

    public c getGalleryShareInfo() {
        return this.mGalleryShareInfo;
    }

    public GuildSharePageSource getSource() {
        return this.mSource;
    }

    public void setGalleryInitBean(GuildFeedGalleryInitBean guildFeedGalleryInitBean) {
        this.mGalleryInitBean = guildFeedGalleryInitBean;
    }

    public void setGalleryShareInfo(c cVar) {
        this.mGalleryShareInfo = cVar;
    }

    public void setSource(GuildSharePageSource guildSharePageSource) {
        this.mSource = guildSharePageSource;
    }
}
