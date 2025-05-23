package com.tencent.opentelemetry.sdk.trace;

import com.google.auto.value.AutoValue;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import javax.annotation.concurrent.Immutable;

/* compiled from: P */
/* loaded from: classes22.dex */
public abstract class SpanLimits {
    static IPatchRedirector $redirector_ = null;
    private static final SpanLimits DEFAULT;
    static final int DEFAULT_SPAN_MAX_ATTRIBUTE_LENGTH = Integer.MAX_VALUE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @AutoValue
    @Immutable
    /* loaded from: classes22.dex */
    public static abstract class SpanLimitsValue extends SpanLimits {
        static IPatchRedirector $redirector_;

        /* JADX INFO: Access modifiers changed from: package-private */
        public SpanLimitsValue() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.opentelemetry.sdk.trace.SpanLimits
        public abstract int getMaxAttributeValueLength();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12176);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            DEFAULT = new SpanLimitsBuilder().build();
        }
    }

    public SpanLimits() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static SpanLimitsBuilder builder() {
        return new SpanLimitsBuilder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SpanLimits create(int i3, int i16, int i17, int i18, int i19, int i26) {
        return new AutoValue_SpanLimits_SpanLimitsValue(i3, i16, i17, i18, i19, i26);
    }

    public static SpanLimits getDefault() {
        return DEFAULT;
    }

    public int getMaxAttributeValueLength() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return Integer.MAX_VALUE;
    }

    public abstract int getMaxNumberOfAttributes();

    public abstract int getMaxNumberOfAttributesPerEvent();

    public abstract int getMaxNumberOfAttributesPerLink();

    public abstract int getMaxNumberOfEvents();

    public abstract int getMaxNumberOfLinks();

    public SpanLimitsBuilder toBuilder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (SpanLimitsBuilder) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new SpanLimitsBuilder().setMaxNumberOfAttributes(getMaxNumberOfAttributes()).setMaxNumberOfEvents(getMaxNumberOfEvents()).setMaxNumberOfLinks(getMaxNumberOfLinks()).setMaxNumberOfAttributesPerEvent(getMaxNumberOfAttributesPerEvent()).setMaxNumberOfAttributesPerLink(getMaxNumberOfAttributesPerLink()).setMaxAttributeValueLength(getMaxAttributeValueLength());
    }
}
