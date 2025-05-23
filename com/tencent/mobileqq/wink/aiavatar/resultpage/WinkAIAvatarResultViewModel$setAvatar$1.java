package com.tencent.mobileqq.wink.aiavatar.resultpage;

import android.graphics.Bitmap;
import com.tencent.mobileqq.utils.FileUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.aiavatar.resultpage.WinkAIAvatarResultViewModel$setAvatar$1", f = "WinkAIAvatarResultViewModel.kt", i = {}, l = {504}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class WinkAIAvatarResultViewModel$setAvatar$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bitmap $bitmap;
    final /* synthetic */ Boolean $syncQZone;
    int label;
    final /* synthetic */ WinkAIAvatarResultViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkAIAvatarResultViewModel$setAvatar$1(WinkAIAvatarResultViewModel winkAIAvatarResultViewModel, Bitmap bitmap, Boolean bool, Continuation<? super WinkAIAvatarResultViewModel$setAvatar$1> continuation) {
        super(2, continuation);
        this.this$0 = winkAIAvatarResultViewModel;
        this.$bitmap = bitmap;
        this.$syncQZone = bool;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkAIAvatarResultViewModel$setAvatar$1(this.this$0, this.$bitmap, this.$syncQZone, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        String l26;
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
            l26 = this.this$0.l2();
            String str = l26 + System.nanoTime() + ".jpg";
            com.tencent.mobileqq.wink.utils.f.v(str, this.$bitmap, Bitmap.CompressFormat.JPEG, 100);
            Bitmap bitmap = this.$bitmap;
            if (bitmap != null) {
                bitmap.recycle();
            }
            boolean z16 = false;
            if (!FileUtils.fileExists(str)) {
                w53.b.c("WinkAIAvatarResultViewModel", "setAvatar file not exists: " + str);
                this.this$0.B2().postValue(Boxing.boxBoolean(false));
                return Unit.INSTANCE;
            }
            WinkAIAvatarResultViewModel winkAIAvatarResultViewModel = this.this$0;
            Boolean bool = this.$syncQZone;
            if (bool != null) {
                z16 = bool.booleanValue();
            }
            this.label = 1;
            obj = winkAIAvatarResultViewModel.Q2(str, z16, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        this.this$0.B2().postValue(Boxing.boxBoolean(((Boolean) obj).booleanValue()));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkAIAvatarResultViewModel$setAvatar$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
