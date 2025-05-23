package com.tencent.tavkit.report;

import android.util.Log;
import androidx.annotation.Nullable;
import com.tencent.tav.report.ReportBean;
import com.tencent.tav.report.ReportKey;
import com.tencent.tav.report.TAVReportCenter;
import com.tencent.tavkit.report.FilterChainReportSession;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class CompositingReportSession {
    private static final int FLUSH_DURATION_THRESHOLD = 10;
    private static final String REPORT_EVENT = "android_tavkit_compositing";
    public static final String REPORT_KEY_AVG_RENDER_TIME_US = "avg_render_time_us";
    private static final String REPORT_SERVICE = "TAVKit_Android";
    private static final String REPORT_VERSION = "3.4.5.130";
    private static final String TAG = "CompositingReportSessio";

    @Nullable
    private static IReporter reporter;
    private final FilterChainReporter filterChainReporter;
    private float renderHeight;
    private float renderWidth;
    private long beginTimeMs = 0;
    private int successCount = 0;
    private int failureCount = 0;
    private long totalCostUs = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static final class Bean extends ReportBean {

        @ReportKey(name = "ext_int1")
        private long avgRenderTimeUs;

        @ReportKey(name = "ext_int2")
        private long renderCount;

        @ReportKey(name = "ext_int4")
        private int renderHeight;

        @ReportKey(name = "ext_int3")
        private int renderWidth;

        public Bean() {
            super(CompositingReportSession.REPORT_SERVICE, CompositingReportSession.REPORT_EVENT, "3.4.5.130");
            this.avgRenderTimeUs = 0L;
            this.renderCount = 0L;
            this.renderWidth = 0;
            this.renderHeight = 0;
        }

        public Map<String, Long> toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put(CompositingReportSession.REPORT_KEY_AVG_RENDER_TIME_US, Long.valueOf(this.avgRenderTimeUs));
            return hashMap;
        }

        public String toString() {
            return "Bean{avgRenderTimeUs=" + this.avgRenderTimeUs + ", renderCount=" + this.renderCount + ", renderWidth=" + this.renderWidth + ", renderHeight=" + this.renderHeight + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class FilterChainReporter implements FilterChainReportSession.IReporter {
        private Map<String, Long> values;

        FilterChainReporter() {
            this.values = new HashMap();
        }

        @Override // com.tencent.tavkit.report.FilterChainReportSession.IReporter
        public void onCommit(Map<String, Long> map) {
            map.putAll(map);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface IReporter {
        void onCommit(Map<String, Long> map, Map<String, Long> map2);
    }

    public CompositingReportSession(float f16, float f17) {
        this.renderWidth = f16;
        this.renderHeight = f17;
        FilterChainReporter filterChainReporter = new FilterChainReporter();
        this.filterChainReporter = filterChainReporter;
        FilterChainReportSession.setReporter(filterChainReporter);
    }

    private void commit() {
        Bean bean = new Bean();
        bean.timestamp = Long.valueOf(this.beginTimeMs * 1000);
        bean.avgRenderTimeUs = this.totalCostUs / this.successCount;
        bean.renderCount = this.successCount;
        bean.renderHeight = (int) this.renderHeight;
        bean.renderWidth = (int) this.renderWidth;
        Log.d(TAG, "commit: bean = " + bean);
        TAVReportCenter.commit(bean);
        synchronized (CompositingReportSession.class) {
            IReporter iReporter = reporter;
            if (iReporter != null) {
                iReporter.onCommit(bean.toMap(), this.filterChainReporter.values);
            }
        }
    }

    private void reset() {
        this.beginTimeMs = 0L;
        this.totalCostUs = 0L;
        this.successCount = 0;
    }

    public static synchronized void setReporter(@Nullable IReporter iReporter) {
        synchronized (CompositingReportSession.class) {
            reporter = iReporter;
        }
    }

    public final void flush() {
        if (this.beginTimeMs == 0) {
            return;
        }
        if (this.successCount >= 10) {
            commit();
        }
        reset();
    }

    public void tickFailed() {
        this.failureCount++;
    }

    public final void tickSuccess(long j3) {
        if (this.beginTimeMs == 0) {
            this.beginTimeMs = System.currentTimeMillis() - ((j3 / 1000) / 1000);
        }
        this.successCount++;
        this.totalCostUs += j3 / 1000;
    }
}
