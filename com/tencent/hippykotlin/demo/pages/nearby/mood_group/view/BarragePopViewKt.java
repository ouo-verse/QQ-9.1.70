package com.tencent.hippykotlin.demo.pages.nearby.mood_group.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.NBPMoodGroupViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.data.NBPMoodGroupConfig;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.NBPMoodGroupReportViewModel;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.layout.d;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.g;
import com.tencent.ntcompose.animation.AnimateAsStateKt;
import com.tencent.ntcompose.animation.b;
import com.tencent.ntcompose.animation.i;
import com.tencent.ntcompose.animation.m;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.k;
import com.tencent.ntcompose.foundation.layout.l;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.foundation.lazy.layout.a;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.LazyColumnKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.an;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.ranges.RangesKt___RangesKt;

/* loaded from: classes31.dex */
public final class BarragePopViewKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final void BarragePopView(final NBPMoodGroupViewModel nBPMoodGroupViewModel, Composer composer, final int i3) {
        final NBPMoodGroupConfig.BarrageConfig barrageConfig;
        Composer startRestartGroup = composer.startRestartGroup(-268283201);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-268283201, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.BarragePopView (BarragePopView.kt:39)");
        }
        NBPMoodGroupConfig nBPMoodGroupConfig = nBPMoodGroupViewModel.config;
        if (nBPMoodGroupConfig != null && (barrageConfig = nBPMoodGroupConfig.barrageConfig) != null) {
            final g gVar = nBPMoodGroupViewModel.pageData;
            startRestartGroup.startReplaceableGroup(-492369756);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            final MutableState mutableState = (MutableState) rememberedValue;
            if (((Boolean) nBPMoodGroupViewModel.barragePopShow$delegate.getValue()).booleanValue()) {
                mutableState.setValue(Boolean.TRUE);
            }
            if (!((Boolean) mutableState.getValue()).booleanValue()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                    return;
                }
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.BarragePopViewKt$BarragePopView$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Unit invoke(Composer composer2, Integer num) {
                        num.intValue();
                        BarragePopViewKt.BarragePopView(NBPMoodGroupViewModel.this, composer2, i3 | 1);
                        return Unit.INSTANCE;
                    }
                });
                return;
            }
            float f16 = ((Boolean) nBPMoodGroupViewModel.barragePopShow$delegate.getValue()).booleanValue() ? 1.0f : 0.0f;
            m d16 = b.d(200, 0, i.c(), null, 10, null);
            startRestartGroup.startReplaceableGroup(1157296644);
            boolean changed = startRestartGroup.changed(mutableState);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new Function1<Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.BarragePopViewKt$BarragePopView$alpha$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Float f17) {
                        if (f17.floatValue() == 0.0f) {
                            mutableState.setValue(Boolean.FALSE);
                        }
                        return Unit.INSTANCE;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceableGroup();
            BoxKt.a(ModifiersKt.T(ViewEventPropUpdaterKt.d(ModifiersKt.c(ModifiersKt.b(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(com.tencent.ntcompose.core.i.INSTANCE, gVar.m()), gVar.l()), AnimateAsStateKt.c(f16, d16, (Function1) rememberedValue2, startRestartGroup, 0, 0).getValue().floatValue()), new h(0L, 0.2f)), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.BarragePopViewKt$BarragePopView$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(ClickParams clickParams) {
                    NBPMoodGroupViewModel.this.changeBarragePopVisible(false);
                    return Unit.INSTANCE;
                }
            }, 3, null), 3), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1991488633, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.BarragePopViewKt$BarragePopView$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer2, Integer num) {
                    float l3;
                    Composer composer3 = composer2;
                    int intValue = num.intValue();
                    if ((intValue & 81) == 16 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                    } else {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1991488633, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.BarragePopView.<anonymous> (BarragePopView.kt:73)");
                        }
                        float f17 = 2;
                        float size = (f17 * 8.0f) + ((NBPMoodGroupConfig.BarrageConfig.this.items.size() - 1) * 6.0f) + (NBPMoodGroupConfig.BarrageConfig.this.items.size() * 36.0f);
                        float m3 = (gVar.m() - 160.0f) - 2.0f;
                        d dVar = nBPMoodGroupViewModel.barrageIconFrame;
                        if (dVar != null) {
                            m3 = RangesKt___RangesKt.coerceAtMost((dVar.getWidth() / f17) + (dVar.getX() - (160.0f / f17)), m3);
                        }
                        d dVar2 = nBPMoodGroupViewModel.barrageIconFrame;
                        if (dVar2 != null) {
                            l3 = (dVar2.getY() - size) - 16.0f;
                        } else {
                            l3 = (gVar.l() - size) - 163.0f;
                        }
                        com.tencent.ntcompose.core.i o16 = ComposeLayoutPropUpdaterKt.o(ModifiersKt.p(ModifiersKt.j(ModifiersKt.c(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(com.tencent.ntcompose.core.i.INSTANCE, 160.0f), size), new h(4294967295L)), 16.0f), new com.tencent.kuikly.core.base.g(0.0f, 4.0f, 14.0f, new h(0L, 0.25f))), m3, l3);
                        l a16 = k.a(8.0f);
                        final NBPMoodGroupConfig.BarrageConfig barrageConfig2 = NBPMoodGroupConfig.BarrageConfig.this;
                        final NBPMoodGroupViewModel nBPMoodGroupViewModel2 = nBPMoodGroupViewModel;
                        LazyColumnKt.a(o16, null, null, a16, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, ComposableLambdaKt.composableLambda(composer3, 219280414, true, new Function3<a, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.BarragePopViewKt$BarragePopView$3.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(a aVar, Composer composer4, Integer num2) {
                                int lastIndex;
                                Composer composer5 = composer4;
                                int intValue2 = num2.intValue();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(219280414, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.BarragePopView.<anonymous>.<anonymous> (BarragePopView.kt:102)");
                                }
                                NBPMoodGroupConfig.BarrageConfig barrageConfig3 = NBPMoodGroupConfig.BarrageConfig.this;
                                List<NBPMoodGroupConfig.BarrageItemConfig> list = barrageConfig3.items;
                                final NBPMoodGroupViewModel nBPMoodGroupViewModel3 = nBPMoodGroupViewModel2;
                                int i16 = 0;
                                for (Object obj : list) {
                                    int i17 = i16 + 1;
                                    if (i16 < 0) {
                                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                                    }
                                    final NBPMoodGroupConfig.BarrageItemConfig barrageItemConfig = (NBPMoodGroupConfig.BarrageItemConfig) obj;
                                    lastIndex = CollectionsKt__CollectionsKt.getLastIndex(barrageConfig3.items);
                                    RowKt.a(ViewEventPropUpdaterKt.d(ViewEventPropUpdaterKt.l(ComposeLayoutPropUpdaterKt.n(ModifiersKt.j(ModifiersKt.c(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(com.tencent.ntcompose.core.i.INSTANCE, 144.0f), 36.0f), new h(168628273L)), 12.0f), 0.0f, 0.0f, 0.0f, i16 == lastIndex ? 0.0f : 6.0f, 7, null), new Function1<ap3.a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.BarragePopViewKt$BarragePopView$3$1$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ap3.a aVar2) {
                                            NBPMoodGroupReportViewModel reportVM = NBPMoodGroupViewModel.this.getReportVM();
                                            e eVar = new e();
                                            eVar.v("nearby_bullet_text", barrageItemConfig.text);
                                            Unit unit = Unit.INSTANCE;
                                            reportVM.dtReportElementImp("em_nearby_bullet_screen_text", eVar);
                                            return Unit.INSTANCE;
                                        }
                                    }), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.BarragePopViewKt$BarragePopView$3$1$1$2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ClickParams clickParams) {
                                            NBPMoodGroupViewModel.this.changeBarragePopVisible(false);
                                            NBPMoodGroupViewModel.this.barrageLoopManger.sendBarrage(barrageItemConfig, true);
                                            NBPMoodGroupReportViewModel reportVM = NBPMoodGroupViewModel.this.getReportVM();
                                            e eVar = new e();
                                            eVar.v("nearby_bullet_text", barrageItemConfig.text);
                                            Unit unit = Unit.INSTANCE;
                                            reportVM.dtReportElementClick("em_nearby_bullet_screen_text", eVar);
                                            return Unit.INSTANCE;
                                        }
                                    }, 3, null), com.tencent.ntcompose.foundation.layout.base.a.f339245a.g(), Alignment.INSTANCE.c(), null, null, ComposableLambdaKt.composableLambda(composer5, -2033399826, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.BarragePopViewKt$BarragePopView$3$1$1$3
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public final Unit invoke(n nVar, Composer composer6, Integer num3) {
                                            Composer composer7 = composer6;
                                            int intValue3 = num3.intValue();
                                            if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                                composer7.skipToGroupEnd();
                                            } else {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-2033399826, intValue3, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.BarragePopView.<anonymous>.<anonymous>.<anonymous>.<anonymous> (BarragePopView.kt:129)");
                                                }
                                                i.Companion companion2 = com.tencent.ntcompose.core.i.INSTANCE;
                                                ImageKt.a(NBPMoodGroupConfig.BarrageItemConfig.this.icon.src, null, null, null, null, ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion2, 24.0f), 24.0f), 8.0f, 0.0f, 4.0f, 0.0f, 10, null), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer7, 262144, 0, 0, 2097118);
                                                com.tencent.ntcompose.core.i z16 = ComposeLayoutPropUpdaterKt.z(ComposeLayoutPropUpdaterKt.w(companion2, 100.0f));
                                                h hVar = new h(4279901214L);
                                                TextKt.a(NBPMoodGroupConfig.BarrageItemConfig.this.text, z16, null, hVar, Float.valueOf(14.0f), null, null, null, null, null, null, null, null, null, null, null, an.d(an.INSTANCE.b()), null, 1, null, null, null, null, null, null, null, false, composer7, 28736, 102236160, 0, 133890020);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer5, 196680, 24);
                                    i16 = i17;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer3, 3080, 0, MsgConstant.KRMFILETHUMBSIZE384, 4194294);
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
            ScopeUpdateScope endRestartGroup2 = startRestartGroup.endRestartGroup();
            if (endRestartGroup2 == null) {
                return;
            }
            endRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.BarragePopViewKt$BarragePopView$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    BarragePopViewKt.BarragePopView(NBPMoodGroupViewModel.this, composer2, i3 | 1);
                    return Unit.INSTANCE;
                }
            });
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup3 = startRestartGroup.endRestartGroup();
        if (endRestartGroup3 == null) {
            return;
        }
        endRestartGroup3.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.BarragePopViewKt$BarragePopView$config$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                BarragePopViewKt.BarragePopView(NBPMoodGroupViewModel.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
