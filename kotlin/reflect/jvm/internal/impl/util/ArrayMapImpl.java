package kotlin.reflect.jvm.internal.impl.util;

import java.util.Arrays;
import java.util.Iterator;
import kotlin.collections.AbstractIterator;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class ArrayMapImpl<T> extends ArrayMap<T> {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private Object[] data;
    private int size;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }
    }

    ArrayMapImpl(Object[] objArr, int i3) {
        super(null);
        this.data = objArr;
        this.size = i3;
    }

    private final void ensureCapacity(int i3) {
        Object[] objArr = this.data;
        if (objArr.length <= i3) {
            Object[] copyOf = Arrays.copyOf(objArr, objArr.length * 2);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.data = copyOf;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap
    @Nullable
    public T get(int i3) {
        Object orNull;
        orNull = ArraysKt___ArraysKt.getOrNull(this.data, i3);
        return (T) orNull;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap
    public int getSize() {
        return this.size;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap, java.lang.Iterable
    @NotNull
    public Iterator<T> iterator() {
        return new AbstractIterator<T>(this) { // from class: kotlin.reflect.jvm.internal.impl.util.ArrayMapImpl$iterator$1
            private int index = -1;
            final /* synthetic */ ArrayMapImpl<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.this$0 = this;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.collections.AbstractIterator
            protected void computeNext() {
                Object[] objArr;
                Object[] objArr2;
                Object[] objArr3;
                Object[] objArr4;
                do {
                    int i3 = this.index + 1;
                    this.index = i3;
                    objArr = ((ArrayMapImpl) this.this$0).data;
                    if (i3 >= objArr.length) {
                        break;
                    } else {
                        objArr4 = ((ArrayMapImpl) this.this$0).data;
                    }
                } while (objArr4[this.index] == null);
                int i16 = this.index;
                objArr2 = ((ArrayMapImpl) this.this$0).data;
                if (i16 < objArr2.length) {
                    objArr3 = ((ArrayMapImpl) this.this$0).data;
                    Object obj = objArr3[this.index];
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of org.jetbrains.kotlin.util.ArrayMapImpl");
                    setNext(obj);
                    return;
                }
                done();
            }
        };
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap
    public void set(int i3, @NotNull T value) {
        Intrinsics.checkNotNullParameter(value, "value");
        ensureCapacity(i3);
        if (this.data[i3] == null) {
            this.size = getSize() + 1;
        }
        this.data[i3] = value;
    }

    public ArrayMapImpl() {
        this(new Object[20], 0);
    }
}
