package com.tencent.mobileqq.exportfile.fragment.rootpage.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.exportfile.fragment.rootpage.view.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
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

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.exportfile.fragment.rootpage.viewmodel.RootPageViewModel$loadRootPageData$1", f = "RootPageViewModel.kt", i = {}, l = {43}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes12.dex */
public final class RootPageViewModel$loadRootPageData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    int label;
    final /* synthetic */ RootPageViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RootPageViewModel$loadRootPageData$1(RootPageViewModel rootPageViewModel, Continuation<? super RootPageViewModel$loadRootPageData$1> continuation) {
        super(2, continuation);
        this.this$0 = rootPageViewModel;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) rootPageViewModel, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new RootPageViewModel$loadRootPageData$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
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
                Function2<Integer, List<a>, Unit> function2 = new Function2<Integer, List<a>, Unit>() { // from class: com.tencent.mobileqq.exportfile.fragment.rootpage.viewmodel.RootPageViewModel$loadRootPageData$1.1
                    static IPatchRedirector $redirector_;

                    {
                        super(2);
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RootPageViewModel.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num, List<a> list) {
                        invoke(num.intValue(), list);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i16, @NotNull List<a> dataList) {
                        MutableLiveData mUiState;
                        MutableLiveData mUiState2;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, i16, (Object) dataList);
                            return;
                        }
                        Intrinsics.checkNotNullParameter(dataList, "dataList");
                        QLog.i("RootPageViewModel", 1, "getRootPageContent result: " + i16 + ", " + dataList);
                        if (i16 == 0) {
                            mUiState2 = RootPageViewModel.this.getMUiState();
                            mUiState2.setValue(new a.b(dataList));
                        } else {
                            mUiState = RootPageViewModel.this.getMUiState();
                            mUiState.setValue(new a.C7514a(i16));
                        }
                    }
                };
                this.label = 1;
                if (RootPageRepositoryKt.a(function2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((RootPageViewModel$loadRootPageData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
