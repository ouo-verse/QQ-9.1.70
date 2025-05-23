package com.qzone.widget.util;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.animation.LinearInterpolator;
import com.qzone.widget.util.ImageDownloadDirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.utils.IQzoneHardwareRestriction;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public class c implements ValueAnimator.AnimatorUpdateListener, ImageDownloadDirector.a {
    private static final boolean P = ((IQzoneHardwareRestriction) QRoute.api(IQzoneHardwareRestriction.class)).meetHardwareRestriction(1, 1);
    private float C;
    private float D;
    protected final int E;
    private ValueAnimator F;
    private int G;
    private int H;
    private d I;
    private InterfaceC0506c J;
    private Paint K;
    private int L;
    private boolean M;
    private final ImageDownloadDirector N;

    /* renamed from: d, reason: collision with root package name */
    private Bitmap f61125d;

    /* renamed from: e, reason: collision with root package name */
    private final List<String> f61126e;

    /* renamed from: f, reason: collision with root package name */
    private final b f61127f;

    /* renamed from: h, reason: collision with root package name */
    private final int f61128h;

    /* renamed from: i, reason: collision with root package name */
    private final int f61129i;

    /* renamed from: m, reason: collision with root package name */
    private final int f61130m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            c.this.m();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c cVar = c.this;
            cVar.w(cVar.G);
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface b {
        Bitmap generateBitmap(String str, String str2);
    }

    /* compiled from: P */
    /* renamed from: com.qzone.widget.util.c$c, reason: collision with other inner class name */
    /* loaded from: classes37.dex */
    public interface InterfaceC0506c {
        void onEnd();
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface d {
        void a(int i3);
    }

    public c(Bitmap bitmap, int i3, int i16, int i17) {
        this.L = -1;
        this.f61125d = bitmap;
        this.f61126e = Collections.emptyList();
        this.f61127f = null;
        this.f61129i = i3;
        this.f61130m = i16;
        this.E = i17;
        this.N = null;
        this.C = bitmap.getWidth() / i3;
        this.D = bitmap.getHeight() / i16;
        QZLog.d("FrameAnimDirector", 4, "FrameAnimDirector: frame size " + this.C + " " + this.D);
        this.f61128h = i3 * i16;
    }

    private Paint k() {
        if (this.K == null) {
            Paint paint = new Paint();
            this.K = paint;
            paint.setAntiAlias(true);
        }
        return this.K;
    }

    @Override // com.qzone.widget.util.ImageDownloadDirector.a
    public void a(String str, Bitmap bitmap) {
        d dVar;
        if (this.f61129i != 0 && this.f61130m != 0) {
            this.f61125d = bitmap;
            this.C = bitmap.getWidth() / this.f61129i;
            this.D = this.f61125d.getHeight() / this.f61130m;
            ValueAnimator valueAnimator = this.F;
            if (valueAnimator == null || !valueAnimator.isRunning() || (dVar = this.I) == null) {
                return;
            }
            dVar.a(g());
            return;
        }
        QZLog.w("FrameAnimDirector", "onLoad: wrong image cnt " + this.f61129i + ";" + this.f61130m);
    }

    public void c(boolean z16, long j3) {
        if (l() || this.f61128h == 0) {
            return;
        }
        int g16 = g();
        if (z16) {
            g16 = 0;
        }
        w((int) ((g16 + ((j3 * this.E) / 1000)) % this.f61128h));
    }

    public void d() {
        if (this.F == null || !l()) {
            return;
        }
        this.F.setRepeatCount(0);
    }

    public float f() {
        return this.D;
    }

    public int g() {
        return Math.max(this.L, 0);
    }

    public float h() {
        return this.C;
    }

    public int j() {
        return this.f61128h;
    }

    public boolean l() {
        ValueAnimator valueAnimator = this.F;
        return valueAnimator != null && valueAnimator.isRunning();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m() {
        if (this.M) {
            w(this.H);
        } else {
            this.L = -1;
        }
        InterfaceC0506c interfaceC0506c = this.J;
        if (interfaceC0506c != null) {
            this.J = null;
            interfaceC0506c.onEnd();
        }
    }

    public void o(int i3) {
        k().setAlpha(i3);
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        if (P || Math.abs(intValue - this.L) > 1 || intValue == this.G || intValue == this.H) {
            w(intValue);
        }
    }

    public void p(InterfaceC0506c interfaceC0506c) {
        this.J = interfaceC0506c;
    }

    public void q(boolean z16) {
        this.M = z16;
    }

    public void r(d dVar) {
        this.I = dVar;
    }

    public void t(int i3, int i16, int i17) {
        ImageDownloadDirector imageDownloadDirector;
        v();
        this.G = x(i3);
        this.H = x(i16);
        if (this.f61125d == null && (imageDownloadDirector = this.N) != null && !imageDownloadDirector.i()) {
            this.N.j();
        }
        int i18 = this.G;
        int i19 = this.H;
        if (i18 == i19) {
            w(i18);
            return;
        }
        int i26 = i18 < i19 ? 1 : -1;
        int i27 = ((i19 - i18) * i26) + 1;
        int[] iArr = new int[i27];
        for (int i28 = 0; i28 < i27; i28++) {
            iArr[i28] = this.G + (i28 * i26);
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(iArr);
        this.F = ofInt;
        ofInt.setDuration((i27 * 1000) / this.E);
        this.F.addUpdateListener(this);
        this.F.setRepeatCount(i17);
        this.F.setInterpolator(new LinearInterpolator());
        this.F.addListener(new a());
        this.F.start();
    }

    public void u() {
        QZLog.i("FrameAnimDirector", "startInfinite: ");
        v();
        ValueAnimator ofInt = ValueAnimator.ofInt(0, this.f61128h - 1);
        this.F = ofInt;
        ofInt.setDuration((this.f61128h * 1000) / this.E);
        this.F.setInterpolator(new LinearInterpolator());
        this.F.addUpdateListener(this);
        this.F.setRepeatCount(-1);
        this.F.start();
    }

    public void v() {
        ValueAnimator valueAnimator = this.F;
        if (valueAnimator == null) {
            return;
        }
        valueAnimator.removeUpdateListener(this);
        this.F.cancel();
        this.F = null;
    }

    public void w(int i3) {
        int x16 = x(i3);
        if (this.L != x16) {
            this.L = x16;
            d dVar = this.I;
            if (dVar != null) {
                dVar.a(x16);
            }
        }
    }

    public void n() {
        this.I = null;
    }

    public void s(int i3, int i16) {
        t(i3, i16, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int i(int i3) {
        int i16 = i3 + 1;
        if (i16 >= this.f61128h) {
            return 0;
        }
        return i16;
    }

    private int x(int i3) {
        if (i3 < 0) {
            return 0;
        }
        int i16 = this.f61128h;
        return i3 >= i16 ? i16 - 1 : i3;
    }

    public void e(Canvas canvas, Rect rect) {
        b bVar;
        Bitmap generateBitmap;
        int i3;
        if (canvas == null || rect == null) {
            return;
        }
        k();
        int g16 = g();
        Bitmap bitmap = this.f61125d;
        if (bitmap != null) {
            if (bitmap.isRecycled() || (i3 = this.f61129i) == 0) {
                return;
            }
            float f16 = (g16 % i3) * this.C;
            float f17 = (g16 / i3) * this.D;
            Rect rect2 = new Rect((int) (f16 + 1.0f), (int) (1.0f + f17), (int) (f16 + this.C), (int) (f17 + this.D));
            QZLog.d("FrameAnimDirector", 4, "draw: " + g16 + " -> " + rect2.toShortString() + " to " + rect.toShortString());
            canvas.drawBitmap(this.f61125d, rect2, rect, this.K);
            return;
        }
        if (this.f61126e.isEmpty() || (bVar = this.f61127f) == null || (generateBitmap = bVar.generateBitmap(this.f61126e.get(g16), this.f61126e.get(i(g16)))) == null || generateBitmap.isRecycled()) {
            return;
        }
        canvas.drawBitmap(generateBitmap, new Rect(0, 0, (int) this.C, (int) this.D), rect, this.K);
    }

    public c(Context context, String str, int i3, int i16, int i17, int i18) {
        this.L = -1;
        this.f61126e = Collections.emptyList();
        this.f61127f = null;
        int max = Math.max(i16, 1);
        this.f61129i = max;
        int max2 = Math.max(i17, 1);
        this.f61130m = max2;
        this.E = i18;
        this.f61128h = max * max2;
        i3 = i3 < 1 ? 1 : i3;
        ImageDownloadDirector imageDownloadDirector = new ImageDownloadDirector(context, str, P ? i3 : i3 * 2, this);
        this.N = imageDownloadDirector;
        imageDownloadDirector.j();
    }

    public c(List<String> list, b bVar, int i3) {
        Bitmap generateBitmap;
        this.L = -1;
        this.f61125d = null;
        if (list == null) {
            this.f61126e = Collections.emptyList();
        } else {
            this.f61126e = Collections.unmodifiableList(new ArrayList(list));
        }
        this.f61127f = bVar;
        this.f61129i = 0;
        this.f61130m = 0;
        this.E = i3;
        this.N = null;
        if (this.f61126e.size() != 0 && bVar != null && (generateBitmap = bVar.generateBitmap(this.f61126e.get(0), null)) != null) {
            this.C = generateBitmap.getWidth();
            this.D = generateBitmap.getHeight();
        } else {
            this.C = 0.0f;
            this.D = 0.0f;
        }
        QZLog.i("FrameAnimDirector", "FrameAnimDirector: frame size " + this.C + " " + this.D);
        this.f61128h = this.f61126e.size();
    }
}
