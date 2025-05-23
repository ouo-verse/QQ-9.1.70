package com.tencent.libra.base.animation.decode;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import t01.d;
import t01.f;

/* compiled from: P */
/* loaded from: classes7.dex */
public abstract class a<R extends d, W extends f> {

    /* renamed from: a, reason: collision with root package name */
    protected final R f118617a;

    /* renamed from: b, reason: collision with root package name */
    public int f118618b;

    /* renamed from: c, reason: collision with root package name */
    public int f118619c;

    /* renamed from: d, reason: collision with root package name */
    public int f118620d;

    /* renamed from: e, reason: collision with root package name */
    public int f118621e;

    /* renamed from: f, reason: collision with root package name */
    public int f118622f;

    public a(R r16) {
        this.f118617a = r16;
    }

    public abstract Bitmap a(Canvas canvas, Paint paint, int i3, Bitmap bitmap, W w3);
}
