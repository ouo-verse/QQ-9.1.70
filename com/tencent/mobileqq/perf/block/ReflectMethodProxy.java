package com.tencent.mobileqq.perf.block;

import android.os.Build;
import android.view.Window;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import mqq.app.MobileQQ;

/* loaded from: classes16.dex */
public class ReflectMethodProxy {
    static IPatchRedirector $redirector_;

    public ReflectMethodProxy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void fieldSet(Field field, Object obj, Object obj2) throws InterruptedException, IllegalAccessException, NullPointerException {
        field.set(obj, obj2);
        long currentTimeMillis = System.currentTimeMillis();
        if (Build.VERSION.SDK_INT >= 31 && MobileQQ.sProcessId == 1 && obj != null && obj2 == null && Window.class.isInstance(obj) && field.getName().equalsIgnoreCase("mContext")) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            StringBuilder sb5 = new StringBuilder();
            for (StackTraceElement stackTraceElement : stackTrace) {
                sb5.append(stackTraceElement.toString());
                sb5.append("\n");
            }
            QLog.e("ReflectMethodProxy", 1, "find window.mContext null set! " + sb5.toString() + " | cost = " + (System.currentTimeMillis() - currentTimeMillis));
        }
    }
}
