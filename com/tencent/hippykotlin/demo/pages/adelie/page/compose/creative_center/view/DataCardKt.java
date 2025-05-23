package com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util.BaseKt;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util.ReportKt;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieKuiklyBaseModule;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.AdelieCreativeCenterViewModel;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.CreateCenterBanner;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.CreateCenterBannerItem;
import com.tencent.hippykotlin.demo.pages.compose_ui.view.adelie.QQAvatarViewKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.view.adelie.VerticalFlipperKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQCommonNApiModule;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
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
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.SurfaceKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.ai;
import com.tencent.ntcompose.material.an;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.ntcompose.material.n;
import com.tencent.ntcompose.ui.platform.CompositionLocalsKt;
import com.tencent.ntcompose.ui.platform.a;
import com.tencent.pts.ui.vnode.PTSNodeTextBase;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import defpackage.k;
import h25.u;
import h25.y;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class DataCardKt {
    public static final void StatItem(final long j3, final String str, Composer composer, final int i3) {
        int i16;
        Pair<String, String> pair;
        Composer startRestartGroup = composer.startRestartGroup(-49680511);
        if ((i3 & 14) == 0) {
            i16 = (startRestartGroup.changed(j3) ? 4 : 2) | i3;
        } else {
            i16 = i3;
        }
        if ((i3 & 112) == 0) {
            i16 |= startRestartGroup.changed(str) ? 32 : 16;
        }
        final int i17 = i16;
        if ((i17 & 91) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-49680511, i17, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.StatItem (DataCard.kt:289)");
            }
            if (j3 >= 0) {
                pair = BaseKt.getToChineseUnit(j3);
            } else {
                pair = new Pair<>("-", null);
            }
            final Pair<String, String> pair2 = pair;
            KLog.INSTANCE.i("", "countPair=" + pair2);
            c cVar = c.f117352a;
            float m3 = ((cVar.g().getPageData().m() - 32.0f) / 3.0f) - 21.333334f;
            startRestartGroup.startReplaceableGroup(-492369756);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                if (k.a(cVar)) {
                    rememberedValue = new n("DIN-NextLT-Pro-QQ");
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
                rememberedValue2 = Float.valueOf(k.a(cVar) ? 6.0f : 1.0f);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceableGroup();
            final float floatValue = ((Number) rememberedValue2).floatValue();
            startRestartGroup.startReplaceableGroup(-492369756);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = Float.valueOf(k.a(cVar) ? 23.0f : 26.0f);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceableGroup();
            final float floatValue2 = ((Number) rememberedValue3).floatValue();
            ColumnKt.a(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, m3), 43.0f), null, Alignment.INSTANCE.b(), null, ComposableLambdaKt.composableLambda(startRestartGroup, 341765418, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCardKt$StatItem$1
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
                            ComposerKt.traceEventStart(341765418, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.StatItem.<anonymous> (DataCard.kt:319)");
                        }
                        Alignment.Vertical a16 = Alignment.INSTANCE.a();
                        final Pair<String, String> pair3 = pair2;
                        final float f16 = floatValue2;
                        final n nVar2 = nVar;
                        RowKt.a(null, null, a16, null, null, ComposableLambdaKt.composableLambda(composer3, -426992056, true, new Function3<com.tencent.ntcompose.foundation.layout.n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCardKt$StatItem$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(com.tencent.ntcompose.foundation.layout.n nVar3, Composer composer4, Integer num2) {
                                int i18;
                                com.tencent.ntcompose.foundation.layout.n nVar4 = nVar3;
                                Composer composer5 = composer4;
                                int intValue2 = num2.intValue();
                                if ((intValue2 & 14) == 0) {
                                    i18 = (composer5.changed(nVar4) ? 4 : 2) | intValue2;
                                } else {
                                    i18 = intValue2;
                                }
                                if ((i18 & 91) == 18 && composer5.getSkipping()) {
                                    composer5.skipToGroupEnd();
                                } else {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-426992056, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.StatItem.<anonymous>.<anonymous> (DataCard.kt:322)");
                                    }
                                    i.Companion companion2 = i.INSTANCE;
                                    i k3 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion2, 0.0f, 1, null), 23.0f);
                                    Alignment.Companion companion3 = Alignment.INSTANCE;
                                    i s16 = ComposeLayoutPropUpdaterKt.s(nVar4.b(k3, companion3.a()), 0.0f, 1.0f, 0.0f, 0.0f, 13, null);
                                    String first = pair3.getFirst();
                                    h color$default = QUIToken.color$default("text_primary");
                                    c.Companion companion4 = bp3.c.INSTANCE;
                                    bp3.c e16 = companion4.e();
                                    ai.Companion companion5 = ai.INSTANCE;
                                    int a17 = companion5.a();
                                    Float valueOf = Float.valueOf(f16);
                                    n nVar5 = nVar2;
                                    ai f17 = ai.f(a17);
                                    Float valueOf2 = Float.valueOf(26.0f);
                                    int i19 = n.f339436b;
                                    TextKt.a(first, s16, null, color$default, valueOf, null, e16, nVar5, null, null, f17, valueOf2, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer5, (i19 << 21) | 1601600, 48, 0, 134214436);
                                    String second = pair3.getSecond();
                                    if (second != null) {
                                        n nVar6 = nVar2;
                                        SpacerKt.a(ComposeLayoutPropUpdaterKt.w(companion2, 1.0f), composer5, 8, 0);
                                        TextKt.a(second, nVar4.b(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion2, 0.0f, 1, null), 20.0f), companion3.a()), null, QUIToken.color$default("text_primary"), Float.valueOf(14.0f), null, companion4.h(), nVar6, null, null, ai.f(companion5.a()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer5, (i19 << 21) | 1601600, 0, 0, 134216484);
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer3, 196608, 27);
                        SpacerKt.a(ComposeLayoutPropUpdaterKt.k(i.INSTANCE, floatValue), composer3, 8, 0);
                        h color$default = QUIToken.color$default("text_secondary");
                        bp3.c e16 = bp3.c.INSTANCE.e();
                        int a17 = ai.INSTANCE.a();
                        TextKt.a(str, null, null, color$default, Float.valueOf(12.0f), null, e16, new n("PingFang SC"), null, null, ai.f(a17), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, ((i17 >> 3) & 14) | 1601536 | (n.f339436b << 21), 0, 0, 134216486);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    return Unit.INSTANCE;
                }
            }), startRestartGroup, 24584, 10);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCardKt$StatItem$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                DataCardKt.StatItem(j3, str, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v52 */
    /* JADX WARN: Type inference failed for: r0v53 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9, types: [T, java.lang.CharSequence] */
    public static final void DataCard(final AdelieCreativeCenterViewModel adelieCreativeCenterViewModel, final boolean z16, e eVar, Composer composer, final int i3, final int i16) {
        ?? r06;
        T t16;
        Composer startRestartGroup = composer.startRestartGroup(1284792848);
        final e eVar2 = (i16 & 4) != 0 ? null : eVar;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1284792848, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCard (DataCard.kt:58)");
        }
        final Ref.FloatRef floatRef = new Ref.FloatRef();
        CreateCenterBanner value = adelieCreativeCenterViewModel.bannerInfo._state.getValue();
        if (value == null) {
            value = null;
        } else if (!value.banner.isEmpty()) {
            floatRef.element = 44.0f;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        QQCommonNApiModule.Companion companion = QQCommonNApiModule.Companion;
        com.tencent.kuikly.core.manager.c cVar = com.tencent.kuikly.core.manager.c.f117352a;
        if (((QQCommonNApiModule) cVar.g().acquireModule("QQCommonNApiModule")).isDarkTheme()) {
            if (value != null) {
                r06 = value.createCenterBkgUrlNight;
            }
            r06 = 0;
        } else {
            if (value != null) {
                r06 = value.createCenterBkgUrlDay;
            }
            r06 = 0;
        }
        objectRef.element = r06;
        if (r06 == 0 || r06.length() == 0) {
            if (((QQCommonNApiModule) cVar.g().acquireModule("QQCommonNApiModule")).isDarkTheme()) {
                t16 = "https://bot-resource-1251316161.file.myqcloud.com/media/create_center_card_night_1.png";
            } else {
                t16 = "https://bot-resource-1251316161.file.myqcloud.com/media/create_center_card_day_1.png";
            }
            objectRef.element = t16;
        }
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(-1, null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState mutableState = (MutableState) rememberedValue;
        float e16 = ((((a) startRestartGroup.consume(CompositionLocalsKt.d())).e() - 32.0f) * 125.0f) / 343.0f;
        float f16 = floatRef.element;
        final float f17 = e16 + f16;
        final float f18 = (f17 - f16) * 0.144f;
        float f19 = k.a(cVar) ? 20.0f : 24.0f;
        final float f26 = ((f17 - floatRef.element) - f18) - f19;
        final float f27 = k.a(cVar) ? 74.166664f : 89.0f;
        final float f28 = f19;
        final float f29 = k.a(cVar) ? 20.0f : 24.0f;
        final e eVar3 = eVar2;
        final e eVar4 = eVar2;
        SurfaceKt.a(ViewEventPropUpdaterKt.g(ComposeLayoutPropUpdaterKt.k(i.INSTANCE, f17), new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCardKt$DataCard$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                y value2;
                e eVar5 = e.this;
                if (eVar5 != null && (value2 = adelieCreativeCenterViewModel.dataInfo._state.getValue()) != null) {
                    e eVar6 = new e(eVar5.toString());
                    eVar6.v("dt_eid", "em_bas_creator_banner");
                    eVar6.u("quantity_created", value2.f404257d);
                    eVar6.u("agent_friend", value2.f404258e);
                    eVar6.u("message_number", value2.f404259f);
                    eVar6.v("cur_pg", eVar5);
                    ReportKt.reportCustomDTEvent("dt_imp", eVar6);
                }
                return Unit.INSTANCE;
            }
        }), uo3.c.a(8.0f), null, h.INSTANCE.j(), ComposableLambdaKt.composableLambda(startRestartGroup, 27347726, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCardKt$DataCard$3
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
                        ComposerKt.traceEventStart(27347726, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCard.<anonymous> (DataCard.kt:107)");
                    }
                    i h16 = ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null);
                    final float f36 = f17;
                    final Ref.FloatRef floatRef2 = floatRef;
                    final AdelieCreativeCenterViewModel adelieCreativeCenterViewModel2 = adelieCreativeCenterViewModel;
                    final Ref.ObjectRef<String> objectRef2 = objectRef;
                    final float f37 = f18;
                    final float f38 = f26;
                    final float f39 = f28;
                    final float f46 = f27;
                    final float f47 = f29;
                    final e eVar5 = eVar3;
                    final boolean z17 = z16;
                    final MutableState<Integer> mutableState2 = mutableState;
                    ColumnKt.a(h16, null, null, null, ComposableLambdaKt.composableLambda(composer3, 931980535, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCardKt$DataCard$3.1
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
                                    ComposerKt.traceEventStart(931980535, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCard.<anonymous>.<anonymous> (DataCard.kt:111)");
                                }
                                i.Companion companion2 = i.INSTANCE;
                                i k3 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion2, 0.0f, 1, null), f36 - floatRef2.element);
                                final Ref.ObjectRef<String> objectRef3 = objectRef2;
                                final float f48 = f37;
                                final float f49 = f38;
                                final float f56 = f39;
                                final AdelieCreativeCenterViewModel adelieCreativeCenterViewModel3 = adelieCreativeCenterViewModel2;
                                final float f57 = f46;
                                final float f58 = f47;
                                final e eVar6 = eVar5;
                                final boolean z18 = z17;
                                BoxKt.a(k3, null, null, ComposableLambdaKt.composableLambda(composer5, 696372529, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCardKt.DataCard.3.1.1
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
                                                ComposerKt.traceEventStart(696372529, intValue3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCard.<anonymous>.<anonymous>.<anonymous> (DataCard.kt:115)");
                                            }
                                            String str = objectRef3.element;
                                            int b16 = com.tencent.ntcompose.material.h.INSTANCE.b();
                                            i.Companion companion3 = i.INSTANCE;
                                            ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.h(companion3, 0.0f, 1, null), null, b16, null, null, str, null, null, null, null, null, null, null, null, null, null, composer7, 12845056, 0, 0, 2095967);
                                            i h17 = ComposeLayoutPropUpdaterKt.h(companion3, 0.0f, 1, null);
                                            final float f59 = f48;
                                            final float f65 = f49;
                                            final float f66 = f56;
                                            final AdelieCreativeCenterViewModel adelieCreativeCenterViewModel4 = adelieCreativeCenterViewModel3;
                                            final float f67 = f57;
                                            final float f68 = f58;
                                            final e eVar7 = eVar6;
                                            final boolean z19 = z18;
                                            ColumnKt.a(h17, null, null, null, ComposableLambdaKt.composableLambda(composer7, -1887705894, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCardKt.DataCard.3.1.1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(3);
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public final Unit invoke(d dVar2, Composer composer8, Integer num4) {
                                                    Composer composer9 = composer8;
                                                    int intValue4 = num4.intValue();
                                                    if ((intValue4 & 81) == 16 && composer9.getSkipping()) {
                                                        composer9.skipToGroupEnd();
                                                    } else {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-1887705894, intValue4, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCard.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DataCard.kt:126)");
                                                        }
                                                        Alignment.Companion companion4 = Alignment.INSTANCE;
                                                        Alignment.Vertical c16 = companion4.c();
                                                        com.tencent.ntcompose.foundation.layout.base.a aVar = com.tencent.ntcompose.foundation.layout.base.a.f339245a;
                                                        a.d g16 = aVar.g();
                                                        i.Companion companion5 = i.INSTANCE;
                                                        i r16 = ComposeLayoutPropUpdaterKt.r(ComposeLayoutPropUpdaterKt.j(companion5, 0.0f, 1, null), 10.0f, f59, 10.0f, 0.0f);
                                                        final float f69 = f66;
                                                        final AdelieCreativeCenterViewModel adelieCreativeCenterViewModel5 = adelieCreativeCenterViewModel4;
                                                        final float f75 = f67;
                                                        final float f76 = f68;
                                                        final e eVar8 = eVar7;
                                                        RowKt.a(r16, g16, c16, null, null, ComposableLambdaKt.composableLambda(composer9, -1059864072, true, new Function3<com.tencent.ntcompose.foundation.layout.n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCardKt.DataCard.3.1.1.1.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(3);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function3
                                                            public final Unit invoke(com.tencent.ntcompose.foundation.layout.n nVar, Composer composer10, Integer num5) {
                                                                Composer composer11 = composer10;
                                                                int intValue5 = num5.intValue();
                                                                if ((intValue5 & 81) == 16 && composer11.getSkipping()) {
                                                                    composer11.skipToGroupEnd();
                                                                } else {
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventStart(-1059864072, intValue5, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCard.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DataCard.kt:131)");
                                                                    }
                                                                    i.Companion companion6 = i.INSTANCE;
                                                                    float f77 = f69;
                                                                    i g17 = ModifiersKt.g(ModifiersKt.j(ComposeLayoutPropUpdaterKt.v(companion6, f77, f77), f69 / 2.0f), new com.tencent.kuikly.core.base.e(0.5f, BorderStyle.SOLID, QUIToken.color$default("border_superlight")));
                                                                    com.tencent.kuikly.core.manager.c cVar2 = com.tencent.kuikly.core.manager.c.f117352a;
                                                                    QQAvatarViewKt.QQAvatarView(g17, null, cVar2.g().getPageData().n().q("uin", ""), composer11, 8, 2);
                                                                    SpacerKt.a(ComposeLayoutPropUpdaterKt.w(companion6, 6.0f), composer11, 8, 0);
                                                                    i x16 = ComposeLayoutPropUpdaterKt.x(ComposeLayoutPropUpdaterKt.z(companion6), 0.0f, 140.0f);
                                                                    String bVar2 = ((AdelieKuiklyBaseModule) cVar2.g().acquireModule("AdelieKuiklyBaseModule")).toNative(false, "getCurrentUserName", null, null, true).toString();
                                                                    h color$default = QUIToken.color$default("text_primary");
                                                                    int b17 = an.INSTANCE.b();
                                                                    n nVar2 = new n(PTSNodeTextBase.FONT_FAMILY_PING_FANG_SC_MEDIUM);
                                                                    TextKt.a(bVar2, x16, null, color$default, Float.valueOf(14.0f), null, bp3.c.INSTANCE.f(), nVar2, null, null, null, Float.valueOf(20.0f), null, null, null, null, an.d(b17), null, 1, null, null, null, "emoji", null, null, null, false, composer11, (n.f339436b << 21) | 1601600, 102236208, MsgConstant.KRMFILETHUMBSIZE384, 129693476);
                                                                    final u value2 = adelieCreativeCenterViewModel5.identityInfo._state.getValue();
                                                                    if (value2 != null) {
                                                                        float f78 = f75;
                                                                        float f79 = f76;
                                                                        final e eVar9 = eVar8;
                                                                        SpacerKt.a(ComposeLayoutPropUpdaterKt.w(companion6, 4.0f), composer11, 8, 0);
                                                                        ImageKt.a(null, null, null, null, null, ViewEventPropUpdaterKt.g(ViewEventPropUpdaterKt.d(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion6, f78), f79), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCardKt$DataCard$3$1$1$1$1$1$1
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ClickParams clickParams) {
                                                                                String str2 = u.this.f404243f;
                                                                                if (str2 == null) {
                                                                                    str2 = "";
                                                                                }
                                                                                DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0.m("click badge : ", str2, KLog.INSTANCE, "AdelieCreativeCenterViewModel");
                                                                                QQKuiklyPlatformApi.Companion companion7 = QQKuiklyPlatformApi.Companion;
                                                                                QQKuiklyPlatformApi.Companion.openPage$default(str2, false, 6);
                                                                                e eVar10 = eVar9;
                                                                                if (eVar10 != null) {
                                                                                    u uVar = u.this;
                                                                                    e eVar11 = new e(eVar10.toString());
                                                                                    eVar11.v("dt_eid", "em_bas_star_creation_badge");
                                                                                    eVar11.t("status", uVar.f404241d);
                                                                                    eVar11.v("cur_pg", eVar10);
                                                                                    ReportKt.reportCustomDTEvent("dt_clck", eVar11);
                                                                                }
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        }, 3, null), new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCardKt$DataCard$3$1$1$1$1$1$2
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(Object obj) {
                                                                                e eVar10 = e.this;
                                                                                if (eVar10 != null) {
                                                                                    u uVar = value2;
                                                                                    e eVar11 = new e(eVar10.toString());
                                                                                    eVar11.v("dt_eid", "em_bas_star_creation_badge");
                                                                                    eVar11.t("status", uVar.f404241d);
                                                                                    eVar11.v("cur_pg", eVar10);
                                                                                    ReportKt.reportCustomDTEvent("dt_imp", eVar11);
                                                                                }
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        }), null, com.tencent.ntcompose.material.h.INSTANCE.b(), null, null, value2.f404242e, null, null, null, null, null, null, null, null, null, null, composer11, 12845056, 0, 0, 2095967);
                                                                    }
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventEnd();
                                                                    }
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        }), composer9, 196680, 24);
                                                        a.e f77 = aVar.f();
                                                        Alignment.Vertical c17 = companion4.c();
                                                        i k16 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion5, 0.0f, 1, null), f65);
                                                        final boolean z26 = z19;
                                                        final AdelieCreativeCenterViewModel adelieCreativeCenterViewModel6 = adelieCreativeCenterViewModel4;
                                                        RowKt.a(k16, f77, c17, null, null, ComposableLambdaKt.composableLambda(composer9, 225910689, true, new Function3<com.tencent.ntcompose.foundation.layout.n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCardKt.DataCard.3.1.1.1.2
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(3);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function3
                                                            public final Unit invoke(com.tencent.ntcompose.foundation.layout.n nVar, Composer composer10, Integer num5) {
                                                                Composer composer11 = composer10;
                                                                int intValue5 = num5.intValue();
                                                                if ((intValue5 & 81) == 16 && composer11.getSkipping()) {
                                                                    composer11.skipToGroupEnd();
                                                                } else {
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventStart(225910689, intValue5, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCard.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DataCard.kt:207)");
                                                                    }
                                                                    if (z26) {
                                                                        composer11.startReplaceableGroup(463275072);
                                                                        y value2 = adelieCreativeCenterViewModel6.dataInfo._state.getValue();
                                                                        if (value2 != null) {
                                                                            DataCardKt.StatItem(value2.f404257d, "\u5df2\u521b\u4f5c", composer11, 48);
                                                                            DataCardKt.StatItem(value2.f404258e, "\u667a\u80fd\u4f53\u597d\u53cb", composer11, 48);
                                                                            DataCardKt.StatItem(value2.f404259f, "\u667a\u80fd\u4f53\u6d88\u606f", composer11, 48);
                                                                        }
                                                                        composer11.endReplaceableGroup();
                                                                    } else {
                                                                        composer11.startReplaceableGroup(463275429);
                                                                        DataCardKt.StatItem(-1L, "\u5df2\u521b\u4f5c", composer11, 54);
                                                                        DataCardKt.StatItem(-1L, "\u667a\u80fd\u4f53\u597d\u53cb", composer11, 54);
                                                                        DataCardKt.StatItem(-1L, "\u667a\u80fd\u4f53\u6d88\u606f", composer11, 54);
                                                                        composer11.endReplaceableGroup();
                                                                    }
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventEnd();
                                                                    }
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        }), composer9, 196680, 24);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }), composer7, 24584, 14);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer5, 3080, 6);
                                CreateCenterBanner value2 = adelieCreativeCenterViewModel2.bannerInfo._state.getValue();
                                final List<CreateCenterBannerItem> list = value2 != null ? value2.banner : null;
                                if (list != null) {
                                    Ref.FloatRef floatRef3 = floatRef2;
                                    final MutableState<Integer> mutableState3 = mutableState2;
                                    RowKt.a(ViewEventPropUpdaterKt.d(ModifiersKt.d(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion2, 0.0f, 1, null), floatRef3.element), 16.0f, 0.0f, 32.0f, 0.0f, 10, null), QUIToken.color$default("bg_bottom_light")), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCardKt$DataCard$3$1$2$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ClickParams clickParams) {
                                            int size = list.size();
                                            int intValue3 = mutableState3.getValue().intValue();
                                            if (intValue3 >= 0 && intValue3 < size) {
                                                String str = list.get(mutableState3.getValue().intValue()).url;
                                                DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0.m("click banner : ", str, KLog.INSTANCE, "AdelieCreativeCenterViewModel");
                                                QQKuiklyPlatformApi.Companion companion3 = QQKuiklyPlatformApi.Companion;
                                                QQKuiklyPlatformApi.Companion.openPage$default(str, false, 6);
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }, 3, null), com.tencent.ntcompose.foundation.layout.base.a.f339245a.e(), Alignment.INSTANCE.c(), null, null, ComposableLambdaKt.composableLambda(composer5, -861995670, true, new Function3<com.tencent.ntcompose.foundation.layout.n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCardKt$DataCard$3$1$2$2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public final Unit invoke(com.tencent.ntcompose.foundation.layout.n nVar, Composer composer6, Integer num3) {
                                            Composer composer7 = composer6;
                                            int intValue3 = num3.intValue();
                                            if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                                composer7.skipToGroupEnd();
                                            } else {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-861995670, intValue3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCard.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DataCard.kt:238)");
                                                }
                                                i.Companion companion3 = i.INSTANCE;
                                                i h17 = ComposeLayoutPropUpdaterKt.h(companion3, 0.0f, 1, null);
                                                Alignment.Vertical c16 = Alignment.INSTANCE.c();
                                                a.d g16 = com.tencent.ntcompose.foundation.layout.base.a.f339245a.g();
                                                final List<CreateCenterBannerItem> list2 = list;
                                                final MutableState<Integer> mutableState4 = mutableState3;
                                                RowKt.a(h17, g16, c16, null, null, ComposableLambdaKt.composableLambda(composer7, -1805122420, true, new Function3<com.tencent.ntcompose.foundation.layout.n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCardKt$DataCard$3$1$2$2.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(3);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function3
                                                    public final Unit invoke(com.tencent.ntcompose.foundation.layout.n nVar2, Composer composer8, Integer num4) {
                                                        int i17;
                                                        com.tencent.ntcompose.foundation.layout.n nVar3 = nVar2;
                                                        Composer composer9 = composer8;
                                                        int intValue4 = num4.intValue();
                                                        if ((intValue4 & 14) == 0) {
                                                            i17 = (composer9.changed(nVar3) ? 4 : 2) | intValue4;
                                                        } else {
                                                            i17 = intValue4;
                                                        }
                                                        if ((i17 & 91) == 18 && composer9.getSkipping()) {
                                                            composer9.skipToGroupEnd();
                                                        } else {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-1805122420, intValue4, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCard.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DataCard.kt:244)");
                                                            }
                                                            i.Companion companion4 = i.INSTANCE;
                                                            ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.u(companion4, 16.0f), null, com.tencent.ntcompose.material.h.INSTANCE.a(), null, null, QUIToken.INSTANCE.image("voice_high", QUIToken.color$default("icon_aio_toolbar_active")), null, null, null, null, null, null, null, null, null, null, composer9, 12845056, 0, 0, 2095967);
                                                            SpacerKt.a(ComposeLayoutPropUpdaterKt.w(companion4, 6.0f), composer9, 8, 0);
                                                            i a16 = nVar3.a(companion4, 1.0f);
                                                            int size = list2.size();
                                                            final MutableState<Integer> mutableState5 = mutableState4;
                                                            composer9.startReplaceableGroup(1157296644);
                                                            boolean changed = composer9.changed(mutableState5);
                                                            Object rememberedValue2 = composer9.rememberedValue();
                                                            if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                                rememberedValue2 = new Function1<Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCardKt$DataCard$3$1$2$2$1$1$1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(Integer num5) {
                                                                        mutableState5.setValue(Integer.valueOf(num5.intValue()));
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                };
                                                                composer9.updateRememberedValue(rememberedValue2);
                                                            }
                                                            composer9.endReplaceableGroup();
                                                            Function1 function1 = (Function1) rememberedValue2;
                                                            final List<CreateCenterBannerItem> list3 = list2;
                                                            Function1<Integer, Unit> function12 = new Function1<Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCardKt.DataCard.3.1.2.2.1.2
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(Integer num5) {
                                                                    Object orNull;
                                                                    orNull = CollectionsKt___CollectionsKt.getOrNull(list3, num5.intValue());
                                                                    CreateCenterBannerItem createCenterBannerItem = (CreateCenterBannerItem) orNull;
                                                                    if (createCenterBannerItem != null) {
                                                                        AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("click banner : "), createCenterBannerItem.url, KLog.INSTANCE, "AdelieCreativeCenterViewModel");
                                                                        QQKuiklyPlatformApi.Companion companion5 = QQKuiklyPlatformApi.Companion;
                                                                        QQKuiklyPlatformApi.Companion.openPage$default(createCenterBannerItem.url, false, 6);
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            };
                                                            final List<CreateCenterBannerItem> list4 = list2;
                                                            VerticalFlipperKt.VerticalFlipper(a16, size, 0, 0, function1, function12, ComposableLambdaKt.composableLambda(composer9, 364349198, true, new Function3<Integer, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCardKt.DataCard.3.1.2.2.1.3
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(3);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function3
                                                                public final Unit invoke(Integer num5, Composer composer10, Integer num6) {
                                                                    int i18;
                                                                    int intValue5 = num5.intValue();
                                                                    Composer composer11 = composer10;
                                                                    int intValue6 = num6.intValue();
                                                                    if ((intValue6 & 14) == 0) {
                                                                        i18 = (composer11.changed(intValue5) ? 4 : 2) | intValue6;
                                                                    } else {
                                                                        i18 = intValue6;
                                                                    }
                                                                    if ((i18 & 91) == 18 && composer11.getSkipping()) {
                                                                        composer11.skipToGroupEnd();
                                                                    } else {
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventStart(364349198, intValue6, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCard.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DataCard.kt:264)");
                                                                        }
                                                                        TextKt.a(list4.get(intValue5).title, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, new bp3.k(QUIToken.color$default("icon_aio_toolbar_active"), Float.valueOf(14.0f), null, null, null, null, null, null, null, null, null, null, null, null, 16380, null), null, null, null, null, null, false, composer11, 0, 0, bp3.k.f28903n, 133169150);
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventEnd();
                                                                        }
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            }), composer9, 1572872, 12);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                }), composer7, 196680, 24);
                                                ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.u(companion3, 12.0f), null, com.tencent.ntcompose.material.h.INSTANCE.a(), null, null, QUIToken.INSTANCE.image("chevron_right", QUIToken.color$default("icon_secondary")), null, null, null, null, null, null, null, null, null, null, composer7, 12845056, 0, 0, 2095967);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer5, 196680, 24);
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
        }), startRestartGroup, 28680, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCardKt$DataCard$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                DataCardKt.DataCard(AdelieCreativeCenterViewModel.this, z16, eVar4, composer2, i3 | 1, i16);
                return Unit.INSTANCE;
            }
        });
    }
}
