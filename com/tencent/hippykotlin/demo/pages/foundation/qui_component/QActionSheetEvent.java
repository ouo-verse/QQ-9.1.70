package com.tencent.hippykotlin.demo.pages.foundation.qui_component;

import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class QActionSheetEvent extends l {
    public final void onClickWithText(final Function1<? super ActionButtonParams, Unit> function1) {
        register("onClickWithText", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.qui_component.QActionSheetEvent$onClickWithText$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                Function1<ActionButtonParams, Unit> function12 = function1;
                e eVar = obj instanceof e ? (e) obj : null;
                if (eVar == null) {
                    eVar = new e();
                }
                function12.invoke(new ActionButtonParams(eVar.k("index", -1), eVar.q("text", "")));
                return Unit.INSTANCE;
            }
        });
    }
}
