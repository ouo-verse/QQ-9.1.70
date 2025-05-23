package com.tencent.tav.report;

import android.util.Log;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class ReadFrameReportSession {
    private static final int FLUSH_DURATION_THRESHOLD = 10;
    private static final String TAG = "PreviewReportSession";
    private static final int TIME_CONS_LIMIT_US = 30000000;

    @Nullable
    private static IReporter reporter;
    private long beginTimeMs = 0;
    private final AverageCalculator averageCalculator = new AverageCalculator();
    private boolean success = true;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static final class Bean extends ReportBean {

        @ReportKey(name = "avg_read_time")
        private long avg_read_sample_time_us;

        @ReportKey(name = "read_sample_count")
        private long read_sample_count;

        @ReportKey(name = "success")
        public int success;

        public String toString() {
            return "Bean{success=" + this.success + ", avg_read_sample_time_us=" + this.avg_read_sample_time_us + ", read_sample_count=" + this.read_sample_count + '}';
        }

        Bean() {
            super("TAVFoundation", "tavkit_preview", "3.4.5.130");
            this.avg_read_sample_time_us = 0L;
            this.read_sample_count = 0L;
        }
    }

    private void commit() {
        Bean bean = new Bean();
        bean.timestamp = Long.valueOf(this.beginTimeMs * 1000);
        bean.avg_read_sample_time_us = this.averageCalculator.getAvg();
        bean.read_sample_count = this.averageCalculator.getCount();
        bean.success = this.success ? 1 : 0;
        Log.d(TAG, "commit: bean = " + bean);
        IReporter iReporter = reporter;
        if (iReporter != null) {
            iReporter.onReport(null, bean.extractReportData());
        }
        TAVReportCenter.commit(bean);
    }

    private void reset() {
        this.beginTimeMs = 0L;
        this.averageCalculator.reset();
    }

    public static void setReporter(@Nullable IReporter iReporter) {
        reporter = iReporter;
    }

    public final void flush() {
        if (this.beginTimeMs == 0) {
            return;
        }
        if (this.averageCalculator.getCount() >= 10) {
            commit();
        }
        reset();
    }

    public void onDecodeError() {
        this.success = false;
    }

    public void tickReadSample(long j3) {
        if (j3 > 30000000) {
            return;
        }
        if (this.beginTimeMs == 0) {
            this.beginTimeMs = System.currentTimeMillis() - (j3 / 1000000);
        }
        this.averageCalculator.tick(j3 / 1000);
    }
}
