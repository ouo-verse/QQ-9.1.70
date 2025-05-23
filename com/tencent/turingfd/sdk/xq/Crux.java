package com.tencent.turingfd.sdk.xq;

import android.net.Network;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.turingfd.sdk.xq.Ginkgo;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import org.apache.httpcore.HttpHeaders;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Crux {

    /* compiled from: P */
    /* renamed from: com.tencent.turingfd.sdk.xq.Crux$do, reason: invalid class name */
    /* loaded from: classes27.dex */
    public class Cdo implements HostnameVerifier {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Filbert f382660a;

        public Cdo(Filbert filbert) {
            this.f382660a = filbert;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) filbert);
            }
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) sSLSession)).booleanValue();
            }
            return HttpsURLConnection.getDefaultHostnameVerifier().verify(this.f382660a.f382748b.getHost(), sSLSession);
        }
    }

    public static Ginkgo a(Filbert filbert) throws IOException {
        URL url;
        InetAddress[] allByName;
        int indexOf;
        if (filbert.f382756j) {
            try {
                String host = filbert.f382748b.getHost();
                Network network = filbert.f382754h;
                if (network != null) {
                    allByName = network.getAllByName(host);
                } else {
                    allByName = InetAddress.getAllByName(host);
                }
                for (InetAddress inetAddress : allByName) {
                    if ((inetAddress instanceof Inet6Address) && (indexOf = filbert.f382747a.indexOf(host)) >= 0) {
                        url = new URL(filbert.f382747a.substring(0, indexOf) + "[" + inetAddress.getHostAddress() + "]" + filbert.f382747a.substring(indexOf + host.length()));
                        break;
                    }
                }
            } catch (Throwable th5) {
                Log.w("TuringFdJava", th5);
            }
            url = null;
            if (url != null) {
                HashMap hashMap = filbert.f382750d == null ? new HashMap() : new HashMap(filbert.f382750d);
                hashMap.put("Host", filbert.f382748b.getHost());
                try {
                    return a(filbert, url, hashMap);
                } catch (IOException unused) {
                }
            }
        }
        return a(filbert, filbert.f382748b, filbert.f382750d);
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x0136 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Ginkgo a(Filbert filbert, URL url, Map<String, String> map) throws IOException {
        OutputStream outputStream;
        HttpURLConnection httpURLConnection;
        BufferedInputStream bufferedInputStream = null;
        try {
            Network network = filbert.f382754h;
            httpURLConnection = network != null ? (HttpURLConnection) network.openConnection(url) : null;
            if (httpURLConnection == null) {
                try {
                    httpURLConnection = (HttpURLConnection) url.openConnection();
                } catch (Throwable th5) {
                    th = th5;
                    outputStream = null;
                    Eridanus.a(outputStream);
                    Eridanus.a(bufferedInputStream);
                    if (httpURLConnection != null) {
                    }
                    throw th;
                }
            }
            httpURLConnection.setRequestProperty("User-Agent", "Turing");
            httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT_CHARSET, "utf-8");
            if (!map.isEmpty()) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                }
            }
            if (filbert.f382756j && url != filbert.f382748b && (httpURLConnection instanceof HttpsURLConnection)) {
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
                httpsURLConnection.setHostnameVerifier(new Cdo(filbert));
                httpsURLConnection.setSSLSocketFactory(new Sapodilla(httpsURLConnection));
            }
            httpURLConnection.setRequestMethod(filbert.f382749c);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setConnectTimeout(filbert.f382752f);
            httpURLConnection.setReadTimeout(filbert.f382753g);
            httpURLConnection.setInstanceFollowRedirects(filbert.f382755i);
            byte[] bArr = filbert.f382751e;
            if (bArr == null || bArr.length == 0) {
                outputStream = null;
            } else {
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setFixedLengthStreamingMode(filbert.f382751e.length);
                outputStream = httpURLConnection.getOutputStream();
                try {
                    outputStream.write(filbert.f382751e);
                    outputStream.flush();
                } catch (Throwable th6) {
                    th = th6;
                    Eridanus.a(outputStream);
                    Eridanus.a(bufferedInputStream);
                    if (httpURLConnection != null) {
                    }
                    throw th;
                }
            }
            Ginkgo.Cdo cdo = new Ginkgo.Cdo();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode != 200) {
                if (responseCode != 305) {
                    switch (responseCode) {
                        case 300:
                        case 301:
                        case 302:
                        case 303:
                            break;
                        default:
                            cdo.f382784a = responseCode;
                            Ginkgo ginkgo = new Ginkgo(cdo);
                            Eridanus.a(outputStream);
                            try {
                                httpURLConnection.disconnect();
                            } catch (Throwable unused) {
                            }
                            return ginkgo;
                    }
                }
                cdo.f382784a = responseCode;
                cdo.f382787d = true;
                cdo.f382786c = httpURLConnection.getHeaderField("Location");
                Ginkgo ginkgo2 = new Ginkgo(cdo);
                Eridanus.a(outputStream);
                try {
                    httpURLConnection.disconnect();
                } catch (Throwable unused2) {
                }
                return ginkgo2;
            }
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(httpURLConnection.getInputStream());
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Eridanus.a(bufferedInputStream2, byteArrayOutputStream);
                URL url2 = httpURLConnection.getURL();
                if (!url.getHost().equals(url2.getHost())) {
                    cdo.f382787d = true;
                    cdo.f382786c = url2.toString();
                }
                cdo.f382785b = byteArrayOutputStream.toByteArray();
                Ginkgo ginkgo3 = new Ginkgo(cdo);
                Eridanus.a(outputStream);
                Eridanus.a(bufferedInputStream2);
                try {
                    httpURLConnection.disconnect();
                } catch (Throwable unused3) {
                }
                return ginkgo3;
            } catch (Throwable th7) {
                th = th7;
                bufferedInputStream = bufferedInputStream2;
                Eridanus.a(outputStream);
                Eridanus.a(bufferedInputStream);
                if (httpURLConnection != null) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable unused4) {
                    }
                }
                throw th;
            }
        } catch (Throwable th8) {
            th = th8;
            outputStream = null;
            httpURLConnection = null;
        }
    }
}
