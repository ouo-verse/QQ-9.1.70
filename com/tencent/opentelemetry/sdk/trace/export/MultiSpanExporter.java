package com.tencent.opentelemetry.sdk.trace.export;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.api.logging.DefaultPrintLogger;
import com.tencent.opentelemetry.sdk.common.CompletableResultCode;
import com.tencent.opentelemetry.sdk.trace.data.SpanData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
final class MultiSpanExporter implements SpanExporter {
    static IPatchRedirector $redirector_;
    private static final String TAG;
    private final SpanExporter[] spanExporters;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11746);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            TAG = MultiSpanExporter.class.getName();
        }
    }

    MultiSpanExporter(SpanExporter[] spanExporterArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) spanExporterArr);
        } else {
            this.spanExporters = spanExporterArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SpanExporter create(List<SpanExporter> list) {
        return new MultiSpanExporter((SpanExporter[]) list.toArray(new SpanExporter[0]));
    }

    @Override // com.tencent.opentelemetry.sdk.trace.export.SpanExporter, java.io.Closeable, java.lang.AutoCloseable
    public /* synthetic */ void close() {
        f.a(this);
    }

    @Override // com.tencent.opentelemetry.sdk.trace.export.SpanExporter
    public CompletableResultCode export(Collection<SpanData> collection) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (CompletableResultCode) iPatchRedirector.redirect((short) 1, (Object) this, (Object) collection);
        }
        ArrayList arrayList = new ArrayList(this.spanExporters.length);
        for (SpanExporter spanExporter : this.spanExporters) {
            try {
                arrayList.add(spanExporter.export(collection));
            } catch (RuntimeException e16) {
                if (DefaultPrintLogger.isDebug()) {
                    DefaultPrintLogger.e(TAG, "Exception thrown by the export.", e16);
                }
                arrayList.add(CompletableResultCode.ofFailure());
            }
        }
        return CompletableResultCode.ofAll(arrayList);
    }

    @Override // com.tencent.opentelemetry.sdk.trace.export.SpanExporter
    public CompletableResultCode flush() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (CompletableResultCode) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        ArrayList arrayList = new ArrayList(this.spanExporters.length);
        for (SpanExporter spanExporter : this.spanExporters) {
            try {
                arrayList.add(spanExporter.flush());
            } catch (RuntimeException e16) {
                if (DefaultPrintLogger.isDebug()) {
                    DefaultPrintLogger.e(TAG, "Exception thrown by the flush.", e16);
                }
                arrayList.add(CompletableResultCode.ofFailure());
            }
        }
        return CompletableResultCode.ofAll(arrayList);
    }

    @Override // com.tencent.opentelemetry.sdk.trace.export.SpanExporter
    public CompletableResultCode shutdown() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (CompletableResultCode) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        ArrayList arrayList = new ArrayList(this.spanExporters.length);
        for (SpanExporter spanExporter : this.spanExporters) {
            try {
                arrayList.add(spanExporter.shutdown());
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
