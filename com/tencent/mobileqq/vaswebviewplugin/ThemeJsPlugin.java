package com.tencent.mobileqq.vaswebviewplugin;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.gamecenter.common.util.GameCenterAPIJavaScript;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.theme.DarkModeManager;
import com.tencent.mobileqq.theme.ThemeConstants;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.VasLogReporter;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.aidl.IDownloadListener;
import com.tencent.mobileqq.vas.aidl.ISwitchCallback;
import com.tencent.mobileqq.vas.ipc.QuickUpdateIPCModule;
import com.tencent.mobileqq.vas.quickupdate.ChatBackgroundBusiness;
import com.tencent.mobileqq.vas.quickupdate.ThemeUpdateCallback;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.mobileqq.vas.report.VasJsbCommonReport;
import com.tencent.mobileqq.vas.theme.JSONResult;
import com.tencent.mobileqq.vas.theme.QUIResourcesTransform;
import com.tencent.mobileqq.vas.theme.ThemeIPCModule;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.mobileqq.vas.theme.ThemeSwitchUtil;
import com.tencent.mobileqq.vas.theme.api.QueryCallback;
import com.tencent.mobileqq.vas.theme.api.ThemeLocator;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.theme.diy.ThemeDiyModule;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vip.d;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.stat.MttLoader;
import com.tencent.theme.SkinEngine;
import com.tencent.theme.TextHook;
import com.tencent.vas.update.entity.UpdateListenerParams;
import eipc.EIPCCallback;
import eipc.EIPCResult;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes35.dex */
public class ThemeJsPlugin extends VasWebviewJsPlugin {
    public static final String BUSINESS_NAME = "theme";
    public static final byte REQUEST_CODE = 1;
    private static final String SAVE_DIY_THEME = "saveDiyTheme";
    public static final String TAG = "ThemeJsPlugin";
    static final int THEME_OPTION_ERROR = -1;
    static final int THEME_OPTION_FILE_LOSE_ERROR = 4;
    static final int THEME_OPTION_PKG_NOT_EXISTS = 1;
    static final int THEME_OPTION_PKG_UNZIP_ERROR = 2;
    static final int THEME_OPTION_SAVE_THEMEINFO_ERROR = 3;
    static final int THEME_OPTION_SET_SV_ERROR = 5;
    static final int THEME_OPTION_SUCCESS = 0;
    private static final String XM_3 = "Xiaomi_MI 3";
    public static String loadingThemeIdForJsCall;
    public BrowserAppInterface app;
    public Context context;
    private String currDownloadingThemeId;
    QQCustomDialog dialog;
    String mCallbackId;
    private String mCurrentMethodName;
    private ThemeDiyModule mThemeDiyModule;
    ThemeUtil.ThemeInfo mThemeinfo;
    public QQProgressDialog themeSwitchDialog;
    private ConcurrentHashMap<String, ThemeUtil.ThemeInfo> downloadThemeMap = new ConcurrentHashMap<>();
    HashMap<Integer, String> reportMap = new HashMap<>();
    private final ConcurrentHashMap<String, String> mThemeToSetKey = new ConcurrentHashMap<>();
    private VasJsbCommonReport report = VasJsbCommonReport.INSTANCE;
    final Object mLock = new Object();
    ThemeDiyModule.ThemeDiyImpl mThemeDiyImpl = new AnonymousClass4();

    /* renamed from: com.tencent.mobileqq.vaswebviewplugin.ThemeJsPlugin$4, reason: invalid class name */
    /* loaded from: classes35.dex */
    class AnonymousClass4 implements ThemeDiyModule.ThemeDiyImpl {
        AnonymousClass4() {
        }

        @Override // com.tencent.mobileqq.vas.theme.diy.ThemeDiyModule.ThemeDiyImpl
        public void callJs(String str, String... strArr) {
            ThemeJsPlugin.this.callJs(str, strArr);
        }

        @Override // com.tencent.mobileqq.vas.theme.diy.ThemeDiyModule.ThemeDiyImpl
        public void diyThemeSetup(JSONObject jSONObject, String str) {
            ThemeJsPlugin.this.diyThemeSetup(jSONObject.optString("id"), jSONObject.optString("version"), jSONObject.optString(VasCommonJsbProxy.JSON_KEY_SET_KEY), str);
        }

        @Override // com.tencent.mobileqq.vas.theme.diy.ThemeDiyModule.ThemeDiyImpl
        public void downloadBgPic(String str, int i3) {
            ChatBackgroundBusiness chatBackgroundBusiness = (ChatBackgroundBusiness) QQVasUpdateBusiness.getBusiness(ChatBackgroundBusiness.class);
            chatBackgroundBusiness.addDownLoadListener(i3, new IDownLoadListener() { // from class: com.tencent.mobileqq.vaswebviewplugin.ThemeJsPlugin.4.1
                @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
                public void onLoadFail(UpdateListenerParams updateListenerParams) {
                    AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                    anonymousClass4.callJs(ThemeJsPlugin.this.mCallbackId, new JSONResult(updateListenerParams.mErrorCode, "bg image download failed").toJsonString());
                }

                @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
                public void onLoadSuccess(UpdateListenerParams updateListenerParams) {
                    ThemeJsPlugin.this.mThemeDiyModule.trySaveDefineImage(ThemeJsPlugin.this.mCallbackId);
                }
            });
            chatBackgroundBusiness.startDownload(i3);
        }

        @Override // com.tencent.mobileqq.vas.theme.diy.ThemeDiyModule.ThemeDiyImpl
        public void startDownload(JSONObject jSONObject, String str) {
            ThemeJsPlugin.this.startDownload(jSONObject, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void applyTheme(final String str, final String str2) {
        VasUtil.getService().getJsbCallManager().detailWithDarkMode(str2, new EIPCCallback.Stub() { // from class: com.tencent.mobileqq.vaswebviewplugin.ThemeJsPlugin.3
            @Override // eipc.EIPCCallback
            public void callback(EIPCResult eIPCResult) throws RemoteException {
                ThemeUtil.ThemeInfo themeInfo;
                if (!TextUtils.isEmpty(str) && str.equals(ThemeJsPlugin.this.mCallbackId) && !TextUtils.isEmpty(str2) && (themeInfo = ThemeJsPlugin.this.mThemeinfo) != null && str2.equals(themeInfo.themeId)) {
                    boolean equals = eIPCResult.data.getString("choose", MiniProgramLpReportDC04239.NORMAL_URL_DIALOG_CONFIRM).equals(MiniProgramLpReportDC04239.NORMAL_URL_DIALOG_CONFIRM);
                    if (equals && !SimpleUIUtil.getSimpleUISwitch()) {
                        VasLogReporter.getTheme().reportHighest("web change theme");
                        ThemeJsPlugin.this.mThemeDiyModule.setSpThemeBackground();
                        String str3 = str2;
                        ThemeIPCModule.startSwitch(str3, new ThemeSwitchListener(str3, true));
                        return;
                    }
                    VasLogReporter.getTheme().reportHighest("web nochange theme : isConfirm=" + equals);
                    if (!ThemeUtil.isFixTheme(str2)) {
                        ThemeSwitchUtil.setPreviousThemeIdVersion(ThemeJsPlugin.this.app, str2, "20000000");
                    }
                    new ThemeSwitchListener(str2, false).postSwitch(0);
                    return;
                }
                QLog.e(ThemeJsPlugin.TAG, 1, "delay callback");
            }
        });
    }

    private long getThemeZipFileSize(String str) {
        ThemeLocator themeLocator = new ThemeLocator();
        themeLocator.setThemeId(str);
        themeLocator.init(BaseApplication.context, ThemeUtil.getThemeConfigID(str), "");
        File file = new File(themeLocator.getZipPath());
        if (!file.exists() || file.isDirectory()) {
            return 0L;
        }
        return file.length();
    }

    private void removeTimeoutDelayTask(String str) {
        this.report.removeTimeoutDelayTask(str);
    }

    private void reportDownloadFail(String str, String str2, long j3, int i3, int i16, String str3) {
        this.report.reportDownloadFail(str, str2, j3, i3, i16, str3);
    }

    private void reportDownloadSuccess(String str, String str2, long j3, long j16) {
        this.report.reportDownloadSuccess(str, str2, j3, j16);
    }

    private void reportFirstQuery(VasJsbCommonReport.TimeRecord timeRecord) {
        this.report.reportFirstQuery(timeRecord);
    }

    private void reportSetComplete(String str, String str2, long j3) {
        this.report.reportSetEndSetSuccess(str, str2, j3);
    }

    private void reportSetFailDownloadFail(String str, String str2, long j3, int i3) {
        this.report.reportSetEndDownloadFail(str, str2, j3, i3);
    }

    private void reportSetFailThemeFail(String str, String str2, long j3, int i3) {
        this.report.reportSetEndSetFail(str, str2, j3, i3);
    }

    private void reportThemeSetFail(String str, String str2, long j3, int i3) {
        this.report.reportSingleStepFail(str, str2, j3, 2, i3);
    }

    private void reportThemeSetSuccess(String str, String str2, long j3) {
        this.report.reportSingleStepSuccess(str, str2, j3, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportThemeSwitch(String str, int i3) {
        VasJsbCommonReport.TimeRecord timeRecord;
        String remove = this.mThemeToSetKey.remove(str);
        if (remove == null || TextUtils.isEmpty(remove) || (timeRecord = this.report.getMSetKeyToStartTime().get(remove)) == null) {
            return;
        }
        if (i3 == 0) {
            reportThemeSetSuccess(remove, timeRecord.getSetupId(), System.currentTimeMillis() - timeRecord.getSetupTime());
            reportSetComplete(remove, str, System.currentTimeMillis() - timeRecord.getFirstQueryTime());
        } else {
            reportThemeSetFail(remove, str, System.currentTimeMillis() - timeRecord.getSetupTime(), i3);
            reportSetFailThemeFail(remove, str, System.currentTimeMillis() - timeRecord.getFirstQueryTime(), i3);
        }
    }

    private void requestDownloadTheme(String str, String str2, final String str3) {
        final DownloadListener downloadListener = new DownloadListener(str, str2);
        VasUtil.getService().getJsbCallManager().startDownloadTheme(str3, new EIPCCallback.Stub() { // from class: com.tencent.mobileqq.vaswebviewplugin.ThemeJsPlugin.10
            @Override // eipc.EIPCCallback
            public void callback(EIPCResult eIPCResult) throws RemoteException {
                Bundle bundle = eIPCResult.data;
                if (bundle == null) {
                    return;
                }
                if (bundle.getBoolean("isProgress")) {
                    downloadListener.onProgress(ThemeUtil.getThemeConfigID(str3), bundle.getLong("progress"), bundle.getLong("progressMax"));
                } else {
                    if (TextUtils.isEmpty(bundle.getString("result"))) {
                        return;
                    }
                    downloadListener.onComplete(ThemeUtil.getThemeConfigID(str3), bundle.getInt("errorCode"));
                }
            }
        });
    }

    private void requestServerAndChangeTheme(final String str, Bundle bundle, final String str2) {
        VasUtil.getService().getJsbCallManager().requestThemeServer(bundle, new EIPCCallback.Stub() { // from class: com.tencent.mobileqq.vaswebviewplugin.ThemeJsPlugin.2
            @Override // eipc.EIPCCallback
            public void callback(EIPCResult eIPCResult) throws RemoteException {
                String string = eIPCResult.data.getString("themeId");
                int i3 = eIPCResult.data.getInt(ThemeConstants.THEME_STATUS, -1);
                if (QLog.isColorLevel()) {
                    VasLogReporter.getTheme().reportLow("IPC_THEME_SET_SERVER respone themeId:" + string + ", ret:" + i3);
                }
                if (i3 == 0) {
                    ThemeJsPlugin.this.applyTheme(str, str2);
                } else {
                    ThemeJsPlugin.super.callJs(str, new JSONResult(i3, "setup theme setSV error.").toJsonString());
                }
            }
        });
    }

    public void diyThemeSetup(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", str);
        } catch (JSONException e16) {
            QLog.w(TAG, 1, "diyThemeSetup", e16);
        }
        if (!"999".equals(str) && !TextUtils.isEmpty(str2)) {
            jSONObject.put("version", str2);
            jSONObject.put(VasCommonJsbProxy.JSON_KEY_SET_KEY, str3);
            setup(jSONObject, str4, this.mThemeDiyModule.getAuthReqBundle(str, str2), true);
        }
        jSONObject.put("version", "20000000");
        jSONObject.put(VasCommonJsbProxy.JSON_KEY_SET_KEY, str3);
        setup(jSONObject, str4, this.mThemeDiyModule.getAuthReqBundle(str, str2), true);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "theme";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasBasePlugin
    public long getPluginBusiness() {
        return 2147483680L;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewEventByNameSpace(String str) {
        return 128L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin, com.tencent.mobileqq.vaswebviewplugin.VasBasePlugin, com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        if (this.mRuntime.b() != null && (this.mRuntime.b() instanceof BrowserAppInterface)) {
            this.app = (BrowserAppInterface) this.mRuntime.b();
        }
        this.context = this.mRuntime.a().getApplicationContext();
        ThemeDiyModule themeDiyModule = new ThemeDiyModule(this.context, this.app);
        this.mThemeDiyModule = themeDiyModule;
        themeDiyModule.setThemeDiyImpl(this.mThemeDiyImpl);
        super.onCreate();
        QLog.d(TAG, 1, "onCreate, nowThemeId=" + ThemeUtil.getCurrentThemeId() + ", userThemeId=" + ThemeUtil.getUserCurrentThemeId(this.app));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin, com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        super.onDestroy();
    }

    public void onPostThemeChanged() {
        View view;
        ThemeUtil.ThemeInfo themeInfo;
        if (QLog.isColorLevel()) {
            if (loadingThemeIdForJsCall != null) {
                QLog.d(TAG, 2, "message.mp3switch to themeid " + loadingThemeIdForJsCall);
            } else {
                QLog.d(TAG, 2, "message.mp3switch ok");
            }
        }
        try {
            view = this.mRuntime.a().getWindow().getDecorView().getRootView();
        } catch (Exception e16) {
            e16.printStackTrace();
            view = null;
        }
        if (view == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "titleView is null");
            }
        } else {
            if ((Build.MANUFACTURER + "_" + DeviceInfoMonitor.getModel()).contains(XM_3)) {
                view.setLayerType(1, null);
            }
            QQProgressDialog qQProgressDialog = this.themeSwitchDialog;
            if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
                this.themeSwitchDialog.dismiss();
            }
        }
        VasUtil.getService().getThemeSwitchManager().onPostThemeChanged();
        if (getNewBusiness() == null || (themeInfo = this.mThemeinfo) == null || TextUtils.isEmpty(this.mCallbackId) || !TextUtils.equals(themeInfo.themeId, ThemeUtil.getCurrentThemeId())) {
            return;
        }
        callJs(this.mCallbackId, new JSONResult(0, "set skin theme back:0").toJsonString());
        reportThemeSwitch(themeInfo.themeId, 0);
    }

    void reportTheme(final String str, final int i3, final String str2, final long j3, final String str3, final String str4, final String str5, final int i16, final String str6, final int i17, final String str7, final String str8) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.tencent.mobileqq.vaswebviewplugin.ThemeJsPlugin.1
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
                ThemeJsPlugin.this.sendRemoteReq(com.tencent.mobileqq.emosm.a.a("reportTheme", "", ThemeJsPlugin.this.mOnRemoteResp.key, bundle), false, true);
                if (j3 <= 0 || TextUtils.isEmpty(str2)) {
                    return;
                }
                VasCommonReporter.getTheme().setValue3(ImageManagerEnv.MTA_VALUE_DOWNLOAD_TIME).setValue4(str2).setValue5(str5).setNum1(i17).setNum2(j3).report(false);
            }
        }, 2000L);
    }

    public synchronized void startDownload(final JSONObject jSONObject, final String str) {
        String optString = jSONObject.optString("id");
        final String optString2 = jSONObject.optString(VasCommonJsbProxy.JSON_KEY_SET_KEY);
        ThemeIPCModule.queryThemeLocation(optString, new QueryCallback<ThemeLocator>() { // from class: com.tencent.mobileqq.vaswebviewplugin.ThemeJsPlugin.5
            @Override // com.tencent.mobileqq.vas.theme.api.QueryCallback
            public void postQuery(ThemeLocator themeLocator) {
                ThemeJsPlugin.this.startDownload(jSONObject, str, themeLocator, optString2);
            }
        });
    }

    private QQVasUpdateBusiness<?> getNewBusiness() {
        if (!QQVasUpdateBusiness.isUseUpdateBusinessMigration(3L).booleanValue()) {
            return null;
        }
        try {
            return QQVasUpdateBusiness.getBusiness(3L);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getNewBusiness Exception\uff1a" + e16.getMessage());
            return null;
        }
    }

    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin
    public void onResponse(Bundle bundle) {
        ThemeUtil.ThemeInfo themeInfo;
        if (bundle != null) {
            int i3 = bundle.getInt("respkey", 0);
            String string = bundle.getString("cmd");
            String string2 = bundle.getString("callbackid");
            Bundle bundle2 = bundle.getBundle("response");
            if (bundle2 != null && i3 == this.mOnRemoteResp.key) {
                int i16 = bundle.getInt("failcode", 1000);
                if (TextUtils.isEmpty(string) || QLog.isColorLevel() || 1001 == i16) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("response:");
                    sb5.append(string);
                    sb5.append(", backCode=");
                    sb5.append(i16);
                    sb5.append(", isTimeOut=");
                    sb5.append(1001 == i16);
                    QLog.d(TAG, 2, sb5.toString());
                }
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                try {
                    if ("stopdownload".equals(string)) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("result", 0);
                        jSONObject.put("message", "Download process paused.");
                        super.callJs(string2, jSONObject.toString());
                        return;
                    }
                    if ("weekLoopGetData".equals(string)) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("result", 0);
                        String string3 = bundle2.getString("seriesID");
                        String string4 = bundle2.getString("themeArray");
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "IPC_THEME_WEEK_LOOP_GET respone seriesID:" + string3 + ", themeArr:" + string4);
                        }
                        jSONObject2.put("seriesID", string3);
                        jSONObject2.put("themeArray", string4);
                        jSONObject2.put("message", "useSeriesID is " + string3);
                        super.callJs(string2, jSONObject2.toString());
                        return;
                    }
                    if ("themeQueryLocal".equals(string)) {
                        JSONObject jSONObject3 = new JSONObject();
                        JSONObject jSONObject4 = new JSONObject();
                        jSONObject4.put("localInfo", new JSONObject(bundle2.getString("themeId")));
                        jSONObject4.put("currentId", ThemeUtil.getCurrentThemeId());
                        int i17 = ThemeUtil.getUinThemePreferences(this.app).getInt("stripUserTheme", 0);
                        if (i17 != 0) {
                            ThemeUtil.getUinThemePreferences(this.app).edit().remove("stripUserTheme").commit();
                        }
                        jSONObject3.put("result", 0);
                        jSONObject3.put("message", FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
                        jSONObject3.put("data", jSONObject4);
                        jSONObject3.put("authResult", i17);
                        if (QLog.isColorLevel()) {
                            QLog.i(TAG, 2, "ThemeJsHandler queryLocal ok:" + jSONObject3);
                        }
                        callJs(string2, jSONObject3.toString());
                        return;
                    }
                    if ("setSVTheme".equals(string)) {
                        final String string5 = bundle2.getString("themeId");
                        int i18 = bundle2.getInt(ThemeConstants.THEME_STATUS, -1);
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "IPC_THEME_SET_SERVER respone themeId:" + string5 + ", ret:" + i18);
                        }
                        if (i18 == 0) {
                            synchronized (this.mLock) {
                                if (!TextUtils.isEmpty(string2) && string2.equals(this.mCallbackId) && !TextUtils.isEmpty(string5) && (themeInfo = this.mThemeinfo) != null && string5.equals(themeInfo.themeId) && !DarkModeManager.w(this.mRuntime.a(), string5, new DarkModeManager.e() { // from class: com.tencent.mobileqq.vaswebviewplugin.ThemeJsPlugin.13
                                    @Override // com.tencent.mobileqq.theme.DarkModeManager.e
                                    public void onCancel() {
                                        if (!ThemeUtil.isFixTheme(string5)) {
                                            ThemeSwitchUtil.setPreviousThemeIdVersion(ThemeJsPlugin.this.app, string5, "20000000");
                                        }
                                        new ThemeSwitchListener(string5, false).postSwitch(0);
                                    }

                                    @Override // com.tencent.mobileqq.theme.DarkModeManager.e
                                    public void onConfirm() {
                                        ThemeJsPlugin.this.mThemeDiyModule.setSpThemeBackground();
                                        ThemeIPCModule.startSwitch(string5, new ThemeSwitchListener(string5, true));
                                    }
                                })) {
                                    if (!SimpleUIUtil.getSimpleUISwitch()) {
                                        this.mThemeDiyModule.setSpThemeBackground();
                                        ThemeIPCModule.startSwitch(string5, new ThemeSwitchListener(string5, true));
                                    } else {
                                        if (!ThemeUtil.isFixTheme(string5)) {
                                            ThemeSwitchUtil.setPreviousThemeIdVersion(this.app, string5, "20000000");
                                        }
                                        new ThemeSwitchListener(string5, false).postSwitch(0);
                                    }
                                }
                            }
                            return;
                        }
                        if (SAVE_DIY_THEME.equals(this.mCurrentMethodName)) {
                            super.callJs(string2, new JSONResult(bundle.getInt(ThemeConstants.BUNDLE_KEY_RESULT_INT), HardCodeUtil.qqStr(R.string.u4q)).toJsonString());
                            return;
                        }
                        JSONObject jSONObject5 = new JSONObject();
                        jSONObject5.put("themeId", string5);
                        jSONObject5.put("result", 5);
                        jSONObject5.put("message", "setup theme setSV error.");
                        super.callJs(string2, jSONObject5.toString());
                        return;
                    }
                    super.onResponse(bundle);
                } catch (Throwable th5) {
                    QLog.e(TAG, 1, "onResponse Throwable cmd:" + string + ", msg\uff1a" + QLog.getStackTraceString(th5));
                    callJsOnError(string2, th5.getMessage());
                }
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
    public synchronized void startDownload(JSONObject jSONObject, final String str, ThemeLocator themeLocator, final String str2) {
        String str3;
        JSONException jSONException;
        int i3;
        final String optString;
        final String optString2;
        int optInt;
        int optInt2;
        try {
            try {
                optString = jSONObject.optString("version");
                optString2 = jSONObject.optString("id");
                optInt = jSONObject.optInt("size", 8000000);
                optInt2 = jSONObject.optInt(ThemeReporter.THEME_ISSOUND, 0);
                if (QLog.isColorLevel()) {
                    try {
                        QLog.d(TAG, 2, "startDownload theme ver=" + optString + ",themeid=" + optString2 + ",size=" + optInt + ",isSound=" + optInt2);
                    } catch (JSONException e16) {
                        jSONException = e16;
                        i3 = 1;
                        str3 = str;
                    }
                }
                try {
                } catch (JSONException e17) {
                    str3 = str;
                    jSONException = e17;
                    i3 = 1;
                }
            } catch (JSONException e18) {
                str3 = str;
                jSONException = e18;
                i3 = 1;
            }
        } catch (Exception e19) {
            super.callJsOnError(str, e19.getMessage());
            QLog.e(TAG, 1, "startDownload Exception\uff1a" + e19.getMessage());
            reportTheme(null, 0, "", 0L, null, null, "200", 153, ThemeReporter.PATH_DOWNLOAD, -35, "", "");
        }
        if (TextUtils.isEmpty(optString2)) {
            QLog.e(TAG, 1, "startDownload into data Error: version=" + optString + ",themeid=" + optString2 + ",size=" + optInt + ",isSound=" + optInt2);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("result", -8);
            jSONObject2.put("message", "themeid = null.");
            super.callJs(str, jSONObject2.toString());
            reportTheme(null, 0, optString2, 0L, null, null, "200", 153, ThemeReporter.PATH_DOWNLOAD, -8, optString, "");
            return;
        }
        ThemeUtil.ThemeInfo themeInfo = ThemeUtil.getThemeInfo(this.context, optString2);
        boolean z16 = themeLocator != null && themeLocator.isUnzipDirExist();
        boolean z17 = themeLocator != null && themeLocator.isZipExist();
        if (!z16 && !z17) {
            boolean z18 = optInt2 == 1;
            try {
                boolean z19 = !jSONObject.optBoolean(ThemeReporter.BUNDLE_KEY_WITHOUT_NET_TIPS, false);
                this.reportMap.put(Integer.valueOf((optString2 + "_" + optString).hashCode()), ThemeReporter.PATH_DOWNLOAD);
                int systemNetwork = NetworkUtil.getSystemNetwork(this.context);
                if (z19 && systemNetwork > 1) {
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 2, "not wifi network");
                    }
                    final boolean z26 = z18;
                    if (com.tencent.mobileqq.vip.d.i(this.mRuntime.a(), 2, new d.b() { // from class: com.tencent.mobileqq.vaswebviewplugin.ThemeJsPlugin.6
                        @Override // com.tencent.mobileqq.vip.d.b
                        public void callback(int i16) {
                            if (i16 == 1 || i16 == 2) {
                                ThemeJsPlugin.this.gotoDownload(2, optString2, optString, z26, str, str2);
                            } else if (i16 == 3 || i16 == 4) {
                                ThemeJsPlugin.this.gotoDownload(-2, optString2, optString, z26, str, str2);
                            }
                        }
                    }, "ThemeDownload")) {
                        final boolean z27 = z18;
                        QQCustomDialog qQCustomDialog = new QQCustomDialog(this.mRuntime.a(), R.style.qZoneInputDialog) { // from class: com.tencent.mobileqq.vaswebviewplugin.ThemeJsPlugin.7
                            @Override // android.app.Dialog
                            public void onBackPressed() {
                                ThemeJsPlugin.this.gotoDownload(-1, optString2, optString, z27, str, str2);
                            }
                        };
                        this.dialog = qQCustomDialog;
                        qQCustomDialog.setContentView(R.layout.f167856jn);
                        this.dialog.setTitle(HardCodeUtil.qqStr(R.string.u4p));
                        this.dialog.setMessage(R.string.i0a);
                        this.dialog.setCanceledOnTouchOutside(false);
                        final boolean z28 = z18;
                        this.dialog.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.vaswebviewplugin.ThemeJsPlugin.8
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i16) {
                                ThemeJsPlugin.this.gotoDownload(-2, optString2, optString, z28, str, str2);
                            }
                        });
                        final boolean z29 = z18;
                        this.dialog.setPositiveButton(R.string.f171151ok, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.vaswebviewplugin.ThemeJsPlugin.9
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i16) {
                                ThemeJsPlugin.this.gotoDownload(2, optString2, optString, z29, str, str2);
                            }
                        });
                        this.dialog.show();
                    }
                } else {
                    gotoDownload(1, optString2, optString, z18, str, str2);
                }
            } catch (JSONException e26) {
                str3 = str;
                jSONException = e26;
                i3 = 1;
            }
        }
        if (themeInfo == null) {
            themeInfo = new ThemeUtil.ThemeInfo();
            themeInfo.themeId = optString2;
            themeInfo.zipVer = ThemeConstants.ZIP_VERSION;
            themeInfo.version = "20000000";
            themeInfo.status = "3";
            themeInfo.isVoiceTheme = optInt2 == 1;
        }
        i3 = 1;
        try {
            QLog.d(TAG, 1, "startDownload themeExist themeid=" + optString2 + ",isFileExists=" + z16 + ",isZipExist=" + z17);
            themeInfo.status = "3";
            if (themeInfo.size < 1) {
                themeInfo.size = 10L;
            }
            themeInfo.downsize = themeInfo.size;
            this.downloadThemeMap.put(optString2, themeInfo);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("result", 3);
            jSONObject3.put("message", "Download target exists in local storage.");
            super.callJs(str, jSONObject3.toString());
            reportTheme(null, 0, optString2, 0L, "VipThemeMallDowned", "HAVE", "200", 153, ThemeReporter.PATH_DOWNLOAD, 2, optString, "");
            return;
        } catch (JSONException e27) {
            str3 = str;
            jSONException = e27;
        }
        super.callJsOnError(str3, jSONException.getMessage());
        QLog.e(TAG, i3, "startDownload dialog JSONException\uff1a" + jSONException.getMessage());
        reportTheme(null, 0, "", 0L, null, null, "200", 153, ThemeReporter.PATH_DOWNLOAD, -36, "", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes35.dex */
    public class DownloadListener extends IDownloadListener.Stub {
        private final String callbackId;
        private final String setKey;
        private final long startTime = System.currentTimeMillis();

        public DownloadListener(String str, String str2) {
            this.callbackId = str;
            this.setKey = str2;
        }

        @Override // com.tencent.mobileqq.vas.aidl.IDownloadListener
        public void onProgress(String str, long j3, long j16) {
            String iDFromSCID = ThemeUtil.getIDFromSCID(str);
            if (iDFromSCID != null && !TextUtils.isEmpty(iDFromSCID)) {
                ThemeUtil.ThemeInfo themeInfo = (ThemeUtil.ThemeInfo) ThemeJsPlugin.this.downloadThemeMap.get(iDFromSCID);
                if (themeInfo != null) {
                    themeInfo.downsize = j3;
                    themeInfo.size = j16;
                    themeInfo.status = "2";
                }
                if (QLog.isColorLevel()) {
                    QLog.d(ThemeJsPlugin.TAG, 2, "onPushMsg onProgress: themeid=" + themeInfo + ", readSize:" + j3 + ", size:" + j16);
                    return;
                }
                return;
            }
            QLog.e(ThemeJsPlugin.TAG, 1, "onProgress error scid: " + str);
        }

        @Override // com.tencent.mobileqq.vas.aidl.IDownloadListener
        public void onComplete(String str, int i3) {
            String str2;
            int i16;
            QLog.d(ThemeJsPlugin.TAG, 1, "onComplete :" + i3 + ", scid " + str);
            if (i3 != 0 || str.startsWith(ThemeUpdateCallback.SCID_THEME_ZIP_PREFIX)) {
                String iDFromSCID = ThemeUtil.getIDFromSCID(str);
                if (iDFromSCID != null && !TextUtils.isEmpty(iDFromSCID)) {
                    ThemeUtil.ThemeInfo themeInfo = (ThemeUtil.ThemeInfo) ThemeJsPlugin.this.downloadThemeMap.get(iDFromSCID);
                    if (themeInfo == null) {
                        QLog.d(ThemeJsPlugin.TAG, 1, "onPushMsg null info Error :" + i3 + ", scid " + str);
                        return;
                    }
                    QLog.d(ThemeJsPlugin.TAG, 1, "onComplete :" + i3 + ", scid " + str + ", themeInfo:" + themeInfo);
                    long currentTimeMillis = System.currentTimeMillis() - this.startTime;
                    ThemeJsPlugin themeJsPlugin = ThemeJsPlugin.this;
                    themeJsPlugin.reportTheme("theme_download", 0, themeJsPlugin.currDownloadingThemeId, currentTimeMillis, "VipThemeMallDowned", FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, "200", 153, ThemeReporter.PATH_DOWNLOAD, 9, themeInfo.version, "");
                    ThemeJsPlugin.this.reportDownloadComplete(this.setKey, this.startTime, i3, -1, iDFromSCID, "");
                    if (!iDFromSCID.equals(ThemeJsPlugin.this.currDownloadingThemeId)) {
                        QLog.e(ThemeJsPlugin.TAG, 1, "onComplete not currentId: " + ThemeJsPlugin.this.currDownloadingThemeId);
                        return;
                    }
                    if (i3 == 0) {
                        themeInfo.status = "3";
                        long j3 = themeInfo.size;
                        if (j3 > 1) {
                            themeInfo.downsize = j3;
                        }
                        str2 = FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS;
                        i16 = 0;
                    } else if (i3 == 8) {
                        i16 = 5;
                        str2 = "No network access.";
                    } else {
                        str2 = "download errCode:" + i3;
                        i16 = -14;
                    }
                    if (ThemeJsPlugin.SAVE_DIY_THEME.equals(ThemeJsPlugin.this.mCurrentMethodName)) {
                        ThemeJsPlugin.this.diyThemeSetup(iDFromSCID, "20000000", this.setKey, this.callbackId);
                        return;
                    }
                    ThemeJsPlugin.this.callJs(this.callbackId, "{'result':" + i16 + ", 'message':'" + str2 + "'}");
                    return;
                }
                QLog.e(ThemeJsPlugin.TAG, 1, "onComplete error scid: " + str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportDownloadComplete(String str, long j3, int i3, int i16, String str2, String str3) {
        VasJsbCommonReport.TimeRecord timeRecord;
        if (i3 == 0) {
            reportDownloadSuccess(str, str2, System.currentTimeMillis() - j3, getThemeZipFileSize(str2));
            return;
        }
        reportDownloadFail(str, str2, System.currentTimeMillis() - j3, i3, i16, str3);
        if (TextUtils.isEmpty(str) || (timeRecord = this.report.getMSetKeyToStartTime().get(str)) == null) {
            return;
        }
        reportSetFailDownloadFail(str, str2, System.currentTimeMillis() - timeRecord.getFirstQueryTime(), i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin
    public boolean excuteEvent(String str, long j3, Map<String, Object> map) {
        if (j3 != 128) {
            if (j3 == 8589934604L) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "EVENT_THEME_POSTCHANGED");
                }
                onPostThemeChanged();
            }
            return false;
        }
        Object obj = map.get("intent");
        if (!(obj instanceof Intent)) {
            return true;
        }
        String stringExtra = ((Intent) obj).getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
        String str2 = this.mCallbackId;
        if (str2 == null) {
            return true;
        }
        this.mThemeDiyModule.albumCallback(stringExtra, str2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v51, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v52 */
    /* JADX WARN: Type inference failed for: r0v54 */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        String str4;
        int i3;
        int i16;
        String str5;
        String str6 = str2;
        if (!"theme".equals(str6) || str3 == null) {
            return false;
        }
        String str7 = str == null ? "" : str;
        this.mCurrentMethodName = str3;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleJsRequest themejs, url=" + str7 + ", pkgName=" + str6 + ", methodName=" + str3);
        }
        try {
            final JSONObject createJson = createJson(str7, strArr);
            if (createJson == null) {
                return true;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "handleJsRequest JSON = " + createJson.toString());
            }
            final String optString = createJson.optString("callback");
            if (TextUtils.isEmpty(optString)) {
                QLog.e(TAG, 1, "callback id is null, so return");
                return true;
            }
            VasCommonReporter.getHistoryJsbFeature(getNameSpace()).setValue2(str3).report();
            String optString2 = createJson.optString("id");
            if (GameCenterAPIJavaScript.QUERY_INFO.equals(str3)) {
                ThemeIPCModule.queryThemeLocation(optString2, new QueryCallback<ThemeLocator>() { // from class: com.tencent.mobileqq.vaswebviewplugin.ThemeJsPlugin.12
                    @Override // com.tencent.mobileqq.vas.theme.api.QueryCallback
                    public void postQuery(ThemeLocator themeLocator) {
                        ThemeJsPlugin.this.queryInfo(createJson, optString, themeLocator);
                    }
                });
                return true;
            }
            if ("queryLocal".equals(str3)) {
                Bundle bundle = new Bundle();
                bundle.putString("themeId", this.currDownloadingThemeId);
                sendRemoteReq(com.tencent.mobileqq.emosm.a.a("themeQueryLocal", optString, this.mOnRemoteResp.key, bundle), false, true);
                return true;
            }
            if (ColorRingJsPlugin.Method_SetUp.equals(str3)) {
                VasLogReporter.getTheme().report("web set - themeId:" + optString2);
                setup(createJson, optString, null, false);
                return true;
            }
            if ("startDownload".equals(str3)) {
                VasLogReporter.getTheme().report("web requestDownload - themeId:" + optString2);
                startDownload(createJson, optString);
                return true;
            }
            if ("stopDownload".equals(str3)) {
                String optString3 = createJson.optString("id");
                Bundle bundle2 = new Bundle();
                bundle2.putString("themeId", optString3);
                if (TextUtils.isEmpty(optString3) && optString3.equals(this.currDownloadingThemeId)) {
                    this.currDownloadingThemeId = "";
                }
                super.sendRemoteReq(com.tencent.mobileqq.emosm.a.a("stopdownload", optString, this.mOnRemoteResp.key, bundle2), false, true);
                return true;
            }
            if ("getDensity".equals(str3)) {
                String themeDensity = ThemeUtil.getThemeDensity(this.context);
                JSONObject jSONObject = new JSONObject();
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "getDensity density:" + themeDensity);
                }
                jSONObject.put("result", 0);
                jSONObject.put("density", themeDensity);
                jSONObject.put("message", "returnt density " + themeDensity);
                super.callJs(optString, jSONObject.toString());
                return true;
            }
            if ("queryWeekLoopInfo".equals(str3)) {
                sendRemoteReq(com.tencent.mobileqq.emosm.a.a("weekLoopGetData", optString, this.mOnRemoteResp.key, new Bundle()), false, true);
                return true;
            }
            try {
                if ("isSupportDynamic".equals(str3)) {
                    try {
                        Bundle bundle3 = new Bundle();
                        boolean isEnableAnimate = VasUtil.getService().getThemeSwitchManager().getIsEnableAnimate(bundle3);
                        if (isEnableAnimate) {
                            i16 = (bundle3.getBoolean(ThemeConstants.BUNDLE_KEY_DYNAMIC_SWITCH, true) && bundle3.getBoolean(ThemeConstants.BUNDLE_KEY_DYNAMIC_ENABLE, true)) ? 1 : 0;
                            i3 = (bundle3.getBoolean(ThemeConstants.BUNDLE_KEY_DYNAMIC_WEBVIEW_ENABLE, true) && i16 == 1) ? 1 : 0;
                        } else {
                            i3 = 1;
                            i16 = 1;
                        }
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("result", 0);
                        jSONObject2.put("isDeviceEnable", i16);
                        jSONObject2.put("isWebviewEnable", i3);
                        if (QLog.isColorLevel()) {
                            QLog.i(TAG, 2, "isSupportDynamic deviceEnable:" + i16 + ", webViewEnable:" + i3 + ", dpcIsOk=" + isEnableAnimate);
                        }
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("result", 0);
                        jSONObject3.put("message", "isSupportDynamic return deviceEnable:" + i16 + ", webViewEnable:" + i3 + ", dpcIsOk=" + isEnableAnimate);
                        jSONObject3.put("data", jSONObject2);
                        super.callJs(optString, jSONObject3.toString());
                        return true;
                    } catch (Throwable th5) {
                        th = th5;
                        str6 = str2;
                        str4 = ", methodName=";
                        th.printStackTrace();
                        QLog.e(TAG, 2, "handleJsRequest exception url=" + str7 + ", pkgName=" + str6 + str4 + str3 + ", msg=" + th.getMessage());
                        return true;
                    }
                }
                if (SAVE_DIY_THEME.equals(str3)) {
                    this.mCallbackId = optString;
                    String optString4 = createJson.optString(VasCommonJsbProxy.JSON_KEY_SET_KEY);
                    if (!TextUtils.isEmpty(optString4) && !this.report.getMSetKeyToStartTime().containsKey(optString4)) {
                        VasJsbCommonReport.TimeRecord timeRecord = new VasJsbCommonReport.TimeRecord(optString4, System.currentTimeMillis(), optString2, 3L);
                        this.report.getMSetKeyToStartTime().put(optString4, timeRecord);
                        reportFirstQuery(timeRecord);
                    }
                    this.mThemeDiyModule.saveDiyTheme(createJson, optString);
                    return true;
                }
                if ("getDiyCurThemeInfo".equals(str3)) {
                    super.callJs(optString, this.mThemeDiyModule.getDiyCurThemeInfo().toString());
                    return true;
                }
                if ("openAlbum".equals(str3)) {
                    this.mCallbackId = optString;
                    this.mThemeDiyModule.openAlbum(getInfoIntent(), this.mRuntime.a(), createJson.optInt("tabType"), getRequestCode((byte) 1));
                    return true;
                }
                if ("checkSimpleUISwitch".equals(str3)) {
                    ?? isNowSimpleMode = SimpleUIUtil.isNowSimpleMode();
                    boolean z16 = StudyModeManager.t() && com.tencent.mobileqq.studymode.b.a(this.app);
                    int i17 = 3;
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 2, String.format("%s checkSimpleUISwitch bSwitch=%b callback=%s ", "SimpleUILog", Boolean.valueOf((boolean) isNowSimpleMode), optString));
                    }
                    if (z16) {
                        isNowSimpleMode = 2;
                    }
                    if (!SimpleUIUtil.isNowElderMode()) {
                        i17 = isNowSimpleMode;
                    }
                    super.callJs(optString, String.valueOf(i17));
                    return true;
                }
                if ("isSysCustomFont".equals(str3)) {
                    boolean isSysCustomFont = TextHook.isSysCustomFont(this.mRuntime.a());
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 2, "isSysCustomFont:" + isSysCustomFont);
                    }
                    String[] strArr2 = new String[1];
                    if (isSysCustomFont) {
                        str5 = "1";
                    } else {
                        str5 = "0";
                    }
                    strArr2[0] = str5;
                    super.callJs(optString, strArr2);
                    return true;
                }
                if ("setupfont".equals(str3)) {
                    int optInt = createJson.optInt("themefontid");
                    VasLogReporter.getTheme().reportHighest("theme_font set to " + optInt);
                    VasUtil.getService().getVasThemeFontApi().switchFont(optInt);
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("result", 1);
                    String optString5 = createJson.optString(VasCommonJsbProxy.JSON_KEY_SET_KEY);
                    this.report.reportSetEndSetSuccess(optString5, String.valueOf(optInt), this.report.getMSetKeyToStartTime().get(optString5) != null ? System.currentTimeMillis() - this.report.getMSetKeyToStartTime().get(optString5).getFirstQueryTime() : 0L);
                    super.callJs(optString, jSONObject4.toString());
                    return true;
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append("handleJsRequest error url=");
                sb5.append(str7);
                sb5.append(", pkgName=");
                str6 = str2;
                try {
                    sb5.append(str6);
                    str4 = ", methodName=";
                } catch (Throwable th6) {
                    th = th6;
                    str4 = ", methodName=";
                    th.printStackTrace();
                    QLog.e(TAG, 2, "handleJsRequest exception url=" + str7 + ", pkgName=" + str6 + str4 + str3 + ", msg=" + th.getMessage());
                    return true;
                }
                try {
                    sb5.append(str4);
                    sb5.append(str3);
                    QLog.e(TAG, 2, sb5.toString());
                    return true;
                } catch (Throwable th7) {
                    th = th7;
                    th.printStackTrace();
                    QLog.e(TAG, 2, "handleJsRequest exception url=" + str7 + ", pkgName=" + str6 + str4 + str3 + ", msg=" + th.getMessage());
                    return true;
                }
            } catch (Throwable th8) {
                th = th8;
                str6 = str2;
            }
        } catch (Throwable th9) {
            th = th9;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0208 A[Catch: all -> 0x022b, TRY_LEAVE, TryCatch #1 {all -> 0x022b, blocks: (B:3:0x000c, B:5:0x0021, B:7:0x002d, B:8:0x004a, B:11:0x0053, B:12:0x0069, B:21:0x01ff, B:23:0x0208), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0140 A[Catch: all -> 0x0227, TRY_LEAVE, TryCatch #0 {all -> 0x0227, blocks: (B:16:0x009b, B:18:0x00a1, B:19:0x01eb, B:30:0x00b6, B:31:0x00bb, B:34:0x00db, B:36:0x00eb, B:37:0x00fa, B:40:0x010b, B:42:0x0113, B:44:0x0119, B:46:0x013a, B:48:0x0140, B:51:0x0158, B:52:0x0167, B:55:0x0171, B:57:0x0179, B:58:0x017f, B:59:0x0181, B:61:0x018c, B:62:0x018e, B:64:0x019d, B:65:0x01c2, B:67:0x01ca, B:68:0x01dd), top: B:14:0x0099 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0153  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void queryInfo(JSONObject jSONObject, String str, ThemeLocator themeLocator) {
        final String optString;
        final String optString2;
        boolean z16;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        QQVasUpdateBusiness<?> newBusiness;
        ThemeUtil.ThemeInfo themeInfo;
        boolean z17;
        int i3;
        String str2 = str;
        try {
            optString = jSONObject.optString(VasCommonJsbProxy.JSON_KEY_SET_KEY);
            optString2 = jSONObject.optString("id");
            if (TextUtils.isEmpty(optString) || this.report.getMSetKeyToStartTime().containsKey(optString)) {
                z16 = false;
            } else {
                VasJsbCommonReport.TimeRecord timeRecord = new VasJsbCommonReport.TimeRecord(optString, System.currentTimeMillis(), optString2, 3L);
                this.report.getMSetKeyToStartTime().put(optString, timeRecord);
                reportFirstQuery(timeRecord);
                z16 = true;
            }
            if (TextUtils.isEmpty(optString2)) {
                QLog.e(TAG, 1, "queryInfo err themeId=null\uff1a" + optString2);
                optString2 = "1000";
            }
            jSONObject2 = new JSONObject();
            jSONObject3 = new JSONObject();
            jSONObject3.put("result", 0);
            jSONObject3.put("message", FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
            newBusiness = getNewBusiness();
            themeInfo = null;
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            if (newBusiness != null) {
                if ("1000".equals(optString2)) {
                    jSONObject2.put("status", Integer.parseInt("3"));
                    jSONObject2.put("version", 0);
                    jSONObject2.put("progress", 100);
                    i3 = 2;
                    jSONObject3.put("data", jSONObject2);
                    str2 = str;
                    super.callJs(str2, jSONObject3.toString());
                    if (QLog.isColorLevel()) {
                        return;
                    }
                    QLog.i(TAG, i3, "queryInfo,themeId=" + optString2 + "result=" + jSONObject3);
                    return;
                }
                int a16 = com.tencent.mobileqq.webview.js.a.a(Integer.parseInt(optString2), newBusiness, z16 ? new IDownLoadListener() { // from class: com.tencent.mobileqq.vaswebviewplugin.ThemeJsPlugin.11
                    final long downloadStartTime = System.currentTimeMillis();

                    @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
                    public void onLoadFail(UpdateListenerParams updateListenerParams) {
                        ThemeJsPlugin.this.reportDownloadComplete(optString, this.downloadStartTime, updateListenerParams.mErrorCode, updateListenerParams.mHttpCode, optString2, updateListenerParams.mErrorMessage);
                    }

                    @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
                    public void onLoadSuccess(UpdateListenerParams updateListenerParams) {
                        long j3 = this.downloadStartTime;
                        VasJsbCommonReport.TimeRecord timeRecord2 = ThemeJsPlugin.this.report.getMSetKeyToStartTime().get(optString);
                        if (timeRecord2 != null) {
                            j3 = timeRecord2.getFirstQueryTime();
                        }
                        ThemeJsPlugin.this.reportDownloadComplete(optString, j3, 0, 0, optString2, "");
                    }
                } : null);
                VasJsbCommonReport.reportPreDownload(optString, newBusiness, Integer.parseInt(optString2), a16, z16, "themejsb");
                if (a16 == 3) {
                    jSONObject2.put("status", Integer.parseInt("3"));
                    jSONObject2.put("version", "20000000");
                    jSONObject2.put("progress", 100);
                } else {
                    jSONObject2.put("status", Integer.parseInt("2"));
                    jSONObject2.put("version", "20000000");
                    jSONObject2.put("progress", 0);
                }
                i3 = 2;
                jSONObject3.put("data", jSONObject2);
                str2 = str;
                super.callJs(str2, jSONObject3.toString());
                if (QLog.isColorLevel()) {
                }
            } else {
                ThemeUtil.ThemeInfo themeInfo2 = this.downloadThemeMap.get(optString2);
                if (!"1000".equals(optString2)) {
                    if (themeInfo2 == null) {
                        themeInfo2 = ThemeUtil.getThemeInfo(this.context, optString2);
                        if (themeLocator == null || !themeLocator.isZipExist()) {
                            QLog.e(TAG, 1, "queryInfo zip is missing: " + themeLocator);
                            ThemeUtil.removeThemeInfo(this.context, optString2);
                            z17 = false;
                            if ("1000".equals(optString2)) {
                                jSONObject2.put("status", Integer.parseInt("3"));
                                jSONObject2.put("version", 0);
                                jSONObject2.put("progress", 100);
                            } else if (themeInfo == null) {
                                jSONObject2.put("status", Integer.parseInt("1"));
                                jSONObject2.put("version", 0);
                                jSONObject2.put("progress", 0);
                            } else {
                                if ("2".equals(themeInfo.status)) {
                                    if (z17) {
                                        if (!optString2.equals(this.currDownloadingThemeId)) {
                                            themeInfo.status = "4";
                                        }
                                    } else {
                                        themeInfo.status = "1";
                                    }
                                }
                                if ("5".equals(themeInfo.status)) {
                                    themeInfo.status = "3";
                                }
                                jSONObject2.put("status", Integer.parseInt(themeInfo.status));
                                if (QLog.isColorLevel()) {
                                    i3 = 2;
                                    QLog.i(TAG, 2, "queryInfo downsize:" + themeInfo.downsize + ",size:" + themeInfo.size);
                                } else {
                                    i3 = 2;
                                }
                                long j3 = themeInfo.size;
                                int min = Math.min(j3 > 0 ? (int) Math.floor(((themeInfo.downsize * 1.0d) / j3) * 100.0d) : 0, 100);
                                jSONObject2.put("version", themeInfo.version);
                                jSONObject2.put("progress", min);
                                jSONObject3.put("data", jSONObject2);
                                str2 = str;
                                super.callJs(str2, jSONObject3.toString());
                                if (QLog.isColorLevel()) {
                                }
                            }
                            i3 = 2;
                            jSONObject3.put("data", jSONObject2);
                            str2 = str;
                            super.callJs(str2, jSONObject3.toString());
                            if (QLog.isColorLevel()) {
                            }
                        }
                    } else {
                        themeInfo = themeInfo2;
                        z17 = true;
                        if ("1000".equals(optString2)) {
                        }
                        i3 = 2;
                        jSONObject3.put("data", jSONObject2);
                        str2 = str;
                        super.callJs(str2, jSONObject3.toString());
                        if (QLog.isColorLevel()) {
                        }
                    }
                }
                themeInfo = themeInfo2;
                z17 = false;
                if ("1000".equals(optString2)) {
                }
                i3 = 2;
                jSONObject3.put("data", jSONObject2);
                str2 = str;
                super.callJs(str2, jSONObject3.toString());
                if (QLog.isColorLevel()) {
                }
            }
        } catch (Throwable th6) {
            th = th6;
            str2 = str;
            QLog.e(TAG, 1, "queryInfo Exception\uff1a" + th.getMessage());
            super.callJsOnError(str2, th.getMessage());
            reportTheme(null, 0, "", 0L, null, null, "200", 152, ThemeReporter.PATH_DOWNLOAD, -35, "1", "");
        }
    }

    public void setup(JSONObject jSONObject, String str, Bundle bundle, boolean z16) {
        String str2;
        String str3;
        if (z16) {
            str2 = ThemeReporter.FROM_DIY;
        } else {
            str2 = "200";
        }
        try {
            String str4 = str2;
            String optString = jSONObject.optString("id");
            String optString2 = jSONObject.optString("version", "0");
            String optString3 = jSONObject.optString(VasCommonJsbProxy.JSON_KEY_SET_KEY);
            removeTimeoutDelayTask(optString3);
            int optInt = jSONObject.optInt(ThemeReporter.THEME_ISSOUND, 0);
            String optString4 = jSONObject.optString("seriesID", null);
            JSONArray optJSONArray = jSONObject.optJSONArray("themeArray");
            long optLong = jSONObject.optLong("startTime", 0L) * 1000;
            if (!TextUtils.isEmpty(optString) && (TextUtils.isEmpty(optString4) || (optJSONArray != null && optJSONArray.length() >= 1))) {
                String currentThemeId = ThemeUtil.getCurrentThemeId();
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "ThemeJsHandler setup,themeId=" + optString + MttLoader.QQBROWSER_PARAMS_VERSION + optString2 + ",isSound=" + optInt + " isDiyTheme:" + z16 + " currentThemeId:" + currentThemeId);
                }
                if (optString.equals(currentThemeId) && !z16) {
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 2, "ThemeJsHandler setup the same theme,themeId=" + optString + MttLoader.QQBROWSER_PARAMS_VERSION + optString2);
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("result", 0);
                    jSONObject2.put("message", "set the same theme");
                    super.callJs(str, jSONObject2.toString());
                    if (this.reportMap.containsKey(Integer.valueOf((optString + "_" + optString2).hashCode()))) {
                        str3 = this.reportMap.get(Integer.valueOf((optString + "_" + optString2).hashCode()));
                    } else {
                        str3 = ThemeReporter.PATH_SETPUP;
                    }
                    reportTheme(null, 1, optString, 0L, null, null, "200", 155, str3, 23, optString2, "0");
                    reportThemeSetSuccess(optString3, optString, 0L);
                    VasJsbCommonReport.TimeRecord timeRecord = this.report.getMSetKeyToStartTime().get(optString3);
                    if (timeRecord != null) {
                        reportSetComplete(optString3, optString, System.currentTimeMillis() - timeRecord.getFirstQueryTime());
                        return;
                    }
                    return;
                }
                try {
                    try {
                        synchronized (this.mLock) {
                            try {
                                ThemeUtil.ThemeInfo themeInfo = ThemeUtil.getThemeInfo(this.context, optString);
                                if (themeInfo == null) {
                                    themeInfo = new ThemeUtil.ThemeInfo();
                                    themeInfo.themeId = optString;
                                    themeInfo.version = optString2;
                                    if ("1000".equals(optString)) {
                                        themeInfo.status = "5";
                                    }
                                    ThemeUtil.setThemeInfo(this.context, themeInfo);
                                }
                                this.mThemeinfo = themeInfo;
                                themeInfo.seriesID = optString4;
                                themeInfo.themeArray = optJSONArray;
                                themeInfo.startTime = optLong;
                            } catch (Throwable th5) {
                                th = th5;
                            }
                            try {
                                this.mCallbackId = str;
                                if ("1103".equals(optString)) {
                                    this.mThemeDiyModule.setSpThemeBackground();
                                    ThemeIPCModule.startSwitch(optString, new ThemeSwitchListener(optString, true));
                                } else {
                                    this.mThemeToSetKey.put(optString, optString3);
                                    VasJsbCommonReport.TimeRecord timeRecord2 = this.report.getMSetKeyToStartTime().get(optString3);
                                    if (timeRecord2 != null) {
                                        timeRecord2.setSetupTime(System.currentTimeMillis());
                                    }
                                    Bundle bundle2 = bundle == null ? new Bundle() : bundle;
                                    bundle2.putString("themeId", optString);
                                    bundle2.putString("seriesID", optString4);
                                    if (VasToggle.FEATURE_THEME_REQUEST.isEnable(true)) {
                                        requestServerAndChangeTheme(str, bundle2, optString);
                                    } else {
                                        super.sendRemoteReq(com.tencent.mobileqq.emosm.a.a("setSVTheme", str, this.mOnRemoteResp.key, bundle2), false, true);
                                    }
                                }
                                if (QLog.isColorLevel()) {
                                    QLog.i(TAG, 2, "setup server :id:" + optString);
                                    return;
                                }
                                return;
                            } catch (Throwable th6) {
                                th = th6;
                                throw th;
                            }
                        }
                    } catch (Throwable th7) {
                        th = th7;
                    }
                } catch (Throwable th8) {
                    th = th8;
                    callJsOnError(str, th.getMessage());
                    QLog.e(TAG, 1, "setup theme error:" + th.getMessage());
                    return;
                }
            }
            QLog.e(TAG, 1, "ThemeJsHandler setup setWeekLoopThemeArray err,seriesID=" + optString4 + ",themeArray=" + optJSONArray);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("result", 1);
            jSONObject3.put("message", "seriesID || themeArray data error");
            super.callJs(str, jSONObject3.toString());
            reportTheme(null, 0, optString, 0L, null, null, str4, 155, ThemeReporter.PATH_DOWNLOAD, -8, optString2, "");
        } catch (Throwable th9) {
            th = th9;
        }
    }

    void gotoDownload(int i3, String str, String str2, boolean z16, String str3, String str4) {
        int i16;
        int i17;
        String str5;
        QQCustomDialog qQCustomDialog;
        QQCustomDialog qQCustomDialog2;
        ThemeJsPlugin themeJsPlugin = this;
        if (i3 < 0) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "not wifi network cancel download dialog=" + themeJsPlugin.dialog);
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("result", 2);
                jSONObject.put("message", "user cancel download theme in not wifi network");
                themeJsPlugin.callJs(str3, jSONObject.toString());
                String str6 = ThemeReporter.PATH_DOWNLOAD;
                str5 = TAG;
                try {
                    reportTheme(null, 0, str, 0L, "VipThemeMallDowned", "Cancel", "200", 153, str6, 10, str2, "");
                    if (i3 != -1 || (qQCustomDialog2 = this.dialog) == null) {
                        return;
                    }
                } catch (Exception e16) {
                    e = e16;
                    i16 = -1;
                    i17 = i3;
                    themeJsPlugin = this;
                    try {
                        QLog.e(str5, 2, "gotoDownload isCancel err:" + e.getMessage());
                        if (i17 != i16 || (qQCustomDialog2 = themeJsPlugin.dialog) == null) {
                            return;
                        }
                        qQCustomDialog2.dismiss();
                        return;
                    } catch (Throwable th5) {
                        th = th5;
                        if (i17 == i16 && (qQCustomDialog = themeJsPlugin.dialog) != null) {
                            qQCustomDialog.dismiss();
                        }
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    i16 = -1;
                    i17 = i3;
                    themeJsPlugin = this;
                    if (i17 == i16) {
                        qQCustomDialog.dismiss();
                    }
                    throw th;
                }
            } catch (Exception e17) {
                e = e17;
                i16 = -1;
                str5 = TAG;
                i17 = i3;
            } catch (Throwable th7) {
                th = th7;
                i16 = -1;
                i17 = i3;
            }
            qQCustomDialog2.dismiss();
            return;
        }
        ThemeUtil.ThemeInfo themeInfo = themeJsPlugin.downloadThemeMap.get(str);
        if (themeInfo == null) {
            themeInfo = ThemeUtil.getThemeInfo(themeJsPlugin.context, str);
        }
        if (themeInfo == null) {
            themeInfo = new ThemeUtil.ThemeInfo();
            themeInfo.themeId = str;
        }
        themeInfo.isVoiceTheme = z16;
        ThemeUtil.setThemeInfo(themeJsPlugin.context, themeInfo);
        themeJsPlugin.downloadThemeMap.put(str, themeInfo);
        themeJsPlugin.currDownloadingThemeId = str;
        loadingThemeIdForJsCall = str;
        reportTheme(null, 0, str, 0L, null, null, "200", 153, ThemeReporter.PATH_DOWNLOAD, 11, str2, "");
        if (getNewBusiness() != null) {
            themeJsPlugin.requestDownloadTheme(str3, str4, str);
        } else {
            QuickUpdateIPCModule.download(3L, ThemeUtil.getThemeConfigID(str), new DownloadListener(str3, str4));
        }
    }

    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin
    void onPushMsg(Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes35.dex */
    public class ThemeSwitchListener extends ISwitchCallback.Stub {
        private final boolean needSetCurrent;
        private final String themeId;

        public ThemeSwitchListener(String str, boolean z16) {
            this.themeId = str;
            this.needSetCurrent = z16;
        }

        @Override // com.tencent.mobileqq.vas.aidl.ISwitchCallback
        public void beginSwitch() {
            VasUtil.getService().getThemeSwitchManager().openSwitchDialog(ThemeJsPlugin.this.mRuntime.a());
        }

        @Override // com.tencent.mobileqq.vas.aidl.ISwitchCallback
        public void doSwitch(final String str, final String str2) throws RemoteException {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.vaswebviewplugin.ThemeJsPlugin.ThemeSwitchListener.1
                @Override // java.lang.Runnable
                public void run() {
                    VasUtil.getService().getThemeSwitchManager().doScreenShot();
                    SkinEngine.getInstances().setSkinRootPath(ThemeJsPlugin.this.app.getApp(), str2);
                    VasLogReporter.getTheme().report("ThemeJsPlugin theme_skin_engine[themeId:" + str + "]");
                    ThemeUtil.setCurrentThemeIdVersion(ThemeJsPlugin.this.app, str, "20000000");
                    QUIResourcesTransform.getInstance().onThemeUpdate(str, str2);
                    ThemeSwitchListener.this.postSwitch(0);
                }
            });
        }

        /* JADX WARN: Can't wrap try/catch for region: R(8:1|(1:48)|4|(2:6|(2:8|9)(2:11|(5:13|(1:25)(1:17)|18|(1:23)|24)))(5:36|(3:38|(1:40)|41)(2:42|(1:47)(1:46))|27|28|(2:30|31)(1:32))|26|27|28|(0)(0)) */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x014b, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x014c, code lost:
        
            r1 = r11.this$0;
            r1.callJsOnError(r1.mCallbackId, r0.getMessage());
         */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0159  */
        /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
        @Override // com.tencent.mobileqq.vas.aidl.ISwitchCallback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void postSwitch(int i3) {
            int i16 = 2;
            if (QLog.isColorLevel() || i3 != 0) {
                QLog.i(ThemeJsPlugin.TAG, 2, "themeSwitchListener,themeId=" + this.themeId + ",stateCode=" + i3);
            }
            ThemeJsPlugin.this.reportThemeSwitch(this.themeId, i3);
            String str = "set skin theme back:" + i3;
            if (i3 == 0) {
                if (ThemeJsPlugin.SAVE_DIY_THEME.equals(ThemeJsPlugin.this.mCurrentMethodName)) {
                    ThemeJsPlugin themeJsPlugin = ThemeJsPlugin.this;
                    themeJsPlugin.callJs(themeJsPlugin.mCallbackId, new JSONResult(0, "set skin theme back:" + i3).toJsonString());
                    return;
                }
                if (this.needSetCurrent) {
                    Bundle bundle = new Bundle();
                    bundle.putString("themeId", this.themeId);
                    bundle.putBoolean("needSaveSp", false);
                    ThemeUtil.ThemeInfo themeInfo = ThemeJsPlugin.this.mThemeinfo;
                    String str2 = themeInfo.seriesID;
                    JSONArray jSONArray = themeInfo.themeArray;
                    long j3 = themeInfo.startTime;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("ThemeJsHandler switchThemeTask onPostExecute themeId=");
                    sb5.append(this.themeId);
                    sb5.append(",seriesID");
                    sb5.append(str2);
                    sb5.append(",themeArray:");
                    sb5.append(jSONArray != null && jSONArray.length() > 0);
                    QLog.i(ThemeJsPlugin.TAG, 1, sb5.toString());
                    if (!TextUtils.isEmpty(str2) && jSONArray != null && jSONArray.length() > 0) {
                        bundle.putString("seriesID", str2);
                        bundle.putString("themeArray", jSONArray.toString());
                        bundle.putLong("startTime", j3);
                    }
                    ThemeJsPlugin.this.sendRemoteReq(com.tencent.mobileqq.emosm.a.a("themeSwitchSucess", "", ThemeJsPlugin.this.mOnRemoteResp.key, bundle), false, true);
                }
            } else {
                if (i3 == 3) {
                    if (QLog.isColorLevel()) {
                        QLog.i(ThemeJsPlugin.TAG, 2, "ThemeJsHandler return because setupping.");
                    }
                    str = "is switching theme";
                } else if (i3 != -202 && i3 != -201) {
                    QLog.e(ThemeJsPlugin.TAG, 1, "themeSwitchListener ret = false");
                    i16 = -1;
                } else {
                    QLog.d(ThemeJsPlugin.TAG, 1, "themeSwitchListener ret = true");
                }
                ThemeJsPlugin themeJsPlugin2 = ThemeJsPlugin.this;
                themeJsPlugin2.callJs(themeJsPlugin2.mCallbackId, new JSONResult(i16, str).toJsonString());
                if (i3 == 0) {
                    VasUtil.getService().getThemeSwitchManager().clearOnErr(i3);
                    return;
                }
                return;
            }
            i16 = 0;
            ThemeJsPlugin themeJsPlugin22 = ThemeJsPlugin.this;
            themeJsPlugin22.callJs(themeJsPlugin22.mCallbackId, new JSONResult(i16, str).toJsonString());
            if (i3 == 0) {
            }
        }

        @Override // com.tencent.mobileqq.vas.aidl.ISwitchCallback
        public void onProgress(long j3, long j16) throws RemoteException {
        }
    }
}
