package com.tencent.qfsmonet.api;

import android.os.Looper;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qfsmonet.gles.b;

/* compiled from: P */
/* loaded from: classes22.dex */
public abstract class MonetContext {
    static IPatchRedirector $redirector_;
    private b mGLContext;
    private Looper mGLLooper;

    /* JADX INFO: Access modifiers changed from: protected */
    public MonetContext(@NonNull Looper looper, @NonNull b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) looper, (Object) bVar);
        } else {
            this.mGLContext = bVar;
            this.mGLLooper = looper;
        }
    }

    public b context() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (b) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mGLContext;
    }

    public Looper looper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Looper) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mGLLooper;
    }
}
