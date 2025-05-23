package com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.a;
import bp3.b;
import bp3.j;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util.ReportKt;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.GuardFastClickKt;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.RedDotKt;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterPage$DeleteAlertDialog$1$2$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterViewModel;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterViewModel$openRobotQzone$1;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerReport;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListSingleLineCommonViewKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.FullScreenLoadingKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.LoadingType;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.coroutines.BuildersKt;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.RichTextKt;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.ai;
import com.tencent.ntcompose.material.base.ModifiersKt;
import h25.ab;
import h25.g;
import java.util.Iterator;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import uo3.c;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class AdelieSpaceQualificationKt {
    public static final void report(String str, String str2, boolean z16, int i3, String str3) {
        e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_bas_agent_management");
        e m16 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_bas_agent_management");
        m16.v("agent_id", AdelieManagerReport.uid);
        m16.u("agent_uin", AdelieManagerReport.uin);
        m3.v("cur_pg", m16);
        m3.v("dt_eid", "em_qz_space_entrance");
        m3.v("agent_id", str3);
        m3.z("red_dot_type", str2);
        m3.z("is_red_tips", Integer.valueOf(z16 ? 1 : 0));
        m3.z("open_status", Integer.valueOf(i3 == 2 ? 1 : 0));
        ReportKt.reportCustomDTEvent(str, m3);
    }

    public static final a createHighlightedString(String str, int i3, int i16) {
        a.C0144a c0144a;
        int e16;
        String substring;
        String str2;
        if (i3 > 0 && i3 <= str.length() && i16 > 0) {
            if (!(str.length() == 0)) {
                String substring2 = str.substring(0, i3);
                Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                int i17 = i16 + i3;
                if (i17 <= str.length()) {
                    substring = str.substring(i3, i17);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                } else {
                    substring = str.substring(i3);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                }
                if (i17 < str.length()) {
                    str2 = str.substring(i17);
                    Intrinsics.checkNotNullExpressionValue(str2, "this as java.lang.String).substring(startIndex)");
                } else {
                    str2 = null;
                }
                c0144a = new a.C0144a(0, 1, null);
                e16 = c0144a.e(new j(QUIToken.color$default("text_secondary"), null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32766, null));
                try {
                    c0144a.a(substring2);
                    Unit unit = Unit.INSTANCE;
                    c0144a.c(e16);
                    e16 = c0144a.e(new j(QUIToken.color$default("brand_standard"), null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32766, null));
                    try {
                        c0144a.a(substring);
                        c0144a.c(e16);
                        if (str2 != null) {
                            e16 = c0144a.e(new j(QUIToken.color$default("text_secondary"), null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32766, null));
                            try {
                                c0144a.a(str2);
                            } finally {
                            }
                        }
                        return c0144a.f();
                    } finally {
                    }
                } finally {
                }
            }
        }
        KLog.INSTANCE.i("AdelieCreativeCenterPage", "invalid input(startIndex{ " + i3 + " }, len:{ " + i16 + "}, strLen:{ " + str.length() + " })");
        c0144a = new a.C0144a(0, 1, null);
        e16 = c0144a.e(new j(QUIToken.color$default("text_secondary"), null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32766, null));
        try {
            c0144a.a(str);
            Unit unit2 = Unit.INSTANCE;
            c0144a.c(e16);
            return c0144a.f();
        } finally {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v40, types: [T, java.lang.String] */
    public static final void AdelieSpaceQualification(final AdelieManagerCenterViewModel adelieManagerCenterViewModel, Composer composer, final int i3) {
        MutableState mutableState;
        AdelieRedDotModule$Companion$RedDotInfo adelieRedDotModule$Companion$RedDotInfo;
        Composer startRestartGroup = composer.startRestartGroup(2045800729);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2045800729, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.AdelieSpaceQualification (AdelieSpaceQualification.kt:59)");
        }
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue = startRestartGroup.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState mutableState2 = (MutableState) rememberedValue;
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue2);
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState mutableState3 = (MutableState) rememberedValue2;
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue3 = startRestartGroup.rememberedValue();
        if (rememberedValue3 == companion.getEmpty()) {
            rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(b.a(""), null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue3);
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState mutableState4 = (MutableState) rememberedValue3;
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue4 = startRestartGroup.rememberedValue();
        if (rememberedValue4 == companion.getEmpty()) {
            rememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue4);
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState mutableState5 = (MutableState) rememberedValue4;
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue5 = startRestartGroup.rememberedValue();
        if (rememberedValue5 == companion.getEmpty()) {
            rememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue5);
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState mutableState6 = (MutableState) rememberedValue5;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue6 = startRestartGroup.rememberedValue();
        if (rememberedValue6 == companion.getEmpty()) {
            rememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue6);
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState mutableState7 = (MutableState) rememberedValue6;
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue7 = startRestartGroup.rememberedValue();
        if (rememberedValue7 == companion.getEmpty()) {
            rememberedValue7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue7);
        }
        startRestartGroup.endReplaceableGroup();
        MutableState mutableState8 = (MutableState) rememberedValue7;
        ab value = adelieManagerCenterViewModel.qZoneInfo._state.getValue();
        if (value != null && !((Boolean) mutableState7.getValue()).booleanValue()) {
            mutableState4.setValue(createHighlightedString(value.f404131e, value.f404133h, value.f404134i));
            mutableState6.setValue(Integer.valueOf(value.f404130d));
            objectRef.element = value.f404132f;
        }
        Iterator<AdelieRedDotModule$Companion$RedDotInfo> it = adelieManagerCenterViewModel.redDotList._stateList.iterator();
        while (true) {
            if (!it.hasNext()) {
                mutableState = mutableState8;
                adelieRedDotModule$Companion$RedDotInfo = null;
                break;
            }
            AdelieRedDotModule$Companion$RedDotInfo next = it.next();
            mutableState = mutableState8;
            if (next.robotUin == adelieManagerCenterViewModel.robotUin) {
                adelieRedDotModule$Companion$RedDotInfo = next;
                break;
            }
            mutableState8 = mutableState;
        }
        final AdelieRedDotModule$Companion$RedDotInfo adelieRedDotModule$Companion$RedDotInfo2 = adelieRedDotModule$Companion$RedDotInfo;
        if (adelieRedDotModule$Companion$RedDotInfo2 != null && ((Boolean) mutableState.getValue()).booleanValue()) {
            mutableState4.setValue(createHighlightedString(adelieRedDotModule$Companion$RedDotInfo2.redDotText, 0, 0));
        }
        final MutableState mutableState9 = mutableState;
        QUIListSingleLineCommonViewKt.QUIListSingleLineCommonView(ViewEventPropUpdaterKt.g(ViewEventPropUpdaterKt.d(ComposeLayoutPropUpdaterKt.n(ModifiersKt.q(i.INSTANCE, c.a(8.0f)), 0.0f, 0.0f, 0.0f, 16.0f, 7, null), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.AdelieSpaceQualificationKt$AdelieSpaceQualification$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ClickParams clickParams) {
                final AdelieRedDotModule$Companion$RedDotInfo adelieRedDotModule$Companion$RedDotInfo3 = AdelieRedDotModule$Companion$RedDotInfo.this;
                final AdelieManagerCenterViewModel adelieManagerCenterViewModel2 = adelieManagerCenterViewModel;
                final Ref.ObjectRef<String> objectRef2 = objectRef;
                final MutableState<Boolean> mutableState10 = mutableState5;
                final MutableState<a> mutableState11 = mutableState4;
                final MutableState<Integer> mutableState12 = mutableState6;
                final MutableState<Boolean> mutableState13 = mutableState9;
                final MutableState<Boolean> mutableState14 = mutableState2;
                GuardFastClickKt.guardFastClick(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.AdelieSpaceQualificationKt$AdelieSpaceQualification$3.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        boolean booleanValue;
                        int intValue;
                        int intValue2;
                        String str;
                        booleanValue = ((Boolean) mutableState10.getValue()).booleanValue();
                        boolean z16 = booleanValue && AdelieRedDotModule$Companion$RedDotInfo.this != null;
                        String text = mutableState11.getValue().getText();
                        intValue = ((Number) mutableState12.getValue()).intValue();
                        AdelieSpaceQualificationKt.report("dt_clck", text, z16, intValue, adelieManagerCenterViewModel2.robotUid);
                        if (adelieManagerCenterViewModel2.bitOP(1)) {
                            QQKuiklyPlatformApi.Companion.qqToast("\u672a\u901a\u8fc7\u5ba1\u6838\u7684\u667a\u80fd\u4f53\u65e0\u6cd5\u4f7f\u7528", QToastMode.Warning);
                        } else {
                            MutableState<Boolean> mutableState15 = mutableState10;
                            Boolean bool = Boolean.FALSE;
                            mutableState15.setValue(bool);
                            AdelieRedDotModule$Companion$RedDotInfo adelieRedDotModule$Companion$RedDotInfo4 = AdelieRedDotModule$Companion$RedDotInfo.this;
                            if (adelieRedDotModule$Companion$RedDotInfo4 != null) {
                                final String str2 = adelieRedDotModule$Companion$RedDotInfo4.revokeId;
                                com.tencent.kuikly.core.manager.c cVar = com.tencent.kuikly.core.manager.c.f117352a;
                                AdelieRedDotModule adelieRedDotModule = (AdelieRedDotModule) cVar.g().acquireModule("AdelieRedDotModule");
                                adelieRedDotModule.getClass();
                                e eVar = new e();
                                eVar.v("revokeId", str2);
                                adelieRedDotModule.toNative(true, "revokeRedDot", eVar.toString(), new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$revokeRedDot$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(e eVar2) {
                                        e eVar3 = eVar2;
                                        KLog kLog = KLog.INSTANCE;
                                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("revokeRedDot revokeId:");
                                        m3.append(str2);
                                        m3.append(" ret:");
                                        m3.append(eVar3 != null ? Boolean.valueOf(eVar3.f("success")) : null);
                                        kLog.i("AdelieRedDotModule", m3.toString());
                                        return Unit.INSTANCE;
                                    }
                                }, false);
                                k kVar = (k) cVar.g().acquireModule("KRNotifyModule");
                                e eVar2 = new e();
                                eVar2.v("revokeId", adelieRedDotModule$Companion$RedDotInfo4.revokeId);
                                Unit unit = Unit.INSTANCE;
                                k.d(kVar, "adelie_revoke_red_dot", eVar2, false, 4, null);
                            }
                            mutableState13.setValue(bool);
                            intValue2 = ((Number) mutableState12.getValue()).intValue();
                            if (intValue2 == 0) {
                                if (objectRef2.element.length() > 0) {
                                    str = objectRef2.element;
                                } else {
                                    str = "https://h5.qzone.qq.com/agent-zone/introduce.html?_wwv=8192&_wv=16777216";
                                }
                                QQKuiklyPlatformApi.Companion companion2 = QQKuiklyPlatformApi.Companion;
                                QQKuiklyPlatformApi.Companion.openPage$default(str, false, 6);
                            } else if (intValue2 == 1) {
                                mutableState14.setValue(Boolean.TRUE);
                            } else if (intValue2 == 2) {
                                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("https://h5.qzone.qq.com/agent-zone/index.html?_wwv=8192&_wv=16777216&bot_uin=");
                                m3.append(adelieManagerCenterViewModel2.robotUin);
                                String sb5 = m3.toString();
                                if (objectRef2.element.length() > 0) {
                                    sb5 = objectRef2.element;
                                }
                                QQKuiklyPlatformApi.Companion companion3 = QQKuiklyPlatformApi.Companion;
                                QQKuiklyPlatformApi.Companion.openPage$default(sb5, false, 6);
                            }
                        }
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        }, 3, null), new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.AdelieSpaceQualificationKt$AdelieSpaceQualification$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                boolean booleanValue;
                int intValue;
                booleanValue = ((Boolean) mutableState5.getValue()).booleanValue();
                boolean z16 = booleanValue && AdelieRedDotModule$Companion$RedDotInfo.this != null;
                String text = mutableState4.getValue().getText();
                intValue = ((Number) mutableState6.getValue()).intValue();
                AdelieSpaceQualificationKt.report("dt_imp", text, z16, intValue, adelieManagerCenterViewModel.robotUid);
                return Unit.INSTANCE;
            }
        }), null, null, "\u7a7a\u95f4\u52a8\u6001", 0.3f, QUIToken.color$default("text_primary"), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -94657108, true, new Function3<i, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.AdelieSpaceQualificationKt$AdelieSpaceQualification$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(i iVar, Composer composer2, Integer num) {
                i iVar2 = iVar;
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-94657108, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.AdelieSpaceQualification.<anonymous> (AdelieSpaceQualification.kt:142)");
                }
                i j3 = ComposeLayoutPropUpdaterKt.j(iVar2, 0.0f, 1, null);
                a.d c16 = com.tencent.ntcompose.foundation.layout.base.a.f339245a.c();
                Alignment.Vertical c17 = Alignment.INSTANCE.c();
                final AdelieManagerCenterViewModel adelieManagerCenterViewModel2 = AdelieManagerCenterViewModel.this;
                final AdelieRedDotModule$Companion$RedDotInfo adelieRedDotModule$Companion$RedDotInfo3 = adelieRedDotModule$Companion$RedDotInfo2;
                final MutableState<bp3.a> mutableState10 = mutableState4;
                final MutableState<Boolean> mutableState11 = mutableState5;
                RowKt.a(j3, c16, c17, null, null, ComposableLambdaKt.composableLambda(composer3, -232254134, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.AdelieSpaceQualificationKt$AdelieSpaceQualification$5.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public final Unit invoke(n nVar, Composer composer4, Integer num2) {
                        boolean booleanValue;
                        Composer composer5 = composer4;
                        int intValue2 = num2.intValue();
                        if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                            composer5.skipToGroupEnd();
                        } else {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-232254134, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.AdelieSpaceQualification.<anonymous>.<anonymous> (AdelieSpaceQualification.kt:148)");
                            }
                            g value2 = AdelieManagerCenterViewModel.this.robotControlInfo._state.getValue();
                            if (!(value2 != null && value2.f404204e == 3)) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            } else {
                                i.Companion companion2 = i.INSTANCE;
                                RichTextKt.b(mutableState10.getValue(), ComposeLayoutPropUpdaterKt.j(companion2, 0.0f, 1, null), null, null, Float.valueOf(14.0f), null, bp3.c.INSTANCE.e(), new com.tencent.ntcompose.material.n("PingFang SC"), null, null, ai.f(ai.INSTANCE.d()), null, null, null, null, null, null, null, 1, null, null, null, null, null, null, null, null, null, composer5, (com.tencent.ntcompose.material.n.f339436b << 21) | 1597504, 100663296, 0, 268172076);
                                SpacerKt.a(ComposeLayoutPropUpdaterKt.w(companion2, 8.0f), composer5, 8, 0);
                                booleanValue = ((Boolean) mutableState11.getValue()).booleanValue();
                                if (booleanValue && adelieRedDotModule$Companion$RedDotInfo3 != null) {
                                    RedDotKt.RedDot(composer5, 0);
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }), composer3, 196680, 24);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                return Unit.INSTANCE;
            }
        }), null, null, 0.7f, startRestartGroup, 100953096, 48, 1734);
        startRestartGroup.startReplaceableGroup(1289077240);
        if (((Boolean) mutableState2.getValue()).booleanValue()) {
            String value2 = adelieManagerCenterViewModel.nickName._state.getValue();
            String value3 = adelieManagerCenterViewModel.avatarUrl._state.getValue();
            Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.AdelieSpaceQualificationKt$AdelieSpaceQualification$6
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    mutableState3.setValue(Boolean.TRUE);
                    final AdelieManagerCenterViewModel adelieManagerCenterViewModel2 = AdelieManagerCenterViewModel.this;
                    String str = adelieManagerCenterViewModel2.robotUid;
                    final MutableState<bp3.a> mutableState10 = mutableState4;
                    final MutableState<Integer> mutableState11 = mutableState6;
                    final MutableState<Boolean> mutableState12 = mutableState3;
                    final MutableState<Boolean> mutableState13 = mutableState2;
                    final MutableState<Boolean> mutableState14 = mutableState7;
                    BuildersKt.e(com.tencent.kuikly.core.coroutines.e.f117232d, null, null, new AdelieManagerCenterViewModel$openRobotQzone$1(str, new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.AdelieSpaceQualificationKt$AdelieSpaceQualification$6.1

                        /* compiled from: P */
                        @DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.AdelieSpaceQualificationKt$AdelieSpaceQualification$6$1$1", f = "AdelieSpaceQualification.kt", i = {}, l = {198}, m = "invokeSuspend", n = {}, s = {})
                        /* renamed from: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.AdelieSpaceQualificationKt$AdelieSpaceQualification$6$1$1, reason: invalid class name and collision with other inner class name */
                        /* loaded from: classes31.dex */
                        public final class C13801 extends SuspendLambda implements Function2<com.tencent.kuikly.core.coroutines.b, Continuation<? super Unit>, Object> {
                            public /* synthetic */ Object L$0;
                            public int label;

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                C13801 c13801 = new C13801(continuation);
                                c13801.L$0 = obj;
                                return c13801;
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(com.tencent.kuikly.core.coroutines.b bVar, Continuation<? super Unit> continuation) {
                                return ((C13801) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                Object coroutine_suspended;
                                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                int i3 = this.label;
                                if (i3 == 0) {
                                    ResultKt.throwOnFailure(obj);
                                    com.tencent.kuikly.core.coroutines.b bVar = (com.tencent.kuikly.core.coroutines.b) this.L$0;
                                    this.label = 1;
                                    if (BuildersKt.c(bVar, 1000, this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                } else if (i3 == 1) {
                                    ResultKt.throwOnFailure(obj);
                                } else {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ((QQKuiklyPlatformApi) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("QQKuiklyPlatformApi")).qqToast("\u5f00\u901a\u6210\u529f\uff0c\u5feb\u53bb\u53d1\u52a8\u6001\u5427", QToastMode.Success);
                                return Unit.INSTANCE;
                            }

                            public C13801(Continuation<? super C13801> continuation) {
                                super(2, continuation);
                            }
                        }

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Unit invoke(Integer num, String str2) {
                            int intValue = num.intValue();
                            KLog.INSTANCE.i("AdelieManagerPage", AdelieManagerCenterPage$DeleteAlertDialog$1$2$1$$ExternalSyntheticOutline0.m("openRobotQzone ", intValue, ", ", str2));
                            if (intValue == 0) {
                                mutableState10.setValue(AdelieSpaceQualificationKt.createHighlightedString("\u53bb\u53d1\u52a8\u6001", 0, 0));
                                mutableState11.setValue(2);
                                MutableState<Boolean> mutableState15 = mutableState12;
                                Boolean bool = Boolean.FALSE;
                                mutableState15.setValue(bool);
                                mutableState13.setValue(bool);
                                mutableState14.setValue(Boolean.TRUE);
                                String str3 = "https://h5.qzone.qq.com/agent-zone/index.html?_wwv=8192&_wv=16777216&bot_uin=" + AdelieManagerCenterViewModel.this.robotUin;
                                QQKuiklyPlatformApi.Companion companion2 = QQKuiklyPlatformApi.Companion;
                                QQKuiklyPlatformApi.Companion.openPage$default(str3, false, 6);
                                BuildersKt.e(com.tencent.kuikly.core.coroutines.e.f117232d, null, null, new C13801(null), 3, null);
                            } else {
                                ((QQKuiklyPlatformApi) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("QQKuiklyPlatformApi")).qqToast("\u5f00\u901a\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5\uff01", QToastMode.Warning);
                                MutableState<Boolean> mutableState16 = mutableState12;
                                Boolean bool2 = Boolean.FALSE;
                                mutableState16.setValue(bool2);
                                mutableState13.setValue(bool2);
                            }
                            return Unit.INSTANCE;
                        }
                    }, null), 3, null);
                    return Unit.INSTANCE;
                }
            };
            startRestartGroup.startReplaceableGroup(1157296644);
            boolean changed = startRestartGroup.changed(mutableState2);
            Object rememberedValue8 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                rememberedValue8 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.AdelieSpaceQualificationKt$AdelieSpaceQualification$7$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        mutableState2.setValue(Boolean.FALSE);
                        return Unit.INSTANCE;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue8);
            }
            startRestartGroup.endReplaceableGroup();
            OpenQZoneSheetKt.OpenQZoneSheet(value2, value3, function0, (Function0) rememberedValue8, startRestartGroup, 0, 0);
        }
        startRestartGroup.endReplaceableGroup();
        if (((Boolean) mutableState3.getValue()).booleanValue()) {
            FullScreenLoadingKt.FullScreenLoading(LoadingType.LOADING_WITH_BOTTOM, null, null, null, startRestartGroup, 6, 14);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.AdelieSpaceQualificationKt$AdelieSpaceQualification$8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                AdelieSpaceQualificationKt.AdelieSpaceQualification(AdelieManagerCenterViewModel.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
