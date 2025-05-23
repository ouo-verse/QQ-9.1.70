package com.tencent.luggage.wxa.s8;

import android.graphics.Bitmap;
import android.graphics.Rect;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public Bitmap f140132a;

    /* renamed from: b, reason: collision with root package name */
    public d f140133b = new l();

    /* renamed from: c, reason: collision with root package name */
    public Rect f140134c = new Rect();

    /* renamed from: d, reason: collision with root package name */
    public int[] f140135d = new int[4];

    public e(int i3, int i16) {
        a(i3, i16);
    }

    public final void a(int i3, int i16) {
        if (i3 <= 0) {
            i3 = 512;
        }
        if (i16 <= 0) {
            i16 = 512;
        }
        this.f140132a = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
        this.f140133b.init(i3, i16);
        this.f140134c.setEmpty();
    }

    public void b() {
        this.f140134c.setEmpty();
        this.f140133b.reset();
        Bitmap bitmap = this.f140132a;
        if (bitmap != null) {
            bitmap.eraseColor(0);
        }
    }

    public Bitmap c() {
        return this.f140132a;
    }

    public int d() {
        Bitmap bitmap = this.f140132a;
        if (bitmap != null) {
            return bitmap.getHeight();
        }
        return 0;
    }

    public void e() {
        Bitmap bitmap = this.f140132a;
        if (bitmap != null) {
            bitmap.recycle();
        }
    }

    public int f() {
        Bitmap bitmap = this.f140132a;
        if (bitmap != null) {
            return bitmap.getWidth();
        }
        return 0;
    }

    public boolean a(int i3, int i16, Rect rect) {
        if (rect == null) {
            return false;
        }
        if (i3 > 0 && i16 > 0) {
            this.f140133b.a(i3, i16, rect);
            if (rect.left < 0 || rect.right < 0 || rect.width() <= 0 || rect.height() <= 0) {
                return false;
            }
            this.f140134c.union(rect);
            return true;
        }
        rect.setEmpty();
        return false;
    }

    public int[] a() {
        if (!(!this.f140134c.isEmpty())) {
            return null;
        }
        int[] iArr = this.f140135d;
        Rect rect = this.f140134c;
        iArr[0] = rect.left;
        iArr[1] = rect.top;
        iArr[2] = rect.right;
        iArr[3] = rect.bottom;
        rect.setEmpty();
        return this.f140135d;
    }
}
