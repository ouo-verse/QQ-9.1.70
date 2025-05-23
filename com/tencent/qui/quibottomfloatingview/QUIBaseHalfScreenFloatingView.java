package com.tencent.qui.quibottomfloatingview;

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
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes25.dex */
public abstract class QUIBaseHalfScreenFloatingView extends FrameLayout {
    static IPatchRedirector $redirector_;
    protected boolean C;
    protected float D;
    private int E;
    protected View F;
    o G;
    l H;
    protected final List<p> I;
    protected final List<n> J;
    protected final List<k> K;
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
    protected boolean f363654a0;

    /* renamed from: b0, reason: collision with root package name */
    protected boolean f363655b0;

    /* renamed from: c0, reason: collision with root package name */
    protected boolean f363656c0;

    /* renamed from: d, reason: collision with root package name */
    protected int f363657d;

    /* renamed from: d0, reason: collision with root package name */
    protected boolean f363658d0;

    /* renamed from: e, reason: collision with root package name */
    protected int f363659e;

    /* renamed from: e0, reason: collision with root package name */
    protected boolean f363660e0;

    /* renamed from: f, reason: collision with root package name */
    protected int f363661f;

    /* renamed from: f0, reason: collision with root package name */
    protected int f363662f0;

    /* renamed from: g0, reason: collision with root package name */
    protected boolean f363663g0;

    /* renamed from: h, reason: collision with root package name */
    protected int f363664h;

    /* renamed from: h0, reason: collision with root package name */
    protected boolean f363665h0;

    /* renamed from: i, reason: collision with root package name */
    protected int f363666i;

    /* renamed from: i0, reason: collision with root package name */
    private int f363667i0;

    /* renamed from: j0, reason: collision with root package name */
    protected com.tencent.qui.quibottomfloatingview.b f363668j0;

    /* renamed from: k0, reason: collision with root package name */
    private int f363669k0;

    /* renamed from: l0, reason: collision with root package name */
    private float f363670l0;

    /* renamed from: m, reason: collision with root package name */
    protected float f363671m;

    /* renamed from: m0, reason: collision with root package name */
    private float f363672m0;

    /* renamed from: n0, reason: collision with root package name */
    private float f363673n0;

    /* renamed from: o0, reason: collision with root package name */
    private float f363674o0;

    /* renamed from: p0, reason: collision with root package name */
    private int f363675p0;

    /* renamed from: q0, reason: collision with root package name */
    private byte f363676q0;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes25.dex */
    public @interface QUIHalfScreenFloatAnimationMode {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes25.dex */
    public @interface QUIHalfScreenFloatInitState {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes25.dex */
    public @interface QUIHalfScreenFloatShowMode {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public class a extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QUIBaseHalfScreenFloatingView.this);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, animator, Boolean.valueOf(z16));
                return;
            }
            QUIBaseHalfScreenFloatingView qUIBaseHalfScreenFloatingView = QUIBaseHalfScreenFloatingView.this;
            if (qUIBaseHalfScreenFloatingView.N != null) {
                Iterator<k> it = qUIBaseHalfScreenFloatingView.K.iterator();
                while (it.hasNext()) {
                    it.next().a(QUIBaseHalfScreenFloatingView.this.N.getY());
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    class b implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QUIBaseHalfScreenFloatingView.this);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                return;
            }
            QUIBaseHalfScreenFloatingView qUIBaseHalfScreenFloatingView = QUIBaseHalfScreenFloatingView.this;
            if (qUIBaseHalfScreenFloatingView.N == null) {
                return;
            }
            Iterator<k> it = qUIBaseHalfScreenFloatingView.K.iterator();
            while (it.hasNext()) {
                it.next().a(QUIBaseHalfScreenFloatingView.this.N.getY());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QUIBaseHalfScreenFloatingView.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                QUIBaseHalfScreenFloatingView qUIBaseHalfScreenFloatingView = QUIBaseHalfScreenFloatingView.this;
                if (!qUIBaseHalfScreenFloatingView.S) {
                    o oVar = qUIBaseHalfScreenFloatingView.G;
                    if (oVar != null) {
                        oVar.a();
                    }
                    QUIBaseHalfScreenFloatingView.this.r(view);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public class d extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QUIBaseHalfScreenFloatingView.this);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
                return;
            }
            super.onAnimationEnd(animator);
            if (ud0.d.i()) {
                ud0.d.a("QUIBaseHalfScreenFloatingView", ud0.d.f438811e, "[appearanceAnimationForResponsive] onAnimationEnd.");
            }
            for (p pVar : QUIBaseHalfScreenFloatingView.this.I) {
                if (QUIBaseHalfScreenFloatingView.this.f363669k0 == 2) {
                    pVar.onShowTotal();
                } else if (QUIBaseHalfScreenFloatingView.this.f363669k0 == 1) {
                    pVar.onShowDefault();
                }
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
                return;
            }
            super.onAnimationStart(animator);
            if (ud0.d.i()) {
                ud0.d.a("QUIBaseHalfScreenFloatingView", ud0.d.f438811e, "[appearanceAnimationForResponsive] onAnimationStart.");
            }
            for (p pVar : QUIBaseHalfScreenFloatingView.this.I) {
                if (QUIBaseHalfScreenFloatingView.this.f363669k0 == 2) {
                    pVar.onShowTotalStart();
                } else if (QUIBaseHalfScreenFloatingView.this.f363669k0 == 1) {
                    pVar.onShowDefaultStart();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public class e extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QUIBaseHalfScreenFloatingView.this);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, animator, Boolean.valueOf(z16));
                return;
            }
            QUIBaseHalfScreenFloatingView qUIBaseHalfScreenFloatingView = QUIBaseHalfScreenFloatingView.this;
            if (qUIBaseHalfScreenFloatingView.N != null && qUIBaseHalfScreenFloatingView.K.size() > 0) {
                Iterator<k> it = QUIBaseHalfScreenFloatingView.this.K.iterator();
                while (it.hasNext()) {
                    it.next().a(QUIBaseHalfScreenFloatingView.this.N.getY());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public class f extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QUIBaseHalfScreenFloatingView.this);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
                return;
            }
            super.onAnimationEnd(animator);
            if (ud0.d.i()) {
                ud0.d.a("QUIBaseHalfScreenFloatingView", ud0.d.f438811e, "[showTotalHeight] onAnimationEnd.");
            }
            Iterator<p> it = QUIBaseHalfScreenFloatingView.this.I.iterator();
            while (it.hasNext()) {
                it.next().onShowTotal();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
                return;
            }
            super.onAnimationStart(animator);
            if (ud0.d.i()) {
                ud0.d.a("QUIBaseHalfScreenFloatingView", ud0.d.f438811e, "[showTotalHeight] onAnimationStart.");
            }
            Iterator<p> it = QUIBaseHalfScreenFloatingView.this.I.iterator();
            while (it.hasNext()) {
                it.next().onShowTotalStart();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public class g extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QUIBaseHalfScreenFloatingView.this);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
                return;
            }
            super.onAnimationEnd(animator);
            if (ud0.d.i()) {
                ud0.d.a("QUIBaseHalfScreenFloatingView", ud0.d.f438811e, "[showDefaultHeight] onAnimationEnd.");
            }
            Iterator<p> it = QUIBaseHalfScreenFloatingView.this.I.iterator();
            while (it.hasNext()) {
                it.next().onShowDefault();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
                return;
            }
            super.onAnimationStart(animator);
            if (ud0.d.i()) {
                ud0.d.a("QUIBaseHalfScreenFloatingView", ud0.d.f438811e, "[showDefaultHeight] onAnimationStart.");
            }
            Iterator<p> it = QUIBaseHalfScreenFloatingView.this.I.iterator();
            while (it.hasNext()) {
                it.next().onShowDefaultStart();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public class h extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QUIBaseHalfScreenFloatingView.this);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
                return;
            }
            super.onAnimationEnd(animator);
            if (ud0.d.i()) {
                ud0.d.a("QUIBaseHalfScreenFloatingView", ud0.d.f438811e, "[showMinHeight] onAnimationEnd.");
            }
            Iterator<p> it = QUIBaseHalfScreenFloatingView.this.I.iterator();
            while (it.hasNext()) {
                it.next().onShowMin();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
                return;
            }
            super.onAnimationStart(animator);
            if (ud0.d.i()) {
                ud0.d.a("QUIBaseHalfScreenFloatingView", ud0.d.f438811e, "[showMinHeight] onAnimationStart.");
            }
            Iterator<p> it = QUIBaseHalfScreenFloatingView.this.I.iterator();
            while (it.hasNext()) {
                it.next().onShowMinStart();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public class i extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QUIBaseHalfScreenFloatingView.this);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
                return;
            }
            super.onAnimationEnd(animator);
            if (ud0.d.i()) {
                ud0.d.a("QUIBaseHalfScreenFloatingView", ud0.d.f438811e, "[dismissWithAnimation] onAnimationEnd.");
            }
            QUIBaseHalfScreenFloatingView qUIBaseHalfScreenFloatingView = QUIBaseHalfScreenFloatingView.this;
            qUIBaseHalfScreenFloatingView.f363660e0 = false;
            if (qUIBaseHalfScreenFloatingView.H != null && qUIBaseHalfScreenFloatingView.f363667i0 == 1) {
                QUIBaseHalfScreenFloatingView.this.H.onDismiss();
            }
            QUIBaseHalfScreenFloatingView.this.setVisibility(8);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
                return;
            }
            super.onAnimationStart(animator);
            if (ud0.d.i()) {
                ud0.d.a("QUIBaseHalfScreenFloatingView", ud0.d.f438811e, "[dismissWithAnimation] onAnimationStart.");
            }
            QUIBaseHalfScreenFloatingView qUIBaseHalfScreenFloatingView = QUIBaseHalfScreenFloatingView.this;
            qUIBaseHalfScreenFloatingView.f363660e0 = true;
            qUIBaseHalfScreenFloatingView.getClass();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public class j extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QUIBaseHalfScreenFloatingView.this);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, animator, Boolean.valueOf(z16));
                return;
            }
            QUIBaseHalfScreenFloatingView qUIBaseHalfScreenFloatingView = QUIBaseHalfScreenFloatingView.this;
            if (qUIBaseHalfScreenFloatingView.N != null) {
                Iterator<k> it = qUIBaseHalfScreenFloatingView.K.iterator();
                while (it.hasNext()) {
                    it.next().a(QUIBaseHalfScreenFloatingView.this.N.getY());
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface k {
        void a(float f16);
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface l {
        void onDismiss();
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface m {
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface n {
        void onFinishDrag();

        void onStartDrag();
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface o {
        void a();

        boolean onClick(View view);
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface p {
        void onShowDefault();

        void onShowDefaultStart();

        void onShowMin();

        void onShowMinStart();

        void onShowTotal();

        void onShowTotalStart();
    }

    public QUIBaseHalfScreenFloatingView(@NonNull Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void e(float f16, int i3, AnimatorListenerAdapter animatorListenerAdapter) {
        float y16 = this.N.getY();
        if (y16 < this.f363664h || Math.abs(y16 - f16) < 1.0E-6f) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.N, "y", y16, f16);
        if (i3 == 1) {
            ofFloat.setInterpolator(new OvershootInterpolator(1.0f));
        } else if (i3 == 0) {
            ofFloat.setInterpolator(new DecelerateInterpolator(0.5f));
        }
        ofFloat.addListener(animatorListenerAdapter);
        if (!this.K.isEmpty()) {
            ofFloat.addUpdateListener(this.L);
            ofFloat.addListener(new a());
        }
        ofFloat.setDuration(this.f363657d).start();
    }

    private void f() {
        int i3;
        if (this.f363669k0 == 1) {
            i3 = this.f363666i - this.f363668j0.defaultHeight();
        } else {
            i3 = this.f363664h;
        }
        this.N.setY(this.f363666i);
        if (ud0.d.i()) {
            ud0.d.a("QUIBaseHalfScreenFloatingView", ud0.d.f438811e, "[appearanceAnimationForResponsive] targetY=" + i3);
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.N, "y", this.f363666i, i3);
        ofFloat.setInterpolator(new DecelerateInterpolator(0.5f));
        ofFloat.addListener(new d());
        if (this.K.size() > 0) {
            ofFloat.addUpdateListener(this.L);
            ofFloat.addListener(new e());
        }
        ofFloat.setDuration(this.f363657d).start();
        if (ud0.d.i()) {
            ud0.d.a("QUIBaseHalfScreenFloatingView", ud0.d.f438811e, "[appearanceAnimationForResponsive] start. translationY=" + ofFloat.hashCode());
        }
        t(1.0f);
    }

    private void g() {
        int i3;
        int i16;
        int i17;
        float f16;
        int i18 = this.f363669k0;
        if (i18 == 2) {
            i17 = this.f363664h;
        } else {
            if (i18 == 1) {
                i3 = this.f363666i;
                i16 = this.f363668j0.defaultHeight();
            } else {
                i3 = this.f363666i;
                i16 = this.f363659e;
            }
            i17 = i3 - i16;
        }
        this.N.setY(i17);
        FrameLayout frameLayout = this.P;
        if (frameLayout != null) {
            if (this.f363669k0 == 0) {
                f16 = 0.0f;
            } else {
                f16 = 1.0f;
            }
            frameLayout.setAlpha(f16);
        }
        for (p pVar : this.I) {
            int i19 = this.f363669k0;
            if (i19 == 2) {
                pVar.onShowTotal();
            } else if (i19 == 1) {
                pVar.onShowDefault();
            } else {
                pVar.onShowMin();
            }
        }
    }

    private void p(MotionEvent motionEvent) {
        float rawY = motionEvent.getRawY();
        x(rawY);
        if (!this.f363654a0) {
            this.f363654a0 = true;
            Iterator<n> it = this.J.iterator();
            while (it.hasNext()) {
                it.next().onStartDrag();
            }
        }
        float f16 = rawY - this.f363670l0;
        float y16 = this.N.getY();
        float f17 = (f16 * this.D) + y16;
        if (f17 > this.f363664h && f17 < this.f363666i - this.f363659e) {
            this.N.setY(f17);
        }
        Iterator<k> it5 = this.K.iterator();
        while (it5.hasNext()) {
            it5.next().a(y16);
        }
        this.f363670l0 = rawY;
        y(true);
    }

    private void q() {
        if (this.f363654a0) {
            this.f363654a0 = false;
            Iterator<n> it = this.J.iterator();
            while (it.hasNext()) {
                it.next().onFinishDrag();
            }
        }
        float y16 = this.f363666i - this.N.getY();
        float k3 = k();
        if (y16 >= k3) {
            int i3 = this.f363669k0;
            if (i3 <= 1) {
                if (y16 > (this.f363661f + k3) / 2.0f) {
                    w(0);
                } else if (this.f363676q0 == 2) {
                    w(1);
                } else if (this.f363656c0) {
                    u(0);
                } else {
                    v(0);
                }
            } else if (i3 == 2) {
                if (y16 < (this.f363661f + k3) / 2.0f) {
                    if (this.f363656c0) {
                        u(0);
                    } else {
                        v(0);
                    }
                } else if (this.f363676q0 == 1) {
                    if (this.f363656c0) {
                        u(0);
                    } else {
                        v(0);
                    }
                } else {
                    w(0);
                }
            }
        } else {
            int i16 = this.f363669k0;
            if (i16 >= 1) {
                if (y16 <= (this.f363659e + k3) / 2.0f) {
                    v(0);
                } else if (this.f363676q0 == 1) {
                    v(1);
                } else {
                    u(0);
                }
            } else if (i16 == 0) {
                if (y16 >= (this.f363659e + k3) / 2.0f) {
                    u(0);
                } else if (this.f363676q0 == 2) {
                    u(1);
                } else {
                    v(0);
                }
            }
        }
        this.f363676q0 = (byte) 0;
        getParent().requestDisallowInterceptTouchEvent(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(View view) {
        o oVar = this.G;
        if (oVar != null && oVar.onClick(view)) {
            return;
        }
        if (this.f363667i0 == 0) {
            if (this.f363656c0 && this.f363669k0 == 2) {
                u(0);
                return;
            } else {
                v(0);
                return;
            }
        }
        if (this.f363656c0 && this.f363669k0 == 2) {
            u(0);
        } else {
            h();
        }
    }

    private void t(float f16) {
        FrameLayout frameLayout = this.P;
        if (frameLayout != null && f16 != frameLayout.getAlpha()) {
            if (!o().booleanValue()) {
                this.P.setAlpha(f16);
                return;
            }
            FrameLayout frameLayout2 = this.P;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(frameLayout2, com.tencent.luggage.wxa.c8.c.f123400v, frameLayout2.getAlpha(), f16);
            ofFloat.setDuration(this.f363657d);
            ofFloat.start();
        }
    }

    private void x(float f16) {
        float f17 = f16 - this.f363670l0;
        if (Math.abs(f17) > this.f363675p0 * 2) {
            if (f17 > 0.0f) {
                this.f363676q0 = (byte) 1;
            } else if (f17 < 0.0f) {
                this.f363676q0 = (byte) 2;
            }
        }
        byte b16 = this.f363676q0;
        if ((b16 == 1 && f17 <= 0.0f) || (b16 == 2 && f17 >= 0.0f)) {
            this.f363676q0 = (byte) 0;
        }
    }

    private void y(boolean z16) {
        ViewParent parent;
        if (this.f363663g0 && (parent = getParent()) != null) {
            parent.requestDisallowInterceptTouchEvent(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(@Nullable AttributeSet attributeSet, int i3, FrameLayout.LayoutParams layoutParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, attributeSet, Integer.valueOf(i3), layoutParams);
            return;
        }
        FrameLayout frameLayout = this.M;
        if (frameLayout == null) {
            return;
        }
        frameLayout.setLayoutParams(layoutParams);
        this.F = new QUIHalfScreenDefaultHeaderView(getContext(), attributeSet, i3);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, com.tencent.biz.qui.quicommon.e.c(14.0f));
        ((QUIHalfScreenDefaultHeaderView) this.F).setFloatingView(this);
        this.M.addView(this.F, layoutParams2);
        ViewGroup viewGroup = this.N;
        if (viewGroup != null) {
            viewGroup.addView(this.M);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return ((Boolean) iPatchRedirector.redirect((short) 40, (Object) this, (Object) motionEvent)).booleanValue();
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (!this.V) {
                        return super.dispatchTouchEvent(motionEvent);
                    }
                    if (this.f363665h0 && Math.abs(motionEvent.getRawX() - this.f363674o0) > Math.abs(motionEvent.getRawY() - this.f363673n0)) {
                        return super.dispatchTouchEvent(motionEvent);
                    }
                    if (!this.f363655b0 && Math.abs(motionEvent.getRawY() - this.f363672m0) <= this.f363675p0) {
                        z18 = false;
                    } else {
                        z18 = true;
                    }
                    this.f363655b0 = z18;
                    if (!z18) {
                        return super.dispatchTouchEvent(motionEvent);
                    }
                    if (this.R) {
                        p(motionEvent);
                        motionEvent.setAction(3);
                        super.dispatchTouchEvent(motionEvent);
                        return true;
                    }
                    if (!this.W) {
                        return super.dispatchTouchEvent(motionEvent);
                    }
                    float y16 = this.N.getY();
                    if (motionEvent.getRawY() < this.f363673n0) {
                        if (y16 > this.f363664h) {
                            this.T = true;
                        } else {
                            boolean z26 = !this.f363668j0.canScrollUp(motionEvent.getRawX(), motionEvent.getRawY());
                            this.T = z26;
                            if (!z26) {
                                this.f363670l0 = motionEvent.getRawY();
                            }
                        }
                    } else if (motionEvent.getRawY() > this.f363673n0) {
                        if (y16 > this.f363664h) {
                            this.T = true;
                        } else {
                            com.tencent.qui.quibottomfloatingview.b bVar = this.f363668j0;
                            if (bVar != null && !bVar.canScrollDown(motionEvent.getRawX(), motionEvent.getRawY())) {
                                z19 = true;
                            } else {
                                z19 = false;
                            }
                            this.T = z19;
                            if (!z19) {
                                this.f363670l0 = motionEvent.getRawY();
                            }
                        }
                    }
                    this.f363674o0 = motionEvent.getRawX();
                    this.f363673n0 = motionEvent.getRawY();
                    if (this.S && this.T) {
                        p(motionEvent);
                        motionEvent.setAction(3);
                        super.dispatchTouchEvent(motionEvent);
                        return true;
                    }
                }
            } else if (this.R || this.T) {
                q();
            }
        } else {
            this.f363655b0 = false;
            this.T = false;
            this.f363654a0 = false;
            this.f363670l0 = motionEvent.getRawY();
            this.f363672m0 = motionEvent.getRawY();
            this.f363673n0 = this.f363670l0;
            this.f363674o0 = motionEvent.getRawX();
            Rect rect = new Rect();
            FrameLayout frameLayout = this.M;
            if (frameLayout != null) {
                frameLayout.getGlobalVisibleRect(rect);
            }
            if (!rect.isEmpty() && rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.R = z16;
            this.N.getGlobalVisibleRect(rect);
            if (!rect.isEmpty() && rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                z17 = true;
            } else {
                z17 = false;
            }
            this.S = z17;
        }
        if (!this.S && !this.R && (this.f363669k0 == 0 || !this.U)) {
            return false;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (dispatchTouchEvent) {
            y(true);
        }
        return dispatchTouchEvent;
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this);
            return;
        }
        if (this.f363669k0 == 0) {
            return;
        }
        this.f363669k0 = 0;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.N, "y", this.N.getY(), this.f363666i - this.f363659e);
        ofFloat.setInterpolator(new DecelerateInterpolator(0.5f));
        ofFloat.addListener(new i());
        if (!this.K.isEmpty()) {
            ofFloat.addUpdateListener(this.L);
            ofFloat.addListener(new j());
        }
        ofFloat.setDuration(this.f363657d).start();
        t(0.0f);
    }

    protected int i(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            return ((Integer) iPatchRedirector.redirect((short) 51, (Object) this, i3)).intValue();
        }
        return (int) ((i3 * this.f363671m) + 0.5f);
    }

    public abstract View j(View view);

    public int k() {
        com.tencent.qui.quibottomfloatingview.b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Integer) iPatchRedirector.redirect((short) 35, (Object) this)).intValue();
        }
        if (this.f363656c0 && (bVar = this.f363668j0) != null) {
            return bVar.defaultHeight();
        }
        return this.f363659e;
    }

    protected abstract void l();

    protected abstract void m(@Nullable AttributeSet attributeSet, int i3);

    protected void n(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.tencent.qui.quibottomfloatingview.d.G);
        this.f363671m = getContext().getResources().getDisplayMetrics().density;
        l();
        this.V = true;
        this.f363659e = i(36);
        this.f363664h = i(88);
        this.f363675p0 = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        int integer = obtainStyledAttributes.getInteger(com.tencent.qui.quibottomfloatingview.d.H, 88);
        this.E = integer;
        this.f363664h = i(integer);
        if (obtainStyledAttributes.getBoolean(com.tencent.qui.quibottomfloatingview.d.I, true)) {
            this.P = new FrameLayout(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.P.setBackgroundColor(Color.parseColor("#80000000"));
            addView(this.P, layoutParams);
            this.P.setClickable(false);
            this.P.setAlpha(0.0f);
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams2.topMargin = i(this.E);
        layoutParams2.gravity = 81;
        this.N.setBackgroundResource(R.drawable.jj_);
        this.N.setElevation(this.f363671m * 4.0f);
        this.N.setLayoutParams(layoutParams2);
        addView(this.N);
        setForegroundGravity(81);
        m(attributeSet, i3);
        setOnClickListener(new c());
    }

    public Boolean o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (Boolean) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        return Boolean.valueOf(this.C);
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return ((Boolean) iPatchRedirector.redirect((short) 41, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (motionEvent.getActionMasked() == 8 && motionEvent.isFromSource(8194)) {
            if (ud0.d.i()) {
                ud0.d.a("QUIBaseHalfScreenFloatingView", ud0.d.f438811e, "onGenericMotionEvent ACTION_SCROLL.");
            }
            return true;
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Boolean) iPatchRedirector.redirect((short) 39, (Object) this, (Object) motionEvent)).booleanValue();
        }
        int action = motionEvent.getAction();
        boolean z17 = false;
        if (action == 1 ? !(!this.f363655b0 || !this.W) : !((action != 2 && action != 3) || !this.T || !this.V || !this.W)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 || this.f363660e0) {
            z17 = true;
        }
        y(z17);
        return z17;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        if (this.f363666i <= 0) {
            this.f363666i = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.N.getLayoutParams();
            int measuredWidth = getMeasuredWidth();
            int i19 = (int) (this.f363662f0 * this.f363671m);
            if (i19 <= 0 || measuredWidth <= i19) {
                i19 = -1;
            }
            int i26 = this.f363658d0 ? -2 : -1;
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(i19, i26);
            } else {
                layoutParams.width = i19;
                layoutParams.height = i26;
            }
            com.tencent.qui.quibottomfloatingview.b bVar = this.f363668j0;
            if (bVar != null && bVar.maxHeight() > 0) {
                this.f363664h = Math.max(i(this.E), this.f363666i - this.f363668j0.maxHeight());
            }
            com.tencent.qui.quibottomfloatingview.b bVar2 = this.f363668j0;
            if (bVar2 != null && bVar2.minMarginTop() > 0) {
                this.f363664h = Math.max(i(this.E), this.f363668j0.minMarginTop());
            }
            layoutParams.topMargin = this.f363664h;
            layoutParams.gravity = 81;
            this.N.setLayoutParams(layoutParams);
            this.f363661f = this.f363666i - this.f363664h;
            if (ud0.d.i()) {
                int i27 = ud0.d.f438811e;
                Object[] objArr = new Object[1];
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[onLayout] init mContainerHeight. mContainerHeight=");
                sb5.append(this.f363666i);
                sb5.append(", mMinimumMarginDp=");
                sb5.append(this.E);
                sb5.append(", mController maxHeight=");
                com.tencent.qui.quibottomfloatingview.b bVar3 = this.f363668j0;
                sb5.append(bVar3 != null ? Integer.valueOf(bVar3.maxHeight()) : "null");
                sb5.append(", mMinimumMarginTop=");
                sb5.append(this.f363664h);
                objArr[0] = sb5.toString();
                ud0.d.a("QUIBaseHalfScreenFloatingView", i27, objArr);
                return;
            }
            return;
        }
        if (this.f363658d0) {
            int measuredHeight = this.N.getMeasuredHeight();
            if (this.f363668j0.maxHeight() > 0 && measuredHeight > this.f363668j0.maxHeight()) {
                measuredHeight = this.f363668j0.maxHeight();
            }
            if (this.f363668j0.minMarginTop() > 0 && measuredHeight > this.f363668j0.minMarginTop()) {
                measuredHeight = this.f363666i - this.f363668j0.minMarginTop();
            }
            int max = Math.max(i(this.E), this.f363666i - measuredHeight);
            this.f363664h = max;
            this.f363661f = this.f363666i - max;
            if (ud0.d.i()) {
                int i28 = ud0.d.f438811e;
                Object[] objArr2 = new Object[1];
                StringBuilder sb6 = new StringBuilder();
                sb6.append("[onLayout] height wrap content adjust. contentHeight=");
                sb6.append(measuredHeight);
                sb6.append(", mMinimumMarginDp=");
                sb6.append(this.E);
                sb6.append(", mController=");
                com.tencent.qui.quibottomfloatingview.b bVar4 = this.f363668j0;
                sb6.append(bVar4 != null ? Integer.valueOf(bVar4.maxHeight()) : "null");
                sb6.append(", mMinimumMarginTop=");
                sb6.append(this.f363664h);
                objArr2[0] = sb6.toString();
                ud0.d.a("QUIBaseHalfScreenFloatingView", i28, objArr2);
            }
        }
        super.onLayout(z16, i3, i16, i17, i18);
        if (ud0.d.i()) {
            int i29 = ud0.d.f438811e;
            Object[] objArr3 = new Object[1];
            StringBuilder sb7 = new StringBuilder();
            sb7.append("[onLayout] mMinimumMarginDp=");
            sb7.append(this.E);
            sb7.append(", mController=");
            com.tencent.qui.quibottomfloatingview.b bVar5 = this.f363668j0;
            sb7.append(bVar5 != null ? Integer.valueOf(bVar5.maxHeight()) : "null");
            sb7.append(", mMinimumMarginTop=");
            sb7.append(this.f363664h);
            objArr3[0] = sb7.toString();
            ud0.d.a("QUIBaseHalfScreenFloatingView", i29, objArr3);
        }
        if (!this.Q) {
            this.Q = true;
            if (this.f363667i0 == 1) {
                f();
            } else {
                g();
            }
        }
        if (!ud0.d.i() || this.N.getLayoutParams() == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.N.getLayoutParams();
        ud0.d.a("QUIBaseHalfScreenFloatingView", ud0.d.f438811e, "[onLayout] topMargin=" + layoutParams2.topMargin);
    }

    public void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        this.f363666i = 0;
        this.f363659e = i(36);
        this.f363664h = i(this.E);
    }

    public void setAnimationDuration(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, i3);
        } else {
            this.f363657d = i3;
        }
    }

    public void setContentViewBackgroundResource(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        } else {
            float i16 = i(8);
            this.N.setBackground(ie0.a.f().l(getContext(), i3, new float[]{i16, i16, i16, i16, 0.0f, 0.0f, 0.0f, 0.0f}, 1000));
        }
    }

    public void setDraggable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, z16);
        } else {
            this.V = z16;
        }
    }

    public void setEnableParentDisallowInterruptTouchEvent(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, (Object) this, z16);
        } else {
            this.f363663g0 = z16;
        }
    }

    public void setHeaderView(View view) {
        View view2;
        FrameLayout frameLayout;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) view);
            return;
        }
        if (view != null && (view2 = this.F) != view && (frameLayout = this.M) != null) {
            frameLayout.removeView(view2);
            this.F = view;
            this.M.addView(view);
            this.M.setVisibility(0);
        }
    }

    public void setIgnoreHorizontalMove(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, z16);
        } else {
            this.f363665h0 = z16;
        }
    }

    public void setIsContentDraggable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, z16);
        } else {
            this.W = z16;
        }
    }

    public void setIsHeightWrapContent(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, z16);
        } else {
            this.f363658d0 = z16;
        }
    }

    public void setMaxWidthDp(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, i3);
        } else if (i3 != this.f363662f0) {
            this.f363662f0 = i3;
            s();
            invalidate();
        }
    }

    public void setMoveRatio(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, this, Float.valueOf(f16));
        } else {
            this.D = f16;
        }
    }

    public void setOnDismissListener(@Nullable l lVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) lVar);
        } else {
            this.H = lVar;
        }
    }

    public void setOnDismissStartListener(m mVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) mVar);
        }
    }

    public void setOnOutsideAreaClickListener(o oVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) oVar);
        } else {
            this.G = oVar;
        }
    }

    public void setOnOutsideClickListener(@Nullable o oVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) oVar);
        } else {
            this.G = oVar;
        }
    }

    public void setOutSideTouchEnable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
        } else {
            this.U = z16;
        }
    }

    public void setQUIDragFloatController(com.tencent.qui.quibottomfloatingview.b bVar) {
        int i3;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) bVar);
            return;
        }
        if (bVar == null) {
            return;
        }
        this.f363668j0 = bVar;
        View createContentView = bVar.createContentView();
        if (createContentView != null) {
            if (createContentView.getParent() != null) {
                ((ViewGroup) createContentView.getParent()).removeView(createContentView);
            }
            this.N.addView(j(createContentView));
        }
        this.f363667i0 = bVar.showMode();
        this.f363668j0.defaultHeight();
        int i16 = 0;
        if (this.f363667i0 == 0) {
            i3 = Math.max(this.f363659e, bVar.minHeight());
        } else {
            i3 = 0;
        }
        this.f363659e = i3;
        int i17 = 1;
        if (this.f363668j0.defaultHeight() > this.f363659e) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f363656c0 = z16;
        int initState = this.f363668j0.initState();
        if (initState != 0) {
            if (initState != 1) {
                if (initState != 2) {
                    this.f363669k0 = 2;
                    return;
                } else {
                    this.f363669k0 = 2;
                    return;
                }
            }
            if (!this.f363656c0) {
                i17 = 2;
            }
            this.f363669k0 = i17;
            return;
        }
        if (this.f363667i0 != 0) {
            i16 = 2;
        }
        this.f363669k0 = i16;
    }

    public void setThemeId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        } else {
            float i16 = i(8);
            this.N.setBackground(ie0.a.f().l(getContext(), R.color.qui_common_bg_middle_light, new float[]{i16, i16, i16, i16, 0.0f, 0.0f, 0.0f, 0.0f}, i3));
        }
    }

    public void u(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this, i3);
            return;
        }
        if (getVisibility() != 0) {
            setVisibility(0);
        }
        if (this.f363656c0) {
            this.f363669k0 = 1;
            e(this.f363666i - k(), i3, new g());
            t(1.0f);
        }
    }

    public void v(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this, i3);
        } else {
            if (this.f363667i0 == 1) {
                h();
                return;
            }
            this.f363669k0 = 0;
            e(this.f363666i - this.f363659e, i3, new h());
            t(0.0f);
        }
    }

    public void w(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this, i3);
            return;
        }
        if (getVisibility() != 0) {
            setVisibility(0);
        }
        this.f363669k0 = 2;
        e(this.f363664h, i3, new f());
        t(1.0f);
    }

    public QUIBaseHalfScreenFloatingView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public QUIBaseHalfScreenFloatingView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f363657d = 200;
        this.C = true;
        this.D = 1.0f;
        this.G = null;
        this.H = null;
        this.I = new ArrayList();
        this.J = new ArrayList();
        this.K = new ArrayList();
        this.L = new b();
        this.Q = false;
        this.R = false;
        this.S = false;
        this.T = false;
        this.U = true;
        this.W = true;
        this.f363654a0 = false;
        this.f363655b0 = false;
        this.f363656c0 = false;
        this.f363658d0 = false;
        this.f363660e0 = false;
        this.f363662f0 = 0;
        this.f363663g0 = false;
        this.f363665h0 = false;
        this.f363667i0 = 0;
        this.f363676q0 = (byte) 0;
        n(context, attributeSet, i3);
    }
}
