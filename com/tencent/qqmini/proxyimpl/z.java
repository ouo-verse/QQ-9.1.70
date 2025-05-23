package com.tencent.qqmini.proxyimpl;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.libra.util.ImageContentType;
import com.tencent.plato.mqq.network.ProgressListener;
import com.tencent.plato.mqq.network.ProgressRequestBody;
import com.tencent.qqmini.sdk.launcher.core.proxy.UploaderProxy;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Map;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.internal.http.HttpMethod;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes34.dex */
public class z {

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class a implements ProgressListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ UploaderProxy.UploadListener f348009a;

        a(UploaderProxy.UploadListener uploadListener) {
            this.f348009a = uploadListener;
        }

        @Override // com.tencent.plato.mqq.network.ProgressListener
        public void onProgress(long j3, long j16, boolean z16) {
            this.f348009a.onUploadProgress((int) ((j3 * 100.0d) / j16), (int) j3, (int) j16);
        }
    }

    public static RequestBody a(String str, Map<String, String> map, String str2, String str3, UploaderProxy.UploadListener uploadListener) {
        MultipartBody.Builder type = new MultipartBody.Builder().setType(MultipartBody.FORM);
        if (map != null) {
            for (String str4 : map.keySet()) {
                type.addFormDataPart(str4, map.get(str4));
            }
        }
        File file = new File(str);
        ProgressRequestBody progressRequestBody = new ProgressRequestBody(RequestBody.create(MediaType.parse(c(str)), file), new a(uploadListener));
        if (TextUtils.isEmpty(str3)) {
            str3 = file.getName();
        }
        type.addFormDataPart(str2, str3, progressRequestBody);
        return type.build();
    }

    public static Request b(String str, Map<String, String> map, String str2, MediaType mediaType, byte[] bArr) {
        RequestBody requestBody;
        Request.Builder builder = new Request.Builder();
        if (map != null) {
            for (String str3 : map.keySet()) {
                builder.addHeader(str3, map.get(str3));
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
            } else {
                requestBody = null;
            }
            builder.method(str2, requestBody);
        }
        return builder.build();
    }

    private static String c(String str) {
        if (!str.endsWith(".jpg") && !str.endsWith(".jpeg")) {
            if (str.endsWith(".png")) {
                return "image/png";
            }
            return "application/octet-stream";
        }
        return ImageContentType.MIME_TYPE_JPG;
    }

    public static int d(Throwable th5, int i3) {
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

    public static JSONObject e(Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            try {
                jSONObject.put(entry.getKey(), entry.getValue());
            } catch (JSONException unused) {
            }
        }
        return jSONObject;
    }
}
