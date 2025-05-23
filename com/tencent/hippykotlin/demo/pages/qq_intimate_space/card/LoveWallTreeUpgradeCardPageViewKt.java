package com.tencent.hippykotlin.demo.pages.qq_intimate_space.card;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.j;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSBottomDynamicGuideEvent;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.modifer_ext.ModifierExtKt;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveSproutCardViewKt;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallButtonConfig;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallButtonKt;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallButtonTextColor;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallFlowerGeneralCardConfig;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallFlowerGeneralCardKt;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.LoveWallHomepageViewModel;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.utils.DTReportKt;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.utils.IntimateSpaceReportUtilKt;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.ModalKt;
import com.tencent.ntcompose.material.RichTextKt;
import com.tencent.ntcompose.material.ai;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.ntcompose.material.n;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.text.StringsKt__StringsJVMKt;

/* loaded from: classes37.dex */
public final class LoveWallTreeUpgradeCardPageViewKt {
    public static final void LoveWallTreeUpgradeCardPageView(final TreeUpgradeCardViewModel treeUpgradeCardViewModel, final LoveWallHomepageViewModel loveWallHomepageViewModel, final Function0<Unit> function0, final Function0<Unit> function02, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-985372633);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-985372633, i3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallTreeUpgradeCardPageView (LoveWallTreeUpgradeCardPageView.kt:43)");
        }
        ModalKt.a(ModifierExtKt.pageVR(i.INSTANCE, "pg_qz_love_tree_home", loveWallHomepageViewModel.getPageReportParams()), false, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1005962331, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallTreeUpgradeCardPageViewKt$LoveWallTreeUpgradeCardPageView$1
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
                        ComposerKt.traceEventStart(-1005962331, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallTreeUpgradeCardPageView.<anonymous> (LoveWallTreeUpgradeCardPageView.kt:51)");
                    }
                    i elementVR = ModifierExtKt.elementVR(ViewEventPropUpdaterKt.d(ModifiersKt.d(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), h.INSTANCE.a(0.7f)), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallTreeUpgradeCardPageViewKt$LoveWallTreeUpgradeCardPageView$1.1
                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                            return Unit.INSTANCE;
                        }
                    }, 3, null), "em_qz_plant_upgrade_pop", IntimateSpaceReportUtilKt.getIntimateDTReportBaseParams());
                    final TreeUpgradeCardViewModel treeUpgradeCardViewModel2 = TreeUpgradeCardViewModel.this;
                    final Function0<Unit> function03 = function02;
                    final int i16 = i3;
                    final Function0<Unit> function04 = function0;
                    final LoveWallHomepageViewModel loveWallHomepageViewModel2 = loveWallHomepageViewModel;
                    BoxKt.a(elementVR, null, null, ComposableLambdaKt.composableLambda(composer3, 1709199583, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallTreeUpgradeCardPageViewKt$LoveWallTreeUpgradeCardPageView$1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(b bVar, Composer composer4, Integer num2) {
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1709199583, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallTreeUpgradeCardPageView.<anonymous>.<anonymous> (LoveWallTreeUpgradeCardPageView.kt:57)");
                                }
                                i.Companion companion = i.INSTANCE;
                                BoxKt.a(ComposeLayoutPropUpdaterKt.h(companion, 0.0f, 1, null), null, null, ComposableSingletons$LoveWallTreeUpgradeCardPageViewKt.f96lambda1, composer5, 3080, 6);
                                ColumnKt.a(ComposeLayoutPropUpdaterKt.h(companion, 0.0f, 1, null), a.f339245a.b(), Alignment.INSTANCE.b(), null, ComposableLambdaKt.composableLambda(composer5, 2061673736, true, new Function3<d, Composer, Integer, Unit>(function03, i16, function04, loveWallHomepageViewModel2) { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallTreeUpgradeCardPageViewKt.LoveWallTreeUpgradeCardPageView.1.2.1
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
                                                ComposerKt.traceEventStart(2061673736, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallTreeUpgradeCardPageView.<anonymous>.<anonymous>.<anonymous> (LoveWallTreeUpgradeCardPageView.kt:72)");
                                            }
                                            i.Companion companion2 = i.INSTANCE;
                                            i v3 = ComposeLayoutPropUpdaterKt.v(companion2, 292, 427);
                                            TreeUpgradeCardViewModel treeUpgradeCardViewModel3 = TreeUpgradeCardViewModel.this;
                                            final Function0<Unit> function05 = this.$onShareBtnClick;
                                            final LoveWallHomepageViewModel loveWallHomepageViewModel3 = this.$homepageViewModel;
                                            LoveWallTreeUpgradeCardPageViewKt.LoveWallTreeUpgradeCardView(v3, treeUpgradeCardViewModel3, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallTreeUpgradeCardPageViewKt.LoveWallTreeUpgradeCardPageView.1.2.1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(0);
                                                }

                                                @Override // kotlin.jvm.functions.Function0
                                                public final Unit invoke() {
                                                    function05.invoke();
                                                    DTReportKt.reportElementClickEvent(loveWallHomepageViewModel3.getPageReportParams(), "em_qz_plant_upgrade_pop", IntimateSpaceReportUtilKt.getIntimateDTReportBaseParams());
                                                    return Unit.INSTANCE;
                                                }
                                            }, composer7, 72);
                                            i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(companion2, 32.0f), 0.0f, 32, 0.0f, 0.0f, 13, null);
                                            final Function0<Unit> function06 = this.$onCloseBtnClick;
                                            composer7.startReplaceableGroup(1157296644);
                                            boolean changed = composer7.changed(function06);
                                            Object rememberedValue = composer7.rememberedValue();
                                            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                                rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallTreeUpgradeCardPageViewKt$LoveWallTreeUpgradeCardPageView$1$2$1$2$1
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallTreeUpgradeCardPageViewKt$LoveWallTreeUpgradeCardPageView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                LoveWallTreeUpgradeCardPageViewKt.LoveWallTreeUpgradeCardPageView(TreeUpgradeCardViewModel.this, loveWallHomepageViewModel, function0, function02, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void LoveWallTreeUpgradeCardView(final i iVar, final TreeUpgradeCardViewModel treeUpgradeCardViewModel, final Function0<Unit> function0, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(1980830491);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1980830491, i3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallTreeUpgradeCardView (LoveWallTreeUpgradeCardPageView.kt:99)");
        }
        LoveWallFlowerGeneralCardKt.LoveWallFlowerGeneralCard(ComposeLayoutPropUpdaterKt.p(iVar, 10, 0.0f, 2, null), new LoveWallFlowerGeneralCardConfig("\u85e4\u8513\u6210\u957f\u5566", 28.0f, 4), ComposableLambdaKt.composableLambda(startRestartGroup, -545636537, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallTreeUpgradeCardPageViewKt$LoveWallTreeUpgradeCardView$1
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
                        ComposerKt.traceEventStart(-545636537, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallTreeUpgradeCardView.<anonymous> (LoveWallTreeUpgradeCardPageView.kt:110)");
                    }
                    ColumnKt.a(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), null, Alignment.INSTANCE.b(), null, ComposableLambdaKt.composableLambda(composer3, -2076519682, true, new Function3<d, Composer, Integer, Unit>(function0, i3) { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallTreeUpgradeCardPageViewKt$LoveWallTreeUpgradeCardView$1.1
                        public final /* synthetic */ Function0<Unit> $onShareBtnClick;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(d dVar, Composer composer4, Integer num2) {
                            String replace$default;
                            String replace$default2;
                            String replace$default3;
                            List listOf;
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-2076519682, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallTreeUpgradeCardView.<anonymous>.<anonymous> (LoveWallTreeUpgradeCardPageView.kt:113)");
                                }
                                i.Companion companion = i.INSTANCE;
                                i n3 = ComposeLayoutPropUpdaterKt.n(companion, 0.0f, 20, 0.0f, 0.0f, 13, null);
                                TreeUpgradeCardViewModel treeUpgradeCardViewModel2 = TreeUpgradeCardViewModel.this;
                                replace$default = StringsKt__StringsJVMKt.replace$default("\u4f60\u4eec\u7684\u7231\u60c5\u518d\u6b21\u751f\u957f\n\u7231\u60c5\u9ad8\u5ea6\u4ece{start_height}m\u957f\u5230\u4e86{to_height}m\n\u690d\u9f84{achieve_days}\u5929", "{start_height}", String.valueOf(treeUpgradeCardViewModel2.formatedStartHeight), false, 4, (Object) null);
                                replace$default2 = StringsKt__StringsJVMKt.replace$default(replace$default, "{to_height}", String.valueOf(treeUpgradeCardViewModel2.formatedToHeight), false, 4, (Object) null);
                                replace$default3 = StringsKt__StringsJVMKt.replace$default(replace$default2, "{achieve_days}", String.valueOf(treeUpgradeCardViewModel2.achieveDays), false, 4, (Object) null);
                                h.Companion companion2 = h.INSTANCE;
                                j jVar = new j(companion2.b(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32766, null);
                                TreeUpgradeCardViewModel treeUpgradeCardViewModel3 = TreeUpgradeCardViewModel.this;
                                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{String.valueOf(treeUpgradeCardViewModel3.formatedStartHeight), String.valueOf(treeUpgradeCardViewModel3.formatedToHeight), String.valueOf(treeUpgradeCardViewModel3.achieveDays)});
                                RichTextKt.b(LoveSproutCardViewKt.highlightedText(replace$default3, jVar, listOf, new j(new h(255, 128, 0, 1.0f), null, null, null, new n("DIN-NextLT-Pro-QQ"), null, null, null, null, null, null, null, null, null, null, 32750, null)), n3, null, companion2.b(), Float.valueOf(14.0f), null, null, null, null, null, ai.f(ai.INSTANCE.a()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, composer5, 28736, 0, 0, 268434404);
                                i n16 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.v(companion, 168, 134), 0.0f, 14, 0.0f, 0.0f, 13, null);
                                final TreeUpgradeCardViewModel treeUpgradeCardViewModel4 = TreeUpgradeCardViewModel.this;
                                BoxKt.a(n16, null, null, ComposableLambdaKt.composableLambda(composer5, 1701734148, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallTreeUpgradeCardPageViewKt.LoveWallTreeUpgradeCardView.1.1.1
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(b bVar, Composer composer6, Integer num3) {
                                        int i16;
                                        b bVar2 = bVar;
                                        Composer composer7 = composer6;
                                        int intValue3 = num3.intValue();
                                        if ((intValue3 & 14) == 0) {
                                            i16 = (composer7.changed(bVar2) ? 4 : 2) | intValue3;
                                        } else {
                                            i16 = intValue3;
                                        }
                                        if ((i16 & 91) == 18 && composer7.getSkipping()) {
                                            composer7.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1701734148, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallTreeUpgradeCardView.<anonymous>.<anonymous>.<anonymous> (LoveWallTreeUpgradeCardPageView.kt:130)");
                                            }
                                            ImageKt.a(null, null, null, null, null, bVar2.a(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), Alignment.Center), null, 0, null, null, TreeUpgradeCardViewModel.this.treeImage, null, null, null, null, null, null, null, null, null, null, composer7, 262144, 0, 0, 2096095);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer5, 3080, 6);
                                i n17 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.v(companion, 166.0f, 45.0f), 0.0f, 24, 0.0f, 0.0f, 13, null);
                                LoveWallButtonConfig loveWallButtonConfig = new LoveWallButtonConfig("\u4e00\u952e\u5206\u4eab", 17.0f, LoveWallButtonTextColor.YELLOW_BUTTON_COLORS, "https://image.superqqshow.qq.com/wuji/qq_zplan_config_test/couple_space_pic_resouce/4221bcd7_TnkBjfRXl8n.png");
                                final Function0<Unit> function02 = this.$onShareBtnClick;
                                composer5.startReplaceableGroup(1157296644);
                                boolean changed = composer5.changed(function02);
                                Object rememberedValue = composer5.rememberedValue();
                                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallTreeUpgradeCardPageViewKt$LoveWallTreeUpgradeCardView$1$1$2$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ClickParams clickParams) {
                                            function02.invoke();
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    composer5.updateRememberedValue(rememberedValue);
                                }
                                composer5.endReplaceableGroup();
                                LoveWallButtonKt.LoveWallButton(n17, loveWallButtonConfig, (Function1) rememberedValue, composer5, 8);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 24584, 10);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, QFSBottomDynamicGuideEvent.DYNAMIC_GUIDE_BUTTON_TYPE, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallTreeUpgradeCardPageViewKt$LoveWallTreeUpgradeCardView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                LoveWallTreeUpgradeCardPageViewKt.LoveWallTreeUpgradeCardView(i.this, treeUpgradeCardViewModel, function0, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
