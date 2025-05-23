package com.tencent.state.utils;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/tencent/state/utils/StringFormatUtils;", "", "()V", "list", "", "", "formatString", "", "text", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class StringFormatUtils {
    public static final StringFormatUtils INSTANCE = new StringFormatUtils();
    private static final List<Integer> list;

    static {
        List<Integer> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{9, 10, 11, 12, 13, 32, 133, 160});
        list = listOf;
    }

    StringFormatUtils() {
    }

    public final String formatString(String text) {
        int i3 = 0;
        if (text == null || text.length() == 0) {
            return "";
        }
        int length = text.length();
        int length2 = text.length();
        while (true) {
            if (i3 >= length2) {
                i3 = -1;
                break;
            }
            if (!list.contains(Integer.valueOf(text.charAt(i3)))) {
                break;
            }
            i3++;
        }
        if (i3 == -1) {
            return "";
        }
        int length3 = text.length() - 1;
        if (length3 >= i3) {
            while (true) {
                if (!list.contains(Integer.valueOf(text.charAt(length3)))) {
                    length = length3 + 1;
                    break;
                }
                if (length3 == i3) {
                    break;
                }
                length3--;
            }
        }
        String substring = text.substring(i3, length);
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        return substring;
    }
}
