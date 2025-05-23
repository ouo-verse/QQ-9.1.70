package kotlinx.atomicfu;

import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0011\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0003H\u0087\u0002R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\bR\u001a\u0010\u0002\u001a\u00020\u00038FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lkotlinx/atomicfu/AtomicLongArray;", "", "size", "", "(I)V", HippyControllerProps.ARRAY, "", "Lkotlinx/atomicfu/AtomicLong;", "[Lkotlinx/atomicfu/AtomicLong;", "getSize$annotations", "()V", "getSize", "()I", "get", "index", "atomicfu"}, k = 1, mv = {1, 4, 3})
/* loaded from: classes28.dex */
public final class AtomicLongArray {
    private final AtomicLong[] array;

    public AtomicLongArray(int i3) {
        AtomicLong[] atomicLongArr = new AtomicLong[i3];
        for (int i16 = 0; i16 < i3; i16++) {
            atomicLongArr[i16] = AtomicFU.atomic(0L);
        }
        this.array = atomicLongArr;
    }

    @NotNull
    public final AtomicLong get(int index) {
        return this.array[index];
    }

    public final int getSize() {
        return this.array.length;
    }

    public static /* synthetic */ void getSize$annotations() {
    }
}
