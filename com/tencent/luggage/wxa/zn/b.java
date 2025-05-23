package com.tencent.luggage.wxa.zn;

import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.zn.a;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes9.dex */
public class b implements com.tencent.luggage.wxa.pn.a {

    /* renamed from: a, reason: collision with root package name */
    public final a f146763a;

    /* renamed from: b, reason: collision with root package name */
    public final String f146764b;

    /* renamed from: c, reason: collision with root package name */
    public final String f146765c;

    /* renamed from: d, reason: collision with root package name */
    public com.tencent.luggage.wxa.xn.a f146766d;

    /* renamed from: e, reason: collision with root package name */
    public HashMap f146767e;

    public b(a eventId, String pendingKey, String logTag) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(pendingKey, "pendingKey");
        Intrinsics.checkNotNullParameter(logTag, "logTag");
        this.f146763a = eventId;
        this.f146764b = pendingKey;
        this.f146765c = logTag;
    }

    public com.tencent.luggage.wxa.pn.a a(com.tencent.luggage.wxa.pn.a newEvent) {
        Intrinsics.checkNotNullParameter(newEvent, "newEvent");
        if (!(newEvent instanceof b)) {
            return this;
        }
        w.a(this.f146765c, "oldEvent:[" + this.f146763a + ", " + getKey() + "] newEvent:[" + ((b) newEvent).f146763a + ", " + newEvent.getKey() + ']');
        return a((b) newEvent, this);
    }

    public final String b() {
        return this.f146764b;
    }

    @Override // com.tencent.luggage.wxa.pn.a
    public String getKey() {
        return this.f146764b;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final b b(b bVar, b bVar2) {
        a aVar;
        com.tencent.luggage.wxa.xn.a aVar2;
        if (!Intrinsics.areEqual(bVar2.f146763a, bVar.f146763a)) {
            a aVar3 = bVar2.f146763a;
            a.C6993a c6993a = a.f146756b;
            if (!Intrinsics.areEqual(aVar3, c6993a.d())) {
                aVar = c6993a.d();
                a aVar4 = bVar.f146763a;
                if (Intrinsics.areEqual(aVar4, c6993a.b())) {
                    a aVar5 = bVar2.f146763a;
                    if (Intrinsics.areEqual(aVar5, c6993a.e())) {
                        aVar = c6993a.b();
                    } else if (Intrinsics.areEqual(aVar5, c6993a.c())) {
                        aVar = c6993a.d();
                    }
                } else if (Intrinsics.areEqual(aVar4, c6993a.c())) {
                    a aVar6 = bVar2.f146763a;
                    if (Intrinsics.areEqual(aVar6, c6993a.b())) {
                        aVar = c6993a.e();
                    } else if (Intrinsics.areEqual(aVar6, c6993a.e())) {
                        aVar = c6993a.c();
                    }
                } else if (Intrinsics.areEqual(aVar4, c6993a.e())) {
                    a aVar7 = bVar2.f146763a;
                    if (Intrinsics.areEqual(aVar7, c6993a.b())) {
                        aVar = c6993a.b();
                    } else if (Intrinsics.areEqual(aVar7, c6993a.c())) {
                        aVar = c6993a.c();
                    }
                }
                b bVar3 = new b(aVar, bVar.f146764b, this.f146765c);
                aVar2 = bVar.f146766d;
                if (!(aVar2 instanceof com.tencent.luggage.wxa.xn.a)) {
                    aVar2 = null;
                }
                bVar3.f146766d = aVar2;
                return bVar3;
            }
        }
        aVar = bVar.f146763a;
        b bVar32 = new b(aVar, bVar.f146764b, this.f146765c);
        aVar2 = bVar.f146766d;
        if (!(aVar2 instanceof com.tencent.luggage.wxa.xn.a)) {
        }
        bVar32.f146766d = aVar2;
        return bVar32;
    }

    public final b a(b bVar, b bVar2) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        a aVar = bVar2.f146763a;
        a.C6993a c6993a = a.f146756b;
        if (Intrinsics.areEqual(aVar, c6993a.a())) {
            HashMap hashMap4 = bVar2.f146767e;
            if (hashMap4 != null) {
                hashMap2.putAll(hashMap4);
            }
        } else {
            String str = bVar2.f146764b;
            Intrinsics.checkNotNull(bVar2, "null cannot be cast to non-null type com.tencent.mm.sdk.storage.observer.StorageObserverEvent<T of com.tencent.mm.sdk.storage.observer.StorageObserverEvent>");
            hashMap2.put(str, bVar2);
        }
        if (Intrinsics.areEqual(bVar.f146763a, c6993a.a())) {
            HashMap hashMap5 = bVar.f146767e;
            if (hashMap5 != null) {
                hashMap3.putAll(hashMap5);
            }
        } else {
            String str2 = bVar.f146764b;
            Intrinsics.checkNotNull(bVar, "null cannot be cast to non-null type com.tencent.mm.sdk.storage.observer.StorageObserverEvent<T of com.tencent.mm.sdk.storage.observer.StorageObserverEvent>");
            hashMap3.put(str2, bVar);
        }
        for (Map.Entry entry : hashMap2.entrySet()) {
            if (hashMap3.containsKey(entry.getKey())) {
                b bVar3 = (b) hashMap3.get(entry.getKey());
                if (bVar3 != null) {
                    Intrinsics.checkNotNullExpressionValue(bVar3, "new");
                    b b16 = b(bVar3, (b) entry.getValue());
                }
                hashMap3.remove(entry.getKey());
            } else {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        hashMap.putAll(hashMap3);
        b bVar4 = new b(a.f146756b.a(), "BATCH_PENDING_KEY", this.f146765c);
        bVar4.f146767e = hashMap;
        return bVar4;
    }

    public final HashMap a() {
        return this.f146767e;
    }

    public final void a(HashMap hashMap) {
        this.f146767e = hashMap;
    }
}
