package androidx.compose.runtime;

import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\u0007R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Landroidx/compose/runtime/PrioritySet;", "", "list", "", "", "(Ljava/util/List;)V", "add", "", "value", "isEmpty", "", "isNotEmpty", "peek", "takeMax", "validateHeap", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes39.dex */
public final class PrioritySet {
    private final List<Integer> list;

    public PrioritySet() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final void add(int value) {
        if (!this.list.isEmpty()) {
            if (this.list.get(0).intValue() == value) {
                return;
            }
            if (this.list.get(r0.size() - 1).intValue() == value) {
                return;
            }
        }
        int size = this.list.size();
        this.list.add(Integer.valueOf(value));
        while (size > 0) {
            int i3 = ((size + 1) >>> 1) - 1;
            int intValue = this.list.get(i3).intValue();
            if (value <= intValue) {
                break;
            }
            this.list.set(size, Integer.valueOf(intValue));
            size = i3;
        }
        this.list.set(size, Integer.valueOf(value));
    }

    public final boolean isEmpty() {
        return this.list.isEmpty();
    }

    public final boolean isNotEmpty() {
        return !this.list.isEmpty();
    }

    public final int peek() {
        Object first;
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) this.list);
        return ((Number) first).intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int takeMax() {
        Object last;
        int intValue;
        if (this.list.size() > 0) {
            int intValue2 = this.list.get(0).intValue();
            while ((!this.list.isEmpty()) && this.list.get(0).intValue() == intValue2) {
                List<Integer> list = this.list;
                last = CollectionsKt___CollectionsKt.last((List<? extends Object>) list);
                list.set(0, last);
                List<Integer> list2 = this.list;
                list2.remove(list2.size() - 1);
                int size = this.list.size();
                int size2 = this.list.size() >>> 1;
                int i3 = 0;
                while (i3 < size2) {
                    int intValue3 = this.list.get(i3).intValue();
                    int i16 = (i3 + 1) * 2;
                    int i17 = i16 - 1;
                    int intValue4 = this.list.get(i17).intValue();
                    if (i16 >= size || (intValue = this.list.get(i16).intValue()) <= intValue4) {
                        if (intValue4 > intValue3) {
                            this.list.set(i3, Integer.valueOf(intValue4));
                            this.list.set(i17, Integer.valueOf(intValue3));
                            i3 = i17;
                        }
                    } else if (intValue > intValue3) {
                        this.list.set(i3, Integer.valueOf(intValue));
                        this.list.set(i16, Integer.valueOf(intValue3));
                        i3 = i16;
                    }
                }
            }
            return intValue2;
        }
        ComposerKt.composeRuntimeError("Set is empty".toString());
        throw new KotlinNothingValueException();
    }

    public final void validateHeap() {
        int size = this.list.size();
        int i3 = size / 2;
        int i16 = 0;
        while (i16 < i3) {
            int i17 = i16 + 1;
            int i18 = i17 * 2;
            boolean z16 = true;
            if (this.list.get(i16).intValue() >= this.list.get(i18 + (-1)).intValue()) {
                if (i18 < size && this.list.get(i16).intValue() < this.list.get(i18).intValue()) {
                    z16 = false;
                }
                if (!z16) {
                    throw new IllegalStateException("Check failed.".toString());
                }
                i16 = i17;
            } else {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
    }

    public PrioritySet(List<Integer> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.list = list;
    }

    public /* synthetic */ PrioritySet(List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new ArrayList() : list);
    }
}
