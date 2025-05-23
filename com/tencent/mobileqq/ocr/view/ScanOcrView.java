package com.tencent.mobileqq.ocr.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import com.qzone.proxy.feedcomponent.model.CellDynamicAlbum;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ScanOcrView extends View {
    static IPatchRedirector $redirector_;
    int C;
    int D;
    int E;
    int F;
    int G;
    int H;
    int I;
    int J;
    int K;
    int L;
    int M;
    int N;
    int P;
    Context Q;
    int R;
    Handler S;
    Drawable T;
    boolean U;
    boolean V;
    g W;

    /* renamed from: a0, reason: collision with root package name */
    g f254885a0;

    /* renamed from: b0, reason: collision with root package name */
    g f254886b0;

    /* renamed from: c0, reason: collision with root package name */
    AnimatorSet f254887c0;

    /* renamed from: d, reason: collision with root package name */
    Drawable f254888d;

    /* renamed from: d0, reason: collision with root package name */
    AnimatorSet f254889d0;

    /* renamed from: e, reason: collision with root package name */
    Drawable f254890e;

    /* renamed from: f, reason: collision with root package name */
    Paint f254891f;

    /* renamed from: h, reason: collision with root package name */
    public boolean f254892h;

    /* renamed from: i, reason: collision with root package name */
    long f254893i;

    /* renamed from: m, reason: collision with root package name */
    int f254894m;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a extends Handler {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ScanOcrView.this);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("ScanOcrView", 2, "handleMessage, MSG_SCANLINE");
            }
            if (message.what == 0) {
                ScanOcrView.this.j(message.arg1);
            }
            super.handleMessage(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ScanOcrView.this);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                return;
            }
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            g gVar = ScanOcrView.this.W;
            int i3 = gVar.f254906c;
            int i16 = gVar.f254907d;
            int i17 = ((int) (i3 * floatValue)) - i3;
            int i18 = ((int) (i16 * floatValue)) - i16;
            int animatedFraction = (int) (valueAnimator.getAnimatedFraction() * 255.0f);
            if (animatedFraction > 255) {
                animatedFraction = 255;
            }
            if (animatedFraction < 0) {
                animatedFraction = 0;
            }
            g gVar2 = ScanOcrView.this.W;
            Rect rect = gVar2.f254905b;
            int i19 = i17 / 2;
            int i26 = rect.left - i19;
            int i27 = i18 / 2;
            int i28 = rect.top - i27;
            int i29 = rect.right + i19;
            int i36 = rect.bottom + i27;
            gVar2.f254911h = animatedFraction;
            gVar2.f254910g.set(i26, i28, i29, i36);
            ScanOcrView.this.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ScanOcrView.this);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                return;
            }
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            ScanOcrView scanOcrView = ScanOcrView.this;
            scanOcrView.W.f254911h = intValue;
            scanOcrView.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class d extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f254898d;

        d(int i3) {
            this.f254898d = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ScanOcrView.this, i3);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
                return;
            }
            ScanOcrView scanOcrView = ScanOcrView.this;
            if (scanOcrView.U) {
                scanOcrView.h(this.f254898d + 1);
            }
            if (this.f254898d == 2) {
                ScanOcrView.this.n();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class e implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ g f254900d;

        e(g gVar) {
            this.f254900d = gVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ScanOcrView.this, (Object) gVar);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                return;
            }
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            g gVar = this.f254900d;
            int i3 = gVar.f254906c;
            int i16 = gVar.f254907d;
            int i17 = ((int) (i3 * floatValue)) - i3;
            int i18 = ((int) (i16 * floatValue)) - i16;
            int animatedFraction = (int) (valueAnimator.getAnimatedFraction() * 255.0f);
            if (animatedFraction > 255) {
                animatedFraction = 255;
            }
            if (animatedFraction < 0) {
                animatedFraction = 0;
            }
            g gVar2 = this.f254900d;
            Rect rect = gVar2.f254905b;
            int i19 = i17 / 2;
            int i26 = rect.left - i19;
            int i27 = i18 / 2;
            int i28 = rect.top - i27;
            int i29 = rect.right + i19;
            int i36 = rect.bottom + i27;
            gVar2.f254911h = animatedFraction;
            gVar2.f254910g.set(i26, i28, i29, i36);
            ScanOcrView.this.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class f implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ g f254902d;

        f(g gVar) {
            this.f254902d = gVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ScanOcrView.this, (Object) gVar);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
            } else {
                this.f254902d.f254911h = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ScanOcrView.this.invalidate();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class g {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        Rect f254904a;

        /* renamed from: b, reason: collision with root package name */
        Rect f254905b;

        /* renamed from: c, reason: collision with root package name */
        int f254906c;

        /* renamed from: d, reason: collision with root package name */
        int f254907d;

        /* renamed from: e, reason: collision with root package name */
        int f254908e;

        /* renamed from: f, reason: collision with root package name */
        int f254909f;

        /* renamed from: g, reason: collision with root package name */
        Rect f254910g;

        /* renamed from: h, reason: collision with root package name */
        int f254911h;

        /* renamed from: i, reason: collision with root package name */
        int f254912i;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f254904a = new Rect();
            this.f254905b = new Rect();
            this.f254910g = new Rect();
        }

        public String toString() {
            String str;
            String str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("currAlpha = ");
            sb5.append(this.f254911h);
            sb5.append("\n");
            sb5.append("currRect = ");
            Rect rect = this.f254910g;
            String str3 = "";
            if (rect == null) {
                str = "";
            } else {
                str = rect.toShortString();
            }
            sb5.append(str);
            sb5.append("\n");
            sb5.append("radomAreaIndex = ");
            sb5.append(this.f254912i);
            sb5.append("\n");
            sb5.append("radomRect = ");
            Rect rect2 = this.f254904a;
            if (rect2 == null) {
                str2 = "";
            } else {
                str2 = rect2.toShortString();
            }
            sb5.append(str2);
            sb5.append("\n");
            sb5.append("gapDuration = ");
            sb5.append(this.f254908e);
            sb5.append("\n");
            sb5.append("startRect = ");
            Rect rect3 = this.f254905b;
            if (rect3 != null) {
                str3 = rect3.toShortString();
            }
            sb5.append(str3);
            sb5.append("\n");
            sb5.append("edageWidth = ");
            sb5.append(this.f254906c);
            sb5.append("\n");
            return sb5.toString();
        }
    }

    public ScanOcrView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f254892h = false;
        this.R = 1;
        this.S = new a();
        this.U = false;
        this.V = false;
        this.Q = context;
        e();
    }

    public static final int b(float f16, Resources resources) {
        if (f16 == 0.0f) {
            return 0;
        }
        return (int) ((f16 * resources.getDisplayMetrics().density) + 0.5f);
    }

    private g c(int i3, g gVar) {
        int nextInt;
        int i16;
        int b16 = b(200.0f, getResources());
        int b17 = b(100.0f, getResources());
        Random random = new Random();
        int nextInt2 = (random.nextInt(b16) % ((b16 - b17) + 1)) + b17;
        int i17 = this.I;
        int i18 = this.K;
        float f16 = i17;
        int i19 = (int) ((f16 * 0.3f) + this.N + 0.5f);
        float f17 = i18;
        int i26 = (int) ((0.3f * f17) + this.L + 0.5f);
        int i27 = (int) (i19 + (f16 * 0.39999998f) + 0.5f);
        int i28 = (int) (i26 + (f17 * 0.39999998f) + 0.5f);
        ArrayList arrayList = new ArrayList();
        for (int i29 = 0; i29 < 2; i29++) {
            arrayList.add(Integer.valueOf(i29));
        }
        if (i3 != 0 && gVar != null) {
            arrayList.remove(Integer.valueOf(gVar.f254912i));
            if (arrayList.size() > 0) {
                nextInt = random.nextInt(arrayList.size());
            } else {
                nextInt = 0;
            }
        } else {
            nextInt = random.nextInt(2);
        }
        if (nextInt < arrayList.size()) {
            i16 = ((Integer) arrayList.get(nextInt)).intValue();
        } else {
            i16 = 0;
        }
        if (i16 >= 2) {
            i16 = 1;
        }
        int i36 = (i28 - i26) / 2;
        int i37 = i26 + (i36 * i16);
        int i38 = i36 + i37;
        Rect rect = new Rect(i19, i37, i27, i38);
        int nextInt3 = (random.nextInt(i27) % ((i27 - i19) + 1)) + i19;
        int nextInt4 = (random.nextInt(i38) % ((i38 - i37) + 1)) + i37;
        Rect rect2 = new Rect();
        int i39 = nextInt2 / 2;
        int i46 = nextInt3 - i39;
        rect2.left = i46;
        int i47 = nextInt4 - i39;
        rect2.top = i47;
        rect2.right = i46 + nextInt2;
        rect2.bottom = i47 + nextInt2;
        g gVar2 = new g();
        gVar2.f254908e = 500;
        gVar2.f254909f = 700;
        gVar2.f254906c = nextInt2;
        gVar2.f254907d = nextInt2;
        gVar2.f254905b = rect2;
        gVar2.f254910g = new Rect(rect2);
        gVar2.f254911h = 0;
        gVar2.f254904a = rect;
        gVar2.f254912i = i16;
        if (QLog.isColorLevel()) {
            QLog.i("ScanOcrView", 2, "generateScanRectAniParam, hasDoneCnt=" + i3 + "," + i17 + "*" + i18 + "\n" + gVar2);
        }
        return gVar2;
    }

    private g d() {
        int b16 = b(200.0f, getResources());
        int b17 = b(200.0f, getResources());
        int i3 = this.I;
        int i16 = this.K / 2;
        Rect rect = new Rect();
        int i17 = (i3 / 2) - (b16 / 2);
        rect.left = i17;
        int i18 = i16 - (b17 / 2);
        rect.top = i18;
        rect.right = i17 + b16;
        rect.bottom = i18 + b17;
        g gVar = new g();
        gVar.f254905b = rect;
        gVar.f254906c = b16;
        gVar.f254907d = b17;
        gVar.f254910g = new Rect(rect);
        gVar.f254911h = 0;
        if (QLog.isColorLevel()) {
            QLog.i("ScanOcrView", 2, "generateScanRectHoldAniParam, \n" + gVar);
        }
        return gVar;
    }

    private void e() {
        this.f254888d = getResources().getDrawable(R.drawable.f161806f10);
        this.f254890e = getResources().getDrawable(R.drawable.f0z);
        this.T = getResources().getDrawable(R.drawable.f161807f11);
        Paint paint = new Paint(1);
        this.f254891f = paint;
        paint.setColor(CellDynamicAlbum.sBtnBackgroundColor);
        this.D = b(10.0f, this.Q.getResources());
        this.F = b(5.0f, this.Q.getResources());
        this.G = b(212.0f, this.Q.getResources());
        this.G = b(212.0f, this.Q.getResources());
        this.H = b(110.0f, this.Q.getResources());
    }

    private void f() {
        int i3 = this.R;
        if (i3 == 0) {
            this.K = this.J - this.H;
        } else if (i3 == 1) {
            this.K = this.J;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(12)
    public void h(int i3) {
        if (QLog.isColorLevel()) {
            QLog.i("ScanOcrView", 2, "realPlayScanRectAnimation, hasDoneCnt=" + i3 + ",mScanRectPlaying=" + this.U + ",mPlaying=" + this.f254892h);
        }
        if (i3 == 2) {
            return;
        }
        g gVar = this.W;
        this.f254886b0 = gVar;
        this.W = c(i3, gVar);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.1f, 1.0f);
        ofFloat.addUpdateListener(new b());
        ofFloat.setDuration(200L);
        ValueAnimator ofInt = ValueAnimator.ofInt(255, 0);
        ofInt.addUpdateListener(new c());
        ofInt.setDuration(200L);
        ofInt.addListener(new d(i3));
        g gVar2 = this.W;
        int i16 = gVar2.f254909f;
        if (i3 == 0) {
            i16 = gVar2.f254908e;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(ofFloat, ofInt);
        this.f254887c0 = animatorSet;
        animatorSet.setStartDelay(i16);
        animatorSet.start();
        invalidate();
    }

    @TargetApi(12)
    private void i() {
        if (QLog.isColorLevel()) {
            QLog.i("ScanOcrView", 2, "realPlayScanRectHoldAnimation, ,mScanRectHoldPlaying=" + this.V + ",mPlaying=" + this.f254892h);
        }
        this.f254885a0 = d();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.1f, 1.0f);
        g gVar = this.f254885a0;
        ofFloat.addUpdateListener(new e(gVar));
        ofFloat.setDuration(200L);
        ValueAnimator ofInt = ValueAnimator.ofInt(255, 0);
        ofInt.addUpdateListener(new f(gVar));
        ofInt.setDuration(100L);
        ofInt.setRepeatCount(3);
        ofInt.setRepeatMode(2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(ofFloat, ofInt);
        this.f254889d0 = animatorSet;
        animatorSet.start();
        invalidate();
    }

    public boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.f254892h;
    }

    public void j(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ScanOcrView", 2, "startScan, mPlaying=" + this.f254892h + ",scanType=" + i3 + ",mScanType=" + this.R);
        }
        this.S.removeMessages(0);
        if (i3 != this.R) {
            m();
            n();
        }
        if (!this.f254892h) {
            this.E = 0;
            this.f254893i = System.currentTimeMillis();
            this.R = i3;
            f();
            this.f254892h = true;
            invalidate();
        }
    }

    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ScanOcrView", 2, "startScanRectAnimation, mScanRectPlaying=" + this.U);
        }
        if (!this.U) {
            this.U = true;
            h(0);
            invalidate();
        }
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ScanOcrView", 2, "startScanRectHoldAni, mScanRectHoldPlaying=" + this.V);
        }
        if (!this.V) {
            this.V = true;
            i();
            invalidate();
        }
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ScanOcrView", 2, "stopScan, mPlaying=" + this.f254892h + ",scanType=" + this.R);
        }
        this.S.removeMessages(0);
        this.f254892h = false;
        invalidate();
    }

    @TargetApi(12)
    public void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ScanOcrView", 2, "stopScanRectAnimation, mScanRectPlaying=" + this.U);
        }
        this.U = false;
        AnimatorSet animatorSet = this.f254887c0;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        invalidate();
    }

    @TargetApi(12)
    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ScanOcrView", 2, "stopScanRectHoldAni, mScanRectHoldPlaying=" + this.V);
        }
        this.V = false;
        AnimatorSet animatorSet = this.f254887c0;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        g gVar;
        g gVar2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) canvas);
            return;
        }
        if (this.f254892h) {
            int i3 = this.E;
            int i16 = 0;
            if (i3 >= this.K) {
                this.E = 0;
                m();
                n();
                if (this.R == 0) {
                    k();
                }
                this.S.removeMessages(0);
                this.S.sendMessageDelayed(Message.obtain(this.S, 0, this.R, 0), 2000L);
                return;
            }
            if (i3 != 0) {
                long currentTimeMillis = System.currentTimeMillis() - this.f254893i;
                int i17 = this.K;
                int i18 = (int) ((currentTimeMillis * i17) / 2000);
                int i19 = this.E;
                if (i19 + i18 > i17) {
                    this.E = i17;
                } else {
                    this.E = i19 + i18;
                }
            } else {
                this.E = 10;
            }
            int i26 = this.E;
            int i27 = i26 - this.G;
            if (i27 >= 0) {
                i16 = i27;
            }
            Drawable drawable = this.f254890e;
            int i28 = this.N;
            drawable.setBounds(i28, i16, this.I + i28, i26);
            this.f254890e.draw(canvas);
            Drawable drawable2 = this.f254888d;
            int i29 = this.N;
            int i36 = this.E;
            int i37 = i36 - this.D;
            int i38 = this.F;
            drawable2.setBounds(i29, i37 + i38, this.I + i29, i36 + i38);
            this.f254888d.draw(canvas);
            this.f254893i = System.currentTimeMillis();
            invalidate();
        }
        if (this.U && (gVar2 = this.W) != null) {
            this.T.setAlpha(gVar2.f254911h);
            Drawable drawable3 = this.T;
            Rect rect = this.W.f254910g;
            drawable3.setBounds(rect.left, rect.top, rect.right, rect.bottom);
            this.T.draw(canvas);
        }
        if (this.V && (gVar = this.f254885a0) != null) {
            this.T.setAlpha(gVar.f254911h);
            Drawable drawable4 = this.T;
            Rect rect2 = this.f254885a0.f254910g;
            drawable4.setBounds(rect2.left, rect2.top, rect2.right, rect2.bottom);
            this.T.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        this.f254894m = i3;
        this.C = i16;
        this.I = (i3 - this.N) - this.P;
        this.J = (i16 - this.L) - this.M;
        f();
        invalidate();
    }

    @Override // android.view.View
    public void setPadding(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        this.N = i3;
        this.P = i17;
        this.L = i16;
        this.M = i18;
    }

    public ScanOcrView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f254892h = false;
        this.R = 1;
        this.S = new a();
        this.U = false;
        this.V = false;
        this.Q = context;
        e();
    }
}
