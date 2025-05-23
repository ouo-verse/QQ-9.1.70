package com.tencent.mobileqq.qqguildsdk.tianjige;

import com.tencent.opentelemetry.api.trace.Span;
import com.tencent.opentelemetry.api.trace.SpanContext;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes17.dex */
public class k {
    public static String a(Span span) {
        if (span != null && span.getSpanContext() != null) {
            try {
                SpanContext spanContext = span.getSpanContext();
                Locale locale = Locale.getDefault();
                Object[] objArr = new Object[4];
                int i3 = 0;
                objArr[0] = "00";
                objArr[1] = spanContext.getTraceId();
                objArr[2] = spanContext.getSpanId();
                if (h.f().m(span)) {
                    i3 = 1;
                }
                objArr[3] = Integer.valueOf(i3);
                return String.format(locale, "%s-%s-%s-0%d", objArr);
            } catch (Throwable th5) {
                QLog.e("SpanWrapper", 1, "getTraceInfo error:" + th5.toString());
            }
        }
        return "";
    }
}
