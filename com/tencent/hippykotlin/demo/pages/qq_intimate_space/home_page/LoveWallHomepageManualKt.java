package com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.modifer_ext.ModifierExtKt;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.LoveWallGrowthManualRuleKt;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.LoveWallGrowthManualViewKt;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.LoveWallHomepageViewModel;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.ManualState;
import com.tencent.ntcompose.core.i;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class LoveWallHomepageManualKt {
    public static final void LoveWallHomepageManual(final LoveWallHomepageViewModel loveWallHomepageViewModel, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-691092202);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-691092202, i3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallHomepageManual (LoveWallHomepageManual.kt:11)");
        }
        int ordinal = loveWallHomepageViewModel.manualState.getValue().ordinal();
        if (ordinal == 0) {
            startRestartGroup.startReplaceableGroup(391879865);
            startRestartGroup.endReplaceableGroup();
        } else if (ordinal == 1) {
            startRestartGroup.startReplaceableGroup(391879935);
            LoveWallGrowthManualViewKt.LoveWallGrowthManual(ModifierExtKt.pageVR(i.INSTANCE, "pg_qz_love_tree_home", loveWallHomepageViewModel.getPageReportParams()), loveWallHomepageViewModel.pageData, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallHomepageManualKt$LoveWallHomepageManual$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    LoveWallHomepageViewModel.this.manualState.setValue(ManualState.NONE);
                    return Unit.INSTANCE;
                }
            }, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallHomepageManualKt$LoveWallHomepageManual$2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    LoveWallHomepageViewModel.this.manualState.setValue(ManualState.RULE_MANUAL);
                    return Unit.INSTANCE;
                }
            }, startRestartGroup, 8);
            startRestartGroup.endReplaceableGroup();
        } else if (ordinal != 2) {
            startRestartGroup.startReplaceableGroup(391880606);
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.startReplaceableGroup(391880441);
            LoveWallGrowthManualRuleKt.LoveWallGrowthManualRule(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallHomepageManualKt$LoveWallHomepageManual$3
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    LoveWallHomepageViewModel.this.manualState.setValue(ManualState.NONE);
                    return Unit.INSTANCE;
                }
            }, startRestartGroup, 0);
            startRestartGroup.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallHomepageManualKt$LoveWallHomepageManual$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                LoveWallHomepageManualKt.LoveWallHomepageManual(LoveWallHomepageViewModel.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
