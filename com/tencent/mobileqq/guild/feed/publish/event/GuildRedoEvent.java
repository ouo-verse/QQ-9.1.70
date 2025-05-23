package com.tencent.mobileqq.guild.feed.publish.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildRedoEvent extends SimpleBaseEvent {
    private boolean mRedo;

    public GuildRedoEvent(boolean z16) {
        this.mRedo = z16;
    }

    public boolean isRedo() {
        return this.mRedo;
    }

    public void setRedo(boolean z16) {
        this.mRedo = z16;
    }

    public String toString() {
        return "GuildRedoEvent{mRedo=" + this.mRedo + "} " + super.toString();
    }
}
