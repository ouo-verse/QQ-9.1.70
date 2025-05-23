package com.tencent.gdtad.statistics;

import androidx.annotation.Nullable;
import com.tencent.ad.tangram.net.AdHttp;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtReportForAntiSpam {
    private static final String TAG = "GdtReportForAntiSpam";

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface ReportCallback {
        void callback(AdHttp.Params params);
    }

    public static void reportFlyingStreaming(@Nullable final JSONObject jSONObject, @Nullable final ReportCallback reportCallback) {
        if (jSONObject == null || JSONObject.NULL.equals(jSONObject) || jSONObject.length() <= 0) {
            return;
        }
        final byte[] bytes = jSONObject.toString().getBytes();
        AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.gdtad.statistics.GdtReportForAntiSpam.1
            @Override // java.lang.Runnable
            public void run() {
                AdHttp.Params params = new AdHttp.Params();
                params.setUrl("https://sdkreport.e.qq.com/link_event");
                params.method = "POST";
                params.contentType = "application/json";
                params.requestData = bytes;
                if (!params.canSend()) {
                    QLog.e(GdtReportForAntiSpam.TAG, 1, "reportFlyingStreaming error");
                    return;
                }
                AdHttp.send(params);
                ReportCallback reportCallback2 = reportCallback;
                if (reportCallback2 != null) {
                    reportCallback2.callback(params);
                }
                GdtLog.i(GdtReportForAntiSpam.TAG, String.format(Locale.getDefault(), "reportFlyingStreaming responseCode:%d durationMillis:%d %s", Integer.valueOf(params.responseCode), Long.valueOf(params.durationMillis), jSONObject.toString()));
            }
        }, 4);
    }

    public static void reportFlyingStreaming(JSONObject jSONObject) {
        reportFlyingStreaming(jSONObject, null);
    }
}
