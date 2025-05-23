package com.qwallet.pay;

import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class PayLogicFactory$mInvokeIDToLogicMap$14 extends FunctionReferenceImpl implements Function2<Context, Intent, l> {
    public static final PayLogicFactory$mInvokeIDToLogicMap$14 INSTANCE = new PayLogicFactory$mInvokeIDToLogicMap$14();

    PayLogicFactory$mInvokeIDToLogicMap$14() {
        super(2, l.class, "<init>", "<init>(Landroid/content/Context;Landroid/content/Intent;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    @NotNull
    public final l invoke(Context context, Intent intent) {
        return new l(context, intent);
    }
}
