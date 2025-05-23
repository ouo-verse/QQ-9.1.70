package com.tencent.mobileqq.leba.core;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.leba.entity.n;
import com.tencent.mobileqq.leba.logic.LebaPluginLogic;
import com.tencent.mobileqq.leba.more.LebaMoreFragment;
import com.tencent.mobileqq.leba.utils.LebaMmkvUtils;
import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static boolean f240379a;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class a implements Comparator<n> {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        private boolean b(n nVar) {
            if (nVar != null && nVar.f240505b != null) {
                return true;
            }
            return false;
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(n nVar, n nVar2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) nVar, (Object) nVar2)).intValue();
            }
            if (b(nVar) && b(nVar2)) {
                int i3 = nVar.f240505b.sPriority;
                int i16 = nVar2.f240505b.sPriority;
                if (i3 > i16) {
                    return 1;
                }
                if (i3 >= i16) {
                    return 0;
                }
                return -1;
            }
            if (b(nVar)) {
                return -1;
            }
            if (b(nVar2)) {
                return 1;
            }
            return 0;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21300);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f240379a = false;
        }
    }

    public static void A(AppRuntime appRuntime, int i3) {
        g(appRuntime, i3, "sp_key_leba_group_seq");
    }

    public static void B(AppRuntime appRuntime, int i3, int i16, int i17) {
        g(appRuntime, i3, F("sp_key_leba_group_seq", i16, i17));
    }

    public static void C(AppRuntime appRuntime, int i3, int i16) {
        QLog.i("LebaUtil", 1, "saveLebaInfo,layoutType = " + i3 + ",pluginType" + i16);
        if (appRuntime == null) {
            return;
        }
        LebaMmkvUtils.f240764a.i("sp_key_leba_plugin_type", i16);
    }

    public static void D(AppRuntime appRuntime, JSONObject jSONObject, int i3, int i16) {
        if (appRuntime == null || jSONObject == null || !com.tencent.mobileqq.leba.utils.c.c(i3, i16)) {
            return;
        }
        com.tencent.mobileqq.leba.utils.b.e(F("sp_key_leba_plugin_res_conf", i3, i16), jSONObject.toString());
    }

    public static void E(AppRuntime appRuntime, int i3, int i16) {
        QLog.d("LebaUtil", 2, "saveLebaStyleUserSetting model= " + i3 + ", style= " + i16);
        if (appRuntime == null || !a(i16)) {
            return;
        }
        LebaMmkvUtils.f240764a.i("sp_key_leba_style_user_setting" + i3, i16);
    }

    private static String F(String str, int i3, int i16) {
        return str + "_" + i3 + "_" + i16;
    }

    public static void G(AppRuntime appRuntime) {
        LebaMmkvUtils lebaMmkvUtils = LebaMmkvUtils.f240764a;
        String str = AppSetting.f99542b;
        lebaMmkvUtils.j("sp_key_leba_upgrade_info", str);
        if (QLog.isColorLevel()) {
            QLog.i("LebaUtil", 2, String.format("update version, buildNum[%s]", str));
        }
        c();
    }

    public static boolean a(int i3) {
        if (i3 == 1 || i3 == 2) {
            return true;
        }
        return false;
    }

    public static Map<Long, com.tencent.mobileqq.leba.entity.d> b(List<com.tencent.mobileqq.leba.entity.d> list) {
        if (list == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (com.tencent.mobileqq.leba.entity.d dVar : list) {
            if (dVar != null) {
                hashMap.put(Long.valueOf(dVar.f240471a), dVar);
            }
        }
        return hashMap;
    }

    private static void c() {
        LebaMmkvUtils.k("sp_key_leba_group_info");
        int[] iArr = {1, 2};
        int[] iArr2 = {1, 2};
        for (int i3 = 0; i3 < 2; i3++) {
            int i16 = iArr[i3];
            for (int i17 = 0; i17 < 2; i17++) {
                int i18 = iArr2[i17];
                LebaMmkvUtils.k(F("sp_key_leba_plugin_res_conf", i16, i18));
                LebaMmkvUtils.k(F("sp_key_leba_group_info", i16, i18));
            }
        }
    }

    private static List<com.tencent.mobileqq.leba.entity.d> d(AppRuntime appRuntime, String str) {
        ArrayList arrayList = new ArrayList();
        String d16 = com.tencent.mobileqq.leba.utils.b.d(str);
        if (d16 != null && !d16.isEmpty()) {
            try {
                JSONArray jSONArray = new JSONArray(d16);
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i3);
                    JSONArray names = jSONObject.names();
                    if (names != null) {
                        com.tencent.mobileqq.leba.entity.d dVar = new com.tencent.mobileqq.leba.entity.d();
                        for (int i16 = 0; i16 < names.length(); i16++) {
                            String string = names.getString(i16);
                            try {
                                if ("uiResId".equals(string)) {
                                    dVar.f240471a = jSONObject.getLong(string);
                                } else if ("groudId".equals(string)) {
                                    dVar.f240472b = jSONObject.getInt(string);
                                } else if ("index".equals(string)) {
                                    dVar.f240473c = jSONObject.getInt(string);
                                }
                            } catch (Exception e16) {
                                f240379a = true;
                                QLog.e("LebaUtil", 1, PluginConst.DataJsPluginConst.API_GET_GROUP_INFO, e16);
                            }
                        }
                        arrayList.add(dVar);
                        if (QLog.isDevelopLevel()) {
                            QLog.i("LebaUtil", 4, "" + dVar);
                        }
                    }
                }
            } catch (Exception e17) {
                f240379a = true;
                QLog.e("LebaUtil", 1, PluginConst.DataJsPluginConst.API_GET_GROUP_INFO, e17);
            }
            return arrayList;
        }
        QLog.e("LebaUtil", 1, "doGetGroupInfo content is null or empty: " + d16 + " spKey=" + str);
        return arrayList;
    }

    private static int e(AppRuntime appRuntime, String str) {
        if (appRuntime == null) {
            return -1;
        }
        int e16 = LebaMmkvUtils.f240764a.e(appRuntime, str, 0);
        if (QLog.isColorLevel()) {
            QLog.d("LebaUtil", 2, "getLebaGroup, seq=" + e16);
        }
        return e16;
    }

    private static void f(AppRuntime appRuntime, List<com.tencent.mobileqq.leba.entity.d> list, String str) {
        boolean z16;
        if (QLog.isColorLevel()) {
            QLog.i("LebaUtil", 2, "saveGroupInfo");
        }
        if (list != null && !list.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            for (com.tencent.mobileqq.leba.entity.d dVar : list) {
                if (dVar != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("uiResId", dVar.f240471a);
                        jSONObject.put("groudId", dVar.f240472b);
                        jSONObject.put("index", dVar.f240473c);
                        jSONArray.mo162put(jSONObject);
                        if (QLog.isDevelopLevel()) {
                            QLog.i("LebaUtil", 4, "" + dVar);
                        }
                    } catch (JSONException e16) {
                        QLog.e("LebaUtil", 1, "saveGroupInfo, exp=", e16);
                        z16 = false;
                    }
                }
            }
            z16 = true;
            if (z16) {
                QLog.i("LebaUtil", 1, "saveGroupInfo, result=true");
                com.tencent.mobileqq.leba.utils.b.e(str, jSONArray.toString());
                return;
            } else {
                QLog.e("LebaUtil", 1, "doSaveGroupInfo result=false");
                return;
            }
        }
        QLog.e("LebaUtil", 1, "doSaveGroupInfo datas is null or empty");
    }

    private static void g(AppRuntime appRuntime, int i3, String str) {
        if (QLog.isColorLevel()) {
            QLog.d("LebaUtil", 2, "saveLebaGroupSeq\uff0cseq=" + i3);
        }
        if (appRuntime == null) {
            return;
        }
        LebaMmkvUtils.f240764a.i(str, i3);
    }

    public static int h(int i3, int i16) {
        return (i3 * 1000) + (i16 * 4);
    }

    public static int i(com.tencent.mobileqq.leba.entity.d dVar) {
        if (dVar == null) {
            return 0;
        }
        return h(dVar.f240472b, dVar.f240473c);
    }

    public static List<com.tencent.mobileqq.leba.entity.d> j(AppRuntime appRuntime) {
        QLog.i("LebaUtil", 2, PluginConst.DataJsPluginConst.API_GET_GROUP_INFO);
        return d(appRuntime, "sp_key_leba_group_info");
    }

    public static List<com.tencent.mobileqq.leba.entity.d> k(AppRuntime appRuntime, int i3, int i16) {
        QLog.i("LebaUtil", 1, "getGroupInfo: mode= " + i3 + ", style= " + i16);
        return d(appRuntime, F("sp_key_leba_group_info", i3, i16));
    }

    public static int l(AppRuntime appRuntime) {
        return e(appRuntime, "sp_key_leba_group_seq");
    }

    public static int m(AppRuntime appRuntime, int i3, int i16) {
        return e(appRuntime, F("sp_key_leba_group_seq", i3, i16));
    }

    @NonNull
    public static JSONObject n(AppRuntime appRuntime, int i3, int i16) {
        if (appRuntime == null) {
            return new JSONObject();
        }
        if (!com.tencent.mobileqq.leba.utils.c.c(i3, i16)) {
            return new JSONObject();
        }
        String d16 = com.tencent.mobileqq.leba.utils.b.d(F("sp_key_leba_plugin_res_conf", i3, i16));
        if (d16 != null && !d16.isEmpty()) {
            try {
                return new JSONObject(d16);
            } catch (JSONException e16) {
                QLog.e("LebaUtil", 1, "getLebaPluginResConf exception", e16);
                return new JSONObject();
            }
        }
        QLog.e("LebaUtil", 1, "getLebaPluginResConf error ret is null or empty: " + d16);
        return new JSONObject();
    }

    public static int o(AppRuntime appRuntime) {
        if (appRuntime == null) {
            return -1;
        }
        int e16 = LebaMmkvUtils.f240764a.e(appRuntime, "sp_key_leba_plugin_type", 0);
        if (e16 != 4042) {
            QLog.i("LebaUtil", 1, "getLebaPluginType =" + e16);
        }
        return e16;
    }

    @IntRange(from = 0, to = 2)
    public static int p(AppRuntime appRuntime, int i3) {
        if (appRuntime == null) {
            return 0;
        }
        int e16 = LebaMmkvUtils.f240764a.e(appRuntime, "sp_key_leba_style_user_setting" + i3, 0);
        if (e16 != 1 && e16 != 2) {
            return 0;
        }
        return e16;
    }

    public static void q(Context context, AppRuntime appRuntime, boolean z16, int i3) {
        Intent intent = new Intent();
        intent.putExtra("key_open_edit_mode", z16);
        intent.putExtra("key_leba_style", i3);
        QPublicFragmentActivity.start(context, intent, LebaMoreFragment.class);
    }

    public static boolean r(AppRuntime appRuntime) {
        String g16 = LebaMmkvUtils.f240764a.g(appRuntime, "sp_key_leba_upgrade_info", "");
        String str = AppSetting.f99542b;
        boolean z16 = !str.equals(g16);
        if (QLog.isColorLevel()) {
            QLog.i("LebaUtil", 2, String.format("update version isAppUpgrade[%b], preBuildNum[%s], cur[%s]", Boolean.valueOf(z16), g16, str));
        }
        return z16;
    }

    public static boolean s(n nVar) {
        LebaPluginInfo lebaPluginInfo = nVar.f240505b;
        if (lebaPluginInfo.cDataType == 1 && !TextUtils.isEmpty(lebaPluginInfo.strPkgName)) {
            return "qzone_feedlist".equals(nVar.f240505b.strPkgName);
        }
        return false;
    }

    public static boolean t(AppRuntime appRuntime) {
        return false;
    }

    public static void u(List<n> list, List<n> list2) {
        com.tencent.mobileqq.leba.utils.d.a(list, list2);
        if (LebaPluginLogic.e() == 1) {
            return;
        }
        n nVar = new n();
        nVar.f240507d = 2;
        list.add(nVar);
    }

    public static boolean v(AppRuntime appRuntime, long j3, Set<Long> set) {
        if (j3 == JsonGrayBusiId.UI_RESERVE_100000_110000) {
            return false;
        }
        return set.contains(Long.valueOf(j3));
    }

    public static void w(String str, String str2, String str3) {
        QLog.e("LebaUtil", 1, "recordApiEmpty tag = " + str + ", method = " + str2 + ",apiName = " + str3);
    }

    public static void x(List<n> list) {
        if (list == null) {
            return;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(list.size());
        linkedHashSet.addAll(list);
        list.clear();
        list.addAll(linkedHashSet);
    }

    public static void y(AppRuntime appRuntime, List<com.tencent.mobileqq.leba.entity.d> list) {
        f(appRuntime, list, "sp_key_leba_group_info");
    }

    public static void z(AppRuntime appRuntime, List<com.tencent.mobileqq.leba.entity.d> list, int i3, int i16) {
        f(appRuntime, list, F("sp_key_leba_group_info", i3, i16));
    }
}
