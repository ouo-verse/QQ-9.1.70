package com.tencent.luggage.wxa.gk;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.wxa.fn.c;
import com.tencent.luggage.wxa.hn.d1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b implements Parcelable {

    /* renamed from: a, reason: collision with root package name */
    public final String f126785a;

    /* renamed from: b, reason: collision with root package name */
    public final String f126786b;

    /* renamed from: c, reason: collision with root package name */
    public final String f126787c;

    /* renamed from: d, reason: collision with root package name */
    public final int f126788d;

    /* renamed from: e, reason: collision with root package name */
    public final int f126789e;

    /* renamed from: f, reason: collision with root package name */
    public final String f126790f;

    /* renamed from: g, reason: collision with root package name */
    public final String f126791g;

    /* renamed from: h, reason: collision with root package name */
    public static final a f126784h = new a(null);

    @NotNull
    public static final Parcelable.Creator<b> CREATOR = new C6247b();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final b a(d1 resp) {
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            String str7;
            Intrinsics.checkNotNullParameter(resp, "resp");
            c cVar = resp.f127445e;
            String str8 = null;
            if (cVar != null) {
                str = cVar.b("UTF-8");
            } else {
                str = null;
            }
            if (str == null) {
                str2 = "";
            } else {
                str2 = str;
            }
            c cVar2 = resp.f127447g;
            if (cVar2 != null) {
                str3 = cVar2.b("UTF-8");
            } else {
                str3 = null;
            }
            if (str3 == null) {
                str4 = "";
            } else {
                str4 = str3;
            }
            c cVar3 = resp.f127446f;
            if (cVar3 != null) {
                str5 = cVar3.b("UTF-8");
            } else {
                str5 = null;
            }
            if (str5 == null) {
                str6 = "";
            } else {
                str6 = str5;
            }
            int i3 = resp.f127448h;
            int i16 = resp.f127449i;
            c cVar4 = resp.f127450j;
            if (cVar4 != null) {
                str8 = cVar4.d();
            }
            if (str8 == null) {
                str7 = "";
            } else {
                str7 = str8;
            }
            return new b(str2, str4, str6, i3, i16, str7, null, 64, null);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.gk.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6247b implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final b createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new b(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final b[] newArray(int i3) {
            return new b[i3];
        }
    }

    public b(String appId, String pageTitle, String path, int i3, int i16, String nickName, String userName) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(pageTitle, "pageTitle");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(nickName, "nickName");
        Intrinsics.checkNotNullParameter(userName, "userName");
        this.f126785a = appId;
        this.f126786b = pageTitle;
        this.f126787c = path;
        this.f126788d = i3;
        this.f126789e = i16;
        this.f126790f = nickName;
        this.f126791g = userName;
    }

    public final String a() {
        return this.f126785a;
    }

    public final String b() {
        return this.f126790f;
    }

    public final String c() {
        return this.f126787c;
    }

    public final int d() {
        return this.f126788d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int e() {
        return this.f126789e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (Intrinsics.areEqual(this.f126785a, bVar.f126785a) && Intrinsics.areEqual(this.f126786b, bVar.f126786b) && Intrinsics.areEqual(this.f126787c, bVar.f126787c) && this.f126788d == bVar.f126788d && this.f126789e == bVar.f126789e && Intrinsics.areEqual(this.f126790f, bVar.f126790f) && Intrinsics.areEqual(this.f126791g, bVar.f126791g)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((this.f126785a.hashCode() * 31) + this.f126786b.hashCode()) * 31) + this.f126787c.hashCode()) * 31) + this.f126788d) * 31) + this.f126789e) * 31) + this.f126790f.hashCode()) * 31) + this.f126791g.hashCode();
    }

    public String toString() {
        return "WxaShortLinkInfo(appId='" + this.f126785a + "', pageTitle='" + this.f126786b + "', path='" + this.f126787c + "', version=" + this.f126788d + ", versionType=" + this.f126789e + ", nickName='" + this.f126790f + "', userName=" + this.f126791g + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i3) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.f126785a);
        out.writeString(this.f126786b);
        out.writeString(this.f126787c);
        out.writeInt(this.f126788d);
        out.writeInt(this.f126789e);
        out.writeString(this.f126790f);
        out.writeString(this.f126791g);
    }

    public /* synthetic */ b(String str, String str2, String str3, int i3, int i16, String str4, String str5, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, i3, i16, str4, (i17 & 64) != 0 ? "" : str5);
    }
}
