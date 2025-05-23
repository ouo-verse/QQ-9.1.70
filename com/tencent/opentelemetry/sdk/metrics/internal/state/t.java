package com.tencent.opentelemetry.sdk.metrics.internal.state;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.context.Context;

/* compiled from: P */
/* loaded from: classes22.dex */
public final /* synthetic */ class t {
    public static void a(WriteableMetricStorage writeableMetricStorage, double d16, Attributes attributes, Context context) {
        IPatchRedirector iPatchRedirector = WriteableMetricStorage.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, writeableMetricStorage, Double.valueOf(d16), attributes, context);
            return;
        }
        BoundStorageHandle bind = writeableMetricStorage.bind(attributes);
        try {
            bind.recordDouble(d16, attributes, context);
        } finally {
            bind.release();
        }
    }

    public static void b(WriteableMetricStorage writeableMetricStorage, long j3, Attributes attributes, Context context) {
        IPatchRedirector iPatchRedirector = WriteableMetricStorage.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, writeableMetricStorage, Long.valueOf(j3), attributes, context);
            return;
        }
        BoundStorageHandle bind = writeableMetricStorage.bind(attributes);
        try {
            bind.recordLong(j3, attributes, context);
        } finally {
            bind.release();
        }
    }
}
