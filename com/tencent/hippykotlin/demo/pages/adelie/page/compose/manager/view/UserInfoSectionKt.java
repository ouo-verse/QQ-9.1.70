package com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util.ReportKt;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieKuiklyBaseModule;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.GuardFastClickKt;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterViewModel;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerReport;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.troop.robot.api.IRobotUtilApi;
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
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.ai;
import com.tencent.ntcompose.material.an;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import uo3.c;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class UserInfoSectionKt {
    public static final void BottomButtons(final Function0<Unit> function0, final Function0<Unit> function02, Composer composer, final int i3) {
        final int i16;
        Composer startRestartGroup = composer.startRestartGroup(-843642295);
        if ((i3 & 14) == 0) {
            i16 = (startRestartGroup.changed(function0) ? 4 : 2) | i3;
        } else {
            i16 = i3;
        }
        if ((i3 & 112) == 0) {
            i16 |= startRestartGroup.changed(function02) ? 32 : 16;
        }
        if ((i16 & 91) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-843642295, i16, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.BottomButtons (UserInfoSection.kt:170)");
            }
            RowKt.a(ViewEventPropUpdaterKt.d(ModifiersKt.c(ComposeLayoutPropUpdaterKt.z(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null)), h.INSTANCE.l()), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.UserInfoSectionKt$BottomButtons$1
                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                    return Unit.INSTANCE;
                }
            }, 3, null), a.f339245a.e(), Alignment.INSTANCE.c(), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1611837799, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.UserInfoSectionKt$BottomButtons$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            ComposerKt.traceEventStart(1611837799, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.BottomButtons.<anonymous> (UserInfoSection.kt:179)");
                        }
                        RowKt.a(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), null, Alignment.INSTANCE.c(), null, null, ComposableLambdaKt.composableLambda(composer3, 2121438213, true, new Function3<n, Composer, Integer, Unit>(function0, i16, function02) { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.UserInfoSectionKt$BottomButtons$2.1
                            public final /* synthetic */ Function0<Unit> $onSendMsg;
                            public final /* synthetic */ Function0<Unit> $onShare;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                                this.$onShare = r3;
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(n nVar2, Composer composer4, Integer num2) {
                                n nVar3 = nVar2;
                                Composer composer5 = composer4;
                                int intValue2 = num2.intValue();
                                if ((intValue2 & 14) == 0) {
                                    intValue2 |= composer5.changed(nVar3) ? 4 : 2;
                                }
                                if ((intValue2 & 91) == 18 && composer5.getSkipping()) {
                                    composer5.skipToGroupEnd();
                                } else {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(2121438213, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.BottomButtons.<anonymous>.<anonymous> (UserInfoSection.kt:183)");
                                    }
                                    QUIToken qUIToken = QUIToken.INSTANCE;
                                    String image = qUIToken.image("message", QUIToken.color$default("icon_primary"));
                                    final Function0<Unit> function03 = this.$onSendMsg;
                                    composer5.startReplaceableGroup(1157296644);
                                    boolean changed = composer5.changed(function03);
                                    Object rememberedValue = composer5.rememberedValue();
                                    if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.UserInfoSectionKt$BottomButtons$2$1$1$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final Unit invoke() {
                                                GuardFastClickKt.guardFastClick(function03);
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        composer5.updateRememberedValue(rememberedValue);
                                    }
                                    composer5.endReplaceableGroup();
                                    int i17 = (intValue2 & 14) | MsgConstant.KRMFILETHUMBSIZE384;
                                    UserInfoSectionKt.access$OPButton(nVar3, image, "\u53d1\u6d88\u606f", (Function0) rememberedValue, composer5, i17);
                                    SpacerKt.a(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 16.0f), composer5, 8, 0);
                                    String image2 = qUIToken.image("share", QUIToken.color$default("icon_primary"));
                                    final Function0<Unit> function04 = this.$onShare;
                                    composer5.startReplaceableGroup(1157296644);
                                    boolean changed2 = composer5.changed(function04);
                                    Object rememberedValue2 = composer5.rememberedValue();
                                    if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue2 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.UserInfoSectionKt$BottomButtons$2$1$2$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final Unit invoke() {
                                                GuardFastClickKt.guardFastClick(function04);
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        composer5.updateRememberedValue(rememberedValue2);
                                    }
                                    composer5.endReplaceableGroup();
                                    UserInfoSectionKt.access$OPButton(nVar3, image2, "\u5206\u4eab", (Function0) rememberedValue2, composer5, i17);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer3, 196616, 26);
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
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.UserInfoSectionKt$BottomButtons$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                UserInfoSectionKt.BottomButtons(function0, function02, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void UserAvatarInfo(final AdelieManagerCenterViewModel adelieManagerCenterViewModel, final Function0<Unit> function0, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-2043258767);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2043258767, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.UserAvatarInfo (UserInfoSection.kt:105)");
        }
        i c16 = ModifiersKt.c(ComposeLayoutPropUpdaterKt.z(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null)), h.INSTANCE.j());
        startRestartGroup.startReplaceableGroup(1157296644);
        boolean changed = startRestartGroup.changed(function0);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.UserInfoSectionKt$UserAvatarInfo$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(ClickParams clickParams) {
                    function0.invoke();
                    return Unit.INSTANCE;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        RowKt.a(ViewEventPropUpdaterKt.r(ViewEventPropUpdaterKt.d(c16, false, null, (Function1) rememberedValue, 3, null), new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.UserInfoSectionKt$UserAvatarInfo$2
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_bas_agent_management");
                e m16 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_bas_agent_management");
                m16.v("agent_id", AdelieManagerReport.uid);
                m16.u("agent_uin", AdelieManagerReport.uin);
                m3.v("cur_pg", m16);
                m3.v("dt_eid", "em_bas_agent_data_card");
                ReportKt.reportCustomDTEvent("dt_imp", m3);
                return Unit.INSTANCE;
            }
        }), a.f339245a.e(), Alignment.INSTANCE.c(), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1624947569, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.UserInfoSectionKt$UserAvatarInfo$3
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
                        ComposerKt.traceEventStart(-1624947569, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.UserAvatarInfo.<anonymous> (UserInfoSection.kt:119)");
                    }
                    Alignment.Vertical c17 = Alignment.INSTANCE.c();
                    final AdelieManagerCenterViewModel adelieManagerCenterViewModel2 = AdelieManagerCenterViewModel.this;
                    RowKt.a(null, null, c17, null, null, ComposableLambdaKt.composableLambda(composer3, -1490572243, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.UserInfoSectionKt$UserAvatarInfo$3.1
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(n nVar2, Composer composer4, Integer num2) {
                            int i16;
                            Composer composer5;
                            Composer composer6 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer6.getSkipping()) {
                                composer6.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1490572243, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.UserAvatarInfo.<anonymous>.<anonymous> (UserInfoSection.kt:122)");
                                }
                                String value = AdelieManagerCenterViewModel.this.avatarUrl._state.getValue();
                                if (value == null || value.length() == 0) {
                                    composer6.startReplaceableGroup(875561044);
                                    BoxKt.a(ModifiersKt.c(ModifiersKt.q(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 56.0f), c.a(56.0f / 2)), QUIToken.color$default("fill_standard_primary").n(0.04f)), Alignment.Center, null, ComposableLambdaKt.composableLambda(composer6, -1191381012, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.UserInfoSectionKt.UserAvatarInfo.3.1.1
                                        @Override // kotlin.jvm.functions.Function3
                                        public final Unit invoke(b bVar, Composer composer7, Integer num3) {
                                            Composer composer8 = composer7;
                                            int intValue3 = num3.intValue();
                                            if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                composer8.skipToGroupEnd();
                                            } else {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1191381012, intValue3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.UserAvatarInfo.<anonymous>.<anonymous>.<anonymous> (UserInfoSection.kt:129)");
                                                }
                                                ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 56.0f / 2), null, com.tencent.ntcompose.material.h.INSTANCE.a(), null, null, QUIToken.INSTANCE.image(IRobotUtilApi.MMKV_SCENE_ID, QUIToken.color$default("fill_standard_primary").n(0.04f)), null, null, null, null, null, null, null, null, null, null, composer8, 12845056, 0, 0, 2095967);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer6, 3128, 4);
                                    composer6.endReplaceableGroup();
                                    i16 = 1;
                                    composer5 = composer6;
                                } else {
                                    composer6.startReplaceableGroup(875561618);
                                    i16 = 1;
                                    composer5 = composer6;
                                    ImageKt.a(null, null, null, null, null, ModifiersKt.q(ModifiersKt.h(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 56.0f), 0.5f, QUIToken.color$default("border_standard").n(0.1f), null, 4, null), c.a(56.0f / 2)), null, com.tencent.ntcompose.material.h.INSTANCE.a(), null, null, AdelieManagerCenterViewModel.this.avatarUrl._state.getValue(), null, null, null, null, null, null, null, null, null, null, composer5, 12845056, 0, 0, 2095967);
                                    composer5.endReplaceableGroup();
                                }
                                String value2 = AdelieManagerCenterViewModel.this.nickName._state.getValue();
                                if (value2 != null) {
                                    if ((value2.length() == 0 ? i16 : 0) != 0) {
                                        value2 = "\u667a\u80fd\u4f53\u6635\u79f0";
                                    }
                                } else {
                                    value2 = null;
                                }
                                TextKt.a(value2, ComposeLayoutPropUpdaterKt.w(ComposeLayoutPropUpdaterKt.n(i.INSTANCE, 10.0f, 0.0f, 0.0f, 0.0f, 14, null), 220.0f), null, QUIToken.color$default("text_primary"), Float.valueOf(16.0f), null, bp3.c.INSTANCE.f(), null, null, null, ai.f(ai.INSTANCE.e()), null, null, null, null, null, an.d(an.INSTANCE.b()), null, Integer.valueOf(i16), null, null, null, null, null, null, null, false, composer5, 1601600, 102236160, 0, 133888932);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 196608, 27);
                    if (!AdelieManagerCenterViewModel.this.disableProfile) {
                        ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 16.0f), null, com.tencent.ntcompose.material.h.INSTANCE.a(), null, null, QUIToken.INSTANCE.image("chevron_right", QUIToken.color$default("icon_secondary")), null, null, null, null, null, null, null, null, null, null, composer3, 12845056, 0, 0, 2095967);
                    }
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.UserInfoSectionKt$UserAvatarInfo$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                UserInfoSectionKt.UserAvatarInfo(AdelieManagerCenterViewModel.this, function0, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void UserInfoSection(final AdelieManagerCenterViewModel adelieManagerCenterViewModel, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-1852152549);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1852152549, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.UserInfoSection (UserInfoSection.kt:47)");
        }
        ColumnKt.a(ModifiersKt.c(ComposeLayoutPropUpdaterKt.l(ComposeLayoutPropUpdaterKt.f(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 0.0f, 1, null), 16.0f), h.INSTANCE.j()), null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1660950866, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.UserInfoSectionKt$UserInfoSection$1

            /* compiled from: P */
            /* renamed from: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.UserInfoSectionKt$UserInfoSection$1$1, reason: invalid class name */
            /* loaded from: classes31.dex */
            public final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Unit> {
                public final /* synthetic */ AdelieManagerCenterViewModel $viewModel;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass1(AdelieManagerCenterViewModel adelieManagerCenterViewModel) {
                    super(0, Intrinsics.Kotlin.class, "openCard", "invoke$openCard(Lcom/tencent/hippykotlin/demo/pages/adelie/page/compose/manager/AdelieManagerCenterViewModel;)V", 0);
                    this.$viewModel = adelieManagerCenterViewModel;
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    AdelieManagerCenterViewModel adelieManagerCenterViewModel = this.$viewModel;
                    e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_bas_agent_management");
                    e m16 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_bas_agent_management");
                    m16.v("agent_id", AdelieManagerReport.uid);
                    m16.u("agent_uin", AdelieManagerReport.uin);
                    m3.v("cur_pg", m16);
                    m3.v("dt_eid", "em_bas_agent_data_card");
                    ReportKt.reportCustomDTEvent("dt_clck", m3);
                    if (!adelieManagerCenterViewModel.disableProfile && adelieManagerCenterViewModel.isFetchDataFinish()) {
                        BridgeModule bridgeModule = (BridgeModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("HRBridgeModule");
                        StringBuilder m17 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("mqqapi://trooprobot/show_card?uin=");
                        m17.append(adelieManagerCenterViewModel.robotUin);
                        BridgeModule.openPage$default(bridgeModule, m17.toString(), false, null, null, 30);
                    }
                    return Unit.INSTANCE;
                }
            }

            /* compiled from: P */
            /* renamed from: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.UserInfoSectionKt$UserInfoSection$1$2, reason: invalid class name */
            /* loaded from: classes31.dex */
            public final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function0<Unit> {
                public final /* synthetic */ AdelieManagerCenterViewModel $viewModel;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass2(AdelieManagerCenterViewModel adelieManagerCenterViewModel) {
                    super(0, Intrinsics.Kotlin.class, "onSendMessage", "invoke$onSendMessage(Lcom/tencent/hippykotlin/demo/pages/adelie/page/compose/manager/AdelieManagerCenterViewModel;)V", 0);
                    this.$viewModel = adelieManagerCenterViewModel;
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    AdelieManagerCenterViewModel adelieManagerCenterViewModel = this.$viewModel;
                    e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_bas_agent_management");
                    e m16 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_bas_agent_management");
                    m16.v("agent_id", AdelieManagerReport.uid);
                    m16.u("agent_uin", AdelieManagerReport.uin);
                    m3.v("cur_pg", m16);
                    m3.v("dt_eid", "em_bas_send_message_button");
                    ReportKt.reportCustomDTEvent("dt_clck", m3);
                    if (adelieManagerCenterViewModel.isFetchDataFinish()) {
                        BridgeModule bridgeModule = (BridgeModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("HRBridgeModule");
                        StringBuilder m17 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("mqqapi://qqrobotaio/open?uin=");
                        m17.append(adelieManagerCenterViewModel.robotUin);
                        BridgeModule.openPage$default(bridgeModule, m17.toString(), false, null, null, 30);
                    }
                    return Unit.INSTANCE;
                }
            }

            /* compiled from: P */
            /* renamed from: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.UserInfoSectionKt$UserInfoSection$1$3, reason: invalid class name */
            /* loaded from: classes31.dex */
            public final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function0<Unit> {
                public final /* synthetic */ AdelieManagerCenterViewModel $viewModel;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass3(AdelieManagerCenterViewModel adelieManagerCenterViewModel) {
                    super(0, Intrinsics.Kotlin.class, "onShare", "invoke$onShare(Lcom/tencent/hippykotlin/demo/pages/adelie/page/compose/manager/AdelieManagerCenterViewModel;)V", 0);
                    this.$viewModel = adelieManagerCenterViewModel;
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    AdelieManagerCenterViewModel adelieManagerCenterViewModel = this.$viewModel;
                    e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_bas_agent_management");
                    e m16 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_bas_agent_management");
                    m16.v("agent_id", AdelieManagerReport.uid);
                    m16.u("agent_uin", AdelieManagerReport.uin);
                    m3.v("cur_pg", m16);
                    m3.v("dt_eid", "em_bas_share_btn");
                    ReportKt.reportCustomDTEvent("dt_clck", m3);
                    if (adelieManagerCenterViewModel.isFetchDataFinish()) {
                        AdelieKuiklyBaseModule adelieKuiklyBaseModule = (AdelieKuiklyBaseModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("AdelieKuiklyBaseModule");
                        String valueOf = String.valueOf(adelieManagerCenterViewModel.robotUin);
                        UserInfoSectionKt$UserInfoSection$1$onShare$2 userInfoSectionKt$UserInfoSection$1$onShare$2 = UserInfoSectionKt$UserInfoSection$1$onShare$2.INSTANCE;
                        adelieKuiklyBaseModule.getClass();
                        e eVar = new e();
                        eVar.v("uin", valueOf);
                        adelieKuiklyBaseModule.toNative(false, "shareRobot", eVar.toString(), userInfoSectionKt$UserInfoSection$1$onShare$2, false);
                    }
                    return Unit.INSTANCE;
                }
            }

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
                        ComposerKt.traceEventStart(1660950866, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.UserInfoSection.<anonymous> (UserInfoSection.kt:51)");
                    }
                    UserInfoSectionKt.UserAvatarInfo(AdelieManagerCenterViewModel.this, new AnonymousClass1(AdelieManagerCenterViewModel.this), composer3, 8);
                    SpacerKt.a(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 16.0f), composer3, 8, 0);
                    UserInfoSectionKt.BottomButtons(new AnonymousClass2(AdelieManagerCenterViewModel.this), new AnonymousClass3(AdelieManagerCenterViewModel.this), composer3, 0);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.UserInfoSectionKt$UserInfoSection$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                UserInfoSectionKt.UserInfoSection(AdelieManagerCenterViewModel.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void access$OPButton(final n nVar, final String str, final String str2, final Function0 function0, Composer composer, final int i3) {
        final int i16;
        Composer startRestartGroup = composer.startRestartGroup(-1605434588);
        if ((i3 & 14) == 0) {
            i16 = (startRestartGroup.changed(nVar) ? 4 : 2) | i3;
        } else {
            i16 = i3;
        }
        if ((i3 & 112) == 0) {
            i16 |= startRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i3 & 896) == 0) {
            i16 |= startRestartGroup.changed(str2) ? 256 : 128;
        }
        if ((i3 & 7168) == 0) {
            i16 |= startRestartGroup.changed(function0) ? 2048 : 1024;
        }
        if ((i16 & 5851) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1605434588, i16, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OPButton (UserInfoSection.kt:196)");
            }
            i h16 = ModifiersKt.h(ModifiersKt.q(ModifiersKt.c(nVar.a(ComposeLayoutPropUpdaterKt.k(i.INSTANCE, 45.0f), 1.0f), h.INSTANCE.l()), c.a(4.0f)), 1.0f, QUIToken.color$default("button_border_secondary_default"), null, 4, null);
            startRestartGroup.startReplaceableGroup(1157296644);
            boolean changed = startRestartGroup.changed(function0);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.UserInfoSectionKt$OPButton$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ClickParams clickParams) {
                        function0.invoke();
                        return Unit.INSTANCE;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            RowKt.a(ViewEventPropUpdaterKt.d(h16, false, null, (Function1) rememberedValue, 3, null), a.f339245a.b(), Alignment.INSTANCE.c(), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1407669182, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.UserInfoSectionKt$OPButton$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public final Unit invoke(n nVar2, Composer composer2, Integer num) {
                    Composer composer3 = composer2;
                    int intValue = num.intValue();
                    if ((intValue & 81) == 16 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                    } else {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1407669182, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OPButton.<anonymous> (UserInfoSection.kt:207)");
                        }
                        i.Companion companion = i.INSTANCE;
                        ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.u(companion, 19.0f), null, com.tencent.ntcompose.material.h.INSTANCE.a(), null, null, str, null, null, null, null, null, null, null, null, null, null, composer3, 12845056, (i16 >> 3) & 14, 0, 2095967);
                        SpacerKt.a(ComposeLayoutPropUpdaterKt.w(companion, 6.0f), composer3, 8, 0);
                        h color$default = QUIToken.color$default("text_primary");
                        int e16 = ai.INSTANCE.e();
                        TextKt.a(str2, null, null, color$default, Float.valueOf(17.0f), null, bp3.c.INSTANCE.e(), null, null, null, ai.f(e16), Float.valueOf(24.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, ((i16 >> 6) & 14) | 1601536, 48, 0, 134214566);
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
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.UserInfoSectionKt$OPButton$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                UserInfoSectionKt.access$OPButton(n.this, str, str2, function0, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
