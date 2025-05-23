package kotlinx.coroutines.flow;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.BuilderInference;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.OverloadResolutionByLambdaReturnType;
import kotlin.PublishedApi;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.ranges.IntRange;
import kotlin.ranges.LongRange;
import kotlin.sequences.Sequence;
import kotlin.time.Duration;
import kotlin.time.ExperimentalTime;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.FlowPreview;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BroadcastChannel;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"kotlinx/coroutines/flow/FlowKt__BuildersKt", "kotlinx/coroutines/flow/FlowKt__ChannelsKt", "kotlinx/coroutines/flow/FlowKt__CollectKt", "kotlinx/coroutines/flow/FlowKt__CollectionKt", "kotlinx/coroutines/flow/FlowKt__ContextKt", "kotlinx/coroutines/flow/FlowKt__CountKt", "kotlinx/coroutines/flow/FlowKt__DelayKt", "kotlinx/coroutines/flow/FlowKt__DistinctKt", "kotlinx/coroutines/flow/FlowKt__EmittersKt", "kotlinx/coroutines/flow/FlowKt__ErrorsKt", "kotlinx/coroutines/flow/FlowKt__LimitKt", "kotlinx/coroutines/flow/FlowKt__MergeKt", "kotlinx/coroutines/flow/FlowKt__MigrationKt", "kotlinx/coroutines/flow/FlowKt__ReduceKt", "kotlinx/coroutines/flow/FlowKt__ShareKt", "kotlinx/coroutines/flow/FlowKt__TransformKt", "kotlinx/coroutines/flow/FlowKt__ZipKt"}, k = 4, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class FlowKt {

    @NotNull
    public static final String DEFAULT_CONCURRENCY_PROPERTY_NAME = "kotlinx.coroutines.flow.defaultConcurrency";

    @NotNull
    public static final <T> Flow<T> asFlow(@NotNull Iterable<? extends T> iterable) {
        return FlowKt__BuildersKt.asFlow(iterable);
    }

    @NotNull
    public static final <T> SharedFlow<T> asSharedFlow(@NotNull MutableSharedFlow<T> mutableSharedFlow) {
        return FlowKt__ShareKt.asSharedFlow(mutableSharedFlow);
    }

    @NotNull
    public static final <T> StateFlow<T> asStateFlow(@NotNull MutableStateFlow<T> mutableStateFlow) {
        return FlowKt__ShareKt.asStateFlow(mutableStateFlow);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use shareIn operator and the resulting SharedFlow as a replacement for BroadcastChannel", replaceWith = @ReplaceWith(expression = "this.shareIn(scope, SharingStarted.Lazily, 0)", imports = {}))
    @NotNull
    public static final <T> BroadcastChannel<T> broadcastIn(@NotNull Flow<? extends T> flow, @NotNull CoroutineScope coroutineScope, @NotNull CoroutineStart coroutineStart) {
        return FlowKt__ChannelsKt.broadcastIn(flow, coroutineScope, coroutineStart);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'cache()' is 'shareIn' with unlimited replay and 'started = SharingStared.Lazily' argument'", replaceWith = @ReplaceWith(expression = "this.shareIn(scope, Int.MAX_VALUE, started = SharingStared.Lazily)", imports = {}))
    @NotNull
    public static final <T> Flow<T> cache(@NotNull Flow<? extends T> flow) {
        return FlowKt__MigrationKt.cache(flow);
    }

    @NotNull
    public static final <T> Flow<T> callbackFlow(@BuilderInference @NotNull Function2<? super ProducerScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return FlowKt__BuildersKt.callbackFlow(function2);
    }

    @NotNull
    public static final <T> Flow<T> cancellable(@NotNull Flow<? extends T> flow) {
        return FlowKt__ContextKt.cancellable(flow);
    }

    @NotNull
    /* renamed from: catch, reason: not valid java name */
    public static final <T> Flow<T> m2026catch(@NotNull Flow<? extends T> flow, @NotNull Function3<? super FlowCollector<? super T>, ? super Throwable, ? super Continuation<? super Unit>, ? extends Object> function3) {
        return FlowKt__ErrorsKt.m2033catch(flow, function3);
    }

    @Nullable
    public static final <T> Object catchImpl(@NotNull Flow<? extends T> flow, @NotNull FlowCollector<? super T> flowCollector, @NotNull Continuation<? super Throwable> continuation) {
        return FlowKt__ErrorsKt.catchImpl(flow, flowCollector, continuation);
    }

    @NotNull
    public static final <T> Flow<T> channelFlow(@BuilderInference @NotNull Function2<? super ProducerScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return FlowKt__BuildersKt.channelFlow(function2);
    }

    @Nullable
    public static final Object collect(@NotNull Flow<?> flow, @NotNull Continuation<? super Unit> continuation) {
        return FlowKt__CollectKt.collect(flow, continuation);
    }

    @Nullable
    public static final <T> Object collectIndexed(@NotNull Flow<? extends T> flow, @NotNull Function3<? super Integer, ? super T, ? super Continuation<? super Unit>, ? extends Object> function3, @NotNull Continuation<? super Unit> continuation) {
        return FlowKt__CollectKt.collectIndexed(flow, function3, continuation);
    }

    @Nullable
    public static final <T> Object collectLatest(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2, @NotNull Continuation<? super Unit> continuation) {
        return FlowKt__CollectKt.collectLatest(flow, function2, continuation);
    }

    @Nullable
    public static final <T> Object collectWhile(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, @NotNull Continuation<? super Unit> continuation) {
        return FlowKt__LimitKt.collectWhile(flow, function2, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(expression = "this.combine(other, transform)", imports = {}))
    @NotNull
    public static final <T1, T2, R> Flow<R> combineLatest(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3) {
        return FlowKt__MigrationKt.combineLatest(flow, flow2, function3);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'compose' is 'let'", replaceWith = @ReplaceWith(expression = "let(transformer)", imports = {}))
    @NotNull
    public static final <T, R> Flow<R> compose(@NotNull Flow<? extends T> flow, @NotNull Function1<? super Flow<? extends T>, ? extends Flow<? extends R>> function1) {
        return FlowKt__MigrationKt.compose(flow, function1);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'concatMap' is 'flatMapConcat'", replaceWith = @ReplaceWith(expression = "flatMapConcat(mapper)", imports = {}))
    @NotNull
    public static final <T, R> Flow<R> concatMap(@NotNull Flow<? extends T> flow, @NotNull Function1<? super T, ? extends Flow<? extends R>> function1) {
        return FlowKt__MigrationKt.concatMap(flow, function1);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'concatWith' is 'onCompletion'. Use 'onCompletion { emit(value) }'", replaceWith = @ReplaceWith(expression = "onCompletion { emit(value) }", imports = {}))
    @NotNull
    public static final <T> Flow<T> concatWith(@NotNull Flow<? extends T> flow, T t16) {
        return FlowKt__MigrationKt.concatWith(flow, t16);
    }

    @NotNull
    public static final <T> Flow<T> conflate(@NotNull Flow<? extends T> flow) {
        return FlowKt__ContextKt.conflate(flow);
    }

    @NotNull
    public static final <T> Flow<T> consumeAsFlow(@NotNull ReceiveChannel<? extends T> receiveChannel) {
        return FlowKt__ChannelsKt.consumeAsFlow(receiveChannel);
    }

    @Nullable
    public static final <T> Object count(@NotNull Flow<? extends T> flow, @NotNull Continuation<? super Integer> continuation) {
        return FlowKt__CountKt.count(flow, continuation);
    }

    @FlowPreview
    @NotNull
    public static final <T> Flow<T> debounce(@NotNull Flow<? extends T> flow, long j3) {
        return FlowKt__DelayKt.debounce(flow, j3);
    }

    @FlowPreview
    @ExperimentalTime
    @NotNull
    /* renamed from: debounce-HG0u8IE, reason: not valid java name */
    public static final <T> Flow<T> m2027debounceHG0u8IE(@NotNull Flow<? extends T> flow, long j3) {
        return FlowKt__DelayKt.m2029debounceHG0u8IE(flow, j3);
    }

    @FlowPreview
    @JvmName(name = "debounceDuration")
    @NotNull
    @OverloadResolutionByLambdaReturnType
    @ExperimentalTime
    public static final <T> Flow<T> debounceDuration(@NotNull Flow<? extends T> flow, @NotNull Function1<? super T, Duration> function1) {
        return FlowKt__DelayKt.debounceDuration(flow, function1);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'onEach { delay(timeMillis) }'", replaceWith = @ReplaceWith(expression = "onEach { delay(timeMillis) }", imports = {}))
    @NotNull
    public static final <T> Flow<T> delayEach(@NotNull Flow<? extends T> flow, long j3) {
        return FlowKt__MigrationKt.delayEach(flow, j3);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'onStart { delay(timeMillis) }'", replaceWith = @ReplaceWith(expression = "onStart { delay(timeMillis) }", imports = {}))
    @NotNull
    public static final <T> Flow<T> delayFlow(@NotNull Flow<? extends T> flow, long j3) {
        return FlowKt__MigrationKt.delayFlow(flow, j3);
    }

    @NotNull
    public static final <T> Flow<T> distinctUntilChanged(@NotNull Flow<? extends T> flow) {
        return FlowKt__DistinctKt.distinctUntilChanged(flow);
    }

    @NotNull
    public static final <T, K> Flow<T> distinctUntilChangedBy(@NotNull Flow<? extends T> flow, @NotNull Function1<? super T, ? extends K> function1) {
        return FlowKt__DistinctKt.distinctUntilChangedBy(flow, function1);
    }

    @NotNull
    public static final <T> Flow<T> drop(@NotNull Flow<? extends T> flow, int i3) {
        return FlowKt__LimitKt.drop(flow, i3);
    }

    @NotNull
    public static final <T> Flow<T> dropWhile(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return FlowKt__LimitKt.dropWhile(flow, function2);
    }

    @Nullable
    public static final <T> Object emitAll(@NotNull FlowCollector<? super T> flowCollector, @NotNull ReceiveChannel<? extends T> receiveChannel, @NotNull Continuation<? super Unit> continuation) {
        return FlowKt__ChannelsKt.emitAll(flowCollector, receiveChannel, continuation);
    }

    @NotNull
    public static final <T> Flow<T> emptyFlow() {
        return FlowKt__BuildersKt.emptyFlow();
    }

    public static final void ensureActive(@NotNull FlowCollector<?> flowCollector) {
        FlowKt__EmittersKt.ensureActive(flowCollector);
    }

    @NotNull
    public static final <T> Flow<T> filter(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return FlowKt__TransformKt.filter(flow, function2);
    }

    @NotNull
    public static final <T> Flow<T> filterNot(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return FlowKt__TransformKt.filterNot(flow, function2);
    }

    @NotNull
    public static final <T> Flow<T> filterNotNull(@NotNull Flow<? extends T> flow) {
        return FlowKt__TransformKt.filterNotNull(flow);
    }

    @Nullable
    public static final <T> Object first(@NotNull Flow<? extends T> flow, @NotNull Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.first(flow, continuation);
    }

    @Nullable
    public static final <T> Object firstOrNull(@NotNull Flow<? extends T> flow, @NotNull Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.firstOrNull(flow, continuation);
    }

    @NotNull
    public static final ReceiveChannel<Unit> fixedPeriodTicker(@NotNull CoroutineScope coroutineScope, long j3, long j16) {
        return FlowKt__DelayKt.fixedPeriodTicker(coroutineScope, j3, j16);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue is 'flatMapConcat'", replaceWith = @ReplaceWith(expression = "flatMapConcat(mapper)", imports = {}))
    @NotNull
    public static final <T, R> Flow<R> flatMap(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> function2) {
        return FlowKt__MigrationKt.flatMap(flow, function2);
    }

    @FlowPreview
    @NotNull
    public static final <T, R> Flow<R> flatMapConcat(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> function2) {
        return FlowKt__MergeKt.flatMapConcat(flow, function2);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T, R> Flow<R> flatMapLatest(@NotNull Flow<? extends T> flow, @BuilderInference @NotNull Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> function2) {
        return FlowKt__MergeKt.flatMapLatest(flow, function2);
    }

    @FlowPreview
    @NotNull
    public static final <T, R> Flow<R> flatMapMerge(@NotNull Flow<? extends T> flow, int i3, @NotNull Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> function2) {
        return FlowKt__MergeKt.flatMapMerge(flow, i3, function2);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'flatten' is 'flattenConcat'", replaceWith = @ReplaceWith(expression = "flattenConcat()", imports = {}))
    @NotNull
    public static final <T> Flow<T> flatten(@NotNull Flow<? extends Flow<? extends T>> flow) {
        return FlowKt__MigrationKt.flatten(flow);
    }

    @FlowPreview
    @NotNull
    public static final <T> Flow<T> flattenConcat(@NotNull Flow<? extends Flow<? extends T>> flow) {
        return FlowKt__MergeKt.flattenConcat(flow);
    }

    @FlowPreview
    @NotNull
    public static final <T> Flow<T> flattenMerge(@NotNull Flow<? extends Flow<? extends T>> flow, int i3) {
        return FlowKt__MergeKt.flattenMerge(flow, i3);
    }

    @NotNull
    public static final <T> Flow<T> flow(@BuilderInference @NotNull Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return FlowKt__BuildersKt.flow(function2);
    }

    @JvmName(name = "flowCombine")
    @NotNull
    public static final <T1, T2, R> Flow<R> flowCombine(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3) {
        return FlowKt__ZipKt.flowCombine(flow, flow2, function3);
    }

    @JvmName(name = "flowCombineTransform")
    @NotNull
    public static final <T1, T2, R> Flow<R> flowCombineTransform(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @BuilderInference @NotNull Function4<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super Continuation<? super Unit>, ? extends Object> function4) {
        return FlowKt__ZipKt.flowCombineTransform(flow, flow2, function4);
    }

    @NotNull
    public static final <T> Flow<T> flowOf(T t16) {
        return FlowKt__BuildersKt.flowOf(t16);
    }

    @NotNull
    public static final <T> Flow<T> flowOn(@NotNull Flow<? extends T> flow, @NotNull CoroutineContext coroutineContext) {
        return FlowKt__ContextKt.flowOn(flow, coroutineContext);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use channelFlow with awaitClose { } instead of flowViaChannel and invokeOnClose { }.")
    @FlowPreview
    @NotNull
    public static final <T> Flow<T> flowViaChannel(int i3, @BuilderInference @NotNull Function2<? super CoroutineScope, ? super SendChannel<? super T>, Unit> function2) {
        return FlowKt__BuildersKt.flowViaChannel(i3, function2);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "flowWith is deprecated without replacement, please refer to its KDoc for an explanation")
    @FlowPreview
    @NotNull
    public static final <T, R> Flow<R> flowWith(@NotNull Flow<? extends T> flow, @NotNull CoroutineContext coroutineContext, int i3, @NotNull Function1<? super Flow<? extends T>, ? extends Flow<? extends R>> function1) {
        return FlowKt__ContextKt.flowWith(flow, coroutineContext, i3, function1);
    }

    @Nullable
    public static final <T, R> Object fold(@NotNull Flow<? extends T> flow, R r16, @NotNull Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> function3, @NotNull Continuation<? super R> continuation) {
        return FlowKt__ReduceKt.fold(flow, r16, function3, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'forEach' is 'collect'", replaceWith = @ReplaceWith(expression = "collect(block)", imports = {}))
    public static final <T> void forEach(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2) {
        FlowKt__MigrationKt.forEach(flow, function2);
    }

    public static final int getDEFAULT_CONCURRENCY() {
        return FlowKt__MergeKt.getDEFAULT_CONCURRENCY();
    }

    @Nullable
    public static final <T> Object last(@NotNull Flow<? extends T> flow, @NotNull Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.last(flow, continuation);
    }

    @Nullable
    public static final <T> Object lastOrNull(@NotNull Flow<? extends T> flow, @NotNull Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.lastOrNull(flow, continuation);
    }

    @NotNull
    public static final <T> Job launchIn(@NotNull Flow<? extends T> flow, @NotNull CoroutineScope coroutineScope) {
        return FlowKt__CollectKt.launchIn(flow, coroutineScope);
    }

    @NotNull
    public static final <T, R> Flow<R> map(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        return FlowKt__TransformKt.map(flow, function2);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T, R> Flow<R> mapLatest(@NotNull Flow<? extends T> flow, @BuilderInference @NotNull Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        return FlowKt__MergeKt.mapLatest(flow, function2);
    }

    @NotNull
    public static final <T, R> Flow<R> mapNotNull(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        return FlowKt__TransformKt.mapNotNull(flow, function2);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T> Flow<T> merge(@NotNull Iterable<? extends Flow<? extends T>> iterable) {
        return FlowKt__MergeKt.merge(iterable);
    }

    @NotNull
    public static final Void noImpl() {
        return FlowKt__MigrationKt.noImpl();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Collect flow in the desired context instead")
    @NotNull
    public static final <T> Flow<T> observeOn(@NotNull Flow<? extends T> flow, @NotNull CoroutineContext coroutineContext) {
        return FlowKt__MigrationKt.observeOn(flow, coroutineContext);
    }

    @NotNull
    public static final <T> Flow<T> onCompletion(@NotNull Flow<? extends T> flow, @NotNull Function3<? super FlowCollector<? super T>, ? super Throwable, ? super Continuation<? super Unit>, ? extends Object> function3) {
        return FlowKt__EmittersKt.onCompletion(flow, function3);
    }

    @NotNull
    public static final <T> Flow<T> onEach(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return FlowKt__TransformKt.onEach(flow, function2);
    }

    @NotNull
    public static final <T> Flow<T> onEmpty(@NotNull Flow<? extends T> flow, @NotNull Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return FlowKt__EmittersKt.onEmpty(flow, function2);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use catch { e -> if (predicate(e)) emitAll(fallback) else throw e }", replaceWith = @ReplaceWith(expression = "catch { e -> if (predicate(e)) emitAll(fallback) else throw e }", imports = {}))
    @NotNull
    public static final <T> Flow<T> onErrorCollect(@NotNull Flow<? extends T> flow, @NotNull Flow<? extends T> flow2, @NotNull Function1<? super Throwable, Boolean> function1) {
        return FlowKt__ErrorsKt.onErrorCollect(flow, flow2, function1);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emitAll(fallback) }'", replaceWith = @ReplaceWith(expression = "catch { emitAll(fallback) }", imports = {}))
    @NotNull
    public static final <T> Flow<T> onErrorResume(@NotNull Flow<? extends T> flow, @NotNull Flow<? extends T> flow2) {
        return FlowKt__MigrationKt.onErrorResume(flow, flow2);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emitAll(fallback) }'", replaceWith = @ReplaceWith(expression = "catch { emitAll(fallback) }", imports = {}))
    @NotNull
    public static final <T> Flow<T> onErrorResumeNext(@NotNull Flow<? extends T> flow, @NotNull Flow<? extends T> flow2) {
        return FlowKt__MigrationKt.onErrorResumeNext(flow, flow2);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emit(fallback) }'", replaceWith = @ReplaceWith(expression = "catch { emit(fallback) }", imports = {}))
    @NotNull
    public static final <T> Flow<T> onErrorReturn(@NotNull Flow<? extends T> flow, T t16) {
        return FlowKt__MigrationKt.onErrorReturn(flow, t16);
    }

    @NotNull
    public static final <T> Flow<T> onStart(@NotNull Flow<? extends T> flow, @NotNull Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return FlowKt__EmittersKt.onStart(flow, function2);
    }

    @NotNull
    public static final <T> SharedFlow<T> onSubscription(@NotNull SharedFlow<? extends T> sharedFlow, @NotNull Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return FlowKt__ShareKt.onSubscription(sharedFlow, function2);
    }

    @FlowPreview
    @NotNull
    public static final <T> ReceiveChannel<T> produceIn(@NotNull Flow<? extends T> flow, @NotNull CoroutineScope coroutineScope) {
        return FlowKt__ChannelsKt.produceIn(flow, coroutineScope);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'publish()' is 'shareIn'. \npublish().connect() is the default strategy (no extra call is needed), \npublish().autoConnect() translates to 'started = SharingStared.Lazily' argument, \npublish().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @ReplaceWith(expression = "this.shareIn(scope, 0)", imports = {}))
    @NotNull
    public static final <T> Flow<T> publish(@NotNull Flow<? extends T> flow) {
        return FlowKt__MigrationKt.publish(flow);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Collect flow in the desired context instead")
    @NotNull
    public static final <T> Flow<T> publishOn(@NotNull Flow<? extends T> flow, @NotNull CoroutineContext coroutineContext) {
        return FlowKt__MigrationKt.publishOn(flow, coroutineContext);
    }

    @NotNull
    public static final <T> Flow<T> receiveAsFlow(@NotNull ReceiveChannel<? extends T> receiveChannel) {
        return FlowKt__ChannelsKt.receiveAsFlow(receiveChannel);
    }

    @Nullable
    public static final <S, T extends S> Object reduce(@NotNull Flow<? extends T> flow, @NotNull Function3<? super S, ? super T, ? super Continuation<? super S>, ? extends Object> function3, @NotNull Continuation<? super S> continuation) {
        return FlowKt__ReduceKt.reduce(flow, function3, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'replay()' is 'shareIn' with unlimited replay. \nreplay().connect() is the default strategy (no extra call is needed), \nreplay().autoConnect() translates to 'started = SharingStared.Lazily' argument, \nreplay().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @ReplaceWith(expression = "this.shareIn(scope, Int.MAX_VALUE)", imports = {}))
    @NotNull
    public static final <T> Flow<T> replay(@NotNull Flow<? extends T> flow) {
        return FlowKt__MigrationKt.replay(flow);
    }

    @NotNull
    public static final <T> Flow<T> retryWhen(@NotNull Flow<? extends T> flow, @NotNull Function4<? super FlowCollector<? super T>, ? super Throwable, ? super Long, ? super Continuation<? super Boolean>, ? extends Object> function4) {
        return FlowKt__ErrorsKt.retryWhen(flow, function4);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T, R> Flow<R> runningFold(@NotNull Flow<? extends T> flow, R r16, @BuilderInference @NotNull Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> function3) {
        return FlowKt__TransformKt.runningFold(flow, r16, function3);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T> Flow<T> runningReduce(@NotNull Flow<? extends T> flow, @NotNull Function3<? super T, ? super T, ? super Continuation<? super T>, ? extends Object> function3) {
        return FlowKt__TransformKt.runningReduce(flow, function3);
    }

    @FlowPreview
    @NotNull
    public static final <T> Flow<T> sample(@NotNull Flow<? extends T> flow, long j3) {
        return FlowKt__DelayKt.sample(flow, j3);
    }

    @FlowPreview
    @ExperimentalTime
    @NotNull
    /* renamed from: sample-HG0u8IE, reason: not valid java name */
    public static final <T> Flow<T> m2028sampleHG0u8IE(@NotNull Flow<? extends T> flow, long j3) {
        return FlowKt__DelayKt.m2030sampleHG0u8IE(flow, j3);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T, R> Flow<R> scan(@NotNull Flow<? extends T> flow, R r16, @BuilderInference @NotNull Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> function3) {
        return FlowKt__TransformKt.scan(flow, r16, function3);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow has less verbose 'scan' shortcut", replaceWith = @ReplaceWith(expression = "scan(initial, operation)", imports = {}))
    @NotNull
    public static final <T, R> Flow<R> scanFold(@NotNull Flow<? extends T> flow, R r16, @BuilderInference @NotNull Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> function3) {
        return FlowKt__MigrationKt.scanFold(flow, r16, function3);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "'scanReduce' was renamed to 'runningReduce' to be consistent with Kotlin standard library", replaceWith = @ReplaceWith(expression = "runningReduce(operation)", imports = {}))
    @NotNull
    public static final <T> Flow<T> scanReduce(@NotNull Flow<? extends T> flow, @NotNull Function3<? super T, ? super T, ? super Continuation<? super T>, ? extends Object> function3) {
        return FlowKt__MigrationKt.scanReduce(flow, function3);
    }

    @NotNull
    public static final <T> SharedFlow<T> shareIn(@NotNull Flow<? extends T> flow, @NotNull CoroutineScope coroutineScope, @NotNull SharingStarted sharingStarted, int i3) {
        return FlowKt__ShareKt.shareIn(flow, coroutineScope, sharingStarted, i3);
    }

    @Nullable
    public static final <T> Object single(@NotNull Flow<? extends T> flow, @NotNull Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.single(flow, continuation);
    }

    @Nullable
    public static final <T> Object singleOrNull(@NotNull Flow<? extends T> flow, @NotNull Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.singleOrNull(flow, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'skip' is 'drop'", replaceWith = @ReplaceWith(expression = "drop(count)", imports = {}))
    @NotNull
    public static final <T> Flow<T> skip(@NotNull Flow<? extends T> flow, int i3) {
        return FlowKt__MigrationKt.skip(flow, i3);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'startWith' is 'onStart'. Use 'onStart { emit(value) }'", replaceWith = @ReplaceWith(expression = "onStart { emit(value) }", imports = {}))
    @NotNull
    public static final <T> Flow<T> startWith(@NotNull Flow<? extends T> flow, T t16) {
        return FlowKt__MigrationKt.startWith(flow, t16);
    }

    @Nullable
    public static final <T> Object stateIn(@NotNull Flow<? extends T> flow, @NotNull CoroutineScope coroutineScope, @NotNull Continuation<? super StateFlow<? extends T>> continuation) {
        return FlowKt__ShareKt.stateIn(flow, coroutineScope, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    public static final <T> void subscribe(@NotNull Flow<? extends T> flow) {
        FlowKt__MigrationKt.subscribe(flow);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'flowOn' instead")
    @NotNull
    public static final <T> Flow<T> subscribeOn(@NotNull Flow<? extends T> flow, @NotNull CoroutineContext coroutineContext) {
        return FlowKt__MigrationKt.subscribeOn(flow, coroutineContext);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogues of 'switchMap' are 'transformLatest', 'flatMapLatest' and 'mapLatest'", replaceWith = @ReplaceWith(expression = "this.flatMapLatest(transform)", imports = {}))
    @NotNull
    public static final <T, R> Flow<R> switchMap(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> function2) {
        return FlowKt__MigrationKt.switchMap(flow, function2);
    }

    @NotNull
    public static final <T> Flow<T> take(@NotNull Flow<? extends T> flow, int i3) {
        return FlowKt__LimitKt.take(flow, i3);
    }

    @NotNull
    public static final <T> Flow<T> takeWhile(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return FlowKt__LimitKt.takeWhile(flow, function2);
    }

    @Nullable
    public static final <T, C extends Collection<? super T>> Object toCollection(@NotNull Flow<? extends T> flow, @NotNull C c16, @NotNull Continuation<? super C> continuation) {
        return FlowKt__CollectionKt.toCollection(flow, c16, continuation);
    }

    @Nullable
    public static final <T> Object toList(@NotNull Flow<? extends T> flow, @NotNull List<T> list, @NotNull Continuation<? super List<? extends T>> continuation) {
        return FlowKt__CollectionKt.toList(flow, list, continuation);
    }

    @Nullable
    public static final <T> Object toSet(@NotNull Flow<? extends T> flow, @NotNull Set<T> set, @NotNull Continuation<? super Set<? extends T>> continuation) {
        return FlowKt__CollectionKt.toSet(flow, set, continuation);
    }

    @NotNull
    public static final <T, R> Flow<R> transform(@NotNull Flow<? extends T> flow, @BuilderInference @NotNull Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> function3) {
        return FlowKt__EmittersKt.transform(flow, function3);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T, R> Flow<R> transformLatest(@NotNull Flow<? extends T> flow, @BuilderInference @NotNull Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> function3) {
        return FlowKt__MergeKt.transformLatest(flow, function3);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T, R> Flow<R> transformWhile(@NotNull Flow<? extends T> flow, @BuilderInference @NotNull Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Boolean>, ? extends Object> function3) {
        return FlowKt__LimitKt.transformWhile(flow, function3);
    }

    @PublishedApi
    @NotNull
    public static final <T, R> Flow<R> unsafeTransform(@NotNull Flow<? extends T> flow, @BuilderInference @NotNull Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> function3) {
        return FlowKt__EmittersKt.unsafeTransform(flow, function3);
    }

    @NotNull
    public static final <T> Flow<IndexedValue<T>> withIndex(@NotNull Flow<? extends T> flow) {
        return FlowKt__TransformKt.withIndex(flow);
    }

    @NotNull
    public static final <T1, T2, R> Flow<R> zip(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3) {
        return FlowKt__ZipKt.zip(flow, flow2, function3);
    }

    @NotNull
    public static final <T> Flow<T> asFlow(@NotNull Iterator<? extends T> it) {
        return FlowKt__BuildersKt.asFlow(it);
    }

    @NotNull
    public static final <T> Flow<T> buffer(@NotNull Flow<? extends T> flow, int i3, @NotNull BufferOverflow bufferOverflow) {
        return FlowKt__ContextKt.buffer(flow, i3, bufferOverflow);
    }

    @Nullable
    public static final <T> Object collect(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2, @NotNull Continuation<? super Unit> continuation) {
        return FlowKt__CollectKt.collect(flow, function2, continuation);
    }

    @NotNull
    public static final <T1, T2, R> Flow<R> combine(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3) {
        return FlowKt__ZipKt.combine(flow, flow2, function3);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(expression = "combine(this, other, other2, transform)", imports = {}))
    @NotNull
    public static final <T1, T2, T3, R> Flow<R> combineLatest(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull Flow<? extends T3> flow3, @NotNull Function4<? super T1, ? super T2, ? super T3, ? super Continuation<? super R>, ? extends Object> function4) {
        return FlowKt__MigrationKt.combineLatest(flow, flow2, flow3, function4);
    }

    @NotNull
    public static final <T1, T2, R> Flow<R> combineTransform(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @BuilderInference @NotNull Function4<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super Continuation<? super Unit>, ? extends Object> function4) {
        return FlowKt__ZipKt.combineTransform(flow, flow2, function4);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'concatWith' is 'onCompletion'. Use 'onCompletion { if (it == null) emitAll(other) }'", replaceWith = @ReplaceWith(expression = "onCompletion { if (it == null) emitAll(other) }", imports = {}))
    @NotNull
    public static final <T> Flow<T> concatWith(@NotNull Flow<? extends T> flow, @NotNull Flow<? extends T> flow2) {
        return FlowKt__MigrationKt.concatWith((Flow) flow, (Flow) flow2);
    }

    @Nullable
    public static final <T> Object count(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, @NotNull Continuation<? super Integer> continuation) {
        return FlowKt__CountKt.count(flow, function2, continuation);
    }

    @FlowPreview
    @OverloadResolutionByLambdaReturnType
    @NotNull
    public static final <T> Flow<T> debounce(@NotNull Flow<? extends T> flow, @NotNull Function1<? super T, Long> function1) {
        return FlowKt__DelayKt.debounce(flow, function1);
    }

    @NotNull
    public static final <T> Flow<T> distinctUntilChanged(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super T, Boolean> function2) {
        return FlowKt__DistinctKt.distinctUntilChanged(flow, function2);
    }

    @Nullable
    public static final <T> Object emitAll(@NotNull FlowCollector<? super T> flowCollector, @NotNull Flow<? extends T> flow, @NotNull Continuation<? super Unit> continuation) {
        return FlowKt__CollectKt.emitAll(flowCollector, flow, continuation);
    }

    @Nullable
    public static final <T> Object first(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.first(flow, function2, continuation);
    }

    @Nullable
    public static final <T> Object firstOrNull(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.firstOrNull(flow, function2, continuation);
    }

    @NotNull
    public static final <T> Flow<T> flowOf(@NotNull T... tArr) {
        return FlowKt__BuildersKt.flowOf((Object[]) tArr);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'merge' is 'flattenConcat'", replaceWith = @ReplaceWith(expression = "flattenConcat()", imports = {}))
    @NotNull
    public static final <T> Flow<T> merge(@NotNull Flow<? extends Flow<? extends T>> flow) {
        return FlowKt__MigrationKt.merge(flow);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { e -> if (predicate(e)) emit(fallback) else throw e }'", replaceWith = @ReplaceWith(expression = "catch { e -> if (predicate(e)) emit(fallback) else throw e }", imports = {}))
    @NotNull
    public static final <T> Flow<T> onErrorReturn(@NotNull Flow<? extends T> flow, T t16, @NotNull Function1<? super Throwable, Boolean> function1) {
        return FlowKt__MigrationKt.onErrorReturn(flow, t16, function1);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'publish(bufferSize)' is 'buffer' followed by 'shareIn'. \npublish().connect() is the default strategy (no extra call is needed), \npublish().autoConnect() translates to 'started = SharingStared.Lazily' argument, \npublish().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @ReplaceWith(expression = "this.buffer(bufferSize).shareIn(scope, 0)", imports = {}))
    @NotNull
    public static final <T> Flow<T> publish(@NotNull Flow<? extends T> flow, int i3) {
        return FlowKt__MigrationKt.publish(flow, i3);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'replay(bufferSize)' is 'shareIn' with the specified replay parameter. \nreplay().connect() is the default strategy (no extra call is needed), \nreplay().autoConnect() translates to 'started = SharingStared.Lazily' argument, \nreplay().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @ReplaceWith(expression = "this.shareIn(scope, bufferSize)", imports = {}))
    @NotNull
    public static final <T> Flow<T> replay(@NotNull Flow<? extends T> flow, int i3) {
        return FlowKt__MigrationKt.replay(flow, i3);
    }

    @NotNull
    public static final <T> Flow<T> retry(@NotNull Flow<? extends T> flow, long j3, @NotNull Function2<? super Throwable, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return FlowKt__ErrorsKt.retry(flow, j3, function2);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'startWith' is 'onStart'. Use 'onStart { emitAll(other) }'", replaceWith = @ReplaceWith(expression = "onStart { emitAll(other) }", imports = {}))
    @NotNull
    public static final <T> Flow<T> startWith(@NotNull Flow<? extends T> flow, @NotNull Flow<? extends T> flow2) {
        return FlowKt__MigrationKt.startWith((Flow) flow, (Flow) flow2);
    }

    @NotNull
    public static final <T> StateFlow<T> stateIn(@NotNull Flow<? extends T> flow, @NotNull CoroutineScope coroutineScope, @NotNull SharingStarted sharingStarted, T t16) {
        return FlowKt__ShareKt.stateIn(flow, coroutineScope, sharingStarted, t16);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    public static final <T> void subscribe(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2) {
        FlowKt__MigrationKt.subscribe(flow, function2);
    }

    @FlowPreview
    @NotNull
    public static final <T> Flow<T> asFlow(@NotNull Function0<? extends T> function0) {
        return FlowKt__BuildersKt.asFlow(function0);
    }

    @NotNull
    public static final <T1, T2, T3, R> Flow<R> combine(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull Flow<? extends T3> flow3, @BuilderInference @NotNull Function4<? super T1, ? super T2, ? super T3, ? super Continuation<? super R>, ? extends Object> function4) {
        return FlowKt__ZipKt.combine(flow, flow2, flow3, function4);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(expression = "combine(this, other, other2, other3, transform)", imports = {}))
    @NotNull
    public static final <T1, T2, T3, T4, R> Flow<R> combineLatest(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull Flow<? extends T3> flow3, @NotNull Flow<? extends T4> flow4, @NotNull Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super Continuation<? super R>, ? extends Object> function5) {
        return FlowKt__MigrationKt.combineLatest(flow, flow2, flow3, flow4, function5);
    }

    @NotNull
    public static final <T1, T2, T3, R> Flow<R> combineTransform(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull Flow<? extends T3> flow3, @BuilderInference @NotNull Function5<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super T3, ? super Continuation<? super Unit>, ? extends Object> function5) {
        return FlowKt__ZipKt.combineTransform(flow, flow2, flow3, function5);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T> Flow<T> merge(@NotNull Flow<? extends T>... flowArr) {
        return FlowKt__MergeKt.merge(flowArr);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    public static final <T> void subscribe(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2, @NotNull Function2<? super Throwable, ? super Continuation<? super Unit>, ? extends Object> function22) {
        FlowKt__MigrationKt.subscribe(flow, function2, function22);
    }

    @FlowPreview
    @NotNull
    public static final <T> Flow<T> asFlow(@NotNull Function1<? super Continuation<? super T>, ? extends Object> function1) {
        return FlowKt__BuildersKt.asFlow(function1);
    }

    @NotNull
    public static final <T1, T2, T3, T4, R> Flow<R> combine(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull Flow<? extends T3> flow3, @NotNull Flow<? extends T4> flow4, @NotNull Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super Continuation<? super R>, ? extends Object> function5) {
        return FlowKt__ZipKt.combine(flow, flow2, flow3, flow4, function5);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(expression = "combine(this, other, other2, other3, transform)", imports = {}))
    @NotNull
    public static final <T1, T2, T3, T4, T5, R> Flow<R> combineLatest(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull Flow<? extends T3> flow3, @NotNull Flow<? extends T4> flow4, @NotNull Flow<? extends T5> flow5, @NotNull Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super Continuation<? super R>, ? extends Object> function6) {
        return FlowKt__MigrationKt.combineLatest(flow, flow2, flow3, flow4, flow5, function6);
    }

    @NotNull
    public static final <T1, T2, T3, T4, R> Flow<R> combineTransform(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull Flow<? extends T3> flow3, @NotNull Flow<? extends T4> flow4, @BuilderInference @NotNull Function6<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super T3, ? super T4, ? super Continuation<? super Unit>, ? extends Object> function6) {
        return FlowKt__ZipKt.combineTransform(flow, flow2, flow3, flow4, function6);
    }

    @NotNull
    public static final Flow<Integer> asFlow(@NotNull IntRange intRange) {
        return FlowKt__BuildersKt.asFlow(intRange);
    }

    @NotNull
    public static final <T1, T2, T3, T4, T5, R> Flow<R> combine(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull Flow<? extends T3> flow3, @NotNull Flow<? extends T4> flow4, @NotNull Flow<? extends T5> flow5, @NotNull Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super Continuation<? super R>, ? extends Object> function6) {
        return FlowKt__ZipKt.combine(flow, flow2, flow3, flow4, flow5, function6);
    }

    @NotNull
    public static final <T1, T2, T3, T4, T5, R> Flow<R> combineTransform(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull Flow<? extends T3> flow3, @NotNull Flow<? extends T4> flow4, @NotNull Flow<? extends T5> flow5, @BuilderInference @NotNull Function7<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super Continuation<? super Unit>, ? extends Object> function7) {
        return FlowKt__ZipKt.combineTransform(flow, flow2, flow3, flow4, flow5, function7);
    }

    @NotNull
    public static final Flow<Long> asFlow(@NotNull LongRange longRange) {
        return FlowKt__BuildersKt.asFlow(longRange);
    }

    @NotNull
    public static final <T> Flow<T> asFlow(@NotNull Sequence<? extends T> sequence) {
        return FlowKt__BuildersKt.asFlow(sequence);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "'BroadcastChannel' is obsolete and all coreresponding operators are deprecated in the favour of StateFlow and SharedFlow")
    @NotNull
    public static final <T> Flow<T> asFlow(@NotNull BroadcastChannel<T> broadcastChannel) {
        return FlowKt__ChannelsKt.asFlow(broadcastChannel);
    }

    @NotNull
    public static final Flow<Integer> asFlow(@NotNull int[] iArr) {
        return FlowKt__BuildersKt.asFlow(iArr);
    }

    @NotNull
    public static final Flow<Long> asFlow(@NotNull long[] jArr) {
        return FlowKt__BuildersKt.asFlow(jArr);
    }

    @NotNull
    public static final <T> Flow<T> asFlow(@NotNull T[] tArr) {
        return FlowKt__BuildersKt.asFlow(tArr);
    }
}
