package com.tencent.tmsqmsp.oaid2;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes26.dex */
public abstract class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final d f380778a;

    /* renamed from: b, reason: collision with root package name */
    public static final d f380779b;

    /* renamed from: c, reason: collision with root package name */
    public static final d f380780c;

    /* renamed from: d, reason: collision with root package name */
    public static final d f380781d;

    /* renamed from: e, reason: collision with root package name */
    public static final d f380782e;

    /* renamed from: f, reason: collision with root package name */
    public static final d f380783f;

    /* renamed from: g, reason: collision with root package name */
    public static final d f380784g;

    /* renamed from: h, reason: collision with root package name */
    public static final d f380785h;

    /* renamed from: i, reason: collision with root package name */
    public static final d f380786i;

    /* renamed from: j, reason: collision with root package name */
    public static final d f380787j;

    /* renamed from: k, reason: collision with root package name */
    public static final d f380788k;

    /* renamed from: l, reason: collision with root package name */
    public static final d f380789l;

    /* renamed from: m, reason: collision with root package name */
    public static final String f380790m;

    /* renamed from: n, reason: collision with root package name */
    public static final String f380791n;

    /* renamed from: o, reason: collision with root package name */
    public static final int f380792o;

    /* renamed from: p, reason: collision with root package name */
    private static final /* synthetic */ d[] f380793p;

    /* compiled from: P */
    /* renamed from: com.tencent.tmsqmsp.oaid2.d$d, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    enum C10008d extends d {
        static IPatchRedirector $redirector_;

        C10008d(String str) {
            super(str, 0, -1, null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            }
        }

        @Override // com.tencent.tmsqmsp.oaid2.d
        public final boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            if (TextUtils.isEmpty(d.f380791n) && TextUtils.isEmpty(d.f380790m)) {
                return true;
            }
            return false;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63280);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        C10008d c10008d = new C10008d("UNSUPPORTED");
        f380778a = c10008d;
        d dVar = new d("XM_TYPE") { // from class: com.tencent.tmsqmsp.oaid2.d.e
            static IPatchRedirector $redirector_;

            {
                super(r4, 1, 0, null);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) r4);
                }
            }

            @Override // com.tencent.tmsqmsp.oaid2.d
            public final boolean a() {
                boolean z16;
                boolean z17;
                boolean z18;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
                }
                String str = d.f380791n;
                if (!str.equalsIgnoreCase("XIAOMI") && !d.f380790m.equalsIgnoreCase("XIAOMI")) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!str.equalsIgnoreCase("REDMI") && !d.f380790m.equalsIgnoreCase("REDMI")) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                if (!str.equalsIgnoreCase("BLACKSHARK") && !d.f380790m.equalsIgnoreCase("BLACKSHARK")) {
                    z18 = false;
                } else {
                    z18 = true;
                }
                boolean equalsIgnoreCase = str.equalsIgnoreCase("MEITU");
                boolean z19 = !TextUtils.isEmpty(com.tencent.tmsqmsp.oaid2.e.a("ro.miui.ui.version.name"));
                if (!z16 && !z17 && !z18 && !equalsIgnoreCase && !z19) {
                    return false;
                }
                return true;
            }
        };
        f380779b = dVar;
        d dVar2 = new d("VV_TYPE") { // from class: com.tencent.tmsqmsp.oaid2.d.f
            static IPatchRedirector $redirector_;

            {
                super(r4, 2, 1, null);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) r4);
                }
            }

            @Override // com.tencent.tmsqmsp.oaid2.d
            public final boolean a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
                }
                if (!d.f380791n.equalsIgnoreCase("VIVO") && !d.f380790m.equalsIgnoreCase("VIVO") && TextUtils.isEmpty(com.tencent.tmsqmsp.oaid2.e.a("ro.vivo.os.version"))) {
                    return false;
                }
                return true;
            }
        };
        f380780c = dVar2;
        d dVar3 = new d("HW_TYPE") { // from class: com.tencent.tmsqmsp.oaid2.d.g
            static IPatchRedirector $redirector_;

            {
                super(r4, 3, 2, null);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) r4);
                }
            }

            @Override // com.tencent.tmsqmsp.oaid2.d
            public final boolean a() {
                boolean z16;
                boolean z17;
                boolean z18;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
                }
                String str = d.f380791n;
                if (!str.equalsIgnoreCase("HUAWEI") && !d.f380790m.equalsIgnoreCase("HUAWEI")) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!str.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HONOR) && !d.f380790m.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HONOR)) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                if (d.f380792o < 31) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                boolean z19 = !TextUtils.isEmpty(com.tencent.tmsqmsp.oaid2.e.a("ro.build.version.emui"));
                if (z16 || (z17 && z18)) {
                    return true;
                }
                if (!z19 || z17) {
                    return false;
                }
                return true;
            }
        };
        f380781d = dVar3;
        d dVar4 = new d("OP_TYPE") { // from class: com.tencent.tmsqmsp.oaid2.d.h
            static IPatchRedirector $redirector_;

            {
                super(r4, 4, 3, null);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) r4);
                }
            }

            @Override // com.tencent.tmsqmsp.oaid2.d
            public final boolean a() {
                boolean z16;
                boolean z17;
                boolean z18;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
                }
                String str = d.f380791n;
                if (!str.equalsIgnoreCase("OPPO") && !d.f380790m.equalsIgnoreCase("OPPO") && TextUtils.isEmpty(com.tencent.tmsqmsp.oaid2.e.a("ro.build.version.opporom"))) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!str.equalsIgnoreCase("REALME") && !d.f380790m.equalsIgnoreCase("REALME")) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                if (!str.equalsIgnoreCase("ONEPLUS") && !d.f380790m.equalsIgnoreCase("ONEPLUS")) {
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
        f380782e = dVar4;
        d dVar5 = new d("LX_TYPE") { // from class: com.tencent.tmsqmsp.oaid2.d.i
            static IPatchRedirector $redirector_;

            {
                super(r4, 5, 4, null);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) r4);
                }
            }

            @Override // com.tencent.tmsqmsp.oaid2.d
            public final boolean a() {
                boolean z16;
                boolean z17;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
                }
                String str = d.f380791n;
                if (!str.equalsIgnoreCase("LENOVO")) {
                    String str2 = d.f380790m;
                    if (!str2.equalsIgnoreCase("LENOVO") && !str2.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_ZUK)) {
                        z16 = false;
                        if (str.equalsIgnoreCase("MOTOROLA") && !d.f380790m.equalsIgnoreCase("MOTOROLA")) {
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
        f380783f = dVar5;
        d dVar6 = new d("HS_TYPE") { // from class: com.tencent.tmsqmsp.oaid2.d.j
            static IPatchRedirector $redirector_;

            {
                super(r4, 6, 5, null);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) r4);
                }
            }

            @Override // com.tencent.tmsqmsp.oaid2.d
            public final boolean a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
                }
                if (!d.f380791n.equalsIgnoreCase("ASUS") && !d.f380790m.equalsIgnoreCase("ASUS")) {
                    return false;
                }
                return true;
            }
        };
        f380784g = dVar6;
        d dVar7 = new d("SX_TYPE") { // from class: com.tencent.tmsqmsp.oaid2.d.k
            static IPatchRedirector $redirector_;

            {
                super(r4, 7, 6, null);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) r4);
                }
            }

            @Override // com.tencent.tmsqmsp.oaid2.d
            public final boolean a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
                }
                if (!d.f380791n.equalsIgnoreCase("SAMSUNG") && !d.f380790m.equalsIgnoreCase("SAMSUNG")) {
                    return false;
                }
                return true;
            }
        };
        f380785h = dVar7;
        d dVar8 = new d("MZ_TYPE") { // from class: com.tencent.tmsqmsp.oaid2.d.l
            static IPatchRedirector $redirector_;

            {
                super(r4, 8, 7, null);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) r4);
                }
            }

            @Override // com.tencent.tmsqmsp.oaid2.d
            public final boolean a() {
                boolean z16;
                boolean z17;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
                }
                String str = d.f380791n;
                if (!str.equalsIgnoreCase("MEIZU") && !d.f380790m.equalsIgnoreCase("MEIZU") && !Build.DISPLAY.toUpperCase().contains("FLYME")) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!str.equalsIgnoreCase("ALPS") && !d.f380790m.equalsIgnoreCase("ALPS")) {
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
        f380786i = dVar8;
        d dVar9 = new d("NB_TYPE") { // from class: com.tencent.tmsqmsp.oaid2.d.a
            static IPatchRedirector $redirector_;

            {
                super(r4, 9, 8, null);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) r4);
                }
            }

            @Override // com.tencent.tmsqmsp.oaid2.d
            public final boolean a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
                }
                if (!d.f380791n.equalsIgnoreCase("NUBIA") && !d.f380790m.equalsIgnoreCase("NUBIA")) {
                    return false;
                }
                return true;
            }
        };
        f380787j = dVar9;
        d dVar10 = new d("MSA_TYPE") { // from class: com.tencent.tmsqmsp.oaid2.d.b
            static IPatchRedirector $redirector_;

            {
                super(r4, 10, 9, null);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) r4);
                }
            }

            @Override // com.tencent.tmsqmsp.oaid2.d
            public final boolean a() {
                boolean z16;
                boolean z17;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
                }
                String str = d.f380791n;
                if (!str.equalsIgnoreCase("ZTE") && !d.f380790m.equalsIgnoreCase("ZTE")) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (TextUtils.isEmpty(com.tencent.tmsqmsp.oaid2.e.a("ro.build.freeme.label")) && !str.equalsIgnoreCase("freemeos")) {
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
        f380788k = dVar10;
        d dVar11 = new d("HONOR_TYPE") { // from class: com.tencent.tmsqmsp.oaid2.d.c
            static IPatchRedirector $redirector_;

            {
                super(r4, 11, 10, null);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) r4);
                }
            }

            @Override // com.tencent.tmsqmsp.oaid2.d
            public final boolean a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
                }
                if (d.f380792o >= 31) {
                    if (d.f380791n.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HONOR) || d.f380790m.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HONOR)) {
                        return true;
                    }
                    return false;
                }
                return false;
            }
        };
        f380789l = dVar11;
        f380793p = new d[]{c10008d, dVar, dVar2, dVar3, dVar4, dVar5, dVar6, dVar7, dVar8, dVar9, dVar10, dVar11};
        f380790m = Build.BRAND;
        f380791n = Build.MANUFACTURER;
        f380792o = Build.VERSION.SDK_INT;
    }

    /* synthetic */ d(String str, int i3, int i16, C10008d c10008d) {
        this(str, i3, i16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), Integer.valueOf(i16), c10008d);
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
        return f380778a;
    }

    public static d[] c() {
        return (d[]) f380793p.clone();
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
