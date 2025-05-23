package com.tencent.mapsdk.internal;

import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class jo extends jn {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<jn> f148936a;

    jo(ArrayList<jn> arrayList) {
        this.f148936a = arrayList;
    }

    @Override // com.tencent.mapsdk.internal.jn
    public final boolean a(jq jqVar) {
        if (this.f148936a.isEmpty()) {
            return true;
        }
        Iterator<jn> it = this.f148936a.iterator();
        while (it.hasNext()) {
            it.next().a(jqVar);
        }
        return true;
    }
}
