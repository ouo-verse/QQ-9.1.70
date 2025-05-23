package androidx.core.view;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.TypedValue;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ViewConfigurationCompat {
    private static final String TAG = "ViewConfigCompat";
    private static Method sGetScaledScrollFactorMethod;

    static {
        if (Build.VERSION.SDK_INT == 25) {
            try {
                sGetScaledScrollFactorMethod = ViewConfiguration.class.getDeclaredMethod("getScaledScrollFactor", new Class[0]);
            } catch (Exception unused) {
                Log.i(TAG, "Could not find method getScaledScrollFactor() on ViewConfiguration");
            }
        }
    }

    ViewConfigurationCompat() {
    }

    private static float getLegacyScrollFactor(ViewConfiguration viewConfiguration, Context context) {
        Method method;
        if (Build.VERSION.SDK_INT >= 25 && (method = sGetScaledScrollFactorMethod) != null) {
            try {
                return ((Integer) method.invoke(viewConfiguration, new Object[0])).intValue();
            } catch (Exception unused) {
                Log.i(TAG, "Could not find method getScaledScrollFactor() on ViewConfiguration");
            }
        }
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
            return typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return 0.0f;
    }

    public static float getScaledHorizontalScrollFactor(@NonNull ViewConfiguration viewConfiguration, @NonNull Context context) {
        float scaledHorizontalScrollFactor;
        if (Build.VERSION.SDK_INT >= 26) {
            scaledHorizontalScrollFactor = viewConfiguration.getScaledHorizontalScrollFactor();
            return scaledHorizontalScrollFactor;
        }
        return getLegacyScrollFactor(viewConfiguration, context);
    }

    public static int getScaledHoverSlop(ViewConfiguration viewConfiguration) {
        int scaledHoverSlop;
        if (Build.VERSION.SDK_INT >= 28) {
            scaledHoverSlop = viewConfiguration.getScaledHoverSlop();
            return scaledHoverSlop;
        }
        return viewConfiguration.getScaledTouchSlop() / 2;
    }

    @Deprecated
    public static int getScaledPagingTouchSlop(ViewConfiguration viewConfiguration) {
        return viewConfiguration.getScaledPagingTouchSlop();
    }

    public static float getScaledVerticalScrollFactor(@NonNull ViewConfiguration viewConfiguration, @NonNull Context context) {
        float scaledVerticalScrollFactor;
        if (Build.VERSION.SDK_INT >= 26) {
            scaledVerticalScrollFactor = viewConfiguration.getScaledVerticalScrollFactor();
            return scaledVerticalScrollFactor;
        }
        return getLegacyScrollFactor(viewConfiguration, context);
    }

    @Deprecated
    public static boolean hasPermanentMenuKey(ViewConfiguration viewConfiguration) {
        return viewConfiguration.hasPermanentMenuKey();
    }

    public static boolean shouldShowMenuShortcutsWhenKeyboardPresent(ViewConfiguration viewConfiguration, @NonNull Context context) {
        boolean shouldShowMenuShortcutsWhenKeyboardPresent;
        if (Build.VERSION.SDK_INT >= 28) {
            shouldShowMenuShortcutsWhenKeyboardPresent = viewConfiguration.shouldShowMenuShortcutsWhenKeyboardPresent();
            return shouldShowMenuShortcutsWhenKeyboardPresent;
        }
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showMenuShortcutsWhenKeyboardPresent", "bool", "android");
        if (identifier != 0 && resources.getBoolean(identifier)) {
            return true;
        }
        return false;
    }
}
