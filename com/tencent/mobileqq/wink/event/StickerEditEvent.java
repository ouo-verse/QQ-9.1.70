package com.tencent.mobileqq.wink.event;

import android.os.Bundle;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes21.dex */
public class StickerEditEvent extends SimpleBaseEvent {
    public static final int EVENT_TYPE_CHANGE_MUSIC = 10;
    public static final int EVENT_TYPE_CLIPPING_CANCER_TRACE = 5;
    public static final int EVENT_TYPE_CROP_CANCER_TRACE = 6;
    public static final int EVENT_TYPE_HIDE_SEEK_BAR = 8;
    public static final int EVENT_TYPE_LYRIC_STICKER_PART_HIDE = 14;
    public static final int EVENT_TYPE_LYRIC_STICKER_PART_SHOW = 13;
    public static final int EVENT_TYPE_SHOW_SEEK_BAR = 9;
    public static final int EVENT_TYPE_SUBTITLE_PART_HIDE = 12;
    public static final int EVENT_TYPE_SUBTITLE_PART_SHOW = 11;
    public static final int EVENT_TYPE_TEMPLATE_TEXT_LIST_PART_HIDE = 19;
    public static final int EVENT_TYPE_TEMPLATE_TEXT_LIST_PART_SHOW = 18;
    public static final int EVENT_TYPE_TEXT_CANCEL_TRACE = 7;
    public static final int EVENT_TYPE_TIMELINE_CANCEL_TRACE = 4;
    public static final int EVENT_TYPE_TIMELINE_PART_HIDE = 2;
    public static final int EVENT_TYPE_TIMELINE_PART_SHOW = 1;
    public static final int EVENT_TYPE_TIMELINE_PART_UPDATE = 3;
    public static final int EVENT_TYPE_TIMELINE_PLAY = 15;
    public static final int EVENT_TYPE_TTS_PART_HIDE = 17;
    public static final int EVENT_TYPE_TTS_PART_SHOW = 16;
    public static final int FROM_STICKER_LYRIC_PART = 102;
    public static final int FROM_STICKER_SUBTITLE_PART = 101;
    public static final int FROM_STICKER_TIMELINE_PART = 100;
    public static final int FROM_STICKER_TTS_PART = 103;
    public static final int FROM_TEMPLATE_TEXT_LIST_PART = 104;
    public static final String KEY_LP_BOTTOM_MARGIN = "KEY_LP_BOTTOM_MARGIN";
    public static final String KEY_LP_LEFT_MARGIN = "KEY_LP_LEFT_MARGIN";
    public static final String KEY_LP_RIGHT_MARGIN = "KEY_LP_RIGHT_MARGIN";
    public static final String KEY_LP_TOP_MARGIN = "KEY_LP_TOP_MARGIN";
    public Bundle bundle;
    public int mEventType;
    public int mFrom;

    public StickerEditEvent(int i3, int i16) {
        this.mEventType = i3;
        this.mFrom = i16;
    }

    public Bundle getBundle() {
        return this.bundle;
    }

    public void setBundle(Bundle bundle) {
        this.bundle = bundle;
    }
}
