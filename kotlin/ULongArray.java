package kotlin;

import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@SinceKotlin(version = "1.3")
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00012B\u0014\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006B\u0014\b\u0001\u0012\u0006\u0010\u0007\u001a\u00020\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\tJ\u001b\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0096\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012J \u0010\u0013\u001a\u00020\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0016\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u00d6\u0003\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u001e\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0004H\u0086\u0002\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0004H\u00d6\u0001\u00a2\u0006\u0004\b!\u0010\u000bJ\u000f\u0010\"\u001a\u00020\u000fH\u0016\u00a2\u0006\u0004\b#\u0010$J\u0019\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020&H\u0096\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b'\u0010(J#\u0010)\u001a\u00020*2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0002H\u0086\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b,\u0010-J\u0010\u0010.\u001a\u00020/H\u00d6\u0001\u00a2\u0006\u0004\b0\u00101R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\b8\u0000X\u0081\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\f\u0010\r\u0088\u0001\u0007\u0092\u0001\u00020\b\u00f8\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u00063"}, d2 = {"Lkotlin/ULongArray;", "", "Lkotlin/ULong;", "size", "", "constructor-impl", "(I)[J", QQPermissionConstants.Permission.STORAGE_GROUP, "", "([J)[J", "getSize-impl", "([J)I", "getStorage$annotations", "()V", "contains", "", DTConstants.TAG.ELEMENT, "contains-VKZWuLQ", "([JJ)Z", "containsAll", DTParamKey.REPORT_KEY_VISUAL_ELEMENTS, "containsAll-impl", "([JLjava/util/Collection;)Z", "equals", "other", "", "equals-impl", "([JLjava/lang/Object;)Z", "get", "index", "get-s-VKNKU", "([JI)J", "hashCode", "hashCode-impl", "isEmpty", "isEmpty-impl", "([J)Z", "iterator", "", "iterator-impl", "([J)Ljava/util/Iterator;", "set", "", "value", "set-k8EXiF4", "([JIJ)V", "toString", "", "toString-impl", "([J)Ljava/lang/String;", "Iterator", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
@ExperimentalUnsignedTypes
@JvmInline
/* loaded from: classes28.dex */
public final class ULongArray implements Collection<ULong>, KMappedMarker {

    @NotNull
    private final long[] storage;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\tH\u0096\u0002J\u0016\u0010\n\u001a\u00020\u0002H\u0096\u0002\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u000b\u0010\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00f8\u0001\u0001\u0082\u0002\b\n\u0002\b!\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lkotlin/ULongArray$Iterator;", "", "Lkotlin/ULong;", HippyControllerProps.ARRAY, "", "([J)V", "index", "", "hasNext", "", "next", "next-s-VKNKU", "()J", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes28.dex */
    public static final class Iterator implements java.util.Iterator<ULong>, KMappedMarker {

        @NotNull
        private final long[] array;
        private int index;

        public Iterator(@NotNull long[] array) {
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

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ ULong next() {
            return ULong.m642boximpl(m717nextsVKNKU());
        }

        /* renamed from: next-s-VKNKU, reason: not valid java name */
        public long m717nextsVKNKU() {
            int i3 = this.index;
            long[] jArr = this.array;
            if (i3 < jArr.length) {
                this.index = i3 + 1;
                return ULong.m648constructorimpl(jArr[i3]);
            }
            throw new NoSuchElementException(String.valueOf(this.index));
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @PublishedApi
    /* synthetic */ ULongArray(long[] jArr) {
        this.storage = jArr;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ULongArray m700boximpl(long[] jArr) {
        return new ULongArray(jArr);
    }

    @PublishedApi
    @NotNull
    /* renamed from: constructor-impl, reason: not valid java name */
    public static long[] m702constructorimpl(@NotNull long[] storage) {
        Intrinsics.checkNotNullParameter(storage, "storage");
        return storage;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0037 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[LOOP:0: B:4:0x0017->B:17:?, LOOP_END, SYNTHETIC] */
    /* renamed from: containsAll-impl, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean m704containsAllimpl(long[] jArr, @NotNull Collection<ULong> elements) {
        boolean z16;
        boolean contains;
        Intrinsics.checkNotNullParameter(elements, "elements");
        Collection<ULong> collection = elements;
        if (collection.isEmpty()) {
            return true;
        }
        for (Object obj : collection) {
            if (obj instanceof ULong) {
                contains = ArraysKt___ArraysKt.contains(jArr, ((ULong) obj).getData());
                if (contains) {
                    z16 = true;
                    if (z16) {
                        return false;
                    }
                }
            }
            z16 = false;
            if (z16) {
            }
        }
        return true;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m705equalsimpl(long[] jArr, Object obj) {
        if (!(obj instanceof ULongArray) || !Intrinsics.areEqual(jArr, ((ULongArray) obj).getStorage())) {
            return false;
        }
        return true;
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m706equalsimpl0(long[] jArr, long[] jArr2) {
        return Intrinsics.areEqual(jArr, jArr2);
    }

    /* renamed from: get-s-VKNKU, reason: not valid java name */
    public static final long m707getsVKNKU(long[] jArr, int i3) {
        return ULong.m648constructorimpl(jArr[i3]);
    }

    /* renamed from: getSize-impl, reason: not valid java name */
    public static int m708getSizeimpl(long[] jArr) {
        return jArr.length;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m709hashCodeimpl(long[] jArr) {
        return Arrays.hashCode(jArr);
    }

    /* renamed from: isEmpty-impl, reason: not valid java name */
    public static boolean m710isEmptyimpl(long[] jArr) {
        if (jArr.length == 0) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: iterator-impl, reason: not valid java name */
    public static java.util.Iterator<ULong> m711iteratorimpl(long[] jArr) {
        return new Iterator(jArr);
    }

    /* renamed from: set-k8EXiF4, reason: not valid java name */
    public static final void m712setk8EXiF4(long[] jArr, int i3, long j3) {
        jArr[i3] = j3;
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m713toStringimpl(long[] jArr) {
        return "ULongArray(storage=" + Arrays.toString(jArr) + ')';
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(ULong uLong) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: add-VKZWuLQ, reason: not valid java name */
    public boolean m714addVKZWuLQ(long j3) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends ULong> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof ULong)) {
            return false;
        }
        return m715containsVKZWuLQ(((ULong) obj).getData());
    }

    /* renamed from: contains-VKZWuLQ, reason: not valid java name */
    public boolean m715containsVKZWuLQ(long j3) {
        return m703containsVKZWuLQ(this.storage, j3);
    }

    @Override // java.util.Collection
    public boolean containsAll(@NotNull Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return m704containsAllimpl(this.storage, elements);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return m705equalsimpl(this.storage, obj);
    }

    @Override // java.util.Collection
    /* renamed from: getSize, reason: merged with bridge method [inline-methods] */
    public int size() {
        return m708getSizeimpl(this.storage);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return m709hashCodeimpl(this.storage);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return m710isEmptyimpl(this.storage);
    }

    @Override // java.util.Collection, java.lang.Iterable
    @NotNull
    public java.util.Iterator<ULong> iterator() {
        return m711iteratorimpl(this.storage);
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    public String toString() {
        return m713toStringimpl(this.storage);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long[] getStorage() {
        return this.storage;
    }

    @NotNull
    /* renamed from: constructor-impl, reason: not valid java name */
    public static long[] m701constructorimpl(int i3) {
        return m702constructorimpl(new long[i3]);
    }

    /* renamed from: contains-VKZWuLQ, reason: not valid java name */
    public static boolean m703containsVKZWuLQ(long[] jArr, long j3) {
        boolean contains;
        contains = ArraysKt___ArraysKt.contains(jArr, j3);
        return contains;
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return (T[]) CollectionToArray.toArray(this, array);
    }

    @PublishedApi
    public static /* synthetic */ void getStorage$annotations() {
    }
}
