package com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.detail.model.BoxType$EnumUnboxingSharedUtility;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallFlowerCardPageViewKt;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallTreeUpgradeCardPageViewKt;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.TreeUpgradeCardViewModel;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.LoveWallHomepageViewModel;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.SharePanelState;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.UpgradeCard;
import e25.i;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class LoveWallHomepageUpgradeCardKt {
    public static final void LoveWallHomepageUpgradeCard(final LoveWallHomepageViewModel loveWallHomepageViewModel, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(2095329660);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2095329660, i3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallHomepageUpgradeCard (LoveWallHomepageUpgradeCard.kt:14)");
        }
        if (loveWallHomepageViewModel.currentUpgradeCard.getValue() != null) {
            UpgradeCard value = loveWallHomepageViewModel.currentUpgradeCard.getValue();
            Intrinsics.checkNotNull(value);
            int ordinal = BoxType$EnumUnboxingSharedUtility.ordinal(value.type);
            if (ordinal == 0) {
                startRestartGroup.startReplaceableGroup(29593683);
                startRestartGroup.endReplaceableGroup();
            } else if (ordinal == 1) {
                startRestartGroup.startReplaceableGroup(29593771);
                UpgradeCard value2 = loveWallHomepageViewModel.currentUpgradeCard.getValue();
                Intrinsics.checkNotNull(value2);
                Object obj = value2.config;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.TreeUpgradeCardViewModel");
                TreeUpgradeCardViewModel treeUpgradeCardViewModel = (TreeUpgradeCardViewModel) obj;
                startRestartGroup.startReplaceableGroup(-492369756);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(treeUpgradeCardViewModel, null, 2, null);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceableGroup();
                LoveWallTreeUpgradeCardPageViewKt.LoveWallTreeUpgradeCardPageView((TreeUpgradeCardViewModel) ((MutableState) rememberedValue).getValue(), loveWallHomepageViewModel, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallHomepageUpgradeCardKt$LoveWallHomepageUpgradeCard$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        LoveWallHomepageViewModel.this.sharePanelState.setValue(SharePanelState.SHARE_TREE_UPGRADE);
                        LoveWallHomepageViewModel.this.showNextUpgradeCard();
                        return Unit.INSTANCE;
                    }
                }, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallHomepageUpgradeCardKt$LoveWallHomepageUpgradeCard$2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        LoveWallHomepageViewModel.this.showNextUpgradeCard();
                        return Unit.INSTANCE;
                    }
                }, startRestartGroup, 72);
                startRestartGroup.endReplaceableGroup();
            } else if (ordinal != 2) {
                startRestartGroup.startReplaceableGroup(29595269);
                startRestartGroup.endReplaceableGroup();
            } else {
                startRestartGroup.startReplaceableGroup(29594592);
                UpgradeCard value3 = loveWallHomepageViewModel.currentUpgradeCard.getValue();
                Intrinsics.checkNotNull(value3);
                Object obj2 = value3.config;
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kuikly.com.tencent.intimate_space.social_tree.FlowerState");
                final i iVar = (i) obj2;
                LoveWallFlowerCardPageViewKt.LoveWallFlowerCardPageView(iVar, loveWallHomepageViewModel, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallHomepageUpgradeCardKt$LoveWallHomepageUpgradeCard$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        LoveWallHomepageViewModel.this.shareFlower.setValue(iVar);
                        LoveWallHomepageViewModel.this.sharePanelState.setValue(SharePanelState.SHARE_FLOWER);
                        LoveWallHomepageViewModel.this.showNextUpgradeCard();
                        return Unit.INSTANCE;
                    }
                }, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallHomepageUpgradeCardKt$LoveWallHomepageUpgradeCard$4
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        LoveWallHomepageViewModel.this.showNextUpgradeCard();
                        return Unit.INSTANCE;
                    }
                }, startRestartGroup, 72);
                startRestartGroup.endReplaceableGroup();
            }
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallHomepageUpgradeCardKt$LoveWallHomepageUpgradeCard$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                LoveWallHomepageUpgradeCardKt.LoveWallHomepageUpgradeCard(LoveWallHomepageViewModel.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
