package com.tencent.qqnt.avatar.disklrucache;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/* compiled from: P */
/* loaded from: classes23.dex */
final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    static final Charset f352769a;

    /* renamed from: b, reason: collision with root package name */
    static final Charset f352770b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40727);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f352769a = Charset.forName("US-ASCII");
            f352770b = Charset.forName("UTF-8");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e16) {
                throw e16;
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(File file) throws IOException {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    b(file2);
                }
                if (!file2.delete()) {
                    throw new IOException("failed to delete file: " + file2);
                }
            }
            return;
        }
        throw new IOException("not a readable directory: " + file);
    }
}
