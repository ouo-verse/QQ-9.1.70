package com.tencent.luggage.wxa.w2;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.wxa.fd.i;
import com.tencent.luggage.wxa.i3.n;
import com.tencent.luggage.wxa.i3.u;
import com.tencent.luggage.wxa.ic.v;
import com.tencent.luggage.wxa.j4.l;
import com.tencent.luggage.wxa.jf.d;
import com.tencent.luggage.wxa.jf.j;
import com.tencent.luggage.wxa.ka.r;
import com.tencent.luggage.wxa.p5.f;
import com.tencent.luggage.wxa.r6.e;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.xo.h;
import com.tencent.luggage.wxa.z4.g;
import com.tencent.luggage.wxa.z4.k;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c extends j {

    /* renamed from: b, reason: collision with root package name */
    public static final b f144049b = new b(null);

    /* renamed from: c, reason: collision with root package name */
    public static final c f144050c = new c();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Parcelable {

        @NotNull
        public static final Parcelable.Creator<a> CREATOR = new C6861a();

        /* renamed from: a, reason: collision with root package name */
        public final String f144051a;

        /* renamed from: b, reason: collision with root package name */
        public final int f144052b;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.w2.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6861a implements Parcelable.Creator {
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
            this.f144051a = appId;
            this.f144052b = i3;
        }

        public final String a() {
            return this.f144051a;
        }

        public final int b() {
            return this.f144052b;
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
            if (Intrinsics.areEqual(this.f144051a, aVar.f144051a) && this.f144052b == aVar.f144052b) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.f144051a.hashCode() * 31) + this.f144052b;
        }

        public String toString() {
            return "AppIdentity(appId=" + this.f144051a + ", versionType=" + this.f144052b + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i3) {
            Intrinsics.checkNotNullParameter(out, "out");
            out.writeString(this.f144051a);
            out.writeInt(this.f144052b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final c a() {
            return c.f144050c;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.w2.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6862c implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ki.a f144054c;

        public C6862c(com.tencent.luggage.wxa.ki.a aVar) {
            this.f144054c = aVar;
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.tencent.luggage.wxa.j4.d call(com.tencent.luggage.wxa.j4.d dVar) {
            if (dVar == null) {
                h.a().a((Object) null);
                return null;
            }
            if (2 == this.f144054c.f132022d) {
                com.tencent.luggage.wxa.xo.d a16 = h.a(dVar);
                String str = this.f144054c.f132018b;
                Intrinsics.checkNotNullExpressionValue(str, "params.appId");
                h.a((com.tencent.luggage.wxa.xo.e) a16.c(new com.tencent.luggage.wxa.i3.a(str)));
            }
            return dVar;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ki.a f144055b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.d f144056c;

        public d(com.tencent.luggage.wxa.ki.a aVar, com.tencent.luggage.wxa.ic.d dVar) {
            this.f144055b = aVar;
            this.f144056c = dVar;
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.tencent.luggage.wxa.j4.d call(com.tencent.luggage.wxa.j4.d dVar) {
            com.tencent.luggage.wxa.r5.a aVar;
            String str;
            boolean z16;
            com.tencent.luggage.wxa.p6.d dVar2 = (com.tencent.luggage.wxa.p6.d) com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.p6.d.class);
            Parcel b16 = dVar.b();
            Intrinsics.checkNotNullExpressionValue(b16, "it.cloneInParcel()");
            com.tencent.luggage.wxa.r5.a a16 = dVar2.a(b16);
            com.tencent.luggage.wxa.ki.a aVar2 = this.f144055b;
            com.tencent.luggage.wxa.ic.d dVar3 = this.f144056c;
            aVar2.a(a16);
            i S = dVar3.getRuntime().S();
            com.tencent.luggage.wxa.j4.d dVar4 = null;
            if (S instanceof com.tencent.luggage.wxa.r5.a) {
                aVar = (com.tencent.luggage.wxa.r5.a) S;
            } else {
                aVar = null;
            }
            if (aVar != null) {
                str = aVar.M0;
            } else {
                str = null;
            }
            a16.M0 = str;
            i S2 = dVar3.getRuntime().S();
            if (S2 instanceof com.tencent.luggage.wxa.j4.d) {
                dVar4 = (com.tencent.luggage.wxa.j4.d) S2;
            }
            if (dVar4 != null && dVar4.f130795g0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                a16.f130795g0 = true;
            }
            return a16;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/tencent/luggage/wxa/w2/c$a;", "data", "Lcom/tencent/luggage/wxa/j4/d;", "a", "(Lcom/tencent/luggage/wxa/w2/c$a;)Lcom/tencent/luggage/wxa/j4/d;"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes8.dex */
    public static final class e<InputType, ResultType> implements r {

        /* renamed from: a, reason: collision with root package name */
        public static final e f144057a = new e();

        @Override // com.tencent.luggage.wxa.ka.r
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.tencent.luggage.wxa.j4.d invoke(a aVar) {
            i iVar;
            if (aVar == null) {
                return null;
            }
            g b16 = com.tencent.luggage.wxa.l3.h.f132999i.a().b(aVar.a(), aVar.b());
            if (b16 != null) {
                iVar = b16.c();
            } else {
                iVar = null;
            }
            if (!(iVar instanceof com.tencent.luggage.wxa.j4.d)) {
                return null;
            }
            return (com.tencent.luggage.wxa.j4.d) iVar;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x009d, code lost:
    
        if ((r2 != null && r2.a(r8)) != false) goto L43;
     */
    @Override // com.tencent.luggage.wxa.jf.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.tencent.luggage.wxa.xo.d a(com.tencent.luggage.wxa.ic.d component, d.a context, com.tencent.luggage.wxa.ki.a params, JSONObject navigateInvokeParams) {
        String str;
        Intrinsics.checkNotNullParameter(component, "component");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(navigateInvokeParams, "navigateInvokeParams");
        String str2 = params.F;
        boolean z16 = false;
        if (str2 == null || str2.length() == 0) {
            i S = component.getRuntime().S();
            com.tencent.luggage.wxa.j4.d dVar = S instanceof com.tencent.luggage.wxa.j4.d ? (com.tencent.luggage.wxa.j4.d) S : null;
            if (dVar != null && (str = dVar.f130793e0) != null) {
                if (str.length() > 0) {
                    params.F = new n(str, true).c();
                }
            }
        }
        l lVar = l.b.f130852a;
        if (lVar == null) {
            lVar = l.f130851b;
        }
        params.c(lVar.a(params));
        f b16 = com.tencent.luggage.wxa.p6.h.b(params.f132018b);
        if (b16 != null && b16.S().d() == params.f132022d) {
            v e06 = component.getRuntime().e0();
            if (!Intrinsics.areEqual(e06, b16.e0())) {
                com.tencent.luggage.wxa.o1.a aVar = e06 instanceof com.tencent.luggage.wxa.o1.a ? (com.tencent.luggage.wxa.o1.a) e06 : null;
            }
            com.tencent.luggage.wxa.r5.a clone = b16.S().clone();
            params.a(clone);
            com.tencent.luggage.wxa.r6.e.f139295y.a(params, k.RESUME_EXISTED, clone.k());
            com.tencent.luggage.wxa.xo.d a16 = h.a(clone);
            Intrinsics.checkNotNullExpressionValue(a16, "pipeline(initConfig)");
            return a16;
        }
        com.tencent.luggage.wxa.ic.g runtime = component.getRuntime();
        com.tencent.luggage.wxa.c5.e eVar = runtime instanceof com.tencent.luggage.wxa.c5.e ? (com.tencent.luggage.wxa.c5.e) runtime : null;
        if (eVar != null && eVar.Q1()) {
            z16 = true;
        }
        if (z16 && !com.tencent.luggage.wxa.td.c.A.a()) {
            String g16 = z.g();
            Intrinsics.checkNotNullExpressionValue(g16, "getMainProcessName()");
            String str3 = params.f132018b;
            Intrinsics.checkNotNullExpressionValue(str3, "params.appId");
            com.tencent.luggage.wxa.j4.d dVar2 = (com.tencent.luggage.wxa.j4.d) com.tencent.luggage.wxa.ka.b.a(g16, new a(str3, params.f132022d), e.f144057a);
            if (dVar2 != null) {
                params.a(dVar2);
                com.tencent.luggage.wxa.r6.e.f139295y.a(params, k.RESUME_EXISTED, dVar2.k());
                com.tencent.luggage.wxa.xo.d a17 = h.a(dVar2);
                Intrinsics.checkNotNullExpressionValue(a17, "pipeline(existedInitConfig)");
                return a17;
            }
        }
        u uVar = new u(params, e.a.a(com.tencent.luggage.wxa.r6.e.f139295y, params, k.CREATE_NEW, null, 4, null));
        if (params.f132040m <= 0) {
            params.f132040m = com.tencent.luggage.wxa.m3.a.f134071a.a();
        }
        com.tencent.luggage.wxa.xo.d c16 = uVar.a().c(new C6862c(params)).c(new d(params, component));
        Intrinsics.checkNotNullExpressionValue(c16, "override fun prepareInit\u2026    }\n            }\n    }");
        return c16;
    }
}
