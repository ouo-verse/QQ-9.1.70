package androidx.core.os;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Process;
import android.os.UserHandle;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class ProcessCompat {

    @RequiresApi(16)
    /* loaded from: classes.dex */
    static class Api16Impl {
        private static Method sMethodUserIdIsAppMethod;
        private static boolean sResolved;
        private static final Object sResolvedLock = new Object();

        Api16Impl() {
        }

        @SuppressLint({"PrivateApi"})
        static boolean isApplicationUid(int i3) {
            try {
                synchronized (sResolvedLock) {
                    if (!sResolved) {
                        sResolved = true;
                        sMethodUserIdIsAppMethod = Class.forName("android.os.UserId").getDeclaredMethod("isApp", Integer.TYPE);
                    }
                }
                Method method = sMethodUserIdIsAppMethod;
                if (method != null) {
                    Boolean bool = (Boolean) method.invoke(null, Integer.valueOf(i3));
                    if (bool != null) {
                        return bool.booleanValue();
                    }
                    throw new NullPointerException();
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            return true;
        }
    }

    @RequiresApi(17)
    /* loaded from: classes.dex */
    static class Api17Impl {
        private static Method sMethodUserHandleIsAppMethod;
        private static boolean sResolved;
        private static final Object sResolvedLock = new Object();

        Api17Impl() {
        }

        @SuppressLint({"DiscouragedPrivateApi"})
        static boolean isApplicationUid(int i3) {
            try {
                synchronized (sResolvedLock) {
                    if (!sResolved) {
                        sResolved = true;
                        sMethodUserHandleIsAppMethod = UserHandle.class.getDeclaredMethod("isApp", Integer.TYPE);
                    }
                }
                Method method = sMethodUserHandleIsAppMethod;
                if (method != null && ((Boolean) method.invoke(null, Integer.valueOf(i3))) == null) {
                    throw new NullPointerException();
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            return true;
        }
    }

    @RequiresApi(24)
    /* loaded from: classes.dex */
    static class Api24Impl {
        Api24Impl() {
        }

        static boolean isApplicationUid(int i3) {
            boolean isApplicationUid;
            isApplicationUid = Process.isApplicationUid(i3);
            return isApplicationUid;
        }
    }

    ProcessCompat() {
    }

    public static boolean isApplicationUid(int i3) {
        if (Build.VERSION.SDK_INT >= 24) {
            return Api24Impl.isApplicationUid(i3);
        }
        return Api17Impl.isApplicationUid(i3);
    }
}
