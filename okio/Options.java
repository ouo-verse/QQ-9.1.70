package okio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004:\u0001\u0015B\u001f\b\u0002\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\u0011\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u000eH\u0096\u0002R\u001e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0006X\u0080\u0004\u00a2\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0007\u001a\u00020\bX\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lokio/Options;", "Lkotlin/collections/AbstractList;", "Lokio/ByteString;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "byteStrings", "", "trie", "", "([Lokio/ByteString;[I)V", "getByteStrings$okio", "()[Lokio/ByteString;", "[Lokio/ByteString;", "size", "", "getSize", "()I", "getTrie$okio", "()[I", "get", "index", "Companion", "okio"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes29.dex */
public final class Options extends AbstractList<ByteString> implements RandomAccess {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private final ByteString[] byteStrings;

    @NotNull
    private final int[] trie;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002JT\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH\u0002J!\u0010\u0014\u001a\u00020\u00152\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u0016\"\u00020\u0010H\u0007\u00a2\u0006\u0002\u0010\u0017R\u0018\u0010\u0003\u001a\u00020\u0004*\u00020\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0018"}, d2 = {"Lokio/Options$Companion;", "", "()V", "intCount", "", "Lokio/Buffer;", "getIntCount", "(Lokio/Buffer;)J", "buildTrieRecursive", "", "nodeOffset", "node", "byteStringOffset", "", "byteStrings", "", "Lokio/ByteString;", "fromIndex", "toIndex", "indexes", "of", "Lokio/Options;", "", "([Lokio/ByteString;)Lokio/Options;", "okio"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes29.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void buildTrieRecursive(long nodeOffset, Buffer node, int byteStringOffset, List<? extends ByteString> byteStrings, int fromIndex, int toIndex, List<Integer> indexes) {
            int i3;
            int i16;
            int i17;
            int i18;
            int i19;
            Buffer buffer;
            int i26 = byteStringOffset;
            if (fromIndex < toIndex) {
                if (fromIndex < toIndex) {
                    int i27 = fromIndex;
                    while (true) {
                        int i28 = i27 + 1;
                        if (!(byteStrings.get(i27).size() >= i26)) {
                            throw new IllegalArgumentException("Failed requirement.".toString());
                        }
                        if (i28 >= toIndex) {
                            break;
                        } else {
                            i27 = i28;
                        }
                    }
                }
                ByteString byteString = byteStrings.get(fromIndex);
                ByteString byteString2 = byteStrings.get(toIndex - 1);
                int i29 = -1;
                if (i26 == byteString.size()) {
                    int intValue = indexes.get(fromIndex).intValue();
                    int i36 = fromIndex + 1;
                    ByteString byteString3 = byteStrings.get(i36);
                    i3 = i36;
                    i16 = intValue;
                    byteString = byteString3;
                } else {
                    i3 = fromIndex;
                    i16 = -1;
                }
                if (byteString.getByte(i26) != byteString2.getByte(i26)) {
                    int i37 = i3 + 1;
                    int i38 = 1;
                    if (i37 < toIndex) {
                        while (true) {
                            int i39 = i37 + 1;
                            if (byteStrings.get(i37 - 1).getByte(i26) != byteStrings.get(i37).getByte(i26)) {
                                i38++;
                            }
                            if (i39 >= toIndex) {
                                break;
                            } else {
                                i37 = i39;
                            }
                        }
                    }
                    long intCount = nodeOffset + getIntCount(node) + 2 + (i38 * 2);
                    node.writeInt(i38);
                    node.writeInt(i16);
                    if (i3 < toIndex) {
                        int i46 = i3;
                        while (true) {
                            int i47 = i46 + 1;
                            byte b16 = byteStrings.get(i46).getByte(i26);
                            if (i46 == i3 || b16 != byteStrings.get(i46 - 1).getByte(i26)) {
                                node.writeInt(b16 & 255);
                            }
                            if (i47 >= toIndex) {
                                break;
                            } else {
                                i46 = i47;
                            }
                        }
                    }
                    Buffer buffer2 = new Buffer();
                    while (i3 < toIndex) {
                        byte b17 = byteStrings.get(i3).getByte(i26);
                        int i48 = i3 + 1;
                        if (i48 < toIndex) {
                            int i49 = i48;
                            while (true) {
                                int i56 = i49 + 1;
                                if (b17 != byteStrings.get(i49).getByte(i26)) {
                                    i18 = i49;
                                    break;
                                } else if (i56 >= toIndex) {
                                    break;
                                } else {
                                    i49 = i56;
                                }
                            }
                        }
                        i18 = toIndex;
                        if (i48 == i18 && i26 + 1 == byteStrings.get(i3).size()) {
                            node.writeInt(indexes.get(i3).intValue());
                            i19 = i18;
                            buffer = buffer2;
                        } else {
                            node.writeInt(((int) (intCount + getIntCount(buffer2))) * i29);
                            i19 = i18;
                            buffer = buffer2;
                            buildTrieRecursive(intCount, buffer2, i26 + 1, byteStrings, i3, i18, indexes);
                        }
                        buffer2 = buffer;
                        i3 = i19;
                        i29 = -1;
                    }
                    node.writeAll(buffer2);
                    return;
                }
                int min = Math.min(byteString.size(), byteString2.size());
                if (i26 < min) {
                    int i57 = i26;
                    i17 = 0;
                    while (true) {
                        int i58 = i57 + 1;
                        if (byteString.getByte(i57) != byteString2.getByte(i57)) {
                            break;
                        }
                        i17++;
                        if (i58 >= min) {
                            break;
                        } else {
                            i57 = i58;
                        }
                    }
                } else {
                    i17 = 0;
                }
                long intCount2 = nodeOffset + getIntCount(node) + 2 + i17 + 1;
                node.writeInt(-i17);
                node.writeInt(i16);
                int i59 = i26 + i17;
                if (i26 < i59) {
                    while (true) {
                        int i65 = i26 + 1;
                        node.writeInt(byteString.getByte(i26) & 255);
                        if (i65 >= i59) {
                            break;
                        } else {
                            i26 = i65;
                        }
                    }
                }
                if (i3 + 1 == toIndex) {
                    if (i59 == byteStrings.get(i3).size()) {
                        node.writeInt(indexes.get(i3).intValue());
                        return;
                    }
                    throw new IllegalStateException("Check failed.".toString());
                }
                Buffer buffer3 = new Buffer();
                node.writeInt(((int) (getIntCount(buffer3) + intCount2)) * (-1));
                buildTrieRecursive(intCount2, buffer3, i59, byteStrings, i3, toIndex, indexes);
                node.writeAll(buffer3);
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        static /* synthetic */ void buildTrieRecursive$default(Companion companion, long j3, Buffer buffer, int i3, List list, int i16, int i17, List list2, int i18, Object obj) {
            long j16;
            int i19;
            int i26;
            int i27;
            if ((i18 & 1) != 0) {
                j16 = 0;
            } else {
                j16 = j3;
            }
            if ((i18 & 4) != 0) {
                i19 = 0;
            } else {
                i19 = i3;
            }
            if ((i18 & 16) != 0) {
                i26 = 0;
            } else {
                i26 = i16;
            }
            if ((i18 & 32) != 0) {
                i27 = list.size();
            } else {
                i27 = i17;
            }
            companion.buildTrieRecursive(j16, buffer, i19, list, i26, i27, list2);
        }

        private final long getIntCount(Buffer buffer) {
            return buffer.size() / 4;
        }

        /* JADX WARN: Code restructure failed: missing block: B:48:0x00e3, code lost:
        
            continue;
         */
        @JvmStatic
        @NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Options of(@NotNull ByteString... byteStrings) {
            boolean z16;
            List mutableList;
            List mutableListOf;
            boolean z17;
            boolean z18;
            int binarySearch$default;
            Intrinsics.checkNotNullParameter(byteStrings, "byteStrings");
            int i3 = 0;
            if (byteStrings.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            DefaultConstructorMarker defaultConstructorMarker = null;
            if (!z16) {
                mutableList = ArraysKt___ArraysKt.toMutableList(byteStrings);
                CollectionsKt__MutableCollectionsJVMKt.sort(mutableList);
                ArrayList arrayList = new ArrayList(byteStrings.length);
                for (ByteString byteString : byteStrings) {
                    arrayList.add(-1);
                }
                Object[] array = arrayList.toArray(new Integer[0]);
                if (array != null) {
                    Integer[] numArr = (Integer[]) array;
                    mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(Arrays.copyOf(numArr, numArr.length));
                    int length = byteStrings.length;
                    int i16 = 0;
                    int i17 = 0;
                    while (i16 < length) {
                        binarySearch$default = CollectionsKt__CollectionsKt.binarySearch$default(mutableList, byteStrings[i16], 0, 0, 6, (Object) null);
                        mutableListOf.set(binarySearch$default, Integer.valueOf(i17));
                        i16++;
                        i17++;
                    }
                    if (((ByteString) mutableList.get(0)).size() > 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        int i18 = 0;
                        while (i18 < mutableList.size()) {
                            ByteString byteString2 = (ByteString) mutableList.get(i18);
                            int i19 = i18 + 1;
                            int i26 = i19;
                            while (i26 < mutableList.size()) {
                                ByteString byteString3 = (ByteString) mutableList.get(i26);
                                if (!byteString3.startsWith(byteString2)) {
                                    break;
                                }
                                if (byteString3.size() != byteString2.size()) {
                                    z18 = true;
                                } else {
                                    z18 = false;
                                }
                                if (z18) {
                                    if (((Number) mutableListOf.get(i26)).intValue() > ((Number) mutableListOf.get(i18)).intValue()) {
                                        mutableList.remove(i26);
                                        mutableListOf.remove(i26);
                                    } else {
                                        i26++;
                                    }
                                } else {
                                    throw new IllegalArgumentException(Intrinsics.stringPlus("duplicate option: ", byteString3).toString());
                                }
                            }
                            i18 = i19;
                        }
                        Buffer buffer = new Buffer();
                        buildTrieRecursive$default(this, 0L, buffer, 0, mutableList, 0, 0, mutableListOf, 53, null);
                        int[] iArr = new int[(int) getIntCount(buffer)];
                        while (!buffer.exhausted()) {
                            iArr[i3] = buffer.readInt();
                            i3++;
                        }
                        Object[] copyOf = Arrays.copyOf(byteStrings, byteStrings.length);
                        Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
                        return new Options((ByteString[]) copyOf, iArr, defaultConstructorMarker);
                    }
                    throw new IllegalArgumentException("the empty byte string is not a supported option".toString());
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            return new Options(new ByteString[0], new int[]{0, -1}, defaultConstructorMarker);
        }

        Companion() {
        }
    }

    public /* synthetic */ Options(ByteString[] byteStringArr, int[] iArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(byteStringArr, iArr);
    }

    @JvmStatic
    @NotNull
    public static final Options of(@NotNull ByteString... byteStringArr) {
        return INSTANCE.of(byteStringArr);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof ByteString) {
            return contains((ByteString) obj);
        }
        return false;
    }

    @NotNull
    /* renamed from: getByteStrings$okio, reason: from getter */
    public final ByteString[] getByteStrings() {
        return this.byteStrings;
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    /* renamed from: getSize */
    public int get_size() {
        return this.byteStrings.length;
    }

    @NotNull
    /* renamed from: getTrie$okio, reason: from getter */
    public final int[] getTrie() {
        return this.trie;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof ByteString) {
            return indexOf((ByteString) obj);
        }
        return -1;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof ByteString) {
            return lastIndexOf((ByteString) obj);
        }
        return -1;
    }

    Options(ByteString[] byteStringArr, int[] iArr) {
        this.byteStrings = byteStringArr;
        this.trie = iArr;
    }

    public /* bridge */ boolean contains(ByteString byteString) {
        return super.contains((Options) byteString);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    @NotNull
    public ByteString get(int index) {
        return this.byteStrings[index];
    }

    public /* bridge */ int indexOf(ByteString byteString) {
        return super.indexOf((Options) byteString);
    }

    public /* bridge */ int lastIndexOf(ByteString byteString) {
        return super.lastIndexOf((Options) byteString);
    }
}
