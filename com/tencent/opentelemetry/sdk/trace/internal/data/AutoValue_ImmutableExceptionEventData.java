package com.tencent.opentelemetry.sdk.trace.internal.data;

import com.google.errorprone.annotations.concurrent.LazyInit;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.Attributes;

/* compiled from: P */
/* loaded from: classes22.dex */
final class AutoValue_ImmutableExceptionEventData extends C$AutoValue_ImmutableExceptionEventData {
    static IPatchRedirector $redirector_;

    @LazyInit
    private volatile transient Attributes getAttributes;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_ImmutableExceptionEventData(final long j3, final Throwable th5, final Attributes attributes) {
        new ImmutableExceptionEventData(j3, th5, attributes) { // from class: com.tencent.opentelemetry.sdk.trace.internal.data.$AutoValue_ImmutableExceptionEventData
            static IPatchRedirector $redirector_;
            private final Attributes additionalAttributes;
            private final long epochNanos;
            private final Throwable exception;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), th5, attributes);
                    return;
                }
                this.epochNanos = j3;
                if (th5 != null) {
                    this.exception = th5;
                    if (attributes != null) {
                        this.additionalAttributes = attributes;
                        return;
                    }
                    throw new NullPointerException("Null additionalAttributes");
                }
                throw new NullPointerException("Null exception");
            }

            public boolean equals(Object obj) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, obj)).booleanValue();
                }
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof ImmutableExceptionEventData)) {
                    return false;
                }
                ImmutableExceptionEventData immutableExceptionEventData = (ImmutableExceptionEventData) obj;
                if (this.epochNanos == immutableExceptionEventData.getEpochNanos() && this.exception.equals(immutableExceptionEventData.getException()) && this.additionalAttributes.equals(immutableExceptionEventData.getAdditionalAttributes())) {
                    return true;
                }
                return false;
            }

            @Override // com.tencent.opentelemetry.sdk.trace.internal.data.ExceptionEventData
            public Attributes getAdditionalAttributes() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return (Attributes) iPatchRedirector.redirect((short) 4, (Object) this);
                }
                return this.additionalAttributes;
            }

            @Override // com.tencent.opentelemetry.sdk.trace.data.EventData
            public long getEpochNanos() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
                }
                return this.epochNanos;
            }

            @Override // com.tencent.opentelemetry.sdk.trace.internal.data.ExceptionEventData
            public Throwable getException() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (Throwable) iPatchRedirector.redirect((short) 3, (Object) this);
                }
                return this.exception;
            }

            public int hashCode() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                    return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
                }
                long j16 = this.epochNanos;
                return ((((((int) (j16 ^ (j16 >>> 32))) ^ 1000003) * 1000003) ^ this.exception.hashCode()) * 1000003) ^ this.additionalAttributes.hashCode();
            }

            public String toString() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return (String) iPatchRedirector.redirect((short) 5, (Object) this);
                }
                return "ImmutableExceptionEventData{epochNanos=" + this.epochNanos + ", exception=" + this.exception + ", additionalAttributes=" + this.additionalAttributes + "}";
            }
        };
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), th5, attributes);
        }
    }

    @Override // com.tencent.opentelemetry.sdk.trace.internal.data.ImmutableExceptionEventData, com.tencent.opentelemetry.sdk.trace.data.EventData
    public Attributes getAttributes() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Attributes) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (this.getAttributes == null) {
            synchronized (this) {
                if (this.getAttributes == null) {
                    this.getAttributes = super.getAttributes();
                    if (this.getAttributes == null) {
                        throw new NullPointerException("getAttributes() cannot return null");
                    }
                }
            }
        }
        return this.getAttributes;
    }
}
