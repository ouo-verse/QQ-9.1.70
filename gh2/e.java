package gh2;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public final /* synthetic */ class e {
    public static void a(f fVar) {
        IPatchRedirector iPatchRedirector = f.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) fVar);
        }
    }
}
