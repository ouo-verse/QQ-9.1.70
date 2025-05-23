package cooperation.qwallet.plugin.impl;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.ResultReceiver;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.ark.ark;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.scroll.HippyHeaderListViewController;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.base.a;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.c0.j;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.o;
import com.tencent.mobileqq.qrscan.k;
import com.tencent.mobileqq.qwallet.IQWalletApi;
import com.tencent.mobileqq.qwallet.api.INewQWalletApi;
import com.tencent.mobileqq.qwallet.api.IQWalletKuiklyApi;
import com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi;
import com.tencent.mobileqq.qwallet.hb.IQWalletHbApi;
import com.tencent.mobileqq.qwallet.impl.TenpayJumpActivity;
import com.tencent.mobileqq.qwallet.impl.b;
import com.tencent.mobileqq.qwallet.preload.IPreloadImgApi;
import com.tencent.mobileqq.qwallet.preload.IPreloadResource;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import com.tencent.mobileqq.qwallet.utils.g;
import com.tencent.mobileqq.qwallet.utils.h;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.AnimationView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.smtt.sdk.WebBackForwardList;
import com.tencent.smtt.sdk.WebView;
import com.tenpay.proxy.dlg.location.QbAddrData;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qwallet.plugin.IActivity;
import cooperation.qwallet.plugin.IQWalletHelper;
import cooperation.qwallet.plugin.PatternLockUtils;
import cooperation.qwallet.plugin.QWalletPayBridge;
import cooperation.qwallet.plugin.ipc.QWalletResultReceiver;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;
import qk2.F2FRedPackConfig;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QWalletHelperImpl implements IQWalletHelper {
    private static final String APPINFO_MATCH_PARAM = "qqwallet_appinfo=";
    public static final String FILE_PRECONNECT_NAME = "pre_connect";
    public static final String KEY_PRECONNECT_LAST_TIME = "pre_connect_last_time";
    private static final String TAG = "QWalletHelperImpl";
    public static final String TYPE_PRECONNECT_M = "type_mqq_and_myun";
    public static long lastTime;
    public static String mQWalletExternalPath;
    public static String mQWalletInternalPath;
    private static long qLaunchTime;
    public static Set<String> sBuiltInActPayPkgs;
    private static HashMap<String, String> sPublicAccWhiteMap;

    static {
        HashSet hashSet = new HashSet();
        sBuiltInActPayPkgs = hashSet;
        hashSet.add(TbsConfig.APP_QB);
        sPublicAccWhiteMap = null;
        lastTime = -1L;
        mQWalletExternalPath = "";
        mQWalletInternalPath = "";
    }

    private static void addExtraForQvipPayWalletAct(Context context, Intent intent, boolean z16) {
        if (intent == null) {
            return;
        }
        String c16 = a.c();
        intent.putExtra(IQWalletHelper.QWALLET_EXTRA_KEY_MQQ_RECEIVER, QWalletResultReceiver.getInstance());
        boolean isPatternLockOpened = PatternLockUtils.isPatternLockOpened(context, c16);
        if (isPatternLockOpened) {
            intent.putExtra(IActivity.PARAM_IS_USE_QWALLET_PATTERN_LOCK, true);
            intent.putExtra(IActivity.PARAM_QWALLET_PLOCK_BG_INTVERAL_TIME, PatternLockUtils.getForgroundIntervalTime(context, c16));
        }
        QLog.d("Q.qwallet.pattern.helper", 2, "addExtraForQvipPayWalletAct: lockOpened=" + isPatternLockOpened + ", isNeedCheckPWD=" + z16);
        intent.putExtra(IQWalletHelper.QWALLET_HOMEPAGE_IS_NEED_OPEN_PATTERN_LOCK, z16);
    }

    public static boolean compare(String str, String str2) {
        int length;
        char[] cArr = {EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET, 'B', 'C', 'D', 'E', 'F'};
        char[] cArr2 = {'a', 'b', 'c', 'd', 'e', 'f'};
        if (str != null && str2 != null) {
            char[] charArray = str.toCharArray();
            char[] charArray2 = str2.toCharArray();
            if (charArray == null || charArray2 == null || (length = charArray.length) != charArray2.length) {
                return false;
            }
            for (int i3 = 0; i3 < length; i3++) {
                if (charArray2[i3] != charArray[i3]) {
                    for (int i16 = 0; i16 < 6; i16++) {
                        if (cArr2[i16] == charArray2[i3] && cArr[i16] != charArray[i3]) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    private static String getAppInfoByUrl(String str) {
        int indexOf;
        if (!TextUtils.isEmpty(str) && (indexOf = str.toLowerCase().indexOf(APPINFO_MATCH_PARAM)) != -1) {
            int i3 = indexOf + 17;
            int indexOf2 = str.indexOf(38, i3);
            if (indexOf2 == -1) {
                indexOf2 = str.length();
            }
            return str.substring(i3, indexOf2);
        }
        return "";
    }

    @Nullable
    public static AppRuntime getAppRuntime() {
        if (((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).isSwitchOn(IQWalletUnitedConfigApi.QWALLET_PEEK_RUNTIME_SWITCH, true)) {
            return MobileQQ.sMobileQQ.peekAppRuntime();
        }
        return MobileQQ.sMobileQQ.waitAppRuntime();
    }

    public static long getLastUpdateToopMemberNumTime(String str) {
        return BaseApplication.getContext().getSharedPreferences(IQWalletHelper.PREF_NAME_MULTI_PROCESS, 4).getLong(str, 0L);
    }

    public static int getProcessPid(Context context, String str) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        ActivityManager activityManager = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        if (activityManager != null && (runningAppProcesses = SystemMethodProxy.getRunningAppProcesses(activityManager)) != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (str.compareTo(runningAppProcessInfo.processName) == 0) {
                    return runningAppProcessInfo.pid;
                }
            }
            return -1;
        }
        return -1;
    }

    public static boolean getSyncPatternLockState(Context context, String str) {
        boolean z16 = context.getSharedPreferences("qwallet_patternlock", 4).getBoolean("is_need_sync" + str, true);
        if (QLog.isColorLevel()) {
            QLog.d(IQWalletHelper.TAG_WALLET_PAY, 2, "getSyncPatternLockState.uin=" + str + ",isNeedSync=" + z16);
        }
        return z16;
    }

    private static void gotoQWalletAct(QBaseActivity qBaseActivity, AppRuntime appRuntime, int i3) {
        if (qBaseActivity != null && appRuntime != null) {
            Intent intent = new Intent();
            intent.putExtra(IQWalletHelper.QWALLET_LOAD_BEING_TIME, qLaunchTime);
            intent.putExtra(IQWalletHelper.QWALLET_HOME_CHANNEL_FROM, i3);
            intent.putExtra("big_brother_source_key", "biz_src_zf_qianbao");
            addExtraForQvipPayWalletAct(qBaseActivity, intent, true);
            ((INewQWalletApi) QRoute.api(INewQWalletApi.class)).launchHomeFragment(qBaseActivity, intent, i3);
        }
    }

    private static boolean isAppPay(Bundle bundle) {
        int i3 = bundle.getInt(PayProxy.Source.PAY_REQUEST_PAY_COME_FROM);
        int i16 = bundle.getInt(QWalletPayBridge.Key.PAY_INVOKER_ID, -1);
        if (((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).isSwitchOn(IQWalletUnitedConfigApi.QWALLET_APP_PAY_DISABLE_LAUNCH_WITH_ACTIVITY, false) || !QWalletPayBridge.isPayInvokeId(i16) || i3 != 4) {
            return false;
        }
        return true;
    }

    private static boolean isCurrTaskNotValid(Activity activity) {
        int i3;
        try {
        } catch (Throwable th5) {
            QLog.d(TAG, 2, "error msg in qqpay-impl module: ", th5);
        }
        if (MobileQQ.sMobileQQ.peekAppRuntime() instanceof BaseQQAppInterface) {
            boolean isSplashNotExist = ((IQWalletTemp) QRoute.api(IQWalletTemp.class)).isSplashNotExist();
            if (QLog.isColorLevel()) {
                QLog.i(QWalletPayBridge.TAG, 2, "isCurrTaskNotValid, isSplashNotExist=" + isSplashNotExist);
            }
            return isSplashNotExist;
        }
        List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) activity.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).getRunningTasks(1);
        if (runningTasks != null && runningTasks.size() > 0 && runningTasks.get(0) != null) {
            i3 = runningTasks.get(0).numActivities;
            if (i3 >= 2) {
                return false;
            }
        }
        return true;
    }

    private static boolean isForePay(Bundle bundle) {
        if (bundle == null || bundle.getInt("launch_type", 0) != 0) {
            return false;
        }
        return true;
    }

    private static boolean isFromDiffTaskAffinity(Activity activity) {
        ComponentName componentName;
        ComponentName componentName2;
        int i3;
        try {
            List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) activity.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).getRunningTasks(1);
            if (runningTasks != null && runningTasks.size() > 0 && runningTasks.get(0) != null) {
                componentName = runningTasks.get(0).baseActivity;
                if (componentName != null && runningTasks.get(0).id == activity.getTaskId()) {
                    componentName2 = runningTasks.get(0).baseActivity;
                    String str = activity.getPackageManager().getActivityInfo(componentName2, 128).taskAffinity;
                    String str2 = BaseApplication.getContext().getApplicationInfo().taskAffinity;
                    if (QLog.isColorLevel()) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("isFromDiffTaskAffinity, baseTask=");
                        sb5.append(str2);
                        sb5.append("reqTask=");
                        sb5.append(str);
                        sb5.append(", numA:");
                        i3 = runningTasks.get(0).numActivities;
                        sb5.append(i3);
                        QLog.i(QWalletPayBridge.TAG, 2, sb5.toString());
                    }
                    if (str2.equals(str)) {
                        return false;
                    }
                } else {
                    return true;
                }
            }
        } catch (Throwable th5) {
            QLog.e(QWalletPayBridge.TAG, 2, th5.getMessage());
        }
        return true;
    }

    private static boolean isFromOnlyActScene(Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        int i3 = bundle.getInt(PayProxy.Source.PAY_REQUEST_PAY_COME_FROM, 0);
        if (i3 != 9 && i3 != 11) {
            if (i3 != 4) {
                return false;
            }
            String string = bundle.getString("packageName");
            if (TextUtils.isEmpty(string)) {
                return false;
            }
            return sBuiltInActPayPkgs.contains(string);
        }
        return true;
    }

    private static boolean isFromSpecifyModel() {
        try {
            String str = Build.MANUFACTURER;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.equals("360");
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "error msg in qqpay-impl module: ", th5);
            return false;
        }
    }

    private static boolean isMidasLogic(Bundle bundle) {
        return QWalletPayBridge.isMidasInvokerId(bundle.getInt(QWalletPayBridge.Key.PAY_INVOKER_ID, -1));
    }

    public static boolean isNeedPreConnect(Context context, String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        SharedPreferences sharedPreferences = context.getSharedPreferences("pre_connect" + str, 4);
        if (TimeUnit.MILLISECONDS.toSeconds(currentTimeMillis - sharedPreferences.getLong("pre_connect_last_time" + str2, 0L)) < 120000) {
            return false;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putLong("pre_connect_last_time" + str2, currentTimeMillis);
        edit.commit();
        return true;
    }

    public static boolean isNeedUpdateTroopMemberNum(String str) {
        if (TextUtils.isEmpty(str) || NetConnInfoCenter.getServerTimeMillis() - getLastUpdateToopMemberNumTime(str) < 1800000) {
            return false;
        }
        return true;
    }

    public static boolean isPhoneRooted() {
        String[] strArr = {"/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/"};
        for (int i3 = 0; i3 < 5; i3++) {
            try {
                if (new File(strArr[i3] + "su").exists()) {
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static boolean isValidUrl(String str) {
        try {
            int indexOf = str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER) + 1;
            int i3 = indexOf + 2;
            String substring = str.substring(0, indexOf - 1);
            int indexOf2 = str.indexOf("#") + 1;
            String substring2 = str.substring(i3, indexOf2 - 1);
            String substring3 = str.substring(indexOf2, str.length());
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(substring);
            stringBuffer.append("#");
            stringBuffer.append(substring3);
            stringBuffer.append("akT!Y#9W");
            String substring4 = QWalletHelperDelegate.hexdigest(stringBuffer.toString()).substring(0, 4);
            boolean equals = substring4.equals(substring2);
            if (!equals) {
                return compare(substring4, substring2);
            }
            return equals;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "error msg in qqpay-impl module: ", e16);
            return false;
        }
    }

    public static void launchPayBridgeService(Context context, AppRuntime appRuntime, Bundle bundle) {
        String str;
        if (context != null && appRuntime != null && bundle != null) {
            Intent intent = new Intent(MobileQQ.sMobileQQ, ((INewQWalletApi) QRoute.api(INewQWalletApi.class)).getQWalletToolServiceClass());
            intent.putExtra(IQWalletHelper.QWALLET_EXTRA_KEY_PAY_BUNDLE, bundle);
            intent.putExtra(IQWalletHelper.QWALLET_EXTRA_KEY_PAY_TIME_START, System.currentTimeMillis());
            intent.putExtra("uin", appRuntime.getCurrentAccountUin());
            boolean z16 = true;
            intent.putExtra(IActivity.PARAM_DISABLE_PATTERN_LOCK, true);
            String str2 = "";
            if (!bundle.containsKey("entry")) {
                str = "";
            } else {
                str = (String) bundle.get("entry");
            }
            if (bundle.containsKey("viewParam")) {
                str2 = (String) bundle.get("viewParam");
            }
            if (!"2".equals(str) || !"10".equals(str2)) {
                z16 = false;
            }
            addExtraForQvipPayWalletAct(context, intent, z16);
            boolean isLaunchPayPluginAct = ((IQWalletHelper) QRoute.api(IQWalletHelper.class)).isLaunchPayPluginAct(bundle, context);
            if (QLog.isColorLevel()) {
                QLog.i(QWalletPayBridge.TAG, 2, "isLaunchPayPluginAct =" + isLaunchPayPluginAct);
            }
            if (isLaunchPayPluginAct) {
                ((INewQWalletApi) QRoute.api(INewQWalletApi.class)).launchQVipPayBridgeFragment(context, intent);
            } else {
                context.startService(intent);
            }
        }
    }

    public static JSONObject loadUnifiedConfig(Context context) {
        boolean z16;
        JSONObject jSONObject = null;
        if (context != null) {
            byte[] readFile = FileUtils.readFile(context.getFilesDir() + "/qb_tenpay_unified_config");
            if (readFile != null) {
                String str = new String(readFile);
                z16 = true;
                try {
                    jSONObject = new JSONObject(str);
                } catch (JSONException e16) {
                    QLog.e(TAG, 1, "error msg in qqpay-impl module: ", e16);
                }
            } else {
                z16 = false;
            }
            if (!z16) {
                g.s("qpay_unified_config_ver");
            }
        }
        return jSONObject;
    }

    public static void saveLastUpdateToopMemberNumTime(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        BaseApplication.getContext().getSharedPreferences(IQWalletHelper.PREF_NAME_MULTI_PROCESS, 4).edit().putLong(str, NetConnInfoCenter.getServerTimeMillis());
    }

    public static void startActivity(Context context, Intent intent, String str) {
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(context, str);
        activityURIRequest.extra().putAll(intent.getExtras());
        activityURIRequest.setFlags(intent.getFlags());
        QRoute.startUri(activityURIRequest, (o) null);
    }

    public static void startActivityForResult(Context context, Intent intent, String str, int i3) {
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(context, str);
        activityURIRequest.extra().putAll(intent.getExtras());
        activityURIRequest.setFlags(intent.getFlags());
        activityURIRequest.setRequestCode(i3);
        QRoute.startUri(activityURIRequest, (o) null);
    }

    @Override // cooperation.qwallet.plugin.IQWalletHelper
    public void clearInstance(BaseQQAppInterface baseQQAppInterface) {
        g.s("qwallet_banned_user_info");
        g.s("qwallet_special_key_info");
        ((IQWalletTemp) QRoute.api(IQWalletTemp.class)).reset();
        QWalletResultReceiver.clear();
        ((IPreloadImgApi) QRoute.api(IPreloadImgApi.class)).onDestory();
        ((IQWalletHbApi) QRoute.api(IQWalletHbApi.class)).getCustomizeStrategyFactory().onDestroy();
        PayLogicImpl.clearCache();
        lastTime = -1L;
        ((IQWalletKuiklyApi) QRoute.api(IQWalletKuiklyApi.class)).clearFinancialOAuthCache();
    }

    @Override // cooperation.qwallet.plugin.IQWalletHelper
    public void doF2FRedpack(AppInterface appInterface, Activity activity, String str) {
        if (appInterface != null && activity != null && !TextUtils.isEmpty(str)) {
            if (((F2FRedPackConfig) ((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).getConfig(IQWalletUnitedConfigApi.QWALLET_F2F_HB_CODE_CONFIG, F2FRedPackConfig.a())).b() && !isValidUrl(str)) {
                Intent payBridgeIntent = ((IQWalletApi) QRoute.api(IQWalletApi.class)).getPayBridgeIntent(activity);
                payBridgeIntent.putExtra("pay_requestcode", 200);
                activity.startActivity(payBridgeIntent);
                return;
            }
            gotoF2FRedpack(appInterface.getCurrentAccountUin(), appInterface.getCurrentNickname(), activity, str, false);
        }
    }

    @Override // cooperation.qwallet.plugin.IQWalletHelper
    public void doQRCodePay(AppInterface appInterface, Activity activity, String str, k kVar) {
        int indexOf;
        String str2;
        if (activity == null || TextUtils.isEmpty(str) || (indexOf = str.indexOf("://qpay.qq.com/qr/")) == -1) {
            return;
        }
        String substring = str.substring(indexOf + 18);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("tokenId", substring);
            jSONObject.put(PayProxy.Source.PAY_REQUEST_PAY_COME_FROM, "3");
            str2 = jSONObject.toString();
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "error msg in qqpay-impl module: ", e16);
            str2 = null;
        }
        if (str2 == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(PayProxy.Source.PAY_CALLBACK_SN_EXTRA_KEY, "0");
        bundle.putString(PayProxy.Source.PAY_JSON_EXTRA_KEY, str2);
        bundle.putInt(PayProxy.Source.PAY_TYPE_EXTRA_KEY, 8);
        bundle.putString(PayProxy.Source.PAY_URL_APPINFO_EXTRA_KEY, "appid#3155944709|bargainor_id#|channel#offline");
        bundle.putString("payparmas_h5_url", str);
        final WeakReference weakReference = new WeakReference(kVar);
        ((IQWalletTemp) QRoute.api(IQWalletTemp.class)).newPay(appInterface, activity, new ResultReceiver(ThreadManagerV2.getUIHandlerV2()) { // from class: cooperation.qwallet.plugin.impl.QWalletHelperImpl.2
            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int i3, Bundle bundle2) {
                super.onReceiveResult(i3, bundle2);
                k kVar2 = (k) weakReference.get();
                if (kVar2 != null) {
                    kVar2.finish();
                }
            }
        }, 9, bundle);
    }

    @Override // cooperation.qwallet.plugin.IQWalletHelper
    public void doQWalletQRCode(AppInterface appInterface, Activity activity, String str) {
        String str2;
        int indexOf;
        String str3;
        if (activity != null && !TextUtils.isEmpty(str)) {
            StatisticCollector.getInstance(null).reportToPCliOper(appInterface, "Vip_pay_mywallet" + QbAddrData.DATA_SPLITER + appInterface.getCurrentAccountUin() + QbAddrData.DATA_SPLITER + "" + QbAddrData.DATA_SPLITER + QCircleDaTongConstant.ElementParamValue.WALLET + QbAddrData.DATA_SPLITER + "watchqrcodescan" + QbAddrData.DATA_SPLITER + 0 + QbAddrData.DATA_SPLITER + 1 + QbAddrData.DATA_SPLITER + 0 + QbAddrData.DATA_SPLITER + "" + QbAddrData.DATA_SPLITER + "" + QbAddrData.DATA_SPLITER + "" + QbAddrData.DATA_SPLITER + "" + QbAddrData.DATA_SPLITER);
            int indexOf2 = str.indexOf(63);
            if (indexOf2 == -1) {
                return;
            }
            try {
                String[] split = str.substring(indexOf2 + 1).split(ContainerUtils.FIELD_DELIMITER);
                HashMap hashMap = new HashMap();
                int length = split.length;
                for (int i3 = 0; i3 < length; i3++) {
                    if (!TextUtils.isEmpty(split[i3]) && (indexOf = split[i3].indexOf(61)) != -1) {
                        String substring = split[i3].substring(0, indexOf);
                        try {
                            str3 = URLDecoder.decode(split[i3].substring(indexOf + 1), "UTF-8");
                        } catch (Exception e16) {
                            QLog.e(TAG, 1, "error msg in qqpay-impl module: ", e16);
                            str3 = "";
                        }
                        if (!TextUtils.isEmpty(substring)) {
                            hashMap.put(substring, str3);
                        }
                    }
                }
                if (hashMap.size() > 0) {
                    String str4 = (String) hashMap.get(QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO);
                    String str5 = (String) hashMap.get("a");
                    if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str5)) {
                        if (str4.compareTo(TenpayJumpActivity.TENPAY_SCHEME) == 0 && str5.compareTo("1") == 0) {
                            String str6 = (String) hashMap.get("u");
                            String str7 = (String) hashMap.get(DomainData.DOMAIN_NAME);
                            String str8 = (String) hashMap.get("f");
                            if (!TextUtils.isEmpty(str8) && str8.compareTo("apw") != 0) {
                                str2 = "appid#20000001|bargainor_id#1000026901|channel#" + str8;
                            } else {
                                str2 = "appid#20000001|bargainor_id#1000026901|channel#applewatchqrcode";
                            }
                            JSONObject jSONObject = new JSONObject();
                            try {
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("url", str);
                                jSONObject2.put("uin", str6);
                                jSONObject2.put("name", str7);
                                jSONObject.put("userId", appInterface.getCurrentAccountUin());
                                jSONObject.put(HippyHeaderListViewController.VIEW_TAG, "parseqrcode");
                                jSONObject.put("appInfo", str2);
                                jSONObject.put("come_from", 5);
                                jSONObject.put("extra_data", jSONObject2);
                            } catch (Exception e17) {
                                if (QLog.isDevelopLevel()) {
                                    QLog.e(TAG, 1, "error msg in qqpay-impl module: ", e17);
                                }
                            }
                            Bundle bundle = new Bundle();
                            bundle.putString(ark.ARKMETADATA_JSON, jSONObject.toString());
                            bundle.putString("callbackSn", "0");
                            Intent payBridgeIntent = ((IQWalletApi) QRoute.api(IQWalletApi.class)).getPayBridgeIntent(activity);
                            payBridgeIntent.putExtras(bundle);
                            payBridgeIntent.putExtra("pay_requestcode", 5);
                            activity.startActivityForResult(payBridgeIntent, 1);
                            return;
                        }
                        QQToast.makeText(activity, HardCodeUtil.qqStr(R.string.f214485t1), 0).show();
                        activity.finish();
                        return;
                    }
                    QQToast.makeText(activity, HardCodeUtil.qqStr(R.string.f214485t1), 0).show();
                    activity.finish();
                }
            } catch (Exception e18) {
                QLog.e(TAG, 1, "error msg in qqpay-impl module: ", e18);
            }
        }
    }

    @Override // cooperation.qwallet.plugin.IQWalletHelper
    public String getAppInfoFromHistory(WebView webView) {
        if (webView != null) {
            String appInfoByUrl = getAppInfoByUrl(webView.getUrl());
            if (!TextUtils.isEmpty(appInfoByUrl)) {
                return appInfoByUrl;
            }
            String appInfoByUrl2 = getAppInfoByUrl(webView.getOriginalUrl());
            if (!TextUtils.isEmpty(appInfoByUrl2)) {
                return appInfoByUrl2;
            }
            WebBackForwardList copyBackForwardList = webView.copyBackForwardList();
            if (copyBackForwardList != null) {
                for (int size = copyBackForwardList.getSize() - 1; size >= 0; size--) {
                    String appInfoByUrl3 = getAppInfoByUrl(copyBackForwardList.getItemAtIndex(size).getUrl());
                    if (!TextUtils.isEmpty(appInfoByUrl3)) {
                        return appInfoByUrl3;
                    }
                    appInfoByUrl2 = getAppInfoByUrl(copyBackForwardList.getItemAtIndex(size).getOriginalUrl());
                    if (!TextUtils.isEmpty(appInfoByUrl2)) {
                        return appInfoByUrl2;
                    }
                }
                return appInfoByUrl2;
            }
            return appInfoByUrl2;
        }
        return "";
    }

    @Override // cooperation.qwallet.plugin.IQWalletHelper
    public BaseQQAppInterface getAppInterface() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof BaseQQAppInterface) {
            return (BaseQQAppInterface) peekAppRuntime;
        }
        return null;
    }

    @Override // cooperation.qwallet.plugin.IQWalletHelper
    public String getCorrectAppInfo(String str, String str2) {
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        if (str.equals(str2)) {
            return str;
        }
        int lastIndexOf = str.lastIndexOf("|channel#");
        String str10 = "";
        if (lastIndexOf == -1) {
            str3 = "";
            str4 = str3;
            str5 = str4;
        } else {
            str5 = str.substring(lastIndexOf + 9);
            int indexOf = str.indexOf("|bargainor_id#");
            if (indexOf == -1) {
                str3 = "";
                str4 = str3;
            } else {
                str4 = str.substring(indexOf + 14, lastIndexOf);
                int indexOf2 = str.indexOf("appid#");
                str3 = indexOf2 != -1 ? str.substring(indexOf2 + 6, indexOf) : "";
            }
        }
        int lastIndexOf2 = str2.lastIndexOf("|channel#");
        if (lastIndexOf2 == -1) {
            str6 = "";
            str7 = str6;
        } else {
            str7 = str2.substring(lastIndexOf2 + 9);
            int indexOf3 = str2.indexOf("|bargainor_id#");
            if (indexOf3 == -1) {
                str6 = "";
            } else {
                str6 = str2.substring(indexOf3 + 14, lastIndexOf2);
                int indexOf4 = str2.indexOf("appid#");
                if (indexOf4 != -1) {
                    str10 = str2.substring(indexOf4 + 6, indexOf3);
                }
            }
        }
        if (!TextUtils.isEmpty(str10)) {
            str8 = "appid#" + str10;
        } else {
            str8 = "appid#" + str3;
        }
        String str11 = str8 + "|bargainor_id#";
        if (TextUtils.isEmpty(str4)) {
            str9 = str11 + str6;
        } else if (str4.compareTo("0") == 0) {
            str9 = str11 + str6;
        } else {
            str9 = str11 + str4;
        }
        String str12 = str9 + "|channel#";
        if (!TextUtils.isEmpty(str7)) {
            return str12 + str7;
        }
        return str12 + str5;
    }

    @Override // cooperation.qwallet.plugin.IQWalletHelper
    public synchronized void getPayCode(BaseQQAppInterface baseQQAppInterface) {
        if (baseQQAppInterface == null) {
            return;
        }
        String config = ((IQWalletTemp) QRoute.api(IQWalletTemp.class)).getConfig(baseQQAppInterface, "qqwallet_preloadpaycode");
        if (config != null && !config.equals("0")) {
            long currentTimeMillis = System.currentTimeMillis();
            long j3 = lastTime;
            if (j3 != -1 && currentTimeMillis - j3 < 7200000) {
                return;
            }
            lastTime = currentTimeMillis;
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 4, "getPayCode...");
            }
            String currentAccountUin = baseQQAppInterface.getCurrentAccountUin();
            Bundle bundle = new Bundle();
            bundle.putString("uin", currentAccountUin);
            bundle.putInt(QWalletPayBridge.Key.PAY_INVOKER_ID, 23);
            QWalletPayBridge.launchBackground(BaseApplication.getContext(), bundle);
        }
    }

    public HashMap<String, String> getPublicAccWhiteMap() {
        HashMap<String, String> hashMap = sPublicAccWhiteMap;
        if (hashMap == null || hashMap.isEmpty()) {
            updatePublicAccWhiteMap(BaseApplication.getContext().getSharedPreferences(IQWalletHelper.PREF_NAME_MULTI_PROCESS, 4).getString(IQWalletHelper.PREF_KEY_MULTI_PUBLICACC_WHITE_LIST, ""));
        }
        return sPublicAccWhiteMap;
    }

    @Override // cooperation.qwallet.plugin.IQWalletHelper
    public String getQWalletExternalPath() {
        if (!TextUtils.isEmpty(mQWalletExternalPath)) {
            return mQWalletExternalPath;
        }
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                mQWalletExternalPath = BaseApplication.getContext().getExternalFilesDir("QWallet").getAbsolutePath() + "/";
            }
        } catch (Throwable th5) {
            QLog.d(TAG, 1, "getQWalletExternalPath is error,throwable:", th5);
        }
        if (TextUtils.isEmpty(mQWalletExternalPath)) {
            mQWalletExternalPath = getQWalletInternalPath();
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "getQWalletExternalPath = " + mQWalletExternalPath);
        }
        return mQWalletExternalPath;
    }

    @Override // cooperation.qwallet.plugin.IQWalletHelper
    public String getQWalletInternalPath() {
        if (!TextUtils.isEmpty(mQWalletInternalPath)) {
            return mQWalletInternalPath;
        }
        String str = BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/QWallet/";
        mQWalletInternalPath = str;
        return str;
    }

    @Override // cooperation.qwallet.plugin.IQWalletHelper
    public AppRuntime getRuntime() {
        return getAppRuntime();
    }

    @Override // cooperation.qwallet.plugin.IQWalletHelper
    public void gotoF2FRedpack(String str, String str2, Activity activity, String str3, boolean z16) {
        int lastIndexOf;
        if (activity == null || TextUtils.isEmpty(str3) || (lastIndexOf = str3.lastIndexOf(35)) == -1) {
            return;
        }
        String substring = str3.substring(lastIndexOf + 1);
        if (TextUtils.isEmpty(substring)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(WadlProxyConsts.CHANNEL, 2048);
            jSONObject2.put("qr_data", substring);
            jSONObject2.put("name", str2);
            jSONObject.put("userId", str);
            jSONObject.put(HippyHeaderListViewController.VIEW_TAG, "graphb");
            jSONObject.put(j.T0, "");
            jSONObject.put("come_from", 2);
            jSONObject.put("extra_data", jSONObject2);
        } catch (Exception e16) {
            if (QLog.isDevelopLevel()) {
                QLog.e(TAG, 1, "error msg in qqpay-impl module: ", e16);
            }
        }
        Bundle bundle = new Bundle();
        bundle.putInt("extra_ext_data_type", 1);
        bundle.putBoolean("extra_ext_f2fredpack_is_anim", z16);
        Bundle bundle2 = new Bundle();
        String jSONObject3 = jSONObject.toString();
        bundle2.putBundle("extra_ext_data", bundle);
        bundle2.putString(ark.ARKMETADATA_JSON, jSONObject3);
        bundle2.putString("callbackSn", "0");
        Intent payBridgeIntent = ((IQWalletApi) QRoute.api(IQWalletApi.class)).getPayBridgeIntent(activity);
        payBridgeIntent.putExtras(bundle2);
        payBridgeIntent.putExtra("pay_requestcode", 5);
        try {
            activity.startActivity(payBridgeIntent);
        } catch (Exception e17) {
            if (QLog.isDevelopLevel()) {
                QLog.e(TAG, 1, "error msg in qqpay-impl module: ", e17);
            }
            if (QLog.isColorLevel()) {
                QLog.d(IQWalletHelper.TAG_WALLET_REDPACK, 2, "QWalletHelperImpl failed to startActivity : " + str3, e17);
            }
        }
    }

    @Override // cooperation.qwallet.plugin.IQWalletHelper
    public void gotoQWalletHome(Activity activity) {
        Intent intent = new Intent();
        intent.setData(Uri.parse("mqqapi://wallet/open?src_type=web&viewtype=0&version=1"));
        intent.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
        activity.startActivity(intent);
    }

    @Override // cooperation.qwallet.plugin.IQWalletHelper
    public boolean isLaunchPayPluginAct(Bundle bundle, Context context) {
        if (isForePay(bundle) && (context instanceof Activity)) {
            Activity activity = (Activity) context;
            if (isFromOnlyActScene(bundle) || isFromDiffTaskAffinity(activity) || isFromSpecifyModel() || isCurrTaskNotValid(activity) || isMidasLogic(bundle) || isAppPay(bundle)) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // cooperation.qwallet.plugin.IQWalletHelper
    public boolean isValidToLaunchQWallet(long j3) {
        long j16 = qLaunchTime;
        if (j3 - j16 <= 1200 && j3 - j16 >= 0) {
            return false;
        }
        return true;
    }

    @Override // cooperation.qwallet.plugin.IQWalletHelper
    public void launchPayService(Context context, AppRuntime appRuntime, Bundle bundle) {
        launchPayBridgeService(context, appRuntime, bundle);
    }

    @Override // cooperation.qwallet.plugin.IQWalletHelper
    public void launchQWalletAct(QBaseActivity qBaseActivity, AppRuntime appRuntime, boolean z16, int i3) {
        if (qBaseActivity != null && appRuntime != null) {
            if (z16 && b.a(qBaseActivity, appRuntime, i3)) {
                return;
            }
            h.a("homepage_onclick");
            qLaunchTime = System.currentTimeMillis();
            gotoQWalletAct(qBaseActivity, appRuntime, i3);
        }
    }

    protected boolean playF2FRedPackAnim(AppInterface appInterface, Activity activity, final String str) {
        IPreloadService iPreloadService;
        kl2.a moduleByName;
        List<IPreloadResource> resApiList;
        IPreloadResource iPreloadResource;
        if (appInterface == null || activity == null || TextUtils.isEmpty(str) || (iPreloadService = (IPreloadService) appInterface.getRuntimeService(IPreloadService.class, "")) == null || (moduleByName = iPreloadService.getModuleByName("f2f_redpacket")) == null || (resApiList = moduleByName.getResApiList()) == null || resApiList.size() <= 0 || (iPreloadResource = resApiList.get(0)) == null || TextUtils.isEmpty(iPreloadResource.getUrl())) {
            return false;
        }
        final String n3 = com.tencent.mobileqq.qwallet.preload.a.n(iPreloadResource.getUrl());
        if (TextUtils.isEmpty(n3)) {
            iPreloadService.downloadModule("f2f_redpacket", true);
            return false;
        }
        final String currentAccountUin = appInterface.getCurrentAccountUin();
        final String currentNickname = appInterface.getCurrentNickname();
        final WeakReference weakReference = new WeakReference(activity);
        ThreadManagerV2.post(new Runnable() { // from class: cooperation.qwallet.plugin.impl.QWalletHelperImpl.3
            @Override // java.lang.Runnable
            public void run() {
                final AnimationView.AnimationInfo loadFromZip = AnimationView.AnimationInfo.loadFromZip(n3);
                Activity activity2 = (Activity) weakReference.get();
                if (activity2 != null && !activity2.isFinishing()) {
                    activity2.runOnUiThread(new Runnable() { // from class: cooperation.qwallet.plugin.impl.QWalletHelperImpl.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Activity activity3 = (Activity) weakReference.get();
                            if (activity3 != null && !activity3.isFinishing()) {
                                if (loadFromZip != null) {
                                    try {
                                        com.tencent.mobileqq.qwallet.widget.a aVar = new com.tencent.mobileqq.qwallet.widget.a(activity3, R.style.ayy, loadFromZip);
                                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                        aVar.N(currentAccountUin, currentNickname, str);
                                        aVar.show();
                                        return;
                                    } catch (Exception unused) {
                                        loadFromZip.destoryBitmaps();
                                    }
                                }
                                AnonymousClass3 anonymousClass32 = AnonymousClass3.this;
                                QWalletHelperImpl.this.gotoF2FRedpack(currentAccountUin, currentNickname, activity3, str, false);
                            }
                        }
                    });
                }
            }
        }, 5, null, true);
        return true;
    }

    @Override // cooperation.qwallet.plugin.IQWalletHelper
    public void preloadQWallet(AppRuntime appRuntime) {
        preloadQWallet(appRuntime, 5000, "qwallet_default");
    }

    @Override // cooperation.qwallet.plugin.IQWalletHelper
    public void resetLaunchTime() {
        qLaunchTime = 0L;
    }

    @Override // cooperation.qwallet.plugin.IQWalletHelper
    public void updateHongBaoSpeedWitch(BaseQQAppInterface baseQQAppInterface, String str) {
        int i3;
        boolean z16 = true;
        try {
            i3 = Integer.parseInt(str);
        } catch (NumberFormatException e16) {
            QLog.e(TAG, 1, "error msg in qqpay-impl module: ", e16);
            i3 = 0;
        }
        if (i3 != 1) {
            z16 = false;
        }
        QWalletHelperDelegate.graphbSpeedEnable = z16;
    }

    @Override // cooperation.qwallet.plugin.IQWalletHelper
    public void updatePublicAccWhiteMap(String str) {
        String[] split;
        String[] split2;
        String str2;
        HashMap<String, String> hashMap = sPublicAccWhiteMap;
        if (hashMap == null) {
            sPublicAccWhiteMap = new HashMap<>(16);
        } else {
            hashMap.clear();
        }
        if (!TextUtils.isEmpty(str) && (split = str.split("\\|")) != null) {
            for (String str3 : split) {
                if (!TextUtils.isEmpty(str3) && (split2 = str3.split("#")) != null && !TextUtils.isEmpty(split2[0])) {
                    HashMap<String, String> hashMap2 = sPublicAccWhiteMap;
                    String str4 = split2[0];
                    if (split2.length > 1) {
                        str2 = split2[1];
                    } else {
                        str2 = "0";
                    }
                    hashMap2.put(str4, str2);
                }
            }
        }
    }

    @Override // cooperation.qwallet.plugin.IQWalletHelper
    public void preloadQWallet(AppRuntime appRuntime, int i3, final String str) {
        if (appRuntime == null) {
            return;
        }
        final String currentAccountUin = appRuntime.getCurrentAccountUin();
        final WeakReference weakReference = new WeakReference(appRuntime);
        ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: cooperation.qwallet.plugin.impl.QWalletHelperImpl.1
            @Override // java.lang.Runnable
            public void run() {
                if (((AppRuntime) weakReference.get()) == null) {
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putString("uin", currentAccountUin);
                bundle.putString("preload_from", str);
                bundle.putInt(QWalletPayBridge.Key.PAY_INVOKER_ID, 21);
                QWalletPayBridge.launchBackground(BaseApplication.getContext(), bundle);
            }
        }, i3);
    }
}
