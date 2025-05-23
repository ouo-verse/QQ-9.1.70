package com.tencent.luggage.wxa.z6;

import android.util.SparseArray;
import androidx.core.util.Pools;
import com.tencent.luggage.wxa.ic.g;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.xd.i;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final SparseArray f146341a = new SparseArray();

    /* renamed from: b, reason: collision with root package name */
    public final C6974a f146342b = new C6974a();

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.z6.a$a, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class C6974a implements Pools.Pool {

        /* renamed from: a, reason: collision with root package name */
        public final ConcurrentLinkedDeque f146343a = new ConcurrentLinkedDeque();

        @Override // androidx.core.util.Pools.Pool
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public d acquire() {
            d dVar = (d) this.f146343a.poll();
            return dVar == null ? new d() : dVar;
        }

        public final void b() {
            this.f146343a.clear();
        }

        @Override // androidx.core.util.Pools.Pool
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean release(d jsApiInfo) {
            Intrinsics.checkNotNullParameter(jsApiInfo, "jsApiInfo");
            return this.f146343a.offer(jsApiInfo);
        }
    }

    public final void a() {
        this.f146342b.b();
        a(this.f146341a);
    }

    public final void b() {
        this.f146342b.b();
    }

    public final Object b(SparseArray sparseArray, int i3) {
        Object obj;
        synchronized (sparseArray) {
            obj = sparseArray.get(i3, null);
            if (obj != null) {
                sparseArray.remove(i3);
            }
        }
        return obj;
    }

    public final void a(int i3, i component, com.tencent.luggage.wxa.xd.c api, String str, String str2) {
        Intrinsics.checkNotNullParameter(component, "component");
        Intrinsics.checkNotNullParameter(api, "api");
        if (e.f146355a.c(api.getName())) {
            return;
        }
        d acquire = this.f146342b.acquire();
        acquire.a(component, api, str, w0.a(), str2);
        a(this.f146341a, i3, acquire);
    }

    public final void a(int i3, int i16) {
        d dVar = (d) a(this.f146341a, i3);
        if (dVar != null) {
            dVar.a(i16);
        }
    }

    public final void a(int i3, String ret) {
        Intrinsics.checkNotNullParameter(ret, "ret");
        d dVar = (d) b(this.f146341a, i3);
        if (dVar == null) {
            return;
        }
        g runtime = dVar.f146349a.getRuntime();
        com.tencent.luggage.wxa.g7.d dVar2 = runtime instanceof com.tencent.luggage.wxa.g7.d ? (com.tencent.luggage.wxa.g7.d) runtime : null;
        if (dVar2 == null) {
            return;
        }
        e.f146355a.b(dVar2, dVar.f146349a.getAppId(), dVar.f146353e, dVar.f146350b.getName(), dVar.f146351c, dVar.f146354f, w0.a() - dVar.f146352d, ret);
        this.f146342b.release(dVar);
    }

    public final void a(SparseArray sparseArray, int i3, Object obj) {
        synchronized (sparseArray) {
            sparseArray.put(i3, obj);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final Object a(SparseArray sparseArray, int i3) {
        Object obj;
        synchronized (sparseArray) {
            obj = sparseArray.get(i3, null);
        }
        return obj;
    }

    public final void a(SparseArray sparseArray) {
        synchronized (sparseArray) {
            sparseArray.clear();
            Unit unit = Unit.INSTANCE;
        }
    }
}
