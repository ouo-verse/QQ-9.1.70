package com.tencent.mars.app;

import com.tencent.mars.app.AppLogic;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes9.dex */
public class AppManager extends BaseManager {
    static IPatchRedirector $redirector_;
    private long callbackHandle;
    private long nativeHandle;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface CallBack {
        AppLogic.AccountInfo getAccountInfo();

        String getAppFilePath();

        String getClientConfig(String str, String str2);

        int getClientVersion();

        AppLogic.DeviceInfo getDeviceType();
    }

    public AppManager(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, j3);
            return;
        }
        this.nativeHandle = 0L;
        this.callbackHandle = 0L;
        OnJniCreateAppManagerFromHandle(j3);
    }

    private native void OnJniCreateAppManagerFromContext(Object obj);

    private native void OnJniCreateAppManagerFromHandle(long j3);

    private native void OnJniDestroyAppManager();

    private native void OnJniSetCallback(Object obj);

    private native void OnJniSetConfigBooleanValue(String str, boolean z16);

    private native void OnJniSetConfigIntValue(String str, int i3);

    private native void OnJniSetConfigStringValue(String str, String str2);

    public void SetConfigBooleanValue(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, Boolean.valueOf(z16));
        } else {
            OnJniSetConfigBooleanValue(str, z16);
        }
    }

    public void SetConfigIntValue(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, i3);
        } else {
            OnJniSetConfigIntValue(str, i3);
        }
    }

    public void SetConfigStringValue(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) str2);
        } else {
            OnJniSetConfigStringValue(str, str2);
        }
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
        OnJniDestroyAppManager();
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

    public AppManager(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        this.nativeHandle = 0L;
        this.callbackHandle = 0L;
        OnJniCreateAppManagerFromContext(context);
    }
}
