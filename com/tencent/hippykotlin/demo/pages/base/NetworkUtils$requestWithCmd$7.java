package com.tencent.hippykotlin.demo.pages.base;

import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX WARN: Incorrect field signature: TRSP; */
/* compiled from: P */
/* loaded from: classes31.dex */
public final class NetworkUtils$requestWithCmd$7 extends Lambda implements Function1<e, Unit> {
    public final /* synthetic */ Function2<Integer, String, Unit> $failBlock;
    public final /* synthetic */ ISSORspModel $rspModel;
    public final /* synthetic */ Function1<RSP, Unit> $successBlock;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Incorrect types in method signature: (Lkotlin/jvm/functions/Function2<-Ljava/lang/Integer;-Ljava/lang/String;Lkotlin/Unit;>;TRSP;Lkotlin/jvm/functions/Function1<-TRSP;Lkotlin/Unit;>;)V */
    public NetworkUtils$requestWithCmd$7(Function2 function2, ISSORspModel iSSORspModel, Function1 function1) {
        super(1);
        this.$failBlock = function2;
        this.$rspModel = iSSORspModel;
        this.$successBlock = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(e eVar) {
        e eVar2 = eVar;
        if (eVar2 != null) {
            Function2<Integer, String, Unit> function2 = this.$failBlock;
            ISSORspModel iSSORspModel = this.$rspModel;
            Function1<RSP, Unit> function1 = this.$successBlock;
            if (eVar2.a("errorCode")) {
                int k3 = eVar2.k("errorCode", -1);
                function2.invoke(Integer.valueOf(k3), eVar2.q("errorMsg", ""));
            } else {
                function1.invoke((ISSORspModel) iSSORspModel.decode(new e(eVar2.q("data", "{}"))));
            }
        }
        return Unit.INSTANCE;
    }
}
