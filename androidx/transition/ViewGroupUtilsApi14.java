package androidx.transition;

import android.animation.LayoutTransition;
import android.util.Log;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes.dex */
class ViewGroupUtilsApi14 {
    private static final int LAYOUT_TRANSITION_CHANGING = 4;
    private static final String TAG = "ViewGroupUtilsApi14";
    private static Method sCancelMethod;
    private static boolean sCancelMethodFetched;
    private static LayoutTransition sEmptyLayoutTransition;
    private static Field sLayoutSuppressedField;
    private static boolean sLayoutSuppressedFieldFetched;

    ViewGroupUtilsApi14() {
    }

    private static void cancelLayoutTransition(LayoutTransition layoutTransition) {
        if (!sCancelMethodFetched) {
            try {
                Method declaredMethod = LayoutTransition.class.getDeclaredMethod("cancel", new Class[0]);
                sCancelMethod = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
                Log.i(TAG, "Failed to access cancel method by reflection");
            }
            sCancelMethodFetched = true;
        }
        Method method = sCancelMethod;
        if (method != null) {
            try {
                method.invoke(layoutTransition, new Object[0]);
            } catch (IllegalAccessException unused2) {
                Log.i(TAG, "Failed to access cancel method by reflection");
            } catch (InvocationTargetException unused3) {
                Log.i(TAG, "Failed to invoke cancel method by reflection");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static void suppressLayout(@NonNull ViewGroup viewGroup, boolean z16) {
        LayoutTransition layoutTransition;
        boolean z17 = false;
        if (sEmptyLayoutTransition == null) {
            LayoutTransition layoutTransition2 = new LayoutTransition() { // from class: androidx.transition.ViewGroupUtilsApi14.1
                @Override // android.animation.LayoutTransition
                public boolean isChangingLayout() {
                    return true;
                }
            };
            sEmptyLayoutTransition = layoutTransition2;
            layoutTransition2.setAnimator(2, null);
            sEmptyLayoutTransition.setAnimator(0, null);
            sEmptyLayoutTransition.setAnimator(1, null);
            sEmptyLayoutTransition.setAnimator(3, null);
            sEmptyLayoutTransition.setAnimator(4, null);
        }
        if (z16) {
            LayoutTransition layoutTransition3 = viewGroup.getLayoutTransition();
            if (layoutTransition3 != null) {
                if (layoutTransition3.isRunning()) {
                    cancelLayoutTransition(layoutTransition3);
                }
                if (layoutTransition3 != sEmptyLayoutTransition) {
                    viewGroup.setTag(com.tencent.mobileqq.R.id.f100845tl, layoutTransition3);
                }
            }
            viewGroup.setLayoutTransition(sEmptyLayoutTransition);
            return;
        }
        viewGroup.setLayoutTransition(null);
        if (!sLayoutSuppressedFieldFetched) {
            try {
                Field declaredField = ViewGroup.class.getDeclaredField("mLayoutSuppressed");
                sLayoutSuppressedField = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i(TAG, "Failed to access mLayoutSuppressed field by reflection");
            }
            sLayoutSuppressedFieldFetched = true;
        }
        Field field = sLayoutSuppressedField;
        if (field != null) {
            try {
                boolean z18 = field.getBoolean(viewGroup);
                if (z18) {
                    try {
                        sLayoutSuppressedField.setBoolean(viewGroup, false);
                    } catch (IllegalAccessException unused2) {
                        z17 = z18;
                        Log.i(TAG, "Failed to get mLayoutSuppressed field by reflection");
                        if (z17) {
                        }
                        layoutTransition = (LayoutTransition) viewGroup.getTag(com.tencent.mobileqq.R.id.f100845tl);
                        if (layoutTransition == null) {
                        }
                    }
                }
                z17 = z18;
            } catch (IllegalAccessException unused3) {
            }
        }
        if (z17) {
            viewGroup.requestLayout();
        }
        layoutTransition = (LayoutTransition) viewGroup.getTag(com.tencent.mobileqq.R.id.f100845tl);
        if (layoutTransition == null) {
            viewGroup.setTag(com.tencent.mobileqq.R.id.f100845tl, null);
            viewGroup.setLayoutTransition(layoutTransition);
        }
    }
}
