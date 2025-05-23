package com.tencent.mobileqq.qcircle.api.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import cooperation.qzone.LbsDataV2;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QcircleLbsEvent extends SimpleBaseEvent {
    public LbsDataV2.PoiList mPoiList;
    public int requestCode;

    public QcircleLbsEvent(LbsDataV2.PoiList poiList, int i3) {
        this.mPoiList = poiList;
        this.requestCode = i3;
    }
}
