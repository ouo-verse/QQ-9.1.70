package com.tencent.mobileqq.qcircle.api.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes16.dex */
public class QCirclePublishButtonEvent extends SimpleBaseEvent {
    public byte[] mData;

    public QCirclePublishButtonEvent(byte[] bArr) {
        this.mData = bArr;
    }
}
