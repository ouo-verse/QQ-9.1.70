package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010'\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004B)\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00028\u0000\u0012\u0006\u0010\b\u001a\u00028\u0001\u00a2\u0006\u0002\u0010\tJ\u0015\u0010\f\u001a\u00028\u00012\u0006\u0010\u000f\u001a\u00028\u0001H\u0016\u00a2\u0006\u0002\u0010\u0010R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u00028\u0001X\u0096\u000e\u00a2\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/MutableMapEntry;", "K", "V", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/MapEntry;", "", "parentIterator", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilderEntriesIterator;", "key", "value", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilderEntriesIterator;Ljava/lang/Object;Ljava/lang/Object;)V", HippyTextInputController.COMMAND_getValue, "()Ljava/lang/Object;", HippyTextInputController.COMMAND_setValue, "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "newValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes39.dex */
public final class MutableMapEntry<K, V> extends MapEntry<K, V> implements KMutableMap.Entry {
    private final PersistentHashMapBuilderEntriesIterator<K, V> parentIterator;
    private V value;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MutableMapEntry(PersistentHashMapBuilderEntriesIterator<K, V> parentIterator, K k3, V v3) {
        super(k3, v3);
        Intrinsics.checkNotNullParameter(parentIterator, "parentIterator");
        this.parentIterator = parentIterator;
        this.value = v3;
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.MapEntry, java.util.Map.Entry
    public V getValue() {
        return this.value;
    }

    @Override // java.util.Map.Entry
    public void setValue(V v3) {
        this.value = v3;
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.MapEntry, java.util.Map.Entry
    public V setValue(V newValue) {
        V value = getValue();
        setValue((MutableMapEntry<K, V>) newValue);
        this.parentIterator.setValue(getKey(), newValue);
        return value;
    }
}
