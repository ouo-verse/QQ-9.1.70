package com.tencent.gdtad.adapter;

import android.content.Context;
import com.tencent.ad.tangram.statistics.metric.IAdMetric;
import com.tencent.ad.tangram.statistics.metric.IAdMetricServiceAdapter;
import java.lang.ref.WeakReference;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class k implements IAdMetricServiceAdapter {
    @Override // com.tencent.ad.tangram.statistics.metric.IAdMetricServiceAdapter
    public IAdMetric build(long j3) {
        return new com.tencent.gdtad.statistics.metric.a(j3);
    }

    @Override // com.tencent.ad.tangram.statistics.metric.IAdMetricServiceAdapter
    public void flush(WeakReference<Context> weakReference) {
        com.tencent.gdtad.statistics.metric.e.b().a(weakReference);
    }

    @Override // com.tencent.ad.tangram.statistics.metric.IAdMetricServiceAdapter
    public void handle(WeakReference<Context> weakReference, CopyOnWriteArrayList<IAdMetric> copyOnWriteArrayList) {
        com.tencent.gdtad.statistics.metric.e.b().c(weakReference, copyOnWriteArrayList);
    }

    @Override // com.tencent.ad.tangram.statistics.metric.IAdMetricServiceAdapter
    public void setReportEnabled(WeakReference<Context> weakReference, boolean z16) {
        com.tencent.gdtad.statistics.metric.e.b().d(weakReference, z16);
    }
}
