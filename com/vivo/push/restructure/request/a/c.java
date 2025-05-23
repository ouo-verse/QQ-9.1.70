package com.vivo.push.restructure.request.a;

import com.vivo.push.restructure.request.a.a.b;
import org.json.JSONException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class c implements com.vivo.push.restructure.request.a.a.b {

    /* renamed from: a, reason: collision with root package name */
    public static final b.a<c> f387822a = new d();

    /* renamed from: b, reason: collision with root package name */
    private String f387823b;

    /* renamed from: c, reason: collision with root package name */
    private int f387824c;

    /* renamed from: d, reason: collision with root package name */
    private long f387825d;

    /* renamed from: e, reason: collision with root package name */
    private int f387826e;

    public c(int i3, int i16) {
        this.f387823b = com.vivo.push.restructure.a.a().b().getPackageName();
        this.f387824c = i3;
        this.f387825d = 341L;
        this.f387826e = i16;
    }

    @Override // com.vivo.push.restructure.request.a.a.b
    public final void a(com.vivo.push.restructure.request.a.a.a aVar) {
        aVar.a(this.f387823b);
        aVar.a(this.f387824c);
        aVar.a(this.f387825d);
        aVar.a(this.f387826e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c(com.vivo.push.restructure.request.a.a.a aVar) {
        try {
            this.f387823b = aVar.c();
            this.f387824c = aVar.a();
            this.f387825d = aVar.b();
            this.f387826e = aVar.a();
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }
}
