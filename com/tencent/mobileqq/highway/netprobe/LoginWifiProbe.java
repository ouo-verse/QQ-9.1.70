package com.tencent.mobileqq.highway.netprobe;

import com.tencent.mobileqq.highway.netprobe.ProbeItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes9.dex */
public class LoginWifiProbe extends ProbeItem {
    static IPatchRedirector $redirector_ = null;
    public static final String PROBE_NAME = "LoginWifi_Probe";
    public final int RESULT_ECHO_NORMAL;
    public final int RESULT_NEED_LOGIN;
    public final int RESULT_NO_WIFI;
    public final int RESULT_UNSPECT_EXCEPTION;
    private EchoTask echoTask;

    public LoginWifiProbe() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.RESULT_ECHO_NORMAL = 0;
        this.RESULT_NO_WIFI = 1;
        this.RESULT_NEED_LOGIN = 2;
        this.RESULT_UNSPECT_EXCEPTION = 3;
    }

    @Override // com.tencent.mobileqq.highway.netprobe.ProbeItem
    public void doProbe() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        EchoTask echoTask = new EchoTask(WeakNetLearner.mContext);
        this.echoTask = echoTask;
        int doEcho = echoTask.doEcho();
        if (doEcho != 1) {
            if (doEcho != 2) {
                if (doEcho == 3) {
                    onFinish(3, this.echoTask.getErrorMsg());
                    return;
                }
                return;
            }
            onFinish(2, this.echoTask.getResponseUrl());
            return;
        }
        onFinish(0, null);
    }

    @Override // com.tencent.mobileqq.highway.netprobe.ProbeItem
    public String getProbeName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return PROBE_NAME;
    }

    public void onFinish(int i3, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3, obj);
            return;
        }
        ProbeItem.ProbeResult probeResult = this.mResult;
        probeResult.errCode = i3;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        probeResult.success = false;
                        probeResult.errDesc = "the echo test has some exception:" + ((String) obj);
                        return;
                    }
                    return;
                }
                probeResult.success = false;
                probeResult.errDesc = "the wifi need to login , the login-url:" + obj;
                return;
            }
            probeResult.success = true;
            probeResult.appendResult("the network type is not wifi!");
            return;
        }
        probeResult.success = true;
        probeResult.appendResult("echo function is normal , wifi maybe is good !");
    }
}
