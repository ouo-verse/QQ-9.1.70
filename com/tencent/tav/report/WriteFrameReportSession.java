package com.tencent.tav.report;

import androidx.annotation.Nullable;
import com.tencent.tav.decoder.RenderContextParams;
import com.tencent.tav.decoder.logger.Logger;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class WriteFrameReportSession {
    private static final int FRAME_COUNT_THRESHOLD = 10;
    private static final String TAG = "WriteFrameReportSession";
    private static final int TIME_CONS_LIMIT_US = 30000000;

    @Nullable
    private static IReporter reporter;

    @Nullable
    private RenderContextParams renderContextParams;
    private final AverageCalculator averageCalculator = new AverageCalculator();
    private boolean success = true;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static final class Bean extends ReportBean {

        @ReportKey(name = "avg_write_time")
        private long avgWriteTime;

        @ReportKey(name = "success")
        private int success;

        public String toString() {
            return "Bean{success=" + this.success + ", avgWriteTime=" + this.avgWriteTime + '}';
        }

        Bean() {
            super("TAVFoundation", "tavkit_export", "3.4.5.130");
            this.success = 0;
            this.avgWriteTime = 0L;
        }
    }

    private void doReport() {
        Bean bean = new Bean();
        bean.timestamp = Long.valueOf(System.nanoTime() / 1000);
        bean.success = this.success ? 1 : 0;
        bean.avgWriteTime = this.averageCalculator.getAvg();
        Logger.i(TAG, "doCommit: bean = " + bean);
        TAVReportCenter.commit(bean);
        if (reporter != null) {
            reporter.onReport(this.renderContextParams, bean.extractReportData(Boolean.FALSE));
        }
    }

    private void reset() {
        Logger.d(TAG, "reset() called");
        this.success = true;
        this.averageCalculator.reset();
    }

    public static void setReporter(@Nullable IReporter iReporter) {
        reporter = iReporter;
    }

    public void error() {
        this.success = false;
    }

    public void flush() {
        if (this.averageCalculator.getCount() >= 10) {
            doReport();
        }
        reset();
    }

    public void setRenderContextParams(RenderContextParams renderContextParams) {
        this.renderContextParams = renderContextParams;
    }

    public void tick(long j3) {
        if (j3 > 30000000) {
            return;
        }
        this.averageCalculator.tick(j3 / 1000);
    }
}
