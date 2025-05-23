package com.tencent.ad.tangram.net;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.mobileqq.msf.core.auth.k;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdHttp {
    private static final String TAG = "AdHttp";

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface Listener {
        void onResponse(Params params);
    }

    /* compiled from: P */
    @AdKeep
    /* loaded from: classes3.dex */
    public static class Params {
        public static final String METHOD_GET = "GET";
        public static final String METHOD_POST = "POST";
        public String contentType;
        public String method;
        public String referer;

        @Nullable
        public byte[] requestData;

        @Nullable
        public byte[] responseData;
        public Throwable throwable;
        private URL url;
        public int connectTimeoutMillis = 10000;
        public int readTimeoutMillis = 10000;
        public int responseCode = Integer.MIN_VALUE;
        public boolean isInstanceFollowRedirects = false;
        public long durationMillis = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;

        public boolean canSend() {
            boolean z16;
            if (this.url != null && !TextUtils.isEmpty(this.method)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (TextUtils.equals(this.method, "POST")) {
                if (z16 && this.requestData != null) {
                    return true;
                }
                return false;
            }
            return z16;
        }

        @Nullable
        public String getUrl() {
            URL url = this.url;
            if (url != null) {
                return url.toString();
            }
            return null;
        }

        public boolean isSuccess() {
            if (canSend() && this.responseCode == 200) {
                return true;
            }
            return false;
        }

        public void setUrl(String str) {
            try {
                this.url = new URL(str);
            } catch (Throwable unused) {
                AdLog.e(AdHttp.TAG, "setUrl " + str);
            }
        }
    }

    @Nullable
    private static byte[] read(@Nullable InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            try {
                byte[] bArr = new byte[1024];
                int read = inputStream.read(bArr);
                if (read < 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } catch (Throwable th5) {
                AdLog.e(TAG, k.f247491e, th5);
            }
        }
        try {
            byteArrayOutputStream.close();
        } catch (Throwable th6) {
            AdLog.e(TAG, k.f247491e, th6);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static void send(@Nullable Params params) {
        HttpURLConnection httpURLConnection;
        Throwable th5;
        long currentTimeMillis = System.currentTimeMillis();
        if (params != null && params.canSend()) {
            try {
                httpURLConnection = (HttpURLConnection) params.url.openConnection();
            } catch (Throwable th6) {
                httpURLConnection = null;
                th5 = th6;
            }
            try {
                httpURLConnection.setConnectTimeout(params.connectTimeoutMillis);
                httpURLConnection.setReadTimeout(params.readTimeoutMillis);
                httpURLConnection.setDoInput(true);
                if (TextUtils.equals(params.method, "GET")) {
                    httpURLConnection.setDoOutput(false);
                } else if (TextUtils.equals(params.method, "POST")) {
                    httpURLConnection.setDoOutput(true);
                }
                httpURLConnection.setRequestMethod(params.method);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setInstanceFollowRedirects(params.isInstanceFollowRedirects);
                if (!TextUtils.isEmpty(params.contentType)) {
                    httpURLConnection.setRequestProperty("Content-Type", params.contentType);
                }
                if (!TextUtils.isEmpty(params.referer)) {
                    httpURLConnection.setRequestProperty("Referer", params.referer);
                }
                if (httpURLConnection.getDoOutput() && params.requestData != null) {
                    DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                    byte[] bArr = params.requestData;
                    dataOutputStream.write(bArr, 0, bArr.length);
                    dataOutputStream.flush();
                    dataOutputStream.close();
                }
                httpURLConnection.connect();
                int responseCode = httpURLConnection.getResponseCode();
                params.responseCode = responseCode;
                if (responseCode == 200 && httpURLConnection.getDoInput()) {
                    InputStream inputStream = httpURLConnection.getInputStream();
                    params.responseData = read(inputStream);
                    inputStream.close();
                }
            } catch (Throwable th7) {
                th5 = th7;
                try {
                    params.throwable = th5;
                    AdLog.e(TAG, "send", th5);
                } finally {
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    params.durationMillis = System.currentTimeMillis() - currentTimeMillis;
                }
            }
        }
    }

    public static boolean sendAsync(@Nullable final Params params, @Nullable final WeakReference<Listener> weakReference) {
        if (params != null && params.canSend()) {
            AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.ad.tangram.net.AdHttp.1
                @Override // java.lang.Runnable
                public void run() {
                    AdHttp.send(Params.this);
                    if (weakReference == null) {
                        return;
                    }
                    AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.ad.tangram.net.AdHttp.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Listener listener = (Listener) weakReference.get();
                            if (listener != null) {
                                listener.onResponse(Params.this);
                            }
                        }
                    }, 0);
                }
            }, 4);
            return true;
        }
        return false;
    }
}
