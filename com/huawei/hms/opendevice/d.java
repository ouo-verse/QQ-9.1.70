package com.huawei.hms.opendevice;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.secure.android.common.ssl.SecureSSLSocketFactory;
import com.huawei.secure.android.common.util.IOUtil;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.GeneralSecurityException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import org.apache.commons.fileupload.FileUploadBase;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class d {

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private enum a {
        GET("GET"),
        POST("POST");


        /* renamed from: d, reason: collision with root package name */
        public String f37343d;

        a(String str) {
            this.f37343d = str;
        }

        public String a() {
            return this.f37343d;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARN: Type inference failed for: r10v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v21, types: [java.io.OutputStream, java.io.FilterOutputStream, java.io.BufferedOutputStream] */
    /* JADX WARN: Type inference failed for: r8v25 */
    /* JADX WARN: Type inference failed for: r8v26 */
    /* JADX WARN: Type inference failed for: r8v27 */
    /* JADX WARN: Type inference failed for: r8v28 */
    /* JADX WARN: Type inference failed for: r8v29 */
    /* JADX WARN: Type inference failed for: r8v30 */
    /* JADX WARN: Type inference failed for: r8v31 */
    /* JADX WARN: Type inference failed for: r8v32 */
    /* JADX WARN: Type inference failed for: r8v33 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v31 */
    /* JADX WARN: Type inference failed for: r9v32 */
    /* JADX WARN: Type inference failed for: r9v8, types: [java.io.InputStream] */
    public static String a(Context context, String str, String str2, Map<String, String> map) {
        ?? r85;
        ?? r95;
        ?? r102;
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        InputStream inputStream2;
        InputStream inputStream3;
        InputStream inputStream4;
        ?? r86;
        InputStream inputStream5;
        InputStream inputStream6;
        OutputStream outputStream;
        ?? r26 = 0;
        if (str2 == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        int i3 = -1;
        try {
            try {
                httpURLConnection = a(context, str, map, a.POST.a());
                if (httpURLConnection == null) {
                    IOUtil.closeSecure((OutputStream) null);
                    IOUtil.closeSecure((InputStream) null);
                    IOUtil.closeSecure((InputStream) null);
                    s.a(httpURLConnection);
                    HMSLog.i("PushHttpClient", "close connection");
                    return null;
                }
                try {
                    r86 = new BufferedOutputStream(httpURLConnection.getOutputStream());
                    try {
                        r86.write(str2.getBytes("UTF-8"));
                        r86.flush();
                        i3 = httpURLConnection.getResponseCode();
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("http post response code: ");
                        sb5.append(i3);
                        HMSLog.d("PushHttpClient", sb5.toString());
                        if (i3 >= 400) {
                            inputStream4 = httpURLConnection.getErrorStream();
                        } else {
                            inputStream4 = httpURLConnection.getInputStream();
                        }
                    } catch (IOException unused) {
                        inputStream4 = null;
                        r86 = r86;
                        inputStream5 = inputStream4;
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("http execute encounter IOException - http code:");
                        sb6.append(i3);
                        HMSLog.w("PushHttpClient", sb6.toString());
                        outputStream = r86;
                        inputStream6 = inputStream4;
                        IOUtil.closeSecure(outputStream);
                        IOUtil.closeSecure(inputStream6);
                        IOUtil.closeSecure(inputStream5);
                        s.a(httpURLConnection);
                        HMSLog.i("PushHttpClient", "close connection");
                        return null;
                    } catch (RuntimeException unused2) {
                        inputStream4 = null;
                        r86 = r86;
                        inputStream5 = inputStream4;
                        StringBuilder sb7 = new StringBuilder();
                        sb7.append("http execute encounter RuntimeException - http code:");
                        sb7.append(i3);
                        HMSLog.w("PushHttpClient", sb7.toString());
                        outputStream = r86;
                        inputStream6 = inputStream4;
                        IOUtil.closeSecure(outputStream);
                        IOUtil.closeSecure(inputStream6);
                        IOUtil.closeSecure(inputStream5);
                        s.a(httpURLConnection);
                        HMSLog.i("PushHttpClient", "close connection");
                        return null;
                    } catch (Exception unused3) {
                        inputStream4 = null;
                        r86 = r86;
                        inputStream5 = inputStream4;
                        StringBuilder sb8 = new StringBuilder();
                        sb8.append("http execute encounter unknown exception - http code:");
                        sb8.append(i3);
                        HMSLog.w("PushHttpClient", sb8.toString());
                        outputStream = r86;
                        inputStream6 = inputStream4;
                        IOUtil.closeSecure(outputStream);
                        IOUtil.closeSecure(inputStream6);
                        IOUtil.closeSecure(inputStream5);
                        s.a(httpURLConnection);
                        HMSLog.i("PushHttpClient", "close connection");
                        return null;
                    } catch (Throwable th5) {
                        r102 = 0;
                        r26 = httpURLConnection;
                        th = th5;
                        r95 = 0;
                        r85 = r86;
                    }
                } catch (IOException unused4) {
                    inputStream3 = null;
                    inputStream4 = inputStream3;
                    r86 = inputStream3;
                    inputStream5 = inputStream4;
                    StringBuilder sb62 = new StringBuilder();
                    sb62.append("http execute encounter IOException - http code:");
                    sb62.append(i3);
                    HMSLog.w("PushHttpClient", sb62.toString());
                    outputStream = r86;
                    inputStream6 = inputStream4;
                    IOUtil.closeSecure(outputStream);
                    IOUtil.closeSecure(inputStream6);
                    IOUtil.closeSecure(inputStream5);
                    s.a(httpURLConnection);
                    HMSLog.i("PushHttpClient", "close connection");
                    return null;
                } catch (RuntimeException unused5) {
                    inputStream2 = null;
                    inputStream4 = inputStream2;
                    r86 = inputStream2;
                    inputStream5 = inputStream4;
                    StringBuilder sb72 = new StringBuilder();
                    sb72.append("http execute encounter RuntimeException - http code:");
                    sb72.append(i3);
                    HMSLog.w("PushHttpClient", sb72.toString());
                    outputStream = r86;
                    inputStream6 = inputStream4;
                    IOUtil.closeSecure(outputStream);
                    IOUtil.closeSecure(inputStream6);
                    IOUtil.closeSecure(inputStream5);
                    s.a(httpURLConnection);
                    HMSLog.i("PushHttpClient", "close connection");
                    return null;
                } catch (Exception unused6) {
                    inputStream = null;
                    inputStream4 = inputStream;
                    r86 = inputStream;
                    inputStream5 = inputStream4;
                    StringBuilder sb82 = new StringBuilder();
                    sb82.append("http execute encounter unknown exception - http code:");
                    sb82.append(i3);
                    HMSLog.w("PushHttpClient", sb82.toString());
                    outputStream = r86;
                    inputStream6 = inputStream4;
                    IOUtil.closeSecure(outputStream);
                    IOUtil.closeSecure(inputStream6);
                    IOUtil.closeSecure(inputStream5);
                    s.a(httpURLConnection);
                    HMSLog.i("PushHttpClient", "close connection");
                    return null;
                } catch (Throwable th6) {
                    r95 = 0;
                    r102 = 0;
                    r26 = httpURLConnection;
                    th = th6;
                    r85 = 0;
                }
                try {
                    inputStream5 = new BufferedInputStream(inputStream4);
                } catch (IOException unused7) {
                    inputStream5 = null;
                } catch (RuntimeException unused8) {
                    inputStream5 = null;
                } catch (Exception unused9) {
                    inputStream5 = null;
                } catch (Throwable th7) {
                    r26 = httpURLConnection;
                    th = th7;
                    r102 = 0;
                    r85 = r86;
                    r95 = inputStream4;
                    IOUtil.closeSecure((OutputStream) r85);
                    IOUtil.closeSecure((InputStream) r95);
                    IOUtil.closeSecure((InputStream) r102);
                    s.a((HttpURLConnection) r26);
                    HMSLog.i("PushHttpClient", "close connection");
                    throw th;
                }
                try {
                    String a16 = s.a(inputStream5);
                    IOUtil.closeSecure((OutputStream) r86);
                    IOUtil.closeSecure(inputStream4);
                    IOUtil.closeSecure(inputStream5);
                    s.a(httpURLConnection);
                    HMSLog.i("PushHttpClient", "close connection");
                    return a16;
                } catch (IOException unused10) {
                    StringBuilder sb622 = new StringBuilder();
                    sb622.append("http execute encounter IOException - http code:");
                    sb622.append(i3);
                    HMSLog.w("PushHttpClient", sb622.toString());
                    outputStream = r86;
                    inputStream6 = inputStream4;
                    IOUtil.closeSecure(outputStream);
                    IOUtil.closeSecure(inputStream6);
                    IOUtil.closeSecure(inputStream5);
                    s.a(httpURLConnection);
                    HMSLog.i("PushHttpClient", "close connection");
                    return null;
                } catch (RuntimeException unused11) {
                    StringBuilder sb722 = new StringBuilder();
                    sb722.append("http execute encounter RuntimeException - http code:");
                    sb722.append(i3);
                    HMSLog.w("PushHttpClient", sb722.toString());
                    outputStream = r86;
                    inputStream6 = inputStream4;
                    IOUtil.closeSecure(outputStream);
                    IOUtil.closeSecure(inputStream6);
                    IOUtil.closeSecure(inputStream5);
                    s.a(httpURLConnection);
                    HMSLog.i("PushHttpClient", "close connection");
                    return null;
                } catch (Exception unused12) {
                    StringBuilder sb822 = new StringBuilder();
                    sb822.append("http execute encounter unknown exception - http code:");
                    sb822.append(i3);
                    HMSLog.w("PushHttpClient", sb822.toString());
                    outputStream = r86;
                    inputStream6 = inputStream4;
                    IOUtil.closeSecure(outputStream);
                    IOUtil.closeSecure(inputStream6);
                    IOUtil.closeSecure(inputStream5);
                    s.a(httpURLConnection);
                    HMSLog.i("PushHttpClient", "close connection");
                    return null;
                }
            } catch (IOException unused13) {
                httpURLConnection = null;
                inputStream3 = null;
            } catch (RuntimeException unused14) {
                httpURLConnection = null;
                inputStream2 = null;
            } catch (Exception unused15) {
                httpURLConnection = null;
                inputStream = null;
            } catch (Throwable th8) {
                th = th8;
                r85 = 0;
                r95 = 0;
                r102 = 0;
            }
        } catch (Throwable th9) {
            r26 = context;
            th = th9;
            r85 = str;
            r95 = str2;
            r102 = map;
        }
    }

    public static HttpURLConnection a(Context context, String str, Map<String, String> map, String str2) throws Exception {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        a(context, httpURLConnection);
        httpURLConnection.setRequestMethod(str2);
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setReadTimeout(15000);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setRequestProperty(FileUploadBase.CONTENT_TYPE, "application/json; charset=UTF-8");
        httpURLConnection.setRequestProperty("Connection", "close");
        if (map != null && map.size() >= 1) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key != null && !TextUtils.isEmpty(key)) {
                    httpURLConnection.setRequestProperty(key, URLEncoder.encode(entry.getValue() == null ? "" : entry.getValue(), "UTF-8"));
                }
            }
        }
        return httpURLConnection;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Context context, HttpURLConnection httpURLConnection) throws Exception {
        SecureSSLSocketFactory secureSSLSocketFactory;
        if (httpURLConnection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            try {
                secureSSLSocketFactory = SecureSSLSocketFactory.getInstance(context);
            } catch (IOException unused) {
                HMSLog.w("PushHttpClient", "Get SocketFactory IO Exception.");
                secureSSLSocketFactory = null;
                if (secureSSLSocketFactory != null) {
                }
            } catch (IllegalAccessException unused2) {
                HMSLog.w("PushHttpClient", "Get SocketFactory Illegal Access Exception.");
                secureSSLSocketFactory = null;
                if (secureSSLSocketFactory != null) {
                }
            } catch (IllegalArgumentException unused3) {
                HMSLog.w("PushHttpClient", "Get SocketFactory Illegal Argument Exception.");
                secureSSLSocketFactory = null;
                if (secureSSLSocketFactory != null) {
                }
            } catch (KeyStoreException unused4) {
                HMSLog.w("PushHttpClient", "Get SocketFactory Key Store exception.");
                secureSSLSocketFactory = null;
                if (secureSSLSocketFactory != null) {
                }
            } catch (NoSuchAlgorithmException unused5) {
                HMSLog.w("PushHttpClient", "Get SocketFactory Algorithm Exception.");
                secureSSLSocketFactory = null;
                if (secureSSLSocketFactory != null) {
                }
            } catch (GeneralSecurityException unused6) {
                HMSLog.w("PushHttpClient", "Get SocketFactory General Security Exception.");
                secureSSLSocketFactory = null;
                if (secureSSLSocketFactory != null) {
                }
            }
            if (secureSSLSocketFactory != null) {
                httpsURLConnection.setSSLSocketFactory(secureSSLSocketFactory);
                httpsURLConnection.setHostnameVerifier(SecureSSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                return;
            }
            throw new Exception("No ssl socket factory set.");
        }
    }
}
