package com.tencent.hippykotlin.demo.pages.qplus_traffic.repository;

import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes31.dex */
public final class QPlusTrafficRepository$requestWithCmd$1 extends Lambda implements Function1<e, Unit> {
    public final /* synthetic */ Function2<Integer, String, Unit> $failBlock;
    public final /* synthetic */ ISSORspModel<Object> $rspModel;
    public final /* synthetic */ Function2<ISSORspModel<Object>, String, Unit> $successBlock;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public QPlusTrafficRepository$requestWithCmd$1(Function2<? super Integer, ? super String, Unit> function2, ISSORspModel<Object> iSSORspModel, Function2<ISSORspModel<Object>, ? super String, Unit> function22) {
        super(1);
        this.$failBlock = function2;
        this.$rspModel = iSSORspModel;
        this.$successBlock = function22;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(e eVar) {
        e eVar2 = eVar;
        if (eVar2 != null) {
            Function2<Integer, String, Unit> function2 = this.$failBlock;
            ISSORspModel<Object> iSSORspModel = this.$rspModel;
            Function2<ISSORspModel<Object>, String, Unit> function22 = this.$successBlock;
            if (eVar2.a("errorCode")) {
                int k3 = eVar2.k("errorCode", -1);
                function2.invoke(Integer.valueOf(k3), eVar2.q("errorMsg", ""));
            } else {
                String q16 = eVar2.q("data", "{}");
                function22.invoke((ISSORspModel) iSSORspModel.decode(new e(q16)), q16);
            }
        }
        return Unit.INSTANCE;
    }
}
