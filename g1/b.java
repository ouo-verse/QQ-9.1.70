package g1;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class b {
    @Nullable
    public static TypedValue a(@NonNull Context context, @AttrRes int i3) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i3, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    public static boolean b(@NonNull Context context, @AttrRes int i3, boolean z16) {
        TypedValue a16 = a(context, i3);
        if (a16 != null && a16.type == 18) {
            if (a16.data != 0) {
                return true;
            }
            return false;
        }
        return z16;
    }

    public static int c(@NonNull Context context, @AttrRes int i3, int i16) {
        TypedValue a16 = a(context, i3);
        if (a16 != null && a16.type == 16) {
            return a16.data;
        }
        return i16;
    }

    public static int d(@NonNull Context context, @AttrRes int i3, @NonNull String str) {
        TypedValue a16 = a(context, i3);
        if (a16 != null) {
            return a16.data;
        }
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", str, context.getResources().getResourceName(i3)));
    }

    public static int e(@NonNull View view, @AttrRes int i3) {
        return d(view.getContext(), i3, view.getClass().getCanonicalName());
    }
}
