package com.tencent.luggage.wxa.n3;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface q extends com.tencent.luggage.wxa.eo.c {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Parcelable {

        @NotNull
        public static final Parcelable.Creator<a> CREATOR = new C6495a();

        /* renamed from: a, reason: collision with root package name */
        public String f135242a;

        /* renamed from: b, reason: collision with root package name */
        public String f135243b;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.n3.q$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6495a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final a createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new a(parcel.readString(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final a[] newArray(int i3) {
                return new a[i3];
            }
        }

        public a(String str, String str2) {
            this.f135242a = str;
            this.f135243b = str2;
        }

        public final boolean a() {
            boolean z16;
            String str = this.f135243b;
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            return !z16;
        }

        public final String b() {
            return this.f135243b;
        }

        public final String c() {
            return this.f135242a;
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
            if (Intrinsics.areEqual(this.f135242a, aVar.f135242a) && Intrinsics.areEqual(this.f135243b, aVar.f135243b)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            String str = this.f135242a;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = hashCode * 31;
            String str2 = this.f135243b;
            if (str2 != null) {
                i3 = str2.hashCode();
            }
            return i16 + i3;
        }

        public String toString() {
            return "AlertParams(alertTitle=" + this.f135242a + ", alertMsg=" + this.f135243b + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i3) {
            Intrinsics.checkNotNullParameter(out, "out");
            out.writeString(this.f135242a);
            out.writeString(this.f135243b);
        }
    }

    void a(Context context, a aVar);
}
