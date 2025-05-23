package com.tencent.freesia;

import androidx.annotation.Nullable;
import com.tencent.freesia.Tack;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes6.dex */
public final /* synthetic */ class d {
    @Nullable
    public static Tack a() {
        IPatchRedirector iPatchRedirector = Tack.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (Tack) iPatchRedirector.redirect((short) 1);
        }
        return Tack.CppProxy.getInstance();
    }
}
