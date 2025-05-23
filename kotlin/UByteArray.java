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
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00012B\u0014\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006B\u0014\b\u0001\u0012\u0006\u0010\u0007\u001a\u00020\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\tJ\u001b\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0096\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012J \u0010\u0013\u001a\u00020\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0016\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u00d6\u0003\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u001e\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0004H\u0086\u0002\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0004H\u00d6\u0001\u00a2\u0006\u0004\b!\u0010\u000bJ\u000f\u0010\"\u001a\u00020\u000fH\u0016\u00a2\u0006\u0004\b#\u0010$J\u0019\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020&H\u0096\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b'\u0010(J#\u0010)\u001a\u00020*2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0002H\u0086\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b,\u0010-J\u0010\u0010.\u001a\u00020/H\u00d6\u0001\u00a2\u0006\u0004\b0\u00101R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\b8\u0000X\u0081\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\f\u0010\r\u0088\u0001\u0007\u0092\u0001\u00020\b\u00f8\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u00063"}, d2 = {"Lkotlin/UByteArray;", "", "Lkotlin/UByte;", "size", "", "constructor-impl", "(I)[B", QQPermissionConstants.Permission.STORAGE_GROUP, "", "([B)[B", "getSize-impl", "([B)I", "getStorage$annotations", "()V", "contains", "", DTConstants.TAG.ELEMENT, "contains-7apg3OU", "([BB)Z", "containsAll", DTParamKey.REPORT_KEY_VISUAL_ELEMENTS, "containsAll-impl", "([BLjava/util/Collection;)Z", "equals", "other", "", "equals-impl", "([BLjava/lang/Object;)Z", "get", "index", "get-w2LRezQ", "([BI)B", "hashCode", "hashCode-impl", "isEmpty", "isEmpty-impl", "([B)Z", "iterator", "", "iterator-impl", "([B)Ljava/util/Iterator;", "set", "", "value", "set-VurrAj0", "([BIB)V", "toString", "", "toString-impl", "([B)Ljava/lang/String;", "Iterator", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
@ExperimentalUnsignedTypes
@JvmInline
/* loaded from: classes28.dex */
public final class UByteArray implements Collection<UByte>, KMappedMarker {

    @NotNull
    private final byte[] storage;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\tH\u0096\u0002J\u0016\u0010\n\u001a\u00020\u0002H\u0096\u0002\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u000b\u0010\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00f8\u0001\u0001\u0082\u0002\b\n\u0002\b!\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lkotlin/UByteArray$Iterator;", "", "Lkotlin/UByte;", HippyControllerProps.ARRAY, "", "([B)V", "index", "", "hasNext", "", "next", "next-w2LRezQ", "()B", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes28.dex */
    public static final class Iterator implements java.util.Iterator<UByte>, KMappedMarker {

        @NotNull
        private final byte[] array;
        private int index;

        public Iterator(@NotNull byte[] array) {
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
        public /* bridge */ /* synthetic */ UByte next() {
            return UByte.m488boximpl(m561nextw2LRezQ());
        }

        /* renamed from: next-w2LRezQ, reason: not valid java name */
        public byte m561nextw2LRezQ() {
            int i3 = this.index;
            byte[] bArr = this.array;
            if (i3 < bArr.length) {
                this.index = i3 + 1;
                return UByte.m494constructorimpl(bArr[i3]);
            }
            throw new NoSuchElementException(String.valueOf(this.index));
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @PublishedApi
    /* synthetic */ UByteArray(byte[] bArr) {
        this.storage = bArr;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ UByteArray m544boximpl(byte[] bArr) {
        return new UByteArray(bArr);
    }

    @PublishedApi
    @NotNull
    /* renamed from: constructor-impl, reason: not valid java name */
    public static byte[] m546constructorimpl(@NotNull byte[] storage) {
        Intrinsics.checkNotNullParameter(storage, "storage");
        return storage;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0037 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[LOOP:0: B:4:0x0017->B:17:?, LOOP_END, SYNTHETIC] */
    /* renamed from: containsAll-impl, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean m548containsAllimpl(byte[] bArr, @NotNull Collection<UByte> elements) {
        boolean z16;
        boolean contains;
        Intrinsics.checkNotNullParameter(elements, "elements");
        Collection<UByte> collection = elements;
        if (collection.isEmpty()) {
            return true;
        }
        for (Object obj : collection) {
            if (obj instanceof UByte) {
                contains = ArraysKt___ArraysKt.contains(bArr, ((UByte) obj).getData());
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
    public static boolean m549equalsimpl(byte[] bArr, Object obj) {
        if (!(obj instanceof UByteArray) || !Intrinsics.areEqual(bArr, ((UByteArray) obj).getStorage())) {
            return false;
        }
        return true;
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m550equalsimpl0(byte[] bArr, byte[] bArr2) {
        return Intrinsics.areEqual(bArr, bArr2);
    }

    /* renamed from: get-w2LRezQ, reason: not valid java name */
    public static final byte m551getw2LRezQ(byte[] bArr, int i3) {
        return UByte.m494constructorimpl(bArr[i3]);
    }

    /* renamed from: getSize-impl, reason: not valid java name */
    public static int m552getSizeimpl(byte[] bArr) {
        return bArr.length;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m553hashCodeimpl(byte[] bArr) {
        return Arrays.hashCode(bArr);
    }

    /* renamed from: isEmpty-impl, reason: not valid java name */
    public static boolean m554isEmptyimpl(byte[] bArr) {
        if (bArr.length == 0) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: iterator-impl, reason: not valid java name */
    public static java.util.Iterator<UByte> m555iteratorimpl(byte[] bArr) {
        return new Iterator(bArr);
    }

    /* renamed from: set-VurrAj0, reason: not valid java name */
    public static final void m556setVurrAj0(byte[] bArr, int i3, byte b16) {
        bArr[i3] = b16;
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m557toStringimpl(byte[] bArr) {
        return "UByteArray(storage=" + Arrays.toString(bArr) + ')';
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(UByte uByte) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: add-7apg3OU, reason: not valid java name */
    public boolean m558add7apg3OU(byte b16) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends UByte> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof UByte)) {
            return false;
        }
        return m559contains7apg3OU(((UByte) obj).getData());
    }

    /* renamed from: contains-7apg3OU, reason: not valid java name */
    public boolean m559contains7apg3OU(byte b16) {
        return m547contains7apg3OU(this.storage, b16);
    }

    @Override // java.util.Collection
    public boolean containsAll(@NotNull Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return m548containsAllimpl(this.storage, elements);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return m549equalsimpl(this.storage, obj);
    }

    @Override // java.util.Collection
    /* renamed from: getSize, reason: merged with bridge method [inline-methods] */
    public int size() {
        return m552getSizeimpl(this.storage);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return m553hashCodeimpl(this.storage);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return m554isEmptyimpl(this.storage);
    }

    @Override // java.util.Collection, java.lang.Iterable
    @NotNull
    public java.util.Iterator<UByte> iterator() {
        return m555iteratorimpl(this.storage);
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
        return m557toStringimpl(this.storage);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ byte[] getStorage() {
        return this.storage;
    }

    @NotNull
    /* renamed from: constructor-impl, reason: not valid java name */
    public static byte[] m545constructorimpl(int i3) {
        return m546constructorimpl(new byte[i3]);
    }

    /* renamed from: contains-7apg3OU, reason: not valid java name */
    public static boolean m547contains7apg3OU(byte[] bArr, byte b16) {
        boolean contains;
        contains = ArraysKt___ArraysKt.contains(bArr, b16);
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
