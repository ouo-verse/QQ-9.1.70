package com.tencent.hippykotlin.demo.pages.nearby.qq_stranger_nearby_entry_guide;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.kuikly.core.base.h;
import com.tencent.ntcompose.core.ComposeNodeKt;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.core.k;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.material.CanvasViewPropUpdater;
import com.tencent.ntcompose.material.ModalKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.f;
import com.tencent.ntcompose.ui.platform.CompositionLocalsKt;
import com.tencent.ntcompose.ui.platform.a;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* loaded from: classes31.dex */
public final class QQStrangerNearbyEntryGuidePageKt {
    public static final void access$GuideView(final i iVar, final GuideParams guideParams, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-1180930044);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1180930044, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.qq_stranger_nearby_entry_guide.GuideView (QQStrangerNearbyEntryGuidePage.kt:69)");
        }
        a aVar = (a) startRestartGroup.consume(CompositionLocalsKt.d());
        final com.tencent.ntcompose.material.i a16 = f.a(false, startRestartGroup, 0, 1);
        EffectsKt.LaunchedEffect(Unit.INSTANCE, new QQStrangerNearbyEntryGuidePageKt$GuideView$1(a16, aVar, guideParams, null), startRestartGroup, 64);
        ModalKt.a(ComposeLayoutPropUpdaterKt.h(iVar, 0.0f, 1, null), true, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -332391166, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.qq_stranger_nearby_entry_guide.QQStrangerNearbyEntryGuidePageKt$GuideView$2
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
                        ComposerKt.traceEventStart(-332391166, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.qq_stranger_nearby_entry_guide.GuideView.<anonymous> (QQStrangerNearbyEntryGuidePage.kt:139)");
                    }
                    i h16 = ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null);
                    final com.tencent.ntcompose.material.i iVar2 = com.tencent.ntcompose.material.i.this;
                    final GuideParams guideParams2 = guideParams;
                    BoxKt.a(h16, null, null, ComposableLambdaKt.composableLambda(composer3, 1953935036, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.qq_stranger_nearby_entry_guide.QQStrangerNearbyEntryGuidePageKt$GuideView$2.1
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
                                    ComposerKt.traceEventStart(1953935036, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.qq_stranger_nearby_entry_guide.GuideView.<anonymous>.<anonymous> (QQStrangerNearbyEntryGuidePage.kt:142)");
                                }
                                i.Companion companion = i.INSTANCE;
                                i h17 = ComposeLayoutPropUpdaterKt.h(companion, 0.0f, 1, null);
                                com.tencent.ntcompose.material.i iVar3 = com.tencent.ntcompose.material.i.this;
                                int i16 = (com.tencent.ntcompose.material.i.f339424f << 3) | 8;
                                composer5.startReplaceableGroup(-522895883);
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(new k("drawCallbackEmpty", iVar3, null, null, null, null, CanvasViewPropUpdater.f339340a, 60, null));
                                ComposeNodeKt.a("Canvas", com.tencent.ntcompose.material.base.a.f339408a, null, h17, arrayList, null, composer5, ((i16 << 9) & 7168) | 33206, 32);
                                composer5.endReplaceableGroup();
                                h m3 = h.INSTANCE.m();
                                GuideParams guideParams3 = guideParams2;
                                TextKt.a("\u9644\u8fd1\u5408\u5e76\u5230\u8fd9\u91cc\u5566\uff0c\u70b9\u51fb\u67e5\u770b\u9644\u8fd1\u7684\u4eba\u548c\u52a8\u6001", ComposeLayoutPropUpdaterKt.n(companion, 20.0f, guideParams3.targetY + 50.0f + guideParams3.targetHeight, 20.0f, 0.0f, 8, null), null, m3, Float.valueOf(16.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer5, 28742, 0, 0, 134217700);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.qq_stranger_nearby_entry_guide.QQStrangerNearbyEntryGuidePageKt$GuideView$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQStrangerNearbyEntryGuidePageKt.access$GuideView(i.this, guideParams, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
