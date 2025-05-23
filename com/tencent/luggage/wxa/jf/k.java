package com.tencent.luggage.wxa.jf;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.wxa.ka.r;
import com.tencent.luggage.wxa.tn.z;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public static final k f131051a = new k();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Parcelable {

        @NotNull
        public static final Parcelable.Creator<a> CREATOR = new C6336a();

        /* renamed from: a, reason: collision with root package name */
        public final String f131052a;

        /* renamed from: b, reason: collision with root package name */
        public final int f131053b;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.jf.k$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6336a implements Parcelable.Creator {
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
            this.f131052a = appId;
            this.f131053b = i3;
        }

        public final String a() {
            return this.f131052a;
        }

        public final int b() {
            return this.f131053b;
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
            if (Intrinsics.areEqual(this.f131052a, aVar.f131052a) && this.f131053b == aVar.f131053b) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.f131052a.hashCode() * 31) + this.f131053b;
        }

        public String toString() {
            return "RuntimeInfo(appId=" + this.f131052a + ", versionType=" + this.f131053b + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i3) {
            Intrinsics.checkNotNullParameter(out, "out");
            out.writeString(this.f131052a);
            out.writeInt(this.f131053b);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/tencent/luggage/wxa/jf/k$a;", "info", "Lcom/tencent/luggage/wxa/va/e;", "a", "(Lcom/tencent/luggage/wxa/jf/k$a;)Lcom/tencent/luggage/wxa/va/e;"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes8.dex */
    public static final class b<InputType, ResultType> implements r {

        /* renamed from: a, reason: collision with root package name */
        public static final b f131054a = new b();

        @Override // com.tencent.luggage.wxa.ka.r
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.tencent.luggage.wxa.va.e invoke(a aVar) {
            if (aVar == null) {
                return com.tencent.luggage.wxa.va.e.f143316a;
            }
            com.tencent.luggage.wxa.z4.f.a(com.tencent.luggage.wxa.z4.f.f146283b.a(), aVar.a(), aVar.b(), false, 0, 12, (Object) null);
            return com.tencent.luggage.wxa.va.e.f143316a;
        }
    }

    public static final void a(String appId, int i3) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        String g16 = z.g();
        Intrinsics.checkNotNullExpressionValue(g16, "getMainProcessName()");
        com.tencent.luggage.wxa.ka.b.a(g16, new a(appId, i3), b.f131054a);
    }
}
