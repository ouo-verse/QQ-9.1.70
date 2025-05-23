package com.qq.e.comm.plugin.base.ad.clickcomponent;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import com.qq.e.comm.plugin.base.adevent.ADLifeEvent;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public class e<T> {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<T> f38605a;

    /* renamed from: b, reason: collision with root package name */
    private int f38606b;

    /* renamed from: c, reason: collision with root package name */
    private int f38607c;

    /* renamed from: d, reason: collision with root package name */
    private String f38608d;

    /* renamed from: e, reason: collision with root package name */
    private Context f38609e;

    /* renamed from: f, reason: collision with root package name */
    private WeakReference<com.qq.e.comm.plugin.base.adevent.a> f38610f;

    /* renamed from: g, reason: collision with root package name */
    private Pair f38611g;

    public e(WeakReference<T> weakReference) {
        this.f38605a = weakReference;
    }

    public T a() {
        WeakReference<T> weakReference = this.f38605a;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public Context b() {
        Context context = this.f38609e;
        if (context != null) {
            return context;
        }
        T a16 = a();
        if (a16 instanceof View) {
            this.f38609e = ((View) a16).getContext();
        }
        return this.f38609e;
    }

    public void c() {
        if (a() != null && (a() instanceof com.qq.e.comm.plugin.base.adevent.a)) {
            ((com.qq.e.comm.plugin.base.adevent.a) a()).a(new ADLifeEvent("Clicked", null));
        } else if (f() != null) {
            f().a(new ADLifeEvent("Clicked", null));
        }
    }

    public String d() {
        return this.f38608d;
    }

    public int e() {
        return this.f38606b;
    }

    public com.qq.e.comm.plugin.base.adevent.a f() {
        WeakReference<com.qq.e.comm.plugin.base.adevent.a> weakReference = this.f38610f;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public void a(String str) {
        this.f38608d = str;
    }

    public void a(int i3) {
        this.f38606b = i3;
    }

    public void a(com.qq.e.comm.plugin.base.adevent.a aVar) {
        this.f38610f = new WeakReference<>(aVar);
    }

    public void a(int i3, int i16) {
        this.f38611g = new Pair(Integer.valueOf(i3), Integer.valueOf(i16));
    }

    public void b(int i3) {
        this.f38607c = i3;
    }
}
