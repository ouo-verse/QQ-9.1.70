package com.tencent.mobileqq.wink.api.impl;

import android.graphics.Bitmap;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.wink.api.IClipService;
import com.tencent.mobileqq.wink.api.IWinkWeClipApi;
import com.tencent.mobileqq.wink.model.MediaScanForwardResult;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.util.BitmapUtil;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\u0018\u0000 ,2\u00020\u0001:\u0001-B\u0007\u00a2\u0006\u0004\b*\u0010+J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J%\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0007*\u00020\u0006H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\tJ&\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007*\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0007H\u0002J\u001a\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\"\u0010\u0012\u001a\u00020\u00042\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R*\u0010!\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u001d0\u001cj\b\u0012\u0004\u0012\u00020\u001d`\u001e0\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/wink/api/impl/ClipServiceBinder;", "Lcom/tencent/mobileqq/wink/api/IClipService$a;", "Lcom/tencent/mobileqq/wink/api/a;", "callback", "", "z1", "", "Lkotlin/Pair;", ICustomDataEditor.STRING_PARAM_1, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/graphics/Bitmap;", "B1", "", "batchSize", "mediaScan", "stopScan", "", "uris", "doClipForward", "Lcom/tencent/mobileqq/wink/api/IWinkWeClipApi;", "d", "Lcom/tencent/mobileqq/wink/api/IWinkWeClipApi;", "winkApi", "Lkotlinx/coroutines/CoroutineScope;", "e", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Ljava/util/concurrent/atomic/AtomicReference;", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/wink/model/MediaScanForwardResult;", "Lkotlin/collections/ArrayList;", "f", "Ljava/util/concurrent/atomic/AtomicReference;", "resultBuffer", "Lkotlinx/coroutines/Job;", tl.h.F, "Lkotlinx/coroutines/Job;", "batchJob", "", "i", "J", "lastOfferTime", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class ClipServiceBinder extends IClipService.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IWinkWeClipApi winkApi;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CoroutineScope scope;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AtomicReference<ArrayList<MediaScanForwardResult>> resultBuffer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Job batchJob;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long lastOfferTime;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "state", "Lcom/tencent/libra/LoadState;", "kotlin.jvm.PlatformType", "opt", "Lcom/tencent/libra/request/Option;", "onStateChange"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class b implements IPicLoadStateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<Pair<String, String>> f317966d;

        /* JADX WARN: Multi-variable type inference failed */
        b(CancellableContinuation<? super Pair<String, String>> cancellableContinuation) {
            this.f317966d = cancellableContinuation;
        }

        @Override // com.tencent.libra.listener.IPicLoadStateListener
        public final void onStateChange(LoadState loadState, Option option) {
            if (loadState.isDownloadSuccess()) {
                CancellableContinuation<Pair<String, String>> cancellableContinuation = this.f317966d;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m476constructorimpl(TuplesKt.to(option.getUrl(), option.getLocalPath())));
                return;
            }
            this.f317966d.resumeWith(Result.m476constructorimpl(null));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/api/impl/ClipServiceBinder$c", "Li83/c;", "Lcom/tencent/mobileqq/wink/model/MediaScanForwardResult;", "result", "", "a", "", "msg", "onError", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements i83.c {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f317968b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.wink.api.a f317969c;

        c(int i3, com.tencent.mobileqq.wink.api.a aVar) {
            this.f317968b = i3;
            this.f317969c = aVar;
        }

        @Override // i83.c
        public void a(@NotNull MediaScanForwardResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            ArrayList arrayList = (ArrayList) ClipServiceBinder.this.resultBuffer.get();
            arrayList.add(result);
            ClipServiceBinder.this.lastOfferTime = System.currentTimeMillis();
            w53.b.a("ClipServiceBinder", "mediaScan offer, remaining: " + arrayList.size());
            if (arrayList.size() >= this.f317968b) {
                ClipServiceBinder.this.z1(this.f317969c);
            }
        }

        @Override // i83.c
        public void onError(@NotNull String msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            w53.b.c("ClipServiceBinder", "mediaScan error: " + msg2);
        }
    }

    public ClipServiceBinder() {
        QRouteApi api = QRoute.api(IWinkWeClipApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IWinkWeClipApi::class.java)");
        this.winkApi = (IWinkWeClipApi) api;
        this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        this.resultBuffer = new AtomicReference<>(new ArrayList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Pair<String, Bitmap> B1(Pair<String, String> pair) {
        try {
            return TuplesKt.to(pair.getFirst(), Bitmap.createScaledBitmap(BitmapUtil.decodeFile(pair.getSecond()), 224, 224, true));
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object s1(String str, Continuation<? super Pair<String, String>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        QCircleFeedPicLoader.g().download(Option.obtain().setUrl(str).setRequestWidth(224).setRequestHeight(224), new b(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z1(com.tencent.mobileqq.wink.api.a callback) {
        ArrayList<MediaScanForwardResult> currentBuffer = this.resultBuffer.get();
        w53.b.a("ClipServiceBinder", "flushBuffer, remaining: " + currentBuffer.size());
        Intrinsics.checkNotNullExpressionValue(currentBuffer, "currentBuffer");
        if (!currentBuffer.isEmpty()) {
            if (callback != null) {
                callback.R(new ArrayList(currentBuffer));
            }
            currentBuffer.clear();
        }
        Job job = this.batchJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
    }

    @Override // com.tencent.mobileqq.wink.api.IClipService
    public void doClipForward(@Nullable List<String> uris, @Nullable com.tencent.mobileqq.wink.api.a callback) {
        Integer num;
        boolean z16;
        List<MediaScanForwardResult> emptyList;
        if (uris != null) {
            num = Integer.valueOf(uris.size());
        } else {
            num = null;
        }
        w53.b.a("ClipServiceBinder", "doClipForward, uris: " + num);
        List<String> list = uris;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new ClipServiceBinder$doClipForward$1(uris, this, callback, null), 3, null);
        } else if (callback != null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            callback.R(emptyList);
        }
    }

    @Override // com.tencent.mobileqq.wink.api.IClipService
    public void mediaScan(int batchSize, @Nullable com.tencent.mobileqq.wink.api.a callback) {
        Job launch$default;
        Job job = this.batchJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.resultBuffer.get().clear();
        this.lastOfferTime = System.currentTimeMillis();
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new ClipServiceBinder$mediaScan$1(this, callback, null), 3, null);
        this.batchJob = launch$default;
        this.winkApi.mediaScan(new c(batchSize, callback));
    }

    @Override // com.tencent.mobileqq.wink.api.IClipService
    public void stopScan() {
        w53.b.a("ClipServiceBinder", "stopScan");
        try {
            this.winkApi.stopScan();
            Job job = this.batchJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            ArrayList<MediaScanForwardResult> remaining = this.resultBuffer.get();
            Intrinsics.checkNotNullExpressionValue(remaining, "remaining");
            if (true ^ remaining.isEmpty()) {
                remaining.clear();
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }
}
