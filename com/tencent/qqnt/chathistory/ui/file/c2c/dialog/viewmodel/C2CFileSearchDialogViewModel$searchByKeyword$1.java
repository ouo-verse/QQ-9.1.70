package com.tencent.qqnt.chathistory.ui.file.c2c.dialog.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.chathistory.ui.file.c2c.dialog.viewmodel.b;
import com.tencent.qqnt.chathistory.util.d;
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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/file/c2c/dialog/data/a;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.qqnt.chathistory.ui.file.c2c.dialog.viewmodel.C2CFileSearchDialogViewModel$searchByKeyword$1", f = "C2CFileSearchDialogViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes23.dex */
public final class C2CFileSearchDialogViewModel$searchByKeyword$1 extends SuspendLambda implements Function2<com.tencent.qqnt.chathistory.ui.file.c2c.dialog.data.a, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ C2CFileSearchDialogViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2CFileSearchDialogViewModel$searchByKeyword$1(C2CFileSearchDialogViewModel c2CFileSearchDialogViewModel, Continuation<? super C2CFileSearchDialogViewModel$searchByKeyword$1> continuation) {
        super(2, continuation);
        this.this$0 = c2CFileSearchDialogViewModel;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) c2CFileSearchDialogViewModel, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        C2CFileSearchDialogViewModel$searchByKeyword$1 c2CFileSearchDialogViewModel$searchByKeyword$1 = new C2CFileSearchDialogViewModel$searchByKeyword$1(this.this$0, continuation);
        c2CFileSearchDialogViewModel$searchByKeyword$1.L$0 = obj;
        return c2CFileSearchDialogViewModel$searchByKeyword$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull com.tencent.qqnt.chathistory.ui.file.c2c.dialog.data.a aVar, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((C2CFileSearchDialogViewModel$searchByKeyword$1) create(aVar, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar, (Object) continuation);
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
                com.tencent.qqnt.chathistory.ui.file.c2c.dialog.data.a aVar = (com.tencent.qqnt.chathistory.ui.file.c2c.dialog.data.a) this.L$0;
                d.f354054a.a("C2CFileSearchDialogViewModel", "searchByKeyword  result " + aVar);
                mUiState = this.this$0.getMUiState();
                mUiState.setValue(new b.a(aVar));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }
}
