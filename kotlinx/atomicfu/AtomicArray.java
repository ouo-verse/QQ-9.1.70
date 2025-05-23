package kotlinx.atomicfu;

import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0019\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\b2\u0006\u0010\u000f\u001a\u00020\u0004H\u0087\u0002R\u001e\u0010\u0006\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\b0\u0007X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\tR\u001a\u0010\u0003\u001a\u00020\u00048FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lkotlinx/atomicfu/AtomicArray;", "T", "", "size", "", "(I)V", HippyControllerProps.ARRAY, "", "Lkotlinx/atomicfu/AtomicRef;", "[Lkotlinx/atomicfu/AtomicRef;", "getSize$annotations", "()V", "getSize", "()I", "get", "index", "atomicfu"}, k = 1, mv = {1, 4, 3})
/* loaded from: classes28.dex */
public final class AtomicArray<T> {
    private final AtomicRef<T>[] array;

    public AtomicArray(int i3) {
        AtomicRef<T>[] atomicRefArr = new AtomicRef[i3];
        for (int i16 = 0; i16 < i3; i16++) {
            atomicRefArr[i16] = AtomicFU.atomic((Object) null);
        }
        this.array = atomicRefArr;
    }

    @NotNull
    public final AtomicRef<T> get(int index) {
        return this.array[index];
    }

    public final int getSize() {
        return this.array.length;
    }

    public static /* synthetic */ void getSize$annotations() {
    }
}
