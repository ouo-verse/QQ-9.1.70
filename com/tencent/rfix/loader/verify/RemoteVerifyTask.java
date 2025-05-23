package com.tencent.rfix.loader.verify;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.mobileqq.minigame.report.StartupReportKey;
import com.tencent.rfix.loader.log.RFixLog;
import com.tencent.rfix.loader.storage.RFixGlobalPreferences;
import com.tencent.rfix.loader.thread.IRFixThreadPool;
import com.tencent.rfix.loader.thread.RFixThreadPool;
import com.tencent.rfix.loader.tls.Tls12SocketFactory;
import com.tencent.rfix.loader.utils.CloseUtil;
import com.tencent.rfix.loader.utils.EncryptUtils;
import com.tencent.rfix.loader.utils.PatchFileUtils;
import com.tencent.smtt.sdk.TbsConfig;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes25.dex */
public class RemoteVerifyTask {
    private static final int PLATFORM_ID_ANDROID = 1;
    private static final int REQUEST_TIMEOUT = 3000;
    private static final String REQUEST_URL = "https://content.rconfig.qq.com/trpc.rconfig.task_svr.GetConfigService/NativeLoadPatch";
    private static final String REQUEST_URL_TEST = "https://t.rconfig.qq.com/trpc.rconfig.task_svr.GetConfigService/NativeLoadPatch";
    private static final int RET_CODE_HTTP_FAIL = -2;
    private static final int RET_CODE_HTTP_TIMEOUT = -1;
    private static final int RET_CODE_JSON_FAIL = -3;
    private static final int RET_CODE_UNKNOWN = -9;
    private static final String TAG = "RFix.RemoteVerifyTask";
    private static final int WAIT_LOCK_TIMEOUT = 3500;
    private final Context context;
    private volatile boolean verifyResult;
    private static final String[] IGNORE_VERIFY_LIST = {TbsConfig.APP_QB};
    private static long sRequestSeq = 0;
    private static final Object sWaitLock = new Object();

    public RemoteVerifyTask(Context context) {
        this.context = context;
    }

    private JSONObject buildRequest(RemoteVerifyInfo remoteVerifyInfo) {
        String str = remoteVerifyInfo.appId;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        String str3 = remoteVerifyInfo.appKey;
        if (str3 == null) {
            str3 = "";
        }
        String str4 = remoteVerifyInfo.appVersion;
        if (str4 != null) {
            str2 = str4;
        }
        long j3 = sRequestSeq;
        sRequestSeq = 1 + j3;
        long currentTimeMillis = System.currentTimeMillis();
        String hmacSHA256Encrypt = EncryptUtils.hmacSHA256Encrypt(String.format("%s-%s-%s", Long.valueOf(j3), Long.valueOf(currentTimeMillis), str), str3);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_id", str);
            jSONObject.put("app_version", str2);
            jSONObject.put(StartupReportKey.PLATFORM_ID, 1);
            jSONObject.put(ReportDataBuilder.KEY_BUNDLE_ID, this.context.getPackageName());
            jSONObject.put("sdk_version", "1.2.4-beta4-SNAPSHOT");
            jSONObject.put("seq", j3);
            jSONObject.put("time_stamp", currentTimeMillis);
            jSONObject.put("sign", hmacSHA256Encrypt);
        } catch (JSONException e16) {
            RFixLog.e(TAG, "buildRequest fail!", e16);
        }
        return jSONObject;
    }

    private JSONObject buildResponse(int i3, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ret_code", i3);
            jSONObject.put("ret_msg", str);
        } catch (JSONException e16) {
            RFixLog.e(TAG, "buildResponse fail!", e16);
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean doRemoteVerify() {
        boolean z16;
        Throwable th5;
        long nanoTime;
        int i3;
        try {
            nanoTime = System.nanoTime();
            JSONObject buildRequest = buildRequest(new RemoteVerifyInfo(this.context, true));
            RFixLog.i(TAG, "doRemoteVerify request=" + buildRequest);
            JSONObject doRequest = doRequest(buildRequest);
            RFixLog.i(TAG, "doRemoteVerify response=" + doRequest);
            i3 = doRequest.getInt("ret_code");
            if (i3 == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
        } catch (Throwable th6) {
            z16 = false;
            th5 = th6;
        }
        try {
            RFixLog.i(TAG, String.format("doRemoteVerify retCode=%s verifyResult=%s timeCost=%s", Integer.valueOf(i3), Boolean.valueOf(z16), Long.valueOf(TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime))));
        } catch (Throwable th7) {
            th5 = th7;
            RFixLog.e(TAG, "doRemoteVerify fail!", th5);
            return z16;
        }
        return z16;
    }

    private JSONObject doRequest(JSONObject jSONObject) {
        Object obj;
        OutputStream outputStream;
        JSONObject buildResponse;
        HttpURLConnection httpURLConnection = null;
        InputStream inputStream = null;
        httpURLConnection = null;
        httpURLConnection = null;
        httpURLConnection = null;
        httpURLConnection = null;
        try {
            try {
                URL url = new URL(getRequestURL());
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
                try {
                    httpURLConnection2.setRequestMethod("POST");
                    httpURLConnection2.setRequestProperty("Content-Type", "application/json");
                    httpURLConnection2.setConnectTimeout(3000);
                    httpURLConnection2.setDoOutput(true);
                    httpURLConnection2.setDoInput(true);
                    Tls12SocketFactory.enableTls12OnPreKitkat(httpURLConnection2);
                    outputStream = httpURLConnection2.getOutputStream();
                    try {
                        outputStream.write(jSONObject.toString().getBytes());
                        int responseCode = httpURLConnection2.getResponseCode();
                        RFixLog.i(TAG, String.format("doRequest requestURL=%s responseCode=%s", url.getHost(), Integer.valueOf(responseCode)));
                        if (responseCode == 200) {
                            inputStream = httpURLConnection2.getInputStream();
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                            StringBuilder sb5 = new StringBuilder();
                            while (true) {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                sb5.append(readLine);
                                sb5.append("\r\n");
                            }
                            buildResponse = new JSONObject(sb5.toString());
                        } else {
                            buildResponse = buildResponse(-2, "responseCode=" + responseCode);
                        }
                        CloseUtil.disconnectQuietly(httpURLConnection2);
                        PatchFileUtils.closeQuietly(outputStream);
                        PatchFileUtils.closeQuietly(inputStream);
                    } catch (SocketTimeoutException e16) {
                        e = e16;
                        obj = null;
                        httpURLConnection = httpURLConnection2;
                        RFixLog.e(TAG, "doRequest timeout!", e);
                        buildResponse = buildResponse(-1, "request timeout!");
                        CloseUtil.disconnectQuietly(httpURLConnection);
                        PatchFileUtils.closeQuietly(outputStream);
                        PatchFileUtils.closeQuietly(obj);
                        return buildResponse;
                    } catch (JSONException e17) {
                        e = e17;
                        obj = null;
                        httpURLConnection = httpURLConnection2;
                        RFixLog.e(TAG, "doRequest json fail!", e);
                        buildResponse = buildResponse(-3, "json fail!");
                        CloseUtil.disconnectQuietly(httpURLConnection);
                        PatchFileUtils.closeQuietly(outputStream);
                        PatchFileUtils.closeQuietly(obj);
                        return buildResponse;
                    } catch (Exception e18) {
                        e = e18;
                        obj = null;
                        httpURLConnection = httpURLConnection2;
                        RFixLog.e(TAG, "doRequest fail!", e);
                        buildResponse = buildResponse(-9, "unknown exception!");
                        CloseUtil.disconnectQuietly(httpURLConnection);
                        PatchFileUtils.closeQuietly(outputStream);
                        PatchFileUtils.closeQuietly(obj);
                        return buildResponse;
                    } catch (Throwable th5) {
                        th = th5;
                        obj = null;
                        httpURLConnection = httpURLConnection2;
                        CloseUtil.disconnectQuietly(httpURLConnection);
                        PatchFileUtils.closeQuietly(outputStream);
                        PatchFileUtils.closeQuietly(obj);
                        throw th;
                    }
                } catch (SocketTimeoutException e19) {
                    e = e19;
                    obj = null;
                    outputStream = null;
                } catch (JSONException e26) {
                    e = e26;
                    obj = null;
                    outputStream = null;
                } catch (Exception e27) {
                    e = e27;
                    obj = null;
                    outputStream = null;
                } catch (Throwable th6) {
                    th = th6;
                    obj = null;
                    outputStream = null;
                }
            } catch (SocketTimeoutException e28) {
                e = e28;
                obj = null;
                outputStream = null;
            } catch (JSONException e29) {
                e = e29;
                obj = null;
                outputStream = null;
            } catch (Exception e36) {
                e = e36;
                obj = null;
                outputStream = null;
            } catch (Throwable th7) {
                th = th7;
                obj = null;
                outputStream = null;
            }
            return buildResponse;
        } catch (Throwable th8) {
            th = th8;
        }
    }

    private String getRequestURL() {
        if (new RFixGlobalPreferences(this.context).testEnvEnable) {
            return REQUEST_URL_TEST;
        }
        return REQUEST_URL;
    }

    private boolean inIgnoreVerifyList() {
        String packageName = this.context.getPackageName();
        for (String str : IGNORE_VERIFY_LIST) {
            if (TextUtils.equals(packageName, str)) {
                return true;
            }
        }
        return false;
    }

    public boolean remoteVerify() {
        if (!inIgnoreVerifyList()) {
            try {
                Object obj = sWaitLock;
                synchronized (obj) {
                    this.verifyResult = false;
                    RFixThreadPool.getInstance().execute(new Runnable() { // from class: com.tencent.rfix.loader.verify.RemoteVerifyTask.1
                        @Override // java.lang.Runnable
                        public void run() {
                            synchronized (RemoteVerifyTask.sWaitLock) {
                                RemoteVerifyTask remoteVerifyTask = RemoteVerifyTask.this;
                                remoteVerifyTask.verifyResult = remoteVerifyTask.doRemoteVerify();
                                RemoteVerifyTask.sWaitLock.notify();
                            }
                        }
                    }, IRFixThreadPool.ThreadType.THREAD_NETWORK);
                    obj.wait(3500L);
                }
            } catch (Throwable th5) {
                RFixLog.e(TAG, "remoteVerify fail!", th5);
            }
            return this.verifyResult;
        }
        RFixLog.d(TAG, "remoteVerify verify ignored.");
        return true;
    }
}
