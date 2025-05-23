package kotlin.text;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\f\n\u0002\u0010\u0019\n\u0002\u0010\r\n\u0000\u001a>\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u001b\u0010\u0004\u001a\u0017\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0005\u00a2\u0006\u0002\b\tH\u0087\b\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001a6\u0010\u0000\u001a\u00020\u00012\u001b\u0010\u0004\u001a\u0017\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0005\u00a2\u0006\u0002\b\tH\u0087\b\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a\u001f\u0010\n\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0087\b\u001a/\u0010\n\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\u0016\u0010\r\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\f0\u000e\"\u0004\u0018\u00010\f\u00a2\u0006\u0002\u0010\u000f\u001a/\u0010\n\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\u0016\u0010\r\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u000e\"\u0004\u0018\u00010\u0001\u00a2\u0006\u0002\u0010\u0010\u001a\u0015\u0010\u0011\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u0007H\u0087\b\u001a\u001f\u0010\u0011\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0087\b\u001a\u001d\u0010\u0011\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\u0006\u0010\r\u001a\u00020\u0012H\u0087\b\u001a\u001d\u0010\u0011\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\u0006\u0010\r\u001a\u00020\u0013H\u0087\b\u001a\u001d\u0010\u0011\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\u0006\u0010\r\u001a\u00020\u0014H\u0087\b\u001a\u001f\u0010\u0011\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0015H\u0087\b\u001a\u001f\u0010\u0011\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0087\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u0016"}, d2 = {"buildString", "", "capacity", "", "builderAction", "Lkotlin/Function1;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "", "Lkotlin/ExtensionFunctionType;", "append", "obj", "", "value", "", "(Ljava/lang/StringBuilder;[Ljava/lang/Object;)Ljava/lang/StringBuilder;", "(Ljava/lang/StringBuilder;[Ljava/lang/String;)Ljava/lang/StringBuilder;", "appendLine", "", "", "", "", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/text/StringsKt")
/* loaded from: classes28.dex */
public class StringsKt__StringBuilderKt extends StringsKt__StringBuilderJVMKt {
    @Deprecated(level = DeprecationLevel.WARNING, message = "Use append(value: Any?) instead", replaceWith = @ReplaceWith(expression = "append(value = obj)", imports = {}))
    @InlineOnly
    private static final StringBuilder append(StringBuilder sb5, Object obj) {
        Intrinsics.checkNotNullParameter(sb5, "<this>");
        sb5.append(obj);
        Intrinsics.checkNotNullExpressionValue(sb5, "this.append(obj)");
        return sb5;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder appendLine(StringBuilder sb5) {
        Intrinsics.checkNotNullParameter(sb5, "<this>");
        sb5.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb5, "append('\\n')");
        return sb5;
    }

    @InlineOnly
    private static final String buildString(Function1<? super StringBuilder, Unit> builderAction) {
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        StringBuilder sb5 = new StringBuilder();
        builderAction.invoke(sb5);
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "StringBuilder().apply(builderAction).toString()");
        return sb6;
    }

    @NotNull
    public static StringBuilder append(@NotNull StringBuilder sb5, @NotNull String... value) {
        Intrinsics.checkNotNullParameter(sb5, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        for (String str : value) {
            sb5.append(str);
        }
        return sb5;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder appendLine(StringBuilder sb5, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(sb5, "<this>");
        sb5.append(charSequence);
        Intrinsics.checkNotNullExpressionValue(sb5, "append(value)");
        sb5.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb5, "append('\\n')");
        return sb5;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final String buildString(int i3, Function1<? super StringBuilder, Unit> builderAction) {
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        StringBuilder sb5 = new StringBuilder(i3);
        builderAction.invoke(sb5);
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "StringBuilder(capacity).\u2026builderAction).toString()");
        return sb6;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder appendLine(StringBuilder sb5, String str) {
        Intrinsics.checkNotNullParameter(sb5, "<this>");
        sb5.append(str);
        Intrinsics.checkNotNullExpressionValue(sb5, "append(value)");
        sb5.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb5, "append('\\n')");
        return sb5;
    }

    @NotNull
    public static final StringBuilder append(@NotNull StringBuilder sb5, @NotNull Object... value) {
        Intrinsics.checkNotNullParameter(sb5, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        for (Object obj : value) {
            sb5.append(obj);
        }
        return sb5;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder appendLine(StringBuilder sb5, Object obj) {
        Intrinsics.checkNotNullParameter(sb5, "<this>");
        sb5.append(obj);
        Intrinsics.checkNotNullExpressionValue(sb5, "append(value)");
        sb5.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb5, "append('\\n')");
        return sb5;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder appendLine(StringBuilder sb5, char[] value) {
        Intrinsics.checkNotNullParameter(sb5, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        sb5.append(value);
        Intrinsics.checkNotNullExpressionValue(sb5, "append(value)");
        sb5.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb5, "append('\\n')");
        return sb5;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder appendLine(StringBuilder sb5, char c16) {
        Intrinsics.checkNotNullParameter(sb5, "<this>");
        sb5.append(c16);
        Intrinsics.checkNotNullExpressionValue(sb5, "append(value)");
        sb5.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb5, "append('\\n')");
        return sb5;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder appendLine(StringBuilder sb5, boolean z16) {
        Intrinsics.checkNotNullParameter(sb5, "<this>");
        sb5.append(z16);
        Intrinsics.checkNotNullExpressionValue(sb5, "append(value)");
        sb5.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb5, "append('\\n')");
        return sb5;
    }
}
