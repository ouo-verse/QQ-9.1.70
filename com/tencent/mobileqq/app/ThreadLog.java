package com.tencent.mobileqq.app;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ThreadLog {
    static IPatchRedirector $redirector_;

    public ThreadLog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean isColorLevel() {
        ThreadWrapContext threadWrapContext = ThreadManagerV2.sThreadWrapContext;
        if (threadWrapContext != null && threadWrapContext.isColorLevel()) {
            return true;
        }
        return false;
    }

    public static boolean needRecordJob() {
        if (needReportRunOrBlocking()) {
            return true;
        }
        ThreadWrapContext threadWrapContext = ThreadManagerV2.sThreadWrapContext;
        if (threadWrapContext != null) {
            return threadWrapContext.isShotReportRejectedError();
        }
        return false;
    }

    public static boolean needReportRunOrBlocking() {
        if (!ThreadSetting.isPublicVersion && ThreadSetting.sProcessId == ThreadSetting.PROCESS_QQ) {
            return true;
        }
        return false;
    }

    public static void printQLog(String str, String str2) {
        printQLog(str, str2, null);
    }

    public static void trackException(String str, String str2) {
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(str2);
        new Handler(Looper.getMainLooper()).post(new Runnable(str, illegalArgumentException) { // from class: com.tencent.mobileqq.app.ThreadLog.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ IllegalArgumentException val$ex;
            final /* synthetic */ String val$tag;

            {
                this.val$tag = str;
                this.val$ex = illegalArgumentException;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) illegalArgumentException);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    ThreadLog.printQLog(this.val$tag, "ExceptinTracker", this.val$ex);
                    throw new IllegalArgumentException(this.val$ex);
                }
            }
        });
        throw illegalArgumentException;
    }

    public static void printQLog(String str, String str2, Throwable th5) {
        if (isColorLevel()) {
            ThreadManagerV2.sThreadWrapContext.d(str, ThreadSetting.CLR, str2, th5);
        }
    }
}
