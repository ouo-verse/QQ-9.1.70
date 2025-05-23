package com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components;

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
/* loaded from: classes31.dex */
public final class QUIFooterRefreshViewKt {

    /* compiled from: P */
    /* loaded from: classes31.dex */
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

    public static final void QUIFooterRefreshView(final FooterRefreshState footerRefreshState, Composer composer, final int i3) {
        int i16;
        Composer startRestartGroup = composer.startRestartGroup(-1805388768);
        if ((i3 & 14) == 0) {
            i16 = (startRestartGroup.changed(footerRefreshState) ? 4 : 2) | i3;
        } else {
            i16 = i3;
        }
        if ((i16 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1805388768, i3, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIFooterRefreshView (QUIFooterRefreshView.kt:73)");
            }
            startRestartGroup.startReplaceableGroup(-492369756);
            Object rememberedValue = startRestartGroup.rememberedValue();
            String str = "";
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            final MutableState mutableState = (MutableState) rememberedValue;
            int i17 = WhenMappings.$EnumSwitchMapping$0[footerRefreshState.ordinal()];
            if (i17 == 1 || i17 == 2) {
                str = "\u6570\u636e\u52a0\u8f7d\u4e2d...";
            } else if (i17 == 3) {
                str = "\u6211\u4e5f\u662f\u6709\u5e95\u7ebf\u7684";
            } else if (i17 == 4) {
                str = "\u52a0\u8f7d\u6570\u636e\u5931\u8d25";
            }
            mutableState.setValue(str);
            RowKt.a(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 0.0f, 10.0f, 0.0f, 10.0f, 5, null), a.f339245a.b(), Alignment.Vertical.CenterVertically, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 342707650, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIFooterRefreshViewKt$QUIFooterRefreshView$1
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
                            ComposerKt.traceEventStart(342707650, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIFooterRefreshView.<anonymous> (QUIFooterRefreshView.kt:96)");
                        }
                        composer3.startReplaceableGroup(-1662544547);
                        if (FooterRefreshState.this == FooterRefreshState.REFRESHING) {
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
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIFooterRefreshViewKt$QUIFooterRefreshView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QUIFooterRefreshViewKt.QUIFooterRefreshView(FooterRefreshState.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
