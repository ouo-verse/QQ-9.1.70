package com.tencent.mapsdk.internal;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class jp extends jn {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<jn> f148937a;

    jp(ArrayList<jn> arrayList) {
        this.f148937a = arrayList;
    }

    @Override // com.tencent.mapsdk.internal.jn
    public final boolean a(jq jqVar) {
        if (this.f148937a.isEmpty()) {
            return true;
        }
        jn jnVar = this.f148937a.get(0);
        if (jnVar.a(jqVar)) {
            this.f148937a.remove(jnVar);
        }
        return this.f148937a.isEmpty();
    }
}
