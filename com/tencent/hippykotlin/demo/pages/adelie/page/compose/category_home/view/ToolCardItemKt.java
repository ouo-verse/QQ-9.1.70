package com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.c;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.util.AdelieCategoryAIOJumpUtil;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.an;
import com.tencent.ntcompose.material.base.ModifiersKt;
import g25.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ToolCardItemKt {
    public static final void ToolCardItem(final int i3, final k kVar, Composer composer, final int i16) {
        Composer startRestartGroup = composer.startRestartGroup(1801184777);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1801184777, i16, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.ToolCardItem (ToolCardItem.kt:29)");
        }
        RowKt.a(ViewEventPropUpdaterKt.d(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 90.0f), 16.0f, 0.0f, 16.0f, 0.0f, 10, null), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.ToolCardItemKt$ToolCardItem$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ClickParams clickParams) {
                AdelieCategoryAIOJumpUtil.INSTANCE.jumpToAIO$qecommerce_biz_release(k.this, null, null, false);
                return Unit.INSTANCE;
            }
        }, 3, null), null, Alignment.Vertical.CenterVertically, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1233925081, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.ToolCardItemKt$ToolCardItem$2
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(n nVar, Composer composer2, Integer num) {
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1233925081, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.ToolCardItem.<anonymous> (ToolCardItem.kt:38)");
                    }
                    i.Companion companion = i.INSTANCE;
                    ImageKt.a(null, null, null, null, null, ModifiersKt.j(ComposeLayoutPropUpdaterKt.u(companion, 56.0f), 28.0f), null, 0, null, null, k.this.f401175f, null, null, null, null, null, null, null, null, null, null, composer3, 262144, 0, 0, 2096095);
                    i j3 = ComposeLayoutPropUpdaterKt.j(ComposeLayoutPropUpdaterKt.n(companion, 10.0f, 0.0f, 0.0f, 0.0f, 14, null), 0.0f, 1, null);
                    a.e b16 = a.f339245a.b();
                    final k kVar2 = k.this;
                    ColumnKt.a(j3, b16, null, null, ComposableLambdaKt.composableLambda(composer3, 666194192, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.ToolCardItemKt$ToolCardItem$2.1
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
                                    ComposerKt.traceEventStart(666194192, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.ToolCardItem.<anonymous>.<anonymous> (ToolCardItem.kt:49)");
                                }
                                String str = k.this.f401173e;
                                h color$default = QUIToken.color$default("text_primary");
                                c.Companion companion2 = c.INSTANCE;
                                c f16 = companion2.f();
                                an.Companion companion3 = an.INSTANCE;
                                int b17 = companion3.b();
                                i.Companion companion4 = i.INSTANCE;
                                TextKt.a(str, ComposeLayoutPropUpdaterKt.j(companion4, 0.0f, 1, null), null, color$default, Float.valueOf(16.0f), null, f16, null, null, null, null, Float.valueOf(22.0f), null, null, null, null, an.d(b17), null, 1, null, null, null, null, null, null, null, false, composer5, 1601600, 102236208, 0, 133887908);
                                TextKt.a(k.this.f401177h, ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.j(companion4, 0.0f, 1, null), 0.0f, 6.0f, 0.0f, 2.0f, 5, null), null, QUIToken.color$default("text_secondary"), Float.valueOf(14.0f), null, companion2.e(), null, null, null, null, Float.valueOf(20.0f), null, null, null, null, an.d(companion3.b()), null, 1, null, null, null, null, null, null, null, false, composer5, 1601600, 102236208, 0, 133887908);
                                HotViewKt.LightHotView(ComposeLayoutPropUpdaterKt.k(companion4, 20.0f), k.this, 0, false, composer5, 72, 12);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 24648, 12);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 197000, 26);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.ToolCardItemKt$ToolCardItem$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                ToolCardItemKt.ToolCardItem(i3, kVar, composer2, i16 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
