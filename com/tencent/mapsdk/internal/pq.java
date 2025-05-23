package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.map.lib.models.PolygonInfo;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Coordinate;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Selectable;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.PolygonOptions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class pq extends po<ar> implements ar, fo {
    private static final double M = 1.0E-10d;

    /* renamed from: d, reason: collision with root package name */
    private static final int f149591d = 180;

    /* renamed from: p, reason: collision with root package name */
    private static final int f149592p = 1;
    private String A;
    private GeoPoint B;
    private Rect C;
    private GeoPoint[] D;
    private boolean E;
    private boolean F;
    private ArrayList<qx> G;
    private ArrayList<qx> H;
    private PolygonOptions I;
    private ne J;
    private String K;
    private BitmapDescriptor L;

    /* renamed from: b, reason: collision with root package name */
    final PolygonInfo f149593b;

    /* renamed from: q, reason: collision with root package name */
    private List<GeoPoint> f149594q;

    /* renamed from: r, reason: collision with root package name */
    private List<LatLng> f149595r;

    /* renamed from: s, reason: collision with root package name */
    private List<List<LatLng>> f149596s;

    /* renamed from: t, reason: collision with root package name */
    private ge[] f149597t;

    /* renamed from: u, reason: collision with root package name */
    private GeoPoint f149598u;

    /* renamed from: v, reason: collision with root package name */
    private Rect f149599v;

    /* renamed from: w, reason: collision with root package name */
    private Rect f149600w;

    /* renamed from: x, reason: collision with root package name */
    private qx f149601x;

    /* renamed from: y, reason: collision with root package name */
    private final byte[] f149602y;

    /* renamed from: z, reason: collision with root package name */
    private b f149603z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        LatLng[] f149604a;

        a(LatLng latLng, LatLng latLng2) {
            this.f149604a = r2;
            LatLng[] latLngArr = {latLng, latLng2};
        }

        public final String toString() {
            return this.f149604a[0].toString() + "    " + this.f149604a[1].toString();
        }
    }

    public pq(bb bbVar, PolygonOptions polygonOptions) {
        super(bbVar);
        this.f149594q = new CopyOnWriteArrayList();
        this.f149602y = new byte[0];
        this.f149603z = new b((byte) 0);
        this.B = new GeoPoint();
        this.C = new Rect();
        this.E = false;
        this.F = false;
        PolygonInfo polygonInfo = new PolygonInfo();
        this.f149593b = polygonInfo;
        polygonInfo.polygonId = -1;
        this.I = polygonOptions;
        this.J = bbVar.b();
        if (polygonOptions != null && !hs.a(this.K)) {
            this.J.f149398k.a(this);
        }
        a(polygonOptions);
    }

    private static double a(double d16, double d17, double d18, double d19, double d26, double d27) {
        return ((d18 - d16) * (d27 - d17)) - ((d26 - d16) * (d19 - d17));
    }

    private void e() {
        PolygonInfo polygonInfo = this.f149593b;
        if (-1 == polygonInfo.polygonId) {
            polygonInfo.polygonId = this.J.a(polygonInfo);
        } else if (v()) {
            this.J.b(this.f149593b);
        }
    }

    private Rect f() {
        Rect rect = this.f149599v;
        if (rect != null) {
            return rect;
        }
        List<GeoPoint> list = this.f149594q;
        if (list != null && !list.isEmpty() && this.f149594q.size() >= 3) {
            GeoPoint geoPoint = this.f149594q.get(0);
            int latitudeE6 = geoPoint.getLatitudeE6();
            int longitudeE6 = geoPoint.getLongitudeE6();
            int size = this.f149594q.size();
            int i3 = latitudeE6;
            int i16 = longitudeE6;
            int i17 = i3;
            for (int i18 = 1; i18 < size; i18++) {
                GeoPoint geoPoint2 = this.f149594q.get(i18);
                int latitudeE62 = geoPoint2.getLatitudeE6();
                int longitudeE62 = geoPoint2.getLongitudeE6();
                longitudeE6 = Math.min(longitudeE6, longitudeE62);
                i16 = Math.max(i16, longitudeE62);
                i17 = Math.max(i17, latitudeE62);
                i3 = Math.min(i3, latitudeE62);
            }
            Rect rect2 = new Rect(longitudeE6, i17, i16, i3);
            this.f149599v = rect2;
            return rect2;
        }
        return null;
    }

    private Rect g() {
        Rect rect = this.f149600w;
        if (rect != null) {
            return rect;
        }
        List<GeoPoint> list = this.f149594q;
        if (list != null && !list.isEmpty() && this.f149594q.size() >= 3) {
            ge b16 = this.J.f149403p.b(this.f149594q.get(0).toLatLng());
            int x16 = (int) b16.x();
            int x17 = (int) b16.x();
            int y16 = (int) b16.y();
            int y17 = (int) b16.y();
            int size = this.f149594q.size();
            for (int i3 = 1; i3 < size; i3++) {
                ge b17 = this.J.f149403p.b(this.f149594q.get(i3).toLatLng());
                x16 = (int) Math.min(x16, b17.x());
                x17 = (int) Math.max(x17, b17.x());
                y16 = (int) Math.min(y16, b17.y());
                y17 = (int) Math.max(y17, b17.y());
            }
            Rect rect2 = new Rect(x16, y16, x17, y17);
            this.f149600w = rect2;
            return rect2;
        }
        return null;
    }

    private Rect i() {
        if (this.J != null) {
            ge b16 = this.J.f149403p.b(this.J.f149403p.a(new fw(0.0d, 0.0d)).toLatLng());
            ge b17 = this.J.f149403p.b(this.J.f149403p.a(new fw(this.J.f149405r.width(), this.J.f149405r.height())).toLatLng());
            ge b18 = this.J.f149403p.b(this.J.f149403p.a(new fw(0.0d, this.J.f149405r.height())).toLatLng());
            ge b19 = this.J.f149403p.b(this.J.f149403p.a(new fw(this.J.f149405r.width(), 0.0d)).toLatLng());
            return new Rect((int) Math.min(Math.min(Math.min(b16.x(), b18.x()), b17.x()), b19.x()), (int) Math.min(Math.min(Math.min(b16.y(), b18.y()), b17.y()), b19.y()), (int) Math.max(Math.max(Math.max(b16.x(), b18.x()), b17.x()), b19.x()), (int) Math.max(Math.max(Math.max(b16.y(), b18.y()), b17.y()), b19.y()));
        }
        return null;
    }

    private static int j() {
        return 1;
    }

    private a[] k() {
        List<GeoPoint> list = this.f149594q;
        List<LatLng> a16 = ks.a(list);
        int size = list.size();
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        while (true) {
            int i16 = size - 1;
            if (i3 < i16) {
                LatLng latLng = a16.get(i3);
                i3++;
                arrayList.add(new a(latLng, a16.get(i3)));
            } else {
                arrayList.add(new a(a16.get(i16), a16.get(0)));
                return (a[]) arrayList.toArray(new a[arrayList.size()]);
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.ar
    public final PolygonInfo b() {
        return this.f149593b;
    }

    @Override // com.tencent.mapsdk.internal.ar
    public final List<GeoPoint> c() {
        ArrayList arrayList = new ArrayList(49);
        Rect f16 = f();
        int i3 = f16.left;
        int i16 = f16.top;
        double d16 = i3;
        double abs = Math.abs(f16.width());
        double d17 = d16 - (abs * 0.125d);
        double d18 = i16;
        double abs2 = Math.abs(f16.height());
        double d19 = d18 - (0.125d * abs2);
        double d26 = d16 - (abs * 0.25d);
        double d27 = d18 - (0.25d * abs2);
        double d28 = d16 - (abs * 0.375d);
        double d29 = d18 - (0.375d * abs2);
        double d36 = d16 - (abs * 0.5d);
        double d37 = d18 - (0.5d * abs2);
        double d38 = d16 - (abs * 0.625d);
        double d39 = d18 - (0.625d * abs2);
        double d46 = d16 - (abs * 0.75d);
        double d47 = d18 - (0.75d * abs2);
        double d48 = d16 - (abs * 0.825d);
        double d49 = d18 - (abs2 * 0.825d);
        int i17 = (int) d19;
        int i18 = (int) d17;
        GeoPoint geoPoint = new GeoPoint(new GeoPoint(i17, i18));
        if (a(geoPoint)) {
            arrayList.add(geoPoint);
        }
        int i19 = (int) d27;
        GeoPoint geoPoint2 = new GeoPoint(new GeoPoint(i19, i18));
        if (a(geoPoint2)) {
            arrayList.add(geoPoint2);
        }
        int i26 = (int) d29;
        GeoPoint geoPoint3 = new GeoPoint(new GeoPoint(i26, i18));
        if (a(geoPoint3)) {
            arrayList.add(geoPoint3);
        }
        int i27 = (int) d37;
        GeoPoint geoPoint4 = new GeoPoint(new GeoPoint(i27, i18));
        if (a(geoPoint4)) {
            arrayList.add(geoPoint4);
        }
        int i28 = (int) d39;
        GeoPoint geoPoint5 = new GeoPoint(new GeoPoint(i28, i18));
        if (a(geoPoint5)) {
            arrayList.add(geoPoint5);
        }
        int i29 = (int) d47;
        GeoPoint geoPoint6 = new GeoPoint(new GeoPoint(i29, i18));
        if (a(geoPoint6)) {
            arrayList.add(geoPoint6);
        }
        int i36 = (int) d49;
        GeoPoint geoPoint7 = new GeoPoint(new GeoPoint(i36, i18));
        if (a(geoPoint7)) {
            arrayList.add(geoPoint7);
        }
        int i37 = (int) d26;
        GeoPoint geoPoint8 = new GeoPoint(new GeoPoint(i17, i37));
        if (a(geoPoint8)) {
            arrayList.add(geoPoint8);
        }
        GeoPoint geoPoint9 = new GeoPoint(new GeoPoint(i19, i37));
        if (a(geoPoint9)) {
            arrayList.add(geoPoint9);
        }
        GeoPoint geoPoint10 = new GeoPoint(new GeoPoint(i26, i37));
        if (a(geoPoint10)) {
            arrayList.add(geoPoint10);
        }
        GeoPoint geoPoint11 = new GeoPoint(new GeoPoint(i27, i37));
        if (a(geoPoint11)) {
            arrayList.add(geoPoint11);
        }
        GeoPoint geoPoint12 = new GeoPoint(new GeoPoint(i28, i37));
        if (a(geoPoint12)) {
            arrayList.add(geoPoint12);
        }
        GeoPoint geoPoint13 = new GeoPoint(new GeoPoint(i29, i37));
        if (a(geoPoint13)) {
            arrayList.add(geoPoint13);
        }
        GeoPoint geoPoint14 = new GeoPoint(new GeoPoint(i36, i37));
        if (a(geoPoint14)) {
            arrayList.add(geoPoint14);
        }
        int i38 = (int) d28;
        GeoPoint geoPoint15 = new GeoPoint(new GeoPoint(i17, i38));
        if (a(geoPoint15)) {
            arrayList.add(geoPoint15);
        }
        GeoPoint geoPoint16 = new GeoPoint(new GeoPoint(i19, i38));
        if (a(geoPoint16)) {
            arrayList.add(geoPoint16);
        }
        GeoPoint geoPoint17 = new GeoPoint(new GeoPoint(i26, i38));
        if (a(geoPoint17)) {
            arrayList.add(geoPoint17);
        }
        GeoPoint geoPoint18 = new GeoPoint(new GeoPoint(i27, i38));
        if (a(geoPoint18)) {
            arrayList.add(geoPoint18);
        }
        GeoPoint geoPoint19 = new GeoPoint(new GeoPoint(i28, i38));
        if (a(geoPoint19)) {
            arrayList.add(geoPoint19);
        }
        GeoPoint geoPoint20 = new GeoPoint(new GeoPoint(i29, i38));
        if (a(geoPoint20)) {
            arrayList.add(geoPoint20);
        }
        GeoPoint geoPoint21 = new GeoPoint(new GeoPoint(i36, i38));
        if (a(geoPoint21)) {
            arrayList.add(geoPoint21);
        }
        int i39 = (int) d36;
        GeoPoint geoPoint22 = new GeoPoint(new GeoPoint(i17, i39));
        if (a(geoPoint22)) {
            arrayList.add(geoPoint22);
        }
        GeoPoint geoPoint23 = new GeoPoint(new GeoPoint(i19, i39));
        if (a(geoPoint23)) {
            arrayList.add(geoPoint23);
        }
        GeoPoint geoPoint24 = new GeoPoint(new GeoPoint(i26, i39));
        if (a(geoPoint24)) {
            arrayList.add(geoPoint24);
        }
        GeoPoint geoPoint25 = new GeoPoint(new GeoPoint(i27, i39));
        if (a(geoPoint25)) {
            arrayList.add(geoPoint25);
        }
        GeoPoint geoPoint26 = new GeoPoint(new GeoPoint(i28, i39));
        if (a(geoPoint26)) {
            arrayList.add(geoPoint26);
        }
        GeoPoint geoPoint27 = new GeoPoint(new GeoPoint(i29, i39));
        if (a(geoPoint27)) {
            arrayList.add(geoPoint27);
        }
        GeoPoint geoPoint28 = new GeoPoint(new GeoPoint(i36, i39));
        if (a(geoPoint28)) {
            arrayList.add(geoPoint28);
        }
        int i46 = (int) d38;
        GeoPoint geoPoint29 = new GeoPoint(new GeoPoint(i17, i46));
        if (a(geoPoint29)) {
            arrayList.add(geoPoint29);
        }
        GeoPoint geoPoint30 = new GeoPoint(new GeoPoint(i19, i46));
        if (a(geoPoint30)) {
            arrayList.add(geoPoint30);
        }
        GeoPoint geoPoint31 = new GeoPoint(new GeoPoint(i26, i46));
        if (a(geoPoint31)) {
            arrayList.add(geoPoint31);
        }
        GeoPoint geoPoint32 = new GeoPoint(new GeoPoint(i27, i46));
        if (a(geoPoint32)) {
            arrayList.add(geoPoint32);
        }
        GeoPoint geoPoint33 = new GeoPoint(new GeoPoint(i28, i46));
        if (a(geoPoint33)) {
            arrayList.add(geoPoint33);
        }
        GeoPoint geoPoint34 = new GeoPoint(new GeoPoint(i29, i46));
        if (a(geoPoint34)) {
            arrayList.add(geoPoint34);
        }
        GeoPoint geoPoint35 = new GeoPoint(new GeoPoint(i36, i46));
        if (a(geoPoint35)) {
            arrayList.add(geoPoint35);
        }
        int i47 = (int) d46;
        GeoPoint geoPoint36 = new GeoPoint(new GeoPoint(i17, i47));
        if (a(geoPoint36)) {
            arrayList.add(geoPoint36);
        }
        GeoPoint geoPoint37 = new GeoPoint(new GeoPoint(i19, i47));
        if (a(geoPoint37)) {
            arrayList.add(geoPoint37);
        }
        GeoPoint geoPoint38 = new GeoPoint(new GeoPoint(i26, i47));
        if (a(geoPoint38)) {
            arrayList.add(geoPoint38);
        }
        GeoPoint geoPoint39 = new GeoPoint(new GeoPoint(i27, i47));
        if (a(geoPoint39)) {
            arrayList.add(geoPoint39);
        }
        GeoPoint geoPoint40 = new GeoPoint(new GeoPoint(i28, i47));
        if (a(geoPoint40)) {
            arrayList.add(geoPoint40);
        }
        GeoPoint geoPoint41 = new GeoPoint(new GeoPoint(i29, i47));
        if (a(geoPoint41)) {
            arrayList.add(geoPoint41);
        }
        GeoPoint geoPoint42 = new GeoPoint(new GeoPoint(i36, i47));
        if (a(geoPoint42)) {
            arrayList.add(geoPoint42);
        }
        int i48 = (int) d48;
        GeoPoint geoPoint43 = new GeoPoint(new GeoPoint(i17, i48));
        if (a(geoPoint43)) {
            arrayList.add(geoPoint43);
        }
        GeoPoint geoPoint44 = new GeoPoint(new GeoPoint(i19, i48));
        if (a(geoPoint44)) {
            arrayList.add(geoPoint44);
        }
        GeoPoint geoPoint45 = new GeoPoint(new GeoPoint(i26, i48));
        if (a(geoPoint45)) {
            arrayList.add(geoPoint45);
        }
        GeoPoint geoPoint46 = new GeoPoint(new GeoPoint(i27, i48));
        if (a(geoPoint46)) {
            arrayList.add(geoPoint46);
        }
        GeoPoint geoPoint47 = new GeoPoint(new GeoPoint(i28, i48));
        if (a(geoPoint47)) {
            arrayList.add(geoPoint47);
        }
        GeoPoint geoPoint48 = new GeoPoint(new GeoPoint(i29, i48));
        if (a(geoPoint48)) {
            arrayList.add(geoPoint48);
        }
        GeoPoint geoPoint49 = new GeoPoint(new GeoPoint(i36, i48));
        if (a(geoPoint49)) {
            arrayList.add(geoPoint49);
        }
        return arrayList;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polygon
    public final boolean contains(LatLng latLng) {
        boolean z16;
        List<LatLng> points = getPoints();
        if (points == null || points.size() < 3 || latLng == null) {
            return false;
        }
        int size = points.size() - 1;
        for (int i3 = 0; i3 < points.size(); i3++) {
            if (points.get(i3).equals(latLng)) {
                return true;
            }
        }
        boolean z17 = false;
        int i16 = size;
        for (int i17 = 0; i17 < points.size(); i17++) {
            if (((points.get(i17).latitude < latLng.latitude && points.get(i16).latitude >= latLng.latitude) || (points.get(i16).latitude < latLng.latitude && points.get(i17).latitude >= latLng.latitude)) && (points.get(i17).longitude <= latLng.longitude || points.get(i16).longitude <= latLng.longitude)) {
                if (points.get(i17).longitude + (((latLng.latitude - points.get(i17).latitude) / (points.get(i16).latitude - points.get(i17).latitude)) * (points.get(i16).longitude - points.get(i17).longitude)) <= latLng.longitude) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                z17 ^= z16;
            }
            i16 = i17;
        }
        return z17;
    }

    @Override // com.tencent.mapsdk.internal.ar
    public final GeoPoint d() {
        Rect f16 = f();
        return new GeoPoint(f16.centerY(), f16.centerX());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polygon
    public final List<LatLng> getPoints() {
        List<LatLng> list = this.f149595r;
        if (list != null) {
            return list;
        }
        return ks.a(this.f149594q);
    }

    @Override // com.tencent.mapsdk.internal.po
    public final void h_() {
        ne neVar = this.J;
        if (neVar == null) {
            return;
        }
        neVar.f149398k.b(this);
        PolygonInfo polygonInfo = this.f149593b;
        if (polygonInfo != null) {
            this.J.a(polygonInfo.polygonId);
        }
        List<GeoPoint> list = this.f149594q;
        if (list != null) {
            list.clear();
        }
        synchronized (this.f149602y) {
            b bVar = this.f149603z;
            if (bVar != null) {
                Bitmap bitmap = bVar.f149608a;
                if (bitmap != null && !bitmap.isRecycled()) {
                    bVar.f149608a.recycle();
                    bVar.f149608a = null;
                }
                this.f149603z = null;
            }
        }
        qx qxVar = this.f149601x;
        if (qxVar != null) {
            this.J.f149400m.b(qxVar);
            this.J.f149412y = true;
            this.f149601x = null;
        }
        this.E = false;
    }

    @Override // com.tencent.mapsdk.internal.po, com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.interfaces.Tappable
    public final boolean handleOnTap() {
        return true;
    }

    @Override // com.tencent.mapsdk.internal.po, com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.interfaces.Selectable
    public final boolean isSelected() {
        return false;
    }

    @Override // com.tencent.mapsdk.internal.po
    public final void j_() {
        ne neVar = this.J;
        if (neVar == null) {
            return;
        }
        int i3 = -1;
        if (!isVisible()) {
            neVar.a(this.f149593b.polygonId);
            this.f149593b.polygonId = -1;
            return;
        }
        if (hs.a(this.K)) {
            p();
        }
        PolygonInfo polygonInfo = this.f149593b;
        if (-1 == polygonInfo.polygonId) {
            polygonInfo.polygonId = this.J.a(polygonInfo);
        } else if (v()) {
            this.J.b(this.f149593b);
        }
        qx qxVar = this.f149601x;
        if (qxVar != null) {
            qxVar.j_();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(this.f149601x.a());
            this.A = sb5.toString();
            if (!this.F) {
                int a16 = this.f149601x.a();
                PolygonInfo polygonInfo2 = this.f149593b;
                if (polygonInfo2 != null) {
                    i3 = polygonInfo2.polygonId;
                }
                neVar.a(a16, i3);
                this.F = true;
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.ar
    public final int k_() {
        PolygonInfo polygonInfo = this.f149593b;
        if (polygonInfo == null) {
            return -1;
        }
        return polygonInfo.polygonId;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x020d, code lost:
    
        if (r8 <= (r4 / 2.0d)) goto L33;
     */
    @Override // com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.interfaces.Tappable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean onTap(float f16, float f17) {
        Rect rect;
        List<GeoPoint> list;
        if (this.J == null || !isVisible()) {
            return false;
        }
        boolean z16 = true;
        if (this.f149600w == null && (list = this.f149594q) != null && !list.isEmpty() && this.f149594q.size() >= 3) {
            ge b16 = this.J.f149403p.b(this.f149594q.get(0).toLatLng());
            int x16 = (int) b16.x();
            int x17 = (int) b16.x();
            int y16 = (int) b16.y();
            int y17 = (int) b16.y();
            int size = this.f149594q.size();
            for (int i3 = 1; i3 < size; i3++) {
                ge b17 = this.J.f149403p.b(this.f149594q.get(i3).toLatLng());
                x16 = (int) Math.min(x16, b17.x());
                x17 = (int) Math.max(x17, b17.x());
                y16 = (int) Math.min(y16, b17.y());
                y17 = (int) Math.max(y17, b17.y());
            }
            this.f149600w = new Rect(x16, y16, x17, y17);
        }
        if (this.J != null) {
            ge b18 = this.J.f149403p.b(this.J.f149403p.a(new fw(0.0d, 0.0d)).toLatLng());
            ge b19 = this.J.f149403p.b(this.J.f149403p.a(new fw(this.J.f149405r.width(), this.J.f149405r.height())).toLatLng());
            ge b26 = this.J.f149403p.b(this.J.f149403p.a(new fw(0.0d, this.J.f149405r.height())).toLatLng());
            ge b27 = this.J.f149403p.b(this.J.f149403p.a(new fw(this.J.f149405r.width(), 0.0d)).toLatLng());
            rect = new Rect((int) Math.min(Math.min(Math.min(b18.x(), b26.x()), b19.x()), b27.x()), (int) Math.min(Math.min(Math.min(b18.y(), b26.y()), b19.y()), b27.y()), (int) Math.max(Math.max(Math.max(b18.x(), b26.x()), b19.x()), b27.x()), (int) Math.max(Math.max(Math.max(b18.y(), b26.y()), b19.y()), b27.y()));
        } else {
            rect = null;
        }
        Rect rect2 = this.f149600w;
        if (rect2 != null && rect != null) {
            double abs = Math.abs(((rect2.left + rect2.right) / 2) - ((rect.left + rect.right) / 2));
            Rect rect3 = this.f149600w;
            double abs2 = Math.abs(((rect3.top + rect3.bottom) / 2) - ((rect.top + rect.bottom) / 2));
            Rect rect4 = this.f149600w;
            double abs3 = Math.abs(rect4.left - rect4.right) + Math.abs(rect.left - rect.right);
            Rect rect5 = this.f149600w;
            double abs4 = Math.abs(rect5.top - rect5.bottom) + Math.abs(rect.top - rect.bottom);
            if (abs <= abs3 / 2.0d) {
            }
        }
        z16 = false;
        if (!z16) {
            return false;
        }
        return a(this.J.f149403p.b(this.J.f149403p.a(new fw(f16, f17)).toLatLng()));
    }

    @Override // com.tencent.mapsdk.internal.po, com.tencent.mapsdk.internal.ex
    public final void p() {
        List<GeoPoint> list;
        if (this.J == null) {
            return;
        }
        if ((this.f149593b.polygonId < 0 || v()) && (list = this.f149594q) != null && list.size() > 2) {
            PolygonInfo polygonInfo = this.f149593b;
            polygonInfo.color = this.f149554f;
            polygonInfo.borderColor = this.f149555g;
            polygonInfo.borderWidth = this.f149553e;
            polygonInfo.zIndex = getZIndex();
            this.f149593b.level = getLevel();
            int size = this.f149594q.size();
            this.f149593b.points = new LatLng[size];
            for (int i3 = 0; i3 < size; i3++) {
                this.f149593b.points[i3] = this.f149594q.get(i3).toLatLng();
            }
            int size2 = this.f149596s.size();
            this.f149593b.holePoints = new LatLng[size2];
            for (int i16 = 0; i16 < size2; i16++) {
                this.f149593b.holePoints[i16] = (LatLng[]) this.f149596s.get(i16).toArray(new LatLng[0]);
            }
            this.J.f149412y = true;
            w();
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polygon
    public final void setHolePoints(List<List<LatLng>> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        PolygonOptions polygonOptions = this.I;
        if (polygonOptions != null) {
            polygonOptions.setHolePoints(list);
        }
        this.f149596s.clear();
        for (List<LatLng> list2 : list) {
            if (list2 != null && list2.size() >= 3) {
                this.f149596s.add(list2);
            }
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polygon
    public final void setOptions(PolygonOptions polygonOptions) {
        a(polygonOptions);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polygon
    public final void setPoints(List<LatLng> list) {
        int size;
        GeoPoint from;
        this.f149595r = list;
        if (list == null || (size = list.size()) <= 0) {
            return;
        }
        PolygonOptions polygonOptions = this.I;
        if (polygonOptions != null) {
            polygonOptions.setPoints(new ArrayList(list));
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < size; i3++) {
            LatLng latLng = list.get(i3);
            if (latLng != null && (from = GeoPoint.from(latLng)) != null) {
                arrayList.add(from);
            }
        }
        a(arrayList);
    }

    private static boolean a(double d16, double d17, double d18, double d19, double d26, double d27, double d28) {
        double d29 = d18 - d16;
        double d36 = d28 - d27;
        double d37 = d19 - d17;
        double d38 = 180.0d - d26;
        double d39 = (d29 * d36) - (d37 * d38);
        if (d39 != 0.0d) {
            double d46 = d17 - d27;
            double d47 = d16 - d26;
            double d48 = ((d38 * d46) - (d36 * d47)) / d39;
            double d49 = ((d46 * d29) - (d47 * d37)) / d39;
            if (d48 >= 0.0d && d48 <= 1.0d && d49 >= 0.0d && d49 <= 1.0d) {
                return true;
            }
        }
        return false;
    }

    private static boolean b(double d16, double d17, double d18, double d19, double d26, double d27) {
        return Math.abs(a(d16, d17, d18, d19, d26, d27)) < 1.0E-9d && (d16 - d18) * (d16 - d26) <= 0.0d && (d17 - d19) * (d17 - d27) <= 0.0d;
    }

    private void a(List<GeoPoint> list) {
        if (list.isEmpty()) {
            return;
        }
        List<GeoPoint> list2 = this.f149594q;
        if (list2 == null) {
            this.f149594q = new ArrayList();
        } else {
            list2.clear();
        }
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            GeoPoint geoPoint = list.get(i3);
            if (geoPoint != null) {
                w();
                this.f149594q.add(geoPoint);
            }
        }
    }

    private void d(fa faVar) {
        if (this.J == null || hs.a(this.K)) {
            return;
        }
        synchronized (this.f149602y) {
            byte b16 = 0;
            if (this.f149603z == null) {
                this.f149603z = new b(b16);
            }
        }
        Rect rect = this.C;
        GeoPoint geoPoint = new GeoPoint(rect.top, rect.left);
        Rect rect2 = this.C;
        GeoPoint geoPoint2 = new GeoPoint(rect2.top, rect2.right);
        Rect rect3 = this.C;
        GeoPoint geoPoint3 = new GeoPoint(rect3.bottom, rect3.right);
        Rect rect4 = this.C;
        fw[] a16 = a(new fw[]{faVar.a(geoPoint), faVar.a(geoPoint2), faVar.a(geoPoint3), faVar.a(new GeoPoint(rect4.bottom, rect4.left))});
        fw fwVar = a16[0];
        int i3 = (int) fwVar.f148383a;
        int i16 = (int) fwVar.f148384b;
        fw fwVar2 = a16[1];
        new Rect(i3, i16, (int) fwVar2.f148383a, (int) fwVar2.f148384b);
    }

    @Override // com.tencent.mapsdk.internal.po, com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.interfaces.Boundable
    /* renamed from: b */
    public final Rect getBound(fa faVar) {
        Rect rect = new Rect();
        new Rect();
        if (this.f149593b != null) {
            rect = f();
        }
        qx qxVar = this.f149601x;
        if (qxVar != null) {
            Rect bound = qxVar.getBound(faVar);
            rect.left = Math.min(rect.left, bound.left);
            rect.top = Math.min(rect.top, bound.top);
            rect.right = Math.max(rect.right, bound.right);
            rect.bottom = Math.max(rect.bottom, bound.bottom);
        }
        return rect;
    }

    private int e(fa faVar) {
        Rect rect = this.C;
        GeoPoint geoPoint = new GeoPoint(rect.top, rect.left);
        Rect rect2 = this.C;
        GeoPoint geoPoint2 = new GeoPoint(rect2.top, rect2.right);
        Rect rect3 = this.C;
        GeoPoint geoPoint3 = new GeoPoint(rect3.bottom, rect3.right);
        Rect rect4 = this.C;
        fw[] a16 = a(new fw[]{faVar.a(geoPoint), faVar.a(geoPoint2), faVar.a(geoPoint3), faVar.a(new GeoPoint(rect4.bottom, rect4.left))});
        fw fwVar = a16[0];
        int i3 = (int) fwVar.f148383a;
        int i16 = (int) fwVar.f148384b;
        fw fwVar2 = a16[1];
        new Rect(i3, i16, (int) fwVar2.f148383a, (int) fwVar2.f148384b);
        return 1;
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    static class b {

        /* renamed from: b, reason: collision with root package name */
        private static final int f149606b = 900;

        /* renamed from: c, reason: collision with root package name */
        private static final int f149607c = 180;

        /* renamed from: a, reason: collision with root package name */
        Bitmap f149608a;

        /* renamed from: d, reason: collision with root package name */
        private TextPaint f149609d;

        /* renamed from: e, reason: collision with root package name */
        private int f149610e;

        /* renamed from: f, reason: collision with root package name */
        private int f149611f;

        /* renamed from: g, reason: collision with root package name */
        private int f149612g;

        /* renamed from: h, reason: collision with root package name */
        private HashMap<String, Integer> f149613h;

        b() {
            this.f149608a = null;
            this.f149609d = null;
            this.f149610e = 900;
            this.f149611f = 180;
            this.f149612g = -1;
            this.f149613h = new HashMap<>();
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0063  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0067  */
        /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private int a(Rect rect, String str, int i3, Typeface typeface, int i16, int i17) {
            int i18;
            int i19;
            if (rect == null) {
                return i17;
            }
            int abs = Math.abs(rect.height());
            int abs2 = Math.abs(rect.width());
            Rect rect2 = new Rect(0, 0, 0, 0);
            a(i16, i3, typeface);
            int ceil = (int) Math.ceil(1.0f / ho.o());
            int i26 = i16 / 2;
            int[] a16 = a(str, i26, rect2);
            int i27 = a16[0];
            int i28 = a16[1];
            if (i27 > abs2 || i28 > abs) {
                i18 = i26 - ceil;
                while (true) {
                    if (i18 < i17) {
                        i18 = i17;
                        break;
                    }
                    int[] a17 = a(str, i18, rect2);
                    int i29 = a17[0];
                    int i36 = a17[1];
                    if (i29 <= abs2 && i36 <= abs) {
                        break;
                    }
                    i18 -= ceil;
                }
                if (i18 >= i17) {
                    i17 = i18;
                }
                return i17 <= i16 ? i16 : i17;
            }
            do {
                i18 = i26;
                i26 += ceil;
                if (i26 >= i16) {
                    break;
                }
                int[] a18 = a(str, i26, rect2);
                int i37 = a18[0];
                i19 = a18[1];
                if (i37 > abs2) {
                    break;
                }
            } while (i19 <= abs);
            if (i18 >= i17) {
            }
            if (i17 <= i16) {
            }
        }

        /* synthetic */ b(byte b16) {
            this();
        }

        private int[] a(String str, int i3, Rect rect) {
            a(i3);
            this.f149609d.getTextBounds(str, 0, str.length(), rect);
            return new int[]{Math.abs(rect.width()), Math.abs(rect.height())};
        }

        private void a() {
            Bitmap bitmap = this.f149608a;
            if (bitmap == null || bitmap.isRecycled()) {
                return;
            }
            this.f149608a.recycle();
            this.f149608a = null;
        }

        private void a(String str, int i3, int i16, Typeface typeface) {
            if (this.f149608a == null) {
                try {
                    this.f149608a = Bitmap.createBitmap(this.f149610e, this.f149611f, Bitmap.Config.ARGB_8888);
                } catch (OutOfMemoryError e16) {
                    e16.printStackTrace();
                    return;
                }
            }
            a(i3, i16, typeface);
            Rect rect = new Rect();
            this.f149609d.getTextBounds(str, 0, str.length(), rect);
            int abs = Math.abs(rect.width());
            int abs2 = Math.abs(rect.height());
            int i17 = this.f149610e;
            if (abs > i17 || abs2 > this.f149611f) {
                this.f149610e = Math.max(abs, i17);
                int max = Math.max(abs2, this.f149611f);
                this.f149611f = max;
                this.f149608a = Bitmap.createBitmap(this.f149610e, max, Bitmap.Config.ARGB_8888);
            }
            this.f149608a.eraseColor(0);
            new Canvas(this.f149608a).drawText(str, this.f149610e / 2.0f, (this.f149611f / 2.0f) - ((this.f149609d.descent() + this.f149609d.ascent()) / 2.0f), this.f149609d);
        }

        private void a(int i3, int i16, Typeface typeface) {
            if (this.f149609d == null) {
                TextPaint textPaint = new TextPaint(65);
                this.f149609d = textPaint;
                textPaint.setStyle(Paint.Style.FILL);
                this.f149609d.setTextAlign(Paint.Align.CENTER);
            }
            this.f149609d.setColor(i16);
            this.f149609d.setTextSize(i3);
            this.f149609d.setTypeface(typeface);
        }

        private void a(int i3) {
            TextPaint textPaint = this.f149609d;
            if (textPaint != null) {
                textPaint.setTextSize(i3);
            }
        }

        private static String a(String str, String str2, int i3) {
            return str + "_" + str2 + "_" + i3;
        }

        private Object[] a(String str, String str2, int i3, int i16, Typeface typeface) {
            String str3 = str + "_" + str2 + "_" + i3;
            if (i3 > 180) {
                i3 = 180;
            }
            if (i3 != this.f149612g) {
                if (this.f149608a == null) {
                    try {
                        this.f149608a = Bitmap.createBitmap(this.f149610e, this.f149611f, Bitmap.Config.ARGB_8888);
                    } catch (OutOfMemoryError e16) {
                        e16.printStackTrace();
                    }
                }
                a(i3, i16, typeface);
                Rect rect = new Rect();
                this.f149609d.getTextBounds(str2, 0, str2.length(), rect);
                int abs = Math.abs(rect.width());
                int abs2 = Math.abs(rect.height());
                int i17 = this.f149610e;
                if (abs > i17 || abs2 > this.f149611f) {
                    this.f149610e = Math.max(abs, i17);
                    int max = Math.max(abs2, this.f149611f);
                    this.f149611f = max;
                    this.f149608a = Bitmap.createBitmap(this.f149610e, max, Bitmap.Config.ARGB_8888);
                }
                this.f149608a.eraseColor(0);
                new Canvas(this.f149608a).drawText(str2, this.f149610e / 2.0f, (this.f149611f / 2.0f) - ((this.f149609d.descent() + this.f149609d.ascent()) / 2.0f), this.f149609d);
                this.f149612g = i3;
            }
            return new Object[]{str3, this.f149608a};
        }
    }

    @Override // com.tencent.mapsdk.internal.ar
    public final void a(PolygonOptions polygonOptions) {
        if (polygonOptions == null) {
            return;
        }
        setFillColor(polygonOptions.getFillColor());
        setStrokeColor(polygonOptions.getStrokeColor());
        setStrokeWidth(polygonOptions.getStrokeWidth());
        setZIndex(polygonOptions.getZIndex());
        setVisible(polygonOptions.isVisible());
        setLevel(polygonOptions.getLevel());
        setClickable(polygonOptions.isClickable());
        setPoints(polygonOptions.getPoints());
        List<Integer> pattern = polygonOptions.getPattern();
        if (pattern != null && !pattern.isEmpty()) {
            int[] iArr = new int[pattern.size()];
            for (int i3 = 0; i3 < pattern.size(); i3++) {
                iArr[i3] = pattern.get(i3).intValue();
            }
            this.f149593b.pattern = iArr;
        }
        BitmapDescriptor texture = polygonOptions.getTexture();
        if (this.L != texture) {
            this.L = texture;
            texture.getBitmap(this.J.getContext());
            this.f149593b.textureName = this.L.getFormater().getBitmapId();
        }
        this.f149593b.textureSpacing = polygonOptions.getTextureSpacing();
        this.f149596s = polygonOptions.getHolePoints();
        w();
    }

    @Override // com.tencent.mapsdk.internal.fo
    public final void b(int i3) {
        ne neVar;
        if (i3 == gh.f148490a || (neVar = this.J) == null) {
            return;
        }
        fa faVar = neVar.f149403p;
        if (neVar == null || hs.a(this.K)) {
            return;
        }
        synchronized (this.f149602y) {
            byte b16 = 0;
            if (this.f149603z == null) {
                this.f149603z = new b(b16);
            }
        }
        Rect rect = this.C;
        GeoPoint geoPoint = new GeoPoint(rect.top, rect.left);
        Rect rect2 = this.C;
        GeoPoint geoPoint2 = new GeoPoint(rect2.top, rect2.right);
        Rect rect3 = this.C;
        GeoPoint geoPoint3 = new GeoPoint(rect3.bottom, rect3.right);
        Rect rect4 = this.C;
        fw[] a16 = a(new fw[]{faVar.a(geoPoint), faVar.a(geoPoint2), faVar.a(geoPoint3), faVar.a(new GeoPoint(rect4.bottom, rect4.left))});
        fw fwVar = a16[0];
        int i16 = (int) fwVar.f148383a;
        int i17 = (int) fwVar.f148384b;
        fw fwVar2 = a16[1];
        new Rect(i16, i17, (int) fwVar2.f148383a, (int) fwVar2.f148384b);
    }

    private ar h() {
        return this;
    }

    @Override // com.tencent.mapsdk.internal.aw
    public final /* bridge */ /* synthetic */ aq f_() {
        return this;
    }

    @Override // com.tencent.mapsdk.internal.po, com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.interfaces.Selectable
    public final void setSelected(boolean z16) {
    }

    @Override // com.tencent.mapsdk.internal.po, com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.interfaces.Selectable
    public final void setSelectedListener(Selectable.OnSelectedListener onSelectedListener) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0138, code lost:
    
        r18 = r7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(ge geVar) {
        int i3;
        List<LatLng> list = this.f149595r;
        if (list == null || list.size() <= 2) {
            return false;
        }
        int i16 = 1;
        this.f149597t = new ge[this.f149595r.size() + 1];
        for (int i17 = 0; i17 < this.f149595r.size(); i17++) {
            this.f149597t[i17] = this.J.f149403p.b(this.f149595r.get(i17));
            ge geVar2 = this.f149597t[i17];
            geVar2.setX(geVar2.f148480c - geVar.f148480c);
            ge geVar3 = this.f149597t[i17];
            geVar3.setY(geVar3.f148479b - geVar.f148479b);
        }
        this.f149597t[this.f149595r.size()] = this.J.f149403p.b(this.f149595r.get(0));
        this.f149597t[this.f149595r.size()].setX(this.f149597t[this.f149595r.size()].f148480c - geVar.f148480c);
        this.f149597t[this.f149595r.size()].setY(this.f149597t[this.f149595r.size()].f148479b - geVar.f148479b);
        ge geVar4 = this.f149597t[0];
        int i18 = geVar4.f148480c >= 0.0d ? geVar4.f148479b >= 0.0d ? 0 : 3 : geVar4.f148479b >= 0.0d ? 1 : 2;
        int i19 = 0;
        int i26 = 1;
        while (true) {
            ge[] geVarArr = this.f149597t;
            if (i26 > geVarArr.length - i16) {
                break;
            }
            ge geVar5 = geVarArr[i26];
            double d16 = geVar5.f148480c;
            if (d16 == 0.0d && geVar5.f148479b == 0.0d) {
                break;
            }
            double d17 = geVar5.f148479b;
            ge geVar6 = geVarArr[i26 - 1];
            double d18 = geVar6.f148480c;
            i3 = i19;
            double d19 = geVar6.f148479b;
            double d26 = (d17 * d18) - (d16 * d19);
            if (d26 == 0.0d && d18 * d16 <= 0.0d && d19 * d17 <= 0.0d) {
                break;
            }
            int i27 = d16 >= 0.0d ? d17 >= 0.0d ? 0 : 3 : d17 >= 0.0d ? 1 : 2;
            if (i27 == (i18 + 1) % 4) {
                i19 = i3 + 1;
            } else if (i27 == (i18 + 3) % 4) {
                i19 = i3 - 1;
            } else {
                i19 = i27 == (i18 + 2) % 4 ? d26 > 0.0d ? i3 + 2 : i3 - 2 : i3;
            }
            i26++;
            i18 = i27;
            i16 = 1;
        }
        return i26 <= this.f149595r.size() || i3 != 0;
    }

    private boolean a(Rect rect) {
        Rect rect2 = this.f149600w;
        if (rect2 == null || rect == null) {
            return false;
        }
        double abs = Math.abs(((rect2.left + rect2.right) / 2) - ((rect.left + rect.right) / 2));
        Rect rect3 = this.f149600w;
        double abs2 = Math.abs(((rect3.top + rect3.bottom) / 2) - ((rect.top + rect.bottom) / 2));
        Rect rect4 = this.f149600w;
        double abs3 = Math.abs(rect4.left - rect4.right) + Math.abs(rect.left - rect.right);
        Rect rect5 = this.f149600w;
        return abs <= abs3 / 2.0d && abs2 <= ((double) (Math.abs(rect5.top - rect5.bottom) + Math.abs(rect.top - rect.bottom))) / 2.0d;
    }

    private boolean a(GeoPoint geoPoint) {
        List<GeoPoint> list = this.f149594q;
        if (list == null || list.size() <= 1) {
            return false;
        }
        double longitudeE6 = geoPoint.getLongitudeE6();
        double latitudeE6 = geoPoint.getLatitudeE6();
        int size = this.f149594q.size();
        int i3 = 0;
        int i16 = 0;
        while (true) {
            int i17 = size - 1;
            if (i3 < i17) {
                GeoPoint geoPoint2 = this.f149594q.get(i3);
                int i18 = i3 + 1;
                GeoPoint geoPoint3 = this.f149594q.get(i18);
                double longitudeE62 = geoPoint2.getLongitudeE6();
                double latitudeE62 = geoPoint2.getLatitudeE6();
                double longitudeE63 = geoPoint3.getLongitudeE6();
                double latitudeE63 = geoPoint3.getLatitudeE6();
                double d16 = latitudeE6;
                double d17 = longitudeE6;
                if (b(longitudeE6, latitudeE6, longitudeE62, latitudeE62, longitudeE63, latitudeE63)) {
                    return true;
                }
                if (Math.abs(latitudeE63 - latitudeE62) >= 1.0E-9d) {
                    if (b(longitudeE62, latitudeE62, d17, d16, 180.0d, d16)) {
                        if (latitudeE62 <= latitudeE63) {
                        }
                        i16++;
                    } else if (b(longitudeE63, latitudeE63, d17, d16, 180.0d, d16)) {
                        if (latitudeE63 <= latitudeE62) {
                        }
                        i16++;
                    } else {
                        if (!a(longitudeE62, latitudeE62, longitudeE63, latitudeE63, d17, d16, d16)) {
                        }
                        i16++;
                    }
                }
                i3 = i18;
                latitudeE6 = d16;
                longitudeE6 = d17;
            } else {
                double d18 = latitudeE6;
                double d19 = longitudeE6;
                GeoPoint geoPoint4 = this.f149594q.get(i17);
                GeoPoint geoPoint5 = this.f149594q.get(0);
                double longitudeE64 = geoPoint4.getLongitudeE6();
                double latitudeE64 = geoPoint4.getLatitudeE6();
                double longitudeE65 = geoPoint5.getLongitudeE6();
                double latitudeE65 = geoPoint5.getLatitudeE6();
                if (b(d19, d18, longitudeE64, latitudeE64, longitudeE65, latitudeE65)) {
                    return true;
                }
                if (Math.abs(latitudeE65 - latitudeE64) >= 1.0E-9d && (!b(longitudeE64, latitudeE64, d19, d18, 180.0d, d18) ? !(!b(longitudeE65, latitudeE65, d19, d18, 180.0d, d18) ? !a(longitudeE64, latitudeE64, longitudeE65, latitudeE65, d19, d18, d18) : latitudeE65 <= latitudeE64) : latitudeE64 > latitudeE65)) {
                    i16++;
                }
                return i16 % 2 == 1;
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.interfaces.Boundable
    /* renamed from: a */
    public final Rect getScreenBound(fa faVar) {
        Rect bound = getBound(faVar);
        int i3 = bound.left;
        int i16 = bound.right;
        int i17 = bound.top;
        int i18 = bound.bottom;
        GeoPoint geoPoint = new GeoPoint(i17, i3);
        GeoPoint geoPoint2 = new GeoPoint(i18, i3);
        GeoPoint geoPoint3 = new GeoPoint(i18, i16);
        GeoPoint geoPoint4 = new GeoPoint(i17, i16);
        fw a16 = faVar.a(geoPoint);
        fw a17 = faVar.a(geoPoint2);
        fw a18 = faVar.a(geoPoint3);
        fw a19 = faVar.a(geoPoint4);
        return new Rect((int) Math.min(Math.min(a16.f148383a, a17.f148383a), Math.min(a18.f148383a, a19.f148383a)), (int) Math.min(Math.min(a16.f148384b, a17.f148384b), Math.min(a18.f148384b, a19.f148384b)), (int) Math.max(Math.max(a16.f148383a, a17.f148383a), Math.max(a18.f148383a, a19.f148383a)), (int) Math.max(Math.max(a16.f148384b, a17.f148384b), Math.max(a18.f148384b, a19.f148384b)));
    }

    private static fw[] a(fw[] fwVarArr) {
        fw fwVar = fwVarArr[0];
        double d16 = fwVar.f148383a;
        double d17 = fwVar.f148384b;
        double d18 = d17;
        double d19 = d16;
        for (int i3 = 1; i3 < 4; i3++) {
            fw fwVar2 = fwVarArr[i3];
            double d26 = fwVar2.f148383a;
            double d27 = fwVar2.f148384b;
            if (d26 < d16) {
                d16 = d26;
            }
            if (d26 > d19) {
                d19 = d26;
            }
            if (d27 < d17) {
                d17 = d27;
            }
            if (d27 > d18) {
                d18 = d27;
            }
        }
        return new fw[]{new fw(d16, d17), new fw(d19, d18)};
    }

    private Rect a(a[] aVarArr) {
        LatLng latLng = new LatLng(0.0d, 0.0d);
        double a16 = a(aVarArr, latLng);
        double d16 = latLng.longitude;
        double d17 = latLng.latitude;
        return new Rect((int) ((d16 + a16) * 1000000.0d), (int) ((d17 + a16) * 1000000.0d), (int) ((d16 - a16) * 1000000.0d), (int) ((d17 - a16) * 1000000.0d));
    }

    private double a(a[] aVarArr, LatLng latLng) {
        List<LatLng> a16;
        List<GeoPoint> c16 = c();
        if (c16.isEmpty() || (a16 = ks.a(c16)) == null || a16.isEmpty()) {
            return 0.0d;
        }
        int size = a16.size();
        LatLng[] latLngArr = new LatLng[size];
        double[] dArr = new double[size];
        int i3 = 0;
        for (int i16 = 0; i16 < size; i16++) {
            latLngArr[i16] = new LatLng(0.0d, 0.0d);
            double a17 = a(a16.get(i16), aVarArr, latLngArr[i16]);
            dArr[i16] = a17;
            if (Double.isNaN(a17)) {
                dArr[i16] = 0.0d;
            }
        }
        double d16 = dArr[0];
        for (int i17 = 1; i17 < size; i17++) {
            double d17 = dArr[i17];
            if (d17 > d16) {
                i3 = i17;
                d16 = d17;
            }
        }
        LatLng latLng2 = latLngArr[i3];
        latLng.latitude = latLng2.latitude;
        latLng.longitude = latLng2.longitude;
        return dArr[i3];
    }

    private static double a(LatLng latLng, a[] aVarArr, LatLng latLng2) {
        boolean z16;
        LatLng latLng3 = latLng;
        a[] aVarArr2 = aVarArr;
        int length = aVarArr2.length;
        double d16 = 0.0d;
        LatLng latLng4 = new LatLng(0.0d, 0.0d);
        LatLng latLng5 = new LatLng(0.0d, 0.0d);
        LatLng[] latLngArr = aVarArr2[0].f149604a;
        LatLng latLng6 = latLngArr[0];
        LatLng latLng7 = latLngArr[1];
        double a16 = lj.a((Coordinate) latLng3, (Coordinate) latLng6, (Coordinate) latLng7);
        latLng4.latitude = latLng6.latitude;
        latLng4.longitude = latLng6.longitude;
        latLng5.latitude = latLng7.latitude;
        latLng5.longitude = latLng7.longitude;
        for (int i3 = 1; i3 < length; i3++) {
            LatLng[] latLngArr2 = aVarArr2[i3].f149604a;
            LatLng latLng8 = latLngArr2[0];
            LatLng latLng9 = latLngArr2[1];
            double a17 = lj.a((Coordinate) latLng3, (Coordinate) latLng8, (Coordinate) latLng9);
            if (a17 < a16) {
                latLng4.latitude = latLng8.latitude;
                latLng4.longitude = latLng8.longitude;
                latLng5.latitude = latLng9.latitude;
                latLng5.longitude = latLng9.longitude;
                a16 = a17;
            }
        }
        LatLng a18 = lj.a(latLng3, latLng4, latLng5);
        LatLng latLng10 = new LatLng(0.0d, 0.0d);
        boolean z17 = false;
        int i16 = 0;
        int i17 = 0;
        while (!z17) {
            LatLng a19 = lj.a(latLng3, a18, i16);
            double a26 = lj.a((Coordinate) a19, (Coordinate) a18);
            int i18 = 0;
            while (true) {
                if (i18 >= length) {
                    z16 = true;
                    break;
                }
                LatLng[] latLngArr3 = aVarArr2[i18].f149604a;
                z16 = true;
                if (lj.a(a19, a26, latLngArr3[0], latLngArr3[1])) {
                    z17 = true;
                    break;
                }
                i18++;
                aVarArr2 = aVarArr;
            }
            if (!z17) {
                latLng10.latitude = a19.latitude;
                latLng10.longitude = a19.longitude;
                i16 += 5;
            } else if (i17 == 0) {
                latLng10.latitude = a19.latitude;
                latLng10.longitude = a19.longitude;
            } else {
                i17++;
                latLng3 = latLng;
                aVarArr2 = aVarArr;
            }
            d16 = a26;
            i17++;
            latLng3 = latLng;
            aVarArr2 = aVarArr;
        }
        latLng2.latitude = latLng10.latitude;
        latLng2.longitude = latLng10.longitude;
        return d16;
    }

    private boolean c(fa faVar) {
        PolygonOptions polygonOptions;
        Rect f16;
        if (this.f149593b == null || (polygonOptions = this.I) == null || !polygonOptions.isValid() || (f16 = f()) == null) {
            return false;
        }
        fw[] a16 = a(new fw[]{faVar.a(new GeoPoint(f16.top, f16.left)), faVar.a(new GeoPoint(f16.top, f16.right)), faVar.a(new GeoPoint(f16.bottom, f16.right)), faVar.a(new GeoPoint(f16.bottom, f16.left))});
        fw fwVar = a16[0];
        int i3 = (int) fwVar.f148383a;
        int i16 = (int) fwVar.f148384b;
        fw fwVar2 = a16[1];
        Rect rect = new Rect(i3, i16, (int) fwVar2.f148383a, (int) fwVar2.f148384b);
        return Math.abs(rect.width()) > 5 && Math.abs(rect.height()) > 5;
    }

    private int a(GeoPoint geoPoint, fa faVar) {
        List<GeoPoint> list = this.f149594q;
        List<LatLng> a16 = ks.a(list);
        int size = list.size();
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        while (true) {
            int i16 = size - 1;
            if (i3 < i16) {
                LatLng latLng = a16.get(i3);
                i3++;
                arrayList.add(new a(latLng, a16.get(i3)));
            } else {
                arrayList.add(new a(a16.get(i16), a16.get(0)));
                a[] aVarArr = (a[]) arrayList.toArray(new a[arrayList.size()]);
                LatLng latLng2 = new LatLng(0.0d, 0.0d);
                double a17 = a(aVarArr, latLng2);
                double d16 = latLng2.longitude;
                double d17 = latLng2.latitude;
                Rect rect = new Rect((int) ((d16 + a17) * 1000000.0d), (int) ((d17 + a17) * 1000000.0d), (int) ((d16 - a17) * 1000000.0d), (int) ((d17 - a17) * 1000000.0d));
                this.C = rect;
                geoPoint.setLatitudeE6(rect.centerY());
                geoPoint.setLongitudeE6(this.C.centerX());
                Rect rect2 = this.C;
                GeoPoint geoPoint2 = new GeoPoint(rect2.top, rect2.left);
                Rect rect3 = this.C;
                GeoPoint geoPoint3 = new GeoPoint(rect3.top, rect3.right);
                Rect rect4 = this.C;
                GeoPoint geoPoint4 = new GeoPoint(rect4.bottom, rect4.right);
                Rect rect5 = this.C;
                fw[] a18 = a(new fw[]{faVar.a(geoPoint2), faVar.a(geoPoint3), faVar.a(geoPoint4), faVar.a(new GeoPoint(rect5.bottom, rect5.left))});
                fw fwVar = a18[0];
                int i17 = (int) fwVar.f148383a;
                int i18 = (int) fwVar.f148384b;
                fw fwVar2 = a18[1];
                new Rect(i17, i18, (int) fwVar2.f148383a, (int) fwVar2.f148384b);
                return 1;
            }
        }
    }
}
