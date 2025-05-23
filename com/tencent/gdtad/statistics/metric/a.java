package com.tencent.gdtad.statistics.metric;

import android.text.TextUtils;
import com.tencent.ad.tangram.statistics.metric.IAdMetric;
import com.tencent.ams.monitor.metric.i;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class a implements i, IAdMetric {

    /* renamed from: a, reason: collision with root package name */
    private long f109496a;

    /* renamed from: b, reason: collision with root package name */
    private long f109497b;

    /* renamed from: c, reason: collision with root package name */
    private double f109498c = 1.0d;

    /* renamed from: d, reason: collision with root package name */
    private ConcurrentHashMap<String, String> f109499d = new ConcurrentHashMap<>();

    /* renamed from: e, reason: collision with root package name */
    private boolean f109500e = true;

    public a(long j3) {
        this.f109496a = 0L;
        this.f109497b = 0L;
        this.f109496a = j3;
        this.f109497b = System.currentTimeMillis();
    }

    @Override // com.tencent.ad.tangram.statistics.metric.IAdMetric
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public a setEnabled(boolean z16) {
        this.f109500e = z16;
        return this;
    }

    @Override // com.tencent.ad.tangram.statistics.metric.IAdMetric
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a setTagSet(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.f109499d.put(str, str2);
        }
        return this;
    }

    @Override // com.tencent.ad.tangram.statistics.metric.IAdMetric
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public a setValue(double d16) {
        this.f109498c = d16;
        return this;
    }

    @Override // com.tencent.ams.monitor.metric.i
    public long getId() {
        return this.f109496a;
    }

    @Override // com.tencent.ams.monitor.metric.i
    public ConcurrentHashMap<String, String> getTagSets() {
        return this.f109499d;
    }

    @Override // com.tencent.ams.monitor.metric.i
    public long getTimeMillis() {
        return this.f109497b;
    }

    @Override // com.tencent.ams.monitor.metric.i
    public double getValue() {
        return this.f109498c;
    }

    @Override // com.tencent.ad.tangram.statistics.metric.IAdMetric
    public boolean isEnabled() {
        return this.f109500e;
    }
}
