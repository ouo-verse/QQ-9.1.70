package com.tencent.av.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class ao extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    private Paint f76983a;

    /* renamed from: b, reason: collision with root package name */
    private final int f76984b;

    /* renamed from: c, reason: collision with root package name */
    private final int f76985c;

    /* renamed from: d, reason: collision with root package name */
    private RectF f76986d;

    /* renamed from: e, reason: collision with root package name */
    private Rect f76987e;

    /* renamed from: h, reason: collision with root package name */
    private int f76990h;

    /* renamed from: f, reason: collision with root package name */
    private HashMap<Integer, ArrayList<Bitmap>> f76988f = new HashMap<>();

    /* renamed from: g, reason: collision with root package name */
    private int f76989g = -1;

    /* renamed from: i, reason: collision with root package name */
    private Rect f76991i = new Rect();

    /* renamed from: j, reason: collision with root package name */
    private boolean f76992j = false;

    public ao(int i3, int i16) {
        this.f76984b = i3;
        this.f76985c = i16;
        Paint paint = new Paint(6);
        this.f76983a = paint;
        paint.setAntiAlias(true);
        this.f76987e = new Rect();
        this.f76986d = new RectF(0.0f, 0.0f, i3, i16);
    }

    private ArrayList<Bitmap> b() {
        return this.f76988f.get(Integer.valueOf(this.f76989g));
    }

    private boolean c() {
        int i3 = this.f76989g;
        if (i3 == 1 || i3 == 3) {
            return true;
        }
        return false;
    }

    public void d(int i3) {
        this.f76990h = i3;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Bitmap bitmap;
        a(canvas);
        ArrayList<Bitmap> b16 = b();
        if (c()) {
            Bitmap bitmap2 = b16.get(0);
            this.f76987e.set(0, 0, bitmap2.getWidth(), bitmap2.getHeight());
            canvas.drawBitmap(bitmap2, this.f76987e, this.f76986d, this.f76983a);
            return;
        }
        int i3 = this.f76989g;
        if (i3 == 0) {
            Bitmap bitmap3 = b16.get(0);
            Bitmap bitmap4 = b16.get(1);
            this.f76987e.set(0, 0, bitmap3.getWidth(), bitmap3.getHeight());
            canvas.drawBitmap(bitmap3, this.f76987e, this.f76986d, this.f76983a);
            canvas.save();
            this.f76991i.set(0, (int) (((10000 - this.f76990h) * r1) / 10000.0f), this.f76984b, this.f76985c);
            canvas.clipRect(this.f76991i);
            canvas.drawBitmap(bitmap4, (Rect) null, this.f76986d, this.f76983a);
            canvas.restore();
            return;
        }
        if (i3 == 2) {
            if (this.f76992j) {
                bitmap = b16.get(1);
            } else {
                bitmap = b16.get(0);
            }
            Bitmap bitmap5 = bitmap;
            this.f76987e.set(0, 0, bitmap5.getWidth(), bitmap5.getHeight());
            canvas.drawBitmap(bitmap5, this.f76987e, this.f76986d, this.f76983a);
        }
    }

    public void e(int i3, Bitmap bitmap) {
        ArrayList<Bitmap> arrayList = this.f76988f.get(Integer.valueOf(i3));
        if (arrayList != null) {
            arrayList.add(bitmap);
            return;
        }
        ArrayList<Bitmap> arrayList2 = new ArrayList<>();
        arrayList2.add(bitmap);
        this.f76988f.put(Integer.valueOf(i3), arrayList2);
    }

    public void f() {
        this.f76988f.clear();
    }

    public void g(int i3) {
        if (this.f76989g == i3) {
            return;
        }
        this.f76989g = i3;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f76985c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f76984b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public void h(boolean z16) {
        this.f76992j = z16;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.f76986d = new RectF(rect.left, rect.top, rect.right, rect.bottom);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        if (this.f76983a.getAlpha() == i3) {
            return;
        }
        this.f76983a.setAlpha(i3);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f76983a.setColorFilter(colorFilter);
    }

    private void a(Canvas canvas) {
    }
}
