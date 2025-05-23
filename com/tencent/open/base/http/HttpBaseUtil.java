package com.tencent.open.base.http;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.open.base.f;
import com.tencent.open.business.base.OpenConfig;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HttpContext;
import org.java_websocket.WebSocketImpl;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@SuppressLint({"DefaultLocale"})
/* loaded from: classes22.dex */
public class HttpBaseUtil {

    /* renamed from: a, reason: collision with root package name */
    protected static final String f340993a = "com.tencent.open.base.http.HttpBaseUtil";

    /* renamed from: b, reason: collision with root package name */
    public static HashMap<String, String> f340994b = new HashMap<>(64);

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class HttpStatusException extends Exception {
        public static final String ERROR_INFO = "http status code error:";

        public HttpStatusException(String str) {
            super(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class NetworkUnavailableException extends Exception {
        public static final String ERROR_INFO = "network unavailable";

        public NetworkUnavailableException(String str) {
            super(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public HttpResponse f340995a;

        /* renamed from: b, reason: collision with root package name */
        public int f340996b;

        public a(HttpResponse httpResponse, int i3) {
            this.f340995a = httpResponse;
            this.f340996b = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f340997a;

        /* renamed from: b, reason: collision with root package name */
        public final int f340998b;

        protected b(String str, int i3) {
            this.f340997a = str;
            this.f340998b = i3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public String f340999a;

        /* renamed from: b, reason: collision with root package name */
        public long f341000b;

        /* renamed from: c, reason: collision with root package name */
        public long f341001c;

        /* renamed from: d, reason: collision with root package name */
        public int f341002d;

        /* renamed from: e, reason: collision with root package name */
        public InputStream f341003e;

        public c(String str, int i3, int i16) {
            this.f340999a = str;
            this.f341000b = i3;
            this.f341002d = i16;
            if (str != null) {
                this.f341001c = str.length();
            }
        }
    }

    public static String a(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.length() < 10) {
                StringBuilder sb5 = new StringBuilder("o");
                for (int length = str.length(); length < 10; length++) {
                    sb5.append("0");
                }
                sb5.append(str);
                return sb5.toString();
            }
            return "o" + str;
        }
        return str;
    }

    public static String b(InputStream inputStream) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb5 = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                sb5.append(readLine);
            } else {
                bufferedReader.close();
                return sb5.toString();
            }
        }
    }

    public static String c(String str, Bundle bundle) {
        String d16 = d(bundle);
        if (str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER) == -1) {
            str = str + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
        } else if (!str.endsWith(ContainerUtils.FIELD_DELIMITER) && !TextUtils.isEmpty(d16)) {
            str = str + ContainerUtils.FIELD_DELIMITER;
        }
        return str + d16;
    }

    public static String d(Bundle bundle) {
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
                    sb5.append(URLEncoder.encode(str));
                    sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    String[] stringArray = bundle.getStringArray(str);
                    for (int i3 = 0; i3 < stringArray.length; i3++) {
                        if (i3 == 0) {
                            sb5.append(URLEncoder.encode(stringArray[i3]));
                        } else {
                            sb5.append(",");
                            sb5.append(URLEncoder.encode(stringArray[i3]));
                        }
                    }
                } else {
                    if (z16) {
                        z16 = false;
                    } else {
                        sb5.append(ContainerUtils.FIELD_DELIMITER);
                    }
                    sb5.append(URLEncoder.encode(str));
                    sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    sb5.append(URLEncoder.encode(bundle.getString(str)));
                }
            }
        }
        return sb5.toString();
    }

    public static String e() {
        f340994b.put("uin", a(String.valueOf(com.tencent.open.adapter.a.f().l())));
        f340994b.put("skey", com.tencent.open.adapter.a.f().k());
        f340994b.put("qua", com.tencent.open.adapter.a.f().i());
        String str = "";
        for (String str2 : f340994b.keySet()) {
            str = str + str2 + ContainerUtils.KEY_VALUE_DELIMITER + f340994b.get(str2) + "; ";
        }
        return str;
    }

    public static HttpClient f(String str, String str2) {
        SSLSocketFactory socketFactory = SSLSocketFactory.getSocketFactory();
        if (!TextUtils.isEmpty(str2)) {
            str2.contains("https");
        }
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        int j3 = OpenConfig.i(com.tencent.open.adapter.a.f().e(), str).j("Common_HttpConnectionTimeout");
        f.a("OpenConfig_agent", "config 3:Common_HttpConnectionTimeout     config_value:" + j3 + "   appid:" + str + "     url:" + str2);
        if (j3 == 0) {
            j3 = 15000;
        }
        f.a("OpenConfig_agent", "config 3:Common_HttpConnectionTimeout     result_value:" + j3 + "   appid:" + str + "     url:" + str2);
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, j3);
        int j16 = OpenConfig.i(com.tencent.open.adapter.a.f().e(), str).j("Common_SocketConnectionTimeout");
        f.a("OpenConfig_agent", "config 4:Common_SocketConnectionTimeout   config_value:" + j16 + "   appid:" + str + "     url:" + str2);
        if (j16 == 0) {
            j16 = 30000;
        }
        f.a("OpenConfig_agent", "config 4:Common_SocketConnectionTimeout   result_value:" + j16 + "   appid:" + str + "     url:" + str2);
        HttpConnectionParams.setSoTimeout(basicHttpParams, j16);
        HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(basicHttpParams, "UTF-8");
        HttpProtocolParams.setUserAgent(basicHttpParams, "AndroidSDK_" + Build.VERSION.SDK + "_" + Build.DEVICE + "_" + Build.VERSION.RELEASE);
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", socketFactory, WebSocketImpl.DEFAULT_WSS_PORT));
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
        b g16 = g(com.tencent.open.adapter.a.f().e());
        if (g16 != null) {
            defaultHttpClient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, new HttpHost(g16.f340997a, g16.f340998b));
        }
        return defaultHttpClient;
    }

    protected static b g(Context context) {
        if (context == null || NetworkUtil.getNetworkType(context) != 0) {
            return null;
        }
        String h16 = h();
        int i3 = i();
        if (TextUtils.isEmpty(h16) || i3 < 0) {
            return null;
        }
        return new b(h16, i3);
    }

    protected static String h() {
        return System.getProperty("http.proxyHost");
    }

    protected static int i() {
        String property = System.getProperty("http.proxyPort");
        if (!TextUtils.isEmpty(property)) {
            try {
                return Integer.parseInt(property);
            } catch (NumberFormatException unused) {
            }
        }
        return -1;
    }

    protected static Boolean j(HttpResponse httpResponse) {
        Header firstHeader = httpResponse.getFirstHeader("Content-Encoding");
        if (firstHeader != null && firstHeader.getValue().toLowerCase().indexOf("gzip") > -1) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    protected static a k(String str, String str2, Bundle bundle) throws Exception {
        return l(str, str2, bundle, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v3, types: [org.apache.http.client.methods.HttpPost, org.apache.http.client.methods.HttpEntityEnclosingRequestBase, org.apache.http.message.AbstractHttpMessage] */
    public static a l(String str, String str2, Bundle bundle, HttpContext httpContext) throws Exception {
        HttpGet httpGet;
        HttpResponse execute;
        String str3;
        if (AppNetConnInfo.isNetSupport()) {
            try {
                String string = bundle.getString("needhttpcache");
                String string2 = bundle.getString("LastModifyUseString");
                bundle.remove("needhttpcache");
                bundle.remove("LastModifyUseString");
                String string3 = bundle.getString("appid_for_getting_config");
                bundle.remove("appid_for_getting_config");
                HttpClient f16 = f(string3, str);
                int length = str.length();
                if (str2.equals("GET")) {
                    String d16 = d(bundle);
                    int length2 = length + d16.length();
                    if (str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER) == -1) {
                        str3 = str + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
                    } else if (!str.endsWith(ContainerUtils.FIELD_DELIMITER) && !TextUtils.isEmpty(d16)) {
                        str3 = str + ContainerUtils.FIELD_DELIMITER;
                    } else {
                        str3 = str;
                    }
                    String str4 = str + d16;
                    httpGet = new HttpGet(str3 + d16);
                    httpGet.addHeader("Accept-Encoding", "gzip");
                    if (bundle.containsKey("Referer")) {
                        httpGet.addHeader("Referer", bundle.getString("Referer"));
                    }
                    if (bundle.containsKey("Cookie")) {
                        httpGet.addHeader("Cookie", bundle.getString("Cookie"));
                    }
                    httpGet.addHeader("Content-Type", "application/x-www-form-urlencoded");
                    if (string != null) {
                        httpGet.addHeader("If-None-Match", com.tencent.open.base.http.c.d().c(str4));
                        if (string2 != null) {
                            httpGet.addHeader("If-Modified-Since", "\"" + com.tencent.open.base.http.c.d().f(str4) + "\"");
                        } else {
                            httpGet.addHeader("If-Modified-Since", "\"" + com.tencent.open.base.http.c.d().e(str4) + "\"");
                            f.a(f340993a, "add header. If-None-Match:" + com.tencent.open.base.http.c.d().c(str4) + "; If-Modified-Since:" + com.tencent.open.base.http.c.d().e(str4));
                        }
                    }
                    length = length2;
                } else if (str2.equals("POST")) {
                    ?? httpPost = new HttpPost(str);
                    httpPost.addHeader("Accept-Encoding", "gzip");
                    httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
                    int i3 = 0;
                    boolean z16 = bundle.getBoolean("doAuthorize", false);
                    bundle.remove("doAuthorize");
                    String string4 = bundle.getString("cmshow_download_key");
                    if (!TextUtils.isEmpty(string4) && string4.equals("cmshow_downLoad")) {
                        if (bundle.containsKey("Referer")) {
                            httpPost.addHeader("Referer", bundle.getString("Referer"));
                        }
                        if (bundle.containsKey("Cookie")) {
                            httpPost.addHeader("Cookie", bundle.getString("Cookie"));
                        }
                        if (bundle.containsKey("Postbody") && bundle.containsKey("needBodyCompatible") && bundle.getBoolean("needBodyCompatible")) {
                            httpPost.addHeader("Postbody", bundle.getString("Postbody"));
                        }
                    }
                    if (z16) {
                        ArrayList arrayList = new ArrayList();
                        for (String str5 : bundle.keySet()) {
                            if (bundle.get(str5) instanceof String) {
                                arrayList.add(new BasicNameValuePair(str5, (String) bundle.get(str5)));
                            } else if (bundle.get(str5) instanceof String[]) {
                                String[] strArr = (String[]) bundle.get(str5);
                                int length3 = strArr.length;
                                String str6 = null;
                                for (int i16 = i3; i16 < length3; i16++) {
                                    String str7 = strArr[i16];
                                    if (TextUtils.isEmpty(str6)) {
                                        str6 = str7;
                                    } else {
                                        str6 = str6 + "," + str7;
                                    }
                                }
                                arrayList.add(new BasicNameValuePair(str5, str6));
                            }
                            i3 = 0;
                        }
                        if (!bundle.containsKey("method")) {
                            arrayList.add(new BasicNameValuePair("method", str2));
                        }
                        httpPost.setEntity(new UrlEncodedFormEntity(arrayList, "UTF-8"));
                    } else if (bundle.containsKey("Postbody") && (!bundle.containsKey("needBodyCompatible") || !bundle.getBoolean("needBodyCompatible"))) {
                        httpPost.setEntity(new ByteArrayEntity(bundle.getString("Postbody").getBytes()));
                    } else {
                        httpPost.setEntity(new ByteArrayEntity(d(bundle).getBytes()));
                    }
                    httpGet = httpPost;
                } else {
                    httpGet = null;
                }
                if (httpGet != null && !httpGet.containsHeader("Cookie")) {
                    httpGet.setHeader("Cookie", e());
                }
                if (httpContext == null) {
                    execute = f16.execute(httpGet);
                } else {
                    execute = f16.execute(httpGet, httpContext);
                }
                r(execute);
                return new a(execute, length);
            } catch (IOException e16) {
                throw e16;
            } catch (NoClassDefFoundError e17) {
                f.d(f340993a, "httpRequest noClassDefFoundError", e17);
                throw new Exception(e17);
            } catch (UnsatisfiedLinkError e18) {
                throw new Exception(e18);
            } catch (MalformedURLException e19) {
                throw new MalformedURLException(e19.getMessage());
            } catch (Exception e26) {
                throw new Exception(e26);
            } catch (OutOfMemoryError e27) {
                throw new Exception(e27);
            }
        }
        throw new NetworkUnavailableException(NetworkUnavailableException.ERROR_INFO);
    }

    public static c m(String str, String str2, Bundle bundle) throws Exception {
        return n(str, str2, bundle, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected static c n(String str, String str2, Bundle bundle, int i3) throws Exception {
        String str3;
        String str4;
        int i16;
        String str5;
        String str6;
        String str7;
        c cVar;
        String string = bundle.getString("needhttpcache");
        String string2 = bundle.getString("LastModifyUseString");
        String insertMtype = MsfSdkUtils.insertMtype("yingyongbao", str);
        String string3 = bundle.getString("downloadfile");
        bundle.remove("downloadfile");
        String string4 = bundle.getString("cmshow_download_key");
        a k3 = k(insertMtype, str2, bundle);
        bundle.remove("needhttpcache");
        bundle.remove("LastModifyUseString");
        HttpResponse httpResponse = k3.f340995a;
        int i17 = k3.f340996b;
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        if (httpResponse.containsHeader("Etag")) {
            str3 = httpResponse.getFirstHeader("Etag").getValue();
        } else {
            str3 = null;
        }
        String str8 = "";
        long j3 = 0;
        if (httpResponse.containsHeader("Last-Modified")) {
            Header firstHeader = httpResponse.getFirstHeader("Last-Modified");
            if (string2 != null) {
                str4 = firstHeader.getValue();
                if (!"GET".equals(str2)) {
                    str5 = c(insertMtype, bundle);
                    String str9 = f340993a;
                    StringBuilder sb5 = new StringBuilder();
                    i16 = i17;
                    sb5.append("url2=");
                    sb5.append(str5);
                    f.a(str9, sb5.toString());
                } else {
                    i16 = i17;
                    str5 = null;
                }
                int i18 = 1;
                if (statusCode != 200) {
                    if (string3 != null) {
                        if (!TextUtils.isEmpty(string4) && string4.equals("cmshow_downLoad") && j(httpResponse).booleanValue()) {
                            str8 = q(httpResponse);
                        }
                    } else {
                        str8 = q(httpResponse);
                    }
                    str7 = str8;
                    if (string != null && "GET".equals(str2)) {
                        com.tencent.open.base.http.c.d().i(str5, str3, j3, str7, str4);
                    }
                } else if (statusCode == 304 && str3 != null) {
                    if (str5 == null) {
                        str6 = "";
                    } else {
                        str6 = com.tencent.open.base.http.c.d().g(str5);
                    }
                    if (str6 == null || "".equals(str6)) {
                        f.c(f340993a, "Get response from cache error. remove cache and retry. retryCount=" + i3);
                        if (str5 != null) {
                            com.tencent.open.base.http.c.d().h(str5);
                        }
                        bundle.putString("needhttpcache", "nothing");
                        if (i3 < 1) {
                            n(insertMtype, str2, bundle, i3);
                        }
                    }
                    i18 = 0;
                    str7 = str6;
                } else {
                    f.c(f340993a, Const.BUNDLE_KEY_REQUEST + insertMtype + "http server return error, statuscode:" + statusCode);
                    throw new HttpStatusException(HttpStatusException.ERROR_INFO + statusCode);
                }
                cVar = new c(str7, i16, i18);
                if (!TextUtils.isEmpty(string4) && string4.equals("cmshow_downLoad") && !j(httpResponse).booleanValue()) {
                    cVar.f341003e = httpResponse.getEntity().getContent();
                }
                return cVar;
            }
            try {
                j3 = Long.parseLong(firstHeader.getValue());
            } catch (NumberFormatException e16) {
                f.a(f340993a, " Parse Last-Modified to Long Exception: " + e16.getMessage());
            }
        }
        str4 = "";
        if (!"GET".equals(str2)) {
        }
        int i182 = 1;
        if (statusCode != 200) {
        }
        cVar = new c(str7, i16, i182);
        if (!TextUtils.isEmpty(string4)) {
            cVar.f341003e = httpResponse.getEntity().getContent();
        }
        return cVar;
    }

    public static JSONObject o(String str) throws JSONException {
        if (str.equals("false")) {
            str = "{value : false}";
        }
        if (str.equals("true")) {
            str = "{value : true}";
        }
        if (str.contains("allback(")) {
            str = str.replaceFirst("[\\s\\S]*allback\\(([\\s\\S]*)\\);[^\\)]*\\z", "$1").trim();
        }
        return new JSONObject(str);
    }

    public static String p(String str) throws JSONException {
        if (str.equals("false")) {
            str = "{value : false}";
        }
        if (str.equals("true")) {
            str = "{value : true}";
        }
        if (str.contains("allback(")) {
            return str.replaceFirst("[\\s\\S]*allback\\(([\\s\\S]*)\\);[^\\)]*\\z", "$1").trim();
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0101 A[Catch: Exception -> 0x00fd, TRY_LEAVE, TryCatch #2 {Exception -> 0x00fd, blocks: (B:60:0x00f9, B:53:0x0101), top: B:59:0x00f9 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00f9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @SuppressLint({"DefaultLocale"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String q(HttpResponse httpResponse) throws IllegalStateException, IOException {
        GZIPInputStream gZIPInputStream;
        String b16;
        HttpEntity entity = httpResponse.getEntity();
        InputStream inputStream = null;
        try {
            if (httpResponse.containsHeader("Content-Length")) {
                f.a(f340993a, "readHttpResponse content-Length = " + Long.parseLong(httpResponse.getFirstHeader("Content-Length").getValue()));
            }
            InputStream content = entity.getContent();
            try {
                Header firstHeader = httpResponse.getFirstHeader("Content-Encoding");
                if (firstHeader != null && firstHeader.getValue().toLowerCase().indexOf("gzip") > -1) {
                    gZIPInputStream = new GZIPInputStream(content);
                    try {
                        b16 = b(gZIPInputStream);
                        inputStream = gZIPInputStream;
                    } catch (Exception e16) {
                        inputStream = content;
                        e = e16;
                        try {
                            f.d(f340993a, "readHttpResponse exception = " + e.getMessage(), e);
                            for (Header header : httpResponse.getAllHeaders()) {
                                f.c(f340993a, "header >>> " + header.getName() + MsgSummary.STR_COLON + header.getValue());
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e17) {
                                    f.d(f340993a, "readHttpResponse>>> ", e17);
                                    return "";
                                }
                            }
                            if (gZIPInputStream != null) {
                                gZIPInputStream.close();
                            }
                            return "";
                        } catch (Throwable th5) {
                            th = th5;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e18) {
                                    f.d(f340993a, "readHttpResponse>>> ", e18);
                                    throw th;
                                }
                            }
                            if (gZIPInputStream != null) {
                                gZIPInputStream.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        inputStream = content;
                        if (inputStream != null) {
                        }
                        if (gZIPInputStream != null) {
                        }
                        throw th;
                    }
                } else {
                    b16 = b(content);
                }
                if (content != null) {
                    try {
                        content.close();
                    } catch (Exception e19) {
                        f.d(f340993a, "readHttpResponse>>> ", e19);
                        return b16;
                    }
                }
                if (inputStream != null) {
                    inputStream.close();
                    return b16;
                }
                return b16;
            } catch (Exception e26) {
                inputStream = content;
                e = e26;
                gZIPInputStream = null;
            } catch (Throwable th7) {
                th = th7;
                gZIPInputStream = null;
            }
        } catch (Exception e27) {
            e = e27;
            gZIPInputStream = null;
        } catch (Throwable th8) {
            th = th8;
            gZIPInputStream = null;
        }
    }

    public static void r(HttpResponse httpResponse) {
        Header[] headerArr;
        String str;
        String str2 = f340993a;
        f.a(str2, "----setCookie");
        if (httpResponse != null) {
            headerArr = httpResponse.getHeaders("Set-Cookie");
        } else {
            headerArr = null;
        }
        if (headerArr != null && headerArr.length != 0) {
            String str3 = "";
            for (int i3 = 0; i3 < headerArr.length; i3++) {
                str3 = str3 + headerArr[i3].getValue();
                if (i3 != headerArr.length - 1) {
                    str3 = str3 + "; ";
                }
            }
            String[] split = str3.split("; ");
            for (String str4 : split) {
                String trim = str4.trim();
                if (f340994b.containsKey(trim.split(ContainerUtils.KEY_VALUE_DELIMITER)[0])) {
                    f340994b.remove(trim.split(ContainerUtils.KEY_VALUE_DELIMITER)[0]);
                }
                HashMap<String, String> hashMap = f340994b;
                String str5 = trim.split(ContainerUtils.KEY_VALUE_DELIMITER)[0];
                if (trim.split(ContainerUtils.KEY_VALUE_DELIMITER).length == 1) {
                    str = "";
                } else if (trim.split(ContainerUtils.KEY_VALUE_DELIMITER).length == 2) {
                    str = trim.split(ContainerUtils.KEY_VALUE_DELIMITER)[1];
                } else {
                    str = trim.split(ContainerUtils.KEY_VALUE_DELIMITER, 2)[1];
                }
                hashMap.put(str5, str);
            }
            return;
        }
        f.a(str2, "----there are no cookies");
    }
}
