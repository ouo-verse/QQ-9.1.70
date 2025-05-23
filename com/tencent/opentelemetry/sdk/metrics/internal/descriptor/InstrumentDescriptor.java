package com.tencent.opentelemetry.sdk.metrics.internal.descriptor;

import com.google.auto.value.AutoValue;
import com.google.auto.value.extension.memoized.Memoized;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.sdk.metrics.InstrumentType;
import com.tencent.opentelemetry.sdk.metrics.InstrumentValueType;
import com.tencent.opentelemetry.sdk.metrics.internal.debug.SourceInfo;
import com.tencent.opentelemetry.sdk.metrics.internal.debug.a;
import javax.annotation.concurrent.Immutable;

/* compiled from: P */
@AutoValue
@Immutable
/* loaded from: classes22.dex */
public abstract class InstrumentDescriptor {
    static IPatchRedirector $redirector_;

    public InstrumentDescriptor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static InstrumentDescriptor create(String str, String str2, String str3, InstrumentType instrumentType, InstrumentValueType instrumentValueType) {
        return new AutoValue_InstrumentDescriptor(str, str2, str3, instrumentType, instrumentValueType, a.a());
    }

    public abstract String getDescription();

    public abstract String getName();

    public abstract SourceInfo getSourceInfo();

    public abstract InstrumentType getType();

    public abstract String getUnit();

    public abstract InstrumentValueType getValueType();

    @Memoized
    public abstract int hashCode();
}
