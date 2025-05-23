package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.map.tools.CallbackRunnable;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.mapsdk.internal.ac;
import com.tencent.mapsdk.internal.ae;
import com.tencent.mapsdk.internal.bm;
import com.tencent.mapsdk.internal.fa;
import com.tencent.mapsdk.internal.hn;
import com.tencent.mapsdk.internal.ne;
import com.tencent.mapsdk.internal.qh;
import com.tencent.mapsdk.internal.sj;
import com.tencent.mapsdk.internal.th;
import com.tencent.mapsdk.internal.tk;
import com.tencent.mapsdk.internal.tz;
import com.tencent.mapsdk.vector.VectorMap;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdate;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.maps.model.CamerParameter;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.CustomLayer;
import com.tencent.tencentmap.mapsdk.maps.model.CustomLayerOptions;
import com.tencent.tencentmap.mapsdk.maps.model.IOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorBuilding;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorLevel;
import com.tencent.tencentmap.mapsdk.maps.model.Language;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import com.tencent.tencentmap.mapsdk.maps.model.MapPoi;
import com.tencent.tencentmap.mapsdk.maps.model.MapRouteSection;
import com.tencent.tencentmap.mapsdk.maps.model.OverSeaTileProvider;
import com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener;
import com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListenerList;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlayOptions;
import com.tencent.tencentmap.mapsdk.maps.model.VisibleRegion;
import com.tencent.xweb.xwalk.plugin.XWalkReaderBasePlugin;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class bi implements ak, al, an, fp {

    /* renamed from: a, reason: collision with root package name */
    public bw f147818a;

    /* renamed from: b, reason: collision with root package name */
    public volatile tr f147819b;

    /* renamed from: c, reason: collision with root package name */
    public Context f147820c;

    /* renamed from: d, reason: collision with root package name */
    public bm f147821d;

    /* renamed from: e, reason: collision with root package name */
    public rr f147822e;

    /* renamed from: f, reason: collision with root package name */
    public qh f147823f;

    /* renamed from: g, reason: collision with root package name */
    public qu f147824g;

    /* renamed from: h, reason: collision with root package name */
    CameraPosition f147825h;

    /* renamed from: j, reason: collision with root package name */
    fa f147827j;

    /* renamed from: m, reason: collision with root package name */
    private String f147830m;

    /* renamed from: o, reason: collision with root package name */
    private re f147832o;

    /* renamed from: x, reason: collision with root package name */
    private float f147841x;

    /* renamed from: n, reason: collision with root package name */
    private qa f147831n = null;

    /* renamed from: p, reason: collision with root package name */
    private final GeoPoint f147833p = null;

    /* renamed from: q, reason: collision with root package name */
    private final GeoPoint f147834q = null;

    /* renamed from: r, reason: collision with root package name */
    private int f147835r = 0;

    /* renamed from: s, reason: collision with root package name */
    private int f147836s = 0;

    /* renamed from: t, reason: collision with root package name */
    private int f147837t = 0;

    /* renamed from: u, reason: collision with root package name */
    private int f147838u = 0;

    /* renamed from: i, reason: collision with root package name */
    final byte[] f147826i = new byte[0];

    /* renamed from: v, reason: collision with root package name */
    private int f147839v = 0;

    /* renamed from: w, reason: collision with root package name */
    private int f147840w = 1000;

    /* renamed from: y, reason: collision with root package name */
    private final b f147842y = new b(false);

    /* renamed from: z, reason: collision with root package name */
    private final b f147843z = new b(true);
    private ae.a A = new ae.a() { // from class: com.tencent.mapsdk.internal.bi.1
        @Override // com.tencent.mapsdk.internal.ae.a
        public final void a(jn jnVar) {
            tr trVar;
            VectorMap vectorMap;
            boolean z16;
            if (jnVar.f148935z != 10000 || !(jnVar instanceof th) || (trVar = bi.this.f147819b) == null || (vectorMap = (VectorMap) trVar.e_) == null) {
                return;
            }
            th thVar = (th) jnVar;
            if (thVar.Q) {
                vectorMap.b((trVar.f151030aj / 2) - thVar.R, (trVar.f151031ak / 2) - thVar.S);
            }
            if (thVar.f150488h) {
                vectorMap.b(thVar.K, thVar.L);
            }
            if (!thVar.N && !thVar.M && !thVar.O) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                vectorMap.f151351o.f149398k.a((float) thVar.P);
            }
            if (thVar.T) {
                int i3 = thVar.f150458aa;
                int i16 = thVar.f150459ab;
                vectorMap.a(i3, i16);
                if (thVar.f150487g) {
                    trVar.b(i3, i16);
                }
            }
            if (thVar.f150460ac) {
                vectorMap.b(thVar.f150464ag);
            }
            if (thVar.f150465ah) {
                vectorMap.a(thVar.f150469al);
            }
            if (thVar.Q) {
                vectorMap.b(thVar.R - (trVar.f151030aj / 2), thVar.S - (trVar.f151031ak / 2));
            }
        }
    };

    /* renamed from: k, reason: collision with root package name */
    public final th.a f147828k = new th.a() { // from class: com.tencent.mapsdk.internal.bi.2
        @Override // com.tencent.mapsdk.internal.th.a
        public final float a() {
            if (bi.this.f147819b == null) {
                return 0.0f;
            }
            return ((VectorMap) bi.this.f147819b.e_).t();
        }

        @Override // com.tencent.mapsdk.internal.th.a
        public final int b() {
            if (bi.this.f147819b == null) {
                return 0;
            }
            return ((VectorMap) bi.this.f147819b.e_).q();
        }

        @Override // com.tencent.mapsdk.internal.th.a
        public final GeoPoint c() {
            if (bi.this.f147819b == null) {
                return null;
            }
            return ((VectorMap) bi.this.f147819b.e_).r();
        }

        @Override // com.tencent.mapsdk.internal.th.a
        public final float d() {
            if (bi.this.f147819b == null) {
                return 0.0f;
            }
            return ((VectorMap) bi.this.f147819b.e_).v();
        }

        @Override // com.tencent.mapsdk.internal.th.a
        public final float e() {
            if (bi.this.f147819b == null) {
                return 0.0f;
            }
            return ((VectorMap) bi.this.f147819b.e_).w();
        }

        @Override // com.tencent.mapsdk.internal.th.a
        public final float f() {
            if (bi.this.f147819b == null) {
                return 0.0f;
            }
            return bi.this.D();
        }

        @Override // com.tencent.mapsdk.internal.th.a
        public final GeoPoint g() {
            if (bi.this.f147819b == null) {
                return null;
            }
            return bi.this.f147819b.s();
        }

        @Override // com.tencent.mapsdk.internal.th.a
        public final boolean h() {
            if (bi.this.f147819b == null) {
                return false;
            }
            return bi.this.f147819b.f151058o.f147693f;
        }

        @Override // com.tencent.mapsdk.internal.th.a
        public final void a(Runnable runnable) {
            if (runnable == null || bi.this.f147819b == null) {
                return;
            }
            kp.a(runnable, 100L);
        }
    };

    /* renamed from: l, reason: collision with root package name */
    public fs f147829l = new fs() { // from class: com.tencent.mapsdk.internal.bi.6
        @Override // com.tencent.mapsdk.internal.fs
        public final void u() {
            kp.a(new Runnable() { // from class: com.tencent.mapsdk.internal.bi.6.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (bi.this.f147819b == null) {
                        return;
                    }
                    bi.this.f147819b.a(((VectorMap) bi.this.f147819b.e_).f151351o.f149410w.a());
                }
            });
        }
    };

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface a {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements a {

        /* renamed from: b, reason: collision with root package name */
        private boolean f147859b;

        public b(boolean z16) {
            this.f147859b = z16;
        }

        @Override // com.tencent.mapsdk.internal.bi.a
        public final void a() {
            float a16;
            if (bi.this.f147819b.f151030aj != 0 && bi.this.f147819b.f151031ak != 0) {
                bi.this.f147819b.C = null;
                if (bi.this.f147819b.f151023ac != null && bi.this.f147819b.f151024ad != null) {
                    LatLng latLng = new LatLng(0.0d, 0.0d);
                    if (bi.this.f147819b.f151026af == 0 && bi.this.f147819b.f151027ag == 0 && bi.this.f147819b.f151028ah == 0 && bi.this.f147819b.f151029ai == 0) {
                        bi biVar = bi.this;
                        a16 = biVar.f147827j.a(biVar.f147819b.f151023ac, bi.this.f147819b.f151024ad, 0, 0, 0, 0, latLng);
                    } else {
                        bi biVar2 = bi.this;
                        a16 = biVar2.f147827j.a(biVar2.f147819b.f151023ac, bi.this.f147819b.f151024ad, bi.this.f147819b.f151026af, bi.this.f147819b.f151027ag, bi.this.f147819b.f151028ah, bi.this.f147819b.f151029ai, latLng);
                    }
                    float f16 = a16;
                    TencentMap.CancelableCallback cancelableCallback = bi.this.f147819b.A;
                    if (this.f147859b) {
                        th thVar = new th();
                        thVar.c(0.0f);
                        thVar.d(0.0f);
                        thVar.b((int) (latLng.latitude * 1000000.0d), (int) (latLng.longitude * 1000000.0d));
                        thVar.a(f16);
                        bi biVar3 = bi.this;
                        thVar.f150457a = biVar3.f147828k;
                        thVar.f150486f = cancelableCallback;
                        ((VectorMap) biVar3.f147819b.e_).a(thVar);
                    } else {
                        ((VectorMap) bi.this.f147819b.e_).b(0.0f);
                        ((VectorMap) bi.this.f147819b.e_).a(0.0f);
                        ((VectorMap) bi.this.f147819b.e_).a((int) (latLng.latitude * 1000000.0d), (int) (latLng.longitude * 1000000.0d));
                        bi.this.a(f16, false, 0L, (TencentMap.CancelableCallback) null);
                    }
                    bi.this.f147819b.f151023ac = null;
                    bi.this.f147819b.f151024ad = null;
                    bi.this.f147819b.f151026af = 0;
                    bi.this.f147819b.f151027ag = 0;
                    bi.this.f147819b.f151028ah = 0;
                    bi.this.f147819b.f151029ai = 0;
                    bi.this.f147819b.A = null;
                }
            }
        }
    }

    public bi(bf bfVar, bw bwVar, TencentMapOptions tencentMapOptions) {
        this.f147818a = null;
        this.f147819b = null;
        this.f147820c = null;
        this.f147830m = null;
        this.f147821d = null;
        this.f147832o = null;
        this.f147822e = null;
        this.f147841x = 1.0f;
        Context applicationContext = bfVar.getContext().getApplicationContext();
        this.f147820c = applicationContext;
        this.f147841x = ht.a(applicationContext);
        this.f147818a = bwVar;
        this.f147819b = (tr) bfVar.b();
        if (hn.f148686b != null && hn.a.b() != 0) {
            hn.a.a();
        } else {
            hn.f148686b = new hn.a(this.f147820c, this.f147819b.f147934f, Math.max(10, tencentMapOptions.getMaxIconMemoryCacheSize()) * 1048576);
        }
        this.f147819b.a(this);
        this.f147827j = ((VectorMap) this.f147819b.e_).getProjection();
        ((VectorMap) this.f147819b.e_).f151351o.f149398k.D = this.A;
        ((VectorMap) this.f147819b.e_).a(this.f147829l);
        if (tencentMapOptions != null && !hs.a(tencentMapOptions.getSubKey())) {
            this.f147830m = tencentMapOptions.getSubKey();
        }
        re reVar = this.f147819b.aC.K;
        this.f147832o = reVar;
        this.f147823f = new qh(this.f147820c, reVar, this.f147819b.ac());
        this.f147822e = new rr(this.f147820c, this.f147830m);
        this.f147824g = new qu(this.f147820c, bfVar, this.f147830m);
        if (this.f147821d == null) {
            this.f147821d = new bm(bfVar, this.f147819b.ab(), this.f147818a);
        }
    }

    private bm E() {
        return this.f147821d;
    }

    private rr F() {
        return this.f147822e;
    }

    private qu G() {
        return this.f147824g;
    }

    private qh H() {
        return this.f147823f;
    }

    private void I() {
        if (this.f147819b != null) {
            ((VectorMap) this.f147819b.e_).b(this.f147829l);
            this.f147819b.k();
            this.f147819b = null;
        }
        if (this.f147820c != null) {
            this.f147820c = null;
        }
        hn.a aVar = hn.f148686b;
        if (aVar != null) {
            aVar.c();
        }
    }

    private tr J() {
        return this.f147819b;
    }

    private Context K() {
        return this.f147820c;
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final int A() {
        return this.f147840w;
    }

    @Override // com.tencent.mapsdk.internal.al
    public final VisibleRegion B() {
        Point point = new Point(0, this.f147819b.f151031ak);
        Point point2 = new Point(this.f147819b.f151030aj, this.f147819b.f151031ak);
        Point point3 = new Point(0, 0);
        Point point4 = new Point(this.f147819b.f151030aj, 0);
        LatLng a16 = a(point);
        LatLng a17 = a(point2);
        LatLng a18 = a(point3);
        LatLng a19 = a(point4);
        return new VisibleRegion(a16, a17, a18, a19, LatLngBounds.builder().include(a16).include(a17).include(a18).include(a19).build());
    }

    @Override // com.tencent.mapsdk.internal.an
    public final bw C() {
        return this.f147818a;
    }

    public final float D() {
        return ((VectorMap) this.f147819b.e_).f151351o.f149410w.a();
    }

    @Override // com.tencent.mapsdk.internal.fp
    public final void b(int i3, int i16) {
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final void e() {
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final int f() {
        int m3 = ((ne) this.f147819b.d_).f149398k.m();
        rr rrVar = this.f147822e;
        if (rrVar != null) {
            return rrVar.b(m3);
        }
        return 0;
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final int g() {
        return -1;
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final boolean h() {
        return ((VectorMap) this.f147819b.e_).f151351o.f149407t;
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final void i() {
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final void j() {
        this.f147818a.a();
        bm bmVar = this.f147821d;
        if (bmVar != null) {
            bmVar.j();
        }
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final void m() {
        this.f147818a.c();
        qa qaVar = this.f147831n;
        if (qaVar != null) {
            qaVar.a();
            this.f147831n = null;
        }
        bm bmVar = this.f147821d;
        if (bmVar != null) {
            tr trVar = bmVar.f147893b;
            if (trVar != null) {
                Handler handler = bmVar.f147900i;
                if (handler != null) {
                    handler.removeCallbacksAndMessages(null);
                }
                ((VectorMap) trVar.e_).f151351o.f149398k.b(bmVar);
                trVar.f151039as.remove(bmVar);
                trVar.b((fj) bmVar);
                ViewGroup ab5 = trVar.ab();
                if (ab5 != null) {
                    ab5.removeAllViews();
                }
                Iterator<ew> it = bmVar.f147899h.iterator();
                while (it.hasNext()) {
                    it.next().c();
                }
                bmVar.f147899h.clear();
            }
            this.f147821d = null;
        }
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final void n() {
        this.f147818a.b();
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final String o() {
        return ho.i();
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final Language p() {
        if (this.f147819b == null) {
            return Language.zh;
        }
        VectorMap vectorMap = (VectorMap) this.f147819b.e_;
        if (vectorMap == null) {
            return Language.zh;
        }
        return vectorMap.getLanguage();
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final void q() {
        VectorMap vectorMap;
        if (this.f147819b == null || (vectorMap = (VectorMap) this.f147819b.e_) == null) {
            return;
        }
        vectorMap.clearRouteNameSegments();
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final int r() {
        IndoorBuilding indoorBuilding;
        if (this.f147819b == null || this.f147819b.f151058o == null || (indoorBuilding = this.f147819b.f151058o.f147694g) == null) {
            return -1;
        }
        return indoorBuilding.getActiveLevelIndex();
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final String[] s() {
        ac acVar;
        IndoorBuilding indoorBuilding;
        String[] strArr = null;
        if (this.f147819b != null && this.f147819b.f151058o != null && (indoorBuilding = (acVar = this.f147819b.f151058o).f147694g) != null && indoorBuilding.getLevels() != null && !acVar.f147694g.getLevels().isEmpty()) {
            List<IndoorLevel> levels = acVar.f147694g.getLevels();
            strArr = new String[levels.size()];
            for (int i3 = 0; i3 < levels.size(); i3++) {
                strArr[i3] = levels.get(i3).getName();
            }
        }
        return strArr;
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final String t() {
        if (this.f147819b != null && this.f147819b.f151058o != null) {
            IndoorBuilding indoorBuilding = this.f147819b.f151058o.f147694g;
            if (indoorBuilding == null) {
                return "";
            }
            return indoorBuilding.getBuildingName();
        }
        return null;
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final IndoorBuilding u() {
        if (this.f147819b != null && this.f147819b.f151058o != null) {
            return this.f147819b.f151058o.f147694g;
        }
        return null;
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final String v() {
        IndoorBuilding indoorBuilding;
        if (this.f147819b == null || this.f147819b.f151058o == null || (indoorBuilding = this.f147819b.f151058o.f147694g) == null) {
            return null;
        }
        return indoorBuilding.getBuidlingId();
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final boolean w() {
        rn rnVar;
        if (this.f147819b == null || (rnVar = this.f147819b.f151055l) == null || rnVar.f150106b == null) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final boolean x() {
        if (this.f147819b == null) {
            return false;
        }
        return this.f147819b.f151035ao;
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final ArrayList<MapPoi> y() {
        if (this.f147819b == null) {
            return null;
        }
        return this.f147819b.aC.N();
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final String z() {
        mv a16;
        tk tkVar;
        String str;
        ne neVar;
        tk tkVar2;
        String a17;
        if (this.f147820c != null && this.f147819b != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                if (!hs.a(this.f147830m)) {
                    a16 = mx.a(this.f147820c, this.f147830m);
                } else {
                    a16 = my.a(this.f147820c);
                }
                jSONObject.put("cfgVer", String.format("%s-%s-%s,%s-%s-%s,%s-%s-%s", er.f148280i, Integer.valueOf(a16.b(et.f148298a)), a16.a(et.f148317t), er.f148283l, Integer.valueOf(a16.b("indoormap_style_version")), a16.a("indoormap_style_md5"), er.f148284m, Integer.valueOf(a16.b("indoormap_style_night_version")), a16.a("indoormap_style_night_md5")));
                jSONObject.put("resolution", "{" + ht.b(this.f147820c) + "," + ht.c(this.f147820c) + "}");
                jSONObject.put("density", (double) this.f147841x);
                ne neVar2 = ((VectorMap) this.f147819b.e_).f151351o;
                if (neVar2 != null && (tkVar = neVar2.f149396i) != null) {
                    str = (String) tkVar.a(new tk.AnonymousClass48(), (tk.AnonymousClass48) null);
                    jSONObject.put("renderStatus", str);
                    neVar = ((VectorMap) this.f147819b.e_).f151351o;
                    if (neVar != null && (tkVar2 = neVar.f149396i) != null) {
                        a17 = tkVar2.a();
                        jSONObject.put("renderError", a17);
                        jSONObject.put("sdkver", "5.6.3.2.2023");
                        return jSONObject.toString();
                    }
                    a17 = null;
                    jSONObject.put("renderError", a17);
                    jSONObject.put("sdkver", "5.6.3.2.2023");
                    return jSONObject.toString();
                }
                str = null;
                jSONObject.put("renderStatus", str);
                neVar = ((VectorMap) this.f147819b.e_).f151351o;
                if (neVar != null) {
                    a17 = tkVar2.a();
                    jSONObject.put("renderError", a17);
                    jSONObject.put("sdkver", "5.6.3.2.2023");
                    return jSONObject.toString();
                }
                a17 = null;
                jSONObject.put("renderError", a17);
                jSONObject.put("sdkver", "5.6.3.2.2023");
                return jSONObject.toString();
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
        return null;
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final float c() {
        return ((VectorMap) this.f147819b.e_).p();
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final void d() {
        ((VectorMap) this.f147819b.e_).y();
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final void g(boolean z16) {
        if (this.f147819b != null) {
            this.f147819b.f151052i = z16;
        }
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final void i(boolean z16) {
        if (this.f147819b == null || this.f147819b.e_ == 0) {
            return;
        }
        VectorMap vectorMap = (VectorMap) this.f147819b.e_;
        vectorMap.f151352p = z16;
        vectorMap.f151351o.j(z16);
    }

    @Override // com.tencent.mapsdk.internal.al
    public final Point b(LatLng latLng) {
        tr trVar;
        M m3;
        fw a16;
        if (latLng == null || (trVar = this.f147819b) == null || (m3 = trVar.e_) == 0 || ((VectorMap) m3).getProjection() == null || (a16 = ((VectorMap) trVar.e_).getProjection().a(GeoPoint.from(latLng))) == null) {
            return null;
        }
        Point point = new Point();
        point.x = (int) Math.round(a16.f148383a);
        point.y = (int) Math.round(a16.f148384b);
        return point;
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final void e(int i3) {
        VectorMap vectorMap;
        if (this.f147819b == null || (vectorMap = (VectorMap) this.f147819b.e_) == null) {
            return;
        }
        ne neVar = vectorMap.f151351o;
        tk tkVar = neVar.f149396i;
        if (tkVar != null) {
            tkVar.b(i3);
        }
        v vVar = neVar.f149410w;
        if (vVar != null) {
            vVar.f151253b.f151288n = i3;
        }
        vectorMap.f151351o.f149412y = true;
    }

    private void a(bm.a aVar) {
        sl slVar = this.f147821d.f147894c;
        if (slVar != null) {
            slVar.f150310d = aVar;
        }
    }

    private void j(boolean z16) {
        this.f147818a.setZOrderMediaOverlay(z16);
    }

    private void c(float f16, float f17) {
        ne neVar = ((VectorMap) this.f147819b.e_).f151351o;
        if (neVar != null) {
            ae aeVar = neVar.f149398k;
            aeVar.E = f16;
            aeVar.F = f17;
        }
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final void d(boolean z16) {
        VectorMap vectorMap;
        tk tkVar;
        if (this.f147819b == null || this.f147819b.f151058o == null || (vectorMap = this.f147819b.f151058o.f147691d) == null || (tkVar = vectorMap.f151351o.f149396i) == null || tkVar.f150515e == 0) {
            return;
        }
        tkVar.a(new tk.AnonymousClass168(z16));
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final void h(boolean z16) {
        if (this.f147819b == null) {
            return;
        }
        this.f147819b.f151035ao = z16;
    }

    private void a(sj.c cVar, TencentMapOptions tencentMapOptions) {
        sj sjVar;
        bm bmVar = this.f147821d;
        if (tencentMapOptions == null || tencentMapOptions.getExtSurface() == null || (sjVar = bmVar.f147895d) == null) {
            return;
        }
        List<sj.c> list = sjVar.f150272r;
        if (list != null && cVar != null) {
            list.add(cVar);
        }
        int extSurfaceWidth = tencentMapOptions.getExtSurfaceWidth();
        int extSurfaceHeight = tencentMapOptions.getExtSurfaceHeight();
        ViewGroup ab5 = bmVar.f147893b.ab();
        if (ab5 != null) {
            ab5.measure(View.MeasureSpec.makeMeasureSpec(extSurfaceWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(extSurfaceHeight, 1073741824));
        }
        bmVar.b(extSurfaceWidth, extSurfaceHeight);
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final void f(boolean z16) {
        if (this.f147819b != null) {
            this.f147819b.f151033am = z16;
        }
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final void f(int i3) {
        rq a16;
        if (i3 == 1000 || i3 == 1011 || i3 == 1008) {
            if (i3 == 1008) {
                this.f147819b.aC.f147918e.e().f148604a++;
            }
            this.f147840w = i3;
            if (i3 == 1000) {
                i3 = this.f147839v;
            }
            rr rrVar = this.f147822e;
            if (rrVar != null && (a16 = rrVar.a(i3)) != null) {
                i3 = a16.f150117a;
            }
            this.f147819b.aC.c(i3);
        }
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final void c(boolean z16) {
        if (this.f147819b == null || this.f147819b.f151058o == null) {
            return;
        }
        ac acVar = this.f147819b.f151058o;
        int i3 = z16 ? ac.a.f147711b : ac.a.f147712c;
        acVar.f147690c = i3;
        acVar.a(i3);
    }

    private void b(boolean z16, long j3, TencentMap.CancelableCallback cancelableCallback) {
        if (!z16) {
            ((VectorMap) this.f147819b.e_).c(((VectorMap) this.f147819b.e_).t() / 2.0f);
            return;
        }
        th thVar = new th();
        thVar.b(-1.0f);
        thVar.f150457a = this.f147828k;
        thVar.f150486f = cancelableCallback;
        thVar.a(j3);
        ((VectorMap) this.f147819b.e_).a(thVar);
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final void d(int i3) {
        if (this.f147819b == null) {
            return;
        }
        this.f147819b.f151053j = i3;
        VectorMap vectorMap = (VectorMap) this.f147819b.e_;
        if (vectorMap == null) {
            return;
        }
        vectorMap.b(i3);
        vectorMap.f151351o.f149412y = true;
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final void e(boolean z16) {
        if (this.f147819b == null) {
            return;
        }
        if (z16) {
            this.f147819b.z();
            return;
        }
        rn rnVar = this.f147819b.f151055l;
        if (rnVar != null) {
            rnVar.b();
        }
    }

    @Override // com.tencent.mapsdk.internal.al
    public final LatLng a(Point point) {
        M m3;
        tr trVar = this.f147819b;
        if (trVar == null || (m3 = trVar.e_) == 0 || ((VectorMap) m3).getProjection() == null) {
            return null;
        }
        return ks.a(((VectorMap) trVar.e_).getProjection().a(new fw(point.x, point.y)));
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final void c(int i3) {
        ac acVar;
        ne neVar;
        if (this.f147819b == null || this.f147819b.f151058o == null || (neVar = (acVar = this.f147819b.f151058o).f147692e) == null) {
            return;
        }
        hi hiVar = neVar.f147918e;
        IndoorBuilding indoorBuilding = acVar.f147694g;
        if (indoorBuilding != null) {
            String buidlingId = indoorBuilding.getBuidlingId();
            if (hiVar != null && !TextUtils.isEmpty(buidlingId)) {
                hiVar.d().a(buidlingId).b();
            }
        }
        tk tkVar = acVar.f147692e.f149396i;
        if (tkVar != null) {
            tkVar.a(new tk.AnonymousClass159(i3));
        }
        acVar.c();
    }

    @Override // com.tencent.mapsdk.internal.al
    public final double a(double d16) {
        return ((VectorMap) this.f147819b.e_).getProjection().metersPerPixel(d16);
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final void k() {
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final void l() {
    }

    private void a(boolean z16, long j3, TencentMap.CancelableCallback cancelableCallback) {
        if (!z16) {
            ((VectorMap) this.f147819b.e_).c(((VectorMap) this.f147819b.e_).t() * 2.0f);
            return;
        }
        th thVar = new th();
        thVar.b(1.0f);
        thVar.f150457a = this.f147828k;
        thVar.f150486f = cancelableCallback;
        thVar.a(j3);
        ((VectorMap) this.f147819b.e_).a(thVar);
    }

    private void b(float f16, boolean z16, long j3, TencentMap.CancelableCallback cancelableCallback) {
        double pow;
        if (this.f147819b == null || f16 == 0.0f) {
            return;
        }
        if (!z16) {
            if (f16 < 0.0f) {
                pow = Math.pow(2.0d, Math.abs(f16));
            } else {
                pow = Math.pow(0.5d, Math.abs(f16));
            }
            ((VectorMap) this.f147819b.e_).a(((VectorMap) this.f147819b.e_).t() * ((float) (1.0d / pow)));
            return;
        }
        th thVar = new th();
        thVar.b(f16);
        thVar.f150457a = this.f147828k;
        thVar.f150486f = cancelableCallback;
        thVar.a(j3);
        ((VectorMap) this.f147819b.e_).a(thVar);
    }

    private void a(float f16, float f17, boolean z16, long j3, TencentMap.CancelableCallback cancelableCallback) {
        if (this.f147819b == null) {
            return;
        }
        if (f16 == 0.0f && f17 == 0.0f) {
            return;
        }
        if (!z16) {
            ((VectorMap) this.f147819b.e_).b((int) f16, (int) f17);
            return;
        }
        th thVar = new th();
        int i3 = (int) f16;
        int i16 = (int) f17;
        if (i3 == 0 && i16 == 0) {
            thVar.f150488h = false;
        }
        thVar.I = i3;
        thVar.J = i16;
        thVar.f150488h = true;
        thVar.f150457a = this.f147828k;
        thVar.f150486f = cancelableCallback;
        thVar.a(j3);
        ((VectorMap) this.f147819b.e_).a(thVar);
    }

    private void b(float f16, float f17, boolean z16, long j3, TencentMap.CancelableCallback cancelableCallback) {
        if (z16) {
            th thVar = new th();
            thVar.c(f16);
            if (f17 >= 0.0f) {
                thVar.d(f17);
            }
            thVar.f150457a = this.f147828k;
            thVar.f150486f = cancelableCallback;
            thVar.a(j3);
            ((VectorMap) this.f147819b.e_).a(thVar);
            return;
        }
        ((VectorMap) this.f147819b.e_).b(f16);
        if (f17 >= 0.0f) {
            ((VectorMap) this.f147819b.e_).a(f17);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(float f16, boolean z16, long j3, TencentMap.CancelableCallback cancelableCallback) {
        if (this.f147819b == null) {
            return;
        }
        if (!z16) {
            ((VectorMap) this.f147819b.e_).a((float) (1.0d / Math.pow(2.0d, 20.0f - Math.min(f16, Math.min(((VectorMap) this.f147819b.e_).q(), this.f147819b.f151058o.f147693f ? 22 : 20)))));
            return;
        }
        th thVar = new th();
        thVar.a(f16);
        thVar.f150457a = this.f147828k;
        thVar.f150486f = cancelableCallback;
        thVar.a(j3);
        ((VectorMap) this.f147819b.e_).a(thVar);
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final float b() {
        return ((VectorMap) this.f147819b.e_).q();
    }

    private static List<fb> b(List<IOverlay> list) {
        ArrayList arrayList = new ArrayList();
        for (IOverlay iOverlay : list) {
            if (iOverlay instanceof fb) {
                arrayList.add((fb) iOverlay);
            }
        }
        return arrayList;
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final void b(TencentMap.OnCameraChangeListener onCameraChangeListener) {
        if (this.f147819b == null) {
            return;
        }
        this.f147819b.F = onCameraChangeListener;
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final void b(TencentMapGestureListener tencentMapGestureListener) {
        TencentMapGestureListenerList tencentMapGestureListenerList;
        if (this.f147819b == null || (tencentMapGestureListenerList = this.f147819b.f151123au) == null) {
            return;
        }
        tencentMapGestureListenerList.removeListener(tencentMapGestureListener);
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final void b(boolean z16) {
        if (this.f147819b == null) {
            return;
        }
        this.f147819b.S = z16;
    }

    private void a(float f16, float f17, float f18, boolean z16, long j3, TencentMap.CancelableCallback cancelableCallback) {
        double pow;
        if (this.f147819b == null || f16 == 0.0f) {
            return;
        }
        if (!z16) {
            if (f16 < 0.0f) {
                pow = Math.pow(2.0d, Math.abs(f16));
            } else {
                pow = Math.pow(0.5d, Math.abs(f16));
            }
            double d16 = f17;
            double d17 = f18;
            ((VectorMap) this.f147819b.e_).f151351o.f149398k.a((float) (1.0d / pow), d16, d17, d16, d17, null);
            return;
        }
        th thVar = new th();
        thVar.a((int) f17, (int) f18);
        thVar.b(f16);
        thVar.f150457a = this.f147828k;
        thVar.f150486f = cancelableCallback;
        thVar.a(j3);
        ((VectorMap) this.f147819b.e_).a(thVar);
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final void b(int i3) {
        if (this.f147819b == null) {
            return;
        }
        this.f147819b.a(i3);
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final void b(float f16, float f17) {
        if (this.f147819b == null) {
            return;
        }
        if (f16 < 0.0f) {
            f16 = 0.0f;
        } else if (f16 > 1.0f) {
            f16 = 1.0f;
        }
        if (f17 < 0.0f) {
            f17 = 0.0f;
        } else if (f17 > 1.0f) {
            f17 = 1.0f;
        }
        this.f147819b.d((int) (this.f147819b.f151030aj * f16), (int) (this.f147819b.f151031ak * f17));
        this.f147819b.P = f16;
        this.f147819b.Q = f17;
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final void b(TencentMap.OnMapLoadedCallback onMapLoadedCallback) {
        this.f147819b.f151122at.remove(onMapLoadedCallback);
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final void b(fk fkVar) {
        VectorMap vectorMap;
        if (this.f147819b == null || (vectorMap = (VectorMap) this.f147819b.e_) == null) {
            return;
        }
        vectorMap.f151351o.b(fkVar);
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final void b(Language language) {
        if (this.f147819b == null || this.f147819b.f151054k == null) {
            return;
        }
        sp spVar = this.f147819b.f151054k;
        if (language != null) {
            so soVar = spVar.f150369b;
            if (soVar.f150358j != language) {
                soVar.f150358j = language;
                OverSeaTileProvider overSeaTileProvider = spVar.f150370c;
                if (overSeaTileProvider != null) {
                    overSeaTileProvider.onLanguageChange(language);
                }
                spVar.a();
            }
        }
    }

    private void a(CameraPosition cameraPosition, boolean z16, long j3, TencentMap.CancelableCallback cancelableCallback) {
        if (this.f147819b == null || cameraPosition == null) {
            return;
        }
        GeoPoint from = GeoPoint.from(cameraPosition.target);
        float f16 = cameraPosition.zoom;
        float p16 = ((VectorMap) this.f147819b.e_).p();
        if (f16 < p16) {
            f16 = p16;
        }
        if (f16 > 20.0f) {
            f16 = 20.0f;
        }
        if (!z16) {
            double pow = 1.0d / Math.pow(2.0d, 20.0f - f16);
            if (from != null) {
                ((VectorMap) this.f147819b.e_).a(from.getLatitudeE6(), from.getLongitudeE6());
            }
            ((VectorMap) this.f147819b.e_).a((float) pow);
            ((VectorMap) this.f147819b.e_).b(cameraPosition.bearing);
            if (cameraPosition.tilt >= 0.0f) {
                ((VectorMap) this.f147819b.e_).a(cameraPosition.tilt);
                return;
            }
            return;
        }
        th thVar = new th();
        if (from != null) {
            thVar.b(from.getLatitudeE6(), from.getLongitudeE6());
        }
        thVar.a(f16);
        thVar.c(cameraPosition.bearing);
        float f17 = cameraPosition.tilt;
        if (f17 >= 0.0f) {
            thVar.d(f17);
        }
        thVar.f150457a = this.f147828k;
        thVar.a(j3);
        thVar.f150486f = cancelableCallback;
        ((VectorMap) this.f147819b.e_).a(thVar);
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final int b(String str) {
        VectorMap vectorMap;
        ne neVar;
        tk tkVar;
        if (this.f147819b == null || this.f147819b.f151058o == null || (vectorMap = this.f147819b.f151058o.f147691d) == null || (neVar = vectorMap.f151351o) == null || (tkVar = neVar.f149396i) == null) {
            return -1;
        }
        return ((Integer) tkVar.a((CallbackRunnable<tk.AnonymousClass47>) new tk.AnonymousClass47(str), (tk.AnonymousClass47) (-1))).intValue();
    }

    private void a(double d16, double d17, float f16, boolean z16, long j3, TencentMap.CancelableCallback cancelableCallback) {
        if (this.f147819b == null) {
            return;
        }
        int i3 = (int) (d16 * 1000000.0d);
        int i16 = (int) (d17 * 1000000.0d);
        float p16 = ((VectorMap) this.f147819b.e_).p();
        if (f16 < p16) {
            f16 = p16;
        }
        if (f16 > 20.0f) {
            f16 = 20.0f;
        }
        double pow = 1.0d / Math.pow(2.0d, 20.0f - f16);
        if (!z16) {
            ((VectorMap) this.f147819b.e_).a(i3, i16);
            ((VectorMap) this.f147819b.e_).a((float) pow);
            return;
        }
        th thVar = new th();
        thVar.b(i3, i16);
        thVar.a(f16);
        thVar.f150457a = this.f147828k;
        thVar.f150486f = cancelableCallback;
        thVar.a(j3);
        ((VectorMap) this.f147819b.e_).a(thVar);
    }

    private void a(double d16, double d17, boolean z16, long j3, TencentMap.CancelableCallback cancelableCallback) {
        if (this.f147819b == null) {
            return;
        }
        int i3 = (int) (d16 * 1000000.0d);
        int i16 = (int) (d17 * 1000000.0d);
        if (!z16) {
            ((VectorMap) this.f147819b.e_).a(i3, i16);
            return;
        }
        th thVar = new th();
        thVar.b(i3, i16);
        thVar.f150457a = this.f147828k;
        thVar.f150486f = cancelableCallback;
        thVar.a(j3);
        ((VectorMap) this.f147819b.e_).a(thVar);
    }

    private int a(LatLngBounds latLngBounds, int i3, boolean z16, long j3, TencentMap.CancelableCallback cancelableCallback) {
        if (latLngBounds != null && latLngBounds.northeast != null && latLngBounds.southwest != null) {
            if (this.f147819b.f151030aj != 0 && this.f147819b.f151031ak != 0) {
                this.f147819b.C = null;
                LatLng latLng = new LatLng(0.0d, 0.0d);
                float a16 = this.f147827j.a(latLngBounds.southwest, latLngBounds.northeast, i3, i3, i3, i3, latLng);
                if (a16 < 0.0f) {
                    return (int) a16;
                }
                if (!z16) {
                    ((VectorMap) this.f147819b.e_).a((int) (latLng.latitude * 1000000.0d), (int) (latLng.longitude * 1000000.0d));
                    a(a16, false, j3, (TencentMap.CancelableCallback) null);
                } else {
                    th thVar = new th();
                    thVar.b((int) (latLng.latitude * 1000000.0d), (int) (latLng.longitude * 1000000.0d));
                    thVar.a(a16);
                    thVar.f150457a = this.f147828k;
                    thVar.f150486f = cancelableCallback;
                    thVar.a(j3);
                    ((VectorMap) this.f147819b.e_).a(thVar);
                }
                return 0;
            }
            this.f147819b.f151023ac = latLngBounds.southwest;
            this.f147819b.f151024ad = latLngBounds.northeast;
            this.f147819b.f151025ae = i3;
            this.f147819b.A = cancelableCallback;
            if (z16) {
                this.f147819b.C = this.f147843z;
            } else {
                this.f147819b.C = this.f147842y;
            }
            int b16 = ht.b(this.f147820c);
            int c16 = ht.c(this.f147820c);
            int i16 = i3 * 2;
            if (this.f147835r + i16 + this.f147837t <= b16 && i16 + this.f147836s + this.f147838u <= c16) {
                return 0;
            }
        }
        return -1;
    }

    private int a(LatLngBounds latLngBounds, int i3, int i16, int i17, int i18, boolean z16, long j3, TencentMap.CancelableCallback cancelableCallback) {
        if (latLngBounds != null && latLngBounds.northeast != null && latLngBounds.southwest != null) {
            if (this.f147819b.f151030aj != 0 && this.f147819b.f151031ak != 0) {
                this.f147819b.C = null;
                LatLng latLng = new LatLng();
                float a16 = this.f147827j.a(latLngBounds.southwest, latLngBounds.northeast, i3, i16, i17, i18, latLng);
                if (a16 < 0.0f) {
                    return (int) a16;
                }
                if (!z16) {
                    ((VectorMap) this.f147819b.e_).a((int) (latLng.latitude * 1000000.0d), (int) (latLng.longitude * 1000000.0d));
                    a(a16, false, j3, (TencentMap.CancelableCallback) null);
                    ((VectorMap) this.f147819b.e_).b(0.0f);
                    ((VectorMap) this.f147819b.e_).a(0.0f);
                } else {
                    th thVar = new th();
                    thVar.c(0.0f);
                    thVar.d(0.0f);
                    thVar.b((int) (latLng.latitude * 1000000.0d), (int) (latLng.longitude * 1000000.0d));
                    thVar.a(a16);
                    thVar.f150457a = this.f147828k;
                    thVar.f150486f = cancelableCallback;
                    thVar.a(j3);
                    ((VectorMap) this.f147819b.e_).a(thVar);
                }
                return 0;
            }
            this.f147819b.f151023ac = latLngBounds.southwest;
            this.f147819b.f151024ad = latLngBounds.northeast;
            this.f147819b.f151026af = i3;
            this.f147819b.f151027ag = i16;
            this.f147819b.f151028ah = i17;
            this.f147819b.f151029ai = i18;
            this.f147819b.A = cancelableCallback;
            if (z16) {
                this.f147819b.C = this.f147843z;
            } else {
                this.f147819b.C = this.f147842y;
            }
            int b16 = ht.b(this.f147820c);
            int c16 = ht.c(this.f147820c);
            if (i3 + i16 + this.f147835r + this.f147837t <= b16 && i17 + i18 + this.f147836s + this.f147838u <= c16) {
                return 0;
            }
        }
        return -1;
    }

    private int a(List<fb> list, int i3, int i16, int i17, int i18, final boolean z16, final long j3, final TencentMap.CancelableCallback cancelableCallback) {
        fa projection = ((VectorMap) this.f147819b.e_).getProjection();
        if (projection == null) {
            return Integer.MIN_VALUE;
        }
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (fb fbVar : list) {
                if (fbVar != null && fbVar.getGroupBounds() != null) {
                    arrayList.addAll(fbVar.getGroupBounds());
                }
            }
            if (this.f147819b.f151030aj != 0 && this.f147819b.f151031ak != 0) {
                if (i3 + i16 > this.f147819b.f151030aj || i17 + i18 > this.f147819b.f151031ak) {
                    return -1;
                }
                projection.a(arrayList, null, new Rect(i3, i17, i16, i18), new fa.a() { // from class: com.tencent.mapsdk.internal.bi.3
                    @Override // com.tencent.mapsdk.internal.fa.a
                    public final void a(final float f16, final GeoPoint geoPoint) {
                        if (bi.this.f147819b == null) {
                            return;
                        }
                        kp.a(new Runnable() { // from class: com.tencent.mapsdk.internal.bi.3.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                if (bi.this.f147819b == null) {
                                    return;
                                }
                                AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                if (z16) {
                                    double b16 = (((int) bi.this.b()) - (Math.log(1.0f / f16) / Math.log(2.0d))) - 2.0d;
                                    if (b16 < 0.0d) {
                                        b16 = 0.0d;
                                    }
                                    th thVar = new th();
                                    thVar.b(geoPoint.getLatitudeE6(), geoPoint.getLongitudeE6());
                                    thVar.a((float) b16);
                                    AnonymousClass3 anonymousClass32 = AnonymousClass3.this;
                                    thVar.f150457a = bi.this.f147828k;
                                    thVar.f150486f = cancelableCallback;
                                    thVar.a(j3);
                                    ((VectorMap) bi.this.f147819b.e_).a(thVar);
                                    return;
                                }
                                VectorMap vectorMap = (VectorMap) bi.this.f147819b.e_;
                                GeoPoint geoPoint2 = geoPoint;
                                vectorMap.f151351o.f149398k.a(geoPoint2.getLatitudeE6(), geoPoint2.getLongitudeE6(), 1);
                                ((VectorMap) bi.this.f147819b.e_).a(f16);
                            }
                        });
                    }
                });
                return 0;
            }
            int b16 = ht.b(this.f147820c);
            int c16 = ht.c(this.f147820c);
            if (i3 + i16 <= b16 && i17 + i18 <= c16) {
                return 0;
            }
        }
        return -1;
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final CameraPosition a() {
        LatLng a16 = ks.a(((VectorMap) this.f147819b.e_).r());
        float v3 = ((VectorMap) this.f147819b.e_).v();
        if (v3 < 0.0f) {
            v3 = (v3 % 360.0f) + 360.0f;
        }
        return CameraPosition.builder().zoom(D()).target(a16).bearing(v3).tilt(((VectorMap) this.f147819b.e_).w()).build();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mapsdk.internal.ak
    public final int a(CameraUpdate cameraUpdate) {
        CamerParameter params;
        if (cameraUpdate == null || (params = cameraUpdate.getParams()) == null) {
            return -1;
        }
        switch (params.iCamerType) {
            case 0:
                a(false, 0L, (TencentMap.CancelableCallback) null);
                return 0;
            case 1:
                b(false, 0L, null);
                return 0;
            case 2:
                a(params.scrollBy_xPixel, params.scrollBy_yPixel, false, 0L, (TencentMap.CancelableCallback) null);
                return 0;
            case 3:
                a(params.zoomTo_zoom, false, 0L, (TencentMap.CancelableCallback) null);
                return 0;
            case 4:
                b(params.zoomBy_amount, false, 0L, null);
                return 0;
            case 5:
                float f16 = params.zoomBy_Point_amount;
                Point point = params.zoomBy_Point_focus;
                a(f16, point.x, point.y, false, 0L, (TencentMap.CancelableCallback) null);
                return 0;
            case 6:
                a(params.newCameraPosition_cameraPosition, false, 0L, (TencentMap.CancelableCallback) null);
                return 0;
            case 7:
                LatLng latLng = params.newLatLng_latLng;
                if (latLng != null) {
                    a(latLng.latitude, latLng.longitude, false, 0L, (TencentMap.CancelableCallback) null);
                }
                return 0;
            case 8:
                LatLng latLng2 = params.newLatLngZoom_latLng;
                if (latLng2 != null) {
                    a(latLng2.latitude, latLng2.longitude, params.newLatLngZoom_zoom, false, 0L, (TencentMap.CancelableCallback) null);
                }
                return 0;
            case 9:
                return a(params.newLatLngBounds_bounds, params.newLatLngBounds_padding, false, 0L, (TencentMap.CancelableCallback) null);
            case 10:
                LatLngBounds latLngBounds = params.newLatLngBounds_dimension_bounds;
                int i3 = params.newLatLngBounds_dimension_padding;
                return a(latLngBounds, i3, i3, i3, i3, false, 0L, (TencentMap.CancelableCallback) null);
            case 11:
                return a(params.newLatLngBounds_dimension_bounds, params.newLatLngBoundsRects_padLeft, params.newLatLngBoundsRects_padRight, params.newLatLngBoundsRects_padTop, params.newLatLngBoundsRects_padBom, false, 0L, (TencentMap.CancelableCallback) null);
            case 12:
                b(params.rotateto_rotate, params.rotateto_skew, false, 0L, null);
                return 0;
            case 13:
                return a(b(params.elements), params.newLatLngBoundsRects_padLeft, params.newLatLngBoundsRects_padRight, params.newLatLngBoundsRects_padTop, params.newLatLngBoundsRects_padBom, false, 0L, (TencentMap.CancelableCallback) null);
            default:
                return 0;
        }
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final int a(CameraUpdate cameraUpdate, long j3, TencentMap.CancelableCallback cancelableCallback) {
        CamerParameter params;
        if (cameraUpdate == null || (params = cameraUpdate.getParams()) == null) {
            return -1;
        }
        long j16 = j3 < 0 ? 0L : j3;
        switch (params.iCamerType) {
            case 0:
                a(true, j16, cancelableCallback);
                return 0;
            case 1:
                b(true, j16, cancelableCallback);
                return 0;
            case 2:
                a(params.scrollBy_xPixel, params.scrollBy_yPixel, true, j16, cancelableCallback);
                return 0;
            case 3:
                a(params.zoomTo_zoom, true, j16, cancelableCallback);
                return 0;
            case 4:
                b(params.zoomBy_amount, true, j16, cancelableCallback);
                return 0;
            case 5:
                float f16 = params.zoomBy_Point_amount;
                Point point = params.zoomBy_Point_focus;
                a(f16, point.x, point.y, true, j16, cancelableCallback);
                return 0;
            case 6:
                a(params.newCameraPosition_cameraPosition, true, j16, cancelableCallback);
                return 0;
            case 7:
                LatLng latLng = params.newLatLng_latLng;
                a(latLng.latitude, latLng.longitude, true, j16, cancelableCallback);
                return 0;
            case 8:
                LatLng latLng2 = params.newLatLngZoom_latLng;
                a(latLng2.latitude, latLng2.longitude, params.newLatLngZoom_zoom, true, j16, cancelableCallback);
                return 0;
            case 9:
                return a(params.newLatLngBounds_bounds, params.newLatLngBounds_padding, true, j16, cancelableCallback);
            case 10:
                LatLngBounds latLngBounds = params.newLatLngBounds_dimension_bounds;
                int i3 = params.newLatLngBounds_dimension_padding;
                return a(latLngBounds, i3, i3, i3, i3, true, j16, cancelableCallback);
            case 11:
                return a(params.newLatLngBounds_dimension_bounds, params.newLatLngBoundsRects_padLeft, params.newLatLngBoundsRects_padRight, params.newLatLngBoundsRects_padTop, params.newLatLngBoundsRects_padBom, true, j16, cancelableCallback);
            case 12:
                b(params.rotateto_rotate, params.rotateto_skew, true, j16, cancelableCallback);
                return 0;
            case 13:
                return a(b(params.elements), params.newLatLngBoundsRects_padLeft, params.newLatLngBoundsRects_padRight, params.newLatLngBoundsRects_padTop, params.newLatLngBoundsRects_padBom, true, j16, cancelableCallback);
            default:
                return 0;
        }
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final void a(int i3) {
        int f16 = f();
        this.f147839v = i3;
        if (i3 == f16 || f16 == 1011 || f16 == 1008) {
            return;
        }
        rr rrVar = this.f147822e;
        if (rrVar != null) {
            rq a16 = rrVar.a(i3);
            if (a16 != null) {
                i3 = a16.f150117a;
                hi hiVar = this.f147819b.aC.f147918e;
                if (hiVar != null) {
                    hiVar.q().a(a16.f150118b);
                }
            } else if (i3 >= 1000) {
                i3 -= 1000;
            } else if (i3 > 8 && i3 < 989) {
                i3 += 11;
            }
        }
        this.f147819b.aC.c(i3);
        ho.q();
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final void a(boolean z16) {
        VectorMap vectorMap = (VectorMap) this.f147819b.e_;
        if (z16) {
            vectorMap.b(true);
        } else {
            vectorMap.b(false);
        }
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final void a(TencentMap.OnMapClickListener onMapClickListener) {
        this.f147819b.f151061r = onMapClickListener;
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final void a(TencentMap.OnMapLongClickListener onMapLongClickListener) {
        this.f147819b.f151064u = onMapLongClickListener;
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final void a(TencentMap.OnCameraChangeListener onCameraChangeListener) {
        if (this.f147819b == null) {
            return;
        }
        this.f147819b.E = onCameraChangeListener;
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final void a(TencentMap.OnScaleViewChangedListener onScaleViewChangedListener) {
        if (this.f147819b == null) {
            return;
        }
        this.f147819b.D = onScaleViewChangedListener;
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final void a(TencentMap.OnDismissCallback onDismissCallback) {
        this.f147819b.f151065v = onDismissCallback;
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final void a(LatLng latLng, float f16, float f17) {
        a(latLng, f16, f17, 0.0f, true);
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final void a(LatLng latLng, float f16, float f17, float f18, boolean z16) {
        th thVar = new th();
        thVar.b((int) (latLng.latitude * 1000000.0d), (int) (latLng.longitude * 1000000.0d));
        thVar.a(f18);
        thVar.c(f16);
        thVar.d(f17);
        thVar.f150457a = this.f147828k;
        thVar.f150487g = true;
        thVar.a(1000L);
        if (z16) {
            thVar.a(this.f147819b.J, this.f147819b.K);
        } else {
            thVar.a(this.f147819b.L, this.f147819b.M);
        }
        ((VectorMap) this.f147819b.e_).y();
        ((VectorMap) this.f147819b.e_).a(thVar);
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final float a(LatLng latLng, LatLng latLng2) {
        return a(0, 0, 0, 0, latLng, latLng2, (LatLng) null);
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final void a(Handler handler, Bitmap.Config config, int i3) {
        tr trVar = this.f147819b;
        trVar.G = handler;
        trVar.I = config;
        if (i3 >= 0) {
            trVar.H = SystemClock.elapsedRealtime() + i3;
        } else {
            trVar.H = Long.MAX_VALUE;
        }
        trVar.I();
        trVar.G();
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final String a(LatLng latLng) {
        if (latLng == null) {
            return null;
        }
        return ((VectorMap) this.f147819b.e_).f151351o.a(GeoPoint.from(latLng));
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final void a(TencentMapGestureListener tencentMapGestureListener) {
        if (this.f147819b == null) {
            return;
        }
        tr trVar = this.f147819b;
        if (trVar.f151123au == null) {
            trVar.f151123au = new TencentMapGestureListenerList();
        }
        trVar.f151123au.addListener(tencentMapGestureListener);
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final void a(float f16, float f17) {
        if (this.f147819b == null) {
            return;
        }
        if (f16 < 0.0f) {
            f16 = 0.0f;
        } else if (f16 > 1.0f) {
            f16 = 1.0f;
        }
        if (f17 < 0.0f) {
            f17 = 0.0f;
        } else if (f17 > 1.0f) {
            f17 = 1.0f;
        }
        this.f147819b.c((int) (this.f147819b.f151030aj * f16), (int) (this.f147819b.f151031ak * f17));
        this.f147819b.N = f16;
        this.f147819b.O = f17;
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final void a(int i3, int i16) {
        if (this.f147819b == null) {
            return;
        }
        this.f147819b.a(i3, i16);
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final void a(TencentMap.OnCompassClickedListener onCompassClickedListener) {
        if (this.f147819b != null) {
            this.f147819b.B = onCompassClickedListener;
        }
    }

    public final float a(float f16, int i3, int i16, int i17, int i18, LatLng latLng, LatLng latLng2) {
        int i19 = this.f147819b.f151030aj;
        int i26 = this.f147819b.f151031ak;
        if (i19 == 0 || i26 == 0 || latLng == null || latLng2 == null) {
            return 0.0f;
        }
        fw a16 = this.f147827j.a(this.f147820c, latLng);
        fw a17 = this.f147827j.a(this.f147820c, latLng2);
        double d16 = a17.f148383a - a16.f148383a;
        if (d16 < 0.0d) {
            d16 = Math.abs(d16);
        }
        double d17 = a17.f148384b - a16.f148384b;
        if (d17 < 0.0d) {
            d17 = Math.abs(d17);
        }
        double d18 = d16 * 1.0d;
        double d19 = d17 * 1.0d;
        int i27 = (i19 - i3) - i16;
        int i28 = (i26 - i17) - i18;
        if (f16 == 90.0f) {
            f16 = 89.0f;
        }
        int cos = (int) (i28 / Math.cos((f16 * 3.141592653589793d) / 180.0d));
        if (i27 <= 0) {
            i27 = 1;
        }
        if (cos <= 0) {
            cos = 1;
        }
        double log = Math.log(d18 / i27) / Math.log(2.0d);
        double log2 = Math.log(d19 / cos) / Math.log(2.0d);
        if (log < 0.0d) {
            log = 0.0d;
        }
        return (float) (20.0d - Math.max(log, log2 >= 0.0d ? log2 : 0.0d));
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0069, code lost:
    
        if ((r7 + r9) <= com.tencent.mapsdk.internal.ht.c(r10)) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int a(int i3, int i16, int i17, int i18, boolean z16) {
        ae aeVar = ((VectorMap) this.f147819b.e_).f151351o.f149398k;
        aeVar.H = i3;
        aeVar.I = i16;
        aeVar.J = i17;
        aeVar.K = i18;
        Rect rect = aeVar.C;
        int i19 = 0;
        if (rect != null && rect.width() > 0 && aeVar.C.height() > 0) {
            if (i3 + i17 <= aeVar.C.width() && i16 + i18 <= aeVar.C.height()) {
                PointF a16 = aeVar.a();
                aeVar.a(a16.x, a16.y, z16);
            }
            i19 = -1;
        } else {
            aeVar.a(new ae.AnonymousClass1(z16));
            bf bfVar = aeVar.f147743z;
            if (bfVar instanceof ne) {
                Context context = ((ne) bfVar).getContext();
                if (i3 + i17 <= ht.b(context)) {
                }
                i19 = -1;
            } else {
                i19 = -2;
            }
        }
        if (i19 == 0) {
            this.f147835r = i3;
            this.f147836s = i16;
            this.f147837t = i17;
            this.f147838u = i18;
        }
        return i19;
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final float a(LatLngBounds latLngBounds, float f16, int i3, boolean z16) {
        int i16;
        if (latLngBounds == null) {
            return 0.0f;
        }
        if (z16) {
            i16 = this.f147819b.K;
        } else {
            i16 = this.f147819b.M;
        }
        float f17 = !z16 ? 0.0f : f16;
        if (i16 < 0) {
            i16 = this.f147819b.f151030aj / 2;
        }
        return a(f17, 0, 0, i3, this.f147819b.f151031ak - i16, latLngBounds.southwest, latLngBounds.northeast);
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final float a(LatLng latLng, LatLng latLng2, float f16, int i3, boolean z16) {
        if (latLng == null || latLng2 == null) {
            return 0.0f;
        }
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        builder.include(latLng);
        builder.include(latLng2);
        return a(!z16 ? 0.0f : f16, 0, 0, i3, 0, builder.build().southwest, builder.build().northeast);
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final float a(LatLng latLng, LatLng latLng2, float f16, int i3, int i16, int i17, int i18, boolean z16) {
        if (latLng == null || latLng2 == null) {
            return 0.0f;
        }
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        builder.include(latLng);
        builder.include(latLng2);
        return a(!z16 ? 0.0f : f16, i3, i16, i17, i18, builder.build().southwest, builder.build().northeast);
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final float a(int i3, int i16, int i17, int i18, LatLng latLng, LatLng latLng2, LatLng latLng3) {
        return this.f147827j.a(latLng, latLng2, i3, i16, i17, i18, latLng3);
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final CameraPosition a(List<fb> list, List<LatLng> list2, int i3, int i16, int i17, int i18) {
        if (this.f147819b.f151030aj != 0 && this.f147819b.f151031ak != 0) {
            if (i3 + i16 > this.f147819b.f151030aj || i17 + i18 > this.f147819b.f151031ak) {
                return null;
            }
        } else {
            int b16 = ht.b(this.f147820c);
            int c16 = ht.c(this.f147820c);
            if (i3 + i16 > b16 || i17 + i18 > c16) {
                return null;
            }
        }
        fa projection = ((VectorMap) this.f147819b.e_).getProjection();
        if (projection == null) {
            return null;
        }
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (fb fbVar : list) {
                if (fbVar != null && fbVar.getGroupBounds() != null) {
                    arrayList.addAll(fbVar.getGroupBounds());
                }
            }
            Rect rect = new Rect(i3, i17, i16, i18);
            this.f147825h = null;
            projection.a(arrayList, GeoPoint.from(list2), rect, new fa.a() { // from class: com.tencent.mapsdk.internal.bi.4
                @Override // com.tencent.mapsdk.internal.fa.a
                public final void a(float f16, GeoPoint geoPoint) {
                    LatLng a16 = ks.a(geoPoint);
                    double log = 20.0d - (Math.log(1.0f / f16) / Math.log(2.0d));
                    if (log < 0.0d) {
                        log = 0.0d;
                    }
                    bi biVar = bi.this;
                    biVar.f147825h = new CameraPosition(a16, (float) log, ((VectorMap) biVar.f147819b.e_).w(), ((VectorMap) bi.this.f147819b.e_).v());
                    synchronized (bi.this.f147826i) {
                        bi.this.f147826i.notifyAll();
                    }
                }
            });
            synchronized (this.f147826i) {
                try {
                    this.f147826i.wait(1000L);
                } catch (InterruptedException e16) {
                    LogUtil.d(Log.getStackTraceString(e16));
                    Thread.currentThread().interrupt();
                }
            }
            return this.f147825h;
        }
        if (list2 == null || list2.isEmpty()) {
            return null;
        }
        if (list2.size() == 1) {
            return new CameraPosition(list2.get(0), ((VectorMap) this.f147819b.e_).f151351o.f149410w.a(), ((VectorMap) this.f147819b.e_).w(), ((VectorMap) this.f147819b.e_).v());
        }
        double d16 = 0.0d;
        double d17 = 0.0d;
        double d18 = 0.0d;
        double d19 = 0.0d;
        double d26 = 0.0d;
        for (LatLng latLng : list2) {
            if (latLng != null) {
                if (d17 == d16) {
                    d17 = latLng.latitude;
                }
                if (d18 == d16) {
                    d18 = latLng.longitude;
                }
                double d27 = d17;
                double d28 = d19;
                if (d28 == d16) {
                    d28 = latLng.latitude;
                }
                double d29 = d26;
                if (d29 == d16) {
                    d29 = latLng.longitude;
                }
                d26 = d29;
                double d36 = latLng.latitude;
                double d37 = d27;
                if (d36 < d37) {
                    d37 = d36;
                }
                if (d36 > d28) {
                    d28 = d36;
                }
                double d38 = latLng.longitude;
                if (d38 < d18) {
                    d18 = d38;
                }
                if (d38 > d26) {
                    d26 = d38;
                }
                d19 = d28;
                d17 = d37;
            } else {
                d17 = d17;
                d16 = 0.0d;
            }
        }
        LatLng latLng2 = new LatLng(d17, d18);
        LatLng latLng3 = new LatLng(d19, d26);
        LatLng latLng4 = new LatLng(0.0d, 0.0d);
        float a16 = a(i3, i16, i17, i18, latLng2, latLng3, latLng4);
        if (a16 < 0.0f) {
            return null;
        }
        return new CameraPosition(latLng4, a16, ((VectorMap) this.f147819b.e_).w(), ((VectorMap) this.f147819b.e_).v());
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final CameraPosition a(List<fb> list, List<LatLng> list2, int i3, int i16, int i17, int i18, final TencentMap.AsyncOperateCallback<CameraPosition> asyncOperateCallback) {
        if (this.f147819b.f151030aj != 0 && this.f147819b.f151031ak != 0) {
            if (i3 + i16 > this.f147819b.f151030aj || i17 + i18 > this.f147819b.f151031ak) {
                if (asyncOperateCallback != null) {
                    asyncOperateCallback.onOperateFinished(null);
                }
                return null;
            }
        } else {
            ht.b(this.f147820c);
            ht.c(this.f147820c);
        }
        fa projection = ((VectorMap) this.f147819b.e_).getProjection();
        if (projection == null) {
            return null;
        }
        if (list.isEmpty()) {
            if (list2 == null || list2.isEmpty()) {
                if (asyncOperateCallback != null) {
                    asyncOperateCallback.onOperateFinished(null);
                }
                return null;
            }
            if (list2.size() == 1) {
                CameraPosition cameraPosition = new CameraPosition(list2.get(0), ((VectorMap) this.f147819b.e_).t(), ((VectorMap) this.f147819b.e_).w(), ((VectorMap) this.f147819b.e_).v());
                if (asyncOperateCallback != null) {
                    asyncOperateCallback.onOperateFinished(cameraPosition);
                }
                return cameraPosition;
            }
            Iterator<LatLng> it = list2.iterator();
            double d16 = 0.0d;
            double d17 = 0.0d;
            double d18 = 0.0d;
            double d19 = 0.0d;
            double d26 = 0.0d;
            while (it.hasNext()) {
                LatLng next = it.next();
                if (next != null) {
                    if (d17 == d16) {
                        d17 = next.latitude;
                    }
                    if (d18 == d16) {
                        d18 = next.longitude;
                    }
                    double d27 = d17;
                    double d28 = d19;
                    if (d28 == d16) {
                        d28 = next.latitude;
                    }
                    Iterator<LatLng> it5 = it;
                    double d29 = d26;
                    if (d29 == d16) {
                        d29 = next.longitude;
                    }
                    d26 = d29;
                    double d36 = next.latitude;
                    double d37 = d27;
                    if (d36 < d37) {
                        d37 = d36;
                    }
                    if (d36 > d28) {
                        d28 = d36;
                    }
                    double d38 = next.longitude;
                    if (d38 < d18) {
                        d18 = d38;
                    }
                    if (d38 > d26) {
                        d26 = d38;
                    }
                    d19 = d28;
                    it = it5;
                    d17 = d37;
                } else {
                    it = it;
                    d17 = d17;
                    d16 = 0.0d;
                }
            }
            LatLng latLng = new LatLng(d17, d18);
            LatLng latLng2 = new LatLng(d19, d26);
            LatLng latLng3 = new LatLng(0.0d, 0.0d);
            float a16 = a(i3, i16, i17, i18, latLng, latLng2, latLng3);
            if (a16 < 0.0f) {
                if (asyncOperateCallback != null) {
                    asyncOperateCallback.onOperateFinished(null);
                }
                return null;
            }
            CameraPosition cameraPosition2 = new CameraPosition(latLng3, a16, ((VectorMap) this.f147819b.e_).w(), ((VectorMap) this.f147819b.e_).v());
            if (asyncOperateCallback != null) {
                asyncOperateCallback.onOperateFinished(cameraPosition2);
            }
            return cameraPosition2;
        }
        ArrayList arrayList = new ArrayList();
        for (fb fbVar : list) {
            if (fbVar != null && fbVar.getGroupBounds() != null) {
                arrayList.addAll(fbVar.getGroupBounds());
            }
        }
        Rect rect = new Rect(i3, i17, i16, i18);
        this.f147825h = null;
        projection.a(arrayList, GeoPoint.from(list2), rect, new fa.a() { // from class: com.tencent.mapsdk.internal.bi.5
            @Override // com.tencent.mapsdk.internal.fa.a
            public final void a(float f16, GeoPoint geoPoint) {
                LatLng a17 = ks.a(geoPoint);
                double log = 20.0d - (Math.log(1.0f / f16) / Math.log(2.0d));
                if (log < 0.0d) {
                    log = 0.0d;
                }
                bi biVar = bi.this;
                biVar.f147825h = new CameraPosition(a17, (float) log, ((VectorMap) biVar.f147819b.e_).w(), ((VectorMap) bi.this.f147819b.e_).v());
                TencentMap.AsyncOperateCallback asyncOperateCallback2 = asyncOperateCallback;
                if (asyncOperateCallback2 != null) {
                    asyncOperateCallback2.onOperateFinished(bi.this.f147825h);
                }
            }
        });
        return null;
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final void a(float f16, float f17, boolean z16) {
        if (this.f147819b == null) {
            return;
        }
        ae aeVar = ((VectorMap) this.f147819b.e_).f151351o.f149398k;
        aeVar.N = true;
        aeVar.a(f16, f17, z16);
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final void a(LatLng latLng, float f16, float f17, float f18) {
        th thVar = new th();
        thVar.b((int) (latLng.latitude * 1000000.0d), (int) (latLng.longitude * 1000000.0d));
        thVar.a(f18);
        thVar.c(f16);
        thVar.d(f17);
        thVar.f150457a = this.f147828k;
        thVar.f150487g = true;
        thVar.a(1000L);
        ((VectorMap) this.f147819b.e_).y();
        ((VectorMap) this.f147819b.e_).a(thVar);
    }

    private void a(int i3, int i16, int i17, int i18) {
        tk tkVar;
        ne neVar = ((VectorMap) this.f147819b.e_).f151351o;
        if (neVar == null || (tkVar = neVar.f149396i) == null) {
            return;
        }
        tkVar.a(new tk.AnonymousClass23(i16, i3, i17, i18));
    }

    private void a(float f16, float f17, float f18) {
        tr trVar = this.f147819b;
        ne neVar = trVar.aC;
        if (neVar != null) {
            float f19 = neVar.f149398k.A.f151253b.f151290p;
            float c16 = tz.c(f18);
            boolean z16 = ((double) Math.abs(f19 - c16)) > 1.0E-4d;
            trVar.aE = 0;
            kp.a(new tz.AnonymousClass1((f17 - trVar.aD) / 10.0f, f16, f17, f18, z16, c16));
        }
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final void a(TencentMap.OnMapLoadedCallback onMapLoadedCallback) {
        this.f147819b.f151122at.add(onMapLoadedCallback);
    }

    private float a(double d16, LatLng latLng) {
        fa faVar;
        if (latLng == null) {
            return 0.0f;
        }
        GeoPoint geoPoint = new GeoPoint((int) (latLng.latitude * 1000000.0d), (int) (latLng.longitude * 1000000.0d));
        ne neVar = ((VectorMap) this.f147819b.e_).f151351o;
        if (neVar.f149410w != null && (faVar = neVar.f149403p) != null) {
            double metersPerPixel = faVar.metersPerPixel(geoPoint.getLatitudeE6() / 1000000.0d);
            if (metersPerPixel != 0.0d) {
                return (float) (d16 / metersPerPixel);
            }
        }
        return 0.0f;
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final List<Rect> a(List<String> list) {
        qv qvVar;
        ArrayList arrayList = null;
        if (list != null && !list.isEmpty()) {
            if (this.f147819b == null) {
                return null;
            }
            arrayList = new ArrayList(list.size());
            fa projection = ((VectorMap) this.f147819b.e_).getProjection();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                po c16 = this.f147819b.c(it.next());
                if (c16 != null) {
                    if (c16 instanceof pp) {
                        arrayList.add(((pp) c16).getScreenBound(projection));
                    } else if ((c16 instanceof pr) && (qvVar = ((pr) c16).f149615b) != null) {
                        arrayList.add(qvVar.getScreenBound(projection));
                    }
                }
            }
        }
        return arrayList;
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final void a(Language language) {
        VectorMap vectorMap;
        if (this.f147819b == null || (vectorMap = (VectorMap) this.f147819b.e_) == null) {
            return;
        }
        vectorMap.setLanguage(language);
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final void a(fk fkVar) {
        VectorMap vectorMap;
        if (this.f147819b == null || (vectorMap = (VectorMap) this.f147819b.e_) == null) {
            return;
        }
        vectorMap.f151351o.a(fkVar);
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final void a(List<MapRouteSection> list, List<LatLng> list2) {
        VectorMap vectorMap;
        if (this.f147819b == null || (vectorMap = (VectorMap) this.f147819b.e_) == null) {
            return;
        }
        List<GeoPoint> from = GeoPoint.from(list2);
        ne neVar = vectorMap.f151351o;
        if (neVar.C == null) {
            neVar.C = new ne.d();
        }
        ne.d dVar = neVar.C;
        dVar.f149425a = list;
        dVar.f149426b = from;
        ne.this.f149396i.a(list, from);
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final void a(TencentMap.OnIndoorStateChangeListener onIndoorStateChangeListener) {
        this.f147819b.a(onIndoorStateChangeListener);
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final void a(String str) {
        ne neVar;
        if (this.f147819b == null || (neVar = this.f147819b.aC) == null) {
            return;
        }
        tk tkVar = neVar.f149396i;
        if (tkVar != null) {
            tkVar.a(new tk.AnonymousClass32(str));
        }
        neVar.f149412y = true;
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final TileOverlay a(TileOverlayOptions tileOverlayOptions) {
        re reVar = this.f147832o;
        if (reVar == null) {
            return null;
        }
        return reVar.b(tileOverlayOptions);
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final CustomLayer a(CustomLayerOptions customLayerOptions) {
        qh qhVar = this.f147823f;
        if (qhVar != null && this.f147832o != null && qhVar.f149804a != null) {
            customLayerOptions.getLayerId();
            lc.b(ky.f149095a, qhVar.f149806c);
            re reVar = qhVar.f149804a;
            TileOverlayOptions tileOverlayOptions = new TileOverlayOptions();
            String str = "custom_layer_" + lj.a(customLayerOptions.getLayerId());
            tileOverlayOptions.diskCacheDir(str);
            tileOverlayOptions.reuseTile(true);
            qi a16 = qhVar.a(customLayerOptions.getLayerId());
            lc.a(ky.f149095a, XWalkReaderBasePlugin.PARAM_KEY_CACHE_DIR, (Object) str, qhVar.f149806c);
            if (a16 != null) {
                lc.a(ky.f149095a, "version", (Object) a16.f149818b, qhVar.f149806c);
                lc.a(ky.f149095a, "minZoom", Integer.valueOf(a16.f149820d), qhVar.f149806c);
                lc.a(ky.f149095a, "maxZoom", Integer.valueOf(a16.f149819c), qhVar.f149806c);
                lc.a(ky.f149095a, "layerId", (Object) a16.f149817a, qhVar.f149806c);
                tileOverlayOptions.tileProvider(new qh.AnonymousClass1(a16));
                tileOverlayOptions.versionInfo(a16.f149818b);
            }
            qz a17 = reVar.a(tileOverlayOptions);
            qi a18 = qhVar.a(customLayerOptions.getLayerId());
            if (a17 != null && a18 != null) {
                if (a18.f149821e) {
                    a17.e();
                    a18.f149821e = false;
                }
                a17.a(a18.f149820d, a18.f149819c);
                qhVar.f149804a.f150022h.f147918e.c().f148683a++;
                lc.d(ky.f149095a, qhVar.f149806c);
                return new av(a17);
            }
        }
        return null;
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final void a(String str, String str2) {
        ne neVar;
        if (this.f147819b == null || this.f147819b.e_ == 0 || (neVar = this.f147819b.aC) == null) {
            return;
        }
        hi hiVar = neVar.f147918e;
        if (hiVar != null && !TextUtils.isEmpty(str)) {
            hiVar.d().a(str).b();
        }
        neVar.a(str, str2);
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final void a(LatLngBounds latLngBounds, int i3) {
        if (this.f147819b == null || this.f147819b.e_ == 0) {
            return;
        }
        this.f147819b.aC.a(latLngBounds, i3);
    }

    @Override // com.tencent.mapsdk.internal.ak
    public final void a(TencentMap.OnTrafficEventClickListener onTrafficEventClickListener) {
        if (this.f147819b == null || this.f147819b.e_ == 0) {
            return;
        }
        this.f147819b.f151037aq = onTrafficEventClickListener;
    }
}
