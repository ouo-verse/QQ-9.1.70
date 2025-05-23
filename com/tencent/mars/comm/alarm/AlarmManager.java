package com.tencent.mars.comm.alarm;

import com.tencent.mars.app.BaseManager;
import com.tencent.mars.app.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes9.dex */
public class AlarmManager extends BaseManager {
    static IPatchRedirector $redirector_;
    private long callbackHandle;
    private long nativeHandle;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface CallBack {
        boolean startAlarm(int i3, int i16, int i17);

        boolean stopAlarm(int i3);
    }

    public AlarmManager(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, j3);
            return;
        }
        this.nativeHandle = 0L;
        this.callbackHandle = 0L;
        OnJniCreateAlarmManagerFromHandle(j3);
    }

    private native void OnJniCreateAlarmManagerFromContext(Object obj);

    private native void OnJniCreateAlarmManagerFromHandle(long j3);

    private native void OnJniDestroyAlarmManager();

    private native void OnJniSetCallback(Object obj);

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
        OnJniDestroyAlarmManager();
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

    public AlarmManager(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        this.nativeHandle = 0L;
        this.callbackHandle = 0L;
        OnJniCreateAlarmManagerFromContext(context);
    }
}
