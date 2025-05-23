package com.tencent.luggage.wxa.be;

import com.tencent.luggage.wxa.hn.n8;
import com.tencent.luggage.wxa.hn.o8;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xo.e;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class g {

    /* renamed from: c, reason: collision with root package name */
    public static final a f122509c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final String f122510a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f122511b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements e.a {

        /* renamed from: a, reason: collision with root package name */
        public static final c f122513a = new c();

        @Override // com.tencent.luggage.wxa.xo.e.a
        public final void a(Object obj) {
            if (obj instanceof Exception) {
                w.b("MicroMsg.ReportUserCheckPhonePrivacy", "CgiCheckVerifyCodeWxaPhone " + ((Exception) obj).getMessage());
            }
        }
    }

    public g(String appId, boolean z16) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        this.f122510a = appId;
        this.f122511b = z16;
    }

    public final void a() {
        n8 n8Var = new n8();
        n8Var.f128269e = this.f122510a;
        n8Var.f128270f = this.f122511b;
        ((com.tencent.luggage.wxa.bj.c) com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.bj.c.class)).b("/cgi-bin/mmbiz-bin/wxabusiness/reportusercheckphoneprivacy", this.f122510a, n8Var, o8.class).b(b.f122512b).a(c.f122513a);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: b, reason: collision with root package name */
        public static final b f122512b = new b();

        @Override // com.tencent.luggage.wxa.uo.b
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            a((o8) obj);
            return Unit.INSTANCE;
        }

        public final void a(o8 o8Var) {
        }
    }
}
