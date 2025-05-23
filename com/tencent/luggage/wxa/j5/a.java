package com.tencent.luggage.wxa.j5;

import com.tencent.luggage.wxa.h1.e;
import com.tencent.luggage.wxa.hn.ma;
import com.tencent.luggage.wxa.hn.na;
import com.tencent.luggage.wxa.hn.oa;
import com.tencent.luggage.wxa.tn.w;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f130859a = new a();

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.j5.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6327a implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: b, reason: collision with root package name */
        public static final C6327a f130860b = new C6327a();

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.tencent.luggage.wxa.sb.c call(oa oaVar) {
            if (oaVar != null && oaVar.f128357o == 0) {
                return com.tencent.luggage.wxa.sb.c.J.a(oaVar);
            }
            w.b("WxaSubscribeMsgSettingDataHelper", "WxaAppModAuthReq failed, response is null!");
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1 f130861b;

        public b(Function1 function1) {
            this.f130861b = function1;
        }

        public final void a(com.tencent.luggage.wxa.sb.c cVar) {
            if (cVar == null) {
                a aVar = a.f130859a;
                this.f130861b.invoke(null);
            } else {
                this.f130861b.invoke(new com.tencent.luggage.wxa.g5.c(cVar, false, 2, null));
            }
        }

        @Override // com.tencent.luggage.wxa.uo.b
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            a((com.tencent.luggage.wxa.sb.c) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: b, reason: collision with root package name */
        public static final c f130862b = new c();

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.tencent.luggage.wxa.sb.c call(oa oaVar) {
            if (oaVar != null && oaVar.f128357o == 0) {
                return com.tencent.luggage.wxa.sb.c.J.a(oaVar);
            }
            w.b("WxaSubscribeMsgSettingDataHelper", "WxaAppModAuthReq failed, response is null!");
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1 f130863b;

        public d(Function1 function1) {
            this.f130863b = function1;
        }

        public final void a(com.tencent.luggage.wxa.sb.c cVar) {
            if (cVar == null) {
                a aVar = a.f130859a;
                this.f130863b.invoke(null);
            } else {
                this.f130863b.invoke(cVar);
            }
        }

        @Override // com.tencent.luggage.wxa.uo.b
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            a((com.tencent.luggage.wxa.sb.c) obj);
            return Unit.INSTANCE;
        }
    }

    public final void a(String userName, String appId, Function1 receiver) {
        Intrinsics.checkNotNullParameter(userName, "userName");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        na naVar = new na();
        naVar.f128277e = userName;
        naVar.f128278f = 3;
        ((com.tencent.luggage.wxa.bj.c) e.a(com.tencent.luggage.wxa.bj.c.class)).b("/cgi-bin/mmbiz-bin/bizattr/subscribemsg", appId, naVar, oa.class).b(C6327a.f130860b).b(new b(receiver));
    }

    public final void a(String userName, String appId, com.tencent.luggage.wxa.g5.c data, Function1 receiver) {
        Intrinsics.checkNotNullParameter(userName, "userName");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        ArrayList arrayList = new ArrayList();
        for (com.tencent.luggage.wxa.sb.d dVar : data.b()) {
            ma maVar = new ma();
            maVar.f128175d = dVar.f();
            maVar.f128176e = dVar.g();
            maVar.f128180i = dVar.e();
            maVar.f128182k = dVar.p() ? 1 : 0;
            arrayList.add(maVar);
        }
        na naVar = new na();
        naVar.f128277e = userName;
        naVar.f128278f = 1;
        naVar.f128281i = 1;
        naVar.f128282j = data.e() ? 1 : 0;
        naVar.f128279g.addAll(arrayList);
        ((com.tencent.luggage.wxa.bj.c) e.a(com.tencent.luggage.wxa.bj.c.class)).b("/cgi-bin/mmbiz-bin/bizattr/subscribemsg", appId, naVar, oa.class).b(c.f130862b).b(new d(receiver));
    }
}
