package com.tencent.mobileqq.aio.title;

import com.tencent.mobileqq.aio.title.AIOTitleUIState;
import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.adapter.api.IAIOTitleApi;
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
@DebugMetadata(c = "com.tencent.mobileqq.aio.title.AIOTitleVM$getData$1", f = "AIOTitleVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes11.dex */
public final class AIOTitleVM$getData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ boolean $needTransparentBg;
    int label;
    final /* synthetic */ AIOTitleVM this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOTitleVM$getData$1(AIOTitleVM aIOTitleVM, boolean z16, Continuation<? super AIOTitleVM$getData$1> continuation) {
        super(2, continuation);
        this.this$0 = aIOTitleVM;
        this.$needTransparentBg = z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, aIOTitleVM, Boolean.valueOf(z16), continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new AIOTitleVM$getData$1(this.this$0, this.$needTransparentBg, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0041  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        boolean z16;
        boolean K;
        boolean z17;
        boolean J;
        boolean L;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                int i3 = 0;
                if (((IAIOTitleApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOTitleApi.class)).isSupportUnreadCount((com.tencent.aio.api.runtime.a) this.this$0.getMContext())) {
                    L = this.this$0.L();
                    if (L) {
                        z16 = true;
                        if (z16) {
                            i3 = this.this$0.w(null);
                        }
                        boolean x16 = AIOUtil.f194084a.x(((com.tencent.aio.api.runtime.a) this.this$0.getMContext()).g().r());
                        AIOTitleVM aIOTitleVM = this.this$0;
                        K = aIOTitleVM.K();
                        z17 = this.this$0.mIsSelectedMode;
                        boolean z18 = this.$needTransparentBg;
                        J = this.this$0.J();
                        aIOTitleVM.updateUI(new AIOTitleUIState.UpdateData(new am(K, i3, x16, z17, z18, !J)));
                        return Unit.INSTANCE;
                    }
                }
                z16 = false;
                if (z16) {
                }
                boolean x162 = AIOUtil.f194084a.x(((com.tencent.aio.api.runtime.a) this.this$0.getMContext()).g().r());
                AIOTitleVM aIOTitleVM2 = this.this$0;
                K = aIOTitleVM2.K();
                z17 = this.this$0.mIsSelectedMode;
                boolean z182 = this.$needTransparentBg;
                J = this.this$0.J();
                aIOTitleVM2.updateUI(new AIOTitleUIState.UpdateData(new am(K, i3, x162, z17, z182, !J)));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AIOTitleVM$getData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
