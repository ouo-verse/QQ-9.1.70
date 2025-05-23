package com.tencent.opentelemetry.sdk.trace.data;

import com.google.auto.value.AutoValue;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.Attributes;
import javax.annotation.concurrent.Immutable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@AutoValue
@Immutable
/* loaded from: classes22.dex */
public abstract class ImmutableEventData implements EventData {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableEventData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static EventData create(long j3, String str, Attributes attributes) {
        return create(j3, str, attributes, attributes.size());
    }

    @Override // com.tencent.opentelemetry.sdk.trace.data.EventData
    public /* synthetic */ int getDroppedAttributesCount() {
        return a.a(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static EventData create(long j3, String str, Attributes attributes, int i3) {
        return new AutoValue_ImmutableEventData(str, attributes, j3, i3);
    }
}
