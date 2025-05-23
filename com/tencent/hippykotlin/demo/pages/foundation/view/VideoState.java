package com.tencent.hippykotlin.demo.pages.foundation.view;

/* compiled from: P */
/* loaded from: classes31.dex */
public enum VideoState {
    IDLE(0),
    /* JADX INFO: Fake field, exist only in values array */
    PREPARING(6),
    PLAYING(1),
    PAUSED(2),
    COMPLETE(3),
    ERROR(4),
    BUFFERING(5);

    public final int state;

    VideoState(int i3) {
        this.state = i3;
    }
}
