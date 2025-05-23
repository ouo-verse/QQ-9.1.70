package com.tencent.qmethod.monitor.ext.traffic;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000e\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0016\u0010\b\u001a\u00020\u0007*\u00060\u0004j\u0002`\u00052\u0006\u0010\u0006\u001a\u00020\u0000\u001a\u0016\u0010\t\u001a\u00020\u0007*\u00060\u0004j\u0002`\u00052\u0006\u0010\u0001\u001a\u00020\u0000\u001a$\u0010\r\u001a\u00020\u0007*\u00060\u0004j\u0002`\u00052\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a8\u0006\u000e"}, d2 = {"", "value", "e", "d", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "key", "", "c", "a", "", "Lcom/tencent/qmethod/monitor/ext/traffic/g;", "matchResult", "b", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class c {
    public static final void a(@NotNull StringBuilder appendEncryptValue, @NotNull String value) {
        Intrinsics.checkParameterIsNotNull(appendEncryptValue, "$this$appendEncryptValue");
        Intrinsics.checkParameterIsNotNull(value, "value");
        appendEncryptValue.append(d(value));
    }

    public static final void b(@NotNull StringBuilder appendHighLightEncryptValue, @NotNull String value, @NotNull List<g> matchResult) {
        boolean contains$default;
        Intrinsics.checkParameterIsNotNull(appendHighLightEncryptValue, "$this$appendHighLightEncryptValue");
        Intrinsics.checkParameterIsNotNull(value, "value");
        Intrinsics.checkParameterIsNotNull(matchResult, "matchResult");
        for (g gVar : matchResult) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) value, (CharSequence) ("###" + gVar.getMatchValue()), false, 2, (Object) null);
            if (!contains$default) {
                value = StringsKt__StringsJVMKt.replace(value, gVar.getMatchValue(), "###" + e(gVar.getMatchValue()) + "###", true);
            }
        }
        appendHighLightEncryptValue.append(value);
    }

    public static final void c(@NotNull StringBuilder appendHightLightKey, @NotNull String key) {
        Intrinsics.checkParameterIsNotNull(appendHightLightKey, "$this$appendHightLightKey");
        Intrinsics.checkParameterIsNotNull(key, "key");
        appendHightLightKey.append("###");
        appendHightLightKey.append(key);
        appendHightLightKey.append("###");
    }

    @NotNull
    public static final String d(@NotNull String value) {
        Intrinsics.checkParameterIsNotNull(value, "value");
        if (!a.f343721k.g()) {
            return value;
        }
        return String.valueOf(value.length());
    }

    @NotNull
    public static final String e(@NotNull String value) {
        IntRange indices;
        CharSequence trim;
        Intrinsics.checkParameterIsNotNull(value, "value");
        if (!a.f343721k.g()) {
            trim = StringsKt__StringsKt.trim((CharSequence) value);
            return trim.toString();
        }
        StringBuilder sb5 = new StringBuilder(value.length());
        indices = StringsKt__StringsKt.getIndices(value);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            ((IntIterator) it).nextInt();
            sb5.append("*");
        }
        String sb6 = sb5.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb6, "sb.toString()");
        return sb6;
    }
}
