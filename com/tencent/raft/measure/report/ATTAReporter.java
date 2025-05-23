package com.tencent.raft.measure.report;

import android.net.TrafficStats;
import android.os.Build;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.raft.measure.RAFTMeasure;
import com.tencent.raft.measure.log.RLog;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes25.dex */
public class ATTAReporter {
    static IPatchRedirector $redirector_ = null;
    public static final String ATTA_TYPE = "Atta-Type";
    private static final String AT_URL = "https://h.trace.qq.com/kv";
    public static final String BATCH_REPORT = "batch-report";
    private static final String KEY_ATTA_ID = "attaid";
    public static final String KEY_CONTENT_LENGTH = "Content-Length";
    public static final String KEY_CONTENT_TYPE = "Content-Type";
    private static final String KEY_DATA = "datas";
    private static final String KEY_TOKEN = "token";
    private static final String KEY_TYPE = "type";
    private static final String KEY_VERSION = "version";
    private static final String METHOD_POST = "POST";
    private static final String TAG = "ATTAReporter";
    public static final int TIMEOUT = 300000;
    private static final String VAL_BATCH = "batch";
    public static final String VAL_TEXT_PLAIN_CHARSET_UTF_8 = "text/plain;charset=UTF-8";
    private static final String VAL_VERSION_DEFAULT = "v1.0.0";
    private final String attaId;
    private final String token;

    public ATTAReporter(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) str2);
        } else {
            this.attaId = str;
            this.token = str2;
        }
    }

    private void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e16) {
                e16.printStackTrace();
            }
        }
    }

    private void doPost(String str, String str2) {
        byte[] bArr;
        Closeable closeable;
        if (Build.VERSION.SDK_INT >= 26) {
            TrafficStats.getAndSetThreadStatsTag(26);
        }
        RLog.d(TAG, "Req " + str + " msg " + str2);
        try {
            bArr = str2.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            bArr = new byte[0];
        }
        Closeable closeable2 = null;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setConnectTimeout(300000);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestProperty(ATTA_TYPE, BATCH_REPORT);
            httpURLConnection.setRequestProperty("Content-Type", VAL_TEXT_PLAIN_CHARSET_UTF_8);
            httpURLConnection.setRequestProperty("Content-Length", String.valueOf(bArr.length));
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                outputStream.write(bArr);
                outputStream.flush();
                closeable2 = httpURLConnection.getInputStream();
                if (RAFTMeasure.getAppConfig().isDebug()) {
                    RLog.d(TAG, "code = " + httpURLConnection.getResponseCode() + ", resp=" + httpURLConnection.getResponseMessage());
                }
                httpURLConnection.disconnect();
                closeQuietly(outputStream);
                closeQuietly(closeable2);
            } catch (Exception e16) {
                e = e16;
                closeable = closeable2;
                closeable2 = outputStream;
                try {
                    RLog.e(TAG, "doPost err", e);
                    closeQuietly(closeable2);
                    closeQuietly(closeable);
                } catch (Throwable th5) {
                    th = th5;
                    closeQuietly(closeable2);
                    closeQuietly(closeable);
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
                closeable = closeable2;
                closeable2 = outputStream;
                closeQuietly(closeable2);
                closeQuietly(closeable);
                throw th;
            }
        } catch (Exception e17) {
            e = e17;
            closeable = null;
        } catch (Throwable th7) {
            th = th7;
            closeable = null;
        }
    }

    public final void doPostBatchReport(@NonNull JSONArray jSONArray) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) jSONArray);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(KEY_ATTA_ID, this.attaId);
            jSONObject.put("token", this.token);
            jSONObject.put("type", VAL_BATCH);
            jSONObject.put("version", VAL_VERSION_DEFAULT);
            jSONObject.put(KEY_DATA, jSONArray);
            doPost("https://h.trace.qq.com/kv", jSONObject.toString());
        } catch (JSONException e16) {
            RLog.e(TAG, "doPostBatchReport err", e16);
        }
    }
}
