package com.tenpay.payment;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0004"}, d2 = {"TAG_PAYMENT", "", "getPaymentTag", "", "qwallet-impl_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class QWalletPaymentExtKt {

    @NotNull
    public static final String TAG_PAYMENT = "Payment-";

    @NotNull
    public static final String getPaymentTag(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        return TAG_PAYMENT + obj.getClass().getSimpleName();
    }
}
