package kotlinx.coroutines.flow;

import com.heytap.databaseengine.type.DeviceType;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import kotlin.BuilderInference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.FlowPreview;
import kotlinx.coroutines.flow.internal.ChannelFlowMerge;
import kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest;
import kotlinx.coroutines.flow.internal.ChannelLimitedFlowMerge;
import kotlinx.coroutines.internal.SystemPropsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a9\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u000b0\n\"\u0004\b\u0000\u0010\u000b2\u001e\u0010\f\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H\u000b0\n0\r\"\b\u0012\u0004\u0012\u0002H\u000b0\nH\u0007\u00a2\u0006\u0002\u0010\u000e\u001ae\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00100\n\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u000b0\n27\u0010\u0011\u001a3\b\u0001\u0012\u0013\u0012\u0011H\u000b\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\n0\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0012H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018\u001ah\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00100\n\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u000b0\n29\b\u0005\u0010\u0011\u001a3\b\u0001\u0012\u0013\u0012\u0011H\u000b\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\n0\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0012H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018\u001ao\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00100\n\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u000b0\n2\b\b\u0002\u0010\u001b\u001a\u00020\u000127\u0010\u0011\u001a3\b\u0001\u0012\u0013\u0012\u0011H\u000b\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\n0\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0012H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001c\u001a$\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u000b0\n\"\u0004\b\u0000\u0010\u000b*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\n0\nH\u0007\u001a.\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u000b0\n\"\u0004\b\u0000\u0010\u000b*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\n0\n2\b\b\u0002\u0010\u001b\u001a\u00020\u0001H\u0007\u001aa\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u00100\n\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u000b0\n23\b\u0001\u0010\u0011\u001a-\b\u0001\u0012\u0013\u0012\u0011H\u000b\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0012H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018\u001a$\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u000b0\n\"\u0004\b\u0000\u0010\u000b*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\n0 H\u0007\u001ar\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u00100\n\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u000b0\n2D\b\u0001\u0010\u0011\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100#\u0012\u0013\u0012\u0011H\u000b\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\"\u00a2\u0006\u0002\b%H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010&\"\u001c\u0010\u0000\u001a\u00020\u00018\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087T\u00a2\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0003\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006'"}, d2 = {"DEFAULT_CONCURRENCY", "", "getDEFAULT_CONCURRENCY$annotations", "()V", "getDEFAULT_CONCURRENCY", "()I", "DEFAULT_CONCURRENCY_PROPERTY_NAME", "", "getDEFAULT_CONCURRENCY_PROPERTY_NAME$annotations", DeviceType.DeviceCategory.MERGER, "Lkotlinx/coroutines/flow/Flow;", "T", "flows", "", "([Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/Flow;", "flatMapConcat", BdhLogUtil.LogTag.Tag_Req, "transform", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "value", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "flatMapLatest", "flatMapMerge", "concurrency", "(Lkotlinx/coroutines/flow/Flow;ILkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "flattenConcat", "flattenMerge", "mapLatest", "", "transformLatest", "Lkotlin/Function3;", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 5, 1}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes28.dex */
public final /* synthetic */ class FlowKt__MergeKt {
    private static final int DEFAULT_CONCURRENCY = SystemPropsKt.systemProp(FlowKt.DEFAULT_CONCURRENCY_PROPERTY_NAME, 16, 1, Integer.MAX_VALUE);

    @FlowPreview
    @NotNull
    public static final <T, R> Flow<R> flatMapConcat(@NotNull final Flow<? extends T> flow, @NotNull final Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> function2) {
        return FlowKt.flattenConcat(new Flow<Flow<? extends R>>() { // from class: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1

            /* JADX INFO: Add missing generic type declarations: [T] */
            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 5, 1}, xi = 48)
            /* renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes28.dex */
            public static final class AnonymousClass2<T> implements FlowCollector<T> {
                final /* synthetic */ FlowCollector $this_unsafeFlow$inlined;
                final /* synthetic */ Function2 $transform$inlined$1;

                /* compiled from: P */
                @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
                @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2", f = "Merge.kt", i = {}, l = {136, 136}, m = "emit", n = {}, s = {})
                /* renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2$1, reason: invalid class name */
                /* loaded from: classes28.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, Function2 function2) {
                    this.$this_unsafeFlow$inlined = flowCollector;
                    this.$transform$inlined$1 = function2;
                }

                /* JADX WARN: Removed duplicated region for block: B:19:0x005d A[RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:20:0x003d  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Object emit(Object obj, @NotNull Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    Object obj2;
                    Object coroutine_suspended;
                    int i3;
                    FlowCollector flowCollector;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i16 = anonymousClass1.label;
                        if ((i16 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i16 - Integer.MIN_VALUE;
                            obj2 = anonymousClass1.result;
                            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i3 = anonymousClass1.label;
                            if (i3 == 0) {
                                if (i3 != 1) {
                                    if (i3 == 2) {
                                        ResultKt.throwOnFailure(obj2);
                                        return Unit.INSTANCE;
                                    }
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                FlowCollector flowCollector2 = (FlowCollector) anonymousClass1.L$0;
                                ResultKt.throwOnFailure(obj2);
                                flowCollector = flowCollector2;
                            } else {
                                ResultKt.throwOnFailure(obj2);
                                FlowCollector flowCollector3 = this.$this_unsafeFlow$inlined;
                                Function2 function2 = this.$transform$inlined$1;
                                anonymousClass1.L$0 = flowCollector3;
                                anonymousClass1.label = 1;
                                Object invoke = function2.invoke(obj, anonymousClass1);
                                if (invoke == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                obj2 = invoke;
                                flowCollector = flowCollector3;
                            }
                            anonymousClass1.L$0 = null;
                            anonymousClass1.label = 2;
                            if (flowCollector.emit(obj2, anonymousClass1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    obj2 = anonymousClass1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = anonymousClass1.label;
                    if (i3 == 0) {
                    }
                    anonymousClass1.L$0 = null;
                    anonymousClass1.label = 2;
                    if (flowCollector.emit(obj2, anonymousClass1) == coroutine_suspended) {
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector flowCollector, @NotNull Continuation continuation) {
                Object coroutine_suspended;
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, function2), continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (collect == coroutine_suspended) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        });
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T, R> Flow<R> flatMapLatest(@NotNull Flow<? extends T> flow, @BuilderInference @NotNull Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> function2) {
        return FlowKt.transformLatest(flow, new FlowKt__MergeKt$flatMapLatest$1(function2, null));
    }

    @FlowPreview
    @NotNull
    public static final <T, R> Flow<R> flatMapMerge(@NotNull final Flow<? extends T> flow, int i3, @NotNull final Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> function2) {
        return FlowKt.flattenMerge(new Flow<Flow<? extends R>>() { // from class: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1

            /* JADX INFO: Add missing generic type declarations: [T] */
            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 5, 1}, xi = 48)
            /* renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes28.dex */
            public static final class AnonymousClass2<T> implements FlowCollector<T> {
                final /* synthetic */ FlowCollector $this_unsafeFlow$inlined;
                final /* synthetic */ Function2 $transform$inlined$1;

                /* compiled from: P */
                @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
                @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2", f = "Merge.kt", i = {}, l = {136, 136}, m = "emit", n = {}, s = {})
                /* renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2$1, reason: invalid class name */
                /* loaded from: classes28.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, Function2 function2) {
                    this.$this_unsafeFlow$inlined = flowCollector;
                    this.$transform$inlined$1 = function2;
                }

                /* JADX WARN: Removed duplicated region for block: B:19:0x005d A[RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:20:0x003d  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Object emit(Object obj, @NotNull Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    Object obj2;
                    Object coroutine_suspended;
                    int i3;
                    FlowCollector flowCollector;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i16 = anonymousClass1.label;
                        if ((i16 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i16 - Integer.MIN_VALUE;
                            obj2 = anonymousClass1.result;
                            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i3 = anonymousClass1.label;
                            if (i3 == 0) {
                                if (i3 != 1) {
                                    if (i3 == 2) {
                                        ResultKt.throwOnFailure(obj2);
                                        return Unit.INSTANCE;
                                    }
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                FlowCollector flowCollector2 = (FlowCollector) anonymousClass1.L$0;
                                ResultKt.throwOnFailure(obj2);
                                flowCollector = flowCollector2;
                            } else {
                                ResultKt.throwOnFailure(obj2);
                                FlowCollector flowCollector3 = this.$this_unsafeFlow$inlined;
                                Function2 function2 = this.$transform$inlined$1;
                                anonymousClass1.L$0 = flowCollector3;
                                anonymousClass1.label = 1;
                                Object invoke = function2.invoke(obj, anonymousClass1);
                                if (invoke == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                obj2 = invoke;
                                flowCollector = flowCollector3;
                            }
                            anonymousClass1.L$0 = null;
                            anonymousClass1.label = 2;
                            if (flowCollector.emit(obj2, anonymousClass1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    obj2 = anonymousClass1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = anonymousClass1.label;
                    if (i3 == 0) {
                    }
                    anonymousClass1.L$0 = null;
                    anonymousClass1.label = 2;
                    if (flowCollector.emit(obj2, anonymousClass1) == coroutine_suspended) {
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector flowCollector, @NotNull Continuation continuation) {
                Object coroutine_suspended;
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, function2), continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (collect == coroutine_suspended) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        }, i3);
    }

    public static /* synthetic */ Flow flatMapMerge$default(Flow flow, int i3, Function2 function2, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = DEFAULT_CONCURRENCY;
        }
        return FlowKt.flatMapMerge(flow, i3, function2);
    }

    @FlowPreview
    @NotNull
    public static final <T> Flow<T> flattenConcat(@NotNull final Flow<? extends Flow<? extends T>> flow) {
        return new Flow<T>() { // from class: kotlinx.coroutines.flow.FlowKt__MergeKt$flattenConcat$$inlined$unsafeFlow$1
            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull final FlowCollector<? super T> flowCollector, @NotNull Continuation<? super Unit> continuation) {
                Object coroutine_suspended;
                Object collect = Flow.this.collect(new FlowCollector<Flow<? extends T>>() { // from class: kotlinx.coroutines.flow.FlowKt__MergeKt$flattenConcat$lambda-1$$inlined$collect$1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    @Nullable
                    public Object emit(Flow<? extends T> flow2, @NotNull Continuation<? super Unit> continuation2) {
                        Object coroutine_suspended2;
                        Object emitAll = FlowKt.emitAll(FlowCollector.this, flow2, continuation2);
                        coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (emitAll == coroutine_suspended2) {
                            return emitAll;
                        }
                        return Unit.INSTANCE;
                    }
                }, continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (collect == coroutine_suspended) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        };
    }

    @FlowPreview
    @NotNull
    public static final <T> Flow<T> flattenMerge(@NotNull Flow<? extends Flow<? extends T>> flow, int i3) {
        boolean z16;
        if (i3 > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (i3 == 1) {
                return FlowKt.flattenConcat(flow);
            }
            return new ChannelFlowMerge(flow, i3, null, 0, null, 28, null);
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("Expected positive concurrency level, but had ", Integer.valueOf(i3)).toString());
    }

    public static /* synthetic */ Flow flattenMerge$default(Flow flow, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = DEFAULT_CONCURRENCY;
        }
        return FlowKt.flattenMerge(flow, i3);
    }

    public static final int getDEFAULT_CONCURRENCY() {
        return DEFAULT_CONCURRENCY;
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T, R> Flow<R> mapLatest(@NotNull Flow<? extends T> flow, @BuilderInference @NotNull Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        return FlowKt.transformLatest(flow, new FlowKt__MergeKt$mapLatest$1(function2, null));
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T> Flow<T> merge(@NotNull Iterable<? extends Flow<? extends T>> iterable) {
        return new ChannelLimitedFlowMerge(iterable, null, 0, null, 14, null);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T, R> Flow<R> transformLatest(@NotNull Flow<? extends T> flow, @BuilderInference @NotNull Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> function3) {
        return new ChannelFlowTransformLatest(function3, flow, null, 0, null, 28, null);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T> Flow<T> merge(@NotNull Flow<? extends T>... flowArr) {
        Iterable asIterable;
        asIterable = ArraysKt___ArraysKt.asIterable(flowArr);
        return FlowKt.merge(asIterable);
    }

    @FlowPreview
    public static /* synthetic */ void getDEFAULT_CONCURRENCY$annotations() {
    }

    @FlowPreview
    public static /* synthetic */ void getDEFAULT_CONCURRENCY_PROPERTY_NAME$annotations() {
    }
}
