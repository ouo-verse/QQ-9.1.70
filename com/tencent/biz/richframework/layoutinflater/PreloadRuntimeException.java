package com.tencent.biz.richframework.layoutinflater;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/biz/richframework/layoutinflater/PreloadRuntimeException;", "Ljava/lang/RuntimeException;", "message", "", "(Ljava/lang/String;)V", "layoutinflater_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class PreloadRuntimeException extends RuntimeException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreloadRuntimeException(@NotNull String message) {
        super(message);
        Intrinsics.checkNotNullParameter(message, "message");
    }
}
