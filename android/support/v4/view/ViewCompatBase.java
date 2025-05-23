package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.view.View;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes.dex */
class ViewCompatBase {
    private static final String TAG = "ViewCompatBase";
    private static Field sMinHeightField;
    private static boolean sMinHeightFieldFetched;
    private static Field sMinWidthField;
    private static boolean sMinWidthFieldFetched;

    ViewCompatBase() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static ColorStateList getBackgroundTintList(View view) {
        if (view instanceof TintableBackgroundView) {
            return ((TintableBackgroundView) view).getSupportBackgroundTintList();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static PorterDuff.Mode getBackgroundTintMode(View view) {
        if (view instanceof TintableBackgroundView) {
            return ((TintableBackgroundView) view).getSupportBackgroundTintMode();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getMinimumHeight(View view) {
        if (!sMinHeightFieldFetched) {
            try {
                Field declaredField = View.class.getDeclaredField("mMinHeight");
                sMinHeightField = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            sMinHeightFieldFetched = true;
        }
        Field field = sMinHeightField;
        if (field != null) {
            try {
                return ((Integer) field.get(view)).intValue();
            } catch (Exception unused2) {
                return 0;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getMinimumWidth(View view) {
        if (!sMinWidthFieldFetched) {
            try {
                Field declaredField = View.class.getDeclaredField("mMinWidth");
                sMinWidthField = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            sMinWidthFieldFetched = true;
        }
        Field field = sMinWidthField;
        if (field != null) {
            try {
                return ((Integer) field.get(view)).intValue();
            } catch (Exception unused2) {
                return 0;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isAttachedToWindow(View view) {
        if (view.getWindowToken() != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isLaidOut(View view) {
        if (view.getWidth() > 0 && view.getHeight() > 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void offsetLeftAndRight(View view, int i3) {
        int left = view.getLeft();
        view.offsetLeftAndRight(i3);
        if (i3 != 0) {
            Object parent = view.getParent();
            if (parent instanceof View) {
                int abs = Math.abs(i3);
                ((View) parent).invalidate(left - abs, view.getTop(), left + view.getWidth() + abs, view.getBottom());
            } else {
                view.invalidate();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void offsetTopAndBottom(View view, int i3) {
        int top = view.getTop();
        view.offsetTopAndBottom(i3);
        if (i3 != 0) {
            Object parent = view.getParent();
            if (parent instanceof View) {
                int abs = Math.abs(i3);
                ((View) parent).invalidate(view.getLeft(), top - abs, view.getRight(), top + view.getHeight() + abs);
            } else {
                view.invalidate();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static void setBackgroundTintList(View view, ColorStateList colorStateList) {
        if (view instanceof TintableBackgroundView) {
            ((TintableBackgroundView) view).setSupportBackgroundTintList(colorStateList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static void setBackgroundTintMode(View view, PorterDuff.Mode mode) {
        if (view instanceof TintableBackgroundView) {
            ((TintableBackgroundView) view).setSupportBackgroundTintMode(mode);
        }
    }
}
