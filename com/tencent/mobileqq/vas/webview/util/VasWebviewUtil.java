package com.tencent.mobileqq.vas.webview.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.annotation.Nullable;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.comic.api.IQQDcReporter;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.DcReportUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.ab.ABTest;
import com.tencent.mobileqq.vas.ab.b;
import com.tencent.mobileqq.vas.api.IVasCommonAdapter;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.mobileqq.vas.toggle.UnitedProxy;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vas.webview.VasWebConstants;
import com.tencent.mobileqq.vas.webview.bean.EntryReportParams;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.xweb.FileReaderHelper;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class VasWebviewUtil {
    public static final String BUSINESS_NAME = "individuation_mainpage_config2";
    private static String DEF_KUIKLY_URL = null;
    public static final String DIR_NAME_FESTIVAL_ANIMATION = "IndividuationAnimation";
    public static final String H5_AID = "mvip.gexinghua.android.zbcenter_h5";
    public static final String IS_FORCE_PULL_JSON_SP_KEY = "individuationIsForcePullSpKey";
    public static final String JSON_FILE_NAME = "IndividuationMainpageConfig4.json";
    public static final int JSON_UPDATE_INTERVAL = 3600000;
    public static final String LAST_JSON_TIME_SP_KEY = "individuationLastJsonTimeSpKey";
    public static final String LAST_VIP_RECOMMEND_TIME_SP_KEY = "individuationLastVIPRecommendSpKey";
    public static final String NATIVE_AID = "mvip.gexinghua.android.zbcenter_qianbao";
    public static final String RECOMMEND_FAIL_H5_AID = "mvip.gexinghua.android.zbcenter_h5recall";
    public static final String SP_FILE_NAME_FOR_INDIVIDUATION_MAINPAGE = "sp_individuation_mainpage2";
    public static final String SP_KEY_LAST_FESTIVAL_ANIMATION_ZIP_URL = "sp_key_last_festival_animation_zip_url";
    public static final String SP_KEY_LOCAL_JSON_VERSION = "IndividuationConfigJsonVersion4";
    public static final String SP_PARSE_ASYNC_COOKIE = "read_vas_asyncCookie";
    public static final String TAG = "VasWebviewUtil";
    public static final String VIP_RECOMMEND_FILE_NAME = "VIPRecommendPayFile.txt";
    public static final int VIP_RECOMMEND_INTERVAL = 3600000;
    private static boolean isNewToggleOpen = false;
    private static boolean isToggleOpen = false;
    public static ConcurrentHashMap<String, String> mAsyncCookiesForVas = null;
    private static UnitedProxy newToggle = null;
    public static String res = "";
    private static UnitedProxy toggle;

    static {
        UnitedProxy b16 = ar.b("shouyouye", "2024-04-08", "vas_gxh_home_kuikly_config");
        toggle = b16;
        isToggleOpen = b16.isEnable(false);
        newToggle = ar.b("shouyouye", "2024-04-08", "vas_gxh_home_tab_config");
        isNewToggleOpen = toggle.isEnable(false);
        DEF_KUIKLY_URL = "mqqapi://kuikly/open?version=1&src_type=app&qqmc_config=vas_kuikly_config&page_name=vas_gxh_shop&bundle_name=vas_gxh_shop&kr_turbo_display=1";
        mAsyncCookiesForVas = new ConcurrentHashMap<>();
    }

    public static String addEntryParamToUrl(String str, int i3) {
        return addEntryParamToUrl(str, i3, null);
    }

    @Nullable
    private static String buildUrlParam(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            return str2 + "&url=" + URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e16) {
            QLog.i(TAG, 1, "encode error: " + e16);
            return null;
        }
    }

    public static String getATag(int i3, String str) {
        if (i3 != 2 && i3 != 3) {
            if (i3 == 7) {
                return "vip.gongneng.mobile.biaoqing.client_index_banner";
            }
            if (i3 == 6) {
                return "vip.gongneng.mobile.biaoqing.client_aio_magic";
            }
            return str;
        }
        return "vip.gongneng.mobile.biaoqing.client_manager_top";
    }

    public static int getActivityType(long j3) {
        if (j3 == 4) {
            return 3;
        }
        if (j3 == 8) {
            return 2;
        }
        return 1;
    }

    private static String getConfigUrl(String str) {
        if (!isNewToggleOpen) {
            QLog.i(TAG, 1, "getConfigUrl is toggle unenable");
            return "";
        }
        String stringDataSet = newToggle.getStringDataSet("url", "");
        if (!TextUtils.isEmpty(stringDataSet) && !TextUtils.equals(stringDataSet, "none")) {
            String buildUrlParam = buildUrlParam(str, stringDataSet);
            QLog.i(TAG, 1, "getConfigUrl abtest:xxx url:" + buildUrlParam);
            return buildUrlParam;
        }
        QLog.i(TAG, 1, "getConfigUrl no jump");
        return "";
    }

    public static String getHome(Intent intent, Context context) {
        String marketUrl = IndividuationUrlHelper.getMarketUrl(context, "emoji", "");
        if (((IVasCommonAdapter) QRoute.api(IVasCommonAdapter.class)).isFragmentStyleOrEmoStore(intent)) {
            return ((IVasCommonAdapter) QRoute.api(IVasCommonAdapter.class)).processEmoStoreHomeUrl(marketUrl);
        }
        return marketUrl;
    }

    private static String getKuiklyUrl(String str) {
        String optString;
        JSONObject json = toggle.getJson();
        if (!isToggleOpen && TextUtils.isEmpty(toggle.getJson().optString("kuikly_url"))) {
            optString = DEF_KUIKLY_URL;
        } else {
            if (!isToggleOpen) {
                QLog.i(TAG, 1, "getKuiklyUrl is toggle unenable");
                return "";
            }
            optString = json.optString("kuikly_url", DEF_KUIKLY_URL);
        }
        if (!TextUtils.isEmpty(optString)) {
            try {
                String str2 = optString + "&url=" + URLEncoder.encode(str, "utf-8");
                if (json.optInt(FileReaderHelper.OPEN_FILE_FROM_FORCE) == 1) {
                    QLog.i(TAG, 1, "getKuiklyUrl force url:" + str2);
                    return str2;
                }
                String optString2 = json.optString("abtest_name");
                if (TextUtils.isEmpty(optString2)) {
                    return "";
                }
                b bVar = new b(optString2);
                if (bVar.a().getFirst() == ABTest.B) {
                    QLog.i(TAG, 1, "getKuiklyUrl abtest:" + bVar + " url:" + str2);
                    return str2;
                }
            } catch (UnsupportedEncodingException e16) {
                QLog.i(TAG, 1, "encode error: " + e16);
                return "";
            }
        }
        QLog.i(TAG, 1, "getKuiklyUrl no jump");
        return "";
    }

    @NotNull
    private static Intent getWithoutADIntent(Context context, String str, long j3, Intent intent) {
        if (intent != null) {
            intent.setClass(context, ((IVasCommonAdapter) QRoute.api(IVasCommonAdapter.class)).getQQBrowserActivityClass());
        } else {
            intent = new Intent(context, ((IVasCommonAdapter) QRoute.api(IVasCommonAdapter.class)).getQQBrowserActivityClass());
        }
        String parseUrlParams = parseUrlParams(context, str, j3, intent);
        if (!TextUtils.isEmpty(parseUrlParams)) {
            intent.putExtra("url", parseUrlParams);
            intent = putWebViewTitleStyle(intent, Uri.parse(parseUrlParams).getHost());
        }
        intent.putExtra("business", j3);
        insertVasWbPluginToIntent(j3, intent);
        if (intent.getLongExtra("startOpenPageTime", 0L) <= 0) {
            intent.putExtra("startOpenPageTime", System.currentTimeMillis());
        }
        intent.putExtra(((IVasCommonAdapter) QRoute.api(IVasCommonAdapter.class)).isShowAdKey(), false);
        intent.putExtra("big_brother_source_key", "biz_src_jc_vip");
        return intent;
    }

    public static String handleDetail(Intent intent, Context context) {
        if (intent.hasExtra(VasWebviewConstants.KEY_EMOJI_IS_ORIGINAL)) {
            String num = Integer.toString(intent.getIntExtra(VasWebviewConstants.KEY_AUTHOR_ID, 0));
            if (!TextUtils.equals(VasWebviewConstants.INVALIDATE_AUTHOR_ID, num)) {
                if (intent.getBooleanExtra(VasWebviewConstants.KEY_EMOJI_IS_ORIGINAL, false)) {
                    return IndividuationUrlHelper.getMarketDetailUrl(context, IndividuationUrlHelper.UrlId.EMOJI_OPEN_AUTHOR_DETAIL, num, "");
                }
                return IndividuationUrlHelper.getMarketDetailUrl(context, IndividuationUrlHelper.UrlId.EMOJI_AUTHOR_DETAIL, num, "");
            }
        }
        return IndividuationUrlHelper.getMarketDetailUrl(context, IndividuationUrlHelper.UrlId.EMOJI_DETAIL, "[id]", "");
    }

    public static String handleEmojiUrl(Intent intent, Context context, long j3, String str) {
        boolean z16 = true;
        int intExtra = intent.getIntExtra("emojimall_src", 1);
        String handleHomePageType = handleHomePageType(intent, context, intExtra, str, getActivityType(j3));
        if (TextUtils.isEmpty(handleHomePageType)) {
            return "";
        }
        String str2 = "vip.gongneng.mobile.biaoqing.client_tab_store";
        if (isDetailType(intExtra)) {
            String stringExtra = intent.getStringExtra("emojimall_detail_id");
            if (TextUtils.isEmpty(stringExtra)) {
                z16 = false;
            } else {
                handleHomePageType = handleHomePageType.replace("[id]", stringExtra).replace("[type]", "view");
                str2 = "vip.gongneng.mobile.biaoqing.client_manager_item";
            }
            if (intExtra == 12) {
                handleHomePageType = handleHomePageType + "&location=dashang";
            }
        } else {
            str2 = getATag(intExtra, "vip.gongneng.mobile.biaoqing.client_tab_store");
        }
        if (z16) {
            String replace = handleHomePageType.replace("[adtag]", str2).replace("[systemInt]", Integer.toString(Build.VERSION.SDK_INT));
            logUrl(replace);
            String replaceEmojiType = replaceEmojiType(intent, replaceUpdateTime(replace, intent.getIntExtra(VasWebviewConstants.KEY_MALL_NEW_TIMESTAMP, -1)).replace("[updateFlag]", Boolean.valueOf(intent.getBooleanExtra(VasWebviewConstants.KEY_UPDATE_FLAG, false)).toString()).replace("[updateId]", "" + intent.getIntExtra(VasWebviewConstants.KEY_UPDATE_ID, 0)));
            if (intent.getBooleanExtra(VasWebviewConstants.KEY_TO_RECOMMEND_DRESSUP, false)) {
                replaceEmojiType = replaceEmojiType + "&to=recommend";
            }
            return addEntryParamToUrl(replaceEmojiType, 47);
        }
        return handleHomePageType;
    }

    public static String handleHomePageType(Intent intent, Context context, int i3, String str, int i16) {
        if (i16 == 1 || i16 == 3) {
            String home = getHome(intent, context);
            if (isDetailType(i3)) {
                return handleDetail(intent, context);
            }
            if (i3 == 11) {
                return IndividuationUrlHelper.getMarketDetailUrl(context, IndividuationUrlHelper.UrlId.SMALL_EMOJI_LIST, "[id]", "");
            }
            if (i3 == 5) {
                return IndividuationUrlHelper.getMarketDetailUrl(context, IndividuationUrlHelper.UrlId.EMOJI_AUTHOR_DETAIL, "[id]", "");
            }
            if (i3 == 6) {
                return handleMagicEmoAio();
            }
            if (i3 == 9) {
                return handleMagicPromotion(context, home);
            }
            if (i3 == 3) {
                return handleIndividCenter(intent, home);
            }
            return home;
        }
        return str;
    }

    public static String handleIndividCenter(Intent intent, String str) {
        String stringExtra = intent.getStringExtra("currentId");
        if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(str)) {
            if (str.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                return str + "&rec_id=" + stringExtra;
            }
            return str + "?rec_id=" + stringExtra;
        }
        return str;
    }

    public static String handleMagicEmoAio() {
        String marketUrl = IndividuationUrlHelper.getMarketUrl(MobileQQ.sMobileQQ.getApplicationContext(), IndividuationUrlHelper.UrlId.MAGIC_PLUS, "");
        if (!TextUtils.isEmpty(marketUrl)) {
            if (MobileQQ.sMobileQQ.peekAppRuntime() != null) {
                marketUrl = marketUrl.replace("[uin]", MobileQQ.sMobileQQ.peekAppRuntime().getAccount());
            }
            return marketUrl.replace("[client]", "androidQQ").replace("[version]", AppSetting.f99554n).replace("[platformId]", "2").replace("[device]", Build.DEVICE).replace("[system]", Build.VERSION.RELEASE);
        }
        return marketUrl;
    }

    public static String handleMagicPromotion(Context context, String str) {
        String string = context.getSharedPreferences("mobileQQ", 0).getString("magic_promotion_jump_url", "");
        if (!TextUtils.isEmpty(string)) {
            if (MobileQQ.sMobileQQ.peekAppRuntime() != null) {
                string = string.replace("[uin]", MobileQQ.sMobileQQ.peekAppRuntime().getAccount());
            }
            str = string.replace("[client]", "androidQQ").replace("[version]", AppSetting.f99554n).replace("[platformId]", "2").replace("[device]", Build.DEVICE).replace("[system]", Build.VERSION.RELEASE);
            string = str;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "promotion_jump_url:" + string);
        }
        return str;
    }

    public static Intent insertVasWbPluginToIntent(long j3, Intent intent) {
        if (intent == null) {
            return null;
        }
        if (j3 > 0) {
            return insertWbPlugin(intent, String.valueOf(j3));
        }
        return intent;
    }

    private static Intent insertWbPlugin(Intent intent, String str) {
        return ((IVasCommonAdapter) QRoute.api(IVasCommonAdapter.class)).insertWbPlugin(intent, str);
    }

    public static boolean isDetailType(int i3) {
        if (i3 != 8 && i3 != 4 && i3 != 12) {
            return false;
        }
        return true;
    }

    public static boolean isExternalStorageOK(Context context) {
        if (!Utils.B()) {
            QQToast.makeText(context, context.getString(R.string.h9v), 0).show();
            return false;
        }
        if (Utils.z() < 5242880) {
            QQToast.makeText(context, context.getString(R.string.h9w), 0).show();
            return false;
        }
        return true;
    }

    private static void logUrl(String str) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "loadHomePage:" + str);
        }
    }

    public static void openIndividuationIndex(Context context) {
        openIndividuationIndex(context, null);
    }

    public static void openQQBrowserActivity(Context context, String str, long j3, Intent intent, boolean z16, int i3) {
        long currentTimeMillis = System.currentTimeMillis();
        if (context == null) {
            return;
        }
        if (intent != null) {
            intent.setClass(context, ((IVasCommonAdapter) QRoute.api(IVasCommonAdapter.class)).getQQBrowserActivityClass());
        } else {
            intent = new Intent(context, ((IVasCommonAdapter) QRoute.api(IVasCommonAdapter.class)).getQQBrowserActivityClass());
        }
        String parseAsyncCookiesForVas = parseAsyncCookiesForVas(str, j3);
        if (!TextUtils.isEmpty(parseAsyncCookiesForVas)) {
            intent.putExtra("url", parseAsyncCookiesForVas);
        }
        intent.putExtra("business", j3);
        insertVasWbPluginToIntent(j3, intent);
        if (intent.getLongExtra("startOpenPageTime", 0L) <= 0) {
            intent.putExtra("startOpenPageTime", System.currentTimeMillis());
        }
        intent.putExtra(((IVasCommonAdapter) QRoute.api(IVasCommonAdapter.class)).isShowAdKey(), false);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "opeen vas webview cost: " + (System.currentTimeMillis() - currentTimeMillis));
        }
        if (z16 && (context instanceof Activity)) {
            ((Activity) context).startActivityForResult(intent, i3);
        } else {
            context.startActivity(intent);
        }
    }

    public static void openQQBrowserWithoutAD(Context context, String str, long j3, Intent intent, boolean z16, int i3) {
        if (context == null) {
            if (QLog.isDevelopLevel()) {
                QLog.d(TAG, 4, "open qqbrowser erro context");
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (j3 == 4194304 && !isExternalStorageOK(context)) {
            return;
        }
        Intent withoutADIntent = getWithoutADIntent(context, str, j3, intent);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "opeen vas webview cost: " + (System.currentTimeMillis() - currentTimeMillis));
        }
        if (z16 && (context instanceof Activity)) {
            ((Activity) context).startActivityForResult(withoutADIntent, i3);
        } else {
            context.startActivity(withoutADIntent);
        }
    }

    private static String parseAsyncCookiesForVas(String str, long j3) {
        ConcurrentHashMap<String, String> concurrentHashMap = mAsyncCookiesForVas;
        if (concurrentHashMap != null && concurrentHashMap.size() > 0 && "1".equalsIgnoreCase(mAsyncCookiesForVas.get(String.valueOf(j3))) && !TextUtils.isEmpty(str) && !str.contains("async_cookie=1")) {
            str = ((IVasCommonAdapter) QRoute.api(IVasCommonAdapter.class)).addParamToUrl(str, "async_cookie=1");
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 1, "now business id " + j3 + "  use async_cookie");
            }
        }
        return str;
    }

    @NotNull
    private static String parseReportEntryStr(int i3, String str) {
        return VasWebConstants.ENTRY_REPORT_PRE + new EntryReportParams(i3, str).base64Json();
    }

    private static String parseUrlParams(Context context, String str, long j3, Intent intent) {
        if (j3 == 2 || j3 == 4 || j3 == 8) {
            String handleEmojiUrl = handleEmojiUrl(intent, context, j3, str);
            if (intent.getBooleanExtra("is_small_emoji", false)) {
                handleEmojiUrl = handleEmojiUrl + "&emojiType=5";
            }
            String stringExtra = intent.getStringExtra("emoji_ids");
            if (stringExtra != null && !stringExtra.equals("")) {
                handleEmojiUrl = handleEmojiUrl + "&id=" + stringExtra;
            }
            if (intent.getBooleanExtra(((IVasCommonAdapter) QRoute.api(IVasCommonAdapter.class)).getKeyIsKandianEmoticon(), false)) {
                handleEmojiUrl = handleEmojiUrl + "&sceneType=1";
            }
            str = handleEmojiUrl;
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "small emoji url = " + str);
            }
        }
        return parseAsyncCookiesForVas(str, j3);
    }

    private static Intent putWebViewTitleStyle(Intent intent, String str) {
        return ((IVasCommonAdapter) QRoute.api(IVasCommonAdapter.class)).putWebViewTitleStyle(intent, str);
    }

    public static String replaceEmojiType(Intent intent, String str) {
        if (intent.hasExtra(((IVasCommonAdapter) QRoute.api(IVasCommonAdapter.class)).getKeyIsSmallEmoticon()) && intent.getBooleanExtra(((IVasCommonAdapter) QRoute.api(IVasCommonAdapter.class)).getKeyIsSmallEmoticon(), false)) {
            return str + "&emojiType=5";
        }
        return str;
    }

    @NotNull
    public static String replaceUpdateTime(String str, int i3) {
        if (i3 > 0) {
            return str.replace("[updateTime]", "" + i3);
        }
        return str.replace("[updateTime]", "0");
    }

    public static void reportCommercialDrainage(String str, String str2, String str3, int i3, String str4, String str5) {
        reportCommercialDrainage(str, str2, str3, 0, i3, 0, "", str4, str5, "", "", "", "", 0, 0, 0, 0);
    }

    public static void reportFontPerformance(String str, int i3, int i16, int i17, double d16, int i18) {
        DcReportUtil.c(null, "sendtdbank|b_sng_qqvip_vas_status_report|vas_font_performance", str + "|" + i3 + "|" + i16 + "|" + i17 + "|" + d16 + "|" + i18 + "|", true);
    }

    public static void reportVASTo00145(AppInterface appInterface, String str, String str2, String str3, String str4, String... strArr) {
        BaseQQAppInterface baseQQAppInterface;
        if (appInterface == null) {
            return;
        }
        if (appInterface instanceof BaseQQAppInterface) {
            baseQQAppInterface = (BaseQQAppInterface) appInterface;
        } else {
            baseQQAppInterface = null;
        }
        if (baseQQAppInterface == null) {
            return;
        }
        String currentAccountUin = appInterface.getCurrentAccountUin();
        BaseApplication app = appInterface.getApp();
        if (currentAccountUin != null && app != null) {
            int netWorkType = HttpUtil.getNetWorkType();
            if (netWorkType < 0 || netWorkType >= AppConstants.NET_TYPE_NAME.length) {
                netWorkType = 0;
            }
            String str5 = AppConstants.NET_TYPE_NAME[netWorkType];
            if (TextUtils.isEmpty(res)) {
                DisplayMetrics displayMetrics = app.getResources().getDisplayMetrics();
                res = displayMetrics.widthPixels + "*" + displayMetrics.heightPixels;
            }
            String[] strArr2 = new String[9];
            System.arraycopy(strArr, 0, strArr2, 0, Math.min(9, strArr.length));
            for (int i3 = 0; i3 < 9; i3++) {
                if (strArr2[i3] == null) {
                    strArr2[i3] = "";
                }
            }
            List<String> asList = Arrays.asList("1", currentAccountUin, ((IQQDcReporter) QRoute.api(IQQDcReporter.class)).getImei(app), "", "android", ThemeReporter.FROM_DIY, Build.VERSION.RELEASE, "3001", "3001013", "", "", str, "", "", "", str2, "", str3, "", "", str4, "", "", AppSetting.f99551k, "", "", "", "", "", "android", str5, res, "", strArr2[0], strArr2[1], strArr2[2], strArr2[3], strArr2[4], strArr2[5], strArr2[6], strArr2[7], strArr2[8]);
            ((IQQDcReporter) QRoute.api(IQQDcReporter.class)).reportDCEvent(baseQQAppInterface, "dc00145", asList);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "reportVASTo00145 paramList=" + asList.toString());
            }
        }
    }

    public static void reportVasStatus(String str, String str2, String str3, int i3, int i16) {
        reportVasStatus(str, str2, str3, i3, i16, 0, 0, "", "");
    }

    public static void reportVipKeywords(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        sb5.append("|");
        sb5.append(str2);
        sb5.append("|");
        sb5.append(str3);
        sb5.append("|");
        sb5.append(str4);
        sb5.append("|");
        sb5.append(str5);
        sb5.append("|");
        sb5.append(str6);
        sb5.append("|");
        sb5.append(str7);
        sb5.append("|");
        sb5.append(str8);
        sb5.append("|");
        sb5.append(str9);
        sb5.append("|");
        sb5.append(str10);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 4, "reportVipKeywords: " + sb5.toString());
        }
        DcReportUtil.c(null, "sendtdbank|b_sng_qqvip_key_word_grey_keyword_show_new|key_word_grey", sb5.toString(), true);
    }

    private static Intent setBrowserTitleStyle(Intent intent, String str) {
        return ((IVasCommonAdapter) QRoute.api(IVasCommonAdapter.class)).setBrowserTitleStyle(intent, str);
    }

    public static String addEntryParamToUrl(String str, int i3, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d("WebReportAdapter", 2, "vas_web_report_entry: " + i3 + "-->" + str);
        }
        if (i3 == 0) {
            return str;
        }
        String parseReportEntryStr = parseReportEntryStr(i3, str2);
        if (TextUtils.isEmpty(parseReportEntryStr)) {
            return str;
        }
        if (str.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
            return str + parseReportEntryStr;
        }
        return str + parseReportEntryStr.replaceFirst(ContainerUtils.FIELD_DELIMITER, QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
    }

    public static void openIndividuationIndex(Context context, String str) {
        String marketUrl = IndividuationUrlHelper.getMarketUrl(context, IndividuationUrlHelper.UrlId.INDIVIDUATION_MAIN_PAGE, "");
        if (str != null) {
            marketUrl = marketUrl + str;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "individuation main page url = " + marketUrl);
        }
        QLog.d(TAG, 2, "individuation --------------open GXH " + marketUrl);
        String configUrl = getConfigUrl(marketUrl);
        if (TextUtils.isEmpty(configUrl)) {
            configUrl = getKuiklyUrl(marketUrl);
        }
        if (!TextUtils.isEmpty(configUrl)) {
            if (configUrl.startsWith("http")) {
                ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openBrowser(context, configUrl);
                return;
            } else {
                ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openKuiklySchema(context, configUrl, null);
                return;
            }
        }
        if (VasNormalToggle.VAS_FEATURE_DRESSUP_HIPPY.isEnable(true)) {
            VasUtil.getTempApi().openGxhHippyPage(marketUrl);
            if (MobileQQ.sMobileQQ.peekAppRuntime() != null) {
                VasUtil.getTempApi().fetchHippyDTReportIndex(marketUrl, MobileQQ.sMobileQQ.peekAppRuntime());
                return;
            }
            return;
        }
        if (VasUtil.getTempApi().isCanOpenGxhHippyPage() && !AppSetting.o(context)) {
            VasUtil.getTempApi().openGxhHippyPage(marketUrl);
            if (MobileQQ.sMobileQQ.peekAppRuntime() != null) {
                VasUtil.getTempApi().fetchHippyDTReportIndex(marketUrl, MobileQQ.sMobileQQ.peekAppRuntime());
                return;
            }
            return;
        }
        Intent intent = new Intent(context, ((IVasCommonAdapter) QRoute.api(IVasCommonAdapter.class)).getQQBrowserActivityClass());
        intent.putExtra("startOpenPageTime", System.currentTimeMillis());
        if (MobileQQ.sMobileQQ.peekAppRuntime() != null) {
            intent.putExtra("uin", MobileQQ.sMobileQQ.peekAppRuntime().getAccount());
        }
        intent.putExtra("hide_operation_bar", true);
        intent.putExtra("hide_more_button", true);
        intent.putExtra("individuation_url_type", VasWebviewConstants.REPORT_FROM_INDIVIDUATION_SET);
        if (((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).isEnable()) {
            ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openBrowser(context, marketUrl);
        } else {
            openQQBrowserWithoutAD(context, marketUrl, 1048576L, intent, false, -1);
        }
        ((IVasCommonAdapter) QRoute.api(IVasCommonAdapter.class)).startWebSoRequest(marketUrl);
    }

    public static void reportCommercialDrainage(String str, String str2, String str3, int i3, int i16, int i17, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i18, int i19, int i26, int i27) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        reportCommercialDrainage(peekAppRuntime != null ? peekAppRuntime.getAccount() : null, str, str2, str3, i3, i16, i17, str4, str5, str6, str7, str8, str9, str10, i18, i19, i26, i27);
    }

    public static void reportVasStatus(String str, String str2, String str3, int i3, int i16, int i17, int i18, String str4, String str5) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        sb5.append("|");
        sb5.append(str2);
        sb5.append("|");
        if (TextUtils.isEmpty(str3)) {
            str3 = "0";
        }
        sb5.append(str3);
        sb5.append("|");
        sb5.append(i3);
        sb5.append("|");
        sb5.append(i16);
        sb5.append("|");
        sb5.append(i17);
        sb5.append("|");
        sb5.append(i18);
        sb5.append("|");
        sb5.append(str4);
        sb5.append("|");
        sb5.append(str5);
        DcReportUtil.c(null, "sendtdbank|b_sng_qqvip_vas_status_report|vas_status_report", sb5.toString(), true);
    }

    public static void reportCommercialDrainage(String str, String str2, String str3, String str4, int i3, int i16, int i17, String str5, String str6, String str7, String str8, String str9, String str10, String str11, int i18, int i19, int i26, int i27) {
        String str12;
        if (TextUtils.isEmpty(str5)) {
            try {
                String str13 = MobileQQ.QQ_PACKAGE_NAME;
                int systemNetwork = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
                if (systemNetwork != -1) {
                    String[] strArr = AppConstants.NET_TYPE_NAME;
                    if (systemNetwork < strArr.length) {
                        str12 = strArr[systemNetwork];
                    }
                }
            } catch (Exception e16) {
                QLog.e(TAG, 1, "NetworkUtil.getSystemNetwork error", e16);
            }
            str12 = "UNKNOWN";
        } else {
            str12 = str5;
        }
        DcReportUtil.c(null, "sendtdbank|b_sng_qqvip_vas_status_report|vas_personal_data_hour", str + "|" + str2 + "|" + str3 + "|" + str4 + "|" + (i3 == 0 ? 1 : i3) + "|" + i16 + "|" + i17 + "|" + str12 + "|" + str6 + "|" + str7 + "|" + str8 + "|" + str9 + "|" + str10 + "|" + str11 + "|" + i18 + "|" + i19 + "|" + i26 + "|" + i27 + "|", true);
    }

    public static void reportCommercialDrainage(String str, String str2, String str3, String str4, int i3, int i16, int i17, String str5, String str6, String str7) {
        String str8;
        String str9;
        if (TextUtils.isEmpty(str5)) {
            try {
                String str10 = MobileQQ.QQ_PACKAGE_NAME;
                int systemNetwork = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
                if (systemNetwork != -1) {
                    String[] strArr = AppConstants.NET_TYPE_NAME;
                    if (systemNetwork < strArr.length) {
                        str9 = strArr[systemNetwork];
                        str8 = str9;
                    }
                }
                str9 = "UNKNOWN";
                str8 = str9;
            } catch (Exception e16) {
                QLog.e(TAG, 1, "NetworkUtil.getSystemNetwork error", e16);
                str8 = "UNKNOWN";
            }
        } else {
            str8 = str5;
        }
        reportCommercialDrainage(str, str2, str3, str4, i3 == 0 ? 1 : i3, i16, i17, str8, str6, str7, "", "", "", "", 0, 0, 0, 0);
    }
}
