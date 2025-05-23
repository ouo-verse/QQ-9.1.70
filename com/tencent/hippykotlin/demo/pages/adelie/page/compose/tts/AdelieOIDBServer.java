package com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.module.OIDBResponse;
import com.tencent.kuikly.core.coroutines.BuildersKt;
import com.tencent.kuikly.core.coroutines.e;
import com.tencent.kuikly.core.log.KLog;
import h25.aj;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class AdelieOIDBServer {
    public static final AdelieOIDBServer INSTANCE = new AdelieOIDBServer();

    public static final void access$handleResponse(OIDBResponse oIDBResponse, Function3 function3) {
        if (oIDBResponse.rsp != 0 && oIDBResponse.success) {
            function3.invoke(Integer.valueOf(oIDBResponse.code), oIDBResponse.f114186msg, oIDBResponse.rsp);
        } else {
            function3.invoke(Integer.valueOf(oIDBResponse.code), oIDBResponse.f114186msg, null);
        }
    }

    public static final void queryTask$pollTaskState(Ref.IntRef intRef, Function3<? super Integer, ? super String, ? super aj, Unit> function3, String str) {
        intRef.element++;
        ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("current poll count = "), intRef.element, KLog.INSTANCE, "AdelieOIDBServer");
        BuildersKt.e(e.f117232d, null, null, new AdelieOIDBServer$queryTask$pollTaskState$1(function3, intRef, str, null), 3, null);
    }
}
