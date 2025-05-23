package com.tencent.hippykotlin.demo.pages.qq_intimate_space.component;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import ap3.a;
import bp3.j;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.GuideBannerCardAnimationViewKt$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.h;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.RichTextKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class LoveWallFeedBackBubbleViewKt {
    public static final void LoveWallFeedBackBubbleView(final i iVar, final String str, final List<String> list, Composer composer, final int i3, final int i16) {
        Composer startRestartGroup = composer.startRestartGroup(-20594390);
        if ((i16 & 4) != 0) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-20594390, i3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallFeedBackBubbleView (LoveWallFeedBackBubbleView.kt:27)");
        }
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = GuideBannerCardAnimationViewKt$$ExternalSyntheticOutline0.m(102, null, 2, null, startRestartGroup);
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState mutableState = (MutableState) rememberedValue;
        final float f16 = 28;
        BoxKt.a(ComposeLayoutPropUpdaterKt.k(iVar, Math.max(((Number) mutableState.getValue()).floatValue() + f16 + 20, 78)), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -879253532, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallFeedBackBubbleViewKt$LoveWallFeedBackBubbleView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(b bVar, Composer composer2, Integer num) {
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-879253532, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallFeedBackBubbleView.<anonymous> (LoveWallFeedBackBubbleView.kt:36)");
                    }
                    i h16 = ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null);
                    final MutableState<Float> mutableState2 = mutableState;
                    final float f17 = f16;
                    final String str2 = str;
                    final List<String> list2 = list;
                    ColumnKt.a(h16, null, null, null, ComposableLambdaKt.composableLambda(composer3, 25379277, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallFeedBackBubbleViewKt$LoveWallFeedBackBubbleView$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(d dVar, Composer composer4, Integer num2) {
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(25379277, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallFeedBackBubbleView.<anonymous>.<anonymous> (LoveWallFeedBackBubbleView.kt:37)");
                                }
                                i.Companion companion = i.INSTANCE;
                                i j3 = ModifiersKt.j(ModifiersKt.d(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null), Math.max(mutableState2.getValue().floatValue() + f17, 58)), h.INSTANCE.p(0.8f)), 8.0f);
                                final MutableState<Float> mutableState3 = mutableState2;
                                final String str3 = str2;
                                final List<String> list3 = list2;
                                BoxKt.a(j3, null, null, ComposableLambdaKt.composableLambda(composer5, -210228729, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallFeedBackBubbleViewKt.LoveWallFeedBackBubbleView.1.1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(b bVar2, Composer composer6, Integer num3) {
                                        int i17;
                                        b bVar3 = bVar2;
                                        Composer composer7 = composer6;
                                        int intValue3 = num3.intValue();
                                        if ((intValue3 & 14) == 0) {
                                            i17 = (composer7.changed(bVar3) ? 4 : 2) | intValue3;
                                        } else {
                                            i17 = intValue3;
                                        }
                                        if ((i17 & 91) == 18 && composer7.getSkipping()) {
                                            composer7.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-210228729, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallFeedBackBubbleView.<anonymous>.<anonymous>.<anonymous> (LoveWallFeedBackBubbleView.kt:41)");
                                            }
                                            i.Companion companion2 = i.INSTANCE;
                                            ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.o(bVar3.a(ComposeLayoutPropUpdaterKt.v(companion2, 17.0f, 12.38f), Alignment.BottomEnd), -9, -6.33f), null, 0, null, null, "https://image.superqqshow.qq.com/wuji/qq_zplan_config_test/couple_space_pic_resouce/4221bcd7_haCKAgse4kE.png", null, null, null, null, null, null, null, null, null, null, composer7, 262144, 6, 0, 2096095);
                                            float f18 = 16;
                                            i m3 = ComposeLayoutPropUpdaterKt.m(ComposeLayoutPropUpdaterKt.j(companion2, 0.0f, 1, null), f18, f18, f18, 12);
                                            final MutableState<Float> mutableState4 = mutableState3;
                                            composer7.startReplaceableGroup(1157296644);
                                            boolean changed = composer7.changed(mutableState4);
                                            Object rememberedValue2 = composer7.rememberedValue();
                                            if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                rememberedValue2 = new Function1<a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallFeedBackBubbleViewKt$LoveWallFeedBackBubbleView$1$1$1$1$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(a aVar) {
                                                        mutableState4.setValue(Float.valueOf(aVar.getSize().getHeight()));
                                                        return Unit.INSTANCE;
                                                    }
                                                };
                                                composer7.updateRememberedValue(rememberedValue2);
                                            }
                                            composer7.endReplaceableGroup();
                                            i k3 = ViewEventPropUpdaterKt.k(m3, (Function1) rememberedValue2);
                                            String str4 = str3;
                                            h.Companion companion3 = h.INSTANCE;
                                            RichTextKt.b(LoveSproutCardViewKt.highlightedText(str4, new j(companion3.b(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32766, null), list3, new j(new h(255, 128, 0, 1.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32766, null)), k3, null, companion3.b(), Float.valueOf(14.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, composer7, 28736, 0, 0, 268435428);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer5, 3080, 6);
                                ImageKt.a(null, null, null, null, null, ModifiersKt.D(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.v(companion, 56, 20), 63, 0.0f, 0.0f, 0.0f, 14, null), 0.8f), null, 0, null, null, "https://image.superqqshow.qq.com/wuji/qq_zplan_config_test/couple_space_pic_resouce/4221bcd7_XCf2iUPdW6t.png", null, null, null, null, null, null, null, null, null, null, composer5, 262144, 6, 0, 2096095);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 24584, 14);
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
        final List<String> list2 = list;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallFeedBackBubbleViewKt$LoveWallFeedBackBubbleView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                LoveWallFeedBackBubbleViewKt.LoveWallFeedBackBubbleView(i.this, str, list2, composer2, i3 | 1, i16);
                return Unit.INSTANCE;
            }
        });
    }
}
