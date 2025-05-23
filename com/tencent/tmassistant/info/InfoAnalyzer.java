package com.tencent.tmassistant.info;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.tmassistant.common.jce.AppDataReportConfig;
import com.tencent.tmassistant.common.jce.AppExtInfoParam;
import com.tencent.tmassistant.common.jce.SDKDataReportRequest;
import com.tencent.tmassistant.info.SDKDataReportEngine;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.Settings;
import com.tencent.tmassistantbase.util.e;
import com.tencent.tmassistantbase.util.g;
import com.tencent.tmassistantbase.util.h;
import com.tencent.tmassistantbase.util.l;
import com.tencent.tmassistantbase.util.r;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public class InfoAnalyzer implements SDKDataReportEngine.Callback {

    /* renamed from: g, reason: collision with root package name */
    private static volatile InfoAnalyzer f380379g;

    /* renamed from: a, reason: collision with root package name */
    private PackageManager f380380a;

    /* renamed from: b, reason: collision with root package name */
    private SDKDataReportEngine f380381b;

    /* renamed from: d, reason: collision with root package name */
    private String f380383d;

    /* renamed from: c, reason: collision with root package name */
    private long f380382c = 0;

    /* renamed from: e, reason: collision with root package name */
    private int f380384e = 0;

    /* renamed from: f, reason: collision with root package name */
    private boolean f380385f = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AppDataReportConfig f380386a;

        a(AppDataReportConfig appDataReportConfig) {
            this.f380386a = appDataReportConfig;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                LockMethodProxy.sleep(((int) ((System.currentTimeMillis() % 5) + 5)) * 1000);
            } catch (InterruptedException e16) {
                e16.printStackTrace();
            }
            try {
                InfoAnalyzer.this.a(this.f380386a);
            } catch (Throwable unused) {
                InfoAnalyzer.this.f380385f = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        String f380388a;

        /* renamed from: b, reason: collision with root package name */
        byte f380389b;

        /* renamed from: c, reason: collision with root package name */
        long f380390c;

        /* renamed from: d, reason: collision with root package name */
        String f380391d;

        /* renamed from: e, reason: collision with root package name */
        long f380392e;

        /* renamed from: f, reason: collision with root package name */
        String f380393f;

        /* renamed from: g, reason: collision with root package name */
        long f380394g;

        /* renamed from: h, reason: collision with root package name */
        long f380395h;

        /* renamed from: i, reason: collision with root package name */
        int f380396i;

        /* renamed from: j, reason: collision with root package name */
        String f380397j;

        b() {
        }

        public String toString() {
            int i3;
            StringBuilder sb5 = new StringBuilder();
            sb5.append((int) this.f380389b);
            sb5.append("|");
            sb5.append(this.f380388a);
            if (this.f380390c != 0) {
                sb5.append("|" + this.f380390c);
                i3 = 1;
            } else {
                i3 = 0;
            }
            if (!TextUtils.isEmpty(this.f380391d)) {
                i3 |= 2;
                sb5.append("|" + this.f380391d);
            }
            if (this.f380392e != 0) {
                i3 |= 4;
                sb5.append("|" + (this.f380392e / 1000));
            }
            if (!TextUtils.isEmpty(this.f380393f)) {
                i3 |= 8;
                sb5.append("|" + this.f380393f);
            }
            if (this.f380394g != 0) {
                i3 |= 16;
                sb5.append("|" + (this.f380394g / 1000) + "_" + (this.f380395h / 1000));
            }
            if (this.f380396i != 0) {
                i3 |= 32;
                sb5.append("|" + this.f380396i);
            }
            if (!TextUtils.isEmpty(this.f380397j)) {
                i3 |= 64;
                sb5.append("|" + this.f380397j);
            }
            sb5.append(";");
            return i3 + "|" + sb5.toString();
        }

        /* synthetic */ b(a aVar) {
            this();
        }
    }

    InfoAnalyzer() {
        this.f380383d = "";
        SDKDataReportEngine sDKDataReportEngine = new SDKDataReportEngine();
        this.f380381b = sDKDataReportEngine;
        sDKDataReportEngine.a(this);
        try {
            Context applicationContext = GlobalUtil.getInstance().getContext().getApplicationContext();
            this.f380380a = applicationContext.getPackageManager();
            this.f380383d = applicationContext.getExternalCacheDir().getParent();
            this.f380383d = new File(this.f380383d).getParent();
        } catch (Throwable unused) {
        }
    }

    public static InfoAnalyzer b() {
        if (f380379g == null) {
            synchronized (InfoAnalyzer.class) {
                if (f380379g == null) {
                    f380379g = new InfoAnalyzer();
                }
            }
        }
        return f380379g;
    }

    private String c(String str) {
        try {
            return g.c(InstalledAppListMonitor.getPackageInfo(this.f380380a, str, 64).signatures[0].toByteArray()).toLowerCase();
        } catch (PackageManager.NameNotFoundException e16) {
            e16.printStackTrace();
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AppDataReportConfig appDataReportConfig) {
        this.f380385f = true;
        long currentTimeMillis = System.currentTimeMillis();
        this.f380384e = 0;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList<String> arrayList6 = new ArrayList();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        System.currentTimeMillis();
        System.currentTimeMillis();
        ArrayList<String> a16 = a(arrayList5);
        for (String str : arrayList6) {
            ApplicationInfo applicationInfo = (ApplicationInfo) hashMap.get(str);
            AppExtInfoParam appExtInfoParam = (AppExtInfoParam) hashMap2.get(str);
            PackageInfo packageInfo = (PackageInfo) hashMap3.get(str);
            if (a16.contains(a(str))) {
                arrayList3.add(a((byte) 2, appExtInfoParam, applicationInfo, packageInfo));
            } else {
                arrayList2.add(a((byte) 1, appExtInfoParam, applicationInfo, packageInfo));
            }
        }
        System.currentTimeMillis();
        arrayList.addAll(arrayList2);
        arrayList.addAll(arrayList3);
        arrayList.addAll(arrayList4);
        StringBuilder sb5 = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            sb5.append(((b) it.next()).toString());
        }
        System.currentTimeMillis();
        SDKDataReportRequest sDKDataReportRequest = new SDKDataReportRequest();
        sDKDataReportRequest.appData = sb5.toString();
        sDKDataReportRequest.timeCost = System.currentTimeMillis() - currentTimeMillis;
        sDKDataReportRequest.uin = GlobalUtil.getUin();
        sDKDataReportRequest.qimei = GlobalUtil.getInstance().getQimei();
        sDKDataReportRequest.qadid = GlobalUtil.getInstance().getQadid();
        this.f380385f = this.f380381b.a(sDKDataReportRequest);
        System.currentTimeMillis();
    }

    public void b(AppDataReportConfig appDataReportConfig) {
        if (!h.a(GlobalUtil.getInstance().getContext())) {
            r.b("InfoAnalyzer_", "[begin] no available network!");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f380382c < 60000) {
            r.b("InfoAnalyzer_", "[begin] < 60 * 1000");
            return;
        }
        this.f380382c = currentTimeMillis;
        if (this.f380385f) {
            r.b("InfoAnalyzer_", "[begin] analyzing ");
            return;
        }
        int b16 = b(appDataReportConfig.frequency);
        r.b("InfoAnalyzer_", "[begin] ret=" + b16 + ",cfg.fre=" + appDataReportConfig.frequency + ",today succeed.times=" + Settings.getInstance().getInt("analysis_succ_times"));
        if (b16 == 0) {
            BaseThread baseThread = new BaseThread(new a(appDataReportConfig), e.b.f380465c.toString());
            baseThread.setPriority(1);
            baseThread.start();
        }
    }

    private String b(String str) {
        String a16 = g.a(str);
        return TextUtils.isEmpty(a16) ? "" : a16.toLowerCase();
    }

    private int b(int i3) {
        int i16;
        if (!l.e()) {
            return -1;
        }
        if (i3 == 0) {
            return -2;
        }
        String currentDay = GlobalUtil.getCurrentDay();
        if (!currentDay.equals(Settings.getInstance().getString("analysis_last_ana_day"))) {
            Settings.getInstance().setString("analysis_last_ana_day", currentDay);
            Settings.getInstance().setInt("analysis_succ_times", 0);
            i16 = 0;
        } else {
            i16 = Settings.getInstance().getInt("analysis_succ_times");
        }
        return i16 >= i3 ? -3 : 0;
    }

    private ArrayList<String> a(List<String> list) {
        ArrayList<String> arrayList = new ArrayList<>();
        HashMap hashMap = new HashMap();
        if (list != null && list.size() != 0) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                String a16 = a(it.next());
                if (hashMap.containsKey(a16)) {
                    hashMap.put(a16, Integer.valueOf(((Integer) hashMap.get(a16)).intValue() + 1));
                } else {
                    hashMap.put(a16, 1);
                }
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                if (((Integer) entry.getValue()).intValue() >= 7) {
                    arrayList.add((String) entry.getKey());
                }
            }
        }
        return arrayList;
    }

    private String a(String str) {
        int indexOf;
        int indexOf2;
        return (TextUtils.isEmpty(str) || (indexOf = str.indexOf(".")) == -1 || (indexOf2 = str.indexOf(".", indexOf + 1)) == -1) ? str : str.substring(0, indexOf2);
    }

    private b a(byte b16, AppExtInfoParam appExtInfoParam, ApplicationInfo applicationInfo, PackageInfo packageInfo) {
        System.currentTimeMillis();
        b bVar = new b(null);
        bVar.f380388a = packageInfo.packageName;
        bVar.f380389b = b16;
        if (appExtInfoParam == null) {
            return bVar;
        }
        System.currentTimeMillis();
        int i3 = appExtInfoParam.flag;
        File file = new File(applicationInfo.sourceDir);
        if ((i3 & 1) != 0) {
            bVar.f380390c = file.length();
        }
        System.currentTimeMillis();
        if ((i3 & 2) != 0) {
            bVar.f380391d = c(applicationInfo.packageName);
        }
        System.currentTimeMillis();
        if ((i3 & 4) != 0) {
            bVar.f380392e = a(applicationInfo.packageName, appExtInfoParam.oftenUsedPath);
        }
        System.currentTimeMillis();
        if ((i3 & 8) != 0) {
            bVar.f380393f = b(applicationInfo.sourceDir);
        }
        System.currentTimeMillis();
        if ((i3 & 16) != 0) {
            bVar.f380394g = packageInfo.firstInstallTime;
            bVar.f380395h = packageInfo.lastUpdateTime;
        }
        if ((i3 & 32) != 0) {
            bVar.f380396i = packageInfo.versionCode;
        }
        System.currentTimeMillis();
        if ((i3 & 64) != 0) {
            bVar.f380397j = AnalysisUtil.a(packageInfo.packageName, appExtInfoParam.targetFileNameList);
        }
        System.currentTimeMillis();
        this.f380384e++;
        return bVar;
    }

    private long a(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str2)) {
            str3 = this.f380383d + File.separator + str;
        } else {
            str3 = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + str2;
        }
        return AnalysisUtil.a(new File(str3));
    }

    @Override // com.tencent.tmassistant.info.SDKDataReportEngine.Callback
    public void a(int i3) {
        r.b("InfoAnalyzer_", "requestFailed errorCode=" + i3);
        this.f380385f = false;
    }

    @Override // com.tencent.tmassistant.info.SDKDataReportEngine.Callback
    public void a() {
        r.b("InfoAnalyzer_", "requestSucceed");
        Settings.getInstance().setInt("analysis_succ_times", Settings.getInstance().getInt("analysis_succ_times") + 1);
        this.f380385f = false;
    }
}
