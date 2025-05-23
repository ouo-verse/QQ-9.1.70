package com.tencent.filament.zplan.avatar;

import com.tencent.filament.zplan.avatar.exception.FetchFileException;
import com.tencent.filament.zplan.avatar.model.Resource;
import com.tencent.filament.zplan.avatar.model.ZPlanDressUpFAsset;
import com.tencent.filament.zplan.avatar.model.ZPlanDressUpFAssetInfo;
import com.tencent.filament.zplan.avatar.model.ZPlanFAssetInfo;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "Lcom/tencent/filament/zplan/avatar/model/ZPlanDressUpFAsset;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.zplan.avatar.ZPlanAvatarResourceHelper$slotFAssetMapWithAvatar$2$pSlotAssetMap$1$deferred$1", f = "ZPlanAvatarResourceHelper.kt", i = {}, l = {1431}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class ZPlanAvatarResourceHelper$slotFAssetMapWithAvatar$2$pSlotAssetMap$1$deferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ZPlanDressUpFAsset>, Object> {
    final /* synthetic */ ZPlanFAssetInfo $assetInfo;
    int label;
    final /* synthetic */ ZPlanAvatarResourceHelper$slotFAssetMapWithAvatar$2$pSlotAssetMap$1 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanAvatarResourceHelper$slotFAssetMapWithAvatar$2$pSlotAssetMap$1$deferred$1(ZPlanAvatarResourceHelper$slotFAssetMapWithAvatar$2$pSlotAssetMap$1 zPlanAvatarResourceHelper$slotFAssetMapWithAvatar$2$pSlotAssetMap$1, ZPlanFAssetInfo zPlanFAssetInfo, Continuation continuation) {
        super(2, continuation);
        this.this$0 = zPlanAvatarResourceHelper$slotFAssetMapWithAvatar$2$pSlotAssetMap$1;
        this.$assetInfo = zPlanFAssetInfo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new ZPlanAvatarResourceHelper$slotFAssetMapWithAvatar$2$pSlotAssetMap$1$deferred$1(this.this$0, this.$assetInfo, completion);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ZPlanDressUpFAsset> continuation) {
        return ((ZPlanAvatarResourceHelper$slotFAssetMapWithAvatar$2$pSlotAssetMap$1$deferred$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        com.tencent.zplan.zplantracing.c cVar;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 != 0) {
                if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                ZPlanAvatarResourceHelper zPlanAvatarResourceHelper = ZPlanAvatarResourceHelper.f105660o;
                com.tencent.zplan.zplantracing.b bVar = this.this$0.$pSlotAssetSpan;
                if (bVar != null) {
                    cVar = bVar.c();
                } else {
                    cVar = null;
                }
                String url = this.$assetInfo.getUrl();
                FilamentUrlTemplate filamentUrlTemplate = this.this$0.this$0.$urlTemplate;
                this.label = 1;
                obj = ZPlanAvatarResourceHelper.M(zPlanAvatarResourceHelper, cVar, url, null, "gltf", filamentUrlTemplate, false, this, 36, null);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            Resource resource = (Resource) obj;
            String path = resource.getPath();
            if (resource.getDownloadFromNet()) {
                this.this$0.$somethingDownloadFromNet.element = true;
            }
            return new ZPlanDressUpFAsset((ZPlanDressUpFAssetInfo) this.$assetInfo, path);
        } catch (FetchFileException e16) {
            if (e16.getType() == FetchFileException.Type.DOWNLOAD_FAIL && e16.getErrorCode() == 404) {
                return null;
            }
            throw e16;
        }
    }
}
