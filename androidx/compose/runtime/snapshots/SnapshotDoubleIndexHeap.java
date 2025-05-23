package androidx.compose.runtime.snapshots;

import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0004H\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\b\b\u0002\u0010\u0016\u001a\u00020\u0004J\u000e\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0004J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u0018\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004H\u0002J\u0006\u0010\u001d\u001a\u00020\u0011J\u0016\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotDoubleIndexHeap;", "", "()V", "firstFreeHandle", "", "handles", "", "index", "<set-?>", "size", "getSize", "()I", "values", "add", "value", "allocateHandle", "ensure", "", "atLeast", "freeHandle", "handle", "lowestOrDefault", "default", "remove", "shiftDown", "shiftUp", "swap", "a", "b", "validate", "validateHandle", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes39.dex */
public final class SnapshotDoubleIndexHeap {
    private int firstFreeHandle;
    private int[] handles;
    private int size;
    private int[] values = new int[16];
    private int[] index = new int[16];

    public SnapshotDoubleIndexHeap() {
        int[] iArr = new int[16];
        int i3 = 0;
        while (i3 < 16) {
            int i16 = i3 + 1;
            iArr[i3] = i16;
            i3 = i16;
        }
        this.handles = iArr;
    }

    private final int allocateHandle() {
        int length = this.handles.length;
        if (this.firstFreeHandle >= length) {
            int i3 = length * 2;
            int[] iArr = new int[i3];
            int i16 = 0;
            while (i16 < i3) {
                int i17 = i16 + 1;
                iArr[i16] = i17;
                i16 = i17;
            }
            ArraysKt___ArraysJvmKt.copyInto$default(this.handles, iArr, 0, 0, 0, 14, (Object) null);
            this.handles = iArr;
        }
        int i18 = this.firstFreeHandle;
        this.firstFreeHandle = this.handles[i18];
        return i18;
    }

    private final void ensure(int atLeast) {
        int[] iArr = this.values;
        int length = iArr.length;
        if (atLeast <= length) {
            return;
        }
        int i3 = length * 2;
        int[] iArr2 = new int[i3];
        int[] iArr3 = new int[i3];
        ArraysKt___ArraysJvmKt.copyInto$default(iArr, iArr2, 0, 0, 0, 14, (Object) null);
        ArraysKt___ArraysJvmKt.copyInto$default(this.index, iArr3, 0, 0, 0, 14, (Object) null);
        this.values = iArr2;
        this.index = iArr3;
    }

    private final void freeHandle(int handle) {
        this.handles[handle] = this.firstFreeHandle;
        this.firstFreeHandle = handle;
    }

    private final void shiftDown(int index) {
        int i3;
        int[] iArr = this.values;
        int i16 = this.size >> 1;
        while (index < i16) {
            int i17 = (index + 1) << 1;
            int i18 = i17 - 1;
            if (i17 < this.size && (i3 = iArr[i17]) < iArr[i18]) {
                if (i3 >= iArr[index]) {
                    return;
                }
                swap(i17, index);
                index = i17;
            } else {
                if (iArr[i18] >= iArr[index]) {
                    return;
                }
                swap(i18, index);
                index = i18;
            }
        }
    }

    private final void shiftUp(int index) {
        int[] iArr = this.values;
        int i3 = iArr[index];
        while (index > 0) {
            int i16 = ((index + 1) >> 1) - 1;
            if (iArr[i16] <= i3) {
                return;
            }
            swap(i16, index);
            index = i16;
        }
    }

    private final void swap(int a16, int b16) {
        int[] iArr = this.values;
        int[] iArr2 = this.index;
        int[] iArr3 = this.handles;
        int i3 = iArr[a16];
        iArr[a16] = iArr[b16];
        iArr[b16] = i3;
        int i16 = iArr2[a16];
        iArr2[a16] = iArr2[b16];
        iArr2[b16] = i16;
        iArr3[iArr2[a16]] = a16;
        iArr3[iArr2[b16]] = b16;
    }

    public final int add(int value) {
        ensure(this.size + 1);
        int i3 = this.size;
        this.size = i3 + 1;
        int allocateHandle = allocateHandle();
        this.values[i3] = value;
        this.index[i3] = allocateHandle;
        this.handles[allocateHandle] = i3;
        shiftUp(i3);
        return allocateHandle;
    }

    public final int getSize() {
        return this.size;
    }

    public final int lowestOrDefault(int r26) {
        return this.size > 0 ? this.values[0] : r26;
    }

    public final void remove(int handle) {
        int i3 = this.handles[handle];
        swap(i3, this.size - 1);
        this.size--;
        shiftUp(i3);
        shiftDown(i3);
        freeHandle(handle);
    }

    public final void validate() {
        int i3 = this.size;
        int i16 = 1;
        while (i16 < i3) {
            int i17 = i16 + 1;
            int[] iArr = this.values;
            if (iArr[(i17 >> 1) - 1] > iArr[i16]) {
                throw new IllegalStateException(("Index " + i16 + " is out of place").toString());
            }
            i16 = i17;
        }
    }

    public final void validateHandle(int handle, int value) {
        int i3 = this.handles[handle];
        if (this.index[i3] == handle) {
            if (this.values[i3] == value) {
                return;
            }
            throw new IllegalStateException(("Value for handle " + handle + " was " + this.values[i3] + " but was supposed to be " + value).toString());
        }
        throw new IllegalStateException(("Index for handle " + handle + " is corrupted").toString());
    }

    public static /* synthetic */ int lowestOrDefault$default(SnapshotDoubleIndexHeap snapshotDoubleIndexHeap, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = 0;
        }
        return snapshotDoubleIndexHeap.lowestOrDefault(i3);
    }
}
