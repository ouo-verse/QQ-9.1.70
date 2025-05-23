package com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model.BaseComposeCardViewModel;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model.BaseComposeCardViewModelKt;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTExpiredHeaderCardViewKt;
import com.tencent.ntcompose.foundation.lazy.layout.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class QQFTExpiredHeaderCardVM extends BaseComposeCardViewModel {
    public final boolean isExpired;

    /* renamed from: vm, reason: collision with root package name */
    public final QQFlashTransferViewModel f114260vm;

    public QQFTExpiredHeaderCardVM(QQFlashTransferViewModel qQFlashTransferViewModel, boolean z16) {
        this.f114260vm = qQFlashTransferViewModel;
        this.isExpired = z16;
        BaseComposeCardViewModelKt.setCardViewBuilder(this, ComposableLambdaKt.composableLambdaInstance(-507200134, true, new Function5<a, BaseComposeCardViewModel, Integer, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.QQFTExpiredHeaderCardVM.1
            {
                super(5);
            }

            @Override // kotlin.jvm.functions.Function5
            public final Unit invoke(a aVar, BaseComposeCardViewModel baseComposeCardViewModel, Integer num, Composer composer, Integer num2) {
                num.intValue();
                Composer composer2 = composer;
                int intValue = num2.intValue();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-507200134, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.QQFTExpiredHeaderCardVM.<anonymous> (QQFTExpiredHeaderCardVM.kt:9)");
                }
                QQFTExpiredHeaderCardVM qQFTExpiredHeaderCardVM = QQFTExpiredHeaderCardVM.this;
                QQFTExpiredHeaderCardViewKt.QQFTExpiredHeaderCardView(qQFTExpiredHeaderCardVM, qQFTExpiredHeaderCardVM.isExpired, composer2, 8);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                return Unit.INSTANCE;
            }
        }));
    }
}
