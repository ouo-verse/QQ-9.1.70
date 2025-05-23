package com.tencent.weiyun.transmission.utils.handler;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class CntHandler extends Handler {
    static IPatchRedirector $redirector_;
    private DispatchCallback mCallback;

    public CntHandler(Looper looper, DispatchCallback dispatchCallback) {
        super(looper);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.mCallback = dispatchCallback;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) looper, (Object) dispatchCallback);
        }
    }

    @Override // android.os.Handler
    public void dispatchMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) message);
            return;
        }
        super.dispatchMessage(message);
        DispatchCallback dispatchCallback = this.mCallback;
        if (dispatchCallback != null) {
            dispatchCallback.dispatchMsgFinished(message);
        }
    }

    public CntHandler(Looper looper, Handler.Callback callback, DispatchCallback dispatchCallback) {
        super(looper, callback);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.mCallback = dispatchCallback;
        } else {
            iPatchRedirector.redirect((short) 2, this, looper, callback, dispatchCallback);
        }
    }
}
