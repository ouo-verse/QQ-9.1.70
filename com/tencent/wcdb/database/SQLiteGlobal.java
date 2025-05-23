package com.tencent.wcdb.database;

import android.os.Environment;
import android.os.StatFs;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class SQLiteGlobal {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final int f384390a;

    static {
        int i3;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21924);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        if (!WCDBInitializationProbe.libLoaded) {
            System.loadLibrary("wcdb");
        }
        try {
            i3 = new StatFs(Environment.getDataDirectory().getAbsolutePath()).getBlockSize();
        } catch (RuntimeException unused) {
            i3 = 4096;
        }
        f384390a = i3;
        nativeSetDefaultCipherSettings(i3);
    }

    SQLiteGlobal() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static native int nativeReleaseMemory();

    private static native void nativeSetDefaultCipherSettings(int i3);

    public static void a() {
    }
}
