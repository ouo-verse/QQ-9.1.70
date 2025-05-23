package com.tencent.hippykotlin.demo.pages.nearby.public_account.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.c;
import bp3.k;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QQAnimatedImageKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView$body$1$1$3$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.public_account.vm.QQStrangerPAEntranceCardVM;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import o35.b;

/* loaded from: classes31.dex */
public final class QQStrangerPAEntranceCardViewKt {
    public static final void doReportEntrance(String str, QQStrangerPAEntranceCardVM qQStrangerPAEntranceCardVM, boolean z16) {
        String str2;
        if (z16) {
            str2 = "dt_imp";
        } else {
            str2 = "dt_clck";
        }
        e dtReportBaseParams = qQStrangerPAEntranceCardVM.mainVM.getDtReportBaseParams();
        dtReportBaseParams.v("dt_eid", "em_nearby_kl_entrance_card");
        dtReportBaseParams.v("nearby_kl_function_name", str);
        dtReportBaseParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent(str2, dtReportBaseParams);
    }

    public static final void QQStrangerPAEntranceCardView(final QQStrangerPAEntranceCardVM qQStrangerPAEntranceCardVM, i iVar, final b bVar, final QQStrangerPAEntranceCardVM qQStrangerPAEntranceCardVM2, Composer composer, final int i3, final int i16) {
        i r16;
        Composer startRestartGroup = composer.startRestartGroup(-446676636);
        if ((i16 & 2) != 0) {
            iVar = i.INSTANCE;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-446676636, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPAEntranceCardView (QQStrangerPAEntranceCardView.kt:28)");
        }
        c cVar = c.f117352a;
        cVar.g().getPageData().m();
        float f16 = 2;
        i c16 = ModifiersKt.c(ModifiersKt.j(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(iVar, ((GoodsCenterProductView$body$1$1$3$$ExternalSyntheticOutline0.m(cVar) - (f16 * 6.0f)) - 6.0f) / f16), 108.0f), 8.0f), QUIToken.color$default("fill_standard_primary"));
        if (qQStrangerPAEntranceCardVM.isFromCache) {
            r16 = i.INSTANCE;
        } else {
            r16 = ViewEventPropUpdaterKt.r(i.INSTANCE, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPAEntranceCardViewKt$QQStrangerPAEntranceCardView$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object obj) {
                    String str;
                    b bVar2 = b.this;
                    if (bVar2 == null || (str = bVar2.f421880d) == null) {
                        str = "";
                    }
                    QQStrangerPAEntranceCardViewKt.doReportEntrance(str, qQStrangerPAEntranceCardVM, true);
                    return Unit.INSTANCE;
                }
            });
        }
        BoxKt.a(ViewEventPropUpdaterKt.d(c16.b(r16), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPAEntranceCardViewKt$QQStrangerPAEntranceCardView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ClickParams clickParams) {
                String str;
                String str2;
                b bVar2 = b.this;
                if (bVar2 != null && (str2 = bVar2.f421883h) != null) {
                    QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                    QQKuiklyPlatformApi.Companion.openPage$default(str2, false, 6);
                }
                b bVar3 = b.this;
                if (bVar3 == null || (str = bVar3.f421880d) == null) {
                    str = "";
                }
                QQStrangerPAEntranceCardViewKt.doReportEntrance(str, qQStrangerPAEntranceCardVM, false);
                return Unit.INSTANCE;
            }
        }, 3, null), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1425894302, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPAEntranceCardViewKt$QQStrangerPAEntranceCardView$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar2, Composer composer2, Integer num) {
                int i17;
                i.Companion companion;
                boolean z16;
                String str;
                String str2;
                o35.e eVar;
                com.tencent.ntcompose.foundation.layout.b bVar3 = bVar2;
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 14) == 0) {
                    i17 = (composer3.changed(bVar3) ? 4 : 2) | intValue;
                } else {
                    i17 = intValue;
                }
                if ((i17 & 91) == 18 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1425894302, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPAEntranceCardView.<anonymous> (QQStrangerPAEntranceCardView.kt:50)");
                    }
                    i.Companion companion2 = i.INSTANCE;
                    i h16 = ComposeLayoutPropUpdaterKt.h(companion2, 0.0f, 1, null);
                    b bVar4 = b.this;
                    ImageKt.a((bVar4 == null || (eVar = bVar4.f421881e) == null) ? null : eVar.f421896d, null, null, null, null, h16, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer3, 262144, 0, 0, 2097118);
                    i o16 = ComposeLayoutPropUpdaterKt.o(companion2, 12.0f, 12.0f);
                    b bVar5 = b.this;
                    String str3 = bVar5 != null ? bVar5.f421880d : null;
                    c.Companion companion3 = bp3.c.INSTANCE;
                    k kVar = new k(QUIToken.color$default("text_allwhite_primary"), Float.valueOf(17.0f), companion3.f(), null, null, null, null, null, null, Float.valueOf(24.0f), null, null, null, null, 15864, null);
                    int i18 = k.f28903n;
                    TextKt.a(str3, o16, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, kVar, null, null, null, null, null, false, composer3, 64, 0, i18, 133169148);
                    i D = ModifiersKt.D(ComposeLayoutPropUpdaterKt.o(companion2, 12.0f, 40.0f), 0.8f);
                    bp3.c e16 = companion3.e();
                    h color$default = QUIToken.color$default("text_allwhite_primary");
                    b bVar6 = b.this;
                    TextKt.a(bVar6 != null ? bVar6.f421885m : null, D, null, color$default, null, null, e16, null, null, null, null, null, null, null, null, null, null, null, null, null, new k(QUIToken.color$default("text_allwhite_primary"), Float.valueOf(12.0f), companion3.e(), null, null, null, null, null, null, Float.valueOf(12.0f), null, null, null, null, 15864, null), null, null, null, null, null, false, composer3, 1577024, 0, i18, 133169076);
                    composer3.startReplaceableGroup(-568491711);
                    b bVar7 = b.this;
                    String str4 = bVar7 != null ? bVar7.f421882f : null;
                    if (str4 == null || str4.length() == 0) {
                        companion = companion2;
                        z16 = true;
                    } else {
                        companion = companion2;
                        i j3 = ModifiersKt.j(ComposeLayoutPropUpdaterKt.o(ComposeLayoutPropUpdaterKt.v(companion, 56.0f, 26.0f), 12.0f, 70.0f), 4.0f);
                        Alignment alignment = Alignment.Center;
                        final b bVar8 = b.this;
                        z16 = true;
                        BoxKt.a(j3, alignment, null, ComposableLambdaKt.composableLambda(composer3, -1510207267, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPAEntranceCardViewKt$QQStrangerPAEntranceCardView$3.1
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar9, Composer composer4, Integer num2) {
                                Composer composer5 = composer4;
                                int intValue2 = num2.intValue();
                                if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                    composer5.skipToGroupEnd();
                                } else {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1510207267, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPAEntranceCardView.<anonymous>.<anonymous> (QQStrangerPAEntranceCardView.kt:77)");
                                    }
                                    i j16 = ModifiersKt.j(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), 4.0f);
                                    b bVar10 = b.this;
                                    ImageKt.a(bVar10 != null ? bVar10.f421884i : null, null, null, null, null, j16, null, com.tencent.ntcompose.material.h.INSTANCE.b(), null, null, null, null, null, null, null, null, null, null, null, null, null, composer5, 12845056, 0, 0, 2096990);
                                    b bVar11 = b.this;
                                    TextKt.a(bVar11 != null ? bVar11.f421882f : null, null, null, QUIToken.color$default("text_allwhite_primary"), Float.valueOf(10.0f), null, bp3.c.INSTANCE.f(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer5, 1601536, 0, 0, 134217638);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer3, 3128, 4);
                    }
                    composer3.endReplaceableGroup();
                    QQStrangerPAEntranceCardVM qQStrangerPAEntranceCardVM3 = qQStrangerPAEntranceCardVM2;
                    if (qQStrangerPAEntranceCardVM3.isJiShiShanLiaoCard) {
                        str = "https://downv6.qq.com/extendfriend/qqstranger_match_chat_entry_lottie_9060.json";
                    } else if (qQStrangerPAEntranceCardVM3.isYuYinLianMai) {
                        str = "https://vfiles.gtimg.cn/wuji_dashboard/xy/componenthub/xrHpSxny.png";
                    } else {
                        str = "";
                    }
                    if (str.length() > 0 ? z16 : false) {
                        QQStrangerPAEntranceCardVM qQStrangerPAEntranceCardVM4 = qQStrangerPAEntranceCardVM2;
                        if (qQStrangerPAEntranceCardVM4.isJiShiShanLiaoCard) {
                            str2 = "https://downv6.qq.com/extendfriend/qqstranger_match_chat_entry_lottie_9060.json";
                        } else if (qQStrangerPAEntranceCardVM4.isYuYinLianMai) {
                            str2 = "https://vfiles.gtimg.cn/wuji_dashboard/xy/componenthub/xrHpSxny.png";
                        } else {
                            str2 = "";
                        }
                        QQAnimatedImageKt.QQAnimatedImage(str2, bVar3.a(ComposeLayoutPropUpdaterKt.v(companion, 83.0f, 108.0f), Alignment.CenterEnd), false, null, composer3, 64, 12);
                    }
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
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final i iVar2 = iVar;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPAEntranceCardViewKt$QQStrangerPAEntranceCardView$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQStrangerPAEntranceCardViewKt.QQStrangerPAEntranceCardView(QQStrangerPAEntranceCardVM.this, iVar2, bVar, qQStrangerPAEntranceCardVM2, composer2, i3 | 1, i16);
                return Unit.INSTANCE;
            }
        });
    }
}
