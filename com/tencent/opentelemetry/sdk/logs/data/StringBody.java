package com.tencent.opentelemetry.sdk.logs.data;

import com.google.auto.value.AutoValue;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.sdk.logs.data.Body;
import javax.annotation.concurrent.Immutable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@AutoValue
@Immutable
/* loaded from: classes22.dex */
public abstract class StringBody implements Body {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StringBody() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Body create(String str) {
        return new AutoValue_StringBody(str);
    }

    @Override // com.tencent.opentelemetry.sdk.logs.data.Body
    public abstract String asString();

    @Override // com.tencent.opentelemetry.sdk.logs.data.Body
    public final Body.Type getType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Body.Type) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return Body.Type.STRING;
    }
}
