package com.tencent.util;

import com.tencent.component.core.log.LogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: P */
/* loaded from: classes27.dex */
public class f {
    static IPatchRedirector $redirector_;

    public static void a(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e16) {
                LogUtil.e("IOUtils", "closeQuietly error:" + e16, new Object[0]);
            }
        }
    }

    public static void b(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e16) {
                LogUtil.e("IOUtils", "closeQuietly error:" + e16, new Object[0]);
            }
        }
    }
}
