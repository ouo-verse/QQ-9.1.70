package com.tencent.ad.tangram.statistics;

import android.content.Context;
import android.support.annotation.Nullable;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.json.AdJSON;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.protocol.link_report;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdReporterForLinkEvent {
    public static final String TAG = "AdReporterForLinkEvent";
    private static volatile AdReporterForLinkEvent sInstance;
    private WeakReference<Adapter> adapter;

    /* compiled from: P */
    @AdKeep
    /* loaded from: classes3.dex */
    public interface Adapter {
        void reportAsync(Context context, int i3, JSONObject jSONObject, JSONObject jSONObject2);
    }

    AdReporterForLinkEvent() {
    }

    @Nullable
    private Adapter getAdapter() {
        WeakReference<Adapter> weakReference = this.adapter;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public static AdReporterForLinkEvent getInstance() {
        if (sInstance == null) {
            synchronized (AdReporterForLinkEvent.class) {
                if (sInstance == null) {
                    sInstance = new AdReporterForLinkEvent();
                }
            }
        }
        return sInstance;
    }

    private void reportAsync(Context context, int i3, JSONObject jSONObject, JSONObject jSONObject2) {
        AdLog.i(TAG, String.format("reportAsync eventCode:%d", Integer.valueOf(i3)));
        Adapter adapter = getAdapter();
        if (adapter != null) {
            adapter.reportAsync(context, i3, jSONObject, jSONObject2);
        }
    }

    public void setAdapter(WeakReference<Adapter> weakReference) {
        this.adapter = weakReference;
    }

    public void reportAsync(Context context, int i3, @Nullable Ad ad5, @Nullable link_report.LinkReport.ReportBiz reportBiz, link_report.LinkReport.ReportExt reportExt) {
        if (ad5 != null) {
            if (reportBiz == null) {
                reportBiz = new link_report.LinkReport.ReportBiz();
            }
            reportBiz.aid = String.valueOf(ad5.getAId());
            reportBiz.pid = ad5.getPosId();
            reportBiz.traceid = ad5.getTraceId();
        }
        try {
            reportAsync(context, i3, (JSONObject) AdJSON.fromObject(reportBiz), (JSONObject) AdJSON.fromObject(reportExt));
        } catch (Throwable th5) {
            AdLog.e(TAG, "AdJSON fromObject", th5);
        }
    }
}
