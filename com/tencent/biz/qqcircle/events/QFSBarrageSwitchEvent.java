package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSBarrageSwitchEvent extends SimpleBaseEvent {
    public static final int EVENT_SWITCH_BARRAGE_CLOSE = 2;
    public static final int EVENT_SWITCH_BARRAGE_OPEN = 1;
    public int eventStatus;

    public QFSBarrageSwitchEvent(int i3) {
        this.eventStatus = i3;
    }
}
