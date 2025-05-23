package com.tencent.mobileqq.highway.netprobe;

import com.tencent.mobileqq.highway.netprobe.ProbeItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes9.dex */
public class EchoProbe extends ProbeItem {
    static IPatchRedirector $redirector_ = null;
    public static final String PROBE_NAME = "Echo_Probe";
    public static final int RESULT_EXCEPTION = 1;
    public static final int RESULT_NOT_MATCH = 2;
    private EchoTask mEchoTask;

    public EchoProbe() {
        this(1);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private void onFinish(int i3) {
        ProbeItem.ProbeResult probeResult = this.mResult;
        probeResult.success = false;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    probeResult.errDesc = "probe has error:" + this.mEchoTask.getErrorMsg();
                    this.mResult.errCode = 1;
                    return;
                }
                return;
            }
            probeResult.errDesc = "echo response error,resposne url:" + this.mEchoTask.getResponseUrl();
            this.mResult.errCode = 2;
            return;
        }
        probeResult.success = true;
        probeResult.appendResult("echo response is normal!");
    }

    @Override // com.tencent.mobileqq.highway.netprobe.ProbeItem
    public void doProbe() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            onFinish(this.mEchoTask.doEcho());
        }
    }

    @Override // com.tencent.mobileqq.highway.netprobe.ProbeItem
    public String getProbeName() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        int i3 = this.mEchoTask.mType;
        if (i3 == 1) {
            str = "GET_";
        } else if (i3 == 2) {
            str = "POST_";
        } else {
            str = "";
        }
        return str + PROBE_NAME;
    }

    public EchoProbe(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.mEchoTask = new EchoTask(WeakNetLearner.mContext, i3);
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
    }
}
