package com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextBuilder;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem;
import com.tencent.aelight.camera.aioeditor.capture.text.TextParcelData;
import com.tencent.aelight.camera.aioeditor.capture.text.w;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleView;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.q;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.widget.StoryGuideLineView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Iterator;
import zr.c;

/* compiled from: P */
/* loaded from: classes32.dex */
public class g extends tr.a {

    /* renamed from: d0, reason: collision with root package name */
    public static final String f67980d0 = "g";

    /* renamed from: e0, reason: collision with root package name */
    public static int f67981e0;

    /* renamed from: i0, reason: collision with root package name */
    public static int f67985i0;
    public int K;
    public int L;
    public int M;
    public int N;
    public int P;
    public zr.c Q;
    public int R;
    public int S;
    public int T;
    public int U;
    public a V;
    public c W;
    public ArrayList<c> X;
    DynamicTextBuilder Y;
    public Paint Z;

    /* renamed from: a0, reason: collision with root package name */
    protected Paint f67989a0;

    /* renamed from: b0, reason: collision with root package name */
    c f67990b0;

    /* renamed from: c0, reason: collision with root package name */
    PointF f67991c0;

    /* renamed from: f0, reason: collision with root package name */
    public static final int f67982f0 = ViewUtils.dip2px(20.0f);

    /* renamed from: g0, reason: collision with root package name */
    public static final int f67983g0 = qs.d.f429427e[1];

    /* renamed from: h0, reason: collision with root package name */
    public static final int f67984h0 = Color.parseColor("#80000000");

    /* renamed from: j0, reason: collision with root package name */
    public static int f67986j0 = 270;

    /* renamed from: k0, reason: collision with root package name */
    public static volatile int f67987k0 = 5;

    /* renamed from: l0, reason: collision with root package name */
    private static String f67988l0 = "TextLayer";

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface a {
        void a(boolean z16, boolean z17, boolean z18, boolean z19, boolean z26);

        void b(DynamicTextItem dynamicTextItem);

        boolean c(c cVar);

        void d(float f16);
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final PointF f67992a;

        /* renamed from: b, reason: collision with root package name */
        public final float f67993b;

        /* renamed from: c, reason: collision with root package name */
        public final float f67994c;

        /* renamed from: d, reason: collision with root package name */
        public final float f67995d;

        /* renamed from: e, reason: collision with root package name */
        public final float f67996e;

        /* renamed from: f, reason: collision with root package name */
        public final float f67997f;

        /* renamed from: g, reason: collision with root package name */
        public final float f67998g;

        public b(float f16, float f17, float f18, float f19, float f26, float f27, float f28, float f29) {
            this.f67992a = new PointF(f16, f17);
            this.f67993b = f18;
            this.f67994c = f19;
            this.f67995d = f26;
            this.f67996e = f27;
            this.f67997f = f28;
            this.f67998g = f29;
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class c extends c.a {
        public float A;
        public float B;
        public float C;
        public float D;
        public float E;
        public float F;
        public float G;
        public float H;
        public int I;

        /* renamed from: x, reason: collision with root package name */
        Rect f67999x;

        /* renamed from: y, reason: collision with root package name */
        public float f68000y;

        /* renamed from: z, reason: collision with root package name */
        public DynamicTextItem f68001z;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes32.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {
            a() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (g.this.f67990b0 == null) {
                    return;
                }
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                c cVar = c.this;
                cVar.f453048d = cVar.C + (cVar.E * floatValue);
                cVar.f453049e = cVar.D + (cVar.F * floatValue);
                cVar.f453046b = cVar.A + (cVar.G * floatValue);
                cVar.f453047c = cVar.B + (cVar.H * floatValue);
                a aVar = g.this.V;
                if (aVar != null) {
                    aVar.d(floatValue);
                }
                if (floatValue == 1.0f) {
                    g.this.f0(5);
                }
                g.super.n();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes32.dex */
        public class b implements ValueAnimator.AnimatorUpdateListener {
            b() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (g.this.f67990b0 == null) {
                    return;
                }
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                c cVar = c.this;
                float f16 = 1.0f - floatValue;
                cVar.f453048d = cVar.C + (cVar.E * f16);
                cVar.f453049e = cVar.D + (cVar.F * f16);
                cVar.f453046b = cVar.A + (cVar.G * f16);
                cVar.f453047c = cVar.B + (cVar.H * f16);
                if (floatValue == 1.0f) {
                    g gVar = g.this;
                    gVar.f67990b0 = null;
                    gVar.f0(4);
                }
                g.super.n();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* renamed from: com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.g$c$c, reason: collision with other inner class name */
        /* loaded from: classes32.dex */
        public class C0609c implements ValueAnimator.AnimatorUpdateListener {
            C0609c() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                c.this.f453055k = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                g.this.n();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes32.dex */
        public class d extends AnimatorListenerAdapter {
            d() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                hd0.c.a(g.f67980d0, "scaleAnimator cancel!");
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                hd0.c.a(g.f67980d0, "scaleAnimator end!");
                c cVar = c.this;
                cVar.f453055k = 1.0f;
                cVar.f453054j = false;
                g.this.n();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                hd0.c.a(g.f67980d0, "scaleAnimator start!");
                c.this.f453054j = true;
            }
        }

        public c(g gVar) {
            this(new b(0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f));
            this.f453045a.set(gVar.f67991c0);
            this.f453058n = UIUtils.b(BaseApplication.getContext(), 15.0f);
        }

        @Override // zr.c.a
        public void a(Canvas canvas) {
            if (this.f453065u.isInSegment(((tr.a) g.this).f437143e.u()) || this.f453057m) {
                canvas.save();
                canvas.concat(g.this.Q.o(this, true));
                this.f68001z.g(canvas);
                canvas.restore();
                if (this.f453057m) {
                    h(canvas);
                }
            }
        }

        public void g() {
            ValueAnimator valueAnimator = this.f453056l;
            if (valueAnimator == null || !this.f453054j) {
                return;
            }
            valueAnimator.cancel();
        }

        protected void h(Canvas canvas) {
            int i3;
            int i16;
            canvas.save();
            int i17 = this.f453059o == 0 ? R.drawable.eid : R.drawable.eic;
            if (!this.f453065u.isDataLocked()) {
                i17 = this.f453059o == 0 ? R.drawable.eij : R.drawable.eih;
            }
            int i18 = this.f453059o;
            int i19 = i18 == 1 ? R.drawable.ei_ : R.drawable.ei9;
            int i26 = i18 == 2 ? R.drawable.eig : R.drawable.eif;
            if (this.f453066v) {
                i17 = -1;
            }
            if (((tr.a) g.this).f437143e.K.c1()) {
                i3 = -1;
                i16 = -1;
            } else {
                i3 = i17;
                i16 = i26;
            }
            zr.a.b(canvas, g.this.Q, this, i3, i19, i16);
            canvas.restore();
        }

        public void i(Canvas canvas) {
            if (this.f453065u.isInSegment(((tr.a) g.this).f437143e.u()) || this.f453057m) {
                canvas.save();
                canvas.concat(g.this.Q.o(this, false));
                this.f68001z.g(canvas);
                canvas.restore();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void j() {
            float f16 = this.f453048d;
            this.C = f16;
            float f17 = this.f453049e;
            this.D = f17;
            float f18 = this.f453046b;
            this.A = f18;
            float f19 = this.f453047c;
            this.B = f19;
            float f26 = g.this.T;
            PointF pointF = this.f453045a;
            this.E = (f26 - pointF.x) - f16;
            this.F = (r4.U - pointF.y) - f17;
            this.G = 1.0f - f18;
            if (f19 < 180.0f) {
                this.H = 0.0f - f19;
            } else {
                this.H = 360.0f - f19;
            }
        }

        public void k() {
            if (this.f453056l == null) {
                ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.85f, 1.0f);
                this.f453056l = ofFloat;
                ofFloat.setDuration(200L);
                this.f453056l.setInterpolator(new LinearInterpolator());
                this.f453056l.addUpdateListener(new C0609c());
                this.f453056l.addListener(new d());
            }
            if (this.f453054j) {
                return;
            }
            this.f453056l.start();
        }

        public String toString() {
            StringBuilder sb5 = new StringBuilder();
            if (this.f67999x != null) {
                sb5.append("centerP x : ");
                sb5.append(this.f453045a.x);
                sb5.append(" y: ");
                sb5.append(this.f453045a.y);
            }
            sb5.append("textLeft: ");
            sb5.append(this.f68000y);
            sb5.append("mSaveScaleValue: ");
            sb5.append(this.A);
            sb5.append("mSaveRotateValue: ");
            sb5.append(this.B);
            sb5.append("mSaveTranslateXValue: ");
            sb5.append(this.C);
            sb5.append("mDistanceX: ");
            sb5.append(this.E);
            sb5.append("mDistanceY: ");
            sb5.append(this.F);
            sb5.append("mDScale: ");
            sb5.append(this.G);
            sb5.append("mDRotate: ");
            sb5.append(this.H);
            return sb5.toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e() {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            ofFloat.setDuration(g.f67986j0);
            ofFloat.addUpdateListener(new b());
            ofFloat.start();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void f() {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            ofFloat.setDuration(g.f67986j0);
            ofFloat.addUpdateListener(new a());
            ofFloat.start();
        }

        public c(b bVar) {
            super(bVar.f67992a, bVar.f67993b, bVar.f67994c, bVar.f67995d, bVar.f67996e, bVar.f67997f, bVar.f67998g, true);
            w wVar = new w();
            this.f68001z = wVar;
            this.f453051g = wVar.w();
            this.f453052h = this.f68001z.m();
            this.f68000y = g.f67981e0;
            this.f453058n = UIUtils.b(BaseApplication.getContext(), 15.0f);
        }

        public c(c cVar) {
            super(cVar, 1.0f);
            if (cVar.f67999x == null) {
                this.f67999x = new Rect(0, 0, 0, 0);
            } else {
                this.f67999x = new Rect(cVar.f67999x);
            }
            this.f68001z = cVar.f68001z;
            this.f68000y = cVar.f68000y;
            this.A = cVar.A;
            this.B = cVar.B;
            this.C = cVar.C;
            this.D = cVar.D;
            this.E = cVar.E;
            this.F = cVar.F;
            this.G = cVar.G;
            this.H = cVar.H;
            this.f453058n = UIUtils.b(BaseApplication.getContext(), 15.0f);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class d extends c {
        public d() {
            super(g.this);
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.g.c, zr.c.a
        public void a(Canvas canvas) {
            if (this.f453065u.isInSegment(((tr.a) g.this).f437143e.u()) || this.f453057m) {
                canvas.save();
                canvas.concat(g.this.Q.o(this, true));
                this.f68001z.g(canvas);
                canvas.restore();
            }
        }

        public d(b bVar) {
            super(bVar);
        }

        public d(c cVar) {
            super(cVar);
        }
    }

    public g(DoodleView doodleView) {
        super(doodleView);
        this.N = f67984h0;
        this.X = new ArrayList<>();
        this.Y = new DynamicTextBuilder();
        this.f67991c0 = new PointF();
        l();
    }

    public static synchronized void L(boolean z16) {
        synchronized (g.class) {
            if (z16) {
                f67987k0--;
            } else {
                f67987k0++;
            }
            f67987k0 = Math.min(f67987k0, 5);
            f67987k0 = Math.max(f67987k0, 4);
        }
    }

    private void M() {
        this.f437143e.F(false, 0.0f, 0.0f, 0.0f, null, false, 1);
    }

    @Override // tr.a
    public void A(int i3, int i16) {
        super.A(i3, i16);
        PointF pointF = this.f67991c0;
        pointF.x = i3 / 2;
        pointF.y = i16 * 0.42f;
        f67981e0 = (int) (this.f437143e.q() * 0.04f);
    }

    public DynamicTextItem K(b bVar, SegmentKeeper segmentKeeper, int i3) {
        c cVar;
        int size = this.X.size();
        if (size >= f67987k0) {
            return null;
        }
        if (bVar != null) {
            cVar = new c(bVar);
        } else {
            cVar = new c(this);
        }
        cVar.I = i3;
        cVar.f453065u = new SegmentKeeper(segmentKeeper);
        cVar.f453050f.set(this.J);
        float f16 = f67982f0 * size;
        cVar.f453048d = f16;
        cVar.f453049e = f16;
        this.X.add(cVar);
        DynamicTextItem dynamicTextItem = cVar.f68001z;
        this.W = cVar;
        return dynamicTextItem;
    }

    public void N() {
        c cVar;
        a aVar = this.V;
        if (aVar == null || (cVar = this.W) == null) {
            return;
        }
        if (aVar.c(cVar)) {
            this.X.remove(this.W);
        } else {
            this.V.b(this.W.f68001z);
        }
    }

    public void O() {
        c cVar = this.W;
        if (cVar != null) {
            this.X.remove(cVar);
            this.W.g();
            hd0.c.a(f67980d0, "delete " + this.W);
            this.W = null;
        }
        if (this.X.size() == 0) {
            this.K = 1;
            this.L = 1;
        }
    }

    public void P() {
        DynamicTextItem dynamicTextItem;
        ArrayList arrayList = new ArrayList();
        if (this.X.size() > 0) {
            Iterator<c> it = this.X.iterator();
            while (it.hasNext()) {
                c next = it.next();
                DynamicTextItem dynamicTextItem2 = next.f68001z;
                if (dynamicTextItem2 != null && dynamicTextItem2.E()) {
                    arrayList.add(next);
                }
            }
        }
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            this.X.remove((c) it5.next());
        }
        c cVar = this.W;
        if (cVar == null || (dynamicTextItem = cVar.f68001z) == null || !dynamicTextItem.E()) {
            return;
        }
        this.W = null;
    }

    public c Q() {
        ArrayList<c> arrayList = this.X;
        if (arrayList == null || arrayList.size() <= f67987k0) {
            return null;
        }
        this.X.remove(this.W);
        return this.W;
    }

    public void R() {
        if (this.X.size() > 0) {
            this.X.remove(r0.size() - 1);
        }
    }

    public void T() {
        if (this.f67990b0 != null) {
            f0(6);
            this.f67990b0.e();
        }
    }

    public void U() {
        if (!isEmpty()) {
            f0(6);
            c cVar = this.W;
            if (cVar != null) {
                c cVar2 = new c(cVar);
                this.f67990b0 = cVar2;
                cVar2.j();
                this.f67990b0.f();
                return;
            }
            return;
        }
        a aVar = this.V;
        if (aVar != null) {
            aVar.d(1.0f);
        }
    }

    public int V() {
        ArrayList<c> arrayList = this.X;
        if (arrayList == null || arrayList.size() <= 0) {
            return a0() ? 1 : 0;
        }
        return this.X.size();
    }

    public DynamicTextItem W() {
        c cVar = this.W;
        if (cVar != null) {
            return cVar.f68001z;
        }
        return null;
    }

    public boolean X() {
        return this.T > 0 && this.U > 0;
    }

    public void Y() {
        DynamicTextItem dynamicTextItem;
        c cVar = this.W;
        if (cVar != null && (dynamicTextItem = cVar.f68001z) != null) {
            dynamicTextItem.O(-1, false);
        }
        ArrayList<c> arrayList = this.X;
        if (arrayList != null) {
            Iterator<c> it = arrayList.iterator();
            while (it.hasNext()) {
                DynamicTextItem dynamicTextItem2 = it.next().f68001z;
                if (dynamicTextItem2 != null) {
                    dynamicTextItem2.O(-1, false);
                }
            }
        }
        n();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Z() {
        String str = Build.MANUFACTURER + "-" + DeviceInfoMonitor.getModel();
        boolean z16 = str.equalsIgnoreCase("vivo-vivo X6Plus D") || str.equalsIgnoreCase("motorola-Nexus 6");
        hd0.c.a(f67980d0, "isRubbish:" + z16 + " brand:" + str);
        return z16;
    }

    @Override // tr.d
    public boolean a(MotionEvent motionEvent) {
        boolean z16 = false;
        if (a0()) {
            float x16 = motionEvent.getX(0);
            float y16 = motionEvent.getY(0);
            int size = this.X.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                c cVar = this.X.get(size);
                if ((cVar == null || cVar.f453065u == null || !cVar.c() || cVar.f453065u.isCurrentIn()) && this.Q.s(cVar, x16, y16, false)) {
                    this.W = cVar;
                    z16 = true;
                    break;
                }
                size--;
            }
        }
        if (z16) {
            this.X.remove(this.W);
            this.X.add(this.W);
        }
        return z16;
    }

    public boolean a0() {
        int i3 = this.K;
        return i3 == 4 || i3 == 3;
    }

    @Override // tr.d
    public void b(Canvas canvas) {
        w(canvas, this.H, false);
    }

    public void e0(boolean z16) {
        hd0.c.a(f67980d0, "setKeyboardState:" + z16);
        if (!z16) {
            f0(4);
        }
        super.n();
    }

    public void f0(int i3) {
        hd0.c.a(f67980d0, "setMode:" + i3 + ",preMode:" + this.L);
        this.L = this.K;
        this.K = i3;
        if (i3 == 4) {
            B();
        }
        super.n();
    }

    public void g0(a aVar) {
        this.V = aVar;
    }

    @Override // tr.a
    public String h() {
        return f67980d0;
    }

    public void h0(int i3, int i16) {
        if (i3 >= 0 && i16 >= 0) {
            hd0.c.a(f67980d0, "setTextTop:" + i3 + "y=" + i16);
            this.T = i3;
            this.U = i16;
            return;
        }
        hd0.c.g(f67980d0, "setTextOffset x:" + i3 + "y=" + i16);
    }

    public void i0(int i3) {
        if (i3 < 0) {
            hd0.c.g(f67980d0, "setTextTop:" + i3);
            return;
        }
        hd0.c.a(f67980d0, "setTextTop:" + i3);
        this.S = i3;
    }

    @Override // tr.d
    public boolean isEmpty() {
        return this.K == 1;
    }

    public void j0(DynamicTextItem dynamicTextItem) {
        c cVar = this.W;
        if (cVar != null) {
            cVar.f68001z = dynamicTextItem;
            cVar.f453051g = dynamicTextItem.w();
            this.W.f453052h = dynamicTextItem.m();
        }
        c cVar2 = this.f67990b0;
        if (cVar2 != null) {
            cVar2.f68001z = dynamicTextItem;
            c cVar3 = this.W;
            if (cVar3 != null) {
                cVar2.f453046b = cVar3.f453046b;
                cVar2.A = cVar3.f453046b;
            }
        }
    }

    public void k0(DynamicTextItem dynamicTextItem, q qVar, RectF rectF) {
        j0(dynamicTextItem);
        c cVar = this.W;
        if (cVar != null) {
            PointF pointF = cVar.f453045a;
            pointF.x = rectF.left + (cVar.f453051g / 2.0f);
            pointF.y = rectF.top + (cVar.f453052h / 2.0f);
        }
    }

    protected void l() {
        this.P = BaseAIOUtils.f(50.0f, this.f437142d.getResources());
        this.M = zr.a.f(this.f437142d);
        this.L = 1;
        this.K = 1;
        zr.c cVar = new zr.c();
        this.Q = cVar;
        cVar.y(6.0f);
        this.Q.z(0.2f);
        this.Q.A(true);
        Paint paint = new Paint();
        this.Z = paint;
        paint.setAntiAlias(true);
        this.Z.setStyle(Paint.Style.STROKE);
        this.Z.setColor(-1);
        this.Z.setStrokeWidth(2.0f);
        Paint paint2 = new Paint();
        this.f67989a0 = paint2;
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        f67985i0 = ViewConfiguration.get(this.f437142d).getScaledTouchSlop();
        if (f67986j0 == 270 && Z()) {
            f67986j0 = 540;
        }
    }

    @Override // tr.a
    public boolean m(long j3) {
        Iterator<c> it = this.X.iterator();
        while (it.hasNext()) {
            if (it.next().f453065u.isSegmentChanged(j3)) {
                return false;
            }
        }
        return true;
    }

    @Override // tr.a
    protected void p(Canvas canvas) {
        int i3 = this.K;
        if (i3 == 6) {
            c cVar = this.f67990b0;
            if (cVar != null) {
                cVar.a(canvas);
            }
            Iterator<c> it = this.X.iterator();
            while (it.hasNext()) {
                c next = it.next();
                c cVar2 = this.f67990b0;
                if (cVar2 != null && next.f68001z != cVar2.f68001z) {
                    next.a(canvas);
                }
            }
            return;
        }
        if (i3 == 4 || i3 == 3) {
            Iterator<c> it5 = this.X.iterator();
            while (it5.hasNext()) {
                it5.next().a(canvas);
            }
        } else if (i3 == 5) {
            Iterator<c> it6 = this.X.iterator();
            while (it6.hasNext()) {
                c next2 = it6.next();
                if (next2.f68001z != this.W.f68001z) {
                    next2.a(canvas);
                }
            }
        }
    }

    @Override // tr.a
    public boolean q(MotionEvent motionEvent) {
        c cVar;
        c cVar2;
        if (!a0()) {
            return false;
        }
        int y16 = (int) motionEvent.getY();
        int abs = Math.abs(y16 - this.R);
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            c cVar3 = this.W;
            if (cVar3 != null) {
                this.Q.x(cVar3);
                this.W.k();
            }
            this.R = y16;
        } else if (action == 1) {
            c cVar4 = this.W;
            if (cVar4 != null) {
                cVar4.g();
            }
            super.t(false);
            if (abs < f67985i0) {
                N();
            } else if (this.K == 3) {
                f0(4);
            }
        } else if (action == 2) {
            if (this.K == 3 && (cVar = this.W) != null) {
                cVar.g();
            }
            if (abs > f67985i0) {
                f0(3);
            }
        } else if (action == 5 && (cVar2 = this.W) != null) {
            cVar2.g();
        }
        this.Q.e(motionEvent, false);
        c cVar5 = this.W;
        if (cVar5 == null) {
            M();
        } else {
            c0(cVar5);
        }
        return true;
    }

    @Override // tr.a
    public void w(Canvas canvas, float f16, boolean z16) {
        canvas.save();
        canvas.scale(f16, f16);
        Iterator<c> it = this.X.iterator();
        while (it.hasNext()) {
            it.next().i(canvas);
        }
        canvas.restore();
    }

    @Override // tr.a
    public void x(Matrix matrix) {
        super.x(matrix);
        Iterator<c> it = this.X.iterator();
        while (it.hasNext()) {
            it.next().f453050f.set(matrix);
        }
    }

    public DynamicTextItem J(int i3) {
        return K(null, null, i3);
    }

    public void b0(boolean z16) {
        f0(5);
        if (z16) {
            U();
        }
    }

    @Override // tr.d
    public void clear() {
        this.K = 1;
        this.L = 1;
        this.N = f67984h0;
        this.S = 0;
        this.X.clear();
        this.W = null;
        hd0.c.a(f67980d0, "clear over");
    }

    public void S(DynamicTextItem dynamicTextItem) {
        if (dynamicTextItem == null || this.X.size() <= 0) {
            return;
        }
        Iterator<c> it = this.X.iterator();
        c cVar = null;
        while (it.hasNext()) {
            c next = it.next();
            if (dynamicTextItem.equals(next.f68001z)) {
                cVar = next;
            }
        }
        this.X.remove(cVar);
    }

    public void d0(ArrayList<TextParcelData> arrayList, boolean z16) {
        if (arrayList != null && !arrayList.isEmpty()) {
            f0(4);
            this.X.clear();
            Iterator<TextParcelData> it = arrayList.iterator();
            while (it.hasNext()) {
                c a16 = it.next().a(this);
                a16.f453050f.set(this.J);
                this.X.add(a16);
                if (this.X.size() > f67987k0) {
                    break;
                }
            }
        }
        n();
    }

    @Override // tr.a
    public void u(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        super.u(bundle);
        d0(bundle.getParcelableArrayList("TextParcelDataList"), bundle.getBoolean("edit_type_photo"));
    }

    private void c0(c cVar) {
        if (cVar == null) {
            return;
        }
        boolean q16 = this.Q.q(cVar, StoryGuideLineView.E, true);
        boolean q17 = this.Q.q(cVar, StoryGuideLineView.F, false);
        boolean r16 = this.Q.r(cVar, StoryGuideLineView.H, false);
        a aVar = this.V;
        if (aVar != null) {
            aVar.a(q16, q17, false, r16, cVar.f453063s);
        }
        if (cVar.f453057m) {
            this.f437143e.F(cVar.f453063s, cVar.f453047c, cVar.f453048d, cVar.f453049e, cVar.f453045a, cVar.f453064t, 2);
        } else {
            this.f437143e.F(cVar.f453063s, cVar.f453047c, cVar.f453048d, cVar.f453049e, cVar.f453045a, cVar.f453064t, 1);
        }
    }
}
