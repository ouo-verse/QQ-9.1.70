package com.tencent.mobileqq.wink.templatelibrary.memoryalbum;

import android.os.SystemClock;
import com.tencent.luggage.wxa.xd.m0;
import com.tencent.mobileqq.app.LocaleManager;
import com.tencent.mobileqq.winkreport.dengta.WinkDengtaReportConstant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.templatelibrary.memoryalbum.MemoryAlbumGenerator$sortPhotoInAlbums$2", f = "MemoryAlbumGenerator.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3}, l = {com.tencent.luggage.wxa.yf.u.CTRL_INDEX, LocaleManager.MOBILE_COUNTRY_CODE_CN_INT, 461, m0.CTRL_INDEX, 471}, m = "invokeSuspend", n = {"$this$coroutineScope", "preLoadAlbum", "allAlbum", "unFaceDetectIdMap", "$this$coroutineScope", "preLoadAlbum", "allAlbum", "unFaceDetectIdMap", "$this$coroutineScope", "allAlbum", "unFaceDetectIdMap", "$this$coroutineScope", "allAlbum"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$0", "L$1"})
/* loaded from: classes21.dex */
public final class MemoryAlbumGenerator$sortPhotoInAlbums$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<s53.a> $queryAlbums;
    final /* synthetic */ long $start1;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemoryAlbumGenerator$sortPhotoInAlbums$2(List<s53.a> list, long j3, Continuation<? super MemoryAlbumGenerator$sortPhotoInAlbums$2> continuation) {
        super(2, continuation);
        this.$queryAlbums = list;
        this.$start1 = j3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        MemoryAlbumGenerator$sortPhotoInAlbums$2 memoryAlbumGenerator$sortPhotoInAlbums$2 = new MemoryAlbumGenerator$sortPhotoInAlbums$2(this.$queryAlbums, this.$start1, continuation);
        memoryAlbumGenerator$sortPhotoInAlbums$2.L$0 = obj;
        return memoryAlbumGenerator$sortPhotoInAlbums$2;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x018a A[LOOP:0: B:16:0x0184->B:18:0x018a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x01af A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0173 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0131 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0132  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        List arrayList;
        Object R;
        List list;
        CoroutineScope coroutineScope;
        HashSet hashSet;
        int collectionSizeOrDefault;
        List list2;
        List list3;
        CoroutineScope coroutineScope2;
        Deferred async$default;
        Object v06;
        List list4;
        CoroutineScope coroutineScope3;
        Map map;
        Object R2;
        List list5;
        ArrayList arrayList2;
        int collectionSizeOrDefault2;
        Iterator it;
        Deferred async$default2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 == 5) {
                                ResultKt.throwOnFailure(obj);
                                return Unit.INSTANCE;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        list5 = (List) this.L$1;
                        coroutineScope3 = (CoroutineScope) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        List list6 = list5;
                        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list6, 10);
                        arrayList2 = new ArrayList(collectionSizeOrDefault2);
                        it = list6.iterator();
                        while (it.hasNext()) {
                            async$default2 = BuildersKt__Builders_commonKt.async$default(coroutineScope3, null, null, new MemoryAlbumGenerator$sortPhotoInAlbums$2$2$1((s53.a) it.next(), null), 3, null);
                            arrayList2.add(async$default2);
                        }
                        this.L$0 = null;
                        this.L$1 = null;
                        this.label = 5;
                        if (AwaitKt.awaitAll(arrayList2, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    }
                    hashSet = (HashSet) this.L$2;
                    list4 = (List) this.L$1;
                    CoroutineScope coroutineScope4 = (CoroutineScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    coroutineScope3 = coroutineScope4;
                    long elapsedRealtime = SystemClock.elapsedRealtime() - this.$start1;
                    MemoryAlbumGenerator memoryAlbumGenerator = MemoryAlbumGenerator.f326501a;
                    w53.b.f(memoryAlbumGenerator.c(), "generateAlbums preload data cost time " + elapsedRealtime);
                    map = MemoryAlbumGenerator.dengTaParams;
                    map.put(WinkDengtaReportConstant.Params.REPORT_PARMA_MEMORY_ALBUM_PRE_LOAD_TIME, String.valueOf(elapsedRealtime));
                    this.L$0 = coroutineScope3;
                    this.L$1 = list4;
                    this.L$2 = null;
                    this.label = 4;
                    R2 = memoryAlbumGenerator.R(hashSet, this);
                    if (R2 != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    list5 = list4;
                    List list62 = list5;
                    collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list62, 10);
                    arrayList2 = new ArrayList(collectionSizeOrDefault2);
                    it = list62.iterator();
                    while (it.hasNext()) {
                    }
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = 5;
                    if (AwaitKt.awaitAll(arrayList2, this) == coroutine_suspended) {
                    }
                    return Unit.INSTANCE;
                }
                hashSet = (HashSet) this.L$3;
                list2 = (List) this.L$2;
                list3 = (List) this.L$1;
                coroutineScope2 = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                MemoryAlbumGenerator memoryAlbumGenerator2 = MemoryAlbumGenerator.f326501a;
                this.L$0 = coroutineScope2;
                this.L$1 = list2;
                this.L$2 = hashSet;
                this.L$3 = null;
                this.label = 3;
                v06 = memoryAlbumGenerator2.v0(list3, this);
                if (v06 != coroutine_suspended) {
                    return coroutine_suspended;
                }
                list4 = list2;
                coroutineScope3 = coroutineScope2;
                long elapsedRealtime2 = SystemClock.elapsedRealtime() - this.$start1;
                MemoryAlbumGenerator memoryAlbumGenerator3 = MemoryAlbumGenerator.f326501a;
                w53.b.f(memoryAlbumGenerator3.c(), "generateAlbums preload data cost time " + elapsedRealtime2);
                map = MemoryAlbumGenerator.dengTaParams;
                map.put(WinkDengtaReportConstant.Params.REPORT_PARMA_MEMORY_ALBUM_PRE_LOAD_TIME, String.valueOf(elapsedRealtime2));
                this.L$0 = coroutineScope3;
                this.L$1 = list4;
                this.L$2 = null;
                this.label = 4;
                R2 = memoryAlbumGenerator3.R(hashSet, this);
                if (R2 != coroutine_suspended) {
                }
            } else {
                hashSet = (HashSet) this.L$3;
                list = (List) this.L$2;
                arrayList = (List) this.L$1;
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope5 = (CoroutineScope) this.L$0;
            arrayList = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            HashSet hashSet2 = new HashSet();
            HashSet hashSet3 = new HashSet();
            int size = this.$queryAlbums.size();
            for (int i16 = 0; i16 < size; i16++) {
                s53.a aVar = this.$queryAlbums.get(i16);
                if (i16 < 10) {
                    arrayList.add(aVar);
                    hashSet3.addAll(aVar.n());
                } else {
                    hashSet2.addAll(aVar.n());
                    arrayList3.add(aVar);
                }
            }
            MemoryAlbumGenerator memoryAlbumGenerator4 = MemoryAlbumGenerator.f326501a;
            this.L$0 = coroutineScope5;
            this.L$1 = arrayList;
            this.L$2 = arrayList3;
            this.L$3 = hashSet2;
            this.label = 1;
            R = memoryAlbumGenerator4.R(hashSet3, this);
            if (R == coroutine_suspended) {
                return coroutine_suspended;
            }
            list = arrayList3;
            coroutineScope = coroutineScope5;
            hashSet = hashSet2;
        }
        List list7 = arrayList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list7, 10);
        ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault);
        Iterator it5 = list7.iterator();
        while (it5.hasNext()) {
            async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new MemoryAlbumGenerator$sortPhotoInAlbums$2$1$1((s53.a) it5.next(), null), 3, null);
            arrayList4.add(async$default);
        }
        this.L$0 = coroutineScope;
        this.L$1 = arrayList;
        this.L$2 = list;
        this.L$3 = hashSet;
        this.label = 2;
        if (AwaitKt.awaitAll(arrayList4, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        list2 = list;
        list3 = arrayList;
        coroutineScope2 = coroutineScope;
        MemoryAlbumGenerator memoryAlbumGenerator22 = MemoryAlbumGenerator.f326501a;
        this.L$0 = coroutineScope2;
        this.L$1 = list2;
        this.L$2 = hashSet;
        this.L$3 = null;
        this.label = 3;
        v06 = memoryAlbumGenerator22.v0(list3, this);
        if (v06 != coroutine_suspended) {
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MemoryAlbumGenerator$sortPhotoInAlbums$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
