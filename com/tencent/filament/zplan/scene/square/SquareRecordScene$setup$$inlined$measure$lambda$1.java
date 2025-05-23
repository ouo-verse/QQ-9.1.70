package com.tencent.filament.zplan.scene.square;

import com.tencent.filament.zplan.avatar.ZPlanAvatarResourceHelper;
import com.tencent.filament.zplan.avatar.model.ReloadAvatarResourceModel;
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
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0006"}, d2 = {"<anonymous>", "Lcom/tencent/filament/zplan/avatar/model/ReloadAvatarResourceModel;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/filament/zplan/scene/square/SquareRecordScene$setup$avatarResources$1$2$1", "com/tencent/filament/zplan/scene/square/SquareRecordScene$$special$$inlined$map$lambda$1"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.zplan.scene.square.SquareRecordScene$setup$avatarResources$1$2$1", f = "SquareRecordScene.kt", i = {}, l = {75}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class SquareRecordScene$setup$$inlined$measure$lambda$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ReloadAvatarResourceModel>, Object> {
    final /* synthetic */ Continuation $continuation$inlined;
    final /* synthetic */ JSONObject $it;
    final /* synthetic */ SquareAvatarData $playData$inlined;
    int label;
    final /* synthetic */ SquareRecordScene this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareRecordScene$setup$$inlined$measure$lambda$1(JSONObject jSONObject, Continuation continuation, SquareRecordScene squareRecordScene, Continuation continuation2, SquareAvatarData squareAvatarData) {
        super(2, continuation);
        this.$it = jSONObject;
        this.this$0 = squareRecordScene;
        this.$continuation$inlined = continuation2;
        this.$playData$inlined = squareAvatarData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new SquareRecordScene$setup$$inlined$measure$lambda$1(this.$it, completion, this.this$0, this.$continuation$inlined, this.$playData$inlined);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ReloadAvatarResourceModel> continuation) {
        return ((SquareRecordScene$setup$$inlined$measure$lambda$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        FilamentUrlTemplate filamentUrlTemplate;
        Object W;
        ReloadAvatarResourceModel j3;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
                W = obj;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            JSONObject jSONObject = this.$it;
            if (jSONObject == null) {
                return null;
            }
            ZPlanAvatarResourceHelper zPlanAvatarResourceHelper = ZPlanAvatarResourceHelper.f105660o;
            filamentUrlTemplate = this.this$0.urlTemplate;
            this.label = 1;
            W = ZPlanAvatarResourceHelper.W(zPlanAvatarResourceHelper, null, jSONObject, filamentUrlTemplate, false, this, 8, null);
            if (W == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        j3 = r9.j((r26 & 1) != 0 ? r9.slotAssetMap : null, (r26 & 2) != 0 ? r9.pinchFaceConfigPath : null, (r26 & 4) != 0 ? r9.pinchFaceData : null, (r26 & 8) != 0 ? r9.eyelashGltfFAsset : null, (r26 & 16) != 0 ? r9.gender : null, (r26 & 32) != 0 ? r9.pantsLength : 0.0d, (r26 & 64) != 0 ? r9.shoeHeight : 0.0d, (r26 & 128) != 0 ? r9.bodyTypePath : "", (r26 & 256) != 0 ? r9.aiBodyRefPath : null, (r26 & 512) != 0 ? ((ReloadAvatarResourceModel) W).ugcResData : null);
        return j3;
    }
}
