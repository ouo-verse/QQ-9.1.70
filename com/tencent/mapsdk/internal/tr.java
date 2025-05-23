package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.location.Location;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.map.tools.Callback;
import com.tencent.map.tools.ReturnCallback;
import com.tencent.map.tools.Util;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.mapsdk.engine.jni.models.TappedElement;
import com.tencent.mapsdk.internal.bi;
import com.tencent.mapsdk.internal.bj;
import com.tencent.mapsdk.internal.bp;
import com.tencent.mapsdk.internal.kp;
import com.tencent.mapsdk.internal.lb;
import com.tencent.mapsdk.internal.px;
import com.tencent.mapsdk.internal.qa;
import com.tencent.mapsdk.internal.sj;
import com.tencent.mapsdk.internal.so;
import com.tencent.mapsdk.vector.VectorMap;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMapInitializer;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Selectable;
import com.tencent.tencentmap.mapsdk.maps.model.AnimationListener;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorBuilding;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorLevel;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorMapPoi;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.MapPoi;
import com.tencent.tencentmap.mapsdk.maps.model.MapViewType;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.OverSeaSource;
import com.tencent.tencentmap.mapsdk.maps.model.OverSeaTileProvider;
import com.tencent.tencentmap.mapsdk.maps.model.Polygon;
import com.tencent.tencentmap.mapsdk.maps.model.SubPoi;
import com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener;
import com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListenerList;
import com.tencent.tencentmap.mapsdk.maps.model.TrafficEvent;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.lang.ref.WeakReference;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: P */
/* loaded from: classes9.dex */
public class tr extends tz implements TencentMap.OnCameraChangeListener {

    /* renamed from: bg, reason: collision with root package name */
    private static final String f151018bg = "copy_config";

    /* renamed from: bh, reason: collision with root package name */
    private static final String f151019bh = "async";

    /* renamed from: bi, reason: collision with root package name */
    private static final String f151020bi = "half_sync";
    public TencentMap.CancelableCallback A;
    public TencentMap.OnCompassClickedListener B;
    public bi.a C;
    public TencentMap.OnScaleViewChangedListener D;
    public TencentMap.OnCameraChangeListener E;
    public TencentMap.OnCameraChangeListener F;
    public Handler G;
    public long H;
    public Bitmap.Config I;
    public int J;
    public int K;
    public int L;
    public int M;
    public float N;
    public float O;
    public float P;
    public float Q;
    public boolean R;
    public boolean S;
    protected boolean T;
    protected boolean U;
    protected boolean V;
    protected boolean W;
    protected boolean X;
    public int Y;
    public int Z;
    private List<fp> aP;
    private final bc aQ;
    private qm aR;
    private final fo aS;
    private fs aT;
    private GeoPoint aU;
    private boolean aV;
    private volatile boolean aW;
    private boolean aX;
    private int aY;
    private int aZ;

    /* renamed from: aa, reason: collision with root package name */
    public boolean f151021aa;

    /* renamed from: ab, reason: collision with root package name */
    public boolean f151022ab;

    /* renamed from: ac, reason: collision with root package name */
    public LatLng f151023ac;

    /* renamed from: ad, reason: collision with root package name */
    public LatLng f151024ad;

    /* renamed from: ae, reason: collision with root package name */
    public int f151025ae;

    /* renamed from: af, reason: collision with root package name */
    public int f151026af;

    /* renamed from: ag, reason: collision with root package name */
    public int f151027ag;

    /* renamed from: ah, reason: collision with root package name */
    public int f151028ah;

    /* renamed from: ai, reason: collision with root package name */
    public int f151029ai;

    /* renamed from: aj, reason: collision with root package name */
    public int f151030aj;

    /* renamed from: ak, reason: collision with root package name */
    public int f151031ak;

    /* renamed from: al, reason: collision with root package name */
    final fd f151032al;

    /* renamed from: am, reason: collision with root package name */
    public boolean f151033am;

    /* renamed from: an, reason: collision with root package name */
    public ap f151034an;

    /* renamed from: ao, reason: collision with root package name */
    public boolean f151035ao;

    /* renamed from: ap, reason: collision with root package name */
    public pt f151036ap;

    /* renamed from: aq, reason: collision with root package name */
    public TencentMap.OnTrafficEventClickListener f151037aq;

    /* renamed from: ar, reason: collision with root package name */
    public List<MapPoi> f151038ar;

    /* renamed from: as, reason: collision with root package name */
    public List<be> f151039as;

    /* renamed from: ba, reason: collision with root package name */
    private float f151040ba;

    /* renamed from: bb, reason: collision with root package name */
    private gd f151041bb;

    /* renamed from: bc, reason: collision with root package name */
    private int f151042bc;

    /* renamed from: bd, reason: collision with root package name */
    private qj f151043bd;

    /* renamed from: be, reason: collision with root package name */
    private int f151044be;

    /* renamed from: bf, reason: collision with root package name */
    private boolean f151045bf;

    /* renamed from: bj, reason: collision with root package name */
    private boolean f151046bj;

    /* renamed from: bk, reason: collision with root package name */
    private boolean f151047bk;

    /* renamed from: bl, reason: collision with root package name */
    private final Map<qa.b, Boolean> f151048bl;

    /* renamed from: bm, reason: collision with root package name */
    private List<ap> f151049bm;

    /* renamed from: g, reason: collision with root package name */
    public final byte[] f151050g;

    /* renamed from: h, reason: collision with root package name */
    public String f151051h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f151052i;

    /* renamed from: j, reason: collision with root package name */
    public int f151053j;

    /* renamed from: k, reason: collision with root package name */
    public sp f151054k;

    /* renamed from: l, reason: collision with root package name */
    public rn f151055l;

    /* renamed from: m, reason: collision with root package name */
    public sj f151056m;

    /* renamed from: n, reason: collision with root package name */
    public qs f151057n;

    /* renamed from: o, reason: collision with root package name */
    public ac f151058o;

    /* renamed from: p, reason: collision with root package name */
    public AnimationListener f151059p;

    /* renamed from: q, reason: collision with root package name */
    public List<fj> f151060q;

    /* renamed from: r, reason: collision with root package name */
    public TencentMap.OnMapClickListener f151061r;

    /* renamed from: s, reason: collision with root package name */
    public bd f151062s;

    /* renamed from: t, reason: collision with root package name */
    public List<TencentMap.OnCameraChangeListener> f151063t;

    /* renamed from: u, reason: collision with root package name */
    public TencentMap.OnMapLongClickListener f151064u;

    /* renamed from: v, reason: collision with root package name */
    public TencentMap.OnDismissCallback f151065v;

    /* renamed from: w, reason: collision with root package name */
    protected TencentMap.OnIndoorStateChangeListener f151066w;

    /* renamed from: x, reason: collision with root package name */
    public TencentMap.OnMapPoiClickListener f151067x;

    /* renamed from: y, reason: collision with root package name */
    Handler f151068y;

    /* renamed from: z, reason: collision with root package name */
    CameraPosition f151069z;

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tr$1, reason: invalid class name */
    /* loaded from: classes9.dex */
    final class AnonymousClass1 implements Callback<fb> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ fb[] f151070a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GL10 f151071b;

        AnonymousClass1(fb[] fbVarArr, GL10 gl10) {
            this.f151070a = fbVarArr;
            this.f151071b = gl10;
        }

        private void a(fb fbVar) {
            if (fbVar instanceof aw) {
                if (TextUtils.equals(fbVar.getId(), tr.this.f151051h)) {
                    if (!fbVar.isVisible() && !tr.this.S) {
                        fbVar.releaseData();
                        return;
                    } else {
                        this.f151070a[0] = fbVar;
                        return;
                    }
                }
                fbVar.a(this.f151071b);
            }
        }

        @Override // com.tencent.map.tools.Callback
        public final /* synthetic */ void callback(fb fbVar) {
            fb fbVar2 = fbVar;
            if (fbVar2 instanceof aw) {
                if (TextUtils.equals(fbVar2.getId(), tr.this.f151051h)) {
                    if (!fbVar2.isVisible() && !tr.this.S) {
                        fbVar2.releaseData();
                        return;
                    } else {
                        this.f151070a[0] = fbVar2;
                        return;
                    }
                }
                fbVar2.a(this.f151071b);
            }
        }
    }

    public tr(Context context, TencentMapOptions tencentMapOptions, ViewGroup viewGroup) {
        super(context, tencentMapOptions, viewGroup);
        this.f151050g = new byte[0];
        this.f151051h = "";
        this.f151052i = false;
        this.f151053j = 22;
        this.f151054k = null;
        this.f151055l = null;
        this.f151058o = null;
        this.f151059p = null;
        this.f151060q = new CopyOnWriteArrayList();
        this.aP = null;
        this.f151061r = null;
        this.f151062s = null;
        this.f151063t = new CopyOnWriteArrayList();
        this.f151064u = null;
        this.f151065v = null;
        this.f151067x = null;
        this.aR = new tl(this);
        this.A = null;
        this.B = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.I = Bitmap.Config.RGB_565;
        this.J = Integer.MIN_VALUE;
        this.K = Integer.MIN_VALUE;
        this.L = Integer.MIN_VALUE;
        this.M = Integer.MIN_VALUE;
        this.N = 0.5f;
        this.O = 0.5f;
        this.P = 0.5f;
        this.Q = 0.5f;
        this.aU = null;
        this.aV = false;
        this.R = true;
        this.aW = false;
        this.aX = false;
        this.aY = 0;
        this.aZ = 0;
        this.S = false;
        this.T = true;
        this.U = true;
        this.V = true;
        this.W = true;
        this.X = true;
        this.Y = 19;
        this.Z = 3;
        this.f151040ba = 0.0f;
        this.f151021aa = true;
        this.f151022ab = true;
        this.f151023ac = null;
        this.f151024ad = null;
        this.f151025ae = 0;
        this.f151026af = 0;
        this.f151027ag = 0;
        this.f151028ah = 0;
        this.f151029ai = 0;
        this.f151030aj = 0;
        this.f151031ak = 0;
        this.f151042bc = 0;
        this.f151033am = false;
        this.f151034an = null;
        this.f151035ao = false;
        this.f151044be = 0;
        this.f151045bf = false;
        this.f151046bj = false;
        this.f151047bk = false;
        this.f151048bl = new ConcurrentHashMap();
        this.f151049bm = new ArrayList();
        this.f151038ar = new ArrayList();
        this.f151039as = new ArrayList();
        this.aS = new tw(this);
        this.f151032al = new tp(this);
        this.aR = new tl(this);
        this.aT = new tn(this);
        this.aQ = new tm(this);
        int[] d16 = ht.d(H());
        this.f151030aj = d16[0];
        this.f151031ak = d16[1];
    }

    private sp am() {
        return this.f151054k;
    }

    private boolean an() {
        return this.f151054k.f150369b.f150353e;
    }

    private sj ao() {
        return this.f151056m;
    }

    private void ap() {
        LogUtil.a(this.f147934f).b(lb.a.f149158e, "asyncCopyConfig: " + this.f151046bj + ", halfSyncCopyConfig: " + this.f151047bk);
        if (this.f151046bj) {
            qe.a(H(), ac().f147927c);
            return;
        }
        if (this.f151047bk) {
            Context H = H();
            String str = ac().f147927c;
            if (H != null) {
                String a16 = mz.a(H, (TencentMapOptions) null).a(str);
                mv a17 = mx.a(H, str);
                mw.c(a17, a16);
                mw.d(a17, a16);
                mw.a(H, a17, a16, er.f148275d);
                mw.a(H, a17, a16, er.f148273b);
                mw.a(H, a17, a16, er.f148274c);
                mw.a(H, a17, a16, er.f148276e);
                mw.a(H, a17, a16, er.f148277f);
                mw.a(H, a17, a16, er.f148278g);
                mw.a(H, a17, a16, er.f148279h);
            }
            VectorMap vectorMap = (VectorMap) this.e_;
            if (vectorMap != null) {
                vectorMap.u();
            }
        }
    }

    private boolean aq() {
        if (!this.f151125aw && as()) {
            return true;
        }
        return false;
    }

    private boolean ar() {
        if (!this.f151127ay && J()) {
            return true;
        }
        return false;
    }

    private boolean as() {
        VectorMap vectorMap = (VectorMap) this.e_;
        sp spVar = this.f151054k;
        if (vectorMap != null && vectorMap.f151350n && spVar != null && spVar.f150371d && J()) {
            return true;
        }
        return false;
    }

    private ge[] at() {
        GeoPoint[] i3 = this.aC.f149396i.i();
        ge[] geVarArr = new ge[4];
        for (int i16 = 0; i16 < 4; i16++) {
            geVarArr[i16] = y.b(i3[i16]);
        }
        return geVarArr;
    }

    private List<MapPoi> au() {
        ArrayList<MapPoi> N;
        this.f151038ar.clear();
        ne neVar = ((VectorMap) this.e_).f151351o;
        if (neVar == null) {
            N = null;
        } else {
            N = neVar.N();
        }
        this.f151038ar = N;
        return N;
    }

    private ge[] av() {
        return new ge[]{y.b(((VectorMap) this.e_).getProjection().a(new fw(0.0d, 0.0d))), y.b(((VectorMap) this.e_).getProjection().a(new fw(ai(), aj())))};
    }

    private void aw() {
        if (ak()) {
            if (this.aF instanceof View) {
                if (this.f151036ap == null) {
                    this.f151036ap = new pt((View) this.aF, this);
                }
                this.f151036ap.onTalkBackActivate(this.aF.getView());
                return;
            }
            return;
        }
        pt ptVar = this.f151036ap;
        if (ptVar != null) {
            ptVar.onTalkBackDeActivate(this.aF.getView());
            this.f151036ap = null;
        }
    }

    private boolean ax() {
        Handler handler = this.f151068y;
        if (handler == null || !handler.getLooper().getThread().isAlive()) {
            return false;
        }
        CameraPosition a16 = a();
        CameraPosition cameraPosition = this.f151069z;
        if (cameraPosition == null || !cameraPosition.equals(a16)) {
            this.f151068y.sendEmptyMessage(0);
            this.f151069z = a16;
            return true;
        }
        return true;
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final void A() {
        rn rnVar = this.f151055l;
        if (rnVar == null) {
            return;
        }
        rnVar.b();
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final boolean B() {
        rn rnVar = this.f151055l;
        if (rnVar == null || rnVar.f150106b == null) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final boolean C() {
        return this.f151035ao;
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final qj M() {
        return this.f151043bd;
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final TencentMap.OnMapClickListener V() {
        return this.f151061r;
    }

    @Override // com.tencent.mapsdk.internal.bq
    public final void X() {
        super.X();
        TencentMapOptions tencentMapOptions = this.f147933e;
        if (tencentMapOptions != null) {
            this.aV = tencentMapOptions.isHandDrawMapEnable();
            this.f151033am = this.f147933e.isMultipleInfoWindowEnable();
        }
        if ("qq".equals(tf.f150436c) && TextUtils.isEmpty(TencentMapInitializer.getExtra(f151018bg))) {
            TencentMapInitializer.addExtra(f151018bg, "async");
            LogUtil.a(this.f147934f).b(lb.a.f149158e, "qq channel async default.");
        }
        String extra = TencentMapInitializer.getExtra(f151018bg);
        if ("async".equals(extra)) {
            this.f151046bj = true;
        } else if (f151020bi.equals(extra)) {
            this.f151047bk = true;
        }
        LogUtil.a(this.f147934f).c(lb.a.f149158e, "valueOfCopyConfig: ".concat(String.valueOf(extra)));
    }

    @Override // com.tencent.mapsdk.internal.tz, com.tencent.mapsdk.internal.bq
    public final void Y() {
        super.Y();
        sp spVar = new sp(this);
        this.f151054k = spVar;
        Context context = this.f147932d;
        OverSeaSource overSeaSource = OverSeaSource.DEFAULT;
        so soVar = new so();
        spVar.f150369b = soVar;
        if (context != null) {
            soVar.f150357i = overSeaSource;
            kp.a((kp.g) new so.AnonymousClass2(context, overSeaSource)).a((kp.b.a) Boolean.FALSE, (kp.a<kp.b.a>) null);
        }
        this.Y = ((VectorMap) this.e_).q();
        this.Z = ((VectorMap) this.e_).p();
        Iterator<qa.b> it = this.f151048bl.keySet().iterator();
        while (it.hasNext()) {
            ((VectorMap) this.e_).a(it.next());
        }
        this.f151048bl.clear();
    }

    @Override // com.tencent.mapsdk.internal.bq
    public final void Z() {
        super.Z();
        if (this.aV) {
            z();
        }
    }

    public final bp.b ac() {
        return ((ne) this.d_).D();
    }

    @Override // com.tencent.mapsdk.internal.tz, com.tencent.mapsdk.internal.ua.m
    public final void ad() {
        super.ad();
        lc.c(lb.f149153ab, this.f147934f);
    }

    public final gd ae() {
        ge[] ag5 = ag();
        ge b16 = y.b(((VectorMap) this.e_).r());
        float s16 = ((VectorMap) this.e_).s();
        gd gdVar = this.f151041bb;
        if (gdVar == null) {
            this.f151041bb = new gd(b16, ag5, s16);
        } else {
            gdVar.a(b16, ag5, s16);
        }
        return this.f151041bb;
    }

    public final void af() {
        C c16 = this.d_;
        if (c16 != 0) {
            sm.a();
            c16.f147920g = !a(sm.c(sm.f150328a));
            sp spVar = this.f151054k;
            if (spVar != null) {
                spVar.b();
            }
            boolean m3 = c16.m();
            if (this.f151056m != null) {
                gd ae5 = ae();
                if (c16.f147920g && !c16.f147921h) {
                    sm.a();
                    ae5 = new gd(y.b(new GeoPoint(new LatLng(39.908823d, 116.39747d))), sm.c(sm.f150328a), 18.0f);
                }
                this.f151056m.a(ae5, m3);
                this.f151056m.a(m3);
            }
        }
    }

    public final ge[] ag() {
        GeoPoint[] i3 = this.aC.f149396i.i();
        ge[] geVarArr = new ge[4];
        for (int i16 = 0; i16 < 4; i16++) {
            geVarArr[i16] = y.b(i3[i16]);
        }
        return geVarArr;
    }

    public final List<ap> ah() {
        this.f151049bm.clear();
        Rect q16 = this.aC.f149398k.q();
        for (fb fbVar : this.aC.M.a(bj.a.DESC)) {
            if (fbVar instanceof ax) {
                ap apVar = ((ax) fbVar).f147778b;
                if (a(apVar.getPosition(), q16)) {
                    this.f151049bm.add(apVar);
                }
            }
        }
        return this.f151049bm;
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final void f(boolean z16) {
        this.X = z16;
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final void g(boolean z16) {
        this.f151124av = z16;
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final void h(boolean z16) {
        if (this.R != z16) {
            gc gcVar = new gc();
            gcVar.f148468f = 2;
            Iterator<fj> it = this.f151060q.iterator();
            while (it.hasNext()) {
                it.next().a(gcVar);
            }
        }
        this.R = z16;
        ae aeVar = ((VectorMap) this.e_).f151351o.f149398k;
        aeVar.G = z16;
        aeVar.f147743z.g().b(aeVar.G);
        ((VectorMap) this.e_).o();
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final boolean i() {
        return this.W;
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final boolean j() {
        return this.X;
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final void k() {
        Handler handler = this.f151068y;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        Handler handler2 = this.G;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
        }
        List<fp> list = this.aP;
        if (list != null) {
            list.clear();
            this.aP = null;
        }
        l();
        this.f151061r = null;
        this.aN = null;
        this.aM = null;
        this.f151064u = null;
        this.B = null;
        this.f151059p = null;
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final void l() {
        synchronized (this.f151050g) {
            this.aC.M.a();
        }
    }

    @Override // com.tencent.mapsdk.internal.bq
    public final void m(boolean z16) {
        super.m(z16);
        af();
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final void n() {
        if (this.f151060q.isEmpty()) {
            return;
        }
        gc gcVar = new gc();
        gcVar.f148468f = 0;
        gcVar.f148469g = this.f151021aa;
        gcVar.f148470h = this.f151022ab;
        Iterator<fj> it = this.f151060q.iterator();
        while (it.hasNext()) {
            it.next().a(gcVar);
        }
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final boolean o() {
        return this.f151021aa;
    }

    @Override // com.tencent.mapsdk.internal.fc
    public final void o_() {
        ae aeVar = ((VectorMap) this.e_).f151351o.f149398k;
        aeVar.o();
        aeVar.j();
        TencentMap.OnCompassClickedListener onCompassClickedListener = this.B;
        if (onCompassClickedListener != null) {
            onCompassClickedListener.onCompassClicked();
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCameraChangeListener
    public void onCameraChange(final CameraPosition cameraPosition) {
        this.f151128az = false;
        this.aA = true;
        kp.a(new Runnable() { // from class: com.tencent.mapsdk.internal.tr.7
            @Override // java.lang.Runnable
            public final void run() {
                List<TencentMap.OnCameraChangeListener> list = tr.this.f151063t;
                if (list != null) {
                    for (TencentMap.OnCameraChangeListener onCameraChangeListener : list) {
                        if (onCameraChangeListener != null) {
                            onCameraChangeListener.onCameraChange(cameraPosition);
                        }
                    }
                }
                if (tr.this.E != null) {
                    tr.this.E.onCameraChange(cameraPosition);
                }
                if (tr.this.F != null) {
                    tr.this.F.onCameraChange(cameraPosition);
                }
            }
        });
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCameraChangeListener
    public void onCameraChangeFinished(final CameraPosition cameraPosition) {
        if (this.aB == 0 && this.f151128az) {
            this.aA = false;
            kp.a(new Runnable() { // from class: com.tencent.mapsdk.internal.tr.8
                @Override // java.lang.Runnable
                public final void run() {
                    List<TencentMap.OnCameraChangeListener> list = tr.this.f151063t;
                    if (list != null) {
                        for (TencentMap.OnCameraChangeListener onCameraChangeListener : list) {
                            if (onCameraChangeListener != null) {
                                onCameraChangeListener.onCameraChangeFinished(cameraPosition);
                            }
                        }
                    }
                    if (tr.this.E != null) {
                        tr.this.E.onCameraChangeFinished(cameraPosition);
                    }
                    if (tr.this.F != null) {
                        tr.this.F.onCameraChangeFinished(cameraPosition);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mapsdk.internal.tz, com.tencent.mapsdk.internal.bq, com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void onCreated() {
        super.onCreated();
        this.f151068y = new tj(this, kp.a("gesture"));
        this.f151043bd = new qj((bf) this.d_);
        ((VectorMap) this.e_).a(this.aR);
        a(this.f151032al);
        ((VectorMap) this.e_).a(this.aQ);
        ((VectorMap) this.e_).a(this.aT);
        ((VectorMap) this.e_).a(this.aR);
        ((VectorMap) this.e_).a(this.aS);
        ((VectorMap) this.e_).a((fc) this);
        this.f151058o = new ac(this, ac().f147927c);
    }

    @Override // com.tencent.mapsdk.internal.tz, com.tencent.mapsdk.internal.bq, com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void onDestroy() {
        ((VectorMap) this.e_).a((fc) null);
        List<TencentMap.OnCameraChangeListener> list = this.f151063t;
        if (list != null) {
            list.clear();
        }
        pt ptVar = this.f151036ap;
        if (ptVar != null) {
            ((VectorMap) ptVar.f149662c.e_).b(ptVar);
            ptVar.accessibleTouchItems.clear();
            ptVar.f149660a.clear();
            ptVar.f149661b.clear();
        }
        this.f151067x = null;
        this.f151037aq = null;
        this.D = null;
        this.f151048bl.clear();
        super.onDestroy();
        this.aX = true;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnIndoorStateChangeListener
    public boolean onIndoorBuildingDeactivated() {
        return ((ne) this.d_).M.a((IndoorBuilding) null);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnIndoorStateChangeListener
    public boolean onIndoorBuildingFocused() {
        return false;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnIndoorStateChangeListener
    public boolean onIndoorLevelActivated(IndoorBuilding indoorBuilding) {
        return ((ne) this.d_).M.a(indoorBuilding);
    }

    @Override // com.tencent.mapsdk.internal.tz, com.tencent.mapsdk.internal.bq, com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void onResume() {
        IndoorBuilding indoorBuilding;
        super.onResume();
        this.aB = 0;
        this.aA = false;
        if (ak()) {
            if (this.aF instanceof View) {
                if (this.f151036ap == null) {
                    this.f151036ap = new pt((View) this.aF, this);
                }
                this.f151036ap.onTalkBackActivate(this.aF.getView());
            }
        } else {
            pt ptVar = this.f151036ap;
            if (ptVar != null) {
                ptVar.onTalkBackDeActivate(this.aF.getView());
                this.f151036ap = null;
            }
        }
        ac acVar = this.f151058o;
        if (acVar != null && (indoorBuilding = acVar.f147694g) != null) {
            String buidlingId = indoorBuilding.getBuidlingId();
            int activeLevelIndex = acVar.f147694g.getActiveLevelIndex();
            List<IndoorLevel> levels = acVar.f147694g.getLevels();
            if (levels != null && activeLevelIndex < levels.size()) {
                String name = levels.get(activeLevelIndex).getName();
                if (!hs.a(buidlingId) && !hs.a(name)) {
                    acVar.f147692e.a(buidlingId, name);
                }
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.tz, com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public boolean onTouchEvent(MotionEvent motionEvent) {
        bd bdVar = this.f151062s;
        if (bdVar != null) {
            bdVar.a(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final boolean p() {
        return this.f151022ab;
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final qs q() {
        return this.f151057n;
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final ac r() {
        return this.f151058o;
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final GeoPoint s() {
        if (this.aU == null) {
            if (this.J == Integer.MIN_VALUE) {
                this.J = this.f151030aj / 2;
            }
            if (this.K == Integer.MIN_VALUE) {
                this.K = this.f151031ak / 2;
            }
            this.aU = ((VectorMap) this.e_).getProjection().a(new fw(this.J, this.K));
        }
        return this.aU;
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final int t() {
        return this.L;
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final int u() {
        return this.M;
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final int v() {
        return this.J;
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final int w() {
        return this.K;
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final TencentMap.OnMapPoiClickListener x() {
        return this.f151067x;
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final boolean y() {
        return this.aW;
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final void z() {
        if (this.f151055l == null) {
            this.f151055l = new rn(this);
        }
        this.f151055l.a();
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final void a(Handler handler, Bitmap.Config config, int i3) {
        this.G = handler;
        this.I = config;
        if (i3 >= 0) {
            this.H = SystemClock.elapsedRealtime() + i3;
        } else {
            this.H = Long.MAX_VALUE;
        }
        I();
        G();
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final void b(String str) {
        synchronized (this.f151050g) {
            this.f151051h = str;
        }
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final void c(boolean z16) {
        this.T = z16;
    }

    public final void e(int i3, int i16) {
        List<fp> list = this.aP;
        if (list != null) {
            int size = list.size();
            for (int i17 = 0; i17 < size; i17++) {
                fp fpVar = this.aP.get(i17);
                if (fpVar != null) {
                    fpVar.b(i3, i16);
                }
            }
        }
        C c16 = this.d_;
        if (c16 != 0) {
            Iterator<fb> it = ((ne) c16).M.f147862a.values().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final boolean f() {
        return this.R;
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final boolean g() {
        return this.U;
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final void i(boolean z16) {
        if (z16 && !this.f151054k.f150369b.f150353e) {
            ((VectorMap) this.e_).a((bc) null);
        } else {
            ((VectorMap) this.e_).a(this.aQ);
        }
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final void j(boolean z16) {
        this.S = z16;
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final void c(int i3, int i16) {
        this.J = i3;
        this.K = i16;
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final so d() {
        return this.f151054k.f150369b;
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final boolean f(float f16, float f17) {
        MapPoi mapPoi;
        sa saVar;
        TappedElement a16 = ((VectorMap) this.e_).a(f16, f17);
        if (a16 == null) {
            return false;
        }
        int i3 = a16.type;
        if (i3 != 1) {
            if (i3 == 4) {
                ne neVar = this.aC;
                if (neVar == null || (saVar = neVar.D) == null) {
                    return false;
                }
                TrafficEvent a17 = saVar.a((int) a16.itemId);
                TencentMap.OnTrafficEventClickListener onTrafficEventClickListener = this.f151037aq;
                if (onTrafficEventClickListener == null || a17 == null) {
                    return false;
                }
                onTrafficEventClickListener.onTrafficEventClicked(a17);
                return true;
            }
            if (i3 != 8) {
                return false;
            }
        } else if (this.f151067x != null) {
            if (a16.itemType == 1) {
                IndoorMapPoi indoorMapPoi = new IndoorMapPoi();
                indoorMapPoi.buildingName = a16.buildingName;
                indoorMapPoi.buildingId = a16.buildingId;
                indoorMapPoi.floorName = a16.floorName;
                mapPoi = indoorMapPoi;
            } else {
                mapPoi = new MapPoi();
            }
            mapPoi.name = a16.name;
            mapPoi.position = new GeoPoint((int) (Math.toDegrees((Math.atan(Math.exp(3.141592653589793d - (a16.pixelY / 4.272282972352698E7d))) - 0.7853981633974483d) * 2.0d) * 1000000.0d), (int) (Math.toDegrees((a16.pixelX / 4.272282972352698E7d) - 3.141592653589793d) * 1000000.0d)).toLatLng();
            mapPoi.poiId = a16.poiId;
            this.f151067x.onClicked(mapPoi);
        }
        return true;
    }

    @Override // com.tencent.mapsdk.internal.bb
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public final ax d(final float f16, final float f17) {
        final ax[] axVarArr = {null};
        synchronized (this.f151050g) {
            Util.where(((ne) this.d_).M.d(), new ReturnCallback<Boolean, fb>() { // from class: com.tencent.mapsdk.internal.tr.4
                private Boolean a(fb fbVar) {
                    if (fbVar != null && fbVar.isVisible()) {
                        if (!(fbVar instanceof ax)) {
                            return Boolean.FALSE;
                        }
                        if (!fbVar.onTap(f16, f17)) {
                            return Boolean.FALSE;
                        }
                        axVarArr[0] = (ax) fbVar;
                        return Boolean.TRUE;
                    }
                    return Boolean.FALSE;
                }

                @Override // com.tencent.map.tools.ReturnCallback
                public final /* synthetic */ Boolean callback(fb fbVar) {
                    fb fbVar2 = fbVar;
                    if (fbVar2 != null && fbVar2.isVisible()) {
                        if (!(fbVar2 instanceof ax)) {
                            return Boolean.FALSE;
                        }
                        if (!fbVar2.onTap(f16, f17)) {
                            return Boolean.FALSE;
                        }
                        axVarArr[0] = (ax) fbVar2;
                        return Boolean.TRUE;
                    }
                    return Boolean.FALSE;
                }
            });
        }
        return axVarArr[0];
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final void m() {
        int s16 = ((VectorMap) this.e_).s();
        this.f151021aa = true;
        this.f151022ab = true;
        if (s16 <= this.Z) {
            this.f151022ab = false;
        } else if (s16 >= this.Y) {
            this.f151021aa = false;
        }
        if (this.f151060q.isEmpty()) {
            return;
        }
        gc gcVar = new gc();
        gcVar.f148468f = 0;
        gcVar.f148469g = this.f151021aa;
        gcVar.f148470h = this.f151022ab;
        Iterator<fj> it = this.f151060q.iterator();
        while (it.hasNext()) {
            it.next().a(gcVar);
        }
    }

    private void c(TencentMap.OnCameraChangeListener onCameraChangeListener) {
        this.F = onCameraChangeListener;
    }

    /* JADX WARN: Code restructure failed: missing block: B:84:0x01ad, code lost:
    
        if (r1 != 8) goto L115;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:87:0x023e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x023f  */
    /* JADX WARN: Type inference failed for: r3v29, types: [com.tencent.tencentmap.mapsdk.maps.model.Marker] */
    @Override // com.tencent.mapsdk.internal.bb
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean b(final float f16, final float f17) {
        boolean z16;
        boolean a16;
        boolean z17;
        int i3;
        MapPoi mapPoi;
        sa saVar;
        TencentMap.OnPolygonClickListener onPolygonClickListener;
        TencentMap.OnPolylineClickListener onPolylineClickListener;
        synchronized (this.f151050g) {
            pp ppVar = (pp) c(this.f151051h);
            fb fbVar = null;
            ey eyVar = ppVar != null ? ppVar.G : null;
            if (this.f151051h.equals("") || ppVar == null || eyVar == null || !eyVar.c()) {
                ppVar = null;
                eyVar = null;
                z16 = false;
            } else {
                z16 = eyVar.onTap(f16, f17);
                if (!z16) {
                    ppVar = null;
                    eyVar = null;
                }
            }
            if (!z16) {
                final Object[] objArr = {Boolean.valueOf(z16), ppVar, eyVar};
                Util.where(((ne) this.d_).M.a(bj.a.DESC), new ReturnCallback<Boolean, fb>() { // from class: com.tencent.mapsdk.internal.tr.2
                    private Boolean a(fb fbVar2) {
                        if (fbVar2 instanceof ax) {
                            ax axVar = (ax) fbVar2;
                            ey h16 = axVar.f147778b.h();
                            if (!axVar.getId().equals(tr.this.f151051h) && h16 != null && h16.c()) {
                                boolean onTap = h16.onTap(f16, f17);
                                objArr[0] = Boolean.valueOf(onTap);
                                if (onTap) {
                                    Object[] objArr2 = objArr;
                                    objArr2[1] = axVar;
                                    objArr2[2] = h16;
                                    return Boolean.TRUE;
                                }
                            }
                        }
                        return Boolean.FALSE;
                    }

                    @Override // com.tencent.map.tools.ReturnCallback
                    public final /* synthetic */ Boolean callback(fb fbVar2) {
                        fb fbVar3 = fbVar2;
                        if (fbVar3 instanceof ax) {
                            ax axVar = (ax) fbVar3;
                            ey h16 = axVar.f147778b.h();
                            if (!axVar.getId().equals(tr.this.f151051h) && h16 != null && h16.c()) {
                                boolean onTap = h16.onTap(f16, f17);
                                objArr[0] = Boolean.valueOf(onTap);
                                if (onTap) {
                                    Object[] objArr2 = objArr;
                                    objArr2[1] = axVar;
                                    objArr2[2] = h16;
                                    return Boolean.TRUE;
                                }
                            }
                        }
                        return Boolean.FALSE;
                    }
                });
                z16 = ((Boolean) objArr[0]).booleanValue();
                ?? r36 = (Marker) objArr[1];
                eyVar = (ey) objArr[2];
                ppVar = r36;
            }
            if (z16) {
                if (this.e_ != null && this.aN != null && ppVar != null && eyVar != null && ppVar.isInfoWindowShown()) {
                    this.aN.onInfoWindowClick(ppVar);
                    Rect screenBound = eyVar.getScreenBound(((VectorMap) this.e_).getProjection());
                    if (screenBound != null) {
                        this.aN.onInfoWindowClickLocation(screenBound.width(), screenBound.height(), ((int) f16) - screenBound.left, ((int) f17) - screenBound.top);
                    }
                }
                return true;
            }
            bj bjVar = this.aC.M;
            List<fb> a17 = bjVar.a(bj.a.DESC);
            int size = a17.size();
            boolean z18 = false;
            for (int i16 = 0; i16 < size; i16++) {
                fbVar = a17.get(i16);
                z18 = a(fbVar, f16, f17);
                if (z18) {
                    break;
                }
            }
            if (!z18) {
                bj.a aVar = bj.a.DESC;
                ArrayList arrayList = new ArrayList(bjVar.f147866e);
                arrayList.addAll(bjVar.f147865d);
                Collections.sort(arrayList, aVar.f147876c);
                int size2 = arrayList.size();
                for (int i17 = 0; i17 < size2; i17++) {
                    fbVar = (fb) arrayList.get(i17);
                    z18 = a(fbVar, f16, f17);
                    if (z18) {
                        break;
                    }
                }
            }
            if (!z18) {
                List<Polygon> c16 = bjVar.c();
                for (int size3 = c16.size() - 1; size3 >= 0; size3--) {
                    fbVar = (fb) c16.get(size3);
                    z18 = a(fbVar, f16, f17);
                    if (z18) {
                        break;
                    }
                }
            }
            if (z18) {
                if (fbVar instanceof ax) {
                    a16 = a((ax) fbVar, false);
                } else if (fbVar instanceof az) {
                    az azVar = (az) fbVar;
                    if (azVar.isClickable() && (onPolylineClickListener = this.aH) != null) {
                        onPolylineClickListener.onPolylineClick(azVar, ((ne) this.d_).f149403p.fromScreenLocation(new Point((int) f16, (int) f17)));
                        a16 = true;
                    }
                    a16 = false;
                } else {
                    if (fbVar instanceof ay) {
                        ay ayVar = (ay) fbVar;
                        if (ayVar.isClickable() && (onPolygonClickListener = this.aI) != null) {
                            onPolygonClickListener.onPolygonClick(ayVar, ((ne) this.d_).f149403p.fromScreenLocation(new Point((int) f16, (int) f17)));
                            a16 = true;
                        }
                    }
                    a16 = false;
                }
            } else {
                a16 = bjVar.f147871j.a(f16, f17);
            }
            if (a16) {
                return a16;
            }
            if (this.f151052i) {
                synchronized (this.f151050g) {
                    Util.foreach(((ne) this.d_).M.a(bj.a.DESC), new Callback<fb>() { // from class: com.tencent.mapsdk.internal.tr.3
                        private static void a(fb fbVar2) {
                            if (fbVar2 instanceof ax) {
                                ap apVar = ((ax) fbVar2).f147778b;
                                if (apVar.h() != null) {
                                    apVar.hideInfoWindow();
                                }
                            }
                        }

                        @Override // com.tencent.map.tools.Callback
                        public final /* synthetic */ void callback(fb fbVar2) {
                            fb fbVar3 = fbVar2;
                            if (fbVar3 instanceof ax) {
                                ap apVar = ((ax) fbVar3).f147778b;
                                if (apVar.h() != null) {
                                    apVar.hideInfoWindow();
                                }
                            }
                        }
                    });
                }
            }
            TappedElement a18 = ((VectorMap) this.e_).a(f16, f17);
            if (a18 != null && (i3 = a18.type) != 0) {
                if (i3 != 1) {
                    if (i3 == 4) {
                        ne neVar = this.aC;
                        if (neVar != null && (saVar = neVar.D) != null) {
                            TrafficEvent a19 = saVar.a((int) a18.itemId);
                            TencentMap.OnTrafficEventClickListener onTrafficEventClickListener = this.f151037aq;
                            if (onTrafficEventClickListener != null && a19 != null) {
                                onTrafficEventClickListener.onTrafficEventClicked(a19);
                            }
                        }
                    }
                    if (z17) {
                        return true;
                    }
                    if (this.f151061r != null && this.f151124av) {
                        this.f151061r.onMapClick(ks.a(((VectorMap) this.e_).getProjection().a(new fw(f16, f17))));
                    }
                    G();
                    return false;
                }
                if (this.f151067x != null) {
                    if (a18.itemType == 1) {
                        IndoorMapPoi indoorMapPoi = new IndoorMapPoi();
                        indoorMapPoi.buildingName = a18.buildingName;
                        indoorMapPoi.buildingId = a18.buildingId;
                        indoorMapPoi.floorName = a18.floorName;
                        mapPoi = indoorMapPoi;
                    } else {
                        mapPoi = new MapPoi();
                    }
                    mapPoi.name = a18.name;
                    mapPoi.position = new GeoPoint((int) (Math.toDegrees((Math.atan(Math.exp(3.141592653589793d - (a18.pixelY / 4.272282972352698E7d))) - 0.7853981633974483d) * 2.0d) * 1000000.0d), (int) (Math.toDegrees((a18.pixelX / 4.272282972352698E7d) - 3.141592653589793d) * 1000000.0d)).toLatLng();
                    mapPoi.poiId = a18.poiId;
                    this.f151067x.onClicked(mapPoi);
                }
                z17 = true;
                if (z17) {
                }
            }
            z17 = false;
            if (z17) {
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final void d(boolean z16) {
        this.V = z16;
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final boolean c(float f16, float f17) {
        tk tkVar;
        ne neVar = this.aC;
        fd fdVar = this.f151032al;
        if (neVar.P == null) {
            nh<?> nhVar = neVar.f149400m.f147881e.get(nr.class);
            if ((nhVar != null ? nhVar.f() : false) && (tkVar = neVar.f149396i) != null) {
                tkVar.f150514d.scheduleClickOnNextRender(tkVar.f150515e, f16, f17);
                neVar.P = fdVar;
                return true;
            }
        }
        neVar.P = null;
        return false;
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final boolean d(String str) {
        boolean z16;
        aq f_;
        if (str == null) {
            return false;
        }
        synchronized (this.f151050g) {
            bj bjVar = this.aC.M;
            fb remove = bjVar.f147862a.remove(str);
            if (remove != null) {
                if (remove instanceof ax) {
                    bjVar.f147863b.remove(remove);
                } else if (remove instanceof at) {
                    bjVar.f147865d.remove(remove);
                } else if (remove instanceof az) {
                    bjVar.f147866e.remove(remove);
                } else if (remove instanceof au) {
                    bjVar.f147868g.remove(remove);
                } else if (remove instanceof ao) {
                    bjVar.f147864c.remove(remove);
                } else if (remove instanceof ay) {
                    bjVar.f147867f.remove(remove);
                }
                if ((remove instanceof aw) && (f_ = ((aw) remove).f_()) != null) {
                    bjVar.f147869h.remove(f_);
                }
            }
            z16 = remove != null;
            if (z16) {
                ((VectorMap) this.e_).o();
            }
        }
        return z16;
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final void a(String str) {
        b(str);
    }

    public final boolean n(boolean z16) {
        Handler handler = this.f151068y;
        if (handler == null || !handler.getLooper().getThread().isAlive()) {
            return false;
        }
        LogUtil.b(ky.f149101g, "send onStable Event");
        this.f151068y.sendEmptyMessage(z16 ? 2 : 1);
        return true;
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final boolean a(float f16, float f17) {
        ax d16;
        if (this.f151062s != null && (d16 = d(f16, f17)) != null) {
            this.f151062s.a(d16.getId());
            a(d16, true);
            return true;
        }
        if (this.f151064u == null || !this.f151124av) {
            return false;
        }
        this.f151064u.onMapLongClick(ks.a(((VectorMap) this.e_).getProjection().a(new fw(f16, f17))));
        return false;
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final String e() {
        return this.f151051h;
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final void e(boolean z16) {
        this.W = z16;
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x00e2, code lost:
    
        r5 = com.tencent.mapsdk.internal.pw.a(r0.getId(), r5);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00f7 A[RETURN] */
    @Override // com.tencent.mapsdk.internal.bb
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean e(float f16, float f17) {
        byte b16;
        boolean z16;
        byte b17;
        py pyVar;
        SubPoi subPoi;
        px.d dVar;
        List<px.d> list;
        WeakReference<TencentMap.OnMyLocationClickListener> weakReference;
        TencentMap.OnMyLocationClickListener onMyLocationClickListener;
        if (!this.f151124av) {
            return false;
        }
        VectorMap vectorMap = (VectorMap) this.e_;
        bk bkVar = vectorMap.f151351o.f149400m;
        TappedElement a16 = bkVar.f147877a.g().a(f16, f17);
        if (a16 == null || a16.type != 3) {
            b16 = false;
        } else {
            fc fcVar = bkVar.f147880d;
            if (fcVar != null) {
                fcVar.o_();
            }
            b16 = true;
        }
        if (b16 == false) {
            bh bhVar = vectorMap.f151355s;
            if (bhVar != null) {
                TappedElement a17 = bhVar.f147806j.f149400m.f147877a.g().a(f16, f17);
                z16 = a17 != null && a17.type == 6;
                if (z16 && (weakReference = bhVar.f147802f) != null && (onMyLocationClickListener = weakReference.get()) != null) {
                    LatLng latLng = new LatLng();
                    Location location = bhVar.f147805i;
                    if (location != null) {
                        latLng.setAltitude(location.getAltitude());
                        latLng.setLongitude(bhVar.f147805i.getLongitude());
                        latLng.setLatitude(bhVar.f147805i.getLatitude());
                    }
                    z16 = onMyLocationClickListener.onMyLocationClicked(latLng);
                }
            } else {
                z16 = false;
            }
            if (!z16) {
                TappedElement a18 = vectorMap.a(f16, f17);
                if (a18 != null && (pyVar = vectorMap.f151356t) != null && pyVar.f149723c != null && a18.type == 4) {
                    long j3 = a18.itemId;
                    Iterator<pw> it = pyVar.f149721a.iterator();
                    while (true) {
                        subPoi = null;
                        r5 = null;
                        r5 = null;
                        r5 = null;
                        px.d dVar2 = null;
                        if (!it.hasNext()) {
                            break;
                        }
                        pw next = it.next();
                        px pxVar = next.f149671b;
                        if (pxVar != null && (dVar = pxVar.f149690a) != null && (list = dVar.f149708j) != null) {
                            Iterator<px.d> it5 = list.iterator();
                            while (true) {
                                if (!it5.hasNext()) {
                                    break;
                                }
                                px.d next2 = it5.next();
                                if (((oc) next.f149670a.f149722b.f149400m.a(oc.class, next2.f149699a)) != null && r8.a() == j3) {
                                    dVar2 = next2;
                                    break;
                                }
                            }
                        }
                    }
                    if (subPoi != null) {
                        pyVar.f149723c.onClicked(subPoi);
                        b17 = true;
                        if (b17 != false) {
                            return false;
                        }
                    }
                }
                b17 = false;
                if (b17 != false) {
                }
            }
        }
        return true;
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final po c(String str) {
        C c16 = this.d_;
        if (c16 == 0) {
            return null;
        }
        fb a16 = ((ne) c16).M.a(str);
        if (!(a16 instanceof aw)) {
            return null;
        }
        Selectable f_ = ((aw) a16).f_();
        if (f_ instanceof po) {
            return (po) f_;
        }
        return null;
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final boolean h() {
        return this.V;
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final void k(boolean z16) {
        this.f151035ao = z16;
    }

    private boolean h(float f16, float f17) {
        TencentMap.OnPolygonClickListener onPolygonClickListener;
        TencentMap.OnPolylineClickListener onPolylineClickListener;
        bj bjVar = this.aC.M;
        List<fb> a16 = bjVar.a(bj.a.DESC);
        int size = a16.size();
        fb fbVar = null;
        boolean z16 = false;
        for (int i3 = 0; i3 < size; i3++) {
            fbVar = a16.get(i3);
            z16 = a(fbVar, f16, f17);
            if (z16) {
                break;
            }
        }
        if (!z16) {
            bj.a aVar = bj.a.DESC;
            ArrayList arrayList = new ArrayList(bjVar.f147866e);
            arrayList.addAll(bjVar.f147865d);
            Collections.sort(arrayList, aVar.f147876c);
            int size2 = arrayList.size();
            for (int i16 = 0; i16 < size2; i16++) {
                fbVar = (fb) arrayList.get(i16);
                z16 = a(fbVar, f16, f17);
                if (z16) {
                    break;
                }
            }
        }
        if (!z16) {
            List<Polygon> c16 = bjVar.c();
            for (int size3 = c16.size() - 1; size3 >= 0; size3--) {
                fbVar = (fb) c16.get(size3);
                z16 = a(fbVar, f16, f17);
                if (z16) {
                    break;
                }
            }
        }
        if (z16) {
            if (fbVar instanceof ax) {
                return a((ax) fbVar, false);
            }
            if (fbVar instanceof az) {
                az azVar = (az) fbVar;
                if (!azVar.isClickable() || (onPolylineClickListener = this.aH) == null) {
                    return false;
                }
                onPolylineClickListener.onPolylineClick(azVar, ((ne) this.d_).f149403p.fromScreenLocation(new Point((int) f16, (int) f17)));
            } else {
                if (!(fbVar instanceof ay)) {
                    return false;
                }
                ay ayVar = (ay) fbVar;
                if (!ayVar.isClickable() || (onPolygonClickListener = this.aI) == null) {
                    return false;
                }
                onPolygonClickListener.onPolygonClick(ayVar, ((ne) this.d_).f149403p.fromScreenLocation(new Point((int) f16, (int) f17)));
            }
            return true;
        }
        return bjVar.f147871j.a(f16, f17);
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final void a(fp fpVar) {
        if (this.aP == null) {
            this.aP = new ArrayList();
        }
        if (this.aP.contains(fpVar)) {
            return;
        }
        this.aP.add(fpVar);
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final void a(boolean z16) {
        this.f151052i = z16;
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final void a(bd bdVar) {
        this.f151062s = bdVar;
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final void a(TencentMapGestureListener tencentMapGestureListener) {
        if (this.f151123au == null) {
            this.f151123au = new TencentMapGestureListenerList();
        }
        this.f151123au.addListener(tencentMapGestureListener);
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final void a(int i3) {
        this.aZ = i3;
        a(this.aY, i3);
        G();
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final void d(int i3, int i16) {
        this.L = i3;
        this.M = i16;
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final void a(int i3, int i16) {
        this.aY = i3;
        this.aZ = i16;
        ((VectorMap) this.e_).c(i3, i16);
        G();
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final void a(bi.a aVar) {
        this.C = aVar;
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final void a(float f16) {
        if (this.f151040ba == f16) {
            return;
        }
        this.f151040ba = f16;
        if (this.f151060q.isEmpty()) {
            return;
        }
        gc gcVar = new gc();
        gcVar.f148468f = 1;
        gcVar.f148471i = ((VectorMap) this.e_).s();
        gcVar.f148472j = ((VectorMap) this.e_).getProjection().a(new Point(0, this.f151031ak / 2), new Point(this.f151030aj, this.f151031ak / 2));
        Iterator<fj> it = this.f151060q.iterator();
        while (it.hasNext()) {
            it.next().a(gcVar);
        }
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final void a(fj fjVar) {
        this.f151060q.remove(fjVar);
        this.f151060q.add(fjVar);
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final void a(TencentMap.OnDismissCallback onDismissCallback) {
        this.f151065v = onDismissCallback;
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final void a(TencentMap.OnIndoorStateChangeListener onIndoorStateChangeListener) {
        this.f151066w = onIndoorStateChangeListener;
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final void a(TencentMap.OnMapPoiClickListener onMapPoiClickListener) {
        this.f151067x = onMapPoiClickListener;
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final void a(sj sjVar) {
        this.f151056m = sjVar;
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final void a(qs qsVar) {
        this.f151057n = qsVar;
    }

    private void a(TencentMap.OnScaleViewChangedListener onScaleViewChangedListener) {
        this.D = onScaleViewChangedListener;
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final void a(TencentMap.OnCameraChangeListener onCameraChangeListener) {
        List<TencentMap.OnCameraChangeListener> list = this.f151063t;
        if (list != null && onCameraChangeListener != null) {
            list.add(onCameraChangeListener);
        }
        if ((onCameraChangeListener == null) && !this.f151054k.f150369b.f150353e) {
            ((VectorMap) this.e_).a((bc) null);
        } else {
            ((VectorMap) this.e_).a(this.aQ);
        }
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final void a(OverSeaTileProvider overSeaTileProvider) {
        sp spVar = this.f151054k;
        if (spVar == null || spVar.f150370c == overSeaTileProvider) {
            return;
        }
        LogUtil.c(ky.f149103i, "\u8bbe\u7f6e\u81ea\u5b9a\u4e49\u6d77\u5916\u56fe\u6e90\uff0cold[" + spVar.f150370c + "] to new[" + overSeaTileProvider + "]");
        spVar.f150370c = overSeaTileProvider;
        spVar.f150372e = true;
        so soVar = spVar.f150369b;
        soVar.f150359k = overSeaTileProvider;
        List<ss> c16 = soVar.c();
        tr trVar = spVar.f150368a;
        if (trVar != null) {
            trVar.a(false, c16);
        }
        spVar.a();
    }

    @Override // com.tencent.mapsdk.internal.tz, com.tencent.mapsdk.internal.ua.m
    public final void a(GL10 gl10, int i3, int i16) {
        super.a(gl10, i3, i16);
        this.f151030aj = i3;
        this.f151031ak = i16;
        c((int) (i3 * this.N), (int) (i16 * this.O));
        d((int) (this.f151030aj * this.P), (int) (this.f151031ak * this.Q));
        bi.a aVar = this.C;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // com.tencent.mapsdk.internal.tz, com.tencent.mapsdk.internal.ua.m
    public final boolean a(GL10 gl10) {
        List<sj.c> list;
        List<sj.c> list2;
        int i3;
        bj bjVar;
        final TencentMap.OnMapFrameFinishCallback W = W();
        if (!this.f151126ax) {
            if (W != null) {
                kp.a(new Runnable() { // from class: com.tencent.mapsdk.internal.tr.5
                    @Override // java.lang.Runnable
                    public final void run() {
                        W.onMapFrameStart();
                    }
                });
            }
            this.f151126ax = true;
            this.aC.f149398k.c();
        }
        C c16 = this.d_;
        boolean z16 = false;
        if (c16 != 0 && (bjVar = ((ne) c16).M) != null) {
            synchronized (this.f151050g) {
                fb[] fbVarArr = {null};
                Util.foreach(bjVar.d(), new AnonymousClass1(fbVarArr, gl10));
                fb fbVar = fbVarArr[0];
                if (fbVar != null) {
                    fbVar.a(gl10);
                }
            }
        }
        boolean a16 = super.a(gl10);
        if (!this.f151045bf) {
            if (aa() != MapViewType.SurfaceView || (i3 = this.f151044be) == 1) {
                LogUtil.a(this.f147934f).b(lb.a.f149158e, "asyncCopyConfig: " + this.f151046bj + ", halfSyncCopyConfig: " + this.f151047bk);
                if (this.f151046bj) {
                    qe.a(H(), ac().f147927c);
                } else if (this.f151047bk) {
                    Context H = H();
                    String str = ac().f147927c;
                    if (H != null) {
                        String a17 = mz.a(H, (TencentMapOptions) null).a(str);
                        mv a18 = mx.a(H, str);
                        mw.c(a18, a17);
                        mw.d(a18, a17);
                        mw.a(H, a18, a17, er.f148275d);
                        mw.a(H, a18, a17, er.f148273b);
                        mw.a(H, a18, a17, er.f148274c);
                        mw.a(H, a18, a17, er.f148276e);
                        mw.a(H, a18, a17, er.f148277f);
                        mw.a(H, a18, a17, er.f148278g);
                        mw.a(H, a18, a17, er.f148279h);
                    }
                    VectorMap vectorMap = (VectorMap) this.e_;
                    if (vectorMap != null) {
                        vectorMap.u();
                    }
                }
                this.f151045bf = true;
            } else if (a16) {
                this.f151044be = i3 + 1;
            }
        }
        if (!this.f151127ay && J()) {
            if (W != null) {
                kp.a(new Runnable() { // from class: com.tencent.mapsdk.internal.tr.6
                    @Override // java.lang.Runnable
                    public final void run() {
                        W.onMapFrameFinished();
                    }
                });
            }
            this.f151127ay = true;
        }
        if (!this.f151125aw && as()) {
            z16 = true;
        }
        if (z16) {
            n(true);
        }
        if (this.G != null && (as() || SystemClock.elapsedRealtime() > this.H)) {
            Handler handler = this.G;
            sj sjVar = this.f151056m;
            if (sjVar != null && (list2 = sjVar.f150272r) != null) {
                Iterator<sj.c> it = list2.iterator();
                while (it.hasNext()) {
                    it.next().a(sjVar);
                }
            }
            b(handler, gl10);
            sj sjVar2 = this.f151056m;
            if (sjVar2 != null && (list = sjVar2.f150272r) != null) {
                Iterator<sj.c> it5 = list.iterator();
                while (it5.hasNext()) {
                    it5.next().c();
                }
            }
            this.G = null;
        }
        return a16;
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final void b(boolean z16) {
        this.U = z16;
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final void b(TencentMapGestureListener tencentMapGestureListener) {
        TencentMapGestureListenerList tencentMapGestureListenerList = this.f151123au;
        if (tencentMapGestureListenerList == null) {
            return;
        }
        tencentMapGestureListenerList.removeListener(tencentMapGestureListener);
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final void b(float f16) {
        TencentMap.OnScaleViewChangedListener onScaleViewChangedListener = this.D;
        if (onScaleViewChangedListener != null) {
            onScaleViewChangedListener.onScaleViewChanged(f16);
        }
        this.f151058o.f147697j.onScaleViewChanged(f16);
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final void b(int i3, int i16) {
        if (i3 == 0 || i16 == 0) {
            return;
        }
        if (this.aU == null) {
            GeoPoint r16 = ((VectorMap) this.e_).r();
            this.aU = new GeoPoint(r16.getLatitudeE6(), r16.getLongitudeE6());
        }
        this.aU.setLatitudeE6(i3);
        this.aU.setLongitudeE6(i16);
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final void b(fj fjVar) {
        this.f151060q.remove(fjVar);
    }

    private void b(TencentMap.OnCameraChangeListener onCameraChangeListener) {
        this.E = onCameraChangeListener;
    }

    private void b(TencentMapOptions tencentMapOptions) {
        String str;
        H().getApplicationContext();
        tu tuVar = new tu(this, ac().f147927c);
        tuVar.b();
        if (!this.f151046bj && !this.f151047bk) {
            qe.a(H(), ac().f147927c);
            LogUtil.a(this.f147934f).b(lb.a.f149158e, "syncCopyConfig");
        } else if (this.f151047bk) {
            Context H = H();
            String str2 = ac().f147927c;
            if (H != null) {
                String a16 = mz.a(H, (TencentMapOptions) null).a(str2);
                my a17 = my.a(H);
                qe.a(a17);
                int b16 = ho.b(ho.n(), a17.a("sdkVersion"));
                mv a18 = mx.a(H, str2);
                mw.b(a18, a16);
                mw.a(H, a18, a16, er.f148272a);
                if (b16 > 0) {
                    a17.a("sdkVersion", ho.n());
                }
            }
            LogUtil.a(this.f147934f).b(lb.a.f149158e, "halfSyncCopyConfig");
        }
        a(tuVar, rs.c());
        dr drVar = (dr) cr.a(dr.class);
        VectorMap vectorMap = (VectorMap) this.e_;
        StringBuilder sb5 = new StringBuilder();
        String j3 = drVar.j();
        if (TextUtils.isEmpty(j3)) {
            str = null;
        } else {
            String k3 = drVar.k();
            if (!TextUtils.isEmpty(k3)) {
                sb5.append(k3);
                sb5.append(QzoneWebViewOfflinePlugin.STR_DEVIDER);
            }
            sb5.append(j3);
            str = sb5.toString();
        }
        vectorMap.f151351o.a(str);
        dx dxVar = (dx) cr.a(dx.class);
        String satelliteVersion = tencentMapOptions != null ? tencentMapOptions.getSatelliteVersion() : null;
        if (TextUtils.isEmpty(satelliteVersion)) {
            satelliteVersion = "0";
        }
        String satelliteUrl = ((di) dxVar.i()).satelliteUrl("%d", "%d", "%d", satelliteVersion);
        if (!dxVar.f148119c || TextUtils.isEmpty(satelliteUrl)) {
            return;
        }
        LogUtil.c(ky.f149101g, "satelliteUrl = ".concat(String.valueOf(satelliteUrl)));
        ((VectorMap) this.e_).f151351o.b(satelliteUrl);
    }

    private void a(Handler handler, GL10 gl10) {
        List<sj.c> list;
        List<sj.c> list2;
        sj sjVar = this.f151056m;
        if (sjVar != null && (list2 = sjVar.f150272r) != null) {
            Iterator<sj.c> it = list2.iterator();
            while (it.hasNext()) {
                it.next().a(sjVar);
            }
        }
        b(handler, gl10);
        sj sjVar2 = this.f151056m;
        if (sjVar2 == null || (list = sjVar2.f150272r) == null) {
            return;
        }
        Iterator<sj.c> it5 = list.iterator();
        while (it5.hasNext()) {
            it5.next().c();
        }
    }

    private Bitmap a(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap == null || bitmap.isRecycled() || bitmap2 == null || bitmap2.isRecycled()) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, new Matrix(), null);
        canvas.drawBitmap(bitmap2, this.f151056m.a().left, this.f151056m.a().top, (Paint) null);
        return createBitmap;
    }

    private boolean a(ge[] geVarArr) {
        ge[] ag5;
        if (this.f151042bc < 25) {
            ag5 = at();
            this.f151042bc++;
        } else {
            ag5 = ag();
        }
        if (geVarArr == null) {
            return true;
        }
        return sm.a(ag5, geVarArr);
    }

    private static boolean a(LatLng latLng, Rect rect) {
        if (latLng != null && rect != null) {
            GeoPoint from = GeoPoint.from(latLng);
            if (from.getLongitudeE6() >= rect.left && from.getLongitudeE6() <= rect.right && from.getLatitudeE6() >= rect.top && from.getLatitudeE6() <= rect.bottom) {
                return true;
            }
        }
        return false;
    }

    private void a(pp ppVar) {
        pt ptVar = this.f151036ap;
        if (ptVar != null) {
            ptVar.a(ppVar);
        }
    }

    private void b(Handler handler, GL10 gl10) {
        Bitmap bitmap;
        if (gl10 == null || handler == null) {
            return;
        }
        int i3 = this.f151030aj;
        int i16 = this.f151031ak;
        int i17 = i3 * i16;
        int[] iArr = new int[i17];
        int[] iArr2 = new int[i17];
        IntBuffer wrap = IntBuffer.wrap(iArr);
        wrap.position(0);
        gl10.glReadPixels(0, 0, i3, i16, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, wrap);
        for (int i18 = 0; i18 < i16; i18++) {
            for (int i19 = 0; i19 < i3; i19++) {
                int i26 = iArr[(i18 * i3) + i19];
                iArr2[(((i16 - i18) - 1) * i3) + i19] = (i26 & (-16711936)) | ((i26 << 16) & ITVKAsset.VOD_ASSET_MASK_BIT) | ((i26 >> 16) & 255);
            }
        }
        try {
            bitmap = Bitmap.createBitmap(iArr2, i3, i16, this.I);
        } catch (OutOfMemoryError unused) {
            bitmap = null;
        }
        bw bwVar = this.aF;
        if (bwVar != null && !(bwVar instanceof ub) && this.f151056m.k()) {
            bitmap = a(bitmap, this.f151056m.j());
        }
        handler.sendMessage(handler.obtainMessage(0, bitmap));
    }

    public final boolean a(MotionEvent motionEvent) {
        pt ptVar = this.f151036ap;
        if (ptVar != null) {
            return ptVar.dispatchHoverEvent(motionEvent);
        }
        return false;
    }

    private void a(TencentMap.OnTrafficEventClickListener onTrafficEventClickListener) {
        this.f151037aq = onTrafficEventClickListener;
    }

    private void a(be beVar) {
        this.f151039as.remove(beVar);
        this.f151039as.add(beVar);
    }

    public final void a(final boolean z16, final List<ss> list) {
        kp.b(new Runnable() { // from class: com.tencent.mapsdk.internal.tr.9
            @Override // java.lang.Runnable
            public final void run() {
                Iterator it = tr.this.f151039as.iterator();
                while (it.hasNext()) {
                    ((be) it.next()).a(z16, list);
                }
            }
        });
    }

    private boolean a(az azVar, float f16, float f17) {
        TencentMap.OnPolylineClickListener onPolylineClickListener;
        if (!azVar.isClickable() || (onPolylineClickListener = this.aH) == null) {
            return false;
        }
        onPolylineClickListener.onPolylineClick(azVar, ((ne) this.d_).f149403p.fromScreenLocation(new Point((int) f16, (int) f17)));
        return true;
    }

    private boolean a(ay ayVar, float f16, float f17) {
        TencentMap.OnPolygonClickListener onPolygonClickListener;
        if (!ayVar.isClickable() || (onPolygonClickListener = this.aI) == null) {
            return false;
        }
        onPolygonClickListener.onPolygonClick(ayVar, ((ne) this.d_).f149403p.fromScreenLocation(new Point((int) f16, (int) f17)));
        return true;
    }

    private void b(be beVar) {
        this.f151039as.remove(beVar);
    }

    private void b(GL10 gl10) {
        bj bjVar;
        C c16 = this.d_;
        if (c16 == 0 || (bjVar = ((ne) c16).M) == null) {
            return;
        }
        synchronized (this.f151050g) {
            fb[] fbVarArr = {null};
            Util.foreach(bjVar.d(), new AnonymousClass1(fbVarArr, gl10));
            fb fbVar = fbVarArr[0];
            if (fbVar != null) {
                fbVar.a(gl10);
            }
        }
    }

    private static boolean a(fb fbVar, float f16, float f17) {
        if (fbVar != null && fbVar.isVisible() && fbVar.handleOnTap()) {
            return fbVar.onTap(f16, f17);
        }
        return false;
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final CameraPosition a() {
        VectorMap vectorMap = (VectorMap) this.e_;
        GeoPoint r16 = vectorMap.r();
        if (r16 == null) {
            return null;
        }
        List<TencentMap.OnCameraChangeListener> list = this.f151063t;
        if ((list == null || list.size() <= 0) && this.f151032al == null) {
            return null;
        }
        LatLng a16 = ks.a(r16);
        float v3 = vectorMap.v();
        if (v3 < 0.0f) {
            v3 = (v3 % 360.0f) + 360.0f;
        }
        return CameraPosition.builder().zoom(vectorMap.f151351o.f149410w.a()).target(a16).bearing(v3).tilt(vectorMap.w()).build();
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final void b(qa.b bVar) {
        M m3 = this.e_;
        if (m3 == 0) {
            this.f151048bl.remove(bVar);
            return;
        }
        VectorMap vectorMap = (VectorMap) m3;
        qa qaVar = vectorMap.f151354r;
        if (qaVar != null) {
            qaVar.b(bVar);
        } else {
            vectorMap.f151357u.remove(bVar);
        }
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final void a(TencentMapOptions tencentMapOptions) {
        String str;
        H().getApplicationContext();
        tu tuVar = new tu(this, ac().f147927c);
        tuVar.b();
        if (!this.f151046bj && !this.f151047bk) {
            qe.a(H(), ac().f147927c);
            LogUtil.a(this.f147934f).b(lb.a.f149158e, "syncCopyConfig");
        } else if (this.f151047bk) {
            Context H = H();
            String str2 = ac().f147927c;
            if (H != null) {
                String a16 = mz.a(H, (TencentMapOptions) null).a(str2);
                my a17 = my.a(H);
                qe.a(a17);
                int b16 = ho.b(ho.n(), a17.a("sdkVersion"));
                mv a18 = mx.a(H, str2);
                mw.b(a18, a16);
                mw.a(H, a18, a16, er.f148272a);
                if (b16 > 0) {
                    a17.a("sdkVersion", ho.n());
                }
            }
            LogUtil.a(this.f147934f).b(lb.a.f149158e, "halfSyncCopyConfig");
        }
        a(tuVar, rs.c());
        dr drVar = (dr) cr.a(dr.class);
        VectorMap vectorMap = (VectorMap) this.e_;
        StringBuilder sb5 = new StringBuilder();
        String j3 = drVar.j();
        if (TextUtils.isEmpty(j3)) {
            str = null;
        } else {
            String k3 = drVar.k();
            if (!TextUtils.isEmpty(k3)) {
                sb5.append(k3);
                sb5.append(QzoneWebViewOfflinePlugin.STR_DEVIDER);
            }
            sb5.append(j3);
            str = sb5.toString();
        }
        vectorMap.f151351o.a(str);
        dx dxVar = (dx) cr.a(dx.class);
        String satelliteVersion = tencentMapOptions != null ? tencentMapOptions.getSatelliteVersion() : null;
        if (TextUtils.isEmpty(satelliteVersion)) {
            satelliteVersion = "0";
        }
        String satelliteUrl = ((di) dxVar.i()).satelliteUrl("%d", "%d", "%d", satelliteVersion);
        if (dxVar.f148119c && !TextUtils.isEmpty(satelliteUrl)) {
            LogUtil.c(ky.f149101g, "satelliteUrl = ".concat(String.valueOf(satelliteUrl)));
            ((VectorMap) this.e_).f151351o.b(satelliteUrl);
        }
        M m3 = this.e_;
        if (!((VectorMap) m3).f151351o.f149407t) {
            ((VectorMap) m3).setMapStyle(0);
        } else {
            ((VectorMap) m3).setMapStyle(5);
        }
    }

    private boolean a(TappedElement tappedElement) {
        sa saVar;
        ne neVar = this.aC;
        if (neVar == null || (saVar = neVar.D) == null) {
            return false;
        }
        TrafficEvent a16 = saVar.a((int) tappedElement.itemId);
        TencentMap.OnTrafficEventClickListener onTrafficEventClickListener = this.f151037aq;
        if (onTrafficEventClickListener == null || a16 == null) {
            return false;
        }
        onTrafficEventClickListener.onTrafficEventClicked(a16);
        return true;
    }

    @Override // com.tencent.mapsdk.internal.tz, com.tencent.mapsdk.internal.ua.m
    public final void a(GL10 gl10, EGLConfig eGLConfig) {
        lc.a(lb.f149153ab, this.f147934f);
        super.a(gl10, eGLConfig);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a(ax axVar, boolean z16) {
        boolean z17 = false;
        if (((VectorMap) this.e_) == null) {
            return false;
        }
        if (axVar == null) {
            b("");
            return true;
        }
        ap apVar = axVar.f147778b;
        String id5 = apVar.getId();
        TencentMap.OnMarkerClickListener onMarkerClickListener = this.aM;
        if (onMarkerClickListener != null && !z16 && onMarkerClickListener.onMarkerClick(axVar)) {
            return true;
        }
        if (!axVar.isInfoWindowEnable()) {
            return false;
        }
        if (!this.f151033am) {
            ap apVar2 = this.f151034an;
            if (apVar2 == null) {
                apVar.showInfoWindow();
                this.f151034an = apVar;
                return true;
            }
            if (apVar2 == apVar) {
                if (apVar.h() != null && apVar.h().c()) {
                    z17 = true;
                }
                if (z17) {
                    apVar.hideInfoWindow();
                    this.f151034an = null;
                } else {
                    apVar.showInfoWindow();
                    this.f151034an = apVar;
                }
                return true;
            }
            apVar2.hideInfoWindow();
            apVar.showInfoWindow();
            this.f151034an = apVar;
            return true;
        }
        if (apVar.i()) {
            if (apVar.h() == null) {
                apVar.showInfoWindow();
            } else if (apVar.isInfoWindowShown()) {
                apVar.hideInfoWindow();
            } else {
                apVar.showInfoWindow();
                this.f151034an = apVar;
            }
        }
        b(id5);
        return true;
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final void a(qa.b bVar) {
        M m3 = this.e_;
        if (m3 == 0) {
            this.f151048bl.put(bVar, Boolean.TRUE);
        } else {
            ((VectorMap) m3).a(bVar);
        }
    }
}
