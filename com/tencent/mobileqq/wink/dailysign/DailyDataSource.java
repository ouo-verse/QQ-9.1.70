package com.tencent.mobileqq.wink.dailysign;

import android.os.SystemClock;
import androidx.lifecycle.Observer;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.preprocess.WinkMaterialResourceLoader;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.random.RandomKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b%\u0010&J/\u0010\u0007\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\bJ\"\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J+\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016J)\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0016J;\u0010\u001d\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\r\u0012\u0004\u0012\u00020\u00190\u001b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\u0006\u0010\u001a\u001a\u00020\u0019H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001d\u0010\u001eR\u001b\u0010$\u001a\u00020\u001f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/wink/dailysign/DailyDataSource;", "", "Lcom/tencent/mobileqq/wink/dailysign/DailySignConfig;", "dailySignConfig", "Lkotlin/Triple;", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "", "g", "(Lcom/tencent/mobileqq/wink/dailysign/DailySignConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "i", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "j", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "data", tl.h.F, "Lkotlinx/coroutines/CoroutineScope;", "mainScope", "Lkotlinx/coroutines/Deferred;", "", "d", "(Lkotlinx/coroutines/CoroutineScope;Lcom/tencent/mobileqq/wink/dailysign/DailySignConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "e", "list", "", "lastRandomIndex", "Lkotlin/Pair;", "", "f", "(Ljava/util/List;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/transfile/api/IHttpEngineService;", "b", "Lkotlin/Lazy;", "getNetEngine", "()Lcom/tencent/mobileqq/transfile/api/IHttpEngineService;", "netEngine", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class DailyDataSource {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final DailyDataSource f318060a = new DailyDataSource();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy netEngine;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<IHttpEngineService>() { // from class: com.tencent.mobileqq.wink.dailysign.DailyDataSource$netEngine$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final IHttpEngineService invoke() {
                IRuntimeService runtimeService = com.tencent.mobileqq.wink.b.a().getRuntimeService(IHttpEngineService.class, "all");
                Intrinsics.checkNotNullExpressionValue(runtimeService, "getAppInterface().getRun\u2026ava, ProcessConstant.ALL)");
                return (IHttpEngineService) runtimeService;
            }
        });
        netEngine = lazy;
    }

    DailyDataSource() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0052 A[PHI: r7
  0x0052: PHI (r7v6 java.lang.Object) = (r7v5 java.lang.Object), (r7v1 java.lang.Object) binds: [B:17:0x004f, B:10:0x0028] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0051 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object g(DailySignConfig dailySignConfig, Continuation<? super Triple<MetaMaterial, Boolean, Boolean>> continuation) {
        DailyDataSource$findAndDownloadMaterial$1 dailyDataSource$findAndDownloadMaterial$1;
        Object obj;
        Object coroutine_suspended;
        int i3;
        if (continuation instanceof DailyDataSource$findAndDownloadMaterial$1) {
            dailyDataSource$findAndDownloadMaterial$1 = (DailyDataSource$findAndDownloadMaterial$1) continuation;
            int i16 = dailyDataSource$findAndDownloadMaterial$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                dailyDataSource$findAndDownloadMaterial$1.label = i16 - Integer.MIN_VALUE;
                obj = dailyDataSource$findAndDownloadMaterial$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = dailyDataSource$findAndDownloadMaterial$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            ResultKt.throwOnFailure(obj);
                            return obj;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                } else {
                    ResultKt.throwOnFailure(obj);
                    dailyDataSource$findAndDownloadMaterial$1.label = 1;
                    obj = j(dailySignConfig, dailyDataSource$findAndDownloadMaterial$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                WinkMaterialResourceLoader winkMaterialResourceLoader = WinkMaterialResourceLoader.f325333a;
                dailyDataSource$findAndDownloadMaterial$1.label = 2;
                obj = winkMaterialResourceLoader.b((MetaMaterial) obj, dailyDataSource$findAndDownloadMaterial$1);
                if (obj != coroutine_suspended) {
                    return coroutine_suspended;
                }
                return obj;
            }
        }
        dailyDataSource$findAndDownloadMaterial$1 = new DailyDataSource$findAndDownloadMaterial$1(this, continuation);
        obj = dailyDataSource$findAndDownloadMaterial$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = dailyDataSource$findAndDownloadMaterial$1.label;
        if (i3 == 0) {
        }
        WinkMaterialResourceLoader winkMaterialResourceLoader2 = WinkMaterialResourceLoader.f325333a;
        dailyDataSource$findAndDownloadMaterial$1.label = 2;
        obj = winkMaterialResourceLoader2.b((MetaMaterial) obj, dailyDataSource$findAndDownloadMaterial$1);
        if (obj != coroutine_suspended) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MetaMaterial h(List<MetaCategory> data, DailySignConfig dailySignConfig) {
        boolean z16;
        Object orNull;
        ArrayList<MetaMaterial> materials;
        Object orNull2;
        Object orNull3;
        Object orNull4;
        List<MetaCategory> list = data;
        boolean z17 = true;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && Intrinsics.areEqual("muban", data.get(0).f30532id)) {
            ArrayList<MetaCategory> arrayList = data.get(0).subCategories;
            Intrinsics.checkNotNullExpressionValue(arrayList, "data[0].subCategories");
            orNull = CollectionsKt___CollectionsKt.getOrNull(arrayList, 0);
            MetaCategory metaCategory = (MetaCategory) orNull;
            if (metaCategory == null || (materials = metaCategory.materials) == null) {
                materials = data.get(0).materials;
            }
            if (materials != null && !materials.isEmpty()) {
                z17 = false;
            }
            if (z17) {
                return null;
            }
            Intrinsics.checkNotNullExpressionValue(materials, "materials");
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : materials) {
                MetaMaterial it = (MetaMaterial) obj;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (Intrinsics.areEqual(com.tencent.mobileqq.wink.editor.sticker.m.J(it), dailySignConfig.getTemplateType().getFirst())) {
                    arrayList2.add(obj);
                }
            }
            if (arrayList2.isEmpty()) {
                orNull4 = CollectionsKt___CollectionsKt.getOrNull(materials, 0);
                return (MetaMaterial) orNull4;
            }
            orNull2 = CollectionsKt___CollectionsKt.getOrNull(arrayList2, com.tencent.av.doodle.e.f73628c.nextInt(arrayList2.size()));
            MetaMaterial metaMaterial = (MetaMaterial) orNull2;
            if (metaMaterial == null) {
                orNull3 = CollectionsKt___CollectionsKt.getOrNull(materials, 0);
                return (MetaMaterial) orNull3;
            }
            return metaMaterial;
        }
        w53.b.a("DailySignDataSource", "no match or null");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object i(Continuation<? super List<MetaMaterial>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        final ArrayList arrayList = new ArrayList();
        final Ref.IntRef intRef = new Ref.IntRef();
        Observer<List<? extends MetaCategory>> observer = new Observer<List<? extends MetaCategory>>() { // from class: com.tencent.mobileqq.wink.dailysign.DailyDataSource$getAllBackgroundPic$2$observer$1
            @Override // androidx.lifecycle.Observer
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onChanged(@Nullable List<MetaCategory> metaCategories) {
                boolean z16;
                List<MetaCategory> list = metaCategories;
                if (list != null && !list.isEmpty()) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    w53.b.a("DailySignDataSource", "Paths size " + metaCategories.size());
                    for (MetaCategory metaCategory : metaCategories) {
                        List<MetaMaterial> list2 = arrayList;
                        ArrayList<MetaMaterial> arrayList2 = metaCategory.materials;
                        Intrinsics.checkNotNullExpressionValue(arrayList2, "category.materials");
                        list2.addAll(arrayList2);
                    }
                } else {
                    final Ref.IntRef intRef2 = intRef;
                    if (intRef2.element < 5) {
                        WinkMaterialResourceLoader.m(WinkMaterialResourceLoader.f325333a, 0L, new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.dailysign.DailyDataSource$getAllBackgroundPic$2$observer$1$onChanged$1
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
                                WinkEditorResourceManager.a1().Q2("background");
                                Ref.IntRef.this.element++;
                            }
                        }, 1, null);
                        return;
                    }
                }
                WinkEditorResourceManager.a1().G0().removeObserver(this);
                Continuation<List<MetaMaterial>> continuation2 = safeContinuation;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m476constructorimpl(arrayList));
            }
        };
        WinkEditorResourceManager.a1().Q2("background");
        WinkEditorResourceManager.a1().G0().observeForever(observer);
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    private final Object j(final DailySignConfig dailySignConfig, Continuation<? super MetaMaterial> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        final Ref.IntRef intRef = new Ref.IntRef();
        Observer<List<? extends MetaCategory>> observer = new Observer<List<? extends MetaCategory>>() { // from class: com.tencent.mobileqq.wink.dailysign.DailyDataSource$getDailySignMaterial$2$observer$1
            @Override // androidx.lifecycle.Observer
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onChanged(@Nullable List<MetaCategory> t16) {
                MetaMaterial h16;
                h16 = DailyDataSource.f318060a.h(t16, DailySignConfig.this);
                if (h16 == null) {
                    final Ref.IntRef intRef2 = intRef;
                    if (intRef2.element < 5) {
                        WinkMaterialResourceLoader.m(WinkMaterialResourceLoader.f325333a, 0L, new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.dailysign.DailyDataSource$getDailySignMaterial$2$observer$1$onChanged$1
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
                                WinkEditorResourceManager.a1().X2("muban");
                                Ref.IntRef.this.element++;
                            }
                        }, 1, null);
                        return;
                    }
                }
                safeContinuation.resumeWith(Result.m476constructorimpl(h16));
                WinkEditorResourceManager.a1().e1().removeObserver(this);
            }
        };
        WinkEditorResourceManager.a1().X2("muban");
        WinkEditorResourceManager.a1().e1().observeForever(observer);
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    @Nullable
    public Object d(@NotNull CoroutineScope coroutineScope, @Nullable DailySignConfig dailySignConfig, @NotNull Continuation<? super Deferred<Unit>> continuation) {
        Deferred async$default;
        async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new DailyDataSource$downDailySignLoadRandomPicAsync$picDeferred$1(dailySignConfig, null), 3, null);
        return async$default;
    }

    @Nullable
    public Object e(@NotNull CoroutineScope coroutineScope, @NotNull DailySignConfig dailySignConfig, @NotNull Continuation<? super Deferred<Unit>> continuation) {
        Deferred async$default;
        async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new DailyDataSource$downloadDailySignTemplateAsync$mateDeferred$1(dailySignConfig, null), 3, null);
        return async$default;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0091 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object f(@NotNull List<MetaMaterial> list, int i3, @NotNull Continuation<? super Pair<? extends List<String>, Integer>> continuation) {
        DailyDataSource$downloadRandomPic$1 dailyDataSource$downloadRandomPic$1;
        Object coroutine_suspended;
        int i16;
        int nextInt;
        Object b16;
        int i17;
        File file;
        ArrayList arrayList;
        int collectionSizeOrDefault;
        if (continuation instanceof DailyDataSource$downloadRandomPic$1) {
            dailyDataSource$downloadRandomPic$1 = (DailyDataSource$downloadRandomPic$1) continuation;
            int i18 = dailyDataSource$downloadRandomPic$1.label;
            if ((i18 & Integer.MIN_VALUE) != 0) {
                dailyDataSource$downloadRandomPic$1.label = i18 - Integer.MIN_VALUE;
                Object obj = dailyDataSource$downloadRandomPic$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i16 = dailyDataSource$downloadRandomPic$1.label;
                if (i16 == 0) {
                    if (i16 == 1) {
                        i17 = dailyDataSource$downloadRandomPic$1.I$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    if (list.size() == 1) {
                        nextInt = 0;
                        w53.b.a("DailySignDataSource", "finalRandomIndex = " + nextInt);
                        MetaMaterial metaMaterial = list.get(nextInt);
                        WinkMaterialResourceLoader winkMaterialResourceLoader = WinkMaterialResourceLoader.f325333a;
                        dailyDataSource$downloadRandomPic$1.I$0 = nextInt;
                        dailyDataSource$downloadRandomPic$1.label = 1;
                        b16 = winkMaterialResourceLoader.b(metaMaterial, dailyDataSource$downloadRandomPic$1);
                        if (b16 != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        int i19 = nextInt;
                        obj = b16;
                        i17 = i19;
                    }
                    do {
                        nextInt = RandomKt.Random(SystemClock.elapsedRealtime()).nextInt(0, list.size());
                        w53.b.a("DailySignDataSource", "random = " + nextInt);
                    } while (nextInt == i3);
                    w53.b.a("DailySignDataSource", "finalRandomIndex = " + nextInt);
                    MetaMaterial metaMaterial2 = list.get(nextInt);
                    WinkMaterialResourceLoader winkMaterialResourceLoader2 = WinkMaterialResourceLoader.f325333a;
                    dailyDataSource$downloadRandomPic$1.I$0 = nextInt;
                    dailyDataSource$downloadRandomPic$1.label = 1;
                    b16 = winkMaterialResourceLoader2.b(metaMaterial2, dailyDataSource$downloadRandomPic$1);
                    if (b16 != coroutine_suspended) {
                    }
                }
                file = new File(WinkEditorResourceManager.a1().m((MetaMaterial) ((Triple) obj).getFirst()));
                if (!file.exists() && file.isDirectory()) {
                    File[] listFiles = file.listFiles();
                    if (listFiles != null) {
                        ArrayList arrayList2 = new ArrayList();
                        for (File file2 : listFiles) {
                            if (file2.isFile()) {
                                arrayList2.add(file2);
                            }
                        }
                        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
                        arrayList = new ArrayList(collectionSizeOrDefault);
                        Iterator it = arrayList2.iterator();
                        while (it.hasNext()) {
                            arrayList.add(((File) it.next()).getPath());
                        }
                    } else {
                        arrayList = new ArrayList();
                    }
                } else {
                    arrayList = new ArrayList();
                }
                return TuplesKt.to(arrayList, Boxing.boxInt(i17));
            }
        }
        dailyDataSource$downloadRandomPic$1 = new DailyDataSource$downloadRandomPic$1(this, continuation);
        Object obj2 = dailyDataSource$downloadRandomPic$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i16 = dailyDataSource$downloadRandomPic$1.label;
        if (i16 == 0) {
        }
        file = new File(WinkEditorResourceManager.a1().m((MetaMaterial) ((Triple) obj2).getFirst()));
        if (!file.exists()) {
        }
        arrayList = new ArrayList();
        return TuplesKt.to(arrayList, Boxing.boxInt(i17));
    }
}
