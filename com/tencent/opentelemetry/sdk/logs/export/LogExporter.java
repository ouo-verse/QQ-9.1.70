package com.tencent.opentelemetry.sdk.logs.export;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.sdk.common.CompletableResultCode;
import com.tencent.opentelemetry.sdk.logs.data.LogData;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface LogExporter {
    public static final IPatchRedirector $redirector_ = null;

    CompletableResultCode export(Collection<LogData> collection);

    CompletableResultCode flush();

    CompletableResultCode shutdown();
}
