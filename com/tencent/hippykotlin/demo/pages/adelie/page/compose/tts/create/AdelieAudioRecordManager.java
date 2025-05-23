package com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.create;

import com.tencent.hippykotlin.demo.pages.adelie.common.compose.util.StateHolder;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util.ReportKt;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.AdelieAudioRecordFrequencyView;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.AdelieAudioRecordFrequencyView$endRecording$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.module.AdelieKuiklyTTSPageModule;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.kuikly.core.coroutines.BuildersKt;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.timer.TimerKt;
import h25.ak;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import yo3.Size;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class AdelieAudioRecordManager {
    public Size buttonSize;
    public AdelieAudioRecordFrequencyView frequencyView;
    public StateHolder<Boolean> isPressedInside;
    public StateHolder<Boolean> isRecording;
    public StateHolder<Boolean> isResetButton;
    public long lastClickTime;
    public String recoredTimer;
    public final AdelieCreateTtsViewModel viewModel;

    public AdelieAudioRecordManager(AdelieCreateTtsViewModel adelieCreateTtsViewModel) {
        this.viewModel = adelieCreateTtsViewModel;
        Boolean bool = Boolean.FALSE;
        this.isRecording = new StateHolder<>(bool);
        this.isPressedInside = new StateHolder<>(Boolean.TRUE);
        this.buttonSize = Size.INSTANCE.a();
        this.isResetButton = new StateHolder<>(bool);
        this.recoredTimer = "";
    }

    public final void endRecord(final Function1<? super Boolean, Unit> function1) {
        TimerKt.b(this.recoredTimer);
        this.recoredTimer = "";
        Boolean value = this.isRecording._state.getValue();
        Boolean bool = Boolean.FALSE;
        if (Intrinsics.areEqual(value, bool)) {
            KLog.INSTANCE.i("AdelieTtsSettingViewModel", "need not endRecord");
            return;
        }
        this.isRecording._state.setValue(bool);
        if (Intrinsics.areEqual(this.isPressedInside._state.getValue(), bool)) {
            StateHolder<Boolean> stateHolder = this.isPressedInside;
            stateHolder._state.setValue(Boolean.TRUE);
            AdelieAudioRecordFrequencyView adelieAudioRecordFrequencyView = this.frequencyView;
            if (adelieAudioRecordFrequencyView != null) {
                int i3 = AdelieAudioRecordFrequencyView.$r8$clinit;
                e eVar = new e();
                eVar.t("isCancel", 1);
                final Function2 function2 = null;
                adelieAudioRecordFrequencyView.callRenderViewMethod("endRecording", eVar.toString(), new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.AdelieAudioRecordFrequencyView$endRecording$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(e eVar2) {
                        String str;
                        e eVar3 = eVar2;
                        Function2<String, Double, Unit> function22 = function2;
                        if (function22 != null) {
                            AdelieAudioRecordFrequencyView$endRecording$1$$ExternalSyntheticOutline0.m("endRecording result: ", eVar3, KLog.INSTANCE, "AdelieAudioRecordFrequencyView");
                            e m3 = eVar3 != null ? eVar3.m("data") : null;
                            if (m3 == null || (str = m3.p("filePath")) == null) {
                                str = "";
                            }
                            function22.invoke(str, Double.valueOf(m3 != null ? m3.h("duration") : 0.0d));
                        }
                        return Unit.INSTANCE;
                    }
                });
                return;
            }
            return;
        }
        AdelieAudioRecordFrequencyView adelieAudioRecordFrequencyView2 = this.frequencyView;
        if (adelieAudioRecordFrequencyView2 != null) {
            final Function2<String, Double, Unit> function22 = new Function2<String, Double, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.create.AdelieAudioRecordManager$endRecord$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(String str, Double d16) {
                    String str2 = str;
                    final double doubleValue = d16.doubleValue();
                    if (doubleValue <= 3000.0d) {
                        ((BridgeModule) c.f117352a.g().acquireModule("HRBridgeModule")).qToast("\u5f55\u5236\u65f6\u95f4\u592a\u77ed", QToastMode.Warning);
                    } else {
                        AdelieCreateTtsViewModel adelieCreateTtsViewModel = AdelieAudioRecordManager.this.viewModel;
                        e eVar2 = new e();
                        eVar2.s("ttsTime", doubleValue);
                        Unit unit = Unit.INSTANCE;
                        adelieCreateTtsViewModel.reportDT$enumunboxing$(1, eVar2);
                        final AdelieAudioRecordManager adelieAudioRecordManager = AdelieAudioRecordManager.this;
                        final Function1<Boolean, Unit> function12 = function1;
                        adelieAudioRecordManager.getClass();
                        e eVar3 = new e();
                        ak value2 = adelieAudioRecordManager.viewModel.ttsReadTtsInfo._state.getValue();
                        eVar3.v("text_id", value2 != null ? value2.f404156d : null);
                        eVar3.t("current_state", 2);
                        ReportKt.reportCustomDTEvent("ev_bas_reading_ai_text", eVar3);
                        adelieAudioRecordManager.viewModel.isRecognizing._state.setValue(Boolean.TRUE);
                        final AdelieCreateTtsViewModel adelieCreateTtsViewModel2 = adelieAudioRecordManager.viewModel;
                        final Function3<Boolean, Integer, String, Unit> function3 = new Function3<Boolean, Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.create.AdelieAudioRecordManager$createTtsVoice$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            /* JADX WARN: Code restructure failed: missing block: B:8:0x0031, code lost:
                            
                                if ((r9.length() == 0) == true) goto L13;
                             */
                            @Override // kotlin.jvm.functions.Function3
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                            */
                            public final Unit invoke(Boolean bool2, Integer num, String str3) {
                                boolean booleanValue = bool2.booleanValue();
                                int intValue = num.intValue();
                                String str4 = str3;
                                AdelieAudioRecordManager.this.viewModel.isRecognizing._state.setValue(Boolean.FALSE);
                                boolean z16 = true;
                                if (!booleanValue) {
                                    if (str4 != null) {
                                    }
                                    z16 = false;
                                    if (z16) {
                                        str4 = "\u8bc6\u522b\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5";
                                    } else if (str4 == null) {
                                        str4 = "";
                                    }
                                    ((BridgeModule) c.f117352a.g().acquireModule("HRBridgeModule")).qToast(str4, QToastMode.Warning);
                                    AdelieCreateTtsViewModel adelieCreateTtsViewModel3 = AdelieAudioRecordManager.this.viewModel;
                                    e eVar4 = new e();
                                    double d17 = doubleValue;
                                    eVar4.w("isSuccess", false);
                                    eVar4.t("errorCode", intValue);
                                    eVar4.s("ttsTime", d17);
                                    Unit unit2 = Unit.INSTANCE;
                                    adelieCreateTtsViewModel3.reportDT$enumunboxing$(2, eVar4);
                                } else {
                                    AdelieCreateTtsViewModel adelieCreateTtsViewModel4 = AdelieAudioRecordManager.this.viewModel;
                                    e eVar5 = new e();
                                    double d18 = doubleValue;
                                    eVar5.w("isSuccess", true);
                                    eVar5.s("ttsTime", d18);
                                    Unit unit3 = Unit.INSTANCE;
                                    adelieCreateTtsViewModel4.reportDT$enumunboxing$(2, eVar5);
                                    function12.invoke(Boolean.TRUE);
                                }
                                return Unit.INSTANCE;
                            }
                        };
                        adelieCreateTtsViewModel2.getClass();
                        AdelieKuiklyTTSPageModule adelieKuiklyTTSPageModule = (AdelieKuiklyTTSPageModule) c.f117352a.g().acquireModule("AdelieKuiklyTTSPageModule");
                        Function1<e, Unit> function13 = new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.create.AdelieCreateTtsViewModel$createTtsVoice$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(e eVar4) {
                                String str3;
                                String str4;
                                String str5;
                                e m3;
                                e eVar5 = eVar4;
                                KLog kLog = KLog.INSTANCE;
                                AdelieAudioRecordFrequencyView$endRecording$1$$ExternalSyntheticOutline0.m("uploadAudioFile finish ", eVar5, kLog, "AdelieTtsSettingViewModel");
                                Boolean valueOf = eVar5 != null ? Boolean.valueOf(eVar5.f("success")) : null;
                                Boolean bool2 = Boolean.FALSE;
                                if (Intrinsics.areEqual(valueOf, bool2)) {
                                    function3.invoke(bool2, 7001, eVar5 != null ? eVar5.p("errorMsg") : null);
                                } else {
                                    String str6 = "";
                                    if (eVar5 == null || (m3 = eVar5.m("data")) == null || (str3 = m3.p("audioUrl")) == null) {
                                        str3 = "";
                                    }
                                    if (str3.length() == 0) {
                                        function3.invoke(bool2, 7002, "\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5");
                                    } else {
                                        DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0.m("uploadAudioFile url: ", str3, kLog, "AdelieTtsSettingViewModel");
                                        AdelieCreateTtsViewModel adelieCreateTtsViewModel3 = adelieCreateTtsViewModel2;
                                        Function3<Boolean, Integer, String, Unit> function32 = function3;
                                        adelieCreateTtsViewModel3.getClass();
                                        kLog.i("AdelieTtsSettingViewModel", "createTtsVoiceRequest");
                                        ak value3 = adelieCreateTtsViewModel3.ttsReadTtsInfo._state.getValue();
                                        if (value3 == null || (str4 = value3.f404156d) == null) {
                                            str4 = "";
                                        }
                                        ak value4 = adelieCreateTtsViewModel3.ttsReadTtsInfo._state.getValue();
                                        if (value4 != null && (str5 = value4.f404157e) != null) {
                                            str6 = str5;
                                        }
                                        BuildersKt.e(adelieCreateTtsViewModel3.requestScope, null, null, new AdelieCreateTtsViewModel$createTtsVoiceRequest$1(adelieCreateTtsViewModel3, function32, new ak(str4, str6, str3), null), 3, null);
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        };
                        adelieKuiklyTTSPageModule.getClass();
                        e m3 = AdelieAudioRecordManager$endRecord$1$$ExternalSyntheticOutline0.m("filePath", str2, "commandId", 2020);
                        m3.v("remoteDir", "ugc_tts");
                        adelieKuiklyTTSPageModule.toNative(true, "uploadFile", m3.toString(), function13, false);
                    }
                    return Unit.INSTANCE;
                }
            };
            e eVar2 = new e();
            eVar2.t("isCancel", 0);
            adelieAudioRecordFrequencyView2.callRenderViewMethod("endRecording", eVar2.toString(), new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.AdelieAudioRecordFrequencyView$endRecording$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(e eVar22) {
                    String str;
                    e eVar3 = eVar22;
                    Function2<String, Double, Unit> function222 = function22;
                    if (function222 != null) {
                        AdelieAudioRecordFrequencyView$endRecording$1$$ExternalSyntheticOutline0.m("endRecording result: ", eVar3, KLog.INSTANCE, "AdelieAudioRecordFrequencyView");
                        e m3 = eVar3 != null ? eVar3.m("data") : null;
                        if (m3 == null || (str = m3.p("filePath")) == null) {
                            str = "";
                        }
                        function222.invoke(str, Double.valueOf(m3 != null ? m3.h("duration") : 0.0d));
                    }
                    return Unit.INSTANCE;
                }
            });
        }
    }
}
