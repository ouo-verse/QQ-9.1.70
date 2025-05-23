package hz3;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.raft.standard.storage.IRStorage;

/* compiled from: P */
/* loaded from: classes25.dex */
public final /* synthetic */ class a {
    public static void a(IRStorage iRStorage) {
        IPatchRedirector iPatchRedirector = IRStorage.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) iRStorage);
        }
    }
}
