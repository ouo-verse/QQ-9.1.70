package com.tencent.qui.video.floatingview.view;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes25.dex */
public final /* synthetic */ class a {
    public static void a(b bVar, boolean z16) {
        IPatchRedirector iPatchRedirector = b.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) bVar, z16);
        }
    }

    public static void b(b bVar, boolean z16) {
        IPatchRedirector iPatchRedirector = b.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) bVar, z16);
        }
    }
}
