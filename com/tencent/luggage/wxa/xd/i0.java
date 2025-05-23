package com.tencent.luggage.wxa.xd;

import androidx.arch.core.util.Function;
import com.tencent.luggage.wxa.hn.te;
import com.tencent.luggage.wxa.xo.e;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.apache.commons.lang.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class i0 extends com.tencent.luggage.wxa.xd.a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f144814a = new a(null);

    @JvmField
    @Deprecated
    @NotNull
    public static final String NAME = "batchGetContact";

    @JvmField
    @Deprecated
    public static final int CTRL_INDEX = 410;

    /* renamed from: b, reason: collision with root package name */
    public static final String f144815b = "/cgi-bin/mmbiz-bin/wxaattr/batchwxaattrsync";

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final /* synthetic */ JSONArray a(List list) {
            Intrinsics.checkNotNullParameter(list, "<this>");
            JSONArray jSONArray = new JSONArray();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                com.tencent.luggage.wxa.fd.n0 n0Var = (com.tencent.luggage.wxa.fd.n0) it.next();
                JSONObject optJSONObject = new JSONObject(n0Var.f138487z).optJSONObject("PluginInfo");
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                }
                jSONArray.mo162put(optJSONObject.put("appId", n0Var.f138467f));
            }
            return jSONArray;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class b extends k0 {

        /* renamed from: a, reason: collision with root package name */
        public static final a f144816a = new a(null);

        @JvmField
        @NotNull
        public static final String NAME = "onContactUpdate";

        @JvmField
        public static final int CTRL_INDEX = -2;

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public static final class a {
            public a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final void a(com.tencent.luggage.wxa.ic.d dVar, List list, String str) {
                boolean z16;
                boolean z17 = false;
                if (dVar != null && dVar.isRunning()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    return;
                }
                if (str == null || str.length() == 0) {
                    z17 = true;
                }
                if (z17) {
                    return;
                }
                b bVar = new b();
                if (list != null) {
                    bVar.setData("contactList", i0.f144814a.a(list));
                }
                bVar.setData("callbackId", str);
                bVar.setContext(dVar).dispatch();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final String f144817a;

        /* renamed from: b, reason: collision with root package name */
        public final int f144818b;

        /* renamed from: c, reason: collision with root package name */
        public final List f144819c;

        /* renamed from: d, reason: collision with root package name */
        public final com.tencent.luggage.wxa.bj.c f144820d;

        /* renamed from: e, reason: collision with root package name */
        public final long f144821e;

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public static final class a implements com.tencent.luggage.wxa.jq.g {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Function1 f144823b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Function1 f144824c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ Function0 f144825d;

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ Function1 f144826e;

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.xd.i0$c$a$a, reason: collision with other inner class name */
            /* loaded from: classes9.dex */
            public static final class C6905a extends Lambda implements Function1 {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ Function1 f144827a;

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ c f144828b;

                /* renamed from: c, reason: collision with root package name */
                public final /* synthetic */ Function1 f144829c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C6905a(Function1 function1, c cVar, Function1 function12) {
                    super(1);
                    this.f144827a = function1;
                    this.f144828b = cVar;
                    this.f144829c = function12;
                }

                public final void a(com.tencent.luggage.wxa.hn.r0 r0Var) {
                    if (r0Var == null) {
                        this.f144827a.invoke("get contact fail response is null");
                        return;
                    }
                    if (com.tencent.luggage.wxa.fd.o0.a().a(107, r0Var)) {
                        List a16 = com.tencent.luggage.wxa.fd.o0.a().a(this.f144828b.f144819c, new String[0]);
                        if (a16 != null) {
                            this.f144829c.invoke(a16);
                        } else {
                            a16 = null;
                        }
                        if (a16 == null) {
                            this.f144827a.invoke("get contact fail");
                            return;
                        }
                        return;
                    }
                    this.f144827a.invoke("update contacts fail");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((com.tencent.luggage.wxa.hn.r0) obj);
                    return Unit.INSTANCE;
                }
            }

            public a(Function1 function1, Function1 function12, Function0 function0, Function1 function13) {
                this.f144823b = function1;
                this.f144824c = function12;
                this.f144825d = function0;
                this.f144826e = function13;
            }

            @Override // com.tencent.luggage.wxa.jq.g, com.tencent.luggage.wxa.jq.f
            public String getKey() {
                return "Luggage.FULL.JsApiBatchGetContact.Loader";
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x0064 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:30:0x0048 A[SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                Unit unit;
                boolean z16;
                LinkedList linkedList = new LinkedList();
                LinkedList linkedList2 = new LinkedList();
                try {
                    HashSet<String> hashSet = new HashSet(c.this.f144819c);
                    List<com.tencent.luggage.wxa.fd.n0> a16 = com.tencent.luggage.wxa.fd.o0.a().a(c.this.f144819c, "username", "appId", "versionInfo", "appInfo", "syncTimeSecond", "syncVersion");
                    if (a16 != null) {
                        c cVar = c.this;
                        for (com.tencent.luggage.wxa.fd.n0 n0Var : a16) {
                            String str = n0Var.f138487z;
                            if (str != null && str.length() != 0) {
                                z16 = false;
                                if (z16) {
                                    hashSet.remove(n0Var.f138467f);
                                    linkedList.add(n0Var);
                                    if (com.tencent.luggage.wxa.tn.w0.d(n0Var.N) > cVar.f144821e) {
                                        te teVar = new te();
                                        teVar.f128764f = n0Var.f138467f;
                                        if (!com.tencent.luggage.wxa.fd.m0.a(n0Var) && !com.tencent.luggage.wxa.fd.m0.b(n0Var)) {
                                            teVar.f128763e = com.tencent.luggage.wxa.fd.k0.b(n0Var);
                                            linkedList2.add(teVar);
                                        }
                                        teVar.f128763e = new com.tencent.luggage.wxa.fn.c(new byte[0]);
                                        linkedList2.add(teVar);
                                    }
                                }
                            }
                            z16 = true;
                            if (z16) {
                            }
                        }
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                    }
                    if (unit == null) {
                        this.f144823b.invoke("get contact fail");
                        return;
                    }
                    for (String str2 : hashSet) {
                        te teVar2 = new te();
                        teVar2.f128764f = str2;
                        teVar2.f128763e = new com.tencent.luggage.wxa.fn.c(new byte[0]);
                        linkedList2.add(teVar2);
                    }
                    if (linkedList.size() == c.this.f144819c.size()) {
                        this.f144824c.invoke(linkedList);
                    }
                    if (!linkedList2.isEmpty()) {
                        com.tencent.luggage.wxa.tn.w.d("Luggage.FULL.JsApiBatchGetContact", "Loader(" + c.this.f144818b + ").waitForBatchCgiUpdate requestList.size:" + linkedList2.size());
                        c cVar2 = c.this;
                        cVar2.a(cVar2.f144820d, linkedList2, new C6905a(this.f144823b, c.this, this.f144826e), this.f144823b);
                        return;
                    }
                    this.f144825d.invoke();
                } catch (JSONException e16) {
                    com.tencent.luggage.wxa.tn.w.b("Luggage.FULL.JsApiBatchGetContact", "Loader(" + c.this.hashCode() + ").run(), make callback array e=" + e16);
                    this.f144823b.invoke("get contact json error");
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public static final class b implements Runnable {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.hn.q0 f144831b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Function1 f144832c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ Function1 f144833d;

            /* compiled from: P */
            /* loaded from: classes9.dex */
            public static final class a implements e.a {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ Function1 f144834a;

                public a(Function1 function1) {
                    this.f144834a = function1;
                }

                @Override // com.tencent.luggage.wxa.xo.e.a
                public final void a(Object obj) {
                    String obj2;
                    if (obj == null) {
                        obj2 = null;
                    } else if (obj instanceof Throwable) {
                        obj2 = ((Throwable) obj).getMessage();
                    } else {
                        obj2 = obj.toString();
                    }
                    this.f144834a.invoke(obj2);
                }
            }

            public b(com.tencent.luggage.wxa.hn.q0 q0Var, Function1 function1, Function1 function12) {
                this.f144831b = q0Var;
                this.f144832c = function1;
                this.f144833d = function12;
            }

            @Override // java.lang.Runnable
            public final void run() {
                c.this.f144820d.b(i0.f144815b, c.this.f144817a, this.f144831b, com.tencent.luggage.wxa.hn.r0.class).a(new i(this.f144832c)).a(new a(this.f144833d));
            }
        }

        public c(String hostWxaAppId, int i3, List appIds, com.tencent.luggage.wxa.bj.c cgiService) {
            Intrinsics.checkNotNullParameter(hostWxaAppId, "hostWxaAppId");
            Intrinsics.checkNotNullParameter(appIds, "appIds");
            Intrinsics.checkNotNullParameter(cgiService, "cgiService");
            this.f144817a = hostWxaAppId;
            this.f144818b = i3;
            this.f144819c = appIds;
            this.f144820d = cgiService;
            this.f144821e = TimeUnit.MINUTES.toSeconds(5L);
        }

        public final void a(Function1 onLoaded, Function1 onUpdated, Function0 onNoUpdate, Function1 onError) {
            Intrinsics.checkNotNullParameter(onLoaded, "onLoaded");
            Intrinsics.checkNotNullParameter(onUpdated, "onUpdated");
            Intrinsics.checkNotNullParameter(onNoUpdate, "onNoUpdate");
            Intrinsics.checkNotNullParameter(onError, "onError");
            com.tencent.luggage.wxa.zp.h.f146825d.execute(new a(onError, onLoaded, onNoUpdate, onUpdated));
        }

        public final void a(com.tencent.luggage.wxa.bj.c cVar, List list, Function1 function1, Function1 function12) {
            com.tencent.luggage.wxa.hn.q0 q0Var = new com.tencent.luggage.wxa.hn.q0();
            q0Var.f128472e.addAll(list);
            q0Var.f128473f = 107;
            com.tencent.luggage.wxa.yo.d.f146045b.a(new b(q0Var, function1, function12));
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class d extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f144835a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h f144836b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(int i3, h hVar) {
            super(1);
            this.f144835a = i3;
            this.f144836b = hVar;
        }

        public final void a(List list) {
            Intrinsics.checkNotNullParameter(list, "list");
            com.tencent.luggage.wxa.tn.w.d("Luggage.FULL.JsApiBatchGetContact", "Loader(" + this.f144835a + ").onLoaded, list.size:" + list.size());
            this.f144836b.apply(list);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((List) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class e extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f144837a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h f144838b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ WeakReference f144839c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f144840d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(int i3, h hVar, WeakReference weakReference, String str) {
            super(1);
            this.f144837a = i3;
            this.f144838b = hVar;
            this.f144839c = weakReference;
            this.f144840d = str;
        }

        public final void a(List list) {
            Intrinsics.checkNotNullParameter(list, "list");
            com.tencent.luggage.wxa.tn.w.d("Luggage.FULL.JsApiBatchGetContact", "Loader(" + this.f144837a + ").onUpdated, list.size:" + list.size());
            if (!this.f144838b.apply(list).booleanValue()) {
                b.f144816a.a((com.tencent.luggage.wxa.ic.d) this.f144839c.get(), list, this.f144840d);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((List) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class f extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f144841a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ WeakReference f144842b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f144843c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(int i3, WeakReference weakReference, String str) {
            super(0);
            this.f144841a = i3;
            this.f144842b = weakReference;
            this.f144843c = str;
        }

        public final void a() {
            com.tencent.luggage.wxa.tn.w.d("Luggage.FULL.JsApiBatchGetContact", "Loader(" + this.f144841a + ").onNoUpdate");
            b.f144816a.a((com.tencent.luggage.wxa.ic.d) this.f144842b.get(), null, this.f144843c);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class g extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f144844a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ WeakReference f144845b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ i0 f144846c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(int i3, WeakReference weakReference, i0 i0Var) {
            super(1);
            this.f144844a = i3;
            this.f144845b = weakReference;
            this.f144846c = i0Var;
        }

        public final void a(String str) {
            boolean z16;
            String str2;
            com.tencent.luggage.wxa.tn.w.b("Luggage.FULL.JsApiBatchGetContact", "Loader(" + this.f144844a + ").onError, errMsg:" + str);
            com.tencent.luggage.wxa.ic.d dVar = (com.tencent.luggage.wxa.ic.d) this.f144845b.get();
            if (dVar != null) {
                int i3 = this.f144844a;
                i0 i0Var = this.f144846c;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("fail");
                if (str != null && str.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (z16) {
                    str2 = "";
                } else {
                    str2 = ':' + str;
                }
                sb5.append(str2);
                dVar.a(i3, i0Var.makeReturnJson(sb5.toString()));
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((String) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class h implements Function {

        /* renamed from: a, reason: collision with root package name */
        public boolean f144847a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ WeakReference f144848b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f144849c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ i0 f144850d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f144851e;

        public h(WeakReference weakReference, int i3, i0 i0Var, String str) {
            this.f144848b = weakReference;
            this.f144849c = i3;
            this.f144850d = i0Var;
            this.f144851e = str;
        }

        @Override // androidx.arch.core.util.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean apply(List input) {
            boolean z16;
            Intrinsics.checkNotNullParameter(input, "input");
            if (!this.f144847a) {
                try {
                    com.tencent.luggage.wxa.ic.d dVar = (com.tencent.luggage.wxa.ic.d) this.f144848b.get();
                    if (dVar != null) {
                        int i3 = this.f144849c;
                        i0 i0Var = this.f144850d;
                        JSONObject jSONObject = new JSONObject();
                        String str = this.f144851e;
                        jSONObject.put("contactList", i0.f144814a.a(input));
                        jSONObject.put("callbackId", str);
                        Unit unit = Unit.INSTANCE;
                        dVar.a(i3, i0Var.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, jSONObject));
                    }
                } catch (JSONException unused) {
                    com.tencent.luggage.wxa.ic.d dVar2 = (com.tencent.luggage.wxa.ic.d) this.f144848b.get();
                    if (dVar2 != null) {
                        dVar2.a(this.f144849c, this.f144850d.makeReturnJson("fail: toJson fail"));
                    }
                }
                z16 = true;
                this.f144847a = true;
            } else {
                z16 = false;
            }
            return Boolean.valueOf(z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class i implements e.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f144852a;

        public i(Function1 function1) {
            this.f144852a = function1;
        }

        @Override // com.tencent.luggage.wxa.xo.e.c
        public final /* synthetic */ void a(Object obj) {
            this.f144852a.invoke(obj);
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(com.tencent.luggage.wxa.ic.d dVar, JSONObject jSONObject, int i3) {
        boolean z16;
        if (dVar == null) {
            return;
        }
        if (jSONObject == null) {
            dVar.a(i3, makeReturnJson("fail:invalid data"));
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("appIds");
        if (optJSONArray != null) {
            LinkedList linkedList = new LinkedList();
            int length = optJSONArray.length();
            int i16 = 0;
            while (true) {
                String str = null;
                if (i16 >= length) {
                    break;
                }
                Object opt = optJSONArray.opt(i16);
                if (opt != null && !Intrinsics.areEqual(JSONObject.NULL, opt)) {
                    str = opt.toString();
                }
                if (str != null && str.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    linkedList.add(str);
                }
                i16++;
            }
            if (linkedList.isEmpty()) {
                linkedList = null;
            }
            if (linkedList != null) {
                String uuid = UUID.randomUUID().toString();
                Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
                com.tencent.luggage.wxa.bj.c cVar = (com.tencent.luggage.wxa.bj.c) dVar.b(com.tencent.luggage.wxa.bj.c.class);
                if (cVar == null) {
                    dVar.a(i3, makeReturnJson("fail:internal error"));
                    return;
                }
                WeakReference weakReference = new WeakReference(dVar);
                h hVar = new h(weakReference, i3, this, uuid);
                com.tencent.luggage.wxa.tn.w.d("Luggage.FULL.JsApiBatchGetContact", "Loader(" + i3 + ").load(), hostWxaAppId[" + dVar.getAppId() + "], eventCallbackId[" + uuid + "] appIds[" + StringUtils.join(linkedList.iterator(), ",") + ']');
                String appId = dVar.getAppId();
                Intrinsics.checkNotNullExpressionValue(appId, "env.appId");
                new c(appId, i3, linkedList, cVar).a(new d(i3, hVar), new e(i3, hVar, weakReference, uuid), new f(i3, weakReference, uuid), new g(i3, weakReference, this));
                return;
            }
        }
        dVar.a(i3, makeReturnJson("fail:appIds is empty"));
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public boolean dispatchInJsThread() {
        return true;
    }
}
