package com.tencent.luggage.wxa.se;

import com.tencent.luggage.wxa.ic.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    public static final b f140284c = new b(null);

    /* renamed from: d, reason: collision with root package name */
    public static final HashMap f140285d = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    public final String f140286a;

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f140287b;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.se.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6715a extends e.c {
        public C6715a() {
        }

        @Override // com.tencent.luggage.wxa.ic.e.c
        public void onDestroy() {
            a.f140284c.b(a.this.c());
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final a a(String appId) {
            Intrinsics.checkNotNullParameter(appId, "appId");
            synchronized (a.f140285d) {
                a aVar = (a) a.f140285d.get(appId);
                if (aVar != null) {
                    return aVar;
                }
                a aVar2 = new a(appId);
                a.f140285d.put(appId, aVar2);
                return aVar2;
            }
        }

        public final a b(String appId) {
            a aVar;
            Intrinsics.checkNotNullParameter(appId, "appId");
            synchronized (a.f140285d) {
                aVar = (a) a.f140285d.remove(appId);
            }
            return aVar;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final com.tencent.magicbrush.ui.g f140289a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f140290b;

        public c(com.tencent.magicbrush.ui.g view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.f140289a = view;
        }

        public final boolean a() {
            return this.f140290b;
        }

        public final com.tencent.magicbrush.ui.g b() {
            return this.f140289a;
        }

        public final void a(boolean z16) {
            this.f140290b = z16;
        }
    }

    public a(String appId) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        this.f140286a = appId;
        com.tencent.luggage.wxa.ic.e.a(appId, new C6715a());
        this.f140287b = new ConcurrentHashMap();
    }

    public final int b() {
        ConcurrentHashMap concurrentHashMap = this.f140287b;
        int i3 = 0;
        if (!concurrentHashMap.isEmpty()) {
            Iterator it = concurrentHashMap.entrySet().iterator();
            while (it.hasNext()) {
                if (((c) ((Map.Entry) it.next()).getValue()).a()) {
                    i3++;
                }
            }
        }
        return i3;
    }

    public final String c() {
        return this.f140286a;
    }

    public final com.tencent.magicbrush.ui.g d(int i3) {
        Object obj = this.f140287b.get(Integer.valueOf(i3));
        Intrinsics.checkNotNull(obj);
        return ((c) obj).b();
    }

    public final void e(int i3) {
        this.f140287b.remove(Integer.valueOf(i3));
    }

    public final void a(int i3, com.tencent.magicbrush.ui.g view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.f140287b.put(Integer.valueOf(i3), new c(view));
    }

    public final void c(int i3) {
        c cVar = (c) this.f140287b.get(Integer.valueOf(i3));
        if (cVar == null) {
            return;
        }
        cVar.a(true);
    }

    public final void a(int i3) {
        c cVar = (c) this.f140287b.get(Integer.valueOf(i3));
        if (cVar == null) {
            return;
        }
        cVar.a(false);
    }

    public final int b(int i3) {
        return d(i3).getVirtualElementId();
    }
}
