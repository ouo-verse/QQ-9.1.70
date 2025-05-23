package com.tencent.mobileqq.wink.editor.avatar;

import android.graphics.Rect;
import com.tencent.videocut.model.ResourceModel;
import com.tencent.videocut.model.SizeF;
import kotlin.Metadata;
import kotlin.Pair;
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
import org.light.lightAssetKit.components.Size;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/Pair;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.editor.avatar.WinkDynamicAvatarFragment$genApngAndUpload$1$genApngDeferred$1", f = "WinkDynamicAvatarFragment.kt", i = {}, l = {597}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
final class WinkDynamicAvatarFragment$genApngAndUpload$1$genApngDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends String, ? extends String>>, Object> {
    final /* synthetic */ ResourceModel $resource;
    final /* synthetic */ Rect $videoRect;
    final /* synthetic */ SizeF $videoSize;
    int label;
    final /* synthetic */ WinkDynamicAvatarFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkDynamicAvatarFragment$genApngAndUpload$1$genApngDeferred$1(WinkDynamicAvatarFragment winkDynamicAvatarFragment, SizeF sizeF, Rect rect, ResourceModel resourceModel, Continuation<? super WinkDynamicAvatarFragment$genApngAndUpload$1$genApngDeferred$1> continuation) {
        super(2, continuation);
        this.this$0 = winkDynamicAvatarFragment;
        this.$videoSize = sizeF;
        this.$videoRect = rect;
        this.$resource = resourceModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkDynamicAvatarFragment$genApngAndUpload$1$genApngDeferred$1(this.this$0, this.$videoSize, this.$videoRect, this.$resource, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Pair<? extends String, ? extends String>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Pair<String, String>>) continuation);
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
            SizeF sizeF = this.$videoSize;
            Size size = new Size((int) sizeF.width, (int) sizeF.height);
            Rect rect = this.$videoRect;
            long j3 = this.$resource.sourceDuration;
            this.label = 1;
            obj = winkDynamicAvatarFragment.hi(size, rect, j3, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }

    @Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Pair<String, String>> continuation) {
        return ((WinkDynamicAvatarFragment$genApngAndUpload$1$genApngDeferred$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
