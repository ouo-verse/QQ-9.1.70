package com.tencent.centaur.host.loader;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileWriter;

/* compiled from: P */
/* loaded from: classes5.dex */
public class DexClassLoaderUtil {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static Looper f99068a;

    /* renamed from: b, reason: collision with root package name */
    private static Handler f99069b;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    private static class CheckMD5Task implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private File f99070d;

        /* renamed from: e, reason: collision with root package name */
        private String f99071e;

        /* renamed from: f, reason: collision with root package name */
        private String f99072f;

        /* renamed from: h, reason: collision with root package name */
        private File f99073h;

        /* renamed from: i, reason: collision with root package name */
        private File f99074i;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            String c16 = com.tencent.centaur.host.loader.util.a.c(this.f99070d.getAbsolutePath());
            String str = this.f99072f;
            if (str == null) {
                DexClassLoaderUtil.c(this.f99073h, this.f99074i, this.f99071e, c16);
            } else if (!str.equalsIgnoreCase(c16)) {
                this.f99070d.delete();
                this.f99073h.delete();
                SystemMethodProxy.killProcess(Process.myPid());
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10698);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f99068a = null;
            f99069b = null;
        }
    }

    private static void b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void c(File file, File file2, String str, String str2) {
        BufferedWriter bufferedWriter = null;
        try {
            try {
                BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file2));
                try {
                    bufferedWriter2.write(str);
                    bufferedWriter2.newLine();
                    if (str2 != null) {
                        bufferedWriter2.write(str2);
                    }
                    b(bufferedWriter2);
                } catch (Exception e16) {
                    e = e16;
                    bufferedWriter = bufferedWriter2;
                    e.printStackTrace();
                    b(bufferedWriter);
                    if (file.exists()) {
                    }
                    file2.renameTo(file);
                } catch (Throwable th5) {
                    th = th5;
                    bufferedWriter = bufferedWriter2;
                    b(bufferedWriter);
                    throw th;
                }
            } catch (Exception e17) {
                e = e17;
            }
            if (file.exists()) {
                file.delete();
            }
            file2.renameTo(file);
        } catch (Throwable th6) {
            th = th6;
        }
    }
}
