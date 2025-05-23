package com.tencent.filament.zplan.scene.tofu;

import com.tencent.filament.zplan.avatar.ZPlanAvatarResourceHelper;
import com.tencent.filament.zplan.avatar.model.BootResourceModel;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "Lcom/tencent/filament/zplan/avatar/model/BootResourceModel;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.zplan.scene.tofu.TofuScene$fetchBootResourceAndBootAsync$1", f = "TofuScene.kt", i = {}, l = {255}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class TofuScene$fetchBootResourceAndBootAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BootResourceModel>, Object> {
    final /* synthetic */ String $bodyTypeName;
    final /* synthetic */ c $spanContext;
    int label;
    final /* synthetic */ TofuScene this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TofuScene$fetchBootResourceAndBootAsync$1(TofuScene tofuScene, c cVar, String str, Continuation continuation) {
        super(2, continuation);
        this.this$0 = tofuScene;
        this.$spanContext = cVar;
        this.$bodyTypeName = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new TofuScene$fetchBootResourceAndBootAsync$1(this.this$0, this.$spanContext, this.$bodyTypeName, completion);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super BootResourceModel> continuation) {
        return ((TofuScene$fetchBootResourceAndBootAsync$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        FilamentUrlTemplate filamentUrlTemplate;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        boolean z16 = true;
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
            filamentUrlTemplate = this.this$0.urlTemplate;
            this.label = 1;
            obj = zPlanAvatarResourceHelper.F(cVar, filamentUrlTemplate, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        BootResourceModel bootResourceModel = (BootResourceModel) obj;
        TofuScene tofuScene = this.this$0;
        if (!tofuScene.hasDownloadFromNet && !bootResourceModel.getDownloadFromNet()) {
            z16 = false;
        }
        tofuScene.hasDownloadFromNet = z16;
        this.this$0.W(this.$spanContext, bootResourceModel, this.$bodyTypeName);
        return bootResourceModel;
    }
}
