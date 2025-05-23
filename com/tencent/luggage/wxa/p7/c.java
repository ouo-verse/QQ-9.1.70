package com.tencent.luggage.wxa.p7;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.wxa.ka.r;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u0005\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0096\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/luggage/wxa/p7/c;", "Lcom/tencent/luggage/wxa/ka/r;", "Lcom/tencent/luggage/wxa/p7/c$a;", "Lcom/tencent/luggage/wxa/va/a;", "data", "a", "<init>", "()V", "luggage-standalone-open-runtime-sdk_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final class c implements r {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Parcelable {

        @NotNull
        public static final Parcelable.Creator<a> CREATOR = new C6590a();

        /* renamed from: a, reason: collision with root package name */
        public final String f137378a;

        /* renamed from: b, reason: collision with root package name */
        public final int f137379b;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.p7.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6590a implements Parcelable.Creator {
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

        public a(String userName, int i3) {
            Intrinsics.checkNotNullParameter(userName, "userName");
            this.f137378a = userName;
            this.f137379b = i3;
        }

        public final String a() {
            return this.f137378a;
        }

        public final int b() {
            return this.f137379b;
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
            if (Intrinsics.areEqual(this.f137378a, aVar.f137378a) && this.f137379b == aVar.f137379b) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.f137378a.hashCode() * 31) + this.f137379b;
        }

        public String toString() {
            return "Parameter(userName=" + this.f137378a + ", versionType=" + this.f137379b + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i3) {
            Intrinsics.checkNotNullParameter(out, "out");
            out.writeString(this.f137378a);
            out.writeInt(this.f137379b);
        }
    }

    @Override // com.tencent.luggage.wxa.ka.r
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public com.tencent.luggage.wxa.va.a invoke(a data) {
        boolean z16 = false;
        if (data == null) {
            return new com.tencent.luggage.wxa.va.a(false);
        }
        h hVar = (h) com.tencent.luggage.wxa.c6.b.a(h.class);
        if (hVar != null) {
            z16 = hVar.b(g.a(data.a(), data.b()), new String[0]);
        }
        return new com.tencent.luggage.wxa.va.a(z16);
    }
}
