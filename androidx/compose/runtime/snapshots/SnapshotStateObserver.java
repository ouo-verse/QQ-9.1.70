package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.SynchronizationKt;
import androidx.compose.runtime.SynchronizedObject;
import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.collection.IdentityScopeMap;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0007\u0018\u00002\u00020\u0001:\u0001+B.\u0012'\u0010\u0002\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\u0002\u0010\tJ\b\u0010\u0019\u001a\u00020\u0005H\u0002J\u0006\u0010\u001a\u001a\u00020\u0005J\u000e\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0001J)\u0010\u001c\u001a\u00020\u00052!\u0010\u001d\u001a\u001d\u0012\u0013\u0012\u00110\u0001\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00170\u0003J,\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001f0\f\"\b\b\u0000\u0010\u001f*\u00020\u00012\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u0002H\u001f\u0012\u0004\u0012\u00020\u00050\u0003H\u0002J\u001c\u0010!\u001a\u00020\u00052\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00010\u00112\u0006\u0010#\u001a\u00020\u0012J?\u0010$\u001a\u00020\u0005\"\b\b\u0000\u0010\u001f*\u00020\u00012\u0006\u0010\u001b\u001a\u0002H\u001f2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u0002H\u001f\u0012\u0004\u0012\u00020\u00050\u00032\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0002\u0010'J\u0006\u0010(\u001a\u00020\u0005J\u0006\u0010)\u001a\u00020\u0005J\u0016\u0010*\u001a\u00020\u00052\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007R\u0018\u0010\n\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R&\u0010\u000f\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0011\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00050\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0002\b\u0003\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R/\u0010\u0002\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006,"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "", "onChangedExecutor", "Lkotlin/Function1;", "Lkotlin/Function0;", "", "Lkotlin/ParameterName;", "name", "callback", "(Lkotlin/jvm/functions/Function1;)V", "applyMaps", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/runtime/snapshots/SnapshotStateObserver$ApplyMap;", "applyMapsLock", "Landroidx/compose/runtime/SynchronizedObject;", "applyObserver", "Lkotlin/Function2;", "", "Landroidx/compose/runtime/snapshots/Snapshot;", "applyUnsubscribe", "Landroidx/compose/runtime/snapshots/ObserverHandle;", "currentMap", "isPaused", "", "readObserver", "callOnChanged", QCircleLpReportDc05507.KEY_CLEAR, "scope", "clearIf", "predicate", "ensureMap", "T", "onChanged", "notifyChanges", "changes", "snapshot", "observeReads", "onValueChangedForScope", "block", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "start", "stop", "withNoObservations", "ApplyMap", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes39.dex */
public final class SnapshotStateObserver {
    public static final int $stable = 8;
    private final MutableVector<ApplyMap<?>> applyMaps;
    private final SynchronizedObject applyMapsLock;
    private final Function2<Set<? extends Object>, Snapshot, Unit> applyObserver;
    private ObserverHandle applyUnsubscribe;
    private ApplyMap<?> currentMap;
    private boolean isPaused;
    private final Function1<Function0<Unit>, Unit> onChangedExecutor;
    private final Function1<Object, Unit> readObserver;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u001e\n\u0000\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u0019\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0002J\u0014\u0010\u001a\u001a\u00020\u00052\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u001cR\u001e\u0010\u0007\u001a\u0004\u0018\u00018\u0000X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR!\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u000ej\b\u0012\u0004\u0012\u00020\u0002`\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001d"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateObserver$ApplyMap;", "T", "", "onChanged", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "currentScope", "getCurrentScope", "()Ljava/lang/Object;", "setCurrentScope", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "invalidated", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getInvalidated", "()Ljava/util/HashSet;", "map", "Landroidx/compose/runtime/collection/IdentityScopeMap;", "getMap", "()Landroidx/compose/runtime/collection/IdentityScopeMap;", "getOnChanged", "()Lkotlin/jvm/functions/Function1;", "addValue", "value", "callOnChanged", "scopes", "", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes39.dex */
    public static final class ApplyMap<T> {
        private T currentScope;
        private final HashSet<Object> invalidated;
        private final IdentityScopeMap<T> map;
        private final Function1<T, Unit> onChanged;

        /* JADX WARN: Multi-variable type inference failed */
        public ApplyMap(Function1<? super T, Unit> onChanged) {
            Intrinsics.checkNotNullParameter(onChanged, "onChanged");
            this.onChanged = onChanged;
            this.map = new IdentityScopeMap<>();
            this.invalidated = new HashSet<>();
        }

        public final void addValue(Object value) {
            Intrinsics.checkNotNullParameter(value, "value");
            IdentityScopeMap<T> identityScopeMap = this.map;
            T t16 = this.currentScope;
            Intrinsics.checkNotNull(t16);
            identityScopeMap.add(value, t16);
        }

        public final void callOnChanged(Collection<? extends Object> scopes) {
            Intrinsics.checkNotNullParameter(scopes, "scopes");
            Iterator<T> it = scopes.iterator();
            while (it.hasNext()) {
                this.onChanged.invoke(it.next());
            }
        }

        public final T getCurrentScope() {
            return this.currentScope;
        }

        public final HashSet<Object> getInvalidated() {
            return this.invalidated;
        }

        public final IdentityScopeMap<T> getMap() {
            return this.map;
        }

        public final Function1<T, Unit> getOnChanged() {
            return this.onChanged;
        }

        public final void setCurrentScope(T t16) {
            this.currentScope = t16;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SnapshotStateObserver(Function1<? super Function0<Unit>, Unit> onChangedExecutor) {
        Intrinsics.checkNotNullParameter(onChangedExecutor, "onChangedExecutor");
        this.onChangedExecutor = onChangedExecutor;
        this.applyObserver = new Function2<Set<? extends Object>, Snapshot, Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$applyObserver$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Set<? extends Object> set, Snapshot snapshot) {
                invoke2(set, snapshot);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Set<? extends Object> applied, Snapshot snapshot) {
                SynchronizedObject synchronizedObject;
                MutableVector mutableVector;
                int i3;
                Function1 function1;
                Intrinsics.checkNotNullParameter(applied, "applied");
                Intrinsics.checkNotNullParameter(snapshot, "<anonymous parameter 1>");
                synchronizedObject = SnapshotStateObserver.this.applyMapsLock;
                SnapshotStateObserver snapshotStateObserver = SnapshotStateObserver.this;
                synchronized (synchronizedObject) {
                    mutableVector = snapshotStateObserver.applyMaps;
                    int size = mutableVector.getSize();
                    i3 = 0;
                    if (size > 0) {
                        Object[] content = mutableVector.getContent();
                        int i16 = 0;
                        do {
                            SnapshotStateObserver.ApplyMap applyMap = (SnapshotStateObserver.ApplyMap) content[i3];
                            HashSet<Object> invalidated = applyMap.getInvalidated();
                            IdentityScopeMap map = applyMap.getMap();
                            Iterator<? extends Object> it = applied.iterator();
                            while (it.hasNext()) {
                                int find = map.find(it.next());
                                if (find >= 0) {
                                    Iterator<T> it5 = map.scopeSetAt(find).iterator();
                                    while (it5.hasNext()) {
                                        invalidated.add(it5.next());
                                        i16 = 1;
                                    }
                                }
                            }
                            i3++;
                        } while (i3 < size);
                        i3 = i16;
                    }
                    Unit unit = Unit.INSTANCE;
                }
                if (i3 != 0) {
                    function1 = SnapshotStateObserver.this.onChangedExecutor;
                    final SnapshotStateObserver snapshotStateObserver2 = SnapshotStateObserver.this;
                    function1.invoke(new Function0<Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$applyObserver$1.2
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
                            SnapshotStateObserver.this.callOnChanged();
                        }
                    });
                }
            }
        };
        this.readObserver = new Function1<Object, Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$readObserver$1
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
            public final void invoke2(Object state) {
                boolean z16;
                SynchronizedObject synchronizedObject;
                SnapshotStateObserver.ApplyMap applyMap;
                Intrinsics.checkNotNullParameter(state, "state");
                z16 = SnapshotStateObserver.this.isPaused;
                if (z16) {
                    return;
                }
                synchronizedObject = SnapshotStateObserver.this.applyMapsLock;
                SnapshotStateObserver snapshotStateObserver = SnapshotStateObserver.this;
                synchronized (synchronizedObject) {
                    applyMap = snapshotStateObserver.currentMap;
                    Intrinsics.checkNotNull(applyMap);
                    applyMap.addValue(state);
                    Unit unit = Unit.INSTANCE;
                }
            }
        };
        this.applyMaps = new MutableVector<>(new ApplyMap[16], 0);
        this.applyMapsLock = SynchronizationKt.createSynchronizedObject();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void callOnChanged() {
        MutableVector<ApplyMap<?>> mutableVector = this.applyMaps;
        int size = mutableVector.getSize();
        if (size > 0) {
            ApplyMap<?>[] content = mutableVector.getContent();
            int i3 = 0;
            do {
                ApplyMap<?> applyMap = content[i3];
                HashSet<Object> invalidated = applyMap.getInvalidated();
                if (!invalidated.isEmpty()) {
                    applyMap.callOnChanged(invalidated);
                    invalidated.clear();
                }
                i3++;
            } while (i3 < size);
        }
    }

    private final <T> ApplyMap<T> ensureMap(Function1<? super T, Unit> onChanged) {
        int i3;
        MutableVector<ApplyMap<?>> mutableVector = this.applyMaps;
        int size = mutableVector.getSize();
        if (size > 0) {
            ApplyMap[] content = mutableVector.getContent();
            i3 = 0;
            do {
                if (content[i3].getOnChanged() == onChanged) {
                    break;
                }
                i3++;
            } while (i3 < size);
        }
        i3 = -1;
        if (i3 == -1) {
            ApplyMap<T> applyMap = new ApplyMap<>(onChanged);
            this.applyMaps.add(applyMap);
            return applyMap;
        }
        return (ApplyMap) this.applyMaps.getContent()[i3];
    }

    public final void clear(Object scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        synchronized (this.applyMapsLock) {
            MutableVector<ApplyMap<?>> mutableVector = this.applyMaps;
            int size = mutableVector.getSize();
            if (size > 0) {
                ApplyMap<?>[] content = mutableVector.getContent();
                int i3 = 0;
                do {
                    IdentityScopeMap<?> map = content[i3].getMap();
                    int size2 = map.getSize();
                    int i16 = 0;
                    for (int i17 = 0; i17 < size2; i17++) {
                        int i18 = map.getValueOrder()[i17];
                        IdentityArraySet<?> identityArraySet = map.getScopeSets()[i18];
                        Intrinsics.checkNotNull(identityArraySet);
                        int size3 = identityArraySet.size();
                        int i19 = 0;
                        for (int i26 = 0; i26 < size3; i26++) {
                            Object obj = identityArraySet.getValues()[i26];
                            if (obj == null) {
                                throw new NullPointerException("null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                            }
                            if (!(obj == scope)) {
                                if (i19 != i26) {
                                    identityArraySet.getValues()[i19] = obj;
                                }
                                i19++;
                            }
                        }
                        int size4 = identityArraySet.size();
                        for (int i27 = i19; i27 < size4; i27++) {
                            identityArraySet.getValues()[i27] = null;
                        }
                        identityArraySet.setSize(i19);
                        if (identityArraySet.size() > 0) {
                            if (i16 != i17) {
                                int i28 = map.getValueOrder()[i16];
                                map.getValueOrder()[i16] = i18;
                                map.getValueOrder()[i17] = i28;
                            }
                            i16++;
                        }
                    }
                    int size5 = map.getSize();
                    for (int i29 = i16; i29 < size5; i29++) {
                        map.getValues()[map.getValueOrder()[i29]] = null;
                    }
                    map.setSize(i16);
                    i3++;
                } while (i3 < size);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void notifyChanges(Set<? extends Object> changes, Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(changes, "changes");
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        this.applyObserver.invoke(changes, snapshot);
    }

    public final <T> void observeReads(T scope, Function1<? super T, Unit> onValueChangedForScope, Function0<Unit> block) {
        ApplyMap<?> ensureMap;
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(onValueChangedForScope, "onValueChangedForScope");
        Intrinsics.checkNotNullParameter(block, "block");
        ApplyMap<?> applyMap = this.currentMap;
        boolean z16 = this.isPaused;
        synchronized (this.applyMapsLock) {
            ensureMap = ensureMap(onValueChangedForScope);
            ensureMap.getMap().removeScope(scope);
        }
        Object currentScope = ensureMap.getCurrentScope();
        ensureMap.setCurrentScope(scope);
        this.currentMap = ensureMap;
        this.isPaused = false;
        Snapshot.INSTANCE.observe(this.readObserver, null, block);
        this.currentMap = applyMap;
        ensureMap.setCurrentScope(currentScope);
        this.isPaused = z16;
    }

    public final void start() {
        this.applyUnsubscribe = Snapshot.INSTANCE.registerApplyObserver(this.applyObserver);
    }

    public final void stop() {
        ObserverHandle observerHandle = this.applyUnsubscribe;
        if (observerHandle != null) {
            observerHandle.dispose();
        }
    }

    @Deprecated(message = "Replace with Snapshot.withoutReadObservation()", replaceWith = @ReplaceWith(expression = "Snapshot.withoutReadObservation(block)", imports = {"androidx.compose.runtime.snapshots.Snapshot"}))
    public final void withNoObservations(Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        boolean z16 = this.isPaused;
        this.isPaused = true;
        try {
            block.invoke();
        } finally {
            this.isPaused = z16;
        }
    }

    public final void clearIf(Function1<Object, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        synchronized (this.applyMapsLock) {
            MutableVector<ApplyMap<?>> mutableVector = this.applyMaps;
            int size = mutableVector.getSize();
            if (size > 0) {
                ApplyMap<?>[] content = mutableVector.getContent();
                int i3 = 0;
                do {
                    IdentityScopeMap<?> map = content[i3].getMap();
                    int size2 = map.getSize();
                    int i16 = 0;
                    for (int i17 = 0; i17 < size2; i17++) {
                        int i18 = map.getValueOrder()[i17];
                        IdentityArraySet<?> identityArraySet = map.getScopeSets()[i18];
                        Intrinsics.checkNotNull(identityArraySet);
                        int size3 = identityArraySet.size();
                        int i19 = 0;
                        for (int i26 = 0; i26 < size3; i26++) {
                            Object obj = identityArraySet.getValues()[i26];
                            if (obj != null) {
                                if (!predicate.invoke(obj).booleanValue()) {
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
                                int i28 = map.getValueOrder()[i16];
                                map.getValueOrder()[i16] = i18;
                                map.getValueOrder()[i17] = i28;
                            }
                            i16++;
                        }
                    }
                    int size5 = map.getSize();
                    for (int i29 = i16; i29 < size5; i29++) {
                        map.getValues()[map.getValueOrder()[i29]] = null;
                    }
                    map.setSize(i16);
                    i3++;
                } while (i3 < size);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void clear() {
        synchronized (this.applyMapsLock) {
            MutableVector<ApplyMap<?>> mutableVector = this.applyMaps;
            int size = mutableVector.getSize();
            if (size > 0) {
                ApplyMap<?>[] content = mutableVector.getContent();
                int i3 = 0;
                do {
                    content[i3].getMap().clear();
                    i3++;
                } while (i3 < size);
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
