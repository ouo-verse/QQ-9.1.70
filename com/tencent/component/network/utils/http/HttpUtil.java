package com.tencent.component.network.utils.http;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.component.network.Global;
import com.tencent.component.network.downloader.impl.DownloaderImpl;
import com.tencent.component.network.module.base.Config;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.module.common.dns.OkHttpDNS;
import com.tencent.component.network.utils.AssertUtil;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.component.network.utils.http.base.QZoneHttpClient;
import com.tencent.component.network.utils.http.base.SNIVerifier;
import com.tencent.component.network.utils.http.base.SniSSLSocketFactory;
import com.tencent.component.network.utils.http.pool.CustomDnsResolve;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.internal.Util;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.conn.DefaultHttpRoutePlanner;
import org.apache.http.impl.conn.SingleClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.java_websocket.WebSocketImpl;

/* compiled from: P */
/* loaded from: classes5.dex */
public class HttpUtil {
    private static final int CONNECTION_TIMEOUT = 30000;
    private static final ClientOptions DEFAULT_CLIENT_OPTIONS = new ClientOptions();
    private static final int SO_TIMEOUT = 55000;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class RequestOptions {
        static final boolean DEFAULT_ALLOW_PROXY = true;
        static final boolean DEFAULT_APN_PROXY = false;
        public boolean allowProxy = true;
        public boolean apnProxy = false;
        public HttpHost mobileProxyHost = null;
        public Proxy mobileProxy = null;
    }

    public static QZoneHttpClient CreateDefaultHttpClient() {
        return CreateDefaultHttpClient(null);
    }

    public static boolean containsProxy(HttpRequest httpRequest, RequestOptions requestOptions) {
        if (httpRequest != null) {
            Object parameter = httpRequest.getParams().getParameter(ConnRoutePNames.DEFAULT_PROXY);
            if (parameter != null && (parameter instanceof HttpHost)) {
                return true;
            }
            return false;
        }
        Proxy prepareRequest = prepareRequest(requestOptions);
        if (prepareRequest != null && prepareRequest.address() != null) {
            return true;
        }
        return false;
    }

    public static OkHttpClient createHttp2Client() {
        return createHttp2Client(null, null);
    }

    public static HttpClient createHttpClient() {
        return createHttpClient(null);
    }

    public static HttpContext createHttpContext() {
        return new BasicHttpContext();
    }

    public static HttpGet createHttpGet(Context context, String str) throws MalformedURLException {
        return createHttpGet(context, str, null);
    }

    public static HttpPost createHttpPost(Context context, String str, HttpEntity httpEntity) throws MalformedURLException {
        return createHttpPost(context, str, httpEntity, null);
    }

    public static Request.Builder createOkHttpGet(Context context, String str, String str2, String str3) throws MalformedURLException {
        String prepareRefer = prepareRefer(str);
        Request.Builder url = new Request.Builder().url(prepareUrl(str3));
        url.addHeader("x-online-host", str2);
        url.addHeader("Host", str2);
        String qua = Config.getQUA();
        if (!TextUtils.isEmpty(qua)) {
            url.addHeader("Q-UA", qua);
        }
        if (TextUtils.isEmpty(prepareRefer)) {
            prepareRefer = Config.getDefaultRefer();
        }
        url.addHeader("Referer", prepareRefer);
        String userAgent = Config.getUserAgent();
        if (!TextUtils.isEmpty(userAgent)) {
            url.header("User-Agent", userAgent);
        }
        return url;
    }

    public static HttpResponse executeHttpPost(Context context, String str, HttpEntity httpEntity) throws IOException {
        return executeHttpPost(context, str, httpEntity, null);
    }

    private static String prepareHost(String str) throws MalformedURLException {
        boolean z16;
        if (str != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        AssertUtil.assertTrue(z16);
        return new URL(str).getAuthority();
    }

    public static String prepareRefer(String str) {
        boolean z16;
        if (str != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        AssertUtil.assertTrue(z16);
        int indexOf = str.indexOf("&rf=");
        if (indexOf < 0) {
            return "";
        }
        int i3 = indexOf + 4;
        int indexOf2 = str.indexOf(ContainerUtils.FIELD_DELIMITER, i3);
        if (indexOf2 > i3) {
            return str.substring(i3, indexOf2);
        }
        return str.substring(i3);
    }

    private static void prepareRequest(Context context, HttpRequest httpRequest, RequestOptions requestOptions) {
        Proxy proxy;
        InetSocketAddress inetSocketAddress;
        if (requestOptions != null && requestOptions.mobileProxy != null && NetworkUtils.isMobileConnected(context)) {
            httpRequest.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, requestOptions.mobileProxy);
            return;
        }
        boolean z16 = requestOptions != null ? requestOptions.allowProxy : true;
        boolean z17 = requestOptions != null ? requestOptions.apnProxy : false;
        if (!z16 || !NetworkUtils.isMobileConnected(context) || (proxy = NetworkUtils.getProxy(context, z17)) == null || (inetSocketAddress = (InetSocketAddress) proxy.address()) == null) {
            return;
        }
        httpRequest.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, new HttpHost(inetSocketAddress.getHostName(), inetSocketAddress.getPort()));
        if (QDLog.isDebugEnable()) {
            QDLog.d(QDLog.TAG_DOWNLOAD, "use proxy[host:" + inetSocketAddress.getHostName() + ",port:" + inetSocketAddress.getPort() + "]");
        }
    }

    private static String prepareUrl(String str) {
        boolean z16;
        if (str != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        AssertUtil.assertTrue(z16);
        String replace = str.trim().replace(" ", "");
        int indexOf = replace.indexOf(35);
        if (indexOf > 0) {
            return replace.substring(0, indexOf);
        }
        return replace;
    }

    public static void setKeepAliveEnabled(HttpRequest httpRequest, Request.Builder builder, boolean z16) {
        String str = "Keep-Alive";
        if (httpRequest != null) {
            if (!z16) {
                str = "Close";
            }
            httpRequest.setHeader("Connection", str);
        } else if (builder != null) {
            if (!z16) {
                str = "Close";
            }
            builder.header("Connection", str);
        }
    }

    public static QZoneHttpClient CreateDefaultHttpClient(CustomDnsResolve customDnsResolve) {
        ClientOptions clientOptions = new ClientOptions();
        clientOptions.multiConnection = true;
        clientOptions.maxConnection = DownloaderImpl.MAX_CONNECTION;
        clientOptions.maxConnectionPerRoute = DownloaderImpl.MAX_CONNECTION_PER_ROUTE;
        clientOptions.timeToLive = DownloaderImpl.TIME_TO_LIVE_HTTP;
        clientOptions.timeToLiveUnit = DownloaderImpl.TIME_TO_LIVE_UNIT;
        clientOptions.dnsResolve = customDnsResolve;
        return createHttpClient(clientOptions);
    }

    public static OkHttpClient createHttp2Client(ClientOptions clientOptions, CustomDnsResolve customDnsResolve) {
        if (clientOptions == null) {
            clientOptions = DEFAULT_CLIENT_OPTIONS;
        }
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (clientOptions != null) {
            long j3 = clientOptions.connTimeout;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            builder.connectTimeout(j3, timeUnit).readTimeout(clientOptions.soTimeout, timeUnit).writeTimeout(clientOptions.soTimeout, timeUnit);
        }
        builder.connectionPool(new ConnectionPool(clientOptions.maxConnection, clientOptions.timeToLive * 1000, TimeUnit.MILLISECONDS)).hostnameVerifier(SSLSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER).protocols(Util.immutableList(Protocol.HTTP_2, Protocol.HTTP_1_1)).dns(new OkHttpDNS(customDnsResolve));
        return builder.build();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v12, types: [com.tencent.component.network.utils.http.PoolingClientConnectionManager] */
    public static QZoneHttpClient createHttpClient(ClientOptions clientOptions) {
        SingleClientConnManager singleClientConnManager;
        if (clientOptions == null) {
            clientOptions = DEFAULT_CLIENT_OPTIONS;
        }
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setStaleCheckingEnabled(basicHttpParams, false);
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, clientOptions.connTimeout);
        HttpConnectionParams.setTcpNoDelay(basicHttpParams, true);
        HttpConnectionParams.setSoTimeout(basicHttpParams, clientOptions.soTimeout);
        HttpConnectionParams.setSocketBufferSize(basicHttpParams, 8192);
        HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setUserAgent(basicHttpParams, Config.getUserAgent());
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        try {
            schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
            SniSSLSocketFactory sniSSLSocketFactory = new SniSSLSocketFactory(null);
            sniSSLSocketFactory.setHostnameVerifier(new SNIVerifier());
            schemeRegistry.register(new Scheme("https", sniSSLSocketFactory, WebSocketImpl.DEFAULT_WSS_PORT));
        } catch (Throwable th5) {
            QDLog.e(QDLog.TAG_DOWNLOAD, "", th5);
        }
        if (clientOptions.multiConnection) {
            ?? poolingClientConnectionManager = new PoolingClientConnectionManager(schemeRegistry, clientOptions.timeToLive, clientOptions.timeToLiveUnit, new SystemDefaultDnsResolver(), clientOptions.dnsResolve);
            int i3 = clientOptions.maxConnectionPerRoute;
            if (i3 > 0) {
                poolingClientConnectionManager.setDefaultMaxPerRoute(i3);
            }
            int i16 = clientOptions.maxConnection;
            singleClientConnManager = poolingClientConnectionManager;
            if (i16 > 0) {
                poolingClientConnectionManager.setMaxTotal(i16);
                singleClientConnManager = poolingClientConnectionManager;
            }
        } else {
            singleClientConnManager = new SingleClientConnManager(basicHttpParams, schemeRegistry);
        }
        ConnManagerParams.setTimeout(basicHttpParams, clientOptions.connManagerTimeout);
        QZoneHttpClient qZoneHttpClient = new QZoneHttpClient(singleClientConnManager, basicHttpParams);
        qZoneHttpClient.setRoutePlanner(new DefaultHttpRoutePlanner(singleClientConnManager.getSchemeRegistry()));
        return qZoneHttpClient;
    }

    public static HttpGet createHttpGet(Context context, String str, String str2, String str3, RequestOptions requestOptions) throws MalformedURLException {
        String prepareRefer = prepareRefer(str);
        HttpGet httpGet = new HttpGet(prepareUrl(str3));
        httpGet.addHeader("x-online-host", str2);
        httpGet.addHeader("Host", str2);
        String qua = Config.getQUA();
        if (!TextUtils.isEmpty(qua)) {
            httpGet.addHeader("Q-UA", qua);
        }
        if (TextUtils.isEmpty(prepareRefer)) {
            prepareRefer = Config.getDefaultRefer();
        }
        httpGet.addHeader("Referer", prepareRefer);
        prepareRequest(context, httpGet, requestOptions);
        return httpGet;
    }

    public static HttpPost createHttpPost(Context context, String str, HttpEntity httpEntity, RequestOptions requestOptions) throws MalformedURLException {
        String prepareUrl = prepareUrl(str);
        String prepareHost = prepareHost(prepareUrl);
        HttpPost httpPost = new HttpPost(prepareUrl);
        httpPost.addHeader("Host", prepareHost);
        httpPost.addHeader("x-online-host", prepareHost);
        String qua = Config.getQUA();
        if (!TextUtils.isEmpty(qua)) {
            httpPost.addHeader("Q-UA", qua);
        }
        httpPost.addHeader("Referer", Config.getDefaultRefer());
        if (httpEntity instanceof ByteArrayEntity) {
            httpPost.addHeader("Content-Type", "application/octet-stream");
        }
        httpPost.setEntity(httpEntity);
        prepareRequest(context, httpPost, requestOptions);
        return httpPost;
    }

    public static HttpResponse executeHttpPost(Context context, String str, HttpEntity httpEntity, RequestOptions requestOptions) throws IOException {
        return createHttpClient().execute(createHttpPost(context, str, httpEntity, requestOptions));
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class ClientOptions {
        public int connManagerTimeout;
        public int connTimeout;
        public CustomDnsResolve dnsResolve;
        public int maxConnection;
        public int maxConnectionPerRoute;
        public boolean multiConnection;
        public Proxy proxy;
        public int soTimeout;
        public long timeToLive;
        public TimeUnit timeToLiveUnit;

        public ClientOptions() {
            this.multiConnection = false;
            this.timeToLive = -1L;
            this.timeToLiveUnit = TimeUnit.SECONDS;
            this.maxConnection = -1;
            this.maxConnectionPerRoute = -1;
            this.connTimeout = 30000;
            this.connManagerTimeout = 30000;
            this.soTimeout = HttpUtil.SO_TIMEOUT;
            this.proxy = Proxy.NO_PROXY;
            this.dnsResolve = null;
        }

        public ClientOptions(boolean z16) {
            this.multiConnection = false;
            this.timeToLive = -1L;
            this.timeToLiveUnit = TimeUnit.SECONDS;
            this.maxConnection = -1;
            this.maxConnectionPerRoute = -1;
            this.connTimeout = 30000;
            this.connManagerTimeout = 30000;
            this.soTimeout = HttpUtil.SO_TIMEOUT;
            this.proxy = Proxy.NO_PROXY;
            this.dnsResolve = null;
            this.multiConnection = z16;
            if (z16) {
                this.maxConnection = DownloaderImpl.MAX_CONNECTION;
                this.maxConnectionPerRoute = DownloaderImpl.MAX_CONNECTION_PER_ROUTE;
                this.timeToLive = DownloaderImpl.TIME_TO_LIVE_HTTP;
                this.timeToLiveUnit = DownloaderImpl.TIME_TO_LIVE_UNIT;
            }
        }
    }

    public static HttpGet createHttpGet(Context context, String str, String str2, String str3, String str4, RequestOptions requestOptions) throws MalformedURLException {
        HttpGet httpGet = new HttpGet(prepareUrl(str3));
        httpGet.addHeader("x-online-host", str2);
        httpGet.addHeader("Host", str2);
        String qua = Config.getQUA();
        if (!TextUtils.isEmpty(qua)) {
            httpGet.addHeader("Q-UA", qua);
        }
        if (TextUtils.isEmpty(str4)) {
            str4 = Config.getDefaultRefer();
        }
        httpGet.addHeader("Referer", str4);
        prepareRequest(context, httpGet, requestOptions);
        return httpGet;
    }

    public static Proxy prepareRequest(RequestOptions requestOptions) {
        Proxy proxy = Proxy.NO_PROXY;
        Context context = Global.getContext();
        if (context == null) {
            return proxy;
        }
        if (requestOptions != null && requestOptions.mobileProxy != null && NetworkUtils.isMobileConnected(context)) {
            return requestOptions.mobileProxy;
        }
        boolean z16 = requestOptions != null ? requestOptions.allowProxy : true;
        boolean z17 = requestOptions != null ? requestOptions.apnProxy : false;
        if (!z16 || !NetworkUtils.isMobileConnected(context)) {
            return proxy;
        }
        Proxy proxy2 = NetworkUtils.getProxy(context, z17);
        if (proxy2 != null && QDLog.isDebugEnable() && (proxy2.address() instanceof InetSocketAddress)) {
            InetSocketAddress inetSocketAddress = (InetSocketAddress) proxy2.address();
            QDLog.d(QDLog.TAG_DOWNLOAD, "use proxy[host:" + inetSocketAddress.getHostName() + ",port:" + inetSocketAddress.getPort() + "]");
        }
        return proxy2;
    }

    public static Request.Builder createOkHttpGet(Context context, String str, String str2, String str3, String str4) throws MalformedURLException {
        Request.Builder url = new Request.Builder().url(prepareUrl(str3));
        String qua = Config.getQUA();
        if (!TextUtils.isEmpty(qua)) {
            url.addHeader("Q-UA", qua);
        }
        if (TextUtils.isEmpty(str4)) {
            str4 = Config.getDefaultRefer();
        }
        url.addHeader("Referer", str4);
        String userAgent = Config.getUserAgent();
        if (!TextUtils.isEmpty(userAgent)) {
            url.header("User-Agent", userAgent);
        }
        return url;
    }

    public static HttpGet createHttpGet(Context context, String str, String str2, RequestOptions requestOptions) throws MalformedURLException {
        String prepareRefer = prepareRefer(str);
        String prepareUrl = prepareUrl(str);
        String prepareUrl2 = prepareUrl(str2);
        String prepareHost = prepareHost(prepareUrl);
        HttpGet httpGet = new HttpGet(prepareUrl2);
        httpGet.addHeader("x-online-host", prepareHost);
        httpGet.addHeader("Host", prepareHost);
        String qua = Config.getQUA();
        if (!TextUtils.isEmpty(qua)) {
            httpGet.addHeader("Q-UA", qua);
        }
        if (TextUtils.isEmpty(prepareRefer)) {
            prepareRefer = Config.getDefaultRefer();
        }
        httpGet.addHeader("Referer", prepareRefer);
        prepareRequest(context, httpGet, requestOptions);
        return httpGet;
    }

    public static Request createOkHttpGet(Context context, String str) throws MalformedURLException {
        String prepareRefer = prepareRefer(str);
        String prepareUrl = prepareUrl(str);
        String prepareHost = prepareHost(prepareUrl);
        Request.Builder url = new Request.Builder().url(prepareUrl);
        url.addHeader("x-online-host", prepareHost);
        url.addHeader("Host", prepareHost);
        String qua = Config.getQUA();
        if (!TextUtils.isEmpty(qua)) {
            url.addHeader("Q-UA", qua);
        }
        if (TextUtils.isEmpty(prepareRefer)) {
            prepareRefer = Config.getDefaultRefer();
        }
        url.addHeader("Referer", prepareRefer);
        return url.build();
    }

    public static HttpGet createHttpGet(Context context, String str, RequestOptions requestOptions) throws MalformedURLException {
        String prepareRefer = prepareRefer(str);
        String prepareUrl = prepareUrl(str);
        String prepareHost = prepareHost(prepareUrl);
        HttpGet httpGet = new HttpGet(prepareUrl);
        httpGet.addHeader("x-online-host", prepareHost);
        httpGet.addHeader("Host", prepareHost);
        String qua = Config.getQUA();
        if (!TextUtils.isEmpty(qua)) {
            httpGet.addHeader("Q-UA", qua);
        }
        if (TextUtils.isEmpty(prepareRefer)) {
            prepareRefer = Config.getDefaultRefer();
        }
        httpGet.addHeader("Referer", prepareRefer);
        prepareRequest(context, httpGet, requestOptions);
        return httpGet;
    }
}
