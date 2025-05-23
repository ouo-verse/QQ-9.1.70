package com.tencent.mobileqq.widget.qus;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* compiled from: P */
/* loaded from: classes20.dex */
public abstract class QUSBaseHalfScreenFloatingView extends FrameLayout {
    protected boolean C;
    protected float D;
    private int E;
    protected View F;
    o G;
    m H;
    l I;
    protected final List<p> J;
    protected final List<n> K;
    protected final List<k> L;
    protected final ValueAnimator.AnimatorUpdateListener M;
    protected FrameLayout N;
    protected ViewGroup P;
    protected FrameLayout Q;
    protected boolean R;
    protected boolean S;
    protected boolean T;
    protected boolean U;
    protected boolean V;
    protected boolean W;

    /* renamed from: a0, reason: collision with root package name */
    protected boolean f317206a0;

    /* renamed from: b0, reason: collision with root package name */
    protected boolean f317207b0;

    /* renamed from: c0, reason: collision with root package name */
    protected boolean f317208c0;

    /* renamed from: d, reason: collision with root package name */
    protected int f317209d;

    /* renamed from: d0, reason: collision with root package name */
    protected boolean f317210d0;

    /* renamed from: e, reason: collision with root package name */
    protected int f317211e;

    /* renamed from: e0, reason: collision with root package name */
    protected boolean f317212e0;

    /* renamed from: f, reason: collision with root package name */
    protected int f317213f;

    /* renamed from: f0, reason: collision with root package name */
    protected boolean f317214f0;

    /* renamed from: g0, reason: collision with root package name */
    protected int f317215g0;

    /* renamed from: h, reason: collision with root package name */
    protected int f317216h;

    /* renamed from: h0, reason: collision with root package name */
    protected boolean f317217h0;

    /* renamed from: i, reason: collision with root package name */
    protected int f317218i;

    /* renamed from: i0, reason: collision with root package name */
    protected boolean f317219i0;

    /* renamed from: j0, reason: collision with root package name */
    private int f317220j0;

    /* renamed from: k0, reason: collision with root package name */
    protected com.tencent.mobileqq.widget.qus.d f317221k0;

    /* renamed from: l0, reason: collision with root package name */
    private int f317222l0;

    /* renamed from: m, reason: collision with root package name */
    protected float f317223m;

    /* renamed from: m0, reason: collision with root package name */
    private float f317224m0;

    /* renamed from: n0, reason: collision with root package name */
    private float f317225n0;

    /* renamed from: o0, reason: collision with root package name */
    private float f317226o0;

    /* renamed from: p0, reason: collision with root package name */
    private float f317227p0;

    /* renamed from: q0, reason: collision with root package name */
    private int f317228q0;

    /* renamed from: r0, reason: collision with root package name */
    private byte f317229r0;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes20.dex */
    public @interface QUSHalfScreenFloatAnimationMode {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes20.dex */
    public @interface QUSHalfScreenFloatInitState {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes20.dex */
    public @interface QUSHalfScreenFloatShowMode {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z16) {
            QUSBaseHalfScreenFloatingView qUSBaseHalfScreenFloatingView = QUSBaseHalfScreenFloatingView.this;
            if (qUSBaseHalfScreenFloatingView.P != null) {
                Iterator<k> it = qUSBaseHalfScreenFloatingView.L.iterator();
                while (it.hasNext()) {
                    it.next().a(QUSBaseHalfScreenFloatingView.this.P.getY());
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            QUSBaseHalfScreenFloatingView qUSBaseHalfScreenFloatingView = QUSBaseHalfScreenFloatingView.this;
            if (qUSBaseHalfScreenFloatingView.P == null) {
                return;
            }
            Iterator<k> it = qUSBaseHalfScreenFloatingView.L.iterator();
            while (it.hasNext()) {
                it.next().a(QUSBaseHalfScreenFloatingView.this.P.getY());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QUSBaseHalfScreenFloatingView qUSBaseHalfScreenFloatingView = QUSBaseHalfScreenFloatingView.this;
            if (!qUSBaseHalfScreenFloatingView.T) {
                o oVar = qUSBaseHalfScreenFloatingView.G;
                if (oVar != null) {
                    oVar.a();
                }
                QUSBaseHalfScreenFloatingView.this.I(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class d extends AnimatorListenerAdapter {
        d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (QLog.isDevelopLevel()) {
                QLog.d("QUSBaseHalfScreenFloatingView", 1, "[appearanceAnimationForResponsive] onAnimationEnd.");
            }
            for (p pVar : QUSBaseHalfScreenFloatingView.this.J) {
                if (QUSBaseHalfScreenFloatingView.this.f317222l0 == 2) {
                    pVar.onShowTotal();
                } else if (QUSBaseHalfScreenFloatingView.this.f317222l0 == 1) {
                    pVar.onShowDefault();
                }
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            if (QLog.isDevelopLevel()) {
                QLog.d("QUSBaseHalfScreenFloatingView", 1, "[appearanceAnimationForResponsive] onAnimationStart.");
            }
            for (p pVar : QUSBaseHalfScreenFloatingView.this.J) {
                if (QUSBaseHalfScreenFloatingView.this.f317222l0 == 2) {
                    pVar.onShowTotalStart();
                } else if (QUSBaseHalfScreenFloatingView.this.f317222l0 == 1) {
                    pVar.onShowDefaultStart();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class e extends AnimatorListenerAdapter {
        e() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z16) {
            QUSBaseHalfScreenFloatingView qUSBaseHalfScreenFloatingView = QUSBaseHalfScreenFloatingView.this;
            if (qUSBaseHalfScreenFloatingView.P != null && qUSBaseHalfScreenFloatingView.L.size() > 0) {
                Iterator<k> it = QUSBaseHalfScreenFloatingView.this.L.iterator();
                while (it.hasNext()) {
                    it.next().a(QUSBaseHalfScreenFloatingView.this.P.getY());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class f extends AnimatorListenerAdapter {
        f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (QLog.isDevelopLevel()) {
                QLog.d("QUSBaseHalfScreenFloatingView", 1, "[showTotalHeight] onAnimationEnd.");
            }
            Iterator<p> it = QUSBaseHalfScreenFloatingView.this.J.iterator();
            while (it.hasNext()) {
                it.next().onShowTotal();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            if (QLog.isDevelopLevel()) {
                QLog.d("QUSBaseHalfScreenFloatingView", 1, "[showTotalHeight] onAnimationStart.");
            }
            Iterator<p> it = QUSBaseHalfScreenFloatingView.this.J.iterator();
            while (it.hasNext()) {
                it.next().onShowTotalStart();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class g extends AnimatorListenerAdapter {
        g() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (QLog.isDevelopLevel()) {
                QLog.d("QUSBaseHalfScreenFloatingView", 1, "[showDefaultHeight] onAnimationEnd.");
            }
            Iterator<p> it = QUSBaseHalfScreenFloatingView.this.J.iterator();
            while (it.hasNext()) {
                it.next().onShowDefault();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            if (QLog.isDevelopLevel()) {
                QLog.d("QUSBaseHalfScreenFloatingView", 1, "[showDefaultHeight] onAnimationStart.");
            }
            Iterator<p> it = QUSBaseHalfScreenFloatingView.this.J.iterator();
            while (it.hasNext()) {
                it.next().onShowDefaultStart();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class h extends AnimatorListenerAdapter {
        h() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (QLog.isDevelopLevel()) {
                QLog.d("QUSBaseHalfScreenFloatingView", 1, "[showMinHeight] onAnimationEnd.");
            }
            Iterator<p> it = QUSBaseHalfScreenFloatingView.this.J.iterator();
            while (it.hasNext()) {
                it.next().onShowMin();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            if (QLog.isDevelopLevel()) {
                QLog.d("QUSBaseHalfScreenFloatingView", 1, "[showMinHeight] onAnimationStart.");
            }
            Iterator<p> it = QUSBaseHalfScreenFloatingView.this.J.iterator();
            while (it.hasNext()) {
                it.next().onShowMinStart();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class i extends AnimatorListenerAdapter {
        i() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (QLog.isDevelopLevel()) {
                QLog.d("QUSBaseHalfScreenFloatingView", 1, "[dismissWithAnimation] onAnimationEnd.");
            }
            QUSBaseHalfScreenFloatingView qUSBaseHalfScreenFloatingView = QUSBaseHalfScreenFloatingView.this;
            qUSBaseHalfScreenFloatingView.f317214f0 = false;
            if (qUSBaseHalfScreenFloatingView.I != null && qUSBaseHalfScreenFloatingView.f317220j0 == 1) {
                QUSBaseHalfScreenFloatingView.this.I.onDismiss();
            }
            QUSBaseHalfScreenFloatingView.this.setVisibility(8);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            if (QLog.isDevelopLevel()) {
                QLog.d("QUSBaseHalfScreenFloatingView", 1, "[dismissWithAnimation] onAnimationStart.");
            }
            QUSBaseHalfScreenFloatingView qUSBaseHalfScreenFloatingView = QUSBaseHalfScreenFloatingView.this;
            qUSBaseHalfScreenFloatingView.f317214f0 = true;
            if (qUSBaseHalfScreenFloatingView.H != null && qUSBaseHalfScreenFloatingView.f317220j0 == 1) {
                QUSBaseHalfScreenFloatingView.this.H.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class j extends AnimatorListenerAdapter {
        j() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z16) {
            QUSBaseHalfScreenFloatingView qUSBaseHalfScreenFloatingView = QUSBaseHalfScreenFloatingView.this;
            if (qUSBaseHalfScreenFloatingView.P != null) {
                Iterator<k> it = qUSBaseHalfScreenFloatingView.L.iterator();
                while (it.hasNext()) {
                    it.next().a(QUSBaseHalfScreenFloatingView.this.P.getY());
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface k {
        void a(float f16);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface l {
        void onDismiss();
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface m {
        void a();
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface n {
        void onFinishDrag();

        void onStartDrag();
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface o {
        void a();

        boolean onClick(View view);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface p {
        void onShowDefault();

        void onShowDefaultStart();

        void onShowMin();

        void onShowMinStart();

        void onShowTotal();

        void onShowTotalStart();
    }

    public QUSBaseHalfScreenFloatingView(@NonNull Context context) {
        this(context, null);
    }

    private void G(MotionEvent motionEvent) {
        float rawY = motionEvent.getRawY();
        Q(rawY);
        if (!this.f317207b0) {
            this.f317207b0 = true;
            Iterator<n> it = this.K.iterator();
            while (it.hasNext()) {
                it.next().onStartDrag();
            }
        }
        float f16 = rawY - this.f317224m0;
        float y16 = this.P.getY();
        float f17 = (f16 * this.D) + y16;
        if (f17 > this.f317216h && f17 < this.f317218i - this.f317211e) {
            this.P.setY(f17);
        }
        Iterator<k> it5 = this.L.iterator();
        while (it5.hasNext()) {
            it5.next().a(y16);
        }
        this.f317224m0 = rawY;
        R(true);
    }

    private void H() {
        if (this.f317207b0) {
            this.f317207b0 = false;
            Iterator<n> it = this.K.iterator();
            while (it.hasNext()) {
                it.next().onFinishDrag();
            }
        }
        float y16 = this.f317218i - this.P.getY();
        float A = A();
        if (y16 >= A) {
            int i3 = this.f317222l0;
            if (i3 <= 1) {
                if (y16 > (this.f317213f + A) / 2.0f) {
                    P(0);
                } else if (this.f317229r0 == 2) {
                    P(1);
                } else if (this.f317210d0) {
                    N(0);
                } else {
                    O(0);
                }
            } else if (i3 == 2) {
                if (y16 < (this.f317213f + A) / 2.0f) {
                    if (this.f317210d0) {
                        N(0);
                    } else {
                        O(0);
                    }
                } else if (this.f317229r0 == 1) {
                    if (this.f317210d0) {
                        N(0);
                    } else {
                        O(0);
                    }
                } else {
                    P(0);
                }
            }
        } else {
            int i16 = this.f317222l0;
            if (i16 >= 1) {
                if (y16 <= (this.f317211e + A) / 2.0f) {
                    O(0);
                } else if (this.f317229r0 == 1) {
                    O(1);
                } else {
                    N(0);
                }
            } else if (i16 == 0) {
                if (y16 >= (this.f317211e + A) / 2.0f) {
                    N(0);
                } else if (this.f317229r0 == 2) {
                    N(1);
                } else {
                    O(0);
                }
            }
        }
        this.f317229r0 = (byte) 0;
        getParent().requestDisallowInterceptTouchEvent(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(View view) {
        o oVar = this.G;
        if (oVar != null && oVar.onClick(view)) {
            return;
        }
        if (this.f317220j0 == 0) {
            if (this.f317210d0 && this.f317222l0 == 2) {
                N(0);
                return;
            } else {
                O(0);
                return;
            }
        }
        if (this.f317210d0 && this.f317222l0 == 2) {
            N(0);
        } else {
            t();
        }
    }

    private void M(float f16) {
        FrameLayout frameLayout = this.Q;
        if (frameLayout != null && f16 != frameLayout.getAlpha()) {
            if (!E().booleanValue()) {
                this.Q.setAlpha(f16);
                return;
            }
            FrameLayout frameLayout2 = this.Q;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(frameLayout2, com.tencent.luggage.wxa.c8.c.f123400v, frameLayout2.getAlpha(), f16);
            ofFloat.setDuration(this.f317209d);
            ofFloat.start();
        }
    }

    private void Q(float f16) {
        float f17 = f16 - this.f317224m0;
        if (Math.abs(f17) > this.f317228q0 * 2) {
            if (f17 > 0.0f) {
                this.f317229r0 = (byte) 1;
            } else if (f17 < 0.0f) {
                this.f317229r0 = (byte) 2;
            }
        }
        byte b16 = this.f317229r0;
        if ((b16 == 1 && f17 <= 0.0f) || (b16 == 2 && f17 >= 0.0f)) {
            this.f317229r0 = (byte) 0;
        }
    }

    private void R(boolean z16) {
        ViewParent parent;
        if (this.f317217h0 && (parent = getParent()) != null) {
            parent.requestDisallowInterceptTouchEvent(z16);
        }
    }

    private void m(float f16, int i3, AnimatorListenerAdapter animatorListenerAdapter) {
        float y16 = this.P.getY();
        if (y16 < this.f317216h || Math.abs(y16 - f16) < 1.0E-6f) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.P, "y", y16, f16);
        if (i3 == 1) {
            ofFloat.setInterpolator(new OvershootInterpolator(1.0f));
        } else if (i3 == 0) {
            ofFloat.setInterpolator(new DecelerateInterpolator(0.5f));
        }
        ofFloat.addListener(animatorListenerAdapter);
        if (!this.L.isEmpty()) {
            ofFloat.addUpdateListener(this.M);
            ofFloat.addListener(new a());
        }
        ofFloat.setDuration(this.f317209d).start();
    }

    private void o() {
        int i3;
        if (this.f317222l0 == 1) {
            i3 = this.f317218i - this.f317221k0.defaultHeight();
        } else {
            i3 = this.f317216h;
        }
        this.P.setY(this.f317218i);
        if (QLog.isDevelopLevel()) {
            QLog.d("QUSBaseHalfScreenFloatingView", 1, "[appearanceAnimationForResponsive] targetY=" + i3);
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.P, "y", this.f317218i, i3);
        ofFloat.setInterpolator(new DecelerateInterpolator(0.5f));
        ofFloat.addListener(new d());
        if (this.L.size() > 0) {
            ofFloat.addUpdateListener(this.M);
            ofFloat.addListener(new e());
        }
        ofFloat.setDuration(this.f317209d).start();
        if (QLog.isDevelopLevel()) {
            QLog.d("QUSBaseHalfScreenFloatingView", 1, "[appearanceAnimationForResponsive] start. translationY=" + ofFloat.hashCode());
        }
        M(1.0f);
    }

    private void p() {
        int i3;
        int i16;
        int i17;
        float f16;
        int i18 = this.f317222l0;
        if (i18 == 2) {
            i17 = this.f317216h;
        } else {
            if (i18 == 1) {
                i3 = this.f317218i;
                i16 = this.f317221k0.defaultHeight();
            } else {
                i3 = this.f317218i;
                i16 = this.f317211e;
            }
            i17 = i3 - i16;
        }
        this.P.setY(i17);
        FrameLayout frameLayout = this.Q;
        if (frameLayout != null) {
            if (this.f317222l0 == 0) {
                f16 = 0.0f;
            } else {
                f16 = 1.0f;
            }
            frameLayout.setAlpha(f16);
        }
        for (p pVar : this.J) {
            int i19 = this.f317222l0;
            if (i19 == 2) {
                pVar.onShowTotal();
            } else if (i19 == 1) {
                pVar.onShowDefault();
            } else {
                pVar.onShowMin();
            }
        }
    }

    public int A() {
        com.tencent.mobileqq.widget.qus.d dVar;
        if (this.f317210d0 && (dVar = this.f317221k0) != null) {
            return dVar.defaultHeight();
        }
        return this.f317211e;
    }

    protected abstract void B();

    protected abstract void C(@Nullable AttributeSet attributeSet, int i3);

    /* JADX INFO: Access modifiers changed from: protected */
    public void D(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, jj2.b.D6);
        this.f317223m = getContext().getResources().getDisplayMetrics().density;
        B();
        this.W = true;
        this.f317211e = u(36);
        this.f317216h = u(88);
        this.f317228q0 = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        int integer = obtainStyledAttributes.getInteger(jj2.b.E6, 88);
        this.E = integer;
        this.f317216h = u(integer);
        if (obtainStyledAttributes.getBoolean(jj2.b.F6, true)) {
            this.Q = new FrameLayout(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.Q.setBackgroundColor(Color.parseColor("#80000000"));
            addView(this.Q, layoutParams);
            this.Q.setClickable(false);
            this.Q.setAlpha(0.0f);
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams2.topMargin = u(this.E);
        layoutParams2.gravity = 81;
        this.P.setBackgroundResource(R.drawable.b4k);
        this.P.setElevation(this.f317223m * 4.0f);
        this.P.setLayoutParams(layoutParams2);
        addView(this.P);
        setForegroundGravity(81);
        C(attributeSet, i3);
        setOnClickListener(new c());
    }

    public Boolean E() {
        return Boolean.valueOf(this.C);
    }

    public int F() {
        ViewGroup viewGroup = this.P;
        if (viewGroup == null) {
            return 0;
        }
        int measuredHeight = viewGroup.getMeasuredHeight();
        if (measuredHeight > 0) {
            return measuredHeight;
        }
        this.P.measure(View.MeasureSpec.makeMeasureSpec(LockFreeTaskQueueCore.MAX_CAPACITY_MASK, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(LockFreeTaskQueueCore.MAX_CAPACITY_MASK, Integer.MIN_VALUE));
        return this.P.getMeasuredHeight();
    }

    public void J() {
        this.N.removeAllViews();
        this.N.setVisibility(8);
    }

    public void K(@NonNull p pVar) {
        this.J.remove(pVar);
    }

    public void L() {
        this.f317218i = 0;
        this.f317211e = u(36);
        this.f317216h = u(this.E);
    }

    public void N(int i3) {
        if (getVisibility() != 0) {
            setVisibility(0);
        }
        if (this.f317210d0) {
            this.f317222l0 = 1;
            m(this.f317218i - A(), i3, new g());
            M(1.0f);
        }
    }

    public void O(int i3) {
        if (this.f317220j0 == 1) {
            t();
            return;
        }
        this.f317222l0 = 0;
        m(this.f317218i - this.f317211e, i3, new h());
        M(0.0f);
    }

    public void P(int i3) {
        if (getVisibility() != 0) {
            setVisibility(0);
        }
        this.f317222l0 = 2;
        m(this.f317216h, i3, new f());
        M(1.0f);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (!this.W) {
                        return super.dispatchTouchEvent(motionEvent);
                    }
                    if (this.f317219i0 && Math.abs(motionEvent.getRawX() - this.f317227p0) > Math.abs(motionEvent.getRawY() - this.f317226o0)) {
                        return super.dispatchTouchEvent(motionEvent);
                    }
                    if (!this.f317208c0 && Math.abs(motionEvent.getRawY() - this.f317225n0) <= this.f317228q0) {
                        z18 = false;
                    } else {
                        z18 = true;
                    }
                    this.f317208c0 = z18;
                    if (!z18) {
                        return super.dispatchTouchEvent(motionEvent);
                    }
                    if (this.S) {
                        G(motionEvent);
                        motionEvent.setAction(3);
                        super.dispatchTouchEvent(motionEvent);
                        return true;
                    }
                    if (!this.f317206a0) {
                        return super.dispatchTouchEvent(motionEvent);
                    }
                    float y16 = this.P.getY();
                    if (motionEvent.getRawY() < this.f317226o0) {
                        if (y16 > this.f317216h) {
                            this.U = true;
                        } else {
                            boolean z26 = !this.f317221k0.canScrollUp(motionEvent.getRawX(), motionEvent.getRawY());
                            this.U = z26;
                            if (!z26) {
                                this.f317224m0 = motionEvent.getRawY();
                            }
                        }
                    } else if (motionEvent.getRawY() > this.f317226o0) {
                        if (y16 > this.f317216h) {
                            this.U = true;
                        } else {
                            com.tencent.mobileqq.widget.qus.d dVar = this.f317221k0;
                            if (dVar != null && !dVar.canScrollDown(motionEvent.getRawX(), motionEvent.getRawY())) {
                                z19 = true;
                            } else {
                                z19 = false;
                            }
                            this.U = z19;
                            if (!z19) {
                                this.f317224m0 = motionEvent.getRawY();
                            }
                        }
                    }
                    this.f317227p0 = motionEvent.getRawX();
                    this.f317226o0 = motionEvent.getRawY();
                    if (this.T && this.U) {
                        G(motionEvent);
                        motionEvent.setAction(3);
                        super.dispatchTouchEvent(motionEvent);
                        return true;
                    }
                }
            } else if (this.S || this.U) {
                H();
            }
        } else {
            this.f317208c0 = false;
            this.U = false;
            this.f317207b0 = false;
            this.f317224m0 = motionEvent.getRawY();
            this.f317225n0 = motionEvent.getRawY();
            this.f317226o0 = this.f317224m0;
            this.f317227p0 = motionEvent.getRawX();
            Rect rect = new Rect();
            FrameLayout frameLayout = this.N;
            if (frameLayout != null) {
                frameLayout.getGlobalVisibleRect(rect);
            }
            if (!rect.isEmpty() && rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.S = z16;
            this.P.getGlobalVisibleRect(rect);
            if (!rect.isEmpty() && rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                z17 = true;
            } else {
                z17 = false;
            }
            this.T = z17;
        }
        if (!this.T && !this.S && (this.f317222l0 == 0 || !this.V)) {
            return false;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (dispatchTouchEvent) {
            R(true);
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(@Nullable AttributeSet attributeSet, int i3, FrameLayout.LayoutParams layoutParams) {
        FrameLayout frameLayout = this.N;
        if (frameLayout == null) {
            return;
        }
        frameLayout.setLayoutParams(layoutParams);
        this.F = new QUSHalfScreenDefaultHeaderView(getContext(), attributeSet, i3);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, ViewUtils.dpToPx(14.0f));
        ((QUSHalfScreenDefaultHeaderView) this.F).setFloatingView(this);
        if (AccessibilityUtil.j(getContext())) {
            AccessibilityUtil.n(this, false);
        }
        this.N.addView(this.F, layoutParams2);
        ViewGroup viewGroup = this.P;
        if (viewGroup != null) {
            viewGroup.addView(this.N);
        }
    }

    public void i(@NonNull n nVar) {
        if (!this.K.contains(nVar)) {
            this.K.add(nVar);
        }
    }

    public void j(@NonNull p pVar) {
        if (!this.J.contains(pVar)) {
            this.J.add(pVar);
        }
    }

    public void l(@NonNull k kVar) {
        if (!this.L.contains(kVar)) {
            this.L.add(kVar);
        }
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 8 && motionEvent.isFromSource(8194)) {
            if (QLog.isDevelopLevel()) {
                QLog.d("QUSBaseHalfScreenFloatingView", 1, "onGenericMotionEvent ACTION_SCROLL.");
            }
            return true;
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z16;
        int action = motionEvent.getAction();
        boolean z17 = true;
        if (action == 1 ? !(!this.f317208c0 || !this.f317206a0) : !((action != 2 && action != 3) || !this.U || !this.W || !this.f317206a0)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && !this.f317214f0) {
            z17 = false;
        }
        R(z17);
        return z17;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        Object obj;
        Object obj2 = "null";
        if (this.f317218i <= 0) {
            this.f317218i = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.P.getLayoutParams();
            int measuredWidth = getMeasuredWidth();
            int i19 = (int) (this.f317215g0 * this.f317223m);
            int i26 = -1;
            if (i19 <= 0 || measuredWidth <= i19) {
                i19 = -1;
            }
            if (this.f317212e0) {
                i26 = -2;
            }
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(i19, i26);
            } else {
                layoutParams.width = i19;
                layoutParams.height = i26;
            }
            com.tencent.mobileqq.widget.qus.d dVar = this.f317221k0;
            if (dVar != null && dVar.maxHeight() > 0) {
                this.f317216h = Math.max(u(this.E), this.f317218i - this.f317221k0.maxHeight());
            }
            com.tencent.mobileqq.widget.qus.d dVar2 = this.f317221k0;
            if (dVar2 != null && dVar2.minMarginTop() > 0) {
                this.f317216h = Math.max(u(this.E), this.f317221k0.minMarginTop());
            }
            layoutParams.topMargin = this.f317216h;
            layoutParams.gravity = 81;
            this.P.setLayoutParams(layoutParams);
            this.f317213f = this.f317218i - this.f317216h;
            if (QLog.isDevelopLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[onLayout] init mContainerHeight. mContainerHeight=");
                sb5.append(this.f317218i);
                sb5.append(", mMinimumMarginDp=");
                sb5.append(this.E);
                sb5.append(", mController maxHeight=");
                com.tencent.mobileqq.widget.qus.d dVar3 = this.f317221k0;
                if (dVar3 != null) {
                    obj2 = Integer.valueOf(dVar3.maxHeight());
                }
                sb5.append(obj2);
                sb5.append(", mMinimumMarginTop=");
                sb5.append(this.f317216h);
                QLog.d("QUSBaseHalfScreenFloatingView", 1, sb5.toString());
                return;
            }
            return;
        }
        if (this.f317212e0) {
            int measuredHeight = this.P.getMeasuredHeight();
            if (this.f317221k0.maxHeight() > 0 && measuredHeight > this.f317221k0.maxHeight()) {
                measuredHeight = this.f317221k0.maxHeight();
            }
            if (this.f317221k0.minMarginTop() > 0 && measuredHeight > this.f317221k0.minMarginTop()) {
                measuredHeight = this.f317218i - this.f317221k0.minMarginTop();
            }
            int max = Math.max(u(this.E), this.f317218i - measuredHeight);
            this.f317216h = max;
            this.f317213f = this.f317218i - max;
            if (QLog.isDevelopLevel()) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append("[onLayout] height wrap content adjust. contentHeight=");
                sb6.append(measuredHeight);
                sb6.append(", mMinimumMarginDp=");
                sb6.append(this.E);
                sb6.append(", mController=");
                com.tencent.mobileqq.widget.qus.d dVar4 = this.f317221k0;
                if (dVar4 == null) {
                    obj = "null";
                } else {
                    obj = Integer.valueOf(dVar4.maxHeight());
                }
                sb6.append(obj);
                sb6.append(", mMinimumMarginTop=");
                sb6.append(this.f317216h);
                QLog.d("QUSBaseHalfScreenFloatingView", 1, sb6.toString());
            }
        }
        super.onLayout(z16, i3, i16, i17, i18);
        if (QLog.isDevelopLevel()) {
            StringBuilder sb7 = new StringBuilder();
            sb7.append("[onLayout] mMinimumMarginDp=");
            sb7.append(this.E);
            sb7.append(", mController=");
            com.tencent.mobileqq.widget.qus.d dVar5 = this.f317221k0;
            if (dVar5 != null) {
                obj2 = Integer.valueOf(dVar5.maxHeight());
            }
            sb7.append(obj2);
            sb7.append(", mMinimumMarginTop=");
            sb7.append(this.f317216h);
            QLog.d("QUSBaseHalfScreenFloatingView", 1, sb7.toString());
        }
        if (!this.R) {
            this.R = true;
            if (this.f317220j0 == 1) {
                o();
            } else {
                p();
            }
        }
        if (QLog.isDevelopLevel() && this.P.getLayoutParams() != null) {
            QLog.d("QUSBaseHalfScreenFloatingView", 1, "[onLayout] topMargin=" + ((FrameLayout.LayoutParams) this.P.getLayoutParams()).topMargin);
        }
    }

    public void q() {
        ViewGroup viewGroup;
        FrameLayout frameLayout = this.N;
        if (frameLayout != null && (viewGroup = this.P) != null) {
            viewGroup.removeView(frameLayout);
            this.N = null;
        }
    }

    public void r() {
        FrameLayout frameLayout = this.Q;
        if (frameLayout != null) {
            removeView(frameLayout);
            this.Q = null;
        }
    }

    public void setAnimationDuration(int i3) {
        this.f317209d = i3;
    }

    public void setContentViewBackgroundResource(int i3) {
        float u16 = u(8);
        this.P.setBackground(ie0.a.f().l(getContext(), i3, new float[]{u16, u16, u16, u16, 0.0f, 0.0f, 0.0f, 0.0f}, 1000));
    }

    public void setDraggable(boolean z16) {
        this.W = z16;
    }

    public void setEnableParentDisallowInterruptTouchEvent(boolean z16) {
        this.f317217h0 = z16;
    }

    public void setHeaderView(View view) {
        View view2;
        FrameLayout frameLayout;
        if (view != null && (view2 = this.F) != view && (frameLayout = this.N) != null) {
            frameLayout.removeView(view2);
            this.F = view;
            this.N.addView(view);
            this.N.setVisibility(0);
        }
    }

    public void setIgnoreHorizontalMove(boolean z16) {
        this.f317219i0 = z16;
    }

    public void setIsContentDraggable(boolean z16) {
        this.f317206a0 = z16;
    }

    public void setIsHeightWrapContent(boolean z16) {
        this.f317212e0 = z16;
    }

    public void setMaxWidthDp(int i3) {
        if (i3 != this.f317215g0) {
            this.f317215g0 = i3;
            L();
            invalidate();
        }
    }

    public void setMoveRatio(float f16) {
        this.D = f16;
    }

    public void setOnDismissListener(@Nullable l lVar) {
        this.I = lVar;
    }

    public void setOnDismissStartListener(m mVar) {
        this.H = mVar;
    }

    public void setOnOutsideAreaClickListener(o oVar) {
        this.G = oVar;
    }

    public void setOnOutsideClickListener(@Nullable o oVar) {
        this.G = oVar;
    }

    public void setOutSideTouchEnable(boolean z16) {
        this.V = z16;
    }

    public void setQUSDragFloatController(com.tencent.mobileqq.widget.qus.d dVar) {
        int i3;
        boolean z16;
        if (dVar == null) {
            return;
        }
        this.f317221k0 = dVar;
        View createContentView = dVar.createContentView();
        if (createContentView != null) {
            if (createContentView.getParent() != null) {
                ((ViewGroup) createContentView.getParent()).removeView(createContentView);
            }
            this.P.addView(y(createContentView));
        }
        this.f317220j0 = dVar.showMode();
        this.f317221k0.defaultHeight();
        int i16 = 0;
        if (this.f317220j0 == 0) {
            i3 = Math.max(this.f317211e, dVar.minHeight());
        } else {
            i3 = 0;
        }
        this.f317211e = i3;
        int i17 = 1;
        if (this.f317221k0.defaultHeight() > this.f317211e) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f317210d0 = z16;
        int initState = this.f317221k0.initState();
        if (initState != 0) {
            if (initState != 1) {
                if (initState != 2) {
                    this.f317222l0 = 2;
                    return;
                } else {
                    this.f317222l0 = 2;
                    return;
                }
            }
            if (!this.f317210d0) {
                i17 = 2;
            }
            this.f317222l0 = i17;
            return;
        }
        if (this.f317220j0 != 0) {
            i16 = 2;
        }
        this.f317222l0 = i16;
    }

    public void setThemeId(int i3) {
        float u16 = u(8);
        this.P.setBackground(ie0.a.f().l(getContext(), R.color.qui_common_bg_middle_light, new float[]{u16, u16, u16, u16, 0.0f, 0.0f, 0.0f, 0.0f}, i3));
    }

    public void t() {
        if (this.f317222l0 == 0) {
            return;
        }
        this.f317222l0 = 0;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.P, "y", this.P.getY(), this.f317218i - this.f317211e);
        ofFloat.setInterpolator(new DecelerateInterpolator(0.5f));
        ofFloat.addListener(new i());
        if (!this.L.isEmpty()) {
            ofFloat.addUpdateListener(this.M);
            ofFloat.addListener(new j());
        }
        ofFloat.setDuration(this.f317209d).start();
        M(0.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int u(int i3) {
        return (int) ((i3 * this.f317223m) + 0.5f);
    }

    public void v(boolean z16) {
        this.C = z16;
    }

    public int w() {
        return this.f317209d;
    }

    public View x() {
        return this.P;
    }

    public abstract View y(View view);

    public int z() {
        return this.f317222l0;
    }

    public QUSBaseHalfScreenFloatingView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QUSBaseHalfScreenFloatingView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f317209d = 200;
        this.C = true;
        this.D = 1.0f;
        this.G = null;
        this.H = null;
        this.I = null;
        this.J = new ArrayList();
        this.K = new ArrayList();
        this.L = new ArrayList();
        this.M = new b();
        this.R = false;
        this.S = false;
        this.T = false;
        this.U = false;
        this.V = true;
        this.f317206a0 = true;
        this.f317207b0 = false;
        this.f317208c0 = false;
        this.f317210d0 = false;
        this.f317212e0 = false;
        this.f317214f0 = false;
        this.f317215g0 = 0;
        this.f317217h0 = false;
        this.f317219i0 = false;
        this.f317220j0 = 0;
        this.f317229r0 = (byte) 0;
        D(context, attributeSet, i3);
    }
}
