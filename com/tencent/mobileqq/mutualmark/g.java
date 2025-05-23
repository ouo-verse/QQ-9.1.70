package com.tencent.mobileqq.mutualmark;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.common.util.k;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.business.MutualMarkConfProcessor;
import com.tencent.mobileqq.config.business.ad;
import com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.webview.util.w;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes15.dex */
public class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static volatile Boolean f252047a;

    /* renamed from: b, reason: collision with root package name */
    private static HashMap<String, Integer> f252048b;

    /* renamed from: c, reason: collision with root package name */
    public static HashMap<String, Integer> f252049c;

    /* renamed from: d, reason: collision with root package name */
    public static HashMap<String, Integer> f252050d;

    /* renamed from: e, reason: collision with root package name */
    public static final long[] f252051e;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements Comparator<String> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2)).intValue();
            }
            if (str.length() > str2.length()) {
                return -1;
            }
            if (str.length() < str2.length()) {
                return 1;
            }
            return 0;
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f252052a;

        /* renamed from: b, reason: collision with root package name */
        public int f252053b;

        /* renamed from: c, reason: collision with root package name */
        public String f252054c;

        /* renamed from: d, reason: collision with root package name */
        public String f252055d;

        /* renamed from: e, reason: collision with root package name */
        public String f252056e;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73271);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f252047a = null;
        HashMap<String, Integer> hashMap = new HashMap<>();
        f252048b = hashMap;
        hashMap.put("hot_reactive_gray_intimate_lover_1_icon", Integer.valueOf(R.drawable.skin_icon_intimate_lover_1));
        f252048b.put("hot_reactive_gray_intimate_lover_2_icon", Integer.valueOf(R.drawable.skin_icon_intimate_lover_2));
        f252048b.put("hot_reactive_gray_intimate_lover_3_icon", Integer.valueOf(R.drawable.skin_icon_intimate_lover_3));
        f252048b.put("hot_reactive_gray_intimate_guimi_1_icon", Integer.valueOf(R.drawable.skin_icon_intimate_guimi_1));
        f252048b.put("hot_reactive_gray_intimate_guimi_2_icon", Integer.valueOf(R.drawable.skin_icon_intimate_guimi_2));
        f252048b.put("hot_reactive_gray_intimate_guimi_3_icon", Integer.valueOf(R.drawable.skin_icon_intimate_guimi_3));
        f252048b.put("hot_reactive_gray_intimate_jiyou_1_icon", Integer.valueOf(R.drawable.skin_icon_intimate_jiyou_1));
        f252048b.put("hot_reactive_gray_intimate_jiyou_2_icon", Integer.valueOf(R.drawable.skin_icon_intimate_jiyou_2));
        f252048b.put("hot_reactive_gray_intimate_jiyou_3_icon", Integer.valueOf(R.drawable.skin_icon_intimate_jiyou_3));
        f252048b.put("hot_reactive_gray_friendship_1_icon", Integer.valueOf(R.drawable.skin_icon_frdship_1));
        f252048b.put("hot_reactive_gray_friendship_2_icon", Integer.valueOf(R.drawable.skin_icon_frdship_2));
        f252048b.put("hot_reactive_gray_friendship_3_icon", Integer.valueOf(R.drawable.skin_icon_frdship_3));
        f252048b.put("gray_small_fire", Integer.valueOf(R.drawable.skin_icon_small_fire));
        f252048b.put("gray_big_fire", Integer.valueOf(R.drawable.skin_icon_big_fire));
        f252048b.put("gray_small_zan", Integer.valueOf(R.drawable.skin_icon_small_praise));
        f252048b.put("gray_big_zan", Integer.valueOf(R.drawable.skin_icon_big_praise));
        f252048b.put("gray_small_lover", Integer.valueOf(R.drawable.skin_icon_lover_small));
        f252048b.put("gray_big_lover", Integer.valueOf(R.drawable.skin_icon_lover_big));
        f252048b.put("qzone_gray_qzone_visit_normal", Integer.valueOf(R.drawable.skin_icon_qzone_visit_normal));
        f252048b.put("qzone_gray_qzone_visit_super", Integer.valueOf(R.drawable.skin_icon_qzone_visit_super));
        f252048b.put("gray_small_ship", Integer.valueOf(R.drawable.skin_icon_small_flower));
        f252048b.put("gray_big_ship", Integer.valueOf(R.drawable.skin_icon_big_flower));
        HashMap<String, Integer> hashMap2 = new HashMap<>();
        f252049c = hashMap2;
        hashMap2.put("skin_icon_small_fire", Integer.valueOf(R.drawable.skin_icon_small_fire));
        f252049c.put("skin_icon_big_fire", Integer.valueOf(R.drawable.skin_icon_big_fire));
        f252049c.put("skin_icon_fire_1", Integer.valueOf(R.drawable.skin_icon_fire_1));
        f252049c.put("skin_icon_fire_2", Integer.valueOf(R.drawable.skin_icon_fire_2));
        f252049c.put("skin_icon_fire_3", Integer.valueOf(R.drawable.skin_icon_fire_3));
        f252049c.put("skin_icon_fire_4", Integer.valueOf(R.drawable.skin_icon_fire_4));
        f252049c.put("skin_icon_fire_5", Integer.valueOf(R.drawable.skin_icon_fire_5));
        f252049c.put("skin_icon_fire_6", Integer.valueOf(R.drawable.skin_icon_fire_6));
        f252049c.put("skin_icon_small_flower", Integer.valueOf(R.drawable.skin_icon_small_flower));
        f252049c.put("skin_icon_big_flower", Integer.valueOf(R.drawable.skin_icon_big_flower));
        f252049c.put("skin_icon_small_praise", Integer.valueOf(R.drawable.skin_icon_small_praise));
        f252049c.put("skin_icon_big_praise", Integer.valueOf(R.drawable.skin_icon_big_praise));
        f252049c.put("skin_icon_lover_small", Integer.valueOf(R.drawable.skin_icon_lover_small));
        f252049c.put("skin_icon_lover_big", Integer.valueOf(R.drawable.skin_icon_lover_big));
        f252049c.put("skin_icon_qzone_visit_normal", Integer.valueOf(R.drawable.skin_icon_qzone_visit_normal));
        f252049c.put("skin_icon_qzone_visit_super", Integer.valueOf(R.drawable.skin_icon_qzone_visit_super));
        f252049c.put("skin_icon_frdship_1", Integer.valueOf(R.drawable.skin_icon_frdship_1));
        f252049c.put("skin_icon_frdship_2", Integer.valueOf(R.drawable.skin_icon_frdship_2));
        f252049c.put("skin_icon_frdship_3", Integer.valueOf(R.drawable.skin_icon_frdship_3));
        f252049c.put("skin_icon_intimate_lover_1", Integer.valueOf(R.drawable.skin_icon_intimate_lover_1));
        f252049c.put("skin_icon_intimate_lover_2", Integer.valueOf(R.drawable.skin_icon_intimate_lover_2));
        f252049c.put("skin_icon_intimate_lover_3", Integer.valueOf(R.drawable.skin_icon_intimate_lover_3));
        f252049c.put("skin_icon_intimate_guimi_1", Integer.valueOf(R.drawable.skin_icon_intimate_guimi_1));
        f252049c.put("skin_icon_intimate_guimi_2", Integer.valueOf(R.drawable.skin_icon_intimate_guimi_2));
        f252049c.put("skin_icon_intimate_guimi_3", Integer.valueOf(R.drawable.skin_icon_intimate_guimi_3));
        f252049c.put("skin_icon_intimate_sidang_1", Integer.valueOf(R.drawable.o2c));
        f252049c.put("skin_icon_intimate_sidang_2", Integer.valueOf(R.drawable.o2d));
        f252049c.put("skin_icon_intimate_sidang_3", Integer.valueOf(R.drawable.o2e));
        f252049c.put("skin_icon_intimate_jiyou_1", Integer.valueOf(R.drawable.skin_icon_intimate_jiyou_1));
        f252049c.put("skin_icon_intimate_jiyou_2", Integer.valueOf(R.drawable.skin_icon_intimate_jiyou_2));
        f252049c.put("skin_icon_intimate_jiyou_3", Integer.valueOf(R.drawable.skin_icon_intimate_jiyou_3));
        f252049c.put("skin_icon_mutual_x_character_1", Integer.valueOf(R.drawable.hzt));
        f252049c.put("skin_icon_mentorship", Integer.valueOf(R.drawable.skin_icon_mentorship_unionvip));
        f252049c.put("skin_icon_mentorship_svip", Integer.valueOf(R.drawable.skin_icon_mentorship_svip));
        f252049c.put("skin_icon_mentorship_yellowvip", Integer.valueOf(R.drawable.skin_icon_mentorship_yellowvip));
        f252049c.put("skin_icon_mentorship_newyear", Integer.valueOf(R.drawable.skin_icon_mentorship_newyear));
        f252049c.put("skin_icon_kapu_1", Integer.valueOf(R.drawable.skin_icon_kapu_1));
        f252049c.put("skin_icon_kapu_2", Integer.valueOf(R.drawable.skin_icon_kapu_2));
        f252049c.put("skin_icon_kapu_3", Integer.valueOf(R.drawable.skin_icon_kapu_3));
        f252049c.put("skin_icon_forget_me_not_1", Integer.valueOf(R.drawable.skin_icon_forget_me_not_1));
        f252049c.put("skin_icon_forget_me_not_2", Integer.valueOf(R.drawable.skin_icon_forget_me_not_2));
        f252049c.put("skin_icon_forget_me_not_3", Integer.valueOf(R.drawable.skin_icon_forget_me_not_3));
        f252049c.put("skin_icon_listen_together_1", Integer.valueOf(R.drawable.skin_icon_listen_together_1));
        f252049c.put("skin_icon_listen_together_2", Integer.valueOf(R.drawable.skin_icon_listen_together_2));
        f252049c.put("skin_icon_listen_together_3", Integer.valueOf(R.drawable.skin_icon_listen_together_3));
        HashMap<String, Integer> hashMap3 = new HashMap<>();
        f252050d = hashMap3;
        hashMap3.putAll(f252048b);
        f252050d.putAll(f252049c);
        f252050d.putAll(com.tencent.mobileqq.mutualmark.alienation.b.f251966a);
        f252051e = new long[]{1, 2, 3, 26};
    }

    public static String a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !l(str2)) {
            if (str.endsWith("/") && str2.startsWith("/")) {
                return str + str2.substring(1);
            }
            if (str.endsWith("/") && !str2.startsWith("/")) {
                return str + str2;
            }
            if (!str.endsWith("/") && str2.startsWith("/")) {
                return str + str2;
            }
            if (!str.endsWith("/") && !str2.startsWith("/")) {
                return str + "/" + str2;
            }
            return str2;
        }
        return str2;
    }

    public static String b(String str) {
        if (!TextUtils.isEmpty(str) && !l(str)) {
            return a(MutualMarkConfProcessor.a().G, str);
        }
        return str;
    }

    public static List<String> c() {
        ArrayList arrayList = new ArrayList(f252050d.keySet());
        Collections.sort(arrayList, new a());
        return arrayList;
    }

    public static String d(long j3, long j16) {
        return String.valueOf((j3 * 10) + JsonGrayBusiId.UI_RESERVE_100000_110000 + j16);
    }

    public static String e(int i3) {
        for (Map.Entry<String, Integer> entry : f252049c.entrySet()) {
            if (entry.getValue().intValue() == i3) {
                return entry.getKey();
            }
        }
        for (Map.Entry<String, Integer> entry2 : com.tencent.mobileqq.mutualmark.alienation.b.f251966a.entrySet()) {
            if (entry2.getValue().intValue() == i3) {
                return entry2.getKey();
            }
        }
        return "";
    }

    public static int f(long j3, long j16) {
        return (int) ((j3 * 10) + JsonGrayBusiId.UI_RESERVE_100000_110000 + j16);
    }

    public static long g(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Long.valueOf(Long.parseLong(str)).longValue() % 10;
            } catch (Exception e16) {
                QLog.e("MutualMarkUtils", 1, "getTypeLevel error:" + e16.getMessage());
            }
        }
        return 0L;
    }

    public static ArrayList<b> h(String str) {
        ArrayList<b> arrayList = new ArrayList<>();
        Matcher matcher = Pattern.compile("#image_url\\{([^\\)]+?)\\}").matcher(str);
        while (matcher.find()) {
            b bVar = new b();
            bVar.f252054c = matcher.group();
            int start = matcher.start();
            bVar.f252052a = start;
            bVar.f252053b = start + bVar.f252054c.length();
            String group = matcher.group(1);
            bVar.f252055d = group;
            if (!TextUtils.isEmpty(group) && bVar.f252055d.contains("client/42px-")) {
                Matcher matcher2 = Pattern.compile("x_character/([^\\)]+?)/client").matcher(bVar.f252055d);
                if (matcher2.find()) {
                    bVar.f252056e = matcher2.group(1);
                }
            }
            arrayList.add(bVar);
            if (QLog.isColorLevel()) {
                QLog.i("MutualMarkUtils", 2, "getMutualMarkImageUrlTemplateInfos. url:" + bVar.f252055d + " template:" + bVar.f252054c);
            }
        }
        return arrayList;
    }

    public static long i(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                Long valueOf = Long.valueOf(Long.parseLong(str));
                return ((valueOf.longValue() - JsonGrayBusiId.UI_RESERVE_100000_110000) - (valueOf.longValue() % 10)) / 10;
            } catch (Exception e16) {
                QLog.e("MutualMarkUtils", 1, "getType error:" + e16.getMessage());
            }
        }
        return 0L;
    }

    public static boolean j(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return true;
        }
        if (!TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            if (AppSetting.b(str) >= 0) {
                return true;
            }
            return false;
        }
        if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (AppSetting.b(str2) <= 0) {
                return true;
            }
            return false;
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return true;
        }
        if (AppSetting.b(str) >= 0 && AppSetting.b(str2) <= 0) {
            return true;
        }
        return false;
    }

    public static boolean k(AppInterface appInterface) {
        if (appInterface == null || appInterface.getApp() == null || appInterface.getApp().getSharedPreferences(appInterface.getCurrentAccountUin(), 0).getInt("hotDisableInteractive", 0) != 1) {
            return false;
        }
        return true;
    }

    public static boolean l(String str) {
        if (!str.contains(QzoneWebViewOfflinePlugin.STR_DEVIDER)) {
            return false;
        }
        return true;
    }

    public static boolean m(int i3) {
        if (i3 != 2097153 && i3 != 2097154 && i3 != 2097155) {
            return false;
        }
        return true;
    }

    public static boolean n(long j3) {
        if (com.tencent.relation.common.config.toggle.c.f364688a0.g(false)) {
            return true;
        }
        ad a16 = MutualMarkConfProcessor.a();
        HashMap<Long, com.tencent.mobileqq.mutualmark.info.b> hashMap = a16.f202489m;
        if (hashMap == null || hashMap.keySet().size() <= 0) {
            return false;
        }
        return a16.f202489m.containsKey(Long.valueOf(j3));
    }

    public static boolean o(long j3) {
        if (!n(j3)) {
            return false;
        }
        for (long j16 : f252051e) {
            if (j16 == j3) {
                return false;
            }
        }
        return true;
    }

    public static void p(QQAppInterface qQAppInterface, Context context, int i3) {
        if (qQAppInterface != null && context != null) {
            String c16 = MutualMarkConfProcessor.a().c();
            boolean E = ((FriendsManager) qQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).E(false);
            String str = MutualMarkConfProcessor.a().G;
            StringBuilder sb5 = new StringBuilder(c16);
            sb5.append(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
            sb5.append("switch=");
            sb5.append(!E ? 1 : 0);
            sb5.append(ContainerUtils.FIELD_DELIMITER);
            sb5.append("prefix=");
            sb5.append(str);
            sb5.append(ContainerUtils.FIELD_DELIMITER);
            sb5.append("entry=");
            sb5.append(i3);
            sb5.append(ContainerUtils.FIELD_DELIMITER);
            if (((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).isElegantVersion()) {
                sb5.append("tab_value=");
                sb5.append(1);
            } else {
                sb5.append("tab_value=");
                sb5.append(0);
            }
            String sb6 = sb5.toString();
            if (w.a(1000L) && !TextUtils.isEmpty(sb6)) {
                Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
                intent.addFlags(268435456);
                intent.putExtra("url", sb6);
                context.startActivity(intent);
                return;
            }
            if (context instanceof Activity) {
                QQToast.makeText(context, 1, R.string.f201214u8, 0).show();
            }
        }
    }

    public static String q() {
        InputStream inputStream = null;
        try {
            inputStream = BaseApplication.getContext().getAssets().open("mutual_mark_default_524.json");
            String h16 = k.h(inputStream);
            if (inputStream != null) {
                try {
                    inputStream.close();
                    return h16;
                } catch (IOException unused) {
                    return h16;
                }
            }
            return h16;
        } catch (Throwable th5) {
            try {
                th5.printStackTrace();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused2) {
                    }
                }
                return "";
            } catch (Throwable th6) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th6;
            }
        }
    }

    public static String r(String str) {
        if (!URLUtil.isNetworkUrl(str)) {
            return str;
        }
        if (f252047a == null) {
            f252047a = Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("revert_mutual_mark_icon_9165", false));
            QLog.i("MutualMarkUtils", 1, "revertIconV2=" + f252047a);
        }
        if (f252047a.booleanValue()) {
            return str;
        }
        String replace = str.replace("/mutualmark/", "/mutualmark_v2/");
        if (QLog.isDevelopLevel()) {
            QLog.i("MutualMarkUtils", 1, String.format("upgradeIconUrlToVersion2 origin=%s, new=%s", str, replace));
        }
        return replace;
    }
}
