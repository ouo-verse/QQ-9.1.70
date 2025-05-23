package com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.detail.model.BoxType$EnumUnboxingSharedUtility;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.data.ImageConfig;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.result.NBPShootResultViewModel;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.material.APNGKt;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.ntcompose.material.h;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class BackgroundLayerViewKt {
    public static final void BackgroundLayerView(final i iVar, final BackgroundInfo backgroundInfo, final NBPShootResultViewModel nBPShootResultViewModel, final Function0<Unit> function0, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(1232572941);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1232572941, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.BackgroundLayerView (BackgroundLayerView.kt:17)");
        }
        i k3 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(iVar, backgroundInfo.width), backgroundInfo.height);
        startRestartGroup.startReplaceableGroup(1157296644);
        boolean changed = startRestartGroup.changed(function0);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.BackgroundLayerViewKt$BackgroundLayerView$1$1
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
        BoxKt.a(ViewEventPropUpdaterKt.d(k3, false, null, (Function1) rememberedValue, 3, null), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1175708269, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.BackgroundLayerViewKt$BackgroundLayerView$2

            /* compiled from: P */
            /* loaded from: classes31.dex */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[BoxType$EnumUnboxingSharedUtility.values(4).length];
                    try {
                        iArr[1] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(b bVar, Composer composer2, Integer num) {
                int i16;
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
                        ComposerKt.traceEventStart(-1175708269, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.BackgroundLayerView.<anonymous> (BackgroundLayerView.kt:28)");
                    }
                    i.Companion companion = i.INSTANCE;
                    i J = ModifiersKt.J(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(bVar2.a(companion, Alignment.CenterEnd), BackgroundInfo.this.width), BackgroundInfo.this.height), (10.0f / BackgroundInfo.this.height) + 1.0f, null, 2, null);
                    String str = BackgroundInfo.this.imageSrc;
                    h.Companion companion2 = h.INSTANCE;
                    ImageKt.a(str, null, null, null, null, J, null, companion2.b(), null, null, null, null, null, null, null, null, null, null, null, null, null, composer3, 12845056, 0, 0, 2096990);
                    ImageConfig imageConfig = BackgroundInfo.this.config.mainBuilding;
                    if (WhenMappings.$EnumSwitchMapping$0[BoxType$EnumUnboxingSharedUtility.ordinal(imageConfig.type)] == 1) {
                        composer3.startReplaceableGroup(-403756642);
                        APNGKt.a(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(bVar2.a(companion, Alignment.TopEnd), imageConfig.width * BackgroundInfo.this.scale), imageConfig.height * BackgroundInfo.this.scale), null, imageConfig.src, 0, Boolean.TRUE, null, null, null, composer3, 27656, 226);
                        composer3.endReplaceableGroup();
                    } else {
                        composer3.startReplaceableGroup(-403756214);
                        ImageKt.a(imageConfig.src, null, null, null, null, ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(bVar2.a(companion, Alignment.TopEnd), imageConfig.width * BackgroundInfo.this.scale), imageConfig.height * BackgroundInfo.this.scale), null, companion2.b(), null, null, null, null, null, null, null, null, null, null, null, null, null, composer3, 12845056, 0, 0, 2096990);
                        composer3.endReplaceableGroup();
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.BackgroundLayerViewKt$BackgroundLayerView$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                BackgroundLayerViewKt.BackgroundLayerView(i.this, backgroundInfo, nBPShootResultViewModel, function0, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
