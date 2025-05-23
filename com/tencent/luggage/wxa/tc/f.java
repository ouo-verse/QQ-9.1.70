package com.tencent.luggage.wxa.tc;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.wxa.ka.r;
import com.tencent.luggage.wxa.tn.z;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class f implements j {

    /* renamed from: a, reason: collision with root package name */
    public static final f f141222a = new f();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Parcelable {

        @NotNull
        public static final Parcelable.Creator<a> CREATOR = new C6749a();

        /* renamed from: a, reason: collision with root package name */
        public final String f141223a;

        /* renamed from: b, reason: collision with root package name */
        public final int f141224b;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.tc.f$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6749a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final a createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new a(parcel.readString(), parcel.readInt());
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final a[] newArray(int i3) {
                return new a[i3];
            }
        }

        public a(String appId, int i3) {
            Intrinsics.checkNotNullParameter(appId, "appId");
            this.f141223a = appId;
            this.f141224b = i3;
        }

        public final String a() {
            return this.f141223a;
        }

        public final int b() {
            return this.f141224b;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (Intrinsics.areEqual(this.f141223a, aVar.f141223a) && this.f141224b == aVar.f141224b) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.f141223a.hashCode() * 31) + this.f141224b;
        }

        public String toString() {
            return "ByAppIdQueryArgs(appId=" + this.f141223a + ", fetchType=" + this.f141224b + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i3) {
            Intrinsics.checkNotNullParameter(out, "out");
            out.writeString(this.f141223a);
            out.writeInt(this.f141224b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements Parcelable {

        @NotNull
        public static final Parcelable.Creator<b> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public final String f141225a;

        /* renamed from: b, reason: collision with root package name */
        public final int f141226b;

        /* renamed from: c, reason: collision with root package name */
        public final String f141227c;

        /* renamed from: d, reason: collision with root package name */
        public final String f141228d;

        /* renamed from: e, reason: collision with root package name */
        public final String f141229e;

        /* renamed from: f, reason: collision with root package name */
        public final int f141230f;

        /* renamed from: g, reason: collision with root package name */
        public final long f141231g;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final b createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new b(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readLong());
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final b[] newArray(int i3) {
                return new b[i3];
            }
        }

        public b(String str, int i3, String str2, String str3, String str4, int i16, long j3) {
            this.f141225a = str;
            this.f141226b = i3;
            this.f141227c = str2;
            this.f141228d = str3;
            this.f141229e = str4;
            this.f141230f = i16;
            this.f141231g = j3;
        }

        public final String a() {
            return this.f141225a;
        }

        public final int b() {
            return this.f141226b;
        }

        public final String c() {
            return this.f141227c;
        }

        public final String d() {
            return this.f141228d;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public final String e() {
            return this.f141229e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (Intrinsics.areEqual(this.f141225a, bVar.f141225a) && this.f141226b == bVar.f141226b && Intrinsics.areEqual(this.f141227c, bVar.f141227c) && Intrinsics.areEqual(this.f141228d, bVar.f141228d) && Intrinsics.areEqual(this.f141229e, bVar.f141229e) && this.f141230f == bVar.f141230f && this.f141231g == bVar.f141231g) {
                return true;
            }
            return false;
        }

        public final int f() {
            return this.f141230f;
        }

        public final long g() {
            return this.f141231g;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            int hashCode3;
            String str = this.f141225a;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = ((hashCode * 31) + this.f141226b) * 31;
            String str2 = this.f141227c;
            if (str2 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str2.hashCode();
            }
            int i17 = (i16 + hashCode2) * 31;
            String str3 = this.f141228d;
            if (str3 == null) {
                hashCode3 = 0;
            } else {
                hashCode3 = str3.hashCode();
            }
            int i18 = (i17 + hashCode3) * 31;
            String str4 = this.f141229e;
            if (str4 != null) {
                i3 = str4.hashCode();
            }
            return ((((i18 + i3) * 31) + this.f141230f) * 31) + androidx.fragment.app.a.a(this.f141231g);
        }

        public String toString() {
            return "SetDataArgs(username=" + this.f141225a + ", fetchType=" + this.f141226b + ", data=" + this.f141227c + ", path=" + this.f141228d + ", query=" + this.f141229e + ", scene=" + this.f141230f + ", time=" + this.f141231g + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i3) {
            Intrinsics.checkNotNullParameter(out, "out");
            out.writeString(this.f141225a);
            out.writeInt(this.f141226b);
            out.writeString(this.f141227c);
            out.writeString(this.f141228d);
            out.writeString(this.f141229e);
            out.writeInt(this.f141230f);
            out.writeLong(this.f141231g);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/tencent/luggage/wxa/tc/f$a;", "it", "Lcom/tencent/luggage/wxa/tc/c;", "a", "(Lcom/tencent/luggage/wxa/tc/f$a;)Lcom/tencent/luggage/wxa/tc/c;"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes8.dex */
    public static final class c<InputType, ResultType> implements r {

        /* renamed from: a, reason: collision with root package name */
        public static final c f141232a = new c();

        @Override // com.tencent.luggage.wxa.ka.r
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.tencent.luggage.wxa.tc.c invoke(a aVar) {
            if (aVar == null) {
                return null;
            }
            String a16 = aVar.a();
            int b16 = aVar.b();
            e eVar = (e) com.tencent.luggage.wxa.c6.b.a(e.class);
            if (eVar == null) {
                return null;
            }
            return eVar.c(a16, b16);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/tencent/luggage/wxa/tc/f$b;", "it", "Lcom/tencent/luggage/wxa/va/a;", "a", "(Lcom/tencent/luggage/wxa/tc/f$b;)Lcom/tencent/luggage/wxa/va/a;"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes8.dex */
    public static final class d<InputType, ResultType> implements r {

        /* renamed from: a, reason: collision with root package name */
        public static final d f141233a = new d();

        @Override // com.tencent.luggage.wxa.ka.r
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.tencent.luggage.wxa.va.a invoke(b bVar) {
            boolean z16 = false;
            if (bVar == null) {
                return new com.tencent.luggage.wxa.va.a(false);
            }
            String a16 = bVar.a();
            int b16 = bVar.b();
            String c16 = bVar.c();
            String d16 = bVar.d();
            String e16 = bVar.e();
            int f16 = bVar.f();
            long g16 = bVar.g();
            e eVar = (e) com.tencent.luggage.wxa.c6.b.a(e.class);
            if (eVar != null) {
                z16 = eVar.a(a16, b16, c16, d16, e16, f16, g16);
            }
            return new com.tencent.luggage.wxa.va.a(z16);
        }
    }

    @Override // com.tencent.luggage.wxa.tc.j
    public boolean a(String str, int i3, String str2, String str3, String str4, int i16, long j3) {
        boolean z16;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return false;
        }
        if (z.m()) {
            e eVar = (e) com.tencent.luggage.wxa.c6.b.a(e.class);
            if (eVar == null) {
                return false;
            }
            return eVar.a(str, i3, str2, str3, str4, i16, j3);
        }
        String g16 = z.g();
        Intrinsics.checkNotNullExpressionValue(g16, "getMainProcessName()");
        com.tencent.luggage.wxa.va.a aVar = (com.tencent.luggage.wxa.va.a) com.tencent.luggage.wxa.ka.b.a(g16, new b(str, i3, str2, str3, str4, i16, j3), d.f141233a);
        if (aVar == null) {
            return false;
        }
        return aVar.f143312a;
    }

    @Override // com.tencent.luggage.wxa.tc.j
    public com.tencent.luggage.wxa.tc.c c(String str, int i3) {
        boolean z16;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return null;
        }
        if (z.m()) {
            e eVar = (e) com.tencent.luggage.wxa.c6.b.a(e.class);
            if (eVar == null) {
                return null;
            }
            return eVar.c(str, i3);
        }
        String g16 = z.g();
        Intrinsics.checkNotNullExpressionValue(g16, "getMainProcessName()");
        return (com.tencent.luggage.wxa.tc.c) com.tencent.luggage.wxa.ka.b.a(g16, new a(str, i3), c.f141232a);
    }
}
