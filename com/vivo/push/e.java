package com.vivo.push;

import com.vivo.push.restructure.request.a.a.c;
import org.json.JSONException;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class e implements com.vivo.push.restructure.request.a.a.c {

    /* renamed from: a, reason: collision with root package name */
    public static c.a<e> f387647a = new f();

    /* renamed from: b, reason: collision with root package name */
    private int f387648b;

    /* renamed from: c, reason: collision with root package name */
    private String f387649c;

    /* renamed from: d, reason: collision with root package name */
    private String f387650d;

    /* renamed from: e, reason: collision with root package name */
    private String f387651e;

    /* renamed from: f, reason: collision with root package name */
    private String f387652f;

    public e(int i3, String str, String str2, String str3, String str4) {
        this.f387648b = i3;
        this.f387649c = str;
        this.f387650d = str2;
        this.f387651e = str3;
        this.f387652f = str4;
    }

    @Override // com.vivo.push.restructure.request.a.a.c
    public final String a() {
        com.vivo.push.restructure.request.a.a.a aVar = new com.vivo.push.restructure.request.a.a.a();
        aVar.a(this.f387648b);
        aVar.a(this.f387649c);
        aVar.a(this.f387650d);
        aVar.a(this.f387651e);
        aVar.a(this.f387652f);
        return aVar.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e(com.vivo.push.restructure.request.a.a.a aVar) throws JSONException {
        this.f387648b = aVar.a();
        this.f387649c = aVar.c();
        this.f387650d = aVar.c();
        this.f387651e = aVar.c();
        this.f387652f = aVar.c();
    }
}
