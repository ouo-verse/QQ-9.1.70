package androidx.compose.runtime;

import androidx.compose.runtime.Recomposer;
import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet;
import androidx.compose.runtime.snapshots.MutableSnapshot;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotApplyResult;
import androidx.compose.runtime.tooling.CompositionData;
import com.tencent.mobileqq.troop.homework.api.IHWTroopUtilsApi;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt__SetsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0090\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 \u009d\u00012\u00020\u0001:\b\u009d\u0001\u009e\u0001\u009f\u0001\u00a0\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010M\u001a\u00020L2\u0006\u0010N\u001a\u00020OH\u0002J\u0006\u0010P\u001a\u00020QJ\u0011\u0010R\u001a\u00020LH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010SJ\u0011\u0010T\u001a\u00020LH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010SJ\u0006\u0010U\u001a\u00020LJ\u0006\u0010V\u001a\u00020LJ*\u0010W\u001a\u00020L2\u0006\u0010X\u001a\u00020\u00172\u0011\u0010Y\u001a\r\u0012\u0004\u0012\u00020L0Z\u00a2\u0006\u0002\b[H\u0010\u00a2\u0006\u0004\b\\\u0010]J:\u0010^\u001a\u0002H_\"\u0004\b\u0000\u0010_2\u0006\u0010X\u001a\u00020\u00172\u000e\u0010`\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010a2\f\u0010b\u001a\b\u0012\u0004\u0012\u0002H_0ZH\u0082\b\u00a2\u0006\u0002\u0010cJ\u0015\u0010d\u001a\u00020L2\u0006\u0010e\u001a\u00020\u001aH\u0010\u00a2\u0006\u0002\bfJ\u0010\u0010g\u001a\n\u0012\u0004\u0012\u00020L\u0018\u00010KH\u0002J\b\u0010h\u001a\u00020LH\u0002J\u0015\u0010i\u001a\u00020L2\u0006\u0010e\u001a\u00020\u001aH\u0010\u00a2\u0006\u0002\bjJ\u0015\u0010k\u001a\u00020L2\u0006\u0010X\u001a\u00020\u0017H\u0010\u00a2\u0006\u0002\blJ\u0015\u0010m\u001a\u00020L2\u0006\u0010n\u001a\u00020oH\u0010\u00a2\u0006\u0002\bpJ\u0011\u0010q\u001a\u00020LH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010SJ\u001d\u0010r\u001a\u00020L2\u0006\u0010e\u001a\u00020\u001a2\u0006\u0010s\u001a\u00020\u001bH\u0010\u00a2\u0006\u0002\btJ\u0017\u0010u\u001a\u0004\u0018\u00010\u001b2\u0006\u0010e\u001a\u00020\u001aH\u0010\u00a2\u0006\u0002\bvJ\u0010\u0010w\u001a\u00020L2\u0006\u0010X\u001a\u00020\u0017H\u0002J,\u0010x\u001a\b\u0012\u0004\u0012\u00020\u00170y2\f\u0010z\u001a\b\u0012\u0004\u0012\u00020\u001a0y2\u000e\u0010`\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010aH\u0002J\"\u0010{\u001a\u0004\u0018\u00010\u00172\u0006\u0010X\u001a\u00020\u00172\u000e\u0010`\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010aH\u0002J\u001c\u0010|\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020L0}2\u0006\u0010X\u001a\u00020\u0017H\u0002JW\u0010~\u001a\u00020L2C\u0010b\u001a?\b\u0001\u0012\u0005\u0012\u00030\u0080\u0001\u0012\u0017\u0012\u00150\u0081\u0001\u00a2\u0006\u000f\b\u0082\u0001\u0012\n\b\u0083\u0001\u0012\u0005\b\b(\u0084\u0001\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020L0\u0085\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u007f\u00a2\u0006\u0003\b\u0086\u0001H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0003\u0010\u0087\u0001J\t\u0010\u0088\u0001\u001a\u00020LH\u0002J\u001f\u0010\u0088\u0001\u001a\u00020L2\u0013\u0010\u0089\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020L0}H\u0082\bJ \u0010\u008a\u0001\u001a\u00020L2\u000f\u0010\u008b\u0001\u001a\n\u0012\u0005\u0012\u00030\u008d\u00010\u008c\u0001H\u0010\u00a2\u0006\u0003\b\u008e\u0001J\u0017\u0010\u008f\u0001\u001a\u00020L2\u0006\u0010X\u001a\u00020\u0017H\u0010\u00a2\u0006\u0003\b\u0090\u0001J\u0012\u0010\u0091\u0001\u001a\u00020L2\u0007\u0010\u0092\u0001\u001a\u00020=H\u0002J'\u0010\u0093\u0001\u001a\u00020L2\b\u0010\u0084\u0001\u001a\u00030\u0081\u00012\b\u0010\u0094\u0001\u001a\u00030\u0095\u0001H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0003\u0010\u0096\u0001J\u0012\u0010\u0097\u0001\u001a\u00020LH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010SJ\u001b\u0010\u0098\u0001\u001a\u00020L2\u0006\u00108\u001a\u00020\u0003H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0003\u0010\u0099\u0001J\u0017\u0010\u009a\u0001\u001a\u00020L2\u0006\u0010X\u001a\u00020\u0017H\u0010\u00a2\u0006\u0003\b\u009b\u0001J-\u0010\u009c\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020L0}2\u0006\u0010X\u001a\u00020\u00172\u000e\u0010`\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010aH\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128PX\u0090\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R(\u0010\u001d\u001a\u001c\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00160\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010!\u001a\u00020\"8PX\u0090\u0004\u00a2\u0006\u0006\u001a\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020\"X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00070'8F\u00a2\u0006\u0006\u001a\u0004\b(\u0010)R\u0014\u0010\u0002\u001a\u00020\u0003X\u0090\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u000e\u0010,\u001a\u00020-X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010.\u001a\u00020\u00128BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b/\u0010\u0014R\u0014\u00100\u001a\u00020\u00128BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b1\u0010\u0014R\u0011\u00102\u001a\u00020\u00128F\u00a2\u0006\u0006\u001a\u0004\b3\u0010\u0014R\u0014\u00104\u001a\u00020\u00128BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b5\u0010\u0014R\u000e\u00106\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u00107\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u00108\u001a\u00020\u00038PX\u0090\u0004\u00a2\u0006\u0006\u001a\u0004\b9\u0010+R\u0012\u0010:\u001a\u00060;R\u00020\u0000X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010=X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010>\u001a\u00020\u00128BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b?\u0010\u0014R\u001a\u0010@\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0A0\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010B\u001a\b\u0012\u0004\u0012\u00020\u00070C8FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\bD\u0010E\u001a\u0004\bF\u0010GR\u000e\u0010H\u001a\u00020IX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010J\u001a\n\u0012\u0004\u0012\u00020L\u0018\u00010KX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u00a1\u0001"}, d2 = {"Landroidx/compose/runtime/Recomposer;", "Landroidx/compose/runtime/CompositionContext;", "effectCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/CoroutineContext;)V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroidx/compose/runtime/Recomposer$State;", "broadcastFrameClock", "Landroidx/compose/runtime/BroadcastFrameClock;", "<set-?>", "", "changeCount", "getChangeCount", "()J", "closeCause", "", "collectingParameterInformation", "", "getCollectingParameterInformation$runtime_release", "()Z", "compositionInvalidations", "", "Landroidx/compose/runtime/ControlledComposition;", "compositionValueStatesAvailable", "", "Landroidx/compose/runtime/MovableContentStateReference;", "Landroidx/compose/runtime/MovableContentState;", "compositionValuesAwaitingInsert", "compositionValuesRemoved", "Landroidx/compose/runtime/MovableContent;", "", "compositionsAwaitingApply", "compoundHashKey", "", "getCompoundHashKey$runtime_release", "()I", "concurrentCompositionsOutstanding", "currentState", "Lkotlinx/coroutines/flow/StateFlow;", "getCurrentState", "()Lkotlinx/coroutines/flow/StateFlow;", "getEffectCoroutineContext$runtime_release", "()Lkotlin/coroutines/CoroutineContext;", "effectJob", "Lkotlinx/coroutines/CompletableJob;", "hasConcurrentFrameWorkLocked", "getHasConcurrentFrameWorkLocked", "hasFrameWorkLocked", "getHasFrameWorkLocked", "hasPendingWork", "getHasPendingWork", "hasSchedulingWork", "getHasSchedulingWork", "isClosed", "knownCompositions", "recomposeCoroutineContext", "getRecomposeCoroutineContext$runtime_release", "recomposerInfo", "Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;", "runnerJob", "Lkotlinx/coroutines/Job;", "shouldKeepRecomposing", "getShouldKeepRecomposing", "snapshotInvalidations", "", "state", "Lkotlinx/coroutines/flow/Flow;", "getState$annotations", "()V", "getState", "()Lkotlinx/coroutines/flow/Flow;", "stateLock", "Landroidx/compose/runtime/SynchronizedObject;", "workContinuation", "Lkotlinx/coroutines/CancellableContinuation;", "", "applyAndCheck", "snapshot", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "asRecomposerInfo", "Landroidx/compose/runtime/RecomposerInfo;", "awaitIdle", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitWorkAvailable", "cancel", "close", "composeInitial", "composition", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "composeInitial$runtime_release", "(Landroidx/compose/runtime/ControlledComposition;Lkotlin/jvm/functions/Function2;)V", "composing", "T", "modifiedValues", "Landroidx/compose/runtime/collection/IdentityArraySet;", "block", "(Landroidx/compose/runtime/ControlledComposition;Landroidx/compose/runtime/collection/IdentityArraySet;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "deletedMovableContent", "reference", "deletedMovableContent$runtime_release", "deriveStateLocked", "discardUnusedValues", "insertMovableContent", "insertMovableContent$runtime_release", "invalidate", "invalidate$runtime_release", "invalidateScope", "scope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "invalidateScope$runtime_release", IHWTroopUtilsApi.HOMEWORK_TROOP_JOIN_SOURCE, "movableContentStateReleased", "data", "movableContentStateReleased$runtime_release", "movableContentStateResolve", "movableContentStateResolve$runtime_release", "performInitialMovableContentInserts", "performInsertValues", "", "references", "performRecompose", "readObserverOf", "Lkotlin/Function1;", "recompositionRunner", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/compose/runtime/MonotonicFrameClock;", "Lkotlin/ParameterName;", "name", "parentFrameClock", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recordComposerModificationsLocked", "onEachInvalidComposition", "recordInspectionTable", "table", "", "Landroidx/compose/runtime/tooling/CompositionData;", "recordInspectionTable$runtime_release", "registerComposition", "registerComposition$runtime_release", "registerRunnerJob", "callingJob", "runFrameLoop", "frameSignal", "Landroidx/compose/runtime/ProduceFrameSignal;", "(Landroidx/compose/runtime/MonotonicFrameClock;Landroidx/compose/runtime/ProduceFrameSignal;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runRecomposeAndApplyChanges", "runRecomposeConcurrentlyAndApplyChanges", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unregisterComposition", "unregisterComposition$runtime_release", "writeObserverOf", "Companion", "HotReloadable", "RecomposerInfoImpl", "State", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes39.dex */
public final class Recomposer extends CompositionContext {
    private final MutableStateFlow<State> _state;
    private final BroadcastFrameClock broadcastFrameClock;
    private long changeCount;
    private Throwable closeCause;
    private final List<ControlledComposition> compositionInvalidations;
    private final Map<MovableContentStateReference, MovableContentState> compositionValueStatesAvailable;
    private final List<MovableContentStateReference> compositionValuesAwaitingInsert;
    private final Map<MovableContent<Object>, List<MovableContentStateReference>> compositionValuesRemoved;
    private final List<ControlledComposition> compositionsAwaitingApply;
    private int concurrentCompositionsOutstanding;
    private final CoroutineContext effectCoroutineContext;
    private final CompletableJob effectJob;
    private boolean isClosed;
    private final List<ControlledComposition> knownCompositions;
    private final RecomposerInfoImpl recomposerInfo;
    private Job runnerJob;
    private final List<Set<Object>> snapshotInvalidations;
    private final SynchronizedObject stateLock;
    private CancellableContinuation<? super Unit> workContinuation;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final MutableStateFlow<PersistentSet<RecomposerInfoImpl>> _runningRecomposers = StateFlowKt.MutableStateFlow(ExtensionsKt.persistentSetOf());

    /* compiled from: P */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\u000e\u001a\u00020\u000f2\n\u0010\u0010\u001a\u00060\u0006R\u00020\u0007H\u0002J\u0015\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0000\u00a2\u0006\u0002\b\u0014J\u0015\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0001H\u0000\u00a2\u0006\u0002\b\u0017J\u0014\u0010\u0018\u001a\u00020\u000f2\n\u0010\u0010\u001a\u00060\u0006R\u00020\u0007H\u0002J\r\u0010\u0019\u001a\u00020\u0001H\u0000\u00a2\u0006\u0002\b\u001aR\u001e\u0010\u0003\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0006R\u00020\u00070\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t8F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\r\u00a8\u0006\u001b"}, d2 = {"Landroidx/compose/runtime/Recomposer$Companion;", "", "()V", "_runningRecomposers", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;", "Landroidx/compose/runtime/Recomposer;", "runningRecomposers", "Lkotlinx/coroutines/flow/StateFlow;", "", "Landroidx/compose/runtime/RecomposerInfo;", "getRunningRecomposers", "()Lkotlinx/coroutines/flow/StateFlow;", "addRunning", "", "info", "invalidateGroupsWithKey", "key", "", "invalidateGroupsWithKey$runtime_release", "loadStateAndComposeForHotReload", "token", "loadStateAndComposeForHotReload$runtime_release", "removeRunning", "saveStateAndDisposeForHotReload", "saveStateAndDisposeForHotReload$runtime_release", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes39.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void addRunning(RecomposerInfoImpl info) {
            PersistentSet persistentSet;
            PersistentSet add;
            do {
                persistentSet = (PersistentSet) Recomposer._runningRecomposers.getValue();
                add = persistentSet.add((PersistentSet) info);
                if (persistentSet == add) {
                    return;
                }
            } while (!Recomposer._runningRecomposers.compareAndSet(persistentSet, add));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void removeRunning(RecomposerInfoImpl info) {
            PersistentSet persistentSet;
            PersistentSet remove;
            do {
                persistentSet = (PersistentSet) Recomposer._runningRecomposers.getValue();
                remove = persistentSet.remove((PersistentSet) info);
                if (persistentSet == remove) {
                    return;
                }
            } while (!Recomposer._runningRecomposers.compareAndSet(persistentSet, remove));
        }

        public final StateFlow<Set<RecomposerInfo>> getRunningRecomposers() {
            return Recomposer._runningRecomposers;
        }

        public final void invalidateGroupsWithKey$runtime_release(int key) {
            Iterator it = ((Iterable) Recomposer._runningRecomposers.getValue()).iterator();
            while (it.hasNext()) {
                ((RecomposerInfoImpl) it.next()).invalidateGroupsWithKey(key);
            }
        }

        public final void loadStateAndComposeForHotReload$runtime_release(Object token) {
            Intrinsics.checkNotNullParameter(token, "token");
            List list = (List) token;
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                ((HotReloadable) list.get(i3)).resetContent();
            }
            int size2 = list.size();
            for (int i16 = 0; i16 < size2; i16++) {
                ((HotReloadable) list.get(i16)).recompose();
            }
        }

        public final Object saveStateAndDisposeForHotReload$runtime_release() {
            Iterable iterable = (Iterable) Recomposer._runningRecomposers.getValue();
            ArrayList arrayList = new ArrayList();
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                CollectionsKt__MutableCollectionsKt.addAll(arrayList, ((RecomposerInfoImpl) it.next()).saveStateAndDisposeForHotReload());
            }
            return arrayList;
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\n\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\u0007J\u0006\u0010\f\u001a\u00020\u0007R\u001b\u0010\u0005\u001a\r\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\b\bX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Landroidx/compose/runtime/Recomposer$HotReloadable;", "", "composition", "Landroidx/compose/runtime/CompositionImpl;", "(Landroidx/compose/runtime/CompositionImpl;)V", "composable", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/jvm/functions/Function2;", "clearContent", "recompose", "resetContent", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes39.dex */
    public static final class HotReloadable {
        private Function2<? super Composer, ? super Integer, Unit> composable;
        private final CompositionImpl composition;

        public HotReloadable(CompositionImpl composition) {
            Intrinsics.checkNotNullParameter(composition, "composition");
            this.composition = composition;
            this.composable = composition.getComposable();
        }

        public final void clearContent() {
            if (this.composition.getIsRoot()) {
                this.composition.setContent(ComposableSingletons$RecomposerKt.INSTANCE.m7getLambda1$runtime_release());
            }
        }

        public final void recompose() {
            if (this.composition.getIsRoot()) {
                this.composition.setContent(this.composable);
            }
        }

        public final void resetContent() {
            this.composition.setComposable(this.composable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0017"}, d2 = {"Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;", "Landroidx/compose/runtime/RecomposerInfo;", "(Landroidx/compose/runtime/Recomposer;)V", "changeCount", "", "getChangeCount", "()J", "hasPendingWork", "", "getHasPendingWork", "()Z", "state", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/compose/runtime/Recomposer$State;", "getState", "()Lkotlinx/coroutines/flow/Flow;", "invalidateGroupsWithKey", "", "key", "", "saveStateAndDisposeForHotReload", "", "Landroidx/compose/runtime/Recomposer$HotReloadable;", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes39.dex */
    public final class RecomposerInfoImpl implements RecomposerInfo {
        public RecomposerInfoImpl() {
        }

        @Override // androidx.compose.runtime.RecomposerInfo
        public long getChangeCount() {
            return Recomposer.this.getChangeCount();
        }

        @Override // androidx.compose.runtime.RecomposerInfo
        public boolean getHasPendingWork() {
            return Recomposer.this.getHasPendingWork();
        }

        @Override // androidx.compose.runtime.RecomposerInfo
        public Flow<State> getState() {
            return Recomposer.this.getCurrentState();
        }

        public final void invalidateGroupsWithKey(int key) {
            List mutableList;
            SynchronizedObject synchronizedObject = Recomposer.this.stateLock;
            Recomposer recomposer = Recomposer.this;
            synchronized (synchronizedObject) {
                mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) recomposer.knownCompositions);
            }
            ArrayList arrayList = new ArrayList(mutableList.size());
            int size = mutableList.size();
            for (int i3 = 0; i3 < size; i3++) {
                ControlledComposition controlledComposition = (ControlledComposition) mutableList.get(i3);
                CompositionImpl compositionImpl = controlledComposition instanceof CompositionImpl ? (CompositionImpl) controlledComposition : null;
                if (compositionImpl != null) {
                    arrayList.add(compositionImpl);
                }
            }
            int size2 = arrayList.size();
            for (int i16 = 0; i16 < size2; i16++) {
                ((CompositionImpl) arrayList.get(i16)).invalidateGroupsWithKey(key);
            }
        }

        public final List<HotReloadable> saveStateAndDisposeForHotReload() {
            List mutableList;
            SynchronizedObject synchronizedObject = Recomposer.this.stateLock;
            Recomposer recomposer = Recomposer.this;
            synchronized (synchronizedObject) {
                mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) recomposer.knownCompositions);
            }
            ArrayList arrayList = new ArrayList(mutableList.size());
            int size = mutableList.size();
            for (int i3 = 0; i3 < size; i3++) {
                ControlledComposition controlledComposition = (ControlledComposition) mutableList.get(i3);
                CompositionImpl compositionImpl = controlledComposition instanceof CompositionImpl ? (CompositionImpl) controlledComposition : null;
                if (compositionImpl != null) {
                    arrayList.add(compositionImpl);
                }
            }
            ArrayList arrayList2 = new ArrayList(arrayList.size());
            int size2 = arrayList.size();
            for (int i16 = 0; i16 < size2; i16++) {
                HotReloadable hotReloadable = new HotReloadable((CompositionImpl) arrayList.get(i16));
                hotReloadable.clearContent();
                arrayList2.add(hotReloadable);
            }
            return arrayList2;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Landroidx/compose/runtime/Recomposer$State;", "", "(Ljava/lang/String;I)V", "ShutDown", "ShuttingDown", "Inactive", "InactivePendingWork", "Idle", "PendingWork", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes39.dex */
    public enum State {
        ShutDown,
        ShuttingDown,
        Inactive,
        InactivePendingWork,
        Idle,
        PendingWork
    }

    public Recomposer(CoroutineContext effectCoroutineContext) {
        Intrinsics.checkNotNullParameter(effectCoroutineContext, "effectCoroutineContext");
        BroadcastFrameClock broadcastFrameClock = new BroadcastFrameClock(new Function0<Unit>() { // from class: androidx.compose.runtime.Recomposer$broadcastFrameClock$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                CancellableContinuation deriveStateLocked;
                MutableStateFlow mutableStateFlow;
                Throwable th5;
                SynchronizedObject synchronizedObject = Recomposer.this.stateLock;
                Recomposer recomposer = Recomposer.this;
                synchronized (synchronizedObject) {
                    deriveStateLocked = recomposer.deriveStateLocked();
                    mutableStateFlow = recomposer._state;
                    if (((Recomposer.State) mutableStateFlow.getValue()).compareTo(Recomposer.State.ShuttingDown) <= 0) {
                        th5 = recomposer.closeCause;
                        throw ExceptionsKt.CancellationException("Recomposer shutdown; frame clock awaiter will never resume", th5);
                    }
                }
                if (deriveStateLocked != null) {
                    Result.Companion companion = Result.INSTANCE;
                    deriveStateLocked.resumeWith(Result.m476constructorimpl(Unit.INSTANCE));
                }
            }
        });
        this.broadcastFrameClock = broadcastFrameClock;
        CompletableJob Job = JobKt.Job((Job) effectCoroutineContext.get(Job.INSTANCE));
        Job.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.compose.runtime.Recomposer$effectJob$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                invoke2(th5);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(final Throwable th5) {
                Job job;
                CancellableContinuation cancellableContinuation;
                MutableStateFlow mutableStateFlow;
                MutableStateFlow mutableStateFlow2;
                boolean z16;
                CancellableContinuation cancellableContinuation2;
                CancellableContinuation cancellableContinuation3;
                CancellationException CancellationException = ExceptionsKt.CancellationException("Recomposer effect job completed", th5);
                SynchronizedObject synchronizedObject = Recomposer.this.stateLock;
                final Recomposer recomposer = Recomposer.this;
                synchronized (synchronizedObject) {
                    job = recomposer.runnerJob;
                    cancellableContinuation = null;
                    if (job != null) {
                        mutableStateFlow2 = recomposer._state;
                        mutableStateFlow2.setValue(Recomposer.State.ShuttingDown);
                        z16 = recomposer.isClosed;
                        if (z16) {
                            cancellableContinuation2 = recomposer.workContinuation;
                            if (cancellableContinuation2 != null) {
                                cancellableContinuation3 = recomposer.workContinuation;
                                recomposer.workContinuation = null;
                                job.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.compose.runtime.Recomposer$effectJob$1$1$1$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Throwable th6) {
                                        invoke2(th6);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(Throwable th6) {
                                        MutableStateFlow mutableStateFlow3;
                                        SynchronizedObject synchronizedObject2 = Recomposer.this.stateLock;
                                        Recomposer recomposer2 = Recomposer.this;
                                        Throwable th7 = th5;
                                        synchronized (synchronizedObject2) {
                                            if (th7 == null) {
                                                th7 = null;
                                            } else if (th6 != null) {
                                                if (!(!(th6 instanceof CancellationException))) {
                                                    th6 = null;
                                                }
                                                if (th6 != null) {
                                                    ExceptionsKt__ExceptionsKt.addSuppressed(th7, th6);
                                                }
                                            }
                                            recomposer2.closeCause = th7;
                                            mutableStateFlow3 = recomposer2._state;
                                            mutableStateFlow3.setValue(Recomposer.State.ShutDown);
                                            Unit unit = Unit.INSTANCE;
                                        }
                                    }
                                });
                                cancellableContinuation = cancellableContinuation3;
                            }
                        } else {
                            job.cancel(CancellationException);
                        }
                        cancellableContinuation3 = null;
                        recomposer.workContinuation = null;
                        job.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.compose.runtime.Recomposer$effectJob$1$1$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Throwable th6) {
                                invoke2(th6);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Throwable th6) {
                                MutableStateFlow mutableStateFlow3;
                                SynchronizedObject synchronizedObject2 = Recomposer.this.stateLock;
                                Recomposer recomposer2 = Recomposer.this;
                                Throwable th7 = th5;
                                synchronized (synchronizedObject2) {
                                    if (th7 == null) {
                                        th7 = null;
                                    } else if (th6 != null) {
                                        if (!(!(th6 instanceof CancellationException))) {
                                            th6 = null;
                                        }
                                        if (th6 != null) {
                                            ExceptionsKt__ExceptionsKt.addSuppressed(th7, th6);
                                        }
                                    }
                                    recomposer2.closeCause = th7;
                                    mutableStateFlow3 = recomposer2._state;
                                    mutableStateFlow3.setValue(Recomposer.State.ShutDown);
                                    Unit unit = Unit.INSTANCE;
                                }
                            }
                        });
                        cancellableContinuation = cancellableContinuation3;
                    } else {
                        recomposer.closeCause = CancellationException;
                        mutableStateFlow = recomposer._state;
                        mutableStateFlow.setValue(Recomposer.State.ShutDown);
                        Unit unit = Unit.INSTANCE;
                    }
                }
                if (cancellableContinuation != null) {
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m476constructorimpl(Unit.INSTANCE));
                }
            }
        });
        this.effectJob = Job;
        this.effectCoroutineContext = effectCoroutineContext.plus(broadcastFrameClock).plus(Job);
        this.stateLock = SynchronizationKt.createSynchronizedObject();
        this.knownCompositions = new ArrayList();
        this.snapshotInvalidations = new ArrayList();
        this.compositionInvalidations = new ArrayList();
        this.compositionsAwaitingApply = new ArrayList();
        this.compositionValuesAwaitingInsert = new ArrayList();
        this.compositionValuesRemoved = new LinkedHashMap();
        this.compositionValueStatesAvailable = new LinkedHashMap();
        this._state = StateFlowKt.MutableStateFlow(State.Inactive);
        this.recomposerInfo = new RecomposerInfoImpl();
    }

    private final void applyAndCheck(MutableSnapshot snapshot) {
        try {
            if (snapshot.apply() instanceof SnapshotApplyResult.Failure) {
                throw new IllegalStateException("Unsupported concurrent change during composition. A state object was modified by composition as well as being modified outside composition.".toString());
            }
        } finally {
            snapshot.dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object awaitWorkAvailable(Continuation<? super Unit> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        Object coroutine_suspended2;
        if (!getHasSchedulingWork()) {
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
            cancellableContinuationImpl.initCancellability();
            synchronized (this.stateLock) {
                if (!getHasSchedulingWork()) {
                    this.workContinuation = cancellableContinuationImpl;
                } else {
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(Unit.INSTANCE));
                }
                Unit unit = Unit.INSTANCE;
            }
            Object result = cancellableContinuationImpl.getResult();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (result == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            return result == coroutine_suspended2 ? result : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    private final <T> T composing(ControlledComposition composition, IdentityArraySet<Object> modifiedValues, Function0<? extends T> block) {
        MutableSnapshot takeMutableSnapshot = Snapshot.INSTANCE.takeMutableSnapshot(readObserverOf(composition), writeObserverOf(composition, modifiedValues));
        try {
            Snapshot makeCurrent = takeMutableSnapshot.makeCurrent();
            try {
                return block.invoke();
            } finally {
                InlineMarker.finallyStart(1);
                takeMutableSnapshot.restoreCurrent(makeCurrent);
                InlineMarker.finallyEnd(1);
            }
        } finally {
            InlineMarker.finallyStart(1);
            applyAndCheck(takeMutableSnapshot);
            InlineMarker.finallyEnd(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CancellableContinuation<Unit> deriveStateLocked() {
        State state;
        if (this._state.getValue().compareTo(State.ShuttingDown) <= 0) {
            this.knownCompositions.clear();
            this.snapshotInvalidations.clear();
            this.compositionInvalidations.clear();
            this.compositionsAwaitingApply.clear();
            this.compositionValuesAwaitingInsert.clear();
            CancellableContinuation<? super Unit> cancellableContinuation = this.workContinuation;
            if (cancellableContinuation != null) {
                CancellableContinuation.DefaultImpls.cancel$default(cancellableContinuation, null, 1, null);
            }
            this.workContinuation = null;
            return null;
        }
        if (this.runnerJob == null) {
            this.snapshotInvalidations.clear();
            this.compositionInvalidations.clear();
            if (this.broadcastFrameClock.getHasAwaiters()) {
                state = State.InactivePendingWork;
            } else {
                state = State.Inactive;
            }
        } else if (!(!this.compositionInvalidations.isEmpty()) && !(!this.snapshotInvalidations.isEmpty()) && !(!this.compositionsAwaitingApply.isEmpty()) && !(!this.compositionValuesAwaitingInsert.isEmpty()) && this.concurrentCompositionsOutstanding <= 0 && !this.broadcastFrameClock.getHasAwaiters()) {
            state = State.Idle;
        } else {
            state = State.PendingWork;
        }
        this._state.setValue(state);
        if (state != State.PendingWork) {
            return null;
        }
        CancellableContinuation cancellableContinuation2 = this.workContinuation;
        this.workContinuation = null;
        return cancellableContinuation2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void discardUnusedValues() {
        int i3;
        List emptyList;
        List flatten;
        synchronized (this.stateLock) {
            if (!this.compositionValuesRemoved.isEmpty()) {
                flatten = CollectionsKt__IterablesKt.flatten(this.compositionValuesRemoved.values());
                this.compositionValuesRemoved.clear();
                emptyList = new ArrayList(flatten.size());
                int size = flatten.size();
                for (int i16 = 0; i16 < size; i16++) {
                    MovableContentStateReference movableContentStateReference = (MovableContentStateReference) flatten.get(i16);
                    emptyList.add(TuplesKt.to(movableContentStateReference, this.compositionValueStatesAvailable.get(movableContentStateReference)));
                }
                this.compositionValueStatesAvailable.clear();
            } else {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
            }
        }
        int size2 = emptyList.size();
        for (i3 = 0; i3 < size2; i3++) {
            Pair pair = (Pair) emptyList.get(i3);
            MovableContentStateReference movableContentStateReference2 = (MovableContentStateReference) pair.component1();
            MovableContentState movableContentState = (MovableContentState) pair.component2();
            if (movableContentState != null) {
                movableContentStateReference2.getComposition().disposeUnusedMovableContent(movableContentState);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getHasConcurrentFrameWorkLocked() {
        return (this.compositionsAwaitingApply.isEmpty() ^ true) || this.broadcastFrameClock.getHasAwaiters();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getHasFrameWorkLocked() {
        return (this.compositionInvalidations.isEmpty() ^ true) || this.broadcastFrameClock.getHasAwaiters();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getHasSchedulingWork() {
        boolean z16;
        synchronized (this.stateLock) {
            z16 = true;
            if (!(!this.snapshotInvalidations.isEmpty()) && !(!this.compositionInvalidations.isEmpty())) {
                if (!this.broadcastFrameClock.getHasAwaiters()) {
                    z16 = false;
                }
            }
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getShouldKeepRecomposing() {
        boolean z16;
        boolean z17;
        synchronized (this.stateLock) {
            z16 = !this.isClosed;
        }
        if (z16) {
            return true;
        }
        Iterator<Job> it = this.effectJob.getChildren().iterator();
        while (true) {
            if (!it.hasNext()) {
                z17 = false;
                break;
            }
            if (it.next().isActive()) {
                z17 = true;
                break;
            }
        }
        return z17;
    }

    private final void performInitialMovableContentInserts(ControlledComposition composition) {
        synchronized (this.stateLock) {
            List<MovableContentStateReference> list = this.compositionValuesAwaitingInsert;
            int size = list.size();
            boolean z16 = false;
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    break;
                }
                if (Intrinsics.areEqual(list.get(i3).getComposition(), composition)) {
                    z16 = true;
                    break;
                }
                i3++;
            }
            if (z16) {
                Unit unit = Unit.INSTANCE;
                ArrayList arrayList = new ArrayList();
                performInitialMovableContentInserts$fillToInsert(arrayList, this, composition);
                while (!arrayList.isEmpty()) {
                    performInsertValues(arrayList, null);
                    performInitialMovableContentInserts$fillToInsert(arrayList, this, composition);
                }
            }
        }
    }

    private static final void performInitialMovableContentInserts$fillToInsert(List<MovableContentStateReference> list, Recomposer recomposer, ControlledComposition controlledComposition) {
        list.clear();
        synchronized (recomposer.stateLock) {
            Iterator<MovableContentStateReference> it = recomposer.compositionValuesAwaitingInsert.iterator();
            while (it.hasNext()) {
                MovableContentStateReference next = it.next();
                if (Intrinsics.areEqual(next.getComposition(), controlledComposition)) {
                    list.add(next);
                    it.remove();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<ControlledComposition> performInsertValues(List<MovableContentStateReference> references, IdentityArraySet<Object> modifiedValues) {
        List<ControlledComposition> list;
        ArrayList arrayList;
        HashMap hashMap = new HashMap(references.size());
        int size = references.size();
        for (int i3 = 0; i3 < size; i3++) {
            MovableContentStateReference movableContentStateReference = references.get(i3);
            ControlledComposition composition = movableContentStateReference.getComposition();
            Object obj = hashMap.get(composition);
            if (obj == null) {
                obj = new ArrayList();
                hashMap.put(composition, obj);
            }
            ((ArrayList) obj).add(movableContentStateReference);
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            ControlledComposition controlledComposition = (ControlledComposition) entry.getKey();
            List list2 = (List) entry.getValue();
            ComposerKt.runtimeCheck(!controlledComposition.isComposing());
            MutableSnapshot takeMutableSnapshot = Snapshot.INSTANCE.takeMutableSnapshot(readObserverOf(controlledComposition), writeObserverOf(controlledComposition, modifiedValues));
            try {
                Snapshot makeCurrent = takeMutableSnapshot.makeCurrent();
                try {
                    synchronized (this.stateLock) {
                        arrayList = new ArrayList(list2.size());
                        int size2 = list2.size();
                        for (int i16 = 0; i16 < size2; i16++) {
                            MovableContentStateReference movableContentStateReference2 = (MovableContentStateReference) list2.get(i16);
                            arrayList.add(TuplesKt.to(movableContentStateReference2, RecomposerKt.removeLastMultiValue(this.compositionValuesRemoved, movableContentStateReference2.getContent$runtime_release())));
                        }
                    }
                    controlledComposition.insertMovableContent(arrayList);
                    Unit unit = Unit.INSTANCE;
                } finally {
                }
            } finally {
                applyAndCheck(takeMutableSnapshot);
            }
        }
        list = CollectionsKt___CollectionsKt.toList(hashMap.keySet());
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ControlledComposition performRecompose(final ControlledComposition composition, final IdentityArraySet<Object> modifiedValues) {
        if (composition.isComposing() || composition.getDisposed()) {
            return null;
        }
        MutableSnapshot takeMutableSnapshot = Snapshot.INSTANCE.takeMutableSnapshot(readObserverOf(composition), writeObserverOf(composition, modifiedValues));
        try {
            Snapshot makeCurrent = takeMutableSnapshot.makeCurrent();
            boolean z16 = false;
            if (modifiedValues != null) {
                try {
                    if (modifiedValues.isNotEmpty()) {
                        z16 = true;
                    }
                } catch (Throwable th5) {
                    takeMutableSnapshot.restoreCurrent(makeCurrent);
                    throw th5;
                }
            }
            if (z16) {
                composition.prepareCompose(new Function0<Unit>() { // from class: androidx.compose.runtime.Recomposer$performRecompose$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        IdentityArraySet<Object> identityArraySet = modifiedValues;
                        ControlledComposition controlledComposition = composition;
                        Iterator<Object> it = identityArraySet.iterator();
                        while (it.hasNext()) {
                            controlledComposition.recordWriteOf(it.next());
                        }
                    }
                });
            }
            boolean recompose = composition.recompose();
            takeMutableSnapshot.restoreCurrent(makeCurrent);
            if (recompose) {
                return composition;
            }
            return null;
        } finally {
            applyAndCheck(takeMutableSnapshot);
        }
    }

    private final Function1<Object, Unit> readObserverOf(final ControlledComposition composition) {
        return new Function1<Object, Unit>() { // from class: androidx.compose.runtime.Recomposer$readObserverOf$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object value) {
                Intrinsics.checkNotNullParameter(value, "value");
                ControlledComposition.this.recordReadOf(value);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object recompositionRunner(Function3<? super CoroutineScope, ? super MonotonicFrameClock, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object withContext = BuildersKt.withContext(this.broadcastFrameClock, new Recomposer$recompositionRunner$2(this, function3, MonotonicFrameClockKt.getMonotonicFrameClock(continuation.getContext()), null), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return withContext == coroutine_suspended ? withContext : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void recordComposerModificationsLocked() {
        if (!this.snapshotInvalidations.isEmpty()) {
            List<Set<Object>> list = this.snapshotInvalidations;
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                Set<? extends Object> set = list.get(i3);
                List<ControlledComposition> list2 = this.knownCompositions;
                int size2 = list2.size();
                for (int i16 = 0; i16 < size2; i16++) {
                    list2.get(i16).recordModificationsOf(set);
                }
            }
            this.snapshotInvalidations.clear();
            if (deriveStateLocked() != null) {
                throw new IllegalStateException("called outside of runRecomposeAndApplyChanges".toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void registerRunnerJob(Job callingJob) {
        synchronized (this.stateLock) {
            Throwable th5 = this.closeCause;
            if (th5 == null) {
                if (this._state.getValue().compareTo(State.ShuttingDown) > 0) {
                    if (this.runnerJob == null) {
                        this.runnerJob = callingJob;
                        deriveStateLocked();
                    } else {
                        throw new IllegalStateException("Recomposer already running".toString());
                    }
                } else {
                    throw new IllegalStateException("Recomposer shut down".toString());
                }
            } else {
                throw th5;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0088 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Type inference failed for: r8v10, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r8v7, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v10, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v7, types: [java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x00a3 -> B:11:0x003f). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object runFrameLoop(MonotonicFrameClock monotonicFrameClock, ProduceFrameSignal produceFrameSignal, Continuation<? super Unit> continuation) {
        Recomposer$runFrameLoop$1 recomposer$runFrameLoop$1;
        Object coroutine_suspended;
        int i3;
        ArrayList arrayList;
        ArrayList arrayList2;
        Recomposer recomposer;
        final ArrayList arrayList3;
        final ArrayList arrayList4;
        final Recomposer recomposer2;
        MonotonicFrameClock monotonicFrameClock2;
        final ProduceFrameSignal produceFrameSignal2;
        Function1<Long, CancellableContinuation<? super Unit>> function1;
        SynchronizedObject synchronizedObject;
        ArrayList arrayList5;
        ArrayList arrayList6;
        if (continuation instanceof Recomposer$runFrameLoop$1) {
            recomposer$runFrameLoop$1 = (Recomposer$runFrameLoop$1) continuation;
            int i16 = recomposer$runFrameLoop$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                recomposer$runFrameLoop$1.label = i16 - Integer.MIN_VALUE;
                Object obj = recomposer$runFrameLoop$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = recomposer$runFrameLoop$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    arrayList = new ArrayList();
                    arrayList2 = new ArrayList();
                    recomposer = this;
                    synchronizedObject = recomposer.stateLock;
                    recomposer$runFrameLoop$1.L$0 = recomposer;
                    recomposer$runFrameLoop$1.L$1 = monotonicFrameClock;
                    recomposer$runFrameLoop$1.L$2 = produceFrameSignal;
                    recomposer$runFrameLoop$1.L$3 = arrayList;
                    recomposer$runFrameLoop$1.L$4 = arrayList2;
                    recomposer$runFrameLoop$1.label = 1;
                    if (produceFrameSignal.awaitFrameRequest(synchronizedObject, recomposer$runFrameLoop$1) != coroutine_suspended) {
                    }
                } else if (i3 == 1) {
                    ?? r85 = (List) recomposer$runFrameLoop$1.L$4;
                    ?? r95 = (List) recomposer$runFrameLoop$1.L$3;
                    produceFrameSignal2 = (ProduceFrameSignal) recomposer$runFrameLoop$1.L$2;
                    monotonicFrameClock2 = (MonotonicFrameClock) recomposer$runFrameLoop$1.L$1;
                    recomposer2 = (Recomposer) recomposer$runFrameLoop$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    arrayList4 = r85;
                    arrayList3 = r95;
                    function1 = new Function1<Long, CancellableContinuation<? super Unit>>() { // from class: androidx.compose.runtime.Recomposer$runFrameLoop$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ CancellableContinuation<? super Unit> invoke(Long l3) {
                            return invoke(l3.longValue());
                        }

                        public final CancellableContinuation<Unit> invoke(long j3) {
                            BroadcastFrameClock broadcastFrameClock;
                            Object beginSection;
                            List list;
                            int i17;
                            List list2;
                            CancellableContinuation<Unit> deriveStateLocked;
                            ControlledComposition performRecompose;
                            BroadcastFrameClock broadcastFrameClock2;
                            broadcastFrameClock = Recomposer.this.broadcastFrameClock;
                            if (broadcastFrameClock.getHasAwaiters()) {
                                Recomposer recomposer3 = Recomposer.this;
                                Trace trace = Trace.INSTANCE;
                                beginSection = trace.beginSection("Recomposer:animation");
                                try {
                                    broadcastFrameClock2 = recomposer3.broadcastFrameClock;
                                    broadcastFrameClock2.sendFrame(j3);
                                    Snapshot.INSTANCE.sendApplyNotifications();
                                    Unit unit = Unit.INSTANCE;
                                    trace.endSection(beginSection);
                                } finally {
                                }
                            }
                            Recomposer recomposer4 = Recomposer.this;
                            List<ControlledComposition> list3 = arrayList3;
                            List<ControlledComposition> list4 = arrayList4;
                            ProduceFrameSignal produceFrameSignal3 = produceFrameSignal2;
                            beginSection = Trace.INSTANCE.beginSection("Recomposer:recompose");
                            try {
                                synchronized (recomposer4.stateLock) {
                                    recomposer4.recordComposerModificationsLocked();
                                    list = recomposer4.compositionsAwaitingApply;
                                    int size = list.size();
                                    for (int i18 = 0; i18 < size; i18++) {
                                        list4.add((ControlledComposition) list.get(i18));
                                    }
                                    list2 = recomposer4.compositionsAwaitingApply;
                                    list2.clear();
                                    List list5 = recomposer4.compositionInvalidations;
                                    int size2 = list5.size();
                                    for (int i19 = 0; i19 < size2; i19++) {
                                        list3.add((ControlledComposition) list5.get(i19));
                                    }
                                    recomposer4.compositionInvalidations.clear();
                                    produceFrameSignal3.takeFrameRequestLocked();
                                    Unit unit2 = Unit.INSTANCE;
                                }
                                IdentityArraySet identityArraySet = new IdentityArraySet();
                                try {
                                    int size3 = list3.size();
                                    for (int i26 = 0; i26 < size3; i26++) {
                                        performRecompose = recomposer4.performRecompose(list3.get(i26), identityArraySet);
                                        if (performRecompose != null) {
                                            list4.add(performRecompose);
                                        }
                                    }
                                    list3.clear();
                                    if (!list4.isEmpty()) {
                                        recomposer4.changeCount = recomposer4.getChangeCount() + 1;
                                    }
                                    try {
                                        int size4 = list4.size();
                                        for (i17 = 0; i17 < size4; i17++) {
                                            list4.get(i17).applyChanges();
                                        }
                                        list4.clear();
                                        synchronized (recomposer4.stateLock) {
                                            deriveStateLocked = recomposer4.deriveStateLocked();
                                        }
                                        return deriveStateLocked;
                                    } catch (Throwable th5) {
                                        list4.clear();
                                        throw th5;
                                    }
                                } catch (Throwable th6) {
                                    list3.clear();
                                    throw th6;
                                }
                            } finally {
                            }
                        }
                    };
                    recomposer$runFrameLoop$1.L$0 = recomposer2;
                    recomposer$runFrameLoop$1.L$1 = monotonicFrameClock2;
                    recomposer$runFrameLoop$1.L$2 = produceFrameSignal2;
                    recomposer$runFrameLoop$1.L$3 = arrayList3;
                    recomposer$runFrameLoop$1.L$4 = arrayList4;
                    recomposer$runFrameLoop$1.label = 2;
                    arrayList6 = arrayList4;
                    arrayList5 = arrayList3;
                    if (monotonicFrameClock2.withFrameNanos(function1, recomposer$runFrameLoop$1) == coroutine_suspended) {
                    }
                    arrayList = arrayList5;
                    produceFrameSignal = produceFrameSignal2;
                    arrayList2 = arrayList6;
                    monotonicFrameClock = monotonicFrameClock2;
                    recomposer = recomposer2;
                    synchronizedObject = recomposer.stateLock;
                    recomposer$runFrameLoop$1.L$0 = recomposer;
                    recomposer$runFrameLoop$1.L$1 = monotonicFrameClock;
                    recomposer$runFrameLoop$1.L$2 = produceFrameSignal;
                    recomposer$runFrameLoop$1.L$3 = arrayList;
                    recomposer$runFrameLoop$1.L$4 = arrayList2;
                    recomposer$runFrameLoop$1.label = 1;
                    if (produceFrameSignal.awaitFrameRequest(synchronizedObject, recomposer$runFrameLoop$1) != coroutine_suspended) {
                    }
                } else if (i3 == 2) {
                    ?? r86 = (List) recomposer$runFrameLoop$1.L$4;
                    ?? r96 = (List) recomposer$runFrameLoop$1.L$3;
                    produceFrameSignal2 = (ProduceFrameSignal) recomposer$runFrameLoop$1.L$2;
                    monotonicFrameClock2 = (MonotonicFrameClock) recomposer$runFrameLoop$1.L$1;
                    recomposer2 = (Recomposer) recomposer$runFrameLoop$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    arrayList6 = r86;
                    arrayList5 = r96;
                    arrayList = arrayList5;
                    produceFrameSignal = produceFrameSignal2;
                    arrayList2 = arrayList6;
                    monotonicFrameClock = monotonicFrameClock2;
                    recomposer = recomposer2;
                    synchronizedObject = recomposer.stateLock;
                    recomposer$runFrameLoop$1.L$0 = recomposer;
                    recomposer$runFrameLoop$1.L$1 = monotonicFrameClock;
                    recomposer$runFrameLoop$1.L$2 = produceFrameSignal;
                    recomposer$runFrameLoop$1.L$3 = arrayList;
                    recomposer$runFrameLoop$1.L$4 = arrayList2;
                    recomposer$runFrameLoop$1.label = 1;
                    if (produceFrameSignal.awaitFrameRequest(synchronizedObject, recomposer$runFrameLoop$1) != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    recomposer2 = recomposer;
                    monotonicFrameClock2 = monotonicFrameClock;
                    arrayList4 = arrayList2;
                    produceFrameSignal2 = produceFrameSignal;
                    arrayList3 = arrayList;
                    function1 = new Function1<Long, CancellableContinuation<? super Unit>>() { // from class: androidx.compose.runtime.Recomposer$runFrameLoop$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ CancellableContinuation<? super Unit> invoke(Long l3) {
                            return invoke(l3.longValue());
                        }

                        public final CancellableContinuation<Unit> invoke(long j3) {
                            BroadcastFrameClock broadcastFrameClock;
                            Object beginSection;
                            List list;
                            int i17;
                            List list2;
                            CancellableContinuation<Unit> deriveStateLocked;
                            ControlledComposition performRecompose;
                            BroadcastFrameClock broadcastFrameClock2;
                            broadcastFrameClock = Recomposer.this.broadcastFrameClock;
                            if (broadcastFrameClock.getHasAwaiters()) {
                                Recomposer recomposer3 = Recomposer.this;
                                Trace trace = Trace.INSTANCE;
                                beginSection = trace.beginSection("Recomposer:animation");
                                try {
                                    broadcastFrameClock2 = recomposer3.broadcastFrameClock;
                                    broadcastFrameClock2.sendFrame(j3);
                                    Snapshot.INSTANCE.sendApplyNotifications();
                                    Unit unit = Unit.INSTANCE;
                                    trace.endSection(beginSection);
                                } finally {
                                }
                            }
                            Recomposer recomposer4 = Recomposer.this;
                            List<ControlledComposition> list3 = arrayList3;
                            List<ControlledComposition> list4 = arrayList4;
                            ProduceFrameSignal produceFrameSignal3 = produceFrameSignal2;
                            beginSection = Trace.INSTANCE.beginSection("Recomposer:recompose");
                            try {
                                synchronized (recomposer4.stateLock) {
                                    recomposer4.recordComposerModificationsLocked();
                                    list = recomposer4.compositionsAwaitingApply;
                                    int size = list.size();
                                    for (int i18 = 0; i18 < size; i18++) {
                                        list4.add((ControlledComposition) list.get(i18));
                                    }
                                    list2 = recomposer4.compositionsAwaitingApply;
                                    list2.clear();
                                    List list5 = recomposer4.compositionInvalidations;
                                    int size2 = list5.size();
                                    for (int i19 = 0; i19 < size2; i19++) {
                                        list3.add((ControlledComposition) list5.get(i19));
                                    }
                                    recomposer4.compositionInvalidations.clear();
                                    produceFrameSignal3.takeFrameRequestLocked();
                                    Unit unit2 = Unit.INSTANCE;
                                }
                                IdentityArraySet identityArraySet = new IdentityArraySet();
                                try {
                                    int size3 = list3.size();
                                    for (int i26 = 0; i26 < size3; i26++) {
                                        performRecompose = recomposer4.performRecompose(list3.get(i26), identityArraySet);
                                        if (performRecompose != null) {
                                            list4.add(performRecompose);
                                        }
                                    }
                                    list3.clear();
                                    if (!list4.isEmpty()) {
                                        recomposer4.changeCount = recomposer4.getChangeCount() + 1;
                                    }
                                    try {
                                        int size4 = list4.size();
                                        for (i17 = 0; i17 < size4; i17++) {
                                            list4.get(i17).applyChanges();
                                        }
                                        list4.clear();
                                        synchronized (recomposer4.stateLock) {
                                            deriveStateLocked = recomposer4.deriveStateLocked();
                                        }
                                        return deriveStateLocked;
                                    } catch (Throwable th5) {
                                        list4.clear();
                                        throw th5;
                                    }
                                } catch (Throwable th6) {
                                    list3.clear();
                                    throw th6;
                                }
                            } finally {
                            }
                        }
                    };
                    recomposer$runFrameLoop$1.L$0 = recomposer2;
                    recomposer$runFrameLoop$1.L$1 = monotonicFrameClock2;
                    recomposer$runFrameLoop$1.L$2 = produceFrameSignal2;
                    recomposer$runFrameLoop$1.L$3 = arrayList3;
                    recomposer$runFrameLoop$1.L$4 = arrayList4;
                    recomposer$runFrameLoop$1.label = 2;
                    arrayList6 = arrayList4;
                    arrayList5 = arrayList3;
                    if (monotonicFrameClock2.withFrameNanos(function1, recomposer$runFrameLoop$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    arrayList = arrayList5;
                    produceFrameSignal = produceFrameSignal2;
                    arrayList2 = arrayList6;
                    monotonicFrameClock = monotonicFrameClock2;
                    recomposer = recomposer2;
                    synchronizedObject = recomposer.stateLock;
                    recomposer$runFrameLoop$1.L$0 = recomposer;
                    recomposer$runFrameLoop$1.L$1 = monotonicFrameClock;
                    recomposer$runFrameLoop$1.L$2 = produceFrameSignal;
                    recomposer$runFrameLoop$1.L$3 = arrayList;
                    recomposer$runFrameLoop$1.L$4 = arrayList2;
                    recomposer$runFrameLoop$1.label = 1;
                    if (produceFrameSignal.awaitFrameRequest(synchronizedObject, recomposer$runFrameLoop$1) != coroutine_suspended) {
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        recomposer$runFrameLoop$1 = new Recomposer$runFrameLoop$1(this, continuation);
        Object obj2 = recomposer$runFrameLoop$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = recomposer$runFrameLoop$1.label;
        if (i3 != 0) {
        }
    }

    private final Function1<Object, Unit> writeObserverOf(final ControlledComposition composition, final IdentityArraySet<Object> modifiedValues) {
        return new Function1<Object, Unit>() { // from class: androidx.compose.runtime.Recomposer$writeObserverOf$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object value) {
                Intrinsics.checkNotNullParameter(value, "value");
                ControlledComposition.this.recordWriteOf(value);
                IdentityArraySet<Object> identityArraySet = modifiedValues;
                if (identityArraySet != null) {
                    identityArraySet.add(value);
                }
            }
        };
    }

    public final RecomposerInfo asRecomposerInfo() {
        return this.recomposerInfo;
    }

    public final Object awaitIdle(Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object collect = FlowKt.collect(FlowKt.takeWhile(getCurrentState(), new Recomposer$awaitIdle$2(null)), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return collect == coroutine_suspended ? collect : Unit.INSTANCE;
    }

    public final void cancel() {
        synchronized (this.stateLock) {
            if (this._state.getValue().compareTo(State.Idle) >= 0) {
                this._state.setValue(State.ShuttingDown);
            }
            Unit unit = Unit.INSTANCE;
        }
        Job.DefaultImpls.cancel$default((Job) this.effectJob, (CancellationException) null, 1, (Object) null);
    }

    public final void close() {
        if (this.effectJob.complete()) {
            synchronized (this.stateLock) {
                this.isClosed = true;
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void composeInitial$runtime_release(ControlledComposition composition, Function2<? super Composer, ? super Integer, Unit> content) {
        Intrinsics.checkNotNullParameter(composition, "composition");
        Intrinsics.checkNotNullParameter(content, "content");
        boolean isComposing = composition.isComposing();
        Snapshot.Companion companion = Snapshot.INSTANCE;
        MutableSnapshot takeMutableSnapshot = companion.takeMutableSnapshot(readObserverOf(composition), writeObserverOf(composition, null));
        try {
            Snapshot makeCurrent = takeMutableSnapshot.makeCurrent();
            try {
                composition.composeContent(content);
                Unit unit = Unit.INSTANCE;
                if (!isComposing) {
                    companion.notifyObjectsInitialized();
                }
                synchronized (this.stateLock) {
                    if (this._state.getValue().compareTo(State.ShuttingDown) > 0 && !this.knownCompositions.contains(composition)) {
                        this.knownCompositions.add(composition);
                    }
                }
                performInitialMovableContentInserts(composition);
                composition.applyChanges();
                composition.applyLateChanges();
                if (isComposing) {
                    return;
                }
                companion.notifyObjectsInitialized();
            } finally {
                takeMutableSnapshot.restoreCurrent(makeCurrent);
            }
        } finally {
            applyAndCheck(takeMutableSnapshot);
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void deletedMovableContent$runtime_release(MovableContentStateReference reference) {
        Intrinsics.checkNotNullParameter(reference, "reference");
        synchronized (this.stateLock) {
            RecomposerKt.addMultiValue(this.compositionValuesRemoved, reference.getContent$runtime_release(), reference);
        }
    }

    public final long getChangeCount() {
        return this.changeCount;
    }

    @Override // androidx.compose.runtime.CompositionContext
    /* renamed from: getCollectingParameterInformation$runtime_release */
    public boolean getCollectingParameterInformation() {
        return false;
    }

    @Override // androidx.compose.runtime.CompositionContext
    /* renamed from: getCompoundHashKey$runtime_release */
    public int getCompoundHashKey() {
        return 1000;
    }

    public final StateFlow<State> getCurrentState() {
        return this._state;
    }

    @Override // androidx.compose.runtime.CompositionContext
    /* renamed from: getEffectCoroutineContext$runtime_release, reason: from getter */
    public CoroutineContext getEffectCoroutineContext() {
        return this.effectCoroutineContext;
    }

    public final boolean getHasPendingWork() {
        boolean z16;
        synchronized (this.stateLock) {
            z16 = true;
            if (!(!this.snapshotInvalidations.isEmpty()) && !(!this.compositionInvalidations.isEmpty()) && this.concurrentCompositionsOutstanding <= 0 && !(!this.compositionsAwaitingApply.isEmpty())) {
                if (!this.broadcastFrameClock.getHasAwaiters()) {
                    z16 = false;
                }
            }
        }
        return z16;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public CoroutineContext getRecomposeCoroutineContext$runtime_release() {
        return EmptyCoroutineContext.INSTANCE;
    }

    public final Flow<State> getState() {
        return getCurrentState();
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void insertMovableContent$runtime_release(MovableContentStateReference reference) {
        CancellableContinuation<Unit> deriveStateLocked;
        Intrinsics.checkNotNullParameter(reference, "reference");
        synchronized (this.stateLock) {
            this.compositionValuesAwaitingInsert.add(reference);
            deriveStateLocked = deriveStateLocked();
        }
        if (deriveStateLocked != null) {
            Result.Companion companion = Result.INSTANCE;
            deriveStateLocked.resumeWith(Result.m476constructorimpl(Unit.INSTANCE));
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void invalidate$runtime_release(ControlledComposition composition) {
        CancellableContinuation<Unit> cancellableContinuation;
        Intrinsics.checkNotNullParameter(composition, "composition");
        synchronized (this.stateLock) {
            if (this.compositionInvalidations.contains(composition)) {
                cancellableContinuation = null;
            } else {
                this.compositionInvalidations.add(composition);
                cancellableContinuation = deriveStateLocked();
            }
        }
        if (cancellableContinuation != null) {
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m476constructorimpl(Unit.INSTANCE));
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void invalidateScope$runtime_release(RecomposeScopeImpl scope) {
        Set<Object> of5;
        CancellableContinuation<Unit> deriveStateLocked;
        Intrinsics.checkNotNullParameter(scope, "scope");
        synchronized (this.stateLock) {
            List<Set<Object>> list = this.snapshotInvalidations;
            of5 = SetsKt__SetsJVMKt.setOf(scope);
            list.add(of5);
            deriveStateLocked = deriveStateLocked();
        }
        if (deriveStateLocked != null) {
            Result.Companion companion = Result.INSTANCE;
            deriveStateLocked.resumeWith(Result.m476constructorimpl(Unit.INSTANCE));
        }
    }

    public final Object join(Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object first = FlowKt.first(getCurrentState(), new Recomposer$join$2(null), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return first == coroutine_suspended ? first : Unit.INSTANCE;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void movableContentStateReleased$runtime_release(MovableContentStateReference reference, MovableContentState data) {
        Intrinsics.checkNotNullParameter(reference, "reference");
        Intrinsics.checkNotNullParameter(data, "data");
        synchronized (this.stateLock) {
            this.compositionValueStatesAvailable.put(reference, data);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public MovableContentState movableContentStateResolve$runtime_release(MovableContentStateReference reference) {
        MovableContentState remove;
        Intrinsics.checkNotNullParameter(reference, "reference");
        synchronized (this.stateLock) {
            remove = this.compositionValueStatesAvailable.remove(reference);
        }
        return remove;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void recordInspectionTable$runtime_release(Set<CompositionData> table) {
        Intrinsics.checkNotNullParameter(table, "table");
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void registerComposition$runtime_release(ControlledComposition composition) {
        Intrinsics.checkNotNullParameter(composition, "composition");
    }

    public final Object runRecomposeAndApplyChanges(Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object recompositionRunner = recompositionRunner(new Recomposer$runRecomposeAndApplyChanges$2(this, null), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return recompositionRunner == coroutine_suspended ? recompositionRunner : Unit.INSTANCE;
    }

    @ExperimentalComposeApi
    public final Object runRecomposeConcurrentlyAndApplyChanges(CoroutineContext coroutineContext, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object recompositionRunner = recompositionRunner(new Recomposer$runRecomposeConcurrentlyAndApplyChanges$2(coroutineContext, this, null), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return recompositionRunner == coroutine_suspended ? recompositionRunner : Unit.INSTANCE;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void unregisterComposition$runtime_release(ControlledComposition composition) {
        Intrinsics.checkNotNullParameter(composition, "composition");
        synchronized (this.stateLock) {
            this.knownCompositions.remove(composition);
            this.compositionInvalidations.remove(composition);
            this.compositionsAwaitingApply.remove(composition);
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void recordComposerModificationsLocked(Function1<? super ControlledComposition, Unit> onEachInvalidComposition) {
        if (!this.snapshotInvalidations.isEmpty()) {
            List list = this.snapshotInvalidations;
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                Set<? extends Object> set = (Set) list.get(i3);
                List list2 = this.knownCompositions;
                int size2 = list2.size();
                for (int i16 = 0; i16 < size2; i16++) {
                    ((ControlledComposition) list2.get(i16)).recordModificationsOf(set);
                }
            }
            this.snapshotInvalidations.clear();
        }
        List list3 = this.compositionInvalidations;
        int size3 = list3.size();
        for (int i17 = 0; i17 < size3; i17++) {
            onEachInvalidComposition.invoke(list3.get(i17));
        }
        this.compositionInvalidations.clear();
        if (deriveStateLocked() != null) {
            throw new IllegalStateException("called outside of runRecomposeAndApplyChanges".toString());
        }
    }

    @Deprecated(message = "Replaced by currentState as a StateFlow", replaceWith = @ReplaceWith(expression = "currentState", imports = {}))
    public static /* synthetic */ void getState$annotations() {
    }
}
