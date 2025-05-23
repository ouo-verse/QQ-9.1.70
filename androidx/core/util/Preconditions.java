package androidx.core.util;

import android.text.TextUtils;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.Locale;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class Preconditions {
    Preconditions() {
    }

    public static void checkArgument(boolean z16) {
        if (!z16) {
            throw new IllegalArgumentException();
        }
    }

    public static int checkArgumentInRange(int i3, int i16, int i17, @NonNull String str) {
        if (i3 >= i16) {
            if (i3 <= i17) {
                return i3;
            }
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", str, Integer.valueOf(i16), Integer.valueOf(i17)));
        }
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", str, Integer.valueOf(i16), Integer.valueOf(i17)));
    }

    @IntRange(from = 0)
    public static int checkArgumentNonnegative(int i3, @Nullable String str) {
        if (i3 >= 0) {
            return i3;
        }
        throw new IllegalArgumentException(str);
    }

    public static int checkFlagsArgument(int i3, int i16) {
        if ((i3 & i16) == i3) {
            return i3;
        }
        throw new IllegalArgumentException("Requested flags 0x" + Integer.toHexString(i3) + ", but only 0x" + Integer.toHexString(i16) + " are allowed");
    }

    @NonNull
    public static <T> T checkNotNull(@Nullable T t16) {
        t16.getClass();
        return t16;
    }

    public static void checkState(boolean z16, @Nullable String str) {
        if (!z16) {
            throw new IllegalStateException(str);
        }
    }

    @NonNull
    public static <T extends CharSequence> T checkStringNotEmpty(@Nullable T t16) {
        if (TextUtils.isEmpty(t16)) {
            throw new IllegalArgumentException();
        }
        return t16;
    }

    public static void checkArgument(boolean z16, @NonNull Object obj) {
        if (!z16) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    @IntRange(from = 0)
    public static int checkArgumentNonnegative(int i3) {
        if (i3 >= 0) {
            return i3;
        }
        throw new IllegalArgumentException();
    }

    @NonNull
    public static <T> T checkNotNull(@Nullable T t16, @NonNull Object obj) {
        if (t16 != null) {
            return t16;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static void checkState(boolean z16) {
        checkState(z16, null);
    }

    @NonNull
    public static <T extends CharSequence> T checkStringNotEmpty(@Nullable T t16, @NonNull Object obj) {
        if (TextUtils.isEmpty(t16)) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
        return t16;
    }

    @NonNull
    public static <T extends CharSequence> T checkStringNotEmpty(@Nullable T t16, @NonNull String str, @NonNull Object... objArr) {
        if (TextUtils.isEmpty(t16)) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
        return t16;
    }
}
