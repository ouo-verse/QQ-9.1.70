package com.tencent.hippykotlin.demo.pages.nearby.public_account.vm;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model.BaseComposeCardViewModel;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model.BaseComposeCardViewModelKt;
import com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPATextCardViewKt;
import com.tencent.ntcompose.foundation.lazy.layout.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import kotlin.text.StringsKt__StringsJVMKt;
import o35.j;

/* loaded from: classes31.dex */
public final class QQStrangerPATextCardVM extends QQStrangerPACardVM {
    public final j textCard;

    public QQStrangerPATextCardVM(j jVar, QQStrangerPublicAccountViewModel qQStrangerPublicAccountViewModel) {
        super(qQStrangerPublicAccountViewModel);
        this.textCard = jVar;
        BaseComposeCardViewModelKt.setCardViewBuilder(this, ComposableLambdaKt.composableLambdaInstance(710635968, true, new Function5<a, BaseComposeCardViewModel, Integer, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.vm.QQStrangerPATextCardVM.1
            {
                super(5);
            }

            @Override // kotlin.jvm.functions.Function5
            public final Unit invoke(a aVar, BaseComposeCardViewModel baseComposeCardViewModel, Integer num, Composer composer, Integer num2) {
                c45.a aVar2;
                byte[] bArr;
                num.intValue();
                Composer composer2 = composer;
                int intValue = num2.intValue();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(710635968, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.public_account.vm.QQStrangerPATextCardVM.<anonymous> (QQStrangerPATextCardVM.kt:18)");
                }
                j jVar2 = QQStrangerPATextCardVM.this.textCard;
                QQStrangerPATextCardViewKt.QQStrangerPATextCardView(String.valueOf((jVar2 == null || (aVar2 = jVar2.f421921d) == null || (bArr = aVar2.f30291a) == null) ? null : StringsKt__StringsJVMKt.decodeToString(bArr)), composer2, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                return Unit.INSTANCE;
            }
        }));
    }
}
