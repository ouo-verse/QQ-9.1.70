package com.tencent.soter.wrapper.wrap_task;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.soter.core.model.SLogger;
import com.tencent.soter.wrapper.wrap_callback.SoterProcessCallback;
import com.tencent.soter.wrapper.wrap_callback.SoterProcessResultBase;
import com.tencent.soter.wrapper.wrap_core.SoterProcessErrCode;

/* compiled from: P */
/* loaded from: classes25.dex */
public abstract class BaseSoterTask implements SoterProcessErrCode {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "Soter.BaseSoterTask";
    private SoterProcessCallback mCallback;
    private boolean mIsCallbacked;

    public BaseSoterTask() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mIsCallbacked = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackInternal(SoterProcessResultBase soterProcessResultBase) {
        SoterProcessCallback soterProcessCallback = this.mCallback;
        if (soterProcessCallback != null && !this.mIsCallbacked) {
            soterProcessCallback.onResult(soterProcessResultBase);
            this.mIsCallbacked = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void callback(SoterProcessResultBase soterProcessResultBase) {
        if (this.mIsCallbacked) {
            SLogger.w(TAG, "soter: warning: already removed the task!", new Object[0]);
            return;
        }
        onExecuteCallback(soterProcessResultBase);
        SoterTaskManager.getInstance().removeFromTask(this);
        SoterTaskThread.getInstance().postToMainThread(new Runnable(soterProcessResultBase) { // from class: com.tencent.soter.wrapper.wrap_task.BaseSoterTask.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ SoterProcessResultBase val$result;

            {
                this.val$result = soterProcessResultBase;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) BaseSoterTask.this, (Object) soterProcessResultBase);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    BaseSoterTask.this.callbackInternal(this.val$result);
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void execute();

    public boolean isFinished() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.mIsCallbacked;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean isSingleInstance();

    abstract void onExecuteCallback(SoterProcessResultBase soterProcessResultBase);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void onRemovedFromTaskPoolActively();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean preExecute();

    public void setTaskCallback(SoterProcessCallback soterProcessCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) soterProcessCallback);
        } else {
            this.mCallback = soterProcessCallback;
        }
    }
}
