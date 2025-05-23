package com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.center;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model.BaseComposeCardViewModel;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model.BaseComposeCardViewModelKt;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQTransferCenterViewModel;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterEmptyCardViewKt;
import com.tencent.ntcompose.foundation.lazy.layout.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class QQFTCenterEmptyCardVM extends BaseComposeCardViewModel {

    /* renamed from: vm, reason: collision with root package name */
    public final QQTransferCenterViewModel f114261vm;

    public QQFTCenterEmptyCardVM(QQTransferCenterViewModel qQTransferCenterViewModel, final boolean z16) {
        this.f114261vm = qQTransferCenterViewModel;
        BaseComposeCardViewModelKt.setCardViewBuilder(this, ComposableLambdaKt.composableLambdaInstance(-1947250971, true, new Function5<a, BaseComposeCardViewModel, Integer, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.center.QQFTCenterEmptyCardVM.1
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
                    ComposerKt.traceEventStart(-1947250971, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.center.QQFTCenterEmptyCardVM.<anonymous> (QQFTCenterEmptyCardVM.kt:9)");
                }
                QQFTCenterEmptyCardViewKt.QQFTCenterEmptyCardView(QQFTCenterEmptyCardVM.this, z16, composer2, 8);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                return Unit.INSTANCE;
            }
        }));
    }
}
