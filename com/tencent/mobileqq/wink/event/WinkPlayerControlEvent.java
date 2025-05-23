package com.tencent.mobileqq.wink.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes21.dex */
public class WinkPlayerControlEvent extends SimpleBaseEvent {
    public static final int EVENT_TYPE_PAUSE = 2;
    public static final int EVENT_TYPE_PLAY = 1;
    public static final int EVENT_TYPE_SEEK_END = 4;
    public static final int EVENT_TYPE_SEEK_START = 3;
    public static final int FROM_BLANK_CLICK = 2;
    public static final int FROM_DEFAULT = 1;
    public static final int FROM_SELECT_STICKER_CHANGE = 3;
    public int mEventType;
    public int mFrom;

    public WinkPlayerControlEvent(int i3, int i16) {
        this.mEventType = i3;
        this.mFrom = i16;
    }

    public WinkPlayerControlEvent(int i3) {
        this.mEventType = i3;
        this.mFrom = 1;
    }
}
