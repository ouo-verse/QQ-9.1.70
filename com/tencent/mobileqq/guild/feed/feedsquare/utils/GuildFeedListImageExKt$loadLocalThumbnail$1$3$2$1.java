package com.tencent.mobileqq.guild.feed.feedsquare.utils;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStVideo;
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
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.feedsquare.utils.GuildFeedListImageExKt$loadLocalThumbnail$1$3$2$1", f = "GuildFeedListImageEx.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class GuildFeedListImageExKt$loadLocalThumbnail$1$3$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bitmap $it;
    final /* synthetic */ GProStVideo $this_with;
    final /* synthetic */ ImageView $view;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFeedListImageExKt$loadLocalThumbnail$1$3$2$1(ImageView imageView, Bitmap bitmap, GProStVideo gProStVideo, Continuation<? super GuildFeedListImageExKt$loadLocalThumbnail$1$3$2$1> continuation) {
        super(2, continuation);
        this.$view = imageView;
        this.$it = bitmap;
        this.$this_with = gProStVideo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildFeedListImageExKt$loadLocalThumbnail$1$3$2$1(this.$view, this.$it, this.$this_with, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        int i3;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.$view.setImageBitmap(this.$it);
            ImageView imageView = this.$view;
            i3 = GuildFeedListImageExKt.f219283b;
            imageView.setTag(i3, this.$this_with.playUrl);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildFeedListImageExKt$loadLocalThumbnail$1$3$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
