package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.mapsdk.internal.in;
import com.tencent.mapsdk.internal.ne;
import com.tencent.mapsdk.internal.qv;
import com.tencent.mapsdk.internal.tk;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Boundable;
import com.tencent.tencentmap.mapsdk.maps.model.AlphaAnimation;
import com.tencent.tencentmap.mapsdk.maps.model.Animation;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.EmergeAnimation;
import com.tencent.tencentmap.mapsdk.maps.model.IAlphaAnimation;
import com.tencent.tencentmap.mapsdk.maps.model.IEmergeAnimation;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorBuilding;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.Polyline;
import com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class pr extends po<as> implements as {
    private BitmapDescriptor A;
    private final int B;
    private in C;
    private float D;
    private a E;
    private float F;
    private int G;
    private PolylineOptions.Text H;
    private boolean I;
    private boolean J;
    private float K;
    private boolean L;
    private boolean M;
    private int N;
    private GeoPoint O;
    private String P;
    private int Q;
    private List<Integer> R;
    private final float S;
    private boolean T;
    private Animation U;
    private PolylineOptions V;
    private List<LatLng> W;
    private final bb X;
    private String Y;
    private boolean Z;

    /* renamed from: aa, reason: collision with root package name */
    private in.b f149614aa;

    /* renamed from: b, reason: collision with root package name */
    public qv f149615b;

    /* renamed from: d, reason: collision with root package name */
    private qw f149616d;

    /* renamed from: p, reason: collision with root package name */
    private Polyline f149617p;

    /* renamed from: q, reason: collision with root package name */
    private final List<a> f149618q;

    /* renamed from: r, reason: collision with root package name */
    private final List<GeoPoint> f149619r;

    /* renamed from: s, reason: collision with root package name */
    private float f149620s;

    /* renamed from: t, reason: collision with root package name */
    private final ne f149621t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f149622u;

    /* renamed from: v, reason: collision with root package name */
    private int[] f149623v;

    /* renamed from: w, reason: collision with root package name */
    private int[] f149624w;

    /* renamed from: x, reason: collision with root package name */
    private int[] f149625x;

    /* renamed from: y, reason: collision with root package name */
    private int f149626y;

    /* renamed from: z, reason: collision with root package name */
    private PolylineOptions.ColorType f149627z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        int[] f149633a;

        /* renamed from: b, reason: collision with root package name */
        int[] f149634b;

        /* renamed from: c, reason: collision with root package name */
        int f149635c;

        /* renamed from: d, reason: collision with root package name */
        int f149636d;

        b(int i3) {
            this.f149636d = i3;
            this.f149633a = new int[i3];
            this.f149634b = new int[i3];
        }

        public final void a(int i3, int i16) {
            int i17 = this.f149635c;
            if (i17 >= this.f149636d) {
                return;
            }
            this.f149633a[i17] = i3;
            this.f149634b[i17] = i16;
            this.f149635c = i17 + 1;
        }
    }

    public pr(bb bbVar) {
        super(bbVar);
        this.f149615b = null;
        this.f149616d = null;
        this.f149617p = null;
        this.f149622u = false;
        this.f149623v = null;
        this.f149624w = null;
        this.f149625x = null;
        this.f149626y = -7829368;
        this.A = null;
        this.B = 12;
        this.E = null;
        this.F = 1.0f;
        this.G = 0;
        this.I = false;
        this.J = true;
        this.K = 0.0f;
        this.L = false;
        this.M = false;
        this.N = -1;
        this.O = null;
        this.Q = (int) (ht.a(this.f149562n.H()) * 100.0f);
        this.Y = ua.f151157a;
        this.f149614aa = new in.b() { // from class: com.tencent.mapsdk.internal.pr.3
            @Override // com.tencent.mapsdk.internal.in.b
            public final void a(float f16, float f17) {
            }

            @Override // com.tencent.mapsdk.internal.in.b
            public final void b(float f16) {
                pr.this.F = f16;
            }

            @Override // com.tencent.mapsdk.internal.in.b
            public final void a(float f16, float f17, float f18, float f19) {
            }

            @Override // com.tencent.mapsdk.internal.in.b
            public final void a(int i3, int i16) {
            }

            @Override // com.tencent.mapsdk.internal.in.b
            public final void a(float f16) {
                pr.this.D = f16;
            }
        };
        this.X = bbVar;
        ne b16 = bbVar.b();
        this.f149621t = b16;
        this.f149618q = new CopyOnWriteArrayList();
        this.f149619r = new CopyOnWriteArrayList();
        this.S = b16.getContext().getResources().getDisplayMetrics().density;
    }

    private static int b(int i3) {
        if (i3 == 0) {
            return 0;
        }
        if (i3 == 1) {
            return 1;
        }
        if (i3 == 2) {
            return 2;
        }
        if (i3 == 3) {
            return 3;
        }
        if (i3 != 4) {
            return (i3 == 6 || i3 != 33) ? 6 : 33;
        }
        return 4;
    }

    private static int c(int i3) {
        if (i3 >= 12) {
            i3 = 11;
        }
        if (i3 < 0) {
            return 0;
        }
        return i3;
    }

    private void d() {
        if (Thread.currentThread().getName().contains(this.Y)) {
            e();
        } else {
            this.f149621t.a(new ne.a() { // from class: com.tencent.mapsdk.internal.pr.1
                @Override // com.tencent.mapsdk.internal.ne.a
                public final void a(GL10 gl10) {
                    pr.this.e();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f149621t != null && this.f149619r.size() >= 2 && isVisible()) {
            qv qvVar = this.f149615b;
            ga g16 = g();
            if (!g16.a()) {
                return;
            }
            if (qvVar == null) {
                qvVar = new qv(this, this.X, g16);
                qvVar.b_ = this.b_;
                this.f149621t.f149400m.a(qvVar);
                this.f149615b = qvVar;
            } else {
                qvVar.a(g16);
            }
            qvVar.a(this.N, this.O);
            this.f149621t.f149412y = true;
        }
    }

    private void f() {
        int i3;
        qw qwVar;
        ne neVar = this.f149621t;
        if (neVar != null && this.T) {
            this.T = false;
            PolylineOptions.Text text = this.H;
            if (text == null && (qwVar = this.f149616d) != null) {
                qwVar.a();
                this.f149616d = null;
                return;
            }
            tk tkVar = neVar.f149396i;
            if (text != null) {
                qw qwVar2 = this.f149616d;
                if (qwVar2 == null) {
                    List<GeoPoint> list = this.f149619r;
                    if (list != null && list.size() >= 2) {
                        List<GeoPoint> list2 = this.f149619r;
                        this.f149616d = new qw(tkVar, (GeoPoint[]) list2.toArray(new GeoPoint[list2.size()]), this.H);
                        return;
                    }
                    return;
                }
                tk tkVar2 = qwVar2.f149954b;
                if (tkVar2 != null && (i3 = qwVar2.f149953a) > 0) {
                    tkVar2.a(new tk.AnonymousClass54(i3, text));
                }
            }
        }
    }

    private ga g() {
        ga gaVar = new ga();
        if (this.f149621t == null) {
            return gaVar;
        }
        BitmapDescriptor bitmapDescriptor = this.A;
        if (bitmapDescriptor != null && bitmapDescriptor.getFormater() != null) {
            gaVar.f148443y = this.A.getFormater().getBitmapId();
        }
        b c16 = c(this.f149619r);
        gaVar.f148441w = this.f149622u;
        gaVar.I = this.Q;
        gaVar.a(this.f149619r);
        gaVar.N = this.f149626y;
        if (this.G == 0) {
            int a16 = a(this.f149621t.getContext(), this.A);
            if (a16 > 0) {
                float f16 = this.f149553e;
                float f17 = a16;
                if (f16 > f17) {
                    f16 = f17;
                }
                gaVar.f148442x = f16;
            } else {
                gaVar.f148442x = this.f149553e;
            }
        } else {
            gaVar.f148442x = this.f149553e;
        }
        if (this.f149627z == PolylineOptions.ColorType.LINE_COLOR_ARGB) {
            gaVar.f148440v = true;
            float f18 = this.f149620s * 2.0f;
            float f19 = this.f149553e;
            if (f18 >= f19) {
                this.f149620s = f19 / 3.0f;
            }
            gaVar.f148439u = this.f149620s;
        }
        int[] iArr = this.f149625x;
        if (this.J) {
            gaVar.a(c16.f149633a);
            if (this.f149620s > 0.0f && iArr != null && iArr.length > 0) {
                gaVar.a(c16.f149634b, iArr);
            } else {
                gaVar.b(c16.f149634b);
            }
        } else {
            gaVar.a(new int[]{0});
            if (this.f149620s > 0.0f && iArr != null && iArr.length > 0) {
                gaVar.a(new int[]{this.f149555g}, new int[]{iArr[0]});
            } else {
                gaVar.b(new int[]{this.f149555g});
            }
        }
        gaVar.A = this.D;
        gaVar.C = this.G;
        gaVar.G = (int) this.f149556h;
        gaVar.D = this.I;
        gaVar.E = this.L;
        gaVar.f148444z = this.M;
        gaVar.B = this.J;
        gaVar.H = this.P;
        gaVar.b(this.R);
        gaVar.M = this.f149560l;
        gaVar.O = this.Z;
        return gaVar;
    }

    private boolean h() {
        boolean z16 = false;
        int i3 = 0;
        z16 = false;
        if (this.f149621t == null) {
            return false;
        }
        in inVar = this.C;
        if (inVar != null && inVar.f148802d) {
            inVar.b();
            in inVar2 = this.C;
            if (inVar2 instanceof ip) {
                this.f149619r.clear();
                List<GeoPoint> list = this.f149619r;
                List<a> list2 = this.f149618q;
                ArrayList arrayList = new ArrayList();
                if (list2 != null && list2.size() >= 2) {
                    float f16 = this.E.f149631a;
                    float f17 = this.K - f16;
                    float f18 = this.F;
                    float f19 = f17 * f18;
                    float f26 = f16 - (f16 * f18);
                    float f27 = f16 + f19;
                    a aVar = null;
                    while (true) {
                        if (i3 >= list2.size()) {
                            break;
                        }
                        a aVar2 = list2.get(i3);
                        float f28 = aVar2.f149631a;
                        if (f28 > f26 && f28 < f27) {
                            if (aVar != null) {
                                float f29 = aVar.f149631a;
                                if (f29 < f26) {
                                    a a16 = a(aVar, aVar2, (f26 - f29) / (f28 - f29));
                                    a16.f149632b = aVar.f149632b;
                                    arrayList.add(a16);
                                }
                            }
                            arrayList.add(aVar2);
                        } else if (f28 > f27) {
                            if (aVar != null) {
                                float f36 = aVar.f149631a;
                                if (f36 < f27) {
                                    a a17 = a(aVar, aVar2, (f27 - f36) / (f28 - f36));
                                    a17.f149632b = aVar2.f149632b;
                                    arrayList.add(a17);
                                }
                            }
                        } else if (Float.compare(f28, f26) == 0 || Float.compare(aVar2.f149631a, f27) == 0) {
                            arrayList.add(aVar2);
                        }
                        i3++;
                        aVar = aVar2;
                    }
                }
                list.addAll(arrayList);
                if (this.f149619r.size() >= 2) {
                    d();
                }
            } else if (inVar2 instanceof im) {
                d();
            }
            z16 = true;
            z16 = true;
            this.f149621t.f149412y = true;
            in inVar3 = this.C;
            if (inVar3.f148803e) {
                inVar3.a((in.b) null);
                this.C = null;
            }
        }
        return z16;
    }

    private int[] i() {
        return this.f149625x;
    }

    private Polyline k() {
        return this.f149617p;
    }

    private float l() {
        return this.D;
    }

    private qv m() {
        return this.f149615b;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public final void addTurnArrow(int i3, int i16) {
        qv qvVar = this.f149615b;
        if (qvVar == null) {
            return;
        }
        qvVar.d();
        qv qvVar2 = this.f149615b;
        qv.a aVar = new qv.a();
        qvVar2.f149944t = aVar;
        aVar.f149951a = i3;
        aVar.f149952b = i16;
        qvVar2.w();
        d();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public final void appendPoint(LatLng... latLngArr) {
        if (this.W == null) {
            this.W = new ArrayList();
        }
        this.W.addAll(Arrays.asList(latLngArr));
        a(this.W);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public final void appendPoints(List<LatLng> list) {
        if (this.W == null) {
            this.W = new ArrayList();
        }
        this.W.addAll(list);
        a(this.W);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public final void arrowSpacing(int i3) {
        if (this.Q != i3) {
            this.Q = i3;
            PolylineOptions polylineOptions = this.V;
            if (polylineOptions != null) {
                polylineOptions.arrowSpacing(i3);
            }
            w();
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public final void cleanTurnArrow() {
        qv qvVar = this.f149615b;
        if (qvVar == null) {
            return;
        }
        qvVar.d();
        d();
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof pr)) {
            return false;
        }
        return TextUtils.equals(y(), ((pr) obj).y());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public final void eraseColor(int i3) {
        if (this.f149626y != i3) {
            this.f149626y = i3;
            PolylineOptions polylineOptions = this.V;
            if (polylineOptions != null) {
                polylineOptions.eraseColor(i3);
            }
            w();
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public final void eraseTo(int i3, LatLng latLng) {
        a(i3, latLng);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public final int getColor() {
        return getStrokeColor();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public final int[][] getColors() {
        int[] iArr;
        int[] iArr2 = this.f149623v;
        if (iArr2 != null && (iArr = this.f149624w) != null) {
            int[][] iArr3 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 2, Math.max(iArr2.length, iArr.length));
            iArr3[0] = this.f149623v;
            iArr3[1] = this.f149624w;
            return iArr3;
        }
        return null;
    }

    @Override // com.tencent.mapsdk.internal.po, com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.interfaces.Boundable
    public final List<Boundable<fa>> getGroupBounds() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(this.f149615b);
        return arrayList;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public final List<Integer> getPattern() {
        return this.R;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public final List<LatLng> getPoints() {
        return this.W;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public final PolylineOptions getPolylineOptions() {
        return this.V;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public final PolylineOptions.Text getText() {
        return this.H;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public final Rect getVisibleRect() {
        int i3;
        Rect rect;
        qv qvVar = this.f149615b;
        ArrayList<GeoPoint> arrayList = qvVar.f149938b.f148430l;
        if (arrayList != null && !arrayList.isEmpty() && (i3 = qvVar.f149941q) >= 0 && i3 < arrayList.size()) {
            List<GeoPoint> subList = arrayList.subList(qvVar.f149941q, arrayList.size());
            if (subList != null && !subList.isEmpty()) {
                GeoPoint geoPoint = subList.get(0);
                int longitudeE6 = geoPoint.getLongitudeE6();
                int longitudeE62 = geoPoint.getLongitudeE6();
                int latitudeE6 = geoPoint.getLatitudeE6();
                int latitudeE62 = geoPoint.getLatitudeE6();
                int size = subList.size();
                for (int i16 = 0; i16 < size; i16++) {
                    GeoPoint geoPoint2 = subList.get(i16);
                    if (geoPoint2 != null) {
                        int latitudeE63 = geoPoint2.getLatitudeE6();
                        int longitudeE63 = geoPoint2.getLongitudeE6();
                        if (longitudeE63 < longitudeE6) {
                            longitudeE6 = longitudeE63;
                        } else if (longitudeE63 > longitudeE62) {
                            longitudeE62 = longitudeE63;
                        }
                        if (latitudeE63 < latitudeE62) {
                            latitudeE62 = latitudeE63;
                        } else if (latitudeE63 > latitudeE6) {
                            latitudeE6 = latitudeE63;
                        }
                    }
                }
                rect = new Rect(longitudeE6, latitudeE6, longitudeE62, latitudeE62);
            } else {
                rect = null;
            }
            if (rect != null) {
                qvVar.f149938b.F = rect;
            }
        }
        return qvVar.f149938b.F;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public final float getWidth() {
        return this.f149553e;
    }

    @Override // com.tencent.mapsdk.internal.po
    public final void h_() {
        qv qvVar = this.f149615b;
        if (qvVar != null) {
            qvVar.remove();
            this.f149615b = null;
        }
        qw qwVar = this.f149616d;
        if (qwVar != null) {
            qwVar.a();
            this.f149616d = null;
        }
        List<a> list = this.f149618q;
        if (list != null) {
            list.clear();
        }
        List<GeoPoint> list2 = this.f149619r;
        if (list2 != null) {
            list2.clear();
        }
    }

    @Override // com.tencent.mapsdk.internal.po, com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.interfaces.Tappable
    public final boolean handleOnTap() {
        return true;
    }

    public final int hashCode() {
        return y().hashCode();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public final boolean isAboveMaskLayer() {
        return this.I;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public final boolean isGradientEnable() {
        return this.Z;
    }

    @Override // com.tencent.mapsdk.internal.po
    public final void j_() {
        int i3;
        qw qwVar;
        in inVar;
        this.Y = Thread.currentThread().getName();
        if (this.f149621t == null || !isVisible()) {
            return;
        }
        if (v()) {
            if (this.f149618q.size() >= 2) {
                this.f149619r.clear();
                this.f149619r.addAll(this.f149618q);
            }
            d();
        }
        if (this.f149621t != null && (inVar = this.C) != null && inVar.f148802d) {
            inVar.b();
            in inVar2 = this.C;
            if (inVar2 instanceof ip) {
                this.f149619r.clear();
                List<GeoPoint> list = this.f149619r;
                List<a> list2 = this.f149618q;
                ArrayList arrayList = new ArrayList();
                if (list2 != null && list2.size() >= 2) {
                    float f16 = this.E.f149631a;
                    float f17 = this.K - f16;
                    float f18 = this.F;
                    float f19 = f17 * f18;
                    float f26 = f16 - (f16 * f18);
                    float f27 = f16 + f19;
                    int i16 = 0;
                    a aVar = null;
                    while (true) {
                        if (i16 >= list2.size()) {
                            break;
                        }
                        a aVar2 = list2.get(i16);
                        float f28 = aVar2.f149631a;
                        if (f28 > f26 && f28 < f27) {
                            if (aVar != null) {
                                float f29 = aVar.f149631a;
                                if (f29 < f26) {
                                    a a16 = a(aVar, aVar2, (f26 - f29) / (f28 - f29));
                                    a16.f149632b = aVar.f149632b;
                                    arrayList.add(a16);
                                }
                            }
                            arrayList.add(aVar2);
                        } else if (f28 > f27) {
                            if (aVar != null) {
                                float f36 = aVar.f149631a;
                                if (f36 < f27) {
                                    a a17 = a(aVar, aVar2, (f27 - f36) / (f28 - f36));
                                    a17.f149632b = aVar2.f149632b;
                                    arrayList.add(a17);
                                }
                            }
                        } else if (Float.compare(f28, f26) == 0 || Float.compare(aVar2.f149631a, f27) == 0) {
                            arrayList.add(aVar2);
                        }
                        i16++;
                        aVar = aVar2;
                    }
                }
                list.addAll(arrayList);
                if (this.f149619r.size() >= 2) {
                    d();
                }
            } else if (inVar2 instanceof im) {
                d();
            }
            this.f149621t.f149412y = true;
            in inVar3 = this.C;
            if (inVar3.f148803e) {
                inVar3.a((in.b) null);
                this.C = null;
            }
        }
        ne neVar = this.f149621t;
        if (neVar != null && this.T) {
            this.T = false;
            PolylineOptions.Text text = this.H;
            if (text == null && (qwVar = this.f149616d) != null) {
                qwVar.a();
                this.f149616d = null;
                return;
            }
            tk tkVar = neVar.f149396i;
            if (text != null) {
                qw qwVar2 = this.f149616d;
                if (qwVar2 == null) {
                    List<GeoPoint> list3 = this.f149619r;
                    if (list3 != null && list3.size() >= 2) {
                        List<GeoPoint> list4 = this.f149619r;
                        this.f149616d = new qw(tkVar, (GeoPoint[]) list4.toArray(new GeoPoint[list4.size()]), this.H);
                        return;
                    }
                    return;
                }
                tk tkVar2 = qwVar2.f149954b;
                if (tkVar2 != null && (i3 = qwVar2.f149953a) > 0) {
                    tkVar2.a(new tk.AnonymousClass54(i3, text));
                }
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.as
    public final Rect l_() {
        int i3;
        Rect rect;
        qv qvVar = this.f149615b;
        ArrayList<GeoPoint> arrayList = qvVar.f149938b.f148430l;
        if (arrayList != null && !arrayList.isEmpty() && (i3 = qvVar.f149941q) >= 0 && i3 < arrayList.size()) {
            List<GeoPoint> subList = arrayList.subList(qvVar.f149941q, arrayList.size());
            if (subList != null && !subList.isEmpty()) {
                GeoPoint geoPoint = subList.get(0);
                int longitudeE6 = geoPoint.getLongitudeE6();
                int longitudeE62 = geoPoint.getLongitudeE6();
                int latitudeE6 = geoPoint.getLatitudeE6();
                int latitudeE62 = geoPoint.getLatitudeE6();
                int size = subList.size();
                for (int i16 = 0; i16 < size; i16++) {
                    GeoPoint geoPoint2 = subList.get(i16);
                    if (geoPoint2 != null) {
                        int latitudeE63 = geoPoint2.getLatitudeE6();
                        int longitudeE63 = geoPoint2.getLongitudeE6();
                        if (longitudeE63 < longitudeE6) {
                            longitudeE6 = longitudeE63;
                        } else if (longitudeE63 > longitudeE62) {
                            longitudeE62 = longitudeE63;
                        }
                        if (latitudeE63 < latitudeE62) {
                            latitudeE62 = latitudeE63;
                        } else if (latitudeE63 > latitudeE6) {
                            latitudeE6 = latitudeE63;
                        }
                    }
                }
                rect = new Rect(longitudeE6, latitudeE6, longitudeE62, latitudeE62);
            } else {
                rect = null;
            }
            if (rect != null) {
                qvVar.f149938b.F = rect;
            }
        }
        return qvVar.f149938b.F;
    }

    @Override // com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.interfaces.Tappable
    public final boolean onTap(float f16, float f17) {
        qv qvVar;
        if (this.f149621t == null || !isVisible() || (qvVar = this.f149615b) == null) {
            return false;
        }
        return qvVar.onTap(f16, f17);
    }

    @Override // com.tencent.mapsdk.internal.po, com.tencent.mapsdk.internal.ex
    public final void p() {
        d();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public final void pattern(List<Integer> list) {
        d(list);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public final void setAboveMaskLayer(boolean z16) {
        if (this.I != z16) {
            this.I = z16;
            w();
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Animationable
    public final void setAnimation(Animation animation) {
        if (!(animation instanceof AlphaAnimation) && !(animation instanceof EmergeAnimation) && !(animation instanceof IAlphaAnimation) && !(animation instanceof IEmergeAnimation)) {
            LogUtil.c("Unsupported animation, only AlphaAnimation and EmergeAnimation allowed.");
        } else {
            this.U = animation;
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public final void setArrow(boolean z16) {
        if (this.f149622u != z16) {
            this.f149622u = z16;
            PolylineOptions polylineOptions = this.V;
            if (polylineOptions != null) {
                polylineOptions.arrow(z16);
            }
            w();
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public final void setBorderColors(int[] iArr) {
        if (this.f149625x != iArr) {
            this.f149625x = iArr;
            PolylineOptions polylineOptions = this.V;
            if (polylineOptions != null) {
                polylineOptions.borderColors(iArr);
            }
            w();
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public final void setColor(int i3) {
        setStrokeColor(i3);
        PolylineOptions polylineOptions = this.V;
        if (polylineOptions != null) {
            polylineOptions.color(i3);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public final void setColorTexture(String str) {
        setColorTexture(BitmapDescriptorFactory.fromAsset(str));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public final void setColors(int[] iArr, int[] iArr2) {
        this.f149623v = iArr;
        this.f149624w = iArr2;
        this.f149627z = a(PolylineOptions.ColorType.LINE_COLOR_NONE);
        this.J = true;
        w();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public final void setEraseable(boolean z16) {
        this.L = z16;
        qv qvVar = this.f149615b;
        if (qvVar != null) {
            qvVar.f149938b.E = z16;
        }
        w();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public final void setGradientEnable(boolean z16) {
        if (this.G == 0 && this.J) {
            this.Z = z16;
            w();
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public final void setPoints(List<LatLng> list) {
        a(list);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public final void setPolylineOptions(PolylineOptions polylineOptions) {
        if (this.f149621t != null && polylineOptions != null) {
            this.f149563o = true;
            this.V = polylineOptions;
            if (polylineOptions.getWidth() == -1.0f) {
                setStrokeWidth(this.S * 9.0f);
            } else {
                setStrokeWidth(polylineOptions.getWidth());
            }
            setStrokeColor(polylineOptions.getColor());
            setZIndex(polylineOptions.getZIndex());
            setVisible(polylineOptions.isVisible());
            this.D = polylineOptions.getAlpha();
            w();
            setArrow(polylineOptions.isArrow());
            setColorTexture(polylineOptions.getColorTexture());
            c(polylineOptions.getLineCap());
            d(polylineOptions.getPattern());
            this.f149620s = polylineOptions.getBorderWidth();
            setClickable(polylineOptions.isClickable());
            this.f149625x = polylineOptions.getBorderColors();
            this.b_ = polylineOptions.getIndoorInfo();
            this.G = polylineOptions.getLineType();
            this.f149560l = polylineOptions.getLevel();
            this.f149626y = polylineOptions.getEraseColor();
            if (polylineOptions.isAbovePillar() && this.f149560l == 0) {
                this.f149560l = 2;
            }
            a(polylineOptions.getPoints());
            if (polylineOptions.getArrowTexture() != null) {
                BitmapDescriptor arrowTexture = polylineOptions.getArrowTexture();
                if (arrowTexture.getBitmap(this.X.H()) != null) {
                    this.P = arrowTexture.getFormater().getBitmapId();
                }
            }
            this.Q = polylineOptions.getArrowSpacing();
            this.J = polylineOptions.isRoad();
            Animation animation = polylineOptions.getAnimation();
            if (animation != null) {
                a(((hw) animation).f148757a);
            }
            int[][] colors = polylineOptions.getColors();
            if (colors != null && colors.length == 2) {
                int[] iArr = colors[0];
                int[] iArr2 = colors[1];
                if (iArr != null && iArr2 != null) {
                    setColors(iArr, iArr2);
                }
            }
            this.f149627z = a(polylineOptions.getColorType());
            setText(polylineOptions.getText());
            setGradientEnable(polylineOptions.isGradientEnable());
            x();
            d();
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public final void setText(PolylineOptions.Text text) {
        if (this.H != text) {
            this.H = text;
            this.T = true;
        }
    }

    @Override // com.tencent.mapsdk.internal.po, com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.interfaces.Visible
    public final void setVisible(boolean z16) {
        super.setVisible(z16);
        qv qvVar = this.f149615b;
        if (qvVar != null) {
            qvVar.setVisible(z16);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public final void setWidth(float f16) {
        if (f16 < 0.0f) {
            f16 = 1.0f;
        }
        if (f16 > 128.0f) {
            f16 = 128.0f;
        }
        setStrokeWidth(f16);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Animationable
    public final boolean startAnimation() {
        hw a16;
        if (this.U == null || (a16 = iv.a(this.f149621t.L(), this.U)) == null) {
            return false;
        }
        a(a16.f148757a);
        return false;
    }

    @Override // com.tencent.mapsdk.internal.po, com.tencent.mapsdk.internal.ez
    public final void u() {
        super.u();
        qv qvVar = this.f149615b;
        if (qvVar != null) {
            qvVar.u();
        }
    }

    @Override // com.tencent.mapsdk.internal.po
    public final void w() {
        super.w();
        qv qvVar = this.f149615b;
        if (qvVar != null) {
            qvVar.w();
        }
    }

    private b c(List<GeoPoint> list) {
        int[] iArr;
        int[] iArr2 = this.f149623v;
        if (iArr2 != null && (iArr = this.f149624w) != null && list != null && iArr2.length != 0 && iArr.length != 0 && !list.isEmpty()) {
            TreeSet treeSet = new TreeSet(new Comparator<Integer>() { // from class: com.tencent.mapsdk.internal.pr.2
                private static int a(Integer num, Integer num2) {
                    return num.compareTo(num2);
                }

                @Override // java.util.Comparator
                public final /* synthetic */ int compare(Integer num, Integer num2) {
                    return num.compareTo(num2);
                }
            });
            for (int i3 : this.f149624w) {
                if (i3 >= 0 && i3 < list.size()) {
                    treeSet.add(Integer.valueOf(i3));
                }
            }
            ArrayList arrayList = new ArrayList();
            for (int i16 : this.f149623v) {
                arrayList.add(Integer.valueOf(i16));
            }
            if (treeSet.isEmpty()) {
                b bVar = new b(1);
                bVar.a(0, ((Integer) arrayList.get(0)).intValue());
                return bVar;
            }
            Integer[] numArr = (Integer[]) treeSet.toArray(new Integer[0]);
            if (numArr[0].intValue() != 0) {
                treeSet.add(0);
                arrayList.add(0, Integer.valueOf(this.f149623v[0]));
            }
            if (numArr[numArr.length - 1].intValue() != list.size() - 1) {
                treeSet.add(Integer.valueOf(list.size() - 1));
                if (numArr.length > this.f149623v.length) {
                    int size = arrayList.size() - 1;
                    int[] iArr3 = this.f149623v;
                    arrayList.add(size, Integer.valueOf(iArr3[iArr3.length - 1]));
                }
            }
            ArrayList arrayList2 = new ArrayList(treeSet);
            int size2 = arrayList2.size();
            b bVar2 = new b(size2);
            for (int i17 = 0; i17 < size2; i17++) {
                if (i17 > arrayList.size() - 1) {
                    bVar2.a(((Integer) arrayList2.get(i17)).intValue(), ((Integer) arrayList.get(arrayList.size() - 1)).intValue());
                } else {
                    bVar2.a(((Integer) arrayList2.get(i17)).intValue(), ((Integer) arrayList.get(i17)).intValue());
                }
            }
            return bVar2;
        }
        int i18 = this.f149555g;
        if (this.f149627z == PolylineOptions.ColorType.LINE_COLOR_TEXTURE) {
            i18 = c(i18);
        }
        b bVar3 = new b(1);
        bVar3.a(0, i18);
        return bVar3;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public final void setColorTexture(BitmapDescriptor bitmapDescriptor) {
        if (this.f149621t == null || bitmapDescriptor == null || bitmapDescriptor.getFormater() == null) {
            return;
        }
        this.A = bitmapDescriptor;
        bitmapDescriptor.getBitmap(this.f149621t.getContext());
        this.f149627z = PolylineOptions.ColorType.LINE_COLOR_TEXTURE;
        w();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class a extends GeoPoint {

        /* renamed from: a, reason: collision with root package name */
        float f149631a;

        /* renamed from: b, reason: collision with root package name */
        int f149632b;

        public a() {
            this.f149631a = 0.0f;
            this.f149632b = 0;
        }

        @Override // com.tencent.map.lib.models.GeoPoint
        public final String toString() {
            return super.toString() + "," + this.f149631a;
        }

        public a(GeoPoint geoPoint) {
            super(geoPoint);
            this.f149631a = 0.0f;
            this.f149632b = 0;
        }
    }

    private void a(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor.getBitmap(this.X.H()) != null) {
            this.P = bitmapDescriptor.getFormater().getBitmapId();
        }
    }

    private ArrayList<GeoPoint> b(List<a> list) {
        ArrayList<GeoPoint> arrayList = new ArrayList<>();
        if (list != null && list.size() >= 2) {
            float f16 = this.E.f149631a;
            float f17 = this.K - f16;
            float f18 = this.F;
            float f19 = f17 * f18;
            float f26 = f16 - (f16 * f18);
            float f27 = f16 + f19;
            a aVar = null;
            int i3 = 0;
            while (true) {
                if (i3 >= list.size()) {
                    break;
                }
                a aVar2 = list.get(i3);
                float f28 = aVar2.f149631a;
                if (f28 > f26 && f28 < f27) {
                    if (aVar != null) {
                        float f29 = aVar.f149631a;
                        if (f29 < f26) {
                            a a16 = a(aVar, aVar2, (f26 - f29) / (f28 - f29));
                            a16.f149632b = aVar.f149632b;
                            arrayList.add(a16);
                        }
                    }
                    arrayList.add(aVar2);
                } else if (f28 > f27) {
                    if (aVar != null) {
                        float f36 = aVar.f149631a;
                        if (f36 < f27) {
                            a a17 = a(aVar, aVar2, (f27 - f36) / (f28 - f36));
                            a17.f149632b = aVar2.f149632b;
                            arrayList.add(a17);
                        }
                    }
                } else if (Float.compare(f28, f26) == 0 || Float.compare(aVar2.f149631a, f27) == 0) {
                    arrayList.add(aVar2);
                }
                i3++;
                aVar = aVar2;
            }
        }
        return arrayList;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline, com.tencent.tencentmap.mapsdk.maps.interfaces.Animationable
    public final void startAnimation(Animation animation) {
        setAnimation(animation);
        startAnimation();
    }

    private void a(int i3) {
        this.Q = i3;
    }

    private void d(List<Integer> list) {
        this.R = list;
        w();
    }

    private void a(List<LatLng> list) {
        int size;
        this.W = list;
        if (list != null && (size = list.size()) > 0) {
            this.K = 0.0f;
            this.f149618q.clear();
            a aVar = null;
            for (int i3 = 0; i3 < size; i3++) {
                LatLng latLng = list.get(i3);
                if (latLng != null) {
                    a aVar2 = new a(GeoPoint.from(latLng));
                    if (aVar != null) {
                        float hypot = this.K + ((float) (Math.hypot(aVar2.getLatitudeE6() - aVar.getLatitudeE6(), aVar2.getLongitudeE6() - aVar.getLongitudeE6()) + 0.0d));
                        this.K = hypot;
                        aVar2.f149631a = hypot;
                        aVar2.f149632b = aVar.f149632b + 1;
                    }
                    this.f149618q.add(aVar2);
                    aVar = aVar2;
                }
            }
            w();
        }
    }

    @Override // com.tencent.mapsdk.internal.as
    public final void b(boolean z16) {
        this.L = z16;
        qv qvVar = this.f149615b;
        if (qvVar != null) {
            qvVar.f149938b.E = z16;
        }
        w();
    }

    private PolylineOptions.ColorType a(PolylineOptions.ColorType colorType) {
        if (colorType != PolylineOptions.ColorType.LINE_COLOR_NONE) {
            return colorType;
        }
        int[] iArr = this.f149623v;
        if (iArr != null && iArr.length > 0) {
            int length = iArr.length;
            for (int i3 = 0; i3 < length; i3++) {
                int i16 = this.f149623v[i3];
                if (i16 < 0 || i16 >= 12) {
                    return PolylineOptions.ColorType.LINE_COLOR_ARGB;
                }
            }
            return PolylineOptions.ColorType.LINE_COLOR_TEXTURE;
        }
        int i17 = this.f149555g;
        return (i17 < 0 || i17 >= 12) ? PolylineOptions.ColorType.LINE_COLOR_ARGB : PolylineOptions.ColorType.LINE_COLOR_TEXTURE;
    }

    private void b(float f16) {
        this.f149620s = f16;
    }

    private as j() {
        return this;
    }

    @Override // com.tencent.mapsdk.internal.aw
    public final /* bridge */ /* synthetic */ aq f_() {
        return this;
    }

    @Override // com.tencent.mapsdk.internal.po, com.tencent.mapsdk.internal.ez
    public final void a(IndoorBuilding indoorBuilding) {
        super.a(indoorBuilding);
        qv qvVar = this.f149615b;
        if (qvVar != null) {
            qvVar.a(indoorBuilding);
        }
    }

    private void c(boolean z16) {
        this.M = z16;
        w();
    }

    private static float a(GeoPoint geoPoint, GeoPoint geoPoint2) {
        if (geoPoint2 == null) {
            return 0.0f;
        }
        return (float) (Math.hypot(geoPoint.getLatitudeE6() - geoPoint2.getLatitudeE6(), geoPoint.getLongitudeE6() - geoPoint2.getLongitudeE6()) + 0.0d);
    }

    private static a a(a aVar, a aVar2, float f16) {
        a aVar3 = new a();
        int longitudeE6 = aVar2.getLongitudeE6() - aVar.getLongitudeE6();
        aVar3.setLatitudeE6(aVar.getLatitudeE6() + Math.round((aVar2.getLatitudeE6() - aVar.getLatitudeE6()) * f16));
        aVar3.setLongitudeE6(aVar.getLongitudeE6() + Math.round(longitudeE6 * f16));
        float f17 = aVar.f149631a;
        aVar3.f149631a = f17 + ((aVar2.f149631a - f17) * f16);
        return aVar3;
    }

    private static float a(a aVar, a aVar2, GeoPoint geoPoint, a aVar3) {
        double hypot;
        int longitudeE6 = aVar.getLongitudeE6();
        int latitudeE6 = aVar.getLatitudeE6();
        int longitudeE62 = aVar2.getLongitudeE6();
        int latitudeE62 = aVar2.getLatitudeE6();
        int longitudeE63 = geoPoint.getLongitudeE6();
        int i3 = longitudeE62 - longitudeE6;
        int i16 = longitudeE63 - longitudeE6;
        int i17 = latitudeE62 - latitudeE6;
        int latitudeE63 = geoPoint.getLatitudeE6() - latitudeE6;
        float f16 = (i3 * i16) + (i17 * latitudeE63);
        if (f16 <= 0.0f) {
            aVar3.setLatitudeE6(aVar.getLatitudeE6());
            aVar3.setLongitudeE6(aVar.getLongitudeE6());
            aVar3.f149631a = aVar.f149631a;
            hypot = Math.hypot(i16, latitudeE63);
        } else {
            double d16 = (i3 * i3) + (i17 * i17);
            double d17 = f16;
            if (d17 >= d16) {
                aVar3.setLatitudeE6(aVar2.getLatitudeE6());
                aVar3.setLongitudeE6(aVar2.getLongitudeE6());
                aVar3.f149631a = aVar2.f149631a;
                hypot = Math.hypot(longitudeE63 - longitudeE62, r14 - latitudeE62);
            } else {
                float f17 = (float) (d17 / d16);
                aVar3.setLongitudeE6(Math.round(longitudeE6 + (i3 * f17)));
                aVar3.setLatitudeE6(Math.round(latitudeE6 + (i17 * f17)));
                float f18 = aVar.f149631a;
                aVar3.f149631a = f18 + ((aVar2.f149631a - f18) * f17);
                hypot = Math.hypot(longitudeE63 - r0, r14 - r1);
            }
        }
        return (float) hypot;
    }

    private void a(Polyline polyline) {
        this.f149617p = polyline;
    }

    @Override // com.tencent.mapsdk.internal.as
    public final void a(float f16) {
        this.D = f16;
        w();
    }

    @Override // com.tencent.mapsdk.internal.as
    public final void a(int i3, LatLng latLng) {
        GeoPoint from = GeoPoint.from(latLng);
        if (i3 == -1 || from == null) {
            return;
        }
        this.N = i3;
        this.O = from;
        qv qvVar = this.f149615b;
        if (qvVar != null) {
            qvVar.a(i3, from);
        }
        ne neVar = this.f149621t;
        if (neVar != null) {
            neVar.f149412y = true;
        }
    }

    @Override // com.tencent.mapsdk.internal.as
    public final void a(in inVar) {
        in inVar2 = this.C;
        if (inVar2 != null) {
            inVar2.f148800b = false;
            inVar2.a((in.b) null);
        }
        if (inVar instanceof ip) {
            a((ip) inVar);
        } else if (inVar instanceof im) {
            a((im) inVar);
        } else {
            this.C = null;
        }
    }

    @Override // com.tencent.mapsdk.internal.as
    public final void a(boolean z16) {
        c(z16);
    }

    private void a(ip ipVar) {
        if (this.f149621t == null) {
            return;
        }
        this.C = ipVar;
        GeoPoint from = GeoPoint.from(ipVar.f148809i);
        a a16 = a(from);
        this.E = a16;
        if (a16 == null) {
            LogUtil.d("Error, start point not found. [p=" + from + "] [offsetGeoPoints=" + this.f149618q + "]");
            return;
        }
        ipVar.a(this.f149614aa);
        ipVar.a((GeoPoint) null, (GeoPoint) null);
        this.f149621t.f149412y = true;
    }

    private void a(im imVar) {
        this.C = imVar;
        imVar.a(this.f149614aa);
        this.C.a((GeoPoint) null, (GeoPoint) null);
        ne neVar = this.f149621t;
        if (neVar != null) {
            neVar.f149412y = true;
        }
    }

    private a a(GeoPoint geoPoint) {
        a aVar = new a();
        List<a> list = this.f149618q;
        a aVar2 = null;
        if (list != null && list.size() >= 2 && geoPoint != null) {
            a aVar3 = this.f149618q.get(0);
            int i3 = 1;
            float f16 = Float.MAX_VALUE;
            while (i3 < this.f149618q.size()) {
                a aVar4 = this.f149618q.get(i3);
                float a16 = a(aVar3, aVar4, geoPoint, aVar);
                if (a16 < f16) {
                    f16 = a16;
                    aVar2 = aVar;
                    aVar = new a();
                }
                i3++;
                aVar3 = aVar4;
            }
        }
        return aVar2;
    }

    private static int a(Context context, BitmapDescriptor bitmapDescriptor) {
        Bitmap bitmap;
        int height;
        if (context == null || bitmapDescriptor == null || (bitmap = bitmapDescriptor.getBitmap(context)) == null || (height = bitmap.getHeight()) <= 0) {
            return 0;
        }
        return (int) ((Math.pow(2.0d, 25.0d) / Math.pow(height, 2.0d)) / ht.a(context));
    }
}
