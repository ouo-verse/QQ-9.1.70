package com.tencent.mapsdk.internal;

import android.util.Pair;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.mapsdk.internal.ce;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes9.dex */
public class ri extends JsonComposer implements ce {

    /* renamed from: a, reason: collision with root package name */
    @Json(name = "project_id")
    String f150027a;

    /* renamed from: b, reason: collision with root package name */
    @Json(name = "min_level")
    int f150028b;

    /* renamed from: c, reason: collision with root package name */
    @Json(name = "max_level")
    int f150029c;

    /* renamed from: d, reason: collision with root package name */
    @Json(name = "marker_width")
    int f150030d;

    /* renamed from: e, reason: collision with root package name */
    @Json(name = "marker_height")
    int f150031e;

    /* renamed from: f, reason: collision with root package name */
    @Json(name = "day_pic_url")
    String f150032f;

    /* renamed from: g, reason: collision with root package name */
    @Json(name = "offline_time")
    String f150033g;

    /* renamed from: h, reason: collision with root package name */
    @Json(name = "online_time")
    String f150034h;

    /* renamed from: i, reason: collision with root package name */
    @Json(name = "latitude")
    private double f150035i;

    /* renamed from: j, reason: collision with root package name */
    @Json(name = "longitude")
    private double f150036j;

    /* renamed from: k, reason: collision with root package name */
    @Json(name = "marker_anchor_x")
    private float f150037k;

    /* renamed from: l, reason: collision with root package name */
    @Json(name = "marker_anchor_y")
    private float f150038l;

    /* renamed from: m, reason: collision with root package name */
    @Json(name = "night_pic_url")
    private String f150039m;

    /* renamed from: n, reason: collision with root package name */
    @Json(name = "rank")
    private int f150040n;

    /* renamed from: o, reason: collision with root package name */
    @Json(ignore = true)
    private ce.a f150041o = ce.a.IDLE;

    /* renamed from: p, reason: collision with root package name */
    @Json(ignore = true)
    private BitmapDescriptor f150042p;

    /* renamed from: q, reason: collision with root package name */
    @Json(ignore = true)
    private BitmapDescriptor f150043q;

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.ri$1, reason: invalid class name */
    /* loaded from: classes9.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f150044a;

        static {
            int[] iArr = new int[ce.a.values().length];
            f150044a = iArr;
            try {
                iArr[ce.a.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f150044a[ce.a.PREPARING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f150044a[ce.a.WILL_ADD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f150044a[ce.a.WILL_UPDATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f150044a[ce.a.WILL_REMOVE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f150044a[ce.a.ADD.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f150044a[ce.a.SHOWING.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f150044a[ce.a.REMOVE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.ce
    public final String a() {
        return this.f150027a;
    }

    @Override // com.tencent.mapsdk.internal.ce
    public final LatLng b() {
        return new LatLng(this.f150035i, this.f150036j);
    }

    @Override // com.tencent.mapsdk.internal.ce
    public final int c() {
        return this.f150040n;
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(ce ceVar) {
        ce ceVar2 = ceVar;
        if (this.f150027a == null) {
            this.f150027a = "";
        }
        return this.f150027a.compareTo(ceVar2.a());
    }

    @Override // com.tencent.mapsdk.internal.ce
    public final gg d() {
        return gg.a(this.f150028b, this.f150029c);
    }

    @Override // com.tencent.mapsdk.internal.ce
    public final Pair<Integer, Integer> e() {
        return new Pair<>(Integer.valueOf(this.f150030d), Integer.valueOf(this.f150031e));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ri riVar = (ri) obj;
            if (Double.compare(riVar.f150035i, this.f150035i) == 0 && Double.compare(riVar.f150036j, this.f150036j) == 0 && this.f150028b == riVar.f150028b && this.f150029c == riVar.f150029c && this.f150030d == riVar.f150030d && this.f150031e == riVar.f150031e && Float.compare(riVar.f150037k, this.f150037k) == 0 && Float.compare(riVar.f150038l, this.f150038l) == 0 && this.f150040n == riVar.f150040n && Objects.equals(this.f150027a, riVar.f150027a) && Objects.equals(this.f150032f, riVar.f150032f) && Objects.equals(this.f150039m, riVar.f150039m) && Objects.equals(this.f150033g, riVar.f150033g) && Objects.equals(this.f150034h, riVar.f150034h)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mapsdk.internal.ce
    public final Pair<Float, Float> f() {
        return new Pair<>(Float.valueOf(this.f150037k), Float.valueOf(this.f150038l));
    }

    @Override // com.tencent.mapsdk.internal.ce
    public final ce.a g() {
        return this.f150041o;
    }

    public int hashCode() {
        return Objects.hash(this.f150027a, Double.valueOf(this.f150035i), Double.valueOf(this.f150036j), Integer.valueOf(this.f150028b), Integer.valueOf(this.f150029c), Integer.valueOf(this.f150030d), Integer.valueOf(this.f150031e), Float.valueOf(this.f150037k), Float.valueOf(this.f150038l), this.f150032f, this.f150039m, this.f150033g, this.f150034h, Integer.valueOf(this.f150040n));
    }

    public String toString() {
        return "PromoteImageImpl{id='" + this.f150027a + "', latitude=" + this.f150035i + ", longitude=" + this.f150036j + ", minLevel=" + this.f150028b + ", maxLevel=" + this.f150029c + ", width=" + this.f150030d + ", height=" + this.f150031e + ", anchorX=" + this.f150037k + ", anchorY=" + this.f150038l + ", dayPicUrl='" + this.f150032f + "', nightPicUrl='" + this.f150039m + "', offlineTime='" + this.f150033g + "', onlineTime='" + this.f150034h + "', rank=" + this.f150040n + ", thisImageStatus=" + this.f150041o + '}';
    }

    @Override // com.tencent.mapsdk.internal.ce
    public final String a(boolean z16) {
        return z16 ? "" : this.f150032f;
    }

    @Override // com.tencent.mapsdk.internal.ce
    public final BitmapDescriptor b(boolean z16) {
        return z16 ? this.f150043q : this.f150042p;
    }

    @Override // com.tencent.mapsdk.internal.ce
    public final boolean a(int i3, int i16) {
        int i17;
        int i18;
        int i19;
        int i26;
        return b().latitude != 0.0d && b().longitude != 0.0d && Integer.parseInt(this.f150033g) >= Integer.parseInt(this.f150034h) && !hs.a(this.f150027a) && !hs.a(this.f150032f) && (i17 = this.f150030d) > 0 && (i18 = this.f150031e) > 0 && i17 <= 32 && i18 <= 32 && i17 % 4 == 0 && i18 % 4 == 0 && (i19 = this.f150028b) <= (i26 = this.f150029c) && i26 <= i16 && i19 >= i3;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0026, code lost:
    
        if (r0 != com.tencent.mapsdk.internal.ce.a.WILL_UPDATE) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0035, code lost:
    
        if (r0 != com.tencent.mapsdk.internal.ce.a.SHOWING) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0040, code lost:
    
        if (r0 != com.tencent.mapsdk.internal.ce.a.SHOWING) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x004f, code lost:
    
        if (r0 != com.tencent.mapsdk.internal.ce.a.SHOWING) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x005a, code lost:
    
        if (r0 != com.tencent.mapsdk.internal.ce.a.PREPARING) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0069, code lost:
    
        if (r0 != com.tencent.mapsdk.internal.ce.a.WILL_UPDATE) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0074, code lost:
    
        if (r0 != com.tencent.mapsdk.internal.ce.a.PREPARING) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0016, code lost:
    
        if (r3.f150041o != com.tencent.mapsdk.internal.ce.a.WILL_REMOVE) goto L54;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x007a  */
    @Override // com.tencent.mapsdk.internal.ce
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(ce.a aVar) {
        boolean z16;
        if (this.f150041o != aVar) {
            z16 = false;
            switch (AnonymousClass1.f150044a[aVar.ordinal()]) {
                case 1:
                    ce.a aVar2 = this.f150041o;
                    if (aVar2 != ce.a.REMOVE) {
                        break;
                    }
                    break;
                case 2:
                    ce.a aVar3 = this.f150041o;
                    if (aVar3 != ce.a.IDLE) {
                        if (aVar3 != ce.a.WILL_ADD) {
                            break;
                        }
                    }
                    break;
                case 3:
                    ce.a aVar4 = this.f150041o;
                    if (aVar4 != ce.a.IDLE) {
                        break;
                    }
                    break;
                case 4:
                    ce.a aVar5 = this.f150041o;
                    if (aVar5 != ce.a.ADD) {
                        if (aVar5 != ce.a.PREPARING) {
                            break;
                        }
                    }
                    break;
                case 5:
                    ce.a aVar6 = this.f150041o;
                    if (aVar6 != ce.a.ADD) {
                        break;
                    }
                    break;
                case 6:
                    ce.a aVar7 = this.f150041o;
                    if (aVar7 != ce.a.WILL_ADD) {
                        if (aVar7 != ce.a.WILL_UPDATE) {
                            break;
                        }
                    }
                    break;
                case 7:
                    ce.a aVar8 = this.f150041o;
                    if (aVar8 != ce.a.ADD) {
                        if (aVar8 != ce.a.WILL_ADD) {
                            break;
                        }
                    }
                    break;
            }
            if (!z16) {
                this.f150041o = aVar;
            } else {
                LogUtil.e("PromoteImage", "setStatus [" + this.f150041o + "] => [" + aVar + "] fail.");
            }
            return z16;
        }
        z16 = true;
        if (!z16) {
        }
        return z16;
    }

    @Override // com.tencent.mapsdk.internal.ce
    public final void a(BitmapDescriptor bitmapDescriptor, boolean z16) {
        if (z16) {
            this.f150043q = bitmapDescriptor;
        } else {
            this.f150042p = bitmapDescriptor;
        }
    }

    private int a(ce ceVar) {
        if (this.f150027a == null) {
            this.f150027a = "";
        }
        return this.f150027a.compareTo(ceVar.a());
    }
}
