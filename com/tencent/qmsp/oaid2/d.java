package com.tencent.qmsp.oaid2;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes22.dex */
public abstract class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final d f344188a;

    /* renamed from: b, reason: collision with root package name */
    public static final d f344189b;

    /* renamed from: c, reason: collision with root package name */
    public static final d f344190c;

    /* renamed from: d, reason: collision with root package name */
    public static final d f344191d;

    /* renamed from: e, reason: collision with root package name */
    public static final d f344192e;

    /* renamed from: f, reason: collision with root package name */
    public static final d f344193f;

    /* renamed from: g, reason: collision with root package name */
    public static final d f344194g;

    /* renamed from: h, reason: collision with root package name */
    public static final d f344195h;

    /* renamed from: i, reason: collision with root package name */
    public static final d f344196i;

    /* renamed from: j, reason: collision with root package name */
    public static final d f344197j;

    /* renamed from: k, reason: collision with root package name */
    public static final d f344198k;

    /* renamed from: l, reason: collision with root package name */
    public static final d f344199l;

    /* renamed from: m, reason: collision with root package name */
    public static final String f344200m;

    /* renamed from: n, reason: collision with root package name */
    public static final String f344201n;

    /* renamed from: o, reason: collision with root package name */
    public static final int f344202o;

    /* renamed from: p, reason: collision with root package name */
    private static final /* synthetic */ d[] f344203p;

    /* compiled from: P */
    /* renamed from: com.tencent.qmsp.oaid2.d$d, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    enum C9339d extends d {
        static IPatchRedirector $redirector_;

        C9339d(String str, int i3, int i16) {
            super(str, i3, i16, null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            }
        }

        @Override // com.tencent.qmsp.oaid2.d
        public boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            if (TextUtils.isEmpty(d.f344201n) && TextUtils.isEmpty(d.f344200m)) {
                return true;
            }
            return false;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14937);
        $redirector_ = redirector;
        int i3 = 3;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        C9339d c9339d = new C9339d("UNSUPPORTED", 0, -1);
        f344188a = c9339d;
        int i16 = 1;
        d dVar = new d("XM_TYPE", i16, 0) { // from class: com.tencent.qmsp.oaid2.d.e
            static IPatchRedirector $redirector_;

            {
                super(r5, i16, r7, null);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, r5, Integer.valueOf(i16), Integer.valueOf(r7));
                }
            }

            @Override // com.tencent.qmsp.oaid2.d
            public boolean a() {
                boolean z16;
                boolean z17;
                boolean z18;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
                }
                String str = d.f344201n;
                if (!str.equalsIgnoreCase("XIAOMI") && !d.f344200m.equalsIgnoreCase("XIAOMI")) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!str.equalsIgnoreCase("REDMI") && !d.f344200m.equalsIgnoreCase("REDMI")) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                if (!str.equalsIgnoreCase("BLACKSHARK") && !d.f344200m.equalsIgnoreCase("BLACKSHARK")) {
                    z18 = false;
                } else {
                    z18 = true;
                }
                boolean equalsIgnoreCase = str.equalsIgnoreCase("MEITU");
                boolean z19 = !TextUtils.isEmpty(com.tencent.qmsp.oaid2.e.a("ro.miui.ui.version.name"));
                if (!z16 && !z17 && !z18 && !equalsIgnoreCase && !z19) {
                    return false;
                }
                return true;
            }
        };
        f344189b = dVar;
        int i17 = 2;
        d dVar2 = new d("VV_TYPE", i17, i16) { // from class: com.tencent.qmsp.oaid2.d.f
            static IPatchRedirector $redirector_;

            {
                super(r5, i17, i16, null);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, r5, Integer.valueOf(i17), Integer.valueOf(i16));
                }
            }

            @Override // com.tencent.qmsp.oaid2.d
            public boolean a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
                }
                if (!d.f344201n.equalsIgnoreCase("VIVO") && !d.f344200m.equalsIgnoreCase("VIVO") && TextUtils.isEmpty(com.tencent.qmsp.oaid2.e.a("ro.vivo.os.version"))) {
                    return false;
                }
                return true;
            }
        };
        f344190c = dVar2;
        d dVar3 = new d("HW_TYPE", i3, i17) { // from class: com.tencent.qmsp.oaid2.d.g
            static IPatchRedirector $redirector_;

            {
                super(r5, i3, i17, null);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, r5, Integer.valueOf(i3), Integer.valueOf(i17));
                }
            }

            @Override // com.tencent.qmsp.oaid2.d
            public boolean a() {
                boolean z16;
                boolean z17;
                boolean z18;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
                }
                String str = d.f344201n;
                if (!str.equalsIgnoreCase("HUAWEI") && !d.f344200m.equalsIgnoreCase("HUAWEI")) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!str.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HONOR) && !d.f344200m.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HONOR)) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                if (d.f344202o < 31) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                boolean z19 = !TextUtils.isEmpty(com.tencent.qmsp.oaid2.e.a("ro.build.version.emui"));
                if (z16 || (z17 && z18)) {
                    return true;
                }
                if (!z19 || z17) {
                    return false;
                }
                return true;
            }
        };
        f344191d = dVar3;
        int i18 = 4;
        d dVar4 = new d("OP_TYPE", i18, i3) { // from class: com.tencent.qmsp.oaid2.d.h
            static IPatchRedirector $redirector_;

            {
                super(r5, i18, i3, null);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, r5, Integer.valueOf(i18), Integer.valueOf(i3));
                }
            }

            @Override // com.tencent.qmsp.oaid2.d
            public boolean a() {
                boolean z16;
                boolean z17;
                boolean z18;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
                }
                String str = d.f344201n;
                if (!str.equalsIgnoreCase("OPPO") && !d.f344200m.equalsIgnoreCase("OPPO") && TextUtils.isEmpty(com.tencent.qmsp.oaid2.e.a("ro.build.version.opporom"))) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!str.equalsIgnoreCase("REALME") && !d.f344200m.equalsIgnoreCase("REALME")) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                if (!str.equalsIgnoreCase("ONEPLUS") && !d.f344200m.equalsIgnoreCase("ONEPLUS")) {
                    z18 = false;
                } else {
                    z18 = true;
                }
                if (!z16 && !z17 && !z18) {
                    return false;
                }
                return true;
            }
        };
        f344192e = dVar4;
        int i19 = 5;
        d dVar5 = new d("LX_TYPE", i19, i18) { // from class: com.tencent.qmsp.oaid2.d.i
            static IPatchRedirector $redirector_;

            {
                super(r5, i19, i18, null);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, r5, Integer.valueOf(i19), Integer.valueOf(i18));
                }
            }

            @Override // com.tencent.qmsp.oaid2.d
            public boolean a() {
                boolean z16;
                boolean z17;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
                }
                String str = d.f344201n;
                if (!str.equalsIgnoreCase("LENOVO")) {
                    String str2 = d.f344200m;
                    if (!str2.equalsIgnoreCase("LENOVO") && !str2.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_ZUK)) {
                        z16 = false;
                        if (str.equalsIgnoreCase("MOTOROLA") && !d.f344200m.equalsIgnoreCase("MOTOROLA")) {
                            z17 = false;
                        } else {
                            z17 = true;
                        }
                        if (z16 && !z17) {
                            return false;
                        }
                        return true;
                    }
                }
                z16 = true;
                if (str.equalsIgnoreCase("MOTOROLA")) {
                }
                z17 = true;
                if (z16) {
                }
                return true;
            }
        };
        f344193f = dVar5;
        int i26 = 6;
        d dVar6 = new d("HS_TYPE", i26, i19) { // from class: com.tencent.qmsp.oaid2.d.j
            static IPatchRedirector $redirector_;

            {
                super(r5, i26, i19, null);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, r5, Integer.valueOf(i26), Integer.valueOf(i19));
                }
            }

            @Override // com.tencent.qmsp.oaid2.d
            public boolean a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
                }
                if (!d.f344201n.equalsIgnoreCase("ASUS") && !d.f344200m.equalsIgnoreCase("ASUS")) {
                    return false;
                }
                return true;
            }
        };
        f344194g = dVar6;
        int i27 = 7;
        d dVar7 = new d("SX_TYPE", i27, i26) { // from class: com.tencent.qmsp.oaid2.d.k
            static IPatchRedirector $redirector_;

            {
                super(r5, i27, i26, null);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, r5, Integer.valueOf(i27), Integer.valueOf(i26));
                }
            }

            @Override // com.tencent.qmsp.oaid2.d
            public boolean a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
                }
                if (!d.f344201n.equalsIgnoreCase("SAMSUNG") && !d.f344200m.equalsIgnoreCase("SAMSUNG")) {
                    return false;
                }
                return true;
            }
        };
        f344195h = dVar7;
        int i28 = 8;
        d dVar8 = new d("MZ_TYPE", i28, i27) { // from class: com.tencent.qmsp.oaid2.d.l
            static IPatchRedirector $redirector_;

            {
                super(r5, i28, i27, null);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, r5, Integer.valueOf(i28), Integer.valueOf(i27));
                }
            }

            @Override // com.tencent.qmsp.oaid2.d
            public boolean a() {
                boolean z16;
                boolean z17;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
                }
                String str = d.f344201n;
                if (!str.equalsIgnoreCase("MEIZU") && !d.f344200m.equalsIgnoreCase("MEIZU") && !Build.DISPLAY.toUpperCase().contains("FLYME")) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!str.equalsIgnoreCase("ALPS") && !d.f344200m.equalsIgnoreCase("ALPS")) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                if (!z16 && !z17) {
                    return false;
                }
                return true;
            }
        };
        f344196i = dVar8;
        int i29 = 9;
        d dVar9 = new d("NB_TYPE", i29, i28) { // from class: com.tencent.qmsp.oaid2.d.a
            static IPatchRedirector $redirector_;

            {
                super(r5, i29, i28, null);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, r5, Integer.valueOf(i29), Integer.valueOf(i28));
                }
            }

            @Override // com.tencent.qmsp.oaid2.d
            public boolean a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
                }
                if (!d.f344201n.equalsIgnoreCase("NUBIA") && !d.f344200m.equalsIgnoreCase("NUBIA")) {
                    return false;
                }
                return true;
            }
        };
        f344197j = dVar9;
        int i36 = 10;
        d dVar10 = new d("MSA_TYPE", i36, i29) { // from class: com.tencent.qmsp.oaid2.d.b
            static IPatchRedirector $redirector_;

            {
                super(r5, i36, i29, null);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, r5, Integer.valueOf(i36), Integer.valueOf(i29));
                }
            }

            @Override // com.tencent.qmsp.oaid2.d
            public boolean a() {
                boolean z16;
                boolean z17;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
                }
                String str = d.f344201n;
                if (!str.equalsIgnoreCase("ZTE") && !d.f344200m.equalsIgnoreCase("ZTE")) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (TextUtils.isEmpty(com.tencent.qmsp.oaid2.e.a("ro.build.freeme.label")) && !str.equalsIgnoreCase("freemeos")) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                boolean equalsIgnoreCase = str.equalsIgnoreCase("SSUI");
                if (!z16 && !z17 && !equalsIgnoreCase) {
                    return false;
                }
                return true;
            }
        };
        f344198k = dVar10;
        d dVar11 = new d("HONOR_TYPE", 11, i36) { // from class: com.tencent.qmsp.oaid2.d.c
            static IPatchRedirector $redirector_;

            {
                super(r5, r6, i36, null);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, r5, Integer.valueOf(r6), Integer.valueOf(i36));
                }
            }

            @Override // com.tencent.qmsp.oaid2.d
            public boolean a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
                }
                if (d.f344202o >= 31 && (d.f344201n.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HONOR) || d.f344200m.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HONOR))) {
                    return true;
                }
                return false;
            }
        };
        f344199l = dVar11;
        f344203p = new d[]{c9339d, dVar, dVar2, dVar3, dVar4, dVar5, dVar6, dVar7, dVar8, dVar9, dVar10, dVar11};
        f344200m = Build.BRAND;
        f344201n = Build.MANUFACTURER;
        f344202o = Build.VERSION.SDK_INT;
    }

    /* synthetic */ d(String str, int i3, int i16, C9339d c9339d) {
        this(str, i3, i16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), Integer.valueOf(i16), c9339d);
    }

    public static boolean a(Context context) {
        try {
            InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), "com.coolpad.deviceidsupport", 0);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static d b() {
        for (d dVar : c()) {
            if (dVar.a()) {
                return dVar;
            }
        }
        return f344188a;
    }

    public static d[] c() {
        return (d[]) f344203p.clone();
    }

    public abstract boolean a();

    d(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
    }
}
