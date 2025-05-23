package com.tencent.luggage.wxa.yi;

import android.net.Uri;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mars.cdn.CronetLogic;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.Inet4Address;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import okhttp3.internal.ws.WebSocketProtocol;
import org.apache.http.conn.util.InetAddressUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public enum q {
    ;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements HostnameVerifier {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HostnameVerifier f145938a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f145939b;

        public a(HostnameVerifier hostnameVerifier, ArrayList arrayList) {
            this.f145938a = hostnameVerifier;
            this.f145939b = arrayList;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            if (!this.f145938a.verify(str, sSLSession) && !q.b(this.f145939b, str)) {
                return false;
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f145940a;

        static {
            int[] iArr = new int[com.tencent.luggage.wxa.qc.b.values().length];
            f145940a = iArr;
            try {
                iArr[com.tencent.luggage.wxa.qc.b.SUSPEND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f145940a[com.tencent.luggage.wxa.qc.b.DESTROYED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static String a(String str) {
        return str;
    }

    public static long[] b(long j3) {
        long[] jArr = new long[4];
        if (j3 > 0) {
            jArr[0] = j3 >>> 24;
            jArr[1] = (16777215 & j3) >>> 16;
            jArr[2] = (WebSocketProtocol.PAYLOAD_SHORT_MAX & j3) >>> 8;
            jArr[3] = j3 & 255;
        }
        return jArr;
    }

    public static boolean c(ArrayList arrayList, String str) {
        return b(arrayList, str, false);
    }

    public static boolean d(String str) {
        if (w0.c(str)) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandNetworkUtil", "matchUrl fail, url is null");
            return false;
        }
        if (!InetAddressUtils.isIPv4Address(str)) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandNetworkUtil", "matchUrl fail, url is not ip");
            return false;
        }
        String[] split = str.split("\\.");
        if (split.length != 4) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandNetworkUtil", "matchUrl fail, invalid ip format");
            return false;
        }
        for (String str2 : split) {
            int a16 = w0.a(str2, -1);
            if (a16 < 0 || a16 > 255) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandNetworkUtil", "matchUrl fail, invalid ip format");
                return false;
            }
        }
        return true;
    }

    public static boolean e(int i3) {
        return i3 == 301 || i3 == 302 || i3 == 307;
    }

    public static HashMap f(String str) {
        String str2;
        String str3;
        String str4 = "";
        try {
            Uri parse = Uri.parse(str);
            str2 = parse.getHost();
            try {
                str3 = parse.getScheme();
                try {
                    str4 = String.valueOf(parse.getPort());
                } catch (Exception e16) {
                    e = e16;
                    com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandNetworkUtil", e, "Exception: parseUrl error", new Object[0]);
                    HashMap hashMap = new HashMap();
                    hashMap.put("host", str2);
                    hashMap.put(ZPlanPublishSource.FROM_SCHEME, str3);
                    hashMap.put("port", str4);
                    return hashMap;
                }
            } catch (Exception e17) {
                e = e17;
                str3 = "";
            }
        } catch (Exception e18) {
            e = e18;
            str2 = "";
            str3 = str2;
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("host", str2);
        hashMap2.put(ZPlanPublishSource.FROM_SCHEME, str3);
        hashMap2.put("port", str4);
        return hashMap2;
    }

    public static q valueOf(String str) {
        com.tencent.luggage.wxa.k0.d.a(Enum.valueOf(q.class, str));
        return null;
    }

    public static Map b(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("header");
            if (optJSONObject != null) {
                Iterator keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String str = (String) keys.next();
                    if (str != null) {
                        hashMap.put(str.toLowerCase(), optJSONObject.getString(str));
                    }
                }
            }
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandNetworkUtil", e16, "Exception: get header error", new Object[0]);
        }
        return hashMap;
    }

    public static int c(String str) {
        if (!d(str)) {
            return 0;
        }
        String[] split = str.split("\\.");
        return com.tencent.luggage.wxa.y8.g.a(new byte[]{(byte) (w0.a(split[0], 0) & 255), (byte) (w0.a(split[1], 0) & 255), (byte) (w0.a(split[2], 0) & 255), (byte) (w0.a(split[3], 0) & 255)});
    }

    public static int e(String str) {
        int i3;
        int i16;
        int i17;
        if (!d(str)) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandNetworkUtil", "matchUrl fail, url is null");
            return 0;
        }
        String[] split = str.split("\\.");
        int a16 = com.tencent.luggage.wxa.y8.g.a(new byte[]{(byte) (w0.a(split[0], 0) & 255), (byte) (w0.a(split[1], 0) & 255), (byte) (w0.a(split[2], 0) & 255), (byte) (w0.a(split[3], 0) & 255)});
        WifiManager wifiManager = (WifiManager) com.tencent.luggage.wxa.tn.z.c().getApplicationContext().getSystemService("wifi");
        if (wifiManager.getWifiState() == 3) {
            int f16 = com.tencent.luggage.wxa.tn.j.f141599a.f();
            String c16 = c(f16);
            try {
                i16 = NetworkMonitor.getDhcpInfo(wifiManager).netmask;
            } catch (NullPointerException e16) {
                com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandNetworkUtil", e16, "NullPointerException: getDhcpInfo error", new Object[0]);
                i16 = 0;
            }
            if (i16 <= 0) {
                int b16 = b(c16);
                i17 = b16;
                i16 = a(b16);
            } else {
                i17 = 0;
            }
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandNetworkUtil", "matchIp oldIpStr:%s, localIp:%s,oldIpInt:%d, localIpInt:%d, netmask:%d, prefixLength:%d", str, c16, Integer.valueOf(a16), Integer.valueOf(f16), Integer.valueOf(i16), Integer.valueOf(i17));
            return a(i16, a16, f16);
        }
        int i18 = 13;
        try {
            i18 = ((Integer) wifiManager.getClass().getField("WIFI_AP_STATE_ENABLED").get(wifiManager)).intValue();
            i3 = ((Integer) wifiManager.getClass().getMethod("getWifiApState", new Class[0]).invoke(wifiManager, new Object[0])).intValue();
        } catch (Exception e17) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandNetworkUtil", e17, "Exception: getWifiApState error", new Object[0]);
            i3 = 0;
        }
        if (i3 == i18) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandNetworkUtil", "matchip in apmode");
            return d(a16);
        }
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandNetworkUtil", "apState:%d", Integer.valueOf(i3));
        return 0;
    }

    public static Map a(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("formData");
            if (optJSONObject != null) {
                Iterator keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String str = (String) keys.next();
                    hashMap.put(str, optJSONObject.getString(str));
                }
            }
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandNetworkUtil", e16, "Exception: get form error", new Object[0]);
        }
        return hashMap;
    }

    public static boolean b(ArrayList arrayList, String str, boolean z16) {
        if (a(arrayList, str, z16)) {
            return true;
        }
        if (e((String) f(str).get("host")) != 2) {
            return false;
        }
        com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandNetworkUtil", "matchUrl, url in the same net %s", str);
        return true;
    }

    public static String c(int i3) {
        return (i3 & 255) + "." + ((i3 >> 8) & 255) + "." + ((i3 >> 16) & 255) + "." + ((i3 >> 24) & 255);
    }

    public static JSONObject c(HttpURLConnection httpURLConnection) {
        if (httpURLConnection == null) {
            return a((Map) null, 2);
        }
        return a(httpURLConnection.getHeaderFields(), 2);
    }

    public static boolean a(ArrayList arrayList, String str, boolean z16) {
        if (w0.c(str)) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandNetworkUtil", "matchUrl fail, url is null");
            return false;
        }
        if (arrayList != null && arrayList.size() != 0) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandNetworkUtil", "url " + str);
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandNetworkUtil", "configUrl size " + arrayList.size());
            HashMap f16 = f(str);
            String str2 = (String) f16.get("host");
            String str3 = (String) f16.get(ZPlanPublishSource.FROM_SCHEME);
            String str4 = (String) f16.get("port");
            if (!w0.c(str2) && !w0.c(str3)) {
                char c16 = 2;
                com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandNetworkUtil", "host %s  scheme %s port %s skipPortCheck %s", str2, str3, str4, Boolean.valueOf(z16));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    String str5 = (String) it.next();
                    com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandNetworkUtil", "configUrl " + str5);
                    HashMap f17 = f(str5);
                    String str6 = (String) f17.get("host");
                    String str7 = (String) f17.get(ZPlanPublishSource.FROM_SCHEME);
                    String str8 = (String) f17.get("port");
                    Object[] objArr = new Object[3];
                    objArr[0] = str6;
                    objArr[1] = str7;
                    objArr[c16] = str8;
                    com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandNetworkUtil", "confighost %s  configscheme %s configport %s", objArr);
                    if (str2.equalsIgnoreCase(str6) && str3.equalsIgnoreCase(str7) && (z16 || str4.equalsIgnoreCase(str8))) {
                        return true;
                    }
                    c16 = 2;
                }
            }
            return false;
        }
        com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandNetworkUtil", "matchUrl fail, configUrls is empty");
        return false;
    }

    public static int d(int i3) {
        try {
            Iterator it = Collections.list(NetworkMonitor.getNetworkInterfaces()).iterator();
            while (it.hasNext()) {
                for (InterfaceAddress interfaceAddress : NetworkMonitor.getInterfaceAddresses((NetworkInterface) it.next())) {
                    if (!interfaceAddress.getAddress().isLoopbackAddress()) {
                        String upperCase = interfaceAddress.getAddress().getHostAddress().toUpperCase();
                        boolean isIPv4Address = InetAddressUtils.isIPv4Address(upperCase);
                        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandNetworkUtil", "check ip:%s, isIPv4:%b", upperCase, Boolean.valueOf(isIPv4Address));
                        if (isIPv4Address) {
                            int c16 = c(upperCase);
                            long a16 = a((int) interfaceAddress.getNetworkPrefixLength());
                            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandNetworkUtil", "matchAddress oldIpInt:%d, localIpInt:%d, netmask:%d", Integer.valueOf(i3), Integer.valueOf(c16), Long.valueOf(a16));
                            return a(a16, i3, c16);
                        }
                    }
                }
            }
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandNetworkUtil", e16, "Exception: matchAddress error", new Object[0]);
        }
        return 0;
    }

    public static String c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        JSONArray optJSONArray = jSONObject.optJSONArray("protocols");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                linkedList.add(optJSONArray.optString(i3));
            }
        }
        if (w0.a((List) linkedList)) {
            return null;
        }
        return TextUtils.join(", ", linkedList);
    }

    public static int b(String str) {
        if (w0.c(str)) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandNetworkUtil", "getHostIPNetMaskPrefixLength invalid ip");
            return 0;
        }
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkMonitor.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                for (InterfaceAddress interfaceAddress : NetworkMonitor.getInterfaceAddresses(networkInterfaces.nextElement())) {
                    com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandNetworkUtil", "address:%s", interfaceAddress.getAddress().getHostAddress());
                    if ((interfaceAddress.getAddress() instanceof Inet4Address) && !interfaceAddress.getAddress().isLoopbackAddress() && !interfaceAddress.getAddress().isAnyLocalAddress() && interfaceAddress.getAddress().getHostAddress().equals(str)) {
                        return interfaceAddress.getNetworkPrefixLength();
                    }
                }
            }
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandNetworkUtil", e16, "lm:get mask failed", new Object[0]);
        }
        return 0;
    }

    public static String b(int i3) {
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandNetworkUtil", "calcMaskStrByPrefixLength length:%d", Integer.valueOf(i3));
        int i16 = (-1) << (32 - i3);
        int[] iArr = new int[4];
        for (int i17 = 0; i17 < 4; i17++) {
            iArr[3 - i17] = (i16 >> (i17 * 8)) & 255;
        }
        String str = "" + iArr[0];
        for (int i18 = 1; i18 < 4; i18++) {
            str = str + "." + iArr[i18];
        }
        return str;
    }

    public static Map b(Map map, ArrayList arrayList) {
        if (map != null && arrayList != null) {
            HashMap hashMap = new HashMap();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (str != null) {
                    String lowerCase = str.toLowerCase();
                    String str2 = (String) map.get(lowerCase);
                    if (str2 != null) {
                        com.tencent.luggage.wxa.tn.w.g("MicroMsg.AppBrandNetworkUtil", "add item, key(%s), value(%s)", lowerCase, str2);
                        hashMap.put(lowerCase, str2);
                    }
                }
            }
            return hashMap;
        }
        com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandNetworkUtil", "filterHttpHeaderWhiteList fail");
        return map;
    }

    public static int a(int i3) {
        String b16 = b(i3);
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandNetworkUtil", "calcMaskIntByPrefixLength result:%s", b16);
        String[] split = b16.split("\\.");
        return com.tencent.luggage.wxa.y8.g.a(new byte[]{(byte) (w0.a(split[0], 0) & 255), (byte) (w0.a(split[1], 0) & 255), (byte) (w0.a(split[2], 0) & 255), (byte) (w0.a(split[3], 0) & 255)});
    }

    public static boolean b(ArrayList arrayList, String str) {
        if (arrayList == null || str == null) {
            return true;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (((String) it.next()).contains(str)) {
                return true;
            }
        }
        return false;
    }

    public static int a(long j3, int i3, int i16) {
        int a16 = com.tencent.luggage.wxa.y8.g.a(new byte[]{-1, -1, -1, 0});
        int i17 = 0;
        for (long j16 : b(j3)) {
            i17 = (int) (i17 + j16);
            if (j16 < 0 || j16 > 255) {
                i17 = -1;
                break;
            }
        }
        if (i17 <= 0) {
            j3 = a16;
        }
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandNetworkUtil", "matchNetMask oldIpInt:%d, localIpInt:%d, netmask:%d", Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3));
        if ((i3 & j3) == (j3 & i16)) {
            return i3 == i16 ? 1 : 2;
        }
        return 0;
    }

    public static t b(com.tencent.luggage.wxa.yi.a aVar) {
        LinkedList linkedList = new LinkedList();
        Iterator it = aVar.H.iterator();
        while (it.hasNext()) {
            byte[] bArr = (byte[]) it.next();
            if (bArr != null && bArr.length != 0) {
                linkedList.add(new ByteArrayInputStream(bArr));
            }
        }
        if (linkedList.isEmpty()) {
            if (!aVar.Q || !aVar.R) {
                return null;
            }
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandNetworkUtil", "getTrustManagerWithSelfSignedCertificates debug type");
            t tVar = new t(true);
            tVar.a();
            return tVar;
        }
        t tVar2 = new t(aVar.Q);
        Iterator it5 = linkedList.iterator();
        while (it5.hasNext()) {
            tVar2.a((InputStream) it5.next());
        }
        tVar2.a();
        return tVar2;
    }

    public static Map a(Map map, ArrayList arrayList) {
        if (map != null && arrayList != null && !arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (str != null) {
                    String lowerCase = str.toLowerCase();
                    String str2 = (String) map.remove(lowerCase);
                    if (str2 != null) {
                        com.tencent.luggage.wxa.tn.w.g("MicroMsg.AppBrandNetworkUtil", "remove key %s value %s", lowerCase, str2);
                    }
                }
            }
            return map;
        }
        com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandNetworkUtil", "filterHttpHeaderBlackList fail, headerMap is null or blacklist is null or nil.");
        return map;
    }

    public static Map a(Map map, com.tencent.luggage.wxa.yi.a aVar) {
        ArrayList arrayList;
        if (aVar == null) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandNetworkUtil", "hy: no network config!");
            return map;
        }
        int i3 = aVar.N;
        if (i3 == 1) {
            ArrayList arrayList2 = aVar.F;
            if (arrayList2 != null) {
                map = a(map, arrayList2);
            }
        } else if (i3 == 2 && (arrayList = aVar.G) != null) {
            map = b(map, arrayList);
        }
        if (map != null) {
            a(map);
            if (!TextUtils.isEmpty(aVar.M)) {
                map.put(ISchemeApi.KEY_REFERER, aVar.M);
            }
        }
        return map;
    }

    public static JSONObject b(HttpURLConnection httpURLConnection) {
        if (httpURLConnection == null) {
            return a((Map) null, 1);
        }
        return a(httpURLConnection.getRequestProperties(), 1);
    }

    public static Map b(Map map) {
        HashMap hashMap = new HashMap();
        try {
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (str != null && !str.isEmpty()) {
                    String str2 = (String) entry.getValue();
                    List list = (List) hashMap.get(str);
                    if (list == null) {
                        list = new ArrayList();
                    }
                    list.add(str2);
                    hashMap.put(str, list);
                }
            }
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandNetworkUtil", e16, "JSONException: put header error", new Object[0]);
        }
        return hashMap;
    }

    public static void a(Map map) {
        if (map != null) {
            map.remove(ISchemeApi.KEY_REFERER);
        }
    }

    public static Map a(JSONObject jSONObject, com.tencent.luggage.wxa.yi.a aVar) {
        return a(b(jSONObject), aVar);
    }

    public static int a(com.tencent.luggage.wxa.yi.a aVar, int i3) {
        if (i3 == 0) {
            return aVar.f145793c;
        }
        if (i3 == 1) {
            return aVar.f145794d;
        }
        if (i3 == 2) {
            return aVar.f145795e;
        }
        if (i3 != 3) {
            return 0;
        }
        return aVar.f145796f;
    }

    public static String a(HttpURLConnection httpURLConnection) {
        URL url;
        if (httpURLConnection == null || (url = httpURLConnection.getURL()) == null) {
            return "";
        }
        String headerField = httpURLConnection.getHeaderField("Location");
        if (headerField == null) {
            headerField = httpURLConnection.getHeaderField("location");
        }
        if (headerField == null) {
            return null;
        }
        try {
            return url.toURI().resolve(headerField).toString();
        } catch (URISyntaxException e16) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandNetworkUtil", e16, "URISyntaxException: resolve url error", new Object[0]);
            return headerField;
        }
    }

    public static void a(HttpURLConnection httpURLConnection, ArrayList arrayList) {
        if (httpURLConnection == null) {
            return;
        }
        ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(new a(HttpsURLConnection.getDefaultHostnameVerifier(), arrayList));
    }

    public static SSLContext a(com.tencent.luggage.wxa.yi.a aVar) {
        t b16 = b(aVar);
        if (b16 == null) {
            return null;
        }
        TrustManager[] trustManagerArr = {b16};
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, trustManagerArr, null);
            return sSLContext;
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandNetworkUtil", e16, "Exception: SSLContext init error", new Object[0]);
            return null;
        }
    }

    public static boolean a(com.tencent.luggage.wxa.qc.b bVar) {
        int i3 = b.f145940a[bVar.ordinal()];
        return i3 == 1 || i3 == 2;
    }

    public static boolean a(com.tencent.luggage.wxa.xd.d dVar) {
        int i3 = b.f145940a[dVar.getAppState().ordinal()];
        return i3 == 1 || i3 == 2;
    }

    public static boolean a(g gVar) {
        int i3 = b.f145940a[gVar.getAppState().ordinal()];
        return i3 == 1 || i3 == 2;
    }

    public static JSONObject a(Map map, int i3) {
        JSONObject jSONObject = new JSONObject();
        if (i3 == 1) {
            try {
                jSONObject.put("__AppBrandRemoteDebugRequestHeader__", true);
            } catch (JSONException e16) {
                com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandNetworkUtil", e16, "JSONException: getHeaderJsonObject put REQUEST_HEADER header error", new Object[0]);
            }
        }
        if (map == null) {
            return jSONObject;
        }
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            List list = (List) entry.getValue();
            if (!w0.c(str) && list != null && !list.isEmpty()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append((String) list.get(0));
                for (int i16 = 1; i16 < list.size(); i16++) {
                    sb5.append(",");
                    sb5.append((String) list.get(i16));
                }
                try {
                    jSONObject.put(str, sb5.toString());
                } catch (JSONException e17) {
                    com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandNetworkUtil", e17, "JSONException: getHeaderJsonObject put header error", new Object[0]);
                }
            }
        }
        return jSONObject;
    }

    public static int a(long j3) {
        return a(j3, -1);
    }

    public static int a(long j3, int i3) {
        if (j3 <= 0) {
            return 8192;
        }
        if (i3 <= 0) {
            i3 = 3;
        }
        int i16 = (int) (j3 / i3);
        return (i16 > 524288 || i16 < 1024) ? i16 < 1024 ? 1024 : 524288 : i16;
    }

    public static String a(URI uri) {
        if (uri == null) {
            return null;
        }
        String scheme = uri.getScheme();
        if (w0.c(scheme)) {
            return null;
        }
        if (scheme.equalsIgnoreCase("wss")) {
            scheme = "https";
        } else if (scheme.equalsIgnoreCase("ws")) {
            scheme = "http";
        }
        StringBuilder sb5 = new StringBuilder(scheme);
        sb5.append(QzoneWebViewOfflinePlugin.STR_DEVIDER);
        sb5.append(uri.getHost());
        int port = uri.getPort();
        if (!(port == -1 || (scheme.equalsIgnoreCase("http") && port == 80) || (scheme.equalsIgnoreCase("https") && port == 443))) {
            sb5.append(":");
            sb5.append(uri.getPort());
        }
        return sb5.toString();
    }

    public static void a(long j3, long j16, long j17) {
        if (new Random().nextInt(100) <= 1) {
            ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class)).a(j3, j16, j17, false);
        }
    }

    public static synchronized Map a(CronetLogic.WebPageProfile webPageProfile) {
        HashMap hashMap;
        synchronized (q.class) {
            hashMap = new HashMap();
            if (webPageProfile != null) {
                hashMap.put("redirectStart", Long.valueOf(webPageProfile.redirectStart));
                hashMap.put("redirectEnd", Long.valueOf(webPageProfile.redirectEnd));
                hashMap.put("fetchStart", Long.valueOf(webPageProfile.fetchStart));
                hashMap.put("domainLookUpStart", Long.valueOf(webPageProfile.domainLookUpStart));
                hashMap.put("domainLookUpEnd", Long.valueOf(webPageProfile.domainLookUpEnd));
                hashMap.put("connectStart", Long.valueOf(webPageProfile.connectStart));
                hashMap.put("connectEnd", Long.valueOf(webPageProfile.connectEnd));
                hashMap.put("SSLconnectionStart", Long.valueOf(webPageProfile.SSLconnectionStart));
                hashMap.put("SSLconnectionEnd", Long.valueOf(webPageProfile.SSLconnectionEnd));
                hashMap.put("requestStart", Long.valueOf(webPageProfile.requestStart));
                hashMap.put("requestEnd", Long.valueOf(webPageProfile.requestEnd));
                hashMap.put("responseStart", Long.valueOf(webPageProfile.responseStart));
                hashMap.put("responseEnd", Long.valueOf(webPageProfile.responseEnd));
                hashMap.put("rtt", Integer.valueOf(webPageProfile.rtt));
                hashMap.put("estimate_nettype", Integer.valueOf(webPageProfile.networkTypeEstimate));
                hashMap.put("httpRttEstimate", Integer.valueOf(webPageProfile.httpRttEstimate));
                hashMap.put("transportRttEstimate", Integer.valueOf(webPageProfile.transportRttEstimate));
                hashMap.put("downstreamThroughputKbpsEstimate", Integer.valueOf(webPageProfile.downstreamThroughputKbpsEstimate));
                hashMap.put("throughputKbps", Integer.valueOf(webPageProfile.throughputKbps));
                hashMap.put("peerIP", webPageProfile.peerIP);
                hashMap.put("port", Integer.valueOf(webPageProfile.port));
                hashMap.put(AudienceReportConst.PROTOCOL, webPageProfile.f151362protocol);
                hashMap.put("socketReused", Boolean.valueOf(webPageProfile.socketReused));
                hashMap.put("sendBytesCount", Long.valueOf(webPageProfile.sendBytesCount));
                hashMap.put("receivedBytedCount", Long.valueOf(webPageProfile.receivedBytedCount));
            }
        }
        return hashMap;
    }
}
