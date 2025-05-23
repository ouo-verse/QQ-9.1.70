package com.tencent.biz.qqcircle.immersive.layer.biz;

import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a extends com.tencent.biz.qqcircle.immersive.layer.base.a {
    @Override // com.tencent.biz.qqcircle.immersive.layer.base.a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public QCircleLayerBean b() {
        QCircleInitBean qCircleInitBean = this.f86508a;
        if (qCircleInitBean instanceof QCircleLayerBean) {
            return (QCircleLayerBean) qCircleInitBean;
        }
        return null;
    }
}
