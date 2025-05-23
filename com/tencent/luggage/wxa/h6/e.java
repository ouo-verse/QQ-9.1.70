package com.tencent.luggage.wxa.h6;

import com.tencent.luggage.wxa.cp.x;
import com.tencent.luggage.wxa.mc.g0;
import com.tencent.luggage.wxa.tn.h0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.mars.cdn.CronetLogic;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt__MathJVMKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f126875a = new e();

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicInteger f126876b = new AtomicInteger(0);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f126877a;

        /* renamed from: b, reason: collision with root package name */
        public final int f126878b;

        /* renamed from: c, reason: collision with root package name */
        public final String f126879c;

        public a(int i3, int i16, String errorMsg) {
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
            this.f126877a = i3;
            this.f126878b = i16;
            this.f126879c = errorMsg;
        }

        public final int a() {
            return this.f126878b;
        }

        public final int b() {
            return this.f126877a;
        }

        public String toString() {
            return "DownloadResult(httpStatusCode=" + this.f126877a + ", errorCode=" + this.f126878b + ", errorMsg='" + this.f126879c + "')";
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f126880a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str) {
            super(1);
            this.f126880a = str;
        }

        public final void a(Throwable th5) {
            CronetLogic.cancelCronetTask(this.f126880a);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return Unit.INSTANCE;
        }
    }

    static {
        CronetLogic.initializeNativeLib();
    }

    public final CronetLogic.CronetRequestParams a(String url, String savePath) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(savePath, "savePath");
        CronetLogic.CronetRequestParams cronetRequestParams = new CronetLogic.CronetRequestParams();
        cronetRequestParams.url = url;
        cronetRequestParams.taskId = String.valueOf(f126876b.getAndIncrement());
        cronetRequestParams.followRedirect = true;
        cronetRequestParams.savePath = x.b(savePath, true);
        cronetRequestParams.method = "GET";
        cronetRequestParams.needWriteLocal = true;
        cronetRequestParams.useHttp2 = true;
        cronetRequestParams.useQuic = true;
        cronetRequestParams.useMemoryCache = false;
        HashMap hashMap = new HashMap();
        hashMap.put("Accept-Encoding", "gzip,compress,br,deflate");
        hashMap.put("User-Agent", "");
        cronetRequestParams.makeRequestHeader(hashMap);
        cronetRequestParams.taskType = 2;
        w.d("Luggage.CronetDownloader", "createCronetParams, url:" + url + ", savePath:" + savePath + " -> taskId:" + cronetRequestParams.taskId);
        return cronetRequestParams;
    }

    public static /* synthetic */ int a(e eVar, String str, String str2, Function1 function1, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            function1 = null;
        }
        return eVar.a(str, str2, function1);
    }

    public final int a(String url, String savePath, Function1 function1) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(savePath, "savePath");
        long currentTimeMillis = System.currentTimeMillis();
        CronetLogic.CronetRequestParams a16 = a(url, savePath);
        String str = a16.taskId;
        AtomicInteger atomicInteger = new AtomicInteger(Integer.MAX_VALUE);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        CronetLogic.CronetHttpsCreateResult startCronetDownloadTask = CronetLogic.startCronetDownloadTask(a16, new d(function1, str, currentTimeMillis, atomicInteger, countDownLatch));
        StringBuilder sb5 = new StringBuilder();
        sb5.append("downloadSync createRet is ");
        Intrinsics.checkNotNull(startCronetDownloadTask);
        sb5.append(startCronetDownloadTask.createRet);
        sb5.append(", taskId ");
        sb5.append(str);
        sb5.append(", createResult.taskId:");
        sb5.append(startCronetDownloadTask.taskId);
        w.d("Luggage.CronetDownloader", sb5.toString());
        try {
            countDownLatch.await(1001000L, TimeUnit.MILLISECONDS);
            return atomicInteger.get();
        } catch (Exception unused) {
            w.b("Luggage.CronetDownloader", "downloadSync url:" + url + " fail, timeout");
            CronetLogic.cancelCronetTask(str);
            return Integer.MAX_VALUE;
        }
    }

    public final Object a(String str, String str2, Function1 function1, Continuation continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        long currentTimeMillis = System.currentTimeMillis();
        CronetLogic.CronetRequestParams a16 = a(str, str2);
        String str3 = a16.taskId;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        CronetLogic.CronetHttpsCreateResult startCronetDownloadTask = CronetLogic.startCronetDownloadTask(a16, new c(function1, str3, currentTimeMillis, cancellableContinuationImpl));
        w.d("Luggage.CronetDownloader", "downloadSync createRet is " + startCronetDownloadTask.createRet + ", taskId " + str3 + ", createResult.taskId:" + startCronetDownloadTask.taskId);
        int i3 = startCronetDownloadTask.createRet;
        if (i3 != 0) {
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(new a(-1, i3, "create task fail")));
        } else {
            cancellableContinuationImpl.invokeOnCancellation(new b(str3));
        }
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements CronetLogic.CronetTaskCallback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f126881a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f126882b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f126883c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ CancellableContinuation f126884d;

        public c(Function1 function1, String str, long j3, CancellableContinuation cancellableContinuation) {
            this.f126881a = function1;
            this.f126882b = str;
            this.f126883c = j3;
            this.f126884d = cancellableContinuation;
        }

        @Override // com.tencent.mars.cdn.CronetLogic.CronetTaskCallback
        public int onCronetReceiveHeader(CronetLogic.ResponseHeader header, int i3, String str) {
            Intrinsics.checkNotNullParameter(header, "header");
            w.d("Luggage.CronetDownloader", "onCronetReceiveHeader status: " + i3 + " taskId:" + this.f126882b);
            return 0;
        }

        @Override // com.tencent.mars.cdn.CronetLogic.CronetTaskCallback
        public void onCronetTaskCompleted(String filekey, CronetLogic.CronetTaskResult result, String str) {
            String str2;
            Intrinsics.checkNotNullParameter(filekey, "filekey");
            Intrinsics.checkNotNullParameter(result, "result");
            try {
                str2 = h0.a(z.c());
                Intrinsics.checkNotNullExpressionValue(str2, "{\n                      \u2026())\n                    }");
            } catch (Exception unused) {
                str2 = "UNKNOWN";
            }
            w.d("Luggage.CronetDownloader", "onCronetTaskCompleted, errorCode:" + result.errorCode + ", errorMsg:" + result.errorMsg + ", httpStatusCode:" + result.statusCode + ", totalReceiveByte:" + result.totalReceiveByte + ", taskId:" + this.f126882b + ", fileKey:" + filekey + ", cost:" + (w0.c() - this.f126883c) + "ms, networkType:" + str2);
            CancellableContinuation cancellableContinuation = this.f126884d;
            int i3 = result.statusCode;
            int i16 = result.errorCode;
            String str3 = result.errorMsg;
            Intrinsics.checkNotNullExpressionValue(str3, "result.errorMsg");
            cancellableContinuation.resumeWith(Result.m476constructorimpl(new a(i3, i16, str3)));
        }

        @Override // com.tencent.mars.cdn.CronetLogic.CronetTaskCallback
        public void onDownloadProgressChanged(String filekey, CronetLogic.CronetDownloadProgress progress) {
            Function1 function1;
            int roundToInt;
            Intrinsics.checkNotNullParameter(filekey, "filekey");
            Intrinsics.checkNotNullParameter(progress, "progress");
            if (w.d() <= 0) {
                w.e("Luggage.CronetDownloader", "onDownloadProgressChanged key:" + filekey + ", currentWriteByte:" + progress.currentWriteByte + " totalByte:" + progress.totalByte);
            }
            if (progress.totalByte > 0 && (function1 = this.f126881a) != null) {
                g0 g0Var = new g0();
                long min = Math.min(progress.currentWriteByte, progress.totalByte);
                g0Var.f134301b = min;
                long j3 = progress.totalByte;
                g0Var.f134302c = j3;
                roundToInt = MathKt__MathJVMKt.roundToInt((((float) min) / ((float) j3)) * 100);
                g0Var.f134300a = roundToInt;
                function1.invoke(g0Var);
            }
        }

        @Override // com.tencent.mars.cdn.CronetLogic.CronetTaskCallback
        public void onCronetReceiveChunkedData(CronetLogic.ChunkedData chunkedData, long j3) {
        }

        @Override // com.tencent.mars.cdn.CronetLogic.CronetTaskCallback
        public void onCronetReceiveUploadProgress(long j3, long j16) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d implements CronetLogic.CronetTaskCallback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f126885a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f126886b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f126887c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ AtomicInteger f126888d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f126889e;

        public d(Function1 function1, String str, long j3, AtomicInteger atomicInteger, CountDownLatch countDownLatch) {
            this.f126885a = function1;
            this.f126886b = str;
            this.f126887c = j3;
            this.f126888d = atomicInteger;
            this.f126889e = countDownLatch;
        }

        @Override // com.tencent.mars.cdn.CronetLogic.CronetTaskCallback
        public int onCronetReceiveHeader(CronetLogic.ResponseHeader header, int i3, String str) {
            Intrinsics.checkNotNullParameter(header, "header");
            w.d("Luggage.CronetDownloader", "onCronetReceiveHeader status: " + i3 + " taskId:" + this.f126886b);
            return 0;
        }

        @Override // com.tencent.mars.cdn.CronetLogic.CronetTaskCallback
        public void onCronetTaskCompleted(String filekey, CronetLogic.CronetTaskResult result, String str) {
            String str2;
            Intrinsics.checkNotNullParameter(filekey, "filekey");
            Intrinsics.checkNotNullParameter(result, "result");
            try {
                str2 = h0.a(z.c());
                Intrinsics.checkNotNullExpressionValue(str2, "{\n                    Ne\u2026text())\n                }");
            } catch (Exception unused) {
                str2 = "UNKNOWN";
            }
            w.d("Luggage.CronetDownloader", "onCronetTaskCompleted, errorCode:" + result.errorCode + ", errorMsg:" + result.errorMsg + ", httpStatusCode:" + result.statusCode + ", totalReceiveByte:" + result.totalReceiveByte + ", taskId:" + this.f126886b + ", fileKey:" + filekey + ", cost:" + (w0.c() - this.f126887c) + "ms, networkType:" + str2);
            this.f126888d.set(result.errorCode);
            this.f126889e.countDown();
        }

        @Override // com.tencent.mars.cdn.CronetLogic.CronetTaskCallback
        public void onDownloadProgressChanged(String filekey, CronetLogic.CronetDownloadProgress progress) {
            Function1 function1;
            int roundToInt;
            Intrinsics.checkNotNullParameter(filekey, "filekey");
            Intrinsics.checkNotNullParameter(progress, "progress");
            if (w.d() <= 0) {
                w.e("Luggage.CronetDownloader", "onDownloadProgressChanged key:" + filekey + ", currentWriteByte:" + progress.currentWriteByte + " totalByte:" + progress.totalByte);
            }
            if (progress.totalByte > 0 && (function1 = this.f126885a) != null) {
                g0 g0Var = new g0();
                long min = Math.min(progress.currentWriteByte, progress.totalByte);
                g0Var.f134301b = min;
                long j3 = progress.totalByte;
                g0Var.f134302c = j3;
                roundToInt = MathKt__MathJVMKt.roundToInt((((float) min) / ((float) j3)) * 100);
                g0Var.f134300a = roundToInt;
                function1.invoke(g0Var);
            }
        }

        @Override // com.tencent.mars.cdn.CronetLogic.CronetTaskCallback
        public void onCronetReceiveChunkedData(CronetLogic.ChunkedData chunkedData, long j3) {
        }

        @Override // com.tencent.mars.cdn.CronetLogic.CronetTaskCallback
        public void onCronetReceiveUploadProgress(long j3, long j16) {
        }
    }
}
