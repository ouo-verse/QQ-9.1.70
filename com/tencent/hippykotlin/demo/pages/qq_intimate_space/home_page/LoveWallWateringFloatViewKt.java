package com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.LoveWallHomepageViewModel;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.material.APNGKt;
import com.tencent.ntcompose.material.SpacerKt;
import e25.aj;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class LoveWallWateringFloatViewKt {
    public static final int getReportTaskTypeOfWaterTask(aj ajVar) {
        int i3 = ajVar.f395459d;
        if (i3 != 2) {
            return i3 != 3 ? 0 : 2;
        }
        return 1;
    }

    public static final void LoveWallWateringFloatView(final LoveWallHomepageViewModel loveWallHomepageViewModel, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-280929092);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-280929092, i3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallWateringFloatView (LoveWallWateringFloatView.kt:21)");
        }
        if (loveWallHomepageViewModel.playWateringAnimation.getValue().booleanValue()) {
            BoxKt.a(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), Alignment.Center, null, ComposableLambdaKt.composableLambda(startRestartGroup, 504068125, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallWateringFloatViewKt$LoveWallWateringFloatView$1
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
                            ComposerKt.traceEventStart(504068125, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallWateringFloatView.<anonymous> (LoveWallWateringFloatView.kt:25)");
                        }
                        i h16 = ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null);
                        a.k a16 = a.f339245a.a();
                        Alignment.Horizontal b16 = Alignment.INSTANCE.b();
                        final LoveWallHomepageViewModel loveWallHomepageViewModel2 = LoveWallHomepageViewModel.this;
                        ColumnKt.a(h16, a16, b16, null, ComposableLambdaKt.composableLambda(composer3, 1046282452, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallWateringFloatViewKt$LoveWallWateringFloatView$1.1
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
                                        ComposerKt.traceEventStart(1046282452, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallWateringFloatView.<anonymous>.<anonymous> (LoveWallWateringFloatView.kt:29)");
                                    }
                                    i.Companion companion = i.INSTANCE;
                                    i v3 = ComposeLayoutPropUpdaterKt.v(companion, 193, 580);
                                    final LoveWallHomepageViewModel loveWallHomepageViewModel3 = LoveWallHomepageViewModel.this;
                                    APNGKt.a(v3, null, "https://image.superqqshow.qq.com/wuji/qq_zplan_config_test/couple_space_pic_resouce/4221bcd7_CqheU_Z81RB.png", 1, null, null, null, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallWateringFloatViewKt.LoveWallWateringFloatView.1.1.1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(Object obj) {
                                            LoveWallHomepageViewModel.this.playWateringAnimation.setValue(Boolean.FALSE);
                                            LoveWallHomepageViewModel.fetchTree$default(LoveWallHomepageViewModel.this, false, null, 3);
                                            LoveWallHomepageViewModel.this.fetchWaterInfo(null);
                                            return Unit.INSTANCE;
                                        }
                                    }, composer5, 3464, 114);
                                    SpacerKt.a(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null), 160), composer5, 8, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer3, 24648, 8);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    return Unit.INSTANCE;
                }
            }), startRestartGroup, 3128, 4);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallWateringFloatViewKt$LoveWallWateringFloatView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                LoveWallWateringFloatViewKt.LoveWallWateringFloatView(LoveWallHomepageViewModel.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
