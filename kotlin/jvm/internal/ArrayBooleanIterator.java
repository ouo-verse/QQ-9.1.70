package kotlin.jvm.internal;

import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.BooleanIterator;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0018\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\bH\u0096\u0002J\b\u0010\t\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lkotlin/jvm/internal/ArrayBooleanIterator;", "Lkotlin/collections/BooleanIterator;", HippyControllerProps.ARRAY, "", "([Z)V", "index", "", "hasNext", "", "nextBoolean", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes28.dex */
final class ArrayBooleanIterator extends BooleanIterator {

    @NotNull
    private final boolean[] array;
    private int index;

    public ArrayBooleanIterator(@NotNull boolean[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        this.array = array;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.index < this.array.length) {
            return true;
        }
        return false;
    }

    @Override // kotlin.collections.BooleanIterator
    public boolean nextBoolean() {
        try {
            boolean[] zArr = this.array;
            int i3 = this.index;
            this.index = i3 + 1;
            return zArr[i3];
        } catch (ArrayIndexOutOfBoundsException e16) {
            this.index--;
            throw new NoSuchElementException(e16.getMessage());
        }
    }
}
