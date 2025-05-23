package com.tencent.luggage.wxa.hk;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public final Map f127224a;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f127225a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f127226b;

        public a(String str, String str2) {
            this.f127225a = str;
            this.f127226b = str2;
        }

        @Override // com.tencent.luggage.wxa.hk.b.c
        public void a(d dVar) {
            dVar.a(this.f127225a, this.f127226b);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.hk.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6268b {

        /* renamed from: a, reason: collision with root package name */
        public static final b f127228a = new b(null);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface c {
        void a(d dVar);
    }

    public /* synthetic */ b(com.tencent.luggage.wxa.hk.a aVar) {
        this();
    }

    public static b a() {
        return C6268b.f127228a;
    }

    public b() {
        this.f127224a = new HashMap();
    }

    public void a(String str, String str2, String str3) {
        a(str, new a(str2, str3));
    }

    public final void a(String str, c cVar) {
        List list = (List) this.f127224a.get(str);
        if (list == null) {
            return;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            com.tencent.luggage.wxa.k0.d.a(list.get(i3));
            cVar.a(null);
        }
    }
}
