package com.tencent.mapsdk.internal;

import android.graphics.Rect;
import com.tencent.map.lib.models.CircleInfo;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.map.tools.CallbackRunnable;
import com.tencent.mapsdk.internal.tk;
import com.tencent.tencentmap.mapsdk.maps.model.CircleOptions;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class pm extends po<ai> implements ai, or {

    /* renamed from: b, reason: collision with root package name */
    private static final int f149528b = 128;

    /* renamed from: d, reason: collision with root package name */
    private GeoPoint f149529d;

    /* renamed from: p, reason: collision with root package name */
    private double f149530p;

    /* renamed from: q, reason: collision with root package name */
    private float f149531q;

    /* renamed from: r, reason: collision with root package name */
    private int f149532r;

    /* renamed from: s, reason: collision with root package name */
    private final ArrayList<Integer> f149533s;

    /* renamed from: t, reason: collision with root package name */
    private CircleOptions f149534t;

    /* renamed from: u, reason: collision with root package name */
    private final CircleInfo f149535u;

    /* renamed from: v, reason: collision with root package name */
    private final ne f149536v;

    public pm(bb bbVar) {
        super(bbVar);
        this.f149529d = new GeoPoint(39909230, 116397428);
        this.f149530p = 0.0d;
        this.f149531q = 1000.0f;
        this.f149532r = 0;
        this.f149533s = new ArrayList<>();
        this.f149535u = new CircleInfo();
        this.f149536v = bbVar.b();
    }

    private double d() {
        return this.f149531q;
    }

    private void e() {
        if (a() == -1) {
            tk tkVar = this.f149536v.f149396i;
            this.f149561m = ((Integer) tkVar.a((CallbackRunnable<tk.AnonymousClass68>) new tk.AnonymousClass68(this.f149535u), (tk.AnonymousClass68) (-1))).intValue();
        } else if (v()) {
            tk tkVar2 = this.f149536v.f149396i;
            int a16 = a();
            CircleInfo circleInfo = this.f149535u;
            if (tkVar2.f150515e != 0 && circleInfo != null) {
                tkVar2.a(new tk.AnonymousClass79(a16, circleInfo));
            }
            this.f149536v.f149412y = true;
        }
    }

    public final void a(CircleOptions circleOptions) {
        if (circleOptions == null) {
            return;
        }
        this.f149534t = circleOptions;
        LatLng center = circleOptions.getCenter();
        if (center != null) {
            a(GeoPoint.from(center));
        }
        setRadius(circleOptions.getRadius());
        setStrokeWidth(circleOptions.getStrokeWidth());
        setStrokeColor(circleOptions.getStrokeColor());
        setFillColor(circleOptions.getFillColor());
        setZIndex(circleOptions.getZIndex());
        setVisible(circleOptions.isVisible());
        setLevel(circleOptions.getLevel());
        a(circleOptions.getBorderType().ordinal());
        a(circleOptions.getPattern());
        this.f149534t = circleOptions;
        w();
    }

    @Override // com.tencent.mapsdk.internal.po, com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.interfaces.Boundable
    /* renamed from: b */
    public final Rect getBound(fa faVar) {
        double a16 = a(this.f149530p, this.f149529d.getLatitudeE6() / 1000000.0d);
        ge a17 = a(new LatLng(this.f149529d.getLatitudeE6() / 1000000.0d, this.f149529d.getLongitudeE6() / 1000000.0d));
        ge geVar = new ge(a17.f148480c - a16, a17.f148479b + a16);
        ge geVar2 = new ge(a17.f148480c + a16, a17.f148479b - a16);
        LatLng a18 = a(geVar);
        LatLng a19 = a(geVar2);
        Rect rect = new Rect();
        rect.left = (int) (a18.longitude * 1000000.0d);
        rect.top = (int) (a18.latitude * 1000000.0d);
        rect.right = (int) (a19.longitude * 1000000.0d);
        rect.bottom = (int) (a19.latitude * 1000000.0d);
        return rect;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Circle
    public final boolean contains(LatLng latLng) {
        LatLng center = getCenter();
        double d16 = center.longitude;
        double d17 = d16 * 0.01745329251994329d;
        double d18 = center.latitude * 0.01745329251994329d;
        double d19 = latLng.longitude * 0.01745329251994329d;
        double d26 = latLng.latitude * 0.01745329251994329d;
        double sin = Math.sin(d17);
        double sin2 = Math.sin(d18);
        double cos = Math.cos(d17);
        double cos2 = Math.cos(d18);
        double sin3 = Math.sin(d19);
        double sin4 = Math.sin(d26);
        double cos3 = Math.cos(d19);
        double cos4 = Math.cos(d26);
        double[] dArr = {cos * cos2, cos2 * sin, sin2};
        double d27 = cos3 * cos4;
        double d28 = cos4 * sin3;
        double d29 = dArr[0];
        double d36 = (d29 - d27) * (d29 - d27);
        double d37 = dArr[1];
        double d38 = d36 + ((d37 - d28) * (d37 - d28));
        double d39 = dArr[2];
        if (Math.asin(Math.sqrt(d38 + ((d39 - sin4) * (d39 - sin4))) / 2.0d) * 1.27420015798544E7d >= getRadius()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mapsdk.internal.or
    public final boolean g_() {
        return false;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Circle
    public final LatLng getCenter() {
        GeoPoint geoPoint = this.f149529d;
        if (geoPoint != null) {
            return geoPoint.toLatLng();
        }
        return null;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Circle
    public final double getRadius() {
        return this.f149530p;
    }

    @Override // com.tencent.mapsdk.internal.po
    public final void h_() {
        ne neVar;
        if (a() != -1 && (neVar = this.f149536v) != null) {
            tk tkVar = neVar.f149396i;
            int a16 = a();
            if (tkVar.f150515e != 0 && a16 >= 0 && tkVar.f150520j != null) {
                tkVar.a(new tk.AnonymousClass90(a16));
            }
            this.f149561m = -1;
        }
    }

    @Override // com.tencent.mapsdk.internal.po
    public final void j_() {
        if (this.f149536v == null) {
            return;
        }
        p();
        if (a() == -1) {
            tk tkVar = this.f149536v.f149396i;
            this.f149561m = ((Integer) tkVar.a((CallbackRunnable<tk.AnonymousClass68>) new tk.AnonymousClass68(this.f149535u), (tk.AnonymousClass68) (-1))).intValue();
        } else if (v()) {
            tk tkVar2 = this.f149536v.f149396i;
            int a16 = a();
            CircleInfo circleInfo = this.f149535u;
            if (tkVar2.f150515e != 0 && circleInfo != null) {
                tkVar2.a(new tk.AnonymousClass79(a16, circleInfo));
            }
            this.f149536v.f149412y = true;
        }
    }

    @Override // com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.interfaces.Tappable
    public final boolean onTap(float f16, float f17) {
        ne neVar;
        if (this.f149529d != null && (neVar = this.f149536v) != null) {
            GeoPoint a16 = neVar.f149403p.a(new fw(f16, f17));
            if (Math.hypot(a16.getLatitudeE6() - this.f149529d.getLatitudeE6(), a16.getLongitudeE6() - this.f149529d.getLongitudeE6()) <= this.f149531q) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mapsdk.internal.po, com.tencent.mapsdk.internal.ex
    public final void p() {
        GeoPoint geoPoint;
        if ((a() <= 0 || v()) && this.f149536v != null && (geoPoint = this.f149529d) != null) {
            double d16 = this.f149530p;
            if (d16 > 0.0d) {
                CircleInfo circleInfo = this.f149535u;
                circleInfo.zIndex = (int) this.f149556h;
                circleInfo.borderColor = this.f149555g;
                circleInfo.borderWidth = this.f149553e;
                circleInfo.fillColor = this.f149554f;
                circleInfo.radius = (float) d16;
                circleInfo.centerX = geoPoint.getLongitudeE6();
                this.f149535u.centerY = this.f149529d.getLatitudeE6();
                CircleInfo circleInfo2 = this.f149535u;
                circleInfo2.isVisible = this.f149557i;
                circleInfo2.level = this.f149560l;
                circleInfo2.borderType = this.f149532r;
                circleInfo2.patterns = new int[this.f149533s.size()];
                for (int i3 = 0; i3 < this.f149533s.size(); i3++) {
                    this.f149535u.patterns[i3] = this.f149533s.get(i3).intValue();
                }
                w();
            }
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Circle
    public final void setCenter(LatLng latLng) {
        a(GeoPoint.from(latLng));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Circle
    public final void setOptions(CircleOptions circleOptions) {
        a(circleOptions);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Circle
    public final void setRadius(double d16) {
        if (d16 < 0.0d) {
            return;
        }
        if (d16 == 0.0d) {
            d16 = 1.0E-10d;
        }
        CircleOptions circleOptions = this.f149534t;
        if (circleOptions != null && circleOptions.getCenter() != null) {
            this.f149530p = d16;
            this.f149531q = (float) ho.a(d16, this.f149534t.getCenter().latitude);
            w();
        }
    }

    private void a(GeoPoint geoPoint) {
        if (geoPoint == null) {
            return;
        }
        GeoPoint geoPoint2 = this.f149529d;
        if (geoPoint2 == null) {
            this.f149529d = new GeoPoint(geoPoint.getLatitudeE6(), geoPoint.getLongitudeE6());
        } else {
            geoPoint2.setLatitudeE6(geoPoint.getLatitudeE6());
            this.f149529d.setLongitudeE6(geoPoint.getLongitudeE6());
        }
        w();
    }

    private void a(int i3) {
        this.f149532r = i3;
        w();
    }

    private void a(List<Integer> list) {
        if (list == null || list.size() != 2) {
            return;
        }
        this.f149533s.clear();
        this.f149533s.addAll(list);
        w();
    }

    private ai f() {
        return this;
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

    @Override // com.tencent.mapsdk.internal.aw
    public final /* bridge */ /* synthetic */ aq f_() {
        return this;
    }

    private static double a(double d16, double d17) {
        return d16 / Math.cos((d17 * 3.141592653589793d) / 180.0d);
    }

    private static ge a(LatLng latLng) {
        return new ge((latLng.longitude * 2.003750834E7d) / 180.0d, ((Math.log(Math.tan(((latLng.latitude + 90.0d) * 3.141592653589793d) / 360.0d)) / 0.017453292519943295d) * 2.003750834E7d) / 180.0d);
    }

    private static LatLng a(ge geVar) {
        return new LatLng((float) (((Math.atan(Math.exp((((float) ((geVar.f148479b * 180.0d) / 2.003750834E7d)) * 3.141592653589793d) / 180.0d)) * 2.0d) - 1.5707963267948966d) * 57.29577951308232d), (float) ((geVar.f148480c * 180.0d) / 2.003750834E7d));
    }
}
