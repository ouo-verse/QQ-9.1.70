package com.tencent.mobileqq.qcircle.api.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleRedInfoEvent extends SimpleBaseEvent {
    public static final String OUTER_ENTRANCE_RED_POINT_READED = "QCircleRedPointManager setOuterEntranceRedPointReaded";
    private static final String TAG = "QCircleRedInfoEvent";
    public String mInvokeMethodName;
    public boolean mIsClearRedPoint;

    public QCircleRedInfoEvent(String str, boolean z16) {
        this.mIsClearRedPoint = z16;
        this.mInvokeMethodName = str;
    }
}
