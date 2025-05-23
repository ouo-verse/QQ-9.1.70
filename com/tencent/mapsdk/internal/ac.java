package com.tencent.mapsdk.internal;

import android.text.TextUtils;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.map.tools.CallbackRunnable;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.mapsdk.internal.tk;
import com.tencent.mapsdk.vector.VectorMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorBuilding;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorLevel;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class ac implements fo, ox {

    /* renamed from: a, reason: collision with root package name */
    public mv f147688a;

    /* renamed from: b, reason: collision with root package name */
    public fz f147689b;

    /* renamed from: d, reason: collision with root package name */
    public VectorMap f147691d;

    /* renamed from: e, reason: collision with root package name */
    public ne f147692e;

    /* renamed from: h, reason: collision with root package name */
    float f147695h;

    /* renamed from: i, reason: collision with root package name */
    float f147696i;

    /* renamed from: k, reason: collision with root package name */
    private boolean f147698k;

    /* renamed from: l, reason: collision with root package name */
    private tr f147699l;

    /* renamed from: m, reason: collision with root package name */
    private TencentMap.OnIndoorStateChangeListener f147700m;

    /* renamed from: c, reason: collision with root package name */
    public int f147690c = a.f147710a;

    /* renamed from: f, reason: collision with root package name */
    public boolean f147693f = false;

    /* renamed from: g, reason: collision with root package name */
    public IndoorBuilding f147694g = null;

    /* renamed from: j, reason: collision with root package name */
    public TencentMap.OnScaleViewChangedListener f147697j = new TencentMap.OnScaleViewChangedListener() { // from class: com.tencent.mapsdk.internal.ac.1
        @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnScaleViewChangedListener
        public final void onScaleViewChanged(float f16) {
            IndoorBuilding indoorBuilding;
            ac acVar = ac.this;
            float f17 = acVar.f147696i;
            acVar.f147695h = f17;
            acVar.f147696i = f16;
            if (f17 > 20.0d && f16 <= 20.0d && acVar.f147693f && (indoorBuilding = acVar.f147694g) != null) {
                String buidlingId = indoorBuilding.getBuidlingId();
                hi hiVar = ac.this.f147692e.f147918e;
                if (hiVar != null && !TextUtils.isEmpty(buidlingId)) {
                    hiVar.d().a(buidlingId).c();
                }
            }
        }
    };

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.ac$2, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass2 implements Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ac acVar = ac.this;
            int i3 = acVar.f147690c;
            if (i3 == a.f147710a) {
                acVar.a(acVar.f147689b.a());
            } else {
                acVar.a(i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.ac$4, reason: invalid class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f147709a;

        static {
            int[] iArr = new int[a.a().length];
            f147709a = iArr;
            try {
                iArr[a.f147711b - 1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f147709a[a.f147710a - 1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f147709a[a.f147712c - 1] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final int f147710a = 1;

        /* renamed from: b, reason: collision with root package name */
        public static final int f147711b = 2;

        /* renamed from: c, reason: collision with root package name */
        public static final int f147712c = 3;

        /* renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ int[] f147713d = {1, 2, 3};

        a(String str, int i3) {
        }

        public static int[] a() {
            return (int[]) f147713d.clone();
        }
    }

    public ac(tr trVar, String str) {
        JSONArray jSONArray = null;
        this.f147700m = null;
        this.f147691d = null;
        this.f147699l = trVar;
        if (trVar != null) {
            if (str == null) {
                this.f147688a = my.a(trVar.H());
            } else {
                this.f147688a = mx.a(trVar.H(), str);
            }
            tr trVar2 = this.f147699l;
            this.f147691d = (VectorMap) trVar2.e_;
            this.f147692e = trVar2.aC;
            int b16 = this.f147688a.b(et.B);
            int b17 = this.f147688a.b(et.C);
            String a16 = this.f147688a.a(et.D);
            try {
                if (!TextUtils.isEmpty(a16)) {
                    jSONArray = new JSONArray(a16);
                }
            } catch (Exception e16) {
                LogUtil.a(ky.f149109o, "indoor auth init failed", e16);
            }
            if (b16 != -1 && b17 != -1 && jSONArray != null) {
                this.f147689b = new fz(b16, b17, jSONArray);
            }
            VectorMap vectorMap = this.f147691d;
            if (vectorMap != null) {
                vectorMap.a(a());
                if (b17 == 1) {
                    this.f147691d.a(b());
                }
            }
            a(false);
        }
        VectorMap vectorMap2 = this.f147691d;
        if (vectorMap2 != null) {
            vectorMap2.a((fo) this);
            this.f147691d.f151351o.a(this);
            this.f147700m = new to(this.f147699l);
        }
    }

    private boolean g() {
        return this.f147693f;
    }

    private void h() {
        M m3;
        tr trVar = this.f147699l;
        if (trVar != null && (m3 = trVar.e_) != 0 && !this.f147693f) {
            VectorMap vectorMap = (VectorMap) m3;
            int min = Math.min(20, trVar.f151053j);
            if (vectorMap.f151351o.f149410w.a() < min) {
                vectorMap.b(min);
            }
        }
    }

    private void i() {
        IndoorBuilding indoorBuilding = this.f147694g;
        if (indoorBuilding != null) {
            String buidlingId = indoorBuilding.getBuidlingId();
            int activeLevelIndex = this.f147694g.getActiveLevelIndex();
            List<IndoorLevel> levels = this.f147694g.getLevels();
            if (levels != null && activeLevelIndex < levels.size()) {
                String name = levels.get(activeLevelIndex).getName();
                if (!hs.a(buidlingId) && !hs.a(name)) {
                    this.f147692e.a(buidlingId, name);
                }
            }
        }
    }

    private IndoorBuilding j() {
        return this.f147694g;
    }

    private String k() {
        IndoorBuilding indoorBuilding = this.f147694g;
        if (indoorBuilding == null) {
            return null;
        }
        return indoorBuilding.getBuidlingId();
    }

    private int l() {
        IndoorBuilding indoorBuilding = this.f147694g;
        if (indoorBuilding == null) {
            return -1;
        }
        return indoorBuilding.getActiveLevelIndex();
    }

    private String[] m() {
        IndoorBuilding indoorBuilding = this.f147694g;
        if (indoorBuilding != null && indoorBuilding.getLevels() != null && !this.f147694g.getLevels().isEmpty()) {
            List<IndoorLevel> levels = this.f147694g.getLevels();
            String[] strArr = new String[levels.size()];
            for (int i3 = 0; i3 < levels.size(); i3++) {
                strArr[i3] = levels.get(i3).getName();
            }
            return strArr;
        }
        return null;
    }

    private String n() {
        IndoorBuilding indoorBuilding = this.f147694g;
        if (indoorBuilding == null) {
            return "";
        }
        return indoorBuilding.getBuildingName();
    }

    private IndoorBuilding o() {
        return this.f147694g;
    }

    private TencentMap.OnScaleViewChangedListener d() {
        return this.f147697j;
    }

    private void e() {
        int b16 = this.f147688a.b(et.B);
        int b17 = this.f147688a.b(et.C);
        String a16 = this.f147688a.a(et.D);
        JSONArray jSONArray = null;
        try {
            if (!TextUtils.isEmpty(a16)) {
                jSONArray = new JSONArray(a16);
            }
        } catch (Exception e16) {
            LogUtil.a(ky.f149109o, "indoor auth init failed", e16);
        }
        if (b16 != -1 && b17 != -1 && jSONArray != null) {
            this.f147689b = new fz(b16, b17, jSONArray);
        }
        VectorMap vectorMap = this.f147691d;
        if (vectorMap != null) {
            vectorMap.a(a());
            if (b17 == 1) {
                this.f147691d.a(b());
            }
        }
    }

    private boolean f() {
        fz fzVar = this.f147689b;
        return fzVar != null && fzVar.a();
    }

    @Override // com.tencent.mapsdk.internal.ox
    public final void c() {
        tr trVar;
        M m3;
        if (!this.f147698k || (trVar = this.f147699l) == null || (m3 = trVar.e_) == 0) {
            return;
        }
        GeoPoint geoPoint = new GeoPoint();
        tk tkVar = ((VectorMap) m3).f151351o.f149396i;
        qr qrVar = (qr) tkVar.a(new tk.AnonymousClass162(geoPoint), (tk.AnonymousClass162) null);
        if (qrVar == null) {
            return;
        }
        final LatLng latLng = new LatLng((geoPoint.getLatitudeE6() * 1.0d) / 1000000.0d, (geoPoint.getLongitudeE6() * 1.0d) / 1000000.0d);
        final String str = qrVar.f149895a;
        final String str2 = qrVar.f149896b;
        final String[] strArr = qrVar.f149898d;
        final int i3 = qrVar.f149897c;
        kp.a(new Runnable() { // from class: com.tencent.mapsdk.internal.ac.3
            @Override // java.lang.Runnable
            public final void run() {
                ac.this.a(str, str2, latLng, strArr, i3);
            }
        });
    }

    private void b(boolean z16) {
        int i3 = z16 ? a.f147711b : a.f147712c;
        this.f147690c = i3;
        a(i3);
    }

    private void a(fz fzVar) {
        if (fzVar != null) {
            this.f147689b = fzVar;
            LogUtil.b(ky.f149101g, "IndoorAuth:".concat(String.valueOf(fzVar)));
            this.f147688a.a(et.B, fzVar.f148412c);
            this.f147688a.a(et.C, fzVar.f148413d);
            JSONArray jSONArray = fzVar.f148414e;
            if (jSONArray != null) {
                this.f147688a.a(et.D, jSONArray.toString());
            }
            VectorMap vectorMap = this.f147691d;
            if (vectorMap != null) {
                vectorMap.a(a());
                if (a() == 1) {
                    this.f147691d.a(b());
                }
            }
        } else {
            this.f147688a.a(new String[]{et.B, et.C, et.D});
        }
        if (this.f147689b == null) {
            this.f147689b = new fz();
        }
        kp.a(new AnonymousClass2());
    }

    public final String[] b() {
        fz fzVar = this.f147689b;
        if (fzVar != null) {
            return fzVar.f148415f;
        }
        return null;
    }

    @Override // com.tencent.mapsdk.internal.fo
    public final void b(int i3) {
        tr trVar;
        if (!this.f147698k || (trVar = this.f147699l) == null || trVar.e_ == 0 || trVar.f151057n == null || this.f147693f) {
            return;
        }
        h();
    }

    private void c(int i3) {
        ne neVar = this.f147692e;
        if (neVar == null) {
            return;
        }
        hi hiVar = neVar.f147918e;
        IndoorBuilding indoorBuilding = this.f147694g;
        if (indoorBuilding != null) {
            String buidlingId = indoorBuilding.getBuidlingId();
            if (hiVar != null && !TextUtils.isEmpty(buidlingId)) {
                hiVar.d().a(buidlingId).b();
            }
        }
        tk tkVar = this.f147692e.f149396i;
        if (tkVar != null) {
            tkVar.a(new tk.AnonymousClass159(i3));
        }
        c();
    }

    public final void a(int i3) {
        int i16 = AnonymousClass4.f147709a[i3 - 1];
        if (i16 == 1) {
            a(true);
        } else if (i16 == 2 || i16 == 3) {
            a(false);
        }
    }

    final void a(boolean z16) {
        this.f147698k = z16;
        if (this.f147692e == null) {
            return;
        }
        if (!f()) {
            this.f147692e.d(false);
            return;
        }
        this.f147692e.d(z16);
        if (z16 || !this.f147693f) {
            return;
        }
        a(null, null, null, null, -1);
    }

    private void c(boolean z16) {
        tk tkVar;
        VectorMap vectorMap = this.f147691d;
        if (vectorMap == null || (tkVar = vectorMap.f151351o.f149396i) == null || tkVar.f150515e == 0) {
            return;
        }
        tkVar.a(new tk.AnonymousClass168(z16));
    }

    public final int a() {
        fz fzVar = this.f147689b;
        return (fzVar == null || !fzVar.b()) ? 0 : 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(String str, String str2, LatLng latLng, String[] strArr, int i3) {
        M m3;
        qs qsVar;
        hi hiVar;
        qs qsVar2;
        hi hiVar2;
        tr trVar = this.f147699l;
        if (trVar == null || (m3 = trVar.e_) == 0) {
            return;
        }
        VectorMap vectorMap = (VectorMap) m3;
        int q16 = vectorMap.q();
        if (str != null && strArr != null && strArr.length > 0 && i3 >= 0 && q16 >= 16) {
            if (!TextUtils.isEmpty(str) && this.f147696i <= 20.0d && !this.f147693f && (hiVar2 = this.f147692e.f147918e) != null) {
                hiVar2.d().a(str).c();
            }
            TencentMap.OnIndoorStateChangeListener onIndoorStateChangeListener = this.f147700m;
            if (onIndoorStateChangeListener != null && !this.f147693f) {
                this.f147693f = true;
                onIndoorStateChangeListener.onIndoorBuildingFocused();
            }
            vectorMap.b(Math.min(this.f147699l.f151053j, 22));
            if (this.f147700m != null) {
                ArrayList arrayList = new ArrayList();
                for (String str3 : strArr) {
                    arrayList.add(new IndoorLevel(str3));
                }
                try {
                    IndoorBuilding indoorBuilding = this.f147694g;
                    if (indoorBuilding != null && indoorBuilding.getBuidlingId().equals(str)) {
                        if (this.f147694g.getActiveLevelIndex() == i3) {
                            return;
                        }
                    }
                } catch (Exception unused) {
                }
                IndoorBuilding indoorBuilding2 = this.f147694g;
                if ((indoorBuilding2 == null || !str.equals(indoorBuilding2.getBuidlingId())) && (hiVar = this.f147692e.f147918e) != null) {
                    hiVar.d().f148622a.a();
                    if (!TextUtils.isEmpty(str)) {
                        hiVar.d().a(str).a();
                    }
                }
                IndoorBuilding indoorBuilding3 = new IndoorBuilding(str, str2, latLng, arrayList, i3);
                this.f147694g = indoorBuilding3;
                tr trVar2 = this.f147699l;
                if (trVar2 != null && (qsVar2 = trVar2.f151057n) != null && qsVar2.f149915b) {
                    qsVar2.a(indoorBuilding3);
                }
                this.f147700m.onIndoorLevelActivated(this.f147694g);
                return;
            }
            return;
        }
        h();
        if (this.f147693f) {
            this.f147693f = false;
            this.f147694g = null;
            tr trVar3 = this.f147699l;
            if (trVar3 != null && (qsVar = trVar3.f151057n) != null) {
                qsVar.a((IndoorBuilding) null);
            }
            TencentMap.OnIndoorStateChangeListener onIndoorStateChangeListener2 = this.f147700m;
            if (onIndoorStateChangeListener2 != null) {
                onIndoorStateChangeListener2.onIndoorBuildingDeactivated();
            }
        }
    }

    private void a(String str, String str2) {
        ne neVar = this.f147692e;
        if (neVar == null) {
            return;
        }
        neVar.a(str, str2);
    }

    private int a(String str) {
        ne neVar;
        tk tkVar;
        VectorMap vectorMap = this.f147691d;
        if (vectorMap == null || (neVar = vectorMap.f151351o) == null || (tkVar = neVar.f149396i) == null) {
            return -1;
        }
        return ((Integer) tkVar.a((CallbackRunnable<tk.AnonymousClass47>) new tk.AnonymousClass47(str), (tk.AnonymousClass47) (-1))).intValue();
    }
}
