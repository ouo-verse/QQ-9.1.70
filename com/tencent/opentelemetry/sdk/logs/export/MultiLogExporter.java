package com.tencent.opentelemetry.sdk.logs.export;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.logging.DefaultPrintLogger;
import com.tencent.opentelemetry.sdk.common.CompletableResultCode;
import com.tencent.opentelemetry.sdk.logs.data.LogData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
final class MultiLogExporter implements LogExporter {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "MultiLogExporter";
    private final LogExporter[] logExporters;

    MultiLogExporter(LogExporter[] logExporterArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) logExporterArr);
        } else {
            this.logExporters = logExporterArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static LogExporter create(List<LogExporter> list) {
        return new MultiLogExporter((LogExporter[]) list.toArray(new LogExporter[0]));
    }

    @Override // com.tencent.opentelemetry.sdk.logs.export.LogExporter
    public CompletableResultCode export(Collection<LogData> collection) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (CompletableResultCode) iPatchRedirector.redirect((short) 1, (Object) this, (Object) collection);
        }
        ArrayList arrayList = new ArrayList(this.logExporters.length);
        for (LogExporter logExporter : this.logExporters) {
            try {
                arrayList.add(logExporter.export(collection));
            } catch (RuntimeException e16) {
                if (DefaultPrintLogger.isDebug()) {
                    DefaultPrintLogger.e(TAG, "Exception thrown by the export.", e16);
                }
                arrayList.add(CompletableResultCode.ofFailure());
            }
        }
        return CompletableResultCode.ofAll(arrayList);
    }

    @Override // com.tencent.opentelemetry.sdk.logs.export.LogExporter
    public CompletableResultCode flush() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (CompletableResultCode) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        ArrayList arrayList = new ArrayList(this.logExporters.length);
        for (LogExporter logExporter : this.logExporters) {
            try {
                arrayList.add(logExporter.flush());
            } catch (RuntimeException e16) {
                if (DefaultPrintLogger.isDebug()) {
                    DefaultPrintLogger.e(TAG, "Exception thrown by the flush.", e16);
                }
                arrayList.add(CompletableResultCode.ofFailure());
            }
        }
        return CompletableResultCode.ofAll(arrayList);
    }

    @Override // com.tencent.opentelemetry.sdk.logs.export.LogExporter
    public CompletableResultCode shutdown() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (CompletableResultCode) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        ArrayList arrayList = new ArrayList(this.logExporters.length);
        for (LogExporter logExporter : this.logExporters) {
            try {
                arrayList.add(logExporter.shutdown());
            } catch (RuntimeException e16) {
                if (DefaultPrintLogger.isDebug()) {
                    DefaultPrintLogger.e(TAG, "Exception thrown by the shutdown.", e16);
                }
                arrayList.add(CompletableResultCode.ofFailure());
            }
        }
        return CompletableResultCode.ofAll(arrayList);
    }
}
