package androidx.appcompat.widget;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class ViewUtils {
    private static final String TAG = "ViewUtils";
    private static Method sComputeFitSystemWindowsMethod;

    static {
        try {
            Method declaredMethod = View.class.getDeclaredMethod("computeFitSystemWindows", Rect.class, Rect.class);
            sComputeFitSystemWindowsMethod = declaredMethod;
            if (!declaredMethod.isAccessible()) {
                sComputeFitSystemWindowsMethod.setAccessible(true);
            }
        } catch (NoSuchMethodException unused) {
            Log.d(TAG, "Could not find method computeFitSystemWindows. Oh well.");
        }
    }

    ViewUtils() {
    }

    public static void computeFitSystemWindows(View view, Rect rect, Rect rect2) {
        Method method = sComputeFitSystemWindowsMethod;
        if (method != null) {
            try {
                method.invoke(view, rect, rect2);
            } catch (Exception e16) {
                Log.d(TAG, "Could not invoke computeFitSystemWindows", e16);
            }
        }
    }

    public static boolean isLayoutRtl(View view) {
        if (ViewCompat.getLayoutDirection(view) == 1) {
            return true;
        }
        return false;
    }

    public static void makeOptionalFitsSystemWindows(View view) {
        try {
            Method method = view.getClass().getMethod("makeOptionalFitsSystemWindows", new Class[0]);
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            method.invoke(view, new Object[0]);
        } catch (IllegalAccessException e16) {
            Log.d(TAG, "Could not invoke makeOptionalFitsSystemWindows", e16);
        } catch (NoSuchMethodException unused) {
            Log.d(TAG, "Could not find method makeOptionalFitsSystemWindows. Oh well...");
        } catch (InvocationTargetException e17) {
            Log.d(TAG, "Could not invoke makeOptionalFitsSystemWindows", e17);
        }
    }
}
