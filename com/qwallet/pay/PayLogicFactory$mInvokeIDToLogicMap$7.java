package com.qwallet.pay;

import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class PayLogicFactory$mInvokeIDToLogicMap$7 extends FunctionReferenceImpl implements Function2<Context, Intent, LogicOpenPay> {
    public static final PayLogicFactory$mInvokeIDToLogicMap$7 INSTANCE = new PayLogicFactory$mInvokeIDToLogicMap$7();

    PayLogicFactory$mInvokeIDToLogicMap$7() {
        super(2, LogicOpenPay.class, "<init>", "<init>(Landroid/content/Context;Landroid/content/Intent;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    @NotNull
    public final LogicOpenPay invoke(@Nullable Context context, @Nullable Intent intent) {
        return new LogicOpenPay(context, intent);
    }
}
