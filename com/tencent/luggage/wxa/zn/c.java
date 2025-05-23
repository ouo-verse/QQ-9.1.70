package com.tencent.luggage.wxa.zn;

import com.tencent.luggage.wxa.tn.w;
import com.tencent.mm.sdk.event.pending.StoragePendingEventNotifier;
import com.tencent.mm.sdk.observer.MvvmObserverOwner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class c extends MvvmObserverOwner implements com.tencent.luggage.wxa.pn.b {

    /* renamed from: d, reason: collision with root package name */
    public static final a f146768d = new a(null);

    /* renamed from: c, reason: collision with root package name */
    public final Lazy f146769c;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class b extends Lambda implements Function0 {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final StoragePendingEventNotifier invoke() {
            return new StoragePendingEventNotifier(50L, c.this.a(), c.this);
        }
    }

    public c() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new b());
        this.f146769c = lazy;
    }

    @Override // com.tencent.mm.sdk.observer.MvvmObserverOwner
    public String a() {
        return "MicroMsg.Mvvm.StorageObserverOwner@" + hashCode();
    }

    public final StoragePendingEventNotifier b() {
        return (StoragePendingEventNotifier) this.f146769c.getValue();
    }

    @Override // com.tencent.luggage.wxa.pn.b
    public void a(List eventList) {
        com.tencent.luggage.wxa.zn.b bVar;
        int collectionSizeOrDefault;
        List listOf;
        Intrinsics.checkNotNullParameter(eventList, "eventList");
        if (eventList.size() == 1) {
            bVar = (com.tencent.luggage.wxa.zn.b) eventList.get(0);
        } else {
            if (w.d() <= 1) {
                String a16 = a();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("merge batch event ");
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(eventList, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                Iterator it = eventList.iterator();
                while (it.hasNext()) {
                    arrayList.add(((com.tencent.luggage.wxa.zn.b) it.next()).b());
                }
                sb5.append(arrayList);
                w.a(a16, sb5.toString());
            }
            com.tencent.luggage.wxa.zn.b bVar2 = new com.tencent.luggage.wxa.zn.b(com.tencent.luggage.wxa.zn.a.f146756b.a(), "BATCH_PENDING_KEY", a());
            bVar2.a(new HashMap());
            Iterator it5 = eventList.iterator();
            while (it5.hasNext()) {
                com.tencent.luggage.wxa.zn.b bVar3 = (com.tencent.luggage.wxa.zn.b) it5.next();
                HashMap a17 = bVar2.a();
                if (a17 != null) {
                }
            }
            bVar = bVar2;
        }
        listOf = CollectionsKt__CollectionsJVMKt.listOf(bVar);
        super.b(listOf);
    }

    @Override // com.tencent.mm.sdk.observer.MvvmObserverOwner
    public void b(List eventList) {
        Intrinsics.checkNotNullParameter(eventList, "eventList");
        com.tencent.luggage.wxa.zn.b bVar = new com.tencent.luggage.wxa.zn.b(com.tencent.luggage.wxa.zn.a.f146756b.a(), "BATCH_PENDING_KEY", a());
        bVar.a(new HashMap());
        Iterator it = eventList.iterator();
        while (it.hasNext()) {
            com.tencent.luggage.wxa.zn.b bVar2 = (com.tencent.luggage.wxa.zn.b) it.next();
            HashMap a16 = bVar.a();
            if (a16 != null) {
            }
        }
        a(bVar);
    }

    public void a(com.tencent.luggage.wxa.zn.b event) {
        Intrinsics.checkNotNullParameter(event, "event");
        b().a(event, true);
    }
}
