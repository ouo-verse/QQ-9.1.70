package com.tencent.hippykotlin.demo.pages.nearby.public_account.vm;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.avbiz.Constants;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model.BaseComposeCardViewModel;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model.BaseComposeCardViewModelKt;
import com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPAEntranceCardViewKt;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.lazy.layout.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import o35.b;

/* loaded from: classes31.dex */
public final class QQStrangerPAEntranceCardVM extends QQStrangerPACardVM {
    public final b entranceCard;
    public final boolean isJiShiShanLiaoCard;
    public final boolean isYuYinLianMai;

    public QQStrangerPAEntranceCardVM(b bVar, QQStrangerPublicAccountViewModel qQStrangerPublicAccountViewModel) {
        super(qQStrangerPublicAccountViewModel);
        this.entranceCard = bVar;
        this.isJiShiShanLiaoCard = Intrinsics.areEqual(bVar != null ? bVar.f421880d : null, "\u5373\u65f6\u95ea\u804a");
        this.isYuYinLianMai = Intrinsics.areEqual(bVar != null ? bVar.f421880d : null, Constants.Business.MATCH_FRIEND);
        BaseComposeCardViewModelKt.setCardViewBuilder(this, ComposableLambdaKt.composableLambdaInstance(-1634394386, true, new Function5<a, BaseComposeCardViewModel, Integer, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.vm.QQStrangerPAEntranceCardVM.1
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
                    ComposerKt.traceEventStart(-1634394386, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.public_account.vm.QQStrangerPAEntranceCardVM.<anonymous> (QQStrangerPAEntranceCardVM.kt:32)");
                }
                QQStrangerPAEntranceCardVM qQStrangerPAEntranceCardVM = QQStrangerPAEntranceCardVM.this;
                QQStrangerPAEntranceCardViewKt.QQStrangerPAEntranceCardView(qQStrangerPAEntranceCardVM, i.INSTANCE, this.entranceCard, qQStrangerPAEntranceCardVM, composer2, PlayerResources.ViewId.CANVAS_VIDEO_TOTAL_TRAFFIC_TEXT, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                return Unit.INSTANCE;
            }
        }));
    }
}
