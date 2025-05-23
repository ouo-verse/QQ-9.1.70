package com.tencent.mobileqq.wink.preprocess;

import android.os.SystemClock;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEMultiDownloadCallBack;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.wink.WinkCoroutineScopes;
import com.tencent.mobileqq.wink.dailysign.DailyDataSource;
import com.tencent.mobileqq.wink.dailysign.DailySignConfig;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.editor.export.WinkExportUtils;
import com.tencent.mobileqq.wink.launcher.network.WinkRecommendDataServiceHandler;
import com.tencent.mobileqq.wink.listener.ResDownLoadListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b0\u00101J\u001b\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005J?\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\"\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n`\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fJ0\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\u00102\"\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n`\u000bJ\u0013\u0010\u0012\u001a\u00020\rH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013J1\u0010\u0017\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u000e\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\tJ9\u0010 \u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\t2\u0012\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\u001cH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b \u0010!J \u0010%\u001a\u00020\r2\b\b\u0002\u0010\"\u001a\u00020\n2\u000e\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0#J\u001f\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160&H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b'\u0010\u0013R\u001b\u0010,\u001a\u00020(8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010)\u001a\u0004\b*\u0010+R\u0014\u0010/\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010.\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/wink/preprocess/WinkMaterialResourceLoader;", "", "Lcom/tencent/mobileqq/wink/dailysign/DailySignConfig;", "dailySignConfig", tl.h.F, "(Lcom/tencent/mobileqq/wink/dailysign/DailySignConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "costMap", "", "i", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;Ljava/util/HashMap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/Deferred;", "g", "f", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mate", "Lkotlin/Triple;", "", "b", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "serviceId", "j", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, "Landroidx/lifecycle/MutableLiveData;", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "materialLiveData", "d", "(Ljava/lang/String;Ljava/lang/String;Landroidx/lifecycle/MutableLiveData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "time", "Lkotlin/Function0;", "callback", "l", "Lkotlin/Pair;", "e", "Lcom/tencent/mobileqq/wink/dailysign/DailyDataSource;", "Lkotlin/Lazy;", "c", "()Lcom/tencent/mobileqq/wink/dailysign/DailyDataSource;", "dailySignDataSource", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/CoroutineScope;", "mainScope", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkMaterialResourceLoader {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final WinkMaterialResourceLoader f325333a = new WinkMaterialResourceLoader();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy dailySignDataSource;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final CoroutineScope mainScope;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/preprocess/WinkMaterialResourceLoader$a", "Lcom/tencent/mobileqq/wink/listener/ResDownLoadListener;", "", "isSuccess", "", "onDownloadFinish", "", "progress", "onProgressUpdate", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements ResDownLoadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<Triple<MetaMaterial, Boolean, Boolean>> f325336a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ MetaMaterial f325337b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Ref.BooleanRef f325338c;

        /* JADX WARN: Multi-variable type inference failed */
        a(Continuation<? super Triple<MetaMaterial, Boolean, Boolean>> continuation, MetaMaterial metaMaterial, Ref.BooleanRef booleanRef) {
            this.f325336a = continuation;
            this.f325337b = metaMaterial;
            this.f325338c = booleanRef;
        }

        @Override // com.tencent.mobileqq.wink.listener.ResDownLoadListener
        public void onDownloadFinish(boolean isSuccess) {
            w53.b.a("WinkMaterialResourceLoader", "downloadMaterial: isSuccess " + isSuccess);
            if (isSuccess) {
                Continuation<Triple<MetaMaterial, Boolean, Boolean>> continuation = this.f325336a;
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m476constructorimpl(new Triple(this.f325337b, Boolean.valueOf(this.f325338c.element), Boolean.TRUE)));
            } else {
                Continuation<Triple<MetaMaterial, Boolean, Boolean>> continuation2 = this.f325336a;
                Result.Companion companion2 = Result.INSTANCE;
                Boolean bool = Boolean.FALSE;
                continuation2.resumeWith(Result.m476constructorimpl(new Triple(null, bool, bool)));
            }
        }

        @Override // com.tencent.mobileqq.wink.listener.ResDownLoadListener
        public void onProgressUpdate(int progress) {
            w53.b.a("WinkMaterialResourceLoader", "downloadMaterial: " + progress);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/wink/preprocess/WinkMaterialResourceLoader$b", "Lcom/tencent/aelight/camera/download/api/IAEMultiDownloadCallBack;", "Lcom/tencent/aelight/camera/download/api/AEResInfo;", "aeResInfo", "", "downloaded", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "", "onAEMultiDownloadFinish", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements IAEMultiDownloadCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<Pair<Boolean, Boolean>> f325339a;

        /* JADX WARN: Multi-variable type inference failed */
        b(Continuation<? super Pair<Boolean, Boolean>> continuation) {
            this.f325339a = continuation;
        }

        @Override // com.tencent.aelight.camera.download.api.IAEMultiDownloadCallBack
        public void onAEMultiDownloadFinish(@Nullable AEResInfo aeResInfo, boolean downloaded, int errorType) {
            String str;
            if (aeResInfo != null) {
                str = aeResInfo.agentType;
            } else {
                str = null;
            }
            w53.b.a("WinkMaterialResourceLoader", "onAEMultiDownloadFinish aeResInfo = " + str + " downloaded = " + downloaded + ", error = " + errorType);
            Continuation<Pair<Boolean, Boolean>> continuation = this.f325339a;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(new Pair(Boolean.valueOf(downloaded), Boolean.TRUE)));
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<DailyDataSource>() { // from class: com.tencent.mobileqq.wink.preprocess.WinkMaterialResourceLoader$dailySignDataSource$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final DailyDataSource invoke() {
                return DailyDataSource.f318060a;
            }
        });
        dailySignDataSource = lazy;
        mainScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain()));
    }

    WinkMaterialResourceLoader() {
    }

    private final DailyDataSource c() {
        return (DailyDataSource) dailySignDataSource.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(String serviceId) {
        Intrinsics.checkNotNullParameter(serviceId, "$serviceId");
        BusinessHandler businessHandler = com.tencent.mobileqq.wink.b.a().getBusinessHandler(WinkRecommendDataServiceHandler.class.getName());
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.wink.launcher.network.WinkRecommendDataServiceHandler");
        ((WinkRecommendDataServiceHandler) businessHandler).m3(serviceId);
    }

    public static /* synthetic */ void m(WinkMaterialResourceLoader winkMaterialResourceLoader, long j3, Function0 function0, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = 500;
        }
        winkMaterialResourceLoader.l(j3, function0);
    }

    @Nullable
    public final Object b(@Nullable MetaMaterial metaMaterial, @NotNull Continuation<? super Triple<MetaMaterial, Boolean, Boolean>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        if (metaMaterial == null) {
            Result.Companion companion = Result.INSTANCE;
            safeContinuation.resumeWith(Result.m476constructorimpl(new Triple(null, Boxing.boxBoolean(false), Boxing.boxBoolean(false))));
        } else {
            Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            booleanRef.element = true;
            if (WinkEditorResourceManager.a1().q(metaMaterial)) {
                booleanRef.element = false;
            }
            WinkEditorResourceManager.a1().f0(metaMaterial, new a(safeContinuation, metaMaterial, booleanRef));
        }
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    @Nullable
    public final Object d(@NotNull String str, @NotNull final String str2, @NotNull MutableLiveData<List<MetaCategory>> mutableLiveData, @NotNull Continuation<? super MetaMaterial> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        WinkEditorResourceManager.a1().p3();
        final Ref.IntRef intRef = new Ref.IntRef();
        mutableLiveData.observeForever(new Observer<List<? extends MetaCategory>>() { // from class: com.tencent.mobileqq.wink.preprocess.WinkMaterialResourceLoader$getMaterialFromResource$2$1
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r3v3 */
            /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Object] */
            @Override // androidx.lifecycle.Observer
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onChanged(@NotNull List<MetaCategory> metaCategories) {
                T t16;
                boolean z16;
                Intrinsics.checkNotNullParameter(metaCategories, "metaCategories");
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                String str3 = str2;
                Iterator<T> it = metaCategories.iterator();
                while (it.hasNext()) {
                    ArrayList<MetaMaterial> arrayList = ((MetaCategory) it.next()).materials;
                    Intrinsics.checkNotNullExpressionValue(arrayList, "category.materials");
                    Iterator<T> it5 = arrayList.iterator();
                    while (true) {
                        if (it5.hasNext()) {
                            t16 = it5.next();
                            if (Intrinsics.areEqual(((MetaMaterial) t16).f30533id, str3)) {
                                break;
                            }
                        } else {
                            t16 = 0;
                            break;
                        }
                    }
                    objectRef.element = t16;
                    if (t16 != 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        break;
                    }
                }
                T t17 = objectRef.element;
                if (t17 == 0) {
                    final Ref.IntRef intRef2 = Ref.IntRef.this;
                    if (intRef2.element < 5) {
                        WinkMaterialResourceLoader.m(WinkMaterialResourceLoader.f325333a, 0L, new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.preprocess.WinkMaterialResourceLoader$getMaterialFromResource$2$1$onChanged$2
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                WinkEditorResourceManager.a1().p3();
                                Ref.IntRef.this.element++;
                            }
                        }, 1, null);
                        return;
                    }
                }
                safeContinuation.resumeWith(Result.m476constructorimpl(t17));
                WinkEditorResourceManager.a1().h2().removeObserver(this);
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
    public final Object e(@NotNull Continuation<? super Pair<Boolean, Boolean>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        if (((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).isCameraResReady(new b(safeContinuation))) {
            Result.Companion companion = Result.INSTANCE;
            safeContinuation.resumeWith(Result.m476constructorimpl(new Pair(Boxing.boxBoolean(true), Boxing.boxBoolean(false))));
        }
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    @Nullable
    public final Object f(@NotNull Continuation<? super Unit> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        Object coroutine_suspended2;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        w53.b.a("DailySignDataSource", "loadLightAssets");
        WinkExportUtils.R();
        Result.Companion companion = Result.INSTANCE;
        Unit unit = Unit.INSTANCE;
        safeContinuation.resumeWith(Result.m476constructorimpl(unit));
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended2) {
            return orThrow;
        }
        return unit;
    }

    @NotNull
    public final Deferred<Unit> g(@NotNull HashMap<String, Long> costMap) {
        Deferred<Unit> async$default;
        Intrinsics.checkNotNullParameter(costMap, "costMap");
        async$default = BuildersKt__Builders_commonKt.async$default(mainScope, WinkCoroutineScopes.f317652a.b(), null, new WinkMaterialResourceLoader$loadLightResAsync$loadLightDeferred$1(costMap, null), 2, null);
        return async$default;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0101 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00f3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00cc A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object h(@NotNull DailySignConfig dailySignConfig, @NotNull Continuation<? super DailySignConfig> continuation) {
        WinkMaterialResourceLoader$prepareDailySignMaterial$1 winkMaterialResourceLoader$prepareDailySignMaterial$1;
        Object coroutine_suspended;
        int i3;
        WinkMaterialResourceLoader winkMaterialResourceLoader;
        Deferred deferred;
        Object e16;
        DailySignConfig dailySignConfig2;
        Deferred deferred2;
        Deferred deferred3;
        Deferred deferred4;
        DailySignConfig dailySignConfig3;
        DailySignConfig dailySignConfig4;
        DailySignConfig dailySignConfig5;
        if (continuation instanceof WinkMaterialResourceLoader$prepareDailySignMaterial$1) {
            winkMaterialResourceLoader$prepareDailySignMaterial$1 = (WinkMaterialResourceLoader$prepareDailySignMaterial$1) continuation;
            int i16 = winkMaterialResourceLoader$prepareDailySignMaterial$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                winkMaterialResourceLoader$prepareDailySignMaterial$1.label = i16 - Integer.MIN_VALUE;
                Object obj = winkMaterialResourceLoader$prepareDailySignMaterial$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = winkMaterialResourceLoader$prepareDailySignMaterial$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 != 3) {
                                if (i3 != 4) {
                                    if (i3 == 5) {
                                        dailySignConfig5 = (DailySignConfig) winkMaterialResourceLoader$prepareDailySignMaterial$1.L$0;
                                        ResultKt.throwOnFailure(obj);
                                        dailySignConfig5.setInited(true);
                                        dailySignConfig5.setLoadAllResourceTime(SystemClock.elapsedRealtime() - dailySignConfig5.getStartTime());
                                        return dailySignConfig5;
                                    }
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                deferred4 = (Deferred) winkMaterialResourceLoader$prepareDailySignMaterial$1.L$1;
                                dailySignConfig4 = (DailySignConfig) winkMaterialResourceLoader$prepareDailySignMaterial$1.L$0;
                                ResultKt.throwOnFailure(obj);
                                winkMaterialResourceLoader$prepareDailySignMaterial$1.L$0 = dailySignConfig4;
                                winkMaterialResourceLoader$prepareDailySignMaterial$1.L$1 = null;
                                winkMaterialResourceLoader$prepareDailySignMaterial$1.label = 5;
                                if (deferred4.await(winkMaterialResourceLoader$prepareDailySignMaterial$1) != coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                dailySignConfig5 = dailySignConfig4;
                                dailySignConfig5.setInited(true);
                                dailySignConfig5.setLoadAllResourceTime(SystemClock.elapsedRealtime() - dailySignConfig5.getStartTime());
                                return dailySignConfig5;
                            }
                            deferred4 = (Deferred) winkMaterialResourceLoader$prepareDailySignMaterial$1.L$2;
                            deferred3 = (Deferred) winkMaterialResourceLoader$prepareDailySignMaterial$1.L$1;
                            dailySignConfig3 = (DailySignConfig) winkMaterialResourceLoader$prepareDailySignMaterial$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            winkMaterialResourceLoader$prepareDailySignMaterial$1.L$0 = dailySignConfig3;
                            winkMaterialResourceLoader$prepareDailySignMaterial$1.L$1 = deferred4;
                            winkMaterialResourceLoader$prepareDailySignMaterial$1.L$2 = null;
                            winkMaterialResourceLoader$prepareDailySignMaterial$1.label = 4;
                            if (deferred3.await(winkMaterialResourceLoader$prepareDailySignMaterial$1) != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            dailySignConfig4 = dailySignConfig3;
                            winkMaterialResourceLoader$prepareDailySignMaterial$1.L$0 = dailySignConfig4;
                            winkMaterialResourceLoader$prepareDailySignMaterial$1.L$1 = null;
                            winkMaterialResourceLoader$prepareDailySignMaterial$1.label = 5;
                            if (deferred4.await(winkMaterialResourceLoader$prepareDailySignMaterial$1) != coroutine_suspended) {
                            }
                        } else {
                            deferred2 = (Deferred) winkMaterialResourceLoader$prepareDailySignMaterial$1.L$2;
                            deferred = (Deferred) winkMaterialResourceLoader$prepareDailySignMaterial$1.L$1;
                            dailySignConfig2 = (DailySignConfig) winkMaterialResourceLoader$prepareDailySignMaterial$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            Deferred deferred5 = (Deferred) obj;
                            winkMaterialResourceLoader$prepareDailySignMaterial$1.L$0 = dailySignConfig2;
                            winkMaterialResourceLoader$prepareDailySignMaterial$1.L$1 = deferred2;
                            winkMaterialResourceLoader$prepareDailySignMaterial$1.L$2 = deferred5;
                            winkMaterialResourceLoader$prepareDailySignMaterial$1.label = 3;
                            if (deferred.await(winkMaterialResourceLoader$prepareDailySignMaterial$1) != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            deferred3 = deferred2;
                            deferred4 = deferred5;
                            dailySignConfig3 = dailySignConfig2;
                            winkMaterialResourceLoader$prepareDailySignMaterial$1.L$0 = dailySignConfig3;
                            winkMaterialResourceLoader$prepareDailySignMaterial$1.L$1 = deferred4;
                            winkMaterialResourceLoader$prepareDailySignMaterial$1.L$2 = null;
                            winkMaterialResourceLoader$prepareDailySignMaterial$1.label = 4;
                            if (deferred3.await(winkMaterialResourceLoader$prepareDailySignMaterial$1) != coroutine_suspended) {
                            }
                        }
                    } else {
                        Deferred deferred6 = (Deferred) winkMaterialResourceLoader$prepareDailySignMaterial$1.L$2;
                        DailySignConfig dailySignConfig6 = (DailySignConfig) winkMaterialResourceLoader$prepareDailySignMaterial$1.L$1;
                        winkMaterialResourceLoader = (WinkMaterialResourceLoader) winkMaterialResourceLoader$prepareDailySignMaterial$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        deferred = deferred6;
                        dailySignConfig = dailySignConfig6;
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    dailySignConfig.setStartTime(SystemClock.elapsedRealtime());
                    j("wordpicture");
                    Deferred<Unit> g16 = g(dailySignConfig.getCostMap());
                    DailyDataSource c16 = c();
                    CoroutineScope coroutineScope = mainScope;
                    winkMaterialResourceLoader$prepareDailySignMaterial$1.L$0 = this;
                    winkMaterialResourceLoader$prepareDailySignMaterial$1.L$1 = dailySignConfig;
                    winkMaterialResourceLoader$prepareDailySignMaterial$1.L$2 = g16;
                    winkMaterialResourceLoader$prepareDailySignMaterial$1.label = 1;
                    Object d16 = c16.d(coroutineScope, dailySignConfig, winkMaterialResourceLoader$prepareDailySignMaterial$1);
                    if (d16 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    winkMaterialResourceLoader = this;
                    deferred = g16;
                    obj = d16;
                }
                Deferred deferred7 = (Deferred) obj;
                DailyDataSource c17 = winkMaterialResourceLoader.c();
                CoroutineScope coroutineScope2 = mainScope;
                winkMaterialResourceLoader$prepareDailySignMaterial$1.L$0 = dailySignConfig;
                winkMaterialResourceLoader$prepareDailySignMaterial$1.L$1 = deferred;
                winkMaterialResourceLoader$prepareDailySignMaterial$1.L$2 = deferred7;
                winkMaterialResourceLoader$prepareDailySignMaterial$1.label = 2;
                e16 = c17.e(coroutineScope2, dailySignConfig, winkMaterialResourceLoader$prepareDailySignMaterial$1);
                if (e16 != coroutine_suspended) {
                    return coroutine_suspended;
                }
                dailySignConfig2 = dailySignConfig;
                deferred2 = deferred7;
                obj = e16;
                Deferred deferred52 = (Deferred) obj;
                winkMaterialResourceLoader$prepareDailySignMaterial$1.L$0 = dailySignConfig2;
                winkMaterialResourceLoader$prepareDailySignMaterial$1.L$1 = deferred2;
                winkMaterialResourceLoader$prepareDailySignMaterial$1.L$2 = deferred52;
                winkMaterialResourceLoader$prepareDailySignMaterial$1.label = 3;
                if (deferred.await(winkMaterialResourceLoader$prepareDailySignMaterial$1) != coroutine_suspended) {
                }
            }
        }
        winkMaterialResourceLoader$prepareDailySignMaterial$1 = new WinkMaterialResourceLoader$prepareDailySignMaterial$1(this, continuation);
        Object obj2 = winkMaterialResourceLoader$prepareDailySignMaterial$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = winkMaterialResourceLoader$prepareDailySignMaterial$1.label;
        if (i3 == 0) {
        }
        Deferred deferred72 = (Deferred) obj2;
        DailyDataSource c172 = winkMaterialResourceLoader.c();
        CoroutineScope coroutineScope22 = mainScope;
        winkMaterialResourceLoader$prepareDailySignMaterial$1.L$0 = dailySignConfig;
        winkMaterialResourceLoader$prepareDailySignMaterial$1.L$1 = deferred;
        winkMaterialResourceLoader$prepareDailySignMaterial$1.L$2 = deferred72;
        winkMaterialResourceLoader$prepareDailySignMaterial$1.label = 2;
        e16 = c172.e(coroutineScope22, dailySignConfig, winkMaterialResourceLoader$prepareDailySignMaterial$1);
        if (e16 != coroutine_suspended) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0069 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object i(@NotNull MetaMaterial metaMaterial, @NotNull HashMap<String, Long> hashMap, @NotNull Continuation<? super Unit> continuation) {
        WinkMaterialResourceLoader$prepareResourceAndMaterial$1 winkMaterialResourceLoader$prepareResourceAndMaterial$1;
        Object coroutine_suspended;
        int i3;
        Deferred async$default;
        if (continuation instanceof WinkMaterialResourceLoader$prepareResourceAndMaterial$1) {
            winkMaterialResourceLoader$prepareResourceAndMaterial$1 = (WinkMaterialResourceLoader$prepareResourceAndMaterial$1) continuation;
            int i16 = winkMaterialResourceLoader$prepareResourceAndMaterial$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                winkMaterialResourceLoader$prepareResourceAndMaterial$1.label = i16 - Integer.MIN_VALUE;
                Object obj = winkMaterialResourceLoader$prepareResourceAndMaterial$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = winkMaterialResourceLoader$prepareResourceAndMaterial$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    async$default = (Deferred) winkMaterialResourceLoader$prepareResourceAndMaterial$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    ResultKt.throwOnFailure(obj);
                    Deferred<Unit> g16 = g(hashMap);
                    async$default = BuildersKt__Builders_commonKt.async$default(mainScope, null, null, new WinkMaterialResourceLoader$prepareResourceAndMaterial$downloadTemplateDeferred$1(metaMaterial, hashMap, null), 3, null);
                    winkMaterialResourceLoader$prepareResourceAndMaterial$1.L$0 = async$default;
                    winkMaterialResourceLoader$prepareResourceAndMaterial$1.label = 1;
                    if (g16.await(winkMaterialResourceLoader$prepareResourceAndMaterial$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                winkMaterialResourceLoader$prepareResourceAndMaterial$1.L$0 = null;
                winkMaterialResourceLoader$prepareResourceAndMaterial$1.label = 2;
                if (async$default.await(winkMaterialResourceLoader$prepareResourceAndMaterial$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        }
        winkMaterialResourceLoader$prepareResourceAndMaterial$1 = new WinkMaterialResourceLoader$prepareResourceAndMaterial$1(this, continuation);
        Object obj2 = winkMaterialResourceLoader$prepareResourceAndMaterial$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = winkMaterialResourceLoader$prepareResourceAndMaterial$1.label;
        if (i3 == 0) {
        }
        winkMaterialResourceLoader$prepareResourceAndMaterial$1.L$0 = null;
        winkMaterialResourceLoader$prepareResourceAndMaterial$1.label = 2;
        if (async$default.await(winkMaterialResourceLoader$prepareResourceAndMaterial$1) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }

    public final void j(@NotNull final String serviceId) {
        Intrinsics.checkNotNullParameter(serviceId, "serviceId");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.preprocess.c
            @Override // java.lang.Runnable
            public final void run() {
                WinkMaterialResourceLoader.k(serviceId);
            }
        }, 128, null, false);
    }

    public final void l(long time, @NotNull Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new WinkMaterialResourceLoader$retry$1(time, callback, null), 2, null);
    }
}
