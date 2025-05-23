package com.tencent.luggage.wxa.fd;

import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class x implements Parcelable {
    public final r C;
    public final boolean D;
    public final int E;
    public final k F;
    public final int G;
    public int H;
    public int I;
    public final boolean J;
    public final boolean K;
    public final boolean L;
    public final j M;
    public final boolean N;
    public final h O;
    public final int P;
    public final boolean Q;
    public final String R;
    public final boolean S;
    public final int T;
    public final boolean U;
    public final boolean V;
    public final boolean W;
    public final boolean X;
    public i Y;
    public String Z;

    /* renamed from: a, reason: collision with root package name */
    public final int f125991a;

    /* renamed from: a0, reason: collision with root package name */
    public g0 f125992a0;

    /* renamed from: b, reason: collision with root package name */
    public final a f125993b;

    /* renamed from: b0, reason: collision with root package name */
    public final boolean f125994b0;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f125995c;

    /* renamed from: c0, reason: collision with root package name */
    public final String f125996c0;

    /* renamed from: d, reason: collision with root package name */
    public final b f125997d;

    /* renamed from: d0, reason: collision with root package name */
    public final String f125998d0;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f125999e;

    /* renamed from: e0, reason: collision with root package name */
    public final boolean f126000e0;

    /* renamed from: f, reason: collision with root package name */
    public final e f126001f;

    /* renamed from: g, reason: collision with root package name */
    public final d f126002g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f126003h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f126004i;

    /* renamed from: j, reason: collision with root package name */
    public h0 f126005j;

    /* renamed from: k, reason: collision with root package name */
    public final l f126006k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f126007l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f126008m;

    /* renamed from: f0, reason: collision with root package name */
    public static final g f125988f0 = new g(null);

    @JvmField
    @NotNull
    public static final Parcelable.Creator<x> CREATOR = new f();

    /* renamed from: g0, reason: collision with root package name */
    public static final x f125989g0 = new x(false, 0, null, false, null, false, null, null, false, false, null, null, false, false, null, false, 0, null, 0, 0, 0, false, false, false, null, false, null, 0, false, null, false, 0, false, false, false, false, null, null, null, false, null, null, -4, 1023, null);

    /* renamed from: h0, reason: collision with root package name */
    public static final int f125990h0 = Color.parseColor("#66000000");

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum a {
        POPUP,
        SLIDE
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c {
        public boolean C;
        public boolean E;
        public boolean G;
        public boolean H;
        public boolean I;
        public boolean J;
        public g0 M;
        public boolean N;

        /* renamed from: a, reason: collision with root package name */
        public boolean f126019a;

        /* renamed from: g, reason: collision with root package name */
        public boolean f126025g;

        /* renamed from: j, reason: collision with root package name */
        public boolean f126028j;

        /* renamed from: l, reason: collision with root package name */
        public boolean f126030l;

        /* renamed from: m, reason: collision with root package name */
        public boolean f126031m;

        /* renamed from: n, reason: collision with root package name */
        public boolean f126032n;

        /* renamed from: o, reason: collision with root package name */
        public h0 f126033o;

        /* renamed from: q, reason: collision with root package name */
        public boolean f126035q;

        /* renamed from: s, reason: collision with root package name */
        public boolean f126037s;

        /* renamed from: z, reason: collision with root package name */
        public boolean f126044z;

        /* renamed from: b, reason: collision with root package name */
        public int f126020b = -1;

        /* renamed from: c, reason: collision with root package name */
        public int f126021c = -1;

        /* renamed from: d, reason: collision with root package name */
        public int f126022d = -2;

        /* renamed from: e, reason: collision with root package name */
        public int f126023e = -2;

        /* renamed from: f, reason: collision with root package name */
        public a f126024f = a.POPUP;

        /* renamed from: h, reason: collision with root package name */
        public e f126026h = e.f126050d;

        /* renamed from: i, reason: collision with root package name */
        public b f126027i = b.f126013g;

        /* renamed from: k, reason: collision with root package name */
        public d f126029k = d.NORMAL;

        /* renamed from: p, reason: collision with root package name */
        public l f126034p = l.FAKE_NATIVE;

        /* renamed from: r, reason: collision with root package name */
        public r f126036r = r.NORMAL;

        /* renamed from: t, reason: collision with root package name */
        public int f126038t = x.f125990h0;

        /* renamed from: u, reason: collision with root package name */
        public k f126039u = k.f126063d;

        /* renamed from: v, reason: collision with root package name */
        public boolean f126040v = true;

        /* renamed from: w, reason: collision with root package name */
        public boolean f126041w = true;

        /* renamed from: x, reason: collision with root package name */
        public boolean f126042x = true;

        /* renamed from: y, reason: collision with root package name */
        public j f126043y = j.NORMAL;
        public h A = h.f126053c;
        public int B = -1;
        public String D = "#FFFFFF";
        public int F = -1;
        public i K = i.APP_BRAND;
        public String L = "";
        public String O = "";
        public String P = "";

        public final c a(int i3) {
            this.f126020b = i3;
            return this;
        }

        public final c b(int i3) {
            this.f126022d = i3;
            return this;
        }

        public final c c(int i3) {
            this.f126023e = i3;
            return this;
        }

        public final c d(boolean z16) {
            this.f126019a = z16;
            return this;
        }

        public final c e(boolean z16) {
            this.J = z16;
            return this;
        }

        public final c f(boolean z16) {
            this.f126031m = z16;
            return this;
        }

        public final c g(boolean z16) {
            this.f126028j = z16;
            return this;
        }

        public final c h(boolean z16) {
            this.f126037s = z16;
            return this;
        }

        public final c i(boolean z16) {
            this.f126032n = z16;
            return this;
        }

        public final c j(boolean z16) {
            this.f126041w = z16;
            return this;
        }

        public final c k(boolean z16) {
            this.f126030l = z16;
            return this;
        }

        public final c l(boolean z16) {
            this.I = z16;
            return this;
        }

        public final c a(a activityAnimStyle) {
            Intrinsics.checkNotNullParameter(activityAnimStyle, "activityAnimStyle");
            this.f126024f = activityAnimStyle;
            return this;
        }

        public final c b(boolean z16) {
            this.f126025g = z16;
            return this;
        }

        public final c c(boolean z16) {
            this.f126042x = z16;
            return this;
        }

        public final c d(int i3) {
            this.f126021c = i3;
            return this;
        }

        public final c a(b bgShapeConf) {
            Intrinsics.checkNotNullParameter(bgShapeConf, "bgShapeConf");
            this.f126027i = bgShapeConf;
            return this;
        }

        public final c a(d capsuleType) {
            Intrinsics.checkNotNullParameter(capsuleType, "capsuleType");
            this.f126029k = capsuleType;
            return this;
        }

        public final c a(l splashLoadingType) {
            Intrinsics.checkNotNullParameter(splashLoadingType, "splashLoadingType");
            this.f126034p = splashLoadingType;
            return this;
        }

        public final c a(r loadingDarkModeStyle) {
            Intrinsics.checkNotNullParameter(loadingDarkModeStyle, "loadingDarkModeStyle");
            this.f126036r = loadingDarkModeStyle;
            return this;
        }

        public final c a(boolean z16) {
            this.f126040v = z16;
            return this;
        }

        public final c a(j mode) {
            Intrinsics.checkNotNullParameter(mode, "mode");
            this.f126043y = mode;
            return this;
        }

        public final x a() {
            return new x(this.f126019a, this.f126020b, this.f126024f, this.f126025g, this.f126027i, this.f126028j, this.f126026h, this.f126029k, this.f126030l, this.f126032n, this.f126033o, this.f126034p, this.f126035q, this.f126031m, this.f126036r, this.f126037s, this.f126038t, this.f126039u, this.f126021c, this.f126022d, this.f126023e, this.f126040v, this.f126041w, this.f126042x, this.f126043y, this.f126044z, this.A, this.B, this.C, this.D, this.E, this.F, this.G, this.H, this.I, this.J, this.K, this.L, this.M, this.N, this.O, this.P);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum d {
        NORMAL,
        SINGLE_CLOSE,
        HIDE
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e implements Parcelable {

        /* renamed from: a, reason: collision with root package name */
        public final String f126051a;

        /* renamed from: b, reason: collision with root package name */
        public final a f126052b;

        /* renamed from: c, reason: collision with root package name */
        public static final b f126049c = new b(null);

        @JvmField
        @NotNull
        public static final Parcelable.Creator<e> CREATOR = new a();

        /* renamed from: d, reason: collision with root package name */
        public static final e f126050d = new e("", a.POPUP);

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public e createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new e(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public e[] newArray(int i3) {
                return new e[i3];
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class b {
            public b() {
            }

            public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public e(String activityClassName, a closeAnimStyle) {
            Intrinsics.checkNotNullParameter(activityClassName, "activityClassName");
            Intrinsics.checkNotNullParameter(closeAnimStyle, "closeAnimStyle");
            this.f126051a = activityClassName;
            this.f126052b = closeAnimStyle;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            if (Intrinsics.areEqual(this.f126051a, eVar.f126051a) && this.f126052b == eVar.f126052b) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.f126051a.hashCode() * 31) + this.f126052b.hashCode();
        }

        public String toString() {
            return "CloseWhenClickEmptyAreaConfig(activityClassName=" + this.f126051a + ", closeAnimStyle=" + this.f126052b + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.f126051a);
            parcel.writeString(this.f126052b.name());
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public e(Parcel parcel) {
            this(r0, a.valueOf(r3 != null ? r3 : ""));
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            readString = readString == null ? "" : readString;
            String readString2 = parcel.readString();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public x createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new x(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public x[] newArray(int i3) {
            return new x[i3];
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class g {
        public g() {
        }

        public /* synthetic */ g(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class h implements Parcelable {

        @NotNull
        public static final a CREATOR = new a(null);

        /* renamed from: c, reason: collision with root package name */
        public static final h f126053c = new h("", "");

        /* renamed from: a, reason: collision with root package name */
        public final String f126054a;

        /* renamed from: b, reason: collision with root package name */
        public final String f126055b;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements Parcelable.Creator {
            public a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public h createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new h(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public h[] newArray(int i3) {
                return new h[i3];
            }
        }

        public h(String name, String iconUrl) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
            this.f126054a = name;
            this.f126055b = iconUrl;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            if (Intrinsics.areEqual(this.f126054a, hVar.f126054a) && Intrinsics.areEqual(this.f126055b, hVar.f126055b)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.f126054a.hashCode() * 31) + this.f126055b.hashCode();
        }

        public String toString() {
            return "CustomSubjectInfo(name=" + this.f126054a + ", iconUrl=" + this.f126055b + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.f126054a);
            parcel.writeString(this.f126055b);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public h(Parcel parcel) {
            this(r0, r2);
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            Intrinsics.checkNotNull(readString);
            String readString2 = parcel.readString();
            Intrinsics.checkNotNull(readString2);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum i {
        NORMAL,
        APP_BRAND
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum j {
        NORMAL,
        EMBED
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class k implements Parcelable {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f126064a;

        /* renamed from: b, reason: collision with root package name */
        public final String f126065b;

        /* renamed from: c, reason: collision with root package name */
        public static final b f126062c = new b(null);

        /* renamed from: d, reason: collision with root package name */
        public static final k f126063d = new k(false, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);

        @JvmField
        @NotNull
        public static final Parcelable.Creator<k> CREATOR = new a();

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public k createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new k(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public k[] newArray(int i3) {
                return new k[i3];
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class b {
            public b() {
            }

            public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public k(boolean z16, String token) {
            Intrinsics.checkNotNullParameter(token, "token");
            this.f126064a = z16;
            this.f126065b = token;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof k)) {
                return false;
            }
            k kVar = (k) obj;
            if (this.f126064a == kVar.f126064a && Intrinsics.areEqual(this.f126065b, kVar.f126065b)) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            boolean z16 = this.f126064a;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            return (r06 * 31) + this.f126065b.hashCode();
        }

        public String toString() {
            return "ShareActionConfig(showShare=" + this.f126064a + ", token=" + this.f126065b + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeByte(this.f126064a ? (byte) 1 : (byte) 0);
            parcel.writeString(this.f126065b);
        }

        public /* synthetic */ k(boolean z16, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? false : z16, (i3 & 2) != 0 ? "" : str);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public k(Parcel parcel) {
            this(r0, r2);
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            boolean z16 = parcel.readByte() != 0;
            String readString = parcel.readString();
            Intrinsics.checkNotNull(readString);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum l {
        NORMAL,
        FAKE_NATIVE
    }

    public x(boolean z16, int i3, a activityAnimStyle, boolean z17, b bgShapeConf, boolean z18, e closeWhenClickEmptyAreaConfig, d capsuleType, boolean z19, boolean z26, h0 h0Var, l splashLoadingType, boolean z27, boolean z28, r loadingDarkModeStyle, boolean z29, int i16, k shareActionConfig, int i17, int i18, int i19, boolean z36, boolean z37, boolean z38, j mode, boolean z39, h customSubjectInfo, int i26, boolean z46, String headerIndicatorColor, boolean z47, int i27, boolean z48, boolean z49, boolean z55, boolean z56, i embedHost, String headerTips, g0 g0Var, boolean z57, String externalWidgetClassName, String externalWidgetData) {
        Intrinsics.checkNotNullParameter(activityAnimStyle, "activityAnimStyle");
        Intrinsics.checkNotNullParameter(bgShapeConf, "bgShapeConf");
        Intrinsics.checkNotNullParameter(closeWhenClickEmptyAreaConfig, "closeWhenClickEmptyAreaConfig");
        Intrinsics.checkNotNullParameter(capsuleType, "capsuleType");
        Intrinsics.checkNotNullParameter(splashLoadingType, "splashLoadingType");
        Intrinsics.checkNotNullParameter(loadingDarkModeStyle, "loadingDarkModeStyle");
        Intrinsics.checkNotNullParameter(shareActionConfig, "shareActionConfig");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(customSubjectInfo, "customSubjectInfo");
        Intrinsics.checkNotNullParameter(headerIndicatorColor, "headerIndicatorColor");
        Intrinsics.checkNotNullParameter(embedHost, "embedHost");
        Intrinsics.checkNotNullParameter(headerTips, "headerTips");
        Intrinsics.checkNotNullParameter(externalWidgetClassName, "externalWidgetClassName");
        Intrinsics.checkNotNullParameter(externalWidgetData, "externalWidgetData");
        this.f125991a = i3;
        this.f125993b = activityAnimStyle;
        this.f125995c = z17;
        this.f125997d = bgShapeConf;
        this.f125999e = z18;
        this.f126001f = closeWhenClickEmptyAreaConfig;
        this.f126002g = capsuleType;
        this.f126003h = z19;
        this.f126004i = z26;
        this.f126005j = h0Var;
        this.f126006k = splashLoadingType;
        this.f126007l = z27;
        this.f126008m = z28;
        this.C = loadingDarkModeStyle;
        this.D = z29;
        this.E = i16;
        this.F = shareActionConfig;
        this.G = i17;
        int i28 = i18;
        this.H = i28;
        int i29 = i19;
        this.I = i29;
        this.J = z36;
        this.K = z37;
        this.L = z38;
        this.M = mode;
        this.N = z39;
        this.O = customSubjectInfo;
        this.P = i26;
        this.Q = z46;
        this.R = headerIndicatorColor;
        this.S = z47;
        this.T = i27;
        this.U = z48;
        this.V = z49;
        this.W = z55;
        this.X = z56;
        this.Y = embedHost;
        this.Z = headerTips;
        this.f125992a0 = g0Var;
        this.f125994b0 = z57;
        this.f125996c0 = externalWidgetClassName;
        this.f125998d0 = externalWidgetData;
        this.f126000e0 = z16;
        this.I = z39 ? -1 : i29;
        this.H = z39 ? -1 : i28;
    }

    public final boolean a() {
        if (this.f126000e0 && this.f125991a != 0) {
            return true;
        }
        return false;
    }

    public final boolean b() {
        if (this.f126002g == d.SINGLE_CLOSE) {
            return true;
        }
        return false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "HalfScreenConfig(height=" + this.f125991a + ", activityAnimStyle=" + this.f125993b + ", closeWhenClickEmptyArea=" + this.f125995c + ", bgShapeConf=" + this.f125997d + ", forceLightMode=" + this.f125999e + ", closeWhenClickEmptyAreaConfig=" + this.f126001f + ", capsuleType=" + this.f126002g + ", supportGesture=" + this.f126003h + ", showHalfScreenCommonHeader=" + this.f126004i + ", halfScreenStatusChangeListener=" + this.f126005j + ", splashLoadingType=" + this.f126006k + ", showHalfScreenCustomHeader=" + this.f126007l + ", forbidSlidingUpGesture=" + this.f126008m + ", loadingDarkModeStyle=" + this.C + ", showBgMask=" + this.D + ", shareActionConfig=" + this.F + ", autoFullScreenWhenTap=" + this.J + ", consumeNavigationBarHeight=" + this.L + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(a() ? 1 : 0);
        parcel.writeInt(this.f125991a);
        parcel.writeString(this.f125993b.name());
        parcel.writeByte(this.f125995c ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.f125997d, i3);
        parcel.writeByte(this.f125999e ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.f126001f, i3);
        parcel.writeString(this.f126002g.name());
        parcel.writeByte(this.f126003h ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f126004i ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.f126005j, i3);
        parcel.writeString(this.f126006k.name());
        parcel.writeByte(this.f126007l ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f126008m ? (byte) 1 : (byte) 0);
        parcel.writeString(this.C.name());
        parcel.writeByte(this.D ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.E);
        parcel.writeParcelable(this.F, i3);
        parcel.writeInt(this.G);
        parcel.writeInt(this.H);
        parcel.writeInt(this.I);
        parcel.writeByte(this.J ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.K ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.L ? (byte) 1 : (byte) 0);
        parcel.writeString(this.M.name());
        parcel.writeByte(this.N ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.O, i3);
        parcel.writeInt(this.P);
        parcel.writeByte(this.Q ? (byte) 1 : (byte) 0);
        parcel.writeString(this.R);
        parcel.writeByte(this.S ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.T);
        parcel.writeByte(this.U ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.V ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.W ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.X ? (byte) 1 : (byte) 0);
        parcel.writeString(this.Y.name());
        parcel.writeString(this.Z);
        parcel.writeParcelable(this.f125992a0, i3);
        parcel.writeByte(this.f125994b0 ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f125996c0);
        parcel.writeString(this.f125998d0);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements Parcelable {

        /* renamed from: a, reason: collision with root package name */
        public final float f126014a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f126015b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f126016c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f126017d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f126018e;

        /* renamed from: f, reason: collision with root package name */
        public static final C6212b f126012f = new C6212b(null);

        /* renamed from: g, reason: collision with root package name */
        public static final b f126013g = new b(0.0f, false, false, false, false, 31, null);

        @JvmField
        @NotNull
        public static final Parcelable.Creator<b> CREATOR = new a();

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public b createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new b(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public b[] newArray(int i3) {
                return new b[i3];
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.fd.x$b$b, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6212b {
            public C6212b() {
            }

            public /* synthetic */ C6212b(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public b(float f16, boolean z16, boolean z17, boolean z18, boolean z19) {
            this.f126014a = f16;
            this.f126015b = z16;
            this.f126016c = z17;
            this.f126017d = z18;
            this.f126018e = z19;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (Intrinsics.areEqual((Object) Float.valueOf(this.f126014a), (Object) Float.valueOf(bVar.f126014a)) && this.f126015b == bVar.f126015b && this.f126016c == bVar.f126016c && this.f126017d == bVar.f126017d && this.f126018e == bVar.f126018e) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int floatToIntBits = Float.floatToIntBits(this.f126014a) * 31;
            boolean z16 = this.f126015b;
            int i3 = 1;
            int i16 = z16;
            if (z16 != 0) {
                i16 = 1;
            }
            int i17 = (floatToIntBits + i16) * 31;
            boolean z17 = this.f126016c;
            int i18 = z17;
            if (z17 != 0) {
                i18 = 1;
            }
            int i19 = (i17 + i18) * 31;
            boolean z18 = this.f126017d;
            int i26 = z18;
            if (z18 != 0) {
                i26 = 1;
            }
            int i27 = (i19 + i26) * 31;
            boolean z19 = this.f126018e;
            if (!z19) {
                i3 = z19 ? 1 : 0;
            }
            return i27 + i3;
        }

        public String toString() {
            return "BackgroundShapeConfig(cornerRadius=" + this.f126014a + ", topLeft=" + this.f126015b + ", topRight=" + this.f126016c + ", bottomLeft=" + this.f126017d + ", bottomRight=" + this.f126018e + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeFloat(this.f126014a);
            parcel.writeByte(this.f126015b ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.f126016c ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.f126017d ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.f126018e ? (byte) 1 : (byte) 0);
        }

        public /* synthetic */ b(float f16, boolean z16, boolean z17, boolean z18, boolean z19, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? 0.0f : f16, (i3 & 2) != 0 ? false : z16, (i3 & 4) != 0 ? false : z17, (i3 & 8) != 0 ? false : z18, (i3 & 16) == 0 ? z19 : false);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public b(Parcel parcel) {
            this(parcel.readFloat(), parcel.readByte() != 0, parcel.readByte() != 0, parcel.readByte() != 0, parcel.readByte() != 0);
            Intrinsics.checkNotNullParameter(parcel, "parcel");
        }
    }

    public /* synthetic */ x(boolean z16, int i3, a aVar, boolean z17, b bVar, boolean z18, e eVar, d dVar, boolean z19, boolean z26, h0 h0Var, l lVar, boolean z27, boolean z28, r rVar, boolean z29, int i16, k kVar, int i17, int i18, int i19, boolean z36, boolean z37, boolean z38, j jVar, boolean z39, h hVar, int i26, boolean z46, String str, boolean z47, int i27, boolean z48, boolean z49, boolean z55, boolean z56, i iVar, String str2, g0 g0Var, boolean z57, String str3, String str4, int i28, int i29, DefaultConstructorMarker defaultConstructorMarker) {
        this(z16, (i28 & 2) != 0 ? -1 : i3, (i28 & 4) != 0 ? a.POPUP : aVar, (i28 & 8) != 0 ? false : z17, (i28 & 16) != 0 ? b.f126013g : bVar, (i28 & 32) != 0 ? false : z18, (i28 & 64) != 0 ? e.f126050d : eVar, (i28 & 128) != 0 ? d.NORMAL : dVar, (i28 & 256) != 0 ? false : z19, (i28 & 512) != 0 ? false : z26, (i28 & 1024) != 0 ? null : h0Var, (i28 & 2048) != 0 ? l.FAKE_NATIVE : lVar, (i28 & 4096) != 0 ? false : z27, (i28 & 8192) != 0 ? false : z28, (i28 & 16384) != 0 ? r.NORMAL : rVar, (i28 & 32768) != 0 ? false : z29, (i28 & 65536) != 0 ? f125990h0 : i16, (i28 & 131072) != 0 ? k.f126063d : kVar, (i28 & 262144) != 0 ? -1 : i17, (i28 & 524288) != 0 ? -2 : i18, (i28 & 1048576) == 0 ? i19 : -2, (i28 & 2097152) != 0 ? true : z36, (i28 & 4194304) != 0 ? true : z37, (i28 & 8388608) != 0 ? true : z38, (i28 & 16777216) != 0 ? j.NORMAL : jVar, (i28 & 33554432) != 0 ? false : z39, (i28 & 67108864) != 0 ? h.f126053c : hVar, (i28 & 134217728) != 0 ? -1 : i26, (i28 & 268435456) != 0 ? false : z46, (i28 & 536870912) != 0 ? "#FFFFFF" : str, (i28 & 1073741824) != 0 ? false : z47, (i28 & Integer.MIN_VALUE) != 0 ? -1 : i27, (i29 & 1) == 0 ? z48 : true, (i29 & 2) != 0 ? false : z49, (i29 & 4) != 0 ? false : z55, (i29 & 8) != 0 ? false : z56, (i29 & 16) != 0 ? i.APP_BRAND : iVar, (i29 & 32) != 0 ? "" : str2, (i29 & 64) != 0 ? null : g0Var, (i29 & 128) != 0 ? false : z57, (i29 & 256) != 0 ? "" : str3, (i29 & 512) == 0 ? str4 : "");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public x(Parcel parcel) {
        this(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r1, r0);
        r valueOf;
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        boolean z16 = parcel.readInt() > 0;
        int readInt = parcel.readInt();
        String readString = parcel.readString();
        Intrinsics.checkNotNull(readString);
        a valueOf2 = a.valueOf(readString);
        boolean z17 = parcel.readByte() != 0;
        Parcelable readParcelable = parcel.readParcelable(b.class.getClassLoader());
        Intrinsics.checkNotNull(readParcelable);
        b bVar = (b) readParcelable;
        boolean z18 = parcel.readByte() != 0;
        Parcelable readParcelable2 = parcel.readParcelable(e.class.getClassLoader());
        Intrinsics.checkNotNull(readParcelable2);
        e eVar = (e) readParcelable2;
        String readString2 = parcel.readString();
        Intrinsics.checkNotNull(readString2);
        d valueOf3 = d.valueOf(readString2);
        boolean z19 = parcel.readByte() != 0;
        boolean z26 = parcel.readByte() != 0;
        h0 h0Var = (h0) parcel.readParcelable(h0.class.getClassLoader());
        String readString3 = parcel.readString();
        Intrinsics.checkNotNull(readString3);
        l valueOf4 = l.valueOf(readString3);
        boolean z27 = parcel.readByte() != 0;
        boolean z28 = parcel.readByte() != 0;
        String readString4 = parcel.readString();
        if (TextUtils.isEmpty(readString4)) {
            valueOf = r.NORMAL;
        } else {
            Intrinsics.checkNotNull(readString4);
            valueOf = r.valueOf(readString4);
        }
        r rVar = valueOf;
        boolean z29 = parcel.readByte() != 0;
        int readInt2 = parcel.readInt();
        Parcelable readParcelable3 = parcel.readParcelable(k.class.getClassLoader());
        Intrinsics.checkNotNull(readParcelable3);
        k kVar = (k) readParcelable3;
        int readInt3 = parcel.readInt();
        int readInt4 = parcel.readInt();
        int readInt5 = parcel.readInt();
        boolean z36 = parcel.readByte() != 0;
        boolean z37 = parcel.readByte() != 0;
        boolean z38 = parcel.readByte() != 0;
        String readString5 = parcel.readString();
        Intrinsics.checkNotNull(readString5);
        j valueOf5 = j.valueOf(readString5);
        boolean z39 = parcel.readByte() != 0;
        Parcelable readParcelable4 = parcel.readParcelable(h.class.getClassLoader());
        Intrinsics.checkNotNull(readParcelable4);
        h hVar = (h) readParcelable4;
        int readInt6 = parcel.readInt();
        boolean z46 = parcel.readByte() != 0;
        String readString6 = parcel.readString();
        Intrinsics.checkNotNull(readString6);
        boolean z47 = parcel.readByte() != 0;
        int readInt7 = parcel.readInt();
        boolean z48 = parcel.readByte() != 0;
        boolean z49 = parcel.readByte() != 0;
        boolean z55 = parcel.readByte() != 0;
        boolean z56 = parcel.readByte() != 0;
        String readString7 = parcel.readString();
        Intrinsics.checkNotNull(readString7);
        i valueOf6 = i.valueOf(readString7);
        String readString8 = parcel.readString();
        Intrinsics.checkNotNull(readString8);
        g0 g0Var = (g0) parcel.readParcelable(g0.class.getClassLoader());
        boolean z57 = parcel.readByte() != 0;
        String readString9 = parcel.readString();
        Intrinsics.checkNotNull(readString9);
        String readString10 = parcel.readString();
        Intrinsics.checkNotNull(readString10);
    }
}
