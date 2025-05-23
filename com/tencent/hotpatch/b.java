package com.tencent.hotpatch;

import android.annotation.SuppressLint;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Closeable;

/* compiled from: P */
/* loaded from: classes7.dex */
public class b {
    static IPatchRedirector $redirector_;

    @SuppressLint({"NewApi"})
    public static void a(Object obj) {
        if (obj == null) {
            return;
        }
        try {
            if (obj instanceof Closeable) {
                ((Closeable) obj).close();
            } else if (obj instanceof AutoCloseable) {
                ((AutoCloseable) obj).close();
            } else {
                throw new IllegalArgumentException("obj: " + obj + " cannot be closed.");
            }
        } catch (Throwable unused) {
        }
    }
}
