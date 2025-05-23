package com.tencent.qqperf.monitor.message;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import ly3.c;
import mqq.util.WeakReference;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile WeakReference<Field> f363279a;

    public static boolean a(Message message, int i3, String str) {
        boolean z16;
        boolean z17;
        String str2;
        boolean z18;
        if (message == null) {
            return false;
        }
        if (message.what == i3) {
            z16 = true;
        } else {
            z16 = false;
        }
        h("checkMsgWithKey check msgCode = " + message.what);
        if (z16) {
            try {
                str2 = "";
                if (!StringUtil.isEmpty(str)) {
                    Object obj = message.obj;
                    if (obj != null) {
                        str2 = obj.toString();
                        z18 = str2.contains(str);
                    } else {
                        z18 = false;
                    }
                } else {
                    z18 = true;
                }
            } catch (Throwable th5) {
                th = th5;
                z17 = false;
            }
            try {
                h("checkMsgWithKey check msg = " + str2);
            } catch (Throwable th6) {
                z17 = z18;
                th = th6;
                h("checkMsgWithKey has Exception " + th.toString());
                th.printStackTrace();
                return !z16 ? false : false;
            }
        } else {
            z18 = false;
        }
        z17 = z18;
        if (!z16 && z17) {
            return true;
        }
    }

    public static Message b(MessageQueue messageQueue, int i3, String str) {
        h("findKeyMsgInQueue check msgCode = " + i3 + " | searchKey = " + str);
        Message message = null;
        if (messageQueue == null) {
            return null;
        }
        try {
            Field declaredField = Class.forName("android.os.MessageQueue").getDeclaredField("mMessages");
            declaredField.setAccessible(true);
            message = (Message) declaredField.get(messageQueue);
        } catch (Throwable th5) {
            h("findKeyMsgInQueue has Exception " + th5.toString());
            th5.printStackTrace();
        }
        synchronized (messageQueue) {
            while (message != null) {
                if (a(message, i3, str)) {
                    break;
                }
                message = g(message);
            }
        }
        return message;
    }

    public static Message c(int i3, Message message) {
        while (message != null && message.what != i3) {
            message = g(message);
        }
        return message;
    }

    public static Message d(MessageQueue messageQueue) {
        if (!com.tencent.mobileqq.perf.tool.a.f258204a.a()) {
            h("getFirstMessageInTheMessageQueue checkFreeReflectionEnable is false");
            return null;
        }
        if (messageQueue == null) {
            h("getFristMessageInTheMessageQueue messageQueue is null");
            return null;
        }
        try {
            Field declaredField = Class.forName("android.os.MessageQueue").getDeclaredField("mMessages");
            declaredField.setAccessible(true);
            return (Message) declaredField.get(messageQueue);
        } catch (Throwable th5) {
            h("getFristMessageInTheMessageQueue has Exception " + th5.toString());
            th5.printStackTrace();
            return null;
        }
    }

    @Nullable
    public static MessageQueue e(Looper looper) {
        if (looper == null) {
            Log.e("MessageHelper", "getLooperMessageQueue failed, looper is null");
            return null;
        }
        return looper.getQueue();
    }

    public static long f(Message message) {
        if (message == null) {
            return -1L;
        }
        return SystemClock.uptimeMillis() - message.getWhen();
    }

    public static Message g(Message message) {
        Field field;
        if (!com.tencent.mobileqq.perf.tool.a.f258204a.a()) {
            return null;
        }
        if (f363279a != null) {
            field = f363279a.get();
        } else {
            field = null;
        }
        if (field == null) {
            try {
                field = Class.forName("android.os.Message").getDeclaredField("next");
                field.setAccessible(true);
                f363279a = new WeakReference<>(field);
            } catch (Throwable th5) {
                QLog.e("MessageHelper", 2, "getNextMessage Failed", th5);
                return null;
            }
        }
        return (Message) field.get(message);
    }

    private static void h(String str) {
        if (ly3.a.f415786a.booleanValue()) {
            QLog.d("MessageHelper", 2, str);
        }
    }

    public static Handler i(Context context) {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Method method = cls.getMethod("currentActivityThread", new Class[0]);
            method.setAccessible(true);
            Object invoke = method.invoke(null, new Object[0]);
            if (invoke == null && context != null) {
                Field field = context.getClass().getField("mLoadedApk");
                field.setAccessible(true);
                Object obj = field.get(context);
                Field declaredField = obj.getClass().getDeclaredField("mActivityThread");
                declaredField.setAccessible(true);
                invoke = declaredField.get(obj);
            }
            if (invoke == null) {
                return null;
            }
            Field declaredField2 = cls.getDeclaredField("mH");
            declaredField2.setAccessible(true);
            return (Handler) declaredField2.get(invoke);
        } catch (Exception e16) {
            QLog.e("MessageHelper", 2, "hookActivityThreadHandler Failed", e16);
            return null;
        }
    }

    public static MessageQueue j(Handler handler) {
        if (!com.tencent.mobileqq.perf.tool.a.f258204a.a()) {
            h("reflectMainMessageQueue checkFreeReflectionEnable is false");
            return null;
        }
        if (handler == null) {
            h("reflectMainMessageQueue queue is null");
            return null;
        }
        try {
            Field declaredField = Class.forName("android.os.Handler").getDeclaredField("mQueue");
            declaredField.setAccessible(true);
            return (MessageQueue) declaredField.get(handler);
        } catch (Throwable th5) {
            QLog.e("MessageHelper", 1, "hookMainMessageQueue Failed", th5);
            return null;
        }
    }

    public static void k(int i3) {
        MessageQueue e16 = e(Looper.getMainLooper());
        if (e16 != null) {
            try {
                c.a(e16, "removeSyncBarrier", new c.b(Integer.TYPE, Integer.valueOf(i3)));
            } catch (Throwable th5) {
                QLog.e("MessageHelper", 1, "removeSyncBarrier has Exception " + th5.toString());
                th5.printStackTrace();
            }
        }
    }
}
