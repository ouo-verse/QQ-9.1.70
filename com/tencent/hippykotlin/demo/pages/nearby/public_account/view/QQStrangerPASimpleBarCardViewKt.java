package com.tencent.hippykotlin.demo.pages.nearby.public_account.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView$body$1$1$3$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.manager.c;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import o35.i;

/* loaded from: classes31.dex */
public final class QQStrangerPASimpleBarCardViewKt {
    public static final void QQStrangerPASimpleBarCardView(final i iVar, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-2137632524);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2137632524, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPASimpleBarCardView (QQStrangerPASimpleBarCardView.kt:23)");
        }
        RowKt.a(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(com.tencent.ntcompose.core.i.INSTANCE, GoodsCenterProductView$body$1$1$3$$ExternalSyntheticOutline0.m(c.f117352a) - (2 * 6.0f)), 70.0f), a.f339245a.b(), Alignment.INSTANCE.c(), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1846694766, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPASimpleBarCardViewKt$QQStrangerPASimpleBarCardView$1
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(n nVar, Composer composer2, Integer num) {
                int i16;
                n nVar2 = nVar;
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 14) == 0) {
                    i16 = (composer3.changed(nVar2) ? 4 : 2) | intValue;
                } else {
                    i16 = intValue;
                }
                if ((i16 & 91) == 18 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1846694766, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPASimpleBarCardView.<anonymous> (QQStrangerPASimpleBarCardView.kt:30)");
                    }
                    i.Companion companion = com.tencent.ntcompose.core.i.INSTANCE;
                    float f16 = 24;
                    com.tencent.ntcompose.core.i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.v(companion, f16, f16), 0.0f, 0.0f, 8.0f, 0.0f, 11, null);
                    o35.i iVar2 = o35.i.this;
                    ImageKt.a(iVar2 != null ? iVar2.f421916d : null, null, null, null, null, n3, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer3, 262144, 0, 0, 2097118);
                    o35.i iVar3 = o35.i.this;
                    TextKt.a(iVar3 != null ? iVar3.f421917e : null, null, null, QUIToken.color$default("text_primary"), Float.valueOf(16.0f), null, bp3.c.INSTANCE.f(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, 1601536, 0, 0, 134217638);
                    SpacerKt.a(nVar2.a(ComposeLayoutPropUpdaterKt.B(companion), 1.0f), composer3, 8, 0);
                    com.tencent.ntcompose.core.i j3 = ModifiersKt.j(ModifiersKt.d(ComposeLayoutPropUpdaterKt.v(companion, 74.0f, 29.0f), QUIToken.color$default("button_bg_primary_default")), 4.0f);
                    final o35.i iVar4 = o35.i.this;
                    com.tencent.ntcompose.core.i d16 = ViewEventPropUpdaterKt.d(j3, false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPASimpleBarCardViewKt$QQStrangerPASimpleBarCardView$1.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ClickParams clickParams) {
                            String str;
                            o35.i iVar5 = o35.i.this;
                            if (iVar5 != null && (str = iVar5.f421919h) != null) {
                                QQKuiklyPlatformApi.Companion companion2 = QQKuiklyPlatformApi.Companion;
                                QQKuiklyPlatformApi.Companion.openPage$default(str, false, 6);
                            }
                            return Unit.INSTANCE;
                        }
                    }, 3, null);
                    Alignment alignment = Alignment.Center;
                    final o35.i iVar5 = o35.i.this;
                    BoxKt.a(d16, alignment, null, ComposableLambdaKt.composableLambda(composer3, -255073204, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPASimpleBarCardViewKt$QQStrangerPASimpleBarCardView$1.2
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
                                    ComposerKt.traceEventStart(-255073204, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPASimpleBarCardView.<anonymous>.<anonymous> (QQStrangerPASimpleBarCardView.kt:53)");
                                }
                                o35.i iVar6 = o35.i.this;
                                TextKt.a(iVar6 != null ? iVar6.f421918f : null, null, null, QUIToken.color$default("button_text_primary_default"), Float.valueOf(14.0f), null, bp3.c.INSTANCE.e(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer5, 1601536, 0, 0, 134217638);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 3128, 4);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 196680, 24);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPASimpleBarCardViewKt$QQStrangerPASimpleBarCardView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQStrangerPASimpleBarCardViewKt.QQStrangerPASimpleBarCardView(o35.i.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
