package com.tencent.qqperf.crashdefend.report;

import com.tencent.local_edit.andserver.util.MediaType;
import com.tencent.qqperf.crashdefend.CrashDefendManager;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes25.dex */
public class StartStepCrashReportHelper {
    public static void b(int i3) {
        wy3.c.g("StartStepCrashReportHelper", "reportCrashDefendExist :" + i3);
        g(new a(i3).d());
    }

    public static void c(int i3) {
        wy3.c.g("StartStepCrashReportHelper", "reportHotFixSuccess :" + i3);
        h(new c(i3, CrashDefendManager.i().e()).d());
    }

    public static void d(int i3) {
        wy3.c.g("StartStepCrashReportHelper", "reportSafeModeClear :" + i3);
        h(new d(i3).d());
    }

    public static void e(int i3) {
        wy3.c.g("StartStepCrashReportHelper", "reportSafeModeFixSuccess :" + i3);
        h(new e(i3, CrashDefendManager.i().e()).d());
    }

    public static void f(com.tencent.mobileqq.qqperftool.crash.b bVar) {
        wy3.c.g("CrashDefendManager", "reportStartStepCrash :" + bVar.g());
        h(new f(bVar).d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(JSONObject jSONObject) {
        HttpURLConnection httpURLConnection;
        OutputStream outputStream = null;
        try {
            try {
                httpURLConnection = (HttpURLConnection) new URL("https://otheve.beacon.qq.com/analytics/v2_upload").openConnection();
            } catch (Throwable th5) {
                th = th5;
                httpURLConnection = null;
            }
            try {
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setRequestProperty("Content-Type", MediaType.APPLICATION_JSON_UTF8_VALUE);
                httpURLConnection.setRequestProperty("Accept", "application/json");
                OutputStream outputStream2 = httpURLConnection.getOutputStream();
                outputStream2.write(jSONObject.toString().getBytes("UTF-8"));
                outputStream2.flush();
                wy3.c.a("StartStepCrashReportHelper", "sendReportHttpsRequest jsonBody is " + jSONObject.toString());
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode == 200) {
                    wy3.c.c("StartStepCrashReportHelper", "request success");
                } else {
                    wy3.c.c("StartStepCrashReportHelper", "request failed, code = " + responseCode);
                }
                outputStream2.close();
                httpURLConnection.disconnect();
            } catch (Throwable th6) {
                th = th6;
                try {
                    wy3.c.d("StartStepCrashReportHelper", "sendReportHttpsRequest has exception: ", th);
                    if (0 != 0) {
                        outputStream.close();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                } catch (Throwable th7) {
                    if (0 != 0) {
                        try {
                            outputStream.close();
                        } catch (Throwable th8) {
                            wy3.c.d("StartStepCrashReportHelper", "sendReportHttpsRequest finally has exception: ", th8);
                            throw th7;
                        }
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th7;
                }
            }
        } catch (Throwable th9) {
            wy3.c.d("StartStepCrashReportHelper", "sendReportHttpsRequest finally has exception: ", th9);
        }
    }

    private static void h(final JSONObject jSONObject) {
        new BaseThread(new Runnable() { // from class: com.tencent.qqperf.crashdefend.report.StartStepCrashReportHelper.1
            @Override // java.lang.Runnable
            public void run() {
                StartStepCrashReportHelper.g(JSONObject.this);
            }
        }, "CrashDefendReport").start();
    }
}
