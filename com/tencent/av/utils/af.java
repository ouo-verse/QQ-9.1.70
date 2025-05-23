package com.tencent.av.utils;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AudioHelperUtil;
import java.nio.charset.StandardCharsets;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class af {
    private static String A = "is_use_nt_kernel_online_push";
    private static boolean B = false;

    /* renamed from: a, reason: collision with root package name */
    private static int f76946a = -1;

    /* renamed from: b, reason: collision with root package name */
    private static volatile int f76947b = -1;

    /* renamed from: c, reason: collision with root package name */
    private static int f76948c = -1;

    /* renamed from: d, reason: collision with root package name */
    private static int f76949d = -1;

    /* renamed from: e, reason: collision with root package name */
    private static volatile int f76950e = -1;

    /* renamed from: f, reason: collision with root package name */
    private static volatile int f76951f = -1;

    /* renamed from: g, reason: collision with root package name */
    private static volatile int f76952g = 6;

    /* renamed from: h, reason: collision with root package name */
    private static volatile int f76953h = -1;

    /* renamed from: i, reason: collision with root package name */
    private static volatile int f76954i = 0;

    /* renamed from: j, reason: collision with root package name */
    private static volatile Boolean f76955j = null;

    /* renamed from: k, reason: collision with root package name */
    private static String f76956k = null;

    /* renamed from: l, reason: collision with root package name */
    private static int f76957l = -1;

    /* renamed from: m, reason: collision with root package name */
    private static int f76958m = -1;

    /* renamed from: n, reason: collision with root package name */
    private static String f76959n = "qav_config_";

    /* renamed from: o, reason: collision with root package name */
    private static String f76960o = "text";

    /* renamed from: p, reason: collision with root package name */
    public static String f76961p = "ver";

    /* renamed from: q, reason: collision with root package name */
    public static String f76962q = "0";

    /* renamed from: r, reason: collision with root package name */
    private static Integer f76963r;

    /* renamed from: s, reason: collision with root package name */
    private static Integer f76964s;

    /* renamed from: t, reason: collision with root package name */
    private static a f76965t;

    /* renamed from: u, reason: collision with root package name */
    private static String f76966u;

    /* renamed from: v, reason: collision with root package name */
    private static Boolean f76967v;

    /* renamed from: w, reason: collision with root package name */
    private static Boolean f76968w;

    /* renamed from: x, reason: collision with root package name */
    private static Boolean f76969x;

    /* renamed from: y, reason: collision with root package name */
    private static Boolean f76970y;

    /* renamed from: z, reason: collision with root package name */
    private static Boolean f76971z;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f76972a;

        /* renamed from: b, reason: collision with root package name */
        public String f76973b;

        /* renamed from: c, reason: collision with root package name */
        public String f76974c;

        a(String str, String str2, String str3) {
            this.f76972a = str;
            this.f76973b = str2;
            this.f76974c = str3;
        }
    }

    public static boolean A() {
        if (f76953h == -1) {
            f76953h = d(287, f76962q).getInt("rollback8930UI", 0);
            QLog.i("QAVConfigUtils", 1, "rollback8930UI = " + f76953h);
        }
        if (f76953h != 1) {
            return false;
        }
        return true;
    }

    public static boolean B() {
        if (f76948c == -1) {
            f76948c = d(287, f76962q).getInt("SpeedDialScreenStyle", 0);
        }
        if (f76948c != 0) {
            return false;
        }
        return true;
    }

    public static boolean C() {
        if (f76968w == null) {
            f76968w = Boolean.valueOf(d(287, f76962q).getBoolean("useHwDecLowLatency", true));
            QLog.d("QAVConfigUtils", 1, "isSupportHWDecLowLatency := " + f76968w);
        }
        return f76968w.booleanValue();
    }

    public static boolean D() {
        if (f76969x == null) {
            f76969x = Boolean.valueOf(d(287, f76962q).getBoolean("useHWEncCBR", true));
            QLog.d("QAVConfigUtils", 1, "isSupportHWEncCBR := " + f76969x);
        }
        return f76969x.booleanValue();
    }

    public static boolean E() {
        if (f76950e == -1) {
            f76950e = d(287, f76962q).getInt("davBubbleSwitch", 1);
        }
        if (f76950e == 0) {
            return true;
        }
        return false;
    }

    public static boolean F() {
        int i3 = f76946a;
        boolean z16 = false;
        if (-1 != i3) {
            if (i3 != 1) {
                return false;
            }
            return true;
        }
        synchronized (af.class) {
            int i16 = f76946a;
            if (-1 != i16) {
                if (i16 == 1) {
                    z16 = true;
                }
                return z16;
            }
            int i17 = d(287, f76962q).getInt("isBlueToothSwitch", 1);
            f76946a = i17;
            if (i17 == 1) {
                z16 = true;
            }
            return z16;
        }
    }

    public static boolean G() {
        if (f76958m == -1) {
            f76958m = d(287, f76962q).getInt("upLoadWhenGetNewData", 0);
        }
        if (f76958m != 1) {
            return false;
        }
        return true;
    }

    public static boolean H() {
        boolean z16 = QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_QAV).getBoolean(s(A), false);
        if (z16 != B) {
            QLog.i("QAVConfigUtils", 1, "isUseNTKernelOnlinePush. " + B + " -> " + z16);
            B = z16;
        }
        return z16;
    }

    public static boolean I() {
        boolean z16 = false;
        String str = new String(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadRawConfig(A, new byte[0]), StandardCharsets.UTF_8);
        QLog.i("QAVConfigUtils", 1, "isUseNTKernelOnlinePushFromConfig. configStr: " + str);
        if (!TextUtils.isEmpty(str)) {
            try {
                z16 = j(new JSONObject(str), A, false);
            } catch (Exception e16) {
                QLog.e("QAVConfigUtils", 1, "isUseNTKernelOnlinePushFromConfig. parse json failed. " + QLog.getStackTraceString(e16));
            }
        }
        QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_QAV).putBoolean(s(A), z16);
        return z16;
    }

    public static boolean J() {
        String str = new String(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadRawConfig("is_used_audio_opensles_device", new byte[0]), StandardCharsets.UTF_8);
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            return j(new JSONObject(str), "is_used_audio_opensles_device", true);
        } catch (Exception e16) {
            QLog.e("QAVConfigUtils", 1, "isUseOpenSLESInterface parse json failed. " + QLog.getStackTraceString(e16));
            return true;
        }
    }

    public static boolean K() {
        if (f76957l == -1) {
            f76957l = d(287, f76962q).getInt("useRGB2I420Shader", 0);
        }
        if (f76957l != 1) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0a4b  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0a65  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0a71  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x08e3  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0900  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0a7f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0a8d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0ac4  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0ad1  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0ade  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0aec  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0b0c  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0ae0  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0ad3  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0ac6  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x09e3  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x09e1  */
    /* JADX WARN: Type inference failed for: r0v132 */
    /* JADX WARN: Type inference failed for: r1v31, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r3v56, types: [int] */
    /* JADX WARN: Type inference failed for: r3v66, types: [int] */
    /* JADX WARN: Type inference failed for: r3v76, types: [int] */
    /* JADX WARN: Type inference failed for: r3v79, types: [int] */
    /* JADX WARN: Type inference failed for: r3v93, types: [int] */
    /* JADX WARN: Type inference failed for: r3v95, types: [int] */
    /* JADX WARN: Type inference failed for: r5v24, types: [int] */
    /* JADX WARN: Type inference failed for: r7v40, types: [java.lang.StringBuilder] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 12 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 4 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 5 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void L(String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        int i3;
        String str11;
        Exception exc;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        String str19;
        boolean z16;
        boolean z17;
        int i16;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        boolean z28;
        boolean z29;
        boolean z36;
        String str20;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        boolean z37;
        int i28;
        int i29;
        int i36;
        int i37;
        int i38;
        int i39;
        int i46;
        int i47;
        int i48;
        int i49;
        String str21;
        String str22;
        String str23;
        int i56;
        boolean z38;
        int i57;
        String str24;
        boolean z39;
        String str25;
        int i58;
        int i59;
        int i65;
        int i66;
        boolean z46;
        int i67;
        String str26;
        int i68;
        String str27;
        String str28;
        String str29;
        int i69;
        int i75;
        boolean z47;
        int i76;
        boolean z48;
        String str30;
        String str31;
        boolean z49;
        boolean z55;
        int i77;
        int i78;
        String str32;
        boolean z56;
        int i79;
        int i85;
        String str33;
        String str34;
        boolean z57;
        String str35;
        long j3;
        boolean z58;
        JSONObject jSONObject;
        int k3;
        String str36;
        String m3;
        String m16;
        boolean z59;
        String jSONArray;
        String m17;
        boolean z65;
        String str37;
        boolean z66;
        int k16;
        boolean z67;
        String m18;
        int k17;
        boolean z68;
        int i86;
        int i87;
        if (QLog.isColorLevel()) {
            QLog.i("QAVConfigUtils", 2, " parseAndSave parse json = " + str);
        }
        long j16 = 1000;
        String str38 = "";
        if (TextUtils.isEmpty(str)) {
            str2 = "QAVConfigUtils";
            str3 = "ptuNewRenderLimit";
            str4 = "upLoadWhenGetNewData";
            str6 = "enableNetworkSdk";
            str7 = "ptuAfterTreamentCanvas";
            str8 = "ptuAfterTreamentLimit";
            str9 = "moreBtnTips";
            i49 = 6;
            str30 = "";
            str31 = str30;
            str22 = str31;
            str25 = str22;
            str27 = str25;
            str24 = str27;
            str28 = str24;
            str29 = str28;
            str33 = "useRGB2I420Shader";
            str34 = "switchMultiForceUseGroupAlertTip";
            str23 = " {\n        \"manufacture\": \"0\"\n}";
            str26 = "\u5bf9\u65b9\u7248\u672c\u8fc7\u4f4e\uff0c\u8bf7\u5148\u521b\u5efa\u7fa4\u804a\u540e\u9080\u8bf7";
            str21 = "networkSwitchJson";
            i65 = -1;
            i66 = 0;
            i68 = 1;
            z57 = true;
            i57 = 1;
            i58 = -1;
            i67 = -1;
            z38 = false;
            i69 = -1;
            i75 = -1;
            i56 = 1;
            z47 = false;
            i76 = -1;
            z55 = false;
            i77 = 1;
            i79 = 1;
            z48 = false;
            z49 = false;
            i78 = 1;
            i59 = 1;
            z39 = false;
            z56 = false;
            i85 = 0;
            str32 = str29;
            z46 = false;
            str35 = "videoTrackSoundSeparation";
            j3 = 1000;
            z58 = false;
        } else {
            try {
                jSONObject = new JSONObject(str);
                k3 = k(jSONObject, "isBlueToothSwitchForAndroid", 1);
                try {
                    j16 = l(jSONObject, "bluetoothDelayTime", 1000L).longValue();
                    z37 = j(jSONObject, "LowlightAndDenoiseDevice", true);
                } catch (Exception e16) {
                    str2 = "QAVConfigUtils";
                    str3 = "ptuNewRenderLimit";
                    str4 = "upLoadWhenGetNewData";
                    i36 = k3;
                    str5 = "handleGetQAVGeneralConfig";
                    str6 = "enableNetworkSdk";
                    str7 = "ptuAfterTreamentCanvas";
                    str8 = "ptuAfterTreamentLimit";
                    str9 = "moreBtnTips";
                    str10 = " {\n        \"manufacture\": \"0\"\n}";
                    i3 = 6;
                    str11 = "networkSwitchJson";
                    exc = e16;
                    str12 = "";
                    str13 = str12;
                    str14 = str13;
                    str15 = str14;
                    str16 = str15;
                    str17 = str16;
                    str18 = str17;
                    str19 = str18;
                    z16 = false;
                    z17 = false;
                    i16 = 0;
                    z18 = false;
                    z19 = false;
                    z26 = false;
                    z27 = false;
                    z28 = false;
                    z29 = false;
                    z36 = false;
                    str20 = "\u5bf9\u65b9\u7248\u672c\u8fc7\u4f4e\uff0c\u8bf7\u5148\u521b\u5efa\u7fa4\u804a\u540e\u9080\u8bf7";
                    i17 = 1;
                    i18 = 1;
                    i19 = 1;
                    i26 = -1;
                    i27 = 1;
                    z37 = true;
                }
            } catch (Exception e17) {
                str2 = "QAVConfigUtils";
                str3 = "ptuNewRenderLimit";
                str4 = "upLoadWhenGetNewData";
                str5 = "handleGetQAVGeneralConfig";
                str6 = "enableNetworkSdk";
                str7 = "ptuAfterTreamentCanvas";
                str8 = "ptuAfterTreamentLimit";
                str9 = "moreBtnTips";
                str10 = " {\n        \"manufacture\": \"0\"\n}";
                i3 = 6;
                str11 = "networkSwitchJson";
                exc = e17;
                str12 = "";
                str13 = str12;
                str14 = str13;
                str15 = str14;
                str16 = str15;
                str17 = str16;
                str18 = str17;
                str19 = str18;
                z16 = false;
                z17 = false;
                i16 = 0;
                z18 = false;
                z19 = false;
                z26 = false;
                z27 = false;
                z28 = false;
                z29 = false;
                z36 = false;
                str20 = "\u5bf9\u65b9\u7248\u672c\u8fc7\u4f4e\uff0c\u8bf7\u5148\u521b\u5efa\u7fa4\u804a\u540e\u9080\u8bf7";
                i17 = 1;
                i18 = 1;
                i19 = 1;
                i26 = -1;
                i27 = 1;
                z37 = true;
                i28 = -1;
                i29 = -1;
                i36 = 1;
            }
            try {
                i28 = k(jSONObject, "multiVideoSupportNumbers", -1);
                try {
                    i16 = k(jSONObject, "SpeedDialScreenStyle", 0);
                } catch (Exception e18) {
                    str2 = "QAVConfigUtils";
                    str3 = "ptuNewRenderLimit";
                    str4 = "upLoadWhenGetNewData";
                    i36 = k3;
                    str5 = "handleGetQAVGeneralConfig";
                    str7 = "ptuAfterTreamentCanvas";
                    str8 = "ptuAfterTreamentLimit";
                    str9 = "moreBtnTips";
                    str10 = " {\n        \"manufacture\": \"0\"\n}";
                    i3 = 6;
                    str36 = "\u5bf9\u65b9\u7248\u672c\u8fc7\u4f4e\uff0c\u8bf7\u5148\u521b\u5efa\u7fa4\u804a\u540e\u9080\u8bf7";
                    str11 = "networkSwitchJson";
                    str6 = "enableNetworkSdk";
                    exc = e18;
                    str12 = "";
                    str13 = str12;
                    str14 = str13;
                    str15 = str14;
                    str16 = str15;
                    str17 = str16;
                    str18 = str17;
                    str19 = str18;
                    z16 = false;
                    z17 = false;
                    i16 = 0;
                    z18 = false;
                }
            } catch (Exception e19) {
                str2 = "QAVConfigUtils";
                str3 = "ptuNewRenderLimit";
                str4 = "upLoadWhenGetNewData";
                i36 = k3;
                str5 = "handleGetQAVGeneralConfig";
                str6 = "enableNetworkSdk";
                str7 = "ptuAfterTreamentCanvas";
                str8 = "ptuAfterTreamentLimit";
                str9 = "moreBtnTips";
                str10 = " {\n        \"manufacture\": \"0\"\n}";
                i3 = 6;
                str11 = "networkSwitchJson";
                exc = e19;
                str12 = "";
                str13 = str12;
                str14 = str13;
                str15 = str14;
                str16 = str15;
                str17 = str16;
                str18 = str17;
                str19 = str18;
                z16 = false;
                z17 = false;
                i16 = 0;
                z18 = false;
                z19 = false;
                z26 = false;
                z27 = false;
                z28 = false;
                z29 = false;
                z36 = false;
                str20 = "\u5bf9\u65b9\u7248\u672c\u8fc7\u4f4e\uff0c\u8bf7\u5148\u521b\u5efa\u7fa4\u804a\u540e\u9080\u8bf7";
                i17 = 1;
                i18 = 1;
                i19 = 1;
                i26 = -1;
                i27 = 1;
                i28 = -1;
                i29 = -1;
                i37 = -1;
                i38 = -1;
                i39 = -1;
                i46 = 1;
                i47 = 1;
                if (QLog.isColorLevel()) {
                }
                i49 = i3;
                str21 = str11;
                str22 = str38;
                str23 = str10;
                i56 = i18;
                z38 = z16;
                i57 = i19;
                str24 = str12;
                z39 = z17;
                str25 = str13;
                i58 = i26;
                i59 = i27;
                i65 = i28;
                i66 = i16;
                z46 = z18;
                i67 = i29;
                str26 = str20;
                i68 = i36;
                str27 = str14;
                str28 = str15;
                str29 = str16;
                i69 = i37;
                i75 = i38;
                z47 = z26;
                i76 = i39;
                z48 = z27;
                str30 = str17;
                str31 = str18;
                z49 = z28;
                z55 = z29;
                i77 = i46;
                i78 = i47;
                str32 = str19;
                z56 = z36;
                i79 = i48;
                i85 = 0;
                str33 = "useRGB2I420Shader";
                str34 = "switchMultiForceUseGroupAlertTip";
                z57 = z37;
                str35 = "videoTrackSoundSeparation";
                j3 = j16;
                z58 = z19;
                String str39 = str23;
                SharedPreferences.Editor edit = d(287, f76962q).edit();
                edit.putInt("isBlueToothSwitch", i68);
                edit.putLong("bluetoothDelayTime", j3);
                edit.putBoolean("LowlightAndDenoiseDevice", z57);
                edit.putInt("multiVideoSupportNumbers", i65);
                edit.putInt("SpeedDialScreenStyle", i66);
                edit.putBoolean("switchMultiForceUseGroup", z46);
                edit.putBoolean(str6, i57 >= 1);
                edit.putString(str21, str39);
                edit.putString(str34, str26);
                edit.putInt(str33, i67);
                edit.putInt(str35, z58 ? 1 : 0);
                edit.putInt(str4, i58);
                edit.putString(str3, str22);
                edit.putString(str9, str25);
                edit.putString(str8, str27);
                edit.putString(str7, str24);
                edit.putBoolean("isAllowedControlMicAfterBeMuted", z38);
                edit.putString("machineMiddleLine", str28);
                edit.putString("machineHighLine", str29);
                edit.putInt("allowMicLongPressSpeakInMute", i69);
                i86 = i75;
                if (i86 != -1) {
                }
                edit.putInt("ScreenShareSwitch", i56);
                edit.putInt("AskScreenShareSwitch", z47 ? 1 : 0);
                i87 = i76;
                if (i87 != -1) {
                }
                if (!str32.isEmpty()) {
                }
                if (!str30.isEmpty()) {
                }
                if (!str31.isEmpty()) {
                }
                int i88 = i79;
                f76950e = i88;
                edit.putInt("davBubbleSwitch", i88);
                edit.putInt("880UIABTestOption", z48 ? 1 : 0);
                edit.putInt("880EffectUIABTestOption", z49 ? 1 : 0);
                edit.putInt("883Avatar2dEntranceABTestOption", z55 ? 1 : 0);
                edit.putInt("V7BeautyLowestSupportLevel", i49);
                edit.putBoolean("useHwDecLowLatency", i77 >= 1);
                edit.putBoolean("useHWEncCBR", i78 >= 1);
                edit.putBoolean("c2cServerConfig", i59 >= 1);
                edit.putBoolean("c2cQClear", z39 >= 1);
                edit.putInt("MoreFuc", z56 ? 1 : 0);
                edit.putInt("rollback8930UI", i85);
                edit.commit();
                if (QLog.isColorLevel()) {
                }
            }
            try {
                z18 = j(jSONObject, "switchMultiForceUseGroup", false);
                try {
                    m3 = m(jSONObject, "switchMultiForceUseGroupAlertTip", "\u5bf9\u65b9\u7248\u672c\u8fc7\u4f4e\uff0c\u8bf7\u5148\u521b\u5efa\u7fa4\u804a\u540e\u9080\u8bf7");
                } catch (Exception e26) {
                    str2 = "QAVConfigUtils";
                    str3 = "ptuNewRenderLimit";
                    str4 = "upLoadWhenGetNewData";
                    i36 = k3;
                    str5 = "handleGetQAVGeneralConfig";
                    str7 = "ptuAfterTreamentCanvas";
                    str8 = "ptuAfterTreamentLimit";
                    str9 = "moreBtnTips";
                    str10 = " {\n        \"manufacture\": \"0\"\n}";
                    i3 = 6;
                    str36 = "\u5bf9\u65b9\u7248\u672c\u8fc7\u4f4e\uff0c\u8bf7\u5148\u521b\u5efa\u7fa4\u804a\u540e\u9080\u8bf7";
                    str11 = "networkSwitchJson";
                    str6 = "enableNetworkSdk";
                    exc = e26;
                    str12 = "";
                    str13 = str12;
                    str14 = str13;
                    str15 = str14;
                    str16 = str15;
                    str17 = str16;
                    str18 = str17;
                    str19 = str18;
                    z16 = false;
                    z17 = false;
                    z19 = false;
                    z26 = z19;
                    z27 = z26;
                    z28 = z27;
                    z29 = z28;
                    z36 = z29;
                    str20 = str36;
                    i17 = 1;
                    i18 = 1;
                    i19 = 1;
                    i26 = -1;
                    i27 = 1;
                    i29 = -1;
                    i37 = -1;
                    i38 = -1;
                    i39 = -1;
                    i46 = 1;
                    i47 = 1;
                    if (QLog.isColorLevel()) {
                    }
                    i49 = i3;
                    str21 = str11;
                    str22 = str38;
                    str23 = str10;
                    i56 = i18;
                    z38 = z16;
                    i57 = i19;
                    str24 = str12;
                    z39 = z17;
                    str25 = str13;
                    i58 = i26;
                    i59 = i27;
                    i65 = i28;
                    i66 = i16;
                    z46 = z18;
                    i67 = i29;
                    str26 = str20;
                    i68 = i36;
                    str27 = str14;
                    str28 = str15;
                    str29 = str16;
                    i69 = i37;
                    i75 = i38;
                    z47 = z26;
                    i76 = i39;
                    z48 = z27;
                    str30 = str17;
                    str31 = str18;
                    z49 = z28;
                    z55 = z29;
                    i77 = i46;
                    i78 = i47;
                    str32 = str19;
                    z56 = z36;
                    i79 = i48;
                    i85 = 0;
                    str33 = "useRGB2I420Shader";
                    str34 = "switchMultiForceUseGroupAlertTip";
                    z57 = z37;
                    str35 = "videoTrackSoundSeparation";
                    j3 = j16;
                    z58 = z19;
                    String str392 = str23;
                    SharedPreferences.Editor edit2 = d(287, f76962q).edit();
                    edit2.putInt("isBlueToothSwitch", i68);
                    edit2.putLong("bluetoothDelayTime", j3);
                    edit2.putBoolean("LowlightAndDenoiseDevice", z57);
                    edit2.putInt("multiVideoSupportNumbers", i65);
                    edit2.putInt("SpeedDialScreenStyle", i66);
                    edit2.putBoolean("switchMultiForceUseGroup", z46);
                    edit2.putBoolean(str6, i57 >= 1);
                    edit2.putString(str21, str392);
                    edit2.putString(str34, str26);
                    edit2.putInt(str33, i67);
                    edit2.putInt(str35, z58 ? 1 : 0);
                    edit2.putInt(str4, i58);
                    edit2.putString(str3, str22);
                    edit2.putString(str9, str25);
                    edit2.putString(str8, str27);
                    edit2.putString(str7, str24);
                    edit2.putBoolean("isAllowedControlMicAfterBeMuted", z38);
                    edit2.putString("machineMiddleLine", str28);
                    edit2.putString("machineHighLine", str29);
                    edit2.putInt("allowMicLongPressSpeakInMute", i69);
                    i86 = i75;
                    if (i86 != -1) {
                    }
                    edit2.putInt("ScreenShareSwitch", i56);
                    edit2.putInt("AskScreenShareSwitch", z47 ? 1 : 0);
                    i87 = i76;
                    if (i87 != -1) {
                    }
                    if (!str32.isEmpty()) {
                    }
                    if (!str30.isEmpty()) {
                    }
                    if (!str31.isEmpty()) {
                    }
                    int i882 = i79;
                    f76950e = i882;
                    edit2.putInt("davBubbleSwitch", i882);
                    edit2.putInt("880UIABTestOption", z48 ? 1 : 0);
                    edit2.putInt("880EffectUIABTestOption", z49 ? 1 : 0);
                    edit2.putInt("883Avatar2dEntranceABTestOption", z55 ? 1 : 0);
                    edit2.putInt("V7BeautyLowestSupportLevel", i49);
                    edit2.putBoolean("useHwDecLowLatency", i77 >= 1);
                    edit2.putBoolean("useHWEncCBR", i78 >= 1);
                    edit2.putBoolean("c2cServerConfig", i59 >= 1);
                    edit2.putBoolean("c2cQClear", z39 >= 1);
                    edit2.putInt("MoreFuc", z56 ? 1 : 0);
                    edit2.putInt("rollback8930UI", i85);
                    edit2.commit();
                    if (QLog.isColorLevel()) {
                    }
                }
            } catch (Exception e27) {
                str2 = "QAVConfigUtils";
                str3 = "ptuNewRenderLimit";
                str4 = "upLoadWhenGetNewData";
                i36 = k3;
                str5 = "handleGetQAVGeneralConfig";
                str7 = "ptuAfterTreamentCanvas";
                str8 = "ptuAfterTreamentLimit";
                str9 = "moreBtnTips";
                str10 = " {\n        \"manufacture\": \"0\"\n}";
                i3 = 6;
                str36 = "\u5bf9\u65b9\u7248\u672c\u8fc7\u4f4e\uff0c\u8bf7\u5148\u521b\u5efa\u7fa4\u804a\u540e\u9080\u8bf7";
                str11 = "networkSwitchJson";
                str6 = "enableNetworkSdk";
                exc = e27;
                str12 = "";
                str13 = str12;
                str14 = str13;
                str15 = str14;
                str16 = str15;
                str17 = str16;
                str18 = str17;
                str19 = str18;
                z16 = false;
                z17 = false;
                z18 = false;
                z19 = z18;
                z26 = z19;
                z27 = z26;
                z28 = z27;
                z29 = z28;
                z36 = z29;
                str20 = str36;
                i17 = 1;
                i18 = 1;
                i19 = 1;
                i26 = -1;
                i27 = 1;
                i29 = -1;
                i37 = -1;
                i38 = -1;
                i39 = -1;
                i46 = 1;
                i47 = 1;
                if (QLog.isColorLevel()) {
                }
                i49 = i3;
                str21 = str11;
                str22 = str38;
                str23 = str10;
                i56 = i18;
                z38 = z16;
                i57 = i19;
                str24 = str12;
                z39 = z17;
                str25 = str13;
                i58 = i26;
                i59 = i27;
                i65 = i28;
                i66 = i16;
                z46 = z18;
                i67 = i29;
                str26 = str20;
                i68 = i36;
                str27 = str14;
                str28 = str15;
                str29 = str16;
                i69 = i37;
                i75 = i38;
                z47 = z26;
                i76 = i39;
                z48 = z27;
                str30 = str17;
                str31 = str18;
                z49 = z28;
                z55 = z29;
                i77 = i46;
                i78 = i47;
                str32 = str19;
                z56 = z36;
                i79 = i48;
                i85 = 0;
                str33 = "useRGB2I420Shader";
                str34 = "switchMultiForceUseGroupAlertTip";
                z57 = z37;
                str35 = "videoTrackSoundSeparation";
                j3 = j16;
                z58 = z19;
                String str3922 = str23;
                SharedPreferences.Editor edit22 = d(287, f76962q).edit();
                edit22.putInt("isBlueToothSwitch", i68);
                edit22.putLong("bluetoothDelayTime", j3);
                edit22.putBoolean("LowlightAndDenoiseDevice", z57);
                edit22.putInt("multiVideoSupportNumbers", i65);
                edit22.putInt("SpeedDialScreenStyle", i66);
                edit22.putBoolean("switchMultiForceUseGroup", z46);
                edit22.putBoolean(str6, i57 >= 1);
                edit22.putString(str21, str3922);
                edit22.putString(str34, str26);
                edit22.putInt(str33, i67);
                edit22.putInt(str35, z58 ? 1 : 0);
                edit22.putInt(str4, i58);
                edit22.putString(str3, str22);
                edit22.putString(str9, str25);
                edit22.putString(str8, str27);
                edit22.putString(str7, str24);
                edit22.putBoolean("isAllowedControlMicAfterBeMuted", z38);
                edit22.putString("machineMiddleLine", str28);
                edit22.putString("machineHighLine", str29);
                edit22.putInt("allowMicLongPressSpeakInMute", i69);
                i86 = i75;
                if (i86 != -1) {
                }
                edit22.putInt("ScreenShareSwitch", i56);
                edit22.putInt("AskScreenShareSwitch", z47 ? 1 : 0);
                i87 = i76;
                if (i87 != -1) {
                }
                if (!str32.isEmpty()) {
                }
                if (!str30.isEmpty()) {
                }
                if (!str31.isEmpty()) {
                }
                int i8822 = i79;
                f76950e = i8822;
                edit22.putInt("davBubbleSwitch", i8822);
                edit22.putInt("880UIABTestOption", z48 ? 1 : 0);
                edit22.putInt("880EffectUIABTestOption", z49 ? 1 : 0);
                edit22.putInt("883Avatar2dEntranceABTestOption", z55 ? 1 : 0);
                edit22.putInt("V7BeautyLowestSupportLevel", i49);
                edit22.putBoolean("useHwDecLowLatency", i77 >= 1);
                edit22.putBoolean("useHWEncCBR", i78 >= 1);
                edit22.putBoolean("c2cServerConfig", i59 >= 1);
                edit22.putBoolean("c2cQClear", z39 >= 1);
                edit22.putInt("MoreFuc", z56 ? 1 : 0);
                edit22.putInt("rollback8930UI", i85);
                edit22.commit();
                if (QLog.isColorLevel()) {
                }
            }
            try {
                i29 = k(jSONObject, "useRGB2I420Shader", -1);
                str20 = m3;
                try {
                    ?? k18 = k(jSONObject, "videoTrackSoundSeparation", 0);
                    try {
                        ?? sb5 = new StringBuilder();
                        i36 = k3;
                        try {
                            sb5.append("JTest. save videoTrackSoundSeparation = ");
                            sb5.append(k18);
                            QLog.i("QAVConfigUtils", 1, sb5.toString());
                            int k19 = k(jSONObject, "upLoadWhenGetNewData", -1);
                            try {
                                m16 = m(jSONObject, "ptuNewRenderLimit", "");
                                try {
                                    if (jSONObject.has("moreBtnTips")) {
                                        try {
                                            z19 = k18;
                                            try {
                                                jSONArray = jSONObject.getJSONArray("moreBtnTips").toString();
                                                i26 = k19;
                                                try {
                                                    StringBuilder sb6 = new StringBuilder();
                                                    str9 = "moreBtnTips";
                                                    try {
                                                        sb6.append("MoreBtnTips. downloaded moreBtnTipsJson = ");
                                                        sb6.append(jSONArray);
                                                        QLog.i("QAVConfigUtils", 1, sb6.toString());
                                                    } catch (Exception e28) {
                                                        e = e28;
                                                        exc = e;
                                                        str2 = "QAVConfigUtils";
                                                        str14 = "";
                                                        str15 = str14;
                                                        str16 = str15;
                                                        str17 = str16;
                                                        str18 = str17;
                                                        str19 = str18;
                                                        str3 = "ptuNewRenderLimit";
                                                        str4 = "upLoadWhenGetNewData";
                                                        str5 = "handleGetQAVGeneralConfig";
                                                        str6 = "enableNetworkSdk";
                                                        str7 = "ptuAfterTreamentCanvas";
                                                        str8 = "ptuAfterTreamentLimit";
                                                        str10 = " {\n        \"manufacture\": \"0\"\n}";
                                                        i17 = 1;
                                                        i3 = 6;
                                                        i18 = 1;
                                                        i19 = 1;
                                                        z17 = false;
                                                        i27 = 1;
                                                        i37 = -1;
                                                        i38 = -1;
                                                        z26 = false;
                                                        i39 = -1;
                                                        z27 = false;
                                                        z28 = false;
                                                        z29 = false;
                                                        i46 = 1;
                                                        i47 = 1;
                                                        z36 = false;
                                                        str13 = jSONArray;
                                                        str12 = str19;
                                                        str11 = "networkSwitchJson";
                                                        str38 = m16;
                                                        z16 = false;
                                                        if (QLog.isColorLevel()) {
                                                        }
                                                        i49 = i3;
                                                        str21 = str11;
                                                        str22 = str38;
                                                        str23 = str10;
                                                        i56 = i18;
                                                        z38 = z16;
                                                        i57 = i19;
                                                        str24 = str12;
                                                        z39 = z17;
                                                        str25 = str13;
                                                        i58 = i26;
                                                        i59 = i27;
                                                        i65 = i28;
                                                        i66 = i16;
                                                        z46 = z18;
                                                        i67 = i29;
                                                        str26 = str20;
                                                        i68 = i36;
                                                        str27 = str14;
                                                        str28 = str15;
                                                        str29 = str16;
                                                        i69 = i37;
                                                        i75 = i38;
                                                        z47 = z26;
                                                        i76 = i39;
                                                        z48 = z27;
                                                        str30 = str17;
                                                        str31 = str18;
                                                        z49 = z28;
                                                        z55 = z29;
                                                        i77 = i46;
                                                        i78 = i47;
                                                        str32 = str19;
                                                        z56 = z36;
                                                        i79 = i48;
                                                        i85 = 0;
                                                        str33 = "useRGB2I420Shader";
                                                        str34 = "switchMultiForceUseGroupAlertTip";
                                                        z57 = z37;
                                                        str35 = "videoTrackSoundSeparation";
                                                        j3 = j16;
                                                        z58 = z19;
                                                        String str39222 = str23;
                                                        SharedPreferences.Editor edit222 = d(287, f76962q).edit();
                                                        edit222.putInt("isBlueToothSwitch", i68);
                                                        edit222.putLong("bluetoothDelayTime", j3);
                                                        edit222.putBoolean("LowlightAndDenoiseDevice", z57);
                                                        edit222.putInt("multiVideoSupportNumbers", i65);
                                                        edit222.putInt("SpeedDialScreenStyle", i66);
                                                        edit222.putBoolean("switchMultiForceUseGroup", z46);
                                                        edit222.putBoolean(str6, i57 >= 1);
                                                        edit222.putString(str21, str39222);
                                                        edit222.putString(str34, str26);
                                                        edit222.putInt(str33, i67);
                                                        edit222.putInt(str35, z58 ? 1 : 0);
                                                        edit222.putInt(str4, i58);
                                                        edit222.putString(str3, str22);
                                                        edit222.putString(str9, str25);
                                                        edit222.putString(str8, str27);
                                                        edit222.putString(str7, str24);
                                                        edit222.putBoolean("isAllowedControlMicAfterBeMuted", z38);
                                                        edit222.putString("machineMiddleLine", str28);
                                                        edit222.putString("machineHighLine", str29);
                                                        edit222.putInt("allowMicLongPressSpeakInMute", i69);
                                                        i86 = i75;
                                                        if (i86 != -1) {
                                                        }
                                                        edit222.putInt("ScreenShareSwitch", i56);
                                                        edit222.putInt("AskScreenShareSwitch", z47 ? 1 : 0);
                                                        i87 = i76;
                                                        if (i87 != -1) {
                                                        }
                                                        if (!str32.isEmpty()) {
                                                        }
                                                        if (!str30.isEmpty()) {
                                                        }
                                                        if (!str31.isEmpty()) {
                                                        }
                                                        int i88222 = i79;
                                                        f76950e = i88222;
                                                        edit222.putInt("davBubbleSwitch", i88222);
                                                        edit222.putInt("880UIABTestOption", z48 ? 1 : 0);
                                                        edit222.putInt("880EffectUIABTestOption", z49 ? 1 : 0);
                                                        edit222.putInt("883Avatar2dEntranceABTestOption", z55 ? 1 : 0);
                                                        edit222.putInt("V7BeautyLowestSupportLevel", i49);
                                                        edit222.putBoolean("useHwDecLowLatency", i77 >= 1);
                                                        edit222.putBoolean("useHWEncCBR", i78 >= 1);
                                                        edit222.putBoolean("c2cServerConfig", i59 >= 1);
                                                        edit222.putBoolean("c2cQClear", z39 >= 1);
                                                        edit222.putInt("MoreFuc", z56 ? 1 : 0);
                                                        edit222.putInt("rollback8930UI", i85);
                                                        edit222.commit();
                                                        if (QLog.isColorLevel()) {
                                                        }
                                                    }
                                                } catch (Exception e29) {
                                                    e = e29;
                                                    str9 = "moreBtnTips";
                                                }
                                            } catch (Exception e36) {
                                                e = e36;
                                                str9 = "moreBtnTips";
                                                i26 = k19;
                                                exc = e;
                                                str2 = "QAVConfigUtils";
                                                str14 = "";
                                                str15 = str14;
                                                str16 = str15;
                                                str17 = str16;
                                                str18 = str17;
                                                str19 = str18;
                                                str3 = "ptuNewRenderLimit";
                                                str4 = "upLoadWhenGetNewData";
                                                str5 = "handleGetQAVGeneralConfig";
                                                str11 = "networkSwitchJson";
                                                str6 = "enableNetworkSdk";
                                                str7 = "ptuAfterTreamentCanvas";
                                                str8 = "ptuAfterTreamentLimit";
                                                str10 = " {\n        \"manufacture\": \"0\"\n}";
                                                i17 = 1;
                                                i3 = 6;
                                                i18 = 1;
                                                z16 = false;
                                                i19 = 1;
                                                z17 = false;
                                                i27 = 1;
                                                i37 = -1;
                                                i38 = -1;
                                                z26 = false;
                                                i39 = -1;
                                                z27 = false;
                                                z28 = false;
                                                z29 = false;
                                                i46 = 1;
                                                i47 = 1;
                                                z36 = false;
                                                str12 = str19;
                                                str13 = str12;
                                                str38 = m16;
                                                if (QLog.isColorLevel()) {
                                                }
                                                i49 = i3;
                                                str21 = str11;
                                                str22 = str38;
                                                str23 = str10;
                                                i56 = i18;
                                                z38 = z16;
                                                i57 = i19;
                                                str24 = str12;
                                                z39 = z17;
                                                str25 = str13;
                                                i58 = i26;
                                                i59 = i27;
                                                i65 = i28;
                                                i66 = i16;
                                                z46 = z18;
                                                i67 = i29;
                                                str26 = str20;
                                                i68 = i36;
                                                str27 = str14;
                                                str28 = str15;
                                                str29 = str16;
                                                i69 = i37;
                                                i75 = i38;
                                                z47 = z26;
                                                i76 = i39;
                                                z48 = z27;
                                                str30 = str17;
                                                str31 = str18;
                                                z49 = z28;
                                                z55 = z29;
                                                i77 = i46;
                                                i78 = i47;
                                                str32 = str19;
                                                z56 = z36;
                                                i79 = i48;
                                                i85 = 0;
                                                str33 = "useRGB2I420Shader";
                                                str34 = "switchMultiForceUseGroupAlertTip";
                                                z57 = z37;
                                                str35 = "videoTrackSoundSeparation";
                                                j3 = j16;
                                                z58 = z19;
                                                String str392222 = str23;
                                                SharedPreferences.Editor edit2222 = d(287, f76962q).edit();
                                                edit2222.putInt("isBlueToothSwitch", i68);
                                                edit2222.putLong("bluetoothDelayTime", j3);
                                                edit2222.putBoolean("LowlightAndDenoiseDevice", z57);
                                                edit2222.putInt("multiVideoSupportNumbers", i65);
                                                edit2222.putInt("SpeedDialScreenStyle", i66);
                                                edit2222.putBoolean("switchMultiForceUseGroup", z46);
                                                edit2222.putBoolean(str6, i57 >= 1);
                                                edit2222.putString(str21, str392222);
                                                edit2222.putString(str34, str26);
                                                edit2222.putInt(str33, i67);
                                                edit2222.putInt(str35, z58 ? 1 : 0);
                                                edit2222.putInt(str4, i58);
                                                edit2222.putString(str3, str22);
                                                edit2222.putString(str9, str25);
                                                edit2222.putString(str8, str27);
                                                edit2222.putString(str7, str24);
                                                edit2222.putBoolean("isAllowedControlMicAfterBeMuted", z38);
                                                edit2222.putString("machineMiddleLine", str28);
                                                edit2222.putString("machineHighLine", str29);
                                                edit2222.putInt("allowMicLongPressSpeakInMute", i69);
                                                i86 = i75;
                                                if (i86 != -1) {
                                                }
                                                edit2222.putInt("ScreenShareSwitch", i56);
                                                edit2222.putInt("AskScreenShareSwitch", z47 ? 1 : 0);
                                                i87 = i76;
                                                if (i87 != -1) {
                                                }
                                                if (!str32.isEmpty()) {
                                                }
                                                if (!str30.isEmpty()) {
                                                }
                                                if (!str31.isEmpty()) {
                                                }
                                                int i882222 = i79;
                                                f76950e = i882222;
                                                edit2222.putInt("davBubbleSwitch", i882222);
                                                edit2222.putInt("880UIABTestOption", z48 ? 1 : 0);
                                                edit2222.putInt("880EffectUIABTestOption", z49 ? 1 : 0);
                                                edit2222.putInt("883Avatar2dEntranceABTestOption", z55 ? 1 : 0);
                                                edit2222.putInt("V7BeautyLowestSupportLevel", i49);
                                                edit2222.putBoolean("useHwDecLowLatency", i77 >= 1);
                                                edit2222.putBoolean("useHWEncCBR", i78 >= 1);
                                                edit2222.putBoolean("c2cServerConfig", i59 >= 1);
                                                edit2222.putBoolean("c2cQClear", z39 >= 1);
                                                edit2222.putInt("MoreFuc", z56 ? 1 : 0);
                                                edit2222.putInt("rollback8930UI", i85);
                                                edit2222.commit();
                                                if (QLog.isColorLevel()) {
                                                }
                                            }
                                        } catch (Exception e37) {
                                            e = e37;
                                            str9 = "moreBtnTips";
                                            z19 = k18;
                                        }
                                    } else {
                                        str9 = "moreBtnTips";
                                        z19 = k18;
                                        i26 = k19;
                                        jSONArray = "";
                                    }
                                    try {
                                        String m19 = m(jSONObject, "ptuAfterTreamentLimit", "");
                                        str13 = jSONArray;
                                        try {
                                            str12 = m(jSONObject, "ptuAfterTreamentCanvas", "");
                                            str14 = m19;
                                            str7 = "ptuAfterTreamentCanvas";
                                        } catch (Exception e38) {
                                            str8 = "ptuAfterTreamentLimit";
                                            str2 = "QAVConfigUtils";
                                            str7 = "ptuAfterTreamentCanvas";
                                            str3 = "ptuNewRenderLimit";
                                            str4 = "upLoadWhenGetNewData";
                                            str14 = m19;
                                            str5 = "handleGetQAVGeneralConfig";
                                            str11 = "networkSwitchJson";
                                            str6 = "enableNetworkSdk";
                                            str10 = " {\n        \"manufacture\": \"0\"\n}";
                                            i3 = 6;
                                            z59 = false;
                                            exc = e38;
                                            str12 = "";
                                            str15 = str12;
                                        }
                                    } catch (Exception e39) {
                                        str8 = "ptuAfterTreamentLimit";
                                        str2 = "QAVConfigUtils";
                                        str13 = jSONArray;
                                        str3 = "ptuNewRenderLimit";
                                        str4 = "upLoadWhenGetNewData";
                                        str5 = "handleGetQAVGeneralConfig";
                                        str11 = "networkSwitchJson";
                                        str6 = "enableNetworkSdk";
                                        str7 = "ptuAfterTreamentCanvas";
                                        str10 = " {\n        \"manufacture\": \"0\"\n}";
                                        i3 = 6;
                                        z59 = false;
                                        exc = e39;
                                        str12 = "";
                                        str14 = str12;
                                        str15 = str14;
                                        str16 = str15;
                                        str17 = str16;
                                        str18 = str17;
                                        str19 = str18;
                                        z16 = z59;
                                        z17 = z16;
                                        z26 = z17;
                                        z27 = z26;
                                        z28 = z27;
                                        z29 = z28;
                                        z36 = z29;
                                        str38 = m16;
                                        i17 = 1;
                                        i18 = 1;
                                        i19 = 1;
                                        i27 = 1;
                                        i37 = -1;
                                        i38 = -1;
                                        i39 = -1;
                                        i46 = 1;
                                        i47 = 1;
                                        if (QLog.isColorLevel()) {
                                        }
                                        i49 = i3;
                                        str21 = str11;
                                        str22 = str38;
                                        str23 = str10;
                                        i56 = i18;
                                        z38 = z16;
                                        i57 = i19;
                                        str24 = str12;
                                        z39 = z17;
                                        str25 = str13;
                                        i58 = i26;
                                        i59 = i27;
                                        i65 = i28;
                                        i66 = i16;
                                        z46 = z18;
                                        i67 = i29;
                                        str26 = str20;
                                        i68 = i36;
                                        str27 = str14;
                                        str28 = str15;
                                        str29 = str16;
                                        i69 = i37;
                                        i75 = i38;
                                        z47 = z26;
                                        i76 = i39;
                                        z48 = z27;
                                        str30 = str17;
                                        str31 = str18;
                                        z49 = z28;
                                        z55 = z29;
                                        i77 = i46;
                                        i78 = i47;
                                        str32 = str19;
                                        z56 = z36;
                                        i79 = i48;
                                        i85 = 0;
                                        str33 = "useRGB2I420Shader";
                                        str34 = "switchMultiForceUseGroupAlertTip";
                                        z57 = z37;
                                        str35 = "videoTrackSoundSeparation";
                                        j3 = j16;
                                        z58 = z19;
                                        String str3922222 = str23;
                                        SharedPreferences.Editor edit22222 = d(287, f76962q).edit();
                                        edit22222.putInt("isBlueToothSwitch", i68);
                                        edit22222.putLong("bluetoothDelayTime", j3);
                                        edit22222.putBoolean("LowlightAndDenoiseDevice", z57);
                                        edit22222.putInt("multiVideoSupportNumbers", i65);
                                        edit22222.putInt("SpeedDialScreenStyle", i66);
                                        edit22222.putBoolean("switchMultiForceUseGroup", z46);
                                        edit22222.putBoolean(str6, i57 >= 1);
                                        edit22222.putString(str21, str3922222);
                                        edit22222.putString(str34, str26);
                                        edit22222.putInt(str33, i67);
                                        edit22222.putInt(str35, z58 ? 1 : 0);
                                        edit22222.putInt(str4, i58);
                                        edit22222.putString(str3, str22);
                                        edit22222.putString(str9, str25);
                                        edit22222.putString(str8, str27);
                                        edit22222.putString(str7, str24);
                                        edit22222.putBoolean("isAllowedControlMicAfterBeMuted", z38);
                                        edit22222.putString("machineMiddleLine", str28);
                                        edit22222.putString("machineHighLine", str29);
                                        edit22222.putInt("allowMicLongPressSpeakInMute", i69);
                                        i86 = i75;
                                        if (i86 != -1) {
                                        }
                                        edit22222.putInt("ScreenShareSwitch", i56);
                                        edit22222.putInt("AskScreenShareSwitch", z47 ? 1 : 0);
                                        i87 = i76;
                                        if (i87 != -1) {
                                        }
                                        if (!str32.isEmpty()) {
                                        }
                                        if (!str30.isEmpty()) {
                                        }
                                        if (!str31.isEmpty()) {
                                        }
                                        int i8822222 = i79;
                                        f76950e = i8822222;
                                        edit22222.putInt("davBubbleSwitch", i8822222);
                                        edit22222.putInt("880UIABTestOption", z48 ? 1 : 0);
                                        edit22222.putInt("880EffectUIABTestOption", z49 ? 1 : 0);
                                        edit22222.putInt("883Avatar2dEntranceABTestOption", z55 ? 1 : 0);
                                        edit22222.putInt("V7BeautyLowestSupportLevel", i49);
                                        edit22222.putBoolean("useHwDecLowLatency", i77 >= 1);
                                        edit22222.putBoolean("useHWEncCBR", i78 >= 1);
                                        edit22222.putBoolean("c2cServerConfig", i59 >= 1);
                                        edit22222.putBoolean("c2cQClear", z39 >= 1);
                                        edit22222.putInt("MoreFuc", z56 ? 1 : 0);
                                        edit22222.putInt("rollback8930UI", i85);
                                        edit22222.commit();
                                        if (QLog.isColorLevel()) {
                                        }
                                    }
                                    try {
                                        boolean j17 = j(jSONObject, "isAllowedControlMicAfterBeMuted", false);
                                        try {
                                            StringBuilder sb7 = new StringBuilder();
                                            str8 = "ptuAfterTreamentLimit";
                                            try {
                                                sb7.append("JTest. save isAllowedControlMicAfterBeMuted = ");
                                                sb7.append(j17);
                                                QLog.i("QAVConfigUtils", 1, sb7.toString());
                                                str6 = "enableNetworkSdk";
                                            } catch (Exception e46) {
                                                e = e46;
                                                str2 = "QAVConfigUtils";
                                                str3 = "ptuNewRenderLimit";
                                                str4 = "upLoadWhenGetNewData";
                                                str5 = "handleGetQAVGeneralConfig";
                                                str11 = "networkSwitchJson";
                                                str6 = "enableNetworkSdk";
                                                i3 = 6;
                                                z16 = j17;
                                                str10 = " {\n        \"manufacture\": \"0\"\n}";
                                                exc = e;
                                                str15 = "";
                                                str16 = str15;
                                                str17 = str16;
                                                str18 = str17;
                                                str19 = str18;
                                                z17 = false;
                                                z26 = z17;
                                                z27 = z26;
                                                z28 = z27;
                                                z29 = z28;
                                                z36 = z29;
                                                str38 = m16;
                                                i17 = 1;
                                                i18 = 1;
                                                i19 = 1;
                                                i27 = 1;
                                                i37 = -1;
                                                i38 = -1;
                                                i39 = -1;
                                                i46 = 1;
                                                i47 = 1;
                                                if (QLog.isColorLevel()) {
                                                }
                                                i49 = i3;
                                                str21 = str11;
                                                str22 = str38;
                                                str23 = str10;
                                                i56 = i18;
                                                z38 = z16;
                                                i57 = i19;
                                                str24 = str12;
                                                z39 = z17;
                                                str25 = str13;
                                                i58 = i26;
                                                i59 = i27;
                                                i65 = i28;
                                                i66 = i16;
                                                z46 = z18;
                                                i67 = i29;
                                                str26 = str20;
                                                i68 = i36;
                                                str27 = str14;
                                                str28 = str15;
                                                str29 = str16;
                                                i69 = i37;
                                                i75 = i38;
                                                z47 = z26;
                                                i76 = i39;
                                                z48 = z27;
                                                str30 = str17;
                                                str31 = str18;
                                                z49 = z28;
                                                z55 = z29;
                                                i77 = i46;
                                                i78 = i47;
                                                str32 = str19;
                                                z56 = z36;
                                                i79 = i48;
                                                i85 = 0;
                                                str33 = "useRGB2I420Shader";
                                                str34 = "switchMultiForceUseGroupAlertTip";
                                                z57 = z37;
                                                str35 = "videoTrackSoundSeparation";
                                                j3 = j16;
                                                z58 = z19;
                                                String str39222222 = str23;
                                                SharedPreferences.Editor edit222222 = d(287, f76962q).edit();
                                                edit222222.putInt("isBlueToothSwitch", i68);
                                                edit222222.putLong("bluetoothDelayTime", j3);
                                                edit222222.putBoolean("LowlightAndDenoiseDevice", z57);
                                                edit222222.putInt("multiVideoSupportNumbers", i65);
                                                edit222222.putInt("SpeedDialScreenStyle", i66);
                                                edit222222.putBoolean("switchMultiForceUseGroup", z46);
                                                edit222222.putBoolean(str6, i57 >= 1);
                                                edit222222.putString(str21, str39222222);
                                                edit222222.putString(str34, str26);
                                                edit222222.putInt(str33, i67);
                                                edit222222.putInt(str35, z58 ? 1 : 0);
                                                edit222222.putInt(str4, i58);
                                                edit222222.putString(str3, str22);
                                                edit222222.putString(str9, str25);
                                                edit222222.putString(str8, str27);
                                                edit222222.putString(str7, str24);
                                                edit222222.putBoolean("isAllowedControlMicAfterBeMuted", z38);
                                                edit222222.putString("machineMiddleLine", str28);
                                                edit222222.putString("machineHighLine", str29);
                                                edit222222.putInt("allowMicLongPressSpeakInMute", i69);
                                                i86 = i75;
                                                if (i86 != -1) {
                                                }
                                                edit222222.putInt("ScreenShareSwitch", i56);
                                                edit222222.putInt("AskScreenShareSwitch", z47 ? 1 : 0);
                                                i87 = i76;
                                                if (i87 != -1) {
                                                }
                                                if (!str32.isEmpty()) {
                                                }
                                                if (!str30.isEmpty()) {
                                                }
                                                if (!str31.isEmpty()) {
                                                }
                                                int i88222222 = i79;
                                                f76950e = i88222222;
                                                edit222222.putInt("davBubbleSwitch", i88222222);
                                                edit222222.putInt("880UIABTestOption", z48 ? 1 : 0);
                                                edit222222.putInt("880EffectUIABTestOption", z49 ? 1 : 0);
                                                edit222222.putInt("883Avatar2dEntranceABTestOption", z55 ? 1 : 0);
                                                edit222222.putInt("V7BeautyLowestSupportLevel", i49);
                                                edit222222.putBoolean("useHwDecLowLatency", i77 >= 1);
                                                edit222222.putBoolean("useHWEncCBR", i78 >= 1);
                                                edit222222.putBoolean("c2cServerConfig", i59 >= 1);
                                                edit222222.putBoolean("c2cQClear", z39 >= 1);
                                                edit222222.putInt("MoreFuc", z56 ? 1 : 0);
                                                edit222222.putInt("rollback8930UI", i85);
                                                edit222222.commit();
                                                if (QLog.isColorLevel()) {
                                                }
                                            }
                                        } catch (Exception e47) {
                                            e = e47;
                                            str8 = "ptuAfterTreamentLimit";
                                        }
                                        try {
                                            i19 = k(jSONObject, str6, 1);
                                            str11 = "networkSwitchJson";
                                            z16 = j17;
                                            str10 = " {\n        \"manufacture\": \"0\"\n}";
                                            try {
                                                m17 = m(jSONObject, str11, str10);
                                                try {
                                                    str15 = m(jSONObject, "machineMiddleLine", "");
                                                } catch (Exception e48) {
                                                    str2 = "QAVConfigUtils";
                                                    str3 = "ptuNewRenderLimit";
                                                    str4 = "upLoadWhenGetNewData";
                                                    i3 = 6;
                                                    z65 = false;
                                                    exc = e48;
                                                    str15 = "";
                                                    str16 = str15;
                                                }
                                            } catch (Exception e49) {
                                                str2 = "QAVConfigUtils";
                                                str3 = "ptuNewRenderLimit";
                                                str4 = "upLoadWhenGetNewData";
                                                str5 = "handleGetQAVGeneralConfig";
                                                i3 = 6;
                                                exc = e49;
                                                str15 = "";
                                                str16 = str15;
                                                str17 = str16;
                                                str18 = str17;
                                                str19 = str18;
                                                z17 = false;
                                                z26 = false;
                                                z27 = false;
                                                z28 = false;
                                                z29 = false;
                                                z36 = false;
                                            }
                                        } catch (Exception e56) {
                                            e = e56;
                                            str2 = "QAVConfigUtils";
                                            str3 = "ptuNewRenderLimit";
                                            str4 = "upLoadWhenGetNewData";
                                            str5 = "handleGetQAVGeneralConfig";
                                            str11 = "networkSwitchJson";
                                            i3 = 6;
                                            z16 = j17;
                                            str10 = " {\n        \"manufacture\": \"0\"\n}";
                                            exc = e;
                                            str15 = "";
                                            str16 = str15;
                                            str17 = str16;
                                            str18 = str17;
                                            str19 = str18;
                                            z17 = false;
                                            z26 = z17;
                                            z27 = z26;
                                            z28 = z27;
                                            z29 = z28;
                                            z36 = z29;
                                            str38 = m16;
                                            i17 = 1;
                                            i18 = 1;
                                            i19 = 1;
                                            i27 = 1;
                                            i37 = -1;
                                            i38 = -1;
                                            i39 = -1;
                                            i46 = 1;
                                            i47 = 1;
                                            if (QLog.isColorLevel()) {
                                            }
                                            i49 = i3;
                                            str21 = str11;
                                            str22 = str38;
                                            str23 = str10;
                                            i56 = i18;
                                            z38 = z16;
                                            i57 = i19;
                                            str24 = str12;
                                            z39 = z17;
                                            str25 = str13;
                                            i58 = i26;
                                            i59 = i27;
                                            i65 = i28;
                                            i66 = i16;
                                            z46 = z18;
                                            i67 = i29;
                                            str26 = str20;
                                            i68 = i36;
                                            str27 = str14;
                                            str28 = str15;
                                            str29 = str16;
                                            i69 = i37;
                                            i75 = i38;
                                            z47 = z26;
                                            i76 = i39;
                                            z48 = z27;
                                            str30 = str17;
                                            str31 = str18;
                                            z49 = z28;
                                            z55 = z29;
                                            i77 = i46;
                                            i78 = i47;
                                            str32 = str19;
                                            z56 = z36;
                                            i79 = i48;
                                            i85 = 0;
                                            str33 = "useRGB2I420Shader";
                                            str34 = "switchMultiForceUseGroupAlertTip";
                                            z57 = z37;
                                            str35 = "videoTrackSoundSeparation";
                                            j3 = j16;
                                            z58 = z19;
                                            String str392222222 = str23;
                                            SharedPreferences.Editor edit2222222 = d(287, f76962q).edit();
                                            edit2222222.putInt("isBlueToothSwitch", i68);
                                            edit2222222.putLong("bluetoothDelayTime", j3);
                                            edit2222222.putBoolean("LowlightAndDenoiseDevice", z57);
                                            edit2222222.putInt("multiVideoSupportNumbers", i65);
                                            edit2222222.putInt("SpeedDialScreenStyle", i66);
                                            edit2222222.putBoolean("switchMultiForceUseGroup", z46);
                                            edit2222222.putBoolean(str6, i57 >= 1);
                                            edit2222222.putString(str21, str392222222);
                                            edit2222222.putString(str34, str26);
                                            edit2222222.putInt(str33, i67);
                                            edit2222222.putInt(str35, z58 ? 1 : 0);
                                            edit2222222.putInt(str4, i58);
                                            edit2222222.putString(str3, str22);
                                            edit2222222.putString(str9, str25);
                                            edit2222222.putString(str8, str27);
                                            edit2222222.putString(str7, str24);
                                            edit2222222.putBoolean("isAllowedControlMicAfterBeMuted", z38);
                                            edit2222222.putString("machineMiddleLine", str28);
                                            edit2222222.putString("machineHighLine", str29);
                                            edit2222222.putInt("allowMicLongPressSpeakInMute", i69);
                                            i86 = i75;
                                            if (i86 != -1) {
                                            }
                                            edit2222222.putInt("ScreenShareSwitch", i56);
                                            edit2222222.putInt("AskScreenShareSwitch", z47 ? 1 : 0);
                                            i87 = i76;
                                            if (i87 != -1) {
                                            }
                                            if (!str32.isEmpty()) {
                                            }
                                            if (!str30.isEmpty()) {
                                            }
                                            if (!str31.isEmpty()) {
                                            }
                                            int i882222222 = i79;
                                            f76950e = i882222222;
                                            edit2222222.putInt("davBubbleSwitch", i882222222);
                                            edit2222222.putInt("880UIABTestOption", z48 ? 1 : 0);
                                            edit2222222.putInt("880EffectUIABTestOption", z49 ? 1 : 0);
                                            edit2222222.putInt("883Avatar2dEntranceABTestOption", z55 ? 1 : 0);
                                            edit2222222.putInt("V7BeautyLowestSupportLevel", i49);
                                            edit2222222.putBoolean("useHwDecLowLatency", i77 >= 1);
                                            edit2222222.putBoolean("useHWEncCBR", i78 >= 1);
                                            edit2222222.putBoolean("c2cServerConfig", i59 >= 1);
                                            edit2222222.putBoolean("c2cQClear", z39 >= 1);
                                            edit2222222.putInt("MoreFuc", z56 ? 1 : 0);
                                            edit2222222.putInt("rollback8930UI", i85);
                                            edit2222222.commit();
                                            if (QLog.isColorLevel()) {
                                            }
                                        }
                                    } catch (Exception e57) {
                                        str8 = "ptuAfterTreamentLimit";
                                        str2 = "QAVConfigUtils";
                                        str3 = "ptuNewRenderLimit";
                                        str4 = "upLoadWhenGetNewData";
                                        str5 = "handleGetQAVGeneralConfig";
                                        str6 = "enableNetworkSdk";
                                        str10 = " {\n        \"manufacture\": \"0\"\n}";
                                        i3 = 6;
                                        z59 = false;
                                        str11 = "networkSwitchJson";
                                        exc = e57;
                                        str15 = "";
                                        str16 = str15;
                                        str17 = str16;
                                        str18 = str17;
                                        str19 = str18;
                                        z16 = z59;
                                        z17 = z16;
                                        z26 = z17;
                                        z27 = z26;
                                        z28 = z27;
                                        z29 = z28;
                                        z36 = z29;
                                        str38 = m16;
                                        i17 = 1;
                                        i18 = 1;
                                        i19 = 1;
                                        i27 = 1;
                                        i37 = -1;
                                        i38 = -1;
                                        i39 = -1;
                                        i46 = 1;
                                        i47 = 1;
                                        if (QLog.isColorLevel()) {
                                        }
                                        i49 = i3;
                                        str21 = str11;
                                        str22 = str38;
                                        str23 = str10;
                                        i56 = i18;
                                        z38 = z16;
                                        i57 = i19;
                                        str24 = str12;
                                        z39 = z17;
                                        str25 = str13;
                                        i58 = i26;
                                        i59 = i27;
                                        i65 = i28;
                                        i66 = i16;
                                        z46 = z18;
                                        i67 = i29;
                                        str26 = str20;
                                        i68 = i36;
                                        str27 = str14;
                                        str28 = str15;
                                        str29 = str16;
                                        i69 = i37;
                                        i75 = i38;
                                        z47 = z26;
                                        i76 = i39;
                                        z48 = z27;
                                        str30 = str17;
                                        str31 = str18;
                                        z49 = z28;
                                        z55 = z29;
                                        i77 = i46;
                                        i78 = i47;
                                        str32 = str19;
                                        z56 = z36;
                                        i79 = i48;
                                        i85 = 0;
                                        str33 = "useRGB2I420Shader";
                                        str34 = "switchMultiForceUseGroupAlertTip";
                                        z57 = z37;
                                        str35 = "videoTrackSoundSeparation";
                                        j3 = j16;
                                        z58 = z19;
                                        String str3922222222 = str23;
                                        SharedPreferences.Editor edit22222222 = d(287, f76962q).edit();
                                        edit22222222.putInt("isBlueToothSwitch", i68);
                                        edit22222222.putLong("bluetoothDelayTime", j3);
                                        edit22222222.putBoolean("LowlightAndDenoiseDevice", z57);
                                        edit22222222.putInt("multiVideoSupportNumbers", i65);
                                        edit22222222.putInt("SpeedDialScreenStyle", i66);
                                        edit22222222.putBoolean("switchMultiForceUseGroup", z46);
                                        edit22222222.putBoolean(str6, i57 >= 1);
                                        edit22222222.putString(str21, str3922222222);
                                        edit22222222.putString(str34, str26);
                                        edit22222222.putInt(str33, i67);
                                        edit22222222.putInt(str35, z58 ? 1 : 0);
                                        edit22222222.putInt(str4, i58);
                                        edit22222222.putString(str3, str22);
                                        edit22222222.putString(str9, str25);
                                        edit22222222.putString(str8, str27);
                                        edit22222222.putString(str7, str24);
                                        edit22222222.putBoolean("isAllowedControlMicAfterBeMuted", z38);
                                        edit22222222.putString("machineMiddleLine", str28);
                                        edit22222222.putString("machineHighLine", str29);
                                        edit22222222.putInt("allowMicLongPressSpeakInMute", i69);
                                        i86 = i75;
                                        if (i86 != -1) {
                                        }
                                        edit22222222.putInt("ScreenShareSwitch", i56);
                                        edit22222222.putInt("AskScreenShareSwitch", z47 ? 1 : 0);
                                        i87 = i76;
                                        if (i87 != -1) {
                                        }
                                        if (!str32.isEmpty()) {
                                        }
                                        if (!str30.isEmpty()) {
                                        }
                                        if (!str31.isEmpty()) {
                                        }
                                        int i8822222222 = i79;
                                        f76950e = i8822222222;
                                        edit22222222.putInt("davBubbleSwitch", i8822222222);
                                        edit22222222.putInt("880UIABTestOption", z48 ? 1 : 0);
                                        edit22222222.putInt("880EffectUIABTestOption", z49 ? 1 : 0);
                                        edit22222222.putInt("883Avatar2dEntranceABTestOption", z55 ? 1 : 0);
                                        edit22222222.putInt("V7BeautyLowestSupportLevel", i49);
                                        edit22222222.putBoolean("useHwDecLowLatency", i77 >= 1);
                                        edit22222222.putBoolean("useHWEncCBR", i78 >= 1);
                                        edit22222222.putBoolean("c2cServerConfig", i59 >= 1);
                                        edit22222222.putBoolean("c2cQClear", z39 >= 1);
                                        edit22222222.putInt("MoreFuc", z56 ? 1 : 0);
                                        edit22222222.putInt("rollback8930UI", i85);
                                        edit22222222.commit();
                                        if (QLog.isColorLevel()) {
                                        }
                                    }
                                } catch (Exception e58) {
                                    str9 = "moreBtnTips";
                                    str2 = "QAVConfigUtils";
                                    z19 = k18;
                                    str3 = "ptuNewRenderLimit";
                                    str4 = "upLoadWhenGetNewData";
                                    i26 = k19;
                                    str5 = "handleGetQAVGeneralConfig";
                                    str11 = "networkSwitchJson";
                                    str6 = "enableNetworkSdk";
                                    str7 = "ptuAfterTreamentCanvas";
                                    str8 = "ptuAfterTreamentLimit";
                                    str10 = " {\n        \"manufacture\": \"0\"\n}";
                                    i3 = 6;
                                    z59 = false;
                                    exc = e58;
                                    str12 = "";
                                    str13 = str12;
                                    str14 = str13;
                                }
                            } catch (Exception e59) {
                                str2 = "QAVConfigUtils";
                                z19 = k18;
                                str3 = "ptuNewRenderLimit";
                                str4 = "upLoadWhenGetNewData";
                                str5 = "handleGetQAVGeneralConfig";
                                str11 = "networkSwitchJson";
                                str6 = "enableNetworkSdk";
                                str7 = "ptuAfterTreamentCanvas";
                                str8 = "ptuAfterTreamentLimit";
                                str9 = "moreBtnTips";
                                i3 = 6;
                                i26 = k19;
                                str10 = " {\n        \"manufacture\": \"0\"\n}";
                                exc = e59;
                                str12 = "";
                                str13 = str12;
                                str14 = str13;
                                str15 = str14;
                                str16 = str15;
                                str17 = str16;
                                str18 = str17;
                                str19 = str18;
                                z16 = false;
                                z17 = false;
                                z26 = false;
                                z27 = false;
                                z28 = false;
                                z29 = false;
                                z36 = false;
                            }
                        } catch (Exception e65) {
                            e = e65;
                            str2 = "QAVConfigUtils";
                            z19 = k18;
                            str3 = "ptuNewRenderLimit";
                            str4 = "upLoadWhenGetNewData";
                            str5 = "handleGetQAVGeneralConfig";
                            str11 = "networkSwitchJson";
                            str6 = "enableNetworkSdk";
                            str7 = "ptuAfterTreamentCanvas";
                            str8 = "ptuAfterTreamentLimit";
                            str9 = "moreBtnTips";
                            str10 = " {\n        \"manufacture\": \"0\"\n}";
                            i3 = 6;
                            exc = e;
                            str12 = "";
                            str13 = str12;
                            str14 = str13;
                            str15 = str14;
                            str16 = str15;
                            str17 = str16;
                            str18 = str17;
                            str19 = str18;
                            z16 = false;
                            z17 = false;
                            z26 = false;
                            z27 = z26;
                            z28 = z27;
                            z29 = z28;
                            z36 = z29;
                            i17 = 1;
                            i18 = 1;
                            i19 = 1;
                            i26 = -1;
                            i27 = 1;
                            i37 = -1;
                            i38 = -1;
                            i39 = -1;
                            i46 = 1;
                            i47 = 1;
                            if (QLog.isColorLevel()) {
                            }
                            i49 = i3;
                            str21 = str11;
                            str22 = str38;
                            str23 = str10;
                            i56 = i18;
                            z38 = z16;
                            i57 = i19;
                            str24 = str12;
                            z39 = z17;
                            str25 = str13;
                            i58 = i26;
                            i59 = i27;
                            i65 = i28;
                            i66 = i16;
                            z46 = z18;
                            i67 = i29;
                            str26 = str20;
                            i68 = i36;
                            str27 = str14;
                            str28 = str15;
                            str29 = str16;
                            i69 = i37;
                            i75 = i38;
                            z47 = z26;
                            i76 = i39;
                            z48 = z27;
                            str30 = str17;
                            str31 = str18;
                            z49 = z28;
                            z55 = z29;
                            i77 = i46;
                            i78 = i47;
                            str32 = str19;
                            z56 = z36;
                            i79 = i48;
                            i85 = 0;
                            str33 = "useRGB2I420Shader";
                            str34 = "switchMultiForceUseGroupAlertTip";
                            z57 = z37;
                            str35 = "videoTrackSoundSeparation";
                            j3 = j16;
                            z58 = z19;
                            String str39222222222 = str23;
                            SharedPreferences.Editor edit222222222 = d(287, f76962q).edit();
                            edit222222222.putInt("isBlueToothSwitch", i68);
                            edit222222222.putLong("bluetoothDelayTime", j3);
                            edit222222222.putBoolean("LowlightAndDenoiseDevice", z57);
                            edit222222222.putInt("multiVideoSupportNumbers", i65);
                            edit222222222.putInt("SpeedDialScreenStyle", i66);
                            edit222222222.putBoolean("switchMultiForceUseGroup", z46);
                            edit222222222.putBoolean(str6, i57 >= 1);
                            edit222222222.putString(str21, str39222222222);
                            edit222222222.putString(str34, str26);
                            edit222222222.putInt(str33, i67);
                            edit222222222.putInt(str35, z58 ? 1 : 0);
                            edit222222222.putInt(str4, i58);
                            edit222222222.putString(str3, str22);
                            edit222222222.putString(str9, str25);
                            edit222222222.putString(str8, str27);
                            edit222222222.putString(str7, str24);
                            edit222222222.putBoolean("isAllowedControlMicAfterBeMuted", z38);
                            edit222222222.putString("machineMiddleLine", str28);
                            edit222222222.putString("machineHighLine", str29);
                            edit222222222.putInt("allowMicLongPressSpeakInMute", i69);
                            i86 = i75;
                            if (i86 != -1) {
                            }
                            edit222222222.putInt("ScreenShareSwitch", i56);
                            edit222222222.putInt("AskScreenShareSwitch", z47 ? 1 : 0);
                            i87 = i76;
                            if (i87 != -1) {
                            }
                            if (!str32.isEmpty()) {
                            }
                            if (!str30.isEmpty()) {
                            }
                            if (!str31.isEmpty()) {
                            }
                            int i88222222222 = i79;
                            f76950e = i88222222222;
                            edit222222222.putInt("davBubbleSwitch", i88222222222);
                            edit222222222.putInt("880UIABTestOption", z48 ? 1 : 0);
                            edit222222222.putInt("880EffectUIABTestOption", z49 ? 1 : 0);
                            edit222222222.putInt("883Avatar2dEntranceABTestOption", z55 ? 1 : 0);
                            edit222222222.putInt("V7BeautyLowestSupportLevel", i49);
                            edit222222222.putBoolean("useHwDecLowLatency", i77 >= 1);
                            edit222222222.putBoolean("useHWEncCBR", i78 >= 1);
                            edit222222222.putBoolean("c2cServerConfig", i59 >= 1);
                            edit222222222.putBoolean("c2cQClear", z39 >= 1);
                            edit222222222.putInt("MoreFuc", z56 ? 1 : 0);
                            edit222222222.putInt("rollback8930UI", i85);
                            edit222222222.commit();
                            if (QLog.isColorLevel()) {
                            }
                        }
                    } catch (Exception e66) {
                        e = e66;
                        str2 = "QAVConfigUtils";
                        z19 = k18;
                        str3 = "ptuNewRenderLimit";
                        str4 = "upLoadWhenGetNewData";
                        i36 = k3;
                    }
                } catch (Exception e67) {
                    str2 = "QAVConfigUtils";
                    str3 = "ptuNewRenderLimit";
                    str4 = "upLoadWhenGetNewData";
                    i36 = k3;
                    str5 = "handleGetQAVGeneralConfig";
                    str11 = "networkSwitchJson";
                    str7 = "ptuAfterTreamentCanvas";
                    str8 = "ptuAfterTreamentLimit";
                    str9 = "moreBtnTips";
                    str10 = " {\n        \"manufacture\": \"0\"\n}";
                    i3 = 6;
                    str6 = "enableNetworkSdk";
                    exc = e67;
                    str12 = "";
                    str13 = str12;
                    str14 = str13;
                    str15 = str14;
                    str16 = str15;
                    str17 = str16;
                    str18 = str17;
                    str19 = str18;
                    z16 = false;
                    z17 = false;
                    z19 = false;
                    z26 = false;
                }
            } catch (Exception e68) {
                str2 = "QAVConfigUtils";
                str20 = m3;
                str3 = "ptuNewRenderLimit";
                str4 = "upLoadWhenGetNewData";
                i36 = k3;
                str5 = "handleGetQAVGeneralConfig";
                str11 = "networkSwitchJson";
                str6 = "enableNetworkSdk";
                str7 = "ptuAfterTreamentCanvas";
                str8 = "ptuAfterTreamentLimit";
                str9 = "moreBtnTips";
                str10 = " {\n        \"manufacture\": \"0\"\n}";
                i3 = 6;
                exc = e68;
                str12 = "";
                str13 = str12;
                str14 = str13;
                str15 = str14;
                str16 = str15;
                str17 = str16;
                str18 = str17;
                str19 = str18;
                z16 = false;
                z17 = false;
                z19 = false;
                z26 = false;
                z27 = false;
                z28 = false;
                z29 = false;
                z36 = false;
                i17 = 1;
                i18 = 1;
                i19 = 1;
                i26 = -1;
                i27 = 1;
                i29 = -1;
                i37 = -1;
                i38 = -1;
                i39 = -1;
                i46 = 1;
                i47 = 1;
                if (QLog.isColorLevel()) {
                }
                i49 = i3;
                str21 = str11;
                str22 = str38;
                str23 = str10;
                i56 = i18;
                z38 = z16;
                i57 = i19;
                str24 = str12;
                z39 = z17;
                str25 = str13;
                i58 = i26;
                i59 = i27;
                i65 = i28;
                i66 = i16;
                z46 = z18;
                i67 = i29;
                str26 = str20;
                i68 = i36;
                str27 = str14;
                str28 = str15;
                str29 = str16;
                i69 = i37;
                i75 = i38;
                z47 = z26;
                i76 = i39;
                z48 = z27;
                str30 = str17;
                str31 = str18;
                z49 = z28;
                z55 = z29;
                i77 = i46;
                i78 = i47;
                str32 = str19;
                z56 = z36;
                i79 = i48;
                i85 = 0;
                str33 = "useRGB2I420Shader";
                str34 = "switchMultiForceUseGroupAlertTip";
                z57 = z37;
                str35 = "videoTrackSoundSeparation";
                j3 = j16;
                z58 = z19;
                String str392222222222 = str23;
                SharedPreferences.Editor edit2222222222 = d(287, f76962q).edit();
                edit2222222222.putInt("isBlueToothSwitch", i68);
                edit2222222222.putLong("bluetoothDelayTime", j3);
                edit2222222222.putBoolean("LowlightAndDenoiseDevice", z57);
                edit2222222222.putInt("multiVideoSupportNumbers", i65);
                edit2222222222.putInt("SpeedDialScreenStyle", i66);
                edit2222222222.putBoolean("switchMultiForceUseGroup", z46);
                edit2222222222.putBoolean(str6, i57 >= 1);
                edit2222222222.putString(str21, str392222222222);
                edit2222222222.putString(str34, str26);
                edit2222222222.putInt(str33, i67);
                edit2222222222.putInt(str35, z58 ? 1 : 0);
                edit2222222222.putInt(str4, i58);
                edit2222222222.putString(str3, str22);
                edit2222222222.putString(str9, str25);
                edit2222222222.putString(str8, str27);
                edit2222222222.putString(str7, str24);
                edit2222222222.putBoolean("isAllowedControlMicAfterBeMuted", z38);
                edit2222222222.putString("machineMiddleLine", str28);
                edit2222222222.putString("machineHighLine", str29);
                edit2222222222.putInt("allowMicLongPressSpeakInMute", i69);
                i86 = i75;
                if (i86 != -1) {
                }
                edit2222222222.putInt("ScreenShareSwitch", i56);
                edit2222222222.putInt("AskScreenShareSwitch", z47 ? 1 : 0);
                i87 = i76;
                if (i87 != -1) {
                }
                if (!str32.isEmpty()) {
                }
                if (!str30.isEmpty()) {
                }
                if (!str31.isEmpty()) {
                }
                int i882222222222 = i79;
                f76950e = i882222222222;
                edit2222222222.putInt("davBubbleSwitch", i882222222222);
                edit2222222222.putInt("880UIABTestOption", z48 ? 1 : 0);
                edit2222222222.putInt("880EffectUIABTestOption", z49 ? 1 : 0);
                edit2222222222.putInt("883Avatar2dEntranceABTestOption", z55 ? 1 : 0);
                edit2222222222.putInt("V7BeautyLowestSupportLevel", i49);
                edit2222222222.putBoolean("useHwDecLowLatency", i77 >= 1);
                edit2222222222.putBoolean("useHWEncCBR", i78 >= 1);
                edit2222222222.putBoolean("c2cServerConfig", i59 >= 1);
                edit2222222222.putBoolean("c2cQClear", z39 >= 1);
                edit2222222222.putInt("MoreFuc", z56 ? 1 : 0);
                edit2222222222.putInt("rollback8930UI", i85);
                edit2222222222.commit();
                if (QLog.isColorLevel()) {
                }
            }
            try {
                str16 = m(jSONObject, "machineHighLine", "");
                str2 = "QAVConfigUtils";
                try {
                    i37 = k(jSONObject, "allowMicLongPressSpeakInMute", -1);
                    try {
                        i38 = k(jSONObject, "qavWatchTogetherSwitch", -1);
                        try {
                            int k26 = k(jSONObject, "ScreenShareSwitch", 1);
                            try {
                                StringBuilder sb8 = new StringBuilder();
                                str3 = "ptuNewRenderLimit";
                                try {
                                    sb8.append(" KEY_QAV_SCREEN_SHARE_SWITCH: ");
                                    sb8.append(k26);
                                    String sb9 = sb8.toString();
                                    str37 = "handleGetQAVGeneralConfig";
                                    i18 = k26;
                                    try {
                                        QLog.d(str37, 2, sb9);
                                        z66 = false;
                                        try {
                                            ?? k27 = k(jSONObject, "AskScreenShareSwitch", 0);
                                            try {
                                                ?? sb10 = new StringBuilder();
                                                str4 = "upLoadWhenGetNewData";
                                                try {
                                                    sb10.append(" KEY_QAV_SCREEN_SHARE_ASK_SWITCH: ");
                                                    sb10.append(k27);
                                                    QLog.d(str37, 2, sb10.toString());
                                                    int k28 = k(jSONObject, "avGameResultUseWebSwitch", -1);
                                                    z26 = k27;
                                                    try {
                                                        k16 = k(jSONObject, "davBubbleSwitch", 1);
                                                        i39 = k28;
                                                        try {
                                                            ?? k29 = k(jSONObject, "880UIABTestOption", 0);
                                                            try {
                                                                m18 = m(jSONObject, "screenShareTips", "");
                                                                z27 = k29;
                                                                try {
                                                                    str17 = m(jSONObject, "screenTipsHighlight", "");
                                                                    try {
                                                                        str18 = m(jSONObject, "screenTipsLink", "");
                                                                        try {
                                                                            z28 = k(jSONObject, "880EffectUIABTestOption", 0);
                                                                        } catch (Exception e69) {
                                                                            str19 = m18;
                                                                            i3 = 6;
                                                                            z67 = false;
                                                                            exc = e69;
                                                                            z17 = z67;
                                                                            z28 = z17;
                                                                            z29 = z28;
                                                                            z36 = z29;
                                                                            i17 = k16;
                                                                            str5 = str37;
                                                                            str10 = m17;
                                                                            str38 = m16;
                                                                            i27 = 1;
                                                                            i46 = 1;
                                                                            i47 = 1;
                                                                            if (QLog.isColorLevel()) {
                                                                            }
                                                                            i49 = i3;
                                                                            str21 = str11;
                                                                            str22 = str38;
                                                                            str23 = str10;
                                                                            i56 = i18;
                                                                            z38 = z16;
                                                                            i57 = i19;
                                                                            str24 = str12;
                                                                            z39 = z17;
                                                                            str25 = str13;
                                                                            i58 = i26;
                                                                            i59 = i27;
                                                                            i65 = i28;
                                                                            i66 = i16;
                                                                            z46 = z18;
                                                                            i67 = i29;
                                                                            str26 = str20;
                                                                            i68 = i36;
                                                                            str27 = str14;
                                                                            str28 = str15;
                                                                            str29 = str16;
                                                                            i69 = i37;
                                                                            i75 = i38;
                                                                            z47 = z26;
                                                                            i76 = i39;
                                                                            z48 = z27;
                                                                            str30 = str17;
                                                                            str31 = str18;
                                                                            z49 = z28;
                                                                            z55 = z29;
                                                                            i77 = i46;
                                                                            i78 = i47;
                                                                            str32 = str19;
                                                                            z56 = z36;
                                                                            i79 = i48;
                                                                            i85 = 0;
                                                                            str33 = "useRGB2I420Shader";
                                                                            str34 = "switchMultiForceUseGroupAlertTip";
                                                                            z57 = z37;
                                                                            str35 = "videoTrackSoundSeparation";
                                                                            j3 = j16;
                                                                            z58 = z19;
                                                                            String str3922222222222 = str23;
                                                                            SharedPreferences.Editor edit22222222222 = d(287, f76962q).edit();
                                                                            edit22222222222.putInt("isBlueToothSwitch", i68);
                                                                            edit22222222222.putLong("bluetoothDelayTime", j3);
                                                                            edit22222222222.putBoolean("LowlightAndDenoiseDevice", z57);
                                                                            edit22222222222.putInt("multiVideoSupportNumbers", i65);
                                                                            edit22222222222.putInt("SpeedDialScreenStyle", i66);
                                                                            edit22222222222.putBoolean("switchMultiForceUseGroup", z46);
                                                                            edit22222222222.putBoolean(str6, i57 >= 1);
                                                                            edit22222222222.putString(str21, str3922222222222);
                                                                            edit22222222222.putString(str34, str26);
                                                                            edit22222222222.putInt(str33, i67);
                                                                            edit22222222222.putInt(str35, z58 ? 1 : 0);
                                                                            edit22222222222.putInt(str4, i58);
                                                                            edit22222222222.putString(str3, str22);
                                                                            edit22222222222.putString(str9, str25);
                                                                            edit22222222222.putString(str8, str27);
                                                                            edit22222222222.putString(str7, str24);
                                                                            edit22222222222.putBoolean("isAllowedControlMicAfterBeMuted", z38);
                                                                            edit22222222222.putString("machineMiddleLine", str28);
                                                                            edit22222222222.putString("machineHighLine", str29);
                                                                            edit22222222222.putInt("allowMicLongPressSpeakInMute", i69);
                                                                            i86 = i75;
                                                                            if (i86 != -1) {
                                                                            }
                                                                            edit22222222222.putInt("ScreenShareSwitch", i56);
                                                                            edit22222222222.putInt("AskScreenShareSwitch", z47 ? 1 : 0);
                                                                            i87 = i76;
                                                                            if (i87 != -1) {
                                                                            }
                                                                            if (!str32.isEmpty()) {
                                                                            }
                                                                            if (!str30.isEmpty()) {
                                                                            }
                                                                            if (!str31.isEmpty()) {
                                                                            }
                                                                            int i8822222222222 = i79;
                                                                            f76950e = i8822222222222;
                                                                            edit22222222222.putInt("davBubbleSwitch", i8822222222222);
                                                                            edit22222222222.putInt("880UIABTestOption", z48 ? 1 : 0);
                                                                            edit22222222222.putInt("880EffectUIABTestOption", z49 ? 1 : 0);
                                                                            edit22222222222.putInt("883Avatar2dEntranceABTestOption", z55 ? 1 : 0);
                                                                            edit22222222222.putInt("V7BeautyLowestSupportLevel", i49);
                                                                            edit22222222222.putBoolean("useHwDecLowLatency", i77 >= 1);
                                                                            edit22222222222.putBoolean("useHWEncCBR", i78 >= 1);
                                                                            edit22222222222.putBoolean("c2cServerConfig", i59 >= 1);
                                                                            edit22222222222.putBoolean("c2cQClear", z39 >= 1);
                                                                            edit22222222222.putInt("MoreFuc", z56 ? 1 : 0);
                                                                            edit22222222222.putInt("rollback8930UI", i85);
                                                                            edit22222222222.commit();
                                                                            if (QLog.isColorLevel()) {
                                                                            }
                                                                        }
                                                                    } catch (Exception e75) {
                                                                        str19 = m18;
                                                                        i3 = 6;
                                                                        z67 = false;
                                                                        exc = e75;
                                                                        str18 = "";
                                                                    }
                                                                } catch (Exception e76) {
                                                                    str19 = m18;
                                                                    i3 = 6;
                                                                    z67 = false;
                                                                    exc = e76;
                                                                    str17 = "";
                                                                    str18 = str17;
                                                                }
                                                                try {
                                                                    z29 = k(jSONObject, "883Avatar2dEntranceABTestOption", 0);
                                                                    i3 = 6;
                                                                    try {
                                                                        k17 = k(jSONObject, "V7BeautyLowestSupportLevel", 6);
                                                                        try {
                                                                            i46 = k(jSONObject, "useHwDecLowLatency", 1);
                                                                        } catch (Exception e77) {
                                                                            e = e77;
                                                                            str19 = m18;
                                                                            z17 = false;
                                                                            z36 = false;
                                                                            i3 = k17;
                                                                            str38 = m16;
                                                                            i46 = 1;
                                                                        }
                                                                    } catch (Exception e78) {
                                                                        str19 = m18;
                                                                        exc = e78;
                                                                        z17 = false;
                                                                        z36 = false;
                                                                        i17 = k16;
                                                                        str5 = str37;
                                                                        str10 = m17;
                                                                        str38 = m16;
                                                                        i27 = 1;
                                                                        i46 = 1;
                                                                        i47 = 1;
                                                                        if (QLog.isColorLevel()) {
                                                                        }
                                                                        i49 = i3;
                                                                        str21 = str11;
                                                                        str22 = str38;
                                                                        str23 = str10;
                                                                        i56 = i18;
                                                                        z38 = z16;
                                                                        i57 = i19;
                                                                        str24 = str12;
                                                                        z39 = z17;
                                                                        str25 = str13;
                                                                        i58 = i26;
                                                                        i59 = i27;
                                                                        i65 = i28;
                                                                        i66 = i16;
                                                                        z46 = z18;
                                                                        i67 = i29;
                                                                        str26 = str20;
                                                                        i68 = i36;
                                                                        str27 = str14;
                                                                        str28 = str15;
                                                                        str29 = str16;
                                                                        i69 = i37;
                                                                        i75 = i38;
                                                                        z47 = z26;
                                                                        i76 = i39;
                                                                        z48 = z27;
                                                                        str30 = str17;
                                                                        str31 = str18;
                                                                        z49 = z28;
                                                                        z55 = z29;
                                                                        i77 = i46;
                                                                        i78 = i47;
                                                                        str32 = str19;
                                                                        z56 = z36;
                                                                        i79 = i48;
                                                                        i85 = 0;
                                                                        str33 = "useRGB2I420Shader";
                                                                        str34 = "switchMultiForceUseGroupAlertTip";
                                                                        z57 = z37;
                                                                        str35 = "videoTrackSoundSeparation";
                                                                        j3 = j16;
                                                                        z58 = z19;
                                                                        String str39222222222222 = str23;
                                                                        SharedPreferences.Editor edit222222222222 = d(287, f76962q).edit();
                                                                        edit222222222222.putInt("isBlueToothSwitch", i68);
                                                                        edit222222222222.putLong("bluetoothDelayTime", j3);
                                                                        edit222222222222.putBoolean("LowlightAndDenoiseDevice", z57);
                                                                        edit222222222222.putInt("multiVideoSupportNumbers", i65);
                                                                        edit222222222222.putInt("SpeedDialScreenStyle", i66);
                                                                        edit222222222222.putBoolean("switchMultiForceUseGroup", z46);
                                                                        edit222222222222.putBoolean(str6, i57 >= 1);
                                                                        edit222222222222.putString(str21, str39222222222222);
                                                                        edit222222222222.putString(str34, str26);
                                                                        edit222222222222.putInt(str33, i67);
                                                                        edit222222222222.putInt(str35, z58 ? 1 : 0);
                                                                        edit222222222222.putInt(str4, i58);
                                                                        edit222222222222.putString(str3, str22);
                                                                        edit222222222222.putString(str9, str25);
                                                                        edit222222222222.putString(str8, str27);
                                                                        edit222222222222.putString(str7, str24);
                                                                        edit222222222222.putBoolean("isAllowedControlMicAfterBeMuted", z38);
                                                                        edit222222222222.putString("machineMiddleLine", str28);
                                                                        edit222222222222.putString("machineHighLine", str29);
                                                                        edit222222222222.putInt("allowMicLongPressSpeakInMute", i69);
                                                                        i86 = i75;
                                                                        if (i86 != -1) {
                                                                        }
                                                                        edit222222222222.putInt("ScreenShareSwitch", i56);
                                                                        edit222222222222.putInt("AskScreenShareSwitch", z47 ? 1 : 0);
                                                                        i87 = i76;
                                                                        if (i87 != -1) {
                                                                        }
                                                                        if (!str32.isEmpty()) {
                                                                        }
                                                                        if (!str30.isEmpty()) {
                                                                        }
                                                                        if (!str31.isEmpty()) {
                                                                        }
                                                                        int i88222222222222 = i79;
                                                                        f76950e = i88222222222222;
                                                                        edit222222222222.putInt("davBubbleSwitch", i88222222222222);
                                                                        edit222222222222.putInt("880UIABTestOption", z48 ? 1 : 0);
                                                                        edit222222222222.putInt("880EffectUIABTestOption", z49 ? 1 : 0);
                                                                        edit222222222222.putInt("883Avatar2dEntranceABTestOption", z55 ? 1 : 0);
                                                                        edit222222222222.putInt("V7BeautyLowestSupportLevel", i49);
                                                                        edit222222222222.putBoolean("useHwDecLowLatency", i77 >= 1);
                                                                        edit222222222222.putBoolean("useHWEncCBR", i78 >= 1);
                                                                        edit222222222222.putBoolean("c2cServerConfig", i59 >= 1);
                                                                        edit222222222222.putBoolean("c2cQClear", z39 >= 1);
                                                                        edit222222222222.putInt("MoreFuc", z56 ? 1 : 0);
                                                                        edit222222222222.putInt("rollback8930UI", i85);
                                                                        edit222222222222.commit();
                                                                        if (QLog.isColorLevel()) {
                                                                        }
                                                                    }
                                                                } catch (Exception e79) {
                                                                    str19 = m18;
                                                                    i3 = 6;
                                                                    exc = e79;
                                                                    z17 = false;
                                                                    z29 = false;
                                                                    z36 = z29;
                                                                    i17 = k16;
                                                                    str5 = str37;
                                                                    str10 = m17;
                                                                    str38 = m16;
                                                                    i27 = 1;
                                                                    i46 = 1;
                                                                    i47 = 1;
                                                                    if (QLog.isColorLevel()) {
                                                                    }
                                                                    i49 = i3;
                                                                    str21 = str11;
                                                                    str22 = str38;
                                                                    str23 = str10;
                                                                    i56 = i18;
                                                                    z38 = z16;
                                                                    i57 = i19;
                                                                    str24 = str12;
                                                                    z39 = z17;
                                                                    str25 = str13;
                                                                    i58 = i26;
                                                                    i59 = i27;
                                                                    i65 = i28;
                                                                    i66 = i16;
                                                                    z46 = z18;
                                                                    i67 = i29;
                                                                    str26 = str20;
                                                                    i68 = i36;
                                                                    str27 = str14;
                                                                    str28 = str15;
                                                                    str29 = str16;
                                                                    i69 = i37;
                                                                    i75 = i38;
                                                                    z47 = z26;
                                                                    i76 = i39;
                                                                    z48 = z27;
                                                                    str30 = str17;
                                                                    str31 = str18;
                                                                    z49 = z28;
                                                                    z55 = z29;
                                                                    i77 = i46;
                                                                    i78 = i47;
                                                                    str32 = str19;
                                                                    z56 = z36;
                                                                    i79 = i48;
                                                                    i85 = 0;
                                                                    str33 = "useRGB2I420Shader";
                                                                    str34 = "switchMultiForceUseGroupAlertTip";
                                                                    z57 = z37;
                                                                    str35 = "videoTrackSoundSeparation";
                                                                    j3 = j16;
                                                                    z58 = z19;
                                                                    String str392222222222222 = str23;
                                                                    SharedPreferences.Editor edit2222222222222 = d(287, f76962q).edit();
                                                                    edit2222222222222.putInt("isBlueToothSwitch", i68);
                                                                    edit2222222222222.putLong("bluetoothDelayTime", j3);
                                                                    edit2222222222222.putBoolean("LowlightAndDenoiseDevice", z57);
                                                                    edit2222222222222.putInt("multiVideoSupportNumbers", i65);
                                                                    edit2222222222222.putInt("SpeedDialScreenStyle", i66);
                                                                    edit2222222222222.putBoolean("switchMultiForceUseGroup", z46);
                                                                    edit2222222222222.putBoolean(str6, i57 >= 1);
                                                                    edit2222222222222.putString(str21, str392222222222222);
                                                                    edit2222222222222.putString(str34, str26);
                                                                    edit2222222222222.putInt(str33, i67);
                                                                    edit2222222222222.putInt(str35, z58 ? 1 : 0);
                                                                    edit2222222222222.putInt(str4, i58);
                                                                    edit2222222222222.putString(str3, str22);
                                                                    edit2222222222222.putString(str9, str25);
                                                                    edit2222222222222.putString(str8, str27);
                                                                    edit2222222222222.putString(str7, str24);
                                                                    edit2222222222222.putBoolean("isAllowedControlMicAfterBeMuted", z38);
                                                                    edit2222222222222.putString("machineMiddleLine", str28);
                                                                    edit2222222222222.putString("machineHighLine", str29);
                                                                    edit2222222222222.putInt("allowMicLongPressSpeakInMute", i69);
                                                                    i86 = i75;
                                                                    if (i86 != -1) {
                                                                    }
                                                                    edit2222222222222.putInt("ScreenShareSwitch", i56);
                                                                    edit2222222222222.putInt("AskScreenShareSwitch", z47 ? 1 : 0);
                                                                    i87 = i76;
                                                                    if (i87 != -1) {
                                                                    }
                                                                    if (!str32.isEmpty()) {
                                                                    }
                                                                    if (!str30.isEmpty()) {
                                                                    }
                                                                    if (!str31.isEmpty()) {
                                                                    }
                                                                    int i882222222222222 = i79;
                                                                    f76950e = i882222222222222;
                                                                    edit2222222222222.putInt("davBubbleSwitch", i882222222222222);
                                                                    edit2222222222222.putInt("880UIABTestOption", z48 ? 1 : 0);
                                                                    edit2222222222222.putInt("880EffectUIABTestOption", z49 ? 1 : 0);
                                                                    edit2222222222222.putInt("883Avatar2dEntranceABTestOption", z55 ? 1 : 0);
                                                                    edit2222222222222.putInt("V7BeautyLowestSupportLevel", i49);
                                                                    edit2222222222222.putBoolean("useHwDecLowLatency", i77 >= 1);
                                                                    edit2222222222222.putBoolean("useHWEncCBR", i78 >= 1);
                                                                    edit2222222222222.putBoolean("c2cServerConfig", i59 >= 1);
                                                                    edit2222222222222.putBoolean("c2cQClear", z39 >= 1);
                                                                    edit2222222222222.putInt("MoreFuc", z56 ? 1 : 0);
                                                                    edit2222222222222.putInt("rollback8930UI", i85);
                                                                    edit2222222222222.commit();
                                                                    if (QLog.isColorLevel()) {
                                                                    }
                                                                }
                                                            } catch (Exception e85) {
                                                                z27 = k29;
                                                                i3 = 6;
                                                                z67 = false;
                                                                exc = e85;
                                                                str17 = "";
                                                                str18 = str17;
                                                                str19 = str18;
                                                            }
                                                        } catch (Exception e86) {
                                                            i3 = 6;
                                                            exc = e86;
                                                            str17 = "";
                                                            str18 = str17;
                                                            str19 = str18;
                                                            z17 = false;
                                                            z27 = false;
                                                            z28 = false;
                                                        }
                                                    } catch (Exception e87) {
                                                        i39 = k28;
                                                        i3 = 6;
                                                        exc = e87;
                                                        str17 = "";
                                                        str18 = str17;
                                                        str19 = str18;
                                                        z17 = false;
                                                        z27 = false;
                                                        z28 = false;
                                                        z29 = false;
                                                        z36 = false;
                                                        str5 = str37;
                                                        str10 = m17;
                                                        str38 = m16;
                                                        i17 = 1;
                                                    }
                                                } catch (Exception e88) {
                                                    e = e88;
                                                    z26 = k27;
                                                    i3 = 6;
                                                    exc = e;
                                                    str17 = "";
                                                    str18 = str17;
                                                    str19 = str18;
                                                    z17 = false;
                                                    z27 = false;
                                                    z28 = z27;
                                                    z29 = z28;
                                                    z36 = z29;
                                                    str5 = str37;
                                                    str10 = m17;
                                                    str38 = m16;
                                                    i17 = 1;
                                                    i27 = 1;
                                                    i39 = -1;
                                                    i46 = 1;
                                                    i47 = 1;
                                                    if (QLog.isColorLevel()) {
                                                    }
                                                    i49 = i3;
                                                    str21 = str11;
                                                    str22 = str38;
                                                    str23 = str10;
                                                    i56 = i18;
                                                    z38 = z16;
                                                    i57 = i19;
                                                    str24 = str12;
                                                    z39 = z17;
                                                    str25 = str13;
                                                    i58 = i26;
                                                    i59 = i27;
                                                    i65 = i28;
                                                    i66 = i16;
                                                    z46 = z18;
                                                    i67 = i29;
                                                    str26 = str20;
                                                    i68 = i36;
                                                    str27 = str14;
                                                    str28 = str15;
                                                    str29 = str16;
                                                    i69 = i37;
                                                    i75 = i38;
                                                    z47 = z26;
                                                    i76 = i39;
                                                    z48 = z27;
                                                    str30 = str17;
                                                    str31 = str18;
                                                    z49 = z28;
                                                    z55 = z29;
                                                    i77 = i46;
                                                    i78 = i47;
                                                    str32 = str19;
                                                    z56 = z36;
                                                    i79 = i48;
                                                    i85 = 0;
                                                    str33 = "useRGB2I420Shader";
                                                    str34 = "switchMultiForceUseGroupAlertTip";
                                                    z57 = z37;
                                                    str35 = "videoTrackSoundSeparation";
                                                    j3 = j16;
                                                    z58 = z19;
                                                    String str3922222222222222 = str23;
                                                    SharedPreferences.Editor edit22222222222222 = d(287, f76962q).edit();
                                                    edit22222222222222.putInt("isBlueToothSwitch", i68);
                                                    edit22222222222222.putLong("bluetoothDelayTime", j3);
                                                    edit22222222222222.putBoolean("LowlightAndDenoiseDevice", z57);
                                                    edit22222222222222.putInt("multiVideoSupportNumbers", i65);
                                                    edit22222222222222.putInt("SpeedDialScreenStyle", i66);
                                                    edit22222222222222.putBoolean("switchMultiForceUseGroup", z46);
                                                    edit22222222222222.putBoolean(str6, i57 >= 1);
                                                    edit22222222222222.putString(str21, str3922222222222222);
                                                    edit22222222222222.putString(str34, str26);
                                                    edit22222222222222.putInt(str33, i67);
                                                    edit22222222222222.putInt(str35, z58 ? 1 : 0);
                                                    edit22222222222222.putInt(str4, i58);
                                                    edit22222222222222.putString(str3, str22);
                                                    edit22222222222222.putString(str9, str25);
                                                    edit22222222222222.putString(str8, str27);
                                                    edit22222222222222.putString(str7, str24);
                                                    edit22222222222222.putBoolean("isAllowedControlMicAfterBeMuted", z38);
                                                    edit22222222222222.putString("machineMiddleLine", str28);
                                                    edit22222222222222.putString("machineHighLine", str29);
                                                    edit22222222222222.putInt("allowMicLongPressSpeakInMute", i69);
                                                    i86 = i75;
                                                    if (i86 != -1) {
                                                    }
                                                    edit22222222222222.putInt("ScreenShareSwitch", i56);
                                                    edit22222222222222.putInt("AskScreenShareSwitch", z47 ? 1 : 0);
                                                    i87 = i76;
                                                    if (i87 != -1) {
                                                    }
                                                    if (!str32.isEmpty()) {
                                                    }
                                                    if (!str30.isEmpty()) {
                                                    }
                                                    if (!str31.isEmpty()) {
                                                    }
                                                    int i8822222222222222 = i79;
                                                    f76950e = i8822222222222222;
                                                    edit22222222222222.putInt("davBubbleSwitch", i8822222222222222);
                                                    edit22222222222222.putInt("880UIABTestOption", z48 ? 1 : 0);
                                                    edit22222222222222.putInt("880EffectUIABTestOption", z49 ? 1 : 0);
                                                    edit22222222222222.putInt("883Avatar2dEntranceABTestOption", z55 ? 1 : 0);
                                                    edit22222222222222.putInt("V7BeautyLowestSupportLevel", i49);
                                                    edit22222222222222.putBoolean("useHwDecLowLatency", i77 >= 1);
                                                    edit22222222222222.putBoolean("useHWEncCBR", i78 >= 1);
                                                    edit22222222222222.putBoolean("c2cServerConfig", i59 >= 1);
                                                    edit22222222222222.putBoolean("c2cQClear", z39 >= 1);
                                                    edit22222222222222.putInt("MoreFuc", z56 ? 1 : 0);
                                                    edit22222222222222.putInt("rollback8930UI", i85);
                                                    edit22222222222222.commit();
                                                    if (QLog.isColorLevel()) {
                                                    }
                                                }
                                            } catch (Exception e89) {
                                                e = e89;
                                                z26 = k27;
                                                str4 = "upLoadWhenGetNewData";
                                            }
                                        } catch (Exception e95) {
                                            e = e95;
                                            str4 = "upLoadWhenGetNewData";
                                            i3 = 6;
                                            exc = e;
                                            str17 = "";
                                            str18 = str17;
                                            str19 = str18;
                                            z17 = z66;
                                            z26 = z17;
                                            z27 = z26;
                                            z28 = z27;
                                            z29 = z28;
                                            z36 = z29;
                                            str5 = str37;
                                            str10 = m17;
                                            str38 = m16;
                                            i17 = 1;
                                            i27 = 1;
                                            i39 = -1;
                                            i46 = 1;
                                            i47 = 1;
                                            if (QLog.isColorLevel()) {
                                            }
                                            i49 = i3;
                                            str21 = str11;
                                            str22 = str38;
                                            str23 = str10;
                                            i56 = i18;
                                            z38 = z16;
                                            i57 = i19;
                                            str24 = str12;
                                            z39 = z17;
                                            str25 = str13;
                                            i58 = i26;
                                            i59 = i27;
                                            i65 = i28;
                                            i66 = i16;
                                            z46 = z18;
                                            i67 = i29;
                                            str26 = str20;
                                            i68 = i36;
                                            str27 = str14;
                                            str28 = str15;
                                            str29 = str16;
                                            i69 = i37;
                                            i75 = i38;
                                            z47 = z26;
                                            i76 = i39;
                                            z48 = z27;
                                            str30 = str17;
                                            str31 = str18;
                                            z49 = z28;
                                            z55 = z29;
                                            i77 = i46;
                                            i78 = i47;
                                            str32 = str19;
                                            z56 = z36;
                                            i79 = i48;
                                            i85 = 0;
                                            str33 = "useRGB2I420Shader";
                                            str34 = "switchMultiForceUseGroupAlertTip";
                                            z57 = z37;
                                            str35 = "videoTrackSoundSeparation";
                                            j3 = j16;
                                            z58 = z19;
                                            String str39222222222222222 = str23;
                                            SharedPreferences.Editor edit222222222222222 = d(287, f76962q).edit();
                                            edit222222222222222.putInt("isBlueToothSwitch", i68);
                                            edit222222222222222.putLong("bluetoothDelayTime", j3);
                                            edit222222222222222.putBoolean("LowlightAndDenoiseDevice", z57);
                                            edit222222222222222.putInt("multiVideoSupportNumbers", i65);
                                            edit222222222222222.putInt("SpeedDialScreenStyle", i66);
                                            edit222222222222222.putBoolean("switchMultiForceUseGroup", z46);
                                            edit222222222222222.putBoolean(str6, i57 >= 1);
                                            edit222222222222222.putString(str21, str39222222222222222);
                                            edit222222222222222.putString(str34, str26);
                                            edit222222222222222.putInt(str33, i67);
                                            edit222222222222222.putInt(str35, z58 ? 1 : 0);
                                            edit222222222222222.putInt(str4, i58);
                                            edit222222222222222.putString(str3, str22);
                                            edit222222222222222.putString(str9, str25);
                                            edit222222222222222.putString(str8, str27);
                                            edit222222222222222.putString(str7, str24);
                                            edit222222222222222.putBoolean("isAllowedControlMicAfterBeMuted", z38);
                                            edit222222222222222.putString("machineMiddleLine", str28);
                                            edit222222222222222.putString("machineHighLine", str29);
                                            edit222222222222222.putInt("allowMicLongPressSpeakInMute", i69);
                                            i86 = i75;
                                            if (i86 != -1) {
                                            }
                                            edit222222222222222.putInt("ScreenShareSwitch", i56);
                                            edit222222222222222.putInt("AskScreenShareSwitch", z47 ? 1 : 0);
                                            i87 = i76;
                                            if (i87 != -1) {
                                            }
                                            if (!str32.isEmpty()) {
                                            }
                                            if (!str30.isEmpty()) {
                                            }
                                            if (!str31.isEmpty()) {
                                            }
                                            int i88222222222222222 = i79;
                                            f76950e = i88222222222222222;
                                            edit222222222222222.putInt("davBubbleSwitch", i88222222222222222);
                                            edit222222222222222.putInt("880UIABTestOption", z48 ? 1 : 0);
                                            edit222222222222222.putInt("880EffectUIABTestOption", z49 ? 1 : 0);
                                            edit222222222222222.putInt("883Avatar2dEntranceABTestOption", z55 ? 1 : 0);
                                            edit222222222222222.putInt("V7BeautyLowestSupportLevel", i49);
                                            edit222222222222222.putBoolean("useHwDecLowLatency", i77 >= 1);
                                            edit222222222222222.putBoolean("useHWEncCBR", i78 >= 1);
                                            edit222222222222222.putBoolean("c2cServerConfig", i59 >= 1);
                                            edit222222222222222.putBoolean("c2cQClear", z39 >= 1);
                                            edit222222222222222.putInt("MoreFuc", z56 ? 1 : 0);
                                            edit222222222222222.putInt("rollback8930UI", i85);
                                            edit222222222222222.commit();
                                            if (QLog.isColorLevel()) {
                                            }
                                        }
                                    } catch (Exception e96) {
                                        e = e96;
                                        str4 = "upLoadWhenGetNewData";
                                        i3 = 6;
                                        z66 = false;
                                        exc = e;
                                        str17 = "";
                                        str18 = str17;
                                        str19 = str18;
                                        z17 = z66;
                                        z26 = z17;
                                        z27 = z26;
                                        z28 = z27;
                                        z29 = z28;
                                        z36 = z29;
                                        str5 = str37;
                                        str10 = m17;
                                        str38 = m16;
                                        i17 = 1;
                                        i27 = 1;
                                        i39 = -1;
                                        i46 = 1;
                                        i47 = 1;
                                        if (QLog.isColorLevel()) {
                                        }
                                        i49 = i3;
                                        str21 = str11;
                                        str22 = str38;
                                        str23 = str10;
                                        i56 = i18;
                                        z38 = z16;
                                        i57 = i19;
                                        str24 = str12;
                                        z39 = z17;
                                        str25 = str13;
                                        i58 = i26;
                                        i59 = i27;
                                        i65 = i28;
                                        i66 = i16;
                                        z46 = z18;
                                        i67 = i29;
                                        str26 = str20;
                                        i68 = i36;
                                        str27 = str14;
                                        str28 = str15;
                                        str29 = str16;
                                        i69 = i37;
                                        i75 = i38;
                                        z47 = z26;
                                        i76 = i39;
                                        z48 = z27;
                                        str30 = str17;
                                        str31 = str18;
                                        z49 = z28;
                                        z55 = z29;
                                        i77 = i46;
                                        i78 = i47;
                                        str32 = str19;
                                        z56 = z36;
                                        i79 = i48;
                                        i85 = 0;
                                        str33 = "useRGB2I420Shader";
                                        str34 = "switchMultiForceUseGroupAlertTip";
                                        z57 = z37;
                                        str35 = "videoTrackSoundSeparation";
                                        j3 = j16;
                                        z58 = z19;
                                        String str392222222222222222 = str23;
                                        SharedPreferences.Editor edit2222222222222222 = d(287, f76962q).edit();
                                        edit2222222222222222.putInt("isBlueToothSwitch", i68);
                                        edit2222222222222222.putLong("bluetoothDelayTime", j3);
                                        edit2222222222222222.putBoolean("LowlightAndDenoiseDevice", z57);
                                        edit2222222222222222.putInt("multiVideoSupportNumbers", i65);
                                        edit2222222222222222.putInt("SpeedDialScreenStyle", i66);
                                        edit2222222222222222.putBoolean("switchMultiForceUseGroup", z46);
                                        edit2222222222222222.putBoolean(str6, i57 >= 1);
                                        edit2222222222222222.putString(str21, str392222222222222222);
                                        edit2222222222222222.putString(str34, str26);
                                        edit2222222222222222.putInt(str33, i67);
                                        edit2222222222222222.putInt(str35, z58 ? 1 : 0);
                                        edit2222222222222222.putInt(str4, i58);
                                        edit2222222222222222.putString(str3, str22);
                                        edit2222222222222222.putString(str9, str25);
                                        edit2222222222222222.putString(str8, str27);
                                        edit2222222222222222.putString(str7, str24);
                                        edit2222222222222222.putBoolean("isAllowedControlMicAfterBeMuted", z38);
                                        edit2222222222222222.putString("machineMiddleLine", str28);
                                        edit2222222222222222.putString("machineHighLine", str29);
                                        edit2222222222222222.putInt("allowMicLongPressSpeakInMute", i69);
                                        i86 = i75;
                                        if (i86 != -1) {
                                        }
                                        edit2222222222222222.putInt("ScreenShareSwitch", i56);
                                        edit2222222222222222.putInt("AskScreenShareSwitch", z47 ? 1 : 0);
                                        i87 = i76;
                                        if (i87 != -1) {
                                        }
                                        if (!str32.isEmpty()) {
                                        }
                                        if (!str30.isEmpty()) {
                                        }
                                        if (!str31.isEmpty()) {
                                        }
                                        int i882222222222222222 = i79;
                                        f76950e = i882222222222222222;
                                        edit2222222222222222.putInt("davBubbleSwitch", i882222222222222222);
                                        edit2222222222222222.putInt("880UIABTestOption", z48 ? 1 : 0);
                                        edit2222222222222222.putInt("880EffectUIABTestOption", z49 ? 1 : 0);
                                        edit2222222222222222.putInt("883Avatar2dEntranceABTestOption", z55 ? 1 : 0);
                                        edit2222222222222222.putInt("V7BeautyLowestSupportLevel", i49);
                                        edit2222222222222222.putBoolean("useHwDecLowLatency", i77 >= 1);
                                        edit2222222222222222.putBoolean("useHWEncCBR", i78 >= 1);
                                        edit2222222222222222.putBoolean("c2cServerConfig", i59 >= 1);
                                        edit2222222222222222.putBoolean("c2cQClear", z39 >= 1);
                                        edit2222222222222222.putInt("MoreFuc", z56 ? 1 : 0);
                                        edit2222222222222222.putInt("rollback8930UI", i85);
                                        edit2222222222222222.commit();
                                        if (QLog.isColorLevel()) {
                                        }
                                    }
                                } catch (Exception e97) {
                                    e = e97;
                                    str4 = "upLoadWhenGetNewData";
                                    str37 = "handleGetQAVGeneralConfig";
                                    z66 = false;
                                    i18 = k26;
                                    i3 = 6;
                                    exc = e;
                                    str17 = "";
                                    str18 = str17;
                                    str19 = str18;
                                    z17 = z66;
                                    z26 = z17;
                                    z27 = z26;
                                    z28 = z27;
                                    z29 = z28;
                                    z36 = z29;
                                    str5 = str37;
                                    str10 = m17;
                                    str38 = m16;
                                    i17 = 1;
                                    i27 = 1;
                                    i39 = -1;
                                    i46 = 1;
                                    i47 = 1;
                                    if (QLog.isColorLevel()) {
                                    }
                                    i49 = i3;
                                    str21 = str11;
                                    str22 = str38;
                                    str23 = str10;
                                    i56 = i18;
                                    z38 = z16;
                                    i57 = i19;
                                    str24 = str12;
                                    z39 = z17;
                                    str25 = str13;
                                    i58 = i26;
                                    i59 = i27;
                                    i65 = i28;
                                    i66 = i16;
                                    z46 = z18;
                                    i67 = i29;
                                    str26 = str20;
                                    i68 = i36;
                                    str27 = str14;
                                    str28 = str15;
                                    str29 = str16;
                                    i69 = i37;
                                    i75 = i38;
                                    z47 = z26;
                                    i76 = i39;
                                    z48 = z27;
                                    str30 = str17;
                                    str31 = str18;
                                    z49 = z28;
                                    z55 = z29;
                                    i77 = i46;
                                    i78 = i47;
                                    str32 = str19;
                                    z56 = z36;
                                    i79 = i48;
                                    i85 = 0;
                                    str33 = "useRGB2I420Shader";
                                    str34 = "switchMultiForceUseGroupAlertTip";
                                    z57 = z37;
                                    str35 = "videoTrackSoundSeparation";
                                    j3 = j16;
                                    z58 = z19;
                                    String str3922222222222222222 = str23;
                                    SharedPreferences.Editor edit22222222222222222 = d(287, f76962q).edit();
                                    edit22222222222222222.putInt("isBlueToothSwitch", i68);
                                    edit22222222222222222.putLong("bluetoothDelayTime", j3);
                                    edit22222222222222222.putBoolean("LowlightAndDenoiseDevice", z57);
                                    edit22222222222222222.putInt("multiVideoSupportNumbers", i65);
                                    edit22222222222222222.putInt("SpeedDialScreenStyle", i66);
                                    edit22222222222222222.putBoolean("switchMultiForceUseGroup", z46);
                                    edit22222222222222222.putBoolean(str6, i57 >= 1);
                                    edit22222222222222222.putString(str21, str3922222222222222222);
                                    edit22222222222222222.putString(str34, str26);
                                    edit22222222222222222.putInt(str33, i67);
                                    edit22222222222222222.putInt(str35, z58 ? 1 : 0);
                                    edit22222222222222222.putInt(str4, i58);
                                    edit22222222222222222.putString(str3, str22);
                                    edit22222222222222222.putString(str9, str25);
                                    edit22222222222222222.putString(str8, str27);
                                    edit22222222222222222.putString(str7, str24);
                                    edit22222222222222222.putBoolean("isAllowedControlMicAfterBeMuted", z38);
                                    edit22222222222222222.putString("machineMiddleLine", str28);
                                    edit22222222222222222.putString("machineHighLine", str29);
                                    edit22222222222222222.putInt("allowMicLongPressSpeakInMute", i69);
                                    i86 = i75;
                                    if (i86 != -1) {
                                    }
                                    edit22222222222222222.putInt("ScreenShareSwitch", i56);
                                    edit22222222222222222.putInt("AskScreenShareSwitch", z47 ? 1 : 0);
                                    i87 = i76;
                                    if (i87 != -1) {
                                    }
                                    if (!str32.isEmpty()) {
                                    }
                                    if (!str30.isEmpty()) {
                                    }
                                    if (!str31.isEmpty()) {
                                    }
                                    int i8822222222222222222 = i79;
                                    f76950e = i8822222222222222222;
                                    edit22222222222222222.putInt("davBubbleSwitch", i8822222222222222222);
                                    edit22222222222222222.putInt("880UIABTestOption", z48 ? 1 : 0);
                                    edit22222222222222222.putInt("880EffectUIABTestOption", z49 ? 1 : 0);
                                    edit22222222222222222.putInt("883Avatar2dEntranceABTestOption", z55 ? 1 : 0);
                                    edit22222222222222222.putInt("V7BeautyLowestSupportLevel", i49);
                                    edit22222222222222222.putBoolean("useHwDecLowLatency", i77 >= 1);
                                    edit22222222222222222.putBoolean("useHWEncCBR", i78 >= 1);
                                    edit22222222222222222.putBoolean("c2cServerConfig", i59 >= 1);
                                    edit22222222222222222.putBoolean("c2cQClear", z39 >= 1);
                                    edit22222222222222222.putInt("MoreFuc", z56 ? 1 : 0);
                                    edit22222222222222222.putInt("rollback8930UI", i85);
                                    edit22222222222222222.commit();
                                    if (QLog.isColorLevel()) {
                                    }
                                }
                            } catch (Exception e98) {
                                e = e98;
                                str3 = "ptuNewRenderLimit";
                            }
                        } catch (Exception e99) {
                            str3 = "ptuNewRenderLimit";
                            str4 = "upLoadWhenGetNewData";
                            i3 = 6;
                            exc = e99;
                            str17 = "";
                            str18 = str17;
                            str19 = str18;
                            z17 = false;
                            z26 = false;
                            z27 = false;
                            z28 = false;
                            z29 = false;
                            z36 = false;
                            str5 = "handleGetQAVGeneralConfig";
                            str10 = m17;
                            str38 = m16;
                            i17 = 1;
                            i18 = 1;
                        }
                    } catch (Exception e100) {
                        str3 = "ptuNewRenderLimit";
                        str4 = "upLoadWhenGetNewData";
                        i3 = 6;
                        exc = e100;
                        str17 = "";
                        str18 = str17;
                        str19 = str18;
                        z17 = false;
                        z26 = false;
                        z27 = false;
                        z28 = false;
                        z29 = false;
                        z36 = false;
                        str5 = "handleGetQAVGeneralConfig";
                        str10 = m17;
                        str38 = m16;
                        i17 = 1;
                        i18 = 1;
                        i27 = 1;
                        i38 = -1;
                        i39 = -1;
                        i46 = 1;
                        i47 = 1;
                        if (QLog.isColorLevel()) {
                        }
                        i49 = i3;
                        str21 = str11;
                        str22 = str38;
                        str23 = str10;
                        i56 = i18;
                        z38 = z16;
                        i57 = i19;
                        str24 = str12;
                        z39 = z17;
                        str25 = str13;
                        i58 = i26;
                        i59 = i27;
                        i65 = i28;
                        i66 = i16;
                        z46 = z18;
                        i67 = i29;
                        str26 = str20;
                        i68 = i36;
                        str27 = str14;
                        str28 = str15;
                        str29 = str16;
                        i69 = i37;
                        i75 = i38;
                        z47 = z26;
                        i76 = i39;
                        z48 = z27;
                        str30 = str17;
                        str31 = str18;
                        z49 = z28;
                        z55 = z29;
                        i77 = i46;
                        i78 = i47;
                        str32 = str19;
                        z56 = z36;
                        i79 = i48;
                        i85 = 0;
                        str33 = "useRGB2I420Shader";
                        str34 = "switchMultiForceUseGroupAlertTip";
                        z57 = z37;
                        str35 = "videoTrackSoundSeparation";
                        j3 = j16;
                        z58 = z19;
                        String str39222222222222222222 = str23;
                        SharedPreferences.Editor edit222222222222222222 = d(287, f76962q).edit();
                        edit222222222222222222.putInt("isBlueToothSwitch", i68);
                        edit222222222222222222.putLong("bluetoothDelayTime", j3);
                        edit222222222222222222.putBoolean("LowlightAndDenoiseDevice", z57);
                        edit222222222222222222.putInt("multiVideoSupportNumbers", i65);
                        edit222222222222222222.putInt("SpeedDialScreenStyle", i66);
                        edit222222222222222222.putBoolean("switchMultiForceUseGroup", z46);
                        edit222222222222222222.putBoolean(str6, i57 >= 1);
                        edit222222222222222222.putString(str21, str39222222222222222222);
                        edit222222222222222222.putString(str34, str26);
                        edit222222222222222222.putInt(str33, i67);
                        edit222222222222222222.putInt(str35, z58 ? 1 : 0);
                        edit222222222222222222.putInt(str4, i58);
                        edit222222222222222222.putString(str3, str22);
                        edit222222222222222222.putString(str9, str25);
                        edit222222222222222222.putString(str8, str27);
                        edit222222222222222222.putString(str7, str24);
                        edit222222222222222222.putBoolean("isAllowedControlMicAfterBeMuted", z38);
                        edit222222222222222222.putString("machineMiddleLine", str28);
                        edit222222222222222222.putString("machineHighLine", str29);
                        edit222222222222222222.putInt("allowMicLongPressSpeakInMute", i69);
                        i86 = i75;
                        if (i86 != -1) {
                        }
                        edit222222222222222222.putInt("ScreenShareSwitch", i56);
                        edit222222222222222222.putInt("AskScreenShareSwitch", z47 ? 1 : 0);
                        i87 = i76;
                        if (i87 != -1) {
                        }
                        if (!str32.isEmpty()) {
                        }
                        if (!str30.isEmpty()) {
                        }
                        if (!str31.isEmpty()) {
                        }
                        int i88222222222222222222 = i79;
                        f76950e = i88222222222222222222;
                        edit222222222222222222.putInt("davBubbleSwitch", i88222222222222222222);
                        edit222222222222222222.putInt("880UIABTestOption", z48 ? 1 : 0);
                        edit222222222222222222.putInt("880EffectUIABTestOption", z49 ? 1 : 0);
                        edit222222222222222222.putInt("883Avatar2dEntranceABTestOption", z55 ? 1 : 0);
                        edit222222222222222222.putInt("V7BeautyLowestSupportLevel", i49);
                        edit222222222222222222.putBoolean("useHwDecLowLatency", i77 >= 1);
                        edit222222222222222222.putBoolean("useHWEncCBR", i78 >= 1);
                        edit222222222222222222.putBoolean("c2cServerConfig", i59 >= 1);
                        edit222222222222222222.putBoolean("c2cQClear", z39 >= 1);
                        edit222222222222222222.putInt("MoreFuc", z56 ? 1 : 0);
                        edit222222222222222222.putInt("rollback8930UI", i85);
                        edit222222222222222222.commit();
                        if (QLog.isColorLevel()) {
                        }
                    }
                } catch (Exception e101) {
                    str3 = "ptuNewRenderLimit";
                    str4 = "upLoadWhenGetNewData";
                    i3 = 6;
                    z65 = false;
                    exc = e101;
                    str17 = "";
                    str18 = str17;
                    str19 = str18;
                    z17 = z65;
                    z26 = z17;
                    z27 = z26;
                    z28 = z27;
                    z29 = z28;
                    z36 = z29;
                    str5 = "handleGetQAVGeneralConfig";
                    str10 = m17;
                    str38 = m16;
                    i17 = 1;
                    i18 = 1;
                    i27 = 1;
                    i37 = -1;
                    i38 = -1;
                    i39 = -1;
                    i46 = 1;
                    i47 = 1;
                    if (QLog.isColorLevel()) {
                    }
                    i49 = i3;
                    str21 = str11;
                    str22 = str38;
                    str23 = str10;
                    i56 = i18;
                    z38 = z16;
                    i57 = i19;
                    str24 = str12;
                    z39 = z17;
                    str25 = str13;
                    i58 = i26;
                    i59 = i27;
                    i65 = i28;
                    i66 = i16;
                    z46 = z18;
                    i67 = i29;
                    str26 = str20;
                    i68 = i36;
                    str27 = str14;
                    str28 = str15;
                    str29 = str16;
                    i69 = i37;
                    i75 = i38;
                    z47 = z26;
                    i76 = i39;
                    z48 = z27;
                    str30 = str17;
                    str31 = str18;
                    z49 = z28;
                    z55 = z29;
                    i77 = i46;
                    i78 = i47;
                    str32 = str19;
                    z56 = z36;
                    i79 = i48;
                    i85 = 0;
                    str33 = "useRGB2I420Shader";
                    str34 = "switchMultiForceUseGroupAlertTip";
                    z57 = z37;
                    str35 = "videoTrackSoundSeparation";
                    j3 = j16;
                    z58 = z19;
                    String str392222222222222222222 = str23;
                    SharedPreferences.Editor edit2222222222222222222 = d(287, f76962q).edit();
                    edit2222222222222222222.putInt("isBlueToothSwitch", i68);
                    edit2222222222222222222.putLong("bluetoothDelayTime", j3);
                    edit2222222222222222222.putBoolean("LowlightAndDenoiseDevice", z57);
                    edit2222222222222222222.putInt("multiVideoSupportNumbers", i65);
                    edit2222222222222222222.putInt("SpeedDialScreenStyle", i66);
                    edit2222222222222222222.putBoolean("switchMultiForceUseGroup", z46);
                    edit2222222222222222222.putBoolean(str6, i57 >= 1);
                    edit2222222222222222222.putString(str21, str392222222222222222222);
                    edit2222222222222222222.putString(str34, str26);
                    edit2222222222222222222.putInt(str33, i67);
                    edit2222222222222222222.putInt(str35, z58 ? 1 : 0);
                    edit2222222222222222222.putInt(str4, i58);
                    edit2222222222222222222.putString(str3, str22);
                    edit2222222222222222222.putString(str9, str25);
                    edit2222222222222222222.putString(str8, str27);
                    edit2222222222222222222.putString(str7, str24);
                    edit2222222222222222222.putBoolean("isAllowedControlMicAfterBeMuted", z38);
                    edit2222222222222222222.putString("machineMiddleLine", str28);
                    edit2222222222222222222.putString("machineHighLine", str29);
                    edit2222222222222222222.putInt("allowMicLongPressSpeakInMute", i69);
                    i86 = i75;
                    if (i86 != -1) {
                    }
                    edit2222222222222222222.putInt("ScreenShareSwitch", i56);
                    edit2222222222222222222.putInt("AskScreenShareSwitch", z47 ? 1 : 0);
                    i87 = i76;
                    if (i87 != -1) {
                    }
                    if (!str32.isEmpty()) {
                    }
                    if (!str30.isEmpty()) {
                    }
                    if (!str31.isEmpty()) {
                    }
                    int i882222222222222222222 = i79;
                    f76950e = i882222222222222222222;
                    edit2222222222222222222.putInt("davBubbleSwitch", i882222222222222222222);
                    edit2222222222222222222.putInt("880UIABTestOption", z48 ? 1 : 0);
                    edit2222222222222222222.putInt("880EffectUIABTestOption", z49 ? 1 : 0);
                    edit2222222222222222222.putInt("883Avatar2dEntranceABTestOption", z55 ? 1 : 0);
                    edit2222222222222222222.putInt("V7BeautyLowestSupportLevel", i49);
                    edit2222222222222222222.putBoolean("useHwDecLowLatency", i77 >= 1);
                    edit2222222222222222222.putBoolean("useHWEncCBR", i78 >= 1);
                    edit2222222222222222222.putBoolean("c2cServerConfig", i59 >= 1);
                    edit2222222222222222222.putBoolean("c2cQClear", z39 >= 1);
                    edit2222222222222222222.putInt("MoreFuc", z56 ? 1 : 0);
                    edit2222222222222222222.putInt("rollback8930UI", i85);
                    edit2222222222222222222.commit();
                    if (QLog.isColorLevel()) {
                    }
                }
                try {
                    i47 = k(jSONObject, "useHWEncCBR", 1);
                    try {
                        int k36 = k(jSONObject, "c2cServerConfig", 1);
                        try {
                            StringBuilder sb11 = new StringBuilder();
                            str19 = m18;
                            try {
                                sb11.append(" enableC2CServerConfig: ");
                                sb11.append(k36);
                                QLog.d(str37, 2, sb11.toString());
                                z68 = false;
                                try {
                                    z17 = k(jSONObject, "c2cQClear", 0);
                                    try {
                                        z36 = k(jSONObject, "MoreFuc", 0);
                                    } catch (Exception e102) {
                                        e = e102;
                                        z36 = false;
                                    }
                                } catch (Exception e103) {
                                    e = e103;
                                    z17 = z68;
                                    z36 = z17;
                                    i3 = k17;
                                    exc = e;
                                    i17 = k16;
                                    str5 = str37;
                                    str10 = m17;
                                    i27 = k36;
                                    str38 = m16;
                                    if (QLog.isColorLevel()) {
                                    }
                                    i49 = i3;
                                    str21 = str11;
                                    str22 = str38;
                                    str23 = str10;
                                    i56 = i18;
                                    z38 = z16;
                                    i57 = i19;
                                    str24 = str12;
                                    z39 = z17;
                                    str25 = str13;
                                    i58 = i26;
                                    i59 = i27;
                                    i65 = i28;
                                    i66 = i16;
                                    z46 = z18;
                                    i67 = i29;
                                    str26 = str20;
                                    i68 = i36;
                                    str27 = str14;
                                    str28 = str15;
                                    str29 = str16;
                                    i69 = i37;
                                    i75 = i38;
                                    z47 = z26;
                                    i76 = i39;
                                    z48 = z27;
                                    str30 = str17;
                                    str31 = str18;
                                    z49 = z28;
                                    z55 = z29;
                                    i77 = i46;
                                    i78 = i47;
                                    str32 = str19;
                                    z56 = z36;
                                    i79 = i48;
                                    i85 = 0;
                                    str33 = "useRGB2I420Shader";
                                    str34 = "switchMultiForceUseGroupAlertTip";
                                    z57 = z37;
                                    str35 = "videoTrackSoundSeparation";
                                    j3 = j16;
                                    z58 = z19;
                                    String str3922222222222222222222 = str23;
                                    SharedPreferences.Editor edit22222222222222222222 = d(287, f76962q).edit();
                                    edit22222222222222222222.putInt("isBlueToothSwitch", i68);
                                    edit22222222222222222222.putLong("bluetoothDelayTime", j3);
                                    edit22222222222222222222.putBoolean("LowlightAndDenoiseDevice", z57);
                                    edit22222222222222222222.putInt("multiVideoSupportNumbers", i65);
                                    edit22222222222222222222.putInt("SpeedDialScreenStyle", i66);
                                    edit22222222222222222222.putBoolean("switchMultiForceUseGroup", z46);
                                    edit22222222222222222222.putBoolean(str6, i57 >= 1);
                                    edit22222222222222222222.putString(str21, str3922222222222222222222);
                                    edit22222222222222222222.putString(str34, str26);
                                    edit22222222222222222222.putInt(str33, i67);
                                    edit22222222222222222222.putInt(str35, z58 ? 1 : 0);
                                    edit22222222222222222222.putInt(str4, i58);
                                    edit22222222222222222222.putString(str3, str22);
                                    edit22222222222222222222.putString(str9, str25);
                                    edit22222222222222222222.putString(str8, str27);
                                    edit22222222222222222222.putString(str7, str24);
                                    edit22222222222222222222.putBoolean("isAllowedControlMicAfterBeMuted", z38);
                                    edit22222222222222222222.putString("machineMiddleLine", str28);
                                    edit22222222222222222222.putString("machineHighLine", str29);
                                    edit22222222222222222222.putInt("allowMicLongPressSpeakInMute", i69);
                                    i86 = i75;
                                    if (i86 != -1) {
                                    }
                                    edit22222222222222222222.putInt("ScreenShareSwitch", i56);
                                    edit22222222222222222222.putInt("AskScreenShareSwitch", z47 ? 1 : 0);
                                    i87 = i76;
                                    if (i87 != -1) {
                                    }
                                    if (!str32.isEmpty()) {
                                    }
                                    if (!str30.isEmpty()) {
                                    }
                                    if (!str31.isEmpty()) {
                                    }
                                    int i8822222222222222222222 = i79;
                                    f76950e = i8822222222222222222222;
                                    edit22222222222222222222.putInt("davBubbleSwitch", i8822222222222222222222);
                                    edit22222222222222222222.putInt("880UIABTestOption", z48 ? 1 : 0);
                                    edit22222222222222222222.putInt("880EffectUIABTestOption", z49 ? 1 : 0);
                                    edit22222222222222222222.putInt("883Avatar2dEntranceABTestOption", z55 ? 1 : 0);
                                    edit22222222222222222222.putInt("V7BeautyLowestSupportLevel", i49);
                                    edit22222222222222222222.putBoolean("useHwDecLowLatency", i77 >= 1);
                                    edit22222222222222222222.putBoolean("useHWEncCBR", i78 >= 1);
                                    edit22222222222222222222.putBoolean("c2cServerConfig", i59 >= 1);
                                    edit22222222222222222222.putBoolean("c2cQClear", z39 >= 1);
                                    edit22222222222222222222.putInt("MoreFuc", z56 ? 1 : 0);
                                    edit22222222222222222222.putInt("rollback8930UI", i85);
                                    edit22222222222222222222.commit();
                                    if (QLog.isColorLevel()) {
                                    }
                                }
                            } catch (Exception e104) {
                                e = e104;
                                z68 = false;
                                z17 = z68;
                                z36 = z17;
                                i3 = k17;
                                exc = e;
                                i17 = k16;
                                str5 = str37;
                                str10 = m17;
                                i27 = k36;
                                str38 = m16;
                                if (QLog.isColorLevel()) {
                                }
                                i49 = i3;
                                str21 = str11;
                                str22 = str38;
                                str23 = str10;
                                i56 = i18;
                                z38 = z16;
                                i57 = i19;
                                str24 = str12;
                                z39 = z17;
                                str25 = str13;
                                i58 = i26;
                                i59 = i27;
                                i65 = i28;
                                i66 = i16;
                                z46 = z18;
                                i67 = i29;
                                str26 = str20;
                                i68 = i36;
                                str27 = str14;
                                str28 = str15;
                                str29 = str16;
                                i69 = i37;
                                i75 = i38;
                                z47 = z26;
                                i76 = i39;
                                z48 = z27;
                                str30 = str17;
                                str31 = str18;
                                z49 = z28;
                                z55 = z29;
                                i77 = i46;
                                i78 = i47;
                                str32 = str19;
                                z56 = z36;
                                i79 = i48;
                                i85 = 0;
                                str33 = "useRGB2I420Shader";
                                str34 = "switchMultiForceUseGroupAlertTip";
                                z57 = z37;
                                str35 = "videoTrackSoundSeparation";
                                j3 = j16;
                                z58 = z19;
                                String str39222222222222222222222 = str23;
                                SharedPreferences.Editor edit222222222222222222222 = d(287, f76962q).edit();
                                edit222222222222222222222.putInt("isBlueToothSwitch", i68);
                                edit222222222222222222222.putLong("bluetoothDelayTime", j3);
                                edit222222222222222222222.putBoolean("LowlightAndDenoiseDevice", z57);
                                edit222222222222222222222.putInt("multiVideoSupportNumbers", i65);
                                edit222222222222222222222.putInt("SpeedDialScreenStyle", i66);
                                edit222222222222222222222.putBoolean("switchMultiForceUseGroup", z46);
                                edit222222222222222222222.putBoolean(str6, i57 >= 1);
                                edit222222222222222222222.putString(str21, str39222222222222222222222);
                                edit222222222222222222222.putString(str34, str26);
                                edit222222222222222222222.putInt(str33, i67);
                                edit222222222222222222222.putInt(str35, z58 ? 1 : 0);
                                edit222222222222222222222.putInt(str4, i58);
                                edit222222222222222222222.putString(str3, str22);
                                edit222222222222222222222.putString(str9, str25);
                                edit222222222222222222222.putString(str8, str27);
                                edit222222222222222222222.putString(str7, str24);
                                edit222222222222222222222.putBoolean("isAllowedControlMicAfterBeMuted", z38);
                                edit222222222222222222222.putString("machineMiddleLine", str28);
                                edit222222222222222222222.putString("machineHighLine", str29);
                                edit222222222222222222222.putInt("allowMicLongPressSpeakInMute", i69);
                                i86 = i75;
                                if (i86 != -1) {
                                }
                                edit222222222222222222222.putInt("ScreenShareSwitch", i56);
                                edit222222222222222222222.putInt("AskScreenShareSwitch", z47 ? 1 : 0);
                                i87 = i76;
                                if (i87 != -1) {
                                }
                                if (!str32.isEmpty()) {
                                }
                                if (!str30.isEmpty()) {
                                }
                                if (!str31.isEmpty()) {
                                }
                                int i88222222222222222222222 = i79;
                                f76950e = i88222222222222222222222;
                                edit222222222222222222222.putInt("davBubbleSwitch", i88222222222222222222222);
                                edit222222222222222222222.putInt("880UIABTestOption", z48 ? 1 : 0);
                                edit222222222222222222222.putInt("880EffectUIABTestOption", z49 ? 1 : 0);
                                edit222222222222222222222.putInt("883Avatar2dEntranceABTestOption", z55 ? 1 : 0);
                                edit222222222222222222222.putInt("V7BeautyLowestSupportLevel", i49);
                                edit222222222222222222222.putBoolean("useHwDecLowLatency", i77 >= 1);
                                edit222222222222222222222.putBoolean("useHWEncCBR", i78 >= 1);
                                edit222222222222222222222.putBoolean("c2cServerConfig", i59 >= 1);
                                edit222222222222222222222.putBoolean("c2cQClear", z39 >= 1);
                                edit222222222222222222222.putInt("MoreFuc", z56 ? 1 : 0);
                                edit222222222222222222222.putInt("rollback8930UI", i85);
                                edit222222222222222222222.commit();
                                if (QLog.isColorLevel()) {
                                }
                            }
                            try {
                                i85 = k(jSONObject, "rollback8930UI", 0);
                                i59 = k36;
                                i79 = k16;
                                i56 = i18;
                                z38 = z16;
                                i57 = i19;
                                str24 = str12;
                                z39 = z17;
                                str25 = str13;
                                i58 = i26;
                                str23 = m17;
                                i49 = k17;
                                i65 = i28;
                                i66 = i16;
                                z46 = z18;
                                i67 = i29;
                                str26 = str20;
                                i68 = i36;
                                str22 = m16;
                                str27 = str14;
                                str28 = str15;
                                str29 = str16;
                                i69 = i37;
                                i75 = i38;
                                z47 = z26;
                                i76 = i39;
                                z48 = z27;
                                str30 = str17;
                                str31 = str18;
                                z49 = z28;
                                z55 = z29;
                                i77 = i46;
                                i78 = i47;
                                str32 = str19;
                                z56 = z36;
                                str21 = str11;
                            } catch (Exception e105) {
                                e = e105;
                                i3 = k17;
                                exc = e;
                                i17 = k16;
                                str5 = str37;
                                str10 = m17;
                                i27 = k36;
                                str38 = m16;
                                if (QLog.isColorLevel()) {
                                }
                                i49 = i3;
                                str21 = str11;
                                str22 = str38;
                                str23 = str10;
                                i56 = i18;
                                z38 = z16;
                                i57 = i19;
                                str24 = str12;
                                z39 = z17;
                                str25 = str13;
                                i58 = i26;
                                i59 = i27;
                                i65 = i28;
                                i66 = i16;
                                z46 = z18;
                                i67 = i29;
                                str26 = str20;
                                i68 = i36;
                                str27 = str14;
                                str28 = str15;
                                str29 = str16;
                                i69 = i37;
                                i75 = i38;
                                z47 = z26;
                                i76 = i39;
                                z48 = z27;
                                str30 = str17;
                                str31 = str18;
                                z49 = z28;
                                z55 = z29;
                                i77 = i46;
                                i78 = i47;
                                str32 = str19;
                                z56 = z36;
                                i79 = i48;
                                i85 = 0;
                                str33 = "useRGB2I420Shader";
                                str34 = "switchMultiForceUseGroupAlertTip";
                                z57 = z37;
                                str35 = "videoTrackSoundSeparation";
                                j3 = j16;
                                z58 = z19;
                                String str392222222222222222222222 = str23;
                                SharedPreferences.Editor edit2222222222222222222222 = d(287, f76962q).edit();
                                edit2222222222222222222222.putInt("isBlueToothSwitch", i68);
                                edit2222222222222222222222.putLong("bluetoothDelayTime", j3);
                                edit2222222222222222222222.putBoolean("LowlightAndDenoiseDevice", z57);
                                edit2222222222222222222222.putInt("multiVideoSupportNumbers", i65);
                                edit2222222222222222222222.putInt("SpeedDialScreenStyle", i66);
                                edit2222222222222222222222.putBoolean("switchMultiForceUseGroup", z46);
                                edit2222222222222222222222.putBoolean(str6, i57 >= 1);
                                edit2222222222222222222222.putString(str21, str392222222222222222222222);
                                edit2222222222222222222222.putString(str34, str26);
                                edit2222222222222222222222.putInt(str33, i67);
                                edit2222222222222222222222.putInt(str35, z58 ? 1 : 0);
                                edit2222222222222222222222.putInt(str4, i58);
                                edit2222222222222222222222.putString(str3, str22);
                                edit2222222222222222222222.putString(str9, str25);
                                edit2222222222222222222222.putString(str8, str27);
                                edit2222222222222222222222.putString(str7, str24);
                                edit2222222222222222222222.putBoolean("isAllowedControlMicAfterBeMuted", z38);
                                edit2222222222222222222222.putString("machineMiddleLine", str28);
                                edit2222222222222222222222.putString("machineHighLine", str29);
                                edit2222222222222222222222.putInt("allowMicLongPressSpeakInMute", i69);
                                i86 = i75;
                                if (i86 != -1) {
                                }
                                edit2222222222222222222222.putInt("ScreenShareSwitch", i56);
                                edit2222222222222222222222.putInt("AskScreenShareSwitch", z47 ? 1 : 0);
                                i87 = i76;
                                if (i87 != -1) {
                                }
                                if (!str32.isEmpty()) {
                                }
                                if (!str30.isEmpty()) {
                                }
                                if (!str31.isEmpty()) {
                                }
                                int i882222222222222222222222 = i79;
                                f76950e = i882222222222222222222222;
                                edit2222222222222222222222.putInt("davBubbleSwitch", i882222222222222222222222);
                                edit2222222222222222222222.putInt("880UIABTestOption", z48 ? 1 : 0);
                                edit2222222222222222222222.putInt("880EffectUIABTestOption", z49 ? 1 : 0);
                                edit2222222222222222222222.putInt("883Avatar2dEntranceABTestOption", z55 ? 1 : 0);
                                edit2222222222222222222222.putInt("V7BeautyLowestSupportLevel", i49);
                                edit2222222222222222222222.putBoolean("useHwDecLowLatency", i77 >= 1);
                                edit2222222222222222222222.putBoolean("useHWEncCBR", i78 >= 1);
                                edit2222222222222222222222.putBoolean("c2cServerConfig", i59 >= 1);
                                edit2222222222222222222222.putBoolean("c2cQClear", z39 >= 1);
                                edit2222222222222222222222.putInt("MoreFuc", z56 ? 1 : 0);
                                edit2222222222222222222222.putInt("rollback8930UI", i85);
                                edit2222222222222222222222.commit();
                                if (QLog.isColorLevel()) {
                                }
                            }
                        } catch (Exception e106) {
                            e = e106;
                            str19 = m18;
                        }
                    } catch (Exception e107) {
                        e = e107;
                        str19 = m18;
                        z17 = false;
                        z36 = false;
                        i3 = k17;
                        str38 = m16;
                        exc = e;
                        i17 = k16;
                        str5 = str37;
                        str10 = m17;
                        i27 = 1;
                        if (QLog.isColorLevel()) {
                        }
                        i49 = i3;
                        str21 = str11;
                        str22 = str38;
                        str23 = str10;
                        i56 = i18;
                        z38 = z16;
                        i57 = i19;
                        str24 = str12;
                        z39 = z17;
                        str25 = str13;
                        i58 = i26;
                        i59 = i27;
                        i65 = i28;
                        i66 = i16;
                        z46 = z18;
                        i67 = i29;
                        str26 = str20;
                        i68 = i36;
                        str27 = str14;
                        str28 = str15;
                        str29 = str16;
                        i69 = i37;
                        i75 = i38;
                        z47 = z26;
                        i76 = i39;
                        z48 = z27;
                        str30 = str17;
                        str31 = str18;
                        z49 = z28;
                        z55 = z29;
                        i77 = i46;
                        i78 = i47;
                        str32 = str19;
                        z56 = z36;
                        i79 = i48;
                        i85 = 0;
                        str33 = "useRGB2I420Shader";
                        str34 = "switchMultiForceUseGroupAlertTip";
                        z57 = z37;
                        str35 = "videoTrackSoundSeparation";
                        j3 = j16;
                        z58 = z19;
                        String str3922222222222222222222222 = str23;
                        SharedPreferences.Editor edit22222222222222222222222 = d(287, f76962q).edit();
                        edit22222222222222222222222.putInt("isBlueToothSwitch", i68);
                        edit22222222222222222222222.putLong("bluetoothDelayTime", j3);
                        edit22222222222222222222222.putBoolean("LowlightAndDenoiseDevice", z57);
                        edit22222222222222222222222.putInt("multiVideoSupportNumbers", i65);
                        edit22222222222222222222222.putInt("SpeedDialScreenStyle", i66);
                        edit22222222222222222222222.putBoolean("switchMultiForceUseGroup", z46);
                        edit22222222222222222222222.putBoolean(str6, i57 >= 1);
                        edit22222222222222222222222.putString(str21, str3922222222222222222222222);
                        edit22222222222222222222222.putString(str34, str26);
                        edit22222222222222222222222.putInt(str33, i67);
                        edit22222222222222222222222.putInt(str35, z58 ? 1 : 0);
                        edit22222222222222222222222.putInt(str4, i58);
                        edit22222222222222222222222.putString(str3, str22);
                        edit22222222222222222222222.putString(str9, str25);
                        edit22222222222222222222222.putString(str8, str27);
                        edit22222222222222222222222.putString(str7, str24);
                        edit22222222222222222222222.putBoolean("isAllowedControlMicAfterBeMuted", z38);
                        edit22222222222222222222222.putString("machineMiddleLine", str28);
                        edit22222222222222222222222.putString("machineHighLine", str29);
                        edit22222222222222222222222.putInt("allowMicLongPressSpeakInMute", i69);
                        i86 = i75;
                        if (i86 != -1) {
                        }
                        edit22222222222222222222222.putInt("ScreenShareSwitch", i56);
                        edit22222222222222222222222.putInt("AskScreenShareSwitch", z47 ? 1 : 0);
                        i87 = i76;
                        if (i87 != -1) {
                        }
                        if (!str32.isEmpty()) {
                        }
                        if (!str30.isEmpty()) {
                        }
                        if (!str31.isEmpty()) {
                        }
                        int i8822222222222222222222222 = i79;
                        f76950e = i8822222222222222222222222;
                        edit22222222222222222222222.putInt("davBubbleSwitch", i8822222222222222222222222);
                        edit22222222222222222222222.putInt("880UIABTestOption", z48 ? 1 : 0);
                        edit22222222222222222222222.putInt("880EffectUIABTestOption", z49 ? 1 : 0);
                        edit22222222222222222222222.putInt("883Avatar2dEntranceABTestOption", z55 ? 1 : 0);
                        edit22222222222222222222222.putInt("V7BeautyLowestSupportLevel", i49);
                        edit22222222222222222222222.putBoolean("useHwDecLowLatency", i77 >= 1);
                        edit22222222222222222222222.putBoolean("useHWEncCBR", i78 >= 1);
                        edit22222222222222222222222.putBoolean("c2cServerConfig", i59 >= 1);
                        edit22222222222222222222222.putBoolean("c2cQClear", z39 >= 1);
                        edit22222222222222222222222.putInt("MoreFuc", z56 ? 1 : 0);
                        edit22222222222222222222222.putInt("rollback8930UI", i85);
                        edit22222222222222222222222.commit();
                        if (QLog.isColorLevel()) {
                        }
                    }
                } catch (Exception e108) {
                    e = e108;
                    str19 = m18;
                    z17 = false;
                    z36 = false;
                    i3 = k17;
                    str38 = m16;
                    i47 = 1;
                    exc = e;
                    i17 = k16;
                    str5 = str37;
                    str10 = m17;
                    i27 = 1;
                    if (QLog.isColorLevel()) {
                    }
                    i49 = i3;
                    str21 = str11;
                    str22 = str38;
                    str23 = str10;
                    i56 = i18;
                    z38 = z16;
                    i57 = i19;
                    str24 = str12;
                    z39 = z17;
                    str25 = str13;
                    i58 = i26;
                    i59 = i27;
                    i65 = i28;
                    i66 = i16;
                    z46 = z18;
                    i67 = i29;
                    str26 = str20;
                    i68 = i36;
                    str27 = str14;
                    str28 = str15;
                    str29 = str16;
                    i69 = i37;
                    i75 = i38;
                    z47 = z26;
                    i76 = i39;
                    z48 = z27;
                    str30 = str17;
                    str31 = str18;
                    z49 = z28;
                    z55 = z29;
                    i77 = i46;
                    i78 = i47;
                    str32 = str19;
                    z56 = z36;
                    i79 = i48;
                    i85 = 0;
                    str33 = "useRGB2I420Shader";
                    str34 = "switchMultiForceUseGroupAlertTip";
                    z57 = z37;
                    str35 = "videoTrackSoundSeparation";
                    j3 = j16;
                    z58 = z19;
                    String str39222222222222222222222222 = str23;
                    SharedPreferences.Editor edit222222222222222222222222 = d(287, f76962q).edit();
                    edit222222222222222222222222.putInt("isBlueToothSwitch", i68);
                    edit222222222222222222222222.putLong("bluetoothDelayTime", j3);
                    edit222222222222222222222222.putBoolean("LowlightAndDenoiseDevice", z57);
                    edit222222222222222222222222.putInt("multiVideoSupportNumbers", i65);
                    edit222222222222222222222222.putInt("SpeedDialScreenStyle", i66);
                    edit222222222222222222222222.putBoolean("switchMultiForceUseGroup", z46);
                    edit222222222222222222222222.putBoolean(str6, i57 >= 1);
                    edit222222222222222222222222.putString(str21, str39222222222222222222222222);
                    edit222222222222222222222222.putString(str34, str26);
                    edit222222222222222222222222.putInt(str33, i67);
                    edit222222222222222222222222.putInt(str35, z58 ? 1 : 0);
                    edit222222222222222222222222.putInt(str4, i58);
                    edit222222222222222222222222.putString(str3, str22);
                    edit222222222222222222222222.putString(str9, str25);
                    edit222222222222222222222222.putString(str8, str27);
                    edit222222222222222222222222.putString(str7, str24);
                    edit222222222222222222222222.putBoolean("isAllowedControlMicAfterBeMuted", z38);
                    edit222222222222222222222222.putString("machineMiddleLine", str28);
                    edit222222222222222222222222.putString("machineHighLine", str29);
                    edit222222222222222222222222.putInt("allowMicLongPressSpeakInMute", i69);
                    i86 = i75;
                    if (i86 != -1) {
                    }
                    edit222222222222222222222222.putInt("ScreenShareSwitch", i56);
                    edit222222222222222222222222.putInt("AskScreenShareSwitch", z47 ? 1 : 0);
                    i87 = i76;
                    if (i87 != -1) {
                    }
                    if (!str32.isEmpty()) {
                    }
                    if (!str30.isEmpty()) {
                    }
                    if (!str31.isEmpty()) {
                    }
                    int i88222222222222222222222222 = i79;
                    f76950e = i88222222222222222222222222;
                    edit222222222222222222222222.putInt("davBubbleSwitch", i88222222222222222222222222);
                    edit222222222222222222222222.putInt("880UIABTestOption", z48 ? 1 : 0);
                    edit222222222222222222222222.putInt("880EffectUIABTestOption", z49 ? 1 : 0);
                    edit222222222222222222222222.putInt("883Avatar2dEntranceABTestOption", z55 ? 1 : 0);
                    edit222222222222222222222222.putInt("V7BeautyLowestSupportLevel", i49);
                    edit222222222222222222222222.putBoolean("useHwDecLowLatency", i77 >= 1);
                    edit222222222222222222222222.putBoolean("useHWEncCBR", i78 >= 1);
                    edit222222222222222222222222.putBoolean("c2cServerConfig", i59 >= 1);
                    edit222222222222222222222222.putBoolean("c2cQClear", z39 >= 1);
                    edit222222222222222222222222.putInt("MoreFuc", z56 ? 1 : 0);
                    edit222222222222222222222222.putInt("rollback8930UI", i85);
                    edit222222222222222222222222.commit();
                    if (QLog.isColorLevel()) {
                    }
                }
            } catch (Exception e109) {
                str2 = "QAVConfigUtils";
                str3 = "ptuNewRenderLimit";
                str4 = "upLoadWhenGetNewData";
                i3 = 6;
                z65 = false;
                exc = e109;
                str16 = "";
                str17 = str16;
                str18 = str17;
                str19 = str18;
                z17 = z65;
                z26 = z17;
                z27 = z26;
                z28 = z27;
                z29 = z28;
                z36 = z29;
                str5 = "handleGetQAVGeneralConfig";
                str10 = m17;
                str38 = m16;
                i17 = 1;
                i18 = 1;
                i27 = 1;
                i37 = -1;
                i38 = -1;
                i39 = -1;
                i46 = 1;
                i47 = 1;
                if (QLog.isColorLevel()) {
                    i48 = i17;
                } else {
                    StringBuilder sb12 = new StringBuilder();
                    i48 = i17;
                    sb12.append(" parse json: ");
                    sb12.append(QLog.getStackTraceString(exc));
                    QLog.i(str5, 2, sb12.toString());
                }
                i49 = i3;
                str21 = str11;
                str22 = str38;
                str23 = str10;
                i56 = i18;
                z38 = z16;
                i57 = i19;
                str24 = str12;
                z39 = z17;
                str25 = str13;
                i58 = i26;
                i59 = i27;
                i65 = i28;
                i66 = i16;
                z46 = z18;
                i67 = i29;
                str26 = str20;
                i68 = i36;
                str27 = str14;
                str28 = str15;
                str29 = str16;
                i69 = i37;
                i75 = i38;
                z47 = z26;
                i76 = i39;
                z48 = z27;
                str30 = str17;
                str31 = str18;
                z49 = z28;
                z55 = z29;
                i77 = i46;
                i78 = i47;
                str32 = str19;
                z56 = z36;
                i79 = i48;
                i85 = 0;
                str33 = "useRGB2I420Shader";
                str34 = "switchMultiForceUseGroupAlertTip";
                z57 = z37;
                str35 = "videoTrackSoundSeparation";
                j3 = j16;
                z58 = z19;
                String str392222222222222222222222222 = str23;
                SharedPreferences.Editor edit2222222222222222222222222 = d(287, f76962q).edit();
                edit2222222222222222222222222.putInt("isBlueToothSwitch", i68);
                edit2222222222222222222222222.putLong("bluetoothDelayTime", j3);
                edit2222222222222222222222222.putBoolean("LowlightAndDenoiseDevice", z57);
                edit2222222222222222222222222.putInt("multiVideoSupportNumbers", i65);
                edit2222222222222222222222222.putInt("SpeedDialScreenStyle", i66);
                edit2222222222222222222222222.putBoolean("switchMultiForceUseGroup", z46);
                edit2222222222222222222222222.putBoolean(str6, i57 >= 1);
                edit2222222222222222222222222.putString(str21, str392222222222222222222222222);
                edit2222222222222222222222222.putString(str34, str26);
                edit2222222222222222222222222.putInt(str33, i67);
                edit2222222222222222222222222.putInt(str35, z58 ? 1 : 0);
                edit2222222222222222222222222.putInt(str4, i58);
                edit2222222222222222222222222.putString(str3, str22);
                edit2222222222222222222222222.putString(str9, str25);
                edit2222222222222222222222222.putString(str8, str27);
                edit2222222222222222222222222.putString(str7, str24);
                edit2222222222222222222222222.putBoolean("isAllowedControlMicAfterBeMuted", z38);
                edit2222222222222222222222222.putString("machineMiddleLine", str28);
                edit2222222222222222222222222.putString("machineHighLine", str29);
                edit2222222222222222222222222.putInt("allowMicLongPressSpeakInMute", i69);
                i86 = i75;
                if (i86 != -1) {
                }
                edit2222222222222222222222222.putInt("ScreenShareSwitch", i56);
                edit2222222222222222222222222.putInt("AskScreenShareSwitch", z47 ? 1 : 0);
                i87 = i76;
                if (i87 != -1) {
                }
                if (!str32.isEmpty()) {
                }
                if (!str30.isEmpty()) {
                }
                if (!str31.isEmpty()) {
                }
                int i882222222222222222222222222 = i79;
                f76950e = i882222222222222222222222222;
                edit2222222222222222222222222.putInt("davBubbleSwitch", i882222222222222222222222222);
                edit2222222222222222222222222.putInt("880UIABTestOption", z48 ? 1 : 0);
                edit2222222222222222222222222.putInt("880EffectUIABTestOption", z49 ? 1 : 0);
                edit2222222222222222222222222.putInt("883Avatar2dEntranceABTestOption", z55 ? 1 : 0);
                edit2222222222222222222222222.putInt("V7BeautyLowestSupportLevel", i49);
                edit2222222222222222222222222.putBoolean("useHwDecLowLatency", i77 >= 1);
                edit2222222222222222222222222.putBoolean("useHWEncCBR", i78 >= 1);
                edit2222222222222222222222222.putBoolean("c2cServerConfig", i59 >= 1);
                edit2222222222222222222222222.putBoolean("c2cQClear", z39 >= 1);
                edit2222222222222222222222222.putInt("MoreFuc", z56 ? 1 : 0);
                edit2222222222222222222222222.putInt("rollback8930UI", i85);
                edit2222222222222222222222222.commit();
                if (QLog.isColorLevel()) {
                }
            }
            str33 = "useRGB2I420Shader";
            str34 = "switchMultiForceUseGroupAlertTip";
            z57 = z37;
            str35 = "videoTrackSoundSeparation";
            j3 = j16;
            z58 = z19;
        }
        String str3922222222222222222222222222 = str23;
        SharedPreferences.Editor edit22222222222222222222222222 = d(287, f76962q).edit();
        edit22222222222222222222222222.putInt("isBlueToothSwitch", i68);
        edit22222222222222222222222222.putLong("bluetoothDelayTime", j3);
        edit22222222222222222222222222.putBoolean("LowlightAndDenoiseDevice", z57);
        edit22222222222222222222222222.putInt("multiVideoSupportNumbers", i65);
        edit22222222222222222222222222.putInt("SpeedDialScreenStyle", i66);
        edit22222222222222222222222222.putBoolean("switchMultiForceUseGroup", z46);
        edit22222222222222222222222222.putBoolean(str6, i57 >= 1);
        edit22222222222222222222222222.putString(str21, str3922222222222222222222222222);
        edit22222222222222222222222222.putString(str34, str26);
        edit22222222222222222222222222.putInt(str33, i67);
        edit22222222222222222222222222.putInt(str35, z58 ? 1 : 0);
        edit22222222222222222222222222.putInt(str4, i58);
        edit22222222222222222222222222.putString(str3, str22);
        edit22222222222222222222222222.putString(str9, str25);
        edit22222222222222222222222222.putString(str8, str27);
        edit22222222222222222222222222.putString(str7, str24);
        edit22222222222222222222222222.putBoolean("isAllowedControlMicAfterBeMuted", z38);
        edit22222222222222222222222222.putString("machineMiddleLine", str28);
        edit22222222222222222222222222.putString("machineHighLine", str29);
        edit22222222222222222222222222.putInt("allowMicLongPressSpeakInMute", i69);
        i86 = i75;
        if (i86 != -1) {
            edit22222222222222222222222222.putInt("qavWatchTogetherSwitch", i86);
        }
        edit22222222222222222222222222.putInt("ScreenShareSwitch", i56);
        edit22222222222222222222222222.putInt("AskScreenShareSwitch", z47 ? 1 : 0);
        i87 = i76;
        if (i87 != -1) {
            edit22222222222222222222222222.putInt("avGameResultUseWebSwitch", i87);
        }
        if (!str32.isEmpty()) {
            edit22222222222222222222222222.putString("screenShareTips", str32);
        }
        if (!str30.isEmpty()) {
            edit22222222222222222222222222.putString("screenTipsHighlight", str30);
        }
        if (!str31.isEmpty()) {
            edit22222222222222222222222222.putString("screenTipsLink", str31);
        }
        int i8822222222222222222222222222 = i79;
        f76950e = i8822222222222222222222222222;
        edit22222222222222222222222222.putInt("davBubbleSwitch", i8822222222222222222222222222);
        edit22222222222222222222222222.putInt("880UIABTestOption", z48 ? 1 : 0);
        edit22222222222222222222222222.putInt("880EffectUIABTestOption", z49 ? 1 : 0);
        edit22222222222222222222222222.putInt("883Avatar2dEntranceABTestOption", z55 ? 1 : 0);
        edit22222222222222222222222222.putInt("V7BeautyLowestSupportLevel", i49);
        edit22222222222222222222222222.putBoolean("useHwDecLowLatency", i77 >= 1);
        edit22222222222222222222222222.putBoolean("useHWEncCBR", i78 >= 1);
        edit22222222222222222222222222.putBoolean("c2cServerConfig", i59 >= 1);
        edit22222222222222222222222222.putBoolean("c2cQClear", z39 >= 1);
        edit22222222222222222222222222.putInt("MoreFuc", z56 ? 1 : 0);
        edit22222222222222222222222222.putInt("rollback8930UI", i85);
        edit22222222222222222222222222.commit();
        if (QLog.isColorLevel()) {
            QLog.i(str2, 2, "parseAndSave [" + str + "]");
        }
    }

    public static void M(int i3, String str, int i16, String str2) {
        SharedPreferences.Editor edit = d(i3, str).edit();
        if (str2 == null) {
            edit.remove(f76960o);
        } else {
            edit.putString(f76960o, str2);
        }
        edit.putInt(f76961p, i16);
        edit.commit();
        if (!QLog.isDevelopLevel()) {
            if (str2 == null) {
                str2 = "null";
            } else {
                str2 = str2.length() + "";
            }
        }
        QLog.w("QAVConfigUtils_" + i3, 1, "saveConfig, configId[" + i3 + "], uin[" + str + "], version[" + i16 + "],\n" + str2 + "");
    }

    public static void N(boolean z16) {
        QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_QAV).putBoolean(s(A), z16);
    }

    public static boolean O() {
        if (f76971z == null) {
            f76971z = Boolean.valueOf(d(287, f76962q).getBoolean("c2cQClear", false));
            QLog.d("QAVConfigUtils", 1, "useC2CQClear := " + f76971z);
        }
        return f76971z.booleanValue();
    }

    public static boolean P() {
        if (f76970y == null) {
            f76970y = Boolean.valueOf(d(287, f76962q).getBoolean("c2cServerConfig", true));
            QLog.d("QAVConfigUtils", 1, "useC2CServerConfig := " + f76970y);
        }
        return f76970y.booleanValue();
    }

    public static Boolean a() {
        if (f76967v == null) {
            f76967v = Boolean.valueOf(d(287, f76962q).getBoolean("enableNetworkSdk", true));
            QLog.d("QAVConfigUtils", 1, "enableNetworkSdk ret := " + f76967v);
        }
        return f76967v;
    }

    public static int b() {
        if (f76951f == -1) {
            f76951f = d(287, f76962q).getInt("880UIABTestOption", 0);
        }
        return f76951f;
    }

    public static String c(@NonNull String str) {
        return d(287, f76962q).getString(str, "");
    }

    public static SharedPreferences d(int i3, String str) {
        return vu.a.h(e(i3, str), 4);
    }

    private static String e(int i3, String str) {
        if (AudioHelperUtil.isDev() && TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("getConfigSPName uin\u4e0d\u80fd\u4e3a\u7a7a, configId:" + i3);
        }
        return f76959n + i3 + "_" + str;
    }

    public static String f(int i3, String str) {
        return d(i3, str).getString(f76960o, null);
    }

    public static int g(int i3, String str) {
        return d(i3, str).getInt(f76961p, 0);
    }

    public static boolean h() {
        u();
        return f76955j.booleanValue();
    }

    public static String i() {
        u();
        return f76956k;
    }

    private static boolean j(JSONObject jSONObject, String str, boolean z16) throws Exception {
        if (jSONObject.has(str)) {
            return jSONObject.getBoolean(str);
        }
        return z16;
    }

    private static int k(JSONObject jSONObject, String str, int i3) throws Exception {
        if (jSONObject.has(str)) {
            return jSONObject.getInt(str);
        }
        return i3;
    }

    private static Long l(JSONObject jSONObject, String str, Long l3) throws Exception {
        long longValue;
        if (jSONObject.has(str)) {
            longValue = jSONObject.getLong(str);
        } else {
            longValue = l3.longValue();
        }
        return Long.valueOf(longValue);
    }

    private static String m(JSONObject jSONObject, String str, String str2) throws Exception {
        if (jSONObject.has(str)) {
            return jSONObject.getString(str);
        }
        return str2;
    }

    public static int n() {
        if (f76954i == 0) {
            f76954i = d(287, f76962q).getInt("MoreFuc", 0);
        }
        return f76954i;
    }

    public static int o() {
        if (f76947b == -1) {
            f76947b = d(287, f76962q).getInt("multiVideoSupportNumbers", -1);
            if (f76947b == -1) {
                f76947b = 5;
            }
            return f76947b;
        }
        return f76947b;
    }

    public static String p() {
        if (f76966u == null) {
            f76966u = d(287, f76962q).getString("networkSwitchJson", "");
            QLog.d("QAVConfigUtils", 1, "getNetworkSwitchJson ret := " + f76966u);
        }
        return f76966u;
    }

    public static int q() {
        if (!J()) {
            return 0;
        }
        String str = new String(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadRawConfig("102760", new byte[0]), StandardCharsets.UTF_8);
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return k(new JSONObject(str), "opensles_unint_play_wait_timelen_ms", 0);
        } catch (Exception e16) {
            QLog.e("QAVConfigUtils", 1, "getOpenSlesUnintPlayWaitTimeLenMs parse json failed. " + QLog.getStackTraceString(e16));
            return 0;
        }
    }

    public static a r(String str, String str2, String str3) {
        if (f76965t == null) {
            f76965t = new a(str, str2, str3);
            SharedPreferences d16 = d(287, f76962q);
            String string = d16.getString("screenShareTips", "");
            if (string.equals("")) {
                QLog.i("QAVConfigUtils", 1, "screenShareTips not receive");
                return f76965t;
            }
            String string2 = d16.getString("screenTipsHighlight", "");
            if (string2.equals("")) {
                QLog.i("QAVConfigUtils", 1, "screenTipsHighlight not receive");
                return f76965t;
            }
            String string3 = d16.getString("screenTipsLink", "");
            if (string3.equals("")) {
                QLog.i("QAVConfigUtils", 1, "screenTipsLink not receive");
                return f76965t;
            }
            a aVar = f76965t;
            aVar.f76972a = string;
            aVar.f76973b = string2;
            aVar.f76974c = string3;
            QLog.i("QAVConfigUtils", 1, "sScreenShareSafeTips, content[" + string + "], highlight[" + string2 + "], link[" + string3 + "]");
        }
        return f76965t;
    }

    private static String s(String str) {
        return str + "_" + MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin();
    }

    public static int t() {
        if (f76952g == 6) {
            f76952g = d(287, f76962q).getInt("V7BeautyLowestSupportLevel", 6);
        }
        if (QLog.isColorLevel()) {
            QLog.i("QAVConfigUtils", 2, "getV7BeautyLowestSupportLevel sV7BeautyLowestSupportLevel " + f76952g);
        }
        return f76952g;
    }

    private static void u() {
        if (f76955j == null || TextUtils.isEmpty(f76956k)) {
            SharedPreferences d16 = d(287, f76962q);
            f76955j = Boolean.valueOf(d16.getBoolean("switchMultiForceUseGroup", false));
            String string = d16.getString("switchMultiForceUseGroupAlertTip", "\u5bf9\u65b9\u7248\u672c\u8fc7\u4f4e\uff0c\u8bf7\u5148\u521b\u5efa\u7fa4\u804a\u540e\u9080\u8bf7");
            f76956k = string;
            if (TextUtils.isEmpty(string)) {
                f76956k = "\u5bf9\u65b9\u7248\u672c\u8fc7\u4f4e\uff0c\u8bf7\u5148\u521b\u5efa\u7fa4\u804a\u540e\u9080\u8bf7";
            }
            if (QLog.isColorLevel()) {
                QLog.i("double_2_multi", 2, "initDouble2GroupConfig [" + f76955j + "," + f76956k + "]");
            }
        }
    }

    public static boolean v() {
        boolean z16 = d(287, f76962q).getBoolean("isAllowedControlMicAfterBeMuted", false);
        QLog.i("QAVConfigUtils", 1, "JTest. read isAllowedControlMicAfterBeMuted = " + z16);
        return z16;
    }

    public static boolean w() {
        if (f76949d == -1) {
            f76949d = d(287, f76962q).getInt("allowMicLongPressSpeakInMute", 0);
        }
        if (f76949d != 1) {
            return false;
        }
        return true;
    }

    public static boolean x() {
        if (n() == 1) {
            return true;
        }
        return false;
    }

    public static boolean y() {
        if (f76964s == null) {
            f76964s = Integer.valueOf(d(287, f76962q).getInt("AskScreenShareSwitch", 1));
            QLog.i("QAVConfigUtils", 1, "isQavScreenShareOpen, switch[" + f76964s + "]");
        }
        if (f76964s.intValue() != 0) {
            return true;
        }
        return false;
    }

    public static boolean z() {
        if (f76963r == null) {
            f76963r = Integer.valueOf(d(287, f76962q).getInt("ScreenShareSwitch", 1));
            QLog.i("QAVConfigUtils", 1, "isQavScreenShareOpen, switch[" + f76963r + "]");
        }
        if (f76963r.intValue() != 0) {
            return true;
        }
        return false;
    }
}
