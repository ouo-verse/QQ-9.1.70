package com.tencent.qqnt.base.mvi;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.base.mvi.a;
import com.tencent.qqnt.base.mvi.b;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u00020\u0005B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0001H&\u00a2\u0006\u0004\b\b\u0010\tJ\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\nJ\u001b\u0010\f\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0001H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u000e\u001a\u00020\u0007H\u0014R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R \u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\n8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00028\u00018&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qqnt/base/mvi/BaseViewModel;", "Lcom/tencent/qqnt/base/mvi/a;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/qqnt/base/mvi/b;", "I", "Landroidx/lifecycle/ViewModel;", "userIntent", "", "handleIntent", "(Lcom/tencent/qqnt/base/mvi/b;)V", "Landroidx/lifecycle/MutableLiveData;", "obtainUiState", "sendUserIntent", "(Lcom/tencent/qqnt/base/mvi/b;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCleared", "Lkotlinx/coroutines/flow/MutableStateFlow;", "i", "Lkotlinx/coroutines/flow/MutableStateFlow;", "_userIntentFlow", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "getMUiState", "()Landroidx/lifecycle/MutableLiveData;", "mUiState", "getMNoneValueIntent", "()Lcom/tencent/qqnt/base/mvi/b;", "mNoneValueIntent", "<init>", "()V", "ntui_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public abstract class BaseViewModel<S extends a, I extends b> extends ViewModel {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableStateFlow<I> _userIntentFlow;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<S> mUiState;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0006\u001a\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0003*\u00020\u00022\u0006\u0010\u0004\u001a\u00028\u0001H\u008a@"}, d2 = {"Lcom/tencent/qqnt/base/mvi/a;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/qqnt/base/mvi/b;", "I", "userIntent", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.qqnt.base.mvi.BaseViewModel$1", f = "BaseViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.qqnt.base.mvi.BaseViewModel$1, reason: invalid class name */
    /* loaded from: classes23.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<I, Continuation<? super Unit>, Object> {
        static IPatchRedirector $redirector_;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ BaseViewModel<S, I> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(BaseViewModel<S, I> baseViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = baseViewModel;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseViewModel, (Object) continuation);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
            }
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull I i3, @Nullable Continuation<? super Unit> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AnonymousClass1) create(i3, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) i3, (Object) continuation);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    b bVar = (b) this.L$0;
                    System.out.println((Object) ("userIntentFlow onEach:" + bVar));
                    if (bVar != null) {
                        this.this$0.handleIntent(bVar);
                    }
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }
    }

    public BaseViewModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        MutableStateFlow<I> MutableStateFlow = StateFlowKt.MutableStateFlow(getMNoneValueIntent());
        this._userIntentFlow = MutableStateFlow;
        this.mUiState = new MutableLiveData<>();
        FlowKt.launchIn(FlowKt.onEach(MutableStateFlow, new AnonymousClass1(this, null)), ViewModelKt.getViewModelScope(this));
    }

    @NotNull
    public abstract I getMNoneValueIntent();

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final MutableLiveData<S> getMUiState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mUiState;
    }

    public abstract void handleIntent(@NotNull I userIntent);

    @NotNull
    public final MutableLiveData<S> obtainUiState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mUiState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.onCleared();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0046  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object sendUserIntent(@NotNull I i3, @NotNull Continuation<? super Unit> continuation) {
        BaseViewModel$sendUserIntent$1 baseViewModel$sendUserIntent$1;
        Object coroutine_suspended;
        int i16;
        BaseViewModel<S, I> baseViewModel;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return iPatchRedirector.redirect((short) 4, (Object) this, (Object) i3, (Object) continuation);
        }
        if (continuation instanceof BaseViewModel$sendUserIntent$1) {
            baseViewModel$sendUserIntent$1 = (BaseViewModel$sendUserIntent$1) continuation;
            int i17 = baseViewModel$sendUserIntent$1.label;
            if ((i17 & Integer.MIN_VALUE) != 0) {
                baseViewModel$sendUserIntent$1.label = i17 - Integer.MIN_VALUE;
                Object obj = baseViewModel$sendUserIntent$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i16 = baseViewModel$sendUserIntent$1.label;
                if (i16 == 0) {
                    if (i16 == 1) {
                        baseViewModel = (BaseViewModel) baseViewModel$sendUserIntent$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    this._userIntentFlow.tryEmit(i3);
                    baseViewModel$sendUserIntent$1.L$0 = this;
                    baseViewModel$sendUserIntent$1.label = 1;
                    if (DelayKt.delay(10L, baseViewModel$sendUserIntent$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    baseViewModel = this;
                }
                baseViewModel._userIntentFlow.tryEmit(baseViewModel.getMNoneValueIntent());
                return Unit.INSTANCE;
            }
        }
        baseViewModel$sendUserIntent$1 = new BaseViewModel$sendUserIntent$1(this, continuation);
        Object obj2 = baseViewModel$sendUserIntent$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i16 = baseViewModel$sendUserIntent$1.label;
        if (i16 == 0) {
        }
        baseViewModel._userIntentFlow.tryEmit(baseViewModel.getMNoneValueIntent());
        return Unit.INSTANCE;
    }
}
