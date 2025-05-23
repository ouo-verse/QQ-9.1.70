package com.tencent.hippykotlin.demo.pages.jubao;

import com.tencent.kuikly.core.base.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class JubaoAnimationViewKt {
    public static final void updateVisibility(final JubaoAnimationView jubaoAnimationView, final Function0<Boolean> function0) {
        jubaoAnimationView.attr(new Function1<k, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoAnimationViewKt$updateVisibility$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(k kVar) {
                kVar.m152visibility(function0.invoke().booleanValue());
                return Unit.INSTANCE;
            }
        });
        jubaoAnimationView.inAnimationComplete = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoAnimationViewKt$updateVisibility$3
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                JubaoAnimationView.this.attr(new Function1<k, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoAnimationViewKt$updateVisibility$3.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(k kVar) {
                        k kVar2 = kVar;
                        if (kVar2.getPagerData().getIsIOS()) {
                            kVar2.m152visibility(false);
                            kVar2.m152visibility(true);
                        } else {
                            O3Module o3Module = (O3Module) kVar2.getPager().getModule("QQKuiklySecurityModule");
                            if (o3Module != null) {
                                o3Module.toNative(false, "traverseExposure", "", null, false);
                            }
                        }
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }
}
