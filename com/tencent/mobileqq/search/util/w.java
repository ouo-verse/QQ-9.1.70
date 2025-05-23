package com.tencent.mobileqq.search.util;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.constants.QFSNumberConstants;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$Content;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.UfsDisTabBizPair;
import com.tencent.util.CommonMmkvAdaptUtils;
import java.net.URLEncoder;
import java.util.List;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class w {

    /* renamed from: a, reason: collision with root package name */
    public static String f285090a = null;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f285091b = false;

    public static void A(int i3, String str) {
        ah.f284994a.r("tab_configurations_" + i3, str);
        QLog.d("Q.uniteSearch.SearchConfigUtils", 1, "setTabExpNameByType:" + str);
    }

    public static void B(List<UfsDisTabBizPair> list) {
        if (list != null) {
            for (UfsDisTabBizPair ufsDisTabBizPair : list) {
                A(ufsDisTabBizPair.key, ufsDisTabBizPair.value);
            }
        }
    }

    public static String a(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (str.contains("from=native_relate_search")) {
            return str.replace("from=native_relate_search", "from=" + f(i3));
        }
        return str;
    }

    public static String b(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (str.contains("from=native_relate_search")) {
            return str.replace("from=native_relate_search", "from=" + q(i3));
        }
        return str;
    }

    public static boolean c() {
        boolean z16;
        sa1.b k3 = k();
        if (k3 != null) {
            z16 = k3.c();
        } else {
            z16 = true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.uniteSearch.SearchConfigUtils", 2, "bEnableFtsTroop. " + z16);
        }
        return z16;
    }

    public static String d(int i3) {
        return com.tencent.mobileqq.search.report.b.a(i3) + "_hotword";
    }

    public static String e(int i3) {
        String h16 = ah.f284994a.h("kNameByType_" + i3, "");
        QLog.d("Q.uniteSearch.SearchConfigUtils", 1, "getModelNameByType:" + h16);
        return h16;
    }

    public static String f(int i3) {
        return com.tencent.mobileqq.search.report.b.a(i3) + "_moresearch";
    }

    public static String g(String str, int i3, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d("Q.uniteSearch.SearchConfigUtils", 2, "getNetSearchJumpUrl()  word=" + str + "  source=" + i3);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return j(i3, str2).replace("$KEYWORD$", Uri.encode(str));
    }

    public static String h(String str, String str2, int i3, String str3) {
        String replace;
        if (QLog.isColorLevel()) {
            QLog.d("Q.uniteSearch.SearchConfigUtils", 2, "getNetSearchJumpUrl()  word=" + str2 + "  source=" + i3);
        }
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (!TextUtils.isEmpty(str)) {
            replace = str.replace("$KEYWORD$", Uri.encode(str2)).replace("$SOURCE$", "" + i3).replace("$FROM$", "" + URLEncoder.encode(str3));
        } else {
            replace = "https://so.html5.qq.com/page/real/kd_result?_bid=3216&_wv=3&_wwv=1293&_wvSb=0&q=$KEYWORD$&from=$FROM$".replace("$KEYWORD$", Uri.encode(str2)).replace("$SOURCE$", "" + i3).replace("$FROM$", "" + URLEncoder.encode(str3));
        }
        if (QLog.isColorLevel()) {
            QLog.i("Q.uniteSearch.SearchConfigUtils", 2, "getNetSearchJumpUrlWithUrl " + replace);
        }
        return replace;
    }

    private static sa1.a i() {
        sa1.a aVar = (sa1.a) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100520");
        if (aVar == null || !aVar.e()) {
            return (sa1.a) com.tencent.mobileqq.config.am.s().x(433);
        }
        return aVar;
    }

    @NonNull
    public static String j(int i3, String str) {
        String str2;
        String replace;
        if (QLog.isColorLevel()) {
            QLog.d("Q.uniteSearch.SearchConfigUtils", 2, "getNetSearchJumpUrl()  source=" + i3);
        }
        String account = BaseApplicationImpl.getApplication().getRuntime().getAccount();
        String str3 = "SearchConfigUtils_Switch" + account;
        CommonMmkvAdaptUtils commonMmkvAdaptUtils = CommonMmkvAdaptUtils.INSTANCE;
        int i16 = commonMmkvAdaptUtils.getInt(str3, "kFTSEnhanceOnlyNetSearchJumpToWeb" + account, "search", 1);
        if (i16 == 1) {
            str2 = commonMmkvAdaptUtils.getString(str3, "kFTSEnhanceNetSearchJumpUrlForOnlyNetSearchJumpToWeb" + account, "search", "");
        } else {
            str2 = null;
        }
        if (!TextUtils.isEmpty(f.b().c())) {
            str2 = f.b().c();
        }
        if (!TextUtils.isEmpty(str2)) {
            replace = str2.replace("$SOURCE$", "" + i3).replace("$FROM$", "" + URLEncoder.encode(str));
            if (SearchUtils.I0(replace)) {
                replace = replace.replace("$SEARCHID$", "" + URLEncoder.encode(UniteSearchActivity.f282687e0)).replace("$SEQNO$", "" + URLEncoder.encode(UniteSearchActivity.f282688f0));
            }
        } else {
            replace = "https://so.html5.qq.com/page/real/kd_result?_bid=3216&_wv=3&_wwv=1293&_wvSb=0&q=$KEYWORD$&from=$FROM$".replace("$SOURCE$", "" + i3).replace("$FROM$", "" + URLEncoder.encode(str));
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.uniteSearch.SearchConfigUtils", 2, "isSearchEnhanceEnable() uin=" + account + " resultUrl=" + replace + " enhanceEnableForJumpToWeb=" + i16);
        }
        return replace;
    }

    public static sa1.b k() {
        sa1.b bVar = (sa1.b) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100501");
        if (bVar == null || !bVar.e()) {
            return (sa1.b) com.tencent.mobileqq.config.am.s().x(432);
        }
        return bVar;
    }

    public static int l() {
        String account = BaseApplicationImpl.getApplication().getRuntime().getAccount();
        return CommonMmkvAdaptUtils.INSTANCE.getInt("SearchConfigUtils_Switch" + account, "search_url_config_version" + account, "search", 0);
    }

    private static sa1.c m() {
        sa1.c cVar = (sa1.c) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100522");
        if (cVar == null || !cVar.f()) {
            return (sa1.c) com.tencent.mobileqq.config.am.s().x(QFSNumberConstants.Int.NUM_456);
        }
        return cVar;
    }

    public static String n(String str) {
        String str2;
        sa1.c m3 = m();
        if (m3 != null) {
            str2 = m3.c(str);
        } else {
            str2 = null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.uniteSearch.SearchConfigUtils", 2, "VerticalSearchName. bizType = " + str + "\uff0c result = " + str2);
        }
        return str2;
    }

    public static String o(String str) {
        String str2;
        sa1.c m3 = m();
        if (m3 != null) {
            str2 = m3.b(str);
        } else {
            str2 = null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.uniteSearch.SearchConfigUtils", 2, "isVerticalSerachSwitchOn. bizType = " + str + "\uff0c result = " + str2);
        }
        return str2;
    }

    public static String p(String str) {
        String str2;
        sa1.c m3 = m();
        if (m3 != null) {
            str2 = m3.d(str);
        } else {
            str2 = null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.uniteSearch.SearchConfigUtils", 2, "isVerticalSerachSwitchOn. bizType = " + str + "\uff0c result = " + str2);
        }
        return str2;
    }

    public static String q(int i3) {
        return com.tencent.mobileqq.search.report.b.a(i3) + "_websearch";
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void r(ConfigurationService$Config configurationService$Config) {
        String stringUtf8;
        String str;
        String str2;
        JSONObject jSONObject;
        int optInt;
        String optString;
        String optString2;
        String optString3;
        boolean z16;
        int i3;
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        String account = application.getRuntime().getAccount();
        int i16 = configurationService$Config.version.get();
        CommonMmkvAdaptUtils commonMmkvAdaptUtils = CommonMmkvAdaptUtils.INSTANCE;
        int i17 = commonMmkvAdaptUtils.getInt("SearchConfigUtils_Switch" + account, "search_url_config_version" + account, "search", 0);
        QLog.i("search_manager_configSearchConfigServlet", 1, "handleSearchEnhanceSwitchConfig newVersion=" + i16 + " oldVersion=" + i17);
        if (i16 <= i17) {
            return;
        }
        if (configurationService$Config.msg_content_list.size() > 0) {
            ConfigurationService$Content configurationService$Content = configurationService$Config.msg_content_list.get(0);
            if (configurationService$Content != null) {
                if (configurationService$Content.compress.get() == 1) {
                    byte[] d16 = com.tencent.mobileqq.olympic.utils.a.d(configurationService$Content.content.get().toByteArray());
                    if (d16 != null) {
                        try {
                        } catch (Throwable th5) {
                            th = th5;
                            i3 = 1;
                        }
                        try {
                            stringUtf8 = new String(d16, "UTF-8");
                        } catch (Throwable th6) {
                            th = th6;
                            i3 = 1;
                            QLog.i("search_manager_configSearchConfigServlet", i3, "handleSearchEnhanceSwitchConfig", th);
                            stringUtf8 = null;
                            QLog.i("search_manager_configSearchConfigServlet", 1, "handleSearchEnhanceSwitchConfig jsonContent = " + stringUtf8);
                            if (stringUtf8 == null) {
                            }
                        }
                    } else {
                        QLog.i("search_manager_configSearchConfigServlet", 1, "handleSearchEnhanceSwitchConfig buff == null");
                    }
                    stringUtf8 = null;
                } else {
                    stringUtf8 = configurationService$Content.content.get().toStringUtf8();
                }
                QLog.i("search_manager_configSearchConfigServlet", 1, "handleSearchEnhanceSwitchConfig jsonContent = " + stringUtf8);
                if (stringUtf8 == null) {
                    CommonMmkvAdaptUtils commonMmkvAdaptUtils2 = CommonMmkvAdaptUtils.INSTANCE;
                    commonMmkvAdaptUtils2.putInt("search_url_config_version" + account, "search", i16);
                    try {
                        jSONObject = new JSONObject(stringUtf8);
                        optInt = jSONObject.optInt("kFTSEnhanceOnlyNetSearchJumpToWeb");
                        optString = jSONObject.optString("kFTSEnhanceNetSearchJumpUrlForEnhance");
                        optString2 = jSONObject.optString("kFTSEnhanceNetSearchJumpUrlForOnlyNetSearchJumpToWeb");
                        try {
                            optString3 = jSONObject.optString("kFTSReadInJoySearchPlaceholderPrefix");
                        } catch (Exception e16) {
                            e = e16;
                            str = "handleSearchEnhanceSwitchConfig";
                            str2 = "search_manager_configSearchConfigServlet";
                            QLog.i(str2, 1, str, e);
                            return;
                        }
                    } catch (Exception e17) {
                        e = e17;
                        str = "handleSearchEnhanceSwitchConfig";
                    }
                    try {
                        String optString4 = jSONObject.optString("kFTSDynamicTabSearchPlaceholderPrefix");
                        MMKVOptionEntity from = QMMKV.from(application, "common_mmkv_configurations");
                        String str3 = "kFTSDynamicTabSearchBarDontShow" + application.getRuntime().getAccount();
                        if (jSONObject.optInt("kFTSDynamicTabSearchBarDontShow") == 1) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        from.encodeBool(str3, z16);
                        commonMmkvAdaptUtils2.putInt("kFTSEnhanceOnlyNetSearchJumpToWeb" + account, "search", optInt);
                        if (!TextUtils.isEmpty(optString)) {
                            commonMmkvAdaptUtils2.putString("kFTSEnhanceNetSearchJumpUrlForEnhance" + account, "search", optString);
                        }
                        if (!TextUtils.isEmpty(optString2)) {
                            commonMmkvAdaptUtils2.putString("kFTSEnhanceNetSearchJumpUrlForOnlyNetSearchJumpToWeb" + account, "search", optString2);
                        }
                        if (!TextUtils.isEmpty(optString3)) {
                            commonMmkvAdaptUtils2.putString("kFTSReadInJoySearchPlaceholderPrefix" + account, "search", optString3);
                        }
                        if (!TextUtils.isEmpty(optString4)) {
                            commonMmkvAdaptUtils2.putString("kFTSDynamicTabSearchPlaceholderPrefix" + account, "search", optString4);
                        }
                        f285090a = null;
                        return;
                    } catch (Exception e18) {
                        e = e18;
                        str = "handleSearchEnhanceSwitchConfig";
                        str2 = "search_manager_configSearchConfigServlet";
                        QLog.i(str2, 1, str, e);
                        return;
                    }
                }
                return;
            }
            return;
        }
        QLog.i("search_manager_configSearchConfigServlet", 1, "handleSearchEnhanceSwitchConfig. config is null or size = 0. config=" + configurationService$Config);
    }

    public static boolean s(int i3) {
        boolean b16 = ah.f284994a.b("kType_" + i3, true);
        QLog.d("Q.uniteSearch.SearchConfigUtils", 1, "isEnableHotListSearch isSwitchOn:" + b16);
        return b16;
    }

    public static boolean t() {
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101055", false);
        QLog.d("Q.uniteSearch.SearchConfigUtils", 1, "isEnableQzoneSearch isSwitchOn:" + isSwitchOn);
        if (!isSwitchOn && !f285091b) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean u(int i3) {
        boolean z16;
        sa1.a i16 = i();
        if (i16 != null) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        z16 = i16.c();
                    }
                } else {
                    z16 = i16.b();
                }
            } else {
                z16 = i16.d();
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.uniteSearch.SearchConfigUtils", 2, "isHotWordSwitchOn. " + z16);
            }
            return z16;
        }
        z16 = false;
        if (QLog.isColorLevel()) {
        }
        return z16;
    }

    public static boolean v(String str) {
        return false;
    }

    public static boolean w() {
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        String account = application.getRuntime().getAccount();
        MMKVOptionEntity from = QMMKV.from(application, "common_mmkv_configurations");
        String str = "kFTSDynamicTabSearchBarDontShow" + account;
        if (from.containsKey(str)) {
            return !from.decodeBool(str, false);
        }
        boolean z16 = application.getSharedPreferences("SearchConfigUtils_Switch" + account, 0).getBoolean(str, false);
        from.encodeBool(str, z16);
        return !z16;
    }

    public static boolean x(String str) {
        boolean z16;
        sa1.c m3 = m();
        if (m3 != null) {
            z16 = m3.e(str);
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.uniteSearch.SearchConfigUtils", 2, "isVerticalSerachSwitchOn. bizType = " + str + "\uff0c result = " + z16);
        }
        return z16;
    }

    public static void y(int i3, boolean z16) {
        ah.f284994a.l("kType_" + i3, z16);
        QLog.d("Q.uniteSearch.SearchConfigUtils", 1, "setEnableHotListSearch isSwitchOn:" + z16);
    }

    public static void z(int i3, String str) {
        ah.f284994a.r("kNameByType_" + i3, str);
        QLog.d("Q.uniteSearch.SearchConfigUtils", 1, "setModelNameByType:" + str);
    }
}
