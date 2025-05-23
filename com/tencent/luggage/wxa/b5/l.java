package com.tencent.luggage.wxa.b5;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class l implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<l> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final int f121864a;

    /* renamed from: b, reason: collision with root package name */
    public final String f121865b;

    /* renamed from: c, reason: collision with root package name */
    public final int f121866c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f121867d;

    /* renamed from: e, reason: collision with root package name */
    public final int f121868e;

    /* renamed from: f, reason: collision with root package name */
    public final String f121869f;

    /* renamed from: g, reason: collision with root package name */
    public final String f121870g;

    /* renamed from: h, reason: collision with root package name */
    public final com.tencent.luggage.wxa.fd.i f121871h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f121872i;

    /* renamed from: j, reason: collision with root package name */
    public final String f121873j;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final l createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new l(parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt(), parcel.readString(), parcel.readString(), (com.tencent.luggage.wxa.fd.i) parcel.readParcelable(l.class.getClassLoader()), parcel.readInt() != 0, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final l[] newArray(int i3) {
            return new l[i3];
        }
    }

    public l(int i3, String appId, int i16, boolean z16, int i17, String instanceId, String userName, com.tencent.luggage.wxa.fd.i initConfig, boolean z17, String stackTrace) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(instanceId, "instanceId");
        Intrinsics.checkNotNullParameter(userName, "userName");
        Intrinsics.checkNotNullParameter(initConfig, "initConfig");
        Intrinsics.checkNotNullParameter(stackTrace, "stackTrace");
        this.f121864a = i3;
        this.f121865b = appId;
        this.f121866c = i16;
        this.f121867d = z16;
        this.f121868e = i17;
        this.f121869f = instanceId;
        this.f121870g = userName;
        this.f121871h = initConfig;
        this.f121872i = z17;
        this.f121873j = stackTrace;
    }

    public final String a() {
        return this.f121865b;
    }

    public final com.tencent.luggage.wxa.fd.i b() {
        return this.f121871h;
    }

    public final String c() {
        return this.f121869f;
    }

    public final int d() {
        return this.f121864a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int e() {
        return this.f121866c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        if (this.f121864a == lVar.f121864a && Intrinsics.areEqual(this.f121865b, lVar.f121865b) && this.f121866c == lVar.f121866c && this.f121867d == lVar.f121867d && this.f121868e == lVar.f121868e && Intrinsics.areEqual(this.f121869f, lVar.f121869f) && Intrinsics.areEqual(this.f121870g, lVar.f121870g) && Intrinsics.areEqual(this.f121871h, lVar.f121871h) && this.f121872i == lVar.f121872i && Intrinsics.areEqual(this.f121873j, lVar.f121873j)) {
            return true;
        }
        return false;
    }

    public final boolean f() {
        return this.f121872i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.f121864a * 31) + this.f121865b.hashCode()) * 31) + this.f121866c) * 31;
        boolean z16 = this.f121867d;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int hashCode2 = (((((((((hashCode + i16) * 31) + this.f121868e) * 31) + this.f121869f.hashCode()) * 31) + this.f121870g.hashCode()) * 31) + this.f121871h.hashCode()) * 31;
        boolean z17 = this.f121872i;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return ((hashCode2 + i3) * 31) + this.f121873j.hashCode();
    }

    public String toString() {
        return "RuntimeInfo(processIndex=" + this.f121864a + ", appId=" + this.f121865b + ", versionType=" + this.f121866c + ", isGame=" + this.f121867d + ", appType=" + this.f121868e + ", instanceId=" + this.f121869f + ", userName=" + this.f121870g + ", initConfig=" + this.f121871h + ", isPersistentApp=" + this.f121872i + ", stackTrace=" + this.f121873j + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i3) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeInt(this.f121864a);
        out.writeString(this.f121865b);
        out.writeInt(this.f121866c);
        out.writeInt(this.f121867d ? 1 : 0);
        out.writeInt(this.f121868e);
        out.writeString(this.f121869f);
        out.writeString(this.f121870g);
        out.writeParcelable(this.f121871h, i3);
        out.writeInt(this.f121872i ? 1 : 0);
        out.writeString(this.f121873j);
    }
}
