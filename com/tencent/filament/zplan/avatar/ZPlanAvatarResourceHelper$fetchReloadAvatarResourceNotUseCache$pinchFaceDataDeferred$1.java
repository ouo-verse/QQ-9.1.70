package com.tencent.filament.zplan.avatar;

import com.tencent.filament.zplan.avatar.model.ZPlanPinchFaceModel;
import java.util.List;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "Lcom/tencent/filament/zplan/avatar/model/ZPlanPinchFaceModel;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.zplan.avatar.ZPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$pinchFaceDataDeferred$1", f = "ZPlanAvatarResourceHelper.kt", i = {}, l = {251}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class ZPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$pinchFaceDataDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends ZPlanPinchFaceModel>>, Object> {
    final /* synthetic */ JSONObject $avatarPbJson;
    final /* synthetic */ com.tencent.zplan.zplantracing.b $fetchAvatarResourceSpan;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$pinchFaceDataDeferred$1(JSONObject jSONObject, com.tencent.zplan.zplantracing.b bVar, Continuation continuation) {
        super(2, continuation);
        this.$avatarPbJson = jSONObject;
        this.$fetchAvatarResourceSpan = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new ZPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$pinchFaceDataDeferred$1(this.$avatarPbJson, this.$fetchAvatarResourceSpan, completion);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends ZPlanPinchFaceModel>> continuation) {
        return ((ZPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$pinchFaceDataDeferred$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            JSONObject jSONObject = this.$avatarPbJson;
            com.tencent.zplan.zplantracing.b bVar = this.$fetchAvatarResourceSpan;
            if (bVar != null) {
                cVar = bVar.c();
            } else {
                cVar = null;
            }
            this.label = 1;
            obj = zPlanAvatarResourceHelper.y0(jSONObject, cVar, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }
}
