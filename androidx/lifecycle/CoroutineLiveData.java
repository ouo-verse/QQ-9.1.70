package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002BK\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012-\u0010\u0007\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\b\u00a2\u0006\u0002\b\r\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u0013\u0010\u0013\u001a\u00020\u000bH\u0080@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0080@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u001c\u001a\u00020\u000bH\u0014J\b\u0010\u001d\u001a\u00020\u000bH\u0014R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001e"}, d2 = {"Landroidx/lifecycle/CoroutineLiveData;", "T", "Landroidx/lifecycle/MediatorLiveData;", "context", "Lkotlin/coroutines/CoroutineContext;", "timeoutInMs", "", "block", "Lkotlin/Function2;", "Landroidx/lifecycle/LiveDataScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/CoroutineContext;JLkotlin/jvm/functions/Function2;)V", "blockRunner", "Landroidx/lifecycle/BlockRunner;", "emittedSource", "Landroidx/lifecycle/EmittedSource;", "clearSource", "clearSource$lifecycle_livedata_ktx_release", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitSource", "Lkotlinx/coroutines/DisposableHandle;", "source", "Landroidx/lifecycle/LiveData;", "emitSource$lifecycle_livedata_ktx_release", "(Landroidx/lifecycle/LiveData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onActive", "onInactive", "lifecycle-livedata-ktx_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes.dex */
public final class CoroutineLiveData<T> extends MediatorLiveData<T> {
    private BlockRunner<T> blockRunner;
    private EmittedSource emittedSource;

    public /* synthetic */ CoroutineLiveData(CoroutineContext coroutineContext, long j3, Function2 function2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? EmptyCoroutineContext.INSTANCE : coroutineContext, (i3 & 2) != 0 ? 5000L : j3, function2);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object clearSource$lifecycle_livedata_ktx_release(@NotNull Continuation<? super Unit> continuation) {
        CoroutineLiveData$clearSource$1 coroutineLiveData$clearSource$1;
        Object coroutine_suspended;
        int i3;
        CoroutineLiveData<T> coroutineLiveData;
        if (continuation instanceof CoroutineLiveData$clearSource$1) {
            coroutineLiveData$clearSource$1 = (CoroutineLiveData$clearSource$1) continuation;
            int i16 = coroutineLiveData$clearSource$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                coroutineLiveData$clearSource$1.label = i16 - Integer.MIN_VALUE;
                Object obj = coroutineLiveData$clearSource$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = coroutineLiveData$clearSource$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        coroutineLiveData = (CoroutineLiveData) coroutineLiveData$clearSource$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    EmittedSource emittedSource = this.emittedSource;
                    if (emittedSource != null) {
                        coroutineLiveData$clearSource$1.L$0 = this;
                        coroutineLiveData$clearSource$1.label = 1;
                        obj = emittedSource.disposeNow(coroutineLiveData$clearSource$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        coroutineLiveData = this;
                    } else {
                        coroutineLiveData = this;
                        coroutineLiveData.emittedSource = null;
                        return Unit.INSTANCE;
                    }
                }
                coroutineLiveData.emittedSource = null;
                return Unit.INSTANCE;
            }
        }
        coroutineLiveData$clearSource$1 = new CoroutineLiveData$clearSource$1(this, continuation);
        Object obj2 = coroutineLiveData$clearSource$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = coroutineLiveData$clearSource$1.label;
        if (i3 == 0) {
        }
        coroutineLiveData.emittedSource = null;
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0069 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emitSource$lifecycle_livedata_ktx_release(@NotNull LiveData<T> liveData, @NotNull Continuation<? super DisposableHandle> continuation) {
        CoroutineLiveData$emitSource$1 coroutineLiveData$emitSource$1;
        Object obj;
        Object coroutine_suspended;
        int i3;
        LiveData<T> liveData2;
        CoroutineLiveData<T> coroutineLiveData;
        if (continuation instanceof CoroutineLiveData$emitSource$1) {
            coroutineLiveData$emitSource$1 = (CoroutineLiveData$emitSource$1) continuation;
            int i16 = coroutineLiveData$emitSource$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                coroutineLiveData$emitSource$1.label = i16 - Integer.MIN_VALUE;
                obj = coroutineLiveData$emitSource$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = coroutineLiveData$emitSource$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            coroutineLiveData = (CoroutineLiveData) coroutineLiveData$emitSource$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            EmittedSource emittedSource = (EmittedSource) obj;
                            coroutineLiveData.emittedSource = emittedSource;
                            return emittedSource;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    LiveData<T> liveData3 = (LiveData) coroutineLiveData$emitSource$1.L$1;
                    CoroutineLiveData<T> coroutineLiveData2 = (CoroutineLiveData) coroutineLiveData$emitSource$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    liveData2 = liveData3;
                    coroutineLiveData = coroutineLiveData2;
                } else {
                    ResultKt.throwOnFailure(obj);
                    coroutineLiveData$emitSource$1.L$0 = this;
                    coroutineLiveData$emitSource$1.L$1 = liveData;
                    coroutineLiveData$emitSource$1.label = 1;
                    if (clearSource$lifecycle_livedata_ktx_release(coroutineLiveData$emitSource$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    liveData2 = liveData;
                    coroutineLiveData = this;
                }
                coroutineLiveData$emitSource$1.L$0 = coroutineLiveData;
                coroutineLiveData$emitSource$1.L$1 = liveData2;
                coroutineLiveData$emitSource$1.label = 2;
                obj = CoroutineLiveDataKt.addDisposableSource(coroutineLiveData, liveData2, coroutineLiveData$emitSource$1);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                EmittedSource emittedSource2 = (EmittedSource) obj;
                coroutineLiveData.emittedSource = emittedSource2;
                return emittedSource2;
            }
        }
        coroutineLiveData$emitSource$1 = new CoroutineLiveData$emitSource$1(this, continuation);
        obj = coroutineLiveData$emitSource$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = coroutineLiveData$emitSource$1.label;
        if (i3 == 0) {
        }
        coroutineLiveData$emitSource$1.L$0 = coroutineLiveData;
        coroutineLiveData$emitSource$1.L$1 = liveData2;
        coroutineLiveData$emitSource$1.label = 2;
        obj = CoroutineLiveDataKt.addDisposableSource(coroutineLiveData, liveData2, coroutineLiveData$emitSource$1);
        if (obj == coroutine_suspended) {
        }
        EmittedSource emittedSource22 = (EmittedSource) obj;
        coroutineLiveData.emittedSource = emittedSource22;
        return emittedSource22;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.MediatorLiveData, androidx.lifecycle.LiveData
    public void onActive() {
        super.onActive();
        BlockRunner<T> blockRunner = this.blockRunner;
        if (blockRunner != null) {
            blockRunner.maybeRun();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.MediatorLiveData, androidx.lifecycle.LiveData
    public void onInactive() {
        super.onInactive();
        BlockRunner<T> blockRunner = this.blockRunner;
        if (blockRunner != null) {
            blockRunner.cancel();
        }
    }

    public CoroutineLiveData(@NotNull CoroutineContext context, long j3, @NotNull Function2<? super LiveDataScope<T>, ? super Continuation<? super Unit>, ? extends Object> block) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(block, "block");
        this.blockRunner = new BlockRunner<>(this, block, j3, CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate().plus(context).plus(SupervisorKt.SupervisorJob((Job) context.get(Job.INSTANCE)))), new Function0<Unit>() { // from class: androidx.lifecycle.CoroutineLiveData.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                CoroutineLiveData.this.blockRunner = null;
            }
        });
    }
}
