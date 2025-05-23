package com.tencent.hippykotlin.demo.pages.nearby.public_account.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.modifer_ext.ModifierExtKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.public_account.vm.QQStrangerPAInteractCardVM;
import com.tencent.hippykotlin.demo.pages.nearby.public_account.vm.QQStrangerPublicAccountViewModel;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.t;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.foundation.lazy.layout.LazyDslKt;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.LazyRowKt;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.ai;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.ntcompose.ui.platform.CompositionLocalsKt;
import com.tencent.ntcompose.ui.platform.a;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import o35.f;
import o35.g;

/* loaded from: classes31.dex */
public final class QQStrangerPAInteractCardViewKt {
    public static final void doReportInteraction(int i3, QQStrangerPAInteractCardVM qQStrangerPAInteractCardVM, boolean z16) {
        String str;
        if (z16) {
            str = "dt_imp";
        } else {
            str = "dt_clck";
        }
        e dtReportBaseParams = qQStrangerPAInteractCardVM.mainVM.getDtReportBaseParams();
        dtReportBaseParams.v("dt_eid", "em_nearby_kl_interact_card");
        dtReportBaseParams.t("nearby_kl_interaction_type", i3);
        dtReportBaseParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent(str, dtReportBaseParams);
    }

    public static final void access$ButtonView(final QQStrangerPAInteractCardVM qQStrangerPAInteractCardVM, final f fVar, final QQStrangerPublicAccountViewModel qQStrangerPublicAccountViewModel, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(302980326);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(302980326, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.public_account.view.ButtonView (QQStrangerPAInteractCardView.kt:248)");
        }
        i iVar = i.INSTANCE;
        i j3 = ModifiersKt.j(ModifiersKt.d(ComposeLayoutPropUpdaterKt.v(iVar, 74.0f, 29.0f), QUIToken.color$default("button_bg_primary_default")), 4.0f);
        if (!qQStrangerPAInteractCardVM.isFromCache) {
            iVar = ModifierExtKt.elementVR(iVar, "em_nearby_kl_go_home_btn", qQStrangerPublicAccountViewModel.getDtReportBaseParams());
        }
        BoxKt.a(j3.b(ViewEventPropUpdaterKt.d(iVar, false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPAInteractCardViewKt$ButtonView$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ClickParams clickParams) {
                String str;
                f fVar2 = f.this;
                if (fVar2 != null && (str = fVar2.f421902h) != null) {
                    QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                    QQKuiklyPlatformApi.Companion.openPage$default(str, false, 6);
                }
                return Unit.INSTANCE;
            }
        }, 3, null)), Alignment.Center, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1835351444, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPAInteractCardViewKt$ButtonView$2
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
                        ComposerKt.traceEventStart(-1835351444, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.public_account.view.ButtonView.<anonymous> (QQStrangerPAInteractCardView.kt:259)");
                    }
                    f fVar2 = f.this;
                    TextKt.a(fVar2 != null ? fVar2.f421901f : null, null, null, QUIToken.color$default("button_text_primary_default"), Float.valueOf(14.0f), null, c.INSTANCE.e(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, 1601536, 0, 0, 134217638);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 3128, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPAInteractCardViewKt$ButtonView$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQStrangerPAInteractCardViewKt.access$ButtonView(QQStrangerPAInteractCardVM.this, fVar, qQStrangerPublicAccountViewModel, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void QQStrangerPAInteractCardView(final QQStrangerPAInteractCardVM qQStrangerPAInteractCardVM, i iVar, final int i3, final f fVar, final QQStrangerPublicAccountViewModel qQStrangerPublicAccountViewModel, Composer composer, final int i16, final int i17) {
        Composer startRestartGroup = composer.startRestartGroup(-641818343);
        i iVar2 = (i17 & 2) != 0 ? i.INSTANCE : iVar;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-641818343, i16, -1, "com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPAInteractCardView (QQStrangerPAInteractCardView.kt:52)");
        }
        ColumnKt.a(ComposeLayoutPropUpdaterKt.z(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, ((a) startRestartGroup.consume(CompositionLocalsKt.d())).e())), null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 690353730, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPAInteractCardViewKt$QQStrangerPAInteractCardView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(d dVar, Composer composer2, Integer num) {
                List<g> list;
                List<g> list2;
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(690353730, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPAInteractCardView.<anonymous> (QQStrangerPAInteractCardView.kt:61)");
                    }
                    i.Companion companion = i.INSTANCE;
                    i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null), 66.0f), 16.0f, 10.0f, 16.0f, 0.0f, 8, null);
                    a.e b16 = com.tencent.ntcompose.foundation.layout.base.a.f339245a.b();
                    Alignment.Vertical a16 = Alignment.INSTANCE.a();
                    final f fVar2 = f.this;
                    final QQStrangerPAInteractCardVM qQStrangerPAInteractCardVM2 = qQStrangerPAInteractCardVM;
                    final QQStrangerPublicAccountViewModel qQStrangerPublicAccountViewModel2 = qQStrangerPublicAccountViewModel;
                    final int i18 = i16;
                    RowKt.a(n3, b16, a16, null, null, ComposableLambdaKt.composableLambda(composer3, 2136604768, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPAInteractCardViewKt$QQStrangerPAInteractCardView$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(n nVar, Composer composer4, Integer num2) {
                            int i19;
                            String str;
                            n nVar2 = nVar;
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 14) == 0) {
                                i19 = (composer5.changed(nVar2) ? 4 : 2) | intValue2;
                            } else {
                                i19 = intValue2;
                            }
                            if ((i19 & 91) == 18 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(2136604768, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPAInteractCardView.<anonymous>.<anonymous> (QQStrangerPAInteractCardView.kt:68)");
                                }
                                i p16 = ComposeLayoutPropUpdaterKt.p(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 0.0f, 3.0f, 1, null);
                                f fVar3 = f.this;
                                if (fVar3 != null) {
                                    int i26 = (int) fVar3.f421900e;
                                    if (i26 <= 999) {
                                        try {
                                            str = String.valueOf(i26);
                                        } catch (Throwable th5) {
                                            System.out.println((Object) ("formatToDisplay error: " + th5));
                                            str = "";
                                        }
                                    } else {
                                        str = "999+";
                                    }
                                } else {
                                    str = null;
                                }
                                c.Companion companion2 = c.INSTANCE;
                                c h16 = companion2.h();
                                ai.Companion companion3 = ai.INSTANCE;
                                TextKt.a(str, p16, null, QUIToken.color$default("text_primary"), Float.valueOf(56.0f), null, h16, new com.tencent.ntcompose.material.n("DIN-NextLT-Pro-QQ"), null, null, ai.f(companion3.b()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer5, (com.tencent.ntcompose.material.n.f339436b << 21) | 1601600, 0, 0, 134216484);
                                i.Companion companion4 = i.INSTANCE;
                                TextKt.a("\u4eba", ComposeLayoutPropUpdaterKt.p(ComposeLayoutPropUpdaterKt.j(companion4, 0.0f, 1, null), 0.0f, 2.0f, 1, null), null, QUIToken.color$default("text_primary"), Float.valueOf(20.0f), null, companion2.f(), null, null, null, ai.f(companion3.b()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer5, 1601606, 0, 0, 134216612);
                                i n16 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.j(companion4, 0.0f, 1, null), 2.0f, 0.0f, 0.0f, 0.0f, 14, null);
                                f fVar4 = f.this;
                                TextKt.a(fVar4 != null ? fVar4.f421903i : null, n16, null, QUIToken.color$default("text_primary"), Float.valueOf(14.0f), null, companion2.f(), null, null, null, ai.f(companion3.d()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer5, 1601600, 0, 0, 134216612);
                                SpacerKt.a(nVar2.a(ComposeLayoutPropUpdaterKt.B(companion4), 1.0f), composer5, 8, 0);
                                QQStrangerPAInteractCardViewKt.access$ButtonView(qQStrangerPAInteractCardVM2, f.this, qQStrangerPublicAccountViewModel2, composer5, (i18 & 14) | PlayerResources.ViewId.CANVAS_VIDEO_TOTAL_TRAFFIC_TEXT);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 196680, 24);
                    KLog kLog = KLog.INSTANCE;
                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("interactCard users size = ");
                    f fVar3 = f.this;
                    m3.append((fVar3 == null || (list2 = fVar3.f421899d) == null) ? null : Integer.valueOf(list2.size()));
                    m3.append(", button jumpUrl = ");
                    f fVar4 = f.this;
                    AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(m3, fVar4 != null ? fVar4.f421902h : null, kLog, "QQStrangerPAInteractCardView");
                    f fVar5 = f.this;
                    if ((fVar5 == null || (list = fVar5.f421899d) == null || !(list.isEmpty() ^ true)) ? false : true) {
                        composer3.startReplaceableGroup(1212853468);
                        QQStrangerPAInteractCardVM qQStrangerPAInteractCardVM3 = qQStrangerPAInteractCardVM;
                        f fVar6 = f.this;
                        List<g> list3 = fVar6.f421899d;
                        int i19 = i3;
                        String str = fVar6.f421902h;
                        int i26 = i16;
                        QQStrangerPAInteractCardViewKt.access$UserScrollableList(qQStrangerPAInteractCardVM3, list3, i19, str, composer3, (i26 & 14) | 64 | (i26 & 896), 0);
                        composer3.endReplaceableGroup();
                    } else {
                        composer3.startReplaceableGroup(1212853573);
                        SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion, 30.0f), composer3, 8, 0);
                        composer3.endReplaceableGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 24584, 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final i iVar3 = iVar2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPAInteractCardViewKt$QQStrangerPAInteractCardView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQStrangerPAInteractCardViewKt.QQStrangerPAInteractCardView(QQStrangerPAInteractCardVM.this, iVar3, i3, fVar, qQStrangerPublicAccountViewModel, composer2, i16 | 1, i17);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void access$UserScrollableList(final QQStrangerPAInteractCardVM qQStrangerPAInteractCardVM, final List list, final int i3, String str, Composer composer, final int i16, final int i17) {
        Composer startRestartGroup = composer.startRestartGroup(1361485485);
        final String str2 = (i17 & 8) != 0 ? "" : str;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1361485485, i16, -1, "com.tencent.hippykotlin.demo.pages.nearby.public_account.view.UserScrollableList (QQStrangerPAInteractCardView.kt:113)");
        }
        LazyRowKt.a(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 0.0f, 4.0f, 0.0f, 0.0f, 13, null), 120.0f), null, null, null, null, null, null, Boolean.FALSE, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 2065769028, true, new Function3<com.tencent.ntcompose.foundation.lazy.layout.a, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPAInteractCardViewKt$UserScrollableList$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(com.tencent.ntcompose.foundation.lazy.layout.a aVar, Composer composer2, Integer num) {
                com.tencent.ntcompose.foundation.lazy.layout.a aVar2 = aVar;
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2065769028, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.public_account.view.UserScrollableList.<anonymous> (QQStrangerPAInteractCardView.kt:119)");
                }
                LazyDslKt.b(aVar2, list, null, ComposableLambdaKt.composableLambda(composer3, -684954696, true, new Function3<g, Composer, Integer, Unit>(i16) { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPAInteractCardViewKt$UserScrollableList$1.1
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public final Unit invoke(g gVar, Composer composer4, Integer num2) {
                        String decodeToString;
                        List listOf;
                        boolean contains$default;
                        final g gVar2 = gVar;
                        Composer composer5 = composer4;
                        int intValue2 = num2.intValue();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-684954696, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.public_account.view.UserScrollableList.<anonymous>.<anonymous> (QQStrangerPAInteractCardView.kt:120)");
                        }
                        decodeToString = StringsKt__StringsJVMKt.decodeToString(gVar2.f421907h.f30291a);
                        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"\u4e92\u52a8", "\u5173\u6ce8", "\u8d5e\u4e86", "\u8bc4\u8bba", "\u56de\u6233", "\u56de\u590d", "\u6233\u4e86\u6233"});
                        Iterator it = listOf.iterator();
                        final int i18 = 0;
                        int i19 = 0;
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            i19++;
                            contains$default = StringsKt__StringsKt.contains$default((CharSequence) decodeToString, (CharSequence) it.next(), false, 2, (Object) null);
                            if (contains$default) {
                                i18 = i19;
                                break;
                            }
                        }
                        i iVar = i.INSTANCE;
                        i n3 = ComposeLayoutPropUpdaterKt.n(iVar, 16.0f, 0.0f, 8.0f, 0.0f, 10, null);
                        if (!QQStrangerPAInteractCardVM.this.isFromCache) {
                            Integer valueOf = Integer.valueOf(i18);
                            final QQStrangerPAInteractCardVM qQStrangerPAInteractCardVM2 = QQStrangerPAInteractCardVM.this;
                            composer5.startReplaceableGroup(511388516);
                            boolean changed = composer5.changed(valueOf) | composer5.changed(qQStrangerPAInteractCardVM2);
                            Object rememberedValue = composer5.rememberedValue();
                            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                rememberedValue = new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPAInteractCardViewKt$UserScrollableList$1$1$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Object obj) {
                                        QQStrangerPAInteractCardViewKt.doReportInteraction(i18, qQStrangerPAInteractCardVM2, true);
                                        return Unit.INSTANCE;
                                    }
                                };
                                composer5.updateRememberedValue(rememberedValue);
                            }
                            composer5.endReplaceableGroup();
                            iVar = ViewEventPropUpdaterKt.r(iVar, (Function1) rememberedValue);
                        }
                        i b16 = n3.b(iVar);
                        Alignment alignment = Alignment.TopCenter;
                        final QQStrangerPAInteractCardVM qQStrangerPAInteractCardVM3 = QQStrangerPAInteractCardVM.this;
                        BoxKt.a(b16, alignment, null, ComposableLambdaKt.composableLambda(composer5, -438647310, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPAInteractCardViewKt.UserScrollableList.1.1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(b bVar, Composer composer6, Integer num3) {
                                Composer composer7 = composer6;
                                int intValue3 = num3.intValue();
                                if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                    composer7.skipToGroupEnd();
                                } else {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-438647310, intValue3, -1, "com.tencent.hippykotlin.demo.pages.nearby.public_account.view.UserScrollableList.<anonymous>.<anonymous>.<anonymous> (QQStrangerPAInteractCardView.kt:129)");
                                    }
                                    i.Companion companion = i.INSTANCE;
                                    float f16 = 54;
                                    i n16 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.v(companion, f16, f16), 0.0f, 35.0f, 0.0f, 0.0f, 13, null);
                                    Alignment alignment2 = Alignment.BottomEnd;
                                    final g gVar3 = g.this;
                                    final int i26 = i18;
                                    final QQStrangerPAInteractCardVM qQStrangerPAInteractCardVM4 = qQStrangerPAInteractCardVM3;
                                    BoxKt.a(n16, alignment2, null, ComposableLambdaKt.composableLambda(composer7, 52972204, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPAInteractCardViewKt.UserScrollableList.1.1.2.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public final Unit invoke(b bVar2, Composer composer8, Integer num4) {
                                            Composer composer9 = composer8;
                                            int intValue4 = num4.intValue();
                                            if ((intValue4 & 81) == 16 && composer9.getSkipping()) {
                                                composer9.skipToGroupEnd();
                                            } else {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(52972204, intValue4, -1, "com.tencent.hippykotlin.demo.pages.nearby.public_account.view.UserScrollableList.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QQStrangerPAInteractCardView.kt:134)");
                                                }
                                                float f17 = 54;
                                                i v3 = ComposeLayoutPropUpdaterKt.v(i.INSTANCE, f17, f17);
                                                final g gVar4 = g.this;
                                                final int i27 = i26;
                                                final QQStrangerPAInteractCardVM qQStrangerPAInteractCardVM5 = qQStrangerPAInteractCardVM4;
                                                ImageKt.a(g.this.f421906f, null, null, null, null, ModifiersKt.j(ViewEventPropUpdaterKt.d(v3, false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPAInteractCardViewKt.UserScrollableList.1.1.2.1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        String str3 = g.this.C;
                                                        QQKuiklyPlatformApi.Companion companion2 = QQKuiklyPlatformApi.Companion;
                                                        QQKuiklyPlatformApi.Companion.openPage$default(str3, false, 6);
                                                        QQStrangerPAInteractCardViewKt.doReportInteraction(i27, qQStrangerPAInteractCardVM5, false);
                                                        return Unit.INSTANCE;
                                                    }
                                                }, 3, null), 27), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer9, 262144, 0, 0, 2097118);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer7, 3128, 4);
                                    i n17 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.A(companion), 0.0f, 15.0f, 0.0f, 0.0f, 13, null);
                                    final g gVar4 = g.this;
                                    final int i27 = i18;
                                    final QQStrangerPAInteractCardVM qQStrangerPAInteractCardVM5 = qQStrangerPAInteractCardVM3;
                                    i d16 = ViewEventPropUpdaterKt.d(n17, false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPAInteractCardViewKt.UserScrollableList.1.1.2.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ClickParams clickParams) {
                                            String str3 = g.this.C;
                                            QQKuiklyPlatformApi.Companion companion2 = QQKuiklyPlatformApi.Companion;
                                            QQKuiklyPlatformApi.Companion.openPage$default(str3, false, 6);
                                            QQStrangerPAInteractCardViewKt.doReportInteraction(i27, qQStrangerPAInteractCardVM5, false);
                                            return Unit.INSTANCE;
                                        }
                                    }, 3, null);
                                    Alignment alignment3 = Alignment.Center;
                                    final g gVar5 = g.this;
                                    BoxKt.a(d16, alignment3, null, ComposableLambdaKt.composableLambda(composer7, -45590315, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPAInteractCardViewKt.UserScrollableList.1.1.2.3
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public final Unit invoke(b bVar2, Composer composer8, Integer num4) {
                                            int i28;
                                            b bVar3 = bVar2;
                                            Composer composer9 = composer8;
                                            int intValue4 = num4.intValue();
                                            if ((intValue4 & 14) == 0) {
                                                i28 = (composer9.changed(bVar3) ? 4 : 2) | intValue4;
                                            } else {
                                                i28 = intValue4;
                                            }
                                            if ((i28 & 91) == 18 && composer9.getSkipping()) {
                                                composer9.skipToGroupEnd();
                                            } else {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-45590315, intValue4, -1, "com.tencent.hippykotlin.demo.pages.nearby.public_account.view.UserScrollableList.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QQStrangerPAInteractCardView.kt:161)");
                                                }
                                                i.Companion companion2 = i.INSTANCE;
                                                BoxKt.a(bVar3.a(ModifiersKt.d(ComposeLayoutPropUpdaterKt.p(ModifiersKt.O(ComposeLayoutPropUpdaterKt.v(companion2, 14.0f, 14.0f), new t(45.0f, 0.0f, 0.0f, 6, null), null, null, null, null, 30, null), 0.0f, 2.0f, 1, null), QUIToken.color$default("fill_light_primary")), Alignment.BottomCenter), null, null, null, composer9, 8, 14);
                                                i j3 = ModifiersKt.j(ModifiersKt.d(ComposeLayoutPropUpdaterKt.r(ComposeLayoutPropUpdaterKt.B(companion2), 8.0f, 6.5f, 8.0f, 6.5f), QUIToken.color$default("fill_light_primary")), 6);
                                                Alignment alignment4 = Alignment.Center;
                                                final g gVar6 = g.this;
                                                BoxKt.a(j3, alignment4, null, ComposableLambdaKt.composableLambda(composer9, -1215465032, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPAInteractCardViewKt.UserScrollableList.1.1.2.3.1
                                                    {
                                                        super(3);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function3
                                                    public final Unit invoke(b bVar4, Composer composer10, Integer num5) {
                                                        String decodeToString2;
                                                        Composer composer11 = composer10;
                                                        int intValue5 = num5.intValue();
                                                        if ((intValue5 & 81) == 16 && composer11.getSkipping()) {
                                                            composer11.skipToGroupEnd();
                                                        } else {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-1215465032, intValue5, -1, "com.tencent.hippykotlin.demo.pages.nearby.public_account.view.UserScrollableList.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QQStrangerPAInteractCardView.kt:178)");
                                                            }
                                                            i y16 = ComposeLayoutPropUpdaterKt.y(ComposeLayoutPropUpdaterKt.B(i.INSTANCE), 0.0f, 55.0f, 1, null);
                                                            decodeToString2 = StringsKt__StringsJVMKt.decodeToString(g.this.f421907h.f30291a);
                                                            c e16 = c.INSTANCE.e();
                                                            TextKt.a(decodeToString2, y16, null, QUIToken.color$default("text_primary"), Float.valueOf(11.0f), null, e16, null, null, null, ai.f(ai.INSTANCE.a()), Float.valueOf(14.0f), null, null, null, null, null, null, 2, null, null, null, null, null, null, null, false, composer11, 1601600, 100663344, 0, 133952420);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                }), composer9, 3128, 4);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer7, 3128, 4);
                                    i w3 = ComposeLayoutPropUpdaterKt.w(ComposeLayoutPropUpdaterKt.n(companion, 0.0f, 94.0f, 0.0f, 0.0f, 13, null), 65.0f);
                                    TextKt.a(g.this.f421905e, w3, null, QUIToken.color$default("text_secondary"), Float.valueOf(10.0f), null, c.INSTANCE.e(), null, null, null, ai.f(ai.INSTANCE.a()), null, null, null, null, null, null, null, 1, null, null, null, null, null, null, null, false, composer7, 1601600, 100663296, 0, 133954468);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer5, 3128, 4);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        return Unit.INSTANCE;
                    }
                }), composer3, 3144, 2);
                if (list.size() > 9) {
                    i n3 = ComposeLayoutPropUpdaterKt.n(i.INSTANCE, 16.0f, 0.0f, 16.0f, 0.0f, 10, null);
                    Alignment alignment = Alignment.TopCenter;
                    final List<g> list2 = list;
                    BoxKt.a(n3, alignment, null, ComposableLambdaKt.composableLambda(composer3, -285926107, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPAInteractCardViewKt$UserScrollableList$1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                    ComposerKt.traceEventStart(-285926107, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.public_account.view.UserScrollableList.<anonymous>.<anonymous> (QQStrangerPAInteractCardView.kt:210)");
                                }
                                i.Companion companion = i.INSTANCE;
                                float f16 = 54;
                                i d16 = ModifiersKt.d(ModifiersKt.j(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.v(companion, f16, f16), 0.0f, 35.0f, 0.0f, 0.0f, 13, null), 27), QUIToken.color$default("fill_light_primary"));
                                final List<g> list3 = list2;
                                BoxKt.a(ViewEventPropUpdaterKt.d(d16, false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPAInteractCardViewKt.UserScrollableList.1.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        Object firstOrNull;
                                        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list3);
                                        g gVar = (g) firstOrNull;
                                        String str3 = gVar != null ? gVar.C : null;
                                        if (str3 != null) {
                                            QQKuiklyPlatformApi.Companion companion2 = QQKuiklyPlatformApi.Companion;
                                            QQKuiklyPlatformApi.Companion.openPage$default(str3, false, 6);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }, 3, null), Alignment.Center, null, ComposableSingletons$QQStrangerPAInteractCardViewKt.f89lambda1, composer5, 3128, 4);
                                TextKt.a("\u67e5\u770b\u66f4\u591a", ComposeLayoutPropUpdaterKt.n(companion, 0.0f, 94.0f, 0.0f, 0.0f, 13, null), null, QUIToken.color$default("text_secondary"), Float.valueOf(10.0f), null, c.INSTANCE.e(), null, null, null, ai.f(ai.INSTANCE.a()), null, null, null, null, null, null, null, 1, null, null, null, null, null, null, null, false, composer5, 1601606, 100663296, 0, 133954468);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 3128, 4);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 12582920, 0, MsgConstant.KRMFILETHUMBSIZE384, 4194174);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPAInteractCardViewKt$UserScrollableList$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQStrangerPAInteractCardViewKt.access$UserScrollableList(QQStrangerPAInteractCardVM.this, list, i3, str2, composer2, i16 | 1, i17);
                return Unit.INSTANCE;
            }
        });
    }
}
