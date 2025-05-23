package androidx.core.os;

import android.os.Build;
import android.os.UserHandle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: P */
@RequiresApi(17)
/* loaded from: classes.dex */
public class UserHandleCompat {

    @Nullable
    private static Method sGetUserIdMethod;

    @Nullable
    private static Constructor<UserHandle> sUserHandleConstructor;

    /* compiled from: P */
    @RequiresApi(24)
    /* loaded from: classes.dex */
    private static class Api24Impl {
        Api24Impl() {
        }

        @NonNull
        static UserHandle getUserHandleForUid(int i3) {
            UserHandle userHandleForUid;
            userHandleForUid = UserHandle.getUserHandleForUid(i3);
            return userHandleForUid;
        }
    }

    UserHandleCompat() {
    }

    private static Method getGetUserIdMethod() throws NoSuchMethodException {
        if (sGetUserIdMethod == null) {
            Method declaredMethod = UserHandle.class.getDeclaredMethod("getUserId", Integer.TYPE);
            sGetUserIdMethod = declaredMethod;
            declaredMethod.setAccessible(true);
        }
        return sGetUserIdMethod;
    }

    private static Constructor<UserHandle> getUserHandleConstructor() throws NoSuchMethodException {
        if (sUserHandleConstructor == null) {
            Constructor<UserHandle> declaredConstructor = UserHandle.class.getDeclaredConstructor(Integer.TYPE);
            sUserHandleConstructor = declaredConstructor;
            declaredConstructor.setAccessible(true);
        }
        return sUserHandleConstructor;
    }

    @NonNull
    public static UserHandle getUserHandleForUid(int i3) {
        if (Build.VERSION.SDK_INT >= 24) {
            return Api24Impl.getUserHandleForUid(i3);
        }
        try {
            return getUserHandleConstructor().newInstance((Integer) getGetUserIdMethod().invoke(null, Integer.valueOf(i3)));
        } catch (IllegalAccessException e16) {
            IllegalAccessError illegalAccessError = new IllegalAccessError();
            illegalAccessError.initCause(e16);
            throw illegalAccessError;
        } catch (InstantiationException e17) {
            InstantiationError instantiationError = new InstantiationError();
            instantiationError.initCause(e17);
            throw instantiationError;
        } catch (NoSuchMethodException e18) {
            NoSuchMethodError noSuchMethodError = new NoSuchMethodError();
            noSuchMethodError.initCause(e18);
            throw noSuchMethodError;
        } catch (InvocationTargetException e19) {
            throw new RuntimeException(e19);
        }
    }
}
