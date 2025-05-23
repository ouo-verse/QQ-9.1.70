package com.tencent.mobileqq.pluginsdk.ipc;

import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public abstract class RemoteCommand {
    static IPatchRedirector $redirector_ = null;
    public static final String RESULT_KEY = "result_key";
    private String mCmd;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface OnInvokeFinishLinstener {
        void onInvokeFinish(Bundle bundle);
    }

    public RemoteCommand(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        } else {
            this.mCmd = str;
        }
    }

    public String getCmd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mCmd;
    }

    public abstract Bundle invoke(Bundle bundle, OnInvokeFinishLinstener onInvokeFinishLinstener);

    public boolean isSynchronized() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return true;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "[cmd:" + this.mCmd + ", sync:" + isSynchronized() + "]";
    }
}
