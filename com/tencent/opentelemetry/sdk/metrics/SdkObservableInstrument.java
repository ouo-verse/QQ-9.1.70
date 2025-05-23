package com.tencent.opentelemetry.sdk.metrics;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.logging.DefaultPrintLogger;
import com.tencent.opentelemetry.api.metrics.ObservableDoubleCounter;
import com.tencent.opentelemetry.api.metrics.ObservableDoubleGauge;
import com.tencent.opentelemetry.api.metrics.ObservableDoubleUpDownCounter;
import com.tencent.opentelemetry.api.metrics.ObservableLongCounter;
import com.tencent.opentelemetry.api.metrics.ObservableLongGauge;
import com.tencent.opentelemetry.api.metrics.ObservableLongUpDownCounter;
import com.tencent.opentelemetry.sdk.metrics.internal.state.CallbackRegistration;
import com.tencent.opentelemetry.sdk.metrics.internal.state.MeterSharedState;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes22.dex */
class SdkObservableInstrument implements ObservableDoubleCounter, ObservableLongCounter, ObservableDoubleGauge, ObservableLongGauge, ObservableDoubleUpDownCounter, ObservableLongUpDownCounter {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "SdkObservableInstrument";
    private final CallbackRegistration<?> callbackRegistration;
    private final MeterSharedState meterSharedState;
    private final AtomicBoolean removed;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SdkObservableInstrument(MeterSharedState meterSharedState, CallbackRegistration<?> callbackRegistration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) meterSharedState, (Object) callbackRegistration);
            return;
        }
        this.removed = new AtomicBoolean(false);
        this.meterSharedState = meterSharedState;
        this.callbackRegistration = callbackRegistration;
    }

    @Override // com.tencent.opentelemetry.api.metrics.ObservableDoubleCounter, java.lang.AutoCloseable
    public void close() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (!this.removed.compareAndSet(false, true)) {
            if (DefaultPrintLogger.isDebug()) {
                DefaultPrintLogger.w(TAG, "Instrument " + this.callbackRegistration.getInstrumentDescriptor().getName() + " has called close() multiple times.");
                return;
            }
            return;
        }
        this.meterSharedState.removeCallback(this.callbackRegistration);
    }
}
