package com.tencent.luggage.wxa.d0;

import com.tencent.luggage.wxa.m.u;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface h {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {
        void a(u uVar, Object obj);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {

        /* renamed from: d, reason: collision with root package name */
        public static final b f123994d = new b(-1, -1, -1);

        /* renamed from: a, reason: collision with root package name */
        public final int f123995a;

        /* renamed from: b, reason: collision with root package name */
        public final int f123996b;

        /* renamed from: c, reason: collision with root package name */
        public final int f123997c;

        public b(int i3) {
            this(i3, -1, -1);
        }

        public b a(int i3) {
            return this.f123995a == i3 ? this : new b(i3, this.f123996b, this.f123997c);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f123995a == bVar.f123995a && this.f123996b == bVar.f123996b && this.f123997c == bVar.f123997c) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return ((((this.f123995a + 527) * 31) + this.f123996b) * 31) + this.f123997c;
        }

        public b(int i3, int i16, int i17) {
            this.f123995a = i3;
            this.f123996b = i16;
            this.f123997c = i17;
        }

        public boolean a() {
            return this.f123996b != -1;
        }
    }

    g a(b bVar, com.tencent.luggage.wxa.l0.b bVar2);

    void a();

    void a(g gVar);

    void a(com.tencent.luggage.wxa.m.e eVar, boolean z16, a aVar);

    void b();
}
