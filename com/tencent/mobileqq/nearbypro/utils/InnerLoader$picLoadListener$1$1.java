package com.tencent.mobileqq.nearbypro.utils;

import android.os.Looper;
import android.widget.ImageView;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.nearbypro.utils.InnerLoader$picLoadListener$1$1", f = "StImageLoader.kt", i = {}, l = {170}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes15.dex */
public final class InnerLoader$picLoadListener$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Option $option;
    final /* synthetic */ LoadState $state;
    int label;
    final /* synthetic */ InnerLoader this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InnerLoader$picLoadListener$1$1(LoadState loadState, InnerLoader innerLoader, Option option, Continuation<? super InnerLoader$picLoadListener$1$1> continuation) {
        super(2, continuation);
        this.$state = loadState;
        this.this$0 = innerLoader;
        this.$option = option;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new InnerLoader$picLoadListener$1$1(this.$state, this.this$0, this.$option, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0069, code lost:
    
        if (r11 == true) goto L21;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        boolean n3;
        ILog.Level level;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        boolean z16 = true;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            if (this.$state.isFinishSuccess()) {
                InnerLoader innerLoader = this.this$0;
                Option option = this.$option;
                Thread currentThread = Thread.currentThread();
                Intrinsics.checkExpressionValueIsNotNull(Looper.getMainLooper(), "Looper.getMainLooper()");
                if (!Intrinsics.areEqual(currentThread, r1.getThread())) {
                    MainCoroutineDispatcher main = Dispatchers.getMain();
                    InnerLoader$picLoadListener$1$1$invokeSuspend$$inlined$checkTargetOnUI$1 innerLoader$picLoadListener$1$1$invokeSuspend$$inlined$checkTargetOnUI$1 = new InnerLoader$picLoadListener$1$1$invokeSuspend$$inlined$checkTargetOnUI$1(null, innerLoader, innerLoader, innerLoader, option);
                    this.label = 1;
                    if (BuildersKt.withContext(main, innerLoader$picLoadListener$1$1$invokeSuspend$$inlined$checkTargetOnUI$1, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    ImageView targetView = innerLoader.getTargetView();
                    if (targetView != null) {
                        n3 = innerLoader.n(targetView, innerLoader.getIndexNode());
                    }
                    z16 = false;
                    if (z16) {
                        ILog.Level level2 = ILog.Level.ERROR;
                        com.tencent.mobileqq.nearbypro.base.j.c().b("StImageLoader", level2, innerLoader.logPrefix + ((Object) "picLoadListener not a same stImage"));
                    } else {
                        ImageView targetView2 = innerLoader.getTargetView();
                        if (targetView2 != null) {
                            targetView2.setTag(R.id.zoo, option.getLocalPath());
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
        InnerLoader innerLoader2 = this.this$0;
        if (this.$state.isFinishError()) {
            level = ILog.Level.ERROR;
        } else {
            level = ILog.Level.INFO;
        }
        LoadState loadState = this.$state;
        Option option2 = this.$option;
        com.tencent.mobileqq.nearbypro.base.j.c().b("StImageLoader", level, innerLoader2.logPrefix + ((Object) ("picLoadListener state:" + loadState + " option:" + option2 + ".")));
        IPicLoadStateListener listener = this.this$0.getListener();
        if (listener != null) {
            listener.onStateChange(this.$state, this.$option);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((InnerLoader$picLoadListener$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
