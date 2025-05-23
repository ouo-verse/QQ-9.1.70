package com.tencent.tav.report;

import android.util.Log;
import androidx.annotation.Nullable;

/* loaded from: classes26.dex */
public final class PreviewReportSession {
    private static final String TAG = "PreviewReportSession";

    @Nullable
    private static IReporter reporter;
    private boolean success = true;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public static final class Bean extends ReportBean {

        @ReportKey(name = "success")
        public int success;

        public String toString() {
            return "Bean{success=" + this.success + '}';
        }

        Bean() {
            super("TAVFoundation", "tavkit_preview_session", "3.4.5.130");
        }
    }

    private void commit() {
        Bean bean = new Bean();
        bean.timestamp = Long.valueOf(System.currentTimeMillis() * 1000);
        bean.success = this.success ? 1 : 0;
        Log.d(TAG, "commit: bean = " + bean);
        IReporter iReporter = reporter;
        if (iReporter != null) {
            iReporter.onReport(null, bean.extractReportData());
        }
        TAVReportCenter.commit(bean);
    }

    public static void setReporter(@Nullable IReporter iReporter) {
        reporter = iReporter;
    }

    public final void flush() {
        commit();
        reset();
    }

    public void onReadSampleError() {
        this.success = false;
    }

    private void reset() {
    }
}
