package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.vas.VasLogReporter;
import com.tencent.mobileqq.vas.aidl.ISwitchCallback;
import com.tencent.mobileqq.vas.report.VasJsbCommonReport;
import com.tencent.mobileqq.vas.theme.QUIResourcesTransform;
import com.tencent.mobileqq.vas.theme.ThemeIPCModule;
import com.tencent.mobileqq.vas.theme.ThemeSwitchUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import eipc.EIPCCallback;
import eipc.EIPCResult;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes20.dex */
public class ThemeNewJsbPlugin {
    private static final String TAG = "ThemeSetUp";
    static final int THEME_OPTION_ERROR = -1;
    static final int THEME_OPTION_PKG_UNZIP_ERROR = 2;
    static final int THEME_OPTION_SUCCESS = 0;
    private final WebViewPlugin.b mRuntime;
    private final WebViewPlugin plugin;
    private final VasJsbCommonReport report = VasJsbCommonReport.INSTANCE;
    private String mCallbackId = "";
    private String mCurThemeId = "";
    private final ConcurrentHashMap<String, String> mThemeToSetKey = new ConcurrentHashMap<>();

    public ThemeNewJsbPlugin(WebViewPlugin webViewPlugin) {
        this.mRuntime = webViewPlugin.mRuntime;
        this.plugin = webViewPlugin;
    }

    private void applyTheme(final String str, final String str2) {
        VasUtil.getService().getJsbCallManager().detailWithDarkMode(str, new EIPCCallback.Stub() { // from class: com.tencent.mobileqq.vaswebviewplugin.ThemeNewJsbPlugin.1
            @Override // eipc.EIPCCallback
            public void callback(EIPCResult eIPCResult) throws RemoteException {
                if (!TextUtils.isEmpty(str2) && str2.equals(ThemeNewJsbPlugin.this.mCallbackId) && !TextUtils.isEmpty(str) && str.equals(ThemeNewJsbPlugin.this.mCurThemeId)) {
                    boolean equals = eIPCResult.data.getString("choose", MiniProgramLpReportDC04239.NORMAL_URL_DIALOG_CONFIRM).equals(MiniProgramLpReportDC04239.NORMAL_URL_DIALOG_CONFIRM);
                    if (equals && !SimpleUIUtil.getSimpleUISwitch()) {
                        VasLogReporter.getTheme().reportHighest("web change theme");
                        String str3 = str;
                        ThemeIPCModule.startSwitch(str3, new ThemeSwitchListener(str3, true));
                        return;
                    }
                    VasLogReporter.getTheme().reportHighest("web nochange theme : isConfirm=" + equals);
                    if (!ThemeUtil.isFixTheme(str)) {
                        ThemeSwitchUtil.setPreviousThemeIdVersion(ThemeNewJsbPlugin.this.mRuntime.b(), str, "20000000");
                    }
                    new ThemeSwitchListener(str, false).postSwitch(0);
                    return;
                }
                QLog.e(ThemeNewJsbPlugin.TAG, 1, "delay callback");
            }
        });
    }

    private QQVasUpdateBusiness<?> getNewBusiness() {
        if (QQVasUpdateBusiness.isUseUpdateBusinessMigration(3L).booleanValue()) {
            try {
                return QQVasUpdateBusiness.getBusiness(3L);
            } catch (Exception e16) {
                QLog.e(TAG, 1, "getNewBusiness Exception\uff1a" + e16.getMessage());
                return null;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportThemeSwitch(String str, int i3) {
        VasJsbCommonReport.TimeRecord timeRecord;
        String remove = this.mThemeToSetKey.remove(str);
        if (!TextUtils.isEmpty(remove) && (timeRecord = this.report.getMSetKeyToStartTime().get(remove)) != null) {
            if (i3 == 0) {
                this.report.reportSingleStepSuccess(remove, timeRecord.getSetupId(), System.currentTimeMillis() - timeRecord.getSetupTime(), 2);
                this.report.reportSetEndSetSuccess(remove, str, System.currentTimeMillis() - timeRecord.getFirstQueryTime());
            } else {
                this.report.reportSingleStepFail(remove, str, System.currentTimeMillis() - timeRecord.getSetupTime(), i3, 5);
                this.report.reportSetEndSetFail(remove, str, System.currentTimeMillis() - timeRecord.getFirstQueryTime(), i3);
            }
        }
    }

    public void postThemeChange() {
        if (getNewBusiness() != null && !TextUtils.isEmpty(this.mCallbackId) && TextUtils.equals(this.mCurThemeId, ThemeUtil.getCurrentThemeId())) {
            reportThemeSwitch(this.mCurThemeId, 0);
            this.plugin.callJs(this.mCallbackId, new w33.b(0, "set skin theme back:0").toString());
        }
    }

    public void setup(String str, String str2, String str3) {
        try {
            String currentThemeId = ThemeUtil.getCurrentThemeId();
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "ThemeJsHandler setup,themeId=" + str + " currentThemeId:" + currentThemeId);
            }
            this.report.removeTimeoutDelayTask(str2);
            if (currentThemeId.equals(str)) {
                w33.b bVar = new w33.b(0, "set the same theme");
                this.report.reportSingleStepSuccess(str2, str, 0L, 2);
                VasJsbCommonReport.TimeRecord timeRecord = this.report.getMSetKeyToStartTime().get(str2);
                if (timeRecord != null) {
                    this.report.reportSetEndSetSuccess(str2, str, System.currentTimeMillis() - timeRecord.getFirstQueryTime());
                }
                this.plugin.callJs(str3, bVar.toString());
                return;
            }
            if ("1103".equals(str)) {
                ThemeIPCModule.startSwitch(str, new ThemeSwitchListener(str, true));
                return;
            }
            this.mCallbackId = str3;
            this.mCurThemeId = str;
            this.mThemeToSetKey.put(str, str2);
            VasJsbCommonReport.TimeRecord timeRecord2 = this.report.getMSetKeyToStartTime().get(str2);
            if (timeRecord2 != null) {
                timeRecord2.setSetupTime(System.currentTimeMillis());
            }
            Bundle bundle = new Bundle();
            bundle.putString("themeId", str);
            bundle.putString("seriesID", null);
            applyTheme(str, str3);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "setup theme error:" + th5.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public class ThemeSwitchListener extends ISwitchCallback.Stub {
        private final boolean needSetCurrent;
        private final String themeId;

        public ThemeSwitchListener(String str, boolean z16) {
            this.themeId = str;
            this.needSetCurrent = z16;
        }

        @Override // com.tencent.mobileqq.vas.aidl.ISwitchCallback
        public void beginSwitch() {
            VasUtil.getService().getThemeSwitchManager().openSwitchDialog(ThemeNewJsbPlugin.this.mRuntime.a());
        }

        @Override // com.tencent.mobileqq.vas.aidl.ISwitchCallback
        public void doSwitch(final String str, final String str2) throws RemoteException {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.vaswebviewplugin.ThemeNewJsbPlugin.ThemeSwitchListener.1
                @Override // java.lang.Runnable
                public void run() {
                    VasUtil.getService().getThemeSwitchManager().doScreenShot();
                    SkinEngine.getInstances().setSkinRootPath(ThemeNewJsbPlugin.this.mRuntime.c().getApp(), str2);
                    VasLogReporter.getTheme().report("ThemeJsPlugin theme_skin_engine[themeId:" + str + "]");
                    ThemeUtil.setCurrentThemeIdVersion(ThemeNewJsbPlugin.this.mRuntime.c(), str, "20000000");
                    QUIResourcesTransform.getInstance().onThemeUpdate(str, str2);
                    ThemeSwitchListener.this.postSwitch(0);
                }
            });
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0088  */
        @Override // com.tencent.mobileqq.vas.aidl.ISwitchCallback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void postSwitch(int i3) {
            int i16 = 2;
            if (QLog.isColorLevel() || i3 != 0) {
                QLog.i(ThemeNewJsbPlugin.TAG, 2, "themeSwitchListener,themeId=" + this.themeId + ",stateCode=" + i3);
            }
            ThemeNewJsbPlugin.this.reportThemeSwitch(this.themeId, i3);
            String str = "set skin theme back:" + i3;
            if (i3 == 0) {
                if (this.needSetCurrent) {
                    VasUtil.getService().getJsbCallManager().setThemeAndBackGround(this.themeId);
                }
            } else {
                if (i3 == 3) {
                    if (QLog.isColorLevel()) {
                        QLog.i(ThemeNewJsbPlugin.TAG, 2, "ThemeJsHandler return because setupping.");
                    }
                    str = "is switching theme";
                } else if (i3 != -202 && i3 != -201) {
                    QLog.e(ThemeNewJsbPlugin.TAG, 1, "themeSwitchListener ret = false");
                    i16 = -1;
                } else {
                    QLog.d(ThemeNewJsbPlugin.TAG, 1, "themeSwitchListener ret = true");
                }
                if (i3 != 0) {
                    VasUtil.getService().getThemeSwitchManager().clearOnErr(i3);
                }
                ThemeNewJsbPlugin.this.plugin.callJs(ThemeNewJsbPlugin.this.mCallbackId, new w33.b(i16, str).toString());
            }
            i16 = 0;
            if (i3 != 0) {
            }
            ThemeNewJsbPlugin.this.plugin.callJs(ThemeNewJsbPlugin.this.mCallbackId, new w33.b(i16, str).toString());
        }

        @Override // com.tencent.mobileqq.vas.aidl.ISwitchCallback
        public void onProgress(long j3, long j16) throws RemoteException {
        }
    }
}
