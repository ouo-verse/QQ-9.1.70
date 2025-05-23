package com.qzone.jbox2d.common;

/* compiled from: P */
/* loaded from: classes39.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private long f48159a;

    public e() {
        b();
    }

    public float a() {
        return (((float) ((System.nanoTime() - this.f48159a) / 1000)) * 1.0f) / 1000.0f;
    }

    public void b() {
        this.f48159a = System.nanoTime();
    }
}
