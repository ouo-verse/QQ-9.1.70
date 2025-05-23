package com.tencent.opentelemetry.sdk.metrics.internal.view;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.api.logging.DefaultPrintLogger;
import com.tencent.opentelemetry.sdk.metrics.Aggregation;
import com.tencent.opentelemetry.sdk.metrics.InstrumentType;
import com.tencent.opentelemetry.sdk.metrics.internal.aggregator.Aggregator;
import com.tencent.opentelemetry.sdk.metrics.internal.aggregator.AggregatorFactory;
import com.tencent.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor;
import com.tencent.opentelemetry.sdk.metrics.internal.exemplar.ExemplarFilter;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class DefaultAggregation implements Aggregation, AggregatorFactory {
    static IPatchRedirector $redirector_ = null;
    private static final Aggregation INSTANCE;
    private static final String TAG = "DefaultAggregation";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.opentelemetry.sdk.metrics.internal.view.DefaultAggregation$1, reason: invalid class name */
    /* loaded from: classes22.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$opentelemetry$sdk$metrics$InstrumentType;
        static IPatchRedirector $redirector_;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22904);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[InstrumentType.values().length];
            $SwitchMap$com$tencent$opentelemetry$sdk$metrics$InstrumentType = iArr;
            try {
                iArr[InstrumentType.COUNTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tencent$opentelemetry$sdk$metrics$InstrumentType[InstrumentType.UP_DOWN_COUNTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$tencent$opentelemetry$sdk$metrics$InstrumentType[InstrumentType.OBSERVABLE_COUNTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$tencent$opentelemetry$sdk$metrics$InstrumentType[InstrumentType.OBSERVABLE_UP_DOWN_COUNTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$tencent$opentelemetry$sdk$metrics$InstrumentType[InstrumentType.HISTOGRAM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$tencent$opentelemetry$sdk$metrics$InstrumentType[InstrumentType.OBSERVABLE_GAUGE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22899);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new DefaultAggregation();
        }
    }

    DefaultAggregation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static Aggregation getInstance() {
        return INSTANCE;
    }

    private static Aggregation resolve(InstrumentDescriptor instrumentDescriptor) {
        switch (AnonymousClass1.$SwitchMap$com$tencent$opentelemetry$sdk$metrics$InstrumentType[instrumentDescriptor.getType().ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                return SumAggregation.getInstance();
            case 5:
                return ExplicitBucketHistogramAggregation.getDefault();
            case 6:
                return LastValueAggregation.getInstance();
            default:
                if (DefaultPrintLogger.isDebug()) {
                    DefaultPrintLogger.w(TAG, "Unable to find default aggregation for instrument: " + instrumentDescriptor);
                }
                return DropAggregation.getInstance();
        }
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.AggregatorFactory
    public <T> Aggregator<T> createAggregator(InstrumentDescriptor instrumentDescriptor, ExemplarFilter exemplarFilter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Aggregator) iPatchRedirector.redirect((short) 2, (Object) this, (Object) instrumentDescriptor, (Object) exemplarFilter);
        }
        return ((AggregatorFactory) resolve(instrumentDescriptor)).createAggregator(instrumentDescriptor, exemplarFilter);
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.AggregatorFactory
    public boolean isCompatibleWithInstrument(InstrumentDescriptor instrumentDescriptor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) instrumentDescriptor)).booleanValue();
        }
        return ((AggregatorFactory) resolve(instrumentDescriptor)).isCompatibleWithInstrument(instrumentDescriptor);
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return TAG;
    }
}
