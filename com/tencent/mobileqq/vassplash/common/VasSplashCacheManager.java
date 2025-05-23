package com.tencent.mobileqq.vassplash.common;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.biz.richframework.util.RFWFileUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.splashad.SplashADUtil;
import com.tencent.mobileqq.utils.bl;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.vip.ad.w;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes20.dex */
public class VasSplashCacheManager {
    public static void b(final String str) {
        RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.vassplash.common.VasSplashCacheManager.1
            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(str)) {
                    QLog.e("QSplash@VasSplashCacheManager", 1, "deleteConfigDataAndFile  uin is empty");
                    return;
                }
                SharedPreferences l3 = c.l(BaseApplication.getContext(), str);
                if (l3 != null) {
                    l3.edit().clear().apply();
                    QLog.i("QSplash@VasSplashCacheManager", 1, "deleteConfigDataAndFile  no splashInfo, clean local sp");
                }
                if (c.f312380h == null) {
                    RFWFileUtils.deleteFile(VFSAssistantUtils.getSDKPrivatePath(c.f312373a));
                    QLog.i("QSplash@VasSplashCacheManager", 1, "deleteConfigDataAndFile  no splashInfo, delete local media file");
                }
            }
        });
    }

    public static void d(QQAppInterface qQAppInterface, String str, List<o43.a> list) {
        if (bl.b(list)) {
            QLog.w("QSplash@VasSplashCacheManager", 1, "saveSplashInfoToSP   splashItemList is empty");
            b(str);
            return;
        }
        QLog.d("QSplash@VasSplashCacheManager", 1, "saveSplashInfoToSP  splashItemList = " + Arrays.toString(list.toArray()));
        ArrayList arrayList = new ArrayList();
        try {
            SplashADUtil.z(qQAppInterface.getApp(), c.z(str));
            for (o43.a aVar : list) {
                if (aVar != null) {
                    arrayList.add(aVar);
                    int i3 = aVar.f421935g;
                    if (i3 == 3 || i3 == 2) {
                        ((IMiniAppService) QRoute.api(IMiniAppService.class)).prePullAppinfoByLink(aVar.f421937h, false, null);
                    }
                    c.f312379g.put(aVar.f421925b, aVar);
                }
            }
            if (arrayList.size() > 0) {
                SharedPreferences l3 = c.l(BaseApplication.getContext(), str);
                if (l3 == null) {
                    QLog.e("QSplash@VasSplashCacheManager", 1, "saveSplashInfoToSP  sp == null");
                    return;
                }
                SharedPreferences.Editor edit = l3.edit();
                Set<String> j3 = c.j(BaseApplication.getContext(), str);
                QLog.i("QSplash@VasSplashCacheManager", 1, "saveSplashInfoToSP :  old localIds = " + j3);
                HashSet hashSet = new HashSet();
                StringBuilder sb5 = new StringBuilder();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    o43.a aVar2 = (o43.a) it.next();
                    String str2 = aVar2.f421925b;
                    hashSet.add(str2);
                    sb5.append(str2);
                    sb5.append(",");
                    sb5.append(aVar2.f421927c);
                    sb5.append(",");
                    sb5.append(aVar2.f421929d);
                    sb5.append(",");
                    if (j3.contains(str2)) {
                        j3.remove(str2);
                        f(edit, aVar2, false);
                    } else {
                        f(edit, aVar2, true);
                    }
                }
                SharedPreferences.Editor edit2 = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit();
                edit.putString("splash_ad_ids", c.i(hashSet));
                edit2.putString("vas_splash_ad_ids_with_showdate_with_priority_" + str, sb5.substring(0, sb5.length() - 1));
                edit.apply();
                edit2.apply();
                QLog.i("QSplash@VasSplashCacheManager", 1, "saveSplashInfoToSP : updateIds = " + hashSet);
                b.d(qQAppInterface, arrayList);
            }
        } catch (Exception e16) {
            QLog.e("QSplash@VasSplashCacheManager", 1, "saveSplashInfoToSP Exception: " + e16);
            for (o43.a aVar3 : list) {
                if (aVar3 != null) {
                    w.q(aVar3.f421925b, 143, e16.getMessage());
                }
            }
        }
    }

    public static void e(final QQAppInterface qQAppInterface, final String str, final List<o43.a> list) {
        RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.vassplash.common.a
            @Override // java.lang.Runnable
            public final void run() {
                VasSplashCacheManager.d(QQAppInterface.this, str, list);
            }
        });
    }

    public static void f(SharedPreferences.Editor editor, o43.a aVar, boolean z16) {
        boolean z17;
        editor.putString("vas_splash_ad_begin_time_" + aVar.f421925b, aVar.f421927c);
        editor.putString("vas_splash_ad_end_time_" + aVar.f421925b, aVar.f421929d);
        editor.putInt("vas_plash_ad_content_type_" + aVar.f421925b, aVar.f421931e);
        editor.putString("vas_splash_ad_download_url_" + aVar.f421925b, aVar.f421933f);
        editor.putInt("vas_splash_ad_jumptype_" + aVar.f421925b, aVar.f421935g);
        editor.putString("vas_splash_ad_jump_h5_url_" + aVar.f421925b, aVar.f421937h);
        editor.putString("vas_splash_ad_jump_reward_h5_url_" + aVar.f421925b, aVar.f421939i);
        editor.putInt("vas_splash_ad_showpriority_" + aVar.f421925b, aVar.f421949n);
        editor.putBoolean("vas_exposure_is_low_device_limit_" + aVar.f421925b, aVar.f421953r);
        editor.putInt("vas_splash_ad_exposure_platform_" + aVar.f421925b, aVar.f421943k);
        editor.putString("vas_splash_info_report_" + aVar.f421925b, aVar.f421950o);
        editor.putString("vas_splash_resource_md5_" + aVar.f421925b, aVar.f421951p);
        editor.putInt("vas_splash_should_show_ad_mark_" + aVar.f421925b, aVar.f421952q);
        editor.putString("vas_splash_union_banner_type_" + aVar.f421925b, aVar.f421955t);
        editor.putString("vas_splash_ad_entry_text_" + aVar.f421925b, aVar.f421956u);
        editor.putString("vas_splash_ad_entry_text_color_" + aVar.f421925b, aVar.f421957v);
        editor.putString("vas_splash_ad_entry_text_bg_color_" + aVar.f421925b, aVar.f421958w);
        editor.putInt("vas_splash_ad_entry_detect_angle_" + aVar.f421925b, aVar.f421961z);
        editor.putString("vas_splash_ad_entry_slide_icon_" + aVar.f421925b, aVar.f421959x);
        editor.putString("vas_splash_ad_entry_slide_icon_path_" + aVar.f421925b, aVar.f421960y);
        editor.putInt("vas_splash_ad_entry_is_ad_splash" + aVar.f421925b, aVar.f421936g0);
        editor.putBoolean("VAS_SPLASH_AD_GREETING_1" + aVar.f421925b, aVar.f421938h0);
        editor.putString("VAS_SPLASH_AD_GREETING_2" + aVar.f421925b, aVar.f421940i0);
        editor.putString("VAS_SPLASH_AD_GREETING_3" + aVar.f421925b, aVar.f421942j0);
        editor.putString("VAS_SPLASH_AD_GREETING_5" + aVar.f421925b, aVar.f421944k0);
        editor.putString("VAS_SPLASH_AD_GREETING_4" + aVar.f421925b, aVar.f421946l0);
        List<String> list = aVar.T;
        if (list != null) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                if (i3 < aVar.T.size() && !TextUtils.isEmpty(aVar.T.get(i3)) && !aVar.T.get(i3).startsWith("https")) {
                    list.set(i3, aVar.T.get(i3).replaceFirst("http", "https"));
                }
            }
            if (list.size() >= 5) {
                editor.putString("vas_exposure_url_" + aVar.f421925b, list.get(0));
                editor.putString("vas_exposure_url_1_" + aVar.f421925b, list.get(1));
                editor.putString("vas_exposure_url_2_" + aVar.f421925b, list.get(2));
                editor.putString("vas_exposure_url_3_" + aVar.f421925b, list.get(3));
                editor.putString("vas_exposure_url_4_" + aVar.f421925b, list.get(4));
            }
        }
        boolean d16 = o43.a.d(aVar.f421945l, true);
        if (!aVar.f421953r && d16 && aVar.c()) {
            z17 = true;
        } else {
            z17 = false;
        }
        aVar.f421954s = z17;
        editor.putBoolean("vas_splash_ad_is_limited_" + aVar.f421925b, aVar.f421954s);
        editor.putInt("vas_splash_ad_entry_btn_type" + aVar.f421925b, aVar.G);
        editor.putString("vas_splash_ad_entry_btn_url" + aVar.f421925b, aVar.H);
        editor.putInt("vas_splash_ad_entry_shake_btn_type" + aVar.f421925b, aVar.J);
        editor.putString("vas_splash_ad_entry_shake_title" + aVar.f421925b, aVar.K);
        editor.putString("vas_splash_ad_entry_shake_desc" + aVar.f421925b, aVar.L);
        editor.putString("vas_splash_ad_entry_shake_circle_bg_color" + aVar.f421925b, aVar.M);
        editor.putFloat("vas_splash_ad_entry_shake_accele_ration" + aVar.f421925b, aVar.N);
        editor.putInt("vas_splash_ad_entry_shake_trigger" + aVar.f421925b, aVar.O);
        editor.putFloat("vas_splash_ad_entry_shake_x_axis" + aVar.f421925b, aVar.P);
        editor.putFloat("vas_splash_ad_entry_shake_y_axis" + aVar.f421925b, aVar.Q);
        editor.putFloat("vas_splash_ad_entry_shake_z_axis" + aVar.f421925b, aVar.R);
        editor.putInt("vas_splash_ad_entry_twist_angle_" + aVar.f421925b, aVar.A);
        editor.putInt("vas_splash_ad_entry_twist_reverse_angle_" + aVar.f421925b, aVar.B);
        editor.putInt("vas_splash_ad_entry_flip_card_angle_" + aVar.f421925b, aVar.C);
        editor.putString("vas_splash_ad_entry_flip_card_jump_text" + aVar.f421925b, aVar.D);
        editor.putString("vas_splash_ad_entry_flip_card_logo" + aVar.f421925b, aVar.E);
        editor.putString("vas_splash_ad_entry_flip_card_product" + aVar.f421925b, aVar.F);
        List<String> list2 = aVar.S;
        if (list2 != null && list2.size() >= 5) {
            editor.putString("vas_splash_ad_entry_click_c2s_url" + aVar.f421925b, aVar.S.get(0));
            editor.putString("vas_splash_ad_entry_click_c2s_url_1_" + aVar.f421925b, aVar.S.get(1));
            editor.putString("vas_splash_ad_entry_click_c2s_url_2_" + aVar.f421925b, aVar.S.get(2));
            editor.putString("vas_splash_ad_entry_click_c2s_url_3_" + aVar.f421925b, aVar.S.get(3));
            editor.putString("vas_splash_ad_entry_click_c2s_url_4_" + aVar.f421925b, aVar.S.get(4));
        }
        editor.putLong("vas_splash_ad_entry_splash_duration" + aVar.f421925b, aVar.U);
        editor.putString("vas_splash_ad_entry_text_bg_end_color_" + aVar.f421925b, aVar.V);
        editor.putString("vas_splash_ad_entry_text_bg_press_color_" + aVar.f421925b, aVar.W);
        editor.putInt("vas_splash_ad_entry_hotzone_height_" + aVar.f421925b, aVar.X);
        editor.putInt("vas_splash_ad_entry_sensitivity_" + aVar.f421925b, aVar.Y);
        editor.putInt("vas_splash_ad_entry_track_switch_" + aVar.f421925b, aVar.Z);
        editor.putString("vas_splash_ad_entry_arrow_" + aVar.f421925b, aVar.f421924a0);
        editor.putString("vas_splash_ad_entry_arrow_end_" + aVar.f421925b, aVar.f421928c0);
        editor.putString("vas_splash_ad_entry_arrow_path_" + aVar.f421925b, aVar.f421926b0);
        editor.putString("vas_splash_ad_entry_arrow_end_path_" + aVar.f421925b, aVar.f421930d0);
        editor.putString("vas_splash_ad_logo_" + aVar.f421925b, aVar.f421932e0);
        editor.putString("vas_splash_ad_logo_path_" + aVar.f421925b, aVar.f421934f0);
        editor.putString("vas_splash_ad_jump_app_schema" + aVar.f421925b, aVar.f421941j);
    }
}
