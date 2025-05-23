package com.tencent.luggage.wxa.ie;

import com.tencent.luggage.wxa.ic.e;
import com.tencent.luggage.wxa.tn.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public static final o f130152a = new o();

    /* renamed from: b, reason: collision with root package name */
    public static final Map f130153b = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    public static e.c f130154c;

    /* renamed from: d, reason: collision with root package name */
    public static com.tencent.luggage.wxa.ge.h f130155d;

    /* renamed from: e, reason: collision with root package name */
    public static volatile boolean f130156e;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends e.c {
        @Override // com.tencent.luggage.wxa.ic.e.c
        public void onDestroy() {
            super.onDestroy();
            w.d("MicroMsg.BLE.PeripheralBleServerManager", "onDestroy: ");
            o.f130156e = true;
            o.f130152a.a();
            o.f130154c = null;
            o.f130156e = false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements com.tencent.luggage.wxa.ge.h {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f130157a;

        public b(com.tencent.luggage.wxa.xd.d dVar) {
            this.f130157a = dVar;
        }

        @Override // com.tencent.luggage.wxa.ge.h
        public void a(com.tencent.luggage.wxa.ge.c newState) {
            Intrinsics.checkNotNullParameter(newState, "newState");
            w.d("MicroMsg.BLE.PeripheralBleServerManager", "onAuthorizeStateChange, newState: " + newState);
            if (com.tencent.luggage.wxa.ge.c.REJECTED == newState) {
                com.tencent.luggage.wxa.ge.d.f126692a.b(this.f130157a.getAppId(), this);
                o.f130156e = true;
                o.f130152a.a();
                o.f130155d = null;
                o.f130156e = false;
            }
        }
    }

    public final int b() {
        int a16;
        do {
            a16 = com.tencent.luggage.wxa.pe.b.a();
        } while (f130153b.containsKey(Integer.valueOf(a16)));
        return a16;
    }

    public final boolean c() {
        if (f130153b.size() + 1 > 10) {
            return true;
        }
        return false;
    }

    public final n b(int i3) {
        if (f130156e) {
            return null;
        }
        return (n) f130153b.get(Integer.valueOf(i3));
    }

    public final int a(com.tencent.luggage.wxa.xd.d component) {
        Intrinsics.checkNotNullParameter(component, "component");
        synchronized (this) {
            if (f130154c == null) {
                f130154c = new a();
                com.tencent.luggage.wxa.ic.e.a(component.getAppId(), f130154c);
            }
            if (f130155d == null) {
                f130155d = new b(component);
                com.tencent.luggage.wxa.ge.d.f126692a.a(component.getAppId(), f130155d);
            }
            if (f130156e) {
                return -1;
            }
            Unit unit = Unit.INSTANCE;
            int b16 = b();
            n nVar = new n();
            nVar.a(component, b16);
            f130153b.put(Integer.valueOf(b16), nVar);
            return b16;
        }
    }

    public final boolean a(int i3) {
        if (f130156e) {
            return false;
        }
        Map map = f130153b;
        n nVar = (n) map.get(Integer.valueOf(i3));
        if (nVar == null) {
            return false;
        }
        nVar.f();
        return map.remove(Integer.valueOf(i3)) != null;
    }

    public final void a() {
        synchronized (this) {
            Map map = f130153b;
            ArrayList<n> arrayList = new ArrayList(map.size());
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                arrayList.add((n) ((Map.Entry) it.next()).getValue());
            }
            for (n nVar : arrayList) {
                w.d("MicroMsg.BLE.PeripheralBleServerManager", "destroy server #" + nVar.d());
                nVar.f();
            }
            f130153b.clear();
            Unit unit = Unit.INSTANCE;
        }
    }
}
