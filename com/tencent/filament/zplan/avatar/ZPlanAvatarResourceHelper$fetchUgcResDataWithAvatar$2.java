package com.tencent.filament.zplan.avatar;

import com.tencent.filament.zplan.avatar.model.ZPlanUgcFAsset;
import com.tencent.filament.zplan.avatar.model.ZPlanUgcFAssetInfo;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.zplan.zplantracing.ZPlanSpanFactory;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
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

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0012\u0004\u0012\u00020\u00050\u0001*\u00020\u0006H\u008a@\u00a2\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "", "Lcom/tencent/filament/zplan/avatar/model/ZPlanUgcFAsset;", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.zplan.avatar.ZPlanAvatarResourceHelper$fetchUgcResDataWithAvatar$2", f = "ZPlanAvatarResourceHelper.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {1036, 1059}, m = "invokeSuspend", n = {"$this$coroutineScope", "fetchUgcResDataSpan", "somethingDownloadFromNet", "ugcFAssetMap", "$this$coroutineScope", "fetchUgcResDataSpan", "somethingDownloadFromNet", "ugcFAssetMap", "assetInfo"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$5"})
/* loaded from: classes6.dex */
public final class ZPlanAvatarResourceHelper$fetchUgcResDataWithAvatar$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends Map<String, ZPlanUgcFAsset>, ? extends Boolean>>, Object> {
    final /* synthetic */ JSONObject $avatarPbJson;
    final /* synthetic */ FilamentUrlTemplate $urlTemplate;
    final /* synthetic */ com.tencent.zplan.zplantracing.c $zplanSpanContext;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanAvatarResourceHelper$fetchUgcResDataWithAvatar$2(com.tencent.zplan.zplantracing.c cVar, JSONObject jSONObject, FilamentUrlTemplate filamentUrlTemplate, Continuation continuation) {
        super(2, continuation);
        this.$zplanSpanContext = cVar;
        this.$avatarPbJson = jSONObject;
        this.$urlTemplate = filamentUrlTemplate;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        ZPlanAvatarResourceHelper$fetchUgcResDataWithAvatar$2 zPlanAvatarResourceHelper$fetchUgcResDataWithAvatar$2 = new ZPlanAvatarResourceHelper$fetchUgcResDataWithAvatar$2(this.$zplanSpanContext, this.$avatarPbJson, this.$urlTemplate, completion);
        zPlanAvatarResourceHelper$fetchUgcResDataWithAvatar$2.L$0 = obj;
        return zPlanAvatarResourceHelper$fetchUgcResDataWithAvatar$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Pair<? extends Map<String, ZPlanUgcFAsset>, ? extends Boolean>> continuation) {
        return ((ZPlanAvatarResourceHelper$fetchUgcResDataWithAvatar$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0108  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0101 -> B:6:0x0104). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Object z06;
        Ref.BooleanRef booleanRef;
        Map map;
        CoroutineScope coroutineScope;
        com.tencent.zplan.zplantracing.b bVar;
        Iterator it;
        ZPlanAvatarResourceHelper$fetchUgcResDataWithAvatar$2 zPlanAvatarResourceHelper$fetchUgcResDataWithAvatar$2;
        com.tencent.zplan.zplantracing.b bVar2;
        CoroutineScope coroutineScope2;
        Map map2;
        Ref.BooleanRef booleanRef2;
        Deferred async$default;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    ZPlanUgcFAssetInfo zPlanUgcFAssetInfo = (ZPlanUgcFAssetInfo) this.L$5;
                    it = (Iterator) this.L$4;
                    map2 = (Map) this.L$3;
                    Ref.BooleanRef booleanRef3 = (Ref.BooleanRef) this.L$2;
                    com.tencent.zplan.zplantracing.b bVar3 = (com.tencent.zplan.zplantracing.b) this.L$1;
                    CoroutineScope coroutineScope3 = (CoroutineScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    zPlanAvatarResourceHelper$fetchUgcResDataWithAvatar$2 = this;
                    bVar2 = bVar3;
                    Ref.BooleanRef booleanRef4 = booleanRef3;
                    Object await = obj;
                    ZPlanUgcFAsset zPlanUgcFAsset = (ZPlanUgcFAsset) await;
                    if (zPlanUgcFAsset != null) {
                        map2.put(String.valueOf(zPlanUgcFAssetInfo.getSlotId()), zPlanUgcFAsset);
                    }
                    booleanRef2 = booleanRef4;
                    coroutineScope2 = coroutineScope3;
                    while (it.hasNext()) {
                        ZPlanUgcFAssetInfo zPlanUgcFAssetInfo2 = (ZPlanUgcFAssetInfo) ((Map.Entry) it.next()).getValue();
                        if (zPlanUgcFAssetInfo2.getIsLocalFileUrl()) {
                            map2.put(String.valueOf(zPlanUgcFAssetInfo2.getSlotId()), new ZPlanUgcFAsset(zPlanUgcFAssetInfo2, zPlanUgcFAssetInfo2.getUrl()));
                        } else {
                            async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope2, null, null, new ZPlanAvatarResourceHelper$fetchUgcResDataWithAvatar$2$fasset$1(zPlanAvatarResourceHelper$fetchUgcResDataWithAvatar$2, bVar2, zPlanUgcFAssetInfo2, booleanRef2, null), 3, null);
                            zPlanAvatarResourceHelper$fetchUgcResDataWithAvatar$2.L$0 = coroutineScope2;
                            zPlanAvatarResourceHelper$fetchUgcResDataWithAvatar$2.L$1 = bVar2;
                            zPlanAvatarResourceHelper$fetchUgcResDataWithAvatar$2.L$2 = booleanRef2;
                            zPlanAvatarResourceHelper$fetchUgcResDataWithAvatar$2.L$3 = map2;
                            zPlanAvatarResourceHelper$fetchUgcResDataWithAvatar$2.L$4 = it;
                            zPlanAvatarResourceHelper$fetchUgcResDataWithAvatar$2.L$5 = zPlanUgcFAssetInfo2;
                            zPlanAvatarResourceHelper$fetchUgcResDataWithAvatar$2.label = 2;
                            await = async$default.await(zPlanAvatarResourceHelper$fetchUgcResDataWithAvatar$2);
                            if (await == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            booleanRef4 = booleanRef2;
                            coroutineScope3 = coroutineScope2;
                            zPlanUgcFAssetInfo = zPlanUgcFAssetInfo2;
                            ZPlanUgcFAsset zPlanUgcFAsset2 = (ZPlanUgcFAsset) await;
                            if (zPlanUgcFAsset2 != null) {
                            }
                            booleanRef2 = booleanRef4;
                            coroutineScope2 = coroutineScope3;
                            while (it.hasNext()) {
                            }
                        }
                    }
                    if (bVar2 != null) {
                        bVar2.e("downloadFromNet", String.valueOf(booleanRef2.element));
                    }
                    if (bVar2 != null) {
                        bVar2.b();
                    }
                    return new Pair(map2, Boxing.boxBoolean(booleanRef2.element));
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            map = (Map) this.L$3;
            Ref.BooleanRef booleanRef5 = (Ref.BooleanRef) this.L$2;
            com.tencent.zplan.zplantracing.b bVar4 = (com.tencent.zplan.zplantracing.b) this.L$1;
            CoroutineScope coroutineScope4 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            coroutineScope = coroutineScope4;
            bVar = bVar4;
            booleanRef = booleanRef5;
            z06 = obj;
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope5 = (CoroutineScope) this.L$0;
            com.tencent.zplan.zplantracing.b startSpan = ZPlanSpanFactory.INSTANCE.startSpan("fetchUgcResData", this.$zplanSpanContext);
            Ref.BooleanRef booleanRef6 = new Ref.BooleanRef();
            booleanRef6.element = false;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            ZPlanAvatarResourceHelper zPlanAvatarResourceHelper = ZPlanAvatarResourceHelper.f105660o;
            JSONObject jSONObject = this.$avatarPbJson;
            this.L$0 = coroutineScope5;
            this.L$1 = startSpan;
            this.L$2 = booleanRef6;
            this.L$3 = linkedHashMap;
            this.label = 1;
            z06 = zPlanAvatarResourceHelper.z0(jSONObject, this);
            if (z06 == coroutine_suspended) {
                return coroutine_suspended;
            }
            booleanRef = booleanRef6;
            map = linkedHashMap;
            coroutineScope = coroutineScope5;
            bVar = startSpan;
        }
        it = ((Map) z06).entrySet().iterator();
        zPlanAvatarResourceHelper$fetchUgcResDataWithAvatar$2 = this;
        bVar2 = bVar;
        coroutineScope2 = coroutineScope;
        Ref.BooleanRef booleanRef7 = booleanRef;
        map2 = map;
        booleanRef2 = booleanRef7;
        while (it.hasNext()) {
        }
        if (bVar2 != null) {
        }
        if (bVar2 != null) {
        }
        return new Pair(map2, Boxing.boxBoolean(booleanRef2.element));
    }
}
