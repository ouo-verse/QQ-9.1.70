package com.tencent.hippykotlin.demo.pages.nearby.pray_calendar;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.avcore.jni.audiodevice.TraeAudioManager;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.extension.PageDataExtKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.da_tong_report.DTReportConstKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.modifer_ext.ModifierExtKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.OIDBResponse;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUITokenThemeMode;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyApi$sendOIDBRequest$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporter;
import com.tencent.hippykotlin.demo.pages.nearby.compose_base.NBPBaseActivity;
import com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPageKt$NBPPrayCalendarPage$1;
import com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view_model.NBPPrayCalendarViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view_model.SetRemindSwitchRequest;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.KuiklyLaunchParams;
import com.tencent.ntcompose.activity.a;
import com.tencent.ntcompose.activity.b;
import com.tencent.ntcompose.animation.AnimateAsStateKt;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.lifecycle.common.Lifecycle;
import com.tencent.ntcompose.lifecycle.viewmodel.b;
import com.tencent.ntcompose.lifecycle.viewmodel.e;
import com.tencent.ntcompose.lifecycle.viewmodel.g;
import com.tencent.ntcompose.lifecycle.viewmodel.i;
import com.tencent.ntcompose.lifecycle.viewmodel.k;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.ui.platform.CompositionLocalsKt;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* loaded from: classes31.dex */
public final class NBPPrayCalendarActivity extends NBPBaseActivity {
    public INBPPrayPageModalHandle modal;

    @Override // com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.BaseComponentActivity, com.tencent.ntcompose.activity.ComponentActivity
    public final void onCreate(a aVar) {
        super.onCreate(aVar);
        b.c(this, null, ComposableLambdaKt.composableLambdaInstance(-496020022, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.NBPPrayCalendarActivity$onCreate$1
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer, Integer num) {
                com.tencent.ntcompose.lifecycle.viewmodel.b bVar;
                Composer composer2 = composer;
                int intValue = num.intValue();
                if ((intValue & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-496020022, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.NBPPrayCalendarActivity.onCreate.<anonymous> (NBPPrayCalendarActivity.kt:20)");
                    }
                    NBPPrayCalendarActivity nBPPrayCalendarActivity = NBPPrayCalendarActivity.this;
                    composer2.startReplaceableGroup(-1672102968);
                    NBPPrayCalendarPageKt$NBPPrayCalendarPage$1 nBPPrayCalendarPageKt$NBPPrayCalendarPage$1 = new Function1<com.tencent.ntcompose.lifecycle.viewmodel.b, NBPPrayCalendarViewModel>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPageKt$NBPPrayCalendarPage$1
                        @Override // kotlin.jvm.functions.Function1
                        public final NBPPrayCalendarViewModel invoke(com.tencent.ntcompose.lifecycle.viewmodel.b bVar2) {
                            return new NBPPrayCalendarViewModel(c.f117352a.g().getPageData());
                        }
                    };
                    composer2.startReplaceableGroup(1485077867);
                    Object consume = composer2.consume(CompositionLocalsKt.f());
                    if (consume != null) {
                        k kVar = (k) consume;
                        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(NBPPrayCalendarViewModel.class);
                        e eVar = new e();
                        eVar.a(Reflection.getOrCreateKotlinClass(NBPPrayCalendarViewModel.class), nBPPrayCalendarPageKt$NBPPrayCalendarPage$1);
                        i.b b16 = eVar.b();
                        if (kVar instanceof com.tencent.ntcompose.lifecycle.viewmodel.c) {
                            bVar = ((com.tencent.ntcompose.lifecycle.viewmodel.c) kVar).a();
                        } else {
                            bVar = b.a.f339329b;
                        }
                        g c16 = com.tencent.ntcompose.lifecycle.viewmodel.compose.a.c(orCreateKotlinClass, kVar, null, b16, bVar, composer2, TraeAudioManager.CustomHandler.MSG_VOICE_CALL_PRE_PROCESS, 0);
                        composer2.endReplaceableGroup();
                        final NBPPrayCalendarViewModel nBPPrayCalendarViewModel = (NBPPrayCalendarViewModel) c16;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1672102968, 0, -1, "com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPage (NBPPrayCalendarPage.kt:77)");
                        }
                        com.tencent.ntcompose.lifecycle.viewmodel.compose.a.b(nBPPrayCalendarViewModel, ((com.tencent.ntcompose.lifecycle.common.c) composer2.consume(CompositionLocalsKt.e())).getLifecycle(), composer2, (Lifecycle.f339325a << 3) | 8);
                        composer2.startReplaceableGroup(-492369756);
                        Object rememberedValue = composer2.rememberedValue();
                        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                            composer2.updateRememberedValue(rememberedValue);
                        }
                        composer2.endReplaceableGroup();
                        final MutableState mutableState = (MutableState) rememberedValue;
                        composer2.startReplaceableGroup(-1691093205);
                        float e16 = (((Boolean) mutableState.getValue()).booleanValue() && Intrinsics.areEqual(nBPPrayCalendarViewModel.pageData.n().p(KuiklyLaunchParams.PARAM_MODAL_MODE), "1")) ? ((com.tencent.ntcompose.ui.platform.a) composer2.consume(CompositionLocalsKt.d())).e() : 0.0f;
                        composer2.endReplaceableGroup();
                        BoxKt.a(ModifierExtKt.pageVR(ComposeLayoutPropUpdaterKt.p(ComposeLayoutPropUpdaterKt.f(ComposeLayoutPropUpdaterKt.w(com.tencent.ntcompose.core.i.INSTANCE, ((com.tencent.ntcompose.ui.platform.a) composer2.consume(CompositionLocalsKt.d())).e()), 0.0f, 1, null), AnimateAsStateKt.c(e16, com.tencent.ntcompose.animation.b.d(250, 0, com.tencent.ntcompose.animation.i.d(), null, 10, null), null, composer2, 0, 4).getValue().floatValue(), 0.0f, 2, null), "pg_nearby_luck_card_calendar", DTReportConstKt.getDTBaseParams("0AND05J90ZOPH3DU")), null, null, ComposableLambdaKt.composableLambda(composer2, -1169182770, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPageKt$NBPPrayCalendarPage$2
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar2, Composer composer3, Integer num2) {
                                int i3;
                                String str;
                                com.tencent.ntcompose.foundation.layout.b bVar3 = bVar2;
                                Composer composer4 = composer3;
                                int intValue2 = num2.intValue();
                                if ((intValue2 & 14) == 0) {
                                    i3 = (composer4.changed(bVar3) ? 4 : 2) | intValue2;
                                } else {
                                    i3 = intValue2;
                                }
                                if ((i3 & 91) == 18 && composer4.getSkipping()) {
                                    composer4.skipToGroupEnd();
                                } else {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1169182770, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPage.<anonymous> (NBPPrayCalendarPage.kt:96)");
                                    }
                                    i.Companion companion = com.tencent.ntcompose.core.i.INSTANCE;
                                    com.tencent.ntcompose.core.i h16 = ComposeLayoutPropUpdaterKt.h(companion, 0.0f, 1, null);
                                    if (PageDataExtKt.isNightMode(NBPPrayCalendarViewModel.this.pageData)) {
                                        str = "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_a3Q927CRqli.png";
                                    } else {
                                        str = "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_x-xjXccBR2C.png";
                                    }
                                    ImageKt.a(str, null, null, null, null, h16, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer4, 262144, 0, 0, 2097118);
                                    com.tencent.ntcompose.core.i f16 = ComposeLayoutPropUpdaterKt.f(ComposeLayoutPropUpdaterKt.w(companion, ((com.tencent.ntcompose.ui.platform.a) composer4.consume(CompositionLocalsKt.d())).e()), 0.0f, 1, null);
                                    final NBPPrayCalendarViewModel nBPPrayCalendarViewModel2 = NBPPrayCalendarViewModel.this;
                                    ColumnKt.a(f16, null, null, null, ComposableLambdaKt.composableLambda(composer4, 902286789, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPageKt$NBPPrayCalendarPage$2.1
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public final Unit invoke(d dVar, Composer composer5, Integer num3) {
                                            Composer composer6 = composer5;
                                            int intValue3 = num3.intValue();
                                            if ((intValue3 & 81) == 16 && composer6.getSkipping()) {
                                                composer6.skipToGroupEnd();
                                            } else {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(902286789, intValue3, -1, "com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPage.<anonymous>.<anonymous> (NBPPrayCalendarPage.kt:107)");
                                                }
                                                final NBPPrayCalendarViewModel nBPPrayCalendarViewModel3 = NBPPrayCalendarViewModel.this;
                                                NBPPrayCalendarPageKt.TopBar(null, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPageKt.NBPPrayCalendarPage.2.1.1
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Unit invoke() {
                                                        final NBPPrayCalendarViewModel nBPPrayCalendarViewModel4 = NBPPrayCalendarViewModel.this;
                                                        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPageKt.NBPPrayCalendarPage.2.1.1.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(Boolean bool) {
                                                                boolean booleanValue = bool.booleanValue();
                                                                NBPPrayCalendarViewModel nBPPrayCalendarViewModel5 = NBPPrayCalendarViewModel.this;
                                                                com.tencent.kuikly.core.nvi.serialization.json.e eVar2 = new com.tencent.kuikly.core.nvi.serialization.json.e();
                                                                eVar2.t("op_result", booleanValue ? 1 : 2);
                                                                Unit unit = Unit.INSTANCE;
                                                                com.tencent.kuikly.core.nvi.serialization.json.e dTElementParams = nBPPrayCalendarViewModel5.getDTElementParams("em_nearby_remind_everyday_switch", eVar2);
                                                                dTElementParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                                                Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", dTElementParams);
                                                                return Unit.INSTANCE;
                                                            }
                                                        };
                                                        final boolean z16 = !nBPPrayCalendarViewModel4.isRemindOn.getValue().booleanValue();
                                                        KLog.INSTANCE.d("NBPPrayCalendarViewModel", "switchRemindNotify: " + z16);
                                                        final Function3<Boolean, String, g35.e, Unit> function3 = new Function3<Boolean, String, g35.e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view_model.NBPPrayCalendarViewModel$switchRemindNotify$1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            /* JADX WARN: Multi-variable type inference failed */
                                                            {
                                                                super(3);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function3
                                                            public final Unit invoke(Boolean bool, String str2, g35.e eVar2) {
                                                                String str3 = str2;
                                                                if (bool.booleanValue()) {
                                                                    NBPPrayCalendarViewModel.this.isRemindOn.setValue(Boolean.valueOf(z16));
                                                                } else if (str3 != null) {
                                                                    Utils.INSTANCE.currentBridgeModule().qToast(str3, QToastMode.Warning);
                                                                }
                                                                Function1<Boolean, Unit> function12 = function1;
                                                                if (function12 != null) {
                                                                    function12.invoke(NBPPrayCalendarViewModel.this.isRemindOn.getValue());
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        };
                                                        SetRemindSwitchRequest setRemindSwitchRequest = new SetRemindSwitchRequest(z16);
                                                        QQKuiklyPlatformApi.Companion.sendOIDBRequest(setRemindSwitchRequest, false, new NearbyApi$sendOIDBRequest$1(new APICallTechReporter(1, setRemindSwitchRequest.getCmd()), new Function1<OIDBResponse<g35.e>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view_model.NBPAttendanceServiceExt$setRemindSwitch$1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            /* JADX WARN: Multi-variable type inference failed */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(OIDBResponse<g35.e> oIDBResponse) {
                                                                OIDBResponse<g35.e> oIDBResponse2 = oIDBResponse;
                                                                KLog.INSTANCE.i("NBPAttendanceServiceExt", "setRemindSwitch rsp: " + oIDBResponse2);
                                                                function3.invoke(Boolean.valueOf(oIDBResponse2.success), oIDBResponse2.f114186msg, oIDBResponse2.rsp);
                                                                return Unit.INSTANCE;
                                                            }
                                                        }));
                                                        return Unit.INSTANCE;
                                                    }
                                                }, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPageKt.NBPPrayCalendarPage.2.1.2
                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Unit invoke() {
                                                        QQKuiklyPlatformApi.Companion companion2 = QQKuiklyPlatformApi.Companion;
                                                        QQKuiklyPlatformApi.Companion.closePage$default();
                                                        return Unit.INSTANCE;
                                                    }
                                                }, composer6, MsgConstant.KRMFILETHUMBSIZE384, 1);
                                                final NBPPrayCalendarViewModel nBPPrayCalendarViewModel4 = NBPPrayCalendarViewModel.this;
                                                NBPPrayCalendarPageKt.Header(null, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPageKt.NBPPrayCalendarPage.2.1.3
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Unit invoke() {
                                                        NBPPrayCalendarViewModel nBPPrayCalendarViewModel5 = NBPPrayCalendarViewModel.this;
                                                        nBPPrayCalendarViewModel5.handleDetailClick(new g35.a(NBPPrayCalendarViewModel.this.todayDate, nBPPrayCalendarViewModel5.todayCard.getValue()), NBPPrayCalendarViewModel.this.todayDate);
                                                        NBPPrayCalendarViewModel nBPPrayCalendarViewModel6 = NBPPrayCalendarViewModel.this;
                                                        com.tencent.kuikly.core.nvi.serialization.json.e eVar2 = new com.tencent.kuikly.core.nvi.serialization.json.e();
                                                        eVar2.t("clockin_state", NBPPrayCalendarViewModel.this.isTodaySignIn.getValue().booleanValue() ? 1 : 2);
                                                        Unit unit = Unit.INSTANCE;
                                                        com.tencent.kuikly.core.nvi.serialization.json.e dTElementParams = nBPPrayCalendarViewModel6.getDTElementParams("em_nearby_luck_card_calendar", eVar2);
                                                        dTElementParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                                        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", dTElementParams);
                                                        return Unit.INSTANCE;
                                                    }
                                                }, composer6, 0, 1);
                                                final NBPPrayCalendarViewModel nBPPrayCalendarViewModel5 = NBPPrayCalendarViewModel.this;
                                                NBPPrayCalendarPageKt.CalendarView(null, new Function2<g35.a, k25.c, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPageKt.NBPPrayCalendarPage.2.1.4
                                                    {
                                                        super(2);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public final Unit invoke(g35.a aVar2, k25.c cVar) {
                                                        NBPPrayCalendarViewModel.this.handleDetailClick(aVar2, cVar);
                                                        return Unit.INSTANCE;
                                                    }
                                                }, composer6, 0, 1);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer4, 24584, 14);
                                    com.tencent.ntcompose.core.i elementVR = ModifierExtKt.elementVR(bVar3.a(ComposeLayoutPropUpdaterKt.n(companion, 0.0f, 0.0f, 0.0f, NBPPrayCalendarViewModel.this.pageData.getSafeAreaInsets().getBottom() + 30, 7, null), Alignment.BottomCenter), "em_nearby_launch_skip_btn", DTReportConstKt.getDTBaseParams("0AND05J90ZOPH3DU"));
                                    final NBPPrayCalendarViewModel nBPPrayCalendarViewModel3 = NBPPrayCalendarViewModel.this;
                                    NBPPrayCalendarPageKt.BottomButton(ViewEventPropUpdaterKt.d(elementVR, false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPageKt$NBPPrayCalendarPage$2.2
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ClickParams clickParams) {
                                            NBPPrayCalendarViewModel.this.jumpMoodGroupPage();
                                            return Unit.INSTANCE;
                                        }
                                    }, 3, null), composer4, 8, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer2, 3080, 6);
                        INBPPrayPageModalHandle iNBPPrayPageModalHandle = new INBPPrayPageModalHandle() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPageKt$NBPPrayCalendarPage$3
                            @Override // com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.INBPPrayPageModalHandle
                            public final void close() {
                                mutableState.setValue(Boolean.TRUE);
                            }
                        };
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer2.endReplaceableGroup();
                        nBPPrayCalendarActivity.modal = iNBPPrayPageModalHandle;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    } else {
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
                    }
                }
                return Unit.INSTANCE;
            }
        }), 1, null);
    }

    @Override // com.tencent.ntcompose.activity.ComponentActivity, com.tencent.kuikly.core.pager.b
    public final void onReceivePagerEvent(String str, com.tencent.kuikly.core.nvi.serialization.json.e eVar) {
        super.onReceivePagerEvent(str, eVar);
        if (Intrinsics.areEqual(str, "onModalModeBackPressed")) {
            KLog.INSTANCE.i("NBPPrayCalendarViewModel", "onModalModeBackPressed");
            INBPPrayPageModalHandle iNBPPrayPageModalHandle = this.modal;
            if (iNBPPrayPageModalHandle != null) {
                iNBPPrayPageModalHandle.close();
            }
            TimerKt.d(300, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.NBPPrayCalendarActivity$onReceivePagerEvent$1
                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                    QQKuiklyPlatformApi.Companion.closePage$default();
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.BaseComponentActivity
    public final QUITokenThemeMode quiTokenThemeMode() {
        return QUITokenThemeMode.ONLY_DAY_AND_NIGHT;
    }
}
