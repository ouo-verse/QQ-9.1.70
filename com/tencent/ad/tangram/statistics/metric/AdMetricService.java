package com.tencent.ad.tangram.statistics.metric;

import android.content.Context;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.log.AdLog;
import java.lang.ref.WeakReference;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdMetricService {
    private static final String TAG = "AdMetricService";
    private static volatile AdMetricService sInstance;
    private WeakReference<IAdMetricServiceAdapter> mWeakAdapter;

    AdMetricService() {
    }

    private IAdMetricServiceAdapter getAdapter() {
        WeakReference<IAdMetricServiceAdapter> weakReference = this.mWeakAdapter;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public static AdMetricService getInstance() {
        if (sInstance == null) {
            synchronized (AdMetricService.class) {
                if (sInstance == null) {
                    sInstance = new AdMetricService();
                }
            }
        }
        return sInstance;
    }

    public IAdMetric build(long j3) {
        IAdMetricServiceAdapter adapter = getAdapter();
        if (adapter == null) {
            AdLog.e(TAG, "[build] error, adapter is null, id:" + j3);
            return new AdMetricDefault();
        }
        IAdMetric build = adapter.build(j3);
        if (build == null) {
            AdLog.e(TAG, "[build] error, metric is null, id:" + j3);
            return new AdMetricDefault();
        }
        return build;
    }

    public void flush(WeakReference<Context> weakReference) {
        IAdMetricServiceAdapter adapter = getAdapter();
        if (adapter == null) {
            AdLog.e(TAG, "[flush] do nothing, adapter is null");
        } else {
            adapter.flush(weakReference);
        }
    }

    public void handle(WeakReference<Context> weakReference, IAdMetric iAdMetric) {
        CopyOnWriteArrayList<IAdMetric> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList.add(iAdMetric);
        handle(weakReference, copyOnWriteArrayList);
    }

    public void setAdapter(WeakReference<IAdMetricServiceAdapter> weakReference) {
        this.mWeakAdapter = weakReference;
    }

    public void setReportEnabled(WeakReference<Context> weakReference, boolean z16) {
        IAdMetricServiceAdapter adapter = getAdapter();
        if (adapter == null) {
            AdLog.e(TAG, "[setReportEnabled] do nothing, adapter is null, enabled:" + z16);
            return;
        }
        adapter.setReportEnabled(weakReference, z16);
    }

    public void handle(WeakReference<Context> weakReference, CopyOnWriteArrayList<IAdMetric> copyOnWriteArrayList) {
        IAdMetricServiceAdapter adapter = getAdapter();
        if (adapter == null) {
            AdLog.e(TAG, "[handle] do nothing, adapter is null");
        } else {
            adapter.handle(weakReference, copyOnWriteArrayList);
        }
    }
}
