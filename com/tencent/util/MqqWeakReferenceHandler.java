package com.tencent.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes27.dex */
public class MqqWeakReferenceHandler extends MqqHandler {
    static IPatchRedirector $redirector_;
    private WeakReference<Handler.Callback> mWeakReferCallBack;

    public MqqWeakReferenceHandler(Handler.Callback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.mWeakReferCallBack = new WeakReference<>(callback);
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) callback);
        }
    }

    @Override // mqq.os.MqqHandler
    public void handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) message);
            return;
        }
        Handler.Callback callback = this.mWeakReferCallBack.get();
        if (callback != null) {
            callback.handleMessage(message);
        }
    }

    @Override // mqq.os.MqqHandler
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return super.toString() + " " + this.mWeakReferCallBack.get();
    }

    public MqqWeakReferenceHandler(Looper looper, Handler.Callback callback) {
        super(looper);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.mWeakReferCallBack = new WeakReference<>(callback);
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) looper, (Object) callback);
        }
    }

    public MqqWeakReferenceHandler(Looper looper, Handler.Callback callback, boolean z16) {
        super(looper, null, z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            this.mWeakReferCallBack = new WeakReference<>(callback);
        } else {
            iPatchRedirector.redirect((short) 3, this, looper, callback, Boolean.valueOf(z16));
        }
    }
}
