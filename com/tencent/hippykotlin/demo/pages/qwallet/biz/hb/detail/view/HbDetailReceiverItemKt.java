package com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.base.QUISkinImage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.QQComposeViewExtCreator$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.compose_ui.view.adelie.QQAvatarViewKt;
import com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.Mqq;
import com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.MqqUi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.data.HbDetailStartupData;
import com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.data.HbReceiver;
import com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.data.HbSender;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.e;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.manager.c;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.ai;
import com.tencent.ntcompose.material.an;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.ntcompose.material.n;
import defpackage.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class HbDetailReceiverItemKt {
    public static final void HbDetailReceiverItem(final HbReceiver hbReceiver, final HbSender hbSender, final HbDetailStartupData hbDetailStartupData, final int i3, Composer composer, final int i16) {
        Composer startRestartGroup = composer.startRestartGroup(-1326511160);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1326511160, i16, -1, "com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailReceiverItem (HbDetailReceiverItem.kt:42)");
        }
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue = startRestartGroup.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
            if (k.a(c.f117352a)) {
                rememberedValue = new n("DIN-NextLT-Pro-Medium");
            } else {
                rememberedValue = new n("DINNextLTPro-Bold");
            }
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        final n nVar = (n) rememberedValue;
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == companion.getEmpty()) {
            if (QUIToken.INSTANCE.isNightMode()) {
                rememberedValue2 = new h(4280821800L);
            } else {
                rememberedValue2 = new h(4294243572L);
            }
            startRestartGroup.updateRememberedValue(rememberedValue2);
        }
        startRestartGroup.endReplaceableGroup();
        h hVar = (h) rememberedValue2;
        float f16 = 4.0f;
        float f17 = (i3 == 1 || i3 == 4) ? 4.0f : 0.0f;
        float f18 = (i3 == 1 || i3 == 4) ? 4.0f : 0.0f;
        float f19 = (i3 == 3 || i3 == 4) ? 4.0f : 0.0f;
        if (i3 != 3 && i3 != 4) {
            f16 = 0.0f;
        }
        RowKt.a(ViewEventPropUpdaterKt.d(ComposeLayoutPropUpdaterKt.s(ModifiersKt.k(ModifiersKt.d(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 76.0f), hVar), f17, f18, f19, f16), 16.0f, 0.0f, 14.0f, 0.0f, 10, null), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailReceiverItemKt$HbDetailReceiverItem$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ClickParams clickParams) {
                String m3;
                String str = HbReceiver.this.recvUin;
                HbSender hbSender2 = hbSender;
                int i17 = hbSender2 != null ? hbSender2.channel : 0;
                boolean z16 = i17 == 5 || i17 == 16;
                HbDetailStartupData hbDetailStartupData2 = hbDetailStartupData;
                String str2 = hbDetailStartupData2 != null ? hbDetailStartupData2.groupId : null;
                if (str != null) {
                    if (z16) {
                        m3 = QQComposeViewExtCreator$$ExternalSyntheticOutline0.m("mqqapi://nearby_entry/nearby_profile?src_type=web&version=1&from=10003&from_type=0&uin=", str, "&mode=3");
                    } else {
                        if (!(str2 == null || str2.length() == 0)) {
                            m3 = QUISkinImage$$ExternalSyntheticOutline0.m("mqqapi://card/show_pslcard?src_type=internal&version=1&card_type=troopmemberfromhb&uin=", str, "&troopuin=", str2);
                        } else {
                            m3 = QQComposeViewExtCreator$$ExternalSyntheticOutline0.m("mqqapi://card/show_pslcard?src_type=internal&uin=", str, "&version=1");
                        }
                    }
                    MqqUi.openUrl$default(Mqq.INSTANCE.getUi(), m3);
                }
                return Unit.INSTANCE;
            }
        }, 3, null), null, Alignment.INSTANCE.c(), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1680170474, true, new Function3<com.tencent.ntcompose.foundation.layout.n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailReceiverItemKt$HbDetailReceiverItem$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(com.tencent.ntcompose.foundation.layout.n nVar2, Composer composer2, Integer num) {
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1680170474, intValue, -1, "com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailReceiverItem.<anonymous> (HbDetailReceiverItem.kt:88)");
                    }
                    i.Companion companion2 = i.INSTANCE;
                    i d16 = ModifiersKt.d(ModifiersKt.g(ModifiersKt.j(ComposeLayoutPropUpdaterKt.u(companion2, 46.0f), 23.0f), new e(0.5f, BorderStyle.SOLID, QUIToken.color$default("border_superlight"))), QUIToken.color$default("overlay_standard_secondary"));
                    String str = HbReceiver.this.recvUin;
                    if (str == null) {
                        str = "";
                    }
                    QQAvatarViewKt.QQAvatarView(d16, null, str, composer3, 8, 2);
                    i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.z(ComposeLayoutPropUpdaterKt.j(companion2, 0.0f, 1, null)), 12.0f, 0.0f, 0.0f, 0.0f, 14, null);
                    a.e b16 = a.f339245a.b();
                    final HbReceiver hbReceiver2 = HbReceiver.this;
                    final n nVar3 = nVar;
                    ColumnKt.a(n3, b16, null, null, ComposableLambdaKt.composableLambda(composer3, 27831777, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailReceiverItemKt$HbDetailReceiverItem$2.1
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
                                    ComposerKt.traceEventStart(27831777, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailReceiverItem.<anonymous>.<anonymous> (HbDetailReceiverItem.kt:102)");
                                }
                                i.Companion companion3 = i.INSTANCE;
                                i z16 = ComposeLayoutPropUpdaterKt.z(ComposeLayoutPropUpdaterKt.j(companion3, 0.0f, 1, null));
                                Alignment.Companion companion4 = Alignment.INSTANCE;
                                Alignment.Vertical c16 = companion4.c();
                                final HbReceiver hbReceiver3 = HbReceiver.this;
                                final n nVar4 = nVar3;
                                RowKt.a(z16, null, c16, null, null, ComposableLambdaKt.composableLambda(composer5, 1911940995, true, new Function3<com.tencent.ntcompose.foundation.layout.n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailReceiverItemKt.HbDetailReceiverItem.2.1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(com.tencent.ntcompose.foundation.layout.n nVar5, Composer composer6, Integer num3) {
                                        int i17;
                                        com.tencent.ntcompose.foundation.layout.n nVar6 = nVar5;
                                        Composer composer7 = composer6;
                                        int intValue3 = num3.intValue();
                                        if ((intValue3 & 14) == 0) {
                                            i17 = (composer7.changed(nVar6) ? 4 : 2) | intValue3;
                                        } else {
                                            i17 = intValue3;
                                        }
                                        if ((i17 & 91) == 18 && composer7.getSkipping()) {
                                            composer7.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1911940995, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailReceiverItem.<anonymous>.<anonymous>.<anonymous> (HbDetailReceiverItem.kt:107)");
                                            }
                                            i.Companion companion5 = i.INSTANCE;
                                            TextKt.a(HbReceiver.this.recvName.getValue(), nVar6.a(ComposeLayoutPropUpdaterKt.A(companion5), 1.0f), null, QUIToken.color$default("text_primary"), Float.valueOf(17.0f), null, null, null, null, null, null, null, null, null, null, null, an.d(an.INSTANCE.b()), null, 1, null, null, null, null, null, null, null, false, composer7, 28736, 102236160, 0, 133890020);
                                            i n16 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.A(companion5), 12.0f, 0.0f, 0.0f, 0.0f, 14, null);
                                            StringBuilder sb5 = new StringBuilder();
                                            sb5.append(HbReceiver.this.amount / 100.0f);
                                            sb5.append('\u5143');
                                            TextKt.a(sb5.toString(), n16, null, QUIToken.color$default("text_primary"), Float.valueOf(14.0f), null, null, nVar4, null, null, ai.f(ai.INSTANCE.b()), null, null, null, null, null, null, null, 1, null, null, null, null, null, null, null, false, composer7, (n.f339436b << 21) | 28736, 100663296, 0, 133954404);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer5, 196616, 26);
                                i n16 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.z(ComposeLayoutPropUpdaterKt.j(companion3, 0.0f, 1, null)), 0.0f, 3.0f, 0.0f, 0.0f, 13, null);
                                Alignment.Vertical c17 = companion4.c();
                                final HbReceiver hbReceiver4 = HbReceiver.this;
                                RowKt.a(n16, null, c17, null, null, ComposableLambdaKt.composableLambda(composer5, 1722790266, true, new Function3<com.tencent.ntcompose.foundation.layout.n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailReceiverItemKt.HbDetailReceiverItem.2.1.2
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(com.tencent.ntcompose.foundation.layout.n nVar5, Composer composer6, Integer num3) {
                                        int i17;
                                        String str2;
                                        com.tencent.ntcompose.foundation.layout.n nVar6 = nVar5;
                                        Composer composer7 = composer6;
                                        int intValue3 = num3.intValue();
                                        if ((intValue3 & 14) == 0) {
                                            i17 = (composer7.changed(nVar6) ? 4 : 2) | intValue3;
                                        } else {
                                            i17 = intValue3;
                                        }
                                        if ((i17 & 91) == 18 && composer7.getSkipping()) {
                                            composer7.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1722790266, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailReceiverItem.<anonymous>.<anonymous>.<anonymous> (HbDetailReceiverItem.kt:130)");
                                            }
                                            i.Companion companion5 = i.INSTANCE;
                                            TextKt.a(HbReceiver.this.createTime, nVar6.a(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.A(companion5), 0.0f, 5.0f, 0.0f, 0.0f, 13, null), 1.0f), null, QUIToken.color$default("text_secondary"), Float.valueOf(14.0f), null, null, null, null, null, null, null, null, null, null, null, an.d(an.INSTANCE.b()), null, 1, null, null, null, null, null, null, null, false, composer7, 28736, 102236160, 0, 133890020);
                                            i n17 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.A(companion5), 12.0f, 0.0f, 0.0f, 0.0f, 14, null);
                                            if (HbReceiver.this.isLuck) {
                                                str2 = "\u624b\u6c14\u6700\u4f73";
                                            } else {
                                                str2 = "";
                                            }
                                            TextKt.a(str2, n17, null, new h(4292057401L), Float.valueOf(14.0f), null, null, null, null, null, ai.f(ai.INSTANCE.b()), null, null, null, null, null, null, null, 1, null, null, null, null, null, null, null, false, composer7, 28736, 100663296, 0, 133954532);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer5, 196616, 26);
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
        }), startRestartGroup, 196616, 26);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailReceiverItemKt$HbDetailReceiverItem$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                HbDetailReceiverItemKt.HbDetailReceiverItem(HbReceiver.this, hbSender, hbDetailStartupData, i3, composer2, i16 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
