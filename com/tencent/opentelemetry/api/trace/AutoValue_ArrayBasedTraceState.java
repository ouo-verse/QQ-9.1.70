package com.tencent.opentelemetry.api.trace;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes22.dex */
public final class AutoValue_ArrayBasedTraceState extends ArrayBasedTraceState {
    static IPatchRedirector $redirector_;
    private final List<String> entries;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_ArrayBasedTraceState(List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) list);
        } else {
            if (list != null) {
                this.entries = list;
                return;
            }
            throw new NullPointerException("Null entries");
        }
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, obj)).booleanValue();
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof ArrayBasedTraceState) {
            return this.entries.equals(((ArrayBasedTraceState) obj).getEntries());
        }
        return false;
    }

    @Override // com.tencent.opentelemetry.api.trace.ArrayBasedTraceState
    List<String> getEntries() {
        return this.entries;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.entries.hashCode() ^ 1000003;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "ArrayBasedTraceState{entries=" + this.entries + "}";
    }
}
