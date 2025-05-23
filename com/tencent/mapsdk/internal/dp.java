package com.tencent.mapsdk.internal;

import com.tencent.mapsdk.internal.cp;
import com.tencent.mapsdk.internal.cp.a;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class dp<R extends cp.a> extends dn<R> {

    /* renamed from: d, reason: collision with root package name */
    public String f148138d;

    /* renamed from: e, reason: collision with root package name */
    public String f148139e;

    private void a(String str) {
        this.f148138d = str;
    }

    private void b(String str) {
        this.f148139e = str;
    }

    @Override // com.tencent.mapsdk.internal.cp
    public final String f() {
        return this.f148138d;
    }

    @Override // com.tencent.mapsdk.internal.dn, com.tencent.mapsdk.internal.cp
    public final String g() {
        return this.f148139e;
    }
}
