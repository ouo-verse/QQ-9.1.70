package com.tencent.biz.qqcircle.immersive.feed.event;

/* compiled from: P */
/* loaded from: classes4.dex */
public class q extends h {

    /* renamed from: a, reason: collision with root package name */
    private int f86175a;

    /* renamed from: b, reason: collision with root package name */
    private int f86176b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f86177c = false;

    public q(int i3, int i16) {
        this.f86175a = i3;
        this.f86176b = i16;
    }

    public int a() {
        return this.f86176b;
    }

    public int b() {
        return this.f86175a;
    }

    public void c(boolean z16) {
        this.f86177c = z16;
    }

    public boolean d() {
        return this.f86177c;
    }
}
