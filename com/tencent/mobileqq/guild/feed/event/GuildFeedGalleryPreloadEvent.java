package com.tencent.mobileqq.guild.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes13.dex */
public class GuildFeedGalleryPreloadEvent extends SimpleBaseEvent {
    private int curPos = 0;

    public GuildFeedGalleryPreloadEvent(int i3) {
        setCurPos(i3);
    }

    public int getCurPos() {
        return this.curPos;
    }

    public void setCurPos(int i3) {
        this.curPos = i3;
    }
}
