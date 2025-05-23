package com.tencent.luggage.wxa.gi;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final Map f126745a;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.gi.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6245a implements g {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f126746a;

        public C6245a(String str) {
            this.f126746a = str;
        }

        @Override // com.tencent.luggage.wxa.gi.a.g
        public void a(com.tencent.luggage.wxa.hi.c cVar) {
            cVar.b(this.f126746a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements g {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f126748a;

        public b(String str) {
            this.f126748a = str;
        }

        @Override // com.tencent.luggage.wxa.gi.a.g
        public void a(com.tencent.luggage.wxa.hi.c cVar) {
            cVar.a(this.f126748a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements g {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f126750a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.hi.b f126751b;

        public c(String str, com.tencent.luggage.wxa.hi.b bVar) {
            this.f126750a = str;
            this.f126751b = bVar;
        }

        @Override // com.tencent.luggage.wxa.gi.a.g
        public void a(com.tencent.luggage.wxa.hi.c cVar) {
            cVar.a(this.f126750a, this.f126751b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements g {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f126753a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.hi.b f126754b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f126755c;

        public d(String str, com.tencent.luggage.wxa.hi.b bVar, long j3) {
            this.f126753a = str;
            this.f126754b = bVar;
            this.f126755c = j3;
        }

        @Override // com.tencent.luggage.wxa.gi.a.g
        public void a(com.tencent.luggage.wxa.hi.c cVar) {
            cVar.a(this.f126753a, this.f126754b, this.f126755c);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e implements g {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f126757a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.hi.b f126758b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f126759c;

        public e(String str, com.tencent.luggage.wxa.hi.b bVar, long j3) {
            this.f126757a = str;
            this.f126758b = bVar;
            this.f126759c = j3;
        }

        @Override // com.tencent.luggage.wxa.gi.a.g
        public void a(com.tencent.luggage.wxa.hi.c cVar) {
            cVar.a(this.f126757a, this.f126758b, this.f126759c);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f {

        /* renamed from: a, reason: collision with root package name */
        public static final a f126761a = new a(null);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface g {
        void a(com.tencent.luggage.wxa.hi.c cVar);
    }

    public /* synthetic */ a(C6245a c6245a) {
        this();
    }

    public static a a() {
        return f.f126761a;
    }

    public void b(String str, String str2) {
        a(str, new C6245a(str2));
    }

    public a() {
        this.f126745a = new HashMap();
    }

    public void a(String str, com.tencent.luggage.wxa.hi.c cVar) {
        if (cVar == null) {
            return;
        }
        List list = (List) this.f126745a.get(str);
        if (list == null) {
            list = new LinkedList();
            this.f126745a.put(str, list);
        }
        list.add(cVar);
    }

    public void b(String str, String str2, com.tencent.luggage.wxa.hi.b bVar, long j3) {
        a(str, new d(str2, bVar, j3));
    }

    public void a(String str, String str2) {
        a(str, new b(str2));
    }

    public void a(String str, String str2, com.tencent.luggage.wxa.hi.b bVar) {
        a(str, new c(str2, bVar));
    }

    public void a(String str, String str2, com.tencent.luggage.wxa.hi.b bVar, long j3) {
        a(str, new e(str2, bVar, j3));
    }

    public final void a(String str, g gVar) {
        List list = (List) this.f126745a.get(str);
        if (list == null) {
            return;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            gVar.a((com.tencent.luggage.wxa.hi.c) list.get(i3));
        }
    }
}
