package com.tencent.filament.zplan.scene.multiCartoon;

import com.tencent.filament.zplan.avatar.ZPlanAvatarResourceHelper;
import com.tencent.filament.zplan.avatar.model.ReloadAvatarResourceModel;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.zplan.zplantracing.c;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "Lcom/tencent/filament/zplan/avatar/model/ReloadAvatarResourceModel;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.zplan.scene.multiCartoon.MultiCartoonScene$fetchReloadAvatarResourceAsync$1", f = "MultiCartoonScene.kt", i = {}, l = {298}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class MultiCartoonScene$fetchReloadAvatarResourceAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ReloadAvatarResourceModel>, Object> {
    final /* synthetic */ JSONObject $avatarInfo;
    final /* synthetic */ c $spanContext;
    int label;
    final /* synthetic */ MultiCartoonScene this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiCartoonScene$fetchReloadAvatarResourceAsync$1(MultiCartoonScene multiCartoonScene, c cVar, JSONObject jSONObject, Continuation continuation) {
        super(2, continuation);
        this.this$0 = multiCartoonScene;
        this.$spanContext = cVar;
        this.$avatarInfo = jSONObject;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new MultiCartoonScene$fetchReloadAvatarResourceAsync$1(this.this$0, this.$spanContext, this.$avatarInfo, completion);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ReloadAvatarResourceModel> continuation) {
        return ((MultiCartoonScene$fetchReloadAvatarResourceAsync$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        FilamentUrlTemplate filamentUrlTemplate;
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
            c cVar = this.$spanContext;
            JSONObject jSONObject = this.$avatarInfo;
            filamentUrlTemplate = this.this$0.urlTemplate;
            this.label = 1;
            obj = ZPlanAvatarResourceHelper.W(zPlanAvatarResourceHelper, cVar, jSONObject, filamentUrlTemplate, false, this, 8, null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }
}
