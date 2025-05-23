package com.tencent.opentelemetry.sdk.logs;

import com.google.auto.value.AutoValue;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import javax.annotation.concurrent.Immutable;

/* compiled from: P */
@AutoValue
@Immutable
/* loaded from: classes22.dex */
public abstract class LogLimits {
    static IPatchRedirector $redirector_;
    private static final LogLimits DEFAULT;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9815);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            DEFAULT = new LogLimitsBuilder().build();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LogLimits() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static LogLimitsBuilder builder() {
        return new LogLimitsBuilder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static LogLimits create(int i3, int i16) {
        return new AutoValue_LogLimits(i3, i16);
    }

    public static LogLimits getDefault() {
        return DEFAULT;
    }

    public abstract int getMaxAttributeValueLength();

    public abstract int getMaxNumberOfAttributes();

    public LogLimitsBuilder toBuilder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LogLimitsBuilder) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new LogLimitsBuilder().setMaxNumberOfAttributes(getMaxNumberOfAttributes()).setMaxAttributeValueLength(getMaxAttributeValueLength());
    }
}
