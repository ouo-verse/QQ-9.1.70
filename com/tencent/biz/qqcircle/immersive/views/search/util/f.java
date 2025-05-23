package com.tencent.biz.qqcircle.immersive.views.search.util;

import android.view.View;
import android.widget.ImageView;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QFSSearchBean;
import com.tencent.biz.qqcircle.immersive.search.viewmodel.QFSSearchViewModel;
import com.tencent.biz.qqcircle.immersive.views.search.util.QFSSearchVideoPlayHelper;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes4.dex */
public class f implements View.OnClickListener, QFSSearchVideoPlayHelper.a {

    /* renamed from: d, reason: collision with root package name */
    private final ImageView f91252d;

    /* renamed from: e, reason: collision with root package name */
    private QFSSearchViewModel f91253e;

    /* renamed from: f, reason: collision with root package name */
    private final b f91254f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f91255h;

    /* renamed from: i, reason: collision with root package name */
    private final Observer<Boolean> f91256i = new a();

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a implements Observer<Boolean> {

        /* renamed from: d, reason: collision with root package name */
        private boolean f91257d = true;

        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            boolean N1 = f.this.f91253e.N1();
            if (N1 == this.f91257d) {
                return;
            }
            this.f91257d = N1;
            f.this.m(N1);
            if (!f.this.f91255h && !N1) {
                f.i(f.this.f91253e.L1(), 2);
            }
            f.this.f91255h = false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface b {
        void B(boolean z16);

        void G();
    }

    public f(View view, b bVar) {
        ImageView imageView = (ImageView) view.findViewById(R.id.f165951y63);
        this.f91252d = imageView;
        imageView.setOnClickListener(this);
        imageView.setVisibility(8);
        this.f91254f = bVar;
    }

    private static void h(boolean z16) {
        int i3;
        HashMap hashMap = new HashMap();
        hashMap.put("xsj_custom_pgid", QCircleDaTongConstant.PageId.PG_XSJ_SEARCH_RESULT_PAGE);
        hashMap.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_MUTE_TIP_TOAST);
        if (z16) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_MUTE_STATE_TYPE, String.valueOf(i3));
        VideoReport.reportEvent("ev_xsj_abnormal_imp", hashMap);
    }

    public static void i(String str, int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put("xsj_custom_pgid", str);
        hashMap.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_EXIT_MUTE_TIP);
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_EXIT_MUTE_STATE_TYPE, String.valueOf(i3));
        VideoReport.reportEvent("ev_xsj_abnormal_imp", hashMap);
    }

    private void l() {
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity("exp_qqsearch_hot_search_mutenotifications");
        expEntity.reportExpExposure();
        if ("exp_qqsearch_hot_search_mutenotifications_B".equals(expEntity.getAssignment())) {
            QCircleToast.h(R.string.f195104dp, 1);
            h(this.f91255h);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(boolean z16) {
        this.f91254f.G();
        n();
        this.f91254f.B(z16);
    }

    private void n() {
        if (this.f91253e.N1()) {
            this.f91252d.setImageResource(R.drawable.nrv);
            QFSSearchViewModel qFSSearchViewModel = this.f91253e;
            if (!qFSSearchViewModel.f89998m) {
                qFSSearchViewModel.f89998m = true;
                l();
                return;
            }
            return;
        }
        this.f91252d.setImageResource(R.drawable.f162061ns0);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.search.util.QFSSearchVideoPlayHelper.a
    public boolean H() {
        if (tb0.a.f435779d.b()) {
            return true;
        }
        if (!f()) {
            return false;
        }
        QFSSearchViewModel qFSSearchViewModel = this.f91253e;
        if (qFSSearchViewModel != null && qFSSearchViewModel.N1()) {
            return true;
        }
        return false;
    }

    public void e() {
        this.f91252d.setVisibility(8);
        this.f91253e.M1().removeObserver(this.f91256i);
    }

    public boolean f() {
        QCircleInitBean qCircleInitBean = QCirclePluginUtil.getQCircleInitBean(this.f91252d.getContext());
        if (!(qCircleInitBean instanceof QFSSearchBean)) {
            return false;
        }
        return ((QFSSearchBean) qCircleInitBean).isMute();
    }

    public void g() {
        this.f91253e.M1().removeObserver(this.f91256i);
    }

    public void j(QFSSearchViewModel qFSSearchViewModel) {
        this.f91253e = qFSSearchViewModel;
    }

    public void k() {
        if (!f()) {
            return;
        }
        this.f91252d.setVisibility(0);
        n();
        this.f91253e.M1().observeForever(this.f91256i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.f91252d) {
            this.f91255h = true;
            this.f91253e.P1(!r1.N1());
            if (!this.f91253e.N1()) {
                i(QCircleDaTongConstant.PageId.PG_XSJ_SEARCH_RESULT_PAGE, 1);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.search.util.QFSSearchVideoPlayHelper.a
    public void onPlay() {
        if (!f()) {
            return;
        }
        k();
    }
}
