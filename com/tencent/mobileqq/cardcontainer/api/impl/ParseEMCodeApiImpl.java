package com.tencent.mobileqq.cardcontainer.api.impl;

import com.tencent.mobileqq.cardcontainer.api.IParseEMCodeApi;
import com.tencent.mobileqq.emoticon.q;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/api/impl/ParseEMCodeApiImpl;", "Lcom/tencent/mobileqq/cardcontainer/api/IParseEMCodeApi;", "()V", "parseEMCodeString", "", "text", "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes11.dex */
public final class ParseEMCodeApiImpl implements IParseEMCodeApi {
    static IPatchRedirector $redirector_;

    public ParseEMCodeApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.cardcontainer.api.IParseEMCodeApi
    @NotNull
    public String parseEMCodeString(@NotNull String text) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) text);
        }
        Intrinsics.checkNotNullParameter(text, "text");
        return q.f204858a.a(text);
    }
}
