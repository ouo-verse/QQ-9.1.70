package com.tencent.mobileqq.app;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.multilanguage.MultiLanguageEngine;
import com.tencent.mobileqq.app.utils.PropertiesUtils;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Locale;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.BuiltInServlet;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

/* compiled from: P */
/* loaded from: classes11.dex */
public class LocaleManager {
    static IPatchRedirector $redirector_ = null;
    public static final int LANG_ID_ENGLISH = 1033;
    public static final int LANG_ID_SIMPLIFIED_CHINESE = 2052;
    public static final int MOBILE_COUNTRY_CODE_CN_INT = 460;
    public static final String MOBILE_COUNTRY_CODE_CN_STR = "CN";
    private static final SparseArray<Locale> S_LOCALE_ID_HOLDER;
    private static final String TAG = "LocaleManager";
    public static boolean isConfShowEntrance;
    private static boolean isLocaleUpdatedByUser;
    private static int sCurrentLocaleId;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41977);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        isConfShowEntrance = false;
        SparseArray<Locale> sparseArray = new SparseArray<>();
        S_LOCALE_ID_HOLDER = sparseArray;
        sparseArray.put(2052, Locale.SIMPLIFIED_CHINESE);
        sparseArray.put(1033, Locale.US);
        isLocaleUpdatedByUser = false;
        sCurrentLocaleId = 2052;
    }

    public LocaleManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static int getLocaleId() {
        return sCurrentLocaleId;
    }

    public static String getLocaleLanName(int i3) {
        if (i3 == 2052) {
            return HardCodeUtil.qqStr(R.string.irs);
        }
        if (i3 == 1033) {
            return HardCodeUtil.qqStr(R.string.irr);
        }
        return "";
    }

    public static void initializeAppLocale(Context context) {
        printLog("initializeAppLocale, sCurrentLocaleId:" + sCurrentLocaleId);
        if (sCurrentLocaleId == 0) {
            String read = PropertiesUtils.read(context, PropertiesUtils.KEY_LOCALE_ID, "0");
            printLog("initializeAppLocale, localeIdStr:" + read);
            if ("0".equals(read)) {
                sCurrentLocaleId = 2052;
                PropertiesUtils.save(context, PropertiesUtils.KEY_LOCALE_ID, String.valueOf(2052));
            } else {
                sCurrentLocaleId = Integer.parseInt(read.trim());
            }
            String read2 = PropertiesUtils.read(context, PropertiesUtils.KEY_LOCALE_LAST, "0");
            boolean z16 = true;
            if ("0".equals(read2)) {
                if (sCurrentLocaleId == 2052) {
                    z16 = false;
                }
                isLocaleUpdatedByUser = z16;
            } else {
                if (Integer.parseInt(read2) == sCurrentLocaleId) {
                    z16 = false;
                }
                isLocaleUpdatedByUser = z16;
            }
            PropertiesUtils.save(context, PropertiesUtils.KEY_LOCALE_LAST, String.valueOf(sCurrentLocaleId));
        }
        printLog("initializeAppLocale, HwEngine.localeId:" + sCurrentLocaleId);
        int i3 = sCurrentLocaleId;
        HwEngine.localeId = i3;
        AppActivity.localeId = i3;
        mqq.app.BaseActivity.localeId = sCurrentLocaleId;
    }

    public static boolean isLocaleCN() {
        if (sCurrentLocaleId == 2052) {
            return true;
        }
        return false;
    }

    public static boolean isLocaleENG() {
        if (sCurrentLocaleId == 1033) {
            return true;
        }
        return false;
    }

    public static boolean isLocaleEqual(Locale locale, Locale locale2) {
        if (locale == null || locale2 == null) {
            return false;
        }
        boolean equals = locale.getLanguage().equals(locale2.getLanguage());
        boolean equals2 = locale.getCountry().equals(locale2.getCountry());
        if (!equals || !equals2) {
            return false;
        }
        return true;
    }

    public static boolean isLocaleUpdatedByUser() {
        return isLocaleUpdatedByUser;
    }

    public static void printLog(String str) {
        QLog.d(TAG, 1, str);
    }

    public static Locale queryCurrentLocale() {
        Locale queryLocaleById = queryLocaleById(sCurrentLocaleId);
        if (queryLocaleById == null) {
            queryLocaleById = Locale.SIMPLIFIED_CHINESE;
        }
        printLog("queryCurrentLocale, currentLocale:" + queryLocaleById.toString());
        return queryLocaleById;
    }

    private static Locale queryLocaleById(int i3) {
        return S_LOCALE_ID_HOLDER.get(i3);
    }

    private static int queryLocaleIdByInstance(Locale locale) {
        int i3 = 0;
        while (true) {
            SparseArray<Locale> sparseArray = S_LOCALE_ID_HOLDER;
            if (i3 >= sparseArray.size()) {
                return 0;
            }
            if (isLocaleEqual(locale, sparseArray.valueAt(i3))) {
                return sparseArray.keyAt(i3);
            }
            i3++;
        }
    }

    public static Locale querySystemLocale() {
        Locale locale;
        LocaleList localeList;
        if (Build.VERSION.SDK_INT >= 24) {
            localeList = LocaleList.getDefault();
            locale = localeList.get(0);
        } else {
            locale = Locale.getDefault();
        }
        if (locale != null) {
            printLog("querySystemLocale: " + locale.toString());
        }
        return locale;
    }

    private static int queryUserPreferLocaleId(Context context) {
        int queryLocaleIdByInstance = queryLocaleIdByInstance(querySystemLocale());
        if (queryLocaleIdByInstance == 0) {
            String tryReadSimCardCountryCode = tryReadSimCardCountryCode(context);
            if (MOBILE_COUNTRY_CODE_CN_STR.equalsIgnoreCase(tryReadSimCardCountryCode) || TextUtils.isEmpty(tryReadSimCardCountryCode)) {
                return 2052;
            }
            return 1033;
        }
        return queryLocaleIdByInstance;
    }

    public static void restartOnLocaleUpdate(Context context) {
        List<ActivityManager.RunningAppProcessInfo> list;
        ActivityManager activityManager = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        if (activityManager != null) {
            list = SystemMethodProxy.getRunningAppProcesses(activityManager);
        } else {
            list = null;
        }
        if (list == null) {
            return;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : list) {
            if (!"com.tencent.mobileqq".equals(runningAppProcessInfo.processName)) {
                SystemMethodProxy.killProcess(runningAppProcessInfo.pid);
                printLog("process killed on locale update, pid:" + runningAppProcessInfo.pid + ", name:" + runningAppProcessInfo.processName);
            }
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo2 : SystemMethodProxy.getRunningAppProcesses(activityManager)) {
            SystemMethodProxy.killProcess(runningAppProcessInfo2.pid);
            printLog("process killed on locale update, pid:" + runningAppProcessInfo2.pid + ", name:" + runningAppProcessInfo2.processName);
        }
    }

    public static void setLocale(Context context, int i3) {
        printLog("setLocale , localeId = " + i3);
        PropertiesUtils.save(context, PropertiesUtils.KEY_LOCALE_LAST, String.valueOf(sCurrentLocaleId));
        PropertiesUtils.save(context, PropertiesUtils.KEY_LOCALE_ID, String.valueOf(i3));
        sCurrentLocaleId = i3;
        HwEngine.localeId = i3;
        AppActivity.localeId = i3;
        mqq.app.BaseActivity.localeId = sCurrentLocaleId;
        updateMsfLocaleId(context, sCurrentLocaleId);
        tryApplyLocale(context, queryLocaleById(i3));
        if (isLocaleENG()) {
            MultiLanguageEngine.getInstance().checkEnglishLangPkg(context);
        }
    }

    public static void tryApplyLocale(Context context, Locale locale) {
        if (context != null && locale != null) {
            AppActivity.locale = locale;
            mqq.app.BaseActivity.locale = locale;
            PluginProxyActivity.locale = locale;
            Resources resources = context.getResources();
            Configuration configuration = resources.getConfiguration();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            displayMetrics.setTo(resources.getDisplayMetrics());
            if (Build.VERSION.SDK_INT >= 24) {
                printLog("rconf locale set1:" + locale.toString());
                LocaleList localeList = new LocaleList(locale);
                LocaleList.setDefault(localeList);
                configuration.setLocales(localeList);
            } else {
                printLog("rconf locale set2:" + locale.toString());
                Locale.setDefault(locale);
                configuration.locale = locale;
            }
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
            resources.getDisplayMetrics().setTo(displayMetrics);
        }
    }

    public static void tryApplyLocaleIfNeeded(Context context) {
        if (context != null) {
            Resources resources = context.getResources();
            if (resources != null) {
                Configuration configuration = resources.getConfiguration();
                printLog("tryApplyLocaleIfNeeded, resLocale:" + configuration.locale.toString());
                if (!isLocaleEqual(queryCurrentLocale(), configuration.locale)) {
                    printLog("tryApplyLocaleIfNeeded, called tryApplyLocale");
                    return;
                }
                return;
            }
            return;
        }
        printLog("called tryApplyLocaleIfNeeded, context null");
    }

    public static String tryReadSimCardCountryCode(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            String networkCountryIso = telephonyManager.getNetworkCountryIso();
            printLog("telephonyManager CountryCode:" + networkCountryIso);
            return networkCountryIso;
        }
        printLog("tryReadSimCardCountryCode telephonyManager null");
        return "";
    }

    private static void updateMsfLocaleId(Context context, int i3) {
        try {
            SettingCloneUtil.writeValueForInt(context, null, null, AppConstants.QQSETTING_LOCALE_ID, i3);
            printLog("updateMsfLocaleId, localeId:" + i3 + ", time:" + System.currentTimeMillis());
            for (int i16 = 0; i16 < 3 && SettingCloneUtil.readValueForInt(context, null, null, AppConstants.QQSETTING_LOCALE_ID, 0) != i3; i16++) {
                SettingCloneUtil.writeValueForInt(context, null, null, AppConstants.QQSETTING_LOCALE_ID, i3);
                printLog("updateMsfLocaleId, write localeId:" + i3 + ", time:" + System.currentTimeMillis());
                LockMethodProxy.sleep(10L);
            }
            if (SettingCloneUtil.readValueForInt(context, null, null, AppConstants.QQSETTING_LOCALE_ID, 0) != i3) {
                printLog("updateMsfLocaleId, write failed, time:" + System.currentTimeMillis());
            }
            AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
            NewIntent newIntent = new NewIntent(context, BuiltInServlet.class);
            newIntent.putExtra("action", Constants.Action.ACTION_MSF_UPDATE_LOCALE_ID);
            newIntent.putExtra("localeId", i3);
            waitAppRuntime.startServlet(newIntent);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "updateMsfLocaleId error!", e16);
        }
    }
}
