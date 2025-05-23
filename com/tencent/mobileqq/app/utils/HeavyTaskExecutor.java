package com.tencent.mobileqq.app.utils;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes11.dex */
public class HeavyTaskExecutor implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private static HeavyTaskExecutor f196583e;

    /* renamed from: d, reason: collision with root package name */
    private List<Runnable> f196584d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(70748);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f196583e = null;
        }
    }

    public HeavyTaskExecutor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f196584d = new ArrayList();
        }
    }

    public static void a(Runnable runnable) {
        if (f196583e == null) {
            synchronized (HeavyTaskExecutor.class) {
                if (f196583e == null) {
                    f196583e = new HeavyTaskExecutor();
                    if (QLog.isDevelopLevel()) {
                        QLog.d("HeavyTaskExecutor", 4, "init.");
                    }
                }
            }
        }
        QLog.d("HeavyTaskExecutor", 1, "asyncExec " + runnable);
        synchronized (f196583e) {
            f196583e.f196584d.add(runnable);
            if (f196583e.f196584d.size() == 1) {
                ThreadManager.getSubThreadHandler().post(f196583e);
            }
        }
    }

    public static void e() {
        HeavyTaskExecutor heavyTaskExecutor = f196583e;
        if (heavyTaskExecutor != null) {
            synchronized (heavyTaskExecutor) {
                if (f196583e.f196584d.size() > 0) {
                    QLog.d("HeavyTaskExecutor", 1, "wait begin.");
                    try {
                        f196583e.wait(3000L);
                    } catch (InterruptedException unused) {
                    }
                    QLog.d("HeavyTaskExecutor", 1, "wait over.");
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0024, code lost:
    
        com.tencent.qphone.base.util.QLog.d("HeavyTaskExecutor", 1, "executing " + r3);
        r3.run();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003f, code lost:
    
        monitor-enter(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0046, code lost:
    
        if (r8.f196584d.size() <= 0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0048, code lost:
    
        r8.f196584d.remove(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0053, code lost:
    
        if (r8.f196584d.size() != 0) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0055, code lost:
    
        com.tencent.qphone.base.util.QLog.d("HeavyTaskExecutor", 1, "tasks done, notify.");
        notify();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x009b, code lost:
    
        r2 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00a7, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isDevelopLevel() != false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00a9, code lost:
    
        r2.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00ac, code lost:
    
        com.tencent.qphone.base.util.QLog.d("HeavyTaskExecutor", 1, "exception when executing task " + r3, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00c4, code lost:
    
        monitor-enter(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00cb, code lost:
    
        if (r8.f196584d.size() > 0) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00cd, code lost:
    
        r8.f196584d.remove(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00d8, code lost:
    
        if (r8.f196584d.size() == 0) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00da, code lost:
    
        com.tencent.qphone.base.util.QLog.d("HeavyTaskExecutor", 1, "tasks done, notify.");
        notify();
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00ee, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00ef, code lost:
    
        monitor-enter(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00f6, code lost:
    
        if (r8.f196584d.size() > 0) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00f8, code lost:
    
        r8.f196584d.remove(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0103, code lost:
    
        if (r8.f196584d.size() == 0) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0105, code lost:
    
        com.tencent.qphone.base.util.QLog.d("HeavyTaskExecutor", 1, "tasks done, notify.");
        notify();
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0112, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0114, code lost:
    
        throw r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x006a, code lost:
    
        monitor-enter(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0071, code lost:
    
        if (r8.f196584d.size() <= 0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0073, code lost:
    
        r8.f196584d.remove(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x007e, code lost:
    
        if (r8.f196584d.size() != 0) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0080, code lost:
    
        com.tencent.qphone.base.util.QLog.d("HeavyTaskExecutor", 1, "tasks done, notify.");
        notify();
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        Runnable runnable;
        Throwable th5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        while (true) {
            try {
                synchronized (this) {
                    try {
                        if (this.f196584d.size() > 0) {
                            runnable = this.f196584d.get(0);
                            try {
                            } catch (Throwable th6) {
                                th5 = th6;
                                throw th5;
                                break;
                            }
                        }
                    } catch (Throwable th7) {
                        runnable = null;
                        th5 = th7;
                    }
                }
            } catch (Throwable th8) {
                runnable = null;
                Throwable th9 = th8;
            }
        }
    }
}
