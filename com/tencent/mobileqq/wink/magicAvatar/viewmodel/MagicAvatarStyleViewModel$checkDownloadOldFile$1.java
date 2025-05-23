package com.tencent.mobileqq.wink.magicAvatar.viewmodel;

import com.tencent.mobileqq.wink.magicstudio.MagicStudioDataSource;
import com.tencent.mobileqq.wink.model.ModifyAvatarConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.magicAvatar.viewmodel.MagicAvatarStyleViewModel$checkDownloadOldFile$1", f = "MagicAvatarStyleViewModel.kt", i = {}, l = {65}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
final class MagicAvatarStyleViewModel$checkDownloadOldFile$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ModifyAvatarConfig $config;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MagicAvatarStyleViewModel$checkDownloadOldFile$1(ModifyAvatarConfig modifyAvatarConfig, Continuation<? super MagicAvatarStyleViewModel$checkDownloadOldFile$1> continuation) {
        super(2, continuation);
        this.$config = modifyAvatarConfig;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MagicAvatarStyleViewModel$checkDownloadOldFile$1(this.$config, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        boolean z16;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
        } catch (IllegalStateException e16) {
            w53.b.c("MagicAvatarStyleViewModel", "checkDownloadOldFile failed: " + e16.getMessage());
        }
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            ModifyAvatarConfig modifyAvatarConfig = this.$config;
            if (modifyAvatarConfig != null) {
                if (modifyAvatarConfig.getOldAvatarFilePath().length() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    MagicStudioDataSource magicStudioDataSource = MagicStudioDataSource.f323652a;
                    String currentAvatarUrl = modifyAvatarConfig.getCurrentAvatarUrl();
                    this.label = 1;
                    if (MagicStudioDataSource.s(magicStudioDataSource, currentAvatarUrl, false, null, this, 6, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MagicAvatarStyleViewModel$checkDownloadOldFile$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
