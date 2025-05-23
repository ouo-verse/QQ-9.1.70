package com.tencent.opentelemetry.api.baggage;

import com.google.auto.value.AutoValue;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import javax.annotation.concurrent.Immutable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@AutoValue
@Immutable
/* loaded from: classes22.dex */
public abstract class ImmutableEntryMetadata implements BaggageEntryMetadata {
    static IPatchRedirector $redirector_;
    static final ImmutableEntryMetadata EMPTY;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15902);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            EMPTY = create("");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableEntryMetadata() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ImmutableEntryMetadata create(String str) {
        if (str == null) {
            return EMPTY;
        }
        return new AutoValue_ImmutableEntryMetadata(str);
    }

    @Override // com.tencent.opentelemetry.api.baggage.BaggageEntryMetadata
    public abstract String getValue();
}
