package com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util.ReportKt;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.AdelieAudioRecordFrequencyView$endRecording$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.GuardFastClickKt;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.HotViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.AdelieCreativeCenterDataManager;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterViewModel;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerReport;
import com.tencent.hippykotlin.demo.pages.adelie.page.kuikly.manager.TroopInfo;
import com.tencent.hippykotlin.demo.pages.adelie.page.kuikly.manager.module.AdelieKuiklyManagerPageModule;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListSingleLineCommonViewKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.winkpublish.api.constant.FSPublishConstants;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.lazy.layout.a;
import com.tencent.ntcompose.material.LazyColumnKt;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import h25.g;
import h25.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import uo3.c;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class AdelieManagerListKt {
    public static final void VerticalSpacing(Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-1112779349);
        if (i3 == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1112779349, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.VerticalSpacing (AdelieManagerList.kt:76)");
            }
            SpacerKt.a(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 16.0f), startRestartGroup, 8, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.AdelieManagerListKt$VerticalSpacing$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                AdelieManagerListKt.VerticalSpacing(composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void access$AdelieManagerSection(final float f16, final Function3 function3, Composer composer, final int i3) {
        final int i16;
        Composer startRestartGroup = composer.startRestartGroup(744869031);
        if ((i3 & 14) == 0) {
            i16 = (startRestartGroup.changed(f16) ? 4 : 2) | i3;
        } else {
            i16 = i3;
        }
        if ((i3 & 112) == 0) {
            i16 |= startRestartGroup.changed(function3) ? 32 : 16;
        }
        if ((i16 & 91) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(744869031, i16, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.AdelieManagerSection (AdelieManagerList.kt:63)");
            }
            BoxKt.a(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(ModifiersKt.c(ModifiersKt.q(i.INSTANCE, c.a(8.0f)), QUIToken.color$default("fill_light_primary")), 0.0f, 1, null), f16), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -237074131, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.AdelieManagerListKt$AdelieManagerSection$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public final Unit invoke(b bVar, Composer composer2, Integer num) {
                    b bVar2 = bVar;
                    Composer composer3 = composer2;
                    int intValue = num.intValue();
                    if ((intValue & 14) == 0) {
                        intValue |= composer3.changed(bVar2) ? 4 : 2;
                    }
                    if ((intValue & 91) == 18 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                    } else {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-237074131, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.AdelieManagerSection.<anonymous> (AdelieManagerList.kt:68)");
                        }
                        function3.invoke(bVar2, composer3, Integer.valueOf((intValue & 14) | (i16 & 112)));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    return Unit.INSTANCE;
                }
            }), startRestartGroup, 3080, 6);
            VerticalSpacing(startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.AdelieManagerListKt$AdelieManagerSection$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                AdelieManagerListKt.access$AdelieManagerSection(f16, function3, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void AdelieManagerList(final AdelieManagerCenterViewModel adelieManagerCenterViewModel, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(1042163067);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1042163067, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.AdelieManagerList (AdelieManagerList.kt:38)");
        }
        LazyColumnKt.a(ModifiersKt.c(ComposeLayoutPropUpdaterKt.f(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 0.0f, 1, null), h.INSTANCE.j()), null, null, null, null, null, null, Boolean.FALSE, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 523983734, true, new Function3<a, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.AdelieManagerListKt$AdelieManagerList$1
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(a aVar, Composer composer2, Integer num) {
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(523983734, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.AdelieManagerList.<anonymous> (AdelieManagerList.kt:42)");
                }
                final AdelieManagerCenterViewModel adelieManagerCenterViewModel2 = AdelieManagerCenterViewModel.this;
                AdelieManagerListKt.access$AdelieManagerSection(149.0f, ComposableLambdaKt.composableLambda(composer3, 1255210931, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.AdelieManagerListKt$AdelieManagerList$1.1
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
                                ComposerKt.traceEventStart(1255210931, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.AdelieManagerList.<anonymous>.<anonymous> (AdelieManagerList.kt:43)");
                            }
                            UserInfoSectionKt.UserInfoSection(AdelieManagerCenterViewModel.this, composer5, 8);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }), composer3, 54);
                final AdelieManagerCenterViewModel adelieManagerCenterViewModel3 = AdelieManagerCenterViewModel.this;
                AdelieManagerListKt.access$AdelieManagerSection(268.0f, ComposableLambdaKt.composableLambda(composer3, 190115164, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.AdelieManagerListKt$AdelieManagerList$1.2
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
                                ComposerKt.traceEventStart(190115164, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.AdelieManagerList.<anonymous>.<anonymous> (AdelieManagerList.kt:46)");
                            }
                            UserDataSectionKt.UserDataSection(AdelieManagerCenterViewModel.this, composer5, 8);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }), composer3, 54);
                AdelieSpaceQualificationKt.AdelieSpaceQualification(AdelieManagerCenterViewModel.this, composer3, 8);
                AdelieManagerListKt.access$EditRobot(AdelieManagerCenterViewModel.this, composer3, 8);
                AdelieManagerListKt.access$RobotPermissionsSetting(AdelieManagerCenterViewModel.this, composer3, 8);
                AdelieManagerListKt.access$BindTroop(AdelieManagerCenterViewModel.this, composer3, 8);
                BindTroopTipKt.BindTroopTip(AdelieManagerCenterViewModel.this, composer3, 8);
                SpacerKt.a(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 32.0f), composer3, 8, 0);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.AdelieManagerListKt$AdelieManagerList$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                AdelieManagerListKt.AdelieManagerList(AdelieManagerCenterViewModel.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void access$BindTroop(final AdelieManagerCenterViewModel adelieManagerCenterViewModel, Composer composer, final int i3) {
        String str;
        String str2;
        String str3;
        String str4;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(200754475);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(200754475, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.BindTroop (AdelieManagerList.kt:83)");
        }
        e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_bas_agent_management");
        e m16 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_bas_agent_management");
        m16.v("agent_id", AdelieManagerReport.uid);
        m16.u("agent_uin", AdelieManagerReport.uin);
        m3.v("cur_pg", m16);
        m3.v("dt_eid", "em_bas_show_group_profile_card");
        u uVar = adelieManagerCenterViewModel.userIdentityInfo;
        m3.t("identity", uVar != null ? uVar.f404241d : 0);
        TroopInfo value = adelieManagerCenterViewModel.troopInfo._state.getValue();
        if (value == null || (str = value.getUin()) == null) {
            str = null;
        } else {
            if (str.length() == 0) {
                str = " ";
            }
        }
        m3.v(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID, str);
        ReportKt.reportCustomDTEvent("dt_imp", m3);
        boolean areEqual = Intrinsics.areEqual(adelieManagerCenterViewModel.troopSettingEnable._state.getValue(), Boolean.TRUE);
        if (!areEqual) {
            str2 = "";
        } else {
            str2 = QUIToken.INSTANCE.image("chevron_right", QUIToken.color$default("text_secondary"));
        }
        if (areEqual) {
            TroopInfo value2 = adelieManagerCenterViewModel.troopInfo._state.getValue();
            if (value2 == null || (str3 = value2.getName()) == null) {
                str4 = "";
                QUIListSingleLineCommonViewKt.QUIListSingleLineCommonView(ViewEventPropUpdaterKt.d(ComposeLayoutPropUpdaterKt.n(ModifiersKt.q(i.INSTANCE, c.a(8.0f)), 0.0f, 0.0f, 0.0f, 6.0f, 7, null), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.AdelieManagerListKt$BindTroop$2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ClickParams clickParams) {
                        final AdelieManagerCenterViewModel adelieManagerCenterViewModel2 = AdelieManagerCenterViewModel.this;
                        GuardFastClickKt.guardFastClick(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.AdelieManagerListKt$BindTroop$2.1
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                String str5;
                                TroopInfo value3;
                                e m17 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_bas_agent_management");
                                e m18 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_bas_agent_management");
                                m18.v("agent_id", AdelieManagerReport.uid);
                                m18.u("agent_uin", AdelieManagerReport.uin);
                                m17.v("cur_pg", m18);
                                AdelieManagerCenterViewModel adelieManagerCenterViewModel3 = AdelieManagerCenterViewModel.this;
                                m17.v("dt_eid", "em_bas_show_group_profile_card");
                                u uVar2 = adelieManagerCenterViewModel3.userIdentityInfo;
                                m17.t("identity", uVar2 != null ? uVar2.f404241d : 0);
                                TroopInfo value4 = adelieManagerCenterViewModel3.troopInfo._state.getValue();
                                if (value4 == null || (str5 = value4.getUin()) == null) {
                                    str5 = null;
                                } else {
                                    if (str5.length() == 0) {
                                        str5 = " ";
                                    }
                                }
                                m17.v(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID, str5);
                                ReportKt.reportCustomDTEvent("dt_clck", m17);
                                if (AdelieManagerCenterViewModel.this.bitOP(2)) {
                                    QQKuiklyPlatformApi.Companion.qqToast("\u672a\u901a\u8fc7\u5ba1\u6838\u7684\u667a\u80fd\u4f53\u65e0\u6cd5\u4f7f\u7528", QToastMode.Warning);
                                } else {
                                    final AdelieManagerCenterViewModel adelieManagerCenterViewModel4 = AdelieManagerCenterViewModel.this;
                                    if (adelieManagerCenterViewModel4.isFetchDataFinish() && !Intrinsics.areEqual(adelieManagerCenterViewModel4.troopSettingEnable._state.getValue(), Boolean.FALSE) && (value3 = adelieManagerCenterViewModel4.troopInfo._state.getValue()) != null) {
                                        e eVar = new e();
                                        com.tencent.kuikly.core.nvi.serialization.json.b bVar = new com.tencent.kuikly.core.nvi.serialization.json.b();
                                        if (value3.getUin().length() > 0) {
                                            bVar.t(value3.getUin());
                                        }
                                        eVar.t("maxSize", 1);
                                        eVar.v("troopUins", bVar);
                                        AdelieKuiklyManagerPageModule adelieKuiklyManagerPageModule = (AdelieKuiklyManagerPageModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("AdelieKuiklyManagerPageModule");
                                        Function1<e, Unit> function1 = new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.AdelieRobotBindTroop$openRobotBindTroop$1
                                            {
                                                super(1);
                                            }

                                            /* JADX WARN: Code restructure failed: missing block: B:28:0x00dd, code lost:
                                            
                                                if ((r1.length() > 0) == true) goto L31;
                                             */
                                            @Override // kotlin.jvm.functions.Function1
                                            /*
                                                Code decompiled incorrectly, please refer to instructions dump.
                                            */
                                            public final Unit invoke(e eVar2) {
                                                int collectionSizeOrDefault;
                                                List<String> emptyList;
                                                e eVar3 = eVar2;
                                                KLog kLog = KLog.INSTANCE;
                                                AdelieAudioRecordFrequencyView$endRecording$1$$ExternalSyntheticOutline0.m("adelie_bind_robot_troop ", eVar3, kLog, "AdelieRobotBindTroop");
                                                TroopInfo.Companion.getClass();
                                                ArrayList arrayList = new ArrayList();
                                                AdelieAudioRecordFrequencyView$endRecording$1$$ExternalSyntheticOutline0.m("parseTroopInfoList, param=", eVar3, kLog, "AdelieManagerPage");
                                                boolean z16 = true;
                                                if (eVar3 != null) {
                                                    e m19 = eVar3.m("data");
                                                    com.tencent.kuikly.core.nvi.serialization.json.b l3 = m19 != null ? m19.l("troopInfoList") : null;
                                                    kLog.i("AdelieManagerPage", "parseTroopInfoList, troopArray=" + l3);
                                                    if (l3 != null) {
                                                        int c16 = l3.c();
                                                        for (int i16 = 0; i16 < c16; i16++) {
                                                            e l16 = l3.l(i16);
                                                            if (l16 != null) {
                                                                String q16 = l16.q("uin", "");
                                                                String q17 = l16.q("name", "");
                                                                TroopInfo troopInfo = new TroopInfo();
                                                                ReadWriteProperty readWriteProperty = troopInfo.uin$delegate;
                                                                KProperty<?>[] kPropertyArr = TroopInfo.$$delegatedProperties;
                                                                readWriteProperty.setValue(troopInfo, kPropertyArr[0], q16);
                                                                troopInfo.name$delegate.setValue(troopInfo, kPropertyArr[1], q17);
                                                                arrayList.add(troopInfo);
                                                            }
                                                        }
                                                    }
                                                    KLog.INSTANCE.i("AdelieManagerPage", "parseTroopInfoList, troopList=" + arrayList);
                                                }
                                                final AdelieManagerCenterViewModel adelieManagerCenterViewModel5 = AdelieManagerCenterViewModel.this;
                                                KLog kLog2 = KLog.INSTANCE;
                                                kLog2.i("AdelieRobotBindTroop", "bindGroupChatToRobot troopList=" + arrayList);
                                                if (arrayList.isEmpty()) {
                                                    TroopInfo value5 = adelieManagerCenterViewModel5.troopInfo._state.getValue();
                                                    if (value5 != null && (r1 = value5.getUin()) != null) {
                                                    }
                                                    z16 = false;
                                                    if (z16) {
                                                        String str6 = adelieManagerCenterViewModel5.robotUid;
                                                        emptyList = CollectionsKt__CollectionsKt.emptyList();
                                                        adelieManagerCenterViewModel5.bindGroupChatToRobot(str6, emptyList, new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.AdelieRobotBindTroop$bindGroupChatToRobot$1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(Boolean bool) {
                                                                if (bool.booleanValue()) {
                                                                    AdelieManagerCenterViewModel.this.updateTroopInfo("", "");
                                                                    ((BridgeModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("HRBridgeModule")).qToast("\u5df2\u53d6\u6d88\uff0c\u8d44\u6599\u5361\u4e0d\u518d\u5c55\u793a", QToastMode.Success);
                                                                } else {
                                                                    ((BridgeModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("HRBridgeModule")).qToast("\u8bbe\u7f6e\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5\u4e00\u4e0b", QToastMode.Warning);
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                    } else {
                                                        kLog2.i("AdelieManagerPage", "bindGroupChatToRobot no need bind");
                                                    }
                                                } else {
                                                    final TroopInfo troopInfo2 = (TroopInfo) arrayList.get(0);
                                                    String uin = troopInfo2.getUin();
                                                    TroopInfo value6 = adelieManagerCenterViewModel5.troopInfo._state.getValue();
                                                    if (!Intrinsics.areEqual(uin, value6 != null ? value6.getUin() : null)) {
                                                        kLog2.i("AdelieManagerPage", "bindGroupChatToRobot need bind");
                                                        String str7 = adelieManagerCenterViewModel5.robotUid;
                                                        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
                                                        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                                                        Iterator it = arrayList.iterator();
                                                        while (it.hasNext()) {
                                                            arrayList2.add(((TroopInfo) it.next()).getUin());
                                                        }
                                                        adelieManagerCenterViewModel5.bindGroupChatToRobot(str7, arrayList2, new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.AdelieRobotBindTroop$bindGroupChatToRobot$3
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(Boolean bool) {
                                                                if (bool.booleanValue()) {
                                                                    AdelieManagerCenterViewModel.this.updateTroopInfo(troopInfo2.getUin(), troopInfo2.getName());
                                                                    ((BridgeModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("HRBridgeModule")).qToast("\u5c55\u793a\u6210\u529f\uff0c\u53ef\u5728\u8d44\u6599\u5361\u67e5\u770b", QToastMode.Success);
                                                                } else {
                                                                    ((BridgeModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("HRBridgeModule")).qToast("\u8bbe\u7f6e\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5\u4e00\u4e0b", QToastMode.Warning);
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                    } else {
                                                        kLog2.i("AdelieManagerPage", "bindGroupChatToRobot no need bind");
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        adelieKuiklyManagerPageModule.getClass();
                                        adelieKuiklyManagerPageModule.toNative(false, "openRobotBindTroop", eVar.toString(), function1, false);
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                }, 3, null), null, null, "\u5728\u8d44\u6599\u5361\u4e2d\u5c55\u793a\u7fa4\u804a", 0.0f, null, null, str4, null, str2, null, 0.0f, startRestartGroup, 3080, 0, 3446);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    return;
                }
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.AdelieManagerListKt$BindTroop$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Unit invoke(Composer composer2, Integer num) {
                        num.intValue();
                        AdelieManagerListKt.access$BindTroop(AdelieManagerCenterViewModel.this, composer2, i3 | 1);
                        return Unit.INSTANCE;
                    }
                });
                return;
            }
        } else {
            str3 = "\u6682\u4e0d\u53ef\u8bbe\u7f6e";
        }
        str4 = str3;
        QUIListSingleLineCommonViewKt.QUIListSingleLineCommonView(ViewEventPropUpdaterKt.d(ComposeLayoutPropUpdaterKt.n(ModifiersKt.q(i.INSTANCE, c.a(8.0f)), 0.0f, 0.0f, 0.0f, 6.0f, 7, null), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.AdelieManagerListKt$BindTroop$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ClickParams clickParams) {
                final AdelieManagerCenterViewModel adelieManagerCenterViewModel2 = AdelieManagerCenterViewModel.this;
                GuardFastClickKt.guardFastClick(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.AdelieManagerListKt$BindTroop$2.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        String str5;
                        TroopInfo value3;
                        e m17 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_bas_agent_management");
                        e m18 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_bas_agent_management");
                        m18.v("agent_id", AdelieManagerReport.uid);
                        m18.u("agent_uin", AdelieManagerReport.uin);
                        m17.v("cur_pg", m18);
                        AdelieManagerCenterViewModel adelieManagerCenterViewModel3 = AdelieManagerCenterViewModel.this;
                        m17.v("dt_eid", "em_bas_show_group_profile_card");
                        u uVar2 = adelieManagerCenterViewModel3.userIdentityInfo;
                        m17.t("identity", uVar2 != null ? uVar2.f404241d : 0);
                        TroopInfo value4 = adelieManagerCenterViewModel3.troopInfo._state.getValue();
                        if (value4 == null || (str5 = value4.getUin()) == null) {
                            str5 = null;
                        } else {
                            if (str5.length() == 0) {
                                str5 = " ";
                            }
                        }
                        m17.v(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID, str5);
                        ReportKt.reportCustomDTEvent("dt_clck", m17);
                        if (AdelieManagerCenterViewModel.this.bitOP(2)) {
                            QQKuiklyPlatformApi.Companion.qqToast("\u672a\u901a\u8fc7\u5ba1\u6838\u7684\u667a\u80fd\u4f53\u65e0\u6cd5\u4f7f\u7528", QToastMode.Warning);
                        } else {
                            final AdelieManagerCenterViewModel adelieManagerCenterViewModel4 = AdelieManagerCenterViewModel.this;
                            if (adelieManagerCenterViewModel4.isFetchDataFinish() && !Intrinsics.areEqual(adelieManagerCenterViewModel4.troopSettingEnable._state.getValue(), Boolean.FALSE) && (value3 = adelieManagerCenterViewModel4.troopInfo._state.getValue()) != null) {
                                e eVar = new e();
                                com.tencent.kuikly.core.nvi.serialization.json.b bVar = new com.tencent.kuikly.core.nvi.serialization.json.b();
                                if (value3.getUin().length() > 0) {
                                    bVar.t(value3.getUin());
                                }
                                eVar.t("maxSize", 1);
                                eVar.v("troopUins", bVar);
                                AdelieKuiklyManagerPageModule adelieKuiklyManagerPageModule = (AdelieKuiklyManagerPageModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("AdelieKuiklyManagerPageModule");
                                Function1<e, Unit> function1 = new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.AdelieRobotBindTroop$openRobotBindTroop$1
                                    {
                                        super(1);
                                    }

                                    /* JADX WARN: Code restructure failed: missing block: B:28:0x00dd, code lost:
                                    
                                        if ((r1.length() > 0) == true) goto L31;
                                     */
                                    @Override // kotlin.jvm.functions.Function1
                                    /*
                                        Code decompiled incorrectly, please refer to instructions dump.
                                    */
                                    public final Unit invoke(e eVar2) {
                                        int collectionSizeOrDefault;
                                        List<String> emptyList;
                                        e eVar3 = eVar2;
                                        KLog kLog = KLog.INSTANCE;
                                        AdelieAudioRecordFrequencyView$endRecording$1$$ExternalSyntheticOutline0.m("adelie_bind_robot_troop ", eVar3, kLog, "AdelieRobotBindTroop");
                                        TroopInfo.Companion.getClass();
                                        ArrayList arrayList = new ArrayList();
                                        AdelieAudioRecordFrequencyView$endRecording$1$$ExternalSyntheticOutline0.m("parseTroopInfoList, param=", eVar3, kLog, "AdelieManagerPage");
                                        boolean z16 = true;
                                        if (eVar3 != null) {
                                            e m19 = eVar3.m("data");
                                            com.tencent.kuikly.core.nvi.serialization.json.b l3 = m19 != null ? m19.l("troopInfoList") : null;
                                            kLog.i("AdelieManagerPage", "parseTroopInfoList, troopArray=" + l3);
                                            if (l3 != null) {
                                                int c16 = l3.c();
                                                for (int i16 = 0; i16 < c16; i16++) {
                                                    e l16 = l3.l(i16);
                                                    if (l16 != null) {
                                                        String q16 = l16.q("uin", "");
                                                        String q17 = l16.q("name", "");
                                                        TroopInfo troopInfo = new TroopInfo();
                                                        ReadWriteProperty readWriteProperty = troopInfo.uin$delegate;
                                                        KProperty<?>[] kPropertyArr = TroopInfo.$$delegatedProperties;
                                                        readWriteProperty.setValue(troopInfo, kPropertyArr[0], q16);
                                                        troopInfo.name$delegate.setValue(troopInfo, kPropertyArr[1], q17);
                                                        arrayList.add(troopInfo);
                                                    }
                                                }
                                            }
                                            KLog.INSTANCE.i("AdelieManagerPage", "parseTroopInfoList, troopList=" + arrayList);
                                        }
                                        final AdelieManagerCenterViewModel adelieManagerCenterViewModel5 = AdelieManagerCenterViewModel.this;
                                        KLog kLog2 = KLog.INSTANCE;
                                        kLog2.i("AdelieRobotBindTroop", "bindGroupChatToRobot troopList=" + arrayList);
                                        if (arrayList.isEmpty()) {
                                            TroopInfo value5 = adelieManagerCenterViewModel5.troopInfo._state.getValue();
                                            if (value5 != null && (r1 = value5.getUin()) != null) {
                                            }
                                            z16 = false;
                                            if (z16) {
                                                String str6 = adelieManagerCenterViewModel5.robotUid;
                                                emptyList = CollectionsKt__CollectionsKt.emptyList();
                                                adelieManagerCenterViewModel5.bindGroupChatToRobot(str6, emptyList, new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.AdelieRobotBindTroop$bindGroupChatToRobot$1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(Boolean bool) {
                                                        if (bool.booleanValue()) {
                                                            AdelieManagerCenterViewModel.this.updateTroopInfo("", "");
                                                            ((BridgeModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("HRBridgeModule")).qToast("\u5df2\u53d6\u6d88\uff0c\u8d44\u6599\u5361\u4e0d\u518d\u5c55\u793a", QToastMode.Success);
                                                        } else {
                                                            ((BridgeModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("HRBridgeModule")).qToast("\u8bbe\u7f6e\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5\u4e00\u4e0b", QToastMode.Warning);
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                            } else {
                                                kLog2.i("AdelieManagerPage", "bindGroupChatToRobot no need bind");
                                            }
                                        } else {
                                            final TroopInfo troopInfo2 = (TroopInfo) arrayList.get(0);
                                            String uin = troopInfo2.getUin();
                                            TroopInfo value6 = adelieManagerCenterViewModel5.troopInfo._state.getValue();
                                            if (!Intrinsics.areEqual(uin, value6 != null ? value6.getUin() : null)) {
                                                kLog2.i("AdelieManagerPage", "bindGroupChatToRobot need bind");
                                                String str7 = adelieManagerCenterViewModel5.robotUid;
                                                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
                                                ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                                                Iterator it = arrayList.iterator();
                                                while (it.hasNext()) {
                                                    arrayList2.add(((TroopInfo) it.next()).getUin());
                                                }
                                                adelieManagerCenterViewModel5.bindGroupChatToRobot(str7, arrayList2, new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.AdelieRobotBindTroop$bindGroupChatToRobot$3
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(Boolean bool) {
                                                        if (bool.booleanValue()) {
                                                            AdelieManagerCenterViewModel.this.updateTroopInfo(troopInfo2.getUin(), troopInfo2.getName());
                                                            ((BridgeModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("HRBridgeModule")).qToast("\u5c55\u793a\u6210\u529f\uff0c\u53ef\u5728\u8d44\u6599\u5361\u67e5\u770b", QToastMode.Success);
                                                        } else {
                                                            ((BridgeModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("HRBridgeModule")).qToast("\u8bbe\u7f6e\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5\u4e00\u4e0b", QToastMode.Warning);
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                            } else {
                                                kLog2.i("AdelieManagerPage", "bindGroupChatToRobot no need bind");
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                };
                                adelieKuiklyManagerPageModule.getClass();
                                adelieKuiklyManagerPageModule.toNative(false, "openRobotBindTroop", eVar.toString(), function1, false);
                            }
                        }
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        }, 3, null), null, null, "\u5728\u8d44\u6599\u5361\u4e2d\u5c55\u793a\u7fa4\u804a", 0.0f, null, null, str4, null, str2, null, 0.0f, startRestartGroup, 3080, 0, 3446);
        if (ComposerKt.isTraceInProgress()) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    public static final void access$EditRobot(final AdelieManagerCenterViewModel adelieManagerCenterViewModel, Composer composer, final int i3) {
        g value;
        String str;
        Composer startRestartGroup = composer.startRestartGroup(882440470);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(882440470, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.EditRobot (AdelieManagerList.kt:117)");
        }
        e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_bas_agent_management");
        e m16 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_bas_agent_management");
        m16.v("agent_id", AdelieManagerReport.uid);
        m16.u("agent_uin", AdelieManagerReport.uin);
        m3.v("cur_pg", m16);
        m3.v("dt_eid", "em_bas_editing_agent");
        ReportKt.reportCustomDTEvent("dt_imp", m3);
        g value2 = adelieManagerCenterViewModel.robotControlInfo._state.getValue();
        QUIListSingleLineCommonViewKt.QUIListSingleLineCommonView(ViewEventPropUpdaterKt.d(ComposeLayoutPropUpdaterKt.n(ModifiersKt.q(i.INSTANCE, c.a(8.0f)), 0.0f, 0.0f, 0.0f, 16.0f, 7, null), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.AdelieManagerListKt$EditRobot$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ClickParams clickParams) {
                final AdelieManagerCenterViewModel adelieManagerCenterViewModel2 = AdelieManagerCenterViewModel.this;
                GuardFastClickKt.guardFastClick(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.AdelieManagerListKt$EditRobot$2.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        e m17 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_bas_agent_management");
                        e m18 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_bas_agent_management");
                        m18.v("agent_id", AdelieManagerReport.uid);
                        m18.u("agent_uin", AdelieManagerReport.uin);
                        m17.v("cur_pg", m18);
                        m17.v("dt_eid", "em_bas_editing_agent");
                        ReportKt.reportCustomDTEvent("dt_clck", m17);
                        if (AdelieManagerCenterViewModel.this.bitOP(0)) {
                            QQKuiklyPlatformApi.Companion.qqToast("\u672a\u901a\u8fc7\u5ba1\u6838\u7684\u667a\u80fd\u4f53\u65e0\u6cd5\u4f7f\u7528", QToastMode.Warning);
                        } else if (AdelieManagerCenterViewModel.this.isFetchDataFinish()) {
                            QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                            StringBuilder m19 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("mqqapi://adelie/edit?version=1&src_type=app&referer=manager_page&pageData=");
                            e eVar = new e();
                            eVar.v("uid", AdelieManagerCenterViewModel.this.robotUid);
                            Unit unit = Unit.INSTANCE;
                            m19.append(eVar);
                            QQKuiklyPlatformApi.Companion.openPage$default(m19.toString(), false, 6);
                        }
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        }, 3, null), null, null, "\u7f16\u8f91\u667a\u80fd\u4f53", 0.0f, null, null, ((value2 != null ? value2.f404204e : 3) == 3 || (value = adelieManagerCenterViewModel.robotControlInfo._state.getValue()) == null || (str = value.f404205f) == null) ? "" : str, null, null, null, 0.0f, startRestartGroup, 3080, 0, 3958);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.AdelieManagerListKt$EditRobot$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                AdelieManagerListKt.access$EditRobot(AdelieManagerCenterViewModel.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void access$RobotPermissionsSetting(final AdelieManagerCenterViewModel adelieManagerCenterViewModel, Composer composer, final int i3) {
        String str;
        String str2;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-1271531188);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1271531188, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.RobotPermissionsSetting (AdelieManagerList.kt:151)");
        }
        e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_bas_agent_management");
        e m16 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_bas_agent_management");
        m16.v("agent_id", AdelieManagerReport.uid);
        m16.u("agent_uin", AdelieManagerReport.uin);
        m3.v("cur_pg", m16);
        m3.v("dt_eid", "em_bas_permission_setting");
        ReportKt.reportCustomDTEvent("dt_imp", m3);
        Integer value = adelieManagerCenterViewModel.permissionType._state.getValue();
        if (value == null || value.intValue() != 0) {
            if (value != null && value.intValue() == 1) {
                str = "\u516c\u5f00\u53ef\u89c1";
            } else if (value != null && value.intValue() == 2) {
                str = "\u4ec5\u5206\u4eab\u53ef\u89c1";
            }
            str2 = str;
            QUIListSingleLineCommonViewKt.QUIListSingleLineCommonView(ViewEventPropUpdaterKt.d(ComposeLayoutPropUpdaterKt.n(ModifiersKt.q(i.INSTANCE, c.a(8.0f)), 0.0f, 0.0f, 0.0f, 16.0f, 7, null), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.AdelieManagerListKt$RobotPermissionsSetting$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(ClickParams clickParams) {
                    final AdelieManagerCenterViewModel adelieManagerCenterViewModel2 = AdelieManagerCenterViewModel.this;
                    GuardFastClickKt.guardFastClick(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.AdelieManagerListKt$RobotPermissionsSetting$2.1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Unit invoke() {
                            e m17 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_bas_agent_management");
                            e m18 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_bas_agent_management");
                            m18.v("agent_id", AdelieManagerReport.uid);
                            m18.u("agent_uin", AdelieManagerReport.uin);
                            m17.v("cur_pg", m18);
                            m17.v("dt_eid", "em_bas_permission_setting");
                            ReportKt.reportCustomDTEvent("dt_clck", m17);
                            StringBuilder m19 = HotViewKt$$ExternalSyntheticOutline0.m(AdelieCreativeCenterDataManager.managerSchemeConfig, "&page_name=adelie_manager_permissions_setting_page&type=");
                            m19.append(AdelieManagerCenterViewModel.this.permissionType._state.getValue());
                            m19.append("&robot_uin=");
                            m19.append(AdelieManagerReport.uin);
                            String sb5 = m19.toString();
                            QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                            QQKuiklyPlatformApi.Companion.openPage$default(sb5, false, 6);
                            return Unit.INSTANCE;
                        }
                    });
                    return Unit.INSTANCE;
                }
            }, 3, null), null, null, "\u6743\u9650\u8bbe\u7f6e", 0.0f, null, null, str2, null, null, null, 0.0f, startRestartGroup, 3080, 0, 3958);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
                return;
            }
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.AdelieManagerListKt$RobotPermissionsSetting$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    AdelieManagerListKt.access$RobotPermissionsSetting(AdelieManagerCenterViewModel.this, composer2, i3 | 1);
                    return Unit.INSTANCE;
                }
            });
            return;
        }
        str2 = "";
        QUIListSingleLineCommonViewKt.QUIListSingleLineCommonView(ViewEventPropUpdaterKt.d(ComposeLayoutPropUpdaterKt.n(ModifiersKt.q(i.INSTANCE, c.a(8.0f)), 0.0f, 0.0f, 0.0f, 16.0f, 7, null), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.AdelieManagerListKt$RobotPermissionsSetting$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ClickParams clickParams) {
                final AdelieManagerCenterViewModel adelieManagerCenterViewModel2 = AdelieManagerCenterViewModel.this;
                GuardFastClickKt.guardFastClick(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.AdelieManagerListKt$RobotPermissionsSetting$2.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        e m17 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_bas_agent_management");
                        e m18 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_bas_agent_management");
                        m18.v("agent_id", AdelieManagerReport.uid);
                        m18.u("agent_uin", AdelieManagerReport.uin);
                        m17.v("cur_pg", m18);
                        m17.v("dt_eid", "em_bas_permission_setting");
                        ReportKt.reportCustomDTEvent("dt_clck", m17);
                        StringBuilder m19 = HotViewKt$$ExternalSyntheticOutline0.m(AdelieCreativeCenterDataManager.managerSchemeConfig, "&page_name=adelie_manager_permissions_setting_page&type=");
                        m19.append(AdelieManagerCenterViewModel.this.permissionType._state.getValue());
                        m19.append("&robot_uin=");
                        m19.append(AdelieManagerReport.uin);
                        String sb5 = m19.toString();
                        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                        QQKuiklyPlatformApi.Companion.openPage$default(sb5, false, 6);
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        }, 3, null), null, null, "\u6743\u9650\u8bbe\u7f6e", 0.0f, null, null, str2, null, null, null, 0.0f, startRestartGroup, 3080, 0, 3958);
        if (ComposerKt.isTraceInProgress()) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}
