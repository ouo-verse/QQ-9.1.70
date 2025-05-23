package com.tencent.filament.zplan.avatar;

import com.tencent.filament.zplan.avatar.model.ZPlanCommonGltfFAsset;
import com.tencent.filament.zplan.avatar.model.ZPlanFAsset;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.zplan.zplantracing.ZPlanSpanFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0012\u0004\u0012\u00020\u00050\u0001*\u00020\u0006H\u008a@\u00a2\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "", "Lcom/tencent/filament/zplan/avatar/model/ZPlanFAsset;", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.zplan.avatar.ZPlanAvatarResourceHelper$slotFAssetMapWithAvatar$2", f = "ZPlanAvatarResourceHelper.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1}, l = {1489, 1491}, m = "invokeSuspend", n = {"fetchSlotResourceSpan", "somethingDownloadFromNet", "pSlotAssetSpan", "torsoAssetsSpan", "pTorsoAssetList", "fetchSlotResourceSpan", "somethingDownloadFromNet", "torsoAssetsSpan", "dressUpAndMakeUpAssets"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3"})
/* loaded from: classes6.dex */
public final class ZPlanAvatarResourceHelper$slotFAssetMapWithAvatar$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends Map<String, ZPlanFAsset>, ? extends Boolean>>, Object> {
    final /* synthetic */ JSONObject $avatarPbJson;
    final /* synthetic */ FilamentUrlTemplate $urlTemplate;
    final /* synthetic */ boolean $useLod2;
    final /* synthetic */ com.tencent.zplan.zplantracing.c $zplanSpanContext;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\u008a@\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "Lcom/tencent/filament/zplan/avatar/model/ZPlanCommonGltfFAsset;", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
    @DebugMetadata(c = "com.tencent.filament.zplan.avatar.ZPlanAvatarResourceHelper$slotFAssetMapWithAvatar$2$1", f = "ZPlanAvatarResourceHelper.kt", i = {}, l = {1485}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.filament.zplan.avatar.ZPlanAvatarResourceHelper$slotFAssetMapWithAvatar$2$1, reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends ZPlanCommonGltfFAsset, ? extends Boolean>>, Object> {
        final /* synthetic */ com.tencent.zplan.zplantracing.b $torsoAssetsSpan;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(com.tencent.zplan.zplantracing.b bVar, Continuation continuation) {
            super(2, continuation);
            this.$torsoAssetsSpan = bVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
            Intrinsics.checkNotNullParameter(completion, "completion");
            return new AnonymousClass1(this.$torsoAssetsSpan, completion);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Pair<? extends ZPlanCommonGltfFAsset, ? extends Boolean>> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            com.tencent.zplan.zplantracing.c cVar;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                ZPlanAvatarResourceHelper zPlanAvatarResourceHelper = ZPlanAvatarResourceHelper.f105660o;
                com.tencent.zplan.zplantracing.b bVar = this.$torsoAssetsSpan;
                if (bVar != null) {
                    cVar = bVar.c();
                } else {
                    cVar = null;
                }
                FilamentUrlTemplate filamentUrlTemplate = ZPlanAvatarResourceHelper$slotFAssetMapWithAvatar$2.this.$urlTemplate;
                this.label = 1;
                obj = zPlanAvatarResourceHelper.K(cVar, filamentUrlTemplate, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanAvatarResourceHelper$slotFAssetMapWithAvatar$2(com.tencent.zplan.zplantracing.c cVar, JSONObject jSONObject, FilamentUrlTemplate filamentUrlTemplate, boolean z16, Continuation continuation) {
        super(2, continuation);
        this.$zplanSpanContext = cVar;
        this.$avatarPbJson = jSONObject;
        this.$urlTemplate = filamentUrlTemplate;
        this.$useLod2 = z16;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        ZPlanAvatarResourceHelper$slotFAssetMapWithAvatar$2 zPlanAvatarResourceHelper$slotFAssetMapWithAvatar$2 = new ZPlanAvatarResourceHelper$slotFAssetMapWithAvatar$2(this.$zplanSpanContext, this.$avatarPbJson, this.$urlTemplate, this.$useLod2, completion);
        zPlanAvatarResourceHelper$slotFAssetMapWithAvatar$2.L$0 = obj;
        return zPlanAvatarResourceHelper$slotFAssetMapWithAvatar$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Pair<? extends Map<String, ZPlanFAsset>, ? extends Boolean>> continuation) {
        return ((ZPlanAvatarResourceHelper$slotFAssetMapWithAvatar$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x014d A[LOOP:1: B:23:0x0147->B:25:0x014d, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x00fe  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Deferred async$default;
        Deferred async$default2;
        List mutableListOf;
        boolean I0;
        Object await;
        com.tencent.zplan.zplantracing.b bVar;
        com.tencent.zplan.zplantracing.b bVar2;
        com.tencent.zplan.zplantracing.b bVar3;
        Ref.BooleanRef booleanRef;
        Deferred async$default3;
        Object awaitAll;
        Map map;
        com.tencent.zplan.zplantracing.b bVar4;
        Iterator it;
        int collectionSizeOrDefault;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    map = (Map) this.L$3;
                    bVar4 = (com.tencent.zplan.zplantracing.b) this.L$2;
                    booleanRef = (Ref.BooleanRef) this.L$1;
                    com.tencent.zplan.zplantracing.b bVar5 = (com.tencent.zplan.zplantracing.b) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    bVar3 = bVar5;
                    awaitAll = obj;
                    List list = (List) awaitAll;
                    if (bVar4 != null) {
                        bVar4.b();
                    }
                    it = list.iterator();
                    while (it.hasNext()) {
                        if (((Boolean) ((Pair) it.next()).getSecond()).booleanValue()) {
                            booleanRef.element = true;
                        }
                    }
                    if (bVar3 != null) {
                        bVar3.e("downloadFromNet", String.valueOf(booleanRef.element));
                    }
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.putAll(map);
                    List<Pair> list2 = list;
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                    for (Pair pair : list2) {
                        arrayList.add(TuplesKt.to(((ZPlanCommonGltfFAsset) pair.getFirst()).getAssetInfo().getSlot(), pair.getFirst()));
                    }
                    MapsKt__MapsKt.putAll(linkedHashMap, arrayList);
                    if (bVar3 != null) {
                        bVar3.b();
                    }
                    return new Pair(linkedHashMap, Boxing.boxBoolean(booleanRef.element));
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            List list3 = (List) this.L$4;
            bVar2 = (com.tencent.zplan.zplantracing.b) this.L$3;
            bVar = (com.tencent.zplan.zplantracing.b) this.L$2;
            Ref.BooleanRef booleanRef2 = (Ref.BooleanRef) this.L$1;
            bVar3 = (com.tencent.zplan.zplantracing.b) this.L$0;
            ResultKt.throwOnFailure(obj);
            mutableListOf = list3;
            booleanRef = booleanRef2;
            await = obj;
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            ZPlanSpanFactory zPlanSpanFactory = ZPlanSpanFactory.INSTANCE;
            com.tencent.zplan.zplantracing.b startSpan = zPlanSpanFactory.startSpan("fetchSlotResource", this.$zplanSpanContext);
            Ref.BooleanRef booleanRef3 = new Ref.BooleanRef();
            booleanRef3.element = false;
            com.tencent.zplan.zplantracing.b startSpan2 = zPlanSpanFactory.startSpan("pSlotAsset", startSpan);
            async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new ZPlanAvatarResourceHelper$slotFAssetMapWithAvatar$2$pSlotAssetMap$1(this, startSpan2, booleanRef3, null), 3, null);
            com.tencent.zplan.zplantracing.b startSpan3 = zPlanSpanFactory.startSpan("torsoAssets", startSpan);
            async$default2 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new ZPlanAvatarResourceHelper$slotFAssetMapWithAvatar$2$pTorsoAssetList$1(this, startSpan3, null), 3, null);
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(async$default2);
            I0 = ZPlanAvatarResourceHelper.f105660o.I0(this.$avatarPbJson);
            if (I0) {
                async$default3 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new AnonymousClass1(startSpan3, null), 3, null);
                mutableListOf.add(async$default3);
            }
            this.L$0 = startSpan;
            this.L$1 = booleanRef3;
            this.L$2 = startSpan2;
            this.L$3 = startSpan3;
            this.L$4 = mutableListOf;
            this.label = 1;
            await = async$default.await(this);
            if (await == coroutine_suspended) {
                return coroutine_suspended;
            }
            bVar = startSpan2;
            bVar2 = startSpan3;
            bVar3 = startSpan;
            booleanRef = booleanRef3;
        }
        Map map2 = (Map) await;
        if (bVar != null) {
            bVar.b();
        }
        this.L$0 = bVar3;
        this.L$1 = booleanRef;
        this.L$2 = bVar2;
        this.L$3 = map2;
        this.L$4 = null;
        this.label = 2;
        awaitAll = AwaitKt.awaitAll(mutableListOf, this);
        if (awaitAll == coroutine_suspended) {
            return coroutine_suspended;
        }
        map = map2;
        bVar4 = bVar2;
        List list4 = (List) awaitAll;
        if (bVar4 != null) {
        }
        it = list4.iterator();
        while (it.hasNext()) {
        }
        if (bVar3 != null) {
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(map);
        List<Pair> list22 = list4;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list22, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        while (r4.hasNext()) {
        }
        MapsKt__MapsKt.putAll(linkedHashMap2, arrayList2);
        if (bVar3 != null) {
        }
        return new Pair(linkedHashMap2, Boxing.boxBoolean(booleanRef.element));
    }
}
