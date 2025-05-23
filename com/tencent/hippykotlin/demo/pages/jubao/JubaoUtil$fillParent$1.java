package com.tencent.hippykotlin.demo.pages.jubao;

import com.tencent.kuikly.core.base.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes31.dex */
public final class JubaoUtil$fillParent$1 extends Lambda implements Function1<k, Unit> {
    public final /* synthetic */ float $top;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JubaoUtil$fillParent$1(float f16) {
        super(1);
        this.$top = f16;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(k kVar) {
        k kVar2 = kVar;
        kVar2.positionAbsolute();
        kVar2.m142left(0.0f);
        kVar2.m149right(0.0f);
        kVar2.m150top(this.$top);
        kVar2.m138bottom(0.0f);
        return Unit.INSTANCE;
    }
}
