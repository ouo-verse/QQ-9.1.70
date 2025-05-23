package com.tencent.luggage.wxa.g0;

import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b extends c {

    /* renamed from: c, reason: collision with root package name */
    public final int f126318c;

    /* renamed from: d, reason: collision with root package name */
    public final long f126319d;

    /* renamed from: e, reason: collision with root package name */
    public final long f126320e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f126321f;

    /* renamed from: g, reason: collision with root package name */
    public final int f126322g;

    /* renamed from: h, reason: collision with root package name */
    public final int f126323h;

    /* renamed from: i, reason: collision with root package name */
    public final int f126324i;

    /* renamed from: j, reason: collision with root package name */
    public final long f126325j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f126326k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f126327l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f126328m;

    /* renamed from: n, reason: collision with root package name */
    public final a f126329n;

    /* renamed from: o, reason: collision with root package name */
    public final List f126330o;

    /* renamed from: p, reason: collision with root package name */
    public final long f126331p;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Comparable {

        /* renamed from: a, reason: collision with root package name */
        public final String f126332a;

        /* renamed from: b, reason: collision with root package name */
        public final long f126333b;

        /* renamed from: c, reason: collision with root package name */
        public final int f126334c;

        /* renamed from: d, reason: collision with root package name */
        public final long f126335d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f126336e;

        /* renamed from: f, reason: collision with root package name */
        public final String f126337f;

        /* renamed from: g, reason: collision with root package name */
        public final String f126338g;

        /* renamed from: h, reason: collision with root package name */
        public final long f126339h;

        /* renamed from: i, reason: collision with root package name */
        public final long f126340i;

        public a(String str, long j3, long j16) {
            this(str, 0L, -1, -9223372036854775807L, false, null, null, j3, j16);
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(Long l3) {
            if (this.f126335d > l3.longValue()) {
                return 1;
            }
            if (this.f126335d < l3.longValue()) {
                return -1;
            }
            return 0;
        }

        public a(String str, long j3, int i3, long j16, boolean z16, String str2, String str3, long j17, long j18) {
            this.f126332a = str;
            this.f126333b = j3;
            this.f126334c = i3;
            this.f126335d = j16;
            this.f126336e = z16;
            this.f126337f = str2;
            this.f126338g = str3;
            this.f126339h = j17;
            this.f126340i = j18;
        }
    }

    public b(int i3, String str, List list, long j3, long j16, boolean z16, int i16, int i17, int i18, long j17, boolean z17, boolean z18, boolean z19, a aVar, List list2) {
        super(str, list);
        long j18;
        this.f126318c = i3;
        this.f126320e = j16;
        this.f126321f = z16;
        this.f126322g = i16;
        this.f126323h = i17;
        this.f126324i = i18;
        this.f126325j = j17;
        this.f126326k = z17;
        this.f126327l = z18;
        this.f126328m = z19;
        this.f126329n = aVar;
        this.f126330o = Collections.unmodifiableList(list2);
        if (!list2.isEmpty()) {
            a aVar2 = (a) list2.get(list2.size() - 1);
            this.f126331p = aVar2.f126335d + aVar2.f126333b;
        } else {
            this.f126331p = 0L;
        }
        if (j3 == -9223372036854775807L) {
            j18 = -9223372036854775807L;
        } else {
            j18 = j3 >= 0 ? j3 : this.f126331p + j3;
        }
        this.f126319d = j18;
    }

    public boolean a(b bVar) {
        int i3;
        int i16;
        if (bVar == null || (i3 = this.f126323h) > (i16 = bVar.f126323h)) {
            return true;
        }
        if (i3 < i16) {
            return false;
        }
        int size = this.f126330o.size();
        int size2 = bVar.f126330o.size();
        if (size <= size2) {
            return size == size2 && this.f126327l && !bVar.f126327l;
        }
        return true;
    }

    public long b() {
        return this.f126320e + this.f126331p;
    }

    public b a(long j3, int i3) {
        return new b(this.f126318c, this.f126341a, this.f126342b, this.f126319d, j3, true, i3, this.f126323h, this.f126324i, this.f126325j, this.f126326k, this.f126327l, this.f126328m, this.f126329n, this.f126330o);
    }

    public b a() {
        return this.f126327l ? this : new b(this.f126318c, this.f126341a, this.f126342b, this.f126319d, this.f126320e, this.f126321f, this.f126322g, this.f126323h, this.f126324i, this.f126325j, this.f126326k, true, this.f126328m, this.f126329n, this.f126330o);
    }
}
