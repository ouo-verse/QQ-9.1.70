package com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieMyTtsVoiceState;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieOIDBServer$requestEditUserTts$1;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsDataManager;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsInfo;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsSettingViewModel;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.kuikly.core.coroutines.BuildersKt;
import com.tencent.kuikly.core.coroutines.e;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import f25.j;
import h25.f;
import h25.q;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public /* synthetic */ class TtsListKt$TtsList$3 extends FunctionReferenceImpl implements Function1<AdelieTtsInfo, Unit> {
    public final /* synthetic */ AdelieTtsSettingViewModel $viewModel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TtsListKt$TtsList$3(AdelieTtsSettingViewModel adelieTtsSettingViewModel) {
        super(1, Intrinsics.Kotlin.class, "onRetry", "TtsList$onRetry(Lcom/tencent/hippykotlin/demo/pages/adelie/page/compose/tts/AdelieTtsSettingViewModel;Lcom/tencent/hippykotlin/demo/pages/adelie/page/compose/tts/AdelieTtsInfo;)V", 0);
        this.$viewModel = adelieTtsSettingViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(AdelieTtsInfo adelieTtsInfo) {
        final AdelieTtsInfo adelieTtsInfo2 = adelieTtsInfo;
        final AdelieTtsSettingViewModel adelieTtsSettingViewModel = this.$viewModel;
        KLog kLog = KLog.INSTANCE;
        kLog.i("LazyListScope.TtsList", "retry ttsInfo=" + adelieTtsInfo2);
        if (adelieTtsInfo2.getState() == AdelieMyTtsVoiceState.CANNOT) {
            ((BridgeModule) c.f117352a.g().acquireModule("HRBridgeModule")).qToast("\u751f\u6210\u5931\u8d25\uff0c\u8bf7\u5220\u9664\u58f0\u97f3\u91cd\u65b0\u521b\u5efa", QToastMode.Warning);
        } else if (adelieTtsInfo2.getState() == AdelieMyTtsVoiceState.ERROR) {
            if (AdelieTtsDataManager.INSTANCE.hasVoiceIsCreate()) {
                ((BridgeModule) c.f117352a.g().acquireModule("HRBridgeModule")).qToast("\u58f0\u97f3\u751f\u6210\u4e2d\uff0c\u8bf7\u7a0d\u5019", QToastMode.Warning);
            } else {
                adelieTtsInfo2.state$delegate.setValue(AdelieMyTtsVoiceState.LOADING);
                adelieTtsSettingViewModel.getClass();
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("retryRequestVoice id: ");
                m3.append(adelieTtsInfo2.ttsId);
                m3.append(" name: ");
                m3.append(adelieTtsInfo2.getTtsName());
                kLog.i("AdelieTtsSettingViewModel", m3.toString());
                j jVar = adelieTtsInfo2.ttsInfo;
                final Function3<f, Integer, String, Unit> function3 = new Function3<f, Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsSettingViewModel$retryRequestVoice$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public final Unit invoke(f fVar, Integer num, String str) {
                        f fVar2 = fVar;
                        String str2 = str;
                        if (num.intValue() == 0 && fVar2 != null) {
                            AdelieTtsInfo.this.taskId = fVar2.f404200d;
                            adelieTtsSettingViewModel.getTtsInfoStateManager().monitorTtsState(fVar2.f404200d, PollingEntrance.CURRENT_CREATE);
                        } else {
                            ((BridgeModule) c.f117352a.g().acquireModule("HRBridgeModule")).qToast(str2, QToastMode.Info);
                            AdelieTtsInfo adelieTtsInfo3 = AdelieTtsInfo.this;
                            adelieTtsInfo3.state$delegate.setValue(AdelieMyTtsVoiceState.ERROR);
                        }
                        return Unit.INSTANCE;
                    }
                };
                BuildersKt.e(e.f117232d, null, null, new AdelieOIDBServer$requestEditUserTts$1(new Function3<Integer, String, q, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsSettingViewModel$editUserTts$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public final Unit invoke(Integer num, String str, q qVar) {
                        int intValue = num.intValue();
                        String str2 = str;
                        q qVar2 = qVar;
                        KLog.INSTANCE.i("AdelieTtsSettingViewModel", "editUserTts response: " + qVar2);
                        if (intValue == 0 && qVar2 != null) {
                            function3.invoke(qVar2.f404225d, Integer.valueOf(intValue), str2);
                        } else {
                            function3.invoke(null, Integer.valueOf(intValue), str2);
                        }
                        return Unit.INSTANCE;
                    }
                }, 4, jVar, null), 3, null);
            }
        }
        return Unit.INSTANCE;
    }
}
