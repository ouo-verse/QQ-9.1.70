package com.tencent.ams.mosaic.utils.vid2url;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.ads.data.AdParam;
import com.tencent.ams.mosaic.MosaicManager;
import com.tencent.local_edit.andserver.util.MediaType;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.adapter.http.HttpHeader;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.slf4j.Marker;
import org.w3c.dom.Document;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c {
    static IPatchRedirector $redirector_;

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00b1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0064 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(String str, Map<String, String> map, boolean z16, String str2) {
        String str3;
        if (str != null && map != null) {
            if (str.contains("livep.l.qq.com") && map.containsKey(AdParam.TY)) {
                map.remove(AdParam.TY);
            }
            if (!str.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                str = str + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
            }
            if (!str.endsWith(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER) && !str.endsWith(ContainerUtils.FIELD_DELIMITER)) {
                str = str + ContainerUtils.FIELD_DELIMITER;
            }
            StringBuilder sb5 = new StringBuilder();
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (entry != null) {
                        String key = entry.getKey();
                        if (entry.getValue() == null) {
                            str3 = "";
                            if (str.contains(ContainerUtils.FIELD_DELIMITER + key + ContainerUtils.KEY_VALUE_DELIMITER)) {
                                if (!str.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + key + ContainerUtils.KEY_VALUE_DELIMITER)) {
                                    sb5.append(key);
                                    sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                                    sb5.append(str3);
                                    sb5.append(ContainerUtils.FIELD_DELIMITER);
                                }
                            }
                        } else {
                            str3 = URLEncoder.encode(entry.getValue(), "UTF-8").replace(Marker.ANY_NON_NULL_MARKER, "%20");
                            if (str.contains(ContainerUtils.FIELD_DELIMITER + key + ContainerUtils.KEY_VALUE_DELIMITER)) {
                            }
                        }
                    }
                }
            } catch (Exception unused) {
            }
            String str4 = (str + sb5.toString()) + "requestid=" + str2 + ContainerUtils.FIELD_DELIMITER;
            com.tencent.ams.mosaic.utils.f.g("AdCoreInternetService", "createUrl-->" + str4);
            if (str4.endsWith(ContainerUtils.FIELD_DELIMITER)) {
                return str4.substring(0, str4.length() - 1);
            }
            return str4;
        }
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x00d4, code lost:
    
        if (r4 == null) goto L44;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String c(String str, String str2, int i3, int i16, int i17) {
        String str3;
        InputStream inputStream;
        DataOutputStream dataOutputStream;
        HttpURLConnection httpURLConnection = null;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            URL url = new URL(str);
            str3 = null;
            inputStream = null;
            dataOutputStream = null;
            boolean z16 = true;
            int i18 = 0;
            while (z16) {
                try {
                    try {
                        com.tencent.ams.mosaic.utils.f.a("AdCoreInternetService", "getHttpJson, start request.");
                        HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
                        try {
                            try {
                                httpURLConnection2.setInstanceFollowRedirects(true);
                                httpURLConnection2.setRequestMethod("POST");
                                httpURLConnection2.setRequestProperty("Accept", "application/json");
                                httpURLConnection2.setRequestProperty(HttpHeader.RSP.CHARSET, "UTF-8");
                                httpURLConnection2.setRequestProperty("Content-Type", "application/json");
                                try {
                                    httpURLConnection2.setConnectTimeout(i16);
                                    try {
                                        httpURLConnection2.setReadTimeout(i3);
                                        httpURLConnection2.setDoOutput(true);
                                        DataOutputStream dataOutputStream2 = new DataOutputStream(httpURLConnection2.getOutputStream());
                                        try {
                                            dataOutputStream2.write(str2.getBytes());
                                            dataOutputStream2.flush();
                                            inputStream = httpURLConnection2.getInputStream();
                                            if (inputStream != null) {
                                                str3 = g(inputStream);
                                            }
                                            dataOutputStream = dataOutputStream2;
                                            httpURLConnection = httpURLConnection2;
                                        } catch (Exception e16) {
                                            e = e16;
                                            dataOutputStream = dataOutputStream2;
                                            httpURLConnection = httpURLConnection2;
                                            com.tencent.ams.mosaic.utils.f.c("AdCoreInternetService", "network error.", e);
                                            if (i18 < i17) {
                                                com.tencent.ams.mosaic.utils.f.a("AdCoreInternetService", "timeout, retryTimes " + i18);
                                                i18++;
                                            } else {
                                                z16 = false;
                                            }
                                        } catch (Throwable th5) {
                                            th = th5;
                                            dataOutputStream = dataOutputStream2;
                                            httpURLConnection = httpURLConnection2;
                                            try {
                                                com.tencent.ams.mosaic.utils.f.c("AdCoreInternetService", "network error.", th);
                                            } finally {
                                                if (httpURLConnection != null) {
                                                    try {
                                                        httpURLConnection.disconnect();
                                                    } catch (Throwable unused) {
                                                    }
                                                }
                                                a(inputStream);
                                                a(dataOutputStream);
                                            }
                                        }
                                    } catch (Exception e17) {
                                        e = e17;
                                    }
                                } catch (Exception e18) {
                                    e = e18;
                                }
                            } catch (Throwable th6) {
                                th = th6;
                            }
                        } catch (Exception e19) {
                            e = e19;
                        }
                    } catch (Throwable th7) {
                        th = th7;
                    }
                } catch (Exception e26) {
                    e = e26;
                }
                z16 = false;
            }
        } catch (Throwable th8) {
            th = th8;
            str3 = null;
            inputStream = null;
            dataOutputStream = null;
        }
        return str3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x00d8, code lost:
    
        if (r11 != null) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00eb, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00da, code lost:
    
        r11.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00e8, code lost:
    
        if (r11 == null) goto L43;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00c8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c5 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Object d(b bVar) {
        int i3;
        HttpURLConnection httpURLConnection;
        Document document = null;
        if (bVar == null) {
            return null;
        }
        String e16 = bVar.e();
        String d16 = bVar.d();
        boolean g16 = bVar.g();
        if (bVar.c() > 0) {
            i3 = bVar.c();
        } else if (e()) {
            i3 = 6000;
        } else {
            i3 = 2000;
        }
        String b16 = b(e16, bVar.a(), bVar.f(), bVar.b());
        com.tencent.ams.mosaic.utils.f.a("AdCoreInternetService", "httpGetXml url: " + b16);
        try {
            URL url = new URL(b16);
            InputStream inputStream = null;
            httpURLConnection = null;
            int i16 = 0;
            boolean z16 = true;
            while (z16) {
                if (i16 > 0 && g16) {
                    try {
                        url = new URL(b16 + "&rt=" + i16);
                    } catch (Throwable unused) {
                        if (i16 >= 3) {
                        }
                    }
                }
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
                try {
                    httpURLConnection2.setInstanceFollowRedirects(true);
                    if (!TextUtils.isEmpty(d16)) {
                        httpURLConnection2.setRequestProperty("User-Agent", System.getProperty("http.agent") + d16);
                    }
                    httpURLConnection2.setRequestMethod("GET");
                    httpURLConnection2.setRequestProperty("Accept", MediaType.APPLICATION_XML_VALUE);
                    httpURLConnection2.setConnectTimeout(i3);
                    httpURLConnection2.setReadTimeout(i3);
                    inputStream = httpURLConnection2.getInputStream();
                    httpURLConnection = httpURLConnection2;
                } catch (Throwable unused2) {
                    httpURLConnection = httpURLConnection2;
                    if (i16 >= 3) {
                        i16++;
                    } else {
                        z16 = false;
                    }
                }
                z16 = false;
            }
            try {
                DocumentBuilder newDocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                if (inputStream != null) {
                    document = newDocumentBuilder.parse(inputStream);
                }
            } catch (Throwable th5) {
                th = th5;
                try {
                    com.tencent.ams.mosaic.utils.f.c("AdCoreInternetService", "httpGetXml error.", th);
                } catch (Throwable th6) {
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Throwable unused3) {
                        }
                    }
                    throw th6;
                }
            }
        } catch (Throwable th7) {
            th = th7;
            httpURLConnection = null;
        }
    }

    public static boolean e() {
        ConnectivityManager connectivityManager;
        Context i3 = MosaicManager.j().i();
        if (i3 == null || (connectivityManager = (ConnectivityManager) i3.getSystemService("connectivity")) == null) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return false;
            }
            if (NetworkMonitor.getType(activeNetworkInfo) != 0) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean f(String str) {
        if (str != null && (str.startsWith("http://") || str.startsWith("https://"))) {
            return true;
        }
        return false;
    }

    public static String g(InputStream inputStream) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        StringBuilder sb5 = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
            sb5.append(readLine);
        }
        return sb5.toString();
    }
}
