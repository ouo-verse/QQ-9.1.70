package com.tencent.guild.aio.msglist.giphy.util;

import android.graphics.drawable.Drawable;
import com.giphy.sdk.core.models.Media;
import com.giphy.sdk.core.models.enums.RenditionType;
import com.giphy.sdk.ui.views.GPHMediaView;
import com.giphy.sdk.ui.views.GifView;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.guild.aio.msglist.giphy.util.GuildGiphyComponentUtilKt$applyAIOMsgGiphyView$1$1", f = "GuildGiphyComponentUtil.kt", i = {}, l = {60}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class GuildGiphyComponentUtilKt$applyAIOMsgGiphyView$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ GiphyElement $giphyElement;
    final /* synthetic */ GPHMediaView $ivPic;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildGiphyComponentUtilKt$applyAIOMsgGiphyView$1$1(GiphyElement giphyElement, GPHMediaView gPHMediaView, Continuation<? super GuildGiphyComponentUtilKt$applyAIOMsgGiphyView$1$1> continuation) {
        super(2, continuation);
        this.$giphyElement = giphyElement;
        this.$ivPic = gPHMediaView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildGiphyComponentUtilKt$applyAIOMsgGiphyView$1$1(this.$giphyElement, this.$ivPic, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        Unit unit = null;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            i.d dVar = i.d.f261782e;
            GuildGiphyComponentUtilKt$applyAIOMsgGiphyView$1$1$cache$1 guildGiphyComponentUtilKt$applyAIOMsgGiphyView$1$1$cache$1 = new GuildGiphyComponentUtilKt$applyAIOMsgGiphyView$1$1$cache$1(this.$giphyElement, null);
            this.label = 1;
            obj = CorountineFunKt.i(dVar, null, null, guildGiphyComponentUtilKt$applyAIOMsgGiphyView$1$1$cache$1, this, 6, null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        Media media = (Media) obj;
        if (media != null) {
            GifView.setMedia$default(this.$ivPic, media, (RenditionType) null, (Drawable) null, 6, (Object) null);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            GiphyElement giphyElement = this.$giphyElement;
            Intrinsics.checkNotNullExpressionValue(giphyElement, "giphyElement");
            GuildGiphyComponentUtilKt.c(giphyElement, this.$ivPic);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildGiphyComponentUtilKt$applyAIOMsgGiphyView$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
