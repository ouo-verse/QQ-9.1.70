package com.tencent.opentelemetry.sdk.logs.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
final class AutoValue_StringBody extends StringBody {
    static IPatchRedirector $redirector_;
    private final String asString;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_StringBody(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        } else {
            if (str != null) {
                this.asString = str;
                return;
            }
            throw new NullPointerException("Null asString");
        }
    }

    @Override // com.tencent.opentelemetry.sdk.logs.data.StringBody, com.tencent.opentelemetry.sdk.logs.data.Body
    public String asString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.asString;
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, obj)).booleanValue();
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof StringBody) {
            return this.asString.equals(((StringBody) obj).asString());
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.asString.hashCode() ^ 1000003;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "StringBody{asString=" + this.asString + "}";
    }
}
