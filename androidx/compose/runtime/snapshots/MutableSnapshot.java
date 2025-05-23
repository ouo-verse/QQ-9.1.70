package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.snapshots.SnapshotApplyResult;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.upload.network.session.cache.SessionDbHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0015\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b \b\u0017\u0018\u00002\u00020\u0001BC\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\u000bJ\b\u0010.\u001a\u00020\tH\u0002J\r\u0010/\u001a\u00020\tH\u0000\u00a2\u0006\u0002\b0J'\u0010/\u001a\u0002H1\"\u0004\b\u0000\u001012\f\u00102\u001a\b\u0012\u0004\u0012\u0002H103H\u0080\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b0\u00104J\b\u00105\u001a\u000206H\u0016J\r\u00107\u001a\u00020\tH\u0010\u00a2\u0006\u0002\b8J\b\u00109\u001a\u00020\tH\u0016J\b\u0010:\u001a\u00020\rH\u0016J3\u0010;\u001a\u0002062\u0006\u0010<\u001a\u00020\u00032\u0014\u0010=\u001a\u0010\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020?\u0018\u00010>2\u0006\u0010@\u001a\u00020\u0005H\u0000\u00a2\u0006\u0002\bAJ\u0015\u0010B\u001a\u00020\t2\u0006\u0010C\u001a\u00020\u0001H\u0010\u00a2\u0006\u0002\bDJ\u0015\u0010E\u001a\u00020\t2\u0006\u0010C\u001a\u00020\u0001H\u0010\u00a2\u0006\u0002\bFJ\r\u0010G\u001a\u00020\tH\u0010\u00a2\u0006\u0002\bHJ\u0015\u0010I\u001a\u00020\t2\u0006\u0010J\u001a\u00020\u0014H\u0010\u00a2\u0006\u0002\bKJ\u0015\u0010L\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u00a2\u0006\u0002\bMJ\u0015\u0010N\u001a\u00020\t2\u0006\u0010,\u001a\u00020\u0005H\u0000\u00a2\u0006\u0002\bOJ\u0015\u0010P\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u00a2\u0006\u0002\bQJ\u0015\u0010R\u001a\u00020\t2\u0006\u0010S\u001a\u00020 H\u0000\u00a2\u0006\u0002\bTJ\r\u0010U\u001a\u00020\tH\u0010\u00a2\u0006\u0002\bVJ\r\u0010W\u001a\u00020\tH\u0000\u00a2\u0006\u0002\bXJ8\u0010Y\u001a\u00020\u00002\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u00072\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H\u0016J\u001e\u0010Z\u001a\u00020\u00012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H\u0016J\r\u0010[\u001a\u00020\tH\u0000\u00a2\u0006\u0002\b\\J\r\u0010]\u001a\u00020\tH\u0000\u00a2\u0006\u0002\b^R\u001a\u0010\f\u001a\u00020\rX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R4\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00132\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013@VX\u0090\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0005X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X\u0090\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020\r8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b(\u0010\u000fR\u0014\u0010)\u001a\u00020\u00018VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b*\u0010+R\u000e\u0010,\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\"\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X\u0090\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010&\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006_"}, d2 = {"Landroidx/compose/runtime/snapshots/MutableSnapshot;", "Landroidx/compose/runtime/snapshots/Snapshot;", "id", "", HippyReporter.RemoveEngineReason.INVALID, "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "readObserver", "Lkotlin/Function1;", "", "", "writeObserver", "(ILandroidx/compose/runtime/snapshots/SnapshotIdSet;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "applied", "", "getApplied$runtime_release", "()Z", "setApplied$runtime_release", "(Z)V", "<set-?>", "", "Landroidx/compose/runtime/snapshots/StateObject;", SessionDbHelper.MODIFIED_DATE, "getModified$runtime_release", "()Ljava/util/Set;", "setModified", "(Ljava/util/Set;)V", "previousIds", "getPreviousIds$runtime_release", "()Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "setPreviousIds$runtime_release", "(Landroidx/compose/runtime/snapshots/SnapshotIdSet;)V", "previousPinnedSnapshots", "", "getPreviousPinnedSnapshots$runtime_release", "()[I", "setPreviousPinnedSnapshots$runtime_release", "([I)V", "getReadObserver$runtime_release", "()Lkotlin/jvm/functions/Function1;", "readOnly", "getReadOnly", "root", "getRoot", "()Landroidx/compose/runtime/snapshots/Snapshot;", "snapshots", "getWriteObserver$runtime_release", "abandon", "advance", "advance$runtime_release", "T", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "apply", "Landroidx/compose/runtime/snapshots/SnapshotApplyResult;", "closeLocked", "closeLocked$runtime_release", "dispose", "hasPendingChanges", "innerApplyLocked", "snapshotId", "optimisticMerges", "", "Landroidx/compose/runtime/snapshots/StateRecord;", "invalidSnapshots", "innerApplyLocked$runtime_release", "nestedActivated", "snapshot", "nestedActivated$runtime_release", "nestedDeactivated", "nestedDeactivated$runtime_release", "notifyObjectsInitialized", "notifyObjectsInitialized$runtime_release", "recordModified", "state", "recordModified$runtime_release", "recordPrevious", "recordPrevious$runtime_release", "recordPreviousList", "recordPreviousList$runtime_release", "recordPreviousPinnedSnapshot", "recordPreviousPinnedSnapshot$runtime_release", "recordPreviousPinnedSnapshots", "handles", "recordPreviousPinnedSnapshots$runtime_release", "releasePinnedSnapshotsForCloseLocked", "releasePinnedSnapshotsForCloseLocked$runtime_release", "releasePreviouslyPinnedSnapshotsLocked", "releasePreviouslyPinnedSnapshotsLocked$runtime_release", "takeNestedMutableSnapshot", "takeNestedSnapshot", "validateNotApplied", "validateNotApplied$runtime_release", "validateNotAppliedOrPinned", "validateNotAppliedOrPinned$runtime_release", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes39.dex */
public class MutableSnapshot extends Snapshot {
    public static final int $stable = 8;
    private boolean applied;
    private Set<StateObject> modified;
    private SnapshotIdSet previousIds;
    private int[] previousPinnedSnapshots;
    private final Function1<Object, Unit> readObserver;
    private int snapshots;
    private final Function1<Object, Unit> writeObserver;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MutableSnapshot(int i3, SnapshotIdSet invalid, Function1<Object, Unit> function1, Function1<Object, Unit> function12) {
        super(i3, invalid, null);
        Intrinsics.checkNotNullParameter(invalid, "invalid");
        this.readObserver = function1;
        this.writeObserver = function12;
        this.previousIds = SnapshotIdSet.INSTANCE.getEMPTY();
        this.previousPinnedSnapshots = new int[0];
        this.snapshots = 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x003b, code lost:
    
        if (r3 != false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void abandon() {
        boolean contains;
        Set<StateObject> modified$runtime_release = getModified$runtime_release();
        if (modified$runtime_release != null) {
            validateNotApplied$runtime_release();
            setModified(null);
            int id5 = getId();
            Iterator<StateObject> it = modified$runtime_release.iterator();
            while (it.hasNext()) {
                for (StateRecord firstStateRecord = it.next().getFirstStateRecord(); firstStateRecord != null; firstStateRecord = firstStateRecord.getNext()) {
                    if (firstStateRecord.getSnapshotId() != id5) {
                        contains = CollectionsKt___CollectionsKt.contains(this.previousIds, Integer.valueOf(firstStateRecord.getSnapshotId()));
                    }
                    firstStateRecord.setSnapshotId$runtime_release(0);
                }
            }
        }
        closeAndReleasePinning$runtime_release();
    }

    public final <T> T advance$runtime_release(Function0<? extends T> block) {
        int i3;
        SnapshotIdSet snapshotIdSet;
        Intrinsics.checkNotNullParameter(block, "block");
        recordPrevious$runtime_release(getId());
        T invoke = block.invoke();
        if (!getApplied() && !getDisposed()) {
            int id5 = getId();
            synchronized (SnapshotKt.getLock()) {
                try {
                    i3 = SnapshotKt.nextSnapshotId;
                    SnapshotKt.nextSnapshotId = i3 + 1;
                    setId$runtime_release(i3);
                    snapshotIdSet = SnapshotKt.openSnapshots;
                    SnapshotKt.openSnapshots = snapshotIdSet.set(getId());
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                } catch (Throwable th5) {
                    InlineMarker.finallyStart(1);
                    InlineMarker.finallyEnd(1);
                    throw th5;
                }
            }
            InlineMarker.finallyEnd(1);
            setInvalid$runtime_release(SnapshotKt.addRange(getInvalid(), id5 + 1, getId()));
        }
        return invoke;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00f4 A[LOOP:0: B:24:0x00f2->B:25:0x00f4, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x010f A[LOOP:1: B:31:0x010d->B:32:0x010f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0120 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SnapshotApplyResult apply() {
        Map<StateRecord, ? extends StateRecord> map;
        AtomicReference atomicReference;
        Function1 function1;
        List emptyList;
        Pair pair;
        List list;
        List mutableList;
        List list2;
        Set set;
        int i3;
        int size;
        int size2;
        int i16;
        AtomicReference atomicReference2;
        int i17;
        SnapshotIdSet snapshotIdSet;
        Function1 function12;
        List list3;
        List mutableList2;
        AtomicReference atomicReference3;
        SnapshotIdSet snapshotIdSet2;
        AtomicReference atomicReference4;
        Set<StateObject> modified$runtime_release = getModified$runtime_release();
        if (modified$runtime_release != null) {
            atomicReference3 = SnapshotKt.currentGlobalSnapshot;
            Object obj = atomicReference3.get();
            Intrinsics.checkNotNullExpressionValue(obj, "currentGlobalSnapshot.get()");
            snapshotIdSet2 = SnapshotKt.openSnapshots;
            atomicReference4 = SnapshotKt.currentGlobalSnapshot;
            map = SnapshotKt.optimisticMerges((MutableSnapshot) obj, this, snapshotIdSet2.clear(((GlobalSnapshot) atomicReference4.get()).getId()));
        } else {
            map = null;
        }
        synchronized (SnapshotKt.getLock()) {
            SnapshotKt.validateOpen(this);
            if (modified$runtime_release != null && modified$runtime_release.size() != 0) {
                atomicReference2 = SnapshotKt.currentGlobalSnapshot;
                GlobalSnapshot previousGlobalSnapshot = (GlobalSnapshot) atomicReference2.get();
                i17 = SnapshotKt.nextSnapshotId;
                snapshotIdSet = SnapshotKt.openSnapshots;
                SnapshotApplyResult innerApplyLocked$runtime_release = innerApplyLocked$runtime_release(i17, map, snapshotIdSet.clear(previousGlobalSnapshot.getId()));
                if (!Intrinsics.areEqual(innerApplyLocked$runtime_release, SnapshotApplyResult.Success.INSTANCE)) {
                    return innerApplyLocked$runtime_release;
                }
                closeLocked$runtime_release();
                Intrinsics.checkNotNullExpressionValue(previousGlobalSnapshot, "previousGlobalSnapshot");
                function12 = SnapshotKt.emptyLambda;
                SnapshotKt.takeNewGlobalSnapshot(previousGlobalSnapshot, function12);
                Set<StateObject> modified$runtime_release2 = previousGlobalSnapshot.getModified$runtime_release();
                setModified(null);
                previousGlobalSnapshot.setModified(null);
                list3 = SnapshotKt.applyObservers;
                mutableList2 = CollectionsKt___CollectionsKt.toMutableList((Collection) list3);
                pair = TuplesKt.to(mutableList2, modified$runtime_release2);
                list2 = (List) pair.component1();
                set = (Set) pair.component2();
                this.applied = true;
                if (set != null && (!set.isEmpty())) {
                    size2 = list2.size();
                    for (i16 = 0; i16 < size2; i16++) {
                        ((Function2) list2.get(i16)).invoke(set, this);
                    }
                }
                if (modified$runtime_release != null && (!modified$runtime_release.isEmpty())) {
                    size = list2.size();
                    for (i3 = 0; i3 < size; i3++) {
                        ((Function2) list2.get(i3)).invoke(modified$runtime_release, this);
                    }
                }
                synchronized (SnapshotKt.getLock()) {
                    releasePinnedSnapshotsForCloseLocked$runtime_release();
                    Unit unit = Unit.INSTANCE;
                }
                return SnapshotApplyResult.Success.INSTANCE;
            }
            closeLocked$runtime_release();
            atomicReference = SnapshotKt.currentGlobalSnapshot;
            GlobalSnapshot previousGlobalSnapshot2 = (GlobalSnapshot) atomicReference.get();
            Intrinsics.checkNotNullExpressionValue(previousGlobalSnapshot2, "previousGlobalSnapshot");
            function1 = SnapshotKt.emptyLambda;
            SnapshotKt.takeNewGlobalSnapshot(previousGlobalSnapshot2, function1);
            Set<StateObject> modified$runtime_release3 = previousGlobalSnapshot2.getModified$runtime_release();
            if (modified$runtime_release3 == null || !(!modified$runtime_release3.isEmpty())) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                pair = TuplesKt.to(emptyList, null);
            } else {
                list = SnapshotKt.applyObservers;
                mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) list);
                pair = TuplesKt.to(mutableList, modified$runtime_release3);
            }
            list2 = (List) pair.component1();
            set = (Set) pair.component2();
            this.applied = true;
            if (set != null) {
                size2 = list2.size();
                while (i16 < size2) {
                }
            }
            if (modified$runtime_release != null) {
                size = list2.size();
                while (i3 < size) {
                }
            }
            synchronized (SnapshotKt.getLock()) {
            }
        }
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void closeLocked$runtime_release() {
        SnapshotIdSet snapshotIdSet;
        snapshotIdSet = SnapshotKt.openSnapshots;
        SnapshotKt.openSnapshots = snapshotIdSet.clear(getId()).andNot(this.previousIds);
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void dispose() {
        if (getDisposed()) {
            return;
        }
        super.dispose();
        mo34nestedDeactivated$runtime_release(this);
    }

    /* renamed from: getApplied$runtime_release, reason: from getter */
    public final boolean getApplied() {
        return this.applied;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public Set<StateObject> getModified$runtime_release() {
        return this.modified;
    }

    /* renamed from: getPreviousIds$runtime_release, reason: from getter */
    public final SnapshotIdSet getPreviousIds() {
        return this.previousIds;
    }

    /* renamed from: getPreviousPinnedSnapshots$runtime_release, reason: from getter */
    public final int[] getPreviousPinnedSnapshots() {
        return this.previousPinnedSnapshots;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public Function1<Object, Unit> getReadObserver$runtime_release() {
        return this.readObserver;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public boolean getReadOnly() {
        return false;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public Function1<Object, Unit> getWriteObserver$runtime_release() {
        return this.writeObserver;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public boolean hasPendingChanges() {
        Set<StateObject> modified$runtime_release = getModified$runtime_release();
        return modified$runtime_release != null && (modified$runtime_release.isEmpty() ^ true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x003c, code lost:
    
        r8 = androidx.compose.runtime.snapshots.SnapshotKt.readable(r6, getId(), r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final SnapshotApplyResult innerApplyLocked$runtime_release(int snapshotId, Map<StateRecord, ? extends StateRecord> optimisticMerges, SnapshotIdSet invalidSnapshots) {
        StateRecord readable;
        StateRecord readable2;
        StateRecord readable3;
        StateRecord mergeRecords;
        Pair pair;
        Intrinsics.checkNotNullParameter(invalidSnapshots, "invalidSnapshots");
        SnapshotIdSet or5 = getInvalid().set(getId()).or(this.previousIds);
        Set<StateObject> modified$runtime_release = getModified$runtime_release();
        Intrinsics.checkNotNull(modified$runtime_release);
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        for (StateObject stateObject : modified$runtime_release) {
            StateRecord firstStateRecord = stateObject.getFirstStateRecord();
            readable = SnapshotKt.readable(firstStateRecord, snapshotId, invalidSnapshots);
            if (readable != null && readable2 != null && !Intrinsics.areEqual(readable, readable2)) {
                readable3 = SnapshotKt.readable(firstStateRecord, getId(), getInvalid());
                if (readable3 == null) {
                    SnapshotKt.readError();
                    throw new KotlinNothingValueException();
                }
                if (optimisticMerges == null || (mergeRecords = optimisticMerges.get(readable)) == null) {
                    mergeRecords = stateObject.mergeRecords(readable2, readable, readable3);
                }
                if (mergeRecords == null) {
                    return new SnapshotApplyResult.Failure(this);
                }
                if (!Intrinsics.areEqual(mergeRecords, readable3)) {
                    if (Intrinsics.areEqual(mergeRecords, readable)) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(TuplesKt.to(stateObject, readable.create()));
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                        }
                        arrayList2.add(stateObject);
                    } else {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        if (!Intrinsics.areEqual(mergeRecords, readable2)) {
                            pair = TuplesKt.to(stateObject, mergeRecords);
                        } else {
                            pair = TuplesKt.to(stateObject, readable2.create());
                        }
                        arrayList.add(pair);
                    }
                }
            }
        }
        if (arrayList != null) {
            advance$runtime_release();
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                Pair pair2 = (Pair) arrayList.get(i3);
                StateObject stateObject2 = (StateObject) pair2.component1();
                StateRecord stateRecord = (StateRecord) pair2.component2();
                stateRecord.setSnapshotId$runtime_release(getId());
                synchronized (SnapshotKt.getLock()) {
                    stateRecord.setNext$runtime_release(stateObject2.getFirstStateRecord());
                    stateObject2.prependStateRecord(stateRecord);
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
        if (arrayList2 != null) {
            modified$runtime_release.removeAll(arrayList2);
        }
        return SnapshotApplyResult.Success.INSTANCE;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* renamed from: nestedActivated$runtime_release */
    public void mo33nestedActivated$runtime_release(Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        this.snapshots++;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* renamed from: nestedDeactivated$runtime_release */
    public void mo34nestedDeactivated$runtime_release(Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        int i3 = this.snapshots;
        if (i3 > 0) {
            int i16 = i3 - 1;
            this.snapshots = i16;
            if (i16 != 0 || this.applied) {
                return;
            }
            abandon();
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void notifyObjectsInitialized$runtime_release() {
        if (this.applied || getDisposed()) {
            return;
        }
        advance$runtime_release();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* renamed from: recordModified$runtime_release */
    public void mo35recordModified$runtime_release(StateObject state) {
        Intrinsics.checkNotNullParameter(state, "state");
        Set<StateObject> modified$runtime_release = getModified$runtime_release();
        if (modified$runtime_release == null) {
            modified$runtime_release = new HashSet<>();
            setModified(modified$runtime_release);
        }
        modified$runtime_release.add(state);
    }

    public final void recordPrevious$runtime_release(int id5) {
        synchronized (SnapshotKt.getLock()) {
            this.previousIds = this.previousIds.set(id5);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void recordPreviousList$runtime_release(SnapshotIdSet snapshots) {
        Intrinsics.checkNotNullParameter(snapshots, "snapshots");
        synchronized (SnapshotKt.getLock()) {
            this.previousIds = this.previousIds.or(snapshots);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void recordPreviousPinnedSnapshots$runtime_release(int[] handles) {
        int[] plus;
        Intrinsics.checkNotNullParameter(handles, "handles");
        if (handles.length == 0) {
            return;
        }
        int[] iArr = this.previousPinnedSnapshots;
        if (!(iArr.length == 0)) {
            plus = ArraysKt___ArraysJvmKt.plus(iArr, handles);
            this.previousPinnedSnapshots = plus;
        } else {
            this.previousPinnedSnapshots = handles;
        }
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void releasePinnedSnapshotsForCloseLocked$runtime_release() {
        releasePreviouslyPinnedSnapshotsLocked$runtime_release();
        super.releasePinnedSnapshotsForCloseLocked$runtime_release();
    }

    public final void releasePreviouslyPinnedSnapshotsLocked$runtime_release() {
        int length = this.previousPinnedSnapshots.length;
        for (int i3 = 0; i3 < length; i3++) {
            SnapshotKt.releasePinningLocked(this.previousPinnedSnapshots[i3]);
        }
    }

    public final void setApplied$runtime_release(boolean z16) {
        this.applied = z16;
    }

    public void setModified(Set<StateObject> set) {
        this.modified = set;
    }

    public final void setPreviousIds$runtime_release(SnapshotIdSet snapshotIdSet) {
        Intrinsics.checkNotNullParameter(snapshotIdSet, "<set-?>");
        this.previousIds = snapshotIdSet;
    }

    public final void setPreviousPinnedSnapshots$runtime_release(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<set-?>");
        this.previousPinnedSnapshots = iArr;
    }

    public MutableSnapshot takeNestedMutableSnapshot(Function1<Object, Unit> readObserver, Function1<Object, Unit> writeObserver) {
        int i3;
        SnapshotIdSet snapshotIdSet;
        NestedMutableSnapshot nestedMutableSnapshot;
        Function1 mergedWriteObserver;
        int i16;
        SnapshotIdSet snapshotIdSet2;
        validateNotDisposed$runtime_release();
        validateNotAppliedOrPinned$runtime_release();
        recordPrevious$runtime_release(getId());
        synchronized (SnapshotKt.getLock()) {
            i3 = SnapshotKt.nextSnapshotId;
            SnapshotKt.nextSnapshotId = i3 + 1;
            snapshotIdSet = SnapshotKt.openSnapshots;
            SnapshotKt.openSnapshots = snapshotIdSet.set(i3);
            SnapshotIdSet invalid = getInvalid();
            setInvalid$runtime_release(invalid.set(i3));
            SnapshotIdSet addRange = SnapshotKt.addRange(invalid, getId() + 1, i3);
            Function1 mergedReadObserver$default = SnapshotKt.mergedReadObserver$default(readObserver, getReadObserver$runtime_release(), false, 4, null);
            mergedWriteObserver = SnapshotKt.mergedWriteObserver(writeObserver, getWriteObserver$runtime_release());
            nestedMutableSnapshot = new NestedMutableSnapshot(i3, addRange, mergedReadObserver$default, mergedWriteObserver, this);
        }
        if (!getApplied() && !getDisposed()) {
            int id5 = getId();
            synchronized (SnapshotKt.getLock()) {
                i16 = SnapshotKt.nextSnapshotId;
                SnapshotKt.nextSnapshotId = i16 + 1;
                setId$runtime_release(i16);
                snapshotIdSet2 = SnapshotKt.openSnapshots;
                SnapshotKt.openSnapshots = snapshotIdSet2.set(getId());
                Unit unit = Unit.INSTANCE;
            }
            setInvalid$runtime_release(SnapshotKt.addRange(getInvalid(), id5 + 1, getId()));
        }
        return nestedMutableSnapshot;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public Snapshot takeNestedSnapshot(Function1<Object, Unit> readObserver) {
        int i3;
        SnapshotIdSet snapshotIdSet;
        NestedReadonlySnapshot nestedReadonlySnapshot;
        int i16;
        SnapshotIdSet snapshotIdSet2;
        validateNotDisposed$runtime_release();
        validateNotAppliedOrPinned$runtime_release();
        int id5 = getId();
        recordPrevious$runtime_release(getId());
        synchronized (SnapshotKt.getLock()) {
            i3 = SnapshotKt.nextSnapshotId;
            SnapshotKt.nextSnapshotId = i3 + 1;
            snapshotIdSet = SnapshotKt.openSnapshots;
            SnapshotKt.openSnapshots = snapshotIdSet.set(i3);
            nestedReadonlySnapshot = new NestedReadonlySnapshot(i3, SnapshotKt.addRange(getInvalid(), id5 + 1, i3), readObserver, this);
        }
        if (!getApplied() && !getDisposed()) {
            int id6 = getId();
            synchronized (SnapshotKt.getLock()) {
                i16 = SnapshotKt.nextSnapshotId;
                SnapshotKt.nextSnapshotId = i16 + 1;
                setId$runtime_release(i16);
                snapshotIdSet2 = SnapshotKt.openSnapshots;
                SnapshotKt.openSnapshots = snapshotIdSet2.set(getId());
                Unit unit = Unit.INSTANCE;
            }
            setInvalid$runtime_release(SnapshotKt.addRange(getInvalid(), id6 + 1, getId()));
        }
        return nestedReadonlySnapshot;
    }

    public final void validateNotApplied$runtime_release() {
        if (!(!this.applied)) {
            throw new IllegalStateException("Unsupported operation on a snapshot that has been applied".toString());
        }
    }

    public final void validateNotAppliedOrPinned$runtime_release() {
        boolean z16 = true;
        if (this.applied) {
            if (!(((Snapshot) this).pinningTrackingHandle >= 0)) {
                z16 = false;
            }
        }
        if (!z16) {
            throw new IllegalStateException("Unsupported operation on a disposed or applied snapshot".toString());
        }
    }

    public final void recordPreviousPinnedSnapshot$runtime_release(int id5) {
        int[] plus;
        if (id5 >= 0) {
            plus = ArraysKt___ArraysJvmKt.plus(this.previousPinnedSnapshots, id5);
            this.previousPinnedSnapshots = plus;
        }
    }

    public final void advance$runtime_release() {
        int i3;
        SnapshotIdSet snapshotIdSet;
        recordPrevious$runtime_release(getId());
        Unit unit = Unit.INSTANCE;
        if (getApplied() || getDisposed()) {
            return;
        }
        int id5 = getId();
        synchronized (SnapshotKt.getLock()) {
            i3 = SnapshotKt.nextSnapshotId;
            SnapshotKt.nextSnapshotId = i3 + 1;
            setId$runtime_release(i3);
            snapshotIdSet = SnapshotKt.openSnapshots;
            SnapshotKt.openSnapshots = snapshotIdSet.set(getId());
        }
        setInvalid$runtime_release(SnapshotKt.addRange(getInvalid(), id5 + 1, getId()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MutableSnapshot takeNestedMutableSnapshot$default(MutableSnapshot mutableSnapshot, Function1 function1, Function1 function12, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                function1 = null;
            }
            if ((i3 & 2) != 0) {
                function12 = null;
            }
            return mutableSnapshot.takeNestedMutableSnapshot(function1, function12);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: takeNestedMutableSnapshot");
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public Snapshot getRoot() {
        return this;
    }
}
