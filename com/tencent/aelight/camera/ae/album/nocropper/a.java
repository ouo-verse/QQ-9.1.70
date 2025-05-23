package com.tencent.aelight.camera.ae.album.nocropper;

import android.graphics.Bitmap;
import android.graphics.Rect;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final int f62181a;

    /* renamed from: b, reason: collision with root package name */
    public final int f62182b;

    /* renamed from: c, reason: collision with root package name */
    public final int f62183c;

    /* renamed from: d, reason: collision with root package name */
    public final int f62184d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f62185e;

    /* renamed from: f, reason: collision with root package name */
    public final int f62186f;

    /* renamed from: g, reason: collision with root package name */
    public final int f62187g;

    /* renamed from: h, reason: collision with root package name */
    public final int f62188h;

    public a(int i3, int i16, int i17, int i18, boolean z16, int i19, int i26, int i27) {
        this.f62181a = i3;
        this.f62182b = i16;
        this.f62183c = i17;
        this.f62184d = i18;
        this.f62185e = z16;
        this.f62187g = i19;
        this.f62186f = i26;
        this.f62188h = i27;
    }

    public static a a(Bitmap bitmap, boolean z16, int i3, int i16, int i17) {
        return new a(0, 0, bitmap.getWidth(), bitmap.getHeight(), z16, i3, i16, i17);
    }

    public static a b(Rect rect, boolean z16, int i3, int i16, int i17) {
        return new a(rect.left, rect.top, rect.width(), rect.height(), z16, i3, i16, i17);
    }

    public String toString() {
        return "CropConfig{x=" + this.f62181a + ", y=" + this.f62182b + ", width=" + this.f62183c + ", height=" + this.f62184d + ", addPadding=" + this.f62185e + ", verticalPadding=" + this.f62186f + ", horizontalPadding=" + this.f62187g + '}';
    }
}
