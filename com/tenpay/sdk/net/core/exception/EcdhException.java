package com.tenpay.sdk.net.core.exception;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0016\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tenpay/sdk/net/core/exception/EcdhException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "msg", "", "e", "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public class EcdhException extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EcdhException(@NotNull String msg2, @Nullable Throwable th5) {
        super(msg2, th5);
        Intrinsics.checkNotNullParameter(msg2, "msg");
    }

    public /* synthetic */ EcdhException(String str, Throwable th5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? null : th5);
    }
}
