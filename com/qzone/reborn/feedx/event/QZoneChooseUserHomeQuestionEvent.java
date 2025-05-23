package com.qzone.reborn.feedx.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneChooseUserHomeQuestionEvent extends SimpleBaseEvent {
    public String mChosenQuestion;

    public QZoneChooseUserHomeQuestionEvent(String str) {
        this.mChosenQuestion = str;
    }
}
