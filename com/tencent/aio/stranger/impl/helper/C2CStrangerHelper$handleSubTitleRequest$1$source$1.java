package com.tencent.aio.stranger.impl.helper;

import com.tencent.aio.stranger.api.IStrangerAIOApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
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
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.aio.stranger.impl.helper.C2CStrangerHelper$handleSubTitleRequest$1$source$1", f = "C2CStrangerHelper.kt", i = {}, l = {196}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
final class C2CStrangerHelper$handleSubTitleRequest$1$source$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    static IPatchRedirector $redirector_;
    int label;
    final /* synthetic */ C2CStrangerHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2CStrangerHelper$handleSubTitleRequest$1$source$1(C2CStrangerHelper c2CStrangerHelper, Continuation<? super C2CStrangerHelper$handleSubTitleRequest$1$source$1> continuation) {
        super(2, continuation);
        this.this$0 = c2CStrangerHelper;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) c2CStrangerHelper, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new C2CStrangerHelper$handleSubTitleRequest$1$source$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        com.tencent.aio.api.runtime.a aVar;
        com.tencent.aio.api.runtime.a aVar2;
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
                IStrangerAIOApi iStrangerAIOApi = (IStrangerAIOApi) QRoute.api(IStrangerAIOApi.class);
                aVar = this.this$0.aioContext;
                com.tencent.aio.api.runtime.a aVar3 = null;
                if (aVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("aioContext");
                    aVar = null;
                }
                int e16 = aVar.g().r().c().e();
                aVar2 = this.this$0.aioContext;
                if (aVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("aioContext");
                } else {
                    aVar3 = aVar2;
                }
                String j3 = aVar3.g().r().c().j();
                this.label = 1;
                obj = iStrangerAIOApi.getStrangerFromDescription(e16, j3, this);
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
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super String> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((C2CStrangerHelper$handleSubTitleRequest$1$source$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
