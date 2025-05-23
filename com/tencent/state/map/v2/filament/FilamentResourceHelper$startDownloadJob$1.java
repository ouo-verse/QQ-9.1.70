package com.tencent.state.map.v2.filament;

import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.download.DownloadCallback;
import com.tencent.state.square.download.Source;
import com.tencent.state.square.download.SquareDownloader;
import com.tencent.state.square.download.TaskProgress;
import com.tencent.state.square.download.TaskResponse;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.state.map.v2.filament.FilamentResourceHelper$startDownloadJob$1", f = "FilamentResourceHelper.kt", i = {}, l = {52}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
public final class FilamentResourceHelper$startDownloadJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $remoteUrl;
    final /* synthetic */ String $savePath;
    long J$0;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilamentResourceHelper$startDownloadJob$1(String str, String str2, Continuation continuation) {
        super(2, continuation);
        this.$remoteUrl = str;
        this.$savePath = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new FilamentResourceHelper$startDownloadJob$1(this.$remoteUrl, this.$savePath, completion);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FilamentResourceHelper$startDownloadJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Continuation intercepted;
        SquareDownloader squareDownloader;
        Object coroutine_suspended2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            final long currentTimeMillis = System.currentTimeMillis();
            this.L$0 = this;
            this.J$0 = currentTimeMillis;
            this.label = 1;
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(this);
            final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
            FilamentResourceHelper filamentResourceHelper = FilamentResourceHelper.INSTANCE;
            squareDownloader = FilamentResourceHelper.downloader;
            squareDownloader.addHighTask(new Source(this.$remoteUrl, this.$savePath), new DownloadCallback() { // from class: com.tencent.state.map.v2.filament.FilamentResourceHelper$startDownloadJob$1$invokeSuspend$$inlined$suspendCoroutine$lambda$1
                @Override // com.tencent.state.square.download.DownloadCallback
                public void onTaskFailed(Source source, TaskResponse response) {
                    Intrinsics.checkNotNullParameter(source, "source");
                    Intrinsics.checkNotNullParameter(response, "response");
                    SquareBaseKt.getSquareLog().i("FilamentResourceHelper", "downloadFile, download failed: " + response.getErrorCode());
                    Continuation.this.resumeWith(Result.m476constructorimpl(Unit.INSTANCE));
                }

                @Override // com.tencent.state.square.download.DownloadCallback
                public void onTaskProgress(Source source, TaskResponse response, TaskProgress progress) {
                    Intrinsics.checkNotNullParameter(source, "source");
                    Intrinsics.checkNotNullParameter(response, "response");
                    Intrinsics.checkNotNullParameter(progress, "progress");
                    DownloadCallback.DefaultImpls.onTaskProgress(this, source, response, progress);
                }

                @Override // com.tencent.state.square.download.DownloadCallback
                public void onTaskStart(Source source, TaskResponse response) {
                    Intrinsics.checkNotNullParameter(source, "source");
                    Intrinsics.checkNotNullParameter(response, "response");
                    DownloadCallback.DefaultImpls.onTaskStart(this, source, response);
                }

                @Override // com.tencent.state.square.download.DownloadCallback
                public void onTaskSuccess(Source source, TaskResponse response) {
                    Intrinsics.checkNotNullParameter(source, "source");
                    Intrinsics.checkNotNullParameter(response, "response");
                    SquareBaseKt.getSquareLog().d("FilamentResourceHelper", "success downloadFile  cost: " + (System.currentTimeMillis() - currentTimeMillis) + ", " + this.$remoteUrl);
                    Continuation.this.resumeWith(Result.m476constructorimpl(Unit.INSTANCE));
                }
            });
            Object orThrow = safeContinuation.getOrThrow();
            coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (orThrow == coroutine_suspended2) {
                DebugProbes.probeCoroutineSuspended(this);
            }
            if (orThrow == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
