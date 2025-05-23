package com.tencent.ecommerce.richtext.ui.dom.style;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.util.SparseIntArray;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b extends Drawable {

    /* renamed from: s, reason: collision with root package name */
    private static final BorderStyle f105356s = BorderStyle.SOLID;

    /* renamed from: t, reason: collision with root package name */
    private static BorderStyle[] f105357t = BorderStyle.values();

    /* renamed from: f, reason: collision with root package name */
    private SparseIntArray f105363f;

    /* renamed from: g, reason: collision with root package name */
    private SparseIntArray f105364g;

    /* renamed from: h, reason: collision with root package name */
    private Path f105365h;

    /* renamed from: m, reason: collision with root package name */
    private p f105370m;

    /* renamed from: n, reason: collision with root package name */
    private q f105371n;

    /* renamed from: o, reason: collision with root package name */
    private d f105372o;

    /* renamed from: p, reason: collision with root package name */
    private c f105373p;

    /* renamed from: q, reason: collision with root package name */
    private RectF f105374q;

    /* renamed from: a, reason: collision with root package name */
    private boolean f105358a = false;

    /* renamed from: b, reason: collision with root package name */
    private final Paint f105359b = new Paint(1);

    /* renamed from: c, reason: collision with root package name */
    private float[] f105360c = new float[5];

    /* renamed from: d, reason: collision with root package name */
    private float[] f105361d = new float[5];

    /* renamed from: e, reason: collision with root package name */
    private float[] f105362e = new float[5];

    /* renamed from: i, reason: collision with root package name */
    private boolean f105366i = false;

    /* renamed from: j, reason: collision with root package name */
    private int f105367j = 0;

    /* renamed from: k, reason: collision with root package name */
    private Shader f105368k = null;

    /* renamed from: l, reason: collision with root package name */
    private int f105369l = 255;

    /* renamed from: r, reason: collision with root package name */
    List<Float> f105375r = new ArrayList(4);

    private void a(Canvas canvas) {
        RectF rectF = this.f105374q;
        if (rectF == null) {
            this.f105374q = new RectF(getBounds());
        } else {
            rectF.set(getBounds());
        }
        float[] fArr = this.f105360c;
        if (fArr == null) {
            return;
        }
        float f16 = fArr[1];
        float f17 = fArr[2];
        float f18 = fArr[4];
        float f19 = fArr[3];
        if (this.f105370m == null) {
            this.f105370m = new p();
        }
        this.f105370m.x(e(1), f16, f17, this.f105374q);
        if (this.f105371n == null) {
            this.f105371n = new q();
        }
        this.f105371n.x(e(2), f17, f19, this.f105374q);
        if (this.f105372o == null) {
            this.f105372o = new d();
        }
        this.f105372o.x(e(3), f19, f18, this.f105374q);
        if (this.f105373p == null) {
            this.f105373p = new c();
        }
        this.f105373p.x(e(4), f18, f16, this.f105374q);
        c(canvas, this.f105370m, this.f105371n, 2);
        c(canvas, this.f105371n, this.f105372o, 3);
        c(canvas, this.f105372o, this.f105373p, 4);
        c(canvas, this.f105373p, this.f105370m, 1);
    }

    private void b(@NonNull Canvas canvas, a aVar, a aVar2, @NonNull Paint paint, int i3) {
        paint.setStrokeWidth(this.f105360c[i3]);
        aVar.a(canvas, paint, aVar.b());
        paint.setStrokeWidth(this.f105360c[i3]);
        canvas.drawLine(aVar.g(), aVar.h(), aVar2.i(), aVar2.j(), paint);
        aVar2.a(canvas, paint, aVar2.b() - 45.0f);
    }

    private void c(Canvas canvas, a aVar, a aVar2, int i3) {
        if (0.0f != h(i3)) {
            l(i3);
            b(canvas, aVar, aVar2, this.f105359b, i3);
        }
    }

    private float e(int i3) {
        float[] fArr = this.f105362e;
        if (fArr != null) {
            return fArr[i3];
        }
        return 0.0f;
    }

    private float i(@NonNull RectF rectF) {
        float[] fArr = this.f105361d;
        float f16 = fArr[1];
        float f17 = fArr[2];
        float f18 = f16 + f17;
        float f19 = fArr[3];
        float f26 = f17 + f19;
        float f27 = fArr[4];
        float f28 = f19 + f27;
        float f29 = f27 + f16;
        if (!this.f105375r.isEmpty()) {
            this.f105375r.clear();
        }
        t(this.f105375r, rectF.width(), f18);
        t(this.f105375r, rectF.height(), f26);
        t(this.f105375r, rectF.width(), f28);
        t(this.f105375r, rectF.height(), f29);
        if (this.f105375r.isEmpty()) {
            return Float.NaN;
        }
        return ((Float) Collections.min(this.f105375r)).floatValue();
    }

    private void j(int i3, int i16, int i17, int i18, @NonNull RectF rectF, @NonNull Path path) {
        if (this.f105361d != null) {
            k(rectF);
            float[] fArr = this.f105362e;
            float f16 = fArr[1];
            float f17 = fArr[2];
            float f18 = fArr[3];
            float f19 = fArr[4];
            float f26 = i18;
            float f27 = i3;
            float f28 = i16;
            float f29 = i17;
            path.addRoundRect(rectF, new float[]{f16 - f26, f16 - f27, f17 - f28, f17 - f27, f18 - f28, f18 - f29, f19 - f26, f19 - f29}, Path.Direction.CW);
            return;
        }
        path.addRect(rectF, Path.Direction.CW);
    }

    private void k(@NonNull RectF rectF) {
        if (this.f105361d != null) {
            float i3 = i(rectF);
            if (!Float.isNaN(i3) && i3 < 1.0f) {
                float[] fArr = this.f105362e;
                float[] fArr2 = this.f105361d;
                fArr[1] = fArr2[1] * i3;
                fArr[2] = fArr2[2] * i3;
                fArr[3] = fArr2[3] * i3;
                fArr[4] = fArr2[4] * i3;
                return;
            }
            float[] fArr3 = this.f105362e;
            float[] fArr4 = this.f105361d;
            fArr3[1] = fArr4[1];
            fArr3[2] = fArr4[2];
            fArr3[3] = fArr4[3];
            fArr3[4] = fArr4[4];
        }
    }

    private void l(int i3) {
        float f16 = this.f105360c[i3];
        int s16 = com.tencent.ecommerce.richtext.utils.e.s(d(i3), this.f105369l);
        this.f105359b.setShader(f105357t[g(i3)].getLineShader(f16, s16, i3));
        this.f105359b.setColor(s16);
        this.f105359b.setStrokeCap(Paint.Cap.ROUND);
    }

    private void s() {
        if (this.f105366i) {
            this.f105366i = false;
            if (this.f105365h == null) {
                this.f105365h = new Path();
            }
            this.f105365h.reset();
            j(0, 0, 0, 0, new RectF(getBounds()), this.f105365h);
        }
    }

    private void t(@NonNull List<Float> list, float f16, float f17) {
        if (f17 != 0.0f) {
            list.add(Float.valueOf(f16 / f17));
        }
    }

    int d(int i3) {
        return com.tencent.ecommerce.richtext.utils.e.e(this.f105363f, i3, -16777216);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        canvas.save();
        s();
        this.f105359b.setAlpha(255);
        if (this.f105365h != null) {
            int s16 = com.tencent.ecommerce.richtext.utils.e.s(this.f105367j, this.f105369l);
            Shader shader = this.f105368k;
            if (shader != null) {
                this.f105359b.setShader(shader);
                this.f105359b.setStyle(Paint.Style.FILL);
                canvas.drawPath(this.f105365h, this.f105359b);
                this.f105359b.setShader(null);
            } else if ((s16 >>> 24) != 0) {
                this.f105359b.setColor(s16);
                this.f105359b.setStyle(Paint.Style.FILL);
                canvas.drawPath(this.f105365h, this.f105359b);
                this.f105359b.setShader(null);
            }
        }
        this.f105359b.setStyle(Paint.Style.STROKE);
        this.f105359b.setStrokeJoin(Paint.Join.ROUND);
        a(canvas);
        this.f105359b.setShader(null);
        canvas.restore();
    }

    public float[] f() {
        return this.f105361d;
    }

    int g(int i3) {
        return com.tencent.ecommerce.richtext.utils.e.e(this.f105364g, i3, BorderStyle.SOLID.ordinal());
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f105369l;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (this.f105368k != null) {
            return -1;
        }
        return com.tencent.ecommerce.richtext.utils.e.o(com.tencent.ecommerce.richtext.utils.e.s(this.f105367j, this.f105369l));
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(@NonNull Outline outline) {
        if (this.f105365h == null) {
            this.f105366i = true;
        }
        s();
        outline.setConvexPath(this.f105365h);
    }

    float h(int i3) {
        return this.f105360c[i3];
    }

    public void m(int i3, int i16) {
        if (this.f105363f == null) {
            SparseIntArray sparseIntArray = new SparseIntArray(5);
            this.f105363f = sparseIntArray;
            sparseIntArray.put(0, -16777216);
        }
        if (d(i3) != i16) {
            com.tencent.ecommerce.richtext.utils.e.A(this.f105363f, i3, i16);
            invalidateSelf();
        }
    }

    public void n(int i3, float f16) {
        float[] fArr = this.f105361d;
        if (fArr[i3] != f16) {
            this.f105358a = true;
            if (i3 == 0) {
                int i16 = 0;
                while (true) {
                    float[] fArr2 = this.f105361d;
                    if (i16 >= fArr2.length) {
                        break;
                    }
                    if (fArr2[i16] == 0.0f) {
                        fArr2[i16] = f16;
                    }
                    i16++;
                }
            } else {
                fArr[i3] = f16;
            }
            this.f105366i = true;
            invalidateSelf();
        }
    }

    public void o(int i3, @NonNull String str) {
        if (this.f105364g == null) {
            SparseIntArray sparseIntArray = new SparseIntArray(5);
            this.f105364g = sparseIntArray;
            sparseIntArray.put(0, f105356s.ordinal());
        }
        try {
            int ordinal = BorderStyle.valueOf(str.toUpperCase(Locale.US)).ordinal();
            if (g(i3) != ordinal) {
                com.tencent.ecommerce.richtext.utils.e.A(this.f105364g, i3, ordinal);
                invalidateSelf();
            }
        } catch (IllegalArgumentException unused) {
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f105366i = true;
    }

    public void p(int i3, float f16) {
        float[] fArr = this.f105360c;
        if (fArr[i3] != f16) {
            if (i3 == 0) {
                int i16 = 0;
                while (true) {
                    float[] fArr2 = this.f105360c;
                    if (i16 >= fArr2.length) {
                        break;
                    }
                    if (fArr2[i16] == 0.0f) {
                        fArr2[i16] = f16;
                    }
                    i16++;
                }
            } else {
                fArr[i3] = f16;
            }
            this.f105366i = true;
            invalidateSelf();
        }
    }

    public void q(int i3) {
        this.f105367j = i3;
        invalidateSelf();
    }

    public void r(Shader shader) {
        this.f105368k = shader;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        if (i3 != this.f105369l) {
            this.f105369l = i3;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
