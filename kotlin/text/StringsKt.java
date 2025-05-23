package kotlin.text;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"kotlin/text/StringsKt__AppendableKt", "kotlin/text/StringsKt__IndentKt", "kotlin/text/StringsKt__RegexExtensionsJVMKt", "kotlin/text/StringsKt__RegexExtensionsKt", "kotlin/text/StringsKt__StringBuilderJVMKt", "kotlin/text/StringsKt__StringBuilderKt", "kotlin/text/StringsKt__StringNumberConversionsJVMKt", "kotlin/text/StringsKt__StringNumberConversionsKt", "kotlin/text/StringsKt__StringsJVMKt", "kotlin/text/StringsKt__StringsKt", "kotlin/text/StringsKt___StringsJvmKt", "kotlin/text/StringsKt___StringsKt"}, k = 4, mv = {1, 7, 1}, xi = 49)
/* loaded from: classes28.dex */
public final class StringsKt extends StringsKt___StringsKt {
    StringsKt() {
    }

    public static /* bridge */ /* synthetic */ boolean equals$default(String str, String str2, boolean z16, int i3, Object obj) {
        return StringsKt__StringsJVMKt.equals$default(str, str2, z16, i3, obj);
    }

    public static /* bridge */ /* synthetic */ boolean isBlank(@NotNull CharSequence charSequence) {
        return StringsKt__StringsJVMKt.isBlank(charSequence);
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    public static /* bridge */ /* synthetic */ Integer toIntOrNull(@NotNull String str) {
        return StringsKt__StringNumberConversionsKt.toIntOrNull(str);
    }

    public static /* bridge */ /* synthetic */ boolean contains$default(CharSequence charSequence, CharSequence charSequence2, boolean z16, int i3, Object obj) {
        return StringsKt__StringsKt.contains$default(charSequence, charSequence2, z16, i3, obj);
    }

    public static /* bridge */ /* synthetic */ int indexOf$default(CharSequence charSequence, String str, int i3, boolean z16, int i16, Object obj) {
        return StringsKt__StringsKt.indexOf$default(charSequence, str, i3, z16, i16, obj);
    }

    @NotNull
    public static /* bridge */ /* synthetic */ String substringAfter(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        return StringsKt__StringsKt.substringAfter(str, str2, str3);
    }

    @NotNull
    public static /* bridge */ /* synthetic */ String substringBefore(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        return StringsKt__StringsKt.substringBefore(str, str2, str3);
    }

    public static /* bridge */ /* synthetic */ boolean endsWith$default(String str, String str2, boolean z16, int i3, Object obj) {
        return StringsKt__StringsJVMKt.endsWith$default(str, str2, z16, i3, obj);
    }

    public static /* bridge */ /* synthetic */ boolean startsWith$default(String str, String str2, boolean z16, int i3, Object obj) {
        return StringsKt__StringsJVMKt.startsWith$default(str, str2, z16, i3, obj);
    }
}
