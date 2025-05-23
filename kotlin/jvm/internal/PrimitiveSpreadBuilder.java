package kotlin.jvm.internal;

import kotlin.Metadata;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\t\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0013\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0004H\u0004J\u001d\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00028\u0000H\u0004\u00a2\u0006\u0002\u0010\u0016J\u0011\u0010\u0017\u001a\u00020\u0004*\u00028\u0000H$\u00a2\u0006\u0002\u0010\u0018R\u001a\u0010\u0006\u001a\u00020\u0004X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0005R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u000bX\u0082\u0004\u00a2\u0006\n\n\u0002\u0010\u000e\u0012\u0004\b\f\u0010\r\u00a8\u0006\u0019"}, d2 = {"Lkotlin/jvm/internal/PrimitiveSpreadBuilder;", "T", "", "size", "", "(I)V", "position", "getPosition", "()I", "setPosition", "spreads", "", "getSpreads$annotations", "()V", "[Ljava/lang/Object;", "addSpread", "", "spreadArgument", "(Ljava/lang/Object;)V", "toArray", "values", "result", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "getSize", "(Ljava/lang/Object;)I", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes28.dex */
public abstract class PrimitiveSpreadBuilder<T> {
    private int position;
    private final int size;

    @NotNull
    private final T[] spreads;

    public PrimitiveSpreadBuilder(int i3) {
        this.size = i3;
        this.spreads = (T[]) new Object[i3];
    }

    public final void addSpread(@NotNull T spreadArgument) {
        Intrinsics.checkNotNullParameter(spreadArgument, "spreadArgument");
        T[] tArr = this.spreads;
        int i3 = this.position;
        this.position = i3 + 1;
        tArr[i3] = spreadArgument;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getPosition() {
        return this.position;
    }

    protected abstract int getSize(@NotNull T t16);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setPosition(int i3) {
        this.position = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    public final int size() {
        int i3;
        int i16 = 0;
        ?? it = new IntRange(0, this.size - 1).iterator();
        while (it.hasNext()) {
            T t16 = this.spreads[it.nextInt()];
            if (t16 != null) {
                i3 = getSize(t16);
            } else {
                i3 = 1;
            }
            i16 += i3;
        }
        return i16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Type inference failed for: r0v3, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @NotNull
    public final T toArray(@NotNull T values, @NotNull T result) {
        Intrinsics.checkNotNullParameter(values, "values");
        Intrinsics.checkNotNullParameter(result, "result");
        ?? it = new IntRange(0, this.size - 1).iterator();
        int i3 = 0;
        int i16 = 0;
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            T t16 = this.spreads[nextInt];
            if (t16 != null) {
                if (i3 < nextInt) {
                    int i17 = nextInt - i3;
                    System.arraycopy(values, i3, result, i16, i17);
                    i16 += i17;
                }
                int size = getSize(t16);
                System.arraycopy(t16, 0, result, i16, size);
                i16 += size;
                i3 = nextInt + 1;
            }
        }
        int i18 = this.size;
        if (i3 < i18) {
            System.arraycopy(values, i3, result, i16, i18 - i3);
        }
        return result;
    }

    private static /* synthetic */ void getSpreads$annotations() {
    }
}
