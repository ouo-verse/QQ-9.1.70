package com.tencent.qne.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qne.model.DependencyLibrary;
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

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/qne/util/c;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "com.tencent.qne.util.SoLoader$load$2$jobs$1$1", f = "SoLoader.kt", i = {}, l = {38}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes22.dex */
final class SoLoader$load$2$jobs$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super c>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ DependencyLibrary $it;
    int label;
    final /* synthetic */ SoLoader this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SoLoader$load$2$jobs$1$1(DependencyLibrary dependencyLibrary, SoLoader soLoader, Continuation<? super SoLoader$load$2$jobs$1$1> continuation) {
        super(2, continuation);
        this.$it = dependencyLibrary;
        this.this$0 = soLoader;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, dependencyLibrary, soLoader, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new SoLoader$load$2$jobs$1$1(this.$it, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        com.tencent.qne.delegate.d dVar;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
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
                String shiplyResourceId = this.$it.getShiplyResourceId();
                dVar = this.this$0.shiply;
                Long boxLong = Boxing.boxLong(this.$it.getSpecificTaskId());
                str = this.this$0.unzipPath;
                ShiplySoDownloader shiplySoDownloader = new ShiplySoDownloader(dVar, shiplyResourceId, boxLong, str);
                this.label = 1;
                obj = ShiplySoDownloader.d(shiplySoDownloader, false, this, 1, null);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return obj;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super c> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((SoLoader$load$2$jobs$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
