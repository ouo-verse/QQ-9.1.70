package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.location.Location;
import android.opengl.Matrix;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.map.tools.CallbackRunnable;
import com.tencent.mapsdk.internal.fa;
import com.tencent.mapsdk.internal.ne;
import com.tencent.mapsdk.internal.tk;
import com.tencent.mapsdk.internal.v;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Boundable;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import com.tencent.tencentmap.mapsdk.maps.model.VisibleRegion;
import java.util.Iterator;
import java.util.List;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class y extends gi implements fa {

    /* renamed from: a, reason: collision with root package name */
    public static final int f151309a = 268435456;

    /* renamed from: e, reason: collision with root package name */
    private static final int f151310e = 19;

    /* renamed from: f, reason: collision with root package name */
    private static final int f151311f = 14;

    /* renamed from: b, reason: collision with root package name */
    protected v f151312b;

    /* renamed from: c, reason: collision with root package name */
    protected ne f151313c;

    /* renamed from: g, reason: collision with root package name */
    private tk f151314g;

    public y(bf bfVar) {
        super(4.007501668E7d);
        this.f151314g = bfVar.g();
        this.f151312b = bfVar.f();
        this.f151313c = (ne) bfVar;
    }

    private void a(v vVar) {
        this.f151312b = vVar;
    }

    private v b() {
        return this.f151312b;
    }

    private fw c(fw fwVar) {
        if (fwVar == null) {
            return null;
        }
        fw fwVar2 = this.f151312b.f151268q;
        return new fw((r0.f151265n.width() / 2) + (fwVar.f148383a - fwVar2.f148383a), (this.f151312b.f151265n.height() / 2) - (fwVar.f148384b - fwVar2.f148384b));
    }

    private boolean d() {
        if (this.f151312b.f151269r == null) {
            return false;
        }
        if (Math.abs(r0.f151295a) <= 0.25d && Math.abs(r0.f151296b) <= 0.25d) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.Projection
    public final LatLng fromScreenLocation(Point point) {
        return a(new fw(point.x, point.y)).toLatLng();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.Projection
    public final VisibleRegion getVisibleRegion() {
        ne neVar = this.f151313c;
        tr trVar = (tr) neVar.f147916c;
        float t16 = neVar.f149396i.t();
        int height = this.f151312b.f151265n.height();
        Point point = new Point(0, trVar.f151031ak);
        Point point2 = new Point(trVar.f151030aj, trVar.f151031ak);
        double d16 = height - t16;
        fw fwVar = new fw(0.0d, d16);
        fw fwVar2 = new fw(trVar.f151030aj, d16);
        LatLng fromScreenLocation = fromScreenLocation(point);
        LatLng fromScreenLocation2 = fromScreenLocation(point2);
        LatLng latLng = a(fwVar).toLatLng();
        LatLng latLng2 = a(fwVar2).toLatLng();
        return new VisibleRegion(fromScreenLocation, fromScreenLocation2, latLng, latLng2, LatLngBounds.builder().include(fromScreenLocation).include(fromScreenLocation2).include(latLng).include(latLng2).build());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.Projection
    public final float[] glModelMatrix(PointF pointF, float f16) {
        if (pointF == null) {
            return null;
        }
        float[] fArr = new float[16];
        Matrix.setIdentityM(fArr, 0);
        float[] nativeGLProjectMatrix = this.f151314g.f150514d.nativeGLProjectMatrix();
        float[] z16 = this.f151314g.z();
        GeoPoint o16 = this.f151314g.o();
        Matrix.multiplyMM(fArr, 0, nativeGLProjectMatrix, 0, z16, 0);
        PointF a16 = a(ks.a(o16));
        Matrix.translateM(fArr, 0, pointF.x - a16.x, a16.y - pointF.y, 0.0f);
        Matrix.scaleM(fArr, 0, f16, f16, f16);
        return fArr;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.Projection
    public final float glPixelRatio() {
        return this.f151314g.f150514d.nativeGLViewScaleRatio();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.Projection
    public final float[] glProjectionMatrix() {
        return this.f151314g.f150514d.nativeGLProjectMatrix();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.Projection
    public final PointF glVertexForCoordinate(LatLng latLng) {
        return a(latLng);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.Projection
    public final float[] glViewMatrix() {
        return this.f151314g.z();
    }

    @Override // com.tencent.mapsdk.internal.fa, com.tencent.tencentmap.mapsdk.maps.Projection
    public final double metersPerPixel(double d16) {
        return metersPerPixel(d16, this.f151312b.a());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.Projection
    public final Point toScreenLocation(LatLng latLng) {
        Rect rect;
        PointF a16 = this.f151314g.a(latLng.latitude, latLng.longitude);
        float f16 = a16.x;
        float f17 = a16.y;
        ne neVar = this.f151313c;
        if (neVar != null && (rect = neVar.F) != null) {
            f16 += rect.left;
            f17 += rect.top;
        }
        fw fwVar = new fw(f16, f17);
        Point point = new Point();
        point.x = (int) Math.round(fwVar.f148383a);
        point.y = (int) Math.round(fwVar.f148384b);
        return point;
    }

    public static ge b(GeoPoint geoPoint) {
        if (geoPoint == null) {
            return null;
        }
        return new ge(((geoPoint.getLongitudeE6() / 1000000.0d) * 2.003750834E7d) / 180.0d, ((Math.log(Math.tan((((geoPoint.getLatitudeE6() / 1000000.0d) + 90.0d) * 3.141592653589793d) / 360.0d)) / 0.017453292519943295d) * 2.003750834E7d) / 180.0d);
    }

    @Override // com.tencent.mapsdk.internal.fa
    public final GeoPoint a(fw fwVar) {
        Rect rect;
        if (fwVar == null) {
            return null;
        }
        Rect rect2 = this.f151312b.f151265n;
        int height = rect2.height();
        float t16 = this.f151314g.t();
        if (String.valueOf(t16).equals("960.0")) {
            t16 = height;
        }
        double d16 = fwVar.f148384b;
        if (d16 >= rect2.top && d16 < (r1 + height) - t16) {
            d16 = (r1 + height) - t16;
        }
        float f16 = (float) fwVar.f148383a;
        float f17 = (float) d16;
        ne neVar = this.f151313c;
        if (neVar != null && (rect = neVar.F) != null) {
            f16 -= rect.left;
            f17 -= rect.top;
        }
        tk tkVar = this.f151314g;
        return (GeoPoint) tkVar.b((CallbackRunnable<tk.AnonymousClass109>) new tk.AnonymousClass109(null, f16, f17), (tk.AnonymousClass109) new GeoPoint());
    }

    @Override // com.tencent.mapsdk.internal.fa, com.tencent.tencentmap.mapsdk.maps.Projection
    public final double metersPerPixel(double d16, double d17) {
        if (d17 >= 0.0d) {
            return (4.0076E7d / ((Math.pow(2.0d, d17) * 256.0d) * ho.o())) * Math.cos((d16 * 3.141592653589793d) / 180.0d);
        }
        return 0.0d;
    }

    private static LatLng b(ge geVar) {
        if (geVar == null) {
            return null;
        }
        return new LatLng(((Math.atan(Math.exp((((geVar.y() / 2.003750834E7d) * 180.0d) * 3.141592653589793d) / 180.0d)) * 2.0d) - 1.5707963267948966d) * 57.29577951308232d, (geVar.x() / 2.003750834E7d) * 180.0d);
    }

    private void b(float f16) {
        this.f151312b.a(f16);
    }

    public static v.b c(LatLng latLng) {
        ge b16 = b(new GeoPoint(latLng));
        v.b bVar = new v.b();
        bVar.f151292a = Math.round(Math.floor(b16.x() / 9783.939619140625d));
        bVar.f151293b = Math.round(Math.floor(b16.y() / 9783.939619140625d));
        bVar.f151294c = 12L;
        return bVar;
    }

    @Override // com.tencent.mapsdk.internal.fa
    public final ge b(LatLng latLng) {
        if (latLng == null) {
            return null;
        }
        return b(GeoPoint.from(latLng));
    }

    static /* synthetic */ boolean b(y yVar) {
        v.c cVar = yVar.f151312b.f151269r;
        if (cVar != null) {
            return ((double) Math.abs(cVar.f151295a)) > 0.25d || ((double) Math.abs(cVar.f151296b)) > 0.25d;
        }
        return false;
    }

    @Override // com.tencent.mapsdk.internal.fa
    public final fw a(GeoPoint geoPoint) {
        Rect rect;
        if (geoPoint == null) {
            return null;
        }
        PointF a16 = this.f151314g.a(geoPoint.getLatitudeE6() / 1000000.0d, geoPoint.getLongitudeE6() / 1000000.0d);
        float f16 = a16.x;
        float f17 = a16.y;
        ne neVar = this.f151313c;
        if (neVar != null && (rect = neVar.F) != null) {
            f16 += rect.left;
            f17 += rect.top;
        }
        return new fw(f16, f17);
    }

    public final void c(GeoPoint geoPoint) {
        int i3;
        int i16;
        v vVar = this.f151312b;
        int latitudeE6 = geoPoint.getLatitudeE6();
        int longitudeE6 = geoPoint.getLongitudeE6();
        int i17 = 1 << (20 - vVar.f151253b.f151291q);
        if (131072 > i17) {
            i3 = ((vVar.f151265n.width() * 131072) - (vVar.f151265n.width() * i17)) / 2;
            i16 = ((vVar.f151265n.height() * 131072) - (vVar.f151265n.height() * i17)) / 2;
        } else {
            i3 = 0;
            i16 = 0;
        }
        Rect rect = vVar.f151254c;
        int i18 = rect.left - i3;
        int i19 = rect.right + i3;
        int i26 = rect.top - i16;
        int i27 = rect.bottom + i16;
        if (latitudeE6 < i26) {
            latitudeE6 = i26;
        }
        if (latitudeE6 <= i27) {
            i27 = latitudeE6;
        }
        if (longitudeE6 < i18) {
            longitudeE6 = i18;
        }
        if (longitudeE6 <= i19) {
            i19 = longitudeE6;
        }
        GeoPoint geoPoint2 = new GeoPoint(i27, i19);
        tk tkVar = vVar.f151267p;
        tkVar.f150520j.a(new tk.AnonymousClass183(geoPoint2));
    }

    @Override // com.tencent.mapsdk.internal.fa
    public final LatLng a(PointF pointF) {
        PointF pointF2;
        float s16 = this.f151313c.f149410w.f151267p.s();
        Rect rect = this.f151312b.f151265n;
        float width = rect.width();
        float height = rect.height();
        GeoPoint geoPoint = this.f151312b.f151264m;
        if (geoPoint == null) {
            return new LatLng(0.0d, 0.0d);
        }
        fw d16 = d(ks.a(geoPoint));
        v.c cVar = this.f151312b.f151269r;
        if (cVar == null) {
            pointF2 = new PointF(width / 2.0f, height / 2.0f);
        } else {
            pointF2 = new PointF((cVar.f151295a + 0.5f) * width, (cVar.f151296b + 0.5f) * height);
        }
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        matrix.setRotate(-s16);
        if (cVar == null) {
            matrix.preTranslate(width * (-0.5f), (-0.5f) * height);
            matrix.postTranslate(width * 0.5f, height * 0.5f);
        } else {
            matrix.preTranslate(((-0.5f) - cVar.f151295a) * width, ((-0.5f) - cVar.f151296b) * height);
            matrix.postTranslate((cVar.f151295a + 0.5f) * width, (cVar.f151296b + 0.5f) * height);
        }
        matrix.mapPoints(new float[2], new float[]{pointF.x, pointF.y});
        double o16 = (2.003750834E7d / ((1 << this.f151312b.f151253b.f151291q) * 256)) * ho.o();
        return b(new fw(d16.f148383a + ((r1[0] - pointF2.x) * o16), d16.f148384b + ((r1[1] - pointF2.y) * o16)));
    }

    private boolean c() {
        v.c cVar = this.f151312b.f151269r;
        if (cVar == null) {
            return false;
        }
        return (cVar.f151295a == 0.0f && cVar.f151296b == 0.0f) ? false : true;
    }

    @Override // com.tencent.mapsdk.internal.fa
    public final LatLng[] a() {
        Rect rect = this.f151313c.f149405r;
        float width = rect.width();
        float height = rect.height();
        return new LatLng[]{this.f151313c.f149403p.a(new PointF(0.0f, 0.0f)), this.f151313c.f149403p.a(new PointF(width, 0.0f)), this.f151313c.f149403p.a(new PointF(width, height)), this.f151313c.f149403p.a(new PointF(0.0f, height))};
    }

    @Override // com.tencent.mapsdk.internal.fa
    public final double a(Point point, Point point2) {
        GeoPoint a16 = a(new fw(point.x, point.y));
        GeoPoint a17 = a(new fw(point2.x, point2.y));
        Location.distanceBetween(a16.getLatitudeE6() / 1000000.0d, a16.getLongitudeE6() / 1000000.0d, a17.getLatitudeE6() / 1000000.0d, a17.getLongitudeE6() / 1000000.0d, new float[1]);
        return r2[0] / ((int) Math.sqrt(Math.pow(point.x - point2.x, 2.0d) + Math.pow(point.y - point2.y, 2.0d)));
    }

    @Override // com.tencent.mapsdk.internal.fa
    public final PointF a(LatLng latLng) {
        if (latLng == null) {
            return null;
        }
        double d16 = (latLng.longitude / 360.0d) + 0.5d;
        double sin = Math.sin(Math.toRadians(latLng.latitude));
        return new PointF((float) (d16 * 2.68435456E8d), (float) ((((Math.log((sin + 1.0d) / (1.0d - sin)) * 0.5d) / (-6.283185307179586d)) + 0.5d) * 2.68435456E8d));
    }

    public static LatLng[] a(v.b bVar) {
        double d16 = 4.007501668E7d / (1 << ((int) bVar.f151294c));
        return new LatLng[]{b(new ge(bVar.f151292a * d16, bVar.f151293b * d16)), b(new ge((bVar.f151292a + 1) * d16, bVar.f151293b * d16)), b(new ge((bVar.f151292a + 1) * d16, (bVar.f151293b + 1) * d16)), b(new ge(bVar.f151292a * d16, d16 * (bVar.f151293b + 1)))};
    }

    private void a(int i3) {
        this.f151312b.c(i3);
    }

    public final void a(float f16) {
        v vVar = this.f151312b;
        tk tkVar = vVar.f151267p;
        if (tkVar != null) {
            tkVar.a(new tk.AnonymousClass188(f16));
        }
        vVar.f151253b.f151290p = f16;
        int i3 = gh.f148490a;
    }

    @Override // com.tencent.mapsdk.internal.fa
    public final void a(final List<? extends Boundable> list, final List<GeoPoint> list2, final Rect rect, final fa.a aVar) {
        if (list.isEmpty() && (list2 == null || list2.isEmpty())) {
            return;
        }
        Rect rect2 = new Rect(this.f151313c.f149405r);
        rect2.left += rect.left;
        rect2.right -= rect.right;
        rect2.top += rect.top;
        rect2.bottom -= rect.bottom;
        final int width = rect2.width();
        final int height = rect2.height();
        ne neVar = this.f151313c;
        final aa aaVar = neVar.f149398k.f147732o;
        final int i3 = aaVar.f147672e;
        neVar.a(new ne.a() { // from class: com.tencent.mapsdk.internal.y.1
            @Override // com.tencent.mapsdk.internal.ne.a
            public final void a(GL10 gl10) {
                v vVar = y.this.f151312b;
                GeoPoint geoPoint = vVar.f151264m;
                v.a aVar2 = vVar.f151253b;
                float f16 = aVar2.f151290p;
                float f17 = aVar2.f151286l;
                GeoPoint geoPoint2 = null;
                float f18 = 4.0f;
                while (true) {
                    if (f18 < f17) {
                        break;
                    }
                    y.this.a(f18);
                    Rect a16 = y.a(y.this, list, list2);
                    GeoPoint geoPoint3 = new GeoPoint(a16.centerY(), a16.centerX());
                    y.this.c(geoPoint3);
                    GeoPoint geoPoint4 = new GeoPoint(a16.top, a16.left);
                    GeoPoint geoPoint5 = new GeoPoint(a16.bottom, a16.right);
                    fw a17 = y.this.a(geoPoint4);
                    fw a18 = y.this.a(geoPoint5);
                    Rect rect3 = new Rect();
                    rect3.left = (int) Math.min(a17.f148383a, a18.f148383a);
                    rect3.right = (int) Math.max(a17.f148383a, a18.f148383a);
                    rect3.top = (int) Math.min(a17.f148384b, a18.f148384b);
                    rect3.bottom = (int) Math.max(a17.f148384b, a18.f148384b);
                    if (width >= rect3.width() && height >= rect3.height()) {
                        if (!y.a(y.this)) {
                            geoPoint2 = y.a(y.this, geoPoint3, rect);
                        } else {
                            if (y.b(y.this)) {
                                y yVar = y.this;
                                v.c cVar = yVar.f151312b.f151269r;
                                if (cVar != null) {
                                    geoPoint2 = y.a(yVar, geoPoint3, cVar);
                                }
                            }
                            geoPoint2 = geoPoint3;
                        }
                    } else {
                        f18 /= 1.01f;
                        geoPoint2 = geoPoint3;
                    }
                }
                float max = Math.max(f17, f18);
                int i16 = i3;
                if (i16 != 60) {
                    aaVar.a(i16);
                }
                y.this.c(geoPoint);
                y.this.a(f16);
                fa.a aVar3 = aVar;
                if (aVar3 != null) {
                    try {
                        aVar3.a(max, geoPoint2);
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                }
            }
        });
        if (i3 != 60) {
            aaVar.f147672e = 60;
        }
    }

    private Rect a(List<? extends Boundable> list, List<GeoPoint> list2) {
        int i3;
        int i16;
        int i17;
        Rect bound;
        int i18 = 0;
        if (list != null) {
            i3 = 0;
            i16 = 0;
            i17 = 0;
            for (Boundable boundable : list) {
                if (boundable != null && (bound = boundable.getBound(this)) != null) {
                    if (i18 == 0) {
                        i18 = bound.left;
                    }
                    if (i3 == 0) {
                        i3 = bound.right;
                    }
                    if (i16 == 0) {
                        i16 = bound.top;
                    }
                    if (i17 == 0) {
                        i17 = bound.bottom;
                    }
                    int i19 = bound.left;
                    if (i19 < i18) {
                        i18 = i19;
                    }
                    int i26 = bound.right;
                    if (i26 > i3) {
                        i3 = i26;
                    }
                    int i27 = bound.top;
                    if (i27 > i16) {
                        i16 = i27;
                    }
                    int i28 = bound.bottom;
                    if (i28 < i17) {
                        i17 = i28;
                    }
                }
            }
        } else {
            i3 = 0;
            i16 = 0;
            i17 = 0;
        }
        if (list2 != null) {
            for (GeoPoint geoPoint : list2) {
                if (geoPoint != null) {
                    if (i18 == 0) {
                        i18 = geoPoint.getLongitudeE6();
                    }
                    if (i3 == 0) {
                        i3 = geoPoint.getLongitudeE6();
                    }
                    if (i16 == 0) {
                        i16 = geoPoint.getLatitudeE6();
                    }
                    if (i17 == 0) {
                        i17 = geoPoint.getLatitudeE6();
                    }
                    if (geoPoint.getLongitudeE6() < i18) {
                        i18 = geoPoint.getLongitudeE6();
                    }
                    if (geoPoint.getLongitudeE6() > i3) {
                        i3 = geoPoint.getLongitudeE6();
                    }
                    if (geoPoint.getLatitudeE6() > i16) {
                        i16 = geoPoint.getLatitudeE6();
                    }
                    if (geoPoint.getLatitudeE6() < i17) {
                        i17 = geoPoint.getLatitudeE6();
                    }
                }
            }
        }
        return new Rect(i18, i16, i3, i17);
    }

    private GeoPoint a(GeoPoint geoPoint, Rect rect) {
        fw a16;
        if (geoPoint == null || (a16 = a(geoPoint)) == null || rect == null) {
            return null;
        }
        return a(new fw(a16.f148383a - ((rect.left - rect.right) * 0.5d), a16.f148384b - ((rect.top - rect.bottom) * 0.5d)));
    }

    private GeoPoint a(GeoPoint geoPoint, v.c cVar) {
        fw a16;
        if (geoPoint == null || (a16 = a(geoPoint)) == null || cVar == null) {
            return null;
        }
        double d16 = a16.f148383a;
        double d17 = a16.f148384b;
        Rect rect = new Rect(this.f151313c.f149405r);
        int width = rect.width();
        int height = rect.height();
        float f16 = cVar.f151295a + 0.5f;
        float f17 = cVar.f151296b + 0.5f;
        double d18 = f16;
        if (d18 < 0.25d) {
            d16 += (0.25d - d18) * width;
        } else if (d18 > 0.75d) {
            d16 -= (d18 - 0.75d) * width;
        }
        double d19 = f17;
        if (d19 < 0.25d) {
            d17 += (0.25d - d19) * height;
        } else if (d19 > 0.75d) {
            d17 -= (d19 - 0.75d) * height;
        }
        return a(new fw(d16, d17));
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x014e  */
    @Override // com.tencent.mapsdk.internal.fa
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final float a(LatLng latLng, LatLng latLng2, int i3, int i16, int i17, int i18, LatLng latLng3) {
        int i19;
        int i26;
        LatLng latLng4;
        double d16;
        double d17;
        double d18;
        double d19;
        double d26;
        Context context = this.f151313c.getContext();
        Rect b16 = this.f151313c.f149398k.b();
        ne neVar = this.f151313c;
        boolean z16 = neVar.f149398k.N;
        int i27 = b16.left;
        int i28 = b16.right;
        int i29 = b16.top;
        int i36 = b16.bottom;
        int width = neVar.f149405r.width();
        int height = this.f151313c.f149405r.height();
        v vVar = this.f151313c.f149410w;
        v.a aVar = vVar.f151253b;
        float f16 = aVar.f151289o;
        float f17 = aVar.f151288n;
        v.c cVar = vVar.f151269r;
        if (width == 0 || height == 0 || latLng == null || latLng2 == null) {
            return -2.0f;
        }
        if (i3 + i16 + i27 + i28 > width || i17 + i18 + i29 + i36 > height) {
            return -1.0f;
        }
        fw a16 = a(context, latLng);
        fw a17 = a(context, latLng2);
        double d27 = a17.f148383a - a16.f148383a;
        if (d27 < 0.0d) {
            d27 = Math.abs(d27);
        }
        double d28 = a17.f148384b - a16.f148384b;
        if (d28 < 0.0d) {
            d28 = Math.abs(d28);
        }
        int i37 = (((width - i3) - i16) - i27) - i28;
        int i38 = (((height - i17) - i18) - i29) - i36;
        if (i37 <= 0) {
            i37 = 1;
        }
        if (i38 <= 0) {
            i26 = width;
            i19 = 1;
        } else {
            i19 = i38;
            i26 = width;
        }
        double max = Math.max(d27 / i37, d28 / i19);
        float log = (float) (20.0d - (Math.log(max) / Math.log(2.0d)));
        if (f16 < log) {
            max = Math.pow(2.0d, 20.0f - f16);
        } else {
            f16 = log;
        }
        if (f17 > f16) {
            max = Math.pow(2.0d, 20.0f - f17);
            latLng4 = latLng3;
            f16 = f17;
        } else {
            latLng4 = latLng3;
        }
        if (latLng4 == null) {
            return f16;
        }
        float f18 = f16;
        double d29 = ((i17 - i18) * max) / 2.0d;
        fw a18 = a(context, new LatLng((latLng.latitude + latLng2.latitude) / 2.0d, (latLng.longitude + latLng2.longitude) / 2.0d));
        double d36 = max;
        double d37 = a18.f148383a + (((i16 - i3) * max) / 2.0d);
        a18.f148383a = d37;
        double d38 = a18.f148384b + d29;
        a18.f148384b = d38;
        if (z16) {
            int i39 = i27 - i28;
            int i46 = i29 - i36;
            int i47 = i26;
            double d39 = (i39 / (i47 * 2.0f)) + 0.5f;
            if (d39 < 0.25d) {
                d16 = i47 * (-0.5d);
            } else {
                if (d39 > 0.75d) {
                    d16 = i47 * 0.5d;
                }
                d17 = (i46 / (height * 2.0f)) + 0.5f;
                if (d17 >= 0.25d) {
                    d18 = height * (-0.5d);
                } else {
                    if (d17 > 0.75d) {
                        d18 = height * 0.5d;
                    }
                    double d46 = (i39 * d36) / 2.0d;
                    double d47 = (i46 * d36) / 2.0d;
                    if (cVar == null) {
                        d26 = 0.0d;
                        d19 = 0.0d;
                    } else {
                        double d48 = cVar.f151295a;
                        d19 = cVar.f151296b;
                        d26 = d48;
                    }
                    d37 = (d37 - d46) + (d26 * i47 * d36);
                    d38 = (d38 - d47) - ((d19 * height) * d36);
                }
                i46 = (int) d18;
                double d462 = (i39 * d36) / 2.0d;
                double d472 = (i46 * d36) / 2.0d;
                if (cVar == null) {
                }
                d37 = (d37 - d462) + (d26 * i47 * d36);
                d38 = (d38 - d472) - ((d19 * height) * d36);
            }
            i39 = (int) d16;
            d17 = (i46 / (height * 2.0f)) + 0.5f;
            if (d17 >= 0.25d) {
            }
            i46 = (int) d18;
            double d4622 = (i39 * d36) / 2.0d;
            double d4722 = (i46 * d36) / 2.0d;
            if (cVar == null) {
            }
            d37 = (d37 - d4622) + (d26 * i47 * d36);
            d38 = (d38 - d4722) - ((d19 * height) * d36);
        }
        fw fwVar = new fw(d37, d38);
        double a19 = ht.a(context) * 2.68435456E8f;
        double d49 = a19 / 2.0d;
        LatLng latLng5 = new LatLng((Math.asin(1.0d - (2.0d / (Math.pow(2.718281828459045d, ((fwVar.f148384b - d49) / 0.5d) / (a19 / 6.283185307179586d)) + 1.0d))) * 180.0d) / 3.141592653589793d, (fwVar.f148383a - d49) / (a19 / 360.0d));
        latLng3.latitude = latLng5.latitude;
        latLng3.longitude = latLng5.longitude;
        return f18;
    }

    private static LatLng a(Context context, fw fwVar) {
        double a16 = ht.a(context) * 2.68435456E8f;
        double d16 = a16 / 2.0d;
        return new LatLng((Math.asin(1.0d - (2.0d / (Math.pow(2.718281828459045d, ((fwVar.f148384b - d16) / 0.5d) / (a16 / 6.283185307179586d)) + 1.0d))) * 180.0d) / 3.141592653589793d, (fwVar.f148383a - d16) / (a16 / 360.0d));
    }

    @Override // com.tencent.mapsdk.internal.fa
    public final fw a(Context context, LatLng latLng) {
        double a16 = ht.a(context) * 2.68435456E8f;
        double d16 = a16 / 2.0d;
        double min = Math.min(Math.max(Math.sin(latLng.latitude * 0.017453292519943295d), -0.9999d), 0.9999d);
        return new fw((latLng.longitude * (a16 / 360.0d)) + d16, d16 + (Math.log((min + 1.0d) / (1.0d - min)) * (a16 / 6.283185307179586d) * 0.5d));
    }

    @Override // com.tencent.mapsdk.internal.fa
    public final LatLng a(ge geVar) {
        return b(geVar);
    }

    public static fw a(v vVar, GeoPoint geoPoint) {
        if (geoPoint == null) {
            return null;
        }
        int i3 = vVar.f151255d >> 1;
        double d16 = vVar.f151256e;
        double d17 = vVar.f151257f;
        double min = Math.min(Math.max(Math.sin((geoPoint.getLatitudeE6() / 1000000.0d) * 0.017453292519943295d), -0.9999d), 0.9999d);
        double d18 = i3;
        return new fw(((geoPoint.getLongitudeE6() / 1000000.0d) * d16) + d18, d18 + (Math.log((min + 1.0d) / (1.0d - min)) * d17 * 0.5d));
    }

    static /* synthetic */ Rect a(y yVar, List list, List list2) {
        int i3;
        int i16;
        int i17;
        Rect bound;
        int i18 = 0;
        if (list != null) {
            Iterator it = list.iterator();
            i3 = 0;
            i16 = 0;
            i17 = 0;
            while (it.hasNext()) {
                Boundable boundable = (Boundable) it.next();
                if (boundable != null && (bound = boundable.getBound(yVar)) != null) {
                    if (i18 == 0) {
                        i18 = bound.left;
                    }
                    if (i3 == 0) {
                        i3 = bound.right;
                    }
                    if (i16 == 0) {
                        i16 = bound.top;
                    }
                    if (i17 == 0) {
                        i17 = bound.bottom;
                    }
                    int i19 = bound.left;
                    if (i19 < i18) {
                        i18 = i19;
                    }
                    int i26 = bound.right;
                    if (i26 > i3) {
                        i3 = i26;
                    }
                    int i27 = bound.top;
                    if (i27 > i16) {
                        i16 = i27;
                    }
                    int i28 = bound.bottom;
                    if (i28 < i17) {
                        i17 = i28;
                    }
                }
            }
        } else {
            i3 = 0;
            i16 = 0;
            i17 = 0;
        }
        if (list2 != null) {
            Iterator it5 = list2.iterator();
            while (it5.hasNext()) {
                GeoPoint geoPoint = (GeoPoint) it5.next();
                if (geoPoint != null) {
                    if (i18 == 0) {
                        i18 = geoPoint.getLongitudeE6();
                    }
                    if (i3 == 0) {
                        i3 = geoPoint.getLongitudeE6();
                    }
                    if (i16 == 0) {
                        i16 = geoPoint.getLatitudeE6();
                    }
                    if (i17 == 0) {
                        i17 = geoPoint.getLatitudeE6();
                    }
                    if (geoPoint.getLongitudeE6() < i18) {
                        i18 = geoPoint.getLongitudeE6();
                    }
                    if (geoPoint.getLongitudeE6() > i3) {
                        i3 = geoPoint.getLongitudeE6();
                    }
                    if (geoPoint.getLatitudeE6() > i16) {
                        i16 = geoPoint.getLatitudeE6();
                    }
                    if (geoPoint.getLatitudeE6() < i17) {
                        i17 = geoPoint.getLatitudeE6();
                    }
                }
            }
        }
        return new Rect(i18, i16, i3, i17);
    }

    static /* synthetic */ boolean a(y yVar) {
        v.c cVar = yVar.f151312b.f151269r;
        if (cVar != null) {
            return (cVar.f151295a == 0.0f && cVar.f151296b == 0.0f) ? false : true;
        }
        return false;
    }

    static /* synthetic */ GeoPoint a(y yVar, GeoPoint geoPoint, Rect rect) {
        fw a16 = yVar.a(geoPoint);
        if (a16 == null || rect == null) {
            return null;
        }
        return yVar.a(new fw(a16.f148383a - ((rect.left - rect.right) * 0.5d), a16.f148384b - ((rect.top - rect.bottom) * 0.5d)));
    }

    static /* synthetic */ GeoPoint a(y yVar, GeoPoint geoPoint, v.c cVar) {
        fw a16 = yVar.a(geoPoint);
        if (a16 == null || cVar == null) {
            return null;
        }
        double d16 = a16.f148383a;
        double d17 = a16.f148384b;
        Rect rect = new Rect(yVar.f151313c.f149405r);
        int width = rect.width();
        int height = rect.height();
        float f16 = cVar.f151295a + 0.5f;
        float f17 = cVar.f151296b + 0.5f;
        double d18 = f16;
        if (d18 < 0.25d) {
            d16 += (0.25d - d18) * width;
        } else if (d18 > 0.75d) {
            d16 -= (d18 - 0.75d) * width;
        }
        double d19 = f17;
        if (d19 < 0.25d) {
            d17 += (0.25d - d19) * height;
        } else if (d19 > 0.75d) {
            d17 -= (d19 - 0.75d) * height;
        }
        return yVar.a(new fw(d16, d17));
    }
}
