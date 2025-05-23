package nn2;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$Content;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchConfigUtilFetcher;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f420530a = false;

    /* renamed from: b, reason: collision with root package name */
    public static String f420531b = "";

    /* renamed from: c, reason: collision with root package name */
    public static String f420532c = "Hot_word";

    /* renamed from: d, reason: collision with root package name */
    public static int f420533d = 8;

    public static int a() {
        return 1;
    }

    public static String b() {
        AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        String currentAccountUin = appInterface.getCurrentAccountUin();
        String qqStr = HardCodeUtil.qqStr(R.string.h_a);
        if (TextUtils.isEmpty(((ISearchConfigUtilFetcher) QRoute.api(ISearchConfigUtilFetcher.class)).getSFtsSearchBarWording())) {
            if (((ISearchConfigUtilFetcher) QRoute.api(ISearchConfigUtilFetcher.class)).isSearchEnhanceEnable(appInterface.getCurrentAccountUin())) {
                MobileQQ mobileQQ = MobileQQ.sMobileQQ;
                if (TextUtils.isEmpty(currentAccountUin)) {
                    currentAccountUin = "";
                }
                String string = PreferenceManager.getDefaultSharedPreferences(mobileQQ).getString("fts_search_bar_summary" + currentAccountUin, "");
                if (!TextUtils.isEmpty(string)) {
                    ((ISearchConfigUtilFetcher) QRoute.api(ISearchConfigUtilFetcher.class)).setSFtsSearchBarWording(string);
                } else {
                    string = HardCodeUtil.qqStr(R.string.h_a);
                }
                qqStr = string;
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("Q.uniteSearch.SearchEntryConfigManager", 2, "getFtsSearchBarWording() cache wording is not null. " + ((ISearchConfigUtilFetcher) QRoute.api(ISearchConfigUtilFetcher.class)).getSFtsSearchBarWording());
            }
            qqStr = ((ISearchConfigUtilFetcher) QRoute.api(ISearchConfigUtilFetcher.class)).getSFtsSearchBarWording();
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.uniteSearch.SearchEntryConfigManager", 2, "getFtsSearchBarWording() searchBarWording=" + qqStr);
        }
        return qqStr;
    }

    public static String c() {
        String currentAccountUin = ((AppInterface) MobileQQ.sMobileQQ.peekAppRuntime()).getCurrentAccountUin();
        return PreferenceManager.getDefaultSharedPreferences(MobileQQ.sMobileQQ).getString("pref_net_search_function_title" + currentAccountUin, HardCodeUtil.qqStr(R.string.t6m));
    }

    public static int[] d(AppInterface appInterface, int i3) {
        String[] split = PreferenceManager.getDefaultSharedPreferences(MobileQQ.sMobileQQ).getString("search_discovery_sp_prefix_unifypref_search_model_list" + appInterface.getCurrentAccountUin() + "_" + i3, "").split("_");
        QLog.d("Q.uniteSearch.SearchEntryConfigManager818searchProto_new", 2, "getModelListByTab");
        int[] iArr = null;
        if (split.length > 0) {
            try {
                int[] iArr2 = new int[split.length];
                for (int i16 = 0; i16 < split.length; i16++) {
                    iArr2[i16] = Integer.valueOf(split[i16]).intValue();
                }
                iArr = iArr2;
            } catch (NumberFormatException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("Q.uniteSearch.SearchEntryConfigManager", 2, "getEntryListByTab, NumberFormatException, e = " + e16 + ", uin = " + appInterface.getCurrentAccountUin() + ", tabType = " + i3);
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.uniteSearch.SearchEntryConfigManager", 2, "getEntryListByTab, result = " + iArr + ", uin = " + appInterface.getCurrentAccountUin() + ", tabType = " + i3);
        }
        return iArr;
    }

    public static int e(String str, int i3) {
        String currentAccountUin = ((AppInterface) MobileQQ.sMobileQQ.peekAppRuntime()).getCurrentAccountUin();
        int i16 = PreferenceManager.getDefaultSharedPreferences(MobileQQ.sMobileQQ).getInt(str + currentAccountUin, i3);
        if (i16 != 0) {
            return i16;
        }
        return i3;
    }

    public static boolean f(AppInterface appInterface, int i3, boolean z16) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(MobileQQ.sMobileQQ);
        if (!z16) {
            boolean z17 = defaultSharedPreferences.getBoolean("search_discovery_sp_prefixrefresh_search_model_list" + appInterface.getCurrentAccountUin() + "_" + i3, true);
            QLog.d("Q.uniteSearch.SearchEntryConfigManager818searchProto_old", 2, "getNeedRefreshModelList");
            return z17;
        }
        boolean z18 = defaultSharedPreferences.getBoolean("search_discovery_sp_prefix_unifyrefresh_search_model_list" + appInterface.getCurrentAccountUin() + "_" + i3, true);
        QLog.d("Q.uniteSearch.SearchEntryConfigManager818searchProto_new", 2, "getNeedRefreshModelList");
        return z18;
    }

    public static String g(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return PreferenceManager.getDefaultSharedPreferences(context).getString("net_search_cell_summary" + str, "");
    }

    public static int h(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return PreferenceManager.getDefaultSharedPreferences(context).getInt("search_net_config_version_code" + str + AppSetting.n(), -1);
    }

    public static boolean i(AppInterface appInterface) {
        boolean z16 = PreferenceManager.getDefaultSharedPreferences(MobileQQ.sMobileQQ).getBoolean(appInterface.getCurrentAccountUin() + "QQ_SEARCH_SHOW_HOTLIST", true);
        QLog.d("hotwordPreference:", 2, "hidden:" + z16);
        return z16;
    }

    public static void j(AppInterface appInterface, boolean z16) {
        QLog.d("hotwordPreference:", 2, "sethidden:" + z16 + "result:" + PreferenceManager.getDefaultSharedPreferences(MobileQQ.sMobileQQ).edit().putBoolean(appInterface.getCurrentAccountUin() + "QQ_SEARCH_SHOW_HOTLIST", z16).commit());
    }

    public static void k(AppInterface appInterface, int i3, int[] iArr) {
        StringBuilder sb5 = new StringBuilder("");
        if (iArr != null && iArr.length > 0) {
            for (int i16 = 0; i16 < iArr.length - 1; i16++) {
                sb5.append(iArr[i16]);
                sb5.append("_");
            }
            sb5.append(iArr[iArr.length - 1]);
        }
        PreferenceManager.getDefaultSharedPreferences(MobileQQ.sMobileQQ).edit().putString("search_discovery_sp_prefix_unifypref_search_model_list" + appInterface.getCurrentAccountUin() + "_" + i3, sb5.toString()).commit();
        QLog.d("Q.uniteSearch.SearchEntryConfigManager818searchProto_new", 2, "updateModelListByTab");
        if (QLog.isColorLevel()) {
            QLog.e("Q.uniteSearch.SearchEntryConfigManager", 2, "setEntryListByTab, result = " + sb5.toString() + ", uin = " + appInterface.getCurrentAccountUin() + ", tabType = " + i3);
        }
    }

    public static void l(AppInterface appInterface, int i3, boolean z16) {
        PreferenceManager.getDefaultSharedPreferences(MobileQQ.sMobileQQ).edit().putBoolean("search_discovery_sp_prefix_unifyrefresh_search_model_list" + appInterface.getCurrentAccountUin() + "_" + i3, z16).commit();
        QLog.d("Q.uniteSearch.SearchEntryConfigManager818searchProto_new", 2, "updateNeedRefreshModelList");
    }

    public static void m(Context context, ConfigurationService$Config configurationService$Config, String str) {
        String str2;
        ConfigurationService$Content configurationService$Content;
        String stringUtf8;
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        if (!TextUtils.isEmpty(str)) {
            str2 = str;
        } else {
            str2 = "";
        }
        PBRepeatMessageField<ConfigurationService$Content> pBRepeatMessageField = configurationService$Config.msg_content_list;
        if (pBRepeatMessageField != null && pBRepeatMessageField.size() > 0 && (configurationService$Content = configurationService$Config.msg_content_list.get(0)) != null) {
            if (configurationService$Content.compress.get() == 1) {
                byte[] inflateConfigString = ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).inflateConfigString(configurationService$Content.content.get().toByteArray());
                if (inflateConfigString != null) {
                    try {
                        stringUtf8 = new String(inflateConfigString, "UTF-8");
                    } catch (Throwable th5) {
                        QLog.i("Q.uniteSearch.SearchEntryConfigManager", 1, "updateNetSearchConfig", th5);
                    }
                } else {
                    QLog.i("Q.uniteSearch.SearchEntryConfigManager", 1, "updateNetSearchConfig buff != null");
                }
                stringUtf8 = null;
            } else {
                stringUtf8 = configurationService$Content.content.get().toStringUtf8();
            }
            QLog.i("Q.uniteSearch.SearchEntryConfigManager", 1, "updateNetSearchConfig jsonContent=" + stringUtf8);
            if (stringUtf8 != null) {
                try {
                    JSONObject jSONObject = new JSONObject(stringUtf8);
                    String optString = jSONObject.optString("kNetSearchEntranceCellSummary");
                    int optInt = jSONObject.optInt("kFTSNativeContactorMaxNum");
                    int optInt2 = jSONObject.optInt("kFTSNativeChatHistoryMaxNum");
                    int optInt3 = jSONObject.optInt("kFTSNativeFunctionMaxNum");
                    int optInt4 = jSONObject.optInt("kDynamicNeedSearchNative");
                    int optInt5 = jSONObject.optInt("kFTSNativePubAccountMaxNum");
                    String optString2 = jSONObject.optString("kFTSNativeFunctionTitleName", HardCodeUtil.qqStr(R.string.t6n));
                    edit.putString("net_search_cell_summary" + str2, optString);
                    edit.putString("fts_search_bar_summary" + str2, jSONObject.optString("kFTSSearchBarPlaceHolder"));
                    edit.putInt("fts_native_contactor_maxnum" + str2, optInt);
                    edit.putInt("fts_native_chathistory_maxnum" + str2, optInt2);
                    edit.putInt("fts_native_function_maxnum" + str2, optInt3);
                    edit.putInt("fts_should_show_netsearch_persongroup_tab1" + str2, jSONObject.optInt("kFTSShouldShowNetSearchPersonGroupTab1"));
                    edit.putInt("fts_should_show_netsearch_persongroup_tab2" + str2, jSONObject.optInt("kFTSShouldShowNetSearchPersonGroupTab2"));
                    edit.putInt("fts_should_show_netsearch_persongroup_tab3" + str2, jSONObject.optInt("kFTSShouldShowNetSearchPersonGroupTab3"));
                    edit.putInt("dynamic_need_search_native" + str2, optInt4);
                    edit.putInt("pref_fts_native_search_public_account_max_num" + str2, optInt5);
                    edit.putString("pref_net_search_function_title" + str2, optString2);
                    edit.commit();
                    ((ISearchConfigUtilFetcher) QRoute.api(ISearchConfigUtilFetcher.class)).setSFtsSearchBarWording(null);
                    return;
                } catch (Exception e16) {
                    QLog.i("Q.uniteSearch.SearchEntryConfigManager", 1, "updateNetSearchConfig parseJsonError", e16);
                }
            }
        }
        n(context, -1, str);
    }

    public static void n(Context context, int i3, String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt("search_net_config_version_code" + str + AppSetting.n(), i3);
        edit.commit();
    }
}
