package com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import ap3.a;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.shoot.NBPShootViewModel;
import com.tencent.kuikly.core.base.h;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ShootGuideTipViewKt {
    public static final void ShootGuideTipView(final NBPShootViewModel nBPShootViewModel, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-625325811);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-625325811, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootGuideTipView (ShootGuideTipView.kt:19)");
        }
        if (nBPShootViewModel.showTopGuideTip.getValue().booleanValue()) {
            BoxKt.a(null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 884025036, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootGuideTipViewKt$ShootGuideTipView$1
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
                            ComposerKt.traceEventStart(884025036, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootGuideTipView.<anonymous> (ShootGuideTipView.kt:21)");
                        }
                        i.Companion companion = i.INSTANCE;
                        i r16 = ComposeLayoutPropUpdaterKt.r(companion, 10.0f, 8.0f, 10.0f, 8.0f);
                        final NBPShootViewModel nBPShootViewModel2 = NBPShootViewModel.this;
                        i c16 = ModifiersKt.c(ModifiersKt.j(ViewEventPropUpdaterKt.l(r16, new Function1<a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootGuideTipViewKt$ShootGuideTipView$1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(a aVar) {
                                NBPShootViewModel.this.reporter.dtReportElementImp("em_nearby_luck_card_guide_bubble", null);
                                return Unit.INSTANCE;
                            }
                        }), 4.0f), h.INSTANCE.a(0.7f));
                        final NBPShootViewModel nBPShootViewModel3 = NBPShootViewModel.this;
                        RowKt.a(c16, null, null, null, null, ComposableLambdaKt.composableLambda(composer3, -213591062, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootGuideTipViewKt$ShootGuideTipView$1.2
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(n nVar, Composer composer4, Integer num2) {
                                Composer composer5 = composer4;
                                int intValue2 = num2.intValue();
                                if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                    composer5.skipToGroupEnd();
                                } else {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-213591062, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootGuideTipView.<anonymous>.<anonymous> (ShootGuideTipView.kt:27)");
                                    }
                                    TextKt.a(NBPShootViewModel.this.topGuideTipText, null, null, h.INSTANCE.m(), Float.valueOf(14.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer5, 28672, 0, 0, 134217702);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer3, 196616, 30);
                        RowKt.a(ComposeLayoutPropUpdaterKt.p(ModifiersKt.E(ComposeLayoutPropUpdaterKt.v(bVar2.a(companion, Alignment.BottomCenter), 15.0f, 5.0f), true), 0.0f, 5.0f, 1, null), com.tencent.ntcompose.foundation.layout.base.a.f339245a.b(), null, null, null, ComposableSingletons$ShootGuideTipViewKt.f82lambda2, composer3, 196680, 28);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    return Unit.INSTANCE;
                }
            }), startRestartGroup, 3072, 7);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootGuideTipViewKt$ShootGuideTipView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                ShootGuideTipViewKt.ShootGuideTipView(NBPShootViewModel.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
