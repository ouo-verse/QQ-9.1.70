package cz3;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes25.dex */
public final /* synthetic */ class a {
    public static void a(b bVar, com.tencent.qui.video.floatingview.a aVar) {
        IPatchRedirector iPatchRedirector = b.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) bVar, (Object) aVar);
        }
    }
}
