package com.tencent.mapsdk.internal;

import com.tencent.mapsdk.vector.VectorMap;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class tw implements fo {

    /* renamed from: a, reason: collision with root package name */
    private final tr f151115a;

    public tw(tr trVar) {
        this.f151115a = trVar;
    }

    @Override // com.tencent.mapsdk.internal.fo
    public final void b(int i3) {
        tr trVar = this.f151115a;
        if (trVar != null && i3 == gh.f148492c) {
            int s16 = ((VectorMap) trVar.e_).s();
            trVar.f151021aa = true;
            trVar.f151022ab = true;
            if (s16 <= trVar.Z) {
                trVar.f151022ab = false;
            } else if (s16 >= trVar.Y) {
                trVar.f151021aa = false;
            }
            if (!trVar.f151060q.isEmpty()) {
                gc gcVar = new gc();
                gcVar.f148468f = 0;
                gcVar.f148469g = trVar.f151021aa;
                gcVar.f148470h = trVar.f151022ab;
                Iterator<fj> it = trVar.f151060q.iterator();
                while (it.hasNext()) {
                    it.next().a(gcVar);
                }
            }
            tr trVar2 = this.f151115a;
            if (!trVar2.f151060q.isEmpty()) {
                gc gcVar2 = new gc();
                gcVar2.f148468f = 0;
                gcVar2.f148469g = trVar2.f151021aa;
                gcVar2.f148470h = trVar2.f151022ab;
                Iterator<fj> it5 = trVar2.f151060q.iterator();
                while (it5.hasNext()) {
                    it5.next().a(gcVar2);
                }
            }
        }
    }
}
