package com.tencent.theme;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thumbplayer.libloader.TPFromApkLibraryLoader;

/* compiled from: P */
/* loaded from: classes26.dex */
public class r {
    static IPatchRedirector $redirector_;

    public static String a(Context context, String str) throws IllegalArgumentException {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass(TPFromApkLibraryLoader.ANDROID_OS_SYSTEM_PROPERTIES_CLASS_NAME);
            return (String) loadClass.getMethod("get", String.class).invoke(loadClass, str);
        } catch (IllegalArgumentException e16) {
            throw e16;
        } catch (Exception unused) {
            return "";
        }
    }
}
