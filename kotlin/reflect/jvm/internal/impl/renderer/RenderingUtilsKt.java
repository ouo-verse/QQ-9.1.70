package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class RenderingUtilsKt {
    @NotNull
    public static final String render(@NotNull Name name) {
        Intrinsics.checkNotNullParameter(name, "<this>");
        if (!shouldBeEscaped(name)) {
            String asString = name.asString();
            Intrinsics.checkNotNullExpressionValue(asString, "asString()");
            return asString;
        }
        StringBuilder sb5 = new StringBuilder();
        String asString2 = name.asString();
        Intrinsics.checkNotNullExpressionValue(asString2, "asString()");
        sb5.append('`' + asString2);
        sb5.append('`');
        return sb5.toString();
    }

    @NotNull
    public static final String renderFqName(@NotNull List<Name> pathSegments) {
        Intrinsics.checkNotNullParameter(pathSegments, "pathSegments");
        StringBuilder sb5 = new StringBuilder();
        for (Name name : pathSegments) {
            if (sb5.length() > 0) {
                sb5.append(".");
            }
            sb5.append(render(name));
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "StringBuilder().apply(builderAction).toString()");
        return sb6;
    }

    private static final boolean shouldBeEscaped(Name name) {
        boolean z16;
        boolean z17;
        String asString = name.asString();
        Intrinsics.checkNotNullExpressionValue(asString, "asString()");
        if (KeywordStringsGenerated.KEYWORDS.contains(asString)) {
            return true;
        }
        int i3 = 0;
        while (true) {
            if (i3 < asString.length()) {
                char charAt = asString.charAt(i3);
                if (!Character.isLetterOrDigit(charAt) && charAt != '_') {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    z16 = true;
                    break;
                }
                i3++;
            } else {
                z16 = false;
                break;
            }
        }
        if (z16) {
            return true;
        }
        return false;
    }

    @NotNull
    public static final String render(@NotNull FqNameUnsafe fqNameUnsafe) {
        Intrinsics.checkNotNullParameter(fqNameUnsafe, "<this>");
        List<Name> pathSegments = fqNameUnsafe.pathSegments();
        Intrinsics.checkNotNullExpressionValue(pathSegments, "pathSegments()");
        return renderFqName(pathSegments);
    }
}
