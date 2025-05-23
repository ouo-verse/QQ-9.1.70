package com.tencent.mars.mmdns;

import com.tencent.mars.app.BaseManager;
import com.tencent.mars.app.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes9.dex */
public class MMDnsManager extends BaseManager {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "mars.MMDnsManager";
    private long callbackHandle;
    private long nativeHandle;

    public MMDnsManager(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, j3);
            return;
        }
        this.nativeHandle = 0L;
        this.callbackHandle = 0L;
        OnJniCreateMMDnsManagerFromHandle(j3);
    }

    private native void OnJniCreateMMDnsManagerFromContext(Object obj);

    private native void OnJniCreateMMDnsManagerFromHandle(long j3);

    private native void OnJniDestroyMMDnsManager();

    private native ArrayList<String> OnJniGetHost(String str);

    private native ArrayList<String> OnJniGetHostWithParam(String str, int i3, boolean z16, int i16);

    private native void OnJniSetDebugIp(String str, int i3);

    private native void OnJniSetForceUserIPv6(boolean z16);

    private native boolean OnJniSyncGetMMDns(String str);

    public ArrayList<String> getHost(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ArrayList) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
        return OnJniGetHost(str);
    }

    public ArrayList<String> getHostWithParam(String str, int i3, boolean z16, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ArrayList) iPatchRedirector.redirect((short) 7, this, str, Integer.valueOf(i3), Boolean.valueOf(z16), Integer.valueOf(i16));
        }
        return OnJniGetHostWithParam(str, i3, z16, i16);
    }

    @Override // com.tencent.mars.app.BaseManager
    public long getNativeHandle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
        return this.nativeHandle;
    }

    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        OnJniDestroyMMDnsManager();
        this.nativeHandle = 0L;
        this.callbackHandle = 0L;
    }

    public void setDebugIp(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, i3);
        } else {
            OnJniSetDebugIp(str, i3);
        }
    }

    public void setForceUserIPv6(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
        } else {
            OnJniSetForceUserIPv6(z16);
        }
    }

    public boolean syncGetMMDns(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str)).booleanValue();
        }
        return OnJniSyncGetMMDns(str);
    }

    public MMDnsManager(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        this.nativeHandle = 0L;
        this.callbackHandle = 0L;
        OnJniCreateMMDnsManagerFromContext(context);
    }
}
