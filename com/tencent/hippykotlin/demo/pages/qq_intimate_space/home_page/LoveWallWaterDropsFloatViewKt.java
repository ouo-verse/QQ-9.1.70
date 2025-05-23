package com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.modifer_ext.ModifierExtKt;
import com.tencent.hippykotlin.demo.pages.foundation.extension.PageDataExtKt;
import com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.Mqq;
import com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.MqqUi;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.BubbleConfig;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.BubbleStatus;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.BubbleTriangleDirection;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.BubbleViewModel;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.FoldAnimation;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallBizJumpBubbleViewKt;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallWaterDropKt;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.Point;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.GuildState;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.LoveWallHomepageViewModel;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.ToastInfo;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.utils.DTReportKt;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.utils.IntimateSpaceReportUtilKt;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.luggage.wxa.xd.d1;
import com.tencent.ntcompose.animation.Animatable;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ActivityEventHandlerKt;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.material.APNGKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import e25.a;
import e25.aj;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class LoveWallWaterDropsFloatViewKt {
    public static final void LoveWallWaterDropsFloatView(final i iVar, final LoveWallHomepageViewModel loveWallHomepageViewModel, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(2095472259);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2095472259, i3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallWaterDropsFloatView (LoveWallWaterDropsFloatView.kt:58)");
        }
        BoxKt.a(iVar, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1063808707, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallWaterDropsFloatViewKt$LoveWallWaterDropsFloatView$1
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(b bVar, Composer composer2, Integer num) {
                aj ajVar;
                int i16;
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1063808707, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallWaterDropsFloatView.<anonymous> (LoveWallWaterDropsFloatView.kt:62)");
                    }
                    LoveWallHomepageViewModel loveWallHomepageViewModel2 = LoveWallHomepageViewModel.this;
                    int i17 = -492369756;
                    composer3.startReplaceableGroup(-492369756);
                    Object rememberedValue = composer3.rememberedValue();
                    int i18 = 2;
                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new WaterDropFloatViewModel(loveWallHomepageViewModel2), null, 2, null);
                        composer3.updateRememberedValue(rememberedValue);
                    }
                    composer3.endReplaceableGroup();
                    final MutableState mutableState = (MutableState) rememberedValue;
                    LoveWallWaterDropsFloatViewKt.CollectWaterAnimationView((WaterDropFloatViewModel) mutableState.getValue(), composer3, 8);
                    Iterator<aj> it = LoveWallHomepageViewModel.this.waterTaskList.iterator();
                    int i19 = 0;
                    int i26 = 0;
                    while (it.hasNext()) {
                        composer3.startReplaceableGroup(222698150);
                        int i27 = i26 + 1;
                        aj next = it.next();
                        int i28 = (next.C && next.f395463i == 0 && next.f395460e == i18) ? 1 : i19;
                        composer3.startReplaceableGroup(i17);
                        Object rememberedValue2 = composer3.rememberedValue();
                        Composer.Companion companion = Composer.INSTANCE;
                        if (rememberedValue2 == companion.getEmpty()) {
                            rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new WaterDropViewModel((WaterDropFloatViewModel) mutableState.getValue()), null, i18, null);
                            composer3.updateRememberedValue(rememberedValue2);
                        }
                        composer3.endReplaceableGroup();
                        final MutableState mutableState2 = (MutableState) rememberedValue2;
                        ((WaterDropFloatViewModel) mutableState.getValue()).waterDropViewModels.put(Integer.valueOf(next.f395459d), mutableState2.getValue());
                        if (i28 == 0) {
                            int i29 = i26 % 2;
                            float f16 = i29 == 0 ? -10.0f : 10.0f;
                            int i36 = i29 == 0 ? 800 : i19;
                            aj value = ((WaterDropViewModel) mutableState2.getValue()).waterTask.getValue();
                            composer3.startReplaceableGroup(1157296644);
                            boolean changed = composer3.changed(mutableState2);
                            Object rememberedValue3 = composer3.rememberedValue();
                            if (changed || rememberedValue3 == companion.getEmpty()) {
                                rememberedValue3 = new LoveWallWaterDropsFloatViewKt$LoveWallWaterDropsFloatView$1$1$1(mutableState2, null);
                                composer3.updateRememberedValue(rememberedValue3);
                            }
                            composer3.endReplaceableGroup();
                            EffectsKt.LaunchedEffect(value, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue3, composer3, 72);
                            composer3.startReplaceableGroup(1157296644);
                            boolean changed2 = composer3.changed(mutableState2);
                            Object rememberedValue4 = composer3.rememberedValue();
                            if (changed2 || rememberedValue4 == companion.getEmpty()) {
                                rememberedValue4 = new Function2<Double, Double, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallWaterDropsFloatViewKt$LoveWallWaterDropsFloatView$1$2$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Unit invoke(Double d16, Double d17) {
                                        d16.doubleValue();
                                        d17.doubleValue();
                                        mutableState2.getValue().updateWaterDropConfig();
                                        return Unit.INSTANCE;
                                    }
                                };
                                composer3.updateRememberedValue(rememberedValue4);
                            }
                            composer3.endReplaceableGroup();
                            ActivityEventHandlerKt.a((Function2) rememberedValue4, composer3, i19);
                            ((WaterDropViewModel) mutableState2.getValue()).waterTask.setValue(next);
                            if (LoveWallHomepageViewModel.this.guildState.getValue() == GuildState.COLLECT_WATER_GUILD && next.f395459d == 1) {
                                composer3.endReplaceableGroup();
                                i16 = i19;
                                i19 = i16;
                                i26 = i27;
                                i17 = -492369756;
                                i18 = 2;
                            } else {
                                i16 = i19;
                                LoveWallWaterDropsFloatViewKt.RandomMovingWaterDropWithBubbleView((WaterDropViewModel) mutableState2.getValue(), (WaterDropFloatViewModel) mutableState.getValue(), LoveWallHomepageViewModel.this, next, 0.0f, f16, i36, composer3, 29256);
                            }
                        } else {
                            i16 = i19;
                        }
                        composer3.endReplaceableGroup();
                        i19 = i16;
                        i26 = i27;
                        i17 = -492369756;
                        i18 = 2;
                    }
                    int i37 = i19;
                    if (LoveWallHomepageViewModel.this.guildState.getValue() == GuildState.COLLECT_WATER_GUILD) {
                        Iterator<aj> it5 = LoveWallHomepageViewModel.this.waterTaskList.iterator();
                        while (true) {
                            if (!it5.hasNext()) {
                                ajVar = null;
                                break;
                            }
                            ajVar = it5.next();
                            if ((ajVar.f395459d == 1 ? 1 : i37) != 0) {
                                break;
                            }
                        }
                        final aj ajVar2 = ajVar;
                        if (ajVar2 != null) {
                            final LoveWallHomepageViewModel loveWallHomepageViewModel3 = LoveWallHomepageViewModel.this;
                            WaterDropViewModel waterDropViewModel = ((WaterDropFloatViewModel) mutableState.getValue()).waterDropViewModels.get(Integer.valueOf(ajVar2.f395459d));
                            if (waterDropViewModel != null) {
                                waterDropViewModel.waterTask.setValue(ajVar2);
                                waterDropViewModel.updateWaterDropConfig();
                                composer3.startReplaceableGroup(-492369756);
                                Object rememberedValue5 = composer3.rememberedValue();
                                if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue5 = new Animatable(Float.valueOf(0.0f));
                                    composer3.updateRememberedValue(rememberedValue5);
                                }
                                composer3.endReplaceableGroup();
                                Animatable animatable = (Animatable) rememberedValue5;
                                EffectsKt.LaunchedEffect(animatable, new LoveWallWaterDropsFloatViewKt$LoveWallWaterDropsFloatView$1$3$1$1(animatable, null), composer3, Animatable.f339143c | 64);
                                i.Companion companion2 = i.INSTANCE;
                                BoxKt.a(ModifiersKt.D(ModifiersKt.d(ComposeLayoutPropUpdaterKt.h(companion2, 0.0f, 1, null), h.INSTANCE.a(0.4f)), ((Number) animatable.f()).floatValue()), null, null, null, composer3, 8, 14);
                                LoveWallWaterDropsFloatViewKt.WaterDropWithBubbleView(companion2, waterDropViewModel, loveWallHomepageViewModel3, (WaterDropFloatViewModel) mutableState.getValue(), ajVar2, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallWaterDropsFloatViewKt$LoveWallWaterDropsFloatView$1$3$1$2
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Unit invoke() {
                                        LoveWallHomepageViewModel.this.guildState.setValue(GuildState.WATERING_GUILD);
                                        return Unit.INSTANCE;
                                    }
                                }, composer3, 37448, 0);
                                i v3 = ComposeLayoutPropUpdaterKt.v(companion2, (float) 137.2d, 130);
                                Point value2 = waterDropViewModel.point.getValue();
                                float f17 = (value2 != null ? value2.f114257x : 0.0f) + 30.0f;
                                Point value3 = waterDropViewModel.point.getValue();
                                APNGKt.a(ViewEventPropUpdaterKt.d(ComposeLayoutPropUpdaterKt.n(v3, f17, (value3 != null ? value3.f114258y : 0.0f) + 30.0f, 0.0f, 0.0f, 12, null), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallWaterDropsFloatViewKt$LoveWallWaterDropsFloatView$1$3$1$3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        mutableState.getValue().collectWater(ajVar2);
                                        loveWallHomepageViewModel3.guildState.setValue(GuildState.WATERING_GUILD);
                                        return Unit.INSTANCE;
                                    }
                                }, 3, null), null, "https://image.superqqshow.qq.com/wuji/qq_zplan_config_test/couple_space_pic_resouce/4221bcd7_mSbOXa9EB79.png", Integer.valueOf(i37), null, null, null, null, composer3, 3464, 242);
                            }
                        }
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 3080, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallWaterDropsFloatViewKt$LoveWallWaterDropsFloatView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                LoveWallWaterDropsFloatViewKt.LoveWallWaterDropsFloatView(i.this, loveWallHomepageViewModel, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void RandomMovingWaterDropWithBubbleView(final WaterDropViewModel waterDropViewModel, final WaterDropFloatViewModel waterDropFloatViewModel, final LoveWallHomepageViewModel loveWallHomepageViewModel, final aj ajVar, final float f16, final float f17, final int i3, Composer composer, final int i16) {
        Composer startRestartGroup = composer.startRestartGroup(-43109397);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-43109397, i16, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.RandomMovingWaterDropWithBubbleView (LoveWallWaterDropsFloatView.kt:149)");
        }
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue = startRestartGroup.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        MutableState mutableState = (MutableState) rememberedValue;
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Integer.valueOf(i3), null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue2);
        }
        startRestartGroup.endReplaceableGroup();
        MutableState mutableState2 = (MutableState) rememberedValue2;
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue3 = startRestartGroup.rememberedValue();
        if (rememberedValue3 == companion.getEmpty()) {
            rememberedValue3 = new Animatable(Float.valueOf(f16));
            startRestartGroup.updateRememberedValue(rememberedValue3);
        }
        startRestartGroup.endReplaceableGroup();
        Animatable animatable = (Animatable) rememberedValue3;
        EffectsKt.LaunchedEffect(mutableState.getValue(), mutableState2.getValue(), new LoveWallWaterDropsFloatViewKt$RandomMovingWaterDropWithBubbleView$1(animatable, mutableState, f17, f16, mutableState2, null), startRestartGroup, 512);
        WaterDropWithBubbleView(ComposeLayoutPropUpdaterKt.p(i.INSTANCE, 0.0f, ((Number) animatable.f()).floatValue(), 1, null), waterDropViewModel, loveWallHomepageViewModel, waterDropFloatViewModel, ajVar, null, startRestartGroup, 37448, 32);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallWaterDropsFloatViewKt$RandomMovingWaterDropWithBubbleView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                LoveWallWaterDropsFloatViewKt.RandomMovingWaterDropWithBubbleView(WaterDropViewModel.this, waterDropFloatViewModel, loveWallHomepageViewModel, ajVar, f16, f17, i3, composer2, i16 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void CollectWaterAnimationView(final WaterDropFloatViewModel waterDropFloatViewModel, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-577425676);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-577425676, i3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.CollectWaterAnimationView (LoveWallWaterDropsFloatView.kt:329)");
        }
        EffectsKt.LaunchedEffect(waterDropFloatViewModel.collectAnimationCount.getValue(), new LoveWallWaterDropsFloatViewKt$CollectWaterAnimationView$1(waterDropFloatViewModel, null), startRestartGroup, 64);
        Iterator<CollectAnimation> it = waterDropFloatViewModel.collectAnimations.iterator();
        while (it.hasNext()) {
            final CollectAnimation next = it.next();
            if (!next.isPlaying) {
                MutableState<Integer> mutableState = waterDropFloatViewModel.collectAnimationCount;
                mutableState.setValue(Integer.valueOf(mutableState.getValue().intValue() + 1));
                next.isPlaying = true;
            }
            if (next.fromLeft) {
                startRestartGroup.startReplaceableGroup(-1448707917);
                BoxKt.a(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), 0.0f, 0.0f, 0.0f, 160, 7, null), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1339683374, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallWaterDropsFloatViewKt$CollectWaterAnimationView$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public final Unit invoke(b bVar, Composer composer2, Integer num) {
                        int i16;
                        Alignment alignment;
                        b bVar2 = bVar;
                        Composer composer3 = composer2;
                        int intValue = num.intValue();
                        if ((intValue & 14) == 0) {
                            i16 = (composer3.changed(bVar2) ? 4 : 2) | intValue;
                        } else {
                            i16 = intValue;
                        }
                        if ((i16 & 91) == 18 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                        } else {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1339683374, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.CollectWaterAnimationView.<anonymous> (LoveWallWaterDropsFloatView.kt:347)");
                            }
                            i k3 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 325.0f), d1.CTRL_INDEX);
                            if (PageDataExtKt.isTabletDevice(com.tencent.ntcompose.activity.b.a().getPageData())) {
                                alignment = Alignment.BottomCenter;
                            } else {
                                alignment = Alignment.BottomStart;
                            }
                            i a16 = bVar2.a(k3, alignment);
                            final CollectAnimation collectAnimation = CollectAnimation.this;
                            final WaterDropFloatViewModel waterDropFloatViewModel2 = waterDropFloatViewModel;
                            APNGKt.a(a16, null, "https://image.superqqshow.qq.com/wuji/qq_zplan_config_test/couple_space_pic_resouce/4221bcd7_S9N-zvJZRKr.png", 1, null, null, null, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallWaterDropsFloatViewKt$CollectWaterAnimationView$2.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(Object obj) {
                                    CollectAnimation.this.waitFroRemove = true;
                                    MutableState<Integer> mutableState2 = waterDropFloatViewModel2.collectAnimationCount;
                                    mutableState2.setValue(Integer.valueOf(mutableState2.getValue().intValue() - 1));
                                    CollectAnimation.this.onFinish.invoke();
                                    return Unit.INSTANCE;
                                }
                            }, composer3, 3464, 114);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }), startRestartGroup, 3080, 6);
                startRestartGroup.endReplaceableGroup();
            } else {
                startRestartGroup.startReplaceableGroup(-1448707103);
                BoxKt.a(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), 0.0f, 0.0f, 0.0f, 160, 7, null), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1911701257, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallWaterDropsFloatViewKt$CollectWaterAnimationView$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public final Unit invoke(b bVar, Composer composer2, Integer num) {
                        int i16;
                        Alignment alignment;
                        b bVar2 = bVar;
                        Composer composer3 = composer2;
                        int intValue = num.intValue();
                        if ((intValue & 14) == 0) {
                            i16 = (composer3.changed(bVar2) ? 4 : 2) | intValue;
                        } else {
                            i16 = intValue;
                        }
                        if ((i16 & 91) == 18 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                        } else {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1911701257, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.CollectWaterAnimationView.<anonymous> (LoveWallWaterDropsFloatView.kt:364)");
                            }
                            i k3 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 325.0f), d1.CTRL_INDEX);
                            if (PageDataExtKt.isTabletDevice(com.tencent.ntcompose.activity.b.a().getPageData())) {
                                alignment = Alignment.Center;
                            } else {
                                alignment = Alignment.BottomEnd;
                            }
                            i a16 = bVar2.a(k3, alignment);
                            final CollectAnimation collectAnimation = CollectAnimation.this;
                            final WaterDropFloatViewModel waterDropFloatViewModel2 = waterDropFloatViewModel;
                            APNGKt.a(a16, null, "https://image.superqqshow.qq.com/wuji/qq_zplan_config_test/couple_space_pic_resouce/4221bcd7_rV1y03X7oOQ.png", 1, null, null, null, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallWaterDropsFloatViewKt$CollectWaterAnimationView$3.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(Object obj) {
                                    CollectAnimation.this.waitFroRemove = true;
                                    MutableState<Integer> mutableState2 = waterDropFloatViewModel2.collectAnimationCount;
                                    mutableState2.setValue(Integer.valueOf(mutableState2.getValue().intValue() - 1));
                                    CollectAnimation.this.onFinish.invoke();
                                    return Unit.INSTANCE;
                                }
                            }, composer3, 3464, 114);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }), startRestartGroup, 3080, 6);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallWaterDropsFloatViewKt$CollectWaterAnimationView$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                LoveWallWaterDropsFloatViewKt.CollectWaterAnimationView(WaterDropFloatViewModel.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void WaterDropWithBubbleView(final i iVar, final WaterDropViewModel waterDropViewModel, final LoveWallHomepageViewModel loveWallHomepageViewModel, final WaterDropFloatViewModel waterDropFloatViewModel, final aj ajVar, Function0<Unit> function0, Composer composer, final int i3, final int i16) {
        e25.b bVar;
        String str;
        String str2;
        String str3;
        Composer startRestartGroup = composer.startRestartGroup(-2073186458);
        Function0<Unit> function02 = (i16 & 32) != 0 ? null : function0;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2073186458, i3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.WaterDropWithBubbleView (LoveWallWaterDropsFloatView.kt:181)");
        }
        FoldAnimation foldAnimation = new FoldAnimation();
        a aVar = ajVar.E;
        String str4 = (aVar == null || (str3 = aVar.f395423e) == null) ? "" : str3;
        String str5 = (aVar == null || (str2 = aVar.f395424f) == null) ? "" : str2;
        BubbleTriangleDirection value = waterDropViewModel.triangleDirection.getValue();
        BubbleStatus bubbleStatus = BubbleStatus.START_FOLD;
        a aVar2 = ajVar.E;
        BubbleConfig bubbleConfig = new BubbleConfig(0.0f, foldAnimation, str4, str5, value, bubbleStatus, (aVar2 == null || (bVar = aVar2.f395425h) == null || (str = bVar.f395469e) == null) ? "" : str, 57951);
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue = startRestartGroup.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new BubbleViewModel(bubbleConfig), null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState mutableState = (MutableState) rememberedValue;
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue2);
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState mutableState2 = (MutableState) rememberedValue2;
        final Function0<Unit> function03 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallWaterDropsFloatViewKt$WaterDropWithBubbleView$showWaterBubbleFun$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                aj ajVar2 = aj.this;
                if (ajVar2.f395463i <= 0 && !ajVar2.C && ajVar2.E != null && ajVar2.f395460e != 0 && mutableState.getValue().bubbleStatus.getValue() != BubbleStatus.FOLDING && mutableState.getValue().bubbleStatus.getValue() != BubbleStatus.UNFOLDING) {
                    if (!mutableState2.getValue().booleanValue()) {
                        mutableState.getValue().bubbleStatus.setValue(BubbleStatus.START_FOLD);
                        mutableState2.setValue(Boolean.TRUE);
                    } else if (mutableState.getValue().bubbleStatus.getValue() == BubbleStatus.FOLD) {
                        mutableState.getValue().bubbleStatus.setValue(BubbleStatus.START_UNFOLD);
                    }
                }
                return Unit.INSTANCE;
            }
        };
        EffectsKt.LaunchedEffect(loveWallHomepageViewModel.unfoldAllWaterBubbles.getValue(), new LoveWallWaterDropsFloatViewKt$WaterDropWithBubbleView$1(loveWallHomepageViewModel, function03, null), startRestartGroup, 64);
        ((BubbleViewModel) mutableState.getValue()).bubbleTips.setValue(ajVar.E);
        EffectsKt.LaunchedEffect(((BubbleViewModel) mutableState.getValue()).bubbleTips.getValue(), new LoveWallWaterDropsFloatViewKt$WaterDropWithBubbleView$2(mutableState, waterDropViewModel, null), startRestartGroup, 72);
        i v3 = ComposeLayoutPropUpdaterKt.v(iVar, waterDropViewModel.width.getValue().floatValue(), 123.0f);
        Point value2 = waterDropViewModel.point.getValue();
        float f16 = value2 != null ? value2.f114257x : 0.0f;
        Point value3 = waterDropViewModel.point.getValue();
        final Function0<Unit> function04 = function02;
        BoxKt.a(ComposeLayoutPropUpdaterKt.n(v3, f16, value3 != null ? value3.f114258y : 0.0f, 0.0f, 0.0f, 12, null), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 446103660, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallWaterDropsFloatViewKt$WaterDropWithBubbleView$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(b bVar2, Composer composer2, Integer num) {
                int i17;
                b bVar3 = bVar2;
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 14) == 0) {
                    i17 = (composer3.changed(bVar3) ? 4 : 2) | intValue;
                } else {
                    i17 = intValue;
                }
                if ((i17 & 91) == 18 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(446103660, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.WaterDropWithBubbleView.<anonymous> (LoveWallWaterDropsFloatView.kt:244)");
                    }
                    composer3.startReplaceableGroup(364092662);
                    if (mutableState2.getValue().booleanValue()) {
                        i L = ModifiersKt.L(bVar3.a(ComposeLayoutPropUpdaterKt.v(i.INSTANCE, waterDropViewModel.width.getValue().floatValue(), mutableState.getValue().config.triangleSize.getHeight() + mutableState.getValue().config.bubbleContainerHeight), Alignment.TopEnd), 0.0f, 2, 6.0f, h.INSTANCE.a(com.tencent.ntcompose.activity.b.a().getPageData().getIsAndroid() ? 0.0f : 0.1f));
                        e intimateDTReportBaseParams = IntimateSpaceReportUtilKt.getIntimateDTReportBaseParams();
                        intimateDTReportBaseParams.t("task_type", LoveWallWateringFloatViewKt.getReportTaskTypeOfWaterTask(ajVar));
                        Unit unit = Unit.INSTANCE;
                        i elementVR = ModifierExtKt.elementVR(L, "em_qz_drop_task", intimateDTReportBaseParams);
                        BubbleViewModel value4 = mutableState.getValue();
                        final MutableState<Boolean> mutableState3 = mutableState2;
                        final MutableState<BubbleViewModel> mutableState4 = mutableState;
                        composer3.startReplaceableGroup(511388516);
                        boolean changed = composer3.changed(mutableState3) | composer3.changed(mutableState4);
                        Object rememberedValue3 = composer3.rememberedValue();
                        if (changed || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue3 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallWaterDropsFloatViewKt$WaterDropWithBubbleView$3$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final Unit invoke() {
                                    mutableState3.setValue(Boolean.FALSE);
                                    mutableState4.getValue().bubbleStatus.setValue(BubbleStatus.UNFOLD);
                                    return Unit.INSTANCE;
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue3);
                        }
                        composer3.endReplaceableGroup();
                        final LoveWallHomepageViewModel loveWallHomepageViewModel2 = loveWallHomepageViewModel;
                        final MutableState<Boolean> mutableState5 = mutableState2;
                        final MutableState<BubbleViewModel> mutableState6 = mutableState;
                        final aj ajVar2 = ajVar;
                        final WaterDropFloatViewModel waterDropFloatViewModel2 = waterDropFloatViewModel;
                        LoveWallBizJumpBubbleViewKt.LoveWallBizJumpBubbleView(elementVR, value4, (Function0) rememberedValue3, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallWaterDropsFloatViewKt$WaterDropWithBubbleView$3.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                e25.b bVar4;
                                String str6;
                                e pageReportParams = LoveWallHomepageViewModel.this.getPageReportParams();
                                e intimateDTReportBaseParams2 = IntimateSpaceReportUtilKt.getIntimateDTReportBaseParams();
                                intimateDTReportBaseParams2.t("task_type", LoveWallWateringFloatViewKt.getReportTaskTypeOfWaterTask(ajVar2));
                                Unit unit2 = Unit.INSTANCE;
                                DTReportKt.reportElementClickEvent(pageReportParams, "em_qz_drop_task", intimateDTReportBaseParams2);
                                mutableState5.setValue(Boolean.FALSE);
                                mutableState6.getValue().bubbleStatus.setValue(BubbleStatus.UNFOLD);
                                aj ajVar3 = ajVar2;
                                if (ajVar3.f395459d == 4) {
                                    KLog kLog = KLog.INSTANCE;
                                    kLog.i("LoveWallBizJumpBubbleView", "click recycle water bubble");
                                    final WaterDropFloatViewModel waterDropFloatViewModel3 = waterDropFloatViewModel2;
                                    final aj ajVar4 = ajVar2;
                                    waterDropFloatViewModel3.getClass();
                                    kLog.i("LoveWallHomepage", "start recycle water");
                                    LoveWallHomepageViewModel.requestShare$default(waterDropFloatViewModel3.homepageViewModel, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.WaterDropFloatViewModel$recycleWater$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public final Unit invoke() {
                                            KLog.INSTANCE.i("LoveWallHomepage", "start collect water");
                                            WaterDropFloatViewModel.this.collectWater(ajVar4);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                } else {
                                    a aVar3 = ajVar3.E;
                                    if (aVar3 != null && (bVar4 = aVar3.f395425h) != null && (str6 = bVar4.f395470f) != null) {
                                        if (!(str6.length() == 0)) {
                                            DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0.m("jumpUrl: ", str6, KLog.INSTANCE, "LoveWallBizJumpBubbleView");
                                            MqqUi.openUrl$default(Mqq.INSTANCE.getUi(), str6);
                                        }
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }, composer3, 72, 0);
                    }
                    composer3.endReplaceableGroup();
                    i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 74.0f), mutableState.getValue().trianglePointToX.getValue().floatValue() - 37.0f, 48, 0.0f, 0.0f, 12, null);
                    aj ajVar3 = ajVar;
                    i D = ModifiersKt.D(n3, (ajVar3.C && ajVar3.f395463i == 0) ? 0.6f : 1.0f);
                    e intimateDTReportBaseParams2 = IntimateSpaceReportUtilKt.getIntimateDTReportBaseParams();
                    intimateDTReportBaseParams2.t("task_type", LoveWallWateringFloatViewKt.getReportTaskTypeOfWaterTask(ajVar));
                    Unit unit2 = Unit.INSTANCE;
                    i elementVR2 = ModifierExtKt.elementVR(D, "em_qz_drop", intimateDTReportBaseParams2);
                    final aj ajVar4 = ajVar;
                    final WaterDropFloatViewModel waterDropFloatViewModel3 = waterDropFloatViewModel;
                    final LoveWallHomepageViewModel loveWallHomepageViewModel3 = loveWallHomepageViewModel;
                    final Function0<Unit> function05 = function03;
                    final Function0<Unit> function06 = function04;
                    LoveWallWaterDropKt.LoveWallWaterDrop(ViewEventPropUpdaterKt.d(elementVR2, false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallWaterDropsFloatViewKt$WaterDropWithBubbleView$3.5
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        /* JADX WARN: Code restructure failed: missing block: B:20:0x0042, code lost:
                        
                            if (kotlin.jvm.internal.Intrinsics.areEqual(r5 != null ? r5.text : null, "\u6bcf\u65e5\u9886\u6c34\u6ef4\uff0c\u52a9\u7231\u751f\u957f") != false) goto L23;
                         */
                        @Override // kotlin.jvm.functions.Function1
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final Unit invoke(ClickParams clickParams) {
                            aj ajVar5 = aj.this;
                            if (ajVar5.f395463i > 0) {
                                waterDropFloatViewModel3.collectWater(ajVar5);
                            } else if (ajVar5.C && ajVar5.f395459d == 1) {
                                if (loveWallHomepageViewModel3.isShowingToast.getValue().booleanValue()) {
                                    ToastInfo value5 = loveWallHomepageViewModel3.currentToast.getValue();
                                }
                                loveWallHomepageViewModel3.showToast("\u6bcf\u65e5\u9886\u6c34\u6ef4\uff0c\u52a9\u7231\u751f\u957f");
                            } else {
                                function05.invoke();
                            }
                            Function0<Unit> function07 = function06;
                            if (function07 != null) {
                                function07.invoke();
                            }
                            return Unit.INSTANCE;
                        }
                    }, 3, null), ajVar, composer3, 72);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 3080, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Function0<Unit> function05 = function02;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallWaterDropsFloatViewKt$WaterDropWithBubbleView$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                LoveWallWaterDropsFloatViewKt.WaterDropWithBubbleView(i.this, waterDropViewModel, loveWallHomepageViewModel, waterDropFloatViewModel, ajVar, function05, composer2, i3 | 1, i16);
                return Unit.INSTANCE;
            }
        });
    }
}
