package com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.view;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.model.ReportAction;
import com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.view.BaseVipTrackerView;
import com.tencent.kuikly.core.coroutines.BuildersKt;
import com.tencent.kuikly.core.coroutines.b;
import com.tencent.kuikly.core.manager.c;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.view.BaseVipTrackerView$startMarkStayTimeIfNeed$1", f = "BaseVipTracker.kt", i = {0, 0}, l = {364}, m = "invokeSuspend", n = {"$this$launch", "count"}, s = {"L$0", "I$0"})
/* loaded from: classes33.dex */
public final class BaseVipTrackerView$startMarkStayTimeIfNeed$1 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
    public int I$0;
    public /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ BaseVipTrackerView<BaseVipTrackerViewAttr, BaseVipTrackerViewEvent> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseVipTrackerView$startMarkStayTimeIfNeed$1(BaseVipTrackerView<BaseVipTrackerViewAttr, BaseVipTrackerViewEvent> baseVipTrackerView, Continuation<? super BaseVipTrackerView$startMarkStayTimeIfNeed$1> continuation) {
        super(2, continuation);
        this.this$0 = baseVipTrackerView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        BaseVipTrackerView$startMarkStayTimeIfNeed$1 baseVipTrackerView$startMarkStayTimeIfNeed$1 = new BaseVipTrackerView$startMarkStayTimeIfNeed$1(this.this$0, continuation);
        baseVipTrackerView$startMarkStayTimeIfNeed$1.L$0 = obj;
        return baseVipTrackerView$startMarkStayTimeIfNeed$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(b bVar, Continuation<? super Unit> continuation) {
        return ((BaseVipTrackerView$startMarkStayTimeIfNeed$1) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        b bVar;
        int i3;
        int min;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i16 = this.label;
        if (i16 == 0) {
            ResultKt.throwOnFailure(obj);
            bVar = (b) this.L$0;
            i3 = 0;
        } else if (i16 == 1) {
            i3 = this.I$0;
            bVar = (b) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        do {
            long currentTimeStamp = ((BridgeModule) c.f117352a.g().acquireModule("HRBridgeModule")).currentTimeStamp() - this.this$0.createdTime;
            if (currentTimeStamp > 60000) {
                return Unit.INSTANCE;
            }
            min = Math.min(2 << i3, 10) * 1000;
            BaseVipTrackerView<BaseVipTrackerViewAttr, BaseVipTrackerViewEvent> baseVipTrackerView = this.this$0;
            BaseVipTrackerView.reportAction$default(baseVipTrackerView, new ReportAction(133, currentTimeStamp, ((Number) BaseVipTrackerView.access$getAttr(baseVipTrackerView).tracker.stayAttr$delegate.getValue()).intValue()), null, null, null, null, null, null, null, 254, null);
            i3++;
            BaseVipTrackerView.Companion companion = BaseVipTrackerView.Companion;
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("MarkStayTime ");
            m3.append(BaseVipTrackerView.access$getAttr(this.this$0).tracker.appId);
            m3.append(TokenParser.SP);
            m3.append(BaseVipTrackerView.access$getAttr(this.this$0).tracker.pageId);
            m3.append(TokenParser.SP);
            m3.append(min);
            companion.log(m3.toString());
            this.L$0 = bVar;
            this.I$0 = i3;
            this.label = 1;
        } while (BuildersKt.c(bVar, min, this) != coroutine_suspended);
        return coroutine_suspended;
    }
}
