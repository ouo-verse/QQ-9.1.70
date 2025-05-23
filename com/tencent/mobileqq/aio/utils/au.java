package com.tencent.mobileqq.aio.utils;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a&\u0010\u0003\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u0087\u0004\u00a2\u0006\u0004\b\u0003\u0010\u0004\u001a,\u0010\u0007\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\u0004\u0018\u00010\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0087\u0004\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"T", "", "value", "a", "(Ljava/lang/Boolean;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlin/Function0;", "block", "b", "(Ljava/lang/Boolean;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "aio_api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class au {
    @SyntaxExtend
    @Nullable
    public static final <T> T a(@Nullable Boolean bool, T t16) {
        if (bool == null) {
            return null;
        }
        if (!bool.booleanValue()) {
            t16 = null;
        }
        return t16;
    }

    @SyntaxExtend
    @Nullable
    public static final <T> T b(@Nullable Boolean bool, @NotNull Function0<? extends T> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (bool == null || !bool.booleanValue()) {
            return null;
        }
        return block.invoke();
    }
}
