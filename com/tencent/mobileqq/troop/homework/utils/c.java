package com.tencent.mobileqq.troop.homework.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.SniSSLSocketFactory;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a implements HostnameVerifier {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ URL f297345a;

        a(URL url) {
            this.f297345a = url;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) url);
            }
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) sSLSession)).booleanValue();
            }
            boolean verify = HttpsURLConnection.getDefaultHostnameVerifier().verify(this.f297345a.getHost(), sSLSession);
            if (verify) {
                QLog.d("URLUtil", 1, "OpenVirtual.HostnameVerifier.host:", this.f297345a.getHost(), ",address:", sSLSession.getPeerHost(), ",isverify:", Boolean.valueOf(verify));
            }
            return verify;
        }
    }

    private static void a(HttpsURLConnection httpsURLConnection, URL url) {
        a aVar = new a(url);
        httpsURLConnection.setRequestProperty("host", url.getHost());
        httpsURLConnection.setSSLSocketFactory(new SniSSLSocketFactory(url.getHost(), aVar));
        httpsURLConnection.setHostnameVerifier(aVar);
    }

    @NonNull
    private static Proxy b(Context context) {
        NetworkInfo activeNetworkInfo;
        Proxy proxy = Proxy.NO_PROXY;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && NetworkUtil.isMobileNetworkInfo(activeNetworkInfo)) {
            String proxyHost = HttpUtil.getProxyHost(context);
            int proxyPort = HttpUtil.getProxyPort(context);
            if (!TextUtils.isEmpty(proxyHost) && proxyPort >= 0) {
                return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, proxyPort));
            }
            return proxy;
        }
        return proxy;
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x015d, code lost:
    
        if (r14 == null) goto L60;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0177 A[Catch: all -> 0x01ab, Exception -> 0x01b0, IOException -> 0x01b5, TryCatch #8 {IOException -> 0x01b5, Exception -> 0x01b0, all -> 0x01ab, blocks: (B:22:0x007b, B:24:0x009d, B:25:0x00a5, B:27:0x00ab, B:30:0x00b9, B:35:0x00bf, B:37:0x00f6, B:52:0x0128, B:56:0x0171, B:58:0x0177, B:61:0x0167, B:72:0x018e, B:73:0x0191, B:78:0x0192, B:39:0x00fa, B:42:0x00ff, B:44:0x0105, B:46:0x0113, B:47:0x0119, B:48:0x011d, B:50:0x0124, B:67:0x0134, B:64:0x014b), top: B:21:0x007b, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0167 A[Catch: all -> 0x01ab, Exception -> 0x01b0, IOException -> 0x01b5, TryCatch #8 {IOException -> 0x01b5, Exception -> 0x01b0, all -> 0x01ab, blocks: (B:22:0x007b, B:24:0x009d, B:25:0x00a5, B:27:0x00ab, B:30:0x00b9, B:35:0x00bf, B:37:0x00f6, B:52:0x0128, B:56:0x0171, B:58:0x0177, B:61:0x0167, B:72:0x018e, B:73:0x0191, B:78:0x0192, B:39:0x00fa, B:42:0x00ff, B:44:0x0105, B:46:0x0113, B:47:0x0119, B:48:0x011d, B:50:0x0124, B:67:0x0134, B:64:0x014b), top: B:21:0x007b, inners: #1 }] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String c(Context context, String str, Bundle bundle, Bundle bundle2) throws IOException {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        URL url;
        HttpsURLConnection httpsURLConnection;
        ByteArrayOutputStream byteArrayOutputStream;
        String str2;
        ?? r46 = 0;
        r46 = 0;
        r4 = null;
        r4 = null;
        HttpsURLConnection httpsURLConnection2 = null;
        if (context == null) {
            QLog.d("URLUtil", 1, "openUrlGet context==null");
            return null;
        }
        QLog.d("URLUtil", 1, "openUrlGet url=", str);
        if (str.contains("#")) {
            str = str.substring(0, str.indexOf(35));
        }
        String replace = str.replace(" ", "%20");
        String encodeUrl = HttpUtil.encodeUrl(bundle);
        if (encodeUrl != null && encodeUrl.length() > 0) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(replace);
            String str3 = QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
            if (replace.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                str3 = ContainerUtils.FIELD_DELIMITER;
            }
            sb5.append(str3);
            sb5.append(encodeUrl);
            replace = sb5.toString();
        }
        try {
            try {
                url = new URL(replace);
                httpsURLConnection = (HttpsURLConnection) url.openConnection(b(context));
            } catch (IOException e16) {
                e = e16;
                obj3 = null;
            } catch (Exception e17) {
                e = e17;
                obj2 = null;
            } catch (Throwable th5) {
                th = th5;
                obj = null;
            }
            try {
                httpsURLConnection.setConnectTimeout(15000);
                httpsURLConnection.setReadTimeout(30000);
                httpsURLConnection.setRequestMethod("GET");
                a(httpsURLConnection, url);
                httpsURLConnection.setRequestProperty("Accept-Encoding", "gzip");
                httpsURLConnection.setRequestProperty("Connection", "close");
                if (bundle2 != null) {
                    for (String str4 : bundle2.keySet()) {
                        Object obj6 = bundle2.get(str4);
                        if (obj6 instanceof String) {
                            httpsURLConnection.setRequestProperty(str4, (String) obj6);
                        }
                    }
                }
                httpsURLConnection.setRequestProperty("User-agent", "AndroidSDK_" + Build.VERSION.SDK + "_" + DeviceInfoMonitor.getModel() + "_" + Build.VERSION.RELEASE);
                httpsURLConnection.connect();
                int responseCode = httpsURLConnection.getResponseCode();
                if (responseCode == 200) {
                    InputStream inputStream = httpsURLConnection.getInputStream();
                    try {
                        try {
                            byteArrayOutputStream = new ByteArrayOutputStream();
                            try {
                                if (httpsURLConnection.getContentEncoding() != null && httpsURLConnection.getContentEncoding().toLowerCase().contains("gzip")) {
                                    inputStream = new GZIPInputStream(inputStream);
                                }
                                byte[] bArr = new byte[512];
                                while (true) {
                                    int read = inputStream.read(bArr);
                                    if (read == -1) {
                                        break;
                                    }
                                    byteArrayOutputStream.write(bArr, 0, read);
                                }
                            } catch (IOException e18) {
                                e = e18;
                                QLog.d("URLUtil", 1, "openUrlGet read IOException=", e.getMessage(), e);
                            } catch (Exception e19) {
                                e = e19;
                                QLog.d("URLUtil", 1, "openUrlGet read Exception=", e.getMessage(), e);
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (byteArrayOutputStream != null) {
                                }
                                String str5 = str2;
                                r46 = str5;
                                if (QLog.isColorLevel()) {
                                }
                                httpsURLConnection.disconnect();
                                return r46;
                            }
                        } catch (IOException e26) {
                            e = e26;
                            byteArrayOutputStream = null;
                        } catch (Exception e27) {
                            e = e27;
                            byteArrayOutputStream = null;
                        }
                        inputStream.close();
                        if (byteArrayOutputStream != null) {
                            str2 = "";
                        } else {
                            str2 = new String(byteArrayOutputStream.toByteArray());
                        }
                        String str52 = str2;
                        r46 = str52;
                        if (QLog.isColorLevel()) {
                            QLog.i("URLUtil", 2, String.format("openUrlGet suc rCode=%d content=%s", Integer.valueOf(responseCode), str52));
                            r46 = str52;
                        }
                    } catch (Throwable th6) {
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        throw th6;
                    }
                } else {
                    QLog.d("URLUtil", 1, "openUrlGet failed " + responseCode);
                }
                httpsURLConnection.disconnect();
            } catch (IOException e28) {
                e = e28;
                httpsURLConnection2 = httpsURLConnection;
                obj3 = null;
                QLog.d("URLUtil", 1, "openUrlGet IOException=", e.getMessage(), e);
                obj5 = obj3;
                obj4 = obj3;
            } catch (Exception e29) {
                e = e29;
                httpsURLConnection2 = httpsURLConnection;
                obj2 = null;
                QLog.d("URLUtil", 1, "openUrlGet Exception=", e.getMessage(), e);
                obj4 = obj2;
                if (httpsURLConnection2 != null) {
                    obj5 = obj2;
                }
                r46 = obj4;
                return r46;
            } catch (Throwable th7) {
                th = th7;
                httpsURLConnection2 = httpsURLConnection;
                obj = null;
                QLog.d("URLUtil", 1, "openUrlGet Throwable=", th.getMessage(), th);
                obj4 = obj;
                if (httpsURLConnection2 != null) {
                    obj5 = obj;
                }
                r46 = obj4;
                return r46;
            }
            return r46;
        } finally {
            if (r46 != 0) {
                r46.disconnect();
            }
        }
    }
}
