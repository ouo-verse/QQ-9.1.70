package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.SynchronizedObject;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import androidx.compose.runtime.snapshots.Snapshot;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableList;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010+\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003:\u0001MB\u0005\u00a2\u0006\u0002\u0010\u0004J\u0015\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u001dJ\u001d\u0010\u001a\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010 J\u001e\u0010!\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u00102\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016J\u0016\u0010!\u001a\u00020\u001b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016J\b\u0010$\u001a\u00020\u001eH\u0016J)\u0010%\u001a\u00020\u001b2\u001e\u0010&\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000(\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000(0'H\u0082\bJ\u0016\u0010)\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0002\u0010\u001dJ\u0016\u0010*\u001a\u00020\u001b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016J\u0016\u0010+\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\u0010H\u0096\u0002\u00a2\u0006\u0002\u0010,J\u0015\u0010-\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010.J\b\u0010/\u001a\u00020\u001bH\u0016J\u000f\u00100\u001a\b\u0012\u0004\u0012\u00028\u000001H\u0096\u0002J\u0015\u00102\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010.J\u000e\u00103\u001a\b\u0012\u0004\u0012\u00028\u000004H\u0016J\u0016\u00103\u001a\b\u0012\u0004\u0012\u00028\u0000042\u0006\u0010\u001f\u001a\u00020\u0010H\u0016J.\u00105\u001a\u0002H6\"\u0004\b\u0001\u001062\u0018\u0010&\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u0002H60'H\u0082\b\u00a2\u0006\u0002\u00107J\"\u00108\u001a\u00020\u001b2\u0018\u0010&\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00020\u001b0'H\u0002J\u0010\u00109\u001a\u00020\u001e2\u0006\u0010:\u001a\u00020\u000bH\u0016J\u0015\u0010;\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u001dJ\u0016\u0010<\u001a\u00020\u001b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016J\u0015\u0010=\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\u0010H\u0016\u00a2\u0006\u0002\u0010,J\u0016\u0010>\u001a\u00020\u001e2\u0006\u0010?\u001a\u00020\u00102\u0006\u0010@\u001a\u00020\u0010J\u0016\u0010A\u001a\u00020\u001b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016J+\u0010B\u001a\u00020\u00102\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#2\u0006\u0010C\u001a\u00020\u00102\u0006\u0010D\u001a\u00020\u0010H\u0000\u00a2\u0006\u0002\bEJ\u001e\u0010F\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0002\u0010GJ\u001e\u0010H\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010?\u001a\u00020\u00102\u0006\u0010@\u001a\u00020\u0010H\u0016J)\u0010I\u001a\u00020\u001e2\u001e\u0010&\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000(\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000(0'H\u0082\bJ3\u0010J\u001a\u0002H6\"\u0004\b\u0001\u001062\u001d\u0010&\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0014\u0012\u0004\u0012\u0002H60'\u00a2\u0006\u0002\bKH\u0082\b\u00a2\u0006\u0002\u00107J3\u0010L\u001a\u0002H6\"\u0004\b\u0001\u001062\u001d\u0010&\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0014\u0012\u0004\u0012\u0002H60'\u00a2\u0006\u0002\bKH\u0082\b\u00a2\u0006\u0002\u00107R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068AX\u0080\u0004\u00a2\u0006\f\u0012\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\tR\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@RX\u0096\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00148@X\u0080\u0004\u00a2\u0006\f\u0012\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00108VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u0012\u00a8\u0006N"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateList;", "T", "", "Landroidx/compose/runtime/snapshots/StateObject;", "()V", "debuggerDisplayValue", "", "getDebuggerDisplayValue$annotations", "getDebuggerDisplayValue", "()Ljava/util/List;", "<set-?>", "Landroidx/compose/runtime/snapshots/StateRecord;", "firstStateRecord", "getFirstStateRecord", "()Landroidx/compose/runtime/snapshots/StateRecord;", "modification", "", "getModification$runtime_release", "()I", "readable", "Landroidx/compose/runtime/snapshots/SnapshotStateList$StateListStateRecord;", "getReadable$runtime_release$annotations", "getReadable$runtime_release", "()Landroidx/compose/runtime/snapshots/SnapshotStateList$StateListStateRecord;", "size", "getSize", "add", "", DTConstants.TAG.ELEMENT, "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", DTParamKey.REPORT_KEY_VISUAL_ELEMENTS, "", QCircleLpReportDc05507.KEY_CLEAR, "conditionalUpdate", "block", "Lkotlin/Function1;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "contains", "containsAll", "get", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "mutate", BdhLogUtil.LogTag.Tag_Req, "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "mutateBoolean", "prependStateRecord", "value", "remove", "removeAll", "removeAt", "removeRange", "fromIndex", "toIndex", "retainAll", "retainAllInRange", "start", "end", "retainAllInRange$runtime_release", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "update", "withCurrent", "Lkotlin/ExtensionFunctionType;", "writable", "StateListStateRecord", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes39.dex */
public final class SnapshotStateList<T> implements List<T>, StateObject, KMutableList {
    private StateRecord firstStateRecord = new StateListStateRecord(ExtensionsKt.persistentListOf());

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B\u0015\b\u0000\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\u00a2\u0006\u0002\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0002H\u0016R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u001a\u0010\t\u001a\u00020\nX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateList$StateListStateRecord;", "T", "Landroidx/compose/runtime/snapshots/StateRecord;", "list", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;)V", "getList$runtime_release", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "setList$runtime_release", "modification", "", "getModification$runtime_release", "()I", "setModification$runtime_release", "(I)V", "assign", "", "value", OperateCustomButton.OPERATE_CREATE, "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes39.dex */
    public static final class StateListStateRecord<T> extends StateRecord {
        private PersistentList<? extends T> list;
        private int modification;

        public StateListStateRecord(PersistentList<? extends T> list) {
            Intrinsics.checkNotNullParameter(list, "list");
            this.list = list;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public void assign(StateRecord value) {
            SynchronizedObject synchronizedObject;
            Intrinsics.checkNotNullParameter(value, "value");
            synchronizedObject = SnapshotStateListKt.sync;
            synchronized (synchronizedObject) {
                this.list = ((StateListStateRecord) value).list;
                this.modification = ((StateListStateRecord) value).modification;
                Unit unit = Unit.INSTANCE;
            }
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public StateRecord create() {
            return new StateListStateRecord(this.list);
        }

        public final PersistentList<T> getList$runtime_release() {
            return this.list;
        }

        /* renamed from: getModification$runtime_release, reason: from getter */
        public final int getModification() {
            return this.modification;
        }

        public final void setList$runtime_release(PersistentList<? extends T> persistentList) {
            Intrinsics.checkNotNullParameter(persistentList, "<set-?>");
            this.list = persistentList;
        }

        public final void setModification$runtime_release(int i3) {
            this.modification = i3;
        }
    }

    private final boolean conditionalUpdate(Function1<? super PersistentList<? extends T>, ? extends PersistentList<? extends T>> block) {
        SynchronizedObject synchronizedObject;
        Snapshot.Companion companion;
        int modification;
        PersistentList<T> list$runtime_release;
        boolean z16;
        SynchronizedObject synchronizedObject2;
        Snapshot current;
        do {
            synchronizedObject = SnapshotStateListKt.sync;
            synchronized (synchronizedObject) {
                try {
                    StateListStateRecord stateListStateRecord = (StateListStateRecord) getFirstStateRecord();
                    companion = Snapshot.INSTANCE;
                    StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.current(stateListStateRecord, companion.getCurrent());
                    modification = stateListStateRecord2.getModification();
                    list$runtime_release = stateListStateRecord2.getList$runtime_release();
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                } catch (Throwable th5) {
                    InlineMarker.finallyStart(1);
                    InlineMarker.finallyEnd(1);
                    throw th5;
                }
            }
            InlineMarker.finallyEnd(1);
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList<? extends T> invoke = block.invoke(list$runtime_release);
            z16 = false;
            if (Intrinsics.areEqual(invoke, list$runtime_release)) {
                return false;
            }
            synchronizedObject2 = SnapshotStateListKt.sync;
            synchronized (synchronizedObject2) {
                try {
                    StateListStateRecord stateListStateRecord3 = (StateListStateRecord) getFirstStateRecord();
                    SnapshotKt.getSnapshotInitializer();
                    synchronized (SnapshotKt.getLock()) {
                        try {
                            current = companion.getCurrent();
                            StateListStateRecord stateListStateRecord4 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord3, this, current);
                            if (stateListStateRecord4.getModification() == modification) {
                                stateListStateRecord4.setList$runtime_release(invoke);
                                stateListStateRecord4.setModification$runtime_release(stateListStateRecord4.getModification() + 1);
                                z16 = true;
                            }
                            InlineMarker.finallyStart(1);
                        } catch (Throwable th6) {
                            InlineMarker.finallyStart(1);
                            InlineMarker.finallyEnd(1);
                            throw th6;
                        }
                    }
                    InlineMarker.finallyEnd(1);
                    SnapshotKt.notifyWrite(current, this);
                    InlineMarker.finallyStart(1);
                } catch (Throwable th7) {
                    InlineMarker.finallyStart(1);
                    InlineMarker.finallyEnd(1);
                    throw th7;
                }
            }
            InlineMarker.finallyEnd(1);
        } while (!z16);
        return true;
    }

    private final <R> R mutate(Function1<? super List<T>, ? extends R> block) {
        SynchronizedObject synchronizedObject;
        Snapshot.Companion companion;
        int modification;
        PersistentList<T> list$runtime_release;
        R invoke;
        SynchronizedObject synchronizedObject2;
        Snapshot current;
        boolean z16;
        do {
            synchronizedObject = SnapshotStateListKt.sync;
            synchronized (synchronizedObject) {
                try {
                    StateListStateRecord stateListStateRecord = (StateListStateRecord) getFirstStateRecord();
                    companion = Snapshot.INSTANCE;
                    StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.current(stateListStateRecord, companion.getCurrent());
                    modification = stateListStateRecord2.getModification();
                    list$runtime_release = stateListStateRecord2.getList$runtime_release();
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                } catch (Throwable th5) {
                    InlineMarker.finallyStart(1);
                    InlineMarker.finallyEnd(1);
                    throw th5;
                }
            }
            InlineMarker.finallyEnd(1);
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList.Builder<T> builder = list$runtime_release.builder();
            invoke = block.invoke(builder);
            PersistentList<T> build = builder.build();
            if (Intrinsics.areEqual(build, list$runtime_release)) {
                break;
            }
            synchronizedObject2 = SnapshotStateListKt.sync;
            synchronized (synchronizedObject2) {
                try {
                    StateListStateRecord stateListStateRecord3 = (StateListStateRecord) getFirstStateRecord();
                    SnapshotKt.getSnapshotInitializer();
                    synchronized (SnapshotKt.getLock()) {
                        try {
                            current = companion.getCurrent();
                            StateListStateRecord stateListStateRecord4 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord3, this, current);
                            if (stateListStateRecord4.getModification() == modification) {
                                stateListStateRecord4.setList$runtime_release(build);
                                stateListStateRecord4.setModification$runtime_release(stateListStateRecord4.getModification() + 1);
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

    private final boolean mutateBoolean(Function1<? super List<T>, Boolean> block) {
        SynchronizedObject synchronizedObject;
        Snapshot.Companion companion;
        int modification;
        PersistentList<T> list$runtime_release;
        Boolean invoke;
        SynchronizedObject synchronizedObject2;
        Snapshot current;
        boolean z16;
        do {
            synchronizedObject = SnapshotStateListKt.sync;
            synchronized (synchronizedObject) {
                StateListStateRecord stateListStateRecord = (StateListStateRecord) getFirstStateRecord();
                companion = Snapshot.INSTANCE;
                StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.current(stateListStateRecord, companion.getCurrent());
                modification = stateListStateRecord2.getModification();
                list$runtime_release = stateListStateRecord2.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList.Builder<T> builder = list$runtime_release.builder();
            invoke = block.invoke(builder);
            PersistentList<T> build = builder.build();
            if (Intrinsics.areEqual(build, list$runtime_release)) {
                break;
            }
            synchronizedObject2 = SnapshotStateListKt.sync;
            synchronized (synchronizedObject2) {
                StateListStateRecord stateListStateRecord3 = (StateListStateRecord) getFirstStateRecord();
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    current = companion.getCurrent();
                    StateListStateRecord stateListStateRecord4 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord3, this, current);
                    if (stateListStateRecord4.getModification() == modification) {
                        stateListStateRecord4.setList$runtime_release(build);
                        z16 = true;
                        stateListStateRecord4.setModification$runtime_release(stateListStateRecord4.getModification() + 1);
                    } else {
                        z16 = false;
                    }
                }
                SnapshotKt.notifyWrite(current, this);
            }
        } while (!z16);
        return invoke.booleanValue();
    }

    private final void update(Function1<? super PersistentList<? extends T>, ? extends PersistentList<? extends T>> block) {
        SynchronizedObject synchronizedObject;
        Snapshot.Companion companion;
        int modification;
        PersistentList<T> list$runtime_release;
        SynchronizedObject synchronizedObject2;
        Snapshot current;
        boolean z16;
        do {
            synchronizedObject = SnapshotStateListKt.sync;
            synchronized (synchronizedObject) {
                try {
                    StateListStateRecord stateListStateRecord = (StateListStateRecord) getFirstStateRecord();
                    companion = Snapshot.INSTANCE;
                    StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.current(stateListStateRecord, companion.getCurrent());
                    modification = stateListStateRecord2.getModification();
                    list$runtime_release = stateListStateRecord2.getList$runtime_release();
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                } catch (Throwable th5) {
                    InlineMarker.finallyStart(1);
                    InlineMarker.finallyEnd(1);
                    throw th5;
                }
            }
            InlineMarker.finallyEnd(1);
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList<? extends T> invoke = block.invoke(list$runtime_release);
            if (Intrinsics.areEqual(invoke, list$runtime_release)) {
                return;
            }
            synchronizedObject2 = SnapshotStateListKt.sync;
            synchronized (synchronizedObject2) {
                try {
                    StateListStateRecord stateListStateRecord3 = (StateListStateRecord) getFirstStateRecord();
                    SnapshotKt.getSnapshotInitializer();
                    synchronized (SnapshotKt.getLock()) {
                        try {
                            current = companion.getCurrent();
                            StateListStateRecord stateListStateRecord4 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord3, this, current);
                            if (stateListStateRecord4.getModification() == modification) {
                                stateListStateRecord4.setList$runtime_release(invoke);
                                stateListStateRecord4.setModification$runtime_release(stateListStateRecord4.getModification() + 1);
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            InlineMarker.finallyStart(1);
                        } catch (Throwable th6) {
                            InlineMarker.finallyStart(1);
                            InlineMarker.finallyEnd(1);
                            throw th6;
                        }
                    }
                    InlineMarker.finallyEnd(1);
                    SnapshotKt.notifyWrite(current, this);
                    InlineMarker.finallyStart(1);
                } catch (Throwable th7) {
                    InlineMarker.finallyStart(1);
                    InlineMarker.finallyEnd(1);
                    throw th7;
                }
            }
            InlineMarker.finallyEnd(1);
        } while (!z16);
    }

    private final <R> R withCurrent(Function1<? super StateListStateRecord<T>, ? extends R> block) {
        return block.invoke(SnapshotKt.current((StateListStateRecord) getFirstStateRecord(), Snapshot.INSTANCE.getCurrent()));
    }

    private final <R> R writable(Function1<? super StateListStateRecord<T>, ? extends R> block) {
        Snapshot current;
        R invoke;
        StateListStateRecord stateListStateRecord = (StateListStateRecord) getFirstStateRecord();
        SnapshotKt.getSnapshotInitializer();
        synchronized (SnapshotKt.getLock()) {
            try {
                current = Snapshot.INSTANCE.getCurrent();
                invoke = block.invoke(SnapshotKt.writableRecord(stateListStateRecord, this, current));
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

    @Override // java.util.List, java.util.Collection
    public boolean add(T element) {
        SynchronizedObject synchronizedObject;
        Snapshot.Companion companion;
        int modification;
        PersistentList<T> list$runtime_release;
        boolean z16;
        SynchronizedObject synchronizedObject2;
        Snapshot current;
        do {
            synchronizedObject = SnapshotStateListKt.sync;
            synchronized (synchronizedObject) {
                StateListStateRecord stateListStateRecord = (StateListStateRecord) getFirstStateRecord();
                companion = Snapshot.INSTANCE;
                StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.current(stateListStateRecord, companion.getCurrent());
                modification = stateListStateRecord2.getModification();
                list$runtime_release = stateListStateRecord2.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList<T> add = list$runtime_release.add((PersistentList<T>) element);
            z16 = false;
            if (Intrinsics.areEqual(add, list$runtime_release)) {
                return false;
            }
            synchronizedObject2 = SnapshotStateListKt.sync;
            synchronized (synchronizedObject2) {
                StateListStateRecord stateListStateRecord3 = (StateListStateRecord) getFirstStateRecord();
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    current = companion.getCurrent();
                    StateListStateRecord stateListStateRecord4 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord3, this, current);
                    if (stateListStateRecord4.getModification() == modification) {
                        stateListStateRecord4.setList$runtime_release(add);
                        stateListStateRecord4.setModification$runtime_release(stateListStateRecord4.getModification() + 1);
                        z16 = true;
                    }
                }
                SnapshotKt.notifyWrite(current, this);
            }
        } while (!z16);
        return true;
    }

    @Override // java.util.List
    public boolean addAll(final int index, final Collection<? extends T> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return mutateBoolean(new Function1<List<T>, Boolean>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateList$addAll$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(List<T> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it.addAll(index, elements));
            }
        });
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        SynchronizedObject synchronizedObject;
        Snapshot current;
        synchronizedObject = SnapshotStateListKt.sync;
        synchronized (synchronizedObject) {
            StateListStateRecord stateListStateRecord = (StateListStateRecord) getFirstStateRecord();
            SnapshotKt.getSnapshotInitializer();
            synchronized (SnapshotKt.getLock()) {
                current = Snapshot.INSTANCE.getCurrent();
                StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord, this, current);
                stateListStateRecord2.setList$runtime_release(ExtensionsKt.persistentListOf());
                stateListStateRecord2.setModification$runtime_release(stateListStateRecord2.getModification() + 1);
            }
            SnapshotKt.notifyWrite(current, this);
        }
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object element) {
        return getReadable$runtime_release().getList$runtime_release().contains(element);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return getReadable$runtime_release().getList$runtime_release().containsAll(elements);
    }

    @Override // java.util.List
    public T get(int index) {
        return getReadable$runtime_release().getList$runtime_release().get(index);
    }

    public final List<T> getDebuggerDisplayValue() {
        return ((StateListStateRecord) SnapshotKt.current((StateListStateRecord) getFirstStateRecord(), Snapshot.INSTANCE.getCurrent())).getList$runtime_release();
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public StateRecord getFirstStateRecord() {
        return this.firstStateRecord;
    }

    public final int getModification$runtime_release() {
        return ((StateListStateRecord) SnapshotKt.current((StateListStateRecord) getFirstStateRecord(), Snapshot.INSTANCE.getCurrent())).getModification();
    }

    public final StateListStateRecord<T> getReadable$runtime_release() {
        return (StateListStateRecord) SnapshotKt.readable((StateListStateRecord) getFirstStateRecord(), this);
    }

    public int getSize() {
        return getReadable$runtime_release().getList$runtime_release().size();
    }

    @Override // java.util.List
    public int indexOf(Object element) {
        return getReadable$runtime_release().getList$runtime_release().indexOf(element);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return getReadable$runtime_release().getList$runtime_release().isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return listIterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object element) {
        return getReadable$runtime_release().getList$runtime_release().lastIndexOf(element);
    }

    @Override // java.util.List
    public ListIterator<T> listIterator() {
        return new StateListIterator(this, 0);
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public /* synthetic */ StateRecord mergeRecords(StateRecord stateRecord, StateRecord stateRecord2, StateRecord stateRecord3) {
        return a.a(this, stateRecord, stateRecord2, stateRecord3);
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public void prependStateRecord(StateRecord value) {
        Intrinsics.checkNotNullParameter(value, "value");
        value.setNext$runtime_release(getFirstStateRecord());
        this.firstStateRecord = (StateListStateRecord) value;
    }

    @Override // java.util.List
    public final /* bridge */ T remove(int i3) {
        return removeAt(i3);
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<? extends Object> elements) {
        SynchronizedObject synchronizedObject;
        Snapshot.Companion companion;
        int modification;
        PersistentList<T> list$runtime_release;
        boolean z16;
        SynchronizedObject synchronizedObject2;
        Snapshot current;
        Intrinsics.checkNotNullParameter(elements, "elements");
        do {
            synchronizedObject = SnapshotStateListKt.sync;
            synchronized (synchronizedObject) {
                StateListStateRecord stateListStateRecord = (StateListStateRecord) getFirstStateRecord();
                companion = Snapshot.INSTANCE;
                StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.current(stateListStateRecord, companion.getCurrent());
                modification = stateListStateRecord2.getModification();
                list$runtime_release = stateListStateRecord2.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList<T> removeAll = list$runtime_release.removeAll((Collection<? extends T>) elements);
            z16 = false;
            if (Intrinsics.areEqual(removeAll, list$runtime_release)) {
                return false;
            }
            synchronizedObject2 = SnapshotStateListKt.sync;
            synchronized (synchronizedObject2) {
                StateListStateRecord stateListStateRecord3 = (StateListStateRecord) getFirstStateRecord();
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    current = companion.getCurrent();
                    StateListStateRecord stateListStateRecord4 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord3, this, current);
                    if (stateListStateRecord4.getModification() == modification) {
                        stateListStateRecord4.setList$runtime_release(removeAll);
                        stateListStateRecord4.setModification$runtime_release(stateListStateRecord4.getModification() + 1);
                        z16 = true;
                    }
                }
                SnapshotKt.notifyWrite(current, this);
            }
        } while (!z16);
        return true;
    }

    public T removeAt(int index) {
        SynchronizedObject synchronizedObject;
        Snapshot.Companion companion;
        int modification;
        PersistentList<T> list$runtime_release;
        SynchronizedObject synchronizedObject2;
        Snapshot current;
        boolean z16;
        T t16 = get(index);
        do {
            synchronizedObject = SnapshotStateListKt.sync;
            synchronized (synchronizedObject) {
                StateListStateRecord stateListStateRecord = (StateListStateRecord) getFirstStateRecord();
                companion = Snapshot.INSTANCE;
                StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.current(stateListStateRecord, companion.getCurrent());
                modification = stateListStateRecord2.getModification();
                list$runtime_release = stateListStateRecord2.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList<T> removeAt = list$runtime_release.removeAt(index);
            if (Intrinsics.areEqual(removeAt, list$runtime_release)) {
                break;
            }
            synchronizedObject2 = SnapshotStateListKt.sync;
            synchronized (synchronizedObject2) {
                StateListStateRecord stateListStateRecord3 = (StateListStateRecord) getFirstStateRecord();
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    current = companion.getCurrent();
                    StateListStateRecord stateListStateRecord4 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord3, this, current);
                    if (stateListStateRecord4.getModification() == modification) {
                        stateListStateRecord4.setList$runtime_release(removeAt);
                        z16 = true;
                        stateListStateRecord4.setModification$runtime_release(stateListStateRecord4.getModification() + 1);
                    } else {
                        z16 = false;
                    }
                }
                SnapshotKt.notifyWrite(current, this);
            }
        } while (!z16);
        return t16;
    }

    public final void removeRange(int fromIndex, int toIndex) {
        SynchronizedObject synchronizedObject;
        Snapshot.Companion companion;
        int modification;
        PersistentList<T> list$runtime_release;
        SynchronizedObject synchronizedObject2;
        Snapshot current;
        boolean z16;
        do {
            synchronizedObject = SnapshotStateListKt.sync;
            synchronized (synchronizedObject) {
                StateListStateRecord stateListStateRecord = (StateListStateRecord) getFirstStateRecord();
                companion = Snapshot.INSTANCE;
                StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.current(stateListStateRecord, companion.getCurrent());
                modification = stateListStateRecord2.getModification();
                list$runtime_release = stateListStateRecord2.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList.Builder<T> builder = list$runtime_release.builder();
            builder.subList(fromIndex, toIndex).clear();
            PersistentList<T> build = builder.build();
            if (Intrinsics.areEqual(build, list$runtime_release)) {
                return;
            }
            synchronizedObject2 = SnapshotStateListKt.sync;
            synchronized (synchronizedObject2) {
                StateListStateRecord stateListStateRecord3 = (StateListStateRecord) getFirstStateRecord();
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    current = companion.getCurrent();
                    StateListStateRecord stateListStateRecord4 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord3, this, current);
                    if (stateListStateRecord4.getModification() == modification) {
                        stateListStateRecord4.setList$runtime_release(build);
                        z16 = true;
                        stateListStateRecord4.setModification$runtime_release(stateListStateRecord4.getModification() + 1);
                    } else {
                        z16 = false;
                    }
                }
                SnapshotKt.notifyWrite(current, this);
            }
        } while (!z16);
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(final Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return mutateBoolean(new Function1<List<T>, Boolean>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateList$retainAll$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(List<T> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it.retainAll(elements));
            }
        });
    }

    public final int retainAllInRange$runtime_release(Collection<? extends T> elements, int start, int end) {
        SynchronizedObject synchronizedObject;
        Snapshot.Companion companion;
        int modification;
        PersistentList<T> list$runtime_release;
        SynchronizedObject synchronizedObject2;
        Snapshot current;
        boolean z16;
        Intrinsics.checkNotNullParameter(elements, "elements");
        int size = size();
        do {
            synchronizedObject = SnapshotStateListKt.sync;
            synchronized (synchronizedObject) {
                StateListStateRecord stateListStateRecord = (StateListStateRecord) getFirstStateRecord();
                companion = Snapshot.INSTANCE;
                StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.current(stateListStateRecord, companion.getCurrent());
                modification = stateListStateRecord2.getModification();
                list$runtime_release = stateListStateRecord2.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList.Builder<T> builder = list$runtime_release.builder();
            builder.subList(start, end).retainAll(elements);
            PersistentList<T> build = builder.build();
            if (Intrinsics.areEqual(build, list$runtime_release)) {
                break;
            }
            synchronizedObject2 = SnapshotStateListKt.sync;
            synchronized (synchronizedObject2) {
                StateListStateRecord stateListStateRecord3 = (StateListStateRecord) getFirstStateRecord();
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    current = companion.getCurrent();
                    StateListStateRecord stateListStateRecord4 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord3, this, current);
                    if (stateListStateRecord4.getModification() == modification) {
                        stateListStateRecord4.setList$runtime_release(build);
                        z16 = true;
                        stateListStateRecord4.setModification$runtime_release(stateListStateRecord4.getModification() + 1);
                    } else {
                        z16 = false;
                    }
                }
                SnapshotKt.notifyWrite(current, this);
            }
        } while (!z16);
        return size - size();
    }

    @Override // java.util.List
    public T set(int index, T element) {
        SynchronizedObject synchronizedObject;
        Snapshot.Companion companion;
        int modification;
        PersistentList<T> list$runtime_release;
        SynchronizedObject synchronizedObject2;
        Snapshot current;
        boolean z16;
        T t16 = get(index);
        do {
            synchronizedObject = SnapshotStateListKt.sync;
            synchronized (synchronizedObject) {
                StateListStateRecord stateListStateRecord = (StateListStateRecord) getFirstStateRecord();
                companion = Snapshot.INSTANCE;
                StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.current(stateListStateRecord, companion.getCurrent());
                modification = stateListStateRecord2.getModification();
                list$runtime_release = stateListStateRecord2.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList<T> persistentList = list$runtime_release.set(index, (int) element);
            if (Intrinsics.areEqual(persistentList, list$runtime_release)) {
                break;
            }
            synchronizedObject2 = SnapshotStateListKt.sync;
            synchronized (synchronizedObject2) {
                StateListStateRecord stateListStateRecord3 = (StateListStateRecord) getFirstStateRecord();
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    current = companion.getCurrent();
                    StateListStateRecord stateListStateRecord4 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord3, this, current);
                    if (stateListStateRecord4.getModification() == modification) {
                        stateListStateRecord4.setList$runtime_release(persistentList);
                        z16 = true;
                        stateListStateRecord4.setModification$runtime_release(stateListStateRecord4.getModification() + 1);
                    } else {
                        z16 = false;
                    }
                }
                SnapshotKt.notifyWrite(current, this);
            }
        } while (!z16);
        return t16;
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends T> elements) {
        SynchronizedObject synchronizedObject;
        Snapshot.Companion companion;
        int modification;
        PersistentList<T> list$runtime_release;
        boolean z16;
        SynchronizedObject synchronizedObject2;
        Snapshot current;
        Intrinsics.checkNotNullParameter(elements, "elements");
        do {
            synchronizedObject = SnapshotStateListKt.sync;
            synchronized (synchronizedObject) {
                StateListStateRecord stateListStateRecord = (StateListStateRecord) getFirstStateRecord();
                companion = Snapshot.INSTANCE;
                StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.current(stateListStateRecord, companion.getCurrent());
                modification = stateListStateRecord2.getModification();
                list$runtime_release = stateListStateRecord2.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList<T> addAll = list$runtime_release.addAll(elements);
            z16 = false;
            if (Intrinsics.areEqual(addAll, list$runtime_release)) {
                return false;
            }
            synchronizedObject2 = SnapshotStateListKt.sync;
            synchronized (synchronizedObject2) {
                StateListStateRecord stateListStateRecord3 = (StateListStateRecord) getFirstStateRecord();
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    current = companion.getCurrent();
                    StateListStateRecord stateListStateRecord4 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord3, this, current);
                    if (stateListStateRecord4.getModification() == modification) {
                        stateListStateRecord4.setList$runtime_release(addAll);
                        stateListStateRecord4.setModification$runtime_release(stateListStateRecord4.getModification() + 1);
                        z16 = true;
                    }
                }
                SnapshotKt.notifyWrite(current, this);
            }
        } while (!z16);
        return true;
    }

    @Override // java.util.List
    public ListIterator<T> listIterator(int index) {
        return new StateListIterator(this, index);
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object element) {
        SynchronizedObject synchronizedObject;
        Snapshot.Companion companion;
        int modification;
        PersistentList<T> list$runtime_release;
        boolean z16;
        SynchronizedObject synchronizedObject2;
        Snapshot current;
        do {
            synchronizedObject = SnapshotStateListKt.sync;
            synchronized (synchronizedObject) {
                StateListStateRecord stateListStateRecord = (StateListStateRecord) getFirstStateRecord();
                companion = Snapshot.INSTANCE;
                StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.current(stateListStateRecord, companion.getCurrent());
                modification = stateListStateRecord2.getModification();
                list$runtime_release = stateListStateRecord2.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList<T> remove = list$runtime_release.remove((PersistentList<T>) element);
            z16 = false;
            if (Intrinsics.areEqual(remove, list$runtime_release)) {
                return false;
            }
            synchronizedObject2 = SnapshotStateListKt.sync;
            synchronized (synchronizedObject2) {
                StateListStateRecord stateListStateRecord3 = (StateListStateRecord) getFirstStateRecord();
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    current = companion.getCurrent();
                    StateListStateRecord stateListStateRecord4 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord3, this, current);
                    if (stateListStateRecord4.getModification() == modification) {
                        stateListStateRecord4.setList$runtime_release(remove);
                        stateListStateRecord4.setModification$runtime_release(stateListStateRecord4.getModification() + 1);
                        z16 = true;
                    }
                }
                SnapshotKt.notifyWrite(current, this);
            }
        } while (!z16);
        return true;
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return (T[]) CollectionToArray.toArray(this, array);
    }

    @Override // java.util.List
    public List<T> subList(int fromIndex, int toIndex) {
        if ((fromIndex >= 0 && fromIndex <= toIndex) && toIndex <= size()) {
            return new SubList(this, fromIndex, toIndex);
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public static /* synthetic */ void getDebuggerDisplayValue$annotations() {
    }

    public static /* synthetic */ void getReadable$runtime_release$annotations() {
    }

    @Override // java.util.List
    public void add(int index, T element) {
        SynchronizedObject synchronizedObject;
        Snapshot.Companion companion;
        int modification;
        PersistentList<T> list$runtime_release;
        SynchronizedObject synchronizedObject2;
        Snapshot current;
        boolean z16;
        do {
            synchronizedObject = SnapshotStateListKt.sync;
            synchronized (synchronizedObject) {
                StateListStateRecord stateListStateRecord = (StateListStateRecord) getFirstStateRecord();
                companion = Snapshot.INSTANCE;
                StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.current(stateListStateRecord, companion.getCurrent());
                modification = stateListStateRecord2.getModification();
                list$runtime_release = stateListStateRecord2.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList<T> add = list$runtime_release.add(index, (int) element);
            if (Intrinsics.areEqual(add, list$runtime_release)) {
                return;
            }
            synchronizedObject2 = SnapshotStateListKt.sync;
            synchronized (synchronizedObject2) {
                StateListStateRecord stateListStateRecord3 = (StateListStateRecord) getFirstStateRecord();
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    current = companion.getCurrent();
                    StateListStateRecord stateListStateRecord4 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord3, this, current);
                    if (stateListStateRecord4.getModification() == modification) {
                        stateListStateRecord4.setList$runtime_release(add);
                        z16 = true;
                        stateListStateRecord4.setModification$runtime_release(stateListStateRecord4.getModification() + 1);
                    } else {
                        z16 = false;
                    }
                }
                SnapshotKt.notifyWrite(current, this);
            }
        } while (!z16);
    }
}
