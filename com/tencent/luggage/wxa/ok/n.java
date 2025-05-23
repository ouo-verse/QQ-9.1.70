package com.tencent.luggage.wxa.ok;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface n extends com.tencent.luggage.wxa.h1.b {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f136605a;

        /* renamed from: b, reason: collision with root package name */
        public final int f136606b;

        /* renamed from: c, reason: collision with root package name */
        public final int f136607c;

        /* renamed from: d, reason: collision with root package name */
        public final int f136608d;

        public a(int i3, int i16, int i17, int i18) {
            this.f136605a = i3;
            this.f136606b = i16;
            this.f136607c = i17;
            this.f136608d = i18;
        }

        public final int a() {
            return this.f136608d;
        }

        public final int b() {
            return this.f136605a;
        }

        public final int c() {
            return this.f136607c;
        }

        public final int d() {
            return this.f136606b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f136605a == aVar.f136605a && this.f136606b == aVar.f136606b && this.f136607c == aVar.f136607c && this.f136608d == aVar.f136608d) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((((this.f136605a * 31) + this.f136606b) * 31) + this.f136607c) * 31) + this.f136608d;
        }

        public String toString() {
            return "Padding(left=" + this.f136605a + ", top=" + this.f136606b + ", right=" + this.f136607c + ", bottom=" + this.f136608d + ')';
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f136609a;

        /* renamed from: b, reason: collision with root package name */
        public final int f136610b;

        public b(int i3, int i16) {
            this.f136609a = i3;
            this.f136610b = i16;
        }

        public final int a() {
            return this.f136609a;
        }

        public final int b() {
            return this.f136610b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f136609a == bVar.f136609a && this.f136610b == bVar.f136610b) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.f136609a * 31) + this.f136610b;
        }

        public String toString() {
            return "Size(width=" + this.f136609a + ", height=" + this.f136610b + ')';
        }
    }

    b N();

    a W();

    int a(com.tencent.luggage.wxa.ic.l lVar);
}
