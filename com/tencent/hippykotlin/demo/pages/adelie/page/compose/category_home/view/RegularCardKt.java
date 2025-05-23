package com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.viewmodel.AdelieHomeCategoryViewModel;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.viewmodel.RegularDelegateData;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.foundation.lazy.layout.LazyDslKt;
import com.tencent.ntcompose.foundation.lazy.layout.a;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.ui.platform.CompositionLocalsKt;
import g25.k;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class RegularCardKt {
    public static final void RegularCard(final a aVar, final RegularDelegateData regularDelegateData, final e eVar, final AdelieHomeCategoryViewModel adelieHomeCategoryViewModel, Composer composer, final int i3) {
        List chunked;
        Composer startRestartGroup = composer.startRestartGroup(982765447);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(982765447, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.RegularCard (RegularCard.kt:20)");
        }
        List<k> list = regularDelegateData.data;
        if (!list.isEmpty()) {
            chunked = CollectionsKt___CollectionsKt.chunked(list, 2);
            LazyDslKt.b(aVar, chunked, null, ComposableLambdaKt.composableLambda(startRestartGroup, 666623160, true, new Function3<List<? extends k>, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.RegularCardKt$RegularCard$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public final Unit invoke(List<? extends k> list2, Composer composer2, Integer num) {
                    final List<? extends k> list3 = list2;
                    Composer composer3 = composer2;
                    int intValue = num.intValue();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(666623160, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.RegularCard.<anonymous> (RegularCard.kt:25)");
                    }
                    i.Companion companion = i.INSTANCE;
                    i j3 = ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null);
                    a.e e16 = com.tencent.ntcompose.foundation.layout.base.a.f339245a.e();
                    Alignment.Vertical vertical = Alignment.Vertical.CenterVertically;
                    final e eVar2 = e.this;
                    final RegularDelegateData regularDelegateData2 = regularDelegateData;
                    final AdelieHomeCategoryViewModel adelieHomeCategoryViewModel2 = adelieHomeCategoryViewModel;
                    RowKt.a(j3, e16, vertical, null, null, ComposableLambdaKt.composableLambda(composer3, 1350278102, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.RegularCardKt$RegularCard$2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                    ComposerKt.traceEventStart(1350278102, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.RegularCard.<anonymous>.<anonymous> (RegularCard.kt:30)");
                                }
                                List<k> list4 = list3;
                                e eVar3 = eVar2;
                                RegularDelegateData regularDelegateData3 = regularDelegateData2;
                                AdelieHomeCategoryViewModel adelieHomeCategoryViewModel3 = adelieHomeCategoryViewModel2;
                                int i16 = 0;
                                for (Object obj : list4) {
                                    int i17 = i16 + 1;
                                    if (i16 < 0) {
                                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                                    }
                                    RoleCardItemKt.RoleCardItem((k) obj, ((((com.tencent.ntcompose.ui.platform.a) composer5.consume(CompositionLocalsKt.d())).e() - 30.0f) - 11.0f) / 2, eVar3, "em_bas_agent_card", regularDelegateData3.tabName, regularDelegateData3.tabId, null, null, adelieHomeCategoryViewModel3, composer5, 134221320, 192);
                                    i16 = i17;
                                    adelieHomeCategoryViewModel3 = adelieHomeCategoryViewModel3;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 197064, 24);
                    SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion, 12.0f), composer3, 8, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    return Unit.INSTANCE;
                }
            }), startRestartGroup, 3144, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                return;
            }
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.RegularCardKt$RegularCard$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    RegularCardKt.RegularCard(com.tencent.ntcompose.foundation.lazy.layout.a.this, regularDelegateData, eVar, adelieHomeCategoryViewModel, composer2, i3 | 1);
                    return Unit.INSTANCE;
                }
            });
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup2 = startRestartGroup.endRestartGroup();
        if (endRestartGroup2 == null) {
            return;
        }
        endRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.RegularCardKt$RegularCard$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                RegularCardKt.RegularCard(com.tencent.ntcompose.foundation.lazy.layout.a.this, regularDelegateData, eVar, adelieHomeCategoryViewModel, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
