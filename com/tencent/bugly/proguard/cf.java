package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class cf extends m implements Cloneable {

    /* renamed from: c, reason: collision with root package name */
    static ArrayList<String> f98390c;

    /* renamed from: a, reason: collision with root package name */
    public String f98391a = "";

    /* renamed from: b, reason: collision with root package name */
    public ArrayList<String> f98392b = null;

    @Override // com.tencent.bugly.proguard.m
    public final void a(StringBuilder sb5, int i3) {
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(l lVar) {
        lVar.a(this.f98391a, 0);
        ArrayList<String> arrayList = this.f98392b;
        if (arrayList != null) {
            lVar.a((Collection) arrayList, 1);
        }
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(k kVar) {
        this.f98391a = kVar.b(0, true);
        if (f98390c == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            f98390c = arrayList;
            arrayList.add("");
        }
        this.f98392b = (ArrayList) kVar.a((k) f98390c, 1, false);
    }
}
