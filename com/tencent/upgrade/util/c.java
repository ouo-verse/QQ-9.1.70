package com.tencent.upgrade.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Closeable;

/* compiled from: P */
/* loaded from: classes27.dex */
public class c {
    static IPatchRedirector $redirector_;

    public static void a(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }
}
