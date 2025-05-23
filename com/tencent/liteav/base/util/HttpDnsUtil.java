package com.tencent.liteav.base.util;

import android.net.SSLCertificateSocketFactory;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.annotations.JNINamespace;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.HttpURLConnection;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: P */
@JNINamespace("liteav::dns")
/* loaded from: classes7.dex */
public class HttpDnsUtil {
    private static final String TAG = "HttpDnsUtil";
    private static final List<String> WHITE_LIST_HOST;
    private static a mCustomHttpDNSCallback = null;
    private static boolean mEnableCustomHttpDNS = false;
    private static final Object mLock = new Object();
    private static final String sIPV4Regular = "(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])";
    private static final String sVClass = "amF2YXgubmV0LnNzbC5Ib3N0bmFtZVZlcmlmaWVy";
    private static Pattern sValidIPV4Pattern = null;
    private static final String sVerifyMethodBase64 = "c2V0SG9zdG5hbWVWZXJpZmllcg";

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface a {
        void a(String str, List<String> list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class b extends SSLSocketFactory {

        /* renamed from: a, reason: collision with root package name */
        private HttpsURLConnection f119003a;

        public b(HttpsURLConnection httpsURLConnection) {
            this.f119003a = httpsURLConnection;
        }

        @Override // javax.net.SocketFactory
        public final Socket createSocket() throws IOException {
            return null;
        }

        @Override // javax.net.ssl.SSLSocketFactory
        public final String[] getDefaultCipherSuites() {
            return new String[0];
        }

        @Override // javax.net.ssl.SSLSocketFactory
        public final String[] getSupportedCipherSuites() {
            return new String[0];
        }

        @Override // javax.net.SocketFactory
        public final Socket createSocket(String str, int i3) throws IOException, UnknownHostException {
            return null;
        }

        @Override // javax.net.SocketFactory
        public final Socket createSocket(String str, int i3, InetAddress inetAddress, int i16) throws IOException, UnknownHostException {
            return null;
        }

        @Override // javax.net.SocketFactory
        public final Socket createSocket(InetAddress inetAddress, int i3) throws IOException {
            return null;
        }

        @Override // javax.net.SocketFactory
        public final Socket createSocket(InetAddress inetAddress, int i3, InetAddress inetAddress2, int i16) throws IOException {
            return null;
        }

        @Override // javax.net.ssl.SSLSocketFactory
        public final Socket createSocket(Socket socket, String str, int i3, boolean z16) throws IOException {
            String requestProperty = this.f119003a.getRequestProperty("Host");
            if (requestProperty != null) {
                str = requestProperty;
            }
            InetAddress inetAddress = socket.getInetAddress();
            if (z16) {
                socket.close();
            }
            SSLCertificateSocketFactory sSLCertificateSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getDefault(0);
            SSLSocket sSLSocket = (SSLSocket) sSLCertificateSocketFactory.createSocket(inetAddress, i3);
            sSLSocket.setEnabledProtocols(sSLSocket.getSupportedProtocols());
            LiteavLog.i(HttpDnsUtil.TAG, "Setting SNI hostname");
            sSLCertificateSocketFactory.setHostname(sSLSocket, str);
            SSLSession session = sSLSocket.getSession();
            if (HttpsURLConnection.getDefaultHostnameVerifier().verify(str, session)) {
                LiteavLog.i(HttpDnsUtil.TAG, "Established " + session.getProtocol() + " connection with " + session.getPeerHost() + " using " + session.getCipherSuite());
                return sSLSocket;
            }
            throw new SSLPeerUnverifiedException("Cannot verify hostname: ".concat(String.valueOf(str)));
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        WHITE_LIST_HOST = arrayList;
        arrayList.add("intl-sdklog.trtc.tencent-cloud.com");
        arrayList.add("trtc-client-log-overseas-1258344699.cos.ap-singapore.myqcloud.com");
        arrayList.add("inland-sdklog.trtc.tencent-cloud.com");
        arrayList.add("trtc-sdk-log-1258344699.cos.ap-guangzhou.myqcloud.com");
        arrayList.add("trtc-sdk-config-1258344699.file.myqcloud.com");
        arrayList.add("liteav.sdk.qcloud.com");
        arrayList.add("yun.tim.qq.com");
        arrayList.add("videoapi-sgp.im.qcloud.com");
        arrayList.add("sdkdc.live.qcloud.com");
        arrayList.add("mlvbdc.live.qcloud.com");
        arrayList.add("conf.sdk.qcloud.com");
        arrayList.add("speedtestint.trtc.tencent-cloud.com");
        arrayList.add("speedtest.trtc.tencent-cloud.com");
        arrayList.add("webrtc-signal-scheduler.tlivesource.com");
        arrayList.add("cloud.tim.qq.com");
        arrayList.add("livepull.myqcloud.com");
        arrayList.add("livepullipv6.myqcloud.com");
        arrayList.add("tcdns.myqcloud.com");
        arrayList.add("tcdnsipv6.myqcloud.com");
        arrayList.add("liteavapp.qcloud.com");
        arrayList.add("license-test.vod2.myqcloud.com");
        arrayList.add("sdkconfig.tlivesource.com");
        arrayList.add("mlvbdc.live.tlivesource.com");
        arrayList.add("license.vodglcdn.com");
        arrayList.add("license.vod-common.com");
        arrayList.add("license.vodglcdn1.com");
        arrayList.add("license.vod-common1.com");
        arrayList.add("license.vodplayvideo.net");
        arrayList.add("license.vodplayvideo.com");
    }

    public static void applySniForHttpsConnection(HttpURLConnection httpURLConnection, final String str) {
        if (httpURLConnection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            httpsURLConnection.setSSLSocketFactory(new b(httpsURLConnection));
            try {
                InvocationHandler invocationHandler = new InvocationHandler() { // from class: com.tencent.liteav.base.util.HttpDnsUtil.1
                    @Override // java.lang.reflect.InvocationHandler
                    public final Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                        if (method.getName().equals("verify")) {
                            return Boolean.valueOf(HttpsURLConnection.getDefaultHostnameVerifier().verify(str, (SSLSession) objArr[1]));
                        }
                        return method.invoke(HttpsURLConnection.getDefaultHostnameVerifier(), objArr);
                    }
                };
                Class<?> cls = Class.forName(new String(Base64.decode(sVClass, 0)));
                Object newProxyInstance = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, invocationHandler);
                Method declaredMethod = HttpsURLConnection.class.getDeclaredMethod(new String(Base64.decode(sVerifyMethodBase64, 0)), cls);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(httpsURLConnection, newProxyInstance);
            } catch (Throwable th5) {
                LiteavLog.e(TAG, "applySniForHttpsConnection error: " + Log.getStackTraceString(th5));
            }
        }
    }

    public static HttpURLConnection createConnectionUseCustomHttpDNS(String str, String str2) throws Exception {
        String replaceFirst;
        String parseAddressUseCustomHttpDns = parseAddressUseCustomHttpDns(str2);
        if (TextUtils.isEmpty(parseAddressUseCustomHttpDns)) {
            return (HttpURLConnection) new URL(str).openConnection();
        }
        InetAddress byName = InetAddress.getByName(parseAddressUseCustomHttpDns);
        if (byName instanceof Inet4Address) {
            replaceFirst = str.replaceFirst(str2, parseAddressUseCustomHttpDns);
        } else if (byName instanceof Inet6Address) {
            replaceFirst = str.replaceFirst(str2, "[" + parseAddressUseCustomHttpDns + "]");
        } else {
            return (HttpURLConnection) new URL(str).openConnection();
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(replaceFirst).openConnection();
        httpURLConnection.setRequestProperty("Host", str2);
        applySniForHttpsConnection(httpURLConnection, str2);
        LiteavLog.i(TAG, "create http conn use httpDns, original url: " + str + " , new url: " + replaceFirst);
        return httpURLConnection;
    }

    public static void enableCustomHttpDNS(boolean z16, a aVar) {
        synchronized (mLock) {
            mEnableCustomHttpDNS = z16;
            mCustomHttpDNSCallback = aVar;
        }
    }

    public static boolean isHostInWhiteList(String str) {
        return WHITE_LIST_HOST.contains(str);
    }

    public static boolean isIpAddress(String str) {
        if (str != null && !"".equals(str)) {
            if (sValidIPV4Pattern == null) {
                try {
                    sValidIPV4Pattern = Pattern.compile(sIPV4Regular, 2);
                } catch (Exception e16) {
                    LiteavLog.e(TAG, "Pattern.compile fail " + Log.getStackTraceString(e16));
                    return false;
                }
            }
            if (sValidIPV4Pattern.matcher(str).matches() || str.contains(":")) {
                return true;
            }
        }
        return false;
    }

    public static String parseAddressUseCustomHttpDns(String str) {
        if (!verifyCustomHttpDNS(str)) {
            return "";
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        ArrayList arrayList = new ArrayList();
        synchronized (mLock) {
            mCustomHttpDNSCallback.a(str, arrayList);
        }
        if (arrayList.size() > 0) {
            String str2 = (String) arrayList.get(0);
            LiteavLog.i(TAG, "parse host: " + str + " and return ipAddress: " + str2 + " ,costTime: " + (SystemClock.elapsedRealtime() - elapsedRealtime) + " ms");
            return str2;
        }
        return "";
    }

    public static boolean verifyCustomHttpDNS(String str) {
        synchronized (mLock) {
            if (mEnableCustomHttpDNS && mCustomHttpDNSCallback != null) {
                if (isHostInWhiteList(str) || isIpAddress(str)) {
                    return false;
                }
                String property = System.getProperty("http.proxyHost");
                String property2 = System.getProperty("http.proxyPort");
                if (property != null && property2 != null) {
                    LiteavLog.w(TAG, "local proxy is on, don't use httpdns. proxyHost=" + property + " ,proxyPort=" + property2);
                    return false;
                }
                return true;
            }
            return false;
        }
    }
}
