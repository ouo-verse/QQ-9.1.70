package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.mapsdk.internal.aa;
import com.tencent.mapsdk.internal.lb;
import com.tencent.mapsdk.internal.ne;
import com.tencent.mapsdk.internal.tk;
import com.tencent.mapsdk.vector.VectorMap;
import com.tencent.tencentmap.mapsdk.maps.CustomRender;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.maps.model.GeometryConstants;
import com.tencent.tencentmap.mapsdk.maps.model.MapViewType;
import com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListenerList;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class tz extends bq<ne, VectorMap> implements bb, pb {

    /* renamed from: j, reason: collision with root package name */
    private static final int f151120j = 10;

    /* renamed from: k, reason: collision with root package name */
    private static final int f151121k = 16;
    public volatile boolean aA;
    public int aB;
    public ne aC;
    public float aD;
    public int aE;
    protected bw aF;
    public volatile boolean aG;
    protected TencentMap.OnPolylineClickListener aH;
    protected TencentMap.OnPolygonClickListener aI;
    public WeakReference<TencentMap.InfoWindowAdapter> aJ;
    protected TencentMap.OnMarkerCollisionStatusListener aK;
    protected TencentMap.OnMarkerDragListener aL;
    protected TencentMap.OnMarkerClickListener aM;
    protected TencentMap.OnInfoWindowClickListener aN;
    protected TencentMap.OnMapFrameFinishCallback aO;

    /* renamed from: at, reason: collision with root package name */
    public List<TencentMap.OnMapLoadedCallback> f151122at;

    /* renamed from: au, reason: collision with root package name */
    public TencentMapGestureListenerList f151123au;

    /* renamed from: av, reason: collision with root package name */
    public boolean f151124av;

    /* renamed from: aw, reason: collision with root package name */
    protected volatile boolean f151125aw;

    /* renamed from: ax, reason: collision with root package name */
    protected volatile boolean f151126ax;

    /* renamed from: ay, reason: collision with root package name */
    protected volatile boolean f151127ay;

    /* renamed from: az, reason: collision with root package name */
    public volatile boolean f151128az;

    /* renamed from: g, reason: collision with root package name */
    private qk f151129g;

    /* renamed from: h, reason: collision with root package name */
    private nf f151130h;

    /* renamed from: i, reason: collision with root package name */
    private volatile boolean f151131i;

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tz$1, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f151132a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f151133b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ float f151134c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ float f151135d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f151136e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ float f151137f;

        public AnonymousClass1(float f16, float f17, float f18, float f19, boolean z16, float f26) {
            this.f151132a = f16;
            this.f151133b = f17;
            this.f151134c = f18;
            this.f151135d = f19;
            this.f151136e = z16;
            this.f151137f = f26;
        }

        @Override // java.lang.Runnable
        public final void run() {
            tz.this.aD += this.f151132a;
            tz tzVar = tz.this;
            tz.a(tzVar, this.f151133b, tzVar.aD);
            if (tz.b(tz.this) < 10) {
                kp.a(this, 16L);
                return;
            }
            tz.a(tz.this, this.f151133b, this.f151134c);
            float f16 = this.f151135d;
            if (f16 >= 3.0f && f16 <= 20.0f) {
                if (this.f151136e) {
                    tz.this.aC.f149398k.a((int) this.f151135d, new Runnable() { // from class: com.tencent.mapsdk.internal.tz.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            tz.this.aC.f149398k.a(AnonymousClass1.this.f151137f);
                        }
                    });
                } else {
                    tz.this.aC.f149398k.a(this.f151137f);
                }
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.tz$3, reason: invalid class name */
    /* loaded from: classes9.dex */
    static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f151141a;

        static {
            int[] iArr = new int[MapViewType.values().length];
            f151141a = iArr;
            try {
                iArr[MapViewType.TextureView.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f151141a[MapViewType.RenderLayer.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f151141a[MapViewType.SurfaceView.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class a implements oo {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<ne> f151142a;

        public a(ne neVar) {
            this.f151142a = new WeakReference<>(neVar);
        }

        @Override // com.tencent.mapsdk.internal.oo
        public final boolean a(int i3) {
            CustomRender customRender;
            ne neVar = this.f151142a.get();
            if (neVar == null || i3 != ne.b.AboveToplayer.f149422g || (customRender = neVar.I) == null) {
                return false;
            }
            customRender.onDrawFrame();
            return true;
        }
    }

    public tz(Context context, TencentMapOptions tencentMapOptions, ViewGroup viewGroup) {
        super(context, tencentMapOptions, viewGroup);
        this.f151122at = new CopyOnWriteArrayList();
        this.f151123au = null;
        this.f151124av = true;
        this.f151125aw = false;
        this.f151126ax = false;
        this.f151127ay = false;
        this.f151128az = false;
        this.aA = false;
        this.aB = 0;
        this.aD = 0.5f;
        this.aE = 0;
        this.aF = null;
    }

    private void ac() {
        bw bwVar = this.aF;
        if (bwVar != null) {
            bwVar.d();
        }
    }

    private void ae() {
        if (this.f151130h != null) {
            while (!this.f151130h.f149448b) {
                try {
                    this.f151130h.c();
                    this.f151130h.b();
                } catch (InterruptedException e16) {
                    LogUtil.b(Log.getStackTraceString(e16));
                }
                if (!this.f151130h.isAlive()) {
                    break;
                } else {
                    this.f151130h.join();
                }
            }
        }
        this.f151130h = null;
        this.f151131i = false;
    }

    private void af() {
        long currentTimeMillis = System.currentTimeMillis();
        hi hiVar = ((ne) this.d_).f147918e;
        if (hiVar != null) {
            hiVar.a().a(true, currentTimeMillis);
        }
        this.aG = false;
    }

    private void ag() {
        this.aG = true;
    }

    private void ah() {
        this.f151128az = true;
        TencentMapGestureListenerList tencentMapGestureListenerList = this.f151123au;
        if (tencentMapGestureListenerList != null && this.f151124av) {
            tencentMapGestureListenerList.onMapStable();
        }
    }

    static /* synthetic */ int b(tz tzVar) {
        int i3 = tzVar.aE;
        tzVar.aE = i3 + 1;
        return i3;
    }

    private void n(boolean z16) {
        bw bwVar = this.aF;
        if (bwVar != null) {
            bwVar.setZOrderMediaOverlay(z16);
        }
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final ol D() {
        ne neVar = this.aC;
        if (neVar == null) {
            return null;
        }
        return neVar.f149411x;
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final void E() {
        if (this.f151130h == null && this.aC != null) {
            this.f151130h = new nf(this.aC);
        }
        if (!this.f151131i) {
            try {
                this.f151130h.start();
                this.f151131i = true;
            } catch (Exception e16) {
                LogUtil.b("startTextureCreatorIfNeed failed", e16);
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final void F() {
        ae();
        if (this.aC != null) {
            getEGLContextHash();
            this.aC.J();
        }
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final void G() {
        bw bwVar = this.aF;
        if (bwVar != null) {
            bwVar.d();
        }
        ne neVar = this.aC;
        if (neVar != null) {
            neVar.f149412y = true;
        }
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final Context H() {
        return this.f147932d;
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final void I() {
        ne neVar = this.aC;
        if (neVar != null) {
            neVar.f149412y = true;
        }
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final boolean J() {
        ne neVar = this.aC;
        if (neVar != null && neVar.M()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final boolean K() {
        ne neVar = this.aC;
        if (neVar == null) {
            return false;
        }
        return neVar.O();
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final TencentMapOptions L() {
        return this.f147933e;
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final boolean N() {
        return this.f151125aw;
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final TencentMap.OnPolylineClickListener O() {
        return this.aH;
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final TencentMap.OnPolygonClickListener P() {
        return this.aI;
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final TencentMap.InfoWindowAdapter Q() {
        WeakReference<TencentMap.InfoWindowAdapter> weakReference = this.aJ;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final TencentMap.OnMarkerCollisionStatusListener R() {
        return this.aK;
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final TencentMap.OnMarkerDragListener S() {
        return this.aL;
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final TencentMap.OnMarkerClickListener T() {
        return this.aM;
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final TencentMap.OnInfoWindowClickListener U() {
        return this.aN;
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final TencentMap.OnMapFrameFinishCallback W() {
        return this.aO;
    }

    @Override // com.tencent.mapsdk.internal.bq
    public void Y() {
        super.Y();
        a(this.f147933e);
    }

    public final int ai() {
        bw bwVar = this.aF;
        if (bwVar != null) {
            return bwVar.getWidth();
        }
        return Integer.MAX_VALUE;
    }

    public final int aj() {
        bw bwVar = this.aF;
        if (bwVar != null) {
            return bwVar.getHeight();
        }
        return Integer.MAX_VALUE;
    }

    public final boolean ak() {
        Context context = this.f147932d;
        if (context == null) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        boolean isEnabled = accessibilityManager.isEnabled();
        boolean isTouchExplorationEnabled = accessibilityManager.isTouchExplorationEnabled();
        if (!isEnabled || !isTouchExplorationEnabled) {
            return false;
        }
        return true;
    }

    public final void al() {
        if (!this.f151125aw) {
            kp.a(new Runnable() { // from class: com.tencent.mapsdk.internal.tz.2
                @Override // java.lang.Runnable
                public final void run() {
                    for (TencentMap.OnMapLoadedCallback onMapLoadedCallback : tz.this.f151122at) {
                        if (onMapLoadedCallback != null) {
                            onMapLoadedCallback.onMapLoaded();
                        }
                    }
                }
            });
        }
        this.f151125aw = true;
    }

    @Override // com.tencent.mapsdk.internal.bb, com.tencent.mapsdk.internal.oy
    public int getEGLContextHash() {
        EGLContext eglGetCurrentContext;
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        if (egl10 != null && (eglGetCurrentContext = egl10.eglGetCurrentContext()) != null) {
            return eglGetCurrentContext.hashCode();
        }
        return 0;
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final void l(boolean z16) {
        this.aC.f149396i.i(z16);
    }

    @Override // com.tencent.mapsdk.internal.bq, com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void onCreated() {
        super.onCreated();
        this.aF = getMapRenderView();
        this.f151129g = new qk(this);
        this.aG = true;
        ne neVar = ((VectorMap) this.e_).f151351o;
        if (neVar != null) {
            neVar.J = this;
        }
    }

    @Override // com.tencent.mapsdk.internal.bq, com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.tencent.mapsdk.internal.bq, com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void onPause() {
        rw rwVar;
        super.onPause();
        nf nfVar = this.f151130h;
        if (nfVar != null) {
            nfVar.c();
        }
        ne neVar = this.aC;
        if (neVar.f149396i != null) {
            neVar.f149412y = false;
            neVar.E = false;
            neVar.h(false);
            sa saVar = neVar.D;
            if (saVar != null) {
                saVar.f150176g = true;
            }
            aa aaVar = neVar.f149398k.f147732o;
            if (aaVar != null) {
                aaVar.a();
            }
            neVar.f149396i.m();
            if (neVar.f149407t && (rwVar = neVar.f149399l) != null) {
                rwVar.f150154b.a();
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.bq, com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void onResume() {
        rw rwVar;
        super.onResume();
        nf nfVar = this.f151130h;
        if (nfVar != null) {
            LogUtil.a(nfVar.a()).c(lb.a.f149160g, "tms-texture thread resume");
            nfVar.f149447a = false;
            synchronized (nfVar) {
                nfVar.notifyAll();
            }
        }
        ne neVar = this.aC;
        if (neVar.f149396i != null) {
            neVar.f149412y = true;
            neVar.E = true;
            tk tkVar = neVar.f149396i;
            if (tkVar != null && tkVar.f150515e != 0) {
                tkVar.b(new tk.AnonymousClass34());
            }
            neVar.h(neVar.E);
            if (neVar.f149413z) {
                aa aaVar = neVar.f149398k.f147732o;
                aa.a aVar = aaVar.f147671d;
                if (aVar != null) {
                    aVar.destroy();
                }
                aa.a aVar2 = new aa.a(aaVar);
                aaVar.f147671d = aVar2;
                aVar2.start();
                neVar.f149413z = false;
            } else {
                aa aaVar2 = neVar.f149398k.f147732o;
                if (aaVar2 != null) {
                    aaVar2.b();
                }
            }
            bb bbVar = neVar.f149402o;
            if (bbVar != null) {
                bbVar.getMapRenderView().d();
            }
            if (neVar.f149406s) {
                neVar.f149396i.l();
            }
            if (neVar.f149407t && (rwVar = neVar.f149399l) != null) {
                rwVar.a();
            }
            sa saVar = neVar.D;
            if (saVar != null) {
                saVar.f150176g = false;
                saVar.f150178i.sendEmptyMessage(130818);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        qk qkVar = this.f151129g;
        if (qkVar != null) {
            return qkVar.onTouch(null, motionEvent);
        }
        return false;
    }

    @Override // com.tencent.mapsdk.internal.pb
    public final void p_() {
        if (this.aG) {
            long currentTimeMillis = System.currentTimeMillis();
            hi hiVar = ((ne) this.d_).f147918e;
            if (hiVar != null) {
                hiVar.a().a(true, currentTimeMillis);
            }
            this.aG = false;
        }
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final nd c() {
        return this.aC.f149401n;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mapsdk.internal.bq
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public VectorMap createMap(ne neVar) {
        return new VectorMap(neVar);
    }

    @Override // com.tencent.mapsdk.internal.bq
    /* renamed from: b */
    public final /* synthetic */ bw createMapView(ne neVar, ViewGroup viewGroup) {
        bw ucVar;
        ne neVar2 = neVar;
        int i3 = AnonymousClass3.f151141a[aa().ordinal()];
        if (i3 == 1) {
            ucVar = new uc(neVar2);
        } else if (i3 != 2) {
            ucVar = new ud(neVar2);
        } else {
            ucVar = new ub(neVar2);
        }
        if (viewGroup != null) {
            viewGroup.addView(ucVar.getView());
        }
        return ucVar;
    }

    private bw a(ne neVar, ViewGroup viewGroup) {
        bw ucVar;
        int i3 = AnonymousClass3.f151141a[aa().ordinal()];
        if (i3 == 1) {
            ucVar = new uc(neVar);
        } else if (i3 != 2) {
            ucVar = new ud(neVar);
        } else {
            ucVar = new ub(neVar);
        }
        if (viewGroup != null) {
            viewGroup.addView(ucVar.getView());
        }
        return ucVar;
    }

    public static float c(float f16) {
        int i3 = (int) f16;
        return (1 << (i3 - 3)) * 3.0517578E-5f * ((float) Math.pow(2.0d, f16 - i3));
    }

    private ne b(Context context, TencentMapOptions tencentMapOptions) {
        ne neVar = new ne(context, tencentMapOptions, this);
        this.aC = neVar;
        return neVar;
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final void a(fd fdVar) {
        this.f151129g.a(fdVar);
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final void a(oq oqVar) {
        this.aC.a(oqVar);
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final void b(fd fdVar) {
        qk qkVar = this.f151129g;
        synchronized (qkVar.f149866a) {
            qkVar.f149866a.b(fdVar);
        }
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final void a(ol olVar, lu luVar) {
        if (this.aC.a(this.f147932d.getApplicationContext(), olVar, luVar, new a(this.aC))) {
            ae aeVar = this.aC.f149398k;
            GeoPoint geoPoint = new GeoPoint(ae.f147728n, ae.f147727m);
            v vVar = aeVar.A;
            Rect h16 = aeVar.f147743z.h();
            int latitudeE6 = geoPoint.getLatitudeE6();
            int longitudeE6 = geoPoint.getLongitudeE6();
            vVar.f151265n = h16;
            vVar.f151254c = GeometryConstants.BOUNDARY_WORLD;
            vVar.c(13);
            vVar.a(0);
            vVar.a(latitudeE6, longitudeE6, false);
            aeVar.f147743z.g().b(aeVar.G);
        }
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final ne b() {
        return this.aC;
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final void a(float f16, float f17, float f18) {
        ne neVar = this.aC;
        if (neVar != null) {
            float f19 = neVar.f149398k.A.f151253b.f151290p;
            float c16 = c(f18);
            boolean z16 = ((double) Math.abs(f19 - c16)) > 1.0E-4d;
            this.aE = 0;
            kp.a(new AnonymousClass1((f17 - this.aD) / 10.0f, f16, f17, f18, z16, c16));
        }
    }

    public void ad() {
    }

    public void a(GL10 gl10, EGLConfig eGLConfig) {
        mp mpVar;
        ne neVar = this.aC;
        if (neVar.f149396i == null || (mpVar = neVar.f149397j) == null) {
            return;
        }
        mpVar.a();
    }

    public void a(GL10 gl10, int i3, int i16) {
        ne neVar = this.aC;
        if (neVar.f149396i != null) {
            neVar.f149412y = true;
            neVar.f149405r.set(0, 0, i3, i16);
            neVar.a(0, 0, i3, i16, false);
            neVar.f149398k.n();
        }
    }

    public boolean a(GL10 gl10) {
        return this.aC.a(gl10);
    }

    private void a(float f16, float f17, boolean z16) {
        this.aC.f149398k.b(f16, f17, z16);
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final void a(TencentMap.OnPolylineClickListener onPolylineClickListener) {
        this.aH = onPolylineClickListener;
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final void a(TencentMap.OnPolygonClickListener onPolygonClickListener) {
        this.aI = onPolygonClickListener;
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final void a(TencentMap.InfoWindowAdapter infoWindowAdapter) {
        this.aJ = new WeakReference<>(infoWindowAdapter);
    }

    private void a(TencentMap.OnVectorOverlayClickListener onVectorOverlayClickListener) {
        this.aC.O = onVectorOverlayClickListener;
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final void a(TencentMap.OnMarkerCollisionStatusListener onMarkerCollisionStatusListener) {
        this.aK = onMarkerCollisionStatusListener;
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final void a(TencentMap.OnMarkerDragListener onMarkerDragListener) {
        this.aL = onMarkerDragListener;
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final void a(TencentMap.OnMarkerClickListener onMarkerClickListener) {
        this.aM = onMarkerClickListener;
    }

    @Override // com.tencent.mapsdk.internal.bb
    public final void a(TencentMap.OnInfoWindowClickListener onInfoWindowClickListener) {
        this.aN = onInfoWindowClickListener;
    }

    public final void a(TencentMap.OnMapFrameFinishCallback onMapFrameFinishCallback) {
        this.aO = onMapFrameFinishCallback;
    }

    @Override // com.tencent.mapsdk.internal.bq
    public final /* synthetic */ ne a(Context context, TencentMapOptions tencentMapOptions) {
        ne neVar = new ne(context, tencentMapOptions, this);
        this.aC = neVar;
        return neVar;
    }

    static /* synthetic */ void a(tz tzVar, float f16, float f17) {
        tzVar.aC.f149398k.b(f16, f17, true);
    }
}
