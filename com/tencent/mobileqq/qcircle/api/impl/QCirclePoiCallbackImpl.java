package com.tencent.mobileqq.qcircle.api.impl;

import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.qcircle.api.IQCirclePoiCallback;
import com.tencent.mobileqq.qcircle.api.event.QcircleLbsEvent;
import cooperation.qzone.LbsDataV2;

/* loaded from: classes16.dex */
public class QCirclePoiCallbackImpl implements IQCirclePoiCallback {
    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePoiCallback
    public void onPoiResultBack(LbsDataV2.PoiList poiList, int i3) {
        SimpleEventBus.getInstance().dispatchEvent(new QcircleLbsEvent(poiList, i3));
    }
}
