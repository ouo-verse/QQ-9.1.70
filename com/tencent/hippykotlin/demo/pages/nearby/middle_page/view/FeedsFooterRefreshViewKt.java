package com.tencent.hippykotlin.demo.pages.nearby.middle_page.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.c;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.TextViewExtKt;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.e;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.views.FooterRefreshState;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.ntcompose.ui.platform.CompositionLocalsKt;
import com.tencent.ntcompose.ui.platform.a;
import com.tencent.tmassistantbase.common.TMAssistantDownloadErrorCode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class FeedsFooterRefreshViewKt {
    public static final void FeedsFooterRefreshView(final FooterRefreshState footerRefreshState, final String str, final Function0<Unit> function0, Composer composer, final int i3) {
        int i16;
        Composer startRestartGroup = composer.startRestartGroup(1318130741);
        if ((i3 & 14) == 0) {
            i16 = (startRestartGroup.changed(footerRefreshState) ? 4 : 2) | i3;
        } else {
            i16 = i3;
        }
        if ((i3 & 112) == 0) {
            i16 |= startRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i3 & 896) == 0) {
            i16 |= startRestartGroup.changed(function0) ? 256 : 128;
        }
        final int i17 = i16;
        if ((i17 & TMAssistantDownloadErrorCode.DownloadSDKErrorCode_URL_EMPTY) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1318130741, i17, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.FeedsFooterRefreshView (FeedsFooterRefreshView.kt:36)");
            }
            final a aVar = (a) startRestartGroup.consume(CompositionLocalsKt.d());
            ColumnKt.a(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), null, Alignment.INSTANCE.b(), null, ComposableLambdaKt.composableLambda(startRestartGroup, -1892733460, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.FeedsFooterRefreshViewKt$FeedsFooterRefreshView$1

                /* compiled from: P */
                /* loaded from: classes31.dex */
                public /* synthetic */ class WhenMappings {
                    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                    static {
                        int[] iArr = new int[FooterRefreshState.values().length];
                        try {
                            iArr[FooterRefreshState.NONE_MORE_DATA.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        try {
                            iArr[FooterRefreshState.IDLE.ordinal()] = 2;
                        } catch (NoSuchFieldError unused2) {
                        }
                        try {
                            iArr[FooterRefreshState.REFRESHING.ordinal()] = 3;
                        } catch (NoSuchFieldError unused3) {
                        }
                        $EnumSwitchMapping$0 = iArr;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            ComposerKt.traceEventStart(-1892733460, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.FeedsFooterRefreshView.<anonymous> (FeedsFooterRefreshView.kt:46)");
                        }
                        int i18 = WhenMappings.$EnumSwitchMapping$0[FooterRefreshState.this.ordinal()];
                        if (i18 == 1 || i18 == 2) {
                            composer3.startReplaceableGroup(-1606654980);
                            String str2 = str;
                            Function0<Unit> function02 = function0;
                            int i19 = i17 >> 3;
                            FeedsFooterRefreshViewKt.access$FeedsNoneDataView(str2, function02, composer3, (i19 & 112) | (i19 & 14));
                            composer3.endReplaceableGroup();
                        } else if (i18 != 3) {
                            composer3.startReplaceableGroup(-1606654850);
                            composer3.endReplaceableGroup();
                        } else {
                            composer3.startReplaceableGroup(-1606654889);
                            FeedsFooterRefreshViewKt.access$FeedsLoadingView(composer3, 0);
                            composer3.endReplaceableGroup();
                        }
                        SpacerKt.a(ComposeLayoutPropUpdaterKt.k(i.INSTANCE, aVar.f().getBottom() + 120.0f), composer3, 8, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    return Unit.INSTANCE;
                }
            }), startRestartGroup, 24584, 10);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.FeedsFooterRefreshViewKt$FeedsFooterRefreshView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                FeedsFooterRefreshViewKt.FeedsFooterRefreshView(FooterRefreshState.this, str, function0, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void access$FeedsLoadingView(Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-1407166187);
        if (i3 == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1407166187, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.FeedsLoadingView (FeedsFooterRefreshView.kt:86)");
            }
            Alignment.Vertical vertical = Alignment.Vertical.CenterVertically;
            RowKt.a(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), com.tencent.ntcompose.foundation.layout.base.a.f339245a.b(), vertical, null, null, ComposableSingletons$FeedsFooterRefreshViewKt.f48lambda1, startRestartGroup, 197064, 24);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.FeedsFooterRefreshViewKt$FeedsLoadingView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                FeedsFooterRefreshViewKt.access$FeedsLoadingView(composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void access$FeedsNoneDataView(final String str, final Function0 function0, Composer composer, final int i3) {
        int i16;
        Composer startRestartGroup = composer.startRestartGroup(1733847724);
        if ((i3 & 14) == 0) {
            i16 = (startRestartGroup.changed(str) ? 4 : 2) | i3;
        } else {
            i16 = i3;
        }
        if ((i3 & 112) == 0) {
            i16 |= startRestartGroup.changed(function0) ? 32 : 16;
        }
        if ((i16 & 91) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1733847724, i16, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.FeedsNoneDataView (FeedsFooterRefreshView.kt:59)");
            }
            Alignment.Vertical vertical = Alignment.Vertical.CenterVertically;
            a.e b16 = com.tencent.ntcompose.foundation.layout.base.a.f339245a.b();
            i r16 = ComposeLayoutPropUpdaterKt.r(ModifiersKt.c(ModifiersKt.g(ModifiersKt.j(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.B(i.INSTANCE), 56.0f), 28.0f), new e(0.5f, BorderStyle.SOLID, QUIToken.color$default("fill_standard_quaternary"))), QUIToken.color$default("fill_light_primary")), 24.0f, 16.0f, 20.0f, 16.0f);
            startRestartGroup.startReplaceableGroup(1157296644);
            boolean changed = startRestartGroup.changed(function0);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.FeedsFooterRefreshViewKt$FeedsNoneDataView$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ClickParams clickParams) {
                        function0.invoke();
                        return Unit.INSTANCE;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            RowKt.a(ViewEventPropUpdaterKt.d(r16, false, null, (Function1) rememberedValue, 3, null), b16, vertical, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 427583438, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.FeedsFooterRefreshViewKt$FeedsNoneDataView$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public final Unit invoke(n nVar, Composer composer2, Integer num) {
                    Composer composer3 = composer2;
                    int intValue = num.intValue();
                    if ((intValue & 81) == 16 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                    } else {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(427583438, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.FeedsNoneDataView.<anonymous> (FeedsFooterRefreshView.kt:68)");
                        }
                        String fixLineHeightForView = TextViewExtKt.fixLineHeightForView(str);
                        c f16 = c.INSTANCE.f();
                        h color$default = QUIToken.color$default("icon_primary");
                        i.Companion companion = i.INSTANCE;
                        TextKt.a(fixLineHeightForView, ComposeLayoutPropUpdaterKt.n(companion, 0.0f, 0.0f, 4.0f, 0.0f, 11, null), null, color$default, Float.valueOf(17.0f), null, f16, null, null, null, null, Float.valueOf(24.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, 1601600, 48, 0, 134215588);
                        ImageKt.a("https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_O5hebu2czEP.png", null, null, null, null, ComposeLayoutPropUpdaterKt.u(companion, 20.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, QUIToken.color$default("icon_primary"), null, composer3, 262150, 1073741824, 0, 1572830);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.FeedsFooterRefreshViewKt$FeedsNoneDataView$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                FeedsFooterRefreshViewKt.access$FeedsNoneDataView(str, function0, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
