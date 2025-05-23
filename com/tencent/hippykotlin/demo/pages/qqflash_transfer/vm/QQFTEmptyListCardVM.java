package com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model.BaseComposeCardViewModel;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model.BaseComposeCardViewModelKt;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTEmptyListViewKt;
import com.tencent.ntcompose.foundation.lazy.layout.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class QQFTEmptyListCardVM extends QQFTCardVM {
    public final MutableState<String> displayText;

    public QQFTEmptyListCardVM(QQFlashTransferViewModel qQFlashTransferViewModel, String str) {
        MutableState<String> mutableStateOf$default;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("\u5f53\u524d\u6ca1\u6709\u6587\u4ef6", null, 2, null);
        this.displayText = mutableStateOf$default;
        if (str != null) {
            mutableStateOf$default.setValue(str);
        }
        BaseComposeCardViewModelKt.setCardViewBuilder(this, ComposableLambdaKt.composableLambdaInstance(1685428552, true, new Function5<a, BaseComposeCardViewModel, Integer, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.QQFTEmptyListCardVM.1
            {
                super(5);
            }

            @Override // kotlin.jvm.functions.Function5
            public final Unit invoke(a aVar, BaseComposeCardViewModel baseComposeCardViewModel, Integer num, Composer composer, Integer num2) {
                num.intValue();
                Composer composer2 = composer;
                int intValue = num2.intValue();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1685428552, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.QQFTEmptyListCardVM.<anonymous> (QQFTEmptyListCardVM.kt:27)");
                }
                QQFTEmptyListViewKt.QQFTEmptyListView(QQFTEmptyListCardVM.this.displayText.getValue(), composer2, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                return Unit.INSTANCE;
            }
        }));
    }
}
