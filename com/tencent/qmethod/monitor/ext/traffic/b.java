package com.tencent.qmethod.monitor.ext.traffic;

import com.tencent.qmethod.pandoraex.core.o;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0004\u001a\u00020\u0000\u00a8\u0006\b"}, d2 = {"", "key", "Lcom/tencent/qmethod/monitor/ext/traffic/NetworkCaptureRule;", "a", "value", "", "Lcom/tencent/qmethod/monitor/ext/traffic/g;", "b", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class b {
    @Nullable
    public static final NetworkCaptureRule a(@NotNull String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        if (!a.f343721k.h()) {
            return null;
        }
        String lowerCase = key.toLowerCase();
        Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase()");
        for (NetworkCaptureRule networkCaptureRule : NetworkCaptureDefine.f343696k.a()) {
            if (networkCaptureRule.getEnable() && (networkCaptureRule.getValRule() & 1) > 0) {
                for (String str : networkCaptureRule.getKeys()) {
                    if (Intrinsics.areEqual(lowerCase, str)) {
                        return networkCaptureRule;
                    }
                }
            }
        }
        return null;
    }

    @NotNull
    public static final List<g> b(@NotNull String value) {
        CharSequence trim;
        boolean equals;
        boolean contains;
        Intrinsics.checkParameterIsNotNull(value, "value");
        ArrayList arrayList = new ArrayList();
        trim = StringsKt__StringsKt.trim((CharSequence) value);
        if (!Intrinsics.areEqual("", trim.toString())) {
            for (NetworkCaptureRule networkCaptureRule : NetworkCaptureDefine.f343696k.a()) {
                if (networkCaptureRule.getEnable()) {
                    if ((networkCaptureRule.getValRule() & 4) > 0) {
                        for (Regex regex : networkCaptureRule.getRegex()) {
                            Sequence<MatchResult> findAll$default = Regex.findAll$default(regex, value, 0, 2, null);
                            if (findAll$default != null) {
                                for (MatchResult matchResult : findAll$default) {
                                    if (!matchResult.getGroupValues().isEmpty()) {
                                        arrayList.add(new g(4, networkCaptureRule, matchResult.getGroupValues().get(0)));
                                    }
                                }
                            }
                        }
                    }
                    if ((networkCaptureRule.getValRule() & 2) > 0) {
                        Set<String> g16 = networkCaptureRule.g();
                        g16.remove("");
                        for (String str : g16) {
                            if (str != null && (!Intrinsics.areEqual("", str))) {
                                equals = StringsKt__StringsJVMKt.equals(str, value, true);
                                if (equals) {
                                    arrayList.add(new g(2, networkCaptureRule, value));
                                } else if ((networkCaptureRule.getValRule() & 8) > 0 && str.length() > networkCaptureRule.getValMinLengthFroContain()) {
                                    contains = StringsKt__StringsKt.contains((CharSequence) value, (CharSequence) str, true);
                                    if (contains) {
                                        arrayList.add(new g(8, networkCaptureRule, str));
                                        if (a.f343721k.i()) {
                                            o.a("NetworkCapture", "getMatchSensitiveRuleValue valueContain " + value + " sen " + str + " ca " + networkCaptureRule.getSensitiveCategory());
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return arrayList;
    }
}
