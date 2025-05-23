package com.tencent.filament.zplan.avatar;

import com.tencent.filament.zplan.avatar.model.ZPlanFAsset;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0012\u0004\u0012\u00020\u00050\u0001*\u00020\u0006H\u008a@\u00a2\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "", "Lcom/tencent/filament/zplan/avatar/model/ZPlanFAsset;", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.zplan.avatar.ZPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$slotAssetMapDeferred$1", f = "ZPlanAvatarResourceHelper.kt", i = {}, l = {249}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class ZPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$slotAssetMapDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends Map<String, ZPlanFAsset>, ? extends Boolean>>, Object> {
    final /* synthetic */ JSONObject $avatarPbJson;
    final /* synthetic */ com.tencent.zplan.zplantracing.b $fetchAvatarResourceSpan;
    final /* synthetic */ FilamentUrlTemplate $urlTemplate;
    final /* synthetic */ boolean $useLod2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$slotAssetMapDeferred$1(com.tencent.zplan.zplantracing.b bVar, JSONObject jSONObject, FilamentUrlTemplate filamentUrlTemplate, boolean z16, Continuation continuation) {
        super(2, continuation);
        this.$fetchAvatarResourceSpan = bVar;
        this.$avatarPbJson = jSONObject;
        this.$urlTemplate = filamentUrlTemplate;
        this.$useLod2 = z16;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new ZPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$slotAssetMapDeferred$1(this.$fetchAvatarResourceSpan, this.$avatarPbJson, this.$urlTemplate, this.$useLod2, completion);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Pair<? extends Map<String, ZPlanFAsset>, ? extends Boolean>> continuation) {
        return ((ZPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$slotAssetMapDeferred$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            com.tencent.zplan.zplantracing.b bVar = this.$fetchAvatarResourceSpan;
            if (bVar != null) {
                cVar = bVar.c();
            } else {
                cVar = null;
            }
            JSONObject jSONObject = this.$avatarPbJson;
            FilamentUrlTemplate filamentUrlTemplate = this.$urlTemplate;
            boolean z16 = this.$useLod2;
            this.label = 1;
            obj = zPlanAvatarResourceHelper.J0(cVar, jSONObject, filamentUrlTemplate, z16, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }
}
