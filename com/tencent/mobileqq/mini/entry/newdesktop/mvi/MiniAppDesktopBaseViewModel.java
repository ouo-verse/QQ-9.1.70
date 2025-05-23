package com.tencent.mobileqq.mini.entry.newdesktop.mvi;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qqnt.base.mvi.a;
import com.tencent.qqnt.base.mvi.b;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u00020\u0005B\u0007\u00a2\u0006\u0004\b2\u00103J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0001H&\u00a2\u0006\u0004\b\b\u0010\tJ\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\nJ\u001b\u0010\f\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0001H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0001H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\rJH\u0010\u0016\u001a\u00020\u0007\"\u0004\b\u0002\u0010\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00020\u00102\"\u0010\u0015\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0012\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0014\u0010\u001b\u001a\u00020\u00072\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018J\b\u0010\u001c\u001a\u00020\u0007H\u0014R\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00010\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR \u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\n8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00190$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00190'8\u0006\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0014\u0010-\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00101\u001a\u00028\u00018&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b/\u00100\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDesktopBaseViewModel;", "Lcom/tencent/qqnt/base/mvi/a;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/qqnt/base/mvi/b;", "I", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "userIntent", "", "handleIntent", "(Lcom/tencent/qqnt/base/mvi/b;)V", "Landroidx/lifecycle/MutableLiveData;", "obtainUiState", "sendUserIntent", "(Lcom/tencent/qqnt/base/mvi/b;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendUserIntentWithoutReset", "T", "Lkotlinx/coroutines/flow/Flow;", "flow", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "action", "executeFlow", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/Function0;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDesktopEffect;", "builder", "setEffect", "onCleared", "Lkotlinx/coroutines/flow/MutableStateFlow;", "_userIntentFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "mUiState", "Landroidx/lifecycle/MutableLiveData;", "getMUiState", "()Landroidx/lifecycle/MutableLiveData;", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "_effect", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkotlinx/coroutines/flow/SharedFlow;", QQWinkConstants.TAB_EFFECT, "Lkotlinx/coroutines/flow/SharedFlow;", "getEffect", "()Lkotlinx/coroutines/flow/SharedFlow;", "Lkotlinx/coroutines/CoroutineScope;", "viewModelScope", "Lkotlinx/coroutines/CoroutineScope;", "getMNoneValueIntent", "()Lcom/tencent/qqnt/base/mvi/b;", "mNoneValueIntent", "<init>", "()V", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public abstract class MiniAppDesktopBaseViewModel<S extends com.tencent.qqnt.base.mvi.a, I extends com.tencent.qqnt.base.mvi.b> extends BaseViewModel {
    private final MutableSharedFlow<MiniAppDesktopEffect> _effect;
    private final MutableStateFlow<I> _userIntentFlow;
    private final SharedFlow<MiniAppDesktopEffect> effect;
    private final MutableLiveData<S> mUiState;
    private final CoroutineScope viewModelScope;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0006\u001a\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0003*\u00020\u00022\u0006\u0010\u0004\u001a\u00028\u0001H\u008a@"}, d2 = {"Lcom/tencent/qqnt/base/mvi/a;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/qqnt/base/mvi/b;", "I", "userIntent", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.mini.entry.newdesktop.mvi.MiniAppDesktopBaseViewModel$1", f = "MiniAppDesktopBaseViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.mini.entry.newdesktop.mvi.MiniAppDesktopBaseViewModel$1, reason: invalid class name */
    /* loaded from: classes33.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<I, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MiniAppDesktopBaseViewModel<S, I> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(MiniAppDesktopBaseViewModel<S, I> miniAppDesktopBaseViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = miniAppDesktopBaseViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(I i3, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(i3, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                com.tencent.qqnt.base.mvi.b bVar = (com.tencent.qqnt.base.mvi.b) this.L$0;
                System.out.println((Object) ("userIntentFlow onEach:" + bVar));
                if (bVar != null) {
                    this.this$0.handleIntent(bVar);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public MiniAppDesktopBaseViewModel() {
        MutableStateFlow<I> MutableStateFlow = StateFlowKt.MutableStateFlow(getMNoneValueIntent());
        this._userIntentFlow = MutableStateFlow;
        this.mUiState = new MutableLiveData<>();
        MutableSharedFlow<MiniAppDesktopEffect> MutableSharedFlow = SharedFlowKt.MutableSharedFlow(0, 1, BufferOverflow.DROP_OLDEST);
        this._effect = MutableSharedFlow;
        this.effect = FlowKt.asSharedFlow(MutableSharedFlow);
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain()));
        this.viewModelScope = CoroutineScope;
        FlowKt.launchIn(FlowKt.onEach(MutableStateFlow, new AnonymousClass1(this, null)), CoroutineScope);
    }

    public final <T> void executeFlow(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> action) {
        Intrinsics.checkNotNullParameter(flow, "flow");
        Intrinsics.checkNotNullParameter(action, "action");
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(flow, new MiniAppDesktopBaseViewModel$executeFlow$1(action, null)), Dispatchers.getIO()), this.viewModelScope);
    }

    public final SharedFlow<MiniAppDesktopEffect> getEffect() {
        return this.effect;
    }

    public abstract I getMNoneValueIntent();

    /* JADX INFO: Access modifiers changed from: protected */
    public final MutableLiveData<S> getMUiState() {
        return this.mUiState;
    }

    public abstract void handleIntent(I userIntent);

    public final MutableLiveData<S> obtainUiState() {
        return this.mUiState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object sendUserIntent(I i3, Continuation<? super Unit> continuation) {
        MiniAppDesktopBaseViewModel$sendUserIntent$1 miniAppDesktopBaseViewModel$sendUserIntent$1;
        Object coroutine_suspended;
        int i16;
        MiniAppDesktopBaseViewModel<S, I> miniAppDesktopBaseViewModel;
        if (continuation instanceof MiniAppDesktopBaseViewModel$sendUserIntent$1) {
            miniAppDesktopBaseViewModel$sendUserIntent$1 = (MiniAppDesktopBaseViewModel$sendUserIntent$1) continuation;
            int i17 = miniAppDesktopBaseViewModel$sendUserIntent$1.label;
            if ((i17 & Integer.MIN_VALUE) != 0) {
                miniAppDesktopBaseViewModel$sendUserIntent$1.label = i17 - Integer.MIN_VALUE;
                Object obj = miniAppDesktopBaseViewModel$sendUserIntent$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i16 = miniAppDesktopBaseViewModel$sendUserIntent$1.label;
                if (i16 != 0) {
                    ResultKt.throwOnFailure(obj);
                    this._userIntentFlow.tryEmit(i3);
                    miniAppDesktopBaseViewModel$sendUserIntent$1.L$0 = this;
                    miniAppDesktopBaseViewModel$sendUserIntent$1.label = 1;
                    if (DelayKt.delay(10L, miniAppDesktopBaseViewModel$sendUserIntent$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    miniAppDesktopBaseViewModel = this;
                } else if (i16 == 1) {
                    miniAppDesktopBaseViewModel = (MiniAppDesktopBaseViewModel) miniAppDesktopBaseViewModel$sendUserIntent$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                miniAppDesktopBaseViewModel._userIntentFlow.tryEmit(miniAppDesktopBaseViewModel.getMNoneValueIntent());
                return Unit.INSTANCE;
            }
        }
        miniAppDesktopBaseViewModel$sendUserIntent$1 = new MiniAppDesktopBaseViewModel$sendUserIntent$1(this, continuation);
        Object obj2 = miniAppDesktopBaseViewModel$sendUserIntent$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i16 = miniAppDesktopBaseViewModel$sendUserIntent$1.label;
        if (i16 != 0) {
        }
        miniAppDesktopBaseViewModel._userIntentFlow.tryEmit(miniAppDesktopBaseViewModel.getMNoneValueIntent());
        return Unit.INSTANCE;
    }

    public final Object sendUserIntentWithoutReset(I i3, Continuation<? super Unit> continuation) {
        this._userIntentFlow.tryEmit(i3);
        return Unit.INSTANCE;
    }

    public final void setEffect(Function0<? extends MiniAppDesktopEffect> builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        BuildersKt__Builders_commonKt.launch$default(this.viewModelScope, null, null, new MiniAppDesktopBaseViewModel$setEffect$1(this, builder.invoke(), null), 3, null);
    }
}
