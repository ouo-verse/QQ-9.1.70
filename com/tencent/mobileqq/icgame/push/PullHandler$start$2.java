package com.tencent.mobileqq.icgame.push;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.icgame.api.ILiveNetRequest;
import com.tencent.mobileqq.icgame.api.sso.QQLiveResponse;
import com.tencent.mobileqq.icgame.sso.request.LivePushRequest;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rt0.a;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.icgame.push.PullHandler$start$2", f = "PullHandler.kt", i = {0, 1}, l = {90, 97}, m = "invokeSuspend", n = {"$this$launch", "$this$launch"}, s = {"L$0", "L$0"})
/* loaded from: classes15.dex */
public final class PullHandler$start$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PullHandler this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PullHandler$start$2(PullHandler pullHandler, Continuation<? super PullHandler$start$2> continuation) {
        super(2, continuation);
        this.this$0 = pullHandler;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        PullHandler$start$2 pullHandler$start$2 = new PullHandler$start$2(this.this$0, continuation);
        pullHandler$start$2.L$0 = obj;
        return pullHandler$start$2;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0105 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0041  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0103 -> B:7:0x003b). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        CoroutineScope coroutineScope;
        PullHandler$start$2 pullHandler$start$2;
        long j3;
        String str;
        long j16;
        long j17;
        byte[] bArr;
        ez0.a k3;
        long j18;
        long j19;
        byte[] bArr2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    coroutineScope = (CoroutineScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                Object obj2 = obj;
                pullHandler$start$2 = this;
                QQLiveResponse qQLiveResponse = (QQLiveResponse) obj2;
                if (qQLiveResponse.isFailed()) {
                    pullHandler$start$2.this$0.h((ez0.c) qQLiveResponse.getRsp());
                } else {
                    rt0.a.INSTANCE.q("ICGamePush|ICGamePullHandler", Const.BUNDLE_KEY_REQUEST, "request error, retCode=" + qQLiveResponse.getRetCode() + ", errMsg=" + qQLiveResponse.getErrMsg());
                }
                j3 = pullHandler$start$2.this$0.pullRequestInterval;
                pullHandler$start$2.L$0 = coroutineScope;
                pullHandler$start$2.label = 2;
                if (DelayKt.delay(j3, pullHandler$start$2) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                if (CoroutineScopeKt.isActive(coroutineScope)) {
                    a.Companion companion = rt0.a.INSTANCE;
                    if (companion.m()) {
                        j18 = pullHandler$start$2.this$0.roomId;
                        j19 = pullHandler$start$2.this$0.msgRspSeq;
                        bArr2 = pullHandler$start$2.this$0.cookie;
                        companion.g("ICGamePush|ICGamePullHandler", Const.BUNDLE_KEY_REQUEST, "roomId=" + j18 + ", msgRspSeq=" + j19 + ", cookie=" + bArr2);
                    }
                    str = pullHandler$start$2.this$0.appId;
                    j16 = pullHandler$start$2.this$0.roomId;
                    j17 = pullHandler$start$2.this$0.msgRspSeq;
                    bArr = pullHandler$start$2.this$0.cookie;
                    k3 = pullHandler$start$2.this$0.k();
                    LivePushRequest livePushRequest = new LivePushRequest(str, j16, j17, bArr, k3);
                    ILiveNetRequest iLiveNetRequest = (ILiveNetRequest) QRoute.api(ILiveNetRequest.class);
                    pullHandler$start$2.L$0 = coroutineScope;
                    pullHandler$start$2.label = 1;
                    obj2 = iLiveNetRequest.sendRequestOnSuspend(livePushRequest, pullHandler$start$2);
                    if (obj2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    QQLiveResponse qQLiveResponse2 = (QQLiveResponse) obj2;
                    if (qQLiveResponse2.isFailed()) {
                    }
                    j3 = pullHandler$start$2.this$0.pullRequestInterval;
                    pullHandler$start$2.L$0 = coroutineScope;
                    pullHandler$start$2.label = 2;
                    if (DelayKt.delay(j3, pullHandler$start$2) == coroutine_suspended) {
                    }
                    if (CoroutineScopeKt.isActive(coroutineScope)) {
                        return Unit.INSTANCE;
                    }
                }
            }
        } else {
            ResultKt.throwOnFailure(obj);
            coroutineScope = (CoroutineScope) this.L$0;
        }
        pullHandler$start$2 = this;
        if (CoroutineScopeKt.isActive(coroutineScope)) {
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((PullHandler$start$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
