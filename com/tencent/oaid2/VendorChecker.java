package com.tencent.oaid2;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qimei.a.c;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes22.dex */
public abstract class VendorChecker {
    static IPatchRedirector $redirector_;
    public static final String BRAND;
    public static final VendorChecker HONOR_TYPE;
    public static final VendorChecker HS_TYPE;
    public static final VendorChecker HW_TYPE;
    public static final VendorChecker LX_TYPE;
    public static final String MANUFACTURER;
    public static final VendorChecker MSA_TYPE;
    public static final VendorChecker MZ_TYPE;
    public static final VendorChecker NB_TYPE;
    public static final VendorChecker OP_TYPE;
    public static final int OS_VERSION;
    public static final VendorChecker SX_TYPE;
    public static final VendorChecker UNSUPPORTED;
    public static final VendorChecker VV_TYPE;
    public static final VendorChecker XM_TYPE;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VendorChecker[] f339474a;
    public final int index;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16896);
        $redirector_ = redirector;
        int i3 = 3;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        int i16 = 0;
        VendorChecker vendorChecker = new VendorChecker("UNSUPPORTED", i16, -1) { // from class: com.tencent.oaid2.VendorChecker.1
            static IPatchRedirector $redirector_;

            {
                super(r5, i16, r7, null);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, r5, Integer.valueOf(i16), Integer.valueOf(r7));
                }
            }

            @Override // com.tencent.oaid2.VendorChecker
            public boolean a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
                }
                if (TextUtils.isEmpty(VendorChecker.MANUFACTURER) && TextUtils.isEmpty(VendorChecker.BRAND)) {
                    return true;
                }
                return false;
            }
        };
        UNSUPPORTED = vendorChecker;
        int i17 = 1;
        VendorChecker vendorChecker2 = new VendorChecker("XM_TYPE", i17, i16) { // from class: com.tencent.oaid2.VendorChecker.2
            static IPatchRedirector $redirector_;

            {
                super(r5, i17, i16, null);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, r5, Integer.valueOf(i17), Integer.valueOf(i16));
                }
            }

            @Override // com.tencent.oaid2.VendorChecker
            public boolean a() {
                boolean z16;
                boolean z17;
                boolean z18;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
                }
                String str = VendorChecker.MANUFACTURER;
                if (!str.equalsIgnoreCase("XIAOMI") && !VendorChecker.BRAND.equalsIgnoreCase("XIAOMI")) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!str.equalsIgnoreCase("REDMI") && !VendorChecker.BRAND.equalsIgnoreCase("REDMI")) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                if (!str.equalsIgnoreCase("BLACKSHARK") && !VendorChecker.BRAND.equalsIgnoreCase("BLACKSHARK")) {
                    z18 = false;
                } else {
                    z18 = true;
                }
                boolean equalsIgnoreCase = str.equalsIgnoreCase("MEITU");
                boolean z19 = !TextUtils.isEmpty(c.a("ro.miui.ui.version.name"));
                if (!z16 && !z17 && !z18 && !equalsIgnoreCase && !z19) {
                    return false;
                }
                return true;
            }
        };
        XM_TYPE = vendorChecker2;
        int i18 = 2;
        VendorChecker vendorChecker3 = new VendorChecker("VV_TYPE", i18, i17) { // from class: com.tencent.oaid2.VendorChecker.3
            static IPatchRedirector $redirector_;

            {
                super(r5, i18, i17, null);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, r5, Integer.valueOf(i18), Integer.valueOf(i17));
                }
            }

            @Override // com.tencent.oaid2.VendorChecker
            public boolean a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
                }
                if (!VendorChecker.MANUFACTURER.equalsIgnoreCase("VIVO") && !VendorChecker.BRAND.equalsIgnoreCase("VIVO") && TextUtils.isEmpty(c.a("ro.vivo.os.version"))) {
                    return false;
                }
                return true;
            }
        };
        VV_TYPE = vendorChecker3;
        VendorChecker vendorChecker4 = new VendorChecker("HW_TYPE", i3, i18) { // from class: com.tencent.oaid2.VendorChecker.4
            static IPatchRedirector $redirector_;

            {
                super(r5, i3, i18, null);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, r5, Integer.valueOf(i3), Integer.valueOf(i18));
                }
            }

            @Override // com.tencent.oaid2.VendorChecker
            public boolean a() {
                boolean z16;
                boolean z17;
                boolean z18;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
                }
                String str = VendorChecker.MANUFACTURER;
                if (!str.equalsIgnoreCase("HUAWEI") && !VendorChecker.BRAND.equalsIgnoreCase("HUAWEI")) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!str.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HONOR) && !VendorChecker.BRAND.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HONOR)) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                if (VendorChecker.OS_VERSION < 31) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                boolean z19 = !TextUtils.isEmpty(c.a("ro.build.version.emui"));
                if (z16 || (z17 && z18)) {
                    return true;
                }
                if (!z19 || z17) {
                    return false;
                }
                return true;
            }
        };
        HW_TYPE = vendorChecker4;
        int i19 = 4;
        VendorChecker vendorChecker5 = new VendorChecker("OP_TYPE", i19, i3) { // from class: com.tencent.oaid2.VendorChecker.5
            static IPatchRedirector $redirector_;

            {
                super(r5, i19, i3, null);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, r5, Integer.valueOf(i19), Integer.valueOf(i3));
                }
            }

            @Override // com.tencent.oaid2.VendorChecker
            public boolean a() {
                boolean z16;
                boolean z17;
                boolean z18;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
                }
                String str = VendorChecker.MANUFACTURER;
                if (!str.equalsIgnoreCase("OPPO") && !VendorChecker.BRAND.equalsIgnoreCase("OPPO") && TextUtils.isEmpty(c.a("ro.build.version.opporom"))) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!str.equalsIgnoreCase("REALME") && !VendorChecker.BRAND.equalsIgnoreCase("REALME")) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                if (!str.equalsIgnoreCase("ONEPLUS") && !VendorChecker.BRAND.equalsIgnoreCase("ONEPLUS")) {
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
        OP_TYPE = vendorChecker5;
        int i26 = 5;
        VendorChecker vendorChecker6 = new VendorChecker("LX_TYPE", i26, i19) { // from class: com.tencent.oaid2.VendorChecker.6
            static IPatchRedirector $redirector_;

            {
                super(r5, i26, i19, null);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, r5, Integer.valueOf(i26), Integer.valueOf(i19));
                }
            }

            @Override // com.tencent.oaid2.VendorChecker
            public boolean a() {
                boolean z16;
                boolean z17;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
                }
                String str = VendorChecker.MANUFACTURER;
                if (!str.equalsIgnoreCase("LENOVO")) {
                    String str2 = VendorChecker.BRAND;
                    if (!str2.equalsIgnoreCase("LENOVO") && !str2.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_ZUK)) {
                        z16 = false;
                        if (str.equalsIgnoreCase("MOTOROLA") && !VendorChecker.BRAND.equalsIgnoreCase("MOTOROLA")) {
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
        LX_TYPE = vendorChecker6;
        int i27 = 6;
        VendorChecker vendorChecker7 = new VendorChecker("HS_TYPE", i27, i26) { // from class: com.tencent.oaid2.VendorChecker.7
            static IPatchRedirector $redirector_;

            {
                super(r5, i27, i26, null);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, r5, Integer.valueOf(i27), Integer.valueOf(i26));
                }
            }

            @Override // com.tencent.oaid2.VendorChecker
            public boolean a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
                }
                if (!VendorChecker.MANUFACTURER.equalsIgnoreCase("ASUS") && !VendorChecker.BRAND.equalsIgnoreCase("ASUS")) {
                    return false;
                }
                return true;
            }
        };
        HS_TYPE = vendorChecker7;
        int i28 = 7;
        VendorChecker vendorChecker8 = new VendorChecker("SX_TYPE", i28, i27) { // from class: com.tencent.oaid2.VendorChecker.8
            static IPatchRedirector $redirector_;

            {
                super(r5, i28, i27, null);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, r5, Integer.valueOf(i28), Integer.valueOf(i27));
                }
            }

            @Override // com.tencent.oaid2.VendorChecker
            public boolean a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
                }
                if (!VendorChecker.MANUFACTURER.equalsIgnoreCase("SAMSUNG") && !VendorChecker.BRAND.equalsIgnoreCase("SAMSUNG")) {
                    return false;
                }
                return true;
            }
        };
        SX_TYPE = vendorChecker8;
        int i29 = 8;
        VendorChecker vendorChecker9 = new VendorChecker("MZ_TYPE", i29, i28) { // from class: com.tencent.oaid2.VendorChecker.9
            static IPatchRedirector $redirector_;

            {
                super(r5, i29, i28, null);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, r5, Integer.valueOf(i29), Integer.valueOf(i28));
                }
            }

            @Override // com.tencent.oaid2.VendorChecker
            public boolean a() {
                boolean z16;
                boolean z17;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
                }
                String str = VendorChecker.MANUFACTURER;
                if (!str.equalsIgnoreCase("MEIZU") && !VendorChecker.BRAND.equalsIgnoreCase("MEIZU") && !Build.DISPLAY.toUpperCase().contains("FLYME")) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!str.equalsIgnoreCase("ALPS") && !VendorChecker.BRAND.equalsIgnoreCase("ALPS")) {
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
        MZ_TYPE = vendorChecker9;
        int i36 = 9;
        VendorChecker vendorChecker10 = new VendorChecker("NB_TYPE", i36, i29) { // from class: com.tencent.oaid2.VendorChecker.10
            static IPatchRedirector $redirector_;

            {
                super(r5, i36, i29, null);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, r5, Integer.valueOf(i36), Integer.valueOf(i29));
                }
            }

            @Override // com.tencent.oaid2.VendorChecker
            public boolean a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
                }
                if (!VendorChecker.MANUFACTURER.equalsIgnoreCase("NUBIA") && !VendorChecker.BRAND.equalsIgnoreCase("NUBIA")) {
                    return false;
                }
                return true;
            }
        };
        NB_TYPE = vendorChecker10;
        int i37 = 10;
        VendorChecker vendorChecker11 = new VendorChecker("MSA_TYPE", i37, i36) { // from class: com.tencent.oaid2.VendorChecker.11
            static IPatchRedirector $redirector_;

            {
                super(r5, i37, i36, null);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, r5, Integer.valueOf(i37), Integer.valueOf(i36));
                }
            }

            @Override // com.tencent.oaid2.VendorChecker
            public boolean a() {
                boolean z16;
                boolean z17;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
                }
                String str = VendorChecker.MANUFACTURER;
                if (!str.equalsIgnoreCase("ZTE") && !VendorChecker.BRAND.equalsIgnoreCase("ZTE")) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (TextUtils.isEmpty(c.a("ro.build.freeme.label")) && !str.equalsIgnoreCase("freemeos")) {
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
        MSA_TYPE = vendorChecker11;
        VendorChecker vendorChecker12 = new VendorChecker("HONOR_TYPE", 11, i37) { // from class: com.tencent.oaid2.VendorChecker.12
            static IPatchRedirector $redirector_;

            {
                super(r5, r6, i37, null);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, r5, Integer.valueOf(r6), Integer.valueOf(i37));
                }
            }

            @Override // com.tencent.oaid2.VendorChecker
            public boolean a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
                }
                if (VendorChecker.OS_VERSION >= 31 && (VendorChecker.MANUFACTURER.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HONOR) || VendorChecker.BRAND.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HONOR))) {
                    return true;
                }
                return false;
            }
        };
        HONOR_TYPE = vendorChecker12;
        f339474a = new VendorChecker[]{vendorChecker, vendorChecker2, vendorChecker3, vendorChecker4, vendorChecker5, vendorChecker6, vendorChecker7, vendorChecker8, vendorChecker9, vendorChecker10, vendorChecker11, vendorChecker12};
        BRAND = Build.BRAND;
        MANUFACTURER = Build.MANUFACTURER;
        OS_VERSION = Build.VERSION.SDK_INT;
    }

    public VendorChecker(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.index = i16;
        } else {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    public static VendorChecker valueOf(String str) {
        return (VendorChecker) Enum.valueOf(VendorChecker.class, str);
    }

    public static VendorChecker[] values() {
        return (VendorChecker[]) f339474a.clone();
    }

    public abstract boolean a();

    public /* synthetic */ VendorChecker(String str, int i3, int i16, AnonymousClass1 anonymousClass1) {
        this(str, i3, i16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), Integer.valueOf(i16), anonymousClass1);
    }
}
