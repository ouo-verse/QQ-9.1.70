package com.tencent.luggage.wxa.w;

import android.util.SparseArray;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface v {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f143971a;

        /* renamed from: b, reason: collision with root package name */
        public final int f143972b;

        /* renamed from: c, reason: collision with root package name */
        public final byte[] f143973c;

        public a(String str, int i3, byte[] bArr) {
            this.f143971a = str;
            this.f143972b = i3;
            this.f143973c = bArr;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f143974a;

        /* renamed from: b, reason: collision with root package name */
        public final String f143975b;

        /* renamed from: c, reason: collision with root package name */
        public final List f143976c;

        /* renamed from: d, reason: collision with root package name */
        public final byte[] f143977d;

        public b(int i3, String str, List list, byte[] bArr) {
            List unmodifiableList;
            this.f143974a = i3;
            this.f143975b = str;
            if (list == null) {
                unmodifiableList = Collections.emptyList();
            } else {
                unmodifiableList = Collections.unmodifiableList(list);
            }
            this.f143976c = unmodifiableList;
            this.f143977d = bArr;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface c {
        SparseArray a();

        v a(int i3, b bVar);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final String f143978a;

        /* renamed from: b, reason: collision with root package name */
        public final int f143979b;

        /* renamed from: c, reason: collision with root package name */
        public final int f143980c;

        /* renamed from: d, reason: collision with root package name */
        public int f143981d;

        /* renamed from: e, reason: collision with root package name */
        public String f143982e;

        public d(int i3, int i16) {
            this(Integer.MIN_VALUE, i3, i16);
        }

        public void a() {
            int i3;
            int i16 = this.f143981d;
            if (i16 == Integer.MIN_VALUE) {
                i3 = this.f143979b;
            } else {
                i3 = i16 + this.f143980c;
            }
            this.f143981d = i3;
            this.f143982e = this.f143978a + this.f143981d;
        }

        public String b() {
            d();
            return this.f143982e;
        }

        public int c() {
            d();
            return this.f143981d;
        }

        public final void d() {
            if (this.f143981d != Integer.MIN_VALUE) {
            } else {
                throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
            }
        }

        public d(int i3, int i16, int i17) {
            String str;
            if (i3 != Integer.MIN_VALUE) {
                str = i3 + "/";
            } else {
                str = "";
            }
            this.f143978a = str;
            this.f143979b = i16;
            this.f143980c = i17;
            this.f143981d = Integer.MIN_VALUE;
        }
    }

    void a();

    void a(com.tencent.luggage.wxa.n0.l lVar, boolean z16);

    void a(com.tencent.luggage.wxa.n0.s sVar, com.tencent.luggage.wxa.q.f fVar, d dVar);
}
