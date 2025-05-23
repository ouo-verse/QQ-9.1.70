package com.tencent.opentelemetry.sdk.metrics.internal.state;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.api.logging.DefaultPrintLogger;
import com.tencent.opentelemetry.api.metrics.ObservableDoubleMeasurement;
import com.tencent.opentelemetry.api.metrics.ObservableLongMeasurement;
import com.tencent.opentelemetry.sdk.internal.ThrowableUtil;
import com.tencent.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/* compiled from: P */
/* loaded from: classes22.dex */
public class CallbackRegistration<T> {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "CallbackRegistration";
    private final Consumer<T> callback;
    private final InstrumentDescriptor instrumentDescriptor;
    private final T measurement;
    private final boolean noStoragesRegistered;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class ObservableDoubleMeasurementImpl implements ObservableDoubleMeasurement {
        static IPatchRedirector $redirector_;
        private final List<AsynchronousMetricStorage<?>> asyncMetricStorages;

        /* synthetic */ ObservableDoubleMeasurementImpl(List list, AnonymousClass1 anonymousClass1) {
            this(list);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) list, (Object) anonymousClass1);
        }

        @Override // com.tencent.opentelemetry.api.metrics.ObservableDoubleMeasurement
        public void record(double d16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                record(d16, com.tencent.opentelemetry.api.common.f.b());
            } else {
                iPatchRedirector.redirect((short) 2, this, Double.valueOf(d16));
            }
        }

        ObservableDoubleMeasurementImpl(List<AsynchronousMetricStorage<?>> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.asyncMetricStorages = list;
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) list);
            }
        }

        @Override // com.tencent.opentelemetry.api.metrics.ObservableDoubleMeasurement
        public void record(double d16, Attributes attributes) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Double.valueOf(d16), attributes);
                return;
            }
            Iterator<AsynchronousMetricStorage<?>> it = this.asyncMetricStorages.iterator();
            while (it.hasNext()) {
                it.next().recordDouble(d16, attributes);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class ObservableLongMeasurementImpl implements ObservableLongMeasurement {
        static IPatchRedirector $redirector_;
        private final List<AsynchronousMetricStorage<?>> asyncMetricStorages;

        /* synthetic */ ObservableLongMeasurementImpl(List list, AnonymousClass1 anonymousClass1) {
            this(list);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) list, (Object) anonymousClass1);
        }

        @Override // com.tencent.opentelemetry.api.metrics.ObservableLongMeasurement
        public void record(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                record(j3, com.tencent.opentelemetry.api.common.f.b());
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, j3);
            }
        }

        ObservableLongMeasurementImpl(List<AsynchronousMetricStorage<?>> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.asyncMetricStorages = list;
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) list);
            }
        }

        @Override // com.tencent.opentelemetry.api.metrics.ObservableLongMeasurement
        public void record(long j3, Attributes attributes) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Long.valueOf(j3), attributes);
                return;
            }
            Iterator<AsynchronousMetricStorage<?>> it = this.asyncMetricStorages.iterator();
            while (it.hasNext()) {
                it.next().recordLong(j3, attributes);
            }
        }
    }

    CallbackRegistration(InstrumentDescriptor instrumentDescriptor, Consumer<T> consumer, T t16, List<AsynchronousMetricStorage<?>> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, instrumentDescriptor, consumer, t16, list);
            return;
        }
        this.instrumentDescriptor = instrumentDescriptor;
        this.callback = consumer;
        this.measurement = t16;
        this.noStoragesRegistered = list.size() == 0;
    }

    public static CallbackRegistration<ObservableDoubleMeasurement> createDouble(InstrumentDescriptor instrumentDescriptor, Consumer<ObservableDoubleMeasurement> consumer, List<AsynchronousMetricStorage<?>> list) {
        return new CallbackRegistration<>(instrumentDescriptor, consumer, new ObservableDoubleMeasurementImpl(list, null), list);
    }

    public static CallbackRegistration<ObservableLongMeasurement> createLong(InstrumentDescriptor instrumentDescriptor, Consumer<ObservableLongMeasurement> consumer, List<AsynchronousMetricStorage<?>> list) {
        return new CallbackRegistration<>(instrumentDescriptor, consumer, new ObservableLongMeasurementImpl(list, null), list);
    }

    public InstrumentDescriptor getInstrumentDescriptor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (InstrumentDescriptor) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.instrumentDescriptor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void invokeCallback() {
        if (!this.noStoragesRegistered) {
            try {
                this.callback.accept(this.measurement);
            } catch (Throwable th5) {
                ThrowableUtil.propagateIfFatal(th5);
                if (DefaultPrintLogger.isDebug()) {
                    DefaultPrintLogger.w(TAG, "An exception occurred invoking callback for instrument " + this.instrumentDescriptor.getName() + ".", th5);
                }
            }
        }
    }
}
