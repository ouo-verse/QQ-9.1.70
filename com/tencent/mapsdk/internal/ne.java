package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import android.view.WindowManager;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.map.lib.callbacks.TileOverlayCallback;
import com.tencent.map.lib.models.AnnocationText;
import com.tencent.map.lib.models.AnnocationTextResult;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.map.lib.models.IndoorCellInfo;
import com.tencent.map.lib.models.MaskLayer;
import com.tencent.map.lib.models.PolygonInfo;
import com.tencent.map.lib.models.SubMarkerInfo;
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
import com.tencent.mapsdk.internal.lb;
import com.tencent.mapsdk.internal.tk;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import com.tencent.tencentmap.mapsdk.maps.CustomRender;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMapComponent;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.maps.VisualSettings;
import com.tencent.tencentmap.mapsdk.maps.model.Circle;
import com.tencent.tencentmap.mapsdk.maps.model.CircleOptions;
import com.tencent.tencentmap.mapsdk.maps.model.GroundOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.GroundOverlayOptions;
import com.tencent.tencentmap.mapsdk.maps.model.IntersectionOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.IntersectionOverlayOptions;
import com.tencent.tencentmap.mapsdk.maps.model.Language;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import com.tencent.tencentmap.mapsdk.maps.model.MapPoi;
import com.tencent.tencentmap.mapsdk.maps.model.MapRouteSection;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import com.tencent.tencentmap.mapsdk.maps.model.OverSeaTileProvider;
import com.tencent.tencentmap.mapsdk.maps.model.Polyline;
import com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions;
import com.tencent.tencentmap.mapsdk.maps.model.TrafficStyle;
import com.tencent.tencentmap.mapsdk.maps.model.VectorHeatOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.VectorHeatOverlayOptions;
import com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider;
import java.io.File;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class ne extends bt implements bf, fq {
    private static final int Q = 50;
    private static final int R = 6;
    private static final int T = 100;
    private static final int U = 100;
    private static final float V = 2.0f;
    public om A;
    public c B;
    public d C;
    public sa D;
    public boolean E;
    public Rect F;
    public int G;
    public int H;
    public CustomRender I;
    public pb J;
    public final re K;
    public final List<oz> L;
    public final bj M;
    public int N;
    public TencentMap.OnVectorOverlayClickListener O;
    public fd P;
    private final int S;
    private final LinkedBlockingQueue<a> W;
    private oq X;
    private lm<Integer, Integer> Y;
    private lm<Integer, List<Integer>> Z;

    /* renamed from: aa, reason: collision with root package name */
    private boolean f149385aa;

    /* renamed from: ab, reason: collision with root package name */
    private boolean f149386ab;

    /* renamed from: ac, reason: collision with root package name */
    private int f149387ac;

    /* renamed from: ad, reason: collision with root package name */
    private int f149388ad;

    /* renamed from: ae, reason: collision with root package name */
    private float f149389ae;

    /* renamed from: af, reason: collision with root package name */
    private float f149390af;

    /* renamed from: ag, reason: collision with root package name */
    private boolean f149391ag;

    /* renamed from: ah, reason: collision with root package name */
    private Rect f149392ah;

    /* renamed from: ai, reason: collision with root package name */
    private boolean f149393ai;

    /* renamed from: aj, reason: collision with root package name */
    private int f149394aj;

    /* renamed from: ak, reason: collision with root package name */
    private String f149395ak;

    /* renamed from: i, reason: collision with root package name */
    public final tk f149396i;

    /* renamed from: j, reason: collision with root package name */
    public final mp f149397j;

    /* renamed from: k, reason: collision with root package name */
    public final ae f149398k;

    /* renamed from: l, reason: collision with root package name */
    public rw f149399l;

    /* renamed from: m, reason: collision with root package name */
    public final bk f149400m;

    /* renamed from: n, reason: collision with root package name */
    public final nd f149401n;

    /* renamed from: o, reason: collision with root package name */
    public final bb f149402o;

    /* renamed from: p, reason: collision with root package name */
    public final fa f149403p;

    /* renamed from: q, reason: collision with root package name */
    public final VisualSettings f149404q;

    /* renamed from: r, reason: collision with root package name */
    public final Rect f149405r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f149406s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f149407t;

    /* renamed from: u, reason: collision with root package name */
    public w f149408u;

    /* renamed from: v, reason: collision with root package name */
    public final f f149409v;

    /* renamed from: w, reason: collision with root package name */
    public final v f149410w;

    /* renamed from: x, reason: collision with root package name */
    public ol f149411x;

    /* renamed from: y, reason: collision with root package name */
    public volatile boolean f149412y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f149413z;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface a {
        void a(GL10 gl10);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public enum b {
        UnderMainMap(2),
        Under3DBuiding(4),
        UnderHandDraw(6),
        UnderPoi(8),
        UnderToplayer(10),
        AboveToplayer(12);


        /* renamed from: g, reason: collision with root package name */
        public int f149422g;

        b(int i3) {
            this.f149422g = i3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class d implements fk {

        /* renamed from: a, reason: collision with root package name */
        public List<MapRouteSection> f149425a;

        /* renamed from: b, reason: collision with root package name */
        public List<GeoPoint> f149426b;

        public d() {
            ne.this.a(this);
        }

        private void a() {
            ne.this.b(this);
        }

        private void b() {
            ne.this.f149396i.w();
            this.f149425a = null;
            this.f149426b = null;
        }

        private void a(List<MapRouteSection> list, List<GeoPoint> list2) {
            this.f149425a = list;
            this.f149426b = list2;
            ne.this.f149396i.a(list, list2);
        }

        @Override // com.tencent.mapsdk.internal.fk
        public final void a(Language language) {
            if (language != Language.zh) {
                ne.this.f149396i.w();
            } else {
                if (this.f149425a == null || this.f149426b == null) {
                    return;
                }
                ne.this.f149396i.a(this.f149425a, this.f149426b);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public enum e {
        DAY,
        NIGHT
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class f {

        /* renamed from: b, reason: collision with root package name */
        private final ArrayList<g> f149432b;

        /* renamed from: c, reason: collision with root package name */
        private g f149433c;

        /* synthetic */ f(ne neVar, byte b16) {
            this();
        }

        private g d() {
            g gVar;
            synchronized (this.f149432b) {
                if (this.f149432b.size() > 0) {
                    gVar = this.f149432b.get(0);
                } else {
                    gVar = null;
                }
            }
            return gVar;
        }

        public final boolean b() {
            boolean z16;
            synchronized (this.f149432b) {
                ArrayList<g> arrayList = this.f149432b;
                if (arrayList != null && !arrayList.isEmpty()) {
                    z16 = false;
                }
                z16 = true;
            }
            return z16;
        }

        public final synchronized g c() {
            g d16 = d();
            this.f149433c = d16;
            if (d16 == null) {
                return null;
            }
            if (d16.c()) {
                a(this.f149433c);
                return null;
            }
            ne.this.f149398k.e();
            g gVar = this.f149433c;
            Rect rect = gVar.f149442i;
            int i3 = gVar.f149440g;
            int i16 = gVar.f149441h;
            Rect rect2 = new Rect();
            int a16 = (int) (ht.a(ne.this.getContext()) * 20.0f);
            int width = ((ne.this.f149405r.width() - i3) / 2) + a16;
            rect2.right = width;
            rect2.left = width;
            int height = ((ne.this.f149405r.height() - i16) / 2) + a16;
            rect2.bottom = height;
            rect2.top = height;
            ne.this.f149398k.c(rect, rect2);
            return this.f149433c;
        }

        f() {
            this.f149432b = new ArrayList<>();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(fb fbVar, Rect rect, fr frVar, int i3, int i16) {
            g gVar = new g(ne.this, fbVar, rect, frVar, i3, i16, (byte) 0);
            synchronized (this.f149432b) {
                this.f149432b.add(gVar);
            }
            LogUtil.b("snapshot addSnapshotRequest");
            ne.this.f149412y = true;
        }

        public final synchronized void a() {
            LogUtil.b("snapshot cancel");
            synchronized (this.f149432b) {
                this.f149432b.clear();
            }
            g gVar = this.f149433c;
            if (gVar != null) {
                gVar.f149443j = 1;
                gVar.f149438e = 0;
            }
        }

        public final synchronized void a(GL10 gl10, nd ndVar) {
            if (ne.this.f149396i == null) {
                return;
            }
            fb fbVar = this.f149433c.f149439f;
            if (fbVar != null) {
                fbVar.a(gl10);
            }
            ndVar.a();
        }

        public final synchronized void a(GL10 gl10) {
            g gVar = this.f149433c;
            if (gVar != null && !gVar.c()) {
                g gVar2 = this.f149433c;
                a(gl10, gVar2.f149440g, gVar2.f149441h);
                a(this.f149433c);
            }
        }

        private void a(g gVar) {
            if (gVar == null || gVar.a()) {
                return;
            }
            gVar.b();
            synchronized (this.f149432b) {
                this.f149432b.remove(gVar);
            }
            ne.this.f149398k.f();
        }

        private Bitmap a(GL10 gl10, int i3, int i16) {
            int i17 = i3 * i16;
            int[] iArr = new int[i17];
            int[] iArr2 = new int[i17];
            IntBuffer wrap = IntBuffer.wrap(iArr);
            wrap.position(0);
            gl10.glReadPixels((ne.this.f149405r.width() - i3) / 2, (ne.this.f149405r.height() - i16) / 2, i3, i16, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, wrap);
            for (int i18 = 0; i18 < i16; i18++) {
                for (int i19 = 0; i19 < i3; i19++) {
                    int i26 = iArr[(i18 * i3) + i19];
                    iArr2[(((i16 - i18) - 1) * i3) + i19] = (i26 & (-16711936)) | ((i26 << 16) & ITVKAsset.VOD_ASSET_MASK_BIT) | ((i26 >> 16) & 255);
                }
            }
            try {
                return Bitmap.createBitmap(iArr2, i3, i16, Bitmap.Config.RGB_565);
            } catch (OutOfMemoryError unused) {
                return Bitmap.createBitmap(iArr2, i3, i16, Bitmap.Config.RGB_565);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class g {

        /* renamed from: a, reason: collision with root package name */
        public static final int f149434a = 0;

        /* renamed from: b, reason: collision with root package name */
        public static final int f149435b = 1;

        /* renamed from: c, reason: collision with root package name */
        public static final int f149436c = 2;

        /* renamed from: d, reason: collision with root package name */
        public static final int f149437d = 3;

        /* renamed from: e, reason: collision with root package name */
        int f149438e;

        /* renamed from: f, reason: collision with root package name */
        fb f149439f;

        /* renamed from: g, reason: collision with root package name */
        int f149440g;

        /* renamed from: h, reason: collision with root package name */
        int f149441h;

        /* renamed from: i, reason: collision with root package name */
        Rect f149442i;

        /* renamed from: j, reason: collision with root package name */
        int f149443j;

        /* renamed from: l, reason: collision with root package name */
        private fr f149445l;

        /* synthetic */ g(ne neVar, fb fbVar, Rect rect, fr frVar, int i3, int i16, byte b16) {
            this(fbVar, rect, frVar, i3, i16);
        }

        private static /* synthetic */ int b(g gVar) {
            gVar.f149438e = 0;
            return 0;
        }

        private static /* synthetic */ int c(g gVar) {
            int i3 = gVar.f149438e;
            gVar.f149438e = i3 + 1;
            return i3;
        }

        g(fb fbVar, Rect rect, fr frVar, int i3, int i16) {
            this.f149438e = 0;
            this.f149439f = fbVar;
            this.f149442i = rect;
            this.f149445l = frVar;
            this.f149440g = i3;
            this.f149441h = i16;
            this.f149443j = 0;
        }

        private void d() {
            this.f149443j = 1;
            this.f149438e = 0;
        }

        private boolean e() {
            StringBuilder sb5 = new StringBuilder("is processing:");
            sb5.append(this.f149443j == 3);
            LogUtil.b(sb5.toString());
            return this.f149443j == 3;
        }

        public final synchronized boolean a() {
            return this.f149443j == 2;
        }

        public final synchronized void b() {
            this.f149443j = 2;
            this.f149438e = 0;
        }

        public final boolean c() {
            return this.f149443j == 1;
        }

        private void a(int i3) {
            this.f149443j = i3;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ne(Context context, TencentMapOptions tencentMapOptions, bq bqVar) {
        super(context, tencentMapOptions, bqVar);
        this.f149412y = false;
        this.f149413z = true;
        this.f149385aa = true;
        this.E = true;
        this.f149386ab = false;
        this.f149387ac = 0;
        this.f149388ad = 0;
        this.f149389ae = 0.5f;
        this.f149390af = 0.5f;
        this.f149391ag = true;
        this.G = 18;
        this.H = 14;
        this.P = null;
        this.N = bqVar.f147934f;
        bb bbVar = (bb) bqVar;
        this.f149402o = bbVar;
        bj bjVar = new bj(bbVar, this);
        this.M = bjVar;
        tk tkVar = new tk(context, this);
        this.f149396i = tkVar;
        this.f149410w = new v(this);
        Rect rect = new Rect();
        this.f149405r = rect;
        bk bkVar = new bk(bjVar, this);
        this.f149400m = bkVar;
        bbVar.a(bkVar);
        this.K = new re(getContext(), this);
        this.f149403p = new y(this);
        this.f149404q = new z(this);
        ae aeVar = new ae(this);
        this.f149398k = aeVar;
        tkVar.f150516f = aeVar;
        this.f149397j = new mp();
        this.f149401n = new nd(this, tkVar);
        this.f149409v = new f(this, (byte) 0);
        this.W = new LinkedBlockingQueue<>();
        this.L = new CopyOnWriteArrayList();
        if (getContext() != null) {
            this.S = (int) ((getContext().getResources().getDisplayMetrics().density * 6.0f) + 0.5d);
        } else {
            this.S = 6;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        rect.set(0, 0, windowManager.getDefaultDisplay().getWidth(), windowManager.getDefaultDisplay().getHeight());
    }

    private tk P() {
        return this.f149396i;
    }

    private int Q() {
        return this.N;
    }

    private boolean R() {
        tk tkVar = this.f149396i;
        if (tkVar == null || tkVar.f150515e == 0) {
            return false;
        }
        if (SystemClock.elapsedRealtime() - tkVar.f150522l > 560) {
            tkVar.f150514d.nativeClearDownloadURLCache(tkVar.f150515e);
            tkVar.f150522l = SystemClock.elapsedRealtime();
        }
        return tkVar.f150514d.nativeGenerateTextures(tkVar.f150515e);
    }

    private lu S() {
        return this.f149411x.d();
    }

    private mp T() {
        return this.f149397j;
    }

    private void U() {
        rw rwVar;
        if (this.f149396i == null) {
            return;
        }
        this.f149412y = true;
        this.E = true;
        tk tkVar = this.f149396i;
        if (tkVar != null && tkVar.f150515e != 0) {
            tkVar.b(new tk.AnonymousClass34());
        }
        h(this.E);
        if (this.f149413z) {
            aa aaVar = this.f149398k.f147732o;
            aa.a aVar = aaVar.f147671d;
            if (aVar != null) {
                aVar.destroy();
            }
            aa.a aVar2 = new aa.a(aaVar);
            aaVar.f147671d = aVar2;
            aVar2.start();
            this.f149413z = false;
        } else {
            aa aaVar2 = this.f149398k.f147732o;
            if (aaVar2 != null) {
                aaVar2.b();
            }
        }
        bb bbVar = this.f149402o;
        if (bbVar != null) {
            bbVar.getMapRenderView().d();
        }
        if (this.f149406s) {
            this.f149396i.l();
        }
        if (this.f149407t && (rwVar = this.f149399l) != null) {
            rwVar.a();
        }
        sa saVar = this.D;
        if (saVar != null) {
            saVar.f150176g = false;
            saVar.f150178i.sendEmptyMessage(130818);
        }
    }

    private void V() {
        rw rwVar;
        if (this.f149396i == null) {
            return;
        }
        this.f149412y = false;
        this.E = false;
        h(false);
        sa saVar = this.D;
        if (saVar != null) {
            saVar.f150176g = true;
        }
        aa aaVar = this.f149398k.f147732o;
        if (aaVar != null) {
            aaVar.a();
        }
        this.f149396i.m();
        if (this.f149407t && (rwVar = this.f149399l) != null) {
            rwVar.f150154b.a();
        }
    }

    private void W() {
        rw rwVar;
        if (this.f149407t && (rwVar = this.f149399l) != null) {
            rwVar.f150154b.a();
        }
    }

    private void X() {
        if (this.f149396i == null) {
            return;
        }
        a(new a() { // from class: com.tencent.mapsdk.internal.ne.1
            @Override // com.tencent.mapsdk.internal.ne.a
            public final void a(GL10 gl10) {
                if (ne.this.f149396i != null) {
                    ne.this.f149397j.a(gl10);
                }
            }
        });
    }

    private w Y() {
        return this.f149408u;
    }

    private void Z() {
        mp mpVar;
        if (this.f149396i != null && (mpVar = this.f149397j) != null) {
            mpVar.a();
        }
    }

    private sa aA() {
        return this.D;
    }

    private ol aB() {
        return this.f149411x;
    }

    private String aC() {
        return this.f149395ak;
    }

    private bj aD() {
        return this.M;
    }

    private String aE() {
        tk tkVar = this.f149396i;
        if (tkVar == null) {
            return null;
        }
        return (String) tkVar.a(new tk.AnonymousClass48(), (tk.AnonymousClass48) null);
    }

    private String aF() {
        tk tkVar = this.f149396i;
        if (tkVar == null) {
            return null;
        }
        return tkVar.a();
    }

    private void aG() {
        pb pbVar = this.J;
        if (pbVar != null) {
            pbVar.p_();
        }
    }

    private void aH() {
        List<oz> list = this.L;
        if (list != null && !list.isEmpty()) {
            Iterator<oz> it = this.L.iterator();
            while (it.hasNext()) {
                it.next().j();
            }
        }
    }

    private void aI() {
        List<oz> list = this.L;
        if (list != null && !list.isEmpty()) {
            Iterator<oz> it = this.L.iterator();
            while (it.hasNext()) {
                it.next().k();
            }
        }
    }

    private re aJ() {
        return this.K;
    }

    private Rect aa() {
        return this.F;
    }

    private void ab() {
        this.f149412y = true;
    }

    private int ac() {
        tk tkVar = this.f149396i;
        if (tkVar != null) {
            return tkVar.e();
        }
        return -1;
    }

    private void ad() {
        tk tkVar = this.f149396i;
        if (tkVar != null) {
            tkVar.d();
        }
    }

    private void ae() {
        tk tkVar = this.f149396i;
        if (tkVar != null) {
            tkVar.f();
        }
    }

    private boolean af() {
        return this.f149407t;
    }

    private void ag() {
        if (this.C == null) {
            this.C = new d();
        }
        d dVar = this.C;
        ne.this.f149396i.w();
        dVar.f149425a = null;
        dVar.f149426b = null;
    }

    private boolean ah() {
        tk tkVar = this.f149396i;
        if (tkVar == null || ((Integer) tkVar.a((CallbackRunnable<tk.AnonymousClass158>) new tk.AnonymousClass158(K()), (tk.AnonymousClass158) 0)).intValue() != 1) {
            return false;
        }
        return true;
    }

    private String[] ai() {
        Rect q16 = this.f149398k.q();
        Point[] pointArr = {new Point(q16.centerX(), q16.centerY()), new Point(q16.left, q16.top), new Point(q16.left, q16.bottom), new Point(q16.right, q16.top), new Point(q16.right, q16.bottom)};
        HashSet hashSet = new HashSet();
        for (int i3 = 0; i3 < 5; i3++) {
            Point point = pointArr[i3];
            String a16 = a(new GeoPoint(point.y, point.x));
            if (!hs.a(a16)) {
                hashSet.add(a16);
            }
        }
        return (String[]) hashSet.toArray(new String[0]);
    }

    private void aj() {
        tk tkVar = this.f149396i;
        if (tkVar != null) {
            tkVar.l();
            this.f149406s = true;
        }
    }

    private void ak() {
        tk tkVar = this.f149396i;
        if (tkVar != null) {
            tkVar.m();
            this.f149406s = false;
        }
    }

    private boolean al() {
        return this.f149406s;
    }

    private boolean am() {
        return this.f149386ab;
    }

    private void an() {
        tk tkVar = this.f149396i;
        if (tkVar != null) {
            tkVar.a(new tk.AnonymousClass117());
        }
    }

    private void ao() {
        tk tkVar = this.f149396i;
        if (tkVar != null) {
            tkVar.a(new tk.AnonymousClass118());
        }
    }

    private void ap() {
        this.f149409v.a();
    }

    private void aq() {
        this.f149412y = true;
    }

    private boolean ar() {
        if (this.f149398k.i() > 1.0E-10d) {
            return true;
        }
        return false;
    }

    private String[] as() {
        tk tkVar = this.f149396i;
        if (tkVar == null) {
            return null;
        }
        return (String[]) tkVar.a(new tk.AnonymousClass161(), (tk.AnonymousClass161) null);
    }

    private void at() {
        tk tkVar = this.f149396i;
        if (tkVar != null) {
            tkVar.a(new tk.AnonymousClass98());
        }
    }

    private String au() {
        tk tkVar = this.f149396i;
        if (tkVar == null) {
            return null;
        }
        return (String) tkVar.a(new tk.AnonymousClass164(), (tk.AnonymousClass164) null);
    }

    private Rect av() {
        tk tkVar = this.f149396i;
        if (tkVar == null) {
            return null;
        }
        return (Rect) tkVar.a(new tk.AnonymousClass163(), (tk.AnonymousClass163) null);
    }

    @Deprecated
    private boolean aw() {
        tk tkVar = this.f149396i;
        if (tkVar != null) {
            return tkVar.v();
        }
        return false;
    }

    private void ax() {
        tk tkVar = this.f149396i;
        if (tkVar != null && tkVar.f150515e != 0) {
            tkVar.b(new tk.AnonymousClass34());
        }
    }

    private Language ay() {
        if (this.B == null) {
            this.B = new c();
        }
        tk tkVar = ne.this.f149396i;
        if (tkVar == null) {
            return Language.zh;
        }
        return Language.wrap(tkVar.f150514d.nativeGetLanguage(tkVar.f150515e));
    }

    private nd az() {
        return this.f149401n;
    }

    static /* synthetic */ boolean e(ne neVar) {
        neVar.f149412y = true;
        return true;
    }

    private void j(int i3) {
        tk tkVar = this.f149396i;
        if (tkVar == null || 0 == tkVar.f150515e) {
            return;
        }
        tkVar.a(new tk.AnonymousClass172(i3));
    }

    private void k(int i3) {
        tk tkVar = this.f149396i;
        if (tkVar != null) {
            tkVar.b(i3);
        }
        v vVar = this.f149410w;
        if (vVar != null) {
            vVar.f151253b.f151288n = i3;
        }
    }

    private void l(boolean z16) {
        this.f149396i.i(z16);
    }

    private void m(boolean z16) {
        tk tkVar = this.f149396i;
        if (tkVar != null) {
            tkVar.a(new tk.AnonymousClass138(z16));
        }
    }

    private void n(boolean z16) {
        tk tkVar = this.f149396i;
        if (0 != tkVar.f150515e) {
            tkVar.a(new tk.AnonymousClass173(z16));
        }
    }

    private void o(boolean z16) {
        if (this.f149396i != null) {
            LogUtil.b(ky.f149101g, "setLandMarkEnabled:".concat(String.valueOf(z16)));
            this.f149396i.c(z16);
        }
    }

    private void p(boolean z16) {
        tk tkVar = this.f149396i;
        if (tkVar == null || tkVar.f150515e == 0) {
            return;
        }
        tkVar.a(new tk.AnonymousClass168(z16));
    }

    @Deprecated
    private void q(boolean z16) {
        tk tkVar = this.f149396i;
        if (tkVar != null) {
            tkVar.j(z16);
        }
    }

    private void r(boolean z16) {
        ae aeVar = this.f149398k;
        aeVar.G = z16;
        aeVar.f147743z.g().b(aeVar.G);
    }

    private void s(boolean z16) {
        tk tkVar = this.f149396i;
        if (tkVar != null) {
            tkVar.b(z16);
        }
        this.f149412y = true;
    }

    private void u(boolean z16) {
        ae aeVar = this.f149398k;
        if (aeVar != null) {
            aeVar.L = z16;
        }
    }

    private void v(boolean z16) {
        ae aeVar = this.f149398k;
        if (aeVar != null) {
            aeVar.M = z16;
        }
    }

    @Override // com.tencent.mapsdk.internal.bp
    public final String E() {
        tk tkVar = this.f149396i;
        if (tkVar != null) {
            return (String) tkVar.a((CallbackRunnable<tk.AnonymousClass43>) new tk.AnonymousClass43(), (tk.AnonymousClass43) "");
        }
        return null;
    }

    @Override // com.tencent.mapsdk.internal.bp
    public final String F() {
        tk tkVar = this.f149396i;
        if (tkVar != null) {
            return (String) tkVar.a((CallbackRunnable<tk.AnonymousClass44>) new tk.AnonymousClass44(), (tk.AnonymousClass44) "");
        }
        return null;
    }

    @Override // com.tencent.mapsdk.internal.bp
    public final bu H() {
        return this.f149396i;
    }

    public final void I() {
        rw rwVar;
        if (this.f149407t && (rwVar = this.f149399l) != null) {
            rwVar.a();
        }
    }

    public final void J() {
        aa.a aVar;
        File[] listFiles;
        Map<Integer, qz> map;
        re reVar = this.K;
        if (reVar != null && (map = reVar.f150021g) != null && !map.isEmpty()) {
            for (qz qzVar : (qz[]) reVar.f150021g.values().toArray(new qz[reVar.f150021g.keySet().size()])) {
                qzVar.remove();
            }
        }
        Context context = getContext();
        if (context != null) {
            File file = new File(mz.a(context, (TencentMapOptions) null).b().getPath() + "/tile/");
            if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                for (File file2 : listFiles) {
                    if (currentTimeMillis - file2.lastModified() > TimeUnit.DAYS.toMillis(7L)) {
                        kt.b(file2);
                    }
                }
            }
        }
        a((ox) null);
        this.J = null;
        this.f149398k.b(this);
        this.L.clear();
        d dVar = this.C;
        if (dVar != null) {
            ne.this.b(dVar);
        }
        aa aaVar = this.f149398k.f147732o;
        if (aaVar != null && (aVar = aaVar.f147671d) != null) {
            aVar.destroy();
        }
        this.f149413z = true;
        sa saVar = this.D;
        if (saVar != null) {
            saVar.f150177h = true;
            saVar.f150175f = false;
            saVar.f150178i.sendEmptyMessage(130819);
        }
        bk bkVar = this.f149400m;
        if (bkVar != null) {
            bkVar.b();
        }
        rw rwVar = this.f149399l;
        if (rwVar != null) {
            rwVar.b();
        }
        tk tkVar = this.f149396i;
        if (tkVar != null) {
            lw lwVar = tkVar.f150517g;
            if (lwVar != null) {
                lwVar.b(tkVar.f150518h);
                tkVar.f150517g.a();
            }
            if (tkVar.f150515e != 0) {
                long j3 = tkVar.f150515e;
                synchronized (tkVar.f150523m) {
                    tkVar.f150515e = 0L;
                    tkVar.f150514d.nativeDestroyEngine(j3);
                }
            }
            tkVar.f150520j = null;
            tkVar.f150514d.destory();
        }
    }

    public final String K() {
        return a(this.f149398k.A.f151264m);
    }

    public final bp L() {
        bb bbVar = this.f149402o;
        if (bbVar == null) {
            return null;
        }
        return bbVar.getMapContext();
    }

    @Deprecated
    public final boolean M() {
        tk tkVar = this.f149396i;
        if (tkVar != null) {
            return tkVar.h();
        }
        return false;
    }

    public final ArrayList<MapPoi> N() {
        tk tkVar = this.f149396i;
        if (tkVar == null) {
            return null;
        }
        return tkVar.x();
    }

    public final boolean O() {
        tk tkVar = this.f149396i;
        if (tkVar == null) {
            return false;
        }
        return ((Boolean) tkVar.a((CallbackRunnable<tk.AnonymousClass50>) new tk.AnonymousClass50(1), (tk.AnonymousClass50) Boolean.FALSE)).booleanValue();
    }

    @Override // com.tencent.mapsdk.internal.bf
    public final v f() {
        return this.f149410w;
    }

    @Override // com.tencent.mapsdk.internal.bf
    public final tk g() {
        return this.f149396i;
    }

    @Override // com.tencent.mapsdk.internal.bf
    public final Rect h() {
        return this.f149405r;
    }

    @Override // com.tencent.mapsdk.internal.bf
    public final float i() {
        if (getContext() == null) {
            return 1.0f;
        }
        return ht.a(getContext());
    }

    @Override // com.tencent.mapsdk.internal.bf
    public final TencentMap.OnMapClickListener t() {
        return this.f149402o.V();
    }

    public final String toString() {
        v vVar = this.f149410w;
        if (vVar != null) {
            return vVar.toString();
        }
        return "";
    }

    @Override // com.tencent.mapsdk.internal.bp
    public final Map<Class<? extends TencentMapComponent.Component>, Class<? extends TencentMapComponent.Component>> y() {
        HashMap hashMap = new HashMap();
        hashMap.put(eg.class, si.class);
        hashMap.put(cf.class, rk.class);
        return hashMap;
    }

    private void b(GL10 gl10) {
        if (this.W.size() == 0) {
            return;
        }
        boolean z16 = true;
        while (z16) {
            a poll = this.W.poll();
            if (poll != null) {
                try {
                    poll.a(gl10);
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            } else {
                z16 = false;
            }
        }
    }

    private void f(int i3) {
        ng a16;
        bk bkVar = this.f149400m;
        if (bkVar == null || (a16 = bkVar.a((Class<ng>) oc.class, i3)) == null) {
            return;
        }
        a16.remove();
    }

    private void g(int i3) {
        tk tkVar = this.f149396i;
        tkVar.a(new tk.AnonymousClass60(i3));
    }

    private void h(int i3) {
        tk tkVar = this.f149396i;
        if (tkVar == null) {
            return;
        }
        tkVar.a(new tk.AnonymousClass169(i3));
    }

    @Deprecated
    private void l(int i3) {
        tk tkVar = this.f149396i;
        if (tkVar != null) {
            tkVar.d(i3);
            this.f149412y = true;
        }
    }

    private void t(boolean z16) {
        tk tkVar = this.f149396i;
        if (tkVar != null) {
            tkVar.a(new tk.AnonymousClass42(z16));
        }
    }

    public final boolean a(Context context, ol olVar, lu luVar, oo ooVar) {
        TrafficStyle trafficStyle;
        this.f149411x = olVar;
        oq c16 = olVar.c();
        this.X = c16;
        om e16 = olVar.e();
        this.A = e16;
        this.f149408u = new w(context, this, c16, e16);
        if (this.f149399l == null) {
            rw rwVar = new rw(this, luVar);
            this.f149399l = rwVar;
            bb bbVar = this.f149402o;
            if (bbVar != null) {
                bbVar.a(rwVar);
            }
        }
        boolean a16 = a(context, ooVar);
        if (a16) {
            TencentMapOptions tencentMapOptions = this.f147915b;
            if (tencentMapOptions != null && (trafficStyle = tencentMapOptions.getTrafficStyle()) != null) {
                this.f149396i.a(trafficStyle);
            }
            tk tkVar = this.f149396i;
            if (0 != tkVar.f150515e) {
                tkVar.a(new tk.AnonymousClass143());
            }
            this.f149396i.g(true);
            this.f149396i.h(true);
            this.f149396i.a(20);
            this.f149396i.b(3);
            this.f149398k.a(this);
            int i3 = this.S;
            b(i3, i3);
        }
        return a16;
    }

    @Override // com.tencent.mapsdk.internal.bf
    public final bk c() {
        return this.f149400m;
    }

    @Override // com.tencent.mapsdk.internal.bf
    public final fa d() {
        return this.f149403p;
    }

    @Override // com.tencent.mapsdk.internal.bf
    public final VisualSettings e() {
        return this.f149404q;
    }

    private void c(int i3, int i16) {
        if (this.f149396i == null) {
            return;
        }
        this.f149412y = true;
        this.f149405r.set(0, 0, i3, i16);
        a(0, 0, i3, i16, false);
        this.f149398k.n();
    }

    private void d(int i3, int i16) {
        Rect rect = this.f149405r;
        if (rect != null) {
            rect.set(0, 0, i3, i16);
        }
    }

    private void e(int i3, int i16) {
        tk tkVar = this.f149396i;
        if (tkVar == null) {
            return;
        }
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

    private void i(int i3) {
        tk tkVar = this.f149396i;
        if (tkVar != null) {
            tkVar.a(new tk.AnonymousClass159(i3));
        }
    }

    @Deprecated
    private void m(int i3) {
        tk tkVar = this.f149396i;
        if (tkVar != null) {
            tkVar.e(i3);
        }
    }

    @Override // com.tencent.mapsdk.internal.bf
    public final TencentMap.OnMarkerCollisionStatusListener q() {
        return this.f149402o.R();
    }

    private void h(int i3, int i16) {
        tk tkVar = this.f149396i;
        if (tkVar != null) {
            tkVar.a(new tk.AnonymousClass26(i3, i16));
        }
    }

    private static boolean n(int i3) {
        return v.b(i3);
    }

    private void o(int i3) {
        tk tkVar = this.f149396i;
        tkVar.a(new tk.AnonymousClass157(i3));
    }

    public final void g(boolean z16) {
        tk tkVar = this.f149396i;
        if (tkVar != null) {
            tkVar.h(z16);
        }
    }

    public final void j(boolean z16) {
        tk tkVar = this.f149396i;
        if (tkVar != null) {
            tkVar.l(z16);
        }
    }

    @Override // com.tencent.mapsdk.internal.bf
    public final boolean p() {
        return this.f147915b.isMSAA();
    }

    @Override // com.tencent.mapsdk.internal.bf
    public final TencentMap.OnMarkerDragListener r() {
        return this.f149402o.S();
    }

    @Override // com.tencent.mapsdk.internal.bf
    public final TencentMap.OnMapPoiClickListener s() {
        return this.f149402o.x();
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c {

        /* renamed from: b, reason: collision with root package name */
        private List<fk> f149424b = new CopyOnWriteArrayList();

        public c() {
        }

        private Language a() {
            if (ne.this.f149396i != null) {
                tk tkVar = ne.this.f149396i;
                return Language.wrap(tkVar.f150514d.nativeGetLanguage(tkVar.f150515e));
            }
            return Language.zh;
        }

        private void b(Language language) {
            if (ne.this.f149396i != null) {
                tk tkVar = ne.this.f149396i;
                int languageType = language.getLanguageType();
                if (tkVar.f150515e != 0) {
                    tkVar.f150514d.nativeSetLanguage(tkVar.f150515e, languageType);
                }
                ne.e(ne.this);
                ne.this.f149412y = true;
                a(language);
            }
        }

        public final void a(fk fkVar) {
            if (fkVar == null) {
                return;
            }
            synchronized (this.f149424b) {
                if (!this.f149424b.contains(fkVar)) {
                    this.f149424b.add(fkVar);
                }
            }
        }

        public final void b(fk fkVar) {
            if (fkVar == null) {
                return;
            }
            this.f149424b.remove(fkVar);
        }

        public final synchronized void a(Language language) {
            for (fk fkVar : this.f149424b) {
                if (fkVar != null) {
                    fkVar.a(language);
                }
            }
        }
    }

    private boolean d(int i3) {
        CustomRender customRender;
        if (i3 != b.AboveToplayer.f149422g || (customRender = this.I) == null) {
            return false;
        }
        customRender.onDrawFrame();
        return true;
    }

    private void e(int i3) {
        tk tkVar = this.f149396i;
        if (tkVar == null) {
            return;
        }
        tkVar.a(new tk.AnonymousClass108(i3));
    }

    public final void i(boolean z16) {
        if (this.D == null) {
            this.D = new sa(this);
        }
        sa saVar = this.D;
        saVar.f150175f = z16;
        if (z16) {
            saVar.f150178i.sendEmptyMessage(130817);
        } else {
            saVar.f150178i.sendEmptyMessage(130819);
        }
    }

    @Override // com.tencent.mapsdk.internal.bf
    public final int l() {
        return this.f147915b.getExtSurfaceHeight();
    }

    @Override // com.tencent.mapsdk.internal.bp, com.tencent.mapsdk.internal.bf
    public final boolean m() {
        return v.b(this.f149398k.m());
    }

    @Override // com.tencent.mapsdk.internal.bf
    public final float n() {
        return this.f147915b.getMapFrameRate();
    }

    private void b(rt rtVar) {
        List<rt> list;
        rw rwVar = this.f149399l;
        if (rwVar == null || rtVar == null || (list = rwVar.f150154b.f150144a) == null) {
            return;
        }
        list.remove(rtVar);
    }

    @Deprecated
    private void g(int i3, int i16) {
        tk tkVar = this.f149396i;
        if (tkVar != null) {
            tkVar.b(i3, i16);
        }
    }

    public final void f(boolean z16) {
        tk tkVar = this.f149396i;
        if (tkVar != null) {
            tkVar.g(z16);
        }
    }

    public final void h(boolean z16) {
        tk tkVar = this.f149396i;
        if (tkVar == null) {
            return;
        }
        tkVar.k(z16);
    }

    @Override // com.tencent.mapsdk.internal.bf
    public final Object j() {
        return this.f147915b.getExtSurface();
    }

    public final void k(boolean z16) {
        tk tkVar = this.f149396i;
        if (tkVar != null) {
            tkVar.a(new tk.AnonymousClass41(z16));
        }
    }

    @Override // com.tencent.mapsdk.internal.bf
    public final boolean o() {
        return this.f147915b.isOpaque();
    }

    public final void e(boolean z16) {
        tk tkVar = this.f149396i;
        if (tkVar != null) {
            tkVar.f(z16);
        }
    }

    private int c(fy fyVar) {
        if (this.f149400m == null || fyVar.f148409u == null) {
            return -1;
        }
        oc ocVar = (oc) this.f149400m.a((bk) b(fyVar));
        if (ocVar != null) {
            return ocVar.b();
        }
        return -1;
    }

    private boolean d(String str) {
        tk tkVar = this.f149396i;
        if (tkVar == null) {
            return false;
        }
        return ((Boolean) tkVar.a((CallbackRunnable<tk.AnonymousClass112>) new tk.AnonymousClass112(str), (tk.AnonymousClass112) Boolean.FALSE)).booleanValue();
    }

    private void f(int i3, int i16) {
        this.H = i3;
        this.G = i16;
    }

    private int g(String str) {
        tk tkVar = this.f149396i;
        if (tkVar == null) {
            return -1;
        }
        return ((Integer) tkVar.a((CallbackRunnable<tk.AnonymousClass47>) new tk.AnonymousClass47(str), (tk.AnonymousClass47) (-1))).intValue();
    }

    private void h(String str) {
        om omVar = this.A;
        if (omVar == null) {
            return;
        }
        omVar.a(str);
    }

    @Override // com.tencent.mapsdk.internal.bf
    public final int k() {
        return this.f147915b.getExtSurfaceWidth();
    }

    private void e(String str) {
        tk tkVar = this.f149396i;
        if (tkVar == null || 0 == tkVar.f150515e) {
            return;
        }
        tkVar.a(new tk.AnonymousClass151(str));
    }

    private void f(String str) {
        tk tkVar = this.f149396i;
        if (tkVar != null) {
            tkVar.a(new tk.AnonymousClass32(str));
        }
    }

    public final void b(PolygonInfo polygonInfo) {
        tk tkVar = this.f149396i;
        if (tkVar == null || polygonInfo == null) {
            return;
        }
        tkVar.a(new tk.AnonymousClass101(polygonInfo));
    }

    public final void d(boolean z16) {
        if (this.f149396i != null) {
            LogUtil.b(ky.f149101g, "setIndoorEnabled:".concat(String.valueOf(z16)));
            this.f149396i.d(z16);
        }
    }

    public static oe b(fy fyVar) {
        oe oeVar = new oe(fyVar.f148409u, fyVar.f148390b);
        if (!TextUtils.isEmpty(fyVar.f148396h)) {
            SubMarkerInfo subMarkerInfo = new SubMarkerInfo();
            subMarkerInfo.iconName(fyVar.f148396h);
            subMarkerInfo.iconWidth(fyVar.f148397i);
            subMarkerInfo.iconHeight(fyVar.f148398j);
            subMarkerInfo.avoidAnnotation(true);
            subMarkerInfo.avoidOtherMarker(true);
            oeVar.subMarkerInfo(subMarkerInfo);
        }
        oeVar.iconWidth(fyVar.f148391c);
        oeVar.iconHeight(fyVar.f148392d);
        oeVar.avoidAnnotation(true);
        oeVar.avoidOtherMarker(true);
        float f16 = fyVar.f148395g;
        oeVar.scale(f16, f16);
        oeVar.priority(fyVar.f148406r);
        oeVar.displayLevel(2);
        oeVar.minScaleLevel(fyVar.f148407s);
        oeVar.maxScaleLevel(fyVar.f148408t);
        return oeVar;
    }

    public final void c(boolean z16) {
        this.f149385aa = z16;
        tk tkVar = this.f149396i;
        if (tkVar != null) {
            tkVar.a(new tk.AnonymousClass138(z16));
        }
    }

    public final void c(String str) {
        tk tkVar = this.f149396i;
        if (tkVar != null) {
            tkVar.b(str);
        }
    }

    public final void c(int i3) {
        ae aeVar = this.f149398k;
        if (aeVar != null) {
            aeVar.b(i3);
        }
        if (i3 == 8) {
            a(e.NIGHT);
        } else {
            a(e.DAY);
        }
    }

    private void a(e eVar) {
        String str = "skybox_" + eVar.name().toLowerCase(Locale.ROOT) + ".png";
        tk tkVar = this.f149396i;
        if (tkVar.f150515e == 0 || tkVar.f150520j == null) {
            return;
        }
        tkVar.f150514d.nativeSetSkyBoxTexture(tkVar.f150515e, str);
    }

    @Override // com.tencent.mapsdk.internal.fq
    public final void d_() {
    }

    private boolean a(Context context, oo ooVar) {
        String c16 = this.X.c();
        String a16 = this.X.a();
        String b16 = this.X.b();
        try {
            if (!this.f149411x.a()) {
                c16 = this.X.d();
            }
            String str = c16;
            LogUtil.b(ky.f149101g, "newEngine config:".concat(String.valueOf(str)));
            this.f149408u.a();
            return this.f149396i.a(context, ooVar, this.f149408u, str, a16, b16);
        } finally {
            this.f149408u.b();
        }
    }

    public final void b(String str) {
        tk tkVar = this.f149396i;
        if (tkVar != null) {
            this.f149395ak = str;
            if (tkVar.f150515e != 0) {
                tkVar.a(new tk.AnonymousClass39(str));
            }
        }
    }

    private static Point[] b(Rect rect) {
        return new Point[]{new Point(rect.centerX(), rect.centerY()), new Point(rect.left, rect.top), new Point(rect.left, rect.bottom), new Point(rect.right, rect.top), new Point(rect.right, rect.bottom)};
    }

    public final void a(oq oqVar) {
        if (oqVar == null) {
            return;
        }
        this.X = oqVar;
        if (this.f149396i != null) {
            String c16 = oqVar.c();
            String a16 = this.X.a();
            String b16 = this.X.b();
            LogUtil.b(ky.f149101g, "resetMapPath config:".concat(String.valueOf(c16)));
            if (hs.a(b16) || hs.a(a16)) {
                return;
            }
            try {
                this.f149408u.a();
                tk tkVar = this.f149396i;
                tkVar.a(new tk.AnonymousClass33(c16, a16, b16));
            } finally {
                this.f149408u.b();
            }
        }
    }

    public final void b(boolean z16) {
        if (this.f149386ab == z16) {
            return;
        }
        this.f149386ab = z16;
        tk tkVar = this.f149396i;
        if (tkVar != null) {
            tkVar.a(z16);
        }
    }

    private void b(List<IndoorCellInfo> list) {
        tk tkVar = this.f149396i;
        if (tkVar != null) {
            tkVar.a(new tk.AnonymousClass97(list));
        }
    }

    private String b(GeoPoint geoPoint) {
        tk tkVar = this.f149396i;
        if (tkVar != null) {
            return (String) tkVar.a(new tk.AnonymousClass165(geoPoint), (tk.AnonymousClass165) null);
        }
        return null;
    }

    public final void b(int i3) {
        tk tkVar = this.f149396i;
        if (tkVar != null) {
            tkVar.a(i3);
        }
        v vVar = this.f149410w;
        if (vVar != null) {
            vVar.f151253b.f151289o = i3;
        }
    }

    public final void a(a aVar) {
        try {
            this.W.put(aVar);
        } catch (InterruptedException e16) {
            LogUtil.b(e16.getMessage(), e16);
            Thread.currentThread().interrupt();
        }
    }

    @Deprecated
    private void b(int i3, int i16, int i17) {
        tk tkVar = this.f149396i;
        if (tkVar == null) {
            return;
        }
        tkVar.a(i3, i16, i17);
    }

    @Override // com.tencent.mapsdk.internal.bf
    public final ae a() {
        return this.f149398k;
    }

    private void a(Rect rect) {
        Rect rect2 = this.f149405r;
        if (rect2 == null || rect == null) {
            return;
        }
        this.F = rect;
        int width = rect2.width();
        int height = this.f149405r.height();
        int i3 = rect.left;
        int i16 = rect.bottom;
        a(i3, i16, (width - rect.right) - i3, (height - i16) - rect.top, true);
    }

    public final void b(int i3, int i16) {
        tk tkVar = this.f149396i;
        if (tkVar != null) {
            tkVar.a(i3 + 50, i16 + 50);
        }
    }

    public final void b(oz ozVar) {
        if (this.L.isEmpty()) {
            return;
        }
        this.L.remove(ozVar);
    }

    public final void b(fk fkVar) {
        if (this.B == null) {
            this.B = new c();
        }
        this.B.b(fkVar);
    }

    private void b(fd fdVar) {
        bb bbVar = this.f149402o;
        if (bbVar != null) {
            bbVar.b(fdVar);
        }
    }

    public final void a(int i3, int i16, int i17, int i18, boolean z16) {
        this.f149396i.a(i3, i16, i17, i18);
        LogUtil.a(this.N).c(lb.a.f149161h, "setViewport, leftBomX: " + i3 + ", leftBomY: " + i16 + ", visibleWidth: " + i17 + ", visibleHeight: " + i18);
        this.f149387ac = i17;
        this.f149388ad = i18;
        if (z16) {
            a(this.f149389ae, this.f149390af, this.f149391ag);
        }
    }

    public final void a(float f16, float f17, boolean z16) {
        this.f149389ae = f16;
        this.f149390af = f17;
        double d16 = f16;
        double d17 = f17;
        if (this.f149405r != null) {
            if (this.f149388ad > 0) {
                d17 = 0.5d - (((0.5d - d17) * r2.height()) / this.f149388ad);
            }
            if (this.f149387ac > 0) {
                d16 = 0.5d - (((0.5d - d16) * this.f149405r.width()) / this.f149387ac);
            }
        }
        this.f149396i.a((float) d16, (float) d17, z16);
    }

    public final boolean a(GL10 gl10) {
        int i3;
        if (this.f149396i == null) {
            return false;
        }
        Collection<nh<?>> values = this.f149400m.f147881e.values();
        if (!values.isEmpty()) {
            Iterator<nh<?>> it = values.iterator();
            while (it.hasNext()) {
                it.next().d();
            }
        }
        this.f149398k.f147732o.g();
        if (this.W.size() != 0) {
            boolean z16 = true;
            while (z16) {
                a poll = this.W.poll();
                if (poll != null) {
                    try {
                        poll.a(gl10);
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                } else {
                    z16 = false;
                }
            }
        }
        tk tkVar = this.f149396i;
        tkVar.a(new tk.AnonymousClass7());
        tk tkVar2 = this.f149396i;
        tk.AnonymousClass8 anonymousClass8 = new tk.AnonymousClass8();
        Boolean bool = Boolean.FALSE;
        boolean z17 = ((Boolean) tkVar2.a((CallbackRunnable<tk.AnonymousClass8>) anonymousClass8, (tk.AnonymousClass8) bool)).booleanValue() || this.f149412y;
        if (z17) {
            g c16 = this.f149409v.c();
            if (c16 == null) {
                this.f149400m.f147879c.f147871j.a(gl10);
            } else if (this.f149409v != null && this.f149396i.h()) {
                this.f149409v.a(gl10, this.f149401n);
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            tk tkVar3 = this.f149396i;
            ((Boolean) tkVar3.a((CallbackRunnable<tk.AnonymousClass103>) new tk.AnonymousClass103(), (tk.AnonymousClass103) bool)).booleanValue();
            this.f149412y = false;
            if (!this.f149402o.N()) {
                long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
                Object c17 = lc.c(lb.f149153ab, "nativeTotalTime", this.N);
                long longValue = c17 != null ? ((Long) c17).longValue() : 0L;
                lc.a(lb.f149153ab, "nativeTime", Long.valueOf(elapsedRealtime2), this.N);
                lc.a(lb.f149153ab, "nativeTotalTime", Long.valueOf(longValue + elapsedRealtime2), this.N);
                lc.d(lb.f149153ab, this.N);
            }
            if (!this.f149409v.b() && c16 != null) {
                if (!c16.c()) {
                    if (!this.f149396i.h() && (i3 = c16.f149438e) < 100) {
                        c16.f149438e = i3 + 1;
                    } else {
                        c16.f149438e = 0;
                        this.f149409v.a(gl10);
                    }
                } else {
                    c16.f149438e = 0;
                }
            }
        }
        nd ndVar = this.f149401n;
        if (ndVar != null) {
            ndVar.a();
        }
        return z17;
    }

    private void a(rt rtVar) {
        List<rt> list;
        rw rwVar = this.f149399l;
        if (rwVar == null || rtVar == null || (list = rwVar.f150154b.f150144a) == null) {
            return;
        }
        list.add(rtVar);
    }

    public final void a(boolean z16) {
        if (this.f149399l != null) {
            this.f149407t = z16;
            if (z16) {
                tk tkVar = this.f149396i;
                if (tkVar != null) {
                    tkVar.a(new tk.AnonymousClass117());
                }
                rw rwVar = this.f149399l;
                ne neVar = rwVar.f150153a;
                if (neVar != null) {
                    neVar.f149398k.a(rwVar);
                    try {
                        rwVar.f150154b.start();
                        return;
                    } catch (Exception unused) {
                        return;
                    }
                }
                return;
            }
            tk tkVar2 = this.f149396i;
            if (tkVar2 != null) {
                tkVar2.a(new tk.AnonymousClass118());
            }
            this.f149399l.b();
        }
    }

    private void a(int[] iArr, int i3, boolean z16) {
        tk tkVar = this.f149396i;
        if (tkVar == null || iArr == null || i3 == 0) {
            return;
        }
        tkVar.a(new tk.AnonymousClass148(iArr, i3, z16));
    }

    private void a(int[] iArr, int i3) {
        tk tkVar = this.f149396i;
        if (tkVar == null || iArr == null || i3 == 0) {
            return;
        }
        tkVar.a(iArr, i3);
    }

    public final int a(PolygonInfo polygonInfo) {
        tk tkVar = this.f149396i;
        if (tkVar == null || polygonInfo == null) {
            return -1;
        }
        int i3 = 0;
        int intValue = ((Integer) tkVar.a((CallbackRunnable<tk.AnonymousClass57>) new tk.AnonymousClass57(polygonInfo), (tk.AnonymousClass57) 0)).intValue();
        if (this.Y == null) {
            this.Y = new lm<>();
        }
        if (this.Z == null) {
            this.Z = new lm<>();
        }
        this.Y.a(Integer.valueOf(intValue), Integer.valueOf(polygonInfo.borderLineId));
        ArrayList arrayList = new ArrayList();
        while (true) {
            int[] iArr = polygonInfo.holeLineIds;
            if (i3 < iArr.length) {
                arrayList.add(Integer.valueOf(iArr[i3]));
                i3++;
            } else {
                this.Z.a(Integer.valueOf(intValue), arrayList);
                return intValue;
            }
        }
    }

    private void a(int i3, boolean z16) {
        lm<Integer, Integer> lmVar;
        if (this.f149396i == null || (lmVar = this.Y) == null) {
            return;
        }
        Integer a16 = lmVar.a((lm<Integer, Integer>) Integer.valueOf(i3));
        int intValue = a16 != null ? a16.intValue() : 0;
        lm<Integer, List<Integer>> lmVar2 = this.Z;
        if (lmVar2 != null) {
            List<Integer> a17 = lmVar2.a((lm<Integer, List<Integer>>) Integer.valueOf(i3));
            int[] iArr = new int[0];
            if (a17 != null) {
                iArr = new int[a17.size()];
                for (int i16 = 0; i16 < a17.size(); i16++) {
                    iArr[i16] = a17.get(i16).intValue();
                }
            }
            tk tkVar = this.f149396i;
            tkVar.a(new tk.AnonymousClass104(i3, intValue, z16, iArr));
        }
    }

    public final void a(int i3) {
        lm<Integer, Integer> lmVar;
        if (this.f149396i == null || (lmVar = this.Y) == null) {
            return;
        }
        Integer a16 = lmVar.a((lm<Integer, Integer>) Integer.valueOf(i3));
        int intValue = a16 != null ? a16.intValue() : 0;
        lm<Integer, List<Integer>> lmVar2 = this.Z;
        if (lmVar2 != null) {
            List<Integer> a17 = lmVar2.a((lm<Integer, List<Integer>>) Integer.valueOf(i3));
            int[] iArr = new int[0];
            if (a17 != null) {
                iArr = new int[a17.size()];
                for (int i16 = 0; i16 < a17.size(); i16++) {
                    iArr[i16] = a17.get(i16).intValue();
                }
            }
            tk tkVar = this.f149396i;
            tkVar.a(new tk.AnonymousClass105(i3, intValue, iArr));
        }
    }

    private Circle a(CircleOptions circleOptions) {
        bj bjVar = this.M;
        if (bjVar == null) {
            return null;
        }
        return bjVar.a(circleOptions);
    }

    public final Polyline a(PolylineOptions polylineOptions) {
        bj bjVar = this.M;
        if (bjVar == null || polylineOptions == null) {
            return null;
        }
        return bjVar.a(polylineOptions);
    }

    private Marker a(MarkerOptions markerOptions) {
        bj bjVar = this.M;
        if (bjVar == null || markerOptions == null) {
            return null;
        }
        return bjVar.a(markerOptions);
    }

    private int a(int i3, int i16, int i17, int i18, int i19, float f16) {
        if (this.f149396i == null) {
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
        Rect rect = this.f149405r;
        if (rect != null) {
            maskLayer.width = rect.width();
            maskLayer.height = this.f149405r.height();
        }
        maskLayer.zIndex = f16;
        maskLayer.layer = i19;
        tk tkVar = this.f149396i;
        return ((Integer) tkVar.a((CallbackRunnable<tk.AnonymousClass106>) new tk.AnonymousClass106(maskLayer), (tk.AnonymousClass106) 0)).intValue();
    }

    private void a(List<MapRouteSection> list, List<GeoPoint> list2) {
        if (this.C == null) {
            this.C = new d();
        }
        d dVar = this.C;
        dVar.f149425a = list;
        dVar.f149426b = list2;
        ne.this.f149396i.a(list, list2);
    }

    private AnnocationTextResult a(AnnocationText annocationText) {
        tk tkVar = this.f149396i;
        return (AnnocationTextResult) tkVar.a(new tk.AnonymousClass30(annocationText), (tk.AnonymousClass30) null);
    }

    public final void a(fy fyVar) {
        ng<?> a16;
        if (this.f149400m != null) {
            oe b16 = b(fyVar);
            bk bkVar = this.f149400m;
            int i3 = fyVar.f148389a;
            nh<?> nhVar = bkVar.f147881e.get(b16.getClass());
            if (nhVar == null || (a16 = nhVar.a(i3)) == null) {
                return;
            }
            a16.a((ng<?>) b16);
            nhVar.a(a16);
        }
    }

    private List<Integer> a(Rect rect, int i3) {
        tk tkVar = this.f149396i;
        return (List) tkVar.a(new tk.AnonymousClass31(rect, i3), (tk.AnonymousClass31) null);
    }

    public final String a(GeoPoint geoPoint) {
        tk tkVar = this.f149396i;
        return tkVar == null ? "" : tkVar.a(geoPoint);
    }

    public final void a(String str) {
        tk tkVar = this.f149396i;
        if (tkVar == null || tkVar.f150515e == 0) {
            return;
        }
        tkVar.a(new tk.AnonymousClass38(str));
    }

    private void a(fb fbVar, int i3, int i16, fr frVar) {
        Rect bound = fbVar.getBound(this.f149403p);
        if (bound == null || i3 <= 0 || i16 <= 0 || frVar == null) {
            return;
        }
        this.f149409v.a(fbVar, bound, frVar, i3, i16);
    }

    private void a(fb fbVar, Rect rect, int i3, int i16, fr frVar) {
        if (fbVar == null || rect == null || i3 <= 0 || i16 <= 0 || frVar == null) {
            return;
        }
        this.f149409v.a(fbVar, rect, frVar, i3, i16);
    }

    private void a(Rect rect, int i3, int i16, fr frVar) {
        if (rect == null || i3 <= 0 || i16 <= 0 || frVar == null) {
            return;
        }
        this.f149409v.a(null, rect, frVar, i3, i16);
    }

    private void a(List<LatLngBounds> list) {
        tk tkVar = this.f149396i;
        if (tkVar != null) {
            tkVar.a(list);
        }
    }

    private void a(int i3, int i16, int i17, int i18) {
        tk tkVar = this.f149396i;
        if (tkVar != null) {
            tkVar.a(new tk.AnonymousClass23(i16, i3, i17, i18));
        }
    }

    public final void a(GeoPoint geoPoint, float f16, float f17, boolean z16) {
        tk tkVar = this.f149396i;
        if (tkVar != null) {
            tkVar.a(geoPoint, f16, f17, z16);
        }
    }

    public final void a(boolean z16, boolean z17) {
        tk tkVar = this.f149396i;
        if (tkVar == null || 0 == tkVar.f150515e || tkVar.f150520j == null) {
            return;
        }
        tkVar.a(new tk.AnonymousClass141(false, z16, false, z17));
    }

    public final void a(float f16) {
        tk tkVar = this.f149396i;
        if (tkVar != null) {
            tkVar.a(f16);
        }
    }

    private void a(Rect rect, Rect rect2, boolean z16) {
        tk tkVar = this.f149396i;
        if (tkVar != null) {
            tkVar.a(rect, rect2, z16);
        }
    }

    public final void a(String[] strArr) {
        tk tkVar = this.f149396i;
        if (tkVar == null || tkVar.f150515e == 0) {
            return;
        }
        tkVar.a(new tk.AnonymousClass170(strArr));
    }

    public final int a(String str, float f16, float f17) {
        tk tkVar = this.f149396i;
        if (tkVar != null) {
            return tkVar.a(str, f16, f17);
        }
        return 0;
    }

    public final void a(String str, String str2, String str3, String str4, String str5) {
        tk tkVar = this.f149396i;
        if (tkVar != null) {
            tkVar.a(str, str2, str3, str4, str5);
        }
    }

    public final void a(float f16, int i3, LatLng latLng) {
        tk tkVar = this.f149396i;
        if (tkVar != null) {
            tkVar.a(f16, i3, latLng);
        }
    }

    private void a(GeoPoint geoPoint, RectF rectF, boolean z16) {
        ne neVar;
        Rect rect;
        if (rectF != null && (rect = this.F) != null) {
            rectF.left -= rect.left;
            rectF.top -= rect.top;
            rectF.right -= rect.right;
            rectF.bottom -= rect.bottom;
        }
        tk tkVar = this.f149396i;
        if (tkVar != null) {
            int i3 = this.H;
            int i16 = this.G;
            if (0 == tkVar.f150515e || (neVar = tkVar.f150520j) == null) {
                return;
            }
            neVar.a(new tk.AnonymousClass4(rectF, geoPoint, i3, i16, z16));
        }
    }

    private void a(int i3, int i16, int i17) {
        tk tkVar = this.f149396i;
        if (tkVar == null || 0 == tkVar.f150515e || tkVar.f150520j == null) {
            return;
        }
        tkVar.a(new tk.AnonymousClass187(i3, i16, i17));
    }

    public final void a(ox oxVar) {
        tk tkVar = this.f149396i;
        if (tkVar != null) {
            tkVar.f150519i = oxVar;
        }
    }

    @Deprecated
    private int a(TileOverlayCallback tileOverlayCallback, boolean z16, boolean z17) {
        tk tkVar = this.f149396i;
        if (tkVar != null) {
            return tkVar.a(tileOverlayCallback, z16, z17);
        }
        return -1;
    }

    private void a(oy oyVar) {
        tk tkVar = this.f149396i;
        if (tkVar != null) {
            tkVar.f150514d.setMapCallbackGetGLContext(oyVar);
        }
    }

    public final void a(int i3, int i16) {
        tk tkVar = this.f149396i;
        if (tkVar != null) {
            tkVar.a(new tk.AnonymousClass25(i3, i16));
        }
    }

    private void a(int i3, float f16) {
        tk tkVar = this.f149396i;
        if (tkVar != null) {
            tkVar.a(i3, f16);
        }
    }

    private void a(Language language) {
        if (this.B == null) {
            this.B = new c();
        }
        c cVar = this.B;
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
    }

    public final void a(fk fkVar) {
        if (this.B == null) {
            this.B = new c();
        }
        this.B.a(fkVar);
    }

    public final void a(oz ozVar) {
        List<oz> list = this.L;
        if (list != null) {
            list.add(ozVar);
        }
    }

    public final TappedElement a(float f16, float f17) {
        tk tkVar = this.f149396i;
        if (tkVar != null) {
            return tkVar.a(f16, f17);
        }
        return null;
    }

    private float a(double d16, GeoPoint geoPoint) {
        fa faVar;
        if (geoPoint != null && this.f149410w != null && (faVar = this.f149403p) != null) {
            double metersPerPixel = faVar.metersPerPixel(geoPoint.getLatitudeE6() / 1000000.0d);
            if (metersPerPixel != 0.0d) {
                return (float) (d16 / metersPerPixel);
            }
        }
        return 0.0f;
    }

    private void a(CustomRender customRender) {
        this.I = customRender;
        this.f149412y = true;
    }

    private VectorHeatOverlay a(VectorHeatOverlayOptions vectorHeatOverlayOptions) {
        if (this.f149396i == null) {
            return null;
        }
        hi hiVar = this.f147918e;
        if (hiVar != null) {
            hiVar.h().a();
        }
        return (VectorHeatOverlay) this.f149400m.a((bk) new nl(vectorHeatOverlayOptions));
    }

    public final <V extends VectorOverlay> V a(VectorOverlayProvider vectorOverlayProvider) {
        if (this.f149396i == null) {
            return null;
        }
        if (vectorOverlayProvider instanceof AggregationOverlayProvider) {
            hi hiVar = this.f147918e;
            if (hiVar != null) {
                hiVar.h().a();
            }
            return (nk) this.f149400m.a((bk) new nl((AggregationOverlayProvider) vectorOverlayProvider));
        }
        if (vectorOverlayProvider instanceof GradientVectorOverlayProvider) {
            hi hiVar2 = this.f147918e;
            if (hiVar2 != null) {
                hiVar2.i().f148621a++;
            }
            return (nw) this.f149400m.a((bk) new ny((GradientVectorOverlayProvider) vectorOverlayProvider));
        }
        if (vectorOverlayProvider instanceof ArcLineOverlayProvider) {
            hi hiVar3 = this.f147918e;
            if (hiVar3 != null) {
                hiVar3.j().f148593a++;
            }
            return (nn) this.f149400m.a((bk) new np((ArcLineOverlayProvider) vectorOverlayProvider));
        }
        if (vectorOverlayProvider instanceof DotScatterPlotOverlayProvider) {
            hi hiVar4 = this.f147918e;
            if (hiVar4 != null) {
                hiVar4.k().f148605a++;
            }
            return (of) this.f149400m.a((bk) new oh(this.f149396i.A(), (DotScatterPlotOverlayProvider) vectorOverlayProvider));
        }
        if (vectorOverlayProvider instanceof BitmapScatterPlotOverlayProvider) {
            hi hiVar5 = this.f147918e;
            if (hiVar5 != null) {
                hiVar5.l().f148600a++;
            }
            return (of) this.f149400m.a((bk) new oh(this.f149396i.A(), (BitmapScatterPlotOverlayProvider) vectorOverlayProvider));
        }
        if (vectorOverlayProvider instanceof TrailOverlayProvider) {
            hi hiVar6 = this.f147918e;
            if (hiVar6 != null) {
                hiVar6.m().f148682a++;
            }
            return (oi) this.f149400m.a((bk) new ok((TrailOverlayProvider) vectorOverlayProvider));
        }
        if (!(vectorOverlayProvider instanceof GLModelOverlayProvider)) {
            return null;
        }
        hi hiVar7 = this.f147918e;
        if (hiVar7 != null) {
            hiVar7.n().f148606a++;
        }
        return (ns) this.f149400m.a((bk) new nr((GLModelOverlayProvider) vectorOverlayProvider));
    }

    private void a(VectorOverlay vectorOverlay, VectorOverlayProvider vectorOverlayProvider) {
        if (this.f149396i == null) {
            return;
        }
        if (vectorOverlayProvider instanceof AggregationOverlayProvider) {
            nk nkVar = (nk) this.f149400m.a(nk.class, ((nk) vectorOverlay).b());
            if (nkVar != null) {
                nkVar.a((nk) new nl((AggregationOverlayProvider) vectorOverlayProvider));
                return;
            } else {
                a(vectorOverlayProvider);
                return;
            }
        }
        if (vectorOverlayProvider instanceof GradientVectorOverlayProvider) {
            nw nwVar = (nw) this.f149400m.a(nw.class, ((nw) vectorOverlay).b());
            if (nwVar != null) {
                nwVar.a((nw) new ny((GradientVectorOverlayProvider) vectorOverlayProvider));
                return;
            } else {
                a(vectorOverlayProvider);
                return;
            }
        }
        if (vectorOverlayProvider instanceof ArcLineOverlayProvider) {
            nn nnVar = (nn) this.f149400m.a(nn.class, ((nn) vectorOverlay).b());
            if (nnVar != null) {
                nnVar.a((nn) new np((ArcLineOverlayProvider) vectorOverlayProvider));
                return;
            } else {
                a(vectorOverlayProvider);
                return;
            }
        }
        if (vectorOverlayProvider instanceof DotScatterPlotOverlayProvider) {
            of ofVar = (of) this.f149400m.a(of.class, ((of) vectorOverlay).b());
            if (ofVar != null) {
                ofVar.a((of) new oh(this.f149396i.A(), (DotScatterPlotOverlayProvider) vectorOverlayProvider));
                return;
            } else {
                a(vectorOverlayProvider);
                return;
            }
        }
        if (vectorOverlayProvider instanceof BitmapScatterPlotOverlayProvider) {
            of ofVar2 = (of) this.f149400m.a(of.class, ((of) vectorOverlay).b());
            if (ofVar2 != null) {
                ofVar2.a((of) new oh(this.f149396i.A(), (BitmapScatterPlotOverlayProvider) vectorOverlayProvider));
                return;
            } else {
                a(vectorOverlayProvider);
                return;
            }
        }
        if (vectorOverlayProvider instanceof TrailOverlayProvider) {
            oi oiVar = (oi) this.f149400m.a(oi.class, ((oi) vectorOverlay).b());
            if (oiVar != null) {
                oiVar.a((oi) new ok((TrailOverlayProvider) vectorOverlayProvider));
                return;
            } else {
                a(vectorOverlayProvider);
                return;
            }
        }
        if (vectorOverlayProvider instanceof GLModelOverlayProvider) {
            ns nsVar = (ns) this.f149400m.a(ns.class, ((ns) vectorOverlay).b());
            if (nsVar != null) {
                nsVar.a((ns) new nr((GLModelOverlayProvider) vectorOverlayProvider));
            } else {
                a(vectorOverlayProvider);
            }
        }
    }

    private GroundOverlay a(GroundOverlayOptions groundOverlayOptions) {
        if (this.f149396i == null) {
            return null;
        }
        hi hiVar = this.f147918e;
        if (hiVar != null) {
            hiVar.o().f148620a++;
        }
        return (GroundOverlay) this.f149400m.a((bk) new nv(this.f149396i.A(), groundOverlayOptions));
    }

    private IntersectionOverlay a(IntersectionOverlayOptions intersectionOverlayOptions) {
        if (this.f149396i == null) {
            return null;
        }
        return (IntersectionOverlay) this.f149400m.a((bk) new ob(intersectionOverlayOptions));
    }

    private void a(OverSeaTileProvider overSeaTileProvider) {
        bb bbVar = this.f149402o;
        if (bbVar == null) {
            return;
        }
        bbVar.a(overSeaTileProvider);
    }

    private void a(TrafficStyle trafficStyle) {
        tk tkVar = this.f149396i;
        if (tkVar == null) {
            return;
        }
        tkVar.a(trafficStyle);
    }

    private void a(fd fdVar) {
        bb bbVar = this.f149402o;
        if (bbVar != null) {
            bbVar.a(fdVar);
        }
    }

    public final void a(String str, String str2) {
        tk tkVar = this.f149396i;
        if (tkVar == null) {
            return;
        }
        tkVar.a(str, str2);
    }

    public final void a(LatLngBounds latLngBounds, int i3) {
        if (this.f149396i == null) {
            return;
        }
        if (latLngBounds != null && !latLngBounds.isEmptySpan()) {
            this.f149396i.a(new double[]{latLngBounds.getLonWest(), latLngBounds.getLatSouth(), latLngBounds.getLonEast(), latLngBounds.getLatNorth()}, new double[]{0.0d, 0.0d, this.f149387ac, this.f149388ad}, i3);
        } else {
            this.f149396i.a((double[]) null, (double[]) null, 0);
        }
    }

    private void a(pb pbVar) {
        this.J = pbVar;
    }

    private void a(TencentMap.OnVectorOverlayClickListener onVectorOverlayClickListener) {
        this.O = onVectorOverlayClickListener;
    }

    private boolean a(float f16, float f17, fd fdVar) {
        tk tkVar;
        if (this.P == null) {
            nh<?> nhVar = this.f149400m.f147881e.get(nr.class);
            if ((nhVar != null ? nhVar.f() : false) && (tkVar = this.f149396i) != null) {
                tkVar.f150514d.scheduleClickOnNextRender(tkVar.f150515e, f16, f17);
                this.P = fdVar;
                return true;
            }
        }
        this.P = null;
        return false;
    }

    private void a(float f16, float f17, long j3, String str, String str2) {
        Pair<VectorOverlay, TencentMap.IClickedObject> pair;
        TencentMap.OnVectorOverlayClickListener onVectorOverlayClickListener;
        if (j3 > 0) {
            LatLng fromScreenLocation = this.f149403p.fromScreenLocation(new Point((int) f16, (int) f17));
            nh<?> nhVar = this.f149400m.f147881e.get(nr.class);
            if (nhVar != null) {
                pair = nhVar.a(fromScreenLocation, j3, str, str2);
            } else {
                pair = new Pair<>(null, null);
            }
            Object obj = pair.first;
            if (obj != null && (onVectorOverlayClickListener = this.O) != null) {
                onVectorOverlayClickListener.onClicked((VectorOverlay) obj, (TencentMap.IClickedObject) pair.second);
            }
        } else {
            this.P.b(f16, f17);
        }
        this.P = null;
    }
}
