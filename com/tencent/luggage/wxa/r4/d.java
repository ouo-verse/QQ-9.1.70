package com.tencent.luggage.wxa.r4;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import com.tencent.luggage.wxa.ic.r0;
import com.tencent.luggage.wxa.m4.c;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.uk.n0;
import com.tencent.luggage.wxa.xd.d;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.LinkedList;
import java.util.Map;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.joor.Reflect;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d extends com.tencent.luggage.wxa.ic.l implements com.tencent.luggage.wxa.xi.e, com.tencent.luggage.wxa.m4.c {
    public static final String[] W = {"onAppEnterForeground", "onAppEnterBackground", "onSkylineGlobalReady", "onSkylineWindowReady", "requireRenderContext", com.tencent.luggage.wxa.c3.a.NAME, "onAppRoute", "onAppRouteDone"};
    public final f T;
    public com.tencent.luggage.wxa.dk.a U = com.tencent.luggage.wxa.dk.a.CreateOnRuntimeInit;
    public final LinkedList V = new LinkedList();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends com.tencent.luggage.wxa.kj.i {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.kj.i
        public void a(com.tencent.luggage.wxa.ic.g gVar, boolean z16, JSONObject jSONObject) {
            super.a(gVar, z16, jSONObject);
            com.tencent.luggage.wxa.ck.d.a(d.this.getRuntime(), jSONObject, z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b extends com.tencent.luggage.wxa.kj.h {
        public b() {
        }

        @Override // com.tencent.luggage.wxa.xd.p, com.tencent.luggage.wxa.xd.k0
        /* renamed from: a */
        public com.tencent.luggage.wxa.xd.p setData(Map map) {
            JSONObject jSONObject = new JSONObject(map);
            com.tencent.luggage.wxa.ck.d.a((com.tencent.luggage.wxa.ic.g) d.this.getRuntime(), jSONObject);
            super.setData(jSONObject.toString());
            return this;
        }
    }

    public d(@NonNull Function<d, ? extends f> function) {
        f apply = function.apply(this);
        this.T = apply;
        apply.O();
    }

    @Override // com.tencent.luggage.wxa.ic.l
    public com.tencent.luggage.wxa.kj.i F() {
        return new a();
    }

    @Override // com.tencent.luggage.wxa.ic.l
    public JSONObject I() {
        boolean z16;
        JSONObject I = super.I();
        a(I, "appType", Integer.valueOf(getRuntime().S().I));
        a(I, "debug", Boolean.valueOf(getRuntime().j0().F));
        a(I, "relaunchForProfile", Boolean.valueOf(getRuntime().H));
        d(I);
        int[] a16 = n0.a((com.tencent.luggage.wxa.xd.i) this);
        a(I, "screenWidth", Integer.valueOf(com.tencent.luggage.wxa.tk.g.a(getContext(), a16[0])));
        a(I, "screenHeight", Integer.valueOf(com.tencent.luggage.wxa.tk.g.a(getContext(), a16[1])));
        a(I, "supportAsyncGetSystemInfo", Boolean.TRUE);
        if (getRuntime().S().G0 == com.tencent.luggage.wxa.v4.i.PRE_RENDER) {
            z16 = true;
        } else {
            z16 = false;
        }
        a(I, "prerender", Boolean.valueOf(z16));
        a(I, "instanceId", getRuntime().S().k());
        String c16 = getRuntime().j0().c();
        if (!TextUtils.isEmpty(c16)) {
            try {
                a(I, "opConfig", new JSONObject(c16));
            } catch (Exception e16) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.AppBrandServiceLU", "generateWxConfig() put wxConfig.opConfig, exception=%s", e16);
            }
        }
        I.remove(QCircleDaTongConstant.ElementParamValue.PERMISSION);
        I.remove("navigateToMiniProgramAppIdList");
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.AppBrandServiceLU", "generateWxConfig(%s): %s", getAppId(), I.toString());
        return I;
    }

    @Override // com.tencent.luggage.wxa.ic.l
    public String K() {
        return "https://lib/";
    }

    @Override // com.tencent.luggage.wxa.ic.l
    public String M() {
        return "https://usr/";
    }

    @Override // com.tencent.luggage.wxa.ic.l
    public final void O() {
        super.O();
        this.T.F();
        U();
    }

    @Override // com.tencent.luggage.wxa.ic.l
    public boolean Q() {
        f fVar = this.T;
        if (fVar != null && fVar.J()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.ic.l
    public boolean S() {
        return !(g0() instanceof q);
    }

    @Override // com.tencent.luggage.wxa.ic.l
    public void V() {
        if (z()) {
            r0.a(this, getJsRuntime());
        }
        this.T.P();
    }

    @Override // com.tencent.luggage.wxa.ic.l
    public void W() {
        this.T.Q();
    }

    @Override // com.tencent.luggage.wxa.ic.l
    public final void X() {
        new b().a(getRuntime());
        this.T.R();
    }

    public void a(c.a aVar, boolean z16, long j3, long j16, Object obj) {
    }

    @Override // com.tencent.luggage.wxa.ic.l
    public void b(com.tencent.luggage.wxa.ic.g gVar) {
        super.b(gVar);
        a(b0());
        this.T.b(gVar);
    }

    public d.c b0() {
        return new com.tencent.luggage.wxa.ic.c(getRuntime(), this, getRuntime().B1());
    }

    @Override // com.tencent.luggage.wxa.ic.l
    public final void c(boolean z16) {
        super.c(z16);
        this.T.S();
    }

    @Override // com.tencent.luggage.wxa.ic.l
    /* renamed from: c0, reason: merged with bridge method [inline-methods] */
    public com.tencent.luggage.wxa.em.a G() {
        return new com.tencent.luggage.wxa.em.a(this);
    }

    public void d(JSONObject jSONObject) {
        h0().b(jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject("appLaunchInfo");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
            a(jSONObject, "appLaunchInfo", optJSONObject);
        }
        if (com.tencent.luggage.wxa.v4.i.HEADLESS == getRuntime().S().G0) {
            a(optJSONObject, "inBackground", Boolean.TRUE);
        }
        a(optJSONObject, "openId", getRuntime().j0().f130834j0);
        if (getRuntime().S().H0 != null && getRuntime().S().H0.a()) {
            a(jSONObject, "serverMode", getRuntime().S().H0.b());
        }
        if (j0()) {
            JSONObject optJSONObject2 = jSONObject.optJSONObject("nativeFeatures");
            if (optJSONObject2 == null) {
                optJSONObject2 = new JSONObject();
                a(jSONObject, "nativeFeatures", optJSONObject2);
            }
            a(optJSONObject2, "batchLoadSubPackage", Boolean.TRUE);
        }
    }

    public final void d0() {
        super.E();
    }

    @Override // com.tencent.luggage.wxa.ic.l
    public String e(String str) {
        String c16 = this.T.c(str);
        return w0.c(c16) ? super.e(str) : c16;
    }

    public final com.tencent.luggage.wxa.dk.a e0() {
        return this.U;
    }

    @Override // com.tencent.luggage.wxa.ic.l
    public boolean f(String str) {
        if (!StringUtils.equals(str, "onSubPackageReady") && !StringUtils.equals(str, "requireRenderContext") && !StringUtils.equals(str, "onWxServiceInit")) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.luggage.wxa.ic.l
    /* renamed from: f0, reason: merged with bridge method [inline-methods] */
    public com.tencent.luggage.wxa.m4.b J() {
        return (com.tencent.luggage.wxa.m4.b) super.f(com.tencent.luggage.wxa.m4.b.class);
    }

    @Override // com.tencent.luggage.wxa.ic.l, com.tencent.luggage.wxa.xd.e
    public final Map g() {
        return this.T.q();
    }

    public final f g0() {
        return this.T;
    }

    public final Object h(Class cls) {
        if (cls.isInstance(this)) {
            return cls.cast(this);
        }
        if (cls.isInstance(this.T)) {
            return cls.cast(this.T);
        }
        return cls.cast(this.T.a(cls));
    }

    public f h0() {
        return this.T;
    }

    @Override // com.tencent.luggage.wxa.ic.l, com.tencent.luggage.wxa.xd.i
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public com.tencent.luggage.wxa.c5.e getRuntime() {
        return (com.tencent.luggage.wxa.c5.e) super.getRuntime();
    }

    @Override // com.tencent.luggage.wxa.ic.l, com.tencent.luggage.wxa.xd.e
    public com.tencent.luggage.wxa.ei.j j() {
        com.tencent.luggage.wxa.ei.j v3 = this.T.v();
        if (v3 == null) {
            return super.j();
        }
        return v3;
    }

    public boolean j0() {
        return true;
    }

    @Override // com.tencent.luggage.wxa.xd.e
    public final void t() {
        this.T.U();
        while (!this.V.isEmpty()) {
            ((Runnable) this.V.poll()).run();
        }
    }

    @Override // com.tencent.luggage.wxa.ic.l, com.tencent.luggage.wxa.xd.j
    public JSONObject x() {
        JSONObject x16 = super.x();
        a(x16, "envPreloadType", Integer.valueOf(this.U.ordinal()));
        return x16;
    }

    @Override // com.tencent.luggage.wxa.ic.l, com.tencent.luggage.wxa.xd.j
    public void a(JSONObject jSONObject) {
        super.a(jSONObject);
        this.T.a(jSONObject);
        a(jSONObject, "isIsolateContext", Boolean.valueOf(this.T.L()));
        a(jSONObject, "version", com.tencent.luggage.wxa.tn.f.a(null, com.tencent.luggage.wxa.tn.e.f141563e));
        a(jSONObject, IjkMediaMeta.IJKM_KEY_LANGUAGE, com.tencent.luggage.wxa.tn.u.a(getContext()));
        if (i() instanceof com.tencent.luggage.wxa.mc.a) {
            ((com.tencent.luggage.wxa.mc.a) i()).x().a(jSONObject);
        }
        a(jSONObject, "supportInvokeWithAppId", Boolean.TRUE);
    }

    @Override // com.tencent.luggage.wxa.ic.l, com.tencent.luggage.wxa.xd.j
    public void b(JSONObject jSONObject) {
        new u().a(jSONObject);
    }

    @Override // com.tencent.luggage.wxa.ic.l, com.tencent.luggage.wxa.xd.e
    public final void e() {
        com.tencent.luggage.wxa.ee.a c16 = com.tencent.luggage.wxa.zd.c.INSTANCE.c(getAppId());
        if (c16 != null) {
            c16.a();
        }
        this.T.u();
        super.e();
        this.T.T();
        com.tencent.luggage.wxa.ic.m.a().b(this);
        a((com.tencent.luggage.wxa.wj.c) null);
        e(com.tencent.luggage.wxa.cj.a.class);
    }

    @Override // com.tencent.luggage.wxa.xi.e
    public boolean b(String str) {
        return this.T.b(str);
    }

    public d(@NonNull Class<? extends f> cls) {
        f fVar = (f) Reflect.on((Class<?>) cls).create(this).get();
        this.T = fVar;
        fVar.O();
    }

    @Override // com.tencent.luggage.wxa.xd.e
    public boolean h() {
        com.tencent.luggage.wxa.dk.a aVar = this.U;
        return aVar == com.tencent.luggage.wxa.dk.a.PreloadBeforeRuntimeInit || aVar == com.tencent.luggage.wxa.dk.a.CreateOnRuntimeInit;
    }

    @Override // com.tencent.luggage.wxa.xd.e
    public void a(Map map) {
        for (com.tencent.luggage.wxa.xd.o oVar : map.values()) {
            if (oVar instanceof com.tencent.luggage.wxa.nf.b) {
                ((com.tencent.luggage.wxa.nf.b) oVar).e().a();
            }
        }
        super.a(map);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00e6  */
    @Override // com.tencent.luggage.wxa.ic.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(String str, String str2, int i3, int i16) {
        int i17;
        com.tencent.luggage.wxa.kj.v a16;
        com.tencent.luggage.wxa.kj.p Y;
        boolean contains = ArrayUtils.contains(W, str);
        if (i3 != 0 && getComponentId() != i3) {
            try {
                com.tencent.luggage.wxa.c5.e runtime = getRuntime();
                a16 = (runtime == null || (Y = runtime.Y()) == null) ? null : Y.a(i3, false);
            } catch (Exception e16) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.AppBrandServiceLU", "dispatch %s, serviceId:%d, try replace src with pageId, get exception:%s", str, Integer.valueOf(getComponentId()), e16);
            }
            if (a16 != null && a16.o1()) {
                i17 = a16.c0();
                if (i3 != i17 && contains) {
                    com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.AppBrandServiceLU", "dispatch %s, serviceId:%d, replace src(%d) with pageId(%d)", str, Integer.valueOf(getComponentId()), Integer.valueOf(i3), Integer.valueOf(i17));
                }
                if (contains) {
                    com.tencent.luggage.wxa.j4.d S = getRuntime() != null ? getRuntime().S() : null;
                    if (S != null) {
                        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.AppBrandServiceLU", "dispatch %s, serviceId:%d, src:%d, appId:%s, instanceId:%s, sessionId:%s, data:%s", str, Integer.valueOf(getComponentId()), Integer.valueOf(i17), getAppId(), S.k(), S.j(), str2);
                    } else {
                        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.AppBrandServiceLU", "dispatch %s, serviceId:%d, src:%d, data:%s", str, Integer.valueOf(getComponentId()), Integer.valueOf(i17), str2);
                    }
                }
                if (this.T.a(str, str2, i17, i16)) {
                    super.a(str, str2, i17, i16);
                    return;
                }
                return;
            }
        }
        i17 = i3;
        if (contains) {
        }
        if (this.T.a(str, str2, i17, i16)) {
        }
    }

    @Override // com.tencent.luggage.wxa.xd.e, com.tencent.luggage.wxa.xd.d
    public void a(int i3, String str) {
        if (this.T.b(i3, str)) {
            return;
        }
        super.a(i3, str);
    }
}
