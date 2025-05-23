package com.tencent.guild.aio.msglist.giphy.util;

import com.giphy.sdk.core.models.Media;
import com.tencent.guild.aio.msglist.giphy.GuildGiphyCacheManager;
import com.tencent.qqnt.kernel.nativeinterface.GiphyElement;
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

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/giphy/sdk/core/models/Media;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.guild.aio.msglist.giphy.util.GuildGiphyComponentUtilKt$applyAIOMsgGiphyView$1$1$cache$1", f = "GuildGiphyComponentUtil.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class GuildGiphyComponentUtilKt$applyAIOMsgGiphyView$1$1$cache$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Media>, Object> {
    final /* synthetic */ GiphyElement $giphyElement;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildGiphyComponentUtilKt$applyAIOMsgGiphyView$1$1$cache$1(GiphyElement giphyElement, Continuation<? super GuildGiphyComponentUtilKt$applyAIOMsgGiphyView$1$1$cache$1> continuation) {
        super(2, continuation);
        this.$giphyElement = giphyElement;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildGiphyComponentUtilKt$applyAIOMsgGiphyView$1$1$cache$1(this.$giphyElement, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            GuildGiphyCacheManager guildGiphyCacheManager = GuildGiphyCacheManager.f111286a;
            String str = this.$giphyElement.f359177id;
            Intrinsics.checkNotNullExpressionValue(str, "giphyElement.id");
            return guildGiphyCacheManager.d(str);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Media> continuation) {
        return ((GuildGiphyComponentUtilKt$applyAIOMsgGiphyView$1$1$cache$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
