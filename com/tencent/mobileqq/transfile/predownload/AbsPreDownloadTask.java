package com.tencent.mobileqq.transfile.predownload;

import android.os.Handler;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes19.dex */
public abstract class AbsPreDownloadTask {
    static IPatchRedirector $redirector_ = null;
    static final String TAG = "PreDownload.Task";
    protected BaseQQAppInterface app;
    protected IPreDownloadController ctrl;
    public String key;
    protected Handler subHandler;
    public Object userData;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbsPreDownloadTask(BaseQQAppInterface baseQQAppInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseQQAppInterface, (Object) str);
            return;
        }
        this.key = str;
        this.app = baseQQAppInterface;
        this.ctrl = (IPreDownloadController) baseQQAppInterface.getRuntimeService(IPreDownloadController.class);
        this.subHandler = new Handler(ThreadManagerV2.getSubThreadLooper());
    }

    public final void cancel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.subHandler.post(new Runnable() { // from class: com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AbsPreDownloadTask.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        AbsPreDownloadTask.this.realCancel();
                    }
                }
            });
        }
    }

    protected abstract void realCancel();

    protected abstract void realStart();

    public final void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.subHandler.post(new Runnable() { // from class: com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AbsPreDownloadTask.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        AbsPreDownloadTask.this.realStart();
                    }
                }
            });
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return super.toString() + "[" + this.key + "]";
    }
}
