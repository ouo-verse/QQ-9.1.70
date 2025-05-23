package g1;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.StyleableRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.TintTypedArray;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class c {
    @Nullable
    public static ColorStateList a(@NonNull Context context, @NonNull TypedArray typedArray, @StyleableRes int i3) {
        int resourceId;
        ColorStateList colorStateList;
        if (typedArray.hasValue(i3) && (resourceId = typedArray.getResourceId(i3, 0)) != 0 && (colorStateList = AppCompatResources.getColorStateList(context, resourceId)) != null) {
            return colorStateList;
        }
        return typedArray.getColorStateList(i3);
    }

    @Nullable
    public static ColorStateList b(@NonNull Context context, @NonNull TintTypedArray tintTypedArray, @StyleableRes int i3) {
        int resourceId;
        ColorStateList colorStateList;
        if (tintTypedArray.hasValue(i3) && (resourceId = tintTypedArray.getResourceId(i3, 0)) != 0 && (colorStateList = AppCompatResources.getColorStateList(context, resourceId)) != null) {
            return colorStateList;
        }
        return tintTypedArray.getColorStateList(i3);
    }

    private static int c(TypedValue typedValue) {
        return typedValue.getComplexUnit();
    }

    public static int d(@NonNull Context context, @NonNull TypedArray typedArray, @StyleableRes int i3, int i16) {
        TypedValue typedValue = new TypedValue();
        if (typedArray.getValue(i3, typedValue) && typedValue.type == 2) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{typedValue.data});
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, i16);
            obtainStyledAttributes.recycle();
            return dimensionPixelSize;
        }
        return typedArray.getDimensionPixelSize(i3, i16);
    }

    @Nullable
    public static Drawable e(@NonNull Context context, @NonNull TypedArray typedArray, @StyleableRes int i3) {
        int resourceId;
        Drawable drawable;
        if (typedArray.hasValue(i3) && (resourceId = typedArray.getResourceId(i3, 0)) != 0 && (drawable = AppCompatResources.getDrawable(context, resourceId)) != null) {
            return drawable;
        }
        return typedArray.getDrawable(i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @StyleableRes
    public static int f(@NonNull TypedArray typedArray, @StyleableRes int i3, @StyleableRes int i16) {
        if (typedArray.hasValue(i3)) {
            return i3;
        }
        return i16;
    }

    @Nullable
    public static d g(@NonNull Context context, @NonNull TypedArray typedArray, @StyleableRes int i3) {
        int resourceId;
        if (typedArray.hasValue(i3) && (resourceId = typedArray.getResourceId(i3, 0)) != 0) {
            return new d(context, resourceId);
        }
        return null;
    }

    public static int h(@NonNull Context context, @StyleRes int i3, int i16) {
        if (i3 == 0) {
            return i16;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i3, w0.a.Y8);
        TypedValue typedValue = new TypedValue();
        boolean value = obtainStyledAttributes.getValue(w0.a.Z8, typedValue);
        obtainStyledAttributes.recycle();
        if (!value) {
            return i16;
        }
        if (c(typedValue) == 2) {
            return Math.round(TypedValue.complexToFloat(typedValue.data) * context.getResources().getDisplayMetrics().density);
        }
        return TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
    }

    public static boolean i(@NonNull Context context) {
        if (context.getResources().getConfiguration().fontScale >= 1.3f) {
            return true;
        }
        return false;
    }

    public static boolean j(@NonNull Context context) {
        if (context.getResources().getConfiguration().fontScale >= 2.0f) {
            return true;
        }
        return false;
    }
}
