package com.tencent.opentelemetry.sdk.logs;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.internal.Utils;

/* compiled from: P */
/* loaded from: classes22.dex */
public class LogLimitsBuilder {
    static IPatchRedirector $redirector_ = null;
    private static final int DEFAULT_LOG_MAX_ATTRIBUTE_LENGTH = Integer.MAX_VALUE;
    private static final int DEFAULT_LOG_MAX_NUM_ATTRIBUTES = 128;
    private int maxAttributeValueLength;
    private int maxNumAttributes;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LogLimitsBuilder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.maxNumAttributes = 128;
            this.maxAttributeValueLength = Integer.MAX_VALUE;
        }
    }

    public LogLimits build() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (LogLimits) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return LogLimits.create(this.maxNumAttributes, this.maxAttributeValueLength);
    }

    public LogLimitsBuilder setMaxAttributeValueLength(int i3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (LogLimitsBuilder) iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
        if (i3 > -1) {
            z16 = true;
        } else {
            z16 = false;
        }
        Utils.checkArgument(z16, "maxAttributeValueLength must be non-negative");
        this.maxAttributeValueLength = i3;
        return this;
    }

    public LogLimitsBuilder setMaxNumberOfAttributes(int i3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LogLimitsBuilder) iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
        if (i3 > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        Utils.checkArgument(z16, "maxNumberOfAttributes must be greater than 0");
        this.maxNumAttributes = i3;
        return this;
    }
}
