package mqq.app;

import com.tencent.qphone.base.util.QLog;
import java.lang.Thread;

/* compiled from: P */
/* loaded from: classes28.dex */
public class CrashHandler implements Thread.UncaughtExceptionHandler {
    private boolean isCrahing;

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th5) {
        synchronized (this) {
            if (this.isCrahing) {
                return;
            }
            this.isCrahing = true;
            MobileQQ mobileQQ = MobileQQ.sMobileQQ;
            if (mobileQQ != null) {
                QLog.e("crash", 1, mobileQQ.getQQProcessName() + " has crashed.", th5);
                mobileQQ.closeAllActivities();
                QLog.flushLog();
            }
        }
    }
}
