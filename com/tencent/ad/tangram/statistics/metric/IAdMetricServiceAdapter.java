package com.tencent.ad.tangram.statistics.metric;

import android.content.Context;
import com.tencent.ad.tangram.annotation.AdKeep;
import java.lang.ref.WeakReference;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public interface IAdMetricServiceAdapter {
    IAdMetric build(long j3);

    void flush(WeakReference<Context> weakReference);

    void handle(WeakReference<Context> weakReference, CopyOnWriteArrayList<IAdMetric> copyOnWriteArrayList);

    void setReportEnabled(WeakReference<Context> weakReference, boolean z16);
}
