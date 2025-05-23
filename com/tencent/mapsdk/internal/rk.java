package com.tencent.mapsdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.map.tools.json.JsonUtils;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.mapsdk.internal.cg;
import com.tencent.mapsdk.internal.ci;
import com.tencent.mapsdk.internal.hr;
import com.tencent.mapsdk.internal.kv;
import com.tencent.mapsdk.internal.qa;
import com.tencent.mapsdk.internal.qb;
import com.tencent.mapsdk.vector.VectorMap;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class rk extends bo implements cf, ft, oz, qa.b {

    /* renamed from: c, reason: collision with root package name */
    private static final String f150052c = "PromoteImage";

    /* renamed from: d, reason: collision with root package name */
    private static final String f150053d = "promote-image-enable";

    /* renamed from: e, reason: collision with root package name */
    private static final String f150054e = "promote-image-max-zoom";

    /* renamed from: f, reason: collision with root package name */
    private static final String f150055f = "promote-image-min-zoom";

    /* renamed from: g, reason: collision with root package name */
    private static final int f150056g = 22;

    /* renamed from: h, reason: collision with root package name */
    private static final int f150057h = 15;

    /* renamed from: b, reason: collision with root package name */
    int f150058b = a.f150071a;

    /* renamed from: i, reason: collision with root package name */
    private boolean f150059i;

    /* renamed from: m, reason: collision with root package name */
    private int f150060m;

    /* renamed from: n, reason: collision with root package name */
    private int f150061n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f150062o;

    /* renamed from: p, reason: collision with root package name */
    private SharedPreferences f150063p;

    /* renamed from: q, reason: collision with root package name */
    private CameraPosition f150064q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f150065r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f150066s;

    /* renamed from: t, reason: collision with root package name */
    private ci f150067t;

    /* renamed from: u, reason: collision with root package name */
    private cg f150068u;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final int f150071a = 1;

        /* renamed from: b, reason: collision with root package name */
        public static final int f150072b = 2;

        /* renamed from: c, reason: collision with root package name */
        public static final int f150073c = 3;

        /* renamed from: d, reason: collision with root package name */
        public static final int f150074d = 4;

        /* renamed from: e, reason: collision with root package name */
        public static final int f150075e = 5;

        /* renamed from: f, reason: collision with root package name */
        private static final /* synthetic */ int[] f150076f = {1, 2, 3, 4, 5};

        a(String str, int i3) {
        }

        private static int[] a() {
            return (int[]) f150076f.clone();
        }
    }

    private int l() {
        return this.f150058b;
    }

    private void m() {
        if (this.f150068u == null) {
            this.f150068u = new rj(this);
        }
    }

    private void n() {
        if (this.f150067t == null) {
            this.f150067t = new rl(this);
        }
    }

    @Override // com.tencent.mapsdk.internal.bo
    public final synchronized void c_() {
        super.c_();
        h();
        i();
        this.f150066s = true;
        LogUtil.b(f150052c, "onDestroy...");
    }

    @Override // com.tencent.mapsdk.internal.cf
    public final void e() {
        if (this.f150059i) {
            int i3 = this.f150058b;
            if (i3 == a.f150071a || i3 == a.f150075e) {
                LogUtil.b(f150052c, "startWatchingCamera");
                new ci.b();
                n();
                new cg.a();
                m();
                this.f150058b = a.f150072b;
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.cf
    public final void f() {
        bb bbVar;
        int i3 = this.f150058b;
        if (i3 == a.f150072b || i3 == a.f150074d) {
            LogUtil.b(f150052c, "resumeWatchingCamera");
            bp mapContext = getMapContext();
            if (mapContext == null || (bbVar = (bb) mapContext.f147916c) == null) {
                return;
            }
            VectorMap map = bbVar.getMap();
            if (map == null) {
                LogUtil.e(f150052c, "resumeWatchingCamera tencentMap null.");
            } else {
                if (map.getCameraPosition() == null) {
                    return;
                }
                a(this.f150067t, this.f150068u);
                ((ne) mapContext).a(this);
                map.a((ft) this);
                this.f150058b = a.f150073c;
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.cf
    public final void g() {
        bb bbVar;
        boolean z16;
        if (this.f150058b == a.f150073c) {
            LogUtil.b(f150052c, "notifyUpdate");
            bp mapContext = getMapContext();
            if (mapContext == null || (bbVar = (bb) mapContext.f147916c) == null) {
                return;
            }
            VectorMap map = bbVar.getMap();
            if (map == null) {
                LogUtil.e(f150052c, "notifyUpdate tencentMap null.");
                return;
            }
            CameraPosition cameraPosition = map.getCameraPosition();
            if (cameraPosition == null) {
                return;
            }
            float f16 = cameraPosition.zoom;
            if (f16 >= this.f150061n && f16 <= this.f150060m) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && (!cameraPosition.equals(this.f150064q) || this.f150065r)) {
                if (this.f150068u != null) {
                    LogUtil.b(f150052c, "notifyUpdate to Layer");
                    this.f150068u.a(cameraPosition, this.f150062o);
                }
                if (this.f150067t != null) {
                    LogUtil.b(f150052c, "notifyUpdate to TileCache");
                    this.f150067t.a(cameraPosition, this.f150062o, this.f150061n, this.f150060m);
                }
                this.f150064q = cameraPosition;
                return;
            }
            LogUtil.b(f150052c, "the current position level[" + cameraPosition.zoom + "] is not in valid level range");
        }
    }

    @Override // com.tencent.mapsdk.internal.cf
    public final void h() {
        int i3 = this.f150058b;
        if (i3 == a.f150072b || i3 == a.f150073c) {
            LogUtil.b(f150052c, "pauseWatchingCamera");
            ne neVar = (ne) getMapContext();
            if (neVar != null) {
                neVar.b(this);
            }
            this.f150058b = a.f150074d;
        }
    }

    @Override // com.tencent.mapsdk.internal.cf
    public final void i() {
        int i3 = this.f150058b;
        if (i3 == a.f150072b || i3 == a.f150073c || i3 == a.f150074d) {
            LogUtil.b(f150052c, "stopWatchingCamera");
            this.f150058b = a.f150075e;
            this.f150068u.c();
            this.f150067t.a();
        }
    }

    @Override // com.tencent.mapsdk.internal.oz
    public final void k() {
        LogUtil.b(f150052c, "onMapCameraChangeStopped");
        g();
    }

    @Override // com.tencent.mapsdk.internal.cf
    public final cg m_() {
        return this.f150068u;
    }

    @Override // com.tencent.mapsdk.internal.bo
    public final void a(Context context) {
        super.a(context);
        LogUtil.b(f150052c, "onCreate");
    }

    @Override // com.tencent.mapsdk.internal.bo
    public final void b(bp bpVar) {
        super.b(bpVar);
        h();
    }

    @Override // com.tencent.mapsdk.internal.bo
    public final void c(bp bpVar) {
        super.c(bpVar);
        f();
    }

    @Override // com.tencent.mapsdk.internal.bo
    public final synchronized void d(bp bpVar) {
        super.d(bpVar);
        LogUtil.b(f150052c, "onUnregistered");
        if (bpVar == null) {
            return;
        }
        bb bbVar = (bb) bpVar.f147916c;
        if (bbVar != null) {
            bbVar.b(this);
        }
        ((ne) bpVar).b(this);
    }

    @Override // com.tencent.mapsdk.internal.bo
    public final synchronized void a(bp bpVar) {
        super.a(bpVar);
        if (bpVar == null) {
            return;
        }
        this.f150066s = false;
        LogUtil.b(f150052c, "onRegistered");
        SharedPreferences a16 = kv.a(c(), bpVar.D().c());
        this.f150063p = a16;
        this.f150059i = a16.getBoolean(f150053d, false);
        this.f150060m = Math.min(22, this.f150063p.getInt(f150054e, 22));
        this.f150061n = Math.max(15, this.f150063p.getInt(f150055f, 15));
        bb bbVar = (bb) bpVar.f147916c;
        if (bbVar != null) {
            bbVar.a(this);
        }
        if (this.f150059i) {
            e();
        }
    }

    @Override // com.tencent.mapsdk.internal.ft
    public final void i(int i3) {
        boolean m3;
        bp mapContext = getMapContext();
        if (mapContext == null || this.f150062o == (m3 = mapContext.m())) {
            return;
        }
        this.f150062o = m3;
        this.f150065r = true;
        LogUtil.b(f150052c, "onStyleChanged isDarkMode ? ".concat(String.valueOf(m3)));
        g();
    }

    @Override // com.tencent.mapsdk.internal.cf
    public final ci d() {
        return this.f150067t;
    }

    @Override // com.tencent.mapsdk.internal.cf
    public final boolean a() {
        return this.f150059i;
    }

    private static void a(ci ciVar, cg cgVar) {
        cgVar.a();
        ciVar.a(cgVar);
    }

    @Override // com.tencent.mapsdk.internal.cf
    public final List<ce> a(String str) {
        try {
            return hr.a((Iterable) JsonUtils.parseToList(new JSONObject(str).optJSONArray("data"), ri.class, new Object[0]), (hr.h) new hr.h<ri, ce>() { // from class: com.tencent.mapsdk.internal.rk.1
                @Override // com.tencent.mapsdk.internal.hr.h
                public final /* synthetic */ ce a(ri riVar) {
                    int i3;
                    int i16;
                    int i17;
                    int i18;
                    ri riVar2 = riVar;
                    if (riVar2.b().latitude != 0.0d && riVar2.b().longitude != 0.0d && Integer.parseInt(riVar2.f150033g) >= Integer.parseInt(riVar2.f150034h) && !hs.a(riVar2.f150027a) && !hs.a(riVar2.f150032f) && (i3 = riVar2.f150030d) > 0 && (i16 = riVar2.f150031e) > 0 && i3 <= 32 && i16 <= 32 && i3 % 4 == 0 && i16 % 4 == 0 && (i17 = riVar2.f150028b) <= (i18 = riVar2.f150029c) && i18 <= rk.this.f150060m && i17 >= rk.this.f150061n) {
                        return riVar2;
                    }
                    return null;
                }

                /* renamed from: a, reason: avoid collision after fix types in other method */
                private ce a2(ri riVar) {
                    int i3;
                    int i16;
                    int i17;
                    int i18;
                    if (riVar.b().latitude != 0.0d && riVar.b().longitude != 0.0d && Integer.parseInt(riVar.f150033g) >= Integer.parseInt(riVar.f150034h) && !hs.a(riVar.f150027a) && !hs.a(riVar.f150032f) && (i3 = riVar.f150030d) > 0 && (i16 = riVar.f150031e) > 0 && i3 <= 32 && i16 <= 32 && i3 % 4 == 0 && i16 % 4 == 0 && (i17 = riVar.f150028b) <= (i18 = riVar.f150029c) && i18 <= rk.this.f150060m && i17 >= rk.this.f150061n) {
                        return riVar;
                    }
                    return null;
                }
            });
        } catch (JSONException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    @Override // com.tencent.mapsdk.internal.cf
    public final BitmapDescriptor a(ce ceVar, byte[] bArr, boolean z16, boolean z17) {
        cg cgVar = this.f150068u;
        if (cgVar != null) {
            return cgVar.a(ceVar, bArr, z16, z17);
        }
        return null;
    }

    @Override // com.tencent.mapsdk.internal.oz
    public final void j() {
    }

    private void a(int i3) {
        this.f150058b = i3;
    }

    private boolean a(CameraPosition cameraPosition) {
        float f16 = cameraPosition.zoom;
        return f16 >= ((float) this.f150061n) && f16 <= ((float) this.f150060m);
    }

    @Override // com.tencent.mapsdk.internal.qa.b
    public final void a(qb.b bVar) {
        JSONObject jSONObject;
        if (bVar == null || (jSONObject = bVar.f149771g) == null) {
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("wechat_logo");
        LogUtil.b(f150052c, "onMapAuthoritySuccess... : ".concat(String.valueOf(optJSONObject)));
        if (optJSONObject != null) {
            this.f150059i = optJSONObject.optInt("enable", 0) == 1;
            kv.a a16 = kv.a(this.f150063p);
            a16.f149086a.putBoolean(f150053d, this.f150059i);
            a16.f149086a.commit();
            this.f150060m = optJSONObject.optInt("zoom_max", 22);
            kv.a(this.f150063p).a(f150054e, this.f150060m);
            this.f150061n = Math.max(optJSONObject.optInt("zoom_min", 15), 15);
            kv.a(this.f150063p).a(f150055f, this.f150061n);
            LogUtil.b(f150052c, "thisFeatureZoom : [" + this.f150061n + "~" + this.f150060m + "]");
        }
        kp.a(new Runnable() { // from class: com.tencent.mapsdk.internal.rk.2
            @Override // java.lang.Runnable
            public final void run() {
                if (rk.this.f150066s) {
                    return;
                }
                if (rk.this.f150059i) {
                    rk.this.e();
                    rk.this.f();
                    rk.this.g();
                } else {
                    rk.this.h();
                    rk.this.i();
                }
            }
        });
    }

    @Override // com.tencent.mapsdk.internal.qa.b
    public final void a(int i3, String str) {
        LogUtil.b(f150052c, "onMapAuthorityFail... code:" + i3 + " msg:" + str);
        i();
    }
}
