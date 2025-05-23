package com.tencent.luggage.wxa.k;

import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.View;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class o {

    /* renamed from: a, reason: collision with root package name */
    public a f131350a;

    /* renamed from: b, reason: collision with root package name */
    public int f131351b;

    /* renamed from: c, reason: collision with root package name */
    public int f131352c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {
        void a();
    }

    public abstract void a(int i3);

    public void a(int i3, int i16) {
    }

    public void b(int i3, int i16) {
        this.f131351b = i3;
        this.f131352c = i16;
    }

    public abstract Class c();

    public abstract Surface d();

    public SurfaceHolder e() {
        return null;
    }

    public Object f() {
        return null;
    }

    public abstract View g();

    public int h() {
        return this.f131351b;
    }

    public abstract boolean i();

    public void a(a aVar) {
        this.f131350a = aVar;
    }

    public void a() {
        this.f131350a.a();
    }

    public int b() {
        return this.f131352c;
    }
}
