package com.qwallet.pay;

import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class PayLogicFactory$mInvokeIDToLogicMap$20 extends FunctionReferenceImpl implements Function2<Context, Intent, LogicQueryTenpayData> {
    public static final PayLogicFactory$mInvokeIDToLogicMap$20 INSTANCE = new PayLogicFactory$mInvokeIDToLogicMap$20();

    PayLogicFactory$mInvokeIDToLogicMap$20() {
        super(2, LogicQueryTenpayData.class, "<init>", "<init>(Landroid/content/Context;Landroid/content/Intent;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    @NotNull
    public final LogicQueryTenpayData invoke(Context context, Intent intent) {
        return new LogicQueryTenpayData(context, intent);
    }
}
