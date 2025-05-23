package kotlin.reflect.jvm.internal.impl.name;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class NameUtils {

    @NotNull
    public static final NameUtils INSTANCE = new NameUtils();

    @NotNull
    private static final Regex SANITIZE_AS_JAVA_INVALID_CHARACTERS = new Regex("[^\\p{L}\\p{Digit}]");

    NameUtils() {
    }

    @JvmStatic
    @NotNull
    public static final String sanitizeAsJavaIdentifier(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return SANITIZE_AS_JAVA_INVALID_CHARACTERS.replace(name, "_");
    }
}
