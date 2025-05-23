package com.tencent.tdf.tdf_flutter.p016native;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0011\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0086 J\u0011\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0086 J\u0011\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0086 \u00a8\u0006\t"}, d2 = {"Lcom/tencent/tdf/tdf_flutter/native/TdfNativeBinding;", "", "()V", "destroyEngine", "", "engineHandle", "", "getShell", "initViewContext", "native_preview_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes26.dex */
public final class TdfNativeBinding {
    static IPatchRedirector $redirector_;

    @NotNull
    public static final TdfNativeBinding INSTANCE;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15576);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new TdfNativeBinding();
        }
    }

    TdfNativeBinding() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final native void destroyEngine(long engineHandle);

    public final native long getShell(long engineHandle);

    public final native long initViewContext(long engineHandle);
}
