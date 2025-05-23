package com.tencent.mobileqq.vassplash.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.ViewConfiguration;
import com.tencent.mobileqq.ad.api.IAdApi;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.m;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vfs.d;
import com.tencent.mobileqq.webview.api.IWebProcessPreload;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.VasC2SReporter;
import cooperation.vip.ad.license.g;
import cooperation.vip.ad.w;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import o43.a;

/* compiled from: P */
/* loaded from: classes20.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static final String f312373a = d.f312455e;

    /* renamed from: b, reason: collision with root package name */
    public static final String f312374b = AppConstants.SDCARD_PATH + "qbdownres";

    /* renamed from: c, reason: collision with root package name */
    public static boolean f312375c = false;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f312376d = false;

    /* renamed from: e, reason: collision with root package name */
    public static String f312377e = "aid";

    /* renamed from: f, reason: collision with root package name */
    public static int f312378f = 102;

    /* renamed from: g, reason: collision with root package name */
    public static HashMap<String, o43.a> f312379g = new HashMap<>();

    /* renamed from: h, reason: collision with root package name */
    public static o43.a f312380h;

    public static HashMap<String, o43.a> a(String str, Set<String> set) {
        String str2;
        String str3 = "QSplash@VasSplashUtil";
        SharedPreferences l3 = l(BaseApplication.getContext(), str + "");
        if (l3 == null) {
            return f312379g;
        }
        try {
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                String next = it.next();
                String string = l3.getString("vas_splash_ad_begin_time_" + next, "");
                String string2 = l3.getString("vas_splash_ad_end_time_" + next, "");
                int i3 = l3.getInt("vas_plash_ad_content_type_" + next, -1);
                String string3 = l3.getString("vas_splash_ad_download_url_" + next, "");
                int i16 = l3.getInt("vas_splash_ad_jumptype_" + next, -1);
                String string4 = l3.getString("vas_splash_ad_jump_h5_url_" + next, "");
                String string5 = l3.getString("vas_splash_ad_jump_reward_h5_url_" + next, "");
                int i17 = l3.getInt("vas_splash_ad_exposure_platform_" + next, 0);
                StringBuilder sb5 = new StringBuilder();
                Iterator<String> it5 = it;
                sb5.append("vas_exposure_is_low_device_limit_");
                sb5.append(next);
                boolean z16 = l3.getBoolean(sb5.toString(), false);
                StringBuilder sb6 = new StringBuilder();
                String str4 = str3;
                try {
                    sb6.append("vas_splash_ad_is_limited_");
                    sb6.append(next);
                    boolean z17 = l3.getBoolean(sb6.toString(), false);
                    int i18 = l3.getInt("vas_splash_ad_showpriority_" + next, 0);
                    String string6 = l3.getString("vas_splash_info_report_" + next, "");
                    String string7 = l3.getString("vas_splash_resource_md5_" + next, "");
                    String string8 = l3.getString("vas_splash_union_banner_type_" + next, "-1");
                    int i19 = l3.getInt("vas_splash_should_show_ad_mark_" + next, 0);
                    String string9 = l3.getString("vas_splash_ad_entry_text_" + next, "");
                    String string10 = l3.getString("vas_splash_ad_entry_text_color_" + next, "");
                    String string11 = l3.getString("vas_splash_ad_entry_text_bg_color_" + next, "");
                    int i26 = l3.getInt("vas_splash_ad_entry_btn_type" + next, 0);
                    String string12 = l3.getString("vas_splash_ad_entry_btn_url" + next, "");
                    int i27 = l3.getInt("vas_splash_ad_entry_shake_btn_type" + next, 0);
                    String string13 = l3.getString("vas_splash_ad_entry_shake_title" + next, "");
                    String string14 = l3.getString("vas_splash_ad_entry_shake_desc" + next, "");
                    String string15 = l3.getString("vas_splash_ad_entry_shake_circle_bg_color" + next, "");
                    float f16 = l3.getFloat("vas_splash_ad_entry_shake_accele_ration" + next, 0.0f);
                    int i28 = l3.getInt("vas_splash_ad_entry_shake_trigger" + next, 0);
                    float f17 = l3.getFloat("vas_splash_ad_entry_shake_x_axis" + next, 0.0f);
                    float f18 = l3.getFloat("vas_splash_ad_entry_shake_y_axis" + next, 0.0f);
                    float f19 = l3.getFloat("vas_splash_ad_entry_shake_z_axis" + next, 0.0f);
                    int i29 = l3.getInt("vas_splash_ad_entry_twist_angle_" + next, 0);
                    int i36 = l3.getInt("vas_splash_ad_entry_twist_reverse_angle_" + next, 0);
                    int i37 = l3.getInt("vas_splash_ad_entry_flip_card_angle_" + next, 0);
                    String string16 = l3.getString("vas_splash_ad_entry_flip_card_jump_text" + next, "");
                    String string17 = l3.getString("vas_splash_ad_entry_flip_card_logo" + next, "");
                    String string18 = l3.getString("vas_splash_ad_entry_flip_card_product" + next, "");
                    List<String> asList = Arrays.asList(l3.getString("vas_exposure_url_" + next, ""), l3.getString("vas_exposure_url_1_" + next, ""), l3.getString("vas_exposure_url_2_" + next, ""), l3.getString("vas_exposure_url_3_" + next, ""), l3.getString("vas_exposure_url_4_" + next, ""));
                    List<String> asList2 = Arrays.asList(l3.getString("vas_splash_ad_entry_click_c2s_url" + next, ""), l3.getString("vas_splash_ad_entry_click_c2s_url_1_" + next, ""), l3.getString("vas_splash_ad_entry_click_c2s_url_2_" + next, ""), l3.getString("vas_splash_ad_entry_click_c2s_url_3_" + next, ""), l3.getString("vas_splash_ad_entry_click_c2s_url_4_" + next, ""));
                    long j3 = l3.getLong("vas_splash_ad_entry_splash_duration" + next, 0L);
                    int i38 = l3.getInt("vas_splash_ad_entry_sensitivity_" + next, 0);
                    String string19 = l3.getString("vas_splash_ad_entry_text_bg_end_color_" + next, "");
                    String string20 = l3.getString("vas_splash_ad_entry_text_bg_press_color_" + next, "");
                    int i39 = l3.getInt("vas_splash_ad_entry_hotzone_height_" + next, 0);
                    int i46 = l3.getInt("vas_splash_ad_entry_track_switch_" + next, 0);
                    String string21 = l3.getString("vas_splash_ad_entry_arrow_" + next, "");
                    String string22 = l3.getString("vas_splash_ad_entry_arrow_end_" + next, "");
                    String string23 = l3.getString("vas_splash_ad_entry_arrow_path_" + next, "");
                    String string24 = l3.getString("vas_splash_ad_entry_arrow_end_path_" + next, "");
                    String string25 = l3.getString("vas_splash_ad_logo_" + next, "");
                    String string26 = l3.getString("vas_splash_ad_logo_path_" + next, "");
                    String string27 = l3.getString("vas_splash_ad_jump_app_schema" + next, "");
                    String string28 = l3.getString("vas_splash_ad_entry_slide_icon_" + next, "");
                    String string29 = l3.getString("vas_splash_ad_entry_slide_icon_path_" + next, "");
                    int i47 = l3.getInt("vas_splash_ad_entry_detect_angle_" + next, 0);
                    int i48 = l3.getInt("vas_splash_ad_entry_is_ad_splash" + next, 0);
                    boolean z18 = l3.getBoolean("VAS_SPLASH_AD_GREETING_1" + next, false);
                    String string30 = l3.getString("VAS_SPLASH_AD_GREETING_2" + next, "");
                    String string31 = l3.getString("VAS_SPLASH_AD_GREETING_3" + next, "");
                    String string32 = l3.getString("VAS_SPLASH_AD_GREETING_5" + next, "");
                    String string33 = l3.getString("VAS_SPLASH_AD_GREETING_4" + next, "");
                    a.C10882a c10882a = new a.C10882a();
                    c10882a.g0(str).b(next).d(string).k(string2).g(i3).j(string3).q(i17).r(asList).z(string4).A(string5).B(i16).C(z16).e(z17).D(i18).F(string6).E(string7).P(i19).c(string8).o(string9).p(string10).l(string11).m(i26).n(string12).H(i27).K(string13).J(string14).I(string15).G(f16).L(i28).M(f17).N(f18).O(f19).f(asList2).S(j3).c0(i38).Z(string19).a0(string20).b0(i39).d0(i46).V(string21).W(string22).Y(string23).X(string24).T(string25).U(string26).y(string27).Q(string28).h(i47).e0(i29).f0(i36).s(i37).t(string16).u(string17).v(string18).R(string29).x(i48).w(z18, string30, string31, string32, string33);
                    str2 = str4;
                    try {
                        QLog.i(str2, 1, "buildADEntryFromSP  adid =" + next);
                        f312379g.put(next, c10882a.a());
                        str3 = str2;
                        it = it5;
                    } catch (Exception e16) {
                        e = e16;
                        QLog.e(str2, 1, "buildADEntryFromSP exception" + e.toString());
                        return f312379g;
                    }
                } catch (Exception e17) {
                    e = e17;
                    str2 = str4;
                }
            }
        } catch (Exception e18) {
            e = e18;
            str2 = str3;
        }
        return f312379g;
    }

    public static void b(Context context, long j3, boolean z16) {
        if (context == null) {
            return;
        }
        try {
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
            edit.remove("vas_splash_ad_ids_with_showdate_with_priority_" + j3);
            edit.remove("vas_splash_ad_ids_with_showdate_with_priority_0");
            edit.apply();
            QLog.i("QSplash@VasSplashUtil", 1, "cleanAllConfig ");
        } catch (Exception e16) {
            QLog.e("QSplash@VasSplashUtil", 1, "cleanAllConfig exception" + e16.toString());
        }
    }

    public static void c(String str) {
        SharedPreferences.Editor edit = l(BaseApplication.getContext(), str).edit();
        edit.remove("vas_union_banner_current_");
        edit.apply();
    }

    public static void d(String str) {
        try {
            QLog.i("QSplash@VasSplashUtil", 1, "cleanOldSplashResDir sub" + str);
            File file = new File(str);
            if (file.exists() && file.isFile()) {
                file.delete();
            }
        } catch (Exception e16) {
            QLog.e("QSplash@VasSplashUtil", 1, "cleanOldSplashResDir exception" + e16.toString());
        }
    }

    private static int e(o43.a aVar) {
        if (aVar != null && !TextUtils.isEmpty(aVar.f421925b)) {
            try {
                return Integer.parseInt(aVar.f421925b);
            } catch (NumberFormatException e16) {
                QLog.e("QSplash@VasSplashUtil", 1, "getAdIdInteger e = " + e16);
            }
        }
        return 0;
    }

    public static List<String> f(Map<String, String> map, String str) {
        String str2;
        ArrayList arrayList = new ArrayList();
        if (map == null) {
            return arrayList;
        }
        for (int i3 = 0; i3 < 5; i3++) {
            if (i3 == 0) {
                str2 = str;
            } else {
                str2 = str + i3;
            }
            if (map.containsKey(str)) {
                arrayList.add(map.get(str2));
            }
        }
        return arrayList;
    }

    public static List<String> g(SharedPreferences sharedPreferences, String str, String str2) {
        String str3;
        ArrayList arrayList = new ArrayList();
        if (sharedPreferences == null) {
            return arrayList;
        }
        for (int i3 = 0; i3 < 5; i3++) {
            if (i3 == 0) {
                str3 = str;
            } else {
                str3 = str + i3 + "_";
            }
            String str4 = str3 + str2;
            if (sharedPreferences.contains(str4)) {
                arrayList.add(sharedPreferences.getString(str4, ""));
            }
        }
        return arrayList;
    }

    public static String h(String str) {
        return l(BaseApplication.getContext(), str).getString("vas_union_banner_current_", "");
    }

    public static String i(Set<String> set) {
        String str;
        if (set != null && set.size() > 0) {
            StringBuffer stringBuffer = new StringBuffer();
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                stringBuffer.append(it.next());
                stringBuffer.append(",");
            }
            str = stringBuffer.substring(0, stringBuffer.length() - 1);
        } else {
            str = "";
        }
        QLog.i("QSplash@VasSplashUtil", 1, "getLocalAdIds  adids =" + str);
        return str;
    }

    public static Set<String> j(Context context, String str) {
        String string = l(context, str).getString("splash_ad_ids", "");
        HashSet hashSet = new HashSet();
        if (!TextUtils.isEmpty(string)) {
            hashSet.addAll(Arrays.asList(string.split(",")));
        }
        QLog.i("QSplash@VasSplashUtil", 1, "getLocalAdIds frosm sp  adids =" + hashSet);
        return hashSet;
    }

    public static List<String> k(Context context, long j3) {
        ArrayList arrayList = null;
        try {
            String string = PreferenceManager.getDefaultSharedPreferences(context).getString("vas_splash_ad_ids_with_showdate_with_priority_" + j3, "");
            QLog.i("QSplash@VasSplashUtil", 1, "idsWithTime = " + string);
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            ArrayList arrayList2 = new ArrayList();
            try {
                String[] split = string.split(",");
                int i3 = 0;
                while (true) {
                    int i16 = i3 + 2;
                    if (i16 < split.length) {
                        String str = split[i3];
                        if (q(split[i3 + 1], split[i16])) {
                            arrayList2.add(str);
                            QLog.i("QSplash@VasSplashUtil", 1, "permittedAdIDs = " + str);
                        }
                        i3 += 3;
                    } else {
                        return arrayList2;
                    }
                }
            } catch (Exception e16) {
                e = e16;
                arrayList = arrayList2;
                QLog.e("QSplash@VasSplashUtil", 1, "getPermittedAdIDs exception" + e.toString());
                return arrayList;
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

    public static SharedPreferences l(Context context, String str) {
        return context.getSharedPreferences("vas_splash_ad_pref_" + str, 0);
    }

    public static boolean m(long j3) {
        boolean z16 = false;
        try {
            List<String> k3 = k(BaseApplication.getContext(), j3);
            if (k3 != null) {
                if (k3.size() > 0) {
                    try {
                        HashMap<String, o43.a> a16 = a(j3 + "", j(BaseApplication.getContext(), j3 + ""));
                        QLog.i("QSplash@VasSplashUtil", 1, "hasSplashADNeedShow   | uinStr = " + j3 + " | localAdEntries.size = " + a16.size());
                        o43.a aVar = null;
                        for (String str : k3) {
                            if (!a16.containsKey(str)) {
                                QLog.e("QSplash@VasSplashUtil", 1, "hasSplashADNeedShow  !adEntries.containsKey(adId)");
                            } else {
                                o43.a aVar2 = a16.get(str);
                                if (aVar2 == null) {
                                    QLog.e("QSplash@VasSplashUtil", 1, "hasSplashADNeedShow  entry == null");
                                } else {
                                    boolean e16 = g.g().e(str);
                                    QLog.i("QSplash@VasSplashUtil", 1, "hasSplashADNeedShow   | licenseCanShow = " + e16 + " | showPriority = " + aVar2.f421949n + " | splashEntry = " + aVar2.toString());
                                    if (!e16) {
                                        QLog.w("QSplash@VasSplashUtil", 1, "hasSplashADNeedShow  can not show, adId = " + str);
                                        HashMap hashMap = new HashMap();
                                        hashMap.put(f312377e, aVar2.f421925b);
                                        ((IAdApi) QRoute.api(IAdApi.class)).report("splash_ad_license_limit", hashMap);
                                        w.q(aVar2.f421925b, 147, aVar2.f421950o);
                                    } else if (aVar2.h()) {
                                        if (aVar != null) {
                                            int i3 = aVar2.f421949n;
                                            int i16 = aVar.f421949n;
                                            if (i3 <= i16) {
                                                if (i3 == i16 && e(aVar2) < e(aVar)) {
                                                }
                                            }
                                        }
                                        aVar = aVar2;
                                    } else {
                                        HashMap hashMap2 = new HashMap();
                                        hashMap2.put(f312377e, aVar2.f421925b);
                                        ((IAdApi) QRoute.api(IAdApi.class)).report("splash_ad_preload_failed", hashMap2);
                                        w.q(aVar2.f421925b, 151, aVar2.f421950o);
                                    }
                                }
                            }
                        }
                        f312380h = aVar;
                        return true;
                    } catch (Exception e17) {
                        e = e17;
                        z16 = true;
                        QLog.e("QSplash@VasSplashUtil", 1, "hasSplashADNeedShow exception" + e.toString());
                        return z16;
                    }
                }
            }
        } catch (Exception e18) {
            e = e18;
        }
        return z16;
    }

    public static boolean n(ViewConfiguration viewConfiguration, float f16, float f17, float f18, float f19) {
        if (viewConfiguration == null) {
            return false;
        }
        float f26 = f18 - f16;
        float f27 = f19 - f17;
        if ((f26 * f26) + (f27 * f27) > viewConfiguration.getScaledTouchSlop() * viewConfiguration.getScaledTouchSlop()) {
            return false;
        }
        return true;
    }

    public static boolean o(String str) {
        if (NetConnInfoCenter.getServerTime() > z(str)) {
            return true;
        }
        return false;
    }

    public static boolean p(int i3, int i16, int i17) {
        boolean z16 = false;
        if (1 == i3) {
            long c16 = m.c();
            if ((i17 != 0 && Build.VERSION.SDK_INT <= i17) || (c16 != 0 && i16 != 0 && c16 <= i16 * 1024 * 1024)) {
                z16 = true;
            }
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder("openDisabledLowerDevice ");
                sb5.append(" sdk_int:" + i17);
                sb5.append(" mem:" + i16);
                QLog.d("QSplash@VasSplashUtil", 2, sb5.toString());
            }
        } else if (QLog.isColorLevel()) {
            QLog.d("QSplash@VasSplashUtil", 2, "isDisabledLowerDevice false");
        }
        return z16;
    }

    public static boolean q(String str, String str2) {
        long z16 = z(str2);
        long z17 = z(str);
        long serverTime = NetConnInfoCenter.getServerTime();
        if (z17 < serverTime && serverTime < z16) {
            return true;
        }
        return false;
    }

    public static void r(String str, String str2) {
        SharedPreferences.Editor edit = l(BaseApplication.getContext(), str2).edit();
        edit.putString("vas_union_banner_current_", str);
        edit.apply();
    }

    public static String s(String str, long j3, boolean z16) {
        String str2;
        boolean z17;
        String str3;
        try {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
            SharedPreferences.Editor edit = defaultSharedPreferences.edit();
            String string = defaultSharedPreferences.getString("vas_splash_ad_ids_with_showdate_with_priority_" + j3, "");
            StringBuffer stringBuffer = new StringBuffer();
            if (TextUtils.isEmpty(string) || TextUtils.isEmpty(str)) {
                str2 = "";
                z17 = false;
            } else {
                String[] split = string.split(",");
                str2 = "";
                int i3 = 0;
                boolean z18 = false;
                while (true) {
                    int i16 = i3 + 2;
                    if (i16 >= split.length) {
                        break;
                    }
                    String str4 = split[i3];
                    if (!z18 && str.equals(str4)) {
                        z18 = true;
                        str2 = str4;
                    } else {
                        stringBuffer.append(split[i3]);
                        stringBuffer.append(",");
                        stringBuffer.append(split[i3 + 1]);
                        stringBuffer.append(",");
                        stringBuffer.append(split[i16]);
                        stringBuffer.append(",");
                    }
                    i3 += 3;
                }
                if (stringBuffer.length() == 0) {
                    str3 = "";
                } else {
                    str3 = stringBuffer.substring(0, stringBuffer.length() - 1);
                }
                QLog.i("QSplash@VasSplashUtil", 1, "removeHasShowAdIDs result=" + str3 + "removeid = " + str);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("vas_splash_ad_ids_with_showdate_with_priority_");
                sb5.append(j3);
                edit.putString(sb5.toString(), str3);
                edit.apply();
                z17 = z18;
            }
            if (!z16 || !z17) {
                return "";
            }
            return l(BaseApplication.getContext(), j3 + "").getString("vas_splash_info_report_" + str2, "");
        } catch (Exception unused) {
            QLog.i("QSplash@VasSplashUtil", 1, "removeHasShowAdIDs exception");
            return null;
        }
    }

    public static void t(List<String> list) {
        if (list == null) {
            return;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            VasC2SReporter.d(list.get(i3));
            if (QLog.isDebugVersion()) {
                QLog.d("VasSplashBannerAd", 2, "report c2s url: " + list.get(i3));
            }
        }
    }

    public static void u(o43.a aVar) {
        if (aVar != null) {
            try {
                List<String> list = aVar.S;
                if (list != null) {
                    for (String str : list) {
                        if (!TextUtils.isEmpty(str)) {
                            VasC2SReporter.d(str);
                        }
                    }
                    return;
                }
            } catch (Exception e16) {
                QLog.e("QSplash@VasSplashUtil", 1, "report c2s failed ", e16);
                return;
            }
        }
        QLog.i("QSplash@VasSplashUtil", 1, "cancel report c2s");
    }

    public static void v(o43.a aVar) {
        String str;
        if (aVar != null) {
            try {
                if (aVar.f421935g == 1) {
                    HashMap hashMap = new HashMap();
                    if (((IWebProcessPreload) QRoute.api(IWebProcessPreload.class)).isWebProcessExist()) {
                        str = "1";
                    } else {
                        str = "0";
                    }
                    hashMap.put("start_method", str);
                    hashMap.put("ad_id", aVar.f421925b);
                    String currentUin = VasUtil.getCurrentUin();
                    hashMap.put("user_uin", currentUin);
                    QQBeaconReport.reportWithAppKey("0AND08LTWK4AJ4RB", currentUin, QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_OPEN_LANDING_PAGE, hashMap);
                    return;
                }
            } catch (Exception e16) {
                QLog.e("QSplash@VasSplashUtil", 1, "reportOpenWebEvent failed ", e16);
                return;
            }
        }
        QLog.i("QSplash@VasSplashUtil", 1, "cancel report to beacon");
    }

    public static void w(List<String> list, String str, String str2, SharedPreferences.Editor editor) {
        String str3;
        if (editor != null && list != null) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                if (!TextUtils.isEmpty(list.get(i3)) && !list.get(i3).startsWith("https")) {
                    list.set(i3, list.get(i3).replaceFirst("http", "https"));
                }
                if (i3 > 0) {
                    str3 = str + i3 + "_";
                } else {
                    str3 = str;
                }
                editor.putString(str3 + str2, list.get(i3));
            }
        }
    }

    public static Float x(String str) {
        float f16 = 0.0f;
        try {
            if (!TextUtils.isEmpty(str)) {
                f16 = Float.parseFloat(str);
            }
        } catch (Exception e16) {
            QLog.e("QSplash@VasSplashUtil", 1, "StringToFloat exception" + e16.toString());
        }
        return Float.valueOf(f16);
    }

    public static int y(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            return Integer.parseInt(str);
        } catch (Exception e16) {
            QLog.e("QSplash@VasSplashUtil", 1, "StringToInt exception" + e16.toString());
            return 0;
        }
    }

    public static long z(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return 0L;
            }
            return Long.parseLong(str);
        } catch (Exception e16) {
            QLog.e("QSplash@VasSplashUtil", 1, "StringToLong exception" + e16.toString());
            return 0L;
        }
    }
}
