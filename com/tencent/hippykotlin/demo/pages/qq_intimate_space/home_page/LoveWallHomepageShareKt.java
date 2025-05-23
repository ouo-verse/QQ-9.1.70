package com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.LoveWallHomepageViewModel;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.SharePanelState;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.LoveWallFlowerCardSharePageViewKt;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.LoveWallFlowerCardShareViewModel;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.LoveWallTreeCardSharePageViewKt;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.LoveWallTreeCardShareViewModel;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.TreeCardShareConfig;
import e25.ae;
import e25.i;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class LoveWallHomepageShareKt {
    public static final void LoveWallHomepageShare(final LoveWallHomepageViewModel loveWallHomepageViewModel, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-157416612);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-157416612, i3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallHomepageShare (LoveWallHomepageShare.kt:14)");
        }
        int ordinal = loveWallHomepageViewModel.sharePanelState.getValue().ordinal();
        if (ordinal == 0) {
            startRestartGroup.startReplaceableGroup(1991607029);
            startRestartGroup.endReplaceableGroup();
        } else if (ordinal == 1) {
            startRestartGroup.startReplaceableGroup(1991607102);
            ae firstLevelTreeBody = loveWallHomepageViewModel.getFirstLevelTreeBody();
            TreeCardShareConfig treeCardShareConfig = new TreeCardShareConfig("\u7231\u60c5\u85e4\u8513", firstLevelTreeBody != null ? Long.valueOf(firstLevelTreeBody.f395443m) : null, loveWallHomepageViewModel.getFlowersCount(), loveWallHomepageViewModel.progressViewModel.getValue().treeProgress.getValue().f395444d);
            startRestartGroup.startReplaceableGroup(-492369756);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new LoveWallTreeCardShareViewModel(treeCardShareConfig, loveWallHomepageViewModel.pageData, loveWallHomepageViewModel.hasTreeRendered()), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            LoveWallTreeCardSharePageViewKt.LoveWallTreeCardSharePageView((LoveWallTreeCardShareViewModel) ((MutableState) rememberedValue).getValue(), loveWallHomepageViewModel, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallHomepageShareKt$LoveWallHomepageShare$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    LoveWallHomepageViewModel.this.sharePanelState.setValue(SharePanelState.NONE);
                    return Unit.INSTANCE;
                }
            }, startRestartGroup, 72, 0);
            startRestartGroup.endReplaceableGroup();
        } else if (ordinal == 2) {
            startRestartGroup.startReplaceableGroup(1991608036);
            ae firstLevelTreeBody2 = loveWallHomepageViewModel.getFirstLevelTreeBody();
            TreeCardShareConfig treeCardShareConfig2 = new TreeCardShareConfig("\u85e4\u8513\u6210\u957f\u5566", firstLevelTreeBody2 != null ? Long.valueOf(firstLevelTreeBody2.f395443m) : null, loveWallHomepageViewModel.getFlowersCount(), loveWallHomepageViewModel.progressViewModel.getValue().treeProgress.getValue().f395444d);
            startRestartGroup.startReplaceableGroup(-492369756);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new LoveWallTreeCardShareViewModel(treeCardShareConfig2, loveWallHomepageViewModel.pageData, loveWallHomepageViewModel.hasTreeRendered()), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceableGroup();
            LoveWallTreeCardSharePageViewKt.LoveWallTreeCardSharePageView((LoveWallTreeCardShareViewModel) ((MutableState) rememberedValue2).getValue(), loveWallHomepageViewModel, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallHomepageShareKt$LoveWallHomepageShare$2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    LoveWallHomepageViewModel.this.sharePanelState.setValue(SharePanelState.NONE);
                    return Unit.INSTANCE;
                }
            }, startRestartGroup, 72, 0);
            startRestartGroup.endReplaceableGroup();
        } else if (ordinal != 3) {
            startRestartGroup.startReplaceableGroup(1991609515);
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.startReplaceableGroup(1991608965);
            i value = loveWallHomepageViewModel.shareFlower.getValue();
            if (value != null) {
                startRestartGroup.startReplaceableGroup(-492369756);
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new LoveWallFlowerCardShareViewModel(value, loveWallHomepageViewModel.pageData), null, 2, null);
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                startRestartGroup.endReplaceableGroup();
                LoveWallFlowerCardSharePageViewKt.LoveWallFlowerCardSharePageView((LoveWallFlowerCardShareViewModel) ((MutableState) rememberedValue3).getValue(), new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallHomepageShareKt$LoveWallHomepageShare$3$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        LoveWallHomepageViewModel.this.sharePanelState.setValue(SharePanelState.NONE);
                        return Unit.INSTANCE;
                    }
                }, startRestartGroup, 8, 0);
            }
            startRestartGroup.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallHomepageShareKt$LoveWallHomepageShare$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                LoveWallHomepageShareKt.LoveWallHomepageShare(LoveWallHomepageViewModel.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
