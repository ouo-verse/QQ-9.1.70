package com.tencent.opentelemetry.sdk.metrics.internal.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.sdk.metrics.data.SummaryPointData;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes22.dex */
final class AutoValue_ImmutableSummaryData extends ImmutableSummaryData {
    static IPatchRedirector $redirector_;
    private final Collection<SummaryPointData> points;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_ImmutableSummaryData(Collection<SummaryPointData> collection) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) collection);
        } else {
            if (collection != null) {
                this.points = collection;
                return;
            }
            throw new NullPointerException("Null points");
        }
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, obj)).booleanValue();
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof ImmutableSummaryData) {
            return this.points.equals(((ImmutableSummaryData) obj).getPoints());
        }
        return false;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.data.Data
    public Collection<SummaryPointData> getPoints() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Collection) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.points;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.points.hashCode() ^ 1000003;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "ImmutableSummaryData{points=" + this.points + "}";
    }
}
