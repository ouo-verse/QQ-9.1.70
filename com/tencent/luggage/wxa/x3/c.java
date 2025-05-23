package com.tencent.luggage.wxa.x3;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class c implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<c> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final int f144556a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f144557b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f144558c;

    /* renamed from: d, reason: collision with root package name */
    public final int f144559d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f144560e;

    /* renamed from: f, reason: collision with root package name */
    public final int f144561f;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final c createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new c(parcel.readInt(), parcel.createByteArray(), parcel.readInt() != 0, parcel.readInt(), parcel.readInt() != 0, parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final c[] newArray(int i3) {
            return new c[i3];
        }
    }

    public c(int i3, byte[] reportContent, boolean z16, int i16, boolean z17, int i17) {
        Intrinsics.checkNotNullParameter(reportContent, "reportContent");
        this.f144556a = i3;
        this.f144557b = reportContent;
        this.f144558c = z16;
        this.f144559d = i16;
        this.f144560e = z17;
        this.f144561f = i17;
    }

    public final boolean a() {
        return this.f144560e;
    }

    public final int b() {
        return this.f144556a;
    }

    public final byte[] c() {
        return this.f144557b;
    }

    public final boolean d() {
        return this.f144558c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int e() {
        return this.f144561f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (this.f144556a == cVar.f144556a && Intrinsics.areEqual(this.f144557b, cVar.f144557b) && this.f144558c == cVar.f144558c && this.f144559d == cVar.f144559d && this.f144560e == cVar.f144560e && this.f144561f == cVar.f144561f) {
            return true;
        }
        return false;
    }

    public final int f() {
        return this.f144559d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.f144556a * 31) + Arrays.hashCode(this.f144557b)) * 31;
        boolean z16 = this.f144558c;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int i17 = (((hashCode + i16) * 31) + this.f144559d) * 31;
        boolean z17 = this.f144560e;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return ((i17 + i3) * 31) + this.f144561f;
    }

    public String toString() {
        return "ReportLogData(logId=" + this.f144556a + ", reportContent=" + this.f144557b.length + ", reportNow=" + this.f144558c + ", type=" + this.f144559d + ", ignoreFreqCheck=" + this.f144560e + ", reportUinType=" + this.f144561f + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i3) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeInt(this.f144556a);
        out.writeByteArray(this.f144557b);
        out.writeInt(this.f144558c ? 1 : 0);
        out.writeInt(this.f144559d);
        out.writeInt(this.f144560e ? 1 : 0);
        out.writeInt(this.f144561f);
    }
}
