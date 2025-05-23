package androidx.transition;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RequiresApi(21)
/* loaded from: classes.dex */
class GhostViewPlatform implements GhostView {
    private static final String TAG = "GhostViewApi21";
    private static Method sAddGhostMethod;
    private static boolean sAddGhostMethodFetched;
    private static Class<?> sGhostViewClass;
    private static boolean sGhostViewClassFetched;
    private static Method sRemoveGhostMethod;
    private static boolean sRemoveGhostMethodFetched;
    private final View mGhostView;

    GhostViewPlatform(@NonNull View view) {
        this.mGhostView = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static GhostView addGhost(View view, ViewGroup viewGroup, Matrix matrix) {
        fetchAddGhostMethod();
        Method method = sAddGhostMethod;
        if (method != null) {
            try {
                return new GhostViewPlatform((View) method.invoke(null, view, viewGroup, matrix));
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e16) {
                throw new RuntimeException(e16.getCause());
            }
        }
        return null;
    }

    private static void fetchAddGhostMethod() {
        if (!sAddGhostMethodFetched) {
            try {
                fetchGhostViewClass();
                Method declaredMethod = sGhostViewClass.getDeclaredMethod("addGhost", View.class, ViewGroup.class, Matrix.class);
                sAddGhostMethod = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e16) {
                Log.i(TAG, "Failed to retrieve addGhost method", e16);
            }
            sAddGhostMethodFetched = true;
        }
    }

    private static void fetchGhostViewClass() {
        if (!sGhostViewClassFetched) {
            try {
                sGhostViewClass = Class.forName("android.view.GhostView");
            } catch (ClassNotFoundException e16) {
                Log.i(TAG, "Failed to retrieve GhostView class", e16);
            }
            sGhostViewClassFetched = true;
        }
    }

    private static void fetchRemoveGhostMethod() {
        if (!sRemoveGhostMethodFetched) {
            try {
                fetchGhostViewClass();
                Method declaredMethod = sGhostViewClass.getDeclaredMethod("removeGhost", View.class);
                sRemoveGhostMethod = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e16) {
                Log.i(TAG, "Failed to retrieve removeGhost method", e16);
            }
            sRemoveGhostMethodFetched = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void removeGhost(View view) {
        fetchRemoveGhostMethod();
        Method method = sRemoveGhostMethod;
        if (method != null) {
            try {
                method.invoke(null, view);
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e16) {
                throw new RuntimeException(e16.getCause());
            }
        }
    }

    @Override // androidx.transition.GhostView
    public void setVisibility(int i3) {
        this.mGhostView.setVisibility(i3);
    }

    @Override // androidx.transition.GhostView
    public void reserveEndViewTransition(ViewGroup viewGroup, View view) {
    }
}
