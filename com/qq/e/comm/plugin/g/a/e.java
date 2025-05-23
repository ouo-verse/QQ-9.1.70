package com.qq.e.comm.plugin.g.a;

import android.os.Build;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.util.StringUtil;
import com.tencent.ams.dsdk.monitor.metric.core.MetricReportConfig;
import com.tencent.ams.monitor.metric.j;
import com.tencent.ams.monitor.metric.l;
import com.tencent.ams.monitor.metric.m;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class e implements l {

    /* renamed from: e, reason: collision with root package name */
    private ConcurrentHashMap<String, String> f39399e = c();

    /* renamed from: a, reason: collision with root package name */
    private final String f39395a = d();

    /* renamed from: b, reason: collision with root package name */
    private final int f39396b = e();

    /* renamed from: c, reason: collision with root package name */
    private final int f39397c = a();

    /* renamed from: d, reason: collision with root package name */
    private final long f39398d = b();

    /* renamed from: f, reason: collision with root package name */
    private j f39400f = new b();

    /* renamed from: g, reason: collision with root package name */
    private m f39401g = new f();

    private ConcurrentHashMap<String, String> c() {
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("appId", GDTADManager.getInstance().getAppStatus().getAPPID());
        concurrentHashMap.put("packageName", GDTADManager.getInstance().getAppStatus().getAPPName());
        concurrentHashMap.put("appVersion", GDTADManager.getInstance().getAppStatus().getAPPVersion());
        concurrentHashMap.put("sdkVersion", SDKStatus.getSDKBuildVersion());
        concurrentHashMap.put("os", "android");
        concurrentHashMap.put("osVersion", Build.VERSION.RELEASE);
        concurrentHashMap.put("brand", Build.BRAND);
        return concurrentHashMap;
    }

    private String d() {
        String str;
        if (f()) {
            str = MetricReportConfig.METRIC_REPORTER_TEST_URL;
        } else {
            str = MetricReportConfig.METRIC_REPORTER_PRODUCT_URL;
        }
        return com.qq.e.comm.plugin.j.c.a((String) null, "metricReporterUrl", str);
    }

    private int e() {
        return com.qq.e.comm.plugin.j.c.a("mrMaxCount", 10000);
    }

    private static boolean f() {
        return false;
    }

    public int a() {
        return com.qq.e.comm.plugin.j.c.a("mrCountThreshold", 10);
    }

    public long b() {
        return com.qq.e.comm.plugin.j.c.a("mrIntervalMillisThreshold", 60000L);
    }

    @Override // com.tencent.ams.monitor.metric.l
    public l cloneDeeply() {
        e eVar = new e();
        eVar.f39399e = new ConcurrentHashMap<>(this.f39399e);
        eVar.f39400f = this.f39400f;
        eVar.f39401g = this.f39401g;
        return eVar;
    }

    @Override // com.tencent.ams.monitor.metric.l
    public int getBusinessType() {
        return 3;
    }

    @Override // com.tencent.ams.monitor.metric.l
    public ConcurrentHashMap<String, String> getCommonTagSets() {
        return this.f39399e;
    }

    @Override // com.tencent.ams.monitor.metric.l
    public int getCountThreshold() {
        return this.f39397c;
    }

    @Override // com.tencent.ams.monitor.metric.l
    public long getIntervalMillisThreshold() {
        return this.f39398d;
    }

    @Override // com.tencent.ams.monitor.metric.l
    public int getMaxCount() {
        return this.f39396b;
    }

    @Override // com.tencent.ams.monitor.metric.l
    public String getUrl() {
        return this.f39395a;
    }

    @Override // com.tencent.ams.monitor.metric.l
    public WeakReference<j> getWeakLogAdapter() {
        return new WeakReference<>(this.f39400f);
    }

    @Override // com.tencent.ams.monitor.metric.l
    public WeakReference<m> getWeakThreadManagerAdapter() {
        return new WeakReference<>(this.f39401g);
    }

    public String toString() {
        return "MetricServiceConfig{url=" + StringUtil.safeString(getUrl()) + ", maxCount=" + getMaxCount() + ", countThreshold=" + getCountThreshold() + ", intervalMillisThreshold=" + getIntervalMillisThreshold() + '}';
    }
}
