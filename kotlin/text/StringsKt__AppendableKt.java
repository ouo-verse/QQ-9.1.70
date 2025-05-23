package kotlin.text;

import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u001a5\u0010\u0000\u001a\u0002H\u0001\"\f\b\u0000\u0010\u0001*\u00060\u0002j\u0002`\u0003*\u0002H\u00012\u0016\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060\u0005\"\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007\u001a9\u0010\b\u001a\u00020\t\"\u0004\b\u0000\u0010\u0001*\u00060\u0002j\u0002`\u00032\u0006\u0010\n\u001a\u0002H\u00012\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u0006\u0018\u00010\fH\u0000\u00a2\u0006\u0002\u0010\r\u001a\u0015\u0010\u000e\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u0003H\u0087\b\u001a\u001d\u0010\u000e\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u00032\u0006\u0010\u0004\u001a\u00020\u000fH\u0087\b\u001a\u001f\u0010\u000e\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0006H\u0087\b\u001a7\u0010\u0010\u001a\u0002H\u0001\"\f\b\u0000\u0010\u0001*\u00060\u0002j\u0002`\u0003*\u0002H\u00012\u0006\u0010\u0004\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0007\u00a2\u0006\u0002\u0010\u0014\u00a8\u0006\u0015"}, d2 = {"append", "T", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "value", "", "", "(Ljava/lang/Appendable;[Ljava/lang/CharSequence;)Ljava/lang/Appendable;", "appendElement", "", DTConstants.TAG.ELEMENT, "transform", "Lkotlin/Function1;", "(Ljava/lang/Appendable;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "appendLine", "", "appendRange", "startIndex", "", "endIndex", "(Ljava/lang/Appendable;Ljava/lang/CharSequence;II)Ljava/lang/Appendable;", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/text/StringsKt")
/* loaded from: classes28.dex */
public class StringsKt__AppendableKt {
    @NotNull
    public static final <T extends Appendable> T append(@NotNull T t16, @NotNull CharSequence... value) {
        Intrinsics.checkNotNullParameter(t16, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        for (CharSequence charSequence : value) {
            t16.append(charSequence);
        }
        return t16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void appendElement(@NotNull Appendable appendable, T t16, @Nullable Function1<? super T, ? extends CharSequence> function1) {
        boolean z16;
        Intrinsics.checkNotNullParameter(appendable, "<this>");
        if (function1 != null) {
            appendable.append(function1.invoke(t16));
            return;
        }
        if (t16 == 0) {
            z16 = true;
        } else {
            z16 = t16 instanceof CharSequence;
        }
        if (z16) {
            appendable.append((CharSequence) t16);
        } else if (t16 instanceof Character) {
            appendable.append(((Character) t16).charValue());
        } else {
            appendable.append(String.valueOf(t16));
        }
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final Appendable appendLine(Appendable appendable) {
        Intrinsics.checkNotNullParameter(appendable, "<this>");
        Appendable append = appendable.append('\n');
        Intrinsics.checkNotNullExpressionValue(append, "append('\\n')");
        return append;
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @NotNull
    public static final <T extends Appendable> T appendRange(@NotNull T t16, @NotNull CharSequence value, int i3, int i16) {
        Intrinsics.checkNotNullParameter(t16, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        T t17 = (T) t16.append(value, i3, i16);
        Intrinsics.checkNotNull(t17, "null cannot be cast to non-null type T of kotlin.text.StringsKt__AppendableKt.appendRange");
        return t17;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final Appendable appendLine(Appendable appendable, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(appendable, "<this>");
        Appendable append = appendable.append(charSequence);
        Intrinsics.checkNotNullExpressionValue(append, "append(value)");
        Appendable append2 = append.append('\n');
        Intrinsics.checkNotNullExpressionValue(append2, "append('\\n')");
        return append2;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final Appendable appendLine(Appendable appendable, char c16) {
        Intrinsics.checkNotNullParameter(appendable, "<this>");
        Appendable append = appendable.append(c16);
        Intrinsics.checkNotNullExpressionValue(append, "append(value)");
        Appendable append2 = append.append('\n');
        Intrinsics.checkNotNullExpressionValue(append2, "append('\\n')");
        return append2;
    }
}
