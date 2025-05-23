package com.tencent.gamecenter.wadl.sdk.common.b.k;

import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private String f107053a;

    /* renamed from: b, reason: collision with root package name */
    private Map<String, c> f107054b = new HashMap();

    public b(String str) {
        this.f107053a = str;
    }

    public String a() {
        return this.f107053a;
    }

    public Map<String, c> b() {
        return this.f107054b;
    }

    public void a(c cVar) {
        this.f107054b.put(cVar.f107055a, cVar);
    }
}
