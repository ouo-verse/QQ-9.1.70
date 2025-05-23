package com.tencent.luggage.wxa.l0;

import android.net.Uri;
import com.tencent.luggage.wxa.l0.r;
import com.tencent.luggage.wxa.n0.v;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class s implements r.c {

    /* renamed from: a, reason: collision with root package name */
    public final j f132851a;

    /* renamed from: b, reason: collision with root package name */
    public final int f132852b;

    /* renamed from: c, reason: collision with root package name */
    public final g f132853c;

    /* renamed from: d, reason: collision with root package name */
    public final a f132854d;

    /* renamed from: e, reason: collision with root package name */
    public volatile Object f132855e;

    /* renamed from: f, reason: collision with root package name */
    public volatile boolean f132856f;

    /* renamed from: g, reason: collision with root package name */
    public volatile long f132857g;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {
        Object a(Uri uri, InputStream inputStream);
    }

    public s(g gVar, Uri uri, int i3, a aVar) {
        this.f132853c = gVar;
        this.f132851a = new j(uri, 1);
        this.f132852b = i3;
        this.f132854d = aVar;
    }

    @Override // com.tencent.luggage.wxa.l0.r.c
    public final boolean a() {
        return this.f132856f;
    }

    @Override // com.tencent.luggage.wxa.l0.r.c
    public final void b() {
        i iVar = new i(this.f132853c, this.f132851a);
        try {
            iVar.open();
            this.f132855e = this.f132854d.a(this.f132853c.getUri(), iVar);
        } finally {
            this.f132857g = iVar.a();
            v.a(iVar);
        }
    }

    @Override // com.tencent.luggage.wxa.l0.r.c
    public final void c() {
        this.f132856f = true;
    }

    public long d() {
        return this.f132857g;
    }

    public final Object e() {
        return this.f132855e;
    }
}
