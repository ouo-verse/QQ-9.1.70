package com.tencent.qfsmonet.gles;

import android.os.Looper;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qfsmonet.api.MonetContext;

/* compiled from: P */
/* loaded from: classes22.dex */
public class e extends MonetContext {
    static IPatchRedirector $redirector_;

    public e(@NonNull Looper looper, @NonNull b bVar) {
        super(looper, bVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) looper, (Object) bVar);
        }
    }
}
