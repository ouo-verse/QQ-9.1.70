package com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.PopDownMenuLogic$deleteTtsInfo$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.kuikly.core.coroutines.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.LiveCouponReceiveViewModel$jumpToLiveWindow$1", f = "LiveCouponReceiveViewModel.kt", i = {}, l = {112}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class LiveCouponReceiveViewModel$jumpToLiveWindow$1 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
    public final /* synthetic */ BridgeModule $bridgeModule;
    public final /* synthetic */ String $couponBatchId;
    public final /* synthetic */ long $liveEnterRoomTime;
    public final /* synthetic */ String $liveProgramId;
    public final /* synthetic */ long $liveRoomId;
    public final /* synthetic */ long $liveUserId;
    public final /* synthetic */ e $userData;
    public int label;
    public final /* synthetic */ LiveCouponReceiveViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveCouponReceiveViewModel$jumpToLiveWindow$1(BridgeModule bridgeModule, e eVar, long j3, long j16, long j17, String str, String str2, LiveCouponReceiveViewModel liveCouponReceiveViewModel, Continuation<? super LiveCouponReceiveViewModel$jumpToLiveWindow$1> continuation) {
        super(2, continuation);
        this.$bridgeModule = bridgeModule;
        this.$userData = eVar;
        this.$liveUserId = j3;
        this.$liveRoomId = j16;
        this.$liveEnterRoomTime = j17;
        this.$liveProgramId = str;
        this.$couponBatchId = str2;
        this.this$0 = liveCouponReceiveViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LiveCouponReceiveViewModel$jumpToLiveWindow$1(this.$bridgeModule, this.$userData, this.$liveUserId, this.$liveRoomId, this.$liveEnterRoomTime, this.$liveProgramId, this.$couponBatchId, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(b bVar, Continuation<? super Unit> continuation) {
        return ((LiveCouponReceiveViewModel$jumpToLiveWindow$1) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Continuation intercepted;
        Object coroutine_suspended2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            BridgeModule bridgeModule = this.$bridgeModule;
            this.label = 1;
            bridgeModule.getClass();
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(this);
            final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
            bridgeModule.localServeTime(new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.BridgeModule$localServeTime$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(e eVar) {
                    safeContinuation.resumeWith(Result.m476constructorimpl(eVar));
                    return Unit.INSTANCE;
                }
            });
            obj = safeContinuation.getOrThrow();
            coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (obj == coroutine_suspended2) {
                DebugProbes.probeCoroutineSuspended(this);
            }
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        e eVar = (e) obj;
        long h16 = (eVar != null ? (long) eVar.h("time") : 0L) * 1000;
        int j3 = this.$userData.j("liveType");
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("mqqapi://ecommerce/open?target=19&channel=8&is_master=0&is_live_opened=1&is_trans_activity=1&is_appcompat_style=1&live_user_id=");
        m3.append(this.$liveUserId);
        m3.append("&live_room_id=");
        m3.append(this.$liveRoomId);
        m3.append("&live_play_time=");
        m3.append(h16 - this.$liveEnterRoomTime);
        m3.append("&live_program_id=");
        StringBuilder m16 = PopDownMenuLogic$deleteTtsInfo$1$$ExternalSyntheticOutline0.m(m3, this.$liveProgramId, "&live_type=", j3, "&coupon_id=");
        m16.append(this.$couponBatchId);
        BridgeModule.openPage$default(this.$bridgeModule, m16.toString(), true, null, null, 28);
        Utils utils = Utils.INSTANCE;
        String str = this.this$0.pagerId;
        StringBuilder m17 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("LiveCouponReceivePage handleUseCouponBtnClicked: couponId:");
        m17.append(this.$couponBatchId);
        utils.bridgeModule(str).log(m17.toString());
        return Unit.INSTANCE;
    }
}
