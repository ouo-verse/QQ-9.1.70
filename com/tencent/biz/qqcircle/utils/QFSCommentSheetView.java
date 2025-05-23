package com.tencent.biz.qqcircle.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
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
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.utils.QFSHalfScreenFloatingView;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFSCommentSheetView extends FrameLayout {
    private boolean C;
    private boolean D;
    private boolean E;
    private boolean F;
    private final List<i> G;
    protected final List<k> H;
    protected final List<j> I;
    protected final List<h> J;
    private QFSHalfScreenFloatingView.a K;
    protected final ValueAnimator.AnimatorUpdateListener L;
    protected FrameLayout M;
    protected ViewGroup N;
    protected FrameLayout P;
    protected boolean Q;
    protected boolean R;
    protected boolean S;
    protected boolean T;
    protected boolean U;
    protected boolean V;
    protected boolean W;

    /* renamed from: a0, reason: collision with root package name */
    protected boolean f92577a0;

    /* renamed from: b0, reason: collision with root package name */
    protected boolean f92578b0;

    /* renamed from: c0, reason: collision with root package name */
    protected boolean f92579c0;

    /* renamed from: d, reason: collision with root package name */
    protected int f92580d;

    /* renamed from: d0, reason: collision with root package name */
    protected boolean f92581d0;

    /* renamed from: e, reason: collision with root package name */
    protected int f92582e;

    /* renamed from: e0, reason: collision with root package name */
    protected boolean f92583e0;

    /* renamed from: f, reason: collision with root package name */
    protected int f92584f;

    /* renamed from: f0, reason: collision with root package name */
    protected com.tencent.mobileqq.widget.qus.d f92585f0;

    /* renamed from: g0, reason: collision with root package name */
    private int f92586g0;

    /* renamed from: h, reason: collision with root package name */
    protected boolean f92587h;

    /* renamed from: h0, reason: collision with root package name */
    private float f92588h0;

    /* renamed from: i, reason: collision with root package name */
    protected float f92589i;

    /* renamed from: i0, reason: collision with root package name */
    private float f92590i0;

    /* renamed from: j0, reason: collision with root package name */
    private float f92591j0;

    /* renamed from: k0, reason: collision with root package name */
    private float f92592k0;

    /* renamed from: l0, reason: collision with root package name */
    private int f92593l0;

    /* renamed from: m, reason: collision with root package name */
    protected View f92594m;

    /* renamed from: m0, reason: collision with root package name */
    private byte f92595m0;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            QFSCommentSheetView qFSCommentSheetView = QFSCommentSheetView.this;
            if (qFSCommentSheetView.N == null) {
                return;
            }
            Iterator<h> it = qFSCommentSheetView.J.iterator();
            while (it.hasNext()) {
                it.next().a(QFSCommentSheetView.this.N.getY());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QFSCommentSheetView qFSCommentSheetView = QFSCommentSheetView.this;
            if (!qFSCommentSheetView.R) {
                qFSCommentSheetView.z(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            Iterator<k> it = QFSCommentSheetView.this.H.iterator();
            while (it.hasNext()) {
                it.next().onShowDefault();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            Iterator<k> it = QFSCommentSheetView.this.H.iterator();
            while (it.hasNext()) {
                it.next().onShowDefaultStart();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class d extends AnimatorListenerAdapter {
        d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            Iterator<k> it = QFSCommentSheetView.this.H.iterator();
            while (it.hasNext()) {
                it.next().onShowTotal();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            Iterator<k> it = QFSCommentSheetView.this.H.iterator();
            while (it.hasNext()) {
                it.next().onShowTotalStart();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class e extends AnimatorListenerAdapter {
        e() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            QFSCommentSheetView qFSCommentSheetView = QFSCommentSheetView.this;
            qFSCommentSheetView.f92579c0 = false;
            if (!qFSCommentSheetView.G.isEmpty()) {
                Iterator it = QFSCommentSheetView.this.G.iterator();
                while (it.hasNext()) {
                    ((i) it.next()).onDismiss();
                }
            }
            QFSCommentSheetView.this.setVisibility(8);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            QFSCommentSheetView qFSCommentSheetView = QFSCommentSheetView.this;
            qFSCommentSheetView.f92579c0 = true;
            qFSCommentSheetView.getClass();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class f extends AnimatorListenerAdapter {
        f() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z16) {
            QFSCommentSheetView qFSCommentSheetView = QFSCommentSheetView.this;
            if (qFSCommentSheetView.N != null) {
                Iterator<h> it = qFSCommentSheetView.J.iterator();
                while (it.hasNext()) {
                    it.next().a(QFSCommentSheetView.this.N.getY());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class g extends AnimatorListenerAdapter {
        g() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z16) {
            QFSCommentSheetView qFSCommentSheetView = QFSCommentSheetView.this;
            if (qFSCommentSheetView.N != null) {
                Iterator<h> it = qFSCommentSheetView.J.iterator();
                while (it.hasNext()) {
                    it.next().a(QFSCommentSheetView.this.N.getY());
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface h {
        void a(float f16);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface i {
        void onDismiss();
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface j {
        void onFinishDrag();

        void onStartDrag();
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface k {
        void onShowDefault();

        void onShowDefaultStart();

        void onShowTotal();

        void onShowTotalStart();

        void onStateChange(int i3);
    }

    public QFSCommentSheetView(@NonNull Context context) {
        this(context, null);
    }

    private void E(int i3) {
        if (getVisibility() != 0) {
            this.N.setY(i3);
            setVisibility(0);
        }
    }

    private void F(float f16) {
        FrameLayout frameLayout = this.P;
        if (frameLayout != null && f16 != frameLayout.getAlpha()) {
            if (!w().booleanValue()) {
                this.P.setAlpha(f16);
                return;
            }
            FrameLayout frameLayout2 = this.P;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(frameLayout2, com.tencent.luggage.wxa.c8.c.f123400v, frameLayout2.getAlpha(), f16);
            ofFloat.setDuration(this.f92580d);
            ofFloat.start();
        }
    }

    private void H() {
        E(this.f92584f);
        this.f92586g0 = 1;
        Iterator<k> it = this.H.iterator();
        while (it.hasNext()) {
            it.next().onStateChange(1);
        }
        int r16 = this.f92584f - r();
        QLog.d("QFSCommentSheetView", 1, "[showDefaultHeightInner] targetY: " + r16 + "mContainerHeight: " + this.f92584f + "defaultHeight: " + r());
        f((float) r16, new c());
        F(1.0f);
    }

    private void J() {
        E(this.f92584f);
        this.f92586g0 = 2;
        Iterator<k> it = this.H.iterator();
        while (it.hasNext()) {
            it.next().onStateChange(2);
        }
        f(this.f92582e, new d());
        F(1.0f);
    }

    private void K(float f16) {
        float f17 = f16 - this.f92588h0;
        if (Math.abs(f17) > this.f92593l0 * 2) {
            if (f17 > 0.0f) {
                this.f92595m0 = (byte) 1;
            } else if (f17 < 0.0f) {
                this.f92595m0 = (byte) 2;
            }
        }
        byte b16 = this.f92595m0;
        if ((b16 == 1 && f17 <= 0.0f) || (b16 == 2 && f17 >= 0.0f)) {
            this.f92595m0 = (byte) 0;
        }
    }

    private void M(boolean z16) {
        ViewParent parent;
        if (this.f92581d0 && (parent = getParent()) != null) {
            parent.requestDisallowInterceptTouchEvent(z16);
        }
    }

    private boolean N() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_use_full_comment_panel_container_height", true);
    }

    private void f(float f16, @Nullable AnimatorListenerAdapter animatorListenerAdapter) {
        float y16 = this.N.getY();
        if (y16 < this.f92582e) {
            QLog.d("QFSCommentSheetView", 4, "[animateToTargetY] top: " + y16 + ", minMarginTop: " + this.f92582e);
            return;
        }
        if (Math.abs(y16 - f16) < 1.0E-6f) {
            QLog.d("QFSCommentSheetView", 4, "[animateToTargetY] top: " + y16 + ", targetY: " + f16);
            return;
        }
        int i3 = this.f92582e;
        if (f16 < i3) {
            f16 = i3;
        }
        QLog.d("QFSCommentSheetView", 1, "[animateToTargetY] targetY: " + f16);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.N, "y", y16, f16);
        ofFloat.setInterpolator(new DecelerateInterpolator(0.5f));
        if (animatorListenerAdapter != null) {
            ofFloat.addListener(animatorListenerAdapter);
        }
        if (!this.J.isEmpty()) {
            ofFloat.addUpdateListener(this.L);
            ofFloat.addListener(new g());
        }
        ofFloat.setDuration(this.f92580d).start();
    }

    private void h() {
        int i3 = this.f92584f;
        if (i3 != 0 && i3 != getMeasuredHeight() && N() && getVisibility() != 0) {
            QLog.d("QFSCommentSheetView", 1, "[checkNeedResetContainerHeight] ");
            D();
        }
    }

    private void u() {
        Object obj;
        if (this.f92584f <= 0) {
            this.f92584f = g();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.N.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, -2);
            } else {
                layoutParams.width = -1;
                layoutParams.height = -2;
            }
            layoutParams.gravity = 81;
            this.N.setLayoutParams(layoutParams);
            this.N.setY(this.f92584f);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[initParams] init mContainerHeight. mContainerHeight=");
            sb5.append(this.f92584f);
            sb5.append(", mController maxHeight=");
            com.tencent.mobileqq.widget.qus.d dVar = this.f92585f0;
            if (dVar != null) {
                obj = Integer.valueOf(dVar.maxHeight());
            } else {
                obj = "null";
            }
            sb5.append(obj);
            sb5.append(", mMinimumMarginTop=");
            sb5.append(this.f92582e);
            QLog.d("QFSCommentSheetView", 1, sb5.toString());
            this.F = true;
        }
    }

    private void x(MotionEvent motionEvent) {
        float rawY = motionEvent.getRawY();
        K(rawY);
        if (!this.V) {
            this.V = true;
            Iterator<j> it = this.I.iterator();
            while (it.hasNext()) {
                it.next().onStartDrag();
            }
        }
        float y16 = this.N.getY() + ((rawY - this.f92588h0) * this.f92589i);
        int i3 = this.f92586g0;
        if (i3 == 1) {
            if (y16 > this.f92584f - r() && y16 < this.f92584f) {
                this.N.setY(y16);
                Iterator<h> it5 = this.J.iterator();
                while (it5.hasNext()) {
                    it5.next().a(y16);
                }
            }
        } else if (i3 == 2 && y16 > this.f92582e && y16 < this.f92584f) {
            this.N.setY(y16);
            Iterator<h> it6 = this.J.iterator();
            while (it6.hasNext()) {
                it6.next().a(y16);
            }
        }
        this.f92588h0 = rawY;
        M(true);
    }

    private void y() {
        float f16;
        if (this.V) {
            this.V = false;
            Iterator<j> it = this.I.iterator();
            while (it.hasNext()) {
                it.next().onFinishDrag();
            }
        }
        float y16 = this.N.getY();
        float r16 = r();
        if (this.f92586g0 == 2) {
            f16 = this.f92582e;
        } else {
            f16 = this.f92584f - r16;
        }
        if (y16 - f16 > DisplayUtil.dip2px(getContext(), 30.0f)) {
            QLog.d("QFSCommentSheetView", 4, "[onActionUp] auto dismiss");
            k();
        } else {
            int i3 = this.f92586g0;
            if (i3 == 1) {
                f(this.f92584f - r(), null);
            } else if (i3 == 2) {
                f(this.f92582e, null);
            }
        }
        this.f92595m0 = (byte) 0;
        getParent().requestDisallowInterceptTouchEvent(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(View view) {
        k();
    }

    public void A(i iVar) {
        this.G.remove(iVar);
    }

    public void B(@NonNull k kVar) {
        this.H.remove(kVar);
    }

    public void C(@NonNull h hVar) {
        this.J.remove(hVar);
    }

    public void D() {
        this.f92584f = 0;
        this.f92582e = cx.h();
        this.D = false;
        this.E = false;
        this.F = false;
        QLog.d("QFSCommentSheetView", 1, "[resetContainerHeight] ");
    }

    public void G() {
        h();
        if (this.f92584f <= 0 && !this.F) {
            QLog.d("QFSCommentSheetView", 1, "[showDefaultHeight] waitLayoutComplete");
            this.D = true;
            E(DisplayUtil.getInstantScreenHeight(getContext()));
        } else {
            u();
            H();
        }
    }

    public void I() {
        h();
        if (this.f92584f <= 0 && !this.F) {
            QLog.d("QFSCommentSheetView", 1, "[showTotalHeight] waitLayoutComplete");
            this.E = true;
            E(DisplayUtil.getInstantScreenHeight(getContext()));
        } else {
            u();
            J();
        }
    }

    public void L() {
        int i3 = this.f92586g0;
        if (i3 == 1) {
            I();
        } else if (i3 == 2) {
            G();
        }
    }

    public void c(i iVar) {
        if (this.G.contains(iVar)) {
            return;
        }
        this.G.add(iVar);
    }

    public void d(@NonNull k kVar) {
        if (!this.H.contains(kVar)) {
            this.H.add(kVar);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z16;
        boolean z17;
        boolean z18;
        int i3;
        boolean z19;
        int i16;
        QFSHalfScreenFloatingView.a aVar = this.K;
        if (aVar != null && aVar.onTouchEvent(motionEvent)) {
            QLog.d("QFSCommentSheetView", 4, "[dispatchTouchEvent] outsideTouch consume");
            return true;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (!this.U) {
                        return super.dispatchTouchEvent(motionEvent);
                    }
                    if (this.f92583e0 && Math.abs(motionEvent.getRawX() - this.f92592k0) > Math.abs(motionEvent.getRawY() - this.f92591j0)) {
                        return super.dispatchTouchEvent(motionEvent);
                    }
                    if (!this.W && Math.abs(motionEvent.getRawY() - this.f92590i0) <= this.f92593l0) {
                        z18 = false;
                    } else {
                        z18 = true;
                    }
                    this.W = z18;
                    if (!z18) {
                        return super.dispatchTouchEvent(motionEvent);
                    }
                    if (this.Q) {
                        x(motionEvent);
                        motionEvent.setAction(3);
                        super.dispatchTouchEvent(motionEvent);
                        return true;
                    }
                    float y16 = this.N.getY();
                    if (motionEvent.getRawY() < this.f92591j0) {
                        if (this.f92586g0 == 1) {
                            i16 = this.f92584f - r();
                        } else {
                            i16 = this.f92582e;
                        }
                        if (y16 > i16) {
                            this.S = true;
                        } else {
                            boolean z26 = !this.f92585f0.canScrollUp(motionEvent.getRawX(), motionEvent.getRawY());
                            this.S = z26;
                            if (!z26) {
                                this.f92588h0 = motionEvent.getRawY();
                            }
                        }
                    } else if (motionEvent.getRawY() > this.f92591j0) {
                        if (this.f92586g0 == 1) {
                            i3 = this.f92584f - r();
                        } else {
                            i3 = this.f92582e;
                        }
                        if (y16 > i3) {
                            this.S = true;
                        } else {
                            com.tencent.mobileqq.widget.qus.d dVar = this.f92585f0;
                            if (dVar != null && !dVar.canScrollDown(motionEvent.getRawX(), motionEvent.getRawY())) {
                                z19 = true;
                            } else {
                                z19 = false;
                            }
                            this.S = z19;
                            if (!z19) {
                                this.f92588h0 = motionEvent.getRawY();
                            }
                        }
                    }
                    this.f92592k0 = motionEvent.getRawX();
                    this.f92591j0 = motionEvent.getRawY();
                    if (this.R && this.S) {
                        x(motionEvent);
                        motionEvent.setAction(3);
                        super.dispatchTouchEvent(motionEvent);
                        return true;
                    }
                }
            } else if (this.Q || this.S) {
                y();
            }
        } else {
            this.W = false;
            this.S = false;
            this.V = false;
            this.f92588h0 = motionEvent.getRawY();
            this.f92590i0 = motionEvent.getRawY();
            this.f92591j0 = this.f92588h0;
            this.f92592k0 = motionEvent.getRawX();
            Rect rect = new Rect();
            FrameLayout frameLayout = this.M;
            if (frameLayout != null) {
                frameLayout.getGlobalVisibleRect(rect);
            }
            if (!rect.isEmpty() && rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.Q = z16;
            this.N.getGlobalVisibleRect(rect);
            if (!rect.isEmpty() && rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                z17 = true;
            } else {
                z17 = false;
            }
            this.R = z17;
        }
        if (!this.R && !this.Q && (this.f92586g0 == 0 || !this.T)) {
            return false;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (dispatchTouchEvent) {
            M(true);
        }
        return dispatchTouchEvent;
    }

    public void e(@NonNull h hVar) {
        if (!this.J.contains(hVar)) {
            this.J.add(hVar);
        }
    }

    public int g() {
        int i3 = this.f92584f;
        if (i3 != 0) {
            return i3;
        }
        return com.tencent.biz.qqcircle.comment.af.g(this);
    }

    public void i() {
        ViewGroup viewGroup;
        FrameLayout frameLayout = this.M;
        if (frameLayout != null && (viewGroup = this.N) != null) {
            viewGroup.removeView(frameLayout);
            this.M = null;
        }
    }

    public void j() {
        FrameLayout frameLayout = this.P;
        if (frameLayout != null) {
            removeView(frameLayout);
            this.P = null;
        }
    }

    public void k() {
        if (this.f92586g0 == 0) {
            return;
        }
        this.f92586g0 = 0;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.N, "y", this.N.getY(), this.f92584f);
        ofFloat.setInterpolator(new DecelerateInterpolator(0.5f));
        ofFloat.addListener(new e());
        if (!this.J.isEmpty()) {
            ofFloat.addUpdateListener(this.L);
            ofFloat.addListener(new f());
        }
        ofFloat.setDuration(this.f92580d).start();
        F(0.0f);
    }

    protected int l(int i3) {
        return (int) ((i3 * DisplayUtil.getDensity()) + 0.5f);
    }

    public void m(boolean z16) {
        this.f92587h = z16;
    }

    public int n() {
        return this.f92584f;
    }

    public View o() {
        return this.N;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        QLog.d("QFSCommentSheetView", 1, "[onConfigurationChanged] resetParams");
        k();
        D();
        super.onConfigurationChanged(configuration);
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 8 && motionEvent.isFromSource(8194)) {
            if (QLog.isDevelopLevel()) {
                QLog.d("QFSCommentSheetView", 1, "onGenericMotionEvent ACTION_SCROLL.");
            }
            return true;
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z16;
        boolean z17 = true;
        if (!this.C) {
            return true;
        }
        int action = motionEvent.getAction();
        if (action != 1) {
            if ((action == 2 || action == 3) && this.S && this.U) {
                z16 = true;
            } else {
                z16 = false;
            }
        } else {
            z16 = this.W;
        }
        if (!z16 && !this.f92579c0) {
            z17 = false;
        }
        M(z17);
        return z17;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        if (this.f92584f <= 0) {
            QLog.d("QFSCommentSheetView", 1, "[onLayout] initParam");
            u();
            return;
        }
        super.onLayout(z16, i3, i16, i17, i18);
        if (getVisibility() == 8) {
            this.N.setY(this.f92584f);
        }
        if (this.D) {
            this.D = false;
            H();
        }
        if (this.E) {
            this.E = false;
            J();
        }
    }

    public int q() {
        return this.f92586g0;
    }

    public int r() {
        com.tencent.mobileqq.widget.qus.d dVar;
        if (this.f92577a0 && (dVar = this.f92585f0) != null) {
            return dVar.defaultHeight();
        }
        return 0;
    }

    public float s() {
        int r16;
        int measuredHeight = getMeasuredHeight();
        if (N()) {
            measuredHeight -= r();
            r16 = cx.h();
        } else {
            r16 = r();
        }
        return measuredHeight - r16;
    }

    public void setAnimationDuration(int i3) {
        this.f92580d = i3;
    }

    public void setCanSlide(boolean z16) {
        this.C = z16;
    }

    public void setContentViewBackgroundResource(int i3) {
        float l3 = l(8);
        this.N.setBackground(ie0.a.f().l(getContext(), i3, new float[]{l3, l3, l3, l3, 0.0f, 0.0f, 0.0f, 0.0f}, 1000));
    }

    public void setDraggable(boolean z16) {
        this.U = z16;
    }

    public void setHeaderView(View view) {
        View view2;
        FrameLayout frameLayout;
        if (view != null && (view2 = this.f92594m) != view && (frameLayout = this.M) != null) {
            frameLayout.removeView(view2);
            this.f92594m = view;
            this.M.addView(view);
            this.M.setVisibility(0);
        }
    }

    public void setIgnoreHorizontalMove(boolean z16) {
        this.f92583e0 = z16;
    }

    public void setIsHeightWrapContent(boolean z16) {
        this.f92578b0 = z16;
    }

    public void setMoveRatio(float f16) {
        this.f92589i = f16;
    }

    public void setOutSideTouchEnable(boolean z16) {
        this.T = z16;
    }

    public void setOutsideTouchEventListener(QFSHalfScreenFloatingView.a aVar) {
        this.K = aVar;
    }

    public void setQUSDragFloatController(com.tencent.mobileqq.widget.qus.d dVar) {
        if (dVar == null) {
            return;
        }
        this.f92585f0 = dVar;
        View createContentView = dVar.createContentView();
        if (createContentView != null) {
            if (createContentView.getParent() != null) {
                ((ViewGroup) createContentView.getParent()).removeView(createContentView);
            }
            this.N.addView(p(createContentView));
        }
        int initState = this.f92585f0.initState();
        int i3 = 1;
        if (initState != 0) {
            if (initState != 1) {
                if (initState != 2) {
                    this.f92586g0 = 2;
                    return;
                } else {
                    this.f92586g0 = 2;
                    return;
                }
            }
            if (!this.f92577a0) {
                i3 = 2;
            }
            this.f92586g0 = i3;
            return;
        }
        this.f92586g0 = 1;
    }

    public void setThemeId(int i3) {
        float l3 = l(8);
        this.N.setBackground(ie0.a.f().l(getContext(), R.color.qui_common_bg_middle_light, new float[]{l3, l3, l3, l3, 0.0f, 0.0f, 0.0f, 0.0f}, i3));
    }

    protected void t() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.N = linearLayout;
        linearLayout.setOrientation(1);
    }

    protected void v(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, jj2.b.D6);
        t();
        this.U = true;
        this.f92582e = cx.h();
        this.f92593l0 = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        if (obtainStyledAttributes.getBoolean(jj2.b.F6, true)) {
            this.P = new FrameLayout(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.P.setBackgroundColor(Color.parseColor("#80000000"));
            addView(this.P, layoutParams);
            this.P.setClickable(false);
            this.P.setAlpha(0.0f);
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams2.gravity = 81;
        this.N.setBackgroundResource(R.drawable.b4k);
        this.N.setElevation(DisplayUtil.getDensity() * 4.0f);
        this.N.setLayoutParams(layoutParams2);
        addView(this.N);
        setForegroundGravity(81);
        setOnClickListener(new b());
    }

    public Boolean w() {
        return Boolean.valueOf(this.f92587h);
    }

    public QFSCommentSheetView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QFSCommentSheetView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f92580d = 200;
        this.f92587h = true;
        this.f92589i = 1.0f;
        this.C = true;
        this.G = new ArrayList();
        this.H = new ArrayList();
        this.I = new ArrayList();
        this.J = new ArrayList();
        this.L = new a();
        this.Q = false;
        this.R = false;
        this.S = false;
        this.T = true;
        this.V = false;
        this.W = false;
        this.f92577a0 = true;
        this.f92578b0 = true;
        this.f92579c0 = false;
        this.f92581d0 = false;
        this.f92583e0 = false;
        this.f92595m0 = (byte) 0;
        v(context, attributeSet, i3);
    }

    public View p(View view) {
        return view;
    }
}
