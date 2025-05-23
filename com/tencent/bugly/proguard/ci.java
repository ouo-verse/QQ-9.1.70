package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class ci extends m implements Cloneable {

    /* renamed from: b, reason: collision with root package name */
    static ArrayList<ch> f98423b;

    /* renamed from: a, reason: collision with root package name */
    public ArrayList<ch> f98424a = null;

    @Override // com.tencent.bugly.proguard.m
    public final void a(StringBuilder sb5, int i3) {
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(l lVar) {
        lVar.a((Collection) this.f98424a, 0);
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(k kVar) {
        if (f98423b == null) {
            f98423b = new ArrayList<>();
            f98423b.add(new ch());
        }
        this.f98424a = (ArrayList) kVar.a((k) f98423b, 0, true);
    }
}
