package com.tencent.mobileqq.transfile.predownload;

import android.os.Handler;
import android.os.Message;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public class RunnableTask extends AbsPreDownloadTask implements Handler.Callback {
    static IPatchRedirector $redirector_;
    private static final int MSG_TASK_END = 0;
    private Runnable mRunnable;
    private Handler mSubHandler;
    private long mTimeoutInterval;

    public RunnableTask(BaseQQAppInterface baseQQAppInterface, String str, Runnable runnable, long j3) {
        super(baseQQAppInterface, str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, baseQQAppInterface, str, runnable, Long.valueOf(j3));
            return;
        }
        this.mRunnable = runnable;
        this.mTimeoutInterval = j3;
        this.mSubHandler = new Handler(ThreadManagerV2.getSubThreadLooper(), this);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) message)).booleanValue();
        }
        if (message.what == 0) {
            this.ctrl.onTaskEnd(this);
            return true;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask
    protected void realCancel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.mSubHandler.removeCallbacks(this.mRunnable);
        }
    }

    @Override // com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask
    protected void realStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.mSubHandler.post(this.mRunnable);
            this.mSubHandler.sendEmptyMessageDelayed(0, this.mTimeoutInterval);
        }
    }

    @Override // com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return super.toString() + "[" + this.mRunnable + ", " + this.mTimeoutInterval + "]";
    }
}
