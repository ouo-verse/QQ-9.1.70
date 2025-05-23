package com.tencent.mobileqq.search.business.qcircle.video.common;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.search.business.qcircle.video.base.QCircleSearchDoubleVideoItemView;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;

/* compiled from: P */
/* loaded from: classes18.dex */
public class QCircleSearchCommonVideoItemView extends QCircleSearchDoubleVideoItemView {
    public QCircleSearchCommonVideoItemView(@NonNull Context context) {
        super(context);
    }

    @Override // com.tencent.mobileqq.search.business.qcircle.video.base.QCircleSearchDoubleVideoItemView
    protected String E0() {
        return "feeds";
    }

    @Override // com.tencent.mobileqq.search.business.qcircle.video.base.QCircleSearchDoubleVideoItemView
    protected String F0() {
        return QCircleDaTongConstant.ElementId.EM_XSJ_FEED;
    }

    @Override // com.tencent.mobileqq.search.business.qcircle.video.base.QCircleSearchDoubleVideoItemView
    protected String G0() {
        return "qDouble";
    }
}
