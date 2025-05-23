package kotlin.text;

import cooperation.qqcircle.report.QCircleLpReportDc05507;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a\u001f\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0087\b\u001a\u001d\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\b\u001a\u001d\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0006H\u0087\b\u001a\u001d\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0007H\u0087\b\u001a\u001d\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\bH\u0087\b\u001a\u001d\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\tH\u0087\b\u001a\u001d\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\nH\u0087\b\u001a%\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u000e\u0010\u0003\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0002H\u0087\b\u001a-\u0010\u000b\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0087\b\u001a-\u0010\u000b\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0087\b\u001a\u0014\u0010\u0010\u001a\u00060\u0011j\u0002`\u0012*\u00060\u0011j\u0002`\u0012H\u0007\u001a\u001d\u0010\u0010\u001a\u00060\u0011j\u0002`\u0012*\u00060\u0011j\u0002`\u00122\u0006\u0010\u0003\u001a\u00020\u0013H\u0087\b\u001a\u001f\u0010\u0010\u001a\u00060\u0011j\u0002`\u0012*\u00060\u0011j\u0002`\u00122\b\u0010\u0003\u001a\u0004\u0018\u00010\u000fH\u0087\b\u001a\u0014\u0010\u0010\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u0002H\u0007\u001a\u001f\u0010\u0010\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0087\b\u001a\u001f\u0010\u0010\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0014H\u0087\b\u001a\u001d\u0010\u0010\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0015H\u0087\b\u001a\u001d\u0010\u0010\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\b\u001a\u001d\u0010\u0010\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0013H\u0087\b\u001a\u001d\u0010\u0010\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\fH\u0087\b\u001a\u001f\u0010\u0010\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u000fH\u0087\b\u001a\u001d\u0010\u0010\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0006H\u0087\b\u001a\u001d\u0010\u0010\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0007H\u0087\b\u001a\u001d\u0010\u0010\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\bH\u0087\b\u001a\u001d\u0010\u0010\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\tH\u0087\b\u001a\u001d\u0010\u0010\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\nH\u0087\b\u001a\u001f\u0010\u0010\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0016H\u0087\b\u001a%\u0010\u0010\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u000e\u0010\u0003\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0002H\u0087\b\u001a\u0014\u0010\u0017\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u0002H\u0007\u001a\u001d\u0010\u0018\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0019\u001a\u00020\bH\u0087\b\u001a%\u0010\u001a\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0087\b\u001a5\u0010\u001b\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0087\b\u001a5\u0010\u001b\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0087\b\u001a!\u0010\u001c\u001a\u00020\u001d*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0013H\u0087\n\u001a-\u0010\u001e\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0016H\u0087\b\u001a7\u0010\u001f\u001a\u00020\u001d*\u00060\u0001j\u0002`\u00022\u0006\u0010 \u001a\u00020\f2\b\b\u0002\u0010!\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\bH\u0087\b\u00a8\u0006\""}, d2 = {"appendLine", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "value", "Ljava/lang/StringBuffer;", "", "", "", "", "", "", "appendRange", "", "startIndex", "endIndex", "", "appendln", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "", "", "", "", QCircleLpReportDc05507.KEY_CLEAR, "deleteAt", "index", "deleteRange", "insertRange", "set", "", "setRange", "toCharArray", "destination", "destinationOffset", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/text/StringsKt")
/* loaded from: classes28.dex */
public class StringsKt__StringBuilderJVMKt extends StringsKt__RegexExtensionsKt {
    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder appendLine(StringBuilder sb5, StringBuffer stringBuffer) {
        Intrinsics.checkNotNullParameter(sb5, "<this>");
        sb5.append(stringBuffer);
        Intrinsics.checkNotNullExpressionValue(sb5, "append(value)");
        sb5.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb5, "append('\\n')");
        return sb5;
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final StringBuilder appendRange(StringBuilder sb5, char[] value, int i3, int i16) {
        Intrinsics.checkNotNullParameter(sb5, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        sb5.append(value, i3, i16 - i3);
        Intrinsics.checkNotNullExpressionValue(sb5, "this.append(value, start\u2026x, endIndex - startIndex)");
        return sb5;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine()", imports = {}))
    @NotNull
    public static final Appendable appendln(@NotNull Appendable appendable) {
        Intrinsics.checkNotNullParameter(appendable, "<this>");
        Appendable append = appendable.append(SystemProperties.LINE_SEPARATOR);
        Intrinsics.checkNotNullExpressionValue(append, "append(SystemProperties.LINE_SEPARATOR)");
        return append;
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static StringBuilder clear(@NotNull StringBuilder sb5) {
        Intrinsics.checkNotNullParameter(sb5, "<this>");
        sb5.setLength(0);
        return sb5;
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final StringBuilder deleteAt(StringBuilder sb5, int i3) {
        Intrinsics.checkNotNullParameter(sb5, "<this>");
        StringBuilder deleteCharAt = sb5.deleteCharAt(i3);
        Intrinsics.checkNotNullExpressionValue(deleteCharAt, "this.deleteCharAt(index)");
        return deleteCharAt;
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final StringBuilder deleteRange(StringBuilder sb5, int i3, int i16) {
        Intrinsics.checkNotNullParameter(sb5, "<this>");
        StringBuilder delete = sb5.delete(i3, i16);
        Intrinsics.checkNotNullExpressionValue(delete, "this.delete(startIndex, endIndex)");
        return delete;
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final StringBuilder insertRange(StringBuilder sb5, int i3, char[] value, int i16, int i17) {
        Intrinsics.checkNotNullParameter(sb5, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        StringBuilder insert = sb5.insert(i3, value, i16, i17 - i16);
        Intrinsics.checkNotNullExpressionValue(insert, "this.insert(index, value\u2026x, endIndex - startIndex)");
        return insert;
    }

    @InlineOnly
    private static final void set(StringBuilder sb5, int i3, char c16) {
        Intrinsics.checkNotNullParameter(sb5, "<this>");
        sb5.setCharAt(i3, c16);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final StringBuilder setRange(StringBuilder sb5, int i3, int i16, String value) {
        Intrinsics.checkNotNullParameter(sb5, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        StringBuilder replace = sb5.replace(i3, i16, value);
        Intrinsics.checkNotNullExpressionValue(replace, "this.replace(startIndex, endIndex, value)");
        return replace;
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final void toCharArray(StringBuilder sb5, char[] destination, int i3, int i16, int i17) {
        Intrinsics.checkNotNullParameter(sb5, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        sb5.getChars(i16, i17, destination, i3);
    }

    static /* synthetic */ void toCharArray$default(StringBuilder sb5, char[] destination, int i3, int i16, int i17, int i18, Object obj) {
        if ((i18 & 2) != 0) {
            i3 = 0;
        }
        if ((i18 & 4) != 0) {
            i16 = 0;
        }
        if ((i18 & 8) != 0) {
            i17 = sb5.length();
        }
        Intrinsics.checkNotNullParameter(sb5, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        sb5.getChars(i16, i17, destination, i3);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder appendLine(StringBuilder sb5, StringBuilder sb6) {
        Intrinsics.checkNotNullParameter(sb5, "<this>");
        sb5.append((CharSequence) sb6);
        Intrinsics.checkNotNullExpressionValue(sb5, "append(value)");
        sb5.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb5, "append('\\n')");
        return sb5;
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final StringBuilder appendRange(StringBuilder sb5, CharSequence value, int i3, int i16) {
        Intrinsics.checkNotNullParameter(sb5, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        sb5.append(value, i3, i16);
        Intrinsics.checkNotNullExpressionValue(sb5, "this.append(value, startIndex, endIndex)");
        return sb5;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    private static final Appendable appendln(Appendable appendable, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(appendable, "<this>");
        Appendable append = appendable.append(charSequence);
        Intrinsics.checkNotNullExpressionValue(append, "append(value)");
        return appendln(append);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final StringBuilder insertRange(StringBuilder sb5, int i3, CharSequence value, int i16, int i17) {
        Intrinsics.checkNotNullParameter(sb5, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        StringBuilder insert = sb5.insert(i3, value, i16, i17);
        Intrinsics.checkNotNullExpressionValue(insert, "this.insert(index, value, startIndex, endIndex)");
        return insert;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder appendLine(StringBuilder sb5, int i3) {
        Intrinsics.checkNotNullParameter(sb5, "<this>");
        sb5.append(i3);
        Intrinsics.checkNotNullExpressionValue(sb5, "append(value)");
        sb5.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb5, "append('\\n')");
        return sb5;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    private static final Appendable appendln(Appendable appendable, char c16) {
        Intrinsics.checkNotNullParameter(appendable, "<this>");
        Appendable append = appendable.append(c16);
        Intrinsics.checkNotNullExpressionValue(append, "append(value)");
        return appendln(append);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder appendLine(StringBuilder sb5, short s16) {
        Intrinsics.checkNotNullParameter(sb5, "<this>");
        sb5.append((int) s16);
        Intrinsics.checkNotNullExpressionValue(sb5, "append(value.toInt())");
        sb5.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb5, "append('\\n')");
        return sb5;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine()", imports = {}))
    @NotNull
    public static StringBuilder appendln(@NotNull StringBuilder sb5) {
        Intrinsics.checkNotNullParameter(sb5, "<this>");
        sb5.append(SystemProperties.LINE_SEPARATOR);
        Intrinsics.checkNotNullExpressionValue(sb5, "append(SystemProperties.LINE_SEPARATOR)");
        return sb5;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder appendLine(StringBuilder sb5, byte b16) {
        Intrinsics.checkNotNullParameter(sb5, "<this>");
        sb5.append((int) b16);
        Intrinsics.checkNotNullExpressionValue(sb5, "append(value.toInt())");
        sb5.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb5, "append('\\n')");
        return sb5;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    private static final StringBuilder appendln(StringBuilder sb5, StringBuffer stringBuffer) {
        StringBuilder appendln;
        Intrinsics.checkNotNullParameter(sb5, "<this>");
        sb5.append(stringBuffer);
        Intrinsics.checkNotNullExpressionValue(sb5, "append(value)");
        appendln = appendln(sb5);
        return appendln;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder appendLine(StringBuilder sb5, long j3) {
        Intrinsics.checkNotNullParameter(sb5, "<this>");
        sb5.append(j3);
        Intrinsics.checkNotNullExpressionValue(sb5, "append(value)");
        sb5.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb5, "append('\\n')");
        return sb5;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    private static final StringBuilder appendln(StringBuilder sb5, CharSequence charSequence) {
        StringBuilder appendln;
        Intrinsics.checkNotNullParameter(sb5, "<this>");
        sb5.append(charSequence);
        Intrinsics.checkNotNullExpressionValue(sb5, "append(value)");
        appendln = appendln(sb5);
        return appendln;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder appendLine(StringBuilder sb5, float f16) {
        Intrinsics.checkNotNullParameter(sb5, "<this>");
        sb5.append(f16);
        Intrinsics.checkNotNullExpressionValue(sb5, "append(value)");
        sb5.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb5, "append('\\n')");
        return sb5;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    private static final StringBuilder appendln(StringBuilder sb5, String str) {
        StringBuilder appendln;
        Intrinsics.checkNotNullParameter(sb5, "<this>");
        sb5.append(str);
        Intrinsics.checkNotNullExpressionValue(sb5, "append(value)");
        appendln = appendln(sb5);
        return appendln;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder appendLine(StringBuilder sb5, double d16) {
        Intrinsics.checkNotNullParameter(sb5, "<this>");
        sb5.append(d16);
        Intrinsics.checkNotNullExpressionValue(sb5, "append(value)");
        sb5.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb5, "append('\\n')");
        return sb5;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    private static final StringBuilder appendln(StringBuilder sb5, Object obj) {
        StringBuilder appendln;
        Intrinsics.checkNotNullParameter(sb5, "<this>");
        sb5.append(obj);
        Intrinsics.checkNotNullExpressionValue(sb5, "append(value)");
        appendln = appendln(sb5);
        return appendln;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    private static final StringBuilder appendln(StringBuilder sb5, StringBuilder sb6) {
        StringBuilder appendln;
        Intrinsics.checkNotNullParameter(sb5, "<this>");
        sb5.append((CharSequence) sb6);
        Intrinsics.checkNotNullExpressionValue(sb5, "append(value)");
        appendln = appendln(sb5);
        return appendln;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    private static final StringBuilder appendln(StringBuilder sb5, char[] value) {
        StringBuilder appendln;
        Intrinsics.checkNotNullParameter(sb5, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        sb5.append(value);
        Intrinsics.checkNotNullExpressionValue(sb5, "append(value)");
        appendln = appendln(sb5);
        return appendln;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    private static final StringBuilder appendln(StringBuilder sb5, char c16) {
        StringBuilder appendln;
        Intrinsics.checkNotNullParameter(sb5, "<this>");
        sb5.append(c16);
        Intrinsics.checkNotNullExpressionValue(sb5, "append(value)");
        appendln = appendln(sb5);
        return appendln;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    private static final StringBuilder appendln(StringBuilder sb5, boolean z16) {
        StringBuilder appendln;
        Intrinsics.checkNotNullParameter(sb5, "<this>");
        sb5.append(z16);
        Intrinsics.checkNotNullExpressionValue(sb5, "append(value)");
        appendln = appendln(sb5);
        return appendln;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    private static final StringBuilder appendln(StringBuilder sb5, int i3) {
        StringBuilder appendln;
        Intrinsics.checkNotNullParameter(sb5, "<this>");
        sb5.append(i3);
        Intrinsics.checkNotNullExpressionValue(sb5, "append(value)");
        appendln = appendln(sb5);
        return appendln;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    private static final StringBuilder appendln(StringBuilder sb5, short s16) {
        StringBuilder appendln;
        Intrinsics.checkNotNullParameter(sb5, "<this>");
        sb5.append((int) s16);
        Intrinsics.checkNotNullExpressionValue(sb5, "append(value.toInt())");
        appendln = appendln(sb5);
        return appendln;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    private static final StringBuilder appendln(StringBuilder sb5, byte b16) {
        StringBuilder appendln;
        Intrinsics.checkNotNullParameter(sb5, "<this>");
        sb5.append((int) b16);
        Intrinsics.checkNotNullExpressionValue(sb5, "append(value.toInt())");
        appendln = appendln(sb5);
        return appendln;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    private static final StringBuilder appendln(StringBuilder sb5, long j3) {
        StringBuilder appendln;
        Intrinsics.checkNotNullParameter(sb5, "<this>");
        sb5.append(j3);
        Intrinsics.checkNotNullExpressionValue(sb5, "append(value)");
        appendln = appendln(sb5);
        return appendln;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    private static final StringBuilder appendln(StringBuilder sb5, float f16) {
        StringBuilder appendln;
        Intrinsics.checkNotNullParameter(sb5, "<this>");
        sb5.append(f16);
        Intrinsics.checkNotNullExpressionValue(sb5, "append(value)");
        appendln = appendln(sb5);
        return appendln;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    private static final StringBuilder appendln(StringBuilder sb5, double d16) {
        StringBuilder appendln;
        Intrinsics.checkNotNullParameter(sb5, "<this>");
        sb5.append(d16);
        Intrinsics.checkNotNullExpressionValue(sb5, "append(value)");
        appendln = appendln(sb5);
        return appendln;
    }
}
