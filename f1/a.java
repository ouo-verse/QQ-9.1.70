package f1;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.TypedValue;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.PathParser;
import androidx.core.view.animation.PathInterpolatorCompat;
import g1.b;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class a {
    private static float a(String[] strArr, int i3) {
        float parseFloat = Float.parseFloat(strArr[i3]);
        if (parseFloat >= 0.0f && parseFloat <= 1.0f) {
            return parseFloat;
        }
        throw new IllegalArgumentException("Motion easing control point value must be between 0 and 1; instead got: " + parseFloat);
    }

    private static String b(String str, String str2) {
        return str.substring(str2.length() + 1, str.length() - 1);
    }

    private static boolean c(String str, String str2) {
        if (str.startsWith(str2 + "(") && str.endsWith(")")) {
            return true;
        }
        return false;
    }

    public static int d(@NonNull Context context, @AttrRes int i3, int i16) {
        return b.c(context, i3, i16);
    }

    @NonNull
    public static TimeInterpolator e(@NonNull Context context, @AttrRes int i3, @NonNull TimeInterpolator timeInterpolator) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i3, typedValue, true)) {
            if (typedValue.type == 3) {
                String valueOf = String.valueOf(typedValue.string);
                if (c(valueOf, "cubic-bezier")) {
                    String[] split = b(valueOf, "cubic-bezier").split(",");
                    if (split.length == 4) {
                        return PathInterpolatorCompat.create(a(split, 0), a(split, 1), a(split, 2), a(split, 3));
                    }
                    throw new IllegalArgumentException("Motion easing theme attribute must have 4 control points if using bezier curve format; instead got: " + split.length);
                }
                if (c(valueOf, "path")) {
                    return PathInterpolatorCompat.create(PathParser.createPathFromPathData(b(valueOf, "path")));
                }
                throw new IllegalArgumentException("Invalid motion easing type: " + valueOf);
            }
            throw new IllegalArgumentException("Motion easing theme attribute must be a string");
        }
        return timeInterpolator;
    }
}
