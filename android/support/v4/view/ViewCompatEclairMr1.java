package android.support.v4.view;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes.dex */
class ViewCompatEclairMr1 {
    public static final String TAG = "ViewCompat";
    private static Method sChildrenDrawingOrderMethod;

    ViewCompatEclairMr1() {
    }

    public static boolean isOpaque(View view) {
        return view.isOpaque();
    }

    public static void setChildrenDrawingOrderEnabled(ViewGroup viewGroup, boolean z16) {
        if (sChildrenDrawingOrderMethod == null) {
            try {
                sChildrenDrawingOrderMethod = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException e16) {
                Log.e(TAG, "Unable to find childrenDrawingOrderEnabled", e16);
            }
            sChildrenDrawingOrderMethod.setAccessible(true);
        }
        try {
            sChildrenDrawingOrderMethod.invoke(viewGroup, Boolean.valueOf(z16));
        } catch (IllegalAccessException e17) {
            Log.e(TAG, "Unable to invoke childrenDrawingOrderEnabled", e17);
        } catch (IllegalArgumentException e18) {
            Log.e(TAG, "Unable to invoke childrenDrawingOrderEnabled", e18);
        } catch (InvocationTargetException e19) {
            Log.e(TAG, "Unable to invoke childrenDrawingOrderEnabled", e19);
        }
    }
}
