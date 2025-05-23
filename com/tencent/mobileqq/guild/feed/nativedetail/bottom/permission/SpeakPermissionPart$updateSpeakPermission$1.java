package com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission;

import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
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

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.SpeakPermissionPart$updateSpeakPermission$1", f = "SpeakPermissionPart.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
final class SpeakPermissionPart$updateSpeakPermission$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IGProGuildInfo $guildInfo;
    int label;
    final /* synthetic */ SpeakPermissionPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpeakPermissionPart$updateSpeakPermission$1(SpeakPermissionPart speakPermissionPart, IGProGuildInfo iGProGuildInfo, Continuation<? super SpeakPermissionPart$updateSpeakPermission$1> continuation) {
        super(2, continuation);
        this.this$0 = speakPermissionPart;
        this.$guildInfo = iGProGuildInfo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SpeakPermissionPart$updateSpeakPermission$1(this.this$0, this.$guildInfo, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            SpeakPermissionPart speakPermissionPart = this.this$0;
            IGProGuildInfo guildInfo = this.$guildInfo;
            Intrinsics.checkNotNullExpressionValue(guildInfo, "guildInfo");
            speakPermissionPart.P9(guildInfo);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SpeakPermissionPart$updateSpeakPermission$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
