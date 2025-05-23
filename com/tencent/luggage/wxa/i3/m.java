package com.tencent.luggage.wxa.i3;

import com.tencent.luggage.wxa.fd.n0;
import com.tencent.luggage.wxa.fd.o0;
import com.tencent.luggage.wxa.hn.h0;
import com.tencent.luggage.wxa.hn.se;
import com.tencent.luggage.wxa.n3.g0;
import com.tencent.luggage.wxa.xo.e;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public static final m f129333a = new m();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f129334b;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.i3.m$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6280a implements e.c {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.xo.b f129335a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f129336b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Ref.ObjectRef f129337c;

            public C6280a(com.tencent.luggage.wxa.xo.b bVar, String str, Ref.ObjectRef objectRef) {
                this.f129335a = bVar;
                this.f129336b = str;
                this.f129337c = objectRef;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.tencent.luggage.wxa.xo.e.c
            public final void a(se seVar) {
                if ((seVar != null ? seVar.f128743d : null) != null) {
                    h0 h0Var = seVar.f128743d;
                    if (h0Var != null && h0Var.f127731d == 0) {
                        o0.a().a(this.f129336b, seVar);
                        Ref.ObjectRef objectRef = this.f129337c;
                        n0 b16 = o0.a().b(this.f129336b, "appId");
                        objectRef.element = b16 != null ? b16.f138467f : 0;
                        CharSequence charSequence = (CharSequence) this.f129337c.element;
                        if (charSequence == null || charSequence.length() == 0) {
                            com.tencent.luggage.wxa.tn.w.b("Luggage.WxaAttrSyncHelper", "getAppIdByUserName fail, appId is null");
                            this.f129335a.a("getAppIdByUserName fail, appId is null");
                            return;
                        } else {
                            this.f129335a.a(this.f129337c.element);
                            return;
                        }
                    }
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append("getAppIdByUserName fail, response:");
                h0 h0Var2 = seVar.f128743d;
                sb5.append(h0Var2 != null ? Integer.valueOf(h0Var2.f127731d) : null);
                sb5.append(" is null");
                com.tencent.luggage.wxa.tn.w.b("Luggage.WxaAttrSyncHelper", sb5.toString());
                com.tencent.luggage.wxa.xo.b bVar = this.f129335a;
                StringBuilder sb6 = new StringBuilder();
                sb6.append("getAppIdByUserName fail, response:");
                h0 h0Var3 = seVar.f128743d;
                sb6.append(h0Var3 != null ? Integer.valueOf(h0Var3.f127731d) : null);
                sb6.append(" is null");
                bVar.a(sb6.toString());
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class b implements e.a {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.xo.b f129338a;

            public b(com.tencent.luggage.wxa.xo.b bVar) {
                this.f129338a = bVar;
            }

            @Override // com.tencent.luggage.wxa.xo.e.a
            public final void a(Object obj) {
                com.tencent.luggage.wxa.tn.w.b("Luggage.WxaAttrSyncHelper", "getAppIdByUserName fail: " + obj);
                this.f129338a.a(obj);
            }
        }

        public a(String str) {
            this.f129334b = str;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v0 */
        /* JADX WARN: Type inference failed for: r6v1, types: [T, java.lang.CharSequence] */
        /* JADX WARN: Type inference failed for: r6v3 */
        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String call(Void r102) {
            boolean z16;
            boolean endsWith$default;
            String str;
            String str2 = this.f129334b;
            boolean z17 = true;
            if (str2 != null && str2.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                com.tencent.luggage.wxa.tn.w.f("Luggage.WxaAttrSyncHelper", "username is null, return");
                return "";
            }
            ?? r65 = 0;
            endsWith$default = StringsKt__StringsJVMKt.endsWith$default(this.f129334b, "@app", false, 2, null);
            if (!endsWith$default) {
                str = this.f129334b + "@app";
            } else {
                str = this.f129334b;
            }
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            n0 b16 = o0.a().b(this.f129334b, "appId");
            if (b16 != null) {
                r65 = b16.f138467f;
            }
            objectRef.element = r65;
            if (r65 != 0) {
                if (r65.length() <= 0) {
                    z17 = false;
                }
                if (z17) {
                    com.tencent.luggage.wxa.tn.w.b("Luggage.WxaAttrSyncHelper", this.f129334b + " getAppIdByUserName by cache success: " + ((String) objectRef.element));
                    return (String) objectRef.element;
                }
            }
            com.tencent.luggage.wxa.xo.b b17 = com.tencent.luggage.wxa.xo.h.b();
            g0.f135177a.c(str).a(new C6280a(b17, this.f129334b, objectRef)).a(new b(b17));
            return "";
        }
    }

    public final com.tencent.luggage.wxa.xo.d a(String str) {
        com.tencent.luggage.wxa.xo.d b16 = com.tencent.luggage.wxa.xo.h.c().b(new a(str));
        Intrinsics.checkNotNullExpressionValue(b16, "username: String?): Pipe\u2026\n            \"\"\n        }");
        return b16;
    }
}
