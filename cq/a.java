package cq;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    public RectF f391620a;

    /* renamed from: c, reason: collision with root package name */
    public BitmapShader f391622c;

    /* renamed from: e, reason: collision with root package name */
    public float f391624e;

    /* renamed from: f, reason: collision with root package name */
    public float f391625f;

    /* renamed from: g, reason: collision with root package name */
    public float f391626g;

    /* renamed from: h, reason: collision with root package name */
    public float f391627h;

    /* renamed from: i, reason: collision with root package name */
    public int f391628i;

    /* renamed from: j, reason: collision with root package name */
    public Bitmap f391629j;

    /* renamed from: k, reason: collision with root package name */
    public int f391630k;

    /* renamed from: l, reason: collision with root package name */
    public int f391631l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f391632m;

    /* renamed from: b, reason: collision with root package name */
    public Path f391621b = new Path();

    /* renamed from: d, reason: collision with root package name */
    public Paint f391623d = new Paint(1);

    private void a(Canvas canvas) {
        int i3 = this.f391631l;
        if (i3 == 0) {
            this.f391623d.setColor(this.f391628i);
        } else if (i3 == 1) {
            if (this.f391629j == null) {
                return;
            }
            if (this.f391622c == null) {
                Bitmap bitmap = this.f391629j;
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                this.f391622c = new BitmapShader(bitmap, tileMode, tileMode);
            }
            this.f391623d.setShader(this.f391622c);
            f();
        }
        d(this.f391630k, this.f391621b);
        canvas.drawPath(this.f391621b, this.f391623d);
    }

    private void b(RectF rectF, Path path) {
        if (this.f391632m) {
            this.f391627h = ((rectF.right - rectF.left) / 2.0f) - (this.f391624e / 2.0f);
        }
        path.moveTo(rectF.left + this.f391625f, rectF.top);
        path.lineTo(rectF.width() - this.f391625f, rectF.top);
        float f16 = rectF.right;
        float f17 = this.f391625f;
        float f18 = rectF.top;
        path.arcTo(new RectF(f16 - f17, f18, f16, f17 + f18), 270.0f, 90.0f);
        path.lineTo(rectF.right, (rectF.bottom - this.f391626g) - this.f391625f);
        float f19 = rectF.right;
        float f26 = this.f391625f;
        float f27 = rectF.bottom;
        float f28 = this.f391626g;
        path.arcTo(new RectF(f19 - f26, (f27 - f26) - f28, f19, f27 - f28), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.f391624e + this.f391627h, rectF.bottom - this.f391626g);
        path.lineTo(rectF.left + this.f391627h + (this.f391624e / 2.0f), rectF.bottom);
        path.lineTo(rectF.left + this.f391627h, rectF.bottom - this.f391626g);
        path.lineTo(rectF.left + Math.min(this.f391625f, this.f391627h), rectF.bottom - this.f391626g);
        float f29 = rectF.left;
        float f36 = rectF.bottom;
        float f37 = this.f391625f;
        float f38 = this.f391626g;
        path.arcTo(new RectF(f29, (f36 - f37) - f38, f37 + f29, f36 - f38), 90.0f, 90.0f);
        path.lineTo(rectF.left, rectF.top + this.f391625f);
        float f39 = rectF.left;
        float f46 = rectF.top;
        float f47 = this.f391625f;
        path.arcTo(new RectF(f39, f46, f47 + f39, f47 + f46), 180.0f, 90.0f);
        path.close();
    }

    private void c(RectF rectF, Path path) {
        if (this.f391632m) {
            this.f391627h = ((rectF.bottom - rectF.top) / 2.0f) - (this.f391624e / 2.0f);
        }
        path.moveTo(this.f391624e + rectF.left + this.f391625f, rectF.top);
        path.lineTo(rectF.width() - this.f391625f, rectF.top);
        float f16 = rectF.right;
        float f17 = this.f391625f;
        float f18 = rectF.top;
        path.arcTo(new RectF(f16 - f17, f18, f16, f17 + f18), 270.0f, 90.0f);
        path.lineTo(rectF.right, rectF.bottom - this.f391625f);
        float f19 = rectF.right;
        float f26 = this.f391625f;
        float f27 = rectF.bottom;
        path.arcTo(new RectF(f19 - f26, f27 - f26, f19, f27), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.f391624e + this.f391625f, rectF.bottom);
        float f28 = rectF.left;
        float f29 = this.f391624e;
        float f36 = rectF.bottom;
        float f37 = this.f391625f;
        path.arcTo(new RectF(f28 + f29, f36 - f37, f37 + f28 + f29, f36), 90.0f, 90.0f);
        path.lineTo(rectF.left + this.f391624e, this.f391626g + this.f391627h);
        path.lineTo(rectF.left, this.f391627h + (this.f391626g / 2.0f));
        path.lineTo(rectF.left + this.f391624e, this.f391627h);
        path.lineTo(rectF.left + this.f391624e, rectF.top + this.f391625f);
        float f38 = rectF.left;
        float f39 = this.f391624e;
        float f46 = rectF.top;
        float f47 = this.f391625f;
        path.arcTo(new RectF(f38 + f39, f46, f38 + f47 + f39, f47 + f46), 180.0f, 90.0f);
        path.close();
    }

    private void e(RectF rectF, Path path) {
        if (this.f391632m) {
            this.f391627h = ((rectF.bottom - rectF.top) / 2.0f) - (this.f391624e / 2.0f);
        }
        path.moveTo(rectF.left + this.f391625f, rectF.top);
        path.lineTo((rectF.width() - this.f391625f) - this.f391624e, rectF.top);
        float f16 = rectF.right;
        float f17 = this.f391625f;
        float f18 = this.f391624e;
        float f19 = rectF.top;
        path.arcTo(new RectF((f16 - f17) - f18, f19, f16 - f18, f17 + f19), 270.0f, 90.0f);
        path.lineTo(rectF.right - this.f391624e, this.f391627h);
        path.lineTo(rectF.right, this.f391627h + (this.f391626g / 2.0f));
        path.lineTo(rectF.right - this.f391624e, this.f391627h + this.f391626g);
        path.lineTo(rectF.right - this.f391624e, rectF.bottom - this.f391625f);
        float f26 = rectF.right;
        float f27 = this.f391625f;
        float f28 = this.f391624e;
        float f29 = rectF.bottom;
        path.arcTo(new RectF((f26 - f27) - f28, f29 - f27, f26 - f28, f29), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.f391624e, rectF.bottom);
        float f36 = rectF.left;
        float f37 = rectF.bottom;
        float f38 = this.f391625f;
        path.arcTo(new RectF(f36, f37 - f38, f38 + f36, f37), 90.0f, 90.0f);
        float f39 = rectF.left;
        float f46 = rectF.top;
        float f47 = this.f391625f;
        path.arcTo(new RectF(f39, f46, f47 + f39, f47 + f46), 180.0f, 90.0f);
        path.close();
    }

    private void f() {
        Matrix matrix = new Matrix();
        matrix.set(null);
        matrix.postScale(getIntrinsicWidth() / this.f391629j.getWidth(), getIntrinsicHeight() / this.f391629j.getHeight());
        RectF rectF = this.f391620a;
        matrix.postTranslate(rectF.left, rectF.top);
        this.f391622c.setLocalMatrix(matrix);
    }

    private void g(RectF rectF, Path path) {
        if (this.f391632m) {
            this.f391627h = ((rectF.right - rectF.left) / 2.0f) - (this.f391624e / 2.0f);
        }
        path.moveTo(rectF.left + Math.min(this.f391627h, this.f391625f), rectF.top + this.f391626g);
        path.lineTo(rectF.left + this.f391627h, rectF.top + this.f391626g);
        path.lineTo(rectF.left + (this.f391624e / 2.0f) + this.f391627h, rectF.top);
        path.lineTo(rectF.left + this.f391624e + this.f391627h, rectF.top + this.f391626g);
        path.lineTo(rectF.right - this.f391625f, rectF.top + this.f391626g);
        float f16 = rectF.right;
        float f17 = this.f391625f;
        float f18 = rectF.top;
        float f19 = this.f391626g;
        path.arcTo(new RectF(f16 - f17, f18 + f19, f16, f17 + f18 + f19), 270.0f, 90.0f);
        path.lineTo(rectF.right, rectF.bottom - this.f391625f);
        float f26 = rectF.right;
        float f27 = this.f391625f;
        float f28 = rectF.bottom;
        path.arcTo(new RectF(f26 - f27, f28 - f27, f26, f28), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.f391625f, rectF.bottom);
        float f29 = rectF.left;
        float f36 = rectF.bottom;
        float f37 = this.f391625f;
        path.arcTo(new RectF(f29, f36 - f37, f37 + f29, f36), 90.0f, 90.0f);
        path.lineTo(rectF.left, rectF.top + this.f391626g + this.f391625f);
        float f38 = rectF.left;
        float f39 = rectF.top;
        float f46 = this.f391626g;
        float f47 = this.f391625f;
        path.arcTo(new RectF(f38, f39 + f46, f47 + f38, f47 + f39 + f46), 180.0f, 90.0f);
        path.close();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        a(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.f391620a.height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) this.f391620a.width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        this.f391623d.setAlpha(i3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f391623d.setColorFilter(colorFilter);
    }

    private void d(int i3, Path path) {
        if (i3 == 0) {
            c(this.f391620a, path);
            return;
        }
        if (i3 == 1) {
            e(this.f391620a, path);
        } else if (i3 == 2) {
            g(this.f391620a, path);
        } else {
            if (i3 != 3) {
                return;
            }
            b(this.f391620a, path);
        }
    }
}
