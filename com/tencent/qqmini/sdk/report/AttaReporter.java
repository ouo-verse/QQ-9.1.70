package com.tencent.qqmini.sdk.report;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.qqlive.tvkplayer.tools.http.api.ITVKHttpProcessor;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.manager.LoginManager;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import org.apache.commons.fileupload.FileUploadBase;

/* compiled from: P */
/* loaded from: classes23.dex */
public class AttaReporter {
    private static void c(HashMap<String, String> hashMap, HashMap<String, String> hashMap2, String str, String str2) {
        if (hashMap2 != null && hashMap != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String str3 = hashMap2.get(str);
            if (TextUtils.isEmpty(str3)) {
                return;
            }
            hashMap.put(str2, str3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String d(String str, String str2, String str3, String str4) {
        StringBuilder sb5 = new StringBuilder();
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("attaid", "09300069486");
            hashMap.put("token", "2166674397");
            hashMap.put("platform", "2");
            hashMap.put("app_type", "1");
            hashMap.put("appid", str);
            hashMap.put("action_id", str2);
            hashMap.put("uid", LoginManager.getInstance().getAccount());
            hashMap.put("qqversion", QUAUtil.getPlatformQUA());
            hashMap.put("consume_ms", str4);
            hashMap.put("report_ts", String.valueOf(System.currentTimeMillis()));
            HashMap<String, String> f16 = f(str3);
            c(hashMap, f16, "bsid", "bid");
            c(hashMap, f16, "seid", "scene_id");
            c(hashMap, f16, "eid", "alg_id");
            c(hashMap, f16, "reqid", "request_id");
            c(hashMap, f16, "expo_source", "expo_source");
            c(hashMap, f16, "expo_location", "expo_location");
            for (String str5 : hashMap.keySet()) {
                String encode = URLEncoder.encode((String) hashMap.get(str5), "UTF-8");
                sb5.append(str5);
                sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb5.append(encode);
                sb5.append(ContainerUtils.FIELD_DELIMITER);
            }
        } catch (Throwable th5) {
            QMLog.e("AttaReporter", "[buildReportParam], error:" + th5);
        }
        return sb5.toString();
    }

    private static HttpURLConnection e(String str) {
        IOException e16;
        HttpURLConnection httpURLConnection;
        ProtocolException e17;
        MalformedURLException e18;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        } catch (MalformedURLException e19) {
            e18 = e19;
            httpURLConnection = null;
        } catch (ProtocolException e26) {
            e17 = e26;
            httpURLConnection = null;
        } catch (IOException e27) {
            e16 = e27;
            httpURLConnection = null;
        }
        try {
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty(FileUploadBase.CONTENT_TYPE, ITVKHttpProcessor.HTTP_REQUEST_CONTENT_TYPE_VALUE_FORM);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.connect();
        } catch (MalformedURLException e28) {
            e18 = e28;
            QMLog.e("AttaReporter", e18.getMessage());
            return httpURLConnection;
        } catch (ProtocolException e29) {
            e17 = e29;
            QMLog.e("AttaReporter", e17.getMessage());
            return httpURLConnection;
        } catch (IOException e36) {
            e16 = e36;
            QMLog.e("AttaReporter", e16.getMessage());
            return httpURLConnection;
        }
        return httpURLConnection;
    }

    private static HashMap<String, String> f(String str) {
        String[] split;
        HashMap<String, String> hashMap = new HashMap<>();
        if (TextUtils.isEmpty(str)) {
            return hashMap;
        }
        try {
            split = str.split(ContainerUtils.FIELD_DELIMITER);
        } catch (Throwable th5) {
            QMLog.e("AttaReporter", "[parseReportParam], error:" + th5);
        }
        if (split != null && split.length != 0) {
            for (String str2 : split) {
                String[] split2 = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                if (split2 != null && split2.length == 2) {
                    int indexOf = str2.indexOf(ContainerUtils.KEY_VALUE_DELIMITER);
                    String substring = str2.substring(0, indexOf);
                    String substring2 = str2.substring(indexOf + 1);
                    if ("category_tag".equals(substring)) {
                        HashMap<String, String> f16 = f(URLDecoder.decode(substring2, "UTF-8"));
                        if (f16 != null && f16.size() > 0) {
                            hashMap.putAll(f16);
                        }
                    } else {
                        hashMap.put(substring, substring2);
                    }
                }
            }
            return hashMap;
        }
        return hashMap;
    }

    public static void g(String str, MiniAppInfo miniAppInfo, long j3) {
        LaunchParam launchParam;
        if (miniAppInfo != null && (launchParam = miniAppInfo.launchParam) != null && launchParam.scene == 3002) {
            String str2 = launchParam.reportData;
            if (TextUtils.isEmpty(str2)) {
                str2 = miniAppInfo.reportData;
            }
            h(str, miniAppInfo.appId, str2, String.valueOf(j3));
        }
    }

    public static void h(final String str, final String str2, final String str3, final String str4) {
        ThreadManager.executeOnNetworkIOThreadPool(new Runnable() { // from class: com.tencent.qqmini.sdk.report.AttaReporter.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    QMLog.i("AttaReporter", "[report], actionId:" + str + ",appId:" + str2);
                    AttaReporter.i("https://h.trace.qq.com/kv", AttaReporter.d(str2, str, str3, str4));
                } catch (Throwable th5) {
                    QMLog.e("AttaReporter", "[report], error:" + th5);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.String] */
    public static void i(String str, String str2) {
        StringBuilder sb5;
        BufferedWriter bufferedWriter;
        HttpURLConnection e16 = e(str);
        if (e16 != null) {
            BufferedWriter bufferedWriter2 = null;
            BufferedWriter bufferedWriter3 = null;
            BufferedWriter bufferedWriter4 = null;
            try {
                try {
                    bufferedWriter = new BufferedWriter(new OutputStreamWriter(e16.getOutputStream(), "UTF-8"));
                    try {
                        bufferedWriter.write(str2);
                        bufferedWriter.close();
                        int responseCode = e16.getResponseCode();
                        if (QMLog.isColorLevel()) {
                            QMLog.d("AttaReporter", "ret code:" + responseCode);
                            bufferedWriter3 = "ret code:";
                        }
                    } catch (IOException e17) {
                        e = e17;
                        bufferedWriter4 = bufferedWriter;
                        QMLog.e("AttaReporter", "[startReport], write error:" + e);
                        bufferedWriter2 = bufferedWriter4;
                        if (bufferedWriter4 != null) {
                            try {
                                bufferedWriter4.close();
                                bufferedWriter2 = bufferedWriter4;
                            } catch (IOException e18) {
                                e = e18;
                                sb5 = new StringBuilder();
                                sb5.append("[startReport], close error");
                                sb5.append(e);
                                QMLog.e("AttaReporter", sb5.toString());
                            }
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedWriter2 = bufferedWriter;
                        if (bufferedWriter2 != null) {
                            try {
                                bufferedWriter2.close();
                            } catch (IOException e19) {
                                QMLog.e("AttaReporter", "[startReport], close error" + e19);
                            }
                        }
                        throw th;
                    }
                } catch (IOException e26) {
                    e = e26;
                }
                try {
                    bufferedWriter.close();
                    bufferedWriter2 = bufferedWriter3;
                } catch (IOException e27) {
                    e = e27;
                    sb5 = new StringBuilder();
                    sb5.append("[startReport], close error");
                    sb5.append(e);
                    QMLog.e("AttaReporter", sb5.toString());
                }
            } catch (Throwable th6) {
                th = th6;
            }
        }
    }
}
