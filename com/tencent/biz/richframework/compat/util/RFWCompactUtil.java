package com.tencent.biz.richframework.compat.util;

import android.app.Activity;
import android.os.Build;
import android.view.ViewParent;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWCompactUtil {
    public static void recoveryConsumeBatchedInputInAndroidR(Activity activity) {
        try {
            if (Build.VERSION.SDK_INT < 30) {
                RFWLog.i("RFWCompactUtil", RFWLog.USR, "not target android sdk version,must bigger than 30");
                return;
            }
            ViewParent parent = activity.getWindow().getDecorView().getParent();
            Class<?> cls = parent.getClass();
            Field declaredField = cls.getDeclaredField("mConsumeBatchedInputImmediatelyScheduled");
            declaredField.setAccessible(true);
            if (!((Boolean) declaredField.get(parent)).booleanValue()) {
                RFWLog.i("RFWCompactUtil", RFWLog.USR, "recoveryConsumeBatchedInput not need recovery,mConsumeBatchedInputImmediatelyScheduled is false");
                return;
            }
            RFWLog.i("RFWCompactUtil", RFWLog.USR, "recoveryConsumeBatchedInput need recovery,mConsumeBatchedInputImmediatelyScheduled is true");
            declaredField.set(parent, Boolean.FALSE);
            Method declaredMethod = cls.getDeclaredMethod("scheduleConsumeBatchedInput", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(parent, new Object[0]);
            RFWLog.i("RFWCompactUtil", RFWLog.USR, "recoveryConsumeBatchedInput success");
        } catch (Throwable th5) {
            RFWLog.e("RFWCompactUtil", RFWLog.USR, "recoveryConsumeBatchedInput error:" + th5.getMessage());
        }
    }
}
