package com.tencent.ads.monitor;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.ads.AdManager;
import com.tencent.ads.data.AdParam;
import com.tencent.ads.utility.SystemUtil;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.DataOutputStream;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.slf4j.Marker;

/* loaded from: classes37.dex */
public class PingService {

    /* renamed from: a, reason: collision with root package name */
    private static final String f61656a = "PingService";

    /* renamed from: b, reason: collision with root package name */
    private static final long f61657b = 300;

    /* renamed from: c, reason: collision with root package name */
    private static final int f61658c = 5;

    /* renamed from: d, reason: collision with root package name */
    private static final String f61659d = "ads.ping.persistence.fail.new";

    /* renamed from: e, reason: collision with root package name */
    private static final Random f61660e = new Random();

    /* renamed from: f, reason: collision with root package name */
    private static PingService f61661f = null;

    /* renamed from: g, reason: collision with root package name */
    private Queue f61662g = new ConcurrentLinkedQueue();

    /* renamed from: h, reason: collision with root package name */
    private ScheduledThreadPoolExecutor f61663h;

    /* renamed from: i, reason: collision with root package name */
    private ThreadPoolExecutor f61664i;

    /* renamed from: j, reason: collision with root package name */
    private SharedPreferences f61665j;

    PingService() {
    }

    private void b() {
        this.f61663h.scheduleAtFixedRate(new c(this), 1L, 300L, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.f61663h;
        if (scheduledThreadPoolExecutor == null || scheduledThreadPoolExecutor.isShutdown()) {
            this.f61663h = new ScheduledThreadPoolExecutor(1);
            this.f61663h.scheduleAtFixedRate(new c(this), 1L, 300L, TimeUnit.SECONDS);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00a5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x005a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String createUrl(String str, Map map, boolean z16, String str2) {
        String str3;
        String str4;
        String str5 = "";
        if (str == null || map == null) {
            return str;
        }
        if (str.contains("livep.l.qq.com") && map.containsKey(AdParam.TY)) {
            map.remove(AdParam.TY);
        }
        if (!str.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
            str = str + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
        }
        if (!str.endsWith(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER) && !str.endsWith(ContainerUtils.FIELD_DELIMITER)) {
            str = str + ContainerUtils.FIELD_DELIMITER;
        }
        try {
            str3 = "";
            for (Map.Entry entry : map.entrySet()) {
                try {
                    if (entry != null) {
                        String str6 = (String) entry.getKey();
                        if (entry.getValue() == null) {
                            str4 = "";
                            if (str.contains(ContainerUtils.FIELD_DELIMITER + str6 + ContainerUtils.KEY_VALUE_DELIMITER)) {
                                if (!str.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + str6 + ContainerUtils.KEY_VALUE_DELIMITER)) {
                                    str3 = String.valueOf(str3) + str6 + ContainerUtils.KEY_VALUE_DELIMITER + str4 + ContainerUtils.FIELD_DELIMITER;
                                }
                            }
                        } else {
                            str4 = URLEncoder.encode((String) entry.getValue(), "UTF-8").replace(Marker.ANY_NON_NULL_MARKER, "%20");
                            if (str.contains(ContainerUtils.FIELD_DELIMITER + str6 + ContainerUtils.KEY_VALUE_DELIMITER)) {
                            }
                        }
                    }
                } catch (Exception unused) {
                    str5 = str3;
                    str3 = str5;
                    String str7 = String.valueOf(str) + str3;
                    Log.v(f61656a, "createUrl-->" + str7);
                    if (!str7.endsWith(ContainerUtils.FIELD_DELIMITER)) {
                    }
                }
            }
        } catch (Exception unused2) {
        }
        String str72 = String.valueOf(str) + str3;
        Log.v(f61656a, "createUrl-->" + str72);
        return !str72.endsWith(ContainerUtils.FIELD_DELIMITER) ? str72.substring(0, str72.length() - 1) : str72;
    }

    private void d() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.f61663h;
        if (scheduledThreadPoolExecutor == null || scheduledThreadPoolExecutor.isShutdown()) {
            return;
        }
        this.f61663h.shutdown();
    }

    public static boolean doGetPing(String str) {
        HttpURLConnection httpURLConnection;
        Throwable th5;
        int responseCode;
        if (!SystemUtil.isNetworkAvailable()) {
            return false;
        }
        try {
            try {
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                try {
                    httpURLConnection.setInstanceFollowRedirects(true);
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setConnectTimeout(30000);
                    httpURLConnection.setReadTimeout(30000);
                    com.tencent.ads.service.b.a();
                    String a16 = com.tencent.ads.service.b.a(str);
                    if (!TextUtils.isEmpty(a16)) {
                        httpURLConnection.setRequestProperty("Cookie", a16);
                    }
                    try {
                        ArrayList<HttpCookie> arrayList = new ArrayList();
                        List<String> list = httpURLConnection.getHeaderFields().get("Set-Cookie");
                        if (list != null) {
                            for (String str2 : list) {
                                if (str2 != null && str2.length() != 0) {
                                    arrayList.addAll(HttpCookie.parse("Set-Cookie: " + str2));
                                    Log.i(f61656a, "headerKey: Set-Cookie, field:" + str2);
                                }
                            }
                            for (HttpCookie httpCookie : arrayList) {
                                com.tencent.ads.service.b.a();
                                com.tencent.ads.service.b.b().a(httpCookie);
                            }
                            com.tencent.ads.service.b.a().c();
                        }
                    } catch (Exception unused) {
                        Log.e(f61656a, "save cookie failed");
                    }
                    responseCode = httpURLConnection.getResponseCode();
                } catch (Throwable th6) {
                    th5 = th6;
                    try {
                        th5.printStackTrace();
                        Log.d(f61656a, "ping " + str + " failed");
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return false;
                    } catch (Throwable th7) {
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Throwable th8) {
                                th8.printStackTrace();
                            }
                        }
                        throw th7;
                    }
                }
            } catch (Throwable th9) {
                httpURLConnection = null;
                th5 = th9;
            }
        } catch (Throwable th10) {
            th10.printStackTrace();
        }
        if (responseCode >= 0 && responseCode < 400) {
            Log.d(f61656a, "ping " + str + " succeed");
            try {
                httpURLConnection.disconnect();
            } catch (Throwable th11) {
                th11.printStackTrace();
            }
            return true;
        }
        Log.d(f61656a, "ping " + str + " failed");
        httpURLConnection.disconnect();
        return false;
    }

    public static boolean doPostPing(String str, String str2) {
        DataOutputStream dataOutputStream;
        HttpURLConnection httpURLConnection;
        int responseCode;
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        Log.d(f61656a, "doPostPing: " + str2);
        if (!SystemUtil.isNetworkAvailable()) {
            return false;
        }
        HttpURLConnection httpURLConnection2 = null;
        try {
            try {
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                try {
                    httpURLConnection.setInstanceFollowRedirects(true);
                    com.tencent.ads.service.b.a();
                    String a16 = com.tencent.ads.service.b.a(str);
                    if (!TextUtils.isEmpty(a16)) {
                        httpURLConnection.setRequestProperty("Cookie", a16);
                    }
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setRequestProperty("Content-Type", "application/json");
                    httpURLConnection.setConnectTimeout(30000);
                    httpURLConnection.setReadTimeout(30000);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setDoOutput(true);
                    dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                } catch (Throwable th5) {
                    th = th5;
                    dataOutputStream = null;
                }
            } catch (Throwable th6) {
                th = th6;
                dataOutputStream = null;
            }
        } catch (Throwable th7) {
            th7.printStackTrace();
        }
        try {
            dataOutputStream.writeBytes(str2);
            httpURLConnection.connect();
            try {
                ArrayList<HttpCookie> arrayList = new ArrayList();
                List<String> list = httpURLConnection.getHeaderFields().get("Set-Cookie");
                if (list != null) {
                    for (String str3 : list) {
                        if (str3 != null && str3.length() != 0) {
                            arrayList.addAll(HttpCookie.parse("Set-Cookie: " + str3));
                            Log.i(f61656a, "headerKey: Set-Cookie, field:" + str3);
                        }
                    }
                    for (HttpCookie httpCookie : arrayList) {
                        com.tencent.ads.service.b.a();
                        com.tencent.ads.service.b.b().a(httpCookie);
                    }
                    com.tencent.ads.service.b.a().c();
                }
            } catch (Exception unused) {
                Log.e(f61656a, "save cookie failed");
            }
            responseCode = httpURLConnection.getResponseCode();
        } catch (Throwable th8) {
            th = th8;
            httpURLConnection2 = httpURLConnection;
            try {
                th.printStackTrace();
                Log.d(f61656a, "ping " + str + str2 + " failed");
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                if (dataOutputStream != null) {
                    dataOutputStream.close();
                }
                return false;
            } catch (Throwable th9) {
                if (httpURLConnection2 != null) {
                    try {
                        httpURLConnection2.disconnect();
                    } catch (Throwable th10) {
                        th10.printStackTrace();
                        throw th9;
                    }
                }
                if (dataOutputStream != null) {
                    dataOutputStream.close();
                }
                throw th9;
            }
        }
        if (responseCode >= 0 && responseCode < 400) {
            Log.d(f61656a, "ping " + str + str2 + " succeed");
            try {
                httpURLConnection.disconnect();
                dataOutputStream.close();
            } catch (Throwable th11) {
                th11.printStackTrace();
            }
            return true;
        }
        Log.d(f61656a, "ping " + str + str2 + " failed");
        httpURLConnection.disconnect();
        dataOutputStream.close();
        return false;
    }

    private List e() {
        e e16;
        if (this.f61665j == null) {
            this.f61665j = AdManager.getApplicationContext().getSharedPreferences(f61659d, 0);
        }
        Map<String, ?> all = this.f61665j.getAll();
        if (all.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            if (entry != null && (e16 = e.e(String.valueOf(entry.getValue()))) != null) {
                e16.c(entry.getKey());
                arrayList.add(e16);
            }
        }
        return arrayList;
    }

    public static synchronized PingService getInstance() {
        PingService pingService;
        ArrayList arrayList;
        e e16;
        synchronized (PingService.class) {
            if (f61661f == null) {
                PingService pingService2 = new PingService();
                f61661f = pingService2;
                pingService2.a();
                PingService pingService3 = f61661f;
                if (pingService3.f61665j == null) {
                    pingService3.f61665j = AdManager.getApplicationContext().getSharedPreferences(f61659d, 0);
                }
                Map<String, ?> all = pingService3.f61665j.getAll();
                if (all.isEmpty()) {
                    arrayList = null;
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    for (Map.Entry<String, ?> entry : all.entrySet()) {
                        if (entry != null && (e16 = e.e(String.valueOf(entry.getValue()))) != null) {
                            e16.c(entry.getKey());
                            arrayList2.add(e16);
                        }
                    }
                    arrayList = arrayList2;
                }
                if (arrayList != null && !arrayList.isEmpty()) {
                    f61661f.f61662g.addAll(arrayList);
                    f61661f.c();
                }
            }
            pingService = f61661f;
        }
        return pingService;
    }

    public void doPing(e eVar) {
        d dVar = new d(this, eVar);
        ThreadPoolExecutor threadPoolExecutor = this.f61664i;
        if (threadPoolExecutor == null || threadPoolExecutor.isShutdown()) {
            return;
        }
        try {
            this.f61664i.execute(dVar);
        } catch (Throwable unused) {
        }
    }

    public void start() {
        ThreadPoolExecutor threadPoolExecutor = this.f61664i;
        if (threadPoolExecutor == null || threadPoolExecutor.isShutdown()) {
            Log.d(f61656a, "thread pool start");
            a();
        }
    }

    public void stop() {
        ThreadPoolExecutor threadPoolExecutor = this.f61664i;
        if (threadPoolExecutor == null || threadPoolExecutor.isShutdown()) {
            return;
        }
        Log.d(f61656a, "thread pool shutdown");
        this.f61664i.shutdown();
    }

    private void a() {
        Log.d(f61656a, "initThreadPool");
        this.f61664i = new ThreadPoolExecutor(2, 3, 2L, TimeUnit.SECONDS, new ArrayBlockingQueue(20), new ThreadPoolExecutor.DiscardOldestPolicy());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(PingService pingService) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = pingService.f61663h;
        if (scheduledThreadPoolExecutor == null || scheduledThreadPoolExecutor.isShutdown()) {
            return;
        }
        pingService.f61663h.shutdown();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(PingService pingService, e eVar) {
        if (pingService.f61665j == null) {
            pingService.f61665j = AdManager.getApplicationContext().getSharedPreferences(f61659d, 0);
        }
        if (eVar == null || TextUtils.isEmpty(eVar.e())) {
            return;
        }
        pingService.f61665j.edit().putString(eVar.e(), eVar.j()).commit();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(PingService pingService, e eVar) {
        if (pingService.f61665j == null) {
            pingService.f61665j = AdManager.getApplicationContext().getSharedPreferences(f61659d, 0);
        }
        if (eVar != null) {
            String str = String.valueOf(System.currentTimeMillis()) + String.valueOf(f61660e.nextInt() & 255);
            eVar.c(str);
            pingService.f61665j.edit().putString(str, eVar.j()).commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(PingService pingService, String str) {
        if (pingService.f61665j == null) {
            pingService.f61665j = AdManager.getApplicationContext().getSharedPreferences(f61659d, 0);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        pingService.f61665j.edit().remove(str).commit();
    }

    private void b(e eVar) {
        if (this.f61665j == null) {
            this.f61665j = AdManager.getApplicationContext().getSharedPreferences(f61659d, 0);
        }
        if (eVar == null || TextUtils.isEmpty(eVar.e())) {
            return;
        }
        this.f61665j.edit().putString(eVar.e(), eVar.j()).commit();
    }

    private void a(e eVar) {
        if (this.f61665j == null) {
            this.f61665j = AdManager.getApplicationContext().getSharedPreferences(f61659d, 0);
        }
        if (eVar == null) {
            return;
        }
        String str = String.valueOf(System.currentTimeMillis()) + String.valueOf(f61660e.nextInt() & 255);
        eVar.c(str);
        this.f61665j.edit().putString(str, eVar.j()).commit();
    }

    public static boolean doRequestPing(e eVar) {
        if (eVar == null) {
            return false;
        }
        Log.d(f61656a, "start ping, url:" + eVar.a());
        if (!TextUtils.isEmpty(eVar.d())) {
            return doPostPing(eVar.a(), eVar.d());
        }
        String createUrl = createUrl(eVar.a(), eVar.c(), eVar.k(), eVar.f());
        if (doGetPing(createUrl)) {
            return true;
        }
        eVar.a(createUrl);
        return false;
    }

    private void a(String str) {
        if (this.f61665j == null) {
            this.f61665j = AdManager.getApplicationContext().getSharedPreferences(f61659d, 0);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f61665j.edit().remove(str).commit();
    }
}
