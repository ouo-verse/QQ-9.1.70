package com.tencent.mobileqq.vaswebviewplugin;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import org.json.JSONObject;

/* loaded from: classes20.dex */
public class ThemeUiPlugin extends VasWebviewUiPlugin {
    public static final String EXTRA_THEME_ID = "extra_theme_id";
    public static final String REPORT_COPYCAT_THEME_DOWNLOAD_TAG = "report_copycat_theme_file_download";
    public static final int REPORT_THEME_DOWNLOAD_CONTENT_RANGE_IILEGAL = 89065;
    public static final int REPORT_THEME_DOWNLOAD_DATA_WRONG = 89068;
    public static final int REPORT_THEME_DOWNLOAD_MKDIR_FAILED = 89069;
    public static final int REPORT_THEME_DOWNLOAD_NOT_EQUAL = 89066;
    public static final int REPORT_THEME_DOWNLOAD_RENAME_FAILED = 89067;
    public static final String REPORT_THEME_DOWNLOAD_TAG = "report_theme_file_download";
    static final int REPORT_THEME_INFO = 1;
    private static final String TAG = "ThemeUiPlugin";
    static String initCurrThemeNameForReport;
    static int initDownloadedThemeNumForReport;
    static Handler reportHandler;
    static int reportTimes;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public static class ReportThemeInfoHandler extends Handler {
        public ReportThemeInfoHandler() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (ThemeUiPlugin.reportHandler == null) {
                ThemeUiPlugin.reportHandler = new ReportThemeInfoHandler(BaseApplication.getContext().getMainLooper());
            }
            int i3 = message.what;
            Object[] objArr = (Object[]) message.obj;
            if (i3 == 1) {
                if (ThemeUiPlugin.reportTimes < 3) {
                    String str = (String) objArr[0];
                    QQAppInterface qQAppInterface = (QQAppInterface) objArr[1];
                    if (QLog.isColorLevel()) {
                        QLog.i(ThemeUiPlugin.TAG, 2, ThemeUiPlugin.initDownloadedThemeNumForReport + "," + ThemeUiPlugin.initCurrThemeNameForReport);
                    }
                    VasWebviewUtil.reportVasStatus("ThemeMall", "ThemeCount", "0", 0, 0, ThemeUiPlugin.initDownloadedThemeNumForReport, 0, "", "");
                    VasWebviewUtil.reportVasStatus("ThemeMall", "ThemeOn", "0", 0, 0, 0, 0, "theme_" + ThemeUiPlugin.initCurrThemeNameForReport, "");
                    ThemeUiPlugin.reportTimes = ThemeUiPlugin.reportTimes + 1;
                    if (QLog.isColorLevel()) {
                        QLog.d(ThemeUiPlugin.TAG, 2, "reportTimes is:" + ThemeUiPlugin.reportTimes);
                    }
                    Message obtainMessage = ThemeUiPlugin.reportHandler.obtainMessage();
                    obtainMessage.what = 1;
                    obtainMessage.obj = new Object[]{str, qQAppInterface};
                    ThemeUiPlugin.reportHandler.sendMessageDelayed(obtainMessage, 120000L);
                    return;
                }
                ThemeUiPlugin.reportTimes = 0;
            }
        }

        public ReportThemeInfoHandler(Looper looper) {
            super(looper);
        }
    }

    public static void destroy(QQAppInterface qQAppInterface) {
        initDownloadedThemeNumForReport = 0;
        initCurrThemeNameForReport = null;
        reportTimes = 0;
        Handler handler = reportHandler;
        if (handler != null) {
            handler.removeMessages(1);
        }
    }

    public static String getReportCurrThemeName() {
        String skinRootPath = SkinEngine.getInstances().getSkinRootPath();
        if (skinRootPath != null && skinRootPath.trim().length() != 0) {
            return ThemeUtil.getCurrentThemeId();
        }
        return "default_theme";
    }

    public static void reportThemeNumAndCurrThemeName(final QQAppInterface qQAppInterface, final String str) {
        reportTimes = 0;
        if (reportHandler == null) {
            reportHandler = new ReportThemeInfoHandler(BaseApplication.getContext().getMainLooper());
        }
        reportHandler.removeMessages(1);
        initDownloadedThemeNumForReport = 0;
        initCurrThemeNameForReport = null;
        qQAppInterface.execute(new Runnable() { // from class: com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin.1
            @Override // java.lang.Runnable
            public void run() {
                ThemeUiPlugin.initDownloadedThemeNumForReport = ThemeUtil.getThemeDownloadNum(QQAppInterface.this.getApp());
                ThemeUiPlugin.initCurrThemeNameForReport = ThemeUtil.getUserCurrentThemeId(QQAppInterface.this);
                Message obtainMessage = ThemeUiPlugin.reportHandler.obtainMessage();
                obtainMessage.what = 1;
                obtainMessage.obj = new Object[]{str, QQAppInterface.this};
                if (QLog.isColorLevel()) {
                    QLog.d(ThemeUiPlugin.TAG, 2, "begin to report theme info");
                }
                if (QLog.isColorLevel()) {
                    QLog.d(ThemeUiPlugin.TAG, 2, "initDownloadedThemeNumForReport is:" + ThemeUiPlugin.initDownloadedThemeNumForReport + ",initCurrThemeNameForReport is:" + ThemeUiPlugin.initCurrThemeNameForReport);
                }
                ThemeUiPlugin.reportHandler.sendMessage(obtainMessage);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewUiPlugin
    public void OnActivityResume() {
        this.activity.setTitle(HardCodeUtil.qqStr(R.string.u4v));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasBasePlugin
    public long getPluginBusiness() {
        return 32L;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewEventByNameSpace(String str) {
        return 3L;
    }

    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewUiPlugin
    public boolean onActivityResult(int i3, int i16, Intent intent) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "BaseWebActivity onActivityResult requestCode=" + i3 + ",resultCode=" + i16);
        }
        if (i16 == -1) {
            switch (i3) {
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    try {
                        String stringExtra = intent.getStringExtra("callbackSn");
                        String stringExtra2 = intent.getStringExtra("result");
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("responseId", stringExtra);
                        jSONObject.put(WebViewPlugin.KEY_RESPONSE, new JSONObject(stringExtra2));
                        if (QLog.isColorLevel()) {
                            QLog.i(TAG, 2, "BaseWebActivity loadUrl setMessage =" + jSONObject.toString());
                        }
                        this.mRuntime.e().loadUrl("javascript:window.qqJSBridge&&qqJSBridge.setMessage('" + jSONObject.toString() + "');");
                        return true;
                    } catch (Exception e16) {
                        e16.printStackTrace();
                        return true;
                    }
                default:
                    return false;
            }
        }
        return false;
    }
}
