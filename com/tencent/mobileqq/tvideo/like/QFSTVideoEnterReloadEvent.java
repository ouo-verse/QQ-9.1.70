package com.tencent.mobileqq.tvideo.like;

import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes19.dex */
public class QFSTVideoEnterReloadEvent extends SimpleBaseEvent {
    private QCircleLayerBean layerBean;

    public QCircleLayerBean getLayerBean() {
        return this.layerBean;
    }

    public void setLayerBean(QCircleLayerBean qCircleLayerBean) {
        this.layerBean = qCircleLayerBean;
    }
}
