package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class mm {

    /* renamed from: a, reason: collision with root package name */
    private static final int f149313a = 7;

    /* renamed from: b, reason: collision with root package name */
    private static Canvas f149314b;

    /* renamed from: c, reason: collision with root package name */
    private static int f149315c;

    /* renamed from: d, reason: collision with root package name */
    private static Bitmap[] f149316d;

    /* renamed from: e, reason: collision with root package name */
    private static Bitmap f149317e;

    static {
        Bitmap[] bitmapArr = new Bitmap[7];
        f149316d = bitmapArr;
        bitmapArr[0] = Bitmap.createBitmap(64, 32, Bitmap.Config.ARGB_8888);
        f149316d[1] = Bitmap.createBitmap(128, 32, Bitmap.Config.ARGB_8888);
        f149316d[2] = Bitmap.createBitmap(128, 64, Bitmap.Config.ARGB_8888);
        f149316d[3] = Bitmap.createBitmap(256, 32, Bitmap.Config.ARGB_8888);
        f149316d[4] = Bitmap.createBitmap(256, 128, Bitmap.Config.ARGB_8888);
        f149316d[5] = Bitmap.createBitmap(32, 128, Bitmap.Config.ARGB_8888);
        f149316d[6] = Bitmap.createBitmap(32, 256, Bitmap.Config.ARGB_8888);
        f149314b = new Canvas(f149316d[1]);
        f149315c = 1;
        f149317e = null;
    }

    private static Canvas a(float f16, float f17) {
        int i3 = 0;
        while (i3 < 7 && (f149316d[i3].getWidth() < f16 || f149316d[i3].getHeight() < f17)) {
            i3++;
        }
        if (i3 < 7) {
            f149315c = i3;
            f149314b.setBitmap(f149316d[i3]);
            f149316d[i3].eraseColor(0);
            return f149314b;
        }
        f149315c = f149316d.length;
        int i16 = 1;
        int i17 = 1;
        while (i17 < f16) {
            i17 <<= 1;
        }
        while (i16 < f17) {
            i16 <<= 1;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i17, i16, Bitmap.Config.ARGB_8888);
        f149317e = createBitmap;
        f149314b.setBitmap(createBitmap);
        f149317e.eraseColor(0);
        return f149314b;
    }

    private static Bitmap b() {
        int i3 = f149315c;
        if (i3 < 7) {
            return f149316d[i3];
        }
        return f149317e;
    }

    private static void a(float f16, float f17, Point point) {
        for (int i3 = 0; i3 < 7; i3++) {
            if (f149316d[i3].getWidth() >= f16 && f149316d[i3].getHeight() >= f17) {
                point.set(f149316d[i3].getWidth(), f149316d[i3].getHeight());
                return;
            }
        }
        int i16 = 1;
        int i17 = 1;
        while (i17 < f16) {
            i17 <<= 1;
        }
        while (i16 < f17) {
            i16 <<= 1;
        }
        point.set(i17, i16);
    }

    private static void a() {
        Bitmap bitmap = f149317e;
        if (bitmap != null) {
            bitmap.recycle();
            f149317e = null;
        }
    }
}
