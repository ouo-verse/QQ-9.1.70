package kotlin.collections;

import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@SinceKotlin(version = "1.4")
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0007\u0018\u0000 P*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001PB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0006B\u0015\b\u0016\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u00a2\u0006\u0002\u0010\tJ\u0015\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u0016J\u001d\u0010\u0013\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u0019J\u001e\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016J\u0016\u0010\u001a\u001a\u00020\u00142\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016J\u0013\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u001cJ\b\u0010\u001e\u001a\u00020\u0017H\u0016J\u0016\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0002\u0010\u0016J\u001e\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0002J\u0010\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u0004H\u0002J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0010\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u0004H\u0002J\u001d\u0010'\u001a\u00020\u00142\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00140)H\u0082\bJ\u000b\u0010*\u001a\u00028\u0000\u00a2\u0006\u0002\u0010+J\r\u0010,\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0002\u0010+J\u0016\u0010-\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u0004H\u0096\u0002\u00a2\u0006\u0002\u0010.J\u0010\u0010/\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0015\u00100\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u00101J\u0016\u00102\u001a\u00028\u00002\u0006\u0010!\u001a\u00020\u0004H\u0083\b\u00a2\u0006\u0002\u0010.J\u0011\u0010!\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0083\bJM\u00103\u001a\u00020\u00172>\u00104\u001a:\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(\u000e\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b\u00a2\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u001705H\u0000\u00a2\u0006\u0002\b8J\b\u00109\u001a\u00020\u0014H\u0016J\u000b\u0010:\u001a\u00028\u0000\u00a2\u0006\u0002\u0010+J\u0015\u0010;\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u00101J\r\u0010<\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0002\u0010+J\u0010\u0010=\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0010\u0010>\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0015\u0010?\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u0016J\u0016\u0010@\u001a\u00020\u00142\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016J\u0015\u0010A\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u0004H\u0016\u00a2\u0006\u0002\u0010.J\u000b\u0010B\u001a\u00028\u0000\u00a2\u0006\u0002\u0010+J\r\u0010C\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0002\u0010+J\u000b\u0010D\u001a\u00028\u0000\u00a2\u0006\u0002\u0010+J\r\u0010E\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0002\u0010+J\u0016\u0010F\u001a\u00020\u00142\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016J\u001e\u0010G\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0002\u0010HJ\u0017\u0010I\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bH\u0000\u00a2\u0006\u0004\bJ\u0010KJ)\u0010I\u001a\b\u0012\u0004\u0012\u0002HL0\u000b\"\u0004\b\u0001\u0010L2\f\u0010M\u001a\b\u0012\u0004\u0012\u0002HL0\u000bH\u0000\u00a2\u0006\u0004\bJ\u0010NJ\u0015\u0010O\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bH\u0016\u00a2\u0006\u0002\u0010KJ'\u0010O\u001a\b\u0012\u0004\u0012\u0002HL0\u000b\"\u0004\b\u0001\u0010L2\f\u0010M\u001a\b\u0012\u0004\u0012\u0002HL0\u000bH\u0016\u00a2\u0006\u0002\u0010NR\u0018\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004@RX\u0096\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006Q"}, d2 = {"Lkotlin/collections/ArrayDeque;", "E", "Lkotlin/collections/AbstractMutableList;", "initialCapacity", "", "(I)V", "()V", DTParamKey.REPORT_KEY_VISUAL_ELEMENTS, "", "(Ljava/util/Collection;)V", "elementData", "", "", "[Ljava/lang/Object;", "head", "<set-?>", "size", "getSize", "()I", "add", "", DTConstants.TAG.ELEMENT, "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "addFirst", "(Ljava/lang/Object;)V", "addLast", QCircleLpReportDc05507.KEY_CLEAR, "contains", "copyCollectionElements", "internalIndex", "copyElements", "newCapacity", "decremented", "ensureCapacity", "minCapacity", "filterInPlace", "predicate", "Lkotlin/Function1;", MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_FIRST, "()Ljava/lang/Object;", "firstOrNull", "get", "(I)Ljava/lang/Object;", "incremented", "indexOf", "(Ljava/lang/Object;)I", "internalGet", "internalStructure", "structure", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "internalStructure$kotlin_stdlib", "isEmpty", "last", "lastIndexOf", "lastOrNull", "negativeMod", "positiveMod", "remove", "removeAll", "removeAt", "removeFirst", "removeFirstOrNull", "removeLast", "removeLastOrNull", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "testToArray", "testToArray$kotlin_stdlib", "()[Ljava/lang/Object;", "T", HippyControllerProps.ARRAY, "([Ljava/lang/Object;)[Ljava/lang/Object;", "toArray", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
@WasExperimental(markerClass = {ExperimentalStdlibApi.class})
/* loaded from: classes28.dex */
public final class ArrayDeque<E> extends AbstractMutableList<E> {
    private static final int defaultMinCapacity = 10;
    private static final int maxArraySize = 2147483639;

    @NotNull
    private Object[] elementData;
    private int head;
    private int size;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Object[] emptyElementData = new Object[0];

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0007\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001d\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0000\u00a2\u0006\u0002\b\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lkotlin/collections/ArrayDeque$Companion;", "", "()V", "defaultMinCapacity", "", "emptyElementData", "", "[Ljava/lang/Object;", "maxArraySize", "newCapacity", "oldCapacity", "minCapacity", "newCapacity$kotlin_stdlib", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes28.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int newCapacity$kotlin_stdlib(int oldCapacity, int minCapacity) {
            int i3 = oldCapacity + (oldCapacity >> 1);
            if (i3 - minCapacity < 0) {
                i3 = minCapacity;
            }
            if (i3 - ArrayDeque.maxArraySize > 0) {
                if (minCapacity <= ArrayDeque.maxArraySize) {
                    return ArrayDeque.maxArraySize;
                }
                return Integer.MAX_VALUE;
            }
            return i3;
        }

        Companion() {
        }
    }

    public ArrayDeque(int i3) {
        Object[] objArr;
        if (i3 == 0) {
            objArr = emptyElementData;
        } else if (i3 > 0) {
            objArr = new Object[i3];
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + i3);
        }
        this.elementData = objArr;
    }

    private final void copyCollectionElements(int internalIndex, Collection<? extends E> elements) {
        Iterator<? extends E> it = elements.iterator();
        int length = this.elementData.length;
        while (internalIndex < length && it.hasNext()) {
            this.elementData[internalIndex] = it.next();
            internalIndex++;
        }
        int i3 = this.head;
        for (int i16 = 0; i16 < i3 && it.hasNext(); i16++) {
            this.elementData[i16] = it.next();
        }
        this.size = size() + elements.size();
    }

    private final void copyElements(int newCapacity) {
        Object[] objArr = new Object[newCapacity];
        Object[] objArr2 = this.elementData;
        ArraysKt___ArraysJvmKt.copyInto(objArr2, objArr, 0, this.head, objArr2.length);
        Object[] objArr3 = this.elementData;
        int length = objArr3.length;
        int i3 = this.head;
        ArraysKt___ArraysJvmKt.copyInto(objArr3, objArr, length - i3, 0, i3);
        this.head = 0;
        this.elementData = objArr;
    }

    private final int decremented(int index) {
        int lastIndex;
        if (index == 0) {
            lastIndex = ArraysKt___ArraysKt.getLastIndex(this.elementData);
            return lastIndex;
        }
        return index - 1;
    }

    private final void ensureCapacity(int minCapacity) {
        int coerceAtLeast;
        if (minCapacity >= 0) {
            Object[] objArr = this.elementData;
            if (minCapacity <= objArr.length) {
                return;
            }
            if (objArr == emptyElementData) {
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(minCapacity, 10);
                this.elementData = new Object[coerceAtLeast];
                return;
            } else {
                copyElements(INSTANCE.newCapacity$kotlin_stdlib(objArr.length, minCapacity));
                return;
            }
        }
        throw new IllegalStateException("Deque is too big.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean filterInPlace(Function1<? super E, Boolean> predicate) {
        byte b16;
        int positiveMod;
        boolean z16 = false;
        z16 = false;
        z16 = false;
        if (!isEmpty()) {
            if (this.elementData.length == 0) {
                b16 = true;
            } else {
                b16 = false;
            }
            if (b16 == false) {
                int positiveMod2 = positiveMod(this.head + size());
                int i3 = this.head;
                if (i3 < positiveMod2) {
                    positiveMod = i3;
                    while (i3 < positiveMod2) {
                        Object obj = this.elementData[i3];
                        if (predicate.invoke(obj).booleanValue()) {
                            this.elementData[positiveMod] = obj;
                            positiveMod++;
                        } else {
                            z16 = true;
                        }
                        i3++;
                    }
                    ArraysKt___ArraysJvmKt.fill(this.elementData, (Object) null, positiveMod, positiveMod2);
                } else {
                    int length = this.elementData.length;
                    boolean z17 = false;
                    int i16 = i3;
                    while (i3 < length) {
                        Object[] objArr = this.elementData;
                        Object obj2 = objArr[i3];
                        objArr[i3] = null;
                        if (predicate.invoke(obj2).booleanValue()) {
                            this.elementData[i16] = obj2;
                            i16++;
                        } else {
                            z17 = true;
                        }
                        i3++;
                    }
                    positiveMod = positiveMod(i16);
                    for (int i17 = 0; i17 < positiveMod2; i17++) {
                        Object[] objArr2 = this.elementData;
                        Object obj3 = objArr2[i17];
                        objArr2[i17] = null;
                        if (predicate.invoke(obj3).booleanValue()) {
                            this.elementData[positiveMod] = obj3;
                            positiveMod = incremented(positiveMod);
                        } else {
                            z17 = true;
                        }
                    }
                    z16 = z17;
                }
                if (z16) {
                    this.size = negativeMod(positiveMod - this.head);
                }
            }
        }
        return z16;
    }

    private final int incremented(int index) {
        int lastIndex;
        lastIndex = ArraysKt___ArraysKt.getLastIndex(this.elementData);
        if (index == lastIndex) {
            return 0;
        }
        return index + 1;
    }

    @InlineOnly
    private final E internalGet(int internalIndex) {
        return (E) this.elementData[internalIndex];
    }

    @InlineOnly
    private final int internalIndex(int index) {
        return positiveMod(this.head + index);
    }

    private final int negativeMod(int index) {
        if (index < 0) {
            return index + this.elementData.length;
        }
        return index;
    }

    private final int positiveMod(int index) {
        Object[] objArr = this.elementData;
        if (index >= objArr.length) {
            return index - objArr.length;
        }
        return index;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E element) {
        addLast(element);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(@NotNull Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements.isEmpty()) {
            return false;
        }
        ensureCapacity(size() + elements.size());
        copyCollectionElements(positiveMod(this.head + size()), elements);
        return true;
    }

    public final void addFirst(E element) {
        ensureCapacity(size() + 1);
        int decremented = decremented(this.head);
        this.head = decremented;
        this.elementData[decremented] = element;
        this.size = size() + 1;
    }

    public final void addLast(E element) {
        ensureCapacity(size() + 1);
        this.elementData[positiveMod(this.head + size())] = element;
        this.size = size() + 1;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        int positiveMod = positiveMod(this.head + size());
        int i3 = this.head;
        if (i3 < positiveMod) {
            ArraysKt___ArraysJvmKt.fill(this.elementData, (Object) null, i3, positiveMod);
        } else if (!isEmpty()) {
            Object[] objArr = this.elementData;
            ArraysKt___ArraysJvmKt.fill(objArr, (Object) null, this.head, objArr.length);
            ArraysKt___ArraysJvmKt.fill(this.elementData, (Object) null, 0, positiveMod);
        }
        this.head = 0;
        this.size = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object element) {
        if (indexOf(element) != -1) {
            return true;
        }
        return false;
    }

    public final E first() {
        if (!isEmpty()) {
            return (E) this.elementData[this.head];
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    @Nullable
    public final E firstOrNull() {
        if (isEmpty()) {
            return null;
        }
        return (E) this.elementData[this.head];
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int index) {
        AbstractList.INSTANCE.checkElementIndex$kotlin_stdlib(index, size());
        return (E) this.elementData[positiveMod(this.head + index)];
    }

    @Override // kotlin.collections.AbstractMutableList
    public int getSize() {
        return this.size;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object element) {
        int i3;
        int positiveMod = positiveMod(this.head + size());
        int i16 = this.head;
        if (i16 < positiveMod) {
            while (i16 < positiveMod) {
                if (Intrinsics.areEqual(element, this.elementData[i16])) {
                    i3 = this.head;
                } else {
                    i16++;
                }
            }
            return -1;
        }
        if (i16 >= positiveMod) {
            int length = this.elementData.length;
            while (true) {
                if (i16 < length) {
                    if (Intrinsics.areEqual(element, this.elementData[i16])) {
                        i3 = this.head;
                        break;
                    }
                    i16++;
                } else {
                    for (int i17 = 0; i17 < positiveMod; i17++) {
                        if (Intrinsics.areEqual(element, this.elementData[i17])) {
                            i16 = i17 + this.elementData.length;
                            i3 = this.head;
                        }
                    }
                    return -1;
                }
            }
        } else {
            return -1;
        }
        return i16 - i3;
    }

    public final void internalStructure$kotlin_stdlib(@NotNull Function2<? super Integer, ? super Object[], Unit> structure) {
        int i3;
        int i16;
        Intrinsics.checkNotNullParameter(structure, "structure");
        int positiveMod = positiveMod(this.head + size());
        if (!isEmpty() && (i16 = this.head) >= positiveMod) {
            i3 = i16 - this.elementData.length;
        } else {
            i3 = this.head;
        }
        structure.invoke(Integer.valueOf(i3), toArray());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    public final E last() {
        int lastIndex;
        if (!isEmpty()) {
            Object[] objArr = this.elementData;
            int i3 = this.head;
            lastIndex = CollectionsKt__CollectionsKt.getLastIndex(this);
            return (E) objArr[positiveMod(i3 + lastIndex)];
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object element) {
        int lastIndex;
        int i3;
        int positiveMod = positiveMod(this.head + size());
        int i16 = this.head;
        if (i16 < positiveMod) {
            lastIndex = positiveMod - 1;
            if (i16 <= lastIndex) {
                while (!Intrinsics.areEqual(element, this.elementData[lastIndex])) {
                    if (lastIndex != i16) {
                        lastIndex--;
                    }
                }
                i3 = this.head;
                return lastIndex - i3;
            }
            return -1;
        }
        if (i16 > positiveMod) {
            int i17 = positiveMod - 1;
            while (true) {
                if (-1 >= i17) {
                    lastIndex = ArraysKt___ArraysKt.getLastIndex(this.elementData);
                    int i18 = this.head;
                    if (i18 <= lastIndex) {
                        while (!Intrinsics.areEqual(element, this.elementData[lastIndex])) {
                            if (lastIndex != i18) {
                                lastIndex--;
                            }
                        }
                        i3 = this.head;
                    }
                } else {
                    if (Intrinsics.areEqual(element, this.elementData[i17])) {
                        lastIndex = i17 + this.elementData.length;
                        i3 = this.head;
                        break;
                    }
                    i17--;
                }
            }
        }
        return -1;
    }

    @Nullable
    public final E lastOrNull() {
        int lastIndex;
        if (isEmpty()) {
            return null;
        }
        Object[] objArr = this.elementData;
        int i3 = this.head;
        lastIndex = CollectionsKt__CollectionsKt.getLastIndex(this);
        return (E) objArr[positiveMod(i3 + lastIndex)];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object element) {
        int indexOf = indexOf(element);
        if (indexOf == -1) {
            return false;
        }
        remove(indexOf);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(@NotNull Collection<? extends Object> elements) {
        byte b16;
        int positiveMod;
        Intrinsics.checkNotNullParameter(elements, "elements");
        boolean z16 = false;
        z16 = false;
        z16 = false;
        if (!isEmpty()) {
            if (this.elementData.length == 0) {
                b16 = true;
            } else {
                b16 = false;
            }
            if (b16 == false) {
                int positiveMod2 = positiveMod(this.head + size());
                int i3 = this.head;
                if (i3 < positiveMod2) {
                    positiveMod = i3;
                    while (i3 < positiveMod2) {
                        Object obj = this.elementData[i3];
                        if (!elements.contains(obj)) {
                            this.elementData[positiveMod] = obj;
                            positiveMod++;
                        } else {
                            z16 = true;
                        }
                        i3++;
                    }
                    ArraysKt___ArraysJvmKt.fill(this.elementData, (Object) null, positiveMod, positiveMod2);
                } else {
                    int length = this.elementData.length;
                    boolean z17 = false;
                    int i16 = i3;
                    while (i3 < length) {
                        Object[] objArr = this.elementData;
                        Object obj2 = objArr[i3];
                        objArr[i3] = null;
                        if (!elements.contains(obj2)) {
                            this.elementData[i16] = obj2;
                            i16++;
                        } else {
                            z17 = true;
                        }
                        i3++;
                    }
                    positiveMod = positiveMod(i16);
                    for (int i17 = 0; i17 < positiveMod2; i17++) {
                        Object[] objArr2 = this.elementData;
                        Object obj3 = objArr2[i17];
                        objArr2[i17] = null;
                        if (!elements.contains(obj3)) {
                            this.elementData[positiveMod] = obj3;
                            positiveMod = incremented(positiveMod);
                        } else {
                            z17 = true;
                        }
                    }
                    z16 = z17;
                }
                if (z16) {
                    this.size = negativeMod(positiveMod - this.head);
                }
            }
        }
        return z16;
    }

    @Override // kotlin.collections.AbstractMutableList
    public E removeAt(int index) {
        int lastIndex;
        int lastIndex2;
        AbstractList.INSTANCE.checkElementIndex$kotlin_stdlib(index, size());
        lastIndex = CollectionsKt__CollectionsKt.getLastIndex(this);
        if (index == lastIndex) {
            return removeLast();
        }
        if (index == 0) {
            return removeFirst();
        }
        int positiveMod = positiveMod(this.head + index);
        E e16 = (E) this.elementData[positiveMod];
        if (index < (size() >> 1)) {
            int i3 = this.head;
            if (positiveMod >= i3) {
                Object[] objArr = this.elementData;
                ArraysKt___ArraysJvmKt.copyInto(objArr, objArr, i3 + 1, i3, positiveMod);
            } else {
                Object[] objArr2 = this.elementData;
                ArraysKt___ArraysJvmKt.copyInto(objArr2, objArr2, 1, 0, positiveMod);
                Object[] objArr3 = this.elementData;
                objArr3[0] = objArr3[objArr3.length - 1];
                int i16 = this.head;
                ArraysKt___ArraysJvmKt.copyInto(objArr3, objArr3, i16 + 1, i16, objArr3.length - 1);
            }
            Object[] objArr4 = this.elementData;
            int i17 = this.head;
            objArr4[i17] = null;
            this.head = incremented(i17);
        } else {
            int i18 = this.head;
            lastIndex2 = CollectionsKt__CollectionsKt.getLastIndex(this);
            int positiveMod2 = positiveMod(i18 + lastIndex2);
            if (positiveMod <= positiveMod2) {
                Object[] objArr5 = this.elementData;
                ArraysKt___ArraysJvmKt.copyInto(objArr5, objArr5, positiveMod, positiveMod + 1, positiveMod2 + 1);
            } else {
                Object[] objArr6 = this.elementData;
                ArraysKt___ArraysJvmKt.copyInto(objArr6, objArr6, positiveMod, positiveMod + 1, objArr6.length);
                Object[] objArr7 = this.elementData;
                objArr7[objArr7.length - 1] = objArr7[0];
                ArraysKt___ArraysJvmKt.copyInto(objArr7, objArr7, 0, 1, positiveMod2 + 1);
            }
            this.elementData[positiveMod2] = null;
        }
        this.size = size() - 1;
        return e16;
    }

    public final E removeFirst() {
        if (!isEmpty()) {
            Object[] objArr = this.elementData;
            int i3 = this.head;
            E e16 = (E) objArr[i3];
            objArr[i3] = null;
            this.head = incremented(i3);
            this.size = size() - 1;
            return e16;
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    @Nullable
    public final E removeFirstOrNull() {
        if (isEmpty()) {
            return null;
        }
        return removeFirst();
    }

    public final E removeLast() {
        int lastIndex;
        if (!isEmpty()) {
            int i3 = this.head;
            lastIndex = CollectionsKt__CollectionsKt.getLastIndex(this);
            int positiveMod = positiveMod(i3 + lastIndex);
            Object[] objArr = this.elementData;
            E e16 = (E) objArr[positiveMod];
            objArr[positiveMod] = null;
            this.size = size() - 1;
            return e16;
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    @Nullable
    public final E removeLastOrNull() {
        if (isEmpty()) {
            return null;
        }
        return removeLast();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(@NotNull Collection<? extends Object> elements) {
        byte b16;
        int positiveMod;
        Intrinsics.checkNotNullParameter(elements, "elements");
        boolean z16 = false;
        z16 = false;
        z16 = false;
        if (!isEmpty()) {
            if (this.elementData.length == 0) {
                b16 = true;
            } else {
                b16 = false;
            }
            if (b16 == false) {
                int positiveMod2 = positiveMod(this.head + size());
                int i3 = this.head;
                if (i3 < positiveMod2) {
                    positiveMod = i3;
                    while (i3 < positiveMod2) {
                        Object obj = this.elementData[i3];
                        if (elements.contains(obj)) {
                            this.elementData[positiveMod] = obj;
                            positiveMod++;
                        } else {
                            z16 = true;
                        }
                        i3++;
                    }
                    ArraysKt___ArraysJvmKt.fill(this.elementData, (Object) null, positiveMod, positiveMod2);
                } else {
                    int length = this.elementData.length;
                    boolean z17 = false;
                    int i16 = i3;
                    while (i3 < length) {
                        Object[] objArr = this.elementData;
                        Object obj2 = objArr[i3];
                        objArr[i3] = null;
                        if (elements.contains(obj2)) {
                            this.elementData[i16] = obj2;
                            i16++;
                        } else {
                            z17 = true;
                        }
                        i3++;
                    }
                    positiveMod = positiveMod(i16);
                    for (int i17 = 0; i17 < positiveMod2; i17++) {
                        Object[] objArr2 = this.elementData;
                        Object obj3 = objArr2[i17];
                        objArr2[i17] = null;
                        if (elements.contains(obj3)) {
                            this.elementData[positiveMod] = obj3;
                            positiveMod = incremented(positiveMod);
                        } else {
                            z17 = true;
                        }
                    }
                    z16 = z17;
                }
                if (z16) {
                    this.size = negativeMod(positiveMod - this.head);
                }
            }
        }
        return z16;
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public E set(int index, E element) {
        AbstractList.INSTANCE.checkElementIndex$kotlin_stdlib(index, size());
        int positiveMod = positiveMod(this.head + index);
        Object[] objArr = this.elementData;
        E e16 = (E) objArr[positiveMod];
        objArr[positiveMod] = element;
        return e16;
    }

    @NotNull
    public final <T> T[] testToArray$kotlin_stdlib(@NotNull T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return (T[]) toArray(array);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    @NotNull
    public <T> T[] toArray(@NotNull T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        if (array.length < size()) {
            array = (T[]) ArraysKt__ArraysJVMKt.arrayOfNulls(array, size());
        }
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        int positiveMod = positiveMod(this.head + size());
        int i3 = this.head;
        if (i3 < positiveMod) {
            ArraysKt___ArraysJvmKt.copyInto$default(this.elementData, array, 0, i3, positiveMod, 2, (Object) null);
        } else if (!isEmpty()) {
            Object[] objArr = this.elementData;
            ArraysKt___ArraysJvmKt.copyInto(objArr, array, 0, this.head, objArr.length);
            Object[] objArr2 = this.elementData;
            ArraysKt___ArraysJvmKt.copyInto(objArr2, array, objArr2.length - this.head, 0, positiveMod);
        }
        if (array.length > size()) {
            array[size()] = null;
        }
        return array;
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public void add(int index, E element) {
        AbstractList.INSTANCE.checkPositionIndex$kotlin_stdlib(index, size());
        if (index == size()) {
            addLast(element);
            return;
        }
        if (index == 0) {
            addFirst(element);
            return;
        }
        ensureCapacity(size() + 1);
        int positiveMod = positiveMod(this.head + index);
        if (index < ((size() + 1) >> 1)) {
            int decremented = decremented(positiveMod);
            int decremented2 = decremented(this.head);
            int i3 = this.head;
            if (decremented >= i3) {
                Object[] objArr = this.elementData;
                objArr[decremented2] = objArr[i3];
                ArraysKt___ArraysJvmKt.copyInto(objArr, objArr, i3, i3 + 1, decremented + 1);
            } else {
                Object[] objArr2 = this.elementData;
                ArraysKt___ArraysJvmKt.copyInto(objArr2, objArr2, i3 - 1, i3, objArr2.length);
                Object[] objArr3 = this.elementData;
                objArr3[objArr3.length - 1] = objArr3[0];
                ArraysKt___ArraysJvmKt.copyInto(objArr3, objArr3, 0, 1, decremented + 1);
            }
            this.elementData[decremented] = element;
            this.head = decremented2;
        } else {
            int positiveMod2 = positiveMod(this.head + size());
            if (positiveMod < positiveMod2) {
                Object[] objArr4 = this.elementData;
                ArraysKt___ArraysJvmKt.copyInto(objArr4, objArr4, positiveMod + 1, positiveMod, positiveMod2);
            } else {
                Object[] objArr5 = this.elementData;
                ArraysKt___ArraysJvmKt.copyInto(objArr5, objArr5, 1, 0, positiveMod2);
                Object[] objArr6 = this.elementData;
                objArr6[0] = objArr6[objArr6.length - 1];
                ArraysKt___ArraysJvmKt.copyInto(objArr6, objArr6, positiveMod + 1, positiveMod, objArr6.length - 1);
            }
            this.elementData[positiveMod] = element;
        }
        this.size = size() + 1;
    }

    @NotNull
    public final Object[] testToArray$kotlin_stdlib() {
        return toArray();
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int index, @NotNull Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        AbstractList.INSTANCE.checkPositionIndex$kotlin_stdlib(index, size());
        if (elements.isEmpty()) {
            return false;
        }
        if (index == size()) {
            return addAll(elements);
        }
        ensureCapacity(size() + elements.size());
        int positiveMod = positiveMod(this.head + size());
        int positiveMod2 = positiveMod(this.head + index);
        int size = elements.size();
        if (index < ((size() + 1) >> 1)) {
            int i3 = this.head;
            int i16 = i3 - size;
            if (positiveMod2 < i3) {
                Object[] objArr = this.elementData;
                ArraysKt___ArraysJvmKt.copyInto(objArr, objArr, i16, i3, objArr.length);
                if (size >= positiveMod2) {
                    Object[] objArr2 = this.elementData;
                    ArraysKt___ArraysJvmKt.copyInto(objArr2, objArr2, objArr2.length - size, 0, positiveMod2);
                } else {
                    Object[] objArr3 = this.elementData;
                    ArraysKt___ArraysJvmKt.copyInto(objArr3, objArr3, objArr3.length - size, 0, size);
                    Object[] objArr4 = this.elementData;
                    ArraysKt___ArraysJvmKt.copyInto(objArr4, objArr4, 0, size, positiveMod2);
                }
            } else if (i16 >= 0) {
                Object[] objArr5 = this.elementData;
                ArraysKt___ArraysJvmKt.copyInto(objArr5, objArr5, i16, i3, positiveMod2);
            } else {
                Object[] objArr6 = this.elementData;
                i16 += objArr6.length;
                int i17 = positiveMod2 - i3;
                int length = objArr6.length - i16;
                if (length >= i17) {
                    ArraysKt___ArraysJvmKt.copyInto(objArr6, objArr6, i16, i3, positiveMod2);
                } else {
                    ArraysKt___ArraysJvmKt.copyInto(objArr6, objArr6, i16, i3, i3 + length);
                    Object[] objArr7 = this.elementData;
                    ArraysKt___ArraysJvmKt.copyInto(objArr7, objArr7, 0, this.head + length, positiveMod2);
                }
            }
            this.head = i16;
            copyCollectionElements(negativeMod(positiveMod2 - size), elements);
        } else {
            int i18 = positiveMod2 + size;
            if (positiveMod2 < positiveMod) {
                int i19 = size + positiveMod;
                Object[] objArr8 = this.elementData;
                if (i19 <= objArr8.length) {
                    ArraysKt___ArraysJvmKt.copyInto(objArr8, objArr8, i18, positiveMod2, positiveMod);
                } else if (i18 >= objArr8.length) {
                    ArraysKt___ArraysJvmKt.copyInto(objArr8, objArr8, i18 - objArr8.length, positiveMod2, positiveMod);
                } else {
                    int length2 = positiveMod - (i19 - objArr8.length);
                    ArraysKt___ArraysJvmKt.copyInto(objArr8, objArr8, 0, length2, positiveMod);
                    Object[] objArr9 = this.elementData;
                    ArraysKt___ArraysJvmKt.copyInto(objArr9, objArr9, i18, positiveMod2, length2);
                }
            } else {
                Object[] objArr10 = this.elementData;
                ArraysKt___ArraysJvmKt.copyInto(objArr10, objArr10, size, 0, positiveMod);
                Object[] objArr11 = this.elementData;
                if (i18 >= objArr11.length) {
                    ArraysKt___ArraysJvmKt.copyInto(objArr11, objArr11, i18 - objArr11.length, positiveMod2, objArr11.length);
                } else {
                    ArraysKt___ArraysJvmKt.copyInto(objArr11, objArr11, 0, objArr11.length - size, objArr11.length);
                    Object[] objArr12 = this.elementData;
                    ArraysKt___ArraysJvmKt.copyInto(objArr12, objArr12, i18, positiveMod2, objArr12.length - size);
                }
            }
            copyCollectionElements(positiveMod2, elements);
        }
        return true;
    }

    public ArrayDeque() {
        this.elementData = emptyElementData;
    }

    public ArrayDeque(@NotNull Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Object[] array = elements.toArray(new Object[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        this.elementData = array;
        this.size = array.length;
        if (array.length == 0) {
            this.elementData = emptyElementData;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    @NotNull
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
