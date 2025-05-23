package com.tencent.commonsdk.classloaderload;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.reflect.Array;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c implements qf0.a {
    static IPatchRedirector $redirector_;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // qf0.a
    public File a(Context context, String str, File file) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (File) iPatchRedirector.redirect((short) 2, this, context, str, file);
        }
        try {
            Object c16 = f.c(context);
            if (c16.getClass().isArray()) {
                int length = Array.getLength(c16);
                ZipEntry zipEntry = null;
                ZipFile zipFile = null;
                for (int i3 = 0; i3 < length; i3++) {
                    Object obj = Array.get(c16, i3);
                    f.i(obj);
                    if (!f.d(obj)) {
                        Object h16 = f.h(obj);
                        if (h16 == null) {
                            QLog.e("SoLoadClassLoaderSDK17To23", 1, "zip == null");
                        } else {
                            zipFile = (ZipFile) h16;
                            zipEntry = f.g(zipFile, str);
                            if (zipEntry != null) {
                                break;
                            }
                        }
                    }
                }
                if (zipEntry != null) {
                    f.b(zipEntry, zipFile, file);
                } else {
                    file = null;
                }
            }
            QLog.e("SoLoadClassLoaderSDK17To23", 1, "getSoByClassLoader over outfile: ", file);
            return file;
        } catch (Exception e16) {
            QLog.e("SoLoadClassLoaderSDK17To23", 1, "getSoByBaseDexClassLoader failed ", e16);
            return null;
        }
    }
}
