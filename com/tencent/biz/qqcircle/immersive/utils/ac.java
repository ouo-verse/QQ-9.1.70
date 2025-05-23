package com.tencent.biz.qqcircle.immersive.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt___StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0005\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/utils/ac;", "", "", "str", "b", "a", "Lkotlin/text/Regex;", "Lkotlin/text/Regex;", "regex", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class ac {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ac f90062a = new ac();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Regex regex = new Regex("[\\u4e00-\\u9fa5]");

    ac() {
    }

    private final String b(String str) {
        String take;
        String repeat;
        StringBuilder sb5 = new StringBuilder();
        int i3 = 0;
        while (i3 < str.length()) {
            if (regex.matches(String.valueOf(str.charAt(i3)))) {
                int i16 = i3;
                while (i16 < str.length() && regex.matches(String.valueOf(str.charAt(i16)))) {
                    i16++;
                }
                String substring = str.substring(i3, i16);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                if (substring.length() > 2) {
                    take = StringsKt___StringsKt.take(substring, 2);
                    repeat = StringsKt__StringsJVMKt.repeat("*", substring.length() - 2);
                    substring = take + repeat;
                }
                sb5.append(substring);
                i3 = i16;
            } else {
                sb5.append(str.charAt(i3));
                i3++;
            }
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "result.toString()");
        return sb6;
    }

    @NotNull
    public final String a(@Nullable String str) {
        boolean z16;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return "";
        }
        if (!uq3.o.r()) {
            return str;
        }
        if (str.length() <= 2) {
            return str;
        }
        return b(str);
    }
}
