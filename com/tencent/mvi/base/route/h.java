package com.tencent.mvi.base.route;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes21.dex */
public final /* synthetic */ class h {
    @Nullable
    public static String a(i iVar) {
        IPatchRedirector iPatchRedirector = i.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (String) iPatchRedirector.redirect((short) 1, (Object) iVar);
        }
        return null;
    }
}
