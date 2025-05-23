package com.tencent.qqcamerakit.common;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.File;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static File a(String str) throws IOException {
        File file = new File(str);
        if (!file.exists()) {
            if (file.getParentFile() != null && !file.getParentFile().exists()) {
                if (file.getParentFile().mkdirs()) {
                    file.createNewFile();
                }
            } else {
                file.createNewFile();
            }
        }
        return file;
    }

    public static void b(String str) {
        if (!c(str)) {
            try {
                a(str);
            } catch (IOException unused) {
            }
        }
    }

    public static boolean c(String str) {
        if (str == null || !new File(str).exists()) {
            return false;
        }
        return true;
    }
}
