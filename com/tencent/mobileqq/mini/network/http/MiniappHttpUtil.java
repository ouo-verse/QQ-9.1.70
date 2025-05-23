package com.tencent.mobileqq.mini.network.http;

import android.net.http.Headers;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.libra.util.ImageContentType;
import com.tencent.mobileqq.mini.appbrand.utils.ThreadPools;
import com.tencent.mobileqq.minigame.manager.GamePreConnectManager;
import com.tencent.mtt.hippy.adapter.http.HttpHeader;
import com.tencent.plato.mqq.network.ProgressListener;
import com.tencent.plato.mqq.network.ProgressRequestBody;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal.http.HttpMethod;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniappHttpUtil {
    public static final int C_TIME_OUT = 60000;
    public static final String HTTP_GET = "GET";
    public static final String HTTP_POST = "POST";
    public static final int LOCAL_RET_CODE_ABORTED = -5;
    public static final int LOCAL_RET_CODE_CLIENT_PROTOCOL_EXP = 8;
    public static final int LOCAL_RET_CODE_CONNECT = -2;
    public static final int LOCAL_RET_CODE_CONNECT_CLOSED_EXP = 14;
    public static final int LOCAL_RET_CODE_CONNECT_NOT_OPEN = 50007;
    public static final int LOCAL_RET_CODE_CONNECT_POOL_TIMEOUT_EXP = 13;
    public static final int LOCAL_RET_CODE_CONNECT_REFUSED = 50006;
    public static final int LOCAL_RET_CODE_CONNECT_TIMEOUT_EXP = 10;
    public static final int LOCAL_RET_CODE_CONTENT_LENGTH_VALID = 50002;
    public static final int LOCAL_RET_CODE_EXCEPTION = -1;
    public static final int LOCAL_RET_CODE_EXP = 4;
    public static final int LOCAL_RET_CODE_FNF_EXP = 1;
    public static final int LOCAL_RET_CODE_ILLEGAL_FORMAT_360WIFI = 50001;
    public static final int LOCAL_RET_CODE_ILL_EXP = 5;
    public static final int LOCAL_RET_CODE_IO_EXP = 2;
    public static final int LOCAL_RET_CODE_METHOD_NOT_SUPPORT = -3;
    public static final int LOCAL_RET_CODE_NETWORK_UNREACHABLE = 50004;
    public static final int LOCAL_RET_CODE_NOSPACE_LEFT_ON_DEVICE = 50003;
    public static final int LOCAL_RET_CODE_NO_HTTP_RSP_EXP = 11;
    public static final int LOCAL_RET_CODE_NO_ROUTE_TO_HOST = 50005;
    public static final int LOCAL_RET_CODE_OOM_ERR = 3;
    public static final int LOCAL_RET_CODE_SOCKET_EXP = 6;
    public static final int LOCAL_RET_CODE_SOCKET_TO_EXP = 7;
    public static final int LOCAL_RET_CODE_SSL_HANDSHAKE_EXP = 15;
    public static final int LOCAL_RET_CODE_SSL_PEER_UNVERIFIED_EXP = 12;
    public static final int LOCAL_RET_CODE_UNKNOW_HOST_EXP = 9;
    public static final int LOCAL_RET_CODE_URL_INVALID = -4;
    public static final int R_TIMEOUT = 60000;
    private static final String TAG = "MiniappHttpUtil";
    private static ConcurrentHashMap<String, HttpURLConnection> uploadMap = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, ArrayList<UploadTask>> uploadMapV2 = new ConcurrentHashMap<>();

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class UploadTask implements Runnable {
        Call call;
        HttpCallBack callBack;
        String filePath;
        JSONObject formDataObj;
        JSONObject headerObj;
        volatile boolean isCanceled = false;
        String method;
        String name;
        String uploadFileName;
        String url;

        UploadTask(String str, String str2, String str3, JSONObject jSONObject, JSONObject jSONObject2, String str4, String str5, HttpCallBack httpCallBack) {
            this.method = str;
            this.url = str2;
            this.filePath = str3;
            this.headerObj = jSONObject;
            this.formDataObj = jSONObject2;
            this.name = str4;
            this.uploadFileName = str5;
            this.callBack = httpCallBack;
        }

        private RequestBody buildMultiPartBody(JSONObject jSONObject, String str, String str2) {
            MultipartBody.Builder type = new MultipartBody.Builder().setType(MultipartBody.FORM);
            if (jSONObject != null) {
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str3 = (String) keys.next();
                    type.addFormDataPart(str3, jSONObject.optString(str3));
                }
            }
            File file = new File(this.filePath);
            ProgressRequestBody progressRequestBody = new ProgressRequestBody(RequestBody.create(MediaType.parse(MiniappHttpUtil.getContentType(this.filePath)), file), new ProgressListener() { // from class: com.tencent.mobileqq.mini.network.http.MiniappHttpUtil.UploadTask.2
                @Override // com.tencent.plato.mqq.network.ProgressListener
                public void onProgress(long j3, long j16, boolean z16) {
                    UploadTask.this.callBack.onProgressUpdate((int) ((j3 * 100.0d) / j16), (int) j3, (int) j16);
                }
            });
            if (TextUtils.isEmpty(str2)) {
                str2 = file.getName();
            }
            type.addFormDataPart(str, str2, progressRequestBody);
            return type.build();
        }

        public void abort() {
            this.isCanceled = true;
            Call call = this.call;
            if (call != null) {
                call.cancel();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                OkHttpClient uploadClient = MiniOkHttpClientFactory.getUploadClient();
                Request.Builder builder = new Request.Builder();
                builder.tag(uploadClient).url(this.url).addHeader(HttpHeader.RSP.CHARSET, "utf-8").addHeader(Headers.CONN_DIRECTIVE, "keep-alive");
                JSONObject jSONObject = this.headerObj;
                if (jSONObject != null) {
                    Iterator keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String str = (String) keys.next();
                        builder.addHeader(str, this.headerObj.optString(str));
                    }
                }
                if (this.isCanceled) {
                    this.callBack.httpCallBack(-5, null, null);
                    return;
                }
                builder.method(this.method, buildMultiPartBody(this.formDataObj, this.name, this.uploadFileName));
                Call newCall = uploadClient.newCall(builder.build());
                this.call = newCall;
                newCall.enqueue(new Callback() { // from class: com.tencent.mobileqq.mini.network.http.MiniappHttpUtil.UploadTask.1
                    @Override // okhttp3.Callback
                    public void onFailure(Call call, IOException iOException) {
                        QLog.e(MiniappHttpUtil.TAG, 1, "httpConnect err url:" + UploadTask.this.url, iOException);
                        if ("Canceled".equals(iOException.getLocalizedMessage())) {
                            UploadTask.this.callBack.httpCallBack(-5, null, null);
                        } else {
                            UploadTask.this.callBack.httpCallBack(MiniappHttpUtil.getRetCodeFrom(iOException, -1), null, null);
                        }
                    }

                    @Override // okhttp3.Callback
                    public void onResponse(Call call, Response response) throws IOException {
                        if (!UploadTask.this.isCanceled) {
                            int code = response.code();
                            Map<String, List<String>> multimap = response.headers().toMultimap();
                            UploadTask.this.callBack.headersReceived(code, multimap);
                            UploadTask.this.callBack.httpCallBack(code, response.body().bytes(), multimap);
                            return;
                        }
                        QLog.w(MiniappHttpUtil.TAG, 1, "upload onResponse but canceled");
                        UploadTask.this.callBack.httpCallBack(-5, null, null);
                    }
                });
            } finally {
            }
        }
    }

    private static Request buildRequest(String str, String[] strArr, String str2, MediaType mediaType, byte[] bArr) {
        Request.Builder builder = new Request.Builder();
        RequestBody requestBody = null;
        if (strArr != null) {
            String str3 = null;
            for (int i3 = 0; i3 < strArr.length; i3++) {
                if (i3 % 2 == 0) {
                    str3 = strArr[i3];
                } else {
                    try {
                        builder.addHeader(str3, strArr[i3]);
                    } catch (Throwable th5) {
                        QLog.e(TAG, 1, "areqBuilder.addHeader.error: " + th5);
                    }
                }
            }
        }
        builder.url(str);
        if ("GET".equals(str2)) {
            builder.get();
        } else {
            if (HttpMethod.requiresRequestBody(str2)) {
                if (bArr == null) {
                    bArr = new byte[0];
                }
                requestBody = RequestBody.create(mediaType, bArr);
            }
            builder.method(str2, requestBody);
        }
        return builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getContentType(String str) {
        if (!str.endsWith(".jpg") && !str.endsWith(".jpeg")) {
            if (str.endsWith(".png")) {
                return "image/png";
            }
            return "application/octet-stream";
        }
        return ImageContentType.MIME_TYPE_JPG;
    }

    private static Call httpConnect(String str, final String str2, String[] strArr, byte[] bArr, final HttpCallBack httpCallBack, RequestConfig requestConfig) {
        if (!TextUtils.isEmpty(str2) && (str2.startsWith("https://") || str2.startsWith("http://"))) {
            Call newCall = MiniOkHttpClientFactory.getRequestClient().newCall(buildRequest(str2, strArr, str, null, bArr));
            newCall.enqueue(new Callback() { // from class: com.tencent.mobileqq.mini.network.http.MiniappHttpUtil.1
                private volatile boolean canceled = false;

                @Override // okhttp3.Callback
                public void onFailure(Call call, IOException iOException) {
                    QLog.e(MiniappHttpUtil.TAG, 1, "httpConnect err url:" + str2, iOException);
                    if ("Canceled".equals(iOException.getLocalizedMessage())) {
                        this.canceled = true;
                        httpCallBack.httpCallBack(-5, null, null);
                    } else {
                        httpCallBack.httpCallBack(MiniappHttpUtil.getRetCodeFrom(iOException, -1), null, null);
                    }
                }

                @Override // okhttp3.Callback
                public void onResponse(Call call, Response response) throws IOException {
                    if (this.canceled) {
                        return;
                    }
                    try {
                        int code = response.code();
                        GamePreConnectManager.onUrlConnect(str2, code);
                        Map<String, List<String>> multimap = response.headers().toMultimap();
                        httpCallBack.headersReceived(code, multimap);
                        httpCallBack.httpCallBack(code, response.body().bytes(), multimap);
                    } catch (Throwable th5) {
                        try {
                            QLog.e(MiniappHttpUtil.TAG, 1, "exception happened err url:" + str2, th5);
                            httpCallBack.httpCallBack(MiniappHttpUtil.getRetCodeFrom(th5, -1), null, null);
                        } catch (Throwable unused) {
                        }
                    }
                }
            });
            return newCall;
        }
        httpCallBack.httpCallBack(-4, null, null);
        QLog.e(TAG, 1, "httpConnect error! url invalid. url:" + str2);
        return null;
    }

    public static Call httpGetV2(String str, String[] strArr, HttpCallBack httpCallBack, RequestConfig requestConfig) {
        return httpConnect("GET", str, strArr, null, httpCallBack, requestConfig);
    }

    public static Call httpPostV2(String str, byte[] bArr, String[] strArr, HttpCallBack httpCallBack, RequestConfig requestConfig) {
        return httpConnect("POST", str, strArr, bArr, httpCallBack, requestConfig);
    }

    public static Call httpSendV2(String str, String str2, byte[] bArr, String[] strArr, HttpCallBack httpCallBack, RequestConfig requestConfig) {
        if ("CONNECT".equals(str)) {
            httpCallBack.httpCallBack(-3, null, null);
            return null;
        }
        return httpConnect(str, str2, strArr, bArr, httpCallBack, requestConfig);
    }

    public static UploadTask httpUpload(String str, String str2, String str3, JSONObject jSONObject, JSONObject jSONObject2, String str4, String str5, HttpCallBack httpCallBack) {
        return httpUploadInnerV2(str, str2, str3, jSONObject, jSONObject2, str4, str5, httpCallBack);
    }

    private static UploadTask httpUploadInnerV2(String str, String str2, String str3, JSONObject jSONObject, JSONObject jSONObject2, String str4, String str5, HttpCallBack httpCallBack) {
        UploadTask uploadTask = new UploadTask(str, str2, str3, jSONObject, jSONObject2, str4, str5, httpCallBack);
        ThreadPools.getNetworkIOThreadPool().execute(uploadTask);
        return uploadTask;
    }

    public static void fillErrMsg(String str, JSONObject jSONObject, int i3) {
        String str2;
        try {
            if (i3 != -5) {
                if (i3 != -3 && i3 != -2) {
                    jSONObject.put("errMsg", "unknown reason");
                    return;
                } else {
                    jSONObject.put("errMsg", "request protocol error");
                    return;
                }
            }
            if (TextUtils.isEmpty(str)) {
                str2 = "abort";
            } else {
                str2 = str + ":fail abort";
            }
            jSONObject.put("errMsg", str2);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "fillErrMsg", th5);
        }
    }

    public static int getRetCodeFrom(Throwable th5, int i3) {
        int i16;
        if (th5 == null) {
            return i3;
        }
        if (th5 instanceof SSLPeerUnverifiedException) {
            return 12;
        }
        if (th5 instanceof UnknownHostException) {
            return 9;
        }
        if (th5 instanceof SSLHandshakeException) {
            return 15;
        }
        if (th5 instanceof IllegalStateException) {
            String stackTraceString = Log.getStackTraceString(th5);
            i16 = (stackTraceString == null || !stackTraceString.contains("Connection is not open")) ? 5 : 50007;
        } else {
            if (th5 instanceof SocketException) {
                return 6;
            }
            if (th5 instanceof SocketTimeoutException) {
                return 7;
            }
            if (th5 instanceof FileNotFoundException) {
                return 1;
            }
            if (th5 instanceof IOException) {
                String stackTraceString2 = Log.getStackTraceString(th5);
                if (stackTraceString2 != null && stackTraceString2.contains("No space left on device")) {
                    i16 = 50003;
                } else if (stackTraceString2 != null && stackTraceString2.contains("Network is unreachable")) {
                    i16 = 50004;
                } else if (stackTraceString2 == null || !stackTraceString2.contains("No route to host")) {
                    i16 = (stackTraceString2 == null || !stackTraceString2.contains("Connection refused")) ? 2 : 50006;
                } else {
                    i16 = 50005;
                }
            } else {
                if (th5 instanceof Exception) {
                    return 4;
                }
                if (th5 instanceof OutOfMemoryError) {
                    return 3;
                }
                return i3;
            }
        }
        return i16;
    }

    public static String[] mapToString(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        String[] strArr = new String[map.size() * 2];
        int i3 = 0;
        for (String str : map.keySet()) {
            strArr[i3] = str;
            int i16 = i3 + 1;
            strArr[i16] = map.get(str);
            i3 = i16 + 1;
        }
        return strArr;
    }
}
