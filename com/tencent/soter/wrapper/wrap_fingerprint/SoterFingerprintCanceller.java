package com.tencent.soter.wrapper.wrap_fingerprint;

import android.annotation.SuppressLint;
import android.os.CancellationSignal;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.soter.core.model.SLogger;
import com.tencent.soter.wrapper.wrap_task.SoterTaskManager;
import com.tencent.soter.wrapper.wrap_task.SoterTaskThread;

/* compiled from: P */
@Deprecated
/* loaded from: classes25.dex */
public class SoterFingerprintCanceller {
    static IPatchRedirector $redirector_ = null;
    private static final long MAX_WAIT_EXECUTION_TIME = 350;
    private static final String TAG = "Soter.SoterFingerprintCanceller";
    private CancellationSignal mCancellationSignal;

    /* compiled from: P */
    /* renamed from: com.tencent.soter.wrapper.wrap_fingerprint.SoterFingerprintCanceller$1, reason: invalid class name */
    /* loaded from: classes25.dex */
    class AnonymousClass1 implements Runnable {
        static IPatchRedirector $redirector_;
        final /* synthetic */ boolean val$shouldPublishCancel;

        AnonymousClass1(boolean z16) {
            this.val$shouldPublishCancel = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, SoterFingerprintCanceller.this, Boolean.valueOf(z16));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            SLogger.v(SoterFingerprintCanceller.TAG, "soter: enter worker thread. perform cancel", new Object[0]);
            SoterFingerprintCanceller.this.mCancellationSignal.cancel();
            if (this.val$shouldPublishCancel) {
                SoterFingerprintCanceller.this.publishCancel();
            }
        }
    }

    public SoterFingerprintCanceller() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mCancellationSignal = null;
            refreshCancellationSignal();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void publishCancel() {
        SoterTaskManager.getInstance().publishAuthCancellation();
    }

    public boolean asyncCancelFingerprintAuthentication() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return asyncCancelFingerprintAuthenticationInnerImp(true);
    }

    @SuppressLint({"NewApi"})
    public boolean asyncCancelFingerprintAuthenticationInnerImp(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, z16)).booleanValue();
        }
        SLogger.v(TAG, "soter: publishing cancellation. should publish: %b", Boolean.valueOf(z16));
        if (!this.mCancellationSignal.isCanceled()) {
            SoterTaskThread.getInstance().postToWorker(new Runnable() { // from class: com.tencent.soter.wrapper.wrap_fingerprint.SoterFingerprintCanceller.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SoterFingerprintCanceller.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        SoterFingerprintCanceller.this.mCancellationSignal.cancel();
                    }
                }
            });
            SoterTaskThread.getInstance().postToWorkerDelayed(new Runnable() { // from class: com.tencent.soter.wrapper.wrap_fingerprint.SoterFingerprintCanceller.3
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SoterFingerprintCanceller.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        SLogger.w(SoterFingerprintCanceller.TAG, "hy: waiting for %s ms not callback to system callback. cancel manually", 350L);
                        SoterFingerprintCanceller.this.publishCancel();
                    }
                }
            }, 350L);
            return true;
        }
        SLogger.i(TAG, "soter: cancellation signal already expired.", new Object[0]);
        return false;
    }

    @NonNull
    public CancellationSignal getSignalObj() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (CancellationSignal) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mCancellationSignal;
    }

    @SuppressLint({"NewApi"})
    public void refreshCancellationSignal() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.mCancellationSignal = new CancellationSignal();
        }
    }
}
