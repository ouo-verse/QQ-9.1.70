package com.tencent.mars.sdt;

import com.tencent.mars.app.BaseManager;
import com.tencent.mars.app.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes9.dex */
public class SdtManager extends BaseManager {
    static IPatchRedirector $redirector_;
    private long callbackHandle;
    private long nativeHandle;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface CallBack {
        void reportSignalDetectResults(String str);
    }

    public SdtManager(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, j3);
            return;
        }
        this.nativeHandle = 0L;
        this.callbackHandle = 0L;
        OnJniCreateSdtManagerFromHandle(j3);
    }

    private native void OnJniCreateSdtManagerFromContext(Object obj);

    private native void OnJniCreateSdtManagerFromHandle(long j3);

    private native void OnJniDestroySdtManager();

    private native ArrayList<String> OnJniGetLoadLibraries();

    private native void OnJniSetCallback(Object obj);

    private native void OnJniSetHttpNetCheckCGI(String str);

    public ArrayList<String> getLoadLibraries() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ArrayList) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return OnJniGetLoadLibraries();
    }

    @Override // com.tencent.mars.app.BaseManager
    public long getNativeHandle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return this.nativeHandle;
    }

    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        OnJniDestroySdtManager();
        this.nativeHandle = 0L;
        this.callbackHandle = 0L;
    }

    public void setCallback(CallBack callBack) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) callBack);
        } else {
            OnJniSetCallback(callBack);
        }
    }

    public void setHttpNetCheckCGI(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        } else {
            OnJniSetHttpNetCheckCGI(str);
        }
    }

    public SdtManager(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        this.nativeHandle = 0L;
        this.callbackHandle = 0L;
        OnJniCreateSdtManagerFromContext(context);
    }
}
