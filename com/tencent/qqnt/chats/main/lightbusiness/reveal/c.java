package com.tencent.qqnt.chats.main.lightbusiness.reveal;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.adapter.api.IAIOTofuApi;
import com.tencent.qqnt.kernel.nativeinterface.UIConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/chats/main/lightbusiness/reveal/c;", "Lcx3/a;", "Lcom/tencent/qqnt/kernel/nativeinterface/UIConfig;", "configParam", "", "a", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class c implements cx3.a {
    static IPatchRedirector $redirector_;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // cx3.a
    @NotNull
    public String a(@NotNull UIConfig configParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) configParam);
        }
        Intrinsics.checkNotNullParameter(configParam, "configParam");
        return ((IAIOTofuApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOTofuApi.class)).getConfig();
    }
}
