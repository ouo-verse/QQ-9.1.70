package com.tencent.mobileqq.nearbypro.utils;

import android.widget.ImageView;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.nearbypro.base.ILog;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.qroute.route.MonitorKt$runOnUI$2", f = "Monitor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes15.dex */
public final class InnerLoader$picLoadListener$1$1$invokeSuspend$$inlined$checkTargetOnUI$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Option $option$inlined;
    int label;
    private CoroutineScope p$;
    final /* synthetic */ InnerLoader this$0;
    final /* synthetic */ InnerLoader this$0$inline_fun;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InnerLoader$picLoadListener$1$1$invokeSuspend$$inlined$checkTargetOnUI$1(Continuation continuation, InnerLoader innerLoader, InnerLoader innerLoader2, InnerLoader innerLoader3, Option option) {
        super(2, continuation);
        this.this$0$inline_fun = innerLoader;
        this.this$0 = innerLoader2;
        this.$option$inlined = option;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkParameterIsNotNull(completion, "completion");
        InnerLoader innerLoader = this.this$0$inline_fun;
        InnerLoader innerLoader2 = this.this$0;
        InnerLoader$picLoadListener$1$1$invokeSuspend$$inlined$checkTargetOnUI$1 innerLoader$picLoadListener$1$1$invokeSuspend$$inlined$checkTargetOnUI$1 = new InnerLoader$picLoadListener$1$1$invokeSuspend$$inlined$checkTargetOnUI$1(completion, innerLoader, innerLoader2, innerLoader2, this.$option$inlined);
        innerLoader$picLoadListener$1$1$invokeSuspend$$inlined$checkTargetOnUI$1.p$ = (CoroutineScope) obj;
        return innerLoader$picLoadListener$1$1$invokeSuspend$$inlined$checkTargetOnUI$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((InnerLoader$picLoadListener$1$1$invokeSuspend$$inlined$checkTargetOnUI$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        boolean n3;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ImageView targetView = this.this$0$inline_fun.getTargetView();
            boolean z16 = false;
            if (targetView != null) {
                InnerLoader innerLoader = this.this$0$inline_fun;
                n3 = innerLoader.n(targetView, innerLoader.getIndexNode());
                if (n3) {
                    z16 = true;
                }
            }
            if (z16) {
                InnerLoader innerLoader2 = this.this$0;
                ILog.Level level = ILog.Level.ERROR;
                com.tencent.mobileqq.nearbypro.base.j.c().b("StImageLoader", level, innerLoader2.logPrefix + ((Object) "picLoadListener not a same stImage"));
            } else {
                ImageView targetView2 = this.this$0.getTargetView();
                if (targetView2 != null) {
                    targetView2.setTag(R.id.zoo, this.$option$inlined.getLocalPath());
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
