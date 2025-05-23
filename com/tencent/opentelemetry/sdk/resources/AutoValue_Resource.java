package com.tencent.opentelemetry.sdk.resources;

import com.google.errorprone.annotations.concurrent.LazyInit;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.Attributes;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes22.dex */
public final class AutoValue_Resource extends C$AutoValue_Resource {
    static IPatchRedirector $redirector_;

    @LazyInit
    private volatile transient int hashCode;

    @LazyInit
    private volatile transient boolean hashCode$Memoized;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_Resource(String str, Attributes attributes) {
        super(str, attributes);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) attributes);
        }
    }

    @Override // com.tencent.opentelemetry.sdk.resources.C$AutoValue_Resource
    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, obj)).booleanValue();
        }
        if (this == obj) {
            return true;
        }
        if ((obj instanceof AutoValue_Resource) && hashCode() == obj.hashCode() && super.equals(obj)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.opentelemetry.sdk.resources.C$AutoValue_Resource, com.tencent.opentelemetry.sdk.resources.Resource
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
