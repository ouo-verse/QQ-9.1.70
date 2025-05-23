package com.tencent.rfix.loader.log;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.Keep;
import com.tencent.rfix.loader.thread.RFixThreadPool;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* compiled from: P */
@Keep
/* loaded from: classes25.dex */
public final class RFixLogInlineFence extends Handler {
    public static final int MSG_PRINT_PENDING_LOGS = 240;
    private final Handler mainHandler;
    private final List<Object[]> pendingLogs;

    public RFixLogInlineFence() {
        super(Looper.getMainLooper());
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.pendingLogs = new ArrayList();
    }

    private void dummyThrowExceptionMethod() {
        if (!RFixLogInlineFence.class.isPrimitive()) {
        } else {
            throw new RuntimeException();
        }
    }

    private void handleMessageImpl(Message message) {
        IRFixLog logImpl = RFixLog.getLogImpl();
        boolean isDefaultLogImpl = RFixLog.isDefaultLogImpl();
        int i3 = message.what;
        if (i3 != 2 && i3 != 3 && i3 != 4 && i3 != 5 && i3 != 6) {
            if (i3 == 240) {
                printPendingLogs(logImpl);
                return;
            }
            return;
        }
        Object[] objArr = (Object[]) message.obj;
        printLog(logImpl, objArr, false);
        if (isDefaultLogImpl) {
            synchronized (this.pendingLogs) {
                this.pendingLogs.add(objArr);
            }
        }
    }

    private void handleMessage_$noinline$(Message message) {
        try {
            dummyThrowExceptionMethod();
        } finally {
            handleMessageImpl(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void printLog(IRFixLog iRFixLog, Object[] objArr, boolean z16) {
        if (!printLogCheck(iRFixLog, objArr)) {
            return;
        }
        try {
            int intValue = ((Integer) objArr[0]).intValue();
            long longValue = ((Long) objArr[1]).longValue();
            String str = (String) objArr[2];
            String str2 = (String) objArr[3];
            Throwable th5 = (Throwable) objArr[4];
            if (z16) {
                str2 = ("[PendingLog @ " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.ENGLISH).format(new Date(longValue)) + "] ") + str2;
            }
            if (intValue != 2) {
                if (intValue != 3) {
                    if (intValue != 4) {
                        if (intValue != 5) {
                            if (intValue == 6) {
                                printLogError(iRFixLog, str, str2, th5);
                                return;
                            }
                            return;
                        }
                        printLogWarn(iRFixLog, str, str2, th5);
                        return;
                    }
                    iRFixLog.i(str, str2);
                    return;
                }
                iRFixLog.d(str, str2);
                return;
            }
            iRFixLog.v(str, str2);
        } catch (Exception unused) {
        }
    }

    private boolean printLogCheck(IRFixLog iRFixLog, Object[] objArr) {
        if (iRFixLog != null && objArr != null && objArr.length == 5) {
            return true;
        }
        return false;
    }

    private void printLogError(IRFixLog iRFixLog, String str, String str2, Throwable th5) {
        if (th5 == null) {
            iRFixLog.e(str, str2);
        } else {
            iRFixLog.e(str, str2, th5);
        }
    }

    private void printLogWarn(IRFixLog iRFixLog, String str, String str2, Throwable th5) {
        if (th5 == null) {
            iRFixLog.w(str, str2);
        } else {
            iRFixLog.w(str, str2, th5);
        }
    }

    private void printPendingLogs(final IRFixLog iRFixLog) {
        synchronized (this.pendingLogs) {
            if (iRFixLog != null) {
                if (!this.pendingLogs.isEmpty()) {
                    RFixThreadPool.getInstance().execute(new Runnable() { // from class: com.tencent.rfix.loader.log.RFixLogInlineFence.1
                        @Override // java.lang.Runnable
                        public void run() {
                            synchronized (RFixLogInlineFence.this.pendingLogs) {
                                for (final Object[] objArr : RFixLogInlineFence.this.pendingLogs) {
                                    RFixLogInlineFence.this.mainHandler.post(new Runnable() { // from class: com.tencent.rfix.loader.log.RFixLogInlineFence.1.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                            RFixLogInlineFence.this.printLog(iRFixLog, objArr, true);
                                        }
                                    });
                                }
                                RFixLogInlineFence.this.pendingLogs.clear();
                            }
                        }
                    });
                }
            }
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        handleMessage_$noinline$(message);
    }
}
