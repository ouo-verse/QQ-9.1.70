package com.vivo.push.d;

import com.vivo.push.restructure.request.a.a.c;
import org.json.JSONException;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class b implements com.vivo.push.restructure.request.a.a.c {

    /* renamed from: a, reason: collision with root package name */
    public static c.a<b> f387631a = new c();

    /* renamed from: b, reason: collision with root package name */
    private String f387632b;

    public b(String str) {
        this.f387632b = str;
    }

    @Override // com.vivo.push.restructure.request.a.a.c
    public final String a() {
        com.vivo.push.restructure.request.a.a.a aVar = new com.vivo.push.restructure.request.a.a.a();
        aVar.a(this.f387632b);
        return aVar.d();
    }

    public final String b() {
        return this.f387632b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b(com.vivo.push.restructure.request.a.a.a aVar) throws JSONException {
        this.f387632b = aVar.c();
    }
}
