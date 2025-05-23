package com.tencent.luggage.wxa.ar;

import android.content.SharedPreferences;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.tvkplayer.report.capability.spatialaudio.TVKDeviceSpatialAudioCapabilityReportConstant;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebViewReporterInterface;
import com.tencent.xweb.XWebSdk;
import com.tencent.xweb.xwalk.plugin.XWalkPluginManager;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import org.xwalk.core.XWalkEnvironment;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class n0 {

    /* renamed from: a, reason: collision with root package name */
    public static String f121748a = "";

    /* renamed from: b, reason: collision with root package name */
    public static boolean f121749b = false;

    /* renamed from: c, reason: collision with root package name */
    public static WebView.WebViewKind f121750c = WebView.WebViewKind.WV_KIND_NONE;

    /* renamed from: d, reason: collision with root package name */
    public static WebViewReporterInterface f121751d = null;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f121752e = false;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public StringBuilder f121753a = new StringBuilder();

        /* renamed from: b, reason: collision with root package name */
        public int f121754b;

        public a(int i3) {
            this.f121754b = i3;
        }

        public a a(int i3, Object obj) {
            return a(obj);
        }

        public a a(Object obj) {
            if (this.f121753a.length() > 0) {
                this.f121753a.append(",");
            }
            this.f121753a.append(obj.toString());
            return this;
        }

        public String a() {
            String sb5 = this.f121753a.toString();
            n0.a(this.f121754b, this.f121753a.toString());
            return sb5;
        }
    }

    public static void A() {
        WebViewReporterInterface webViewReporterInterface = f121751d;
        if (webViewReporterInterface != null) {
            webViewReporterInterface.idkeyStat(577L, 14L, 1L);
        }
    }

    public static void B() {
        WebViewReporterInterface webViewReporterInterface = f121751d;
        if (webViewReporterInterface != null) {
            webViewReporterInterface.idkeyStat(577L, 15L, 1L);
        }
    }

    public static void C() {
        WebViewReporterInterface webViewReporterInterface = f121751d;
        if (webViewReporterInterface != null) {
            webViewReporterInterface.idkeyStat(577L, 25L, 1L);
        }
    }

    public static void D() {
        WebViewReporterInterface webViewReporterInterface = f121751d;
        if (webViewReporterInterface != null) {
            webViewReporterInterface.idkeyStat(577L, 26L, 1L);
        }
    }

    public static void E() {
        WebViewReporterInterface webViewReporterInterface = f121751d;
        if (webViewReporterInterface != null) {
            webViewReporterInterface.idkeyStat(577L, 181L, 1L);
        }
    }

    public static void F() {
        WebViewReporterInterface webViewReporterInterface = f121751d;
        if (webViewReporterInterface != null) {
            webViewReporterInterface.idkeyStat(577L, 183L, 1L);
        }
    }

    public static void G() {
        WebViewReporterInterface webViewReporterInterface = f121751d;
        if (webViewReporterInterface != null) {
            webViewReporterInterface.idkeyStat(577L, 182L, 1L);
        }
    }

    public static void H() {
        WebViewReporterInterface webViewReporterInterface = f121751d;
        if (webViewReporterInterface != null) {
            webViewReporterInterface.idkeyStat(577L, 184L, 1L);
        }
    }

    public static void I() {
        WebViewReporterInterface webViewReporterInterface = f121751d;
        if (webViewReporterInterface != null) {
            webViewReporterInterface.idkeyStat(577L, 9L, 1L);
        }
    }

    public static void J() {
        WebViewReporterInterface webViewReporterInterface = f121751d;
        if (webViewReporterInterface != null) {
            webViewReporterInterface.idkeyStat(577L, 10L, 1L);
        }
    }

    public static void K() {
        WebViewReporterInterface webViewReporterInterface = f121751d;
        if (webViewReporterInterface != null) {
            webViewReporterInterface.idkeyStat(577L, 180L, 1L);
        }
    }

    public static void L() {
        WebViewReporterInterface webViewReporterInterface = f121751d;
        if (webViewReporterInterface == null) {
            return;
        }
        webViewReporterInterface.idkeyStat(577L, 88L, 1L);
    }

    public static void M() {
        WebViewReporterInterface webViewReporterInterface = f121751d;
        if (webViewReporterInterface != null) {
            webViewReporterInterface.idkeyStat(577L, 56L, 1L);
            f121751d.idkeyStat(1749L, 5L, 1L);
        }
    }

    public static void N() {
        WebViewReporterInterface webViewReporterInterface = f121751d;
        if (webViewReporterInterface != null) {
            webViewReporterInterface.idkeyStat(577L, 57L, 1L);
        }
    }

    public static void O() {
        WebViewReporterInterface webViewReporterInterface = f121751d;
        if (webViewReporterInterface != null) {
            webViewReporterInterface.idkeyStat(577L, 58L, 1L);
        }
    }

    public static void P() {
        WebViewReporterInterface webViewReporterInterface = f121751d;
        if (webViewReporterInterface != null) {
            webViewReporterInterface.idkeyStat(577L, 59L, 1L);
        }
    }

    public static void Q() {
        WebViewReporterInterface webViewReporterInterface = f121751d;
        if (webViewReporterInterface != null) {
            webViewReporterInterface.idkeyStat(577L, 46L, 1L);
        }
    }

    public static void R() {
        WebViewReporterInterface webViewReporterInterface = f121751d;
        if (webViewReporterInterface != null) {
            webViewReporterInterface.idkeyStat(577L, 47L, 1L);
        }
    }

    public static void S() {
        T();
        WebViewReporterInterface webViewReporterInterface = f121751d;
        if (webViewReporterInterface != null) {
            webViewReporterInterface.idkeyStat(577L, 5L, 1L);
        }
    }

    public static void T() {
        WebViewReporterInterface webViewReporterInterface = f121751d;
        if (webViewReporterInterface != null) {
            webViewReporterInterface.idkeyStat(577L, 1L, 1L);
        }
    }

    public static void U() {
        WebViewReporterInterface webViewReporterInterface = f121751d;
        if (webViewReporterInterface != null) {
            webViewReporterInterface.idkeyStat(577L, 52L, 1L);
            f121751d.idkeyStat(1749L, 4L, 1L);
        }
    }

    public static void V() {
        WebViewReporterInterface webViewReporterInterface = f121751d;
        if (webViewReporterInterface != null) {
            webViewReporterInterface.idkeyStat(577L, 53L, 1L);
        }
    }

    public static void W() {
        WebViewReporterInterface webViewReporterInterface = f121751d;
        if (webViewReporterInterface != null) {
            webViewReporterInterface.idkeyStat(577L, 54L, 1L);
        }
    }

    public static void X() {
        WebViewReporterInterface webViewReporterInterface = f121751d;
        if (webViewReporterInterface != null) {
            webViewReporterInterface.idkeyStat(577L, 55L, 1L);
        }
    }

    public static void Y() {
        String str;
        String b16 = b.b();
        if (!"armeabi-v7a".equals(b16)) {
            str = "armeabi-v7a";
        } else {
            str = "arm64-v8a";
        }
        int installedNewstVersion = XWalkEnvironment.getInstalledNewstVersion(b16);
        int installedNewstVersion2 = XWalkEnvironment.getInstalledNewstVersion(str);
        x0.d("WXWebReporter", "reportCoreInstalled, cur abi(" + b16 + "), ver = " + installedNewstVersion + ", predown abi(" + str + "), ver = " + installedNewstVersion2);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("");
        sb5.append(installedNewstVersion);
        boolean a16 = x.a("report_core_ver", sb5.toString());
        if (x.a("report_core_daily") || a16) {
            if (installedNewstVersion <= 0) {
                b(1367L, 251L, 1L);
            } else {
                b(1367L, (installedNewstVersion % 100) + 0, 1L);
            }
        }
        boolean a17 = x.a("report_core_ver_predown", "" + installedNewstVersion2);
        if (x.a("report_core_daily_predown") || a17) {
            if (installedNewstVersion2 <= 0) {
                b(1367L, 252L, 1L);
            } else {
                b(1367L, (installedNewstVersion2 % 100) + 100, 1L);
            }
        }
        if ("armeabi-v7a".equalsIgnoreCase(b16)) {
            String a18 = b.a();
            if ("armeabi-v7a".equalsIgnoreCase(a18)) {
                a(1367, 253);
                return;
            } else {
                if ("arm64-v8a".equalsIgnoreCase(a18)) {
                    a(1367, 254);
                    return;
                }
                return;
            }
        }
        if ("arm64-v8a".equalsIgnoreCase(b16)) {
            a(1367, 255);
        }
    }

    public static void Z() {
        if (f121752e) {
            return;
        }
        int b16 = b();
        int ordinal = WebView.getCurrentModuleWebCoreType().ordinal() - 1;
        if (WebView.getCurrentModuleWebCoreType() == WebView.WebViewKind.WV_KIND_PINUS) {
            ordinal = WebView.WebViewKind.WV_KIND_CW.ordinal() - 1;
        }
        if (b16 >= 30 && ordinal >= 0) {
            f121752e = true;
            a(903, b16 + 3 + ordinal);
        }
    }

    public static boolean a(int i3) {
        return i3 == 15625 || i3 == 15626;
    }

    public static void b(long j3, long j16, long j17) {
        x0.d("WXWebReporter", "report idkey id = " + j3 + " key = " + j16 + " value = " + j17);
        WebViewReporterInterface webViewReporterInterface = f121751d;
        if (webViewReporterInterface != null) {
            webViewReporterInterface.idkeyStat(j3, j16, j17);
        }
    }

    public static void c(WebView.WebViewKind webViewKind) {
        if (f121751d == null) {
            return;
        }
        if (webViewKind == WebView.WebViewKind.WV_KIND_CW || webViewKind == WebView.WebViewKind.WV_KIND_PINUS) {
            f121751d.idkeyStat(577L, 61L, 1L);
            a(577, 62);
        }
    }

    public static void d(WebView.WebViewKind webViewKind) {
        String str;
        int i3;
        if (f121751d == null) {
            return;
        }
        WebView.WebViewKind webViewKind2 = WebView.WebViewKind.WV_KIND_CW;
        if (webViewKind == webViewKind2 || webViewKind == WebView.WebViewKind.WV_KIND_PINUS) {
            str = "REPORT_APK_VER_TIME";
        } else {
            str = "REPORT_APK_VER_TIME_" + webViewKind;
        }
        String format = new SimpleDateFormat(DateUtil.DATE_FORMAT_8).format(new Date());
        String string = y0.s().getString(str, "");
        String str2 = string != null ? string : "";
        if (webViewKind == webViewKind2 || webViewKind == WebView.WebViewKind.WV_KIND_PINUS) {
            int i16 = y0.s().getInt("REPORT_XWEB_APK_VER", 0);
            int availableVersion = XWalkEnvironment.getAvailableVersion();
            if (availableVersion <= 0) {
                return;
            }
            if (availableVersion != i16 || !format.equals(str2)) {
                f121751d.idkeyStat(577L, (availableVersion % 50) + 100, 1L);
                y0.s().edit().putInt("REPORT_XWEB_APK_VER", availableVersion).commit();
            }
        }
        if (format.equals(str2)) {
            return;
        }
        if (webViewKind != webViewKind2 && webViewKind != WebView.WebViewKind.WV_KIND_PINUS) {
            if (webViewKind != WebView.WebViewKind.WV_KIND_SYS) {
                return;
            } else {
                i3 = 97;
            }
        } else if (XWalkEnvironment.getAvailableVersion() <= 0) {
            return;
        } else {
            i3 = 99;
        }
        f121751d.idkeyStat(577L, i3, 1L);
        y0.s().edit().putString(str, format).commit();
    }

    public static void e(WebView.WebViewKind webViewKind) {
        f121750c = webViewKind;
        x0.d("WXWebReporter", "setMostPrefferdCore, kind:" + webViewKind);
    }

    public static void f(String str) {
        if (str != null) {
            f121748a = str;
        }
    }

    public static void g(long j3) {
        WebViewReporterInterface webViewReporterInterface = f121751d;
        if (webViewReporterInterface == null || j3 <= 0 || j3 >= MiniBoxNoticeInfo.MIN_5) {
            return;
        }
        webViewReporterInterface.idkeyForPair(577, 577, 2, 3, 1, (int) j3);
    }

    public static void h() {
        WebViewReporterInterface webViewReporterInterface = f121751d;
        if (webViewReporterInterface != null) {
            webViewReporterInterface.idkeyStat(1749L, 2L, 1L);
        }
    }

    public static void i() {
        WebViewReporterInterface webViewReporterInterface = f121751d;
        if (webViewReporterInterface != null) {
            webViewReporterInterface.idkeyStat(577L, 60L, 1L);
        }
    }

    public static void j() {
        WebViewReporterInterface webViewReporterInterface = f121751d;
        if (webViewReporterInterface != null) {
            webViewReporterInterface.idkeyStat(1749L, 7L, 1L);
        }
    }

    public static void k() {
        WebViewReporterInterface webViewReporterInterface = f121751d;
        if (webViewReporterInterface != null) {
            webViewReporterInterface.idkeyStat(1749L, 8L, 1L);
        }
    }

    public static void l() {
        WebViewReporterInterface webViewReporterInterface = f121751d;
        if (webViewReporterInterface != null) {
            webViewReporterInterface.idkeyStat(1749L, 9L, 1L);
        }
    }

    public static void m() {
        WebViewReporterInterface webViewReporterInterface = f121751d;
        if (webViewReporterInterface != null) {
            webViewReporterInterface.idkeyStat(1749L, 10L, 1L);
        }
    }

    public static void n() {
        WebViewReporterInterface webViewReporterInterface = f121751d;
        if (webViewReporterInterface != null) {
            webViewReporterInterface.idkeyStat(1749L, 11L, 1L);
        }
    }

    public static void o() {
        WebViewReporterInterface webViewReporterInterface = f121751d;
        if (webViewReporterInterface != null) {
            webViewReporterInterface.idkeyStat(1749L, 12L, 1L);
        }
    }

    public static void p() {
        WebViewReporterInterface webViewReporterInterface = f121751d;
        if (webViewReporterInterface != null) {
            webViewReporterInterface.idkeyStat(1749L, 13L, 1L);
        }
    }

    public static void q() {
        WebViewReporterInterface webViewReporterInterface = f121751d;
        if (webViewReporterInterface != null) {
            webViewReporterInterface.idkeyStat(1749L, 14L, 1L);
        }
    }

    public static void r() {
        WebViewReporterInterface webViewReporterInterface = f121751d;
        if (webViewReporterInterface != null) {
            webViewReporterInterface.idkeyStat(577L, 20L, 1L);
        }
    }

    public static void s() {
        WebViewReporterInterface webViewReporterInterface = f121751d;
        if (webViewReporterInterface != null) {
            webViewReporterInterface.idkeyStat(577L, 21L, 1L);
        }
    }

    public static void t() {
        WebViewReporterInterface webViewReporterInterface = f121751d;
        if (webViewReporterInterface == null) {
            return;
        }
        webViewReporterInterface.idkeyStat(577L, 87L, 1L);
    }

    public static void u() {
        WebViewReporterInterface webViewReporterInterface = f121751d;
        if (webViewReporterInterface != null) {
            webViewReporterInterface.idkeyStat(1749L, 1L, 1L);
        }
    }

    public static void v() {
        WebViewReporterInterface webViewReporterInterface = f121751d;
        if (webViewReporterInterface != null) {
            webViewReporterInterface.idkeyStat(1749L, 0L, 1L);
        }
    }

    public static void w() {
        WebViewReporterInterface webViewReporterInterface = f121751d;
        if (webViewReporterInterface != null) {
            webViewReporterInterface.idkeyStat(577L, 190L, 1L);
        }
    }

    public static void x() {
        WebViewReporterInterface webViewReporterInterface = f121751d;
        if (webViewReporterInterface != null) {
            webViewReporterInterface.idkeyStat(577L, 189L, 1L);
        }
    }

    public static void y() {
        WebViewReporterInterface webViewReporterInterface = f121751d;
        if (webViewReporterInterface == null) {
            return;
        }
        webViewReporterInterface.idkeyStat(577L, 83L, 1L);
    }

    public static void z() {
        WebViewReporterInterface webViewReporterInterface = f121751d;
        if (webViewReporterInterface != null) {
            webViewReporterInterface.idkeyStat(577L, 167L, 1L);
        }
    }

    public static void a(WebViewReporterInterface webViewReporterInterface) {
        f121751d = webViewReporterInterface;
    }

    public static void f(long j3) {
        g(j3);
        WebViewReporterInterface webViewReporterInterface = f121751d;
        if (webViewReporterInterface == null || j3 <= 0 || j3 >= MiniBoxNoticeInfo.MIN_5) {
            return;
        }
        webViewReporterInterface.idkeyForPair(577, 577, 6, 7, 1, (int) j3);
    }

    public static void a(int i3, String str) {
        WebViewReporterInterface webViewReporterInterface = f121751d;
        if (webViewReporterInterface != null) {
            webViewReporterInterface.kvStat(i3, str);
        }
    }

    public static void e(String str) {
        int i3;
        WebViewReporterInterface webViewReporterInterface = f121751d;
        if (webViewReporterInterface != null) {
            webViewReporterInterface.idkeyStat(577L, 0L, 1L);
            if (f121748a.equals("tools") && str != null && a(str) == 1) {
                f121751d.idkeyStat(903L, 103L, 1L);
            }
            if (f121749b) {
                return;
            }
            if (f121748a.equals("tools")) {
                i3 = 70;
            } else {
                i3 = f121748a.equals("appbrand") ? 73 : -1;
            }
            int ordinal = WebView.getCurrentModuleWebCoreType().ordinal() - 1;
            if (WebView.getCurrentModuleWebCoreType() == WebView.WebViewKind.WV_KIND_PINUS) {
                ordinal = WebView.WebViewKind.WV_KIND_CW.ordinal() - 1;
            }
            if (i3 < 70 || ordinal < 0) {
                return;
            }
            f121749b = true;
            a(577, i3 + ordinal);
        }
    }

    public static void g() {
        WebViewReporterInterface webViewReporterInterface = f121751d;
        if (webViewReporterInterface != null) {
            webViewReporterInterface.idkeyStat(1749L, 3L, 1L);
        }
    }

    public static int b() {
        if (f121748a.equals("mm")) {
            return 30;
        }
        if (f121748a.equals("tools")) {
            return 36;
        }
        if (f121748a.equals("appbrand")) {
            return 48;
        }
        return f121748a.equals(TVKDeviceSpatialAudioCapabilityReportConstant.SPATIAL_AUDIO_CAPABILITY_PARAM_SURPPORT) ? 54 : -1;
    }

    public static void a(long j3, int i3) {
        WebViewReporterInterface webViewReporterInterface = f121751d;
        if (webViewReporterInterface != null) {
            webViewReporterInterface.idkeyStat(577L, j3, i3);
        }
    }

    public static void c(long j3) {
        WebViewReporterInterface webViewReporterInterface = f121751d;
        if (webViewReporterInterface == null || j3 <= 0 || j3 >= 600000) {
            return;
        }
        webViewReporterInterface.idkeyForPair(577, 577, 27, 28, 1, (int) j3);
    }

    public static void f(String str, boolean z16) {
        if (f121751d == null) {
            return;
        }
        int i3 = z16 ? 59 : 65;
        if (XWalkPluginManager.XWALK_PLUGIN_NAME_PPT.equals(str)) {
            f121751d.idkeyStat(1068L, i3, 1L);
            return;
        }
        if (XWalkPluginManager.XWALK_PLUGIN_NAME_PDF.equals(str)) {
            f121751d.idkeyStat(1071L, i3, 1L);
            return;
        }
        if (XWalkPluginManager.XWALK_PLUGIN_NAME_WORD.equals(str)) {
            f121751d.idkeyStat(1069L, i3, 1L);
            return;
        }
        if (XWalkPluginManager.XWALK_PLUGIN_NAME_EXCEL.equals(str)) {
            f121751d.idkeyStat(1070L, i3, 1L);
        } else if (XWalkPluginManager.XWALK_PLUGIN_NAME_OFFICE.equals(str)) {
            f121751d.idkeyStat(1544L, i3, 1L);
        } else if (XWalkPluginManager.XWALK_PLUGIN_NAME_TXT.equals(str)) {
            f121751d.idkeyStat(1889L, i3, 1L);
        }
    }

    public static void a(long j3, long j16, long j17) {
        WebViewReporterInterface webViewReporterInterface = f121751d;
        if (webViewReporterInterface != null) {
            webViewReporterInterface.idkeyStat(j3, j16, j17);
        }
    }

    public static void c(String str, boolean z16) {
        if (f121751d == null) {
            return;
        }
        int i3 = z16 ? 51 : 60;
        if (XWalkPluginManager.XWALK_PLUGIN_NAME_FULL_SCREEN_VIDEO.equals(str)) {
            f121751d.idkeyStat(577L, 185L, 1L);
            return;
        }
        if (XWalkPluginManager.XWALK_PLUGIN_NAME_PPT.equals(str)) {
            f121751d.idkeyStat(1068L, i3, 1L);
            return;
        }
        if (XWalkPluginManager.XWALK_PLUGIN_NAME_PDF.equals(str)) {
            f121751d.idkeyStat(1071L, i3, 1L);
            return;
        }
        if (XWalkPluginManager.XWALK_PLUGIN_NAME_WORD.equals(str)) {
            f121751d.idkeyStat(1069L, i3, 1L);
            return;
        }
        if (XWalkPluginManager.XWALK_PLUGIN_NAME_EXCEL.equals(str)) {
            f121751d.idkeyStat(1070L, i3, 1L);
        } else if (XWalkPluginManager.XWALK_PLUGIN_NAME_OFFICE.equals(str)) {
            f121751d.idkeyStat(1544L, i3, 1L);
        } else if (XWalkPluginManager.XWALK_PLUGIN_NAME_TXT.equals(str)) {
            f121751d.idkeyStat(1889L, i3, 1L);
        }
    }

    public static void b(int i3, boolean z16) {
        WebViewReporterInterface webViewReporterInterface = f121751d;
        if (webViewReporterInterface != null) {
            int i16 = i3 == 0 ? z16 ? 155 : 151 : i3 == 1 ? z16 ? 156 : 152 : i3 == 2 ? z16 ? 157 : 153 : i3 == 3 ? z16 ? 158 : 154 : 0;
            if (i16 > 0) {
                webViewReporterInterface.idkeyStat(577L, i16, 1L);
            }
        }
    }

    public static void a(int i3, int i16) {
        if (f121751d == null) {
            return;
        }
        SharedPreferences h16 = y0.h();
        String str = "id_" + i3 + "_key_" + i16;
        String format = new SimpleDateFormat(DateUtil.DATE_FORMAT_8).format(new Date());
        if (format.equals(h16.getString(str, ""))) {
            return;
        }
        f121751d.idkeyStat(i3, i16, 1L);
        h16.edit().putString(str, format).commit();
    }

    public static void b(long j3) {
        WebViewReporterInterface webViewReporterInterface = f121751d;
        if (webViewReporterInterface == null || j3 <= 0 || j3 >= 120000) {
            return;
        }
        webViewReporterInterface.idkeyForPair(577, 577, 16, 17, 1, (int) j3);
    }

    public static void b(WebView.WebViewKind webViewKind) {
        int i3;
        if (f121751d == null) {
            return;
        }
        if (webViewKind == WebView.WebViewKind.WV_KIND_CW || webViewKind == WebView.WebViewKind.WV_KIND_PINUS) {
            i3 = 82;
        } else if (webViewKind != WebView.WebViewKind.WV_KIND_SYS) {
            return;
        } else {
            i3 = 80;
        }
        f121751d.idkeyStat(577L, i3, 1L);
    }

    public static void e(long j3) {
        WebViewReporterInterface webViewReporterInterface = f121751d;
        if (webViewReporterInterface == null || j3 <= 0 || j3 >= MiniBoxNoticeInfo.MIN_5) {
            return;
        }
        webViewReporterInterface.idkeyForPair(577, 577, 48, 49, 1, (int) j3);
    }

    public static void b(String str, boolean z16) {
        if (f121751d == null) {
            return;
        }
        int i3 = z16 ? 55 : 63;
        if (XWalkPluginManager.XWALK_PLUGIN_NAME_FULL_SCREEN_VIDEO.equals(str)) {
            f121751d.idkeyStat(577L, 188L, 1L);
            return;
        }
        if (XWalkPluginManager.XWALK_PLUGIN_NAME_PPT.equals(str)) {
            f121751d.idkeyStat(1068L, i3, 1L);
            return;
        }
        if (XWalkPluginManager.XWALK_PLUGIN_NAME_PDF.equals(str)) {
            f121751d.idkeyStat(1071L, i3, 1L);
            return;
        }
        if (XWalkPluginManager.XWALK_PLUGIN_NAME_WORD.equals(str)) {
            f121751d.idkeyStat(1069L, i3, 1L);
            return;
        }
        if (XWalkPluginManager.XWALK_PLUGIN_NAME_EXCEL.equals(str)) {
            f121751d.idkeyStat(1070L, i3, 1L);
        } else if (XWalkPluginManager.XWALK_PLUGIN_NAME_OFFICE.equals(str)) {
            f121751d.idkeyStat(1544L, i3, 1L);
        } else if (XWalkPluginManager.XWALK_PLUGIN_NAME_TXT.equals(str)) {
            f121751d.idkeyStat(1889L, i3, 1L);
        }
    }

    public static void e(String str, boolean z16) {
        if (f121751d == null) {
            return;
        }
        int i3 = z16 ? 52 : 61;
        if (XWalkPluginManager.XWALK_PLUGIN_NAME_FULL_SCREEN_VIDEO.equals(str)) {
            f121751d.idkeyStat(577L, 186L, 1L);
            return;
        }
        if (XWalkPluginManager.XWALK_PLUGIN_NAME_PPT.equals(str)) {
            f121751d.idkeyStat(1068L, i3, 1L);
            return;
        }
        if (XWalkPluginManager.XWALK_PLUGIN_NAME_PDF.equals(str)) {
            f121751d.idkeyStat(1071L, i3, 1L);
            return;
        }
        if (XWalkPluginManager.XWALK_PLUGIN_NAME_WORD.equals(str)) {
            f121751d.idkeyStat(1069L, i3, 1L);
            return;
        }
        if (XWalkPluginManager.XWALK_PLUGIN_NAME_EXCEL.equals(str)) {
            f121751d.idkeyStat(1070L, i3, 1L);
        } else if (XWalkPluginManager.XWALK_PLUGIN_NAME_OFFICE.equals(str)) {
            f121751d.idkeyStat(1544L, i3, 1L);
        } else if (XWalkPluginManager.XWALK_PLUGIN_NAME_TXT.equals(str)) {
            f121751d.idkeyStat(1889L, i3, 1L);
        }
    }

    public static synchronized void a(String str, WebView webView) {
        synchronized (n0.class) {
            if (f121751d == null) {
                return;
            }
            Z();
            if (str != null && "https://servicewechat.com/preload/page-frame.html".equalsIgnoreCase(str.trim())) {
                f121751d.idkeyStat(903L, 102L, 1L);
            }
            int b16 = b();
            int ordinal = WebView.getCurrentModuleWebCoreType().ordinal() - 1;
            if (WebView.getCurrentModuleWebCoreType() == WebView.WebViewKind.WV_KIND_PINUS) {
                ordinal = WebView.WebViewKind.WV_KIND_CW.ordinal() - 1;
            }
            if (b16 >= 30 && ordinal >= 0) {
                f121751d.idkeyStat(903L, b16 + 0 + ordinal, 1L);
            }
        }
    }

    public static void f() {
        a(938L, 89L, 1L);
    }

    public static void c(String str) {
        if (f121751d == null) {
            return;
        }
        if (XWalkPluginManager.XWALK_PLUGIN_NAME_PPT.equals(str)) {
            f121751d.idkeyStat(1068L, 57L, 1L);
            return;
        }
        if (XWalkPluginManager.XWALK_PLUGIN_NAME_PDF.equals(str)) {
            f121751d.idkeyStat(1071L, 57L, 1L);
            return;
        }
        if (XWalkPluginManager.XWALK_PLUGIN_NAME_WORD.equals(str)) {
            f121751d.idkeyStat(1069L, 57L, 1L);
            return;
        }
        if (XWalkPluginManager.XWALK_PLUGIN_NAME_EXCEL.equals(str)) {
            f121751d.idkeyStat(1070L, 57L, 1L);
        } else if (XWalkPluginManager.XWALK_PLUGIN_NAME_OFFICE.equals(str)) {
            f121751d.idkeyStat(1544L, 57L, 1L);
        } else if (XWalkPluginManager.XWALK_PLUGIN_NAME_TXT.equals(str)) {
            f121751d.idkeyStat(1889L, 57L, 1L);
        }
    }

    public static void d(String str) {
        e(str);
        WebViewReporterInterface webViewReporterInterface = f121751d;
        if (webViewReporterInterface != null) {
            webViewReporterInterface.idkeyStat(577L, 4L, 1L);
        }
    }

    public static void d(long j3) {
        WebViewReporterInterface webViewReporterInterface = f121751d;
        if (webViewReporterInterface == null || j3 <= 0 || j3 >= 600000) {
            return;
        }
        webViewReporterInterface.idkeyForPair(577, 577, 11, 12, 1, (int) j3);
    }

    public static int a(String str) {
        if (str.startsWith("https://servicewechat.com/")) {
            return 0;
        }
        return (str.startsWith("http://mp.weixin.qq.com/") || str.startsWith("https://mp.weixin.qq.com/") || str.startsWith("https://servicewechat.com/preload/") || str.startsWith("http://mp.weixinbridge.com/")) ? 1 : 2;
    }

    public static void d(String str, boolean z16) {
        if (f121751d == null) {
            return;
        }
        int i3 = z16 ? 54 : 62;
        if (XWalkPluginManager.XWALK_PLUGIN_NAME_FULL_SCREEN_VIDEO.equals(str)) {
            f121751d.idkeyStat(577L, 187L, 1L);
            return;
        }
        if (XWalkPluginManager.XWALK_PLUGIN_NAME_PPT.equals(str)) {
            f121751d.idkeyStat(1068L, i3, 1L);
            return;
        }
        if (XWalkPluginManager.XWALK_PLUGIN_NAME_PDF.equals(str)) {
            f121751d.idkeyStat(1071L, i3, 1L);
            return;
        }
        if (XWalkPluginManager.XWALK_PLUGIN_NAME_WORD.equals(str)) {
            f121751d.idkeyStat(1069L, i3, 1L);
            return;
        }
        if (XWalkPluginManager.XWALK_PLUGIN_NAME_EXCEL.equals(str)) {
            f121751d.idkeyStat(1070L, i3, 1L);
        } else if (XWalkPluginManager.XWALK_PLUGIN_NAME_OFFICE.equals(str)) {
            f121751d.idkeyStat(1544L, i3, 1L);
        } else if (XWalkPluginManager.XWALK_PLUGIN_NAME_TXT.equals(str)) {
            f121751d.idkeyStat(1889L, i3, 1L);
        }
    }

    public static void a(int i3, boolean z16) {
        WebViewReporterInterface webViewReporterInterface = f121751d;
        if (webViewReporterInterface != null) {
            int i16 = i3 == 0 ? z16 ? 163 : 159 : i3 == 1 ? z16 ? 164 : 160 : i3 == 2 ? z16 ? 165 : 161 : i3 == 3 ? z16 ? 166 : 162 : 0;
            if (i16 > 0) {
                webViewReporterInterface.idkeyStat(577L, i16, 1L);
            }
        }
    }

    public static void b(String str) {
        if (f121751d == null) {
            return;
        }
        if (XWalkPluginManager.XWALK_PLUGIN_NAME_PPT.equals(str)) {
            f121751d.idkeyStat(1068L, 66L, 1L);
            return;
        }
        if (XWalkPluginManager.XWALK_PLUGIN_NAME_PDF.equals(str)) {
            f121751d.idkeyStat(1071L, 66L, 1L);
            return;
        }
        if (XWalkPluginManager.XWALK_PLUGIN_NAME_WORD.equals(str)) {
            f121751d.idkeyStat(1069L, 66L, 1L);
            return;
        }
        if (XWalkPluginManager.XWALK_PLUGIN_NAME_EXCEL.equals(str)) {
            f121751d.idkeyStat(1070L, 66L, 1L);
        } else if (XWalkPluginManager.XWALK_PLUGIN_NAME_OFFICE.equals(str)) {
            f121751d.idkeyStat(1544L, 66L, 1L);
        } else if (XWalkPluginManager.XWALK_PLUGIN_NAME_TXT.equals(str)) {
            f121751d.idkeyStat(1889L, 66L, 1L);
        }
    }

    public static String a() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static void e() {
        a(938L, 91L, 1L);
    }

    public static void a(WebView.WebViewKind webViewKind, int i3) {
        if (x.a("kv_" + o0.f121756a + webViewKind.toString() + "_" + i3)) {
            a aVar = new a(o0.f121756a);
            aVar.a(21, Integer.valueOf(i3));
            if (webViewKind != WebView.WebViewKind.WV_KIND_CW && webViewKind != WebView.WebViewKind.WV_KIND_PINUS) {
                if (webViewKind == WebView.WebViewKind.WV_KIND_SYS) {
                    aVar.a(22, Integer.valueOf(g.g()));
                } else {
                    aVar.a(22, 0);
                }
            } else {
                aVar.a(22, Integer.valueOf(XWalkEnvironment.getInstalledNewstVersionForCurAbi()));
            }
            aVar.a(23, Integer.valueOf(XWebSdk.getXWebSdkVersion()));
            if ("armeabi-v7a".equalsIgnoreCase(b.b())) {
                aVar.a(24, Integer.valueOf(o0.f121759d));
            } else if ("arm64-v8a".equalsIgnoreCase(b.b())) {
                aVar.a(24, Integer.valueOf(o0.f121760e));
            }
            aVar.a(25, Integer.valueOf(webViewKind.ordinal()));
            aVar.a();
        }
    }

    public static boolean c() {
        return f121751d != null;
    }

    public static void d() {
        a(938L, 90L, 1L);
    }

    public static void a(long j3) {
        WebViewReporterInterface webViewReporterInterface = f121751d;
        if (webViewReporterInterface == null || j3 <= 0 || j3 >= 600000) {
            return;
        }
        webViewReporterInterface.idkeyForPair(577, 577, 22, 23, 1, (int) j3);
    }

    public static void a(WebView.WebViewKind webViewKind) {
        int i3;
        if (f121751d == null) {
            return;
        }
        if (webViewKind == WebView.WebViewKind.WV_KIND_CW || webViewKind == WebView.WebViewKind.WV_KIND_PINUS) {
            i3 = 86;
        } else if (webViewKind != WebView.WebViewKind.WV_KIND_SYS) {
            return;
        } else {
            i3 = 84;
        }
        f121751d.idkeyStat(577L, i3, 1L);
    }

    public static void a(String str, boolean z16) {
        a(1511L, (z16 ? 0 : 100) + (a0.c(str).b() % 100), 1L);
    }

    public static void a(WebView.WebViewKind webViewKind, boolean z16, String str) {
        int i3;
        if (f121751d == null) {
            return;
        }
        if (webViewKind == WebView.WebViewKind.WV_KIND_PINUS) {
            i3 = z16 ? 78 : 82;
        } else if (webViewKind == WebView.WebViewKind.WV_KIND_CW) {
            i3 = z16 ? 77 : 81;
        } else if (webViewKind != WebView.WebViewKind.WV_KIND_SYS) {
            return;
        } else {
            i3 = z16 ? 75 : 79;
        }
        f121751d.idkeyStat(1749L, i3, 1L);
        com.tencent.luggage.wxa.wq.q.a(webViewKind, z16 ? 1 : 2, 2, false, str);
    }
}
