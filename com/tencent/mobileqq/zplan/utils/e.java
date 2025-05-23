package com.tencent.mobileqq.zplan.utils;

import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.mobileqq.zplan.utils.g;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.flow.MutableStateFlow;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u0002`\u0004B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u001b\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0096B\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/zplan/utils/e;", "Lcom/tencent/mobileqq/zplan/utils/o;", "Lcom/tencent/mobileqq/zplan/utils/f;", "Lcom/tencent/mobileqq/zplan/utils/g;", "Lcom/tencent/mobileqq/zplan/utils/IDownload;", "req", "b", "(Lcom/tencent/mobileqq/zplan/utils/f;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class e implements o<f, g> {

    /* renamed from: a, reason: collision with root package name */
    public static final e f335814a = new e();

    e() {
    }

    @Override // com.tencent.mobileqq.zplan.utils.o
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Object a(f fVar, Continuation<? super g> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        aj.j().i(fVar.getUrl(), fVar.getSavePath(), fVar.a(), fVar.getPriority(), Downloader.DownloadMode.OkHttpMode, new a(cancellableContinuationImpl, fVar));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\"\u0010\u000e\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/zplan/utils/e$a", "Lcom/tencent/component/network/downloader/Downloader$DownloadListener;", "", "url", "Lcom/tencent/component/network/downloader/DownloadResult;", "result", "", "onDownloadFailed", "onDownloadSucceed", "onDownloadCanceled", "", "totalSize", "", "progress", "onDownloadProgress", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements Downloader.DownloadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<g> f335815a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ f f335816b;

        /* JADX WARN: Multi-variable type inference failed */
        a(CancellableContinuation<? super g> cancellableContinuation, f fVar) {
            this.f335815a = cancellableContinuation;
            this.f335816b = fVar;
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadFailed(String url, DownloadResult result) {
            CancellableContinuation<g> cancellableContinuation = this.f335815a;
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m476constructorimpl(new g.b(result)));
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadProgress(String url, long totalSize, float progress) {
            MutableStateFlow<Float> c16 = this.f335816b.c();
            if (c16 != null) {
                c16.tryEmit(Float.valueOf(progress));
            }
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadSucceed(String url, DownloadResult result) {
            Object dVar;
            CancellableContinuation<g> cancellableContinuation = this.f335815a;
            Result.Companion companion = Result.INSTANCE;
            if (result != null) {
                dVar = new g.c(new File(this.f335816b.getSavePath()), result);
            } else {
                dVar = new g.d();
            }
            cancellableContinuation.resumeWith(Result.m476constructorimpl(dVar));
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadCanceled(String url) {
        }
    }
}
