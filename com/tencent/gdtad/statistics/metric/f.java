package com.tencent.gdtad.statistics.metric;

import android.os.Build;
import com.tencent.ams.monitor.metric.j;
import com.tencent.ams.monitor.metric.l;
import com.tencent.ams.monitor.metric.m;
import com.tencent.gdtad.qqproxy.GdtVersionUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes6.dex */
final class f implements l {

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.gdtad.config.data.f f109505a = b.b().a();

    /* renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<String, String> f109506b;

    /* renamed from: c, reason: collision with root package name */
    private j f109507c;

    /* renamed from: d, reason: collision with root package name */
    private m f109508d;

    public f() {
        String str;
        QLog.i("GdtMetricServiceConfig", 1, "[constructor] mConfig:" + this.f109505a);
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        this.f109506b = concurrentHashMap;
        concurrentHashMap.put("appVersion", GdtVersionUtil.getQQVersion());
        this.f109506b.put("brand", Build.BRAND);
        this.f109506b.put("os", "Android");
        this.f109506b.put("osVersion", Build.VERSION.RELEASE);
        ConcurrentHashMap<String, String> concurrentHashMap2 = this.f109506b;
        if (BaseApplication.getContext() != null) {
            str = BaseApplication.getContext().getPackageName();
        } else {
            str = null;
        }
        concurrentHashMap2.put("packageName", str);
        this.f109507c = new c();
        this.f109508d = new GdtMetricThreadManagerAdapter();
    }

    @Override // com.tencent.ams.monitor.metric.l
    public l cloneDeeply() {
        f fVar = new f();
        fVar.f109505a = this.f109505a;
        fVar.f109506b = this.f109506b;
        fVar.f109507c = this.f109507c;
        fVar.f109508d = this.f109508d;
        return fVar;
    }

    @Override // com.tencent.ams.monitor.metric.l
    public int getBusinessType() {
        return 2;
    }

    @Override // com.tencent.ams.monitor.metric.l
    public ConcurrentHashMap<String, String> getCommonTagSets() {
        return this.f109506b;
    }

    @Override // com.tencent.ams.monitor.metric.l
    public int getCountThreshold() {
        com.tencent.gdtad.config.data.f fVar = this.f109505a;
        if (fVar != null) {
            return fVar.countThreshold;
        }
        return 0;
    }

    @Override // com.tencent.ams.monitor.metric.l
    public long getIntervalMillisThreshold() {
        com.tencent.gdtad.config.data.f fVar = this.f109505a;
        if (fVar != null) {
            return fVar.intervalMillisThreshold;
        }
        return 0L;
    }

    @Override // com.tencent.ams.monitor.metric.l
    public int getMaxCount() {
        com.tencent.gdtad.config.data.f fVar = this.f109505a;
        if (fVar != null) {
            return fVar.maxCount;
        }
        return 0;
    }

    @Override // com.tencent.ams.monitor.metric.l
    public String getUrl() {
        com.tencent.gdtad.config.data.f fVar = this.f109505a;
        if (fVar != null) {
            return fVar.url;
        }
        return null;
    }

    @Override // com.tencent.ams.monitor.metric.l
    public WeakReference<j> getWeakLogAdapter() {
        return new WeakReference<>(this.f109507c);
    }

    @Override // com.tencent.ams.monitor.metric.l
    public WeakReference<m> getWeakThreadManagerAdapter() {
        return new WeakReference<>(this.f109508d);
    }
}
