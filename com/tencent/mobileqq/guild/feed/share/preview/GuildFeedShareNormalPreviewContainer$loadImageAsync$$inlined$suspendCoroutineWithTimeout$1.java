package com.tencent.mobileqq.guild.feed.share.preview;

import android.widget.ImageView;
import com.tencent.mobileqq.guild.feed.share.preview.GuildFeedShareNormalPreviewContainer;
import com.tencent.mobileqq.guild.picload.e;
import com.tencent.mobileqq.guild.util.v;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.share.preview.GuildFeedShareNormalPreviewContainer$loadImageAsync$$inlined$suspendCoroutineWithTimeout$1", f = "GuildFeedShareNormalPreviewContainer.kt", i = {}, l = {22}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class GuildFeedShareNormalPreviewContainer$loadImageAsync$$inlined$suspendCoroutineWithTimeout$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ri1.a>, Object> {
    final /* synthetic */ ImageView $imageView$inlined;
    final /* synthetic */ String $url$inlined;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFeedShareNormalPreviewContainer$loadImageAsync$$inlined$suspendCoroutineWithTimeout$1(Continuation continuation, String str, ImageView imageView) {
        super(2, continuation);
        this.$url$inlined = str;
        this.$imageView$inlined = imageView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildFeedShareNormalPreviewContainer$loadImageAsync$$inlined$suspendCoroutineWithTimeout$1(continuation, this.$url$inlined, this.$imageView$inlined);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Continuation intercepted;
        Object coroutine_suspended2;
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
            this.label = 1;
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(this);
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
            cancellableContinuationImpl.initCancellability();
            e.a().f(v.d(this.$url$inlined, this.$imageView$inlined, null, null, 12, null).setLoadingDrawable(com.tencent.mobileqq.urldrawable.b.f306350a), new GuildFeedShareNormalPreviewContainer.b(cancellableContinuationImpl, this.$imageView$inlined));
            obj = cancellableContinuationImpl.getResult();
            coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (obj == coroutine_suspended2) {
                DebugProbes.probeCoroutineSuspended(this);
            }
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super ri1.a> continuation) {
        return ((GuildFeedShareNormalPreviewContainer$loadImageAsync$$inlined$suspendCoroutineWithTimeout$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
