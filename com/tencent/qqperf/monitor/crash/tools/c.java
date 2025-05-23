package com.tencent.qqperf.monitor.crash.tools;

import android.app.Activity;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.MessageQueue;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;
import ly3.c;

/* compiled from: P */
/* loaded from: classes25.dex */
public class c {
    public static boolean a(Activity activity) {
        Message e16 = e(activity);
        if (e16 == null) {
            return false;
        }
        long f16 = com.tencent.qqperf.monitor.message.a.f(e16);
        h("checkActivityDestoryMessageIsTimeOut find msg duration=" + f16);
        if (f16 < 9500) {
            return false;
        }
        return true;
    }

    public static boolean b(String str, String str2) {
        boolean z16 = false;
        if (StringUtil.isEmpty(str) || StringUtil.isEmpty(str2)) {
            return false;
        }
        boolean contains = str.contains("BadTokenException");
        boolean contains2 = str2.contains("ActivityThread.handleResumeActivity");
        QLog.d("ActivityManagerInfoHelper", 2, "checkCrashIsActivityResumeTimeOut crash type check is " + contains);
        if (!ly3.a.f415786a.booleanValue()) {
            if (contains && contains2) {
                z16 = true;
            }
            return z16;
        }
        return contains;
    }

    @Nullable
    private static Message c(Activity activity, MessageQueue messageQueue) {
        IBinder f16 = f(activity);
        Message message = null;
        if (f16 == null) {
            QLog.e("ActivityManagerInfoHelper", 1, "findActivityIsHasDestoryMessageAt_P failed getActivityWindowToken is null ");
            return null;
        }
        Message d16 = com.tencent.qqperf.monitor.message.a.d(messageQueue);
        long currentTimeMillis = System.currentTimeMillis();
        while (true) {
            if (d16 == null) {
                break;
            }
            Message c16 = com.tencent.qqperf.monitor.message.a.c(159, d16);
            if (c16 == null) {
                break;
            }
            Object obj = c16.obj;
            try {
                Class<?> cls = Class.forName("android.app.servertransaction.ClientTransaction");
                if (obj != null && cls.isInstance(obj)) {
                    Object f17 = ly3.c.f(obj, "mLifecycleStateRequest");
                    Class<?> cls2 = Class.forName("android.app.servertransaction.ActivityLifecycleItem");
                    if (f17 != null && cls2.isInstance(f17) && ((Integer) ly3.c.a(f17, "getTargetState", new c.b[0])).intValue() == 6 && ((IBinder) ly3.c.e(obj, "mActivityToken")) == f16) {
                        message = c16;
                        break;
                    }
                }
            } catch (ClassNotFoundException e16) {
                QLog.e("ActivityManagerInfoHelper", 1, "findActivityIsHasDestoryMessageAt_P ClassNotFound ", e16);
            } catch (Throwable th5) {
                QLog.e("ActivityManagerInfoHelper", 1, "findActivityIsHasDestoryMessageAt_P failed ", th5);
            }
            d16 = com.tencent.qqperf.monitor.message.a.g(c16);
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (currentTimeMillis2 > 10) {
            QLog.w("ActivityManagerInfoHelper", 1, "findActivityIsHasDestoryMessageAt_P time cost " + currentTimeMillis2);
        }
        return message;
    }

    @Nullable
    private static Message d(Activity activity, MessageQueue messageQueue) {
        return com.tencent.qqperf.monitor.message.a.b(messageQueue, 109, g(activity));
    }

    public static Message e(Activity activity) {
        if (activity == null) {
            return null;
        }
        MessageQueue queue = activity.getMainLooper().getQueue();
        if (queue == null) {
            queue = i(activity);
        }
        if (queue == null) {
            return null;
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 28) {
            return d(activity, queue);
        }
        if (i3 != 28) {
            return null;
        }
        return c(activity, queue);
    }

    private static IBinder f(Activity activity) {
        StringBuilder sb5;
        String str = "null";
        if (activity == null) {
            return null;
        }
        try {
            Method method = Activity.class.getMethod("getActivityToken", new Class[0]);
            method.setAccessible(true);
            IBinder iBinder = (IBinder) method.invoke(activity, new Object[0]);
            StringBuilder sb6 = new StringBuilder();
            sb6.append("getActivityWindowToken return ");
            if (iBinder != null) {
                str = iBinder.toString();
            }
            sb6.append(str);
            h(sb6.toString());
            return iBinder;
        } catch (Throwable th5) {
            try {
                QLog.e("ActivityManagerInfoHelper", 1, "getActivityWindowToken Failed", th5);
                sb5 = new StringBuilder();
            } catch (Throwable unused) {
                sb5 = new StringBuilder();
            }
            sb5.append("getActivityWindowToken return ");
            sb5.append("null");
            h(sb5.toString());
            return null;
        }
    }

    private static String g(Activity activity) {
        IBinder f16 = f(activity);
        if (f16 != null) {
            return f16.toString();
        }
        return "";
    }

    private static void h(String str) {
        if (ly3.a.f415786a.booleanValue()) {
            QLog.d("ActivityManagerInfoHelper", 2, str);
        }
    }

    private static MessageQueue i(Activity activity) {
        Handler i3;
        if (activity == null || (i3 = com.tencent.qqperf.monitor.message.a.i(activity)) == null) {
            return null;
        }
        return com.tencent.qqperf.monitor.message.a.j(i3);
    }
}
