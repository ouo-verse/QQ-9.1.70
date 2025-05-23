package androidx.core.location;

import android.location.Location;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes.dex */
public final class LocationCompat {
    private static final String EXTRA_IS_MOCK = "mockLocation";

    @Nullable
    private static Method sSetIsFromMockProviderMethod;

    /* compiled from: P */
    @RequiresApi(17)
    /* loaded from: classes.dex */
    private static class Api17Impl {
        Api17Impl() {
        }

        @DoNotInline
        static long getElapsedRealtimeNanos(Location location) {
            return location.getElapsedRealtimeNanos();
        }
    }

    /* compiled from: P */
    @RequiresApi(18)
    /* loaded from: classes.dex */
    private static class Api18Impl {
        Api18Impl() {
        }

        @DoNotInline
        static boolean isMock(Location location) {
            return location.isFromMockProvider();
        }
    }

    LocationCompat() {
    }

    public static long getElapsedRealtimeMillis(@NonNull Location location) {
        return TimeUnit.NANOSECONDS.toMillis(Api17Impl.getElapsedRealtimeNanos(location));
    }

    public static long getElapsedRealtimeNanos(@NonNull Location location) {
        return Api17Impl.getElapsedRealtimeNanos(location);
    }

    private static Method getSetIsFromMockProviderMethod() throws NoSuchMethodException {
        if (sSetIsFromMockProviderMethod == null) {
            Method declaredMethod = Location.class.getDeclaredMethod("setIsFromMockProvider", Boolean.TYPE);
            sSetIsFromMockProviderMethod = declaredMethod;
            declaredMethod.setAccessible(true);
        }
        return sSetIsFromMockProviderMethod;
    }

    public static boolean isMock(@NonNull Location location) {
        return Api18Impl.isMock(location);
    }

    public static void setMock(@NonNull Location location, boolean z16) {
        try {
            getSetIsFromMockProviderMethod().invoke(location, Boolean.valueOf(z16));
        } catch (IllegalAccessException e16) {
            IllegalAccessError illegalAccessError = new IllegalAccessError();
            illegalAccessError.initCause(e16);
            throw illegalAccessError;
        } catch (NoSuchMethodException e17) {
            NoSuchMethodError noSuchMethodError = new NoSuchMethodError();
            noSuchMethodError.initCause(e17);
            throw noSuchMethodError;
        } catch (InvocationTargetException e18) {
            throw new RuntimeException(e18);
        }
    }
}
