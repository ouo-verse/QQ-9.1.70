package com.tencent.hippykotlin.demo.pages.base;

import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class NetworkUtils$requestWithCmd$2 extends Lambda implements Function1<e, Unit> {
    public final /* synthetic */ Function3<Object, Integer, String, Unit> $responseBlock;
    public final /* synthetic */ ISSOModelFactory<Object> $rspFactory;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NetworkUtils$requestWithCmd$2(ISSOModelFactory<Object> iSSOModelFactory, Function3<Object, ? super Integer, ? super String, Unit> function3) {
        super(1);
        this.$rspFactory = iSSOModelFactory;
        this.$responseBlock = function3;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(e eVar) {
        e eVar2 = eVar;
        if (eVar2 != null) {
            ISSOModelFactory<Object> iSSOModelFactory = this.$rspFactory;
            Function3<Object, Integer, String, Unit> function3 = this.$responseBlock;
            Object decode = iSSOModelFactory.decode(new e(eVar2.q("data", "{}")));
            int k3 = eVar2.k("errorCode", 0);
            function3.invoke(decode, Integer.valueOf(k3), eVar2.q("errorMsg", ""));
        }
        return Unit.INSTANCE;
    }
}
