package com.tencent.qqnt.aio.icebreak;

import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a'\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006\u001a=\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lcom/tencent/component/network/downloader/Downloader;", "", "url", "savePath", "", "b", "(Lcom/tencent/component/network/downloader/Downloader;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "T", "Lkotlin/Function0;", "block", "c", "(Lcom/tencent/component/network/downloader/Downloader;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "base_proj_nt_ext_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class IceBreakingWelcomeWordingKt {
    private static final Object b(Downloader downloader, String str, String str2, Continuation<? super Boolean> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        downloader.download(str, str2, new a(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0054 A[Catch: all -> 0x006b, TRY_LEAVE, TryCatch #3 {all -> 0x006b, blocks: (B:11:0x002f, B:12:0x004c, B:14:0x0054, B:31:0x003f), top: B:7:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0061 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object c(Downloader downloader, String str, String str2, Function0<? extends T> function0, Continuation<? super T> continuation) {
        IceBreakingWelcomeWordingKt$useTemporarily$1 iceBreakingWelcomeWordingKt$useTemporarily$1;
        Object obj;
        Object coroutine_suspended;
        int i3;
        try {
            if (continuation instanceof IceBreakingWelcomeWordingKt$useTemporarily$1) {
                iceBreakingWelcomeWordingKt$useTemporarily$1 = (IceBreakingWelcomeWordingKt$useTemporarily$1) continuation;
                int i16 = iceBreakingWelcomeWordingKt$useTemporarily$1.label;
                if ((i16 & Integer.MIN_VALUE) != 0) {
                    iceBreakingWelcomeWordingKt$useTemporarily$1.label = i16 - Integer.MIN_VALUE;
                    obj = iceBreakingWelcomeWordingKt$useTemporarily$1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = iceBreakingWelcomeWordingKt$useTemporarily$1.label;
                    if (i3 != 0) {
                        ResultKt.throwOnFailure(obj);
                        iceBreakingWelcomeWordingKt$useTemporarily$1.L$0 = str2;
                        iceBreakingWelcomeWordingKt$useTemporarily$1.L$1 = function0;
                        iceBreakingWelcomeWordingKt$useTemporarily$1.label = 1;
                        obj = b(downloader, str, str2, iceBreakingWelcomeWordingKt$useTemporarily$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (i3 == 1) {
                        function0 = (Function0) iceBreakingWelcomeWordingKt$useTemporarily$1.L$1;
                        str2 = (String) iceBreakingWelcomeWordingKt$useTemporarily$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    if (!((Boolean) obj).booleanValue()) {
                        return function0.invoke();
                    }
                    try {
                        new File(str2).delete();
                        return null;
                    } catch (IOException unused) {
                        return null;
                    }
                }
            }
            if (i3 != 0) {
            }
            if (!((Boolean) obj).booleanValue()) {
            }
        } finally {
            try {
                new File(str2).delete();
            } catch (IOException unused2) {
            }
        }
        iceBreakingWelcomeWordingKt$useTemporarily$1 = new IceBreakingWelcomeWordingKt$useTemporarily$1(continuation);
        obj = iceBreakingWelcomeWordingKt$useTemporarily$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = iceBreakingWelcomeWordingKt$useTemporarily$1.label;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\"\u0010\r\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u001c\u0010\u000e\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/qqnt/aio/icebreak/IceBreakingWelcomeWordingKt$a", "Lcom/tencent/component/network/downloader/Downloader$DownloadListener;", "", "url", "", "onDownloadCanceled", "Lcom/tencent/component/network/downloader/DownloadResult;", "result", "onDownloadFailed", "", "totalSize", "", "progress", "onDownloadProgress", "onDownloadSucceed", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements Downloader.DownloadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<Boolean> f351154a;

        /* JADX WARN: Multi-variable type inference failed */
        a(CancellableContinuation<? super Boolean> cancellableContinuation) {
            this.f351154a = cancellableContinuation;
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadCanceled(String url) {
            if (this.f351154a.isActive()) {
                CancellableContinuation<Boolean> cancellableContinuation = this.f351154a;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m476constructorimpl(Boolean.FALSE));
            }
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadFailed(String url, DownloadResult result) {
            if (this.f351154a.isActive()) {
                CancellableContinuation<Boolean> cancellableContinuation = this.f351154a;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m476constructorimpl(Boolean.FALSE));
            }
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadSucceed(String url, DownloadResult result) {
            CancellableContinuation<Boolean> cancellableContinuation = this.f351154a;
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m476constructorimpl(Boolean.TRUE));
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadProgress(String url, long totalSize, float progress) {
        }
    }
}
