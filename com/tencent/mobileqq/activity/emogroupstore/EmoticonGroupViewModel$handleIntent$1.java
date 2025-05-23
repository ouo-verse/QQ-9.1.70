package com.tencent.mobileqq.activity.emogroupstore;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.activity.emogroupstore.EmoticonGroupDataSource;
import com.tencent.mobileqq.activity.emogroupstore.k;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lcom/tencent/mobileqq/activity/emogroupstore/EmoticonGroupDataSource$b;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.activity.emogroupstore.EmoticonGroupViewModel$handleIntent$1", f = "EmoticonGroupViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes10.dex */
public final class EmoticonGroupViewModel$handleIntent$1 extends SuspendLambda implements Function2<EmoticonGroupDataSource.b, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ EmoticonGroupViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmoticonGroupViewModel$handleIntent$1(EmoticonGroupViewModel emoticonGroupViewModel, Continuation<? super EmoticonGroupViewModel$handleIntent$1> continuation) {
        super(2, continuation);
        this.this$0 = emoticonGroupViewModel;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) emoticonGroupViewModel, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        EmoticonGroupViewModel$handleIntent$1 emoticonGroupViewModel$handleIntent$1 = new EmoticonGroupViewModel$handleIntent$1(this.this$0, continuation);
        emoticonGroupViewModel$handleIntent$1.L$0 = obj;
        return emoticonGroupViewModel$handleIntent$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull EmoticonGroupDataSource.b bVar, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((EmoticonGroupViewModel$handleIntent$1) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) bVar, (Object) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        MutableLiveData mUiState;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                EmoticonGroupDataSource.b bVar = (EmoticonGroupDataSource.b) this.L$0;
                mUiState = this.this$0.getMUiState();
                mUiState.setValue(new k.a(bVar));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }
}
