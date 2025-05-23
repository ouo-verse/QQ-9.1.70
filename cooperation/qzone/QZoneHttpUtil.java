package cooperation.qzone;

import android.content.Context;
import android.net.Proxy;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IDataUtils;
import cooperation.qzone.util.NetworkState;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.DefaultHttpRoutePlanner;
import org.apache.http.impl.conn.SingleClientConnManager;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;
import org.java_websocket.WebSocketImpl;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QZoneHttpUtil {
    private static final int CONNECTION_TIMEOUT = 20000;
    public static final int DEFAULT_CONNECT_TIMEOUT = 60000;
    public static final int DEFAULT_READ_TIMEOUT = 60000;
    public static final String GET = "GET";
    public static final String GZIP = "gzip";
    public static final String HEADER_CONTENT_ENCODING = "Content-Encoding";
    public static final String HEADER_HOST = "Host";
    public static final String HEADER_X_ONLINE_HOST = "X-Online-Host";
    public static final int HTTP_CLIENT_ERROR = 400;
    public static final int HTTP_CODE_ERROR = 4096;
    public static final int HTTP_CONNECT_ERROR = 1024;
    public static final int HTTP_REDIRECT = 300;
    public static final int HTTP_SERVER_ERROR = 500;
    public static final int HTTP_SUCCESS = 200;
    public static final int HTTP_URL_NOT_AVALIBLE = 2048;
    public static final String POST = "POST";
    public static final char PROTOCOL_HOST_SPLITTER = '/';
    public static final char PROTOCOL_PORT_SPLITTER = ':';
    public static final String PROTOCOL_PREFIX = "https://";
    public static final int PROTOCOL_PREFIX_LENGTH = 8;
    private static final int SO_TIMEOUT = 45000;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static abstract class HttpProxy {
        public static HttpProxy Default = new HttpProxy() { // from class: cooperation.qzone.QZoneHttpUtil.HttpProxy.1
            @Override // cooperation.qzone.QZoneHttpUtil.HttpProxy
            public String getHost() {
                return Proxy.getDefaultHost();
            }

            @Override // cooperation.qzone.QZoneHttpUtil.HttpProxy
            public int getPort() {
                return Proxy.getDefaultPort();
            }
        };

        public abstract String getHost();

        public abstract int getPort();

        public String toString() {
            return getHost() + ':' + getPort();
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class RequestOptions {
        static final boolean DEFAULT_ALLOW_PROXY = true;
        static final boolean DEFAULT_APN_PROXY = false;
        public boolean allowProxy = true;
        public boolean apnProxy = false;
    }

    public static HttpClient createHttpClient(boolean z16) {
        ClientConnectionManager singleClientConnManager;
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setStaleCheckingEnabled(basicHttpParams, false);
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, 20000);
        HttpConnectionParams.setTcpNoDelay(basicHttpParams, true);
        HttpConnectionParams.setSoTimeout(basicHttpParams, 45000);
        HttpConnectionParams.setSocketBufferSize(basicHttpParams, 8192);
        HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setUserAgent(basicHttpParams, "android-qzone");
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        try {
            schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), WebSocketImpl.DEFAULT_WSS_PORT));
        } catch (Exception unused) {
        }
        if (z16) {
            singleClientConnManager = new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry);
        } else {
            singleClientConnManager = new SingleClientConnManager(basicHttpParams, schemeRegistry);
        }
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient(singleClientConnManager, basicHttpParams);
        defaultHttpClient.setRoutePlanner(new DefaultHttpRoutePlanner(singleClientConnManager.getSchemeRegistry()));
        return defaultHttpClient;
    }

    public static HttpPost createHttpPost(Context context, String str, HttpEntity httpEntity, RequestOptions requestOptions) throws MalformedURLException {
        String prepareUrl = prepareUrl(str);
        String prepareHost = prepareHost(prepareUrl);
        HttpPost httpPost = new HttpPost(prepareUrl);
        httpPost.addHeader("Host", prepareHost);
        httpPost.addHeader("x-online-host", prepareHost);
        if (httpEntity instanceof ByteArrayEntity) {
            httpPost.addHeader("Content-Type", "application/octet-stream");
        }
        httpPost.setEntity(httpEntity);
        prepareRequest(context, httpPost, requestOptions);
        return httpPost;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:46:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0115 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00f1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:75:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0131 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r12v20 */
    /* JADX WARN: Type inference failed for: r12v27 */
    /* JADX WARN: Type inference failed for: r12v28 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.io.OutputStream, java.io.BufferedOutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int download(String str, File file) {
        HttpProxy httpProxy;
        String[] strArr;
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        InputStream inputStream2;
        HttpURLConnection httpURLConnection2;
        int i3;
        InputStream inputStream3;
        ?? r06 = "https://";
        InputStream inputStream4 = null;
        if (NetworkState.isWap()) {
            httpProxy = HttpProxy.Default;
        } else {
            httpProxy = null;
        }
        try {
            if (httpProxy != null) {
                try {
                    String[] splitUrl = splitUrl(str);
                    strArr = splitUrl;
                    str = httpProxy.toString() + splitUrl[1];
                } catch (IOException e16) {
                    e = e16;
                    inputStream2 = null;
                    httpURLConnection2 = null;
                    QLog.e("QZoneHttpUtil", 1, "download error HTTP_CONNECT_ERROR ", e);
                    ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(inputStream4);
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException e17) {
                            e17.printStackTrace();
                        }
                    }
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    i3 = 1024;
                    r06 = httpURLConnection2;
                    file = inputStream2;
                    return i3;
                } catch (Exception e18) {
                    e = e18;
                    inputStream = null;
                    httpURLConnection = null;
                    QLog.e("QZoneHttpUtil", 1, "download error HTTP_CODE_ERROR ", e);
                    ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(inputStream4);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e19) {
                            e19.printStackTrace();
                        }
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    i3 = 4096;
                    r06 = httpURLConnection;
                    file = inputStream;
                    return i3;
                } catch (Throwable th5) {
                    th = th5;
                    file = 0;
                    r06 = 0;
                    ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(inputStream4);
                    if (file != 0) {
                        try {
                            file.close();
                        } catch (IOException e26) {
                            e26.printStackTrace();
                        }
                    }
                    if (r06 == 0) {
                        r06.disconnect();
                        throw th;
                    }
                    throw th;
                }
            } else {
                strArr = null;
            }
            if (!str.toLowerCase().startsWith("https://")) {
                str = "https://".concat(str);
            }
            HttpURLConnection httpURLConnection3 = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection3.setReadTimeout(30000);
                httpURLConnection3.setConnectTimeout(15000);
                httpURLConnection3.setRequestMethod("GET");
                httpURLConnection3.setDoInput(true);
                if (httpProxy != null) {
                    httpURLConnection3.setRequestProperty("X-Online-Host", strArr[0]);
                }
                i3 = httpURLConnection3.getResponseCode();
                if (isSuccess(i3)) {
                    ?? bufferedOutputStream = new BufferedOutputStream(new FileOutputStream((File) file, true));
                    try {
                        inputStream4 = httpURLConnection3.getInputStream();
                        byte[] bArr = new byte[8192];
                        while (true) {
                            int read = inputStream4.read(bArr, 0, 8192);
                            if (-1 == read) {
                                break;
                            }
                            bufferedOutputStream.write(bArr, 0, read);
                        }
                        bufferedOutputStream.flush();
                        bufferedOutputStream.close();
                        inputStream3 = inputStream4;
                        inputStream4 = bufferedOutputStream;
                    } catch (IOException e27) {
                        httpURLConnection2 = httpURLConnection3;
                        e = e27;
                        inputStream2 = inputStream4;
                        inputStream4 = bufferedOutputStream;
                        QLog.e("QZoneHttpUtil", 1, "download error HTTP_CONNECT_ERROR ", e);
                        ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(inputStream4);
                        if (inputStream2 != null) {
                        }
                        if (httpURLConnection2 != null) {
                        }
                        i3 = 1024;
                        r06 = httpURLConnection2;
                        file = inputStream2;
                        return i3;
                    } catch (Exception e28) {
                        httpURLConnection = httpURLConnection3;
                        e = e28;
                        inputStream = inputStream4;
                        inputStream4 = bufferedOutputStream;
                        QLog.e("QZoneHttpUtil", 1, "download error HTTP_CODE_ERROR ", e);
                        ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(inputStream4);
                        if (inputStream != null) {
                        }
                        if (httpURLConnection != null) {
                        }
                        i3 = 4096;
                        r06 = httpURLConnection;
                        file = inputStream;
                        return i3;
                    } catch (Throwable th6) {
                        r06 = httpURLConnection3;
                        th = th6;
                        file = inputStream4;
                        inputStream4 = bufferedOutputStream;
                        ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(inputStream4);
                        if (file != 0) {
                        }
                        if (r06 == 0) {
                        }
                    }
                } else {
                    inputStream3 = null;
                }
                ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(inputStream4);
                if (inputStream3 != null) {
                    try {
                        inputStream3.close();
                    } catch (IOException e29) {
                        e29.printStackTrace();
                    }
                }
                httpURLConnection3.disconnect();
            } catch (IOException e36) {
                httpURLConnection2 = httpURLConnection3;
                e = e36;
                inputStream2 = null;
            } catch (Exception e37) {
                httpURLConnection = httpURLConnection3;
                e = e37;
                inputStream = null;
            } catch (Throwable th7) {
                r06 = httpURLConnection3;
                th = th7;
                file = 0;
            }
            return i3;
        } catch (Throwable th8) {
            th = th8;
        }
    }

    public static HttpResponse executeHttpPost(Context context, String str, HttpEntity httpEntity) throws ClientProtocolException, IOException {
        return executeHttpPost(context, str, httpEntity, null);
    }

    public static boolean isSuccess(int i3) {
        if (i3 >= 200 && i3 < 299) {
            return true;
        }
        return false;
    }

    private static String prepareHost(String str) throws MalformedURLException {
        return new URL(str).getAuthority();
    }

    private static void prepareRequest(Context context, HttpRequest httpRequest, RequestOptions requestOptions) {
        boolean z16;
        boolean z17;
        java.net.Proxy proxy;
        InetSocketAddress inetSocketAddress;
        if (requestOptions != null) {
            z16 = requestOptions.allowProxy;
        } else {
            z16 = true;
        }
        if (requestOptions != null) {
            z17 = requestOptions.apnProxy;
        } else {
            z17 = false;
        }
        if (z16 && NetworkState.isMobile() && (proxy = NetworkUtils.getProxy(context, z17)) != null && (inetSocketAddress = (InetSocketAddress) proxy.address()) != null) {
            httpRequest.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, new HttpHost(inetSocketAddress.getHostName(), inetSocketAddress.getPort()));
        }
    }

    private static String prepareUrl(String str) {
        String replace = str.trim().replace(" ", "");
        int indexOf = replace.indexOf(35);
        if (indexOf > 0) {
            return replace.substring(0, indexOf);
        }
        return replace;
    }

    public static String[] splitUrl(String str) {
        String[] strArr = new String[2];
        if (str != null) {
            int length = str.length();
            int i3 = PROTOCOL_PREFIX_LENGTH;
            if (length >= i3) {
                if (!str.toLowerCase().startsWith("https://")) {
                    str = "https://".concat(str);
                }
                int indexOf = str.indexOf(47, i3);
                if (indexOf <= i3) {
                    indexOf = str.length();
                }
                strArr[0] = str.substring(i3, indexOf);
                if (indexOf < str.length()) {
                    strArr[1] = str.substring(indexOf, str.length());
                } else {
                    strArr[1] = "";
                }
            }
        }
        return strArr;
    }

    public static HttpResponse executeHttpPost(Context context, String str, HttpEntity httpEntity, RequestOptions requestOptions) throws ClientProtocolException, IOException {
        return createHttpClient(false).execute(createHttpPost(context, str, httpEntity, requestOptions));
    }
}
