package com.tencent.biz.qqcircle.immersive.views.search;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.ak;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudRead$FilterGroup;
import java.util.List;
import q60.d;
import ua0.i;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSSearchFilterBlockContainer extends QFSSearchBlockContainer implements View.OnClickListener {
    private View C;
    private View D;
    private d E;
    private List<FeedCloudRead$FilterGroup> F;
    private p70.d G;

    /* renamed from: d, reason: collision with root package name */
    private final Interpolator f91048d;

    /* renamed from: e, reason: collision with root package name */
    private final Interpolator f91049e;

    /* renamed from: f, reason: collision with root package name */
    private ObjectAnimator f91050f;

    /* renamed from: h, reason: collision with root package name */
    private ObjectAnimator f91051h;

    /* renamed from: i, reason: collision with root package name */
    private View f91052i;

    /* renamed from: m, reason: collision with root package name */
    private View f91053m;

    public QFSSearchFilterBlockContainer(Context context) {
        super(context);
        this.f91048d = new lc0.a(0.39f, 0.0f, 0.23f, 1.0f);
        this.f91049e = new lc0.a(0.39f, 0.0f, 0.23f, 1.0f);
    }

    private void d() {
        i.k(this, QCircleDaTongConstant.ElementId.EM_XSJ_SEARCH_RESULT_FILTER_PANEL, null, 0);
        i.k(this.D, "em_xsj_confirm_button", null, 0);
        i.k(this.C, QCircleDaTongConstant.ElementId.EM_XSJ_CANCEL_BUTTON, null, 0);
    }

    private int e() {
        p70.d dVar = this.G;
        if (dVar == null) {
            return 0;
        }
        return dVar.T1();
    }

    private void g() {
        j();
        EventCollector.getInstance().onViewClicked(this.C);
    }

    private void h() {
        p70.d dVar = this.G;
        if (dVar != null) {
            dVar.a2();
            VideoReport.setElementParam(this.D, QCircleDaTongConstant.ElementParamKey.XSJ_FILTER_OPTION_NAME, this.G.R1());
        }
        EventCollector.getInstance().onViewClicked(this.D);
    }

    private boolean i() {
        List<FeedCloudRead$FilterGroup> list = this.F;
        if (list != null && !list.isEmpty()) {
            return true;
        }
        return false;
    }

    private void j() {
        p70.d dVar = this.G;
        if (dVar != null) {
            dVar.b2();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(int i3) {
        p70.d dVar = this.G;
        if (dVar != null) {
            dVar.d2(i3);
        }
    }

    public void b() {
        QLog.d("QFSSearchFilterBlockContainer", 1, "#changeVisible mCurrentStatus: " + e());
        if (e() == 1) {
            c();
        } else if (e() == 0) {
            l();
        }
    }

    public void c() {
        QLog.d("QFSSearchFilterBlockContainer", 1, "#dismissView mCurrentStatus: " + e());
        if (e() != 1) {
            setVisibility(8);
            return;
        }
        ObjectAnimator objectAnimator = this.f91051h;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            return;
        }
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.f91053m, "translationY", 0.0f, -f()).setDuration(250L);
        this.f91051h = duration;
        duration.setInterpolator(this.f91049e);
        this.f91051h.addListener(new b());
        this.f91051h.start();
    }

    public int f() {
        float f16;
        if (i()) {
            f16 = (this.F.size() * 70) + 100;
        } else {
            f16 = 250.0f;
        }
        return cx.a(f16);
    }

    @Override // com.tencent.biz.richframework.part.block.BlockContainer
    public int getLayoutId() {
        return R.layout.gru;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.block.BlockContainer
    public void initView() {
        super.initView();
        this.f91053m = findViewById(R.id.f52792ar);
        this.f91052i = findViewById(R.id.f52782aq);
        this.C = findViewById(R.id.f3481106);
        this.D = findViewById(R.id.f3630147);
        this.f91053m.setOnClickListener(this);
        this.f91052i.setOnClickListener(this);
        this.C.setOnClickListener(this);
        this.D.setOnClickListener(this);
        this.f91052i.setBackground(ie0.a.f().k(getContext(), R.color.qui_common_overlay_dark, 0.0f, 1000));
        d dVar = new d(new Bundle());
        this.E = dVar;
        registerBlock(dVar);
        getRecyclerView().setNestedScrollingEnabled(false);
        setEnableLoadMore(false);
        setEnableRefresh(false);
        start();
    }

    public void l() {
        QLog.d("QFSSearchFilterBlockContainer", 1, "#showView mCurrentStatus: " + e());
        setVisibility(0);
        if (e() != 0) {
            return;
        }
        ObjectAnimator objectAnimator = this.f91050f;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            return;
        }
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.f91053m, "translationY", -f(), 0.0f).setDuration(250L);
        this.f91050f = duration;
        duration.setInterpolator(this.f91048d);
        this.f91050f.addListener(new a());
        this.f91050f.start();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.f91052i || view == this.C || view == this.D) {
            c();
        }
        if (view == this.f91052i) {
            j();
        } else if (view == this.C) {
            g();
        } else if (view == this.D) {
            h();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setData(List<FeedCloudRead$FilterGroup> list) {
        this.F = list;
        if (!i()) {
            c();
        }
        this.E.setDatas(this.F);
        d();
    }

    public void setFilterViewModel(p70.d dVar) {
        this.G = dVar;
    }

    public QFSSearchFilterBlockContainer(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f91048d = new lc0.a(0.39f, 0.0f, 0.23f, 1.0f);
        this.f91049e = new lc0.a(0.39f, 0.0f, 0.23f, 1.0f);
    }

    public QFSSearchFilterBlockContainer(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f91048d = new lc0.a(0.39f, 0.0f, 0.23f, 1.0f);
        this.f91049e = new lc0.a(0.39f, 0.0f, 0.23f, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends ak {
        a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            QLog.d("QFSSearchFilterBlockContainer", 1, "#showView onAnimationCancel");
        }

        @Override // com.tencent.mobileqq.widget.ak, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            QLog.d("QFSSearchFilterBlockContainer", 1, "#showView onAnimationEnd");
            QFSSearchFilterBlockContainer.this.k(1);
            VideoReport.traverseExposure();
        }

        @Override // com.tencent.mobileqq.widget.ak, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            QLog.d("QFSSearchFilterBlockContainer", 1, "#showView onAnimationStart");
            QFSSearchFilterBlockContainer.this.k(3);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b extends ak {
        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            QLog.d("QFSSearchFilterBlockContainer", 1, "#dismissView onAnimationCancel");
        }

        @Override // com.tencent.mobileqq.widget.ak, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            QLog.d("QFSSearchFilterBlockContainer", 1, "#dismissView onAnimationEnd");
            QFSSearchFilterBlockContainer.this.k(0);
            QFSSearchFilterBlockContainer.this.setVisibility(8);
        }

        @Override // com.tencent.mobileqq.widget.ak, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            QLog.d("QFSSearchFilterBlockContainer", 1, "#dismissView onAnimationStart");
            QFSSearchFilterBlockContainer.this.k(2);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }
}
