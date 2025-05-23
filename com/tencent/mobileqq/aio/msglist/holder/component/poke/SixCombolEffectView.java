package com.tencent.mobileqq.aio.msglist.holder.component.poke;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.aio.msg.PokeMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.tools.config.TVKConfigSystem;
import com.tencent.qqnt.aio.adapter.api.IAIOHapticApi;
import com.tencent.qqnt.aio.adapter.api.IAIOPokeApi;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes11.dex */
public class SixCombolEffectView extends View implements Handler.Callback {
    static IPatchRedirector $redirector_;

    /* renamed from: k0, reason: collision with root package name */
    public static boolean f191550k0;

    /* renamed from: l0, reason: collision with root package name */
    public static int f191551l0;
    private ValueAnimator C;
    private ValueAnimator D;
    float E;
    float F;
    float G;
    float H;
    private boolean I;
    private boolean J;
    private Handler K;
    private Matrix L;
    private ArrayList<q> M;
    private q N;
    private int P;
    private int Q;
    private long R;
    private boolean S;
    private String T;
    private int U;
    private int V;
    private int W;

    /* renamed from: a0, reason: collision with root package name */
    private PokeMsgItem f191552a0;

    /* renamed from: b0, reason: collision with root package name */
    private View f191553b0;

    /* renamed from: c0, reason: collision with root package name */
    private final int[] f191554c0;

    /* renamed from: d, reason: collision with root package name */
    Bitmap f191555d;

    /* renamed from: d0, reason: collision with root package name */
    float f191556d0;

    /* renamed from: e, reason: collision with root package name */
    Bitmap f191557e;

    /* renamed from: e0, reason: collision with root package name */
    float f191558e0;

    /* renamed from: f, reason: collision with root package name */
    Bitmap f191559f;

    /* renamed from: f0, reason: collision with root package name */
    private Context f191560f0;

    /* renamed from: g0, reason: collision with root package name */
    int f191561g0;

    /* renamed from: h, reason: collision with root package name */
    BitmapFactory.Options f191562h;

    /* renamed from: h0, reason: collision with root package name */
    int f191563h0;

    /* renamed from: i, reason: collision with root package name */
    private p f191564i;

    /* renamed from: i0, reason: collision with root package name */
    int f191565i0;

    /* renamed from: j0, reason: collision with root package name */
    int f191566j0;

    /* renamed from: m, reason: collision with root package name */
    private ValueAnimator f191567m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ q f191568d;

        a(q qVar) {
            this.f191568d = qVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SixCombolEffectView.this, (Object) qVar);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                return;
            }
            this.f191568d.f191596h = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            q qVar = this.f191568d;
            if (!qVar.f191603o && qVar.f191596h < 0.52f) {
                qVar.f191603o = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ q f191570d;

        b(q qVar) {
            this.f191570d = qVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SixCombolEffectView.this, (Object) qVar);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
            } else {
                this.f191570d.f191596h = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class c extends com.tencent.mobileqq.widget.f {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SixCombolEffectView.this);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animator);
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) animator);
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ q f191573d;

        d(q qVar) {
            this.f191573d = qVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SixCombolEffectView.this, (Object) qVar);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                return;
            }
            this.f191573d.f191597i = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            SixCombolEffectView.this.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class e implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ q f191575d;

        e(q qVar) {
            this.f191575d = qVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SixCombolEffectView.this, (Object) qVar);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                return;
            }
            this.f191575d.f191597i = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            SixCombolEffectView.this.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class f implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SixCombolEffectView.this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class g implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SixCombolEffectView.this);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                return;
            }
            SixCombolEffectView.this.E = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            SixCombolEffectView.this.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class h extends com.tencent.mobileqq.widget.f {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SixCombolEffectView.this);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animator);
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
            } else {
                if (!SixCombolEffectView.f191550k0) {
                    return;
                }
                SixCombolEffectView.this.D.start();
                SixCombolEffectView.this.q();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) animator);
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
                return;
            }
            if (SixCombolEffectView.this.J) {
                return;
            }
            SixCombolEffectView.f191551l0 = 1;
            if (QLog.isColorLevel()) {
                QLog.w("SixCombolEffectView", 2, "Animation 1 ,mAnimationState = " + SixCombolEffectView.f191551l0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class i implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SixCombolEffectView.this);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                return;
            }
            SixCombolEffectView.this.F = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            SixCombolEffectView.this.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class j extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SixCombolEffectView.this);
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
            if (!SixCombolEffectView.f191550k0) {
                return;
            }
            SixCombolEffectView.this.C.start();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
                return;
            }
            super.onAnimationStart(animator);
            if (SixCombolEffectView.this.J) {
                return;
            }
            SixCombolEffectView.f191551l0 = 2;
            if (QLog.isColorLevel()) {
                QLog.w("SixCombolEffectView", 2, "Animation 2 ,mAnimationState = " + SixCombolEffectView.f191551l0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class k implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SixCombolEffectView.this);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                return;
            }
            SixCombolEffectView.this.E = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            SixCombolEffectView.this.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class l extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SixCombolEffectView.this);
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
            if (!SixCombolEffectView.f191550k0) {
                return;
            }
            SixCombolEffectView.f191551l0 = 4;
            if (QLog.isColorLevel()) {
                QLog.w("SixCombolEffectView", 2, "Animation 4 ,mAnimationState = " + SixCombolEffectView.f191551l0);
            }
            if (SixCombolEffectView.this.f191564i != null) {
                SixCombolEffectView.this.f191564i.end();
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
            if (SixCombolEffectView.this.J) {
                return;
            }
            SixCombolEffectView.f191551l0 = 3;
            if (QLog.isColorLevel()) {
                QLog.w("SixCombolEffectView", 2, "Animation 3 ,mAnimationState = " + SixCombolEffectView.f191551l0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class m extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SixCombolEffectView.this);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
                return;
            }
            super.onAnimationEnd(animator);
            if (!SixCombolEffectView.f191550k0) {
                return;
            }
            SixCombolEffectView.this.n();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class n extends com.tencent.mobileqq.widget.f {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ q f191585d;

        n(q qVar) {
            this.f191585d = qVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SixCombolEffectView.this, (Object) qVar);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animator);
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
            } else {
                if (!SixCombolEffectView.f191550k0) {
                    return;
                }
                this.f191585d.f191600l.start();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) animator);
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class o implements TypeEvaluator<PointF> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private PointF[] f191587a;

        public o() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SixCombolEffectView.this);
            }
        }

        @Override // android.animation.TypeEvaluator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF evaluate(float f16, PointF pointF, PointF pointF2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (PointF) iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16), pointF, pointF2);
            }
            PointF[] pointFArr = this.f191587a;
            PointF pointF3 = pointFArr[0];
            PointF pointF4 = pointFArr[1];
            PointF pointF5 = pointFArr[2];
            if (f16 <= 1.0f) {
                double d16 = 1.0f - f16;
                double pow = (pointF3.x * Math.pow(d16, 2.0d)) + (pointF4.x * 2.0f * f16 * r3);
                double d17 = pointF5.x;
                double d18 = f16;
                return new PointF((float) (pow + (d17 * Math.pow(d18, 2.0d))), (float) ((pointF3.y * Math.pow(d16, 2.0d)) + (pointF4.y * 2.0f * f16 * r3) + (pointF5.y * Math.pow(d18, 2.0d))));
            }
            return pointF5;
        }

        public void b(PointF... pointFArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) pointFArr);
            } else {
                if (pointFArr.length == 3) {
                    this.f191587a = pointFArr;
                    return;
                }
                throw new IllegalArgumentException("Only show cubic Bezier curves");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface p {
        void end();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class q {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f191589a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f191590b;

        /* renamed from: c, reason: collision with root package name */
        public int f191591c;

        /* renamed from: d, reason: collision with root package name */
        public int f191592d;

        /* renamed from: e, reason: collision with root package name */
        public int f191593e;

        /* renamed from: f, reason: collision with root package name */
        public int f191594f;

        /* renamed from: g, reason: collision with root package name */
        public int f191595g;

        /* renamed from: h, reason: collision with root package name */
        public float f191596h;

        /* renamed from: i, reason: collision with root package name */
        public float f191597i;

        /* renamed from: j, reason: collision with root package name */
        public int f191598j;

        /* renamed from: k, reason: collision with root package name */
        public ValueAnimator f191599k;

        /* renamed from: l, reason: collision with root package name */
        public ValueAnimator f191600l;

        /* renamed from: m, reason: collision with root package name */
        public ValueAnimator f191601m;

        /* renamed from: n, reason: collision with root package name */
        public ValueAnimator f191602n;

        /* renamed from: o, reason: collision with root package name */
        public boolean f191603o;

        /* renamed from: p, reason: collision with root package name */
        public o f191604p;

        q() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SixCombolEffectView.this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60952);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            f191550k0 = false;
            f191551l0 = 0;
        }
    }

    public SixCombolEffectView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f191562h = new BitmapFactory.Options();
        this.G = ScreenUtil.dip2px(120.0f);
        this.H = ScreenUtil.dip2px(120.0f);
        this.J = false;
        this.L = null;
        this.P = 0;
        this.Q = 0;
        this.R = 0L;
        this.S = false;
        this.T = "chat_item_for_qq666";
        this.W = ScreenUtil.dip2px(60.0f);
        this.f191554c0 = new int[2];
        this.f191558e0 = ScreenUtil.dip2px(100.0f);
        this.f191561g0 = ScreenUtil.dip2px(30.0f);
        this.f191563h0 = ScreenUtil.dip2px(30.0f);
        this.f191565i0 = ScreenUtil.dip2px(13.0f);
        this.f191566j0 = ScreenUtil.dip2px(50.0f);
        l(context);
    }

    private void e() {
        this.J = true;
        this.K.removeMessages(2);
        this.D.end();
        this.f191567m.end();
        this.C.end();
        this.J = false;
        Iterator<q> it = this.M.iterator();
        while (it.hasNext()) {
            q next = it.next();
            next.f191602n.end();
            next.f191599k.end();
            next.f191601m.end();
            next.f191600l.end();
            next.f191596h = 0.0f;
            next.f191597i = 0.0f;
            next.f191590b = false;
        }
        if (this.S) {
            ((IAIOHapticApi) com.tencent.qqnt.aio.adapter.a.b(IAIOHapticApi.class)).stopEffect(this.U);
        }
        this.U = 0;
    }

    private void h(Canvas canvas, Paint paint, Bitmap bitmap, float f16, float f17, float f18) {
        canvas.save();
        Matrix matrix = new Matrix();
        float height = this.H / bitmap.getHeight();
        matrix.postScale(height, height);
        matrix.postTranslate((-this.G) / 2.0f, (-this.H) / 2.0f);
        matrix.postRotate(f16);
        matrix.postTranslate(f17, f18);
        canvas.drawBitmap(bitmap, matrix, paint);
        canvas.restore();
    }

    private void i(Canvas canvas, Paint paint, Bitmap bitmap, float f16, float f17) {
        canvas.save();
        Matrix matrix = new Matrix();
        float height = this.H / bitmap.getHeight();
        matrix.postScale(height, height);
        matrix.postTranslate(f16, f17);
        canvas.drawBitmap(bitmap, matrix, paint);
        canvas.restore();
    }

    @TargetApi(11)
    private q k(int i3, int i16, int i17, int i18, int i19, int i26) {
        q qVar = new q();
        qVar.f191589a = i3;
        qVar.f191590b = false;
        qVar.f191591c = i16;
        qVar.f191593e = i17;
        qVar.f191595g = i18;
        qVar.f191598j = i19;
        qVar.f191603o = false;
        qVar.f191604p = new o();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.2f, this.f191556d0 - 0.15f);
        qVar.f191599k = ofFloat;
        ofFloat.setDuration((int) (i19 * 1.2d));
        qVar.f191599k.addListener(new n(qVar));
        qVar.f191599k.addUpdateListener(new a(qVar));
        float f16 = this.f191556d0;
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(f16 - 0.15f, f16);
        qVar.f191600l = ofFloat2;
        ofFloat2.setDuration(i26);
        qVar.f191600l.addUpdateListener(new b(qVar));
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(0.0f, 2.5f);
        qVar.f191601m = ofFloat3;
        int i27 = i26 - i19;
        ofFloat3.setDuration((long) (i27 * 2.1d));
        qVar.f191601m.setInterpolator(new DecelerateInterpolator());
        qVar.f191601m.addListener(new c());
        qVar.f191601m.addUpdateListener(new d(qVar));
        ValueAnimator ofFloat4 = ValueAnimator.ofFloat(1.0f, 2.2f);
        qVar.f191602n = ofFloat4;
        ofFloat4.setDuration(i27);
        qVar.f191602n.setInterpolator(new LinearInterpolator());
        qVar.f191602n.addUpdateListener(new e(qVar));
        return qVar;
    }

    private void l(Context context) {
        this.f191560f0 = context;
        setOnTouchListener(new f());
        BitmapFactory.Options options = this.f191562h;
        options.inSampleSize = 1;
        options.inMutable = true;
        if (((IAIOPokeApi) com.tencent.qqnt.aio.adapter.a.b(IAIOPokeApi.class)).isBigResReady()) {
            try {
                this.f191555d = BaseImageUtil.decodeFileWithBufferedStream(af.I3 + "/666_caidan/666send_caidan_hand.png", this.f191562h);
            } catch (OutOfMemoryError e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("Six Hand", 2, e16.toString());
                }
                this.f191555d = null;
            }
            try {
                this.f191559f = BaseImageUtil.decodeFileWithBufferedStream(af.I3 + "/666_caidan/666send_caidan_hand6.png", this.f191562h);
            } catch (OutOfMemoryError e17) {
                if (QLog.isColorLevel()) {
                    QLog.d("Six Six", 2, e17.toString());
                }
                this.f191559f = null;
            }
            this.f191557e = f(this.f191555d);
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(-0.2f, 1.0f);
        this.f191567m = ofFloat;
        ofFloat.setDuration(300L);
        this.f191567m.addUpdateListener(new g());
        this.f191567m.addListener(new h());
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f, 0.0f).setDuration(300L);
        this.D = duration;
        duration.setInterpolator(new DecelerateInterpolator());
        this.D.setRepeatCount(7);
        this.D.addUpdateListener(new i());
        this.D.addListener(new j());
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, -0.2f);
        this.C = ofFloat2;
        ofFloat2.setDuration(300L);
        this.C.addUpdateListener(new k());
        this.C.addListener(new l());
        m(getContext());
    }

    private void o(q qVar, int i3, int i16, int i17) {
        qVar.f191592d = i3;
        qVar.f191594f = i16;
        qVar.f191603o = false;
        float f16 = i16;
        qVar.f191604p.b(new PointF(i3, qVar.f191593e), new PointF(f16, qVar.f191593e - i17), new PointF(f16, qVar.f191595g));
    }

    public Bitmap f(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Bitmap) iPatchRedirector.redirect((short) 9, (Object) this, (Object) bitmap);
        }
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(-1.0f, 1.0f);
        try {
            return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        } catch (OutOfMemoryError e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            this.f191560f0 = null;
            n();
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    setVisibility(0);
                    requestLayout();
                    f191551l0 = 0;
                    this.f191567m.start();
                }
            } else {
                this.K.removeMessages(2);
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.R;
                for (int i16 = 0; i16 < this.M.size(); i16++) {
                    q qVar = this.M.get(i16);
                    if (currentAnimationTimeMillis >= qVar.f191591c && !qVar.f191590b) {
                        qVar.f191590b = true;
                        qVar.f191599k.start();
                        qVar.f191601m.start();
                    }
                }
                if (!this.N.f191590b) {
                    Message obtainMessage = this.K.obtainMessage();
                    obtainMessage.what = 2;
                    this.K.sendMessageDelayed(obtainMessage, 25L);
                }
            }
        } else {
            this.R = AnimationUtils.currentAnimationTimeMillis();
            Iterator<q> it = this.M.iterator();
            while (it.hasNext()) {
                it.next().f191590b = false;
            }
            this.K.sendEmptyMessage(2);
        }
        return false;
    }

    public PokeMsgItem j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (PokeMsgItem) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f191552a0;
    }

    void m(Context context) {
        this.K = new Handler(Looper.getMainLooper(), this);
        this.L = new Matrix();
        int screenWidth = ViewUtils.getScreenWidth();
        int i3 = getResources().getDisplayMetrics().heightPixels;
        this.P = screenWidth;
        this.Q = i3;
        this.f191556d0 = this.f191558e0 / this.f191559f.getWidth();
        ArrayList<q> arrayList = new ArrayList<>();
        this.M = arrayList;
        int i16 = (int) (i3 * 0.6f);
        arrayList.add(k(0, 800, i3 - ScreenUtil.dip2px(70.0f), i16, 700, 2000));
        this.M.add(k(0, 1600, i3 - ScreenUtil.dip2px(70.0f), i16, 600, 1400));
        this.M.add(k(0, TVKConfigSystem.REQUEST_ONLINE_CONFIG_MIN_INTERVAL_SEC, i3 - ScreenUtil.dip2px(70.0f), i16, 600, TVKConfigSystem.REQUEST_ONLINE_CONFIG_MIN_INTERVAL_SEC));
        this.M.add(k(1, 0, i3 - ScreenUtil.dip2px(70.0f), i16, 500, 1500));
        this.M.add(k(1, 600, i3 - ScreenUtil.dip2px(70.0f), i16, 500, 1400));
        this.M.add(k(1, 1200, i3 - ScreenUtil.dip2px(70.0f), i16, 500, 1500));
        this.M.add(k(1, 2000, i3 - ScreenUtil.dip2px(70.0f), i16, 500, TVKConfigSystem.REQUEST_ONLINE_CONFIG_MIN_INTERVAL_SEC));
        this.M.add(k(2, 300, i3 - ScreenUtil.dip2px(70.0f), i16, 500, 1500));
        this.M.add(k(2, 1000, i3 - ScreenUtil.dip2px(70.0f), i16, 500, 1500));
        this.M.add(k(2, 1400, i3 - ScreenUtil.dip2px(70.0f), i16, 500, 1900));
        q qVar = this.M.get(6);
        this.N = qVar;
        qVar.f191601m.addListener(new m());
    }

    public void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        setVisibility(8);
        p pVar = this.f191564i;
        if (pVar != null) {
            pVar.end();
            this.f191564i = null;
        }
        PokeMsgItem pokeMsgItem = this.f191552a0;
        if (pokeMsgItem != null) {
            pokeMsgItem.frameState.f191488d = false;
        }
        f191550k0 = false;
        f191551l0 = 0;
        e();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        this.f191553b0.getLocationOnScreen(this.f191554c0);
        this.V = (int) ((this.f191554c0[1] + this.H) - this.f191566j0);
        if (this.f191559f != null && this.f191555d != null) {
            Iterator<q> it = this.M.iterator();
            while (it.hasNext()) {
                q next = it.next();
                if (next.f191590b) {
                    this.L.reset();
                    float f16 = next.f191597i;
                    if (f16 <= 1.0f) {
                        PointF evaluate = next.f191604p.evaluate(f16, null, null);
                        this.L.postTranslate(evaluate.x, (evaluate.y - (this.Q - this.V)) + this.f191565i0);
                    } else {
                        int i16 = (int) (this.Q * 0.6d * (1.0f - (f16 - 1.0f)));
                        this.L.postTranslate(next.f191604p.evaluate(f16, null, null).x, (i16 - (this.Q - this.V)) + this.f191565i0);
                    }
                    Matrix matrix = this.L;
                    float f17 = next.f191596h;
                    matrix.preScale(f17, f17);
                    canvas.drawBitmap(this.f191559f, this.L, null);
                }
            }
            q qVar = this.N;
            if (qVar.f191590b) {
                float f18 = qVar.f191597i;
                if (f18 <= 1.0f) {
                    i3 = (int) ((qVar.f191604p.evaluate(f18, null, null).y - (this.Q - this.V)) + this.f191565i0);
                } else {
                    int i17 = this.Q;
                    i3 = this.f191565i0 + (((int) ((i17 * 0.6d) * (1.0f - (f18 - 1.0f)))) - (i17 - this.V));
                }
                if (i3 + (this.f191559f.getHeight() * this.N.f191596h) < 0.0f) {
                    n();
                }
            }
            int i18 = f191551l0;
            if (i18 != 1) {
                if (i18 != 2) {
                    if (i18 == 3) {
                        if (this.I) {
                            Bitmap bitmap = this.f191555d;
                            float f19 = 90.0f - (this.E * 90.0f);
                            float width = (getWidth() - (this.G / 2.0f)) - this.W;
                            int i19 = this.f191565i0;
                            h(canvas, null, bitmap, f19, width - i19, (this.V - (this.H / 2.0f)) + i19);
                            return;
                        }
                        Bitmap bitmap2 = this.f191557e;
                        float f26 = (this.E * 90.0f) - 90.0f;
                        float f27 = (this.G / 2.0f) + this.W;
                        int i26 = this.f191565i0;
                        h(canvas, null, bitmap2, f26, i26 + f27, (this.V - (this.H / 2.0f)) + i26);
                        return;
                    }
                    return;
                }
                if (this.I) {
                    i(canvas, null, this.f191555d, ((getWidth() - this.G) + ((this.F - 0.5f) * 100.0f)) - this.W, this.V - this.H);
                    return;
                } else {
                    i(canvas, null, this.f191557e, ((-(this.F - 0.5f)) * 100.0f) + this.W, this.V - this.H);
                    return;
                }
            }
            if (this.I) {
                h(canvas, null, this.f191555d, 90.0f - (this.E * 90.0f), (getWidth() - (this.G / 2.0f)) - this.W, this.V - (this.H / 2.0f));
            } else {
                h(canvas, null, this.f191557e, (this.E * 90.0f) - 90.0f, (this.G / 2.0f) + this.W, this.V - (this.H / 2.0f));
            }
        }
    }

    public void p(PokeMsgItem pokeMsgItem, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) pokeMsgItem, (Object) view);
            return;
        }
        if (f191550k0) {
            return;
        }
        this.S = ae.f191631a.w();
        e();
        this.f191552a0 = pokeMsgItem;
        this.f191553b0 = view;
        pokeMsgItem.frameState.f191488d = true;
        this.I = pokeMsgItem.isSelf();
        f191550k0 = true;
        this.K.sendEmptyMessage(3);
        if (this.S) {
            this.U = ((IAIOHapticApi) com.tencent.qqnt.aio.adapter.a.b(IAIOHapticApi.class)).playEffect(this.T, 2);
        }
    }

    public void q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (this.I) {
            int dip2px = (int) ((this.P - ScreenUtil.dip2px(50.0f)) - (this.G / 2.0f));
            Iterator<q> it = this.M.iterator();
            while (it.hasNext()) {
                q next = it.next();
                int i3 = next.f191589a;
                if (i3 == 0) {
                    o(next, dip2px, (dip2px / 3) * 2, 0);
                } else if (i3 == 1) {
                    o(next, dip2px, dip2px / 3, 0);
                } else {
                    o(next, dip2px, ScreenUtil.dip2px(10.0f), 50);
                }
            }
        } else {
            Iterator<q> it5 = this.M.iterator();
            while (it5.hasNext()) {
                q next2 = it5.next();
                int dip2px2 = (int) (ScreenUtil.dip2px(50.0f) + (this.G / 2.0f));
                int dip2px3 = (int) ((this.P - ScreenUtil.dip2px(50.0f)) - (this.G / 2.0f));
                int i16 = next2.f191589a;
                if (i16 == 0) {
                    o(next2, dip2px2, dip2px2, 0);
                } else if (i16 == 1) {
                    o(next2, dip2px2, (dip2px3 / 3) + dip2px2, 0);
                } else {
                    o(next2, dip2px2, (int) ((this.P - this.f191558e0) - ScreenUtil.dip2px(10.0f)), 50);
                }
            }
        }
        this.K.sendEmptyMessage(1);
    }

    public void setListener(p pVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) pVar);
        } else {
            this.f191564i = pVar;
        }
    }

    public SixCombolEffectView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f191562h = new BitmapFactory.Options();
        this.G = ScreenUtil.dip2px(120.0f);
        this.H = ScreenUtil.dip2px(120.0f);
        this.J = false;
        this.L = null;
        this.P = 0;
        this.Q = 0;
        this.R = 0L;
        this.S = false;
        this.T = "chat_item_for_qq666";
        this.W = ScreenUtil.dip2px(60.0f);
        this.f191554c0 = new int[2];
        this.f191558e0 = ScreenUtil.dip2px(100.0f);
        this.f191561g0 = ScreenUtil.dip2px(30.0f);
        this.f191563h0 = ScreenUtil.dip2px(30.0f);
        this.f191565i0 = ScreenUtil.dip2px(13.0f);
        this.f191566j0 = ScreenUtil.dip2px(50.0f);
        l(context);
    }

    public SixCombolEffectView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f191562h = new BitmapFactory.Options();
        this.G = ScreenUtil.dip2px(120.0f);
        this.H = ScreenUtil.dip2px(120.0f);
        this.J = false;
        this.L = null;
        this.P = 0;
        this.Q = 0;
        this.R = 0L;
        this.S = false;
        this.T = "chat_item_for_qq666";
        this.W = ScreenUtil.dip2px(60.0f);
        this.f191554c0 = new int[2];
        this.f191558e0 = ScreenUtil.dip2px(100.0f);
        this.f191561g0 = ScreenUtil.dip2px(30.0f);
        this.f191563h0 = ScreenUtil.dip2px(30.0f);
        this.f191565i0 = ScreenUtil.dip2px(13.0f);
        this.f191566j0 = ScreenUtil.dip2px(50.0f);
        l(context);
    }
}
