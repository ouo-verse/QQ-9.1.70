package com.google.android.material.circularreveal;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.circularreveal.b;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes2.dex */
public class CircularRevealHelper {

    /* renamed from: j, reason: collision with root package name */
    public static final int f33490j = 2;

    /* renamed from: a, reason: collision with root package name */
    private final a f33491a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    private final View f33492b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    private final Path f33493c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    private final Paint f33494d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    private final Paint f33495e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    private b.e f33496f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    private Drawable f33497g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f33498h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f33499i;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface Strategy {
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface a {
        void a(Canvas canvas);

        boolean c();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CircularRevealHelper(a aVar) {
        this.f33491a = aVar;
        View view = (View) aVar;
        this.f33492b = view;
        view.setWillNotDraw(false);
        this.f33493c = new Path();
        this.f33494d = new Paint(7);
        Paint paint = new Paint(1);
        this.f33495e = paint;
        paint.setColor(0);
    }

    private void d(@NonNull Canvas canvas) {
        if (n()) {
            Rect bounds = this.f33497g.getBounds();
            float width = this.f33496f.f33507a - (bounds.width() / 2.0f);
            float height = this.f33496f.f33508b - (bounds.height() / 2.0f);
            canvas.translate(width, height);
            this.f33497g.draw(canvas);
            canvas.translate(-width, -height);
        }
    }

    private float f(@NonNull b.e eVar) {
        return e1.a.b(eVar.f33507a, eVar.f33508b, 0.0f, 0.0f, this.f33492b.getWidth(), this.f33492b.getHeight());
    }

    private void h() {
        if (f33490j == 1) {
            this.f33493c.rewind();
            b.e eVar = this.f33496f;
            if (eVar != null) {
                this.f33493c.addCircle(eVar.f33507a, eVar.f33508b, eVar.f33509c, Path.Direction.CW);
            }
        }
        this.f33492b.invalidate();
    }

    private boolean m() {
        boolean z16;
        b.e eVar = this.f33496f;
        if (eVar != null && !eVar.a()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (f33490j == 0) {
            if (z16 || !this.f33499i) {
                return false;
            }
            return true;
        }
        return !z16;
    }

    private boolean n() {
        if (!this.f33498h && this.f33497g != null && this.f33496f != null) {
            return true;
        }
        return false;
    }

    private boolean o() {
        if (!this.f33498h && Color.alpha(this.f33495e.getColor()) != 0) {
            return true;
        }
        return false;
    }

    public void a() {
        if (f33490j == 0) {
            this.f33498h = true;
            this.f33499i = false;
            this.f33492b.buildDrawingCache();
            Bitmap drawingCache = this.f33492b.getDrawingCache();
            if (drawingCache == null && this.f33492b.getWidth() != 0 && this.f33492b.getHeight() != 0) {
                drawingCache = Bitmap.createBitmap(this.f33492b.getWidth(), this.f33492b.getHeight(), Bitmap.Config.ARGB_8888);
                this.f33492b.draw(new Canvas(drawingCache));
            }
            if (drawingCache != null) {
                Paint paint = this.f33494d;
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                paint.setShader(new BitmapShader(drawingCache, tileMode, tileMode));
            }
            this.f33498h = false;
            this.f33499i = true;
        }
    }

    public void b() {
        if (f33490j == 0) {
            this.f33499i = false;
            this.f33492b.destroyDrawingCache();
            this.f33494d.setShader(null);
            this.f33492b.invalidate();
        }
    }

    public void c(@NonNull Canvas canvas) {
        if (m()) {
            int i3 = f33490j;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        this.f33491a.a(canvas);
                        if (o()) {
                            canvas.drawRect(0.0f, 0.0f, this.f33492b.getWidth(), this.f33492b.getHeight(), this.f33495e);
                        }
                    } else {
                        throw new IllegalStateException("Unsupported strategy " + i3);
                    }
                } else {
                    int save = canvas.save();
                    canvas.clipPath(this.f33493c);
                    this.f33491a.a(canvas);
                    if (o()) {
                        canvas.drawRect(0.0f, 0.0f, this.f33492b.getWidth(), this.f33492b.getHeight(), this.f33495e);
                    }
                    canvas.restoreToCount(save);
                }
            } else {
                b.e eVar = this.f33496f;
                canvas.drawCircle(eVar.f33507a, eVar.f33508b, eVar.f33509c, this.f33494d);
                if (o()) {
                    b.e eVar2 = this.f33496f;
                    canvas.drawCircle(eVar2.f33507a, eVar2.f33508b, eVar2.f33509c, this.f33495e);
                }
            }
        } else {
            this.f33491a.a(canvas);
            if (o()) {
                canvas.drawRect(0.0f, 0.0f, this.f33492b.getWidth(), this.f33492b.getHeight(), this.f33495e);
            }
        }
        d(canvas);
    }

    @ColorInt
    public int e() {
        return this.f33495e.getColor();
    }

    @Nullable
    public b.e g() {
        b.e eVar = this.f33496f;
        if (eVar == null) {
            return null;
        }
        b.e eVar2 = new b.e(eVar);
        if (eVar2.a()) {
            eVar2.f33509c = f(eVar2);
        }
        return eVar2;
    }

    public boolean i() {
        if (this.f33491a.c() && !m()) {
            return true;
        }
        return false;
    }

    public void j(@Nullable Drawable drawable) {
        this.f33497g = drawable;
        this.f33492b.invalidate();
    }

    public void k(@ColorInt int i3) {
        this.f33495e.setColor(i3);
        this.f33492b.invalidate();
    }

    public void l(@Nullable b.e eVar) {
        if (eVar == null) {
            this.f33496f = null;
        } else {
            b.e eVar2 = this.f33496f;
            if (eVar2 == null) {
                this.f33496f = new b.e(eVar);
            } else {
                eVar2.c(eVar);
            }
            if (e1.a.c(eVar.f33509c, f(eVar), 1.0E-4f)) {
                this.f33496f.f33509c = Float.MAX_VALUE;
            }
        }
        h();
    }
}
