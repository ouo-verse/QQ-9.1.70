package com.tencent.mapsdk.internal;

import android.graphics.Rect;
import android.util.Pair;
import com.tencent.map.tools.IndexCallback;
import com.tencent.tencentmap.mapsdk.maps.model.ArcOptions;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.Polyline;
import com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class pl extends po<ah> implements ah {

    /* renamed from: b, reason: collision with root package name */
    as f149514b;

    /* renamed from: d, reason: collision with root package name */
    private final ne f149515d;

    /* renamed from: p, reason: collision with root package name */
    private LatLng f149516p;

    /* renamed from: q, reason: collision with root package name */
    private LatLng f149517q;

    /* renamed from: r, reason: collision with root package name */
    private LatLng f149518r;

    /* renamed from: s, reason: collision with root package name */
    private float f149519s;

    /* renamed from: t, reason: collision with root package name */
    private LatLng f149520t;

    /* renamed from: u, reason: collision with root package name */
    private double f149521u;

    /* renamed from: v, reason: collision with root package name */
    private double f149522v;

    /* renamed from: w, reason: collision with root package name */
    private int f149523w;

    /* renamed from: x, reason: collision with root package name */
    private float f149524x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f149525y;

    public pl(ArcOptions arcOptions, bb bbVar) {
        super(bbVar);
        float angle;
        this.f149523w = -16776961;
        this.f149524x = 10.0f;
        ne b16 = bbVar.b();
        this.f149515d = b16;
        if (b16 != null && arcOptions != null) {
            LatLng startLatLng = arcOptions.getStartLatLng();
            LatLng passLatLng = arcOptions.getPassLatLng();
            LatLng endLatLng = arcOptions.getEndLatLng();
            if (arcOptions.getAngle() >= 0.0f) {
                angle = arcOptions.getAngle() % 360.0f;
            } else {
                angle = (arcOptions.getAngle() % 360.0f) + 360.0f;
            }
            if (startLatLng != null && endLatLng != null && !startLatLng.equals(endLatLng)) {
                if (passLatLng != null || (angle != 0.0f && angle != 180.0f)) {
                    if (passLatLng == null || (!passLatLng.equals(startLatLng) && !passLatLng.equals(endLatLng))) {
                        if (this.f149516p != startLatLng) {
                            this.f149516p = startLatLng;
                            w();
                        }
                        if (this.f149517q != endLatLng) {
                            this.f149517q = endLatLng;
                            w();
                        }
                        if (this.f149518r != passLatLng) {
                            this.f149518r = passLatLng;
                            w();
                        }
                        if (this.f149519s != angle) {
                            this.f149519s = angle;
                            w();
                        }
                        setColor(arcOptions.getColor());
                        setWidth(arcOptions.getWidth());
                        setStrokeWidth(arcOptions.getStrokeWidth());
                        setStrokeColor(arcOptions.getStrokeColor());
                        this.f149525y = arcOptions.isShowArrow();
                        if (v()) {
                            e();
                        }
                    }
                }
            }
        }
    }

    private void b(LatLng latLng) {
        if (this.f149517q != latLng) {
            this.f149517q = latLng;
            w();
        }
    }

    private void c(LatLng latLng) {
        if (this.f149518r != latLng) {
            this.f149518r = latLng;
            w();
        }
    }

    private void e() {
        boolean z16;
        double a16;
        boolean z17;
        boolean z18;
        LatLng latLng = this.f149516p;
        LatLng latLng2 = this.f149518r;
        LatLng latLng3 = this.f149517q;
        float f16 = this.f149519s;
        ge b16 = this.f149515d.f149403p.b(latLng);
        ge b17 = this.f149515d.f149403p.b(latLng3);
        ge geVar = new ge(0.0d, 0.0d);
        if (f16 == 0.0f) {
            ge b18 = this.f149515d.f149403p.b(latLng2);
            double a17 = lj.a(b16, b18, b17, geVar);
            if (lj.a(b16.x(), b16.y(), b17.x(), b17.y(), b18.x(), b18.y()) > 0.0d) {
                z18 = true;
            } else {
                z18 = false;
            }
            z17 = z18;
            a16 = a17;
        } else {
            if (f16 < 180.0f) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (f16 > 180.0f) {
                f16 = 360.0f - f16;
            }
            a16 = lj.a(b16, b17, f16 * 2.0f, z16, geVar);
            z17 = z16;
        }
        this.f149520t = this.f149515d.f149403p.a(geVar);
        this.f149521u = lj.b(b16, b17, geVar);
        this.f149522v = lj.a(b16, geVar);
        final LatLng[] latLngArr = new LatLng[360];
        lj.a(geVar, a16, b16, b17, z17, new IndexCallback<Pair<Double, Double>>() { // from class: com.tencent.mapsdk.internal.pl.1
            private void a(int i3, Pair<Double, Double> pair) {
                latLngArr[i3] = pl.this.f149515d.f149403p.a(new ge(((Double) pair.first).doubleValue(), ((Double) pair.second).doubleValue()));
            }

            @Override // com.tencent.map.tools.IndexCallback
            public final /* synthetic */ void callback(int i3, Pair<Double, Double> pair) {
                Pair<Double, Double> pair2 = pair;
                latLngArr[i3] = pl.this.f149515d.f149403p.a(new ge(((Double) pair2.first).doubleValue(), ((Double) pair2.second).doubleValue()));
            }
        });
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f149516p);
        for (int i3 = 0; i3 < 360; i3++) {
            LatLng latLng4 = latLngArr[i3];
            if (latLng4 != null) {
                arrayList.add(latLng4);
            }
        }
        arrayList.add(this.f149517q);
        as asVar = this.f149514b;
        if (asVar != null) {
            asVar.remove();
        }
        Polyline a18 = this.f149515d.a(new PolylineOptions().addAll(arrayList).color(this.f149523w).width(this.f149524x).borderWidth(getStrokeWidth()).borderColor(getStrokeColor()).zIndex(getZIndex()).level(getLevel()).arrow(this.f149525y).lineCap(true));
        if (a18 instanceof az) {
            this.f149514b = ((az) a18).f147788j;
        }
        this.f149515d.f149412y = true;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Arc
    public final LatLng getCenter() {
        return this.f149520t;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Colorable
    public final int getColor() {
        return this.f149523w;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Arc
    public final double getLength() {
        return this.f149521u;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Arc
    public final double getRadius() {
        return this.f149522v;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Widthable
    public final float getWidth() {
        return this.f149524x;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mapsdk.internal.po
    public final void h_() {
        super.h_();
        as asVar = this.f149514b;
        if (asVar != null) {
            asVar.remove();
            this.f149514b = null;
        }
    }

    @Override // com.tencent.mapsdk.internal.po
    public final void j_() {
        if (this.f149515d != null && this.f149514b != null) {
            if (!isVisible()) {
                this.f149514b.remove();
                return;
            }
            if (v()) {
                e();
                as asVar = this.f149514b;
                if (asVar instanceof ex) {
                    ex exVar = (ex) asVar;
                    if (a() == -1) {
                        this.f149561m = exVar.a();
                    } else {
                        exVar.p();
                    }
                }
            }
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Colorable
    public final void setColor(int i3) {
        if (this.f149523w != i3) {
            this.f149523w = i3;
            w();
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Widthable
    public final void setWidth(float f16) {
        if (this.f149524x != f16) {
            this.f149524x = f16;
            w();
        }
    }

    private void a(LatLng latLng) {
        if (this.f149516p != latLng) {
            this.f149516p = latLng;
            w();
        }
    }

    @Override // com.tencent.mapsdk.internal.po, com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.interfaces.Boundable
    /* renamed from: b */
    public final Rect getBound(fa faVar) {
        LatLng latLng = this.f149520t;
        if (latLng != null) {
            ge b16 = faVar.b(latLng);
            double d16 = b16.f148480c;
            double d17 = this.f149522v;
            ge geVar = new ge(d16 - d17, b16.f148479b - d17);
            double d18 = b16.f148480c;
            double d19 = this.f149522v;
            ge geVar2 = new ge(d18 + d19, b16.f148479b + d19);
            LatLng a16 = faVar.a(geVar);
            LatLng a17 = faVar.a(geVar2);
            Rect rect = new Rect();
            rect.left = (int) (a16.longitude * 1000000.0d);
            rect.top = (int) (a16.latitude * 1000000.0d);
            rect.right = (int) (a17.longitude * 1000000.0d);
            rect.bottom = (int) (a17.latitude * 1000000.0d);
            return rect;
        }
        return super.getBound(faVar);
    }

    private void a(float f16) {
        if (this.f149519s != f16) {
            this.f149519s = f16;
            w();
        }
    }

    @Override // com.tencent.mapsdk.internal.ah
    public final void a(ArcOptions arcOptions) {
        if (this.f149515d == null || arcOptions == null) {
            return;
        }
        LatLng startLatLng = arcOptions.getStartLatLng();
        LatLng passLatLng = arcOptions.getPassLatLng();
        LatLng endLatLng = arcOptions.getEndLatLng();
        float angle = arcOptions.getAngle() >= 0.0f ? arcOptions.getAngle() % 360.0f : (arcOptions.getAngle() % 360.0f) + 360.0f;
        if (startLatLng == null || endLatLng == null || startLatLng.equals(endLatLng)) {
            return;
        }
        if (passLatLng == null && (angle == 0.0f || angle == 180.0f)) {
            return;
        }
        if (passLatLng == null || !(passLatLng.equals(startLatLng) || passLatLng.equals(endLatLng))) {
            if (this.f149516p != startLatLng) {
                this.f149516p = startLatLng;
                w();
            }
            if (this.f149517q != endLatLng) {
                this.f149517q = endLatLng;
                w();
            }
            if (this.f149518r != passLatLng) {
                this.f149518r = passLatLng;
                w();
            }
            if (this.f149519s != angle) {
                this.f149519s = angle;
                w();
            }
            setColor(arcOptions.getColor());
            setWidth(arcOptions.getWidth());
            setStrokeWidth(arcOptions.getStrokeWidth());
            setStrokeColor(arcOptions.getStrokeColor());
            this.f149525y = arcOptions.isShowArrow();
            if (v()) {
                e();
            }
        }
    }

    private ah d() {
        return this;
    }

    @Override // com.tencent.mapsdk.internal.aw
    public final /* bridge */ /* synthetic */ aq f_() {
        return this;
    }

    private void a(boolean z16) {
        this.f149525y = z16;
    }
}
