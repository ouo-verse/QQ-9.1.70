package com.tencent.biz.qqcircle.immersive.layer.base;

import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import cooperation.qqcircle.report.QCircleReportBean;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    protected QCircleInitBean f86508a;

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.biz.qqcircle.richframework.part.a<QCircleReportBean> f86509b;

    public com.tencent.biz.qqcircle.richframework.part.a<QCircleReportBean> a() {
        return this.f86509b;
    }

    public QCircleInitBean b() {
        return this.f86508a;
    }

    public a c(com.tencent.biz.qqcircle.richframework.part.a<QCircleReportBean> aVar) {
        this.f86509b = aVar;
        return this;
    }

    public a d(QCircleInitBean qCircleInitBean) {
        this.f86508a = qCircleInitBean;
        return this;
    }
}
