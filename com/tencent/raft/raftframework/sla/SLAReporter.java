package com.tencent.raft.raftframework.sla;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.util.Pair;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqmini.sdk.task.MiniAppSoLoader;
import com.tencent.raft.raftframework.log.RLog;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes25.dex */
public class SLAReporter {
    static IPatchRedirector $redirector_ = null;
    public static final int GROUP_ID_MUST_REPORT = -1;
    public static final String PERMISSION_NET = "android.permission.INTERNET";
    public static final double REPORT_NS_MS = 1000000.0d;
    public static final String TAG = "SLAReporter";
    private StringBuilder baseURL;

    @Nullable
    private Context context;
    private ExecutorService executor;
    private long frameworkStartupNs;
    private int groupId;
    private boolean isInit;
    private boolean open;

    public SLAReporter(@Nullable Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.isInit = false;
        this.groupId = 1;
        this.executor = ProxyExecutors.newFixedThreadPool(3);
        this.open = false;
        if (isContextValidate(context)) {
            this.context = context;
        }
    }

    private int applyForGroupId() {
        int i3 = this.groupId;
        this.groupId = i3 + 1;
        return i3;
    }

    private String getApplicationName(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            return (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 0));
        } catch (Exception e16) {
            RLog.w(TAG, "getApplicationName error: " + e16);
            return "";
        }
    }

    private SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences("raft_config", 0);
    }

    private synchronized String getUrl(String str, String str2) {
        return ((Object) this.baseURL) + "&event_name=" + str + "&event_value=" + str2;
    }

    private boolean hasInternetPermission() {
        Context context = this.context;
        if (context == null || context.checkSelfPermission(PERMISSION_NET) != 0) {
            return false;
        }
        return true;
    }

    private void initBuglyReport(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("BuglySdkInfos", 0).edit();
        edit.putString("a321c41aa2", MiniAppSoLoader.LOCAL_ENGINE_VERSION);
        edit.apply();
    }

    private synchronized void initIfNeeded() {
        if (this.isInit) {
            return;
        }
        StringBuilder sb5 = new StringBuilder("https://h.trace.qq.com/kv");
        this.baseURL = sb5;
        sb5.append("?attaid=");
        sb5.append("0c500034918");
        StringBuilder sb6 = this.baseURL;
        sb6.append("&token=");
        sb6.append("4483379541");
        this.baseURL.append("&client_type=android");
        this.isInit = true;
    }

    private boolean isContextValidate(Context context) {
        if (context != null && getSharedPreferences(context) != null) {
            return true;
        }
        return false;
    }

    private void report(String str, String str2) {
        report(str, str2, -1);
    }

    private void reportAppInfo(Context context) {
        SharedPreferences sharedPreferences = getSharedPreferences(context);
        if (sharedPreferences.getBoolean("app_sla_report", false)) {
            return;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putBoolean("app_sla_report", true);
        edit.apply();
        ArrayList arrayList = new ArrayList();
        arrayList.add(Pair.create("app_name", getApplicationName(context)));
        arrayList.add(Pair.create("app_bundle_id", context.getPackageName()));
        report(arrayList);
    }

    private void reportInner(String str) {
        this.executor.submit(new Runnable(str) { // from class: com.tencent.raft.raftframework.sla.SLAReporter.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String val$path;

            {
                this.val$path = str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) SLAReporter.this, (Object) str);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.val$path).openConnection();
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.setRequestMethod("GET");
                    RLog.d(SLAReporter.TAG, "report code: " + httpURLConnection.getResponseCode() + ", path: " + this.val$path);
                } catch (Exception e16) {
                    RLog.w(SLAReporter.TAG, "report error: " + e16 + ", path: " + this.val$path);
                }
            }
        });
    }

    public void open(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
            return;
        }
        this.open = z16;
        if (!hasInternetPermission()) {
            z16 = false;
        }
        RLog.d(TAG, "set open: " + z16 + " ,real: " + this.open);
    }

    public void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.executor.shutdown();
            this.context = null;
        }
    }

    public void reportGetServiceFinish(long j3, boolean z16) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Long.valueOf(j3), Boolean.valueOf(z16));
            return;
        }
        if (!this.open) {
            return;
        }
        int applyForGroupId = applyForGroupId();
        report("get_service_cost", String.valueOf((System.nanoTime() - j3) / 1000000.0d), applyForGroupId);
        if (z16) {
            str = "1";
        } else {
            str = "0";
        }
        report("get_service_success", str, applyForGroupId);
    }

    public void reportOnFrameworkStartup() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (!this.open) {
            return;
        }
        this.frameworkStartupNs = System.nanoTime();
        Context context = this.context;
        if (context != null) {
            initBuglyReport(context);
        }
    }

    public void reportOnFrameworkStartupFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (!this.open) {
            return;
        }
        Context context = this.context;
        if (context != null) {
            reportAppInfo(context);
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Pair.create("app_name", "RAFTAndroid"));
            arrayList.add(Pair.create("app_bundle_id", "com.tencent.raft"));
            report(arrayList);
        }
        report("launch_cost", String.valueOf((System.nanoTime() - this.frameworkStartupNs) / 1000000.0d));
        report("launch_success", "1");
    }

    private synchronized String getUrl(List<Pair<String, String>> list) {
        StringBuilder sb5;
        sb5 = new StringBuilder(this.baseURL);
        for (Pair<String, String> pair : list) {
            sb5.append(ContainerUtils.FIELD_DELIMITER);
            sb5.append((String) pair.first);
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append((String) pair.second);
        }
        return sb5.toString();
    }

    private void report(List<Pair<String, String>> list) {
        report(list, -1);
    }

    private void report(String str, String str2, int i3) {
        if (i3 == -1 || i3 % 100 == 1) {
            initIfNeeded();
            reportInner(getUrl(str, str2));
        }
    }

    private void report(List<Pair<String, String>> list, int i3) {
        if (i3 == -1 || i3 % 100 == 1) {
            initIfNeeded();
            reportInner(getUrl(list));
        }
    }
}
