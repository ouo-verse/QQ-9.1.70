package com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.center;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import ap3.a;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model.BaseComposeCardViewModel;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model.BaseComposeCardViewModelKt;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQTransferCenterViewModel;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterFilterCardViewKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class QQFTCenterFilterCardVM extends BaseComposeCardViewModel {
    public final MutableState<Integer> currentFilterType;
    public final MutableState<a> filterPopoverPosition;
    public final MutableState<Boolean> listGridMode;
    public final MutableState<Boolean> showFilterContent;

    /* renamed from: vm, reason: collision with root package name */
    public final QQTransferCenterViewModel f114263vm;

    public QQFTCenterFilterCardVM(QQTransferCenterViewModel qQTransferCenterViewModel) {
        MutableState<Boolean> mutableStateOf$default;
        MutableState<a> mutableStateOf$default2;
        MutableState<Integer> mutableStateOf$default3;
        MutableState<Boolean> mutableStateOf$default4;
        this.f114263vm = qQTransferCenterViewModel;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        this.showFilterContent = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.filterPopoverPosition = mutableStateOf$default2;
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(3, null, 2, null);
        this.currentFilterType = mutableStateOf$default3;
        mutableStateOf$default4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
        this.listGridMode = mutableStateOf$default4;
        BaseComposeCardViewModelKt.setCardViewBuilder(this, ComposableLambdaKt.composableLambdaInstance(-372076327, true, new Function5<com.tencent.ntcompose.foundation.lazy.layout.a, BaseComposeCardViewModel, Integer, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.center.QQFTCenterFilterCardVM.1
            {
                super(5);
            }

            @Override // kotlin.jvm.functions.Function5
            public final Unit invoke(com.tencent.ntcompose.foundation.lazy.layout.a aVar, BaseComposeCardViewModel baseComposeCardViewModel, Integer num, Composer composer, Integer num2) {
                num.intValue();
                Composer composer2 = composer;
                int intValue = num2.intValue();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-372076327, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.center.QQFTCenterFilterCardVM.<anonymous> (QQFTCenterFilterCardVM.kt:21)");
                }
                QQFTCenterFilterCardViewKt.QQFTCenterFilterCardView(QQFTCenterFilterCardVM.this, composer2, 8);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                return Unit.INSTANCE;
            }
        }));
    }

    public final String displayTextForFileSetListType(int i3) {
        if (i3 == 1) {
            return "\u6211\u4e0a\u4f20\u7684";
        }
        if (i3 != 2) {
            return "\u5168\u90e8";
        }
        return "\u6211\u63a5\u6536\u7684";
    }
}
