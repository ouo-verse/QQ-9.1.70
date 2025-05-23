package com.tencent.mapsdk.internal;

import com.tencent.map.tools.json.annotation.Json;
import com.tencent.mapsdk.shell.events.ReportEvent;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class hd extends hj {

    /* renamed from: a, reason: collision with root package name */
    @Json(name = "loadSuccess")
    private boolean f148630a;

    /* renamed from: b, reason: collision with root package name */
    @Json(name = "loadSuccessTime")
    private long f148631b;

    /* renamed from: c, reason: collision with root package name */
    @Json(name = "firstLoadTime")
    private long f148632c;

    /* renamed from: d, reason: collision with root package name */
    @Json(name = "configUpdate")
    private b f148633d;

    /* renamed from: e, reason: collision with root package name */
    @Json(name = "tileErrors")
    private Set<e> f148634e;

    /* renamed from: f, reason: collision with root package name */
    @Json(name = "configError")
    private a f148635f;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class a extends hj {

        /* renamed from: a, reason: collision with root package name */
        @Json(name = "failUpdates")
        Set<c> f148636a;

        /* renamed from: b, reason: collision with root package name */
        @Json(name = "missFiles")
        Set<d> f148637b;

        public a() {
        }

        a(long j3) {
            super(j3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class b extends hj {

        /* renamed from: a, reason: collision with root package name */
        @Json(name = "success")
        boolean f148638a;

        /* renamed from: b, reason: collision with root package name */
        @Json(name = "loadBeginTime")
        long f148639b;

        public b() {
            this.f148638a = false;
            this.f148639b = 0L;
        }

        b(long j3) {
            super(j3);
            this.f148638a = false;
            this.f148639b = 0L;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class c extends hj {

        /* renamed from: a, reason: collision with root package name */
        @Json(name = "name")
        public String f148640a;

        /* renamed from: b, reason: collision with root package name */
        @Json(name = "time")
        public long f148641b;

        /* renamed from: c, reason: collision with root package name */
        @Json(name = "expectMd5")
        public String f148642c;

        /* renamed from: d, reason: collision with root package name */
        @Json(name = "actualMd5")
        public String f148643d;

        /* renamed from: e, reason: collision with root package name */
        @Json(name = "localVer")
        public int f148644e;

        /* renamed from: f, reason: collision with root package name */
        @Json(name = "netError")
        public int f148645f;

        public c() {
            this(0L);
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            return hs.a(this.f148640a, ((c) obj).f148640a);
        }

        public final int hashCode() {
            String str = this.f148640a;
            if (str == null) {
                return super.hashCode();
            }
            return str.hashCode();
        }

        c(long j3) {
            super(j3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class d extends hj {

        /* renamed from: a, reason: collision with root package name */
        @Json(name = "name")
        String f148646a;

        /* renamed from: b, reason: collision with root package name */
        @Json(name = "time")
        long f148647b;

        public d() {
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            return hs.a(this.f148646a, ((d) obj).f148646a);
        }

        public final int hashCode() {
            String str = this.f148646a;
            if (str == null) {
                return super.hashCode();
            }
            return str.hashCode();
        }

        d(long j3) {
            super(j3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class e extends hj {

        /* renamed from: a, reason: collision with root package name */
        @Json(name = "time")
        long f148648a;

        /* renamed from: b, reason: collision with root package name */
        @Json(name = "tid")
        String f148649b;

        /* renamed from: c, reason: collision with root package name */
        @Json(name = "netError")
        int f148650c;

        public e() {
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof e)) {
                return false;
            }
            return hs.a(this.f148649b, ((e) obj).f148649b);
        }

        public final int hashCode() {
            String str = this.f148649b;
            if (str == null) {
                return super.hashCode();
            }
            return str.hashCode();
        }

        e(long j3) {
            super(j3);
        }
    }

    public hd() {
        this.f148630a = false;
        this.f148631b = 0L;
        this.f148632c = 0L;
    }

    public final void a(boolean z16, long j3) {
        this.f148630a = z16;
        if (this.f148632c > 0) {
            this.f148631b = j3 - this.f148681g;
        } else {
            this.f148632c = j3 - this.f148681g;
        }
        this.f148631b = j3;
        HashMap hashMap = new HashMap();
        hashMap.put("success", String.valueOf(z16));
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.f148681g);
        hashMap.put("startTime", sb5.toString());
        hashMap.put("endTime", String.valueOf(j3));
        StringBuilder sb6 = new StringBuilder();
        sb6.append(this.f148631b);
        hashMap.put("duration", sb6.toString());
        StringBuilder sb7 = new StringBuilder();
        sb7.append(this.f148632c);
        hashMap.put("firstDuration", sb7.toString());
        u.a();
        new ReportEvent("mapload", hashMap);
    }

    public final void b(boolean z16, long j3) {
        b bVar = new b(t());
        this.f148633d = bVar;
        bVar.f148638a = z16;
        long j16 = this.f148681g;
        if (j3 - j16 > 0) {
            bVar.f148639b = j3 - j16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public hd(long j3) {
        super(j3);
        this.f148630a = false;
        this.f148631b = 0L;
        this.f148632c = 0L;
    }

    public final void a(long j3, String str, int i3) {
        if (this.f148634e == null) {
            this.f148634e = new CopyOnWriteArraySet();
        }
        if (this.f148634e.size() > 9) {
            return;
        }
        e eVar = new e(j3);
        eVar.f148648a = j3 - this.f148681g;
        eVar.f148649b = str;
        eVar.f148650c = i3;
        this.f148634e.add(eVar);
        HashMap hashMap = new HashMap();
        hashMap.put("tid", str);
        hashMap.put("netError", String.valueOf(i3));
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.f148681g);
        hashMap.put("startTime", sb5.toString());
        hashMap.put("endTime", String.valueOf(j3));
        u.a();
        new ReportEvent("mapload-tile", hashMap);
    }

    public final void a(c cVar) {
        if (this.f148635f == null) {
            this.f148635f = new a(t());
        }
        a aVar = this.f148635f;
        if (aVar.f148636a == null) {
            aVar.f148636a = new CopyOnWriteArraySet();
        }
        if (this.f148635f.f148636a.size() > 9) {
            return;
        }
        this.f148635f.f148636a.add(cVar);
        HashMap hashMap = new HashMap();
        hashMap.put("name", cVar.f148640a);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(cVar.f148644e);
        hashMap.put("localVer", sb5.toString());
        StringBuilder sb6 = new StringBuilder();
        sb6.append(cVar.f148645f);
        hashMap.put("netError", sb6.toString());
        hashMap.put("expectMd5", cVar.f148642c);
        hashMap.put("actualMd5", cVar.f148643d);
        StringBuilder sb7 = new StringBuilder();
        sb7.append(this.f148681g);
        hashMap.put("startTime", sb7.toString());
        StringBuilder sb8 = new StringBuilder();
        sb8.append(this.f148681g);
        sb8.append(cVar.f148641b);
        hashMap.put("endTime", sb8.toString());
        u.a();
        new ReportEvent("mapload-configfile", hashMap);
    }

    public final void a(long j3, String str) {
        if (this.f148635f == null) {
            this.f148635f = new a(t());
        }
        a aVar = this.f148635f;
        if (aVar.f148637b == null) {
            aVar.f148637b = new CopyOnWriteArraySet();
        }
        if (this.f148635f.f148637b.size() > 9) {
            return;
        }
        d dVar = new d(this.f148681g);
        dVar.f148647b = j3 - this.f148681g;
        dVar.f148646a = str;
        this.f148635f.f148637b.add(dVar);
        HashMap hashMap = new HashMap();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.f148681g);
        hashMap.put("startTime", sb5.toString());
        hashMap.put("endTime", String.valueOf(j3));
        u.a();
        new ReportEvent("mapload-missfile", hashMap);
    }
}
