package com.tencent.mobileqq.qqperfnativetool.signalTool;

import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.SystemClock;
import android.util.ArrayMap;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes17.dex */
public class SignalCatcherJNI {
    static IPatchRedirector $redirector_ = null;
    private static final long BACKGROUND_MSG_THRESHOLD = -10000;
    private static final long FOREGROUND_MSG_THRESHOLD = -2000;
    static final String TAG = "SignalCatcherJNI";

    public SignalCatcherJNI() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static native int initANRSignalCatcher(boolean z16);

    public static native int initNativeCrashSignalCatcher(boolean z16);

    private static boolean isActivityInterestingToUser() {
        ArrayMap arrayMap;
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object invoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            arrayMap = (ArrayMap) declaredField.get(invoke);
        } catch (Exception e16) {
            Log.e(TAG, "isActivityInterestingToUser failed!", e16);
        }
        if (arrayMap.size() < 1) {
            return false;
        }
        for (Object obj : arrayMap.values()) {
            Field declaredField2 = obj.getClass().getDeclaredField("paused");
            declaredField2.setAccessible(true);
            if (!declaredField2.getBoolean(obj)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isMainThreadBlocked() {
        long j3;
        try {
            MessageQueue queue = Looper.getMainLooper().getQueue();
            Field declaredField = queue.getClass().getDeclaredField("mMessages");
            declaredField.setAccessible(true);
            Message message = (Message) declaredField.get(queue);
            if (message != null) {
                long when = message.getWhen();
                if (when == 0) {
                    return false;
                }
                long uptimeMillis = when - SystemClock.uptimeMillis();
                if (isActivityInterestingToUser()) {
                    j3 = FOREGROUND_MSG_THRESHOLD;
                } else {
                    j3 = BACKGROUND_MSG_THRESHOLD;
                }
                if (uptimeMillis >= j3) {
                    return false;
                }
                return true;
            }
            Log.i(TAG, "mMessage is null");
            return false;
        } catch (Throwable th5) {
            Log.e(TAG, "isMainThreadBlocked failed!", th5);
            return false;
        }
    }

    public static void onSignalCatched(int i3, int i16, int i17, int i18) {
        a b16;
        Log.d(TAG, "onSignalCatched invoke");
        StringBuilder sb5 = new StringBuilder();
        sb5.append("JAVA onSignalCatched invoke");
        sb5.append("\n sigNumber = " + i3);
        sb5.append("\n sigCode = " + i16);
        sb5.append("\n errorNum = " + i17);
        Log.e(TAG, sb5.toString());
        if (i3 != 100 && (b16 = com.tencent.mobileqq.qqperfnativetool.a.a().b()) != null) {
            if (i3 == 3) {
                if (isMainThreadBlocked()) {
                    b16.onANR("msg");
                    return;
                }
                return;
            }
            b16.a(i3, i16, i18);
        }
    }

    public static native int unInitANRSignalCatcher();

    public static native int unInitNativeCrashSignalCatcher();
}
