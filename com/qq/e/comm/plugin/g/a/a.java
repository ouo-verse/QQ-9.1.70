package com.qq.e.comm.plugin.g.a;

import android.text.TextUtils;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.ams.monitor.metric.i;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class a implements i {

    /* renamed from: a, reason: collision with root package name */
    private long f39384a;

    /* renamed from: b, reason: collision with root package name */
    private long f39385b;

    /* renamed from: c, reason: collision with root package name */
    private double f39386c = 1.0d;

    /* renamed from: d, reason: collision with root package name */
    private ConcurrentHashMap<String, String> f39387d = new ConcurrentHashMap<>();

    public a(long j3) {
        this.f39384a = 0L;
        this.f39385b = 0L;
        this.f39384a = j3;
        this.f39385b = System.currentTimeMillis();
    }

    public a a(double d16) {
        this.f39386c = d16;
        return this;
    }

    @Override // com.tencent.ams.monitor.metric.i
    public long getId() {
        return this.f39384a;
    }

    @Override // com.tencent.ams.monitor.metric.i
    public ConcurrentHashMap<String, String> getTagSets() {
        return this.f39387d;
    }

    @Override // com.tencent.ams.monitor.metric.i
    public long getTimeMillis() {
        return this.f39385b;
    }

    @Override // com.tencent.ams.monitor.metric.i
    public double getValue() {
        return this.f39386c;
    }

    public a a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.f39387d.put(str, str2);
        } else {
            GDTLogger.e("tagName and tagValue must not be null or empty");
        }
        return this;
    }
}
