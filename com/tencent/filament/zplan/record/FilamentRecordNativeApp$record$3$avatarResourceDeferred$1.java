package com.tencent.filament.zplan.record;

import com.tencent.filament.zplan.avatar.model.ReloadAvatarResourceModel;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "Lcom/tencent/filament/zplan/avatar/model/ReloadAvatarResourceModel;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.zplan.record.FilamentRecordNativeApp$record$3$avatarResourceDeferred$1", f = "FilamentRecordNativeApp.kt", i = {0}, l = {228}, m = "invokeSuspend", n = {"this_$iv"}, s = {"L$0"})
/* loaded from: classes6.dex */
public final class FilamentRecordNativeApp$record$3$avatarResourceDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ReloadAvatarResourceModel>, Object> {
    final /* synthetic */ al0.a $avatarResourceStep;
    Object L$0;
    int label;
    final /* synthetic */ FilamentRecordNativeApp$record$3 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilamentRecordNativeApp$record$3$avatarResourceDeferred$1(FilamentRecordNativeApp$record$3 filamentRecordNativeApp$record$3, al0.a aVar, Continuation continuation) {
        super(2, continuation);
        this.this$0 = filamentRecordNativeApp$record$3;
        this.$avatarResourceStep = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new FilamentRecordNativeApp$record$3$avatarResourceDeferred$1(this.this$0, this.$avatarResourceStep, completion);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ReloadAvatarResourceModel> continuation) {
        return ((FilamentRecordNativeApp$record$3$avatarResourceDeferred$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        al0.a aVar;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                aVar = (al0.a) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            al0.a aVar2 = this.$avatarResourceStep;
            aVar2.l(al0.a.INSTANCE.b());
            FilamentRecordNativeApp filamentRecordNativeApp = this.this$0.this$0;
            String str = "record taskId:" + this.this$0.$taskId + ", fetchAvatarResource";
            FilamentRecordNativeApp$record$3$avatarResourceDeferred$1$invokeSuspend$$inlined$measure$lambda$1 filamentRecordNativeApp$record$3$avatarResourceDeferred$1$invokeSuspend$$inlined$measure$lambda$1 = new FilamentRecordNativeApp$record$3$avatarResourceDeferred$1$invokeSuspend$$inlined$measure$lambda$1(null, this);
            this.L$0 = aVar2;
            this.label = 1;
            Object G = FilamentRecordNativeApp.G(filamentRecordNativeApp, str, 0, filamentRecordNativeApp$record$3$avatarResourceDeferred$1$invokeSuspend$$inlined$measure$lambda$1, this, 2, null);
            if (G == coroutine_suspended) {
                return coroutine_suspended;
            }
            aVar = aVar2;
            obj = G;
        }
        ReloadAvatarResourceModel reloadAvatarResourceModel = (ReloadAvatarResourceModel) obj;
        aVar.i(al0.a.INSTANCE.b());
        return reloadAvatarResourceModel;
    }
}
