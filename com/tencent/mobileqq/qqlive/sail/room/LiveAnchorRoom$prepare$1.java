package com.tencent.mobileqq.qqlive.sail.room;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qqlive.sail.model.AnchorRoomInfo;
import com.tencent.mobileqq.qqlive.sso.request.LiveAnchorPrepareRequest;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.AegisLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.qqlive.sail.room.LiveAnchorRoom$prepare$1", f = "LiveAnchorRoom.kt", i = {}, l = {95}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes17.dex */
final class LiveAnchorRoom$prepare$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ Function1<l<AnchorRoomInfo>, Unit> $callback;
    final /* synthetic */ byte[] $extBytes;
    int label;
    final /* synthetic */ LiveAnchorRoom this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveAnchorRoom$prepare$1(LiveAnchorRoom liveAnchorRoom, byte[] bArr, Function1<? super l<AnchorRoomInfo>, Unit> function1, Continuation<? super LiveAnchorRoom$prepare$1> continuation) {
        super(2, continuation);
        this.this$0 = liveAnchorRoom;
        this.$extBytes = bArr;
        this.$callback = function1;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, liveAnchorRoom, bArr, function1, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new LiveAnchorRoom$prepare$1(this.this$0, this.$extBytes, this.$callback, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Object sendRequestOnSuspend;
        AnchorRoomInfo a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                    sendRequestOnSuspend = obj;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                if (this.this$0.M().c() == 10) {
                    AegisLogger.INSTANCE.i(this.this$0.N(), "prepare", "room is preparing now");
                    return Unit.INSTANCE;
                }
                if (!this.this$0.M().b(10)) {
                    AegisLogger.INSTANCE.w(this.this$0.N(), "prepare", "cannot change to prepared state, " + this.this$0.M());
                    return Unit.INSTANCE;
                }
                this.this$0.M().a(10);
                LiveAnchorPrepareRequest liveAnchorPrepareRequest = new LiveAnchorPrepareRequest(this.this$0.J(), this.$extBytes);
                ILiveNetRequest iLiveNetRequest = (ILiveNetRequest) QRoute.api(ILiveNetRequest.class);
                this.label = 1;
                sendRequestOnSuspend = iLiveNetRequest.sendRequestOnSuspend(liveAnchorPrepareRequest, this);
                if (sendRequestOnSuspend == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            l<AnchorRoomInfo> l3 = com.tencent.mobileqq.qqlive.sail.model.a.l((QQLiveResponse) sendRequestOnSuspend);
            LiveAnchorRoom liveAnchorRoom = this.this$0;
            Function1<l<AnchorRoomInfo>, Unit> function1 = this.$callback;
            if (l3.b() == 0) {
                AnchorRoomInfo d16 = l3.d();
                Intrinsics.checkNotNull(d16);
                a16 = r5.a((r28 & 1) != 0 ? r5.avConfig : null, (r28 & 2) != 0 ? r5.basicInfo : null, (r28 & 4) != 0 ? r5.settingInfo : null, (r28 & 8) != 0 ? r5.anchorInfo : null, (r28 & 16) != 0 ? r5.trtcInfo : null, (r28 & 32) != 0 ? r5.thirdPushInfo : null, (r28 & 64) != 0 ? r5.heartBeatTime : 0L, (r28 & 128) != 0 ? r5.appId : null, (r28 & 256) != 0 ? r5.enterRoomTime : 0L, (r28 & 512) != 0 ? r5.popupDialogUrl : null, (r28 & 1024) != 0 ? d16.backgroundInfo : null);
                liveAnchorRoom.Q(a16);
                liveAnchorRoom.L().x(liveAnchorRoom.J());
                liveAnchorRoom.M().a(20);
            } else {
                AegisLogger.INSTANCE.w(liveAnchorRoom.N(), "prepare", "failed, result=" + l3);
                liveAnchorRoom.M().a(0);
            }
            function1.invoke(l3);
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((LiveAnchorRoom$prepare$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
