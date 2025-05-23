package com.tencent.mobileqq.onlinestatus.shareposter;

import android.graphics.Bitmap;
import com.tencent.mobileqq.vas.qid.QidPagView;
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
@DebugMetadata(c = "com.tencent.mobileqq.onlinestatus.shareposter.OnlineStatusShareHelper$initShareActionSheetItemList$1$2", f = "OnlineStatusShareHelper.kt", i = {}, l = {QidPagView.DESIGN_PAG_WIDTH}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes16.dex */
public final class OnlineStatusShareHelper$initShareActionSheetItemList$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ e $shareActionSheet;
    int label;
    final /* synthetic */ OnlineStatusShareHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnlineStatusShareHelper$initShareActionSheetItemList$1$2(OnlineStatusShareHelper onlineStatusShareHelper, e eVar, Continuation<? super OnlineStatusShareHelper$initShareActionSheetItemList$1$2> continuation) {
        super(2, continuation);
        this.this$0 = onlineStatusShareHelper;
        this.$shareActionSheet = eVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new OnlineStatusShareHelper$initShareActionSheetItemList$1$2(this.this$0, this.$shareActionSheet, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Bitmap G;
        Object R;
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
            this.this$0.U();
            OnlineStatusShareHelper onlineStatusShareHelper = this.this$0;
            G = onlineStatusShareHelper.G(this.$shareActionSheet);
            this.label = 1;
            R = onlineStatusShareHelper.R(G, this);
            if (R == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        this.this$0.A();
        this.this$0.B();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((OnlineStatusShareHelper$initShareActionSheetItemList$1$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
