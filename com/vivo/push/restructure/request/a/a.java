package com.vivo.push.restructure.request.a;

import com.vivo.push.restructure.request.a.a.b;
import com.vivo.push.util.u;
import org.json.JSONException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class a implements com.vivo.push.restructure.request.a.a.b {

    /* renamed from: a, reason: collision with root package name */
    public static final b.a<a> f387812a = new b();

    /* renamed from: b, reason: collision with root package name */
    private String f387813b;

    /* renamed from: c, reason: collision with root package name */
    private int f387814c;

    /* renamed from: d, reason: collision with root package name */
    private int f387815d;

    /* renamed from: e, reason: collision with root package name */
    private long f387816e;

    /* renamed from: f, reason: collision with root package name */
    private int f387817f;

    /* renamed from: g, reason: collision with root package name */
    private int f387818g;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(com.vivo.push.restructure.request.a.a.a aVar) {
        try {
            this.f387813b = aVar.c();
            this.f387814c = aVar.a();
            this.f387816e = aVar.b();
            this.f387817f = aVar.a();
            this.f387815d = aVar.a();
            this.f387818g = aVar.a();
        } catch (JSONException e16) {
            u.a("CFToClientDS", e16);
        }
    }

    public final int a() {
        return this.f387814c;
    }

    public final int b() {
        return this.f387817f;
    }

    public final int c() {
        return this.f387818g;
    }

    @Override // com.vivo.push.restructure.request.a.a.b
    public final void a(com.vivo.push.restructure.request.a.a.a aVar) {
        aVar.a(this.f387813b);
        aVar.a(this.f387814c);
        aVar.a(this.f387816e);
        aVar.a(this.f387817f);
        aVar.a(this.f387815d);
        aVar.a(this.f387818g);
    }
}
