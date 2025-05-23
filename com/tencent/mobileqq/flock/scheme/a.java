package com.tencent.mobileqq.flock.scheme;

import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u001a6\u0010\u0006\u001a\u00020\u0004*\u001e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0000j\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001`\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004\u001a6\u0010\b\u001a\u00020\u0007*\u001e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0000j\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001`\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0007\u00a8\u0006\t"}, d2 = {"Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "paramKey", "", RemoteHandleConst.PARAM_DEFAULT_VALUE, "a", "", "b", "qq-flock-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class a {
    public static final int a(@NotNull HashMap<String, String> hashMap, @NotNull String paramKey, int i3) {
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(hashMap, "<this>");
        Intrinsics.checkNotNullParameter(paramKey, "paramKey");
        String str = hashMap.get(paramKey);
        if (str == null) {
            str = String.valueOf(i3);
        }
        intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(str);
        if (intOrNull != null) {
            return intOrNull.intValue();
        }
        return i3;
    }

    public static final long b(@NotNull HashMap<String, String> hashMap, @NotNull String paramKey, long j3) {
        Long longOrNull;
        Intrinsics.checkNotNullParameter(hashMap, "<this>");
        Intrinsics.checkNotNullParameter(paramKey, "paramKey");
        String str = hashMap.get(paramKey);
        if (str == null) {
            str = String.valueOf(j3);
        }
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(str);
        if (longOrNull != null) {
            return longOrNull.longValue();
        }
        return j3;
    }
}
