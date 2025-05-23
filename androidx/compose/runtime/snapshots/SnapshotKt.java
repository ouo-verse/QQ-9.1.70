package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.SnapshotThreadLocal;
import androidx.compose.runtime.SynchronizationKt;
import androidx.compose.runtime.SynchronizedObject;
import androidx.compose.runtime.snapshots.SnapshotIdSet;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.aspectj.lang.JoinPoint;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\n\u001a\b\u0010%\u001a\u00020\bH\u0002\u001a6\u0010%\u001a\u0002H&\"\u0004\b\u0000\u0010&2!\u0010'\u001a\u001d\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u0002H&0\u000fH\u0002\u00a2\u0006\u0002\u0010(\u001a4\u0010)\u001a\u00020\u00072\b\u0010*\u001a\u0004\u0018\u00010\u00072\u0016\b\u0002\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f2\b\b\u0002\u0010,\u001a\u00020-H\u0002\u001a'\u0010.\u001a\u0002H&\"\b\b\u0000\u0010&*\u00020/2\u0006\u00100\u001a\u0002H&2\u0006\u00101\u001a\u00020\u0007H\u0001\u00a2\u0006\u0002\u00102\u001a\b\u00103\u001a\u00020\u0007H\u0000\u001aL\u00104\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f2\u0014\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f2\u0014\u00105\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f2\b\b\u0002\u00106\u001a\u00020-H\u0002\u001aB\u00107\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f2\u0014\u00108\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f2\u0014\u00105\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\u000fH\u0002\u001a\u0018\u00109\u001a\u00020\b2\u0006\u00101\u001a\u00020\u00072\u0006\u0010:\u001a\u00020;H\u0001\u001a.\u0010<\u001a\u0010\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020/\u0018\u00010=2\u0006\u00103\u001a\u00020>2\u0006\u0010?\u001a\u00020>2\u0006\u0010@\u001a\u00020\u0010H\u0002\u001a\b\u0010A\u001a\u00020BH\u0002\u001a1\u0010C\u001a\u0004\u0018\u0001H&\"\b\b\u0000\u0010&*\u00020/2\u0006\u00100\u001a\u0002H&2\u0006\u0010D\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0010H\u0002\u00a2\u0006\u0002\u0010E\u001a\u0010\u0010F\u001a\u00020\b2\u0006\u0010G\u001a\u00020\u0001H\u0000\u001a\b\u0010H\u001a\u00020BH\u0002\u001a%\u0010I\u001a\u0002H&\"\u0004\b\u0000\u0010&2\f\u0010'\u001a\b\u0012\u0004\u0012\u0002H&0JH\u0081\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010K\u001a>\u0010L\u001a\u0002H&\"\u0004\b\u0000\u0010&2\u0006\u0010M\u001a\u00020\u00072!\u0010'\u001a\u001d\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u0002H&0\u000fH\u0002\u00a2\u0006\u0002\u0010N\u001a:\u0010O\u001a\u0002H&\"\b\b\u0000\u0010&*\u00020\u00072!\u0010'\u001a\u001d\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u0002H&0\u000fH\u0002\u00a2\u0006\u0002\u0010P\u001a\u0018\u0010Q\u001a\u00020\u00012\u0006\u0010D\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0010H\u0000\u001a\u0012\u0010R\u001a\u0004\u0018\u00010/2\u0006\u0010:\u001a\u00020;H\u0002\u001a \u0010S\u001a\u00020-2\u0006\u0010T\u001a\u00020/2\u0006\u00101\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0010H\u0002\u001a \u0010S\u001a\u00020-2\u0006\u00103\u001a\u00020\u00012\u0006\u0010U\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0010H\u0002\u001a\u0010\u0010V\u001a\u00020\b2\u0006\u00101\u001a\u00020\u0007H\u0002\u001a\u001c\u0010W\u001a\u00020\u0010*\u00020\u00102\u0006\u0010X\u001a\u00020\u00012\u0006\u0010Y\u001a\u00020\u0001H\u0000\u001a#\u0010Z\u001a\u0002H&\"\b\b\u0000\u0010&*\u00020/*\u0002H&2\u0006\u0010:\u001a\u00020;H\u0000\u00a2\u0006\u0002\u0010[\u001a+\u0010\\\u001a\u0002H&\"\b\b\u0000\u0010&*\u00020/*\u0002H&2\u0006\u0010:\u001a\u00020;2\u0006\u00101\u001a\u00020\u0007H\u0000\u00a2\u0006\u0002\u0010]\u001aN\u0010^\u001a\u0002H_\"\b\b\u0000\u0010&*\u00020/\"\u0004\b\u0001\u0010_*\u0002H&2\u0006\u0010:\u001a\u00020;2\u0006\u0010`\u001a\u0002H&2\u0017\u0010'\u001a\u0013\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u0002H_0\u000f\u00a2\u0006\u0002\baH\u0080\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010b\u001a3\u0010c\u001a\u0002H&\"\b\b\u0000\u0010&*\u00020/*\u0002H&2\u0006\u0010:\u001a\u00020;2\u0006\u00101\u001a\u00020\u00072\u0006\u0010`\u001a\u0002H&H\u0000\u00a2\u0006\u0002\u0010d\u001a!\u0010C\u001a\u0002H&\"\b\b\u0000\u0010&*\u00020/*\u0002H&2\u0006\u0010:\u001a\u00020;\u00a2\u0006\u0002\u0010[\u001a)\u0010C\u001a\u0002H&\"\b\b\u0000\u0010&*\u00020/*\u0002H&2\u0006\u0010:\u001a\u00020;2\u0006\u00101\u001a\u00020\u0007\u00a2\u0006\u0002\u0010]\u001aH\u0010e\u001a\u0002H_\"\b\b\u0000\u0010&*\u00020/\"\u0004\b\u0001\u0010_*\u0002H&2!\u0010'\u001a\u001d\u0012\u0013\u0012\u0011H&\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(0\u0012\u0004\u0012\u0002H_0\u000fH\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010f\u001aF\u0010g\u001a\u0002H_\"\b\b\u0000\u0010&*\u00020/\"\u0004\b\u0001\u0010_*\u0002H&2\u0006\u0010:\u001a\u00020;2\u0017\u0010'\u001a\u0013\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u0002H_0\u000f\u00a2\u0006\u0002\baH\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010h\u001aN\u0010g\u001a\u0002H_\"\b\b\u0000\u0010&*\u00020/\"\u0004\b\u0001\u0010_*\u0002H&2\u0006\u0010:\u001a\u00020;2\u0006\u00101\u001a\u00020\u00072\u0017\u0010'\u001a\u0013\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u0002H_0\u000f\u00a2\u0006\u0002\baH\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010i\u001a+\u0010j\u001a\u0002H&\"\b\b\u0000\u0010&*\u00020/*\u0002H&2\u0006\u0010:\u001a\u00020;2\u0006\u00101\u001a\u00020\u0007H\u0001\u00a2\u0006\u0002\u0010]\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\",\u0010\u0002\u001a \u0012\u001c\u0012\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\".\u0010\t\u001a\"\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b0\nj\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b`\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000\")\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\b0\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\" \u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u000f0\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u001c\u0010\u0015\u001a\u00020\u00168\u0000X\u0081\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u000e\u0010\u001b\u001a\u00020\u0001X\u0082\u000e\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u001c\u0010\u001f\u001a\u00020\u00078\u0000X\u0081\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0018\u001a\u0004\b!\u0010\"\"\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00070$X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006k"}, d2 = {"INVALID_SNAPSHOT", "", "applyObservers", "", "Lkotlin/Function2;", "", "", "Landroidx/compose/runtime/snapshots/Snapshot;", "", "currentGlobalSnapshot", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/runtime/snapshots/GlobalSnapshot;", "kotlin.jvm.PlatformType", "Landroidx/compose/runtime/AtomicReference;", "emptyLambda", "Lkotlin/Function1;", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "Lkotlin/ParameterName;", "name", HippyReporter.RemoveEngineReason.INVALID, "globalWriteObservers", JoinPoint.SYNCHRONIZATION_LOCK, "Landroidx/compose/runtime/SynchronizedObject;", "getLock$annotations", "()V", "getLock", "()Landroidx/compose/runtime/SynchronizedObject;", "nextSnapshotId", "openSnapshots", "pinningTable", "Landroidx/compose/runtime/snapshots/SnapshotDoubleIndexHeap;", "snapshotInitializer", "getSnapshotInitializer$annotations", "getSnapshotInitializer", "()Landroidx/compose/runtime/snapshots/Snapshot;", "threadSnapshot", "Landroidx/compose/runtime/SnapshotThreadLocal;", "advanceGlobalSnapshot", "T", "block", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "createTransparentSnapshotWithNoParentReadObserver", "previousSnapshot", "readObserver", "ownsPreviousSnapshot", "", "current", "Landroidx/compose/runtime/snapshots/StateRecord;", "r", "snapshot", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/Snapshot;)Landroidx/compose/runtime/snapshots/StateRecord;", "currentSnapshot", "mergedReadObserver", "parentObserver", "mergeReadObserver", "mergedWriteObserver", "writeObserver", "notifyWrite", "state", "Landroidx/compose/runtime/snapshots/StateObject;", "optimisticMerges", "", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "applyingSnapshot", "invalidSnapshots", "readError", "", "readable", "id", "(Landroidx/compose/runtime/snapshots/StateRecord;ILandroidx/compose/runtime/snapshots/SnapshotIdSet;)Landroidx/compose/runtime/snapshots/StateRecord;", "releasePinningLocked", "handle", "reportReadonlySnapshotWrite", "sync", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "takeNewGlobalSnapshot", "previousGlobalSnapshot", "(Landroidx/compose/runtime/snapshots/Snapshot;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "takeNewSnapshot", "(Lkotlin/jvm/functions/Function1;)Landroidx/compose/runtime/snapshots/Snapshot;", "trackPinning", "used", "valid", "data", "candidateSnapshot", "validateOpen", "addRange", "from", "until", "newOverwritableRecord", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;)Landroidx/compose/runtime/snapshots/StateRecord;", "newWritableRecord", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;Landroidx/compose/runtime/snapshots/Snapshot;)Landroidx/compose/runtime/snapshots/StateRecord;", "overwritable", BdhLogUtil.LogTag.Tag_Req, "candidate", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;Landroidx/compose/runtime/snapshots/StateRecord;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "overwritableRecord", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;Landroidx/compose/runtime/snapshots/Snapshot;Landroidx/compose/runtime/snapshots/StateRecord;)Landroidx/compose/runtime/snapshots/StateRecord;", "withCurrent", "(Landroidx/compose/runtime/snapshots/StateRecord;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "writable", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;Landroidx/compose/runtime/snapshots/Snapshot;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "writableRecord", "runtime_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes39.dex */
public final class SnapshotKt {
    private static final int INVALID_SNAPSHOT = 0;
    private static final List<Function2<Set<? extends Object>, Snapshot, Unit>> applyObservers;
    private static final AtomicReference<GlobalSnapshot> currentGlobalSnapshot;
    private static final List<Function1<Object, Unit>> globalWriteObservers;
    private static int nextSnapshotId;
    private static SnapshotIdSet openSnapshots;
    private static final SnapshotDoubleIndexHeap pinningTable;
    private static final Snapshot snapshotInitializer;
    private static final Function1<SnapshotIdSet, Unit> emptyLambda = new Function1<SnapshotIdSet, Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotKt$emptyLambda$1
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SnapshotIdSet it) {
            Intrinsics.checkNotNullParameter(it, "it");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SnapshotIdSet snapshotIdSet) {
            invoke2(snapshotIdSet);
            return Unit.INSTANCE;
        }
    };
    private static final SnapshotThreadLocal<Snapshot> threadSnapshot = new SnapshotThreadLocal<>();
    private static final SynchronizedObject lock = SynchronizationKt.createSynchronizedObject();

    static {
        SnapshotIdSet.Companion companion = SnapshotIdSet.INSTANCE;
        openSnapshots = companion.getEMPTY();
        nextSnapshotId = 1;
        pinningTable = new SnapshotDoubleIndexHeap();
        applyObservers = new ArrayList();
        globalWriteObservers = new ArrayList();
        int i3 = nextSnapshotId;
        nextSnapshotId = i3 + 1;
        GlobalSnapshot globalSnapshot = new GlobalSnapshot(i3, companion.getEMPTY());
        openSnapshots = openSnapshots.set(globalSnapshot.getId());
        AtomicReference<GlobalSnapshot> atomicReference = new AtomicReference<>(globalSnapshot);
        currentGlobalSnapshot = atomicReference;
        GlobalSnapshot globalSnapshot2 = atomicReference.get();
        Intrinsics.checkNotNullExpressionValue(globalSnapshot2, "currentGlobalSnapshot.get()");
        snapshotInitializer = globalSnapshot2;
    }

    public static final SnapshotIdSet addRange(SnapshotIdSet snapshotIdSet, int i3, int i16) {
        Intrinsics.checkNotNullParameter(snapshotIdSet, "<this>");
        while (i3 < i16) {
            snapshotIdSet = snapshotIdSet.set(i3);
            i3++;
        }
        return snapshotIdSet;
    }

    public static final <T> T advanceGlobalSnapshot(Function1<? super SnapshotIdSet, ? extends T> function1) {
        T t16;
        List mutableList;
        GlobalSnapshot previousGlobalSnapshot = currentGlobalSnapshot.get();
        synchronized (getLock()) {
            Intrinsics.checkNotNullExpressionValue(previousGlobalSnapshot, "previousGlobalSnapshot");
            t16 = (T) takeNewGlobalSnapshot(previousGlobalSnapshot, function1);
        }
        Set<StateObject> modified$runtime_release = previousGlobalSnapshot.getModified$runtime_release();
        if (modified$runtime_release != null) {
            synchronized (getLock()) {
                mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) applyObservers);
            }
            int size = mutableList.size();
            for (int i3 = 0; i3 < size; i3++) {
                ((Function2) mutableList.get(i3)).invoke(modified$runtime_release, previousGlobalSnapshot);
            }
        }
        return t16;
    }

    public static final Snapshot createTransparentSnapshotWithNoParentReadObserver(Snapshot snapshot, Function1<Object, Unit> function1, boolean z16) {
        boolean z17 = snapshot instanceof MutableSnapshot;
        if (!z17 && snapshot != null) {
            return new TransparentObserverSnapshot(snapshot, function1, false, z16);
        }
        return new TransparentObserverMutableSnapshot(z17 ? (MutableSnapshot) snapshot : null, function1, null, false, z16);
    }

    public static final <T extends StateRecord> T current(T r16, Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(r16, "r");
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        T t16 = (T) readable(r16, snapshot.getId(), snapshot.getInvalid());
        if (t16 != null) {
            return t16;
        }
        readError();
        throw new KotlinNothingValueException();
    }

    public static final Snapshot currentSnapshot() {
        Snapshot snapshot = threadSnapshot.get();
        if (snapshot != null) {
            return snapshot;
        }
        GlobalSnapshot globalSnapshot = currentGlobalSnapshot.get();
        Intrinsics.checkNotNullExpressionValue(globalSnapshot, "currentGlobalSnapshot.get()");
        return globalSnapshot;
    }

    public static final SynchronizedObject getLock() {
        return lock;
    }

    public static final Snapshot getSnapshotInitializer() {
        return snapshotInitializer;
    }

    public static final <T extends StateRecord> T newOverwritableRecord(T t16, StateObject state) {
        Intrinsics.checkNotNullParameter(t16, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        T t17 = (T) used(state);
        if (t17 != null) {
            t17.setSnapshotId$runtime_release(Integer.MAX_VALUE);
            return t17;
        }
        T t18 = (T) t16.create();
        t18.setSnapshotId$runtime_release(Integer.MAX_VALUE);
        t18.setNext$runtime_release(state.getFirstStateRecord());
        state.prependStateRecord(t18);
        return t18;
    }

    public static final <T extends StateRecord> T newWritableRecord(T t16, StateObject state, Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(t16, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        T t17 = (T) newOverwritableRecord(t16, state);
        t17.assign(t16);
        t17.setSnapshotId$runtime_release(snapshot.getId());
        return t17;
    }

    public static final void notifyWrite(Snapshot snapshot, StateObject state) {
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        Intrinsics.checkNotNullParameter(state, "state");
        Function1<Object, Unit> writeObserver$runtime_release = snapshot.getWriteObserver$runtime_release();
        if (writeObserver$runtime_release != null) {
            writeObserver$runtime_release.invoke(state);
        }
    }

    public static final Map<StateRecord, StateRecord> optimisticMerges(MutableSnapshot mutableSnapshot, MutableSnapshot mutableSnapshot2, SnapshotIdSet snapshotIdSet) {
        StateRecord readable;
        Set<StateObject> modified$runtime_release = mutableSnapshot2.getModified$runtime_release();
        int id5 = mutableSnapshot.getId();
        if (modified$runtime_release == null) {
            return null;
        }
        SnapshotIdSet or5 = mutableSnapshot2.getInvalid().set(mutableSnapshot2.getId()).or(mutableSnapshot2.getPreviousIds$runtime_release());
        HashMap hashMap = null;
        for (StateObject stateObject : modified$runtime_release) {
            StateRecord firstStateRecord = stateObject.getFirstStateRecord();
            StateRecord readable2 = readable(firstStateRecord, id5, snapshotIdSet);
            if (readable2 != null && (readable = readable(firstStateRecord, id5, or5)) != null && !Intrinsics.areEqual(readable2, readable)) {
                StateRecord readable3 = readable(firstStateRecord, mutableSnapshot2.getId(), mutableSnapshot2.getInvalid());
                if (readable3 != null) {
                    StateRecord mergeRecords = stateObject.mergeRecords(readable, readable2, readable3);
                    if (mergeRecords == null) {
                        return null;
                    }
                    if (hashMap == null) {
                        hashMap = new HashMap();
                    }
                    hashMap.put(readable2, mergeRecords);
                    hashMap = hashMap;
                } else {
                    readError();
                    throw new KotlinNothingValueException();
                }
            }
        }
        return hashMap;
    }

    public static final <T extends StateRecord, R> R overwritable(T t16, StateObject state, T candidate, Function1<? super T, ? extends R> block) {
        Snapshot current;
        R invoke;
        Intrinsics.checkNotNullParameter(t16, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(candidate, "candidate");
        Intrinsics.checkNotNullParameter(block, "block");
        getSnapshotInitializer();
        synchronized (getLock()) {
            try {
                current = Snapshot.INSTANCE.getCurrent();
                invoke = block.invoke(overwritableRecord(t16, state, current, candidate));
                InlineMarker.finallyStart(1);
            } catch (Throwable th5) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th5;
            }
        }
        InlineMarker.finallyEnd(1);
        notifyWrite(current, state);
        return invoke;
    }

    public static final <T extends StateRecord> T overwritableRecord(T t16, StateObject state, Snapshot snapshot, T candidate) {
        Intrinsics.checkNotNullParameter(t16, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        Intrinsics.checkNotNullParameter(candidate, "candidate");
        if (snapshot.getReadOnly()) {
            snapshot.mo35recordModified$runtime_release(state);
        }
        int id5 = snapshot.getId();
        if (candidate.getSnapshotId() == id5) {
            return candidate;
        }
        T t17 = (T) newOverwritableRecord(t16, state);
        t17.setSnapshotId$runtime_release(id5);
        snapshot.mo35recordModified$runtime_release(state);
        return t17;
    }

    public static final Void readError() {
        throw new IllegalStateException("Reading a state that was created after the snapshot was taken or in a snapshot that has not yet been applied".toString());
    }

    public static final <T extends StateRecord> T readable(T t16, int i3, SnapshotIdSet snapshotIdSet) {
        T t17 = null;
        while (t16 != null) {
            if (valid(t16, i3, snapshotIdSet) && (t17 == null || t17.getSnapshotId() < t16.getSnapshotId())) {
                t17 = t16;
            }
            t16 = (T) t16.getNext();
        }
        if (t17 != null) {
            return t17;
        }
        return null;
    }

    public static final void releasePinningLocked(int i3) {
        pinningTable.remove(i3);
    }

    public static final Void reportReadonlySnapshotWrite() {
        throw new IllegalStateException("Cannot modify a state object in a read-only snapshot".toString());
    }

    public static final <T> T sync(Function0<? extends T> block) {
        T invoke;
        Intrinsics.checkNotNullParameter(block, "block");
        synchronized (getLock()) {
            try {
                invoke = block.invoke();
                InlineMarker.finallyStart(1);
            } catch (Throwable th5) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th5;
            }
        }
        InlineMarker.finallyEnd(1);
        return invoke;
    }

    public static final <T> T takeNewGlobalSnapshot(Snapshot snapshot, Function1<? super SnapshotIdSet, ? extends T> function1) {
        T invoke = function1.invoke(openSnapshots.clear(snapshot.getId()));
        synchronized (getLock()) {
            int i3 = nextSnapshotId;
            nextSnapshotId = i3 + 1;
            openSnapshots = openSnapshots.clear(snapshot.getId());
            currentGlobalSnapshot.set(new GlobalSnapshot(i3, openSnapshots));
            snapshot.dispose();
            openSnapshots = openSnapshots.set(i3);
            Unit unit = Unit.INSTANCE;
        }
        return invoke;
    }

    public static final <T extends Snapshot> T takeNewSnapshot(final Function1<? super SnapshotIdSet, ? extends T> function1) {
        return (T) advanceGlobalSnapshot(new Function1<SnapshotIdSet, T>() { // from class: androidx.compose.runtime.snapshots.SnapshotKt$takeNewSnapshot$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            /* JADX WARN: Incorrect return type in method signature: (Landroidx/compose/runtime/snapshots/SnapshotIdSet;)TT; */
            @Override // kotlin.jvm.functions.Function1
            public final Snapshot invoke(SnapshotIdSet invalid) {
                SnapshotIdSet snapshotIdSet;
                Intrinsics.checkNotNullParameter(invalid, "invalid");
                Snapshot snapshot = (Snapshot) function1.invoke(invalid);
                synchronized (SnapshotKt.getLock()) {
                    snapshotIdSet = SnapshotKt.openSnapshots;
                    SnapshotKt.openSnapshots = snapshotIdSet.set(snapshot.getId());
                    Unit unit = Unit.INSTANCE;
                }
                return snapshot;
            }
        });
    }

    public static final int trackPinning(int i3, SnapshotIdSet invalid) {
        int add;
        Intrinsics.checkNotNullParameter(invalid, "invalid");
        int lowest = invalid.lowest(i3);
        synchronized (getLock()) {
            add = pinningTable.add(lowest);
        }
        return add;
    }

    private static final StateRecord used(StateObject stateObject) {
        int lowestOrDefault = pinningTable.lowestOrDefault(nextSnapshotId) - 1;
        SnapshotIdSet empty = SnapshotIdSet.INSTANCE.getEMPTY();
        StateRecord stateRecord = null;
        for (StateRecord firstStateRecord = stateObject.getFirstStateRecord(); firstStateRecord != null; firstStateRecord = firstStateRecord.getNext()) {
            if (firstStateRecord.getSnapshotId() == 0) {
                return firstStateRecord;
            }
            if (valid(firstStateRecord, lowestOrDefault, empty)) {
                if (stateRecord != null) {
                    return firstStateRecord.getSnapshotId() < stateRecord.getSnapshotId() ? firstStateRecord : stateRecord;
                }
                stateRecord = firstStateRecord;
            }
        }
        return null;
    }

    private static final boolean valid(int i3, int i16, SnapshotIdSet snapshotIdSet) {
        return (i16 == 0 || i16 > i3 || snapshotIdSet.get(i16)) ? false : true;
    }

    public static final void validateOpen(Snapshot snapshot) {
        if (!openSnapshots.get(snapshot.getId())) {
            throw new IllegalStateException("Snapshot is not open".toString());
        }
    }

    public static final <T extends StateRecord, R> R withCurrent(T t16, Function1<? super T, ? extends R> block) {
        Intrinsics.checkNotNullParameter(t16, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        return block.invoke(current(t16, Snapshot.INSTANCE.getCurrent()));
    }

    public static final <T extends StateRecord, R> R writable(T t16, StateObject state, Function1<? super T, ? extends R> block) {
        Snapshot current;
        R invoke;
        Intrinsics.checkNotNullParameter(t16, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(block, "block");
        getSnapshotInitializer();
        synchronized (getLock()) {
            try {
                current = Snapshot.INSTANCE.getCurrent();
                invoke = block.invoke(writableRecord(t16, state, current));
                InlineMarker.finallyStart(1);
            } catch (Throwable th5) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th5;
            }
        }
        InlineMarker.finallyEnd(1);
        notifyWrite(current, state);
        return invoke;
    }

    public static final <T extends StateRecord> T writableRecord(T t16, StateObject state, Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(t16, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        if (snapshot.getReadOnly()) {
            snapshot.mo35recordModified$runtime_release(state);
        }
        T t17 = (T) readable(t16, snapshot.getId(), snapshot.getInvalid());
        if (t17 != null) {
            if (t17.getSnapshotId() == snapshot.getId()) {
                return t17;
            }
            T t18 = (T) newWritableRecord(t17, state, snapshot);
            snapshot.mo35recordModified$runtime_release(state);
            return t18;
        }
        readError();
        throw new KotlinNothingValueException();
    }

    private static final boolean valid(StateRecord stateRecord, int i3, SnapshotIdSet snapshotIdSet) {
        return valid(i3, stateRecord.getSnapshotId(), snapshotIdSet);
    }

    public static final <T extends StateRecord> T readable(T t16, StateObject state) {
        Intrinsics.checkNotNullParameter(t16, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        return (T) readable(t16, state, currentSnapshot());
    }

    public static final Function1<Object, Unit> mergedWriteObserver(final Function1<Object, Unit> function1, final Function1<Object, Unit> function12) {
        if (function1 == null || function12 == null || Intrinsics.areEqual(function1, function12)) {
            return function1 == null ? function12 : function1;
        }
        return new Function1<Object, Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotKt$mergedWriteObserver$1
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
            public final void invoke2(Object state) {
                Intrinsics.checkNotNullParameter(state, "state");
                function1.invoke(state);
                function12.invoke(state);
            }
        };
    }

    public static final <T extends StateRecord> T readable(T t16, StateObject state, Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(t16, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        Function1<Object, Unit> readObserver$runtime_release = snapshot.getReadObserver$runtime_release();
        if (readObserver$runtime_release != null) {
            readObserver$runtime_release.invoke(state);
        }
        T t17 = (T) readable(t16, snapshot.getId(), snapshot.getInvalid());
        if (t17 != null) {
            return t17;
        }
        readError();
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ Function1 mergedReadObserver$default(Function1 function1, Function1 function12, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = true;
        }
        return mergedReadObserver(function1, function12, z16);
    }

    public static final <T extends StateRecord, R> R writable(T t16, StateObject state, Snapshot snapshot, Function1<? super T, ? extends R> block) {
        R invoke;
        Intrinsics.checkNotNullParameter(t16, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        Intrinsics.checkNotNullParameter(block, "block");
        synchronized (getLock()) {
            try {
                invoke = block.invoke(writableRecord(t16, state, snapshot));
                InlineMarker.finallyStart(1);
            } catch (Throwable th5) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th5;
            }
        }
        InlineMarker.finallyEnd(1);
        notifyWrite(snapshot, state);
        return invoke;
    }

    public static final Function1<Object, Unit> mergedReadObserver(final Function1<Object, Unit> function1, final Function1<Object, Unit> function12, boolean z16) {
        if (!z16) {
            function12 = null;
        }
        if (function1 == null || function12 == null || Intrinsics.areEqual(function1, function12)) {
            return function1 == null ? function12 : function1;
        }
        return new Function1<Object, Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotKt$mergedReadObserver$1
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
            public final void invoke2(Object state) {
                Intrinsics.checkNotNullParameter(state, "state");
                function1.invoke(state);
                function12.invoke(state);
            }
        };
    }

    public static /* synthetic */ Snapshot createTransparentSnapshotWithNoParentReadObserver$default(Snapshot snapshot, Function1 function1, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            function1 = null;
        }
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        return createTransparentSnapshotWithNoParentReadObserver(snapshot, function1, z16);
    }

    public static final void advanceGlobalSnapshot() {
        advanceGlobalSnapshot(new Function1<SnapshotIdSet, Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotKt$advanceGlobalSnapshot$2
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SnapshotIdSet it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SnapshotIdSet snapshotIdSet) {
                invoke2(snapshotIdSet);
                return Unit.INSTANCE;
            }
        });
    }

    public static /* synthetic */ void getLock$annotations() {
    }

    public static /* synthetic */ void getSnapshotInitializer$annotations() {
    }
}
