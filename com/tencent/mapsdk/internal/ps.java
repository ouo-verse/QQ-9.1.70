package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.mapsdk.vector.VectorMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Collision;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class ps extends aw<ao> implements ao, oz {

    /* renamed from: d, reason: collision with root package name */
    private final tr f149637d;

    /* renamed from: e, reason: collision with root package name */
    private View f149638e;

    /* renamed from: j, reason: collision with root package name */
    private GeoPoint f149643j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f149644k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f149645l;

    /* renamed from: o, reason: collision with root package name */
    private final ap f149648o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f149649p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f149650q;

    /* renamed from: f, reason: collision with root package name */
    private int f149639f = 0;

    /* renamed from: g, reason: collision with root package name */
    private int f149640g = 0;

    /* renamed from: h, reason: collision with root package name */
    private float f149641h = 0.5f;

    /* renamed from: i, reason: collision with root package name */
    private float f149642i = 0.5f;

    /* renamed from: m, reason: collision with root package name */
    private boolean f149646m = false;

    /* renamed from: n, reason: collision with root package name */
    private final fw f149647n = new fw();

    public ps(tr trVar, ap apVar) {
        TencentMap.InfoWindowAdapter infoWindowAdapter;
        this.f149637d = trVar;
        this.f149648o = apVar;
        h();
        if (trVar != null && trVar.H() != null) {
            if (apVar != null) {
                infoWindowAdapter = apVar.g();
            } else {
                infoWindowAdapter = null;
            }
            this.f149638e = pn.a(trVar.H(), (bf) trVar.d_, this, infoWindowAdapter, apVar);
            if (apVar != null) {
                a(apVar.getPosition());
            }
        }
        this.f149644k = true;
    }

    private void h() {
        M m3;
        tr trVar = this.f149637d;
        if (trVar != null && (m3 = trVar.e_) != 0) {
            ((VectorMap) m3).a((oz) this);
        }
    }

    private void i() {
        M m3;
        tr trVar = this.f149637d;
        if (trVar != null && (m3 = trVar.e_) != 0) {
            ((VectorMap) m3).f151351o.b(this);
        }
    }

    private void l() {
        TencentMap.InfoWindowAdapter infoWindowAdapter;
        tr trVar = this.f149637d;
        if (trVar != null && trVar.H() != null) {
            ap apVar = this.f149648o;
            if (apVar != null) {
                infoWindowAdapter = apVar.g();
            } else {
                infoWindowAdapter = null;
            }
            this.f149638e = pn.a(this.f149637d.H(), (bf) this.f149637d.d_, this, infoWindowAdapter, this.f149648o);
            ap apVar2 = this.f149648o;
            if (apVar2 != null) {
                a(apVar2.getPosition());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        final View view;
        VectorMap vectorMap;
        ViewGroup p16;
        tr trVar = this.f149637d;
        if (trVar != null && (view = this.f149638e) != null && (vectorMap = (VectorMap) trVar.e_) != null && vectorMap.getProjection() != null && (p16 = p()) != null) {
            p16.post(new Runnable() { // from class: com.tencent.mapsdk.internal.ps.1
                @Override // java.lang.Runnable
                public final void run() {
                    boolean z16;
                    if (!ps.this.f149649p) {
                        view.setVisibility(8);
                        return;
                    }
                    view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                    ps.this.f149639f = view.getMeasuredWidth();
                    ps.this.f149640g = view.getMeasuredHeight();
                    View view2 = view;
                    view2.layout(0, 0, view2.getMeasuredWidth(), view.getMeasuredHeight());
                    ViewGroup ab5 = ps.this.f149637d.ab();
                    Rect screenBound = ps.this.getScreenBound(((VectorMap) ps.this.f149637d.e_).getProjection());
                    if (screenBound != null && ab5 != null) {
                        if (view.getParent() == null) {
                            int childCount = ab5.getChildCount();
                            int zIndex = ps.this.f149648o.getZIndex();
                            int i3 = childCount - 1;
                            int i16 = -1;
                            int i17 = -1;
                            while (true) {
                                if (i3 >= 0) {
                                    Object tag = ab5.getChildAt(i3).getTag();
                                    if (tag instanceof Integer) {
                                        if (zIndex >= ((Integer) tag).intValue()) {
                                            i16 = i3 + 1;
                                            z16 = true;
                                            break;
                                        }
                                        i17 = i3;
                                    }
                                    i3--;
                                } else {
                                    i3 = i17;
                                    z16 = false;
                                    break;
                                }
                            }
                            if (z16) {
                                i3 = i16;
                            }
                            view.setTag(Integer.valueOf(zIndex));
                            if (i3 < childCount) {
                                ab5.addView(view, i3);
                            } else {
                                ab5.addView(view);
                            }
                        }
                        Rect rect = new Rect();
                        ab5.getLocalVisibleRect(rect);
                        if (rect.isEmpty()) {
                            view.setVisibility(8);
                            return;
                        }
                        if (rect.intersect(screenBound)) {
                            view.setVisibility(0);
                        }
                        view.setX(screenBound.left);
                        view.setY(screenBound.top);
                    }
                }
            });
        }
    }

    private ViewGroup p() {
        tr trVar = this.f149637d;
        if (trVar == null) {
            return null;
        }
        return trVar.ab();
    }

    @Override // com.tencent.mapsdk.internal.ao
    public final int a() {
        return 0;
    }

    @Override // com.tencent.mapsdk.internal.ey
    public final void e() {
        float f16;
        if (this.f149648o != null && this.f149637d.H() != null) {
            int height = (int) (this.f149648o.getHeight(this.f149637d.H()) * this.f149648o.getAnchorV());
            int i3 = this.f149640g;
            if (this.f149648o.getOptions() != null) {
                f16 = this.f149648o.getOptions().getInfoWindowAnchorV();
            } else {
                f16 = 1.0f;
            }
            if (i3 == 0) {
                i3 = 1;
            }
            float f17 = i3;
            this.f149642i = (height + (f16 * f17)) / f17;
        }
    }

    @Override // com.tencent.mapsdk.internal.ey
    public final void f() {
        final TencentMap.InfoWindowAdapter infoWindowAdapter;
        tr trVar = this.f149637d;
        if (trVar != null && this.f149650q) {
            ap apVar = this.f149648o;
            if (apVar != null) {
                infoWindowAdapter = apVar.g();
            } else {
                infoWindowAdapter = null;
            }
            final Context H = trVar.H();
            final bf bfVar = (bf) trVar.d_;
            ViewGroup p16 = p();
            if (p16 != null) {
                p16.post(new Runnable() { // from class: com.tencent.mapsdk.internal.ps.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        ps psVar = ps.this;
                        psVar.f149638e = pn.a(H, bfVar, psVar, infoWindowAdapter, psVar.f149648o);
                        ps.this.m();
                    }
                });
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.ey
    public final View g() {
        return this.f149638e;
    }

    @Override // com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.model.IOverlay
    public final String getId() {
        return this.c_;
    }

    @Override // com.tencent.mapsdk.internal.ey
    public final void i_() {
        m();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Collisionable
    public final boolean isCollisionBy(Collision collision) {
        return false;
    }

    @Override // com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.interfaces.Removable
    public final boolean isRemoved() {
        return this.f149645l;
    }

    @Override // com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.interfaces.Visible
    public final boolean isVisible() {
        return this.f149649p;
    }

    @Override // com.tencent.mapsdk.internal.oz
    public final void j() {
        m();
    }

    @Override // com.tencent.mapsdk.internal.oz
    public final void k() {
        m();
    }

    @Override // com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.interfaces.Tappable
    public final boolean onTap(float f16, float f17) {
        tr trVar;
        M m3;
        Rect screenBound;
        if (this.f149638e == null || !this.f149644k || (trVar = this.f149637d) == null || (m3 = trVar.e_) == 0 || ((VectorMap) m3).getProjection() == null || (screenBound = getScreenBound(((VectorMap) this.f149637d.e_).getProjection())) == null || screenBound.isEmpty()) {
            return false;
        }
        return screenBound.contains((int) f16, (int) f17);
    }

    @Override // com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.interfaces.Removable
    public final void releaseData() {
        i();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.interfaces.Removable
    public final void remove() {
        final View view = this.f149638e;
        if (view == 0) {
            return;
        }
        final ViewParent parent = view.getParent();
        if (parent == null) {
            parent = (ViewParent) view;
        }
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).post(new Runnable() { // from class: com.tencent.mapsdk.internal.ps.3
                @Override // java.lang.Runnable
                public final void run() {
                    ((ViewGroup) parent).removeView(view);
                    View view2 = view;
                    if (view2 instanceof ViewGroup) {
                        ((ViewGroup) view2).removeAllViews();
                    }
                    ps.this.releaseData();
                }
            });
        }
        this.f149637d.d(getId());
        this.f149645l = true;
    }

    @Override // com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.interfaces.Visible
    public final void setVisible(boolean z16) {
        this.f149649p = z16;
        m();
    }

    @Override // com.tencent.mapsdk.internal.ey
    public final void a(MarkerOptions markerOptions) {
    }

    @Override // com.tencent.mapsdk.internal.ey
    public final void c(boolean z16) {
        if (this.f149638e == null) {
            return;
        }
        this.f149644k = z16;
        setVisible(z16);
    }

    @Override // com.tencent.mapsdk.internal.ey
    public final void d() {
        if (this.f149648o == null || this.f149637d.H() == null) {
            return;
        }
        int width = this.f149648o.getWidth(this.f149637d.H());
        float infoWindowAnchorU = this.f149648o.getOptions() != null ? this.f149648o.getOptions().getInfoWindowAnchorU() : 0.5f;
        int i3 = this.f149639f;
        if (i3 == 0) {
            i3 = 1;
        }
        this.f149641h = infoWindowAnchorU + ((width * (this.f149648o.getAnchorU() - 0.5f)) / i3);
    }

    @Override // com.tencent.mapsdk.internal.ey
    public final void b(boolean z16) {
        this.f149646m = z16;
        if (z16) {
            i();
        } else {
            h();
        }
    }

    @Override // com.tencent.mapsdk.internal.ey
    public final boolean c() {
        return this.f149644k;
    }

    @Override // com.tencent.mapsdk.internal.ey
    public final void a(boolean z16) {
        this.f149650q = z16;
        if (this.f149644k) {
            c(z16);
        }
    }

    @Override // com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.interfaces.Boundable
    /* renamed from: b */
    public final Rect getBound(fa faVar) {
        if (getScreenBound(faVar) != null && faVar != null) {
            GeoPoint a16 = faVar.a(new fw(r0.left, r0.top));
            GeoPoint a17 = faVar.a(new fw(r0.right, r0.bottom));
            if (a16 != null && a17 != null) {
                return new Rect(a16.getLongitudeE6(), a16.getLatitudeE6(), a17.getLongitudeE6(), a17.getLatitudeE6());
            }
        }
        return null;
    }

    @Override // com.tencent.mapsdk.internal.ey
    public final void a(LatLng latLng) {
        if (latLng == null) {
            return;
        }
        GeoPoint geoPoint = this.f149643j;
        if (geoPoint == null) {
            this.f149643j = GeoPoint.from(latLng);
        } else {
            geoPoint.setLatitudeE6((int) (latLng.latitude * 1000000.0d));
            this.f149643j.setLongitudeE6((int) (latLng.longitude * 1000000.0d));
        }
        m();
    }

    @Override // com.tencent.mapsdk.internal.ey
    public final void a(int i3, int i16) {
        b(true);
        this.f149647n.a(i3, i16);
        m();
    }

    @Override // com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.interfaces.Boundable
    /* renamed from: a */
    public final Rect getScreenBound(fa faVar) {
        fw a16;
        int i3;
        int i16;
        if (faVar == null || this.f149638e == null) {
            return null;
        }
        if (this.f149646m) {
            a16 = this.f149647n;
        } else {
            a16 = faVar.a(this.f149643j);
        }
        if (a16 == null) {
            return null;
        }
        ap apVar = this.f149648o;
        if (apVar == null || apVar.getOptions() == null) {
            i3 = 0;
            i16 = 0;
        } else {
            i3 = this.f149648o.getOptions().getInfoWindowOffsetX();
            i16 = this.f149648o.getOptions().getInfowindowOffsetY();
        }
        d();
        e();
        float f16 = this.f149641h;
        int i17 = this.f149639f;
        float f17 = f16 - ((i3 * 1.0f) / i17);
        float f18 = this.f149642i;
        int i18 = this.f149640g;
        float f19 = f18 - ((i16 * 1.0f) / i18);
        int i19 = (int) (a16.f148383a - (i17 * f17));
        int i26 = (int) (a16.f148384b - (i18 * f19));
        return new Rect(i19, i26, i17 + i19, i18 + i26);
    }

    private ao n() {
        return this;
    }

    @Override // com.tencent.mapsdk.internal.aw
    public final /* bridge */ /* synthetic */ ao f_() {
        return this;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Collisionable
    public final void setCollisions(Collision... collisionArr) {
    }
}
