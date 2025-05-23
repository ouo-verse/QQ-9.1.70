package com.tencent.biz.qqcircle.immersive.feed.event;

import android.graphics.Bitmap;

/* compiled from: P */
/* loaded from: classes4.dex */
public class u extends h {

    /* renamed from: a, reason: collision with root package name */
    private Bitmap f86187a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f86188b;

    /* renamed from: c, reason: collision with root package name */
    private final int f86189c;

    public u(int i3) {
        this.f86189c = i3;
    }

    public boolean a() {
        return this.f86188b;
    }

    public int b() {
        return this.f86189c;
    }

    public Bitmap c() {
        return this.f86187a;
    }

    public void d(boolean z16) {
        this.f86188b = z16;
    }

    public void e(Bitmap bitmap) {
        this.f86187a = bitmap;
    }
}
