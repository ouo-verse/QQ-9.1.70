package com.tencent.mars.comm;

import android.content.Context;
import android.os.PowerManager;
import com.tencent.luggage.wxa.tn.b0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.wa.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes9.dex */
public class WakerLock {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "MicroMsg.WakerLock";
    private static long lastChecktime = 0;
    private static boolean sReentrantGuard = true;
    private static Boolean shouldLock;
    private IAutoUnlockCallback autoUnlockCallback;
    private Context context;
    private String mCreatePosStackLine;
    private b0 mHandler;
    private Runnable mReleaser;
    private PowerManager.WakeLock wakeLock;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface IAutoUnlockCallback {
        void autoUnlockCallback();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59120);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        }
    }

    public WakerLock(Context context, String str, IAutoUnlockCallback iAutoUnlockCallback) {
        this(context, str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.autoUnlockCallback = iAutoUnlockCallback;
        } else {
            iPatchRedirector.redirect((short) 1, this, context, str, iAutoUnlockCallback);
        }
    }

    private String getCallerStack() {
        for (StackTraceElement stackTraceElement : new Throwable().getStackTrace()) {
            if (!stackTraceElement.getClassName().contains(WakerLock.class.getName())) {
                return stackTraceElement.toString();
            }
        }
        return "<native>";
    }

    public static void setReentrantGuard(boolean z16) {
        sReentrantGuard = z16;
    }

    public void finalize() throws Throwable {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        w.d(TAG, "finalize unlock [%d,%d] @[%s]", Integer.valueOf(hashCode()), Integer.valueOf(this.wakeLock.hashCode()), this.mCreatePosStackLine);
        unLock();
        super.finalize();
    }

    public String getCreatePosStackLine() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mCreatePosStackLine;
    }

    public int innerWakeLockHashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return this.wakeLock.hashCode();
    }

    public boolean isLocking() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        try {
            boolean isHeld = this.wakeLock.isHeld();
            w.d(TAG, "check is held [%d,%d] :%b caller:[%s] @[%s]", Integer.valueOf(hashCode()), Integer.valueOf(this.wakeLock.hashCode()), Boolean.valueOf(isHeld), getCallerStack(), getCreatePosStackLine());
            return isHeld;
        } catch (Exception e16) {
            w.a(TAG, e16, "", "");
            return false;
        }
    }

    public void lock(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            lock(j3, getCallerStack());
        } else {
            iPatchRedirector.redirect((short) 7, (Object) this, j3);
        }
    }

    public void unLock() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        if (this.wakeLock.isHeld()) {
            this.mHandler.b(this.mReleaser);
            a.a(this);
            w.d(TAG, "unlock [%d,%d] caller:[%s] @[%s]", Integer.valueOf(hashCode()), Integer.valueOf(this.wakeLock.hashCode()), getCallerStack(), getCreatePosStackLine());
            try {
                this.wakeLock.release();
            } catch (Exception e16) {
                w.a(TAG, e16, "", "");
            }
        }
    }

    public void lock() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            lock(getCallerStack());
        } else {
            iPatchRedirector.redirect((short) 8, (Object) this);
        }
    }

    public WakerLock(Context context, String str) {
        this(context, str, 1);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) str);
    }

    public void lock(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            lock(-1L, str);
        } else {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        }
    }

    public WakerLock(Context context, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, str, Integer.valueOf(i3));
            return;
        }
        this.mCreatePosStackLine = null;
        this.wakeLock = null;
        this.mHandler = null;
        this.autoUnlockCallback = null;
        this.mReleaser = new Runnable() { // from class: com.tencent.mars.comm.WakerLock.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) WakerLock.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (WakerLock.this.wakeLock.isHeld()) {
                    w.h(WakerLock.TAG, "unlock by timeout handler! [%d,%d] @[%s]", Integer.valueOf(WakerLock.this.hashCode()), Integer.valueOf(WakerLock.this.wakeLock.hashCode()), WakerLock.this.mCreatePosStackLine);
                    WakerLock.this.unLock();
                    if (WakerLock.this.autoUnlockCallback != null) {
                        WakerLock.this.autoUnlockCallback.autoUnlockCallback();
                    }
                }
            }
        };
        this.mCreatePosStackLine = getCallerStack();
        PowerManager.WakeLock newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(i3, str);
        this.wakeLock = newWakeLock;
        newWakeLock.setReferenceCounted(false);
        this.mHandler = new b0(context.getMainLooper());
        this.context = context;
        w.d(TAG, "init [%d,%d] @[%s]", Integer.valueOf(hashCode()), Integer.valueOf(this.wakeLock.hashCode()), this.mCreatePosStackLine);
    }

    public void lock(long j3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Long.valueOf(j3), str);
            return;
        }
        PowerManager.WakeLock wakeLock = null;
        try {
            try {
                if (this.wakeLock.isHeld()) {
                    if (sReentrantGuard) {
                        try {
                            wakeLock = ((PowerManager) this.context.getSystemService("power")).newWakeLock(1, "MicroMsg:ReentrantGuard");
                            wakeLock.acquire(100L);
                        } catch (Exception e16) {
                            w.f(TAG, "acquire wakelock failed: " + e16.getMessage());
                        }
                    }
                    unLock();
                }
                a.a(this, str);
                w.d(TAG, "lock [%d,%d] traceMsg:[%s] @[%s] limit time:%d", Integer.valueOf(hashCode()), Integer.valueOf(this.wakeLock.hashCode()), str, getCreatePosStackLine(), Long.valueOf(j3));
                this.wakeLock.acquire();
                if (j3 == -1) {
                    this.mHandler.b(this.mReleaser);
                } else {
                    this.mHandler.a(this.mReleaser, j3);
                }
                if (wakeLock != null) {
                    try {
                        wakeLock.release();
                    } catch (Exception e17) {
                        w.f(TAG, "release wakelock failed: " + e17.getMessage());
                    }
                }
            } catch (Exception e18) {
                w.a(TAG, e18, "", "");
                if (0 != 0) {
                    try {
                        wakeLock.release();
                    } catch (Exception e19) {
                        w.f(TAG, "release wakelock failed: " + e19.getMessage());
                    }
                }
            }
        } catch (Throwable th5) {
            if (0 != 0) {
                try {
                    wakeLock.release();
                } catch (Exception e26) {
                    w.f(TAG, "release wakelock failed: " + e26.getMessage());
                }
            }
            throw th5;
        }
    }
}
