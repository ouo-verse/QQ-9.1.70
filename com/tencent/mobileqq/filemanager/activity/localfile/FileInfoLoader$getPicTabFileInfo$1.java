package com.tencent.mobileqq.filemanager.activity.localfile;

import android.os.SystemClock;
import com.tencent.biz.qqcircle.immersive.constants.QFSNumberConstants;
import com.tencent.mobileqq.filemanager.data.CostData;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.LoadParam;
import com.tencent.mobileqq.filemanager.util.p;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.filemanager.activity.localfile.FileInfoLoader$getPicTabFileInfo$1", f = "FileInfoLoader.kt", i = {0, 0}, l = {427, QFSNumberConstants.Int.NUM_456}, m = "invokeSuspend", n = {"costData", "start"}, s = {"L$0", "J$0"})
/* loaded from: classes12.dex */
public final class FileInfoLoader$getPicTabFileInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<HashMap<String, ArrayList<FileInfo>>, ArrayList<FileInfo>, Unit> $callback;
    final /* synthetic */ boolean $isFileChooseSupport;
    final /* synthetic */ LoadParam $loadParams;
    long J$0;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.filemanager.activity.localfile.FileInfoLoader$getPicTabFileInfo$1$1", f = "FileInfoLoader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.filemanager.activity.localfile.FileInfoLoader$getPicTabFileInfo$1$1, reason: invalid class name */
    /* loaded from: classes12.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ArrayList<FileInfo> $allFileInfo;
        final /* synthetic */ Function2<HashMap<String, ArrayList<FileInfo>>, ArrayList<FileInfo>, Unit> $callback;
        final /* synthetic */ HashMap<String, ArrayList<FileInfo>> $mediaStoreFileInfo;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Function2<? super HashMap<String, ArrayList<FileInfo>>, ? super ArrayList<FileInfo>, Unit> function2, HashMap<String, ArrayList<FileInfo>> hashMap, ArrayList<FileInfo> arrayList, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$callback = function2;
            this.$mediaStoreFileInfo = hashMap;
            this.$allFileInfo = arrayList;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.$callback, this.$mediaStoreFileInfo, this.$allFileInfo, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.$callback.invoke(this.$mediaStoreFileInfo, this.$allFileInfo);
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
    public FileInfoLoader$getPicTabFileInfo$1(boolean z16, LoadParam loadParam, Function2<? super HashMap<String, ArrayList<FileInfo>>, ? super ArrayList<FileInfo>, Unit> function2, Continuation<? super FileInfoLoader$getPicTabFileInfo$1> continuation) {
        super(2, continuation);
        this.$isFileChooseSupport = z16;
        this.$loadParams = loadParam;
        this.$callback = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FileInfoLoader$getPicTabFileInfo$1 fileInfoLoader$getPicTabFileInfo$1 = new FileInfoLoader$getPicTabFileInfo$1(this.$isFileChooseSupport, this.$loadParams, this.$callback, continuation);
        fileInfoLoader$getPicTabFileInfo$1.L$0 = obj;
        return fileInfoLoader$getPicTabFileInfo$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        CostData costData;
        Deferred async$default;
        Deferred async$default2;
        Deferred async$default3;
        List listOf;
        Object awaitAll;
        long j3;
        Deferred async$default4;
        Deferred async$default5;
        Comparator comparator;
        boolean z16;
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
            costData = r14;
            CostData costData3 = new CostData(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 255, null);
            long uptimeMillis = SystemClock.uptimeMillis();
            if (this.$isFileChooseSupport) {
                async$default4 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new FileInfoLoader$getPicTabFileInfo$1$jobs$1(this.$loadParams, costData, null), 3, null);
                async$default5 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new FileInfoLoader$getPicTabFileInfo$1$jobs$2(this.$loadParams, costData, null), 3, null);
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Deferred[]{async$default4, async$default5});
            } else {
                async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new FileInfoLoader$getPicTabFileInfo$1$jobs$3(this.$loadParams, costData, null), 3, null);
                async$default2 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new FileInfoLoader$getPicTabFileInfo$1$jobs$4(this.$loadParams, costData, null), 3, null);
                async$default3 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new FileInfoLoader$getPicTabFileInfo$1$jobs$5(this.$loadParams, costData, null), 3, null);
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Deferred[]{async$default, async$default2, async$default3});
            }
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
        HashMap t16 = (list.size() <= 2 || list.get(2) == null) ? FileInfoLoader.f206609a.t((HashMap) list.get(0), (HashMap) list.get(1), null) : FileInfoLoader.f206609a.t((HashMap) list.get(0), (HashMap) list.get(1), (HashMap) list.get(2));
        long uptimeMillis3 = SystemClock.uptimeMillis() - uptimeMillis2;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Collection values = ((HashMap) it.next()).values();
            Intrinsics.checkNotNullExpressionValue(values, "it.values");
            flatten = CollectionsKt__IterablesKt.flatten(values);
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, flatten);
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (((FileInfo) obj2).getType() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList2.add(obj2);
            }
        }
        comparator = FileInfoLoader.sMediaComparatorByTime;
        Collections.sort(arrayList2, comparator);
        ArrayList arrayList3 = new ArrayList(arrayList2);
        long uptimeMillis4 = SystemClock.uptimeMillis() - uptimeMillis2;
        costData.i(uptimeMillis4);
        costData.p(SystemClock.uptimeMillis() - j3);
        p.d(costData.getSystemPicCost(), costData.getSandBoxPicCost(), costData.getTotalCost(), true);
        QLog.d("FileInfoLoader", 1, "getPicTabFileInfo groupCost=" + uptimeMillis4 + " groupCost2=" + uptimeMillis3);
        MainCoroutineDispatcher main = Dispatchers.getMain();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$callback, t16, arrayList3, null);
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
        return ((FileInfoLoader$getPicTabFileInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
