package com.tencent.mobileqq.wink.aiavatar.picker;

import android.content.Context;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.edit.manager.ak;
import com.tencent.mobileqq.wink.l;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.aiavatar.picker.WinkAIAvatarMediaPickerViewModel$jumpToResultFragment$2", f = "WinkAIAvatarMediaPickerViewModel.kt", i = {}, l = {81}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class WinkAIAvatarMediaPickerViewModel$jumpToResultFragment$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Boolean, Unit> $callback;
    final /* synthetic */ Context $context;
    final /* synthetic */ ArrayList<LocalMediaInfo> $images;
    int label;
    final /* synthetic */ WinkAIAvatarMediaPickerViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WinkAIAvatarMediaPickerViewModel$jumpToResultFragment$2(WinkAIAvatarMediaPickerViewModel winkAIAvatarMediaPickerViewModel, Context context, ArrayList<LocalMediaInfo> arrayList, Function1<? super Boolean, Unit> function1, Continuation<? super WinkAIAvatarMediaPickerViewModel$jumpToResultFragment$2> continuation) {
        super(2, continuation);
        this.this$0 = winkAIAvatarMediaPickerViewModel;
        this.$context = context;
        this.$images = arrayList;
        this.$callback = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkAIAvatarMediaPickerViewModel$jumpToResultFragment$2(this.this$0, this.$context, this.$images, this.$callback, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        List W1;
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
            WinkEditorResourceManager a16 = WinkEditorResourceManager.a1();
            Intrinsics.checkNotNullExpressionValue(a16, "getInstance()");
            this.label = 1;
            obj = ak.h(a16, "FACE_AGENT", null, this, 2, null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        if (!((Boolean) obj).booleanValue()) {
            w53.b.c("WinkAIAvatarMediaPickerViewModel", "detectFace bundle fetch failed");
            WinkAIAvatarMediaPickerViewModel winkAIAvatarMediaPickerViewModel = this.this$0;
            Context context = this.$context;
            ArrayList<LocalMediaInfo> arrayList = this.$images;
            ArrayList arrayList2 = new ArrayList();
            W1 = this.this$0.W1(new ArrayList());
            WinkAIAvatarMediaPickerViewModel.b2(winkAIAvatarMediaPickerViewModel, context, arrayList, arrayList2, W1, null, 16, null);
            return Unit.INSTANCE;
        }
        l.f();
        this.this$0.T1(this.$context, this.$images, this.$callback);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkAIAvatarMediaPickerViewModel$jumpToResultFragment$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
