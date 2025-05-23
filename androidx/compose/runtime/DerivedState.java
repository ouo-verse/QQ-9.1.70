package androidx.compose.runtime;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.snapshots.StateObject;
import androidx.compose.runtime.snapshots.StateRecord;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001#B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u00a2\u0006\u0002\u0010\u0006J2\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u00132\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00132\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020!2\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J\b\u0010\"\u001a\u00020\u001fH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00028\u00008VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0019\u0010\n\u001a\u0004\u0018\u00018\u00008G\u00a2\u0006\f\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\tR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00028\u00008VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\t\u00a8\u0006$"}, d2 = {"Landroidx/compose/runtime/DerivedSnapshotState;", "T", "Landroidx/compose/runtime/snapshots/StateObject;", "Landroidx/compose/runtime/DerivedState;", "calculation", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "currentValue", "getCurrentValue", "()Ljava/lang/Object;", "debuggerDisplayValue", "getDebuggerDisplayValue$annotations", "()V", "getDebuggerDisplayValue", "dependencies", "", "getDependencies", "()Ljava/util/Set;", MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_FIRST, "Landroidx/compose/runtime/DerivedSnapshotState$ResultRecord;", "firstStateRecord", "Landroidx/compose/runtime/snapshots/StateRecord;", "getFirstStateRecord", "()Landroidx/compose/runtime/snapshots/StateRecord;", "value", HippyTextInputController.COMMAND_getValue, "currentRecord", "readable", "snapshot", "Landroidx/compose/runtime/snapshots/Snapshot;", "displayValue", "", "prependStateRecord", "", "toString", "ResultRecord", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* renamed from: androidx.compose.runtime.DerivedSnapshotState, reason: from toString */
/* loaded from: classes39.dex */
public final class DerivedState<T> implements StateObject, androidx.compose.runtime.DerivedState<T> {
    private final Function0<T> calculation;
    private ResultRecord<T> first;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000 #*\u0004\b\u0001\u0010\u00012\u00020\u0002:\u0001#B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0002H\u0016J\b\u0010\u001b\u001a\u00020\u0002H\u0016J\u001a\u0010\u001c\u001a\u00020\u001d2\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001f2\u0006\u0010 \u001a\u00020!J\u001a\u0010\"\u001a\u00020\u00132\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001f2\u0006\u0010 \u001a\u00020!R.\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006$"}, d2 = {"Landroidx/compose/runtime/DerivedSnapshotState$ResultRecord;", "T", "Landroidx/compose/runtime/snapshots/StateRecord;", "()V", "dependencies", "Ljava/util/HashSet;", "Landroidx/compose/runtime/snapshots/StateObject;", "Lkotlin/collections/HashSet;", "getDependencies", "()Ljava/util/HashSet;", "setDependencies", "(Ljava/util/HashSet;)V", "result", "", "getResult", "()Ljava/lang/Object;", "setResult", "(Ljava/lang/Object;)V", "resultHash", "", "getResultHash", "()I", "setResultHash", "(I)V", "assign", "", "value", OperateCustomButton.OPERATE_CREATE, AppConstants.Key.COLUMN_IS_VALID, "", "derivedState", "Landroidx/compose/runtime/DerivedState;", "snapshot", "Landroidx/compose/runtime/snapshots/Snapshot;", "readableHash", "Companion", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* renamed from: androidx.compose.runtime.DerivedSnapshotState$ResultRecord */
    /* loaded from: classes39.dex */
    public static final class ResultRecord<T> extends StateRecord {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Object Unset = new Object();
        private HashSet<StateObject> dependencies;
        private Object result = Unset;
        private int resultHash;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Landroidx/compose/runtime/DerivedSnapshotState$ResultRecord$Companion;", "", "()V", "Unset", "getUnset", "()Ljava/lang/Object;", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* renamed from: androidx.compose.runtime.DerivedSnapshotState$ResultRecord$Companion, reason: from kotlin metadata */
        /* loaded from: classes39.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Object getUnset() {
                return ResultRecord.Unset;
            }

            private Companion() {
            }
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public void assign(StateRecord value) {
            Intrinsics.checkNotNullParameter(value, "value");
            ResultRecord resultRecord = (ResultRecord) value;
            this.dependencies = resultRecord.dependencies;
            this.result = resultRecord.result;
            this.resultHash = resultRecord.resultHash;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public StateRecord create() {
            return new ResultRecord();
        }

        public final HashSet<StateObject> getDependencies() {
            return this.dependencies;
        }

        public final Object getResult() {
            return this.result;
        }

        public final int getResultHash() {
            return this.resultHash;
        }

        public final boolean isValid(androidx.compose.runtime.DerivedState<?> derivedState, Snapshot snapshot) {
            Intrinsics.checkNotNullParameter(derivedState, "derivedState");
            Intrinsics.checkNotNullParameter(snapshot, "snapshot");
            return this.result != Unset && this.resultHash == readableHash(derivedState, snapshot);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final int readableHash(androidx.compose.runtime.DerivedState<?> derivedState, Snapshot snapshot) {
            HashSet<StateObject> hashSet;
            Intrinsics.checkNotNullParameter(derivedState, "derivedState");
            Intrinsics.checkNotNullParameter(snapshot, "snapshot");
            synchronized (SnapshotKt.getLock()) {
                hashSet = this.dependencies;
            }
            int i3 = 7;
            if (hashSet != null) {
                PersistentList persistentList = (PersistentList) SnapshotStateKt__DerivedStateKt.derivedStateObservers.get();
                if (persistentList == null) {
                    persistentList = ExtensionsKt.persistentListOf();
                }
                int size = persistentList.size();
                int i16 = 0;
                for (int i17 = 0; i17 < size; i17++) {
                    ((Function1) ((Pair) persistentList.get(i17)).component1()).invoke(derivedState);
                }
                try {
                    Iterator<StateObject> it = hashSet.iterator();
                    while (it.hasNext()) {
                        StateObject stateObject = it.next();
                        StateRecord firstStateRecord = stateObject.getFirstStateRecord();
                        Intrinsics.checkNotNullExpressionValue(stateObject, "stateObject");
                        StateRecord readable = SnapshotKt.readable(firstStateRecord, stateObject, snapshot);
                        i3 = (((i3 * 31) + ActualJvm_jvmKt.identityHashCode(readable)) * 31) + readable.getSnapshotId();
                    }
                    Unit unit = Unit.INSTANCE;
                } finally {
                    int size2 = persistentList.size();
                    while (i16 < size2) {
                        ((Function1) ((Pair) persistentList.get(i16)).component2()).invoke(derivedState);
                        i16++;
                    }
                }
            }
            return i3;
        }

        public final void setDependencies(HashSet<StateObject> hashSet) {
            this.dependencies = hashSet;
        }

        public final void setResult(Object obj) {
            this.result = obj;
        }

        public final void setResultHash(int i3) {
            this.resultHash = i3;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DerivedState(Function0<? extends T> calculation) {
        Intrinsics.checkNotNullParameter(calculation, "calculation");
        this.calculation = calculation;
        this.first = new ResultRecord<>();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final ResultRecord<T> currentRecord(ResultRecord<T> readable, Snapshot snapshot, Function0<? extends T> calculation) {
        SnapshotThreadLocal snapshotThreadLocal;
        SnapshotThreadLocal snapshotThreadLocal2;
        Snapshot.Companion companion;
        ResultRecord<T> resultRecord;
        SnapshotThreadLocal snapshotThreadLocal3;
        if (readable.isValid(this, snapshot)) {
            return readable;
        }
        snapshotThreadLocal = SnapshotStateKt__DerivedStateKt.isCalculationBlockRunning;
        Boolean bool = (Boolean) snapshotThreadLocal.get();
        int i3 = 0;
        boolean booleanValue = bool != null ? bool.booleanValue() : false;
        final HashSet<StateObject> hashSet = new HashSet<>();
        PersistentList persistentList = (PersistentList) SnapshotStateKt__DerivedStateKt.derivedStateObservers.get();
        if (persistentList == null) {
            persistentList = ExtensionsKt.persistentListOf();
        }
        int size = persistentList.size();
        for (int i16 = 0; i16 < size; i16++) {
            ((Function1) ((Pair) persistentList.get(i16)).component1()).invoke(this);
        }
        if (!booleanValue) {
            try {
                snapshotThreadLocal2 = SnapshotStateKt__DerivedStateKt.isCalculationBlockRunning;
                snapshotThreadLocal2.set(Boolean.TRUE);
            } finally {
                int size2 = persistentList.size();
                while (i3 < size2) {
                    ((Function1) ((Pair) persistentList.get(i3)).component2()).invoke(this);
                    i3++;
                }
            }
        }
        Object observe = Snapshot.INSTANCE.observe(new Function1<Object, Unit>(this) { // from class: androidx.compose.runtime.DerivedSnapshotState$currentRecord$result$1$result$1
            final /* synthetic */ DerivedState<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (it != this.this$0) {
                    if (it instanceof StateObject) {
                        hashSet.add(it);
                        return;
                    }
                    return;
                }
                throw new IllegalStateException("A derived state calculation cannot read itself".toString());
            }
        }, null, calculation);
        if (!booleanValue) {
            snapshotThreadLocal3 = SnapshotStateKt__DerivedStateKt.isCalculationBlockRunning;
            snapshotThreadLocal3.set(Boolean.FALSE);
        }
        synchronized (SnapshotKt.getLock()) {
            companion = Snapshot.INSTANCE;
            Snapshot current = companion.getCurrent();
            resultRecord = (ResultRecord) SnapshotKt.newWritableRecord(this.first, this, current);
            resultRecord.setDependencies(hashSet);
            resultRecord.setResultHash(resultRecord.readableHash(this, current));
            resultRecord.setResult(observe);
        }
        if (!booleanValue) {
            companion.notifyObjectsInitialized();
        }
        return resultRecord;
    }

    private final String displayValue() {
        ResultRecord<T> resultRecord = this.first;
        Snapshot.Companion companion = Snapshot.INSTANCE;
        ResultRecord resultRecord2 = (ResultRecord) SnapshotKt.current(resultRecord, companion.getCurrent());
        if (resultRecord2.isValid(this, companion.getCurrent())) {
            return String.valueOf(resultRecord2.getResult());
        }
        return "<Not calculated>";
    }

    @Override // androidx.compose.runtime.DerivedState
    public T getCurrentValue() {
        ResultRecord<T> resultRecord = this.first;
        Snapshot.Companion companion = Snapshot.INSTANCE;
        return (T) currentRecord((ResultRecord) SnapshotKt.current(resultRecord, companion.getCurrent()), companion.getCurrent(), this.calculation).getResult();
    }

    public final T getDebuggerDisplayValue() {
        ResultRecord<T> resultRecord = this.first;
        Snapshot.Companion companion = Snapshot.INSTANCE;
        ResultRecord resultRecord2 = (ResultRecord) SnapshotKt.current(resultRecord, companion.getCurrent());
        if (resultRecord2.isValid(this, companion.getCurrent())) {
            return (T) resultRecord2.getResult();
        }
        return null;
    }

    @Override // androidx.compose.runtime.DerivedState
    public Set<StateObject> getDependencies() {
        Set<StateObject> emptySet;
        ResultRecord<T> resultRecord = this.first;
        Snapshot.Companion companion = Snapshot.INSTANCE;
        HashSet<StateObject> dependencies = currentRecord((ResultRecord) SnapshotKt.current(resultRecord, companion.getCurrent()), companion.getCurrent(), this.calculation).getDependencies();
        if (dependencies != null) {
            return dependencies;
        }
        emptySet = SetsKt__SetsKt.emptySet();
        return emptySet;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public StateRecord getFirstStateRecord() {
        return this.first;
    }

    @Override // androidx.compose.runtime.State
    public T getValue() {
        Function1<Object, Unit> readObserver$runtime_release = Snapshot.INSTANCE.getCurrent().getReadObserver$runtime_release();
        if (readObserver$runtime_release != null) {
            readObserver$runtime_release.invoke(this);
        }
        return getCurrentValue();
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public /* synthetic */ StateRecord mergeRecords(StateRecord stateRecord, StateRecord stateRecord2, StateRecord stateRecord3) {
        return androidx.compose.runtime.snapshots.a.a(this, stateRecord, stateRecord2, stateRecord3);
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public void prependStateRecord(StateRecord value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.first = (ResultRecord) value;
    }

    public String toString() {
        return "DerivedState(value=" + displayValue() + ")@" + hashCode();
    }

    public static /* synthetic */ void getDebuggerDisplayValue$annotations() {
    }
}
