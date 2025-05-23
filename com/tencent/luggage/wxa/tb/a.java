package com.tencent.luggage.wxa.tb;

import com.tencent.luggage.wxa.hn.ma;
import com.tencent.luggage.wxa.hn.na;
import com.tencent.luggage.wxa.hn.oa;
import com.tencent.luggage.wxa.hn.q7;
import com.tencent.luggage.wxa.hn.qa;
import com.tencent.luggage.wxa.hn.s8;
import com.tencent.luggage.wxa.hn.t8;
import com.tencent.luggage.wxa.sb.b;
import com.tencent.luggage.wxa.sb.d;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.wb.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a extends com.tencent.luggage.wxa.wb.a implements a.b {

    /* renamed from: n, reason: collision with root package name */
    public static final b f141195n = new b(null);

    /* renamed from: a, reason: collision with root package name */
    public String f141196a;

    /* renamed from: b, reason: collision with root package name */
    public String f141197b;

    /* renamed from: c, reason: collision with root package name */
    public final int f141198c;

    /* renamed from: d, reason: collision with root package name */
    public final List f141199d;

    /* renamed from: e, reason: collision with root package name */
    public a.c f141200e;

    /* renamed from: f, reason: collision with root package name */
    public c f141201f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f141202g;

    /* renamed from: h, reason: collision with root package name */
    public String f141203h;

    /* renamed from: i, reason: collision with root package name */
    public com.tencent.luggage.wxa.sb.b f141204i;

    /* renamed from: j, reason: collision with root package name */
    public int f141205j;

    /* renamed from: k, reason: collision with root package name */
    public String f141206k;

    /* renamed from: l, reason: collision with root package name */
    public String f141207l;

    /* renamed from: m, reason: collision with root package name */
    public byte[] f141208m;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.tb.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6747a {

        /* renamed from: a, reason: collision with root package name */
        public static final C6748a f141209a = new C6748a(null);

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.tb.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6748a {
            public C6748a() {
            }

            public /* synthetic */ C6748a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public static /* synthetic */ a a(C6748a c6748a, String str, List list, c cVar, boolean z16, byte[] bArr, com.tencent.luggage.wxa.sb.b bVar, int i3, Object obj) {
                if ((i3 & 8) != 0) {
                    z16 = true;
                }
                boolean z17 = z16;
                if ((i3 & 16) != 0) {
                    bArr = new byte[0];
                }
                byte[] bArr2 = bArr;
                if ((i3 & 32) != 0) {
                    bVar = null;
                }
                return c6748a.a(str, list, cVar, z17, bArr2, bVar);
            }

            public final a a(String username, List templates, c cVar, boolean z16, byte[] byteArray, com.tencent.luggage.wxa.sb.b bVar) {
                Intrinsics.checkNotNullParameter(username, "username");
                Intrinsics.checkNotNullParameter(templates, "templates");
                Intrinsics.checkNotNullParameter(byteArray, "byteArray");
                return a(username, "", templates, "", cVar, z16, byteArray, bVar);
            }

            public final a a(String username, String appId, List templates, String extInfo, c cVar, boolean z16, byte[] byteArray, com.tencent.luggage.wxa.sb.b bVar) {
                Intrinsics.checkNotNullParameter(username, "username");
                Intrinsics.checkNotNullParameter(appId, "appId");
                Intrinsics.checkNotNullParameter(templates, "templates");
                Intrinsics.checkNotNullParameter(extInfo, "extInfo");
                Intrinsics.checkNotNullParameter(byteArray, "byteArray");
                return a(username, appId, z16, cVar, templates, 6, byteArray, bVar, extInfo);
            }

            public final a a(String username, List templateIds, c cVar) {
                Intrinsics.checkNotNullParameter(username, "username");
                Intrinsics.checkNotNullParameter(templateIds, "templateIds");
                a aVar = new a(username, 2);
                aVar.f141201f = cVar;
                Iterator it = templateIds.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    List list = aVar.f141199d;
                    ma maVar = new ma();
                    maVar.f128175d = str;
                    list.add(maVar);
                }
                return aVar;
            }

            public final a a(String str, String str2, boolean z16, c cVar, List list, int i3, byte[] bArr, com.tencent.luggage.wxa.sb.b bVar, String str3) {
                a aVar = new a(str, i3, z16);
                aVar.a(str2);
                aVar.f141201f = cVar;
                aVar.a(bArr);
                aVar.f141204i = bVar;
                a(str3, aVar);
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    d dVar = (d) it.next();
                    List list2 = aVar.f141199d;
                    ma maVar = new ma();
                    maVar.f128175d = dVar.f();
                    maVar.f128176e = dVar.g();
                    maVar.f128180i = dVar.e();
                    maVar.f128188q = dVar.k() ? 1 : 0;
                    maVar.f128191t = dVar.l() ? 1 : 0;
                    maVar.f128182k = dVar.p() ? 1 : 0;
                    maVar.f128193v = dVar.b();
                    list2.add(maVar);
                }
                return aVar;
            }

            public final void a(String str, a aVar) {
                if (str.length() > 0) {
                    aVar.f141207l = str;
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        aVar.f141205j = jSONObject.optInt("scene");
                        String optString = jSONObject.optString("sessionid");
                        Intrinsics.checkNotNullExpressionValue(optString, "ext.optString(\"sessionid\")");
                        aVar.f141206k = optString;
                        String extUsername = jSONObject.optString("username");
                        Intrinsics.checkNotNullExpressionValue(extUsername, "extUsername");
                        if (extUsername.length() > 0) {
                            aVar.b(extUsername);
                        }
                        w.d("NetSceneSubscribeMsg", "alvinluo parseExtInfo scene: %s, sessionId: %s, username: %s, extInfo: %s", Integer.valueOf(aVar.f141205j), aVar.f141206k, aVar.b(), str);
                    } catch (Exception e16) {
                        w.a("NetSceneSubscribeMsg", e16, "parse extInfo exception", new Object[0]);
                    }
                }
            }
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
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface c {
        void a(int i3, int i16, String str, com.tencent.luggage.wxa.sb.c cVar);
    }

    public a(String username, String appId, int i3) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(appId, "appId");
        this.f141196a = username;
        this.f141197b = appId;
        this.f141198c = i3;
        this.f141199d = new ArrayList();
        this.f141203h = "";
        this.f141206k = "";
        this.f141207l = "";
        this.f141208m = new byte[0];
    }

    public int a() {
        return 2920;
    }

    public final String b() {
        return this.f141196a;
    }

    public final void b(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f141196a = str;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(String username, int i3) {
        this(username, "", i3);
        Intrinsics.checkNotNullParameter(username, "username");
    }

    public final void a(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f141197b = str;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(String username, int i3, boolean z16) {
        this(username, i3);
        Intrinsics.checkNotNullParameter(username, "username");
        this.f141202g = z16;
    }

    public final void a(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<set-?>");
        this.f141208m = bArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0049, code lost:
    
        if (r1 != 6) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int a(a.InterfaceC6874a dispatcher) {
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        a.c a16 = a.c.f144157a.a(new na(), new oa(), a(), "/cgi-bin/mmbiz-bin/bizattr/subscribemsg");
        this.f141200e = a16;
        Intrinsics.checkNotNull(a16);
        s8 a17 = a16.a();
        Intrinsics.checkNotNull(a17, "null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.SubscribeMsgReq");
        na naVar = (na) a17;
        naVar.f128287o = this.f141205j;
        naVar.f128288p = this.f141206k;
        naVar.f128289q = this.f141207l;
        int i3 = this.f141198c;
        if (i3 != 1) {
            if (i3 == 2 || i3 == 3 || i3 == 5) {
                naVar.f128277e = this.f141196a;
                naVar.f128280h = this.f141197b;
                naVar.f128278f = i3;
                naVar.f128279g.addAll(this.f141199d);
                if (this.f141203h.length() > 0) {
                    naVar.f128283k = this.f141203h;
                }
            }
            a.c cVar = this.f141200e;
            Intrinsics.checkNotNull(cVar);
            return dispatcher.a(cVar, this, this);
        }
        naVar.f128277e = this.f141196a;
        naVar.f128280h = this.f141197b;
        naVar.f128278f = i3;
        naVar.f128281i = 1;
        naVar.f128282j = this.f141202g ? 1 : 0;
        naVar.f128279g.addAll(this.f141199d);
        if (this.f141198c == 6) {
            naVar.f128284l = new com.tencent.luggage.wxa.fn.c(this.f141208m);
            q7 q7Var = new q7();
            naVar.f128285m = q7Var;
            com.tencent.luggage.wxa.sb.b bVar = this.f141204i;
            if (bVar != null) {
                q7Var.f128507e = bVar.h();
                naVar.f128285m.f128506d = bVar.f();
                Iterator it = bVar.g().iterator();
                while (it.hasNext()) {
                    b.c cVar2 = (b.c) it.next();
                    LinkedList linkedList = naVar.f128285m.f128508f;
                    qa qaVar = new qa();
                    qaVar.f128515d = cVar2.e();
                    qaVar.f128516e = cVar2.c();
                    qaVar.f128517f = cVar2.f() ? 1 : 0;
                    qaVar.f128518g = cVar2.d() ? 1 : 0;
                    linkedList.add(qaVar);
                }
            }
        }
        a.c cVar3 = this.f141200e;
        Intrinsics.checkNotNull(cVar3);
        return dispatcher.a(cVar3, this, this);
    }

    @Override // com.tencent.luggage.wxa.wb.a.b
    public void a(int i3, int i16, String str, com.tencent.luggage.wxa.wb.a aVar) {
        if (i3 == 0 && i16 == 0) {
            a.c cVar = this.f141200e;
            Intrinsics.checkNotNull(cVar);
            t8 b16 = cVar.b();
            Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.SubscribeMsgResp");
            oa oaVar = (oa) b16;
            c cVar2 = this.f141201f;
            if (cVar2 != null) {
                if (str == null) {
                    str = "";
                }
                cVar2.a(i3, i16, str, com.tencent.luggage.wxa.sb.c.J.a(oaVar));
                return;
            }
            return;
        }
        c cVar3 = this.f141201f;
        if (cVar3 != null) {
            if (str == null) {
                str = "";
            }
            cVar3.a(i3, i16, str, null);
        }
    }
}
