package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.ListImplementation;
import com.tencent.mtt.hippy.dom.node.TextNode;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import java.util.Arrays;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010*\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B5\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0002\u0010\u000bJ\u001b\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0010\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u0011J#\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u0013J\u001d\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010\u0012\u001a\u00020\tH\u0002\u00a2\u0006\u0002\u0010\u0015J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0016J\u0016\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00020\tH\u0096\u0002\u00a2\u0006\u0002\u0010\u0019JG\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001c\u001a\u00020\u001dH\u0002\u00a2\u0006\u0002\u0010\u001eJ5\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010 \u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006H\u0002\u00a2\u0006\u0002\u0010!J\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#2\u0006\u0010\u0012\u001a\u00020\tH\u0016J?\u0010$\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u001dH\u0002\u00a2\u0006\u0002\u0010&J3\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010(\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\tH\u0002\u00a2\u0006\u0002\u0010)JC\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u000e\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u000e\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005H\u0002\u00a2\u0006\u0002\u0010-J?\u0010.\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\u0006\u0010\u001b\u001a\u00020\t2\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005H\u0002\u00a2\u0006\u0002\u0010/J\"\u00100\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020302H\u0016J\u0016\u00104\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0012\u001a\u00020\tH\u0016J=\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u001dH\u0002\u00a2\u0006\u0002\u0010&J;\u00106\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010(\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\tH\u0002\u00a2\u0006\u0002\u00107J\b\u0010(\u001a\u00020\tH\u0002J#\u00108\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u0013J?\u00109\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\b\u0010:\u001a\u0004\u0018\u00010\u0006H\u0002\u00a2\u0006\u0002\u0010;R\u0018\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\n\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\f\u00a8\u0006<"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/PersistentVector;", "E", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/AbstractPersistentList;", "root", "", "", TextNode.MODE_TAIL, "size", "", "rootShift", "([Ljava/lang/Object;[Ljava/lang/Object;II)V", "[Ljava/lang/Object;", "getSize", "()I", "add", DTConstants.TAG.ELEMENT, "(Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "index", "(ILjava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "bufferFor", "(I)[Ljava/lang/Object;", "builder", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/PersistentVectorBuilder;", "get", "(I)Ljava/lang/Object;", "insertIntoRoot", "shift", "elementCarry", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/ObjectRef;", "([Ljava/lang/Object;IILjava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/ObjectRef;)[Ljava/lang/Object;", "insertIntoTail", "tailIndex", "([Ljava/lang/Object;ILjava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/PersistentVector;", "listIterator", "", "pullLastBuffer", "tailCarry", "([Ljava/lang/Object;IILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/ObjectRef;)[Ljava/lang/Object;", "pullLastBufferFromRoot", "rootSize", "([Ljava/lang/Object;II)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "pushFilledTail", "filledTail", "newTail", "([Ljava/lang/Object;[Ljava/lang/Object;[Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/PersistentVector;", "pushTail", "([Ljava/lang/Object;I[Ljava/lang/Object;)[Ljava/lang/Object;", "removeAll", "predicate", "Lkotlin/Function1;", "", "removeAt", "removeFromRootAt", "removeFromTailAt", "([Ljava/lang/Object;III)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "set", "setInRoot", "e", "([Ljava/lang/Object;IILjava/lang/Object;)[Ljava/lang/Object;", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes39.dex */
public final class PersistentVector<E> extends AbstractPersistentList<E> {
    private final Object[] root;
    private final int rootShift;
    private final int size;
    private final Object[] tail;

    public PersistentVector(Object[] root, Object[] tail, int i3, int i16) {
        int coerceAtMost;
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(tail, "tail");
        this.root = root;
        this.tail = tail;
        this.size = i3;
        this.rootShift = i16;
        if (size() > 32) {
            int size = size() - UtilsKt.rootSize(size());
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(tail.length, 32);
            CommonFunctionsKt.m32assert(size <= coerceAtMost);
        } else {
            throw new IllegalArgumentException(("Trie-based persistent vector should have at least 33 elements, got " + size()).toString());
        }
    }

    private final Object[] bufferFor(int index) {
        if (rootSize() <= index) {
            return this.tail;
        }
        Object[] objArr = this.root;
        for (int i3 = this.rootShift; i3 > 0; i3 -= 5) {
            Object[] objArr2 = objArr[UtilsKt.indexSegment(index, i3)];
            if (objArr2 != null) {
                objArr = objArr2;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            }
        }
        return objArr;
    }

    private final PersistentVector<E> insertIntoTail(Object[] root, int tailIndex, Object element) {
        int size = size() - rootSize();
        Object[] copyOf = Arrays.copyOf(this.tail, 32);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        if (size < 32) {
            ArraysKt___ArraysJvmKt.copyInto(this.tail, copyOf, tailIndex + 1, tailIndex, size);
            copyOf[tailIndex] = element;
            return new PersistentVector<>(root, copyOf, size() + 1, this.rootShift);
        }
        Object[] objArr = this.tail;
        Object obj = objArr[31];
        ArraysKt___ArraysJvmKt.copyInto(objArr, copyOf, tailIndex + 1, tailIndex, size - 1);
        copyOf[tailIndex] = element;
        return pushFilledTail(root, copyOf, UtilsKt.presizedBufferWith(obj));
    }

    private final Object[] pullLastBuffer(Object[] root, int shift, int index, ObjectRef tailCarry) {
        Object[] pullLastBuffer;
        int indexSegment = UtilsKt.indexSegment(index, shift);
        if (shift == 5) {
            tailCarry.setValue(root[indexSegment]);
            pullLastBuffer = null;
        } else {
            Object obj = root[indexSegment];
            if (obj != null) {
                pullLastBuffer = pullLastBuffer((Object[]) obj, shift - 5, index, tailCarry);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            }
        }
        if (pullLastBuffer == null && indexSegment == 0) {
            return null;
        }
        Object[] copyOf = Arrays.copyOf(root, 32);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        copyOf[indexSegment] = pullLastBuffer;
        return copyOf;
    }

    private final PersistentVector<E> pushFilledTail(Object[] root, Object[] filledTail, Object[] newTail) {
        int size = size() >> 5;
        int i3 = this.rootShift;
        if (size > (1 << i3)) {
            Object[] presizedBufferWith = UtilsKt.presizedBufferWith(root);
            int i16 = this.rootShift + 5;
            return new PersistentVector<>(pushTail(presizedBufferWith, i16, filledTail), newTail, size() + 1, i16);
        }
        return new PersistentVector<>(pushTail(root, i3, filledTail), newTail, size() + 1, this.rootShift);
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0018, code lost:
    
        if (r4 == null) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Object[] pushTail(Object[] root, int shift, Object[] tail) {
        Object[] objArr;
        int indexSegment = UtilsKt.indexSegment(size() - 1, shift);
        if (root != null) {
            objArr = Arrays.copyOf(root, 32);
            Intrinsics.checkNotNullExpressionValue(objArr, "copyOf(this, newSize)");
        }
        objArr = new Object[32];
        if (shift == 5) {
            objArr[indexSegment] = tail;
        } else {
            objArr[indexSegment] = pushTail((Object[]) objArr[indexSegment], shift - 5, tail);
        }
        return objArr;
    }

    private final Object[] removeFromRootAt(Object[] root, int shift, int index, ObjectRef tailCarry) {
        Object[] copyOf;
        int indexSegment = UtilsKt.indexSegment(index, shift);
        if (shift == 0) {
            if (indexSegment == 0) {
                copyOf = new Object[32];
            } else {
                copyOf = Arrays.copyOf(root, 32);
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            }
            ArraysKt___ArraysJvmKt.copyInto(root, copyOf, indexSegment, indexSegment + 1, 32);
            copyOf[31] = tailCarry.getValue();
            tailCarry.setValue(root[indexSegment]);
            return copyOf;
        }
        int indexSegment2 = root[31] == null ? UtilsKt.indexSegment(rootSize() - 1, shift) : 31;
        Object[] copyOf2 = Arrays.copyOf(root, 32);
        Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(this, newSize)");
        int i3 = shift - 5;
        int i16 = indexSegment + 1;
        if (i16 <= indexSegment2) {
            while (true) {
                Object obj = copyOf2[indexSegment2];
                if (obj != null) {
                    copyOf2[indexSegment2] = removeFromRootAt((Object[]) obj, i3, 0, tailCarry);
                    if (indexSegment2 == i16) {
                        break;
                    }
                    indexSegment2--;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                }
            }
        }
        Object obj2 = copyOf2[indexSegment];
        if (obj2 != null) {
            copyOf2[indexSegment] = removeFromRootAt((Object[]) obj2, i3, index, tailCarry);
            return copyOf2;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
    }

    private final PersistentList<E> removeFromTailAt(Object[] root, int rootSize, int shift, int index) {
        int size = size() - rootSize;
        CommonFunctionsKt.m32assert(index < size);
        if (size == 1) {
            return pullLastBufferFromRoot(root, rootSize, shift);
        }
        Object[] copyOf = Arrays.copyOf(this.tail, 32);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        int i3 = size - 1;
        if (index < i3) {
            ArraysKt___ArraysJvmKt.copyInto(this.tail, copyOf, index, index + 1, size);
        }
        copyOf[i3] = null;
        return new PersistentVector(root, copyOf, (rootSize + size) - 1, shift);
    }

    private final int rootSize() {
        return UtilsKt.rootSize(size());
    }

    private final Object[] setInRoot(Object[] root, int shift, int index, Object e16) {
        int indexSegment = UtilsKt.indexSegment(index, shift);
        Object[] copyOf = Arrays.copyOf(root, 32);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        if (shift == 0) {
            copyOf[indexSegment] = e16;
        } else {
            Object obj = copyOf[indexSegment];
            if (obj != null) {
                copyOf[indexSegment] = setInRoot((Object[]) obj, shift - 5, index, e16);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            }
        }
        return copyOf;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Collection, java.util.List, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection
    public /* bridge */ /* synthetic */ PersistentCollection add(Object obj) {
        return add((PersistentVector<E>) obj);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public E get(int index) {
        ListImplementation.checkElementIndex$runtime_release(index, size());
        return (E) bufferFor(index)[index & 31];
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    /* renamed from: getSize, reason: from getter */
    public int get_size() {
        return this.size;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public ListIterator<E> listIterator(int index) {
        ListImplementation.checkPositionIndex$runtime_release(index, size());
        return new PersistentVectorIterator(this.root, this.tail, index, size(), (this.rootShift / 5) + 1);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList
    public PersistentList<E> removeAt(int index) {
        ListImplementation.checkElementIndex$runtime_release(index, size());
        int rootSize = rootSize();
        if (index >= rootSize) {
            return removeFromTailAt(this.root, rootSize, this.rootShift, index - rootSize);
        }
        return removeFromTailAt(removeFromRootAt(this.root, this.rootShift, index, new ObjectRef(this.tail[0])), rootSize, this.rootShift, 0);
    }

    @Override // kotlin.collections.AbstractList, java.util.List, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList
    public PersistentList<E> set(int index, E element) {
        ListImplementation.checkElementIndex$runtime_release(index, size());
        if (rootSize() <= index) {
            Object[] copyOf = Arrays.copyOf(this.tail, 32);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            copyOf[index & 31] = element;
            return new PersistentVector(this.root, copyOf, size(), this.rootShift);
        }
        return new PersistentVector(setInRoot(this.root, this.rootShift, index, element), this.tail, size(), this.rootShift);
    }

    @Override // java.util.Collection, java.util.List, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection
    public PersistentList<E> add(E element) {
        int size = size() - rootSize();
        if (size < 32) {
            Object[] copyOf = Arrays.copyOf(this.tail, 32);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            copyOf[size] = element;
            return new PersistentVector(this.root, copyOf, size() + 1, this.rootShift);
        }
        return pushFilledTail(this.root, this.tail, UtilsKt.presizedBufferWith(element));
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection
    public PersistentList<E> removeAll(Function1<? super E, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        PersistentVectorBuilder<E> builder = builder();
        builder.removeAllWithPredicate(predicate);
        return builder.build();
    }

    private final PersistentList<E> pullLastBufferFromRoot(Object[] root, int rootSize, int shift) {
        if (shift == 0) {
            if (root.length == 33) {
                root = Arrays.copyOf(root, 32);
                Intrinsics.checkNotNullExpressionValue(root, "copyOf(this, newSize)");
            }
            return new SmallPersistentVector(root);
        }
        ObjectRef objectRef = new ObjectRef(null);
        Object[] pullLastBuffer = pullLastBuffer(root, shift, rootSize - 1, objectRef);
        Intrinsics.checkNotNull(pullLastBuffer);
        Object value = objectRef.getValue();
        if (value != null) {
            Object[] objArr = (Object[]) value;
            if (pullLastBuffer[1] == null) {
                Object obj = pullLastBuffer[0];
                if (obj != null) {
                    return new PersistentVector((Object[]) obj, objArr, rootSize, shift - 5);
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            }
            return new PersistentVector(pullLastBuffer, objArr, rootSize, shift);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection
    public PersistentVectorBuilder<E> builder() {
        return new PersistentVectorBuilder<>(this, this.root, this.tail, this.rootShift);
    }

    private final Object[] insertIntoRoot(Object[] root, int shift, int index, Object element, ObjectRef elementCarry) {
        Object[] copyOf;
        int indexSegment = UtilsKt.indexSegment(index, shift);
        if (shift == 0) {
            if (indexSegment == 0) {
                copyOf = new Object[32];
            } else {
                copyOf = Arrays.copyOf(root, 32);
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            }
            ArraysKt___ArraysJvmKt.copyInto(root, copyOf, indexSegment + 1, indexSegment, 31);
            elementCarry.setValue(root[31]);
            copyOf[indexSegment] = element;
            return copyOf;
        }
        Object[] copyOf2 = Arrays.copyOf(root, 32);
        Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(this, newSize)");
        int i3 = shift - 5;
        Object obj = root[indexSegment];
        String str = "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>";
        if (obj != null) {
            copyOf2[indexSegment] = insertIntoRoot((Object[]) obj, i3, index, element, elementCarry);
            int i16 = indexSegment + 1;
            while (i16 < 32 && copyOf2[i16] != null) {
                Object obj2 = root[i16];
                if (obj2 != null) {
                    Object[] objArr = copyOf2;
                    objArr[i16] = insertIntoRoot((Object[]) obj2, i3, 0, elementCarry.getValue(), elementCarry);
                    i16++;
                    copyOf2 = objArr;
                    str = str;
                } else {
                    throw new NullPointerException(str);
                }
            }
            return copyOf2;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
    }

    @Override // java.util.List, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList
    public PersistentList<E> add(int index, E element) {
        ListImplementation.checkPositionIndex$runtime_release(index, size());
        if (index == size()) {
            return add((PersistentVector<E>) element);
        }
        int rootSize = rootSize();
        if (index >= rootSize) {
            return insertIntoTail(this.root, index - rootSize, element);
        }
        ObjectRef objectRef = new ObjectRef(null);
        return insertIntoTail(insertIntoRoot(this.root, this.rootShift, index, element, objectRef), 0, objectRef.getValue());
    }
}
