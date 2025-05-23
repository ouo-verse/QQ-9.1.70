package com.tencent.hippykotlin.demo.pages.qq_intimate_space.utils;

import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.kuikly.core.coroutines.b;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.qq_intimate_space.utils.DTReportKt$reportElementClickEvent$1", f = "DTReport.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes37.dex */
public final class DTReportKt$reportElementClickEvent$1 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
    public final /* synthetic */ String $elementId;
    public final /* synthetic */ e $elementParams;
    public final /* synthetic */ String $pageId;
    public final /* synthetic */ e $pageParams;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DTReportKt$reportElementClickEvent$1(e eVar, e eVar2, String str, String str2, Continuation<? super DTReportKt$reportElementClickEvent$1> continuation) {
        super(2, continuation);
        this.$pageParams = eVar;
        this.$elementParams = eVar2;
        this.$pageId = str;
        this.$elementId = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DTReportKt$reportElementClickEvent$1(this.$pageParams, this.$elementParams, this.$pageId, this.$elementId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(b bVar, Continuation<? super Unit> continuation) {
        return ((DTReportKt$reportElementClickEvent$1) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        e eVar = this.$pageParams;
        if (eVar != null) {
            this.$elementParams.v("cur_pg", eVar);
        }
        this.$elementParams.v("dt_pgid", this.$pageId);
        this.$elementParams.v("dt_eid", this.$elementId);
        ((BridgeModule) c.f117352a.g().acquireModule("HRBridgeModule")).reportCustomDtEvent("dt_clck", this.$elementParams);
        return Unit.INSTANCE;
    }
}
