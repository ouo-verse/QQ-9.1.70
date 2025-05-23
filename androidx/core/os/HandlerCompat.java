package androidx.core.os;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.lang.reflect.InvocationTargetException;

/* compiled from: P */
/* loaded from: classes.dex */
public final class HandlerCompat {
    private static final String TAG = "HandlerCompat";

    /* compiled from: P */
    @RequiresApi(28)
    /* loaded from: classes.dex */
    private static class Api28Impl {
        Api28Impl() {
        }

        public static Handler createAsync(Looper looper) {
            Handler createAsync;
            createAsync = Handler.createAsync(looper);
            return createAsync;
        }

        public static boolean postDelayed(Handler handler, Runnable runnable, Object obj, long j3) {
            boolean postDelayed;
            postDelayed = handler.postDelayed(runnable, obj, j3);
            return postDelayed;
        }

        public static Handler createAsync(Looper looper, Handler.Callback callback) {
            Handler createAsync;
            createAsync = Handler.createAsync(looper, callback);
            return createAsync;
        }
    }

    /* compiled from: P */
    @RequiresApi(29)
    /* loaded from: classes.dex */
    private static class Api29Impl {
        Api29Impl() {
        }

        public static boolean hasCallbacks(Handler handler, Runnable runnable) {
            boolean hasCallbacks;
            hasCallbacks = handler.hasCallbacks(runnable);
            return hasCallbacks;
        }
    }

    HandlerCompat() {
    }

    @NonNull
    public static Handler createAsync(@NonNull Looper looper) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.createAsync(looper);
        }
        try {
            return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
        } catch (IllegalAccessException e16) {
            e = e16;
            Log.w(TAG, "Unable to invoke Handler(Looper, Callback, boolean) constructor", e);
            return new Handler(looper);
        } catch (InstantiationException e17) {
            e = e17;
            Log.w(TAG, "Unable to invoke Handler(Looper, Callback, boolean) constructor", e);
            return new Handler(looper);
        } catch (NoSuchMethodException e18) {
            e = e18;
            Log.w(TAG, "Unable to invoke Handler(Looper, Callback, boolean) constructor", e);
            return new Handler(looper);
        } catch (InvocationTargetException e19) {
            Throwable cause = e19.getCause();
            if (!(cause instanceof RuntimeException)) {
                if (cause instanceof Error) {
                    throw ((Error) cause);
                }
                throw new RuntimeException(cause);
            }
            throw ((RuntimeException) cause);
        }
    }

    @RequiresApi(16)
    public static boolean hasCallbacks(@NonNull Handler handler, @NonNull Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 29) {
            return Api29Impl.hasCallbacks(handler, runnable);
        }
        try {
            return ((Boolean) Handler.class.getMethod("hasCallbacks", Runnable.class).invoke(handler, runnable)).booleanValue();
        } catch (IllegalAccessException e16) {
            e = e16;
            throw new UnsupportedOperationException("Failed to call Handler.hasCallbacks(), but there is no safe failure mode for this method. Raising exception.", e);
        } catch (NoSuchMethodException e17) {
            e = e17;
            throw new UnsupportedOperationException("Failed to call Handler.hasCallbacks(), but there is no safe failure mode for this method. Raising exception.", e);
        } catch (NullPointerException e18) {
            e = e18;
            throw new UnsupportedOperationException("Failed to call Handler.hasCallbacks(), but there is no safe failure mode for this method. Raising exception.", e);
        } catch (InvocationTargetException e19) {
            Throwable cause = e19.getCause();
            if (!(cause instanceof RuntimeException)) {
                if (cause instanceof Error) {
                    throw ((Error) cause);
                }
                throw new RuntimeException(cause);
            }
            throw ((RuntimeException) cause);
        }
    }

    public static boolean postDelayed(@NonNull Handler handler, @NonNull Runnable runnable, @Nullable Object obj, long j3) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.postDelayed(handler, runnable, obj, j3);
        }
        Message obtain = Message.obtain(handler, runnable);
        obtain.obj = obj;
        return handler.sendMessageDelayed(obtain, j3);
    }

    @NonNull
    public static Handler createAsync(@NonNull Looper looper, @NonNull Handler.Callback callback) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.createAsync(looper, callback);
        }
        try {
            return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, callback, Boolean.TRUE);
        } catch (IllegalAccessException e16) {
            e = e16;
            Log.w(TAG, "Unable to invoke Handler(Looper, Callback, boolean) constructor", e);
            return new Handler(looper, callback);
        } catch (InstantiationException e17) {
            e = e17;
            Log.w(TAG, "Unable to invoke Handler(Looper, Callback, boolean) constructor", e);
            return new Handler(looper, callback);
        } catch (NoSuchMethodException e18) {
            e = e18;
            Log.w(TAG, "Unable to invoke Handler(Looper, Callback, boolean) constructor", e);
            return new Handler(looper, callback);
        } catch (InvocationTargetException e19) {
            Throwable cause = e19.getCause();
            if (!(cause instanceof RuntimeException)) {
                if (cause instanceof Error) {
                    throw ((Error) cause);
                }
                throw new RuntimeException(cause);
            }
            throw ((RuntimeException) cause);
        }
    }
}
