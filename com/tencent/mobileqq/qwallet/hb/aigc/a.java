package com.tencent.mobileqq.qwallet.hb.aigc;

import com.tencent.mobileqq.wink.edit.manager.g;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.aigc.AIGCClient;
import org.light.aigc.bean.AIGCContentOutput;
import org.light.aigc.bean.AIGCRequest;
import org.light.aigc.bean.ContentInfo;
import org.light.aigc.bean.MediaType;
import org.light.aigc.net.IGenerateCallback;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0006\u0010\t\u001a\u00020\u0002J#\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/aigc/a;", "", "", "e", "", "bizId", "url", "Lorg/light/aigc/bean/AIGCRequest;", "d", "f", "Lorg/light/aigc/bean/AIGCContentOutput;", "g", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "path", tl.h.F, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lorg/light/aigc/AIGCClient;", "a", "Lorg/light/aigc/AIGCClient;", "aigcClient", "<init>", "()V", "b", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private volatile AIGCClient aigcClient;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/qwallet/hb/aigc/a$b", "Lorg/light/aigc/net/IGenerateCallback;", "Lorg/light/aigc/bean/AIGCContentOutput;", "output", "", "onSuccess", "", "errorCode", "", "errorMsg", "onError", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b implements IGenerateCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<AIGCContentOutput> f277213a;

        /* JADX WARN: Multi-variable type inference failed */
        b(CancellableContinuation<? super AIGCContentOutput> cancellableContinuation) {
            this.f277213a = cancellableContinuation;
        }

        @Override // org.light.aigc.net.IGenerateCallback
        public void onError(long errorCode, @Nullable String errorMsg) {
            QLog.i("QWalletAigcHbService", 1, "requestAigc onError: " + errorCode + ", errorMsg: " + errorMsg);
            if (this.f277213a.isActive() && !this.f277213a.isCancelled()) {
                CancellableContinuation<AIGCContentOutput> cancellableContinuation = this.f277213a;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new Exception(errorCode + "," + errorMsg))));
            }
        }

        @Override // org.light.aigc.net.IGenerateCallback
        public void onSuccess(@Nullable AIGCContentOutput output) {
            QLog.i("QWalletAigcHbService", 1, "requestAigc onSuccess:" + output);
            if (this.f277213a.isActive() && !this.f277213a.isCancelled()) {
                if (output == null) {
                    CancellableContinuation<AIGCContentOutput> cancellableContinuation = this.f277213a;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new RuntimeException("empty result"))));
                    return;
                }
                this.f277213a.resumeWith(Result.m476constructorimpl(output));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AIGCRequest d(String bizId, String url) {
        ArrayList arrayListOf;
        AIGCRequest aIGCRequest = new AIGCRequest();
        aIGCRequest.bussId = bizId;
        aIGCRequest.functionId = "image_detect";
        ContentInfo contentInfo = new ContentInfo();
        contentInfo.type = MediaType.TypeImage;
        contentInfo.stringData = url;
        Unit unit = Unit.INSTANCE;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(contentInfo);
        aIGCRequest.contentInfos = arrayListOf;
        aIGCRequest.extra = "";
        return aIGCRequest;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void e() {
        try {
            if (this.aigcClient == null) {
                this.aigcClient = com.tencent.mobileqq.wink.aigc.utils.b.f317941a.i();
            }
        } finally {
        }
    }

    public final void f() {
        AIGCClient aIGCClient = this.aigcClient;
        if (aIGCClient != null) {
            aIGCClient.release();
        }
        this.aigcClient = null;
    }

    @Nullable
    public final Object g(@NotNull String str, @NotNull String str2, @NotNull Continuation<? super AIGCContentOutput> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        e();
        AIGCClient aIGCClient = this.aigcClient;
        if (aIGCClient != null) {
            aIGCClient.generateAIGCContent(d(str, str2), new b(cancellableContinuationImpl));
        }
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @Nullable
    public final Object h(@Nullable String str, @NotNull Continuation<? super String> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        if (str != null) {
            com.tencent.mobileqq.wink.edit.manager.g.c(str, com.tencent.mobileqq.qwallet.hb.aigc.c.f277218a.c(str), new c(cancellableContinuationImpl, str));
        }
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/qwallet/hb/aigc/a$c", "Lcom/tencent/mobileqq/wink/edit/manager/g$b;", "", "imageDownLoadUrl", "", "onSuccess", "onFail", "onCancel", "", "progress", "onProgress", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class c implements g.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<String> f277214d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f277215e;

        /* JADX WARN: Multi-variable type inference failed */
        c(CancellableContinuation<? super String> cancellableContinuation, String str) {
            this.f277214d = cancellableContinuation;
            this.f277215e = str;
        }

        @Override // com.tencent.mobileqq.wink.edit.manager.g.b
        public void onCancel() {
            QLog.e("QWalletAigcHbService", 1, "uploadOriginImageFile " + this.f277215e + " canceled");
            if (this.f277214d.isActive() && !this.f277214d.isCancelled()) {
                CancellableContinuation<String> cancellableContinuation = this.f277214d;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new IllegalStateException("upload cancel"))));
            }
        }

        @Override // com.tencent.mobileqq.wink.edit.manager.g.b
        public void onFail() {
            QLog.e("QWalletAigcHbService", 1, "uploadOriginImageFile " + this.f277215e + " failed");
            if (this.f277214d.isActive() && !this.f277214d.isCancelled()) {
                CancellableContinuation<String> cancellableContinuation = this.f277214d;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new IllegalStateException("upload fail"))));
            }
        }

        @Override // com.tencent.mobileqq.wink.edit.manager.g.b
        public void onSuccess(@Nullable String imageDownLoadUrl) {
            boolean z16 = true;
            QLog.d("QWalletAigcHbService", 1, "upload result path: " + imageDownLoadUrl);
            if (this.f277214d.isActive() && !this.f277214d.isCancelled()) {
                if (imageDownLoadUrl != null && imageDownLoadUrl.length() != 0) {
                    z16 = false;
                }
                if (!z16) {
                    this.f277214d.resumeWith(Result.m476constructorimpl(imageDownLoadUrl));
                    return;
                }
                CancellableContinuation<String> cancellableContinuation = this.f277214d;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new IllegalStateException("upload empty"))));
            }
        }

        @Override // com.tencent.mobileqq.wink.edit.manager.g.b
        public void onProgress(int progress) {
        }
    }
}
