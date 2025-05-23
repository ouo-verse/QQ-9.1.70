package com.tencent.mobileqq.tvideo.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TVideoChannelAutoJumpEvent extends SimpleBaseEvent {
    private int channelId;

    public int getChannelId() {
        return this.channelId;
    }

    public void setChannelId(int i3) {
        this.channelId = i3;
    }
}
