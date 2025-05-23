package androidx.transition;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes.dex */
class ViewGroupUtils {
    private static Method sGetChildDrawingOrderMethod = null;
    private static boolean sGetChildDrawingOrderMethodFetched = false;
    private static boolean sTryHiddenSuppressLayout = true;

    ViewGroupUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getChildDrawingOrder(@NonNull ViewGroup viewGroup, int i3) {
        int childDrawingOrder;
        if (Build.VERSION.SDK_INT >= 29) {
            childDrawingOrder = viewGroup.getChildDrawingOrder(i3);
            return childDrawingOrder;
        }
        if (!sGetChildDrawingOrderMethodFetched) {
            try {
                Class cls = Integer.TYPE;
                Method declaredMethod = ViewGroup.class.getDeclaredMethod("getChildDrawingOrder", cls, cls);
                sGetChildDrawingOrderMethod = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            sGetChildDrawingOrderMethodFetched = true;
        }
        Method method = sGetChildDrawingOrderMethod;
        if (method != null) {
            try {
                return ((Integer) method.invoke(viewGroup, Integer.valueOf(viewGroup.getChildCount()), Integer.valueOf(i3))).intValue();
            } catch (IllegalAccessException | InvocationTargetException unused2) {
            }
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ViewGroupOverlayImpl getOverlay(@NonNull ViewGroup viewGroup) {
        return new ViewGroupOverlayApi18(viewGroup);
    }

    @RequiresApi(18)
    @SuppressLint({"NewApi"})
    private static void hiddenSuppressLayout(@NonNull ViewGroup viewGroup, boolean z16) {
        if (sTryHiddenSuppressLayout) {
            try {
                viewGroup.suppressLayout(z16);
            } catch (NoSuchMethodError unused) {
                sTryHiddenSuppressLayout = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void suppressLayout(@NonNull ViewGroup viewGroup, boolean z16) {
        if (Build.VERSION.SDK_INT >= 29) {
            viewGroup.suppressLayout(z16);
        } else {
            hiddenSuppressLayout(viewGroup, z16);
        }
    }
}
