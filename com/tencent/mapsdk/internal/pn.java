package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.map.tools.ReturnCallback;
import com.tencent.map.tools.Util;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.mapsdk.vector.VectorMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMapContext;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Collision;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerCollisionItem;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerCollisionRelation;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class pn extends po<ao> implements ao {

    /* renamed from: y, reason: collision with root package name */
    private static final AtomicInteger f149537y = new AtomicInteger(0);
    private View A;
    private Collision[] B;
    private boolean C;

    /* renamed from: d, reason: collision with root package name */
    qx f149538d;

    /* renamed from: p, reason: collision with root package name */
    private ap f149539p;

    /* renamed from: q, reason: collision with root package name */
    private Bitmap f149540q;

    /* renamed from: r, reason: collision with root package name */
    private int f149541r;

    /* renamed from: s, reason: collision with root package name */
    private int f149542s;

    /* renamed from: t, reason: collision with root package name */
    private GeoPoint f149543t;

    /* renamed from: u, reason: collision with root package name */
    private final tr f149544u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f149545v;

    /* renamed from: w, reason: collision with root package name */
    private float f149546w;

    /* renamed from: x, reason: collision with root package name */
    private float f149547x;

    /* renamed from: z, reason: collision with root package name */
    private boolean f149548z;

    public pn(tr trVar, ap apVar) {
        super(trVar);
        this.f149540q = null;
        this.f149541r = 0;
        this.f149542s = 0;
        this.f149543t = null;
        this.f149545v = false;
        this.f149546w = 0.5f;
        this.f149547x = 0.5f;
        this.f149548z = false;
        this.C = true;
        this.f149544u = trVar;
        this.f149539p = apVar;
        if (trVar != null && apVar != null && apVar.getOptions() != null) {
            i();
            if (((VectorMap) trVar.e_).f151351o.f149401n != null) {
                this.f149538d = new qx(this, trVar, b(apVar.getOptions()));
                LogUtil.b("create InfoWindowView:" + this.A);
                this.f149538d.f149962u = apVar.m();
                a(hn.a(this.A), apVar.getOptions().isIconLooperEnable());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static View a(Context context, bf bfVar, ey eyVar, TencentMap.InfoWindowAdapter infoWindowAdapter, Marker marker) {
        if (context == null || eyVar == null || marker == null || bfVar == null) {
            return null;
        }
        String title = marker.getTitle();
        String snippet = marker.getSnippet();
        if (infoWindowAdapter == null) {
            if (hs.a(title) && hs.a(snippet)) {
                return null;
            }
            return a(context, bfVar, eyVar, title, snippet);
        }
        LinearLayout linearLayout = (LinearLayout) eyVar.g();
        if (linearLayout == null) {
            linearLayout = a(context);
        }
        ax axVar = (ax) bfVar.c().f147879c.a(marker.getId(), ax.class);
        if (axVar == null) {
            return null;
        }
        View infoWindow = infoWindowAdapter.getInfoWindow(axVar);
        if (infoWindow != null) {
            if (infoWindow.getParent() == linearLayout) {
                return linearLayout;
            }
            if (infoWindow.getParent() instanceof ViewGroup) {
                ((ViewGroup) infoWindow.getParent()).removeAllViews();
            }
            linearLayout.setBackgroundDrawable(null);
            a(linearLayout);
            linearLayout.addView(infoWindow);
            return linearLayout;
        }
        View infoContents = infoWindowAdapter.getInfoContents(axVar);
        if (infoContents != null) {
            if (infoContents.getParent() == linearLayout) {
                return linearLayout;
            }
            if (infoContents.getParent() instanceof ViewGroup) {
                ((ViewGroup) infoContents.getParent()).removeAllViews();
            }
            a(linearLayout);
            a(linearLayout, "marker_infowindow.9.png");
            linearLayout.addView(infoContents);
            return linearLayout;
        }
        if (hs.a(title) && hs.a(snippet)) {
            return null;
        }
        a(linearLayout, "marker_infowindow.9.png");
        linearLayout.removeAllViews();
        a(bfVar, linearLayout, ey.f148339b, title);
        a(bfVar, linearLayout, ey.f148340c, snippet);
        return linearLayout;
    }

    private qy b(MarkerOptions markerOptions) {
        int infoWindowOffsetX = markerOptions.getInfoWindowOffsetX();
        int infowindowOffsetY = markerOptions.getInfowindowOffsetY();
        d();
        e();
        float f16 = this.f149546w - ((infoWindowOffsetX * 1.0f) / this.f149541r);
        float f17 = this.f149547x - ((infowindowOffsetY * 1.0f) / this.f149542s);
        MarkerCollisionItem[] infoWindowCollisions = markerOptions.getInfoWindowCollisions();
        if (infoWindowCollisions == null || markerOptions.getCollisionRelation() == MarkerCollisionRelation.TOGETHER) {
            infoWindowCollisions = markerOptions.getCollisions();
        }
        setCollisions(infoWindowCollisions);
        qy qyVar = new qy();
        qyVar.f149976i = GeoPoint.from(markerOptions.getPosition());
        qyVar.f149980m = markerOptions.getAlpha();
        qy a16 = qyVar.a(f16, f17);
        a16.f149981n = false;
        a16.f149991x = isCollisionBy(MarkerCollisionItem.POI);
        a16.f149992y = isCollisionBy(MarkerCollisionItem.MARKER);
        a16.f149986s = (int) markerOptions.getZIndex();
        a16.f149987t = markerOptions.getLevel();
        a16.f149988u = this.f149545v;
        a16.A = "InfoWindow Of " + markerOptions.getTag();
        a16.f149989v = true;
        return a16;
    }

    private void h() {
        ap apVar = this.f149539p;
        if (this.f149544u != null && apVar != null && apVar.getOptions() != null) {
            i();
            tr trVar = this.f149544u;
            if (((VectorMap) trVar.e_).f151351o.f149401n == null) {
                return;
            }
            this.f149538d = new qx(this, trVar, b(apVar.getOptions()));
            LogUtil.b("create InfoWindowView:" + this.A);
            this.f149538d.f149962u = apVar.m();
            a(hn.a(this.A), apVar.getOptions().isIconLooperEnable());
        }
    }

    private void i() {
        TencentMap.InfoWindowAdapter infoWindowAdapter;
        tr trVar = this.f149544u;
        if (trVar != null && trVar.H() != null) {
            ap apVar = this.f149539p;
            if (apVar != null) {
                infoWindowAdapter = apVar.g();
            } else {
                infoWindowAdapter = null;
            }
            View a16 = a(trVar.H(), (bf) trVar.d_, this, infoWindowAdapter, apVar);
            this.A = a16;
            if (a16 != null) {
                a16.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                this.f149541r = this.A.getMeasuredWidth();
                this.f149542s = this.A.getMeasuredHeight();
                View view = this.A;
                view.layout(0, 0, view.getMeasuredWidth(), this.A.getMeasuredHeight());
            }
        }
    }

    private qx k() {
        return this.f149538d;
    }

    @Override // com.tencent.mapsdk.internal.ey
    public final void c(boolean z16) {
        this.f149548z = z16;
        setVisible(z16);
    }

    @Override // com.tencent.mapsdk.internal.ey
    public final void d() {
        float f16;
        ap apVar = this.f149539p;
        tr trVar = this.f149544u;
        if (apVar != null && trVar != null && trVar.H() != null) {
            int width = apVar.getWidth(trVar.H());
            if (apVar.getOptions() != null) {
                f16 = apVar.getOptions().getInfoWindowAnchorU();
            } else {
                f16 = 0.5f;
            }
            int i3 = this.f149541r;
            if (i3 == 0) {
                i3 = 1;
            }
            this.f149546w = f16 + ((width * (apVar.getAnchorU() - 0.5f)) / i3);
        }
    }

    @Override // com.tencent.mapsdk.internal.ey
    public final void e() {
        float f16;
        ap apVar = this.f149539p;
        tr trVar = this.f149544u;
        if (apVar != null && trVar != null && trVar.H() != null) {
            int height = (int) (apVar.getHeight(trVar.H()) * apVar.getAnchorV());
            int i3 = this.f149542s;
            if (apVar.getOptions() != null) {
                f16 = apVar.getOptions().getInfoWindowAnchorV();
            } else {
                f16 = 1.0f;
            }
            if (i3 == 0) {
                i3 = 1;
            }
            float f17 = i3;
            this.f149547x = ((height + 5) + (f16 * f17)) / f17;
        }
    }

    @Override // com.tencent.mapsdk.internal.ey
    public final void f() {
        ap apVar = this.f149539p;
        if (apVar != null && this.C) {
            a(apVar.getOptions());
        }
    }

    @Override // com.tencent.mapsdk.internal.ey
    public final View g() {
        return this.A;
    }

    @Override // com.tencent.mapsdk.internal.po, com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.model.IOverlay
    public final String getId() {
        qx qxVar = this.f149538d;
        if (qxVar != null) {
            return qxVar.getId();
        }
        return super.getId();
    }

    @Override // com.tencent.mapsdk.internal.po
    public final void h_() {
        releaseData();
    }

    @Override // com.tencent.mapsdk.internal.ey
    public final void i_() {
        int i3;
        int i16;
        ap apVar = this.f149539p;
        if (apVar != null && apVar.getOptions() != null) {
            i3 = apVar.getOptions().getInfoWindowOffsetX();
            i16 = apVar.getOptions().getInfowindowOffsetY();
        } else {
            i3 = 0;
            i16 = 0;
        }
        d();
        e();
        float f16 = this.f149546w - ((i3 * 1.0f) / this.f149541r);
        float f17 = this.f149547x - ((i16 * 1.0f) / this.f149542s);
        qx qxVar = this.f149538d;
        if (qxVar != null) {
            qxVar.a(f16, f17);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Collisionable
    public final boolean isCollisionBy(final Collision collision) {
        Collision[] collisionArr = this.B;
        if (collisionArr != null) {
            return Util.where(collisionArr, new ReturnCallback<Boolean, Collision>() { // from class: com.tencent.mapsdk.internal.pn.1
                private Boolean a(Collision collision2) {
                    boolean z16;
                    if (collision2 == collision) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    return Boolean.valueOf(z16);
                }

                @Override // com.tencent.map.tools.ReturnCallback
                public final /* synthetic */ Boolean callback(Collision collision2) {
                    boolean z16;
                    if (collision2 == collision) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    return Boolean.valueOf(z16);
                }
            });
        }
        return false;
    }

    @Override // com.tencent.mapsdk.internal.po, com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.interfaces.Visible
    public final boolean isVisible() {
        if (c() && super.isVisible()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mapsdk.internal.po
    public final void j_() {
        qx qxVar = this.f149538d;
        if (qxVar != null) {
            qxVar.j_();
        }
    }

    @Override // com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.interfaces.Tappable
    public final boolean onTap(float f16, float f17) {
        qx qxVar = this.f149538d;
        if (qxVar == null) {
            return false;
        }
        return qxVar.onTap(f16, f17);
    }

    @Override // com.tencent.mapsdk.internal.po, com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.interfaces.Removable
    public final void releaseData() {
        this.f149540q = null;
        this.f149539p = null;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Collisionable
    public final void setCollisions(Collision... collisionArr) {
        this.B = collisionArr;
        qx qxVar = this.f149538d;
        if (qxVar == null) {
            return;
        }
        if (!isCollisionBy(MarkerCollisionItem.NONE) && collisionArr.length != 0) {
            qxVar.b(isCollisionBy(MarkerCollisionItem.POI));
            qxVar.c(isCollisionBy(MarkerCollisionItem.MARKER));
        } else {
            qxVar.b(false);
            qxVar.c(false);
        }
    }

    @Override // com.tencent.mapsdk.internal.po
    public final void setTag(Object obj) {
        super.setTag(obj);
        qx qxVar = this.f149538d;
        if (qxVar != null) {
            qxVar.setTag(obj);
        }
    }

    @Override // com.tencent.mapsdk.internal.po, com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.interfaces.Visible
    public final void setVisible(boolean z16) {
        M m3;
        super.setVisible(z16);
        qx qxVar = this.f149538d;
        if (qxVar != null) {
            qxVar.setVisible(z16);
        }
        tr trVar = this.f149544u;
        if (trVar != null && (m3 = trVar.e_) != 0) {
            ((VectorMap) m3).f151351o.f149412y = true;
        }
    }

    public final String toString() {
        return "GLInfoWindowOverlay{id='" + getId() + "'nativeId='" + a() + "'tag='" + getTag() + "'}";
    }

    @Override // com.tencent.mapsdk.internal.ey
    public final boolean c() {
        return this.f149548z && this.f149540q != null;
    }

    private ao j() {
        return this;
    }

    @Override // com.tencent.mapsdk.internal.aw
    public final /* bridge */ /* synthetic */ aq f_() {
        return this;
    }

    @Override // com.tencent.mapsdk.internal.po, com.tencent.mapsdk.internal.ex
    public final void p() {
    }

    private static void a(LinearLayout linearLayout) {
        linearLayout.removeAllViews();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams();
        linearLayout.setPadding(0, 0, 0, 0);
        marginLayoutParams.setMargins(0, 0, 0, 0);
        linearLayout.setLayoutParams(marginLayoutParams);
    }

    private static View a(Context context, TencentMapContext tencentMapContext, ey eyVar, String str, String str2) {
        LinearLayout linearLayout = (LinearLayout) eyVar.g();
        if (linearLayout == null) {
            linearLayout = a(context);
        } else {
            linearLayout.removeAllViews();
        }
        a(linearLayout, "marker_infowindow.9.png");
        a(tencentMapContext, linearLayout, ey.f148339b, str);
        a(tencentMapContext, linearLayout, ey.f148340c, str2);
        return linearLayout;
    }

    @Override // com.tencent.mapsdk.internal.po, com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.interfaces.Boundable
    /* renamed from: b */
    public final Rect getBound(fa faVar) {
        qx qxVar = this.f149538d;
        if (qxVar != null) {
            return qxVar.getBound(faVar);
        }
        return new Rect(0, 0, 0, 0);
    }

    @Override // com.tencent.mapsdk.internal.ey
    public final void b(boolean z16) {
        this.f149545v = z16;
        qx qxVar = this.f149538d;
        if (qxVar != null) {
            qxVar.a(z16);
        }
    }

    private static LinearLayout a(Context context) {
        if (context == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setTag(ey.f148338a);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        return linearLayout;
    }

    private static void a(ViewGroup viewGroup, String str) {
        if (TextUtils.isEmpty(str)) {
            viewGroup.setBackgroundDrawable(null);
        }
        Bitmap b16 = hn.b(viewGroup.getContext(), str);
        if (b16 != null) {
            viewGroup.setBackgroundDrawable(new NinePatchDrawable(viewGroup.getContext().getResources(), b16, b16.getNinePatchChunk(), new Rect(10, 10, 10, 30), null));
        }
    }

    private static void a(TencentMapContext tencentMapContext, LinearLayout linearLayout, String str, String str2) {
        if (linearLayout == null || linearLayout.getContext() == null) {
            return;
        }
        Context context = linearLayout.getContext();
        TextView textView = (TextView) linearLayout.findViewWithTag(str);
        if (TextUtils.isEmpty(str2)) {
            if (textView != null) {
                linearLayout.removeView(textView);
                return;
            }
            return;
        }
        if (textView == null) {
            textView = new nb(context, tencentMapContext);
            textView.setTag(str);
            textView.setGravity(3);
            textView.setTextColor(-16777216);
            linearLayout.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        }
        textView.setText(str2);
    }

    @Override // com.tencent.mapsdk.internal.ey
    public final void a(MarkerOptions markerOptions) {
        if (markerOptions == null || this.f149538d == null) {
            return;
        }
        setVisible(markerOptions.isVisible());
        setLevel(markerOptions.getLevel());
        i();
        qy b16 = b(markerOptions);
        if (b16 == null) {
            return;
        }
        this.f149538d.a(b16);
        a(hn.a(this.A), markerOptions.isIconLooperEnable());
    }

    @Override // com.tencent.mapsdk.internal.ey
    public final void a(boolean z16) {
        this.C = z16;
        if (c()) {
            setVisible(z16);
        }
    }

    @Override // com.tencent.mapsdk.internal.ey
    public final void a(LatLng latLng) {
        if (latLng == null) {
            return;
        }
        GeoPoint geoPoint = this.f149543t;
        if (geoPoint == null) {
            this.f149543t = GeoPoint.from(latLng);
        } else {
            geoPoint.setLatitudeE6((int) (latLng.latitude * 1000000.0d));
            this.f149543t.setLongitudeE6((int) (latLng.longitude * 1000000.0d));
        }
        qx qxVar = this.f149538d;
        if (qxVar != null) {
            qxVar.a(this.f149543t);
        }
    }

    @Override // com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.interfaces.Boundable
    /* renamed from: a */
    public final Rect getScreenBound(fa faVar) {
        qx qxVar = this.f149538d;
        if (qxVar == null) {
            return null;
        }
        return qxVar.getScreenBound(faVar);
    }

    @Override // com.tencent.mapsdk.internal.ey
    public final void a(int i3, int i16) {
        if (this.f149538d != null) {
            b(true);
            this.f149538d.a(new GeoPoint(i16, i3));
        }
    }

    private void a(Bitmap bitmap, boolean z16) {
        this.f149540q = bitmap;
        if (bitmap == null) {
            return;
        }
        LogUtil.b("setBitmapAssist:".concat(String.valueOf(bitmap)));
        StringBuilder sb5 = new StringBuilder();
        sb5.append(bitmap.hashCode() + f149537y.getAndIncrement());
        String sb6 = sb5.toString();
        qx qxVar = this.f149538d;
        if (qxVar != null) {
            qxVar.a(sb6, z16, bitmap);
        }
    }

    @Override // com.tencent.mapsdk.internal.po, com.tencent.mapsdk.internal.ex, com.tencent.mapsdk.internal.ao
    public final int a() {
        qx qxVar = this.f149538d;
        if (qxVar != null) {
            return qxVar.a();
        }
        return super.a();
    }
}
