package com.tencent.mobileqq.guild.feed.gallery.vm;

import android.util.Log;
import com.tencent.mobileqq.guild.feed.util.l;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.o;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProReportRecentViewFeedReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGproFeedOperateCallback;
import kotlin.Metadata;
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
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.gallery.vm.GuildFeedGalleryViewModel$reportRecentViewFeed$1", f = "GuildFeedGalleryViewModel.kt", i = {}, l = {355}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
final class GuildFeedGalleryViewModel$reportRecentViewFeed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $feedId;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "result", "", "errMsg", "", "kotlin.jvm.PlatformType", "onResult"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class a implements IGproFeedOperateCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<Boolean> f219765a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f219766b;

        /* JADX WARN: Multi-variable type inference failed */
        a(Continuation<? super Boolean> continuation, String str) {
            this.f219765a = continuation;
            this.f219766b = str;
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGproFeedOperateCallback
        public final void onResult(int i3, String str) {
            boolean z16;
            Logger logger = Logger.f235387a;
            String str2 = this.f219766b;
            if (QLog.isDevelopLevel()) {
                Log.d("Guild_Feed_GAL_GuildFeedGalleryViewModel", "[reportRecentViewFeed] feedId " + str2 + " | retCode " + i3 + " | errMsg " + str);
            }
            Continuation<Boolean> continuation = this.f219765a;
            Result.Companion companion = Result.INSTANCE;
            if (i3 == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            continuation.resumeWith(Result.m476constructorimpl(Boolean.valueOf(z16)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFeedGalleryViewModel$reportRecentViewFeed$1(String str, Continuation<? super GuildFeedGalleryViewModel$reportRecentViewFeed$1> continuation) {
        super(2, continuation);
        this.$feedId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildFeedGalleryViewModel$reportRecentViewFeed$1(this.$feedId, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Continuation intercepted;
        Object coroutine_suspended2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            String str = this.$feedId;
            this.L$0 = str;
            this.label = 1;
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(this);
            SafeContinuation safeContinuation = new SafeContinuation(intercepted);
            o c16 = l.c();
            if (c16 != null) {
                GProReportRecentViewFeedReq gProReportRecentViewFeedReq = new GProReportRecentViewFeedReq();
                gProReportRecentViewFeedReq.feedId = str;
                gProReportRecentViewFeedReq.reportType = 1;
                c16.reportRecentViewFeed(gProReportRecentViewFeedReq, new a(safeContinuation, str));
            }
            Object orThrow = safeContinuation.getOrThrow();
            coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (orThrow == coroutine_suspended2) {
                DebugProbes.probeCoroutineSuspended(this);
            }
            if (orThrow == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildFeedGalleryViewModel$reportRecentViewFeed$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
