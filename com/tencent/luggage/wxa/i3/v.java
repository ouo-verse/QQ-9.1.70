package com.tencent.luggage.wxa.i3;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.wxa.fd.o0;
import com.tencent.luggage.wxa.hn.se;
import com.tencent.luggage.wxa.n3.g0;
import com.tencent.luggage.wxa.xo.e;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    public static final v f129385a = new v();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Parcelable {

        @NotNull
        public static final Parcelable.Creator<a> CREATOR = new C6282a();

        /* renamed from: a, reason: collision with root package name */
        public final String f129386a;

        /* renamed from: b, reason: collision with root package name */
        public final String f129387b;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.i3.v$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6282a implements Parcelable.Creator {
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
            this.f129386a = str;
            this.f129387b = str2;
        }

        public final String a() {
            return this.f129386a;
        }

        public final String b() {
            return this.f129387b;
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
            if (Intrinsics.areEqual(this.f129386a, aVar.f129386a) && Intrinsics.areEqual(this.f129387b, aVar.f129387b)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            String str = this.f129386a;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = hashCode * 31;
            String str2 = this.f129387b;
            if (str2 != null) {
                i3 = str2.hashCode();
            }
            return i16 + i3;
        }

        public String toString() {
            return "ParcelizedSyncParameters(appId=" + this.f129386a + ", username=" + this.f129387b + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i3) {
            Intrinsics.checkNotNullParameter(out, "out");
            out.writeString(this.f129386a);
            out.writeString(this.f129387b);
        }
    }

    /* compiled from: P */
    @com.tencent.luggage.wxa.na.a
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ#\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005H\u0096\u0002\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/luggage/wxa/i3/v$b;", "Lcom/tencent/luggage/wxa/ka/e;", "Lcom/tencent/luggage/wxa/i3/v$a;", "Lcom/tencent/luggage/wxa/va/e;", "data", "Lcom/tencent/luggage/wxa/ka/i;", "callback", "", "a", "<init>", "()V", "luggage-standalone-mode-ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes8.dex */
    public static final class b implements com.tencent.luggage.wxa.ka.e<a, com.tencent.luggage.wxa.va.e> {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements e.c {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f129388a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f129389b;

            public a(String str, String str2) {
                this.f129388a = str;
                this.f129389b = str2;
            }

            @Override // com.tencent.luggage.wxa.xo.e.c
            public final void a(se seVar) {
                String str = this.f129388a;
                if (!(str == null || str.length() == 0)) {
                    o0.a().b(this.f129388a, seVar);
                    return;
                }
                String str2 = this.f129389b;
                if (str2 == null || str2.length() == 0) {
                    return;
                }
                o0.a().a(this.f129389b, seVar);
            }
        }

        @Override // com.tencent.luggage.wxa.ka.f
        public void a(a data, com.tencent.luggage.wxa.ka.i callback) {
            if (data != null) {
                try {
                    String a16 = data.a();
                    String b16 = data.b();
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("syncInMainProcess, main process enter, appId:");
                    String str = "";
                    sb5.append(a16 == null ? "" : a16);
                    sb5.append(", username:");
                    if (b16 != null) {
                        str = b16;
                    }
                    sb5.append(str);
                    com.tencent.luggage.wxa.tn.w.d("Luggage.WxaLaunchPreconditionProcessKt", sb5.toString());
                    g0.b(a16, b16).a(new a(a16, b16));
                } finally {
                    if (callback != null) {
                        callback.a(com.tencent.luggage.wxa.va.e.f143316a);
                    }
                }
            }
        }
    }

    public static /* synthetic */ void a(String str, String str2, String str3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        if ((i3 & 2) != 0) {
            str2 = null;
        }
        if ((i3 & 4) != 0) {
            str3 = null;
        }
        a(str, str2, str3);
    }

    public static final void a(String str, String str2, String str3) {
        if (str == null || str.length() == 0) {
            if (str2 == null || str2.length() == 0) {
                return;
            }
        }
        boolean z16 = 1 != com.tencent.luggage.wxa.p3.g.a();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("syncOnLaunchFail start, syncInMainProcess:");
        sb5.append(z16);
        sb5.append(", appId:");
        sb5.append(str == null ? "" : str);
        sb5.append(", username:");
        sb5.append(str2 == null ? "" : str2);
        sb5.append(", reason:");
        if (str3 == null) {
            str3 = "";
        }
        sb5.append(str3);
        com.tencent.luggage.wxa.tn.w.d("Luggage.WxaLaunchPreconditionProcessKt", sb5.toString());
        if (z16) {
            String g16 = com.tencent.luggage.wxa.tn.z.g();
            Intrinsics.checkNotNullExpressionValue(g16, "getMainProcessName()");
            com.tencent.luggage.wxa.ka.b.a(g16, new a(str, str2), new b(), c.f129390a);
            return;
        }
        new b().a(new a(str, str2), (com.tencent.luggage.wxa.ka.i) null);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public static final c f129390a = new c();

        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((com.tencent.luggage.wxa.va.e) obj);
            return Unit.INSTANCE;
        }

        public final void a(com.tencent.luggage.wxa.va.e eVar) {
        }
    }
}
