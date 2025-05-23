package com.tencent.luggage.wxa.n3;

import com.tencent.luggage.wxa.hn.gb;
import com.tencent.luggage.wxa.hn.hb;
import com.tencent.luggage.wxa.xo.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class f0 {

    /* renamed from: a, reason: collision with root package name */
    public static final f0 f135168a = new f0();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002*\u0010\u0005\u001a&\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004 \u0001*\u0012\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/tencent/luggage/wxa/va/d;", "kotlin.jvm.PlatformType", "ipcAppId", "Lcom/tencent/luggage/wxa/ka/i;", "Lcom/tencent/luggage/wxa/va/e;", "<anonymous parameter 1>", "", "a", "(Lcom/tencent/luggage/wxa/va/d;Lcom/tencent/luggage/wxa/ka/i;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes8.dex */
    public static final class a<InputType, ResultType> implements com.tencent.luggage.wxa.ka.f {

        /* renamed from: a, reason: collision with root package name */
        public static final a f135169a = new a();

        @Override // com.tencent.luggage.wxa.ka.f
        public final void a(com.tencent.luggage.wxa.va.d dVar, com.tencent.luggage.wxa.ka.i iVar) {
            String paramAppId = dVar.f143315a;
            com.tencent.luggage.wxa.tn.w.d("WMPF.UpdateWxaUsageRecord", "addUseHistory appId:" + paramAppId);
            com.tencent.luggage.wxa.sk.b bVar = (com.tencent.luggage.wxa.sk.b) com.tencent.luggage.wxa.c6.b.a(com.tencent.luggage.wxa.sk.b.class);
            if (bVar != null) {
                Intrinsics.checkNotNullExpressionValue(paramAppId, "paramAppId");
                bVar.f(paramAppId);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements com.tencent.luggage.wxa.ka.i {

        /* renamed from: a, reason: collision with root package name */
        public static final b f135170a = new b();

        @Override // com.tencent.luggage.wxa.ka.i
        public final void a(com.tencent.luggage.wxa.va.e eVar) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements e.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f135171a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f135172b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f135173c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f135174d;

        public c(String str, String str2, int i3, int i16) {
            this.f135171a = str;
            this.f135172b = str2;
            this.f135173c = i3;
            this.f135174d = i16;
        }

        @Override // com.tencent.luggage.wxa.xo.e.c
        public final void a(hb hbVar) {
            com.tencent.luggage.wxa.tn.w.d("WMPF.UpdateWxaUsageRecord", "addUsage username=" + this.f135171a + ", appId=" + this.f135172b + ", versionType=" + this.f135173c + ", visitSessionId=" + this.f135174d + ", visitScene=" + this.f135174d + ", response=" + f0.f135168a.a(hbVar));
        }
    }

    public static final void a(String str, String str2, int i3, String str3, int i16) {
        if (str == null || str2 == null || str3 == null) {
            return;
        }
        String e16 = com.tencent.luggage.wxa.o3.l.f136139a.e();
        if (e16 == null || e16.length() == 0) {
            com.tencent.luggage.wxa.tn.w.f("WMPF.UpdateWxaUsageRecord", "addUsage while no user logged in. username=" + str + ", appId=" + str2 + ", versionType=" + i3 + ", visitSessionId=" + i16 + ", visitScene=" + i16);
            return;
        }
        com.tencent.luggage.wxa.ka.o.a(com.tencent.luggage.wxa.tn.z.g(), new com.tencent.luggage.wxa.va.d(str2), a.f135169a.getClass(), b.f135170a);
        gb gbVar = new gb();
        gbVar.f127703e = i16;
        gbVar.f127704f = 0;
        gbVar.f127705g = i3;
        gbVar.f127706h = 2;
        gbVar.f127707i = 1;
        gbVar.f127708j = str;
        gbVar.f127709k = 0;
        gbVar.f127710l = str3;
        ((com.tencent.luggage.wxa.bj.c) com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.bj.c.class)).b("/cgi-bin/mmbiz-bin/wxaapp/updatewxausagerecord", str2, gbVar, hb.class).a(new c(str, str2, i3, i16));
    }

    public final String a(hb hbVar) {
        if (hbVar == null || hbVar.f127795e == null) {
            return "NULL";
        }
        return "{ErrCode=" + hbVar.f127795e.f128970d + ", ErrMsg=" + hbVar.f127795e.f128971e + '}';
    }
}
