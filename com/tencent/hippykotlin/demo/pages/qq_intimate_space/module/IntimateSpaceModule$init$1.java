package com.tencent.hippykotlin.demo.pages.qq_intimate_space.module;

import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes37.dex */
public final /* synthetic */ class IntimateSpaceModule$init$1 extends FunctionReferenceImpl implements Function1<e, Unit> {
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.LinkedHashMap, java.util.Map<java.lang.String, kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit>>] */
    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(e eVar) {
        e eVar2 = eVar;
        IntimateSpaceModule intimateSpaceModule = (IntimateSpaceModule) this.receiver;
        intimateSpaceModule.getClass();
        if (eVar2 != null) {
            String p16 = eVar2.p("method");
            KLog kLog = KLog.INSTANCE;
            DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0.m("native call compose method: ", p16, kLog, "IntimateSpaceModule");
            if (Intrinsics.areEqual(p16, "onMiniAIODismiss")) {
                kLog.i("IntimateSpaceModule", "onMiniAIODismiss");
                Function1 function1 = (Function1) intimateSpaceModule.eventHandlerMap.get(p16);
                if (function1 != null) {
                    function1.invoke(eVar2.e("params"));
                }
            }
        }
        return Unit.INSTANCE;
    }

    public IntimateSpaceModule$init$1(Object obj) {
        super(1, obj, IntimateSpaceModule.class, "call", "call(Lcom/tencent/kuikly/core/nvi/serialization/json/JSONObject;)V", 0);
    }
}
