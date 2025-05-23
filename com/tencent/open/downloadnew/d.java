package com.tencent.open.downloadnew;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.assistant.sdk.remote.SDKConst;
import com.tencent.open.business.base.OpenConfig;
import com.tencent.qqmini.sdk.launcher.utils.OSUtils;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* compiled from: P */
/* loaded from: classes22.dex */
public class d {
    public static void A(long j3) {
        SharedPreferences.Editor edit = com.tencent.open.adapter.a.f().e().getSharedPreferences("share_myAppApi", 0).edit();
        edit.putLong("SP_Lastest_require_time", j3);
        edit.commit();
    }

    public static long B() {
        return OpenConfig.i(com.tencent.open.adapter.a.f().e(), null).k("Common_tips_dialog_interval");
    }

    public static boolean a(long j3) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(System.currentTimeMillis()));
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(new Date(j3));
        if (calendar2.get(1) == calendar.get(1) && calendar2.get(6) - calendar.get(6) == 0) {
            return true;
        }
        return false;
    }

    public static void b() {
        if (!OpenConfig.i(com.tencent.open.adapter.a.f().e(), null).h("Common_Show_Dialog_Flag")) {
            return;
        }
        SharedPreferences sharedPreferences = com.tencent.open.adapter.a.f().e().getSharedPreferences("share_myAppApi", 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        int i3 = 1;
        if (OpenConfig.i(com.tencent.open.adapter.a.f().e(), null).f("Common_Dialog_Only_Once_Flag")) {
            edit.putBoolean("SP_Has_shown_Dialog", true);
            edit.commit();
            return;
        }
        int j3 = OpenConfig.i(com.tencent.open.adapter.a.f().e(), null).j("Common_Max_Count");
        if (j3 != -1 && j3 != 0) {
            int i16 = sharedPreferences.getInt("SP_Show_Dialog_Count", 0);
            String string = sharedPreferences.getString("SP_Show_Dialog_Date", "");
            String format = new SimpleDateFormat("yyyy\u5e74MM\u6708dd\u65e5").format(new Date(System.currentTimeMillis()));
            if (format.equals(string)) {
                i3 = 1 + i16;
            }
            edit.putInt("SP_Show_Dialog_Count", i3);
            edit.putString("SP_Show_Dialog_Date", format);
            edit.commit();
        }
    }

    public static boolean c() {
        if (!r()) {
            return true;
        }
        return OpenConfig.i(com.tencent.open.adapter.a.f().e(), null).g("Common_YYB_MiUi12Wake");
    }

    public static boolean d() {
        return OpenConfig.i(com.tencent.open.adapter.a.f().e(), null).h("Common_MyAppDownload_Flag");
    }

    public static boolean e() {
        return OpenConfig.i(com.tencent.open.adapter.a.f().e(), null).g("Common_YYB_Wake_BackTwo");
    }

    public static boolean f() {
        return OpenConfig.i(com.tencent.open.adapter.a.f().e(), null).g("Common_YYB_Wake_BackOne");
    }

    public static boolean g() {
        if (!OpenConfig.i(com.tencent.open.adapter.a.f().e(), null).h("Common_Show_Dialog_Flag")) {
            return false;
        }
        SharedPreferences sharedPreferences = com.tencent.open.adapter.a.f().e().getSharedPreferences("share_myAppApi", 0);
        boolean z16 = sharedPreferences.getBoolean("SP_Has_shown_Dialog", false);
        if (OpenConfig.i(com.tencent.open.adapter.a.f().e(), null).f("Common_Dialog_Only_Once_Flag")) {
            if (z16) {
                return false;
            }
            return true;
        }
        int j3 = OpenConfig.i(com.tencent.open.adapter.a.f().e(), null).j("Common_Max_Count");
        com.tencent.open.base.f.a("OpenConfig-MyAppApi", " maxCount = " + j3);
        if (j3 != -1 && j3 != 0) {
            int i3 = sharedPreferences.getInt("SP_Show_Dialog_Count", 0);
            if (new SimpleDateFormat("yyyy\u5e74MM\u6708dd\u65e5").format(new Date(System.currentTimeMillis())).equals(sharedPreferences.getString("SP_Show_Dialog_Date", "")) && i3 >= j3) {
                return false;
            }
            return true;
        }
        return true;
    }

    public static boolean h() {
        boolean g16 = OpenConfig.i(com.tencent.open.adapter.a.f().e(), null).g("Common_tmast_wake");
        com.tencent.open.base.f.a("TAMST_WAKE", ">>allowTmastWake allowWake = " + g16);
        if (g16 && w()) {
            return true;
        }
        return false;
    }

    public static boolean i() {
        return OpenConfig.i(com.tencent.open.adapter.a.f().e(), null).h("Common_Detail_Page");
    }

    public static boolean j() {
        return OpenConfig.i(com.tencent.open.adapter.a.f().e(), null).h("Common_yyb_wifi_download_Switch");
    }

    public static boolean k() {
        return OpenConfig.i(com.tencent.open.adapter.a.f().e(), null).g("Common_YYB_BgWake");
    }

    public static boolean l() {
        return OpenConfig.i(com.tencent.open.adapter.a.f().e(), null).g("Common_YYB_InstWake");
    }

    public static boolean m() {
        if (!c() || !OpenConfig.i(com.tencent.open.adapter.a.f().e(), null).g("Common_YYB_Wake") || !w()) {
            return false;
        }
        return true;
    }

    public static String n() {
        return OpenConfig.i(com.tencent.open.adapter.a.f().e(), null).l("Common_myapp_download_url");
    }

    public static String o(int i3, String str) {
        String str2;
        if ("biz_src_zf_games".equals(str)) {
            str2 = "Common_GC_InstallYYB_Install_Words";
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            str2 = "Common_GC_UpdateYYB_Update_Words";
                        }
                    } else {
                        str2 = "Common_GC_UpdateYYB_Install_Words";
                    }
                } else {
                    str2 = "Common_GC_InstallYYB_Update_Words";
                }
            }
        } else if ("biz_src_jc_update".equals(str)) {
            str2 = i3 != 1 ? i3 != 3 ? null : "Common_QQUpdate_UpdateYYB_Update_Words" : "Common_QQUpdate_InstallYYB_Update_Words";
        } else {
            str2 = "Common_InstallYYB_Install_Words";
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            str2 = "Common_UpdateYYB_Update_Words";
                        }
                    } else {
                        str2 = "Common_UpdateYYB_Install_Words";
                    }
                } else {
                    str2 = "Common_InstallYYB_Update_Words";
                }
            }
        }
        return OpenConfig.i(com.tencent.open.adapter.a.f().e(), null).l(str2);
    }

    public static boolean p() {
        if (com.tencent.open.business.base.a.g(SDKConst.SELF_PACKAGENAME) <= 4001126 || !OpenConfig.i(com.tencent.open.adapter.a.f().e(), null).h("Common_QQ_CARRY_IDENTITY")) {
            return false;
        }
        return true;
    }

    public static void q() {
        OpenConfig.i(com.tencent.open.adapter.a.f().e(), null);
    }

    public static boolean r() {
        String mIUIVersion = OSUtils.getMIUIVersion();
        if (TextUtils.isEmpty(mIUIVersion)) {
            return false;
        }
        try {
        } catch (Throwable th5) {
            com.tencent.open.base.f.c("ControlPolicyUtil", "parseInt error:" + th5.getMessage());
        }
        if (Integer.parseInt(mIUIVersion.substring(1)) < 12) {
            return false;
        }
        return true;
    }

    public static boolean s() {
        return true;
    }

    public static boolean t(long j3) {
        SharedPreferences sharedPreferences = com.tencent.open.adapter.a.f().e().getSharedPreferences("share_myAppApi", 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        long j16 = sharedPreferences.getLong("SP_Lastest_require_time", j3);
        if (j3 - j16 >= z()) {
            edit.putLong("SP_Lastest_require_time", j3);
            edit.commit();
            return true;
        }
        if (j3 != j16) {
            return false;
        }
        return true;
    }

    public static boolean u() {
        String trim = OpenConfig.i(com.tencent.open.adapter.a.f().e(), null).l("Common_Release_Control").trim();
        if (TextUtils.isEmpty(trim) || trim.equals("-1")) {
            return true;
        }
        if (trim.equals("-2")) {
            return false;
        }
        String[] split = trim.split(";");
        if (split == null) {
            return true;
        }
        String valueOf = String.valueOf(com.tencent.open.adapter.a.f().l());
        if (valueOf == null) {
            return false;
        }
        for (String str : split) {
            if (str.length() == 2 && valueOf.endsWith(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean v() {
        if (OpenConfig.i(com.tencent.open.adapter.a.f().e(), null).j("Common_root_autoinstall_flag") <= 0) {
            return true;
        }
        return false;
    }

    public static boolean w() {
        long k3 = OpenConfig.i(com.tencent.open.adapter.a.f().e(), null).k("Common_wake_limite");
        long k16 = OpenConfig.i(com.tencent.open.adapter.a.f().e(), null).k("Common_wake_interval") * 1000;
        SharedPreferences sharedPreferences = com.tencent.open.adapter.a.f().e().getSharedPreferences("share_myAppApi", 0);
        int i3 = sharedPreferences.getInt("tmast_wake_times", 0);
        long j3 = sharedPreferences.getLong("tmast_wake_last_time", 0L);
        boolean a16 = a(j3);
        if (!a16) {
            i3 = 0;
        }
        com.tencent.open.base.f.a("TAMST_WAKE", ">>allowTmastWake  wakeLimit = " + k3 + " wakeInterval = " + k16 + " wakeTimes = " + i3 + " isToday = " + a16);
        if (i3 >= k3) {
            return false;
        }
        if (System.currentTimeMillis() - j3 <= k16 && a16) {
            return false;
        }
        return true;
    }

    public static void x() {
        int i3 = 0;
        SharedPreferences sharedPreferences = com.tencent.open.adapter.a.f().e().getSharedPreferences("share_myAppApi", 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        int i16 = sharedPreferences.getInt("tmast_wake_times", 0);
        if (a(sharedPreferences.getLong("tmast_wake_last_time", 0L))) {
            i3 = i16;
        }
        edit.putInt("tmast_wake_times", i3 + 1);
        edit.putLong("tmast_wake_last_time", System.currentTimeMillis());
        edit.commit();
    }

    public static boolean y() {
        String str;
        DownloadInfo w3 = DownloadManager.C().w("1101070898");
        if (w3 != null) {
            str = w3.L;
        } else {
            str = "";
        }
        if (!TextUtils.isEmpty(str) && new File(str).exists()) {
            return false;
        }
        return true;
    }

    public static long z() {
        return OpenConfig.i(com.tencent.open.adapter.a.f().e(), null).k("Common_require_root_interval");
    }
}
