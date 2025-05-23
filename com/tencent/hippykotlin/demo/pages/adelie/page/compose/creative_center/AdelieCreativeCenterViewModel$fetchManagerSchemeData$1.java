package com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center;

import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.AdelieAudioRecordFrequencyView$endRecording$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.coroutines.b;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.AdelieCreativeCenterViewModel$fetchManagerSchemeData$1", f = "AdelieCreativeCenterViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class AdelieCreativeCenterViewModel$fetchManagerSchemeData$1 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AdelieCreativeCenterViewModel$fetchManagerSchemeData$1(continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(b bVar, Continuation<? super Unit> continuation) {
        return new AdelieCreativeCenterViewModel$fetchManagerSchemeData$1(continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        KLog.INSTANCE.i("AdelieCreativeCenterViewModel", "get banner data");
        AdelieCreativeCenterDataManager.INSTANCE.getAdelieKuiklyBaseModule().getQQMCConfig("adelie_kuikly_scheme", "{\"adelie_compose\":\"mqqapi://kuikly/open?local_bundle_name=nearbypro&version=1&src_type=web&use_host_display_metrics=1\"}", new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.AdelieCreativeCenterDataManager$fetchManagerSchemeData$1
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar) {
                e eVar2 = eVar;
                AdelieAudioRecordFrequencyView$endRecording$1$$ExternalSyntheticOutline0.m("fetchManagerSchemeData scheme info : ", eVar2, KLog.INSTANCE, "AdelieCreativeCenterDataManager");
                if (eVar2 != null) {
                    try {
                        String q16 = new e(eVar2.q("data", "{}")).q("adelie_compose", "");
                        if (!(q16.length() == 0)) {
                            AdelieCreativeCenterDataManager.managerSchemeConfig = q16;
                        }
                    } catch (Throwable th5) {
                        AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0.m("fetchManagerSchemeData error, ", th5, KLog.INSTANCE, "AdelieCreativeCenterDataManager");
                    }
                }
                return Unit.INSTANCE;
            }
        });
        return Unit.INSTANCE;
    }

    public AdelieCreativeCenterViewModel$fetchManagerSchemeData$1(Continuation<? super AdelieCreativeCenterViewModel$fetchManagerSchemeData$1> continuation) {
        super(2, continuation);
    }
}
