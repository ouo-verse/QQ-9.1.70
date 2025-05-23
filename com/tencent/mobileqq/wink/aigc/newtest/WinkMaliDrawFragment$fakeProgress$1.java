package com.tencent.mobileqq.wink.aigc.newtest;

import android.widget.ProgressBar;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.aigc.newtest.WinkMaliDrawFragment$fakeProgress$1", f = "WinkMaliDrawFragment.kt", i = {0, 0, 0, 0}, l = {151}, m = "invokeSuspend", n = {"interpolator", "it", "beginTime", "totalTime"}, s = {"L$0", "L$1", "J$0", "I$0"})
/* loaded from: classes21.dex */
public final class WinkMaliDrawFragment$fakeProgress$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ WinkMaliDrawFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkMaliDrawFragment$fakeProgress$1(WinkMaliDrawFragment winkMaliDrawFragment, Continuation<? super WinkMaliDrawFragment$fakeProgress$1> continuation) {
        super(2, continuation);
        this.this$0 = winkMaliDrawFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkMaliDrawFragment$fakeProgress$1(this.this$0, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0062  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0058 -> B:5:0x005b). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        long currentTimeMillis;
        LinearOutSlowInInterpolator linearOutSlowInInterpolator;
        WinkMaliDrawFragment$fakeProgress$1 winkMaliDrawFragment$fakeProgress$1;
        ProgressBar progressBar;
        int i3;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i16 = this.label;
        if (i16 != 0) {
            if (i16 == 1) {
                i3 = this.I$0;
                currentTimeMillis = this.J$0;
                progressBar = (ProgressBar) this.L$1;
                linearOutSlowInInterpolator = (LinearOutSlowInInterpolator) this.L$0;
                ResultKt.throwOnFailure(obj);
                winkMaliDrawFragment$fakeProgress$1 = this;
                if (progressBar.getProgress() <= 95) {
                    float currentTimeMillis2 = (((float) (System.currentTimeMillis() - currentTimeMillis)) * 1.0f) / i3;
                    float interpolation = linearOutSlowInInterpolator.getInterpolation(currentTimeMillis2) * 100;
                    com.tencent.xaction.log.b.a("WinkMaliDrawFragment", 1, "[fakeProgress] input=" + currentTimeMillis2 + ", value=" + interpolation);
                    progressBar.setProgress((int) interpolation);
                    if (progressBar.getProgress() <= 95) {
                        winkMaliDrawFragment$fakeProgress$1.L$0 = linearOutSlowInInterpolator;
                        winkMaliDrawFragment$fakeProgress$1.L$1 = progressBar;
                        winkMaliDrawFragment$fakeProgress$1.J$0 = currentTimeMillis;
                        winkMaliDrawFragment$fakeProgress$1.I$0 = i3;
                        winkMaliDrawFragment$fakeProgress$1.label = 1;
                        if (DelayKt.delay(200L, winkMaliDrawFragment$fakeProgress$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        if (progressBar.getProgress() <= 95) {
                        }
                    }
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        LinearOutSlowInInterpolator linearOutSlowInInterpolator2 = new LinearOutSlowInInterpolator();
        currentTimeMillis = System.currentTimeMillis();
        ProgressBar progressBar2 = this.this$0.progressBar;
        if (progressBar2 != null) {
            linearOutSlowInInterpolator = linearOutSlowInInterpolator2;
            winkMaliDrawFragment$fakeProgress$1 = this;
            progressBar = progressBar2;
            i3 = 20000;
            if (progressBar.getProgress() <= 95) {
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkMaliDrawFragment$fakeProgress$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
