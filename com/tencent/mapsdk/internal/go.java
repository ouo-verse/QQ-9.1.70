package com.tencent.mapsdk.internal;

import com.tencent.mapsdk.internal.gn;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class go {

    /* renamed from: a, reason: collision with root package name */
    public final gn.b f148528a;

    /* renamed from: b, reason: collision with root package name */
    public final gn f148529b = new gn();

    public go(gn.b bVar) {
        this.f148528a = bVar;
    }

    private void a(gn.a.EnumC7040a enumC7040a, int i3, String str) {
        gn.b bVar = new gn.b(this.f148528a);
        bVar.f148515a = new gn.a(enumC7040a, i3, str, 1);
        this.f148529b.a(bVar);
    }

    private Collection<? extends gn.b> a() {
        return this.f148529b.f148507a;
    }
}
