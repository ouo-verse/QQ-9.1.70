package com.tencent.hippykotlin.demo.pages.nearby.mood_group.repo;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.module.PbResponse;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyApi$sendPbRequest$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporter;
import com.tencent.kuikly.core.log.KLog;
import java.util.List;
import k35.c;
import k35.e;
import k35.i;
import k35.p;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* loaded from: classes31.dex */
public final class NBPMoodGroupRepo implements INBPMoodGroupRepo {
    @Override // com.tencent.hippykotlin.demo.pages.nearby.mood_group.repo.INBPMoodGroupRepo
    public final void getAll(int i3, final Function3<? super c, ? super Integer, ? super String, Unit> function3) {
        KLog.INSTANCE.i("NBPMoodGroupRepo", "getAll: mid=" + i3);
        GetAllRequest getAllRequest = new GetAllRequest(i3);
        Function1<PbResponse<c>, Unit> function1 = new Function1<PbResponse<c>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.repo.NBPMoodGroupRepo$getAll$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(PbResponse<c> pbResponse) {
                PbResponse<c> pbResponse2 = pbResponse;
                KLog kLog = KLog.INSTANCE;
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("getAll response, msg=");
                m3.append(pbResponse2.f114187msg);
                m3.append(", code=");
                ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0.m(m3, pbResponse2.code, kLog, "NBPMoodGroupRepo");
                function3.invoke(pbResponse2.rsp, Integer.valueOf(pbResponse2.code), pbResponse2.f114187msg);
                return Unit.INSTANCE;
            }
        };
        APICallTechReporter aPICallTechReporter = new APICallTechReporter(1, "trpc.lplan.mood_svr.MoodSvr.SsoGetAll");
        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
        QQKuiklyPlatformApi.Companion.sendPbRequest$default(getAllRequest, null, new NearbyApi$sendPbRequest$1(aPICallTechReporter, function1), 6);
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.mood_group.repo.INBPMoodGroupRepo
    public final void getBarrage(int i3, List<Long> list, final Function3<? super e, ? super Integer, ? super String, Unit> function3) {
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("getBarrage: ");
        m3.append(list.size());
        kLog.i("NBPMoodGroupRepo", m3.toString());
        GetBarrageRequest getBarrageRequest = new GetBarrageRequest(i3, list);
        Function1<PbResponse<e>, Unit> function1 = new Function1<PbResponse<e>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.repo.NBPMoodGroupRepo$getBarrage$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(PbResponse<e> pbResponse) {
                PbResponse<e> pbResponse2 = pbResponse;
                KLog kLog2 = KLog.INSTANCE;
                StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("getBarrage response, ");
                m16.append(pbResponse2.f114187msg);
                m16.append(", ");
                ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0.m(m16, pbResponse2.code, kLog2, "NBPMoodGroupRepo");
                function3.invoke(pbResponse2.rsp, Integer.valueOf(pbResponse2.code), pbResponse2.f114187msg);
                return Unit.INSTANCE;
            }
        };
        APICallTechReporter aPICallTechReporter = new APICallTechReporter(1, "trpc.lplan.mood_svr.MoodSvr.SsoGetBarrage");
        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
        QQKuiklyPlatformApi.Companion.sendPbRequest$default(getBarrageRequest, null, new NearbyApi$sendPbRequest$1(aPICallTechReporter, function1), 6);
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.mood_group.repo.INBPMoodGroupRepo
    public final void interact(long j3, int i3, long j16, final Function3<? super i, ? super Integer, ? super String, Unit> function3) {
        KLog.INSTANCE.i("NBPMoodGroupRepo", "interact: " + j16);
        InteractRequest interactRequest = new InteractRequest(j3, i3, j16);
        Function1<PbResponse<i>, Unit> function1 = new Function1<PbResponse<i>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.repo.NBPMoodGroupRepo$interact$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(PbResponse<i> pbResponse) {
                PbResponse<i> pbResponse2 = pbResponse;
                KLog kLog = KLog.INSTANCE;
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("interact response, ");
                m3.append(pbResponse2.f114187msg);
                m3.append(", ");
                ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0.m(m3, pbResponse2.code, kLog, "NBPMoodGroupRepo");
                function3.invoke(pbResponse2.rsp, Integer.valueOf(pbResponse2.code), pbResponse2.f114187msg);
                return Unit.INSTANCE;
            }
        };
        APICallTechReporter aPICallTechReporter = new APICallTechReporter(1, "trpc.lplan.mood_svr.MoodSvr.SsoInteract");
        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
        QQKuiklyPlatformApi.Companion.sendPbRequest$default(interactRequest, null, new NearbyApi$sendPbRequest$1(aPICallTechReporter, function1), 6);
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.mood_group.repo.INBPMoodGroupRepo
    public final void sendBarrage(int i3, long j3, final Function3<? super p, ? super Integer, ? super String, Unit> function3) {
        KLog.INSTANCE.i("NBPMoodGroupRepo", "sendBarrage: " + j3);
        SendBarrageRequest sendBarrageRequest = new SendBarrageRequest(i3, j3);
        Function1<PbResponse<p>, Unit> function1 = new Function1<PbResponse<p>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.repo.NBPMoodGroupRepo$sendBarrage$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(PbResponse<p> pbResponse) {
                PbResponse<p> pbResponse2 = pbResponse;
                KLog kLog = KLog.INSTANCE;
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("sendBarrage response, ");
                m3.append(pbResponse2.f114187msg);
                m3.append(", ");
                ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0.m(m3, pbResponse2.code, kLog, "NBPMoodGroupRepo");
                function3.invoke(pbResponse2.rsp, Integer.valueOf(pbResponse2.code), pbResponse2.f114187msg);
                return Unit.INSTANCE;
            }
        };
        APICallTechReporter aPICallTechReporter = new APICallTechReporter(1, "trpc.lplan.mood_svr.MoodSvr.SsoSendBarrage");
        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
        QQKuiklyPlatformApi.Companion.sendPbRequest$default(sendBarrageRequest, null, new NearbyApi$sendPbRequest$1(aPICallTechReporter, function1), 6);
    }
}
