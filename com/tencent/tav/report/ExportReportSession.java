package com.tencent.tav.report;

import android.util.Log;
import androidx.annotation.Nullable;
import com.tencent.tav.core.ExportErrorStatus;
import com.tencent.tav.decoder.RenderContextParams;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class ExportReportSession {
    private static final String TAG = "ExportReportSession";
    private static final int TIME_CONS_LIMIT_US = 30000000;

    @Nullable
    private static IReporter reporter;
    private int errorCode;
    private String errorMsg;

    @Nullable
    private RenderContextParams renderContextParams;
    private long beginTimeMs = 0;
    private long compositeTimeUs = 0;
    private boolean success = true;
    private long fileDurationUs = 0;
    private long framePerSecond = 0;
    private long exportStartTimeNs = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static final class Bean extends ReportBean {

        @ReportKey(name = "composite_time")
        private long composite_time;

        @ReportKey(name = "error_code")
        private int errorCode;

        @ReportKey(name = "error_msg")
        private String errorMsg;

        @ReportKey(name = "file_duration")
        private long file_duration;

        @ReportKey(name = "frame_per_second")
        private long frame_per_second;

        @ReportKey(name = "success")
        private int success;

        public String toString() {
            return "Bean{composite_time=" + this.composite_time + ", success=" + this.success + ", file_duration=" + this.file_duration + ", frame_per_second=" + this.frame_per_second + '}';
        }

        Bean() {
            super("TAVFoundation", "tavkit_export_session", "3.4.5.130");
            this.composite_time = 0L;
            this.success = 0;
            this.file_duration = 0L;
            this.frame_per_second = 0L;
        }
    }

    private void report() {
        Bean bean = new Bean();
        bean.timestamp = Long.valueOf(this.beginTimeMs * 1000);
        bean.composite_time = this.compositeTimeUs;
        bean.success = this.success ? 1 : 0;
        bean.file_duration = this.fileDurationUs;
        bean.frame_per_second = this.framePerSecond;
        bean.errorCode = this.errorCode;
        bean.errorMsg = this.errorMsg;
        Log.d(TAG, "doCommit: bean = " + bean);
        TAVReportCenter.commit(bean);
        if (reporter != null) {
            reporter.onReport(this.renderContextParams, bean.extractReportData(Boolean.FALSE));
        }
        reset();
    }

    public static void setReporter(@Nullable IReporter iReporter) {
        reporter = iReporter;
    }

    public void onExportError(@Nullable ExportErrorStatus exportErrorStatus) {
        this.success = false;
        if (exportErrorStatus != null) {
            this.errorCode = exportErrorStatus.code;
            this.errorMsg = exportErrorStatus.f374239msg;
        }
        report();
    }

    public void onExportStart(long j3) {
        this.exportStartTimeNs = j3;
        this.beginTimeMs = System.currentTimeMillis();
    }

    public void onExportSuccess() {
        if (this.exportStartTimeNs <= 0) {
            Log.e(TAG, "onExportSuccess: \u6570\u636e\u9519\u8bef\uff0cexportStartTimeNs = " + this.exportStartTimeNs);
            return;
        }
        this.success = true;
        this.compositeTimeUs = (System.nanoTime() - this.exportStartTimeNs) / 1000;
        report();
    }

    public synchronized void reset() {
        Log.d(TAG, "reset() called");
        this.compositeTimeUs = 0L;
        this.success = false;
        this.fileDurationUs = 0L;
        this.framePerSecond = 0L;
    }

    public void setFileDurationUs(long j3) {
        this.fileDurationUs = j3;
    }

    public void setFramePerSecond(int i3) {
        this.framePerSecond = i3;
    }

    public void setRenderContextParams(RenderContextParams renderContextParams) {
        this.renderContextParams = renderContextParams;
    }
}
