package com.tencent.luggage.wxa.kf;

import com.tencent.luggage.wxa.ic.g;
import com.tencent.luggage.wxa.mc.g0;
import com.tencent.luggage.wxa.r4.h;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.xd.i;
import com.tencent.luggage.wxa.xd.p;
import com.tencent.luggage.wxa.xi.a;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c extends com.tencent.luggage.wxa.nf.b implements e {
    public static final int CTRL_INDEX = 467;
    public static final String NAME = "createLoadSubPackageTask";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements a.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f131960a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f131961b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f131962c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f131963d;

        public a(i iVar, String str, String str2, String str3) {
            this.f131960a = iVar;
            this.f131961b = str;
            this.f131962c = str2;
            this.f131963d = str3;
        }

        @Override // com.tencent.luggage.wxa.xi.a.c
        public /* synthetic */ void a(List list) {
            s41.a.a(this, list);
        }

        @Override // com.tencent.luggage.wxa.xi.a.c
        public void a(a.e eVar) {
            c.this.a(this.f131960a, this.f131961b, eVar, this.f131962c, this.f131963d);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements a.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f131965a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i f131966b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f131967c;

        public b(String str, i iVar, String str2) {
            this.f131965a = str;
            this.f131966b = iVar;
            this.f131967c = str2;
        }

        @Override // com.tencent.luggage.wxa.xi.a.b
        public void a(g0 g0Var) {
            w.d("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: module name: %s progress: %s", this.f131965a, g0Var.toString());
            d.a(this.f131966b, this.f131967c, "progressUpdate", this.f131965a, g0Var.a(), g0Var.c(), g0Var.b());
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.kf.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class C6382c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f131969a;

        static {
            int[] iArr = new int[a.e.values().length];
            f131969a = iArr;
            try {
                iArr[a.e.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f131969a[a.e.FAIL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f131969a[a.e.MODULE_NOT_FOUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f131969a[a.e.CANCEL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class d extends p {
        public static final int CTRL_INDEX = 468;
        public static final String NAME = "onLoadSubPackageTaskStateChange";

        public static void a(com.tencent.luggage.wxa.xd.d dVar, String str, String str2, String str3) {
            a(dVar, str, str2, str3, -1, -1L, -1L);
        }

        public static void a(com.tencent.luggage.wxa.xd.d dVar, String str, String str2, String str3, int i3, long j3, long j16) {
            i iVar = (i) dVar;
            f fVar = (f) dVar.c(f.class);
            if (fVar == null) {
                fVar = new f(iVar);
            }
            w.d("MicroMsg.JsApiCreateLoadSubPackageTask", "the provided state:" + str2);
            if (fVar.h(str2)) {
                w.d("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: formatEventCallback taskId: %s, state: %s, progress: %d, currentWritten: %d, totalWritten: %d", str, str2, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16));
                HashMap hashMap = new HashMap();
                hashMap.put(MiniAppGetGameTaskTicketServlet.KEY_TASKID, str);
                hashMap.put("state", str2);
                hashMap.put("moduleName", str3);
                if (i3 >= 0) {
                    hashMap.put("progress", Integer.valueOf(i3));
                }
                if (j3 >= 0) {
                    hashMap.put("totalBytesWritten", Long.valueOf(j3));
                }
                if (j16 >= 0) {
                    hashMap.put("totalBytesExpectedToWrite", Long.valueOf(j16));
                }
                JSONObject jSONObject = new JSONObject(hashMap);
                if (StringUtils.equals(str2, "success")) {
                    h.a(dVar, str3, jSONObject);
                }
                new d().setContext(dVar).setData(jSONObject).dispatch();
                return;
            }
            w.d("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: formatEventCallback, but it has not been listened: taskId: %s, state: %s, progress: %d, currentWritten: %d, totalWritten: %d", str, str2, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16));
        }
    }

    @Override // com.tencent.luggage.wxa.ee.h
    public void a(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, String str) {
        i iVar = (i) dVar;
        String appId = dVar.getAppId();
        String optString = jSONObject.optString("moduleName");
        if (w0.c(optString)) {
            w.b("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: null or nil moduleName");
            a(iVar, str, optString);
            return;
        }
        g runtime = iVar.getRuntime();
        if (runtime != null && !runtime.t0()) {
            com.tencent.luggage.wxa.xi.a W = runtime.W();
            if (W == null) {
                w.b("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: modularizingHelper null!");
                a(iVar, str, optString);
                return;
            }
            if (!W.b() && !optString.equals(ModulePkgInfo.MAIN_MODULE_NAME)) {
                w.f("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: not support modularizing but still called JsApiCreateLoadSubPackageTask");
                a(iVar, str, optString);
                return;
            }
            try {
                W.a(optString, new a(iVar, str, appId, optString), new b(optString, iVar, str), false);
                return;
            } catch (IllegalAccessError e16) {
                w.a("MicroMsg.JsApiCreateLoadSubPackageTask", e16, "loadModule(%s)", optString);
                a(iVar, str, optString);
                return;
            } catch (NullPointerException e17) {
                w.a("MicroMsg.JsApiCreateLoadSubPackageTask", e17, "loadModule(%s) npe, isRunning:%b", optString, Boolean.valueOf(dVar.isRunning()));
                a(iVar, str, optString);
                return;
            }
        }
        w.b("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: runtime is not in valid state!");
        a(iVar, str, optString);
    }

    @Override // com.tencent.luggage.wxa.ee.h
    public String b() {
        return a31.a.a() + "";
    }

    @Override // com.tencent.luggage.wxa.ee.h
    public String d() {
        return "loadTaskId";
    }

    public void a(com.tencent.luggage.wxa.xd.d dVar, String str, a.e eVar, String str2, String str3) {
        w.d("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: loadResult: %s, with appId[%s] moduleName[%s]", eVar.toString(), str2, str3);
        int i3 = C6382c.f131969a[eVar.ordinal()];
        if (i3 == 1) {
            d.a(dVar, str, "success", str3);
            return;
        }
        if (i3 == 2 || i3 == 3) {
            d.a(dVar, str, "fail", str3);
        } else {
            if (i3 != 4) {
                return;
            }
            w.f("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: should not happen cancel!!");
            d.a(dVar, str, "fail", str3);
        }
    }

    public final void a(com.tencent.luggage.wxa.xd.d dVar, String str, String str2) {
        d.a(dVar, str, "fail", str2);
    }
}
