package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.map.tools.CallbackRunnable;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.mapsdk.engine.jni.models.TappedElement;
import com.tencent.mapsdk.internal.tk;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Selectable;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerCollisionRelation;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerCollisionRelationUnit;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class qx extends po<aq> implements MarkerCollisionRelationUnit {

    /* renamed from: b, reason: collision with root package name */
    protected qy f149955b;

    /* renamed from: d, reason: collision with root package name */
    protected final pi f149956d;

    /* renamed from: p, reason: collision with root package name */
    protected Selectable.OnSelectedListener f149957p;

    /* renamed from: q, reason: collision with root package name */
    protected fw f149958q;

    /* renamed from: r, reason: collision with root package name */
    public ic f149959r;

    /* renamed from: s, reason: collision with root package name */
    public qx f149960s;

    /* renamed from: t, reason: collision with root package name */
    public final List<qx> f149961t;

    /* renamed from: u, reason: collision with root package name */
    public MarkerCollisionRelation f149962u;

    /* renamed from: v, reason: collision with root package name */
    private final nd f149963v;

    /* renamed from: w, reason: collision with root package name */
    private final bf f149964w;

    /* renamed from: x, reason: collision with root package name */
    private ic f149965x;

    /* renamed from: y, reason: collision with root package name */
    private final aq f149966y;

    /* renamed from: z, reason: collision with root package name */
    private final AtomicBoolean f149967z;

    public qx(aq aqVar, bb bbVar, qy qyVar) {
        super(bbVar);
        this.f149958q = new fw();
        this.f149965x = null;
        this.f149961t = new CopyOnWriteArrayList();
        this.f149962u = MarkerCollisionRelation.ALONE;
        this.f149967z = new AtomicBoolean(false);
        this.f149966y = aqVar;
        this.f149963v = bbVar.c();
        this.f149964w = bbVar.getMapContext();
        this.f149955b = qyVar;
        this.f149956d = new pi(this, qyVar);
        setVisible(true);
        a(qyVar);
    }

    private boolean A() {
        pi piVar = this.f149956d;
        if (piVar != null) {
            return piVar.f149510y;
        }
        return false;
    }

    private float B() {
        pi piVar = this.f149956d;
        if (piVar != null) {
            return piVar.f149503r;
        }
        return 0.0f;
    }

    private float C() {
        pi piVar = this.f149956d;
        if (piVar != null) {
            return piVar.f149504s;
        }
        return 0.0f;
    }

    private float D() {
        pi piVar = this.f149956d;
        if (piVar != null) {
            return piVar.f149505t;
        }
        return 0.0f;
    }

    private float E() {
        pi piVar = this.f149956d;
        if (piVar != null) {
            return piVar.f149506u;
        }
        return 0.0f;
    }

    private boolean F() {
        qy qyVar = this.f149955b;
        if (qyVar != null) {
            return qyVar.f149981n;
        }
        return false;
    }

    private static boolean G() {
        return false;
    }

    private boolean H() {
        qy qyVar = this.f149955b;
        if (qyVar != null) {
            return qyVar.f149993z;
        }
        return true;
    }

    private List<qx> I() {
        return this.f149961t;
    }

    private qx J() {
        return this.f149960s;
    }

    private MarkerCollisionRelation K() {
        return this.f149962u;
    }

    private void a(ic icVar) {
        this.f149959r = icVar;
    }

    private void b(ic icVar) {
        if (icVar == null) {
            return;
        }
        this.f149965x = icVar;
        icVar.a();
    }

    private void h() {
        pi piVar = this.f149956d;
        if (piVar != null) {
            piVar.a(true);
        }
    }

    private GeoPoint i() {
        return this.f149955b.f149976i;
    }

    private int j() {
        return this.f149955b.f149982o;
    }

    private float k() {
        return this.f149955b.f149980m;
    }

    private float l() {
        pi piVar = this.f149956d;
        if (piVar != null) {
            return piVar.f149508w;
        }
        return 1.0f;
    }

    private float m() {
        pi piVar = this.f149956d;
        if (piVar != null) {
            return piVar.f149509x;
        }
        return 1.0f;
    }

    private qy n() {
        return this.f149955b;
    }

    private pi z() {
        return this.f149956d;
    }

    public final void c(boolean z16) {
        qy qyVar = this.f149955b;
        if (qyVar != null) {
            qyVar.f149992y = z16;
        }
        pi piVar = this.f149956d;
        if (piVar != null) {
            piVar.d(z16);
            this.f149956d.a(true);
        }
    }

    public final float d() {
        return this.f149955b.f149978k;
    }

    public final float e() {
        return this.f149955b.f149979l;
    }

    public final void f() {
        ic icVar = this.f149959r;
        if (icVar != null) {
            icVar.f148766b = false;
        }
    }

    @Override // com.tencent.mapsdk.internal.aw
    public final aq f_() {
        return this.f149966y;
    }

    public final boolean g() {
        pi piVar = this.f149956d;
        if (piVar == null) {
            return false;
        }
        return piVar.C;
    }

    @Override // com.tencent.mapsdk.internal.po, com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.interfaces.Levelable
    public final int getZIndex() {
        return this.f149955b.f149986s;
    }

    @Override // com.tencent.mapsdk.internal.po
    public final void h_() {
        super.h_();
        f();
        for (qx qxVar : this.f149961t) {
            if (b(qxVar)) {
                qxVar.remove();
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.po, com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.interfaces.Selectable
    public final boolean isSelected() {
        if (this.f149956d.N == 1) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mapsdk.internal.po, com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.interfaces.Visible
    public final boolean isVisible() {
        return this.f149956d.J;
    }

    @Override // com.tencent.mapsdk.internal.po
    public final void j_() {
        if (this.f149963v == null) {
            return;
        }
        ic icVar = this.f149965x;
        if (icVar != null) {
            if (!icVar.f148768d) {
                icVar.b();
            } else {
                this.f149965x = null;
            }
        }
        ic icVar2 = this.f149959r;
        if (icVar2 != null && !icVar2.f148768d) {
            icVar2.b();
        }
        pi piVar = this.f149956d;
        boolean z16 = true;
        if (piVar != null) {
            nd ndVar = this.f149963v;
            int a16 = piVar.I.a();
            if (a16 > 0 && ndVar.f149382c.containsKey(Integer.valueOf(a16))) {
                if (piVar.f149502q.get() > 0) {
                    piVar.f149501p = true;
                    piVar.f149502q.set(0);
                }
                if (piVar.f149501p) {
                    tk tkVar = ndVar.f149381b;
                    if (0 != tkVar.f150515e) {
                        tkVar.a(new tk.AnonymousClass145(piVar));
                    }
                    if (piVar.B.get() > 0) {
                        piVar.A = true;
                        piVar.B.set(0);
                    }
                    if (piVar.A) {
                        if (!piVar.H) {
                            ndVar.f149384e.add(piVar.f149492g);
                        }
                        hn.f148686b.a(piVar.f149491f, piVar.d());
                        piVar.b(false);
                    }
                }
                piVar.a(false);
                ndVar.f149383d.put(Integer.valueOf(a16), piVar);
            } else {
                LogUtil.b("Marker", "addMarker GIcon before [" + a16 + "]");
                tk tkVar2 = ndVar.f149381b;
                int intValue = ((Integer) tkVar2.a((CallbackRunnable<tk.AnonymousClass144>) new tk.AnonymousClass144(piVar), (tk.AnonymousClass144) 0)).intValue();
                piVar.I.f149561m = intValue;
                LogUtil.b("Marker", "addMarker GIcon after [" + intValue + "]");
                if (intValue > 0) {
                    hn.f148686b.a(piVar.f149491f, piVar.d());
                    piVar.b(false);
                    piVar.a(false);
                    ndVar.f149383d.put(Integer.valueOf(intValue), piVar);
                    LogUtil.b("Marker", "mCurFrameDisplayMap: " + ndVar.f149383d.keySet());
                }
            }
        }
        if (this.f149967z.get() && a() > 0) {
            qx qxVar = this.f149960s;
            if (qxVar != null) {
                String id5 = qxVar.getId();
                int a17 = this.f149960s.a();
                if (a17 > 0) {
                    LogUtil.b("Marker", "setMarkerMainSubRelation parent[" + id5 + ":" + a17 + "] => child[" + getId() + " :" + a() + "] relation:" + this.f149962u);
                    tk g16 = this.f149964w.g();
                    int a18 = a();
                    if (this.f149962u != MarkerCollisionRelation.TOGETHER) {
                        z16 = false;
                    }
                    g16.a(a17, a18, z16);
                    this.f149967z.set(false);
                    return;
                }
                return;
            }
            LogUtil.b("Marker", "setMarkerMainSubRelation parent[-1] => child[" + getId() + " :" + a() + "] relation:" + this.f149962u);
            tk g17 = this.f149964w.g();
            int a19 = a();
            if (this.f149962u != MarkerCollisionRelation.TOGETHER) {
                z16 = false;
            }
            g17.a(-1, a19, z16);
            this.f149967z.set(false);
        }
    }

    @Override // com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.interfaces.Tappable
    public final boolean onTap(float f16, float f17) {
        bf bfVar;
        boolean z16;
        Selectable.OnSelectedListener onSelectedListener;
        if (!isVisible() || this.f149955b.f149976i == null || (bfVar = this.f149964w) == null) {
            return false;
        }
        TappedElement a16 = bfVar.g().a(f16, f17);
        if (a16 != null && a16.itemId == a()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.f149956d.b(1);
        } else {
            this.f149956d.b(0);
        }
        if (z16 && (onSelectedListener = this.f149957p) != null) {
            onSelectedListener.onSelected(this);
        }
        return z16;
    }

    @Override // com.tencent.mapsdk.internal.po, com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.interfaces.Levelable, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay
    public final void setLevel(int i3) {
        qy qyVar = this.f149955b;
        qyVar.f149987t = i3;
        this.f149955b = qyVar;
        pi piVar = this.f149956d;
        if (piVar != null) {
            piVar.F = i3;
            piVar.a(true);
        }
    }

    @Override // com.tencent.mapsdk.internal.po, com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.interfaces.Selectable
    public final void setSelected(boolean z16) {
        if (z16) {
            this.f149956d.b(1);
        } else {
            this.f149956d.b(0);
        }
    }

    @Override // com.tencent.mapsdk.internal.po, com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.interfaces.Selectable
    public final void setSelectedListener(Selectable.OnSelectedListener onSelectedListener) {
        this.f149957p = onSelectedListener;
    }

    @Override // com.tencent.mapsdk.internal.po, com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.interfaces.Visible
    public final void setVisible(boolean z16) {
        boolean z17;
        super.setVisible(z16);
        pi piVar = this.f149956d;
        if (piVar.J != z16) {
            z17 = true;
        } else {
            z17 = false;
        }
        piVar.a(z17);
        piVar.J = z16;
    }

    @Override // com.tencent.mapsdk.internal.po, com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.interfaces.Levelable
    public final void setZIndex(int i3) {
        qy qyVar = this.f149955b;
        qyVar.f149986s = i3;
        this.f149955b = qyVar;
        pi piVar = this.f149956d;
        if (piVar != null) {
            piVar.G = i3;
            piVar.a(true);
        }
    }

    public final String toString() {
        return "GLMarkerOverlayImpl{id='" + getId() + "'nativeId='" + a() + "'tag='" + getTag() + "'}";
    }

    public final void a(qy qyVar) {
        if (qyVar == null) {
            return;
        }
        this.f149955b = qyVar;
        this.f149956d.a(qyVar);
        setTag(qyVar.A);
    }

    private void e(boolean z16) {
        this.f149955b.f149983p = z16;
    }

    @Override // com.tencent.mapsdk.internal.po, com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.interfaces.Boundable
    /* renamed from: b */
    public final Rect getBound(fa faVar) {
        qy qyVar;
        if (this.f149956d == null || (qyVar = this.f149955b) == null || qyVar.f149976i == null) {
            return null;
        }
        if (A()) {
            GeoPoint geoPoint = this.f149955b.f149976i;
            fw fwVar = new fw(0.0d, 0.0d);
            if (geoPoint != null) {
                fwVar.f148383a = geoPoint.getLongitudeE6();
                fwVar.f148384b = geoPoint.getLatitudeE6();
            }
            this.f149958q = fwVar;
        } else {
            this.f149958q = faVar.a(this.f149955b.f149976i);
        }
        fw fwVar2 = new fw();
        fw fwVar3 = new fw();
        Bitmap d16 = this.f149956d.d();
        if (d16 == null) {
            return null;
        }
        int width = d16.getWidth();
        int height = d16.getHeight();
        fw fwVar4 = this.f149958q;
        fwVar2.f148383a = fwVar4.f148383a;
        fwVar3.f148383a = fwVar4.f148383a + width;
        fwVar2.f148384b = fwVar4.f148384b;
        fwVar3.f148384b = fwVar4.f148384b + height;
        qy qyVar2 = this.f149955b;
        int i3 = (int) (qyVar2.f149978k * width);
        int i16 = (int) (qyVar2.f149979l * height);
        double d17 = i3;
        fwVar2.f148383a -= d17;
        fwVar3.f148383a -= d17;
        double d18 = i16;
        fwVar2.f148384b -= d18;
        fwVar3.f148384b -= d18;
        int i17 = qyVar2.f149984q;
        int i18 = qyVar2.f149985r;
        double d19 = i17;
        fwVar2.f148383a += d19;
        fwVar3.f148383a += d19;
        double d26 = i18;
        fwVar2.f148384b += d26;
        fwVar3.f148384b += d26;
        GeoPoint a16 = faVar.a(fwVar2);
        GeoPoint a17 = faVar.a(fwVar3);
        return new Rect(a16.getLongitudeE6(), a16.getLatitudeE6(), a17.getLongitudeE6(), a17.getLatitudeE6());
    }

    public final void d(boolean z16) {
        pi piVar = this.f149956d;
        if (piVar == null) {
            return;
        }
        piVar.C = z16;
        piVar.a(true);
    }

    private void c(qx qxVar) {
        this.f149967z.set(this.f149960s != qxVar);
        this.f149960s = qxVar;
        if (qxVar != null) {
            LogUtil.b("Marker", "this[" + getId() + " :" + a() + "] set parent => parent:[" + qxVar.getId() + ":" + qxVar.a() + "] changed:" + this.f149967z.get());
            return;
        }
        LogUtil.b("Marker", "this[" + getId() + " :" + a() + "] set parent => null changed:" + this.f149967z.get());
    }

    @Override // com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.interfaces.Boundable
    /* renamed from: a */
    public final Rect getScreenBound(fa faVar) {
        qy qyVar;
        int i3;
        int i16;
        if (this.f149956d == null || (qyVar = this.f149955b) == null || qyVar.f149976i == null) {
            return null;
        }
        if (A()) {
            GeoPoint geoPoint = this.f149955b.f149976i;
            fw fwVar = new fw(0.0d, 0.0d);
            if (geoPoint != null) {
                fwVar.f148383a = geoPoint.getLongitudeE6();
                fwVar.f148384b = geoPoint.getLatitudeE6();
            }
            this.f149958q = fwVar;
        } else {
            this.f149958q = faVar.a(this.f149955b.f149976i);
        }
        fw fwVar2 = new fw();
        fw fwVar3 = new fw();
        Bitmap d16 = this.f149956d.d();
        if (d16 != null) {
            i3 = d16.getWidth();
            i16 = d16.getHeight();
        } else {
            i3 = 0;
            i16 = 0;
        }
        fw fwVar4 = this.f149958q;
        fwVar2.f148383a = fwVar4.f148383a;
        fwVar3.f148383a = fwVar4.f148383a + i3;
        fwVar2.f148384b = fwVar4.f148384b;
        fwVar3.f148384b = fwVar4.f148384b + i16;
        qy qyVar2 = this.f149955b;
        int i17 = (int) (qyVar2.f149978k * i3);
        int i18 = (int) (qyVar2.f149979l * i16);
        double d17 = i17;
        fwVar2.f148383a -= d17;
        fwVar3.f148383a -= d17;
        double d18 = i18;
        fwVar2.f148384b -= d18;
        fwVar3.f148384b -= d18;
        int i19 = qyVar2.f149984q;
        int i26 = qyVar2.f149985r;
        double d19 = i19;
        fwVar2.f148383a += d19;
        fwVar3.f148383a += d19;
        double d26 = i26;
        fwVar2.f148384b += d26;
        fwVar3.f148384b += d26;
        return new Rect((int) fwVar2.f148383a, (int) fwVar2.f148384b, (int) fwVar3.f148383a, (int) fwVar3.f148384b);
    }

    public final void b(float f16, float f17) {
        pi piVar = this.f149956d;
        if (piVar != null) {
            piVar.f149508w = f16;
            piVar.f149509x = f17;
            piVar.a(true);
            this.f149956d.a(true);
        }
    }

    private void a(String str, Bitmap... bitmapArr) {
        a(str, false, bitmapArr);
    }

    private void a(int i3, int i16) {
        qy qyVar = this.f149955b;
        qyVar.f149984q = i3;
        qyVar.f149985r = i16;
        pi piVar = this.f149956d;
        if (piVar != null) {
            piVar.f149496k = i3;
            piVar.f149497l = i16;
            piVar.a(true);
            this.f149956d.a(true);
        }
    }

    public final void b(boolean z16) {
        qy qyVar = this.f149955b;
        if (qyVar != null) {
            qyVar.f149991x = z16;
        }
        pi piVar = this.f149956d;
        if (piVar != null) {
            piVar.c(z16);
            this.f149956d.a(true);
        }
    }

    public final void a(String str, boolean z16, Bitmap... bitmapArr) {
        this.f149955b = this.f149955b.a(str, bitmapArr);
        pi piVar = this.f149956d;
        if (piVar != null) {
            piVar.H = z16;
            piVar.a(str, bitmapArr);
            this.f149956d.a(true);
        }
    }

    public final boolean b(qx qxVar) {
        LogUtil.b("Marker", "this[" + getId() + " :" + a() + "] removeChild => child[" + qxVar.getId() + ":" + qxVar.a() + "]");
        boolean remove = this.f149961t.remove(qxVar);
        if (remove) {
            qxVar.c((qx) null);
        }
        return remove;
    }

    public final void a(GeoPoint geoPoint) {
        qy qyVar = this.f149955b;
        qyVar.f149976i = geoPoint;
        this.f149955b = qyVar;
        pi piVar = this.f149956d;
        if (piVar != null) {
            if (geoPoint != null) {
                double d16 = piVar.f149510y ? 1.0d : 1000000.0d;
                piVar.f149494i = geoPoint.getLongitudeE6() / d16;
                piVar.f149495j = geoPoint.getLatitudeE6() / d16;
                piVar.a(true);
            }
            this.f149956d.a(true);
        }
    }

    public final void a(int i3) {
        qy qyVar = this.f149955b;
        qyVar.f149982o = i3;
        this.f149955b = qyVar;
        pi piVar = this.f149956d;
        if (piVar != null) {
            piVar.a(i3);
            this.f149956d.a(true);
        }
    }

    public final void a(float f16) {
        qy qyVar = this.f149955b;
        qyVar.f149980m = f16;
        this.f149955b = qyVar;
        pi piVar = this.f149956d;
        if (piVar != null) {
            piVar.a(f16);
            this.f149956d.a(true);
        }
    }

    public final void a(float f16, float f17) {
        this.f149955b = this.f149955b.a(f16, f17);
        pi piVar = this.f149956d;
        if (piVar != null) {
            piVar.a(f16, f17);
            this.f149956d.a(true);
        }
    }

    public final void a(boolean z16) {
        pi piVar = this.f149956d;
        if (piVar != null) {
            piVar.f149510y = z16;
            piVar.a(true);
        }
    }

    public final void a(qx qxVar) {
        LogUtil.b("Marker", "this[" + getId() + " :" + a() + "] addChild => child[" + qxVar.getId() + ":" + qxVar.a() + "]");
        this.f149961t.add(qxVar);
        qxVar.c(this);
    }

    private void a(MarkerCollisionRelation markerCollisionRelation) {
        this.f149962u = markerCollisionRelation;
    }
}
