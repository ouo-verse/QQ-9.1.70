package com.tencent.opentelemetry.sdk.metrics.internal.state;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface ExponentialCounterFactory {
    public static final IPatchRedirector $redirector_ = null;

    /* compiled from: P */
    /* renamed from: com.tencent.opentelemetry.sdk.metrics.internal.state.ExponentialCounterFactory$-CC, reason: invalid class name */
    /* loaded from: classes22.dex */
    public final /* synthetic */ class CC {
        public static ExponentialCounterFactory a() {
            IPatchRedirector iPatchRedirector = ExponentialCounterFactory.$redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (ExponentialCounterFactory) iPatchRedirector.redirect((short) 2);
            }
            return new ExponentialCounterFactory() { // from class: com.tencent.opentelemetry.sdk.metrics.internal.state.ExponentialCounterFactory.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this);
                    }
                }

                @Override // com.tencent.opentelemetry.sdk.metrics.internal.state.ExponentialCounterFactory
                public ExponentialCounter copy(ExponentialCounter exponentialCounter) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                        return (ExponentialCounter) iPatchRedirector2.redirect((short) 3, (Object) this, (Object) exponentialCounter);
                    }
                    return new AdaptingCircularBufferCounter(exponentialCounter);
                }

                @Override // com.tencent.opentelemetry.sdk.metrics.internal.state.ExponentialCounterFactory
                public ExponentialCounter newCounter(int i3) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (ExponentialCounter) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                    }
                    return new AdaptingCircularBufferCounter(i3);
                }

                public String toString() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                        return (String) iPatchRedirector2.redirect((short) 4, (Object) this);
                    }
                    return "circularBufferCounter";
                }
            };
        }

        public static ExponentialCounterFactory b() {
            IPatchRedirector iPatchRedirector = ExponentialCounterFactory.$redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return (ExponentialCounterFactory) iPatchRedirector.redirect((short) 1);
            }
            return new ExponentialCounterFactory() { // from class: com.tencent.opentelemetry.sdk.metrics.internal.state.ExponentialCounterFactory.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this);
                    }
                }

                @Override // com.tencent.opentelemetry.sdk.metrics.internal.state.ExponentialCounterFactory
                public ExponentialCounter copy(ExponentialCounter exponentialCounter) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                        return (ExponentialCounter) iPatchRedirector2.redirect((short) 3, (Object) this, (Object) exponentialCounter);
                    }
                    return new MapCounter(exponentialCounter);
                }

                @Override // com.tencent.opentelemetry.sdk.metrics.internal.state.ExponentialCounterFactory
                public ExponentialCounter newCounter(int i3) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (ExponentialCounter) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                    }
                    return new MapCounter(i3);
                }

                public String toString() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                        return (String) iPatchRedirector2.redirect((short) 4, (Object) this);
                    }
                    return "mapCounter";
                }
            };
        }
    }

    ExponentialCounter copy(ExponentialCounter exponentialCounter);

    ExponentialCounter newCounter(int i3);
}
