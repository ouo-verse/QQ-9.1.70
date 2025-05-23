package com.tencent.luggage.wxa.hj;

import com.tencent.luggage.wxa.ej.e;
import com.tencent.luggage.wxa.ic.l;
import com.tencent.luggage.wxa.rj.c;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.profilecard.vas.misc.VasProfileTemplatePreloadHelper;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b extends e {

    /* renamed from: d, reason: collision with root package name */
    public c.f f127215d;

    public b(e.b bVar, l lVar) {
        super(bVar, lVar);
    }

    @Override // com.tencent.luggage.wxa.ej.e
    public int a() {
        return 3;
    }

    @Override // com.tencent.luggage.wxa.ej.e
    public void b() {
        com.tencent.luggage.wxa.rj.c B1;
        if (this.f127215d == null || this.f124913a.getRuntime() == null || (B1 = ((com.tencent.luggage.wxa.c5.e) this.f124913a.getRuntime()).B1()) == null) {
            return;
        }
        B1.b(this.f127215d);
    }

    @Override // com.tencent.luggage.wxa.ej.e
    public void c() {
        com.tencent.luggage.wxa.rj.c B1 = ((com.tencent.luggage.wxa.c5.e) this.f124913a.getRuntime()).B1();
        if (B1 == null) {
            w.b("MicroMsg.ProxyOnPermissionUpdateListener", "AppRuntimeApiPermissionController null");
            return;
        }
        a aVar = new a();
        this.f127215d = aVar;
        B1.a((c.f) aVar);
    }

    public static void a(Map map, byte[] bArr, byte[] bArr2) {
        map.put("fg", bArr);
        map.put(VasProfileTemplatePreloadHelper.BACKGROUND, bArr2);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements c.f {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.hj.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C6266a extends HashMap {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ byte[] f127217a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ byte[] f127218b;

            public C6266a(byte[] bArr, byte[] bArr2) {
                this.f127217a = bArr;
                this.f127218b = bArr2;
                b.a(this, bArr, bArr2);
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.hj.b$a$b, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C6267b extends HashMap {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ HashMap f127220a;

            public C6267b(HashMap hashMap) {
                this.f127220a = hashMap;
                b.a(this, hashMap);
            }
        }

        public a() {
        }

        @Override // com.tencent.luggage.wxa.rj.c.f
        public void a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
            w.d("MicroMsg.ProxyOnPermissionUpdateListener", "onUpdate");
            b.this.a(new C6266a(bArr, bArr2));
        }

        @Override // com.tencent.luggage.wxa.rj.c.f
        public void a(HashMap hashMap) {
            w.d("MicroMsg.ProxyOnPermissionUpdateListener", "onPluginUpdate");
            if (hashMap == null) {
                return;
            }
            b.this.a(new C6267b(hashMap));
        }
    }

    public static void a(Map map, Map map2) {
        HashMap hashMap = new HashMap();
        map.put("plugins", hashMap);
        if (map2 == null || map2.isEmpty()) {
            return;
        }
        for (Map.Entry entry : map2.entrySet()) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("fg", ((com.tencent.luggage.wxa.rj.b) entry.getValue()).b());
            hashMap2.put(VasProfileTemplatePreloadHelper.BACKGROUND, ((com.tencent.luggage.wxa.rj.b) entry.getValue()).a());
            hashMap.put((String) entry.getKey(), hashMap2);
        }
    }
}
