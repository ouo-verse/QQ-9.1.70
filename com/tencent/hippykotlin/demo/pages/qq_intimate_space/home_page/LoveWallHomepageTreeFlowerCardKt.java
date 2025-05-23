package com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.Mqq;
import com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.MqqUi;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallContributionCardPageViewKt;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallFlowerCardListViewKt;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallFlowerTaskCardPageViewKt;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.CardShowState;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.LoveWallHomepageViewModel;
import com.tencent.kuikly.core.log.KLog;
import e25.ad;
import e25.ae;
import e25.b;
import e25.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class LoveWallHomepageTreeFlowerCardKt {
    public static final void LoveWallHomepageTreeFlowerCard(final LoveWallHomepageViewModel loveWallHomepageViewModel, Composer composer, final int i3) {
        List<ae> list;
        Composer startRestartGroup = composer.startRestartGroup(381504400);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(381504400, i3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallHomepageTreeFlowerCard (LoveWallHomepageTreeFlowerCard.kt:14)");
        }
        int ordinal = loveWallHomepageViewModel.cardShowState.getValue().ordinal();
        if (ordinal == 0) {
            startRestartGroup.startReplaceableGroup(275303300);
            startRestartGroup.endReplaceableGroup();
        } else if (ordinal == 1) {
            startRestartGroup.startReplaceableGroup(275303377);
            LoveWallFlowerTaskCardPageViewKt.LoveWallFlowerTaskCardPageView(loveWallHomepageViewModel.clickedFlower.getValue(), new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallHomepageTreeFlowerCardKt$LoveWallHomepageTreeFlowerCard$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    String str;
                    b bVar = LoveWallHomepageViewModel.this.clickedFlower.getValue().F;
                    if (bVar != null && (str = bVar.f395470f) != null) {
                        LoveWallHomepageViewModel loveWallHomepageViewModel2 = LoveWallHomepageViewModel.this;
                        KLog.INSTANCE.i("LoveWallHomepage", "click flower task, jumpUrl: " + str);
                        if (!(str.length() == 0)) {
                            MqqUi.openUrl$default(Mqq.INSTANCE.getUi(), str);
                            loveWallHomepageViewModel2.cardShowState.setValue(CardShowState.NONE);
                        }
                    }
                    return Unit.INSTANCE;
                }
            }, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallHomepageTreeFlowerCardKt$LoveWallHomepageTreeFlowerCard$2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    LoveWallHomepageViewModel.this.cardShowState.setValue(CardShowState.NONE);
                    return Unit.INSTANCE;
                }
            }, startRestartGroup, 8);
            startRestartGroup.endReplaceableGroup();
        } else if (ordinal == 2) {
            startRestartGroup.startReplaceableGroup(275304173);
            ArrayList arrayList = new ArrayList();
            ad value = loveWallHomepageViewModel.tree.getValue();
            if (value != null && (list = value.f395435h) != null) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    for (i iVar : ((ae) it.next()).f395442i) {
                        if (iVar.G == 1) {
                            arrayList.add(iVar);
                        }
                    }
                }
            }
            LoveWallFlowerCardListViewKt.LoveWallFlowerCardListView(loveWallHomepageViewModel, arrayList, loveWallHomepageViewModel.clickedFlower.getValue().f395478d, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallHomepageTreeFlowerCardKt$LoveWallHomepageTreeFlowerCard$4
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    LoveWallHomepageViewModel.this.cardShowState.setValue(CardShowState.NONE);
                    return Unit.INSTANCE;
                }
            }, startRestartGroup, 72);
            startRestartGroup.endReplaceableGroup();
        } else if (ordinal != 3) {
            startRestartGroup.startReplaceableGroup(275305084);
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.startReplaceableGroup(275304939);
            LoveWallContributionCardPageViewKt.LoveWallContributionCardPageView(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallHomepageTreeFlowerCardKt$LoveWallHomepageTreeFlowerCard$5
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    LoveWallHomepageViewModel.this.cardShowState.setValue(CardShowState.NONE);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallHomepageTreeFlowerCardKt$LoveWallHomepageTreeFlowerCard$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                LoveWallHomepageTreeFlowerCardKt.LoveWallHomepageTreeFlowerCard(LoveWallHomepageViewModel.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
