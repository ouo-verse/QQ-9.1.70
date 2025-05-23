package com.tencent.mobileqq.pluginsdk.exception;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class ExceptionTracker {
    static IPatchRedirector $redirector_;

    public ExceptionTracker() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void printCallStack(String str) {
        printCallStack(str, 1);
    }

    public static void trackException(String str, String str2) {
        printCallStack(str, 1);
        try {
            throw new IllegalArgumentException(str2);
        } catch (Exception e16) {
            new Handler(Looper.getMainLooper()).post(new Runnable(str, e16) { // from class: com.tencent.mobileqq.pluginsdk.exception.ExceptionTracker.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Exception val$ex;
                final /* synthetic */ String val$tag;

                {
                    this.val$tag = str;
                    this.val$ex = e16;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) e16);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        if (QLog.isColorLevel()) {
                            QLog.e(this.val$tag, 2, "ExceptinTracker", this.val$ex);
                        }
                        throw new IllegalArgumentException(this.val$ex);
                    }
                }
            });
            throw new IllegalArgumentException(e16);
        }
    }

    public static void printCallStack(String str, int i3) {
        int i16 = i3 + 3;
        try {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            if (stackTrace != null && stackTrace.length > i16) {
                if (QLog.isColorLevel()) {
                    QLog.d(str, 2, "printCallStack:");
                }
                while (i16 < stackTrace.length) {
                    if (QLog.isColorLevel()) {
                        QLog.d(str, 2, "" + stackTrace[i16]);
                    }
                    i16++;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(str, 2, "printCallStack empty");
            }
        } catch (Throwable unused) {
        }
    }
}
