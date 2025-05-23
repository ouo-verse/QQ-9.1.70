package com.tencent.hippykotlin.demo.pages.nearby.public_account.vm;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model.BaseComposeCardViewModel;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model.BaseComposeCardViewModelKt;
import com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPASimpleBarCardViewKt;
import com.tencent.ntcompose.foundation.lazy.layout.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import o35.i;

/* loaded from: classes31.dex */
public final class QQStrangerPASimpleBarCardVM extends QQStrangerPACardVM {
    public final i simpleBarCard;

    public QQStrangerPASimpleBarCardVM(i iVar, QQStrangerPublicAccountViewModel qQStrangerPublicAccountViewModel) {
        super(qQStrangerPublicAccountViewModel);
        this.simpleBarCard = iVar;
        BaseComposeCardViewModelKt.setCardViewBuilder(this, ComposableLambdaKt.composableLambdaInstance(-1676087316, true, new Function5<a, BaseComposeCardViewModel, Integer, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.vm.QQStrangerPASimpleBarCardVM.1
            {
                super(5);
            }

            @Override // kotlin.jvm.functions.Function5
            public final Unit invoke(a aVar, BaseComposeCardViewModel baseComposeCardViewModel, Integer num, Composer composer, Integer num2) {
                num.intValue();
                Composer composer2 = composer;
                int intValue = num2.intValue();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1676087316, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.public_account.vm.QQStrangerPASimpleBarCardVM.<anonymous> (QQStrangerPASimpleBarCardVM.kt:17)");
                }
                QQStrangerPASimpleBarCardViewKt.QQStrangerPASimpleBarCardView(QQStrangerPASimpleBarCardVM.this.simpleBarCard, composer2, 8);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                return Unit.INSTANCE;
            }
        }));
    }
}
