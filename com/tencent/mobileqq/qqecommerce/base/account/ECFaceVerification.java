package com.tencent.mobileqq.qqecommerce.base.account;

import android.content.Context;
import com.tencent.ecommerce.base.account.api.IECFaceVerification;
import com.tencent.mobileqq.qqconnectface.IIdentificationApi;
import com.tencent.mobileqq.qqconnectface.c;
import com.tencent.mobileqq.qroute.QRoute;
import cooperation.qqcircle.report.QCircleQualityReporter;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ,2\u00020\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b*\u0010+JU\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fJ=\u0010\u0012\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\rH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016R\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010!\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\u001eR\u001b\u0010&\u001a\u00020\"8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b#\u0010%R\u0018\u0010)\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010(\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/base/account/ECFaceVerification;", "Lcom/tencent/ecommerce/base/account/api/IECFaceVerification;", "", "appId", "", "keyType", "key", "uin", "from", "idCard", "name", "", "nonce", "Lcom/tencent/ecommerce/base/account/api/IECFaceVerification$b;", "d", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "psKey", "idNum", "requestForFaceVerificationConfig", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/content/Context;", "context", "identificationConfig", "Lcom/tencent/ecommerce/base/account/api/IECFaceVerification$a;", "startFaceVerification", "(Landroid/content/Context;Lcom/tencent/ecommerce/base/account/api/IECFaceVerification$b;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "onRelease", "Lokhttp3/MediaType;", "a", "Lokhttp3/MediaType;", "jsonType", "b", "urlType", "Lokhttp3/OkHttpClient;", "c", "Lkotlin/Lazy;", "()Lokhttp3/OkHttpClient;", "okHttpClient", "Lcom/tencent/mobileqq/qqconnectface/a;", "Lcom/tencent/mobileqq/qqconnectface/a;", "identificationCallback", "<init>", "()V", "e", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ECFaceVerification implements IECFaceVerification {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final MediaType jsonType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final MediaType urlType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Lazy okHttpClient;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.qqconnectface.a identificationCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/qqecommerce/base/account/ECFaceVerification$b", "Lcom/tencent/mobileqq/qqconnectface/a;", "Lcom/tencent/mobileqq/qqconnectface/c;", "result", "", "onIdentificationSuccess", "onIdentificationCanceled", "onIdentificationFailed", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends com.tencent.mobileqq.qqconnectface.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<IECFaceVerification.FaceVerificationResult> f262397a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IECFaceVerification.IdentificationConfig f262398b;

        /* JADX WARN: Multi-variable type inference failed */
        b(Continuation<? super IECFaceVerification.FaceVerificationResult> continuation, IECFaceVerification.IdentificationConfig identificationConfig) {
            this.f262397a = continuation;
            this.f262398b = identificationConfig;
        }

        @Override // com.tencent.mobileqq.qqconnectface.a
        public void onIdentificationCanceled() {
            super.onIdentificationCanceled();
            this.f262397a.resumeWith(Result.m476constructorimpl(null));
        }

        @Override // com.tencent.mobileqq.qqconnectface.a
        public void onIdentificationFailed(c result) {
            super.onIdentificationFailed(result);
            this.f262397a.resumeWith(Result.m476constructorimpl(null));
        }

        @Override // com.tencent.mobileqq.qqconnectface.a
        public void onIdentificationSuccess(c result) {
            super.onIdentificationSuccess(result);
            String str = result != null ? result.f262380c : null;
            if (str == null || str.length() == 0) {
                this.f262397a.resumeWith(Result.m476constructorimpl(null));
                return;
            }
            Continuation<IECFaceVerification.FaceVerificationResult> continuation = this.f262397a;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(new IECFaceVerification.FaceVerificationResult(str, "101997523", this.f262398b.getOpenId())));
        }
    }

    public ECFaceVerification() {
        Lazy lazy;
        MediaType.Companion companion = MediaType.INSTANCE;
        this.jsonType = companion.get("application/json; charset=utf-8");
        this.urlType = companion.get("application/x-www-form-urlencoded");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<OkHttpClient>() { // from class: com.tencent.mobileqq.qqecommerce.base.account.ECFaceVerification$okHttpClient$2
            @Override // kotlin.jvm.functions.Function0
            public final OkHttpClient invoke() {
                return new OkHttpClient();
            }
        });
        this.okHttpClient = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OkHttpClient c() {
        return (OkHttpClient) this.okHttpClient.getValue();
    }

    private final Object d(int i3, String str, String str2, String str3, String str4, String str5, String str6, long j3, Continuation<? super IECFaceVerification.IdentificationConfig> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ECFaceVerification$requestForFaceVerificationConfigInternal$2(this, str3, str5, str6, i3, str, str2, str4, j3, null), continuation);
    }

    @Override // com.tencent.ecommerce.base.account.api.IECFaceVerification
    public void onRelease(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ((IIdentificationApi) QRoute.api(IIdentificationApi.class)).unregisterCallback(context, this.identificationCallback);
    }

    @Override // com.tencent.ecommerce.base.account.api.IECFaceVerification
    public Object startFaceVerification(Context context, IECFaceVerification.IdentificationConfig identificationConfig, Continuation<? super IECFaceVerification.FaceVerificationResult> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        com.tencent.mobileqq.qqconnectface.b bVar = new com.tencent.mobileqq.qqconnectface.b();
        bVar.f262371a = 101997523;
        bVar.f262372b = QCircleQualityReporter.KEY_ID;
        bVar.f262374d = identificationConfig.getUin();
        bVar.f262376f = identificationConfig.getTmpKey();
        bVar.f262375e = identificationConfig.getOpenId();
        bVar.f262377g = 1;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        this.identificationCallback = new b(safeContinuation, identificationConfig);
        ((IIdentificationApi) QRoute.api(IIdentificationApi.class)).startIdentification(context, bVar, this.identificationCallback);
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    @Override // com.tencent.ecommerce.base.account.api.IECFaceVerification
    public Object requestForFaceVerificationConfig(String str, String str2, String str3, String str4, long j3, Continuation<? super IECFaceVerification.IdentificationConfig> continuation) {
        return d(101997523, "pskey", str, str2, "recognize", str3, str4, j3, continuation);
    }
}
