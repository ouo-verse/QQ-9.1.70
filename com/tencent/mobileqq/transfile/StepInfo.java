package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public class StepInfo {
    static IPatchRedirector $redirector_ = null;
    public static final int STEP_MSG_URL_DOWN = 4;
    public static final int STEP_NOTIFY = 3;
    public static final int STEP_SIG = 0;
    public static final int STEP_TRANS = 2;
    public static final int STEP_URL = 1;
    public int failTryCount;
    public long finishTime;
    public int result;
    public long startTime;
    public int successTryCount;

    public StepInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.result = -1;
        this.startTime = 0L;
        this.finishTime = 0L;
        this.successTryCount = 0;
        this.failTryCount = 0;
    }

    public void fixAtPttPreSend(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, j3);
        } else if (j3 >= this.finishTime) {
            this.startTime = 0L;
        } else if (j3 > this.startTime) {
            this.startTime = j3;
        }
    }

    public String getReportInfo(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, i3);
        }
        long j3 = 0;
        if (this.result != -1) {
            long j16 = this.startTime;
            if (j16 != 0) {
                long j17 = this.finishTime;
                if (j17 != 0) {
                    j3 = (j17 - j16) / 1000000;
                }
            }
        }
        return i3 + "_" + this.result + "_" + this.successTryCount + "_" + this.failTryCount + "_" + j3;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long getTimeConsume() {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
        }
        long j16 = this.startTime;
        if (j16 != 0) {
            long j17 = this.finishTime;
            if (j17 != 0) {
                j3 = (j17 - j16) / 1000000;
                if (j3 >= 0) {
                    return 0L;
                }
                return j3;
            }
        }
        j3 = 0;
        if (j3 >= 0) {
        }
    }

    public void logFinishTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        long nanoTime = System.nanoTime();
        if (nanoTime > this.finishTime) {
            this.finishTime = nanoTime;
        }
    }

    public void logStartTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else if (this.startTime == 0) {
            this.startTime = System.nanoTime();
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("startTime: ");
        stringBuffer.append(this.startTime);
        stringBuffer.append(" finishTime: ");
        stringBuffer.append(this.finishTime);
        return stringBuffer.toString();
    }
}
