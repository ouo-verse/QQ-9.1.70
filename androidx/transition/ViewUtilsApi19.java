package androidx.transition;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: P */
@RequiresApi(19)
/* loaded from: classes.dex */
class ViewUtilsApi19 extends ViewUtilsBase {
    private static boolean sTryHiddenTransitionAlpha = true;

    @Override // androidx.transition.ViewUtilsBase
    @SuppressLint({"NewApi"})
    public float getTransitionAlpha(@NonNull View view) {
        float transitionAlpha;
        if (sTryHiddenTransitionAlpha) {
            try {
                transitionAlpha = view.getTransitionAlpha();
                return transitionAlpha;
            } catch (NoSuchMethodError unused) {
                sTryHiddenTransitionAlpha = false;
            }
        }
        return view.getAlpha();
    }

    @Override // androidx.transition.ViewUtilsBase
    @SuppressLint({"NewApi"})
    public void setTransitionAlpha(@NonNull View view, float f16) {
        if (sTryHiddenTransitionAlpha) {
            try {
                view.setTransitionAlpha(f16);
                return;
            } catch (NoSuchMethodError unused) {
                sTryHiddenTransitionAlpha = false;
            }
        }
        view.setAlpha(f16);
    }

    @Override // androidx.transition.ViewUtilsBase
    public void clearNonTransitionAlpha(@NonNull View view) {
    }

    @Override // androidx.transition.ViewUtilsBase
    public void saveNonTransitionAlpha(@NonNull View view) {
    }
}
