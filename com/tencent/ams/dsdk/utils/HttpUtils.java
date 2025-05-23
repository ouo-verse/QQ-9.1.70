package com.tencent.ams.dsdk.utils;

import android.text.TextUtils;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.ams.dsdk.utility.DKCoreSetting;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.adapter.http.HttpHeader;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class HttpUtils {
    static IPatchRedirector $redirector_ = null;
    private static final int MAX_REDIRECT_COUNT = 3;
    public static final String METHOD_GET = "GET";
    public static final String METHOD_POST = "POST";
    private static final String TAG = "HttpUtils";

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public @interface Method {
    }

    public HttpUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static HttpURLConnection connect(String str, String str2, byte[] bArr, int i3, int i16) {
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2;
        try {
            DKURLConnectionCreator connectionCreator = DKConfiguration.getConnectionCreator();
            if (connectionCreator != null) {
                httpURLConnection2 = connectionCreator.getURLConnection(str);
            } else {
                httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            }
            if (httpURLConnection2 == null) {
                return null;
            }
            try {
                httpURLConnection2.setInstanceFollowRedirects(true);
                httpURLConnection2.setRequestMethod(str2);
                httpURLConnection2.setRequestProperty("Accept", "application/json");
                httpURLConnection2.setRequestProperty(HttpHeader.RSP.CHARSET, "UTF-8");
                httpURLConnection2.setRequestProperty("Content-Type", "application/json");
                httpURLConnection2.setConnectTimeout(i3);
                httpURLConnection2.setReadTimeout(i3);
                if ("POST".equals(str2) && bArr != null) {
                    httpURLConnection2.setDoOutput(true);
                    DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection2.getOutputStream());
                    dataOutputStream.write(bArr);
                    dataOutputStream.flush();
                    dataOutputStream.close();
                }
                int responseCode = httpURLConnection2.getResponseCode();
                DLog.d(TAG, "response code: " + responseCode);
                if (isRedirect(responseCode)) {
                    String headerField = httpURLConnection2.getHeaderField("location");
                    DLog.d(TAG, "redirect, new url: " + headerField);
                    DynamicUtils.safeDisconnect(httpURLConnection2);
                    if (i16 >= 3) {
                        DLog.w(TAG, "redirect count exceeded.");
                        return null;
                    }
                    return connect(headerField, str2, bArr, i3, i16 + 1);
                }
                if (responseCode >= 200 && responseCode < 400) {
                    return httpURLConnection2;
                }
                DLog.w(TAG, "request error.");
                DynamicUtils.safeDisconnect(httpURLConnection2);
                return null;
            } catch (Throwable th5) {
                httpURLConnection = httpURLConnection2;
                th = th5;
                DynamicUtils.safeDisconnect(httpURLConnection);
                DLog.e(TAG, "connect error.", th);
                return null;
            }
        } catch (Throwable th6) {
            th = th6;
            httpURLConnection = null;
        }
    }

    public static JSONObject createRequestBody() {
        try {
            JSONObject jSONObject = new JSONObject();
            Map<String, String> completeGlobalParams = DynamicUtils.getCompleteGlobalParams();
            jSONObject.put("app", DynamicUtils.getApp());
            jSONObject.put("os", "2");
            jSONObject.put("version", DynamicUtils.getAppVersion());
            jSONObject.put("sdk_version", DKCoreSetting.SDK_VERSION);
            jSONObject.put("app_name", DynamicUtils.getAppName());
            jSONObject.put("package_name", DynamicUtils.getPackageName());
            jSONObject.put("platform", DynamicUtils.getPlatform());
            JSONObject jSONObject2 = new JSONObject();
            if (completeGlobalParams != null) {
                jSONObject.put("guid", completeGlobalParams.get("guid"));
                jSONObject.put("oaid", completeGlobalParams.get("oaid"));
                jSONObject.put("taid", completeGlobalParams.get("taid"));
                jSONObject.put("qimei36", completeGlobalParams.get("qimei36"));
                String str = completeGlobalParams.get("ad_sdk_version");
                if (!TextUtils.isEmpty(str)) {
                    try {
                        jSONObject2.put("ad_sdk_version", str);
                    } catch (Throwable th5) {
                        DLog.e(TAG, "put ad_sdk_version error.", th5);
                    }
                }
                Map<String, String> extParams = DynamicUtils.getExtParams();
                if (extParams != null && !extParams.isEmpty()) {
                    for (Map.Entry<String, String> entry : extParams.entrySet()) {
                        if (entry != null) {
                            try {
                                jSONObject2.put(entry.getKey(), entry.getValue());
                            } catch (Throwable th6) {
                                DLog.e(TAG, "put ext param error: " + entry.getKey(), th6);
                            }
                        }
                    }
                }
            }
            jSONObject.put("ext", jSONObject2);
            return jSONObject;
        } catch (Throwable th7) {
            DLog.e(TAG, "build request body error.", th7);
            return null;
        }
    }

    public static String getHttpJson(String str, int i3, int i16) {
        return requestHttp(str, "GET", null, i3, i16);
    }

    public static boolean isRedirect(int i3) {
        if (i3 >= 300 && i3 <= 308) {
            return true;
        }
        return false;
    }

    public static String postHttpJson(String str, byte[] bArr, int i3, int i16) {
        return requestHttp(str, "POST", bArr, i3, i16);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String readInputStreamAsString(InputStream inputStream) {
        BufferedReader bufferedReader;
        InputStreamReader inputStreamReader;
        StringBuilder sb5 = new StringBuilder();
        try {
            inputStreamReader = new InputStreamReader(inputStream);
            try {
                bufferedReader = new BufferedReader(inputStreamReader);
            } catch (Throwable th5) {
                th = th5;
                bufferedReader = null;
            }
        } catch (Throwable th6) {
            th = th6;
            bufferedReader = null;
            inputStreamReader = null;
        }
        try {
            for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                sb5.append(readLine);
            }
        } catch (Throwable th7) {
            th = th7;
            try {
                DLog.e(TAG, "read input stream error.", th);
                DynamicUtils.safeClose(bufferedReader);
                DynamicUtils.safeClose(inputStreamReader);
                sb5 = null;
                if (sb5 != null) {
                }
            } finally {
                DynamicUtils.safeClose(bufferedReader);
                DynamicUtils.safeClose(inputStreamReader);
            }
        }
        if (sb5 != null) {
            return null;
        }
        return sb5.toString();
    }

    public static String requestHttp(String str, @Method String str2, byte[] bArr, int i3, int i16) {
        DLog.d(TAG, "getHttpJson, url: " + str);
        String str3 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int i17 = 0;
        HttpURLConnection httpURLConnection = null;
        boolean z16 = true;
        InputStream inputStream = null;
        while (z16) {
            try {
                httpURLConnection = connect(str, str2, bArr, i3, 0);
            } finally {
                try {
                    if (i17 < i16) {
                        i17++;
                    } else {
                        DynamicUtils.safeClose(inputStream);
                        DynamicUtils.safeDisconnect(httpURLConnection);
                        z16 = false;
                    }
                } finally {
                }
            }
            if (httpURLConnection != null) {
                inputStream = httpURLConnection.getInputStream();
                if (inputStream != null) {
                    str3 = readInputStreamAsString(inputStream);
                }
            } else if (i17 < i16) {
                DLog.d(TAG, "getHttpJson, timeout, retryTimes " + i17);
                i17++;
            }
            DynamicUtils.safeClose(inputStream);
            DynamicUtils.safeDisconnect(httpURLConnection);
            z16 = false;
        }
        return str3;
    }
}
