package kotlin.script.dependencies;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u001c\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a4\u0010\u0000\u001a\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0002\u001a/\u0010\u0007\u001a\u00020\u0001\"\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00032\b\u0010\u0004\u001a\u0004\u0018\u0001H\u00022\b\u0010\u0006\u001a\u0004\u0018\u0001H\u0002H\u0002\u00a2\u0006\u0002\u0010\b\u001a\u001b\u0010\t\u001a\u00020\u0001*\u00020\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0082\b\u00a8\u0006\f"}, d2 = {"compareIterables", "", "T", "", "a", "", "b", "compareValues", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)I", "chainCompare", "compFn", "Lkotlin/Function0;", "kotlin-script-runtime"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes38.dex */
public final class Dependencies_deprecatedKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final <T extends Comparable<? super T>> int compareIterables(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        int compareValues;
        Iterator<? extends T> it = iterable.iterator();
        Iterator<? extends T> it5 = iterable2.iterator();
        do {
            if (it.hasNext() && !it5.hasNext()) {
                return 1;
            }
            if (!it.hasNext() && !it5.hasNext()) {
                return 0;
            }
            if (!it.hasNext()) {
                return -1;
            }
            compareValues = compareValues(it.next(), it5.next());
        } while (compareValues == 0);
        return compareValues;
    }

    private static final int chainCompare(int i3, Function0<Integer> function0) {
        return i3 != 0 ? i3 : function0.invoke().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T extends Comparable<?>> int compareValues(T t16, T t17) {
        if (t16 == t17) {
            return 0;
        }
        if (t16 == null) {
            return -1;
        }
        if (t17 == null) {
            return 1;
        }
        return t16.compareTo(t17);
    }
}
