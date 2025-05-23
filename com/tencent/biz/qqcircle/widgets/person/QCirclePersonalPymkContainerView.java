package com.tencent.biz.qqcircle.widgets.person;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.immersive.personal.data.w;
import com.tencent.biz.qqcircle.widgets.pymk.QCirclePYMKRecommendView;
import com.tencent.biz.qqcircle.widgets.pymk.a;
import com.tencent.mobileqq.widget.ak;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes5.dex */
public class QCirclePersonalPymkContainerView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name */
    private QCirclePYMKRecommendView f93687d;

    /* renamed from: e, reason: collision with root package name */
    private int f93688e;

    /* renamed from: f, reason: collision with root package name */
    private int f93689f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            QCirclePersonalPymkContainerView.this.d(Float.parseFloat(valueAnimator.getAnimatedValue().toString()));
        }
    }

    public QCirclePersonalPymkContainerView(Context context) {
        super(context);
        this.f93687d = null;
        this.f93688e = 0;
        this.f93689f = 0;
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z16, boolean z17) {
        QCirclePYMKRecommendView qCirclePYMKRecommendView = this.f93687d;
        if (qCirclePYMKRecommendView == null) {
            QLog.w("PYMK-QCirclePersonalPymkContainerView", 1, "[handlerAnimStateChange] pymk recommend view should not be null.");
            return;
        }
        if (!z16 && !z17) {
            qCirclePYMKRecommendView.setVisibility(8);
        } else if (z16 && z17) {
            qCirclePYMKRecommendView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(float f16) {
        QCirclePYMKRecommendView qCirclePYMKRecommendView = this.f93687d;
        if (qCirclePYMKRecommendView == null) {
            QLog.d("PYMK-QCirclePersonalPymkContainerView", 1, "[handlerAnimationUpdate] pymk recommend content should not be null.");
            return;
        }
        qCirclePYMKRecommendView.setAlpha(1.0f * f16);
        ViewGroup.LayoutParams layoutParams = this.f93687d.getLayoutParams();
        layoutParams.height = (int) (f16 * this.f93688e);
        this.f93687d.setLayoutParams(layoutParams);
    }

    private void f() {
        QCirclePYMKRecommendView qCirclePYMKRecommendView = new QCirclePYMKRecommendView(getContext(), 1001);
        this.f93687d = qCirclePYMKRecommendView;
        qCirclePYMKRecommendView.setVisibility(8);
        this.f93687d.setPageId(this.f93689f);
        addView(this.f93687d);
    }

    private void g(boolean z16) {
        float f16;
        float f17 = 0.0f;
        if (z16) {
            f16 = 0.0f;
        } else {
            f16 = 1.0f;
        }
        if (z16) {
            f17 = 1.0f;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f16, f17);
        ofFloat.setDuration(250L);
        ofFloat.addUpdateListener(new a());
        ofFloat.addListener(new b(z16));
        ofFloat.start();
    }

    public void e() {
        if (this.f93687d == null) {
            QLog.w("PYMK-QCirclePersonalPymkContainerView", 1, "[hidePymkContent] view should not be null.");
        } else {
            g(false);
        }
    }

    public void setPageId(int i3) {
        this.f93689f = i3;
        QCirclePYMKRecommendView qCirclePYMKRecommendView = this.f93687d;
        if (qCirclePYMKRecommendView != null) {
            qCirclePYMKRecommendView.setPageId(i3);
        }
    }

    public void setUserInfo(w wVar) {
        this.f93687d.setUserInfo(wVar);
    }

    public void setWidgetHideIntercept(a.InterfaceC0939a interfaceC0939a) {
        QCirclePYMKRecommendView qCirclePYMKRecommendView = this.f93687d;
        if (qCirclePYMKRecommendView == null) {
            QLog.d("PYMK-QCirclePersonalPymkContainerView", 1, "[setWidgetHideIntercept] recommend adapter should not be null.");
        } else {
            qCirclePYMKRecommendView.setWidgetHideIntercept(interfaceC0939a);
        }
    }

    public QCirclePersonalPymkContainerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f93687d = null;
        this.f93688e = 0;
        this.f93689f = 0;
        f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b extends ak {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f93691d;

        b(boolean z16) {
            this.f93691d = z16;
        }

        @Override // com.tencent.mobileqq.widget.ak, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            QCirclePersonalPymkContainerView.this.c(this.f93691d, false);
        }

        @Override // com.tencent.mobileqq.widget.ak, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            QCirclePersonalPymkContainerView.this.c(this.f93691d, true);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }
}
