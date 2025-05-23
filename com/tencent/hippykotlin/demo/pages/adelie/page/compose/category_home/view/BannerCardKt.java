package com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.adelie.common.compose.util.StateHolder;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.viewmodel.AdelieHomePageBannerConfig;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.viewmodel.AdelieHomePageBannerItemData;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.viewmodel.BannerDelegateData;
import com.tencent.hippykotlin.demo.pages.compose_ui.view.adelie.BannerWithIndicatorKt;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.luggage.wxa.ig.w;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.ui.platform.CompositionLocalsKt;
import com.tencent.ntcompose.ui.platform.a;
import g25.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class BannerCardKt {
    public static final void BannerCard(final StateHolder<AdelieHomePageBannerConfig> stateHolder, final BannerDelegateData bannerDelegateData, final e eVar, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(1264442647);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1264442647, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.BannerCard (BannerCard.kt:35)");
        }
        final AdelieHomePageBannerConfig value = stateHolder._state.getValue();
        if (value == null) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                return;
            }
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.BannerCardKt$BannerCard$bannerConfig$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    BannerCardKt.BannerCard(stateHolder, bannerDelegateData, eVar, composer2, i3 | 1);
                    return Unit.INSTANCE;
                }
            });
            return;
        }
        final ArrayList arrayList = new ArrayList();
        g gVar = bannerDelegateData != null ? bannerDelegateData.robotGuideInfo : null;
        if (gVar != null) {
            arrayList.add(gVar);
        }
        Iterator<AdelieHomePageBannerItemData> it = value.itemList.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        if (arrayList.isEmpty()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ScopeUpdateScope endRestartGroup2 = startRestartGroup.endRestartGroup();
            if (endRestartGroup2 == null) {
                return;
            }
            endRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.BannerCardKt$BannerCard$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    BannerCardKt.BannerCard(stateHolder, bannerDelegateData, eVar, composer2, i3 | 1);
                    return Unit.INSTANCE;
                }
            });
            return;
        }
        final float e16 = ((a) startRestartGroup.consume(CompositionLocalsKt.d())).e() - 32.0f;
        final float f16 = e16 * 0.39941692f;
        ColumnKt.a(null, null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1525282496, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.BannerCardKt$BannerCard$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(d dVar, Composer composer2, Integer num) {
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1525282496, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.BannerCard.<anonymous> (BannerCard.kt:50)");
                    }
                    List<Object> list = arrayList;
                    float f17 = e16;
                    i.Companion companion = i.INSTANCE;
                    i w3 = ComposeLayoutPropUpdaterKt.w(ComposeLayoutPropUpdaterKt.k(companion, f16), e16);
                    int i16 = (int) value.loopInterval;
                    AnonymousClass1 anonymousClass1 = new Function1<Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.BannerCardKt$BannerCard$2.1
                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(Integer num2) {
                            num2.intValue();
                            k kVar = (k) c.f117352a.g().acquireModule("KRNotifyModule");
                            e eVar2 = new e();
                            eVar2.w("show_next_time", false);
                            Unit unit = Unit.INSTANCE;
                            k.d(kVar, "adelie_interrupt_guide_animation", eVar2, false, 4, null);
                            return Unit.INSTANCE;
                        }
                    };
                    final float f18 = e16;
                    final float f19 = f16;
                    final e eVar2 = eVar;
                    BannerWithIndicatorKt.BannerWithIndicator(list, f17, w3, i16, false, false, 0.0f, null, null, anonymousClass1, ComposableLambdaKt.composableLambda(composer3, 404711998, true, new Function4<Integer, Object, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.BannerCardKt$BannerCard$2.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(4);
                        }

                        @Override // kotlin.jvm.functions.Function4
                        public final Unit invoke(Integer num2, Object obj, Composer composer4, Integer num3) {
                            num2.intValue();
                            Composer composer5 = composer4;
                            int intValue2 = num3.intValue();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(404711998, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.BannerCard.<anonymous>.<anonymous> (BannerCard.kt:63)");
                            }
                            if (obj instanceof g) {
                                composer5.startReplaceableGroup(1079276334);
                                GuideBannerCardKt.GuideBannerCard((g) obj, f18, f19, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.BannerCardKt.BannerCard.2.2.1
                                    @Override // kotlin.jvm.functions.Function0
                                    public final /* bridge */ /* synthetic */ Unit invoke() {
                                        return Unit.INSTANCE;
                                    }
                                }, eVar2, composer5, 35848);
                                composer5.endReplaceableGroup();
                            } else if (obj instanceof AdelieHomePageBannerItemData) {
                                composer5.startReplaceableGroup(1079276548);
                                RegularBannerCardKt.RegularBannerCard((AdelieHomePageBannerItemData) obj, eVar2, composer5, 72);
                                composer5.endReplaceableGroup();
                            } else {
                                composer5.startReplaceableGroup(1079276624);
                                composer5.endReplaceableGroup();
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 805306888, 6, w.CTRL_INDEX);
                    SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion, 12.0f), composer3, 8, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 24576, 15);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup3 = startRestartGroup.endRestartGroup();
        if (endRestartGroup3 == null) {
            return;
        }
        endRestartGroup3.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.BannerCardKt$BannerCard$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                BannerCardKt.BannerCard(stateHolder, bannerDelegateData, eVar, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
