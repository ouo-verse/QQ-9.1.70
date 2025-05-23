package com.tencent.hippykotlin.demo.pages.nearby.public_account.vm;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model.BaseComposeCardViewModel;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model.BaseComposeCardViewModelKt;
import com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPAInteractCardViewKt;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.lazy.layout.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import o35.f;

/* loaded from: classes31.dex */
public final class QQStrangerPAInteractCardVM extends QQStrangerPACardVM {
    public final f interactCard;

    public QQStrangerPAInteractCardVM(final int i3, f fVar, final QQStrangerPublicAccountViewModel qQStrangerPublicAccountViewModel) {
        super(qQStrangerPublicAccountViewModel);
        this.interactCard = fVar;
        BaseComposeCardViewModelKt.setCardViewBuilder(this, ComposableLambdaKt.composableLambdaInstance(188671982, true, new Function5<a, BaseComposeCardViewModel, Integer, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.vm.QQStrangerPAInteractCardVM.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(5);
            }

            @Override // kotlin.jvm.functions.Function5
            public final Unit invoke(a aVar, BaseComposeCardViewModel baseComposeCardViewModel, Integer num, Composer composer, Integer num2) {
                num.intValue();
                Composer composer2 = composer;
                int intValue = num2.intValue();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(188671982, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.public_account.vm.QQStrangerPAInteractCardVM.<anonymous> (QQStrangerPAInteractCardVM.kt:28)");
                }
                QQStrangerPAInteractCardViewKt.QQStrangerPAInteractCardView(QQStrangerPAInteractCardVM.this, i.INSTANCE, i3, this.interactCard, qQStrangerPublicAccountViewModel, composer2, 36928, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                return Unit.INSTANCE;
            }
        }));
    }
}
