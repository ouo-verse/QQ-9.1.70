package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.SynchronizedObject;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.snapshots.Snapshot;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\u0010'\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u00020\u0004:\u0001KB\u0005\u00a2\u0006\u0002\u0010\u0005J1\u0010&\u001a\u00020'2\u001e\u0010(\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010*\u0012\u0004\u0012\u00020'0)H\u0080\b\u00f8\u0001\u0000\u00a2\u0006\u0002\b+J1\u0010,\u001a\u00020'2\u001e\u0010(\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010*\u0012\u0004\u0012\u00020'0)H\u0080\b\u00f8\u0001\u0000\u00a2\u0006\u0002\b-J\b\u0010.\u001a\u00020/H\u0016J\u0015\u00100\u001a\u00020'2\u0006\u00101\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u00102J\u0015\u00103\u001a\u00020'2\u0006\u00104\u001a\u00028\u0001H\u0016\u00a2\u0006\u0002\u00102J\u0018\u00105\u001a\u0004\u0018\u00018\u00012\u0006\u00101\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0002\u00106J\b\u00107\u001a\u00020'H\u0016J4\u00108\u001a\u0002H9\"\u0004\b\u0002\u001092\u001e\u0010:\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003\u0012\u0004\u0012\u0002H90)H\u0082\b\u00a2\u0006\u0002\u0010;J\u0010\u0010<\u001a\u00020/2\u0006\u00104\u001a\u00020\u0011H\u0016J\u001f\u0010=\u001a\u0004\u0018\u00018\u00012\u0006\u00101\u001a\u00028\u00002\u0006\u00104\u001a\u00028\u0001H\u0016\u00a2\u0006\u0002\u0010>J\u001e\u0010?\u001a\u00020/2\u0014\u0010@\u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007H\u0016J\u0017\u0010A\u001a\u0004\u0018\u00018\u00012\u0006\u00101\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u00106J1\u0010B\u001a\u00020'2\u001e\u0010(\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r\u0012\u0004\u0012\u00020'0)H\u0080\b\u00f8\u0001\u0000\u00a2\u0006\u0002\bCJ\u0017\u0010D\u001a\u00020'2\u0006\u00104\u001a\u00028\u0001H\u0000\u00a2\u0006\u0004\bE\u00102J5\u0010F\u001a\u00020/2*\u0010:\u001a&\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010G\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010G0)H\u0082\bJ9\u0010H\u001a\u0002H9\"\u0004\b\u0002\u001092#\u0010:\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001c\u0012\u0004\u0012\u0002H90)\u00a2\u0006\u0002\bIH\u0082\b\u00a2\u0006\u0002\u0010;J9\u0010J\u001a\u0002H9\"\u0004\b\u0002\u001092#\u0010:\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001c\u0012\u0004\u0012\u0002H90)\u00a2\u0006\u0002\bIH\u0082\b\u00a2\u0006\u0002\u0010;R&\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00078AX\u0080\u0004\u00a2\u0006\f\u0012\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\nR&\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r0\fX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011@RX\u0096\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\fX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0014\u0010\u0017\u001a\u00020\u00188@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR&\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001c8@X\u0080\u0004\u00a2\u0006\f\u0012\u0004\b\u001d\u0010\u0005\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u00188VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b!\u0010\u001aR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00010#X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010%\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006L"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "K", "V", "", "Landroidx/compose/runtime/snapshots/StateObject;", "()V", "debuggerDisplayValue", "", "getDebuggerDisplayValue$annotations", "getDebuggerDisplayValue", "()Ljava/util/Map;", "entries", "", "", "getEntries", "()Ljava/util/Set;", "<set-?>", "Landroidx/compose/runtime/snapshots/StateRecord;", "firstStateRecord", "getFirstStateRecord", "()Landroidx/compose/runtime/snapshots/StateRecord;", "keys", "getKeys", "modification", "", "getModification$runtime_release", "()I", "readable", "Landroidx/compose/runtime/snapshots/SnapshotStateMap$StateMapStateRecord;", "getReadable$runtime_release$annotations", "getReadable$runtime_release", "()Landroidx/compose/runtime/snapshots/SnapshotStateMap$StateMapStateRecord;", "size", "getSize", "values", "", "getValues", "()Ljava/util/Collection;", "all", "", "predicate", "Lkotlin/Function1;", "", "all$runtime_release", SemanticAttributes.DbCassandraConsistencyLevelValues.ANY, "any$runtime_release", QCircleLpReportDc05507.KEY_CLEAR, "", "containsKey", "key", "(Ljava/lang/Object;)Z", "containsValue", "value", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "isEmpty", "mutate", BdhLogUtil.LogTag.Tag_Req, "block", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "prependStateRecord", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "putAll", "from", "remove", "removeIf", "removeIf$runtime_release", "removeValue", "removeValue$runtime_release", "update", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "withCurrent", "Lkotlin/ExtensionFunctionType;", "writable", "StateMapStateRecord", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes39.dex */
public final class SnapshotStateMap<K, V> implements Map<K, V>, StateObject, KMutableMap {
    private StateRecord firstStateRecord = new StateMapStateRecord(ExtensionsKt.persistentHashMapOf());
    private final Set<Map.Entry<K, V>> entries = new SnapshotMapEntrySet(this);
    private final Set<K> keys = new SnapshotMapKeySet(this);
    private final Collection<V> values = new SnapshotMapValueSet(this);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u0003B\u001b\b\u0000\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0003H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016R&\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006R\u001a\u0010\n\u001a\u00020\u000bX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateMap$StateMapStateRecord;", "K", "V", "Landroidx/compose/runtime/snapshots/StateRecord;", "map", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;)V", "getMap$runtime_release", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "setMap$runtime_release", "modification", "", "getModification$runtime_release", "()I", "setModification$runtime_release", "(I)V", "assign", "", "value", OperateCustomButton.OPERATE_CREATE, "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes39.dex */
    public static final class StateMapStateRecord<K, V> extends StateRecord {
        private PersistentMap<K, ? extends V> map;
        private int modification;

        public StateMapStateRecord(PersistentMap<K, ? extends V> map) {
            Intrinsics.checkNotNullParameter(map, "map");
            this.map = map;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public void assign(StateRecord value) {
            SynchronizedObject synchronizedObject;
            Intrinsics.checkNotNullParameter(value, "value");
            StateMapStateRecord stateMapStateRecord = (StateMapStateRecord) value;
            synchronizedObject = SnapshotStateMapKt.sync;
            synchronized (synchronizedObject) {
                this.map = stateMapStateRecord.map;
                this.modification = stateMapStateRecord.modification;
                Unit unit = Unit.INSTANCE;
            }
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public StateRecord create() {
            return new StateMapStateRecord(this.map);
        }

        public final PersistentMap<K, V> getMap$runtime_release() {
            return this.map;
        }

        /* renamed from: getModification$runtime_release, reason: from getter */
        public final int getModification() {
            return this.modification;
        }

        public final void setMap$runtime_release(PersistentMap<K, ? extends V> persistentMap) {
            Intrinsics.checkNotNullParameter(persistentMap, "<set-?>");
            this.map = persistentMap;
        }

        public final void setModification$runtime_release(int i3) {
            this.modification = i3;
        }
    }

    private final <R> R mutate(Function1<? super Map<K, V>, ? extends R> block) {
        SynchronizedObject synchronizedObject;
        Snapshot.Companion companion;
        PersistentMap<K, V> map$runtime_release;
        int modification;
        R invoke;
        SynchronizedObject synchronizedObject2;
        Snapshot current;
        boolean z16;
        do {
            synchronizedObject = SnapshotStateMapKt.sync;
            synchronized (synchronizedObject) {
                try {
                    StateMapStateRecord stateMapStateRecord = (StateMapStateRecord) getFirstStateRecord();
                    companion = Snapshot.INSTANCE;
                    StateMapStateRecord stateMapStateRecord2 = (StateMapStateRecord) SnapshotKt.current(stateMapStateRecord, companion.getCurrent());
                    map$runtime_release = stateMapStateRecord2.getMap$runtime_release();
                    modification = stateMapStateRecord2.getModification();
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                } catch (Throwable th5) {
                    InlineMarker.finallyStart(1);
                    InlineMarker.finallyEnd(1);
                    throw th5;
                }
            }
            InlineMarker.finallyEnd(1);
            Intrinsics.checkNotNull(map$runtime_release);
            PersistentMap.Builder<K, V> builder = map$runtime_release.builder();
            invoke = block.invoke(builder);
            PersistentMap<K, V> build = builder.build();
            if (Intrinsics.areEqual(build, map$runtime_release)) {
                break;
            }
            synchronizedObject2 = SnapshotStateMapKt.sync;
            synchronized (synchronizedObject2) {
                try {
                    StateMapStateRecord stateMapStateRecord3 = (StateMapStateRecord) getFirstStateRecord();
                    SnapshotKt.getSnapshotInitializer();
                    synchronized (SnapshotKt.getLock()) {
                        try {
                            current = companion.getCurrent();
                            StateMapStateRecord stateMapStateRecord4 = (StateMapStateRecord) SnapshotKt.writableRecord(stateMapStateRecord3, this, current);
                            if (stateMapStateRecord4.getModification() == modification) {
                                stateMapStateRecord4.setMap$runtime_release(build);
                                stateMapStateRecord4.setModification$runtime_release(stateMapStateRecord4.getModification() + 1);
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            InlineMarker.finallyStart(1);
                        } finally {
                        }
                    }
                    InlineMarker.finallyEnd(1);
                    SnapshotKt.notifyWrite(current, this);
                    InlineMarker.finallyStart(1);
                } catch (Throwable th6) {
                    InlineMarker.finallyStart(1);
                    InlineMarker.finallyEnd(1);
                    throw th6;
                }
            }
            InlineMarker.finallyEnd(1);
        } while (!z16);
        return invoke;
    }

    private final void update(Function1<? super PersistentMap<K, ? extends V>, ? extends PersistentMap<K, ? extends V>> block) {
        SynchronizedObject synchronizedObject;
        Snapshot current;
        StateMapStateRecord stateMapStateRecord = (StateMapStateRecord) getFirstStateRecord();
        Snapshot.Companion companion = Snapshot.INSTANCE;
        StateMapStateRecord stateMapStateRecord2 = (StateMapStateRecord) SnapshotKt.current(stateMapStateRecord, companion.getCurrent());
        PersistentMap<K, ? extends V> invoke = block.invoke(stateMapStateRecord2.getMap$runtime_release());
        if (invoke != stateMapStateRecord2.getMap$runtime_release()) {
            synchronizedObject = SnapshotStateMapKt.sync;
            synchronized (synchronizedObject) {
                try {
                    StateMapStateRecord stateMapStateRecord3 = (StateMapStateRecord) getFirstStateRecord();
                    SnapshotKt.getSnapshotInitializer();
                    synchronized (SnapshotKt.getLock()) {
                        try {
                            current = companion.getCurrent();
                            StateMapStateRecord stateMapStateRecord4 = (StateMapStateRecord) SnapshotKt.writableRecord(stateMapStateRecord3, this, current);
                            stateMapStateRecord4.setMap$runtime_release(invoke);
                            stateMapStateRecord4.setModification$runtime_release(stateMapStateRecord4.getModification() + 1);
                            InlineMarker.finallyStart(1);
                        } catch (Throwable th5) {
                            InlineMarker.finallyStart(1);
                            InlineMarker.finallyEnd(1);
                            throw th5;
                        }
                    }
                    InlineMarker.finallyEnd(1);
                    SnapshotKt.notifyWrite(current, this);
                    InlineMarker.finallyStart(1);
                } catch (Throwable th6) {
                    InlineMarker.finallyStart(1);
                    InlineMarker.finallyEnd(1);
                    throw th6;
                }
            }
            InlineMarker.finallyEnd(1);
        }
    }

    private final <R> R withCurrent(Function1<? super StateMapStateRecord<K, V>, ? extends R> block) {
        return block.invoke(SnapshotKt.current((StateMapStateRecord) getFirstStateRecord(), Snapshot.INSTANCE.getCurrent()));
    }

    private final <R> R writable(Function1<? super StateMapStateRecord<K, V>, ? extends R> block) {
        Snapshot current;
        R invoke;
        StateMapStateRecord stateMapStateRecord = (StateMapStateRecord) getFirstStateRecord();
        SnapshotKt.getSnapshotInitializer();
        synchronized (SnapshotKt.getLock()) {
            try {
                current = Snapshot.INSTANCE.getCurrent();
                invoke = block.invoke(SnapshotKt.writableRecord(stateMapStateRecord, this, current));
                InlineMarker.finallyStart(1);
            } catch (Throwable th5) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th5;
            }
        }
        InlineMarker.finallyEnd(1);
        SnapshotKt.notifyWrite(current, this);
        return invoke;
    }

    public final boolean all$runtime_release(Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Iterator<E> it = ((ImmutableSet) getReadable$runtime_release().getMap$runtime_release().entrySet()).iterator();
        while (it.hasNext()) {
            if (!predicate.invoke((Map.Entry) it.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public final boolean any$runtime_release(Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Iterator<E> it = ((ImmutableSet) getReadable$runtime_release().getMap$runtime_release().entrySet()).iterator();
        while (it.hasNext()) {
            if (predicate.invoke((Map.Entry) it.next()).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map
    public void clear() {
        SynchronizedObject synchronizedObject;
        Snapshot current;
        StateMapStateRecord stateMapStateRecord = (StateMapStateRecord) getFirstStateRecord();
        Snapshot.Companion companion = Snapshot.INSTANCE;
        StateMapStateRecord stateMapStateRecord2 = (StateMapStateRecord) SnapshotKt.current(stateMapStateRecord, companion.getCurrent());
        stateMapStateRecord2.getMap$runtime_release();
        PersistentMap<K, V> persistentHashMapOf = ExtensionsKt.persistentHashMapOf();
        if (persistentHashMapOf != stateMapStateRecord2.getMap$runtime_release()) {
            synchronizedObject = SnapshotStateMapKt.sync;
            synchronized (synchronizedObject) {
                StateMapStateRecord stateMapStateRecord3 = (StateMapStateRecord) getFirstStateRecord();
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    current = companion.getCurrent();
                    StateMapStateRecord stateMapStateRecord4 = (StateMapStateRecord) SnapshotKt.writableRecord(stateMapStateRecord3, this, current);
                    stateMapStateRecord4.setMap$runtime_release(persistentHashMapOf);
                    stateMapStateRecord4.setModification$runtime_release(stateMapStateRecord4.getModification() + 1);
                }
                SnapshotKt.notifyWrite(current, this);
            }
        }
    }

    @Override // java.util.Map
    public boolean containsKey(Object key) {
        return getReadable$runtime_release().getMap$runtime_release().containsKey(key);
    }

    @Override // java.util.Map
    public boolean containsValue(Object value) {
        return getReadable$runtime_release().getMap$runtime_release().containsValue(value);
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public V get(Object key) {
        return getReadable$runtime_release().getMap$runtime_release().get(key);
    }

    public final Map<K, V> getDebuggerDisplayValue() {
        return ((StateMapStateRecord) SnapshotKt.current((StateMapStateRecord) getFirstStateRecord(), Snapshot.INSTANCE.getCurrent())).getMap$runtime_release();
    }

    public Set<Map.Entry<K, V>> getEntries() {
        return this.entries;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public StateRecord getFirstStateRecord() {
        return this.firstStateRecord;
    }

    public Set<K> getKeys() {
        return this.keys;
    }

    public final int getModification$runtime_release() {
        return getReadable$runtime_release().getModification();
    }

    public final StateMapStateRecord<K, V> getReadable$runtime_release() {
        return (StateMapStateRecord) SnapshotKt.readable((StateMapStateRecord) getFirstStateRecord(), this);
    }

    public int getSize() {
        return getReadable$runtime_release().getMap$runtime_release().size();
    }

    public Collection<V> getValues() {
        return this.values;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return getReadable$runtime_release().getMap$runtime_release().isEmpty();
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return getKeys();
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public /* synthetic */ StateRecord mergeRecords(StateRecord stateRecord, StateRecord stateRecord2, StateRecord stateRecord3) {
        return a.a(this, stateRecord, stateRecord2, stateRecord3);
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public void prependStateRecord(StateRecord value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.firstStateRecord = (StateMapStateRecord) value;
    }

    @Override // java.util.Map
    public V put(K key, V value) {
        SynchronizedObject synchronizedObject;
        Snapshot.Companion companion;
        PersistentMap<K, V> map$runtime_release;
        int modification;
        V put;
        SynchronizedObject synchronizedObject2;
        Snapshot current;
        boolean z16;
        do {
            synchronizedObject = SnapshotStateMapKt.sync;
            synchronized (synchronizedObject) {
                StateMapStateRecord stateMapStateRecord = (StateMapStateRecord) getFirstStateRecord();
                companion = Snapshot.INSTANCE;
                StateMapStateRecord stateMapStateRecord2 = (StateMapStateRecord) SnapshotKt.current(stateMapStateRecord, companion.getCurrent());
                map$runtime_release = stateMapStateRecord2.getMap$runtime_release();
                modification = stateMapStateRecord2.getModification();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(map$runtime_release);
            PersistentMap.Builder<K, V> builder = map$runtime_release.builder();
            put = builder.put(key, value);
            PersistentMap<K, V> build = builder.build();
            if (Intrinsics.areEqual(build, map$runtime_release)) {
                break;
            }
            synchronizedObject2 = SnapshotStateMapKt.sync;
            synchronized (synchronizedObject2) {
                StateMapStateRecord stateMapStateRecord3 = (StateMapStateRecord) getFirstStateRecord();
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    current = companion.getCurrent();
                    StateMapStateRecord stateMapStateRecord4 = (StateMapStateRecord) SnapshotKt.writableRecord(stateMapStateRecord3, this, current);
                    if (stateMapStateRecord4.getModification() == modification) {
                        stateMapStateRecord4.setMap$runtime_release(build);
                        z16 = true;
                        stateMapStateRecord4.setModification$runtime_release(stateMapStateRecord4.getModification() + 1);
                    } else {
                        z16 = false;
                    }
                }
                SnapshotKt.notifyWrite(current, this);
            }
        } while (!z16);
        return put;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> from) {
        SynchronizedObject synchronizedObject;
        Snapshot.Companion companion;
        PersistentMap<K, V> map$runtime_release;
        int modification;
        SynchronizedObject synchronizedObject2;
        Snapshot current;
        boolean z16;
        Intrinsics.checkNotNullParameter(from, "from");
        do {
            synchronizedObject = SnapshotStateMapKt.sync;
            synchronized (synchronizedObject) {
                StateMapStateRecord stateMapStateRecord = (StateMapStateRecord) getFirstStateRecord();
                companion = Snapshot.INSTANCE;
                StateMapStateRecord stateMapStateRecord2 = (StateMapStateRecord) SnapshotKt.current(stateMapStateRecord, companion.getCurrent());
                map$runtime_release = stateMapStateRecord2.getMap$runtime_release();
                modification = stateMapStateRecord2.getModification();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(map$runtime_release);
            PersistentMap.Builder<K, V> builder = map$runtime_release.builder();
            builder.putAll(from);
            PersistentMap<K, V> build = builder.build();
            if (Intrinsics.areEqual(build, map$runtime_release)) {
                return;
            }
            synchronizedObject2 = SnapshotStateMapKt.sync;
            synchronized (synchronizedObject2) {
                StateMapStateRecord stateMapStateRecord3 = (StateMapStateRecord) getFirstStateRecord();
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    current = companion.getCurrent();
                    StateMapStateRecord stateMapStateRecord4 = (StateMapStateRecord) SnapshotKt.writableRecord(stateMapStateRecord3, this, current);
                    if (stateMapStateRecord4.getModification() == modification) {
                        stateMapStateRecord4.setMap$runtime_release(build);
                        z16 = true;
                        stateMapStateRecord4.setModification$runtime_release(stateMapStateRecord4.getModification() + 1);
                    } else {
                        z16 = false;
                    }
                }
                SnapshotKt.notifyWrite(current, this);
            }
        } while (!z16);
    }

    @Override // java.util.Map
    public V remove(Object key) {
        SynchronizedObject synchronizedObject;
        Snapshot.Companion companion;
        PersistentMap<K, V> map$runtime_release;
        int modification;
        V remove;
        SynchronizedObject synchronizedObject2;
        Snapshot current;
        boolean z16;
        do {
            synchronizedObject = SnapshotStateMapKt.sync;
            synchronized (synchronizedObject) {
                StateMapStateRecord stateMapStateRecord = (StateMapStateRecord) getFirstStateRecord();
                companion = Snapshot.INSTANCE;
                StateMapStateRecord stateMapStateRecord2 = (StateMapStateRecord) SnapshotKt.current(stateMapStateRecord, companion.getCurrent());
                map$runtime_release = stateMapStateRecord2.getMap$runtime_release();
                modification = stateMapStateRecord2.getModification();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(map$runtime_release);
            PersistentMap.Builder<K, V> builder = map$runtime_release.builder();
            remove = builder.remove(key);
            PersistentMap<K, V> build = builder.build();
            if (Intrinsics.areEqual(build, map$runtime_release)) {
                break;
            }
            synchronizedObject2 = SnapshotStateMapKt.sync;
            synchronized (synchronizedObject2) {
                StateMapStateRecord stateMapStateRecord3 = (StateMapStateRecord) getFirstStateRecord();
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    current = companion.getCurrent();
                    StateMapStateRecord stateMapStateRecord4 = (StateMapStateRecord) SnapshotKt.writableRecord(stateMapStateRecord3, this, current);
                    if (stateMapStateRecord4.getModification() == modification) {
                        stateMapStateRecord4.setMap$runtime_release(build);
                        z16 = true;
                        stateMapStateRecord4.setModification$runtime_release(stateMapStateRecord4.getModification() + 1);
                    } else {
                        z16 = false;
                    }
                }
                SnapshotKt.notifyWrite(current, this);
            }
        } while (!z16);
        return remove;
    }

    public final boolean removeIf$runtime_release(Function1<? super Map.Entry<K, V>, Boolean> predicate) {
        SynchronizedObject synchronizedObject;
        PersistentMap<K, V> map$runtime_release;
        int modification;
        SynchronizedObject synchronizedObject2;
        Snapshot current;
        boolean z16;
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        boolean z17 = false;
        do {
            synchronizedObject = SnapshotStateMapKt.sync;
            synchronized (synchronizedObject) {
                try {
                    StateMapStateRecord stateMapStateRecord = (StateMapStateRecord) SnapshotKt.current((StateMapStateRecord) getFirstStateRecord(), Snapshot.INSTANCE.getCurrent());
                    map$runtime_release = stateMapStateRecord.getMap$runtime_release();
                    modification = stateMapStateRecord.getModification();
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                } catch (Throwable th5) {
                    InlineMarker.finallyStart(1);
                    InlineMarker.finallyEnd(1);
                    throw th5;
                }
            }
            InlineMarker.finallyEnd(1);
            Intrinsics.checkNotNull(map$runtime_release);
            PersistentMap.Builder<K, V> builder = map$runtime_release.builder();
            for (Map.Entry<K, V> entry : entrySet()) {
                if (predicate.invoke(entry).booleanValue()) {
                    builder.remove(entry.getKey());
                    z17 = true;
                }
            }
            Unit unit2 = Unit.INSTANCE;
            PersistentMap<K, V> build = builder.build();
            if (Intrinsics.areEqual(build, map$runtime_release)) {
                break;
            }
            synchronizedObject2 = SnapshotStateMapKt.sync;
            synchronized (synchronizedObject2) {
                try {
                    StateMapStateRecord stateMapStateRecord2 = (StateMapStateRecord) getFirstStateRecord();
                    SnapshotKt.getSnapshotInitializer();
                    synchronized (SnapshotKt.getLock()) {
                        try {
                            current = Snapshot.INSTANCE.getCurrent();
                            StateMapStateRecord stateMapStateRecord3 = (StateMapStateRecord) SnapshotKt.writableRecord(stateMapStateRecord2, this, current);
                            if (stateMapStateRecord3.getModification() == modification) {
                                stateMapStateRecord3.setMap$runtime_release(build);
                                stateMapStateRecord3.setModification$runtime_release(stateMapStateRecord3.getModification() + 1);
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            InlineMarker.finallyStart(1);
                        } finally {
                        }
                    }
                    InlineMarker.finallyEnd(1);
                    SnapshotKt.notifyWrite(current, this);
                    InlineMarker.finallyStart(1);
                } catch (Throwable th6) {
                    InlineMarker.finallyStart(1);
                    InlineMarker.finallyEnd(1);
                    throw th6;
                }
            }
            InlineMarker.finallyEnd(1);
        } while (!z16);
        return z17;
    }

    public final boolean removeValue$runtime_release(V value) {
        Object obj;
        Iterator<T> it = entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((Map.Entry) obj).getValue(), value)) {
                break;
            }
        }
        Map.Entry entry = (Map.Entry) obj;
        if (entry == null) {
            return false;
        }
        remove(entry.getKey());
        return true;
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return getValues();
    }

    public static /* synthetic */ void getDebuggerDisplayValue$annotations() {
    }

    public static /* synthetic */ void getReadable$runtime_release$annotations() {
    }
}
