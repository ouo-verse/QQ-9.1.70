package h0;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class j {
    public static void a(boolean z16, @NonNull String str) {
        if (z16) {
        } else {
            throw new IllegalArgumentException(str);
        }
    }

    @NonNull
    public static String b(@Nullable String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException("Must not be null or empty");
    }

    @NonNull
    public static <T extends Collection<Y>, Y> T c(@NonNull T t16) {
        if (!t16.isEmpty()) {
            return t16;
        }
        throw new IllegalArgumentException("Must not be empty.");
    }

    @NonNull
    public static <T> T d(@Nullable T t16) {
        return (T) e(t16, "Argument must not be null");
    }

    @NonNull
    public static <T> T e(@Nullable T t16, @NonNull String str) {
        if (t16 != null) {
            return t16;
        }
        throw new NullPointerException(str);
    }
}
