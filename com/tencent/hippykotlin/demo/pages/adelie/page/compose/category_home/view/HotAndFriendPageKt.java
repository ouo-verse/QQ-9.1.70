package com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.material.SurfaceKt;
import com.tencent.ntcompose.ui.platform.CompositionLocalsKt;
import g25.a;
import g25.k;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* loaded from: classes31.dex */
public final class HotAndFriendPageKt {
    public static final void HotAndFriendPage(final List<k> list, final a aVar, final int i3, final e eVar, Composer composer, final int i16) {
        Composer startRestartGroup = composer.startRestartGroup(290907634);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(290907634, i16, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.HotAndFriendPage (HotAndFriendPage.kt:14)");
        }
        SurfaceKt.a(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, (((com.tencent.ntcompose.ui.platform.a) startRestartGroup.consume(CompositionLocalsKt.d())).e() - 30.0f) - 44.0f), null, null, QUIToken.color$default("fill_light_primary"), ComposableLambdaKt.composableLambda(startRestartGroup, -966537488, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.HotAndFriendPageKt$HotAndFriendPage$1
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
                        ComposerKt.traceEventStart(-966537488, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.HotAndFriendPage.<anonymous> (HotAndFriendPage.kt:23)");
                    }
                    i w3 = ComposeLayoutPropUpdaterKt.w(i.INSTANCE, (((com.tencent.ntcompose.ui.platform.a) composer3.consume(CompositionLocalsKt.d())).e() - 30.0f) - 44.0f);
                    final List<k> list2 = list;
                    final int i17 = i3;
                    final a aVar2 = aVar;
                    final e eVar2 = eVar;
                    ColumnKt.a(w3, null, null, null, ComposableLambdaKt.composableLambda(composer3, -61904679, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.HotAndFriendPageKt$HotAndFriendPage$1.1
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
                                    ComposerKt.traceEventStart(-61904679, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.HotAndFriendPage.<anonymous>.<anonymous> (HotAndFriendPage.kt:26)");
                                }
                                List<k> list3 = list2;
                                int i18 = i17;
                                a aVar3 = aVar2;
                                e eVar3 = eVar2;
                                int i19 = 0;
                                for (Object obj : list3) {
                                    int i26 = i19 + 1;
                                    if (i19 < 0) {
                                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                                    }
                                    HotAndFriendItemKt.HotAndFriendItem((list3.size() * i18) + i19 + 1, (k) obj, aVar3.f401137m, eVar3, aVar3.f401133e, composer5, 4160);
                                    i19 = i26;
                                }
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
        }), startRestartGroup, 28680, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.HotAndFriendPageKt$HotAndFriendPage$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                HotAndFriendPageKt.HotAndFriendPage(list, aVar, i3, eVar, composer2, i16 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
