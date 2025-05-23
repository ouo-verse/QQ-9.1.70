package androidx.appcompat.widget;

import android.R;
import android.annotation.SuppressLint;
import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.graphics.drawable.DrawableWrapper;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.graphics.drawable.WrappedDrawable;
import java.lang.reflect.Field;

/* compiled from: P */
@SuppressLint({"RestrictedAPI"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class DrawableUtils {
    private static final int[] CHECKED_STATE_SET = {R.attr.state_checked};
    private static final int[] EMPTY_STATE_SET = new int[0];
    public static final Rect INSETS_NONE = new Rect();
    private static final String TAG = "DrawableUtils";
    private static final String VECTOR_DRAWABLE_CLAZZ_NAME = "android.graphics.drawable.VectorDrawable";
    private static Class<?> sInsetsClazz;

    static {
        try {
            sInsetsClazz = Class.forName("android.graphics.Insets");
        } catch (ClassNotFoundException unused) {
        }
    }

    DrawableUtils() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean canSafelyMutateDrawable(@NonNull Drawable drawable) {
        if (drawable instanceof DrawableContainer) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState instanceof DrawableContainer.DrawableContainerState) {
                for (Drawable drawable2 : ((DrawableContainer.DrawableContainerState) constantState).getChildren()) {
                    if (!canSafelyMutateDrawable(drawable2)) {
                        return false;
                    }
                }
                return true;
            }
            return true;
        }
        if (drawable instanceof WrappedDrawable) {
            return canSafelyMutateDrawable(((WrappedDrawable) drawable).getWrappedDrawable());
        }
        if (drawable instanceof DrawableWrapper) {
            return canSafelyMutateDrawable(((DrawableWrapper) drawable).getWrappedDrawable());
        }
        if (drawable instanceof ScaleDrawable) {
            return canSafelyMutateDrawable(((ScaleDrawable) drawable).getDrawable());
        }
        return true;
    }

    private static void fixVectorDrawableTinting(Drawable drawable) {
        int[] state = drawable.getState();
        if (state != null && state.length != 0) {
            drawable.setState(EMPTY_STATE_SET);
        } else {
            drawable.setState(CHECKED_STATE_SET);
        }
        drawable.setState(state);
    }

    public static Rect getOpticalBounds(Drawable drawable) {
        char c16;
        Insets opticalInsets;
        int i3;
        int i16;
        int i17;
        int i18;
        if (Build.VERSION.SDK_INT >= 29) {
            opticalInsets = drawable.getOpticalInsets();
            Rect rect = new Rect();
            i3 = opticalInsets.left;
            rect.left = i3;
            i16 = opticalInsets.right;
            rect.right = i16;
            i17 = opticalInsets.top;
            rect.top = i17;
            i18 = opticalInsets.bottom;
            rect.bottom = i18;
            return rect;
        }
        if (sInsetsClazz != null) {
            try {
                Drawable unwrap = DrawableCompat.unwrap(drawable);
                Object invoke = unwrap.getClass().getMethod("getOpticalInsets", new Class[0]).invoke(unwrap, new Object[0]);
                if (invoke != null) {
                    Rect rect2 = new Rect();
                    for (Field field : sInsetsClazz.getFields()) {
                        String name = field.getName();
                        switch (name.hashCode()) {
                            case -1383228885:
                                if (name.equals("bottom")) {
                                    c16 = 3;
                                    break;
                                }
                                break;
                            case 115029:
                                if (name.equals("top")) {
                                    c16 = 1;
                                    break;
                                }
                                break;
                            case 3317767:
                                if (name.equals("left")) {
                                    c16 = 0;
                                    break;
                                }
                                break;
                            case 108511772:
                                if (name.equals("right")) {
                                    c16 = 2;
                                    break;
                                }
                                break;
                        }
                        c16 = '\uffff';
                        if (c16 != 0) {
                            if (c16 != 1) {
                                if (c16 != 2) {
                                    if (c16 == 3) {
                                        rect2.bottom = field.getInt(invoke);
                                    }
                                } else {
                                    rect2.right = field.getInt(invoke);
                                }
                            } else {
                                rect2.top = field.getInt(invoke);
                            }
                        } else {
                            rect2.left = field.getInt(invoke);
                        }
                    }
                    return rect2;
                }
            } catch (Exception unused) {
                Log.e(TAG, "Couldn't obtain the optical insets. Ignoring.");
            }
        }
        return INSETS_NONE;
    }

    public static PorterDuff.Mode parseTintMode(int i3, PorterDuff.Mode mode) {
        if (i3 != 3) {
            if (i3 != 5) {
                if (i3 != 9) {
                    switch (i3) {
                        case 14:
                            return PorterDuff.Mode.MULTIPLY;
                        case 15:
                            return PorterDuff.Mode.SCREEN;
                        case 16:
                            return PorterDuff.Mode.ADD;
                        default:
                            return mode;
                    }
                }
                return PorterDuff.Mode.SRC_ATOP;
            }
            return PorterDuff.Mode.SRC_IN;
        }
        return PorterDuff.Mode.SRC_OVER;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void fixDrawable(@NonNull Drawable drawable) {
    }
}
