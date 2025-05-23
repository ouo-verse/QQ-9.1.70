package com.tencent.apkupdate.obfuscated;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import java.util.concurrent.ExecutorService;

/* compiled from: P */
/* loaded from: classes3.dex */
public class h {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    public static h f72529c;

    /* renamed from: a, reason: collision with root package name */
    public Context f72530a;

    /* renamed from: b, reason: collision with root package name */
    public ExecutorService f72531b;

    public h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static synchronized h a() {
        h hVar;
        synchronized (h.class) {
            if (f72529c == null) {
                f72529c = new h();
            }
            hVar = f72529c;
        }
        return hVar;
    }

    public String b(String str) {
        Signature[] signatureArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        try {
            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(this.f72530a.getPackageManager(), str, 64);
            if (packageInfo != null && (signatureArr = packageInfo.signatures) != null && signatureArr.length > 0) {
                return m.c(signatureArr[signatureArr.length - 1].toCharsString());
            }
            return "";
        } catch (Throwable th5) {
            th5.printStackTrace();
            return "";
        }
    }

    public void c(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) runnable);
            return;
        }
        Log.i("ProtocolHelper", "startNewTask");
        ExecutorService executorService = this.f72531b;
        if (executorService != null && !executorService.isShutdown()) {
            Log.i("ProtocolHelper", "threadPool.execute");
            try {
                this.f72531b.execute(runnable);
            } catch (Exception e16) {
                Log.i("ProtocolHelper", "threadPool.execute error: " + e16);
            }
        }
    }
}
