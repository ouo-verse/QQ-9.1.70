package com.tencent.hippykotlin.demo.pages.foundation.view;

import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes31.dex */
public final class QQVideoView$getCurrentPositionMs$1 extends Lambda implements Function1<e, Unit> {
    public final /* synthetic */ Function1<Long, Unit> $callback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public QQVideoView$getCurrentPositionMs$1(Function1<? super Long, Unit> function1) {
        super(1);
        this.$callback = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(e eVar) {
        e eVar2 = eVar;
        if (eVar2 != null) {
            this.$callback.invoke(Long.valueOf(eVar2.n("position")));
        }
        return Unit.INSTANCE;
    }
}
