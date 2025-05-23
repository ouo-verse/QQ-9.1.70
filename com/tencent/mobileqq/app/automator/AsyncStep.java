package com.tencent.mobileqq.app.automator;

import android.os.SystemClock;
import com.tencent.mobileqq.app.automator.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class AsyncStep<T extends b> implements Runnable {
    static IPatchRedirector $redirector_ = null;
    private static final int RESULT_EMPTY = 1;
    public static final int RESULT_FAIL = 6;
    public static final int RESULT_INTERRUPTED = 8;
    public static final int RESULT_NET_CONNECT = 4;
    public static final int RESULT_OK = 7;
    public static final int RESULT_TIMEOUT = 5;
    private static final int RESULT_UPDATE_TIMEOUT = 3;
    public static final int RESULT_WAITING = 2;
    protected static final String TAG = "IAutomator";
    protected static final long TIMEOUT_DEFAULT = 30000;
    public T mAutomator;
    protected int mCountRetry;
    public String mName;
    public Object[] mParams;
    protected volatile int mResult;
    public c mResultListener;
    private Object mResultLock;
    public int mStepId;
    public e mStepListener;
    protected long mTimeout;

    public AsyncStep() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mResult = 1;
        this.mTimeout = 30000L;
        this.mStepId = -1;
        this.mCountRetry = 0;
        this.mResultLock = new Object();
    }

    private boolean waitResult() {
        while (true) {
            synchronized (this.mResultLock) {
                if (this.mResult == 2) {
                    try {
                        this.mResultLock.wait(this.mTimeout);
                    } catch (InterruptedException e16) {
                        e16.printStackTrace();
                    }
                }
                if (QLog.isDevelopLevel()) {
                    QLog.d(tag(), 4, this.mName + "[" + this.mStepId + "] waitResult " + this.mResult + " " + this.mCountRetry);
                }
                if (this.mResult != 3) {
                    break;
                }
                this.mResult = 2;
            }
        }
        if (this.mResult == 2) {
            this.mResult = 5;
            T t16 = this.mAutomator;
            if (t16 != null) {
                t16.E();
            }
        }
        if (this.mResult == 6 || this.mResult == 5) {
            int i3 = this.mCountRetry;
            this.mCountRetry = i3 - 1;
            if (i3 > 0) {
                this.mResult = 1;
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int doStep() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        if (QLog.isColorLevel()) {
            QLog.e(tag(), 2, this.mName + " AsyncStep.doStep()");
        }
        return 7;
    }

    public void onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        }
    }

    /* JADX WARN: Finally extract failed */
    @Override // java.lang.Runnable
    public final void run() {
        c cVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (this.mResult == 1) {
            long uptimeMillis = SystemClock.uptimeMillis();
            T t16 = this.mAutomator;
            if (t16 != null && t16.S()) {
                QLog.d(tag(), 1, this.mName + "[" + this.mStepId + "] begin with " + this.mResult);
            }
            try {
                onCreate();
                do {
                    setResult(doStep());
                } while (waitResult());
                onDestroy();
                T t17 = this.mAutomator;
                if (t17 != null && t17.S()) {
                    QLog.d(tag(), 1, this.mName + "[" + this.mStepId + "] cost: " + (SystemClock.uptimeMillis() - uptimeMillis));
                }
                cVar = this.mResultListener;
                if (cVar == null) {
                    return;
                }
            } catch (Throwable th5) {
                try {
                    T t18 = this.mAutomator;
                    if (t18 != null && t18.Q()) {
                        throw new RuntimeException(th5);
                    }
                    QLog.e(tag(), 1, "", th5);
                    setResult(8);
                    T t19 = this.mAutomator;
                    if (t19 != null && t19.S()) {
                        QLog.d(tag(), 1, this.mName + "[" + this.mStepId + "] cost: " + (SystemClock.uptimeMillis() - uptimeMillis));
                    }
                    cVar = this.mResultListener;
                    if (cVar == null) {
                        return;
                    }
                } catch (Throwable th6) {
                    T t26 = this.mAutomator;
                    if (t26 != null && t26.S()) {
                        QLog.d(tag(), 1, this.mName + "[" + this.mStepId + "] cost: " + (SystemClock.uptimeMillis() - uptimeMillis));
                    }
                    c cVar2 = this.mResultListener;
                    if (cVar2 != null) {
                        cVar2.a(this, this.mResult);
                    }
                    throw th6;
                }
            }
            cVar.a(this, this.mResult);
        }
    }

    public void setResult(int i3) {
        T t16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(tag(), 4, this.mName + "[" + this.mStepId + "] setResult " + i3 + ", when " + this.mResult);
        }
        if (i3 == 6 && (t16 = this.mAutomator) != null) {
            t16.E();
        }
        synchronized (this.mResultLock) {
            if (i3 > this.mResult && i3 != 4) {
                this.mResult = i3;
            }
            this.mResultLock.notifyAll();
        }
    }

    protected String tag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        T t16 = this.mAutomator;
        if (t16 == null) {
            return TAG;
        }
        return t16.getTag();
    }

    public final void updateTimeout(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, j3);
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder(64);
            sb5.append(this.mName);
            sb5.append("[");
            sb5.append(this.mStepId);
            sb5.append("]");
            sb5.append(" updateTimeout ");
            sb5.append(j3);
            sb5.append(", when ");
            sb5.append(this.mResult);
            QLog.d(tag(), 2, sb5.toString());
        }
        synchronized (this.mResultLock) {
            if (this.mResult == 2) {
                this.mResult = 3;
            }
            this.mTimeout = j3;
            this.mResultLock.notifyAll();
        }
    }
}
