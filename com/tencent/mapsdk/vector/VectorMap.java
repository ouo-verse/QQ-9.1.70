package com.tencent.mapsdk.vector;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Keep;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.map.lib.callbacks.TileOverlayCallback;
import com.tencent.map.lib.models.AnnocationText;
import com.tencent.map.lib.models.AnnocationTextResult;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.map.lib.models.IndoorCellInfo;
import com.tencent.map.lib.models.MaskLayer;
import com.tencent.map.lib.models.PolygonInfo;
import com.tencent.map.sdk.comps.vis.VisualLayer;
import com.tencent.map.sdk.comps.vis.VisualLayerOptions;
import com.tencent.map.sdk.utilities.visualization.aggregation.AggregationOverlayProvider;
import com.tencent.map.sdk.utilities.visualization.glmodel.GLModelOverlayProvider;
import com.tencent.map.sdk.utilities.visualization.heatmap.GradientVectorOverlayProvider;
import com.tencent.map.sdk.utilities.visualization.od.ArcLineOverlayProvider;
import com.tencent.map.sdk.utilities.visualization.scatterplot.BitmapScatterPlotOverlayProvider;
import com.tencent.map.sdk.utilities.visualization.scatterplot.DotScatterPlotOverlayProvider;
import com.tencent.map.sdk.utilities.visualization.trails.TrailOverlayProvider;
import com.tencent.map.tools.CallbackRunnable;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.mapsdk.engine.jni.models.TappedElement;
import com.tencent.mapsdk.internal.aa;
import com.tencent.mapsdk.internal.ab;
import com.tencent.mapsdk.internal.ad;
import com.tencent.mapsdk.internal.ae;
import com.tencent.mapsdk.internal.af;
import com.tencent.mapsdk.internal.ag;
import com.tencent.mapsdk.internal.aj;
import com.tencent.mapsdk.internal.ak;
import com.tencent.mapsdk.internal.ap;
import com.tencent.mapsdk.internal.at;
import com.tencent.mapsdk.internal.ax;
import com.tencent.mapsdk.internal.ay;
import com.tencent.mapsdk.internal.bb;
import com.tencent.mapsdk.internal.bc;
import com.tencent.mapsdk.internal.bf;
import com.tencent.mapsdk.internal.bh;
import com.tencent.mapsdk.internal.bi;
import com.tencent.mapsdk.internal.bj;
import com.tencent.mapsdk.internal.bk;
import com.tencent.mapsdk.internal.bl;
import com.tencent.mapsdk.internal.bm;
import com.tencent.mapsdk.internal.bn;
import com.tencent.mapsdk.internal.bw;
import com.tencent.mapsdk.internal.eg;
import com.tencent.mapsdk.internal.es;
import com.tencent.mapsdk.internal.ex;
import com.tencent.mapsdk.internal.fa;
import com.tencent.mapsdk.internal.fb;
import com.tencent.mapsdk.internal.fc;
import com.tencent.mapsdk.internal.fd;
import com.tencent.mapsdk.internal.fg;
import com.tencent.mapsdk.internal.fi;
import com.tencent.mapsdk.internal.fk;
import com.tencent.mapsdk.internal.fl;
import com.tencent.mapsdk.internal.fm;
import com.tencent.mapsdk.internal.fn;
import com.tencent.mapsdk.internal.fo;
import com.tencent.mapsdk.internal.fq;
import com.tencent.mapsdk.internal.fr;
import com.tencent.mapsdk.internal.fs;
import com.tencent.mapsdk.internal.ft;
import com.tencent.mapsdk.internal.fw;
import com.tencent.mapsdk.internal.hi;
import com.tencent.mapsdk.internal.hn;
import com.tencent.mapsdk.internal.hs;
import com.tencent.mapsdk.internal.ht;
import com.tencent.mapsdk.internal.il;
import com.tencent.mapsdk.internal.iu;
import com.tencent.mapsdk.internal.iw;
import com.tencent.mapsdk.internal.ix;
import com.tencent.mapsdk.internal.jh;
import com.tencent.mapsdk.internal.jl;
import com.tencent.mapsdk.internal.jn;
import com.tencent.mapsdk.internal.kp;
import com.tencent.mapsdk.internal.kt;
import com.tencent.mapsdk.internal.ky;
import com.tencent.mapsdk.internal.lb;
import com.tencent.mapsdk.internal.lc;
import com.tencent.mapsdk.internal.mo;
import com.tencent.mapsdk.internal.mz;
import com.tencent.mapsdk.internal.nd;
import com.tencent.mapsdk.internal.ne;
import com.tencent.mapsdk.internal.nk;
import com.tencent.mapsdk.internal.nl;
import com.tencent.mapsdk.internal.nn;
import com.tencent.mapsdk.internal.np;
import com.tencent.mapsdk.internal.nr;
import com.tencent.mapsdk.internal.ns;
import com.tencent.mapsdk.internal.nv;
import com.tencent.mapsdk.internal.nw;
import com.tencent.mapsdk.internal.ny;
import com.tencent.mapsdk.internal.oc;
import com.tencent.mapsdk.internal.of;
import com.tencent.mapsdk.internal.oh;
import com.tencent.mapsdk.internal.oi;
import com.tencent.mapsdk.internal.ok;
import com.tencent.mapsdk.internal.oq;
import com.tencent.mapsdk.internal.ox;
import com.tencent.mapsdk.internal.oz;
import com.tencent.mapsdk.internal.pb;
import com.tencent.mapsdk.internal.ph;
import com.tencent.mapsdk.internal.pl;
import com.tencent.mapsdk.internal.pq;
import com.tencent.mapsdk.internal.pw;
import com.tencent.mapsdk.internal.px;
import com.tencent.mapsdk.internal.py;
import com.tencent.mapsdk.internal.qa;
import com.tencent.mapsdk.internal.qj;
import com.tencent.mapsdk.internal.qm;
import com.tencent.mapsdk.internal.qr;
import com.tencent.mapsdk.internal.rt;
import com.tencent.mapsdk.internal.rw;
import com.tencent.mapsdk.internal.sj;
import com.tencent.mapsdk.internal.sl;
import com.tencent.mapsdk.internal.sm;
import com.tencent.mapsdk.internal.tf;
import com.tencent.mapsdk.internal.tk;
import com.tencent.mapsdk.internal.tr;
import com.tencent.mapsdk.internal.ty;
import com.tencent.mapsdk.internal.tz;
import com.tencent.mapsdk.internal.v;
import com.tencent.mapsdk.internal.w;
import com.tencent.mapsdk.internal.x;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdate;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.CustomLocationProvider;
import com.tencent.tencentmap.mapsdk.maps.CustomRender;
import com.tencent.tencentmap.mapsdk.maps.LocationSource;
import com.tencent.tencentmap.mapsdk.maps.MapParamConstants;
import com.tencent.tencentmap.mapsdk.maps.Projection;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMapContext;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.maps.UiSettings;
import com.tencent.tencentmap.mapsdk.maps.VisualSettings;
import com.tencent.tencentmap.mapsdk.maps.internal.TencentMapPro;
import com.tencent.tencentmap.mapsdk.maps.model.AoiLayer;
import com.tencent.tencentmap.mapsdk.maps.model.AoiLayerOptions;
import com.tencent.tencentmap.mapsdk.maps.model.Arc;
import com.tencent.tencentmap.mapsdk.maps.model.ArcOptions;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.Circle;
import com.tencent.tencentmap.mapsdk.maps.model.CircleOptions;
import com.tencent.tencentmap.mapsdk.maps.model.CustomLayer;
import com.tencent.tencentmap.mapsdk.maps.model.CustomLayerOptions;
import com.tencent.tencentmap.mapsdk.maps.model.GeometryConstants;
import com.tencent.tencentmap.mapsdk.maps.model.GroundOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.GroundOverlayOptions;
import com.tencent.tencentmap.mapsdk.maps.model.IOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorBuilding;
import com.tencent.tencentmap.mapsdk.maps.model.Language;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import com.tencent.tencentmap.mapsdk.maps.model.MapFontSize;
import com.tencent.tencentmap.mapsdk.maps.model.MapPoi;
import com.tencent.tencentmap.mapsdk.maps.model.MapRouteSection;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import com.tencent.tencentmap.mapsdk.maps.model.MyLocationStyle;
import com.tencent.tencentmap.mapsdk.maps.model.OverSeaTileProvider;
import com.tencent.tencentmap.mapsdk.maps.model.Polygon;
import com.tencent.tencentmap.mapsdk.maps.model.PolygonOptions;
import com.tencent.tencentmap.mapsdk.maps.model.Polyline;
import com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions;
import com.tencent.tencentmap.mapsdk.maps.model.RestrictBoundsFitMode;
import com.tencent.tencentmap.mapsdk.maps.model.SubPoi;
import com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlayOptions;
import com.tencent.tencentmap.mapsdk.maps.model.VectorHeatOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.VectorHeatOverlayOptions;
import com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes9.dex */
public class VectorMap extends bn {
    private static final int A = 2;
    private static final int B = 3;

    /* renamed from: a, reason: collision with root package name */
    public static final int f151332a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static final int f151333b = 1;

    /* renamed from: c, reason: collision with root package name */
    public static final int f151334c = 2;

    /* renamed from: d, reason: collision with root package name */
    public static final int f151335d = 3;

    /* renamed from: e, reason: collision with root package name */
    public static final int f151336e = 4;

    /* renamed from: f, reason: collision with root package name */
    public static final int f151337f = 5;

    /* renamed from: g, reason: collision with root package name */
    public static final int f151338g = 11;

    /* renamed from: h, reason: collision with root package name */
    public static final int f151339h = 15;

    /* renamed from: i, reason: collision with root package name */
    public static final int f151340i = 18;

    /* renamed from: j, reason: collision with root package name */
    public static final float f151341j = MapParamConstants.MAX_SKEW_ANGLE;

    /* renamed from: k, reason: collision with root package name */
    public static final int f151342k = 0;

    /* renamed from: l, reason: collision with root package name */
    public static final int f151343l = 1;

    /* renamed from: m, reason: collision with root package name */
    public static final int f151344m = 2;

    /* renamed from: v, reason: collision with root package name */
    public static final int f151345v = 0;

    /* renamed from: w, reason: collision with root package name */
    public static final int f151346w = 1;

    /* renamed from: x, reason: collision with root package name */
    public static final int f151347x = 2;

    /* renamed from: y, reason: collision with root package name */
    public static final int f151348y = 3;

    /* renamed from: z, reason: collision with root package name */
    private static final int f151349z = 1;
    private ab E;
    private UiSettings J;
    private boolean K;
    private TencentMapPro L;
    private final tz M;
    private float N;

    /* renamed from: o, reason: collision with root package name */
    public final ne f151351o;

    /* renamed from: q, reason: collision with root package name */
    public bi f151353q;

    /* renamed from: t, reason: collision with root package name */
    public py f151356t;

    /* renamed from: n, reason: collision with root package name */
    public boolean f151350n = false;

    /* renamed from: p, reason: collision with root package name */
    public boolean f151352p = true;

    /* renamed from: r, reason: collision with root package name */
    public qa f151354r = null;

    /* renamed from: s, reason: collision with root package name */
    public bh f151355s = null;
    private ag C = null;
    private Projection D = null;
    private ad F = null;
    private af G = null;
    private boolean H = false;
    private boolean I = false;

    /* renamed from: u, reason: collision with root package name */
    public final Map<qa.b, Boolean> f151357u = new ConcurrentHashMap();
    private GeoPoint O = new GeoPoint();
    private int P = 0;

    public VectorMap(ne neVar) {
        this.f151351o = neVar;
        this.M = (tz) neVar.f147916c;
    }

    private static int A() {
        return 20;
    }

    private String B() {
        return this.f151351o.K();
    }

    private String[] C() {
        ne neVar = this.f151351o;
        Rect q16 = neVar.f149398k.q();
        Point[] pointArr = {new Point(q16.centerX(), q16.centerY()), new Point(q16.left, q16.top), new Point(q16.left, q16.bottom), new Point(q16.right, q16.top), new Point(q16.right, q16.bottom)};
        HashSet hashSet = new HashSet();
        for (int i3 = 0; i3 < 5; i3++) {
            Point point = pointArr[i3];
            String a16 = neVar.a(new GeoPoint(point.y, point.x));
            if (!hs.a(a16)) {
                hashSet.add(a16);
            }
        }
        return (String[]) hashSet.toArray(new String[0]);
    }

    private Rect D() {
        return this.f151351o.f149398k.q();
    }

    private Rect E() {
        return this.f151351o.f149398k.r();
    }

    private int F() {
        return this.f151351o.f149398k.A.f151253b.f151291q;
    }

    private GeoPoint G() {
        return this.f151351o.f149398k.s();
    }

    private GeoPoint H() {
        return this.f151351o.f149398k.t();
    }

    private boolean I() {
        return this.f151351o.f149406s;
    }

    private boolean K() {
        return this.f151351o.f149407t;
    }

    private boolean L() {
        ne neVar = this.f151351o;
        tk tkVar = neVar.f149396i;
        if (tkVar == null || ((Integer) tkVar.a((CallbackRunnable<tk.AnonymousClass158>) new tk.AnonymousClass158(neVar.K()), (tk.AnonymousClass158) 0)).intValue() != 1) {
            return false;
        }
        return true;
    }

    private static boolean M() {
        return true;
    }

    private float N() {
        return this.f151351o.f149398k.A.f151253b.a();
    }

    private void O() {
        this.f151351o.f149398k.a((Runnable) null);
    }

    private void P() {
        this.f151351o.f149398k.b((Runnable) null);
    }

    private void Q() {
        this.f151351o.f149398k.p();
    }

    private boolean R() {
        return this.f151351o.f149398k.k();
    }

    private void S() {
        ae aeVar = this.f151351o.f149398k;
        aeVar.o();
        aeVar.j();
    }

    private void T() {
        ae aeVar = this.f151351o.f149398k;
        aeVar.o();
        aeVar.a(aeVar.h(), MapParamConstants.MAX_SKEW_ANGLE, true);
    }

    private void U() {
        ae aeVar = this.f151351o.f149398k;
        aeVar.o();
        aeVar.f147732o.e();
        aeVar.a(0.0d, 0.0d);
    }

    private void V() {
        ae aeVar = this.f151351o.f149398k;
        aeVar.o();
        aeVar.f147732o.e();
        aeVar.a(aeVar.h(), MapParamConstants.MAX_SKEW_ANGLE);
    }

    private void W() {
        tk tkVar = this.f151351o.f149396i;
        if (tkVar != null) {
            tkVar.d();
        }
    }

    private void X() {
        tk tkVar = this.f151351o.f149396i;
        if (tkVar != null) {
            tkVar.f();
        }
    }

    private void Y() {
        tk tkVar = this.f151351o.f149396i;
        if (tkVar != null) {
            tkVar.e();
        }
    }

    private void Z() {
        this.f151351o.f149409v.a();
    }

    private void aA() {
        this.f151350n = true;
    }

    private ArrayList<MapPoi> aB() {
        ne neVar = this.f151351o;
        if (neVar == null) {
            return null;
        }
        return neVar.N();
    }

    private String aC() {
        tk tkVar;
        ne neVar = this.f151351o;
        if (neVar == null || (tkVar = neVar.f149396i) == null) {
            return null;
        }
        return (String) tkVar.a(new tk.AnonymousClass48(), (tk.AnonymousClass48) null);
    }

    private String aD() {
        tk tkVar;
        ne neVar = this.f151351o;
        if (neVar == null || (tkVar = neVar.f149396i) == null) {
            return null;
        }
        return tkVar.a();
    }

    private ne aE() {
        return this.f151351o;
    }

    private bi aF() {
        return this.f151353q;
    }

    private void aG() {
        bh bhVar = this.f151355s;
        if (bhVar != null) {
            bhVar.a();
            this.f151355s = null;
        }
        bi biVar = this.f151353q;
        if (biVar != null) {
            if (biVar.f147819b != null) {
                ((VectorMap) biVar.f147819b.e_).b(biVar.f147829l);
                biVar.f147819b.k();
                biVar.f147819b = null;
            }
            if (biVar.f147820c != null) {
                biVar.f147820c = null;
            }
            hn.a aVar = hn.f148686b;
            if (aVar != null) {
                aVar.c();
            }
            this.f151353q = null;
        }
    }

    private void aH() {
        af afVar = this.G;
        if (afVar != null) {
            if (afVar.f147771a != null) {
                afVar.f147771a = null;
            }
            this.G = null;
        }
        ad adVar = this.F;
        if (adVar != null) {
            aj ajVar = adVar.f147714a;
            if (ajVar != null) {
                ajVar.a();
                adVar.f147714a = null;
            }
            this.F = null;
        }
        ab abVar = this.E;
        if (abVar != null) {
            if (abVar.f147684b != null) {
                abVar.f147684b = null;
            }
            this.E = null;
        }
        if (this.D != null) {
            this.D = null;
        }
        ag agVar = this.C;
        if (agVar != null) {
            if (agVar.f147772a != null) {
                agVar.f147772a = null;
            }
            this.C = null;
        }
    }

    private long aa() {
        return this.f151351o.f149398k.f147732o.c();
    }

    private void ab() {
        this.f151351o.f149398k.f147732o.a();
    }

    private void ac() {
        this.f151351o.f149398k.f147732o.b();
    }

    private String ad() {
        return this.f151351o.toString();
    }

    private boolean ae() {
        return this.f151351o.f149398k.f147732o.f();
    }

    private void af() {
        this.f151351o.f149398k.f147732o.f147672e = 60;
    }

    private int ag() {
        return this.f151351o.f149398k.A.f151255d;
    }

    private Rect ah() {
        return this.f151351o.f149405r;
    }

    private void ai() {
        this.f151351o.f149398k.e();
    }

    private void aj() {
        this.f151351o.f149398k.f();
    }

    private void ak() {
        rw rwVar;
        ne neVar = this.f151351o;
        if (neVar.f149407t && (rwVar = neVar.f149399l) != null) {
            rwVar.f150154b.a();
        }
    }

    private void al() {
        this.f151351o.I();
    }

    private int am() {
        return this.P;
    }

    private bh an() {
        return this.f151355s;
    }

    private String[] ao() {
        tk tkVar = this.f151351o.f149396i;
        if (tkVar == null) {
            return null;
        }
        return (String[]) tkVar.a(new tk.AnonymousClass161(), (tk.AnonymousClass161) null);
    }

    private String ap() {
        tk tkVar = this.f151351o.f149396i;
        if (tkVar == null) {
            return null;
        }
        return (String) tkVar.a(new tk.AnonymousClass164(), (tk.AnonymousClass164) null);
    }

    private Rect aq() {
        tk tkVar = this.f151351o.f149396i;
        if (tkVar == null) {
            return null;
        }
        return (Rect) tkVar.a(new tk.AnonymousClass163(), (tk.AnonymousClass163) null);
    }

    private v ar() {
        return this.f151351o.f149398k.g();
    }

    private void as() {
        this.f151351o.f149398k.j();
    }

    private nd at() {
        return this.f151351o.f149401n;
    }

    private v au() {
        return this.f151351o.f149410w;
    }

    private boolean av() {
        return this.f151351o.K.f150020f.v();
    }

    private void aw() {
        if (this.f151355s == null) {
            this.f151355s = new bh(this.f151351o, this.E);
        }
        if (this.F == null) {
            this.F = new ad(this.f151355s);
        }
    }

    private boolean ax() {
        return this.f151352p;
    }

    private String ay() {
        ne neVar = this.f151351o;
        if (neVar != null) {
            return neVar.E();
        }
        return null;
    }

    private boolean az() {
        return this.f151350n;
    }

    private static boolean b(GeoPoint geoPoint) {
        return es.f148293a.contains(geoPoint.getLongitudeE6(), geoPoint.getLatitudeE6());
    }

    private String c(GeoPoint geoPoint) {
        return this.f151351o.a(geoPoint);
    }

    private static boolean d(int i3, int i16) {
        return GeometryConstants.BOUNDARY_WORLD.contains(i16, i3);
    }

    private void f(fb fbVar) {
        this.f151351o.f149400m.b(fbVar);
        this.f151351o.f149412y = true;
    }

    private void g(int i3) {
        this.f151351o.a(i3);
    }

    private void i(int i3) {
        ae aeVar = this.f151351o.f149398k;
        aeVar.a(i3, (Runnable) new ae.AnonymousClass4());
    }

    private void j(int i3) {
        this.f151351o.f149398k.f147732o.a(i3);
    }

    private void k(int i3) {
        ne neVar = this.f151351o;
        if (neVar == null) {
            return;
        }
        if (i3 != 0) {
            if (i3 == 1) {
                neVar.a(false, false);
                int i16 = (getMapStyle() != 11 ? 18 : 17) - 1;
                if (this.P == 2) {
                    ae aeVar = this.f151351o.f149398k;
                    aeVar.a(i16, (Runnable) new ae.AnonymousClass4());
                } else {
                    int s16 = s();
                    if (s16 > i16) {
                        i16 = s16;
                    }
                    a(this.O, i16);
                }
            } else if (i3 == 2) {
                int i17 = getMapStyle() != 11 ? 18 : 17;
                int s17 = s();
                if (s17 > i17) {
                    i17 = s17;
                }
                if (this.O.getLatitudeE6() != 0) {
                    this.f151351o.f149398k.a(this.O.getLatitudeE6(), this.O.getLongitudeE6(), 2);
                }
                float f16 = this.N;
                ae aeVar2 = this.f151351o.f149398k;
                aeVar2.a(i17, (Runnable) new ae.AnonymousClass5(f16));
                new Handler().postDelayed(new Runnable() { // from class: com.tencent.mapsdk.vector.VectorMap.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        VectorMap.this.f151351o.a(true, false);
                    }
                }, 1000L);
            } else if (i3 == 3) {
                neVar.a(false, true);
            }
        } else {
            neVar.a(false, false);
        }
        this.P = i3;
    }

    private static int l(int i3) {
        if (i3 < 3) {
            i3 = 3;
        }
        if (i3 > 22) {
            return 22;
        }
        return i3;
    }

    private void m(int i3) {
        tk tkVar = this.f151351o.f149396i;
        if (tkVar != null && 0 != tkVar.f150515e) {
            tkVar.a(new tk.AnonymousClass172(i3));
        }
    }

    private void n(int i3) {
        ne neVar = this.f151351o;
        tk tkVar = neVar.f149396i;
        if (tkVar != null) {
            tkVar.b(i3);
        }
        v vVar = neVar.f149410w;
        if (vVar != null) {
            vVar.f151253b.f151288n = i3;
        }
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public AoiLayer addAoiLayer(String str, AoiLayerOptions aoiLayerOptions, AoiLayer.OnAoiLayerLoadListener onAoiLayerLoadListener) {
        py pyVar;
        super.addAoiLayer(str, aoiLayerOptions, onAoiLayerLoadListener);
        pw pwVar = null;
        if (!this.H && (pyVar = this.f151356t) != null) {
            Iterator<pw> it = pyVar.f149721a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                pw next = it.next();
                if (next.getId() != null && next.getId().equals(str)) {
                    pwVar = next;
                    break;
                }
            }
            if (pwVar == null) {
                pwVar = new pw(pyVar, str, aoiLayerOptions, pyVar);
                pyVar.f149721a.add(pwVar);
                if (onAoiLayerLoadListener != null) {
                    pyVar.f149724d.put(str, onAoiLayerLoadListener);
                }
            }
            pwVar.a(aoiLayerOptions);
            o();
        }
        return pwVar;
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public Arc addArc(ArcOptions arcOptions) {
        ne neVar;
        if (!this.H && (neVar = this.f151351o) != null && arcOptions != null) {
            bj bjVar = neVar.M;
            pl plVar = new pl(arcOptions, bjVar.f147870i);
            at atVar = new at(plVar);
            bjVar.f147862a.put(plVar.getId(), atVar);
            bjVar.f147865d.add(atVar);
            bjVar.a((ex) plVar);
            return atVar;
        }
        return null;
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public Circle addCircle(CircleOptions circleOptions) {
        ne neVar;
        if (!this.H && circleOptions != null && (neVar = this.f151351o) != null) {
            return neVar.M.a(circleOptions);
        }
        return null;
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public CustomLayer addCustomLayer(CustomLayerOptions customLayerOptions) {
        ab abVar;
        ak akVar;
        super.addCustomLayer(customLayerOptions);
        if (this.H || (abVar = this.E) == null || (akVar = abVar.f147684b) == null) {
            return null;
        }
        return akVar.a(customLayerOptions);
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public GroundOverlay addGroundOverlay(GroundOverlayOptions groundOverlayOptions) {
        ne neVar;
        super.addGroundOverlay(groundOverlayOptions);
        GroundOverlay groundOverlay = null;
        if (!this.H && (neVar = this.f151351o) != null && groundOverlayOptions != null) {
            if (neVar.f149396i != null) {
                hi hiVar = neVar.f147918e;
                if (hiVar != null) {
                    hiVar.o().f148620a++;
                }
                groundOverlay = (GroundOverlay) neVar.f149400m.a((bk) new nv(neVar.f149396i.A(), groundOverlayOptions));
            }
            o();
        }
        return groundOverlay;
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public Marker addMarker(MarkerOptions markerOptions) {
        ne neVar;
        if (!this.H && (neVar = this.f151351o) != null && markerOptions != null) {
            return neVar.M.a(markerOptions);
        }
        return null;
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void addOnMapLoadedCallback(TencentMap.OnMapLoadedCallback onMapLoadedCallback) {
        ab abVar;
        ak akVar;
        super.addOnMapLoadedCallback(onMapLoadedCallback);
        if (!this.H && (abVar = this.E) != null && (akVar = abVar.f147684b) != null) {
            akVar.a(onMapLoadedCallback);
        }
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public Polygon addPolygon(PolygonOptions polygonOptions) {
        ne neVar;
        if (!this.H && (neVar = this.f151351o) != null && polygonOptions != null) {
            bj bjVar = neVar.M;
            pq pqVar = new pq(bjVar.f147870i, polygonOptions);
            ay ayVar = new ay(pqVar);
            bjVar.f147862a.put(pqVar.getId(), ayVar);
            bjVar.f147867f.add(ayVar);
            bjVar.a((ex) pqVar);
            return ayVar;
        }
        return null;
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public Polyline addPolyline(PolylineOptions polylineOptions) {
        ne neVar;
        if (!this.H && (neVar = this.f151351o) != null && polylineOptions != null) {
            return neVar.M.a(polylineOptions);
        }
        return null;
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void addTencentMapGestureListener(TencentMapGestureListener tencentMapGestureListener) {
        ab abVar;
        ak akVar;
        super.addTencentMapGestureListener(tencentMapGestureListener);
        if (!this.H && (abVar = this.E) != null && (akVar = abVar.f147684b) != null) {
            akVar.a(tencentMapGestureListener);
        }
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public TileOverlay addTileOverlay(TileOverlayOptions tileOverlayOptions) {
        ab abVar;
        ak akVar;
        super.addTileOverlay(tileOverlayOptions);
        if (this.H || (abVar = this.E) == null || (akVar = abVar.f147684b) == null) {
            return null;
        }
        return akVar.a(tileOverlayOptions);
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public VectorHeatOverlay addVectorHeatOverlay(VectorHeatOverlayOptions vectorHeatOverlayOptions) {
        ne neVar;
        super.addVectorHeatOverlay(vectorHeatOverlayOptions);
        VectorHeatOverlay vectorHeatOverlay = null;
        if (!this.H && (neVar = this.f151351o) != null) {
            if (neVar.f149396i != null) {
                hi hiVar = neVar.f147918e;
                if (hiVar != null) {
                    hiVar.h().a();
                }
                vectorHeatOverlay = (VectorHeatOverlay) neVar.f149400m.a((bk) new nl(vectorHeatOverlayOptions));
            }
            o();
        }
        return vectorHeatOverlay;
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public <L extends VectorOverlay> L addVectorOverlay(VectorOverlayProvider vectorOverlayProvider) {
        ne neVar;
        super.addVectorOverlay(vectorOverlayProvider);
        if (!this.H && (neVar = this.f151351o) != null) {
            L l3 = (L) neVar.a(vectorOverlayProvider);
            o();
            return l3;
        }
        return null;
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public VisualLayer addVisualLayer(VisualLayerOptions visualLayerOptions) {
        super.addVisualLayer(visualLayerOptions);
        eg egVar = (eg) getMapComponent(eg.class);
        if (egVar != null) {
            return egVar.a(visualLayerOptions);
        }
        return null;
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void animateCamera(CameraUpdate cameraUpdate) {
        ab abVar;
        super.animateCamera(cameraUpdate);
        if (this.H || (abVar = this.E) == null || abVar.b()) {
            return;
        }
        this.E.a(cameraUpdate, 500L, (TencentMap.CancelableCallback) null);
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public CameraPosition calculateZoomToSpanLevel(List<IOverlay> list, List<LatLng> list2, int i3, int i16, int i17, int i18) {
        ArrayList arrayList;
        super.calculateZoomToSpanLevel(list, list2, i3, i16, i17, i18);
        if (this.H || this.E == null) {
            return null;
        }
        int abs = Math.abs(i3);
        int abs2 = Math.abs(i16);
        int abs3 = Math.abs(i17);
        int abs4 = Math.abs(i18);
        if (list != null) {
            ArrayList arrayList2 = new ArrayList();
            for (IOverlay iOverlay : list) {
                if (iOverlay instanceof fb) {
                    arrayList2.add((fb) iOverlay);
                }
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        ak akVar = this.E.f147684b;
        if (akVar == null) {
            return null;
        }
        return akVar.a(arrayList, list2, abs, abs2, abs3, abs4);
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void clear() {
        super.clear();
        clearAllOverlays();
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void clearAllOverlays() {
        tz tzVar;
        super.clearAllOverlays();
        if (!this.H && (tzVar = this.M) != null) {
            tzVar.l();
        }
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void clearCache() {
        super.clearCache();
        kt.f(mz.a(getMapContext().getContext(), (TencentMapOptions) null).c());
    }

    public void clearRouteNameSegments() {
        ne neVar = this.f151351o;
        if (neVar.C == null) {
            neVar.C = new ne.d();
        }
        ne.d dVar = neVar.C;
        ne.this.f149396i.w();
        dVar.f149425a = null;
        dVar.f149426b = null;
    }

    @Override // com.tencent.mapsdk.internal.bn
    public final void e() {
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void enableAutoMaxSkew(boolean z16) {
        ne neVar;
        super.enableAutoMaxSkew(z16);
        if (!this.H && (neVar = this.f151351o) != null) {
            neVar.f149410w.f151270s = z16;
        }
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void enableMultipleInfowindow(boolean z16) {
        ab abVar;
        ak akVar;
        super.enableMultipleInfowindow(z16);
        if (!this.H && (abVar = this.E) != null && (akVar = abVar.f147684b) != null) {
            akVar.f(z16);
        }
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public String executeVisualLayerCommand(VisualLayer visualLayer, String str) {
        super.executeVisualLayerCommand(visualLayer, str);
        eg egVar = (eg) getMapComponent(eg.class);
        if (egVar != null) {
            return egVar.a(visualLayer, str);
        }
        return null;
    }

    @Override // com.tencent.map.sdk.comps.indoor.IIndoor
    public String getActivedIndoorBuilding(LatLng latLng) {
        ab abVar;
        ak akVar;
        IndoorBuilding u16;
        if (this.H || (abVar = this.E) == null || (akVar = abVar.f147684b) == null || (u16 = akVar.u()) == null) {
            return null;
        }
        if (u16.getBuildingLatLng() != null && latLng != null) {
            latLng.latitude = u16.getBuildingLatLng().latitude;
            latLng.longitude = u16.getBuildingLatLng().longitude;
        }
        return u16.getBuildingName();
    }

    @Override // com.tencent.map.sdk.comps.indoor.IIndoor
    public String[] getActivedIndoorFloorNames() {
        ab abVar;
        ak akVar;
        if (this.H || (abVar = this.E) == null || (akVar = abVar.f147684b) == null) {
            return null;
        }
        return akVar.s();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public List<LatLng> getBounderPoints(Marker marker) {
        ne neVar;
        ax axVar;
        if (marker == null || (neVar = this.f151351o) == null || (axVar = (ax) neVar.M.a(marker.getId(), ax.class)) == null) {
            return null;
        }
        return axVar.f147778b.e();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public CameraPosition getCameraPosition() {
        ab abVar;
        if (!this.H && (abVar = this.E) != null) {
            return abVar.a();
        }
        return null;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public String getCityName(LatLng latLng) {
        ab abVar;
        if (!this.H && (abVar = this.E) != null) {
            ak akVar = abVar.f147684b;
            if (akVar == null) {
                return null;
            }
            return akVar.a(latLng);
        }
        return "";
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public String getDebugError() {
        ab abVar;
        ak akVar;
        if (this.H || (abVar = this.E) == null || (akVar = abVar.f147684b) == null) {
            return null;
        }
        return akVar.z();
    }

    @Override // com.tencent.map.sdk.comps.indoor.IIndoor
    public int getIndoorFloorId() {
        ab abVar;
        ak akVar;
        if (this.H || (abVar = this.E) == null || (akVar = abVar.f147684b) == null) {
            return -1;
        }
        return akVar.r();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public Language getLanguage() {
        ne neVar = this.f151351o;
        if (neVar.B == null) {
            neVar.B = new ne.c();
        }
        ne.c cVar = neVar.B;
        if (ne.this.f149396i != null) {
            tk tkVar = ne.this.f149396i;
            return Language.wrap(tkVar.f150514d.nativeGetLanguage(tkVar.f150515e));
        }
        return Language.zh;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public TencentMapContext getMapContext() {
        return this.f151351o;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public int getMapHeight() {
        return this.f151351o.f147916c.getMapRenderView().getHeight();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public Rect getMapPadding() {
        return this.f151351o.f149398k.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Keep
    public TencentMapPro getMapPro() {
        return this.L;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public int getMapStyle() {
        ab abVar;
        if (!this.H && (abVar = this.E) != null) {
            ak akVar = abVar.f147684b;
            if (akVar == null) {
                return -1;
            }
            return akVar.f();
        }
        return 0;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public int getMapType() {
        ab abVar;
        ak akVar;
        if (this.H || (abVar = this.E) == null || (akVar = abVar.f147684b) == null) {
            return 1000;
        }
        return akVar.A();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public int getMapWidth() {
        return this.f151351o.f147916c.getMapRenderView().getWidth();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public float getMaxZoomLevel() {
        ab abVar;
        if (!this.H && (abVar = this.E) != null) {
            ak akVar = abVar.f147684b;
            if (akVar == null) {
                return -1.0f;
            }
            return akVar.b();
        }
        return 0.0f;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public float getMinZoomLevel() {
        ab abVar;
        if (!this.H && (abVar = this.E) != null) {
            ak akVar = abVar.f147684b;
            if (akVar == null) {
                return -1.0f;
            }
            return akVar.c();
        }
        return 0.0f;
    }

    @Override // com.tencent.map.sdk.comps.mylocation.IMyLocation
    public Location getMyLocation() {
        if (this.H) {
            return null;
        }
        aw();
        aj ajVar = this.F.f147714a;
        if (ajVar == null) {
            return null;
        }
        return ajVar.e();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public List<Marker> getScreenMarkers() {
        ArrayList arrayList = new ArrayList();
        Iterator<ap> it = ((tr) this.f151351o.f147916c).ah().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public UiSettings getUiSettings() {
        if (this.H) {
            return null;
        }
        if (this.J == null) {
            this.J = new ty(this.G);
        }
        return this.J;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public String getVersion() {
        ab abVar;
        ak akVar;
        if (this.H || (abVar = this.E) == null || (akVar = abVar.f147684b) == null) {
            return "";
        }
        return akVar.o();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public VisualSettings getVisualSettings() {
        ne neVar;
        if (!this.H && (neVar = this.f151351o) != null) {
            return neVar.f149404q;
        }
        return null;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public float getZoomToSpanLevel(LatLng latLng, LatLng latLng2) {
        ab abVar;
        ak akVar;
        if (!this.H && (abVar = this.E) != null) {
            if (latLng == null || latLng2 == null || (akVar = abVar.f147684b) == null) {
                return -1.0f;
            }
            return akVar.a(latLng, latLng2);
        }
        return 0.0f;
    }

    @Override // com.tencent.mapsdk.internal.bn
    public final int h() {
        ne neVar = this.f151351o;
        if (neVar == null) {
            return -1;
        }
        return neVar.N;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public boolean isBlockRouteEnabled() {
        return false;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public boolean isDestroyed() {
        return this.H;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public boolean isHandDrawMapEnable() {
        ab abVar;
        ak akVar;
        if (this.H || (abVar = this.E) == null || (akVar = abVar.f147684b) == null) {
            return false;
        }
        return akVar.w();
    }

    @Override // com.tencent.map.sdk.comps.mylocation.IMyLocation
    public boolean isMyLocationEnabled() {
        if (this.H) {
            return false;
        }
        aw();
        aj ajVar = this.F.f147714a;
        if (ajVar == null) {
            return false;
        }
        return ajVar.d();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public boolean isSateLiteEnable() {
        if (getMapType() == 1011) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public boolean isTrafficEnabled() {
        ab abVar;
        ak akVar;
        if (this.H || (abVar = this.E) == null || (akVar = abVar.f147684b) == null) {
            return false;
        }
        return akVar.h();
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void loadKMLFile(String str) {
        ab abVar;
        ak akVar;
        super.loadKMLFile(str);
        if (!this.H && (abVar = this.E) != null && (akVar = abVar.f147684b) != null) {
            akVar.a(str);
        }
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void moveCamera(CameraUpdate cameraUpdate) {
        ab abVar;
        super.moveCamera(cameraUpdate);
        if (!this.H && (abVar = this.E) != null && !abVar.b()) {
            this.E.a(cameraUpdate);
        }
    }

    public final void o() {
        this.f151351o.f149412y = true;
    }

    public final int p() {
        return this.f151351o.f149410w.f151253b.f151288n;
    }

    public final int q() {
        return this.f151351o.f149410w.f151253b.f151289o;
    }

    public final GeoPoint r() {
        return this.f151351o.f149398k.A.f151264m;
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void removeOnMapLoadedCallback(TencentMap.OnMapLoadedCallback onMapLoadedCallback) {
        ab abVar;
        ak akVar;
        super.removeOnMapLoadedCallback(onMapLoadedCallback);
        if (!this.H && (abVar = this.E) != null && (akVar = abVar.f147684b) != null) {
            akVar.b(onMapLoadedCallback);
        }
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void removeTencentMapGestureListener(TencentMapGestureListener tencentMapGestureListener) {
        ab abVar;
        ak akVar;
        super.removeTencentMapGestureListener(tencentMapGestureListener);
        if (!this.H && (abVar = this.E) != null && (akVar = abVar.f147684b) != null) {
            akVar.b(tencentMapGestureListener);
        }
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.map.sdk.comps.indoor.IIndoor
    public void resetIndoorCellInfo() {
        tk tkVar;
        super.resetIndoorCellInfo();
        if (!this.H && this.E != null && (tkVar = this.f151351o.f149396i) != null) {
            tkVar.a(new tk.AnonymousClass98());
        }
    }

    public final int s() {
        return this.f151351o.f149398k.A.f151253b.f151291q;
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setBaseMapEnabled(boolean z16) {
        ne neVar;
        super.setBaseMapEnabled(z16);
        if (!this.H && (neVar = this.f151351o) != null) {
            neVar.k(z16);
        }
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setBuilding3dEffectEnable(boolean z16) {
        ne neVar;
        super.setBuilding3dEffectEnable(z16);
        if (!this.H && (neVar = this.f151351o) != null) {
            neVar.c(z16);
        }
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setBuildingBlackList(List<LatLngBounds> list) {
        super.setBuildingBlackList(list);
        tk tkVar = this.f151351o.f149396i;
        if (tkVar != null) {
            tkVar.a(list);
        }
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setBuildingEnable(boolean z16) {
        super.setBuildingEnable(z16);
        setBuilding3dEffectEnable(z16);
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setCameraCenterProportion(float f16, float f17) {
        super.setCameraCenterProportion(f16, f17);
        setCameraCenterProportion(f16, f17, true);
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setCustomRender(CustomRender customRender) {
        ne neVar;
        super.setCustomRender(customRender);
        if (!this.H && (neVar = this.f151351o) != null) {
            neVar.I = customRender;
            neVar.f149412y = true;
        }
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setDrawPillarWith2DStyle(boolean z16) {
        ne neVar;
        super.setDrawPillarWith2DStyle(z16);
        if (!this.H && (neVar = this.f151351o) != null) {
            neVar.c(!z16);
        }
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setForeignLanguage(Language language) {
        ab abVar;
        super.setForeignLanguage(language);
        if (!this.H && (abVar = this.E) != null) {
            abVar.a(language);
        }
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setHandDrawMapEnable(boolean z16) {
        ab abVar;
        ak akVar;
        super.setHandDrawMapEnable(z16);
        if (!this.H && (abVar = this.E) != null && (akVar = abVar.f147684b) != null) {
            akVar.e(z16);
        }
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.map.sdk.comps.indoor.IIndoor
    public void setIndoorCellInfo(List<IndoorCellInfo> list) {
        tk tkVar;
        super.setIndoorCellInfo(list);
        if (!this.H && this.E != null && (tkVar = this.f151351o.f149396i) != null) {
            tkVar.a(new tk.AnonymousClass97(list));
        }
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.map.sdk.comps.indoor.IIndoor
    public void setIndoorEnabled(boolean z16) {
        ab abVar;
        ak akVar;
        super.setIndoorEnabled(z16);
        if (!this.H && (abVar = this.E) != null && (akVar = abVar.f147684b) != null) {
            akVar.c(z16);
        }
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.map.sdk.comps.indoor.IIndoor
    public void setIndoorFloor(int i3) {
        ab abVar;
        ak akVar;
        super.setIndoorFloor(i3);
        if (this.H || (abVar = this.E) == null || (akVar = abVar.f147684b) == null) {
            return;
        }
        akVar.c(i3);
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.map.sdk.comps.indoor.IIndoor
    public void setIndoorMaskColor(int i3) {
        super.setIndoorMaskColor(i3);
        tk tkVar = this.f151351o.f149396i;
        if (0 != tkVar.f150515e) {
            tkVar.a(new tk.AnonymousClass166(i3));
        }
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setInfoWindowAdapter(TencentMap.InfoWindowAdapter infoWindowAdapter) {
        tz tzVar;
        super.setInfoWindowAdapter(infoWindowAdapter);
        if (!this.H && (tzVar = this.M) != null) {
            tzVar.aJ = new WeakReference<>(infoWindowAdapter);
        }
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setLanguage(Language language) {
        super.setLanguage(language);
        if (!this.H && this.E != null && "bmw".equals(tf.f150436c)) {
            ne neVar = this.f151351o;
            if (neVar.B == null) {
                neVar.B = new ne.c();
            }
            ne.c cVar = neVar.B;
            tk tkVar = ne.this.f149396i;
            if (tkVar != null) {
                int languageType = language.getLanguageType();
                if (tkVar.f150515e != 0) {
                    tkVar.f150514d.nativeSetLanguage(tkVar.f150515e, languageType);
                }
                ne.this.f149412y = true;
                ne.this.f149412y = true;
                cVar.a(language);
            }
            this.E.a(language);
        }
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setLocationCompassHidden(boolean z16) {
        super.setLocationCompassHidden(z16);
        this.f151351o.f(z16);
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setLocationNavigationGravityLineHidden(boolean z16) {
        super.setLocationNavigationGravityLineHidden(z16);
        this.f151351o.g(z16);
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.map.sdk.comps.mylocation.IMyLocation
    public void setLocationSource(LocationSource locationSource) {
        super.setLocationSource(locationSource);
        if (this.H) {
            return;
        }
        aw();
        aj ajVar = this.F.f147714a;
        if (ajVar != null) {
            ajVar.a(locationSource);
        }
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setMapCenterAndScale(float f16, float f17, float f18) {
        bi biVar;
        tr trVar;
        ne neVar;
        boolean z16;
        super.setMapCenterAndScale(f16, f17, f18);
        if (!this.H && (biVar = this.f151353q) != null && (neVar = (trVar = biVar.f147819b).aC) != null) {
            float f19 = neVar.f149398k.A.f151253b.f151290p;
            float c16 = tz.c(f18);
            if (Math.abs(f19 - c16) > 1.0E-4d) {
                z16 = true;
            } else {
                z16 = false;
            }
            trVar.aE = 0;
            kp.a(new tz.AnonymousClass1((f17 - trVar.aD) / 10.0f, f16, f17, f18, z16, c16));
        }
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setMapFontSize(MapFontSize mapFontSize) {
        if (!this.H && this.E != null && mapFontSize != null) {
            ne neVar = this.f151351o;
            int value = mapFontSize.getValue();
            tk tkVar = neVar.f149396i;
            tkVar.a(new tk.AnonymousClass60(value));
        }
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setMapFrameRate(float f16) {
        bw bwVar;
        super.setMapFrameRate(f16);
        tz tzVar = this.M;
        if (tzVar != null && (bwVar = tzVar.f147931c) != null) {
            bwVar.a(f16);
        }
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setMapStyle(int i3) {
        ab abVar;
        ak akVar;
        super.setMapStyle(i3);
        if (!this.H && (abVar = this.E) != null && (akVar = abVar.f147684b) != null) {
            akVar.a(i3);
        }
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setMapType(int i3) {
        ab abVar;
        ak akVar;
        super.setMapType(i3);
        if (!this.H && (abVar = this.E) != null && (akVar = abVar.f147684b) != null) {
            akVar.f(i3);
        }
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setMaxZoomLevel(int i3) {
        super.setMaxZoomLevel(i3);
        if (!this.H && this.E != null) {
            int l3 = l(i3);
            ak akVar = this.E.f147684b;
            if (akVar != null) {
                akVar.d(l3);
            }
            float f16 = l3;
            if (this.E.a().zoom > f16) {
                animateCamera(CameraUpdateFactory.zoomTo(f16));
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setMinZoomLevel(int i3) {
        super.setMinZoomLevel(i3);
        if (!this.H && this.E != null) {
            int l3 = l(i3);
            ak akVar = this.E.f147684b;
            if (akVar != null) {
                akVar.e(l3);
            }
            float f16 = l3;
            if (this.E.a().zoom < f16) {
                animateCamera(CameraUpdateFactory.zoomTo(f16));
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.map.sdk.comps.mylocation.IMyLocation
    public void setMyLocationClickListener(TencentMap.OnMyLocationClickListener onMyLocationClickListener) {
        super.setMyLocationClickListener(onMyLocationClickListener);
        if (this.H) {
            return;
        }
        if (this.f151355s == null) {
            aw();
        }
        bh bhVar = this.f151355s;
        if (onMyLocationClickListener != null) {
            bhVar.f147802f = new WeakReference<>(onMyLocationClickListener);
        }
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.map.sdk.comps.mylocation.IMyLocation
    public void setMyLocationEnabled(boolean z16) {
        aj ajVar;
        super.setMyLocationEnabled(z16);
        if (this.H) {
            return;
        }
        aw();
        if (!z16) {
            aj ajVar2 = this.F.f147714a;
            if (ajVar2 != null) {
                ajVar2.c();
                return;
            }
            return;
        }
        if (!isMyLocationEnabled() && (ajVar = this.F.f147714a) != null) {
            ajVar.b();
        }
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap, com.tencent.map.sdk.comps.mylocation.IMyLocation
    public void setMyLocationStyle(MyLocationStyle myLocationStyle) {
        super.setMyLocationStyle(myLocationStyle);
        if (this.F == null) {
            aw();
        }
        aj ajVar = this.F.f147714a;
        if (ajVar != null) {
            ajVar.a(myLocationStyle);
        }
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setOnCameraChangeListener(TencentMap.OnCameraChangeListener onCameraChangeListener) {
        ab abVar;
        ak akVar;
        super.setOnCameraChangeListener(onCameraChangeListener);
        if (!this.H && (abVar = this.E) != null && (akVar = abVar.f147684b) != null) {
            akVar.a(onCameraChangeListener);
        }
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setOnCompassClickedListener(TencentMap.OnCompassClickedListener onCompassClickedListener) {
        ab abVar;
        ak akVar;
        super.setOnCompassClickedListener(onCompassClickedListener);
        if (!this.H && (abVar = this.E) != null && (akVar = abVar.f147684b) != null) {
            akVar.a(onCompassClickedListener);
        }
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.map.sdk.comps.indoor.IIndoor
    public void setOnIndoorStateChangeListener(TencentMap.OnIndoorStateChangeListener onIndoorStateChangeListener) {
        ab abVar;
        ak akVar;
        super.setOnIndoorStateChangeListener(onIndoorStateChangeListener);
        if (!this.H && (abVar = this.E) != null && (akVar = abVar.f147684b) != null) {
            akVar.a(onIndoorStateChangeListener);
        }
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setOnInfoWindowClickListener(TencentMap.OnInfoWindowClickListener onInfoWindowClickListener) {
        tz tzVar;
        super.setOnInfoWindowClickListener(onInfoWindowClickListener);
        if (!this.H && (tzVar = this.M) != null) {
            tzVar.a(onInfoWindowClickListener);
        }
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setOnMapClickListener(TencentMap.OnMapClickListener onMapClickListener) {
        ab abVar;
        ak akVar;
        super.setOnMapClickListener(onMapClickListener);
        if (!this.H && (abVar = this.E) != null && (akVar = abVar.f147684b) != null) {
            akVar.a(onMapClickListener);
        }
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setOnMapFrameFinished(TencentMap.OnMapFrameFinishCallback onMapFrameFinishCallback) {
        tz tzVar;
        super.setOnMapFrameFinished(onMapFrameFinishCallback);
        if (!this.H && (tzVar = this.M) != null) {
            tzVar.a(onMapFrameFinishCallback);
        }
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setOnMapLongClickListener(TencentMap.OnMapLongClickListener onMapLongClickListener) {
        ab abVar;
        ak akVar;
        super.setOnMapLongClickListener(onMapLongClickListener);
        if (!this.H && (abVar = this.E) != null && (akVar = abVar.f147684b) != null) {
            akVar.a(onMapLongClickListener);
        }
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setOnMapPoiClickListener(TencentMap.OnMapPoiClickListener onMapPoiClickListener) {
        super.setOnMapPoiClickListener(onMapPoiClickListener);
        if (!this.H && this.E != null) {
            py pyVar = this.f151356t;
            if (pyVar != null) {
                pyVar.f149723c = onMapPoiClickListener;
            }
            this.M.a(onMapPoiClickListener);
        }
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setOnMarkerClickListener(TencentMap.OnMarkerClickListener onMarkerClickListener) {
        tz tzVar;
        super.setOnMarkerClickListener(onMarkerClickListener);
        if (!this.H && (tzVar = this.M) != null) {
            tzVar.a(onMarkerClickListener);
        }
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setOnMarkerCollisionStatusListener(TencentMap.OnMarkerCollisionStatusListener onMarkerCollisionStatusListener) {
        tz tzVar;
        super.setOnMarkerCollisionStatusListener(onMarkerCollisionStatusListener);
        if (!this.H && (tzVar = this.M) != null) {
            tzVar.a(onMarkerCollisionStatusListener);
        }
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setOnMarkerDragListener(TencentMap.OnMarkerDragListener onMarkerDragListener) {
        tz tzVar;
        super.setOnMarkerDragListener(onMarkerDragListener);
        if (!this.H && (tzVar = this.M) != null) {
            tzVar.a(onMarkerDragListener);
        }
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.map.sdk.comps.mylocation.IMyLocation
    public void setOnMyLocationChangeListener(TencentMap.OnMyLocationChangeListener onMyLocationChangeListener) {
        super.setOnMyLocationChangeListener(onMyLocationChangeListener);
        if (this.H) {
            return;
        }
        if (this.f151355s == null) {
            aw();
        }
        bh bhVar = this.f151355s;
        if (onMyLocationChangeListener != null) {
            bhVar.f147801e = new WeakReference<>(onMyLocationChangeListener);
        }
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setOnPolygonClickListener(TencentMap.OnPolygonClickListener onPolygonClickListener) {
        tz tzVar;
        super.setOnPolygonClickListener(onPolygonClickListener);
        if (!this.H && (tzVar = this.M) != null) {
            tzVar.a(onPolygonClickListener);
        }
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setOnPolylineClickListener(TencentMap.OnPolylineClickListener onPolylineClickListener) {
        tz tzVar;
        super.setOnPolylineClickListener(onPolylineClickListener);
        if (!this.H && (tzVar = this.M) != null) {
            tzVar.a(onPolylineClickListener);
        }
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setOnScaleViewChangedListener(TencentMap.OnScaleViewChangedListener onScaleViewChangedListener) {
        ab abVar;
        ak akVar;
        super.setOnScaleViewChangedListener(onScaleViewChangedListener);
        if (!this.H && (abVar = this.E) != null && (akVar = abVar.f147684b) != null) {
            akVar.a(onScaleViewChangedListener);
        }
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setOnTapMapViewInfoWindowHidden(boolean z16) {
        ab abVar;
        ak akVar;
        super.setOnTapMapViewInfoWindowHidden(z16);
        if (!this.H && (abVar = this.E) != null && (akVar = abVar.f147684b) != null) {
            akVar.g(z16);
        }
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setOnTrafficEventClickListener(TencentMap.OnTrafficEventClickListener onTrafficEventClickListener) {
        ab abVar;
        ak akVar;
        super.setOnTrafficEventClickListener(onTrafficEventClickListener);
        if (!this.H && (abVar = this.E) != null && (akVar = abVar.f147684b) != null) {
            akVar.a(onTrafficEventClickListener);
        }
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setOnVectorOverlayClickListener(TencentMap.OnVectorOverlayClickListener onVectorOverlayClickListener) {
        tz tzVar;
        super.setOnVectorOverlayClickListener(onVectorOverlayClickListener);
        if (!this.H && (tzVar = this.M) != null) {
            tzVar.aC.O = onVectorOverlayClickListener;
        }
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setOverSeaEnable(boolean z16) {
        super.setOverSeaEnable(z16);
        tz tzVar = this.M;
        if (tzVar != null) {
            tzVar.m(z16);
        }
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setOverSeaTileProvider(OverSeaTileProvider overSeaTileProvider) {
        ne neVar;
        bb bbVar;
        super.setOverSeaTileProvider(overSeaTileProvider);
        if (!this.H && (neVar = this.f151351o) != null && (bbVar = neVar.f149402o) != null) {
            bbVar.a(overSeaTileProvider);
        }
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setPadding(int i3, int i16, int i17, int i18) {
        super.setPadding(i3, i16, i17, i18);
        bi biVar = this.f151353q;
        if (biVar != null) {
            biVar.a(i3, i16, i17, i18, false);
        }
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setPointToCenter(int i3, int i16) {
        fa projection;
        super.setPointToCenter(i3, i16);
        if (!this.H && this.E != null && (projection = getProjection()) != null) {
            this.E.a(CameraUpdateFactory.newLatLng(projection.fromScreenLocation(new Point(i3, i16))));
        }
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setPoisEnabled(boolean z16) {
        ab abVar;
        ak akVar;
        super.setPoisEnabled(z16);
        if (!this.H && (abVar = this.E) != null && (akVar = abVar.f147684b) != null) {
            akVar.i(z16);
        }
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setRestrictBounds(LatLngBounds latLngBounds, RestrictBoundsFitMode restrictBoundsFitMode) {
        ab abVar;
        int ordinal;
        super.setRestrictBounds(latLngBounds, restrictBoundsFitMode);
        if (!this.H && (abVar = this.E) != null) {
            if (restrictBoundsFitMode == null) {
                ordinal = 0;
            } else {
                ordinal = restrictBoundsFitMode.ordinal();
            }
            ak akVar = abVar.f147684b;
            if (akVar != null) {
                akVar.a(latLngBounds, ordinal);
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setSatelliteEnabled(boolean z16) {
        super.setSatelliteEnabled(z16);
        if (z16) {
            setMapType(1011);
        } else {
            setMapType(1000);
        }
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setSceneByTag(String str) {
        ne neVar;
        super.setSceneByTag(str);
        if (!this.H && (neVar = this.f151351o) != null) {
            neVar.f147918e.f148661c = str;
        }
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setTencentMapGestureListener(TencentMapGestureListener tencentMapGestureListener) {
        super.setTencentMapGestureListener(tencentMapGestureListener);
        addTencentMapGestureListener(tencentMapGestureListener);
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setTrafficEnabled(boolean z16) {
        ab abVar;
        ak akVar;
        super.setTrafficEnabled(z16);
        if (!this.H && (abVar = this.E) != null && (akVar = abVar.f147684b) != null) {
            akVar.a(z16);
        }
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setTrafficMode(int i3, int i16) {
        super.setTrafficMode(i3, i16);
        if (!this.H && this.E != null) {
            tk tkVar = this.f151351o.f149396i;
            tkVar.b(new tk.AnonymousClass2(i3, i16));
        }
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void showBuilding(boolean z16) {
        super.showBuilding(z16);
        tk tkVar = this.f151351o.f149396i;
        if (tkVar != null) {
            tkVar.a(new tk.AnonymousClass42(z16));
        }
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void snapshot(TencentMap.SnapshotReadyCallback snapshotReadyCallback, Bitmap.Config config, int i3) {
        ak akVar;
        super.snapshot(snapshotReadyCallback, config, i3);
        ab abVar = this.E;
        if (abVar == null || (akVar = abVar.f147684b) == null || snapshotReadyCallback == null) {
            return;
        }
        abVar.f147685c = snapshotReadyCallback;
        Handler handler = abVar.f147686d;
        if (akVar != null) {
            akVar.a(handler, config, i3);
        }
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void stopAnimation() {
        ab abVar;
        ak akVar;
        super.stopAnimation();
        if (!this.H && (abVar = this.E) != null && (akVar = abVar.f147684b) != null) {
            akVar.d();
        }
    }

    public final float t() {
        return this.f151351o.f149398k.A.f151253b.f151290p;
    }

    public final void u() {
        w wVar = this.f151351o.f149408u;
        if (wVar == null) {
            return;
        }
        wVar.c();
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void updateVectorOverlay(VectorOverlay vectorOverlay, VectorOverlayProvider vectorOverlayProvider) {
        ne neVar;
        super.updateVectorOverlay(vectorOverlay, vectorOverlayProvider);
        if (!this.H && (neVar = this.f151351o) != null) {
            if (neVar.f149396i != null) {
                if (vectorOverlayProvider instanceof AggregationOverlayProvider) {
                    nk nkVar = (nk) neVar.f149400m.a(nk.class, ((nk) vectorOverlay).b());
                    if (nkVar != null) {
                        nkVar.a((nk) new nl((AggregationOverlayProvider) vectorOverlayProvider));
                    } else {
                        neVar.a(vectorOverlayProvider);
                    }
                } else if (vectorOverlayProvider instanceof GradientVectorOverlayProvider) {
                    nw nwVar = (nw) neVar.f149400m.a(nw.class, ((nw) vectorOverlay).b());
                    if (nwVar != null) {
                        nwVar.a((nw) new ny((GradientVectorOverlayProvider) vectorOverlayProvider));
                    } else {
                        neVar.a(vectorOverlayProvider);
                    }
                } else if (vectorOverlayProvider instanceof ArcLineOverlayProvider) {
                    nn nnVar = (nn) neVar.f149400m.a(nn.class, ((nn) vectorOverlay).b());
                    if (nnVar != null) {
                        nnVar.a((nn) new np((ArcLineOverlayProvider) vectorOverlayProvider));
                    } else {
                        neVar.a(vectorOverlayProvider);
                    }
                } else if (vectorOverlayProvider instanceof DotScatterPlotOverlayProvider) {
                    of ofVar = (of) neVar.f149400m.a(of.class, ((of) vectorOverlay).b());
                    if (ofVar != null) {
                        ofVar.a((of) new oh(neVar.f149396i.A(), (DotScatterPlotOverlayProvider) vectorOverlayProvider));
                    } else {
                        neVar.a(vectorOverlayProvider);
                    }
                } else if (vectorOverlayProvider instanceof BitmapScatterPlotOverlayProvider) {
                    of ofVar2 = (of) neVar.f149400m.a(of.class, ((of) vectorOverlay).b());
                    if (ofVar2 != null) {
                        ofVar2.a((of) new oh(neVar.f149396i.A(), (BitmapScatterPlotOverlayProvider) vectorOverlayProvider));
                    } else {
                        neVar.a(vectorOverlayProvider);
                    }
                } else if (vectorOverlayProvider instanceof TrailOverlayProvider) {
                    oi oiVar = (oi) neVar.f149400m.a(oi.class, ((oi) vectorOverlay).b());
                    if (oiVar != null) {
                        oiVar.a((oi) new ok((TrailOverlayProvider) vectorOverlayProvider));
                    } else {
                        neVar.a(vectorOverlayProvider);
                    }
                } else if (vectorOverlayProvider instanceof GLModelOverlayProvider) {
                    ns nsVar = (ns) neVar.f149400m.a(ns.class, ((ns) vectorOverlay).b());
                    if (nsVar != null) {
                        nsVar.a((ns) new nr((GLModelOverlayProvider) vectorOverlayProvider));
                    } else {
                        neVar.a(vectorOverlayProvider);
                    }
                }
            }
            o();
        }
    }

    public final float v() {
        return this.f151351o.f149398k.h();
    }

    public final float w() {
        return this.f151351o.f149398k.i();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public final fa getProjection() {
        ne neVar;
        if (!this.H && (neVar = this.f151351o) != null) {
            return neVar.f149403p;
        }
        return new x();
    }

    public final void y() {
        this.f151351o.f149398k.f147732o.e();
    }

    public final String z() {
        ne neVar = this.f151351o;
        if (neVar != null) {
            return neVar.F();
        }
        return null;
    }

    private void c(int i3) {
        this.f151351o.f149398k.a(i3);
    }

    private synchronized void e(fb fbVar) {
        this.f151351o.f149400m.a(fbVar);
        this.f151351o.f149412y = true;
    }

    private String g(GeoPoint geoPoint) {
        tk tkVar = this.f151351o.f149396i;
        if (tkVar != null) {
            return (String) tkVar.a(new tk.AnonymousClass165(geoPoint), (tk.AnonymousClass165) null);
        }
        return null;
    }

    private void l(boolean z16) {
        ae aeVar;
        ne neVar = this.f151351o;
        if (neVar == null || (aeVar = neVar.f149398k) == null) {
            return;
        }
        aeVar.M = z16;
    }

    @Override // com.tencent.mapsdk.internal.bn
    public final void a(Bundle bundle) {
        ne neVar;
        sj sjVar;
        super.a(bundle);
        sm.a().a(this.f151351o.getContext());
        bl.a().a(this.f151351o.L());
        bi biVar = new bi(this.f151351o, this.M.getMapRenderView(), this.f151351o.f147915b);
        this.f151353q = biVar;
        this.C = new ag(biVar);
        this.E = new ab(this.f151353q);
        this.L = new TencentMapPro(this.f151353q, this.C);
        this.f151356t = new py(this.f151351o);
        this.G = new af(this.f151353q.f147821d);
        bm.a aVar = new bm.a() { // from class: com.tencent.mapsdk.vector.VectorMap.1
            @Override // com.tencent.mapsdk.internal.bm.a
            public final void a() {
                VectorMap.this.setMyLocationEnabled(true);
                Location myLocation = VectorMap.this.getMyLocation();
                if (myLocation != null) {
                    VectorMap.this.animateCamera(CameraUpdateFactory.newLatLng(new LatLng(myLocation.getLatitude(), myLocation.getLongitude())));
                }
            }
        };
        bm bmVar = this.f151353q.f147821d;
        sl slVar = bmVar.f147894c;
        if (slVar != null) {
            slVar.f150310d = aVar;
        }
        ne neVar2 = this.f151351o;
        bk bkVar = neVar2.f149400m;
        TencentMapOptions tencentMapOptions = neVar2.f147915b;
        if (tencentMapOptions != null && tencentMapOptions.getExtSurface() != null && (sjVar = bmVar.f147895d) != null) {
            List<sj.c> list = sjVar.f150272r;
            if (list != null && bkVar != null) {
                list.add(bkVar);
            }
            int extSurfaceWidth = tencentMapOptions.getExtSurfaceWidth();
            int extSurfaceHeight = tencentMapOptions.getExtSurfaceHeight();
            ViewGroup ab5 = bmVar.f147893b.ab();
            if (ab5 != null) {
                ab5.measure(View.MeasureSpec.makeMeasureSpec(extSurfaceWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(extSurfaceHeight, 1073741824));
            }
            bmVar.b(extSurfaceWidth, extSurfaceHeight);
        }
        if (CustomLocationProvider.getInstance().hasLocationSource()) {
            setLocationSource(CustomLocationProvider.getInstance().getLocationSource());
            CustomLocationProvider.getInstance().requestLatestLocation();
        }
        qa qaVar = new qa(this.f151353q);
        this.f151354r = qaVar;
        ne neVar3 = this.f151351o;
        qaVar.f149735a.a((qa.a) neVar3.f149400m, neVar3.f147915b);
        Iterator<qa.b> it = this.f151357u.keySet().iterator();
        while (it.hasNext()) {
            this.f151354r.a(it.next());
        }
        this.f151357u.clear();
        qa qaVar2 = this.f151354r;
        lc.a(lb.Y, qaVar2.b());
        Iterator<AsyncTask> it5 = qaVar2.f149736b.iterator();
        while (it5.hasNext()) {
            it5.next().execute(new Object[0]);
        }
        tr trVar = qaVar2.f149737d;
        if (trVar != null && (neVar = trVar.aC) != null) {
            neVar.f147918e.s().a();
        }
        addOnMapLoadedCallback(this.f151351o.f147915b.getOnMapLoadedCallback());
        this.K = true;
    }

    private void b(float f16, float f17) {
        this.f151351o.f149398k.b(f16, f17, true);
    }

    private synchronized void d(fb fbVar) {
        this.f151351o.f149400m.a(fbVar);
        this.f151351o.f149412y = true;
    }

    private void h(int i3) {
        tk tkVar = this.f151351o.f149396i;
        if (tkVar != null) {
            tkVar.a(new tk.AnonymousClass108(i3));
        }
    }

    @Deprecated
    private void o(int i3) {
        ne neVar = this.f151351o;
        tk tkVar = neVar.f149396i;
        if (tkVar != null) {
            tkVar.d(i3);
            neVar.f149412y = true;
        }
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setCameraCenterProportion(float f16, float f17, boolean z16) {
        ab abVar;
        ak akVar;
        super.setCameraCenterProportion(f16, f17, z16);
        if (this.H || (abVar = this.E) == null || (akVar = abVar.f147684b) == null) {
            return;
        }
        akVar.a(f16, f17, z16);
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void animateCamera(CameraUpdate cameraUpdate, TencentMap.CancelableCallback cancelableCallback) {
        ab abVar;
        super.animateCamera(cameraUpdate, cancelableCallback);
        if (this.H || (abVar = this.E) == null || abVar.b()) {
            return;
        }
        this.E.a(cameraUpdate, 500L, cancelableCallback);
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setPadding(int i3, int i16, int i17, int i18, boolean z16) {
        super.setPadding(i3, i16, i17, i18, z16);
        bi biVar = this.f151353q;
        if (biVar != null) {
            biVar.a(i3, i16, i17, i18, z16);
        }
    }

    private void c(boolean z16) {
        if (z16) {
            ne neVar = this.f151351o;
            tk tkVar = neVar.f149396i;
            if (tkVar != null) {
                tkVar.l();
                neVar.f149406s = true;
                return;
            }
            return;
        }
        ne neVar2 = this.f151351o;
        tk tkVar2 = neVar2.f149396i;
        if (tkVar2 != null) {
            tkVar2.m();
            neVar2.f149406s = false;
        }
    }

    private void g(boolean z16) {
        this.f151351o.f149396i.g(z16);
    }

    private void i(int i3, int i16) {
        tk tkVar = this.f151351o.f149396i;
        if (tkVar != null) {
            tkVar.a(new tk.AnonymousClass26(i3, i16));
        }
    }

    private void j(boolean z16) {
        this.f151352p = z16;
        this.f151351o.j(z16);
    }

    @Deprecated
    private void p(int i3) {
        tk tkVar = this.f151351o.f149396i;
        if (tkVar != null) {
            tkVar.e(i3);
        }
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.map.sdk.comps.indoor.IIndoor
    public void setIndoorFloor(String str, String str2) {
        ab abVar;
        super.setIndoorFloor(str, str2);
        if (this.H || (abVar = this.E) == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        abVar.f147684b.a(str, str2);
    }

    private void b(fb fbVar) {
        this.f151351o.f149400m.a(fbVar);
        this.f151351o.f149412y = true;
    }

    private void f(GeoPoint geoPoint) {
        a(geoPoint, s());
    }

    private qr h(GeoPoint geoPoint) {
        tk tkVar = this.f151351o.f149396i;
        if (geoPoint == null) {
            geoPoint = new GeoPoint();
        }
        return (qr) tkVar.a(new tk.AnonymousClass162(geoPoint), (tk.AnonymousClass162) null);
    }

    private void f(int i3, int i16) {
        ne neVar = this.f151351o;
        if (neVar != null) {
            neVar.H = i3;
            neVar.G = i16;
        }
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void animateCamera(CameraUpdate cameraUpdate, long j3, TencentMap.CancelableCallback cancelableCallback) {
        ab abVar;
        super.animateCamera(cameraUpdate, j3, cancelableCallback);
        if (this.H || (abVar = this.E) == null || abVar.b()) {
            return;
        }
        this.E.a(cameraUpdate, j3, cancelableCallback);
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void snapshot(TencentMap.SnapshotReadyCallback snapshotReadyCallback, Bitmap.Config config) {
        super.snapshot(snapshotReadyCallback, config);
        snapshot(snapshotReadyCallback, config, 0);
    }

    private void e(int i3) {
        tk tkVar = this.f151351o.f149396i;
        if (tkVar != null) {
            tkVar.a(new tk.AnonymousClass169(i3));
        }
    }

    @Deprecated
    private void g(int i3, int i16) {
        tk tkVar = this.f151351o.f149396i;
        if (tkVar != null) {
            tkVar.b(i3, i16);
        }
    }

    private void i(boolean z16) {
        ae aeVar = this.f151351o.f149398k;
        aeVar.G = z16;
        aeVar.f147743z.g().b(aeVar.G);
    }

    private void d(GeoPoint geoPoint) {
        this.f151351o.f149398k.a(geoPoint.getLatitudeE6(), geoPoint.getLongitudeE6(), 1);
    }

    @Override // com.tencent.mapsdk.internal.bn, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void snapshot(TencentMap.SnapshotReadyCallback snapshotReadyCallback) {
        super.snapshot(snapshotReadyCallback);
        snapshot(snapshotReadyCallback, Bitmap.Config.ARGB_8888);
    }

    private void f(boolean z16) {
        this.f151351o.e(z16);
    }

    private void h(boolean z16) {
        this.f151351o.K.f150020f.j(z16);
    }

    private void b(fl flVar) {
        ae aeVar = this.f151351o.f149398k;
        synchronized (aeVar.f147734q) {
            aeVar.f147734q.remove(flVar);
        }
    }

    private void e(int i3, int i16) {
        tk tkVar = this.f151351o.f149396i;
        if (tkVar != null) {
            if (i16 < 0) {
                i16 = 0;
            }
            if (i16 > 255) {
                i16 = 255;
            }
            int i17 = 255 - i16;
            if (i17 == 0) {
                i17 = 1;
            }
            tkVar.a(new tk.AnonymousClass107(i3, i17));
        }
    }

    private int f(String str) {
        tk tkVar;
        ne neVar = this.f151351o;
        if (neVar == null || (tkVar = neVar.f149396i) == null) {
            return -1;
        }
        return ((Integer) tkVar.a((CallbackRunnable<tk.AnonymousClass47>) new tk.AnonymousClass47(str), (tk.AnonymousClass47) (-1))).intValue();
    }

    @Override // com.tencent.mapsdk.internal.bn
    public final void g() {
        ak akVar;
        super.g();
        if (this.H) {
            return;
        }
        ab abVar = this.E;
        if (abVar != null && (akVar = abVar.f147684b) != null) {
            akVar.m();
        }
        qa qaVar = this.f151354r;
        if (qaVar != null) {
            qaVar.a();
        }
        py pyVar = this.f151356t;
        if (pyVar != null) {
            pyVar.f149723c = null;
            pyVar.f149721a.clear();
            pyVar.f149724d.clear();
        }
        sm.a();
        af afVar = this.G;
        if (afVar != null) {
            if (afVar.f147771a != null) {
                afVar.f147771a = null;
            }
            this.G = null;
        }
        ad adVar = this.F;
        if (adVar != null) {
            aj ajVar = adVar.f147714a;
            if (ajVar != null) {
                ajVar.a();
                adVar.f147714a = null;
            }
            this.F = null;
        }
        ab abVar2 = this.E;
        if (abVar2 != null) {
            if (abVar2.f147684b != null) {
                abVar2.f147684b = null;
            }
            this.E = null;
        }
        if (this.D != null) {
            this.D = null;
        }
        ag agVar = this.C;
        if (agVar != null) {
            if (agVar.f147772a != null) {
                agVar.f147772a = null;
            }
            this.C = null;
        }
        bh bhVar = this.f151355s;
        if (bhVar != null) {
            bhVar.a();
            this.f151355s = null;
        }
        bi biVar = this.f151353q;
        if (biVar != null) {
            if (biVar.f147819b != null) {
                ((VectorMap) biVar.f147819b.e_).b(biVar.f147829l);
                biVar.f147819b.k();
                biVar.f147819b = null;
            }
            if (biVar.f147820c != null) {
                biVar.f147820c = null;
            }
            hn.a aVar = hn.f148686b;
            if (aVar != null) {
                aVar.c();
            }
            this.f151353q = null;
        }
        this.f151357u.clear();
        this.H = true;
    }

    private boolean i(GeoPoint geoPoint) {
        boolean z16;
        ae aeVar = this.f151351o.f149398k;
        if (geoPoint == null) {
            return true;
        }
        Rect r16 = aeVar.r();
        boolean contains = r16 != null ? r16.contains(geoPoint.getLongitudeE6(), geoPoint.getLatitudeE6()) : false;
        fw a16 = aeVar.B.a(aeVar.A.f151264m);
        fw a17 = aeVar.B.a(geoPoint);
        if (aeVar.C != null) {
            double abs = Math.abs(a16.f148383a - a17.f148383a);
            double abs2 = Math.abs(a16.f148384b - a17.f148384b);
            if (abs > aeVar.C.width() || abs2 > aeVar.C.height()) {
                z16 = false;
                return contains && !z16;
            }
        }
        z16 = true;
        if (contains) {
        }
    }

    private void c(fb fbVar) {
        this.f151351o.f149400m.a(fbVar);
        this.f151351o.f149412y = true;
    }

    private void d(int i3) {
        this.f151351o.f149398k.a(i3);
    }

    private void h(int i3, int i16) {
        this.f151351o.a(i3, i16);
    }

    private void e(boolean z16) {
        tk tkVar = this.f151351o.f149396i;
        if (0 != tkVar.f150515e) {
            tkVar.a(new tk.AnonymousClass173(z16));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0063, code lost:
    
        r4 = com.tencent.mapsdk.internal.pw.a(r3.getId(), r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean h(float f16, float f17) {
        py pyVar;
        SubPoi subPoi;
        px.d dVar;
        List<px.d> list;
        TappedElement a16 = a(f16, f17);
        if (a16 != null && (pyVar = this.f151356t) != null && pyVar.f149723c != null && a16.type == 4) {
            long j3 = a16.itemId;
            Iterator<pw> it = pyVar.f149721a.iterator();
            while (true) {
                subPoi = null;
                r4 = null;
                r4 = null;
                r4 = null;
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
                        if (((oc) next.f149670a.f149722b.f149400m.a(oc.class, next2.f149699a)) != null && r7.a() == j3) {
                            dVar2 = next2;
                            break;
                        }
                    }
                }
            }
            if (subPoi != null) {
                pyVar.f149723c.onClicked(subPoi);
                return true;
            }
        }
        return false;
    }

    private void b(fg fgVar) {
        ae aeVar = this.f151351o.f149398k;
        synchronized (aeVar.f147735r) {
            aeVar.f147735r.remove(fgVar);
        }
    }

    private void d(float f16) {
        this.N = f16;
        ne neVar = this.f151351o;
        if (neVar != null) {
            neVar.a(f16);
            if (this.P != 2 || ae()) {
                return;
            }
            b(this.N);
        }
    }

    @Override // com.tencent.mapsdk.internal.bn
    public final void f() {
        py pyVar;
        if (this.H || this.E == null || (pyVar = this.f151356t) == null) {
            return;
        }
        this.M.b(pyVar);
    }

    private void c(Rect rect, Rect rect2) {
        this.f151351o.f149398k.c(rect, rect2);
    }

    private void e(String str) {
        this.f151351o.b(str);
    }

    private void e(GeoPoint geoPoint) {
        boolean contains;
        if (geoPoint == null) {
            contains = false;
        } else {
            int latitudeE6 = geoPoint.getLatitudeE6();
            contains = GeometryConstants.BOUNDARY_WORLD.contains(geoPoint.getLongitudeE6(), latitudeE6);
        }
        if (contains) {
            this.f151351o.f149398k.a(geoPoint, (Runnable) null);
        }
    }

    private boolean f(float f16, float f17) {
        bk bkVar = this.f151351o.f149400m;
        TappedElement a16 = bkVar.f147877a.g().a(f16, f17);
        if (a16 == null || a16.type != 3) {
            return false;
        }
        fc fcVar = bkVar.f147880d;
        if (fcVar == null) {
            return true;
        }
        fcVar.o_();
        return true;
    }

    private void c(float f16, float f17) {
        this.f151351o.f149398k.a(f16, f17, true);
    }

    private void d(boolean z16) {
        tk tkVar = this.f151351o.f149396i;
        if (tkVar == null || tkVar.f150515e == 0) {
            return;
        }
        tkVar.a(new tk.AnonymousClass168(z16));
    }

    public final void b(fs fsVar) {
        this.f151351o.f149398k.b(fsVar);
    }

    private void b(fi fiVar) {
        ae aeVar = this.f151351o.f149398k;
        if (aeVar.f147736s != null) {
            synchronized (aeVar.f147737t) {
                aeVar.f147736s.remove(fiVar);
            }
        }
    }

    public final void c(float f16) {
        this.f151351o.f149398k.a(f16);
    }

    private void d(float f16, float f17) {
        ne neVar = this.f151351o;
        if (neVar != null) {
            ae aeVar = neVar.f149398k;
            aeVar.E = f16;
            aeVar.F = f17;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x00d9, code lost:
    
        r5 = com.tencent.mapsdk.internal.pw.a(r4.getId(), r5);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ee A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean e(float f16, float f17) {
        byte b16;
        boolean z16;
        byte b17;
        py pyVar;
        SubPoi subPoi;
        px.d dVar;
        List<px.d> list;
        WeakReference<TencentMap.OnMyLocationClickListener> weakReference;
        TencentMap.OnMyLocationClickListener onMyLocationClickListener;
        bk bkVar = this.f151351o.f149400m;
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
            bh bhVar = this.f151355s;
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
                TappedElement a18 = a(f16, f17);
                if (a18 != null && (pyVar = this.f151356t) != null && pyVar.f149723c != null && a18.type == 4) {
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

    private static float f(int i3) {
        return v.a.a(i3);
    }

    private void k(boolean z16) {
        ae aeVar;
        ne neVar = this.f151351o;
        if (neVar == null || (aeVar = neVar.f149398k) == null) {
            return;
        }
        aeVar.L = z16;
    }

    private static void J() {
    }

    private void c(float f16, float f17, boolean z16) {
        ae aeVar = this.f151351o.f149398k;
        aeVar.N = true;
        aeVar.a(f16, f17, z16);
    }

    private void d(String str) {
        this.f151351o.a(str);
    }

    public final void b(float f16) {
        this.f151351o.f149398k.b(f16);
    }

    @Override // com.tencent.mapsdk.internal.bn
    public final void d() {
        ab abVar;
        if (this.H || (abVar = this.E) == null) {
            return;
        }
        ak akVar = abVar.f147684b;
        if (akVar != null) {
            akVar.n();
        }
        this.I = true;
    }

    private void c(double d16) {
        this.f151351o.f149398k.a((float) d16);
    }

    public final void b(boolean z16) {
        this.f151351o.a(z16);
    }

    private boolean b(String str, byte[] bArr) {
        oq oqVar;
        w wVar = this.f151351o.f149408u;
        if (wVar == null || (oqVar = wVar.f151302b) == null) {
            return false;
        }
        return w.a(new File(oqVar.e()), str, bArr, wVar.f151305e);
    }

    public final void c(int i3, int i16) {
        this.f151351o.b(i3, i16);
    }

    private void c(String str) {
        tk tkVar = this.f151351o.f149396i;
        if (tkVar == null || 0 == tkVar.f150515e) {
            return;
        }
        tkVar.a(new tk.AnonymousClass151(str));
    }

    @Override // com.tencent.mapsdk.internal.bn
    public final void c() {
        ab abVar;
        if (this.H || (abVar = this.E) == null) {
            return;
        }
        ak akVar = abVar.f147684b;
        if (akVar != null) {
            akVar.j();
        }
        this.I = false;
    }

    private void b(fm fmVar) {
        ae aeVar = this.f151351o.f149398k;
        synchronized (aeVar.f147741x) {
            aeVar.f147741x.remove(fmVar);
        }
    }

    private void b(fq fqVar) {
        this.f151351o.f149398k.b(fqVar);
    }

    private void b(fo foVar) {
        this.f151351o.f149398k.b(foVar);
    }

    private void b(fn fnVar) {
        ae aeVar = this.f151351o.f149398k;
        synchronized (aeVar.f147738u) {
            aeVar.f147738u.remove(fnVar);
        }
    }

    @Override // com.tencent.mapsdk.internal.bn
    public final boolean a() {
        return (!this.K || this.I || this.H) ? false : true;
    }

    private static boolean a(GeoPoint geoPoint) {
        if (geoPoint == null) {
            return false;
        }
        int latitudeE6 = geoPoint.getLatitudeE6();
        return GeometryConstants.BOUNDARY_WORLD.contains(geoPoint.getLongitudeE6(), latitudeE6);
    }

    private void b(ph phVar) {
        this.f151351o.f149398k.b(phVar);
    }

    private void a(oq oqVar) {
        ne neVar = this.f151351o;
        if (neVar != null) {
            neVar.a(oqVar);
        }
    }

    private void b(ft ftVar) {
        this.f151351o.f149398k.b(ftVar);
    }

    private boolean g(float f16, float f17) {
        WeakReference<TencentMap.OnMyLocationClickListener> weakReference;
        TencentMap.OnMyLocationClickListener onMyLocationClickListener;
        bh bhVar = this.f151355s;
        boolean z16 = false;
        if (bhVar != null) {
            TappedElement a16 = bhVar.f147806j.f149400m.f147877a.g().a(f16, f17);
            if (a16 != null && a16.type == 6) {
                z16 = true;
            }
            if (z16 && (weakReference = bhVar.f147802f) != null && (onMyLocationClickListener = weakReference.get()) != null) {
                LatLng latLng = new LatLng();
                Location location = bhVar.f147805i;
                if (location != null) {
                    latLng.setAltitude(location.getAltitude());
                    latLng.setLongitude(bhVar.f147805i.getLongitude());
                    latLng.setLatitude(bhVar.f147805i.getLatitude());
                }
                return onMyLocationClickListener.onMyLocationClicked(latLng);
            }
        }
        return z16;
    }

    private void a(float f16, float f17, boolean z16) {
        this.f151351o.f149398k.b(f16, f17, z16);
    }

    private void b(rt rtVar) {
        List<rt> list;
        rw rwVar = this.f151351o.f149399l;
        if (rwVar == null || rtVar == null || (list = rwVar.f150154b.f150144a) == null) {
            return;
        }
        list.remove(rtVar);
    }

    private boolean a(String str) {
        tk tkVar = this.f151351o.f149396i;
        if (tkVar == null) {
            return false;
        }
        return ((Boolean) tkVar.a((CallbackRunnable<tk.AnonymousClass112>) new tk.AnonymousClass112(str), (tk.AnonymousClass112) Boolean.FALSE)).booleanValue();
    }

    private void a(fb fbVar) {
        this.f151351o.f149400m.a(fbVar);
        this.f151351o.f149412y = true;
    }

    private void b(PolygonInfo polygonInfo) {
        this.f151351o.b(polygonInfo);
    }

    private void b(Rect rect, Rect rect2) {
        this.f151351o.f149398k.b(rect, rect2);
    }

    private void b(GeoPoint geoPoint, Runnable runnable) {
        this.f151351o.f149398k.a(geoPoint, runnable);
    }

    private void a(fl flVar) {
        ae aeVar = this.f151351o.f149398k;
        if (flVar != null) {
            synchronized (aeVar.f147734q) {
                if (!aeVar.f147734q.contains(flVar)) {
                    aeVar.f147734q.add(flVar);
                }
            }
        }
    }

    private void b(float f16, float f17, boolean z16) {
        this.f151351o.f149398k.a(f16, f17, z16);
    }

    private void b(Rect rect) {
        this.f151351o.f149398k.b(rect);
    }

    private void a(fg fgVar) {
        ae aeVar = this.f151351o.f149398k;
        if (fgVar != null) {
            synchronized (aeVar.f147735r) {
                if (!aeVar.f147735r.contains(fgVar)) {
                    aeVar.f147735r.add(fgVar);
                }
            }
        }
    }

    private void b(double d16) {
        this.f151351o.f149398k.a((360.0d - d16) % 360.0d, r1.i(), true);
    }

    private void b(fd fdVar) {
        bb bbVar;
        ne neVar = this.f151351o;
        if (neVar == null || (bbVar = neVar.f149402o) == null) {
            return;
        }
        bbVar.b(fdVar);
    }

    public final void a(fs fsVar) {
        this.f151351o.f149398k.a(fsVar);
    }

    private void b(String str) {
        this.f151351o.f149396i.b(str);
    }

    private void a(fi fiVar) {
        ae aeVar = this.f151351o.f149398k;
        if (fiVar != null) {
            if (aeVar.f147736s == null) {
                aeVar.f147736s = new ArrayList();
            }
            synchronized (aeVar.f147737t) {
                if (!aeVar.f147736s.contains(fiVar)) {
                    aeVar.f147736s.add(fiVar);
                }
            }
        }
    }

    public final void b(int i3) {
        this.f151351o.b(i3);
    }

    public final void b(int i3, int i16) {
        this.f151351o.f149398k.a(i3, i16);
    }

    private void b(bc bcVar) {
        ae aeVar = this.f151351o.f149398k;
        if (aeVar.f147739v != null) {
            synchronized (aeVar.f147740w) {
                aeVar.f147739v.remove(bcVar);
            }
        }
    }

    public final void a(int i3, int i16) {
        this.f151351o.f149398k.a(i3, i16, 1);
    }

    public final void a(float f16) {
        this.f151351o.f149398k.a(f16);
    }

    private void b(int i3, float f16) {
        tk tkVar = this.f151351o.f149396i;
        if (tkVar != null) {
            tkVar.a(i3, f16);
        }
    }

    public final void a(double d16) {
        this.f151351o.f149398k.c(d16);
    }

    private void b(fk fkVar) {
        this.f151351o.b(fkVar);
    }

    private void b(oz ozVar) {
        this.f151351o.b(ozVar);
    }

    private boolean a(String str, byte[] bArr) {
        oq oqVar;
        w wVar = this.f151351o.f149408u;
        if (wVar == null || (oqVar = wVar.f151302b) == null) {
            return false;
        }
        return w.a(new File(oqVar.c()), str, bArr, wVar.f151304d);
    }

    @Override // com.tencent.mapsdk.internal.bn
    public final void b() {
        py pyVar;
        if (this.H || this.E == null || (pyVar = this.f151356t) == null) {
            return;
        }
        this.M.a(pyVar);
    }

    private void b(qa.b bVar) {
        if (bVar == null) {
            return;
        }
        qa qaVar = this.f151354r;
        if (qaVar != null) {
            qaVar.b(bVar);
        } else {
            this.f151357u.remove(bVar);
        }
    }

    private void a(fm fmVar) {
        ae aeVar = this.f151351o.f149398k;
        if (fmVar != null) {
            synchronized (aeVar.f147741x) {
                if (!aeVar.f147741x.contains(fmVar)) {
                    aeVar.f147741x.add(fmVar);
                }
            }
        }
    }

    private void a(fq fqVar) {
        this.f151351o.f149398k.a(fqVar);
    }

    public final void a(fo foVar) {
        this.f151351o.f149398k.a(foVar);
    }

    private void a(fn fnVar) {
        ae aeVar = this.f151351o.f149398k;
        if (fnVar != null) {
            synchronized (aeVar.f147738u) {
                if (!aeVar.f147738u.contains(fnVar)) {
                    aeVar.f147738u.add(fnVar);
                }
            }
        }
    }

    public final void a(ft ftVar) {
        this.f151351o.f149398k.a(ftVar);
    }

    private void a(ph phVar) {
        this.f151351o.f149398k.a(phVar);
    }

    public final void a(fc fcVar) {
        this.f151351o.f149400m.f147880d = fcVar;
    }

    private void a(fb fbVar, int i3, int i16, fr frVar) {
        ne neVar = this.f151351o;
        Rect bound = fbVar.getBound(neVar.f149403p);
        if (bound == null || i3 <= 0 || i16 <= 0 || frVar == null) {
            return;
        }
        neVar.f149409v.a(fbVar, bound, frVar, i3, i16);
    }

    private void a(Rect rect, int i3, int i16, fr frVar) {
        ne neVar = this.f151351o;
        if (rect == null) {
            rect = neVar.f149398k.q();
        }
        Rect rect2 = rect;
        if (rect2 == null || i3 <= 0 || i16 <= 0 || frVar == null) {
            return;
        }
        neVar.f149409v.a(null, rect2, frVar, i3, i16);
    }

    private ix a(int i3, Object obj, Object obj2) {
        ae aeVar = this.f151351o.f149398k;
        if (i3 == 0) {
            return jh.a((iu) aeVar, 0, 1);
        }
        if (i3 == 1) {
            return jh.a((iu) aeVar, (jl) new il(), new Object[]{obj, obj2});
        }
        if (i3 == 2) {
            return jh.a(aeVar, 3, Math.log10(((Number) obj).doubleValue()) / Math.log10(2.0d), Math.log10(((Number) obj2).doubleValue()) / Math.log10(2.0d));
        }
        if (i3 == 3) {
            return jh.a(aeVar, 2, aeVar.h(), (((Number) obj2).doubleValue() - ((Number) obj).doubleValue()) + aeVar.h());
        }
        if (i3 != 4) {
            return null;
        }
        return jh.a(aeVar, 4, aeVar.i(), (((Number) obj2).doubleValue() - ((Number) obj).doubleValue()) + aeVar.i());
    }

    private double a(Rect rect, Rect rect2) {
        Rect rect3 = new Rect(this.f151351o.f149398k.f147743z.h());
        if (rect2 != null) {
            rect3.left += rect2.left;
            rect3.right -= rect2.right;
            rect3.top += rect2.top;
            rect3.bottom -= rect2.bottom;
        }
        return r0.a(rect, rect3);
    }

    private void a(rt rtVar) {
        List<rt> list;
        rw rwVar = this.f151351o.f149399l;
        if (rwVar == null || rtVar == null || (list = rwVar.f150154b.f150144a) == null) {
            return;
        }
        list.add(rtVar);
    }

    private int a(PolygonInfo polygonInfo) {
        return this.f151351o.a(polygonInfo);
    }

    private int a(int i3, int i16, int i17, int i18, int i19, float f16) {
        ne neVar = this.f151351o;
        if (neVar.f149396i == null) {
            return -1;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        if (i3 > 255) {
            i3 = 255;
        }
        if (i16 < 0) {
            i16 = 0;
        }
        if (i16 > 255) {
            i16 = 255;
        }
        if (i17 < 0) {
            i17 = 0;
        }
        if (i17 > 255) {
            i17 = 255;
        }
        if (i18 < 0) {
            i18 = 0;
        }
        if (i18 > 255) {
            i18 = 255;
        }
        MaskLayer maskLayer = new MaskLayer();
        maskLayer.color = new int[]{i3, i16, i17, 255 - i18};
        Rect rect = neVar.f149405r;
        if (rect != null) {
            maskLayer.width = rect.width();
            maskLayer.height = neVar.f149405r.height();
        }
        maskLayer.zIndex = f16;
        maskLayer.layer = i19;
        tk tkVar = neVar.f149396i;
        return ((Integer) tkVar.a((CallbackRunnable<tk.AnonymousClass106>) new tk.AnonymousClass106(maskLayer), (tk.AnonymousClass106) 0)).intValue();
    }

    private void a(List<MapRouteSection> list, List<GeoPoint> list2) {
        ne neVar = this.f151351o;
        if (neVar.C == null) {
            neVar.C = new ne.d();
        }
        ne.d dVar = neVar.C;
        dVar.f149425a = list;
        dVar.f149426b = list2;
        ne.this.f149396i.a(list, list2);
    }

    private List<Integer> a(Rect rect, int i3) {
        tk tkVar = this.f151351o.f149396i;
        return (List) tkVar.a(new tk.AnonymousClass31(rect, i3), (tk.AnonymousClass31) null);
    }

    private AnnocationTextResult a(AnnocationText annocationText) {
        tk tkVar = this.f151351o.f149396i;
        return (AnnocationTextResult) tkVar.a(new tk.AnonymousClass30(annocationText), (tk.AnonymousClass30) null);
    }

    private void a(int i3, float f16) {
        ae aeVar = this.f151351o.f149398k;
        aeVar.a(i3, (Runnable) new ae.AnonymousClass5(f16));
    }

    private void a(GeoPoint geoPoint, Runnable runnable) {
        ae aeVar = this.f151351o.f149398k;
        if (geoPoint != null) {
            aeVar.a(geoPoint, aeVar.A.f151253b.f151291q, runnable);
        }
    }

    private void a(GeoPoint geoPoint, int i3) {
        this.f151351o.f149398k.a(geoPoint, i3, (Runnable) null);
    }

    private void a(GeoPoint geoPoint, int i3, Runnable runnable) {
        this.f151351o.f149398k.a(geoPoint, i3, runnable);
    }

    private void a(GeoPoint geoPoint, float f16, Runnable runnable) {
        int i3;
        ae aeVar = this.f151351o.f149398k;
        if (geoPoint != null) {
            aeVar.f147732o.e();
            double d16 = aeVar.A.f151253b.f151290p;
            double d17 = f16;
            double d18 = d17 / d16;
            if (d18 > 1.0d) {
                i3 = (int) (d18 / 0.5d);
            } else {
                if (d18 >= 1.0d) {
                    aeVar.b(geoPoint, runnable);
                    return;
                }
                i3 = d18 != 1.0d ? (int) (0.5d / d18) : 0;
            }
            int max = Math.max(60, Math.min(120, (i3 >> 1) << 1));
            double log10 = Math.log10(d16) / Math.log10(2.0d);
            double log102 = Math.log10(d17) / Math.log10(2.0d);
            GeoPoint geoPoint2 = aeVar.A.f151264m;
            int i16 = 0;
            while (i16 < max) {
                long j3 = max;
                int i17 = i16 + 1;
                long j16 = i17;
                double d19 = log10;
                double d26 = log102;
                double pow = Math.pow(2.0d, mo.a(log10, log102, j3, j16));
                double a16 = mo.a(geoPoint2.getLatitudeE6(), geoPoint.getLatitudeE6(), j3, j16);
                double a17 = mo.a(geoPoint2.getLongitudeE6(), geoPoint.getLongitudeE6(), j3, j16);
                LogUtil.b("debug location anim zoomOut:" + a16 + "," + a17);
                aeVar.b(new jn(120, new double[]{pow, a16, a17}));
                log10 = d19;
                log102 = d26;
                i16 = i17;
            }
            if (runnable != null) {
                aeVar.b(new jn(runnable));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003f, code lost:
    
        if (r2 > r11) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(GeoPoint geoPoint, Rect rect) {
        double d16;
        double d17;
        int i3;
        ae aeVar = this.f151351o.f149398k;
        fa faVar = aeVar.B;
        fw a16 = faVar.a(geoPoint);
        if (rect.contains((int) a16.f148383a, (int) a16.f148384b)) {
            return;
        }
        double d18 = a16.f148383a;
        int i16 = rect.left;
        double d19 = 0.0d;
        if (d18 >= i16) {
            i16 = rect.right;
            if (d18 <= i16) {
                d16 = 0.0d;
                d17 = a16.f148384b;
                i3 = rect.top;
                if (d17 >= i3) {
                    i3 = rect.bottom;
                }
                d19 = i3 - d17;
                fw a17 = faVar.a(aeVar.A.f151264m);
                a17.f148383a -= d16;
                a17.f148384b -= d19;
                aeVar.a(faVar.a(a17), (Runnable) null);
            }
        }
        d16 = i16 - d18;
        d17 = a16.f148384b;
        i3 = rect.top;
        if (d17 >= i3) {
        }
        d19 = i3 - d17;
        fw a172 = faVar.a(aeVar.A.f151264m);
        a172.f148383a -= d16;
        a172.f148384b -= d19;
        aeVar.a(faVar.a(a172), (Runnable) null);
    }

    public final void a(jn jnVar) {
        this.f151351o.f149398k.b(jnVar);
    }

    private void a(Rect rect) {
        this.f151351o.f149398k.a(rect);
    }

    private int a(int i3, int i16, int i17, int i18, boolean z16) {
        ae aeVar = this.f151351o.f149398k;
        aeVar.H = i3;
        aeVar.I = i16;
        aeVar.J = i17;
        aeVar.K = i18;
        Rect rect = aeVar.C;
        if (rect != null && rect.width() > 0 && aeVar.C.height() > 0) {
            if (i3 + i17 > aeVar.C.width() || i16 + i18 > aeVar.C.height()) {
                return -1;
            }
            PointF a16 = aeVar.a();
            aeVar.a(a16.x, a16.y, z16);
            return 0;
        }
        aeVar.a(new ae.AnonymousClass1(z16));
        bf bfVar = aeVar.f147743z;
        if (!(bfVar instanceof ne)) {
            return -2;
        }
        Context context = ((ne) bfVar).getContext();
        return (i3 + i17 > ht.b(context) || i16 + i18 > ht.c(context)) ? -1 : 0;
    }

    private void a(double d16, double d17) {
        aa aaVar = this.f151351o.f149398k.f147732o;
        synchronized (aaVar.f147670c) {
            while (!aaVar.f147669b.isEmpty()) {
                ArrayList<jn> arrayList = aaVar.f147669b;
                if (arrayList.get(arrayList.size() - 1).f148935z != 3) {
                    break;
                }
                ArrayList<jn> arrayList2 = aaVar.f147669b;
                double[] dArr = arrayList2.remove(arrayList2.size() - 1).A;
                d16 += dArr[0];
                d17 += dArr[1];
            }
            aaVar.a(new jn(3, new double[]{d16, d17}));
        }
    }

    public final void a(qm qmVar) {
        ae aeVar = this.f151351o.f149398k;
        if (aeVar.f147733p == null) {
            aeVar.f147733p = aeVar.f147742y.M();
        }
        qj qjVar = aeVar.f147733p;
        qjVar.f149828b = qmVar;
        boolean a16 = qmVar.a();
        bb bbVar = qjVar.f149830d;
        if (bbVar != null) {
            if (a16) {
                bbVar.b(qjVar);
            } else {
                bbVar.a(qjVar);
            }
        }
    }

    private void a(fd fdVar) {
        bb bbVar;
        ne neVar = this.f151351o;
        if (neVar == null || (bbVar = neVar.f149402o) == null) {
            return;
        }
        bbVar.a(fdVar);
    }

    private void a(GeoPoint geoPoint, float f16, float f17, boolean z16) {
        this.N = f16;
        this.O.setLatitudeE6(geoPoint.getLatitudeE6());
        this.O.setLongitudeE6(geoPoint.getLongitudeE6());
        ne neVar = this.f151351o;
        if (neVar != null) {
            neVar.a(this.O, this.N, f17, z16);
            int i3 = this.P;
            if (i3 == 1 || i3 == 2) {
                a(this.O, s());
            }
            if (this.P != 2 || ae()) {
                return;
            }
            b(this.N);
        }
    }

    private void a(GeoPoint geoPoint, RectF rectF, boolean z16) {
        ne neVar;
        Rect rect;
        ne neVar2 = this.f151351o;
        if (neVar2 != null) {
            if (rectF != null && (rect = neVar2.F) != null) {
                rectF.left -= rect.left;
                rectF.top -= rect.top;
                rectF.right -= rect.right;
                rectF.bottom -= rect.bottom;
            }
            tk tkVar = neVar2.f149396i;
            if (tkVar != null) {
                int i3 = neVar2.H;
                int i16 = neVar2.G;
                if (0 == tkVar.f150515e || (neVar = tkVar.f150520j) == null) {
                    return;
                }
                neVar.a(new tk.AnonymousClass4(rectF, geoPoint, i3, i16, z16));
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.bn
    public final void a(int i3) {
        super.a(i3);
        if (this.H || this.f151351o == null) {
            return;
        }
        LogUtil.b(ky.f149101g, "setIndoorConfigType:".concat(String.valueOf(i3)));
        tk tkVar = this.f151351o.f149396i;
        tkVar.a(new tk.AnonymousClass157(i3));
    }

    private void a(float f16, float f17, float f18, float f19) {
        tk tkVar = this.f151351o.f149396i;
        if (0 != tkVar.f150515e) {
            tkVar.a(new tk.AnonymousClass167(f16, f17, f18, f19));
        }
    }

    public final void a(String[] strArr) {
        this.f151351o.a(strArr);
    }

    private void a(ox oxVar) {
        this.f151351o.a(oxVar);
    }

    private void a(ae.a aVar) {
        this.f151351o.f149398k.D = aVar;
    }

    private void a(int i3, int i16, int i17, int i18) {
        tk tkVar;
        ne neVar = this.f151351o;
        if (neVar == null || (tkVar = neVar.f149396i) == null) {
            return;
        }
        tkVar.a(new tk.AnonymousClass23(i16, i3, i17, i18));
    }

    private void a(double d16, double d17, double d18, double d19, double d26) {
        this.f151351o.f149398k.a(d16, d17, d18, d19, d26, null);
    }

    public final void a(bc bcVar) {
        this.f151351o.f149398k.a(bcVar);
    }

    @Deprecated
    private int a(TileOverlayCallback tileOverlayCallback, boolean z16, boolean z17) {
        tk tkVar = this.f151351o.f149396i;
        if (tkVar != null) {
            return tkVar.a(tileOverlayCallback, z16, z17);
        }
        return -1;
    }

    @Deprecated
    private void a(int i3, int i16, int i17) {
        tk tkVar = this.f151351o.f149396i;
        if (tkVar != null) {
            tkVar.a(i3, i16, i17);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x010f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(GeoPoint geoPoint, iw iwVar) {
        boolean z16;
        int i3;
        float f16;
        ae aeVar = this.f151351o.f149398k;
        Rect r16 = aeVar.r();
        int i16 = 0;
        boolean contains = r16 != null ? r16.contains(geoPoint.getLongitudeE6(), geoPoint.getLatitudeE6()) : false;
        ae.AnonymousClass6 anonymousClass6 = new ae.AnonymousClass6(iwVar);
        v vVar = aeVar.A;
        float f17 = vVar.f151253b.f151290p;
        if (!contains) {
            GeoPoint geoPoint2 = vVar.f151264m;
            fw a16 = aeVar.B.a(geoPoint2);
            fw a17 = aeVar.B.a(geoPoint);
            if (aeVar.C != null) {
                double abs = Math.abs(a16.f148383a - a17.f148383a);
                double abs2 = Math.abs(a16.f148384b - a17.f148384b);
                if (abs > aeVar.C.width() || abs2 > aeVar.C.height()) {
                    z16 = false;
                    if (z16) {
                        Rect rect = aeVar.C;
                        if (rect != null) {
                            i16 = rect.width();
                            i3 = aeVar.C.height();
                        } else {
                            i3 = 0;
                        }
                        if (i16 == 0 || i3 == 0 || geoPoint2 == null || geoPoint == null) {
                            f16 = 1.0f;
                        } else {
                            fw a18 = ae.a(geoPoint2);
                            fw a19 = ae.a(geoPoint);
                            double d16 = a19.f148383a - a18.f148383a;
                            if (d16 < 0.0d) {
                                d16 = Math.abs(d16);
                            }
                            double d17 = d16;
                            double d18 = a19.f148384b - a18.f148384b;
                            if (d18 < 0.0d) {
                                d18 = Math.abs(d18);
                            }
                            double d19 = d17 * 1.0d;
                            double d26 = d18 * 1.0d;
                            int i17 = (i16 - aeVar.H) - aeVar.J;
                            int i18 = (i3 - aeVar.I) - aeVar.K;
                            if (i17 <= 0) {
                                i17 = 1;
                            }
                            if (i18 <= 0) {
                                i18 = 1;
                            }
                            f16 = (float) (20.0d - Math.max(Math.log(d19 / i17) / Math.log(2.0d), Math.log(d26 / i18) / Math.log(2.0d)));
                            if (aeVar.A != null) {
                                f16 = v.a.a((int) f16);
                            }
                        }
                        aeVar.b(new GeoPoint((geoPoint.getLatitudeE6() + geoPoint2.getLatitudeE6()) / 2, (geoPoint.getLongitudeE6() + geoPoint2.getLongitudeE6()) / 2), f16, new ae.AnonymousClass7(geoPoint, f17, anonymousClass6));
                        return;
                    }
                    aeVar.b(geoPoint, anonymousClass6);
                    return;
                }
            }
            z16 = true;
            if (z16) {
            }
        } else {
            aeVar.b(geoPoint, anonymousClass6);
        }
    }

    private float a(double d16, GeoPoint geoPoint) {
        fa faVar;
        ne neVar = this.f151351o;
        if (geoPoint != null && neVar.f149410w != null && (faVar = neVar.f149403p) != null) {
            double metersPerPixel = faVar.metersPerPixel(geoPoint.getLatitudeE6() / 1000000.0d);
            if (metersPerPixel != 0.0d) {
                return (float) (d16 / metersPerPixel);
            }
        }
        return 0.0f;
    }

    private void a(fk fkVar) {
        this.f151351o.a(fkVar);
    }

    public final void a(oz ozVar) {
        this.f151351o.a(ozVar);
    }

    public final TappedElement a(float f16, float f17) {
        return this.f151351o.a(f16, f17);
    }

    @Override // com.tencent.mapsdk.internal.bn
    public final void a(boolean z16) {
        bi biVar;
        if (this.H || (biVar = this.f151353q) == null) {
            return;
        }
        biVar.f147818a.setZOrderMediaOverlay(z16);
    }

    private void a(pb pbVar) {
        ne neVar = this.f151351o;
        if (neVar == null) {
            return;
        }
        neVar.J = pbVar;
    }

    private void a(LatLngBounds latLngBounds, int i3) {
        ne neVar = this.f151351o;
        if (neVar == null) {
            return;
        }
        neVar.a(latLngBounds, i3);
    }

    public final void a(qa.b bVar) {
        if (bVar == null) {
            return;
        }
        qa qaVar = this.f151354r;
        if (qaVar != null) {
            qaVar.a(bVar);
        } else {
            this.f151357u.put(bVar, Boolean.TRUE);
        }
    }
}
