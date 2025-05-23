package com.tencent.filament.zplan.avatar;

import com.tencent.filament.zplan.avatar.exception.BlackListResourceException;
import com.tencent.filament.zplan.avatar.model.ZPlanDressUpFAssetInfo;
import com.tencent.filament.zplan.avatar.model.ZPlanFAsset;
import com.tencent.filament.zplan.avatar.model.ZPlanFAssetInfo;
import com.tencent.filament.zplan.avatar.model.ZPlanMakeUpFAssetInfo;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\u008a@\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "", "Lcom/tencent/filament/zplan/avatar/model/ZPlanFAsset;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.zplan.avatar.ZPlanAvatarResourceHelper$slotFAssetMapWithAvatar$2$pSlotAssetMap$1", f = "ZPlanAvatarResourceHelper.kt", i = {0, 1}, l = {1421, 1467}, m = "invokeSuspend", n = {"$this$async", "destination$iv$iv"}, s = {"L$0", "L$0"})
/* loaded from: classes6.dex */
final class ZPlanAvatarResourceHelper$slotFAssetMapWithAvatar$2$pSlotAssetMap$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Map<String, ZPlanFAsset>>, Object> {
    final /* synthetic */ com.tencent.zplan.zplantracing.b $pSlotAssetSpan;
    final /* synthetic */ Ref.BooleanRef $somethingDownloadFromNet;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ ZPlanAvatarResourceHelper$slotFAssetMapWithAvatar$2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanAvatarResourceHelper$slotFAssetMapWithAvatar$2$pSlotAssetMap$1(ZPlanAvatarResourceHelper$slotFAssetMapWithAvatar$2 zPlanAvatarResourceHelper$slotFAssetMapWithAvatar$2, com.tencent.zplan.zplantracing.b bVar, Ref.BooleanRef booleanRef, Continuation continuation) {
        super(2, continuation);
        this.this$0 = zPlanAvatarResourceHelper$slotFAssetMapWithAvatar$2;
        this.$pSlotAssetSpan = bVar;
        this.$somethingDownloadFromNet = booleanRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        ZPlanAvatarResourceHelper$slotFAssetMapWithAvatar$2$pSlotAssetMap$1 zPlanAvatarResourceHelper$slotFAssetMapWithAvatar$2$pSlotAssetMap$1 = new ZPlanAvatarResourceHelper$slotFAssetMapWithAvatar$2$pSlotAssetMap$1(this.this$0, this.$pSlotAssetSpan, this.$somethingDownloadFromNet, completion);
        zPlanAvatarResourceHelper$slotFAssetMapWithAvatar$2$pSlotAssetMap$1.L$0 = obj;
        return zPlanAvatarResourceHelper$slotFAssetMapWithAvatar$2$pSlotAssetMap$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Map<String, ZPlanFAsset>> continuation) {
        return ((ZPlanAvatarResourceHelper$slotFAssetMapWithAvatar$2$pSlotAssetMap$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x011a  */
    /* JADX WARN: Type inference failed for: r1v20, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r4v17, types: [java.util.Collection] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x012f -> B:6:0x0135). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        CoroutineScope coroutineScope;
        int collectionSizeOrDefault;
        Iterator it;
        ArrayList<ZPlanFAsset> arrayList;
        ZPlanAvatarResourceHelper$slotFAssetMapWithAvatar$2$pSlotAssetMap$1 zPlanAvatarResourceHelper$slotFAssetMapWithAvatar$2$pSlotAssetMap$1;
        List list;
        Deferred async$default;
        List list2;
        Deferred async$default2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    ?? r16 = (Collection) this.L$2;
                    Iterator it5 = (Iterator) this.L$1;
                    ?? r46 = (Collection) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    Iterator it6 = it5;
                    ArrayList arrayList2 = r16;
                    Object obj2 = coroutine_suspended;
                    ZPlanAvatarResourceHelper$slotFAssetMapWithAvatar$2$pSlotAssetMap$1 zPlanAvatarResourceHelper$slotFAssetMapWithAvatar$2$pSlotAssetMap$12 = this;
                    ArrayList arrayList3 = r46;
                    arrayList2.add((ZPlanFAsset) obj);
                    zPlanAvatarResourceHelper$slotFAssetMapWithAvatar$2$pSlotAssetMap$1 = zPlanAvatarResourceHelper$slotFAssetMapWithAvatar$2$pSlotAssetMap$12;
                    coroutine_suspended = obj2;
                    arrayList = arrayList3;
                    it = it6;
                    if (it.hasNext()) {
                        Deferred deferred = (Deferred) it.next();
                        zPlanAvatarResourceHelper$slotFAssetMapWithAvatar$2$pSlotAssetMap$1.L$0 = arrayList;
                        zPlanAvatarResourceHelper$slotFAssetMapWithAvatar$2$pSlotAssetMap$1.L$1 = it;
                        zPlanAvatarResourceHelper$slotFAssetMapWithAvatar$2$pSlotAssetMap$1.L$2 = arrayList;
                        zPlanAvatarResourceHelper$slotFAssetMapWithAvatar$2$pSlotAssetMap$1.label = 2;
                        Object await = deferred.await(zPlanAvatarResourceHelper$slotFAssetMapWithAvatar$2$pSlotAssetMap$1);
                        if (await == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        it6 = it;
                        arrayList2 = arrayList;
                        obj2 = coroutine_suspended;
                        zPlanAvatarResourceHelper$slotFAssetMapWithAvatar$2$pSlotAssetMap$12 = zPlanAvatarResourceHelper$slotFAssetMapWithAvatar$2$pSlotAssetMap$1;
                        obj = await;
                        arrayList3 = arrayList2;
                        arrayList2.add((ZPlanFAsset) obj);
                        zPlanAvatarResourceHelper$slotFAssetMapWithAvatar$2$pSlotAssetMap$1 = zPlanAvatarResourceHelper$slotFAssetMapWithAvatar$2$pSlotAssetMap$12;
                        coroutine_suspended = obj2;
                        arrayList = arrayList3;
                        it = it6;
                        if (it.hasNext()) {
                            LinkedHashMap linkedHashMap = new LinkedHashMap();
                            for (ZPlanFAsset zPlanFAsset : arrayList) {
                                if (zPlanFAsset != null) {
                                    linkedHashMap.put(zPlanFAsset.getAssetInfo().getSlot(), zPlanFAsset);
                                }
                            }
                            return linkedHashMap;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
        } else {
            ResultKt.throwOnFailure(obj);
            coroutineScope = (CoroutineScope) this.L$0;
            ZPlanAvatarResourceHelper zPlanAvatarResourceHelper = ZPlanAvatarResourceHelper.f105660o;
            ZPlanAvatarResourceHelper$slotFAssetMapWithAvatar$2 zPlanAvatarResourceHelper$slotFAssetMapWithAvatar$2 = this.this$0;
            JSONObject jSONObject = zPlanAvatarResourceHelper$slotFAssetMapWithAvatar$2.$avatarPbJson;
            FilamentUrlTemplate filamentUrlTemplate = zPlanAvatarResourceHelper$slotFAssetMapWithAvatar$2.$urlTemplate;
            this.L$0 = coroutineScope;
            this.label = 1;
            obj = zPlanAvatarResourceHelper.K0(jSONObject, filamentUrlTemplate, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        ArrayList arrayList4 = new ArrayList();
        Iterator it7 = ((Map) obj).entrySet().iterator();
        while (it7.hasNext()) {
            ZPlanFAssetInfo zPlanFAssetInfo = (ZPlanFAssetInfo) ((Map.Entry) it7.next()).getValue();
            if (zPlanFAssetInfo instanceof ZPlanDressUpFAssetInfo) {
                ZPlanDressUpFAssetInfo zPlanDressUpFAssetInfo = (ZPlanDressUpFAssetInfo) zPlanFAssetInfo;
                if (zPlanDressUpFAssetInfo.getItemId() != 0) {
                    ZPlanAvatarResourceHelper zPlanAvatarResourceHelper2 = ZPlanAvatarResourceHelper.f105660o;
                    list2 = ZPlanAvatarResourceHelper.resBlackList;
                    if (!list2.contains(Boxing.boxLong(zPlanDressUpFAssetInfo.getItemId()))) {
                        async$default2 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new ZPlanAvatarResourceHelper$slotFAssetMapWithAvatar$2$pSlotAssetMap$1$deferred$1(this, zPlanFAssetInfo, null), 3, null);
                        arrayList4.add(async$default2);
                    } else {
                        throw new BlackListResourceException(zPlanDressUpFAssetInfo.getItemId(), zPlanFAssetInfo.getUrl());
                    }
                }
            }
            if (zPlanFAssetInfo instanceof ZPlanMakeUpFAssetInfo) {
                ZPlanMakeUpFAssetInfo zPlanMakeUpFAssetInfo = (ZPlanMakeUpFAssetInfo) zPlanFAssetInfo;
                if (zPlanMakeUpFAssetInfo.getItemId() != 0) {
                    ZPlanAvatarResourceHelper zPlanAvatarResourceHelper3 = ZPlanAvatarResourceHelper.f105660o;
                    list = ZPlanAvatarResourceHelper.resBlackList;
                    if (!list.contains(Boxing.boxLong(zPlanMakeUpFAssetInfo.getItemId()))) {
                        async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new ZPlanAvatarResourceHelper$slotFAssetMapWithAvatar$2$pSlotAssetMap$1$deferred$2(this, zPlanFAssetInfo, null), 3, null);
                        arrayList4.add(async$default);
                    } else {
                        throw new BlackListResourceException(zPlanMakeUpFAssetInfo.getItemId(), zPlanFAssetInfo.getUrl());
                    }
                } else {
                    continue;
                }
            } else {
                continue;
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList4, 10);
        ArrayList arrayList5 = new ArrayList(collectionSizeOrDefault);
        it = arrayList4.iterator();
        arrayList = arrayList5;
        zPlanAvatarResourceHelper$slotFAssetMapWithAvatar$2$pSlotAssetMap$1 = this;
        if (it.hasNext()) {
        }
    }
}
