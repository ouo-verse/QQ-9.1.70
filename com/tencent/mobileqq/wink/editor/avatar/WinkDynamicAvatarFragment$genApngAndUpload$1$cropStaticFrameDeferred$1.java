package com.tencent.mobileqq.wink.editor.avatar;

import android.graphics.Rect;
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
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.editor.avatar.WinkDynamicAvatarFragment$genApngAndUpload$1$cropStaticFrameDeferred$1", f = "WinkDynamicAvatarFragment.kt", i = {}, l = {600}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
final class WinkDynamicAvatarFragment$genApngAndUpload$1$cropStaticFrameDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ Rect $videoRect;
    int label;
    final /* synthetic */ WinkDynamicAvatarFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkDynamicAvatarFragment$genApngAndUpload$1$cropStaticFrameDeferred$1(WinkDynamicAvatarFragment winkDynamicAvatarFragment, Rect rect, Continuation<? super WinkDynamicAvatarFragment$genApngAndUpload$1$cropStaticFrameDeferred$1> continuation) {
        super(2, continuation);
        this.this$0 = winkDynamicAvatarFragment;
        this.$videoRect = rect;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkDynamicAvatarFragment$genApngAndUpload$1$cropStaticFrameDeferred$1(this.this$0, this.$videoRect, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
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
            WinkDynamicAvatarFragment winkDynamicAvatarFragment = this.this$0;
            Rect rect = this.$videoRect;
            this.label = 1;
            obj = winkDynamicAvatarFragment.fi(rect, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super String> continuation) {
        return ((WinkDynamicAvatarFragment$genApngAndUpload$1$cropStaticFrameDeferred$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
