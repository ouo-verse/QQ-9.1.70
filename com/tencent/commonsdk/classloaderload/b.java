package com.tencent.commonsdk.classloaderload;

import android.content.Context;
import android.os.Build;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static volatile qf0.a f99893a;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static File a(Context context, String str, String str2) {
        b();
        QLog.d("SoLoadClassLoaderFactory", 1, "getSoByBaseDexClassLoader, entryName:[" + str + "], dstPath:[" + str2 + "]");
        File file = new File(str2);
        if (file.exists()) {
            file.delete();
            QLog.d("SoLoadClassLoaderFactory", 1, "getSoByBaseDexClassLoader, dstPath file exists, delete it");
        }
        return f99893a.a(context, str, file);
    }

    private static void b() {
        if (f99893a != null) {
            return;
        }
        synchronized (b.class) {
            if (f99893a != null) {
                return;
            }
            int i3 = Build.VERSION.SDK_INT;
            if (i3 <= 23) {
                f99893a = new c();
            } else if (i3 <= 25) {
                f99893a = new d();
            } else {
                f99893a = new e();
            }
        }
    }
}
