package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.map.tools.ReturnCallback;
import com.tencent.map.tools.Util;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.mapsdk.internal.hr;
import com.tencent.mapsdk.internal.ic;
import com.tencent.mapsdk.internal.in;
import com.tencent.mapsdk.vector.VectorMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Boundable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Collision;
import com.tencent.tencentmap.mapsdk.maps.model.Animation;
import com.tencent.tencentmap.mapsdk.maps.model.AnimationListener;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerCollisionItem;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerCollisionRelation;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerCollisionRelationUnit;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class pp extends po<ap> implements ap {
    protected GeoPoint A;
    protected float B;
    protected float C;
    protected float D;
    public boolean E;
    public final tr F;
    public ey G;
    private boolean H;
    private int I;
    private int J;
    private boolean K;
    private GeoPoint L;
    private final qx M;
    private AnimationListener N;
    private in O;
    private TencentMap.OnMarkerClickListener P;
    private LatLng Q;
    private Collision[] R;
    private int S;
    private final in.b T;
    private MarkerCollisionRelation U;

    /* renamed from: b, reason: collision with root package name */
    protected Bitmap f149571b;

    /* renamed from: d, reason: collision with root package name */
    boolean f149572d;

    /* renamed from: p, reason: collision with root package name */
    protected final Object f149573p;

    /* renamed from: q, reason: collision with root package name */
    float f149574q;

    /* renamed from: r, reason: collision with root package name */
    float f149575r;

    /* renamed from: s, reason: collision with root package name */
    protected boolean f149576s;

    /* renamed from: t, reason: collision with root package name */
    protected float f149577t;

    /* renamed from: u, reason: collision with root package name */
    protected float f149578u;

    /* renamed from: v, reason: collision with root package name */
    protected float f149579v;

    /* renamed from: w, reason: collision with root package name */
    protected final MarkerOptions f149580w;

    /* renamed from: x, reason: collision with root package name */
    protected String f149581x;

    /* renamed from: y, reason: collision with root package name */
    protected GeoPoint f149582y;

    /* renamed from: z, reason: collision with root package name */
    protected GeoPoint f149583z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.pp$5, reason: invalid class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class AnonymousClass5 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f149590a;

        static {
            int[] iArr = new int[MarkerCollisionRelation.values().length];
            f149590a = iArr;
            try {
                iArr[MarkerCollisionRelation.ALONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f149590a[MarkerCollisionRelation.TOGETHER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public pp(tr trVar, MarkerOptions markerOptions) {
        super(trVar);
        Bitmap bitmap = null;
        this.f149571b = null;
        this.f149572d = false;
        this.f149573p = new Object();
        this.f149574q = 0.5f;
        this.f149575r = 0.5f;
        this.f149576s = false;
        this.f149577t = 0.0f;
        this.f149578u = 0.0f;
        this.f149579v = -1.0f;
        this.f149581x = null;
        this.f149582y = null;
        this.f149583z = null;
        this.A = null;
        this.B = 1.0f;
        this.C = 1.0f;
        this.D = 1.0f;
        this.E = false;
        this.H = false;
        this.I = 0;
        this.J = 0;
        this.K = false;
        this.L = null;
        this.T = new in.b() { // from class: com.tencent.mapsdk.internal.pp.1
            @Override // com.tencent.mapsdk.internal.in.b
            public final void a(float f16, float f17, float f18, float f19) {
                pp.this.setRotation(f16);
                pp ppVar = pp.this;
                ppVar.f149577t = f17;
                ppVar.f149578u = f18;
                ppVar.f149579v = f19;
                ppVar.f149576s = true;
                if (ppVar.M != null) {
                    pp.this.M.a((int) pp.this.getRotation());
                }
            }

            @Override // com.tencent.mapsdk.internal.in.b
            public final void a(float f16) {
                pp ppVar = pp.this;
                ppVar.B = f16;
                if (ppVar.M != null) {
                    pp.this.M.a(pp.this.B);
                    pp ppVar2 = pp.this;
                    ppVar2.f149580w.alpha(ppVar2.B);
                }
                pp ppVar3 = pp.this;
                ey eyVar = ppVar3.G;
                if (eyVar != null) {
                    eyVar.a(ppVar3.f149580w);
                }
            }

            @Override // com.tencent.mapsdk.internal.in.b
            public final void a(int i3, int i16) {
                if (pp.this.F == null || pp.this.f149582y == null) {
                    return;
                }
                GeoPoint geoPoint = new GeoPoint();
                if (pp.this.K && pp.this.L != null && pp.this.F.e_ != 0) {
                    GeoPoint a16 = ((VectorMap) pp.this.F.e_).getProjection().a(new fw(pp.this.I, pp.this.J));
                    int latitudeE6 = a16.getLatitudeE6() - pp.this.L.getLatitudeE6();
                    int longitudeE6 = a16.getLongitudeE6() - pp.this.L.getLongitudeE6();
                    geoPoint.setLatitudeE6(i3 + latitudeE6);
                    geoPoint.setLongitudeE6(i16 + longitudeE6);
                    fw a17 = ((VectorMap) pp.this.F.e_).getProjection().a(geoPoint);
                    pp.this.f149582y.setLatitudeE6((int) a17.f148384b);
                    pp.this.f149582y.setLongitudeE6((int) a17.f148383a);
                } else {
                    pp.this.f149582y.setLatitudeE6(i3 + 0);
                    pp.this.f149582y.setLongitudeE6(i16 + 0);
                }
                pp ppVar = pp.this;
                MarkerOptions markerOptions2 = ppVar.f149580w;
                if (markerOptions2 != null) {
                    markerOptions2.position(ks.a(ppVar.f149582y));
                }
                if (pp.this.M != null) {
                    pp.this.M.a(pp.this.f149582y);
                }
                pp ppVar2 = pp.this;
                ey eyVar = ppVar2.G;
                if (eyVar != null) {
                    eyVar.a(ks.a(ppVar2.f149582y));
                }
            }

            @Override // com.tencent.mapsdk.internal.in.b
            public final void b(float f16) {
            }

            @Override // com.tencent.mapsdk.internal.in.b
            public final void a(float f16, float f17) {
                pp.this.a(f16, f17);
            }
        };
        this.U = MarkerCollisionRelation.ALONE;
        this.F = trVar;
        this.f149580w = markerOptions;
        setClickable(true);
        this.f149563o = true;
        setTitle(markerOptions.getTitle());
        setDraggable(markerOptions.isDraggable());
        setPosition(markerOptions.getPosition());
        setSnippet(markerOptions.getSnippet());
        setAnchor(markerOptions.getAnchorU(), markerOptions.getAnchorV());
        setVisible(markerOptions.isVisible());
        setRotation(markerOptions.getRotation());
        setIcon(markerOptions.getIcon());
        setAlpha(markerOptions.getAlpha());
        setZIndex(markerOptions.getZIndex());
        setLevel(markerOptions.getLevel());
        a(markerOptions.getIndoorInfo());
        setTag(markerOptions.getTag());
        setCollisions(markerOptions.getCollisions());
        MarkerCollisionRelation collisionRelation = markerOptions.getCollisionRelation();
        this.U = collisionRelation;
        qx qxVar = this.M;
        if (qxVar != null) {
            qxVar.f149962u = collisionRelation;
        }
        MarkerOptions options = getOptions();
        qy qyVar = new qy();
        qyVar.f149976i = GeoPoint.from(options.getPosition());
        qyVar.f149980m = options.getAlpha();
        qyVar.a(options.getAnchorU(), options.getAnchorV());
        byte[] bArr = new byte[20];
        new SecureRandom().nextBytes(bArr);
        String str = new String(bArr);
        try {
            bitmap = options.getIcon().getBitmap(trVar.H());
            str = options.getIcon().getFormater().getBitmapId();
        } catch (NullPointerException e16) {
            e16.printStackTrace();
        }
        qy a16 = qyVar.a(str, bitmap);
        a16.f149982o = (int) options.getRotation();
        a16.f149981n = options.isFlat();
        a16.f149986s = (int) options.getZIndex();
        a16.f149988u = this.H;
        a16.f149992y = isCollisionBy(MarkerCollisionItem.MARKER);
        a16.f149991x = isCollisionBy(MarkerCollisionItem.POI);
        a16.f149993z = options.isClockwise();
        a16.f149989v = options.isFastLoad();
        a16.A = options.getTag();
        a16.f149987t = options.getLevel();
        qx qxVar2 = new qx(this, this.F, qyVar);
        this.M = qxVar2;
        qxVar2.f149962u = options.getCollisionRelation();
        setIconLooper(options.getIcon(), options.isIconLooperEnable(), options.getIconLooperDuration());
        x();
    }

    private void A() {
        Iterator<MarkerCollisionRelationUnit> it = l().iterator();
        while (it.hasNext()) {
            po c16 = this.F.c(it.next().getId());
            if (c16 instanceof pp) {
                c16.setVisible(false);
            } else if ((c16 instanceof pn) && ((pn) c16).c()) {
                c16.setVisible(false);
            }
        }
    }

    private void B() {
        Iterator<MarkerCollisionRelationUnit> it = l().iterator();
        while (it.hasNext()) {
            po c16 = this.F.c(it.next().getId());
            if (c16 instanceof pp) {
                c16.setVisible(true);
            } else if ((c16 instanceof pn) && ((pn) c16).c()) {
                c16.setVisible(true);
            }
        }
    }

    private void C() {
        synchronized (this.f149573p) {
            Bitmap bitmap = this.f149571b;
            if (bitmap != null && !bitmap.isRecycled()) {
                this.f149572d = true;
            }
        }
    }

    private String D() {
        return "GLMarkerOverlay-" + y();
    }

    private Rect E() {
        tr trVar;
        M m3;
        qx qxVar = this.M;
        if (qxVar != null && (trVar = this.F) != null && (m3 = trVar.e_) != 0) {
            return qxVar.getBound(((VectorMap) m3).getProjection());
        }
        return new Rect();
    }

    private boolean F() {
        M m3;
        boolean z16 = false;
        if (this.F == null) {
            return false;
        }
        in inVar = this.O;
        if (inVar != null) {
            inVar.b();
            boolean z17 = this.O.f148800b;
            this.K = z17;
            z16 = true;
            if (z17 && (m3 = this.F.e_) != 0) {
                ((VectorMap) m3).f151351o.f149412y = true;
            }
        }
        return z16;
    }

    private boolean G() {
        return this.H;
    }

    private int H() {
        Bitmap bitmap = this.f149571b;
        if (bitmap != null && this.M != null) {
            float width = bitmap.getWidth();
            return (int) ((this.M.d() * width) - (width * 0.5f));
        }
        return 0;
    }

    private boolean I() {
        return this.K;
    }

    private Boundable<fa> J() {
        return this.M;
    }

    private boolean L() {
        if (this.F == null) {
            return false;
        }
        Rect j3 = j();
        int ai5 = this.F.ai();
        int aj5 = this.F.aj();
        if (j3.left < 0 || j3.top < 0 || j3.right > ai5 || j3.bottom > aj5) {
            return false;
        }
        return true;
    }

    private void z() {
        tr trVar = this.F;
        if (trVar != null && this.E) {
            a(trVar.s());
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public final MarkerCollisionRelationUnit addCollisionUnit(@NonNull MarkerOptions markerOptions) {
        qx qxVar;
        if (this.f149580w.getCollisionRelation() == MarkerCollisionRelation.TOGETHER) {
            markerOptions.collisionBy(this.f149580w.getCollisions());
        }
        ap apVar = ((ax) ((VectorMap) this.F.e_).addMarker(markerOptions)).f147778b;
        if (apVar instanceof pp) {
            qxVar = ((pp) apVar).M;
        } else {
            qxVar = null;
        }
        if (qxVar != null) {
            a(qxVar);
        }
        return qxVar;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Alphable
    public final float getAlpha() {
        return this.B;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Anchorable
    public final float getAnchorU() {
        return this.f149580w.getAnchorU();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Anchorable
    public final float getAnchorV() {
        return this.f149580w.getAnchorV();
    }

    @Override // com.tencent.mapsdk.internal.po, com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.interfaces.Boundable
    public final /* synthetic */ Rect getBound(fa faVar) {
        return E();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Accessible
    public final String getContentDescription() {
        MarkerOptions markerOptions = this.f149580w;
        if (markerOptions == null) {
            return null;
        }
        return markerOptions.getContentDescription();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Scalable
    public final float getEqualScale() {
        return this.C;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public final int getHeight(Context context) {
        Bitmap bitmap;
        BitmapDescriptor icon = this.f149580w.getIcon();
        if (icon == null || (bitmap = icon.getFormater().getBitmap(context)) == null) {
            return 0;
        }
        return bitmap.getHeight();
    }

    @Override // com.tencent.mapsdk.internal.po, com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.model.IOverlay
    public final String getId() {
        qx qxVar = this.M;
        if (qxVar != null) {
            return qxVar.getId();
        }
        return super.getId();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public final MarkerOptions getOptions() {
        return this.f149580w;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public final LatLng getPosition() {
        return this.Q;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Scalable
    public final float[] getScale() {
        return new float[]{this.C, this.D};
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public final String getSnippet() {
        MarkerOptions markerOptions = this.f149580w;
        if (markerOptions != null) {
            return markerOptions.getSnippet();
        }
        return null;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public final String getTitle() {
        MarkerOptions markerOptions = this.f149580w;
        if (markerOptions != null) {
            return markerOptions.getTitle();
        }
        return null;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public final int getWidth(Context context) {
        Bitmap bitmap;
        BitmapDescriptor icon = this.f149580w.getIcon();
        if (icon == null || (bitmap = icon.getFormater().getBitmap(context)) == null) {
            return 0;
        }
        return bitmap.getWidth();
    }

    @Override // com.tencent.mapsdk.internal.ap
    public final ey h() {
        return this.G;
    }

    @Override // com.tencent.mapsdk.internal.po
    public final void h_() {
        tr trVar = this.F;
        if (trVar != null) {
            if (getId().equals(trVar.f151051h)) {
                trVar.b("");
            }
        }
        qx qxVar = this.M;
        if (qxVar != null) {
            qxVar.h_();
        }
        ey eyVar = this.G;
        if (eyVar != null) {
            eyVar.remove();
            removeCollisionUnit(this.G);
            this.G = null;
        }
    }

    @Override // com.tencent.mapsdk.internal.po, com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.interfaces.Tappable
    public final boolean handleOnTap() {
        return true;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public final void hideInfoWindow() {
        tr trVar = this.F;
        if (trVar == null) {
            return;
        }
        trVar.b("");
        ((VectorMap) trVar.e_).f151351o.f149412y = true;
        synchronized (trVar.f151050g) {
            ey eyVar = this.G;
            if (eyVar == null) {
                return;
            }
            eyVar.c(false);
        }
    }

    @Override // com.tencent.mapsdk.internal.ap
    public final boolean i() {
        if (this.f149580w.isInfoWindowEnable()) {
            if (!TextUtils.isEmpty(this.f149580w.getTitle()) || !TextUtils.isEmpty(this.f149580w.getSnippet()) || g() != null) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Collisionable
    public final boolean isCollisionBy(final Collision collision) {
        Collision[] collisionArr = this.R;
        if (collisionArr != null) {
            return Util.where(collisionArr, new ReturnCallback<Boolean, Collision>() { // from class: com.tencent.mapsdk.internal.pp.4
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

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public final boolean isFastLoad() {
        qx qxVar = this.M;
        if (qxVar == null) {
            return false;
        }
        return qxVar.g();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public final boolean isInfoWindowEnable() {
        MarkerOptions markerOptions = this.f149580w;
        if (markerOptions != null) {
            return markerOptions.isInfoWindowEnable();
        }
        return false;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public final boolean isInfoWindowShown() {
        ey eyVar;
        if (this.F != null && this.f149580w != null && (eyVar = this.G) != null) {
            return eyVar.c();
        }
        return false;
    }

    @Override // com.tencent.mapsdk.internal.ap
    public final Rect j() {
        tr trVar;
        M m3;
        qx qxVar = this.M;
        if (qxVar != null && (trVar = this.F) != null && (m3 = trVar.e_) != 0) {
            return qxVar.getScreenBound(((VectorMap) m3).getProjection());
        }
        return new Rect();
    }

    @Override // com.tencent.mapsdk.internal.po
    public final void j_() {
        qx qxVar;
        in inVar;
        M m3;
        tr trVar = this.F;
        if (trVar == null) {
            return;
        }
        if (trVar != null && this.E) {
            a(trVar.s());
        }
        if (this.F != null && (inVar = this.O) != null) {
            inVar.b();
            boolean z16 = this.O.f148800b;
            this.K = z16;
            if (z16 && (m3 = this.F.e_) != 0) {
                ((VectorMap) m3).f151351o.f149412y = true;
            }
        }
        M m16 = this.F.e_;
        if (m16 != 0 && ((VectorMap) m16).f151351o.f149401n != null && (qxVar = this.M) != null) {
            qxVar.j_();
        }
    }

    @Override // com.tencent.mapsdk.internal.ap
    public final qx k() {
        return this.M;
    }

    @Override // com.tencent.mapsdk.internal.ap
    public final List<MarkerCollisionRelationUnit> l() {
        return hr.a((Iterable) this.M.f149961t, (hr.h) new hr.h<qx, MarkerCollisionRelationUnit>() { // from class: com.tencent.mapsdk.internal.pp.2
            /* renamed from: a, reason: avoid collision after fix types in other method */
            private static MarkerCollisionRelationUnit a2(qx qxVar) {
                return qxVar;
            }

            @Override // com.tencent.mapsdk.internal.hr.h
            public final /* bridge */ /* synthetic */ MarkerCollisionRelationUnit a(qx qxVar) {
                return qxVar;
            }
        });
    }

    @Override // com.tencent.mapsdk.internal.ap
    public final MarkerCollisionRelation m() {
        qx qxVar = this.M;
        if (qxVar != null) {
            return qxVar.f149962u;
        }
        return this.U;
    }

    @Override // com.tencent.mapsdk.internal.ap
    public final boolean n() {
        if (this.M.f149960s != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.interfaces.Tappable
    public final boolean onTap(float f16, float f17) {
        qx qxVar;
        TencentMap.OnMarkerClickListener onMarkerClickListener;
        if (this.F == null || !isClickable() || (qxVar = this.M) == null) {
            return false;
        }
        boolean onTap = qxVar.onTap(f16, f17);
        if (onTap && (onMarkerClickListener = this.P) != null) {
            onMarkerClickListener.onMarkerClick(this);
        }
        return onTap;
    }

    @Override // com.tencent.mapsdk.internal.po, com.tencent.mapsdk.internal.ex
    public final boolean q() {
        if (getTag() != null && qa.f149734c.equals(getTag().toString())) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public final void refreshInfoWindow() {
        ey eyVar;
        if (isInfoWindowEnable() && (eyVar = this.G) != null && eyVar.c()) {
            this.G.f();
        }
    }

    @Override // com.tencent.mapsdk.internal.po, com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.interfaces.Removable
    public final void releaseData() {
        qx qxVar = this.M;
        if (qxVar != null) {
            qxVar.f();
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public final void removeCollisionUnit(MarkerCollisionRelationUnit markerCollisionRelationUnit) {
        qx qxVar;
        if (markerCollisionRelationUnit == null) {
            return;
        }
        po c16 = this.F.c(markerCollisionRelationUnit.getId());
        if (c16 instanceof pp) {
            qxVar = ((pp) c16).M;
        } else if (c16 instanceof pn) {
            qxVar = ((pn) c16).f149538d;
        } else {
            qxVar = null;
        }
        if (qxVar != null && this.M.b(qxVar)) {
            c16.remove();
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Alphable
    public final void setAlpha(float f16) {
        this.B = f16;
        MarkerOptions markerOptions = this.f149580w;
        if (markerOptions != null) {
            markerOptions.alpha(f16);
        }
        qx qxVar = this.M;
        if (qxVar != null) {
            qxVar.a(f16);
        }
        w();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Anchorable
    public final void setAnchor(float f16, float f17) {
        MarkerOptions markerOptions = this.f149580w;
        if (markerOptions != null) {
            markerOptions.anchor(f16, f17);
        }
        this.f149574q = f16;
        this.f149575r = f17;
        qx qxVar = this.M;
        if (qxVar != null) {
            qxVar.a(f16, f17);
        }
        ey eyVar = this.G;
        if (eyVar != null) {
            eyVar.i_();
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Animationable
    public final void setAnimation(Animation animation) {
        hw a16;
        tr trVar = this.F;
        if (trVar != null && (a16 = iv.a(trVar.d_, animation)) != null) {
            in inVar = a16.f148757a;
            this.O = inVar;
            if (inVar != null) {
                inVar.a(this.T);
            }
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Collisionable
    public final void setCollisions(Collision... collisionArr) {
        this.R = collisionArr;
        qx qxVar = this.M;
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

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Accessible
    public final void setContentDescription(String str) {
        MarkerOptions markerOptions = this.f149580w;
        if (markerOptions != null) {
            markerOptions.contentDescription(str);
        }
    }

    @Override // com.tencent.mapsdk.internal.po, com.tencent.tencentmap.mapsdk.maps.interfaces.Draggable
    public final void setDraggable(boolean z16) {
        super.setDraggable(z16);
        MarkerOptions markerOptions = this.f149580w;
        if (markerOptions != null) {
            markerOptions.draggable(z16);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Scalable
    public final void setEqualScale(float f16) {
        a(f16, f16);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public final void setFastLoad(boolean z16) {
        qx qxVar = this.M;
        if (qxVar == null) {
            return;
        }
        qxVar.d(z16);
        w();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public final void setFixingPoint(int i3, int i16) {
        this.I = i3;
        this.J = i16;
        if (this.M != null) {
            setFixingPointEnable(true);
            this.M.a(new GeoPoint(this.J, this.I));
        }
        ey eyVar = this.G;
        if (eyVar != null) {
            eyVar.a(i3, i16);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public final void setFixingPointEnable(boolean z16) {
        this.H = z16;
        qx qxVar = this.M;
        if (qxVar != null) {
            qxVar.a(z16);
        }
        ey eyVar = this.G;
        if (eyVar != null) {
            if (z16) {
                eyVar.a(this.I, this.J);
            } else {
                eyVar.b(false);
            }
        }
        w();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public final void setIcon(BitmapDescriptor bitmapDescriptor) {
        boolean z16;
        tr trVar = this.F;
        if (trVar == null) {
            return;
        }
        BitmapDescriptor defaultMarker = BitmapDescriptorFactory.defaultMarker(trVar.d_);
        tr trVar2 = this.F;
        if (trVar2 != null) {
            if (bitmapDescriptor == null && defaultMarker != null) {
                bitmapDescriptor = defaultMarker;
            }
            if (bitmapDescriptor != null) {
                if (this.M != null) {
                    BitmapDescriptor.BitmapFormator formater = bitmapDescriptor.getFormater();
                    if (formater.getFormateType() == 10 && this.f149580w.isIconLooperEnable()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    a(trVar2.H(), formater, z16);
                }
                MarkerOptions markerOptions = this.f149580w;
                if (markerOptions != null) {
                    markerOptions.icon(bitmapDescriptor);
                }
                ey eyVar = this.G;
                if (eyVar != null) {
                    eyVar.f();
                }
            }
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public final void setIconLooper(BitmapDescriptor bitmapDescriptor, boolean z16, int i3) {
        MarkerOptions markerOptions = this.f149580w;
        if (markerOptions != null) {
            markerOptions.icon(bitmapDescriptor);
            this.f149580w.iconLooper(z16, i3);
        }
        final boolean isIconLooperEnable = this.f149580w.isIconLooperEnable();
        int activeSize = this.f149580w.getIcon().getFormater().activeSize();
        LogUtil.b(ky.f149098d, "iconLooper totalSize:".concat(String.valueOf(activeSize)));
        if (activeSize > 1) {
            this.S = -1;
            ic icVar = new ic();
            icVar.a(this.f149580w.getIconLooperDuration());
            icVar.a(new ic.a() { // from class: com.tencent.mapsdk.internal.pp.3
                @Override // com.tencent.mapsdk.internal.ic.a
                public final void a(float f16) {
                    MarkerOptions markerOptions2;
                    super.a(f16);
                    if (pp.this.M != null && pp.this.F != null && (markerOptions2 = pp.this.f149580w) != null) {
                        BitmapDescriptor icon = markerOptions2.getIcon();
                        int activeSize2 = icon.getFormater().activeSize();
                        LogUtil.b(ky.f149098d, "current Marker iconLooper getValue:".concat(String.valueOf(f16)));
                        int round = Math.round(activeSize2 * f16);
                        LogUtil.b(ky.f149098d, "current Marker iconLooper activeIndex:".concat(String.valueOf(round)));
                        if (round != pp.this.S) {
                            pp ppVar = pp.this;
                            ppVar.a(ppVar.F.H(), icon.getFormater(), isIconLooperEnable);
                            icon.getFormater().nextActiveIndex();
                            pp.this.S = round;
                        }
                    }
                }
            });
            this.M.f149959r = icVar;
            icVar.a(isIconLooperEnable);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public final void setInfoWindowAnchor(float f16, float f17) {
        MarkerOptions markerOptions = this.f149580w;
        if (markerOptions != null) {
            markerOptions.infoWindowAnchor(f16, f17);
        }
        ey eyVar = this.G;
        if (eyVar != null) {
            eyVar.f();
        }
        w();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public final void setInfoWindowEnable(boolean z16) {
        MarkerOptions markerOptions = this.f149580w;
        if (markerOptions != null) {
            markerOptions.infoWindowEnable(z16);
        }
        ey eyVar = this.G;
        if (eyVar != null) {
            eyVar.a(z16);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public final void setInfoWindowOffset(int i3, int i16) {
        MarkerOptions markerOptions = this.f149580w;
        if (markerOptions != null) {
            markerOptions.infoWindowOffset(i3, i16);
        }
        ey eyVar = this.G;
        if (eyVar != null) {
            eyVar.f();
        }
        w();
    }

    @Override // com.tencent.mapsdk.internal.po, com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.interfaces.Levelable, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay
    public final void setLevel(int i3) {
        super.setLevel(i3);
        qx qxVar = this.M;
        if (qxVar != null) {
            qxVar.setLevel(i3);
        }
        MarkerOptions markerOptions = this.f149580w;
        if (markerOptions != null) {
            markerOptions.level(i3);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public final void setOnTop() {
        tr trVar = this.F;
        MarkerOptions markerOptions = this.f149580w;
        if (trVar != null && markerOptions != null) {
            synchronized (trVar.f151050g) {
                List<Marker> b16 = trVar.aC.M.b();
                if (b16.size() > 0) {
                    Marker marker = b16.get(b16.size() - 1);
                    setLevel(marker.getLevel());
                    setZIndex(marker.getZIndex() + 1);
                    refreshInfoWindow();
                }
            }
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public final void setPosition(LatLng latLng) {
        this.Q = latLng;
        if (latLng != null) {
            a(GeoPoint.from(latLng));
        }
        MarkerOptions markerOptions = this.f149580w;
        if (markerOptions != null) {
            markerOptions.position(latLng);
        }
    }

    @Override // com.tencent.mapsdk.internal.po, com.tencent.tencentmap.mapsdk.maps.interfaces.Rotatable
    public final void setRotation(float f16) {
        super.setRotation(f16);
        qx qxVar = this.M;
        if (qxVar != null) {
            qxVar.a((int) getRotation());
        }
        MarkerOptions markerOptions = this.f149580w;
        if (markerOptions != null) {
            markerOptions.rotation(f16);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Scalable
    public final void setScale(float f16, float f17) {
        a(f16, f17);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public final void setSnippet(String str) {
        MarkerOptions markerOptions = this.f149580w;
        if (markerOptions != null) {
            markerOptions.snippet(str);
        }
        ey eyVar = this.G;
        if (eyVar != null) {
            eyVar.f();
        }
    }

    @Override // com.tencent.mapsdk.internal.po
    public final void setTag(Object obj) {
        super.setTag(obj);
        qx qxVar = this.M;
        if (qxVar != null) {
            qxVar.setTag(obj);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public final void setTitle(String str) {
        MarkerOptions markerOptions = this.f149580w;
        if (markerOptions != null) {
            markerOptions.title(str);
        }
        if (this.G != null && isInfoWindowEnable()) {
            this.G.f();
        }
    }

    @Override // com.tencent.mapsdk.internal.po, com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.interfaces.Visible
    public final void setVisible(boolean z16) {
        M m3;
        boolean z17;
        super.setVisible(z16);
        MarkerOptions markerOptions = this.f149580w;
        if (markerOptions != null) {
            markerOptions.visible(z16);
        }
        qx qxVar = this.M;
        if (qxVar != null) {
            qxVar.setVisible(z16);
        }
        ey eyVar = this.G;
        if (eyVar != null) {
            if (z16 && eyVar.c()) {
                z17 = true;
            } else {
                z17 = false;
            }
            eyVar.setVisible(z17);
        }
        tr trVar = this.F;
        if (trVar != null && (m3 = trVar.e_) != 0) {
            ((VectorMap) m3).f151351o.f149412y = true;
        }
    }

    @Override // com.tencent.mapsdk.internal.po, com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.interfaces.Levelable
    public final void setZIndex(float f16) {
        this.f149556h = f16;
        MarkerOptions markerOptions = this.f149580w;
        if (markerOptions != null) {
            markerOptions.zIndex(f16);
        }
        qx qxVar = this.M;
        if (qxVar != null) {
            qxVar.setZIndex((int) f16);
        }
        w();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public final void showInfoWindow() {
        ey pnVar;
        tr trVar = this.F;
        MarkerOptions markerOptions = this.f149580w;
        if (trVar != null && markerOptions != null) {
            ne neVar = trVar.aC;
            synchronized (trVar.f151050g) {
                if (!trVar.f151033am) {
                    for (Marker marker : trVar.aC.M.b()) {
                        if (marker != null && marker.isInfoWindowShown()) {
                            marker.hideInfoWindow();
                        }
                    }
                }
                if (!isInfoWindowEnable()) {
                    return;
                }
                ey eyVar = this.G;
                if (eyVar == null) {
                    if (markerOptions.isViewInfowindow()) {
                        bj bjVar = neVar.M;
                        pnVar = new ps((tr) bjVar.f147870i, this);
                        bjVar.f147864c.add(pnVar);
                        LogUtil.b("Marker", "this[" + getId() + " :" + a() + "] addViewInfoWindow => child:" + pnVar.getId());
                    } else {
                        bj bjVar2 = neVar.M;
                        pnVar = new pn((tr) bjVar2.f147870i, this);
                        bjVar2.f147862a.put(pnVar.getId(), pnVar);
                        bjVar2.f147864c.add(pnVar);
                        LogUtil.b("Marker", "this[" + getId() + " :" + a() + "] addInfoWindow => child:" + pnVar.getId());
                        a((MarkerCollisionRelationUnit) pnVar);
                    }
                    a(pnVar);
                    this.G = pnVar;
                } else {
                    eyVar.f();
                    a(eyVar);
                }
            }
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Animationable
    public final boolean startAnimation() {
        M m3;
        tr trVar = this.F;
        if (trVar == null || this.O == null) {
            return false;
        }
        GeoPoint geoPoint = this.f149582y;
        if (this.H && (m3 = trVar.e_) != 0) {
            geoPoint = ((VectorMap) m3).getProjection().a(new fw(this.I, this.J));
            this.L = new GeoPoint(geoPoint);
        }
        return this.O.a(geoPoint, this.A);
    }

    public final String toString() {
        return "GLMarkerOverlay{id='" + getId() + "'nativeId='" + a() + "'tag='" + getTag() + "'}";
    }

    private void b(int[] iArr, int[] iArr2) {
        if (a(iArr)) {
            return;
        }
        b(iArr2);
    }

    @Override // com.tencent.mapsdk.internal.ap
    public final Point c() {
        return new Point(this.I, this.J);
    }

    @Override // com.tencent.mapsdk.internal.ap
    public final TencentMap.OnMarkerClickListener d() {
        return this.P;
    }

    @Override // com.tencent.mapsdk.internal.ap
    public final List<LatLng> e() {
        VectorMap vectorMap;
        Rect bound;
        tr trVar = this.F;
        if (trVar == null || (vectorMap = (VectorMap) trVar.e_) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (E() != null) {
            LatLng latLng = new LatLng(r2.top / 1000000.0d, r2.left / 1000000.0d);
            LatLng latLng2 = new LatLng(r2.bottom / 1000000.0d, r2.left / 1000000.0d);
            LatLng latLng3 = new LatLng(r2.top / 1000000.0d, r2.right / 1000000.0d);
            LatLng latLng4 = new LatLng(r2.bottom / 1000000.0d, r2.right / 1000000.0d);
            arrayList.add(latLng);
            arrayList.add(latLng2);
            arrayList.add(latLng3);
            arrayList.add(latLng4);
        }
        ey eyVar = this.G;
        if (eyVar != null && eyVar.c() && (bound = eyVar.getBound(vectorMap.getProjection())) != null) {
            LatLng latLng5 = new LatLng(bound.top / 1000000.0d, bound.left / 1000000.0d);
            LatLng latLng6 = new LatLng(bound.bottom / 1000000.0d, bound.left / 1000000.0d);
            LatLng latLng7 = new LatLng(bound.top / 1000000.0d, bound.right / 1000000.0d);
            LatLng latLng8 = new LatLng(bound.bottom / 1000000.0d, bound.right / 1000000.0d);
            arrayList.add(latLng5);
            arrayList.add(latLng6);
            arrayList.add(latLng7);
            arrayList.add(latLng8);
        }
        return arrayList;
    }

    @Override // com.tencent.mapsdk.internal.ap
    public final List<Boundable<fa>> f() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(this.M);
        ey eyVar = this.G;
        if (eyVar != null && eyVar.c()) {
            arrayList.add(this.G);
        }
        return arrayList;
    }

    @Override // com.tencent.mapsdk.internal.ap
    public final TencentMap.InfoWindowAdapter g() {
        tr trVar = this.F;
        if (trVar != null) {
            return trVar.Q();
        }
        return null;
    }

    private void b(int[] iArr) {
        TencentMap.OnMarkerCollisionStatusListener R = this.F.R();
        if (R == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (MarkerCollisionRelationUnit markerCollisionRelationUnit : l()) {
            po c16 = this.F.c(markerCollisionRelationUnit.getId());
            if (c16 != null) {
                int a16 = c16.a();
                if (iArr != null && iArr.length > 0) {
                    if (Arrays.binarySearch(iArr, a16) >= 0) {
                        LogUtil.b("Marker", "dispatchCollisionOnRelationUnits shown Marker[" + getId() + ":" + a() + "] RelationUnit = [" + markerCollisionRelationUnit.getId() + " :" + a16 + "]");
                        arrayList2.add(markerCollisionRelationUnit);
                    } else {
                        arrayList.add(c16);
                    }
                }
            }
        }
        if (arrayList2.isEmpty()) {
            return;
        }
        int i3 = AnonymousClass5.f149590a[m().ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                return;
            }
            R.onCollisionShown(this, l());
        } else {
            R.onCollisionShown(this, arrayList2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f16, float f17) {
        int anchorU;
        if (f16 >= 0.0f) {
            this.C = f16;
        }
        if (f17 >= 0.0f) {
            this.D = f17;
        }
        qx qxVar = this.M;
        if (qxVar != null) {
            qxVar.b(this.C, this.D);
            int height = getHeight(this.F.H());
            float width = getWidth(this.F.H());
            float f18 = this.C * width;
            if (f18 >= width) {
                float f19 = f18 - width;
                anchorU = (int) ((0.5f * f19) - (getAnchorU() * f19));
            } else {
                float f26 = width - f18;
                anchorU = (int) ((getAnchorU() * f26) - (f26 * 0.5f));
            }
            float f27 = height;
            this.f149580w.infoWindowOffset(anchorU, (int) (getAnchorV() * (f27 - (this.D * f27))));
        }
        if (this.G != null) {
            refreshInfoWindow();
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Animationable
    public final void startAnimation(Animation animation) {
        setAnimation(animation);
        startAnimation();
    }

    @Override // com.tencent.mapsdk.internal.po, com.tencent.mapsdk.internal.ex, com.tencent.mapsdk.internal.ao
    public final int a() {
        qx qxVar = this.M;
        if (qxVar != null) {
            return qxVar.a();
        }
        return super.a();
    }

    private void b(Bitmap bitmap, boolean z16) {
        synchronized (this.f149573p) {
            this.f149571b = bitmap;
            if (this.f149581x == null) {
                this.f149581x = bitmap.toString();
            }
            qx qxVar = this.M;
            if (qxVar != null) {
                qxVar.a(this.f149581x, z16, this.f149571b);
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.ap
    public final void a(BitmapDescriptor bitmapDescriptor, BitmapDescriptor bitmapDescriptor2) {
        tr trVar = this.F;
        if (trVar == null) {
            return;
        }
        if (bitmapDescriptor == null && bitmapDescriptor2 != null) {
            bitmapDescriptor = bitmapDescriptor2;
        }
        if (bitmapDescriptor == null) {
            return;
        }
        if (this.M != null) {
            BitmapDescriptor.BitmapFormator formater = bitmapDescriptor.getFormater();
            a(trVar.H(), formater, formater.getFormateType() == 10 && this.f149580w.isIconLooperEnable());
        }
        MarkerOptions markerOptions = this.f149580w;
        if (markerOptions != null) {
            markerOptions.icon(bitmapDescriptor);
        }
        ey eyVar = this.G;
        if (eyVar != null) {
            eyVar.f();
        }
    }

    private ap K() {
        return this;
    }

    @Override // com.tencent.mapsdk.internal.aw
    public final /* bridge */ /* synthetic */ aq f_() {
        return this;
    }

    @Override // com.tencent.mapsdk.internal.po, com.tencent.mapsdk.internal.ex
    public final void p() {
    }

    @Override // com.tencent.mapsdk.internal.po, com.tencent.mapsdk.internal.aw
    /* renamed from: b */
    public final Rect getBound(fa faVar) {
        return E();
    }

    private int b(boolean z16) {
        float e16;
        Bitmap bitmap = this.f149571b;
        if (bitmap == null || this.M == null) {
            return 0;
        }
        int height = bitmap.getHeight();
        if (!z16) {
            e16 = height * this.M.e();
        } else {
            e16 = height * (1.0f - this.M.e());
        }
        return (int) e16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, BitmapDescriptor.BitmapFormator bitmapFormator, boolean z16) {
        if (bitmapFormator != null) {
            Bitmap bitmap = bitmapFormator.getBitmap(context);
            String str = this.f149581x;
            if (str == null || !str.equals(bitmapFormator.getBitmapId())) {
                a(bitmapFormator.getBitmapId());
                a(bitmap, z16);
            }
        }
    }

    private boolean b(ey eyVar) {
        MarkerOptions markerOptions = this.f149580w;
        if (markerOptions == null || !markerOptions.isInfoWindowEnable()) {
            return false;
        }
        return ((eyVar == null || eyVar.g() == null) && hs.a(markerOptions.getTitle()) && hs.a(markerOptions.getSnippet())) ? false : true;
    }

    private void a(GeoPoint geoPoint) {
        if (geoPoint == null) {
            return;
        }
        GeoPoint geoPoint2 = this.f149582y;
        if (geoPoint2 == null) {
            this.f149582y = new GeoPoint(geoPoint.getLatitudeE6(), geoPoint.getLongitudeE6());
        } else {
            geoPoint2.setLatitudeE6(geoPoint.getLatitudeE6());
            this.f149582y.setLongitudeE6(geoPoint.getLongitudeE6());
        }
        qx qxVar = this.M;
        if (qxVar != null) {
            qxVar.a(this.f149582y);
        }
        ey eyVar = this.G;
        if (eyVar != null) {
            eyVar.a(ks.a(this.f149582y));
        }
    }

    @Override // com.tencent.mapsdk.internal.ap
    public final boolean b() {
        return this.H;
    }

    private void a(MarkerCollisionRelationUnit markerCollisionRelationUnit) {
        qx qxVar;
        if (markerCollisionRelationUnit == null) {
            return;
        }
        po c16 = this.F.c(markerCollisionRelationUnit.getId());
        if (c16 instanceof pp) {
            qxVar = ((pp) c16).M;
        } else {
            qxVar = c16 instanceof pn ? ((pn) c16).f149538d : null;
        }
        if (qxVar != null) {
            qxVar.f149962u = m();
            this.M.a(qxVar);
        }
    }

    private void a(MarkerCollisionRelation markerCollisionRelation) {
        this.U = markerCollisionRelation;
        qx qxVar = this.M;
        if (qxVar != null) {
            qxVar.f149962u = markerCollisionRelation;
        }
    }

    @Override // com.tencent.mapsdk.internal.ap
    public final void a(int[] iArr, int[] iArr2) {
        boolean z16;
        boolean z17 = true;
        if (iArr == null || iArr.length <= 0 || Arrays.binarySearch(iArr, a()) < 0) {
            z16 = false;
        } else {
            LogUtil.b("Marker", "dispatchCollisionOnMarker hidden = [" + getTag() + " :" + a() + "]");
            TencentMap.OnMarkerCollisionStatusListener R = this.F.R();
            int i3 = AnonymousClass5.f149590a[m().ordinal()];
            if (i3 == 1) {
                A();
                if (R != null) {
                    R.onCollisionHidden(this, new ArrayList());
                }
            } else if (i3 == 2 && R != null) {
                R.onCollisionHidden(this, l());
            }
            z16 = true;
        }
        if (z16 || iArr2 == null || iArr2.length <= 0 || Arrays.binarySearch(iArr2, a()) < 0) {
            z17 = z16;
        } else {
            LogUtil.b("Marker", "dispatchCollisionOnMarker show = [" + getTag() + " :" + a() + "]");
            MarkerCollisionRelation m3 = m();
            TencentMap.OnMarkerCollisionStatusListener R2 = this.F.R();
            int i16 = AnonymousClass5.f149590a[m3.ordinal()];
            if (i16 == 1) {
                B();
                if (R2 != null) {
                    R2.onCollisionShown(this, new ArrayList());
                }
            } else if (i16 == 2 && R2 != null) {
                R2.onCollisionShown(this, l());
            }
        }
        if (z17 || a(iArr)) {
            return;
        }
        b(iArr2);
    }

    private boolean a(int[] iArr) {
        TencentMap.OnMarkerCollisionStatusListener R = this.F.R();
        boolean z16 = false;
        if (R == null) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (MarkerCollisionRelationUnit markerCollisionRelationUnit : l()) {
            po c16 = this.F.c(markerCollisionRelationUnit.getId());
            if (c16 != null) {
                int a16 = c16.a();
                if (iArr != null && iArr.length > 0) {
                    if (Arrays.binarySearch(iArr, a16) >= 0) {
                        LogUtil.b("Marker", "dispatchCollisionOnRelationUnits hidden Marker[" + getId() + ":" + a() + "] RelationUnit = [" + markerCollisionRelationUnit.getId() + " :" + a16 + "]");
                        arrayList2.add(markerCollisionRelationUnit);
                    } else {
                        arrayList.add(c16);
                    }
                }
            }
        }
        if (!arrayList2.isEmpty()) {
            int i3 = AnonymousClass5.f149590a[m().ordinal()];
            z16 = true;
            if (i3 == 1) {
                R.onCollisionHidden(this, arrayList2);
            } else if (i3 == 2) {
                R.onCollisionHidden(this, l());
            }
        }
        return z16;
    }

    private void a(String str) {
        synchronized (this.f149573p) {
            this.f149581x = str;
        }
    }

    @Override // com.tencent.mapsdk.internal.ap
    public final void a(LatLng latLng) {
        ey eyVar;
        tr trVar = this.F;
        setPosition(latLng);
        if (!getId().equals(trVar != null ? trVar.f151051h : "") || (eyVar = this.G) == null) {
            return;
        }
        eyVar.a(latLng);
    }

    @Override // com.tencent.mapsdk.internal.ap
    public final void a(Bitmap bitmap, boolean z16) {
        if (bitmap == null) {
            return;
        }
        b(bitmap, z16);
        C();
    }

    private void a(in inVar) {
        this.O = inVar;
        if (inVar != null) {
            inVar.a(this.T);
        }
    }

    @Override // com.tencent.mapsdk.internal.ap
    public final void a(AnimationListener animationListener) {
        this.N = animationListener;
    }

    @Override // com.tencent.mapsdk.internal.ap
    public final void a(boolean z16) {
        this.E = z16;
    }

    @Override // com.tencent.mapsdk.internal.ap
    public final void a(TencentMap.OnMarkerClickListener onMarkerClickListener) {
        this.P = onMarkerClickListener;
    }

    @Override // com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.interfaces.Boundable
    /* renamed from: a */
    public final Rect getScreenBound(fa faVar) {
        qx qxVar = this.M;
        if (qxVar == null) {
            return null;
        }
        Rect screenBound = qxVar.getScreenBound(faVar);
        ey eyVar = this.G;
        Rect screenBound2 = eyVar != null ? eyVar.getScreenBound(faVar) : null;
        if (screenBound == null) {
            return screenBound2;
        }
        if (screenBound2 == null) {
            return screenBound;
        }
        return new Rect(Math.min(screenBound.left, screenBound2.left), Math.min(screenBound.top, screenBound2.top), Math.max(screenBound.right, screenBound2.right), Math.max(screenBound.bottom, screenBound2.bottom));
    }

    private void a(ey eyVar) {
        if (eyVar == null) {
            return;
        }
        if (this.H) {
            eyVar.a(this.I, this.J);
        }
        if (b(eyVar)) {
            eyVar.c(true);
        }
    }
}
