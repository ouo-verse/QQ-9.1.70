package okio.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ByteString;
import okio.Path;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0006\n\u0002\u0010\u0005\n\u0000\u001a\u0015\u0010\u0014\u001a\u00020\r*\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000eH\u0080\b\u001a\u0017\u0010\u0016\u001a\u00020\u0017*\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0018H\u0080\b\u001a\r\u0010\u0019\u001a\u00020\r*\u00020\u000eH\u0080\b\u001a\r\u0010\u001a\u001a\u00020\u0017*\u00020\u000eH\u0080\b\u001a\r\u0010\u001b\u001a\u00020\u0017*\u00020\u000eH\u0080\b\u001a\r\u0010\u001c\u001a\u00020\u0017*\u00020\u000eH\u0080\b\u001a\r\u0010\u001d\u001a\u00020\u001e*\u00020\u000eH\u0080\b\u001a\r\u0010\u001f\u001a\u00020\u0001*\u00020\u000eH\u0080\b\u001a\r\u0010 \u001a\u00020\u000e*\u00020\u000eH\u0080\b\u001a\u000f\u0010!\u001a\u0004\u0018\u00010\u000e*\u00020\u000eH\u0080\b\u001a\u0015\u0010\"\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000eH\u0080\b\u001a\u001d\u0010#\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\u0017H\u0080\b\u001a\u001d\u0010#\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010$\u001a\u00020&2\u0006\u0010%\u001a\u00020\u0017H\u0080\b\u001a\u001d\u0010#\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010$\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\u0017H\u0080\b\u001a\u001c\u0010#\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u0017H\u0000\u001a\u000f\u0010'\u001a\u0004\u0018\u00010\u000e*\u00020\u000eH\u0080\b\u001a\u0013\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001e0)*\u00020\u000eH\u0080\b\u001a\u0013\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00010)*\u00020\u000eH\u0080\b\u001a\u0012\u0010+\u001a\u00020\u000e*\u00020\u001e2\u0006\u0010%\u001a\u00020\u0017\u001a\r\u0010,\u001a\u00020\u001e*\u00020\u000eH\u0080\b\u001a\u0014\u0010-\u001a\u0004\u0018\u00010.*\u00020\u000eH\u0080\b\u00a2\u0006\u0002\u0010/\u001a\f\u00100\u001a\u00020\u0017*\u00020\u000eH\u0002\u001a\f\u00101\u001a\u00020\r*\u00020\u000eH\u0002\u001a\u0014\u00102\u001a\u00020\u0017*\u00020&2\u0006\u0010\u0011\u001a\u00020\u0001H\u0002\u001a\u0014\u00103\u001a\u00020\u000e*\u00020&2\u0006\u0010%\u001a\u00020\u0017H\u0000\u001a\f\u00104\u001a\u00020\u0001*\u000205H\u0002\u001a\f\u00104\u001a\u00020\u0001*\u00020\u001eH\u0002\"\u0016\u0010\u0000\u001a\u00020\u00018\u0002X\u0083\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0004\u001a\u00020\u00018\u0002X\u0083\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0003\"\u0016\u0010\u0006\u001a\u00020\u00018\u0002X\u0083\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0003\"\u0016\u0010\b\u001a\u00020\u00018\u0002X\u0083\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\t\u0010\u0003\"\u0016\u0010\n\u001a\u00020\u00018\u0002X\u0083\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\u0003\"\u0018\u0010\f\u001a\u00020\r*\u00020\u000e8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u0001*\u00020\u000e8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u00a8\u00066"}, d2 = {"ANY_SLASH", "Lokio/ByteString;", "getANY_SLASH$annotations", "()V", "BACKSLASH", "getBACKSLASH$annotations", "DOT", "getDOT$annotations", "DOT_DOT", "getDOT_DOT$annotations", "SLASH", "getSLASH$annotations", "indexOfLastSlash", "", "Lokio/Path;", "getIndexOfLastSlash", "(Lokio/Path;)I", "slash", "getSlash", "(Lokio/Path;)Lokio/ByteString;", "commonCompareTo", "other", "commonEquals", "", "", "commonHashCode", "commonIsAbsolute", "commonIsRelative", "commonIsRoot", "commonName", "", "commonNameBytes", "commonNormalized", "commonParent", "commonRelativeTo", "commonResolve", "child", "normalize", "Lokio/Buffer;", "commonRoot", "commonSegments", "", "commonSegmentsBytes", "commonToPath", "commonToString", "commonVolumeLetter", "", "(Lokio/Path;)Ljava/lang/Character;", "lastSegmentIsDotDot", "rootLength", "startsWithVolumeLetterAndColon", "toPath", "toSlash", "", "okio"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes29.dex */
public final class _PathKt {

    @NotNull
    private static final ByteString ANY_SLASH;

    @NotNull
    private static final ByteString BACKSLASH;

    @NotNull
    private static final ByteString DOT;

    @NotNull
    private static final ByteString DOT_DOT;

    @NotNull
    private static final ByteString SLASH;

    static {
        ByteString.Companion companion = ByteString.INSTANCE;
        SLASH = companion.encodeUtf8("/");
        BACKSLASH = companion.encodeUtf8("\\");
        ANY_SLASH = companion.encodeUtf8("/\\");
        DOT = companion.encodeUtf8(".");
        DOT_DOT = companion.encodeUtf8("..");
    }

    public static final int commonCompareTo(@NotNull Path path, @NotNull Path other) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return path.getBytes().compareTo(other.getBytes());
    }

    public static final boolean commonEquals(@NotNull Path path, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        if ((obj instanceof Path) && Intrinsics.areEqual(((Path) obj).getBytes(), path.getBytes())) {
            return true;
        }
        return false;
    }

    public static final int commonHashCode(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        return path.getBytes().hashCode();
    }

    public static final boolean commonIsAbsolute(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        if (rootLength(path) != -1) {
            return true;
        }
        return false;
    }

    public static final boolean commonIsRelative(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        if (rootLength(path) == -1) {
            return true;
        }
        return false;
    }

    public static final boolean commonIsRoot(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        if (rootLength(path) == path.getBytes().size()) {
            return true;
        }
        return false;
    }

    @NotNull
    public static final String commonName(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        return path.nameBytes().utf8();
    }

    @NotNull
    public static final ByteString commonNameBytes(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        int indexOfLastSlash = getIndexOfLastSlash(path);
        if (indexOfLastSlash != -1) {
            return ByteString.substring$default(path.getBytes(), indexOfLastSlash + 1, 0, 2, null);
        }
        if (path.volumeLetter() != null && path.getBytes().size() == 2) {
            return ByteString.EMPTY;
        }
        return path.getBytes();
    }

    @NotNull
    public static final Path commonNormalized(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        return Path.INSTANCE.get(path.toString(), true);
    }

    @Nullable
    public static final Path commonParent(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        if (!Intrinsics.areEqual(path.getBytes(), DOT) && !Intrinsics.areEqual(path.getBytes(), SLASH) && !Intrinsics.areEqual(path.getBytes(), BACKSLASH) && !lastSegmentIsDotDot(path)) {
            int indexOfLastSlash = getIndexOfLastSlash(path);
            if (indexOfLastSlash == 2 && path.volumeLetter() != null) {
                if (path.getBytes().size() == 3) {
                    return null;
                }
                return new Path(ByteString.substring$default(path.getBytes(), 0, 3, 1, null));
            }
            if (indexOfLastSlash == 1 && path.getBytes().startsWith(BACKSLASH)) {
                return null;
            }
            if (indexOfLastSlash == -1 && path.volumeLetter() != null) {
                if (path.getBytes().size() == 2) {
                    return null;
                }
                return new Path(ByteString.substring$default(path.getBytes(), 0, 2, 1, null));
            }
            if (indexOfLastSlash == -1) {
                return new Path(DOT);
            }
            if (indexOfLastSlash == 0) {
                return new Path(ByteString.substring$default(path.getBytes(), 0, 1, 1, null));
            }
            return new Path(ByteString.substring$default(path.getBytes(), 0, indexOfLastSlash, 1, null));
        }
        return null;
    }

    @NotNull
    public static final Path commonRelativeTo(@NotNull Path path, @NotNull Path other) {
        boolean z16;
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (Intrinsics.areEqual(path.getRoot(), other.getRoot())) {
            List<ByteString> segmentsBytes = path.getSegmentsBytes();
            List<ByteString> segmentsBytes2 = other.getSegmentsBytes();
            int min = Math.min(segmentsBytes.size(), segmentsBytes2.size());
            int i3 = 0;
            while (i3 < min && Intrinsics.areEqual(segmentsBytes.get(i3), segmentsBytes2.get(i3))) {
                i3++;
            }
            if (i3 == min && path.getBytes().size() == other.getBytes().size()) {
                return Path.Companion.get$default(Path.INSTANCE, ".", false, 1, (Object) null);
            }
            if (segmentsBytes2.subList(i3, segmentsBytes2.size()).indexOf(DOT_DOT) == -1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                Buffer buffer = new Buffer();
                ByteString slash = getSlash(other);
                if (slash == null && (slash = getSlash(path)) == null) {
                    slash = toSlash(Path.DIRECTORY_SEPARATOR);
                }
                int size = segmentsBytes2.size();
                if (i3 < size) {
                    int i16 = i3;
                    do {
                        i16++;
                        buffer.write(DOT_DOT);
                        buffer.write(slash);
                    } while (i16 < size);
                }
                int size2 = segmentsBytes.size();
                if (i3 < size2) {
                    while (true) {
                        int i17 = i3 + 1;
                        buffer.write(segmentsBytes.get(i3));
                        buffer.write(slash);
                        if (i17 >= size2) {
                            break;
                        }
                        i3 = i17;
                    }
                }
                return toPath(buffer, false);
            }
            throw new IllegalArgumentException(("Impossible relative path to resolve: " + path + " and " + other).toString());
        }
        throw new IllegalArgumentException(("Paths of different roots cannot be relative to each other: " + path + " and " + other).toString());
    }

    @NotNull
    public static final Path commonResolve(@NotNull Path path, @NotNull String child, boolean z16) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(child, "child");
        return commonResolve(path, toPath(new Buffer().writeUtf8(child), false), z16);
    }

    @Nullable
    public static final Path commonRoot(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        int rootLength = rootLength(path);
        if (rootLength == -1) {
            return null;
        }
        return new Path(path.getBytes().substring(0, rootLength));
    }

    @NotNull
    public static final List<String> commonSegments(@NotNull Path path) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(path, "<this>");
        ArrayList arrayList = new ArrayList();
        int rootLength = rootLength(path);
        if (rootLength == -1) {
            rootLength = 0;
        } else if (rootLength < path.getBytes().size() && path.getBytes().getByte(rootLength) == ((byte) 92)) {
            rootLength++;
        }
        int size = path.getBytes().size();
        if (rootLength < size) {
            int i3 = rootLength;
            while (true) {
                int i16 = rootLength + 1;
                if (path.getBytes().getByte(rootLength) == ((byte) 47) || path.getBytes().getByte(rootLength) == ((byte) 92)) {
                    arrayList.add(path.getBytes().substring(i3, rootLength));
                    i3 = i16;
                }
                if (i16 >= size) {
                    break;
                }
                rootLength = i16;
            }
            rootLength = i3;
        }
        if (rootLength < path.getBytes().size()) {
            arrayList.add(path.getBytes().substring(rootLength, path.getBytes().size()));
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((ByteString) it.next()).utf8());
        }
        return arrayList2;
    }

    @NotNull
    public static final List<ByteString> commonSegmentsBytes(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        ArrayList arrayList = new ArrayList();
        int rootLength = rootLength(path);
        if (rootLength == -1) {
            rootLength = 0;
        } else if (rootLength < path.getBytes().size() && path.getBytes().getByte(rootLength) == ((byte) 92)) {
            rootLength++;
        }
        int size = path.getBytes().size();
        if (rootLength < size) {
            int i3 = rootLength;
            while (true) {
                int i16 = rootLength + 1;
                if (path.getBytes().getByte(rootLength) == ((byte) 47) || path.getBytes().getByte(rootLength) == ((byte) 92)) {
                    arrayList.add(path.getBytes().substring(i3, rootLength));
                    i3 = i16;
                }
                if (i16 >= size) {
                    break;
                }
                rootLength = i16;
            }
            rootLength = i3;
        }
        if (rootLength < path.getBytes().size()) {
            arrayList.add(path.getBytes().substring(rootLength, path.getBytes().size()));
        }
        return arrayList;
    }

    @NotNull
    public static final Path commonToPath(@NotNull String str, boolean z16) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return toPath(new Buffer().writeUtf8(str), z16);
    }

    @NotNull
    public static final String commonToString(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        return path.getBytes().utf8();
    }

    @Nullable
    public static final Character commonVolumeLetter(@NotNull Path path) {
        boolean z16;
        Intrinsics.checkNotNullParameter(path, "<this>");
        boolean z17 = false;
        if (ByteString.indexOf$default(path.getBytes(), SLASH, 0, 2, (Object) null) != -1 || path.getBytes().size() < 2 || path.getBytes().getByte(1) != ((byte) 58)) {
            return null;
        }
        char c16 = (char) path.getBytes().getByte(0);
        if ('a' <= c16 && c16 <= 'z') {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if ('A' <= c16 && c16 <= 'Z') {
                z17 = true;
            }
            if (!z17) {
                return null;
            }
        }
        return Character.valueOf(c16);
    }

    public static final int getIndexOfLastSlash(Path path) {
        int lastIndexOf$default = ByteString.lastIndexOf$default(path.getBytes(), SLASH, 0, 2, (Object) null);
        if (lastIndexOf$default != -1) {
            return lastIndexOf$default;
        }
        return ByteString.lastIndexOf$default(path.getBytes(), BACKSLASH, 0, 2, (Object) null);
    }

    public static final ByteString getSlash(Path path) {
        ByteString bytes = path.getBytes();
        ByteString byteString = SLASH;
        if (ByteString.indexOf$default(bytes, byteString, 0, 2, (Object) null) == -1) {
            ByteString bytes2 = path.getBytes();
            ByteString byteString2 = BACKSLASH;
            if (ByteString.indexOf$default(bytes2, byteString2, 0, 2, (Object) null) == -1) {
                return null;
            }
            return byteString2;
        }
        return byteString;
    }

    public static final boolean lastSegmentIsDotDot(Path path) {
        if (!path.getBytes().endsWith(DOT_DOT) || (path.getBytes().size() != 2 && !path.getBytes().rangeEquals(path.getBytes().size() - 3, SLASH, 0, 1) && !path.getBytes().rangeEquals(path.getBytes().size() - 3, BACKSLASH, 0, 1))) {
            return false;
        }
        return true;
    }

    public static final int rootLength(Path path) {
        boolean z16;
        if (path.getBytes().size() == 0) {
            return -1;
        }
        boolean z17 = false;
        if (path.getBytes().getByte(0) == ((byte) 47)) {
            return 1;
        }
        byte b16 = (byte) 92;
        if (path.getBytes().getByte(0) == b16) {
            if (path.getBytes().size() <= 2 || path.getBytes().getByte(1) != b16) {
                return 1;
            }
            int indexOf = path.getBytes().indexOf(BACKSLASH, 2);
            if (indexOf == -1) {
                return path.getBytes().size();
            }
            return indexOf;
        }
        if (path.getBytes().size() <= 2 || path.getBytes().getByte(1) != ((byte) 58) || path.getBytes().getByte(2) != b16) {
            return -1;
        }
        char c16 = (char) path.getBytes().getByte(0);
        if ('a' <= c16 && c16 <= 'z') {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if ('A' <= c16 && c16 <= 'Z') {
                z17 = true;
            }
            if (!z17) {
                return -1;
            }
            return 3;
        }
        return 3;
    }

    private static final boolean startsWithVolumeLetterAndColon(Buffer buffer, ByteString byteString) {
        boolean z16;
        boolean z17;
        if (!Intrinsics.areEqual(byteString, BACKSLASH) || buffer.size() < 2 || buffer.getByte(1L) != ((byte) 58)) {
            return false;
        }
        char c16 = (char) buffer.getByte(0L);
        if ('a' <= c16 && c16 <= 'z') {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if ('A' <= c16 && c16 <= 'Z') {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public static final Path toPath(@NotNull Buffer buffer, boolean z16) {
        ByteString byteString;
        boolean z17;
        boolean z18;
        ByteString readByteString;
        Object last;
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Buffer buffer2 = new Buffer();
        ByteString byteString2 = null;
        int i3 = 0;
        int i16 = 0;
        while (true) {
            if (!buffer.rangeEquals(0L, SLASH)) {
                byteString = BACKSLASH;
                if (!buffer.rangeEquals(0L, byteString)) {
                    break;
                }
            }
            byte readByte = buffer.readByte();
            if (byteString2 == null) {
                byteString2 = toSlash(readByte);
            }
            i16++;
        }
        if (i16 >= 2 && Intrinsics.areEqual(byteString2, byteString)) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            Intrinsics.checkNotNull(byteString2);
            buffer2.write(byteString2);
            buffer2.write(byteString2);
        } else if (i16 > 0) {
            Intrinsics.checkNotNull(byteString2);
            buffer2.write(byteString2);
        } else {
            long indexOfElement = buffer.indexOfElement(ANY_SLASH);
            if (byteString2 == null) {
                if (indexOfElement == -1) {
                    byteString2 = toSlash(Path.DIRECTORY_SEPARATOR);
                } else {
                    byteString2 = toSlash(buffer.getByte(indexOfElement));
                }
            }
            if (startsWithVolumeLetterAndColon(buffer, byteString2)) {
                if (indexOfElement == 2) {
                    buffer2.write(buffer, 3L);
                } else {
                    buffer2.write(buffer, 2L);
                }
            }
        }
        if (buffer2.size() > 0) {
            z18 = true;
        } else {
            z18 = false;
        }
        ArrayList arrayList = new ArrayList();
        while (!buffer.exhausted()) {
            long indexOfElement2 = buffer.indexOfElement(ANY_SLASH);
            if (indexOfElement2 == -1) {
                readByteString = buffer.readByteString();
            } else {
                readByteString = buffer.readByteString(indexOfElement2);
                buffer.readByte();
            }
            ByteString byteString3 = DOT_DOT;
            if (Intrinsics.areEqual(readByteString, byteString3)) {
                if (!z18 || !arrayList.isEmpty()) {
                    if (z16) {
                        if (!z18) {
                            if (!arrayList.isEmpty()) {
                                last = CollectionsKt___CollectionsKt.last((List<? extends Object>) arrayList);
                                if (Intrinsics.areEqual(last, byteString3)) {
                                }
                            }
                        }
                        if (!z17 || arrayList.size() != 1) {
                            CollectionsKt__MutableCollectionsKt.removeLastOrNull(arrayList);
                        }
                    }
                    arrayList.add(readByteString);
                }
            } else if (!Intrinsics.areEqual(readByteString, DOT) && !Intrinsics.areEqual(readByteString, ByteString.EMPTY)) {
                arrayList.add(readByteString);
            }
        }
        int size = arrayList.size();
        if (size > 0) {
            while (true) {
                int i17 = i3 + 1;
                if (i3 > 0) {
                    buffer2.write(byteString2);
                }
                buffer2.write((ByteString) arrayList.get(i3));
                if (i17 >= size) {
                    break;
                }
                i3 = i17;
            }
        }
        if (buffer2.size() == 0) {
            buffer2.write(DOT);
        }
        return new Path(buffer2.readByteString());
    }

    public static final ByteString toSlash(String str) {
        if (Intrinsics.areEqual(str, "/")) {
            return SLASH;
        }
        if (Intrinsics.areEqual(str, "\\")) {
            return BACKSLASH;
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("not a directory separator: ", str));
    }

    @NotNull
    public static final Path commonResolve(@NotNull Path path, @NotNull ByteString child, boolean z16) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(child, "child");
        return commonResolve(path, toPath(new Buffer().write(child), false), z16);
    }

    private static final ByteString toSlash(byte b16) {
        if (b16 == 47) {
            return SLASH;
        }
        if (b16 == 92) {
            return BACKSLASH;
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("not a directory separator: ", Byte.valueOf(b16)));
    }

    @NotNull
    public static final Path commonResolve(@NotNull Path path, @NotNull Buffer child, boolean z16) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(child, "child");
        return commonResolve(path, toPath(child, false), z16);
    }

    @NotNull
    public static final Path commonResolve(@NotNull Path path, @NotNull Path child, boolean z16) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(child, "child");
        if (child.isAbsolute() || child.volumeLetter() != null) {
            return child;
        }
        ByteString slash = getSlash(path);
        if (slash == null && (slash = getSlash(child)) == null) {
            slash = toSlash(Path.DIRECTORY_SEPARATOR);
        }
        Buffer buffer = new Buffer();
        buffer.write(path.getBytes());
        if (buffer.size() > 0) {
            buffer.write(slash);
        }
        buffer.write(child.getBytes());
        return toPath(buffer, z16);
    }

    private static /* synthetic */ void getANY_SLASH$annotations() {
    }

    private static /* synthetic */ void getBACKSLASH$annotations() {
    }

    private static /* synthetic */ void getDOT$annotations() {
    }

    private static /* synthetic */ void getDOT_DOT$annotations() {
    }

    private static /* synthetic */ void getSLASH$annotations() {
    }
}
