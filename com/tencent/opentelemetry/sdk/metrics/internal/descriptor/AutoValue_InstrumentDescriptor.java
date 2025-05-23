package com.tencent.opentelemetry.sdk.metrics.internal.descriptor;

import com.google.errorprone.annotations.concurrent.LazyInit;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.sdk.metrics.InstrumentType;
import com.tencent.opentelemetry.sdk.metrics.InstrumentValueType;
import com.tencent.opentelemetry.sdk.metrics.internal.debug.SourceInfo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes22.dex */
public final class AutoValue_InstrumentDescriptor extends C$AutoValue_InstrumentDescriptor {
    static IPatchRedirector $redirector_;

    @LazyInit
    private volatile transient int hashCode;

    @LazyInit
    private volatile transient boolean hashCode$Memoized;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_InstrumentDescriptor(String str, String str2, String str3, InstrumentType instrumentType, InstrumentValueType instrumentValueType, SourceInfo sourceInfo) {
        super(str, str2, str3, instrumentType, instrumentValueType, sourceInfo);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, str3, instrumentType, instrumentValueType, sourceInfo);
        }
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.descriptor.C$AutoValue_InstrumentDescriptor
    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, obj)).booleanValue();
        }
        if (this == obj) {
            return true;
        }
        if ((obj instanceof AutoValue_InstrumentDescriptor) && hashCode() == obj.hashCode() && super.equals(obj)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.descriptor.C$AutoValue_InstrumentDescriptor, com.tencent.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor
    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        if (!this.hashCode$Memoized) {
            synchronized (this) {
                if (!this.hashCode$Memoized) {
                    this.hashCode = super.hashCode();
                    this.hashCode$Memoized = true;
                }
            }
        }
        return this.hashCode;
    }
}
