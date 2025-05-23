package com.tencent.filament.zplan.avatar;

import com.tencent.view.FilterEnum;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0086@"}, d2 = {"Lcom/tencent/zplan/zplantracing/c;", "zplanSpanContext", "Lorg/json/JSONObject;", "avatarPbJson", "Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;", "urlTemplate", "", "useLod2", "Lkotlin/coroutines/Continuation;", "Lcom/tencent/filament/zplan/avatar/model/ReloadAvatarResourceModel;", "continuation", "", "fetchReloadAvatarResourceNotUseCache"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.zplan.avatar.ZPlanAvatarResourceHelper", f = "ZPlanAvatarResourceHelper.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10}, l = {263, 264, 266, 267, 275, 276, 277, FilterEnum.MIC_PTU_TRANS_ROUHE, 284, 287, 288}, m = "fetchReloadAvatarResourceNotUseCache", n = {"this", "urlTemplate", "fetchAvatarResourceSpan", "fetchSplitShaderSpan", "coroutineScope", "pinchFaceConfigPathDeferred", "pinchFaceDataDeferred", "eyelashGltfFAssetDeferred", "gender", "pantsLengthDeferred", "shoeHeightDeferred", "bodyTypePathDeferred", "aiBodyRefPathDeferred", "ugcResDataDeferred", "fetchSplitShaderJobList", "urlTemplate", "fetchAvatarResourceSpan", "fetchSplitShaderSpan", "coroutineScope", "pinchFaceConfigPathDeferred", "pinchFaceDataDeferred", "eyelashGltfFAssetDeferred", "gender", "pantsLengthDeferred", "shoeHeightDeferred", "bodyTypePathDeferred", "aiBodyRefPathDeferred", "ugcResDataDeferred", "fetchSplitShaderJobList", "slotAssetMap", "slotAssetMapDownload", "urlTemplate", "fetchAvatarResourceSpan", "fetchSplitShaderSpan", "coroutineScope", "pinchFaceDataDeferred", "eyelashGltfFAssetDeferred", "gender", "pantsLengthDeferred", "shoeHeightDeferred", "bodyTypePathDeferred", "aiBodyRefPathDeferred", "ugcResDataDeferred", "fetchSplitShaderJobList", "slotAssetMap", "slotAssetMapDownload", "urlTemplate", "fetchAvatarResourceSpan", "fetchSplitShaderSpan", "coroutineScope", "pinchFaceDataDeferred", "gender", "pantsLengthDeferred", "shoeHeightDeferred", "bodyTypePathDeferred", "aiBodyRefPathDeferred", "ugcResDataDeferred", "fetchSplitShaderJobList", "slotAssetMap", "pinchFaceConfigPath", "slotAssetMapDownload", "pinchFaceConfigDownload", "fetchAvatarResourceSpan", "fetchSplitShaderSpan", "pinchFaceDataDeferred", "gender", "pantsLengthDeferred", "shoeHeightDeferred", "aiBodyRefPathDeferred", "ugcResDataDeferred", "fetchSplitShaderJobList", "slotAssetMap", "pinchFaceConfigPath", "eyelashGltfFAsset", "slotAssetMapDownload", "pinchFaceConfigDownload", "eyelashDownload", "fetchAvatarResourceSpan", "fetchSplitShaderSpan", "pinchFaceDataDeferred", "gender", "pantsLengthDeferred", "shoeHeightDeferred", "ugcResDataDeferred", "fetchSplitShaderJobList", "slotAssetMap", "pinchFaceConfigPath", "eyelashGltfFAsset", "bodyTypePath", "slotAssetMapDownload", "pinchFaceConfigDownload", "eyelashDownload", "bodyTypePathDownload", "fetchAvatarResourceSpan", "fetchSplitShaderSpan", "pinchFaceDataDeferred", "gender", "pantsLengthDeferred", "shoeHeightDeferred", "fetchSplitShaderJobList", "slotAssetMap", "pinchFaceConfigPath", "eyelashGltfFAsset", "bodyTypePath", "aiBodyRefPath", "slotAssetMapDownload", "pinchFaceConfigDownload", "eyelashDownload", "bodyTypePathDownload", "aiBodyRefPathDownload", "fetchAvatarResourceSpan", "fetchSplitShaderSpan", "pinchFaceDataDeferred", "gender", "pantsLengthDeferred", "shoeHeightDeferred", "slotAssetMap", "pinchFaceConfigPath", "eyelashGltfFAsset", "bodyTypePath", "aiBodyRefPath", "ugcResData", "slotAssetMapDownload", "pinchFaceConfigDownload", "eyelashDownload", "bodyTypePathDownload", "aiBodyRefPathDownload", "ugcResDataDownload", "fetchAvatarResourceSpan", "gender", "pantsLengthDeferred", "shoeHeightDeferred", "eyelashGltfFAsset", "bodyTypePath", "aiBodyRefPath", "ugcResData", "slotAssetMapDownload", "pinchFaceConfigDownload", "eyelashDownload", "bodyTypePathDownload", "aiBodyRefPathDownload", "ugcResDataDownload", "fetchAvatarResourceSpan", "shoeHeightDeferred", "bodyTypePath", "aiBodyRefPath", "ugcResData", "slotAssetMapDownload", "pinchFaceConfigDownload", "eyelashDownload", "bodyTypePathDownload", "aiBodyRefPathDownload", "ugcResDataDownload", "fetchAvatarResourceSpan", "bodyTypePath", "aiBodyRefPath", "ugcResData", "slotAssetMapDownload", "pinchFaceConfigDownload", "eyelashDownload", "bodyTypePathDownload", "aiBodyRefPathDownload", "ugcResDataDownload"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "Z$0", "Z$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "Z$0", "Z$1", "Z$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "Z$0", "Z$1", "Z$2", "Z$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "Z$0", "Z$1", "Z$2", "Z$3", "Z$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "Z$0", "Z$1", "Z$2", "Z$3", "Z$4", "Z$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "Z$0", "Z$1", "Z$2", "Z$3", "Z$4", "Z$5", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "Z$1", "Z$2", "Z$3", "Z$4", "Z$5", "L$0", "L$1", "L$2", "L$3", "Z$0", "Z$1", "Z$2", "Z$3", "Z$4", "Z$5"})
/* loaded from: classes6.dex */
public final class ZPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$1 extends ContinuationImpl {
    double D$0;
    Object L$0;
    Object L$1;
    Object L$10;
    Object L$11;
    Object L$12;
    Object L$13;
    Object L$14;
    Object L$15;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    boolean Z$0;
    boolean Z$1;
    boolean Z$2;
    boolean Z$3;
    boolean Z$4;
    boolean Z$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ZPlanAvatarResourceHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$1(ZPlanAvatarResourceHelper zPlanAvatarResourceHelper, Continuation continuation) {
        super(continuation);
        this.this$0 = zPlanAvatarResourceHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.X(null, null, null, false, this);
    }
}
