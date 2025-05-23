package org.extra.tools;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.tencent.local_edit.andserver.util.MediaType;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.raft.raftframework.sla.SLAReporter;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONObject;
import org.libpag.PAG;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Reporter {

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicReference f423589a = new AtomicReference(b.Unreported);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Reporter.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public enum b {
        Unreported,
        Reporting,
        Reported
    }

    private static native String authName();

    private static String b() {
        return new SimpleDateFormat("yyyy-MM").format(new Date());
    }

    public static void c() {
        BaseThreadPoolExecutor baseThreadPoolExecutor;
        Throwable th5;
        AtomicReference atomicReference = f423589a;
        if (atomicReference.get() != b.Unreported) {
            return;
        }
        atomicReference.set(b.Reporting);
        try {
            baseThreadPoolExecutor = new BaseThreadPoolExecutor(2, 4, 1L, TimeUnit.SECONDS, new ArrayBlockingQueue(2));
            try {
                baseThreadPoolExecutor.execute(new a());
            } catch (Throwable th6) {
                th5 = th6;
                try {
                    th5.printStackTrace();
                } finally {
                    baseThreadPoolExecutor.shutdown();
                }
            }
        } catch (Throwable th7) {
            baseThreadPoolExecutor = null;
            th5 = th7;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d() {
        Context a16 = org.extra.tools.a.a();
        if (a16 == null) {
            f423589a.set(b.Unreported);
            return;
        }
        String SDKVersion = PAG.SDKVersion();
        if (TextUtils.isEmpty(SDKVersion)) {
            f423589a.set(b.Unreported);
            return;
        }
        SharedPreferences sharedPreferences = a16.getSharedPreferences("pag_reporter", 0);
        String str = "";
        String string = sharedPreferences.getString("last_pag_version", "");
        String string2 = sharedPreferences.getString("pag_report_time", "");
        String b16 = b();
        if (SDKVersion.equals(string) && b16.equals(string2)) {
            f423589a.set(b.Reported);
            return;
        }
        String packageName = a16.getPackageName();
        if (TextUtils.isEmpty(packageName)) {
            f423589a.set(b.Unreported);
            return;
        }
        PackageManager packageManager = a16.getPackageManager();
        try {
            str = InstalledAppListMonitor.getPackageInfo(packageManager, packageName, 0).applicationInfo.loadLabel(packageManager).toString();
        } catch (Throwable unused) {
        }
        if (packageManager.checkPermission(SLAReporter.PERMISSION_NET, packageName) != 0) {
            f423589a.set(b.Unreported);
        } else {
            if (a(SDKVersion, str, packageName, string)) {
                sharedPreferences.edit().putString("last_pag_version", SDKVersion).apply();
                sharedPreferences.edit().putString("pag_report_time", b16).apply();
                f423589a.set(b.Reported);
                return;
            }
            f423589a.set(b.Unreported);
        }
    }

    private static boolean a(String str, String str2, String str3, String str4) {
        boolean z16 = false;
        try {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL("https://otheve.beacon.qq.com/analytics/v2_upload").openConnection();
            httpsURLConnection.setConnectTimeout(2000);
            httpsURLConnection.setReadTimeout(5000);
            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.setRequestMethod("POST");
            httpsURLConnection.setRequestProperty("Content-Type", MediaType.APPLICATION_JSON_UTF8_VALUE);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpsURLConnection.getOutputStream(), "UTF-8");
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            bufferedWriter.write(b(str, str2, str3, str4));
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStreamWriter.close();
            httpsURLConnection.connect();
            if (httpsURLConnection.getResponseCode() == 200) {
                StringBuilder sb5 = new StringBuilder();
                InputStreamReader inputStreamReader = new InputStreamReader(httpsURLConnection.getInputStream(), "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb5.append(readLine);
                }
                bufferedReader.close();
                inputStreamReader.close();
                if (new JSONObject(sb5.toString()).optInt("result") == 200) {
                    z16 = true;
                }
            }
            httpsURLConnection.disconnect();
        } catch (Throwable unused) {
        }
        return z16;
    }

    private static String b(String str, String str2, String str3, String str4) {
        return "{\"appVersion\":\"\",\"sdkId\":\"pag_enterprise\",\"sdkVersion\":\"" + str + "\",\"mainAppKey\":\"0DOU0K0WD05SLYU3\",\"platformId\":\"\",\"common\":{\"A2\":\"pag_sdk_report\"},\"events\":[{\"eventCode\":\"pag_sdk_report\",\"eventTime\":\"" + System.currentTimeMillis() + "\",\"mapValue\":{\"appName\":\"" + str2 + "\",\"appID\":\"" + str3 + "\",\"appPlatform\":\"Android\",\"previousSDKVersion\":\"" + str4 + "\",\"authType\":\"" + authName() + "\"}}]}";
    }
}
