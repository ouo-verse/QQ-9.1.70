package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArrayMap;
import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.collection.IdentityScopeMap;
import androidx.compose.runtime.snapshots.StateObject;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.aspectj.lang.JoinPoint;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00e2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0000\u0018\u00002\u00020\u0001:\u0002\u008d\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bJ\u001e\u0010U\u001a\u00020\u001b2\f\u0010V\u001a\b\u0012\u0004\u0012\u00020.0W2\u0006\u0010X\u001a\u00020\u000fH\u0002J\b\u0010Y\u001a\u00020\u001bH\u0016Jc\u0010Z\u001a\u00020\u001b2Y\u0010\u0012\u001aU\u0012Q\u0012O\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0005\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0017\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0019\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b0\u0014j\u0002`\u001c0\u0013H\u0002J\b\u0010[\u001a\u00020\u001bH\u0016J\b\u0010\\\u001a\u00020\u001bH\u0016J\b\u0010]\u001a\u00020\u001bH\u0002J \u0010^\u001a\u00020\u001b2\u0011\u0010_\u001a\r\u0012\u0004\u0012\u00020\u001b0\u001e\u00a2\u0006\u0002\b\u001fH\u0016\u00a2\u0006\u0002\u0010#J3\u0010`\u001a\u0002Ha\"\u0004\b\u0000\u0010a2\b\u0010b\u001a\u0004\u0018\u00010\u00012\u0006\u0010c\u001a\u00020:2\f\u0010d\u001a\b\u0012\u0004\u0012\u0002Ha0\u001eH\u0016\u00a2\u0006\u0002\u0010eJ\b\u0010f\u001a\u00020\u001bH\u0016J\u0010\u0010g\u001a\u00020\u001b2\u0006\u0010h\u001a\u00020iH\u0016J\b\u0010j\u001a\u00020\u001bH\u0002J\b\u0010k\u001a\u00020\u001bH\u0002J$\u0010l\u001a\u00020\u001b2\u001a\u0010m\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020o\u0012\u0006\u0012\u0004\u0018\u00010o0n0(H\u0016J\u0018\u0010p\u001a\u00020q2\u0006\u0010r\u001a\u00020)2\b\u0010s\u001a\u0004\u0018\u00010.J\b\u0010t\u001a\u00020\u001bH\u0016J\"\u0010u\u001a\u00020q2\u0006\u0010r\u001a\u00020)2\u0006\u0010v\u001a\u00020w2\b\u0010s\u001a\u0004\u0018\u00010.H\u0002J\u000e\u0010x\u001a\u00020\u001b2\u0006\u0010y\u001a\u00020:J\u0010\u0010z\u001a\u00020\u001b2\u0006\u0010{\u001a\u00020.H\u0002J\u0016\u0010|\u001a\u00020\u000f2\f\u0010V\u001a\b\u0012\u0004\u0012\u00020.0WH\u0016J\u0016\u0010}\u001a\u00020\u001b2\f\u0010d\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001eH\u0016J\b\u0010~\u001a\u00020\u000fH\u0016J\u0016\u0010\u007f\u001a\u00020\u001b2\f\u0010V\u001a\b\u0012\u0004\u0012\u00020.0WH\u0016J\u0011\u0010\u0080\u0001\u001a\u00020\u001b2\u0006\u0010{\u001a\u00020.H\u0016J\u0011\u0010\u0081\u0001\u001a\u00020\u001b2\u0006\u0010{\u001a\u00020.H\u0016J\u001b\u0010\u0082\u0001\u001a\u00020\u001b2\n\u0010h\u001a\u0006\u0012\u0002\b\u000302H\u0000\u00a2\u0006\u0003\b\u0083\u0001J\u001f\u0010\u0084\u0001\u001a\u00020\u001b2\u0006\u0010s\u001a\u00020.2\u0006\u0010r\u001a\u00020)H\u0000\u00a2\u0006\u0003\b\u0085\u0001J!\u0010\u0086\u0001\u001a\u00020\u001b2\u0011\u0010_\u001a\r\u0012\u0004\u0012\u00020\u001b0\u001e\u00a2\u0006\u0002\b\u001fH\u0016\u00a2\u0006\u0002\u0010#J\u001d\u0010\u0087\u0001\u001a\u0016\u0012\u0004\u0012\u00020)\u0012\f\u0012\n\u0012\u0004\u0012\u00020.\u0018\u00010=0<H\u0002J'\u0010\u0088\u0001\u001a\u0003H\u0089\u0001\"\u0005\b\u0000\u0010\u0089\u00012\r\u0010d\u001a\t\u0012\u0005\u0012\u0003H\u0089\u00010\u001eH\u0082\b\u00a2\u0006\u0003\u0010\u008a\u0001J\u0011\u0010\u008b\u0001\u001a\u00020\u001b2\u0006\u0010Q\u001a\u00020RH\u0002J\t\u0010\u008c\u0001\u001a\u00020\u001bH\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011Ra\u0010\u0012\u001aU\u0012Q\u0012O\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0005\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0017\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0019\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b0\u0014j\u0002`\u001c0\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R'\u0010\u001d\u001a\r\u0012\u0004\u0012\u00020\u001b0\u001e\u00a2\u0006\u0002\b\u001fX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010$\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010%\u001a\u00020&X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(8@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b*\u0010+R\u001e\u0010,\u001a\u0012\u0012\u0004\u0012\u00020)0\u000bj\b\u0012\u0004\u0012\u00020)`\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020.0(8@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b/\u0010+R\u0018\u00100\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030201X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u00104\u001a\u00020\u000f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b5\u0010\u0011R\u0014\u00106\u001a\u00020\u000f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b7\u0010\u0011R\u0010\u00108\u001a\u0004\u0018\u00010\u0000X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\"\u0010;\u001a\u0016\u0012\u0004\u0012\u00020)\u0012\f\u0012\n\u0012\u0004\u0012\u00020.\u0018\u00010=0<X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010>\u001a\u00020\u000f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b>\u0010\u0011R\u0014\u0010?\u001a\u00020\u000f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b?\u0010\u0011R\u0011\u0010@\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b@\u0010\u0011Ra\u0010A\u001aU\u0012Q\u0012O\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0005\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0017\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0019\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b0\u0014j\u0002`\u001c0\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020CX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010D\u001a\b\u0012\u0004\u0012\u00020)01X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010E\u001a\b\u0012\u0004\u0012\u00020)01X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010F\u001a\b\u0012\u0004\u0012\u00020.0(8@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\bG\u0010+R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010H\u001a\u00020\u000fX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0011\"\u0004\bJ\u0010KR\"\u0010L\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010.0Mj\n\u0012\u0006\u0012\u0004\u0018\u00010.`NX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F\u00a2\u0006\u0006\u001a\u0004\bO\u0010PR\u0014\u0010Q\u001a\u00020RX\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bS\u0010T\u00a8\u0006\u008e\u0001"}, d2 = {"Landroidx/compose/runtime/CompositionImpl;", "Landroidx/compose/runtime/ControlledComposition;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/compose/runtime/CompositionContext;", "applier", "Landroidx/compose/runtime/Applier;", "recomposeContext", "Lkotlin/coroutines/CoroutineContext;", "(Landroidx/compose/runtime/CompositionContext;Landroidx/compose/runtime/Applier;Lkotlin/coroutines/CoroutineContext;)V", "_recomposeContext", "abandonSet", "Ljava/util/HashSet;", "Landroidx/compose/runtime/RememberObserver;", "Lkotlin/collections/HashSet;", "areChildrenComposing", "", "getAreChildrenComposing", "()Z", "changes", "", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", "", "Landroidx/compose/runtime/Change;", "composable", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "getComposable", "()Lkotlin/jvm/functions/Function2;", "setComposable", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "composer", "Landroidx/compose/runtime/ComposerImpl;", "conditionalScopes", "", "Landroidx/compose/runtime/RecomposeScopeImpl;", "getConditionalScopes$runtime_release", "()Ljava/util/List;", "conditionallyInvalidatedScopes", "derivedStateDependencies", "", "getDerivedStateDependencies$runtime_release", "derivedStates", "Landroidx/compose/runtime/collection/IdentityScopeMap;", "Landroidx/compose/runtime/DerivedState;", "disposed", "hasInvalidations", "getHasInvalidations", "hasPendingChanges", "getHasPendingChanges", "invalidationDelegate", "invalidationDelegateGroup", "", "invalidations", "Landroidx/compose/runtime/collection/IdentityArrayMap;", "Landroidx/compose/runtime/collection/IdentityArraySet;", "isComposing", "isDisposed", "isRoot", "lateChanges", JoinPoint.SYNCHRONIZATION_LOCK, "Landroidx/compose/runtime/SynchronizedObject;", "observations", "observationsProcessed", "observedObjects", "getObservedObjects$runtime_release", "pendingInvalidScopes", "getPendingInvalidScopes$runtime_release", "setPendingInvalidScopes$runtime_release", "(Z)V", "pendingModifications", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/runtime/AtomicReference;", "getRecomposeContext", "()Lkotlin/coroutines/CoroutineContext;", "slotTable", "Landroidx/compose/runtime/SlotTable;", "getSlotTable$runtime_release", "()Landroidx/compose/runtime/SlotTable;", "addPendingInvalidationsLocked", "values", "", "forgetConditionalScopes", "applyChanges", "applyChangesInLocked", "applyLateChanges", "changesApplied", "cleanUpDerivedStateObservations", "composeContent", "content", "delegateInvalidations", BdhLogUtil.LogTag.Tag_Req, "to", "groupIndex", "block", "(Landroidx/compose/runtime/ControlledComposition;ILkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "dispose", "disposeUnusedMovableContent", "state", "Landroidx/compose/runtime/MovableContentState;", "drainPendingModificationsForCompositionLocked", "drainPendingModificationsLocked", "insertMovableContent", "references", "Lkotlin/Pair;", "Landroidx/compose/runtime/MovableContentStateReference;", "invalidate", "Landroidx/compose/runtime/InvalidationResult;", "scope", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "invalidateAll", "invalidateChecked", "anchor", "Landroidx/compose/runtime/Anchor;", "invalidateGroupsWithKey", "key", "invalidateScopeOfLocked", "value", "observesAnyOf", "prepareCompose", "recompose", "recordModificationsOf", "recordReadOf", "recordWriteOf", "removeDerivedStateObservation", "removeDerivedStateObservation$runtime_release", "removeObservation", "removeObservation$runtime_release", "setContent", "takeInvalidations", "trackAbandonedValues", "T", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "validateRecomposeScopeAnchors", "verifyConsistent", "RememberEventDispatcher", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes39.dex */
public final class CompositionImpl implements ControlledComposition {
    private final CoroutineContext _recomposeContext;
    private final HashSet<RememberObserver> abandonSet;
    private final Applier<?> applier;
    private final List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> changes;
    private Function2<? super Composer, ? super Integer, Unit> composable;
    private final ComposerImpl composer;
    private final HashSet<RecomposeScopeImpl> conditionallyInvalidatedScopes;
    private final IdentityScopeMap<DerivedState<?>> derivedStates;
    private boolean disposed;
    private CompositionImpl invalidationDelegate;
    private int invalidationDelegateGroup;
    private IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> invalidations;
    private final boolean isRoot;
    private final List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> lateChanges;
    private final SynchronizedObject lock;
    private final IdentityScopeMap<RecomposeScopeImpl> observations;
    private final IdentityScopeMap<RecomposeScopeImpl> observationsProcessed;
    private final CompositionContext parent;
    private boolean pendingInvalidScopes;
    private final AtomicReference<Object> pendingModifications;
    private final SlotTable slotTable;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005J\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\r\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\u000bJ\u0010\u0010\u0006\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J\u0016\u0010\u0010\u001a\u00020\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Landroidx/compose/runtime/CompositionImpl$RememberEventDispatcher;", "Landroidx/compose/runtime/RememberManager;", "abandoning", "", "Landroidx/compose/runtime/RememberObserver;", "(Ljava/util/Set;)V", "forgetting", "", "remembering", "sideEffects", "Lkotlin/Function0;", "", "dispatchAbandons", "dispatchRememberObservers", "dispatchSideEffects", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "sideEffect", QQWinkConstants.TAB_EFFECT, "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes39.dex */
    public static final class RememberEventDispatcher implements RememberManager {
        private final Set<RememberObserver> abandoning;
        private final List<RememberObserver> forgetting;
        private final List<RememberObserver> remembering;
        private final List<Function0<Unit>> sideEffects;

        public RememberEventDispatcher(Set<RememberObserver> abandoning) {
            Intrinsics.checkNotNullParameter(abandoning, "abandoning");
            this.abandoning = abandoning;
            this.remembering = new ArrayList();
            this.forgetting = new ArrayList();
            this.sideEffects = new ArrayList();
        }

        public final void dispatchAbandons() {
            if (!this.abandoning.isEmpty()) {
                Object beginSection = Trace.INSTANCE.beginSection("Compose:abandons");
                try {
                    Iterator<RememberObserver> it = this.abandoning.iterator();
                    while (it.hasNext()) {
                        RememberObserver next = it.next();
                        it.remove();
                        next.onAbandoned();
                    }
                    Unit unit = Unit.INSTANCE;
                } finally {
                    Trace.INSTANCE.endSection(beginSection);
                }
            }
        }

        public final void dispatchRememberObservers() {
            Object beginSection;
            if (!this.forgetting.isEmpty()) {
                beginSection = Trace.INSTANCE.beginSection("Compose:onForgotten");
                try {
                    for (int size = this.forgetting.size() - 1; -1 < size; size--) {
                        RememberObserver rememberObserver = this.forgetting.get(size);
                        if (!this.abandoning.contains(rememberObserver)) {
                            rememberObserver.onForgotten();
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                } finally {
                }
            }
            if (!this.remembering.isEmpty()) {
                beginSection = Trace.INSTANCE.beginSection("Compose:onRemembered");
                try {
                    List<RememberObserver> list = this.remembering;
                    int size2 = list.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        RememberObserver rememberObserver2 = list.get(i3);
                        this.abandoning.remove(rememberObserver2);
                        rememberObserver2.onRemembered();
                    }
                    Unit unit2 = Unit.INSTANCE;
                } finally {
                }
            }
        }

        public final void dispatchSideEffects() {
            if (!this.sideEffects.isEmpty()) {
                Object beginSection = Trace.INSTANCE.beginSection("Compose:sideeffects");
                try {
                    List<Function0<Unit>> list = this.sideEffects;
                    int size = list.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        list.get(i3).invoke();
                    }
                    this.sideEffects.clear();
                    Unit unit = Unit.INSTANCE;
                } finally {
                    Trace.INSTANCE.endSection(beginSection);
                }
            }
        }

        @Override // androidx.compose.runtime.RememberManager
        public void forgetting(RememberObserver instance) {
            Intrinsics.checkNotNullParameter(instance, "instance");
            int lastIndexOf = this.remembering.lastIndexOf(instance);
            if (lastIndexOf >= 0) {
                this.remembering.remove(lastIndexOf);
                this.abandoning.remove(instance);
            } else {
                this.forgetting.add(instance);
            }
        }

        @Override // androidx.compose.runtime.RememberManager
        public void remembering(RememberObserver instance) {
            Intrinsics.checkNotNullParameter(instance, "instance");
            int lastIndexOf = this.forgetting.lastIndexOf(instance);
            if (lastIndexOf >= 0) {
                this.forgetting.remove(lastIndexOf);
                this.abandoning.remove(instance);
            } else {
                this.remembering.add(instance);
            }
        }

        @Override // androidx.compose.runtime.RememberManager
        public void sideEffect(Function0<Unit> effect) {
            Intrinsics.checkNotNullParameter(effect, "effect");
            this.sideEffects.add(effect);
        }
    }

    public CompositionImpl(CompositionContext parent, Applier<?> applier, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(applier, "applier");
        this.parent = parent;
        this.applier = applier;
        this.pendingModifications = new AtomicReference<>(null);
        this.lock = SynchronizationKt.createSynchronizedObject();
        HashSet<RememberObserver> hashSet = new HashSet<>();
        this.abandonSet = hashSet;
        SlotTable slotTable = new SlotTable();
        this.slotTable = slotTable;
        this.observations = new IdentityScopeMap<>();
        this.conditionallyInvalidatedScopes = new HashSet<>();
        this.derivedStates = new IdentityScopeMap<>();
        ArrayList arrayList = new ArrayList();
        this.changes = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.lateChanges = arrayList2;
        this.observationsProcessed = new IdentityScopeMap<>();
        this.invalidations = new IdentityArrayMap<>(0, 1, null);
        ComposerImpl composerImpl = new ComposerImpl(applier, parent, slotTable, hashSet, arrayList, arrayList2, this);
        parent.registerComposer$runtime_release(composerImpl);
        this.composer = composerImpl;
        this._recomposeContext = coroutineContext;
        this.isRoot = parent instanceof Recomposer;
        this.composable = ComposableSingletons$CompositionKt.INSTANCE.m5getLambda1$runtime_release();
    }

    /* JADX WARN: Type inference failed for: r2v7, types: [java.util.HashSet, T] */
    private static final void addPendingInvalidationsLocked$invalidate(CompositionImpl compositionImpl, boolean z16, Ref.ObjectRef<HashSet<RecomposeScopeImpl>> objectRef, Object obj) {
        IdentityScopeMap<RecomposeScopeImpl> identityScopeMap = compositionImpl.observations;
        int find = identityScopeMap.find(obj);
        if (find >= 0) {
            for (RecomposeScopeImpl recomposeScopeImpl : identityScopeMap.scopeSetAt(find)) {
                if (!compositionImpl.observationsProcessed.remove(obj, recomposeScopeImpl) && recomposeScopeImpl.invalidateForResult(obj) != InvalidationResult.IGNORED) {
                    if (recomposeScopeImpl.isConditional() && !z16) {
                        compositionImpl.conditionallyInvalidatedScopes.add(recomposeScopeImpl);
                    } else {
                        HashSet<RecomposeScopeImpl> hashSet = objectRef.element;
                        HashSet<RecomposeScopeImpl> hashSet2 = hashSet;
                        if (hashSet == null) {
                            ?? hashSet3 = new HashSet();
                            objectRef.element = hashSet3;
                            hashSet2 = hashSet3;
                        }
                        hashSet2.add(recomposeScopeImpl);
                    }
                }
            }
        }
    }

    private final void applyChangesInLocked(List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> changes) {
        boolean isEmpty;
        RememberEventDispatcher rememberEventDispatcher = new RememberEventDispatcher(this.abandonSet);
        try {
            if (changes.isEmpty()) {
                if (isEmpty) {
                    return;
                } else {
                    return;
                }
            }
            Object beginSection = Trace.INSTANCE.beginSection("Compose:applyChanges");
            try {
                this.applier.onBeginChanges();
                SlotWriter openWriter = this.slotTable.openWriter();
                try {
                    Applier<?> applier = this.applier;
                    int size = changes.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        changes.get(i3).invoke(applier, openWriter, rememberEventDispatcher);
                    }
                    changes.clear();
                    Unit unit = Unit.INSTANCE;
                    openWriter.close();
                    this.applier.onEndChanges();
                    Trace trace = Trace.INSTANCE;
                    trace.endSection(beginSection);
                    rememberEventDispatcher.dispatchRememberObservers();
                    rememberEventDispatcher.dispatchSideEffects();
                    if (this.pendingInvalidScopes) {
                        beginSection = trace.beginSection("Compose:unobserve");
                        try {
                            this.pendingInvalidScopes = false;
                            IdentityScopeMap<RecomposeScopeImpl> identityScopeMap = this.observations;
                            int size2 = identityScopeMap.getSize();
                            int i16 = 0;
                            for (int i17 = 0; i17 < size2; i17++) {
                                int i18 = identityScopeMap.getValueOrder()[i17];
                                IdentityArraySet<RecomposeScopeImpl> identityArraySet = identityScopeMap.getScopeSets()[i18];
                                Intrinsics.checkNotNull(identityArraySet);
                                int size3 = identityArraySet.size();
                                int i19 = 0;
                                for (int i26 = 0; i26 < size3; i26++) {
                                    Object obj = identityArraySet.getValues()[i26];
                                    if (obj != null) {
                                        if (!(!((RecomposeScopeImpl) obj).getValid())) {
                                            if (i19 != i26) {
                                                identityArraySet.getValues()[i19] = obj;
                                            }
                                            i19++;
                                        }
                                    } else {
                                        throw new NullPointerException("null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                                    }
                                }
                                int size4 = identityArraySet.size();
                                for (int i27 = i19; i27 < size4; i27++) {
                                    identityArraySet.getValues()[i27] = null;
                                }
                                identityArraySet.setSize(i19);
                                if (identityArraySet.size() > 0) {
                                    if (i16 != i17) {
                                        int i28 = identityScopeMap.getValueOrder()[i16];
                                        identityScopeMap.getValueOrder()[i16] = i18;
                                        identityScopeMap.getValueOrder()[i17] = i28;
                                    }
                                    i16++;
                                }
                            }
                            int size5 = identityScopeMap.getSize();
                            for (int i29 = i16; i29 < size5; i29++) {
                                identityScopeMap.getValues()[identityScopeMap.getValueOrder()[i29]] = null;
                            }
                            identityScopeMap.setSize(i16);
                            cleanUpDerivedStateObservations();
                            Unit unit2 = Unit.INSTANCE;
                            Trace.INSTANCE.endSection(beginSection);
                        } finally {
                        }
                    }
                    if (this.lateChanges.isEmpty()) {
                        rememberEventDispatcher.dispatchAbandons();
                    }
                } catch (Throwable th5) {
                    openWriter.close();
                    throw th5;
                }
            } finally {
            }
        } finally {
            if (this.lateChanges.isEmpty()) {
                rememberEventDispatcher.dispatchAbandons();
            }
        }
    }

    private final void cleanUpDerivedStateObservations() {
        IdentityScopeMap<DerivedState<?>> identityScopeMap = this.derivedStates;
        int size = identityScopeMap.getSize();
        int i3 = 0;
        for (int i16 = 0; i16 < size; i16++) {
            int i17 = identityScopeMap.getValueOrder()[i16];
            IdentityArraySet<DerivedState<?>> identityArraySet = identityScopeMap.getScopeSets()[i17];
            Intrinsics.checkNotNull(identityArraySet);
            int size2 = identityArraySet.size();
            int i18 = 0;
            for (int i19 = 0; i19 < size2; i19++) {
                Object obj = identityArraySet.getValues()[i19];
                if (obj != null) {
                    if (!(!this.observations.contains((DerivedState) obj))) {
                        if (i18 != i19) {
                            identityArraySet.getValues()[i18] = obj;
                        }
                        i18++;
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                }
            }
            int size3 = identityArraySet.size();
            for (int i26 = i18; i26 < size3; i26++) {
                identityArraySet.getValues()[i26] = null;
            }
            identityArraySet.setSize(i18);
            if (identityArraySet.size() > 0) {
                if (i3 != i16) {
                    int i27 = identityScopeMap.getValueOrder()[i3];
                    identityScopeMap.getValueOrder()[i3] = i17;
                    identityScopeMap.getValueOrder()[i16] = i27;
                }
                i3++;
            }
        }
        int size4 = identityScopeMap.getSize();
        for (int i28 = i3; i28 < size4; i28++) {
            identityScopeMap.getValues()[identityScopeMap.getValueOrder()[i28]] = null;
        }
        identityScopeMap.setSize(i3);
        Iterator<RecomposeScopeImpl> it = this.conditionallyInvalidatedScopes.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator()");
        while (it.hasNext()) {
            if (!it.next().isConditional()) {
                it.remove();
            }
        }
    }

    private final void drainPendingModificationsForCompositionLocked() {
        Object obj;
        Object obj2;
        AtomicReference<Object> atomicReference = this.pendingModifications;
        obj = CompositionKt.PendingApplyNoModifications;
        Object andSet = atomicReference.getAndSet(obj);
        if (andSet != null) {
            obj2 = CompositionKt.PendingApplyNoModifications;
            if (!Intrinsics.areEqual(andSet, obj2)) {
                if (andSet instanceof Set) {
                    addPendingInvalidationsLocked((Set) andSet, true);
                    return;
                }
                if (andSet instanceof Object[]) {
                    for (Set<? extends Object> set : (Set[]) andSet) {
                        addPendingInvalidationsLocked(set, true);
                    }
                    return;
                }
                throw new IllegalStateException(("corrupt pendingModifications drain: " + this.pendingModifications).toString());
            }
            throw new IllegalStateException("pending composition has not been applied".toString());
        }
    }

    private final void drainPendingModificationsLocked() {
        Object obj;
        Object andSet = this.pendingModifications.getAndSet(null);
        obj = CompositionKt.PendingApplyNoModifications;
        if (Intrinsics.areEqual(andSet, obj)) {
            return;
        }
        if (andSet instanceof Set) {
            addPendingInvalidationsLocked((Set) andSet, false);
            return;
        }
        if (!(andSet instanceof Object[])) {
            if (andSet == null) {
                throw new IllegalStateException("calling recordModificationsOf and applyChanges concurrently is not supported".toString());
            }
            throw new IllegalStateException(("corrupt pendingModifications drain: " + this.pendingModifications).toString());
        }
        for (Set<? extends Object> set : (Set[]) andSet) {
            addPendingInvalidationsLocked(set, false);
        }
    }

    private final boolean getAreChildrenComposing() {
        return this.composer.getAreChildrenComposing$runtime_release();
    }

    private final InvalidationResult invalidateChecked(RecomposeScopeImpl scope, Anchor anchor, Object instance) {
        synchronized (this.lock) {
            CompositionImpl compositionImpl = this.invalidationDelegate;
            if (compositionImpl == null || !this.slotTable.groupContainsAnchor(this.invalidationDelegateGroup, anchor)) {
                compositionImpl = null;
            }
            if (compositionImpl == null) {
                if (isComposing() && this.composer.tryImminentInvalidation$runtime_release(scope, instance)) {
                    return InvalidationResult.IMMINENT;
                }
                if (instance != null) {
                    CompositionKt.addValue(this.invalidations, scope, instance);
                } else {
                    this.invalidations.set(scope, null);
                }
            }
            if (compositionImpl != null) {
                return compositionImpl.invalidateChecked(scope, anchor, instance);
            }
            this.parent.invalidate$runtime_release(this);
            if (isComposing()) {
                return InvalidationResult.DEFERRED;
            }
            return InvalidationResult.SCHEDULED;
        }
    }

    private final void invalidateScopeOfLocked(Object value) {
        IdentityScopeMap<RecomposeScopeImpl> identityScopeMap = this.observations;
        int find = identityScopeMap.find(value);
        if (find >= 0) {
            for (RecomposeScopeImpl recomposeScopeImpl : identityScopeMap.scopeSetAt(find)) {
                if (recomposeScopeImpl.invalidateForResult(value) == InvalidationResult.IMMINENT) {
                    this.observationsProcessed.add(value, recomposeScopeImpl);
                }
            }
        }
    }

    private final IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> takeInvalidations() {
        IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> identityArrayMap = this.invalidations;
        this.invalidations = new IdentityArrayMap<>(0, 1, null);
        return identityArrayMap;
    }

    private final void validateRecomposeScopeAnchors(SlotTable slotTable) {
        int indexOf;
        Object[] slots = slotTable.getSlots();
        ArrayList arrayList = new ArrayList();
        for (Object obj : slots) {
            RecomposeScopeImpl recomposeScopeImpl = obj instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) obj : null;
            if (recomposeScopeImpl != null) {
                arrayList.add(recomposeScopeImpl);
            }
        }
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) arrayList.get(i3);
            Anchor anchor = recomposeScopeImpl2.getAnchor();
            if (anchor != null && !slotTable.slotsOf$runtime_release(anchor.toIndexFor(slotTable)).contains(recomposeScopeImpl2)) {
                indexOf = ArraysKt___ArraysKt.indexOf((RecomposeScopeImpl[]) slotTable.getSlots(), recomposeScopeImpl2);
                throw new IllegalStateException(("Misaligned anchor " + anchor + " in scope " + recomposeScopeImpl2 + " encountered, scope found at " + indexOf).toString());
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void applyChanges() {
        synchronized (this.lock) {
            applyChangesInLocked(this.changes);
            drainPendingModificationsLocked();
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void applyLateChanges() {
        synchronized (this.lock) {
            if (!this.lateChanges.isEmpty()) {
                applyChangesInLocked(this.lateChanges);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void changesApplied() {
        synchronized (this.lock) {
            this.composer.changesApplied$runtime_release();
            if (!this.abandonSet.isEmpty()) {
                new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void composeContent(Function2<? super Composer, ? super Integer, Unit> content) {
        Intrinsics.checkNotNullParameter(content, "content");
        try {
            synchronized (this.lock) {
                drainPendingModificationsForCompositionLocked();
                this.composer.composeContent$runtime_release(takeInvalidations(), content);
                Unit unit = Unit.INSTANCE;
            }
        } catch (Throwable th5) {
            if (!this.abandonSet.isEmpty()) {
                new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
            }
            throw th5;
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public <R> R delegateInvalidations(ControlledComposition to5, int groupIndex, Function0<? extends R> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (to5 != null && !Intrinsics.areEqual(to5, this) && groupIndex >= 0) {
            this.invalidationDelegate = (CompositionImpl) to5;
            this.invalidationDelegateGroup = groupIndex;
            try {
                return block.invoke();
            } finally {
                this.invalidationDelegate = null;
                this.invalidationDelegateGroup = 0;
            }
        }
        return block.invoke();
    }

    @Override // androidx.compose.runtime.Composition
    public void dispose() {
        synchronized (this.lock) {
            if (!this.disposed) {
                this.disposed = true;
                this.composable = ComposableSingletons$CompositionKt.INSTANCE.m6getLambda2$runtime_release();
                boolean z16 = this.slotTable.getGroupsSize() > 0;
                if (z16 || (true ^ this.abandonSet.isEmpty())) {
                    RememberEventDispatcher rememberEventDispatcher = new RememberEventDispatcher(this.abandonSet);
                    if (z16) {
                        SlotWriter openWriter = this.slotTable.openWriter();
                        try {
                            ComposerKt.removeCurrentGroup(openWriter, rememberEventDispatcher);
                            Unit unit = Unit.INSTANCE;
                            openWriter.close();
                            this.applier.clear();
                            rememberEventDispatcher.dispatchRememberObservers();
                        } catch (Throwable th5) {
                            openWriter.close();
                            throw th5;
                        }
                    }
                    rememberEventDispatcher.dispatchAbandons();
                }
                this.composer.dispose$runtime_release();
            }
            Unit unit2 = Unit.INSTANCE;
        }
        this.parent.unregisterComposition$runtime_release(this);
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void disposeUnusedMovableContent(MovableContentState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        RememberEventDispatcher rememberEventDispatcher = new RememberEventDispatcher(this.abandonSet);
        SlotWriter openWriter = state.getSlotTable().openWriter();
        try {
            ComposerKt.removeCurrentGroup(openWriter, rememberEventDispatcher);
            Unit unit = Unit.INSTANCE;
            openWriter.close();
            rememberEventDispatcher.dispatchRememberObservers();
        } catch (Throwable th5) {
            openWriter.close();
            throw th5;
        }
    }

    public final Function2<Composer, Integer, Unit> getComposable() {
        return this.composable;
    }

    public final List<RecomposeScopeImpl> getConditionalScopes$runtime_release() {
        List<RecomposeScopeImpl> list;
        list = CollectionsKt___CollectionsKt.toList(this.conditionallyInvalidatedScopes);
        return list;
    }

    public final List<Object> getDerivedStateDependencies$runtime_release() {
        List<Object> filterNotNull;
        filterNotNull = ArraysKt___ArraysKt.filterNotNull(this.derivedStates.getValues());
        return filterNotNull;
    }

    @Override // androidx.compose.runtime.Composition
    public boolean getHasInvalidations() {
        boolean z16;
        synchronized (this.lock) {
            z16 = this.invalidations.getSize() > 0;
        }
        return z16;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public boolean getHasPendingChanges() {
        boolean hasPendingChanges$runtime_release;
        synchronized (this.lock) {
            hasPendingChanges$runtime_release = this.composer.getHasPendingChanges$runtime_release();
        }
        return hasPendingChanges$runtime_release;
    }

    public final List<Object> getObservedObjects$runtime_release() {
        List<Object> filterNotNull;
        filterNotNull = ArraysKt___ArraysKt.filterNotNull(this.observations.getValues());
        return filterNotNull;
    }

    /* renamed from: getPendingInvalidScopes$runtime_release, reason: from getter */
    public final boolean getPendingInvalidScopes() {
        return this.pendingInvalidScopes;
    }

    public final CoroutineContext getRecomposeContext() {
        CoroutineContext coroutineContext = this._recomposeContext;
        return coroutineContext == null ? this.parent.getRecomposeCoroutineContext$runtime_release() : coroutineContext;
    }

    /* renamed from: getSlotTable$runtime_release, reason: from getter */
    public final SlotTable getSlotTable() {
        return this.slotTable;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void insertMovableContent(List<Pair<MovableContentStateReference, MovableContentStateReference>> references) {
        Intrinsics.checkNotNullParameter(references, "references");
        int size = references.size();
        boolean z16 = false;
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                z16 = true;
                break;
            } else if (!Intrinsics.areEqual(references.get(i3).getFirst().getComposition(), this)) {
                break;
            } else {
                i3++;
            }
        }
        ComposerKt.runtimeCheck(z16);
        try {
            this.composer.insertMovableContentReferences(references);
            Unit unit = Unit.INSTANCE;
        } catch (Throwable th5) {
            if (!this.abandonSet.isEmpty()) {
                new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
            }
            throw th5;
        }
    }

    public final InvalidationResult invalidate(RecomposeScopeImpl scope, Object instance) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        if (scope.getDefaultsInScope()) {
            scope.setDefaultsInvalid(true);
        }
        Anchor anchor = scope.getAnchor();
        if (anchor != null && this.slotTable.ownsAnchor(anchor) && anchor.getValid()) {
            if (!anchor.getValid()) {
                return InvalidationResult.IGNORED;
            }
            if (!scope.getCanRecompose()) {
                return InvalidationResult.IGNORED;
            }
            return invalidateChecked(scope, anchor, instance);
        }
        return InvalidationResult.IGNORED;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void invalidateAll() {
        synchronized (this.lock) {
            for (Object obj : this.slotTable.getSlots()) {
                RecomposeScopeImpl recomposeScopeImpl = obj instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) obj : null;
                if (recomposeScopeImpl != null) {
                    recomposeScopeImpl.invalidate();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void invalidateGroupsWithKey(int key) {
        List<RecomposeScopeImpl> invalidateGroupsWithKey$runtime_release;
        boolean z16;
        synchronized (this.lock) {
            invalidateGroupsWithKey$runtime_release = this.slotTable.invalidateGroupsWithKey$runtime_release(key);
        }
        boolean z17 = true;
        if (invalidateGroupsWithKey$runtime_release != null) {
            int size = invalidateGroupsWithKey$runtime_release.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    z16 = false;
                    break;
                }
                if (invalidateGroupsWithKey$runtime_release.get(i3).invalidateForResult(null) == InvalidationResult.IGNORED) {
                    z16 = true;
                    break;
                }
                i3++;
            }
            if (!z16) {
                z17 = false;
            }
        }
        if (z17 && this.composer.forceRecomposeScopes$runtime_release()) {
            this.parent.invalidate$runtime_release(this);
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public boolean isComposing() {
        return this.composer.getIsComposing();
    }

    @Override // androidx.compose.runtime.Composition
    /* renamed from: isDisposed, reason: from getter */
    public boolean getDisposed() {
        return this.disposed;
    }

    /* renamed from: isRoot, reason: from getter */
    public final boolean getIsRoot() {
        return this.isRoot;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public boolean observesAnyOf(Set<? extends Object> values) {
        Intrinsics.checkNotNullParameter(values, "values");
        for (Object obj : values) {
            if (this.observations.contains(obj) || this.derivedStates.contains(obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void prepareCompose(Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.composer.prepareCompose$runtime_release(block);
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public boolean recompose() {
        boolean recompose$runtime_release;
        synchronized (this.lock) {
            drainPendingModificationsForCompositionLocked();
            try {
                recompose$runtime_release = this.composer.recompose$runtime_release(takeInvalidations());
                if (!recompose$runtime_release) {
                    drainPendingModificationsLocked();
                }
            } finally {
            }
        }
        return recompose$runtime_release;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.util.Set[]] */
    @Override // androidx.compose.runtime.ControlledComposition
    public void recordModificationsOf(Set<? extends Object> values) {
        Object obj;
        Object obj2;
        boolean areEqual;
        ?? plus;
        Set<? extends Object> set;
        Intrinsics.checkNotNullParameter(values, "values");
        do {
            obj = this.pendingModifications.get();
            if (obj == null) {
                areEqual = true;
            } else {
                obj2 = CompositionKt.PendingApplyNoModifications;
                areEqual = Intrinsics.areEqual(obj, obj2);
            }
            if (areEqual) {
                set = values;
            } else if (obj instanceof Set) {
                set = new Set[]{(Set) obj, values};
            } else {
                if (!(obj instanceof Object[])) {
                    throw new IllegalStateException(("corrupt pendingModifications: " + this.pendingModifications).toString());
                }
                if (obj != null) {
                    plus = ArraysKt___ArraysJvmKt.plus((Set<? extends Object>[]) obj, values);
                    set = plus;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.collections.Set<kotlin.Any>>");
                }
            }
        } while (!c.a(this.pendingModifications, obj, set));
        if (obj == null) {
            synchronized (this.lock) {
                drainPendingModificationsLocked();
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void recordReadOf(Object value) {
        RecomposeScopeImpl currentRecomposeScope$runtime_release;
        Intrinsics.checkNotNullParameter(value, "value");
        if (getAreChildrenComposing() || (currentRecomposeScope$runtime_release = this.composer.getCurrentRecomposeScope$runtime_release()) == null) {
            return;
        }
        currentRecomposeScope$runtime_release.setUsed(true);
        this.observations.add(value, currentRecomposeScope$runtime_release);
        if (value instanceof DerivedState) {
            this.derivedStates.removeScope(value);
            Iterator<T> it = ((DerivedState) value).getDependencies().iterator();
            while (it.hasNext()) {
                this.derivedStates.add((StateObject) it.next(), value);
            }
        }
        currentRecomposeScope$runtime_release.recordRead(value);
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void recordWriteOf(Object value) {
        Intrinsics.checkNotNullParameter(value, "value");
        synchronized (this.lock) {
            invalidateScopeOfLocked(value);
            IdentityScopeMap<DerivedState<?>> identityScopeMap = this.derivedStates;
            int find = identityScopeMap.find(value);
            if (find >= 0) {
                Iterator<T> it = identityScopeMap.scopeSetAt(find).iterator();
                while (it.hasNext()) {
                    invalidateScopeOfLocked((DerivedState) it.next());
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void removeDerivedStateObservation$runtime_release(DerivedState<?> state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (this.observations.contains(state)) {
            return;
        }
        this.derivedStates.removeScope(state);
    }

    public final void removeObservation$runtime_release(Object instance, RecomposeScopeImpl scope) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.observations.remove(instance, scope);
    }

    public final void setComposable(Function2<? super Composer, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "<set-?>");
        this.composable = function2;
    }

    @Override // androidx.compose.runtime.Composition
    public void setContent(Function2<? super Composer, ? super Integer, Unit> content) {
        Intrinsics.checkNotNullParameter(content, "content");
        if (!this.disposed) {
            this.composable = content;
            this.parent.composeInitial$runtime_release(this, content);
            return;
        }
        throw new IllegalStateException("The composition is disposed".toString());
    }

    public final void setPendingInvalidScopes$runtime_release(boolean z16) {
        this.pendingInvalidScopes = z16;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void verifyConsistent() {
        synchronized (this.lock) {
            if (!isComposing()) {
                this.slotTable.verifyWellFormed();
                validateRecomposeScopeAnchors(this.slotTable);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final <T> T trackAbandonedValues(Function0<? extends T> block) {
        try {
            T invoke = block.invoke();
            InlineMarker.finallyStart(1);
            InlineMarker.finallyEnd(1);
            return invoke;
        } catch (Throwable th5) {
            InlineMarker.finallyStart(1);
            if (!this.abandonSet.isEmpty()) {
                new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
            }
            InlineMarker.finallyEnd(1);
            throw th5;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:41:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a9 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void addPendingInvalidationsLocked(Set<? extends Object> values, boolean forgetConditionalScopes) {
        boolean z16;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        for (Object obj : values) {
            if (obj instanceof RecomposeScopeImpl) {
                ((RecomposeScopeImpl) obj).invalidateForResult(null);
            } else {
                addPendingInvalidationsLocked$invalidate(this, forgetConditionalScopes, objectRef, obj);
                IdentityScopeMap<DerivedState<?>> identityScopeMap = this.derivedStates;
                int find = identityScopeMap.find(obj);
                if (find >= 0) {
                    Iterator<T> it = identityScopeMap.scopeSetAt(find).iterator();
                    while (it.hasNext()) {
                        addPendingInvalidationsLocked$invalidate(this, forgetConditionalScopes, objectRef, (DerivedState) it.next());
                    }
                }
            }
        }
        if (forgetConditionalScopes && (!this.conditionallyInvalidatedScopes.isEmpty())) {
            IdentityScopeMap<RecomposeScopeImpl> identityScopeMap2 = this.observations;
            int size = identityScopeMap2.getSize();
            int i3 = 0;
            for (int i16 = 0; i16 < size; i16++) {
                int i17 = identityScopeMap2.getValueOrder()[i16];
                IdentityArraySet<RecomposeScopeImpl> identityArraySet = identityScopeMap2.getScopeSets()[i17];
                Intrinsics.checkNotNull(identityArraySet);
                int size2 = identityArraySet.size();
                int i18 = 0;
                for (int i19 = 0; i19 < size2; i19++) {
                    Object obj2 = identityArraySet.getValues()[i19];
                    if (obj2 != null) {
                        RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) obj2;
                        if (!this.conditionallyInvalidatedScopes.contains(recomposeScopeImpl)) {
                            HashSet hashSet = (HashSet) objectRef.element;
                            if (!(hashSet != null && hashSet.contains(recomposeScopeImpl))) {
                                z16 = false;
                                if (!z16) {
                                    if (i18 != i19) {
                                        identityArraySet.getValues()[i18] = obj2;
                                    }
                                    i18++;
                                }
                            }
                        }
                        z16 = true;
                        if (!z16) {
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                    }
                }
                int size3 = identityArraySet.size();
                for (int i26 = i18; i26 < size3; i26++) {
                    identityArraySet.getValues()[i26] = null;
                }
                identityArraySet.setSize(i18);
                if (identityArraySet.size() > 0) {
                    if (i3 != i16) {
                        int i27 = identityScopeMap2.getValueOrder()[i3];
                        identityScopeMap2.getValueOrder()[i3] = i17;
                        identityScopeMap2.getValueOrder()[i16] = i27;
                    }
                    i3++;
                }
            }
            int size4 = identityScopeMap2.getSize();
            for (int i28 = i3; i28 < size4; i28++) {
                identityScopeMap2.getValues()[identityScopeMap2.getValueOrder()[i28]] = null;
            }
            identityScopeMap2.setSize(i3);
            cleanUpDerivedStateObservations();
            this.conditionallyInvalidatedScopes.clear();
            return;
        }
        HashSet hashSet2 = (HashSet) objectRef.element;
        if (hashSet2 != null) {
            IdentityScopeMap<RecomposeScopeImpl> identityScopeMap3 = this.observations;
            int size5 = identityScopeMap3.getSize();
            int i29 = 0;
            for (int i36 = 0; i36 < size5; i36++) {
                int i37 = identityScopeMap3.getValueOrder()[i36];
                IdentityArraySet<RecomposeScopeImpl> identityArraySet2 = identityScopeMap3.getScopeSets()[i37];
                Intrinsics.checkNotNull(identityArraySet2);
                int size6 = identityArraySet2.size();
                int i38 = 0;
                for (int i39 = 0; i39 < size6; i39++) {
                    Object obj3 = identityArraySet2.getValues()[i39];
                    if (obj3 != null) {
                        if (!hashSet2.contains((RecomposeScopeImpl) obj3)) {
                            if (i38 != i39) {
                                identityArraySet2.getValues()[i38] = obj3;
                            }
                            i38++;
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                    }
                }
                int size7 = identityArraySet2.size();
                for (int i46 = i38; i46 < size7; i46++) {
                    identityArraySet2.getValues()[i46] = null;
                }
                identityArraySet2.setSize(i38);
                if (identityArraySet2.size() > 0) {
                    if (i29 != i36) {
                        int i47 = identityScopeMap3.getValueOrder()[i29];
                        identityScopeMap3.getValueOrder()[i29] = i37;
                        identityScopeMap3.getValueOrder()[i36] = i47;
                    }
                    i29++;
                }
            }
            int size8 = identityScopeMap3.getSize();
            for (int i48 = i29; i48 < size8; i48++) {
                identityScopeMap3.getValues()[identityScopeMap3.getValueOrder()[i48]] = null;
            }
            identityScopeMap3.setSize(i29);
            cleanUpDerivedStateObservations();
        }
    }

    public /* synthetic */ CompositionImpl(CompositionContext compositionContext, Applier applier, CoroutineContext coroutineContext, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(compositionContext, applier, (i3 & 4) != 0 ? null : coroutineContext);
    }
}
