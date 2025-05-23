package com.tencent.opentelemetry.sdk.metrics.export;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.sdk.common.CompletableResultCode;
import com.tencent.opentelemetry.sdk.metrics.InstrumentType;
import com.tencent.opentelemetry.sdk.metrics.data.AggregationTemporality;
import com.tencent.opentelemetry.sdk.metrics.data.MetricData;
import java.io.Closeable;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface MetricExporter extends Closeable {
    public static final IPatchRedirector $redirector_ = null;

    /* compiled from: P */
    /* renamed from: com.tencent.opentelemetry.sdk.metrics.export.MetricExporter$1, reason: invalid class name */
    /* loaded from: classes22.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$opentelemetry$sdk$metrics$InstrumentType;
        static IPatchRedirector $redirector_;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13805);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[InstrumentType.values().length];
            $SwitchMap$com$tencent$opentelemetry$sdk$metrics$InstrumentType = iArr;
            try {
                iArr[InstrumentType.UP_DOWN_COUNTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tencent$opentelemetry$sdk$metrics$InstrumentType[InstrumentType.OBSERVABLE_UP_DOWN_COUNTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$tencent$opentelemetry$sdk$metrics$InstrumentType[InstrumentType.COUNTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$tencent$opentelemetry$sdk$metrics$InstrumentType[InstrumentType.OBSERVABLE_COUNTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$tencent$opentelemetry$sdk$metrics$InstrumentType[InstrumentType.HISTOGRAM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    CompletableResultCode export(Collection<MetricData> collection);

    CompletableResultCode flush();

    AggregationTemporality getAggregationTemporality(InstrumentType instrumentType);

    CompletableResultCode shutdown();
}
