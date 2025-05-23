package com.tencent.luggage.wxa.g0;

import com.tencent.luggage.wxa.m.j;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a extends c {

    /* renamed from: c, reason: collision with root package name */
    public final List f126311c;

    /* renamed from: d, reason: collision with root package name */
    public final List f126312d;

    /* renamed from: e, reason: collision with root package name */
    public final List f126313e;

    /* renamed from: f, reason: collision with root package name */
    public final j f126314f;

    /* renamed from: g, reason: collision with root package name */
    public final List f126315g;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.g0.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6226a {

        /* renamed from: a, reason: collision with root package name */
        public final String f126316a;

        /* renamed from: b, reason: collision with root package name */
        public final j f126317b;

        public C6226a(String str, j jVar) {
            this.f126316a = str;
            this.f126317b = jVar;
        }

        public static C6226a a(String str) {
            return new C6226a(str, j.a("0", "application/x-mpegURL", (String) null, (String) null, -1, 0, (String) null));
        }
    }

    public a(String str, List list, List list2, List list3, List list4, j jVar, List list5) {
        super(str, list);
        List list6;
        this.f126311c = Collections.unmodifiableList(list2);
        this.f126312d = Collections.unmodifiableList(list3);
        this.f126313e = Collections.unmodifiableList(list4);
        this.f126314f = jVar;
        if (list5 != null) {
            list6 = Collections.unmodifiableList(list5);
        } else {
            list6 = null;
        }
        this.f126315g = list6;
    }

    public static a a(String str) {
        List singletonList = Collections.singletonList(C6226a.a(str));
        List emptyList = Collections.emptyList();
        return new a(null, Collections.emptyList(), singletonList, emptyList, emptyList, null, null);
    }
}
