package com.tencent.mobileqq.vas.hippy;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThemeHandler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.msf.core.c0.j;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.theme.DarkModeManager;
import com.tencent.mobileqq.theme.ThemeConstants;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.VasLogReporter;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.theme.QUIResourcesTransform;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.mobileqq.vas.theme.ThemeSwitchCallback;
import com.tencent.mobileqq.vas.theme.ThemeSwitchUtil;
import com.tencent.mobileqq.vas.theme.ThemeSwitcher;
import com.tencent.mobileqq.vas.theme.api.ThemeLocator;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.theme.diy.ResData;
import com.tencent.mobileqq.vas.theme.diy.ThemeBackground;
import com.tencent.mobileqq.vas.theme.diy.ThemeDiyModule;
import com.tencent.mobileqq.vas.theme.diy.ThemeDiyStyleLogic;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.stat.MttLoader;
import com.tencent.theme.SkinEngine;
import java.util.HashMap;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class VasThemeHippyHelper {

    /* renamed from: c, reason: collision with root package name */
    public Context f309459c;

    /* renamed from: d, reason: collision with root package name */
    private ThemeDiyModule f309460d;

    /* renamed from: f, reason: collision with root package name */
    Activity f309462f;

    /* renamed from: a, reason: collision with root package name */
    HashMap<Integer, String> f309457a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    final Object f309458b = new Object();

    /* renamed from: e, reason: collision with root package name */
    AppRuntime f309461e = BaseApplicationImpl.getApplication().getRuntime();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class ThemeSwitchListener extends ThemeSwitchCallback {
        String currentMethodName;
        private final boolean needSetCurrent;
        Promise promise;
        private final String themeId;
        ThemeUtil.ThemeInfo themeInfo;

        public ThemeSwitchListener(String str, boolean z16, ThemeUtil.ThemeInfo themeInfo, Promise promise) {
            this.themeId = str;
            this.needSetCurrent = z16;
            this.themeInfo = themeInfo;
            this.promise = promise;
        }

        @Override // com.tencent.mobileqq.vas.theme.ThemeSwitchCallback, com.tencent.mobileqq.vas.theme.api.IThemeSwitchCallback
        public boolean beforeSwitch(final ThemeLocator themeLocator) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.vas.hippy.VasThemeHippyHelper.ThemeSwitchListener.1
                @Override // java.lang.Runnable
                public void run() {
                    VasUtil.getService().getThemeSwitchManager().doScreenShot();
                    SkinEngine.getInstances().setSkinRootPath(VasThemeHippyHelper.this.f309459c, themeLocator.getUnzipPath());
                    VasLogReporter.getTheme().report("VasThemeHippyHelper theme_skin_engine[themeId:" + themeLocator.getThemeId() + "]");
                    ThemeUtil.setCurrentThemeIdVersion(VasThemeHippyHelper.this.f309461e, themeLocator.getThemeId(), "20000000");
                    QUIResourcesTransform.getInstance().onThemeUpdate(themeLocator.getThemeId(), themeLocator.getUnzipPath());
                    ThemeSwitchListener.this.postSwitch(0);
                }
            });
            return true;
        }

        @Override // com.tencent.mobileqq.vas.theme.ThemeSwitchCallback, com.tencent.mobileqq.vas.theme.api.IThemeSwitchCallback
        public void beginSwitch() {
            VasUtil.getService().getThemeSwitchManager().openSwitchDialog(VasThemeHippyHelper.this.f309462f);
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x0135  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x014d  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x013f  */
        @Override // com.tencent.mobileqq.vas.theme.ThemeSwitchCallback, com.tencent.mobileqq.vas.theme.api.IThemeSwitchCallback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean postSwitch(int i3) {
            boolean z16;
            char c16 = 2;
            if (QLog.isColorLevel() || i3 != 0) {
                QLog.i("VasThemeHippyHelper", 2, "themeSwitchListener,themeId=" + this.themeId + ",stateCode=" + i3);
            }
            String str = "set skin theme back:" + i3;
            if (i3 == 0) {
                if (this.needSetCurrent) {
                    ThemeUtil.ThemeInfo themeInfo = this.themeInfo;
                    String str2 = themeInfo.seriesID;
                    JSONArray jSONArray = themeInfo.themeArray;
                    long j3 = themeInfo.startTime;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("ThemeJsHandler switchThemeTask onPostExecute themeId=");
                    sb5.append(this.themeId);
                    sb5.append(",seriesID");
                    sb5.append(str2);
                    sb5.append(",themeArray:");
                    if (jSONArray != null && jSONArray.length() > 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    sb5.append(z16);
                    QLog.i("VasThemeHippyHelper", 1, sb5.toString());
                    if (!TextUtils.isEmpty(str2) && jSONArray != null && jSONArray.length() > 0) {
                        ThemeUtil.setWeekLoopTheme(VasThemeHippyHelper.this.f309461e, str2, jSONArray.toString(), j3);
                    }
                    ChatBackgroundManager chatBackgroundManager = (ChatBackgroundManager) VasThemeHippyHelper.this.f309461e.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER);
                    String string = ThemeBackground.getSharedPreferences(VasThemeHippyHelper.this.f309461e.getApp(), VasThemeHippyHelper.this.f309461e.getAccount(), 0).getString(AppConstants.Preferences.THEME_DIY_BG_AIO_PATH, "null");
                    String o16 = chatBackgroundManager.o(null);
                    if (string != null && !"null".equals(string) && string.equals(o16)) {
                        chatBackgroundManager.z(VasThemeHippyHelper.this.f309461e.getAccount(), null, "null", -1);
                    }
                    ThemeReporter.reportTheme(VasThemeHippyHelper.this.f309461e, ThemeReporter.SUBACTION_THEME, "200", 155, NetworkUtil.getSystemNetwork(null), 31, this.themeId, "20000000", ThemeReporter.PATH_DOWNLOAD, "");
                }
            } else {
                if (i3 == 3) {
                    if (QLog.isColorLevel()) {
                        QLog.i("VasThemeHippyHelper", 2, "ThemeJsHandler return because setupping.");
                    }
                    str = "is switching theme";
                } else if (i3 != -202 && i3 != -201) {
                    QLog.e("VasThemeHippyHelper", 1, "themeSwitchListener ret = false");
                    c16 = '\uffff';
                } else {
                    QLog.d("VasThemeHippyHelper", 1, "themeSwitchListener ret = true");
                }
                if (c16 != 0) {
                    this.promise.resolve(d.a(0, str, null));
                } else {
                    this.promise.reject(d.a(i3, "", null));
                }
                if (i3 != 0) {
                    VasUtil.getService().getThemeSwitchManager().clearOnErr(i3);
                }
                return false;
            }
            c16 = 0;
            if (c16 != 0) {
            }
            if (i3 != 0) {
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements DarkModeManager.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f309471a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ThemeSwitchListener f309472b;

        a(String str, ThemeSwitchListener themeSwitchListener) {
            this.f309471a = str;
            this.f309472b = themeSwitchListener;
        }

        @Override // com.tencent.mobileqq.theme.DarkModeManager.e
        public void onCancel() {
            if (!ThemeUtil.isFixTheme(this.f309471a)) {
                ThemeSwitchUtil.setPreviousThemeIdVersion(VasThemeHippyHelper.this.f309461e, this.f309471a, "20000000");
            }
            this.f309472b.postSwitch(0);
        }

        @Override // com.tencent.mobileqq.theme.DarkModeManager.e
        public void onConfirm() {
            VasThemeHippyHelper.this.f309460d.setSpThemeBackground();
            ThemeSwitcher.startSwitch(this.f309471a, "200", this.f309472b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b implements ThemeDiyStyleLogic.StyleCallBack {

        /* renamed from: a, reason: collision with root package name */
        String f309474a;

        /* renamed from: b, reason: collision with root package name */
        ThemeUtil.ThemeInfo f309475b;

        /* renamed from: c, reason: collision with root package name */
        Promise f309476c;

        public b(String str, boolean z16, String str2, ThemeUtil.ThemeInfo themeInfo, Promise promise) {
            this.f309474a = str2;
            this.f309475b = themeInfo;
            this.f309476c = promise;
        }

        @Override // com.tencent.mobileqq.vas.theme.diy.ThemeDiyStyleLogic.StyleCallBack
        public int callback(int i3, int i16, Bundle bundle, ResData resData) {
            int i17;
            Bundle bundle2 = new Bundle();
            bundle2.putString("themeId", bundle.getString("themeId"));
            if (i16 == 4) {
                i17 = 0;
            } else {
                i17 = -2;
            }
            bundle2.putInt(ThemeConstants.THEME_STATUS, i17);
            bundle.putBundle("response", bundle2);
            VasThemeHippyHelper.this.e(bundle, this.f309476c, this.f309475b);
            return 1;
        }
    }

    public VasThemeHippyHelper(Context context, AppInterface appInterface, Activity activity) {
        this.f309459c = context;
        this.f309460d = new ThemeDiyModule(context, appInterface);
        this.f309462f = activity;
    }

    private void c(String str, String str2, String str3, Promise promise) {
        ThemeUtil.ThemeInfo themeInfo = ThemeUtil.getThemeInfo(this.f309459c, str);
        if (themeInfo == null) {
            themeInfo = new ThemeUtil.ThemeInfo();
            themeInfo.themeId = str;
            themeInfo.version = str2;
            if ("1000".equals(str)) {
                themeInfo.status = "5";
            }
            ThemeUtil.setThemeInfo(this.f309459c, themeInfo);
        }
        ThemeUtil.ThemeInfo themeInfo2 = themeInfo;
        if ("1103".equals(str)) {
            this.f309460d.setSpThemeBackground();
            ThemeSwitcher.startSwitch(str, "200", new ThemeSwitchListener(str, true, themeInfo2, promise));
            return;
        }
        b bVar = new b(str, true, "", themeInfo2, promise);
        Bundle bundle = new Bundle();
        bundle.putString("themeId", str);
        bundle.putString("seriesID", str3);
        ((ThemeHandler) ((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(BusinessHandlerFactory.THEME_HANDLER)).T2(str, str2, str3, com.tencent.mobileqq.emosm.a.a("setSVTheme", "0", 0, bundle), bVar);
    }

    private void d(Promise promise, ThemeUtil.ThemeInfo themeInfo, String str, Bundle bundle) {
        try {
            if ("setSVTheme".equals(str)) {
                String string = bundle.getString("themeId");
                int i3 = bundle.getInt(ThemeConstants.THEME_STATUS, -1);
                if (QLog.isColorLevel()) {
                    QLog.d("VasThemeHippyHelper", 2, "IPC_THEME_SET_SERVER respone themeId:" + string + ", ret:" + i3);
                }
                if (i3 != 0) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("themeId", string);
                    promise.reject(d.a(5, "setup theme setSV error.", jSONObject));
                    return;
                }
                synchronized (this.f309458b) {
                    ThemeSwitchListener themeSwitchListener = new ThemeSwitchListener(string, true, themeInfo, promise);
                    if (promise != null && !TextUtils.isEmpty(string) && themeInfo != null && string.equals(themeInfo.themeId) && !DarkModeManager.w(this.f309462f, string, new a(string, themeSwitchListener))) {
                        if (!SimpleUIUtil.getSimpleUISwitch()) {
                            this.f309460d.setSpThemeBackground();
                            ThemeSwitcher.startSwitch(string, "200", themeSwitchListener);
                        } else {
                            if (!ThemeUtil.isFixTheme(string)) {
                                ThemeSwitchUtil.setPreviousThemeIdVersion(this.f309461e, string, "20000000");
                            }
                            themeSwitchListener.postSwitch(0);
                        }
                    }
                }
            }
        } catch (Throwable th5) {
            QLog.e("VasThemeHippyHelper", 1, "onResponse Throwable cmd:" + str + ", msg\uff1a" + QLog.getStackTraceString(th5));
            promise.reject(d.a(-1, th5.toString(), null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h(Bundle bundle, String str, int i3) {
        String str2;
        String str3;
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        int systemNetwork = NetworkUtil.getSystemNetwork(qQAppInterface.getApplication().getApplicationContext());
        String string = bundle.getString("actionName");
        boolean z16 = false;
        if (TextUtils.isEmpty(string)) {
            str2 = "";
        } else {
            long j3 = bundle.getLong(PreDownloadConstants.RPORT_KEY_DOWNLOAD_TIME);
            int currentUserVipType = ((ISVIPHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).getCurrentUserVipType();
            if (currentUserVipType == 2) {
                currentUserVipType = 0;
            } else if (currentUserVipType == 3) {
                currentUserVipType = 2;
            }
            str2 = "";
            ReportController.o(qQAppInterface, "CliOper", "", "", "theme_mall", string, 0, i3, str, "" + currentUserVipType, String.valueOf(systemNetwork), String.valueOf(j3));
        }
        String string2 = bundle.getString("statisticKey");
        if (!TextUtils.isEmpty(string2)) {
            try {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("param_themeId", str);
                hashMap.put(j.I0, String.valueOf(systemNetwork));
                hashMap.put("param_FailCode", bundle.getString("param_FailCode"));
                StatisticCollector statisticCollector = StatisticCollector.getInstance(qQAppInterface.getApplication().getApplicationContext());
                String account = qQAppInterface.getAccount();
                if (i3 == 0) {
                    z16 = true;
                }
                statisticCollector.collectPerformance(account, string2, z16, 1L, 0L, hashMap, "", false);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(StatisticCollector.TAG, 2, "StatisticCollector Error:" + e16.getMessage());
                }
            }
        }
        String string3 = bundle.getString("from");
        if (!TextUtils.isEmpty(string3)) {
            int i16 = bundle.getInt("step");
            int i17 = bundle.getInt("code");
            String string4 = bundle.getString("version");
            String string5 = bundle.getString("path");
            String string6 = bundle.getString("r5");
            if (TextUtils.isEmpty(string6)) {
                str3 = str2;
            } else {
                str3 = string6;
            }
            ThemeReporter.reportTheme(qQAppInterface, ThemeReporter.SUBACTION_THEME, string3, i16, systemNetwork, i17, str, string4, string5, str3);
        }
    }

    public void e(Bundle bundle, Promise promise, ThemeUtil.ThemeInfo themeInfo) {
        if (bundle != null) {
            boolean z16 = false;
            bundle.getInt("respkey", 0);
            String string = bundle.getString("cmd");
            bundle.getString("callbackid");
            Bundle bundle2 = bundle.getBundle("response");
            if (bundle2 == null) {
                return;
            }
            int i3 = bundle2.getInt("failcode", 1000);
            if (TextUtils.isEmpty(string) || QLog.isColorLevel() || 1001 == i3) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("response:");
                sb5.append(string);
                sb5.append(", backCode=");
                sb5.append(i3);
                sb5.append(", isTimeOut=");
                if (1001 == i3) {
                    z16 = true;
                }
                sb5.append(z16);
                QLog.d("VasThemeHippyHelper", 2, sb5.toString());
            }
            if (TextUtils.isEmpty(string)) {
                return;
            }
            d(promise, themeInfo, string, bundle2);
        }
    }

    void f(final String str, final int i3, final String str2, final long j3, final String str3, final String str4, final String str5, final int i16, final String str6, final int i17, final String str7, final String str8) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.tencent.mobileqq.vas.hippy.VasThemeHippyHelper.1
            @Override // java.lang.Runnable
            public void run() {
                Bundle bundle = new Bundle();
                bundle.putString("themeId", str2);
                bundle.putInt("actionResult", i3);
                if (!TextUtils.isEmpty(str)) {
                    bundle.putString("actionName", str);
                    bundle.putLong(PreDownloadConstants.RPORT_KEY_DOWNLOAD_TIME, j3);
                }
                if (!TextUtils.isEmpty(str3)) {
                    bundle.putString("statistic_key", str3);
                    bundle.putString("param_FailCode", str4);
                }
                if (!TextUtils.isEmpty(str5)) {
                    bundle.putString("from", str5);
                    bundle.putInt("step", i16);
                    bundle.putInt("code", i17);
                    bundle.putString("version", str7);
                    bundle.putString("r5", str8);
                    bundle.putString("path", str6);
                }
                VasThemeHippyHelper.h(bundle, str2, i3);
            }
        }, 2000L);
    }

    public String g(boolean z16, String str, String str2, String str3, int i3, String str4, JSONArray jSONArray, long j3, Promise promise) {
        String str5;
        Object obj;
        Promise promise2;
        String str6;
        VasThemeHippyHelper vasThemeHippyHelper;
        Promise promise3;
        String str7;
        VasCommonReporter.getHistoryFeature().setValue1("hippy_set_theme").reportEveryDay();
        if (!TextUtils.isEmpty(str2) && (TextUtils.isEmpty(str4) || (jSONArray != null && jSONArray.length() >= 1))) {
            promise2 = promise;
            str5 = str2;
            obj = null;
        } else {
            QLog.e("VasThemeHippyHelper", 1, "ThemeJsHandler setup setWeekLoopThemeArray err,seriesID=" + str4 + ",themeArray=" + jSONArray);
            str5 = str2;
            f(null, 0, str2, 0L, null, null, str, 155, ThemeReporter.PATH_DOWNLOAD, -8, str3, "");
            obj = null;
            promise2 = promise;
            promise2.reject(d.a(1, "seriesID || themeArray data error", null));
        }
        String currentThemeId = ThemeUtil.getCurrentThemeId();
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("ThemeJsHandler setup,themeId=");
            sb5.append(str5);
            sb5.append(MttLoader.QQBROWSER_PARAMS_VERSION);
            str6 = str3;
            sb5.append(str6);
            sb5.append(",isSound=");
            sb5.append(i3);
            sb5.append(" isDiyTheme:");
            sb5.append(z16);
            sb5.append(" currentThemeId:");
            sb5.append(currentThemeId);
            QLog.i("VasThemeHippyHelper", 2, sb5.toString());
        } else {
            str6 = str3;
        }
        if (str5.equals(currentThemeId) && !z16) {
            if (QLog.isColorLevel()) {
                QLog.i("VasThemeHippyHelper", 2, "ThemeJsHandler setup the same theme,themeId=" + str5 + MttLoader.QQBROWSER_PARAMS_VERSION + str6);
            }
            String str8 = str5;
            vasThemeHippyHelper = this;
            if (vasThemeHippyHelper.f309457a.containsKey(Integer.valueOf((str8 + "_" + str6).hashCode()))) {
                str7 = vasThemeHippyHelper.f309457a.get(Integer.valueOf((str8 + "_" + str6).hashCode()));
            } else {
                str7 = ThemeReporter.PATH_SETPUP;
            }
            f(null, 1, str2, 0L, null, null, "200", 155, str7, 23, str3, "0");
            promise3 = promise;
            promise3.resolve(d.a(0, "set the same theme", obj));
        } else {
            vasThemeHippyHelper = this;
            promise3 = promise2;
        }
        synchronized (vasThemeHippyHelper.f309458b) {
            vasThemeHippyHelper.c(str2, str3, str4, promise3);
        }
        if (QLog.isColorLevel()) {
            QLog.i("VasThemeHippyHelper", 2, "setup server :id:" + str2);
            return "";
        }
        return "";
    }
}
