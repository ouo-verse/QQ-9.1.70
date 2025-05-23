package com.tencent.opentelemetry.sdk.metrics.internal.view;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.sdk.internal.RandomSupplier;
import com.tencent.opentelemetry.sdk.metrics.Aggregation;
import com.tencent.opentelemetry.sdk.metrics.InstrumentType;
import com.tencent.opentelemetry.sdk.metrics.InstrumentValueType;
import com.tencent.opentelemetry.sdk.metrics.internal.aggregator.Aggregator;
import com.tencent.opentelemetry.sdk.metrics.internal.aggregator.AggregatorFactory;
import com.tencent.opentelemetry.sdk.metrics.internal.aggregator.DoubleSumAggregator;
import com.tencent.opentelemetry.sdk.metrics.internal.aggregator.LongSumAggregator;
import com.tencent.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor;
import com.tencent.opentelemetry.sdk.metrics.internal.exemplar.ExemplarFilter;
import com.tencent.opentelemetry.sdk.metrics.internal.exemplar.ExemplarReservoir;
import java.util.function.Supplier;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class SumAggregation implements Aggregation, AggregatorFactory {
    static IPatchRedirector $redirector_;
    private static final SumAggregation INSTANCE;

    /* compiled from: P */
    /* renamed from: com.tencent.opentelemetry.sdk.metrics.internal.view.SumAggregation$1, reason: invalid class name */
    /* loaded from: classes22.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$opentelemetry$sdk$metrics$InstrumentType;
        static final /* synthetic */ int[] $SwitchMap$com$tencent$opentelemetry$sdk$metrics$InstrumentValueType;
        static IPatchRedirector $redirector_;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22473);
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
                $SwitchMap$com$tencent$opentelemetry$sdk$metrics$InstrumentType[InstrumentType.OBSERVABLE_COUNTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$tencent$opentelemetry$sdk$metrics$InstrumentType[InstrumentType.UP_DOWN_COUNTER.ordinal()] = 3;
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
            int[] iArr2 = new int[InstrumentValueType.values().length];
            $SwitchMap$com$tencent$opentelemetry$sdk$metrics$InstrumentValueType = iArr2;
            try {
                iArr2[InstrumentValueType.LONG.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$tencent$opentelemetry$sdk$metrics$InstrumentValueType[InstrumentValueType.DOUBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22401);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new SumAggregation();
        }
    }

    SumAggregation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static Aggregation getInstance() {
        return INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ExemplarReservoir lambda$createAggregator$0(ExemplarFilter exemplarFilter) {
        return com.tencent.opentelemetry.sdk.metrics.internal.exemplar.c.a(exemplarFilter, com.tencent.opentelemetry.sdk.metrics.internal.exemplar.c.b(com.tencent.opentelemetry.sdk.common.a.a(), Runtime.getRuntime().availableProcessors(), RandomSupplier.platformDefault()));
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.AggregatorFactory
    public <T> Aggregator<T> createAggregator(InstrumentDescriptor instrumentDescriptor, final ExemplarFilter exemplarFilter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Aggregator) iPatchRedirector.redirect((short) 2, (Object) this, (Object) instrumentDescriptor, (Object) exemplarFilter);
        }
        Supplier supplier = new Supplier() { // from class: com.tencent.opentelemetry.sdk.metrics.internal.view.p
            @Override // java.util.function.Supplier
            public final Object get() {
                ExemplarReservoir lambda$createAggregator$0;
                lambda$createAggregator$0 = SumAggregation.lambda$createAggregator$0(ExemplarFilter.this);
                return lambda$createAggregator$0;
            }
        };
        int i3 = AnonymousClass1.$SwitchMap$com$tencent$opentelemetry$sdk$metrics$InstrumentValueType[instrumentDescriptor.getValueType().ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                return new DoubleSumAggregator(instrumentDescriptor, supplier);
            }
            throw new IllegalArgumentException("Invalid instrument value type");
        }
        return new LongSumAggregator(instrumentDescriptor, supplier);
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.AggregatorFactory
    public boolean isCompatibleWithInstrument(InstrumentDescriptor instrumentDescriptor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) instrumentDescriptor)).booleanValue();
        }
        int i3 = AnonymousClass1.$SwitchMap$com$tencent$opentelemetry$sdk$metrics$InstrumentType[instrumentDescriptor.getType().ordinal()];
        if (i3 == 1 || i3 == 2 || i3 == 3 || i3 == 4 || i3 == 5) {
            return true;
        }
        return false;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "SumAggregation";
    }
}
