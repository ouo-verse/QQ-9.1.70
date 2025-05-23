package com.tencent.biz.qqcircle.immersive.refresh;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.immersive.views.QFSPageTurnContainer;
import com.tencent.biz.qqcircle.utils.QCircleNetWorkTestHelper;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.utils.h;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.network.util.VSNetworkSpeedHelper;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.util.LoadingUtil;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSLayerLoadFooterView extends QCircleBaseWidgetView implements b {
    private static final int G = cx.a(64.0f);
    private boolean C;
    private boolean D;
    private int E;
    private t40.a F;

    /* renamed from: d, reason: collision with root package name */
    protected QFSPageTurnContainer.j f89630d;

    /* renamed from: e, reason: collision with root package name */
    protected TextView f89631e;

    /* renamed from: f, reason: collision with root package name */
    protected TextView f89632f;

    /* renamed from: h, reason: collision with root package name */
    protected ImageView f89633h;

    /* renamed from: i, reason: collision with root package name */
    private Drawable f89634i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f89635m;

    public QFSLayerLoadFooterView(@NonNull Context context) {
        this(context, null);
    }

    private void k0() {
        TextView textView = this.f89631e;
        if (textView == null) {
            return;
        }
        if (this.C) {
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
    }

    private boolean l0(QFSPullRefreshLayout qFSPullRefreshLayout) {
        if (qFSPullRefreshLayout == null || qFSPullRefreshLayout.K()) {
            return false;
        }
        if (this.f89631e.getVisibility() != 0) {
            VideoReport.reportEvent("imp", this.f89631e, null);
        }
        this.f89631e.setText(h.a(R.string.f184043kt));
        this.f89631e.setVisibility(0);
        this.f89633h.setVisibility(8);
        this.f89632f.setVisibility(8);
        invalidate();
        return true;
    }

    private void m0() {
        TextView textView = this.f89632f;
        if (textView == null) {
            return;
        }
        if (this.f89635m) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            r0(this, 1);
        }
    }

    private t40.a n0() {
        t40.a aVar = this.F;
        if (aVar != null) {
            return aVar;
        }
        t40.a aVar2 = (t40.a) RFWIocAbilityProvider.g().getIocInterface(t40.a.class, this, null);
        this.F = aVar2;
        return aVar2;
    }

    private int o0() {
        t40.a n06 = n0();
        if (n06 != null) {
            return n06.getFeedPosition();
        }
        return -1;
    }

    private void q0(View view) {
        this.f89631e = (TextView) view.findViewById(R.id.f109086ev);
        this.f89632f = (TextView) view.findViewById(R.id.f109076eu);
        this.f89633h = (ImageView) view.findViewById(R.id.y5d);
        this.f89634i = LoadingUtil.getLoadingDrawable(getContext(), 2);
        this.D = false;
        setVisibility(8);
        s0(this);
    }

    private void v0() {
        if (this.D) {
            QLog.e("LOAD-QFSLayerLoadFooterView", 1, "[startLoadingAnim] current not start anim.");
        } else {
            if (this.f89633h == null) {
                QLog.e("LOAD-QFSLayerLoadFooterView", 1, "[startLoadingAnim] load more image should not be null.");
                return;
            }
            this.D = true;
            QLog.d("LOAD-QFSLayerLoadFooterView", 2, "[startLoadingAnim] start loading anim...");
            this.f89633h.setImageDrawable(this.f89634i);
        }
    }

    private void w0() {
        this.D = false;
        QLog.d("LOAD-QFSLayerLoadFooterView", 2, "[stopLoadingAnim] stop loading anim...");
    }

    @Override // com.tencent.biz.qqcircle.immersive.refresh.b
    public void A(float f16, boolean z16) {
        int i3 = this.E;
        if (i3 == 0) {
            return;
        }
        if (f16 > 1.0f) {
            f16 = 1.0f;
        }
        if (f16 < 0.0f) {
            f16 = 0.0f;
        }
        int i16 = (int) (f16 * i3);
        if (!z16) {
            i16 = 0;
        }
        float f17 = i16;
        if (f17 != getTranslationY()) {
            setTranslationY(f17);
        }
    }

    public /* synthetic */ int B() {
        return a.a(this);
    }

    public void C(QFSPullRefreshLayout qFSPullRefreshLayout, boolean z16) {
        QLog.d("LOAD-QFSLayerLoadFooterView", 1, "onComplete  hasMoreData = " + z16);
        QFSPageTurnContainer.j jVar = this.f89630d;
        if (jVar != null) {
            jVar.onComplete(true);
        }
        w0();
    }

    public void D(QFSPullRefreshLayout qFSPullRefreshLayout, float f16) {
        if (l0(qFSPullRefreshLayout)) {
            return;
        }
        QLog.d("LOAD-QFSLayerLoadFooterView", 1, "[onPull] load more to pull state.");
        QFSPageTurnContainer.j jVar = this.f89630d;
        if (jVar != null) {
            jVar.c(true, f16);
        }
    }

    public void U(QFSPullRefreshLayout qFSPullRefreshLayout) {
        QFSPageTurnContainer.j jVar;
        if (!l0(qFSPullRefreshLayout) && (jVar = this.f89630d) != null) {
            jVar.a(true);
        }
    }

    public int b0() {
        return G;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gfp;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return null;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        this.E = getMeasuredHeight();
    }

    public Map<String, Object> p0(int i3) {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FOOTER_STATUS, Integer.valueOf(i3));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_WEAK_NETWORK_FLAG, Integer.valueOf(QCircleNetWorkTestHelper.f92533b.get() ? 1 : 0));
        Pair<Double, Double> speedAndSucceedRate = VSNetworkSpeedHelper.getNetworkSpeedTest().getSpeedAndSucceedRate();
        if (speedAndSucceedRate != null) {
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AVG_CMD_COST, speedAndSucceedRate.first);
        }
        int o06 = o0() + 1;
        if (o06 > 0) {
            buildElementParams.put("xsj_index", Integer.valueOf(o06));
        }
        QLog.d("LOAD-QFSLayerLoadFooterView", 1, "[getFooterDynamicParams] feedPos: " + o06 + " | loadStatus: " + i3);
        return buildElementParams;
    }

    public void r0(View view, int i3) {
        Map<String, Object> p06 = p0(i3);
        p06.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_BLANK_TIP);
        VideoReport.reportEvent("ev_xsj_abnormal_imp", view, p06);
    }

    public void s(QFSPullRefreshLayout qFSPullRefreshLayout) {
        if (l0(qFSPullRefreshLayout)) {
            return;
        }
        u0();
    }

    public void s0(View view) {
        VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_BLANK_TIP);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_NONE);
    }

    public void setHideSloganImage(boolean z16) {
        this.f89635m = z16;
    }

    public void setLoadText(String str) {
        this.f89631e.setText(str);
    }

    public void setOnRefreshViewStatusListener(QFSPageTurnContainer.j jVar) {
        this.f89630d = jVar;
    }

    public void setShowLoadText(boolean z16) {
        this.C = z16;
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        TextView textView;
        super.setVisibility(i3);
        if (i3 == 0 && (textView = this.f89631e) != null && textView.getVisibility() == 0) {
            r0(this, 2);
        }
        QLog.d("LOAD-QFSLayerLoadFooterView", 1, "[setVisibility] visibility: " + i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u0() {
        w0();
        v0();
        this.f89633h.setVisibility(0);
        k0();
        m0();
        invalidate();
        QFSPageTurnContainer.j jVar = this.f89630d;
        if (jVar != null) {
            jVar.b(true);
        }
    }

    public QFSLayerLoadFooterView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QFSLayerLoadFooterView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f89635m = false;
        this.C = false;
        this.D = false;
        this.E = 0;
        q0(this);
    }

    @Override // com.tencent.biz.qqcircle.immersive.refresh.b
    public View getRefreshView() {
        return this;
    }

    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public void setReportBean(Object obj) {
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    protected void bindData(Object obj, int i3) {
    }
}
