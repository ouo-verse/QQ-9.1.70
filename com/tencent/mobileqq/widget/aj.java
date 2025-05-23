package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes20.dex */
public class aj extends Drawable {
    static LruCache<String, Typeface> I = new LruCache<>(8);
    float C;
    private boolean G;
    public WeakReference<Context> H;

    /* renamed from: a, reason: collision with root package name */
    WeakReference<b> f316616a;

    /* renamed from: b, reason: collision with root package name */
    DisplayMetrics f316617b;

    /* renamed from: m, reason: collision with root package name */
    public String f316628m;

    /* renamed from: n, reason: collision with root package name */
    public String f316629n;

    /* renamed from: p, reason: collision with root package name */
    public Drawable f316631p;

    /* renamed from: q, reason: collision with root package name */
    Rect f316632q;

    /* renamed from: r, reason: collision with root package name */
    public Paint f316633r;

    /* renamed from: s, reason: collision with root package name */
    public Paint f316634s;

    /* renamed from: t, reason: collision with root package name */
    public Paint f316635t;

    /* renamed from: u, reason: collision with root package name */
    public Paint f316636u;

    /* renamed from: v, reason: collision with root package name */
    private Paint f316637v;

    /* renamed from: w, reason: collision with root package name */
    RectF f316638w;

    /* renamed from: x, reason: collision with root package name */
    RectF f316639x;

    /* renamed from: c, reason: collision with root package name */
    public int f316618c = 100;

    /* renamed from: d, reason: collision with root package name */
    public int f316619d = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f316620e = -90;

    /* renamed from: f, reason: collision with root package name */
    public boolean f316621f = false;

    /* renamed from: g, reason: collision with root package name */
    public boolean f316622g = false;

    /* renamed from: h, reason: collision with root package name */
    public boolean f316623h = true;

    /* renamed from: i, reason: collision with root package name */
    public float f316624i = 1.5f;

    /* renamed from: j, reason: collision with root package name */
    public float f316625j = 4.0f;

    /* renamed from: k, reason: collision with root package name */
    public boolean f316626k = true;

    /* renamed from: l, reason: collision with root package name */
    public float f316627l = 14.0f;

    /* renamed from: o, reason: collision with root package name */
    public boolean f316630o = true;

    /* renamed from: y, reason: collision with root package name */
    public int f316640y = 1;

    /* renamed from: z, reason: collision with root package name */
    public int f316641z = 25;
    public int A = 2;
    public a B = new a();
    private boolean D = false;
    public boolean E = true;
    public boolean F = false;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public int f316642a;

        a() {
        }

        public void a(int i3) {
            this.f316642a = i3;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (!aj.this.isVisible()) {
                aj.this.f316619d = this.f316642a;
                return;
            }
            aj ajVar = aj.this;
            int i3 = ajVar.f316619d;
            int i16 = this.f316642a;
            if (i3 > i16) {
                ajVar.i(i3 - 1);
                sendEmptyMessageDelayed(0, aj.this.f316641z);
            } else {
                if (i3 < i16) {
                    int i17 = i3 + ajVar.A;
                    if (i17 <= i16) {
                        ajVar.i(i17);
                    } else {
                        ajVar.i(i16);
                    }
                    sendEmptyMessageDelayed(0, aj.this.f316641z);
                    return;
                }
                removeMessages(0);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface b {
        void onProgressChanged(aj ajVar, int i3, int i16);

        void onProgressCompleted(aj ajVar);
    }

    public aj(Context context) {
        this.H = new WeakReference<>(context);
        c(context);
    }

    public int a() {
        return this.f316619d;
    }

    public Resources b() {
        if (this.H.get() == null) {
            return null;
        }
        return this.H.get().getResources();
    }

    void c(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.f316617b = displayMetrics;
        float f16 = this.f316624i;
        float f17 = displayMetrics.density;
        this.f316624i = f16 * f17;
        this.f316625j *= f17;
        this.f316627l *= displayMetrics.scaledDensity;
        Paint paint = new Paint(1);
        this.f316636u = paint;
        paint.setColor(0);
        this.f316636u.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint(1);
        this.f316637v = paint2;
        paint2.setColor(-1493172225);
        Paint paint3 = new Paint(1);
        this.f316635t = paint3;
        paint3.setColor(16777215);
        if (this.f316640y == 1) {
            this.f316635t.setStyle(Paint.Style.STROKE);
            this.f316635t.setStrokeWidth(this.f316625j);
            this.f316637v.setStyle(Paint.Style.STROKE);
            this.f316637v.setStrokeWidth(this.f316625j);
        } else {
            this.f316635t.setStyle(Paint.Style.FILL);
            this.f316637v.setStyle(Paint.Style.FILL);
        }
        Paint paint4 = new Paint(1);
        this.f316633r = paint4;
        paint4.setColor(16777215);
        this.f316633r.setStyle(Paint.Style.STROKE);
        this.f316633r.setStrokeWidth(this.f316624i);
        Paint paint5 = new Paint(1);
        this.f316634s = paint5;
        paint5.setColor(3355443);
        this.f316634s.setTextSize(this.f316627l);
        this.f316634s.setTextAlign(Paint.Align.CENTER);
        this.f316638w = new RectF();
        this.f316632q = new Rect();
        this.f316639x = new RectF();
    }

    public boolean d(int i3) {
        if (i3 >= 0 && i3 <= this.f316618c) {
            return true;
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        AssetManager assets;
        if (!isVisible()) {
            return;
        }
        Rect bounds = getBounds();
        RectF rectF = this.f316638w;
        float f16 = this.C;
        rectF.set(0.0f, 0.0f, f16, f16);
        this.f316638w.offset((bounds.width() - this.C) / 2.0f, (bounds.height() - this.C) / 2.0f);
        if (this.f316623h) {
            float strokeWidth = (int) ((this.f316633r.getStrokeWidth() / 2.0f) + 0.5f);
            this.f316638w.inset(strokeWidth, strokeWidth);
        }
        float centerX = this.f316638w.centerX();
        float centerY = this.f316638w.centerY();
        if (this.E) {
            this.f316639x.set(this.f316638w);
            canvas.drawArc(this.f316639x, 0.0f, 360.0f, true, this.f316636u);
            int i3 = this.f316640y;
            if (i3 != 0 && i3 != 1) {
                if (i3 == 2) {
                    float f17 = (this.C / 2.0f) * (this.f316619d / this.f316618c);
                    if (this.f316623h) {
                        f17 = (f17 + 0.5f) - this.f316633r.getStrokeWidth();
                    }
                    canvas.drawCircle(centerX, centerY, f17, this.f316635t);
                } else {
                    throw new IllegalArgumentException("Invalid Progress Fill = " + this.f316640y);
                }
            } else {
                float f18 = (this.f316619d * 360) / this.f316618c;
                if (this.f316621f) {
                    f18 -= 360.0f;
                }
                if (this.f316622g) {
                    f18 = -f18;
                }
                float f19 = f18;
                if (i3 == 0) {
                    if (this.G) {
                        canvas.drawArc(this.f316639x, 0.0f, 360.0f, true, this.f316637v);
                    }
                    canvas.drawArc(this.f316639x, this.f316620e, f19, true, this.f316635t);
                } else {
                    float strokeWidth2 = (int) ((this.f316635t.getStrokeWidth() / 2.0f) + 0.5f);
                    this.f316639x.inset(strokeWidth2, strokeWidth2);
                    if (this.G) {
                        canvas.drawArc(this.f316639x, 0.0f, 360.0f, false, this.f316637v);
                    }
                    canvas.drawArc(this.f316639x, this.f316620e, f19, false, this.f316635t);
                }
            }
        }
        if (!TextUtils.isEmpty(this.f316628m) && this.f316626k) {
            if (!TextUtils.isEmpty(this.f316629n)) {
                Typeface typeface = I.get(this.f316629n);
                if (typeface == null && b() != null && (assets = b().getAssets()) != null) {
                    typeface = Typeface.createFromAsset(assets, this.f316629n);
                    I.put(this.f316629n, typeface);
                }
                this.f316634s.setTypeface(typeface);
            }
            canvas.drawText(this.f316628m, (int) centerX, (int) (centerY - ((this.f316634s.descent() + this.f316634s.ascent()) / 2.0f)), this.f316634s);
        }
        Drawable drawable = this.f316631p;
        if (drawable != null && this.f316630o) {
            if (this.D) {
                this.f316632q.set(0, 0, bounds.width(), bounds.height());
            } else {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                this.f316632q.set(0, 0, intrinsicWidth, intrinsicWidth);
                this.f316632q.offset((bounds.width() - intrinsicWidth) / 2, (bounds.height() - intrinsicWidth) / 2);
            }
            this.f316631p.setBounds(this.f316632q);
            this.f316631p.draw(canvas);
        }
        if (this.f316623h && this.E) {
            canvas.drawOval(this.f316638w, this.f316633r);
        }
    }

    public void e(int i3) {
        this.f316636u.setColor(i3);
        invalidateSelf();
    }

    public void f(boolean z16) {
        this.D = z16;
    }

    public void g(b bVar) {
        this.f316616a = new WeakReference<>(bVar);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.C;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) this.C;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    public void h(int i3) {
        this.C = i3;
    }

    public void i(int i3) {
        b bVar;
        if (d(i3)) {
            this.f316619d = i3;
            WeakReference<b> weakReference = this.f316616a;
            if (weakReference != null && (bVar = weakReference.get()) != null) {
                int i16 = this.f316619d;
                int i17 = this.f316618c;
                if (i16 == i17) {
                    bVar.onProgressCompleted(this);
                } else {
                    bVar.onProgressChanged(this, i16, i17);
                }
            }
            invalidateSelf();
            return;
        }
        throw new IllegalArgumentException(String.format("Progress (%d) must be between %d and %d", Integer.valueOf(i3), 0, Integer.valueOf(this.f316618c)));
    }

    public void j(int i3) {
        this.f316635t.setColor(i3);
        invalidateSelf();
    }

    public void k(int i3) {
        this.f316637v.setColor(i3);
        invalidateSelf();
    }

    public void l(int i3) {
        if (this.f316635t.getStyle() == Paint.Style.STROKE) {
            float f16 = i3 * this.f316617b.density;
            this.f316625j = f16;
            this.f316635t.setStrokeWidth(f16);
            this.f316637v.setStrokeWidth(this.f316625j);
            invalidateSelf();
        }
    }

    public void m(boolean z16) {
        this.f316630o = z16;
        invalidateSelf();
    }

    public void n(boolean z16) {
        this.G = z16;
    }

    public void o(boolean z16) {
        this.f316623h = z16;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i3) {
        return super.onLevelChange(i3);
    }

    public void p(boolean z16) {
        this.f316626k = z16;
        invalidateSelf();
    }

    public void q(String str) {
        this.f316628m = str;
        invalidateSelf();
    }

    public void r(int i3) {
        this.f316634s.setColor(i3);
        invalidateSelf();
    }

    public void s(int i3) {
        float f16 = i3 * this.f316617b.scaledDensity;
        this.f316627l = f16;
        this.f316634s.setTextSize(f16);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect rect) {
        super.setBounds(rect);
    }

    public void t() {
        this.B.removeMessages(0);
        this.B.a(this.f316619d);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i3, int i16, int i17, int i18) {
        super.setBounds(i3, i16, i17, i18);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
