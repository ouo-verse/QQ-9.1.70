package com.tencent.mobileqq.guild.media.core.logic;

import com.tencent.mobileqq.guild.media.core.CommonRsp;
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
@DebugMetadata(c = "com.tencent.mobileqq.guild.media.core.logic.MediaEnterExitRequestHelper$switchChannelTheme$1", f = "MediaEnterExitRequestHelper.kt", i = {}, l = {397}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes14.dex */
final class MediaEnterExitRequestHelper$switchChannelTheme$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $themeType;
    int label;
    final /* synthetic */ MediaEnterExitRequestHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaEnterExitRequestHelper$switchChannelTheme$1(MediaEnterExitRequestHelper mediaEnterExitRequestHelper, int i3, Continuation<? super MediaEnterExitRequestHelper$switchChannelTheme$1> continuation) {
        super(2, continuation);
        this.this$0 = mediaEnterExitRequestHelper;
        this.$themeType = i3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MediaEnterExitRequestHelper$switchChannelTheme$1(this.this$0, this.$themeType, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        ca caVar;
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
            MediaEnterExitRequestHelper mediaEnterExitRequestHelper = this.this$0;
            int i16 = this.$themeType;
            this.label = 1;
            obj = mediaEnterExitRequestHelper.m1(i16, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        if (((CommonRsp) obj).c()) {
            this.this$0.g1(this.$themeType);
            caVar = this.this$0.modelTrans;
            caVar.k(this.$themeType);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MediaEnterExitRequestHelper$switchChannelTheme$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
