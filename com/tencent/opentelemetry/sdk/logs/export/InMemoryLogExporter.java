package com.tencent.opentelemetry.sdk.logs.export;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.sdk.common.CompletableResultCode;
import com.tencent.opentelemetry.sdk.logs.data.LogData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: P */
/* loaded from: classes22.dex */
public class InMemoryLogExporter implements LogExporter {
    static IPatchRedirector $redirector_;
    private final Queue<LogData> finishedLogItems;
    private boolean isStopped;

    InMemoryLogExporter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.finishedLogItems = new ConcurrentLinkedQueue();
            this.isStopped = false;
        }
    }

    public static InMemoryLogExporter create() {
        return new InMemoryLogExporter();
    }

    @Override // com.tencent.opentelemetry.sdk.logs.export.LogExporter
    public CompletableResultCode export(Collection<LogData> collection) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (CompletableResultCode) iPatchRedirector.redirect((short) 4, (Object) this, (Object) collection);
        }
        if (this.isStopped) {
            return CompletableResultCode.ofFailure();
        }
        this.finishedLogItems.addAll(collection);
        return CompletableResultCode.ofSuccess();
    }

    @Override // com.tencent.opentelemetry.sdk.logs.export.LogExporter
    public CompletableResultCode flush() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (CompletableResultCode) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return CompletableResultCode.ofSuccess();
    }

    public List<LogData> getFinishedLogItems() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return Collections.unmodifiableList(new ArrayList(this.finishedLogItems));
    }

    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.finishedLogItems.clear();
        }
    }

    @Override // com.tencent.opentelemetry.sdk.logs.export.LogExporter
    public CompletableResultCode shutdown() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (CompletableResultCode) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        this.isStopped = true;
        this.finishedLogItems.clear();
        return CompletableResultCode.ofSuccess();
    }
}
