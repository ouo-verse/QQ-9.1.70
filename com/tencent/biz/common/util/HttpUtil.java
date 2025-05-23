package com.tencent.biz.common.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.common.config.AppSetting;
import com.tencent.component.network.utils.http.base.SNIVerifier;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.SniSSLSocketFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tuxmetersdk.export.config.TuxQuestionType;
import com.tencent.util.BaseQRUtil;
import com.tencent.util.Pair;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;
import oicq.wlogin_sdk.tools.ErrMsg;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.AbstractVerifier;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;
import org.java_websocket.WebSocketImpl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import wns_proxy.HttpRsp;

/* compiled from: P */
/* loaded from: classes2.dex */
public class HttpUtil {
    public static final String GET = "GET";
    public static final String LOCAL_IMAGE_QUERY_URL = "https://cgi.connect.qq.com/qqconnectopen/query_share_image?key=%s&size=%d&short_url=0";
    public static final String LOCAL_IMAGE_UPLOAD_HOST = "cgi.connect.qq.com";
    public static final String LOCAL_IMAGE_UPLOAD_NO_SCALE = "1";
    public static final String LOCAL_IMAGE_UPLOAD_URL = "https://cgi.connect.qq.com/qqconnectopen/upload_share_image";
    public static final String POST = "POST";
    public static final int SET_CONNECTION_TIMEOUT = 15000;
    public static final int SET_SOCKET_TIMEOUT = 30000;
    public static final String TAG = "HttpUtil";
    private static final String URL_EXCHANGE_URL = "https://openmobile.qq.com/api/url_change";
    private static final String URL_SHORTEN_URL = "https://openmobile.qq.com/api/shortUrl";
    private static final int VIVO_3G = 17;
    private static boolean hasLookupQrDNS = false;
    private static final SNIVerifier httpVerifier = new SNIVerifier();

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class NetworkProxy {
        public final String host;
        public final int port;

        NetworkProxy(String str, int i3) {
            this.host = str;
            this.port = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a extends AbstractVerifier {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f78447a;

        a(String str) {
            this.f78447a = str;
        }

        public final String toString() {
            return "CUSTOM_COMPATIBLE";
        }

        @Override // org.apache.http.conn.ssl.X509HostnameVerifier
        public final void verify(String str, String[] strArr, String[] strArr2) throws SSLException {
            verify(this.f78447a, strArr, strArr2, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class b implements WtTicketPromise {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ticket[] f78448a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f78449b;

        b(Ticket[] ticketArr, Object obj) {
            this.f78448a = ticketArr;
            this.f78449b = obj;
        }

        @Override // oicq.wlogin_sdk.request.WtTicketPromise
        public void Done(Ticket ticket) {
            this.f78448a[0] = ticket;
            synchronized (this.f78449b) {
                this.f78449b.notifyAll();
            }
        }

        @Override // oicq.wlogin_sdk.request.WtTicketPromise
        public void Failed(ErrMsg errMsg) {
            QLog.e(HttpUtil.TAG, 1, "getPsKeySync Failed, errCode = " + errMsg.getType() + ", errorMsg = ", errMsg.getMessage());
            synchronized (this.f78449b) {
                this.f78449b.notifyAll();
            }
        }

        @Override // oicq.wlogin_sdk.request.WtTicketPromise
        public void Timeout(ErrMsg errMsg) {
            QLog.e(HttpUtil.TAG, 1, "getPsKeySync Timeout.");
            synchronized (this.f78449b) {
                this.f78449b.notifyAll();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class c implements HostnameVerifier {
        c() {
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            boolean verify = HttpsURLConnection.getDefaultHostnameVerifier().verify(HttpUtil.LOCAL_IMAGE_UPLOAD_HOST, sSLSession);
            QLog.d(LogTag.TAG_SHARE_SDK, 1, "queryImageByIP|verify hostname=", str, ", host=", HttpUtil.LOCAL_IMAGE_UPLOAD_HOST, ", verify=", Boolean.valueOf(verify));
            return verify;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class d implements HostnameVerifier {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f78450a;

        d(String str) {
            this.f78450a = str;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            boolean verify = HttpsURLConnection.getDefaultHostnameVerifier().verify(this.f78450a, sSLSession);
            QLog.d(LogTag.TAG_SHARE_SDK, 1, "uploadImageWithHttps|verify hostname=", str, ", host=", this.f78450a, ", verify=", Boolean.valueOf(verify));
            return verify;
        }
    }

    public static final HashMap<String, String> batchUrlExchange(Context context, String str, int i3, HashMap<String, String> hashMap, Bundle bundle) {
        if (hashMap == null) {
            return new HashMap<>();
        }
        HashMap<String, String> hashMap2 = new HashMap<>(hashMap);
        JSONArray jSONArray = new JSONArray();
        ArrayList arrayList = new ArrayList();
        for (String str2 : hashMap.keySet()) {
            String str3 = hashMap.get(str2);
            if (!TextUtils.isEmpty(str3)) {
                jSONArray.mo162put(str3);
                arrayList.add(str2);
            }
        }
        String exchaneUrl = exchaneUrl(context, str, i3, jSONArray);
        if (exchaneUrl != null) {
            try {
                JSONObject jSONObject = new JSONObject(exchaneUrl);
                int i16 = jSONObject.getInt("retcode");
                if (bundle != null) {
                    bundle.putInt("retcode", i16);
                }
                if (i16 == 0) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("result");
                    if (jSONObject2 == null) {
                        return hashMap2;
                    }
                    JSONArray jSONArray2 = jSONObject2.getJSONArray("list");
                    if (jSONArray2 == null) {
                        return hashMap2;
                    }
                    if (jSONArray2.length() == arrayList.size()) {
                        HashMap<String, String> hashMap3 = new HashMap<>();
                        for (int i17 = 0; i17 < jSONArray2.length(); i17++) {
                            hashMap3.put((String) arrayList.get(i17), jSONArray2.getString(i17));
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "batchUrlExchange results: " + hashMap3.toString() + ", input: " + hashMap);
                        }
                        if (bundle != null) {
                            bundle.putBoolean("isSuccess", true);
                        }
                        return hashMap3;
                    }
                    QLog.e(LogTag.TAG_SHARE_SDK, 4, "!!!!urlArray.length() != srcKeyArray.size()");
                }
            } catch (JSONException e16) {
                QLog.d(LogTag.TAG_SHARE_SDK, 4, e16.getMessage());
            }
        }
        return hashMap2;
    }

    public static String decodeHtmlText(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str.replace("&nbsp;", " ").replace("<br>", " ").replace("<br/>", " ").replace("<br />", " ").replace("&amp;", ContainerUtils.FIELD_DELIMITER).replace("&lt;", "<").replace("&gt;", ">").replace("&quot;", "\"").replace("&#92;", "\\").replace("&#39;", "'");
    }

    public static HashMap<String, String> decodeURL(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (str == null) {
            return hashMap;
        }
        String truncateUrlPage = truncateUrlPage(str);
        if (truncateUrlPage == null) {
            return hashMap;
        }
        for (String str2 : truncateUrlPage.split("[&]")) {
            String[] split = str2.split("[=]");
            if (split.length > 1) {
                hashMap.put(URLDecoder.decode(split[0]), URLDecoder.decode(split[1]));
            } else if (!TextUtils.isEmpty(split[0])) {
                hashMap.put(split[0], "");
            }
        }
        return hashMap;
    }

    public static String encodeUrl(Bundle bundle) {
        if (bundle == null) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        boolean z16 = true;
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if ((obj instanceof String) || (obj instanceof String[])) {
                if (obj instanceof String[]) {
                    if (z16) {
                        z16 = false;
                    } else {
                        sb5.append(ContainerUtils.FIELD_DELIMITER);
                    }
                    sb5.append(URLEncoder.encode(str) + ContainerUtils.KEY_VALUE_DELIMITER);
                    String[] stringArray = bundle.getStringArray(str);
                    for (int i3 = 0; i3 < stringArray.length; i3++) {
                        if (i3 == 0) {
                            sb5.append(URLEncoder.encode(stringArray[i3]));
                        } else {
                            sb5.append(URLEncoder.encode("," + stringArray[i3]));
                        }
                    }
                } else {
                    if (z16) {
                        z16 = false;
                    } else {
                        sb5.append(ContainerUtils.FIELD_DELIMITER);
                    }
                    sb5.append(URLEncoder.encode(str) + ContainerUtils.KEY_VALUE_DELIMITER + URLEncoder.encode(bundle.getString(str)));
                }
            }
        }
        return sb5.toString();
    }

    public static String escape(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str.replace(ContainerUtils.FIELD_DELIMITER, "&amp;").replace("'", "&apos;").replace("\"", "&quot;").replace(" ", "&nbsp;").replace("<", "&lt;").replace(">", "&gt;");
    }

    protected static final String exchaneUrl(Context context, String str, int i3, JSONArray jSONArray) {
        Bundle bundle = new Bundle();
        String psKeySync = getPsKeySync(str, "openmobile.qq.com");
        if (!TextUtils.isEmpty(psKeySync)) {
            bundle.putString("cookie", "p_uin=o" + str + ";p_skey=" + psKeySync);
        }
        bundle.putString("Referer", "http://openmobile.qq.com/");
        Bundle bundle2 = new Bundle();
        bundle2.putString("type", String.valueOf(i3));
        bundle2.putString("value", jSONArray.toString());
        bundle2.putString(HttpMsg.MTYPE, AppConstants.HTTP_TYPE_QB_SHARE);
        try {
            return openUrl(context, URL_EXCHANGE_URL, "POST", bundle2, bundle);
        } catch (IOException e16) {
            QLog.d("zivonchen", 4, e16.getMessage());
            return null;
        }
    }

    private static String getAccount() {
        String account;
        AppRuntime runTime = getRunTime();
        if (runTime == null || (account = runTime.getAccount()) == null) {
            return "0";
        }
        return account;
    }

    private static HttpClient getHttpClient(Context context, int i3, int i16, String str) {
        if (context == null) {
            return null;
        }
        SSLSocketFactory socketFactory = SSLSocketFactory.getSocketFactory();
        if (!TextUtils.isEmpty(str)) {
            socketFactory.setHostnameVerifier(new a(str));
        }
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, i3);
        HttpConnectionParams.setSoTimeout(basicHttpParams, i16);
        HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(basicHttpParams, "UTF-8");
        HttpProtocolParams.setUserAgent(basicHttpParams, "AndroidSDK_" + Build.VERSION.SDK + "_" + Build.DEVICE + "_" + Build.VERSION.RELEASE);
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", socketFactory, WebSocketImpl.DEFAULT_WSS_PORT));
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
        NetworkProxy proxy = getProxy(context);
        if (proxy != null) {
            defaultHttpClient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, new HttpHost(proxy.host, proxy.port));
        }
        return defaultHttpClient;
    }

    public static int getNetWorkType() {
        int mobileInfo;
        int i3 = 0;
        if (!AppNetConnInfo.isNetSupport()) {
            return 0;
        }
        if (AppNetConnInfo.isWifiConn()) {
            return 1;
        }
        if (AppNetConnInfo.isMobileConn() && (mobileInfo = AppNetConnInfo.getMobileInfo()) != -1) {
            i3 = 2;
            if (mobileInfo != 0 && mobileInfo != 1) {
                if (mobileInfo == 2) {
                    return 3;
                }
                if (mobileInfo != 3 && mobileInfo != 4) {
                    return -1;
                }
                return 4;
            }
        }
        return i3;
    }

    public static String getNetWorkTypeByStr() {
        switch (getNetWorkType()) {
            case -1:
                return "UNKNOWN";
            case 0:
                return "NONE";
            case 1:
                return Global.TRACKING_WIFI;
            case 2:
                return "2G";
            case 3:
                return "3G";
            case 4:
                return "4G";
            case 5:
                return "CABLE";
            case 6:
                return "5G";
            default:
                return null;
        }
    }

    public static int getNetWorkTypeContain5G() {
        int mobileInfo;
        int i3 = 0;
        if (!AppNetConnInfo.isNetSupport()) {
            return 0;
        }
        if (AppNetConnInfo.isWifiConn()) {
            return 1;
        }
        if (AppNetConnInfo.isMobileConn() && (mobileInfo = AppNetConnInfo.getMobileInfo()) != -1) {
            i3 = 2;
            if (mobileInfo != 0 && mobileInfo != 1) {
                if (mobileInfo == 2) {
                    return 3;
                }
                if (mobileInfo == 3) {
                    return 4;
                }
                if (mobileInfo != 4) {
                    return -1;
                }
                return 6;
            }
        }
        return i3;
    }

    public static NetworkProxy getProxy(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (context == null || (connectivityManager = (ConnectivityManager) BaseApplication.context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !NetworkUtil.isMobileNetworkInfo(activeNetworkInfo)) {
            return null;
        }
        String proxyHost = getProxyHost(context);
        int proxyPort = getProxyPort(context);
        if (isEmpty(proxyHost) || proxyPort < 0) {
            return null;
        }
        return new NetworkProxy(proxyHost, proxyPort);
    }

    public static String getProxyHost(Context context) {
        return System.getProperty("http.proxyHost");
    }

    public static int getProxyPort(Context context) {
        String property = System.getProperty("http.proxyPort");
        if (!isEmpty(property)) {
            try {
                return Integer.parseInt(property);
            } catch (NumberFormatException unused) {
            }
        }
        return -1;
    }

    @Deprecated
    private static String getPsKeySync(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Object obj = new Object();
            Ticket[] ticketArr = {null};
            Ticket pskey = ((TicketManager) getRunTime().getManager(2)).getPskey(str, 16L, new String[]{str2}, new b(ticketArr, obj));
            ticketArr[0] = pskey;
            if (pskey == null) {
                synchronized (obj) {
                    try {
                        obj.wait(5000L);
                    } finally {
                    }
                }
            }
            Ticket ticket = ticketArr[0];
            if (ticket != null) {
                byte[] bArr = ticket._pskey_map.get(str2);
                if (bArr != null) {
                    return new String(bArr);
                }
                QLog.e(TAG, 1, "getPsKeySync, psKeyByte is null.");
                return "";
            }
            return "";
        }
        return "";
    }

    private static AppRuntime getRunTime() {
        return MobileQQ.sMobileQQ.waitAppRuntime(null);
    }

    public static boolean isConnect(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "isConnect(), context == null");
            }
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) BaseApplication.context.getSystemService("connectivity");
            if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
                if (activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
        } catch (Exception e16) {
            QLog.d(TAG, 2, e16.toString());
        }
        return false;
    }

    private static boolean isEmpty(String str) {
        if (str != null && str.length() != 0) {
            return false;
        }
        return true;
    }

    public static final boolean isValidUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!str.startsWith("http://") && !str.startsWith("https://")) {
            return false;
        }
        return true;
    }

    public static String mapToParams(Map<String, String> map) throws UnsupportedEncodingException {
        StringBuilder sb5 = new StringBuilder();
        boolean z16 = true;
        for (String str : map.keySet()) {
            String str2 = map.get(str);
            if (str2 == null) {
                str2 = "";
            }
            if (z16) {
                sb5.append(str + ContainerUtils.KEY_VALUE_DELIMITER + URLEncoder.encode(str2, "utf-8"));
                z16 = false;
            } else {
                sb5.append(ContainerUtils.FIELD_DELIMITER + str + ContainerUtils.KEY_VALUE_DELIMITER + URLEncoder.encode(str2, "utf-8"));
            }
        }
        return sb5.toString();
    }

    public static HttpResponse openRequest(Context context, String str, String str2, String str3, Bundle bundle, Bundle bundle2) throws IOException {
        return openRequest(context, str, str2, str3, bundle, bundle2, 15000, 30000);
    }

    public static String openUrl(Context context, String str, String str2, Bundle bundle, Bundle bundle2) throws IOException {
        HttpResponse openRequest;
        if (bundle == null) {
            bundle = new Bundle();
        }
        String host = Uri.parse(str).getHost();
        try {
            openRequest = openRequest(context, str, null, str2, bundle, bundle2);
        } catch (IOException e16) {
            if (host.equals(BaseQRUtil.QM_QQ_COM)) {
                String ip5 = BaseQRUtil.getIP(context, host);
                if (ip5 != null) {
                    str = str.replace(host, ip5);
                }
                String str3 = str;
                QLog.d("QRHttpUtil", 2, "ClientProtocolException reopen: " + str3);
                openRequest = openRequest(context, str3, host, str2, bundle, bundle2);
            } else {
                throw e16;
            }
        }
        if (openRequest != null) {
            int statusCode = openRequest.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                return readHttpResponse(openRequest);
            }
            throw new IOException("Http statusCode:" + statusCode);
        }
        throw new IOException("Http no response.");
    }

    public static byte[] openUrlForByte(Context context, String str, String str2, Bundle bundle, Bundle bundle2) throws IOException {
        HttpResponse openRequest;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        String host = Uri.parse(str).getHost();
        try {
            openRequest = openRequest(context, str, null, str2, bundle, bundle2);
        } catch (IOException e16) {
            if (host.equals(BaseQRUtil.QM_QQ_COM)) {
                String ip5 = BaseQRUtil.getIP(context, host);
                if (ip5 != null) {
                    str = str.replace(host, ip5);
                }
                String str3 = str;
                QLog.d("QRHttpUtil", 2, "ClientProtocolException reopen: " + str3);
                openRequest = openRequest(context, str3, host, str2, bundle, bundle2);
            } else {
                throw e16;
            }
        }
        if (openRequest != null) {
            int statusCode = openRequest.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                return readHttpResponseSteam(openRequest).toByteArray();
            }
            throw new IOException("Http statusCode:" + statusCode);
        }
        throw new IOException("Http no response.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v5, types: [org.apache.http.HttpResponse] */
    /* JADX WARN: Type inference failed for: r1v6, types: [org.apache.http.HttpResponse] */
    public static byte[] openUrlForByteForPubAccount(Context context, String str, String str2, Bundle bundle, Bundle bundle2, String str3) throws IOException {
        Bundle bundle3;
        String str4;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (bundle == null) {
            bundle3 = new Bundle();
        } else {
            bundle3 = bundle;
        }
        String host = Uri.parse(str).getHost();
        try {
            if (TextUtils.isEmpty(str3)) {
                bundle3 = openRequest(context, str, host, str2, bundle3, bundle2);
            } else {
                bundle3 = openRequest(context, str, host, str2, bundle3, bundle2, 15000, 30000, str3);
            }
        } catch (IOException unused) {
            if (host.equals(BaseQRUtil.QM_QQ_COM)) {
                String ip5 = BaseQRUtil.getIP(context, host);
                if (ip5 != null) {
                    str4 = str.replace(host, ip5);
                } else {
                    str4 = str;
                }
                QLog.d("QRHttpUtil", 2, "ClientProtocolException reopen: " + str4);
                bundle3 = openRequest(context, str4, host, str2, bundle3, bundle2);
            } else {
                throw new IOException("0");
            }
        }
        if (bundle3 != 0) {
            int statusCode = bundle3.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                return readHttpResponseSteam(bundle3).toByteArray();
            }
            throw new IOException("" + statusCode);
        }
        throw new IOException("0");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7, types: [org.apache.http.HttpResponse] */
    /* JADX WARN: Type inference failed for: r1v8, types: [org.apache.http.HttpResponse] */
    public static String openUrlForPubAccount(Context context, String str, String str2, Bundle bundle, Bundle bundle2, String str3) throws IOException {
        Bundle bundle3;
        String str4;
        if (bundle == null) {
            bundle3 = new Bundle();
        } else {
            bundle3 = bundle;
        }
        String host = Uri.parse(str).getHost();
        try {
            if (TextUtils.isEmpty(str3)) {
                bundle3 = openRequest(context, str, host, str2, bundle3, bundle2);
            } else {
                bundle3 = openRequest(context, str, host, str2, bundle3, bundle2, 15000, 30000, str3);
            }
        } catch (IOException unused) {
            if (host.equals(BaseQRUtil.QM_QQ_COM)) {
                String ip5 = BaseQRUtil.getIP(context, host);
                if (ip5 != null) {
                    str4 = str.replace(host, ip5);
                } else {
                    str4 = str;
                }
                QLog.d("QRHttpUtil", 2, "ClientProtocolException reopen: " + str4);
                bundle3 = openRequest(context, str4, host, str2, bundle3, bundle2);
            } else {
                throw new IOException("0");
            }
        } catch (OutOfMemoryError unused2) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "openRequest fail OutOfMemoryError");
            }
            bundle3 = 0;
        }
        if (bundle3 != 0) {
            int statusCode = bundle3.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                try {
                    return readHttpResponse(bundle3);
                } catch (OutOfMemoryError unused3) {
                    throw new IOException("-1");
                }
            }
            throw new IOException("" + statusCode);
        }
        throw new IOException("0");
    }

    public static HttpResponse postRequestWithJson(Context context, String str, String str2, JSONObject jSONObject, Bundle bundle, int i3, int i16, String str3) throws IOException {
        HttpClient httpClient;
        if (!hasLookupQrDNS) {
            hasLookupQrDNS = true;
            BaseQRUtil.lookupIP(context, BaseQRUtil.QM_QQ_COM);
        }
        if (context == null || jSONObject == null || (httpClient = getHttpClient(context, i3, i16, str3)) == null) {
            return null;
        }
        QLog.d("QRHttpUtil", 2, str);
        if (str.contains("#")) {
            str = str.substring(0, str.indexOf(35));
        }
        HttpPost httpPost = new HttpPost(str.replace(" ", "%20"));
        httpPost.addHeader("Accept-Encoding", "gzip");
        httpPost.addHeader("Connection", "close");
        httpPost.setHeader("Content-Type", "application/json; charset=UTF-8");
        byte[] bytes = jSONObject.toString().getBytes();
        if (bundle != null) {
            for (String str4 : bundle.keySet()) {
                Object obj = bundle.get(str4);
                if (obj instanceof String) {
                    httpPost.addHeader(str4, (String) obj);
                }
            }
        }
        httpPost.setEntity(new ByteArrayEntity(bytes));
        if (!TextUtils.isEmpty(str2)) {
            httpPost.getParams().setParameter(ClientPNames.VIRTUAL_HOST, new HttpHost(str2));
        }
        try {
            return httpClient.execute(httpPost);
        } catch (IOException e16) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.d("QRHttpUtil", 2, "openRequestWithJson fail IOException", e16);
            return null;
        } catch (Exception e17) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.d("QRHttpUtil", 2, "openRequestWithJson fail Exception", e17);
            return null;
        } catch (OutOfMemoryError unused) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.d("QRHttpUtil", 2, "openRequestWithJson fail OutOfMemoryError");
            return null;
        }
    }

    public static byte[] postUrlForByteWithJson(Context context, String str, JSONObject jSONObject, Bundle bundle) throws IOException {
        HttpResponse postRequestWithJson;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String host = Uri.parse(str).getHost();
        try {
            postRequestWithJson = postRequestWithJson(context, str, null, jSONObject, bundle, 15000, 30000, null);
        } catch (IOException e16) {
            if (host.equals(BaseQRUtil.QM_QQ_COM)) {
                String ip5 = BaseQRUtil.getIP(context, host);
                if (ip5 != null) {
                    str = str.replace(host, ip5);
                }
                String str2 = str;
                QLog.d("QRHttpUtil", 2, "ClientProtocolException reopen: " + str2);
                postRequestWithJson = postRequestWithJson(context, str2, host, jSONObject, bundle, 15000, 30000, null);
            } else {
                throw e16;
            }
        }
        if (postRequestWithJson != null) {
            int statusCode = postRequestWithJson.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                return readHttpResponseSteam(postRequestWithJson).toByteArray();
            }
            throw new IOException("Http statusCode:" + statusCode);
        }
        throw new IOException("Http no response.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.net.HttpURLConnection] */
    public static Pair<Integer, String> queryImageByIP(String str, String str2) {
        int i3;
        HttpsURLConnection httpsURLConnection;
        int responseCode;
        int i16 = 1;
        QLog.d(LogTag.TAG_SHARE_SDK, 1, "queryImageByIP|urlStr=" + str);
        ?? r65 = 0;
        r6 = null;
        r6 = null;
        r6 = null;
        r6 = null;
        String str3 = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
                        try {
                            c cVar = new c();
                            httpsURLConnection.setSSLSocketFactory(new SniSSLSocketFactory(LOCAL_IMAGE_UPLOAD_HOST, cVar));
                            httpsURLConnection.setHostnameVerifier(cVar);
                            httpsURLConnection.setConnectTimeout(5000);
                            httpsURLConnection.setReadTimeout(30000);
                            httpsURLConnection.setRequestMethod("GET");
                            httpsURLConnection.setRequestProperty("Connection", "Keep-Alive");
                            httpsURLConnection.setRequestProperty("User-Agent", "android_" + Build.VERSION.SDK + "_" + Build.DEVICE + "_" + Build.VERSION.RELEASE + "_" + AppSetting.f99551k);
                            httpsURLConnection.setRequestProperty("Referer", "http://www.qq.com");
                            httpsURLConnection.setRequestProperty("Host", LOCAL_IMAGE_UPLOAD_HOST);
                            String psKeySync = getPsKeySync(str2, "connect.qq.com");
                            if (!TextUtils.isEmpty(psKeySync)) {
                                httpsURLConnection.setRequestProperty("Cookie", "p_uin=o" + str2 + ";p_skey=" + psKeySync);
                            }
                            responseCode = httpsURLConnection.getResponseCode();
                        } catch (Exception e16) {
                            e = e16;
                            i3 = 1;
                        }
                    } catch (Exception e17) {
                        e = e17;
                        i3 = 1;
                        httpsURLConnection = null;
                    } catch (Throwable th5) {
                        th = th5;
                        if (r65 != 0) {
                            r65.disconnect();
                        }
                        throw th;
                    }
                    if (responseCode != 200) {
                        QLog.d(LogTag.TAG_SHARE_SDK, 1, "queryImageByIP|ResponseCode=" + responseCode);
                        Pair<Integer, String> pair = new Pair<>(Integer.valueOf(responseCode), "");
                        httpsURLConnection.disconnect();
                        return pair;
                    }
                    StringBuilder sb5 = new StringBuilder();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream()));
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb5.append(readLine);
                        sb5.append("\n");
                    }
                    bufferedReader.close();
                    String sb6 = sb5.toString();
                    if (!TextUtils.isEmpty(sb6)) {
                        JSONObject jSONObject = new JSONObject(sb6);
                        int i17 = jSONObject.getInt("retcode");
                        if (i17 == 0) {
                            try {
                                if (jSONObject.has("result")) {
                                    i16 = i17;
                                    str3 = jSONObject.getJSONObject("result").getString("url");
                                }
                            } catch (Exception e18) {
                                i3 = i17;
                                e = e18;
                                QLog.e(LogTag.TAG_SHARE_SDK, i16, "queryImageByIP|err=" + e);
                                if (httpsURLConnection != null) {
                                    httpsURLConnection.disconnect();
                                }
                                i16 = i3;
                                return new Pair<>(Integer.valueOf(i16), str3);
                            }
                        }
                        QLog.d(LogTag.TAG_SHARE_SDK, 1, "queryImageByIP|retCode=" + i17);
                        i16 = i17;
                    }
                    httpsURLConnection.disconnect();
                    return new Pair<>(Integer.valueOf(i16), str3);
                }
            } catch (Throwable th6) {
                th = th6;
                r65 = str;
            }
        }
        return null;
    }

    public static String readHttpResponse(HttpResponse httpResponse) throws IllegalStateException, IOException {
        return new String(readHttpResponseSteam(httpResponse).toByteArray());
    }

    public static ByteArrayOutputStream readHttpResponseSteam(HttpResponse httpResponse) throws IOException {
        InputStream inputStream = null;
        try {
            try {
                inputStream = httpResponse.getEntity().getContent();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Header firstHeader = httpResponse.getFirstHeader("Content-Encoding");
                if (firstHeader != null && firstHeader.getValue().toLowerCase().contains("gzip")) {
                    inputStream = new GZIPInputStream(inputStream);
                }
                byte[] bArr = new byte[512];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read != -1) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    } else {
                        inputStream.close();
                        return byteArrayOutputStream;
                    }
                }
            } catch (IOException e16) {
                throw e16;
            } catch (Exception unused) {
                throw new IOException();
            }
        } catch (Throwable th5) {
            if (inputStream != null) {
                inputStream.close();
            }
            throw th5;
        }
    }

    public static String removeHtmlTags(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String[] strArr = {"li", "del", "ins", "fieldset", "legend", ReportConstant.COSTREPORT_TRANS, "th", "caption", "thead", "tbody", "tfoot", "p", "h[1-6]", "dl", "dt", "dd", "ol", "ul", QzoneZipCacheHelper.DIR, "address", "blockquote", "center", "hr", "pre", "form", TuxQuestionType.QUESTION_TEXT_TEXTAREA, "table"};
        String str2 = str;
        for (int i3 = 0; i3 < 27; i3++) {
            Matcher matcher = Pattern.compile("<(\\s*" + strArr[i3] + ")[^>]*>").matcher(str2);
            if (matcher.find()) {
                str2 = matcher.replaceAll(" ");
            }
            Matcher matcher2 = Pattern.compile("</?(\\s*" + strArr[i3] + ")[^>]*>").matcher(str2);
            if (matcher2.find()) {
                str2 = matcher2.replaceAll("\n");
            }
        }
        Matcher matcher3 = Pattern.compile("<br>").matcher(str2);
        if (matcher3.find()) {
            str2 = matcher3.replaceAll("\n");
        }
        return str2.replaceAll("<[^>]*>", "").replaceAll("[(/>)<]", "");
    }

    public static final HashMap<String, String> shortenUrlBatch(HashMap<String, String> hashMap) {
        return shortenUrlBatch(hashMap, null);
    }

    private static String truncateUrlPage(String str) {
        String str2;
        String trim = str.trim();
        String[] split = trim.split("[?]");
        if (trim.length() <= 1 || split.length <= 1 || (str2 = split[1]) == null) {
            return null;
        }
        return str2;
    }

    public static String unEscape(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str.replace("&apos;", "'").replace("&quot;", "\"").replace("&nbsp;", " ").replace("&lt;", "<").replace("&gt;", ">").replace("&amp;", ContainerUtils.FIELD_DELIMITER);
    }

    public static final String uploadImage(String str, String str2, Map<String, String> map, Map<String, String> map2, Map<String, String> map3) {
        int i3;
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            try {
                i3 = 4;
                try {
                    return uploadImage((HttpURLConnection) new URL(str).openConnection(), str, str2, map, map2, map3, str.startsWith("http://cgi.connect.qq.com/qqconnectopen/upload_share_image"));
                } catch (MalformedURLException e16) {
                    e = e16;
                    Object[] objArr = new Object[i3];
                    objArr[0] = "urlStr=";
                    objArr[1] = str;
                    objArr[2] = ", MalformedURLException uploadImage|err=";
                    objArr[3] = e;
                    QLog.e(LogTag.TAG_SHARE_SDK, 1, objArr);
                    return null;
                } catch (IOException e17) {
                    e = e17;
                    Object[] objArr2 = new Object[i3];
                    objArr2[0] = "urlStr=";
                    objArr2[1] = str;
                    objArr2[2] = ", IOException uploadImage|err=";
                    objArr2[3] = e;
                    QLog.e(LogTag.TAG_SHARE_SDK, 1, objArr2);
                    return null;
                }
            } catch (MalformedURLException e18) {
                e = e18;
                i3 = 4;
            } catch (IOException e19) {
                e = e19;
                i3 = 4;
            }
        } else {
            QLog.d(LogTag.TAG_SHARE_SDK, 1, "uploadImage param invalid");
            return null;
        }
    }

    public static String uploadImageWithHttps(String str, String str2, String str3, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, boolean z16) {
        int i3;
        try {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
            d dVar = new d(str2);
            if (!z16) {
                httpsURLConnection.setSSLSocketFactory(new SniSSLSocketFactory(str2, dVar));
            }
            httpsURLConnection.setHostnameVerifier(dVar);
            httpsURLConnection.setRequestProperty("Host", str2);
            i3 = 1;
            try {
                return uploadImage(httpsURLConnection, str, str3, map, map2, map3, z16);
            } catch (MalformedURLException e16) {
                e = e16;
                Object[] objArr = new Object[4];
                objArr[0] = "urlStr=";
                objArr[i3] = str;
                objArr[2] = ", MalformedURLException uploadImage|err=";
                objArr[3] = e;
                QLog.e(LogTag.TAG_SHARE_SDK, i3, objArr);
                return null;
            } catch (IOException e17) {
                e = e17;
                Object[] objArr2 = new Object[4];
                objArr2[0] = "urlStr=";
                objArr2[i3] = str;
                objArr2[2] = ", IOException uploadImage|err=";
                objArr2[3] = e;
                QLog.e(LogTag.TAG_SHARE_SDK, i3, objArr2);
                return null;
            }
        } catch (MalformedURLException e18) {
            e = e18;
            i3 = 1;
        } catch (IOException e19) {
            e = e19;
            i3 = 1;
        }
    }

    public static HttpResponse openRequest(Context context, String str, String str2, String str3, Bundle bundle, Bundle bundle2, int i3, int i16) throws IOException {
        return openRequest(context, str, str2, str3, bundle, bundle2, i3, i16, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00dd A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00de A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final HashMap<String, String> shortenUrlBatch(HashMap<String, String> hashMap, Bundle bundle) {
        String str;
        JSONObject jSONObject;
        int i3;
        if (hashMap == null) {
            return new HashMap<>();
        }
        HashMap<String, String> hashMap2 = new HashMap<>(hashMap);
        JSONArray jSONArray = new JSONArray();
        ArrayList arrayList = new ArrayList();
        for (String str2 : hashMap.keySet()) {
            String str3 = hashMap.get(str2);
            if (!TextUtils.isEmpty(str3)) {
                jSONArray.mo162put(str3);
                arrayList.add(str2);
            }
        }
        Bundle bundle2 = new Bundle();
        String account = getAccount();
        if (!TextUtils.isEmpty(account)) {
            String psKeySync = getPsKeySync(account, "openmobile.qq.com");
            if (!TextUtils.isEmpty(psKeySync)) {
                bundle2.putString("cookie", "p_uin=o" + account + ";p_skey=" + psKeySync);
            }
        }
        bundle2.putString("Referer", "http://openmobile.qq.com/");
        Bundle bundle3 = new Bundle();
        bundle3.putString("value", jSONArray.toString());
        bundle3.putString(HttpMsg.MTYPE, AppConstants.HTTP_TYPE_QB_SHARE);
        try {
            str = openUrl(BaseApplication.getContext(), MsfSdkUtils.insertMtype("AppDepart", URL_SHORTEN_URL), "POST", bundle3, bundle2);
        } catch (IOException e16) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, e16.getMessage());
            }
            str = null;
            if (TextUtils.isEmpty(str)) {
            }
        } catch (OutOfMemoryError e17) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, e17.getMessage());
            }
            str = null;
            if (TextUtils.isEmpty(str)) {
            }
        }
        if (TextUtils.isEmpty(str)) {
            return hashMap2;
        }
        try {
            jSONObject = new JSONObject(str);
            i3 = jSONObject.getInt("retcode");
            if (bundle != null) {
                bundle.putInt("retcode", i3);
            }
        } catch (JSONException unused) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "shortenUrl parse response error");
            }
        }
        if (i3 != 0) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "shortenUrl error retcode:" + i3);
            }
            return hashMap2;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("result");
        if (jSONObject2 == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "shortenUrl error result");
            }
            return hashMap2;
        }
        JSONArray jSONArray2 = jSONObject2.getJSONArray("list");
        if (jSONArray2 == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "shortenUrl error result");
            }
            return hashMap2;
        }
        if (jSONArray2.length() == arrayList.size()) {
            for (int i16 = 0; i16 < jSONArray2.length(); i16++) {
                String string = jSONArray2.getString(i16);
                if (!TextUtils.isEmpty(string)) {
                    hashMap2.put((String) arrayList.get(i16), string);
                }
            }
        } else if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "shortenUrl error result size");
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "shortenUrl results: " + hashMap2.toString() + ", input: " + hashMap);
        }
        return hashMap2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [org.apache.http.client.HttpClient] */
    /* JADX WARN: Type inference failed for: r8v2, types: [org.apache.http.client.methods.HttpPost, org.apache.http.client.methods.HttpEntityEnclosingRequestBase, org.apache.http.message.AbstractHttpMessage] */
    /* JADX WARN: Type inference failed for: r8v3, types: [org.apache.http.HttpMessage, org.apache.http.client.methods.HttpUriRequest] */
    /* JADX WARN: Type inference failed for: r8v5, types: [org.apache.http.client.methods.HttpGet, org.apache.http.HttpMessage] */
    public static HttpResponse openRequest(Context context, String str, String str2, String str3, Bundle bundle, Bundle bundle2, int i3, int i16, String str4) throws IOException {
        ?? httpClient;
        ?? httpPost;
        String str5;
        if (!hasLookupQrDNS) {
            hasLookupQrDNS = true;
            BaseQRUtil.lookupIP(context, BaseQRUtil.QM_QQ_COM);
        }
        if (context == null || (httpClient = getHttpClient(context, i3, i16, str4)) == 0) {
            return null;
        }
        QLog.d("QRHttpUtil", 2, str);
        if (str.contains("#")) {
            str = str.substring(0, str.indexOf(35));
        }
        String replace = str.replace(" ", "%20");
        if ("GET".equals(str3)) {
            String encodeUrl = encodeUrl(bundle);
            if (encodeUrl != null && encodeUrl.length() > 0) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(replace);
                String str6 = QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
                if (replace.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                    str6 = ContainerUtils.FIELD_DELIMITER;
                }
                sb5.append(str6);
                sb5.append(encodeUrl);
                replace = sb5.toString();
            }
            try {
                httpPost = new HttpGet(replace);
                httpPost.addHeader("Accept-Encoding", "gzip");
                httpPost.addHeader("Connection", "close");
                if (bundle2 != null) {
                    for (String str7 : bundle2.keySet()) {
                        Object obj = bundle2.get(str7);
                        if (obj instanceof String) {
                            httpPost.addHeader(str7, (String) obj);
                        }
                    }
                }
            } catch (Exception unused) {
                return null;
            }
        } else {
            httpPost = new HttpPost(replace);
            httpPost.addHeader("Accept-Encoding", "gzip");
            httpPost.addHeader("Connection", "close");
            int i17 = bundle.getInt("PostBodyType");
            if (i17 == 0) {
                str5 = encodeUrl(bundle);
                httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");
            } else if (i17 == 1) {
                httpPost.setHeader("Content-Type", "application/json; charset=UTF-8");
                bundle.remove("PostBodyType");
                JSONObject jSONObject = new JSONObject();
                for (String str8 : bundle.keySet()) {
                    Object obj2 = bundle.get(str8);
                    try {
                        if (obj2 instanceof String) {
                            jSONObject.put(URLEncoder.encode(str8), bundle.getString(str8));
                        } else {
                            if (!(obj2 instanceof Long) && !(obj2 instanceof Integer) && !(obj2 instanceof Float) && !(obj2 instanceof Double) && !(obj2 instanceof Byte)) {
                                if ((obj2 instanceof JSONObject) || (obj2 instanceof JSONArray)) {
                                    jSONObject.put(URLEncoder.encode(str8), obj2);
                                }
                            }
                            jSONObject.put(URLEncoder.encode(str8), obj2);
                        }
                    } catch (JSONException unused2) {
                        if (QLog.isColorLevel()) {
                            QLog.d("QRHttpUtil", 2, "postBodyType=POST_BODY_TYPE_JSON parse Params to Json failed.");
                        }
                    }
                }
                str5 = jSONObject.toString();
            } else {
                str5 = "";
            }
            byte[] bytes = str5.getBytes();
            if (bundle2 != null) {
                for (String str9 : bundle2.keySet()) {
                    Object obj3 = bundle2.get(str9);
                    if (obj3 instanceof String) {
                        httpPost.addHeader(str9, (String) obj3);
                    }
                }
            }
            httpPost.setEntity(new ByteArrayEntity(bytes));
        }
        if (!TextUtils.isEmpty(str2)) {
            httpPost.getParams().setParameter(ClientPNames.VIRTUAL_HOST, new HttpHost(str2));
        }
        try {
            return httpClient.execute(httpPost);
        } catch (IOException e16) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.d("QRHttpUtil", 2, "openRequest fail IOException", e16);
            return null;
        } catch (Exception e17) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.d("QRHttpUtil", 2, "openRequest fail Exception", e17);
            return null;
        } catch (OutOfMemoryError unused3) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.d("QRHttpUtil", 2, "openRequest fail OutOfMemoryError");
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0331  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0305 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x034c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final String uploadImage(HttpURLConnection httpURLConnection, String str, String str2, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, boolean z16) {
        String str3;
        Map<String, String> hashMap;
        DataOutputStream dataOutputStream;
        HttpURLConnection httpURLConnection2 = httpURLConnection;
        String str4 = "image/png";
        try {
            try {
                httpURLConnection2.setConnectTimeout(5000);
                httpURLConnection2.setReadTimeout(30000);
                httpURLConnection2.setDoOutput(true);
                httpURLConnection2.setDoInput(true);
                httpURLConnection2.setUseCaches(false);
                httpURLConnection2.setRequestMethod("POST");
                httpURLConnection2.setRequestProperty("Connection", "Keep-Alive");
                httpURLConnection2.setRequestProperty("User-Agent", "android_" + Build.VERSION.SDK + "_" + Build.DEVICE + "_" + Build.VERSION.RELEASE + "_" + AppSetting.f99551k);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("multipart/form-data; boundary=");
                sb5.append("---------------------------123821742118716");
                httpURLConnection2.setRequestProperty("Content-Type", sb5.toString());
                if (map3 == null) {
                    try {
                        try {
                            hashMap = new HashMap<>();
                        } catch (Throwable th5) {
                            th = th5;
                            Throwable th6 = th;
                            if (httpURLConnection2 == null) {
                                try {
                                    int responseCode = httpURLConnection2.getResponseCode();
                                    if (QLog.isColorLevel()) {
                                        QLog.d(TAG, 2, "responseCode = " + responseCode);
                                    }
                                } catch (Exception e16) {
                                    QLog.e(TAG, 1, "Exception", e16);
                                }
                                httpURLConnection2.disconnect();
                                throw th6;
                            }
                            throw th6;
                        }
                    } catch (Exception e17) {
                        e = e17;
                        str3 = null;
                        QLog.e(TAG, 1, "\u53d1\u9001POST\u8bf7\u6c42\u51fa\u9519\u3002" + str, e);
                        if (httpURLConnection2 != null) {
                            try {
                                int responseCode2 = httpURLConnection2.getResponseCode();
                                if (QLog.isColorLevel()) {
                                    QLog.d(TAG, 2, "responseCode = " + responseCode2);
                                }
                            } catch (Exception e18) {
                                QLog.e(TAG, 1, "Exception", e18);
                            }
                            httpURLConnection2.disconnect();
                        }
                        if (QLog.isColorLevel()) {
                        }
                        return str3;
                    }
                } else {
                    hashMap = map3;
                }
                if (z16) {
                    String psKeySync = getPsKeySync(str2, "connect.qq.com");
                    if (!TextUtils.isEmpty(psKeySync)) {
                        hashMap.put("Cookie", "p_uin=o" + str2 + ";p_skey=" + psKeySync);
                    }
                }
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    httpURLConnection2.setRequestProperty(entry.getKey(), entry.getValue());
                }
                dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                if (map != null) {
                    StringBuffer stringBuffer = new StringBuffer();
                    for (Map.Entry<String, String> entry2 : map.entrySet()) {
                        String key = entry2.getKey();
                        String value = entry2.getValue();
                        if (value != null) {
                            stringBuffer.append("\r\n");
                            stringBuffer.append("--");
                            stringBuffer.append("---------------------------123821742118716");
                            stringBuffer.append("\r\n");
                            stringBuffer.append("Content-Disposition: form-data; name=\"" + key + "\"\r\n\r\n");
                            stringBuffer.append(value);
                        }
                    }
                    dataOutputStream.write(stringBuffer.toString().getBytes());
                }
            } catch (Exception e19) {
                e = e19;
                str4 = null;
            }
            try {
                if (map2 != null) {
                    for (Map.Entry<String, String> entry3 : map2.entrySet()) {
                        String key2 = entry3.getKey();
                        String value2 = entry3.getValue();
                        if (value2 != null) {
                            File file = new File(value2);
                            String name = file.getName();
                            name.endsWith(".png");
                            String str5 = "image/png".equals("") ? "application/octet-stream" : "image/png";
                            StringBuffer stringBuffer2 = new StringBuffer();
                            stringBuffer2.append("\r\n");
                            stringBuffer2.append("--");
                            stringBuffer2.append("---------------------------123821742118716");
                            stringBuffer2.append("\r\n");
                            stringBuffer2.append("Content-Disposition: form-data; name=\"" + key2 + "\"; filename=\"" + name + "\"\r\n");
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append("Content-Type:");
                            sb6.append(str5);
                            sb6.append(HttpRsp.HTTP_HEADER_END);
                            stringBuffer2.append(sb6.toString());
                            dataOutputStream.write(stringBuffer2.toString().getBytes());
                            BufferedInputStream bufferedInputStream = new BufferedInputStream(new BufferedInputStream(new FileInputStream(file)));
                            byte[] bArr = new byte[3072];
                            while (true) {
                                try {
                                    try {
                                        int read = bufferedInputStream.read(bArr);
                                        if (read != -1) {
                                            dataOutputStream.write(bArr, 0, read);
                                        } else {
                                            try {
                                                break;
                                            } catch (Exception e26) {
                                                e = e26;
                                                str3 = null;
                                                httpURLConnection2 = httpURLConnection;
                                                QLog.e(TAG, 1, "\u53d1\u9001POST\u8bf7\u6c42\u51fa\u9519\u3002" + str, e);
                                                if (httpURLConnection2 != null) {
                                                }
                                                if (QLog.isColorLevel()) {
                                                }
                                                return str3;
                                            }
                                        }
                                    } catch (OutOfMemoryError unused) {
                                        QLog.e(TAG, 1, "uploadImage OOM: fileSize = ", Long.valueOf(file.length()), ", name = ", file.getAbsolutePath());
                                        dataOutputStream.flush();
                                        dataOutputStream.close();
                                        httpURLConnection.disconnect();
                                        try {
                                            bufferedInputStream.close();
                                            return null;
                                        } catch (Exception e27) {
                                            e = e27;
                                            httpURLConnection2 = null;
                                            str3 = null;
                                            QLog.e(TAG, 1, "\u53d1\u9001POST\u8bf7\u6c42\u51fa\u9519\u3002" + str, e);
                                            if (httpURLConnection2 != null) {
                                            }
                                            if (QLog.isColorLevel()) {
                                            }
                                            return str3;
                                        } catch (Throwable th7) {
                                            th = th7;
                                            httpURLConnection2 = null;
                                            Throwable th62 = th;
                                            if (httpURLConnection2 == null) {
                                            }
                                        }
                                    }
                                } catch (Throwable th8) {
                                    bufferedInputStream.close();
                                    throw th8;
                                }
                            }
                            bufferedInputStream.close();
                        }
                    }
                }
                dataOutputStream.write(("\r\n-----------------------------123821742118716--\r\n").getBytes());
                dataOutputStream.flush();
                dataOutputStream.close();
                StringBuffer stringBuffer3 = new StringBuffer();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    stringBuffer3.append(readLine);
                    stringBuffer3.append("\n");
                }
                str3 = stringBuffer3.toString();
                try {
                    bufferedReader.close();
                    try {
                        int responseCode3 = httpURLConnection.getResponseCode();
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "responseCode = " + responseCode3);
                        }
                    } catch (Exception e28) {
                        QLog.e(TAG, 1, "Exception", e28);
                    }
                    httpURLConnection.disconnect();
                } catch (Exception e29) {
                    e = e29;
                    httpURLConnection2 = httpURLConnection;
                    QLog.e(TAG, 1, "\u53d1\u9001POST\u8bf7\u6c42\u51fa\u9519\u3002" + str, e);
                    if (httpURLConnection2 != null) {
                    }
                    if (QLog.isColorLevel()) {
                    }
                    return str3;
                }
            } catch (Exception e36) {
                e = e36;
                httpURLConnection2 = httpURLConnection;
                str3 = str4;
                QLog.e(TAG, 1, "\u53d1\u9001POST\u8bf7\u6c42\u51fa\u9519\u3002" + str, e);
                if (httpURLConnection2 != null) {
                }
                if (QLog.isColorLevel()) {
                }
                return str3;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "result = " + str3);
            }
            return str3;
        } catch (Throwable th9) {
            th = th9;
            httpURLConnection2 = httpURLConnection;
        }
    }
}
