package com.tencent.av.opengl.ui;

import android.content.Context;
import android.view.ViewConfiguration;

/* compiled from: P */
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private d f74175a;

    /* renamed from: b, reason: collision with root package name */
    private int f74176b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f74177c;

    public f(Context context) {
        this.f74175a = new d(context);
        this.f74176b = ViewConfiguration.get(context).getScaledOverflingDistance();
    }

    public boolean a(long j3) {
        return this.f74175a.b();
    }

    public void b(int i3, int i16, int i17) {
        int i18;
        int d16 = d();
        d dVar = this.f74175a;
        if (this.f74177c) {
            i18 = this.f74176b;
        } else {
            i18 = 0;
        }
        dVar.c(d16, 0, i3, 0, i16, i17, 0, 0, i18, 0);
    }

    public void c() {
        this.f74175a.d(true);
    }

    public int d() {
        return this.f74175a.e();
    }

    public boolean e() {
        return this.f74175a.f();
    }

    public void f(int i3) {
        this.f74176b = Math.max(i3, this.f74176b);
    }

    public void g(boolean z16) {
        this.f74177c = z16;
    }

    public void h(int i3) {
        this.f74175a.g(i3, 0, 0, 0, 0);
        this.f74175a.a();
    }
}
