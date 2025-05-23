package com.tencent.filament.zplanservice.download;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.report.ReportConstant;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 P2\u00020\u0001:\u0001DB\u000f\u0012\u0006\u0010M\u001a\u00020J\u00a2\u0006\u0004\bN\u0010OJ!\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0082 J\u0011\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\bH\u0082 J!\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0082 J1\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0082 J)\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0082 J)\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0082 J!\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0082 J\u0019\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0082 J!\u0010!\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0010\u001a\u00020 H\u0082 J!\u0010#\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0082 J\u0019\u0010$\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u0002H\u0082 J\u0019\u0010&\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020%H\u0082 J!\u0010(\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010'\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0082 J)\u0010+\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0082 J\u0019\u0010,\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0082 J\u0006\u0010-\u001a\u00020\u000bJ\u001b\u0010.\u001a\u00020\u001e2\u0006\u0010\u000e\u001a\u00020\rH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b.\u0010/J+\u00100\u001a\u00020\u001e2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0004H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b0\u00101J#\u00102\u001a\u00020\u001e2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b2\u00103J#\u00104\u001a\u00020\u001e2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b4\u00103J\u001b\u00105\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b5\u00106J\u0013\u00107\u001a\u00020\u001eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b7\u00108J\u0013\u00109\u001a\u00020\u001eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b9\u00108J\u001b\u0010:\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b:\u00106J#\u0010;\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b;\u0010<J\u000e\u0010=\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u0002J\u0013\u0010>\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b>\u00108J!\u0010A\u001a\b\u0012\u0004\u0012\u00020@0?2\u0006\u0010\u001f\u001a\u00020\u001eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\bA\u0010BJ\u001b\u0010C\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\bC\u00106R\u0016\u0010\n\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0014\u0010I\u001a\u00020F8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0014\u0010M\u001a\u00020J8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bK\u0010L\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006Q"}, d2 = {"Lcom/tencent/filament/zplanservice/download/ZPlanAvatarService;", "", "", "urlTemplate", "", "enableResourceCheck", "", "algorithmSelect", "", "nCreateZPlanAvatarService", "nativeObject", "", "nDeleteZPlanAvatarService", "Lcom/tencent/filament/zplanservice/download/FetchBootResourcesOptions;", "options", "Lcom/tencent/filament/zplanservice/download/IZPlanAvatarServiceCallback;", "callback", "nFetchBootResource", "avatarInfo", "Lcom/tencent/filament/zplanservice/download/ZPlanAvatarMask;", "avatarMask", "needApplyShoesHeight", "nFetchAvatarResource", "actionId", "gender", "nFetchFaceAction", "nFetchBodyAction", "path", "nFetchAction", "nFetchIndirectLight", "Lcom/tencent/filament/zplanservice/download/ZPlanAvatarInterfaceResult;", "result", "Lcom/tencent/filament/zplanservice/download/IZPlanAvatarCheckCallback;", "nCheckResult", "url", "nDeprecatedFetchFile", "nDeprecatedUnzipDirectoryPathWithUrl", "Lcom/tencent/filament/zplanservice/download/IZPlanFetchShareDirCallback;", "nDeprecatedShadersDirectory", "gltfPath", "nFetchLocalGltfDependencies", "shaderName", "shaderExtension", "nDeprecatedFetchShaderDirFile", "nFetchAIBodyDriveJson", "E", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lcom/tencent/filament/zplanservice/download/FetchBootResourcesOptions;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "y", "(Ljava/lang/String;Lcom/tencent/filament/zplanservice/download/ZPlanAvatarMask;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "B", "(JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, HippyTKDListViewAdapter.X, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", BdhLogUtil.LogTag.Tag_Conn, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "w", ReportConstant.COSTREPORT_PREFIX, "t", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "v", "u", "", "Lcom/tencent/filament/zplanservice/download/ZPlanAvatarCheckResult;", "r", "(Lcom/tencent/filament/zplanservice/download/ZPlanAvatarInterfaceResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "D", "a", "J", "Lkotlinx/coroutines/Job;", "b", "Lkotlinx/coroutines/Job;", "initServiceJob", "Lcom/tencent/filament/zplanservice/download/a;", "c", "Lcom/tencent/filament/zplanservice/download/a;", DownloadInfo.spKey_Config, "<init>", "(Lcom/tencent/filament/zplanservice/download/a;)V", "d", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class ZPlanAvatarService {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long nativeObject;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Job initServiceJob;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final a config;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
    @DebugMetadata(c = "com.tencent.filament.zplanservice.download.ZPlanAvatarService$1", f = "ZPlanAvatarService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.filament.zplanservice.download.ZPlanAvatarService$1, reason: invalid class name */
    /* loaded from: classes6.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
            Intrinsics.checkNotNullParameter(completion, "completion");
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(completion);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                bl0.a aVar = bl0.a.f28591a;
                FLog.INSTANCE.i("[ZPlanAvatarService]", "init service. " + coroutineScope);
                ZPlanAvatarService zPlanAvatarService = ZPlanAvatarService.this;
                zPlanAvatarService.nativeObject = zPlanAvatarService.nCreateZPlanAvatarService(zPlanAvatarService.config.getUrlTemplate(), ZPlanAvatarService.this.config.getEnableResourceCheck(), ZPlanAvatarService.this.config.getAlgorithmSelect().getValue());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public ZPlanAvatarService(@NotNull a config) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
        launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(null), 3, null);
        this.initServiceJob = launch$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nCheckResult(long nativeObject, ZPlanAvatarInterfaceResult result, IZPlanAvatarCheckCallback callback);

    /* JADX INFO: Access modifiers changed from: private */
    public final native long nCreateZPlanAvatarService(String urlTemplate, boolean enableResourceCheck, int algorithmSelect);

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nDeleteZPlanAvatarService(long nativeObject);

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nDeprecatedFetchFile(long nativeObject, String url, IZPlanAvatarServiceCallback callback);

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nDeprecatedFetchShaderDirFile(long nativeObject, String shaderName, String shaderExtension, IZPlanAvatarServiceCallback callback);

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nDeprecatedShadersDirectory(long nativeObject, IZPlanFetchShareDirCallback callback);

    private final native String nDeprecatedUnzipDirectoryPathWithUrl(long nativeObject, String url);

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nFetchAIBodyDriveJson(long nativeObject, IZPlanAvatarServiceCallback callback);

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nFetchAction(long nativeObject, String path, IZPlanAvatarServiceCallback callback);

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nFetchAvatarResource(long nativeObject, String avatarInfo, ZPlanAvatarMask avatarMask, boolean needApplyShoesHeight, IZPlanAvatarServiceCallback callback);

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nFetchBodyAction(long nativeObject, long actionId, int gender, IZPlanAvatarServiceCallback callback);

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nFetchBootResource(long nativeObject, FetchBootResourcesOptions options, IZPlanAvatarServiceCallback callback);

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nFetchFaceAction(long nativeObject, long actionId, int gender, IZPlanAvatarServiceCallback callback);

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nFetchIndirectLight(long nativeObject, IZPlanAvatarServiceCallback callback);

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nFetchLocalGltfDependencies(long nativeObject, String gltfPath, IZPlanAvatarServiceCallback callback);

    @Nullable
    public final Object A(@NotNull final FetchBootResourcesOptions fetchBootResourcesOptions, @NotNull Continuation<? super ZPlanAvatarInterfaceResult> continuation) throws ZPlanAvatarServiceException {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        this.initServiceJob.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: com.tencent.filament.zplanservice.download.ZPlanAvatarService$fetchBootResource$$inlined$suspendCoroutine$lambda$1

            @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"com/tencent/filament/zplanservice/download/ZPlanAvatarService$fetchBootResource$2$1$1", "Lcom/tencent/filament/zplanservice/download/IZPlanAvatarServiceCallback;", "Lcom/tencent/filament/zplanservice/download/ZPlanAvatarInterfaceResult;", "result", "", "onSuccess", "Lcom/tencent/filament/zplanservice/download/ZPlanAvatarError;", "error", "onFail", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
            /* loaded from: classes6.dex */
            public static final class a implements IZPlanAvatarServiceCallback {
                a() {
                }

                @Override // com.tencent.filament.zplanservice.download.IZPlanAvatarServiceCallback
                public void onFail(@NotNull ZPlanAvatarError error) {
                    Intrinsics.checkNotNullParameter(error, "error");
                    FLog.INSTANCE.e("[ZPlanAvatarService]", "fetchBootResource fail. error:" + error);
                    Continuation continuation = Continuation.this;
                    ZPlanAvatarServiceException zPlanAvatarServiceException = new ZPlanAvatarServiceException(error);
                    Result.Companion companion = Result.INSTANCE;
                    continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(zPlanAvatarServiceException)));
                }

                @Override // com.tencent.filament.zplanservice.download.IZPlanAvatarServiceCallback
                public void onSuccess(@NotNull ZPlanAvatarInterfaceResult result) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    Continuation.this.resumeWith(Result.m476constructorimpl(result));
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                long j3;
                FLog.INSTANCE.i("[ZPlanAvatarService]", "exec fetchBootResource. " + this);
                ZPlanAvatarService zPlanAvatarService = this;
                j3 = zPlanAvatarService.nativeObject;
                zPlanAvatarService.nFetchBootResource(j3, fetchBootResourcesOptions, new a());
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    @Nullable
    public final Object B(final long j3, final int i3, @NotNull Continuation<? super ZPlanAvatarInterfaceResult> continuation) throws ZPlanAvatarServiceException {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        this.initServiceJob.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: com.tencent.filament.zplanservice.download.ZPlanAvatarService$fetchFaceAction$$inlined$suspendCoroutine$lambda$1

            @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"com/tencent/filament/zplanservice/download/ZPlanAvatarService$fetchFaceAction$2$1$1", "Lcom/tencent/filament/zplanservice/download/IZPlanAvatarServiceCallback;", "Lcom/tencent/filament/zplanservice/download/ZPlanAvatarInterfaceResult;", "result", "", "onSuccess", "Lcom/tencent/filament/zplanservice/download/ZPlanAvatarError;", "error", "onFail", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
            /* loaded from: classes6.dex */
            public static final class a implements IZPlanAvatarServiceCallback {
                a() {
                }

                @Override // com.tencent.filament.zplanservice.download.IZPlanAvatarServiceCallback
                public void onFail(@NotNull ZPlanAvatarError error) {
                    Intrinsics.checkNotNullParameter(error, "error");
                    FLog.INSTANCE.e("[ZPlanAvatarService]", "fetchFaceAction fail. actionId:" + j3 + " gender:" + i3 + " error:" + error);
                    Continuation continuation = Continuation.this;
                    ZPlanAvatarServiceException zPlanAvatarServiceException = new ZPlanAvatarServiceException(error);
                    Result.Companion companion = Result.INSTANCE;
                    continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(zPlanAvatarServiceException)));
                }

                @Override // com.tencent.filament.zplanservice.download.IZPlanAvatarServiceCallback
                public void onSuccess(@NotNull ZPlanAvatarInterfaceResult result) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    Continuation.this.resumeWith(Result.m476constructorimpl(result));
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                long j16;
                FLog.INSTANCE.i("[ZPlanAvatarService]", "fetchFaceAction exec. actionId:" + j3 + " gender:" + i3);
                ZPlanAvatarService zPlanAvatarService = this;
                j16 = zPlanAvatarService.nativeObject;
                zPlanAvatarService.nFetchFaceAction(j16, j3, i3, new a());
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    @Nullable
    public final Object C(@NotNull Continuation<? super ZPlanAvatarInterfaceResult> continuation) throws ZPlanAvatarServiceException {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        this.initServiceJob.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: com.tencent.filament.zplanservice.download.ZPlanAvatarService$fetchIndirectLight$$inlined$suspendCoroutine$lambda$1

            @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"com/tencent/filament/zplanservice/download/ZPlanAvatarService$fetchIndirectLight$2$1$1", "Lcom/tencent/filament/zplanservice/download/IZPlanAvatarServiceCallback;", "Lcom/tencent/filament/zplanservice/download/ZPlanAvatarInterfaceResult;", "result", "", "onSuccess", "Lcom/tencent/filament/zplanservice/download/ZPlanAvatarError;", "error", "onFail", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
            /* loaded from: classes6.dex */
            public static final class a implements IZPlanAvatarServiceCallback {
                a() {
                }

                @Override // com.tencent.filament.zplanservice.download.IZPlanAvatarServiceCallback
                public void onFail(@NotNull ZPlanAvatarError error) {
                    Intrinsics.checkNotNullParameter(error, "error");
                    FLog.INSTANCE.e("[ZPlanAvatarService]", "fetchIndirectLight fail. error: " + error.toString());
                    Continuation continuation = Continuation.this;
                    ZPlanAvatarServiceException zPlanAvatarServiceException = new ZPlanAvatarServiceException(error);
                    Result.Companion companion = Result.INSTANCE;
                    continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(zPlanAvatarServiceException)));
                }

                @Override // com.tencent.filament.zplanservice.download.IZPlanAvatarServiceCallback
                public void onSuccess(@NotNull ZPlanAvatarInterfaceResult result) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    Continuation.this.resumeWith(Result.m476constructorimpl(result));
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                long j3;
                FLog.INSTANCE.i("[ZPlanAvatarService]", "fetchIndirectLight exec.");
                ZPlanAvatarService zPlanAvatarService = this;
                j3 = zPlanAvatarService.nativeObject;
                zPlanAvatarService.nFetchIndirectLight(j3, new a());
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    @Nullable
    public final Object D(@NotNull final String str, @NotNull Continuation<? super ZPlanAvatarInterfaceResult> continuation) throws ZPlanAvatarServiceException {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        this.initServiceJob.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: com.tencent.filament.zplanservice.download.ZPlanAvatarService$fetchLocalGltfDependencies$$inlined$suspendCoroutine$lambda$1

            @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"com/tencent/filament/zplanservice/download/ZPlanAvatarService$fetchLocalGltfDependencies$2$1$1", "Lcom/tencent/filament/zplanservice/download/IZPlanAvatarServiceCallback;", "Lcom/tencent/filament/zplanservice/download/ZPlanAvatarInterfaceResult;", "result", "", "onSuccess", "Lcom/tencent/filament/zplanservice/download/ZPlanAvatarError;", "error", "onFail", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
            /* loaded from: classes6.dex */
            public static final class a implements IZPlanAvatarServiceCallback {
                a() {
                }

                @Override // com.tencent.filament.zplanservice.download.IZPlanAvatarServiceCallback
                public void onFail(@NotNull ZPlanAvatarError error) {
                    Intrinsics.checkNotNullParameter(error, "error");
                    FLog.INSTANCE.e("[ZPlanAvatarService]V2", "FLGFDependencies fail. gltfPath:" + str);
                    Continuation continuation = Continuation.this;
                    ZPlanAvatarServiceException zPlanAvatarServiceException = new ZPlanAvatarServiceException(error);
                    Result.Companion companion = Result.INSTANCE;
                    continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(zPlanAvatarServiceException)));
                }

                @Override // com.tencent.filament.zplanservice.download.IZPlanAvatarServiceCallback
                public void onSuccess(@NotNull ZPlanAvatarInterfaceResult result) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    Continuation.this.resumeWith(Result.m476constructorimpl(result));
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                long j3;
                FLog.INSTANCE.i("[ZPlanAvatarService]V2", "FLGFDependencies exec. gltfPath:" + str);
                ZPlanAvatarService zPlanAvatarService = this;
                j3 = zPlanAvatarService.nativeObject;
                zPlanAvatarService.nFetchLocalGltfDependencies(j3, str, new a());
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public final void E() {
        FLog.INSTANCE.i("[ZPlanAvatarService]", "stop. " + this);
        this.initServiceJob.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: com.tencent.filament.zplanservice.download.ZPlanAvatarService$stop$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                long j3;
                FLog.INSTANCE.i("[ZPlanAvatarService]", "exec stop. " + ZPlanAvatarService.this);
                ZPlanAvatarService zPlanAvatarService = ZPlanAvatarService.this;
                j3 = zPlanAvatarService.nativeObject;
                zPlanAvatarService.nDeleteZPlanAvatarService(j3);
                ZPlanAvatarService.this.nativeObject = 0L;
            }
        });
    }

    @Nullable
    public final Object r(@NotNull final ZPlanAvatarInterfaceResult zPlanAvatarInterfaceResult, @NotNull Continuation<? super ZPlanAvatarCheckResult[]> continuation) throws ZPlanAvatarServiceException {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        this.initServiceJob.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: com.tencent.filament.zplanservice.download.ZPlanAvatarService$checkResult$$inlined$suspendCoroutine$lambda$1

            @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b\u00b8\u0006\u0000"}, d2 = {"com/tencent/filament/zplanservice/download/ZPlanAvatarService$checkResult$2$1$1", "Lcom/tencent/filament/zplanservice/download/IZPlanAvatarCheckCallback;", "", "Lcom/tencent/filament/zplanservice/download/ZPlanAvatarCheckResult;", "result", "", "onSuccess", "([Lcom/tencent/filament/zplanservice/download/ZPlanAvatarCheckResult;)V", "Lcom/tencent/filament/zplanservice/download/ZPlanAvatarError;", "error", "onFail", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
            /* loaded from: classes6.dex */
            public static final class a implements IZPlanAvatarCheckCallback {
                a() {
                }

                @Override // com.tencent.filament.zplanservice.download.IZPlanAvatarCheckCallback
                public void onFail(@NotNull ZPlanAvatarError error) {
                    Intrinsics.checkNotNullParameter(error, "error");
                    FLog.INSTANCE.e("[ZPlanAvatarService]", "fail checkResult.");
                    Continuation continuation = Continuation.this;
                    ZPlanAvatarServiceException zPlanAvatarServiceException = new ZPlanAvatarServiceException(error);
                    Result.Companion companion = Result.INSTANCE;
                    continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(zPlanAvatarServiceException)));
                }

                @Override // com.tencent.filament.zplanservice.download.IZPlanAvatarCheckCallback
                public void onSuccess(@NotNull ZPlanAvatarCheckResult[] result) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    Continuation.this.resumeWith(Result.m476constructorimpl(result));
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                long j3;
                FLog.INSTANCE.i("[ZPlanAvatarService]", "exec checkResult.");
                ZPlanAvatarService zPlanAvatarService = this;
                j3 = zPlanAvatarService.nativeObject;
                zPlanAvatarService.nCheckResult(j3, zPlanAvatarInterfaceResult, new a());
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    @Nullable
    public final Object s(@NotNull final String str, @NotNull Continuation<? super ZPlanAvatarInterfaceResult> continuation) throws ZPlanAvatarServiceException {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        this.initServiceJob.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: com.tencent.filament.zplanservice.download.ZPlanAvatarService$deprecatedFetchFileWithUrl$$inlined$suspendCoroutine$lambda$1

            @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"com/tencent/filament/zplanservice/download/ZPlanAvatarService$deprecatedFetchFileWithUrl$2$1$1", "Lcom/tencent/filament/zplanservice/download/IZPlanAvatarServiceCallback;", "Lcom/tencent/filament/zplanservice/download/ZPlanAvatarError;", "error", "", "onFail", "Lcom/tencent/filament/zplanservice/download/ZPlanAvatarInterfaceResult;", "result", "onSuccess", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
            /* loaded from: classes6.dex */
            public static final class a implements IZPlanAvatarServiceCallback {
                a() {
                }

                @Override // com.tencent.filament.zplanservice.download.IZPlanAvatarServiceCallback
                public void onFail(@NotNull ZPlanAvatarError error) {
                    Intrinsics.checkNotNullParameter(error, "error");
                    FLog.INSTANCE.e("[ZPlanAvatarService]V2", "DFFile fail. error:" + error + " url:" + str);
                    Continuation continuation = Continuation.this;
                    ZPlanAvatarServiceException zPlanAvatarServiceException = new ZPlanAvatarServiceException(error);
                    Result.Companion companion = Result.INSTANCE;
                    continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(zPlanAvatarServiceException)));
                }

                @Override // com.tencent.filament.zplanservice.download.IZPlanAvatarServiceCallback
                public void onSuccess(@NotNull ZPlanAvatarInterfaceResult result) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    Continuation.this.resumeWith(Result.m476constructorimpl(result));
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                long j3;
                FLog.INSTANCE.i("[ZPlanAvatarService]V2", "DFFile exec. url:" + str);
                ZPlanAvatarService zPlanAvatarService = this;
                j3 = zPlanAvatarService.nativeObject;
                zPlanAvatarService.nDeprecatedFetchFile(j3, str, new a());
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    @Nullable
    public final Object t(@NotNull final String str, @NotNull final String str2, @NotNull Continuation<? super ZPlanAvatarInterfaceResult> continuation) throws ZPlanAvatarServiceException {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        this.initServiceJob.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: com.tencent.filament.zplanservice.download.ZPlanAvatarService$deprecatedFetchShaderDirFile$$inlined$suspendCoroutine$lambda$1

            @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"com/tencent/filament/zplanservice/download/ZPlanAvatarService$deprecatedFetchShaderDirFile$2$1$1", "Lcom/tencent/filament/zplanservice/download/IZPlanAvatarServiceCallback;", "Lcom/tencent/filament/zplanservice/download/ZPlanAvatarInterfaceResult;", "result", "", "onSuccess", "Lcom/tencent/filament/zplanservice/download/ZPlanAvatarError;", "error", "onFail", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
            /* loaded from: classes6.dex */
            public static final class a implements IZPlanAvatarServiceCallback {
                a() {
                }

                @Override // com.tencent.filament.zplanservice.download.IZPlanAvatarServiceCallback
                public void onFail(@NotNull ZPlanAvatarError error) {
                    Intrinsics.checkNotNullParameter(error, "error");
                    FLog.INSTANCE.e("[ZPlanAvatarService]V2", "DFFShader fail. shaderName:" + str + " shaderExtension:" + str2);
                    Continuation continuation = Continuation.this;
                    ZPlanAvatarServiceException zPlanAvatarServiceException = new ZPlanAvatarServiceException(error);
                    Result.Companion companion = Result.INSTANCE;
                    continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(zPlanAvatarServiceException)));
                }

                @Override // com.tencent.filament.zplanservice.download.IZPlanAvatarServiceCallback
                public void onSuccess(@NotNull ZPlanAvatarInterfaceResult result) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    Continuation.this.resumeWith(Result.m476constructorimpl(result));
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                long j3;
                FLog.INSTANCE.i("[ZPlanAvatarService]V2", "DFFShader exec. shaderName:" + str + " shaderExtension:" + str2);
                ZPlanAvatarService zPlanAvatarService = this;
                j3 = zPlanAvatarService.nativeObject;
                zPlanAvatarService.nDeprecatedFetchShaderDirFile(j3, str, str2, new a());
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    @Nullable
    public final Object u(@NotNull Continuation<? super String> continuation) throws ZPlanAvatarServiceException {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        this.initServiceJob.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: com.tencent.filament.zplanservice.download.ZPlanAvatarService$deprecatedShadersDirectory$$inlined$suspendCoroutine$lambda$1

            @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"com/tencent/filament/zplanservice/download/ZPlanAvatarService$deprecatedShadersDirectory$2$1$1", "Lcom/tencent/filament/zplanservice/download/IZPlanFetchShareDirCallback;", "", "path", "", "onSuccess", "Lcom/tencent/filament/zplanservice/download/ZPlanAvatarError;", "error", "onFail", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
            /* loaded from: classes6.dex */
            public static final class a implements IZPlanFetchShareDirCallback {
                a() {
                }

                @Override // com.tencent.filament.zplanservice.download.IZPlanFetchShareDirCallback
                public void onFail(@NotNull ZPlanAvatarError error) {
                    Intrinsics.checkNotNullParameter(error, "error");
                    FLog.INSTANCE.e("[ZPlanAvatarService]V2", "DSDir fail. error:" + error);
                    Continuation continuation = Continuation.this;
                    ZPlanAvatarServiceException zPlanAvatarServiceException = new ZPlanAvatarServiceException(error);
                    Result.Companion companion = Result.INSTANCE;
                    continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(zPlanAvatarServiceException)));
                }

                @Override // com.tencent.filament.zplanservice.download.IZPlanFetchShareDirCallback
                public void onSuccess(@NotNull String path) {
                    Intrinsics.checkNotNullParameter(path, "path");
                    Continuation.this.resumeWith(Result.m476constructorimpl(path));
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                long j3;
                FLog.INSTANCE.e("[ZPlanAvatarService]V2", "DSDir exec.");
                ZPlanAvatarService zPlanAvatarService = this;
                j3 = zPlanAvatarService.nativeObject;
                zPlanAvatarService.nDeprecatedShadersDirectory(j3, new a());
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    @NotNull
    public final String v(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        long j3 = this.nativeObject;
        if (j3 == 0) {
            FLog.INSTANCE.e("[ZPlanAvatarService]V2", "deprecatedUnzipDirectoryPathWithUrl fail. nativeObject not init. url:" + url);
            return "";
        }
        return nDeprecatedUnzipDirectoryPathWithUrl(j3, url);
    }

    @Nullable
    public final Object w(@NotNull Continuation<? super ZPlanAvatarInterfaceResult> continuation) throws ZPlanAvatarServiceException {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        this.initServiceJob.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: com.tencent.filament.zplanservice.download.ZPlanAvatarService$fetchAIBodyDriveJson$$inlined$suspendCoroutine$lambda$1

            @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"com/tencent/filament/zplanservice/download/ZPlanAvatarService$fetchAIBodyDriveJson$2$1$1", "Lcom/tencent/filament/zplanservice/download/IZPlanAvatarServiceCallback;", "Lcom/tencent/filament/zplanservice/download/ZPlanAvatarInterfaceResult;", "result", "", "onSuccess", "Lcom/tencent/filament/zplanservice/download/ZPlanAvatarError;", "error", "onFail", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
            /* loaded from: classes6.dex */
            public static final class a implements IZPlanAvatarServiceCallback {
                a() {
                }

                @Override // com.tencent.filament.zplanservice.download.IZPlanAvatarServiceCallback
                public void onFail(@NotNull ZPlanAvatarError error) {
                    Intrinsics.checkNotNullParameter(error, "error");
                    FLog.INSTANCE.e("[ZPlanAvatarService]V2", "fetchAIBodyDriveJson fail. error: " + error.toString());
                    Continuation continuation = Continuation.this;
                    ZPlanAvatarServiceException zPlanAvatarServiceException = new ZPlanAvatarServiceException(error);
                    Result.Companion companion = Result.INSTANCE;
                    continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(zPlanAvatarServiceException)));
                }

                @Override // com.tencent.filament.zplanservice.download.IZPlanAvatarServiceCallback
                public void onSuccess(@NotNull ZPlanAvatarInterfaceResult result) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    Continuation.this.resumeWith(Result.m476constructorimpl(result));
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                long j3;
                FLog.INSTANCE.i("[ZPlanAvatarService]V2", "fetchAIBodyDriveJson exec.");
                ZPlanAvatarService zPlanAvatarService = this;
                j3 = zPlanAvatarService.nativeObject;
                zPlanAvatarService.nFetchAIBodyDriveJson(j3, new a());
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    @Nullable
    public final Object x(@NotNull final String str, @NotNull Continuation<? super ZPlanAvatarInterfaceResult> continuation) throws ZPlanAvatarServiceException {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        this.initServiceJob.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: com.tencent.filament.zplanservice.download.ZPlanAvatarService$fetchAction$$inlined$suspendCoroutine$lambda$1

            @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"com/tencent/filament/zplanservice/download/ZPlanAvatarService$fetchAction$2$1$1", "Lcom/tencent/filament/zplanservice/download/IZPlanAvatarServiceCallback;", "Lcom/tencent/filament/zplanservice/download/ZPlanAvatarInterfaceResult;", "result", "", "onSuccess", "Lcom/tencent/filament/zplanservice/download/ZPlanAvatarError;", "error", "onFail", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
            /* loaded from: classes6.dex */
            public static final class a implements IZPlanAvatarServiceCallback {
                a() {
                }

                @Override // com.tencent.filament.zplanservice.download.IZPlanAvatarServiceCallback
                public void onFail(@NotNull ZPlanAvatarError error) {
                    Intrinsics.checkNotNullParameter(error, "error");
                    FLog.INSTANCE.e("[ZPlanAvatarService]", "fetchAction fail. path:" + str);
                    Continuation continuation = Continuation.this;
                    ZPlanAvatarServiceException zPlanAvatarServiceException = new ZPlanAvatarServiceException(error);
                    Result.Companion companion = Result.INSTANCE;
                    continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(zPlanAvatarServiceException)));
                }

                @Override // com.tencent.filament.zplanservice.download.IZPlanAvatarServiceCallback
                public void onSuccess(@NotNull ZPlanAvatarInterfaceResult result) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    Continuation.this.resumeWith(Result.m476constructorimpl(result));
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                long j3;
                FLog.INSTANCE.i("[ZPlanAvatarService]", "fetchAction exec. path:" + str);
                ZPlanAvatarService zPlanAvatarService = this;
                j3 = zPlanAvatarService.nativeObject;
                zPlanAvatarService.nFetchAction(j3, str, new a());
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    @Nullable
    public final Object y(@NotNull final String str, @NotNull final ZPlanAvatarMask zPlanAvatarMask, final boolean z16, @NotNull Continuation<? super ZPlanAvatarInterfaceResult> continuation) throws ZPlanAvatarServiceException {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        this.initServiceJob.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: com.tencent.filament.zplanservice.download.ZPlanAvatarService$fetchAvatarResource$$inlined$suspendCoroutine$lambda$1

            @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"com/tencent/filament/zplanservice/download/ZPlanAvatarService$fetchAvatarResource$2$1$1", "Lcom/tencent/filament/zplanservice/download/IZPlanAvatarServiceCallback;", "Lcom/tencent/filament/zplanservice/download/ZPlanAvatarInterfaceResult;", "result", "", "onSuccess", "Lcom/tencent/filament/zplanservice/download/ZPlanAvatarError;", "error", "onFail", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
            /* loaded from: classes6.dex */
            public static final class a implements IZPlanAvatarServiceCallback {
                a() {
                }

                @Override // com.tencent.filament.zplanservice.download.IZPlanAvatarServiceCallback
                public void onFail(@NotNull ZPlanAvatarError error) {
                    Intrinsics.checkNotNullParameter(error, "error");
                    FLog.INSTANCE.e("[ZPlanAvatarService]", "fetchAvatarResource fail. error:" + error);
                    Continuation continuation = Continuation.this;
                    ZPlanAvatarServiceException zPlanAvatarServiceException = new ZPlanAvatarServiceException(error);
                    Result.Companion companion = Result.INSTANCE;
                    continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(zPlanAvatarServiceException)));
                }

                @Override // com.tencent.filament.zplanservice.download.IZPlanAvatarServiceCallback
                public void onSuccess(@NotNull ZPlanAvatarInterfaceResult result) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    Continuation.this.resumeWith(Result.m476constructorimpl(result));
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                long j3;
                FLog.INSTANCE.i("[ZPlanAvatarService]", "fetchAvatarResource exec.");
                ZPlanAvatarService zPlanAvatarService = this;
                j3 = zPlanAvatarService.nativeObject;
                zPlanAvatarService.nFetchAvatarResource(j3, str, zPlanAvatarMask, z16, new a());
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    @Nullable
    public final Object z(final long j3, final int i3, @NotNull Continuation<? super ZPlanAvatarInterfaceResult> continuation) throws ZPlanAvatarServiceException {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        this.initServiceJob.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: com.tencent.filament.zplanservice.download.ZPlanAvatarService$fetchBodyAction$$inlined$suspendCoroutine$lambda$1

            @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"com/tencent/filament/zplanservice/download/ZPlanAvatarService$fetchBodyAction$2$1$1", "Lcom/tencent/filament/zplanservice/download/IZPlanAvatarServiceCallback;", "Lcom/tencent/filament/zplanservice/download/ZPlanAvatarInterfaceResult;", "result", "", "onSuccess", "Lcom/tencent/filament/zplanservice/download/ZPlanAvatarError;", "error", "onFail", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
            /* loaded from: classes6.dex */
            public static final class a implements IZPlanAvatarServiceCallback {
                a() {
                }

                @Override // com.tencent.filament.zplanservice.download.IZPlanAvatarServiceCallback
                public void onFail(@NotNull ZPlanAvatarError error) {
                    Intrinsics.checkNotNullParameter(error, "error");
                    FLog.INSTANCE.e("[ZPlanAvatarService]", "fetchBodyAction fail. actionId:" + j3 + " gender:" + i3 + " error:" + error);
                    Continuation continuation = Continuation.this;
                    ZPlanAvatarServiceException zPlanAvatarServiceException = new ZPlanAvatarServiceException(error);
                    Result.Companion companion = Result.INSTANCE;
                    continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(zPlanAvatarServiceException)));
                }

                @Override // com.tencent.filament.zplanservice.download.IZPlanAvatarServiceCallback
                public void onSuccess(@NotNull ZPlanAvatarInterfaceResult result) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    Continuation.this.resumeWith(Result.m476constructorimpl(result));
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                long j16;
                FLog.INSTANCE.i("[ZPlanAvatarService]", "fetchBodyAction exec. actionId:" + j3 + " gender:" + i3);
                ZPlanAvatarService zPlanAvatarService = this;
                j16 = zPlanAvatarService.nativeObject;
                zPlanAvatarService.nFetchBodyAction(j16, j3, i3, new a());
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }
}
