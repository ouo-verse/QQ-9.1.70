package androidx.compose.runtime.snapshots;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.upload.network.session.cache.SessionDbHelper;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001BK\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0002\u0010\u000bJ\b\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020\u0006H\u0016J\b\u0010,\u001a\u00020\tH\u0016J\u0015\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0010\u00a2\u0006\u0002\b1J\u0015\u00102\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0010\u00a2\u0006\u0002\b3J\r\u00104\u001a\u00020\u0006H\u0010\u00a2\u0006\u0002\b5J\u0015\u00106\u001a\u00020\u00062\u0006\u00107\u001a\u00020\u001dH\u0010\u00a2\u0006\u0002\b8J4\u00109\u001a\u00020\u00012\u0014\u0010:\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00042\u0014\u0010;\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004H\u0016J\u001e\u0010<\u001a\u0002002\u0014\u0010:\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004H\u0016R\u0014\u0010\f\u001a\u00020\u00018BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00108V@PX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u00168P@PX\u0090\u000e\u00a2\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R4\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c8P@VX\u0090\u000e\u00a2\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010#\u001a\u00020\t8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b$\u0010%R\"\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\"\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010'\u00a8\u0006="}, d2 = {"Landroidx/compose/runtime/snapshots/TransparentObserverMutableSnapshot;", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "previousSnapshot", "specifiedReadObserver", "Lkotlin/Function1;", "", "", "specifiedWriteObserver", "mergeParentObservers", "", "ownsPreviousSnapshot", "(Landroidx/compose/runtime/snapshots/MutableSnapshot;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZZ)V", "currentSnapshot", "getCurrentSnapshot", "()Landroidx/compose/runtime/snapshots/MutableSnapshot;", "value", "", "id", "getId", "()I", "setId$runtime_release", "(I)V", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", HippyReporter.RemoveEngineReason.INVALID, "getInvalid$runtime_release", "()Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "setInvalid$runtime_release", "(Landroidx/compose/runtime/snapshots/SnapshotIdSet;)V", "", "Landroidx/compose/runtime/snapshots/StateObject;", SessionDbHelper.MODIFIED_DATE, "getModified$runtime_release", "()Ljava/util/Set;", "setModified", "(Ljava/util/Set;)V", "readOnly", "getReadOnly", "()Z", "getSpecifiedReadObserver$runtime_release", "()Lkotlin/jvm/functions/Function1;", "getSpecifiedWriteObserver$runtime_release", "apply", "Landroidx/compose/runtime/snapshots/SnapshotApplyResult;", "dispose", "hasPendingChanges", "nestedActivated", "", "snapshot", "Landroidx/compose/runtime/snapshots/Snapshot;", "nestedActivated$runtime_release", "nestedDeactivated", "nestedDeactivated$runtime_release", "notifyObjectsInitialized", "notifyObjectsInitialized$runtime_release", "recordModified", "state", "recordModified$runtime_release", "takeNestedMutableSnapshot", "readObserver", "writeObserver", "takeNestedSnapshot", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes39.dex */
public final class TransparentObserverMutableSnapshot extends MutableSnapshot {
    private final boolean mergeParentObservers;
    private final boolean ownsPreviousSnapshot;
    private final MutableSnapshot previousSnapshot;
    private final Function1<Object, Unit> specifiedReadObserver;
    private final Function1<Object, Unit> specifiedWriteObserver;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TransparentObserverMutableSnapshot(MutableSnapshot mutableSnapshot, Function1<Object, Unit> function1, Function1<Object, Unit> function12, boolean z16, boolean z17) {
        super(0, r0, r1, r2);
        AtomicReference atomicReference;
        Function1<Object, Unit> readObserver$runtime_release;
        Function1 mergedReadObserver;
        AtomicReference atomicReference2;
        Function1<Object, Unit> writeObserver$runtime_release;
        Function1 mergedWriteObserver;
        SnapshotIdSet empty = SnapshotIdSet.INSTANCE.getEMPTY();
        if (mutableSnapshot == null || (readObserver$runtime_release = mutableSnapshot.getReadObserver$runtime_release()) == null) {
            atomicReference = SnapshotKt.currentGlobalSnapshot;
            readObserver$runtime_release = ((GlobalSnapshot) atomicReference.get()).getReadObserver$runtime_release();
        }
        mergedReadObserver = SnapshotKt.mergedReadObserver(function1, readObserver$runtime_release, z16);
        if (mutableSnapshot == null || (writeObserver$runtime_release = mutableSnapshot.getWriteObserver$runtime_release()) == null) {
            atomicReference2 = SnapshotKt.currentGlobalSnapshot;
            writeObserver$runtime_release = ((GlobalSnapshot) atomicReference2.get()).getWriteObserver$runtime_release();
        }
        mergedWriteObserver = SnapshotKt.mergedWriteObserver(function12, writeObserver$runtime_release);
        this.previousSnapshot = mutableSnapshot;
        this.specifiedReadObserver = function1;
        this.specifiedWriteObserver = function12;
        this.mergeParentObservers = z16;
        this.ownsPreviousSnapshot = z17;
    }

    private final MutableSnapshot getCurrentSnapshot() {
        AtomicReference atomicReference;
        MutableSnapshot mutableSnapshot = this.previousSnapshot;
        if (mutableSnapshot != null) {
            return mutableSnapshot;
        }
        atomicReference = SnapshotKt.currentGlobalSnapshot;
        Object obj = atomicReference.get();
        Intrinsics.checkNotNullExpressionValue(obj, "currentGlobalSnapshot.get()");
        return (MutableSnapshot) obj;
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
    public SnapshotApplyResult apply() {
        return getCurrentSnapshot().apply();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public int getId() {
        return getCurrentSnapshot().getId();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* renamed from: getInvalid$runtime_release */
    public SnapshotIdSet getInvalid() {
        return getCurrentSnapshot().getInvalid();
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public Set<StateObject> getModified$runtime_release() {
        return getCurrentSnapshot().getModified$runtime_release();
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public boolean getReadOnly() {
        return getCurrentSnapshot().getReadOnly();
    }

    public final Function1<Object, Unit> getSpecifiedReadObserver$runtime_release() {
        return this.specifiedReadObserver;
    }

    public final Function1<Object, Unit> getSpecifiedWriteObserver$runtime_release() {
        return this.specifiedWriteObserver;
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public boolean hasPendingChanges() {
        return getCurrentSnapshot().hasPendingChanges();
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public void notifyObjectsInitialized$runtime_release() {
        getCurrentSnapshot().notifyObjectsInitialized$runtime_release();
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    /* renamed from: recordModified$runtime_release */
    public void mo35recordModified$runtime_release(StateObject state) {
        Intrinsics.checkNotNullParameter(state, "state");
        getCurrentSnapshot().mo35recordModified$runtime_release(state);
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void setId$runtime_release(int i3) {
        SnapshotStateMapKt.unsupported();
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void setInvalid$runtime_release(SnapshotIdSet value) {
        Intrinsics.checkNotNullParameter(value, "value");
        SnapshotStateMapKt.unsupported();
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
    public void setModified(Set<StateObject> set) {
        SnapshotStateMapKt.unsupported();
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
    public MutableSnapshot takeNestedMutableSnapshot(Function1<Object, Unit> readObserver, Function1<Object, Unit> writeObserver) {
        Function1<Object, Unit> mergedWriteObserver;
        Function1<Object, Unit> mergedReadObserver$default = SnapshotKt.mergedReadObserver$default(readObserver, getReadObserver$runtime_release(), false, 4, null);
        mergedWriteObserver = SnapshotKt.mergedWriteObserver(writeObserver, getWriteObserver$runtime_release());
        if (!this.mergeParentObservers) {
            return new TransparentObserverMutableSnapshot(getCurrentSnapshot().takeNestedMutableSnapshot(null, mergedWriteObserver), mergedReadObserver$default, mergedWriteObserver, false, true);
        }
        return getCurrentSnapshot().takeNestedMutableSnapshot(mergedReadObserver$default, mergedWriteObserver);
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public Snapshot takeNestedSnapshot(Function1<Object, Unit> readObserver) {
        Snapshot createTransparentSnapshotWithNoParentReadObserver;
        Function1<Object, Unit> mergedReadObserver$default = SnapshotKt.mergedReadObserver$default(readObserver, getReadObserver$runtime_release(), false, 4, null);
        if (!this.mergeParentObservers) {
            createTransparentSnapshotWithNoParentReadObserver = SnapshotKt.createTransparentSnapshotWithNoParentReadObserver(getCurrentSnapshot().takeNestedSnapshot(null), mergedReadObserver$default, true);
            return createTransparentSnapshotWithNoParentReadObserver;
        }
        return getCurrentSnapshot().takeNestedSnapshot(mergedReadObserver$default);
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public void dispose() {
        MutableSnapshot mutableSnapshot;
        setDisposed$runtime_release(true);
        if (!this.ownsPreviousSnapshot || (mutableSnapshot = this.previousSnapshot) == null) {
            return;
        }
        mutableSnapshot.dispose();
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    /* renamed from: nestedActivated$runtime_release, reason: merged with bridge method [inline-methods] */
    public Void mo33nestedActivated$runtime_release(Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        SnapshotStateMapKt.unsupported();
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    /* renamed from: nestedDeactivated$runtime_release, reason: merged with bridge method [inline-methods] */
    public Void mo34nestedDeactivated$runtime_release(Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        SnapshotStateMapKt.unsupported();
        throw new KotlinNothingValueException();
    }
}
