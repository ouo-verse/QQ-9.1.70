package com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.viewmodel.AdelieHomeCategoryViewModel;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.material.FooterRefreshKt;
import com.tencent.ntcompose.material.p;
import g25.h;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class CategoryListFooterKt {
    public static final void CategoryListFooter(final MutableState<Boolean> mutableState, final h hVar, final AdelieHomeCategoryViewModel adelieHomeCategoryViewModel, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-1116877308);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1116877308, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.CategoryListFooter (CategoryListFooter.kt:17)");
        }
        final p b16 = FooterRefreshKt.b(startRestartGroup, 0);
        b16.b(!mutableState.getValue().booleanValue());
        FooterRefreshKt.a(b16, null, null, 1000.0f, 0.0f, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.CategoryListFooterKt$CategoryListFooter$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                KLog.INSTANCE.i("CategoryListFooter", "start load more");
                AdelieHomeCategoryViewModel adelieHomeCategoryViewModel2 = AdelieHomeCategoryViewModel.this;
                h hVar2 = hVar;
                final MutableState<Boolean> mutableState2 = mutableState;
                final p pVar = b16;
                adelieHomeCategoryViewModel2.getPageDataWrapper(hVar2).loadMorePageData(new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.CategoryListFooterKt$CategoryListFooter$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Boolean bool) {
                        CategoryListFooterKt$CategoryListFooter$1$1$$ExternalSyntheticOutline0.m("load end success=", bool.booleanValue(), KLog.INSTANCE, "CategoryListFooter");
                        if (mutableState2.getValue().booleanValue()) {
                            final p pVar2 = pVar;
                            TimerKt.d(500, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.CategoryListFooterKt.CategoryListFooter.1.1.1
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final Unit invoke() {
                                    p.this.b(false);
                                    return Unit.INSTANCE;
                                }
                            });
                        }
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        }, ComposableLambdaKt.composableLambda(startRestartGroup, -717219755, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.CategoryListFooterKt$CategoryListFooter$2
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
                        ComposerKt.traceEventStart(-717219755, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.CategoryListFooter.<anonymous> (CategoryListFooter.kt:39)");
                    }
                    i s16 = ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 44.0f), 0.0f, 6.0f, 0.0f, 0.0f, 13, null);
                    final MutableState<Boolean> mutableState2 = mutableState;
                    BoxKt.a(s16, null, null, ComposableLambdaKt.composableLambda(composer3, -65610661, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.CategoryListFooterKt$CategoryListFooter$2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(b bVar, Composer composer4, Integer num2) {
                            String str;
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-65610661, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.CategoryListFooter.<anonymous>.<anonymous> (CategoryListFooter.kt:42)");
                                }
                                boolean booleanValue = mutableState2.getValue().booleanValue();
                                if (mutableState2.getValue().booleanValue()) {
                                    str = "\u52a0\u8f7d\u4e2d,\u8bf7\u7a0d\u540e...";
                                } else {
                                    str = "\u6ca1\u6709\u66f4\u591a\u4e86";
                                }
                                LoadingKt.LoadingView(booleanValue, str, composer5, 0);
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
        }), startRestartGroup, 1575936, 22);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.CategoryListFooterKt$CategoryListFooter$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                CategoryListFooterKt.CategoryListFooter(mutableState, hVar, adelieHomeCategoryViewModel, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
