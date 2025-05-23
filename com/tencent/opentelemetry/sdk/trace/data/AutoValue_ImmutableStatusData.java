package com.tencent.opentelemetry.sdk.trace.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.trace.StatusCode;

/* compiled from: P */
/* loaded from: classes22.dex */
final class AutoValue_ImmutableStatusData extends ImmutableStatusData {
    static IPatchRedirector $redirector_;
    private final String description;
    private final StatusCode statusCode;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_ImmutableStatusData(StatusCode statusCode, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) statusCode, (Object) str);
        } else {
            if (statusCode != null) {
                this.statusCode = statusCode;
                if (str != null) {
                    this.description = str;
                    return;
                }
                throw new NullPointerException("Null description");
            }
            throw new NullPointerException("Null statusCode");
        }
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, obj)).booleanValue();
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableStatusData)) {
            return false;
        }
        ImmutableStatusData immutableStatusData = (ImmutableStatusData) obj;
        if (this.statusCode.equals(immutableStatusData.getStatusCode()) && this.description.equals(immutableStatusData.getDescription())) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.opentelemetry.sdk.trace.data.StatusData
    public String getDescription() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.description;
    }

    @Override // com.tencent.opentelemetry.sdk.trace.data.StatusData
    public StatusCode getStatusCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (StatusCode) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.statusCode;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return ((this.statusCode.hashCode() ^ 1000003) * 1000003) ^ this.description.hashCode();
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "ImmutableStatusData{statusCode=" + this.statusCode + ", description=" + this.description + "}";
    }
}
