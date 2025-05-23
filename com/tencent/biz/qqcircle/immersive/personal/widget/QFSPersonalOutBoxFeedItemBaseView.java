package com.tencent.biz.qqcircle.immersive.personal.widget;

import android.content.Context;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.mobileqq.winkpublish.model.DraftBean;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public abstract class QFSPersonalOutBoxFeedItemBaseView extends QCircleBaseWidgetView<com.tencent.biz.qqcircle.immersive.personal.bean.k> {

    /* renamed from: d, reason: collision with root package name */
    protected com.tencent.biz.qqcircle.immersive.personal.bean.k f89294d;

    /* renamed from: e, reason: collision with root package name */
    protected List<DraftBean> f89295e;

    /* renamed from: f, reason: collision with root package name */
    protected List<String> f89296f;

    /* renamed from: h, reason: collision with root package name */
    protected View.OnClickListener f89297h;

    /* loaded from: classes4.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QFSPersonalOutBoxFeedItemBaseView.this.o0(view);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public QFSPersonalOutBoxFeedItemBaseView(@NonNull Context context) {
        super(context);
        this.f89295e = new ArrayList();
        this.f89296f = new ArrayList();
        this.f89297h = new a();
    }

    private void m0() {
        int j3;
        String d16;
        VideoReport.setElementId(this, QCircleDaTongConstant.ElementId.EM_XSJ_DRAFTS);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        com.tencent.biz.qqcircle.immersive.personal.bean.k kVar = this.f89294d;
        if (kVar == null) {
            j3 = 0;
        } else {
            j3 = kVar.j();
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_DRAFTS_FEEDS_NUM, Integer.valueOf(j3));
        com.tencent.biz.qqcircle.immersive.personal.bean.k kVar2 = this.f89294d;
        if (kVar2 == null) {
            d16 = "";
        } else {
            d16 = kVar2.d();
        }
        buildElementParams.put("xsj_feed_id", d16);
        VideoReport.setElementParams(this, buildElementParams);
        VideoReport.setElementEndExposePolicy(this, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(this, ClickPolicy.REPORT_ALL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0(View view) {
        int j3;
        QCircleInitBean qCircleInitBean = new QCircleInitBean();
        qCircleInitBean.setFromReportBean(getReportBean().m466clone());
        Context context = view.getContext();
        com.tencent.biz.qqcircle.immersive.personal.bean.k kVar = this.f89294d;
        if (kVar == null) {
            j3 = 0;
        } else {
            j3 = kVar.j();
        }
        com.tencent.biz.qqcircle.launcher.c.C(context, qCircleInitBean, j3);
    }

    private void r0() {
        s0();
        com.tencent.biz.qqcircle.immersive.personal.bean.k kVar = this.f89294d;
        if (kVar == null) {
            QLog.d(getLogTag(), 1, "parseData, mPersonalFeedInfo is null ");
            return;
        }
        List<DraftBean> i3 = kVar.i();
        if (i3 != null && !i3.isEmpty()) {
            for (DraftBean draftBean : i3) {
                this.f89295e.add(draftBean);
                this.f89296f.add(draftBean.getCoverUrl());
            }
            QLog.d(getLogTag(), 1, "parseData, mCoverList: " + this.f89296f);
            return;
        }
        QLog.d(getLogTag(), 1, "parseData, draftBeanList is null or empty ");
    }

    private void s0() {
        this.f89295e.clear();
        this.f89296f.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    @CallSuper
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public void bindData(com.tencent.biz.qqcircle.immersive.personal.bean.k kVar, int i3) {
        this.f89294d = kVar;
        r0();
        setOnClickListener(this.f89297h);
        m0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String n0() {
        com.tencent.biz.qqcircle.immersive.personal.bean.k kVar = this.f89294d;
        if (kVar == null) {
            return "";
        }
        int j3 = kVar.j();
        if (j3 > 99) {
            return "99+";
        }
        return String.valueOf(j3);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec((View.MeasureSpec.getSize(i3) * 4) / 3, 1073741824));
    }

    public void p0() {
    }

    public void q0() {
    }
}
