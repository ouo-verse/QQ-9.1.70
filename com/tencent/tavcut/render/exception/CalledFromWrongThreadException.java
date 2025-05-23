package com.tencent.tavcut.render.exception;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/tavcut/render/exception/CalledFromWrongThreadException;", "Ljava/lang/RuntimeException;", "msg", "", "(Ljava/lang/String;)V", "lib_tavcut_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class CalledFromWrongThreadException extends RuntimeException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CalledFromWrongThreadException(@NotNull String msg2) {
        super(msg2);
        Intrinsics.checkParameterIsNotNull(msg2, "msg");
    }
}
