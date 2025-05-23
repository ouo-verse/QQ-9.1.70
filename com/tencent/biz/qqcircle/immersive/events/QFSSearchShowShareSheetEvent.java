package com.tencent.biz.qqcircle.immersive.events;

import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSSearchShowShareSheetEvent extends SimpleBaseEvent {
    private int mContextHashCode;
    private QCircleShareInfo mShareInfo;

    public QFSSearchShowShareSheetEvent(QCircleShareInfo qCircleShareInfo, int i3) {
        this.mShareInfo = qCircleShareInfo;
        this.mContextHashCode = i3;
    }

    public int getContextHashCode() {
        return this.mContextHashCode;
    }

    public QCircleShareInfo getShareInfo() {
        return this.mShareInfo;
    }
}
