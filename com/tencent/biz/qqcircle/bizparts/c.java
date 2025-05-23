package com.tencent.biz.qqcircle.bizparts;

import android.os.Bundle;
import com.tencent.biz.richframework.part.extendsblock.SingleViewBlock;
import cooperation.qqcircle.report.QCircleReportBean;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class c extends SingleViewBlock implements com.tencent.biz.qqcircle.richframework.part.a<QCircleReportBean> {

    /* renamed from: m, reason: collision with root package name */
    protected QCircleReportBean f82984m;

    public c(Bundle bundle) {
        super(bundle);
    }

    protected abstract String getLogTag();

    public void setReportBean(QCircleReportBean qCircleReportBean) {
        this.f82984m = QCircleReportBean.setReportBean(getLogTag(), qCircleReportBean);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.biz.qqcircle.richframework.part.a
    public QCircleReportBean getReportBean() {
        if (this.f82984m == null) {
            this.f82984m = new QCircleReportBean();
        }
        return QCircleReportBean.getReportBean(getLogTag(), this.f82984m);
    }

    public void release() {
    }
}
