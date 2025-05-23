package com.tencent.mobileqq.unifiedebug;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.biz.common.util.k;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.bc;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.unifiedebug.a;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.utils.m;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.mobileqq.webview.swift.utils.i;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import mqq.app.MainService;
import mqq.app.MobileQQ;
import org.apache.commons.lang.CharEncoding;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes19.dex */
public class UnifiedDebugManager {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public Map<String, String> f305742a;

    /* renamed from: b, reason: collision with root package name */
    public bc f305743b;

    /* renamed from: c, reason: collision with root package name */
    ResultReceiver f305744c;

    /* renamed from: d, reason: collision with root package name */
    final Queue<e> f305745d;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a implements FilenameFilter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f305753d;

        a(String str) {
            this.f305753d = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) UnifiedDebugManager.this, (Object) str);
            }
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) file, (Object) str)).booleanValue();
            }
            return str.startsWith(this.f305753d);
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class b implements FilenameFilter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f305755d;

        b(String str) {
            this.f305755d = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) UnifiedDebugManager.this, (Object) str);
            }
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) file, (Object) str)).booleanValue();
            }
            return str.startsWith(this.f305755d);
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class c implements FilenameFilter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f305757d;

        c(String str) {
            this.f305757d = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) UnifiedDebugManager.this, (Object) str);
            }
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) file, (Object) str)).booleanValue();
            }
            if (str.startsWith(this.f305757d) && str.endsWith(".localstorage")) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class d implements FilenameFilter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f305759d;

        d(String str) {
            this.f305759d = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) UnifiedDebugManager.this, (Object) str);
            }
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) file, (Object) str)).booleanValue();
            }
            if (str.startsWith(this.f305759d) && str.endsWith(".localstorage")) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final String f305761a;

        /* renamed from: b, reason: collision with root package name */
        final long f305762b;

        /* renamed from: c, reason: collision with root package name */
        final long f305763c;

        /* renamed from: d, reason: collision with root package name */
        final String f305764d;

        /* renamed from: e, reason: collision with root package name */
        final int f305765e;

        public e(String str, int i3, long j3, long j16, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, UnifiedDebugManager.this, str, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), str2);
                return;
            }
            this.f305761a = str;
            this.f305762b = j3;
            this.f305763c = j16;
            this.f305764d = str2;
            this.f305765e = i3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f305767a;

        /* renamed from: b, reason: collision with root package name */
        public String f305768b;

        /* renamed from: c, reason: collision with root package name */
        public String f305769c;

        /* renamed from: d, reason: collision with root package name */
        public String f305770d;

        /* renamed from: e, reason: collision with root package name */
        public String f305771e;

        /* renamed from: f, reason: collision with root package name */
        public int f305772f;

        /* renamed from: g, reason: collision with root package name */
        public long f305773g;

        /* renamed from: h, reason: collision with root package name */
        public long f305774h;

        /* renamed from: i, reason: collision with root package name */
        public String f305775i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f305776j;

        /* renamed from: k, reason: collision with root package name */
        public boolean f305777k;

        /* renamed from: l, reason: collision with root package name */
        public int f305778l;

        public f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) UnifiedDebugManager.this);
            }
        }

        public JSONObject a() throws JSONException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (JSONObject) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("mobile_mode", this.f305767a);
            jSONObject.put("os_version", this.f305768b);
            jSONObject.put("app_version", this.f305769c);
            jSONObject.put("net_type", this.f305770d);
            jSONObject.put("carrier_type", this.f305771e);
            jSONObject.put("cpu_num", this.f305772f);
            jSONObject.put("cpu_freq", this.f305773g);
            jSONObject.put("total_ram", this.f305774h);
            jSONObject.put("cpu_type", this.f305775i);
            jSONObject.put("is_proxy", this.f305776j);
            jSONObject.put("is_X5_support", this.f305777k);
            jSONObject.put("X5_version", this.f305778l);
            return jSONObject;
        }
    }

    public UnifiedDebugManager(SnapshotResultReceiver snapshotResultReceiver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) snapshotResultReceiver);
            return;
        }
        this.f305745d = new LinkedList();
        this.f305744c = snapshotResultReceiver;
        this.f305743b = ThreadManagerV2.newHandlerRecycleThread("UnifiedDebugMonitor", 0).b();
        HashMap hashMap = new HashMap();
        this.f305742a = hashMap;
        hashMap.put("offline_pkg", com.tencent.biz.common.offline.c.e());
    }

    public static void B(Context context) {
        Intent intent = new Intent("android.intent.action.ultimatesnapshot");
        intent.putExtra("action", 1);
        intent.putExtra("id", 0L);
        context.sendBroadcast(intent);
        if (QLog.isColorLevel()) {
            QLog.d("UnifiedDebugManager", 2, "send broadcast to finish all alive webview");
        }
    }

    public static void C(Application application) {
        SharedPreferences sharedPreferences = application.getSharedPreferences("x5_proxy_setting", 4);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.remove("http_proxy_address");
        edit.putBoolean("post_encription", true);
        edit.remove("qproxy_address");
        edit.putInt("connect_status", 0);
        edit.remove("qproxy_address_lists");
        edit.putBoolean("is_in_proxy", false);
        edit.putBoolean("need_set_proxy", true);
        edit.commit();
        B(application);
        ThreadManager.getFileThreadHandler().postDelayed(new Runnable(application) { // from class: com.tencent.mobileqq.unifiedebug.UnifiedDebugManager.6
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Application f305752d;

            {
                this.f305752d = application;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) application);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    UnifiedDebugManager.t(this.f305752d);
                }
            }
        }, 2000L);
        if (QLog.isColorLevel()) {
            QLog.d("UnifiedDebugManager", 2, "unset x5 proxy");
            QLog.d("UnifiedDebugManager", 2, "http_proxy_address: " + sharedPreferences.getString("http_proxy_address", "no proxy"));
            QLog.d("UnifiedDebugManager", 2, "qproxy_address_lists: " + sharedPreferences.getString("qproxy_address_lists", "no proxy"));
        }
    }

    public static boolean s(Context context) {
        return context.getSharedPreferences("x5_proxy_setting", 4).contains("http_proxy_address");
    }

    static boolean t(Application application) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) application.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY));
        if (runningAppProcesses != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                String str = runningAppProcessInfo.processName;
                if (str.startsWith(MobileQQ.PACKAGE_NAME) && str.indexOf(58) != -1 && str.endsWith(":tool")) {
                    int i3 = runningAppProcessInfo.importance;
                    if (i3 != 100) {
                        if (i3 != 200 || (i3 == 200 && runningAppProcessInfo.importanceReasonCode != 0)) {
                            Utils.N(application, MainService.QQPROCESSNAME + ":tool");
                            return true;
                        }
                        return false;
                    }
                    return false;
                }
            }
            return false;
        }
        return false;
    }

    public static void v(Application application, String str, int i3) {
        SharedPreferences sharedPreferences = application.getSharedPreferences("x5_proxy_setting", 4);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("http_proxy_address", str + ":" + i3);
        edit.putBoolean("post_encription", false);
        edit.putString("qproxy_address", "http://" + str + ":" + i3);
        edit.putInt("connect_status", 1);
        edit.putString("qproxy_address_lists", str + ":" + i3);
        edit.putBoolean("is_in_proxy", true);
        edit.putBoolean("need_set_proxy", true);
        edit.commit();
        Utils.N(application, MainService.QQPROCESSNAME + ":tool");
        if (QLog.isColorLevel()) {
            QLog.d("UnifiedDebugManager", 2, "set x5 proxy: " + str + ":" + i3);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("http_proxy_address: ");
            sb5.append(sharedPreferences.getString("http_proxy_address", "no proxy"));
            QLog.d("UnifiedDebugManager", 2, sb5.toString());
            QLog.d("UnifiedDebugManager", 2, "qproxy_address_lists: " + sharedPreferences.getString("qproxy_address_lists", "no proxy"));
            QLog.d("UnifiedDebugManager", 2, "sQQBrowserActivityCounter =  " + QQBrowserActivity.sQQBrowserActivityCounter);
        }
    }

    public void A(Context context, String str, int i3, long j3, long j16, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, context, str, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), str2);
            return;
        }
        synchronized (this.f305745d) {
            if (this.f305745d.isEmpty()) {
                z(context, str, i3, j3, j16, str2);
                if (QLog.isColorLevel()) {
                    QLog.d("UnifiedDebugManager", 2, "start debug(queue is empty): seq=" + j16);
                }
            } else if (QLog.isColorLevel()) {
                QLog.d("UnifiedDebugManager", 2, "start debug(only enqueue one cmd): seq=" + j16);
            }
            this.f305745d.offer(new e(str, i3, j3, j16, str2));
        }
    }

    public void D(QQAppInterface qQAppInterface, long j3, String str, Handler handler) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, qQAppInterface, Long.valueOf(j3), str, handler);
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            String l3 = l(str);
            if (QLog.isColorLevel()) {
                QLog.d("UnifiedDebugManager", 2, "traceRoute getHost = " + l3);
            }
            String n3 = n(l3);
            if (QLog.isColorLevel()) {
                QLog.d("UnifiedDebugManager", 2, "traceRoute getIp = " + n3);
            }
            new UnifiedTraceRouter(qQAppInterface, handler).e(j3, l3, u(str));
            return;
        }
        throw new IOException("url is empty");
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01b1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01a1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String E(QQAppInterface qQAppInterface, long j3, String str) throws Exception {
        Throwable th5;
        BufferedInputStream bufferedInputStream;
        HttpURLConnection httpURLConnection;
        FileOutputStream fileOutputStream;
        BufferedInputStream bufferedInputStream2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (String) iPatchRedirector.redirect((short) 25, this, qQAppInterface, Long.valueOf(j3), str);
        }
        Bundle bundle = new Bundle();
        bundle.putString("User-Agent", i.i(""));
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        String cookie = cookieManager.getCookie(str);
        if (cookie != null) {
            bundle.putString("Cookie", cookie);
            if (QLog.isColorLevel()) {
                QLog.d("UnifiedDebugManager", 2, "Get cookie: " + k.e(cookie, new String[0]) + " from " + k.f(str, new String[0]));
            }
        }
        String str2 = Environment.getExternalStorageDirectory() + "/tencent/MobileQQ/unifiedebug";
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        String valueOf = String.valueOf(j3);
        String str3 = str2 + "/" + valueOf + ".html";
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(new File(str3));
            try {
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                try {
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setConnectTimeout(6000);
                    httpURLConnection.setReadTimeout(6000);
                    for (String str4 : bundle.keySet()) {
                        Object obj = bundle.get(str4);
                        if (obj instanceof String) {
                            httpURLConnection.setRequestProperty(str4, (String) obj);
                        }
                    }
                    httpURLConnection.connect();
                    if (200 == httpURLConnection.getResponseCode()) {
                        byte[] bArr = new byte[1024];
                        bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                        while (true) {
                            try {
                                int read = bufferedInputStream.read(bArr);
                                if (-1 == read) {
                                    break;
                                }
                                fileOutputStream2.write(bArr, 0, read);
                            } catch (Exception e16) {
                                e = e16;
                                fileOutputStream = fileOutputStream2;
                                try {
                                    QLog.e("UnifiedDebugManager", 1, "uploadHTMLSource error: ", e);
                                    throw e;
                                } catch (Throwable th6) {
                                    th5 = th6;
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                        } catch (Exception e17) {
                                            QLog.e("UnifiedDebugManager", 1, "uploadHTMLSource error: ", e17);
                                        }
                                    }
                                    if (httpURLConnection != null) {
                                        httpURLConnection.disconnect();
                                    }
                                    if (bufferedInputStream == null) {
                                        try {
                                            bufferedInputStream.close();
                                            throw th5;
                                        } catch (IOException e18) {
                                            QLog.e("UnifiedDebugManager", 1, "Close In error: ", e18);
                                            throw th5;
                                        }
                                    }
                                    throw th5;
                                }
                            } catch (Throwable th7) {
                                th5 = th7;
                                fileOutputStream = fileOutputStream2;
                                if (fileOutputStream != null) {
                                }
                                if (httpURLConnection != null) {
                                }
                                if (bufferedInputStream == null) {
                                }
                            }
                        }
                        fileOutputStream2.flush();
                        bufferedInputStream2 = bufferedInputStream;
                    } else {
                        bufferedInputStream2 = null;
                    }
                    try {
                        fileOutputStream2.close();
                    } catch (Exception e19) {
                        QLog.e("UnifiedDebugManager", 1, "uploadHTMLSource error: ", e19);
                    }
                    httpURLConnection.disconnect();
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException e26) {
                            QLog.e("UnifiedDebugManager", 1, "Close In error: ", e26);
                        }
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(str3);
                    String str5 = str2 + "/" + valueOf + ".zip";
                    com.tencent.mobileqq.unifiedebug.d.f(arrayList, str5);
                    return str5;
                } catch (Exception e27) {
                    e = e27;
                    fileOutputStream = fileOutputStream2;
                    bufferedInputStream = null;
                } catch (Throwable th8) {
                    th5 = th8;
                    fileOutputStream = fileOutputStream2;
                    bufferedInputStream = null;
                }
            } catch (Exception e28) {
                e = e28;
                fileOutputStream = fileOutputStream2;
                bufferedInputStream = null;
                httpURLConnection = null;
            } catch (Throwable th9) {
                th5 = th9;
                fileOutputStream = fileOutputStream2;
                bufferedInputStream = null;
                httpURLConnection = null;
            }
        } catch (Exception e29) {
            e = e29;
            bufferedInputStream = null;
            httpURLConnection = null;
            fileOutputStream = null;
        } catch (Throwable th10) {
            th5 = th10;
            bufferedInputStream = null;
            httpURLConnection = null;
            fileOutputStream = null;
        }
    }

    public String F(File file, List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this, (Object) file, (Object) list);
        }
        String absolutePath = new File(file, "files-" + System.currentTimeMillis() + ".zip").getAbsolutePath();
        LinkedList linkedList = new LinkedList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            linkedList.add(file + "/" + list.get(i3));
        }
        com.tencent.mobileqq.unifiedebug.d.e(file, list, absolutePath);
        return absolutePath;
    }

    public String G(Context context, List<String> list) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this, (Object) context, (Object) list);
        }
        int tbsVersion = QbSdk.getTbsVersion(context);
        ArrayList arrayList = new ArrayList();
        char c16 = 0;
        if (tbsVersion < 30000) {
            String[] strArr = {"url", "filepath"};
            String path = context.getDatabasePath("webviewCache_x5.db").getPath();
            File file = new File(context.getCacheDir(), "webviewCache");
            SQLiteDatabase openDatabase = SQLiteDatabase.openDatabase(path, null, 0);
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                String[] strArr2 = new String[1];
                strArr2[c16] = it.next();
                Cursor query = openDatabase.query("cache", strArr, "url=?", strArr2, null, null, null);
                while (query.moveToNext()) {
                    arrayList.add(new File(file, query.getString(1)).getPath());
                }
                query.close();
                c16 = 0;
            }
            openDatabase.close();
            String str = file.getPath() + "/html_cache.zip";
            com.tencent.mobileqq.unifiedebug.d.f(arrayList, str);
            return str;
        }
        String str2 = context.getApplicationContext().getDir("webview", 0).getPath() + "/Cache/";
        File file2 = new File(str2);
        if (file2.exists() && file2.isDirectory()) {
            Iterator<String> it5 = list.iterator();
            while (it5.hasNext()) {
                String[] list2 = file2.list(new a(w(it5.next()).substring(0, 16)));
                if (list2 != null) {
                    for (String str3 : list2) {
                        arrayList.add(str2 + str3);
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                String str4 = str2 + "html_cache.zip";
                com.tencent.mobileqq.unifiedebug.d.f(arrayList, str4);
                return str4;
            }
            throw new FileNotFoundException("no cache file was found");
        }
        throw new FileNotFoundException("no cache directory found");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r12v4 */
    public String H(Context context, String str) throws Exception {
        JSONArray jSONArray;
        JSONObject jSONObject;
        ArrayList arrayList;
        String str2;
        String str3;
        int i3;
        Throwable th5;
        ?? r122;
        BufferedOutputStream bufferedOutputStream;
        String str4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this, (Object) context, (Object) str);
        }
        String[] strArr = {"key", "value"};
        URL url = new URL(str);
        String protocol2 = url.getProtocol();
        String host = url.getHost();
        String str5 = protocol2 + "_" + host + "_";
        File file = new File(p(context));
        if (file.exists() && file.isDirectory()) {
            String[] list = file.list(new c(str5));
            ArrayList arrayList2 = new ArrayList();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("host", host);
            JSONArray jSONArray2 = new JSONArray();
            String str6 = "UnifiedDebugManager";
            if (list != null && list.length > 0) {
                int length = list.length;
                ArrayList arrayList3 = arrayList2;
                int i16 = 0;
                while (i16 < length) {
                    SQLiteDatabase openDatabase = SQLiteDatabase.openDatabase(file.getPath() + "/" + list[i16], null, 1);
                    int i17 = length;
                    String str7 = str6;
                    JSONArray jSONArray3 = jSONArray2;
                    JSONObject jSONObject3 = jSONObject2;
                    ArrayList arrayList4 = arrayList3;
                    int i18 = i16;
                    Cursor query = openDatabase.query("ItemTable", strArr, null, null, null, null, null);
                    while (query.moveToNext()) {
                        String string = query.getString(0);
                        String str8 = new String(query.getBlob(1), CharEncoding.UTF_16LE);
                        JSONObject jSONObject4 = new JSONObject();
                        jSONObject4.put("key", string);
                        jSONObject4.put("value", str8);
                        jSONArray3.mo162put(jSONObject4);
                    }
                    if (QLog.isColorLevel()) {
                        str4 = str7;
                        QLog.d(str4, 2, "zipLocalStorage value = " + jSONArray3.toString());
                    } else {
                        str4 = str7;
                    }
                    query.close();
                    openDatabase.close();
                    jSONArray2 = jSONArray3;
                    str6 = str4;
                    length = i17;
                    jSONObject2 = jSONObject3;
                    arrayList3 = arrayList4;
                    i16 = i18 + 1;
                }
                arrayList = arrayList3;
                str3 = str6;
                jSONArray = jSONArray2;
                jSONObject = jSONObject2;
                i3 = 1;
                str2 = null;
            } else {
                jSONArray = jSONArray2;
                jSONObject = jSONObject2;
                arrayList = arrayList2;
                str2 = null;
                str3 = "UnifiedDebugManager";
                i3 = 1;
            }
            JSONObject jSONObject5 = jSONObject;
            jSONObject5.put("data", jSONArray);
            File file2 = new File(file, "json.txt");
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
            } catch (Throwable th6) {
                th5 = th6;
                r122 = str2;
            }
            try {
                bufferedOutputStream.write(jSONObject5.toString().getBytes());
                bufferedOutputStream.flush();
                ArrayList arrayList5 = arrayList;
                arrayList5.add(file2.getPath());
                try {
                    bufferedOutputStream.close();
                } catch (IOException e16) {
                    QLog.e(str3, i3, "os closed error", e16);
                }
                if (!arrayList5.isEmpty()) {
                    String str9 = file.getPath() + "/localstorage_" + host + ".zip";
                    com.tencent.mobileqq.unifiedebug.d.f(arrayList5, str9);
                    com.tencent.mobileqq.unifiedebug.d.a(arrayList5);
                    return str9;
                }
                return str2;
            } catch (Throwable th7) {
                th5 = th7;
                r122 = bufferedOutputStream;
                if (r122 != 0) {
                    try {
                        r122.close();
                        throw th5;
                    } catch (IOException e17) {
                        QLog.e(str3, i3, "os closed error", e17);
                        throw th5;
                    }
                }
                throw th5;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0124 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01d2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String I(long j3, long j16) {
        int i3;
        String str;
        File file;
        Throwable th5;
        BufferedWriter bufferedWriter;
        int i16;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, this, Long.valueOf(j3), Long.valueOf(j16));
        }
        Calendar calendar = Calendar.getInstance();
        long j17 = j3;
        calendar.setTimeInMillis(j17);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(j16);
        long currentTimeMillis = System.currentTimeMillis();
        if (j16 >= currentTimeMillis) {
            calendar2.setTimeInMillis(currentTimeMillis);
        }
        int i17 = calendar.get(1);
        int i18 = calendar.get(2) + 1;
        int i19 = calendar.get(5);
        int i26 = calendar.get(10);
        int i27 = calendar2.get(1);
        int i28 = calendar2.get(2) + 1;
        int i29 = calendar2.get(5);
        int i36 = calendar2.get(10);
        HashSet hashSet = new HashSet();
        int i37 = 0;
        while (true) {
            i3 = i36;
            String format = QLog.getLogFileFormatter().format(Long.valueOf(j17));
            hashSet.add(format);
            if (i37 == 0) {
                i37 = format.length();
            }
            long j18 = j17 + 3600000;
            if (j18 > j16) {
                break;
            }
            j17 = j18;
            i36 = i3;
        }
        ArrayList arrayList = new ArrayList();
        File file2 = new File(QLog.getLogPath());
        String str3 = ".zip";
        if (!file2.exists()) {
            str = ".zip";
            file2.mkdirs();
        } else {
            File[] listFiles = file2.listFiles();
            if (listFiles != null) {
                int length = listFiles.length;
                int i38 = 0;
                while (i38 < length) {
                    File file3 = listFiles[i38];
                    File[] fileArr = listFiles;
                    String name = file3.getName();
                    if (name.endsWith(str3)) {
                        str2 = str3;
                        i16 = length;
                    } else {
                        i16 = length;
                        if (name.endsWith(".log")) {
                            str2 = str3;
                            name = name.substring(0, name.length() - 4);
                        } else {
                            str2 = str3;
                            if (name.endsWith(".qlog")) {
                                name = name.substring(0, name.length() - 5);
                                if (!name.startsWith(MobileQQ.PACKAGE_NAME)) {
                                    String substring = name.substring(name.length() - i37);
                                    if (!TextUtils.isEmpty(substring) && hashSet.contains(substring)) {
                                        arrayList.add(file3.getPath());
                                    }
                                }
                            }
                        }
                        if (!name.startsWith(MobileQQ.PACKAGE_NAME)) {
                        }
                    }
                    i38++;
                    listFiles = fileArr;
                    str3 = str2;
                    length = i16;
                }
            }
            str = str3;
        }
        File file4 = null;
        BufferedWriter bufferedWriter2 = null;
        File file5 = null;
        if (file2.exists()) {
            File file6 = new File(file2, "FileList.log");
            try {
                try {
                    BufferedWriter bufferedWriter3 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file6)));
                    try {
                        File[] listFiles2 = file2.listFiles();
                        if (listFiles2 != null) {
                            int length2 = listFiles2.length;
                            int i39 = 0;
                            while (i39 < length2) {
                                bufferedWriter3.write(listFiles2[i39].getName() + "\n");
                                i39++;
                                listFiles2 = listFiles2;
                            }
                        }
                        bufferedWriter3.flush();
                        try {
                            bufferedWriter3.close();
                        } catch (IOException e16) {
                            QLog.e("UnifiedDebugManager", 1, "bw closed error. ", e16);
                        }
                    } catch (Exception e17) {
                        e = e17;
                        bufferedWriter2 = bufferedWriter3;
                        QLog.e("UnifiedDebugManager", 1, "read Log file list error. ", e);
                        if (bufferedWriter2 != null) {
                            try {
                                bufferedWriter2.close();
                            } catch (IOException e18) {
                                QLog.e("UnifiedDebugManager", 1, "bw closed error. ", e18);
                            }
                        }
                        file5 = file6;
                        file4 = file5;
                        if (file4 != null) {
                        }
                        file = new File("/data/anr/traces.txt");
                        if (file.exists()) {
                        }
                        String str4 = QLog.getLogPath() + i17 + "_" + i18 + "_" + i19 + "_" + i26 + "-" + i27 + "_" + i28 + "_" + i29 + "_" + i3 + str;
                        com.tencent.mobileqq.unifiedebug.d.f(arrayList, str4);
                        return str4;
                    } catch (Throwable th6) {
                        th5 = th6;
                        bufferedWriter = bufferedWriter3;
                        if (bufferedWriter != 0) {
                            try {
                                bufferedWriter.close();
                                throw th5;
                            } catch (IOException e19) {
                                QLog.e("UnifiedDebugManager", 1, "bw closed error. ", e19);
                                throw th5;
                            }
                        }
                        throw th5;
                    }
                } catch (Exception e26) {
                    e = e26;
                }
                file5 = file6;
                file4 = file5;
            } catch (Throwable th7) {
                th5 = th7;
                bufferedWriter = file5;
            }
        }
        if (file4 != null) {
            arrayList.add(file4.getPath());
        }
        file = new File("/data/anr/traces.txt");
        if (file.exists()) {
            arrayList.add(file.getPath());
        }
        String str42 = QLog.getLogPath() + i17 + "_" + i18 + "_" + i19 + "_" + i26 + "-" + i27 + "_" + i28 + "_" + i29 + "_" + i3 + str;
        com.tencent.mobileqq.unifiedebug.d.f(arrayList, str42);
        return str42;
    }

    public String J(List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, (Object) this, (Object) list);
        }
        String str = Environment.getExternalStorageDirectory().getPath() + "/tencent/MobileQQ/unifiedebug/snapshots.zip";
        com.tencent.mobileqq.unifiedebug.d.f(list, str);
        return str;
    }

    public String K(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), "/tencent/tbs_live_log/com.tencent.mobileqq/");
        File file2 = new File(file, "com.tencent.mobileqq_tool_livelog_" + str + ".livelog");
        if (file2.exists()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(file2.getName());
            return F(file, arrayList);
        }
        return "";
    }

    public String a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        if (this.f305742a.containsKey(str)) {
            return this.f305742a.get(str);
        }
        return str;
    }

    public void b(Context context, String str, List<String> list) throws SQLiteException {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, context, str, list);
            return;
        }
        int tbsVersion = QbSdk.getTbsVersion(context);
        String g16 = g(context, tbsVersion);
        if (tbsVersion < 30000) {
            str2 = "domain=? and name=?";
        } else {
            str2 = "host_key=? and name=?";
        }
        SQLiteDatabase openDatabase = SQLiteDatabase.openDatabase(g16, null, 0);
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            openDatabase.delete("cookies", str2, new String[]{str, it.next()});
        }
        openDatabase.close();
    }

    public boolean c(File file, List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) file, (Object) list)).booleanValue();
        }
        if (file != null && list != null && !list.isEmpty()) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                File file2 = new File(file, it.next());
                if (file2.exists()) {
                    if (file2.isDirectory()) {
                        return VasUpdateUtil.safeDeleteFile(file2);
                    }
                    return file2.delete();
                }
            }
        }
        return false;
    }

    public void d(Context context, List<String> list) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) context, (Object) list);
            return;
        }
        if (QbSdk.getTbsVersion(context) < 30000) {
            String[] strArr = {"url", "filepath"};
            String path = context.getDatabasePath("webviewCache_x5.db").getPath();
            File file = new File(context.getCacheDir(), "webviewCache");
            SQLiteDatabase openDatabase = SQLiteDatabase.openDatabase(path, null, 0);
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                Cursor query = openDatabase.query("cache", strArr, "url=?", new String[]{it.next()}, null, null, null);
                while (query.moveToNext()) {
                    String string = query.getString(0);
                    String string2 = query.getString(1);
                    File file2 = new File(file, string2);
                    if (file2.exists() && file2.delete()) {
                        openDatabase.delete("cache", "url=? and filepath=?", new String[]{string, string2});
                    }
                }
                query.close();
            }
            openDatabase.close();
            return;
        }
        File file3 = new File(context.getApplicationContext().getDir("webview", 0).getPath() + "/Cache");
        Iterator<String> it5 = list.iterator();
        while (it5.hasNext()) {
            File[] listFiles = file3.listFiles(new b(w(it5.next()).substring(0, 16)));
            if (listFiles != null) {
                for (File file4 : listFiles) {
                    file4.delete();
                }
            }
        }
    }

    public void e(Context context, String str, List<String> list) throws SQLiteException, MalformedURLException {
        String[] list2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, context, str, list);
            return;
        }
        URL url = new URL(str);
        String str2 = url.getProtocol() + "_" + url.getHost() + "_";
        File file = new File(p(context));
        if (file.exists() && file.isDirectory() && (list2 = file.list(new d(str2))) != null && list2.length > 0) {
            for (String str3 : list2) {
                SQLiteDatabase openDatabase = SQLiteDatabase.openDatabase(file.getPath() + "/" + str3, null, 0);
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    openDatabase.delete("ItemTable", "key=?", new String[]{it.next()});
                }
                openDatabase.close();
            }
        }
    }

    public boolean f(Context context, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, this, context, Long.valueOf(j3))).booleanValue();
        }
        synchronized (this.f305745d) {
            e poll = this.f305745d.poll();
            if (poll == null || poll.f305763c != j3) {
                return false;
            }
            e peek = this.f305745d.peek();
            if (peek != null) {
                z(context, peek.f305761a, peek.f305765e, peek.f305762b, peek.f305763c, peek.f305764d);
                if (QLog.isColorLevel()) {
                    QLog.d("UnifiedDebugManager", 2, "finish once webview debug, start new debug(dequeue one cmd): seq=" + peek.f305763c);
                }
            } else if (QLog.isColorLevel()) {
                QLog.d("UnifiedDebugManager", 2, "finish once webview debug: seq=" + j3);
            }
            return true;
        }
    }

    String g(Context context, int i3) {
        if (i3 < 30000) {
            return context.getDatabasePath("webview_x5.db").getPath();
        }
        return context.getApplicationContext().getDir("webview", 0).getPath() + "/Cookies";
    }

    public Set<String> h(Context context) throws SQLiteException {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Set) iPatchRedirector.redirect((short) 13, (Object) this, (Object) context);
        }
        int tbsVersion = QbSdk.getTbsVersion(context);
        if (tbsVersion < 30000) {
            str = "domain";
        } else {
            str = "host_key";
        }
        SQLiteDatabase openDatabase = SQLiteDatabase.openDatabase(g(context, tbsVersion), null, 1);
        Cursor query = openDatabase.query("cookies", new String[]{str}, null, null, null, null, null);
        HashSet hashSet = new HashSet();
        while (query.moveToNext()) {
            hashSet.add(query.getString(0));
        }
        query.close();
        openDatabase.close();
        return hashSet;
    }

    public List<Map<String, Object>> i(Context context, String str) throws SQLiteException {
        String[] strArr;
        Object valueOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (List) iPatchRedirector.redirect((short) 14, (Object) this, (Object) context, (Object) str);
        }
        int tbsVersion = QbSdk.getTbsVersion(context);
        if (!str.startsWith(".")) {
            str = "." + str;
        }
        if (tbsVersion < 30000) {
            strArr = new String[]{"domain", "name", "value", "path", "expires", ClientCookie.SECURE_ATTR};
        } else {
            strArr = new String[]{"host_key", "name", "value", "path", "expires_utc", ClientCookie.SECURE_ATTR, "httponly", "has_expires", "persistent", "priority"};
        }
        SQLiteDatabase openDatabase = SQLiteDatabase.openDatabase(g(context, tbsVersion), null, 1);
        Cursor query = openDatabase.query("cookies", strArr, null, null, null, null, null);
        ArrayList arrayList = new ArrayList();
        while (query.moveToNext()) {
            String string = query.getString(0);
            if (str.endsWith(string) || str.equals(string)) {
                HashMap hashMap = new HashMap();
                for (int i3 = 0; i3 < strArr.length; i3++) {
                    String str2 = strArr[i3];
                    if (i3 <= 3) {
                        valueOf = query.getString(i3);
                    } else {
                        valueOf = Integer.valueOf(query.getInt(i3));
                    }
                    hashMap.put(str2, valueOf);
                }
                arrayList.add(hashMap);
            }
        }
        query.close();
        openDatabase.close();
        return arrayList;
    }

    public String j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (String) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        a.C8876a a16 = com.tencent.mobileqq.unifiedebug.a.a("getprop net.dns1");
        if (a16.f305796a) {
            if (!a16.f305797b.isEmpty()) {
                return a16.f305797b.get(0);
            }
            return "";
        }
        if (QLog.isColorLevel()) {
            QLog.d("UnifiedDebugManager", 2, a16.f305798c);
            return "";
        }
        return "";
    }

    public JSONObject k(File file, String str) throws JSONException {
        File[] fileArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (JSONObject) iPatchRedirector.redirect((short) 7, (Object) this, (Object) file, (Object) str);
        }
        JSONObject jSONObject = new JSONObject();
        if (file == null) {
            return jSONObject;
        }
        if (file.exists() && file.isDirectory()) {
            fileArr = file.listFiles();
        } else {
            fileArr = null;
        }
        if (fileArr != null) {
            jSONObject.put("module_dir", str);
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = new JSONArray();
            for (File file2 : fileArr) {
                JSONArray jSONArray3 = new JSONArray();
                jSONArray3.mo162put(file2.getName());
                if (file2.isFile()) {
                    jSONArray3.put(file2.length() / 1000.0d);
                    jSONArray3.put(0);
                    jSONArray3.put(file2.lastModified());
                    jSONArray.mo162put(jSONArray3);
                } else {
                    jSONArray3.put(0);
                    jSONArray3.put(0);
                    jSONArray3.put(file2.lastModified());
                    jSONArray2.mo162put(jSONArray3);
                }
            }
            jSONObject.put("sub_dir", jSONArray2);
            jSONObject.put("files", jSONArray);
        }
        return jSONObject;
    }

    String l(String str) throws MalformedURLException {
        return new URL(str).getHost();
    }

    @Deprecated
    public List<String> m(Context context) throws SQLiteException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (List) iPatchRedirector.redirect((short) 10, (Object) this, (Object) context);
        }
        if (QbSdk.getTbsVersion(context) < 30000) {
            SQLiteDatabase openDatabase = SQLiteDatabase.openDatabase(context.getDatabasePath("webviewCache_x5.db").getPath(), null, 1);
            Cursor query = openDatabase.query("cache", new String[]{"url"}, null, null, null, null, null);
            ArrayList arrayList = new ArrayList();
            while (query.moveToNext()) {
                arrayList.add(query.getString(0));
            }
            query.close();
            openDatabase.close();
            return arrayList;
        }
        return new ArrayList();
    }

    public String n(String str) throws UnknownHostException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (String) iPatchRedirector.redirect((short) 27, (Object) this, (Object) str);
        }
        return InetAddress.getByName(str).getHostAddress();
    }

    public Set<String> o(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (Set) iPatchRedirector.redirect((short) 16, (Object) this, (Object) context);
        }
        String[] c16 = com.tencent.mobileqq.unifiedebug.d.c(p(context));
        HashSet hashSet = new HashSet();
        if (c16 != null && c16.length > 0) {
            for (String str : c16) {
                String[] split = str.split("_");
                if (split.length == 3) {
                    hashSet.add(split[1]);
                }
            }
        }
        return hashSet;
    }

    String p(Context context) {
        if (QbSdk.getTbsVersion(context) < 30000) {
            if (QLog.isColorLevel()) {
                QLog.d("UnifiedDebugManager", 2, "Local StoragePath = " + context.getApplicationContext().getDir("database_web", 0).getPath());
            }
            return context.getApplicationContext().getDir("database_web", 0).getPath();
        }
        if (QLog.isColorLevel()) {
            QLog.d("UnifiedDebugManager", 2, "Local StoragePath = " + context.getApplicationContext().getDir("webview", 0).getPath() + "/Local Storage/");
        }
        return context.getApplicationContext().getDir("webview", 0).getPath() + "/Local Storage/";
    }

    public bc q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (bc) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f305743b;
    }

    public f r(Context context) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (f) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
        }
        f fVar = new f();
        fVar.f305767a = ah.C() + " " + ah.s();
        fVar.f305768b = Build.VERSION.RELEASE;
        fVar.f305769c = AppSetting.f99554n;
        ah.a G = ah.G(context);
        fVar.f305770d = G.f307417a;
        fVar.f305771e = G.f307419c;
        fVar.f305772f = ah.n();
        fVar.f305773g = ah.l();
        fVar.f305774h = m.c();
        fVar.f305775i = ah.o();
        fVar.f305776j = s(context);
        int tbsVersion = QbSdk.getTbsVersion(context);
        fVar.f305778l = tbsVersion;
        if (tbsVersion == 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        fVar.f305777k = z16;
        return fVar;
    }

    Map<String, Object> u(String str) throws IOException {
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, 10000);
        HttpConnectionParams.setSoTimeout(basicHttpParams, 10000);
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient(basicHttpParams);
        HttpGet httpGet = new HttpGet(str);
        long currentTimeMillis = System.currentTimeMillis();
        HttpResponse execute = defaultHttpClient.execute(httpGet);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        int statusCode = execute.getStatusLine().getStatusCode();
        HashMap hashMap = new HashMap();
        hashMap.put("status", Integer.valueOf(statusCode));
        hashMap.put(PreDownloadConstants.RPORT_KEY_DOWNLOAD_TIME, Long.valueOf(currentTimeMillis2));
        if (statusCode / 100 == 2) {
            hashMap.put("size", Integer.valueOf(EntityUtils.toByteArray(execute.getEntity()).length));
        }
        return hashMap;
    }

    String w(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_SHA1);
        messageDigest.update(str.getBytes());
        byte[] digest = messageDigest.digest();
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b16 : digest) {
            String hexString = Integer.toHexString(b16 & 255);
            if (hexString.length() < 2) {
                stringBuffer.append(0);
            }
            stringBuffer.append(hexString);
        }
        return stringBuffer.toString();
    }

    public void x(Context context, long j3, long j16, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, context, Long.valueOf(j3), Long.valueOf(j16), str, Integer.valueOf(i3));
            return;
        }
        Intent intent = new Intent(context, (Class<?>) SnapshotService.class);
        intent.setFlags(268435456);
        intent.putExtra("id", j3);
        intent.putExtra("action", 0);
        intent.putExtra("seq", j16);
        intent.putExtra("seqKey", str);
        intent.putExtra("maxSnapshotCount", i3);
        intent.putExtra("callback", this.f305744c);
        context.startActivity(intent);
        if (QLog.isColorLevel()) {
            QLog.d("UnifiedDebugManager", 2, "start alive snapshot to webview(" + j3 + ")");
        }
    }

    public void y(Context context, String str, int i3, long j3, long j16, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, context, str, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), str2);
            return;
        }
        Intent intent = new Intent(context, (Class<?>) SnapshotService.class);
        intent.setFlags(268435456);
        intent.putExtra("id", j16);
        intent.putExtra("action", 2);
        intent.putExtra("debugUrl", str);
        intent.putExtra("seq", j16);
        intent.putExtra("seqKey", str2);
        intent.putExtra("delay", j3);
        intent.putExtra("maxSnapshotCount", i3);
        intent.putExtra("callback", this.f305744c);
        context.startActivity(intent);
        if (QLog.isColorLevel()) {
            QLog.d("UnifiedDebugManager", 2, "start alive snapshot, seq=" + j16);
        }
    }

    void z(Context context, String str, int i3, long j3, long j16, String str2) {
        Intent intent = new Intent(context, (Class<?>) SnapshotService.class);
        intent.setFlags(268435456);
        intent.putExtra("debugUrl", str);
        intent.putExtra("seq", j16);
        intent.putExtra("seqKey", str2);
        intent.putExtra("delay", j3);
        intent.putExtra("maxSnapshotCount", i3);
        intent.putExtra("callback", this.f305744c);
        context.startActivity(intent);
        this.f305743b.postDelayed(new Runnable(j16, context, str, i3, j3, str2) { // from class: com.tencent.mobileqq.unifiedebug.UnifiedDebugManager.5
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ long f305746d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Context f305747e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f305748f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ int f305749h;

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ long f305750i;

            /* renamed from: m, reason: collision with root package name */
            final /* synthetic */ String f305751m;

            {
                this.f305746d = j16;
                this.f305747e = context;
                this.f305748f = str;
                this.f305749h = i3;
                this.f305750i = j3;
                this.f305751m = str2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, UnifiedDebugManager.this, Long.valueOf(j16), context, str, Integer.valueOf(i3), Long.valueOf(j3), str2);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                synchronized (UnifiedDebugManager.this.f305745d) {
                    e peek = UnifiedDebugManager.this.f305745d.peek();
                    if (peek != null) {
                        long j17 = peek.f305763c;
                        long j18 = this.f305746d;
                        if (j17 == j18) {
                            UnifiedDebugManager.this.z(this.f305747e, this.f305748f, this.f305749h, this.f305750i, j18, this.f305751m);
                            if (QLog.isColorLevel()) {
                                QLog.d("UnifiedDebugManager", 2, "start debug(retry): seq=" + this.f305746d);
                            }
                        }
                    }
                }
            }
        }, 120000 + j3);
    }
}
