package com.tencent.opentelemetry.sdk.metrics.internal.view;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.sdk.metrics.Aggregation;
import com.tencent.opentelemetry.sdk.metrics.InstrumentType;
import com.tencent.opentelemetry.sdk.metrics.InstrumentValueType;
import com.tencent.opentelemetry.sdk.metrics.internal.aggregator.Aggregator;
import com.tencent.opentelemetry.sdk.metrics.internal.aggregator.AggregatorFactory;
import com.tencent.opentelemetry.sdk.metrics.internal.aggregator.DoubleLastValueAggregator;
import com.tencent.opentelemetry.sdk.metrics.internal.aggregator.LongLastValueAggregator;
import com.tencent.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor;
import com.tencent.opentelemetry.sdk.metrics.internal.exemplar.ExemplarFilter;
import java.util.function.Supplier;

/* compiled from: P */
/* loaded from: classes22.dex */
public class LastValueAggregation implements Aggregation, AggregatorFactory {
    static IPatchRedirector $redirector_;
    private static final Aggregation INSTANCE;

    /* compiled from: P */
    /* renamed from: com.tencent.opentelemetry.sdk.metrics.internal.view.LastValueAggregation$1, reason: invalid class name */
    /* loaded from: classes22.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$opentelemetry$sdk$metrics$InstrumentValueType;
        static IPatchRedirector $redirector_;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22556);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[InstrumentValueType.values().length];
            $SwitchMap$com$tencent$opentelemetry$sdk$metrics$InstrumentValueType = iArr;
            try {
                iArr[InstrumentValueType.LONG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tencent$opentelemetry$sdk$metrics$InstrumentValueType[InstrumentValueType.DOUBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22496);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new LastValueAggregation();
        }
    }

    LastValueAggregation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static Aggregation getInstance() {
        return INSTANCE;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.AggregatorFactory
    public <T> Aggregator<T> createAggregator(InstrumentDescriptor instrumentDescriptor, ExemplarFilter exemplarFilter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Aggregator) iPatchRedirector.redirect((short) 2, (Object) this, (Object) instrumentDescriptor, (Object) exemplarFilter);
        }
        int i3 = AnonymousClass1.$SwitchMap$com$tencent$opentelemetry$sdk$metrics$InstrumentValueType[instrumentDescriptor.getValueType().ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                return new DoubleLastValueAggregator(new Supplier() { // from class: com.tencent.opentelemetry.sdk.metrics.internal.view.l
                    @Override // java.util.function.Supplier
                    public final Object get() {
                        return com.tencent.opentelemetry.sdk.metrics.internal.exemplar.c.d();
                    }
                });
            }
            throw new IllegalArgumentException("Invalid instrument value type");
        }
        return new LongLastValueAggregator(new Supplier() { // from class: com.tencent.opentelemetry.sdk.metrics.internal.view.l
            @Override // java.util.function.Supplier
            public final Object get() {
                return com.tencent.opentelemetry.sdk.metrics.internal.exemplar.c.d();
            }
        });
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.AggregatorFactory
    public boolean isCompatibleWithInstrument(InstrumentDescriptor instrumentDescriptor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) instrumentDescriptor)).booleanValue();
        }
        if (instrumentDescriptor.getType() == InstrumentType.OBSERVABLE_GAUGE) {
            return true;
        }
        return false;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "LastValueAggregation";
    }
}
