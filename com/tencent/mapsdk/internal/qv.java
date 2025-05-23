package com.tencent.mapsdk.internal;

import android.graphics.Rect;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.map.tools.CallbackRunnable;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.mapsdk.engine.jni.models.TappedElement;
import com.tencent.mapsdk.internal.tk;
import com.tencent.mapsdk.vector.VectorMap;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Selectable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class qv extends po {
    private boolean A;
    private aq B;

    /* renamed from: b, reason: collision with root package name */
    public ga f149938b;

    /* renamed from: d, reason: collision with root package name */
    public int[] f149939d;

    /* renamed from: p, reason: collision with root package name */
    public int[] f149940p;

    /* renamed from: q, reason: collision with root package name */
    public int f149941q;

    /* renamed from: r, reason: collision with root package name */
    public GeoPoint f149942r;

    /* renamed from: s, reason: collision with root package name */
    public int f149943s;

    /* renamed from: t, reason: collision with root package name */
    public a f149944t;

    /* renamed from: u, reason: collision with root package name */
    private bf f149945u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f149946v;

    /* renamed from: w, reason: collision with root package name */
    private Selectable.OnSelectedListener f149947w;

    /* renamed from: x, reason: collision with root package name */
    private float f149948x;

    /* renamed from: y, reason: collision with root package name */
    private int f149949y;

    /* renamed from: z, reason: collision with root package name */
    private nd f149950z;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f149951a;

        /* renamed from: b, reason: collision with root package name */
        public int f149952b;
    }

    public qv(aq aqVar, bb bbVar, ga gaVar) {
        super(bbVar);
        this.f149946v = true;
        this.f149943s = -1;
        this.f149948x = -1.0f;
        this.f149949y = -1;
        this.B = aqVar;
        this.f149950z = bbVar.c();
        a(gaVar);
    }

    private int A() {
        return this.f149941q;
    }

    private boolean B() {
        return this.f149938b.f148441w;
    }

    private boolean C() {
        return this.f149938b.f148444z;
    }

    private boolean D() {
        return this.f149938b.B;
    }

    private int E() {
        return this.f149938b.C;
    }

    private boolean F() {
        return this.f149938b.O;
    }

    private float G() {
        return this.f149938b.f148442x;
    }

    private float H() {
        ga gaVar = this.f149938b;
        if (gaVar == null) {
            return 1.0f;
        }
        return gaVar.A;
    }

    private a I() {
        return this.f149944t;
    }

    private String J() {
        ga gaVar = this.f149938b;
        int[] iArr = gaVar.f148436r;
        if (iArr != null && iArr.length > 0) {
            int i3 = iArr[0];
            if (i3 == 33) {
                return ga.f148428j;
            }
            if (i3 == 20) {
                return ga.f148429k;
            }
        }
        if (hs.a(gaVar.f148443y)) {
            return ga.f148427i;
        }
        return this.f149938b.f148443y;
    }

    private int K() {
        return this.f149943s;
    }

    private boolean L() {
        return this.f149938b.D;
    }

    private boolean M() {
        return this.f149938b.E;
    }

    private Rect N() {
        int i3;
        Rect rect;
        ArrayList<GeoPoint> arrayList = this.f149938b.f148430l;
        if (arrayList != null && !arrayList.isEmpty() && (i3 = this.f149941q) >= 0 && i3 < arrayList.size()) {
            List<GeoPoint> subList = arrayList.subList(this.f149941q, arrayList.size());
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
                this.f149938b.F = rect;
            }
        }
        return this.f149938b.F;
    }

    private String O() {
        return this.f149938b.H;
    }

    private float P() {
        return this.f149938b.I;
    }

    private int[] Q() {
        ga gaVar = this.f149938b;
        return new int[]{gaVar.J, gaVar.K};
    }

    private List<Integer> R() {
        return this.f149938b.L;
    }

    private void c(float f16) {
        ga gaVar = this.f149938b;
        if (gaVar == null || f16 < 0.0f || f16 > 1.0f) {
            return;
        }
        gaVar.A = f16;
    }

    private ArrayList<GeoPoint> e() {
        return this.f149938b.f148431m;
    }

    private int[] f() {
        return this.f149939d;
    }

    private int[] g() {
        return this.f149940p;
    }

    private boolean h() {
        return this.f149938b.f148440v;
    }

    private int[] i() {
        return this.f149938b.f148437s;
    }

    private int[] j() {
        return this.f149938b.f148438t;
    }

    private float k() {
        return this.f149938b.f148439u;
    }

    private int[] l() {
        return this.f149938b.f148432n;
    }

    private int[] m() {
        return this.f149938b.f148433o;
    }

    private String[] n() {
        return this.f149938b.f148434p;
    }

    private GeoPoint z() {
        return this.f149942r;
    }

    @Override // com.tencent.mapsdk.internal.aw
    /* renamed from: a */
    public final Rect getScreenBound(fa faVar) {
        Rect bound = getBound(faVar);
        if (bound == null) {
            return null;
        }
        GeoPoint geoPoint = new GeoPoint(bound.top, bound.left);
        GeoPoint geoPoint2 = new GeoPoint(bound.bottom, bound.right);
        fw a16 = faVar.a(geoPoint);
        fw a17 = faVar.a(geoPoint2);
        return new Rect((int) a16.f148383a, (int) a16.f148384b, (int) a17.f148383a, (int) a17.f148384b);
    }

    @Override // com.tencent.mapsdk.internal.po, com.tencent.mapsdk.internal.aw
    /* renamed from: b */
    public final Rect getBound(fa faVar) {
        ArrayList<GeoPoint> arrayList;
        ga gaVar = this.f149938b;
        if (gaVar == null || (arrayList = gaVar.f148431m) == null || arrayList.isEmpty()) {
            return null;
        }
        Iterator<GeoPoint> it = this.f149938b.f148431m.iterator();
        int i3 = Integer.MAX_VALUE;
        int i16 = Integer.MIN_VALUE;
        int i17 = Integer.MIN_VALUE;
        int i18 = Integer.MAX_VALUE;
        while (it.hasNext()) {
            GeoPoint next = it.next();
            int latitudeE6 = next.getLatitudeE6();
            int longitudeE6 = next.getLongitudeE6();
            if (latitudeE6 > i16) {
                i16 = latitudeE6;
            }
            if (latitudeE6 < i18) {
                i18 = latitudeE6;
            }
            if (longitudeE6 > i17) {
                i17 = longitudeE6;
            }
            if (longitudeE6 < i3) {
                i3 = longitudeE6;
            }
        }
        return new Rect(i3, i16, i17, i18);
    }

    public final void d() {
        a aVar = this.f149944t;
        if (aVar != null) {
            aVar.f149951a = -1;
            w();
        }
    }

    @Override // com.tencent.mapsdk.internal.aw
    public final aq f_() {
        return this.B;
    }

    @Override // com.tencent.mapsdk.internal.po, com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.interfaces.Levelable
    public final int getLevel() {
        return this.f149938b.M;
    }

    @Override // com.tencent.mapsdk.internal.po, com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.interfaces.Levelable
    public final int getZIndex() {
        return this.f149938b.G;
    }

    @Override // com.tencent.mapsdk.internal.po
    public final void h_() {
        this.A = true;
    }

    @Override // com.tencent.mapsdk.internal.po, com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.interfaces.Selectable
    public final boolean isSelected() {
        return this.f149946v;
    }

    @Override // com.tencent.mapsdk.internal.po
    public final void j_() {
        nd ndVar = this.f149950z;
        if (ndVar == null) {
            return;
        }
        bf bfVar = ndVar.f149380a;
        this.f149945u = bfVar;
        tr trVar = (tr) bfVar.b();
        if (trVar == null) {
            return;
        }
        if (this.A && this.f149943s != -1) {
            LogUtil.b(ky.f149101g, "deleteLine..." + this.f149943s);
            VectorMap vectorMap = (VectorMap) trVar.e_;
            vectorMap.f151351o.f149400m.b(this);
            vectorMap.f151351o.f149412y = true;
            tk g16 = this.f149945u.g();
            g16.a(new tk.AnonymousClass126(this.f149943s, this.f149938b.B));
            this.f149943s = -1;
            return;
        }
        float f16 = ndVar.f149380a.a().A.f151253b.f151290p;
        float f17 = this.f149948x;
        if (f17 == -1.0f || f17 != f16) {
            this.f149948x = f16;
        }
        if (this.f149943s == -1) {
            tk g17 = this.f149945u.g();
            this.f149943s = ((Integer) g17.a((CallbackRunnable<tk.AnonymousClass121>) new tk.AnonymousClass121(this), (tk.AnonymousClass121) (-1))).intValue();
            LogUtil.b(ky.f149101g, "createLine..." + this.f149943s);
        }
        if (v()) {
            tk g18 = this.f149945u.g();
            g18.a(new tk.AnonymousClass122(this));
        }
    }

    @Override // com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.interfaces.Tappable
    public final boolean onTap(float f16, float f17) {
        TappedElement a16;
        bf bfVar = this.f149945u;
        if (bfVar == null || (a16 = bfVar.g().a(f16, f17)) == null || a16.itemId != this.f149943s) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mapsdk.internal.po, com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.interfaces.Selectable
    public final void setSelected(boolean z16) {
        this.f149946v = z16;
        bf bfVar = this.f149945u;
        if (bfVar != null && bfVar.g() != null) {
            tk g16 = this.f149945u.g();
            g16.a(new tk.AnonymousClass124(this));
        }
    }

    @Override // com.tencent.mapsdk.internal.po, com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.interfaces.Levelable
    public final void setZIndex(int i3) {
        this.f149938b.G = i3;
        bf bfVar = this.f149945u;
        if (bfVar != null && bfVar.g() != null) {
            this.f149945u.g().a(this.f149949y, i3);
        }
    }

    @Deprecated
    private void c(String str) {
        this.f149938b.f148443y = str;
    }

    private void b(float f16) {
        this.f149938b.f148439u = f16;
    }

    public final void a(int i3, GeoPoint geoPoint) {
        this.f149941q = i3;
        this.f149942r = geoPoint;
        w();
    }

    private void b(String str) {
        this.f149938b.f148443y = str;
    }

    private void b(boolean z16) {
        this.f149938b.E = z16;
    }

    private void a(boolean z16) {
        this.f149938b.f148441w = z16;
    }

    private static Rect b(List<GeoPoint> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        GeoPoint geoPoint = list.get(0);
        int longitudeE6 = geoPoint.getLongitudeE6();
        int longitudeE62 = geoPoint.getLongitudeE6();
        int latitudeE6 = geoPoint.getLatitudeE6();
        int latitudeE62 = geoPoint.getLatitudeE6();
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            GeoPoint geoPoint2 = list.get(i3);
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
        return new Rect(longitudeE6, latitudeE6, longitudeE62, latitudeE62);
    }

    private void a(float f16) {
        this.f149938b.f148442x = f16;
    }

    private void a(int[] iArr) {
        this.f149938b.f148438t = iArr;
    }

    private void a(int i3, int i16) {
        a aVar = new a();
        this.f149944t = aVar;
        aVar.f149951a = i3;
        aVar.f149952b = i16;
        w();
    }

    @Deprecated
    private void a(String str) {
        this.f149938b.f148443y = str;
    }

    private void a(int i3) {
        this.f149943s = i3;
    }

    public final void a(ga gaVar) {
        if (gaVar != null && gaVar.a()) {
            if (gaVar.equals(this.f149938b)) {
                return;
            }
            w();
            this.f149938b = gaVar;
            this.f149939d = gaVar.f148435q;
            this.f149940p = gaVar.f148436r;
            return;
        }
        LogUtil.c("LineOptions\u4e0d\u80fd\u4e3a\u7a7a\uff01");
    }

    private void a(List<Integer> list) {
        this.f149938b.b(list);
    }
}
