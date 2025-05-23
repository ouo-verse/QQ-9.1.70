package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.map.lib.models.PolygonInfo;
import com.tencent.map.tools.Callback;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.mapsdk.internal.ee;
import com.tencent.mapsdk.internal.fu;
import com.tencent.mapsdk.internal.kp;
import com.tencent.mapsdk.internal.px;
import com.tencent.tencentmap.mapsdk.maps.model.AoiLayer;
import com.tencent.tencentmap.mapsdk.maps.model.AoiLayerOptions;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import com.tencent.tencentmap.mapsdk.maps.model.SubPoi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class pw implements AoiLayer {

    /* renamed from: c, reason: collision with root package name */
    private static final String f149669c = AoiLayer.class.getSimpleName();

    /* renamed from: a, reason: collision with root package name */
    public py f149670a;

    /* renamed from: b, reason: collision with root package name */
    public px f149671b;

    /* renamed from: d, reason: collision with root package name */
    private String f149672d;

    /* renamed from: g, reason: collision with root package name */
    private boolean f149675g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f149676h;

    /* renamed from: j, reason: collision with root package name */
    private int[] f149678j;

    /* renamed from: k, reason: collision with root package name */
    private int[] f149679k;

    /* renamed from: l, reason: collision with root package name */
    private AoiLayer.OnAoiLayerLoadListener f149680l;

    /* renamed from: e, reason: collision with root package name */
    private int f149673e = 20;

    /* renamed from: f, reason: collision with root package name */
    private int f149674f = -1;

    /* renamed from: i, reason: collision with root package name */
    private boolean f149677i = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.pw$3, reason: invalid class name */
    /* loaded from: classes9.dex */
    public final class AnonymousClass3 extends kp.a<Object> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f149683a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ List f149684b;

        AnonymousClass3(List list, List list2) {
            this.f149683a = list;
            this.f149684b = list2;
        }

        @Override // com.tencent.mapsdk.internal.kp.a, com.tencent.map.tools.Callback
        public final void callback(Object obj) {
            if (pw.this.f149676h) {
                return;
            }
            int size = this.f149683a.size();
            int size2 = this.f149684b.size();
            if (size != size2) {
                LogUtil.d(pw.f149669c, "PoiLayer\u7684\u5b50\u70b9\u6e32\u67d3\u7f3a\u5931\uff01\uff01count:" + size2 + "/" + size);
            }
            pw.a(pw.this, this.f149684b);
            if (pw.this.f149680l != null) {
                pw.this.f149680l.onAoiLayerLoaded(true, pw.this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.pw$4, reason: invalid class name */
    /* loaded from: classes9.dex */
    public final class AnonymousClass4 extends kp.g<Object> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f149686a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ List f149687b;

        AnonymousClass4(List list, List list2) {
            this.f149686a = list;
            this.f149687b = list2;
        }

        @Override // java.util.concurrent.Callable
        public final Object call() throws Exception {
            if (pw.this.f149676h) {
                return null;
            }
            pw.a(pw.this, this.f149686a, new Callback<px.d>() { // from class: com.tencent.mapsdk.internal.pw.4.1
                private void a(px.d dVar) {
                    if (dVar != null) {
                        AnonymousClass4.this.f149687b.add(dVar);
                    }
                }

                @Override // com.tencent.map.tools.Callback
                public final /* synthetic */ void callback(px.d dVar) {
                    px.d dVar2 = dVar;
                    if (dVar2 != null) {
                        AnonymousClass4.this.f149687b.add(dVar2);
                    }
                }
            });
            return null;
        }
    }

    public pw(py pyVar, String str, AoiLayerOptions aoiLayerOptions, AoiLayer.OnAoiLayerLoadListener onAoiLayerLoadListener) {
        this.f149670a = pyVar;
        this.f149672d = str;
        this.f149680l = onAoiLayerLoadListener;
        a(aoiLayerOptions);
    }

    static /* synthetic */ boolean e(pw pwVar) {
        pwVar.f149675g = false;
        return false;
    }

    static /* synthetic */ px f(pw pwVar) {
        ne neVar;
        String str = f149669c;
        LogUtil.c(str, "\u8bf7\u6c42poiDetail[" + pwVar.f149672d + "]");
        py pyVar = pwVar.f149670a;
        if (pyVar != null && (neVar = pyVar.f149722b) != null) {
            NetResponse poiDetail = ((dd) ((ds) cr.a(ds.class)).i()).poiDetail(pwVar.f149672d, neVar.D().f147925a);
            poiDetail.charset = "UTF-8";
            ee.a aVar = new ee.a(poiDetail, px.class);
            LogUtil.c(str, "poiDetail[" + pwVar.f149672d + "] resp:" + aVar.available());
            if (aVar.available()) {
                return (px) aVar.f148152b;
            }
            return null;
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof pw)) {
            return false;
        }
        String str = this.f149672d;
        String str2 = ((pw) obj).f149672d;
        if (str != null) {
            return str.equals(str2);
        }
        if (str2 == null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.AoiLayer, com.tencent.tencentmap.mapsdk.maps.model.IOverlay
    public final String getId() {
        return this.f149672d;
    }

    public final int hashCode() {
        String str = this.f149672d;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.AoiLayer
    public final LatLng location() {
        px.d dVar;
        px pxVar = this.f149671b;
        if (pxVar != null && (dVar = pxVar.f149690a) != null) {
            return dVar.f149706h;
        }
        return null;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.AoiLayer
    public final String name() {
        px.d dVar;
        px pxVar = this.f149671b;
        if (pxVar != null && (dVar = pxVar.f149690a) != null) {
            return dVar.f149701c;
        }
        return null;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.AoiLayer
    public final boolean remove() {
        ne neVar;
        boolean z16;
        ng a16;
        py pyVar = this.f149670a;
        if (pyVar == null || this.f149676h || (neVar = pyVar.f149722b) == null) {
            return false;
        }
        int[] iArr = this.f149679k;
        if (iArr != null) {
            for (int i3 : iArr) {
                bk bkVar = neVar.f149400m;
                if (bkVar != null && (a16 = bkVar.a((Class<ng>) oc.class, i3)) != null) {
                    a16.remove();
                }
            }
            this.f149679k = null;
            z16 = true;
        } else {
            z16 = false;
        }
        int[] iArr2 = this.f149678j;
        if (iArr2 != null) {
            for (int i16 : iArr2) {
                neVar.a(i16);
            }
            this.f149678j = null;
            z16 = true;
        }
        this.f149671b = null;
        this.f149670a.f149721a.remove(this);
        this.f149676h = true;
        LogUtil.c(f149669c, "\u79fb\u9664poiLayer[" + this.f149672d + "]");
        return z16;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.AoiLayer
    public final void showSubPois(boolean z16) {
        px.d dVar;
        List<px.d> list;
        py pyVar;
        ne neVar;
        if (this.f149677i == z16) {
            return;
        }
        this.f149677i = z16;
        px pxVar = this.f149671b;
        if (pxVar != null && (dVar = pxVar.f149690a) != null && (list = dVar.f149708j) != null && (pyVar = this.f149670a) != null && (neVar = pyVar.f149722b) != null) {
            for (px.d dVar2 : list) {
                fy a16 = a(d(dVar2.f149704f), dVar2);
                a16.f148389a = dVar2.f149699a;
                if (!this.f149677i) {
                    a16.f148396h = "";
                }
                neVar.a(a16);
                oc ocVar = (oc) neVar.f149400m.a(oc.class, a16.f148389a);
                if (ocVar != null) {
                    oe oeVar = (oe) ocVar.f149454d;
                    oeVar.visible(this.f149677i);
                    ocVar.a((oc) oeVar);
                    LogUtil.c(f149669c, "\u663e\u793a/\u9690\u85cf\u5b50\u70b9\u6210\u529f\uff01" + dVar2.a() + "\u663e\u793a\u72b6\u6001: " + this.f149677i);
                }
            }
        }
    }

    private LatLngBounds b() {
        px pxVar = this.f149671b;
        if (pxVar != null) {
            return a(pxVar.f149690a);
        }
        return null;
    }

    private static Point[] c(List<LatLng> list) {
        if (list == null || list.isEmpty()) {
            return new Point[0];
        }
        int size = list.size();
        Point[] pointArr = new Point[size];
        for (int i3 = 0; i3 < size; i3++) {
            pointArr[i3] = GeoPoint.from(list.get(i3)).toPoint();
        }
        return pointArr;
    }

    private px.e d(List<px.e> list) {
        py pyVar;
        ne neVar;
        px.e eVar = new px.e();
        if (list == null || (pyVar = this.f149670a) == null || (neVar = pyVar.f149722b) == null) {
            return eVar;
        }
        boolean m3 = neVar.m();
        for (px.e eVar2 : list) {
            if ((m3 && eVar2.f149711c == 1) || (!m3 && eVar2.f149711c == 0)) {
                return eVar2;
            }
        }
        return eVar;
    }

    private px.c e(List<px.e> list) {
        return d(list).f149720l;
    }

    private void b(px pxVar) {
        px.d dVar;
        boolean z16;
        px.b bVar;
        List<List<LatLng>> list;
        if (pxVar == null || (dVar = pxVar.f149690a) == null) {
            return;
        }
        px.c cVar = d(dVar.f149704f).f149720l;
        px.a aVar = pxVar.f149690a.f149707i;
        String str = f149669c;
        LogUtil.c(str, "\u7ed8\u5236PoiLayer\u7684\u9762\uff0caoiStyle:" + cVar + "|poiArea:" + aVar);
        if (aVar != null && (bVar = aVar.f149693c) != null && "Polygon".equalsIgnoreCase(bVar.f149694a) && (list = aVar.f149693c.f149695b) != null) {
            a(cVar, list);
            z16 = true;
        } else {
            LogUtil.d(str, "PoiLayer\u7684\u9762\u6e32\u67d3\u5931\u8d25\uff01");
            z16 = false;
        }
        this.f149671b = pxVar;
        if (!z16) {
            AoiLayer.OnAoiLayerLoadListener onAoiLayerLoadListener = this.f149680l;
            if (onAoiLayerLoadListener != null) {
                onAoiLayerLoadListener.onAoiLayerLoaded(false, this);
                return;
            }
            return;
        }
        List<px.d> list2 = pxVar.f149690a.f149708j;
        ArrayList arrayList = new ArrayList();
        LogUtil.c(str, "\u7ed8\u5236PoiLayer\u7684\u5b50\u70b9\uff0cremotePois:".concat(String.valueOf(list2)));
        kp.a((kp.g) new AnonymousClass4(list2, arrayList)).a((kp.b.a) null, (kp.a<kp.b.a>) new AnonymousClass3(list2, arrayList));
    }

    public final void a(AoiLayerOptions aoiLayerOptions) {
        if (aoiLayerOptions != null) {
            if (aoiLayerOptions.getMaxLevel() != -1) {
                this.f149673e = aoiLayerOptions.getMaxLevel();
            }
            if (aoiLayerOptions.getMinLevel() != -1) {
                this.f149674f = aoiLayerOptions.getMinLevel();
            }
        }
        if (this.f149675g) {
            return;
        }
        LogUtil.c(f149669c, "\u5f00\u59cb\u66f4\u65b0POI[" + this.f149672d + "]\u7684\u8be6\u60c5\u6570\u636e");
        this.f149675g = true;
        kp.a((kp.g) new kp.g<px>() { // from class: com.tencent.mapsdk.internal.pw.2
            private px a() throws Exception {
                if (pw.this.f149676h) {
                    return null;
                }
                return pw.f(pw.this);
            }

            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() throws Exception {
                if (pw.this.f149676h) {
                    return null;
                }
                return pw.f(pw.this);
            }
        }).a((kp.b.a) null, (kp.a<kp.b.a>) new kp.a<px>() { // from class: com.tencent.mapsdk.internal.pw.1
            private void a(px pxVar) {
                LogUtil.c(pw.f149669c, "POI[" + pw.this.f149672d + "]\u7684\u8be6\u60c5\u6570\u636e\uff1a" + pxVar);
                if (pxVar != null && !pw.this.f149676h) {
                    if (pw.this.f149674f < 0) {
                        pw pwVar = pw.this;
                        pwVar.f149674f = pw.a(pwVar, pxVar);
                    }
                    pw.b(pw.this, pxVar);
                } else if (pw.this.f149680l != null) {
                    pw.this.f149680l.onAoiLayerLoaded(false, pw.this);
                }
                pw.e(pw.this);
                LogUtil.c(pw.f149669c, "\u7ed3\u675fPOI[" + pw.this.f149672d + "]\u8be6\u60c5\u6570\u636e\u7684\u66f4\u65b0");
            }

            @Override // com.tencent.mapsdk.internal.kp.a, com.tencent.map.tools.Callback
            public final /* synthetic */ void callback(Object obj) {
                px pxVar = (px) obj;
                LogUtil.c(pw.f149669c, "POI[" + pw.this.f149672d + "]\u7684\u8be6\u60c5\u6570\u636e\uff1a" + pxVar);
                if (pxVar != null && !pw.this.f149676h) {
                    if (pw.this.f149674f < 0) {
                        pw pwVar = pw.this;
                        pwVar.f149674f = pw.a(pwVar, pxVar);
                    }
                    pw.b(pw.this, pxVar);
                } else if (pw.this.f149680l != null) {
                    pw.this.f149680l.onAoiLayerLoaded(false, pw.this);
                }
                pw.e(pw.this);
                LogUtil.c(pw.f149669c, "\u7ed3\u675fPOI[" + pw.this.f149672d + "]\u8be6\u60c5\u6570\u636e\u7684\u66f4\u65b0");
            }
        });
    }

    @WorkerThread
    private px c() {
        ne neVar;
        String str = f149669c;
        LogUtil.c(str, "\u8bf7\u6c42poiDetail[" + this.f149672d + "]");
        py pyVar = this.f149670a;
        if (pyVar == null || (neVar = pyVar.f149722b) == null) {
            return null;
        }
        NetResponse poiDetail = ((dd) ((ds) cr.a(ds.class)).i()).poiDetail(this.f149672d, neVar.D().f147925a);
        poiDetail.charset = "UTF-8";
        ee.a aVar = new ee.a(poiDetail, px.class);
        LogUtil.c(str, "poiDetail[" + this.f149672d + "] resp:" + aVar.available());
        if (aVar.available()) {
            return (px) aVar.f148152b;
        }
        return null;
    }

    private int a(px pxVar) {
        ne neVar;
        LatLngBounds a16;
        py pyVar = this.f149670a;
        if (pyVar == null || (neVar = pyVar.f149722b) == null || pxVar == null || (a16 = a(pxVar.f149690a)) == null) {
            return 0;
        }
        return ((int) neVar.f149403p.a(a16.getSouthWest(), a16.getNorthEast(), 0, 0, 0, 0, null)) - 2;
    }

    private void a(px.c cVar, List<List<LatLng>> list) {
        ne neVar;
        py pyVar = this.f149670a;
        if (pyVar == null || (neVar = pyVar.f149722b) == null) {
            return;
        }
        int i3 = 0;
        if (this.f149678j == null) {
            this.f149678j = new int[list.size()];
            Iterator<List<LatLng>> it = list.iterator();
            while (it.hasNext()) {
                PolygonInfo b16 = b(cVar, it.next());
                if (!this.f149676h) {
                    int i16 = i3 + 1;
                    this.f149678j[i3] = neVar.a(b16);
                    LogUtil.c(f149669c, "\u6dfb\u52a0PoiLayer\u6210\u529f,ID=" + this.f149678j[i16 - 1] + "|model:" + b16);
                    i3 = i16;
                }
            }
            return;
        }
        Iterator<List<LatLng>> it5 = list.iterator();
        while (it5.hasNext()) {
            PolygonInfo b17 = b(cVar, it5.next());
            int i17 = i3 + 1;
            b17.polygonId = this.f149678j[i3];
            if (!this.f149676h) {
                neVar.b(b17);
                LogUtil.c(f149669c, "\u66f4\u65b0PoiLayer\u6210\u529f");
            }
            i3 = i17;
        }
    }

    private void b(List<px.d> list) {
        ne neVar;
        py pyVar = this.f149670a;
        if (pyVar == null || (neVar = pyVar.f149722b) == null) {
            return;
        }
        for (px.d dVar : list) {
            fy a16 = a(d(dVar.f149704f), dVar);
            a16.f148389a = dVar.f149699a;
            if (!this.f149677i) {
                a16.f148396h = "";
            }
            neVar.a(a16);
            oc ocVar = (oc) neVar.f149400m.a(oc.class, a16.f148389a);
            if (ocVar != null) {
                oe oeVar = (oe) ocVar.f149454d;
                oeVar.visible(this.f149677i);
                ocVar.a((oc) oeVar);
                LogUtil.c(f149669c, "\u663e\u793a/\u9690\u85cf\u5b50\u70b9\u6210\u529f\uff01" + dVar.a() + "\u663e\u793a\u72b6\u6001: " + this.f149677i);
            }
        }
    }

    private void a(List<px.d> list) {
        ne neVar;
        int i3;
        py pyVar = this.f149670a;
        if (pyVar == null || (neVar = pyVar.f149722b) == null) {
            return;
        }
        int size = list.size();
        int[] iArr = new int[size];
        int i16 = 0;
        for (px.d dVar : list) {
            fy a16 = a(d(dVar.f149704f), dVar);
            int i17 = dVar.f149699a;
            if (i17 < 0) {
                if (neVar.f149400m != null && a16.f148409u != null) {
                    oc ocVar = (oc) neVar.f149400m.a((bk) ne.b(a16));
                    if (ocVar != null) {
                        i3 = ocVar.b();
                        dVar.f149699a = i3;
                        int i18 = i16 + 1;
                        iArr[i16] = i3;
                        LogUtil.c(f149669c, "\u6dfb\u52a0\u5b50\u70b9\u6210\u529f\uff01" + dVar.a() + "|id:" + a16.f148396h);
                        i16 = i18;
                    }
                }
                i3 = -1;
                dVar.f149699a = i3;
                int i182 = i16 + 1;
                iArr[i16] = i3;
                LogUtil.c(f149669c, "\u6dfb\u52a0\u5b50\u70b9\u6210\u529f\uff01" + dVar.a() + "|id:" + a16.f148396h);
                i16 = i182;
            } else {
                a16.f148389a = i17;
                neVar.a(a16);
                LogUtil.c(f149669c, "\u66f4\u65b0\u5b50\u70b9\u6210\u529f\uff01" + dVar.a());
            }
        }
        int[] iArr2 = new int[size];
        this.f149679k = iArr2;
        System.arraycopy(iArr, 0, iArr2, 0, size);
    }

    private PolygonInfo b(px.c cVar, List<LatLng> list) {
        ne neVar;
        Context context;
        PolygonInfo polygonInfo = new PolygonInfo();
        py pyVar = this.f149670a;
        if (pyVar == null || (neVar = pyVar.f149722b) == null || (context = neVar.getContext()) == null) {
            return polygonInfo;
        }
        ht.a(context);
        polygonInfo.points = (LatLng[]) list.toArray(new LatLng[0]);
        if (cVar != null) {
            polygonInfo.borderWidth = cVar.f149698c;
            polygonInfo.borderColor = Color.parseColor(cVar.f149697b);
            polygonInfo.color = Color.parseColor(cVar.f149696a);
            polygonInfo.level = 1;
            polygonInfo.minScaleLevel = this.f149674f;
            polygonInfo.maxScaleLevel = this.f149673e;
        }
        return polygonInfo;
    }

    static /* synthetic */ void b(pw pwVar, px pxVar) {
        px.d dVar;
        boolean z16;
        px.b bVar;
        List<List<LatLng>> list;
        if (pxVar == null || (dVar = pxVar.f149690a) == null) {
            return;
        }
        px.c cVar = pwVar.d(dVar.f149704f).f149720l;
        px.a aVar = pxVar.f149690a.f149707i;
        String str = f149669c;
        LogUtil.c(str, "\u7ed8\u5236PoiLayer\u7684\u9762\uff0caoiStyle:" + cVar + "|poiArea:" + aVar);
        if (aVar != null && (bVar = aVar.f149693c) != null && "Polygon".equalsIgnoreCase(bVar.f149694a) && (list = aVar.f149693c.f149695b) != null) {
            pwVar.a(cVar, list);
            z16 = true;
        } else {
            LogUtil.d(str, "PoiLayer\u7684\u9762\u6e32\u67d3\u5931\u8d25\uff01");
            z16 = false;
        }
        pwVar.f149671b = pxVar;
        if (!z16) {
            AoiLayer.OnAoiLayerLoadListener onAoiLayerLoadListener = pwVar.f149680l;
            if (onAoiLayerLoadListener != null) {
                onAoiLayerLoadListener.onAoiLayerLoaded(false, pwVar);
                return;
            }
            return;
        }
        List<px.d> list2 = pxVar.f149690a.f149708j;
        ArrayList arrayList = new ArrayList();
        LogUtil.c(str, "\u7ed8\u5236PoiLayer\u7684\u5b50\u70b9\uff0cremotePois:".concat(String.valueOf(list2)));
        kp.a((kp.g) new AnonymousClass4(list2, arrayList)).a((kp.b.a) null, (kp.a<kp.b.a>) new AnonymousClass3(list2, arrayList));
    }

    private static LatLngBounds a(px.d dVar) {
        px.a aVar;
        px.b bVar;
        List<List<LatLng>> list;
        if (dVar != null && (aVar = dVar.f149707i) != null && (bVar = aVar.f149693c) != null && (list = bVar.f149695b) != null) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            Iterator<List<LatLng>> it = list.iterator();
            while (it.hasNext()) {
                builder.include(it.next());
            }
            try {
                return builder.build();
            } catch (Exception e16) {
                LogUtil.b(Log.getStackTraceString(e16));
            }
        }
        return null;
    }

    @WorkerThread
    private void a(List<px.d> list, Callback<px.d> callback) {
        ne neVar;
        Context context;
        ne neVar2;
        Context context2;
        py pyVar = this.f149670a;
        if (pyVar == null || (neVar = pyVar.f149722b) == null || (context = neVar.getContext()) == null || list == null || list.isEmpty()) {
            return;
        }
        for (int i3 = 0; i3 < list.size() && !this.f149676h; i3++) {
            px.d dVar = list.get(i3);
            px.e d16 = d(dVar.f149704f);
            String str = d16.f149712d;
            if (!TextUtils.isEmpty(str)) {
                new fy();
                py pyVar2 = this.f149670a;
                if (pyVar2 != null && (neVar2 = pyVar2.f149722b) != null && (context2 = neVar2.getContext()) != null) {
                    int a16 = (int) ht.a(context2);
                    str = a16 <= 1 ? str.replace("{density}", "") : a16 <= 2 ? str.replace("{density}", "@2x") : str.replace("{density}", "@3x");
                }
            }
            String str2 = f149669c;
            LogUtil.c(str2, "\u8bf7\u6c42\u5b50\u70b9[" + dVar.a() + "]icon url:" + str);
            if (!TextUtils.isEmpty(str)) {
                BitmapDescriptor createBitmapDescriptor = neVar.createBitmapDescriptor(str, 8);
                d16.f149709a = createBitmapDescriptor;
                createBitmapDescriptor.getFormater().setScale(2);
                if (d16.f149709a.getBitmap(context) != null) {
                    LogUtil.c(str2, "\u5b50\u70b9[" + dVar.a() + "]icon\u4e0b\u8f7d\u6210\u529f");
                    if (d16.f149713e == 1) {
                        fu.a aVar = new fu.a(dVar.a(), d16.f149715g, Color.parseColor(d16.f149714f));
                        aVar.f148375f = neVar.getTypeface();
                        aVar.f148374e = Color.parseColor(d16.f149716h);
                        aVar.f148373d = d16.f149717i;
                        aVar.f148376g = ht.a(context) / 2.0f;
                        BitmapDescriptor createBitmapDescriptor2 = neVar.createBitmapDescriptor(aVar, 9);
                        d16.f149710b = createBitmapDescriptor2;
                        if (createBitmapDescriptor2.getBitmap(context) != null) {
                            LogUtil.c(str2, "\u5b50\u70b9[" + dVar.a() + "]\u6587\u672c\u56fe\u7247\u521b\u5efa\u6210\u529f");
                        } else {
                            LogUtil.d(str2, "\u5b50\u70b9[" + dVar.a() + "]\u6587\u672c\u56fe\u7247\u521b\u5efa\u5931\u8d25\uff01");
                        }
                    }
                    if (callback != null) {
                        callback.callback(dVar);
                    }
                } else {
                    LogUtil.d(str2, "\u5b50\u70b9[" + dVar.a() + "]icon\u4e0b\u8f7d\u5931\u8d25\uff01");
                }
            }
        }
    }

    private String a(String str) {
        ne neVar;
        Context context;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        new fy();
        py pyVar = this.f149670a;
        if (pyVar == null || (neVar = pyVar.f149722b) == null || (context = neVar.getContext()) == null) {
            return str;
        }
        int a16 = (int) ht.a(context);
        if (a16 <= 1) {
            return str.replace("{density}", "");
        }
        if (a16 <= 2) {
            return str.replace("{density}", "@2x");
        }
        return str.replace("{density}", "@3x");
    }

    private fy a(px.e eVar, px.d dVar) {
        ne neVar;
        Context context;
        fy fyVar = new fy();
        py pyVar = this.f149670a;
        if (pyVar == null || (neVar = pyVar.f149722b) == null || (context = neVar.getContext()) == null || eVar == null) {
            return fyVar;
        }
        int i3 = eVar.f149713e;
        if (i3 == 0) {
            fyVar.f148399k = "";
        } else if (i3 == 1) {
            fyVar.f148399k = dVar.a();
            BitmapDescriptor bitmapDescriptor = eVar.f149710b;
            if (bitmapDescriptor != null) {
                fyVar.f148396h = bitmapDescriptor.getFormater().getBitmapId();
                Bitmap bitmap = bitmapDescriptor.getBitmap(context);
                if (bitmap != null) {
                    fyVar.f148397i = bitmap.getWidth();
                    fyVar.f148398j = bitmap.getHeight();
                }
            }
        }
        BitmapDescriptor bitmapDescriptor2 = eVar.f149709a;
        if (bitmapDescriptor2 == null) {
            return fyVar;
        }
        fyVar.f148390b = bitmapDescriptor2.getFormater().getBitmapId();
        Bitmap bitmap2 = bitmapDescriptor2.getBitmap(context);
        if (bitmap2 != null) {
            fyVar.f148391c = bitmap2.getWidth();
            fyVar.f148392d = bitmap2.getHeight();
        }
        fyVar.f148404p = 2;
        int i16 = eVar.f149719k;
        fyVar.f148405q = i16;
        fyVar.f148406r = ((eVar.f149718j + 1) * 10000) + i16;
        fyVar.f148409u = dVar.f149706h;
        fyVar.f148407s = this.f149674f;
        fyVar.f148408t = this.f149673e;
        fyVar.f148395g = 1.0f;
        return fyVar;
    }

    private px.d a(long j3) {
        px.d dVar;
        List<px.d> list;
        px pxVar = this.f149671b;
        if (pxVar == null || (dVar = pxVar.f149690a) == null || (list = dVar.f149708j) == null) {
            return null;
        }
        for (px.d dVar2 : list) {
            if (((oc) this.f149670a.f149722b.f149400m.a(oc.class, dVar2.f149699a)) != null && r2.a() == j3) {
                return dVar2;
            }
        }
        return null;
    }

    public static SubPoi a(String str, px.d dVar) {
        SubPoi subPoi = new SubPoi();
        subPoi.setParentId(str);
        subPoi.setId(dVar.f149700b);
        subPoi.setName(dVar.a());
        subPoi.setPosition(dVar.f149706h);
        return subPoi;
    }

    static /* synthetic */ int a(pw pwVar, px pxVar) {
        ne neVar;
        LatLngBounds a16;
        py pyVar = pwVar.f149670a;
        if (pyVar == null || (neVar = pyVar.f149722b) == null || pxVar == null || (a16 = a(pxVar.f149690a)) == null) {
            return 0;
        }
        return ((int) neVar.f149403p.a(a16.getSouthWest(), a16.getNorthEast(), 0, 0, 0, 0, null)) - 2;
    }

    static /* synthetic */ void a(pw pwVar, List list) {
        ne neVar;
        int i3;
        py pyVar = pwVar.f149670a;
        if (pyVar == null || (neVar = pyVar.f149722b) == null) {
            return;
        }
        int size = list.size();
        int[] iArr = new int[size];
        Iterator it = list.iterator();
        int i16 = 0;
        while (it.hasNext()) {
            px.d dVar = (px.d) it.next();
            fy a16 = pwVar.a(pwVar.d(dVar.f149704f), dVar);
            int i17 = dVar.f149699a;
            if (i17 < 0) {
                if (neVar.f149400m != null && a16.f148409u != null) {
                    oc ocVar = (oc) neVar.f149400m.a((bk) ne.b(a16));
                    if (ocVar != null) {
                        i3 = ocVar.b();
                        dVar.f149699a = i3;
                        int i18 = i16 + 1;
                        iArr[i16] = i3;
                        LogUtil.c(f149669c, "\u6dfb\u52a0\u5b50\u70b9\u6210\u529f\uff01" + dVar.a() + "|id:" + a16.f148396h);
                        i16 = i18;
                    }
                }
                i3 = -1;
                dVar.f149699a = i3;
                int i182 = i16 + 1;
                iArr[i16] = i3;
                LogUtil.c(f149669c, "\u6dfb\u52a0\u5b50\u70b9\u6210\u529f\uff01" + dVar.a() + "|id:" + a16.f148396h);
                i16 = i182;
            } else {
                a16.f148389a = i17;
                neVar.a(a16);
                LogUtil.c(f149669c, "\u66f4\u65b0\u5b50\u70b9\u6210\u529f\uff01" + dVar.a());
            }
        }
        int[] iArr2 = new int[size];
        pwVar.f149679k = iArr2;
        System.arraycopy(iArr, 0, iArr2, 0, size);
    }

    static /* synthetic */ void a(pw pwVar, List list, Callback callback) {
        ne neVar;
        Context context;
        ne neVar2;
        Context context2;
        py pyVar = pwVar.f149670a;
        if (pyVar == null || (neVar = pyVar.f149722b) == null || (context = neVar.getContext()) == null || list == null || list.isEmpty()) {
            return;
        }
        for (int i3 = 0; i3 < list.size() && !pwVar.f149676h; i3++) {
            px.d dVar = (px.d) list.get(i3);
            px.e d16 = pwVar.d(dVar.f149704f);
            String str = d16.f149712d;
            if (!TextUtils.isEmpty(str)) {
                new fy();
                py pyVar2 = pwVar.f149670a;
                if (pyVar2 != null && (neVar2 = pyVar2.f149722b) != null && (context2 = neVar2.getContext()) != null) {
                    int a16 = (int) ht.a(context2);
                    str = a16 <= 1 ? str.replace("{density}", "") : a16 <= 2 ? str.replace("{density}", "@2x") : str.replace("{density}", "@3x");
                }
            }
            String str2 = f149669c;
            LogUtil.c(str2, "\u8bf7\u6c42\u5b50\u70b9[" + dVar.a() + "]icon url:" + str);
            if (!TextUtils.isEmpty(str)) {
                BitmapDescriptor createBitmapDescriptor = neVar.createBitmapDescriptor(str, 8);
                d16.f149709a = createBitmapDescriptor;
                createBitmapDescriptor.getFormater().setScale(2);
                if (d16.f149709a.getBitmap(context) != null) {
                    LogUtil.c(str2, "\u5b50\u70b9[" + dVar.a() + "]icon\u4e0b\u8f7d\u6210\u529f");
                    if (d16.f149713e == 1) {
                        fu.a aVar = new fu.a(dVar.a(), d16.f149715g, Color.parseColor(d16.f149714f));
                        aVar.f148375f = neVar.getTypeface();
                        aVar.f148374e = Color.parseColor(d16.f149716h);
                        aVar.f148373d = d16.f149717i;
                        aVar.f148376g = ht.a(context) / 2.0f;
                        BitmapDescriptor createBitmapDescriptor2 = neVar.createBitmapDescriptor(aVar, 9);
                        d16.f149710b = createBitmapDescriptor2;
                        if (createBitmapDescriptor2.getBitmap(context) != null) {
                            LogUtil.c(str2, "\u5b50\u70b9[" + dVar.a() + "]\u6587\u672c\u56fe\u7247\u521b\u5efa\u6210\u529f");
                        } else {
                            LogUtil.d(str2, "\u5b50\u70b9[" + dVar.a() + "]\u6587\u672c\u56fe\u7247\u521b\u5efa\u5931\u8d25\uff01");
                        }
                    }
                    callback.callback(dVar);
                } else {
                    LogUtil.d(str2, "\u5b50\u70b9[" + dVar.a() + "]icon\u4e0b\u8f7d\u5931\u8d25\uff01");
                }
            }
        }
    }
}
