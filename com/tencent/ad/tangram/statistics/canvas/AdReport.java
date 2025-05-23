package com.tencent.ad.tangram.statistics.canvas;

import android.content.Context;
import android.support.annotation.Nullable;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.views.canvas.components.appbutton.AdAppBtnData;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class AdReport {
    private static final String TAG = "AdReport";
    private static volatile AdReport sInstance;
    private WeakReference<AdReportAdapter> adapter;

    AdReport() {
    }

    @Nullable
    private AdReportAdapter getAdapter() {
        WeakReference<AdReportAdapter> weakReference = this.adapter;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public static AdReport getInstance() {
        if (sInstance == null) {
            synchronized (AdReport.class) {
                if (sInstance == null) {
                    sInstance = new AdReport();
                }
            }
        }
        return sInstance;
    }

    public void downloadReport(Ad ad5, String str, int i3, boolean z16, AdAppBtnData adAppBtnData) {
        AdReportAdapter adapter = getAdapter();
        if (adapter != null) {
            adapter.downloadReport(ad5, str, i3, z16, adAppBtnData);
        }
    }

    @Nullable
    public AdRefreshCallback getAdReportAdapter() {
        AdReportAdapter adapter = getAdapter();
        if (adapter != null) {
            return adapter.getAdReportAdapter();
        }
        return null;
    }

    public void reportForCanvasDataBuildEnd(Context context, Ad ad5, long j3) {
        AdReportAdapter adapter = getAdapter();
        if (adapter != null) {
            adapter.reportForCanvasDataBuildEnd(context, ad5, j3);
        }
    }

    public void reportForCanvasDataBuildError(Context context, int i3, Ad ad5, String str) {
        AdReportAdapter adapter = getAdapter();
        if (adapter != null) {
            adapter.reportForCanvasDataBuildError(context, i3, ad5, str);
        }
    }

    public void setAdapter(WeakReference<AdReportAdapter> weakReference) {
        this.adapter = weakReference;
    }
}
