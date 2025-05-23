package com.tencent.mobileqq.guild.feed;

import androidx.core.app.NotificationCompat;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetFeedsByIndexReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetFeedsByIndexRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetFeedsByIndexCallback;
import com.tencent.richframework.thread.RFWThreadManager;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.GuildFeedViewModel$fetchMVPFeedsFromServerWithTimeout$1", f = "GuildFeedViewModel.kt", i = {0}, l = {337}, m = "invokeSuspend", n = {NotificationCompat.CATEGORY_ERROR}, s = {"L$0"})
/* loaded from: classes13.dex */
final class GuildFeedViewModel$fetchMVPFeedsFromServerWithTimeout$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IGProGetFeedsByIndexCallback $callback;
    final /* synthetic */ GProGetFeedsByIndexReq $request;
    Object L$0;
    int label;

    @Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\b0\bH\n\u00a2\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "result", "", "msg", "", "kotlin.jvm.PlatformType", "rsp", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGetFeedsByIndexRsp;", "onResult"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    static final class a implements IGProGetFeedsByIndexCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<Triple<Integer, String, GProGetFeedsByIndexRsp>> f217919a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Multi-variable type inference failed */
        public a(Continuation<? super Triple<Integer, String, GProGetFeedsByIndexRsp>> continuation) {
            this.f217919a = continuation;
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetFeedsByIndexCallback
        public final void onResult(int i3, String str, GProGetFeedsByIndexRsp gProGetFeedsByIndexRsp) {
            Continuation<Triple<Integer, String, GProGetFeedsByIndexRsp>> continuation = this.f217919a;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(new Triple(Integer.valueOf(i3), str, gProGetFeedsByIndexRsp)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFeedViewModel$fetchMVPFeedsFromServerWithTimeout$1(GProGetFeedsByIndexReq gProGetFeedsByIndexReq, IGProGetFeedsByIndexCallback iGProGetFeedsByIndexCallback, Continuation<? super GuildFeedViewModel$fetchMVPFeedsFromServerWithTimeout$1> continuation) {
        super(2, continuation);
        this.$request = gProGetFeedsByIndexReq;
        this.$callback = iGProGetFeedsByIndexCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(IGProGetFeedsByIndexCallback iGProGetFeedsByIndexCallback, Triple triple) {
        iGProGetFeedsByIndexCallback.onResult(((Number) triple.getFirst()).intValue(), (String) triple.getSecond(), (GProGetFeedsByIndexRsp) triple.getThird());
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildFeedViewModel$fetchMVPFeedsFromServerWithTimeout$1(this.$request, this.$callback, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Function0 function0;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                function0 = (Function0) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            GuildFeedViewModel$fetchMVPFeedsFromServerWithTimeout$1$err$1 guildFeedViewModel$fetchMVPFeedsFromServerWithTimeout$1$err$1 = new Function0<Triple<? extends Integer, ? extends String, ? extends GProGetFeedsByIndexRsp>>() { // from class: com.tencent.mobileqq.guild.feed.GuildFeedViewModel$fetchMVPFeedsFromServerWithTimeout$1$err$1
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final Triple<? extends Integer, ? extends String, ? extends GProGetFeedsByIndexRsp> invoke() {
                    return new Triple<>(-1, null, null);
                }
            };
            GuildFeedViewModel$fetchMVPFeedsFromServerWithTimeout$1$invokeSuspend$$inlined$suspendCoroutineWithTimeout$1 guildFeedViewModel$fetchMVPFeedsFromServerWithTimeout$1$invokeSuspend$$inlined$suspendCoroutineWithTimeout$1 = new GuildFeedViewModel$fetchMVPFeedsFromServerWithTimeout$1$invokeSuspend$$inlined$suspendCoroutineWithTimeout$1(null, guildFeedViewModel$fetchMVPFeedsFromServerWithTimeout$1$err$1, this.$request);
            this.L$0 = guildFeedViewModel$fetchMVPFeedsFromServerWithTimeout$1$err$1;
            this.label = 1;
            Object withTimeoutOrNull = TimeoutKt.withTimeoutOrNull(18000L, guildFeedViewModel$fetchMVPFeedsFromServerWithTimeout$1$invokeSuspend$$inlined$suspendCoroutineWithTimeout$1, this);
            if (withTimeoutOrNull == coroutine_suspended) {
                return coroutine_suspended;
            }
            function0 = guildFeedViewModel$fetchMVPFeedsFromServerWithTimeout$1$err$1;
            obj = withTimeoutOrNull;
        }
        if (obj == null) {
            obj = function0.invoke();
        }
        final Triple triple = (Triple) obj;
        RFWThreadManager rFWThreadManager = RFWThreadManager.getInstance();
        final IGProGetFeedsByIndexCallback iGProGetFeedsByIndexCallback = this.$callback;
        rFWThreadManager.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.h
            @Override // java.lang.Runnable
            public final void run() {
                GuildFeedViewModel$fetchMVPFeedsFromServerWithTimeout$1.b(IGProGetFeedsByIndexCallback.this, triple);
            }
        });
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildFeedViewModel$fetchMVPFeedsFromServerWithTimeout$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
