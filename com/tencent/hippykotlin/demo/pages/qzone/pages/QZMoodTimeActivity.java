package com.tencent.hippykotlin.demo.pages.qzone.pages;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.BaseComponentActivity;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.DatePickerState;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIAlertDialogItem;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIAlertDialogKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePickerKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListSingleLineCommonViewKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListSingleLineSwitchViewKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBarKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.ICalendar;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.ntcompose.activity.a;
import com.tencent.ntcompose.activity.b;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.material.base.ModifiersKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class QZMoodTimeActivity extends BaseComponentActivity {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final int MAX_FUTURE_SPAN_DAYS = 10;
    public final int MAX_FUTURE_SPAN_MILLISECONDS = 864000000;
    public long lastShowToastTime;
    public final MutableState<Long> publishTime;
    public final MutableState<Long> scheduleDelete;

    public QZMoodTimeActivity() {
        MutableState<Long> mutableStateOf$default;
        MutableState<Long> mutableStateOf$default2;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0L, null, 2, null);
        this.publishTime = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0L, null, 2, null);
        this.scheduleDelete = mutableStateOf$default2;
    }

    public static final void access$postResult(QZMoodTimeActivity qZMoodTimeActivity) {
        k kVar = (k) qZMoodTimeActivity.acquireModule("KRNotifyModule");
        e eVar = new e();
        eVar.u("publish_time", qZMoodTimeActivity.publishTime.getValue().longValue());
        eVar.u("schedule_delete", qZMoodTimeActivity.scheduleDelete.getValue().longValue());
        Unit unit = Unit.INSTANCE;
        k.d(kVar, "MOOD_TIME_SETTING_COMPLETE", eVar, false, 4, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.BaseComponentActivity, com.tencent.ntcompose.activity.ComponentActivity
    public final void onCreate(a aVar) {
        super.onCreate(aVar);
        this.publishTime.setValue(Long.valueOf(getPageData().n().o("publish_time", 0L)));
        this.scheduleDelete.setValue(Long.valueOf(getPageData().n().o("schedule_delete", 0L)));
        b.c(this, null, ComposableLambdaKt.composableLambdaInstance(-877718343, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qzone.pages.QZMoodTimeActivity$onCreate$1
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
                        ComposerKt.traceEventStart(-877718343, intValue, -1, "com.tencent.hippykotlin.demo.pages.qzone.pages.QZMoodTimeActivity.onCreate.<anonymous> (QZMoodTimeActivity.kt:51)");
                    }
                    QZMoodTimeActivity.this.QZTimeSettingPage(composer2, 8);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), 1, null);
    }

    @Override // com.tencent.ntcompose.activity.ComponentActivity
    public final void onDestroy() {
        super.onDestroy();
    }

    public final void QZTimeSettingPage(Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-648657408);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-648657408, i3, -1, "com.tencent.hippykotlin.demo.pages.qzone.pages.QZMoodTimeActivity.QZTimeSettingPage (QZMoodTimeActivity.kt:61)");
        }
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue = startRestartGroup.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(this.publishTime.getValue().longValue() > 0), null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState mutableState = (MutableState) rememberedValue;
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue2);
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState mutableState2 = (MutableState) rememberedValue2;
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue3 = startRestartGroup.rememberedValue();
        if (rememberedValue3 == companion.getEmpty()) {
            rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue3);
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState mutableState3 = (MutableState) rememberedValue3;
        final com.tencent.kuikly.core.module.b bVar = (com.tencent.kuikly.core.module.b) c.f117352a.g().acquireModule("KRCalendarModule");
        i.Companion companion2 = i.INSTANCE;
        ColumnKt.a(ModifiersKt.d(ComposeLayoutPropUpdaterKt.h(companion2, 0.0f, 1, null), QUIToken.color$default("bg_bottom_standard")), null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 489834281, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qzone.pages.QZMoodTimeActivity$QZTimeSettingPage$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(d dVar, Composer composer2, Integer num) {
                float f16;
                i.Companion companion3;
                Composer composer3;
                Composer composer4 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer4.getSkipping()) {
                    composer4.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(489834281, intValue, -1, "com.tencent.hippykotlin.demo.pages.qzone.pages.QZMoodTimeActivity.QZTimeSettingPage.<anonymous> (QZMoodTimeActivity.kt:74)");
                    }
                    QUINavBarKt.QUINavBar(QUIToken.color$default("bg_nav_secondary"), null, null, "\u5b9a\u65f6", null, null, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qzone.pages.QZMoodTimeActivity$QZTimeSettingPage$1.1
                        @Override // kotlin.jvm.functions.Function0
                        public final Unit invoke() {
                            QQKuiklyPlatformApi.Companion companion4 = QQKuiklyPlatformApi.Companion;
                            QQKuiklyPlatformApi.Companion.closePage$default();
                            return Unit.INSTANCE;
                        }
                    }, null, false, 0.0f, composer4, 806882312, 438);
                    i.Companion companion4 = i.INSTANCE;
                    i n3 = ComposeLayoutPropUpdaterKt.n(ModifiersKt.q(companion4, new uo3.b(8.0f, 8.0f, QZMoodTimeActivity.this.publishTime.getValue().longValue() > 0 ? 0.0f : 8.0f, QZMoodTimeActivity.this.publishTime.getValue().longValue() > 0 ? 0.0f : 8.0f)), 16.0f, 16.0f, 16.0f, 0.0f, 8, null);
                    boolean booleanValue = mutableState.getValue().booleanValue();
                    final MutableState<Boolean> mutableState4 = mutableState;
                    final MutableState<Boolean> mutableState5 = mutableState2;
                    final QZMoodTimeActivity qZMoodTimeActivity = QZMoodTimeActivity.this;
                    QUIListSingleLineSwitchViewKt.QUIListSingleLineSwitchView(n3, null, null, "\u5b9a\u65f6\u53d1\u8868", null, booleanValue, new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qzone.pages.QZMoodTimeActivity$QZTimeSettingPage$1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(Boolean bool) {
                            boolean booleanValue2 = bool.booleanValue();
                            mutableState4.setValue(Boolean.valueOf(booleanValue2));
                            if (booleanValue2) {
                                mutableState5.setValue(Boolean.TRUE);
                            } else {
                                qZMoodTimeActivity.publishTime.setValue(0L);
                                QZMoodTimeActivity.access$postResult(qZMoodTimeActivity);
                            }
                            return Unit.INSTANCE;
                        }
                    }, composer4, 3080, 22);
                    composer4.startReplaceableGroup(-267155915);
                    if (QZMoodTimeActivity.this.publishTime.getValue().longValue() > 0) {
                        i n16 = ComposeLayoutPropUpdaterKt.n(ModifiersKt.q(companion4, new uo3.b(0.0f, 0.0f, 8.0f, 8.0f)), 16.0f, 0.0f, 16.0f, 0.0f, 10, null);
                        final MutableState<Boolean> mutableState6 = mutableState2;
                        composer4.startReplaceableGroup(1157296644);
                        boolean changed = composer4.changed(mutableState6);
                        Object rememberedValue4 = composer4.rememberedValue();
                        if (changed || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue4 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qzone.pages.QZMoodTimeActivity$QZTimeSettingPage$1$3$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ClickParams clickParams) {
                                    mutableState6.setValue(Boolean.TRUE);
                                    return Unit.INSTANCE;
                                }
                            };
                            composer4.updateRememberedValue(rememberedValue4);
                        }
                        composer4.endReplaceableGroup();
                        f16 = 8.0f;
                        companion3 = companion4;
                        composer3 = composer4;
                        QUIListSingleLineCommonViewKt.QUIListSingleLineCommonView(ViewEventPropUpdaterKt.d(n16, false, null, (Function1) rememberedValue4, 3, null), null, null, ((BridgeModule) c.f117352a.g().acquireModule("HRBridgeModule")).dateFormatter(QZMoodTimeActivity.this.publishTime.getValue().longValue(), "yyyy\u5e74MM\u6708dd\u65e5 HH:mm"), 0.0f, null, null, null, null, "", null, 0.0f, composer4, 805306376, 0, 3574);
                    } else {
                        f16 = 8.0f;
                        companion3 = companion4;
                        composer3 = composer4;
                    }
                    composer3.endReplaceableGroup();
                    if (!c.f117352a.g().getPageData().getIsOhOs()) {
                        i n17 = ComposeLayoutPropUpdaterKt.n(ModifiersKt.q(companion3, uo3.c.a(f16)), 16.0f, 16.0f, 16.0f, 0.0f, 8, null);
                        boolean z16 = QZMoodTimeActivity.this.scheduleDelete.getValue().longValue() > 0;
                        final QZMoodTimeActivity qZMoodTimeActivity2 = QZMoodTimeActivity.this;
                        final MutableState<Boolean> mutableState7 = mutableState3;
                        QUIListSingleLineSwitchViewKt.QUIListSingleLineSwitchView(n17, null, null, "\u53d1\u886824\u5c0f\u65f6\u540e\u81ea\u52a8\u5220\u9664", null, z16, new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qzone.pages.QZMoodTimeActivity$QZTimeSettingPage$1.4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(Boolean bool) {
                                boolean booleanValue2 = bool.booleanValue();
                                QZMoodTimeActivity.this.scheduleDelete.setValue(Long.valueOf(booleanValue2 ? 1L : 0L));
                                mutableState7.setValue(Boolean.valueOf(booleanValue2));
                                QZMoodTimeActivity.access$postResult(QZMoodTimeActivity.this);
                                return Unit.INSTANCE;
                            }
                        }, composer3, 3080, 22);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 24584, 14);
        QUIDatePickerKt.QUIDatePicker(ComposeLayoutPropUpdaterKt.h(companion2, 0.0f, 1, null), null, this.publishTime.getValue().longValue(), this.MAX_FUTURE_SPAN_DAYS, ((Boolean) mutableState2.getValue()).booleanValue(), null, null, null, null, null, new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qzone.pages.QZMoodTimeActivity$QZTimeSettingPage$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Boolean bool) {
                bool.booleanValue();
                MutableState<Boolean> mutableState4 = mutableState2;
                Boolean bool2 = Boolean.FALSE;
                mutableState4.setValue(bool2);
                if (this.publishTime.getValue().longValue() <= 0) {
                    mutableState.setValue(bool2);
                }
                return Unit.INSTANCE;
            }
        }, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qzone.pages.QZMoodTimeActivity$QZTimeSettingPage$3
            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                return Unit.INSTANCE;
            }
        }, new Function2<Long, DatePickerState, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qzone.pages.QZMoodTimeActivity$QZTimeSettingPage$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Long l3, DatePickerState datePickerState) {
                long longValue = l3.longValue();
                final DatePickerState datePickerState2 = datePickerState;
                KLog.INSTANCE.i("QzoneMoodTime", "onScrollEnd, timestamp: " + longValue + ", time: " + com.tencent.kuikly.core.module.b.this.a(longValue, "yyyy-MM-dd HH:mm:ss"));
                zz0.a aVar = zz0.a.f453719a;
                long a16 = aVar.a();
                if (this.publishTime.getValue().longValue() > 0) {
                    a16 = this.publishTime.getValue().longValue();
                }
                final QZMoodTimeActivity qZMoodTimeActivity = this;
                Function4<Boolean, Integer, Integer, Integer, Unit> function4 = new Function4<Boolean, Integer, Integer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qzone.pages.QZMoodTimeActivity$QZTimeSettingPage$4.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(4);
                    }

                    @Override // kotlin.jvm.functions.Function4
                    public final Unit invoke(Boolean bool, Integer num, Integer num2, Integer num3) {
                        boolean booleanValue = bool.booleanValue();
                        int intValue = num.intValue();
                        int intValue2 = num2.intValue();
                        int intValue3 = num3.intValue();
                        if (booleanValue) {
                            KLog kLog = KLog.INSTANCE;
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("adjust and scroll ");
                            sb5.append(intValue);
                            sb5.append(", ");
                            sb5.append(intValue2);
                            sb5.append(", ");
                            ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0.m(sb5, intValue3, kLog, "QzoneMoodTime");
                            QZMoodTimeActivity qZMoodTimeActivity2 = QZMoodTimeActivity.this;
                            int i16 = QZMoodTimeActivity.$r8$clinit;
                            qZMoodTimeActivity2.getClass();
                            long a17 = zz0.a.f453719a.a();
                            if (a17 - qZMoodTimeActivity2.lastShowToastTime > 2000) {
                                qZMoodTimeActivity2.lastShowToastTime = a17;
                                ((QQKuiklyPlatformApi) c.f117352a.g().acquireModule("QQKuiklyPlatformApi")).qqToast(AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\u65f6\u5149\u673a\u53ea\u80fd\u7a7f\u8d8a\u672a\u6765"), qZMoodTimeActivity2.MAX_FUTURE_SPAN_DAYS, '\u5929'), QToastMode.Info);
                            }
                            com.tencent.ntcompose.foundation.lazy.d.x(datePickerState2.scrollPickerState1.state, intValue, 0.0f, true, null, 10, null);
                            com.tencent.ntcompose.foundation.lazy.d.x(datePickerState2.scrollPickerState2.state, intValue2, 0.0f, true, null, 10, null);
                            com.tencent.ntcompose.foundation.lazy.d.x(datePickerState2.scrollPickerState3.state, intValue3, 0.0f, true, null, 10, null);
                        }
                        return Unit.INSTANCE;
                    }
                };
                qZMoodTimeActivity.getClass();
                long a17 = aVar.a();
                ICalendar b16 = ((com.tencent.kuikly.core.module.b) c.f117352a.g().acquireModule("KRCalendarModule")).b(a17);
                int c16 = b16.c(ICalendar.Field.HOUR_OF_DAY);
                int c17 = b16.c(ICalendar.Field.MINUS);
                long j3 = qZMoodTimeActivity.MAX_FUTURE_SPAN_MILLISECONDS + a17;
                if (longValue > j3) {
                    function4.invoke(Boolean.TRUE, Integer.valueOf((int) (((j3 - a16) / 86400000) + qZMoodTimeActivity.MAX_FUTURE_SPAN_DAYS)), Integer.valueOf(c16), Integer.valueOf(c17));
                } else if (longValue < a17) {
                    function4.invoke(Boolean.TRUE, Integer.valueOf((int) ((-Math.ceil((a16 - a17) / 8.64E7d)) + qZMoodTimeActivity.MAX_FUTURE_SPAN_DAYS)), Integer.valueOf(c16), Integer.valueOf(c17));
                } else {
                    function4.invoke(Boolean.FALSE, 0, 0, 0);
                }
                return Unit.INSTANCE;
            }
        }, new Function2<Long, DatePickerState, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qzone.pages.QZMoodTimeActivity$QZTimeSettingPage$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Long l3, DatePickerState datePickerState) {
                long longValue = l3.longValue();
                KLog kLog = KLog.INSTANCE;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onSelected, timestamp: ");
                sb5.append(longValue);
                sb5.append(", publishTime: ");
                sb5.append(QZMoodTimeActivity.this.publishTime);
                sb5.append(", current: ");
                zz0.a aVar = zz0.a.f453719a;
                sb5.append(aVar.a());
                kLog.i("QzoneMoodTime", sb5.toString());
                mutableState2.setValue(Boolean.FALSE);
                long a16 = aVar.a();
                if (longValue < a16) {
                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("selected illegal time, reset to current time. error time: ");
                    m3.append(bVar.a(longValue, "yyyy-MM-dd HH:mm:ss"));
                    kLog.e("QzoneMoodTime", m3.toString());
                    QZMoodTimeActivity.this.publishTime.setValue(Long.valueOf(a16));
                } else {
                    QZMoodTimeActivity qZMoodTimeActivity = QZMoodTimeActivity.this;
                    long j3 = a16 + qZMoodTimeActivity.MAX_FUTURE_SPAN_MILLISECONDS;
                    if (longValue > j3) {
                        qZMoodTimeActivity.publishTime.setValue(Long.valueOf(j3));
                    } else {
                        qZMoodTimeActivity.publishTime.setValue(Long.valueOf(longValue));
                    }
                }
                QZMoodTimeActivity.access$postResult(QZMoodTimeActivity.this);
                return Unit.INSTANCE;
            }
        }, startRestartGroup, 8, 48, 994);
        boolean booleanValue = ((Boolean) mutableState3.getValue()).booleanValue();
        QUIAlertDialogItem[] qUIAlertDialogItemArr = new QUIAlertDialogItem[2];
        qUIAlertDialogItemArr[0] = QUIAlertDialogKt.QUIAlertDialogNormalTextItem("\u53d6\u6d88", new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qzone.pages.QZMoodTimeActivity$QZTimeSettingPage$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                mutableState3.setValue(Boolean.FALSE);
                this.scheduleDelete.setValue(0L);
                QZMoodTimeActivity.access$postResult(this);
                return Unit.INSTANCE;
            }
        });
        startRestartGroup.startReplaceableGroup(1157296644);
        boolean changed = startRestartGroup.changed(mutableState3);
        Object rememberedValue4 = startRestartGroup.rememberedValue();
        if (changed || rememberedValue4 == companion.getEmpty()) {
            rememberedValue4 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qzone.pages.QZMoodTimeActivity$QZTimeSettingPage$7$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    mutableState3.setValue(Boolean.FALSE);
                    return Unit.INSTANCE;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue4);
        }
        startRestartGroup.endReplaceableGroup();
        qUIAlertDialogItemArr[1] = QUIAlertDialogKt.QUIAlertDialogNormalTextItem("\u786e\u8ba4", (Function0) rememberedValue4);
        QUIAlertDialogKt.QUIAlertDialog(booleanValue, "", "\u53d1\u8868\u540e\uff0c\u8be5\u8bf4\u8bf4\u5c06\u572824\u5c0f\u65f6\u540e\u81ea\u52a8\u5220\u9664\uff0c\u8be5\u8bbe\u7f6e\u4e0d\u53ef\u64a4\u56de", null, qUIAlertDialogItemArr, null, null, startRestartGroup, 33200, 104);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qzone.pages.QZMoodTimeActivity$QZTimeSettingPage$8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QZMoodTimeActivity.this.QZTimeSettingPage(composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
