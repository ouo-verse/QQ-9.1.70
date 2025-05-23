package com.qwallet.pay;

import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class PayLogicFactory$mInvokeIDToLogicMap$8 extends FunctionReferenceImpl implements Function2<Context, Intent, o> {
    public static final PayLogicFactory$mInvokeIDToLogicMap$8 INSTANCE = new PayLogicFactory$mInvokeIDToLogicMap$8();

    PayLogicFactory$mInvokeIDToLogicMap$8() {
        super(2, o.class, "<init>", "<init>(Landroid/content/Context;Landroid/content/Intent;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    @NotNull
    public final o invoke(Context context, Intent intent) {
        return new o(context, intent);
    }
}
