package com.vivo.push;

import com.vivo.push.restructure.request.a.a.c;
import org.json.JSONException;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class g implements com.vivo.push.restructure.request.a.a.c {

    /* renamed from: a, reason: collision with root package name */
    public static c.a<g> f387703a = new h();

    /* renamed from: b, reason: collision with root package name */
    private int f387704b;

    /* renamed from: c, reason: collision with root package name */
    private String f387705c;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(com.vivo.push.restructure.request.a.a.a aVar) throws JSONException {
        this.f387704b = aVar.a();
        this.f387705c = aVar.c();
    }

    @Override // com.vivo.push.restructure.request.a.a.c
    public final String a() {
        com.vivo.push.restructure.request.a.a.a aVar = new com.vivo.push.restructure.request.a.a.a();
        aVar.a(this.f387704b);
        aVar.a(this.f387705c);
        return aVar.d();
    }

    public final String b() {
        return this.f387705c;
    }
}
