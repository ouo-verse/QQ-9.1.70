package com.tencent.gdtad.statistics;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.net.AdHttp;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoModel;
import com.tencent.gdtad.basics.motivevideo.report.GdtADFlyingStreamingReportHelper;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.statistics.GdtCgiReportRunnable;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import java.util.Locale;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtReporter {
    private static final String PARAM_KEY_PS = "ps";
    private static final String PARAM_VALUE_THREE = "3";
    private static final String PARAM_VALUE_TWO = "2";
    public static final int REPORT_DEEP_LINK_SUCCESS = 137;
    public static final int REPORT_OPEN_MAIN_PAGE = 138;
    private static final String TAG = "GdtReporter";

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a implements GdtCgiReportRunnable.GdtCgiReportRunnableCallback {
        a() {
        }

        @Override // com.tencent.gdtad.statistics.GdtCgiReportRunnable.GdtCgiReportRunnableCallback
        public void callback(int i3) {
            boolean z16;
            if (i3 != 200 && i3 != 204) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                GdtADFlyingStreamingReportHelper.getInstance().reportADEvent(GdtADFlyingStreamingReportHelper.EVENT_CODE_1020021);
            } else {
                GdtADFlyingStreamingReportHelper.getInstance().reportADEvent(GdtADFlyingStreamingReportHelper.EVENT_CODE_1020022);
            }
        }
    }

    @Deprecated
    public static void doCgiReport(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ThreadManagerV2.post(new GdtCgiReportRunnable(str), 2, null, false);
        GdtLog.i("GDT_CGI_REPORT", str);
    }

    public static void doExposeCgiReport(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        GdtADFlyingStreamingReportHelper.getInstance().reportADEvent(GdtADFlyingStreamingReportHelper.EVENT_CODE_1020008);
        GdtCgiReportRunnable gdtCgiReportRunnable = new GdtCgiReportRunnable(str);
        gdtCgiReportRunnable.setGdtCgiReportRunnableCallback(new a());
        ThreadManagerV2.post(gdtCgiReportRunnable, 2, null, false);
        GdtLog.i("GDT_CGI_REPORT", str);
    }

    public static void reportPlayFail(@Nullable final GdtMotiveVideoModel gdtMotiveVideoModel, int i3, int i16) {
        String str;
        if (gdtMotiveVideoModel == null) {
            QLog.i(TAG, 1, "reportPlayFail fail,model is null");
            return;
        }
        final JSONObject jSONObject = new JSONObject();
        if (i3 != 1101 && i3 != 1103 && ((int) (i16 / 1000000.0d)) != 14) {
            str = "3";
        } else {
            str = "2";
        }
        try {
            jSONObject.put("ps", str);
        } catch (Throwable th5) {
            QLog.i(TAG, 1, "reportPlayFail error:" + th5);
        }
        AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.gdtad.statistics.GdtReporter.2
            @Override // java.lang.Runnable
            public void run() {
                String str2;
                GdtAd gdtAd = GdtMotiveVideoModel.this.getGdtAd();
                if (gdtAd == null) {
                    QLog.i(GdtReporter.TAG, 1, "reportPlayFail fail,gdtad is null");
                    return;
                }
                if (TextUtils.isEmpty(gdtAd.getVideoReportUrl())) {
                    QLog.i(GdtReporter.TAG, 1, "reportPlayFail fail,url is empty");
                    return;
                }
                String jSONObject2 = jSONObject.toString();
                AdHttp.Params params = new AdHttp.Params();
                params.method = "GET";
                try {
                    str2 = String.format(Locale.CHINA, "%s&video=%s", gdtAd.getVideoReportUrl(), URLEncoder.encode(jSONObject2));
                } catch (Throwable th6) {
                    AdLog.e(GdtReporter.TAG, "reportPlayFail", th6);
                    str2 = "";
                }
                params.setUrl(str2);
                GdtLog.i(GdtReporter.TAG, "reportPlayFail url:" + str2);
                if (!params.canSend()) {
                    QLog.e(GdtReporter.TAG, 1, "reportPlayFail error");
                } else {
                    AdHttp.send(params);
                    GdtLog.i(GdtReporter.TAG, String.format(Locale.getDefault(), "reportPlayFail responseCode:%d durationMillis:%d %s", Integer.valueOf(params.responseCode), Long.valueOf(params.durationMillis), jSONObject2));
                }
            }
        }, 4);
    }
}
