package com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.compress;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.d;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class QQFTCompressHoverViewKt {
    public static final void QQFTCompressHoverView(final QQFlashTransferViewModel qQFlashTransferViewModel, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-691250651);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-691250651, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.compress.QQFTCompressHoverView (QQFTCompressHoverView.kt:22)");
        }
        ColumnKt.a(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1052035598, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.compress.QQFTCompressHoverViewKt$QQFTCompressHoverView$1
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(d dVar, Composer composer2, Integer num) {
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1052035598, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.compress.QQFTCompressHoverView.<anonymous> (QQFTCompressHoverView.kt:23)");
                    }
                    QQFTCompressTitleStatusViewKt.QQFTCompressTitleStatusView(QQFlashTransferViewModel.this, composer3, 8);
                    QQFTCompressFilterBarViewKt.QQFTCompressFilterBarView(QQFlashTransferViewModel.this, composer3, 8);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 24584, 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.compress.QQFTCompressHoverViewKt$QQFTCompressHoverView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTCompressHoverViewKt.QQFTCompressHoverView(QQFlashTransferViewModel.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
