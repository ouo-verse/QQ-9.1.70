package com.tencent.raft.measure.log;

import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes25.dex */
public class DefaultLogDelegate implements ILogDelegate {
    static IPatchRedirector $redirector_;

    public DefaultLogDelegate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.raft.measure.log.ILogDelegate
    public void debug(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            Log.d(str, str2);
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
        }
    }

    @Override // com.tencent.raft.measure.log.ILogDelegate
    public void error(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            Log.e(str, str2);
        } else {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) str2);
        }
    }

    @Override // com.tencent.raft.measure.log.ILogDelegate
    public void info(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            Log.i(str, str2);
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) str2);
        }
    }

    @Override // com.tencent.raft.measure.log.ILogDelegate
    public void warn(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            Log.w(str, str2);
        } else {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) str2);
        }
    }

    @Override // com.tencent.raft.measure.log.ILogDelegate
    public void debug(String str, String str2, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            Log.d(str, str2, th5);
        } else {
            iPatchRedirector.redirect((short) 3, this, str, str2, th5);
        }
    }

    @Override // com.tencent.raft.measure.log.ILogDelegate
    public void error(String str, String str2, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            Log.e(str, str2, th5);
        } else {
            iPatchRedirector.redirect((short) 9, this, str, str2, th5);
        }
    }

    @Override // com.tencent.raft.measure.log.ILogDelegate
    public void info(String str, String str2, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            Log.i(str, str2, th5);
        } else {
            iPatchRedirector.redirect((short) 5, this, str, str2, th5);
        }
    }

    @Override // com.tencent.raft.measure.log.ILogDelegate
    public void warn(String str, String str2, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            Log.w(str, str2, th5);
        } else {
            iPatchRedirector.redirect((short) 7, this, str, str2, th5);
        }
    }
}
