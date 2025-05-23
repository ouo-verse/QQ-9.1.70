package com.tencent.luggage.wxa.j4;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.wxa.fd.i0;
import com.tencent.luggage.wxa.fd.j0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class e implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<e> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public boolean f130815a;

    /* renamed from: b, reason: collision with root package name */
    public int f130816b;

    /* renamed from: c, reason: collision with root package name */
    public j0 f130817c;

    /* renamed from: d, reason: collision with root package name */
    public String f130818d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f130819e;

    /* renamed from: f, reason: collision with root package name */
    public i0 f130820f;

    /* renamed from: g, reason: collision with root package name */
    public i0 f130821g;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final e createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new e(parcel.readInt() != 0, parcel.readInt(), n.f130857a.create(parcel), parcel.readString(), parcel.readInt() != 0, i0.valueOf(parcel.readString()), i0.valueOf(parcel.readString()));
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final e[] newArray(int i3) {
            return new e[i3];
        }
    }

    public e(boolean z16, int i3, j0 j0Var, String str, boolean z17, i0 enterAnimation, i0 exitAnimation) {
        Intrinsics.checkNotNullParameter(enterAnimation, "enterAnimation");
        Intrinsics.checkNotNullParameter(exitAnimation, "exitAnimation");
        this.f130815a = z16;
        this.f130816b = i3;
        this.f130817c = j0Var;
        this.f130818d = str;
        this.f130819e = z17;
        this.f130820f = enterAnimation;
        this.f130821g = exitAnimation;
    }

    public final i0 a() {
        return this.f130821g;
    }

    public final String b() {
        return this.f130818d;
    }

    public final j0 c() {
        return this.f130817c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (this.f130815a == eVar.f130815a && this.f130816b == eVar.f130816b && this.f130817c == eVar.f130817c && Intrinsics.areEqual(this.f130818d, eVar.f130818d) && this.f130819e == eVar.f130819e && this.f130820f == eVar.f130820f && this.f130821g == eVar.f130821g) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    public int hashCode() {
        int hashCode;
        boolean z16 = this.f130815a;
        int i3 = 1;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i16 = ((r06 * 31) + this.f130816b) * 31;
        j0 j0Var = this.f130817c;
        int i17 = 0;
        if (j0Var == null) {
            hashCode = 0;
        } else {
            hashCode = j0Var.hashCode();
        }
        int i18 = (i16 + hashCode) * 31;
        String str = this.f130818d;
        if (str != null) {
            i17 = str.hashCode();
        }
        int i19 = (i18 + i17) * 31;
        boolean z17 = this.f130819e;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return ((((i19 + i3) * 31) + this.f130820f.hashCode()) * 31) + this.f130821g.hashCode();
    }

    public String toString() {
        boolean z16;
        String str;
        String sb5;
        StringBuilder sb6 = new StringBuilder();
        sb6.append("AppBrandInitWindowConfig(");
        if (this.f130815a) {
            sb5 = "navigationBarColor:" + this.f130816b + ", ";
        } else {
            StringBuilder sb7 = new StringBuilder();
            sb7.append("windowOpacity:");
            sb7.append(this.f130817c);
            sb7.append(", ");
            String str2 = this.f130818d;
            if (str2 != null && str2.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                str = "windowBackgroundImageFilePath:" + this.f130818d + ", ";
            } else {
                str = ")";
            }
            sb7.append(str);
            sb5 = sb7.toString();
        }
        sb6.append(sb5);
        return sb6.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i3) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeInt(this.f130815a ? 1 : 0);
        out.writeInt(this.f130816b);
        n.f130857a.write(this.f130817c, out, i3);
        out.writeString(this.f130818d);
        out.writeInt(this.f130819e ? 1 : 0);
        out.writeString(this.f130820f.name());
        out.writeString(this.f130821g.name());
    }

    public final void a(i0 i0Var) {
        Intrinsics.checkNotNullParameter(i0Var, "<set-?>");
        this.f130821g = i0Var;
    }

    public /* synthetic */ e(boolean z16, int i3, j0 j0Var, String str, boolean z17, i0 i0Var, i0 i0Var2, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? false : z16, (i16 & 2) != 0 ? 0 : i3, (i16 & 4) != 0 ? j0.UNKNOWN : j0Var, (i16 & 8) != 0 ? null : str, (i16 & 16) == 0 ? z17 : false, (i16 & 32) != 0 ? i0.DEFAULT : i0Var, (i16 & 64) != 0 ? i0.DEFAULT : i0Var2);
    }
}
