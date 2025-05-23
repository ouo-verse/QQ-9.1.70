package com.tencent.mobileqq.guild.feed.api.impl;

import androidx.core.util.Consumer;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.guild.feed.api.FeedEditorCheckItemResult;
import com.tencent.util.QQToastUtil;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.api.impl.GuildFeedLauncherHelper$makeCheckItemListener$1$onCheckResult$3", f = "GuildShareToFeedApiImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class GuildFeedLauncherHelper$makeCheckItemListener$1$onCheckResult$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Consumer<FeedEditorCheckItemResult> $fallbackCheckResultConsumer;
    final /* synthetic */ FeedEditorCheckItemResult $result;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFeedLauncherHelper$makeCheckItemListener$1$onCheckResult$3(FeedEditorCheckItemResult feedEditorCheckItemResult, Consumer<FeedEditorCheckItemResult> consumer, Continuation<? super GuildFeedLauncherHelper$makeCheckItemListener$1$onCheckResult$3> continuation) {
        super(2, continuation);
        this.$result = feedEditorCheckItemResult;
        this.$fallbackCheckResultConsumer = consumer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildFeedLauncherHelper$makeCheckItemListener$1$onCheckResult$3(this.$result, this.$fallbackCheckResultConsumer, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            int what = this.$result.getWhat();
            if (what != 5 && what != 6) {
                this.$fallbackCheckResultConsumer.accept(this.$result);
            } else {
                QQToastUtil.showQQToast(0, ForwardRecentActivity.NOT_SUPPORT_SHARE_TO_GUILD);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildFeedLauncherHelper$makeCheckItemListener$1$onCheckResult$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
