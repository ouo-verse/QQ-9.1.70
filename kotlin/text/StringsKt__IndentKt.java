package kotlin.text;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.internal.IntrinsicConstEvaluation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000b\u001a!\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0002\b\u0004\u001a\u0011\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0002\u00a2\u0006\u0002\b\u0007\u001a\u0014\u0010\b\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u001aJ\u0010\t\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001H\u0082\b\u00a2\u0006\u0002\b\u000e\u001a\u0014\u0010\u000f\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u001a\u001e\u0010\u0011\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u001a\f\u0010\u0013\u001a\u00020\u0002*\u00020\u0002H\u0007\u001a\u0016\u0010\u0014\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0002H\u0007\u00a8\u0006\u0015"}, d2 = {"getIndentFunction", "Lkotlin/Function1;", "", "indent", "getIndentFunction$StringsKt__IndentKt", "indentWidth", "", "indentWidth$StringsKt__IndentKt", "prependIndent", "reindent", "", "resultSizeEstimate", "indentAddFunction", "indentCutFunction", "reindent$StringsKt__IndentKt", "replaceIndent", "newIndent", "replaceIndentByMargin", "marginPrefix", "trimIndent", "trimMargin", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/text/StringsKt")
/* loaded from: classes28.dex */
public class StringsKt__IndentKt extends StringsKt__AppendableKt {
    private static final Function1<String, String> getIndentFunction$StringsKt__IndentKt(final String str) {
        boolean z16;
        if (str.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return new Function1<String, String>() { // from class: kotlin.text.StringsKt__IndentKt$getIndentFunction$1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final String invoke(@NotNull String line) {
                    Intrinsics.checkNotNullParameter(line, "line");
                    return line;
                }
            };
        }
        return new Function1<String, String>() { // from class: kotlin.text.StringsKt__IndentKt$getIndentFunction$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final String invoke(@NotNull String line) {
                Intrinsics.checkNotNullParameter(line, "line");
                return str + line;
            }
        };
    }

    private static final int indentWidth$StringsKt__IndentKt(String str) {
        boolean isWhitespace;
        int length = str.length();
        int i3 = 0;
        while (true) {
            if (i3 < length) {
                isWhitespace = CharsKt__CharJVMKt.isWhitespace(str.charAt(i3));
                if (!isWhitespace) {
                    break;
                }
                i3++;
            } else {
                i3 = -1;
                break;
            }
        }
        if (i3 == -1) {
            return str.length();
        }
        return i3;
    }

    @NotNull
    public static final String prependIndent(@NotNull String str, @NotNull final String indent) {
        Sequence map;
        String joinToString$default;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(indent, "indent");
        map = SequencesKt___SequencesKt.map(StringsKt__StringsKt.lineSequence(str), new Function1<String, String>() { // from class: kotlin.text.StringsKt__IndentKt$prependIndent$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final String invoke(@NotNull String it) {
                boolean isBlank;
                Intrinsics.checkNotNullParameter(it, "it");
                isBlank = StringsKt__StringsJVMKt.isBlank(it);
                if (isBlank) {
                    return it.length() < indent.length() ? indent : it;
                }
                return indent + it;
            }
        });
        joinToString$default = SequencesKt___SequencesKt.joinToString$default(map, "\n", null, null, 0, null, null, 62, null);
        return joinToString$default;
    }

    public static /* synthetic */ String prependIndent$default(String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str2 = "    ";
        }
        return prependIndent(str, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0046 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final String reindent$StringsKt__IndentKt(List<String> list, int i3, Function1<? super String, String> function1, Function1<? super String, String> function12) {
        int lastIndex;
        Appendable joinTo$default;
        boolean isBlank;
        String invoke;
        lastIndex = CollectionsKt__CollectionsKt.getLastIndex(list);
        ArrayList arrayList = new ArrayList();
        int i16 = 0;
        for (Object obj : list) {
            int i17 = i16 + 1;
            if (i16 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            String str = (String) obj;
            if (i16 == 0 || i16 == lastIndex) {
                isBlank = StringsKt__StringsJVMKt.isBlank(str);
                if (isBlank) {
                    str = null;
                    if (str == null) {
                        arrayList.add(str);
                    }
                    i16 = i17;
                }
            }
            String invoke2 = function12.invoke(str);
            if (invoke2 != null && (invoke = function1.invoke(invoke2)) != null) {
                str = invoke;
            }
            if (str == null) {
            }
            i16 = i17;
        }
        joinTo$default = CollectionsKt___CollectionsKt.joinTo$default(arrayList, new StringBuilder(i3), "\n", null, null, 0, null, null, 124, null);
        String sb5 = ((StringBuilder) joinTo$default).toString();
        Intrinsics.checkNotNullExpressionValue(sb5, "mapIndexedNotNull { inde\u2026\"\\n\")\n        .toString()");
        return sb5;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c0 A[SYNTHETIC] */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final String replaceIndent(@NotNull String str, @NotNull String newIndent) {
        int collectionSizeOrDefault;
        Comparable minOrNull;
        int i3;
        int lastIndex;
        Appendable joinTo$default;
        boolean isBlank;
        String drop;
        String invoke;
        boolean isBlank2;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(newIndent, "newIndent");
        List<String> lines = StringsKt__StringsKt.lines(str);
        ArrayList arrayList = new ArrayList();
        for (Object obj : lines) {
            isBlank2 = StringsKt__StringsJVMKt.isBlank((String) obj);
            if (!isBlank2) {
                arrayList.add(obj);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Integer.valueOf(indentWidth$StringsKt__IndentKt((String) it.next())));
        }
        minOrNull = CollectionsKt___CollectionsKt.minOrNull((Iterable<? extends Comparable>) arrayList2);
        Integer num = (Integer) minOrNull;
        int i16 = 0;
        if (num != null) {
            i3 = num.intValue();
        } else {
            i3 = 0;
        }
        int length = str.length() + (newIndent.length() * lines.size());
        Function1<String, String> indentFunction$StringsKt__IndentKt = getIndentFunction$StringsKt__IndentKt(newIndent);
        lastIndex = CollectionsKt__CollectionsKt.getLastIndex(lines);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : lines) {
            int i17 = i16 + 1;
            if (i16 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            String str2 = (String) obj2;
            if (i16 == 0 || i16 == lastIndex) {
                isBlank = StringsKt__StringsJVMKt.isBlank(str2);
                if (isBlank) {
                    str2 = null;
                    if (str2 == null) {
                        arrayList3.add(str2);
                    }
                    i16 = i17;
                }
            }
            drop = StringsKt___StringsKt.drop(str2, i3);
            if (drop != null && (invoke = indentFunction$StringsKt__IndentKt.invoke(drop)) != null) {
                str2 = invoke;
            }
            if (str2 == null) {
            }
            i16 = i17;
        }
        joinTo$default = CollectionsKt___CollectionsKt.joinTo$default(arrayList3, new StringBuilder(length), "\n", null, null, 0, null, null, 124, null);
        String sb5 = ((StringBuilder) joinTo$default).toString();
        Intrinsics.checkNotNullExpressionValue(sb5, "mapIndexedNotNull { inde\u2026\"\\n\")\n        .toString()");
        return sb5;
    }

    public static /* synthetic */ String replaceIndent$default(String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str2 = "";
        }
        return replaceIndent(str, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00bf A[SYNTHETIC] */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final String replaceIndentByMargin(@NotNull String str, @NotNull String newIndent, @NotNull String marginPrefix) {
        boolean isBlank;
        int lastIndex;
        Appendable joinTo$default;
        boolean isBlank2;
        int i3;
        String invoke;
        boolean startsWith$default;
        boolean isWhitespace;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(newIndent, "newIndent");
        Intrinsics.checkNotNullParameter(marginPrefix, "marginPrefix");
        isBlank = StringsKt__StringsJVMKt.isBlank(marginPrefix);
        if (!isBlank) {
            List<String> lines = StringsKt__StringsKt.lines(str);
            int length = str.length() + (newIndent.length() * lines.size());
            Function1<String, String> indentFunction$StringsKt__IndentKt = getIndentFunction$StringsKt__IndentKt(newIndent);
            lastIndex = CollectionsKt__CollectionsKt.getLastIndex(lines);
            ArrayList arrayList = new ArrayList();
            int i16 = 0;
            for (Object obj : lines) {
                int i17 = i16 + 1;
                if (i16 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                String str2 = (String) obj;
                String str3 = null;
                if (i16 == 0 || i16 == lastIndex) {
                    isBlank2 = StringsKt__StringsJVMKt.isBlank(str2);
                    if (isBlank2) {
                        str2 = null;
                        if (str2 == null) {
                            arrayList.add(str2);
                        }
                        i16 = i17;
                    }
                }
                int length2 = str2.length();
                int i18 = 0;
                while (true) {
                    if (i18 < length2) {
                        isWhitespace = CharsKt__CharJVMKt.isWhitespace(str2.charAt(i18));
                        if (!isWhitespace) {
                            i3 = i18;
                            break;
                        }
                        i18++;
                    } else {
                        i3 = -1;
                        break;
                    }
                }
                if (i3 != -1) {
                    int i19 = i3;
                    startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str2, marginPrefix, i3, false, 4, null);
                    if (startsWith$default) {
                        int length3 = i19 + marginPrefix.length();
                        Intrinsics.checkNotNull(str2, "null cannot be cast to non-null type java.lang.String");
                        str3 = str2.substring(length3);
                        Intrinsics.checkNotNullExpressionValue(str3, "this as java.lang.String).substring(startIndex)");
                    }
                }
                if (str3 != null && (invoke = indentFunction$StringsKt__IndentKt.invoke(str3)) != null) {
                    str2 = invoke;
                }
                if (str2 == null) {
                }
                i16 = i17;
            }
            joinTo$default = CollectionsKt___CollectionsKt.joinTo$default(arrayList, new StringBuilder(length), "\n", null, null, 0, null, null, 124, null);
            String sb5 = ((StringBuilder) joinTo$default).toString();
            Intrinsics.checkNotNullExpressionValue(sb5, "mapIndexedNotNull { inde\u2026\"\\n\")\n        .toString()");
            return sb5;
        }
        throw new IllegalArgumentException("marginPrefix must be non-blank string.".toString());
    }

    public static /* synthetic */ String replaceIndentByMargin$default(String str, String str2, String str3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str2 = "";
        }
        if ((i3 & 2) != 0) {
            str3 = "|";
        }
        return replaceIndentByMargin(str, str2, str3);
    }

    @IntrinsicConstEvaluation
    @NotNull
    public static String trimIndent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return replaceIndent(str, "");
    }

    @IntrinsicConstEvaluation
    @NotNull
    public static final String trimMargin(@NotNull String str, @NotNull String marginPrefix) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(marginPrefix, "marginPrefix");
        return replaceIndentByMargin(str, "", marginPrefix);
    }

    public static /* synthetic */ String trimMargin$default(String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str2 = "|";
        }
        return trimMargin(str, str2);
    }
}
