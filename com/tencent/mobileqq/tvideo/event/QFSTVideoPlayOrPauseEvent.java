package com.tencent.mobileqq.tvideo.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes19.dex */
public class QFSTVideoPlayOrPauseEvent extends SimpleBaseEvent {
    private boolean isPause;
    private boolean isPlay;

    public boolean isPause() {
        return this.isPause;
    }

    public boolean isPlay() {
        return this.isPlay;
    }

    public void setPause(boolean z16) {
        this.isPause = z16;
    }

    public void setPlay(boolean z16) {
        this.isPlay = z16;
    }
}
