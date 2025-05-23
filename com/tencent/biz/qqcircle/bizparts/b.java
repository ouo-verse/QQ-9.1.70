package com.tencent.biz.qqcircle.bizparts;

import com.tencent.biz.richframework.part.Part;
import cooperation.qqcircle.report.QCircleReportBean;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class b extends Part implements com.tencent.biz.qqcircle.richframework.part.a<QCircleReportBean> {
    protected QCircleReportBean mReportBean;

    /* JADX INFO: Access modifiers changed from: protected */
    public int getPageId() {
        return QCircleReportBean.getPageId(getLogTag(), this.mReportBean);
    }

    protected int getParentPageId() {
        return QCircleReportBean.getParentPageId(getLogTag(), this.mReportBean);
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.a
    public QCircleReportBean getReportBean() {
        if (this.mReportBean == null) {
            this.mReportBean = new QCircleReportBean();
        }
        return QCircleReportBean.getReportBean(getLogTag(), this.mReportBean);
    }

    public void setReportBean(QCircleReportBean qCircleReportBean) {
        this.mReportBean = QCircleReportBean.setReportBean(getLogTag(), qCircleReportBean);
    }
}
