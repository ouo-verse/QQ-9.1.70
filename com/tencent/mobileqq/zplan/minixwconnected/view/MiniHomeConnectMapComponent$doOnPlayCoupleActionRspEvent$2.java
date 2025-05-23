package com.tencent.mobileqq.zplan.minixwconnected.view;

import com.tencent.filament.zplan.scene.xwconnect.handler.MiniHomeConnectPlayCoupleActionHandler;
import com.tencent.mobileqq.zplan.minihome.MiniHomeNetworkKt;
import com.tencent.mobileqq.zplan.minixwconnected.data.GuestActionInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.minixwconnected.view.MiniHomeConnectMapComponent$doOnPlayCoupleActionRspEvent$2", f = "MiniHomeConnectMapComponent.kt", i = {}, l = {418}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
public final class MiniHomeConnectMapComponent$doOnPlayCoupleActionRspEvent$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MiniHomeConnectPlayCoupleActionHandler.c $event;
    Object L$0;
    int label;
    final /* synthetic */ MiniHomeConnectMapComponent this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniHomeConnectMapComponent$doOnPlayCoupleActionRspEvent$2(MiniHomeConnectPlayCoupleActionHandler.c cVar, MiniHomeConnectMapComponent miniHomeConnectMapComponent, Continuation<? super MiniHomeConnectMapComponent$doOnPlayCoupleActionRspEvent$2> continuation) {
        super(2, continuation);
        this.$event = cVar;
        this.this$0 = miniHomeConnectMapComponent;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MiniHomeConnectMapComponent$doOnPlayCoupleActionRspEvent$2(this.$event, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Map map;
        Map map2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            MiniHomeConnectPlayCoupleActionHandler.c cVar = this.$event;
            if (cVar != null) {
                int reqActionId = cVar.getReqActionId();
                map = this.this$0.masterActionIdToGuestActionInfoMap;
                GuestActionInfo guestActionInfo = (GuestActionInfo) map.get(Boxing.boxInt(reqActionId));
                if (guestActionInfo != null) {
                    MiniHomeConnectMapComponent miniHomeConnectMapComponent = this.this$0;
                    guestActionInfo.d(guestActionInfo.getTimes() - 1);
                    if (guestActionInfo.getTimes() <= 0) {
                        map2 = miniHomeConnectMapComponent.masterActionIdToGuestActionInfoMap;
                        map2.remove(Boxing.boxInt(reqActionId));
                    }
                    int guestActionId = guestActionInfo.getGuestActionId();
                    long guestUin = guestActionInfo.getGuestUin();
                    QLog.i("MiniHomeConnectMapComponent", 1, "start requestReportPlayActionEvent, guestUin: " + guestUin + ", masterActionId: " + reqActionId + ", guestActionId: " + guestActionId);
                    this.L$0 = guestActionInfo;
                    this.label = 1;
                    if (MiniHomeNetworkKt.k(guestUin, reqActionId, guestActionId, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                return Unit.INSTANCE;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MiniHomeConnectMapComponent$doOnPlayCoupleActionRspEvent$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
