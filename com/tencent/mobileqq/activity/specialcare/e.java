package com.tencent.mobileqq.activity.specialcare;

import android.content.SharedPreferences;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.eb;
import com.tencent.mobileqq.vas.api.IVasDepTemp;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes10.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static Object f186569a;

    /* renamed from: b, reason: collision with root package name */
    public static HashMap<String, String> f186570b;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f186571c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40947);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f186569a = new Object();
        f186570b = new HashMap<>();
        f186571c = true;
    }

    public static void a(String str, String str2, AppRuntime appRuntime) {
        if (str2 != null && str2.length() != 0) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (!p(str, appRuntime)) {
                    f(str, appRuntime);
                }
                h(str, parseInt, appRuntime);
                return;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.i("SpecialCareManager", 2, "dealWithRespSound|exception = " + e16.toString());
                    return;
                }
                return;
            }
        }
        if (p(str, appRuntime)) {
            b(str, appRuntime);
        }
        if (q(str, appRuntime)) {
            d(str, appRuntime);
        }
    }

    public static void b(String str, AppRuntime appRuntime) {
        SharedPreferences sharedPreferences = appRuntime.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        String str2 = appRuntime.getCurrentAccountUin() + str;
        if (f186570b.containsKey(str2)) {
            f186570b.remove(str2);
        }
        synchronized (f186569a) {
            Set<String> a16 = eb.a(sharedPreferences, AppConstants.Preferences.SPECIAL_SOUND + appRuntime.getCurrentAccountUin(), null);
            if (a16 != null) {
                if (!a16.contains(str)) {
                    return;
                }
                a16.remove(str);
                eb.c(edit, AppConstants.Preferences.SPECIAL_SOUND + appRuntime.getCurrentAccountUin(), a16.toArray()).commit();
            }
        }
    }

    public static void c(List<String> list, AppRuntime appRuntime) {
        if (list != null && list.size() != 0) {
            SharedPreferences sharedPreferences = appRuntime.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            synchronized (f186569a) {
                Set<String> a16 = eb.a(sharedPreferences, AppConstants.Preferences.SPECIAL_SOUND + appRuntime.getCurrentAccountUin(), null);
                if (a16 != null) {
                    for (String str : list) {
                        String str2 = appRuntime.getCurrentAccountUin() + str;
                        if (f186570b.containsKey(str2)) {
                            f186570b.remove(str2);
                        }
                        if (a16.contains(str)) {
                            a16.remove(str);
                        }
                    }
                    eb.c(edit, AppConstants.Preferences.SPECIAL_SOUND + appRuntime.getCurrentAccountUin(), a16.toArray()).commit();
                }
            }
        }
    }

    public static void f(String str, AppRuntime appRuntime) {
        SharedPreferences sharedPreferences = appRuntime.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        String str2 = appRuntime.getCurrentAccountUin() + str;
        if (!f186570b.containsKey(str2)) {
            f186570b.put(str2, str);
        }
        synchronized (f186569a) {
            Set a16 = eb.a(sharedPreferences, AppConstants.Preferences.SPECIAL_SOUND + appRuntime.getCurrentAccountUin(), null);
            if (a16 == null) {
                a16 = new HashSet();
            }
            if (a16.contains(str)) {
                return;
            }
            a16.add(str);
            eb.c(edit, AppConstants.Preferences.SPECIAL_SOUND + appRuntime.getCurrentAccountUin(), a16.toArray()).commit();
        }
    }

    public static void g(List<String> list, AppRuntime appRuntime) {
        if (list != null && list.size() != 0) {
            SharedPreferences sharedPreferences = appRuntime.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            synchronized (f186569a) {
                Set a16 = eb.a(sharedPreferences, AppConstants.Preferences.SPECIAL_SOUND + appRuntime.getCurrentAccountUin(), null);
                if (a16 == null) {
                    a16 = new HashSet();
                }
                for (String str : list) {
                    String str2 = appRuntime.getCurrentAccountUin() + str;
                    if (!f186570b.containsKey(str2)) {
                        f186570b.put(str2, str);
                    }
                    if (!a16.contains(str)) {
                        a16.add(str);
                    }
                }
                eb.c(edit, AppConstants.Preferences.SPECIAL_SOUND + appRuntime.getCurrentAccountUin(), a16.toArray()).commit();
            }
        }
    }

    public static void h(String str, int i3, AppRuntime appRuntime) {
        SharedPreferences.Editor edit = appRuntime.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4).edit();
        edit.putInt(AppConstants.Preferences.SPECIAL_SOUND_TYPE + appRuntime.getCurrentAccountUin() + str, i3);
        edit.commit();
    }

    public static void i(int i3, AppRuntime appRuntime) {
        SharedPreferences.Editor edit = appRuntime.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4).edit();
        edit.putInt(AppConstants.Preferences.SPECIAL_SOUND_QUOTA + appRuntime.getCurrentAccountUin(), i3);
        edit.commit();
    }

    public static void j(int i3, AppRuntime appRuntime) {
        SharedPreferences.Editor edit = appRuntime.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4).edit();
        edit.putInt(AppConstants.Preferences.SPECIAL_SOUND_SVIP_QUOTA + appRuntime.getCurrentAccountUin(), i3);
        edit.commit();
    }

    public static void k(Map<String, Integer> map, AppRuntime appRuntime) {
        if (map != null && !map.isEmpty()) {
            SharedPreferences.Editor edit = appRuntime.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4).edit();
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (QLog.isColorLevel()) {
                    QLog.d("SpecialCareManager", 2, "getSpecialCareSounds from FriendList: " + entry.toString());
                }
                String key = entry.getKey();
                edit.putInt(AppConstants.Preferences.SPECIAL_SOUND_TYPE + appRuntime.getCurrentAccountUin() + key, entry.getValue().intValue());
            }
            edit.commit();
        }
    }

    public static void l(AppRuntime appRuntime) {
        SharedPreferences.Editor edit = appRuntime.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4).edit();
        edit.putLong(AppConstants.Preferences.KEY_GET_SPECIAL_SOUND_QUOTA_TIME + appRuntime.getCurrentAccountUin(), System.currentTimeMillis());
        edit.commit();
    }

    public static int m(AppRuntime appRuntime) {
        Set<String> a16;
        SharedPreferences sharedPreferences = appRuntime.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
        new HashSet();
        synchronized (f186569a) {
            a16 = eb.a(sharedPreferences, AppConstants.Preferences.SPECIAL_SOUND + appRuntime.getCurrentAccountUin(), null);
        }
        if (a16 != null) {
            return a16.size();
        }
        return 0;
    }

    public static Set<String> n(AppRuntime appRuntime) {
        Set<String> a16;
        SharedPreferences sharedPreferences = appRuntime.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
        new HashSet();
        synchronized (f186569a) {
            a16 = eb.a(sharedPreferences, AppConstants.Preferences.SPECIAL_SOUND + appRuntime.getCurrentAccountUin(), null);
        }
        return a16;
    }

    public static int o(String str, AppRuntime appRuntime) {
        return appRuntime.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4).getInt(AppConstants.Preferences.SPECIAL_SOUND_TYPE + appRuntime.getCurrentAccountUin() + str, 1);
    }

    public static boolean p(String str, AppRuntime appRuntime) {
        Set<String> a16;
        SharedPreferences sharedPreferences = appRuntime.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
        new HashSet();
        synchronized (f186569a) {
            a16 = eb.a(sharedPreferences, AppConstants.Preferences.SPECIAL_SOUND + appRuntime.getCurrentAccountUin(), null);
        }
        if (a16 != null && !a16.isEmpty() && a16.contains(str)) {
            return true;
        }
        return false;
    }

    public static boolean q(String str, AppRuntime appRuntime) {
        return appRuntime.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4).contains(AppConstants.Preferences.SPECIAL_SOUND_TYPE + appRuntime.getCurrentAccountUin() + str);
    }

    public static boolean r(String str) {
        return f186570b.containsKey(str);
    }

    public static void s(List<String> list, int i3, List<String> list2, AppRuntime appRuntime) {
        ((IVasDepTemp) QRoute.api(IVasDepTemp.class)).sendSpecialCareEvent(list, i3, list2, appRuntime);
    }

    public static void t(String str, String str2, AppRuntime appRuntime) {
        if (q(str, appRuntime)) {
            return;
        }
        a(str, str2, appRuntime);
    }

    public static void u(boolean z16) {
        f186571c = z16;
    }

    public static void d(String str, AppRuntime appRuntime) {
    }

    public static void e(List<String> list, AppRuntime appRuntime) {
    }
}
