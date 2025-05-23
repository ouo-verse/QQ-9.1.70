package com.tencent.mvi.base.route;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes21.dex */
public final /* synthetic */ class f {
    @Nullable
    public static Set a(g gVar) {
        IPatchRedirector iPatchRedirector = g.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (Set) iPatchRedirector.redirect((short) 1, (Object) gVar);
        }
        return null;
    }

    @Nullable
    public static Set b(g gVar) {
        IPatchRedirector iPatchRedirector = g.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Set) iPatchRedirector.redirect((short) 2, (Object) gVar);
        }
        return null;
    }
}
