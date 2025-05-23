package com.tencent.qimei.aa;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.IOException;
import java.nio.channels.FileLock;

/* compiled from: P */
/* loaded from: classes22.dex */
public class d implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Runnable f342893a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f342894b;

    public d(e eVar, Runnable runnable) {
        this.f342894b = eVar;
        this.f342893a = runnable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) eVar, (Object) runnable);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0020, code lost:
    
        if (r1 != null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002b, code lost:
    
        r1.release();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0029, code lost:
    
        if (r1 == null) goto L20;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        synchronized (this.f342894b) {
            FileLock fileLock = null;
            try {
                try {
                    fileLock = this.f342894b.f342896b.lock();
                    this.f342893a.run();
                } catch (Exception e16) {
                    e16.getMessage();
                }
            } catch (Throwable th5) {
                if (fileLock != null) {
                    try {
                        fileLock.release();
                    } catch (IOException unused) {
                    }
                }
                throw th5;
            }
        }
    }
}
