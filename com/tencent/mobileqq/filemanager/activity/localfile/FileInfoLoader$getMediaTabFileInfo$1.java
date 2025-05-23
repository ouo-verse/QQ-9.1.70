package com.tencent.mobileqq.filemanager.activity.localfile;

import android.os.SystemClock;
import com.tencent.mobileqq.filemanager.data.CostData;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.LoadParam;
import com.tencent.mobileqq.filemanager.util.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.filemanager.activity.localfile.FileInfoLoader$getMediaTabFileInfo$1", f = "FileInfoLoader.kt", i = {0, 0}, l = {76, 105}, m = "invokeSuspend", n = {"costData", "start"}, s = {"L$0", "J$0"})
/* loaded from: classes12.dex */
public final class FileInfoLoader$getMediaTabFileInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function4<HashMap<String, ArrayList<FileInfo>>, ArrayList<FileInfo>, ArrayList<FileInfo>, ArrayList<FileInfo>, Unit> $callback;
    final /* synthetic */ LoadParam $loadParams;
    long J$0;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.filemanager.activity.localfile.FileInfoLoader$getMediaTabFileInfo$1$1", f = "FileInfoLoader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.filemanager.activity.localfile.FileInfoLoader$getMediaTabFileInfo$1$1, reason: invalid class name */
    /* loaded from: classes12.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ArrayList<FileInfo> $allFileInfo;
        final /* synthetic */ Function4<HashMap<String, ArrayList<FileInfo>>, ArrayList<FileInfo>, ArrayList<FileInfo>, ArrayList<FileInfo>, Unit> $callback;
        final /* synthetic */ HashMap<String, ArrayList<FileInfo>> $mediaStoreFileInfo;
        final /* synthetic */ ArrayList<FileInfo> $sandBoxAudioInfo;
        final /* synthetic */ ArrayList<FileInfo> $sandBoxVideoFile;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Function4<? super HashMap<String, ArrayList<FileInfo>>, ? super ArrayList<FileInfo>, ? super ArrayList<FileInfo>, ? super ArrayList<FileInfo>, Unit> function4, HashMap<String, ArrayList<FileInfo>> hashMap, ArrayList<FileInfo> arrayList, ArrayList<FileInfo> arrayList2, ArrayList<FileInfo> arrayList3, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$callback = function4;
            this.$mediaStoreFileInfo = hashMap;
            this.$allFileInfo = arrayList;
            this.$sandBoxAudioInfo = arrayList2;
            this.$sandBoxVideoFile = arrayList3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.$callback, this.$mediaStoreFileInfo, this.$allFileInfo, this.$sandBoxAudioInfo, this.$sandBoxVideoFile, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.$callback.invoke(this.$mediaStoreFileInfo, this.$allFileInfo, this.$sandBoxAudioInfo, this.$sandBoxVideoFile);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FileInfoLoader$getMediaTabFileInfo$1(LoadParam loadParam, Function4<? super HashMap<String, ArrayList<FileInfo>>, ? super ArrayList<FileInfo>, ? super ArrayList<FileInfo>, ? super ArrayList<FileInfo>, Unit> function4, Continuation<? super FileInfoLoader$getMediaTabFileInfo$1> continuation) {
        super(2, continuation);
        this.$loadParams = loadParam;
        this.$callback = function4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FileInfoLoader$getMediaTabFileInfo$1 fileInfoLoader$getMediaTabFileInfo$1 = new FileInfoLoader$getMediaTabFileInfo$1(this.$loadParams, this.$callback, continuation);
        fileInfoLoader$getMediaTabFileInfo$1.L$0 = obj;
        return fileInfoLoader$getMediaTabFileInfo$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        CostData costData;
        Deferred async$default;
        Deferred async$default2;
        Deferred async$default3;
        Deferred async$default4;
        List listOf;
        Object awaitAll;
        long j3;
        HashMap u16;
        Comparator comparator;
        Comparator comparator2;
        Comparator comparator3;
        List flatten;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j3 = this.J$0;
            CostData costData2 = (CostData) this.L$0;
            ResultKt.throwOnFailure(obj);
            costData = costData2;
            awaitAll = obj;
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            costData = r15;
            CostData costData3 = new CostData(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 255, null);
            long uptimeMillis = SystemClock.uptimeMillis();
            async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new FileInfoLoader$getMediaTabFileInfo$1$jobs$1(this.$loadParams, costData, null), 3, null);
            async$default2 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new FileInfoLoader$getMediaTabFileInfo$1$jobs$2(this.$loadParams, costData, null), 3, null);
            async$default3 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new FileInfoLoader$getMediaTabFileInfo$1$jobs$3(this.$loadParams, costData, null), 3, null);
            async$default4 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new FileInfoLoader$getMediaTabFileInfo$1$jobs$4(this.$loadParams, costData, null), 3, null);
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Deferred[]{async$default, async$default2, async$default3, async$default4});
            this.L$0 = costData;
            this.J$0 = uptimeMillis;
            this.label = 1;
            awaitAll = AwaitKt.awaitAll(listOf, this);
            if (awaitAll == coroutine_suspended) {
                return coroutine_suspended;
            }
            j3 = uptimeMillis;
        }
        List list = (List) awaitAll;
        long uptimeMillis2 = SystemClock.uptimeMillis();
        u16 = FileInfoLoader.f206609a.u((HashMap) list.get(0), (HashMap) list.get(1));
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Collection values = ((HashMap) it.next()).values();
            Intrinsics.checkNotNullExpressionValue(values, "it.values");
            flatten = CollectionsKt__IterablesKt.flatten(values);
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, flatten);
        }
        comparator = FileInfoLoader.sMediaComparatorByTime;
        Collections.sort(arrayList, comparator);
        ArrayList arrayList2 = new ArrayList(arrayList);
        Map map = (Map) list.get(2);
        ArrayList arrayList3 = new ArrayList();
        Iterator it5 = map.entrySet().iterator();
        while (it5.hasNext()) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList3, (HashSet) ((Map.Entry) it5.next()).getValue());
        }
        ArrayList arrayList4 = new ArrayList(arrayList3);
        comparator2 = FileInfoLoader.sMediaComparatorByTime;
        Collections.sort(arrayList4, comparator2);
        Map map2 = (Map) list.get(3);
        ArrayList arrayList5 = new ArrayList();
        Iterator it6 = map2.entrySet().iterator();
        while (it6.hasNext()) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList5, (HashSet) ((Map.Entry) it6.next()).getValue());
        }
        comparator3 = FileInfoLoader.sMediaComparatorByTime;
        Collections.sort(arrayList5, comparator3);
        ArrayList arrayList6 = new ArrayList(arrayList5);
        costData.i(SystemClock.uptimeMillis() - uptimeMillis2);
        costData.p(SystemClock.uptimeMillis() - j3);
        p.c(costData.getSystemAudioCost(), costData.getSystemVideoCost(), costData.getSandBoxAudioCost(), costData.getSandBoxVideoCost(), costData.getTotalCost(), costData.getGroupCost(), true);
        MainCoroutineDispatcher main = Dispatchers.getMain();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$callback, u16, arrayList2, arrayList4, arrayList6, null);
        this.L$0 = null;
        this.label = 2;
        if (BuildersKt.withContext(main, anonymousClass1, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FileInfoLoader$getMediaTabFileInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
