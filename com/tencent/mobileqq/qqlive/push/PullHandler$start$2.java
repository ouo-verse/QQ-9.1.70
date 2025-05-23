package com.tencent.mobileqq.qqlive.push;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qqlive.sso.request.LivePushRequest;
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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.qqlive.push.PullHandler$start$2", f = "PullHandler.kt", i = {0, 1}, l = {90, 97}, m = "invokeSuspend", n = {"$this$launch", "$this$launch"}, s = {"L$0", "L$0"})
/* loaded from: classes17.dex */
public final class PullHandler$start$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PullHandler this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PullHandler$start$2(PullHandler pullHandler, Continuation<? super PullHandler$start$2> continuation) {
        super(2, continuation);
        this.this$0 = pullHandler;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) pullHandler, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        PullHandler$start$2 pullHandler$start$2 = new PullHandler$start$2(this.this$0, continuation);
        pullHandler$start$2.L$0 = obj;
        return pullHandler$start$2;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x012a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x012b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0128 -> B:14:0x004f). Please report as a decompilation issue!!! */
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
        jp4.a k3;
        long j18;
        String str2;
        long j19;
        byte[] bArr2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        coroutineScope = coroutineScope2;
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    CoroutineScope coroutineScope3 = (CoroutineScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    Object obj2 = obj;
                    coroutineScope = coroutineScope3;
                    pullHandler$start$2 = this;
                    QQLiveResponse qQLiveResponse = (QQLiveResponse) obj2;
                    if (qQLiveResponse.isFailed()) {
                        pullHandler$start$2.this$0.h((jp4.c) qQLiveResponse.getRsp());
                    } else {
                        AegisLogger.INSTANCE.w("Push|PullHandler", Const.BUNDLE_KEY_REQUEST, "request error, retCode=" + qQLiveResponse.getRetCode() + ", errMsg=" + qQLiveResponse.getErrMsg());
                    }
                    j3 = pullHandler$start$2.this$0.pullRequestInterval;
                    pullHandler$start$2.L$0 = coroutineScope;
                    pullHandler$start$2.label = 2;
                    if (DelayKt.delay(j3, pullHandler$start$2) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    if (CoroutineScopeKt.isActive(coroutineScope)) {
                        AegisLogger.Companion companion = AegisLogger.INSTANCE;
                        if (companion.isDevelopLevel()) {
                            j18 = pullHandler$start$2.this$0.roomId;
                            str2 = pullHandler$start$2.this$0.appId;
                            j19 = pullHandler$start$2.this$0.msgRspSeq;
                            bArr2 = pullHandler$start$2.this$0.cookie;
                            companion.d("Push|PullHandler", Const.BUNDLE_KEY_REQUEST, "roomId=" + j18 + ", appId=" + str2 + ", msgRspSeq=" + j19 + ", cookie=" + bArr2);
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
        } else {
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((PullHandler$start$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
