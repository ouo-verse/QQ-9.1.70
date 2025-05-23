package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.CheckedTextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CheckedTextViewCompat {
    private static final String TAG = "CheckedTextViewCompat";

    /* compiled from: P */
    /* loaded from: classes.dex */
    private static class Api14Impl {
        private static Field sCheckMarkDrawableField;
        private static boolean sResolved;

        Api14Impl() {
        }

        @Nullable
        static Drawable getCheckMarkDrawable(@NonNull CheckedTextView checkedTextView) {
            if (!sResolved) {
                try {
                    Field declaredField = CheckedTextView.class.getDeclaredField("mCheckMarkDrawable");
                    sCheckMarkDrawableField = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException e16) {
                    Log.i(CheckedTextViewCompat.TAG, "Failed to retrieve mCheckMarkDrawable field", e16);
                }
                sResolved = true;
            }
            Field field = sCheckMarkDrawableField;
            if (field != null) {
                try {
                    return (Drawable) field.get(checkedTextView);
                } catch (IllegalAccessException e17) {
                    Log.i(CheckedTextViewCompat.TAG, "Failed to get check mark drawable via reflection", e17);
                    sCheckMarkDrawableField = null;
                }
            }
            return null;
        }
    }

    /* compiled from: P */
    @RequiresApi(16)
    /* loaded from: classes.dex */
    private static class Api16Impl {
        Api16Impl() {
        }

        @Nullable
        static Drawable getCheckMarkDrawable(@NonNull CheckedTextView checkedTextView) {
            return checkedTextView.getCheckMarkDrawable();
        }
    }

    /* compiled from: P */
    @RequiresApi(21)
    /* loaded from: classes.dex */
    private static class Api21Impl {
        Api21Impl() {
        }

        @Nullable
        static ColorStateList getCheckMarkTintList(@NonNull CheckedTextView checkedTextView) {
            return checkedTextView.getCheckMarkTintList();
        }

        @Nullable
        static PorterDuff.Mode getCheckMarkTintMode(@NonNull CheckedTextView checkedTextView) {
            return checkedTextView.getCheckMarkTintMode();
        }

        static void setCheckMarkTintList(@NonNull CheckedTextView checkedTextView, @Nullable ColorStateList colorStateList) {
            checkedTextView.setCheckMarkTintList(colorStateList);
        }

        static void setCheckMarkTintMode(@NonNull CheckedTextView checkedTextView, @Nullable PorterDuff.Mode mode) {
            checkedTextView.setCheckMarkTintMode(mode);
        }
    }

    CheckedTextViewCompat() {
    }

    @Nullable
    public static Drawable getCheckMarkDrawable(@NonNull CheckedTextView checkedTextView) {
        return Api16Impl.getCheckMarkDrawable(checkedTextView);
    }

    @Nullable
    public static ColorStateList getCheckMarkTintList(@NonNull CheckedTextView checkedTextView) {
        return Api21Impl.getCheckMarkTintList(checkedTextView);
    }

    @Nullable
    public static PorterDuff.Mode getCheckMarkTintMode(@NonNull CheckedTextView checkedTextView) {
        return Api21Impl.getCheckMarkTintMode(checkedTextView);
    }

    public static void setCheckMarkTintList(@NonNull CheckedTextView checkedTextView, @Nullable ColorStateList colorStateList) {
        Api21Impl.setCheckMarkTintList(checkedTextView, colorStateList);
    }

    public static void setCheckMarkTintMode(@NonNull CheckedTextView checkedTextView, @Nullable PorterDuff.Mode mode) {
        Api21Impl.setCheckMarkTintMode(checkedTextView, mode);
    }
}
