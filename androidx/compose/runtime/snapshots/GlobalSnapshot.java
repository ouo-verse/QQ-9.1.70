package androidx.compose.runtime.snapshots;

import com.tencent.hippy.qq.utils.HippyReporter;
import java.util.Collection;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\u0015\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0010\u00a2\u0006\u0002\b\u000fJ\u0015\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0010\u00a2\u0006\u0002\b\u0011J\r\u0010\u0012\u001a\u00020\nH\u0010\u00a2\u0006\u0002\b\u0013J4\u0010\u0014\u001a\u00020\u00012\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\n\u0018\u00010\u00162\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\n\u0018\u00010\u0016H\u0016J\u001e\u0010\u0019\u001a\u00020\u000e2\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\n\u0018\u00010\u0016H\u0016\u00a8\u0006\u001a"}, d2 = {"Landroidx/compose/runtime/snapshots/GlobalSnapshot;", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "id", "", HippyReporter.RemoveEngineReason.INVALID, "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "(ILandroidx/compose/runtime/snapshots/SnapshotIdSet;)V", "apply", "Landroidx/compose/runtime/snapshots/SnapshotApplyResult;", "dispose", "", "nestedActivated", "", "snapshot", "Landroidx/compose/runtime/snapshots/Snapshot;", "nestedActivated$runtime_release", "nestedDeactivated", "nestedDeactivated$runtime_release", "notifyObjectsInitialized", "notifyObjectsInitialized$runtime_release", "takeNestedMutableSnapshot", "readObserver", "Lkotlin/Function1;", "", "writeObserver", "takeNestedSnapshot", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes39.dex */
public final class GlobalSnapshot extends MutableSnapshot {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public GlobalSnapshot(int i3, SnapshotIdSet invalid) {
        super(i3, invalid, null, r3);
        List list;
        final List list2;
        Function1<Object, Unit> function1;
        Object singleOrNull;
        List list3;
        Intrinsics.checkNotNullParameter(invalid, "invalid");
        synchronized (SnapshotKt.getLock()) {
            list = SnapshotKt.globalWriteObservers;
            if (!list.isEmpty()) {
                list3 = SnapshotKt.globalWriteObservers;
                list2 = CollectionsKt___CollectionsKt.toMutableList((Collection) list3);
            } else {
                list2 = null;
            }
            if (list2 != null) {
                singleOrNull = CollectionsKt___CollectionsKt.singleOrNull((List<? extends Object>) list2);
                function1 = (Function1) singleOrNull;
                if (function1 == null) {
                    function1 = new Function1<Object, Unit>() { // from class: androidx.compose.runtime.snapshots.GlobalSnapshot$1$1$1
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
                            List<Function1<Object, Unit>> list4 = list2;
                            int size = list4.size();
                            for (int i16 = 0; i16 < size; i16++) {
                                list4.get(i16).invoke(state);
                            }
                        }
                    };
                }
            } else {
                function1 = null;
            }
        }
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
    public SnapshotApplyResult apply() {
        throw new IllegalStateException("Cannot apply the global snapshot directly. Call Snapshot.advanceGlobalSnapshot".toString());
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public void dispose() {
        synchronized (SnapshotKt.getLock()) {
            releasePinnedSnapshotLocked$runtime_release();
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public void notifyObjectsInitialized$runtime_release() {
        SnapshotKt.advanceGlobalSnapshot();
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
    public MutableSnapshot takeNestedMutableSnapshot(final Function1<Object, Unit> readObserver, final Function1<Object, Unit> writeObserver) {
        Snapshot takeNewSnapshot;
        takeNewSnapshot = SnapshotKt.takeNewSnapshot(new Function1<SnapshotIdSet, MutableSnapshot>() { // from class: androidx.compose.runtime.snapshots.GlobalSnapshot$takeNestedMutableSnapshot$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final MutableSnapshot invoke(SnapshotIdSet invalid) {
                int i3;
                Intrinsics.checkNotNullParameter(invalid, "invalid");
                synchronized (SnapshotKt.getLock()) {
                    i3 = SnapshotKt.nextSnapshotId;
                    SnapshotKt.nextSnapshotId = i3 + 1;
                }
                return new MutableSnapshot(i3, invalid, readObserver, writeObserver);
            }
        });
        return (MutableSnapshot) takeNewSnapshot;
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public Snapshot takeNestedSnapshot(final Function1<Object, Unit> readObserver) {
        Snapshot takeNewSnapshot;
        takeNewSnapshot = SnapshotKt.takeNewSnapshot(new Function1<SnapshotIdSet, ReadonlySnapshot>() { // from class: androidx.compose.runtime.snapshots.GlobalSnapshot$takeNestedSnapshot$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ReadonlySnapshot invoke(SnapshotIdSet invalid) {
                int i3;
                Intrinsics.checkNotNullParameter(invalid, "invalid");
                synchronized (SnapshotKt.getLock()) {
                    i3 = SnapshotKt.nextSnapshotId;
                    SnapshotKt.nextSnapshotId = i3 + 1;
                }
                return new ReadonlySnapshot(i3, invalid, readObserver);
            }
        });
        return takeNewSnapshot;
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
