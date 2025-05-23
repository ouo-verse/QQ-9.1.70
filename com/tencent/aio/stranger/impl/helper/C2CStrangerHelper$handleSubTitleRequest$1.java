package com.tencent.aio.stranger.impl.helper;

import com.tencent.mobileqq.aio.event.AIOTitleEvent;
import com.tencent.mobileqq.aio.title.ai;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.interceptor.e;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.aio.stranger.impl.helper.C2CStrangerHelper$handleSubTitleRequest$1", f = "C2CStrangerHelper.kt", i = {}, l = {195}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class C2CStrangerHelper$handleSubTitleRequest$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    int label;
    final /* synthetic */ C2CStrangerHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2CStrangerHelper$handleSubTitleRequest$1(C2CStrangerHelper c2CStrangerHelper, Continuation<? super C2CStrangerHelper$handleSubTitleRequest$1> continuation) {
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
        return new C2CStrangerHelper$handleSubTitleRequest$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        e k3;
        com.tencent.aio.api.runtime.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            com.tencent.aio.api.runtime.a aVar2 = null;
            if (i3 != 0) {
                if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                k3 = this.this$0.k();
                C2CStrangerHelper$handleSubTitleRequest$1$source$1 c2CStrangerHelper$handleSubTitleRequest$1$source$1 = new C2CStrangerHelper$handleSubTitleRequest$1$source$1(this.this$0, null);
                this.label = 1;
                obj = BuildersKt.withContext(k3, c2CStrangerHelper$handleSubTitleRequest$1$source$1, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            String str = (String) obj;
            if (QLog.isColorLevel()) {
                QLog.d("C2CStrangerHelper", 2, "handleSubTitleRequest end: " + str);
            }
            if (str != null) {
                aVar = this.this$0.aioContext;
                if (aVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("aioContext");
                } else {
                    aVar2 = aVar;
                }
                aVar2.e().h(new AIOTitleEvent.SubTitleResponseEvent(new ai(null, null, null, str, "5")));
            }
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((C2CStrangerHelper$handleSubTitleRequest$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
