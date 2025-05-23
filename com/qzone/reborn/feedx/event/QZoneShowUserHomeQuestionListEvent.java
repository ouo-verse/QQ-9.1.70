package com.qzone.reborn.feedx.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneShowUserHomeQuestionListEvent extends SimpleBaseEvent {
    public ArrayList<String> mQuestionList;

    public QZoneShowUserHomeQuestionListEvent(ArrayList<String> arrayList) {
        this.mQuestionList = arrayList;
    }
}
