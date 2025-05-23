package com.tencent.hippykotlin.demo.pages.foundation.view;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class QQVideoViewKt {
    public static final VideoState access$toState(int i3) {
        for (VideoState videoState : VideoState.values()) {
            if (videoState.state == i3) {
                return videoState;
            }
        }
        return VideoState.IDLE;
    }
}
