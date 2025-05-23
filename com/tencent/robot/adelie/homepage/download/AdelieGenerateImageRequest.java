package com.tencent.robot.adelie.homepage.download;

import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.QLog;
import com.tencent.robot.adelie.homepage.download.AdelieGenerateImageRequest;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qshadow.ShadowAIGCGenerate$GenerateReply;
import qshadow.ShadowAIGCGenerate$GenerateRequest;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0002\u0013\u0018B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J,\u0010\u000e\u001a\u00020\r\"\u000e\b\u0000\u0010\b*\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\n\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bJ4\u0010\u0012\u001a\u00020\r\"\u000e\b\u0000\u0010\b*\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\n\u001a\u00020\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2\u0006\u0010\u0011\u001a\u00020\u0010R\u0014\u0010\u0015\u001a\u00020\u00108\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/robot/adelie/homepage/download/AdelieGenerateImageRequest;", "", "Lqshadow/ShadowAIGCGenerate$GenerateRequest;", "req", "Lcom/tencent/robot/adelie/homepage/download/AdelieGenerateImageRequest$b;", "d", "(Lqshadow/ShadowAIGCGenerate$GenerateRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/pb/MessageMicro;", "T", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/robot/adelie/homepage/download/AdelieGenerateImageRequest$a;", "adelieRequestCallback", "", "e", "requestCallback", "", "externalLogField", "f", "a", "Ljava/lang/String;", "TAG", "<init>", "()V", "b", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AdelieGenerateImageRequest {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG = "AdelieGenerateImageRequest";

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00012\u00020\u0003J=\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00018\u0000H&\u00a2\u0006\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/robot/adelie/homepage/download/AdelieGenerateImageRequest$a;", "Lcom/tencent/mobileqq/pb/MessageMicro;", "T", "", "", "isSuccess", "", "retCode", "", "msg", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", "pbRequest", "pbResponse", "", "a", "(ZJLjava/lang/String;Lcom/tencent/biz/richframework/network/request/BaseRequest;Lcom/tencent/mobileqq/pb/MessageMicro;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public interface a<T extends MessageMicro<T>> {
        void a(boolean isSuccess, long retCode, @Nullable String msg2, @Nullable BaseRequest pbRequest, @Nullable T pbResponse);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u0017\u001a\u00020\u0010\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R$\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0018\u001a\u0004\b\u0011\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/robot/adelie/homepage/download/AdelieGenerateImageRequest$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lqshadow/ShadowAIGCGenerate$GenerateReply;", "a", "Lqshadow/ShadowAIGCGenerate$GenerateReply;", "()Lqshadow/ShadowAIGCGenerate$GenerateReply;", "d", "(Lqshadow/ShadowAIGCGenerate$GenerateReply;)V", "date", "", "b", "J", "c", "()J", "setErrorCode", "(J)V", "errorCode", "Ljava/lang/String;", "()Ljava/lang/String;", "setErrMsg", "(Ljava/lang/String;)V", "errMsg", "<init>", "(Lqshadow/ShadowAIGCGenerate$GenerateReply;JLjava/lang/String;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.adelie.homepage.download.AdelieGenerateImageRequest$b, reason: from toString */
    /* loaded from: classes25.dex */
    public static final /* data */ class FullReply {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private ShadowAIGCGenerate$GenerateReply date;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private long errorCode;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private String errMsg;

        public FullReply(@Nullable ShadowAIGCGenerate$GenerateReply shadowAIGCGenerate$GenerateReply, long j3, @Nullable String str) {
            this.date = shadowAIGCGenerate$GenerateReply;
            this.errorCode = j3;
            this.errMsg = str;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final ShadowAIGCGenerate$GenerateReply getDate() {
            return this.date;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final String getErrMsg() {
            return this.errMsg;
        }

        /* renamed from: c, reason: from getter */
        public final long getErrorCode() {
            return this.errorCode;
        }

        public final void d(@Nullable ShadowAIGCGenerate$GenerateReply shadowAIGCGenerate$GenerateReply) {
            this.date = shadowAIGCGenerate$GenerateReply;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FullReply)) {
                return false;
            }
            FullReply fullReply = (FullReply) other;
            if (Intrinsics.areEqual(this.date, fullReply.date) && this.errorCode == fullReply.errorCode && Intrinsics.areEqual(this.errMsg, fullReply.errMsg)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            ShadowAIGCGenerate$GenerateReply shadowAIGCGenerate$GenerateReply = this.date;
            int i3 = 0;
            if (shadowAIGCGenerate$GenerateReply == null) {
                hashCode = 0;
            } else {
                hashCode = shadowAIGCGenerate$GenerateReply.hashCode();
            }
            int a16 = ((hashCode * 31) + androidx.fragment.app.a.a(this.errorCode)) * 31;
            String str = this.errMsg;
            if (str != null) {
                i3 = str.hashCode();
            }
            return a16 + i3;
        }

        @NotNull
        public String toString() {
            return "FullReply(date=" + this.date + ", errorCode=" + this.errorCode + ", errMsg=" + this.errMsg + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J6\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/robot/adelie/homepage/download/AdelieGenerateImageRequest$c", "Lcom/tencent/robot/adelie/homepage/download/AdelieGenerateImageRequest$a;", "Lqshadow/ShadowAIGCGenerate$GenerateReply;", "", "isSuccess", "", "retCode", "", "msg", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", "pbRequest", "pbResponse", "", "b", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class c implements a<ShadowAIGCGenerate$GenerateReply> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<FullReply> f366329b;

        /* JADX WARN: Multi-variable type inference failed */
        c(CancellableContinuation<? super FullReply> cancellableContinuation) {
            this.f366329b = cancellableContinuation;
        }

        @Override // com.tencent.robot.adelie.homepage.download.AdelieGenerateImageRequest.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(boolean isSuccess, long retCode, @Nullable String msg2, @Nullable BaseRequest pbRequest, @Nullable ShadowAIGCGenerate$GenerateReply pbResponse) {
            Integer num;
            if (pbRequest != null) {
                num = Integer.valueOf(pbRequest.getCurrentSeq());
            } else {
                num = null;
            }
            QLog.i(AdelieGenerateImageRequest.this.TAG, 1, "requestGenerateImage onReceive: dispatch Success:" + isSuccess + " | retCode:" + retCode + " | msg:" + msg2 + " | SeqId:" + num);
            FullReply fullReply = new FullReply(null, retCode, msg2);
            if (isSuccess && retCode == 0 && pbResponse != null) {
                QLog.i(AdelieGenerateImageRequest.this.TAG, 1, "callback?.onSuccess(output) = " + pbResponse);
                fullReply.d(pbResponse);
            }
            if (this.f366329b.isActive()) {
                this.f366329b.resumeWith(Result.m476constructorimpl(fullReply));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(long j3, a requestCallback, final AdelieGenerateImageRequest this$0, final String str, final String externalLogField, BaseRequest baseRequest, boolean z16, long j16, String str2, final MessageMicro messageMicro) {
        Intrinsics.checkNotNullParameter(requestCallback, "$requestCallback");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(externalLogField, "$externalLogField");
        final long currentTimeMillis = System.currentTimeMillis() - j3;
        ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.robot.adelie.homepage.download.e
            @Override // java.lang.Runnable
            public final void run() {
                AdelieGenerateImageRequest.h(AdelieGenerateImageRequest.this, str, externalLogField, currentTimeMillis, messageMicro);
            }
        });
        requestCallback.a(z16, j16, str2, baseRequest, messageMicro);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(AdelieGenerateImageRequest this$0, String str, String externalLogField, long j3, MessageMicro messageMicro) {
        Integer num;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(externalLogField, "$externalLogField");
        String str2 = this$0.TAG;
        if (messageMicro != null) {
            num = Integer.valueOf(messageMicro.getSerializedSize());
        } else {
            num = null;
        }
        QLog.i(str2, 1, "wink request end, cmdName: " + str + " " + externalLogField + ", cost " + j3 + " ms, size:" + num);
    }

    @Nullable
    public final Object d(@Nullable final ShadowAIGCGenerate$GenerateRequest shadowAIGCGenerate$GenerateRequest, @NotNull Continuation<? super FullReply> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        if (MobileQQ.sMobileQQ.peekAppRuntime() != null && shadowAIGCGenerate$GenerateRequest != null) {
            QLog.i(this.TAG, 1, "requestGenerateImage begin");
            final int e16 = e(new AdelieVSBaseRequest(shadowAIGCGenerate$GenerateRequest), new c(cancellableContinuationImpl));
            cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.tencent.robot.adelie.homepage.download.AdelieGenerateImageRequest$requestGenerateImageWithErrorMsg$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                    invoke2(th5);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Throwable th5) {
                    String str = ShadowAIGCGenerate$GenerateRequest.this.medias.isEmpty() ? "" : ShadowAIGCGenerate$GenerateRequest.this.medias.get(0).string_data.get();
                    QLog.e(this.TAG, 1, "timeout. cancel request " + str);
                    VSNetworkHelper.getInstance().cancelRequest(MobileQQ.sMobileQQ.getApplicationContext(), e16);
                    CancellableContinuation<AdelieGenerateImageRequest.FullReply> cancellableContinuation = cancellableContinuationImpl;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m476constructorimpl(new AdelieGenerateImageRequest.FullReply(null, -1L, "\u6d3b\u52a8\u592a\u706b\u7206\u4e86\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5!")));
                }
            });
        } else {
            QLog.e(this.TAG, 1, "req is invalid!");
            cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(null));
        }
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public final <T extends MessageMicro<T>> int e(@NotNull BaseRequest request, @NotNull a<T> adelieRequestCallback) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(adelieRequestCallback, "adelieRequestCallback");
        return f(request, adelieRequestCallback, "");
    }

    public final <T extends MessageMicro<T>> int f(@NotNull BaseRequest request, @NotNull final a<T> requestCallback, @NotNull final String externalLogField) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(requestCallback, "requestCallback");
        Intrinsics.checkNotNullParameter(externalLogField, "externalLogField");
        final String cmdName = request.getCmdName();
        final long currentTimeMillis = System.currentTimeMillis();
        QLog.i(this.TAG, 1, "cmdName: " + cmdName + " " + externalLogField);
        return VSNetworkHelper.getInstance().sendRequest(MobileQQ.sMobileQQ.getApplicationContext(), request, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.robot.adelie.homepage.download.d
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                AdelieGenerateImageRequest.g(currentTimeMillis, requestCallback, this, cmdName, externalLogField, baseRequest, z16, j3, str, (MessageMicro) obj);
            }
        });
    }
}
