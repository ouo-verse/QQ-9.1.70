package com.tencent.hippykotlin.demo.pages.qq_intimate_space.card;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.modifer_ext.ModifierExtKt;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveFlowerCardViewKt;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.LoveWallHomepageViewModel;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.utils.DTReportKt;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.utils.IntimateSpaceReportUtilKt;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.luggage.wxa.yf.u;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.material.APNGKt;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.ModalKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import e25.i;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* loaded from: classes37.dex */
public final class LoveWallFlowerCardPageViewKt {
    public static final void LoveWallFlowerCardPageView(final i iVar, final LoveWallHomepageViewModel loveWallHomepageViewModel, final Function0<Unit> function0, final Function0<Unit> function02, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(1608665975);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1608665975, i3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallFlowerCardPageView (LoveWallFlowerCardPageView.kt:42)");
        }
        ModalKt.a(ModifierExtKt.pageVR(com.tencent.ntcompose.core.i.INSTANCE, "pg_qz_love_tree_home", loveWallHomepageViewModel.getPageReportParams()), false, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 487132601, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallFlowerCardPageViewKt$LoveWallFlowerCardPageView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 11) == 2 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(487132601, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallFlowerCardPageView.<anonymous> (LoveWallFlowerCardPageView.kt:50)");
                    }
                    com.tencent.ntcompose.core.i d16 = ViewEventPropUpdaterKt.d(ModifiersKt.d(ComposeLayoutPropUpdaterKt.h(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, 1, null), h.INSTANCE.a(0.5f)), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallFlowerCardPageViewKt$LoveWallFlowerCardPageView$1.1
                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                            return Unit.INSTANCE;
                        }
                    }, 3, null);
                    e intimateDTReportBaseParams = IntimateSpaceReportUtilKt.getIntimateDTReportBaseParams();
                    intimateDTReportBaseParams.v("bud_id", String.valueOf(i.this.f395478d));
                    Unit unit = Unit.INSTANCE;
                    com.tencent.ntcompose.core.i elementVR = ModifierExtKt.elementVR(d16, "em_qz_bud_unlock_pop", intimateDTReportBaseParams);
                    final i iVar2 = i.this;
                    final Function0<Unit> function03 = function02;
                    final int i16 = i3;
                    final Function0<Unit> function04 = function0;
                    final LoveWallHomepageViewModel loveWallHomepageViewModel2 = loveWallHomepageViewModel;
                    BoxKt.a(elementVR, null, null, ComposableLambdaKt.composableLambda(composer3, 1138741695, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallFlowerCardPageViewKt$LoveWallFlowerCardPageView$1.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(b bVar, Composer composer4, Integer num2) {
                            int i17;
                            b bVar2 = bVar;
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 14) == 0) {
                                i17 = (composer5.changed(bVar2) ? 4 : 2) | intValue2;
                            } else {
                                i17 = intValue2;
                            }
                            if ((i17 & 91) == 18 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1138741695, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallFlowerCardPageView.<anonymous>.<anonymous> (LoveWallFlowerCardPageView.kt:58)");
                                }
                                i.Companion companion = com.tencent.ntcompose.core.i.INSTANCE;
                                APNGKt.a(bVar2.a(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null), (com.tencent.ntcompose.activity.b.a().getPageData().m() * 407.0f) / 188.0f), Alignment.Center), null, "https://image.superqqshow.qq.com/wuji/qq_zplan_config_test/couple_space_pic_resouce/4221bcd7_5cAgmr-WmMg.png", 0, null, null, null, null, composer5, 3464, 242);
                                ColumnKt.a(ComposeLayoutPropUpdaterKt.h(companion, 0.0f, 1, null), a.f339245a.b(), Alignment.INSTANCE.b(), null, ComposableLambdaKt.composableLambda(composer5, -1280526410, true, new Function3<d, Composer, Integer, Unit>(function03, i16, function04, loveWallHomepageViewModel2) { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallFlowerCardPageViewKt.LoveWallFlowerCardPageView.1.3.1
                                    public final /* synthetic */ LoveWallHomepageViewModel $homepageViewModel;
                                    public final /* synthetic */ Function0<Unit> $onCloseBtnClick;
                                    public final /* synthetic */ Function0<Unit> $onShareBtnClick;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                        this.$onShareBtnClick = r4;
                                        this.$homepageViewModel = r5;
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(d dVar, Composer composer6, Integer num3) {
                                        Composer composer7 = composer6;
                                        int intValue3 = num3.intValue();
                                        if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                            composer7.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1280526410, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallFlowerCardPageView.<anonymous>.<anonymous>.<anonymous> (LoveWallFlowerCardPageView.kt:69)");
                                            }
                                            i.Companion companion2 = com.tencent.ntcompose.core.i.INSTANCE;
                                            RowKt.a(ComposeLayoutPropUpdaterKt.j(companion2, 0.0f, 1, null), a.f339245a.b(), null, null, null, ComposableSingletons$LoveWallFlowerCardPageViewKt.f95lambda1, composer7, 196680, 28);
                                            com.tencent.ntcompose.core.i p16 = ComposeLayoutPropUpdaterKt.p(ComposeLayoutPropUpdaterKt.v(companion2, 292, u.CTRL_INDEX), 10, 0.0f, 2, null);
                                            final e25.i iVar3 = e25.i.this;
                                            final Function0<Unit> function05 = this.$onShareBtnClick;
                                            final LoveWallHomepageViewModel loveWallHomepageViewModel3 = this.$homepageViewModel;
                                            LoveFlowerCardViewKt.LoveFlowerCardView(p16, iVar3, null, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallFlowerCardPageViewKt.LoveWallFlowerCardPageView.1.3.1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(0);
                                                }

                                                @Override // kotlin.jvm.functions.Function0
                                                public final Unit invoke() {
                                                    function05.invoke();
                                                    e pageReportParams = loveWallHomepageViewModel3.getPageReportParams();
                                                    e intimateDTReportBaseParams2 = IntimateSpaceReportUtilKt.getIntimateDTReportBaseParams();
                                                    intimateDTReportBaseParams2.v("bud_id", String.valueOf(iVar3.f395478d));
                                                    Unit unit2 = Unit.INSTANCE;
                                                    DTReportKt.reportElementClickEvent(pageReportParams, "em_qz_bud_unlock_pop", intimateDTReportBaseParams2);
                                                    return Unit.INSTANCE;
                                                }
                                            }, composer7, 72, 4);
                                            com.tencent.ntcompose.core.i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(companion2, 32.0f), 0.0f, 32, 0.0f, 0.0f, 13, null);
                                            final Function0<Unit> function06 = this.$onCloseBtnClick;
                                            composer7.startReplaceableGroup(1157296644);
                                            boolean changed = composer7.changed(function06);
                                            Object rememberedValue = composer7.rememberedValue();
                                            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                                rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallFlowerCardPageViewKt$LoveWallFlowerCardPageView$1$3$1$2$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        function06.invoke();
                                                        return Unit.INSTANCE;
                                                    }
                                                };
                                                composer7.updateRememberedValue(rememberedValue);
                                            }
                                            composer7.endReplaceableGroup();
                                            ImageKt.a(null, null, null, null, null, ViewEventPropUpdaterKt.d(n3, false, null, (Function1) rememberedValue, 3, null), null, 0, null, null, QUIToken.INSTANCE.image("close_circle", QUIToken.color$default("icon_allwhite_primary")), null, null, null, null, null, null, null, null, null, null, composer7, 262144, 0, 0, 2096095);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer5, 24648, 8);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 3080, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 24632, 12);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallFlowerCardPageViewKt$LoveWallFlowerCardPageView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                LoveWallFlowerCardPageViewKt.LoveWallFlowerCardPageView(e25.i.this, loveWallHomepageViewModel, function0, function02, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
