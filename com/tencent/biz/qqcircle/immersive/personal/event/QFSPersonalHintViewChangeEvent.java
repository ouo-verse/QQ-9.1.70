package com.tencent.biz.qqcircle.immersive.personal.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes4.dex */
public class QFSPersonalHintViewChangeEvent extends SimpleBaseEvent {
    public static final int TYPE_HIDE_HINT_LOADING = 1;
    public static final int TYPE_SHOW_HINT_EMPTY = 2;
    public static final int TYPE_SHOW_HINT_LOADING = 0;
    public int actionType;

    public QFSPersonalHintViewChangeEvent(int i3) {
        this.actionType = i3;
    }
}
