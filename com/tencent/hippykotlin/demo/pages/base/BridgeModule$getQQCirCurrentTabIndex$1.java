package com.tencent.hippykotlin.demo.pages.base;

import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class BridgeModule$getQQCirCurrentTabIndex$1 extends Lambda implements Function1<e, Unit> {
    public final /* synthetic */ Function1<Integer, Unit> $callbackFn;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BridgeModule$getQQCirCurrentTabIndex$1(Function1<? super Integer, Unit> function1) {
        super(1);
        this.$callbackFn = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(e eVar) {
        e eVar2 = eVar;
        this.$callbackFn.invoke(Integer.valueOf(eVar2 != null ? eVar2.k("index", 0) : 0));
        return Unit.INSTANCE;
    }
}
