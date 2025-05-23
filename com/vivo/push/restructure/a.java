package com.vivo.push.restructure;

import android.content.Context;
import com.vivo.push.k;
import com.vivo.push.restructure.a.a.d;
import com.vivo.push.restructure.b.b;
import com.vivo.push.restructure.b.f;
import com.vivo.push.util.z;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private Context f387764a;

    /* renamed from: b, reason: collision with root package name */
    private com.vivo.push.restructure.c.a f387765b;

    /* renamed from: c, reason: collision with root package name */
    private d f387766c;

    /* renamed from: d, reason: collision with root package name */
    private com.vivo.push.restructure.b.a f387767d;

    /* renamed from: e, reason: collision with root package name */
    private b f387768e;

    /* renamed from: f, reason: collision with root package name */
    private com.vivo.push.c.a f387769f;

    /* renamed from: g, reason: collision with root package name */
    private k f387770g;

    /* compiled from: P */
    /* renamed from: com.vivo.push.restructure.a$a, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    private static class C10087a {

        /* renamed from: a, reason: collision with root package name */
        static a f387771a = new a(0);
    }

    /* synthetic */ a(byte b16) {
        this();
    }

    public static a a() {
        return C10087a.f387771a;
    }

    public final synchronized Context b() {
        return this.f387764a;
    }

    public final com.vivo.push.restructure.c.a c() {
        return this.f387765b;
    }

    public final d d() {
        return this.f387766c;
    }

    public final synchronized com.vivo.push.restructure.b.a e() {
        return this.f387767d;
    }

    public final b f() {
        return this.f387768e;
    }

    public final com.vivo.push.c.a g() {
        return this.f387769f;
    }

    public final k h() {
        return this.f387770g;
    }

    a() {
    }

    public final synchronized void a(Context context) {
        if (context == null) {
            return;
        }
        this.f387764a = context;
        com.vivo.push.restructure.b.d dVar = new com.vivo.push.restructure.b.d(new z(context));
        this.f387767d = dVar;
        this.f387765b = new com.vivo.push.restructure.c.b(dVar);
        this.f387766c = new d();
        this.f387768e = new f();
        com.vivo.push.c.a aVar = new com.vivo.push.c.a(context);
        this.f387769f = aVar;
        this.f387770g = new com.vivo.push.z(aVar, e());
    }
}
