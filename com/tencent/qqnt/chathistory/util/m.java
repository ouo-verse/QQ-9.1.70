package com.tencent.qqnt.chathistory.util;

import android.util.TypedValue;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u001a\u0017\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001\u00a2\u0006\u0004\b\u0002\u0010\u0003\u001a\u0017\u0010\u0004\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001\u00a2\u0006\u0004\b\u0004\u0010\u0003\"\u0015\u0010\b\u001a\u00020\u0005*\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\"\u0015\u0010\b\u001a\u00020\u0005*\u00020\u00018F\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"T", "", "c", "(Ljava/lang/Number;)Ljava/lang/Object;", "d", "", "a", "(I)I", "dp", "b", "(Ljava/lang/Number;)I", "chathistory_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class m {
    public static final int a(int i3) {
        return ((Number) c(Integer.valueOf(i3))).intValue();
    }

    public static final int b(@NotNull Number number) {
        Intrinsics.checkNotNullParameter(number, "<this>");
        return ((Number) c(number)).intValue();
    }

    public static final <T> T c(@NotNull Number number) {
        Intrinsics.checkNotNullParameter(number, "<this>");
        return (T) Float.valueOf(TypedValue.applyDimension(1, number.floatValue(), BaseApplication.getContext().getResources().getDisplayMetrics()));
    }

    public static final <T> T d(@NotNull Number number) {
        Intrinsics.checkNotNullParameter(number, "<this>");
        return (T) Float.valueOf(TypedValue.applyDimension(2, number.floatValue(), BaseApplication.getContext().getResources().getDisplayMetrics()));
    }
}
