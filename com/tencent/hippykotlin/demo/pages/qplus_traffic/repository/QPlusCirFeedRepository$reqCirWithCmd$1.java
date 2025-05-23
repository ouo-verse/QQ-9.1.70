package com.tencent.hippykotlin.demo.pages.qplus_traffic.repository;

import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes31.dex */
public final class QPlusCirFeedRepository$reqCirWithCmd$1 extends Lambda implements Function1<e, Unit> {
    public final /* synthetic */ Function4<ISSORspModel<Object>, String, Integer, String, Unit> $responseBlock;
    public final /* synthetic */ ISSORspModel<Object> $rspModel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public QPlusCirFeedRepository$reqCirWithCmd$1(ISSORspModel<Object> iSSORspModel, Function4<ISSORspModel<Object>, ? super String, ? super Integer, ? super String, Unit> function4) {
        super(1);
        this.$rspModel = iSSORspModel;
        this.$responseBlock = function4;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(e eVar) {
        e eVar2 = eVar;
        if (eVar2 != null) {
            ISSORspModel<Object> iSSORspModel = this.$rspModel;
            Function4<ISSORspModel<Object>, String, Integer, String, Unit> function4 = this.$responseBlock;
            int k3 = eVar2.k("errorCode", 0);
            String q16 = eVar2.q("errorMsg", "");
            String q17 = eVar2.q("data", "{}");
            function4.invoke((ISSORspModel) iSSORspModel.decode(new e(q17)), q17, Integer.valueOf(k3), q16);
        }
        return Unit.INSTANCE;
    }
}
