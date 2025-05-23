package com.qq.e.tg.splash.adapter;

import com.qq.e.comm.util.GDTLogger;
import com.qq.e.tg.splash.adapter.AdFlowReportAdapter;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AdFlowReporter {

    /* renamed from: a, reason: collision with root package name */
    private static volatile AdFlowReporter f40827a;

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<AdFlowReportAdapter> f40828b;

    AdFlowReporter() {
    }

    public static AdFlowReporter getInstance() {
        if (f40827a == null) {
            synchronized (AdFlowReporter.class) {
                if (f40827a == null) {
                    f40827a = new AdFlowReporter();
                }
            }
        }
        return f40827a;
    }

    public AdFlowReportAdapter getFlowReportAdapter() {
        WeakReference<AdFlowReportAdapter> weakReference = this.f40828b;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public void report(AdFlowReportAdapter.Params params) {
        if (params == null) {
            GDTLogger.e("AdFlowReporter report error , params is null.");
            return;
        }
        AdFlowReportAdapter flowReportAdapter = getFlowReportAdapter();
        if (flowReportAdapter == null) {
            GDTLogger.e("AdFlowReporter report error , adapter is null.");
            return;
        }
        GDTLogger.d("AdFlowReporter report :" + params.url + " size :" + params.flowAmount);
        flowReportAdapter.report(params);
    }

    public void setFlowReportAdapter(WeakReference<AdFlowReportAdapter> weakReference) {
        this.f40828b = weakReference;
    }
}
