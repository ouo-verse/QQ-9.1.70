package com.tencent.qqmini.sdk.report;

import android.text.TextUtils;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.net.URLEncoder;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class MiniGdtReporter {
    public static final int CODE_APKG_FAIL = 315;
    public static final int CODE_BASELIB_LOAD_FAIL = 310;
    public static final int CODE_G_BASELIB_LOAD_FAIL = 510;
    public static final int CODE_G_PKG_DOWNLOAD_FAIL = 511;
    public static final int CODE_G_PKG_LOAD_FAIL = 512;
    public static final int CODE_SUCCESS = 0;
    private static final String KEY_ACTION = "__PAGE_ACTION_ID__";
    private static final String KEY_ERROR_CODE = "__LANDING_ERROR_CODE__";
    private static final String KEY_OS = "__OS_TYPE__";
    private static final String KEY_TIME = "__PAGE_TIME__";
    private static final String KEY_VER = "__VERSION__";
    private static final String TAG = "MiniGdtReporter";
    private static final AtomicBoolean sNoNeedReport = new AtomicBoolean(true);

    public static void prepareReport() {
        sNoNeedReport.set(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void report(MiniAppInfo miniAppInfo, int i3) {
        String optString;
        String replace;
        boolean z16 = false;
        if (!sNoNeedReport.compareAndSet(false, true)) {
            QMLog.w(TAG, "report: no need report now " + i3);
            return;
        }
        if (miniAppInfo == null) {
            QMLog.w(TAG, "report: null config", new Throwable());
            return;
        }
        LaunchParam launchParam = miniAppInfo.launchParam;
        if (launchParam == null) {
            QMLog.w(TAG, "report: null param " + miniAppInfo, new Throwable());
            return;
        }
        if (launchParam.scene != 1095) {
            QMLog.d(TAG, "report: not form ad " + launchParam.scene);
            return;
        }
        if (launchParam.timestamp == 0) {
            QMLog.w(TAG, "report: no timestamp " + miniAppInfo, new Throwable());
            return;
        }
        if (!TextUtils.isEmpty(launchParam.navigateExtData)) {
            try {
                optString = new JSONObject(launchParam.navigateExtData).optString(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_URL);
            } catch (JSONException e16) {
                QMLog.w(TAG, "report: failed to read ext data " + launchParam, e16);
            }
            if (!TextUtils.isEmpty(optString)) {
                QMLog.w(TAG, "report: empty url " + launchParam, new Throwable());
                return;
            }
            try {
                if (i3 == 0) {
                    replace = optString.replace(KEY_ACTION, Integer.toString(51)).replace(KEY_TIME, Long.toString(System.currentTimeMillis() - launchParam.timestamp));
                } else {
                    replace = optString.replace(KEY_ACTION, Integer.toString(52)).replace(KEY_ERROR_CODE, Integer.toString(i3));
                }
                optString = replace.replace(KEY_OS, Integer.toString(2)).replace(KEY_VER, URLEncoder.encode("1.83.3", "utf-8"));
                z16 = true;
            } catch (Exception e17) {
                QMLog.w(TAG, "report: failed to convert report url " + optString + " " + i3, e17);
            }
            if (!z16) {
                return;
            }
            QMLog.i(TAG, "report: get report url " + optString + " " + launchParam.timestamp);
            GdtReporter.doCgiReport(optString);
            return;
        }
        optString = null;
        if (!TextUtils.isEmpty(optString)) {
        }
    }
}
