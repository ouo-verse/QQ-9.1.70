package com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.GuildState;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.LoveWallHomepageViewModel;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.UserTreeState;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallFloweringGuildViewKt;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallLightingFlowerGuildViewKt;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallPlantingGuildViewKt;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallSproutCardGuildViewKt;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallWateringGuildViewKt;
import e25.i;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class LoveWallHomepageGuildKt {
    public static final void LoveWallHomepageGuild(final LoveWallHomepageViewModel loveWallHomepageViewModel, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-459646244);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-459646244, i3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallHomepageGuild (LoveWallHomepageGuild.kt:14)");
        }
        switch (loveWallHomepageViewModel.guildState.getValue()) {
            case REQUESTING:
            case NONE:
                startRestartGroup.startReplaceableGroup(1660295640);
                startRestartGroup.endReplaceableGroup();
                break;
            case PLANTING_GUILD:
                startRestartGroup.startReplaceableGroup(1660295712);
                LoveWallPlantingGuildViewKt.LoveWallPlantingGuildView(loveWallHomepageViewModel, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallHomepageGuildKt$LoveWallHomepageGuild$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        LoveWallHomepageViewModel.this.userTreeState.setValue(UserTreeState.CREATED_TREE);
                        LoveWallHomepageViewModel.this.guildState.setValue(GuildState.COLLECT_WATER_GUILD);
                        return Unit.INSTANCE;
                    }
                }, startRestartGroup, 8);
                startRestartGroup.endReplaceableGroup();
                break;
            case COLLECT_WATER_GUILD:
                startRestartGroup.startReplaceableGroup(1660296044);
                startRestartGroup.endReplaceableGroup();
                break;
            case WATERING_GUILD:
                startRestartGroup.startReplaceableGroup(1660296146);
                loveWallHomepageViewModel.fetchSproutFlowerPosition();
                LoveWallWateringGuildViewKt.LoveWallWateringGuildView(loveWallHomepageViewModel, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallHomepageGuildKt$LoveWallHomepageGuild$2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        LoveWallHomepageViewModel.this.guildState.setValue(GuildState.CLICK_FLOWER_GUILD);
                        return Unit.INSTANCE;
                    }
                }, startRestartGroup, 8);
                startRestartGroup.endReplaceableGroup();
                break;
            case CLICK_FLOWER_GUILD:
                startRestartGroup.startReplaceableGroup(1660296470);
                loveWallHomepageViewModel.fetchSproutFlowerPosition();
                LoveWallLightingFlowerGuildViewKt.LoveWallLightingFlowerGuildView(loveWallHomepageViewModel, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallHomepageGuildKt$LoveWallHomepageGuild$3
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        LoveWallHomepageViewModel.this.guildState.setValue(GuildState.RECEIVE_SPROUT_FLOWER);
                        return Unit.INSTANCE;
                    }
                }, startRestartGroup, 8);
                startRestartGroup.endReplaceableGroup();
                break;
            case RECEIVE_SPROUT_FLOWER:
                startRestartGroup.startReplaceableGroup(1660296856);
                i firstLevelFlower = loveWallHomepageViewModel.getFirstLevelFlower();
                if (firstLevelFlower != null) {
                    LoveWallSproutCardGuildViewKt.LoveWallSproutCardGuildView(firstLevelFlower, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallHomepageGuildKt$LoveWallHomepageGuild$4
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Unit invoke() {
                            LoveWallHomepageViewModel.this.guildState.setValue(GuildState.FLOWERING_AND_SHOW_BUBBLE);
                            return Unit.INSTANCE;
                        }
                    }, startRestartGroup, 8);
                }
                startRestartGroup.endReplaceableGroup();
                break;
            case FLOWERING_AND_SHOW_BUBBLE:
                startRestartGroup.startReplaceableGroup(1660297324);
                LoveWallFloweringGuildViewKt.LoveWallFloweringGuildView(loveWallHomepageViewModel, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallHomepageGuildKt$LoveWallHomepageGuild$5
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        LoveWallHomepageViewModel.this.guildState.setValue(GuildState.NONE);
                        LoveWallHomepageViewModel.this.notifyTreeFreeState(1);
                        return Unit.INSTANCE;
                    }
                }, startRestartGroup, 8);
                startRestartGroup.endReplaceableGroup();
                break;
            default:
                startRestartGroup.startReplaceableGroup(1660297674);
                startRestartGroup.endReplaceableGroup();
                break;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallHomepageGuildKt$LoveWallHomepageGuild$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                LoveWallHomepageGuildKt.LoveWallHomepageGuild(LoveWallHomepageViewModel.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
