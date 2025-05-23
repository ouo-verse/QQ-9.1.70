package com.tencent.luggage.wxa.ic;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.xweb.FileReaderHelper;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class x extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = -2;

    @NotNull
    public static final String NAME = "restart";

    /* renamed from: a, reason: collision with root package name */
    public static final a f130013a = new a(null);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final com.tencent.luggage.wxa.d6.b a(com.tencent.luggage.wxa.r5.a aVar) {
            Intrinsics.checkNotNullParameter(aVar, "<this>");
            com.tencent.luggage.wxa.d6.b bVar = new com.tencent.luggage.wxa.d6.b();
            bVar.f124086d = aVar.f125808a;
            bVar.f124088f = aVar.X0;
            bVar.f124089g = aVar.f125813f;
            bVar.f124090h = aVar.d();
            LinkedList linkedList = new LinkedList();
            bVar.f124091i = linkedList;
            linkedList.add(new com.tencent.luggage.wxa.d6.a().a("clientApplicationId").b(aVar.M0));
            bVar.f124091i.add(new com.tencent.luggage.wxa.d6.a().a("zoom").b(String.valueOf(aVar.N0)));
            bVar.f124091i.add(new com.tencent.luggage.wxa.d6.a().a("ratio").b(String.valueOf(aVar.O0)));
            bVar.f124092j = aVar.R0.ordinal();
            bVar.f124093k = aVar.S0;
            bVar.f124094l = aVar.f130812x0;
            bVar.f124096n = aVar.T0;
            bVar.f124097o = aVar.f130806r0;
            bVar.f124098p = aVar.f130795g0;
            bVar.f124100r = aVar.f130793e0;
            bVar.f124105w = aVar.P0;
            bVar.f124106x = aVar.Q0;
            return bVar;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements Parcelable {

        @NotNull
        public static final Parcelable.Creator<b> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public final com.tencent.luggage.wxa.r5.a f130014a;

        /* renamed from: b, reason: collision with root package name */
        public final com.tencent.luggage.wxa.bk.e f130015b;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final b createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new b((com.tencent.luggage.wxa.r5.a) parcel.readParcelable(b.class.getClassLoader()), (com.tencent.luggage.wxa.bk.e) parcel.readParcelable(b.class.getClassLoader()));
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final b[] newArray(int i3) {
                return new b[i3];
            }
        }

        public b(com.tencent.luggage.wxa.r5.a initConfig, com.tencent.luggage.wxa.bk.e eVar) {
            Intrinsics.checkNotNullParameter(initConfig, "initConfig");
            this.f130014a = initConfig;
            this.f130015b = eVar;
        }

        public final com.tencent.luggage.wxa.r5.a a() {
            return this.f130014a;
        }

        public final com.tencent.luggage.wxa.bk.e b() {
            return this.f130015b;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (Intrinsics.areEqual(this.f130014a, bVar.f130014a) && Intrinsics.areEqual(this.f130015b, bVar.f130015b)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2 = this.f130014a.hashCode() * 31;
            com.tencent.luggage.wxa.bk.e eVar = this.f130015b;
            if (eVar == null) {
                hashCode = 0;
            } else {
                hashCode = eVar.hashCode();
            }
            return hashCode2 + hashCode;
        }

        public String toString() {
            return "RestartParams(initConfig=" + this.f130014a + ", statObject=" + this.f130015b + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i3) {
            Intrinsics.checkNotNullParameter(out, "out");
            out.writeParcelable(this.f130014a, i3);
            out.writeParcelable(this.f130015b, i3);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002*\u0010\u0005\u001a&\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004 \u0001*\u0012\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/tencent/luggage/wxa/ic/x$b;", "kotlin.jvm.PlatformType", "restartParams", "Lcom/tencent/luggage/wxa/ka/i;", "Lcom/tencent/luggage/wxa/va/e;", "callback", "", "a", "(Lcom/tencent/luggage/wxa/ic/x$b;Lcom/tencent/luggage/wxa/ka/i;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes8.dex */
    public static final class c<InputType, ResultType> implements com.tencent.luggage.wxa.ka.e {

        /* renamed from: a, reason: collision with root package name */
        public static final c f130016a = new c();

        @Override // com.tencent.luggage.wxa.ka.f
        public final void a(b bVar, com.tencent.luggage.wxa.ka.i iVar) {
            com.tencent.luggage.wxa.i3.t.a(null, x.f130013a.a(bVar.a()), bVar.b(), null, true);
            if (iVar != null) {
                iVar.a(com.tencent.luggage.wxa.va.e.f143316a);
            }
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(d dVar, JSONObject jSONObject, int i3) {
        String str;
        com.tencent.luggage.wxa.fd.i iVar;
        com.tencent.luggage.wxa.r5.a aVar;
        com.tencent.luggage.wxa.r5.a aVar2;
        g runtime;
        if (jSONObject != null) {
            str = jSONObject.optString("url");
        } else {
            str = null;
        }
        if (dVar != null && (runtime = dVar.getRuntime()) != null) {
            iVar = runtime.S();
        } else {
            iVar = null;
        }
        if (iVar instanceof com.tencent.luggage.wxa.r5.a) {
            aVar = (com.tencent.luggage.wxa.r5.a) iVar;
        } else {
            aVar = null;
        }
        if (aVar != null) {
            aVar2 = aVar.clone();
        } else {
            aVar2 = null;
        }
        if (aVar2 == null) {
            if (dVar != null) {
                dVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.e.f121309e));
                return;
            }
            return;
        }
        aVar2.f125813f = str;
        boolean z16 = false;
        if (jSONObject != null) {
            z16 = jSONObject.optBoolean(FileReaderHelper.OPEN_FILE_FROM_FORCE, false);
        }
        aVar2.C = z16;
        aVar2.f130802n0 = z16;
        b bVar = new b(aVar2, aVar2.i());
        String g16 = com.tencent.luggage.wxa.tn.z.g();
        Intrinsics.checkNotNullExpressionValue(g16, "getMainProcessName()");
        com.tencent.luggage.wxa.ka.b.a(g16, bVar, c.f130016a, null);
    }
}
