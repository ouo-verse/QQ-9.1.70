package com.tencent.luggage.wxa.ii;

import com.tencent.luggage.wxa.hn.k1;
import com.tencent.luggage.wxa.tn.w0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface l {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Comparable {

        /* renamed from: k, reason: collision with root package name */
        public static final C6315a f130554k = new C6315a(null);

        /* renamed from: a, reason: collision with root package name */
        public String f130555a = "";

        /* renamed from: b, reason: collision with root package name */
        public String f130556b;

        /* renamed from: c, reason: collision with root package name */
        public int f130557c;

        /* renamed from: d, reason: collision with root package name */
        public int f130558d;

        /* renamed from: e, reason: collision with root package name */
        public int f130559e;

        /* renamed from: f, reason: collision with root package name */
        public String f130560f;

        /* renamed from: g, reason: collision with root package name */
        public int f130561g;

        /* renamed from: h, reason: collision with root package name */
        public int f130562h;

        /* renamed from: i, reason: collision with root package name */
        public int f130563i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f130564j;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.ii.l$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6315a {
            public C6315a() {
            }

            public /* synthetic */ C6315a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public final String a() {
            return this.f130555a;
        }

        public final void b(String str) {
            this.f130556b = str;
        }

        public final void c(String str) {
            this.f130560f = str;
        }

        public final void d(int i3) {
            this.f130558d = i3;
        }

        public final String e() {
            return this.f130556b;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a) || (this != obj && hashCode() != ((a) obj).hashCode())) {
                return false;
            }
            return true;
        }

        public final boolean f() {
            return this.f130564j;
        }

        public final int g() {
            return this.f130557c;
        }

        public final int h() {
            return this.f130561g;
        }

        public int hashCode() {
            return toString().hashCode();
        }

        public final String i() {
            return this.f130560f;
        }

        public final int j() {
            return this.f130558d;
        }

        public String toString() {
            return "LocalUnifiedGetDownloadUrlRequest(appId='" + this.f130555a + "', moduleName=" + this.f130556b + ", packageType=" + this.f130557c + ", versionType=" + this.f130558d + ", appVersion=" + this.f130559e + ", supportEncryptVersion=" + this.f130561g + ", localPkgVersion=" + this.f130562h + ", localPkgEncryptVersion=" + this.f130563i + ", needLatestVersion=" + this.f130564j + ')';
        }

        public final void a(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.f130555a = str;
        }

        public final void b(int i3) {
            this.f130557c = i3;
        }

        public final void c(int i3) {
            this.f130561g = i3;
        }

        public final int d() {
            return this.f130562h;
        }

        public final void a(int i3) {
            this.f130559e = i3;
        }

        public final int b() {
            return this.f130559e;
        }

        public final int c() {
            return this.f130563i;
        }

        public final void a(boolean z16) {
            this.f130564j = z16;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a other) {
            int compare;
            Intrinsics.checkNotNullParameter(other, "other");
            if (!Intrinsics.areEqual(this.f130555a, other.f130555a)) {
                compare = this.f130555a.compareTo(other.f130555a);
            } else if (!Intrinsics.areEqual(w0.d(this.f130556b), w0.d(other.f130556b))) {
                String d16 = w0.d(this.f130556b);
                String d17 = w0.d(other.f130556b);
                Intrinsics.checkNotNullExpressionValue(d17, "nullAsNil(other.moduleName)");
                compare = d16.compareTo(d17);
            } else {
                int i3 = this.f130557c;
                int i16 = other.f130557c;
                if (i3 != i16) {
                    compare = Intrinsics.compare(i3, i16);
                } else {
                    int i17 = this.f130558d;
                    int i18 = other.f130558d;
                    if (i17 != i18) {
                        compare = Intrinsics.compare(i17, i18);
                    } else {
                        boolean z16 = this.f130564j;
                        boolean z17 = other.f130564j;
                        if (z16 != z17) {
                            compare = Intrinsics.compare(z16 ? 1 : 0, z17 ? 1 : 0);
                        } else {
                            int i19 = this.f130559e;
                            int i26 = other.f130559e;
                            if (i19 != i26) {
                                compare = Intrinsics.compare(i19, i26);
                            } else {
                                int i27 = this.f130561g;
                                int i28 = other.f130561g;
                                if (i27 != i28) {
                                    compare = Intrinsics.compare(i27, i28);
                                } else {
                                    int i29 = this.f130562h;
                                    int i36 = other.f130562h;
                                    if (i29 != i36) {
                                        compare = Intrinsics.compare(i29, i36);
                                    } else {
                                        int i37 = this.f130563i;
                                        int i38 = other.f130563i;
                                        compare = i37 != i38 ? Intrinsics.compare(i37, i38) : 0;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            com.tencent.luggage.wxa.tn.w.d("IGetDownloadUrlCgiExecutor.LocalUnifiedGetDownloadUrlRequest", "request.compareTo=" + compare + ", this=" + this + ", other=" + other);
            return compare;
        }
    }

    void a(a aVar, Function1 function1, Function1 function12, int i3, k1 k1Var);
}
