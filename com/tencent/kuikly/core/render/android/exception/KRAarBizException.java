package com.tencent.kuikly.core.render.android.exception;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/kuikly/core/render/android/exception/KRAarBizException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "t", "", "(Ljava/lang/Throwable;)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class KRAarBizException extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KRAarBizException(@NotNull Throwable t16) {
        super(t16);
        Intrinsics.checkNotNullParameter(t16, "t");
    }
}
