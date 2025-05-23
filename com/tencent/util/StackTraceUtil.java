package com.tencent.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes27.dex */
public class StackTraceUtil {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "StackTraceUtil";
    private static boolean mCanNotFound;
    private static Method mFillStackTraceMethod;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42411);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            mCanNotFound = false;
        }
    }

    public StackTraceUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static StackTraceElement[] getStackTraceWithMaxDepth(Thread thread, int i3, boolean z16) {
        if (!initMethod()) {
            return thread.getStackTrace();
        }
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[i3];
        try {
            mFillStackTraceMethod.invoke(null, thread, stackTraceElementArr);
        } catch (IllegalAccessException e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        } catch (InvocationTargetException e17) {
            QLog.e(TAG, 1, e17, new Object[0]);
        }
        if (!z16) {
            return stackTraceElementArr;
        }
        for (int i16 = i3 - 1; i16 >= 0; i16--) {
            if (stackTraceElementArr[i16] != null) {
                return (StackTraceElement[]) Arrays.copyOfRange(stackTraceElementArr, 0, i16 + 1);
            }
        }
        return thread.getStackTrace();
    }

    private static boolean initMethod() {
        if (mCanNotFound) {
            return false;
        }
        if (mFillStackTraceMethod != null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "initMethod return true as method is found before.");
            }
            return true;
        }
        try {
            mFillStackTraceMethod = Class.forName("dalvik.system.VMStack").getMethod("fillStackTraceElements", Thread.class, new StackTraceElement[0].getClass());
        } catch (ClassNotFoundException unused) {
            QLog.d(TAG, 1, "can not find the class VMStack");
            mCanNotFound = true;
        } catch (NoSuchMethodException unused2) {
            QLog.d(TAG, 1, "can not find the method fillStackTraceElements");
            mCanNotFound = true;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("initMethod finished with res: ");
            sb5.append(!mCanNotFound);
            QLog.d(TAG, 2, sb5.toString());
        }
        return !mCanNotFound;
    }
}
