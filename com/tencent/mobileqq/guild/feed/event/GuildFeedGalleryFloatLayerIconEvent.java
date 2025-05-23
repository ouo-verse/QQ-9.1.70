package com.tencent.mobileqq.guild.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildFeedGalleryFloatLayerIconEvent extends SimpleBaseEvent {
    private boolean mShowIcon;

    public GuildFeedGalleryFloatLayerIconEvent(boolean z16) {
        this.mShowIcon = z16;
    }

    public boolean showIcon() {
        return this.mShowIcon;
    }
}
