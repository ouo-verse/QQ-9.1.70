package com.tencent.filament.zplan.record;

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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001H\u008a@\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"<anonymous>", "Lcom/tencent/filament/zplan/avatar/model/ReloadAvatarResourceModel;", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/filament/zplan/record/FilamentRecordNativeApp$record$3$avatarResourceDeferred$1$1$1"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.zplan.record.FilamentRecordNativeApp$record$3$avatarResourceDeferred$1$1$1", f = "FilamentRecordNativeApp.kt", i = {}, l = {229}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class FilamentRecordNativeApp$record$3$avatarResourceDeferred$1$invokeSuspend$$inlined$measure$lambda$1 extends SuspendLambda implements Function1<Continuation<? super ReloadAvatarResourceModel>, Object> {
    int label;
    final /* synthetic */ FilamentRecordNativeApp$record$3$avatarResourceDeferred$1 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilamentRecordNativeApp$record$3$avatarResourceDeferred$1$invokeSuspend$$inlined$measure$lambda$1(Continuation continuation, FilamentRecordNativeApp$record$3$avatarResourceDeferred$1 filamentRecordNativeApp$record$3$avatarResourceDeferred$1) {
        super(1, continuation);
        this.this$0 = filamentRecordNativeApp$record$3$avatarResourceDeferred$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new FilamentRecordNativeApp$record$3$avatarResourceDeferred$1$invokeSuspend$$inlined$measure$lambda$1(completion, this.this$0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super ReloadAvatarResourceModel> continuation) {
        return ((FilamentRecordNativeApp$record$3$avatarResourceDeferred$1$invokeSuspend$$inlined$measure$lambda$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
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
            FilamentRecordNativeApp$record$3 filamentRecordNativeApp$record$3 = this.this$0.this$0;
            JSONObject jSONObject = filamentRecordNativeApp$record$3.$avatarInfo;
            filamentUrlTemplate = filamentRecordNativeApp$record$3.this$0.urlTemplate;
            this.label = 1;
            obj = ZPlanAvatarResourceHelper.W(zPlanAvatarResourceHelper, null, jSONObject, filamentUrlTemplate, false, this, 8, null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }
}
