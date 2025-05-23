package com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.gcloudsdk.gcloud.voice.GCloudVoiceErrorCode;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.compose.page.BaseComposePager;
import com.tencent.hippykotlin.demo.pages.adelie.common.compose.util.StateHolder;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util.ReportKt;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.CategoryListFooterKt$CategoryListFooter$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterViewModel;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.AdelieManagerListKt;
import com.tencent.hippykotlin.demo.pages.adelie.page.kuikly.manager.module.AdelieKuiklyManagerPageModule;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIActionSheetItem;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIActionSheetKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIAlertDialogItem;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIAlertDialogKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.view.adelie.AdelieScanningLightView;
import com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.CenterContentConfig;
import com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.LeftContentConfig;
import com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.RightContentConfig;
import com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.RightContentData;
import com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.SecNavBarKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQUIModule;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUITokenThemeMode;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.coroutines.BuildersKt;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.Module;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.g;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.ntcompose.activity.a;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import h25.aq;
import h25.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class AdelieManagerCenterPage extends BaseComposePager {
    public static final /* synthetic */ int $r8$clinit = 0;
    public String editRobotEventCallbackRef;
    public String permissionTypeCallbackRef;
    public final StateHolder<Boolean> showActionSheet;
    public final StateHolder<Boolean> showDeleteAlert;
    public final Lazy viewModel$delegate;

    public AdelieManagerCenterPage() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<AdelieManagerCenterViewModel>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterPage$viewModel$2
            @Override // kotlin.jvm.functions.Function0
            public final AdelieManagerCenterViewModel invoke() {
                return new AdelieManagerCenterViewModel();
            }
        });
        this.viewModel$delegate = lazy;
        Boolean bool = Boolean.FALSE;
        this.showActionSheet = new StateHolder<>(bool);
        this.showDeleteAlert = new StateHolder<>(bool);
    }

    public static final void access$DeleteAlertDialog(final AdelieManagerCenterPage adelieManagerCenterPage, Composer composer, final int i3) {
        adelieManagerCenterPage.getClass();
        Composer startRestartGroup = composer.startRestartGroup(1492875223);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1492875223, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterPage.DeleteAlertDialog (AdelieManagerCenterPage.kt:303)");
        }
        Boolean value = adelieManagerCenterPage.showDeleteAlert._state.getValue();
        if (value != null) {
            QUIAlertDialogKt.QUIAlertDialog(value.booleanValue(), null, "\u5220\u9664\u540e\uff0c\u667a\u80fd\u4f53\u76f8\u5173\u7684\u6570\u636e\u5c06\u4e0d\u4f1a\u4fdd\u7559\uff0c\u4efb\u4f55\u4eba\u5c06\u65e0\u6cd5\u7ee7\u7eed\u4f7f\u7528\u6b64\u667a\u80fd\u4f53\uff0c\u786e\u8ba4\u5220\u9664\u5417\uff1f", null, new QUIAlertDialogItem[]{QUIAlertDialogKt.QUIAlertDialogNormalTextItem("\u53d6\u6d88", new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterPage$DeleteAlertDialog$1$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    StateHolder<Boolean> stateHolder = AdelieManagerCenterPage.this.showDeleteAlert;
                    stateHolder._state.setValue(Boolean.FALSE);
                    e eVar = new e();
                    eVar.v("dt_pgid", "pg_bas_agent_management");
                    e eVar2 = new e();
                    eVar2.v("dt_pgid", "pg_bas_agent_management");
                    eVar2.v("agent_id", AdelieManagerReport.uid);
                    eVar2.u("agent_uin", AdelieManagerReport.uin);
                    eVar.v("cur_pg", eVar2);
                    eVar.v("dt_eid", "em_bas_cancel");
                    ReportKt.reportCustomDTEvent("dt_clck", eVar);
                    return Unit.INSTANCE;
                }
            }), QUIAlertDialogKt.QUIAlertDialogWarningTextItem("\u786e\u5b9a\u5220\u9664", new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterPage$DeleteAlertDialog$1$2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    StateHolder<Boolean> stateHolder = AdelieManagerCenterPage.this.showDeleteAlert;
                    stateHolder._state.setValue(Boolean.FALSE);
                    if (!AdelieManagerCenterPage.this.getViewModel().isFetchDataFinish()) {
                        ((BridgeModule) c.f117352a.g().acquireModule("HRBridgeModule")).qToast("\u9875\u9762\u52a0\u8f7d\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5", QToastMode.Warning);
                    } else {
                        AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("deleteRobot "), AdelieManagerCenterPage.this.getViewModel().robotUid, KLog.INSTANCE, "AdelieManagerPage");
                        AdelieManagerCenterViewModel viewModel = AdelieManagerCenterPage.this.getViewModel();
                        String str = AdelieManagerCenterPage.this.getViewModel().robotUid;
                        final AdelieManagerCenterPage adelieManagerCenterPage2 = AdelieManagerCenterPage.this;
                        Function2<Integer, String, Unit> function2 = new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterPage$DeleteAlertDialog$1$2.1
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Unit invoke(Integer num, String str2) {
                                int intValue = num.intValue();
                                String str3 = str2;
                                KLog.INSTANCE.i("AdelieManagerPage", AdelieManagerCenterPage$DeleteAlertDialog$1$2$1$$ExternalSyntheticOutline0.m("deleteRobot ", intValue, ", ", str3));
                                if (intValue == 0) {
                                    c cVar = c.f117352a;
                                    ((BridgeModule) cVar.g().acquireModule("HRBridgeModule")).qToast("\u5220\u9664\u6210\u529f", QToastMode.Success);
                                    k kVar = (k) cVar.g().acquireModule("KRNotifyModule");
                                    e eVar = new e();
                                    AdelieManagerCenterPage adelieManagerCenterPage3 = AdelieManagerCenterPage.this;
                                    int i16 = AdelieManagerCenterPage.$r8$clinit;
                                    eVar.v("uid", adelieManagerCenterPage3.getViewModel().robotUid);
                                    Unit unit = Unit.INSTANCE;
                                    k.d(kVar, "adelie_delete_robot", eVar, false, 4, null);
                                    QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                    QQKuiklyPlatformApi.Companion.closePage$default();
                                } else if (intValue == 30099) {
                                    QQUIModule qQUIModule = (QQUIModule) c.f117352a.g().acquireModule("QQUIModule");
                                    final AdelieManagerCenterPage adelieManagerCenterPage4 = AdelieManagerCenterPage.this;
                                    qQUIModule.openAlertDialog("", "\u8be5\u667a\u80fd\u4f53\u5df2\u5220\u9664\uff0c\u65e0\u6cd5\u518d\u6b21\u8fdb\u884c\u7f16\u8f91", "\u6211\u77e5\u9053\u4e86", "", "", false, new Function2<Boolean, Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterPage.DeleteAlertDialog.1.2.1.2
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public final Unit invoke(Boolean bool, Boolean bool2) {
                                            bool.booleanValue();
                                            bool2.booleanValue();
                                            k kVar2 = (k) c.f117352a.g().acquireModule("KRNotifyModule");
                                            e eVar2 = new e();
                                            AdelieManagerCenterPage adelieManagerCenterPage5 = AdelieManagerCenterPage.this;
                                            int i17 = AdelieManagerCenterPage.$r8$clinit;
                                            eVar2.v("uid", adelieManagerCenterPage5.getViewModel().robotUid);
                                            Unit unit2 = Unit.INSTANCE;
                                            k.d(kVar2, "adelie_delete_robot", eVar2, false, 4, null);
                                            QQKuiklyPlatformApi.Companion companion2 = QQKuiklyPlatformApi.Companion;
                                            QQKuiklyPlatformApi.Companion.closePage$default();
                                            return Unit.INSTANCE;
                                        }
                                    });
                                } else if (intValue < 10000) {
                                    ((BridgeModule) c.f117352a.g().acquireModule("HRBridgeModule")).qToast("\u5220\u9664\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5\uff01", QToastMode.Warning);
                                } else {
                                    if (intValue > 10000) {
                                        if (str3.length() > 0) {
                                            ((BridgeModule) c.f117352a.g().acquireModule("HRBridgeModule")).qToast(str3, QToastMode.Warning);
                                        }
                                    }
                                    ((BridgeModule) c.f117352a.g().acquireModule("HRBridgeModule")).qToast("\u5220\u9664\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5\uff01", QToastMode.Warning);
                                }
                                return Unit.INSTANCE;
                            }
                        };
                        viewModel.getClass();
                        BuildersKt.e(com.tencent.kuikly.core.coroutines.e.f117232d, null, null, new AdelieManagerCenterViewModel$deleteRobot$1(str, function2, null), 3, null);
                        e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_bas_agent_management");
                        e m16 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_bas_agent_management");
                        m16.v("agent_id", AdelieManagerReport.uid);
                        m16.u("agent_uin", AdelieManagerReport.uin);
                        m3.v("cur_pg", m16);
                        m3.v("dt_eid", "em_bas_delete");
                        ReportKt.reportCustomDTEvent("dt_clck", m3);
                    }
                    return Unit.INSTANCE;
                }
            })}, null, null, startRestartGroup, 33152, 106);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterPage$DeleteAlertDialog$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                AdelieManagerCenterPage.access$DeleteAlertDialog(AdelieManagerCenterPage.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void access$contentContainer(final AdelieManagerCenterPage adelieManagerCenterPage, final float f16, final Function3 function3, Composer composer, final int i3) {
        final int i16;
        adelieManagerCenterPage.getClass();
        Composer startRestartGroup = composer.startRestartGroup(904523313);
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
                ComposerKt.traceEventStart(904523313, i16, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterPage.contentContainer (AdelieManagerCenterPage.kt:236)");
            }
            BoxKt.a(ComposeLayoutPropUpdaterKt.m(ComposeLayoutPropUpdaterKt.j(ComposeLayoutPropUpdaterKt.f(ModifiersKt.c(i.INSTANCE, h.INSTANCE.j()), 0.0f, 1, null), 0.0f, 1, null), 16.0f, f16, 16.0f, 0.0f), Alignment.Center, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1413844459, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterPage$contentContainer$1
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
                            ComposerKt.traceEventStart(1413844459, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterPage.contentContainer.<anonymous> (AdelieManagerCenterPage.kt:245)");
                        }
                        function3.invoke(bVar2, composer3, Integer.valueOf((intValue & 14) | (i16 & 112)));
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
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterPage$contentContainer$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                AdelieManagerCenterPage.access$contentContainer(AdelieManagerCenterPage.this, f16, function3, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void access$showRejectedDialog(final AdelieManagerCenterPage adelieManagerCenterPage, Composer composer, final int i3) {
        adelieManagerCenterPage.getClass();
        Composer startRestartGroup = composer.startRestartGroup(-583595919);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-583595919, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterPage.showRejectedDialog (AdelieManagerCenterPage.kt:140)");
        }
        if (Intrinsics.areEqual(adelieManagerCenterPage.getViewModel().showRejectDialog._state.getValue(), Boolean.TRUE)) {
            QUIAlertDialogKt.QUIAlertDialog(true, null, "\u667a\u80fd\u4f53\u5df2\u4e0b\u67b6\uff0c\u8bf7\u9075\u5b88\u793e\u533a\u89c4\u8303", null, new QUIAlertDialogItem[]{QUIAlertDialogKt.QUIAlertDialogNormalTextItem("\u6211\u77e5\u9053\u4e86", new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterPage$showRejectedDialog$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    StateHolder<Boolean> stateHolder = AdelieManagerCenterPage.this.getViewModel().showRejectDialog;
                    stateHolder._state.setValue(Boolean.FALSE);
                    QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                    QQKuiklyPlatformApi.Companion.closePage$default();
                    return Unit.INSTANCE;
                }
            })}, null, null, startRestartGroup, 33158, 106);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterPage$showRejectedDialog$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                AdelieManagerCenterPage.access$showRejectedDialog(AdelieManagerCenterPage.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0016, code lost:
    
        r1 = kotlin.collections.MapsKt__MapsKt.plus(r1, r0);
     */
    @Override // com.tencent.hippykotlin.demo.pages.adelie.common.compose.page.BaseComposePager, com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.BaseComponentActivity, com.tencent.ntcompose.activity.ComponentActivity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Map<String, Module> createExternalModules() {
        Map<String, Module> plus;
        HashMap hashMap = new HashMap();
        hashMap.put("AdelieKuiklyManagerPageModule", new AdelieKuiklyManagerPageModule());
        Map<String, Module> createExternalModules = super.createExternalModules();
        return (createExternalModules == null || plus == null) ? hashMap : plus;
    }

    public final String getUid$qecommerce_biz_release(g gVar) {
        String p16 = gVar.n().p("uid");
        return p16.length() == 0 ? "u_rCt3JOZbjZheh5ZJNa6xaw" : p16;
    }

    public final AdelieManagerCenterViewModel getViewModel() {
        return (AdelieManagerCenterViewModel) this.viewModel$delegate.getValue();
    }

    @Override // com.tencent.ntcompose.activity.ComponentActivity
    public final void onDestroy() {
        super.onDestroy();
        String str = this.editRobotEventCallbackRef;
        if (str != null) {
            ((k) c.f117352a.g().acquireModule("KRNotifyModule")).e("adelie_edit_robot", str);
        }
        String str2 = this.permissionTypeCallbackRef;
        if (str2 != null) {
            ((k) c.f117352a.g().acquireModule("KRNotifyModule")).e("adelie_manager_permission_type", str2);
        }
    }

    @Override // com.tencent.ntcompose.activity.ComponentActivity
    public final void onPause() {
        super.onPause();
        e eVar = new e();
        eVar.v("dt_pgid", "pg_bas_agent_management");
        eVar.v("agent_id", AdelieManagerReport.uid);
        eVar.u("agent_uin", AdelieManagerReport.uin);
        ReportKt.reportCustomDTEvent("dt_pgout", eVar);
    }

    @Override // com.tencent.ntcompose.activity.ComponentActivity
    public final void onResume() {
        super.onResume();
        e eVar = new e();
        eVar.v("dt_pgid", "pg_bas_agent_management");
        eVar.v("agent_id", AdelieManagerReport.uid);
        eVar.u("agent_uin", AdelieManagerReport.uin);
        ReportKt.reportCustomDTEvent("dt_pgin", eVar);
    }

    @Override // com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.BaseComponentActivity
    public final QUITokenThemeMode quiTokenThemeMode() {
        return QUITokenThemeMode.ONLY_DAY_AND_NIGHT;
    }

    public static final void access$setBkgView(final AdelieManagerCenterPage adelieManagerCenterPage, Composer composer, final int i3) {
        String str;
        adelieManagerCenterPage.getClass();
        Composer startRestartGroup = composer.startRestartGroup(-301663693);
        if ((i3 & 1) == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-301663693, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterPage.setBkgView (AdelieManagerCenterPage.kt:154)");
            }
            if (QUIToken.INSTANCE.isNightMode()) {
                str = "https://static-res.qq.com/static-res/adelie/home/home_page_bg_night.png";
            } else {
                str = "https://static-res.qq.com/static-res/adelie/home/home_page_bg.png";
            }
            ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.f(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 0.0f, 1, null), null, com.tencent.ntcompose.material.h.INSTANCE.a(), null, null, str, null, null, null, null, null, null, null, null, null, null, startRestartGroup, 12845056, 0, 0, 2095967);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterPage$setBkgView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                AdelieManagerCenterPage.access$setBkgView(AdelieManagerCenterPage.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.BaseComponentActivity, com.tencent.ntcompose.activity.ComponentActivity
    public final void onCreate(a aVar) {
        super.onCreate(aVar);
        AdelieManagerReport.uid = getUid$qecommerce_biz_release(getPageData());
        String p16 = getPageData().n().p("robot_uin");
        if (p16.length() == 0) {
            p16 = "0";
        }
        AdelieManagerReport.uin = Long.parseLong(p16);
        getViewModel().disableProfile = Intrinsics.areEqual(getPageData().n().p("disable_jump_profile"), "1");
        AdelieManagerCenterViewModel viewModel = getViewModel();
        viewModel.getClass();
        com.tencent.kuikly.core.coroutines.e eVar = com.tencent.kuikly.core.coroutines.e.f117232d;
        BuildersKt.e(eVar, null, null, new AdelieManagerCenterViewModel$fetchOptionQQMC$1(viewModel, null), 3, null);
        final AdelieManagerCenterViewModel viewModel2 = getViewModel();
        String uid$qecommerce_biz_release = getUid$qecommerce_biz_release(getPageData());
        Integer value = viewModel2.permissionType._state.getValue();
        BuildersKt.e(eVar, null, null, new AdelieManagerOIDBServer$permissionsEdit$1(new Function3<Integer, String, o, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterViewModel$fetchEditSwitchSetting$1
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(Integer num, String str, o oVar) {
                aq aqVar;
                o oVar2 = oVar;
                KLog kLog = KLog.INSTANCE;
                StringBuilder m3 = AdelieManagerCenterViewModel$fetchEditSwitchSetting$1$$ExternalSyntheticOutline0.m("fetchEditSwitchSetting result errCode=", num.intValue(), ", errMsg=", str, ", rsp=");
                m3.append(oVar2);
                kLog.i("AdelieManagerCenterViewModel", m3.toString());
                if (oVar2 != null && (aqVar = oVar2.f404221d) != null) {
                    AdelieManagerCenterViewModel.this.permissionType._state.setValue(Integer.valueOf(aqVar.f404174d));
                }
                return Unit.INSTANCE;
            }
        }, 1, uid$qecommerce_biz_release, new aq(value != null ? value.intValue() : 0), null), 3, null);
        getViewModel().fetchRobotInfo(getUid$qecommerce_biz_release(getPageData()), new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterPage$onCreate$1
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Boolean bool) {
                boolean booleanValue = bool.booleanValue();
                CategoryListFooterKt$CategoryListFooter$1$1$$ExternalSyntheticOutline0.m("fetchRobotInfo ", booleanValue, KLog.INSTANCE, "AdelieManagerCenterPage");
                if (!booleanValue) {
                    ((BridgeModule) c.f117352a.g().acquireModule("HRBridgeModule")).qToast("\u9875\u9762\u52a0\u8f7d\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5", QToastMode.Warning);
                }
                return Unit.INSTANCE;
            }
        });
        AdelieManagerCenterViewModel viewModel3 = getViewModel();
        viewModel3.getClass();
        c cVar = c.f117352a;
        AdelieRedDotModule adelieRedDotModule = (AdelieRedDotModule) cVar.g().acquireModule("AdelieRedDotModule");
        viewModel3.redDotList.updateValueList(AdelieRedDotModule.getRedDotInfoListFromCache$default(adelieRedDotModule));
        BuildersKt.e(eVar, null, null, new AdelieManagerCenterViewModel$fetchRedDotData$1(adelieRedDotModule, viewModel3, null), 3, null);
        this.editRobotEventCallbackRef = k.b((k) cVar.g().acquireModule("KRNotifyModule"), "adelie_edit_robot", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterPage$onCreate$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar2) {
                e eVar3 = eVar2;
                if (Intrinsics.areEqual(eVar3 != null ? eVar3.p("uid") : null, AdelieManagerCenterPage.this.getViewModel().robotUid)) {
                    AdelieManagerCenterPage.this.getViewModel().fetchRobotInfo(AdelieManagerCenterPage.this.getViewModel().robotUid, null);
                }
                return Unit.INSTANCE;
            }
        }, 2, null);
        this.permissionTypeCallbackRef = k.b((k) cVar.g().acquireModule("KRNotifyModule"), "adelie_manager_permission_type", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterPage$onCreate$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar2) {
                e eVar3 = eVar2;
                int j3 = eVar3 != null ? eVar3.j("type") : 0;
                final AdelieManagerCenterViewModel viewModel4 = AdelieManagerCenterPage.this.getViewModel();
                AdelieManagerCenterPage adelieManagerCenterPage = AdelieManagerCenterPage.this;
                String uid$qecommerce_biz_release2 = adelieManagerCenterPage.getUid$qecommerce_biz_release(adelieManagerCenterPage.getPageData());
                final Integer value2 = viewModel4.permissionType._state.getValue();
                viewModel4.permissionType._state.setValue(Integer.valueOf(j3));
                BuildersKt.e(com.tencent.kuikly.core.coroutines.e.f117232d, null, null, new AdelieManagerOIDBServer$permissionsEdit$1(new Function3<Integer, String, o, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterViewModel$setEditSwitchSetting$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public final Unit invoke(Integer num, String str, o oVar) {
                        o oVar2 = oVar;
                        KLog kLog = KLog.INSTANCE;
                        StringBuilder m3 = AdelieManagerCenterViewModel$fetchEditSwitchSetting$1$$ExternalSyntheticOutline0.m("setEditSwitchSetting result errCode=", num.intValue(), ", errMsg=", str, ", rsp=");
                        m3.append(oVar2);
                        kLog.i("AdelieManagerCenterViewModel", m3.toString());
                        if (oVar2 == null) {
                            StateHolder<Integer> stateHolder = AdelieManagerCenterViewModel.this.permissionType;
                            stateHolder._state.setValue(value2);
                        } else {
                            aq aqVar = oVar2.f404221d;
                            if (aqVar == null) {
                                StateHolder<Integer> stateHolder2 = AdelieManagerCenterViewModel.this.permissionType;
                                stateHolder2._state.setValue(value2);
                            } else {
                                StateHolder<Integer> stateHolder3 = AdelieManagerCenterViewModel.this.permissionType;
                                stateHolder3._state.setValue(Integer.valueOf(aqVar.f404174d));
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }, 2, uid$qecommerce_biz_release2, new aq(j3), null), 3, null);
                return Unit.INSTANCE;
            }
        }, 2, null);
        com.tencent.ntcompose.activity.b.c(this, null, ComposableLambdaKt.composableLambdaInstance(-2103230528, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterPage$onCreate$4
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer, Integer num) {
                Composer composer2 = composer;
                int intValue = num.intValue();
                if ((intValue & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2103230528, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterPage.onCreate.<anonymous> (AdelieManagerCenterPage.kt:115)");
                    }
                    i c16 = ModifiersKt.c(ComposeLayoutPropUpdaterKt.f(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 0.0f, 1, null), h.INSTANCE.j());
                    final AdelieManagerCenterPage adelieManagerCenterPage = AdelieManagerCenterPage.this;
                    BoxKt.a(c16, null, null, ComposableLambdaKt.composableLambda(composer2, 249273286, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterPage$onCreate$4.1
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(b bVar, Composer composer3, Integer num2) {
                            Composer composer4 = composer3;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer4.getSkipping()) {
                                composer4.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(249273286, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterPage.onCreate.<anonymous>.<anonymous> (AdelieManagerCenterPage.kt:119)");
                                }
                                AdelieManagerCenterPage.access$setBkgView(AdelieManagerCenterPage.this, composer4, 8);
                                final AdelieManagerCenterPage adelieManagerCenterPage2 = AdelieManagerCenterPage.this;
                                AdelieManagerCenterPage.access$navigationBar(adelieManagerCenterPage2, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterPage.onCreate.4.1.1
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Unit invoke() {
                                        StateHolder<Boolean> stateHolder = AdelieManagerCenterPage.this.showActionSheet;
                                        stateHolder._state.setValue(Boolean.TRUE);
                                        return Unit.INSTANCE;
                                    }
                                }, composer4, 64);
                                final AdelieManagerCenterPage adelieManagerCenterPage3 = AdelieManagerCenterPage.this;
                                AdelieManagerCenterPage.access$contentContainer(adelieManagerCenterPage3, 104.0f, ComposableLambdaKt.composableLambda(composer4, -1954125293, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterPage.onCreate.4.1.2
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(b bVar2, Composer composer5, Integer num3) {
                                        Composer composer6 = composer5;
                                        int intValue3 = num3.intValue();
                                        if ((intValue3 & 81) == 16 && composer6.getSkipping()) {
                                            composer6.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1954125293, intValue3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterPage.onCreate.<anonymous>.<anonymous>.<anonymous> (AdelieManagerCenterPage.kt:122)");
                                            }
                                            AdelieManagerCenterPage adelieManagerCenterPage4 = AdelieManagerCenterPage.this;
                                            int i3 = AdelieManagerCenterPage.$r8$clinit;
                                            if (adelieManagerCenterPage4.getViewModel().pageState._state.getValue() == AdelieManagerCenterViewModel.PageState.LOADING) {
                                                new AdelieScanningLightView();
                                            } else {
                                                AdelieManagerListKt.AdelieManagerList(AdelieManagerCenterPage.this.getViewModel(), composer6, 8);
                                                AdelieManagerCenterPage.access$showRejectedDialog(AdelieManagerCenterPage.this, composer6, 8);
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer4, PlayerResources.ViewId.EXTENDED_VIEW_IV_USER_PORTRAIT);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer2, 3080, 6);
                    AdelieManagerCenterPage.access$MoreActionSheet(AdelieManagerCenterPage.this, composer2, 8);
                    AdelieManagerCenterPage.access$DeleteAlertDialog(AdelieManagerCenterPage.this, composer2, 8);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), 1, null);
    }

    public static final void access$MoreActionSheet(final AdelieManagerCenterPage adelieManagerCenterPage, Composer composer, final int i3) {
        boolean z16;
        String str;
        adelieManagerCenterPage.getClass();
        Composer startRestartGroup = composer.startRestartGroup(1104934876);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1104934876, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterPage.MoreActionSheet (AdelieManagerCenterPage.kt:251)");
        }
        Boolean value = adelieManagerCenterPage.showActionSheet._state.getValue();
        if (value != null) {
            boolean booleanValue = value.booleanValue();
            if (!Intrinsics.areEqual(adelieManagerCenterPage.showActionSheet._state.getValue(), Boolean.TRUE)) {
                z16 = booleanValue;
                str = "\u5220\u9664";
            } else {
                e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_bas_agent_management");
                e m16 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_bas_agent_management");
                m16.v("agent_id", AdelieManagerReport.uid);
                m16.u("agent_uin", AdelieManagerReport.uin);
                m3.v("cur_pg", m16);
                m3.v("dt_eid", "em_bas_more_panels");
                m3.v(PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "\u5220\u9664");
                ReportKt.reportCustomDTEvent("dt_imp", m3);
                e eVar = new e();
                eVar.v("dt_pgid", "pg_bas_agent_management");
                e m17 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_bas_agent_management");
                m17.v("agent_id", AdelieManagerReport.uid);
                z16 = booleanValue;
                str = "\u5220\u9664";
                m17.u("agent_uin", AdelieManagerReport.uin);
                eVar.v("cur_pg", m17);
                eVar.v("dt_eid", "em_bas_more_panels");
                eVar.v(PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "\u53d6\u6d88");
                ReportKt.reportCustomDTEvent("dt_imp", eVar);
            }
            QUIActionSheetKt.QUIActionSheet(z16, null, new QUIActionSheetItem[]{QUIActionSheetKt.QUIActionSheetWarningTextItem(str, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterPage$MoreActionSheet$1$3
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    StateHolder<Boolean> stateHolder = AdelieManagerCenterPage.this.showActionSheet;
                    stateHolder._state.setValue(Boolean.FALSE);
                    e eVar2 = new e();
                    eVar2.v("dt_pgid", "pg_bas_agent_management");
                    e eVar3 = new e();
                    eVar3.v("dt_pgid", "pg_bas_agent_management");
                    eVar3.v("agent_id", AdelieManagerReport.uid);
                    eVar3.u("agent_uin", AdelieManagerReport.uin);
                    eVar2.v("cur_pg", eVar3);
                    eVar2.v("dt_eid", "em_bas_more_panels");
                    eVar2.v(PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "\u5220\u9664");
                    ReportKt.reportCustomDTEvent("dt_clck", eVar2);
                    e eVar4 = new e();
                    eVar4.v("dt_pgid", "pg_bas_agent_management");
                    e eVar5 = new e();
                    eVar5.v("dt_pgid", "pg_bas_agent_management");
                    eVar5.v("agent_id", AdelieManagerReport.uid);
                    eVar5.u("agent_uin", AdelieManagerReport.uin);
                    eVar4.v("cur_pg", eVar5);
                    eVar4.v("dt_eid", "em_bas_delete_pop");
                    ReportKt.reportCustomDTEvent("dt_imp", eVar4);
                    StateHolder<Boolean> stateHolder2 = AdelieManagerCenterPage.this.showDeleteAlert;
                    stateHolder2._state.setValue(Boolean.TRUE);
                    return Unit.INSTANCE;
                }
            })}, null, new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterPage$MoreActionSheet$1$4
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Boolean bool) {
                    bool.booleanValue();
                    StateHolder<Boolean> stateHolder = AdelieManagerCenterPage.this.showActionSheet;
                    stateHolder._state.setValue(Boolean.FALSE);
                    e eVar2 = new e();
                    eVar2.v("dt_pgid", "pg_bas_agent_management");
                    e eVar3 = new e();
                    eVar3.v("dt_pgid", "pg_bas_agent_management");
                    eVar3.v("agent_id", AdelieManagerReport.uid);
                    eVar3.u("agent_uin", AdelieManagerReport.uin);
                    eVar2.v("cur_pg", eVar3);
                    eVar2.v("dt_eid", "em_bas_more_panels");
                    eVar2.v(PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "\u53d6\u6d88");
                    ReportKt.reportCustomDTEvent("dt_clck", eVar2);
                    return Unit.INSTANCE;
                }
            }, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterPage$MoreActionSheet$1$5
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    StateHolder<Boolean> stateHolder = AdelieManagerCenterPage.this.showActionSheet;
                    stateHolder._state.setValue(Boolean.FALSE);
                    return Unit.INSTANCE;
                }
            }, startRestartGroup, PlayerResources.ViewId.GET_MORE_TOGGLE_AREA, 8);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterPage$MoreActionSheet$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                AdelieManagerCenterPage.access$MoreActionSheet(AdelieManagerCenterPage.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void access$navigationBar(final AdelieManagerCenterPage adelieManagerCenterPage, final Function0 function0, Composer composer, final int i3) {
        final int i16;
        adelieManagerCenterPage.getClass();
        Composer startRestartGroup = composer.startRestartGroup(21821915);
        if ((i3 & 14) == 0) {
            i16 = (startRestartGroup.changed(function0) ? 4 : 2) | i3;
        } else {
            i16 = i3;
        }
        if ((i16 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(21821915, i16, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterPage.navigationBar (AdelieManagerCenterPage.kt:194)");
            }
            i.Companion companion = i.INSTANCE;
            float f16 = 88.0f / 2;
            SpacerKt.a(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null), f16), startRestartGroup, 8, 0);
            BoxKt.a(ViewEventPropUpdaterKt.r(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.j(ModifiersKt.c(companion, h.INSTANCE.j()), 0.0f, 1, null), 0.0f, f16, 0.0f, 0.0f, 13, null), new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterPage$navigationBar$1
                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object obj) {
                    e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_bas_agent_management");
                    e m16 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_bas_agent_management");
                    m16.v("agent_id", AdelieManagerReport.uid);
                    m16.u("agent_uin", AdelieManagerReport.uin);
                    m3.v("cur_pg", m16);
                    m3.v("dt_eid", WinkDaTongReportConstant.ElementId.EM_BAS_MORE);
                    ReportKt.reportCustomDTEvent("dt_imp", m3);
                    return Unit.INSTANCE;
                }
            }), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 532537569, true, new Function3<b, Composer, Integer, Unit>(function0, i16) { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterPage$navigationBar$2
                public final /* synthetic */ Function0<Unit> $rightClick;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            ComposerKt.traceEventStart(532537569, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterPage.navigationBar.<anonymous> (AdelieManagerCenterPage.kt:205)");
                        }
                        h j3 = h.INSTANCE.j();
                        LeftContentConfig leftContentConfig = new LeftContentConfig("icon_allwhite_primary", new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterPage$navigationBar$2.1
                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                QQKuiklyPlatformApi.Companion companion2 = QQKuiklyPlatformApi.Companion;
                                QQKuiklyPlatformApi.Companion.closePage$default();
                                return Unit.INSTANCE;
                            }
                        }, 182);
                        CenterContentConfig centerContentConfig = new CenterContentConfig("\u7ba1\u7406\u667a\u80fd\u4f53");
                        ArrayList arrayList = new ArrayList();
                        final Function0<Unit> function02 = this.$rightClick;
                        composer3.startReplaceableGroup(1157296644);
                        boolean changed = composer3.changed(function02);
                        Object rememberedValue = composer3.rememberedValue();
                        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                            rememberedValue = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterPage$navigationBar$2$2$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final Unit invoke() {
                                    function02.invoke();
                                    e eVar = new e();
                                    eVar.v("dt_pgid", "pg_bas_agent_management");
                                    e eVar2 = new e();
                                    eVar2.v("dt_pgid", "pg_bas_agent_management");
                                    eVar2.v("agent_id", AdelieManagerReport.uid);
                                    eVar2.u("agent_uin", AdelieManagerReport.uin);
                                    eVar.v("cur_pg", eVar2);
                                    eVar.v("dt_eid", WinkDaTongReportConstant.ElementId.EM_BAS_MORE);
                                    ReportKt.reportCustomDTEvent("dt_clck", eVar);
                                    return Unit.INSTANCE;
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue);
                        }
                        composer3.endReplaceableGroup();
                        arrayList.add(new RightContentData("more", (Function0) rememberedValue, 59));
                        Unit unit = Unit.INSTANCE;
                        SecNavBarKt.SecNavBar(j3, leftContentConfig, centerContentConfig, new RightContentConfig(4, arrayList, null), composer3, GCloudVoiceErrorCode.GCloudVoiceErrno.GCLOUD_VOICE_OPENFILE_ERR, 0);
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
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterPage$navigationBar$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                AdelieManagerCenterPage.access$navigationBar(AdelieManagerCenterPage.this, function0, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
