package com.tencent.avcore.jni.log;

import com.tencent.avcore.util.AVCoreLog;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class GAClientLogReportJni {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "GAClientLogReport";
    protected final IClientLogReport mImpl;
    protected final boolean mNativeInit;

    public GAClientLogReportJni(IClientLogReport iClientLogReport) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iClientLogReport);
            return;
        }
        this.mImpl = iClientLogReport;
        try {
            cacheMethodIds();
        } catch (Throwable th5) {
            AVCoreLog.e(TAG, "cacheMethodIds fail.", th5);
        }
        try {
            init();
            this.mNativeInit = true;
        } catch (Throwable th6) {
            try {
                AVCoreLog.e(TAG, "inti fail.", th6);
            } finally {
                this.mNativeInit = false;
            }
        }
    }

    private static native void cacheMethodIds();

    private int callbackSendLog(long j3, String str, byte[] bArr) {
        Object valueOf;
        if (AVCoreLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("callbackSendLog, sendUin[");
            sb5.append(j3);
            sb5.append("], topicId[");
            sb5.append(str);
            sb5.append("], log[");
            if (bArr == null) {
                valueOf = "null";
            } else {
                valueOf = Integer.valueOf(bArr.length);
            }
            sb5.append(valueOf);
            sb5.append("]");
            AVCoreLog.i(TAG, sb5.toString());
        }
        IClientLogReport iClientLogReport = this.mImpl;
        if (iClientLogReport != null) {
            return iClientLogReport.sendLog(j3, str, bArr, false);
        }
        return 0;
    }

    private native void init();
}
