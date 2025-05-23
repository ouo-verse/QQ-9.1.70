package com.tencent.mobileqq.qqlive.sail.room;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qqlive.sail.model.AnchorRoomInfo;
import com.tencent.mobileqq.qqlive.sso.request.LiveHeartbeatRequest;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.AegisLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.qqlive.sail.room.LiveHeartbeatJob$heartBeat$1", f = "LiveHeartbeatJob.kt", i = {0, 0, 0, 1, 1, 1}, l = {32, 60}, m = "invokeSuspend", n = {"$this$launch", Const.BUNDLE_KEY_REQUEST, "delayTimeMs", "$this$launch", Const.BUNDLE_KEY_REQUEST, "delayTimeMs"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
/* loaded from: classes17.dex */
public final class LiveHeartbeatJob$heartBeat$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ LiveHeartbeatJob this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveHeartbeatJob$heartBeat$1(LiveHeartbeatJob liveHeartbeatJob, Continuation<? super LiveHeartbeatJob$heartBeat$1> continuation) {
        super(2, continuation);
        this.this$0 = liveHeartbeatJob;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) liveHeartbeatJob, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        LiveHeartbeatJob$heartBeat$1 liveHeartbeatJob$heartBeat$1 = new LiveHeartbeatJob$heartBeat$1(this.this$0, continuation);
        liveHeartbeatJob$heartBeat$1.L$0 = obj;
        return liveHeartbeatJob$heartBeat$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x009b, code lost:
    
        r10 = new com.tencent.mobileqq.qqlive.sso.request.LiveHeartbeatRequest(r12, r11.getRoomId(), 0, 4, null);
        r11 = new kotlin.jvm.internal.Ref.LongRef();
        r11.element = r5;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01be A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x011b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x01bf -> B:13:0x01c0). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        CoroutineScope coroutineScope;
        LiveHeartbeatJob$heartBeat$1 liveHeartbeatJob$heartBeat$1;
        CoroutineScope coroutineScope2;
        Ref.LongRef longRef;
        LiveHeartbeatRequest liveHeartbeatRequest;
        l<lt3.c> k3;
        AegisLogger.Companion companion;
        AnchorRoomInfo anchorRoomInfo;
        long j3;
        AnchorRoomInfo anchorRoomInfo2;
        AnchorRoomInfo anchorRoomInfo3;
        AnchorRoomInfo a16;
        int coerceAtLeast;
        long j16;
        char c16;
        AnchorRoomInfo anchorRoomInfo4;
        AnchorRoomInfo anchorRoomInfo5;
        com.tencent.mobileqq.qqlive.sail.model.d dVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }
        Object obj2 = obj;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        long j17 = 1000;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    Ref.LongRef longRef2 = (Ref.LongRef) this.L$2;
                    liveHeartbeatRequest = (LiveHeartbeatRequest) this.L$1;
                    CoroutineScope coroutineScope3 = (CoroutineScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    long j18 = 1000;
                    coroutineScope = coroutineScope3;
                    c16 = 2;
                    longRef = longRef2;
                    liveHeartbeatJob$heartBeat$1 = this;
                    j17 = j18;
                    if (CoroutineScopeKt.isActive(coroutineScope)) {
                        ILiveNetRequest iLiveNetRequest = (ILiveNetRequest) QRoute.api(ILiveNetRequest.class);
                        liveHeartbeatJob$heartBeat$1.L$0 = coroutineScope;
                        liveHeartbeatJob$heartBeat$1.L$1 = liveHeartbeatRequest;
                        liveHeartbeatJob$heartBeat$1.L$2 = longRef;
                        liveHeartbeatJob$heartBeat$1.label = 1;
                        if (iLiveNetRequest.sendRequestOnSuspend(liveHeartbeatRequest, liveHeartbeatJob$heartBeat$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        coroutineScope2 = coroutineScope;
                        obj2 = coroutineScope2;
                        k3 = com.tencent.mobileqq.qqlive.sail.model.a.k((QQLiveResponse) obj2);
                        LiveHeartbeatJob liveHeartbeatJob = liveHeartbeatJob$heartBeat$1.this$0;
                        companion = AegisLogger.INSTANCE;
                        if (companion.isDevelopLevel()) {
                            companion.d("Open_Live|LiveHeartbeatJob", "heartbeatJob", "heartbeat result=" + k3);
                        }
                        if (k3.b() != 0) {
                            companion.w("Open_Live|LiveHeartbeatJob", "heartbeatJob", "heartbeat failed, result=" + k3);
                            long b16 = k3.b();
                            String c17 = k3.c();
                            if (c17 == null) {
                                c17 = "";
                            }
                            liveHeartbeatJob.g(b16, c17);
                            j18 = 1000;
                        } else {
                            lt3.c d16 = k3.d();
                            if (d16 != null) {
                                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(d16.f415550b, 1);
                                j18 = 1000;
                                longRef.element = coerceAtLeast * 1000;
                            } else {
                                j18 = 1000;
                            }
                            anchorRoomInfo = liveHeartbeatJob.roomInfo;
                            if (anchorRoomInfo == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("roomInfo");
                                anchorRoomInfo = null;
                            }
                            anchorRoomInfo.A(System.currentTimeMillis());
                            liveHeartbeatJob.heartbeatFailedTimes = 0;
                            long currentTimeMillis = System.currentTimeMillis();
                            j3 = liveHeartbeatJob.lastSaveTimeMs;
                            if (currentTimeMillis - j3 > 10000) {
                                k kVar = k.f272428a;
                                anchorRoomInfo2 = liveHeartbeatJob.roomInfo;
                                if (anchorRoomInfo2 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("roomInfo");
                                    anchorRoomInfo3 = null;
                                } else {
                                    anchorRoomInfo3 = anchorRoomInfo2;
                                }
                                a16 = anchorRoomInfo3.a((r28 & 1) != 0 ? anchorRoomInfo3.avConfig : null, (r28 & 2) != 0 ? anchorRoomInfo3.basicInfo : null, (r28 & 4) != 0 ? anchorRoomInfo3.settingInfo : null, (r28 & 8) != 0 ? anchorRoomInfo3.anchorInfo : null, (r28 & 16) != 0 ? anchorRoomInfo3.trtcInfo : null, (r28 & 32) != 0 ? anchorRoomInfo3.thirdPushInfo : null, (r28 & 64) != 0 ? anchorRoomInfo3.heartBeatTime : 0L, (r28 & 128) != 0 ? anchorRoomInfo3.appId : null, (r28 & 256) != 0 ? anchorRoomInfo3.enterRoomTime : 0L, (r28 & 512) != 0 ? anchorRoomInfo3.popupDialogUrl : null, (r28 & 1024) != 0 ? anchorRoomInfo3.backgroundInfo : null);
                                kVar.e(a16);
                                liveHeartbeatJob.lastSaveTimeMs = System.currentTimeMillis();
                            }
                        }
                        if (companion.isDevelopLevel()) {
                            companion.d("Open_Live|LiveHeartbeatJob", "heartbeatJob", "delayTimeMs=" + longRef.element);
                        }
                        j16 = longRef.element;
                        liveHeartbeatJob$heartBeat$1.L$0 = coroutineScope2;
                        liveHeartbeatJob$heartBeat$1.L$1 = liveHeartbeatRequest;
                        liveHeartbeatJob$heartBeat$1.L$2 = longRef;
                        c16 = 2;
                        liveHeartbeatJob$heartBeat$1.label = 2;
                        if (DelayKt.delay(j16, liveHeartbeatJob$heartBeat$1) != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        coroutineScope = coroutineScope2;
                        j17 = j18;
                        if (CoroutineScopeKt.isActive(coroutineScope)) {
                        }
                    }
                    if (CoroutineScopeKt.isActive(coroutineScope)) {
                        anchorRoomInfo4 = liveHeartbeatJob$heartBeat$1.this$0.roomInfo;
                        if (anchorRoomInfo4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("roomInfo");
                            anchorRoomInfo4 = null;
                        }
                        String m3 = anchorRoomInfo4.m();
                        anchorRoomInfo5 = liveHeartbeatJob$heartBeat$1.this$0.roomInfo;
                        if (anchorRoomInfo5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("roomInfo");
                            dVar = null;
                        }
                        liveHeartbeatRequest = new LiveHeartbeatRequest(m3, dVar.getRoomId(), 0, 4, null);
                        longRef = new Ref.LongRef();
                        longRef.element = j17;
                        if (CoroutineScopeKt.isActive(coroutineScope)) {
                        }
                        if (CoroutineScopeKt.isActive(coroutineScope)) {
                        }
                    } else {
                        return Unit.INSTANCE;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                Ref.LongRef longRef3 = (Ref.LongRef) this.L$2;
                liveHeartbeatRequest = (LiveHeartbeatRequest) this.L$1;
                CoroutineScope coroutineScope4 = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                coroutineScope2 = coroutineScope4;
                longRef = longRef3;
                liveHeartbeatJob$heartBeat$1 = this;
                k3 = com.tencent.mobileqq.qqlive.sail.model.a.k((QQLiveResponse) obj2);
                LiveHeartbeatJob liveHeartbeatJob2 = liveHeartbeatJob$heartBeat$1.this$0;
                companion = AegisLogger.INSTANCE;
                if (companion.isDevelopLevel()) {
                }
                if (k3.b() != 0) {
                }
                if (companion.isDevelopLevel()) {
                }
                j16 = longRef.element;
                liveHeartbeatJob$heartBeat$1.L$0 = coroutineScope2;
                liveHeartbeatJob$heartBeat$1.L$1 = liveHeartbeatRequest;
                liveHeartbeatJob$heartBeat$1.L$2 = longRef;
                c16 = 2;
                liveHeartbeatJob$heartBeat$1.label = 2;
                if (DelayKt.delay(j16, liveHeartbeatJob$heartBeat$1) != coroutine_suspended) {
                }
            }
        } else {
            ResultKt.throwOnFailure(obj);
            coroutineScope = (CoroutineScope) this.L$0;
            liveHeartbeatJob$heartBeat$1 = this;
            if (CoroutineScopeKt.isActive(coroutineScope)) {
            }
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((LiveHeartbeatJob$heartBeat$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
