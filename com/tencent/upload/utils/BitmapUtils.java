package com.tencent.upload.utils;

import android.graphics.BitmapFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class BitmapUtils {
    static IPatchRedirector $redirector_;

    public BitmapUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static BitmapFactory.Options getOptions() {
        return new BitmapFactory.Options();
    }

    public static void setBitmapOptionInNativeAlloc(Object obj) {
        try {
            Field declaredField = obj.getClass().getDeclaredField("inNativeAlloc");
            declaredField.setAccessible(true);
            declaredField.setBoolean(obj, true);
        } catch (Throwable th5) {
            UploadLog.i("BitmapUtils", "setBitmapOptionInNativeAlloc :", th5);
        }
    }
}
