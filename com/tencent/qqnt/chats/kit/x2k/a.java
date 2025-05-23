package com.tencent.qqnt.chats.kit.x2k;

import com.tencent.mobileqq.utils.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0003\u001a\u0017\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"T", "", "a", "(Ljava/lang/Number;)Ljava/lang/Object;", "chats_kit_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a {
    public static final <T> T a(@NotNull Number number) {
        Intrinsics.checkNotNullParameter(number, "<this>");
        return (T) Integer.valueOf(ViewUtils.dpToPx(number.floatValue()));
    }
}
