package com.tencent.beacon.event;

import java.util.Iterator;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f77947a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ f f77948b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(f fVar, long j3) {
        this.f77948b = fVar;
        this.f77947a = j3;
    }

    @Override // java.lang.Runnable
    public void run() {
        Set set;
        com.tencent.beacon.event.a.a aVar;
        String str;
        String str2;
        g gVar;
        Set<Long> set2;
        g gVar2;
        StringBuilder sb5 = new StringBuilder();
        set = this.f77948b.f77949a;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            sb5.append((Long) it.next());
            sb5.append(",");
        }
        String substring = sb5.substring(0, sb5.lastIndexOf(","));
        aVar = this.f77948b.f77955g;
        str = this.f77948b.f77954f;
        boolean a16 = aVar.a(str, substring);
        str2 = this.f77948b.f77950b;
        com.tencent.beacon.base.util.c.a(str2, 4, "delete: %s", Boolean.valueOf(a16));
        gVar = this.f77948b.f77953e;
        set2 = this.f77948b.f77949a;
        gVar.a(set2);
        gVar2 = this.f77948b.f77953e;
        gVar2.a(this.f77947a);
    }
}
