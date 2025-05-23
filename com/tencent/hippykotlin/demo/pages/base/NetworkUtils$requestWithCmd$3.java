package com.tencent.hippykotlin.demo.pages.base;

import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class NetworkUtils$requestWithCmd$3 extends Lambda implements Function1<e, Unit> {
    public final /* synthetic */ Function2<Integer, String, Unit> $failBlock;
    public final /* synthetic */ ISSOModelFactory<Object> $rspFactory;
    public final /* synthetic */ Function1<Object, Unit> $successBlock;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NetworkUtils$requestWithCmd$3(Function2<? super Integer, ? super String, Unit> function2, ISSOModelFactory<Object> iSSOModelFactory, Function1<Object, Unit> function1) {
        super(1);
        this.$failBlock = function2;
        this.$rspFactory = iSSOModelFactory;
        this.$successBlock = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(e eVar) {
        e eVar2 = eVar;
        if (eVar2 != null) {
            Function2<Integer, String, Unit> function2 = this.$failBlock;
            ISSOModelFactory<Object> iSSOModelFactory = this.$rspFactory;
            Function1<Object, Unit> function1 = this.$successBlock;
            if (eVar2.a("errorCode")) {
                int k3 = eVar2.k("errorCode", -1);
                function2.invoke(Integer.valueOf(k3), eVar2.q("errorMsg", ""));
            } else {
                function1.invoke(iSSOModelFactory.decode(new e(eVar2.q("data", "{}"))));
            }
        }
        return Unit.INSTANCE;
    }
}
