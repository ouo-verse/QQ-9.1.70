package com.tencent.hippykotlin.demo.pages.qqflash_transfer.views;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.c;
import com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.LoadingIconType;
import com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.LoadingKt;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel;
import com.tencent.kuikly.core.views.FooterRefreshState;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.TextKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class QQFTFooterRefreshViewKt {

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FooterRefreshState.values().length];
            try {
                iArr[FooterRefreshState.REFRESHING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FooterRefreshState.IDLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FooterRefreshState.NONE_MORE_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FooterRefreshState.FAILURE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final void QQFTFooterRefreshView(final QQFlashTransferViewModel qQFlashTransferViewModel, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(2111867995);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2111867995, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFooterRefreshView (QQFTFooterRefreshView.kt:41)");
        }
        if (qQFlashTransferViewModel.footerRefreshState.getValue() != FooterRefreshState.FAILURE) {
            startRestartGroup.startReplaceableGroup(-492369756);
            Object rememberedValue = startRestartGroup.rememberedValue();
            String str = "";
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            final MutableState mutableState = (MutableState) rememberedValue;
            int i16 = WhenMappings.$EnumSwitchMapping$0[qQFlashTransferViewModel.footerRefreshState.getValue().ordinal()];
            if (i16 == 1 || i16 == 2) {
                str = "\u6570\u636e\u52a0\u8f7d\u4e2d...";
            } else if (i16 != 3) {
                if (i16 == 4) {
                    str = "\u52a0\u8f7d\u6570\u636e\u5931\u8d25";
                }
            } else if (qQFlashTransferViewModel.isFileSetExpired.getValue().booleanValue() && qQFlashTransferViewModel.showCacheTips.getValue().booleanValue()) {
                str = "\u8fc7\u671f\u6587\u4ef6\u4ec5\u5c55\u793a\u672c\u5730\u5df2\u7f13\u5b58\u6570\u636e";
            }
            mutableState.setValue(str);
            Alignment.Vertical vertical = Alignment.Vertical.CenterVertically;
            RowKt.a(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 0.0f, 10.0f, 0.0f, 10.0f, 5, null), a.f339245a.b(), vertical, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -57048415, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFooterRefreshViewKt$QQFTFooterRefreshView$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public final Unit invoke(n nVar, Composer composer2, Integer num) {
                    LoadingIconType loadingIconType;
                    Composer composer3 = composer2;
                    int intValue = num.intValue();
                    if ((intValue & 81) == 16 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                    } else {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-57048415, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFooterRefreshView.<anonymous> (QQFTFooterRefreshView.kt:71)");
                        }
                        composer3.startReplaceableGroup(343596834);
                        if (QQFlashTransferViewModel.this.footerRefreshState.getValue() == FooterRefreshState.REFRESHING) {
                            if (QUIToken.INSTANCE.isNightMode()) {
                                loadingIconType = LoadingIconType.WHITE;
                            } else {
                                loadingIconType = LoadingIconType.GRAY;
                            }
                            LoadingKt.Loading(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 18.0f), loadingIconType, composer3, 8, 0);
                        }
                        composer3.endReplaceableGroup();
                        TextKt.a(mutableState.getValue(), ComposeLayoutPropUpdaterKt.n(i.INSTANCE, 6.0f, 0.0f, 0.0f, 0.0f, 14, null), null, QUIToken.color$default("text_secondary"), Float.valueOf(14.0f), null, c.INSTANCE.e(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, 1601600, 0, 0, 134217636);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    return Unit.INSTANCE;
                }
            }), startRestartGroup, 197064, 24);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFooterRefreshViewKt$QQFTFooterRefreshView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTFooterRefreshViewKt.QQFTFooterRefreshView(QQFlashTransferViewModel.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
