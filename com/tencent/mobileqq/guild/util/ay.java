package com.tencent.mobileqq.guild.util;

import java.text.BreakIterator;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0004\"\u0017\u0010\u0003\u001a\u00020\u0000*\u0004\u0018\u00010\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0001\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"", "a", "(Ljava/lang/String;)Ljava/lang/String;", "maskedText", "qqguild-api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class ay {
    @NotNull
    public static final String a(@Nullable String str) {
        boolean z16;
        String joinToString$default;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return "";
        }
        BreakIterator characterInstance = BreakIterator.getCharacterInstance();
        characterInstance.setText(str);
        ArrayList arrayList = new ArrayList();
        int first = characterInstance.first();
        int next = characterInstance.next();
        while (true) {
            int i3 = next;
            int i16 = first;
            first = i3;
            if (first == -1 || arrayList.size() >= 2) {
                break;
            }
            String substring = str.substring(i16, first);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            arrayList.add(substring);
            next = characterInstance.next();
        }
        if (first == -1) {
            return str;
        }
        StringBuilder sb5 = new StringBuilder();
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, "", null, null, 0, null, null, 62, null);
        sb5.append(joinToString$default);
        sb5.append("**");
        return sb5.toString();
    }
}
