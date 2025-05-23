package com.tencent.mapsdk.internal;

import com.tencent.map.tools.net.http.HttpProxyRule;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class cu implements ct {

    /* renamed from: a, reason: collision with root package name */
    public boolean f148074a;

    /* renamed from: b, reason: collision with root package name */
    public List<HttpProxyRule> f148075b;

    private void a(boolean z16) {
        this.f148074a = z16;
    }

    @Override // com.tencent.mapsdk.internal.ct
    public final List<HttpProxyRule> b() {
        return this.f148075b;
    }

    private void a(List<HttpProxyRule> list) {
        this.f148075b = list;
    }

    private void a(cs csVar) {
        this.f148074a = csVar.f148072a;
        this.f148075b = csVar.f148073b;
    }

    @Override // com.tencent.mapsdk.internal.ct
    public final boolean a() {
        return this.f148074a;
    }
}
