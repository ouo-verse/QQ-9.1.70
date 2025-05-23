package com.tencent.opentelemetry.api.metrics;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.context.Context;
import java.util.function.Consumer;
import javax.annotation.concurrent.ThreadSafe;

/* compiled from: P */
@ThreadSafe
/* loaded from: classes22.dex */
class DefaultMeter implements Meter {
    static IPatchRedirector $redirector_;
    private static final Meter INSTANCE;
    private static final DoubleGaugeBuilder NOOP_DOUBLE_GAUGE_BUILDER;
    private static final DoubleHistogramBuilder NOOP_DOUBLE_HISTOGRAM_BUILDER;
    private static final LongCounterBuilder NOOP_LONG_COUNTER_BUILDER;
    private static final LongUpDownCounterBuilder NOOP_LONG_UP_DOWN_COUNTER_BUILDER;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private static class NoopDoubleCounter implements DoubleCounter {
        static IPatchRedirector $redirector_;

        NoopDoubleCounter() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        @Override // com.tencent.opentelemetry.api.metrics.DoubleCounter
        public void add(double d16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, this, Double.valueOf(d16));
        }

        /* synthetic */ NoopDoubleCounter(AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) anonymousClass1);
        }

        @Override // com.tencent.opentelemetry.api.metrics.DoubleCounter
        public void add(double d16, Attributes attributes) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, this, Double.valueOf(d16), attributes);
        }

        @Override // com.tencent.opentelemetry.api.metrics.DoubleCounter
        public void add(double d16, Attributes attributes, Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, Double.valueOf(d16), attributes, context);
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private static class NoopDoubleCounterBuilder implements DoubleCounterBuilder {
        static IPatchRedirector $redirector_;
        private static final DoubleCounter NOOP_COUNTER;
        private static final ObservableDoubleCounter NOOP_OBSERVABLE_COUNTER;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16136);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 7)) {
                redirector.redirect((short) 7);
            } else {
                NOOP_COUNTER = new NoopDoubleCounter(null);
                NOOP_OBSERVABLE_COUNTER = new ObservableDoubleCounter() { // from class: com.tencent.opentelemetry.api.metrics.DefaultMeter.NoopDoubleCounterBuilder.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this);
                        }
                    }

                    @Override // com.tencent.opentelemetry.api.metrics.ObservableDoubleCounter, java.lang.AutoCloseable
                    public /* synthetic */ void close() {
                        b.a(this);
                    }
                };
            }
        }

        NoopDoubleCounterBuilder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        @Override // com.tencent.opentelemetry.api.metrics.DoubleCounterBuilder
        public DoubleCounter build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (DoubleCounter) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return NOOP_COUNTER;
        }

        @Override // com.tencent.opentelemetry.api.metrics.DoubleCounterBuilder
        public ObservableDoubleCounter buildWithCallback(Consumer<ObservableDoubleMeasurement> consumer) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (ObservableDoubleCounter) iPatchRedirector.redirect((short) 5, (Object) this, (Object) consumer);
            }
            return NOOP_OBSERVABLE_COUNTER;
        }

        @Override // com.tencent.opentelemetry.api.metrics.DoubleCounterBuilder
        public DoubleCounterBuilder setDescription(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (DoubleCounterBuilder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
            return this;
        }

        @Override // com.tencent.opentelemetry.api.metrics.DoubleCounterBuilder
        public DoubleCounterBuilder setUnit(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (DoubleCounterBuilder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            }
            return this;
        }

        /* synthetic */ NoopDoubleCounterBuilder(AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                return;
            }
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) anonymousClass1);
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private static class NoopDoubleGaugeBuilder implements DoubleGaugeBuilder {
        static IPatchRedirector $redirector_;
        private static final ObservableDoubleGauge NOOP;
        private static final LongGaugeBuilder NOOP_LONG_GAUGE_BUILDER;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15889);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 7)) {
                redirector.redirect((short) 7);
            } else {
                NOOP = new ObservableDoubleGauge() { // from class: com.tencent.opentelemetry.api.metrics.DefaultMeter.NoopDoubleGaugeBuilder.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this);
                        }
                    }

                    @Override // com.tencent.opentelemetry.api.metrics.ObservableDoubleGauge, java.lang.AutoCloseable
                    public /* synthetic */ void close() {
                        c.a(this);
                    }
                };
                NOOP_LONG_GAUGE_BUILDER = new NoopLongGaugeBuilder(null);
            }
        }

        NoopDoubleGaugeBuilder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        @Override // com.tencent.opentelemetry.api.metrics.DoubleGaugeBuilder
        public ObservableDoubleGauge buildWithCallback(Consumer<ObservableDoubleMeasurement> consumer) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (ObservableDoubleGauge) iPatchRedirector.redirect((short) 5, (Object) this, (Object) consumer);
            }
            return NOOP;
        }

        @Override // com.tencent.opentelemetry.api.metrics.DoubleGaugeBuilder
        public LongGaugeBuilder ofLongs() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (LongGaugeBuilder) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return NOOP_LONG_GAUGE_BUILDER;
        }

        @Override // com.tencent.opentelemetry.api.metrics.DoubleGaugeBuilder
        public DoubleGaugeBuilder setDescription(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (DoubleGaugeBuilder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
            return this;
        }

        @Override // com.tencent.opentelemetry.api.metrics.DoubleGaugeBuilder
        public DoubleGaugeBuilder setUnit(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (DoubleGaugeBuilder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            }
            return this;
        }

        /* synthetic */ NoopDoubleGaugeBuilder(AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                return;
            }
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) anonymousClass1);
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private static class NoopDoubleHistogram implements DoubleHistogram {
        static IPatchRedirector $redirector_;

        NoopDoubleHistogram() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        @Override // com.tencent.opentelemetry.api.metrics.DoubleHistogram
        public void record(double d16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, this, Double.valueOf(d16));
        }

        /* synthetic */ NoopDoubleHistogram(AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) anonymousClass1);
        }

        @Override // com.tencent.opentelemetry.api.metrics.DoubleHistogram
        public void record(double d16, Attributes attributes) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, this, Double.valueOf(d16), attributes);
        }

        @Override // com.tencent.opentelemetry.api.metrics.DoubleHistogram
        public void record(double d16, Attributes attributes, Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, Double.valueOf(d16), attributes, context);
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private static class NoopDoubleHistogramBuilder implements DoubleHistogramBuilder {
        static IPatchRedirector $redirector_;
        private static final DoubleHistogram NOOP;
        private static final LongHistogramBuilder NOOP_LONG_HISTOGRAM_BUILDER;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15936);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 7)) {
                redirector.redirect((short) 7);
                return;
            }
            AnonymousClass1 anonymousClass1 = null;
            NOOP = new NoopDoubleHistogram(anonymousClass1);
            NOOP_LONG_HISTOGRAM_BUILDER = new NoopLongHistogramBuilder(anonymousClass1);
        }

        NoopDoubleHistogramBuilder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        @Override // com.tencent.opentelemetry.api.metrics.DoubleHistogramBuilder
        public DoubleHistogram build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (DoubleHistogram) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return NOOP;
        }

        @Override // com.tencent.opentelemetry.api.metrics.DoubleHistogramBuilder
        public LongHistogramBuilder ofLongs() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (LongHistogramBuilder) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return NOOP_LONG_HISTOGRAM_BUILDER;
        }

        @Override // com.tencent.opentelemetry.api.metrics.DoubleHistogramBuilder
        public DoubleHistogramBuilder setDescription(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (DoubleHistogramBuilder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
            return this;
        }

        @Override // com.tencent.opentelemetry.api.metrics.DoubleHistogramBuilder
        public DoubleHistogramBuilder setUnit(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (DoubleHistogramBuilder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            }
            return this;
        }

        /* synthetic */ NoopDoubleHistogramBuilder(AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                return;
            }
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) anonymousClass1);
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private static class NoopDoubleUpDownCounter implements DoubleUpDownCounter {
        static IPatchRedirector $redirector_;

        NoopDoubleUpDownCounter() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        @Override // com.tencent.opentelemetry.api.metrics.DoubleUpDownCounter
        public void add(double d16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, this, Double.valueOf(d16));
        }

        /* synthetic */ NoopDoubleUpDownCounter(AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) anonymousClass1);
        }

        @Override // com.tencent.opentelemetry.api.metrics.DoubleUpDownCounter
        public void add(double d16, Attributes attributes) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, this, Double.valueOf(d16), attributes);
        }

        @Override // com.tencent.opentelemetry.api.metrics.DoubleUpDownCounter
        public void add(double d16, Attributes attributes, Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, Double.valueOf(d16), attributes, context);
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private static class NoopDoubleUpDownCounterBuilder implements DoubleUpDownCounterBuilder {
        static IPatchRedirector $redirector_;
        private static final ObservableDoubleUpDownCounter NOOP_OBSERVABLE_UP_DOWN_COUNTER;
        private static final DoubleUpDownCounter NOOP_UP_DOWN_COUNTER;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16009);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 7)) {
                redirector.redirect((short) 7);
            } else {
                NOOP_UP_DOWN_COUNTER = new NoopDoubleUpDownCounter() { // from class: com.tencent.opentelemetry.api.metrics.DefaultMeter.NoopDoubleUpDownCounterBuilder.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this);
                        }
                    }
                };
                NOOP_OBSERVABLE_UP_DOWN_COUNTER = new ObservableDoubleUpDownCounter() { // from class: com.tencent.opentelemetry.api.metrics.DefaultMeter.NoopDoubleUpDownCounterBuilder.2
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this);
                        }
                    }

                    @Override // com.tencent.opentelemetry.api.metrics.ObservableDoubleUpDownCounter, java.lang.AutoCloseable
                    public /* synthetic */ void close() {
                        d.a(this);
                    }
                };
            }
        }

        NoopDoubleUpDownCounterBuilder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        @Override // com.tencent.opentelemetry.api.metrics.DoubleUpDownCounterBuilder
        public DoubleUpDownCounter build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (DoubleUpDownCounter) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return NOOP_UP_DOWN_COUNTER;
        }

        @Override // com.tencent.opentelemetry.api.metrics.DoubleUpDownCounterBuilder
        public ObservableDoubleUpDownCounter buildWithCallback(Consumer<ObservableDoubleMeasurement> consumer) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (ObservableDoubleUpDownCounter) iPatchRedirector.redirect((short) 5, (Object) this, (Object) consumer);
            }
            return NOOP_OBSERVABLE_UP_DOWN_COUNTER;
        }

        @Override // com.tencent.opentelemetry.api.metrics.DoubleUpDownCounterBuilder
        public DoubleUpDownCounterBuilder setDescription(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (DoubleUpDownCounterBuilder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
            return this;
        }

        @Override // com.tencent.opentelemetry.api.metrics.DoubleUpDownCounterBuilder
        public DoubleUpDownCounterBuilder setUnit(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (DoubleUpDownCounterBuilder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            }
            return this;
        }

        /* synthetic */ NoopDoubleUpDownCounterBuilder(AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                return;
            }
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) anonymousClass1);
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private static class NoopLongCounter implements LongCounter {
        static IPatchRedirector $redirector_;

        NoopLongCounter() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        @Override // com.tencent.opentelemetry.api.metrics.LongCounter
        public void add(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, j3);
        }

        /* synthetic */ NoopLongCounter(AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) anonymousClass1);
        }

        @Override // com.tencent.opentelemetry.api.metrics.LongCounter
        public void add(long j3, Attributes attributes) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(j3), attributes);
        }

        @Override // com.tencent.opentelemetry.api.metrics.LongCounter
        public void add(long j3, Attributes attributes, Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), attributes, context);
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private static class NoopLongCounterBuilder implements LongCounterBuilder {
        static IPatchRedirector $redirector_;
        private static final LongCounter NOOP_COUNTER;
        private static final DoubleCounterBuilder NOOP_DOUBLE_COUNTER_BUILDER;
        private static final ObservableLongCounter NOOP_OBSERVABLE_COUNTER;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16148);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 8)) {
                redirector.redirect((short) 8);
                return;
            }
            AnonymousClass1 anonymousClass1 = null;
            NOOP_COUNTER = new NoopLongCounter(anonymousClass1);
            NOOP_OBSERVABLE_COUNTER = new ObservableLongCounter() { // from class: com.tencent.opentelemetry.api.metrics.DefaultMeter.NoopLongCounterBuilder.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                @Override // com.tencent.opentelemetry.api.metrics.ObservableLongCounter, java.lang.AutoCloseable
                public /* synthetic */ void close() {
                    e.a(this);
                }
            };
            NOOP_DOUBLE_COUNTER_BUILDER = new NoopDoubleCounterBuilder(anonymousClass1);
        }

        NoopLongCounterBuilder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        @Override // com.tencent.opentelemetry.api.metrics.LongCounterBuilder
        public LongCounter build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (LongCounter) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return NOOP_COUNTER;
        }

        @Override // com.tencent.opentelemetry.api.metrics.LongCounterBuilder
        public ObservableLongCounter buildWithCallback(Consumer<ObservableLongMeasurement> consumer) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (ObservableLongCounter) iPatchRedirector.redirect((short) 6, (Object) this, (Object) consumer);
            }
            return NOOP_OBSERVABLE_COUNTER;
        }

        @Override // com.tencent.opentelemetry.api.metrics.LongCounterBuilder
        public DoubleCounterBuilder ofDoubles() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (DoubleCounterBuilder) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return NOOP_DOUBLE_COUNTER_BUILDER;
        }

        @Override // com.tencent.opentelemetry.api.metrics.LongCounterBuilder
        public LongCounterBuilder setDescription(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (LongCounterBuilder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
            return this;
        }

        @Override // com.tencent.opentelemetry.api.metrics.LongCounterBuilder
        public LongCounterBuilder setUnit(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (LongCounterBuilder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            }
            return this;
        }

        /* synthetic */ NoopLongCounterBuilder(AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
                return;
            }
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) anonymousClass1);
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private static class NoopLongGaugeBuilder implements LongGaugeBuilder {
        static IPatchRedirector $redirector_;
        private static final ObservableLongGauge NOOP;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15852);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 6)) {
                redirector.redirect((short) 6);
            } else {
                NOOP = new ObservableLongGauge() { // from class: com.tencent.opentelemetry.api.metrics.DefaultMeter.NoopLongGaugeBuilder.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this);
                        }
                    }

                    @Override // com.tencent.opentelemetry.api.metrics.ObservableLongGauge, java.lang.AutoCloseable
                    public /* synthetic */ void close() {
                        f.a(this);
                    }
                };
            }
        }

        NoopLongGaugeBuilder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        @Override // com.tencent.opentelemetry.api.metrics.LongGaugeBuilder
        public ObservableLongGauge buildWithCallback(Consumer<ObservableLongMeasurement> consumer) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (ObservableLongGauge) iPatchRedirector.redirect((short) 4, (Object) this, (Object) consumer);
            }
            return NOOP;
        }

        @Override // com.tencent.opentelemetry.api.metrics.LongGaugeBuilder
        public LongGaugeBuilder setDescription(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (LongGaugeBuilder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
            return this;
        }

        @Override // com.tencent.opentelemetry.api.metrics.LongGaugeBuilder
        public LongGaugeBuilder setUnit(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (LongGaugeBuilder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            }
            return this;
        }

        /* synthetic */ NoopLongGaugeBuilder(AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) anonymousClass1);
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private static class NoopLongHistogram implements LongHistogram {
        static IPatchRedirector $redirector_;

        NoopLongHistogram() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        @Override // com.tencent.opentelemetry.api.metrics.LongHistogram
        public void record(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, j3);
        }

        /* synthetic */ NoopLongHistogram(AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) anonymousClass1);
        }

        @Override // com.tencent.opentelemetry.api.metrics.LongHistogram
        public void record(long j3, Attributes attributes) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(j3), attributes);
        }

        @Override // com.tencent.opentelemetry.api.metrics.LongHistogram
        public void record(long j3, Attributes attributes, Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), attributes, context);
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private static class NoopLongHistogramBuilder implements LongHistogramBuilder {
        static IPatchRedirector $redirector_;
        private static final LongHistogram NOOP;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15911);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 6)) {
                redirector.redirect((short) 6);
            } else {
                NOOP = new NoopLongHistogram(null);
            }
        }

        NoopLongHistogramBuilder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        @Override // com.tencent.opentelemetry.api.metrics.LongHistogramBuilder
        public LongHistogram build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (LongHistogram) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return NOOP;
        }

        @Override // com.tencent.opentelemetry.api.metrics.LongHistogramBuilder
        public LongHistogramBuilder setDescription(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (LongHistogramBuilder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
            return this;
        }

        @Override // com.tencent.opentelemetry.api.metrics.LongHistogramBuilder
        public LongHistogramBuilder setUnit(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (LongHistogramBuilder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            }
            return this;
        }

        /* synthetic */ NoopLongHistogramBuilder(AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) anonymousClass1);
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private static class NoopLongUpDownCounter implements LongUpDownCounter {
        static IPatchRedirector $redirector_;

        NoopLongUpDownCounter() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        @Override // com.tencent.opentelemetry.api.metrics.LongUpDownCounter
        public void add(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, j3);
        }

        /* synthetic */ NoopLongUpDownCounter(AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) anonymousClass1);
        }

        @Override // com.tencent.opentelemetry.api.metrics.LongUpDownCounter
        public void add(long j3, Attributes attributes) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(j3), attributes);
        }

        @Override // com.tencent.opentelemetry.api.metrics.LongUpDownCounter
        public void add(long j3, Attributes attributes, Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), attributes, context);
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private static class NoopLongUpDownCounterBuilder implements LongUpDownCounterBuilder {
        static IPatchRedirector $redirector_;
        private static final DoubleUpDownCounterBuilder NOOP_DOUBLE_UP_DOWN_COUNTER_BUILDER;
        private static final ObservableLongUpDownCounter NOOP_OBSERVABLE_UP_DOWN_COUNTER;
        private static final LongUpDownCounter NOOP_UP_DOWN_COUNTER;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16071);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 8)) {
                redirector.redirect((short) 8);
                return;
            }
            NOOP_UP_DOWN_COUNTER = new NoopLongUpDownCounter() { // from class: com.tencent.opentelemetry.api.metrics.DefaultMeter.NoopLongUpDownCounterBuilder.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }
            };
            NOOP_OBSERVABLE_UP_DOWN_COUNTER = new ObservableLongUpDownCounter() { // from class: com.tencent.opentelemetry.api.metrics.DefaultMeter.NoopLongUpDownCounterBuilder.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                @Override // com.tencent.opentelemetry.api.metrics.ObservableLongUpDownCounter, java.lang.AutoCloseable
                public /* synthetic */ void close() {
                    g.a(this);
                }
            };
            NOOP_DOUBLE_UP_DOWN_COUNTER_BUILDER = new NoopDoubleUpDownCounterBuilder(null);
        }

        NoopLongUpDownCounterBuilder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        @Override // com.tencent.opentelemetry.api.metrics.LongUpDownCounterBuilder
        public LongUpDownCounter build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (LongUpDownCounter) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return NOOP_UP_DOWN_COUNTER;
        }

        @Override // com.tencent.opentelemetry.api.metrics.LongUpDownCounterBuilder
        public ObservableLongUpDownCounter buildWithCallback(Consumer<ObservableLongMeasurement> consumer) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (ObservableLongUpDownCounter) iPatchRedirector.redirect((short) 6, (Object) this, (Object) consumer);
            }
            return NOOP_OBSERVABLE_UP_DOWN_COUNTER;
        }

        @Override // com.tencent.opentelemetry.api.metrics.LongUpDownCounterBuilder
        public DoubleUpDownCounterBuilder ofDoubles() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (DoubleUpDownCounterBuilder) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return NOOP_DOUBLE_UP_DOWN_COUNTER_BUILDER;
        }

        @Override // com.tencent.opentelemetry.api.metrics.LongUpDownCounterBuilder
        public LongUpDownCounterBuilder setDescription(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (LongUpDownCounterBuilder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
            return this;
        }

        @Override // com.tencent.opentelemetry.api.metrics.LongUpDownCounterBuilder
        public LongUpDownCounterBuilder setUnit(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (LongUpDownCounterBuilder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            }
            return this;
        }

        /* synthetic */ NoopLongUpDownCounterBuilder(AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
                return;
            }
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) anonymousClass1);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15830);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        INSTANCE = new DefaultMeter();
        AnonymousClass1 anonymousClass1 = null;
        NOOP_LONG_COUNTER_BUILDER = new NoopLongCounterBuilder(anonymousClass1);
        NOOP_LONG_UP_DOWN_COUNTER_BUILDER = new NoopLongUpDownCounterBuilder(anonymousClass1);
        NOOP_DOUBLE_HISTOGRAM_BUILDER = new NoopDoubleHistogramBuilder(anonymousClass1);
        NOOP_DOUBLE_GAUGE_BUILDER = new NoopDoubleGaugeBuilder(anonymousClass1);
    }

    DefaultMeter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Meter getInstance() {
        return INSTANCE;
    }

    @Override // com.tencent.opentelemetry.api.metrics.Meter
    public LongCounterBuilder counterBuilder(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (LongCounterBuilder) iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        }
        return NOOP_LONG_COUNTER_BUILDER;
    }

    @Override // com.tencent.opentelemetry.api.metrics.Meter
    public DoubleGaugeBuilder gaugeBuilder(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (DoubleGaugeBuilder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        return NOOP_DOUBLE_GAUGE_BUILDER;
    }

    @Override // com.tencent.opentelemetry.api.metrics.Meter
    public DoubleHistogramBuilder histogramBuilder(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (DoubleHistogramBuilder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        return NOOP_DOUBLE_HISTOGRAM_BUILDER;
    }

    @Override // com.tencent.opentelemetry.api.metrics.Meter
    public LongUpDownCounterBuilder upDownCounterBuilder(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LongUpDownCounterBuilder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        return NOOP_LONG_UP_DOWN_COUNTER_BUILDER;
    }
}
